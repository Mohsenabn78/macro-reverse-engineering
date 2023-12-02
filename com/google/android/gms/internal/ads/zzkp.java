package com.google.android.gms.internal.ads;

import android.util.Pair;
import androidx.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzkp {
    private final zzct zza = new zzct();
    private final zzcv zzb = new zzcv();
    private final zzls zzc;
    private final zzei zzd;
    private long zze;
    private int zzf;
    private boolean zzg;
    @Nullable
    private zzkm zzh;
    @Nullable
    private zzkm zzi;
    @Nullable
    private zzkm zzj;
    private int zzk;
    @Nullable
    private Object zzl;
    private long zzm;

    public zzkp(zzls zzlsVar, zzei zzeiVar) {
        this.zzc = zzlsVar;
        this.zzd = zzeiVar;
    }

    private final boolean zzA(zzcw zzcwVar, zzto zztoVar) {
        if (!zzC(zztoVar)) {
            return false;
        }
        int i4 = zzcwVar.zzn(zztoVar.zza, this.zza).zzd;
        if (zzcwVar.zze(i4, this.zzb, 0L).zzp != zzcwVar.zza(zztoVar.zza)) {
            return false;
        }
        return true;
    }

    private final boolean zzB(zzcw zzcwVar) {
        zzkm zzkmVar = this.zzh;
        if (zzkmVar == null) {
            return true;
        }
        int zza = zzcwVar.zza(zzkmVar.zzb);
        while (true) {
            zza = zzcwVar.zzi(zza, this.zza, this.zzb, this.zzf, this.zzg);
            while (zzkmVar.zzg() != null && !zzkmVar.zzf.zzg) {
                zzkmVar = zzkmVar.zzg();
            }
            zzkm zzg = zzkmVar.zzg();
            if (zza == -1 || zzg == null || zzcwVar.zza(zzg.zzb) != zza) {
                break;
            }
            zzkmVar = zzg;
        }
        boolean zzm = zzm(zzkmVar);
        zzkmVar.zzf = zzg(zzcwVar, zzkmVar.zzf);
        if (!zzm) {
            return true;
        }
        return false;
    }

    private static final boolean zzC(zzto zztoVar) {
        if (!zztoVar.zzb() && zztoVar.zze == -1) {
            return true;
        }
        return false;
    }

    private final long zzs(zzcw zzcwVar, Object obj, int i4) {
        zzcwVar.zzn(obj, this.zza);
        this.zza.zzi(i4);
        this.zza.zzk(i4);
        return 0L;
    }

    @Nullable
    private final zzkn zzt(zzcw zzcwVar, zzkm zzkmVar, long j4) {
        long j5;
        zzkn zzknVar = zzkmVar.zzf;
        long zze = (zzkmVar.zze() + zzknVar.zze) - j4;
        if (zzknVar.zzg) {
            long j6 = 0;
            int zzi = zzcwVar.zzi(zzcwVar.zza(zzknVar.zza.zza), this.zza, this.zzb, this.zzf, this.zzg);
            if (zzi != -1) {
                int i4 = zzcwVar.zzd(zzi, this.zza, true).zzd;
                Object obj = this.zza.zzc;
                obj.getClass();
                long j7 = zzknVar.zza.zzd;
                if (zzcwVar.zze(i4, this.zzb, 0L).zzo == zzi) {
                    Pair zzm = zzcwVar.zzm(this.zzb, this.zza, i4, -9223372036854775807L, Math.max(0L, zze));
                    if (zzm != null) {
                        obj = zzm.first;
                        long longValue = ((Long) zzm.second).longValue();
                        zzkm zzg = zzkmVar.zzg();
                        if (zzg != null && zzg.zzb.equals(obj)) {
                            j7 = zzg.zzf.zza.zzd;
                        } else {
                            j7 = this.zze;
                            this.zze = 1 + j7;
                        }
                        j5 = longValue;
                        j6 = -9223372036854775807L;
                    }
                } else {
                    j5 = 0;
                }
                zzto zzx = zzx(zzcwVar, obj, j5, j7, this.zzb, this.zza);
                if (j6 != -9223372036854775807L && zzknVar.zzc != -9223372036854775807L) {
                    zzcwVar.zzn(zzknVar.zza.zza, this.zza).zzb();
                    this.zza.zzg();
                }
                return zzu(zzcwVar, zzx, j6, j5);
            }
        } else {
            zzto zztoVar = zzknVar.zza;
            zzcwVar.zzn(zztoVar.zza, this.zza);
            if (zztoVar.zzb()) {
                int i5 = zztoVar.zzb;
                if (this.zza.zza(i5) != -1) {
                    int zzf = this.zza.zzf(i5, zztoVar.zzc);
                    if (zzf < 0) {
                        return zzv(zzcwVar, zztoVar.zza, i5, zzf, zzknVar.zzc, zztoVar.zzd);
                    }
                    long j8 = zzknVar.zzc;
                    if (j8 == -9223372036854775807L) {
                        zzcv zzcvVar = this.zzb;
                        zzct zzctVar = this.zza;
                        Pair zzm2 = zzcwVar.zzm(zzcvVar, zzctVar, zzctVar.zzd, -9223372036854775807L, Math.max(0L, zze));
                        if (zzm2 != null) {
                            j8 = ((Long) zzm2.second).longValue();
                        }
                    }
                    zzs(zzcwVar, zztoVar.zza, zztoVar.zzb);
                    return zzw(zzcwVar, zztoVar.zza, Math.max(0L, j8), zzknVar.zzc, zztoVar.zzd);
                }
            } else {
                int i6 = zztoVar.zze;
                if (i6 != -1) {
                    this.zza.zzm(i6);
                }
                int zze2 = this.zza.zze(zztoVar.zze);
                this.zza.zzn(zztoVar.zze);
                if (zze2 != this.zza.zza(zztoVar.zze)) {
                    return zzv(zzcwVar, zztoVar.zza, zztoVar.zze, zze2, zzknVar.zze, zztoVar.zzd);
                }
                zzs(zzcwVar, zztoVar.zza, zztoVar.zze);
                return zzw(zzcwVar, zztoVar.zza, 0L, zzknVar.zze, zztoVar.zzd);
            }
        }
        return null;
    }

    @Nullable
    private final zzkn zzu(zzcw zzcwVar, zzto zztoVar, long j4, long j5) {
        zzcwVar.zzn(zztoVar.zza, this.zza);
        if (zztoVar.zzb()) {
            return zzv(zzcwVar, zztoVar.zza, zztoVar.zzb, zztoVar.zzc, j4, zztoVar.zzd);
        }
        return zzw(zzcwVar, zztoVar.zza, j5, j4, zztoVar.zzd);
    }

    private final zzkn zzv(zzcw zzcwVar, Object obj, int i4, int i5, long j4, long j5) {
        zzto zztoVar = new zzto(obj, i4, i5, j5);
        long zzh = zzcwVar.zzn(zztoVar.zza, this.zza).zzh(zztoVar.zzb, zztoVar.zzc);
        if (i5 == this.zza.zze(i4)) {
            this.zza.zzj();
        }
        this.zza.zzn(zztoVar.zzb);
        long j6 = 0;
        if (zzh != -9223372036854775807L && zzh <= 0) {
            j6 = Math.max(0L, (-1) + zzh);
        }
        return new zzkn(zztoVar, j6, j4, -9223372036854775807L, zzh, false, false, false, false);
    }

    private final zzkn zzw(zzcw zzcwVar, Object obj, long j4, long j5, long j6) {
        long j7;
        long j8;
        long j9;
        long j10 = j4;
        zzcwVar.zzn(obj, this.zza);
        int zzc = this.zza.zzc(j10);
        if (zzc != -1) {
            this.zza.zzm(zzc);
        }
        if (zzc == -1) {
            this.zza.zzb();
        } else {
            this.zza.zzn(zzc);
        }
        zzto zztoVar = new zzto(obj, j6, zzc);
        boolean zzC = zzC(zztoVar);
        boolean zzA = zzA(zzcwVar, zztoVar);
        boolean zzz = zzz(zzcwVar, zztoVar, zzC);
        if (zzc != -1) {
            this.zza.zzn(zzc);
        }
        if (zzc != -1) {
            this.zza.zzi(zzc);
            j7 = 0;
        } else {
            j7 = -9223372036854775807L;
        }
        if (j7 != -9223372036854775807L) {
            j8 = 0;
            j9 = 0;
        } else {
            j8 = j7;
            j9 = this.zza.zze;
        }
        if (j9 != -9223372036854775807L && j10 >= j9) {
            j10 = Math.max(0L, j9 - 1);
        }
        return new zzkn(zztoVar, j10, j5, j8, j9, false, zzC, zzA, zzz);
    }

    private static zzto zzx(zzcw zzcwVar, Object obj, long j4, long j5, zzcv zzcvVar, zzct zzctVar) {
        zzcwVar.zzn(obj, zzctVar);
        zzcwVar.zze(zzctVar.zzd, zzcvVar, 0L);
        zzcwVar.zza(obj);
        zzctVar.zzb();
        zzcwVar.zzn(obj, zzctVar);
        int zzd = zzctVar.zzd(j4);
        if (zzd == -1) {
            return new zzto(obj, j5, zzctVar.zzc(j4));
        }
        return new zzto(obj, zzd, zzctVar.zze(zzd), j5);
    }

    private final void zzy() {
        final zzto zztoVar;
        final zzfrz zzfrzVar = new zzfrz();
        for (zzkm zzkmVar = this.zzh; zzkmVar != null; zzkmVar = zzkmVar.zzg()) {
            zzfrzVar.zzf(zzkmVar.zzf.zza);
        }
        zzkm zzkmVar2 = this.zzi;
        if (zzkmVar2 == null) {
            zztoVar = null;
        } else {
            zztoVar = zzkmVar2.zzf.zza;
        }
        this.zzd.zzh(new Runnable() { // from class: com.google.android.gms.internal.ads.zzko
            @Override // java.lang.Runnable
            public final void run() {
                zzkp.this.zzj(zzfrzVar, zztoVar);
            }
        });
    }

    private final boolean zzz(zzcw zzcwVar, zzto zztoVar, boolean z3) {
        int zza = zzcwVar.zza(zztoVar.zza);
        if (zzcwVar.zze(zzcwVar.zzd(zza, this.zza, false).zzd, this.zzb, 0L).zzi || zzcwVar.zzi(zza, this.zza, this.zzb, this.zzf, this.zzg) != -1 || !z3) {
            return false;
        }
        return true;
    }

    @Nullable
    public final zzkm zza() {
        zzkm zzkmVar = this.zzh;
        if (zzkmVar == null) {
            return null;
        }
        if (zzkmVar == this.zzi) {
            this.zzi = zzkmVar.zzg();
        }
        zzkmVar.zzn();
        int i4 = this.zzk - 1;
        this.zzk = i4;
        if (i4 == 0) {
            this.zzj = null;
            zzkm zzkmVar2 = this.zzh;
            this.zzl = zzkmVar2.zzb;
            this.zzm = zzkmVar2.zzf.zza.zzd;
        }
        this.zzh = this.zzh.zzg();
        zzy();
        return this.zzh;
    }

    public final zzkm zzb() {
        zzkm zzkmVar = this.zzi;
        boolean z3 = false;
        if (zzkmVar != null && zzkmVar.zzg() != null) {
            z3 = true;
        }
        zzdy.zzf(z3);
        this.zzi = this.zzi.zzg();
        zzy();
        return this.zzi;
    }

    @Nullable
    public final zzkm zzc() {
        return this.zzj;
    }

    @Nullable
    public final zzkm zzd() {
        return this.zzh;
    }

    @Nullable
    public final zzkm zze() {
        return this.zzi;
    }

    @Nullable
    public final zzkn zzf(long j4, zzlc zzlcVar) {
        zzkm zzkmVar = this.zzj;
        if (zzkmVar == null) {
            return zzu(zzlcVar.zza, zzlcVar.zzb, zzlcVar.zzc, zzlcVar.zzr);
        }
        return zzt(zzlcVar.zza, zzkmVar, j4);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.internal.ads.zzkn zzg(com.google.android.gms.internal.ads.zzcw r19, com.google.android.gms.internal.ads.zzkn r20) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            com.google.android.gms.internal.ads.zzto r3 = r2.zza
            boolean r12 = zzC(r3)
            boolean r13 = r0.zzA(r1, r3)
            boolean r14 = r0.zzz(r1, r3, r12)
            com.google.android.gms.internal.ads.zzto r4 = r2.zza
            java.lang.Object r4 = r4.zza
            com.google.android.gms.internal.ads.zzct r5 = r0.zza
            r1.zzn(r4, r5)
            boolean r1 = r3.zzb()
            r4 = -1
            r5 = 0
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r1 != 0) goto L37
            int r1 = r3.zze
            if (r1 != r4) goto L30
            goto L37
        L30:
            com.google.android.gms.internal.ads.zzct r9 = r0.zza
            r9.zzi(r1)
            r9 = r5
            goto L38
        L37:
            r9 = r7
        L38:
            boolean r1 = r3.zzb()
            if (r1 == 0) goto L4b
            com.google.android.gms.internal.ads.zzct r1 = r0.zza
            int r5 = r3.zzb
            int r6 = r3.zzc
            long r5 = r1.zzh(r5, r6)
        L48:
            r7 = r9
            r9 = r5
            goto L57
        L4b:
            int r1 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r1 == 0) goto L52
            r7 = r5
            r9 = r7
            goto L57
        L52:
            com.google.android.gms.internal.ads.zzct r1 = r0.zza
            long r5 = r1.zze
            goto L48
        L57:
            boolean r1 = r3.zzb()
            if (r1 == 0) goto L65
            com.google.android.gms.internal.ads.zzct r1 = r0.zza
            int r4 = r3.zzb
            r1.zzn(r4)
            goto L6e
        L65:
            int r1 = r3.zze
            if (r1 == r4) goto L6e
            com.google.android.gms.internal.ads.zzct r4 = r0.zza
            r4.zzn(r1)
        L6e:
            com.google.android.gms.internal.ads.zzkn r15 = new com.google.android.gms.internal.ads.zzkn
            long r4 = r2.zzb
            long r1 = r2.zzc
            r11 = 0
            r16 = r1
            r1 = r15
            r2 = r3
            r3 = r4
            r5 = r16
            r1.<init>(r2, r3, r5, r7, r9, r11, r12, r13, r14)
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzkp.zzg(com.google.android.gms.internal.ads.zzcw, com.google.android.gms.internal.ads.zzkn):com.google.android.gms.internal.ads.zzkn");
    }

    public final zzto zzh(zzcw zzcwVar, Object obj, long j4) {
        long j5;
        int zza;
        int i4 = zzcwVar.zzn(obj, this.zza).zzd;
        Object obj2 = this.zzl;
        if (obj2 != null && (zza = zzcwVar.zza(obj2)) != -1 && zzcwVar.zzd(zza, this.zza, false).zzd == i4) {
            j5 = this.zzm;
        } else {
            zzkm zzkmVar = this.zzh;
            while (true) {
                if (zzkmVar != null) {
                    if (zzkmVar.zzb.equals(obj)) {
                        j5 = zzkmVar.zzf.zza.zzd;
                        break;
                    }
                    zzkmVar = zzkmVar.zzg();
                } else {
                    zzkm zzkmVar2 = this.zzh;
                    while (true) {
                        if (zzkmVar2 != null) {
                            int zza2 = zzcwVar.zza(zzkmVar2.zzb);
                            if (zza2 != -1 && zzcwVar.zzd(zza2, this.zza, false).zzd == i4) {
                                j5 = zzkmVar2.zzf.zza.zzd;
                                break;
                            }
                            zzkmVar2 = zzkmVar2.zzg();
                        } else {
                            j5 = this.zze;
                            this.zze = 1 + j5;
                            if (this.zzh == null) {
                                this.zzl = obj;
                                this.zzm = j5;
                            }
                        }
                    }
                }
            }
        }
        long j6 = j5;
        zzcwVar.zzn(obj, this.zza);
        zzcwVar.zze(this.zza.zzd, this.zzb, 0L);
        int zza3 = zzcwVar.zza(obj);
        Object obj3 = obj;
        while (true) {
            zzcv zzcvVar = this.zzb;
            if (zza3 >= zzcvVar.zzo) {
                zzcwVar.zzd(zza3, this.zza, true);
                this.zza.zzb();
                zzct zzctVar = this.zza;
                if (zzctVar.zzd(zzctVar.zze) != -1) {
                    obj3 = this.zza.zzc;
                    obj3.getClass();
                }
                zza3--;
            } else {
                return zzx(zzcwVar, obj3, j4, j6, zzcvVar, this.zza);
            }
        }
    }

    public final void zzi() {
        if (this.zzk == 0) {
            return;
        }
        zzkm zzkmVar = this.zzh;
        zzdy.zzb(zzkmVar);
        this.zzl = zzkmVar.zzb;
        this.zzm = zzkmVar.zzf.zza.zzd;
        while (zzkmVar != null) {
            zzkmVar.zzn();
            zzkmVar = zzkmVar.zzg();
        }
        this.zzh = null;
        this.zzj = null;
        this.zzi = null;
        this.zzk = 0;
        zzy();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzj(zzfrz zzfrzVar, zzto zztoVar) {
        this.zzc.zzQ(zzfrzVar.zzi(), zztoVar);
    }

    public final void zzk(long j4) {
        zzkm zzkmVar = this.zzj;
        if (zzkmVar != null) {
            zzkmVar.zzm(j4);
        }
    }

    public final boolean zzl(zztm zztmVar) {
        zzkm zzkmVar = this.zzj;
        if (zzkmVar != null && zzkmVar.zza == zztmVar) {
            return true;
        }
        return false;
    }

    public final boolean zzm(zzkm zzkmVar) {
        boolean z3;
        boolean z4 = false;
        if (zzkmVar != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        zzdy.zzf(z3);
        if (zzkmVar.equals(this.zzj)) {
            return false;
        }
        this.zzj = zzkmVar;
        while (zzkmVar.zzg() != null) {
            zzkmVar = zzkmVar.zzg();
            if (zzkmVar == this.zzi) {
                this.zzi = this.zzh;
                z4 = true;
            }
            zzkmVar.zzn();
            this.zzk--;
        }
        this.zzj.zzo(null);
        zzy();
        return z4;
    }

    public final boolean zzn() {
        zzkm zzkmVar = this.zzj;
        if (zzkmVar == null) {
            return true;
        }
        if (!zzkmVar.zzf.zzi && zzkmVar.zzr() && this.zzj.zzf.zze != -9223372036854775807L && this.zzk < 100) {
            return true;
        }
        return false;
    }

    public final boolean zzo(zzcw zzcwVar, long j4, long j5) {
        zzkn zzknVar;
        long zze;
        boolean z3;
        zzkm zzkmVar = null;
        for (zzkm zzkmVar2 = this.zzh; zzkmVar2 != null; zzkmVar2 = zzkmVar2.zzg()) {
            zzkn zzknVar2 = zzkmVar2.zzf;
            if (zzkmVar == null) {
                zzknVar = zzg(zzcwVar, zzknVar2);
            } else {
                zzkn zzt = zzt(zzcwVar, zzkmVar, j4);
                if (zzt == null) {
                    if (!zzm(zzkmVar)) {
                        return true;
                    }
                    return false;
                } else if (zzknVar2.zzb == zzt.zzb && zzknVar2.zza.equals(zzt.zza)) {
                    zzknVar = zzt;
                } else if (!zzm(zzkmVar)) {
                    return true;
                } else {
                    return false;
                }
            }
            zzkmVar2.zzf = zzknVar.zza(zzknVar2.zzc);
            long j6 = zzknVar2.zze;
            int i4 = (j6 > (-9223372036854775807L) ? 1 : (j6 == (-9223372036854775807L) ? 0 : -1));
            long j7 = zzknVar.zze;
            if (i4 != 0 && j6 != j7) {
                zzkmVar2.zzq();
                long j8 = zzknVar.zze;
                if (j8 == -9223372036854775807L) {
                    zze = Long.MAX_VALUE;
                } else {
                    zze = j8 + zzkmVar2.zze();
                }
                if (zzkmVar2 == this.zzi) {
                    boolean z4 = zzkmVar2.zzf.zzf;
                    if (j5 == Long.MIN_VALUE || j5 >= zze) {
                        z3 = true;
                        if (zzm(zzkmVar2) && !z3) {
                            return true;
                        }
                        return false;
                    }
                }
                z3 = false;
                if (zzm(zzkmVar2)) {
                }
                return false;
            }
            zzkmVar = zzkmVar2;
        }
        return true;
    }

    public final boolean zzp(zzcw zzcwVar, int i4) {
        this.zzf = i4;
        return zzB(zzcwVar);
    }

    public final boolean zzq(zzcw zzcwVar, boolean z3) {
        this.zzg = z3;
        return zzB(zzcwVar);
    }

    public final zzkm zzr(zzlk[] zzlkVarArr, zzxg zzxgVar, zzxp zzxpVar, zzlb zzlbVar, zzkn zzknVar, zzxh zzxhVar) {
        long zze;
        zzkm zzkmVar = this.zzj;
        if (zzkmVar == null) {
            zze = 1000000000000L;
        } else {
            zze = (zzkmVar.zze() + zzkmVar.zzf.zze) - zzknVar.zzb;
        }
        zzkm zzkmVar2 = new zzkm(zzlkVarArr, zze, zzxgVar, zzxpVar, zzlbVar, zzknVar, zzxhVar);
        zzkm zzkmVar3 = this.zzj;
        if (zzkmVar3 != null) {
            zzkmVar3.zzo(zzkmVar2);
        } else {
            this.zzh = zzkmVar2;
            this.zzi = zzkmVar2;
        }
        this.zzl = null;
        this.zzj = zzkmVar2;
        this.zzk++;
        zzy();
        return zzkmVar2;
    }
}
