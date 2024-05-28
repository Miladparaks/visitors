package model.controller.exceptions.NoMedicalFounException;

public class NoMedicalFoundException extends Exception {
    public NoMedicalFoundException() {
        super ("No Such Medical Services has been found");
    }
}
