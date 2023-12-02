package com.arlosoft.macrodroid.logging.helper;

import com.arlosoft.macrodroid.database.room.LogLevel;
import org.jetbrains.annotations.NotNull;

/* compiled from: HelperLogLevel.kt */
/* loaded from: classes3.dex */
public enum HelperLogLevel {
    LOG_ENTRY_DEBUG(0, LogLevel.DEBUG),
    LOG_ENTRY_STANDARD(1, LogLevel.INFO),
    LOG_ENTRY_WARNING(2, LogLevel.WARNING),
    LOG_ENTRY_ERROR(3, LogLevel.ERROR);
    
    private final int intVal;
    @NotNull
    private final LogLevel logLevel;

    HelperLogLevel(int i4, LogLevel logLevel) {
        this.intVal = i4;
        this.logLevel = logLevel;
    }

    public final int getIntVal() {
        return this.intVal;
    }

    @NotNull
    public final LogLevel getLogLevel() {
        return this.logLevel;
    }
}
