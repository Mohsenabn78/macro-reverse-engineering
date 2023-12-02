package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdError;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzehg implements zzcwp {
    boolean zza = false;
    final /* synthetic */ zzecf zzb;
    final /* synthetic */ zzcaj zzc;
    final /* synthetic */ zzehh zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzehg(zzehh zzehhVar, zzecf zzecfVar, zzcaj zzcajVar) {
        this.zzd = zzehhVar;
        this.zzb = zzecfVar;
        this.zzc = zzcajVar;
    }

    private final synchronized void zze(com.google.android.gms.ads.internal.client.zze zzeVar) {
        int i4 = 1;
        if (true == ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzfi)).booleanValue()) {
            i4 = 3;
        }
        this.zzc.zze(new zzecg(i4, zzeVar));
    }

    @Override // com.google.android.gms.internal.ads.zzcwp
    public final synchronized void zza(int i4) {
        if (this.zza) {
            return;
        }
        this.zza = true;
        zze(new com.google.android.gms.ads.internal.client.zze(i4, zzehh.zze(this.zzb.zza, i4), AdError.UNDEFINED_DOMAIN, null, null));
    }

    @Override // com.google.android.gms.internal.ads.zzcwp
    public final synchronized void zzb(com.google.android.gms.ads.internal.client.zze zzeVar) {
        if (this.zza) {
            return;
        }
        this.zza = true;
        zze(zzeVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcwp
    public final synchronized void zzc(int i4, @Nullable String str) {
        if (this.zza) {
            return;
        }
        this.zza = true;
        if (str == null) {
            str = zzehh.zze(this.zzb.zza, i4);
        }
        zze(new com.google.android.gms.ads.internal.client.zze(i4, str, AdError.UNDEFINED_DOMAIN, null, null));
    }

    @Override // com.google.android.gms.internal.ads.zzcwp
    public final synchronized void zzd() {
        this.zzc.zzd(null);
    }
}
