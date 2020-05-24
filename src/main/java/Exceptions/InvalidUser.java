package Exceptions;

public class InvalidUser extends Exception{
    public InvalidUser(){
        super("User does not exist");
    }
}
