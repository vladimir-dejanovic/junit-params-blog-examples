package xyz.itshark.blog.examples;

public class Person {

    private final String firstName;
    private final String lastName;

    public Person(String first, String last) {
        if(first == null || first.trim().isEmpty() || last == null || last.trim().isEmpty() ) {
            throw new RuntimeException("bad input");
        }
        this.firstName = first;
        this.lastName = last;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
