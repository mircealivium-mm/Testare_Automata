package Tema8;

public class Book {

    private String title;
    private String author;


    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title= title;

    }
    public String getAuthor(){
        return author;

    }

    public void setAuthor(String author){
        this.author=author;

    }

    public static void main(String[] args){
        Book book = new Book();

        book.setTitle("Amintiri din copilarie");
        book.setAuthor("Ion Creanga");

        System.out.println("Titlu: " + book.getTitle());
        System.out.println("Autor: " + book.getAuthor());
    }
}
