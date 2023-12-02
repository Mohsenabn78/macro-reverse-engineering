package com.google.android.gms.internal.measurement;

import java.io.Serializable;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzir {
    public static zzim zza(zzim zzimVar) {
        if (!(zzimVar instanceof zzip) && !(zzimVar instanceof zzin)) {
            if (zzimVar instanceof Serializable) {
                return new zzin(zzimVar);
            }
            return new zzip(zzimVar);
        }
        return zzimVar;
    }

    public static zzim zzb(Object obj) {
        return new zziq(obj);
    }
}
