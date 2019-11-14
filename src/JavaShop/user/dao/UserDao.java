package JavaShop.user.dao;

import JavaShop.user.pojo.User;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface UserDao {
    // Add User
    public boolean addUser(User user) throws IOException, ClassNotFoundException;

    public boolean removeUser(String account) throws IOException, ClassNotFoundException;

    /***
     *  要求serivce层把所有要修改用户的数据传过来
     */
    public boolean updateUser(User user) throws IOException, ClassNotFoundException;

    public User getUserByAccount(String account) throws IOException, ClassNotFoundException;

    public List<User> getUserByAgeRange(int maxAge,int minAge) throws IOException, ClassNotFoundException;

    public List<User> getUserByVipRange(int maxAge,int minAge) throws IOException, ClassNotFoundException;

    public List<User> getUserByName(String name) throws IOException, ClassNotFoundException;


}
