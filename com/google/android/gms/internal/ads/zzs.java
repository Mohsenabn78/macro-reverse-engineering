package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Locale;
import org.checkerframework.dataflow.qual.Pure;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzs {
    public static final zzs zza = new zzs(1, 2, 3, null);
    public static final zzs zzb;
    public static final zzn zzc;
    private static final String zzh;
    private static final String zzi;
    private static final String zzj;
    private static final String zzk;
    public final int zzd;
    public final int zze;
    public final int zzf;
    @Nullable
    public final byte[] zzg;
    private int zzl;

    static {
        zzr zzrVar = new zzr();
        zzrVar.zzb(1);
        zzrVar.zza(1);
        zzrVar.zzc(2);
        zzb = zzrVar.zzd();
        zzh = Integer.toString(0, 36);
        zzi = Integer.toString(1, 36);
        zzj = Integer.toString(2, 36);
        zzk = Integer.toString(3, 36);
        zzc = new zzn() { // from class: com.google.android.gms.internal.ads.zzp
        };
    }

    @Deprecated
    public zzs(int i4, int i5, int i6, @Nullable byte[] bArr) {
        this.zzd = i4;
        this.zze = i5;
        this.zzf = i6;
        this.zzg = bArr;
    }

    @Pure
    public static int zza(int i4) {
        if (i4 == 1) {
            return 1;
        }
        if (i4 == 9) {
            return 6;
        }
        if (i4 != 4 && i4 != 5 && i4 != 6 && i4 != 7) {
            return -1;
        }
        return 2;
    }

    @Pure
    public static int zzb(int i4) {
        if (i4 != 1) {
            if (i4 != 4) {
                if (i4 != 13) {
                    if (i4 == 16) {
                        return 6;
                    }
                    if (i4 == 18) {
                        return 7;
                    }
                    if (i4 != 6 && i4 != 7) {
                        return -1;
                    }
                    return 3;
                }
                return 2;
            }
            return 10;
        }
        return 3;
    }

    private static String zzf(int i4) {
        if (i4 != -1) {
            if (i4 != 1) {
                if (i4 != 2) {
                    return "Undefined color range";
                }
                return "Limited range";
            }
            return "Full range";
        }
        return "Unset color range";
    }

    private static String zzg(int i4) {
        if (i4 != -1) {
            if (i4 != 6) {
                if (i4 != 1) {
                    if (i4 != 2) {
                        return "Undefined color space";
                    }
                    return "BT601";
                }
                return "BT709";
            }
            return "BT2020";
        }
        return "Unset color space";
    }

    private static String zzh(int i4) {
        if (i4 != -1) {
            if (i4 != 10) {
                if (i4 != 1) {
                    if (i4 != 2) {
                        if (i4 != 3) {
                            if (i4 != 6) {
                                if (i4 != 7) {
                                    return "Undefined color transfer";
                                }
                                return "HLG";
                            }
                            return "ST2084 PQ";
                        }
                        return "SDR SMPTE 170M";
                    }
                    return "sRGB";
                }
                return "Linear";
            }
            return "Gamma 2.2";
        }
        return "Unset color transfer";
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzs.class == obj.getClass()) {
            zzs zzsVar = (zzs) obj;
            if (this.zzd == zzsVar.zzd && this.zze == zzsVar.zze && this.zzf == zzsVar.zzf && Arrays.equals(this.zzg, zzsVar.zzg)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i4 = this.zzl;
        if (i4 == 0) {
            int hashCode = ((((((this.zzd + 527) * 31) + this.zze) * 31) + this.zzf) * 31) + Arrays.hashCode(this.zzg);
            this.zzl = hashCode;
            return hashCode;
        }
        return i4;
    }

    public final String toString() {
        boolean z3;
        String zzg = zzg(this.zzd);
        String zzf = zzf(this.zze);
        String zzh2 = zzh(this.zzf);
        byte[] bArr = this.zzg;
        StringBuilder sb = new StringBuilder();
        sb.append("ColorInfo(");
        sb.append(zzg);
        sb.append(", ");
        sb.append(zzf);
        sb.append(", ");
        sb.append(zzh2);
        sb.append(", ");
        if (bArr != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        sb.append(z3);
        sb.append(")");
        return sb.toString();
    }

    public final zzr zzc() {
        return new zzr(this, null);
    }

    public final String zzd() {
        if (!zze()) {
            return "NA";
        }
        return String.format(Locale.US, "%s/%s/%s", zzg(this.zzd), zzf(this.zze), zzh(this.zzf));
    }

    public final boolean zze() {
        if (this.zzd != -1 && this.zze != -1 && this.zzf != -1) {
            return true;
        }
        return false;
    }
}
