package com.google.android.gms.internal.ads;

import android.util.Pair;
import com.google.android.gms.nearby.connection.ConnectionsStatusCodes;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzafo {
    public byte[] zzM;
    public zzaca zzS;
    public boolean zzT;
    public zzabz zzV;
    public int zzW;
    private int zzX;
    public String zza;
    public String zzb;
    public int zzc;
    public int zzd;
    public int zze;
    public int zzf;
    public boolean zzg;
    public byte[] zzh;
    public zzaby zzi;
    public byte[] zzj;
    public zzad zzk;
    public int zzl = -1;
    public int zzm = -1;
    public int zzn = -1;
    public int zzo = -1;
    public int zzp = 0;
    public int zzq = -1;
    public float zzr = 0.0f;
    public float zzs = 0.0f;
    public float zzt = 0.0f;
    public byte[] zzu = null;
    public int zzv = -1;
    public boolean zzw = false;
    public int zzx = -1;
    public int zzy = -1;
    public int zzz = -1;
    public int zzA = 1000;
    public int zzB = 200;
    public float zzC = -1.0f;
    public float zzD = -1.0f;
    public float zzE = -1.0f;
    public float zzF = -1.0f;
    public float zzG = -1.0f;
    public float zzH = -1.0f;
    public float zzI = -1.0f;
    public float zzJ = -1.0f;
    public float zzK = -1.0f;
    public float zzL = -1.0f;
    public int zzN = 1;
    public int zzO = -1;
    public int zzP = ConnectionsStatusCodes.STATUS_NETWORK_NOT_CONNECTED;
    public long zzQ = 0;
    public long zzR = 0;
    public boolean zzU = true;
    private String zzY = "eng";

    private static Pair zzf(zzfa zzfaVar) throws zzcd {
        try {
            zzfaVar.zzG(16);
            long zzq = zzfaVar.zzq();
            if (zzq == 1482049860) {
                return new Pair("video/divx", null);
            }
            if (zzq == 859189832) {
                return new Pair("video/3gpp", null);
            }
            if (zzq == 826496599) {
                int zzc = zzfaVar.zzc() + 20;
                byte[] zzH = zzfaVar.zzH();
                while (true) {
                    int length = zzH.length;
                    if (zzc < length - 4) {
                        if (zzH[zzc] == 0 && zzH[zzc + 1] == 0 && zzH[zzc + 2] == 1 && zzH[zzc + 3] == 15) {
                            return new Pair("video/wvc1", Collections.singletonList(Arrays.copyOfRange(zzH, zzc, length)));
                        }
                        zzc++;
                    } else {
                        throw zzcd.zza("Failed to find FourCC VC1 initialization data", null);
                    }
                }
            } else {
                zzer.zzf("MatroskaExtractor", "Unknown FourCC. Setting mimeType to video/x-unknown");
                return new Pair("video/x-unknown", null);
            }
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw zzcd.zza("Error parsing FourCC private data", null);
        }
    }

    private static List zzg(byte[] bArr) throws zzcd {
        int i4;
        int i5;
        try {
            if (bArr[0] == 2) {
                int i6 = 1;
                int i7 = 0;
                while (true) {
                    i4 = bArr[i6] & 255;
                    if (i4 != 255) {
                        break;
                    }
                    i6++;
                    i7 += 255;
                }
                int i8 = i7 + i4;
                int i9 = i6 + 1;
                int i10 = 0;
                while (true) {
                    i5 = bArr[i9] & 255;
                    if (i5 != 255) {
                        break;
                    }
                    i9++;
                    i10 += 255;
                }
                int i11 = i9 + 1;
                int i12 = i10 + i5;
                if (bArr[i11] == 1) {
                    byte[] bArr2 = new byte[i8];
                    System.arraycopy(bArr, i11, bArr2, 0, i8);
                    int i13 = i11 + i8;
                    if (bArr[i13] == 3) {
                        int i14 = i13 + i12;
                        if (bArr[i14] == 5) {
                            int length = bArr.length - i14;
                            byte[] bArr3 = new byte[length];
                            System.arraycopy(bArr, i14, bArr3, 0, length);
                            ArrayList arrayList = new ArrayList(2);
                            arrayList.add(bArr2);
                            arrayList.add(bArr3);
                            return arrayList;
                        }
                        throw zzcd.zza("Error parsing vorbis codec private", null);
                    }
                    throw zzcd.zza("Error parsing vorbis codec private", null);
                }
                throw zzcd.zza("Error parsing vorbis codec private", null);
            }
            throw zzcd.zza("Error parsing vorbis codec private", null);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw zzcd.zza("Error parsing vorbis codec private", null);
        }
    }

    private static boolean zzh(zzfa zzfaVar) throws zzcd {
        UUID uuid;
        UUID uuid2;
        try {
            int zzi = zzfaVar.zzi();
            if (zzi == 1) {
                return true;
            }
            if (zzi == 65534) {
                zzfaVar.zzF(24);
                long zzr = zzfaVar.zzr();
                uuid = zzafp.zzf;
                if (zzr == uuid.getMostSignificantBits()) {
                    long zzr2 = zzfaVar.zzr();
                    uuid2 = zzafp.zzf;
                    if (zzr2 == uuid2.getLeastSignificantBits()) {
                        return true;
                    }
                }
            }
            return false;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw zzcd.zza("Error parsing MS/ACM codec private", null);
        }
    }

    @EnsuresNonNull({"codecPrivate"})
    private final byte[] zzi(String str) throws zzcd {
        byte[] bArr = this.zzj;
        if (bArr != null) {
            return bArr;
        }
        throw zzcd.zza("Missing CodecPrivate for codec ".concat(String.valueOf(str)), null);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @EnsuresNonNull({"this.output"})
    @RequiresNonNull({"codecId"})
    public final void zze(zzaaz zzaazVar, int i4) throws zzcd {
        char c4;
        List singletonList;
        zzfsc zzfscVar;
        String str;
        String str2;
        int i5;
        byte[] bArr;
        zzs zzsVar;
        Map map;
        Map map2;
        byte[] bArr2;
        int i6;
        Map map3;
        zzaas zza;
        String str3 = this.zzb;
        int i7 = 1;
        int i8 = 4;
        int i9 = 0;
        int i10 = -1;
        switch (str3.hashCode()) {
            case -2095576542:
                if (str3.equals("V_MPEG4/ISO/AP")) {
                    c4 = 6;
                    break;
                }
                c4 = 65535;
                break;
            case -2095575984:
                if (str3.equals("V_MPEG4/ISO/SP")) {
                    c4 = 4;
                    break;
                }
                c4 = 65535;
                break;
            case -1985379776:
                if (str3.equals("A_MS/ACM")) {
                    c4 = 23;
                    break;
                }
                c4 = 65535;
                break;
            case -1784763192:
                if (str3.equals("A_TRUEHD")) {
                    c4 = 18;
                    break;
                }
                c4 = 65535;
                break;
            case -1730367663:
                if (str3.equals("A_VORBIS")) {
                    c4 = 11;
                    break;
                }
                c4 = 65535;
                break;
            case -1482641358:
                if (str3.equals("A_MPEG/L2")) {
                    c4 = 14;
                    break;
                }
                c4 = 65535;
                break;
            case -1482641357:
                if (str3.equals("A_MPEG/L3")) {
                    c4 = 15;
                    break;
                }
                c4 = 65535;
                break;
            case -1373388978:
                if (str3.equals("V_MS/VFW/FOURCC")) {
                    c4 = '\t';
                    break;
                }
                c4 = 65535;
                break;
            case -933872740:
                if (str3.equals("S_DVBSUB")) {
                    c4 = ' ';
                    break;
                }
                c4 = 65535;
                break;
            case -538363189:
                if (str3.equals("V_MPEG4/ISO/ASP")) {
                    c4 = 5;
                    break;
                }
                c4 = 65535;
                break;
            case -538363109:
                if (str3.equals("V_MPEG4/ISO/AVC")) {
                    c4 = 7;
                    break;
                }
                c4 = 65535;
                break;
            case -425012669:
                if (str3.equals("S_VOBSUB")) {
                    c4 = 30;
                    break;
                }
                c4 = 65535;
                break;
            case -356037306:
                if (str3.equals("A_DTS/LOSSLESS")) {
                    c4 = 21;
                    break;
                }
                c4 = 65535;
                break;
            case 62923557:
                if (str3.equals("A_AAC")) {
                    c4 = '\r';
                    break;
                }
                c4 = 65535;
                break;
            case 62923603:
                if (str3.equals("A_AC3")) {
                    c4 = 16;
                    break;
                }
                c4 = 65535;
                break;
            case 62927045:
                if (str3.equals("A_DTS")) {
                    c4 = 19;
                    break;
                }
                c4 = 65535;
                break;
            case 82318131:
                if (str3.equals("V_AV1")) {
                    c4 = 2;
                    break;
                }
                c4 = 65535;
                break;
            case 82338133:
                if (str3.equals("V_VP8")) {
                    c4 = 0;
                    break;
                }
                c4 = 65535;
                break;
            case 82338134:
                if (str3.equals("V_VP9")) {
                    c4 = 1;
                    break;
                }
                c4 = 65535;
                break;
            case 99146302:
                if (str3.equals("S_HDMV/PGS")) {
                    c4 = 31;
                    break;
                }
                c4 = 65535;
                break;
            case 444813526:
                if (str3.equals("V_THEORA")) {
                    c4 = '\n';
                    break;
                }
                c4 = 65535;
                break;
            case 542569478:
                if (str3.equals("A_DTS/EXPRESS")) {
                    c4 = 20;
                    break;
                }
                c4 = 65535;
                break;
            case 635596514:
                if (str3.equals("A_PCM/FLOAT/IEEE")) {
                    c4 = 26;
                    break;
                }
                c4 = 65535;
                break;
            case 725948237:
                if (str3.equals("A_PCM/INT/BIG")) {
                    c4 = 25;
                    break;
                }
                c4 = 65535;
                break;
            case 725957860:
                if (str3.equals("A_PCM/INT/LIT")) {
                    c4 = 24;
                    break;
                }
                c4 = 65535;
                break;
            case 738597099:
                if (str3.equals("S_TEXT/ASS")) {
                    c4 = 28;
                    break;
                }
                c4 = 65535;
                break;
            case 855502857:
                if (str3.equals("V_MPEGH/ISO/HEVC")) {
                    c4 = '\b';
                    break;
                }
                c4 = 65535;
                break;
            case 1045209816:
                if (str3.equals("S_TEXT/WEBVTT")) {
                    c4 = 29;
                    break;
                }
                c4 = 65535;
                break;
            case 1422270023:
                if (str3.equals("S_TEXT/UTF8")) {
                    c4 = 27;
                    break;
                }
                c4 = 65535;
                break;
            case 1809237540:
                if (str3.equals("V_MPEG2")) {
                    c4 = 3;
                    break;
                }
                c4 = 65535;
                break;
            case 1950749482:
                if (str3.equals("A_EAC3")) {
                    c4 = 17;
                    break;
                }
                c4 = 65535;
                break;
            case 1950789798:
                if (str3.equals("A_FLAC")) {
                    c4 = 22;
                    break;
                }
                c4 = 65535;
                break;
            case 1951062397:
                if (str3.equals("A_OPUS")) {
                    c4 = '\f';
                    break;
                }
                c4 = 65535;
                break;
            default:
                c4 = 65535;
                break;
        }
        String str4 = "audio/raw";
        switch (c4) {
            case 0:
                str4 = "video/x-vnd.on2.vp8";
                i5 = -1;
                zzfscVar = null;
                str2 = null;
                i8 = -1;
                break;
            case 1:
                str4 = "video/x-vnd.on2.vp9";
                i5 = -1;
                zzfscVar = null;
                str2 = null;
                i8 = -1;
                break;
            case 2:
                str4 = "video/av01";
                i5 = -1;
                zzfscVar = null;
                str2 = null;
                i8 = -1;
                break;
            case 3:
                str4 = "video/mpeg2";
                i5 = -1;
                zzfscVar = null;
                str2 = null;
                i8 = -1;
                break;
            case 4:
            case 5:
            case 6:
                byte[] bArr3 = this.zzj;
                singletonList = bArr3 == null ? null : Collections.singletonList(bArr3);
                str4 = "video/mp4v-es";
                zzfscVar = singletonList;
                i5 = -1;
                str2 = null;
                i8 = -1;
                break;
            case 7:
                zzaab zza2 = zzaab.zza(new zzfa(zzi(this.zzb)));
                zzfscVar = zza2.zza;
                this.zzW = zza2.zzb;
                str = zza2.zzi;
                str4 = "video/avc";
                str2 = str;
                i5 = -1;
                i8 = -1;
                break;
            case '\b':
                zzabm zza3 = zzabm.zza(new zzfa(zzi(this.zzb)));
                zzfscVar = zza3.zza;
                this.zzW = zza3.zzb;
                str = zza3.zzg;
                str4 = "video/hevc";
                str2 = str;
                i5 = -1;
                i8 = -1;
                break;
            case '\t':
                Pair zzf = zzf(new zzfa(zzi(this.zzb)));
                str4 = (String) zzf.first;
                singletonList = (List) zzf.second;
                zzfscVar = singletonList;
                i5 = -1;
                str2 = null;
                i8 = -1;
                break;
            case '\n':
                str4 = "video/x-unknown";
                i5 = -1;
                zzfscVar = null;
                str2 = null;
                i8 = -1;
                break;
            case 11:
                str4 = "audio/vorbis";
                zzfscVar = zzg(zzi(str3));
                i5 = 8192;
                str2 = null;
                i8 = -1;
                break;
            case '\f':
                ArrayList arrayList = new ArrayList(3);
                arrayList.add(zzi(this.zzb));
                ByteBuffer allocate = ByteBuffer.allocate(8);
                ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                arrayList.add(allocate.order(byteOrder).putLong(this.zzQ).array());
                arrayList.add(ByteBuffer.allocate(8).order(byteOrder).putLong(this.zzR).array());
                str4 = "audio/opus";
                zzfscVar = arrayList;
                i5 = 5760;
                str2 = null;
                i8 = -1;
                break;
            case '\r':
                List singletonList2 = Collections.singletonList(zzi(str3));
                zzzt zza4 = zzzu.zza(this.zzj);
                this.zzP = zza4.zza;
                this.zzN = zza4.zzb;
                str4 = "audio/mp4a-latm";
                str2 = zza4.zzc;
                i8 = -1;
                zzfscVar = singletonList2;
                i5 = -1;
                break;
            case 14:
                str4 = "audio/mpeg-L2";
                i5 = 4096;
                zzfscVar = null;
                str2 = null;
                i8 = -1;
                break;
            case 15:
                str4 = "audio/mpeg";
                i5 = 4096;
                zzfscVar = null;
                str2 = null;
                i8 = -1;
                break;
            case 16:
                str4 = "audio/ac3";
                i5 = -1;
                zzfscVar = null;
                str2 = null;
                i8 = -1;
                break;
            case 17:
                str4 = "audio/eac3";
                i5 = -1;
                zzfscVar = null;
                str2 = null;
                i8 = -1;
                break;
            case 18:
                this.zzS = new zzaca();
                str4 = "audio/true-hd";
                i5 = -1;
                zzfscVar = null;
                str2 = null;
                i8 = -1;
                break;
            case 19:
            case 20:
                str4 = "audio/vnd.dts";
                i5 = -1;
                zzfscVar = null;
                str2 = null;
                i8 = -1;
                break;
            case 21:
                str4 = "audio/vnd.dts.hd";
                i5 = -1;
                zzfscVar = null;
                str2 = null;
                i8 = -1;
                break;
            case 22:
                singletonList = Collections.singletonList(zzi(str3));
                str4 = "audio/flac";
                zzfscVar = singletonList;
                i5 = -1;
                str2 = null;
                i8 = -1;
                break;
            case 23:
                if (zzh(new zzfa(zzi(this.zzb)))) {
                    i8 = zzfj.zzj(this.zzO);
                    if (i8 == 0) {
                        int i11 = this.zzO;
                        zzer.zzf("MatroskaExtractor", "Unsupported PCM bit depth: " + i11 + ". Setting mimeType to audio/x-unknown");
                    }
                    i5 = -1;
                    zzfscVar = null;
                    str2 = null;
                    break;
                } else {
                    zzer.zzf("MatroskaExtractor", "Non-PCM MS/ACM is unsupported. Setting mimeType to audio/x-unknown");
                }
                str4 = "audio/x-unknown";
                i5 = -1;
                zzfscVar = null;
                str2 = null;
                i8 = -1;
                break;
            case 24:
                i8 = zzfj.zzj(this.zzO);
                if (i8 == 0) {
                    int i12 = this.zzO;
                    zzer.zzf("MatroskaExtractor", "Unsupported little endian PCM bit depth: " + i12 + ". Setting mimeType to audio/x-unknown");
                    str4 = "audio/x-unknown";
                    i5 = -1;
                    zzfscVar = null;
                    str2 = null;
                    i8 = -1;
                    break;
                }
                i5 = -1;
                zzfscVar = null;
                str2 = null;
                break;
            case 25:
                int i13 = this.zzO;
                if (i13 != 8) {
                    if (i13 != 16) {
                        zzer.zzf("MatroskaExtractor", "Unsupported big endian PCM bit depth: " + i13 + ". Setting mimeType to audio/x-unknown");
                        str4 = "audio/x-unknown";
                        i5 = -1;
                        zzfscVar = null;
                        str2 = null;
                        i8 = -1;
                        break;
                    } else {
                        i8 = 268435456;
                        i5 = -1;
                        zzfscVar = null;
                        str2 = null;
                        break;
                    }
                } else {
                    i5 = -1;
                    zzfscVar = null;
                    str2 = null;
                    i8 = 3;
                    break;
                }
            case 26:
                int i14 = this.zzO;
                if (i14 != 32) {
                    zzer.zzf("MatroskaExtractor", "Unsupported floating point PCM bit depth: " + i14 + ". Setting mimeType to audio/x-unknown");
                    str4 = "audio/x-unknown";
                    i5 = -1;
                    zzfscVar = null;
                    str2 = null;
                    i8 = -1;
                    break;
                }
                i5 = -1;
                zzfscVar = null;
                str2 = null;
                break;
            case 27:
                str4 = "application/x-subrip";
                i5 = -1;
                zzfscVar = null;
                str2 = null;
                i8 = -1;
                break;
            case 28:
                bArr = zzafp.zzc;
                zzfscVar = zzfsc.zzn(bArr, zzi(this.zzb));
                str4 = "text/x-ssa";
                i5 = -1;
                str2 = null;
                i8 = -1;
                break;
            case 29:
                str4 = "text/vtt";
                i5 = -1;
                zzfscVar = null;
                str2 = null;
                i8 = -1;
                break;
            case 30:
                singletonList = zzfsc.zzm(zzi(str3));
                str4 = "application/vobsub";
                zzfscVar = singletonList;
                i5 = -1;
                str2 = null;
                i8 = -1;
                break;
            case 31:
                str4 = "application/pgs";
                i5 = -1;
                zzfscVar = null;
                str2 = null;
                i8 = -1;
                break;
            case ' ':
                byte[] bArr4 = new byte[4];
                System.arraycopy(zzi(str3), 0, bArr4, 0, 4);
                singletonList = zzfsc.zzm(bArr4);
                str4 = "application/dvbsubs";
                zzfscVar = singletonList;
                i5 = -1;
                str2 = null;
                i8 = -1;
                break;
            default:
                throw zzcd.zza("Unrecognized codec identifier.", null);
        }
        if (this.zzM != null && (zza = zzaas.zza(new zzfa(this.zzM))) != null) {
            str2 = zza.zza;
            str4 = "video/dolby-vision";
        }
        String str5 = str4;
        int i15 = (this.zzU ? 1 : 0) | (true != this.zzT ? 0 : 2);
        zzak zzakVar = new zzak();
        if (zzcc.zzf(str5)) {
            zzakVar.zzw(this.zzN);
            zzakVar.zzT(this.zzP);
            zzakVar.zzN(i8);
        } else if (zzcc.zzg(str5)) {
            if (this.zzp == 0) {
                int i16 = this.zzn;
                if (i16 == -1) {
                    i16 = this.zzl;
                }
                this.zzn = i16;
                int i17 = this.zzo;
                if (i17 == -1) {
                    i17 = this.zzm;
                }
                this.zzo = i17;
            }
            int i18 = this.zzn;
            float f4 = (i18 == -1 || (i6 = this.zzo) == -1) ? -1.0f : (this.zzm * i18) / (this.zzl * i6);
            if (this.zzw) {
                if (this.zzC == -1.0f || this.zzD == -1.0f || this.zzE == -1.0f || this.zzF == -1.0f || this.zzG == -1.0f || this.zzH == -1.0f || this.zzI == -1.0f || this.zzJ == -1.0f || this.zzK == -1.0f || this.zzL == -1.0f) {
                    bArr2 = null;
                } else {
                    bArr2 = new byte[25];
                    ByteBuffer order = ByteBuffer.wrap(bArr2).order(ByteOrder.LITTLE_ENDIAN);
                    order.put((byte) 0);
                    order.putShort((short) ((this.zzC * 50000.0f) + 0.5f));
                    order.putShort((short) ((this.zzD * 50000.0f) + 0.5f));
                    order.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                    order.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                    order.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                    order.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                    order.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                    order.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                    order.putShort((short) (this.zzK + 0.5f));
                    order.putShort((short) (this.zzL + 0.5f));
                    order.putShort((short) this.zzA);
                    order.putShort((short) this.zzB);
                }
                zzsVar = new zzs(this.zzx, this.zzz, this.zzy, bArr2);
            } else {
                zzsVar = null;
            }
            if (this.zza != null) {
                map = zzafp.zzg;
                if (map.containsKey(this.zza)) {
                    map2 = zzafp.zzg;
                    i10 = ((Integer) map2.get(this.zza)).intValue();
                }
            }
            if (this.zzq == 0 && Float.compare(this.zzr, 0.0f) == 0 && Float.compare(this.zzs, 0.0f) == 0) {
                if (Float.compare(this.zzt, 0.0f) != 0) {
                    if (Float.compare(this.zzs, 90.0f) == 0) {
                        i9 = 90;
                    } else if (Float.compare(this.zzs, -180.0f) == 0 || Float.compare(this.zzs, 180.0f) == 0) {
                        i9 = 180;
                    } else if (Float.compare(this.zzs, -90.0f) == 0) {
                        i9 = 270;
                    }
                }
                zzakVar.zzX(this.zzl);
                zzakVar.zzF(this.zzm);
                zzakVar.zzP(f4);
                zzakVar.zzR(i9);
                zzakVar.zzQ(this.zzu);
                zzakVar.zzV(this.zzv);
                zzakVar.zzy(zzsVar);
                i7 = 2;
            }
            i9 = i10;
            zzakVar.zzX(this.zzl);
            zzakVar.zzF(this.zzm);
            zzakVar.zzP(f4);
            zzakVar.zzR(i9);
            zzakVar.zzQ(this.zzu);
            zzakVar.zzV(this.zzv);
            zzakVar.zzy(zzsVar);
            i7 = 2;
        } else if (!"application/x-subrip".equals(str5) && !"text/x-ssa".equals(str5) && !"text/vtt".equals(str5) && !"application/vobsub".equals(str5) && !"application/pgs".equals(str5) && !"application/dvbsubs".equals(str5)) {
            throw zzcd.zza("Unexpected MIME type.", null);
        } else {
            i7 = 3;
        }
        if (this.zza != null) {
            map3 = zzafp.zzg;
            if (!map3.containsKey(this.zza)) {
                zzakVar.zzJ(this.zza);
            }
        }
        zzakVar.zzG(i4);
        zzakVar.zzS(str5);
        zzakVar.zzL(i5);
        zzakVar.zzK(this.zzY);
        zzakVar.zzU(i15);
        zzakVar.zzI(zzfscVar);
        zzakVar.zzx(str2);
        zzakVar.zzB(this.zzk);
        zzam zzY = zzakVar.zzY();
        zzabz zzv = zzaazVar.zzv(this.zzc, i7);
        this.zzV = zzv;
        zzv.zzk(zzY);
    }
}
