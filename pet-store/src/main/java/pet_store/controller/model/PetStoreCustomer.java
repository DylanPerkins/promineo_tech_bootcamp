package pet_store.controller.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import pet_store.entity.Customer;

@Data
@NoArgsConstructor
public class PetStoreCustomer {
    private Long customerId;
    private String customerFirstName;
    private String customerLastName;
    private String customerEmail;

    // Constructor
    public PetStoreCustomer(Customer customer) {
        customerId = customer.getCustomerId();
        customerFirstName = customer.getCustomerFirstName();
        customerLastName = customer.getCustomerLastName();
        customerEmail = customer.getCustomerEmail();
    }
}
