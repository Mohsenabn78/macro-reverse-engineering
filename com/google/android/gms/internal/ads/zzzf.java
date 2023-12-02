package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.Display;
import android.view.Surface;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzzf {
    private final zzyj zza = new zzyj();
    @Nullable
    private final zzzb zzb;
    @Nullable
    private final zzze zzc;
    private boolean zzd;
    @Nullable
    private Surface zze;
    private float zzf;
    private float zzg;
    private float zzh;
    private float zzi;
    private int zzj;
    private long zzk;
    private long zzl;
    private long zzm;
    private long zzn;
    private long zzo;
    private long zzp;
    private long zzq;

    public zzzf(@Nullable Context context) {
        zzzb zzzbVar;
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            int i4 = zzfj.zza;
            zzzbVar = zzzd.zzc(applicationContext);
            if (zzzbVar == null) {
                zzzbVar = zzzc.zzc(applicationContext);
            }
        } else {
            zzzbVar = null;
        }
        this.zzb = zzzbVar;
        this.zzc = zzzbVar != null ? zzze.zza() : null;
        this.zzk = -9223372036854775807L;
        this.zzl = -9223372036854775807L;
        this.zzf = -1.0f;
        this.zzi = 1.0f;
        this.zzj = 0;
    }

    public static /* synthetic */ void zzb(zzzf zzzfVar, Display display) {
        if (display != null) {
            long refreshRate = (long) (1.0E9d / display.getRefreshRate());
            zzzfVar.zzk = refreshRate;
            zzzfVar.zzl = (refreshRate * 80) / 100;
            return;
        }
        zzer.zzf("VideoFrameReleaseHelper", "Unable to query display refresh rate");
        zzzfVar.zzk = -9223372036854775807L;
        zzzfVar.zzl = -9223372036854775807L;
    }

    private final void zzk() {
        Surface surface;
        if (zzfj.zza >= 30 && (surface = this.zze) != null && this.zzj != Integer.MIN_VALUE && this.zzh != 0.0f) {
            this.zzh = 0.0f;
            zzza.zza(surface, 0.0f);
        }
    }

    private final void zzl() {
        this.zzm = 0L;
        this.zzp = -1L;
        this.zzn = -1L;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0055, code lost:
        if (java.lang.Math.abs(r0 - r10.zzg) >= r2) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0060, code lost:
        if (r10.zza.zzb() >= 30) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0063, code lost:
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0064, code lost:
        if (r3 == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0067, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void zzm() {
        /*
            r10 = this;
            int r0 = com.google.android.gms.internal.ads.zzfj.zza
            r1 = 30
            if (r0 < r1) goto L6d
            android.view.Surface r0 = r10.zze
            if (r0 != 0) goto Lb
            goto L6d
        Lb:
            com.google.android.gms.internal.ads.zzyj r0 = r10.zza
            boolean r0 = r0.zzg()
            if (r0 == 0) goto L1a
            com.google.android.gms.internal.ads.zzyj r0 = r10.zza
            float r0 = r0.zza()
            goto L1c
        L1a:
            float r0 = r10.zzf
        L1c:
            float r2 = r10.zzg
            int r3 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r3 != 0) goto L23
            return
        L23:
            r3 = 1
            r4 = -1082130432(0xffffffffbf800000, float:-1.0)
            r5 = 0
            int r6 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r6 == 0) goto L58
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L58
            com.google.android.gms.internal.ads.zzyj r1 = r10.zza
            boolean r1 = r1.zzg()
            r2 = 1065353216(0x3f800000, float:1.0)
            if (r1 == 0) goto L4b
            com.google.android.gms.internal.ads.zzyj r1 = r10.zza
            long r6 = r1.zzd()
            r8 = 5000000000(0x12a05f200, double:2.470328229E-314)
            int r1 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r1 < 0) goto L4b
            r2 = 1017370378(0x3ca3d70a, float:0.02)
        L4b:
            float r1 = r10.zzg
            float r1 = r0 - r1
            float r1 = java.lang.Math.abs(r1)
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 < 0) goto L63
            goto L64
        L58:
            if (r6 != 0) goto L68
            com.google.android.gms.internal.ads.zzyj r2 = r10.zza
            int r2 = r2.zzb()
            if (r2 < r1) goto L63
            goto L64
        L63:
            r3 = 0
        L64:
            if (r3 == 0) goto L67
            goto L68
        L67:
            return
        L68:
            r10.zzg = r0
            r10.zzn(r5)
        L6d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzzf.zzm():void");
    }

    private final void zzn(boolean z3) {
        Surface surface;
        if (zzfj.zza >= 30 && (surface = this.zze) != null && this.zzj != Integer.MIN_VALUE) {
            float f4 = 0.0f;
            if (this.zzd) {
                float f5 = this.zzg;
                if (f5 != -1.0f) {
                    f4 = this.zzi * f5;
                }
            }
            if (!z3 && this.zzh == f4) {
                return;
            }
            this.zzh = f4;
            zzza.zza(surface, f4);
        }
    }

    public final long zza(long j4) {
        long j5;
        if (this.zzp != -1 && this.zza.zzg()) {
            long zzc = this.zza.zzc();
            long j6 = this.zzq + (((float) (zzc * (this.zzm - this.zzp))) / this.zzi);
            if (Math.abs(j4 - j6) > 20000000) {
                zzl();
            } else {
                j4 = j6;
            }
        }
        this.zzn = this.zzm;
        this.zzo = j4;
        zzze zzzeVar = this.zzc;
        if (zzzeVar != null && this.zzk != -9223372036854775807L) {
            long j7 = zzzeVar.zza;
            if (j7 == -9223372036854775807L) {
                return j4;
            }
            long j8 = this.zzk;
            long j9 = j7 + (((j4 - j7) / j8) * j8);
            if (j4 <= j9) {
                j5 = j9 - j8;
            } else {
                j9 = j8 + j9;
                j5 = j9;
            }
            long j10 = this.zzl;
            if (j9 - j4 >= j4 - j5) {
                j9 = j5;
            }
            return j9 - j10;
        }
        return j4;
    }

    public final void zzc(float f4) {
        this.zzf = f4;
        this.zza.zzf();
        zzm();
    }

    public final void zzd(long j4) {
        long j5 = this.zzn;
        if (j5 != -1) {
            this.zzp = j5;
            this.zzq = this.zzo;
        }
        this.zzm++;
        this.zza.zze(j4 * 1000);
        zzm();
    }

    public final void zze(float f4) {
        this.zzi = f4;
        zzl();
        zzn(false);
    }

    public final void zzf() {
        zzl();
    }

    public final void zzg() {
        this.zzd = true;
        zzl();
        if (this.zzb != null) {
            zzze zzzeVar = this.zzc;
            zzzeVar.getClass();
            zzzeVar.zzb();
            this.zzb.zzb(new zzyz(this));
        }
        zzn(false);
    }

    public final void zzh() {
        this.zzd = false;
        zzzb zzzbVar = this.zzb;
        if (zzzbVar != null) {
            zzzbVar.zza();
            zzze zzzeVar = this.zzc;
            zzzeVar.getClass();
            zzzeVar.zzc();
        }
        zzk();
    }

    public final void zzi(@Nullable Surface surface) {
        if (true == (surface instanceof zzyx)) {
            surface = null;
        }
        if (this.zze == surface) {
            return;
        }
        zzk();
        this.zze = surface;
        zzn(true);
    }

    public final void zzj(int i4) {
        if (this.zzj == i4) {
            return;
        }
        this.zzj = i4;
        zzn(true);
    }
}
