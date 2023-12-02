package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.android.dx.io.Opcodes;
import com.tencent.soter.core.biometric.FaceManager;
import java.nio.ByteBuffer;
import okio.Utf8;
import org.apache.http.HttpStatus;
import org.jetbrains.anko.DimensionsKt;
import org.joni.constants.internal.StackType;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzzx {
    public static final /* synthetic */ int zza = 0;
    private static final int[] zzb = {1, 2, 3, 6};
    private static final int[] zzc = {48000, 44100, 32000};
    private static final int[] zzd = {24000, 22050, 16000};
    private static final int[] zze = {2, 1, 2, 3, 3, 4, 4, 5};
    private static final int[] zzf = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, Opcodes.SHL_INT_LIT8, 256, DimensionsKt.XHDPI, 384, 448, 512, 576, DimensionsKt.XXXHDPI};
    private static final int[] zzg = {69, 87, 104, 121, 139, 174, Opcodes.ADD_INT_LIT16, 243, 278, 348, HttpStatus.SC_EXPECTATION_FAILED, 487, 557, 696, 835, 975, FaceManager.FACE_ACQUIRED_RIGHT, 1253, 1393};

    public static int zza(ByteBuffer byteBuffer) {
        int i4 = 3;
        if (((byteBuffer.get(byteBuffer.position() + 5) & 248) >> 3) > 10) {
            if (((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3) {
                i4 = (byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4;
            }
            return zzb[i4] * 256;
        }
        return StackType.STOP_BT;
    }

    public static int zzb(byte[] bArr) {
        if (bArr.length < 6) {
            return -1;
        }
        if (((bArr[5] & 248) >> 3) > 10) {
            int i4 = ((bArr[3] & 255) | ((bArr[2] & 7) << 8)) + 1;
            return i4 + i4;
        }
        byte b4 = bArr[4];
        return zzf((b4 & 192) >> 6, b4 & Utf8.REPLACEMENT_BYTE);
    }

    public static zzam zzc(zzfa zzfaVar, String str, String str2, @Nullable zzad zzadVar) {
        zzez zzezVar = new zzez();
        zzezVar.zzh(zzfaVar);
        int i4 = zzc[zzezVar.zzd(2)];
        zzezVar.zzl(8);
        int i5 = zze[zzezVar.zzd(3)];
        if (zzezVar.zzd(1) != 0) {
            i5++;
        }
        int i6 = zzf[zzezVar.zzd(5)] * 1000;
        zzezVar.zze();
        zzfaVar.zzF(zzezVar.zzb());
        zzak zzakVar = new zzak();
        zzakVar.zzH(str);
        zzakVar.zzS("audio/ac3");
        zzakVar.zzw(i5);
        zzakVar.zzT(i4);
        zzakVar.zzB(zzadVar);
        zzakVar.zzK(str2);
        zzakVar.zzv(i6);
        zzakVar.zzO(i6);
        return zzakVar.zzY();
    }

    public static zzam zzd(zzfa zzfaVar, String str, String str2, @Nullable zzad zzadVar) {
        String str3;
        zzez zzezVar = new zzez();
        zzezVar.zzh(zzfaVar);
        int zzd2 = zzezVar.zzd(13) * 1000;
        zzezVar.zzl(3);
        int i4 = zzc[zzezVar.zzd(2)];
        zzezVar.zzl(10);
        int i5 = zze[zzezVar.zzd(3)];
        if (zzezVar.zzd(1) != 0) {
            i5++;
        }
        zzezVar.zzl(3);
        int zzd3 = zzezVar.zzd(4);
        zzezVar.zzl(1);
        if (zzd3 > 0) {
            zzezVar.zzm(6);
            if (zzezVar.zzd(1) != 0) {
                i5 += 2;
            }
            zzezVar.zzl(1);
        }
        if (zzezVar.zza() > 7) {
            zzezVar.zzl(7);
            if (zzezVar.zzd(1) != 0) {
                str3 = "audio/eac3-joc";
                zzezVar.zze();
                zzfaVar.zzF(zzezVar.zzb());
                zzak zzakVar = new zzak();
                zzakVar.zzH(str);
                zzakVar.zzS(str3);
                zzakVar.zzw(i5);
                zzakVar.zzT(i4);
                zzakVar.zzB(zzadVar);
                zzakVar.zzK(str2);
                zzakVar.zzO(zzd2);
                return zzakVar.zzY();
            }
        }
        str3 = "audio/eac3";
        zzezVar.zze();
        zzfaVar.zzF(zzezVar.zzb());
        zzak zzakVar2 = new zzak();
        zzakVar2.zzH(str);
        zzakVar2.zzS(str3);
        zzakVar2.zzw(i5);
        zzakVar2.zzT(i4);
        zzakVar2.zzB(zzadVar);
        zzakVar2.zzK(str2);
        zzakVar2.zzO(zzd2);
        return zzakVar2.zzY();
    }

    public static zzzw zze(zzez zzezVar) {
        String str;
        int i4;
        String str2;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        String str3;
        int zzc2 = zzezVar.zzc();
        zzezVar.zzl(40);
        int zzd2 = zzezVar.zzd(5);
        zzezVar.zzj(zzc2);
        int i16 = -1;
        if (zzd2 > 10) {
            zzezVar.zzl(16);
            int zzd3 = zzezVar.zzd(2);
            if (zzd3 != 0) {
                if (zzd3 != 1) {
                    if (zzd3 == 2) {
                        i16 = 2;
                    }
                } else {
                    i16 = 1;
                }
            } else {
                i16 = 0;
            }
            zzezVar.zzl(3);
            int zzd4 = zzezVar.zzd(11) + 1;
            int zzd5 = zzezVar.zzd(2);
            if (zzd5 == 3) {
                i12 = zzd[zzezVar.zzd(2)];
                i11 = 3;
                i13 = 6;
            } else {
                int zzd6 = zzezVar.zzd(2);
                int i17 = zzb[zzd6];
                i11 = zzd6;
                i12 = zzc[zzd5];
                i13 = i17;
            }
            int i18 = zzd4 + zzd4;
            int i19 = (i18 * i12) / (i13 * 32);
            int zzd7 = zzezVar.zzd(3);
            boolean zzn = zzezVar.zzn();
            int i20 = zze[zzd7] + (zzn ? 1 : 0);
            zzezVar.zzl(10);
            if (zzezVar.zzn()) {
                zzezVar.zzl(8);
            }
            if (zzd7 == 0) {
                zzezVar.zzl(5);
                if (zzezVar.zzn()) {
                    zzezVar.zzl(8);
                }
                i14 = 0;
                zzd7 = 0;
            } else {
                i14 = zzd7;
            }
            if (i16 == 1) {
                if (zzezVar.zzn()) {
                    zzezVar.zzl(16);
                }
                i15 = 1;
            } else {
                i15 = i16;
            }
            if (zzezVar.zzn()) {
                if (i14 > 2) {
                    zzezVar.zzl(2);
                }
                if ((i14 & 1) != 0 && i14 > 2) {
                    zzezVar.zzl(6);
                }
                if ((i14 & 4) != 0) {
                    zzezVar.zzl(6);
                }
                if (zzn && zzezVar.zzn()) {
                    zzezVar.zzl(5);
                }
                if (i15 == 0) {
                    if (zzezVar.zzn()) {
                        zzezVar.zzl(6);
                    }
                    if (i14 == 0 && zzezVar.zzn()) {
                        zzezVar.zzl(6);
                    }
                    if (zzezVar.zzn()) {
                        zzezVar.zzl(6);
                    }
                    int zzd8 = zzezVar.zzd(2);
                    if (zzd8 == 1) {
                        zzezVar.zzl(5);
                    } else if (zzd8 == 2) {
                        zzezVar.zzl(12);
                    } else if (zzd8 == 3) {
                        int zzd9 = zzezVar.zzd(5);
                        if (zzezVar.zzn()) {
                            zzezVar.zzl(5);
                            if (zzezVar.zzn()) {
                                zzezVar.zzl(4);
                            }
                            if (zzezVar.zzn()) {
                                zzezVar.zzl(4);
                            }
                            if (zzezVar.zzn()) {
                                zzezVar.zzl(4);
                            }
                            if (zzezVar.zzn()) {
                                zzezVar.zzl(4);
                            }
                            if (zzezVar.zzn()) {
                                zzezVar.zzl(4);
                            }
                            if (zzezVar.zzn()) {
                                zzezVar.zzl(4);
                            }
                            if (zzezVar.zzn()) {
                                zzezVar.zzl(4);
                            }
                            if (zzezVar.zzn()) {
                                if (zzezVar.zzn()) {
                                    zzezVar.zzl(4);
                                }
                                if (zzezVar.zzn()) {
                                    zzezVar.zzl(4);
                                }
                            }
                        }
                        if (zzezVar.zzn()) {
                            zzezVar.zzl(5);
                            if (zzezVar.zzn()) {
                                zzezVar.zzl(7);
                                if (zzezVar.zzn()) {
                                    zzezVar.zzl(8);
                                }
                            }
                        }
                        zzezVar.zzl((zzd9 + 2) * 8);
                        zzezVar.zze();
                    }
                    if (i14 < 2) {
                        if (zzezVar.zzn()) {
                            zzezVar.zzl(14);
                        }
                        if (zzd7 == 0 && zzezVar.zzn()) {
                            zzezVar.zzl(14);
                        }
                    }
                    if (zzezVar.zzn()) {
                        if (i11 == 0) {
                            zzezVar.zzl(5);
                            i15 = 0;
                            i11 = 0;
                        } else {
                            for (int i21 = 0; i21 < i13; i21++) {
                                if (zzezVar.zzn()) {
                                    zzezVar.zzl(5);
                                }
                            }
                        }
                    }
                    i15 = 0;
                }
            }
            if (zzezVar.zzn()) {
                zzezVar.zzl(5);
                if (i14 == 2) {
                    zzezVar.zzl(4);
                    i14 = 2;
                }
                if (i14 >= 6) {
                    zzezVar.zzl(2);
                }
                if (zzezVar.zzn()) {
                    zzezVar.zzl(8);
                }
                if (i14 == 0 && zzezVar.zzn()) {
                    zzezVar.zzl(8);
                }
                if (zzd5 < 3) {
                    zzezVar.zzk();
                }
            }
            if (i15 == 0 && i11 != 3) {
                zzezVar.zzk();
            }
            if (i15 == 2 && (i11 == 3 || zzezVar.zzn())) {
                zzezVar.zzl(6);
            }
            if (zzezVar.zzn() && zzezVar.zzd(6) == 1 && zzezVar.zzd(8) == 1) {
                str3 = "audio/eac3-joc";
            } else {
                str3 = "audio/eac3";
            }
            str2 = str3;
            i9 = i16;
            i6 = i18;
            i7 = i12;
            i10 = i13 * 256;
            i5 = i19;
            i8 = i20;
        } else {
            zzezVar.zzl(32);
            int zzd10 = zzezVar.zzd(2);
            if (zzd10 == 3) {
                str = null;
            } else {
                str = "audio/ac3";
            }
            int zzd11 = zzezVar.zzd(6);
            int i22 = zzf[zzd11 / 2] * 1000;
            int zzf2 = zzf(zzd10, zzd11);
            zzezVar.zzl(8);
            int zzd12 = zzezVar.zzd(3);
            if ((zzd12 & 1) != 0 && zzd12 != 1) {
                zzezVar.zzl(2);
            }
            if ((zzd12 & 4) != 0) {
                zzezVar.zzl(2);
            }
            if (zzd12 == 2) {
                zzezVar.zzl(2);
            }
            if (zzd10 < 3) {
                i4 = zzc[zzd10];
            } else {
                i4 = -1;
            }
            str2 = str;
            i5 = i22;
            i6 = zzf2;
            i7 = i4;
            i8 = zze[zzd12] + (zzezVar.zzn() ? 1 : 0);
            i9 = -1;
            i10 = StackType.STOP_BT;
        }
        return new zzzw(str2, i9, i8, i7, i6, i10, i5, null);
    }

    private static int zzf(int i4, int i5) {
        int i6;
        if (i4 >= 0 && i4 < 3 && i5 >= 0 && (i6 = i5 >> 1) < 19) {
            int i7 = zzc[i4];
            if (i7 == 44100) {
                int i8 = zzg[i6] + (i5 & 1);
                return i8 + i8;
            }
            int i9 = zzf[i6];
            if (i7 == 32000) {
                return i9 * 6;
            }
            return i9 * 4;
        }
        return -1;
    }
}
