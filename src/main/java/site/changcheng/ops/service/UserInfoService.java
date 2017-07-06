package site.changcheng.ops.service;

import site.changcheng.ops.entity.UserInfo;

import java.util.List;
import java.util.Map;

public interface UserInfoService {
  void add(UserInfo user);
  
  List<UserInfo> getAll();
  
  Map<String, Object> login(String id,String password);
}
