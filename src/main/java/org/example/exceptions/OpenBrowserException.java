package org.example.exceptions;

import java.net.MalformedURLException;

public class OpenBrowserException extends FrameworkException{
    public OpenBrowserException() {
        super();
    }

    public OpenBrowserException(String message) {
        super(message);
    }

    public OpenBrowserException(Throwable cause) {
        super(cause);
    }
    public OpenBrowserException(String message, Throwable cause) {
        super(message, cause);
    }
}
