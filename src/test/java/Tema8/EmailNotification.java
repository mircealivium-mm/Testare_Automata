package Tema8;

public class EmailNotification extends Notification {
    private String emailAddress;

    public String getEmailAddress() {
        return emailAddress;

    }
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public void send() {
        System.out.println("Se trimite email: " + emailAddress);
    }

    public static void main(String[] args) {
        EmailNotification email = new EmailNotification();
        email.setEmailAddress("test@gmail.com");
        email.send();

//        EmailNotification email2 = new EmailNotification();
//        email2.setEmailAddress("test2@gmail.com");
//        email2.send();
    }
}
