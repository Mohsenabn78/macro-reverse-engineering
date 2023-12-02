package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import androidx.collection.SimpleArrayMap;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdhl {
    public static final zzdhl zza = new zzdhl(new zzdhj());
    @Nullable
    private final zzbfs zzb;
    @Nullable
    private final zzbfp zzc;
    @Nullable
    private final zzbgf zzd;
    @Nullable
    private final zzbgc zze;
    @Nullable
    private final zzbla zzf;
    private final SimpleArrayMap zzg;
    private final SimpleArrayMap zzh;

    @Nullable
    public final zzbfp zza() {
        return this.zzc;
    }

    @Nullable
    public final zzbfs zzb() {
        return this.zzb;
    }

    @Nullable
    public final zzbfv zzc(String str) {
        return (zzbfv) this.zzh.get(str);
    }

    @Nullable
    public final zzbfy zzd(String str) {
        return (zzbfy) this.zzg.get(str);
    }

    @Nullable
    public final zzbgc zze() {
        return this.zze;
    }

    @Nullable
    public final zzbgf zzf() {
        return this.zzd;
    }

    @Nullable
    public final zzbla zzg() {
        return this.zzf;
    }

    public final ArrayList zzh() {
        ArrayList arrayList = new ArrayList(this.zzg.size());
        for (int i4 = 0; i4 < this.zzg.size(); i4++) {
            arrayList.add((String) this.zzg.keyAt(i4));
        }
        return arrayList;
    }

    public final ArrayList zzi() {
        ArrayList arrayList = new ArrayList();
        if (this.zzd != null) {
            arrayList.add(Integer.toString(6));
        }
        if (this.zzb != null) {
            arrayList.add(Integer.toString(1));
        }
        if (this.zzc != null) {
            arrayList.add(Integer.toString(2));
        }
        if (!this.zzg.isEmpty()) {
            arrayList.add(Integer.toString(3));
        }
        if (this.zzf != null) {
            arrayList.add(Integer.toString(7));
        }
        return arrayList;
    }

    private zzdhl(zzdhj zzdhjVar) {
        this.zzb = zzdhjVar.zza;
        this.zzc = zzdhjVar.zzb;
        this.zzd = zzdhjVar.zzc;
        this.zzg = new SimpleArrayMap(zzdhjVar.zzf);
        this.zzh = new SimpleArrayMap(zzdhjVar.zzg);
        this.zze = zzdhjVar.zzd;
        this.zzf = zzdhjVar.zze;
    }
}
