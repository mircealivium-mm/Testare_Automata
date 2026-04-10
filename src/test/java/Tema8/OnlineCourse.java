package Tema8;

public class OnlineCourse extends Course {
    private String platform;


    public OnlineCourse(String courseName, int duration, String platform) {
        super(courseName, duration);
        this.platform = platform;

    }

    public String getPlatform() {
        return platform;

    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Platform: " + platform);
    }

    public static void main(String[] args) {
        Course curs = new Course("Java Basics", 50);
        curs.displayInfo();

        OnlineCourse cursOnline = new OnlineCourse("Automation Testing with Selenium", 80, "ItSchool");
        cursOnline.displayInfo();
    }

}
