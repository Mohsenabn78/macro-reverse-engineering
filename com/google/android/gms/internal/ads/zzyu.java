package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaCodecInfo;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.os.Trace;
import android.view.Surface;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.nio.ByteBuffer;
import java.util.List;
import org.jetbrains.anko.DimensionsKt;
import org.joni.constants.internal.StackType;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzyu extends zzrw {
    private static final int[] zzb = {1920, 1600, 1440, StackType.POS, 960, 854, DimensionsKt.XXXHDPI, 540, DimensionsKt.XXHDPI};
    private static boolean zzc;
    private static boolean zzd;
    private long zzA;
    private long zzB;
    private int zzC;
    private long zzD;
    private zzdn zzE;
    @Nullable
    private zzdn zzF;
    private int zzG;
    @Nullable
    private zzyy zzH;
    private final Context zze;
    private final zzzf zzf;
    private final zzzq zzg;
    private final zzyt zzh;
    private final boolean zzi;
    private zzym zzj;
    private boolean zzk;
    private boolean zzl;
    @Nullable
    private Surface zzm;
    @Nullable
    private zzyx zzn;
    private boolean zzo;
    private int zzp;
    private boolean zzq;
    private boolean zzr;
    private boolean zzs;
    private long zzt;
    private long zzu;
    private long zzv;
    private int zzw;
    private int zzx;
    private int zzy;
    private long zzz;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzyu(Context context, zzro zzroVar, zzry zzryVar, long j4, boolean z3, @Nullable Handler handler, @Nullable zzzr zzzrVar, int i4, float f4) {
        super(2, zzroVar, zzryVar, false, 30.0f);
        zzyp zzypVar = new zzyp(null);
        Context applicationContext = context.getApplicationContext();
        this.zze = applicationContext;
        zzzf zzzfVar = new zzzf(applicationContext);
        this.zzf = zzzfVar;
        this.zzg = new zzzq(handler, zzzrVar);
        this.zzh = new zzyt(zzypVar, zzzfVar, this);
        this.zzi = "NVIDIA".equals(zzfj.zzc);
        this.zzu = -9223372036854775807L;
        this.zzp = 1;
        this.zzE = zzdn.zza;
        this.zzG = 0;
        this.zzF = null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0072, code lost:
        if (r3.equals("video/av01") != false) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int zzW(com.google.android.gms.internal.ads.zzrs r10, com.google.android.gms.internal.ads.zzam r11) {
        /*
            Method dump skipped, instructions count: 262
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzyu.zzW(com.google.android.gms.internal.ads.zzrs, com.google.android.gms.internal.ads.zzam):int");
    }

    protected static int zzX(zzrs zzrsVar, zzam zzamVar) {
        if (zzamVar.zzn != -1) {
            int size = zzamVar.zzo.size();
            int i4 = 0;
            for (int i5 = 0; i5 < size; i5++) {
                i4 += ((byte[]) zzamVar.zzo.get(i5)).length;
            }
            return zzamVar.zzn + i4;
        }
        return zzW(zzrsVar, zzamVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:323:0x04c0, code lost:
        if (r0.equals("deb") != false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:514:0x07a0, code lost:
        if (r10 != 0) goto L19;
     */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0080 A[FALL_THROUGH] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected static final boolean zzaK(java.lang.String r17) {
        /*
            Method dump skipped, instructions count: 2926
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzyu.zzaK(java.lang.String):boolean");
    }

    private static List zzaL(Context context, zzry zzryVar, zzam zzamVar, boolean z3, boolean z4) throws zzsf {
        String str = zzamVar.zzm;
        if (str == null) {
            return zzfsc.zzl();
        }
        if (zzfj.zza >= 26 && "video/dolby-vision".equals(str) && !zzyl.zza(context)) {
            List zzf = zzsl.zzf(zzryVar, zzamVar, z3, z4);
            if (!zzf.isEmpty()) {
                return zzf;
            }
        }
        return zzsl.zzh(zzryVar, zzamVar, z3, z4);
    }

    private final void zzaM(zzdn zzdnVar) {
        if (!zzdnVar.equals(zzdn.zza) && !zzdnVar.equals(this.zzF)) {
            this.zzF = zzdnVar;
            this.zzg.zzt(zzdnVar);
        }
    }

    private final void zzaN() {
        zzdn zzdnVar = this.zzF;
        if (zzdnVar != null) {
            this.zzg.zzt(zzdnVar);
        }
    }

    @RequiresApi(17)
    private final void zzaO() {
        Surface surface = this.zzm;
        zzyx zzyxVar = this.zzn;
        if (surface == zzyxVar) {
            this.zzm = null;
        }
        zzyxVar.release();
        this.zzn = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zzaP() {
        if (zzfj.zza >= 21) {
            return true;
        }
        return false;
    }

    private static boolean zzaQ(long j4) {
        if (j4 < -30000) {
            return true;
        }
        return false;
    }

    private final boolean zzaR(zzrs zzrsVar) {
        if (zzfj.zza < 23 || zzaK(zzrsVar.zza)) {
            return false;
        }
        if (zzrsVar.zzf && !zzyx.zzb(this.zze)) {
            return false;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzrw, com.google.android.gms.internal.ads.zzhy, com.google.android.gms.internal.ads.zzli
    public final void zzG(float f4, float f5) throws zzih {
        super.zzG(f4, f5);
        this.zzf.zze(f4);
    }

    @Override // com.google.android.gms.internal.ads.zzli, com.google.android.gms.internal.ads.zzlk
    public final String zzN() {
        return "MediaCodecVideoRenderer";
    }

    @Override // com.google.android.gms.internal.ads.zzrw, com.google.android.gms.internal.ads.zzli
    public final boolean zzQ() {
        zzyx zzyxVar;
        if (super.zzQ() && (this.zzq || (((zzyxVar = this.zzn) != null && this.zzm == zzyxVar) || zzan() == null))) {
            this.zzu = -9223372036854775807L;
            return true;
        } else if (this.zzu == -9223372036854775807L) {
            return false;
        } else {
            if (SystemClock.elapsedRealtime() < this.zzu) {
                return true;
            }
            this.zzu = -9223372036854775807L;
            return false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzrw
    protected final float zzS(float f4, zzam zzamVar, zzam[] zzamVarArr) {
        float f5 = -1.0f;
        for (zzam zzamVar2 : zzamVarArr) {
            float f6 = zzamVar2.zzt;
            if (f6 != -1.0f) {
                f5 = Math.max(f5, f6);
            }
        }
        if (f5 == -1.0f) {
            return -1.0f;
        }
        return f5 * f4;
    }

    @Override // com.google.android.gms.internal.ads.zzrw
    protected final int zzT(zzry zzryVar, zzam zzamVar) throws zzsf {
        boolean z3;
        boolean z4;
        int i4;
        int i5;
        int i6;
        int i7 = 128;
        if (!zzcc.zzg(zzamVar.zzm)) {
            return 128;
        }
        int i8 = 0;
        if (zzamVar.zzp != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        List zzaL = zzaL(this.zze, zzryVar, zzamVar, z3, false);
        if (z3 && zzaL.isEmpty()) {
            zzaL = zzaL(this.zze, zzryVar, zzamVar, false, false);
        }
        if (zzaL.isEmpty()) {
            return 129;
        }
        if (!zzrw.zzaB(zzamVar)) {
            return 130;
        }
        zzrs zzrsVar = (zzrs) zzaL.get(0);
        boolean zze = zzrsVar.zze(zzamVar);
        if (!zze) {
            for (int i9 = 1; i9 < zzaL.size(); i9++) {
                zzrs zzrsVar2 = (zzrs) zzaL.get(i9);
                if (zzrsVar2.zze(zzamVar)) {
                    zzrsVar = zzrsVar2;
                    z4 = false;
                    zze = true;
                    break;
                }
            }
        }
        z4 = true;
        if (true != zze) {
            i4 = 3;
        } else {
            i4 = 4;
        }
        if (true != zzrsVar.zzf(zzamVar)) {
            i5 = 8;
        } else {
            i5 = 16;
        }
        if (true != zzrsVar.zzg) {
            i6 = 0;
        } else {
            i6 = 64;
        }
        if (true != z4) {
            i7 = 0;
        }
        if (zzfj.zza >= 26 && "video/dolby-vision".equals(zzamVar.zzm) && !zzyl.zza(this.zze)) {
            i7 = 256;
        }
        if (zze) {
            List zzaL2 = zzaL(this.zze, zzryVar, zzamVar, z3, true);
            if (!zzaL2.isEmpty()) {
                zzrs zzrsVar3 = (zzrs) zzsl.zzi(zzaL2, zzamVar).get(0);
                if (zzrsVar3.zze(zzamVar) && zzrsVar3.zzf(zzamVar)) {
                    i8 = 32;
                }
            }
        }
        return i4 | i5 | i8 | i6 | i7;
    }

    @Override // com.google.android.gms.internal.ads.zzrw
    protected final zzia zzU(zzrs zzrsVar, zzam zzamVar, zzam zzamVar2) {
        int i4;
        int i5;
        zzia zzb2 = zzrsVar.zzb(zzamVar, zzamVar2);
        int i6 = zzb2.zze;
        int i7 = zzamVar2.zzr;
        zzym zzymVar = this.zzj;
        if (i7 > zzymVar.zza || zzamVar2.zzs > zzymVar.zzb) {
            i6 |= 256;
        }
        if (zzX(zzrsVar, zzamVar2) > this.zzj.zzc) {
            i6 |= 64;
        }
        String str = zzrsVar.zza;
        if (i6 != 0) {
            i5 = i6;
            i4 = 0;
        } else {
            i4 = zzb2.zzd;
            i5 = 0;
        }
        return new zzia(str, zzamVar, zzamVar2, i4, i5);
    }

    @Override // com.google.android.gms.internal.ads.zzrw
    @Nullable
    protected final zzia zzV(zzkj zzkjVar) throws zzih {
        zzia zzV = super.zzV(zzkjVar);
        this.zzg.zzf(zzkjVar.zza, zzV);
        return zzV;
    }

    /* JADX WARN: Code restructure failed: missing block: B:67:0x0112, code lost:
        if (true == r12) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0114, code lost:
        r13 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0116, code lost:
        r13 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0117, code lost:
        if (true == r12) goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0119, code lost:
        r4 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x011d, code lost:
        r3 = new android.graphics.Point(r13, r4);
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0208  */
    @Override // com.google.android.gms.internal.ads.zzrw
    @android.annotation.TargetApi(17)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final com.google.android.gms.internal.ads.zzrn zzY(com.google.android.gms.internal.ads.zzrs r20, com.google.android.gms.internal.ads.zzam r21, @androidx.annotation.Nullable android.media.MediaCrypto r22, float r23) {
        /*
            Method dump skipped, instructions count: 594
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzyu.zzY(com.google.android.gms.internal.ads.zzrs, com.google.android.gms.internal.ads.zzam, android.media.MediaCrypto, float):com.google.android.gms.internal.ads.zzrn");
    }

    @Override // com.google.android.gms.internal.ads.zzrw
    protected final List zzZ(zzry zzryVar, zzam zzamVar, boolean z3) throws zzsf {
        return zzsl.zzi(zzaL(this.zze, zzryVar, zzamVar, false, false), zzamVar);
    }

    @Override // com.google.android.gms.internal.ads.zzrw
    protected final boolean zzaA(zzrs zzrsVar) {
        if (this.zzm == null && !zzaR(zzrsVar)) {
            return false;
        }
        return true;
    }

    final void zzaD() {
        this.zzs = true;
        if (!this.zzq) {
            this.zzq = true;
            this.zzg.zzq(this.zzm);
            this.zzo = true;
        }
    }

    protected final void zzaE(zzrp zzrpVar, int i4, long j4) {
        int i5 = zzfj.zza;
        Trace.beginSection("releaseOutputBuffer");
        zzrpVar.zzn(i4, true);
        Trace.endSection();
        ((zzrw) this).zza.zze++;
        this.zzx = 0;
        this.zzA = SystemClock.elapsedRealtime() * 1000;
        zzaM(this.zzE);
        zzaD();
    }

    @RequiresApi(21)
    protected final void zzaF(zzrp zzrpVar, int i4, long j4, long j5) {
        int i5 = zzfj.zza;
        Trace.beginSection("releaseOutputBuffer");
        zzrpVar.zzm(i4, j5);
        Trace.endSection();
        ((zzrw) this).zza.zze++;
        this.zzx = 0;
        this.zzA = SystemClock.elapsedRealtime() * 1000;
        zzaM(this.zzE);
        zzaD();
    }

    protected final void zzaG(zzrp zzrpVar, int i4, long j4) {
        int i5 = zzfj.zza;
        Trace.beginSection("skipVideoBuffer");
        zzrpVar.zzn(i4, false);
        Trace.endSection();
        ((zzrw) this).zza.zzf++;
    }

    protected final void zzaH(int i4, int i5) {
        zzhz zzhzVar = ((zzrw) this).zza;
        zzhzVar.zzh += i4;
        int i6 = i4 + i5;
        zzhzVar.zzg += i6;
        this.zzw += i6;
        int i7 = this.zzx + i6;
        this.zzx = i7;
        zzhzVar.zzi = Math.max(i7, zzhzVar.zzi);
    }

    protected final void zzaI(long j4) {
        zzhz zzhzVar = ((zzrw) this).zza;
        zzhzVar.zzk += j4;
        zzhzVar.zzl++;
        this.zzB += j4;
        this.zzC++;
    }

    @Override // com.google.android.gms.internal.ads.zzrw
    protected final void zzaa(Exception exc) {
        zzer.zzd("MediaCodecVideoRenderer", "Video codec error", exc);
        this.zzg.zzs(exc);
    }

    @Override // com.google.android.gms.internal.ads.zzrw
    protected final void zzab(String str, zzrn zzrnVar, long j4, long j5) {
        this.zzg.zza(str, j4, j5);
        this.zzk = zzaK(str);
        zzrs zzap = zzap();
        zzap.getClass();
        boolean z3 = false;
        if (zzfj.zza >= 29 && "video/x-vnd.on2.vp9".equals(zzap.zzb)) {
            MediaCodecInfo.CodecProfileLevel[] zzh = zzap.zzh();
            int length = zzh.length;
            int i4 = 0;
            while (true) {
                if (i4 >= length) {
                    break;
                } else if (zzh[i4].profile == 16384) {
                    z3 = true;
                    break;
                } else {
                    i4++;
                }
            }
        }
        this.zzl = z3;
        this.zzh.zza(str);
    }

    @Override // com.google.android.gms.internal.ads.zzrw
    protected final void zzac(String str) {
        this.zzg.zzb(str);
    }

    @Override // com.google.android.gms.internal.ads.zzrw
    protected final void zzad(zzam zzamVar, @Nullable MediaFormat mediaFormat) {
        boolean z3;
        int integer;
        int integer2;
        zzrp zzan = zzan();
        if (zzan != null) {
            zzan.zzq(this.zzp);
        }
        mediaFormat.getClass();
        int i4 = 0;
        if (mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top")) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            integer = (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1;
        } else {
            integer = mediaFormat.getInteger("width");
        }
        if (z3) {
            integer2 = (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1;
        } else {
            integer2 = mediaFormat.getInteger("height");
        }
        float f4 = zzamVar.zzv;
        if (zzaP()) {
            int i5 = zzamVar.zzu;
            if (i5 == 90 || i5 == 270) {
                f4 = 1.0f / f4;
                int i6 = integer2;
                integer2 = integer;
                integer = i6;
            }
        } else {
            i4 = zzamVar.zzu;
        }
        this.zzE = new zzdn(integer, integer2, i4, f4);
        this.zzf.zzc(zzamVar.zzt);
    }

    @Override // com.google.android.gms.internal.ads.zzrw
    @CallSuper
    protected final void zzaf(long j4) {
        super.zzaf(j4);
        this.zzy--;
    }

    @Override // com.google.android.gms.internal.ads.zzrw
    protected final void zzag() {
        this.zzq = false;
        int i4 = zzfj.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzrw
    @CallSuper
    protected final void zzah(zzhp zzhpVar) throws zzih {
        this.zzy++;
        int i4 = zzfj.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzrw
    protected final boolean zzaj(long j4, long j5, @Nullable zzrp zzrpVar, @Nullable ByteBuffer byteBuffer, int i4, int i5, int i6, long j6, boolean z3, boolean z4, zzam zzamVar) throws zzih {
        boolean z5;
        boolean z6;
        int zzd2;
        zzrpVar.getClass();
        if (this.zzt == -9223372036854775807L) {
            this.zzt = j4;
        }
        if (j6 != this.zzz) {
            this.zzf.zzd(j6);
            this.zzz = j6;
        }
        long zzam = j6 - zzam();
        if (z3 && !z4) {
            zzaG(zzrpVar, i4, zzam);
            return true;
        }
        int zzbc = zzbc();
        long elapsedRealtime = SystemClock.elapsedRealtime() * 1000;
        long zzal = (long) ((j6 - j4) / zzal());
        if (zzbc == 2) {
            zzal -= elapsedRealtime - j5;
        }
        if (this.zzm == this.zzn) {
            if (!zzaQ(zzal)) {
                return false;
            }
            zzaG(zzrpVar, i4, zzam);
            zzaI(zzal);
            return true;
        }
        int zzbc2 = zzbc();
        boolean z7 = this.zzs;
        if (zzbc2 == 2) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (z7 ? !this.zzq : !(!z5 && !this.zzr)) {
            z6 = true;
        } else {
            z6 = false;
        }
        long elapsedRealtime2 = (SystemClock.elapsedRealtime() * 1000) - this.zzA;
        if (this.zzu == -9223372036854775807L && j4 >= zzam() && (z6 || (z5 && zzaQ(zzal) && elapsedRealtime2 > 100000))) {
            long nanoTime = System.nanoTime();
            if (zzfj.zza >= 21) {
                zzaF(zzrpVar, i4, zzam, nanoTime);
            } else {
                zzaE(zzrpVar, i4, zzam);
            }
            zzaI(zzal);
            return true;
        } else if (zzbc == 2 && j4 != this.zzt) {
            long nanoTime2 = System.nanoTime();
            long zza = this.zzf.zza((zzal * 1000) + nanoTime2);
            long j7 = (zza - nanoTime2) / 1000;
            long j8 = this.zzu;
            if (j7 < -500000 && !z4 && (zzd2 = zzd(j4)) != 0) {
                if (j8 != -9223372036854775807L) {
                    zzhz zzhzVar = ((zzrw) this).zza;
                    zzhzVar.zzd += zzd2;
                    zzhzVar.zzf += this.zzy;
                } else {
                    ((zzrw) this).zza.zzj++;
                    zzaH(zzd2, this.zzy);
                }
                zzaw();
                return false;
            } else if (zzaQ(j7) && !z4) {
                if (j8 != -9223372036854775807L) {
                    zzaG(zzrpVar, i4, zzam);
                } else {
                    int i7 = zzfj.zza;
                    Trace.beginSection("dropVideoBuffer");
                    zzrpVar.zzn(i4, false);
                    Trace.endSection();
                    zzaH(0, 1);
                }
                zzaI(j7);
                return true;
            } else if (zzfj.zza >= 21) {
                if (j7 < 50000) {
                    if (zza == this.zzD) {
                        zzaG(zzrpVar, i4, zzam);
                    } else {
                        zzaF(zzrpVar, i4, zzam, zza);
                    }
                    zzaI(j7);
                    this.zzD = zza;
                    return true;
                }
                return false;
            } else if (j7 < 30000) {
                if (j7 > 11000) {
                    try {
                        Thread.sleep(((-10000) + j7) / 1000);
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        return false;
                    }
                }
                zzaE(zzrpVar, i4, zzam);
                zzaI(j7);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzrw
    protected final zzrq zzao(Throwable th, @Nullable zzrs zzrsVar) {
        return new zzyk(th, zzrsVar, this.zzm);
    }

    @Override // com.google.android.gms.internal.ads.zzrw
    @TargetApi(29)
    protected final void zzaq(zzhp zzhpVar) throws zzih {
        if (!this.zzl) {
            return;
        }
        ByteBuffer byteBuffer = zzhpVar.zze;
        byteBuffer.getClass();
        if (byteBuffer.remaining() >= 7) {
            byte b4 = byteBuffer.get();
            short s3 = byteBuffer.getShort();
            short s4 = byteBuffer.getShort();
            byte b5 = byteBuffer.get();
            byte b6 = byteBuffer.get();
            byteBuffer.position(0);
            if (b4 == -75 && s3 == 60 && s4 == 1 && b5 == 4) {
                if (b6 == 0 || b6 == 1) {
                    byte[] bArr = new byte[byteBuffer.remaining()];
                    byteBuffer.get(bArr);
                    byteBuffer.position(0);
                    zzrp zzan = zzan();
                    Bundle bundle = new Bundle();
                    bundle.putByteArray("hdr10-plus-info", bArr);
                    zzan.zzp(bundle);
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzrw
    @CallSuper
    protected final void zzas(zzam zzamVar) throws zzih {
        this.zzh.zzd(zzamVar, zzam());
    }

    @Override // com.google.android.gms.internal.ads.zzrw
    @CallSuper
    protected final void zzau() {
        super.zzau();
        this.zzy = 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v8, types: [android.view.Surface] */
    @Override // com.google.android.gms.internal.ads.zzhy, com.google.android.gms.internal.ads.zzle
    public final void zzq(int i4, @Nullable Object obj) throws zzih {
        zzyx zzyxVar;
        Surface surface;
        if (i4 != 1) {
            if (i4 != 7) {
                if (i4 != 10) {
                    if (i4 != 4) {
                        if (i4 != 5) {
                            if (i4 != 13) {
                                if (i4 == 14) {
                                    obj.getClass();
                                    zzfb zzfbVar = (zzfb) obj;
                                    if (zzfbVar.zzb() != 0 && zzfbVar.zza() != 0 && (surface = this.zzm) != null) {
                                        this.zzh.zzb(surface, zzfbVar);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            obj.getClass();
                            this.zzh.zzc((List) obj);
                            return;
                        }
                        this.zzf.zzj(((Integer) obj).intValue());
                        return;
                    }
                    int intValue = ((Integer) obj).intValue();
                    this.zzp = intValue;
                    zzrp zzan = zzan();
                    if (zzan != null) {
                        zzan.zzq(intValue);
                        return;
                    }
                    return;
                }
                int intValue2 = ((Integer) obj).intValue();
                if (this.zzG != intValue2) {
                    this.zzG = intValue2;
                    return;
                }
                return;
            }
            this.zzH = (zzyy) obj;
            return;
        }
        if (obj instanceof Surface) {
            zzyxVar = (Surface) obj;
        } else {
            zzyxVar = null;
        }
        if (zzyxVar == null) {
            zzyx zzyxVar2 = this.zzn;
            if (zzyxVar2 != null) {
                zzyxVar = zzyxVar2;
            } else {
                zzrs zzap = zzap();
                if (zzap != null && zzaR(zzap)) {
                    zzyxVar = zzyx.zza(this.zze, zzap.zzf);
                    this.zzn = zzyxVar;
                }
            }
        }
        if (this.zzm != zzyxVar) {
            this.zzm = zzyxVar;
            this.zzf.zzi(zzyxVar);
            this.zzo = false;
            int zzbc = zzbc();
            zzrp zzan2 = zzan();
            if (zzan2 != null) {
                if (zzfj.zza >= 23 && zzyxVar != null && !this.zzk) {
                    zzan2.zzo(zzyxVar);
                } else {
                    zzat();
                    zzar();
                }
            }
            if (zzyxVar != null && zzyxVar != this.zzn) {
                zzaN();
                this.zzq = false;
                int i5 = zzfj.zza;
                if (zzbc == 2) {
                    this.zzu = -9223372036854775807L;
                    return;
                }
                return;
            }
            this.zzF = null;
            this.zzq = false;
            int i6 = zzfj.zza;
        } else if (zzyxVar != null && zzyxVar != this.zzn) {
            zzaN();
            if (this.zzo) {
                this.zzg.zzq(this.zzm);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzrw, com.google.android.gms.internal.ads.zzhy
    protected final void zzt() {
        this.zzF = null;
        this.zzq = false;
        int i4 = zzfj.zza;
        this.zzo = false;
        try {
            super.zzt();
        } finally {
            this.zzg.zzc(((zzrw) this).zza);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzrw, com.google.android.gms.internal.ads.zzhy
    protected final void zzu(boolean z3, boolean z4) throws zzih {
        super.zzu(z3, z4);
        zzk();
        this.zzg.zze(((zzrw) this).zza);
        this.zzr = z4;
        this.zzs = false;
    }

    @Override // com.google.android.gms.internal.ads.zzrw, com.google.android.gms.internal.ads.zzhy
    protected final void zzv(long j4, boolean z3) throws zzih {
        super.zzv(j4, z3);
        this.zzq = false;
        int i4 = zzfj.zza;
        this.zzf.zzf();
        this.zzz = -9223372036854775807L;
        this.zzt = -9223372036854775807L;
        this.zzx = 0;
        this.zzu = -9223372036854775807L;
    }

    @Override // com.google.android.gms.internal.ads.zzrw, com.google.android.gms.internal.ads.zzhy
    @TargetApi(17)
    protected final void zzw() {
        try {
            super.zzw();
            if (this.zzn != null) {
                zzaO();
            }
        } catch (Throwable th) {
            if (this.zzn != null) {
                zzaO();
            }
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhy
    protected final void zzx() {
        this.zzw = 0;
        this.zzv = SystemClock.elapsedRealtime();
        this.zzA = SystemClock.elapsedRealtime() * 1000;
        this.zzB = 0L;
        this.zzC = 0;
        this.zzf.zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzhy
    protected final void zzy() {
        this.zzu = -9223372036854775807L;
        if (this.zzw > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.zzg.zzd(this.zzw, elapsedRealtime - this.zzv);
            this.zzw = 0;
            this.zzv = elapsedRealtime;
        }
        int i4 = this.zzC;
        if (i4 != 0) {
            this.zzg.zzr(this.zzB, i4);
            this.zzB = 0L;
            this.zzC = 0;
        }
        this.zzf.zzh();
    }
}
