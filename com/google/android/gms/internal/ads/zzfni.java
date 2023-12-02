package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzfni extends zzfnu {
    final /* synthetic */ zzfnj zza;
    private final zzfno zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfni(zzfnj zzfnjVar, zzfno zzfnoVar) {
        this.zza = zzfnjVar;
        this.zzb = zzfnoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfnv
    public final void zzb(Bundle bundle) {
        int i4 = bundle.getInt("statusCode", 8150);
        String string = bundle.getString("sessionToken");
        zzfnm zzc = zzfnn.zzc();
        zzc.zzb(i4);
        if (string != null) {
            zzc.zza(string);
        }
        this.zzb.zza(zzc.zzc());
        if (i4 == 8157) {
            this.zza.zzc();
        }
    }
}
