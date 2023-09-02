package org.example.report;


import lombok.extern.java.Log;
import org.example.enums.LogType;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;

public final class FrameworkLogger {
    private FrameworkLogger() {

    }

    private static final BiConsumer<String, Boolean> PASS = ExtendLogger::pass;
    private static final BiConsumer<String, Boolean> FAIL = ExtendLogger::fail;
    private static final BiConsumer<String, Boolean> SKIP = ExtendLogger::skip;
    private static final BiConsumer<String, Boolean> INFO = ExtendLogger::info;
    private static final BiConsumer<String, Boolean> CONSOLE = (message, getScreenshot)->System.out.println(message);
    private static final BiConsumer<String, Boolean> EXTEND_PASS_AND_CONSOLE = PASS.andThen(CONSOLE);

    private static final Map<LogType, BiConsumer<String, Boolean>> MAP = new EnumMap<>(LogType.class);

    static {
        MAP.put(LogType.PASS, PASS);
        MAP.put(LogType.FAIL, FAIL);
        MAP.put(LogType.SKIP, SKIP);
        MAP.put(LogType.INFO, INFO);
        MAP.put(LogType.CONSOLE, CONSOLE);
        MAP.put(LogType.EXTEND_PASS_AND_CONSOLE, EXTEND_PASS_AND_CONSOLE);
    }

    public static void log(LogType logType, String message, boolean getScreenshot) {
        MAP.get(logType).accept(message, getScreenshot);
    }
}
