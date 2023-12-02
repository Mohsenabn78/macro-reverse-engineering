package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.Surface;
import androidx.annotation.Nullable;
import com.google.android.gms.wearable.WearableStatusCodes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzjx extends zzm implements zzis {
    public static final /* synthetic */ int zzd = 0;
    private final zzlr zzA;
    private final long zzB;
    private int zzC;
    private int zzD;
    private boolean zzE;
    private int zzF;
    private zzlm zzG;
    private zzcl zzH;
    private zzbv zzI;
    private zzbv zzJ;
    @Nullable
    private zzam zzK;
    @Nullable
    private zzam zzL;
    @Nullable
    private AudioTrack zzM;
    @Nullable
    private Object zzN;
    @Nullable
    private Surface zzO;
    private int zzP;
    private zzfb zzQ;
    @Nullable
    private zzhz zzR;
    @Nullable
    private zzhz zzS;
    private int zzT;
    private zzk zzU;
    private float zzV;
    private boolean zzW;
    private zzdx zzX;
    private boolean zzY;
    private boolean zzZ;
    private zzz zzaa;
    private zzdn zzab;
    private zzbv zzac;
    private zzlc zzad;
    private int zzae;
    private long zzaf;
    private final zzjc zzag;
    private zzvi zzah;
    final zzxh zzb;
    final zzcl zzc;
    private final zzeb zze;
    private final Context zzf;
    private final zzcp zzg;
    private final zzli[] zzh;
    private final zzxg zzi;
    private final zzei zzj;
    private final zzkh zzk;
    private final zzeo zzl;
    private final CopyOnWriteArraySet zzm;
    private final zzct zzn;
    private final List zzo;
    private final boolean zzp;
    private final zztn zzq;
    private final zzls zzr;
    private final Looper zzs;
    private final zzxo zzt;
    private final zzdz zzu;
    private final zzjt zzv;
    private final zzjv zzw;
    private final zzht zzx;
    private final zzhx zzy;
    private final zzlq zzz;

    static {
        zzbq.zzb("media3.exoplayer");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v6, types: [com.google.android.gms.internal.ads.zzls, java.lang.Object, com.google.android.gms.internal.ads.zzxn] */
    @SuppressLint({"HandlerLeak"})
    public zzjx(zzir zzirVar, @Nullable zzcp zzcpVar) {
        zzoc zza;
        Object obj;
        zzeb zzebVar = new zzeb(zzdz.zza);
        this.zze = zzebVar;
        try {
            String hexString = Integer.toHexString(System.identityHashCode(this));
            String str = zzfj.zze;
            zzer.zze("ExoPlayerImpl", "Init " + hexString + " [AndroidXMedia3/1.1.0-beta01] [" + str + "]");
            Context applicationContext = zzirVar.zza.getApplicationContext();
            this.zzf = applicationContext;
            ?? apply = zzirVar.zzh.apply(zzirVar.zzb);
            this.zzr = apply;
            this.zzU = zzirVar.zzj;
            this.zzP = zzirVar.zzk;
            this.zzW = false;
            this.zzB = zzirVar.zzo;
            zzjt zzjtVar = new zzjt(this, null);
            this.zzv = zzjtVar;
            zzjv zzjvVar = new zzjv(null);
            this.zzw = zzjvVar;
            Handler handler = new Handler(zzirVar.zzi);
            zzli[] zza2 = ((zzil) zzirVar.zzc).zza.zza(handler, zzjtVar, zzjtVar, zzjtVar, zzjtVar);
            this.zzh = zza2;
            int length = zza2.length;
            zzxg zzxgVar = (zzxg) zzirVar.zze.zza();
            this.zzi = zzxgVar;
            this.zzq = zzir.zza(((zzim) zzirVar.zzd).zza);
            zzxs zzg = zzxs.zzg(((zzip) zzirVar.zzg).zza);
            this.zzt = zzg;
            this.zzp = zzirVar.zzl;
            this.zzG = zzirVar.zzm;
            Looper looper = zzirVar.zzi;
            this.zzs = looper;
            zzdz zzdzVar = zzirVar.zzb;
            this.zzu = zzdzVar;
            this.zzg = zzcpVar;
            zzeo zzeoVar = new zzeo(looper, zzdzVar, new zzem() { // from class: com.google.android.gms.internal.ads.zzjb
                @Override // com.google.android.gms.internal.ads.zzem
                public final void zza(Object obj2, zzah zzahVar) {
                    zzcm zzcmVar = (zzcm) obj2;
                }
            });
            this.zzl = zzeoVar;
            CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
            this.zzm = copyOnWriteArraySet;
            this.zzo = new ArrayList();
            this.zzah = new zzvi(0);
            int length2 = zza2.length;
            zzxh zzxhVar = new zzxh(new zzll[2], new zzxa[2], zzdh.zza, null);
            this.zzb = zzxhVar;
            this.zzn = new zzct();
            zzcj zzcjVar = new zzcj();
            zzcjVar.zzc(1, 2, 3, 13, 14, 15, 16, 17, 18, 19, 31, 20, 30, 21, 22, 24, 27, 28, 32);
            zzxgVar.zzm();
            zzcjVar.zzd(29, true);
            zzcjVar.zzd(23, false);
            zzcjVar.zzd(25, false);
            zzcjVar.zzd(33, false);
            zzcjVar.zzd(26, false);
            zzcjVar.zzd(34, false);
            zzcl zze = zzcjVar.zze();
            this.zzc = zze;
            zzcj zzcjVar2 = new zzcj();
            zzcjVar2.zzb(zze);
            zzcjVar2.zza(4);
            zzcjVar2.zza(10);
            this.zzH = zzcjVar2.zze();
            this.zzj = zzdzVar.zzb(looper, null);
            zzjc zzjcVar = new zzjc(this);
            this.zzag = zzjcVar;
            this.zzad = zzlc.zzi(zzxhVar);
            apply.zzP(zzcpVar, looper);
            int i4 = zzfj.zza;
            if (i4 < 31) {
                zza = new zzoc();
            } else {
                zza = zzjo.zza(applicationContext, this, zzirVar.zzp);
            }
            this.zzk = new zzkh(zza2, zzxgVar, zzxhVar, (zzkk) zzirVar.zzf.zza(), zzg, 0, false, apply, this.zzG, zzirVar.zzr, zzirVar.zzn, false, looper, zzdzVar, zzjcVar, zza, null);
            this.zzV = 1.0f;
            zzbv zzbvVar = zzbv.zza;
            this.zzI = zzbvVar;
            this.zzJ = zzbvVar;
            this.zzac = zzbvVar;
            int i5 = -1;
            this.zzae = -1;
            if (i4 >= 21) {
                AudioManager audioManager = (AudioManager) applicationContext.getSystemService("audio");
                if (audioManager != null) {
                    i5 = audioManager.generateAudioSessionId();
                }
                this.zzT = i5;
                obj = null;
            } else {
                AudioTrack audioTrack = this.zzM;
                if (audioTrack != null && audioTrack.getAudioSessionId() != 0) {
                    this.zzM.release();
                    obj = null;
                    this.zzM = null;
                } else {
                    obj = null;
                }
                if (this.zzM == null) {
                    this.zzM = new AudioTrack(3, WearableStatusCodes.TARGET_NODE_NOT_CONNECTED, 4, 2, 2, 0, 0);
                }
                this.zzT = this.zzM.getAudioSessionId();
            }
            this.zzX = zzdx.zza;
            this.zzY = true;
            apply.getClass();
            zzeoVar.zzb(apply);
            zzg.zze(new Handler(looper), apply);
            copyOnWriteArraySet.add(zzjtVar);
            this.zzx = new zzht(zzirVar.zza, handler, zzjtVar);
            this.zzy = new zzhx(zzirVar.zza, handler, zzjtVar);
            zzfj.zzC(obj, obj);
            this.zzz = new zzlq(zzirVar.zza);
            this.zzA = new zzlr(zzirVar.zza);
            this.zzaa = new zzx(0).zza();
            this.zzab = zzdn.zza;
            this.zzQ = zzfb.zza;
            zzxgVar.zzj(this.zzU);
            zzah(1, 10, Integer.valueOf(this.zzT));
            zzah(2, 10, Integer.valueOf(this.zzT));
            zzah(1, 3, this.zzU);
            zzah(2, 4, Integer.valueOf(this.zzP));
            zzah(2, 5, 0);
            zzah(1, 9, Boolean.valueOf(this.zzW));
            zzah(2, 7, zzjvVar);
            zzah(6, 8, zzjvVar);
            zzebVar.zze();
        } catch (Throwable th) {
            this.zze.zze();
            throw th;
        }
    }

    public static /* bridge */ /* synthetic */ void zzP(zzjx zzjxVar, SurfaceTexture surfaceTexture) {
        Surface surface = new Surface(surfaceTexture);
        zzjxVar.zzaj(surface);
        zzjxVar.zzO = surface;
    }

    private final int zzX(zzlc zzlcVar) {
        if (zzlcVar.zza.zzo()) {
            return this.zzae;
        }
        return zzlcVar.zza.zzn(zzlcVar.zzb.zza, this.zzn).zzd;
    }

    public static int zzY(boolean z3, int i4) {
        if (!z3 || i4 == 1) {
            return 1;
        }
        return 2;
    }

    private final long zzZ(zzlc zzlcVar) {
        if (zzlcVar.zzb.zzb()) {
            zzlcVar.zza.zzn(zzlcVar.zzb.zza, this.zzn);
            long j4 = zzlcVar.zzc;
            if (j4 == -9223372036854775807L) {
                long j5 = zzlcVar.zza.zze(zzX(zzlcVar), this.zza, 0L).zzm;
                return zzfj.zzq(0L);
            }
            return zzfj.zzq(j4) + zzfj.zzq(0L);
        }
        return zzfj.zzq(zzaa(zzlcVar));
    }

    private final long zzaa(zzlc zzlcVar) {
        long j4;
        if (zzlcVar.zza.zzo()) {
            return zzfj.zzo(this.zzaf);
        }
        if (zzlcVar.zzo) {
            j4 = zzlcVar.zza();
        } else {
            j4 = zzlcVar.zzr;
        }
        if (zzlcVar.zzb.zzb()) {
            return j4;
        }
        zzac(zzlcVar.zza, zzlcVar.zzb, j4);
        return j4;
    }

    private static long zzab(zzlc zzlcVar) {
        zzcv zzcvVar = new zzcv();
        zzct zzctVar = new zzct();
        zzlcVar.zza.zzn(zzlcVar.zzb.zza, zzctVar);
        long j4 = zzlcVar.zzc;
        if (j4 == -9223372036854775807L) {
            long j5 = zzlcVar.zza.zze(zzctVar.zzd, zzcvVar, 0L).zzm;
            return 0L;
        }
        return j4;
    }

    private final long zzac(zzcw zzcwVar, zzto zztoVar, long j4) {
        zzcwVar.zzn(zztoVar.zza, this.zzn);
        return j4;
    }

    @Nullable
    private final Pair zzad(zzcw zzcwVar, int i4, long j4) {
        if (zzcwVar.zzo()) {
            this.zzae = i4;
            if (j4 == -9223372036854775807L) {
                j4 = 0;
            }
            this.zzaf = j4;
            return null;
        }
        if (i4 == -1 || i4 >= zzcwVar.zzc()) {
            i4 = zzcwVar.zzg(false);
            long j5 = zzcwVar.zze(i4, this.zza, 0L).zzm;
            j4 = zzfj.zzq(0L);
        }
        return zzcwVar.zzl(this.zza, this.zzn, i4, zzfj.zzo(j4));
    }

    private final zzlc zzae(zzlc zzlcVar, zzcw zzcwVar, @Nullable Pair pair) {
        boolean z3;
        zzto zztoVar;
        zzvn zzvnVar;
        zzxh zzxhVar;
        List list;
        int i4;
        long j4;
        if (!zzcwVar.zzo() && pair == null) {
            z3 = false;
        } else {
            z3 = true;
        }
        zzdy.zzd(z3);
        zzcw zzcwVar2 = zzlcVar.zza;
        long zzZ = zzZ(zzlcVar);
        zzlc zzh = zzlcVar.zzh(zzcwVar);
        if (zzcwVar.zzo()) {
            zzto zzj = zzlc.zzj();
            long zzo = zzfj.zzo(this.zzaf);
            zzlc zzc = zzh.zzd(zzj, zzo, zzo, zzo, 0L, zzvn.zza, this.zzb, zzfsc.zzl()).zzc(zzj);
            zzc.zzp = zzc.zzr;
            return zzc;
        }
        Object obj = zzh.zzb.zza;
        int i5 = zzfj.zza;
        boolean z4 = !obj.equals(pair.first);
        if (z4) {
            zztoVar = new zzto(pair.first);
        } else {
            zztoVar = zzh.zzb;
        }
        zzto zztoVar2 = zztoVar;
        long longValue = ((Long) pair.second).longValue();
        long zzo2 = zzfj.zzo(zzZ);
        if (!zzcwVar2.zzo()) {
            zzcwVar2.zzn(obj, this.zzn);
        }
        if (!z4 && longValue >= zzo2) {
            if (i4 == 0) {
                int zza = zzcwVar.zza(zzh.zzk.zza);
                if (zza == -1 || zzcwVar.zzd(zza, this.zzn, false).zzd != zzcwVar.zzn(zztoVar2.zza, this.zzn).zzd) {
                    zzcwVar.zzn(zztoVar2.zza, this.zzn);
                    if (zztoVar2.zzb()) {
                        j4 = this.zzn.zzh(zztoVar2.zzb, zztoVar2.zzc);
                    } else {
                        j4 = this.zzn.zze;
                    }
                    zzlc zzc2 = zzh.zzd(zztoVar2, zzh.zzr, zzh.zzr, zzh.zzd, j4 - zzh.zzr, zzh.zzh, zzh.zzi, zzh.zzj).zzc(zztoVar2);
                    zzc2.zzp = j4;
                    return zzc2;
                }
                return zzh;
            }
            zzdy.zzf(!zztoVar2.zzb());
            long max = Math.max(0L, zzh.zzq - (longValue - zzo2));
            long j5 = zzh.zzp;
            if (zzh.zzk.equals(zzh.zzb)) {
                j5 = longValue + max;
            }
            zzlc zzd2 = zzh.zzd(zztoVar2, longValue, longValue, longValue, max, zzh.zzh, zzh.zzi, zzh.zzj);
            zzd2.zzp = j5;
            return zzd2;
        }
        zzdy.zzf(!zztoVar2.zzb());
        if (z4) {
            zzvnVar = zzvn.zza;
        } else {
            zzvnVar = zzh.zzh;
        }
        zzvn zzvnVar2 = zzvnVar;
        if (z4) {
            zzxhVar = this.zzb;
        } else {
            zzxhVar = zzh.zzi;
        }
        zzxh zzxhVar2 = zzxhVar;
        if (z4) {
            list = zzfsc.zzl();
        } else {
            list = zzh.zzj;
        }
        zzlc zzc3 = zzh.zzd(zztoVar2, longValue, longValue, longValue, 0L, zzvnVar2, zzxhVar2, list).zzc(zztoVar2);
        zzc3.zzp = longValue;
        return zzc3;
    }

    private final zzlf zzaf(zzle zzleVar) {
        int i4;
        int zzX = zzX(this.zzad);
        zzkh zzkhVar = this.zzk;
        zzcw zzcwVar = this.zzad.zza;
        if (zzX == -1) {
            i4 = 0;
        } else {
            i4 = zzX;
        }
        return new zzlf(zzkhVar, zzleVar, zzcwVar, i4, this.zzu, zzkhVar.zzb());
    }

    public final void zzag(final int i4, final int i5) {
        if (i4 == this.zzQ.zzb() && i5 == this.zzQ.zza()) {
            return;
        }
        this.zzQ = new zzfb(i4, i5);
        zzeo zzeoVar = this.zzl;
        zzeoVar.zzd(24, new zzel() { // from class: com.google.android.gms.internal.ads.zzjf
            @Override // com.google.android.gms.internal.ads.zzel
            public final void zza(Object obj) {
                int i6 = i4;
                int i7 = i5;
                int i8 = zzjx.zzd;
                ((zzcm) obj).zzo(i6, i7);
            }
        });
        zzeoVar.zzc();
        zzah(2, 14, new zzfb(i4, i5));
    }

    private final void zzah(int i4, int i5, @Nullable Object obj) {
        zzli[] zzliVarArr = this.zzh;
        int length = zzliVarArr.length;
        for (int i6 = 0; i6 < 2; i6++) {
            zzli zzliVar = zzliVarArr[i6];
            if (zzliVar.zzb() == i4) {
                zzlf zzaf = zzaf(zzliVar);
                zzaf.zzf(i5);
                zzaf.zze(obj);
                zzaf.zzd();
            }
        }
    }

    public final void zzai() {
        zzah(1, 2, Float.valueOf(this.zzV * this.zzy.zza()));
    }

    public final void zzaj(@Nullable Object obj) {
        ArrayList<zzlf> arrayList = new ArrayList();
        zzli[] zzliVarArr = this.zzh;
        int length = zzliVarArr.length;
        boolean z3 = false;
        for (int i4 = 0; i4 < 2; i4++) {
            zzli zzliVar = zzliVarArr[i4];
            if (zzliVar.zzb() == 2) {
                zzlf zzaf = zzaf(zzliVar);
                zzaf.zzf(1);
                zzaf.zze(obj);
                zzaf.zzd();
                arrayList.add(zzaf);
            }
        }
        Object obj2 = this.zzN;
        if (obj2 != null && obj2 != obj) {
            try {
                for (zzlf zzlfVar : arrayList) {
                    zzlfVar.zzi(this.zzB);
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            } catch (TimeoutException unused2) {
                z3 = true;
            }
            Object obj3 = this.zzN;
            Surface surface = this.zzO;
            if (obj3 == surface) {
                surface.release();
                this.zzO = null;
            }
        }
        this.zzN = obj;
        if (z3) {
            zzak(zzih.zzd(new zzki(3), 1003));
        }
    }

    private final void zzak(@Nullable zzih zzihVar) {
        zzlc zzlcVar = this.zzad;
        zzlc zzc = zzlcVar.zzc(zzlcVar.zzb);
        zzc.zzp = zzc.zzr;
        zzc.zzq = 0L;
        zzlc zzg = zzc.zzg(1);
        if (zzihVar != null) {
            zzg = zzg.zzf(zzihVar);
        }
        this.zzC++;
        this.zzk.zzo();
        zzam(zzg, 0, 1, false, 5, -9223372036854775807L, -1, false);
    }

    public final void zzal(boolean z3, int i4, int i5) {
        boolean z4;
        int i6 = 0;
        if (z3 && i4 != -1) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4 && i4 != 1) {
            i6 = 1;
        }
        zzlc zzlcVar = this.zzad;
        if (zzlcVar.zzl == z4 && zzlcVar.zzm == i6) {
            return;
        }
        this.zzC++;
        if (zzlcVar.zzo) {
            zzlcVar = zzlcVar.zzb();
        }
        zzlc zze = zzlcVar.zze(z4, i6);
        this.zzk.zzn(z4, i6);
        zzam(zze, 0, i5, false, 5, -9223372036854775807L, -1, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:306:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:311:0x02a7  */
    /* JADX WARN: Removed duplicated region for block: B:363:0x03f3  */
    /* JADX WARN: Removed duplicated region for block: B:368:0x040e  */
    /* JADX WARN: Removed duplicated region for block: B:371:0x0424  */
    /* JADX WARN: Removed duplicated region for block: B:375:0x0433  */
    /* JADX WARN: Removed duplicated region for block: B:381:0x045b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:386:0x0465 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:391:0x0470 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:399:0x0481 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:404:0x048d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:412:0x04a4 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:417:0x04b0 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:422:0x04c6  */
    /* JADX WARN: Removed duplicated region for block: B:425:0x04dd  */
    /* JADX WARN: Removed duplicated region for block: B:429:0x04f5 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Type inference failed for: r9v23 */
    /* JADX WARN: Type inference failed for: r9v24 */
    /* JADX WARN: Type inference failed for: r9v9, types: [int, boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void zzam(final com.google.android.gms.internal.ads.zzlc r43, final int r44, final int r45, boolean r46, final int r47, long r48, int r50, boolean r51) {
        /*
            Method dump skipped, instructions count: 1270
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzjx.zzam(com.google.android.gms.internal.ads.zzlc, int, int, boolean, int, long, int, boolean):void");
    }

    public final void zzan() {
        int zzf = zzf();
        if (zzf != 2 && zzf != 3) {
            return;
        }
        zzao();
        boolean z3 = this.zzad.zzo;
        zzv();
        zzv();
    }

    private final void zzao() {
        IllegalStateException illegalStateException;
        this.zze.zzb();
        if (Thread.currentThread() != this.zzs.getThread()) {
            String format = String.format(Locale.US, "Player is accessed on the wrong thread.\nCurrent thread: '%s'\nExpected thread: '%s'\nSee https://developer.android.com/guide/topics/media/issues/player-accessed-on-wrong-thread", Thread.currentThread().getName(), this.zzs.getThread().getName());
            if (!this.zzY) {
                if (this.zzZ) {
                    illegalStateException = null;
                } else {
                    illegalStateException = new IllegalStateException();
                }
                zzer.zzg("ExoPlayerImpl", format, illegalStateException);
                this.zzZ = true;
                return;
            }
            throw new IllegalStateException(format);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzis
    public final void zzA(zzlv zzlvVar) {
        zzao();
        this.zzr.zzO(zzlvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzis
    public final void zzB(zztq zztqVar) {
        boolean z3;
        zzao();
        List singletonList = Collections.singletonList(zztqVar);
        zzao();
        zzao();
        zzX(this.zzad);
        zzk();
        this.zzC++;
        if (!this.zzo.isEmpty()) {
            int size = this.zzo.size();
            for (int i4 = size - 1; i4 >= 0; i4--) {
                this.zzo.remove(i4);
            }
            this.zzah = this.zzah.zzh(0, size);
        }
        ArrayList arrayList = new ArrayList();
        for (int i5 = 0; i5 < singletonList.size(); i5++) {
            zzkz zzkzVar = new zzkz((zztq) singletonList.get(i5), this.zzp);
            arrayList.add(zzkzVar);
            this.zzo.add(i5, new zzjw(zzkzVar.zzb, zzkzVar.zza.zzB()));
        }
        this.zzah = this.zzah.zzg(0, arrayList.size());
        zzlg zzlgVar = new zzlg(this.zzo, this.zzah);
        if (!zzlgVar.zzo() && zzlgVar.zzc() < 0) {
            throw new zzan(zzlgVar, -1, -9223372036854775807L);
        }
        int zzg = zzlgVar.zzg(false);
        zzlc zzae = zzae(this.zzad, zzlgVar, zzad(zzlgVar, zzg, -9223372036854775807L));
        int i6 = zzae.zze;
        if (zzg != -1 && i6 != 1) {
            i6 = 4;
            if (!zzlgVar.zzo() && zzg < zzlgVar.zzc()) {
                i6 = 2;
            }
        }
        zzlc zzg2 = zzae.zzg(i6);
        this.zzk.zzq(arrayList, zzg, zzfj.zzo(-9223372036854775807L), this.zzah);
        if (!this.zzad.zzb.zza.equals(zzg2.zzb.zza) && !this.zzad.zza.zzo()) {
            z3 = true;
        } else {
            z3 = false;
        }
        zzam(zzg2, 0, 1, z3, 4, zzaa(zzg2), -1, false);
    }

    @Nullable
    public final zzih zzE() {
        zzao();
        return this.zzad.zzf;
    }

    public final /* synthetic */ void zzT(zzkf zzkfVar) {
        long j4;
        boolean z3;
        boolean z4;
        int i4 = this.zzC - zzkfVar.zzb;
        this.zzC = i4;
        boolean z5 = true;
        if (zzkfVar.zzc) {
            this.zzD = zzkfVar.zzd;
            this.zzE = true;
        }
        if (zzkfVar.zze) {
            this.zzF = zzkfVar.zzf;
        }
        if (i4 == 0) {
            zzcw zzcwVar = zzkfVar.zza.zza;
            if (!this.zzad.zza.zzo() && zzcwVar.zzo()) {
                this.zzae = -1;
                this.zzaf = 0L;
            }
            if (!zzcwVar.zzo()) {
                List zzw = ((zzlg) zzcwVar).zzw();
                if (zzw.size() == this.zzo.size()) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                zzdy.zzf(z4);
                for (int i5 = 0; i5 < zzw.size(); i5++) {
                    ((zzjw) this.zzo.get(i5)).zzb = (zzcw) zzw.get(i5);
                }
            }
            if (this.zzE) {
                if (zzkfVar.zza.zzb.equals(this.zzad.zzb) && zzkfVar.zza.zzd == this.zzad.zzr) {
                    z5 = false;
                }
                if (z5) {
                    if (!zzcwVar.zzo() && !zzkfVar.zza.zzb.zzb()) {
                        zzlc zzlcVar = zzkfVar.zza;
                        zzto zztoVar = zzlcVar.zzb;
                        j4 = zzlcVar.zzd;
                        zzac(zzcwVar, zztoVar, j4);
                    } else {
                        j4 = zzkfVar.zza.zzd;
                    }
                } else {
                    j4 = -9223372036854775807L;
                }
                z3 = z5;
            } else {
                j4 = -9223372036854775807L;
                z3 = false;
            }
            this.zzE = false;
            zzam(zzkfVar.zza, 1, this.zzF, z3, this.zzD, j4, -1, false);
        }
    }

    public final /* synthetic */ void zzU(final zzkf zzkfVar) {
        this.zzj.zzh(new Runnable() { // from class: com.google.android.gms.internal.ads.zzjd
            @Override // java.lang.Runnable
            public final void run() {
                zzjx.this.zzT(zzkfVar);
            }
        });
    }

    public final /* synthetic */ void zzV(zzcm zzcmVar) {
        zzcmVar.zza(this.zzH);
    }

    @Override // com.google.android.gms.internal.ads.zzm
    public final void zza(int i4, long j4, int i5, boolean z3) {
        boolean z4;
        zzao();
        if (i4 >= 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        zzdy.zzd(z4);
        this.zzr.zzu();
        zzcw zzcwVar = this.zzad.zza;
        if (!zzcwVar.zzo() && i4 >= zzcwVar.zzc()) {
            return;
        }
        this.zzC++;
        if (zzx()) {
            zzer.zzf("ExoPlayerImpl", "seekTo ignored because an ad is playing");
            zzkf zzkfVar = new zzkf(this.zzad);
            zzkfVar.zza(1);
            this.zzag.zza.zzU(zzkfVar);
            return;
        }
        zzlc zzlcVar = this.zzad;
        int i6 = zzlcVar.zze;
        if (i6 == 3 || (i6 == 4 && !zzcwVar.zzo())) {
            zzlcVar = this.zzad.zzg(2);
        }
        int zzd2 = zzd();
        zzlc zzae = zzae(zzlcVar, zzcwVar, zzad(zzcwVar, i4, j4));
        this.zzk.zzl(zzcwVar, i4, zzfj.zzo(j4));
        zzam(zzae, 0, 1, true, 1, zzaa(zzae), zzd2, false);
    }

    @Override // com.google.android.gms.internal.ads.zzcp
    public final int zzb() {
        zzao();
        if (zzx()) {
            return this.zzad.zzb.zzb;
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzcp
    public final int zzc() {
        zzao();
        if (zzx()) {
            return this.zzad.zzb.zzc;
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzcp
    public final int zzd() {
        zzao();
        int zzX = zzX(this.zzad);
        if (zzX == -1) {
            return 0;
        }
        return zzX;
    }

    @Override // com.google.android.gms.internal.ads.zzcp
    public final int zze() {
        zzao();
        if (this.zzad.zza.zzo()) {
            return 0;
        }
        zzlc zzlcVar = this.zzad;
        return zzlcVar.zza.zza(zzlcVar.zzb.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzcp
    public final int zzf() {
        zzao();
        return this.zzad.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzcp
    public final int zzg() {
        zzao();
        return this.zzad.zzm;
    }

    @Override // com.google.android.gms.internal.ads.zzcp
    public final int zzh() {
        zzao();
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzcp
    public final long zzi() {
        zzao();
        if (zzx()) {
            zzlc zzlcVar = this.zzad;
            if (zzlcVar.zzk.equals(zzlcVar.zzb)) {
                return zzfj.zzq(this.zzad.zzp);
            }
            return zzl();
        }
        zzao();
        if (this.zzad.zza.zzo()) {
            return this.zzaf;
        }
        zzlc zzlcVar2 = this.zzad;
        long j4 = 0;
        if (zzlcVar2.zzk.zzd != zzlcVar2.zzb.zzd) {
            return zzfj.zzq(zzlcVar2.zza.zze(zzd(), this.zza, 0L).zzn);
        }
        long j5 = zzlcVar2.zzp;
        if (this.zzad.zzk.zzb()) {
            zzlc zzlcVar3 = this.zzad;
            zzlcVar3.zza.zzn(zzlcVar3.zzk.zza, this.zzn).zzi(this.zzad.zzk.zzb);
        } else {
            j4 = j5;
        }
        zzlc zzlcVar4 = this.zzad;
        zzac(zzlcVar4.zza, zzlcVar4.zzk, j4);
        return zzfj.zzq(j4);
    }

    @Override // com.google.android.gms.internal.ads.zzcp
    public final long zzj() {
        zzao();
        return zzZ(this.zzad);
    }

    @Override // com.google.android.gms.internal.ads.zzcp
    public final long zzk() {
        zzao();
        return zzfj.zzq(zzaa(this.zzad));
    }

    @Override // com.google.android.gms.internal.ads.zzcp
    public final long zzl() {
        zzao();
        if (!zzx()) {
            zzcw zzn = zzn();
            if (zzn.zzo()) {
                return -9223372036854775807L;
            }
            return zzfj.zzq(zzn.zze(zzd(), this.zza, 0L).zzn);
        }
        zzlc zzlcVar = this.zzad;
        zzto zztoVar = zzlcVar.zzb;
        zzlcVar.zza.zzn(zztoVar.zza, this.zzn);
        return zzfj.zzq(this.zzn.zzh(zztoVar.zzb, zztoVar.zzc));
    }

    @Override // com.google.android.gms.internal.ads.zzcp
    public final long zzm() {
        zzao();
        return zzfj.zzq(this.zzad.zzq);
    }

    @Override // com.google.android.gms.internal.ads.zzcp
    public final zzcw zzn() {
        zzao();
        return this.zzad.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzcp
    public final zzdh zzo() {
        zzao();
        return this.zzad.zzi.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzcp
    public final void zzp() {
        zzao();
        boolean zzv = zzv();
        int i4 = 2;
        int zzb = this.zzy.zzb(zzv, 2);
        zzal(zzv, zzb, zzY(zzv, zzb));
        zzlc zzlcVar = this.zzad;
        if (zzlcVar.zze != 1) {
            return;
        }
        zzlc zzf = zzlcVar.zzf(null);
        if (true == zzf.zza.zzo()) {
            i4 = 4;
        }
        zzlc zzg = zzf.zzg(i4);
        this.zzC++;
        this.zzk.zzk();
        zzam(zzg, 1, 1, false, 5, -9223372036854775807L, -1, false);
    }

    @Override // com.google.android.gms.internal.ads.zzcp
    public final void zzq() {
        AudioTrack audioTrack;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        String str = zzfj.zze;
        String zza = zzbq.zza();
        zzer.zze("ExoPlayerImpl", "Release " + hexString + " [AndroidXMedia3/1.1.0-beta01] [" + str + "] [" + zza + "]");
        zzao();
        if (zzfj.zza < 21 && (audioTrack = this.zzM) != null) {
            audioTrack.release();
            this.zzM = null;
        }
        this.zzy.zzd();
        if (!this.zzk.zzp()) {
            zzeo zzeoVar = this.zzl;
            zzeoVar.zzd(10, new zzel() { // from class: com.google.android.gms.internal.ads.zzje
                @Override // com.google.android.gms.internal.ads.zzel
                public final void zza(Object obj) {
                    ((zzcm) obj).zzj(zzih.zzd(new zzki(1), 1003));
                }
            });
            zzeoVar.zzc();
        }
        this.zzl.zze();
        this.zzj.zze(null);
        this.zzt.zzf(this.zzr);
        zzlc zzlcVar = this.zzad;
        if (zzlcVar.zzo) {
            this.zzad = zzlcVar.zzb();
        }
        zzlc zzg = this.zzad.zzg(1);
        this.zzad = zzg;
        zzlc zzc = zzg.zzc(zzg.zzb);
        this.zzad = zzc;
        zzc.zzp = zzc.zzr;
        this.zzad.zzq = 0L;
        this.zzr.zzN();
        this.zzi.zzi();
        Surface surface = this.zzO;
        if (surface != null) {
            surface.release();
            this.zzO = null;
        }
        this.zzX = zzdx.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzcp
    public final void zzr(boolean z3) {
        zzao();
        int zzb = this.zzy.zzb(z3, zzf());
        zzal(z3, zzb, zzY(z3, zzb));
    }

    @Override // com.google.android.gms.internal.ads.zzcp
    public final void zzs(@Nullable Surface surface) {
        int i4;
        zzao();
        zzaj(surface);
        if (surface == null) {
            i4 = 0;
        } else {
            i4 = -1;
        }
        zzag(i4, i4);
    }

    @Override // com.google.android.gms.internal.ads.zzcp
    public final void zzt(float f4) {
        zzao();
        final float max = Math.max(0.0f, Math.min(f4, 1.0f));
        if (this.zzV == max) {
            return;
        }
        this.zzV = max;
        zzai();
        zzeo zzeoVar = this.zzl;
        zzeoVar.zzd(22, new zzel() { // from class: com.google.android.gms.internal.ads.zzjg
            @Override // com.google.android.gms.internal.ads.zzel
            public final void zza(Object obj) {
                float f5 = max;
                int i4 = zzjx.zzd;
                ((zzcm) obj).zzs(f5);
            }
        });
        zzeoVar.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzcp
    public final void zzu() {
        zzao();
        this.zzy.zzb(zzv(), 1);
        zzak(null);
        this.zzX = new zzdx(zzfsc.zzl(), this.zzad.zzr);
    }

    @Override // com.google.android.gms.internal.ads.zzcp
    public final boolean zzv() {
        zzao();
        return this.zzad.zzl;
    }

    @Override // com.google.android.gms.internal.ads.zzcp
    public final boolean zzw() {
        zzao();
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzcp
    public final boolean zzx() {
        zzao();
        return this.zzad.zzb.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzis
    public final int zzy() {
        zzao();
        int length = this.zzh.length;
        return 2;
    }

    @Override // com.google.android.gms.internal.ads.zzis
    public final void zzz(zzlv zzlvVar) {
        this.zzr.zzt(zzlvVar);
    }
}
