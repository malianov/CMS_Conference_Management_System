package model.exception;

public class ItemException extends Exception {

    private String wrongData;

    ItemException(String wrongData) {
        this.wrongData = wrongData;
    }

    ItemException() {}

    public String getWrongData() {
        return wrongData;
    }
}
