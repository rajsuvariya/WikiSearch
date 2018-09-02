
package io.rajsuvariya.wikisearch.data.remote.model.detailsApi;

import android.arch.persistence.room.ColumnInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Mobile {

    @SerializedName("page")
    @ColumnInfo(name = "mobile_page")
    @Expose
    private String page;
    @SerializedName("revisions")
    @ColumnInfo(name = "mobile_revisions")
    @Expose
    private String revisions;
    @SerializedName("edit")
    @ColumnInfo(name = "mobile_edit")
    @Expose
    private String edit;
    @SerializedName("talk")
    @ColumnInfo(name = "mobile_talk")
    @Expose
    private String talk;

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getRevisions() {
        return revisions;
    }

    public void setRevisions(String revisions) {
        this.revisions = revisions;
    }

    public String getEdit() {
        return edit;
    }

    public void setEdit(String edit) {
        this.edit = edit;
    }

    public String getTalk() {
        return talk;
    }

    public void setTalk(String talk) {
        this.talk = talk;
    }

}
