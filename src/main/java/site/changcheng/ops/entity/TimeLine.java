package site.changcheng.ops.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by baiju on 2017/6/4.
 */
public class TimeLine implements Serializable {
    private static final long serialVersionUID = -7576575574612530550L;
    private Long id;
    private String title;
    private String content;
    private String year;

    public String getTime() {
        return time;
    }

    private String time;
    private Date createTime;
    private Integer important;

    public Long getId() {
        return id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getImportant() {
        return important;
    }
    public void setImportant(Integer important) {
        this.important = important;
    }
}
