package JavseSeDay14;

public class LoginServiceImpl implements LoginService {
    public void say(){
        System.out.println("Hi");
    }

    public void say(String name){
        System.out.println("Hi:" + name);
    }

    public void eat(String food){
        System.out.println("Eating");
    }

    public void speak(String name){
        System.out.println("I am "+ name);
    }

}
