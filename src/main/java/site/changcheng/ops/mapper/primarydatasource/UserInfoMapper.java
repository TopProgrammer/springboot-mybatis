package site.changcheng.ops.mapper.primarydatasource;

import org.apache.ibatis.annotations.Select;
import site.changcheng.ops.entity.UserInfo;

import java.util.List;

/**
 * Created by changcheng on 2017/7/6.
 */
public interface UserInfoMapper {

    @Select("SELECT * FROM userinfo")
    List<UserInfo> getAll();
}
