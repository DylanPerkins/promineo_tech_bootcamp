package dog_rescue.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping("/location/{locationId}")
    @ResponseStatus(HttpStatus.OK)
    public LocationData retrieveLocation(@PathVariable Long locationId) {
        log.info("Getting location: {}", locationId);
        return rescueService.retrieveLocationById(locationId);
    }

    @GetMapping("/location")
    @ResponseStatus(HttpStatus.OK)
    public List<LocationData> retrieveAllLocations() {
        log.info("Getting all locations");
        return rescueService.retrieveAllLocations();
    }

    @PutMapping("/location/{locationId}")
    @ResponseStatus(HttpStatus.OK)
    public LocationData updateLocation(@PathVariable Long locationId, @RequestBody LocationData locationData) {
        locationData.setLocationId(locationId);
        log.info("Updating location: {}", locationId);
        return rescueService.saveLocation(locationData);
    }

    @DeleteMapping("/location/{locationId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Map<String, String> deleteLocation(@PathVariable Long locationId) {
        log.info("Deleting location: {}", locationId);
        rescueService.deleteLocationById(locationId);

        return Map.of("message", "Location deleted successfully");
    }
}
