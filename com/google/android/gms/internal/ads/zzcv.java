package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.android.dx.io.Opcodes;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzcv {
    private static final String zzA;
    private static final String zzB;
    private static final String zzC;
    private static final String zzD;
    private static final String zzE;
    public static final zzn zzb;
    private static final zzbp zzr;
    private static final String zzs;
    private static final String zzt;
    private static final String zzu;
    private static final String zzv;
    private static final String zzw;
    private static final String zzx;
    private static final String zzy;
    private static final String zzz;
    public Object zzc = zza;
    public zzbp zzd = zzr;
    public long zze;
    public long zzf;
    public long zzg;
    public boolean zzh;
    public boolean zzi;
    @Deprecated
    public boolean zzj;
    @Nullable
    public zzbf zzk;
    public boolean zzl;
    public long zzm;
    public long zzn;
    public int zzo;
    public int zzp;
    public static final Object zza = new Object();
    private static final Object zzq = new Object();

    static {
        zzar zzarVar = new zzar();
        zzarVar.zza("androidx.media3.common.Timeline");
        zzarVar.zzb(Uri.EMPTY);
        zzr = zzarVar.zzc();
        zzs = Integer.toString(1, 36);
        zzt = Integer.toString(2, 36);
        zzu = Integer.toString(3, 36);
        zzv = Integer.toString(4, 36);
        zzw = Integer.toString(5, 36);
        zzx = Integer.toString(6, 36);
        zzy = Integer.toString(7, 36);
        zzz = Integer.toString(8, 36);
        zzA = Integer.toString(9, 36);
        zzB = Integer.toString(10, 36);
        zzC = Integer.toString(11, 36);
        zzD = Integer.toString(12, 36);
        zzE = Integer.toString(13, 36);
        zzb = new zzn() { // from class: com.google.android.gms.internal.ads.zzcu
        };
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzcv.class.equals(obj.getClass())) {
            zzcv zzcvVar = (zzcv) obj;
            if (zzfj.zzC(this.zzc, zzcvVar.zzc) && zzfj.zzC(this.zzd, zzcvVar.zzd) && zzfj.zzC(null, null) && zzfj.zzC(this.zzk, zzcvVar.zzk) && this.zze == zzcvVar.zze && this.zzf == zzcvVar.zzf && this.zzg == zzcvVar.zzg && this.zzh == zzcvVar.zzh && this.zzi == zzcvVar.zzi && this.zzl == zzcvVar.zzl && this.zzn == zzcvVar.zzn && this.zzo == zzcvVar.zzo && this.zzp == zzcvVar.zzp) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode;
        int hashCode2 = ((this.zzc.hashCode() + Opcodes.RSUB_INT_LIT8) * 31) + this.zzd.hashCode();
        zzbf zzbfVar = this.zzk;
        if (zzbfVar == null) {
            hashCode = 0;
        } else {
            hashCode = zzbfVar.hashCode();
        }
        long j4 = this.zze;
        long j5 = this.zzf;
        long j6 = this.zzg;
        int i4 = (((((((((((((hashCode2 * 961) + hashCode) * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31) + ((int) (j5 ^ (j5 >>> 32)))) * 31) + ((int) (j6 ^ (j6 >>> 32)))) * 31) + (this.zzh ? 1 : 0)) * 31) + (this.zzi ? 1 : 0)) * 31) + (this.zzl ? 1 : 0);
        long j7 = this.zzn;
        return ((((((i4 * 961) + ((int) (j7 ^ (j7 >>> 32)))) * 31) + this.zzo) * 31) + this.zzp) * 31;
    }

    public final zzcv zza(Object obj, @Nullable zzbp zzbpVar, @Nullable Object obj2, long j4, long j5, long j6, boolean z3, boolean z4, @Nullable zzbf zzbfVar, long j7, long j8, int i4, int i5, long j9) {
        zzbp zzbpVar2;
        boolean z5;
        this.zzc = obj;
        if (zzbpVar == null) {
            zzbpVar2 = zzr;
        } else {
            zzbpVar2 = zzbpVar;
        }
        this.zzd = zzbpVar2;
        this.zze = -9223372036854775807L;
        this.zzf = -9223372036854775807L;
        this.zzg = -9223372036854775807L;
        this.zzh = z3;
        this.zzi = z4;
        if (zzbfVar != null) {
            z5 = true;
        } else {
            z5 = false;
        }
        this.zzj = z5;
        this.zzk = zzbfVar;
        this.zzm = 0L;
        this.zzn = j8;
        this.zzo = 0;
        this.zzp = 0;
        this.zzl = false;
        return this;
    }

    public final boolean zzb() {
        boolean z3;
        boolean z4;
        boolean z5 = this.zzj;
        if (this.zzk == null) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (z5 == z3) {
            z4 = true;
        } else {
            z4 = false;
        }
        zzdy.zzf(z4);
        if (this.zzk == null) {
            return false;
        }
        return true;
    }
}
