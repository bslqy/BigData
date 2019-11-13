package JavaShop.user.pojo;

import java.io.Serializable;

/***
 * 描述用户实体的类
 */
public class User implements Serializable {
    private String account;
    private String  password;
    private int age;
    private String name;
    private int VIPLevel;
    private String phone;
    private String add;

    public User(String account, String password, int age, String name, int VIPLevel, String phone, String add) {
        this.account = account;
        this.password = password;
        this.age = age;
        this.name = name;
        this.VIPLevel = VIPLevel;
        this.phone = phone;
        this.add = add;
    }

    public void set(String account, String password, int age, String name, int VIPLevel, String phone, String add) {
        this.account = account;
        this.password = password;
        this.age = age;
        this.name = name;
        this.VIPLevel = VIPLevel;
        this.phone = phone;
        this.add = add;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVIPLevel() {
        return VIPLevel;
    }

    public void setVIPLevel(int VIPLevel) {
        this.VIPLevel = VIPLevel;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }
}
