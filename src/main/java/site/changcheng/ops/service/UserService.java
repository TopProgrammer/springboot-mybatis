package site.changcheng.ops.service;

import java.util.List;
import java.util.Map;

import site.changcheng.ops.entity.User;

public interface UserService {
  public void add(User user);
  
  public List<User> getAll();
  
  public Map<String, Object> login(String id,String password);
}
