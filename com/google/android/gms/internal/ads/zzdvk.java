package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdvk extends zzbtz {
    final /* synthetic */ zzdvl zza;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzdvk(zzdvl zzdvlVar) {
        this.zza = zzdvlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbua
    public final void zze(com.google.android.gms.ads.internal.util.zzaz zzazVar) {
        this.zza.zza.zze(zzazVar.zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbua
    public final void zzf(ParcelFileDescriptor parcelFileDescriptor) {
        this.zza.zza.zzd(new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor));
    }
}
