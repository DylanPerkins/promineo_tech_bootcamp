package dog_rescue.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dog_rescue.controller.model.LocationData;
import dog_rescue.dao.LocationDao;
import dog_rescue.entity.Location;

@Service
public class RescueService {

    @Autowired
    private LocationDao locationDao;

    // Main Methods

    @Transactional(readOnly = false)
    public LocationData saveLocation(LocationData locationData) {
        Location location = locationData.toLocation();

        Location savedLocation = locationDao.save(location);

        return new LocationData(savedLocation);
    }

    @Transactional(readOnly = true)
    public LocationData retrieveLocationById(Long locationId) {
        Location location = findLocationById(locationId);

        return new LocationData(location);
    }

    // Helper Methods

    private Location findLocationById(Long locationId) {
        return locationDao.findById(locationId)
                .orElseThrow(() -> new NoSuchElementException("Location ID=" + locationId + " not found"));
    }

}
