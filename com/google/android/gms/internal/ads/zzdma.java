package com.google.android.gms.internal.ads;

import androidx.annotation.VisibleForTesting;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
@VisibleForTesting
/* loaded from: classes4.dex */
public final class zzdma extends zzdlk implements zzdcu {
    private zzdcu zza;

    /* JADX INFO: Access modifiers changed from: protected */
    public final synchronized void zzi(com.google.android.gms.ads.internal.client.zza zzaVar, zzbhc zzbhcVar, com.google.android.gms.ads.internal.overlay.zzo zzoVar, zzbhe zzbheVar, com.google.android.gms.ads.internal.overlay.zzz zzzVar, zzdcu zzdcuVar) {
        super.zzh(zzaVar, zzbhcVar, zzoVar, zzbheVar, zzzVar);
        this.zza = zzdcuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdcu
    public final synchronized void zzr() {
        zzdcu zzdcuVar = this.zza;
        if (zzdcuVar != null) {
            zzdcuVar.zzr();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdcu
    public final synchronized void zzs() {
        zzdcu zzdcuVar = this.zza;
        if (zzdcuVar != null) {
            zzdcuVar.zzs();
        }
    }
}
