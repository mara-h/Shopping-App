package Exceptions;

public class InvalidAdmin extends Exception {
    public InvalidAdmin(){
        super("Admin does not exist");
    }
}
