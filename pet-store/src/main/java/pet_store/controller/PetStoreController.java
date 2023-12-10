package pet_store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import pet_store.controller.model.PetStoreCustomer;
import pet_store.controller.model.PetStoreData;
import pet_store.controller.model.PetStoreEmployee;
import pet_store.service.PetStoreService;

@RestController
@RequestMapping("/pet-store")
@Slf4j
public class PetStoreController {

    @Autowired
    PetStoreService petStoreService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public PetStoreData insertPetStore(@RequestBody PetStoreData petStoreData) {
        log.info("Creating pet store: {}", petStoreData);
        return petStoreService.savePetStore(petStoreData);
    }

    @PutMapping("/{petStoreId}")
    public PetStoreData updatePetStore(@PathVariable Long petStoreId, @RequestBody PetStoreData petStoreData) {
        petStoreData.setPetStoreId(petStoreId);
        log.info("Updating pet store {}", petStoreData);

        return petStoreService.savePetStore(petStoreData);
    }

    @PostMapping("/{petStoreId}/employee")
    @ResponseStatus(code = HttpStatus.CREATED)
    public PetStoreEmployee insertEmployee(@PathVariable Long petStoreId, @RequestBody PetStoreEmployee petStoreEmployee) {
        log.info("Creating employee: {}", petStoreEmployee);
        return petStoreService.saveEmployee(petStoreId, petStoreEmployee);
    }

    @PostMapping("/{petStoreId}/customer")
    @ResponseStatus(code = HttpStatus.CREATED)
    public PetStoreCustomer insertCustomer(@PathVariable Long petStoreId, @RequestBody PetStoreCustomer petStoreCustomer) {
        log.info("Creating customer: {}", petStoreCustomer);
        return petStoreService.saveCustomer(petStoreId, petStoreCustomer);
    }
    
}
