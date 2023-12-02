package com.koushikdutta.async.http.spdy;

import com.google.mlkit.nl.translate.TranslateLanguage;
import com.koushikdutta.async.http.Protocol;
import java.util.List;
import java.util.Locale;

/* compiled from: SpdyTransport.java */
/* loaded from: classes6.dex */
final class l {

    /* renamed from: a  reason: collision with root package name */
    private static final List<String> f35628a = m.a("connection", "host", "keep-alive", "proxy-connection", "transfer-encoding");

    /* renamed from: b  reason: collision with root package name */
    private static final List<String> f35629b = m.a("connection", "host", "keep-alive", "proxy-connection", TranslateLanguage.TELUGU, "transfer-encoding", "encoding", "upgrade");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Protocol protocol, String str) {
        if (protocol == Protocol.SPDY_3) {
            return f35628a.contains(str.toLowerCase(Locale.US));
        }
        if (protocol == Protocol.HTTP_2) {
            return f35629b.contains(str.toLowerCase(Locale.US));
        }
        throw new AssertionError(protocol);
    }
}
