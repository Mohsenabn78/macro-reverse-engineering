package com.google.android.gms.internal.ads;

import androidx.annotation.VisibleForTesting;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
@VisibleForTesting
/* loaded from: classes4.dex */
public final class zzcvs extends zzdaq implements zzcvk {
    @VisibleForTesting
    public zzcvs(Set set) {
        super(set);
    }

    @Override // com.google.android.gms.internal.ads.zzcvk
    public final void zza(final com.google.android.gms.ads.internal.client.zze zzeVar) {
        zzp(new zzdap() { // from class: com.google.android.gms.internal.ads.zzcvp
            @Override // com.google.android.gms.internal.ads.zzdap
            public final void zza(Object obj) {
                ((zzcvw) obj).zzk(com.google.android.gms.ads.internal.client.zze.this);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcvk
    public final void zzb() {
        zzp(new zzdap() { // from class: com.google.android.gms.internal.ads.zzcvq
            @Override // com.google.android.gms.internal.ads.zzdap
            public final void zza(Object obj) {
                ((zzcvw) obj).zzk(zzfbi.zzd(11, null, null));
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcvk
    public final void zzc(final zzdev zzdevVar) {
        zzp(new zzdap() { // from class: com.google.android.gms.internal.ads.zzcvr
            @Override // com.google.android.gms.internal.ads.zzdap
            public final void zza(Object obj) {
                ((zzcvw) obj).zzk(zzfbi.zzd(12, zzdev.this.getMessage(), null));
            }
        });
    }
}
