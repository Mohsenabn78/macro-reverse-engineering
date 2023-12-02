package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzcap implements zzfvy {
    final /* synthetic */ zzcan zza;
    final /* synthetic */ zzcal zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcap(zzcaq zzcaqVar, zzcan zzcanVar, zzcal zzcalVar) {
        this.zza = zzcanVar;
        this.zzb = zzcalVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfvy
    public final void zza(Throwable th) {
        this.zzb.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzfvy
    public final void zzb(@Nullable Object obj) {
        this.zza.zza(obj);
    }
}
