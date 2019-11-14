package JavaShop.user.Service;

import JavaShop.user.pojo.User;

import java.io.IOException;

public interface UserService {
    public  boolean checkIfAccountExist(String account) throws IOException, ClassNotFoundException;
    public boolean addUser(User user) throws IOException, ClassNotFoundException;
    public boolean userLogin(String account,String password) throws IOException, ClassNotFoundException;
    public boolean updateUserName(String account,String newName) throws IOException, ClassNotFoundException;
    public boolean updateUserAge(String account,int newAge) throws IOException, ClassNotFoundException;
    public boolean removeUser(String account) throws IOException, ClassNotFoundException;




}
