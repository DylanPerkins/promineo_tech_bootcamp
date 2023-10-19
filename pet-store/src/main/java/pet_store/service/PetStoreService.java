package pet_store.service;

import java.util.NoSuchElementException;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pet_store.controller.model.PetStoreData;
import pet_store.dao.PetStoreDao;
import pet_store.entity.PetStore;

@Service
public class PetStoreService {
    @Autowired
    private PetStoreDao petStoreDao;

    // Main methods
    public PetStoreData savePetStore(PetStoreData petStoreData) {

        PetStore petStore = findOrCreatePetStore(petStoreData.getPetStoreId());

        copyPetStoreFields(petStore, petStoreData);

        PetStore savedPetStore = petStoreDao.save(petStore);

        return new PetStoreData(savedPetStore);
    }

    // Sub-methods

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
