package zx_ventures.com.beercrawl.data.source.remote.dto.geocode;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ivo on 25/08/17.
 */

public class Location {
    @SerializedName("lat")
    @Expose
    private Double lat;
    @SerializedName("lng")
    @Expose
    private Double lng;

    /**
     * @return The lat
     */
    public Double getLat() {
        return lat;
    }

    /**
     * @param lat The lat
     */
    public void setLat(Double lat) {
        this.lat = lat;
    }

    /**
     * @return The lng
     */
    public Double getLng() {
        return lng;
    }

    /**
     * @param lng The lng
     */
    public void setLng(Double lng) {
        this.lng = lng;
    }

}
