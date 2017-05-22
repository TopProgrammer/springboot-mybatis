package site.changcheng.ops.test;

import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

import site.changcheng.ops.entity.User;
import site.changcheng.ops.mapper.UserMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {UserMapperTest.class})
@WebAppConfiguration
public class UserMapperTest {

    @Autowired
    private UserMapper UserMapper;

/*    @Test
    public void testInsert() throws Exception {
        UserMapper.insert(new User("aa", "a123456", UserSexEnum.MAN));
        UserMapper.insert(new User("bb", "b123456", UserSexEnum.WOMAN));
        UserMapper.insert(new User("cc", "b123456", UserSexEnum.WOMAN));

        Assert.assertEquals(3, UserMapper.getAll().size());
    }*/

    @Test
    public void testQuery() throws Exception {
        List<User> users = UserMapper.getAll();
        System.out.println(users.toString());
    }


}