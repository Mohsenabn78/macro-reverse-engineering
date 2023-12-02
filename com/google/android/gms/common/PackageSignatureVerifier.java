package com.google.android.gms.common;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.arlosoft.macrodroid.common.Util;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.errorprone.annotations.CheckReturnValue;
import com.google.errorprone.annotations.RestrictedInheritance;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
@CheckReturnValue
@ShowFirstParty
@KeepForSdk
@RestrictedInheritance(allowedOnPath = ".*javatests.*/com/google/android/gms/common/.*", explanation = "Sub classing of GMS Core's APIs are restricted to testing fakes.", link = "go/gmscore-restrictedinheritance")
/* loaded from: classes4.dex */
public class PackageSignatureVerifier {
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private static zzad f19977b;

    /* renamed from: a  reason: collision with root package name */
    private volatile zzac f19978a;

    private static zzad a() {
        zzad zzadVar;
        synchronized (zzad.class) {
            if (f19977b == null) {
                f19977b = new zzad();
            }
            zzadVar = f19977b;
        }
        return zzadVar;
    }

    @NonNull
    @ShowFirstParty
    @KeepForSdk
    public PackageVerificationResult queryPackageSignatureVerified(@NonNull Context context, @NonNull String str) {
        String str2;
        PackageVerificationResult packageVerificationResult;
        String str3;
        PackageVerificationResult packageVerificationResult2;
        boolean honorsDebugCertificates = GooglePlayServicesUtilLight.honorsDebugCertificates(context);
        a();
        if (zzn.f()) {
            if (true != honorsDebugCertificates) {
                str2 = "-0";
            } else {
                str2 = Util.ANY_CONTACT_ID;
            }
            String concat = String.valueOf(str).concat(str2);
            if (this.f19978a != null) {
                str3 = this.f19978a.f20770a;
                if (str3.equals(concat)) {
                    packageVerificationResult2 = this.f19978a.f20771b;
                    return packageVerificationResult2;
                }
            }
            a();
            zzx c4 = zzn.c(str, honorsDebugCertificates, false, false);
            if (c4.f20799a) {
                this.f19978a = new zzac(concat, PackageVerificationResult.zzd(str, c4.f20802d));
                packageVerificationResult = this.f19978a.f20771b;
                return packageVerificationResult;
            }
            Preconditions.checkNotNull(c4.f20800b);
            return PackageVerificationResult.zza(str, c4.f20800b, c4.f20801c);
        }
        throw new zzae();
    }

    @NonNull
    @ShowFirstParty
    @KeepForSdk
    public PackageVerificationResult queryPackageSignatureVerifiedWithRetry(@NonNull Context context, @NonNull String str) {
        try {
            PackageVerificationResult queryPackageSignatureVerified = queryPackageSignatureVerified(context, str);
            queryPackageSignatureVerified.zzb();
            return queryPackageSignatureVerified;
        } catch (SecurityException e4) {
            PackageVerificationResult queryPackageSignatureVerified2 = queryPackageSignatureVerified(context, str);
            if (queryPackageSignatureVerified2.zzc()) {
                Log.e("PkgSignatureVerifier", "Got flaky result during package signature verification", e4);
                return queryPackageSignatureVerified2;
            }
            return queryPackageSignatureVerified2;
        }
    }
}
