package com.koushikdutta.async.http.cache;

import android.net.Uri;
import com.google.common.net.HttpHeaders;
import com.koushikdutta.async.http.HttpDate;
import com.koushikdutta.async.http.cache.HeaderParser;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import org.apache.http.cookie.ClientCookie;

/* compiled from: ResponseHeaders.java */
/* loaded from: classes6.dex */
final class d {

    /* renamed from: a  reason: collision with root package name */
    private final Uri f35228a;

    /* renamed from: b  reason: collision with root package name */
    private final b f35229b;

    /* renamed from: c  reason: collision with root package name */
    private Date f35230c;

    /* renamed from: d  reason: collision with root package name */
    private Date f35231d;

    /* renamed from: e  reason: collision with root package name */
    private Date f35232e;

    /* renamed from: f  reason: collision with root package name */
    private long f35233f;

    /* renamed from: g  reason: collision with root package name */
    private long f35234g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f35235h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f35236i;

    /* renamed from: j  reason: collision with root package name */
    private int f35237j = -1;

    /* renamed from: k  reason: collision with root package name */
    private int f35238k = -1;

    /* renamed from: l  reason: collision with root package name */
    private boolean f35239l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f35240m;

    /* renamed from: n  reason: collision with root package name */
    private String f35241n;

    /* renamed from: o  reason: collision with root package name */
    private int f35242o;

    /* renamed from: p  reason: collision with root package name */
    private Set<String> f35243p;

    /* renamed from: q  reason: collision with root package name */
    private String f35244q;

    /* renamed from: r  reason: collision with root package name */
    private String f35245r;

    /* renamed from: s  reason: collision with root package name */
    private long f35246s;

    /* renamed from: t  reason: collision with root package name */
    private String f35247t;

    /* renamed from: u  reason: collision with root package name */
    private String f35248u;

    /* renamed from: v  reason: collision with root package name */
    private String f35249v;

    /* compiled from: ResponseHeaders.java */
    /* loaded from: classes6.dex */
    class a implements HeaderParser.CacheControlHandler {
        a() {
        }

        @Override // com.koushikdutta.async.http.cache.HeaderParser.CacheControlHandler
        public void handle(String str, String str2) {
            if (str.equalsIgnoreCase("no-cache")) {
                d.this.f35235h = true;
            } else if (str.equalsIgnoreCase("no-store")) {
                d.this.f35236i = true;
            } else if (str.equalsIgnoreCase(ClientCookie.MAX_AGE_ATTR)) {
                d.this.f35237j = HeaderParser.b(str2);
            } else if (str.equalsIgnoreCase("s-maxage")) {
                d.this.f35238k = HeaderParser.b(str2);
            } else if (str.equalsIgnoreCase("public")) {
                d.this.f35239l = true;
            } else if (str.equalsIgnoreCase("must-revalidate")) {
                d.this.f35240m = true;
            }
        }
    }

    public d(Uri uri, b bVar) {
        this.f35242o = -1;
        this.f35243p = Collections.emptySet();
        this.f35246s = -1L;
        this.f35228a = uri;
        this.f35229b = bVar;
        a aVar = new a();
        for (int i4 = 0; i4 < bVar.l(); i4++) {
            String g4 = bVar.g(i4);
            String k4 = bVar.k(i4);
            if (HttpHeaders.CACHE_CONTROL.equalsIgnoreCase(g4)) {
                HeaderParser.a(k4, aVar);
            } else if ("Date".equalsIgnoreCase(g4)) {
                this.f35230c = HttpDate.parse(k4);
            } else if (HttpHeaders.EXPIRES.equalsIgnoreCase(g4)) {
                this.f35232e = HttpDate.parse(k4);
            } else if (HttpHeaders.LAST_MODIFIED.equalsIgnoreCase(g4)) {
                this.f35231d = HttpDate.parse(k4);
            } else if (HttpHeaders.ETAG.equalsIgnoreCase(g4)) {
                this.f35241n = k4;
            } else if (HttpHeaders.PRAGMA.equalsIgnoreCase(g4)) {
                if (k4.equalsIgnoreCase("no-cache")) {
                    this.f35235h = true;
                }
            } else if (HttpHeaders.AGE.equalsIgnoreCase(g4)) {
                this.f35242o = HeaderParser.b(k4);
            } else if (HttpHeaders.VARY.equalsIgnoreCase(g4)) {
                if (this.f35243p.isEmpty()) {
                    this.f35243p = new TreeSet(String.CASE_INSENSITIVE_ORDER);
                }
                for (String str : k4.split(",")) {
                    this.f35243p.add(str.trim().toLowerCase(Locale.US));
                }
            } else if ("Content-Encoding".equalsIgnoreCase(g4)) {
                this.f35244q = k4;
            } else if ("Transfer-Encoding".equalsIgnoreCase(g4)) {
                this.f35245r = k4;
            } else if ("Content-Length".equalsIgnoreCase(g4)) {
                try {
                    this.f35246s = Long.parseLong(k4);
                } catch (NumberFormatException unused) {
                }
            } else if ("Connection".equalsIgnoreCase(g4)) {
                this.f35247t = k4;
            } else if ("Proxy-Authenticate".equalsIgnoreCase(g4)) {
                this.f35248u = k4;
            } else if ("WWW-Authenticate".equalsIgnoreCase(g4)) {
                this.f35249v = k4;
            } else if ("X-Android-Sent-Millis".equalsIgnoreCase(g4)) {
                this.f35233f = Long.parseLong(k4);
            } else if ("X-Android-Received-Millis".equalsIgnoreCase(g4)) {
                this.f35234g = Long.parseLong(k4);
            }
        }
    }

    private long i(long j4) {
        Date date = this.f35230c;
        long j5 = 0;
        if (date != null) {
            j5 = Math.max(0L, this.f35234g - date.getTime());
        }
        int i4 = this.f35242o;
        if (i4 != -1) {
            j5 = Math.max(j5, TimeUnit.SECONDS.toMillis(i4));
        }
        long j6 = this.f35234g;
        return j5 + (j6 - this.f35233f) + (j4 - j6);
    }

    private long j() {
        long j4;
        long j5;
        int i4 = this.f35237j;
        if (i4 != -1) {
            return TimeUnit.SECONDS.toMillis(i4);
        }
        if (this.f35232e != null) {
            Date date = this.f35230c;
            if (date != null) {
                j5 = date.getTime();
            } else {
                j5 = this.f35234g;
            }
            long time = this.f35232e.getTime() - j5;
            if (time <= 0) {
                return 0L;
            }
            return time;
        } else if (this.f35231d == null || this.f35228a.getEncodedQuery() != null) {
            return 0L;
        } else {
            Date date2 = this.f35230c;
            if (date2 != null) {
                j4 = date2.getTime();
            } else {
                j4 = this.f35233f;
            }
            long time2 = j4 - this.f35231d.getTime();
            if (time2 <= 0) {
                return 0L;
            }
            return time2 / 10;
        }
    }

    private static boolean n(String str) {
        if (!str.equalsIgnoreCase("Connection") && !str.equalsIgnoreCase("Keep-Alive") && !str.equalsIgnoreCase("Proxy-Authenticate") && !str.equalsIgnoreCase("Proxy-Authorization") && !str.equalsIgnoreCase(HttpHeaders.TE) && !str.equalsIgnoreCase("Trailers") && !str.equalsIgnoreCase("Transfer-Encoding") && !str.equalsIgnoreCase(HttpHeaders.UPGRADE)) {
            return true;
        }
        return false;
    }

    private boolean o() {
        if (this.f35237j == -1 && this.f35232e == null) {
            return true;
        }
        return false;
    }

    public e g(long j4, c cVar) {
        long j5;
        if (!m(cVar)) {
            return e.NETWORK;
        }
        if (!cVar.l() && !cVar.k()) {
            long i4 = i(j4);
            long j6 = j();
            if (cVar.g() != -1) {
                j6 = Math.min(j6, TimeUnit.SECONDS.toMillis(cVar.g()));
            }
            long j7 = 0;
            if (cVar.i() != -1) {
                j5 = TimeUnit.SECONDS.toMillis(cVar.i());
            } else {
                j5 = 0;
            }
            if (!this.f35240m && cVar.h() != -1) {
                j7 = TimeUnit.SECONDS.toMillis(cVar.h());
            }
            if (!this.f35235h) {
                long j8 = j5 + i4;
                if (j8 < j7 + j6) {
                    if (j8 >= j6) {
                        this.f35229b.a(HttpHeaders.WARNING, "110 HttpURLConnection \"Response is stale\"");
                    }
                    if (i4 > 86400000 && o()) {
                        this.f35229b.a(HttpHeaders.WARNING, "113 HttpURLConnection \"Heuristic expiration\"");
                    }
                    return e.CACHE;
                }
            }
            String str = this.f35241n;
            if (str != null) {
                cVar.n(str);
            } else {
                Date date = this.f35231d;
                if (date != null) {
                    cVar.m(date);
                } else {
                    Date date2 = this.f35230c;
                    if (date2 != null) {
                        cVar.m(date2);
                    }
                }
            }
            if (cVar.k()) {
                return e.CONDITIONAL_CACHE;
            }
            return e.NETWORK;
        }
        return e.NETWORK;
    }

    public d h(d dVar) {
        b bVar = new b();
        for (int i4 = 0; i4 < this.f35229b.l(); i4++) {
            String g4 = this.f35229b.g(i4);
            String k4 = this.f35229b.k(i4);
            if ((!g4.equals(HttpHeaders.WARNING) || !k4.startsWith("1")) && (!n(g4) || dVar.f35229b.e(g4) == null)) {
                bVar.a(g4, k4);
            }
        }
        for (int i5 = 0; i5 < dVar.f35229b.l(); i5++) {
            String g5 = dVar.f35229b.g(i5);
            if (n(g5)) {
                bVar.a(g5, dVar.f35229b.k(i5));
            }
        }
        return new d(this.f35228a, bVar);
    }

    public b k() {
        return this.f35229b;
    }

    public Set<String> l() {
        return this.f35243p;
    }

    public boolean m(c cVar) {
        int h4 = this.f35229b.h();
        if (h4 != 200 && h4 != 203 && h4 != 300 && h4 != 301 && h4 != 410) {
            return false;
        }
        if ((cVar.j() && !this.f35239l && !this.f35240m && this.f35238k == -1) || this.f35236i) {
            return false;
        }
        return true;
    }

    public void p(long j4, long j5) {
        this.f35233f = j4;
        this.f35229b.a("X-Android-Sent-Millis", Long.toString(j4));
        this.f35234g = j5;
        this.f35229b.a("X-Android-Received-Millis", Long.toString(j5));
    }

    public boolean q(d dVar) {
        Date date;
        if (dVar.f35229b.h() == 304) {
            return true;
        }
        if (this.f35231d != null && (date = dVar.f35231d) != null && date.getTime() < this.f35231d.getTime()) {
            return true;
        }
        return false;
    }

    public boolean r(Map<String, List<String>> map, Map<String, List<String>> map2) {
        for (String str : this.f35243p) {
            if (!com.koushikdutta.async.http.cache.a.a(map.get(str), map2.get(str))) {
                return false;
            }
        }
        return true;
    }
}
