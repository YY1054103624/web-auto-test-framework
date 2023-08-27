package org.example.exceptions;

public class ExcelFileIOException extends FrameworkFileIOException{
    public ExcelFileIOException() {
        super();
    }

    public ExcelFileIOException(String message) {
        super(message);
    }

    public ExcelFileIOException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExcelFileIOException(Throwable cause) {
        super(cause);
    }
}
