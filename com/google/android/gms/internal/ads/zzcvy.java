package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzcvy extends zzdaq {
    private boolean zzb;

    public zzcvy(Set set) {
        super(set);
        this.zzb = false;
    }

    public final synchronized void zza() {
        if (!this.zzb) {
            zzp(new zzdap() { // from class: com.google.android.gms.internal.ads.zzcvx
                @Override // com.google.android.gms.internal.ads.zzdap
                public final void zza(Object obj) {
                    ((zzcwa) obj).zzl();
                }
            });
            this.zzb = true;
        }
    }
}
