package com.pollfish.internal;

import android.net.Uri;
import com.google.common.net.HttpHeaders;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.pollfish.internal.l4;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.io.ByteStreamsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsKt;
import net.bytebuddy.description.type.TypeDescription;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes6.dex */
public final class h implements f {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public String f36878a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public String f36879b;

    /* loaded from: classes6.dex */
    public static final class a extends Lambda implements Function2<Integer, String, l4.a> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f36880a = new a();

        public a() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: invoke */
        public final l4.a mo1invoke(Integer num, String str) {
            int intValue = num.intValue();
            return new l4.a.j(" \n                    {\n                        code: " + intValue + ",\n                        message: " + str + "\n                    }\n                    ");
        }
    }

    /* loaded from: classes6.dex */
    public static final class b extends Lambda implements Function2<Integer, String, l4.a> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ URL f36882b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(URL url) {
            super(2);
            this.f36882b = url;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: invoke */
        public final l4.a mo1invoke(Integer num, String str) {
            return h.a(h.this, num.intValue(), this.f36882b.toString(), str);
        }
    }

    /* loaded from: classes6.dex */
    public static final class c extends Lambda implements Function2<Integer, String, l4.a> {

        /* renamed from: a  reason: collision with root package name */
        public static final c f36883a = new c();

        public c() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: invoke */
        public final l4.a mo1invoke(Integer num, String str) {
            return new l4.a.z(num.intValue(), str);
        }
    }

    /* loaded from: classes6.dex */
    public static final class d extends Lambda implements Function2<Integer, String, l4.a> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ URL f36885b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(URL url) {
            super(2);
            this.f36885b = url;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: invoke */
        public final l4.a mo1invoke(Integer num, String str) {
            return h.a(h.this, num.intValue(), this.f36885b.toString(), str);
        }
    }

    public h(@NotNull String str, @Nullable String str2) {
        this.f36878a = str;
        this.f36879b = str2;
    }

    public static final l4.a a(h hVar, int i4, String str, String str2) {
        hVar.getClass();
        if (i4 != 204) {
            if (i4 != 406) {
                if (i4 != 408) {
                    if (i4 != 500) {
                        if (i4 != 400) {
                            if (i4 != 401) {
                                return new l4.a.e0(str, i4, str2);
                            }
                            return l4.a.i0.f37034c;
                        }
                        return new l4.a.j0(str, str2);
                    }
                    return new l4.a.b0(str, str2);
                }
                return l4.a.c0.f37017c;
            }
            return l4.a.l0.f37043c;
        }
        return l4.a.r.f37058c;
    }

    @Override // com.pollfish.internal.f
    @NotNull
    public final l4<byte[]> b(@NotNull String str) {
        try {
            l4 a4 = a(new URL(str), "GET", null, null, a.f36880a);
            if (a4 instanceof l4.b) {
                return new l4.b(((l4.b) a4).a());
            }
            return (l4.a) a4;
        } catch (Exception unused) {
            return new l4.a.h0(str);
        }
    }

    @Override // com.pollfish.internal.f
    @NotNull
    public final l4<Unit> c(@NotNull String str) {
        Map mapOf;
        try {
            Uri.Builder buildUpon = Uri.parse(this.f36878a).buildUpon();
            buildUpon.appendEncodedPath("v1/report");
            URL url = new URL(buildUpon.build().toString());
            byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
            mapOf = kotlin.collections.s.mapOf(new Pair("Content-Type", "application/json"), new Pair("Content-Length", String.valueOf(bytes.length)));
            l4 a4 = a(url, "POST", mapOf, bytes, c.f36883a);
            if (a4 instanceof l4.b) {
                return new l4.b(Unit.INSTANCE);
            }
            return (l4.a) a4;
        } catch (Exception e4) {
            return new l4.a.n0(str, e4);
        }
    }

    @Override // com.pollfish.internal.f
    public final void a(@NotNull x4 x4Var) {
        this.f36878a = x4Var.c();
        this.f36879b = x4Var.m();
    }

    @Override // com.pollfish.internal.f
    @NotNull
    public final l4<String> a(@NotNull String str) {
        Map mapOf;
        try {
            Uri.Builder buildUpon = Uri.parse(this.f36878a).buildUpon();
            buildUpon.appendEncodedPath("v2/device/register/false").appendQueryParameter("json", str).appendQueryParameter("dontencrypt", "true");
            String str2 = this.f36879b;
            if (str2 != null) {
                buildUpon.appendQueryParameter("sig", str2);
            }
            URL url = new URL(buildUpon.build().toString());
            mapOf = kotlin.collections.s.mapOf(new Pair("Content-Type", "application/json"), new Pair(HttpHeaders.ACCEPT, "application/json"));
            l4 a4 = a(url, "GET", mapOf, null, new b(url));
            if (a4 instanceof l4.b) {
                return new l4.b(new String((byte[]) ((l4.b) a4).a(), Charsets.UTF_8));
            }
            return (l4.a) a4;
        } catch (Exception e4) {
            return new l4.a.m0(str, e4);
        }
    }

    @Override // com.pollfish.internal.f
    @NotNull
    public final l4<Unit> a(@NotNull String str, @NotNull String str2) {
        boolean startsWith$default;
        String substringBefore$default;
        try {
            Uri.Builder buildUpon = Uri.parse(this.f36878a).buildUpon();
            startsWith$default = kotlin.text.m.startsWith$default(str, RemoteSettings.FORWARD_SLASH_STRING, false, 2, null);
            substringBefore$default = StringsKt__StringsKt.substringBefore$default(startsWith$default ? StringsKt__StringsKt.removePrefix(str, (CharSequence) RemoteSettings.FORWARD_SLASH_STRING) : str, TypeDescription.Generic.OfWildcardType.SYMBOL, (String) null, 2, (Object) null);
            buildUpon.appendEncodedPath(substringBefore$default).appendQueryParameter("json", str2).appendQueryParameter("dontencrypt", "true");
            String str3 = this.f36879b;
            if (str3 != null) {
                buildUpon.appendQueryParameter("sig", str3);
            }
            URL url = new URL(buildUpon.build().toString());
            l4 a4 = a(url, "POST", null, null, new d(url));
            if (a4 instanceof l4.b) {
                return new l4.b(Unit.INSTANCE);
            }
            return (l4.a) a4;
        } catch (Exception e4) {
            return new l4.a.o0(str, str2, e4);
        }
    }

    public static l4 a(URL url, String str, Map map, byte[] bArr, Function2 function2) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod(str);
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setReadTimeout(10000);
            StringsKt__StringsKt.contains$default((CharSequence) url.toString(), (CharSequence) "staging", false, 2, (Object) null);
            if (map != null) {
                for (Map.Entry entry : map.entrySet()) {
                    httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                }
            }
            if (bArr != null) {
                try {
                    DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                    dataOutputStream.write(bArr);
                    dataOutputStream.close();
                } catch (Exception e4) {
                    return new l4.a.a0(new String(bArr, StandardCharsets.UTF_8), e4);
                }
            }
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() == 200) {
                byte[] readBytes = ByteStreamsKt.readBytes(httpURLConnection.getInputStream());
                httpURLConnection.disconnect();
                return new l4.b(readBytes);
            }
            httpURLConnection.disconnect();
            return (l4) function2.mo1invoke(Integer.valueOf(httpURLConnection.getResponseCode()), httpURLConnection.getResponseMessage());
        } catch (InterruptedIOException unused) {
            return l4.a.p.f37055c;
        } catch (IOException e5) {
            return new l4.a.i(e5);
        } catch (Exception e6) {
            return new l4.a.h(e6);
        }
    }
}
