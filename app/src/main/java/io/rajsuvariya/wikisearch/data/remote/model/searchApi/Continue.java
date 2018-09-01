
package io.rajsuvariya.wikisearch.data.remote.model.searchApi;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Continue implements Parcelable
{

    @SerializedName("gpsoffset")
    @Expose
    private int gpsoffset;
    @SerializedName("continue")
    @Expose
    private String _continue;
    public final static Creator<Continue> CREATOR = new Creator<Continue>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Continue createFromParcel(Parcel in) {
            return new Continue(in);
        }

        public Continue[] newArray(int size) {
            return (new Continue[size]);
        }

    }
    ;

    protected Continue(Parcel in) {
        this.gpsoffset = ((int) in.readValue((int.class.getClassLoader())));
        this._continue = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Continue() {
    }

    public int getGpsoffset() {
        return gpsoffset;
    }

    public void setGpsoffset(int gpsoffset) {
        this.gpsoffset = gpsoffset;
    }

    public String getContinue() {
        return _continue;
    }

    public void setContinue(String _continue) {
        this._continue = _continue;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(gpsoffset);
        dest.writeValue(_continue);
    }

    public int describeContents() {
        return  0;
    }

}
