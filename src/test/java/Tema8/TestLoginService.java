package Tema8;

public class TestLoginService {

    public static void main(String[] args) {
        User user = new User("Marin Ionescu","parola999");
        LoginService service = new LoginService();
        service.login(user);
    }
}
