package JavaSeDay6;

public class User {
    private String id;
    private String name;
    private int age;
    private String password;
    private String phone;
    private float salary;


    public User(String id, String name, int age, String password, String phone, float salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.password = password;
        this.phone = phone;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public float getSalary() {
        return salary;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
}
