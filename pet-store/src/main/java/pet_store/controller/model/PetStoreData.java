package pet_store.controller.model;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;
import lombok.NoArgsConstructor;
import pet_store.entity.Customer;
import pet_store.entity.Employee;
import pet_store.entity.PetStore;

@Data
@NoArgsConstructor
public class PetStoreData {
    private Long petStoreId;
    private String petStoreName;
    private String petStoreAddress;
    private String petStoreCity;
    private String petStoreState;
    private Integer petStoreZip;
    private String petStorePhone;
    private Set<PetStoreCustomer> customers = new HashSet<>();
    private Set<PetStoreEmployee> employees = new HashSet<>();

    // Constructor
    public PetStoreData(PetStore petStore) {
        petStoreId = petStore.getPetStoreId();
        petStoreName = petStore.getPetStoreName();
        petStoreAddress = petStore.getPetStoreAddress();
        petStoreCity = petStore.getPetStoreCity();
        petStoreState = petStore.getPetStoreState();
        petStoreZip = petStore.getPetStoreZip();
        petStorePhone = petStore.getPetStorePhone();

        for (Customer customer : petStore.getCustomers()) {
            customers.add(new PetStoreCustomer(customer));
        }

        for (Employee employee : petStore.getEmployees()) {
            employees.add(new PetStoreEmployee(employee));
        }
    }
}
