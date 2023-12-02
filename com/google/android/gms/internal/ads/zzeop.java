package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzeop implements zzeqx {
    public final zzezm zza;

    public zzeop(zzezm zzezmVar) {
        this.zza = zzezmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeqx
    public final /* bridge */ /* synthetic */ void zzh(Object obj) {
        Bundle bundle = (Bundle) obj;
        zzezm zzezmVar = this.zza;
        if (zzezmVar != null) {
            bundle.putBoolean("render_in_browser", zzezmVar.zzd());
            bundle.putBoolean("disable_ml", this.zza.zzc());
        }
    }
}
