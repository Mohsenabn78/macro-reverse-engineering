package com.google.android.gms.internal.ads;

import android.util.Base64;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zznw implements zzoa {
    public static final zzfpx zza = new zzfpx() { // from class: com.google.android.gms.internal.ads.zznu
        @Override // com.google.android.gms.internal.ads.zzfpx
        public final Object zza() {
            String zzl;
            zzl = zznw.zzl();
            return zzl;
        }
    };
    private static final Random zzb = new Random();
    private final zzcv zzc;
    private final zzct zzd;
    private final HashMap zze;
    private final zzfpx zzf;
    private zznz zzg;
    private zzcw zzh;
    @Nullable
    private String zzi;

    public zznw() {
        throw null;
    }

    private final zznv zzk(int i4, @Nullable zzto zztoVar) {
        long j4;
        int i5;
        zzto zztoVar2;
        zzto zztoVar3;
        long j5 = Long.MAX_VALUE;
        zznv zznvVar = null;
        for (zznv zznvVar2 : this.zze.values()) {
            zznvVar2.zzg(i4, zztoVar);
            if (zznvVar2.zzj(i4, zztoVar)) {
                j4 = zznvVar2.zzd;
                if (j4 != -1 && j4 >= j5) {
                    if (i5 == 0) {
                        int i6 = zzfj.zza;
                        zztoVar2 = zznvVar.zze;
                        if (zztoVar2 != null) {
                            zztoVar3 = zznvVar2.zze;
                            if (zztoVar3 != null) {
                                zznvVar = zznvVar2;
                            }
                        }
                    }
                } else {
                    zznvVar = zznvVar2;
                    j5 = j4;
                }
            }
        }
        if (zznvVar == null) {
            String zzl = zzl();
            zznv zznvVar3 = new zznv(this, zzl, i4, zztoVar);
            this.zze.put(zzl, zznvVar3);
            return zznvVar3;
        }
        return zznvVar;
    }

    public static String zzl() {
        byte[] bArr = new byte[12];
        zzb.nextBytes(bArr);
        return Base64.encodeToString(bArr, 10);
    }

    @RequiresNonNull({ServiceSpecificExtraArgs.CastExtraArgs.LISTENER})
    private final void zzm(zzlt zzltVar) {
        String str;
        long j4;
        zzto zztoVar;
        zzto zztoVar2;
        zzto zztoVar3;
        String unused;
        String unused2;
        if (zzltVar.zzb.zzo()) {
            this.zzi = null;
            return;
        }
        zznv zznvVar = (zznv) this.zze.get(this.zzi);
        zznv zzk = zzk(zzltVar.zzc, zzltVar.zzd);
        str = zzk.zzb;
        this.zzi = str;
        zzh(zzltVar);
        zzto zztoVar4 = zzltVar.zzd;
        if (zztoVar4 != null && zztoVar4.zzb()) {
            if (zznvVar != null) {
                j4 = zznvVar.zzd;
                if (j4 == zzltVar.zzd.zzd) {
                    zztoVar = zznvVar.zze;
                    if (zztoVar != null) {
                        zztoVar2 = zznvVar.zze;
                        if (zztoVar2.zzb == zzltVar.zzd.zzb) {
                            zztoVar3 = zznvVar.zze;
                            if (zztoVar3.zzc == zzltVar.zzd.zzc) {
                                return;
                            }
                        }
                    }
                }
            }
            zzto zztoVar5 = zzltVar.zzd;
            unused = zzk(zzltVar.zzc, new zzto(zztoVar5.zza, zztoVar5.zzd)).zzb;
            unused2 = zzk.zzb;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzoa
    @Nullable
    public final synchronized String zzd() {
        return this.zzi;
    }

    @Override // com.google.android.gms.internal.ads.zzoa
    public final synchronized String zze(zzcw zzcwVar, zzto zztoVar) {
        String str;
        str = zzk(zzcwVar.zzn(zztoVar.zza, this.zzd).zzd, zztoVar).zzb;
        return str;
    }

    @Override // com.google.android.gms.internal.ads.zzoa
    public final synchronized void zzf(zzlt zzltVar) {
        boolean z3;
        zznz zznzVar;
        String str;
        this.zzi = null;
        Iterator it = this.zze.values().iterator();
        while (it.hasNext()) {
            zznv zznvVar = (zznv) it.next();
            it.remove();
            z3 = zznvVar.zzf;
            if (z3 && (zznzVar = this.zzg) != null) {
                str = zznvVar.zzb;
                zznzVar.zzd(zzltVar, str, false);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzoa
    public final void zzg(zznz zznzVar) {
        this.zzg = zznzVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x003d, code lost:
        if (r1 < r3) goto L18;
     */
    @Override // com.google.android.gms.internal.ads.zzoa
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized void zzh(com.google.android.gms.internal.ads.zzlt r10) {
        /*
            r9 = this;
            monitor-enter(r9)
            com.google.android.gms.internal.ads.zznz r0 = r9.zzg     // Catch: java.lang.Throwable -> Lcb
            r0.getClass()
            com.google.android.gms.internal.ads.zzcw r0 = r10.zzb     // Catch: java.lang.Throwable -> Lcb
            boolean r0 = r0.zzo()     // Catch: java.lang.Throwable -> Lcb
            if (r0 == 0) goto L10
            monitor-exit(r9)
            return
        L10:
            java.util.HashMap r0 = r9.zze     // Catch: java.lang.Throwable -> Lcb
            java.lang.String r1 = r9.zzi     // Catch: java.lang.Throwable -> Lcb
            java.lang.Object r0 = r0.get(r1)     // Catch: java.lang.Throwable -> Lcb
            com.google.android.gms.internal.ads.zznv r0 = (com.google.android.gms.internal.ads.zznv) r0     // Catch: java.lang.Throwable -> Lcb
            com.google.android.gms.internal.ads.zzto r1 = r10.zzd     // Catch: java.lang.Throwable -> Lcb
            if (r1 == 0) goto L41
            if (r0 == 0) goto L41
            long r1 = com.google.android.gms.internal.ads.zznv.zzb(r0)     // Catch: java.lang.Throwable -> Lcb
            r3 = -1
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 != 0) goto L33
            int r0 = com.google.android.gms.internal.ads.zznv.zza(r0)     // Catch: java.lang.Throwable -> Lcb
            int r1 = r10.zzc     // Catch: java.lang.Throwable -> Lcb
            if (r0 != r1) goto L3f
            goto L41
        L33:
            com.google.android.gms.internal.ads.zzto r1 = r10.zzd     // Catch: java.lang.Throwable -> Lcb
            long r1 = r1.zzd     // Catch: java.lang.Throwable -> Lcb
            long r3 = com.google.android.gms.internal.ads.zznv.zzb(r0)     // Catch: java.lang.Throwable -> Lcb
            int r0 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r0 >= 0) goto L41
        L3f:
            monitor-exit(r9)
            return
        L41:
            int r0 = r10.zzc     // Catch: java.lang.Throwable -> Lcb
            com.google.android.gms.internal.ads.zzto r1 = r10.zzd     // Catch: java.lang.Throwable -> Lcb
            com.google.android.gms.internal.ads.zznv r0 = r9.zzk(r0, r1)     // Catch: java.lang.Throwable -> Lcb
            java.lang.String r1 = r9.zzi     // Catch: java.lang.Throwable -> Lcb
            if (r1 != 0) goto L53
            java.lang.String r1 = com.google.android.gms.internal.ads.zznv.zzd(r0)     // Catch: java.lang.Throwable -> Lcb
            r9.zzi = r1     // Catch: java.lang.Throwable -> Lcb
        L53:
            com.google.android.gms.internal.ads.zzto r1 = r10.zzd     // Catch: java.lang.Throwable -> Lcb
            r2 = 1
            if (r1 == 0) goto L9d
            boolean r3 = r1.zzb()     // Catch: java.lang.Throwable -> Lcb
            if (r3 == 0) goto L9d
            com.google.android.gms.internal.ads.zzto r3 = new com.google.android.gms.internal.ads.zzto     // Catch: java.lang.Throwable -> Lcb
            java.lang.Object r4 = r1.zza     // Catch: java.lang.Throwable -> Lcb
            long r5 = r1.zzd     // Catch: java.lang.Throwable -> Lcb
            int r1 = r1.zzb     // Catch: java.lang.Throwable -> Lcb
            r3.<init>(r4, r5, r1)     // Catch: java.lang.Throwable -> Lcb
            int r1 = r10.zzc     // Catch: java.lang.Throwable -> Lcb
            com.google.android.gms.internal.ads.zznv r1 = r9.zzk(r1, r3)     // Catch: java.lang.Throwable -> Lcb
            boolean r3 = com.google.android.gms.internal.ads.zznv.zzi(r1)     // Catch: java.lang.Throwable -> Lcb
            if (r3 != 0) goto L9d
            com.google.android.gms.internal.ads.zznv.zzf(r1, r2)     // Catch: java.lang.Throwable -> Lcb
            com.google.android.gms.internal.ads.zzcw r3 = r10.zzb     // Catch: java.lang.Throwable -> Lcb
            com.google.android.gms.internal.ads.zzto r4 = r10.zzd     // Catch: java.lang.Throwable -> Lcb
            java.lang.Object r4 = r4.zza     // Catch: java.lang.Throwable -> Lcb
            com.google.android.gms.internal.ads.zzct r5 = r9.zzd     // Catch: java.lang.Throwable -> Lcb
            r3.zzn(r4, r5)     // Catch: java.lang.Throwable -> Lcb
            com.google.android.gms.internal.ads.zzct r3 = r9.zzd     // Catch: java.lang.Throwable -> Lcb
            com.google.android.gms.internal.ads.zzto r4 = r10.zzd     // Catch: java.lang.Throwable -> Lcb
            int r4 = r4.zzb     // Catch: java.lang.Throwable -> Lcb
            r3.zzi(r4)     // Catch: java.lang.Throwable -> Lcb
            r3 = 0
            long r5 = com.google.android.gms.internal.ads.zzfj.zzq(r3)     // Catch: java.lang.Throwable -> Lcb
            long r7 = com.google.android.gms.internal.ads.zzfj.zzq(r3)     // Catch: java.lang.Throwable -> Lcb
            long r5 = r5 + r7
            java.lang.Math.max(r3, r5)     // Catch: java.lang.Throwable -> Lcb
            com.google.android.gms.internal.ads.zznv.zzd(r1)     // Catch: java.lang.Throwable -> Lcb
        L9d:
            boolean r1 = com.google.android.gms.internal.ads.zznv.zzi(r0)     // Catch: java.lang.Throwable -> Lcb
            if (r1 != 0) goto La9
            com.google.android.gms.internal.ads.zznv.zzf(r0, r2)     // Catch: java.lang.Throwable -> Lcb
            com.google.android.gms.internal.ads.zznv.zzd(r0)     // Catch: java.lang.Throwable -> Lcb
        La9:
            java.lang.String r1 = com.google.android.gms.internal.ads.zznv.zzd(r0)     // Catch: java.lang.Throwable -> Lcb
            java.lang.String r3 = r9.zzi     // Catch: java.lang.Throwable -> Lcb
            boolean r1 = r1.equals(r3)     // Catch: java.lang.Throwable -> Lcb
            if (r1 == 0) goto Lc9
            boolean r1 = com.google.android.gms.internal.ads.zznv.zzh(r0)     // Catch: java.lang.Throwable -> Lcb
            if (r1 != 0) goto Lc9
            com.google.android.gms.internal.ads.zznv.zze(r0, r2)     // Catch: java.lang.Throwable -> Lcb
            com.google.android.gms.internal.ads.zznz r1 = r9.zzg     // Catch: java.lang.Throwable -> Lcb
            java.lang.String r0 = com.google.android.gms.internal.ads.zznv.zzd(r0)     // Catch: java.lang.Throwable -> Lcb
            r1.zzc(r10, r0)     // Catch: java.lang.Throwable -> Lcb
            monitor-exit(r9)
            return
        Lc9:
            monitor-exit(r9)
            return
        Lcb:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zznw.zzh(com.google.android.gms.internal.ads.zzlt):void");
    }

    @Override // com.google.android.gms.internal.ads.zzoa
    public final synchronized void zzi(zzlt zzltVar, int i4) {
        boolean z3;
        String str;
        String str2;
        boolean z4;
        this.zzg.getClass();
        Iterator it = this.zze.values().iterator();
        while (it.hasNext()) {
            zznv zznvVar = (zznv) it.next();
            if (zznvVar.zzk(zzltVar)) {
                it.remove();
                z3 = zznvVar.zzf;
                if (z3) {
                    str = zznvVar.zzb;
                    boolean equals = str.equals(this.zzi);
                    boolean z5 = false;
                    if (i4 == 0 && equals) {
                        z4 = zznvVar.zzg;
                        if (z4) {
                            z5 = true;
                        }
                    }
                    if (equals) {
                        this.zzi = null;
                    }
                    zznz zznzVar = this.zzg;
                    str2 = zznvVar.zzb;
                    zznzVar.zzd(zzltVar, str2, z5);
                }
            }
        }
        zzm(zzltVar);
    }

    @Override // com.google.android.gms.internal.ads.zzoa
    public final synchronized void zzj(zzlt zzltVar) {
        boolean z3;
        String str;
        String str2;
        this.zzg.getClass();
        zzcw zzcwVar = this.zzh;
        this.zzh = zzltVar.zzb;
        Iterator it = this.zze.values().iterator();
        while (it.hasNext()) {
            zznv zznvVar = (zznv) it.next();
            if (!zznvVar.zzl(zzcwVar, this.zzh) || zznvVar.zzk(zzltVar)) {
                it.remove();
                z3 = zznvVar.zzf;
                if (z3) {
                    str = zznvVar.zzb;
                    if (str.equals(this.zzi)) {
                        this.zzi = null;
                    }
                    zznz zznzVar = this.zzg;
                    str2 = zznvVar.zzb;
                    zznzVar.zzd(zzltVar, str2, false);
                }
            }
        }
        zzm(zzltVar);
    }

    public zznw(zzfpx zzfpxVar) {
        this.zzf = zzfpxVar;
        this.zzc = new zzcv();
        this.zzd = new zzct();
        this.zze = new HashMap();
        this.zzh = zzcw.zza;
    }
}
