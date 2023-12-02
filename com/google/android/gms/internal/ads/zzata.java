package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzata extends zzath {
    public zzata(zzart zzartVar, String str, String str2, zzanq zzanqVar, int i4, int i5) {
        super(zzartVar, "HSZqqXAvfM6p9uyg5JhDHQlMlgQJzMAOkGc0u97KAICZfvxto4YfGWg7De8vgAj2", "daqH0kaQsjOZO0MCcjtalDHoDE4Fma0yQGSHO+ub6NM=", zzanqVar, i4, 51);
    }

    @Override // com.google.android.gms.internal.ads.zzath
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        synchronized (this.zze) {
            zzaro zzaroVar = new zzaro((String) this.zzf.invoke(null, new Object[0]));
            this.zze.zzp(zzaroVar.zza.longValue());
            this.zze.zzq(zzaroVar.zzb.longValue());
        }
    }
}
