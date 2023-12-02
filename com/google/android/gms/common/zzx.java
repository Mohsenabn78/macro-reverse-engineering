package com.google.android.gms.common;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.errorprone.annotations.CheckReturnValue;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
@CheckReturnValue
/* loaded from: classes4.dex */
public class zzx {

    /* renamed from: e  reason: collision with root package name */
    private static final zzx f20798e = new zzx(true, 3, 1, null, null);

    /* renamed from: a  reason: collision with root package name */
    final boolean f20799a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    final String f20800b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    final Throwable f20801c;

    /* renamed from: d  reason: collision with root package name */
    final int f20802d;

    private zzx(boolean z3, int i4, int i5, @Nullable String str, @Nullable Throwable th) {
        this.f20799a = z3;
        this.f20802d = i4;
        this.f20800b = str;
        this.f20801c = th;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public static zzx b() {
        return f20798e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzx c(@NonNull String str) {
        return new zzx(false, 1, 5, str, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzx d(@NonNull String str, @NonNull Throwable th) {
        return new zzx(false, 1, 5, str, th);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzx f(int i4) {
        return new zzx(true, i4, 1, null, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzx g(int i4, int i5, @NonNull String str, @Nullable Throwable th) {
        return new zzx(false, i4, i5, str, th);
    }

    @Nullable
    String a() {
        return this.f20800b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void e() {
        if (!this.f20799a && Log.isLoggable("GoogleCertificatesRslt", 3)) {
            if (this.f20801c != null) {
                a();
            } else {
                a();
            }
        }
    }
}
