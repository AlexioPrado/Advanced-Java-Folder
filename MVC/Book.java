// Book.java — MODEL  [25 pts]
// Responsibility: Stores and manages book data.
// Rule: This class must NEVER reference BookView or BookController.

public class Book {

    // TODO (1): Declare three private fields:
    //   - title  (String)
    //   - author (String)
    //   - year   (int)
    private String title;
    private String author;
    private int year;

    // TODO (2): Write a constructor that accepts title, author, and year
    //           and assigns each to the corresponding field.
    public Book(String title, String author, int year){
        this.title = title;
        this.author = author;
        this.year = year;
    }

    // TODO (3): Write public getters for all three fields.
    //   - getTitle()  → returns title
    //   - getAuthor() → returns author
    //   - getYear()   → returns year
    public String getTitle(){
        return this.title;
    }

    public String getAuthor(){
        return this.author;
    }

    public int getYear(){
        return this.year;
    }

    // TODO (4): Write a public setter for year ONLY.
    //           (title and author should never change after construction)
    //   - setYear(int year)
    public void setYear(int year){
        this.year = year;
    }

}
