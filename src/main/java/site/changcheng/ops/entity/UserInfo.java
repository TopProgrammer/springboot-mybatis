package site.changcheng.ops.entity;

import java.io.Serializable;
import java.util.Date;

public class UserInfo implements Serializable {

  private static final long serialVersionUID = -7576575574612530550L;
  private Long id;
  private String username;
  private String password;
  private Short gender;
  private String nickName;
  private String qq;

  public Short getGender() {
    return gender;
  }

  public void setGender(Short gender) {
    this.gender = gender;
  }

  public String getNickName() {
    return nickName;
  }

  public void setNickName(String nickName) {
    this.nickName = nickName;
  }

  public String getQq() {
    return qq;
  }

  public void setQq(String qq) {
    this.qq = qq;
  }

  public Date getCreatTime() {
    return creatTime;
  }

  public void setCreatTime(Date creatTime) {
    this.creatTime = creatTime;
  }

  private Date creatTime;
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

}
