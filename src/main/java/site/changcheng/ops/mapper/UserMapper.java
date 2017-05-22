package site.changcheng.ops.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import site.changcheng.ops.entity.User;

public interface UserMapper {
/**
 * 
 *   // This example creates a prepared statement, something like select * from teacher where name = ?;
 *   @Select("Select * from teacher where name = #{name}")
 *   Teacher selectTeachForGivenName(@Param("name") String name);
 *   
 *   // This example creates n inlined statement, something like select * from teacher where name = 'someName';
 *   @Select("Select * from teacher where name = '${name}'")
 *   Teacher selectTeachForGivenName(@Param("name") String name);
 */
  
  
  
  @Select("SELECT * FROM user")
//  @Results({
//      @Result(property = "userSex",  column = "user_sex", javaType = UserSexEnum.class),
//      @Result(property = "nickName", column = "nick_name")
//  })
  List<User> getAll();

  @Select("SELECT * FROM user WHERE id = #{id}")
//  @Results({
//      @Result(property = "userSex",  column = "user_sex", javaType = UserSexEnum.class),
//      @Result(property = "nickName", column = "nick_name")
//  })
  User getOne(Long id);

  @Insert("INSERT INTO user(username,passWord,gender) VALUES(#{username}, #{password}, #{gender})")
  void insert(User user);

  @Update("UPDATE user SET username=#{username} WHERE id =#{id}")
  void update(User user);

  @Delete("DELETE FROM users WHERE id =#{id}")
  void delete(Long id);

}
