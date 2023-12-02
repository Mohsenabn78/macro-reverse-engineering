package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.core.content.ContextCompat;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzekk implements zzeqy {
    private final Context zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzekk(Context context) {
        this.zza = context;
    }

    @Override // com.google.android.gms.internal.ads.zzeqy
    public final int zza() {
        return 2;
    }

    @Override // com.google.android.gms.internal.ads.zzeqy
    public final zzfwm zzb() {
        boolean z3;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzcB)).booleanValue()) {
            if (ContextCompat.checkSelfPermission(this.zza, "com.google.android.gms.permission.AD_ID") == 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            return zzfwc.zzh(new zzekl(z3));
        }
        return zzfwc.zzh(null);
    }
}
