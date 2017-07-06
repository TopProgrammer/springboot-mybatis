package site.changcheng.ops.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.changcheng.ops.entity.UserInfo;
import site.changcheng.ops.mapper.primarydatasource.UserInfoMapper;
import site.changcheng.ops.service.UserInfoService;

import java.util.List;
import java.util.Map;

@Service("userService")
public class UserServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public void add(UserInfo user) {

    }

    @Override
    public List<UserInfo> getAll() {
        return userInfoMapper.getAll();
    }

    @Override
    public Map<String, Object> login(String id, String password) {
        // TODO Auto-generated method stub
        return null;
    }

}
