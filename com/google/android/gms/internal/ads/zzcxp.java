package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzcxp extends zzdaq implements zzcwa, zzcxf {
    private final zzezn zzb;
    private final AtomicBoolean zzc;

    public zzcxp(Set set, zzezn zzeznVar) {
        super(set);
        this.zzc = new AtomicBoolean();
        this.zzb = zzeznVar;
    }

    private final void zzb() {
        com.google.android.gms.ads.internal.client.zzs zzsVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzhr)).booleanValue() && this.zzc.compareAndSet(false, true) && (zzsVar = this.zzb.zzaf) != null && zzsVar.zza == 3) {
            zzp(new zzdap() { // from class: com.google.android.gms.internal.ads.zzcxo
                @Override // com.google.android.gms.internal.ads.zzdap
                public final void zza(Object obj) {
                    zzcxp.this.zza((zzcxr) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzcxr zzcxrVar) throws Exception {
        zzcxrVar.zzh(this.zzb.zzaf);
    }

    @Override // com.google.android.gms.internal.ads.zzcxf
    public final void zzg() {
        if (this.zzb.zzb == 1) {
            zzb();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcwa
    public final void zzl() {
        int i4 = this.zzb.zzb;
        if (i4 != 2 && i4 != 5 && i4 != 4 && i4 != 6 && i4 != 7) {
            return;
        }
        zzb();
    }
}
