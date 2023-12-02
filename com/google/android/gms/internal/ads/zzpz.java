package com.google.android.gms.internal.ads;

import android.media.AudioDeviceInfo;
import android.media.AudioTrack;
import android.os.SystemClock;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.concurrent.ExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzpz implements zzoz {
    private static final Object zza = new Object();
    @Nullable
    @GuardedBy("releaseExecutorLock")
    private static ExecutorService zzb;
    @GuardedBy("releaseExecutorLock")
    private static int zzc;
    private long zzA;
    private long zzB;
    private long zzC;
    private long zzD;
    private int zzE;
    private boolean zzF;
    private boolean zzG;
    private long zzH;
    private float zzI;
    @Nullable
    private ByteBuffer zzJ;
    private int zzK;
    @Nullable
    private ByteBuffer zzL;
    private byte[] zzM;
    private int zzN;
    private boolean zzO;
    private boolean zzP;
    private boolean zzQ;
    private boolean zzR;
    private int zzS;
    private zzl zzT;
    @Nullable
    private zzpl zzU;
    private long zzV;
    private boolean zzW;
    private boolean zzX;
    private final zzpp zzY;
    private final zzph zzZ;
    private final zzpe zzd;
    private final zzqj zze;
    private final zzfsc zzf;
    private final zzfsc zzg;
    private final zzeb zzh;
    private final zzpd zzi;
    private final ArrayDeque zzj;
    private zzpx zzk;
    private final zzps zzl;
    private final zzps zzm;
    private final zzpm zzn;
    @Nullable
    private zzoc zzo;
    @Nullable
    private zzow zzp;
    @Nullable
    private zzpo zzq;
    private zzpo zzr;
    private zzdo zzs;
    @Nullable
    private AudioTrack zzt;
    private zzoe zzu;
    private zzk zzv;
    @Nullable
    private zzpr zzw;
    private zzpr zzx;
    private zzch zzy;
    private boolean zzz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzpz(zzpn zzpnVar, zzpy zzpyVar) {
        zzoe zzoeVar;
        zzpp zzppVar;
        zzpm zzpmVar;
        zzph zzphVar;
        zzoeVar = zzpnVar.zza;
        this.zzu = zzoeVar;
        zzppVar = zzpnVar.zzd;
        this.zzY = zzppVar;
        int i4 = zzfj.zza;
        zzpmVar = zzpnVar.zzc;
        this.zzn = zzpmVar;
        zzphVar = zzpnVar.zze;
        zzphVar.getClass();
        this.zzZ = zzphVar;
        zzeb zzebVar = new zzeb(zzdz.zza);
        this.zzh = zzebVar;
        zzebVar.zze();
        this.zzi = new zzpd(new zzpu(this, null));
        zzpe zzpeVar = new zzpe();
        this.zzd = zzpeVar;
        zzqj zzqjVar = new zzqj();
        this.zze = zzqjVar;
        this.zzf = zzfsc.zzo(new zzdv(), zzpeVar, zzqjVar);
        this.zzg = zzfsc.zzm(new zzqi());
        this.zzI = 1.0f;
        this.zzv = zzk.zza;
        this.zzS = 0;
        this.zzT = new zzl(0, 0.0f);
        zzch zzchVar = zzch.zza;
        this.zzx = new zzpr(zzchVar, 0L, 0L, null);
        this.zzy = zzchVar;
        this.zzz = false;
        this.zzj = new ArrayDeque();
        this.zzl = new zzps(100L);
        this.zzm = new zzps(100L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzD(AudioTrack audioTrack, zzeb zzebVar) {
        try {
            audioTrack.flush();
            audioTrack.release();
            zzebVar.zze();
            synchronized (zza) {
                int i4 = zzc - 1;
                zzc = i4;
                if (i4 == 0) {
                    zzb.shutdown();
                    zzb = null;
                }
            }
        } catch (Throwable th) {
            zzebVar.zze();
            synchronized (zza) {
                int i5 = zzc - 1;
                zzc = i5;
                if (i5 == 0) {
                    zzb.shutdown();
                    zzb = null;
                }
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long zzF() {
        zzpo zzpoVar = this.zzr;
        if (zzpoVar.zzc == 0) {
            return this.zzA / zzpoVar.zzb;
        }
        return this.zzB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long zzG() {
        zzpo zzpoVar = this.zzr;
        if (zzpoVar.zzc == 0) {
            return this.zzC / zzpoVar.zzd;
        }
        return this.zzD;
    }

    private final AudioTrack zzH(zzpo zzpoVar) throws zzov {
        try {
            return zzpoVar.zzb(false, this.zzv, this.zzS);
        } catch (zzov e4) {
            zzow zzowVar = this.zzp;
            if (zzowVar != null) {
                zzowVar.zza(e4);
            }
            throw e4;
        }
    }

    private final void zzI(long j4) {
        zzch zzchVar;
        boolean z3;
        zzos zzosVar;
        if (zzS()) {
            zzpp zzppVar = this.zzY;
            zzchVar = this.zzy;
            zzppVar.zzc(zzchVar);
        } else {
            zzchVar = zzch.zza;
        }
        zzch zzchVar2 = zzchVar;
        this.zzy = zzchVar2;
        if (zzS()) {
            zzpp zzppVar2 = this.zzY;
            z3 = this.zzz;
            zzppVar2.zzd(z3);
        } else {
            z3 = false;
        }
        this.zzz = z3;
        this.zzj.add(new zzpr(zzchVar2, Math.max(0L, j4), this.zzr.zza(zzG()), null));
        zzN();
        zzow zzowVar = this.zzp;
        if (zzowVar != null) {
            boolean z4 = this.zzz;
            zzosVar = ((zzqe) zzowVar).zza.zzc;
            zzosVar.zzs(z4);
        }
    }

    private final void zzJ() {
        if (!this.zzP) {
            this.zzP = true;
            this.zzi.zzc(zzG());
            this.zzt.stop();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0026, code lost:
        r0 = r2.zzJ;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0028, code lost:
        if (r0 == null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002e, code lost:
        if (r0.hasRemaining() != false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0031, code lost:
        r2.zzs.zze(r2.zzJ);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0039, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:?, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void zzK(long r3) throws com.google.android.gms.internal.ads.zzoy {
        /*
            r2 = this;
            com.google.android.gms.internal.ads.zzdo r0 = r2.zzs
            boolean r0 = r0.zzh()
            if (r0 == 0) goto L3a
        L8:
            com.google.android.gms.internal.ads.zzdo r0 = r2.zzs
            boolean r0 = r0.zzg()
            if (r0 != 0) goto L39
        L10:
            com.google.android.gms.internal.ads.zzdo r0 = r2.zzs
            java.nio.ByteBuffer r0 = r0.zzb()
            boolean r1 = r0.hasRemaining()
            if (r1 == 0) goto L26
            r2.zzO(r0, r3)
            boolean r0 = r0.hasRemaining()
            if (r0 == 0) goto L10
            return
        L26:
            java.nio.ByteBuffer r0 = r2.zzJ
            if (r0 == 0) goto L39
            boolean r0 = r0.hasRemaining()
            if (r0 != 0) goto L31
            goto L39
        L31:
            com.google.android.gms.internal.ads.zzdo r0 = r2.zzs
            java.nio.ByteBuffer r1 = r2.zzJ
            r0.zze(r1)
            goto L8
        L39:
            return
        L3a:
            java.nio.ByteBuffer r0 = r2.zzJ
            if (r0 != 0) goto L40
            java.nio.ByteBuffer r0 = com.google.android.gms.internal.ads.zzdr.zza
        L40:
            r2.zzO(r0, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzpz.zzK(long):void");
    }

    private final void zzL(zzch zzchVar) {
        zzpr zzprVar = new zzpr(zzchVar, -9223372036854775807L, -9223372036854775807L, null);
        if (zzQ()) {
            this.zzw = zzprVar;
        } else {
            this.zzx = zzprVar;
        }
    }

    private final void zzM() {
        if (!zzQ()) {
            return;
        }
        if (zzfj.zza >= 21) {
            this.zzt.setVolume(this.zzI);
            return;
        }
        AudioTrack audioTrack = this.zzt;
        float f4 = this.zzI;
        audioTrack.setStereoVolume(f4, f4);
    }

    private final void zzN() {
        zzdo zzdoVar = this.zzr.zzi;
        this.zzs = zzdoVar;
        zzdoVar.zzc();
    }

    private final void zzO(ByteBuffer byteBuffer, long j4) throws zzoy {
        int write;
        zzow zzowVar;
        zzlh zzlhVar;
        zzlh zzlhVar2;
        boolean z3;
        if (!byteBuffer.hasRemaining()) {
            return;
        }
        ByteBuffer byteBuffer2 = this.zzL;
        boolean z4 = true;
        if (byteBuffer2 != null) {
            if (byteBuffer2 == byteBuffer) {
                z3 = true;
            } else {
                z3 = false;
            }
            zzdy.zzd(z3);
        } else {
            this.zzL = byteBuffer;
            if (zzfj.zza < 21) {
                int remaining = byteBuffer.remaining();
                byte[] bArr = this.zzM;
                if (bArr == null || bArr.length < remaining) {
                    this.zzM = new byte[remaining];
                }
                int position = byteBuffer.position();
                byteBuffer.get(this.zzM, 0, remaining);
                byteBuffer.position(position);
                this.zzN = 0;
            }
        }
        int remaining2 = byteBuffer.remaining();
        int i4 = zzfj.zza;
        if (i4 < 21) {
            int zza2 = this.zzi.zza(this.zzC);
            if (zza2 > 0) {
                write = this.zzt.write(this.zzM, this.zzN, Math.min(remaining2, zza2));
                if (write > 0) {
                    this.zzN += write;
                    byteBuffer.position(byteBuffer.position() + write);
                }
            } else {
                write = 0;
            }
        } else {
            write = this.zzt.write(byteBuffer, remaining2, 1);
        }
        this.zzV = SystemClock.elapsedRealtime();
        if (write < 0) {
            zzoy zzoyVar = new zzoy(write, this.zzr.zza, (((i4 < 24 || write != -6) && write != -32) || this.zzD <= 0) ? false : false);
            zzow zzowVar2 = this.zzp;
            if (zzowVar2 != null) {
                zzowVar2.zza(zzoyVar);
            }
            if (!zzoyVar.zzb) {
                this.zzm.zzb(zzoyVar);
                return;
            } else {
                this.zzu = zzoe.zza;
                throw zzoyVar;
            }
        }
        this.zzm.zza();
        if (zzR(this.zzt)) {
            if (this.zzD > 0) {
                this.zzX = false;
            }
            if (this.zzQ && (zzowVar = this.zzp) != null && write < remaining2) {
                zzqf zzqfVar = ((zzqe) zzowVar).zza;
                zzlhVar = zzqfVar.zzm;
                if (zzlhVar != null) {
                    zzlhVar2 = zzqfVar.zzm;
                    zzlhVar2.zza();
                }
            }
        }
        int i5 = this.zzr.zzc;
        if (i5 == 0) {
            this.zzC += write;
        }
        if (write == remaining2) {
            if (i5 != 0) {
                if (byteBuffer != this.zzJ) {
                    z4 = false;
                }
                zzdy.zzf(z4);
                this.zzD += this.zzE * this.zzK;
            }
            this.zzL = null;
        }
    }

    private final boolean zzP() throws zzoy {
        if (!this.zzs.zzh()) {
            ByteBuffer byteBuffer = this.zzL;
            if (byteBuffer == null) {
                return true;
            }
            zzO(byteBuffer, Long.MIN_VALUE);
            if (this.zzL != null) {
                return false;
            }
            return true;
        }
        this.zzs.zzd();
        zzK(Long.MIN_VALUE);
        if (!this.zzs.zzg()) {
            return false;
        }
        ByteBuffer byteBuffer2 = this.zzL;
        if (byteBuffer2 != null && byteBuffer2.hasRemaining()) {
            return false;
        }
        return true;
    }

    private final boolean zzQ() {
        if (this.zzt != null) {
            return true;
        }
        return false;
    }

    private static boolean zzR(AudioTrack audioTrack) {
        boolean isOffloadedPlayback;
        if (zzfj.zza >= 29) {
            isOffloadedPlayback = audioTrack.isOffloadedPlayback();
            if (isOffloadedPlayback) {
                return true;
            }
            return false;
        }
        return false;
    }

    private final boolean zzS() {
        zzpo zzpoVar = this.zzr;
        if (zzpoVar.zzc == 0) {
            int i4 = zzpoVar.zza.zzB;
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzoz
    public final int zza(zzam zzamVar) {
        if ("audio/raw".equals(zzamVar.zzm)) {
            if (!zzfj.zzD(zzamVar.zzB)) {
                int i4 = zzamVar.zzB;
                zzer.zzf("DefaultAudioSink", "Invalid PCM encoding: " + i4);
                return 0;
            } else if (zzamVar.zzB == 2) {
                return 2;
            } else {
                return 1;
            }
        } else if (this.zzu.zza(zzamVar) == null) {
            return 0;
        } else {
            return 2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzoz
    public final long zzb(boolean z3) {
        long zzm;
        if (zzQ() && !this.zzG) {
            long min = Math.min(this.zzi.zzb(z3), this.zzr.zza(zzG()));
            while (!this.zzj.isEmpty() && min >= ((zzpr) this.zzj.getFirst()).zzc) {
                this.zzx = (zzpr) this.zzj.remove();
            }
            zzpr zzprVar = this.zzx;
            long j4 = min - zzprVar.zzc;
            if (zzprVar.zza.equals(zzch.zza)) {
                zzm = this.zzx.zzb + j4;
            } else if (this.zzj.isEmpty()) {
                zzm = this.zzY.zza(j4) + this.zzx.zzb;
            } else {
                zzpr zzprVar2 = (zzpr) this.zzj.getFirst();
                zzm = zzprVar2.zzb - zzfj.zzm(zzprVar2.zzc - min, this.zzx.zza.zzc);
            }
            return zzm + this.zzr.zza(this.zzY.zzb());
        }
        return Long.MIN_VALUE;
    }

    @Override // com.google.android.gms.internal.ads.zzoz
    public final zzch zzc() {
        return this.zzy;
    }

    @Override // com.google.android.gms.internal.ads.zzoz
    public final zzoh zzd(zzam zzamVar) {
        if (this.zzW) {
            return zzoh.zza;
        }
        return this.zzZ.zza(zzamVar, this.zzv);
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0165  */
    @Override // com.google.android.gms.internal.ads.zzoz
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zze(com.google.android.gms.internal.ads.zzam r19, int r20, @androidx.annotation.Nullable int[] r21) throws com.google.android.gms.internal.ads.zzou {
        /*
            Method dump skipped, instructions count: 442
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzpz.zze(com.google.android.gms.internal.ads.zzam, int, int[]):void");
    }

    @Override // com.google.android.gms.internal.ads.zzoz
    public final void zzf() {
        if (zzQ()) {
            this.zzA = 0L;
            this.zzB = 0L;
            this.zzC = 0L;
            this.zzD = 0L;
            this.zzX = false;
            this.zzE = 0;
            this.zzx = new zzpr(this.zzy, 0L, 0L, null);
            this.zzH = 0L;
            this.zzw = null;
            this.zzj.clear();
            this.zzJ = null;
            this.zzK = 0;
            this.zzL = null;
            this.zzP = false;
            this.zzO = false;
            this.zze.zzp();
            zzN();
            if (this.zzi.zzh()) {
                this.zzt.pause();
            }
            if (zzR(this.zzt)) {
                zzpx zzpxVar = this.zzk;
                zzpxVar.getClass();
                zzpxVar.zzb(this.zzt);
            }
            if (zzfj.zza < 21 && !this.zzR) {
                this.zzS = 0;
            }
            zzpo zzpoVar = this.zzq;
            if (zzpoVar != null) {
                this.zzr = zzpoVar;
                this.zzq = null;
            }
            this.zzi.zzd();
            final AudioTrack audioTrack = this.zzt;
            final zzeb zzebVar = this.zzh;
            zzebVar.zzc();
            synchronized (zza) {
                if (zzb == null) {
                    zzb = zzfj.zzA("ExoPlayer:AudioTrackReleaseThread");
                }
                zzc++;
                zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzpi
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzpz.zzD(audioTrack, zzebVar);
                    }
                });
            }
            this.zzt = null;
        }
        this.zzm.zza();
        this.zzl.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzoz
    public final void zzg() {
        this.zzF = true;
    }

    @Override // com.google.android.gms.internal.ads.zzoz
    public final void zzh() {
        this.zzQ = false;
        if (zzQ() && this.zzi.zzk()) {
            this.zzt.pause();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzoz
    public final void zzi() {
        this.zzQ = true;
        if (zzQ()) {
            this.zzi.zzf();
            this.zzt.play();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzoz
    public final void zzj() throws zzoy {
        if (!this.zzO && zzQ() && zzP()) {
            zzJ();
            this.zzO = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzoz
    public final void zzk() {
        zzf();
        zzfsc zzfscVar = this.zzf;
        int size = zzfscVar.size();
        for (int i4 = 0; i4 < size; i4++) {
            ((zzdr) zzfscVar.get(i4)).zzf();
        }
        zzfsc zzfscVar2 = this.zzg;
        int size2 = zzfscVar2.size();
        for (int i5 = 0; i5 < size2; i5++) {
            ((zzdr) zzfscVar2.get(i5)).zzf();
        }
        zzdo zzdoVar = this.zzs;
        if (zzdoVar != null) {
            zzdoVar.zzf();
        }
        this.zzQ = false;
        this.zzW = false;
    }

    @Override // com.google.android.gms.internal.ads.zzoz
    public final void zzl(zzk zzkVar) {
        if (this.zzv.equals(zzkVar)) {
            return;
        }
        this.zzv = zzkVar;
        zzf();
    }

    @Override // com.google.android.gms.internal.ads.zzoz
    public final void zzm(int i4) {
        boolean z3;
        if (this.zzS != i4) {
            this.zzS = i4;
            if (i4 != 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            this.zzR = z3;
            zzf();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzoz
    public final void zzn(zzl zzlVar) {
        if (this.zzT.equals(zzlVar)) {
            return;
        }
        int i4 = zzlVar.zza;
        if (this.zzt != null) {
            int i5 = this.zzT.zza;
        }
        this.zzT = zzlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzoz
    public final void zzo(zzow zzowVar) {
        this.zzp = zzowVar;
    }

    @Override // com.google.android.gms.internal.ads.zzoz
    public final void zzp(zzch zzchVar) {
        this.zzy = new zzch(Math.max(0.1f, Math.min(zzchVar.zzc, 8.0f)), Math.max(0.1f, Math.min(zzchVar.zzd, 8.0f)));
        zzL(zzchVar);
    }

    @Override // com.google.android.gms.internal.ads.zzoz
    public final void zzq(@Nullable zzoc zzocVar) {
        this.zzo = zzocVar;
    }

    @Override // com.google.android.gms.internal.ads.zzoz
    @RequiresApi(23)
    public final void zzr(@Nullable AudioDeviceInfo audioDeviceInfo) {
        zzpl zzplVar;
        if (audioDeviceInfo == null) {
            zzplVar = null;
        } else {
            zzplVar = new zzpl(audioDeviceInfo);
        }
        this.zzU = zzplVar;
        AudioTrack audioTrack = this.zzt;
        if (audioTrack != null) {
            zzpj.zza(audioTrack, zzplVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzoz
    public final void zzs(boolean z3) {
        this.zzz = z3;
        zzL(this.zzy);
    }

    @Override // com.google.android.gms.internal.ads.zzoz
    public final void zzt(float f4) {
        if (this.zzI != f4) {
            this.zzI = f4;
            zzM();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:190:0x039e A[Catch: zzov -> 0x03a2, TryCatch #3 {zzov -> 0x03a2, blocks: (B:36:0x0071, B:49:0x00c2, B:51:0x00ca, B:53:0x00d0, B:54:0x00d7, B:55:0x00e0, B:57:0x00e6, B:59:0x00ea, B:60:0x00ef, B:64:0x0105, B:68:0x011d, B:69:0x0122, B:45:0x0086, B:47:0x008f, B:188:0x0396, B:190:0x039e, B:191:0x03a1, B:39:0x007a, B:41:0x007f), top: B:205:0x0071, inners: #0 }] */
    @Override // com.google.android.gms.internal.ads.zzoz
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean zzu(java.nio.ByteBuffer r28, long r29, int r31) throws com.google.android.gms.internal.ads.zzov, com.google.android.gms.internal.ads.zzoy {
        /*
            Method dump skipped, instructions count: 980
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzpz.zzu(java.nio.ByteBuffer, long, int):boolean");
    }

    @Override // com.google.android.gms.internal.ads.zzoz
    public final boolean zzv() {
        if (zzQ() && this.zzi.zzg(zzG())) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzoz
    public final boolean zzw() {
        if (!zzQ()) {
            return true;
        }
        if (this.zzO && !zzv()) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzoz
    public final boolean zzx(zzam zzamVar) {
        if (zza(zzamVar) != 0) {
            return true;
        }
        return false;
    }
}
