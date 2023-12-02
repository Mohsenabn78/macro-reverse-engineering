package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzcnd implements zzcwb {
    private final zzfbd zza;

    public zzcnd(zzfbd zzfbdVar) {
        this.zza = zzfbdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcwb
    public final void zzbn(@Nullable Context context) {
        try {
            this.zza.zzg();
        } catch (zzfan e4) {
            zzbzr.zzk("Cannot invoke onDestroy for the mediation adapter.", e4);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcwb
    public final void zzbp(@Nullable Context context) {
        try {
            this.zza.zzt();
        } catch (zzfan e4) {
            zzbzr.zzk("Cannot invoke onPause for the mediation adapter.", e4);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcwb
    public final void zzbq(@Nullable Context context) {
        try {
            this.zza.zzu();
            if (context != null) {
                this.zza.zzs(context);
            }
        } catch (zzfan e4) {
            zzbzr.zzk("Cannot invoke onResume for the mediation adapter.", e4);
        }
    }
}
