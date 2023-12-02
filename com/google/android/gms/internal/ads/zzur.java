package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzur implements zztm, zzaaz, zzxu, zzxz, zzvd {
    private static final Map zzb;
    private static final zzam zzc;
    private boolean zzA;
    private boolean zzC;
    private boolean zzD;
    private int zzE;
    private boolean zzF;
    private long zzG;
    private boolean zzI;
    private int zzJ;
    private boolean zzK;
    private boolean zzL;
    private final zzxt zzM;
    private final zzxp zzN;
    private final Uri zzd;
    private final zzge zze;
    private final zzqu zzf;
    private final zztx zzg;
    private final zzqo zzh;
    private final zzun zzi;
    private final long zzj;
    private final zzuh zzl;
    @Nullable
    private zztl zzq;
    @Nullable
    private zzadw zzr;
    private boolean zzu;
    private boolean zzv;
    private boolean zzw;
    private zzuq zzx;
    private zzabv zzy;
    private final zzyc zzk = new zzyc("ProgressiveMediaPeriod");
    private final zzeb zzm = new zzeb(zzdz.zza);
    private final Runnable zzn = new Runnable() { // from class: com.google.android.gms.internal.ads.zzui
        @Override // java.lang.Runnable
        public final void run() {
            zzur.this.zzT();
        }
    };
    private final Runnable zzo = new Runnable() { // from class: com.google.android.gms.internal.ads.zzuj
        @Override // java.lang.Runnable
        public final void run() {
            zzur.this.zzD();
        }
    };
    private final Handler zzp = zzfj.zzt(null);
    private zzup[] zzt = new zzup[0];
    private zzve[] zzs = new zzve[0];
    private long zzH = -9223372036854775807L;
    private long zzz = -9223372036854775807L;
    private int zzB = 1;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("Icy-MetaData", "1");
        zzb = Collections.unmodifiableMap(hashMap);
        zzak zzakVar = new zzak();
        zzakVar.zzH("icy");
        zzakVar.zzS("application/x-icy");
        zzc = zzakVar.zzY();
    }

    public zzur(Uri uri, zzge zzgeVar, zzuh zzuhVar, zzqu zzquVar, zzqo zzqoVar, zzxt zzxtVar, zztx zztxVar, zzun zzunVar, zzxp zzxpVar, @Nullable String str, int i4) {
        this.zzd = uri;
        this.zze = zzgeVar;
        this.zzf = zzquVar;
        this.zzh = zzqoVar;
        this.zzM = zzxtVar;
        this.zzg = zztxVar;
        this.zzi = zzunVar;
        this.zzN = zzxpVar;
        this.zzj = i4;
        this.zzl = zzuhVar;
    }

    private final int zzP() {
        int i4 = 0;
        for (zzve zzveVar : this.zzs) {
            i4 += zzveVar.zzc();
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long zzQ(boolean z3) {
        int i4 = 0;
        long j4 = Long.MIN_VALUE;
        while (true) {
            zzve[] zzveVarArr = this.zzs;
            if (i4 < zzveVarArr.length) {
                if (!z3) {
                    zzuq zzuqVar = this.zzx;
                    zzuqVar.getClass();
                    if (!zzuqVar.zzc[i4]) {
                        i4++;
                    }
                }
                j4 = Math.max(j4, zzveVarArr[i4].zzg());
                i4++;
            } else {
                return j4;
            }
        }
    }

    private final zzabz zzR(zzup zzupVar) {
        int length = this.zzs.length;
        for (int i4 = 0; i4 < length; i4++) {
            if (zzupVar.equals(this.zzt[i4])) {
                return this.zzs[i4];
            }
        }
        zzve zzveVar = new zzve(this.zzN, this.zzf, this.zzh);
        zzveVar.zzu(this);
        int i5 = length + 1;
        zzup[] zzupVarArr = (zzup[]) Arrays.copyOf(this.zzt, i5);
        zzupVarArr[length] = zzupVar;
        int i6 = zzfj.zza;
        this.zzt = zzupVarArr;
        zzve[] zzveVarArr = (zzve[]) Arrays.copyOf(this.zzs, i5);
        zzveVarArr[length] = zzveVar;
        this.zzs = zzveVarArr;
        return zzveVar;
    }

    @EnsuresNonNull({"trackState", "seekMap"})
    private final void zzS() {
        zzdy.zzf(this.zzv);
        this.zzx.getClass();
        this.zzy.getClass();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzT() {
        boolean z3;
        zzbz zzc2;
        int i4;
        if (!this.zzL && !this.zzv && this.zzu && this.zzy != null) {
            for (zzve zzveVar : this.zzs) {
                if (zzveVar.zzh() == null) {
                    return;
                }
            }
            this.zzm.zzc();
            int length = this.zzs.length;
            zzcy[] zzcyVarArr = new zzcy[length];
            boolean[] zArr = new boolean[length];
            for (int i5 = 0; i5 < length; i5++) {
                zzam zzh = this.zzs[i5].zzh();
                zzh.getClass();
                String str = zzh.zzm;
                boolean zzf = zzcc.zzf(str);
                if (!zzf && !zzcc.zzg(str)) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                zArr[i5] = z3;
                this.zzw = z3 | this.zzw;
                zzadw zzadwVar = this.zzr;
                if (zzadwVar != null) {
                    if (zzf || this.zzt[i5].zzb) {
                        zzbz zzbzVar = zzh.zzk;
                        if (zzbzVar == null) {
                            zzc2 = new zzbz(-9223372036854775807L, zzadwVar);
                        } else {
                            zzc2 = zzbzVar.zzc(zzadwVar);
                        }
                        zzak zzb2 = zzh.zzb();
                        zzb2.zzM(zzc2);
                        zzh = zzb2.zzY();
                    }
                    if (zzf && zzh.zzg == -1 && zzh.zzh == -1 && (i4 = zzadwVar.zza) != -1) {
                        zzak zzb3 = zzh.zzb();
                        zzb3.zzv(i4);
                        zzh = zzb3.zzY();
                    }
                }
                zzcyVarArr[i5] = new zzcy(Integer.toString(i5), zzh.zzc(this.zzf.zza(zzh)));
            }
            this.zzx = new zzuq(new zzvn(zzcyVarArr), zArr);
            this.zzv = true;
            zztl zztlVar = this.zzq;
            zztlVar.getClass();
            zztlVar.zzi(this);
        }
    }

    private final void zzU(int i4) {
        zzS();
        zzuq zzuqVar = this.zzx;
        boolean[] zArr = zzuqVar.zzd;
        if (!zArr[i4]) {
            zzam zzb2 = zzuqVar.zza.zzb(i4).zzb(0);
            this.zzg.zzc(new zztk(1, zzcc.zzb(zzb2.zzm), zzb2, 0, null, zzfj.zzq(this.zzG), -9223372036854775807L));
            zArr[i4] = true;
        }
    }

    private final void zzV(int i4) {
        zzS();
        boolean[] zArr = this.zzx.zzb;
        if (this.zzI && zArr[i4] && !this.zzs[i4].zzx(false)) {
            this.zzH = 0L;
            this.zzI = false;
            this.zzD = true;
            this.zzG = 0L;
            this.zzJ = 0;
            for (zzve zzveVar : this.zzs) {
                zzveVar.zzp(false);
            }
            zztl zztlVar = this.zzq;
            zztlVar.getClass();
            zztlVar.zzg(this);
        }
    }

    private final void zzW() {
        zzum zzumVar = new zzum(this, this.zzd, this.zze, this.zzl, this, this.zzm);
        if (this.zzv) {
            zzdy.zzf(zzX());
            long j4 = this.zzz;
            if (j4 != -9223372036854775807L && this.zzH > j4) {
                this.zzK = true;
                this.zzH = -9223372036854775807L;
                return;
            }
            zzabv zzabvVar = this.zzy;
            zzabvVar.getClass();
            zzum.zzf(zzumVar, zzabvVar.zzg(this.zzH).zza.zzc, this.zzH);
            for (zzve zzveVar : this.zzs) {
                zzveVar.zzt(this.zzH);
            }
            this.zzH = -9223372036854775807L;
        }
        this.zzJ = zzP();
        long zza = this.zzk.zza(zzumVar, this, zzxt.zza(this.zzB));
        zzgj zzd = zzum.zzd(zzumVar);
        this.zzg.zzg(new zztf(zzum.zzb(zzumVar), zzd, zzd.zza, Collections.emptyMap(), zza, 0L, 0L), new zztk(1, -1, null, 0, null, zzfj.zzq(zzum.zzc(zzumVar)), zzfj.zzq(this.zzz)));
    }

    private final boolean zzX() {
        if (this.zzH != -9223372036854775807L) {
            return true;
        }
        return false;
    }

    private final boolean zzY() {
        if (!this.zzD && !zzX()) {
            return false;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzaaz
    public final void zzC() {
        this.zzu = true;
        this.zzp.post(this.zzn);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzD() {
        if (!this.zzL) {
            zztl zztlVar = this.zzq;
            zztlVar.getClass();
            zztlVar.zzg(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzE() {
        this.zzF = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzF(zzabv zzabvVar) {
        zzabv zzabuVar;
        if (this.zzr == null) {
            zzabuVar = zzabvVar;
        } else {
            zzabuVar = new zzabu(-9223372036854775807L, 0L);
        }
        this.zzy = zzabuVar;
        this.zzz = zzabvVar.zze();
        boolean z3 = false;
        int i4 = 1;
        if (!this.zzF && zzabvVar.zze() == -9223372036854775807L) {
            z3 = true;
        }
        this.zzA = z3;
        if (true == z3) {
            i4 = 7;
        }
        this.zzB = i4;
        this.zzi.zza(this.zzz, zzabvVar.zzh(), this.zzA);
        if (!this.zzv) {
            zzT();
        }
    }

    final void zzG() throws IOException {
        this.zzk.zzi(zzxt.zza(this.zzB));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzH(int i4) throws IOException {
        this.zzs[i4].zzm();
        zzG();
    }

    @Override // com.google.android.gms.internal.ads.zzxu
    public final /* bridge */ /* synthetic */ void zzI(zzxy zzxyVar, long j4, long j5, boolean z3) {
        zzum zzumVar = (zzum) zzxyVar;
        zzhf zze = zzum.zze(zzumVar);
        zztf zztfVar = new zztf(zzum.zzb(zzumVar), zzum.zzd(zzumVar), zze.zzh(), zze.zzi(), j4, j5, zze.zzg());
        zzum.zzb(zzumVar);
        this.zzg.zzd(zztfVar, new zztk(1, -1, null, 0, null, zzfj.zzq(zzum.zzc(zzumVar)), zzfj.zzq(this.zzz)));
        if (!z3) {
            for (zzve zzveVar : this.zzs) {
                zzveVar.zzp(false);
            }
            if (this.zzE > 0) {
                zztl zztlVar = this.zzq;
                zztlVar.getClass();
                zztlVar.zzg(this);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxu
    public final /* bridge */ /* synthetic */ void zzJ(zzxy zzxyVar, long j4, long j5) {
        zzabv zzabvVar;
        long j6;
        if (this.zzz == -9223372036854775807L && (zzabvVar = this.zzy) != null) {
            boolean zzh = zzabvVar.zzh();
            long zzQ = zzQ(true);
            if (zzQ == Long.MIN_VALUE) {
                j6 = 0;
            } else {
                j6 = zzQ + 10000;
            }
            this.zzz = j6;
            this.zzi.zza(j6, zzh, this.zzA);
        }
        zzum zzumVar = (zzum) zzxyVar;
        zzhf zze = zzum.zze(zzumVar);
        zztf zztfVar = new zztf(zzum.zzb(zzumVar), zzum.zzd(zzumVar), zze.zzh(), zze.zzi(), j4, j5, zze.zzg());
        zzum.zzb(zzumVar);
        this.zzg.zze(zztfVar, new zztk(1, -1, null, 0, null, zzfj.zzq(zzum.zzc(zzumVar)), zzfj.zzq(this.zzz)));
        this.zzK = true;
        zztl zztlVar = this.zzq;
        zztlVar.getClass();
        zztlVar.zzg(this);
    }

    @Override // com.google.android.gms.internal.ads.zzxz
    public final void zzK() {
        for (zzve zzveVar : this.zzs) {
            zzveVar.zzo();
        }
        this.zzl.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzvd
    public final void zzL(zzam zzamVar) {
        this.zzp.post(this.zzn);
    }

    public final void zzM() {
        if (this.zzv) {
            for (zzve zzveVar : this.zzs) {
                zzveVar.zzn();
            }
        }
        this.zzk.zzj(this);
        this.zzp.removeCallbacksAndMessages(null);
        this.zzq = null;
        this.zzL = true;
    }

    @Override // com.google.android.gms.internal.ads.zzaaz
    public final void zzN(final zzabv zzabvVar) {
        this.zzp.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzul
            @Override // java.lang.Runnable
            public final void run() {
                zzur.this.zzF(zzabvVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzO(int i4) {
        if (!zzY() && this.zzs[i4].zzx(this.zzK)) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zztm
    public final long zza(long j4, zzlm zzlmVar) {
        boolean z3;
        zzS();
        if (!this.zzy.zzh()) {
            return 0L;
        }
        zzabt zzg = this.zzy.zzg(j4);
        long j5 = zzg.zza.zzb;
        long j6 = zzg.zzb.zzb;
        long j7 = zzlmVar.zzf;
        if (j7 == 0) {
            if (zzlmVar.zzg == 0) {
                return j4;
            }
            j7 = 0;
        }
        int i4 = zzfj.zza;
        long j8 = j4 - j7;
        long j9 = zzlmVar.zzg;
        long j10 = j4 + j9;
        long j11 = j4 ^ j10;
        long j12 = j9 ^ j10;
        if (((j7 ^ j4) & (j4 ^ j8)) < 0) {
            j8 = Long.MIN_VALUE;
        }
        if ((j11 & j12) < 0) {
            j10 = Long.MAX_VALUE;
        }
        boolean z4 = true;
        if (j8 <= j5 && j5 <= j10) {
            z3 = true;
        } else {
            z3 = false;
        }
        z4 = (j8 > j6 || j6 > j10) ? false : false;
        if (z3 && z4) {
            if (Math.abs(j5 - j4) > Math.abs(j6 - j4)) {
                return j6;
            }
        } else if (!z3) {
            if (z4) {
                return j6;
            }
            return j8;
        }
        return j5;
    }

    @Override // com.google.android.gms.internal.ads.zztm, com.google.android.gms.internal.ads.zzvh
    public final long zzb() {
        long j4;
        zzS();
        if (this.zzK || this.zzE == 0) {
            return Long.MIN_VALUE;
        }
        if (zzX()) {
            return this.zzH;
        }
        if (this.zzw) {
            int length = this.zzs.length;
            j4 = Long.MAX_VALUE;
            for (int i4 = 0; i4 < length; i4++) {
                zzuq zzuqVar = this.zzx;
                if (zzuqVar.zzb[i4] && zzuqVar.zzc[i4] && !this.zzs[i4].zzw()) {
                    j4 = Math.min(j4, this.zzs[i4].zzg());
                }
            }
        } else {
            j4 = Long.MAX_VALUE;
        }
        if (j4 == Long.MAX_VALUE) {
            j4 = zzQ(false);
        }
        if (j4 == Long.MIN_VALUE) {
            return this.zzG;
        }
        return j4;
    }

    @Override // com.google.android.gms.internal.ads.zztm, com.google.android.gms.internal.ads.zzvh
    public final long zzc() {
        return zzb();
    }

    @Override // com.google.android.gms.internal.ads.zztm
    public final long zzd() {
        if (this.zzD) {
            if (this.zzK || zzP() > this.zzJ) {
                this.zzD = false;
                return this.zzG;
            }
            return -9223372036854775807L;
        }
        return -9223372036854775807L;
    }

    @Override // com.google.android.gms.internal.ads.zztm
    public final long zze(long j4) {
        zzS();
        boolean[] zArr = this.zzx.zzb;
        if (true != this.zzy.zzh()) {
            j4 = 0;
        }
        this.zzD = false;
        this.zzG = j4;
        if (zzX()) {
            this.zzH = j4;
            return j4;
        }
        if (this.zzB != 7) {
            int length = this.zzs.length;
            for (int i4 = 0; i4 < length; i4++) {
                if (this.zzs[i4].zzy(j4, false) || (!zArr[i4] && this.zzw)) {
                }
            }
            return j4;
        }
        this.zzI = false;
        this.zzH = j4;
        this.zzK = false;
        zzyc zzycVar = this.zzk;
        if (zzycVar.zzl()) {
            for (zzve zzveVar : this.zzs) {
                zzveVar.zzj();
            }
            this.zzk.zzg();
        } else {
            zzycVar.zzh();
            for (zzve zzveVar2 : this.zzs) {
                zzveVar2.zzp(false);
            }
        }
        return j4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x003a, code lost:
        if (r2 == 0) goto L77;
     */
    @Override // com.google.android.gms.internal.ads.zztm
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long zzf(com.google.android.gms.internal.ads.zzxa[] r8, boolean[] r9, com.google.android.gms.internal.ads.zzvf[] r10, boolean[] r11, long r12) {
        /*
            Method dump skipped, instructions count: 231
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzur.zzf(com.google.android.gms.internal.ads.zzxa[], boolean[], com.google.android.gms.internal.ads.zzvf[], boolean[], long):long");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzg(int i4, zzkj zzkjVar, zzhp zzhpVar, int i5) {
        if (zzY()) {
            return -3;
        }
        zzU(i4);
        int zzd = this.zzs[i4].zzd(zzkjVar, zzhpVar, i5, this.zzK);
        if (zzd == -3) {
            zzV(i4);
        }
        return zzd;
    }

    @Override // com.google.android.gms.internal.ads.zztm
    public final zzvn zzh() {
        zzS();
        return this.zzx.zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzi(int i4, long j4) {
        if (zzY()) {
            return 0;
        }
        zzU(i4);
        zzve zzveVar = this.zzs[i4];
        int zzb2 = zzveVar.zzb(j4, this.zzK);
        zzveVar.zzv(zzb2);
        if (zzb2 == 0) {
            zzV(i4);
            return 0;
        }
        return zzb2;
    }

    @Override // com.google.android.gms.internal.ads.zztm
    public final void zzj(long j4, boolean z3) {
        zzS();
        if (zzX()) {
            return;
        }
        boolean[] zArr = this.zzx.zzc;
        int length = this.zzs.length;
        for (int i4 = 0; i4 < length; i4++) {
            this.zzs[i4].zzi(j4, false, zArr[i4]);
        }
    }

    @Override // com.google.android.gms.internal.ads.zztm
    public final void zzk() throws IOException {
        zzG();
        if (this.zzK && !this.zzv) {
            throw zzcd.zza("Loading finished before preparation is complete.", null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zztm
    public final void zzl(zztl zztlVar, long j4) {
        this.zzq = zztlVar;
        this.zzm.zze();
        zzW();
    }

    @Override // com.google.android.gms.internal.ads.zztm, com.google.android.gms.internal.ads.zzvh
    public final boolean zzo(long j4) {
        if (!this.zzK && !this.zzk.zzk() && !this.zzI) {
            if (!this.zzv || this.zzE != 0) {
                boolean zze = this.zzm.zze();
                if (!this.zzk.zzl()) {
                    zzW();
                    return true;
                }
                return zze;
            }
            return false;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zztm, com.google.android.gms.internal.ads.zzvh
    public final boolean zzp() {
        if (this.zzk.zzl() && this.zzm.zzd()) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00e3  */
    @Override // com.google.android.gms.internal.ads.zzxu
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final /* bridge */ /* synthetic */ com.google.android.gms.internal.ads.zzxw zzt(com.google.android.gms.internal.ads.zzxy r22, long r23, long r25, java.io.IOException r27, int r28) {
        /*
            Method dump skipped, instructions count: 231
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzur.zzt(com.google.android.gms.internal.ads.zzxy, long, long, java.io.IOException, int):com.google.android.gms.internal.ads.zzxw");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzabz zzu() {
        return zzR(new zzup(0, true));
    }

    @Override // com.google.android.gms.internal.ads.zzaaz
    public final zzabz zzv(int i4, int i5) {
        return zzR(new zzup(i4, false));
    }

    @Override // com.google.android.gms.internal.ads.zztm, com.google.android.gms.internal.ads.zzvh
    public final void zzm(long j4) {
    }
}
