package org.example.exceptions;

public class ConfigFileNotFoundException extends FrameworkFileNotFoundException{
    public ConfigFileNotFoundException() {
        super();
    }

    public ConfigFileNotFoundException(String message) {
        super(message);
    }

    public ConfigFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConfigFileNotFoundException(Throwable cause) {
        super(cause);
    }
}
