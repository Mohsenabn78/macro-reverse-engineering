package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzco {
    @Nullable
    public final Object zzb;
    public final int zzc;
    @Nullable
    public final zzbp zzd;
    @Nullable
    public final Object zze;
    public final int zzf;
    public final long zzg;
    public final long zzh;
    public final int zzi;
    public final int zzj;
    private static final String zzk = Integer.toString(0, 36);
    private static final String zzl = Integer.toString(1, 36);
    private static final String zzm = Integer.toString(2, 36);
    private static final String zzn = Integer.toString(3, 36);
    private static final String zzo = Integer.toString(4, 36);
    private static final String zzp = Integer.toString(5, 36);
    private static final String zzq = Integer.toString(6, 36);
    public static final zzn zza = new zzn() { // from class: com.google.android.gms.internal.ads.zzcn
    };

    public zzco(@Nullable Object obj, int i4, @Nullable zzbp zzbpVar, @Nullable Object obj2, int i5, long j4, long j5, int i6, int i7) {
        this.zzb = obj;
        this.zzc = i4;
        this.zzd = zzbpVar;
        this.zze = obj2;
        this.zzf = i5;
        this.zzg = j4;
        this.zzh = j5;
        this.zzi = i6;
        this.zzj = i7;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzco.class == obj.getClass()) {
            zzco zzcoVar = (zzco) obj;
            if (this.zzc == zzcoVar.zzc && this.zzf == zzcoVar.zzf && this.zzg == zzcoVar.zzg && this.zzh == zzcoVar.zzh && this.zzi == zzcoVar.zzi && this.zzj == zzcoVar.zzj && zzfpc.zza(this.zzb, zzcoVar.zzb) && zzfpc.zza(this.zze, zzcoVar.zze) && zzfpc.zza(this.zzd, zzcoVar.zzd)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zzb, Integer.valueOf(this.zzc), this.zzd, this.zze, Integer.valueOf(this.zzf), Long.valueOf(this.zzg), Long.valueOf(this.zzh), Integer.valueOf(this.zzi), Integer.valueOf(this.zzj)});
    }
}
