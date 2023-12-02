package com.google.android.gms.internal.mlkit_translate;

import org.slf4j.Marker;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes4.dex */
final class zzdh implements zzby {
    final /* synthetic */ Class zza;
    final /* synthetic */ Class zzb;
    final /* synthetic */ zzbx zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdh(Class cls, Class cls2, zzbx zzbxVar) {
        this.zza = cls;
        this.zzb = cls2;
        this.zzc = zzbxVar;
    }

    public final String toString() {
        return "Factory[type=" + this.zzb.getName() + Marker.ANY_NON_NULL_MARKER + this.zza.getName() + ",adapter=" + this.zzc + "]";
    }
}
