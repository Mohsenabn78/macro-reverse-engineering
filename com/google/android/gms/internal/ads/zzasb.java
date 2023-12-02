package com.google.android.gms.internal.ads;

import android.app.AppOpsManager;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzasb implements AppOpsManager.OnOpActiveChangedListener {
    final /* synthetic */ zzasc zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzasb(zzasc zzascVar) {
        this.zza = zzascVar;
    }

    @Override // android.app.AppOpsManager.OnOpActiveChangedListener
    public final void onOpActiveChanged(String str, int i4, String str2, boolean z3) {
        long j4;
        long j5;
        long j6;
        if (z3) {
            this.zza.zzb = System.currentTimeMillis();
            this.zza.zze = true;
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        zzasc zzascVar = this.zza;
        j4 = zzascVar.zzc;
        if (j4 > 0) {
            j5 = zzascVar.zzc;
            if (currentTimeMillis >= j5) {
                j6 = zzascVar.zzc;
                zzascVar.zzd = currentTimeMillis - j6;
            }
        }
        this.zza.zze = false;
    }
}
