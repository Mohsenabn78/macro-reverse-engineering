package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzagy implements zzaaw, zzabv {
    public static final zzabd zza = new zzabd() { // from class: com.google.android.gms.internal.ads.zzagv
        @Override // com.google.android.gms.internal.ads.zzabd
        public final /* synthetic */ zzaaw[] zza(Uri uri, Map map) {
            int i4 = zzabc.zza;
            return new zzaaw[]{new zzagy(0)};
        }
    };
    private final zzfa zzb;
    private final zzfa zzc;
    private final zzfa zzd;
    private final zzfa zze;
    private final ArrayDeque zzf;
    private final zzaha zzg;
    private final List zzh;
    private int zzi;
    private int zzj;
    private long zzk;
    private int zzl;
    @Nullable
    private zzfa zzm;
    private int zzn;
    private int zzo;
    private int zzp;
    private int zzq;
    private zzaaz zzr;
    private zzagx[] zzs;
    private long[][] zzt;
    private int zzu;
    private long zzv;
    private int zzw;
    @Nullable
    private zzafa zzx;

    public zzagy() {
        this(0);
    }

    private static int zzf(int i4) {
        if (i4 != 1751476579) {
            if (i4 != 1903435808) {
                return 0;
            }
            return 1;
        }
        return 2;
    }

    private static int zzi(zzahf zzahfVar, long j4) {
        int zza2 = zzahfVar.zza(j4);
        if (zza2 == -1) {
            return zzahfVar.zzb(j4);
        }
        return zza2;
    }

    private static long zzj(zzahf zzahfVar, long j4, long j5) {
        int zzi = zzi(zzahfVar, j4);
        if (zzi == -1) {
            return j5;
        }
        return Math.min(zzahfVar.zzc[zzi], j5);
    }

    private final void zzk() {
        this.zzi = 0;
        this.zzl = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:78:0x01a4 A[LOOP:2: B:76:0x01a1->B:78:0x01a4, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01cf A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void zzl(long r31) throws com.google.android.gms.internal.ads.zzcd {
        /*
            Method dump skipped, instructions count: 659
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzagy.zzl(long):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:193:0x0379, code lost:
        r3 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:258:0x0081 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x007b  */
    @Override // com.google.android.gms.internal.ads.zzaaw
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int zza(com.google.android.gms.internal.ads.zzaax r33, com.google.android.gms.internal.ads.zzabs r34) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1028
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzagy.zza(com.google.android.gms.internal.ads.zzaax, com.google.android.gms.internal.ads.zzabs):int");
    }

    @Override // com.google.android.gms.internal.ads.zzaaw
    public final void zzb(zzaaz zzaazVar) {
        this.zzr = zzaazVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaaw
    public final void zzc(long j4, long j5) {
        zzagx[] zzagxVarArr;
        this.zzf.clear();
        this.zzl = 0;
        this.zzn = -1;
        this.zzo = 0;
        this.zzp = 0;
        this.zzq = 0;
        if (j4 == 0) {
            zzk();
            return;
        }
        for (zzagx zzagxVar : this.zzs) {
            zzahf zzahfVar = zzagxVar.zzb;
            int zza2 = zzahfVar.zza(j5);
            if (zza2 == -1) {
                zza2 = zzahfVar.zzb(j5);
            }
            zzagxVar.zze = zza2;
            zzaca zzacaVar = zzagxVar.zzd;
            if (zzacaVar != null) {
                zzacaVar.zzb();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaaw
    public final boolean zzd(zzaax zzaaxVar) throws IOException {
        return zzahb.zzb(zzaaxVar, false);
    }

    @Override // com.google.android.gms.internal.ads.zzabv
    public final long zze() {
        return this.zzv;
    }

    @Override // com.google.android.gms.internal.ads.zzabv
    public final zzabt zzg(long j4) {
        long j5;
        long j6;
        int zzb;
        zzagx[] zzagxVarArr = this.zzs;
        if (zzagxVarArr.length == 0) {
            zzabw zzabwVar = zzabw.zza;
            return new zzabt(zzabwVar, zzabwVar);
        }
        int i4 = this.zzu;
        long j7 = -1;
        if (i4 != -1) {
            zzahf zzahfVar = zzagxVarArr[i4].zzb;
            int zzi = zzi(zzahfVar, j4);
            if (zzi == -1) {
                zzabw zzabwVar2 = zzabw.zza;
                return new zzabt(zzabwVar2, zzabwVar2);
            }
            long j8 = zzahfVar.zzf[zzi];
            j5 = zzahfVar.zzc[zzi];
            if (j8 < j4 && zzi < zzahfVar.zzb - 1 && (zzb = zzahfVar.zzb(j4)) != -1 && zzb != zzi) {
                j6 = zzahfVar.zzf[zzb];
                j7 = zzahfVar.zzc[zzb];
            } else {
                j6 = -9223372036854775807L;
            }
            j4 = j8;
        } else {
            j5 = Long.MAX_VALUE;
            j6 = -9223372036854775807L;
        }
        int i5 = 0;
        while (true) {
            zzagx[] zzagxVarArr2 = this.zzs;
            if (i5 >= zzagxVarArr2.length) {
                break;
            }
            if (i5 != this.zzu) {
                zzahf zzahfVar2 = zzagxVarArr2[i5].zzb;
                long zzj = zzj(zzahfVar2, j4, j5);
                if (j6 != -9223372036854775807L) {
                    j7 = zzj(zzahfVar2, j6, j7);
                }
                j5 = zzj;
            }
            i5++;
        }
        zzabw zzabwVar3 = new zzabw(j4, j5);
        if (j6 == -9223372036854775807L) {
            return new zzabt(zzabwVar3, zzabwVar3);
        }
        return new zzabt(zzabwVar3, new zzabw(j6, j7));
    }

    @Override // com.google.android.gms.internal.ads.zzabv
    public final boolean zzh() {
        return true;
    }

    public zzagy(int i4) {
        this.zzi = 0;
        this.zzg = new zzaha();
        this.zzh = new ArrayList();
        this.zze = new zzfa(16);
        this.zzf = new ArrayDeque();
        this.zzb = new zzfa(zzfu.zza);
        this.zzc = new zzfa(4);
        this.zzd = new zzfa();
        this.zzn = -1;
        this.zzr = zzaaz.zza;
        this.zzs = new zzagx[0];
    }
}
