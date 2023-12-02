package com.google.android.gms.internal.p002firebaseauthapi;

import android.os.Build;
import java.security.GeneralSecurityException;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjt  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzjt {
    public static final /* synthetic */ int zza = 0;
    private static final Object zzb = new Object();
    private static final String zzc = "zzjt";
    private final zzcb zzd;
    private final zzbd zze;
    @GuardedBy("this")
    private final zzca zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzjt(zzjr zzjrVar, zzjs zzjsVar) {
        this.zzd = new zzjw(zzjr.zza(zzjrVar), zzjr.zzh(zzjrVar), zzjr.zzi(zzjrVar));
        this.zze = zzjr.zzb(zzjrVar);
        this.zzf = zzjr.zzc(zzjrVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ boolean zzd() {
        if (Build.VERSION.SDK_INT >= 23) {
            return true;
        }
        return false;
    }

    public final synchronized zzbz zza() throws GeneralSecurityException {
        return this.zzf.zzb();
    }
}
