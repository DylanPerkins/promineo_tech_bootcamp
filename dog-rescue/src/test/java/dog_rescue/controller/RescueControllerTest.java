package dog_rescue.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;

import dog_rescue.DogRescueApplication;
import dog_rescue.controller.model.LocationData;

@SpringBootTest(webEnvironment = WebEnvironment.NONE, classes = DogRescueApplication.class)
@ActiveProfiles("test")
@Sql(scripts = { "classpath:schema.sql", "classpath:data.sql" })
@SqlConfig(encoding = "utf-8")
class RescueControllerTest extends RescueServiceTestSupport {

    @Test
    void testInsertLocation() {
        // Given: A Location Request
        LocationData request = buildInsertLocation(1);
        LocationData expected = buildInsertLocation(1);

        // When: The location is added to the location table
        LocationData actual = insertLocation(request);

        // Then: The location returned is what we expected
        assertThat(actual).isEqualTo(expected);

        // And: There is a new row in the location table
        assertThat(rowsInLocationTable()).isOne();
    }

    @Test
    void testRetrieveLocation() {
        // Given: A Location
        LocationData location = insertLocation(buildInsertLocation(1));
        LocationData expected = buildInsertLocation(1);

        // When: The location is retrieved from the location table via the location ID
        LocationData actual = retrieveLocation(location.getLocationId());

        // Then: The location returned is what we expected
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testRetrieveAllLocations() {
        // Given: Two Locations
        List<LocationData> expected = insertTwoLocations();

        // When: All locations are retrieved from the location table
        List<LocationData> actual = retrieveAllLocations();

        // Then: The locations returned are what we expected
        assertThat(actual).isEqualTo(expected);

    }

    @Test
    void testUpdateLocation() {
        // Given: A Location
        insertLocation(buildInsertLocation(1));
        LocationData expected = buildUpdateLocation();

        // When: The location is updated in the location table
        LocationData actual = updateLocation(expected);

        // Then: The location returned is what we expected
        assertThat(actual).isEqualTo(expected);

        // And: There is one row in the location table
        assertThat(rowsInLocationTable()).isOne();
    }

}
