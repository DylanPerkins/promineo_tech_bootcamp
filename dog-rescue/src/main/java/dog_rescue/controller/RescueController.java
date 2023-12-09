package dog_rescue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import dog_rescue.controller.model.LocationData;
import dog_rescue.service.RescueService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/dog_rescue")
@Slf4j
public class RescueController {

    @Autowired
    private RescueService rescueService;

    @PostMapping("/location")
    @ResponseStatus(HttpStatus.CREATED)
    public LocationData createLocation(@RequestBody LocationData locationData) {
        log.info("Creating location: {}", locationData);
        return rescueService.saveLocation(locationData);
    }
}
