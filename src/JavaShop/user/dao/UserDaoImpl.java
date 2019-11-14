package JavaShop.user.dao;

import JavaShop.user.constant.DatabasePathConstant;
import JavaShop.user.pojo.User;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class UserDaoImpl implements UserDao {

    @Override
    public boolean addUser(User user) throws IOException, ClassNotFoundException {
        File file = new File(DatabasePathConstant.user_data_path);
        HashMap<String,User> userMap = null;
        if (file.exists()){

        userMap = FileUtil.readMapFromFile(DatabasePathConstant.user_data_path);

        }
        else{
            userMap = new HashMap<>();
        }


        userMap.put(user.getAccount(),user);

        FileUtil.saveMapToFile(userMap);

        return true;
    }

    @Override
    public boolean removeUser(String account) throws IOException, ClassNotFoundException {
        HashMap<String, User> userMap = FileUtil.readMapFromFile(DatabasePathConstant.user_data_path);
        User remove = userMap.remove(account);
        if (remove == null) return false;
        FileUtil.saveMapToFile(userMap);

        return true;

    }

    @Override
    public boolean updateUser(User user) throws IOException, ClassNotFoundException {
        HashMap<String, User> userMap = FileUtil.readMapFromFile(DatabasePathConstant.user_data_path);
        userMap.put(user.getAccount(),user);
        FileUtil.saveMapToFile(userMap);
        return true;
    }

    @Override
    public User getUserByAccount(String account) throws IOException, ClassNotFoundException {
        HashMap<String, User> userMap = FileUtil.readMapFromFile(DatabasePathConstant.user_data_path);

        return userMap.get(account);

    }

    @Override
    public List<User> getUserByAgeRange(int maxAge, int minAge) throws IOException, ClassNotFoundException {
        ArrayList<User> userList = new ArrayList<>();
        HashMap<String, User> userMap = FileUtil.readMapFromFile(DatabasePathConstant.user_data_path);
        Collection<User> users = userMap.values();
        for (User u:users){
            if(u.getAge() >= minAge && u.getAge() <= maxAge){
                userList.add(u);
            }
        }
        return userList;
    }

    @Override
    public List<User> getUserByVipRange(int maxAge, int minAge) throws IOException, ClassNotFoundException {
        ArrayList<User> userList = new ArrayList<>();
        HashMap<String, User> userMap = FileUtil.readMapFromFile(DatabasePathConstant.user_data_path);
        Collection<User> users = userMap.values();
        for (User u:users){
            if(u.getVIPLevel() >= minAge && u.getVIPLevel() <= maxAge){
                userList.add(u);
            }
        }
        return userList;
}

    @Override
    public List<User> getUserByName(String name) throws IOException, ClassNotFoundException {
        ArrayList<User> userList = new ArrayList<>();
        HashMap<String, User> userMap = FileUtil.readMapFromFile(DatabasePathConstant.user_data_path);
        Collection<User> users = userMap.values();
        for (User u:users){
            if (u.getName().contains(name)){
                userList.add(u);
            }
        }
        return userList;
    }
}
