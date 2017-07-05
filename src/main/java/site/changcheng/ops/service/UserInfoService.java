package site.changcheng.ops.service;

import java.util.List;
import java.util.Map;

import site.changcheng.ops.entity.UserInfo;

public interface UserInfoService {
  public void add(UserInfo user);
  
  public List<UserInfo> getAll();
  
  public Map<String, Object> login(String id,String password);
}
