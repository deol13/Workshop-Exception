package se.lexicon.exceptions.workshop.Exceptions;

public class DuplicateNameException extends Exception {
    private String name;
    public DuplicateNameException(String message, String name) {
        super(message);
        this.name = name;
    }
    public String getName() {return name;}
    public String toString() {return "Duplicate name: " + name + ", " + getMessage();}
}
