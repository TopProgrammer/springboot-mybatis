package site.changcheng.ops.entity;

import java.io.Serializable;

public class User implements Serializable {

  private static final long serialVersionUID = -7576575574612530550L;
  private Long id;
  private String username;
  private String password;
  private String age;
  private String gender;


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

  public String getAge() {
    return age;
  }

  public void setAge(String age) {
    this.age = age;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

}
