package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdnn implements zzcwb {
    @Nullable
    private final zzcez zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdnn(@Nullable zzcez zzcezVar) {
        this.zza = zzcezVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcwb
    public final void zzbn(@Nullable Context context) {
        zzcez zzcezVar = this.zza;
        if (zzcezVar != null) {
            zzcezVar.destroy();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcwb
    public final void zzbp(@Nullable Context context) {
        zzcez zzcezVar = this.zza;
        if (zzcezVar != null) {
            zzcezVar.onPause();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcwb
    public final void zzbq(@Nullable Context context) {
        zzcez zzcezVar = this.zza;
        if (zzcezVar != null) {
            zzcezVar.onResume();
        }
    }
}
