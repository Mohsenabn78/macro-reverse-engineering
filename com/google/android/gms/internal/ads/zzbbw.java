package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
@Deprecated
/* loaded from: classes4.dex */
public final class zzbbw {
    public static boolean zza(@Nullable zzbce zzbceVar, @Nullable zzbcb zzbcbVar, String... strArr) {
        if (zzbcbVar == null) {
            return false;
        }
        zzbceVar.zze(zzbcbVar, com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime(), strArr);
        return true;
    }
}
