package com.uriah.mmvm.busytoeasy.data.remote.local.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


@Entity
public class Item {



    @PrimaryKey
    @NonNull
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("file_links")
    @Expose
    private String fileLinks;
    @SerializedName("file_url")
    @Expose
    private String fileUrl;
    @SerializedName("date_added")
    @Expose
    private String dateAdded;

    public Item(){}

    public Item(@NonNull String id, String title, String fileLinks, String fileUrl, String dateAdded) {
        this.id = id;
        this.title = title;
        this.fileLinks = fileLinks;
        this.fileUrl = fileUrl;
        this.dateAdded = dateAdded;
    }


    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFileLinks() {
        return fileLinks;
    }

    public void setFileLinks(String fileLinks) {
        this.fileLinks = fileLinks;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

}