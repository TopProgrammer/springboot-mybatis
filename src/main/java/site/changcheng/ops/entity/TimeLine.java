package site.changcheng.ops.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by baiju on 2017/6/4.
 */
public class TimeLine implements Serializable{
    private static final long serialVersionUID = -7576575574612530550L;
    private Long id;
    private String title;
    private String content;
    private Date time;
    private String important;

    public Long getId() {
        return id;
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

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getImportant() {
        return important;
    }

    public void setImportant(String important) {
        this.important = important;
    }
}
