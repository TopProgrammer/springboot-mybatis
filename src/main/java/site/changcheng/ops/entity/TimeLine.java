package site.changcheng.ops.entity;

import java.util.Date;

public class TimeLine {
    /**
     *主键
     */
    private Integer id;

    /**
     *内容
     */
    private String content;

    /**
     *标题
     */
    private String title;

    /**
     *年
     */
    private String year;

    /**
     *
     */
    private Date createtime;

    /**
     *天
     */
    private String time;

    /**
     *是否重要
     */
    private Integer important;

    /**
     *主键
     */
    public Integer getId() {
        return id;
    }

    /**
     *主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *内容
     */
    public String getContent() {
        return content;
    }

    /**
     *内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     *标题
     */
    public String getTitle() {
        return title;
    }

    /**
     *标题
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     *年
     */
    public String getYear() {
        return year;
    }

    /**
     *年
     */
    public void setYear(String year) {
        this.year = year == null ? null : year.trim();
    }

    /**
     *
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     *
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     *天
     */
    public String getTime() {
        return time;
    }

    /**
     *天
     */
    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    /**
     *是否重要
     */
    public Integer getImportant() {
        return important;
    }

    /**
     *是否重要
     */
    public void setImportant(Integer important) {
        this.important = important;
    }
}