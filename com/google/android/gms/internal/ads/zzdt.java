package com.google.android.gms.internal.ads;

import com.google.android.gms.wearable.WearableStatusCodes;
import java.nio.ShortBuffer;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzdt {
    private final int zza;
    private final int zzb;
    private final float zzc;
    private final float zzd;
    private final float zze;
    private final int zzf;
    private final int zzg;
    private final int zzh;
    private final short[] zzi;
    private short[] zzj;
    private int zzk;
    private short[] zzl;
    private int zzm;
    private short[] zzn;
    private int zzo;
    private int zzp;
    private int zzq;
    private int zzr;
    private int zzs;
    private int zzt;
    private int zzu;
    private int zzv;

    public zzdt(int i4, int i5, float f4, float f5, int i6) {
        this.zza = i4;
        this.zzb = i5;
        this.zzc = f4;
        this.zzd = f5;
        this.zze = i4 / i6;
        this.zzf = i4 / 400;
        int i7 = i4 / 65;
        this.zzg = i7;
        int i8 = i7 + i7;
        this.zzh = i8;
        this.zzi = new short[i8];
        int i9 = i8 * i5;
        this.zzj = new short[i9];
        this.zzl = new short[i9];
        this.zzn = new short[i9];
    }

    private final int zzg(short[] sArr, int i4, int i5, int i6) {
        int i7 = i4 * this.zzb;
        int i8 = 1;
        int i9 = 255;
        int i10 = 0;
        int i11 = 0;
        while (i5 <= i6) {
            int i12 = 0;
            for (int i13 = 0; i13 < i5; i13++) {
                i12 += Math.abs(sArr[i7 + i13] - sArr[(i7 + i5) + i13]);
            }
            int i14 = i12 * i10;
            int i15 = i8 * i5;
            if (i14 < i15) {
                i8 = i12;
            }
            if (i14 < i15) {
                i10 = i5;
            }
            int i16 = i12 * i9;
            int i17 = i11 * i5;
            if (i16 > i17) {
                i11 = i12;
            }
            if (i16 > i17) {
                i9 = i5;
            }
            i5++;
        }
        this.zzu = i8 / i10;
        this.zzv = i11 / i9;
        return i10;
    }

    private final void zzh(short[] sArr, int i4, int i5) {
        short[] zzl = zzl(this.zzl, this.zzm, i5);
        this.zzl = zzl;
        int i6 = this.zzb;
        System.arraycopy(sArr, i4 * i6, zzl, this.zzm * i6, i6 * i5);
        this.zzm += i5;
    }

    private final void zzi(short[] sArr, int i4, int i5) {
        int i6 = this.zzh / i5;
        int i7 = this.zzb;
        int i8 = i5 * i7;
        int i9 = i4 * i7;
        for (int i10 = 0; i10 < i6; i10++) {
            int i11 = 0;
            for (int i12 = 0; i12 < i8; i12++) {
                i11 += sArr[(i10 * i8) + i9 + i12];
            }
            this.zzi[i10] = (short) (i11 / i8);
        }
    }

    private static void zzj(int i4, int i5, short[] sArr, int i6, short[] sArr2, int i7, short[] sArr3, int i8) {
        for (int i9 = 0; i9 < i5; i9++) {
            int i10 = (i7 * i5) + i9;
            int i11 = (i8 * i5) + i9;
            int i12 = (i6 * i5) + i9;
            for (int i13 = 0; i13 < i4; i13++) {
                sArr[i12] = (short) (((sArr2[i10] * (i4 - i13)) + (sArr3[i11] * i13)) / i4);
                i12 += i5;
                i10 += i5;
                i11 += i5;
            }
        }
    }

    private final void zzk() {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        boolean z3;
        int i14 = this.zzm;
        float f4 = this.zzc;
        float f5 = this.zzd;
        float f6 = f4 / f5;
        float f7 = this.zze * f5;
        double d4 = f6;
        float f8 = 1.0f;
        int i15 = 1;
        if (d4 <= 1.00001d && d4 >= 0.99999d) {
            zzh(this.zzj, 0, this.zzk);
            this.zzk = 0;
        } else {
            int i16 = this.zzk;
            if (i16 >= this.zzh) {
                int i17 = 0;
                while (true) {
                    int i18 = this.zzr;
                    if (i18 > 0) {
                        int min = Math.min(this.zzh, i18);
                        zzh(this.zzj, i17, min);
                        this.zzr -= min;
                        i17 += min;
                    } else {
                        short[] sArr = this.zzj;
                        int i19 = this.zza;
                        if (i19 > 4000) {
                            i4 = i19 / WearableStatusCodes.TARGET_NODE_NOT_CONNECTED;
                        } else {
                            i4 = 1;
                        }
                        if (this.zzb == i15 && i4 == i15) {
                            i5 = zzg(sArr, i17, this.zzf, this.zzg);
                        } else {
                            zzi(sArr, i17, i4);
                            int zzg = zzg(this.zzi, 0, this.zzf / i4, this.zzg / i4);
                            if (i4 != i15) {
                                int i20 = zzg * i4;
                                int i21 = i4 * 4;
                                int i22 = this.zzf;
                                int i23 = i20 - i21;
                                if (i23 >= i22) {
                                    i22 = i23;
                                }
                                int i24 = i20 + i21;
                                int i25 = this.zzg;
                                if (i24 > i25) {
                                    i24 = i25;
                                }
                                if (this.zzb == i15) {
                                    i5 = zzg(sArr, i17, i22, i24);
                                } else {
                                    zzi(sArr, i17, i15);
                                    i5 = zzg(this.zzi, 0, i22, i24);
                                }
                            } else {
                                i5 = zzg;
                            }
                        }
                        int i26 = this.zzu;
                        int i27 = this.zzv;
                        if (i26 != 0 && (i9 = this.zzs) != 0 && i27 <= i26 * 3 && i26 + i26 > this.zzt * 3) {
                            i6 = i9;
                        } else {
                            i6 = i5;
                        }
                        this.zzt = i26;
                        this.zzs = i5;
                        if (d4 > 1.0d) {
                            short[] sArr2 = this.zzj;
                            if (f6 >= 2.0f) {
                                i8 = (int) (i6 / ((-1.0f) + f6));
                            } else {
                                this.zzr = (int) ((i6 * (2.0f - f6)) / ((-1.0f) + f6));
                                i8 = i6;
                            }
                            short[] zzl = zzl(this.zzl, this.zzm, i8);
                            this.zzl = zzl;
                            int i28 = i8;
                            zzj(i8, this.zzb, zzl, this.zzm, sArr2, i17, sArr2, i17 + i6);
                            this.zzm += i28;
                            i17 += i6 + i28;
                        } else {
                            int i29 = i6;
                            short[] sArr3 = this.zzj;
                            if (f6 < 0.5f) {
                                i7 = (int) ((i29 * f6) / (f8 - f6));
                            } else {
                                this.zzr = (int) ((i29 * ((f6 + f6) - 1.0f)) / (f8 - f6));
                                i7 = i29;
                            }
                            int i30 = i29 + i7;
                            short[] zzl2 = zzl(this.zzl, this.zzm, i30);
                            this.zzl = zzl2;
                            int i31 = this.zzb;
                            System.arraycopy(sArr3, i17 * i31, zzl2, this.zzm * i31, i31 * i29);
                            zzj(i7, this.zzb, this.zzl, this.zzm + i29, sArr3, i17 + i29, sArr3, i17);
                            this.zzm += i30;
                            i17 += i7;
                        }
                    }
                    if (this.zzh + i17 > i16) {
                        break;
                    }
                    f8 = 1.0f;
                    i15 = 1;
                }
                int i32 = this.zzk - i17;
                short[] sArr4 = this.zzj;
                int i33 = this.zzb;
                System.arraycopy(sArr4, i17 * i33, sArr4, 0, i33 * i32);
                this.zzk = i32;
                f8 = 1.0f;
            }
        }
        if (f7 != f8 && this.zzm != i14) {
            int i34 = this.zza;
            int i35 = (int) (i34 / f7);
            while (true) {
                if (i35 <= 16384 && i34 <= 16384) {
                    break;
                }
                i35 /= 2;
                i34 /= 2;
            }
            int i36 = this.zzm - i14;
            short[] zzl3 = zzl(this.zzn, this.zzo, i36);
            this.zzn = zzl3;
            short[] sArr5 = this.zzl;
            int i37 = this.zzb;
            System.arraycopy(sArr5, i14 * i37, zzl3, this.zzo * i37, i37 * i36);
            this.zzm = i14;
            this.zzo += i36;
            int i38 = 0;
            while (true) {
                i10 = this.zzo;
                i11 = i10 - 1;
                if (i38 >= i11) {
                    break;
                }
                while (true) {
                    i12 = this.zzp + 1;
                    int i39 = i12 * i35;
                    i13 = this.zzq;
                    if (i39 <= i13 * i34) {
                        break;
                    }
                    this.zzl = zzl(this.zzl, this.zzm, 1);
                    int i40 = 0;
                    while (true) {
                        int i41 = this.zzb;
                        if (i40 < i41) {
                            short[] sArr6 = this.zzl;
                            int i42 = this.zzm * i41;
                            short[] sArr7 = this.zzn;
                            int i43 = (i38 * i41) + i40;
                            short s3 = sArr7[i43];
                            short s4 = sArr7[i43 + i41];
                            int i44 = this.zzp;
                            int i45 = i44 * i35;
                            int i46 = (i44 + 1) * i35;
                            int i47 = i46 - (this.zzq * i34);
                            int i48 = i46 - i45;
                            sArr6[i42 + i40] = (short) (((s3 * i47) + ((i48 - i47) * s4)) / i48);
                            i40++;
                        }
                    }
                    this.zzq++;
                    this.zzm++;
                }
                this.zzp = i12;
                if (i12 == i34) {
                    this.zzp = 0;
                    if (i13 == i35) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    zzdy.zzf(z3);
                    this.zzq = 0;
                }
                i38++;
            }
            if (i11 != 0) {
                short[] sArr8 = this.zzn;
                int i49 = this.zzb;
                System.arraycopy(sArr8, i11 * i49, sArr8, 0, (i10 - i11) * i49);
                this.zzo -= i11;
            }
        }
    }

    private final short[] zzl(short[] sArr, int i4, int i5) {
        int length = sArr.length;
        int i6 = this.zzb;
        int i7 = length / i6;
        if (i4 + i5 <= i7) {
            return sArr;
        }
        return Arrays.copyOf(sArr, (((i7 * 3) / 2) + i5) * i6);
    }

    public final int zza() {
        int i4 = this.zzm * this.zzb;
        return i4 + i4;
    }

    public final int zzb() {
        int i4 = this.zzk * this.zzb;
        return i4 + i4;
    }

    public final void zzc() {
        this.zzk = 0;
        this.zzm = 0;
        this.zzo = 0;
        this.zzp = 0;
        this.zzq = 0;
        this.zzr = 0;
        this.zzs = 0;
        this.zzt = 0;
        this.zzu = 0;
        this.zzv = 0;
    }

    public final void zzd(ShortBuffer shortBuffer) {
        int min = Math.min(shortBuffer.remaining() / this.zzb, this.zzm);
        shortBuffer.put(this.zzl, 0, this.zzb * min);
        int i4 = this.zzm - min;
        this.zzm = i4;
        short[] sArr = this.zzl;
        int i5 = this.zzb;
        System.arraycopy(sArr, min * i5, sArr, 0, i4 * i5);
    }

    public final void zze() {
        int i4;
        int i5 = this.zzk;
        float f4 = this.zzc;
        float f5 = this.zzd;
        int i6 = this.zzm + ((int) ((((i5 / (f4 / f5)) + this.zzo) / (this.zze * f5)) + 0.5f));
        short[] sArr = this.zzj;
        int i7 = this.zzh;
        this.zzj = zzl(sArr, i5, i7 + i7 + i5);
        int i8 = 0;
        while (true) {
            int i9 = this.zzh;
            i4 = i9 + i9;
            int i10 = this.zzb;
            if (i8 >= i4 * i10) {
                break;
            }
            this.zzj[(i10 * i5) + i8] = 0;
            i8++;
        }
        this.zzk += i4;
        zzk();
        if (this.zzm > i6) {
            this.zzm = i6;
        }
        this.zzk = 0;
        this.zzr = 0;
        this.zzo = 0;
    }

    public final void zzf(ShortBuffer shortBuffer) {
        int remaining = shortBuffer.remaining();
        int i4 = this.zzb;
        int i5 = remaining / i4;
        int i6 = i4 * i5;
        short[] zzl = zzl(this.zzj, this.zzk, i5);
        this.zzj = zzl;
        shortBuffer.get(zzl, this.zzk * this.zzb, (i6 + i6) / 2);
        this.zzk += i5;
        zzk();
    }
}
