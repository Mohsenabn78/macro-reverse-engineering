package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Pair;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzkh implements Handler.Callback, zztl, zzxf, zzla, zzie, zzld {
    private boolean zzA;
    private boolean zzD;
    private boolean zzE;
    private boolean zzF;
    private int zzG;
    @Nullable
    private zzkg zzH;
    private long zzI;
    private int zzJ;
    private boolean zzK;
    @Nullable
    private zzih zzL;
    private final zzjc zzN;
    private final zzic zzO;
    private final zzli[] zza;
    private final Set zzb;
    private final zzlk[] zzc;
    private final zzxg zzd;
    private final zzxh zze;
    private final zzkk zzf;
    private final zzxo zzg;
    private final zzei zzh;
    @Nullable
    private final HandlerThread zzi;
    private final Looper zzj;
    private final zzcv zzk;
    private final zzct zzl;
    private final long zzm;
    private final zzif zzn;
    private final ArrayList zzo;
    private final zzdz zzp;
    private final zzkp zzq;
    private final zzlb zzr;
    private final long zzs;
    private zzlm zzt;
    private zzlc zzu;
    private zzkf zzv;
    private boolean zzw;
    private boolean zzy;
    private boolean zzz;
    private int zzB = 0;
    private boolean zzC = false;
    private boolean zzx = false;
    private long zzM = -9223372036854775807L;

    public zzkh(zzli[] zzliVarArr, zzxg zzxgVar, zzxh zzxhVar, zzkk zzkkVar, zzxo zzxoVar, int i4, boolean z3, zzls zzlsVar, zzlm zzlmVar, zzic zzicVar, long j4, boolean z4, Looper looper, zzdz zzdzVar, zzjc zzjcVar, zzoc zzocVar, Looper looper2) {
        this.zzN = zzjcVar;
        this.zza = zzliVarArr;
        this.zzd = zzxgVar;
        this.zze = zzxhVar;
        this.zzf = zzkkVar;
        this.zzg = zzxoVar;
        this.zzt = zzlmVar;
        this.zzO = zzicVar;
        this.zzs = j4;
        this.zzp = zzdzVar;
        this.zzm = zzkkVar.zza();
        zzkkVar.zzf();
        zzlc zzi = zzlc.zzi(zzxhVar);
        this.zzu = zzi;
        this.zzv = new zzkf(zzi);
        int length = zzliVarArr.length;
        this.zzc = new zzlk[2];
        zzlj zzc = zzxgVar.zzc();
        for (int i5 = 0; i5 < 2; i5++) {
            zzliVarArr[i5].zzr(i5, zzocVar);
            this.zzc[i5] = zzliVarArr[i5].zzj();
            this.zzc[i5].zzF(zzc);
        }
        this.zzn = new zzif(this, zzdzVar);
        this.zzo = new ArrayList();
        this.zzb = Collections.newSetFromMap(new IdentityHashMap());
        this.zzk = new zzcv();
        this.zzl = new zzct();
        zzxgVar.zzr(this, zzxoVar);
        this.zzK = true;
        zzei zzb = zzdzVar.zzb(looper, null);
        this.zzq = new zzkp(zzlsVar, zzb);
        this.zzr = new zzlb(this, zzlsVar, zzb, zzocVar);
        HandlerThread handlerThread = new HandlerThread("ExoPlayer:Playback", -16);
        this.zzi = handlerThread;
        handlerThread.start();
        Looper looper3 = handlerThread.getLooper();
        this.zzj = looper3;
        this.zzh = zzdzVar.zzb(looper3, this);
    }

    private final void zzA(zzli zzliVar) throws zzih {
        if (!zzae(zzliVar)) {
            return;
        }
        this.zzn.zzd(zzliVar);
        zzal(zzliVar);
        zzliVar.zzo();
        this.zzG--;
    }

    private final void zzB() throws zzih {
        int length = this.zza.length;
        zzC(new boolean[2]);
    }

    private final void zzC(boolean[] zArr) throws zzih {
        boolean z3;
        boolean z4;
        boolean z5;
        zzkm zze = this.zzq.zze();
        zzxh zzi = zze.zzi();
        int i4 = 0;
        while (true) {
            int length = this.zza.length;
            if (i4 >= 2) {
                break;
            }
            if (!zzi.zzb(i4) && this.zzb.remove(this.zza[i4])) {
                this.zza[i4].zzC();
            }
            i4++;
        }
        int i5 = 0;
        while (true) {
            int length2 = this.zza.length;
            if (i5 < 2) {
                if (zzi.zzb(i5)) {
                    boolean z6 = zArr[i5];
                    zzli zzliVar = this.zza[i5];
                    if (!zzae(zzliVar)) {
                        zzkm zze2 = this.zzq.zze();
                        if (zze2 == this.zzq.zzd()) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        zzxh zzi2 = zze2.zzi();
                        zzll zzllVar = zzi2.zzb[i5];
                        zzam[] zzaj = zzaj(zzi2.zzc[i5]);
                        if (zzah() && this.zzu.zze == 3) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        if (!z6 && z4) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        this.zzG++;
                        this.zzb.add(zzliVar);
                        zzliVar.zzp(zzllVar, zzaj, zze2.zzc[i5], this.zzI, z5, z3, zze2.zzf(), zze2.zze());
                        zzliVar.zzq(11, new zzka(this));
                        this.zzn.zze(zzliVar);
                        if (z4) {
                            zzliVar.zzH();
                        }
                    }
                }
                i5++;
            } else {
                zze.zzg = true;
                return;
            }
        }
    }

    private final void zzD(IOException iOException, int i4) {
        zzih zzc = zzih.zzc(iOException, i4);
        zzkm zzd = this.zzq.zzd();
        if (zzd != null) {
            zzc = zzc.zza(zzd.zzf.zza);
        }
        zzer.zzd("ExoPlayerImplInternal", "Playback error", zzc);
        zzW(false, false);
        this.zzu = this.zzu.zzf(zzc);
    }

    private final void zzE(boolean z3) {
        zzto zztoVar;
        long zzc;
        zzkm zzc2 = this.zzq.zzc();
        if (zzc2 == null) {
            zztoVar = this.zzu.zzb;
        } else {
            zztoVar = zzc2.zzf.zza;
        }
        boolean z4 = !this.zzu.zzk.equals(zztoVar);
        if (z4) {
            this.zzu = this.zzu.zzc(zztoVar);
        }
        zzlc zzlcVar = this.zzu;
        if (zzc2 == null) {
            zzc = zzlcVar.zzr;
        } else {
            zzc = zzc2.zzc();
        }
        zzlcVar.zzp = zzc;
        this.zzu.zzq = zzt();
        if ((z4 || z3) && zzc2 != null && zzc2.zzd) {
            zzZ(zzc2.zzf.zza, zzc2.zzh(), zzc2.zzi());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:182:0x0337  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x037d  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x03a7  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01bc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void zzF(com.google.android.gms.internal.ads.zzcw r28, boolean r29) throws com.google.android.gms.internal.ads.zzih {
        /*
            Method dump skipped, instructions count: 942
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzkh.zzF(com.google.android.gms.internal.ads.zzcw, boolean):void");
    }

    private final void zzG(zzch zzchVar, boolean z3) throws zzih {
        zzH(zzchVar, zzchVar.zzc, true, z3);
    }

    private final void zzH(zzch zzchVar, float f4, boolean z3, boolean z4) throws zzih {
        int i4;
        zzkh zzkhVar = this;
        if (z3) {
            if (z4) {
                zzkhVar.zzv.zza(1);
            }
            zzlc zzlcVar = zzkhVar.zzu;
            zzkhVar = this;
            zzkhVar.zzu = new zzlc(zzlcVar.zza, zzlcVar.zzb, zzlcVar.zzc, zzlcVar.zzd, zzlcVar.zze, zzlcVar.zzf, zzlcVar.zzg, zzlcVar.zzh, zzlcVar.zzi, zzlcVar.zzj, zzlcVar.zzk, zzlcVar.zzl, zzlcVar.zzm, zzchVar, zzlcVar.zzp, zzlcVar.zzq, zzlcVar.zzr, zzlcVar.zzs, zzlcVar.zzo);
        }
        float f5 = zzchVar.zzc;
        zzkm zzd = zzkhVar.zzq.zzd();
        while (true) {
            i4 = 0;
            if (zzd == null) {
                break;
            }
            zzxa[] zzxaVarArr = zzd.zzi().zzc;
            int length = zzxaVarArr.length;
            while (i4 < length) {
                zzxa zzxaVar = zzxaVarArr[i4];
                i4++;
            }
            zzd = zzd.zzg();
        }
        zzli[] zzliVarArr = zzkhVar.zza;
        int length2 = zzliVarArr.length;
        while (i4 < 2) {
            zzli zzliVar = zzliVarArr[i4];
            if (zzliVar != null) {
                zzliVar.zzG(f4, zzchVar.zzc);
            }
            i4++;
        }
    }

    private final void zzI() {
        long zze;
        long j4;
        boolean z3 = false;
        if (zzad()) {
            zzkm zzc = this.zzq.zzc();
            long zzu = zzu(zzc.zzd());
            if (zzc == this.zzq.zzd()) {
                zze = this.zzI;
                j4 = zzc.zze();
            } else {
                zze = this.zzI - zzc.zze();
                j4 = zzc.zzf.zzb;
            }
            long j5 = zze - j4;
            boolean zzg = this.zzf.zzg(j5, zzu, this.zzn.zzc().zzc);
            if (!zzg && zzu < 500000 && this.zzm > 0) {
                this.zzq.zzd().zza.zzj(this.zzu.zzr, false);
                z3 = this.zzf.zzg(j5, zzu, this.zzn.zzc().zzc);
            } else {
                z3 = zzg;
            }
        }
        this.zzA = z3;
        if (z3) {
            this.zzq.zzc().zzk(this.zzI);
        }
        zzY();
    }

    private final void zzJ() {
        boolean z3;
        this.zzv.zzc(this.zzu);
        z3 = this.zzv.zzg;
        if (z3) {
            zzjc zzjcVar = this.zzN;
            zzjcVar.zza.zzU(this.zzv);
            this.zzv = new zzkf(this.zzu);
        }
    }

    private final void zzK() throws zzih {
        int i4;
        boolean z3;
        float f4 = this.zzn.zzc().zzc;
        zzkm zze = this.zzq.zze();
        boolean z4 = true;
        for (zzkm zzd = this.zzq.zzd(); zzd != null && zzd.zzd; zzd = zzd.zzg()) {
            zzxh zzj = zzd.zzj(f4, this.zzu.zza);
            zzxh zzi = zzd.zzi();
            boolean z5 = false;
            if (zzi != null && zzi.zzc.length == zzj.zzc.length) {
                for (int i5 = 0; i5 < zzj.zzc.length; i5++) {
                    if (zzj.zza(zzi, i5)) {
                    }
                }
                if (zzd != zze) {
                    z5 = true;
                }
                z4 &= z5;
            }
            if (z4) {
                zzkm zzd2 = this.zzq.zzd();
                boolean zzm = this.zzq.zzm(zzd2);
                int length = this.zza.length;
                boolean[] zArr = new boolean[2];
                long zzb = zzd2.zzb(zzj, this.zzu.zzr, zzm, zArr);
                zzlc zzlcVar = this.zzu;
                if (zzlcVar.zze != 4 && zzb != zzlcVar.zzr) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                zzlc zzlcVar2 = this.zzu;
                i4 = 2;
                this.zzu = zzz(zzlcVar2.zzb, zzb, zzlcVar2.zzc, zzlcVar2.zzd, z3, 5);
                if (z3) {
                    zzO(zzb);
                }
                int length2 = this.zza.length;
                boolean[] zArr2 = new boolean[2];
                int i6 = 0;
                while (true) {
                    zzli[] zzliVarArr = this.zza;
                    int length3 = zzliVarArr.length;
                    if (i6 >= 2) {
                        break;
                    }
                    zzli zzliVar = zzliVarArr[i6];
                    boolean zzae = zzae(zzliVar);
                    zArr2[i6] = zzae;
                    zzvf zzvfVar = zzd2.zzc[i6];
                    if (zzae) {
                        if (zzvfVar != zzliVar.zzm()) {
                            zzA(zzliVar);
                        } else if (zArr[i6]) {
                            zzliVar.zzD(this.zzI);
                        }
                    }
                    i6++;
                }
                zzC(zArr2);
            } else {
                i4 = 2;
                this.zzq.zzm(zzd);
                if (zzd.zzd) {
                    zzd.zza(zzj, Math.max(zzd.zzf.zzb, this.zzI - zzd.zze()), false);
                }
            }
            zzE(true);
            if (this.zzu.zze != 4) {
                zzI();
                zzaa();
                this.zzh.zzi(i4);
                return;
            }
            return;
        }
    }

    private final void zzL() throws zzih {
        zzK();
        zzR(true);
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:66:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void zzM(boolean r32, boolean r33, boolean r34, boolean r35) {
        /*
            Method dump skipped, instructions count: 263
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzkh.zzM(boolean, boolean, boolean, boolean):void");
    }

    private final void zzN() {
        zzkm zzd = this.zzq.zzd();
        boolean z3 = false;
        if (zzd != null && zzd.zzf.zzh && this.zzx) {
            z3 = true;
        }
        this.zzy = z3;
    }

    private final void zzO(long j4) throws zzih {
        long zze;
        zzxa[] zzxaVarArr;
        zzkm zzd = this.zzq.zzd();
        if (zzd == null) {
            zze = 1000000000000L;
        } else {
            zze = zzd.zze();
        }
        long j5 = j4 + zze;
        this.zzI = j5;
        this.zzn.zzf(j5);
        zzli[] zzliVarArr = this.zza;
        int length = zzliVarArr.length;
        for (int i4 = 0; i4 < 2; i4++) {
            zzli zzliVar = zzliVarArr[i4];
            if (zzae(zzliVar)) {
                zzliVar.zzD(this.zzI);
            }
        }
        for (zzkm zzd2 = this.zzq.zzd(); zzd2 != null; zzd2 = zzd2.zzg()) {
            for (zzxa zzxaVar : zzd2.zzi().zzc) {
            }
        }
    }

    private final void zzP(zzcw zzcwVar, zzcw zzcwVar2) {
        if (zzcwVar.zzo() && zzcwVar2.zzo()) {
            return;
        }
        int size = this.zzo.size() - 1;
        if (size < 0) {
            Collections.sort(this.zzo);
            return;
        }
        Object obj = ((zzke) this.zzo.get(size)).zzb;
        int i4 = zzfj.zza;
        throw null;
    }

    private final void zzQ(long j4, long j5) {
        this.zzh.zzj(2, j4 + j5);
    }

    private final void zzR(boolean z3) throws zzih {
        zzto zztoVar = this.zzq.zzd().zzf.zza;
        long zzw = zzw(zztoVar, this.zzu.zzr, true, false);
        if (zzw != this.zzu.zzr) {
            zzlc zzlcVar = this.zzu;
            this.zzu = zzz(zztoVar, zzw, zzlcVar.zzc, zzlcVar.zzd, z3, 5);
        }
    }

    private final void zzS(zzch zzchVar) {
        this.zzh.zzf(16);
        this.zzn.zzg(zzchVar);
    }

    private final void zzT(boolean z3, int i4, boolean z4, int i5) throws zzih {
        zzxa[] zzxaVarArr;
        this.zzv.zza(z4 ? 1 : 0);
        this.zzv.zzb(i5);
        this.zzu = this.zzu.zze(z3, i4);
        this.zzz = false;
        for (zzkm zzd = this.zzq.zzd(); zzd != null; zzd = zzd.zzg()) {
            for (zzxa zzxaVar : zzd.zzi().zzc) {
            }
        }
        if (!zzah()) {
            zzX();
            zzaa();
            return;
        }
        int i6 = this.zzu.zze;
        if (i6 == 3) {
            zzV();
            this.zzh.zzi(2);
        } else if (i6 == 2) {
            this.zzh.zzi(2);
        }
    }

    private final void zzU(int i4) {
        zzlc zzlcVar = this.zzu;
        if (zzlcVar.zze != i4) {
            if (i4 != 2) {
                this.zzM = -9223372036854775807L;
            }
            this.zzu = zzlcVar.zzg(i4);
        }
    }

    private final void zzV() throws zzih {
        this.zzz = false;
        this.zzn.zzh();
        zzli[] zzliVarArr = this.zza;
        int length = zzliVarArr.length;
        for (int i4 = 0; i4 < 2; i4++) {
            zzli zzliVar = zzliVarArr[i4];
            if (zzae(zzliVar)) {
                zzliVar.zzH();
            }
        }
    }

    private final void zzW(boolean z3, boolean z4) {
        boolean z5;
        if (!z3 && this.zzD) {
            z5 = false;
        } else {
            z5 = true;
        }
        zzM(z5, false, true, false);
        this.zzv.zza(z4 ? 1 : 0);
        this.zzf.zzd();
        zzU(1);
    }

    private final void zzX() throws zzih {
        this.zzn.zzi();
        zzli[] zzliVarArr = this.zza;
        int length = zzliVarArr.length;
        for (int i4 = 0; i4 < 2; i4++) {
            zzli zzliVar = zzliVarArr[i4];
            if (zzae(zzliVar)) {
                zzal(zzliVar);
            }
        }
    }

    private final void zzY() {
        boolean z3;
        zzkm zzc = this.zzq.zzc();
        if (!this.zzA && (zzc == null || !zzc.zza.zzp())) {
            z3 = false;
        } else {
            z3 = true;
        }
        zzlc zzlcVar = this.zzu;
        if (z3 != zzlcVar.zzg) {
            this.zzu = new zzlc(zzlcVar.zza, zzlcVar.zzb, zzlcVar.zzc, zzlcVar.zzd, zzlcVar.zze, zzlcVar.zzf, z3, zzlcVar.zzh, zzlcVar.zzi, zzlcVar.zzj, zzlcVar.zzk, zzlcVar.zzl, zzlcVar.zzm, zzlcVar.zzn, zzlcVar.zzp, zzlcVar.zzq, zzlcVar.zzr, zzlcVar.zzs, zzlcVar.zzo);
        }
    }

    private final void zzZ(zzto zztoVar, zzvn zzvnVar, zzxh zzxhVar) {
        this.zzf.zze(this.zzu.zza, zztoVar, this.zza, zzvnVar, zzxhVar.zzc);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00aa A[LOOP:0: B:29:0x009a->B:36:0x00aa, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00b5 A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00b5 -> B:29:0x009a). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void zzaa() throws com.google.android.gms.internal.ads.zzih {
        /*
            Method dump skipped, instructions count: 330
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzkh.zzaa():void");
    }

    private final void zzab(zzcw zzcwVar, zzto zztoVar, zzcw zzcwVar2, zzto zztoVar2, long j4, boolean z3) throws zzih {
        Object obj;
        zzch zzchVar;
        if (!zzai(zzcwVar, zztoVar)) {
            if (zztoVar.zzb()) {
                zzchVar = zzch.zza;
            } else {
                zzchVar = this.zzu.zzn;
            }
            if (!this.zzn.zzc().equals(zzchVar)) {
                zzS(zzchVar);
                zzH(this.zzu.zzn, zzchVar.zzc, false, false);
                return;
            }
            return;
        }
        zzcwVar.zze(zzcwVar.zzn(zztoVar.zza, this.zzl).zzd, this.zzk, 0L);
        zzic zzicVar = this.zzO;
        zzbf zzbfVar = this.zzk.zzk;
        int i4 = zzfj.zza;
        zzicVar.zzd(zzbfVar);
        if (j4 != -9223372036854775807L) {
            this.zzO.zze(zzs(zzcwVar, zztoVar.zza, j4));
            return;
        }
        Object obj2 = this.zzk.zzc;
        if (!zzcwVar2.zzo()) {
            obj = zzcwVar2.zze(zzcwVar2.zzn(zztoVar2.zza, this.zzl).zzd, this.zzk, 0L).zzc;
        } else {
            obj = null;
        }
        if (zzfj.zzC(obj, obj2) && !z3) {
            return;
        }
        this.zzO.zze(-9223372036854775807L);
    }

    private final synchronized void zzac(zzfpx zzfpxVar, long j4) {
        long elapsedRealtime = SystemClock.elapsedRealtime() + j4;
        boolean z3 = false;
        while (!Boolean.valueOf(((zzjy) zzfpxVar).zza.zzw).booleanValue() && j4 > 0) {
            try {
                wait(j4);
            } catch (InterruptedException unused) {
                z3 = true;
            }
            j4 = elapsedRealtime - SystemClock.elapsedRealtime();
        }
        if (z3) {
            Thread.currentThread().interrupt();
        }
    }

    private final boolean zzad() {
        zzkm zzc = this.zzq.zzc();
        if (zzc == null || zzc.zzd() == Long.MIN_VALUE) {
            return false;
        }
        return true;
    }

    private static boolean zzae(zzli zzliVar) {
        if (zzliVar.zzbc() != 0) {
            return true;
        }
        return false;
    }

    private final boolean zzaf() {
        zzkm zzd = this.zzq.zzd();
        long j4 = zzd.zzf.zze;
        if (!zzd.zzd) {
            return false;
        }
        if (j4 != -9223372036854775807L && this.zzu.zzr >= j4 && zzah()) {
            return false;
        }
        return true;
    }

    private static boolean zzag(zzlc zzlcVar, zzct zzctVar) {
        zzto zztoVar = zzlcVar.zzb;
        zzcw zzcwVar = zzlcVar.zza;
        if (!zzcwVar.zzo() && !zzcwVar.zzn(zztoVar.zza, zzctVar).zzg) {
            return false;
        }
        return true;
    }

    private final boolean zzah() {
        zzlc zzlcVar = this.zzu;
        if (zzlcVar.zzl && zzlcVar.zzm == 0) {
            return true;
        }
        return false;
    }

    private final boolean zzai(zzcw zzcwVar, zzto zztoVar) {
        if (!zztoVar.zzb() && !zzcwVar.zzo()) {
            zzcwVar.zze(zzcwVar.zzn(zztoVar.zza, this.zzl).zzd, this.zzk, 0L);
            if (this.zzk.zzb()) {
                zzcv zzcvVar = this.zzk;
                if (zzcvVar.zzi && zzcvVar.zzf != -9223372036854775807L) {
                    return true;
                }
            }
        }
        return false;
    }

    private static zzam[] zzaj(zzxa zzxaVar) {
        int i4;
        if (zzxaVar != null) {
            i4 = zzxaVar.zzc();
        } else {
            i4 = 0;
        }
        zzam[] zzamVarArr = new zzam[i4];
        for (int i5 = 0; i5 < i4; i5++) {
            zzamVarArr[i5] = zzxaVar.zzd(i5);
        }
        return zzamVarArr;
    }

    private static final void zzak(zzlf zzlfVar) throws zzih {
        zzlfVar.zzj();
        try {
            zzlfVar.zzc().zzq(zzlfVar.zza(), zzlfVar.zzg());
        } finally {
            zzlfVar.zzh(true);
        }
    }

    private static final void zzal(zzli zzliVar) {
        if (zzliVar.zzbc() == 2) {
            zzliVar.zzI();
        }
    }

    private static final void zzam(zzli zzliVar, long j4) {
        zzliVar.zzE();
        if (!(zzliVar instanceof zzvr)) {
            return;
        }
        zzvr zzvrVar = (zzvr) zzliVar;
        throw null;
    }

    @Nullable
    static Object zze(zzcv zzcvVar, zzct zzctVar, int i4, boolean z3, Object obj, zzcw zzcwVar, zzcw zzcwVar2) {
        int zza = zzcwVar.zza(obj);
        int zzb = zzcwVar.zzb();
        int i5 = 0;
        int i6 = zza;
        int i7 = -1;
        while (true) {
            if (i5 >= zzb || i7 != -1) {
                break;
            }
            i6 = zzcwVar.zzi(i6, zzctVar, zzcvVar, i4, z3);
            if (i6 == -1) {
                i7 = -1;
                break;
            }
            i7 = zzcwVar2.zza(zzcwVar.zzf(i6));
            i5++;
        }
        if (i7 == -1) {
            return null;
        }
        return zzcwVar2.zzf(i7);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void zzr(zzlf zzlfVar) {
        try {
            zzak(zzlfVar);
        } catch (zzih e4) {
            zzer.zzd("ExoPlayerImplInternal", "Unexpected error delivering message on external thread.", e4);
            throw new RuntimeException(e4);
        }
    }

    private final long zzs(zzcw zzcwVar, Object obj, long j4) {
        long elapsedRealtime;
        zzcwVar.zze(zzcwVar.zzn(obj, this.zzl).zzd, this.zzk, 0L);
        zzcv zzcvVar = this.zzk;
        if (zzcvVar.zzf != -9223372036854775807L && zzcvVar.zzb()) {
            zzcv zzcvVar2 = this.zzk;
            if (zzcvVar2.zzi) {
                long j5 = zzcvVar2.zzg;
                if (j5 == -9223372036854775807L) {
                    elapsedRealtime = System.currentTimeMillis();
                } else {
                    elapsedRealtime = j5 + SystemClock.elapsedRealtime();
                }
                return zzfj.zzo(elapsedRealtime - this.zzk.zzf) - j4;
            }
        }
        return -9223372036854775807L;
    }

    private final long zzt() {
        return zzu(this.zzu.zzp);
    }

    private final long zzu(long j4) {
        zzkm zzc = this.zzq.zzc();
        if (zzc == null) {
            return 0L;
        }
        return Math.max(0L, j4 - (this.zzI - zzc.zze()));
    }

    private final long zzv(zzto zztoVar, long j4, boolean z3) throws zzih {
        boolean z4;
        if (this.zzq.zzd() != this.zzq.zze()) {
            z4 = true;
        } else {
            z4 = false;
        }
        return zzw(zztoVar, j4, z4, z3);
    }

    private final long zzw(zzto zztoVar, long j4, boolean z3, boolean z4) throws zzih {
        zzX();
        this.zzz = false;
        if (z4 || this.zzu.zze == 3) {
            zzU(2);
        }
        zzkm zzd = this.zzq.zzd();
        zzkm zzkmVar = zzd;
        while (zzkmVar != null && !zztoVar.equals(zzkmVar.zzf.zza)) {
            zzkmVar = zzkmVar.zzg();
        }
        if (z3 || zzd != zzkmVar || (zzkmVar != null && zzkmVar.zze() + j4 < 0)) {
            zzli[] zzliVarArr = this.zza;
            int length = zzliVarArr.length;
            for (int i4 = 0; i4 < 2; i4++) {
                zzA(zzliVarArr[i4]);
            }
            if (zzkmVar != null) {
                while (this.zzq.zzd() != zzkmVar) {
                    this.zzq.zza();
                }
                this.zzq.zzm(zzkmVar);
                zzkmVar.zzp(1000000000000L);
                zzB();
            }
        }
        if (zzkmVar != null) {
            this.zzq.zzm(zzkmVar);
            if (!zzkmVar.zzd) {
                zzkmVar.zzf = zzkmVar.zzf.zzb(j4);
            } else if (zzkmVar.zze) {
                j4 = zzkmVar.zza.zze(j4);
                zzkmVar.zza.zzj(j4 - this.zzm, false);
            }
            zzO(j4);
            zzI();
        } else {
            this.zzq.zzi();
            zzO(j4);
        }
        zzE(false);
        this.zzh.zzi(2);
        return j4;
    }

    private final Pair zzx(zzcw zzcwVar) {
        long j4 = 0;
        if (zzcwVar.zzo()) {
            return Pair.create(zzlc.zzj(), 0L);
        }
        Pair zzl = zzcwVar.zzl(this.zzk, this.zzl, zzcwVar.zzg(this.zzC), -9223372036854775807L);
        zzto zzh = this.zzq.zzh(zzcwVar, zzl.first, 0L);
        long longValue = ((Long) zzl.second).longValue();
        if (zzh.zzb()) {
            zzcwVar.zzn(zzh.zza, this.zzl);
            if (zzh.zzc == this.zzl.zze(zzh.zzb)) {
                this.zzl.zzj();
            }
        } else {
            j4 = longValue;
        }
        return Pair.create(zzh, Long.valueOf(j4));
    }

    @Nullable
    private static Pair zzy(zzcw zzcwVar, zzkg zzkgVar, boolean z3, int i4, boolean z4, zzcv zzcvVar, zzct zzctVar) {
        zzcw zzcwVar2;
        Pair zzl;
        zzcw zzcwVar3 = zzkgVar.zza;
        if (zzcwVar.zzo()) {
            return null;
        }
        if (true == zzcwVar3.zzo()) {
            zzcwVar2 = zzcwVar;
        } else {
            zzcwVar2 = zzcwVar3;
        }
        try {
            zzl = zzcwVar2.zzl(zzcvVar, zzctVar, zzkgVar.zzb, zzkgVar.zzc);
        } catch (IndexOutOfBoundsException unused) {
        }
        if (zzcwVar.equals(zzcwVar2)) {
            return zzl;
        }
        if (zzcwVar.zza(zzl.first) != -1) {
            if (zzcwVar2.zzn(zzl.first, zzctVar).zzg && zzcwVar2.zze(zzctVar.zzd, zzcvVar, 0L).zzo == zzcwVar2.zza(zzl.first)) {
                return zzcwVar.zzl(zzcvVar, zzctVar, zzcwVar.zzn(zzl.first, zzctVar).zzd, zzkgVar.zzc);
            }
            return zzl;
        }
        Object zze = zze(zzcvVar, zzctVar, i4, z4, zzl.first, zzcwVar2, zzcwVar);
        if (zze != null) {
            return zzcwVar.zzl(zzcvVar, zzctVar, zzcwVar.zzn(zze, zzctVar).zzd, -9223372036854775807L);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00bd  */
    @androidx.annotation.CheckResult
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final com.google.android.gms.internal.ads.zzlc zzz(com.google.android.gms.internal.ads.zzto r17, long r18, long r20, long r22, boolean r24, int r25) {
        /*
            Method dump skipped, instructions count: 216
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzkh.zzz(com.google.android.gms.internal.ads.zzto, long, long, long, boolean, int):com.google.android.gms.internal.ads.zzlc");
    }

    /* JADX WARN: Code restructure failed: missing block: B:404:0x07c7, code lost:
        if (zzaf() != false) goto L539;
     */
    /* JADX WARN: Code restructure failed: missing block: B:440:0x0868, code lost:
        if (r3 == false) goto L522;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:285:0x05e4 A[Catch: RuntimeException -> 0x09fd, IOException -> 0x0a28, zzsq -> 0x0a30, zzgf -> 0x0a38, zzcd -> 0x0a40, zzqm -> 0x0a57, zzih -> 0x0a61, TryCatch #9 {zzcd -> 0x0a40, zzgf -> 0x0a38, zzih -> 0x0a61, zzqm -> 0x0a57, zzsq -> 0x0a30, IOException -> 0x0a28, RuntimeException -> 0x09fd, blocks: (B:3:0x0006, B:4:0x0011, B:7:0x0016, B:8:0x001b, B:9:0x0020, B:13:0x0027, B:15:0x002b, B:17:0x002f, B:19:0x0035, B:20:0x003c, B:24:0x0043, B:26:0x004c, B:28:0x005a, B:29:0x0062, B:30:0x006d, B:31:0x0081, B:32:0x0099, B:33:0x00af, B:35:0x00be, B:36:0x00c2, B:37:0x00d3, B:39:0x00e2, B:40:0x00fe, B:41:0x0111, B:42:0x011a, B:44:0x012c, B:45:0x0138, B:46:0x0148, B:48:0x0154, B:51:0x015f, B:52:0x0166, B:53:0x0173, B:57:0x017a, B:59:0x0182, B:61:0x0186, B:63:0x018c, B:65:0x0194, B:67:0x019c, B:68:0x019f, B:70:0x01a4, B:77:0x01b1, B:78:0x01b2, B:82:0x01b9, B:84:0x01c7, B:85:0x01ca, B:86:0x01cf, B:88:0x01df, B:89:0x01e2, B:90:0x01e7, B:91:0x01ec, B:93:0x01f8, B:94:0x0204, B:96:0x0210, B:98:0x023c, B:99:0x025c, B:100:0x0261, B:101:0x0265, B:103:0x026a, B:104:0x027b, B:106:0x0287, B:107:0x028a, B:114:0x0295, B:115:0x0296, B:116:0x029b, B:117:0x02a3, B:118:0x02b5, B:120:0x02dc, B:186:0x03f3, B:170:0x03c0, B:169:0x03bc, B:195:0x0404, B:196:0x0411, B:121:0x02fe, B:125:0x0311, B:127:0x0321, B:129:0x0338, B:131:0x0342, B:197:0x0412, B:199:0x0426, B:202:0x0430, B:204:0x043f, B:206:0x044b, B:208:0x047a, B:209:0x047f, B:210:0x0483, B:212:0x0487, B:214:0x0494, B:283:0x05dc, B:285:0x05e4, B:287:0x05ec, B:290:0x05f1, B:291:0x05fd, B:293:0x0603, B:295:0x060b, B:298:0x061b, B:300:0x0621, B:301:0x063b, B:303:0x0641, B:305:0x0646, B:307:0x064b, B:309:0x064f, B:311:0x0655, B:313:0x0659, B:315:0x0661, B:317:0x0667, B:319:0x0671, B:322:0x0677, B:323:0x067a, B:325:0x0683, B:327:0x0695, B:329:0x069e, B:331:0x06a6, B:336:0x06b0, B:217:0x04a3, B:219:0x04a9, B:222:0x04af, B:225:0x04ba, B:227:0x04bf, B:230:0x04cd, B:232:0x04d3, B:233:0x04db, B:234:0x04de, B:236:0x04e6, B:238:0x04f4, B:240:0x0530, B:242:0x053a, B:245:0x0545, B:247:0x054d, B:248:0x0550, B:250:0x0554, B:252:0x055a, B:254:0x0566, B:256:0x0570, B:258:0x0581, B:260:0x0587, B:261:0x0592, B:262:0x0597, B:264:0x05a2, B:267:0x05a7, B:269:0x05ad, B:271:0x05b5, B:273:0x05bb, B:275:0x05c1, B:279:0x05cf, B:281:0x05d6, B:282:0x05d9, B:213:0x0491, B:338:0x06da, B:342:0x06e5, B:344:0x06ef, B:345:0x06f4, B:347:0x0704, B:348:0x071a, B:350:0x0720, B:352:0x0728, B:354:0x072f, B:358:0x0738, B:363:0x0747, B:369:0x0754, B:371:0x075a, B:381:0x076d, B:382:0x0770, B:384:0x077c, B:386:0x0782, B:390:0x078f, B:392:0x0797, B:394:0x079b, B:395:0x07a6, B:397:0x07ac, B:451:0x089c, B:454:0x08a4, B:456:0x08a9, B:458:0x08b1, B:460:0x08bf, B:461:0x08c6, B:462:0x08ca, B:464:0x08d0, B:466:0x08d9, B:468:0x08df, B:470:0x08ea, B:477:0x090e, B:479:0x0914, B:483:0x091d, B:485:0x0921, B:490:0x092a, B:492:0x0930, B:494:0x0990, B:496:0x0995, B:505:0x09a6, B:507:0x09aa, B:508:0x09b2, B:509:0x09b9, B:471:0x08f1, B:474:0x08ff, B:475:0x0906, B:476:0x0907, B:398:0x07b5, B:433:0x0857, B:435:0x085d, B:437:0x0861, B:441:0x086a, B:443:0x0878, B:445:0x0880, B:447:0x088a, B:448:0x088f, B:449:0x0894, B:450:0x0899, B:401:0x07bf, B:403:0x07c3, B:430:0x0847, B:432:0x0853, B:407:0x07ce, B:409:0x07d2, B:411:0x07e6, B:413:0x07f4, B:415:0x0800, B:419:0x0809, B:421:0x0813, B:427:0x081e, B:383:0x0775, B:510:0x09be, B:514:0x09c5, B:515:0x09cd, B:519:0x09eb), top: B:589:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:293:0x0603 A[Catch: RuntimeException -> 0x09fd, IOException -> 0x0a28, zzsq -> 0x0a30, zzgf -> 0x0a38, zzcd -> 0x0a40, zzqm -> 0x0a57, zzih -> 0x0a61, TryCatch #9 {zzcd -> 0x0a40, zzgf -> 0x0a38, zzih -> 0x0a61, zzqm -> 0x0a57, zzsq -> 0x0a30, IOException -> 0x0a28, RuntimeException -> 0x09fd, blocks: (B:3:0x0006, B:4:0x0011, B:7:0x0016, B:8:0x001b, B:9:0x0020, B:13:0x0027, B:15:0x002b, B:17:0x002f, B:19:0x0035, B:20:0x003c, B:24:0x0043, B:26:0x004c, B:28:0x005a, B:29:0x0062, B:30:0x006d, B:31:0x0081, B:32:0x0099, B:33:0x00af, B:35:0x00be, B:36:0x00c2, B:37:0x00d3, B:39:0x00e2, B:40:0x00fe, B:41:0x0111, B:42:0x011a, B:44:0x012c, B:45:0x0138, B:46:0x0148, B:48:0x0154, B:51:0x015f, B:52:0x0166, B:53:0x0173, B:57:0x017a, B:59:0x0182, B:61:0x0186, B:63:0x018c, B:65:0x0194, B:67:0x019c, B:68:0x019f, B:70:0x01a4, B:77:0x01b1, B:78:0x01b2, B:82:0x01b9, B:84:0x01c7, B:85:0x01ca, B:86:0x01cf, B:88:0x01df, B:89:0x01e2, B:90:0x01e7, B:91:0x01ec, B:93:0x01f8, B:94:0x0204, B:96:0x0210, B:98:0x023c, B:99:0x025c, B:100:0x0261, B:101:0x0265, B:103:0x026a, B:104:0x027b, B:106:0x0287, B:107:0x028a, B:114:0x0295, B:115:0x0296, B:116:0x029b, B:117:0x02a3, B:118:0x02b5, B:120:0x02dc, B:186:0x03f3, B:170:0x03c0, B:169:0x03bc, B:195:0x0404, B:196:0x0411, B:121:0x02fe, B:125:0x0311, B:127:0x0321, B:129:0x0338, B:131:0x0342, B:197:0x0412, B:199:0x0426, B:202:0x0430, B:204:0x043f, B:206:0x044b, B:208:0x047a, B:209:0x047f, B:210:0x0483, B:212:0x0487, B:214:0x0494, B:283:0x05dc, B:285:0x05e4, B:287:0x05ec, B:290:0x05f1, B:291:0x05fd, B:293:0x0603, B:295:0x060b, B:298:0x061b, B:300:0x0621, B:301:0x063b, B:303:0x0641, B:305:0x0646, B:307:0x064b, B:309:0x064f, B:311:0x0655, B:313:0x0659, B:315:0x0661, B:317:0x0667, B:319:0x0671, B:322:0x0677, B:323:0x067a, B:325:0x0683, B:327:0x0695, B:329:0x069e, B:331:0x06a6, B:336:0x06b0, B:217:0x04a3, B:219:0x04a9, B:222:0x04af, B:225:0x04ba, B:227:0x04bf, B:230:0x04cd, B:232:0x04d3, B:233:0x04db, B:234:0x04de, B:236:0x04e6, B:238:0x04f4, B:240:0x0530, B:242:0x053a, B:245:0x0545, B:247:0x054d, B:248:0x0550, B:250:0x0554, B:252:0x055a, B:254:0x0566, B:256:0x0570, B:258:0x0581, B:260:0x0587, B:261:0x0592, B:262:0x0597, B:264:0x05a2, B:267:0x05a7, B:269:0x05ad, B:271:0x05b5, B:273:0x05bb, B:275:0x05c1, B:279:0x05cf, B:281:0x05d6, B:282:0x05d9, B:213:0x0491, B:338:0x06da, B:342:0x06e5, B:344:0x06ef, B:345:0x06f4, B:347:0x0704, B:348:0x071a, B:350:0x0720, B:352:0x0728, B:354:0x072f, B:358:0x0738, B:363:0x0747, B:369:0x0754, B:371:0x075a, B:381:0x076d, B:382:0x0770, B:384:0x077c, B:386:0x0782, B:390:0x078f, B:392:0x0797, B:394:0x079b, B:395:0x07a6, B:397:0x07ac, B:451:0x089c, B:454:0x08a4, B:456:0x08a9, B:458:0x08b1, B:460:0x08bf, B:461:0x08c6, B:462:0x08ca, B:464:0x08d0, B:466:0x08d9, B:468:0x08df, B:470:0x08ea, B:477:0x090e, B:479:0x0914, B:483:0x091d, B:485:0x0921, B:490:0x092a, B:492:0x0930, B:494:0x0990, B:496:0x0995, B:505:0x09a6, B:507:0x09aa, B:508:0x09b2, B:509:0x09b9, B:471:0x08f1, B:474:0x08ff, B:475:0x0906, B:476:0x0907, B:398:0x07b5, B:433:0x0857, B:435:0x085d, B:437:0x0861, B:441:0x086a, B:443:0x0878, B:445:0x0880, B:447:0x088a, B:448:0x088f, B:449:0x0894, B:450:0x0899, B:401:0x07bf, B:403:0x07c3, B:430:0x0847, B:432:0x0853, B:407:0x07ce, B:409:0x07d2, B:411:0x07e6, B:413:0x07f4, B:415:0x0800, B:419:0x0809, B:421:0x0813, B:427:0x081e, B:383:0x0775, B:510:0x09be, B:514:0x09c5, B:515:0x09cd, B:519:0x09eb), top: B:589:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:311:0x0655 A[Catch: RuntimeException -> 0x09fd, IOException -> 0x0a28, zzsq -> 0x0a30, zzgf -> 0x0a38, zzcd -> 0x0a40, zzqm -> 0x0a57, zzih -> 0x0a61, TryCatch #9 {zzcd -> 0x0a40, zzgf -> 0x0a38, zzih -> 0x0a61, zzqm -> 0x0a57, zzsq -> 0x0a30, IOException -> 0x0a28, RuntimeException -> 0x09fd, blocks: (B:3:0x0006, B:4:0x0011, B:7:0x0016, B:8:0x001b, B:9:0x0020, B:13:0x0027, B:15:0x002b, B:17:0x002f, B:19:0x0035, B:20:0x003c, B:24:0x0043, B:26:0x004c, B:28:0x005a, B:29:0x0062, B:30:0x006d, B:31:0x0081, B:32:0x0099, B:33:0x00af, B:35:0x00be, B:36:0x00c2, B:37:0x00d3, B:39:0x00e2, B:40:0x00fe, B:41:0x0111, B:42:0x011a, B:44:0x012c, B:45:0x0138, B:46:0x0148, B:48:0x0154, B:51:0x015f, B:52:0x0166, B:53:0x0173, B:57:0x017a, B:59:0x0182, B:61:0x0186, B:63:0x018c, B:65:0x0194, B:67:0x019c, B:68:0x019f, B:70:0x01a4, B:77:0x01b1, B:78:0x01b2, B:82:0x01b9, B:84:0x01c7, B:85:0x01ca, B:86:0x01cf, B:88:0x01df, B:89:0x01e2, B:90:0x01e7, B:91:0x01ec, B:93:0x01f8, B:94:0x0204, B:96:0x0210, B:98:0x023c, B:99:0x025c, B:100:0x0261, B:101:0x0265, B:103:0x026a, B:104:0x027b, B:106:0x0287, B:107:0x028a, B:114:0x0295, B:115:0x0296, B:116:0x029b, B:117:0x02a3, B:118:0x02b5, B:120:0x02dc, B:186:0x03f3, B:170:0x03c0, B:169:0x03bc, B:195:0x0404, B:196:0x0411, B:121:0x02fe, B:125:0x0311, B:127:0x0321, B:129:0x0338, B:131:0x0342, B:197:0x0412, B:199:0x0426, B:202:0x0430, B:204:0x043f, B:206:0x044b, B:208:0x047a, B:209:0x047f, B:210:0x0483, B:212:0x0487, B:214:0x0494, B:283:0x05dc, B:285:0x05e4, B:287:0x05ec, B:290:0x05f1, B:291:0x05fd, B:293:0x0603, B:295:0x060b, B:298:0x061b, B:300:0x0621, B:301:0x063b, B:303:0x0641, B:305:0x0646, B:307:0x064b, B:309:0x064f, B:311:0x0655, B:313:0x0659, B:315:0x0661, B:317:0x0667, B:319:0x0671, B:322:0x0677, B:323:0x067a, B:325:0x0683, B:327:0x0695, B:329:0x069e, B:331:0x06a6, B:336:0x06b0, B:217:0x04a3, B:219:0x04a9, B:222:0x04af, B:225:0x04ba, B:227:0x04bf, B:230:0x04cd, B:232:0x04d3, B:233:0x04db, B:234:0x04de, B:236:0x04e6, B:238:0x04f4, B:240:0x0530, B:242:0x053a, B:245:0x0545, B:247:0x054d, B:248:0x0550, B:250:0x0554, B:252:0x055a, B:254:0x0566, B:256:0x0570, B:258:0x0581, B:260:0x0587, B:261:0x0592, B:262:0x0597, B:264:0x05a2, B:267:0x05a7, B:269:0x05ad, B:271:0x05b5, B:273:0x05bb, B:275:0x05c1, B:279:0x05cf, B:281:0x05d6, B:282:0x05d9, B:213:0x0491, B:338:0x06da, B:342:0x06e5, B:344:0x06ef, B:345:0x06f4, B:347:0x0704, B:348:0x071a, B:350:0x0720, B:352:0x0728, B:354:0x072f, B:358:0x0738, B:363:0x0747, B:369:0x0754, B:371:0x075a, B:381:0x076d, B:382:0x0770, B:384:0x077c, B:386:0x0782, B:390:0x078f, B:392:0x0797, B:394:0x079b, B:395:0x07a6, B:397:0x07ac, B:451:0x089c, B:454:0x08a4, B:456:0x08a9, B:458:0x08b1, B:460:0x08bf, B:461:0x08c6, B:462:0x08ca, B:464:0x08d0, B:466:0x08d9, B:468:0x08df, B:470:0x08ea, B:477:0x090e, B:479:0x0914, B:483:0x091d, B:485:0x0921, B:490:0x092a, B:492:0x0930, B:494:0x0990, B:496:0x0995, B:505:0x09a6, B:507:0x09aa, B:508:0x09b2, B:509:0x09b9, B:471:0x08f1, B:474:0x08ff, B:475:0x0906, B:476:0x0907, B:398:0x07b5, B:433:0x0857, B:435:0x085d, B:437:0x0861, B:441:0x086a, B:443:0x0878, B:445:0x0880, B:447:0x088a, B:448:0x088f, B:449:0x0894, B:450:0x0899, B:401:0x07bf, B:403:0x07c3, B:430:0x0847, B:432:0x0853, B:407:0x07ce, B:409:0x07d2, B:411:0x07e6, B:413:0x07f4, B:415:0x0800, B:419:0x0809, B:421:0x0813, B:427:0x081e, B:383:0x0775, B:510:0x09be, B:514:0x09c5, B:515:0x09cd, B:519:0x09eb), top: B:589:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:322:0x0677 A[Catch: RuntimeException -> 0x09fd, IOException -> 0x0a28, zzsq -> 0x0a30, zzgf -> 0x0a38, zzcd -> 0x0a40, zzqm -> 0x0a57, zzih -> 0x0a61, TryCatch #9 {zzcd -> 0x0a40, zzgf -> 0x0a38, zzih -> 0x0a61, zzqm -> 0x0a57, zzsq -> 0x0a30, IOException -> 0x0a28, RuntimeException -> 0x09fd, blocks: (B:3:0x0006, B:4:0x0011, B:7:0x0016, B:8:0x001b, B:9:0x0020, B:13:0x0027, B:15:0x002b, B:17:0x002f, B:19:0x0035, B:20:0x003c, B:24:0x0043, B:26:0x004c, B:28:0x005a, B:29:0x0062, B:30:0x006d, B:31:0x0081, B:32:0x0099, B:33:0x00af, B:35:0x00be, B:36:0x00c2, B:37:0x00d3, B:39:0x00e2, B:40:0x00fe, B:41:0x0111, B:42:0x011a, B:44:0x012c, B:45:0x0138, B:46:0x0148, B:48:0x0154, B:51:0x015f, B:52:0x0166, B:53:0x0173, B:57:0x017a, B:59:0x0182, B:61:0x0186, B:63:0x018c, B:65:0x0194, B:67:0x019c, B:68:0x019f, B:70:0x01a4, B:77:0x01b1, B:78:0x01b2, B:82:0x01b9, B:84:0x01c7, B:85:0x01ca, B:86:0x01cf, B:88:0x01df, B:89:0x01e2, B:90:0x01e7, B:91:0x01ec, B:93:0x01f8, B:94:0x0204, B:96:0x0210, B:98:0x023c, B:99:0x025c, B:100:0x0261, B:101:0x0265, B:103:0x026a, B:104:0x027b, B:106:0x0287, B:107:0x028a, B:114:0x0295, B:115:0x0296, B:116:0x029b, B:117:0x02a3, B:118:0x02b5, B:120:0x02dc, B:186:0x03f3, B:170:0x03c0, B:169:0x03bc, B:195:0x0404, B:196:0x0411, B:121:0x02fe, B:125:0x0311, B:127:0x0321, B:129:0x0338, B:131:0x0342, B:197:0x0412, B:199:0x0426, B:202:0x0430, B:204:0x043f, B:206:0x044b, B:208:0x047a, B:209:0x047f, B:210:0x0483, B:212:0x0487, B:214:0x0494, B:283:0x05dc, B:285:0x05e4, B:287:0x05ec, B:290:0x05f1, B:291:0x05fd, B:293:0x0603, B:295:0x060b, B:298:0x061b, B:300:0x0621, B:301:0x063b, B:303:0x0641, B:305:0x0646, B:307:0x064b, B:309:0x064f, B:311:0x0655, B:313:0x0659, B:315:0x0661, B:317:0x0667, B:319:0x0671, B:322:0x0677, B:323:0x067a, B:325:0x0683, B:327:0x0695, B:329:0x069e, B:331:0x06a6, B:336:0x06b0, B:217:0x04a3, B:219:0x04a9, B:222:0x04af, B:225:0x04ba, B:227:0x04bf, B:230:0x04cd, B:232:0x04d3, B:233:0x04db, B:234:0x04de, B:236:0x04e6, B:238:0x04f4, B:240:0x0530, B:242:0x053a, B:245:0x0545, B:247:0x054d, B:248:0x0550, B:250:0x0554, B:252:0x055a, B:254:0x0566, B:256:0x0570, B:258:0x0581, B:260:0x0587, B:261:0x0592, B:262:0x0597, B:264:0x05a2, B:267:0x05a7, B:269:0x05ad, B:271:0x05b5, B:273:0x05bb, B:275:0x05c1, B:279:0x05cf, B:281:0x05d6, B:282:0x05d9, B:213:0x0491, B:338:0x06da, B:342:0x06e5, B:344:0x06ef, B:345:0x06f4, B:347:0x0704, B:348:0x071a, B:350:0x0720, B:352:0x0728, B:354:0x072f, B:358:0x0738, B:363:0x0747, B:369:0x0754, B:371:0x075a, B:381:0x076d, B:382:0x0770, B:384:0x077c, B:386:0x0782, B:390:0x078f, B:392:0x0797, B:394:0x079b, B:395:0x07a6, B:397:0x07ac, B:451:0x089c, B:454:0x08a4, B:456:0x08a9, B:458:0x08b1, B:460:0x08bf, B:461:0x08c6, B:462:0x08ca, B:464:0x08d0, B:466:0x08d9, B:468:0x08df, B:470:0x08ea, B:477:0x090e, B:479:0x0914, B:483:0x091d, B:485:0x0921, B:490:0x092a, B:492:0x0930, B:494:0x0990, B:496:0x0995, B:505:0x09a6, B:507:0x09aa, B:508:0x09b2, B:509:0x09b9, B:471:0x08f1, B:474:0x08ff, B:475:0x0906, B:476:0x0907, B:398:0x07b5, B:433:0x0857, B:435:0x085d, B:437:0x0861, B:441:0x086a, B:443:0x0878, B:445:0x0880, B:447:0x088a, B:448:0x088f, B:449:0x0894, B:450:0x0899, B:401:0x07bf, B:403:0x07c3, B:430:0x0847, B:432:0x0853, B:407:0x07ce, B:409:0x07d2, B:411:0x07e6, B:413:0x07f4, B:415:0x0800, B:419:0x0809, B:421:0x0813, B:427:0x081e, B:383:0x0775, B:510:0x09be, B:514:0x09c5, B:515:0x09cd, B:519:0x09eb), top: B:589:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:327:0x0695 A[Catch: RuntimeException -> 0x09fd, IOException -> 0x0a28, zzsq -> 0x0a30, zzgf -> 0x0a38, zzcd -> 0x0a40, zzqm -> 0x0a57, zzih -> 0x0a61, TryCatch #9 {zzcd -> 0x0a40, zzgf -> 0x0a38, zzih -> 0x0a61, zzqm -> 0x0a57, zzsq -> 0x0a30, IOException -> 0x0a28, RuntimeException -> 0x09fd, blocks: (B:3:0x0006, B:4:0x0011, B:7:0x0016, B:8:0x001b, B:9:0x0020, B:13:0x0027, B:15:0x002b, B:17:0x002f, B:19:0x0035, B:20:0x003c, B:24:0x0043, B:26:0x004c, B:28:0x005a, B:29:0x0062, B:30:0x006d, B:31:0x0081, B:32:0x0099, B:33:0x00af, B:35:0x00be, B:36:0x00c2, B:37:0x00d3, B:39:0x00e2, B:40:0x00fe, B:41:0x0111, B:42:0x011a, B:44:0x012c, B:45:0x0138, B:46:0x0148, B:48:0x0154, B:51:0x015f, B:52:0x0166, B:53:0x0173, B:57:0x017a, B:59:0x0182, B:61:0x0186, B:63:0x018c, B:65:0x0194, B:67:0x019c, B:68:0x019f, B:70:0x01a4, B:77:0x01b1, B:78:0x01b2, B:82:0x01b9, B:84:0x01c7, B:85:0x01ca, B:86:0x01cf, B:88:0x01df, B:89:0x01e2, B:90:0x01e7, B:91:0x01ec, B:93:0x01f8, B:94:0x0204, B:96:0x0210, B:98:0x023c, B:99:0x025c, B:100:0x0261, B:101:0x0265, B:103:0x026a, B:104:0x027b, B:106:0x0287, B:107:0x028a, B:114:0x0295, B:115:0x0296, B:116:0x029b, B:117:0x02a3, B:118:0x02b5, B:120:0x02dc, B:186:0x03f3, B:170:0x03c0, B:169:0x03bc, B:195:0x0404, B:196:0x0411, B:121:0x02fe, B:125:0x0311, B:127:0x0321, B:129:0x0338, B:131:0x0342, B:197:0x0412, B:199:0x0426, B:202:0x0430, B:204:0x043f, B:206:0x044b, B:208:0x047a, B:209:0x047f, B:210:0x0483, B:212:0x0487, B:214:0x0494, B:283:0x05dc, B:285:0x05e4, B:287:0x05ec, B:290:0x05f1, B:291:0x05fd, B:293:0x0603, B:295:0x060b, B:298:0x061b, B:300:0x0621, B:301:0x063b, B:303:0x0641, B:305:0x0646, B:307:0x064b, B:309:0x064f, B:311:0x0655, B:313:0x0659, B:315:0x0661, B:317:0x0667, B:319:0x0671, B:322:0x0677, B:323:0x067a, B:325:0x0683, B:327:0x0695, B:329:0x069e, B:331:0x06a6, B:336:0x06b0, B:217:0x04a3, B:219:0x04a9, B:222:0x04af, B:225:0x04ba, B:227:0x04bf, B:230:0x04cd, B:232:0x04d3, B:233:0x04db, B:234:0x04de, B:236:0x04e6, B:238:0x04f4, B:240:0x0530, B:242:0x053a, B:245:0x0545, B:247:0x054d, B:248:0x0550, B:250:0x0554, B:252:0x055a, B:254:0x0566, B:256:0x0570, B:258:0x0581, B:260:0x0587, B:261:0x0592, B:262:0x0597, B:264:0x05a2, B:267:0x05a7, B:269:0x05ad, B:271:0x05b5, B:273:0x05bb, B:275:0x05c1, B:279:0x05cf, B:281:0x05d6, B:282:0x05d9, B:213:0x0491, B:338:0x06da, B:342:0x06e5, B:344:0x06ef, B:345:0x06f4, B:347:0x0704, B:348:0x071a, B:350:0x0720, B:352:0x0728, B:354:0x072f, B:358:0x0738, B:363:0x0747, B:369:0x0754, B:371:0x075a, B:381:0x076d, B:382:0x0770, B:384:0x077c, B:386:0x0782, B:390:0x078f, B:392:0x0797, B:394:0x079b, B:395:0x07a6, B:397:0x07ac, B:451:0x089c, B:454:0x08a4, B:456:0x08a9, B:458:0x08b1, B:460:0x08bf, B:461:0x08c6, B:462:0x08ca, B:464:0x08d0, B:466:0x08d9, B:468:0x08df, B:470:0x08ea, B:477:0x090e, B:479:0x0914, B:483:0x091d, B:485:0x0921, B:490:0x092a, B:492:0x0930, B:494:0x0990, B:496:0x0995, B:505:0x09a6, B:507:0x09aa, B:508:0x09b2, B:509:0x09b9, B:471:0x08f1, B:474:0x08ff, B:475:0x0906, B:476:0x0907, B:398:0x07b5, B:433:0x0857, B:435:0x085d, B:437:0x0861, B:441:0x086a, B:443:0x0878, B:445:0x0880, B:447:0x088a, B:448:0x088f, B:449:0x0894, B:450:0x0899, B:401:0x07bf, B:403:0x07c3, B:430:0x0847, B:432:0x0853, B:407:0x07ce, B:409:0x07d2, B:411:0x07e6, B:413:0x07f4, B:415:0x0800, B:419:0x0809, B:421:0x0813, B:427:0x081e, B:383:0x0775, B:510:0x09be, B:514:0x09c5, B:515:0x09cd, B:519:0x09eb), top: B:589:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:334:0x06ae  */
    /* JADX WARN: Removed duplicated region for block: B:381:0x076d A[Catch: RuntimeException -> 0x09fd, IOException -> 0x0a28, zzsq -> 0x0a30, zzgf -> 0x0a38, zzcd -> 0x0a40, zzqm -> 0x0a57, zzih -> 0x0a61, TryCatch #9 {zzcd -> 0x0a40, zzgf -> 0x0a38, zzih -> 0x0a61, zzqm -> 0x0a57, zzsq -> 0x0a30, IOException -> 0x0a28, RuntimeException -> 0x09fd, blocks: (B:3:0x0006, B:4:0x0011, B:7:0x0016, B:8:0x001b, B:9:0x0020, B:13:0x0027, B:15:0x002b, B:17:0x002f, B:19:0x0035, B:20:0x003c, B:24:0x0043, B:26:0x004c, B:28:0x005a, B:29:0x0062, B:30:0x006d, B:31:0x0081, B:32:0x0099, B:33:0x00af, B:35:0x00be, B:36:0x00c2, B:37:0x00d3, B:39:0x00e2, B:40:0x00fe, B:41:0x0111, B:42:0x011a, B:44:0x012c, B:45:0x0138, B:46:0x0148, B:48:0x0154, B:51:0x015f, B:52:0x0166, B:53:0x0173, B:57:0x017a, B:59:0x0182, B:61:0x0186, B:63:0x018c, B:65:0x0194, B:67:0x019c, B:68:0x019f, B:70:0x01a4, B:77:0x01b1, B:78:0x01b2, B:82:0x01b9, B:84:0x01c7, B:85:0x01ca, B:86:0x01cf, B:88:0x01df, B:89:0x01e2, B:90:0x01e7, B:91:0x01ec, B:93:0x01f8, B:94:0x0204, B:96:0x0210, B:98:0x023c, B:99:0x025c, B:100:0x0261, B:101:0x0265, B:103:0x026a, B:104:0x027b, B:106:0x0287, B:107:0x028a, B:114:0x0295, B:115:0x0296, B:116:0x029b, B:117:0x02a3, B:118:0x02b5, B:120:0x02dc, B:186:0x03f3, B:170:0x03c0, B:169:0x03bc, B:195:0x0404, B:196:0x0411, B:121:0x02fe, B:125:0x0311, B:127:0x0321, B:129:0x0338, B:131:0x0342, B:197:0x0412, B:199:0x0426, B:202:0x0430, B:204:0x043f, B:206:0x044b, B:208:0x047a, B:209:0x047f, B:210:0x0483, B:212:0x0487, B:214:0x0494, B:283:0x05dc, B:285:0x05e4, B:287:0x05ec, B:290:0x05f1, B:291:0x05fd, B:293:0x0603, B:295:0x060b, B:298:0x061b, B:300:0x0621, B:301:0x063b, B:303:0x0641, B:305:0x0646, B:307:0x064b, B:309:0x064f, B:311:0x0655, B:313:0x0659, B:315:0x0661, B:317:0x0667, B:319:0x0671, B:322:0x0677, B:323:0x067a, B:325:0x0683, B:327:0x0695, B:329:0x069e, B:331:0x06a6, B:336:0x06b0, B:217:0x04a3, B:219:0x04a9, B:222:0x04af, B:225:0x04ba, B:227:0x04bf, B:230:0x04cd, B:232:0x04d3, B:233:0x04db, B:234:0x04de, B:236:0x04e6, B:238:0x04f4, B:240:0x0530, B:242:0x053a, B:245:0x0545, B:247:0x054d, B:248:0x0550, B:250:0x0554, B:252:0x055a, B:254:0x0566, B:256:0x0570, B:258:0x0581, B:260:0x0587, B:261:0x0592, B:262:0x0597, B:264:0x05a2, B:267:0x05a7, B:269:0x05ad, B:271:0x05b5, B:273:0x05bb, B:275:0x05c1, B:279:0x05cf, B:281:0x05d6, B:282:0x05d9, B:213:0x0491, B:338:0x06da, B:342:0x06e5, B:344:0x06ef, B:345:0x06f4, B:347:0x0704, B:348:0x071a, B:350:0x0720, B:352:0x0728, B:354:0x072f, B:358:0x0738, B:363:0x0747, B:369:0x0754, B:371:0x075a, B:381:0x076d, B:382:0x0770, B:384:0x077c, B:386:0x0782, B:390:0x078f, B:392:0x0797, B:394:0x079b, B:395:0x07a6, B:397:0x07ac, B:451:0x089c, B:454:0x08a4, B:456:0x08a9, B:458:0x08b1, B:460:0x08bf, B:461:0x08c6, B:462:0x08ca, B:464:0x08d0, B:466:0x08d9, B:468:0x08df, B:470:0x08ea, B:477:0x090e, B:479:0x0914, B:483:0x091d, B:485:0x0921, B:490:0x092a, B:492:0x0930, B:494:0x0990, B:496:0x0995, B:505:0x09a6, B:507:0x09aa, B:508:0x09b2, B:509:0x09b9, B:471:0x08f1, B:474:0x08ff, B:475:0x0906, B:476:0x0907, B:398:0x07b5, B:433:0x0857, B:435:0x085d, B:437:0x0861, B:441:0x086a, B:443:0x0878, B:445:0x0880, B:447:0x088a, B:448:0x088f, B:449:0x0894, B:450:0x0899, B:401:0x07bf, B:403:0x07c3, B:430:0x0847, B:432:0x0853, B:407:0x07ce, B:409:0x07d2, B:411:0x07e6, B:413:0x07f4, B:415:0x0800, B:419:0x0809, B:421:0x0813, B:427:0x081e, B:383:0x0775, B:510:0x09be, B:514:0x09c5, B:515:0x09cd, B:519:0x09eb), top: B:589:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:453:0x08a3  */
    /* JADX WARN: Removed duplicated region for block: B:479:0x0914 A[Catch: RuntimeException -> 0x09fd, IOException -> 0x0a28, zzsq -> 0x0a30, zzgf -> 0x0a38, zzcd -> 0x0a40, zzqm -> 0x0a57, zzih -> 0x0a61, TryCatch #9 {zzcd -> 0x0a40, zzgf -> 0x0a38, zzih -> 0x0a61, zzqm -> 0x0a57, zzsq -> 0x0a30, IOException -> 0x0a28, RuntimeException -> 0x09fd, blocks: (B:3:0x0006, B:4:0x0011, B:7:0x0016, B:8:0x001b, B:9:0x0020, B:13:0x0027, B:15:0x002b, B:17:0x002f, B:19:0x0035, B:20:0x003c, B:24:0x0043, B:26:0x004c, B:28:0x005a, B:29:0x0062, B:30:0x006d, B:31:0x0081, B:32:0x0099, B:33:0x00af, B:35:0x00be, B:36:0x00c2, B:37:0x00d3, B:39:0x00e2, B:40:0x00fe, B:41:0x0111, B:42:0x011a, B:44:0x012c, B:45:0x0138, B:46:0x0148, B:48:0x0154, B:51:0x015f, B:52:0x0166, B:53:0x0173, B:57:0x017a, B:59:0x0182, B:61:0x0186, B:63:0x018c, B:65:0x0194, B:67:0x019c, B:68:0x019f, B:70:0x01a4, B:77:0x01b1, B:78:0x01b2, B:82:0x01b9, B:84:0x01c7, B:85:0x01ca, B:86:0x01cf, B:88:0x01df, B:89:0x01e2, B:90:0x01e7, B:91:0x01ec, B:93:0x01f8, B:94:0x0204, B:96:0x0210, B:98:0x023c, B:99:0x025c, B:100:0x0261, B:101:0x0265, B:103:0x026a, B:104:0x027b, B:106:0x0287, B:107:0x028a, B:114:0x0295, B:115:0x0296, B:116:0x029b, B:117:0x02a3, B:118:0x02b5, B:120:0x02dc, B:186:0x03f3, B:170:0x03c0, B:169:0x03bc, B:195:0x0404, B:196:0x0411, B:121:0x02fe, B:125:0x0311, B:127:0x0321, B:129:0x0338, B:131:0x0342, B:197:0x0412, B:199:0x0426, B:202:0x0430, B:204:0x043f, B:206:0x044b, B:208:0x047a, B:209:0x047f, B:210:0x0483, B:212:0x0487, B:214:0x0494, B:283:0x05dc, B:285:0x05e4, B:287:0x05ec, B:290:0x05f1, B:291:0x05fd, B:293:0x0603, B:295:0x060b, B:298:0x061b, B:300:0x0621, B:301:0x063b, B:303:0x0641, B:305:0x0646, B:307:0x064b, B:309:0x064f, B:311:0x0655, B:313:0x0659, B:315:0x0661, B:317:0x0667, B:319:0x0671, B:322:0x0677, B:323:0x067a, B:325:0x0683, B:327:0x0695, B:329:0x069e, B:331:0x06a6, B:336:0x06b0, B:217:0x04a3, B:219:0x04a9, B:222:0x04af, B:225:0x04ba, B:227:0x04bf, B:230:0x04cd, B:232:0x04d3, B:233:0x04db, B:234:0x04de, B:236:0x04e6, B:238:0x04f4, B:240:0x0530, B:242:0x053a, B:245:0x0545, B:247:0x054d, B:248:0x0550, B:250:0x0554, B:252:0x055a, B:254:0x0566, B:256:0x0570, B:258:0x0581, B:260:0x0587, B:261:0x0592, B:262:0x0597, B:264:0x05a2, B:267:0x05a7, B:269:0x05ad, B:271:0x05b5, B:273:0x05bb, B:275:0x05c1, B:279:0x05cf, B:281:0x05d6, B:282:0x05d9, B:213:0x0491, B:338:0x06da, B:342:0x06e5, B:344:0x06ef, B:345:0x06f4, B:347:0x0704, B:348:0x071a, B:350:0x0720, B:352:0x0728, B:354:0x072f, B:358:0x0738, B:363:0x0747, B:369:0x0754, B:371:0x075a, B:381:0x076d, B:382:0x0770, B:384:0x077c, B:386:0x0782, B:390:0x078f, B:392:0x0797, B:394:0x079b, B:395:0x07a6, B:397:0x07ac, B:451:0x089c, B:454:0x08a4, B:456:0x08a9, B:458:0x08b1, B:460:0x08bf, B:461:0x08c6, B:462:0x08ca, B:464:0x08d0, B:466:0x08d9, B:468:0x08df, B:470:0x08ea, B:477:0x090e, B:479:0x0914, B:483:0x091d, B:485:0x0921, B:490:0x092a, B:492:0x0930, B:494:0x0990, B:496:0x0995, B:505:0x09a6, B:507:0x09aa, B:508:0x09b2, B:509:0x09b9, B:471:0x08f1, B:474:0x08ff, B:475:0x0906, B:476:0x0907, B:398:0x07b5, B:433:0x0857, B:435:0x085d, B:437:0x0861, B:441:0x086a, B:443:0x0878, B:445:0x0880, B:447:0x088a, B:448:0x088f, B:449:0x0894, B:450:0x0899, B:401:0x07bf, B:403:0x07c3, B:430:0x0847, B:432:0x0853, B:407:0x07ce, B:409:0x07d2, B:411:0x07e6, B:413:0x07f4, B:415:0x0800, B:419:0x0809, B:421:0x0813, B:427:0x081e, B:383:0x0775, B:510:0x09be, B:514:0x09c5, B:515:0x09cd, B:519:0x09eb), top: B:589:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:485:0x0921 A[Catch: RuntimeException -> 0x09fd, IOException -> 0x0a28, zzsq -> 0x0a30, zzgf -> 0x0a38, zzcd -> 0x0a40, zzqm -> 0x0a57, zzih -> 0x0a61, TryCatch #9 {zzcd -> 0x0a40, zzgf -> 0x0a38, zzih -> 0x0a61, zzqm -> 0x0a57, zzsq -> 0x0a30, IOException -> 0x0a28, RuntimeException -> 0x09fd, blocks: (B:3:0x0006, B:4:0x0011, B:7:0x0016, B:8:0x001b, B:9:0x0020, B:13:0x0027, B:15:0x002b, B:17:0x002f, B:19:0x0035, B:20:0x003c, B:24:0x0043, B:26:0x004c, B:28:0x005a, B:29:0x0062, B:30:0x006d, B:31:0x0081, B:32:0x0099, B:33:0x00af, B:35:0x00be, B:36:0x00c2, B:37:0x00d3, B:39:0x00e2, B:40:0x00fe, B:41:0x0111, B:42:0x011a, B:44:0x012c, B:45:0x0138, B:46:0x0148, B:48:0x0154, B:51:0x015f, B:52:0x0166, B:53:0x0173, B:57:0x017a, B:59:0x0182, B:61:0x0186, B:63:0x018c, B:65:0x0194, B:67:0x019c, B:68:0x019f, B:70:0x01a4, B:77:0x01b1, B:78:0x01b2, B:82:0x01b9, B:84:0x01c7, B:85:0x01ca, B:86:0x01cf, B:88:0x01df, B:89:0x01e2, B:90:0x01e7, B:91:0x01ec, B:93:0x01f8, B:94:0x0204, B:96:0x0210, B:98:0x023c, B:99:0x025c, B:100:0x0261, B:101:0x0265, B:103:0x026a, B:104:0x027b, B:106:0x0287, B:107:0x028a, B:114:0x0295, B:115:0x0296, B:116:0x029b, B:117:0x02a3, B:118:0x02b5, B:120:0x02dc, B:186:0x03f3, B:170:0x03c0, B:169:0x03bc, B:195:0x0404, B:196:0x0411, B:121:0x02fe, B:125:0x0311, B:127:0x0321, B:129:0x0338, B:131:0x0342, B:197:0x0412, B:199:0x0426, B:202:0x0430, B:204:0x043f, B:206:0x044b, B:208:0x047a, B:209:0x047f, B:210:0x0483, B:212:0x0487, B:214:0x0494, B:283:0x05dc, B:285:0x05e4, B:287:0x05ec, B:290:0x05f1, B:291:0x05fd, B:293:0x0603, B:295:0x060b, B:298:0x061b, B:300:0x0621, B:301:0x063b, B:303:0x0641, B:305:0x0646, B:307:0x064b, B:309:0x064f, B:311:0x0655, B:313:0x0659, B:315:0x0661, B:317:0x0667, B:319:0x0671, B:322:0x0677, B:323:0x067a, B:325:0x0683, B:327:0x0695, B:329:0x069e, B:331:0x06a6, B:336:0x06b0, B:217:0x04a3, B:219:0x04a9, B:222:0x04af, B:225:0x04ba, B:227:0x04bf, B:230:0x04cd, B:232:0x04d3, B:233:0x04db, B:234:0x04de, B:236:0x04e6, B:238:0x04f4, B:240:0x0530, B:242:0x053a, B:245:0x0545, B:247:0x054d, B:248:0x0550, B:250:0x0554, B:252:0x055a, B:254:0x0566, B:256:0x0570, B:258:0x0581, B:260:0x0587, B:261:0x0592, B:262:0x0597, B:264:0x05a2, B:267:0x05a7, B:269:0x05ad, B:271:0x05b5, B:273:0x05bb, B:275:0x05c1, B:279:0x05cf, B:281:0x05d6, B:282:0x05d9, B:213:0x0491, B:338:0x06da, B:342:0x06e5, B:344:0x06ef, B:345:0x06f4, B:347:0x0704, B:348:0x071a, B:350:0x0720, B:352:0x0728, B:354:0x072f, B:358:0x0738, B:363:0x0747, B:369:0x0754, B:371:0x075a, B:381:0x076d, B:382:0x0770, B:384:0x077c, B:386:0x0782, B:390:0x078f, B:392:0x0797, B:394:0x079b, B:395:0x07a6, B:397:0x07ac, B:451:0x089c, B:454:0x08a4, B:456:0x08a9, B:458:0x08b1, B:460:0x08bf, B:461:0x08c6, B:462:0x08ca, B:464:0x08d0, B:466:0x08d9, B:468:0x08df, B:470:0x08ea, B:477:0x090e, B:479:0x0914, B:483:0x091d, B:485:0x0921, B:490:0x092a, B:492:0x0930, B:494:0x0990, B:496:0x0995, B:505:0x09a6, B:507:0x09aa, B:508:0x09b2, B:509:0x09b9, B:471:0x08f1, B:474:0x08ff, B:475:0x0906, B:476:0x0907, B:398:0x07b5, B:433:0x0857, B:435:0x085d, B:437:0x0861, B:441:0x086a, B:443:0x0878, B:445:0x0880, B:447:0x088a, B:448:0x088f, B:449:0x0894, B:450:0x0899, B:401:0x07bf, B:403:0x07c3, B:430:0x0847, B:432:0x0853, B:407:0x07ce, B:409:0x07d2, B:411:0x07e6, B:413:0x07f4, B:415:0x0800, B:419:0x0809, B:421:0x0813, B:427:0x081e, B:383:0x0775, B:510:0x09be, B:514:0x09c5, B:515:0x09cd, B:519:0x09eb), top: B:589:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:492:0x0930 A[Catch: RuntimeException -> 0x09fd, IOException -> 0x0a28, zzsq -> 0x0a30, zzgf -> 0x0a38, zzcd -> 0x0a40, zzqm -> 0x0a57, zzih -> 0x0a61, TryCatch #9 {zzcd -> 0x0a40, zzgf -> 0x0a38, zzih -> 0x0a61, zzqm -> 0x0a57, zzsq -> 0x0a30, IOException -> 0x0a28, RuntimeException -> 0x09fd, blocks: (B:3:0x0006, B:4:0x0011, B:7:0x0016, B:8:0x001b, B:9:0x0020, B:13:0x0027, B:15:0x002b, B:17:0x002f, B:19:0x0035, B:20:0x003c, B:24:0x0043, B:26:0x004c, B:28:0x005a, B:29:0x0062, B:30:0x006d, B:31:0x0081, B:32:0x0099, B:33:0x00af, B:35:0x00be, B:36:0x00c2, B:37:0x00d3, B:39:0x00e2, B:40:0x00fe, B:41:0x0111, B:42:0x011a, B:44:0x012c, B:45:0x0138, B:46:0x0148, B:48:0x0154, B:51:0x015f, B:52:0x0166, B:53:0x0173, B:57:0x017a, B:59:0x0182, B:61:0x0186, B:63:0x018c, B:65:0x0194, B:67:0x019c, B:68:0x019f, B:70:0x01a4, B:77:0x01b1, B:78:0x01b2, B:82:0x01b9, B:84:0x01c7, B:85:0x01ca, B:86:0x01cf, B:88:0x01df, B:89:0x01e2, B:90:0x01e7, B:91:0x01ec, B:93:0x01f8, B:94:0x0204, B:96:0x0210, B:98:0x023c, B:99:0x025c, B:100:0x0261, B:101:0x0265, B:103:0x026a, B:104:0x027b, B:106:0x0287, B:107:0x028a, B:114:0x0295, B:115:0x0296, B:116:0x029b, B:117:0x02a3, B:118:0x02b5, B:120:0x02dc, B:186:0x03f3, B:170:0x03c0, B:169:0x03bc, B:195:0x0404, B:196:0x0411, B:121:0x02fe, B:125:0x0311, B:127:0x0321, B:129:0x0338, B:131:0x0342, B:197:0x0412, B:199:0x0426, B:202:0x0430, B:204:0x043f, B:206:0x044b, B:208:0x047a, B:209:0x047f, B:210:0x0483, B:212:0x0487, B:214:0x0494, B:283:0x05dc, B:285:0x05e4, B:287:0x05ec, B:290:0x05f1, B:291:0x05fd, B:293:0x0603, B:295:0x060b, B:298:0x061b, B:300:0x0621, B:301:0x063b, B:303:0x0641, B:305:0x0646, B:307:0x064b, B:309:0x064f, B:311:0x0655, B:313:0x0659, B:315:0x0661, B:317:0x0667, B:319:0x0671, B:322:0x0677, B:323:0x067a, B:325:0x0683, B:327:0x0695, B:329:0x069e, B:331:0x06a6, B:336:0x06b0, B:217:0x04a3, B:219:0x04a9, B:222:0x04af, B:225:0x04ba, B:227:0x04bf, B:230:0x04cd, B:232:0x04d3, B:233:0x04db, B:234:0x04de, B:236:0x04e6, B:238:0x04f4, B:240:0x0530, B:242:0x053a, B:245:0x0545, B:247:0x054d, B:248:0x0550, B:250:0x0554, B:252:0x055a, B:254:0x0566, B:256:0x0570, B:258:0x0581, B:260:0x0587, B:261:0x0592, B:262:0x0597, B:264:0x05a2, B:267:0x05a7, B:269:0x05ad, B:271:0x05b5, B:273:0x05bb, B:275:0x05c1, B:279:0x05cf, B:281:0x05d6, B:282:0x05d9, B:213:0x0491, B:338:0x06da, B:342:0x06e5, B:344:0x06ef, B:345:0x06f4, B:347:0x0704, B:348:0x071a, B:350:0x0720, B:352:0x0728, B:354:0x072f, B:358:0x0738, B:363:0x0747, B:369:0x0754, B:371:0x075a, B:381:0x076d, B:382:0x0770, B:384:0x077c, B:386:0x0782, B:390:0x078f, B:392:0x0797, B:394:0x079b, B:395:0x07a6, B:397:0x07ac, B:451:0x089c, B:454:0x08a4, B:456:0x08a9, B:458:0x08b1, B:460:0x08bf, B:461:0x08c6, B:462:0x08ca, B:464:0x08d0, B:466:0x08d9, B:468:0x08df, B:470:0x08ea, B:477:0x090e, B:479:0x0914, B:483:0x091d, B:485:0x0921, B:490:0x092a, B:492:0x0930, B:494:0x0990, B:496:0x0995, B:505:0x09a6, B:507:0x09aa, B:508:0x09b2, B:509:0x09b9, B:471:0x08f1, B:474:0x08ff, B:475:0x0906, B:476:0x0907, B:398:0x07b5, B:433:0x0857, B:435:0x085d, B:437:0x0861, B:441:0x086a, B:443:0x0878, B:445:0x0880, B:447:0x088a, B:448:0x088f, B:449:0x0894, B:450:0x0899, B:401:0x07bf, B:403:0x07c3, B:430:0x0847, B:432:0x0853, B:407:0x07ce, B:409:0x07d2, B:411:0x07e6, B:413:0x07f4, B:415:0x0800, B:419:0x0809, B:421:0x0813, B:427:0x081e, B:383:0x0775, B:510:0x09be, B:514:0x09c5, B:515:0x09cd, B:519:0x09eb), top: B:589:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:493:0x098a  */
    /* JADX WARN: Removed duplicated region for block: B:496:0x0995 A[Catch: RuntimeException -> 0x09fd, IOException -> 0x0a28, zzsq -> 0x0a30, zzgf -> 0x0a38, zzcd -> 0x0a40, zzqm -> 0x0a57, zzih -> 0x0a61, TryCatch #9 {zzcd -> 0x0a40, zzgf -> 0x0a38, zzih -> 0x0a61, zzqm -> 0x0a57, zzsq -> 0x0a30, IOException -> 0x0a28, RuntimeException -> 0x09fd, blocks: (B:3:0x0006, B:4:0x0011, B:7:0x0016, B:8:0x001b, B:9:0x0020, B:13:0x0027, B:15:0x002b, B:17:0x002f, B:19:0x0035, B:20:0x003c, B:24:0x0043, B:26:0x004c, B:28:0x005a, B:29:0x0062, B:30:0x006d, B:31:0x0081, B:32:0x0099, B:33:0x00af, B:35:0x00be, B:36:0x00c2, B:37:0x00d3, B:39:0x00e2, B:40:0x00fe, B:41:0x0111, B:42:0x011a, B:44:0x012c, B:45:0x0138, B:46:0x0148, B:48:0x0154, B:51:0x015f, B:52:0x0166, B:53:0x0173, B:57:0x017a, B:59:0x0182, B:61:0x0186, B:63:0x018c, B:65:0x0194, B:67:0x019c, B:68:0x019f, B:70:0x01a4, B:77:0x01b1, B:78:0x01b2, B:82:0x01b9, B:84:0x01c7, B:85:0x01ca, B:86:0x01cf, B:88:0x01df, B:89:0x01e2, B:90:0x01e7, B:91:0x01ec, B:93:0x01f8, B:94:0x0204, B:96:0x0210, B:98:0x023c, B:99:0x025c, B:100:0x0261, B:101:0x0265, B:103:0x026a, B:104:0x027b, B:106:0x0287, B:107:0x028a, B:114:0x0295, B:115:0x0296, B:116:0x029b, B:117:0x02a3, B:118:0x02b5, B:120:0x02dc, B:186:0x03f3, B:170:0x03c0, B:169:0x03bc, B:195:0x0404, B:196:0x0411, B:121:0x02fe, B:125:0x0311, B:127:0x0321, B:129:0x0338, B:131:0x0342, B:197:0x0412, B:199:0x0426, B:202:0x0430, B:204:0x043f, B:206:0x044b, B:208:0x047a, B:209:0x047f, B:210:0x0483, B:212:0x0487, B:214:0x0494, B:283:0x05dc, B:285:0x05e4, B:287:0x05ec, B:290:0x05f1, B:291:0x05fd, B:293:0x0603, B:295:0x060b, B:298:0x061b, B:300:0x0621, B:301:0x063b, B:303:0x0641, B:305:0x0646, B:307:0x064b, B:309:0x064f, B:311:0x0655, B:313:0x0659, B:315:0x0661, B:317:0x0667, B:319:0x0671, B:322:0x0677, B:323:0x067a, B:325:0x0683, B:327:0x0695, B:329:0x069e, B:331:0x06a6, B:336:0x06b0, B:217:0x04a3, B:219:0x04a9, B:222:0x04af, B:225:0x04ba, B:227:0x04bf, B:230:0x04cd, B:232:0x04d3, B:233:0x04db, B:234:0x04de, B:236:0x04e6, B:238:0x04f4, B:240:0x0530, B:242:0x053a, B:245:0x0545, B:247:0x054d, B:248:0x0550, B:250:0x0554, B:252:0x055a, B:254:0x0566, B:256:0x0570, B:258:0x0581, B:260:0x0587, B:261:0x0592, B:262:0x0597, B:264:0x05a2, B:267:0x05a7, B:269:0x05ad, B:271:0x05b5, B:273:0x05bb, B:275:0x05c1, B:279:0x05cf, B:281:0x05d6, B:282:0x05d9, B:213:0x0491, B:338:0x06da, B:342:0x06e5, B:344:0x06ef, B:345:0x06f4, B:347:0x0704, B:348:0x071a, B:350:0x0720, B:352:0x0728, B:354:0x072f, B:358:0x0738, B:363:0x0747, B:369:0x0754, B:371:0x075a, B:381:0x076d, B:382:0x0770, B:384:0x077c, B:386:0x0782, B:390:0x078f, B:392:0x0797, B:394:0x079b, B:395:0x07a6, B:397:0x07ac, B:451:0x089c, B:454:0x08a4, B:456:0x08a9, B:458:0x08b1, B:460:0x08bf, B:461:0x08c6, B:462:0x08ca, B:464:0x08d0, B:466:0x08d9, B:468:0x08df, B:470:0x08ea, B:477:0x090e, B:479:0x0914, B:483:0x091d, B:485:0x0921, B:490:0x092a, B:492:0x0930, B:494:0x0990, B:496:0x0995, B:505:0x09a6, B:507:0x09aa, B:508:0x09b2, B:509:0x09b9, B:471:0x08f1, B:474:0x08ff, B:475:0x0906, B:476:0x0907, B:398:0x07b5, B:433:0x0857, B:435:0x085d, B:437:0x0861, B:441:0x086a, B:443:0x0878, B:445:0x0880, B:447:0x088a, B:448:0x088f, B:449:0x0894, B:450:0x0899, B:401:0x07bf, B:403:0x07c3, B:430:0x0847, B:432:0x0853, B:407:0x07ce, B:409:0x07d2, B:411:0x07e6, B:413:0x07f4, B:415:0x0800, B:419:0x0809, B:421:0x0813, B:427:0x081e, B:383:0x0775, B:510:0x09be, B:514:0x09c5, B:515:0x09cd, B:519:0x09eb), top: B:589:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:595:0x0649 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:630:0x0770 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v34, types: [com.google.android.gms.internal.ads.zzhg, com.google.android.gms.internal.ads.zzxo] */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean handleMessage(android.os.Message r56) {
        /*
            Method dump skipped, instructions count: 2890
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzkh.handleMessage(android.os.Message):boolean");
    }

    @Override // com.google.android.gms.internal.ads.zzie
    public final void zza(zzch zzchVar) {
        this.zzh.zzc(16, zzchVar).zza();
    }

    public final Looper zzb() {
        return this.zzj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Boolean zzd() {
        return Boolean.valueOf(this.zzw);
    }

    @Override // com.google.android.gms.internal.ads.zzvg
    public final /* bridge */ /* synthetic */ void zzg(zzvh zzvhVar) {
        this.zzh.zzc(9, (zztm) zzvhVar).zza();
    }

    @Override // com.google.android.gms.internal.ads.zzla
    public final void zzh() {
        this.zzh.zzi(22);
    }

    @Override // com.google.android.gms.internal.ads.zztl
    public final void zzi(zztm zztmVar) {
        this.zzh.zzc(8, zztmVar).zza();
    }

    @Override // com.google.android.gms.internal.ads.zzxf
    public final void zzj() {
        this.zzh.zzi(10);
    }

    public final void zzk() {
        this.zzh.zzb(0).zza();
    }

    public final void zzl(zzcw zzcwVar, int i4, long j4) {
        this.zzh.zzc(3, new zzkg(zzcwVar, i4, j4)).zza();
    }

    @Override // com.google.android.gms.internal.ads.zzld
    public final synchronized void zzm(zzlf zzlfVar) {
        if (!this.zzw && this.zzj.getThread().isAlive()) {
            this.zzh.zzc(14, zzlfVar).zza();
            return;
        }
        zzer.zzf("ExoPlayerImplInternal", "Ignoring messages sent after release.");
        zzlfVar.zzh(false);
    }

    public final void zzn(boolean z3, int i4) {
        this.zzh.zzd(1, z3 ? 1 : 0, i4).zza();
    }

    public final void zzo() {
        this.zzh.zzb(6).zza();
    }

    public final synchronized boolean zzp() {
        if (!this.zzw && this.zzj.getThread().isAlive()) {
            this.zzh.zzi(7);
            zzac(new zzjy(this), this.zzs);
            return this.zzw;
        }
        return true;
    }

    public final void zzq(List list, int i4, long j4, zzvi zzviVar) {
        this.zzh.zzc(17, new zzkc(list, zzviVar, i4, j4, null)).zza();
    }
}
