package com.koushikdutta.async.http.spdy;

/* compiled from: ErrorCode.java */
/* loaded from: classes6.dex */
enum b {
    NO_ERROR(0, -1, 0),
    PROTOCOL_ERROR(1, 1, 1),
    INVALID_STREAM(1, 2, -1),
    UNSUPPORTED_VERSION(1, 4, -1),
    STREAM_IN_USE(1, 8, -1),
    STREAM_ALREADY_CLOSED(1, 9, -1),
    INTERNAL_ERROR(2, 6, 2),
    FLOW_CONTROL_ERROR(3, 7, -1),
    STREAM_CLOSED(5, -1, -1),
    FRAME_TOO_LARGE(6, 11, -1),
    REFUSED_STREAM(7, 3, -1),
    CANCEL(8, 5, -1),
    COMPRESSION_ERROR(9, -1, -1),
    CONNECT_ERROR(10, -1, -1),
    ENHANCE_YOUR_CALM(11, -1, -1),
    INADEQUATE_SECURITY(12, -1, -1),
    INVALID_CREDENTIALS(-1, 10, -1);
    
    public final int httpCode;
    public final int spdyGoAwayCode;
    public final int spdyRstCode;

    b(int i4, int i5, int i6) {
        this.httpCode = i4;
        this.spdyRstCode = i5;
        this.spdyGoAwayCode = i6;
    }

    public static b a(int i4) {
        b[] values;
        for (b bVar : values()) {
            if (bVar.httpCode == i4) {
                return bVar;
            }
        }
        return null;
    }

    public static b b(int i4) {
        b[] values;
        for (b bVar : values()) {
            if (bVar.spdyRstCode == i4) {
                return bVar;
            }
        }
        return null;
    }

    public static b c(int i4) {
        b[] values;
        for (b bVar : values()) {
            if (bVar.spdyGoAwayCode == i4) {
                return bVar;
            }
        }
        return null;
    }
}
