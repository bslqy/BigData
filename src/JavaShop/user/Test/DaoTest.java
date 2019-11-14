package JavaShop.user.Test;

import JavaShop.user.constant.UserVipLevelConstant;
import JavaShop.user.dao.UserDaoImpl;
import JavaShop.user.pojo.User;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class DaoTest {

    @Test
    public void testAddUser() throws IOException, ClassNotFoundException {
        User u1 = new User("lovebaby1","123",20,"杨颖", UserVipLevelConstant.VIP_1,"138138338","Beijing");
        User u2 = new User("lovebaby2","123",30,"杨颖", UserVipLevelConstant.VIP_1,"138138338","Beijing");
        User u3 = new User("lovebaby3","123",35,"杨颖", UserVipLevelConstant.VIP_1,"138138338","Beijing");
        User u4 = new User("lovebaby4","123",40,"杨颖", UserVipLevelConstant.VIP_1,"138138338","Beijing");
        User u5 = new User("lovebaby5","123",18,"杨颖", UserVipLevelConstant.VIP_1,"138138338","Beijing");
        UserDaoImpl userDaoImpl = new UserDaoImpl();
        userDaoImpl.addUser(u1);

        userDaoImpl.getUserByAccount("lovebaby");
        List<User> users = userDaoImpl.getUserByAgeRange(30, 20);
        for(User u:users){
            System.out.println(u.getAge());
        }
    }
}
