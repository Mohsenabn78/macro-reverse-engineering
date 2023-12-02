package com.koushikdutta.async.http.spdy;

import java.util.Locale;
import okhttp3.internal.http2.Header;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Header.java */
/* loaded from: classes6.dex */
public final class d {

    /* renamed from: d  reason: collision with root package name */
    public static final a f35534d = a.a(Header.RESPONSE_STATUS_UTF8);

    /* renamed from: e  reason: collision with root package name */
    public static final a f35535e = a.a(Header.TARGET_METHOD_UTF8);

    /* renamed from: f  reason: collision with root package name */
    public static final a f35536f = a.a(Header.TARGET_PATH_UTF8);

    /* renamed from: g  reason: collision with root package name */
    public static final a f35537g = a.a(Header.TARGET_SCHEME_UTF8);

    /* renamed from: h  reason: collision with root package name */
    public static final a f35538h = a.a(Header.TARGET_AUTHORITY_UTF8);

    /* renamed from: i  reason: collision with root package name */
    public static final a f35539i = a.a(":host");

    /* renamed from: j  reason: collision with root package name */
    public static final a f35540j = a.a(":version");

    /* renamed from: a  reason: collision with root package name */
    public final a f35541a;

    /* renamed from: b  reason: collision with root package name */
    public final a f35542b;

    /* renamed from: c  reason: collision with root package name */
    final int f35543c;

    public d(String str, String str2) {
        this(a.a(str), a.a(str2));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (!this.f35541a.equals(dVar.f35541a) || !this.f35542b.equals(dVar.f35542b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((527 + this.f35541a.hashCode()) * 31) + this.f35542b.hashCode();
    }

    public String toString() {
        return String.format(Locale.ENGLISH, "%s: %s", this.f35541a.j(), this.f35542b.j());
    }

    public d(a aVar, String str) {
        this(aVar, a.a(str));
    }

    public d(a aVar, a aVar2) {
        this.f35541a = aVar;
        this.f35542b = aVar2;
        this.f35543c = aVar.g() + 32 + aVar2.g();
    }
}
