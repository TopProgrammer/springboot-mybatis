package site.changcheng.ops.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import site.changcheng.ops.entity.User;
import site.changcheng.ops.mapper.UserMapper;
import site.changcheng.ops.service.UserService;
@Service("userService")
public class UserServiceImpl implements UserService{

  @Autowired
  private UserMapper userMapper;
  @Override
  public void add(User user) {
    userMapper.insert(user);
  }

  @Override
  public List<User> getAll() {
    return userMapper.getAll();
  }

  @Override
  public Map<String, Object> login(String id, String password) {
    // TODO Auto-generated method stub
    return null;
  }

}
