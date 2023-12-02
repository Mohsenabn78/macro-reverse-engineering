package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzefy {
    @Nullable
    private zzefr zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzefy() {
    }

    private zzefy(zzefr zzefrVar) {
        this.zza = zzefrVar;
    }

    public static zzefy zzb(zzefr zzefrVar) {
        return new zzefy(zzefrVar);
    }

    public final zzefr zza(Clock clock, zzefs zzefsVar, zzech zzechVar, zzfgr zzfgrVar) {
        zzefr zzefrVar = this.zza;
        if (zzefrVar != null) {
            return zzefrVar;
        }
        return new zzefr(clock, zzefsVar, zzechVar, zzfgrVar);
    }
}
