package org.example.exceptions;

public class ExcelFileNotFoundException extends FrameworkFileNotFoundException{
    public ExcelFileNotFoundException() {
        super();
    }

    public ExcelFileNotFoundException(String message) {
        super(message);
    }

    public ExcelFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExcelFileNotFoundException(Throwable cause) {
        super(cause);
    }
}
