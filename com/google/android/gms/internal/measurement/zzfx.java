package com.google.android.gms.internal.measurement;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzfx extends zzlb implements zzmj {
    private static final zzfx zza;
    private int zzd;
    private long zzg;
    private float zzh;
    private double zzi;
    private String zze = "";
    private String zzf = "";
    private zzli zzj = zzlb.zzbH();

    static {
        zzfx zzfxVar = new zzfx();
        zza = zzfxVar;
        zzlb.zzbO(zzfx.class, zzfxVar);
    }

    private zzfx() {
    }

    public static zzfw zze() {
        return (zzfw) zza.zzbA();
    }

    public static /* synthetic */ void zzj(zzfx zzfxVar, String str) {
        str.getClass();
        zzfxVar.zzd |= 1;
        zzfxVar.zze = str;
    }

    public static /* synthetic */ void zzk(zzfx zzfxVar, String str) {
        str.getClass();
        zzfxVar.zzd |= 2;
        zzfxVar.zzf = str;
    }

    public static /* synthetic */ void zzm(zzfx zzfxVar) {
        zzfxVar.zzd &= -3;
        zzfxVar.zzf = zza.zzf;
    }

    public static /* synthetic */ void zzn(zzfx zzfxVar, long j4) {
        zzfxVar.zzd |= 4;
        zzfxVar.zzg = j4;
    }

    public static /* synthetic */ void zzo(zzfx zzfxVar) {
        zzfxVar.zzd &= -5;
        zzfxVar.zzg = 0L;
    }

    public static /* synthetic */ void zzp(zzfx zzfxVar, double d4) {
        zzfxVar.zzd |= 16;
        zzfxVar.zzi = d4;
    }

    public static /* synthetic */ void zzq(zzfx zzfxVar) {
        zzfxVar.zzd &= -17;
        zzfxVar.zzi = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
    }

    public static /* synthetic */ void zzr(zzfx zzfxVar, zzfx zzfxVar2) {
        zzfxVar2.getClass();
        zzfxVar.zzz();
        zzfxVar.zzj.add(zzfxVar2);
    }

    public static /* synthetic */ void zzs(zzfx zzfxVar, Iterable iterable) {
        zzfxVar.zzz();
        zzjk.zzbw(iterable, zzfxVar.zzj);
    }

    private final void zzz() {
        zzli zzliVar = this.zzj;
        if (!zzliVar.zzc()) {
            this.zzj = zzlb.zzbI(zzliVar);
        }
    }

    public final double zza() {
        return this.zzi;
    }

    public final float zzb() {
        return this.zzh;
    }

    public final int zzc() {
        return this.zzj.size();
    }

    public final long zzd() {
        return this.zzg;
    }

    public final String zzg() {
        return this.zze;
    }

    public final String zzh() {
        return this.zzf;
    }

    public final List zzi() {
        return this.zzj;
    }

    @Override // com.google.android.gms.internal.measurement.zzlb
    public final Object zzl(int i4, Object obj, Object obj2) {
        int i5 = i4 - 1;
        if (i5 != 0) {
            if (i5 != 2) {
                if (i5 != 3) {
                    if (i5 != 4) {
                        if (i5 != 5) {
                            return null;
                        }
                        return zza;
                    }
                    return new zzfw(null);
                }
                return new zzfx();
            }
            return zzlb.zzbL(zza, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဂ\u0002\u0004ခ\u0003\u0005က\u0004\u0006\u001b", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", zzfx.class});
        }
        return (byte) 1;
    }

    public final boolean zzu() {
        if ((this.zzd & 16) != 0) {
            return true;
        }
        return false;
    }

    public final boolean zzv() {
        if ((this.zzd & 8) != 0) {
            return true;
        }
        return false;
    }

    public final boolean zzw() {
        if ((this.zzd & 4) != 0) {
            return true;
        }
        return false;
    }

    public final boolean zzx() {
        if ((this.zzd & 1) != 0) {
            return true;
        }
        return false;
    }

    public final boolean zzy() {
        if ((this.zzd & 2) != 0) {
            return true;
        }
        return false;
    }
}
