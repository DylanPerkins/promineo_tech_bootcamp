package pet_park.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
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
}
