package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzcrf implements zzcrg {
    private final Map zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcrf(Map map) {
        this.zza = map;
    }

    @Override // com.google.android.gms.internal.ads.zzcrg
    @Nullable
    public final zzecc zza(int i4, String str) {
        return (zzecc) this.zza.get(str);
    }
}
