package Tema8;

public class AdminAccount extends Account {

    public void deleteUser(String user) {
        System.out.println("Adminul " + getUsername() + " a sters utilizatorul " + user);
    }

    public static void main(String[] args) {
        Account cont = new Account();
        cont.setUsername("Marin Ionescu");
        cont.login();


        AdminAccount admin = new AdminAccount();
        admin.setUsername("Admin12345");
        admin.login();
        admin.deleteUser("Marin Ionescu");
    }
}
