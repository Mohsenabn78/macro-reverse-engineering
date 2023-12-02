package com.google.android.gms.internal.ads;

import android.os.Bundle;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzemv implements zzeqy {
    @Nullable
    private final zzewl zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzemv(@Nullable zzewl zzewlVar) {
        this.zza = zzewlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeqy
    public final int zza() {
        return 15;
    }

    @Override // com.google.android.gms.internal.ads.zzeqy
    public final zzfwm zzb() {
        zzewl zzewlVar = this.zza;
        zzeqx zzeqxVar = null;
        if (zzewlVar != null && zzewlVar.zza() != null && !zzewlVar.zza().isEmpty()) {
            zzeqxVar = new zzeqx() { // from class: com.google.android.gms.internal.ads.zzemu
                @Override // com.google.android.gms.internal.ads.zzeqx
                public final void zzh(Object obj) {
                    zzemv.this.zzc((Bundle) obj);
                }
            };
        }
        return zzfwc.zzh(zzeqxVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(Bundle bundle) {
        bundle.putString("key_schema", this.zza.zza());
    }
}
