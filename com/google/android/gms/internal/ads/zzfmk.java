package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfmk extends zzfuq {
    Object zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfmk(Object obj) {
        this.zza = obj;
    }

    @Override // com.google.android.gms.internal.ads.zzfuq
    public final String zza() {
        Object obj = this.zza;
        if (obj == null) {
            return "";
        }
        return obj.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzfuq
    protected final void zzb() {
        this.zza = null;
    }

    @Override // com.google.android.gms.internal.ads.zzfuq
    public final boolean zzd(Object obj) {
        return super.zzd(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzfuq
    public final boolean zze(Throwable th) {
        return super.zze(th);
    }
}
