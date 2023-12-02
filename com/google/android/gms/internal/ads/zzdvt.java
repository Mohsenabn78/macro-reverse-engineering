package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzdvt implements zzcyb {
    private final Context zza;
    private final zzbxw zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdvt(Context context, zzbxw zzbxwVar) {
        this.zza = context;
        this.zzb = zzbxwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcyb
    public final void zzb(zzezz zzezzVar) {
        if (!TextUtils.isEmpty(zzezzVar.zzb.zzb.zzd)) {
            this.zzb.zzp(this.zza, zzezzVar.zza.zza.zzd);
            this.zzb.zzl(this.zza, zzezzVar.zzb.zzb.zzd);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcyb
    public final void zzbA(zzbue zzbueVar) {
    }
}
