package com.google.android.gms.internal.ads;

import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzrs {
    public final String zza;
    public final String zzb;
    public final String zzc;
    @Nullable
    public final MediaCodecInfo.CodecCapabilities zzd;
    public final boolean zze;
    public final boolean zzf;
    public final boolean zzg;
    private final boolean zzh;

    @VisibleForTesting
    zzrs(String str, String str2, String str3, @Nullable MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8) {
        str.getClass();
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = codecCapabilities;
        this.zzg = z3;
        this.zze = z6;
        this.zzf = z8;
        this.zzh = zzcc.zzg(str2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0028, code lost:
        if ("Nexus 10".equals(r3) == false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0038, code lost:
        if ("OMX.Exynos.AVC.Decoder.secure".equals(r12) == false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.android.gms.internal.ads.zzrs zzc(java.lang.String r12, java.lang.String r13, java.lang.String r14, @androidx.annotation.Nullable android.media.MediaCodecInfo.CodecCapabilities r15, boolean r16, boolean r17, boolean r18, boolean r19, boolean r20) {
        /*
            r1 = r12
            r4 = r15
            com.google.android.gms.internal.ads.zzrs r11 = new com.google.android.gms.internal.ads.zzrs
            r0 = 1
            r2 = 0
            if (r4 == 0) goto L3d
            int r3 = com.google.android.gms.internal.ads.zzfj.zza
            java.lang.String r3 = "adaptive-playback"
            boolean r3 = r15.isFeatureSupported(r3)
            if (r3 == 0) goto L3d
            int r3 = com.google.android.gms.internal.ads.zzfj.zza
            r5 = 22
            if (r3 > r5) goto L3b
            java.lang.String r3 = com.google.android.gms.internal.ads.zzfj.zzd
            java.lang.String r5 = "ODROID-XU3"
            boolean r5 = r5.equals(r3)
            if (r5 != 0) goto L2a
            java.lang.String r5 = "Nexus 10"
            boolean r3 = r5.equals(r3)
            if (r3 == 0) goto L3b
        L2a:
            java.lang.String r3 = "OMX.Exynos.AVC.Decoder"
            boolean r3 = r3.equals(r12)
            if (r3 != 0) goto L3d
            java.lang.String r3 = "OMX.Exynos.AVC.Decoder.secure"
            boolean r3 = r3.equals(r12)
            if (r3 == 0) goto L3b
            goto L3d
        L3b:
            r8 = 1
            goto L3e
        L3d:
            r8 = 0
        L3e:
            r3 = 21
            if (r4 == 0) goto L50
            int r5 = com.google.android.gms.internal.ads.zzfj.zza
            if (r5 < r3) goto L50
            java.lang.String r5 = "tunneled-playback"
            boolean r5 = r15.isFeatureSupported(r5)
            if (r5 == 0) goto L50
            r9 = 1
            goto L51
        L50:
            r9 = 0
        L51:
            if (r20 != 0) goto L64
            if (r4 == 0) goto L62
            int r5 = com.google.android.gms.internal.ads.zzfj.zza
            if (r5 < r3) goto L62
            java.lang.String r3 = "secure-playback"
            boolean r3 = r15.isFeatureSupported(r3)
            if (r3 == 0) goto L62
            goto L64
        L62:
            r10 = 0
            goto L65
        L64:
            r10 = 1
        L65:
            r0 = r11
            r1 = r12
            r2 = r13
            r3 = r14
            r4 = r15
            r5 = r16
            r6 = r17
            r7 = r18
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzrs.zzc(java.lang.String, java.lang.String, java.lang.String, android.media.MediaCodecInfo$CodecCapabilities, boolean, boolean, boolean, boolean, boolean):com.google.android.gms.internal.ads.zzrs");
    }

    @RequiresApi(21)
    private static Point zzi(MediaCodecInfo.VideoCapabilities videoCapabilities, int i4, int i5) {
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        int i6 = zzfj.zza;
        return new Point((((i4 + widthAlignment) - 1) / widthAlignment) * widthAlignment, (((i5 + heightAlignment) - 1) / heightAlignment) * heightAlignment);
    }

    private final void zzj(String str) {
        String str2 = this.zza;
        String str3 = this.zzb;
        String str4 = zzfj.zze;
        zzer.zzb("MediaCodecInfo", "NoSupport [" + str + "] [" + str2 + ", " + str3 + "] [" + str4 + "]");
    }

    @RequiresApi(21)
    private static boolean zzk(MediaCodecInfo.VideoCapabilities videoCapabilities, int i4, int i5, double d4) {
        Point zzi = zzi(videoCapabilities, i4, i5);
        int i6 = zzi.x;
        int i7 = zzi.y;
        if (d4 != -1.0d && d4 >= 1.0d) {
            return videoCapabilities.areSizeAndRateSupported(i6, i7, Math.floor(d4));
        }
        return videoCapabilities.isSizeSupported(i6, i7);
    }

    private final boolean zzl(zzam zzamVar, boolean z3) {
        int i4;
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        Pair zzb = zzsl.zzb(zzamVar);
        if (zzb == null) {
            return true;
        }
        int intValue = ((Integer) zzb.first).intValue();
        int intValue2 = ((Integer) zzb.second).intValue();
        int i5 = 8;
        if ("video/dolby-vision".equals(zzamVar.zzm)) {
            if ("video/avc".equals(this.zzb)) {
                intValue2 = 0;
                intValue = 8;
            } else if ("video/hevc".equals(this.zzb)) {
                intValue2 = 0;
                intValue = 2;
            }
        }
        if (!this.zzh && intValue != 42) {
            return true;
        }
        MediaCodecInfo.CodecProfileLevel[] zzh = zzh();
        if (zzfj.zza <= 23 && "video/x-vnd.on2.vp9".equals(this.zzb) && zzh.length == 0) {
            MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzd;
            if (codecCapabilities != null && (videoCapabilities = codecCapabilities.getVideoCapabilities()) != null) {
                i4 = videoCapabilities.getBitrateRange().getUpper().intValue();
            } else {
                i4 = 0;
            }
            if (i4 >= 180000000) {
                i5 = 1024;
            } else if (i4 >= 120000000) {
                i5 = 512;
            } else if (i4 >= 60000000) {
                i5 = 256;
            } else if (i4 >= 30000000) {
                i5 = 128;
            } else if (i4 >= 18000000) {
                i5 = 64;
            } else if (i4 >= 12000000) {
                i5 = 32;
            } else if (i4 >= 7200000) {
                i5 = 16;
            } else if (i4 < 3600000) {
                if (i4 >= 1800000) {
                    i5 = 4;
                } else if (i4 >= 800000) {
                    i5 = 2;
                } else {
                    i5 = 1;
                }
            }
            MediaCodecInfo.CodecProfileLevel codecProfileLevel = new MediaCodecInfo.CodecProfileLevel();
            codecProfileLevel.profile = 1;
            codecProfileLevel.level = i5;
            zzh = new MediaCodecInfo.CodecProfileLevel[]{codecProfileLevel};
        }
        for (MediaCodecInfo.CodecProfileLevel codecProfileLevel2 : zzh) {
            if (codecProfileLevel2.profile == intValue && (codecProfileLevel2.level >= intValue2 || !z3)) {
                if ("video/hevc".equals(this.zzb) && intValue == 2) {
                    String str = zzfj.zzb;
                    if (!"sailfish".equals(str) && !"marlin".equals(str)) {
                    }
                }
                return true;
            }
        }
        zzj("codec.profileLevel, " + zzamVar.zzj + ", " + this.zzc);
        return false;
    }

    private final boolean zzm(zzam zzamVar) {
        if (!this.zzb.equals(zzamVar.zzm) && !this.zzb.equals(zzsl.zze(zzamVar))) {
            return false;
        }
        return true;
    }

    public final String toString() {
        return this.zza;
    }

    @Nullable
    @RequiresApi(21)
    public final Point zza(int i4, int i5) {
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzd;
        if (codecCapabilities == null || (videoCapabilities = codecCapabilities.getVideoCapabilities()) == null) {
            return null;
        }
        return zzi(videoCapabilities, i4, i5);
    }

    public final zzia zzb(zzam zzamVar, zzam zzamVar2) {
        int i4;
        int i5;
        if (true != zzfj.zzC(zzamVar.zzm, zzamVar2.zzm)) {
            i4 = 8;
        } else {
            i4 = 0;
        }
        if (this.zzh) {
            if (zzamVar.zzu != zzamVar2.zzu) {
                i4 |= 1024;
            }
            if (!this.zze && (zzamVar.zzr != zzamVar2.zzr || zzamVar.zzs != zzamVar2.zzs)) {
                i4 |= 512;
            }
            if (!zzfj.zzC(zzamVar.zzy, zzamVar2.zzy)) {
                i4 |= 2048;
            }
            String str = this.zza;
            if (zzfj.zzd.startsWith("SM-T230") && "OMX.MARVELL.VIDEO.HW.CODA7542DECODER".equals(str) && !zzamVar.zzd(zzamVar2)) {
                i4 |= 2;
            }
            if (i4 == 0) {
                String str2 = this.zza;
                if (true != zzamVar.zzd(zzamVar2)) {
                    i5 = 2;
                } else {
                    i5 = 3;
                }
                return new zzia(str2, zzamVar, zzamVar2, i5, 0);
            }
        } else {
            if (zzamVar.zzz != zzamVar2.zzz) {
                i4 |= 4096;
            }
            if (zzamVar.zzA != zzamVar2.zzA) {
                i4 |= 8192;
            }
            if (zzamVar.zzB != zzamVar2.zzB) {
                i4 |= 16384;
            }
            if (i4 == 0 && "audio/mp4a-latm".equals(this.zzb)) {
                Pair zzb = zzsl.zzb(zzamVar);
                Pair zzb2 = zzsl.zzb(zzamVar2);
                if (zzb != null && zzb2 != null) {
                    int intValue = ((Integer) zzb.first).intValue();
                    int intValue2 = ((Integer) zzb2.first).intValue();
                    if (intValue == 42 && intValue2 == 42) {
                        return new zzia(this.zza, zzamVar, zzamVar2, 3, 0);
                    }
                }
            }
            if (!zzamVar.zzd(zzamVar2)) {
                i4 |= 32;
            }
            if ("audio/opus".equals(this.zzb)) {
                i4 |= 2;
            }
            if (i4 == 0) {
                return new zzia(this.zza, zzamVar, zzamVar2, 1, 0);
            }
        }
        return new zzia(this.zza, zzamVar, zzamVar2, 0, i4);
    }

    public final boolean zzd(zzam zzamVar) {
        if (!zzm(zzamVar) || !zzl(zzamVar, false)) {
            return false;
        }
        return true;
    }

    public final boolean zze(zzam zzamVar) throws zzsf {
        int i4;
        int i5;
        boolean z3 = false;
        if (!zzm(zzamVar) || !zzl(zzamVar, true)) {
            return false;
        }
        if (this.zzh) {
            int i6 = zzamVar.zzr;
            if (i6 <= 0 || (i5 = zzamVar.zzs) <= 0) {
                return true;
            }
            if (zzfj.zza >= 21) {
                return zzg(i6, i5, zzamVar.zzt);
            }
            if (i6 * i5 <= zzsl.zza()) {
                z3 = true;
            }
            if (!z3) {
                int i7 = zzamVar.zzr;
                int i8 = zzamVar.zzs;
                zzj("legacyFrameSize, " + i7 + "x" + i8);
            }
            return z3;
        }
        int i9 = zzfj.zza;
        if (i9 >= 21) {
            int i10 = zzamVar.zzA;
            if (i10 != -1) {
                MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzd;
                if (codecCapabilities == null) {
                    zzj("sampleRate.caps");
                    return false;
                }
                MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
                if (audioCapabilities == null) {
                    zzj("sampleRate.aCaps");
                    return false;
                } else if (!audioCapabilities.isSampleRateSupported(i10)) {
                    zzj("sampleRate.support, " + i10);
                    return false;
                }
            }
            int i11 = zzamVar.zzz;
            if (i11 != -1) {
                MediaCodecInfo.CodecCapabilities codecCapabilities2 = this.zzd;
                if (codecCapabilities2 == null) {
                    zzj("channelCount.caps");
                } else {
                    MediaCodecInfo.AudioCapabilities audioCapabilities2 = codecCapabilities2.getAudioCapabilities();
                    if (audioCapabilities2 == null) {
                        zzj("channelCount.aCaps");
                    } else {
                        String str = this.zza;
                        String str2 = this.zzb;
                        int maxInputChannelCount = audioCapabilities2.getMaxInputChannelCount();
                        if (maxInputChannelCount <= 1 && ((i9 < 26 || maxInputChannelCount <= 0) && !"audio/mpeg".equals(str2) && !"audio/3gpp".equals(str2) && !"audio/amr-wb".equals(str2) && !"audio/mp4a-latm".equals(str2) && !"audio/vorbis".equals(str2) && !"audio/opus".equals(str2) && !"audio/raw".equals(str2) && !"audio/flac".equals(str2) && !"audio/g711-alaw".equals(str2) && !"audio/g711-mlaw".equals(str2) && !"audio/gsm".equals(str2))) {
                            if ("audio/ac3".equals(str2)) {
                                i4 = 6;
                            } else if ("audio/eac3".equals(str2)) {
                                i4 = 16;
                            } else {
                                i4 = 30;
                            }
                            zzer.zzf("MediaCodecInfo", "AssumedMaxChannelAdjustment: " + str + ", [" + maxInputChannelCount + " to " + i4 + "]");
                            maxInputChannelCount = i4;
                        }
                        if (maxInputChannelCount < i11) {
                            zzj("channelCount.support, " + i11);
                        }
                    }
                }
                return false;
            }
        }
        return true;
    }

    public final boolean zzf(zzam zzamVar) {
        if (this.zzh) {
            return this.zze;
        }
        Pair zzb = zzsl.zzb(zzamVar);
        if (zzb != null && ((Integer) zzb.first).intValue() == 42) {
            return true;
        }
        return false;
    }

    @RequiresApi(21)
    public final boolean zzg(int i4, int i5, double d4) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzd;
        if (codecCapabilities == null) {
            zzj("sizeAndRate.caps");
            return false;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            zzj("sizeAndRate.vCaps");
            return false;
        }
        if (zzfj.zza >= 29) {
            int zza = zzrr.zza(videoCapabilities, i4, i5, d4);
            if (zza == 2) {
                return true;
            }
            if (zza == 1) {
                zzj("sizeAndRate.cover, " + i4 + "x" + i5 + "@" + d4);
                return false;
            }
        }
        if (!zzk(videoCapabilities, i4, i5, d4)) {
            if (i4 < i5 && ((!"OMX.MTK.VIDEO.DECODER.HEVC".equals(this.zza) || !"mcv5a".equals(zzfj.zzb)) && zzk(videoCapabilities, i5, i4, d4))) {
                zzer.zzb("MediaCodecInfo", "AssumedSupport [" + ("sizeAndRate.rotated, " + i4 + "x" + i5 + "@" + d4) + "] [" + this.zza + ", " + this.zzb + "] [" + zzfj.zze + "]");
            } else {
                zzj("sizeAndRate.support, " + i4 + "x" + i5 + "@" + d4);
                return false;
            }
        }
        return true;
    }

    public final MediaCodecInfo.CodecProfileLevel[] zzh() {
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzd;
        if (codecCapabilities == null || (codecProfileLevelArr = codecCapabilities.profileLevels) == null) {
            return new MediaCodecInfo.CodecProfileLevel[0];
        }
        return codecProfileLevelArr;
    }
}
