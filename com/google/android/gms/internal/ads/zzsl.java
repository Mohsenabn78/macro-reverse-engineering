package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.media.MediaCodecInfo;
import android.util.Pair;
import androidx.annotation.CheckResult;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
@SuppressLint({"InlinedApi"})
/* loaded from: classes4.dex */
public final class zzsl {
    public static final /* synthetic */ int zza = 0;
    private static final Pattern zzb = Pattern.compile("^\\D?(\\d+)$");
    @GuardedBy("MediaCodecUtil.class")
    private static final HashMap zzc = new HashMap();
    private static int zzd = -1;

    public static int zza() throws zzsf {
        int i4;
        int i5;
        int i6 = zzd;
        if (i6 == -1) {
            zzrs zzc2 = zzc("video/avc", false, false);
            if (zzc2 != null) {
                int i7 = 0;
                for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : zzc2.zzh()) {
                    int i8 = codecProfileLevel.level;
                    if (i8 != 1 && i8 != 2) {
                        switch (i8) {
                            case 8:
                            case 16:
                            case 32:
                                i5 = 101376;
                                continue;
                            case 64:
                                i5 = 202752;
                                continue;
                            case 128:
                            case 256:
                                i5 = 414720;
                                continue;
                            case 512:
                                i5 = 921600;
                                continue;
                            case 1024:
                                i5 = 1310720;
                                continue;
                            case 2048:
                            case 4096:
                                i5 = 2097152;
                                continue;
                            case 8192:
                                i5 = 2228224;
                                continue;
                            case 16384:
                                i5 = 5652480;
                                continue;
                            case 32768:
                            case 65536:
                                i5 = 9437184;
                                continue;
                            case 131072:
                            case 262144:
                            case 524288:
                                i5 = 35651584;
                                continue;
                            default:
                                i5 = -1;
                                continue;
                        }
                    } else {
                        i5 = 25344;
                    }
                    i7 = Math.max(i5, i7);
                }
                if (zzfj.zza >= 21) {
                    i4 = 345600;
                } else {
                    i4 = 172800;
                }
                i6 = Math.max(i7, i4);
            } else {
                i6 = 0;
            }
            zzd = i6;
        }
        return i6;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x02c5 A[Catch: NumberFormatException -> 0x02d5, TRY_LEAVE, TryCatch #0 {NumberFormatException -> 0x02d5, blocks: (B:148:0x026a, B:150:0x027c, B:161:0x0298, B:177:0x02c5), top: B:491:0x026a }] */
    /* JADX WARN: Removed duplicated region for block: B:366:0x061c  */
    /* JADX WARN: Removed duplicated region for block: B:367:0x062b  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x011e  */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.util.Pair zzb(com.google.android.gms.internal.ads.zzam r17) {
        /*
            Method dump skipped, instructions count: 2548
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzsl.zzb(com.google.android.gms.internal.ads.zzam):android.util.Pair");
    }

    @Nullable
    public static zzrs zzc(String str, boolean z3, boolean z4) throws zzsf {
        List zzg = zzg(str, false, false);
        if (zzg.isEmpty()) {
            return null;
        }
        return (zzrs) zzg.get(0);
    }

    @Nullable
    public static zzrs zzd() throws zzsf {
        return zzc("audio/raw", false, false);
    }

    @Nullable
    public static String zze(zzam zzamVar) {
        Pair zzb2;
        if ("audio/eac3-joc".equals(zzamVar.zzm)) {
            return "audio/eac3";
        }
        if ("video/dolby-vision".equals(zzamVar.zzm) && (zzb2 = zzb(zzamVar)) != null) {
            int intValue = ((Integer) zzb2.first).intValue();
            if (intValue != 16 && intValue != 256) {
                if (intValue == 512) {
                    return "video/avc";
                }
                return null;
            }
            return "video/hevc";
        }
        return null;
    }

    public static List zzf(zzry zzryVar, zzam zzamVar, boolean z3, boolean z4) throws zzsf {
        String zze = zze(zzamVar);
        if (zze == null) {
            return zzfsc.zzl();
        }
        return zzg(zze, z3, z4);
    }

    public static synchronized List zzg(String str, boolean z3, boolean z4) throws zzsf {
        zzsg zzsiVar;
        synchronized (zzsl.class) {
            zzsd zzsdVar = new zzsd(str, z3, z4);
            HashMap hashMap = zzc;
            List list = (List) hashMap.get(zzsdVar);
            if (list != null) {
                return list;
            }
            int i4 = zzfj.zza;
            if (i4 >= 21) {
                zzsiVar = new zzsj(z3, z4);
            } else {
                zzsiVar = new zzsi(null);
            }
            ArrayList zzj = zzj(zzsdVar, zzsiVar);
            if (z3 && zzj.isEmpty() && i4 >= 21 && i4 <= 23) {
                zzj = zzj(zzsdVar, new zzsi(null));
                if (!zzj.isEmpty()) {
                    String str2 = ((zzrs) zzj.get(0)).zza;
                    zzer.zzf("MediaCodecUtil", "MediaCodecList API didn't list secure decoder for: " + str + ". Assuming: " + str2);
                }
            }
            if ("audio/raw".equals(str)) {
                if (i4 < 26 && zzfj.zzb.equals("R9") && zzj.size() == 1 && ((zzrs) zzj.get(0)).zza.equals("OMX.MTK.AUDIO.DECODER.RAW")) {
                    zzj.add(zzrs.zzc("OMX.google.raw.decoder", "audio/raw", "audio/raw", null, false, true, false, false, false));
                }
                zzk(zzj, new zzsk() { // from class: com.google.android.gms.internal.ads.zzsb
                    @Override // com.google.android.gms.internal.ads.zzsk
                    public final int zza(Object obj) {
                        int i5 = zzsl.zza;
                        String str3 = ((zzrs) obj).zza;
                        if (str3.startsWith("OMX.google") || str3.startsWith("c2.android")) {
                            return 1;
                        }
                        if (zzfj.zza >= 26 || !str3.equals("OMX.MTK.AUDIO.DECODER.RAW")) {
                            return 0;
                        }
                        return -1;
                    }
                });
            }
            if (i4 < 21 && zzj.size() > 1) {
                String str3 = ((zzrs) zzj.get(0)).zza;
                if ("OMX.SEC.mp3.dec".equals(str3) || "OMX.SEC.MP3.Decoder".equals(str3) || "OMX.brcm.audio.mp3.decoder".equals(str3)) {
                    zzk(zzj, new zzsk() { // from class: com.google.android.gms.internal.ads.zzsc
                        @Override // com.google.android.gms.internal.ads.zzsk
                        public final int zza(Object obj) {
                            int i5 = zzsl.zza;
                            if (((zzrs) obj).zza.startsWith("OMX.google")) {
                                return 1;
                            }
                            return 0;
                        }
                    });
                }
            }
            if (i4 < 32 && zzj.size() > 1 && "OMX.qti.audio.decoder.flac".equals(((zzrs) zzj.get(0)).zza)) {
                zzj.add((zzrs) zzj.remove(0));
            }
            zzfsc zzj2 = zzfsc.zzj(zzj);
            hashMap.put(zzsdVar, zzj2);
            return zzj2;
        }
    }

    @RequiresNonNull({"#2.sampleMimeType"})
    public static List zzh(zzry zzryVar, zzam zzamVar, boolean z3, boolean z4) throws zzsf {
        List zzg = zzg(zzamVar.zzm, z3, z4);
        List zzf = zzf(zzryVar, zzamVar, z3, z4);
        zzfrz zzfrzVar = new zzfrz();
        zzfrzVar.zzh(zzg);
        zzfrzVar.zzh(zzf);
        return zzfrzVar.zzi();
    }

    @CheckResult
    public static List zzi(List list, final zzam zzamVar) {
        ArrayList arrayList = new ArrayList(list);
        zzk(arrayList, new zzsk() { // from class: com.google.android.gms.internal.ads.zzrz
            @Override // com.google.android.gms.internal.ads.zzsk
            public final int zza(Object obj) {
                zzam zzamVar2 = zzam.this;
                int i4 = zzsl.zza;
                if (((zzrs) obj).zzd(zzamVar2)) {
                    return 1;
                }
                return 0;
            }
        });
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:150:0x0233, code lost:
        if (r1.zzb == false) goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00da, code lost:
        if ("SCV31".equals(r10) == false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0118, code lost:
        if (r8.startsWith("t0") == false) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x002a, code lost:
        if (r9 != false) goto L9;
     */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01e7 A[Catch: Exception -> 0x029e, TryCatch #1 {Exception -> 0x029e, blocks: (B:115:0x01b6, B:121:0x01cd, B:127:0x01e1, B:129:0x01e7, B:134:0x01f9, B:136:0x0201, B:146:0x022b, B:137:0x0206, B:139:0x0216, B:141:0x021e, B:130:0x01ee), top: B:187:0x01b6 }] */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01ee A[Catch: Exception -> 0x029e, TryCatch #1 {Exception -> 0x029e, blocks: (B:115:0x01b6, B:121:0x01cd, B:127:0x01e1, B:129:0x01e7, B:134:0x01f9, B:136:0x0201, B:146:0x022b, B:137:0x0206, B:139:0x0216, B:141:0x021e, B:130:0x01ee), top: B:187:0x01b6 }] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0201 A[Catch: Exception -> 0x029e, TryCatch #1 {Exception -> 0x029e, blocks: (B:115:0x01b6, B:121:0x01cd, B:127:0x01e1, B:129:0x01e7, B:134:0x01f9, B:136:0x0201, B:146:0x022b, B:137:0x0206, B:139:0x0216, B:141:0x021e, B:130:0x01ee), top: B:187:0x01b6 }] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0206 A[Catch: Exception -> 0x029e, TryCatch #1 {Exception -> 0x029e, blocks: (B:115:0x01b6, B:121:0x01cd, B:127:0x01e1, B:129:0x01e7, B:134:0x01f9, B:136:0x0201, B:146:0x022b, B:137:0x0206, B:139:0x0216, B:141:0x021e, B:130:0x01ee), top: B:187:0x01b6 }] */
    /* JADX WARN: Removed duplicated region for block: B:175:0x02b0 A[Catch: Exception -> 0x02ff, TRY_ENTER, TryCatch #0 {Exception -> 0x02ff, blocks: (B:3:0x0008, B:5:0x001c, B:7:0x0026, B:10:0x0034, B:14:0x0042, B:18:0x004c, B:20:0x0054, B:22:0x005c, B:24:0x0064, B:26:0x006c, B:28:0x0074, B:32:0x0082, B:34:0x008a, B:36:0x0092, B:38:0x009a, B:40:0x00a4, B:42:0x00ac, B:44:0x00b4, B:46:0x00bc, B:48:0x00c4, B:50:0x00cc, B:52:0x00d4, B:56:0x00e2, B:58:0x00ea, B:60:0x00f2, B:62:0x00fc, B:64:0x0104, B:66:0x010a, B:68:0x0112, B:71:0x011c, B:73:0x0124, B:77:0x0130, B:79:0x0138, B:81:0x0140, B:83:0x0148, B:172:0x02a8, B:175:0x02b0, B:177:0x02b6, B:178:0x02d0, B:179:0x02f3, B:86:0x0151, B:87:0x0154, B:89:0x015c, B:92:0x0167, B:94:0x016f, B:97:0x017a, B:99:0x0182, B:102:0x018d, B:104:0x0195, B:107:0x01a0, B:109:0x01a8), top: B:185:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0231 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:199:0x02d0 A[ADDED_TO_REGION, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.util.ArrayList zzj(com.google.android.gms.internal.ads.zzsd r27, com.google.android.gms.internal.ads.zzsg r28) throws com.google.android.gms.internal.ads.zzsf {
        /*
            Method dump skipped, instructions count: 775
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzsl.zzj(com.google.android.gms.internal.ads.zzsd, com.google.android.gms.internal.ads.zzsg):java.util.ArrayList");
    }

    private static void zzk(List list, final zzsk zzskVar) {
        Collections.sort(list, new Comparator() { // from class: com.google.android.gms.internal.ads.zzsa
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                zzsk zzskVar2 = zzsk.this;
                int i4 = zzsl.zza;
                return zzskVar2.zza(obj2) - zzskVar2.zza(obj);
            }
        });
    }

    private static boolean zzl(MediaCodecInfo mediaCodecInfo, String str) {
        boolean isSoftwareOnly;
        if (zzfj.zza >= 29) {
            isSoftwareOnly = mediaCodecInfo.isSoftwareOnly();
            return isSoftwareOnly;
        } else if (zzcc.zzf(str)) {
            return true;
        } else {
            String zza2 = zzfon.zza(mediaCodecInfo.getName());
            if (zza2.startsWith("arc.")) {
                return false;
            }
            if (zza2.startsWith("omx.google.") || zza2.startsWith("omx.ffmpeg.")) {
                return true;
            }
            if ((zza2.startsWith("omx.sec.") && zza2.contains(".sw.")) || zza2.equals("omx.qcom.video.decoder.hevcswvdec") || zza2.startsWith("c2.android.") || zza2.startsWith("c2.google.")) {
                return true;
            }
            if (!zza2.startsWith("omx.") && !zza2.startsWith("c2.")) {
                return true;
            }
            return false;
        }
    }
}
