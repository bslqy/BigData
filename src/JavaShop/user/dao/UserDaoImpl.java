package JavaShop.user.dao;

import JavaShop.user.pojo.User;

import java.io.*;
import java.util.HashMap;
import java.util.List;

public class UserDaoImpl implements UserDao {

    @Override
    public boolean addUser(User user) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("d:/shop/user.dat"));
        HashMap<String,User> userMap = (HashMap<String,User>) ois.readObject();


        userMap.put(user.getAccount(),user);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("d:/shop/user.dat"));
        oos.writeObject(userMap);
        oos.close();

        return true;
    }

    @Override
    public boolean removeUser(String account) {
        return false;
    }

    @Override
    public boolean updateUser(User user) {
        return false;
    }

    @Override
    public User getUserByAccount(String account) {
        return null;
    }

    @Override
    public List<User> getUserByAgeRange(int maxAge, int minAge) {
        return null;
    }

    @Override
    public List<User> getUserByVipRange(int maxAge, int minAge) {
        return null;
    }

    @Override
    public List<User> getUserByName(String name) {
        return null;
    }
}
