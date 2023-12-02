package com.koushikdutta.async.http.cache;

import android.net.Uri;
import com.google.common.net.HttpHeaders;
import com.koushikdutta.async.http.HttpDate;
import com.koushikdutta.async.http.cache.HeaderParser;
import java.util.Date;
import org.apache.http.cookie.ClientCookie;

/* compiled from: RequestHeaders.java */
/* loaded from: classes6.dex */
final class c {

    /* renamed from: a  reason: collision with root package name */
    private final Uri f35209a;

    /* renamed from: b  reason: collision with root package name */
    private final b f35210b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f35211c;

    /* renamed from: d  reason: collision with root package name */
    private int f35212d = -1;

    /* renamed from: e  reason: collision with root package name */
    private int f35213e = -1;

    /* renamed from: f  reason: collision with root package name */
    private int f35214f = -1;

    /* renamed from: g  reason: collision with root package name */
    private boolean f35215g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f35216h;

    /* renamed from: i  reason: collision with root package name */
    private int f35217i;

    /* renamed from: j  reason: collision with root package name */
    private String f35218j;

    /* renamed from: k  reason: collision with root package name */
    private String f35219k;

    /* renamed from: l  reason: collision with root package name */
    private String f35220l;

    /* renamed from: m  reason: collision with root package name */
    private String f35221m;

    /* renamed from: n  reason: collision with root package name */
    private String f35222n;

    /* renamed from: o  reason: collision with root package name */
    private String f35223o;

    /* renamed from: p  reason: collision with root package name */
    private String f35224p;

    /* renamed from: q  reason: collision with root package name */
    private String f35225q;

    /* renamed from: r  reason: collision with root package name */
    private String f35226r;

    /* compiled from: RequestHeaders.java */
    /* loaded from: classes6.dex */
    class a implements HeaderParser.CacheControlHandler {
        a() {
        }

        @Override // com.koushikdutta.async.http.cache.HeaderParser.CacheControlHandler
        public void handle(String str, String str2) {
            if (str.equalsIgnoreCase("no-cache")) {
                c.this.f35211c = true;
            } else if (str.equalsIgnoreCase(ClientCookie.MAX_AGE_ATTR)) {
                c.this.f35212d = HeaderParser.b(str2);
            } else if (str.equalsIgnoreCase("max-stale")) {
                c.this.f35213e = HeaderParser.b(str2);
            } else if (str.equalsIgnoreCase("min-fresh")) {
                c.this.f35214f = HeaderParser.b(str2);
            } else if (str.equalsIgnoreCase("only-if-cached")) {
                c.this.f35215g = true;
            }
        }
    }

    public c(Uri uri, b bVar) {
        this.f35217i = -1;
        this.f35209a = uri;
        this.f35210b = bVar;
        a aVar = new a();
        for (int i4 = 0; i4 < bVar.l(); i4++) {
            String g4 = bVar.g(i4);
            String k4 = bVar.k(i4);
            if (HttpHeaders.CACHE_CONTROL.equalsIgnoreCase(g4)) {
                HeaderParser.a(k4, aVar);
            } else if (HttpHeaders.PRAGMA.equalsIgnoreCase(g4)) {
                if (k4.equalsIgnoreCase("no-cache")) {
                    this.f35211c = true;
                }
            } else if (HttpHeaders.IF_NONE_MATCH.equalsIgnoreCase(g4)) {
                this.f35225q = k4;
            } else if (HttpHeaders.IF_MODIFIED_SINCE.equalsIgnoreCase(g4)) {
                this.f35224p = k4;
            } else if ("Authorization".equalsIgnoreCase(g4)) {
                this.f35216h = true;
            } else if ("Content-Length".equalsIgnoreCase(g4)) {
                try {
                    this.f35217i = Integer.parseInt(k4);
                } catch (NumberFormatException unused) {
                }
            } else if ("Transfer-Encoding".equalsIgnoreCase(g4)) {
                this.f35218j = k4;
            } else if ("User-Agent".equalsIgnoreCase(g4)) {
                this.f35219k = k4;
            } else if ("Host".equalsIgnoreCase(g4)) {
                this.f35220l = k4;
            } else if ("Connection".equalsIgnoreCase(g4)) {
                this.f35221m = k4;
            } else if (HttpHeaders.ACCEPT_ENCODING.equalsIgnoreCase(g4)) {
                this.f35222n = k4;
            } else if ("Content-Type".equalsIgnoreCase(g4)) {
                this.f35223o = k4;
            } else if ("Proxy-Authorization".equalsIgnoreCase(g4)) {
                this.f35226r = k4;
            }
        }
    }

    public b f() {
        return this.f35210b;
    }

    public int g() {
        return this.f35212d;
    }

    public int h() {
        return this.f35213e;
    }

    public int i() {
        return this.f35214f;
    }

    public boolean j() {
        return this.f35216h;
    }

    public boolean k() {
        if (this.f35224p == null && this.f35225q == null) {
            return false;
        }
        return true;
    }

    public boolean l() {
        return this.f35211c;
    }

    public void m(Date date) {
        if (this.f35224p != null) {
            this.f35210b.m(HttpHeaders.IF_MODIFIED_SINCE);
        }
        String format = HttpDate.format(date);
        this.f35210b.a(HttpHeaders.IF_MODIFIED_SINCE, format);
        this.f35224p = format;
    }

    public void n(String str) {
        if (this.f35225q != null) {
            this.f35210b.m(HttpHeaders.IF_NONE_MATCH);
        }
        this.f35210b.a(HttpHeaders.IF_NONE_MATCH, str);
        this.f35225q = str;
    }
}
