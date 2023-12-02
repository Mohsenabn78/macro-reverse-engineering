package com.google.android.gms.internal.p002firebaseauthapi;

import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import android.util.Base64;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.android.gms.auth.api.phone.SmsRetriever;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.firebase.auth.PhoneAuthCredential;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzacm  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzacm {
    private static final Logger zza = new Logger("FirebaseAuth", "SmsRetrieverHelper");
    private final Context zzb;
    private final ScheduledExecutorService zzc;
    private final HashMap zzd = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzacm(Context context, ScheduledExecutorService scheduledExecutorService) {
        this.zzb = context;
        this.zzc = scheduledExecutorService;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void zzd(zzacm zzacmVar, String str) {
        zzacl zzaclVar = (zzacl) zzacmVar.zzd.get(str);
        if (zzaclVar != null && !zzac.zzd(zzaclVar.zzd) && !zzac.zzd(zzaclVar.zze) && !zzaclVar.zzb.isEmpty()) {
            for (zzaaq zzaaqVar : zzaclVar.zzb) {
                zzaaqVar.zzr(PhoneAuthCredential.zzc(zzaclVar.zzd, zzaclVar.zze));
            }
            zzaclVar.zzh = true;
        }
    }

    private static String zzl(String str, String str2) {
        String str3 = str + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + str2;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_SHA256);
            messageDigest.update(str3.getBytes(zzk.zzc));
            String substring = Base64.encodeToString(Arrays.copyOf(messageDigest.digest(), 9), 3).substring(0, 11);
            zza.d("Package: " + str + " -- Hash: " + substring, new Object[0]);
            return substring;
        } catch (NoSuchAlgorithmException e4) {
            zza.e("NoSuchAlgorithm: ".concat(String.valueOf(e4.getMessage())), new Object[0]);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzm(String str) {
        zzacl zzaclVar = (zzacl) this.zzd.get(str);
        if (zzaclVar != null && !zzaclVar.zzh && !zzac.zzd(zzaclVar.zzd)) {
            zza.w("Timed out waiting for SMS.", new Object[0]);
            for (zzaaq zzaaqVar : zzaclVar.zzb) {
                zzaaqVar.zza(zzaclVar.zzd);
            }
            zzaclVar.zzi = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zzn */
    public final void zzg(String str) {
        zzacl zzaclVar = (zzacl) this.zzd.get(str);
        if (zzaclVar == null) {
            return;
        }
        if (!zzaclVar.zzi) {
            zzm(str);
        }
        zzi(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzb() {
        SigningInfo signingInfo;
        Signature[] apkContentsSigners;
        try {
            String packageName = this.zzb.getPackageName();
            if (Build.VERSION.SDK_INT >= 28) {
                signingInfo = Wrappers.packageManager(this.zzb).getPackageInfo(packageName, 134217728).signingInfo;
                apkContentsSigners = signingInfo.getApkContentsSigners();
            } else {
                apkContentsSigners = Wrappers.packageManager(this.zzb).getPackageInfo(packageName, 64).signatures;
            }
            String zzl = zzl(packageName, apkContentsSigners[0].toCharsString());
            if (zzl != null) {
                return zzl;
            }
            zza.e("Hash generation failed.", new Object[0]);
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            zza.e("Unable to find package to obtain hash.", new Object[0]);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzh(zzaaq zzaaqVar, String str) {
        zzacl zzaclVar = (zzacl) this.zzd.get(str);
        if (zzaclVar == null) {
            return;
        }
        zzaclVar.zzb.add(zzaaqVar);
        if (zzaclVar.zzg) {
            zzaaqVar.zzb(zzaclVar.zzd);
        }
        if (zzaclVar.zzh) {
            zzaaqVar.zzr(PhoneAuthCredential.zzc(zzaclVar.zzd, zzaclVar.zze));
        }
        if (zzaclVar.zzi) {
            zzaaqVar.zza(zzaclVar.zzd);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzi(String str) {
        zzacl zzaclVar = (zzacl) this.zzd.get(str);
        if (zzaclVar == null) {
            return;
        }
        ScheduledFuture scheduledFuture = zzaclVar.zzf;
        if (scheduledFuture != null && !scheduledFuture.isDone()) {
            zzaclVar.zzf.cancel(false);
        }
        zzaclVar.zzb.clear();
        this.zzd.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzj(final String str, zzaaq zzaaqVar, long j4, boolean z3) {
        this.zzd.put(str, new zzacl(j4, z3));
        zzh(zzaaqVar, str);
        zzacl zzaclVar = (zzacl) this.zzd.get(str);
        long j5 = zzaclVar.zza;
        if (j5 <= 0) {
            zza.w("Timeout of 0 specified; SmsRetriever will not start.", new Object[0]);
            return;
        }
        zzaclVar.zzf = this.zzc.schedule(new Runnable() { // from class: com.google.android.gms.internal.firebase-auth-api.zzach
            @Override // java.lang.Runnable
            public final void run() {
                zzacm.this.zzg(str);
            }
        }, j5, TimeUnit.SECONDS);
        if (!zzaclVar.zzc) {
            zza.w("SMS auto-retrieval unavailable; SmsRetriever will not start.", new Object[0]);
            return;
        }
        zzack zzackVar = new zzack(this, str);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(SmsRetriever.SMS_RETRIEVED_ACTION);
        zzb.zza(this.zzb.getApplicationContext(), zzackVar, intentFilter);
        SmsRetriever.getClient(this.zzb).startSmsRetriever().addOnFailureListener(new zzaci(this));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzk(String str) {
        if (this.zzd.get(str) != null) {
            return true;
        }
        return false;
    }
}
