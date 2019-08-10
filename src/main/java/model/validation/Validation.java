package model.validation;

public class Validation {

    public static boolean isStringValid(String string) {
        if (string != null && string.matches("^[[А-ЩЬЮЯЇІЄҐ а-щьюяїієґ A-Z a-z 0-9]]{1,20}+$")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isPasswordValid(String password) {
        if (password != null) {
            return true;
        } else {
            return false;
        }
    }
}