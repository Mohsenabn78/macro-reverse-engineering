package com.koushikdutta.async.http;

import java.util.Hashtable;
import java.util.Locale;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes6.dex */
public class Protocol {
    public static final Protocol HTTP_1_0;
    public static final Protocol HTTP_1_1;
    public static final Protocol HTTP_2;
    public static final Protocol SPDY_3;

    /* renamed from: a  reason: collision with root package name */
    private static final Hashtable<String, Protocol> f35070a;

    /* renamed from: b  reason: collision with root package name */
    private static final /* synthetic */ Protocol[] f35071b;
    private final String protocol;

    /* loaded from: classes6.dex */
    enum a extends Protocol {
        a(String str, int i4, String str2) {
            super(str, i4, str2, null);
        }

        @Override // com.koushikdutta.async.http.Protocol
        public boolean needsSpdyConnection() {
            return true;
        }
    }

    static {
        Protocol protocol = new Protocol("HTTP_1_0", 0, "http/1.0");
        HTTP_1_0 = protocol;
        Protocol protocol2 = new Protocol("HTTP_1_1", 1, "http/1.1");
        HTTP_1_1 = protocol2;
        a aVar = new a("SPDY_3", 2, "spdy/3.1");
        SPDY_3 = aVar;
        Protocol protocol3 = new Protocol("HTTP_2", 3, "h2-13") { // from class: com.koushikdutta.async.http.Protocol.b
            @Override // com.koushikdutta.async.http.Protocol
            public boolean needsSpdyConnection() {
                return true;
            }
        };
        HTTP_2 = protocol3;
        f35071b = new Protocol[]{protocol, protocol2, aVar, protocol3};
        Hashtable<String, Protocol> hashtable = new Hashtable<>();
        f35070a = hashtable;
        hashtable.put(protocol.toString(), protocol);
        hashtable.put(protocol2.toString(), protocol2);
        hashtable.put(aVar.toString(), aVar);
        hashtable.put(protocol3.toString(), protocol3);
    }

    /* synthetic */ Protocol(String str, int i4, String str2, a aVar) {
        this(str, i4, str2);
    }

    public static Protocol get(String str) {
        if (str == null) {
            return null;
        }
        return f35070a.get(str.toLowerCase(Locale.US));
    }

    public static Protocol valueOf(String str) {
        return (Protocol) Enum.valueOf(Protocol.class, str);
    }

    public static Protocol[] values() {
        return (Protocol[]) f35071b.clone();
    }

    public boolean needsSpdyConnection() {
        return false;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.protocol;
    }

    private Protocol(String str, int i4, String str2) {
        this.protocol = str2;
    }
}
