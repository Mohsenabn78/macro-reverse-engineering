package com.arlosoft.macrodroid.database.room;

import java.util.NoSuchElementException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* compiled from: SystemLogEntry.kt */
/* loaded from: classes3.dex */
public enum LogLevel {
    DEBUG(0),
    VERBOSE(10),
    INFO(20),
    WARNING(30),
    ERROR(40);
    
    @NotNull
    public static final Companion Companion = new Companion(null);
    private final int levelInt;

    /* compiled from: SystemLogEntry.kt */
    @SourceDebugExtension({"SMAP\nSystemLogEntry.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SystemLogEntry.kt\ncom/arlosoft/macrodroid/database/room/LogLevel$Companion\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,49:1\n1109#2,2:50\n*S KotlinDebug\n*F\n+ 1 SystemLogEntry.kt\ncom/arlosoft/macrodroid/database/room/LogLevel$Companion\n*L\n18#1:50,2\n*E\n"})
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final LogLevel fromIntLevel(int i4) {
            LogLevel[] values;
            boolean z3;
            for (LogLevel logLevel : LogLevel.values()) {
                if (logLevel.getLevelInt() == i4) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    return logLevel;
                }
            }
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }
    }

    LogLevel(int i4) {
        this.levelInt = i4;
    }

    @JvmStatic
    @NotNull
    public static final LogLevel fromIntLevel(int i4) {
        return Companion.fromIntLevel(i4);
    }

    public final int getLevelInt() {
        return this.levelInt;
    }
}
