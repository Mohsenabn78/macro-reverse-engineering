package com.pollfish.internal;

import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import com.pollfish.internal.f4;
import java.io.IOException;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes6.dex */
public abstract class l4<R> {

    /* loaded from: classes6.dex */
    public static abstract class a extends l4 {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        public final Throwable f37009a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        public final f4.a f37010b;

        /* renamed from: com.pollfish.internal.l4$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static final class C0214a extends a {
            public final boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof C0214a)) {
                    return false;
                }
                ((C0214a) obj).getClass();
                if (Intrinsics.areEqual((Object) null, (Object) null)) {
                    return true;
                }
                return false;
            }

            public final int hashCode() {
                throw null;
            }

            @Override // com.pollfish.internal.l4
            @NotNull
            public final String toString() {
                return "AdvertisingIdGeneration(t=" + ((Object) null) + ')';
            }
        }

        /* loaded from: classes6.dex */
        public static final class a0 extends a {
            @NotNull

            /* renamed from: c  reason: collision with root package name */
            public final String f37011c;
            @NotNull

            /* renamed from: d  reason: collision with root package name */
            public final Throwable f37012d;

            public a0(@NotNull String str, @NotNull Exception exc) {
                super(exc, (f4.a) null, 2);
                this.f37011c = str;
                this.f37012d = exc;
            }

            @NotNull
            public final String e() {
                return this.f37011c;
            }

            public final boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof a0)) {
                    return false;
                }
                a0 a0Var = (a0) obj;
                if (Intrinsics.areEqual(this.f37011c, a0Var.f37011c) && Intrinsics.areEqual(this.f37012d, a0Var.f37012d)) {
                    return true;
                }
                return false;
            }

            @NotNull
            public final Throwable f() {
                return this.f37012d;
            }

            public final int hashCode() {
                return this.f37012d.hashCode() + (this.f37011c.hashCode() * 31);
            }

            @Override // com.pollfish.internal.l4
            @NotNull
            public final String toString() {
                StringBuilder a4 = u4.a("ReportRequestBodyError(body=");
                a4.append(this.f37011c);
                a4.append(", t=");
                a4.append(this.f37012d);
                a4.append(')');
                return a4.toString();
            }
        }

        /* loaded from: classes6.dex */
        public static final class b extends a {
            @NotNull

            /* renamed from: c  reason: collision with root package name */
            public final Throwable f37013c;

            public b(@NotNull Exception exc) {
                super(exc, (f4.a) null, 2);
                this.f37013c = exc;
            }

            @NotNull
            public final Throwable e() {
                return this.f37013c;
            }

            public final boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if ((obj instanceof b) && Intrinsics.areEqual(this.f37013c, ((b) obj).f37013c)) {
                    return true;
                }
                return false;
            }

            public final int hashCode() {
                return this.f37013c.hashCode();
            }

            @Override // com.pollfish.internal.l4
            @NotNull
            public final String toString() {
                StringBuilder a4 = u4.a("AdvertisingIdRetrieval(t=");
                a4.append(this.f37013c);
                a4.append(')');
                return a4.toString();
            }
        }

        /* loaded from: classes6.dex */
        public static final class b0 extends a {
            @NotNull

            /* renamed from: c  reason: collision with root package name */
            public final String f37014c;
            @NotNull

            /* renamed from: d  reason: collision with root package name */
            public final String f37015d;

            public b0(@NotNull String str, @NotNull String str2) {
                super((Throwable) null, (f4.a) null, 3);
                this.f37014c = str;
                this.f37015d = str2;
            }

            @NotNull
            public final String e() {
                return this.f37015d;
            }

            public final boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof b0)) {
                    return false;
                }
                b0 b0Var = (b0) obj;
                if (Intrinsics.areEqual(this.f37014c, b0Var.f37014c) && Intrinsics.areEqual(this.f37015d, b0Var.f37015d)) {
                    return true;
                }
                return false;
            }

            @NotNull
            public final String f() {
                return this.f37014c;
            }

            public final int hashCode() {
                return this.f37015d.hashCode() + (this.f37014c.hashCode() * 31);
            }

            @Override // com.pollfish.internal.l4
            @NotNull
            public final String toString() {
                StringBuilder a4 = u4.a("ServerError(url=");
                a4.append(this.f37014c);
                a4.append(", message=");
                return g5.a(a4, this.f37015d, ')');
            }
        }

        /* loaded from: classes6.dex */
        public static final class c extends a {
            @NotNull

            /* renamed from: c  reason: collision with root package name */
            public final Throwable f37016c;

            public c(@NotNull Exception exc) {
                super(exc, (f4.a) null, 2);
                this.f37016c = exc;
            }

            @NotNull
            public final Throwable e() {
                return this.f37016c;
            }

            public final boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if ((obj instanceof c) && Intrinsics.areEqual(this.f37016c, ((c) obj).f37016c)) {
                    return true;
                }
                return false;
            }

            public final int hashCode() {
                return this.f37016c.hashCode();
            }

            @Override // com.pollfish.internal.l4
            @NotNull
            public final String toString() {
                StringBuilder a4 = u4.a("AnimationError(t=");
                a4.append(this.f37016c);
                a4.append(')');
                return a4.toString();
            }
        }

        /* loaded from: classes6.dex */
        public static final class c0 extends a {
            @NotNull

            /* renamed from: c  reason: collision with root package name */
            public static final c0 f37017c = new c0();

            public c0() {
                super((Throwable) null, f4.a.DEBUG, 1);
            }
        }

        /* loaded from: classes6.dex */
        public static final class d extends a {
            @NotNull

            /* renamed from: c  reason: collision with root package name */
            public static final d f37018c = new d();

            public d() {
                super((Throwable) null, (f4.a) null, 3);
            }
        }

        /* loaded from: classes6.dex */
        public static final class d0 extends a {
            @NotNull

            /* renamed from: c  reason: collision with root package name */
            public final Throwable f37019c;

            public d0(@NotNull Throwable th) {
                super(th, (f4.a) null, 2);
                this.f37019c = th;
            }

            @NotNull
            public final Throwable e() {
                return this.f37019c;
            }

            public final boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if ((obj instanceof d0) && Intrinsics.areEqual(this.f37019c, ((d0) obj).f37019c)) {
                    return true;
                }
                return false;
            }

            public final int hashCode() {
                return this.f37019c.hashCode();
            }

            @Override // com.pollfish.internal.l4
            @NotNull
            public final String toString() {
                StringBuilder a4 = u4.a("UncaughtException(t=");
                a4.append(this.f37019c);
                a4.append(')');
                return a4.toString();
            }
        }

        /* loaded from: classes6.dex */
        public static final class e extends a {
            @NotNull

            /* renamed from: c  reason: collision with root package name */
            public final Throwable f37020c;

            public e(@NotNull Exception exc) {
                super(exc, (f4.a) null, 2);
                this.f37020c = exc;
            }

            @NotNull
            public final Throwable e() {
                return this.f37020c;
            }

            public final boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if ((obj instanceof e) && Intrinsics.areEqual(this.f37020c, ((e) obj).f37020c)) {
                    return true;
                }
                return false;
            }

            public final int hashCode() {
                return this.f37020c.hashCode();
            }

            @Override // com.pollfish.internal.l4
            @NotNull
            public final String toString() {
                StringBuilder a4 = u4.a("CacheClear(t=");
                a4.append(this.f37020c);
                a4.append(')');
                return a4.toString();
            }
        }

        /* loaded from: classes6.dex */
        public static final class e0 extends a {

            /* renamed from: c  reason: collision with root package name */
            public final int f37021c;
            @NotNull

            /* renamed from: d  reason: collision with root package name */
            public final String f37022d;
            @Nullable

            /* renamed from: e  reason: collision with root package name */
            public final String f37023e;

            public e0(@NotNull String str, int i4, @Nullable String str2) {
                super((Throwable) null, (f4.a) null, 3);
                this.f37021c = i4;
                this.f37022d = str;
                this.f37023e = str2;
            }

            public final int e() {
                return this.f37021c;
            }

            public final boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof e0)) {
                    return false;
                }
                e0 e0Var = (e0) obj;
                if (this.f37021c == e0Var.f37021c && Intrinsics.areEqual(this.f37022d, e0Var.f37022d) && Intrinsics.areEqual(this.f37023e, e0Var.f37023e)) {
                    return true;
                }
                return false;
            }

            @Nullable
            public final String f() {
                return this.f37023e;
            }

            @NotNull
            public final String g() {
                return this.f37022d;
            }

            public final int hashCode() {
                int hashCode;
                int a4 = m4.a(this.f37022d, this.f37021c * 31, 31);
                String str = this.f37023e;
                if (str == null) {
                    hashCode = 0;
                } else {
                    hashCode = str.hashCode();
                }
                return a4 + hashCode;
            }

            @Override // com.pollfish.internal.l4
            @NotNull
            public final String toString() {
                StringBuilder a4 = u4.a("UnknownHttpError(code=");
                a4.append(this.f37021c);
                a4.append(", url=");
                a4.append(this.f37022d);
                a4.append(", message=");
                return g5.a(a4, this.f37023e, ')');
            }
        }

        /* loaded from: classes6.dex */
        public static final class f extends a {
            @NotNull

            /* renamed from: c  reason: collision with root package name */
            public final String f37024c;
            @NotNull

            /* renamed from: d  reason: collision with root package name */
            public final Throwable f37025d;

            public f(@NotNull String str, @NotNull Exception exc) {
                super(exc, (f4.a) null, 2);
                this.f37024c = str;
                this.f37025d = exc;
            }

            @NotNull
            public final String e() {
                return this.f37024c;
            }

            public final boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof f)) {
                    return false;
                }
                f fVar = (f) obj;
                if (Intrinsics.areEqual(this.f37024c, fVar.f37024c) && Intrinsics.areEqual(this.f37025d, fVar.f37025d)) {
                    return true;
                }
                return false;
            }

            @NotNull
            public final Throwable f() {
                return this.f37025d;
            }

            public final int hashCode() {
                return this.f37025d.hashCode() + (this.f37024c.hashCode() * 31);
            }

            @Override // com.pollfish.internal.l4
            @NotNull
            public final String toString() {
                StringBuilder a4 = u4.a("CacheRead(path=");
                a4.append(this.f37024c);
                a4.append(", t=");
                a4.append(this.f37025d);
                a4.append(')');
                return a4.toString();
            }
        }

        /* loaded from: classes6.dex */
        public static final class f0 extends a {
            @NotNull

            /* renamed from: c  reason: collision with root package name */
            public final String f37026c;

            public f0(@NotNull String str) {
                super((Throwable) null, (f4.a) null, 3);
                this.f37026c = str;
            }

            @NotNull
            public final String e() {
                return this.f37026c;
            }

            public final boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if ((obj instanceof f0) && Intrinsics.areEqual(this.f37026c, ((f0) obj).f37026c)) {
                    return true;
                }
                return false;
            }

            public final int hashCode() {
                return this.f37026c.hashCode();
            }

            @Override // com.pollfish.internal.l4
            @NotNull
            public final String toString() {
                return g5.a(u4.a("Unspecified(message="), this.f37026c, ')');
            }
        }

        /* loaded from: classes6.dex */
        public static final class g extends a {
            @NotNull

            /* renamed from: c  reason: collision with root package name */
            public final String f37027c;
            @NotNull

            /* renamed from: d  reason: collision with root package name */
            public final Throwable f37028d;

            public g(@NotNull String str, @NotNull Throwable th) {
                super(th, (f4.a) null, 2);
                this.f37027c = str;
                this.f37028d = th;
            }

            @NotNull
            public final String e() {
                return this.f37027c;
            }

            public final boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof g)) {
                    return false;
                }
                g gVar = (g) obj;
                if (Intrinsics.areEqual(this.f37027c, gVar.f37027c) && Intrinsics.areEqual(this.f37028d, gVar.f37028d)) {
                    return true;
                }
                return false;
            }

            @NotNull
            public final Throwable f() {
                return this.f37028d;
            }

            public final int hashCode() {
                return this.f37028d.hashCode() + (this.f37027c.hashCode() * 31);
            }

            @Override // com.pollfish.internal.l4
            @NotNull
            public final String toString() {
                StringBuilder a4 = u4.a("CacheWrite(path=");
                a4.append(this.f37027c);
                a4.append(", t=");
                a4.append(this.f37028d);
                a4.append(')');
                return a4.toString();
            }
        }

        /* loaded from: classes6.dex */
        public static final class g0 extends a {
            @NotNull

            /* renamed from: c  reason: collision with root package name */
            public final WebResourceRequest f37029c;
            @Nullable

            /* renamed from: d  reason: collision with root package name */
            public final WebResourceResponse f37030d;

            public g0(@NotNull WebResourceRequest webResourceRequest, @Nullable WebResourceResponse webResourceResponse) {
                super((Throwable) null, (f4.a) null, 3);
                this.f37029c = webResourceRequest;
                this.f37030d = webResourceResponse;
            }

            @Nullable
            public final WebResourceResponse e() {
                return this.f37030d;
            }

            public final boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof g0)) {
                    return false;
                }
                g0 g0Var = (g0) obj;
                if (Intrinsics.areEqual(this.f37029c, g0Var.f37029c) && Intrinsics.areEqual(this.f37030d, g0Var.f37030d)) {
                    return true;
                }
                return false;
            }

            @NotNull
            public final WebResourceRequest f() {
                return this.f37029c;
            }

            public final int hashCode() {
                int hashCode;
                int hashCode2 = this.f37029c.hashCode() * 31;
                WebResourceResponse webResourceResponse = this.f37030d;
                if (webResourceResponse == null) {
                    hashCode = 0;
                } else {
                    hashCode = webResourceResponse.hashCode();
                }
                return hashCode2 + hashCode;
            }

            @Override // com.pollfish.internal.l4
            @NotNull
            public final String toString() {
                StringBuilder a4 = u4.a("WebViewHttpError(request=");
                a4.append(this.f37029c);
                a4.append(", error=");
                a4.append(this.f37030d);
                a4.append(')');
                return a4.toString();
            }
        }

        /* loaded from: classes6.dex */
        public static final class h extends a {
            @NotNull

            /* renamed from: c  reason: collision with root package name */
            public final Throwable f37031c;

            public h(@NotNull Exception exc) {
                super(exc, (f4.a) null, 2);
                this.f37031c = exc;
            }

            @NotNull
            public final Throwable e() {
                return this.f37031c;
            }

            public final boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if ((obj instanceof h) && Intrinsics.areEqual(this.f37031c, ((h) obj).f37031c)) {
                    return true;
                }
                return false;
            }

            public final int hashCode() {
                return this.f37031c.hashCode();
            }

            @Override // com.pollfish.internal.l4
            @NotNull
            public final String toString() {
                StringBuilder a4 = u4.a("ConnectionError(t=");
                a4.append(this.f37031c);
                a4.append(')');
                return a4.toString();
            }
        }

        /* loaded from: classes6.dex */
        public static final class h0 extends a {
            @NotNull

            /* renamed from: c  reason: collision with root package name */
            public final String f37032c;

            public h0(@NotNull String str) {
                super((Throwable) null, (f4.a) null, 3);
                this.f37032c = str;
            }

            @NotNull
            public final String e() {
                return this.f37032c;
            }

            public final boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if ((obj instanceof h0) && Intrinsics.areEqual(this.f37032c, ((h0) obj).f37032c)) {
                    return true;
                }
                return false;
            }

            public final int hashCode() {
                return this.f37032c.hashCode();
            }

            @Override // com.pollfish.internal.l4
            @NotNull
            public final String toString() {
                return g5.a(u4.a("WrongDownloadAssetUrl(url="), this.f37032c, ')');
            }
        }

        /* loaded from: classes6.dex */
        public static final class i extends a {
            @NotNull

            /* renamed from: c  reason: collision with root package name */
            public final Throwable f37033c;

            public i(@NotNull IOException iOException) {
                super(iOException, f4.a.DEBUG, (Object) null);
                this.f37033c = iOException;
            }

            @NotNull
            public final Throwable e() {
                return this.f37033c;
            }

            public final boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if ((obj instanceof i) && Intrinsics.areEqual(this.f37033c, ((i) obj).f37033c)) {
                    return true;
                }
                return false;
            }

            public final int hashCode() {
                return this.f37033c.hashCode();
            }

            @Override // com.pollfish.internal.l4
            @NotNull
            public final String toString() {
                StringBuilder a4 = u4.a("ConnectionIOError(t=");
                a4.append(this.f37033c);
                a4.append(')');
                return a4.toString();
            }
        }

        /* loaded from: classes6.dex */
        public static final class i0 extends a {
            @NotNull

            /* renamed from: c  reason: collision with root package name */
            public static final i0 f37034c = new i0();

            public i0() {
                super((Throwable) null, f4.a.INFO, 1);
            }
        }

        /* loaded from: classes6.dex */
        public static final class j extends a {
            @NotNull

            /* renamed from: c  reason: collision with root package name */
            public final String f37035c;

            public j(@NotNull String str) {
                super((Throwable) null, (f4.a) null, 3);
                this.f37035c = str;
            }

            @NotNull
            public final String e() {
                return this.f37035c;
            }

            public final boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if ((obj instanceof j) && Intrinsics.areEqual(this.f37035c, ((j) obj).f37035c)) {
                    return true;
                }
                return false;
            }

            public final int hashCode() {
                return this.f37035c.hashCode();
            }

            @Override // com.pollfish.internal.l4
            @NotNull
            public final String toString() {
                return g5.a(u4.a("DownloadAssetServerError(reason="), this.f37035c, ')');
            }
        }

        /* loaded from: classes6.dex */
        public static final class j0 extends a {
            @NotNull

            /* renamed from: c  reason: collision with root package name */
            public final String f37036c;
            @NotNull

            /* renamed from: d  reason: collision with root package name */
            public final String f37037d;

            public j0(@NotNull String str, @NotNull String str2) {
                super((Throwable) null, (f4.a) null, 3);
                this.f37036c = str;
                this.f37037d = str2;
            }

            @NotNull
            public final String e() {
                return this.f37037d;
            }

            public final boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof j0)) {
                    return false;
                }
                j0 j0Var = (j0) obj;
                if (Intrinsics.areEqual(this.f37036c, j0Var.f37036c) && Intrinsics.areEqual(this.f37037d, j0Var.f37037d)) {
                    return true;
                }
                return false;
            }

            @NotNull
            public final String f() {
                return this.f37036c;
            }

            public final int hashCode() {
                return this.f37037d.hashCode() + (this.f37036c.hashCode() * 31);
            }

            @Override // com.pollfish.internal.l4
            @NotNull
            public final String toString() {
                StringBuilder a4 = u4.a("WrongOrBadArguments(url=");
                a4.append(this.f37036c);
                a4.append(", message=");
                return g5.a(a4, this.f37037d, ')');
            }
        }

        /* loaded from: classes6.dex */
        public static final class k extends a {
            @NotNull

            /* renamed from: c  reason: collision with root package name */
            public final String f37038c;
            @NotNull

            /* renamed from: d  reason: collision with root package name */
            public final String f37039d;
            @NotNull

            /* renamed from: e  reason: collision with root package name */
            public final Throwable f37040e;

            public k(@NotNull String str, @NotNull String str2, @NotNull Exception exc) {
                super(exc, (f4.a) null, 2);
                this.f37038c = str;
                this.f37039d = str2;
                this.f37040e = exc;
            }

            @NotNull
            public final String e() {
                return this.f37038c;
            }

            public final boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof k)) {
                    return false;
                }
                k kVar = (k) obj;
                if (Intrinsics.areEqual(this.f37038c, kVar.f37038c) && Intrinsics.areEqual(this.f37039d, kVar.f37039d) && Intrinsics.areEqual(this.f37040e, kVar.f37040e)) {
                    return true;
                }
                return false;
            }

            @NotNull
            public final String f() {
                return this.f37039d;
            }

            @NotNull
            public final Throwable g() {
                return this.f37040e;
            }

            public final int hashCode() {
                return this.f37040e.hashCode() + m4.a(this.f37039d, this.f37038c.hashCode() * 31, 31);
            }

            @Override // com.pollfish.internal.l4
            @NotNull
            public final String toString() {
                StringBuilder a4 = u4.a("EndpointRequestEncode(endpoint=");
                a4.append(this.f37038c);
                a4.append(", params=");
                a4.append(this.f37039d);
                a4.append(", t=");
                a4.append(this.f37040e);
                a4.append(')');
                return a4.toString();
            }
        }

        /* loaded from: classes6.dex */
        public static final class k0 extends a {
            @NotNull

            /* renamed from: c  reason: collision with root package name */
            public static final k0 f37041c = new k0();

            public k0() {
                super((Throwable) null, (f4.a) null, 3);
            }
        }

        /* loaded from: classes6.dex */
        public static final class l extends a {
            @NotNull

            /* renamed from: c  reason: collision with root package name */
            public final Throwable f37042c;

            public l(@NotNull Exception exc) {
                super(exc, (f4.a) null, 2);
                this.f37042c = exc;
            }

            @NotNull
            public final Throwable e() {
                return this.f37042c;
            }

            public final boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if ((obj instanceof l) && Intrinsics.areEqual(this.f37042c, ((l) obj).f37042c)) {
                    return true;
                }
                return false;
            }

            public final int hashCode() {
                return this.f37042c.hashCode();
            }

            @Override // com.pollfish.internal.l4
            @NotNull
            public final String toString() {
                StringBuilder a4 = u4.a("ExecuteMultipleException(t=");
                a4.append(this.f37042c);
                a4.append(')');
                return a4.toString();
            }
        }

        /* loaded from: classes6.dex */
        public static final class l0 extends a {
            @NotNull

            /* renamed from: c  reason: collision with root package name */
            public static final l0 f37043c = new l0();

            public l0() {
                super((Throwable) null, f4.a.INFO, 1);
            }
        }

        /* loaded from: classes6.dex */
        public static final class m extends a {
            @NotNull

            /* renamed from: c  reason: collision with root package name */
            public static final m f37044c = new m();

            public m() {
                super((Throwable) null, f4.a.INFO, 1);
            }
        }

        /* loaded from: classes6.dex */
        public static final class m0 extends a {
            @NotNull

            /* renamed from: c  reason: collision with root package name */
            public final String f37045c;
            @NotNull

            /* renamed from: d  reason: collision with root package name */
            public final Throwable f37046d;

            public m0(@NotNull String str, @NotNull Exception exc) {
                super(exc, (f4.a) null, 2);
                this.f37045c = str;
                this.f37046d = exc;
            }

            @NotNull
            public final String e() {
                return this.f37045c;
            }

            public final boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof m0)) {
                    return false;
                }
                m0 m0Var = (m0) obj;
                if (Intrinsics.areEqual(this.f37045c, m0Var.f37045c) && Intrinsics.areEqual(this.f37046d, m0Var.f37046d)) {
                    return true;
                }
                return false;
            }

            @NotNull
            public final Throwable f() {
                return this.f37046d;
            }

            public final int hashCode() {
                return this.f37046d.hashCode() + (this.f37045c.hashCode() * 31);
            }

            @Override // com.pollfish.internal.l4
            @NotNull
            public final String toString() {
                StringBuilder a4 = u4.a("WrongRegisterRequestUrl(params=");
                a4.append(this.f37045c);
                a4.append(", t=");
                a4.append(this.f37046d);
                a4.append(')');
                return a4.toString();
            }
        }

        /* loaded from: classes6.dex */
        public static final class n extends a {

            /* renamed from: c  reason: collision with root package name */
            public final int f37047c;
            @Nullable

            /* renamed from: d  reason: collision with root package name */
            public final String f37048d;

            public n(int i4, @Nullable String str) {
                super((Throwable) null, f4.a.INFO, 1);
                this.f37047c = i4;
                this.f37048d = str;
            }

            public final int e() {
                return this.f37047c;
            }

            public final boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof n)) {
                    return false;
                }
                n nVar = (n) obj;
                if (this.f37047c == nVar.f37047c && Intrinsics.areEqual(this.f37048d, nVar.f37048d)) {
                    return true;
                }
                return false;
            }

            @Nullable
            public final String f() {
                return this.f37048d;
            }

            public final int hashCode() {
                int hashCode;
                int i4 = this.f37047c * 31;
                String str = this.f37048d;
                if (str == null) {
                    hashCode = 0;
                } else {
                    hashCode = str.hashCode();
                }
                return i4 + hashCode;
            }

            @Override // com.pollfish.internal.l4
            @NotNull
            public final String toString() {
                StringBuilder a4 = u4.a("GoogleServicesError(code=");
                a4.append(this.f37047c);
                a4.append(", message=");
                return g5.a(a4, this.f37048d, ')');
            }
        }

        /* loaded from: classes6.dex */
        public static final class n0 extends a {
            @NotNull

            /* renamed from: c  reason: collision with root package name */
            public final String f37049c;
            @NotNull

            /* renamed from: d  reason: collision with root package name */
            public final Throwable f37050d;

            public n0(@NotNull String str, @NotNull Exception exc) {
                super(exc, (f4.a) null, 2);
                this.f37049c = str;
                this.f37050d = exc;
            }

            @NotNull
            public final String e() {
                return this.f37049c;
            }

            public final boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof n0)) {
                    return false;
                }
                n0 n0Var = (n0) obj;
                if (Intrinsics.areEqual(this.f37049c, n0Var.f37049c) && Intrinsics.areEqual(this.f37050d, n0Var.f37050d)) {
                    return true;
                }
                return false;
            }

            @NotNull
            public final Throwable f() {
                return this.f37050d;
            }

            public final int hashCode() {
                return this.f37050d.hashCode() + (this.f37049c.hashCode() * 31);
            }

            @Override // com.pollfish.internal.l4
            @NotNull
            public final String toString() {
                StringBuilder a4 = u4.a("WrongReportErrorUrl(params=");
                a4.append(this.f37049c);
                a4.append(", t=");
                a4.append(this.f37050d);
                a4.append(')');
                return a4.toString();
            }
        }

        /* loaded from: classes6.dex */
        public static final class o extends a {
            @NotNull

            /* renamed from: c  reason: collision with root package name */
            public final List<a> f37051c;

            /* JADX WARN: Multi-variable type inference failed */
            public o(@NotNull List<? extends a> list) {
                super((Throwable) null, (f4.a) null, 3);
                this.f37051c = list;
            }

            @NotNull
            public final List<a> e() {
                return this.f37051c;
            }

            public final boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if ((obj instanceof o) && Intrinsics.areEqual(this.f37051c, ((o) obj).f37051c)) {
                    return true;
                }
                return false;
            }

            public final int hashCode() {
                return this.f37051c.hashCode();
            }

            @Override // com.pollfish.internal.l4
            @NotNull
            public final String toString() {
                StringBuilder a4 = u4.a("GroupError(errors=");
                a4.append(this.f37051c);
                a4.append(')');
                return a4.toString();
            }
        }

        /* loaded from: classes6.dex */
        public static final class o0 extends a {
            @NotNull

            /* renamed from: c  reason: collision with root package name */
            public final String f37052c;
            @NotNull

            /* renamed from: d  reason: collision with root package name */
            public final String f37053d;
            @NotNull

            /* renamed from: e  reason: collision with root package name */
            public final Throwable f37054e;

            public o0(@NotNull String str, @NotNull String str2, @NotNull Exception exc) {
                super(exc, (f4.a) null, 2);
                this.f37052c = str;
                this.f37053d = str2;
                this.f37054e = exc;
            }

            @NotNull
            public final String e() {
                return this.f37053d;
            }

            public final boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof o0)) {
                    return false;
                }
                o0 o0Var = (o0) obj;
                if (Intrinsics.areEqual(this.f37052c, o0Var.f37052c) && Intrinsics.areEqual(this.f37053d, o0Var.f37053d) && Intrinsics.areEqual(this.f37054e, o0Var.f37054e)) {
                    return true;
                }
                return false;
            }

            @NotNull
            public final Throwable f() {
                return this.f37054e;
            }

            @NotNull
            public final String g() {
                return this.f37052c;
            }

            public final int hashCode() {
                return this.f37054e.hashCode() + m4.a(this.f37053d, this.f37052c.hashCode() * 31, 31);
            }

            @Override // com.pollfish.internal.l4
            @NotNull
            public final String toString() {
                StringBuilder a4 = u4.a("WrongSendToServerUrl(url=");
                a4.append(this.f37052c);
                a4.append(", params=");
                a4.append(this.f37053d);
                a4.append(", t=");
                a4.append(this.f37054e);
                a4.append(')');
                return a4.toString();
            }
        }

        /* loaded from: classes6.dex */
        public static final class p extends a {
            @NotNull

            /* renamed from: c  reason: collision with root package name */
            public static final p f37055c = new p();

            public p() {
                super((Throwable) null, (f4.a) null, 1);
            }
        }

        /* loaded from: classes6.dex */
        public static final class q extends a {
            @NotNull

            /* renamed from: c  reason: collision with root package name */
            public final j3 f37056c;
            @NotNull

            /* renamed from: d  reason: collision with root package name */
            public final Throwable f37057d;

            public q(@NotNull j3 j3Var, @NotNull Exception exc) {
                super(exc, (f4.a) null, 2);
                this.f37056c = j3Var;
                this.f37057d = exc;
            }

            @NotNull
            public final Throwable e() {
                return this.f37057d;
            }

            public final boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof q)) {
                    return false;
                }
                q qVar = (q) obj;
                if (Intrinsics.areEqual(this.f37056c, qVar.f37056c) && Intrinsics.areEqual(this.f37057d, qVar.f37057d)) {
                    return true;
                }
                return false;
            }

            public final int hashCode() {
                return this.f37057d.hashCode() + (this.f37056c.hashCode() * 31);
            }

            @Override // com.pollfish.internal.l4
            @NotNull
            public final String toString() {
                StringBuilder a4 = u4.a("MediationParamsParse(params=");
                a4.append(this.f37056c);
                a4.append(", t=");
                a4.append(this.f37057d);
                a4.append(')');
                return a4.toString();
            }
        }

        /* loaded from: classes6.dex */
        public static final class r extends a {
            @NotNull

            /* renamed from: c  reason: collision with root package name */
            public static final r f37058c = new r();

            public r() {
                super((Throwable) null, f4.a.DEBUG, 1);
            }
        }

        /* loaded from: classes6.dex */
        public static final class s extends a {
            @NotNull

            /* renamed from: c  reason: collision with root package name */
            public static final s f37059c = new s();

            public s() {
                super((Throwable) null, (f4.a) null, 3);
            }
        }

        /* loaded from: classes6.dex */
        public static final class t extends a {
            @NotNull

            /* renamed from: c  reason: collision with root package name */
            public static final t f37060c = new t();

            public t() {
                super((Throwable) null, (f4.a) null, 3);
            }
        }

        /* loaded from: classes6.dex */
        public static final class u extends a {
            @NotNull

            /* renamed from: c  reason: collision with root package name */
            public final String f37061c;

            public u(@NotNull String str) {
                super((Throwable) null, (f4.a) null, 3);
                this.f37061c = str;
            }

            @NotNull
            public final String e() {
                return this.f37061c;
            }

            public final boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if ((obj instanceof u) && Intrinsics.areEqual(this.f37061c, ((u) obj).f37061c)) {
                    return true;
                }
                return false;
            }

            public final int hashCode() {
                return this.f37061c.hashCode();
            }

            @Override // com.pollfish.internal.l4
            @NotNull
            public final String toString() {
                return g5.a(u4.a("NullPollfishConfiguration(viewModelState="), this.f37061c, ')');
            }
        }

        /* loaded from: classes6.dex */
        public static final class v extends a {
            public final boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof v)) {
                    return false;
                }
                ((v) obj).getClass();
                if (Intrinsics.areEqual((Object) null, (Object) null)) {
                    return true;
                }
                return false;
            }

            public final int hashCode() {
                throw null;
            }

            @Override // com.pollfish.internal.l4
            @NotNull
            public final String toString() {
                return "OptOutFlagRetrieval(t=" + ((Object) null) + ')';
            }
        }

        /* loaded from: classes6.dex */
        public static final class w extends a {
            @NotNull

            /* renamed from: c  reason: collision with root package name */
            public final Throwable f37062c;

            public w(@NotNull Exception exc) {
                super(exc, (f4.a) null, 2);
                this.f37062c = exc;
            }

            @NotNull
            public final Throwable e() {
                return this.f37062c;
            }

            public final boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if ((obj instanceof w) && Intrinsics.areEqual(this.f37062c, ((w) obj).f37062c)) {
                    return true;
                }
                return false;
            }

            public final int hashCode() {
                return this.f37062c.hashCode();
            }

            @Override // com.pollfish.internal.l4
            @NotNull
            public final String toString() {
                StringBuilder a4 = u4.a("RegisterRequestEncode(t=");
                a4.append(this.f37062c);
                a4.append(')');
                return a4.toString();
            }
        }

        /* loaded from: classes6.dex */
        public static final class x extends a {
            @NotNull

            /* renamed from: c  reason: collision with root package name */
            public final String f37063c;
            @NotNull

            /* renamed from: d  reason: collision with root package name */
            public final Throwable f37064d;

            public x(@NotNull String str, @NotNull Exception exc) {
                super(exc, (f4.a) null, 2);
                this.f37063c = str;
                this.f37064d = exc;
            }

            @NotNull
            public final String e() {
                return this.f37063c;
            }

            public final boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof x)) {
                    return false;
                }
                x xVar = (x) obj;
                if (Intrinsics.areEqual(this.f37063c, xVar.f37063c) && Intrinsics.areEqual(this.f37064d, xVar.f37064d)) {
                    return true;
                }
                return false;
            }

            @NotNull
            public final Throwable f() {
                return this.f37064d;
            }

            public final int hashCode() {
                return this.f37064d.hashCode() + (this.f37063c.hashCode() * 31);
            }

            @Override // com.pollfish.internal.l4
            @NotNull
            public final String toString() {
                StringBuilder a4 = u4.a("RegisterResponseParse(response=");
                a4.append(this.f37063c);
                a4.append(", t=");
                a4.append(this.f37064d);
                a4.append(')');
                return a4.toString();
            }
        }

        /* loaded from: classes6.dex */
        public static final class y extends a {
            @NotNull

            /* renamed from: c  reason: collision with root package name */
            public final Throwable f37065c;

            public y(@NotNull Exception exc) {
                super(exc, (f4.a) null, 2);
                this.f37065c = exc;
            }

            @NotNull
            public final Throwable e() {
                return this.f37065c;
            }

            public final boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if ((obj instanceof y) && Intrinsics.areEqual(this.f37065c, ((y) obj).f37065c)) {
                    return true;
                }
                return false;
            }

            public final int hashCode() {
                return this.f37065c.hashCode();
            }

            @Override // com.pollfish.internal.l4
            @NotNull
            public final String toString() {
                StringBuilder a4 = u4.a("RemoveViewFromParent(t=");
                a4.append(this.f37065c);
                a4.append(')');
                return a4.toString();
            }
        }

        /* loaded from: classes6.dex */
        public static final class z extends a {

            /* renamed from: c  reason: collision with root package name */
            public final int f37066c;
            @Nullable

            /* renamed from: d  reason: collision with root package name */
            public final String f37067d;

            public z(int i4, @Nullable String str) {
                super((Throwable) null, (f4.a) null, 3);
                this.f37066c = i4;
                this.f37067d = str;
            }

            public final int e() {
                return this.f37066c;
            }

            public final boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof z)) {
                    return false;
                }
                z zVar = (z) obj;
                if (this.f37066c == zVar.f37066c && Intrinsics.areEqual(this.f37067d, zVar.f37067d)) {
                    return true;
                }
                return false;
            }

            @Nullable
            public final String f() {
                return this.f37067d;
            }

            public final int hashCode() {
                int hashCode;
                int i4 = this.f37066c * 31;
                String str = this.f37067d;
                if (str == null) {
                    hashCode = 0;
                } else {
                    hashCode = str.hashCode();
                }
                return i4 + hashCode;
            }

            @Override // com.pollfish.internal.l4
            @NotNull
            public final String toString() {
                StringBuilder a4 = u4.a("ReportHttpError(code=");
                a4.append(this.f37066c);
                a4.append(", message=");
                return g5.a(a4, this.f37067d, ')');
            }
        }

        public /* synthetic */ a(Throwable th, f4.a aVar, Object obj) {
            this(th, aVar);
        }

        @NotNull
        public final String a() {
            boolean z3;
            StringBuilder sb = new StringBuilder();
            sb.append(getClass().getSimpleName());
            StringBuilder a4 = u4.a(", ");
            a4.append(d());
            String sb2 = a4.toString();
            if (d().length() > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (!z3) {
                sb2 = null;
            }
            if (sb2 == null) {
                sb2 = "";
            }
            sb.append(sb2);
            return sb.toString();
        }

        @NotNull
        public final Throwable b() {
            return this.f37009a;
        }

        @NotNull
        public final String c() {
            return getClass().getSimpleName();
        }

        @NotNull
        public final String d() {
            String trimIndent;
            if (this instanceof j) {
                StringBuilder a4 = u4.a("Reason: ");
                a4.append(((j) this).e());
                return a4.toString();
            } else if (this instanceof n) {
                StringBuilder a5 = u4.a("Code: ");
                n nVar = (n) this;
                a5.append(nVar.e());
                a5.append(", Message: ");
                String f4 = nVar.f();
                if (f4 == null) {
                    f4 = "Unknown Error";
                }
                a5.append(f4);
                return a5.toString();
            } else if (this instanceof o0) {
                StringBuilder a6 = u4.a("Url: ");
                o0 o0Var = (o0) this;
                a6.append(o0Var.g());
                a6.append(", Params: ");
                a6.append(o0Var.e());
                a6.append(", Message: ");
                a6.append(o0Var.f().getMessage());
                return a6.toString();
            } else if (this instanceof o) {
                StringBuilder a7 = u4.a("Errors: ");
                a7.append(((o) this).e());
                return a7.toString();
            } else {
                String str = "";
                if (this instanceof z) {
                    StringBuilder a8 = u4.a("Code: ");
                    z zVar = (z) this;
                    a8.append(zVar.e());
                    String f5 = zVar.f();
                    if (f5 != null) {
                        String str2 = ", Message: " + f5;
                        if (str2 != null) {
                            str = str2;
                        }
                    }
                    a8.append(str);
                    return a8.toString();
                } else if (this instanceof e0) {
                    StringBuilder a9 = u4.a("Code: ");
                    e0 e0Var = (e0) this;
                    a9.append(e0Var.e());
                    a9.append(", Url: ");
                    a9.append(e0Var.g());
                    String f6 = e0Var.f();
                    if (f6 != null) {
                        String str3 = ", Message: " + f6;
                        if (str3 != null) {
                            str = str3;
                        }
                    }
                    a9.append(str);
                    return a9.toString();
                } else if (this instanceof a0) {
                    StringBuilder a10 = u4.a("Body: ");
                    a0 a0Var = (a0) this;
                    a10.append(a0Var.e());
                    a10.append(", Message: ");
                    a10.append(a0Var.f().getMessage());
                    return a10.toString();
                } else if (this instanceof x) {
                    StringBuilder a11 = u4.a("Response: ");
                    x xVar = (x) this;
                    a11.append(xVar.e());
                    a11.append(", Message: ");
                    a11.append(xVar.f().getMessage());
                    return a11.toString();
                } else if (this instanceof k) {
                    StringBuilder a12 = u4.a("Endpoint: ");
                    k kVar = (k) this;
                    a12.append(kVar.e());
                    a12.append(", Params: ");
                    a12.append(kVar.f());
                    a12.append(", Message: ");
                    a12.append(kVar.g().getMessage());
                    return a12.toString();
                } else if (this instanceof g) {
                    StringBuilder a13 = u4.a("Path: ");
                    g gVar = (g) this;
                    a13.append(gVar.e());
                    a13.append(", Message: ");
                    a13.append(gVar.f().getMessage());
                    return a13.toString();
                } else if (this instanceof f) {
                    StringBuilder a14 = u4.a("Path: ");
                    f fVar = (f) this;
                    a14.append(fVar.e());
                    a14.append(", Message: ");
                    a14.append(fVar.f().getMessage());
                    return a14.toString();
                } else if (this instanceof e) {
                    StringBuilder a15 = u4.a("Message: ");
                    a15.append(((e) this).e().getMessage());
                    return a15.toString();
                } else if (this instanceof w) {
                    StringBuilder a16 = u4.a("Message: ");
                    a16.append(((w) this).e().getMessage());
                    return a16.toString();
                } else if (this instanceof n0) {
                    StringBuilder a17 = u4.a("Params: ");
                    n0 n0Var = (n0) this;
                    a17.append(n0Var.e());
                    a17.append(", Message: ");
                    a17.append(n0Var.f().getMessage());
                    return a17.toString();
                } else if (this instanceof q) {
                    StringBuilder a18 = u4.a("Message: ");
                    a18.append(((q) this).e().getMessage());
                    return a18.toString();
                } else if (!(this instanceof v)) {
                    if (this instanceof b) {
                        StringBuilder a19 = u4.a("Message: ");
                        a19.append(((b) this).e().getMessage());
                        return a19.toString();
                    } else if (this instanceof m0) {
                        StringBuilder a20 = u4.a("Params: ");
                        m0 m0Var = (m0) this;
                        a20.append(m0Var.e());
                        a20.append(", Message: ");
                        a20.append(m0Var.f().getMessage());
                        return a20.toString();
                    } else if (!(this instanceof C0214a)) {
                        if (this instanceof l) {
                            StringBuilder a21 = u4.a("Message: ");
                            a21.append(((l) this).e().getMessage());
                            return a21.toString();
                        } else if (this instanceof h) {
                            StringBuilder a22 = u4.a("Message: ");
                            a22.append(((h) this).e().getMessage());
                            return a22.toString();
                        } else if (this instanceof b0) {
                            StringBuilder a23 = u4.a("Url: ");
                            b0 b0Var = (b0) this;
                            a23.append(b0Var.f());
                            a23.append(", Message: ");
                            a23.append(b0Var.e());
                            return a23.toString();
                        } else if (this instanceof j0) {
                            StringBuilder a24 = u4.a("Url: ");
                            j0 j0Var = (j0) this;
                            a24.append(j0Var.f());
                            a24.append(", Message: ");
                            a24.append(j0Var.e());
                            return a24.toString();
                        } else if (this instanceof h0) {
                            StringBuilder a25 = u4.a("Url: ");
                            a25.append(((h0) this).e());
                            return a25.toString();
                        } else if (this instanceof u) {
                            StringBuilder a26 = u4.a("viewModel: ");
                            a26.append(((u) this).e());
                            return a26.toString();
                        } else if (this instanceof c) {
                            StringBuilder a27 = u4.a("Message: ");
                            a27.append(((c) this).e().getMessage());
                            return a27.toString();
                        } else if (this instanceof y) {
                            StringBuilder a28 = u4.a("Message: ");
                            a28.append(((y) this).e().getMessage());
                            return a28.toString();
                        } else if (this instanceof d0) {
                            StringBuilder a29 = u4.a("Message: ");
                            a29.append(((d0) this).e().getMessage());
                            return a29.toString();
                        } else if (this instanceof i) {
                            StringBuilder a30 = u4.a("Message: ");
                            a30.append(((i) this).e().getMessage());
                            return a30.toString();
                        } else if (this instanceof f0) {
                            StringBuilder a31 = u4.a("Message: ");
                            a31.append(((f0) this).e());
                            return a31.toString();
                        } else if (!(this instanceof g0)) {
                            return "";
                        } else {
                            StringBuilder a32 = u4.a("\n                    Request: [\n                        method: ");
                            g0 g0Var = (g0) this;
                            a32.append(g0Var.f().getMethod());
                            a32.append("\n                        headers: ");
                            a32.append(g0Var.f().getRequestHeaders());
                            a32.append("\n                        url: ");
                            a32.append(g0Var.f().getUrl());
                            a32.append("\n                    ]");
                            WebResourceResponse e4 = g0Var.e();
                            if (e4 != null) {
                                StringBuilder a33 = u4.a(", \n                                errorResponse: [\n                                reasonPhrase: ");
                                a33.append(e4.getReasonPhrase());
                                a33.append("\n                                responseHeaders: ");
                                a33.append(e4.getResponseHeaders());
                                a33.append("\n                                statusCode: ");
                                a33.append(e4.getStatusCode());
                                a33.append(", \n                        ]");
                                String sb = a33.toString();
                                if (sb != null) {
                                    str = sb;
                                }
                            }
                            a32.append(str);
                            trimIndent = kotlin.text.f.trimIndent(a32.toString());
                            return trimIndent;
                        }
                    } else {
                        C0214a c0214a = (C0214a) this;
                        throw null;
                    }
                } else {
                    v vVar = (v) this;
                    throw null;
                }
            }
        }

        public /* synthetic */ a(Throwable th, f4.a aVar, int i4) {
            this((i4 & 1) != 0 ? new Exception() : th, (i4 & 2) != 0 ? f4.a.ERROR : aVar, (Object) null);
        }

        public a(Throwable th, f4.a aVar) {
            super(0);
            this.f37009a = th;
            this.f37010b = aVar;
        }
    }

    /* loaded from: classes6.dex */
    public static final class b<T> extends l4<T> {

        /* renamed from: a  reason: collision with root package name */
        public final T f37068a;

        public b(T t3) {
            super(0);
            this.f37068a = t3;
        }

        public final T a() {
            return this.f37068a;
        }

        public final boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof b) && Intrinsics.areEqual(this.f37068a, ((b) obj).f37068a)) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            T t3 = this.f37068a;
            if (t3 == null) {
                return 0;
            }
            return t3.hashCode();
        }

        @Override // com.pollfish.internal.l4
        @NotNull
        public final String toString() {
            StringBuilder a4 = u4.a("Success(data=");
            a4.append(this.f37068a);
            a4.append(')');
            return a4.toString();
        }
    }

    public l4() {
    }

    public /* synthetic */ l4(int i4) {
        this();
    }

    @NotNull
    public String toString() {
        if (this instanceof b) {
            StringBuilder a4 = u4.a("Success: ");
            a4.append(((b) this).a());
            return a4.toString();
        } else if (this instanceof a) {
            return ((a) this).a();
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
