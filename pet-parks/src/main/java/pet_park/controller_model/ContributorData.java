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
public class ContributorData {
    private Long contributorId;
    private String contributorName;
    private String contributorEmail;
    private Set<PetParkResponse> petParks = new HashSet<>();

    public ContributorData(Contributor contributor) {
        contributorId = contributor.getContributorId();
        contributorName = contributor.getContributorName();
        contributorEmail = contributor.getContributorEmail();

        for (PetPark petPark : contributor.getPetParks()) {
            petParks.add(new PetParkResponse(petPark));
        }
    }

    @Data
    @NoArgsConstructor
    static class PetParkResponse {
        private Long petParkId;
        private String parkName;
        private String directions;
        private String stateOrProvidence;
        private String country;
        private GeoLocation geoLocation;
        private Set<String> amenities = new HashSet<>();

        public PetParkResponse(PetPark petPark) {
            petParkId = petPark.getPetParkId();
            parkName = petPark.getParkName();
            directions = petPark.getDirections();
            stateOrProvidence = petPark.getStateOrProvidence();
            country = petPark.getCountry();
            geoLocation = petPark.getGeoLocation();

            for (Amenity amenity : petPark.getAmenities()) {
                amenities.add(amenity.getAmenityName());
            }
        }
    }
}
