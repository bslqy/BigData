package JavaShop.user.Service;

import JavaShop.user.dao.UserDao;
import JavaShop.user.dao.UserDaoImpl;
import JavaShop.user.pojo.User;

import java.io.IOException;
import java.util.HashMap;

public class UserServiceImpl implements UserService {

    UserDao userDao = new UserDaoImpl();

    @Override
    public boolean checkIfAccountExist(String account) throws IOException, ClassNotFoundException {
        User user = userDao.getUserByAccount(account);

        return user != null;
    }

    @Override
    public boolean addUser(User user) throws IOException, ClassNotFoundException {
        boolean addUser = userDao.addUser(user);
        return addUser;
    }

    @Override
    public boolean userLogin(String account, String password) throws IOException, ClassNotFoundException {
        User user = userDao.getUserByAccount(account);
        if (user == null) return false;

        return user.getPassword().equals(password);

    }

    @Override
    public boolean updateUserName(String account, String newName) throws IOException, ClassNotFoundException {
        User user = userDao.getUserByAccount(account);
        if(user == null) return false;

        user.setName(newName);

        return  true;

    }

    @Override
    public boolean updateUserAge(String account, int newAge) throws IOException, ClassNotFoundException {
        User user = userDao.getUserByAccount(account);
        if(user == null) return false;

        user.setAge(newAge);

        return  true;
    }

    @Override
    public boolean removeUser(String account) throws IOException, ClassNotFoundException {
        boolean removeUser = userDao.removeUser(account);
        return removeUser;


    }
}
