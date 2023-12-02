package com.google.api.client.util.escape;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/* loaded from: classes5.dex */
public final class CharEscapers {

    /* renamed from: a  reason: collision with root package name */
    private static final Escaper f26156a = new PercentEscaper("-_.*", true);

    /* renamed from: b  reason: collision with root package name */
    private static final Escaper f26157b = new PercentEscaper("-_.!~*'()@:$&,;=", false);

    /* renamed from: c  reason: collision with root package name */
    private static final Escaper f26158c = new PercentEscaper(PercentEscaper.SAFE_PLUS_RESERVED_CHARS_URLENCODER, false);

    /* renamed from: d  reason: collision with root package name */
    private static final Escaper f26159d = new PercentEscaper(PercentEscaper.SAFEUSERINFOCHARS_URLENCODER, false);

    /* renamed from: e  reason: collision with root package name */
    private static final Escaper f26160e = new PercentEscaper("-_.!~*'()@:$,;/?:", false);

    private CharEscapers() {
    }

    public static String decodeUri(String str) {
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e4) {
            throw new RuntimeException(e4);
        }
    }

    public static String escapeUri(String str) {
        return f26156a.escape(str);
    }

    public static String escapeUriPath(String str) {
        return f26157b.escape(str);
    }

    public static String escapeUriPathWithoutReserved(String str) {
        return f26158c.escape(str);
    }

    public static String escapeUriQuery(String str) {
        return f26160e.escape(str);
    }

    public static String escapeUriUserInfo(String str) {
        return f26159d.escape(str);
    }
}
