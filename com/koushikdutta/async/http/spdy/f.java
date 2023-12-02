package com.koushikdutta.async.http.spdy;

import androidx.webkit.ProxyConfig;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.http.spdy.BitArray;
import com.sun.mail.imap.IMAPStore;
import io.grpc.internal.GrpcUtil;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HpackDraft08.java */
/* loaded from: classes6.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    private static final d[] f35546a;

    /* renamed from: b  reason: collision with root package name */
    private static final Map<com.koushikdutta.async.http.spdy.a, Integer> f35547b;

    /* compiled from: HpackDraft08.java */
    /* loaded from: classes6.dex */
    static final class a {

        /* renamed from: c  reason: collision with root package name */
        private int f35550c;

        /* renamed from: d  reason: collision with root package name */
        private int f35551d;

        /* renamed from: e  reason: collision with root package name */
        d[] f35552e;

        /* renamed from: f  reason: collision with root package name */
        int f35553f;

        /* renamed from: a  reason: collision with root package name */
        private final List<d> f35548a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        private final ByteBufferList f35549b = new ByteBufferList();

        /* renamed from: g  reason: collision with root package name */
        int f35554g = 0;

        /* renamed from: h  reason: collision with root package name */
        BitArray f35555h = new BitArray.FixedCapacity();

        /* renamed from: i  reason: collision with root package name */
        BitArray f35556i = new BitArray.FixedCapacity();

        /* renamed from: j  reason: collision with root package name */
        int f35557j = 0;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(int i4) {
            d[] dVarArr = new d[8];
            this.f35552e = dVarArr;
            this.f35553f = dVarArr.length - 1;
            this.f35550c = i4;
            this.f35551d = i4;
        }

        private void a() {
            int i4 = this.f35551d;
            int i5 = this.f35557j;
            if (i4 < i5) {
                if (i4 == 0) {
                    b();
                } else {
                    e(i5 - i4);
                }
            }
        }

        private void b() {
            c();
            Arrays.fill(this.f35552e, (Object) null);
            this.f35553f = this.f35552e.length - 1;
            this.f35554g = 0;
            this.f35557j = 0;
        }

        private void c() {
            this.f35555h.clear();
            this.f35556i.clear();
        }

        private int e(int i4) {
            int i5 = 0;
            if (i4 > 0) {
                int length = this.f35552e.length;
                while (true) {
                    length--;
                    if (length < this.f35553f || i4 <= 0) {
                        break;
                    }
                    int i6 = this.f35552e[length].f35543c;
                    i4 -= i6;
                    this.f35557j -= i6;
                    this.f35554g--;
                    i5++;
                }
                this.f35555h.shiftLeft(i5);
                this.f35556i.shiftLeft(i5);
                d[] dVarArr = this.f35552e;
                int i7 = this.f35553f;
                System.arraycopy(dVarArr, i7 + 1, dVarArr, i7 + 1 + i5, this.f35554g);
                this.f35553f += i5;
            }
            return i5;
        }

        private com.koushikdutta.async.http.spdy.a g(int i4) {
            if (j(i4)) {
                return f.f35546a[i4 - this.f35554g].f35541a;
            }
            return this.f35552e[h(i4)].f35541a;
        }

        private int h(int i4) {
            return this.f35553f + 1 + i4;
        }

        private void i(int i4, d dVar) {
            int i5 = dVar.f35543c;
            if (i4 != -1) {
                i5 -= this.f35552e[h(i4)].f35543c;
            }
            int i6 = this.f35551d;
            if (i5 > i6) {
                b();
                this.f35548a.add(dVar);
                return;
            }
            int e4 = e((this.f35557j + i5) - i6);
            if (i4 == -1) {
                int i7 = this.f35554g + 1;
                d[] dVarArr = this.f35552e;
                if (i7 > dVarArr.length) {
                    int length = dVarArr.length * 2;
                    d[] dVarArr2 = new d[length];
                    System.arraycopy(dVarArr, 0, dVarArr2, dVarArr.length, dVarArr.length);
                    if (length == 64) {
                        this.f35555h = ((BitArray.FixedCapacity) this.f35555h).toVariableCapacity();
                        this.f35556i = ((BitArray.FixedCapacity) this.f35556i).toVariableCapacity();
                    }
                    this.f35555h.shiftLeft(this.f35552e.length);
                    this.f35556i.shiftLeft(this.f35552e.length);
                    this.f35553f = this.f35552e.length - 1;
                    this.f35552e = dVarArr2;
                }
                int i8 = this.f35553f;
                this.f35553f = i8 - 1;
                this.f35555h.set(i8);
                this.f35552e[i8] = dVar;
                this.f35554g++;
            } else {
                int h4 = i4 + h(i4) + e4;
                this.f35555h.set(h4);
                this.f35552e[h4] = dVar;
            }
            this.f35557j += i5;
        }

        private boolean j(int i4) {
            if (i4 >= this.f35554g) {
                return true;
            }
            return false;
        }

        private int l() throws IOException {
            return this.f35549b.get() & 255;
        }

        private void o(int i4) throws IOException {
            if (j(i4)) {
                int i5 = i4 - this.f35554g;
                if (i5 <= f.f35546a.length - 1) {
                    d dVar = f.f35546a[i5];
                    if (this.f35551d == 0) {
                        this.f35548a.add(dVar);
                        return;
                    } else {
                        i(-1, dVar);
                        return;
                    }
                }
                throw new IOException("Header index too large " + (i5 + 1));
            }
            int h4 = h(i4);
            if (!this.f35555h.get(h4)) {
                this.f35548a.add(this.f35552e[h4]);
                this.f35556i.set(h4);
            }
            this.f35555h.toggle(h4);
        }

        private void q(int i4) throws IOException {
            i(-1, new d(g(i4), m()));
        }

        private void r() throws IOException {
            i(-1, new d(f.d(m()), m()));
        }

        private void s(int i4) throws IOException {
            this.f35548a.add(new d(g(i4), m()));
        }

        private void t() throws IOException {
            this.f35548a.add(new d(f.d(m()), m()));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void d() {
            int length = this.f35552e.length;
            while (true) {
                length--;
                if (length != this.f35553f) {
                    if (this.f35555h.get(length) && !this.f35556i.get(length)) {
                        this.f35548a.add(this.f35552e[length]);
                    }
                } else {
                    return;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public List<d> f() {
            ArrayList arrayList = new ArrayList(this.f35548a);
            this.f35548a.clear();
            this.f35556i.clear();
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void k(int i4) {
            this.f35550c = i4;
            this.f35551d = i4;
            a();
        }

        com.koushikdutta.async.http.spdy.a m() throws IOException {
            boolean z3;
            int l4 = l();
            if ((l4 & 128) == 128) {
                z3 = true;
            } else {
                z3 = false;
            }
            int p4 = p(l4, 127);
            if (z3) {
                return com.koushikdutta.async.http.spdy.a.e(h.d().c(this.f35549b.getBytes(p4)));
            }
            return com.koushikdutta.async.http.spdy.a.e(this.f35549b.getBytes(p4));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void n() throws IOException {
            while (this.f35549b.hasRemaining()) {
                int i4 = this.f35549b.get() & 255;
                if (i4 != 128) {
                    if ((i4 & 128) == 128) {
                        o(p(i4, 127) - 1);
                    } else if (i4 == 64) {
                        r();
                    } else if ((i4 & 64) == 64) {
                        q(p(i4, 63) - 1);
                    } else if ((i4 & 32) == 32) {
                        if ((i4 & 16) == 16) {
                            if ((i4 & 15) == 0) {
                                c();
                            } else {
                                throw new IOException("Invalid header table state change " + i4);
                            }
                        } else {
                            int p4 = p(i4, 15);
                            this.f35551d = p4;
                            if (p4 >= 0 && p4 <= this.f35550c) {
                                a();
                            } else {
                                throw new IOException("Invalid header table byte count " + this.f35551d);
                            }
                        }
                    } else if (i4 != 16 && i4 != 0) {
                        s(p(i4, 15) - 1);
                    } else {
                        t();
                    }
                } else {
                    throw new IOException("index == 0");
                }
            }
        }

        int p(int i4, int i5) throws IOException {
            int i6 = i4 & i5;
            if (i6 < i5) {
                return i6;
            }
            int i7 = 0;
            while (true) {
                int l4 = l();
                if ((l4 & 128) != 0) {
                    i5 += (l4 & 127) << i7;
                    i7 += 7;
                } else {
                    return i5 + (l4 << i7);
                }
            }
        }

        public void u(ByteBufferList byteBufferList) {
            byteBufferList.get(this.f35549b);
        }
    }

    /* compiled from: HpackDraft08.java */
    /* loaded from: classes6.dex */
    static final class b {
        void a(ByteBuffer byteBuffer, com.koushikdutta.async.http.spdy.a aVar) throws IOException {
            c(byteBuffer, aVar.g(), 127, 0);
            byteBuffer.put(aVar.i());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public ByteBufferList b(List<d> list) throws IOException {
            ByteBufferList byteBufferList = new ByteBufferList();
            ByteBuffer obtain = ByteBufferList.obtain(8192);
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                if (obtain.remaining() < obtain.capacity() / 2) {
                    obtain.flip();
                    byteBufferList.add(obtain);
                    obtain = ByteBufferList.obtain(obtain.capacity() * 2);
                }
                com.koushikdutta.async.http.spdy.a h4 = list.get(i4).f35541a.h();
                Integer num = (Integer) f.f35547b.get(h4);
                if (num != null) {
                    c(obtain, num.intValue() + 1, 15, 0);
                    a(obtain, list.get(i4).f35542b);
                } else {
                    obtain.put((byte) 0);
                    a(obtain, h4);
                    a(obtain, list.get(i4).f35542b);
                }
            }
            byteBufferList.add(obtain);
            return byteBufferList;
        }

        void c(ByteBuffer byteBuffer, int i4, int i5, int i6) throws IOException {
            if (i4 < i5) {
                byteBuffer.put((byte) (i4 | i6));
                return;
            }
            byteBuffer.put((byte) (i6 | i5));
            int i7 = i4 - i5;
            while (i7 >= 128) {
                byteBuffer.put((byte) (128 | (i7 & 127)));
                i7 >>>= 7;
            }
            byteBuffer.put((byte) i7);
        }
    }

    static {
        com.koushikdutta.async.http.spdy.a aVar = d.f35535e;
        com.koushikdutta.async.http.spdy.a aVar2 = d.f35536f;
        com.koushikdutta.async.http.spdy.a aVar3 = d.f35537g;
        com.koushikdutta.async.http.spdy.a aVar4 = d.f35534d;
        f35546a = new d[]{new d(d.f35538h, ""), new d(aVar, "GET"), new d(aVar, "POST"), new d(aVar2, RemoteSettings.FORWARD_SLASH_STRING), new d(aVar2, "/index.html"), new d(aVar3, "http"), new d(aVar3, ProxyConfig.MATCH_HTTPS), new d(aVar4, "200"), new d(aVar4, "204"), new d(aVar4, "206"), new d(aVar4, "304"), new d(aVar4, "400"), new d(aVar4, "404"), new d(aVar4, "500"), new d("accept-charset", ""), new d(GrpcUtil.CONTENT_ACCEPT_ENCODING, "gzip, deflate"), new d("accept-language", ""), new d("accept-ranges", ""), new d("accept", ""), new d("access-control-allow-origin", ""), new d("age", ""), new d("allow", ""), new d("authorization", ""), new d("cache-control", ""), new d("content-disposition", ""), new d(GrpcUtil.CONTENT_ENCODING, ""), new d("content-language", ""), new d("content-length", ""), new d("content-location", ""), new d("content-range", ""), new d("content-type", ""), new d("cookie", ""), new d(IMAPStore.ID_DATE, ""), new d("etag", ""), new d("expect", ""), new d(ClientCookie.EXPIRES_ATTR, ""), new d("from", ""), new d("host", ""), new d("if-match", ""), new d("if-modified-since", ""), new d("if-none-match", ""), new d("if-range", ""), new d("if-unmodified-since", ""), new d("last-modified", ""), new d("link", ""), new d(FirebaseAnalytics.Param.LOCATION, ""), new d("max-forwards", ""), new d("proxy-authenticate", ""), new d("proxy-authorization", ""), new d("range", ""), new d("referer", ""), new d("refresh", ""), new d("retry-after", ""), new d("server", ""), new d("set-cookie", ""), new d("strict-transport-security", ""), new d("transfer-encoding", ""), new d("user-agent", ""), new d("vary", ""), new d("via", ""), new d("www-authenticate", "")};
        f35547b = e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.koushikdutta.async.http.spdy.a d(com.koushikdutta.async.http.spdy.a aVar) throws IOException {
        int g4 = aVar.g();
        for (int i4 = 0; i4 < g4; i4++) {
            byte b4 = aVar.b(i4);
            if (b4 >= 65 && b4 <= 90) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + aVar.j());
            }
        }
        return aVar;
    }

    private static Map<com.koushikdutta.async.http.spdy.a, Integer> e() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(f35546a.length);
        int i4 = 0;
        while (true) {
            d[] dVarArr = f35546a;
            if (i4 < dVarArr.length) {
                if (!linkedHashMap.containsKey(dVarArr[i4].f35541a)) {
                    linkedHashMap.put(dVarArr[i4].f35541a, Integer.valueOf(i4));
                }
                i4++;
            } else {
                return Collections.unmodifiableMap(linkedHashMap);
            }
        }
    }
}
