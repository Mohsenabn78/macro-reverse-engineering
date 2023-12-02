package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.SystemClock;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.facebook.stetho.dumpapp.Framer;
import com.google.android.gms.wearable.WearableStatusCodes;
import com.google.common.base.Ascii;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public abstract class zzrw extends zzhy {
    private static final byte[] zzb = {0, 0, 1, 103, 66, -64, Ascii.VT, -38, 37, -112, 0, 0, 1, 104, -50, Ascii.SI, 19, 32, 0, 0, 1, 101, -120, -124, Ascii.CR, -50, 113, Ascii.CAN, -96, 0, 47, -65, Ascii.FS, Framer.STDOUT_FRAME_PREFIX, -61, 39, 93, Framer.EXIT_FRAME_PREFIX};
    @Nullable
    private zzru zzA;
    @Nullable
    private zzrs zzB;
    private int zzC;
    private boolean zzD;
    private boolean zzE;
    private boolean zzF;
    private boolean zzG;
    private boolean zzH;
    private boolean zzI;
    private boolean zzJ;
    private boolean zzK;
    private boolean zzL;
    @Nullable
    private zzrk zzM;
    private long zzN;
    private int zzO;
    private int zzP;
    @Nullable
    private ByteBuffer zzQ;
    private boolean zzR;
    private boolean zzS;
    private boolean zzT;
    private boolean zzU;
    private boolean zzV;
    private boolean zzW;
    private int zzX;
    private int zzY;
    private int zzZ;
    protected zzhz zza;
    private boolean zzaa;
    private boolean zzab;
    private boolean zzac;
    private long zzad;
    private long zzae;
    private boolean zzaf;
    private boolean zzag;
    private boolean zzah;
    private zzrv zzai;
    private long zzaj;
    private boolean zzak;
    @Nullable
    private zzqv zzal;
    @Nullable
    private zzqv zzam;
    private final zzro zzc;
    private final zzry zzd;
    private final float zze;
    private final zzhp zzf;
    private final zzhp zzg;
    private final zzhp zzh;
    private final zzrj zzi;
    private final ArrayList zzj;
    private final MediaCodec.BufferInfo zzk;
    private final ArrayDeque zzl;
    private final zzqg zzm;
    @Nullable
    private zzam zzn;
    @Nullable
    private zzam zzo;
    @Nullable
    private MediaCrypto zzp;
    private boolean zzq;
    private long zzr;
    private float zzs;
    private float zzt;
    @Nullable
    private zzrp zzu;
    @Nullable
    private zzam zzv;
    @Nullable
    private MediaFormat zzw;
    private boolean zzx;
    private float zzy;
    @Nullable
    private ArrayDeque zzz;

    public zzrw(int i4, zzro zzroVar, zzry zzryVar, boolean z3, float f4) {
        super(i4);
        this.zzc = zzroVar;
        zzryVar.getClass();
        this.zzd = zzryVar;
        this.zze = f4;
        this.zzf = new zzhp(0, 0);
        this.zzg = new zzhp(0, 0);
        this.zzh = new zzhp(2, 0);
        zzrj zzrjVar = new zzrj();
        this.zzi = zzrjVar;
        this.zzj = new ArrayList();
        this.zzk = new MediaCodec.BufferInfo();
        this.zzs = 1.0f;
        this.zzt = 1.0f;
        this.zzr = -9223372036854775807L;
        this.zzl = new ArrayDeque();
        zzaG(zzrv.zza);
        zzrjVar.zzj(0);
        zzrjVar.zzb.order(ByteOrder.nativeOrder());
        this.zzm = new zzqg();
        this.zzy = -1.0f;
        this.zzC = 0;
        this.zzX = 0;
        this.zzO = -1;
        this.zzP = -1;
        this.zzN = -9223372036854775807L;
        this.zzad = -9223372036854775807L;
        this.zzae = -9223372036854775807L;
        this.zzaj = -9223372036854775807L;
        this.zzY = 0;
        this.zzZ = 0;
    }

    private final void zzW() {
        this.zzV = false;
        this.zzi.zzb();
        this.zzh.zzb();
        this.zzU = false;
        this.zzT = false;
        this.zzm.zzb();
    }

    private final void zzX() throws zzih {
        if (this.zzaa) {
            this.zzY = 1;
            this.zzZ = 3;
            return;
        }
        zzat();
        zzar();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean zzaB(zzam zzamVar) {
        if (zzamVar.zzF != 0) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:160:0x034f, code lost:
        if ("stvm8".equals(r5) == false) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x035f, code lost:
        if ("OMX.amlogic.avc.decoder.awesome.secure".equals(r2) == false) goto L131;
     */
    /* JADX WARN: Removed duplicated region for block: B:128:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0300  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0321  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0332  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0367  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0376  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x03c3  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x042b  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x0439  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void zzaC(com.google.android.gms.internal.ads.zzrs r21, @androidx.annotation.Nullable android.media.MediaCrypto r22) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 1128
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzrw.zzaC(com.google.android.gms.internal.ads.zzrs, android.media.MediaCrypto):void");
    }

    @TargetApi(23)
    private final void zzaD() throws zzih {
        int i4 = this.zzZ;
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3) {
                    this.zzag = true;
                    zzai();
                    return;
                }
                zzat();
                zzar();
                return;
            }
            zzae();
            zzaH();
            return;
        }
        zzae();
    }

    private final void zzaE() {
        this.zzO = -1;
        this.zzg.zzb = null;
    }

    private final void zzaF() {
        this.zzP = -1;
        this.zzQ = null;
    }

    private final void zzaG(zzrv zzrvVar) {
        this.zzai = zzrvVar;
        if (zzrvVar.zzc != -9223372036854775807L) {
            this.zzak = true;
        }
    }

    @RequiresApi(23)
    private final void zzaH() throws zzih {
        this.zzal = this.zzam;
        this.zzY = 0;
        this.zzZ = 0;
    }

    @TargetApi(23)
    private final boolean zzaI() throws zzih {
        if (this.zzaa) {
            this.zzY = 1;
            if (!this.zzE && !this.zzG) {
                this.zzZ = 2;
            } else {
                this.zzZ = 3;
                return false;
            }
        } else {
            zzaH();
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    private final boolean zzaJ() throws zzih {
        zzrp zzrpVar = this.zzu;
        boolean z3 = 0;
        if (zzrpVar == null || this.zzY == 2 || this.zzaf) {
            return false;
        }
        if (this.zzO < 0) {
            int zza = zzrpVar.zza();
            this.zzO = zza;
            if (zza < 0) {
                return false;
            }
            this.zzg.zzb = this.zzu.zzf(zza);
            this.zzg.zzb();
        }
        if (this.zzY == 1) {
            if (!this.zzL) {
                this.zzab = true;
                this.zzu.zzj(this.zzO, 0, 0, 0L, 4);
                zzaE();
            }
            this.zzY = 2;
            return false;
        } else if (this.zzJ) {
            this.zzJ = false;
            this.zzg.zzb.put(zzb);
            this.zzu.zzj(this.zzO, 0, 38, 0L, 0);
            zzaE();
            this.zzaa = true;
            return true;
        } else {
            if (this.zzX == 1) {
                for (int i4 = 0; i4 < this.zzv.zzo.size(); i4++) {
                    this.zzg.zzb.put((byte[]) this.zzv.zzo.get(i4));
                }
                this.zzX = 2;
            }
            int position = this.zzg.zzb.position();
            zzkj zzh = zzh();
            try {
                int zzbd = zzbd(zzh, this.zzg, 0);
                if (zzJ() || this.zzg.zzi()) {
                    this.zzae = this.zzad;
                }
                if (zzbd == -3) {
                    return false;
                }
                if (zzbd == -5) {
                    if (this.zzX == 2) {
                        this.zzg.zzb();
                        this.zzX = 1;
                    }
                    zzV(zzh);
                    return true;
                }
                zzhp zzhpVar = this.zzg;
                if (zzhpVar.zzg()) {
                    if (this.zzX == 2) {
                        zzhpVar.zzb();
                        this.zzX = 1;
                    }
                    this.zzaf = true;
                    if (!this.zzaa) {
                        zzaD();
                        return false;
                    }
                    try {
                        if (!this.zzL) {
                            this.zzab = true;
                            this.zzu.zzj(this.zzO, 0, 0, 0L, 4);
                            zzaE();
                        }
                        return false;
                    } catch (MediaCodec.CryptoException e4) {
                        throw zzbe(e4, this.zzn, false, zzfj.zzh(e4.getErrorCode()));
                    }
                } else if (!this.zzaa && !zzhpVar.zzh()) {
                    zzhpVar.zzb();
                    if (this.zzX == 2) {
                        this.zzX = 1;
                    }
                    return true;
                } else {
                    boolean zzl = zzhpVar.zzl();
                    if (zzl) {
                        zzhpVar.zza.zzb(position);
                    }
                    if (this.zzD && !zzl) {
                        ByteBuffer byteBuffer = this.zzg.zzb;
                        byte[] bArr = zzfu.zza;
                        int position2 = byteBuffer.position();
                        int i5 = 0;
                        int i6 = 0;
                        while (true) {
                            int i7 = i5 + 1;
                            if (i7 < position2) {
                                int i8 = byteBuffer.get(i5) & 255;
                                if (i6 == 3) {
                                    if (i8 == 1) {
                                        if ((byteBuffer.get(i7) & Ascii.US) == 7) {
                                            ByteBuffer duplicate = byteBuffer.duplicate();
                                            duplicate.position(i5 - 3);
                                            duplicate.limit(position2);
                                            byteBuffer.position(0);
                                            byteBuffer.put(duplicate);
                                            break;
                                        }
                                        i8 = 1;
                                    }
                                } else if (i8 == 0) {
                                    i6++;
                                }
                                if (i8 != 0) {
                                    i6 = 0;
                                }
                                i5 = i7;
                            } else {
                                byteBuffer.clear();
                                break;
                            }
                        }
                        if (this.zzg.zzb.position() == 0) {
                            return true;
                        }
                        this.zzD = false;
                    }
                    zzhp zzhpVar2 = this.zzg;
                    long j4 = zzhpVar2.zzd;
                    zzrk zzrkVar = this.zzM;
                    if (zzrkVar != null) {
                        j4 = zzrkVar.zzb(this.zzn, zzhpVar2);
                        this.zzad = Math.max(this.zzad, this.zzM.zza(this.zzn));
                    }
                    long j5 = j4;
                    if (this.zzg.zzf()) {
                        this.zzj.add(Long.valueOf(j5));
                    }
                    if (this.zzah) {
                        if (!this.zzl.isEmpty()) {
                            ((zzrv) this.zzl.peekLast()).zzd.zzd(j5, this.zzn);
                        } else {
                            this.zzai.zzd.zzd(j5, this.zzn);
                        }
                        this.zzah = false;
                    }
                    this.zzad = Math.max(this.zzad, j5);
                    this.zzg.zzk();
                    zzhp zzhpVar3 = this.zzg;
                    if (zzhpVar3.zze()) {
                        zzaq(zzhpVar3);
                    }
                    zzah(this.zzg);
                    try {
                        if (zzl) {
                            this.zzu.zzk(this.zzO, 0, this.zzg.zza, j5, 0);
                        } else {
                            this.zzu.zzj(this.zzO, 0, this.zzg.zzb.limit(), j5, 0);
                        }
                        zzaE();
                        this.zzaa = true;
                        this.zzX = 0;
                        zzhz zzhzVar = this.zza;
                        z3 = zzhzVar.zzc + 1;
                        zzhzVar.zzc = z3;
                        return true;
                    } catch (MediaCodec.CryptoException e5) {
                        throw zzbe(e5, this.zzn, z3, zzfj.zzh(e5.getErrorCode()));
                    }
                }
            } catch (zzho e6) {
                zzaa(e6);
                zzaL(0);
                zzae();
                return true;
            }
        }
    }

    private final boolean zzaK() {
        if (this.zzP >= 0) {
            return true;
        }
        return false;
    }

    private final boolean zzaL(int i4) throws zzih {
        zzkj zzh = zzh();
        this.zzf.zzb();
        int zzbd = zzbd(zzh, this.zzf, i4 | 4);
        if (zzbd == -5) {
            zzV(zzh);
            return true;
        } else if (zzbd == -4 && this.zzf.zzg()) {
            this.zzaf = true;
            zzaD();
            return false;
        } else {
            return false;
        }
    }

    private final boolean zzaM(long j4) {
        if (this.zzr != -9223372036854775807L && SystemClock.elapsedRealtime() - j4 >= this.zzr) {
            return false;
        }
        return true;
    }

    private final boolean zzaN(zzam zzamVar) throws zzih {
        if (zzfj.zza >= 23 && this.zzu != null && this.zzZ != 3 && zzbc() != 0) {
            float zzS = zzS(this.zzt, zzamVar, zzM());
            float f4 = this.zzy;
            if (f4 == zzS) {
                return true;
            }
            if (zzS == -1.0f) {
                zzX();
                return false;
            } else if (f4 == -1.0f && zzS <= this.zze) {
                return true;
            } else {
                Bundle bundle = new Bundle();
                bundle.putFloat("operating-rate", zzS);
                this.zzu.zzp(bundle);
                this.zzy = zzS;
            }
        }
        return true;
    }

    private final void zzae() {
        try {
            this.zzu.zzi();
        } finally {
            zzau();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhy, com.google.android.gms.internal.ads.zzli
    public void zzG(float f4, float f5) throws zzih {
        this.zzs = f4;
        this.zzt = f5;
        zzaN(this.zzv);
    }

    /* JADX WARN: Code restructure failed: missing block: B:154:0x027f, code lost:
        if (r15.zzo != null) goto L213;
     */
    /* JADX WARN: Removed duplicated region for block: B:181:0x030e  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x032f A[LOOP:2: B:79:0x0150->B:189:0x032f, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:193:0x033f A[Catch: IllegalStateException -> 0x0370, TryCatch #2 {IllegalStateException -> 0x0370, blocks: (B:186:0x0328, B:191:0x0339, B:193:0x033f, B:195:0x0345, B:182:0x0310, B:184:0x0322, B:202:0x0356), top: B:240:0x0143 }] */
    /* JADX WARN: Removed duplicated region for block: B:215:0x037e  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x038a  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x0336 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:278:0x032e A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r13v7, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r13v8 */
    @Override // com.google.android.gms.internal.ads.zzli
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzO(long r24, long r26) throws com.google.android.gms.internal.ads.zzih {
        /*
            Method dump skipped, instructions count: 962
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzrw.zzO(long, long):void");
    }

    @Override // com.google.android.gms.internal.ads.zzli
    public boolean zzP() {
        return this.zzag;
    }

    @Override // com.google.android.gms.internal.ads.zzli
    public boolean zzQ() {
        if (this.zzn == null) {
            return false;
        }
        if (!zzL() && !zzaK()) {
            if (this.zzN == -9223372036854775807L || SystemClock.elapsedRealtime() >= this.zzN) {
                return false;
            }
            return true;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzlk
    public final int zzR(zzam zzamVar) throws zzih {
        try {
            return zzT(this.zzd, zzamVar);
        } catch (zzsf e4) {
            throw zzbe(e4, zzamVar, false, WearableStatusCodes.UNKNOWN_LISTENER);
        }
    }

    protected float zzS(float f4, zzam zzamVar, zzam[] zzamVarArr) {
        throw null;
    }

    protected abstract int zzT(zzry zzryVar, zzam zzamVar) throws zzsf;

    protected zzia zzU(zzrs zzrsVar, zzam zzamVar, zzam zzamVar2) {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0060, code lost:
        if (zzaI() == false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x008c, code lost:
        if (zzaI() == false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00a0, code lost:
        if (zzaI() == false) goto L31;
     */
    @androidx.annotation.Nullable
    @androidx.annotation.CallSuper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.google.android.gms.internal.ads.zzia zzV(com.google.android.gms.internal.ads.zzkj r12) throws com.google.android.gms.internal.ads.zzih {
        /*
            Method dump skipped, instructions count: 243
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzrw.zzV(com.google.android.gms.internal.ads.zzkj):com.google.android.gms.internal.ads.zzia");
    }

    protected abstract zzrn zzY(zzrs zzrsVar, zzam zzamVar, @Nullable MediaCrypto mediaCrypto, float f4);

    protected abstract List zzZ(zzry zzryVar, zzam zzamVar, boolean z3) throws zzsf;

    protected boolean zzaA(zzrs zzrsVar) {
        return true;
    }

    protected void zzaa(Exception exc) {
        throw null;
    }

    protected void zzab(String str, zzrn zzrnVar, long j4, long j5) {
        throw null;
    }

    protected void zzac(String str) {
        throw null;
    }

    protected void zzad(zzam zzamVar, @Nullable MediaFormat mediaFormat) throws zzih {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @CallSuper
    public void zzaf(long j4) {
        this.zzaj = j4;
        while (!this.zzl.isEmpty() && j4 >= ((zzrv) this.zzl.peek()).zzb) {
            zzaG((zzrv) this.zzl.poll());
            zzag();
        }
    }

    protected void zzah(zzhp zzhpVar) throws zzih {
        throw null;
    }

    protected abstract boolean zzaj(long j4, long j5, @Nullable zzrp zzrpVar, @Nullable ByteBuffer byteBuffer, int i4, int i5, int i6, long j6, boolean z3, boolean z4, zzam zzamVar) throws zzih;

    protected boolean zzak(zzam zzamVar) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final float zzal() {
        return this.zzs;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long zzam() {
        return this.zzai.zzc;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final zzrp zzan() {
        return this.zzu;
    }

    protected zzrq zzao(Throwable th, @Nullable zzrs zzrsVar) {
        return new zzrq(th, zzrsVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final zzrs zzap() {
        return this.zzB;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00e2 A[Catch: zzru -> 0x0105, TryCatch #1 {zzru -> 0x0105, blocks: (B:25:0x0051, B:28:0x0056, B:30:0x006c, B:31:0x0077, B:36:0x0086, B:38:0x008e, B:39:0x0096, B:41:0x009a, B:52:0x00c2, B:54:0x00e2, B:56:0x00eb, B:59:0x00f4, B:60:0x00f6, B:55:0x00e5, B:61:0x00f7, B:63:0x00fa, B:64:0x0104, B:34:0x007b, B:35:0x0085, B:44:0x00a9, B:49:0x00b2, B:50:0x00c0), top: B:71:0x0051, inners: #0, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00e5 A[Catch: zzru -> 0x0105, TryCatch #1 {zzru -> 0x0105, blocks: (B:25:0x0051, B:28:0x0056, B:30:0x006c, B:31:0x0077, B:36:0x0086, B:38:0x008e, B:39:0x0096, B:41:0x009a, B:52:0x00c2, B:54:0x00e2, B:56:0x00eb, B:59:0x00f4, B:60:0x00f6, B:55:0x00e5, B:61:0x00f7, B:63:0x00fa, B:64:0x0104, B:34:0x007b, B:35:0x0085, B:44:0x00a9, B:49:0x00b2, B:50:0x00c0), top: B:71:0x0051, inners: #0, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00f4 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzar() throws com.google.android.gms.internal.ads.zzih {
        /*
            Method dump skipped, instructions count: 272
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzrw.zzar():void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.ads.zzrp, android.media.MediaCrypto, com.google.android.gms.internal.ads.zzqv] */
    public final void zzat() {
        try {
            zzrp zzrpVar = this.zzu;
            if (zzrpVar != null) {
                zzrpVar.zzl();
                this.zza.zzb++;
                zzac(this.zzB.zza);
            }
        } finally {
            this.zzu = null;
            this.zzp = null;
            this.zzal = null;
            zzav();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @CallSuper
    public void zzau() {
        zzaE();
        zzaF();
        this.zzN = -9223372036854775807L;
        this.zzab = false;
        this.zzaa = false;
        this.zzJ = false;
        this.zzK = false;
        this.zzR = false;
        this.zzS = false;
        this.zzj.clear();
        this.zzad = -9223372036854775807L;
        this.zzae = -9223372036854775807L;
        this.zzaj = -9223372036854775807L;
        zzrk zzrkVar = this.zzM;
        if (zzrkVar != null) {
            zzrkVar.zzc();
        }
        this.zzY = 0;
        this.zzZ = 0;
        this.zzX = this.zzW ? 1 : 0;
    }

    @CallSuper
    protected final void zzav() {
        zzau();
        this.zzM = null;
        this.zzz = null;
        this.zzB = null;
        this.zzv = null;
        this.zzw = null;
        this.zzx = false;
        this.zzac = false;
        this.zzy = -1.0f;
        this.zzC = 0;
        this.zzD = false;
        this.zzE = false;
        this.zzF = false;
        this.zzG = false;
        this.zzH = false;
        this.zzI = false;
        this.zzL = false;
        this.zzW = false;
        this.zzX = 0;
        this.zzq = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean zzaw() throws zzih {
        boolean zzax = zzax();
        if (zzax) {
            zzar();
        }
        return zzax;
    }

    protected final boolean zzax() {
        boolean z3;
        if (this.zzu == null) {
            return false;
        }
        int i4 = this.zzZ;
        if (i4 != 3 && !this.zzE && ((!this.zzF || this.zzac) && (!this.zzG || !this.zzab))) {
            if (i4 == 2) {
                int i5 = zzfj.zza;
                if (i5 >= 23) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                zzdy.zzf(z3);
                if (i5 >= 23) {
                    try {
                        zzaH();
                    } catch (zzih e4) {
                        zzer.zzg("MediaCodecRenderer", "Failed to update the DRM session, releasing the codec instead.", e4);
                        zzat();
                        return true;
                    }
                }
            }
            zzae();
            return false;
        }
        zzat();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean zzay() {
        return this.zzT;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean zzaz(zzam zzamVar) {
        if (this.zzam == null && zzak(zzamVar)) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzhy, com.google.android.gms.internal.ads.zzlk
    public final int zze() {
        return 8;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzhy
    public void zzt() {
        this.zzn = null;
        zzaG(zzrv.zza);
        this.zzl.clear();
        zzax();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzhy
    public void zzu(boolean z3, boolean z4) throws zzih {
        this.zza = new zzhz();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzhy
    public void zzv(long j4, boolean z3) throws zzih {
        this.zzaf = false;
        this.zzag = false;
        if (this.zzT) {
            this.zzi.zzb();
            this.zzh.zzb();
            this.zzU = false;
        } else {
            zzaw();
        }
        zzfg zzfgVar = this.zzai.zzd;
        if (zzfgVar.zza() > 0) {
            this.zzah = true;
        }
        zzfgVar.zze();
        this.zzl.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzhy
    public void zzw() {
        try {
            zzW();
            zzat();
        } finally {
            this.zzam = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0037, code lost:
        if (r5 >= r1) goto L14;
     */
    @Override // com.google.android.gms.internal.ads.zzhy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final void zzz(com.google.android.gms.internal.ads.zzam[] r16, long r17, long r19) throws com.google.android.gms.internal.ads.zzih {
        /*
            r15 = this;
            r0 = r15
            com.google.android.gms.internal.ads.zzrv r1 = r0.zzai
            long r1 = r1.zzc
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 != 0) goto L21
            com.google.android.gms.internal.ads.zzrv r1 = new com.google.android.gms.internal.ads.zzrv
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r6 = r1
            r9 = r17
            r11 = r19
            r6.<init>(r7, r9, r11)
            r15.zzaG(r1)
            return
        L21:
            java.util.ArrayDeque r1 = r0.zzl
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L57
            long r1 = r0.zzad
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L39
            long r5 = r0.zzaj
            int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r7 == 0) goto L57
            int r7 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r7 < 0) goto L57
        L39:
            com.google.android.gms.internal.ads.zzrv r1 = new com.google.android.gms.internal.ads.zzrv
            r9 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r8 = r1
            r11 = r17
            r13 = r19
            r8.<init>(r9, r11, r13)
            r15.zzaG(r1)
            com.google.android.gms.internal.ads.zzrv r1 = r0.zzai
            long r1 = r1.zzc
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L56
            r15.zzag()
        L56:
            return
        L57:
            java.util.ArrayDeque r1 = r0.zzl
            com.google.android.gms.internal.ads.zzrv r9 = new com.google.android.gms.internal.ads.zzrv
            long r3 = r0.zzad
            r2 = r9
            r5 = r17
            r7 = r19
            r2.<init>(r3, r5, r7)
            r1.add(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzrw.zzz(com.google.android.gms.internal.ads.zzam[], long, long):void");
    }

    protected void zzag() {
    }

    protected void zzai() throws zzih {
    }

    protected void zzaq(zzhp zzhpVar) throws zzih {
    }

    protected void zzas(zzam zzamVar) throws zzih {
    }
}
