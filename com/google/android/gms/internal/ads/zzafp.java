package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.util.SparseArray;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.compose.animation.core.AnimationKt;
import com.android.dx.io.Opcodes;
import com.facebook.stetho.dumpapp.Framer;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzafp implements zzaaw {
    public static final zzabd zza = new zzabd() { // from class: com.google.android.gms.internal.ads.zzafl
        @Override // com.google.android.gms.internal.ads.zzabd
        public final /* synthetic */ zzaaw[] zza(Uri uri, Map map) {
            int i4 = zzabc.zza;
            return new zzaaw[]{new zzafp(0)};
        }
    };
    private static final byte[] zzb = {Framer.STDOUT_FRAME_PREFIX, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, Framer.STDIN_FRAME_PREFIX, Framer.STDIN_FRAME_PREFIX, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
    private static final byte[] zzc;
    private static final byte[] zzd;
    private static final byte[] zze;
    private static final UUID zzf;
    private static final Map zzg;
    private long zzA;
    @Nullable
    private zzafo zzB;
    private boolean zzC;
    private int zzD;
    private long zzE;
    private boolean zzF;
    private long zzG;
    private long zzH;
    private long zzI;
    @Nullable
    private zzes zzJ;
    @Nullable
    private zzes zzK;
    private boolean zzL;
    private boolean zzM;
    private int zzN;
    private long zzO;
    private long zzP;
    private int zzQ;
    private int zzR;
    private int[] zzS;
    private int zzT;
    private int zzU;
    private int zzV;
    private int zzW;
    private boolean zzX;
    private long zzY;
    private int zzZ;
    private int zzaa;
    private int zzab;
    private boolean zzac;
    private boolean zzad;
    private boolean zzae;
    private int zzaf;
    private byte zzag;
    private boolean zzah;
    private zzaaz zzai;
    private final zzafk zzh;
    private final zzafr zzi;
    private final SparseArray zzj;
    private final boolean zzk;
    private final zzfa zzl;
    private final zzfa zzm;
    private final zzfa zzn;
    private final zzfa zzo;
    private final zzfa zzp;
    private final zzfa zzq;
    private final zzfa zzr;
    private final zzfa zzs;
    private final zzfa zzt;
    private final zzfa zzu;
    private ByteBuffer zzv;
    private long zzw;
    private long zzx;
    private long zzy;
    private long zzz;

    static {
        int i4 = zzfj.zza;
        zzc = "Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text".getBytes(zzfot.zzc);
        zzd = new byte[]{68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};
        zze = new byte[]{87, 69, 66, 86, 84, 84, 10, 10, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 32, Framer.STDIN_FRAME_PREFIX, Framer.STDIN_FRAME_PREFIX, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 10};
        zzf = new UUID(72057594037932032L, -9223371306706625679L);
        HashMap hashMap = new HashMap();
        hashMap.put("htc_video_rotA-000", 0);
        hashMap.put("htc_video_rotA-090", 90);
        hashMap.put("htc_video_rotA-180", 180);
        hashMap.put("htc_video_rotA-270", 270);
        zzg = Collections.unmodifiableMap(hashMap);
    }

    public zzafp() {
        this(0);
    }

    @RequiresNonNull({"#2.output"})
    private final int zzn(zzaax zzaaxVar, zzafo zzafoVar, int i4, boolean z3) throws IOException {
        int i5;
        if ("S_TEXT/UTF8".equals(zzafoVar.zzb)) {
            zzv(zzaaxVar, zzb, i4);
            int i6 = this.zzaa;
            zzu();
            return i6;
        } else if ("S_TEXT/ASS".equals(zzafoVar.zzb)) {
            zzv(zzaaxVar, zzd, i4);
            int i7 = this.zzaa;
            zzu();
            return i7;
        } else if ("S_TEXT/WEBVTT".equals(zzafoVar.zzb)) {
            zzv(zzaaxVar, zze, i4);
            int i8 = this.zzaa;
            zzu();
            return i8;
        } else {
            zzabz zzabzVar = zzafoVar.zzV;
            boolean z4 = true;
            if (!this.zzac) {
                if (zzafoVar.zzg) {
                    this.zzV &= -1073741825;
                    int i9 = 128;
                    if (!this.zzad) {
                        ((zzaam) zzaaxVar).zzn(this.zzn.zzH(), 0, 1, false);
                        this.zzZ++;
                        if ((this.zzn.zzH()[0] & 128) != 128) {
                            this.zzag = this.zzn.zzH()[0];
                            this.zzad = true;
                        } else {
                            throw zzcd.zza("Extension bit is set in signal byte", null);
                        }
                    }
                    byte b4 = this.zzag;
                    if ((b4 & 1) == 1) {
                        int i10 = b4 & 2;
                        this.zzV |= 1073741824;
                        if (!this.zzah) {
                            ((zzaam) zzaaxVar).zzn(this.zzs.zzH(), 0, 8, false);
                            this.zzZ += 8;
                            this.zzah = true;
                            byte[] zzH = this.zzn.zzH();
                            if (i10 != 2) {
                                i9 = 0;
                            }
                            zzH[0] = (byte) (i9 | 8);
                            this.zzn.zzF(0);
                            zzabzVar.zzr(this.zzn, 1, 1);
                            this.zzaa++;
                            this.zzs.zzF(0);
                            zzabzVar.zzr(this.zzs, 8, 1);
                            this.zzaa += 8;
                        }
                        if (i10 == 2) {
                            if (!this.zzae) {
                                ((zzaam) zzaaxVar).zzn(this.zzn.zzH(), 0, 1, false);
                                this.zzZ++;
                                this.zzn.zzF(0);
                                this.zzaf = this.zzn.zzk();
                                this.zzae = true;
                            }
                            int i11 = this.zzaf * 4;
                            this.zzn.zzC(i11);
                            ((zzaam) zzaaxVar).zzn(this.zzn.zzH(), 0, i11, false);
                            this.zzZ += i11;
                            int i12 = (this.zzaf >> 1) + 1;
                            int i13 = (i12 * 6) + 2;
                            ByteBuffer byteBuffer = this.zzv;
                            if (byteBuffer == null || byteBuffer.capacity() < i13) {
                                this.zzv = ByteBuffer.allocate(i13);
                            }
                            this.zzv.position(0);
                            this.zzv.putShort((short) i12);
                            int i14 = 0;
                            int i15 = 0;
                            while (true) {
                                i5 = this.zzaf;
                                if (i14 >= i5) {
                                    break;
                                }
                                int zzn = this.zzn.zzn();
                                if (i14 % 2 == 0) {
                                    this.zzv.putShort((short) (zzn - i15));
                                } else {
                                    this.zzv.putInt(zzn - i15);
                                }
                                i14++;
                                i15 = zzn;
                            }
                            int i16 = (i4 - this.zzZ) - i15;
                            if ((i5 & 1) == 1) {
                                this.zzv.putInt(i16);
                            } else {
                                this.zzv.putShort((short) i16);
                                this.zzv.putInt(0);
                            }
                            this.zzt.zzD(this.zzv.array(), i13);
                            zzabzVar.zzr(this.zzt, i13, 1);
                            this.zzaa += i13;
                        }
                    }
                } else {
                    byte[] bArr = zzafoVar.zzh;
                    if (bArr != null) {
                        this.zzq.zzD(bArr, bArr.length);
                    }
                }
                if (!"A_OPUS".equals(zzafoVar.zzb) ? zzafoVar.zzf > 0 : z3) {
                    this.zzV |= 268435456;
                    this.zzu.zzC(0);
                    int zzd2 = (this.zzq.zzd() + i4) - this.zzZ;
                    this.zzn.zzC(4);
                    this.zzn.zzH()[0] = (byte) ((zzd2 >> 24) & 255);
                    this.zzn.zzH()[1] = (byte) ((zzd2 >> 16) & 255);
                    this.zzn.zzH()[2] = (byte) ((zzd2 >> 8) & 255);
                    this.zzn.zzH()[3] = (byte) (zzd2 & 255);
                    zzabzVar.zzr(this.zzn, 4, 2);
                    this.zzaa += 4;
                }
                this.zzac = true;
            }
            int zzd3 = i4 + this.zzq.zzd();
            if (!"V_MPEG4/ISO/AVC".equals(zzafoVar.zzb) && !"V_MPEGH/ISO/HEVC".equals(zzafoVar.zzb)) {
                if (zzafoVar.zzS != null) {
                    if (this.zzq.zzd() != 0) {
                        z4 = false;
                    }
                    zzdy.zzf(z4);
                    zzafoVar.zzS.zzd(zzaaxVar);
                }
                while (true) {
                    int i17 = this.zzZ;
                    if (i17 >= zzd3) {
                        break;
                    }
                    int zzo = zzo(zzaaxVar, zzabzVar, zzd3 - i17);
                    this.zzZ += zzo;
                    this.zzaa += zzo;
                }
            } else {
                byte[] zzH2 = this.zzm.zzH();
                zzH2[0] = 0;
                zzH2[1] = 0;
                zzH2[2] = 0;
                int i18 = zzafoVar.zzW;
                int i19 = 4 - i18;
                while (this.zzZ < zzd3) {
                    int i20 = this.zzab;
                    if (i20 == 0) {
                        int min = Math.min(i18, this.zzq.zza());
                        ((zzaam) zzaaxVar).zzn(zzH2, i19 + min, i18 - min, false);
                        if (min > 0) {
                            this.zzq.zzB(zzH2, i19, min);
                        }
                        this.zzZ += i18;
                        this.zzm.zzF(0);
                        this.zzab = this.zzm.zzn();
                        this.zzl.zzF(0);
                        zzabx.zzb(zzabzVar, this.zzl, 4);
                        this.zzaa += 4;
                    } else {
                        int zzo2 = zzo(zzaaxVar, zzabzVar, i20);
                        this.zzZ += zzo2;
                        this.zzaa += zzo2;
                        this.zzab -= zzo2;
                    }
                }
            }
            if ("A_VORBIS".equals(zzafoVar.zzb)) {
                this.zzo.zzF(0);
                zzabx.zzb(zzabzVar, this.zzo, 4);
                this.zzaa += 4;
            }
            int i21 = this.zzaa;
            zzu();
            return i21;
        }
    }

    private final int zzo(zzaax zzaaxVar, zzabz zzabzVar, int i4) throws IOException {
        int zza2 = this.zzq.zza();
        if (zza2 > 0) {
            int min = Math.min(i4, zza2);
            zzabx.zzb(zzabzVar, this.zzq, min);
            return min;
        }
        return zzabx.zza(zzabzVar, zzaaxVar, i4, false);
    }

    private final long zzp(long j4) throws zzcd {
        long j5 = this.zzy;
        if (j5 != -9223372036854775807L) {
            return zzfj.zzp(j4, j5, 1000L);
        }
        throw zzcd.zza("Can't scale timecode prior to timecodeScale being set.", null);
    }

    @EnsuresNonNull({"cueTimesUs", "cueClusterPositions"})
    private final void zzq(int i4) throws zzcd {
        if (this.zzJ != null && this.zzK != null) {
            return;
        }
        throw zzcd.zza("Element " + i4 + " must be in a Cues", null);
    }

    @EnsuresNonNull({"currentTrack"})
    private final void zzr(int i4) throws zzcd {
        if (this.zzB != null) {
            return;
        }
        throw zzcd.zza("Element " + i4 + " must be in a TrackEntry", null);
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00e0 A[EDGE_INSN: B:62:0x00e0->B:51:0x00e0 ?: BREAK  , SYNTHETIC] */
    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"#1.output"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void zzs(com.google.android.gms.internal.ads.zzafo r18, long r19, int r21, int r22, int r23) {
        /*
            Method dump skipped, instructions count: 292
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzafp.zzs(com.google.android.gms.internal.ads.zzafo, long, int, int, int):void");
    }

    private final void zzt(zzaax zzaaxVar, int i4) throws IOException {
        if (this.zzn.zzd() >= i4) {
            return;
        }
        if (this.zzn.zzb() < i4) {
            zzfa zzfaVar = this.zzn;
            int zzb2 = zzfaVar.zzb();
            zzfaVar.zzz(Math.max(zzb2 + zzb2, i4));
        }
        ((zzaam) zzaaxVar).zzn(this.zzn.zzH(), this.zzn.zzd(), i4 - this.zzn.zzd(), false);
        this.zzn.zzE(i4);
    }

    private final void zzu() {
        this.zzZ = 0;
        this.zzaa = 0;
        this.zzab = 0;
        this.zzac = false;
        this.zzad = false;
        this.zzae = false;
        this.zzaf = 0;
        this.zzag = (byte) 0;
        this.zzah = false;
        this.zzq.zzC(0);
    }

    private final void zzv(zzaax zzaaxVar, byte[] bArr, int i4) throws IOException {
        int length = bArr.length;
        int i5 = length + i4;
        if (this.zzr.zzb() < i5) {
            zzfa zzfaVar = this.zzr;
            byte[] copyOf = Arrays.copyOf(bArr, i5 + i4);
            zzfaVar.zzD(copyOf, copyOf.length);
        } else {
            System.arraycopy(bArr, 0, this.zzr.zzH(), 0, length);
        }
        ((zzaam) zzaaxVar).zzn(this.zzr.zzH(), length, i4, false);
        this.zzr.zzF(0);
        this.zzr.zzE(i5);
    }

    private static byte[] zzw(long j4, String str, long j5) {
        boolean z3;
        if (j4 != -9223372036854775807L) {
            z3 = true;
        } else {
            z3 = false;
        }
        zzdy.zzd(z3);
        Locale locale = Locale.US;
        int i4 = (int) (j4 / 3600000000L);
        long j6 = j4 - (i4 * 3600000000L);
        int i5 = (int) (j6 / 60000000);
        long j7 = j6 - (i5 * 60000000);
        int i6 = (int) (j7 / AnimationKt.MillisToNanos);
        String format = String.format(locale, str, Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf((int) ((j7 - (i6 * AnimationKt.MillisToNanos)) / j5)));
        int i7 = zzfj.zza;
        return format.getBytes(zzfot.zzc);
    }

    private static int[] zzx(@Nullable int[] iArr, int i4) {
        if (iArr == null) {
            return new int[i4];
        }
        int length = iArr.length;
        if (length >= i4) {
            return iArr;
        }
        return new int[Math.max(length + length, i4)];
    }

    @Override // com.google.android.gms.internal.ads.zzaaw
    public final int zza(zzaax zzaaxVar, zzabs zzabsVar) throws IOException {
        this.zzM = false;
        while (!this.zzM) {
            if (this.zzh.zzc(zzaaxVar)) {
                long zzf2 = zzaaxVar.zzf();
                if (this.zzF) {
                    this.zzH = zzf2;
                    zzabsVar.zza = this.zzG;
                    this.zzF = false;
                    return 1;
                } else if (this.zzC) {
                    long j4 = this.zzH;
                    if (j4 != -1) {
                        zzabsVar.zza = j4;
                        this.zzH = -1L;
                        return 1;
                    }
                }
            } else {
                for (int i4 = 0; i4 < this.zzj.size(); i4++) {
                    zzafo zzafoVar = (zzafo) this.zzj.valueAt(i4);
                    zzafo.zzd(zzafoVar);
                    zzaca zzacaVar = zzafoVar.zzS;
                    if (zzacaVar != null) {
                        zzacaVar.zza(zzafoVar.zzV, zzafoVar.zzi);
                    }
                }
                return -1;
            }
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzaaw
    public final void zzb(zzaaz zzaazVar) {
        this.zzai = zzaazVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaaw
    @CallSuper
    public final void zzc(long j4, long j5) {
        this.zzI = -9223372036854775807L;
        this.zzN = 0;
        this.zzh.zzb();
        this.zzi.zze();
        zzu();
        for (int i4 = 0; i4 < this.zzj.size(); i4++) {
            zzaca zzacaVar = ((zzafo) this.zzj.valueAt(i4)).zzS;
            if (zzacaVar != null) {
                zzacaVar.zzb();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaaw
    public final boolean zzd(zzaax zzaaxVar) throws IOException {
        return new zzafq().zza(zzaaxVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x027e, code lost:
        throw com.google.android.gms.internal.ads.zzcd.zza("EBML lacing sample size out of range.", null);
     */
    @androidx.annotation.CallSuper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzg(int r20, int r21, com.google.android.gms.internal.ads.zzaax r22) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 808
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzafp.zzg(int, int, com.google.android.gms.internal.ads.zzaax):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x01e8, code lost:
        if (r5.equals("V_MPEGH/ISO/HEVC") != false) goto L95;
     */
    @androidx.annotation.CallSuper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzh(int r22) throws com.google.android.gms.internal.ads.zzcd {
        /*
            Method dump skipped, instructions count: 1150
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzafp.zzh(int):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @CallSuper
    public final void zzi(int i4, double d4) throws zzcd {
        if (i4 != 181) {
            if (i4 != 17545) {
                switch (i4) {
                    case 21969:
                        zzr(i4);
                        this.zzB.zzC = (float) d4;
                        return;
                    case 21970:
                        zzr(i4);
                        this.zzB.zzD = (float) d4;
                        return;
                    case 21971:
                        zzr(i4);
                        this.zzB.zzE = (float) d4;
                        return;
                    case 21972:
                        zzr(i4);
                        this.zzB.zzF = (float) d4;
                        return;
                    case 21973:
                        zzr(i4);
                        this.zzB.zzG = (float) d4;
                        return;
                    case 21974:
                        zzr(i4);
                        this.zzB.zzH = (float) d4;
                        return;
                    case 21975:
                        zzr(i4);
                        this.zzB.zzI = (float) d4;
                        return;
                    case 21976:
                        zzr(i4);
                        this.zzB.zzJ = (float) d4;
                        return;
                    case 21977:
                        zzr(i4);
                        this.zzB.zzK = (float) d4;
                        return;
                    case 21978:
                        zzr(i4);
                        this.zzB.zzL = (float) d4;
                        return;
                    default:
                        switch (i4) {
                            case 30323:
                                zzr(i4);
                                this.zzB.zzr = (float) d4;
                                return;
                            case 30324:
                                zzr(i4);
                                this.zzB.zzs = (float) d4;
                                return;
                            case 30325:
                                zzr(i4);
                                this.zzB.zzt = (float) d4;
                                return;
                            default:
                                return;
                        }
                }
            }
            this.zzz = (long) d4;
            return;
        }
        zzr(i4);
        this.zzB.zzP = (int) d4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @CallSuper
    public final void zzj(int i4, long j4) throws zzcd {
        if (i4 != 20529) {
            if (i4 != 20530) {
                boolean z3 = false;
                switch (i4) {
                    case 131:
                        zzr(i4);
                        this.zzB.zzd = (int) j4;
                        return;
                    case 136:
                        zzr(i4);
                        zzafo zzafoVar = this.zzB;
                        if (j4 == 1) {
                            z3 = true;
                        }
                        zzafoVar.zzU = z3;
                        return;
                    case 155:
                        this.zzP = zzp(j4);
                        return;
                    case 159:
                        zzr(i4);
                        this.zzB.zzN = (int) j4;
                        return;
                    case 176:
                        zzr(i4);
                        this.zzB.zzl = (int) j4;
                        return;
                    case 179:
                        zzq(i4);
                        this.zzJ.zzc(zzp(j4));
                        return;
                    case 186:
                        zzr(i4);
                        this.zzB.zzm = (int) j4;
                        return;
                    case Opcodes.XOR_INT_LIT16 /* 215 */:
                        zzr(i4);
                        this.zzB.zzc = (int) j4;
                        return;
                    case 231:
                        this.zzI = zzp(j4);
                        return;
                    case 238:
                        this.zzW = (int) j4;
                        return;
                    case 241:
                        if (!this.zzL) {
                            zzq(i4);
                            this.zzK.zzc(j4);
                            this.zzL = true;
                            return;
                        }
                        return;
                    case 251:
                        this.zzX = true;
                        return;
                    case 16871:
                        zzr(i4);
                        zzafo.zzb(this.zzB, (int) j4);
                        return;
                    case 16980:
                        if (j4 != 3) {
                            throw zzcd.zza("ContentCompAlgo " + j4 + " not supported", null);
                        }
                        return;
                    case 17029:
                        if (j4 < 1 || j4 > 2) {
                            throw zzcd.zza("DocTypeReadVersion " + j4 + " not supported", null);
                        }
                        return;
                    case 17143:
                        if (j4 != 1) {
                            throw zzcd.zza("EBMLReadVersion " + j4 + " not supported", null);
                        }
                        return;
                    case 18401:
                        if (j4 != 5) {
                            throw zzcd.zza("ContentEncAlgo " + j4 + " not supported", null);
                        }
                        return;
                    case 18408:
                        if (j4 != 1) {
                            throw zzcd.zza("AESSettingsCipherMode " + j4 + " not supported", null);
                        }
                        return;
                    case 21420:
                        this.zzE = j4 + this.zzx;
                        return;
                    case 21432:
                        int i5 = (int) j4;
                        zzr(i4);
                        if (i5 != 0) {
                            if (i5 != 1) {
                                if (i5 != 3) {
                                    if (i5 == 15) {
                                        this.zzB.zzv = 3;
                                        return;
                                    }
                                    return;
                                }
                                this.zzB.zzv = 1;
                                return;
                            }
                            this.zzB.zzv = 2;
                            return;
                        }
                        this.zzB.zzv = 0;
                        return;
                    case 21680:
                        zzr(i4);
                        this.zzB.zzn = (int) j4;
                        return;
                    case 21682:
                        zzr(i4);
                        this.zzB.zzp = (int) j4;
                        return;
                    case 21690:
                        zzr(i4);
                        this.zzB.zzo = (int) j4;
                        return;
                    case 21930:
                        zzr(i4);
                        zzafo zzafoVar2 = this.zzB;
                        if (j4 == 1) {
                            z3 = true;
                        }
                        zzafoVar2.zzT = z3;
                        return;
                    case 21998:
                        zzr(i4);
                        this.zzB.zzf = (int) j4;
                        return;
                    case 22186:
                        zzr(i4);
                        this.zzB.zzQ = j4;
                        return;
                    case 22203:
                        zzr(i4);
                        this.zzB.zzR = j4;
                        return;
                    case 25188:
                        zzr(i4);
                        this.zzB.zzO = (int) j4;
                        return;
                    case 30114:
                        this.zzY = j4;
                        return;
                    case 30321:
                        zzr(i4);
                        int i6 = (int) j4;
                        if (i6 != 0) {
                            if (i6 != 1) {
                                if (i6 != 2) {
                                    if (i6 == 3) {
                                        this.zzB.zzq = 3;
                                        return;
                                    }
                                    return;
                                }
                                this.zzB.zzq = 2;
                                return;
                            }
                            this.zzB.zzq = 1;
                            return;
                        }
                        this.zzB.zzq = 0;
                        return;
                    case 2352003:
                        zzr(i4);
                        this.zzB.zze = (int) j4;
                        return;
                    case 2807729:
                        this.zzy = j4;
                        return;
                    default:
                        switch (i4) {
                            case 21945:
                                zzr(i4);
                                int i7 = (int) j4;
                                if (i7 != 1) {
                                    if (i7 == 2) {
                                        this.zzB.zzz = 1;
                                        return;
                                    }
                                    return;
                                }
                                this.zzB.zzz = 2;
                                return;
                            case 21946:
                                zzr(i4);
                                int zzb2 = zzs.zzb((int) j4);
                                if (zzb2 != -1) {
                                    this.zzB.zzy = zzb2;
                                    return;
                                }
                                return;
                            case 21947:
                                zzr(i4);
                                this.zzB.zzw = true;
                                int zza2 = zzs.zza((int) j4);
                                if (zza2 != -1) {
                                    this.zzB.zzx = zza2;
                                    return;
                                }
                                return;
                            case 21948:
                                zzr(i4);
                                this.zzB.zzA = (int) j4;
                                return;
                            case 21949:
                                zzr(i4);
                                this.zzB.zzB = (int) j4;
                                return;
                            default:
                                return;
                        }
                }
            } else if (j4 != 1) {
                throw zzcd.zza("ContentEncodingScope " + j4 + " not supported", null);
            }
        } else if (j4 == 0) {
        } else {
            throw zzcd.zza("ContentEncodingOrder " + j4 + " not supported", null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @CallSuper
    public final void zzk(int i4, long j4, long j5) throws zzcd {
        zzdy.zzb(this.zzai);
        if (i4 != 160) {
            if (i4 != 174) {
                if (i4 != 187) {
                    if (i4 != 19899) {
                        if (i4 != 20533) {
                            if (i4 != 21968) {
                                if (i4 != 408125543) {
                                    if (i4 != 475249515) {
                                        if (i4 == 524531317 && !this.zzC) {
                                            if (this.zzk && this.zzG != -1) {
                                                this.zzF = true;
                                                return;
                                            }
                                            this.zzai.zzN(new zzabu(this.zzA, 0L));
                                            this.zzC = true;
                                            return;
                                        }
                                        return;
                                    }
                                    this.zzJ = new zzes(32);
                                    this.zzK = new zzes(32);
                                    return;
                                }
                                long j6 = this.zzx;
                                if (j6 != -1 && j6 != j4) {
                                    throw zzcd.zza("Multiple Segment elements not supported", null);
                                }
                                this.zzx = j4;
                                this.zzw = j5;
                                return;
                            }
                            zzr(i4);
                            this.zzB.zzw = true;
                            return;
                        }
                        zzr(i4);
                        this.zzB.zzg = true;
                        return;
                    }
                    this.zzD = -1;
                    this.zzE = -1L;
                    return;
                }
                this.zzL = false;
                return;
            }
            this.zzB = new zzafo();
            return;
        }
        this.zzX = false;
        this.zzY = 0L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @CallSuper
    public final void zzl(int i4, String str) throws zzcd {
        if (i4 != 134) {
            if (i4 != 17026) {
                if (i4 != 21358) {
                    if (i4 == 2274716) {
                        zzr(i4);
                        zzafo.zzc(this.zzB, str);
                        return;
                    }
                    return;
                }
                zzr(i4);
                this.zzB.zza = str;
                return;
            } else if (!"webm".equals(str) && !"matroska".equals(str)) {
                throw zzcd.zza("DocType " + str + " not supported", null);
            } else {
                return;
            }
        }
        zzr(i4);
        this.zzB.zzb = str;
    }

    public zzafp(int i4) {
        zzafi zzafiVar = new zzafi();
        this.zzx = -1L;
        this.zzy = -9223372036854775807L;
        this.zzz = -9223372036854775807L;
        this.zzA = -9223372036854775807L;
        this.zzG = -1L;
        this.zzH = -1L;
        this.zzI = -9223372036854775807L;
        this.zzh = zzafiVar;
        zzafiVar.zza(new zzafn(this, null));
        this.zzk = true;
        this.zzi = new zzafr();
        this.zzj = new SparseArray();
        this.zzn = new zzfa(4);
        this.zzo = new zzfa(ByteBuffer.allocate(4).putInt(-1).array());
        this.zzp = new zzfa(4);
        this.zzl = new zzfa(zzfu.zza);
        this.zzm = new zzfa(4);
        this.zzq = new zzfa();
        this.zzr = new zzfa();
        this.zzs = new zzfa(8);
        this.zzt = new zzfa();
        this.zzu = new zzfa();
        this.zzS = new int[1];
    }
}
