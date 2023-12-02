package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
@ParametersAreNonnullByDefault
@Deprecated
/* loaded from: classes4.dex */
public final class zzbcc {
    private final Map zza = new HashMap();
    private final zzbce zzb;

    public zzbcc(zzbce zzbceVar) {
        this.zzb = zzbceVar;
    }

    public final zzbce zza() {
        return this.zzb;
    }

    public final void zzb(String str, @Nullable zzbcb zzbcbVar) {
        this.zza.put(str, zzbcbVar);
    }

    public final void zzc(String str, String str2, long j4) {
        zzbce zzbceVar = this.zzb;
        zzbcb zzbcbVar = (zzbcb) this.zza.get(str2);
        String[] strArr = {str};
        if (zzbcbVar != null) {
            zzbceVar.zze(zzbcbVar, j4, strArr);
        }
        this.zza.put(str, new zzbcb(j4, null, null));
    }
}
