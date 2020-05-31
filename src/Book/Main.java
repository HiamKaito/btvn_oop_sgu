package Book;


public class Main {
    public static void main(String[] args) {
        Author b = new Author("K", "a", 'm');
        Book a = new Book("Hello", b, 12.9, 20);
        System.out.println(a.toString());
    }
}
