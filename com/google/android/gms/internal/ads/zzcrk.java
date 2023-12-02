package com.google.android.gms.internal.ads;

import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzcrk {
    public final List zza;

    public zzcrk(List list) {
        this.zza = list;
    }

    public static zzecc zza(@NonNull zzecc zzeccVar) {
        return new zzecd(zzeccVar, new zzfov() { // from class: com.google.android.gms.internal.ads.zzcrj
            @Override // com.google.android.gms.internal.ads.zzfov
            public final Object apply(Object obj) {
                return new zzcrk((zzcrd) obj);
            }
        });
    }

    public zzcrk(zzcrd zzcrdVar) {
        this.zza = Collections.singletonList(zzfwc.zzh(zzcrdVar));
    }
}
