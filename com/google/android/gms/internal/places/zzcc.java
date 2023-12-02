package com.google.android.gms.internal.places;

import java.io.IOException;

/* loaded from: classes4.dex */
public final class zzcc<K, V> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> void zzb(zzaj zzajVar, zzcb<K, V> zzcbVar, K k4, V v3) throws IOException {
        zzav.zzb(zzajVar, zzcbVar.zzkj, 1, k4);
        zzav.zzb(zzajVar, zzcbVar.zzkl, 2, v3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> int zzb(zzcb<K, V> zzcbVar, K k4, V v3) {
        return zzav.zzb(zzcbVar.zzkj, 1, k4) + zzav.zzb(zzcbVar.zzkl, 2, v3);
    }
}
