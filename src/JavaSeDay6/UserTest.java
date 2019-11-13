package JavaSeDay6;

import java.util.*;

public class UserTest {

    @org.junit.Test
    public void sayHello() {
        System.out.println("HHHA");
    }

    public static void main(String[] args){

        User u1 = new User("1","A",30,"abc1","0431",1000);
        User u2 = new User("2","B",40,"abc2","0432",2000);
        User u3 = new User("3","C",50,"abc3","0433",3000);
        User u4 = new User("4","D",60,"abc4","0434",4000);

        // Array
        User[] userArr = new User[]{u1,u2,u3,u4};

        // ArrayList
        ArrayList<User> userList = new ArrayList<>();
        userList.add(u1);
        userList.add(u2);
        userList.add(u3);
        userList.add(u4);

        //HashMap
        HashMap<String,User> userMap = new HashMap<>();
        userMap.put(u1.getId(),u1);
        userMap.put(u2.getId(),u2);
        userMap.put(u3.getId(),u3);
        userMap.put(u4.getId(),u4);

        // Hashset
        HashSet<User> userSet = new HashSet<>();
        userSet.add(u1);
        userSet.add(u2);
        userSet.add(u3);
        userSet.add(u4);

        //遍历Hashmap
//        等同于 python for k in dic:
//                         d[k]
        Set<String> keySet = userMap.keySet();
        for (String s:keySet){
            User u = userMap.get(s);
            System.out.println(u.getId());
        }

        // 方法2 (for k,v in d.items())
        Set<Map.Entry<String, User>> entries = userMap.entrySet();
        for (Map.Entry<String,User> ent:entries){
            System.out.println(ent.getKey());
            System.out.println(ent.getValue());
        }

        //找出年龄最大的user对象，从set中找出薪水最高的user对象，从map中找出age最小的user对象
        User u = userList.get(0);
        for (int i = 0; i <userList.size();i++){
            if(userList.get(i).getAge() > u.getAge()){
                u = userList.get(i);
            }
        }

        System.out.println("Oldest user is " + u.getId());

        Iterator<User> iterator = userSet.iterator();
        User u_set = iterator.next();
        for (User user:userSet){
            if (user.getSalary() > u_set.getSalary()){
                u_set = user;
            }
        }

        System.out.println("Highest salary "+ u_set.getId());

    }
}
