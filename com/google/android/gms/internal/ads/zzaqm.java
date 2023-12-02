package com.google.android.gms.internal.ads;

import android.os.ConditionVariable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzaqm implements Runnable {
    final /* synthetic */ zzaqn zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaqm(zzaqn zzaqnVar) {
        this.zza = zzaqnVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ConditionVariable conditionVariable;
        boolean z3;
        zzart zzartVar;
        ConditionVariable conditionVariable2;
        if (this.zza.zzb == null) {
            conditionVariable = zzaqn.zzc;
            synchronized (conditionVariable) {
                if (this.zza.zzb != null) {
                    return;
                }
                boolean z4 = false;
                try {
                    z3 = ((Boolean) zzbbm.zzci.zze()).booleanValue();
                } catch (IllegalStateException unused) {
                    z3 = false;
                }
                if (z3) {
                    try {
                        zzartVar = this.zza.zze;
                        zzaqn.zza = zzfld.zzb(zzartVar.zza, "ADSHIELD", null);
                    } catch (Throwable unused2) {
                    }
                }
                z4 = z3;
                this.zza.zzb = Boolean.valueOf(z4);
                conditionVariable2 = zzaqn.zzc;
                conditionVariable2.open();
            }
        }
    }
}
