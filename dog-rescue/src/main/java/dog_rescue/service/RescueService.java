package dog_rescue.service;

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

    @Transactional(readOnly = false)
    public LocationData saveLocation(LocationData locationData) {
        Location location = locationData.toLocation();

        Location savedLocation = locationDao.save(location);

        return new LocationData(savedLocation);
    }

}
