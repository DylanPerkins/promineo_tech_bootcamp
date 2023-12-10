package pet_store.service;

import java.util.NoSuchElementException;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pet_store.controller.model.PetStoreCustomer;
import pet_store.controller.model.PetStoreData;
import pet_store.controller.model.PetStoreEmployee;
import pet_store.dao.CustomerDao;
import pet_store.dao.EmployeeDao;
import pet_store.dao.PetStoreDao;
import pet_store.entity.Customer;
import pet_store.entity.Employee;
import pet_store.entity.PetStore;

@Service
public class PetStoreService {
    @Autowired
    private PetStoreDao petStoreDao;

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private CustomerDao customerDao;

    // Main Methods

    public PetStoreData savePetStore(PetStoreData petStoreData) {

        PetStore petStore = findOrCreatePetStore(petStoreData.getPetStoreId());

        copyPetStoreFields(petStore, petStoreData);

        PetStore savedPetStore = petStoreDao.save(petStore);

        return new PetStoreData(savedPetStore);
    }

    @Transactional(readOnly = false)
    public PetStoreEmployee saveEmployee(Long petStoreId, PetStoreEmployee petStoreEmployee) {
        PetStore petStore = findPetStoreById(petStoreId);
        Long employeeId = petStoreEmployee.getEmployeeId();
        Employee employee = findOrCreateEmployee(petStoreId, employeeId);

        copyEmployeeFields(employee, petStoreEmployee);
        employee.setPetStore(petStore);

        petStore.getEmployees().add(employee);

        Employee savedEmployee = employeeDao.save(employee);

        return new PetStoreEmployee(savedEmployee);
    }

    @Transactional(readOnly = false)
    public PetStoreCustomer saveCustomer(Long petStoreId, PetStoreCustomer petStoreCustomer) {
        PetStore petStore = findPetStoreById(petStoreId);
        Long customerId = petStoreCustomer.getCustomerId();
        Customer customer = findOrCreateCustomer(petStoreId, customerId);

        copyCustomerFields(customer, petStoreCustomer);

        petStore.getCustomers().add(customer);

        Customer savedCustomer = customerDao.save(customer);

        return new PetStoreCustomer(savedCustomer);
    }

    // Helper Methods

    private Customer findOrCreateCustomer(Long petStoreId, Long customerId) {
        Customer customer;

        if (Objects.isNull(customerId)) {
            customer = new Customer();
            customer.getPetStores().add(findPetStoreById(petStoreId));
        } else {
            customer = findCustomerById(petStoreId, customerId);
        }

        return customer;
    }

    private Customer findCustomerById(Long petStoreId, Long customerId) {
        Customer customer = customerDao.findById(customerId)
                .orElseThrow(() -> new NoSuchElementException("Customer with ID=" + customerId + " was not found"));

        for (PetStore petStore : customer.getPetStores()) {
            if (petStore.getPetStoreId().equals(petStoreId)) {
                return customer;
            } else {
                throw new IllegalArgumentException(
                        "Customer with ID=" + customerId + " does not belong to Pet Store with ID=" + petStoreId);
            }
        }

        return customer;
    }

    private void copyCustomerFields(Customer customer, PetStoreCustomer petStoreCustomer) {
        customer.setCustomerId(petStoreCustomer.getCustomerId());
        customer.setCustomerFirstName(petStoreCustomer.getCustomerFirstName());
        customer.setCustomerLastName(petStoreCustomer.getCustomerLastName());
        customer.setCustomerEmail(petStoreCustomer.getCustomerEmail());
    }

    private Employee findEmployeeById(Long petStoreId, Long employeeId) {
        Employee employee = employeeDao.findById(employeeId)
                .orElseThrow(() -> new NoSuchElementException("Employee with ID=" + employeeId + " was not found"));

        if (!employee.getPetStore().getPetStoreId().equals(petStoreId)) {
            throw new IllegalArgumentException(
                    "Employee with ID=" + employeeId + " does not belong to Pet Store with ID=" + petStoreId);
        } else {
            return employee;
        }
    }

    private Employee findOrCreateEmployee(Long petStoreId, Long employeeId) {
        Employee employee;

        if (Objects.isNull(employeeId)) {
            employee = new Employee();
            employee.setPetStore(findPetStoreById(petStoreId));
        } else {
            employee = findEmployeeById(petStoreId, employeeId);
        }

        return employee;
    }

    private void copyEmployeeFields(Employee employee, PetStoreEmployee petStoreEmployee) {
        employee.setEmployeeId(petStoreEmployee.getEmployeeId());
        employee.setEmployeeFirstName(petStoreEmployee.getEmployeeFirstName());
        employee.setEmployeeLastName(petStoreEmployee.getEmployeeLastName());
        employee.setEmployeePhone(petStoreEmployee.getEmployeePhone());
        employee.setEmployeeJobTitle(petStoreEmployee.getEmployeeJobTitle());
    }

    private void copyPetStoreFields(PetStore petStore, PetStoreData petStoreData) {
        petStore.setPetStoreId(petStoreData.getPetStoreId());
        petStore.setPetStoreName(petStoreData.getPetStoreName());
        petStore.setPetStoreAddress(petStoreData.getPetStoreAddress());
        petStore.setPetStoreCity(petStoreData.getPetStoreCity());
        petStore.setPetStoreState(petStoreData.getPetStoreState());
        petStore.setPetStoreZip(petStoreData.getPetStoreZip());
        petStore.setPetStorePhone(petStoreData.getPetStorePhone());
    }

    private PetStore findOrCreatePetStore(Long petStoreId) {
        PetStore petStore;

        if (Objects.isNull(petStoreId) || petStoreId == 0) {
            petStore = new PetStore();
        } else {
            petStore = findPetStoreById(petStoreId);
        }

        return petStore;
    }

    private PetStore findPetStoreById(Long petStoreId) {
        return petStoreDao.findById(petStoreId)
                .orElseThrow(() -> new NoSuchElementException("Pet Store with ID=" + petStoreId + " was not found"));
    }
}
