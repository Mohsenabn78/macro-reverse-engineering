package com.google.android.gms.internal.ads;

import android.graphics.Color;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzbea extends zzbei {
    static final int zza;
    static final int zzb;
    private static final int zzc;
    private final String zzd;
    private final List zze = new ArrayList();
    private final List zzf = new ArrayList();
    private final int zzg;
    private final int zzh;
    private final int zzi;
    private final int zzj;
    private final int zzk;

    static {
        int rgb = Color.rgb(12, 174, 206);
        zzc = rgb;
        zza = Color.rgb(204, 204, 204);
        zzb = rgb;
    }

    public zzbea(String str, List list, Integer num, Integer num2, Integer num3, int i4, int i5, boolean z3) {
        int i6;
        int i7;
        int i8;
        this.zzd = str;
        for (int i9 = 0; i9 < list.size(); i9++) {
            zzbed zzbedVar = (zzbed) list.get(i9);
            this.zze.add(zzbedVar);
            this.zzf.add(zzbedVar);
        }
        if (num != null) {
            i6 = num.intValue();
        } else {
            i6 = zza;
        }
        this.zzg = i6;
        if (num2 != null) {
            i7 = num2.intValue();
        } else {
            i7 = zzb;
        }
        this.zzh = i7;
        if (num3 != null) {
            i8 = num3.intValue();
        } else {
            i8 = 12;
        }
        this.zzi = i8;
        this.zzj = i4;
        this.zzk = i5;
    }

    public final int zzb() {
        return this.zzj;
    }

    public final int zzc() {
        return this.zzk;
    }

    public final int zzd() {
        return this.zzg;
    }

    public final int zze() {
        return this.zzh;
    }

    public final int zzf() {
        return this.zzi;
    }

    @Override // com.google.android.gms.internal.ads.zzbej
    public final String zzg() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzbej
    public final List zzh() {
        return this.zzf;
    }

    public final List zzi() {
        return this.zze;
    }
}
