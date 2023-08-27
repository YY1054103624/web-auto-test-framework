package org.example.exceptions;

public class OpenReportIOException extends FrameworkException{
    public OpenReportIOException() {

    }

    public OpenReportIOException(String message) {
        super(message);
    }

    public OpenReportIOException(String message, Throwable cause) {
        super(message, cause);
    }

    public OpenReportIOException(Throwable cause) {
        super(cause);
    }
}
