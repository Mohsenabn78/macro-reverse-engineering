package com.google.android.gms.internal.mlkit_common;

import androidx.annotation.Nullable;

/* compiled from: com.google.mlkit:common@@18.5.0 */
/* loaded from: classes4.dex */
public final class zznb {
    @Nullable
    private static zzna zza;

    public static synchronized zzmq zza(zzmj zzmjVar) {
        zzmq zzmqVar;
        synchronized (zznb.class) {
            if (zza == null) {
                zza = new zzna(null);
            }
            zzmqVar = (zzmq) zza.get(zzmjVar);
        }
        return zzmqVar;
    }

    public static synchronized zzmq zzb(String str) {
        zzmq zza2;
        synchronized (zznb.class) {
            zza2 = zza(zzmj.zzd("common").zzd());
        }
        return zza2;
    }
}
