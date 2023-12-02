package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzcug implements zzcwu, zzcwb {
    private final Context zza;
    private final zzezn zzb;
    private final zzbry zzc;

    public zzcug(Context context, zzezn zzeznVar, zzbry zzbryVar) {
        this.zza = context;
        this.zzb = zzeznVar;
        this.zzc = zzbryVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcwu
    public final void zzn() {
        zzbrz zzbrzVar = this.zzb.zzae;
        if (zzbrzVar != null && zzbrzVar.zza) {
            ArrayList arrayList = new ArrayList();
            if (!this.zzb.zzae.zzb.isEmpty()) {
                arrayList.add(this.zzb.zzae.zzb);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcwb
    public final void zzbn(@Nullable Context context) {
    }

    @Override // com.google.android.gms.internal.ads.zzcwb
    public final void zzbp(@Nullable Context context) {
    }

    @Override // com.google.android.gms.internal.ads.zzcwb
    public final void zzbq(@Nullable Context context) {
    }
}
