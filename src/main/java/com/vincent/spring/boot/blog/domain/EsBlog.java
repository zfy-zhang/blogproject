package com.vincent.spring.boot.blog.domain;

import java.io.Serializable;

/**
 * Created with IDEA
 * author:vicent
 * Date:2018/10/18
 * Time:22:33
 */
@Document(indexName = "blog", type = "blog", shards = 1, replicas = 0, refreshInterval = "-1")
@XmlRootElement // MediaType 转为 XML
public class EsBlog implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id  // 主键
    private String id;

    private String title;

    private String summary;

    private String content;

    protected EsBlog() {  // JPA 的规范要求无参构造函数；设为 protected 防止直接使用
    }

    public EsBlog(String title,String summary, String content) {
        this.title = title;
        this.summary = summary;
        this.content = content;
    }

    public Blog(String id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "EsBlog{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
