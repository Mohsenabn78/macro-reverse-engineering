package com.google.android.gms.internal.ads;

import android.media.Spatializer;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzwq implements Spatializer.OnSpatializerStateChangedListener {
    final /* synthetic */ zzwy zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzwq(zzwr zzwrVar, zzwy zzwyVar) {
        this.zza = zzwyVar;
    }

    @Override // android.media.Spatializer.OnSpatializerStateChangedListener
    public final void onSpatializerAvailableChanged(Spatializer spatializer, boolean z3) {
        zzwy.zzh(this.zza);
    }

    @Override // android.media.Spatializer.OnSpatializerStateChangedListener
    public final void onSpatializerEnabledChanged(Spatializer spatializer, boolean z3) {
        zzwy.zzh(this.zza);
    }
}
