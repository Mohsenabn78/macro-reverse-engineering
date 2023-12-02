package com.google.android.gms.common;

import androidx.annotation.NonNull;
import com.google.errorprone.annotations.CheckReturnValue;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
@CheckReturnValue
/* loaded from: classes4.dex */
public class PackageVerificationResult {

    /* renamed from: a  reason: collision with root package name */
    private final String f19979a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f19980b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final String f19981c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private final Throwable f19982d;

    private PackageVerificationResult(String str, int i4, boolean z3, @Nullable String str2, @Nullable Throwable th) {
        this.f19979a = str;
        this.f19980b = z3;
        this.f19981c = str2;
        this.f19982d = th;
    }

    @NonNull
    public static PackageVerificationResult zza(@NonNull String str, @NonNull String str2, @Nullable Throwable th) {
        return new PackageVerificationResult(str, 1, false, str2, th);
    }

    @NonNull
    public static PackageVerificationResult zzd(@NonNull String str, int i4) {
        return new PackageVerificationResult(str, i4, true, null, null);
    }

    public final void zzb() {
        if (!this.f19980b) {
            String concat = "PackageVerificationRslt: ".concat(String.valueOf(this.f19981c));
            Throwable th = this.f19982d;
            if (th != null) {
                throw new SecurityException(concat, th);
            }
            throw new SecurityException(concat);
        }
    }

    public final boolean zzc() {
        return this.f19980b;
    }
}
