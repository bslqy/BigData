package JavaShop.user.dao;

import JavaShop.user.constant.DatabasePathConstant;
import JavaShop.user.pojo.User;

import java.io.*;
import java.util.HashMap;

public class FileUtil {

    public static HashMap<String, User> readMapFromFile(String path) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DatabasePathConstant.user_data_path));
        HashMap<String, User> userMap = (HashMap<String, User>) ois.readObject();
        ois.close();

        return userMap;
    }

    public static void saveMapToFile(HashMap<String,User> userMap) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DatabasePathConstant.user_data_path));
        oos.writeObject(userMap);
        oos.close();
    }
}
