package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdxq extends zzbtw {
    final /* synthetic */ zzdxr zza;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzdxq(zzdxr zzdxrVar) {
        this.zza = zzdxrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbtx
    public final void zze(com.google.android.gms.ads.internal.util.zzaz zzazVar) {
        this.zza.zza.zze(zzazVar.zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbtx
    public final void zzf(ParcelFileDescriptor parcelFileDescriptor) {
        this.zza.zza.zzd(new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor));
    }
}
