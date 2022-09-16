package config;

import java.util.function.Supplier;

public class MenuException extends Exception implements Supplier<MenuException> {
    public MenuException(String message) {
        super(message);
    }

    @Override
    public MenuException get() {
        return this;
    }
}
