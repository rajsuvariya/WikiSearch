
package io.rajsuvariya.wikisearch.data.remote.model.searchApi;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Query implements Parcelable
{

    @SerializedName("redirects")
    @Expose
    private List<Redirect> redirects = null;
    @SerializedName("pages")
    @Expose
    private List<Page> pages = null;
    public final static Creator<Query> CREATOR = new Creator<Query>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Query createFromParcel(Parcel in) {
            return new Query(in);
        }

        public Query[] newArray(int size) {
            return (new Query[size]);
        }

    }
    ;

    protected Query(Parcel in) {
        in.readList(this.redirects, (Redirect.class.getClassLoader()));
        in.readList(this.pages, (Page.class.getClassLoader()));
    }

    public Query() {
    }

    public List<Redirect> getRedirects() {
        return redirects;
    }

    public void setRedirects(List<Redirect> redirects) {
        this.redirects = redirects;
    }

    public List<Page> getPages() {
        return pages;
    }

    public void setPages(List<Page> pages) {
        this.pages = pages;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(redirects);
        dest.writeList(pages);
    }

    public int describeContents() {
        return  0;
    }

}
