package com.google.android.gms.internal.ads;

import android.os.Bundle;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzeqr implements zzeqy {
    private final boolean zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeqr(@Nullable zzexi zzexiVar) {
        boolean z3;
        if (zzexiVar != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.zza = z3;
    }

    @Override // com.google.android.gms.internal.ads.zzeqy
    public final int zza() {
        return 36;
    }

    @Override // com.google.android.gms.internal.ads.zzeqy
    public final zzfwm zzb() {
        zzeqq zzeqqVar;
        if (this.zza) {
            zzeqqVar = new zzeqx() { // from class: com.google.android.gms.internal.ads.zzeqq
                @Override // com.google.android.gms.internal.ads.zzeqx
                public final void zzh(Object obj) {
                    ((Bundle) obj).putBoolean("sdk_prefetch", true);
                }
            };
        } else {
            zzeqqVar = null;
        }
        return zzfwc.zzh(zzeqqVar);
    }
}
