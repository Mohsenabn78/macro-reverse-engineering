package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzbmf extends zzcaq {
    private final Object zza = new Object();
    private final zzbmk zzb;
    private boolean zzc;

    public zzbmf(zzbmk zzbmkVar) {
        this.zzb = zzbmkVar;
    }

    public final void zzb() {
        synchronized (this.zza) {
            if (this.zzc) {
                return;
            }
            this.zzc = true;
            zzi(new zzbmc(this), new zzcam());
            zzi(new zzbmd(this), new zzbme(this));
        }
    }
}
