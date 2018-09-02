
package io.rajsuvariya.wikisearch.data.remote.model.searchApi;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Page implements Parcelable
{

    @SerializedName("pageid")
    @Expose
    private int pageid;
    @SerializedName("ns")
    @Expose
    private int ns;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("index")
    @Expose
    private int index;
    @SerializedName("thumbnail")
    @Expose
    private Thumbnail thumbnail;
    @SerializedName("terms")
    @Expose
    private Terms terms;
    public final static Creator<Page> CREATOR = new Creator<Page>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Page createFromParcel(Parcel in) {
            return new Page(in);
        }

        public Page[] newArray(int size) {
            return (new Page[size]);
        }

    }
    ;

    protected Page(Parcel in) {
        this.pageid = ((int) in.readValue((int.class.getClassLoader())));
        this.ns = ((int) in.readValue((int.class.getClassLoader())));
        this.title = ((String) in.readValue((String.class.getClassLoader())));
        this.index = ((int) in.readValue((int.class.getClassLoader())));
        this.thumbnail = ((Thumbnail) in.readValue((Thumbnail.class.getClassLoader())));
        this.terms = ((Terms) in.readValue((Terms.class.getClassLoader())));
    }

    public Page() {
    }

    public int getPageid() {
        return pageid;
    }

    public void setPageid(int pageid) {
        this.pageid = pageid;
    }

    public int getNs() {
        return ns;
    }

    public void setNs(int ns) {
        this.ns = ns;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Terms getTerms() {
        return terms;
    }

    public void setTerms(Terms terms) {
        this.terms = terms;
    }

    public String getImageUrl() {
        if (getThumbnail()!=null && getThumbnail().getSource()!=null) {
            return getThumbnail().getSource();
        }
        return "";
    }


    public String getDescription() {
        if (this.getTerms()!=null) {
            List<String> descriptions = getTerms().getDescription();
            if (descriptions.size() > 0) {
                StringBuilder descriptionBuilder  = new StringBuilder();
                for (int i = 0; i < descriptions.size(); i++) {
                    descriptionBuilder.append(descriptions.get(i));
                    if (i != descriptions.size() - 1)
                        descriptionBuilder.append(", ");
                }
                return descriptionBuilder.toString();
            } else {
                return "";
            }
        } else {
            return "";
        }
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(pageid);
        dest.writeValue(ns);
        dest.writeValue(title);
        dest.writeValue(index);
        dest.writeValue(thumbnail);
        dest.writeValue(terms);
    }

    public int describeContents() {
        return  0;
    }

}
