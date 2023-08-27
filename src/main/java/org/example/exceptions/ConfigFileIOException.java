package org.example.exceptions;

public class ConfigFileIOException extends FrameworkFileIOException{
    public ConfigFileIOException() {
        super();
    }

    public ConfigFileIOException(String message) {
        super(message);
    }

    public ConfigFileIOException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConfigFileIOException(Throwable cause) {
        super(cause);
    }
}
