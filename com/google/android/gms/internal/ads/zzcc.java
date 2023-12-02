package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzcc {
    public static final /* synthetic */ int zza = 0;
    private static final ArrayList zzb = new ArrayList();
    private static final Pattern zzc = Pattern.compile("^mp4a\\.([a-zA-Z0-9]{2})(?:\\.([0-9]{1,2}))?$");

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int zza(String str, @Nullable String str2) {
        char c4;
        zzcb zzc2;
        switch (str.hashCode()) {
            case -2123537834:
                if (str.equals("audio/eac3-joc")) {
                    c4 = 4;
                    break;
                }
                c4 = 65535;
                break;
            case -1365340241:
                if (str.equals("audio/vnd.dts.hd;profile=lbr")) {
                    c4 = '\b';
                    break;
                }
                c4 = 65535;
                break;
            case -1095064472:
                if (str.equals("audio/vnd.dts")) {
                    c4 = 6;
                    break;
                }
                c4 = 65535;
                break;
            case -53558318:
                if (str.equals("audio/mp4a-latm")) {
                    c4 = 1;
                    break;
                }
                c4 = 65535;
                break;
            case 187078296:
                if (str.equals("audio/ac3")) {
                    c4 = 2;
                    break;
                }
                c4 = 65535;
                break;
            case 187078297:
                if (str.equals("audio/ac4")) {
                    c4 = 5;
                    break;
                }
                c4 = 65535;
                break;
            case 550520934:
                if (str.equals("audio/vnd.dts.uhd;profile=p2")) {
                    c4 = '\t';
                    break;
                }
                c4 = 65535;
                break;
            case 1504578661:
                if (str.equals("audio/eac3")) {
                    c4 = 3;
                    break;
                }
                c4 = 65535;
                break;
            case 1504831518:
                if (str.equals("audio/mpeg")) {
                    c4 = 0;
                    break;
                }
                c4 = 65535;
                break;
            case 1504891608:
                if (str.equals("audio/opus")) {
                    c4 = 11;
                    break;
                }
                c4 = 65535;
                break;
            case 1505942594:
                if (str.equals("audio/vnd.dts.hd")) {
                    c4 = 7;
                    break;
                }
                c4 = 65535;
                break;
            case 1556697186:
                if (str.equals("audio/true-hd")) {
                    c4 = '\n';
                    break;
                }
                c4 = 65535;
                break;
            default:
                c4 = 65535;
                break;
        }
        switch (c4) {
            case 0:
                return 9;
            case 1:
                if (str2 == null || (zzc2 = zzc(str2)) == null) {
                    return 0;
                }
                return zzc2.zza();
            case 2:
                return 5;
            case 3:
                return 6;
            case 4:
                return 18;
            case 5:
                return 17;
            case 6:
                return 7;
            case 7:
            case '\b':
                return 8;
            case '\t':
                return 30;
            case '\n':
                return 14;
            case 11:
                return 20;
            default:
                return 0;
        }
    }

    public static int zzb(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (zzf(str)) {
            return 1;
        }
        if (!zzg(str)) {
            if (!"text".equals(zzh(str)) && !"application/cea-608".equals(str) && !"application/cea-708".equals(str) && !"application/x-mp4-cea-608".equals(str) && !"application/x-subrip".equals(str) && !"application/ttml+xml".equals(str) && !"application/x-quicktime-tx3g".equals(str) && !"application/x-mp4-vtt".equals(str) && !"application/x-rawcc".equals(str) && !"application/vobsub".equals(str) && !"application/pgs".equals(str) && !"application/dvbsubs".equals(str)) {
                if ("image".equals(zzh(str))) {
                    return 4;
                }
                if (!"application/id3".equals(str) && !"application/x-emsg".equals(str) && !"application/x-scte35".equals(str)) {
                    if (!"application/x-camera-motion".equals(str)) {
                        int size = zzb.size();
                        for (int i4 = 0; i4 < size; i4++) {
                            String str2 = ((zzca) zzb.get(i4)).zza;
                            if (str.equals(null)) {
                                return 0;
                            }
                        }
                        return -1;
                    }
                    return 6;
                }
                return 5;
            }
            return 3;
        }
        return 2;
    }

    @Nullable
    @VisibleForTesting
    static zzcb zzc(String str) {
        int i4;
        Matcher matcher = zzc.matcher(str);
        if (!matcher.matches()) {
            return null;
        }
        String group = matcher.group(1);
        group.getClass();
        String group2 = matcher.group(2);
        try {
            int parseInt = Integer.parseInt(group, 16);
            if (group2 != null) {
                i4 = Integer.parseInt(group2);
            } else {
                i4 = 0;
            }
            return new zzcb(parseInt, i4);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @Nullable
    public static String zzd(int i4) {
        if (i4 != 32) {
            if (i4 != 33) {
                if (i4 != 35) {
                    if (i4 != 64) {
                        if (i4 != 163) {
                            if (i4 != 177) {
                                if (i4 != 165) {
                                    if (i4 != 166) {
                                        switch (i4) {
                                            case 96:
                                            case 97:
                                            case 98:
                                            case 99:
                                            case 100:
                                            case 101:
                                                return "video/mpeg2";
                                            case 102:
                                            case 103:
                                            case 104:
                                                return "audio/mp4a-latm";
                                            case 105:
                                            case 107:
                                                return "audio/mpeg";
                                            case 106:
                                                return "video/mpeg";
                                            default:
                                                switch (i4) {
                                                    case 169:
                                                    case 172:
                                                        return "audio/vnd.dts";
                                                    case 170:
                                                    case 171:
                                                        return "audio/vnd.dts.hd";
                                                    case 173:
                                                        return "audio/opus";
                                                    case 174:
                                                        return "audio/ac4";
                                                    default:
                                                        return null;
                                                }
                                        }
                                    }
                                    return "audio/eac3";
                                }
                                return "audio/ac3";
                            }
                            return "video/x-vnd.on2.vp9";
                        }
                        return "video/wvc1";
                    }
                    return "audio/mp4a-latm";
                }
                return "video/hevc";
            }
            return "video/avc";
        }
        return "video/mp4v-es";
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static boolean zze(@Nullable String str, @Nullable String str2) {
        char c4;
        zzcb zzc2;
        int zza2;
        if (str == null) {
            return false;
        }
        switch (str.hashCode()) {
            case -2123537834:
                if (str.equals("audio/eac3-joc")) {
                    c4 = '\t';
                    break;
                }
                c4 = 65535;
                break;
            case -432837260:
                if (str.equals("audio/mpeg-L1")) {
                    c4 = 1;
                    break;
                }
                c4 = 65535;
                break;
            case -432837259:
                if (str.equals("audio/mpeg-L2")) {
                    c4 = 2;
                    break;
                }
                c4 = 65535;
                break;
            case -53558318:
                if (str.equals("audio/mp4a-latm")) {
                    c4 = '\n';
                    break;
                }
                c4 = 65535;
                break;
            case 187078296:
                if (str.equals("audio/ac3")) {
                    c4 = 7;
                    break;
                }
                c4 = 65535;
                break;
            case 187094639:
                if (str.equals("audio/raw")) {
                    c4 = 3;
                    break;
                }
                c4 = 65535;
                break;
            case 1504578661:
                if (str.equals("audio/eac3")) {
                    c4 = '\b';
                    break;
                }
                c4 = 65535;
                break;
            case 1504619009:
                if (str.equals("audio/flac")) {
                    c4 = 6;
                    break;
                }
                c4 = 65535;
                break;
            case 1504831518:
                if (str.equals("audio/mpeg")) {
                    c4 = 0;
                    break;
                }
                c4 = 65535;
                break;
            case 1903231877:
                if (str.equals("audio/g711-alaw")) {
                    c4 = 4;
                    break;
                }
                c4 = 65535;
                break;
            case 1903589369:
                if (str.equals("audio/g711-mlaw")) {
                    c4 = 5;
                    break;
                }
                c4 = 65535;
                break;
            default:
                c4 = 65535;
                break;
        }
        switch (c4) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case '\b':
            case '\t':
                return true;
            case '\n':
                if (str2 == null || (zzc2 = zzc(str2)) == null || (zza2 = zzc2.zza()) == 0 || zza2 == 16) {
                    return false;
                }
                return true;
            default:
                return false;
        }
    }

    public static boolean zzf(@Nullable String str) {
        return "audio".equals(zzh(str));
    }

    public static boolean zzg(@Nullable String str) {
        return "video".equals(zzh(str));
    }

    @Nullable
    private static String zzh(@Nullable String str) {
        int indexOf;
        if (str == null || (indexOf = str.indexOf(47)) == -1) {
            return null;
        }
        return str.substring(0, indexOf);
    }
}
