package com.example.vishvendu.nyctopnews.database;



import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by vishvendu on 12/12/17.
 */


@Entity
public class TopNewsData {

    @Id(autoincrement = true)
    private Long id;

    @NotNull
    private String title;

    @NotNull
    private String byline;

    @NotNull
    private String section;

    @NotNull
    private String shortUrl;

    private Long NewsId;

    @Generated(hash = 263559589)
    public TopNewsData(Long id, @NotNull String title, @NotNull String byline,
            @NotNull String section, @NotNull String shortUrl, Long NewsId) {
        this.id = id;
        this.title = title;
        this.byline = byline;
        this.section = section;
        this.shortUrl = shortUrl;
        this.NewsId = NewsId;
    }

    @Generated(hash = 871781987)
    public TopNewsData() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getByline() {
        return this.byline;
    }

    public void setByline(String byline) {
        this.byline = byline;
    }

    public String getSection() {
        return this.section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getShortUrl() {
        return this.shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public Long getNewsId() {
        return this.NewsId;
    }

    public void setNewsId(Long NewsId) {
        this.NewsId = NewsId;
    }

   



}
