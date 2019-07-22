package utility;

import java.util.Locale;

public enum Language {
    UA(new Locale("uk", "UA")),
    EN(new Locale("en", "UK"));

    private Locale locale;

    Language(Locale locale) {
        this.locale = locale;
    }

    public Locale getLocale() {
        return locale;
    }
}