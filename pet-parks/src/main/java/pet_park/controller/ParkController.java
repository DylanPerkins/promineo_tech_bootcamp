package pet_park.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import pet_park.controller_model.ContributorData;
import pet_park.service.ParkService;

@RestController
@RequestMapping("/pet_park")
@Slf4j
public class ParkController {
    @Autowired
    private ParkService parkService;

    @PostMapping("/contributor")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ContributorData insertContributor(@RequestBody ContributorData contributorData) {
        log.info("Creating contributor: {}", contributorData);
        return parkService.saveContributor(contributorData);
    }

    @PutMapping("/contributor/{contributorId}")
    public ContributorData updateContributor(@PathVariable Long contributorId,
            @RequestBody ContributorData contributorData) {
        contributorData.setContributorId(contributorId);
        log.info("Updating contributor {}", contributorData);

        return parkService.saveContributor(contributorData);
    }

    @GetMapping("/contributor")
    public List<ContributorData> retrieveAllContributors() {
        log.info("Retrieve all contributors called.");
        return parkService.retrieveAllContributors();
    }

    @GetMapping("/contributor/{contributorId}")
    public ContributorData retrieveContributorById(@PathVariable Long contributorId) {
        log.info("Retrieving contributor with ID={}", contributorId);
        return parkService.retrieveContributorById(contributorId);

    }
}
