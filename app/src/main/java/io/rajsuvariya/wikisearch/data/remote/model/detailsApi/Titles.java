
package io.rajsuvariya.wikisearch.data.remote.model.detailsApi;

import android.arch.persistence.room.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity
public class Titles {

    @SerializedName("canonical")
    @Expose
    private String canonical;
    @SerializedName("normalized")
    @Expose
    private String normalized;
    @SerializedName("display")
    @Expose
    private String display;

    public String getCanonical() {
        return canonical;
    }

    public void setCanonical(String canonical) {
        this.canonical = canonical;
    }

    public String getNormalized() {
        return normalized;
    }

    public void setNormalized(String normalized) {
        this.normalized = normalized;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

}
