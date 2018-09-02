
package io.rajsuvariya.wikisearch.data.remote.model.detailsApi;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity
public class Thumbnail {

    @SerializedName("source")
    @ColumnInfo(name = "thumbnail_source")
    @Expose
    private String source;
    @SerializedName("width")
    @ColumnInfo(name = "thumbnail_width")
    @Expose
    private int width;
    @SerializedName("height")
    @ColumnInfo(name = "thumbnail_height")
    @Expose
    private int height;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

}
