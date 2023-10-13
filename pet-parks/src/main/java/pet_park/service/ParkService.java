package pet_park.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pet_park.controller_model.ContributorData;
import pet_park.controller_model.PetParkData;
import pet_park.dao.AmenityDao;
import pet_park.dao.ContributorDao;
import pet_park.dao.PetParkDao;
import pet_park.entity.Contributor;
import pet_park.entity.PetPark;
import pet_park.entity.Amenity;

@Service
public class ParkService {

    @Autowired
    private ContributorDao contributorDao;

    @Autowired
    private AmenityDao amenityDao;

    @Autowired
    private PetParkDao petParkDao;

    @Transactional(readOnly = false)
    public ContributorData saveContributor(ContributorData contributorData) {
        Long contributorId = contributorData.getContributorId();
        Contributor contributor = findOrCreateContributor(contributorId, contributorData.getContributorEmail());

        setFieldsInContributor(contributor, contributorData);
        return new ContributorData(contributorDao.save(contributor));
    }

    private void setFieldsInContributor(Contributor contributor, ContributorData contributorData) {
        contributor.setContributorName(contributorData.getContributorName());
        contributor.setContributorEmail(contributorData.getContributorEmail());
    }

    private Contributor findOrCreateContributor(Long contributorId, String contributorEmail) {
        Contributor contributor;

        if (Objects.isNull(contributorId)) {
            Optional<Contributor> optionalContributor = contributorDao.findByContributorEmail(contributorEmail);

            if (optionalContributor.isPresent()) {
                throw new DuplicateKeyException(contributorEmail + " already exists in the database");
            }

            contributor = new Contributor();
        } else {
            contributor = findContributorById(contributorId);
        }

        return contributor;
    }

    private Contributor findContributorById(Long contributorId) {
        return contributorDao.findById(contributorId)
                .orElseThrow(
                        () -> new NoSuchElementException("Contributor with ID= " + contributorId + " was not found"));
    }

    // Retrieves all of the contributors in the database
    @Transactional(readOnly = true)
    public List<ContributorData> retrieveAllContributors() {
        return contributorDao.findAll()
                .stream()
                .map(ContributorData::new)
                .toList();
    }

    // Retrieves a single contributor from the database using an ID
    @Transactional(readOnly = true)
    public ContributorData retrieveContributorById(Long contributorId) {
        Contributor contributor = findContributorById(contributorId);
        return new ContributorData(contributor);
    }

    // Deletes a single contributor from the database using an ID
    @Transactional(readOnly = false)
    public void deleteContributorById(Long contributorId) {
        Contributor contributor = findContributorById(contributorId);
        contributorDao.delete(contributor);
    }

    // Saves a pet park to the database
    @Transactional(readOnly = false)
    public PetParkData savePetPark(Long contributorId, PetParkData petParkData) {
        Contributor contributor = findContributorById(contributorId);

        Set<Amenity> amenities = amenityDao.findAllByAmenityIn(petParkData.getAmenities());

        PetPark petPark = findOrCreatePetPark(petParkData.getPetParkId());

        setPetParkFields(petPark, petParkData);

        petPark.setContributor(contributor);
        contributor.getPetParks().add(petPark);

        for (Amenity amenity : amenities) {
            amenity.getPetParks().add(petPark);
            petPark.getAmenities().add(amenity);
        }

        PetPark dbPetPark = petParkDao.save(petPark);

        return new PetParkData(dbPetPark);
    }

    private void setPetParkFields(PetPark petPark, PetParkData petParkData) {
        petPark.setCountry(petParkData.getCountry());
        petPark.setDirections(petParkData.getDirections());
        petPark.setGeoLocation(petParkData.getGeoLocation());
        petPark.setParkName(petParkData.getParkName());
        petPark.setPetParkId(petParkData.getPetParkId());
        petPark.setStateOrProvidence(petParkData.getStateOrProvidence());
    }

    private PetPark findOrCreatePetPark(long petParkId) {
        PetPark petPark;

        if (Objects.isNull(petParkId) || petParkId == 0) {
            petPark = new PetPark();
        } else {
            petPark = findPetParkById(petParkId);
        }

        return petPark;
    }

    private PetPark findPetParkById(long petParkId) {
        return petParkDao.findById(petParkId)
                .orElseThrow(() -> new NoSuchElementException("Pet Park with ID=" + petParkId + " was not found"));
    }

    @Transactional(readOnly = true)
    public PetParkData retrievePetParkById(Long contributorId, Long parkId) {
        findContributorById(contributorId);

        PetPark petPark = findPetParkById(parkId);

        if(petPark.getContributor().getContributorId() != contributorId) {
            throw new IllegalStateException("Pet Park with ID=" + parkId + " does not belong to contributor with ID=" + contributorId);
        }

        return new PetParkData(petPark);
    }
}
