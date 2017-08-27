package zx_ventures.com.beercrawl.data.source.remote.dto.geocode;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by krrishnaaaa on Dec 06, 2015
 */
public class Geometry {
    @SerializedName("location")
    @Expose
    private Location location;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
