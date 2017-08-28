package zx_ventures.com.beercrawl.data;

import com.google.gson.annotations.SerializedName;

import zx_ventures.com.beercrawl.data.source.remote.dto.geocode.Geometry;

/**
 * Created by ivo on 24/08/17.
 */

public class LocationMap {
    @SerializedName("formatted_address")
    private String formattedAddress;

    @SerializedName("geometry")
    private Geometry geometry;

    public String getFormattedAddress() {
        return formattedAddress;
    }

    public void setFormattedAddress(String formattedAddress) {
        this.formattedAddress = formattedAddress;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }
}