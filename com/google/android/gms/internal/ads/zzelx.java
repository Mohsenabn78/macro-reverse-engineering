package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzelx implements zzeqy {
    private final Executor zza;
    private final zzbza zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzelx(Executor executor, zzbza zzbzaVar) {
        this.zza = executor;
        this.zzb = zzbzaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeqy
    public final int zza() {
        return 10;
    }

    @Override // com.google.android.gms.internal.ads.zzeqy
    public final zzfwm zzb() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzct)).booleanValue()) {
            return zzfwc.zzh(null);
        }
        return zzfwc.zzl(this.zzb.zzj(), new zzfov() { // from class: com.google.android.gms.internal.ads.zzelv
            @Override // com.google.android.gms.internal.ads.zzfov
            public final Object apply(Object obj) {
                final ArrayList arrayList = (ArrayList) obj;
                if (arrayList.isEmpty()) {
                    return null;
                }
                return new zzeqx() { // from class: com.google.android.gms.internal.ads.zzelw
                    @Override // com.google.android.gms.internal.ads.zzeqx
                    public final void zzh(Object obj2) {
                        ((Bundle) obj2).putStringArrayList("android_permissions", arrayList);
                    }
                };
            }
        }, this.zza);
    }
}
