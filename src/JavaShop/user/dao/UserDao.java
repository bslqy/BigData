package JavaShop.user.dao;

import JavaShop.user.pojo.User;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface UserDao {
    // Add User
    public boolean addUser(User user) throws IOException, ClassNotFoundException;

    public boolean removeUser(String account);

    /***
     *  要求serivce层把所有要修改用户的数据传过来
     */
    public boolean updateUser(User user);

    public User getUserByAccount(String account);

    public List<User> getUserByAgeRange(int maxAge,int minAge);

    public List<User> getUserByVipRange(int maxAge,int minAge);

    public List<User> getUserByName(String name);

}
