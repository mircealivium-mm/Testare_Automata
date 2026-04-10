package Tema8;

public class LoginService {

    public void login(User user) {

        System.out.println("Login cu user: " + user.getUsername());
        System.out.println("Parola: " + user.getPassword());

    }
}
