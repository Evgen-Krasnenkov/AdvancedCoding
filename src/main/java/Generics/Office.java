package Generics;

public class Office extends Building{
    int capacity;
    String category;

    @Override
    public String toString() {
        return "Office{" +
                "capacity=" + capacity +
                ", category='" + category + '\'' +
                '}';
    }
}
