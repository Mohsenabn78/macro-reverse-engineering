package com.google.android.gms.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.errorprone.annotations.CheckReturnValue;
import com.google.errorprone.annotations.RestrictedInheritance;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
@CheckReturnValue
@ShowFirstParty
@KeepForSdk
@RestrictedInheritance(allowedOnPath = ".*java.*/com/google/android/gms/common/testing/.*", explanation = "Sub classing of GMS Core's APIs are restricted to testing fakes.", link = "go/gmscore-restrictedinheritance")
/* loaded from: classes4.dex */
public class GoogleSignatureVerifier {
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private static GoogleSignatureVerifier f19974c;

    /* renamed from: a  reason: collision with root package name */
    private final Context f19975a;

    /* renamed from: b  reason: collision with root package name */
    private volatile String f19976b;

    public GoogleSignatureVerifier(@NonNull Context context) {
        this.f19975a = context.getApplicationContext();
    }

    @Nullable
    static final zzj a(PackageInfo packageInfo, zzj... zzjVarArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr == null) {
            return null;
        }
        if (signatureArr.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        zzk zzkVar = new zzk(packageInfo.signatures[0].toByteArray());
        for (int i4 = 0; i4 < zzjVarArr.length; i4++) {
            if (zzjVarArr[i4].equals(zzkVar)) {
                return zzjVarArr[i4];
            }
        }
        return null;
    }

    @SuppressLint({"PackageManagerGetSignatures"})
    private final zzx b(String str, boolean z3, boolean z4) {
        zzx c4;
        ApplicationInfo applicationInfo;
        if (str == null) {
            return zzx.c("null pkg");
        }
        if (!str.equals(this.f19976b)) {
            if (zzn.g()) {
                c4 = zzn.b(str, GooglePlayServicesUtilLight.honorsDebugCertificates(this.f19975a), false, false);
            } else {
                try {
                    PackageInfo packageInfo = this.f19975a.getPackageManager().getPackageInfo(str, 64);
                    boolean honorsDebugCertificates = GooglePlayServicesUtilLight.honorsDebugCertificates(this.f19975a);
                    if (packageInfo == null) {
                        c4 = zzx.c("null pkg");
                    } else {
                        Signature[] signatureArr = packageInfo.signatures;
                        if (signatureArr != null && signatureArr.length == 1) {
                            zzk zzkVar = new zzk(packageInfo.signatures[0].toByteArray());
                            String str2 = packageInfo.packageName;
                            zzx a4 = zzn.a(str2, zzkVar, honorsDebugCertificates, false);
                            if (a4.f20799a && (applicationInfo = packageInfo.applicationInfo) != null && (applicationInfo.flags & 2) != 0 && zzn.a(str2, zzkVar, false, true).f20799a) {
                                c4 = zzx.c("debuggable release cert app rejected");
                            } else {
                                c4 = a4;
                            }
                        } else {
                            c4 = zzx.c("single cert required");
                        }
                    }
                } catch (PackageManager.NameNotFoundException e4) {
                    return zzx.d("no pkg ".concat(str), e4);
                }
            }
            if (c4.f20799a) {
                this.f19976b = str;
            }
            return c4;
        }
        return zzx.b();
    }

    @NonNull
    @KeepForSdk
    public static GoogleSignatureVerifier getInstance(@NonNull Context context) {
        Preconditions.checkNotNull(context);
        synchronized (GoogleSignatureVerifier.class) {
            if (f19974c == null) {
                zzn.e(context);
                f19974c = new GoogleSignatureVerifier(context);
            }
        }
        return f19974c;
    }

    public static final boolean zzb(@NonNull PackageInfo packageInfo, boolean z3) {
        zzj a4;
        if (z3 && packageInfo != null && ("com.android.vending".equals(packageInfo.packageName) || "com.google.android.gms".equals(packageInfo.packageName))) {
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            if (applicationInfo == null || (applicationInfo.flags & 129) == 0) {
                z3 = false;
            } else {
                z3 = true;
            }
        }
        if (packageInfo != null && packageInfo.signatures != null) {
            if (z3) {
                a4 = a(packageInfo, zzm.f20776a);
            } else {
                a4 = a(packageInfo, zzm.f20776a[0]);
            }
            if (a4 != null) {
                return true;
            }
        }
        return false;
    }

    @KeepForSdk
    public boolean isGooglePublicSignedPackage(@NonNull PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (zzb(packageInfo, false)) {
            return true;
        }
        if (zzb(packageInfo, true)) {
            if (GooglePlayServicesUtilLight.honorsDebugCertificates(this.f19975a)) {
                return true;
            }
            Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        }
        return false;
    }

    @ShowFirstParty
    @KeepForSdk
    public boolean isPackageGoogleSigned(@NonNull String str) {
        zzx b4 = b(str, false, false);
        b4.e();
        return b4.f20799a;
    }

    @ShowFirstParty
    @KeepForSdk
    public boolean isUidGoogleSigned(int i4) {
        zzx c4;
        int length;
        String[] packagesForUid = this.f19975a.getPackageManager().getPackagesForUid(i4);
        if (packagesForUid != null && (length = packagesForUid.length) != 0) {
            c4 = null;
            int i5 = 0;
            while (true) {
                if (i5 < length) {
                    c4 = b(packagesForUid[i5], false, false);
                    if (c4.f20799a) {
                        break;
                    }
                    i5++;
                } else {
                    Preconditions.checkNotNull(c4);
                    break;
                }
            }
        } else {
            c4 = zzx.c("no pkgs");
        }
        c4.e();
        return c4.f20799a;
    }
}
