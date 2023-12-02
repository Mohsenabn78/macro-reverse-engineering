package com.google.android.gms.internal.mlkit_translate;

import androidx.annotation.Nullable;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes4.dex */
public final class zzqf {
    @Nullable
    private static zzqe zza;

    public static synchronized zzps zza(zzpl zzplVar) {
        zzps zzpsVar;
        synchronized (zzqf.class) {
            if (zza == null) {
                zza = new zzqe(null);
            }
            zzpsVar = (zzps) zza.get(zzplVar);
        }
        return zzpsVar;
    }

    public static synchronized zzps zzb(String str) {
        zzps zza2;
        synchronized (zzqf.class) {
            zza2 = zza(zzpl.zzd("translate").zzd());
        }
        return zza2;
    }
}
