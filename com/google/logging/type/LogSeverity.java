package com.google.logging.type;

import com.google.protobuf.Internal;

/* loaded from: classes5.dex */
public enum LogSeverity implements Internal.EnumLite {
    DEFAULT(0),
    DEBUG(100),
    INFO(200),
    NOTICE(300),
    WARNING(400),
    ERROR(500),
    CRITICAL(600),
    ALERT(700),
    EMERGENCY(EMERGENCY_VALUE),
    UNRECOGNIZED(-1);
    
    public static final int ALERT_VALUE = 700;
    public static final int CRITICAL_VALUE = 600;
    public static final int DEBUG_VALUE = 100;
    public static final int DEFAULT_VALUE = 0;
    public static final int EMERGENCY_VALUE = 800;
    public static final int ERROR_VALUE = 500;
    public static final int INFO_VALUE = 200;
    public static final int NOTICE_VALUE = 300;
    public static final int WARNING_VALUE = 400;

    /* renamed from: a  reason: collision with root package name */
    private static final Internal.EnumLiteMap<LogSeverity> f32905a = new Internal.EnumLiteMap<LogSeverity>() { // from class: com.google.logging.type.LogSeverity.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        /* renamed from: a */
        public LogSeverity findValueByNumber(int i4) {
            return LogSeverity.forNumber(i4);
        }
    };
    private final int value;

    /* loaded from: classes5.dex */
    private static final class LogSeverityVerifier implements Internal.EnumVerifier {

        /* renamed from: a  reason: collision with root package name */
        static final Internal.EnumVerifier f32907a = new LogSeverityVerifier();

        private LogSeverityVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i4) {
            if (LogSeverity.forNumber(i4) != null) {
                return true;
            }
            return false;
        }
    }

    LogSeverity(int i4) {
        this.value = i4;
    }

    public static LogSeverity forNumber(int i4) {
        if (i4 != 0) {
            if (i4 != 100) {
                if (i4 != 200) {
                    if (i4 != 300) {
                        if (i4 != 400) {
                            if (i4 != 500) {
                                if (i4 != 600) {
                                    if (i4 != 700) {
                                        if (i4 != 800) {
                                            return null;
                                        }
                                        return EMERGENCY;
                                    }
                                    return ALERT;
                                }
                                return CRITICAL;
                            }
                            return ERROR;
                        }
                        return WARNING;
                    }
                    return NOTICE;
                }
                return INFO;
            }
            return DEBUG;
        }
        return DEFAULT;
    }

    public static Internal.EnumLiteMap<LogSeverity> internalGetValueMap() {
        return f32905a;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return LogSeverityVerifier.f32907a;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.value;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    @Deprecated
    public static LogSeverity valueOf(int i4) {
        return forNumber(i4);
    }
}
