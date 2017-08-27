package zx_ventures.com.beercrawl.data.source.remote.dto.geocode;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import zx_ventures.com.beercrawl.data.LocationMap;

/**
 * Created by ivo on 25/08/17.
 */

public class ResultDto {
    @SerializedName("results")
    private List<LocationMap> results;

    public List<LocationMap> getResults() {
        return results;
    }

    public void setResults(List<LocationMap> results) {
        this.results = results;
    }
}
