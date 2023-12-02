package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.MediaFormat;
import android.os.Handler;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import java.nio.ByteBuffer;
import java.util.List;
import org.joni.constants.internal.StackType;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzqf extends zzrw implements zzkl {
    private final Context zzb;
    private final zzos zzc;
    private final zzoz zzd;
    private int zze;
    private boolean zzf;
    @Nullable
    private zzam zzg;
    @Nullable
    private zzam zzh;
    private long zzi;
    private boolean zzj;
    private boolean zzk;
    private boolean zzl;
    @Nullable
    private zzlh zzm;

    public zzqf(Context context, zzro zzroVar, zzry zzryVar, boolean z3, @Nullable Handler handler, @Nullable zzot zzotVar, zzoz zzozVar) {
        super(1, zzroVar, zzryVar, false, 44100.0f);
        this.zzb = context.getApplicationContext();
        this.zzd = zzozVar;
        this.zzc = new zzos(handler, zzotVar);
        zzozVar.zzo(new zzqe(this, null));
    }

    private final int zzaC(zzrs zzrsVar, zzam zzamVar) {
        int i4;
        if ("OMX.google.raw.decoder".equals(zzrsVar.zza) && (i4 = zzfj.zza) < 24 && (i4 != 23 || !zzfj.zzE(this.zzb))) {
            return -1;
        }
        return zzamVar.zzn;
    }

    private static List zzaD(zzry zzryVar, zzam zzamVar, boolean z3, zzoz zzozVar) throws zzsf {
        zzrs zzd;
        if (zzamVar.zzm == null) {
            return zzfsc.zzl();
        }
        if (zzozVar.zzx(zzamVar) && (zzd = zzsl.zzd()) != null) {
            return zzfsc.zzm(zzd);
        }
        return zzsl.zzh(zzryVar, zzamVar, false, false);
    }

    private final void zzaE() {
        long zzb = this.zzd.zzb(zzP());
        if (zzb != Long.MIN_VALUE) {
            if (!this.zzk) {
                zzb = Math.max(this.zzi, zzb);
            }
            this.zzi = zzb;
            this.zzk = false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzli, com.google.android.gms.internal.ads.zzlk
    public final String zzN() {
        return "MediaCodecAudioRenderer";
    }

    @Override // com.google.android.gms.internal.ads.zzrw, com.google.android.gms.internal.ads.zzli
    public final boolean zzP() {
        if (super.zzP() && this.zzd.zzw()) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzrw, com.google.android.gms.internal.ads.zzli
    public final boolean zzQ() {
        if (!this.zzd.zzv() && !super.zzQ()) {
            return false;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzrw
    protected final float zzS(float f4, zzam zzamVar, zzam[] zzamVarArr) {
        int i4 = -1;
        for (zzam zzamVar2 : zzamVarArr) {
            int i5 = zzamVar2.zzA;
            if (i5 != -1) {
                i4 = Math.max(i4, i5);
            }
        }
        if (i4 == -1) {
            return -1.0f;
        }
        return i4 * f4;
    }

    @Override // com.google.android.gms.internal.ads.zzrw
    protected final int zzT(zzry zzryVar, zzam zzamVar) throws zzsf {
        int i4;
        int i5;
        boolean z3;
        int i6;
        int i7;
        int i8;
        int i9 = 128;
        if (!zzcc.zzf(zzamVar.zzm)) {
            return 128;
        }
        if (zzfj.zza >= 21) {
            i4 = 32;
        } else {
            i4 = 0;
        }
        int i10 = zzamVar.zzF;
        boolean zzaB = zzrw.zzaB(zzamVar);
        if (zzaB && (i10 == 0 || zzsl.zzd() != null)) {
            zzoh zzd = this.zzd.zzd(zzamVar);
            if (!zzd.zzb) {
                i5 = 0;
            } else {
                if (true != zzd.zzc) {
                    i5 = 512;
                } else {
                    i5 = StackType.STOP_BT;
                }
                if (zzd.zzd) {
                    i5 |= 2048;
                }
            }
            if (this.zzd.zzx(zzamVar)) {
                i8 = i4 | 140;
                return i8 | i5;
            }
        } else {
            i5 = 0;
        }
        if (("audio/raw".equals(zzamVar.zzm) && !this.zzd.zzx(zzamVar)) || !this.zzd.zzx(zzfj.zzv(2, zzamVar.zzz, zzamVar.zzA))) {
            return 129;
        }
        List zzaD = zzaD(zzryVar, zzamVar, false, this.zzd);
        if (zzaD.isEmpty()) {
            return 129;
        }
        if (!zzaB) {
            return 130;
        }
        zzrs zzrsVar = (zzrs) zzaD.get(0);
        boolean zze = zzrsVar.zze(zzamVar);
        if (!zze) {
            for (int i11 = 1; i11 < zzaD.size(); i11++) {
                zzrs zzrsVar2 = (zzrs) zzaD.get(i11);
                if (zzrsVar2.zze(zzamVar)) {
                    zzrsVar = zzrsVar2;
                    z3 = false;
                    zze = true;
                    break;
                }
            }
        }
        z3 = true;
        if (true != zze) {
            i6 = 3;
        } else {
            i6 = 4;
        }
        int i12 = 8;
        if (zze && zzrsVar.zzf(zzamVar)) {
            i12 = 16;
        }
        if (true != zzrsVar.zzg) {
            i7 = 0;
        } else {
            i7 = 64;
        }
        if (true != z3) {
            i9 = 0;
        }
        i8 = i6 | i12 | i4 | i7 | i9;
        return i8 | i5;
    }

    @Override // com.google.android.gms.internal.ads.zzrw
    protected final zzia zzU(zzrs zzrsVar, zzam zzamVar, zzam zzamVar2) {
        int i4;
        int i5;
        zzia zzb = zzrsVar.zzb(zzamVar, zzamVar2);
        int i6 = zzb.zze;
        if (zzaz(zzamVar2)) {
            i6 |= 32768;
        }
        if (zzaC(zzrsVar, zzamVar2) > this.zze) {
            i6 |= 64;
        }
        String str = zzrsVar.zza;
        if (i6 != 0) {
            i5 = i6;
            i4 = 0;
        } else {
            i4 = zzb.zzd;
            i5 = 0;
        }
        return new zzia(str, zzamVar, zzamVar2, i4, i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzrw
    @Nullable
    public final zzia zzV(zzkj zzkjVar) throws zzih {
        zzam zzamVar = zzkjVar.zza;
        zzamVar.getClass();
        this.zzg = zzamVar;
        zzia zzV = super.zzV(zzkjVar);
        this.zzc.zzg(this.zzg, zzV);
        return zzV;
    }

    /* JADX WARN: Code restructure failed: missing block: B:91:0x00a8, code lost:
        if ("AXON 7 mini".equals(r10) == false) goto L34;
     */
    /* JADX WARN: Removed duplicated region for block: B:104:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x008b  */
    @Override // com.google.android.gms.internal.ads.zzrw
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final com.google.android.gms.internal.ads.zzrn zzY(com.google.android.gms.internal.ads.zzrs r8, com.google.android.gms.internal.ads.zzam r9, @androidx.annotation.Nullable android.media.MediaCrypto r10, float r11) {
        /*
            Method dump skipped, instructions count: 259
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzqf.zzY(com.google.android.gms.internal.ads.zzrs, com.google.android.gms.internal.ads.zzam, android.media.MediaCrypto, float):com.google.android.gms.internal.ads.zzrn");
    }

    @Override // com.google.android.gms.internal.ads.zzrw
    protected final List zzZ(zzry zzryVar, zzam zzamVar, boolean z3) throws zzsf {
        return zzsl.zzi(zzaD(zzryVar, zzamVar, false, this.zzd), zzamVar);
    }

    @Override // com.google.android.gms.internal.ads.zzkl
    public final long zza() {
        if (zzbc() == 2) {
            zzaE();
        }
        return this.zzi;
    }

    @Override // com.google.android.gms.internal.ads.zzrw
    protected final void zzaa(Exception exc) {
        zzer.zzd("MediaCodecAudioRenderer", "Audio codec error", exc);
        this.zzc.zza(exc);
    }

    @Override // com.google.android.gms.internal.ads.zzrw
    protected final void zzab(String str, zzrn zzrnVar, long j4, long j5) {
        this.zzc.zzc(str, j4, j5);
    }

    @Override // com.google.android.gms.internal.ads.zzrw
    protected final void zzac(String str) {
        this.zzc.zzd(str);
    }

    @Override // com.google.android.gms.internal.ads.zzrw
    protected final void zzad(zzam zzamVar, @Nullable MediaFormat mediaFormat) throws zzih {
        int i4;
        int i5;
        boolean z3;
        zzam zzamVar2 = this.zzh;
        int[] iArr = null;
        if (zzamVar2 != null) {
            zzamVar = zzamVar2;
        } else if (zzan() != null) {
            if ("audio/raw".equals(zzamVar.zzm)) {
                i4 = zzamVar.zzB;
            } else if (zzfj.zza >= 24 && mediaFormat.containsKey("pcm-encoding")) {
                i4 = mediaFormat.getInteger("pcm-encoding");
            } else if (mediaFormat.containsKey("v-bits-per-sample")) {
                i4 = zzfj.zzj(mediaFormat.getInteger("v-bits-per-sample"));
            } else {
                i4 = 2;
            }
            zzak zzakVar = new zzak();
            zzakVar.zzS("audio/raw");
            zzakVar.zzN(i4);
            zzakVar.zzC(zzamVar.zzC);
            zzakVar.zzD(zzamVar.zzD);
            zzakVar.zzw(mediaFormat.getInteger("channel-count"));
            zzakVar.zzT(mediaFormat.getInteger("sample-rate"));
            zzam zzY = zzakVar.zzY();
            if (this.zzf && zzY.zzz == 6 && (i5 = zzamVar.zzz) < 6) {
                iArr = new int[i5];
                for (int i6 = 0; i6 < zzamVar.zzz; i6++) {
                    iArr[i6] = i6;
                }
            }
            zzamVar = zzY;
        }
        try {
            int i7 = zzfj.zza;
            if (i7 >= 29) {
                if (zzay()) {
                    zzk();
                }
                if (i7 >= 29) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                zzdy.zzf(z3);
            }
            this.zzd.zze(zzamVar, 0, iArr);
        } catch (zzou e4) {
            throw zzbe(e4, e4.zza, false, 5001);
        }
    }

    @CallSuper
    public final void zzae() {
        this.zzk = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzrw
    @CallSuper
    public final void zzaf(long j4) {
        super.zzaf(j4);
        this.zzj = false;
    }

    @Override // com.google.android.gms.internal.ads.zzrw
    protected final void zzag() {
        this.zzd.zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzrw
    protected final void zzah(zzhp zzhpVar) {
        if (this.zzj && !zzhpVar.zzf()) {
            if (Math.abs(zzhpVar.zzd - this.zzi) > 500000) {
                this.zzi = zzhpVar.zzd;
            }
            this.zzj = false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzrw
    protected final void zzai() throws zzih {
        try {
            this.zzd.zzj();
        } catch (zzoy e4) {
            throw zzbe(e4, e4.zzc, e4.zzb, 5002);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzrw
    protected final boolean zzaj(long j4, long j5, @Nullable zzrp zzrpVar, @Nullable ByteBuffer byteBuffer, int i4, int i5, int i6, long j6, boolean z3, boolean z4, zzam zzamVar) throws zzih {
        byteBuffer.getClass();
        if (this.zzh != null && (i5 & 2) != 0) {
            zzrpVar.getClass();
            zzrpVar.zzn(i4, false);
            return true;
        } else if (z3) {
            if (zzrpVar != null) {
                zzrpVar.zzn(i4, false);
            }
            ((zzrw) this).zza.zzf += i6;
            this.zzd.zzg();
            return true;
        } else {
            try {
                if (!this.zzd.zzu(byteBuffer, j6, i6)) {
                    return false;
                }
                if (zzrpVar != null) {
                    zzrpVar.zzn(i4, false);
                }
                ((zzrw) this).zza.zze += i6;
                return true;
            } catch (zzov e4) {
                throw zzbe(e4, this.zzg, e4.zzb, 5001);
            } catch (zzoy e5) {
                throw zzbe(e5, zzamVar, e5.zzb, 5002);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzrw
    protected final boolean zzak(zzam zzamVar) {
        zzk();
        return this.zzd.zzx(zzamVar);
    }

    @Override // com.google.android.gms.internal.ads.zzkl
    public final zzch zzc() {
        return this.zzd.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzkl
    public final void zzg(zzch zzchVar) {
        this.zzd.zzp(zzchVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhy, com.google.android.gms.internal.ads.zzle
    public final void zzq(int i4, @Nullable Object obj) throws zzih {
        if (i4 != 2) {
            if (i4 != 3) {
                if (i4 != 6) {
                    switch (i4) {
                        case 9:
                            this.zzd.zzs(((Boolean) obj).booleanValue());
                            return;
                        case 10:
                            this.zzd.zzm(((Integer) obj).intValue());
                            return;
                        case 11:
                            this.zzm = (zzlh) obj;
                            return;
                        case 12:
                            if (zzfj.zza >= 23) {
                                zzqc.zza(this.zzd, obj);
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                }
                this.zzd.zzn((zzl) obj);
                return;
            }
            this.zzd.zzl((zzk) obj);
            return;
        }
        this.zzd.zzt(((Float) obj).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzrw, com.google.android.gms.internal.ads.zzhy
    public final void zzt() {
        this.zzl = true;
        this.zzg = null;
        try {
            this.zzd.zzf();
            try {
                super.zzt();
            } finally {
            }
        } catch (Throwable th) {
            try {
                super.zzt();
                throw th;
            } finally {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzrw, com.google.android.gms.internal.ads.zzhy
    public final void zzu(boolean z3, boolean z4) throws zzih {
        super.zzu(z3, z4);
        this.zzc.zzf(((zzrw) this).zza);
        zzk();
        this.zzd.zzq(zzl());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzrw, com.google.android.gms.internal.ads.zzhy
    public final void zzv(long j4, boolean z3) throws zzih {
        super.zzv(j4, z3);
        this.zzd.zzf();
        this.zzi = j4;
        this.zzj = true;
        this.zzk = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzrw, com.google.android.gms.internal.ads.zzhy
    public final void zzw() {
        try {
            super.zzw();
            if (this.zzl) {
                this.zzl = false;
                this.zzd.zzk();
            }
        } catch (Throwable th) {
            if (this.zzl) {
                this.zzl = false;
                this.zzd.zzk();
            }
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhy
    protected final void zzx() {
        this.zzd.zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzhy
    protected final void zzy() {
        zzaE();
        this.zzd.zzh();
    }

    @Override // com.google.android.gms.internal.ads.zzhy, com.google.android.gms.internal.ads.zzli
    @Nullable
    public final zzkl zzi() {
        return this;
    }
}
