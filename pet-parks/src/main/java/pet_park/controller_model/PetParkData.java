package pet_park.controller_model;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;
import lombok.NoArgsConstructor;
import pet_park.entity.Amenity;
import pet_park.entity.Contributor;
import pet_park.entity.GeoLocation;
import pet_park.entity.PetPark;

@Data
@NoArgsConstructor
public class PetParkData {
    private long petParkId;
    private String parkName;
    private String directions;
    private String stateOrProvidence;
    private String country;
    private GeoLocation geoLocation;
    private PetParkContributor contributor;
    private Set<String> amenities = new HashSet<>();

    public PetParkData(PetPark petPark) {
        petParkId = petPark.getPetParkId();
        parkName = petPark.getParkName();
        directions = petPark.getDirections();
        stateOrProvidence = petPark.getStateOrProvidence();
        country = petPark.getCountry();
        geoLocation = petPark.getGeoLocation();
        contributor = new PetParkContributor(petPark.getContributor());

        for (Amenity amenity : petPark.getAmenities()) {
            amenities.add(amenity.getAmenity());
        }
    }

    @Data
    @NoArgsConstructor
    public static class PetParkContributor {
        private long contributorId;
        private String contributorName;
        private String contributorEmail;

        public PetParkContributor(Contributor contributor) {
            contributorId = contributor.getContributorId();
            contributorName = contributor.getContributorName();
            contributorEmail = contributor.getContributorEmail();
        }
    }
}
