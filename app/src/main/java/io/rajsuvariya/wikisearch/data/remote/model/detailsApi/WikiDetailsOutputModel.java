
package io.rajsuvariya.wikisearch.data.remote.model.detailsApi;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity
public class WikiDetailsOutputModel {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("displaytitle")
    @Expose
    private String displaytitle;
    @SerializedName("namespace")
    @Expose
    @Embedded
    private Namespace namespace;
    @SerializedName("titles")
    @Expose
    @Embedded
    private Titles titles;
    @PrimaryKey
    @SerializedName("pageid")
    @Expose
    private int pageid;
    @SerializedName("thumbnail")
    @Expose
    @Embedded
    private Thumbnail thumbnail;
    @SerializedName("originalimage")
    @Expose
    @Embedded
    private Originalimage originalimage;
    @SerializedName("lang")
    @Expose
    private String lang;
    @SerializedName("dir")
    @Expose
    private String dir;
    @SerializedName("revision")
    @Expose
    private String revision;
    @SerializedName("tid")
    @Expose
    private String tid;
    @SerializedName("timestamp")
    @Expose
    private String timestamp;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("content_urls")
    @Expose
    @Embedded
    private ContentUrls contentUrls;
    @SerializedName("api_urls")
    @Expose
    @Embedded
    private ApiUrls apiUrls;
    @SerializedName("extract")
    @Expose
    private String extract;
    @SerializedName("extract_html")
    @Expose
    private String extractHtml;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDisplaytitle() {
        return displaytitle;
    }

    public void setDisplaytitle(String displaytitle) {
        this.displaytitle = displaytitle;
    }

    public Namespace getNamespace() {
        return namespace;
    }

    public void setNamespace(Namespace namespace) {
        this.namespace = namespace;
    }

    public Titles getTitles() {
        return titles;
    }

    public void setTitles(Titles titles) {
        this.titles = titles;
    }

    public int getPageid() {
        return pageid;
    }

    public void setPageid(int pageid) {
        this.pageid = pageid;
    }

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Originalimage getOriginalimage() {
        return originalimage;
    }

    public void setOriginalimage(Originalimage originalimage) {
        this.originalimage = originalimage;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getRevision() {
        return revision;
    }

    public void setRevision(String revision) {
        this.revision = revision;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ContentUrls getContentUrls() {
        return contentUrls;
    }

    public void setContentUrls(ContentUrls contentUrls) {
        this.contentUrls = contentUrls;
    }

    public ApiUrls getApiUrls() {
        return apiUrls;
    }

    public void setApiUrls(ApiUrls apiUrls) {
        this.apiUrls = apiUrls;
    }

    public String getExtract() {
        return extract;
    }

    public void setExtract(String extract) {
        this.extract = extract;
    }

    public String getExtractHtml() {
        return extractHtml;
    }

    public void setExtractHtml(String extractHtml) {
        this.extractHtml = extractHtml;
    }

}
