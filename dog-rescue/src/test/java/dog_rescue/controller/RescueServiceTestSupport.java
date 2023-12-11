package dog_rescue.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.jdbc.JdbcTestUtils;

import dog_rescue.controller.model.LocationData;
import dog_rescue.entity.Location;

public class RescueServiceTestSupport {

    private static final String DOG_TABLE = "dog";

    private static final String DOG_BREED_TABLE = "dog_breed";

    private static final String BREED_TABLE = "breed";

    private static final String LOCATION_TABLE = "location";

    private static final String INSERT_DOG_1_SQL = """
            INSERT INTO dog
            (location_id, dog_name, age, color)
            VALUES(1, 'Alex', 4, 'Brown and White');
                """;

    private static final String INSERT_DOG_2_SQL = """
            INSERT INTO dog
            (location_id, dog_name, age, color)
            VALUES(1, 'jeff', 8, 'White');
                """;

    private static final String INSERT_BREEDS_1_SQL = """
            insert into dog_breed
            (dog_id, breed_id)
            values (1, 3), (1, 13);
                """;

    private static final String INSERT_BREEDS_2_SQL = """
            insert into dog_breed
            (dog_id, breed_id)
            values (2, 6), (2, 35);
                """;

    // @formatter:off
    private LocationData insertAddress1 = new LocationData(
        1L,
        "Dog Rescue",
        "123 Main St",
        "Anytown",
        "CA",
        "12345",
        "555-555-5555"
    );

    private LocationData insertAddress2 = new LocationData(
        2L,
        "Downtown Rescue",
        "41 Grove St",
        "Greenland",
        "CA",
        "38112",
        "222-333-4444"
    );

    private LocationData updateAddress1 = new LocationData(
        1L,
        "Greatest Dog Rescue",
        "2431 East Street",
        "Goodtown",
        "CA",
        "26267",
        "235-153-8423"
    );

    // @formatter:on

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private RescueController rescueController;

    protected LocationData buildInsertLocation(int which) {
        return which == 1 ? insertAddress1 : insertAddress2;
    }

    protected int rowsInLocationTable() {
        return JdbcTestUtils.countRowsInTable(jdbcTemplate, LOCATION_TABLE);
    }

    protected LocationData insertLocation(LocationData locationData) {
        Location location = locationData.toLocation();
        LocationData clone = new LocationData(location);

        clone.setLocationId(null);

        return rescueController.createLocation(clone);
    }

    protected LocationData retrieveLocation(Long locationId) {
        return rescueController.retrieveLocation(locationId);
    }

    protected List<LocationData> insertTwoLocations() {
        LocationData location1 = insertLocation(buildInsertLocation(1));
        LocationData location2 = insertLocation(buildInsertLocation(2));

        return List.of(location1, location2);
    }

    protected List<LocationData> retrieveAllLocations() {
        return rescueController.retrieveAllLocations();
    }

    protected LocationData updateLocation(LocationData locationData) {
        return rescueController.updateLocation(locationData.getLocationId(), locationData);
    }

    protected LocationData buildUpdateLocation() {
        return updateAddress1;
    }

    /////////////

    protected void deleteLocation(Long locationId) {
        rescueController.deleteLocation(locationId);
    }

    protected int rowsInBreedTable() {
        return JdbcTestUtils.countRowsInTable(jdbcTemplate, BREED_TABLE);
    }

    protected int rowsInDogBreedTable() {
        return JdbcTestUtils.countRowsInTable(jdbcTemplate, DOG_BREED_TABLE);
    }

    protected int rowsInDogTable() {
        return JdbcTestUtils.countRowsInTable(jdbcTemplate, DOG_TABLE);
    }

    protected void insertDog(int which) {
        String dogSql = which == 1 ? INSERT_DOG_1_SQL : INSERT_DOG_2_SQL;
        String breedSql = which == 1 ? INSERT_BREEDS_1_SQL : INSERT_BREEDS_2_SQL;

        jdbcTemplate.update(dogSql);
        jdbcTemplate.update(breedSql);
    }

}
