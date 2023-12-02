package com.koushikdutta.async.http.spdy;

/* loaded from: classes6.dex */
public enum HeadersMode {
    SPDY_SYN_STREAM,
    SPDY_REPLY,
    SPDY_HEADERS,
    HTTP_20_HEADERS;

    public boolean failIfHeadersAbsent() {
        if (this == SPDY_HEADERS) {
            return true;
        }
        return false;
    }

    public boolean failIfHeadersPresent() {
        if (this == SPDY_REPLY) {
            return true;
        }
        return false;
    }

    public boolean failIfStreamAbsent() {
        if (this != SPDY_REPLY && this != SPDY_HEADERS) {
            return false;
        }
        return true;
    }

    public boolean failIfStreamPresent() {
        if (this == SPDY_SYN_STREAM) {
            return true;
        }
        return false;
    }
}
