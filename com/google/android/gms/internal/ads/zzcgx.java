package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzcgx {
    private final zzbzx zza;
    private final Context zzb;
    private final WeakReference zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzcgx(zzcgv zzcgvVar, zzcgw zzcgwVar) {
        zzbzx zzbzxVar;
        Context context;
        WeakReference weakReference;
        zzbzxVar = zzcgvVar.zza;
        this.zza = zzbzxVar;
        context = zzcgvVar.zzb;
        this.zzb = context;
        weakReference = zzcgvVar.zzc;
        this.zzc = weakReference;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Context zza() {
        return this.zzb;
    }

    public final zzaqs zzb() {
        return new zzaqs(new com.google.android.gms.ads.internal.zzi(this.zzb, this.zza));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzbdy zzc() {
        return new zzbdy(this.zzb);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzbzx zzd() {
        return this.zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zze() {
        return com.google.android.gms.ads.internal.zzt.zzp().zzc(this.zzb, this.zza.zza);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final WeakReference zzf() {
        return this.zzc;
    }
}
