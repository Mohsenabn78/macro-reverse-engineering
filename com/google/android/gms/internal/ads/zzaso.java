package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzaso extends zzath {
    private final Map zzi;
    private final View zzj;
    private final Context zzk;

    public zzaso(zzart zzartVar, String str, String str2, zzanq zzanqVar, int i4, int i5, Map map, View view, Context context) {
        super(zzartVar, "8A6/EDFVHoT40S+hatGoptnyThtgSNe3d9RgnDPM1sB7IlgQEsqPlgL1Jhl6dC4s", "93eE6DMOIbdNN+XzPfwTeV3VtXW82G23sIL9X3G1CFc=", zzanqVar, i4, 85);
        this.zzi = map;
        this.zzj = view;
        this.zzk = context;
    }

    private final long zzc(int i4) {
        Map map = this.zzi;
        Integer valueOf = Integer.valueOf(i4);
        if (map.containsKey(valueOf)) {
            return ((Long) this.zzi.get(valueOf)).longValue();
        }
        return Long.MIN_VALUE;
    }

    @Override // com.google.android.gms.internal.ads.zzath
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        long[] jArr = {zzc(1), zzc(2)};
        Context context = this.zzk;
        if (context == null) {
            context = this.zzb.zzb();
        }
        long[] jArr2 = (long[]) this.zzf.invoke(null, jArr, context, this.zzj);
        long j4 = jArr2[0];
        this.zzi.put(1, Long.valueOf(jArr2[1]));
        long j5 = jArr2[2];
        this.zzi.put(2, Long.valueOf(jArr2[3]));
        synchronized (this.zze) {
            this.zze.zzv(j4);
            this.zze.zzu(j5);
        }
    }
}
