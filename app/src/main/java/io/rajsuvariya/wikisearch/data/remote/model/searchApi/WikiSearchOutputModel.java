
package io.rajsuvariya.wikisearch.data.remote.model.searchApi;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WikiSearchOutputModel implements Parcelable
{

    @SerializedName("batchcomplete")
    @Expose
    private boolean batchcomplete;
    @SerializedName("continue")
    @Expose
    private Continue _continue;
    @SerializedName("query")
    @Expose
    private Query query;
    public final static Creator<WikiSearchOutputModel> CREATOR = new Creator<WikiSearchOutputModel>() {


        @SuppressWarnings({
            "unchecked"
        })
        public WikiSearchOutputModel createFromParcel(Parcel in) {
            return new WikiSearchOutputModel(in);
        }

        public WikiSearchOutputModel[] newArray(int size) {
            return (new WikiSearchOutputModel[size]);
        }

    }
    ;

    protected WikiSearchOutputModel(Parcel in) {
        this.batchcomplete = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this._continue = ((Continue) in.readValue((Continue.class.getClassLoader())));
        this.query = ((Query) in.readValue((Query.class.getClassLoader())));
    }

    public WikiSearchOutputModel() {
    }

    public boolean isBatchcomplete() {
        return batchcomplete;
    }

    public void setBatchcomplete(boolean batchcomplete) {
        this.batchcomplete = batchcomplete;
    }

    public Continue getContinue() {
        return _continue;
    }

    public void setContinue(Continue _continue) {
        this._continue = _continue;
    }

    public Query getQuery() {
        return query;
    }

    public void setQuery(Query query) {
        this.query = query;
    }


    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(batchcomplete);
        dest.writeValue(_continue);
        dest.writeValue(query);
    }

    public int describeContents() {
        return  0;
    }

}
