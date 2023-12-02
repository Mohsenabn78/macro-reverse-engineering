package com.google.android.gms.internal.ads;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzbmk extends zzcaq {
    private final com.google.android.gms.ads.internal.util.zzbb zzb;
    private final Object zza = new Object();
    private boolean zzc = false;
    private int zzd = 0;

    public zzbmk(com.google.android.gms.ads.internal.util.zzbb zzbbVar) {
        this.zzb = zzbbVar;
    }

    public final zzbmf zza() {
        boolean z3;
        zzbmf zzbmfVar = new zzbmf(this);
        synchronized (this.zza) {
            zzi(new zzbmg(this, zzbmfVar), new zzbmh(this, zzbmfVar));
            if (this.zzd >= 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkState(z3);
            this.zzd++;
        }
        return zzbmfVar;
    }

    public final void zzb() {
        boolean z3;
        synchronized (this.zza) {
            if (this.zzd >= 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkState(z3);
            com.google.android.gms.ads.internal.util.zze.zza("Releasing root reference. JS Engine will be destroyed once other references are released.");
            this.zzc = true;
            zzc();
        }
    }

    protected final void zzc() {
        boolean z3;
        synchronized (this.zza) {
            if (this.zzd >= 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkState(z3);
            if (this.zzc && this.zzd == 0) {
                com.google.android.gms.ads.internal.util.zze.zza("No reference is left (including root). Cleaning up engine.");
                zzi(new zzbmj(this), new zzcam());
            } else {
                com.google.android.gms.ads.internal.util.zze.zza("There are still references to the engine. Not destroying.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzd() {
        boolean z3;
        synchronized (this.zza) {
            if (this.zzd > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkState(z3);
            com.google.android.gms.ads.internal.util.zze.zza("Releasing 1 reference for JS Engine");
            this.zzd--;
            zzc();
        }
    }
}
