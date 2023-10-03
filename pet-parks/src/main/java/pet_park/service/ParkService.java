package pet_park.service;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pet_park.controller_model.ContributorData;
import pet_park.dao.ContributorDao;
import pet_park.entity.Contributor;

@Service
public class ParkService {

    @Autowired
    private ContributorDao contributorDao;

    @Transactional(readOnly = false)
    public ContributorData saveContributor(ContributorData contributorData) {
        Long contributorId = contributorData.getContributorId();
        Contributor contributor = findOrCreateContributor(contributorId);

        setFieldsInContributor(contributor, contributorData);
        return new ContributorData(contributorDao.save(contributor));
    }

    private void setFieldsInContributor(Contributor contributor, ContributorData contributorData) {
        contributor.setContributorName(contributorData.getContributorName());
        contributor.setContributorEmail(contributorData.getContributorEmail());
    }

    private Contributor findOrCreateContributor(Long contributorId) {
        Contributor contributor;

        if (Objects.isNull(contributorId)) {
            contributor = new Contributor();
        } else {
            contributor = findContributorById(contributorId);
        }

        return contributor;
    }

    private Contributor findContributorById(Long contributorId) {
        return contributorDao.findById(contributorId)
                .orElseThrow(() -> new NoSuchElementException("Contributor with ID= " + contributorId + " was not found"));
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
    public ContributorData retrieveContributorById(Long contributorId) {
        Contributor contributor = findContributorById(contributorId);
        return new ContributorData(contributor);
    }
}
