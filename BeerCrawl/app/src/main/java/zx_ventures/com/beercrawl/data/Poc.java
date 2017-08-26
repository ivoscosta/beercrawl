package zx_ventures.com.beercrawl.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import zx_ventures.com.beercrawl.data.geocode.Result;

/**
 * Created by ivo on 24/08/17.
 */

public class Poc {
    @SerializedName("results")
    private List<Result> results;

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }
}