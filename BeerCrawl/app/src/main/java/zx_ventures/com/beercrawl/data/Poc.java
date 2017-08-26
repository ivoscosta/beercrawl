package zx_ventures.com.beercrawl.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ivo on 24/08/17.
 */

public class Poc {
    @SerializedName("results")
    private List<Results> results;
}

final class Results {
    @SerializedName("formatted_address")
    private String formattedAddress;

    @SerializedName("geometry")
    private Geometry geometry;
}

class Geometry {
    @SerializedName("location")
    private LocationGeocoder location;
}

class LocationGeocoder {
    @SerializedName("lat")
    private Double lat;

    @SerializedName("lng")
    private Double lng;
}