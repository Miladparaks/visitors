package model.controller.exceptions;

public class NoMedicalFoundException extends Exception {

    public NoMedicalFoundException() {

        super("No Such Medical Services has been found");
    }
}
