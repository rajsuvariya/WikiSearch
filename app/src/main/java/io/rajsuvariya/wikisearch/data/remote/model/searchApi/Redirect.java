
package io.rajsuvariya.wikisearch.data.remote.model.searchApi;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Redirect implements Parcelable
{

    @SerializedName("index")
    @Expose
    private int index;
    @SerializedName("from")
    @Expose
    private String from;
    @SerializedName("to")
    @Expose
    private String to;
    public final static Creator<Redirect> CREATOR = new Creator<Redirect>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Redirect createFromParcel(Parcel in) {
            return new Redirect(in);
        }

        public Redirect[] newArray(int size) {
            return (new Redirect[size]);
        }

    }
    ;

    protected Redirect(Parcel in) {
        this.index = ((int) in.readValue((int.class.getClassLoader())));
        this.from = ((String) in.readValue((String.class.getClassLoader())));
        this.to = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Redirect() {
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(index);
        dest.writeValue(from);
        dest.writeValue(to);
    }

    public int describeContents() {
        return  0;
    }

}
