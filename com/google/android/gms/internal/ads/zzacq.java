package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzacq implements zzaci {
    public final zzfsc zza;
    private final int zzb;

    private zzacq(int i4, zzfsc zzfscVar) {
        this.zzb = i4;
        this.zza = zzfscVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static zzacq zzc(int i4, zzfa zzfaVar) {
        String str;
        zzaci zzacrVar;
        String str2;
        zzfrz zzfrzVar = new zzfrz();
        int zzd = zzfaVar.zzd();
        int i5 = -2;
        while (zzfaVar.zza() > 8) {
            int zzg = zzfaVar.zzg();
            int zzc = zzfaVar.zzc() + zzfaVar.zzg();
            zzfaVar.zzE(zzc);
            if (zzg == 1414744396) {
                zzacrVar = zzc(zzfaVar.zzg(), zzfaVar);
            } else {
                zzacr zzacrVar2 = null;
                switch (zzg) {
                    case 1718776947:
                        if (i5 == 2) {
                            zzfaVar.zzG(4);
                            int zzg2 = zzfaVar.zzg();
                            int zzg3 = zzfaVar.zzg();
                            zzfaVar.zzG(4);
                            int zzg4 = zzfaVar.zzg();
                            switch (zzg4) {
                                case 808802372:
                                case 877677894:
                                case 1145656883:
                                case 1145656920:
                                case 1482049860:
                                case 1684633208:
                                case 2021026148:
                                    str2 = "video/mp4v-es";
                                    break;
                                case 826496577:
                                case 828601953:
                                case 875967048:
                                    str2 = "video/avc";
                                    break;
                                case 842289229:
                                    str2 = "video/mp42";
                                    break;
                                case 859066445:
                                    str2 = "video/mp43";
                                    break;
                                case 1196444237:
                                case 1735420525:
                                    str2 = "video/mjpeg";
                                    break;
                                default:
                                    str2 = null;
                                    break;
                            }
                            if (str2 == null) {
                                zzer.zzf("StreamFormatChunk", "Ignoring track with unsupported compression " + zzg4);
                            } else {
                                zzak zzakVar = new zzak();
                                zzakVar.zzX(zzg2);
                                zzakVar.zzF(zzg3);
                                zzakVar.zzS(str2);
                                zzacrVar2 = new zzacr(zzakVar.zzY());
                            }
                        } else if (i5 == 1) {
                            int zzi = zzfaVar.zzi();
                            if (zzi == 1) {
                                str = "audio/raw";
                            } else if (zzi != 85) {
                                if (zzi == 255) {
                                    str = "audio/mp4a-latm";
                                } else if (zzi != 8192) {
                                    if (zzi != 8193) {
                                        str = null;
                                    } else {
                                        str = "audio/vnd.dts";
                                    }
                                } else {
                                    str = "audio/ac3";
                                }
                            } else {
                                str = "audio/mpeg";
                            }
                            if (str == null) {
                                zzer.zzf("StreamFormatChunk", "Ignoring track with unsupported format tag " + zzi);
                            } else {
                                int zzi2 = zzfaVar.zzi();
                                int zzg5 = zzfaVar.zzg();
                                zzfaVar.zzG(6);
                                int zzj = zzfj.zzj(zzfaVar.zzo());
                                int zzi3 = zzfaVar.zzi();
                                byte[] bArr = new byte[zzi3];
                                zzfaVar.zzB(bArr, 0, zzi3);
                                zzak zzakVar2 = new zzak();
                                zzakVar2.zzS(str);
                                zzakVar2.zzw(zzi2);
                                zzakVar2.zzT(zzg5);
                                if ("audio/raw".equals(str) && zzj != 0) {
                                    zzakVar2.zzN(zzj);
                                }
                                if ("audio/mp4a-latm".equals(str) && zzi3 > 0) {
                                    zzakVar2.zzI(zzfsc.zzm(bArr));
                                }
                                zzacrVar = new zzacr(zzakVar2.zzY());
                                break;
                            }
                        } else {
                            zzer.zzf("StreamFormatChunk", "Ignoring strf box for unsupported track type: ".concat(zzfj.zzy(i5)));
                        }
                        zzacrVar = zzacrVar2;
                        break;
                    case 1751742049:
                        zzacrVar = zzacn.zzb(zzfaVar);
                        break;
                    case 1752331379:
                        zzacrVar = zzaco.zzb(zzfaVar);
                        break;
                    case 1852994675:
                        zzacrVar = zzacs.zzb(zzfaVar);
                        break;
                    default:
                        zzacrVar = zzacrVar2;
                        break;
                }
            }
            if (zzacrVar != null) {
                if (zzacrVar.zza() == 1752331379) {
                    int i6 = ((zzaco) zzacrVar).zza;
                    if (i6 != 1935960438) {
                        if (i6 != 1935963489) {
                            if (i6 != 1937012852) {
                                zzer.zzf("AviStreamHeaderChunk", "Found unsupported streamType fourCC: ".concat(String.valueOf(Integer.toHexString(i6))));
                                i5 = -1;
                            } else {
                                i5 = 3;
                            }
                        } else {
                            i5 = 1;
                        }
                    } else {
                        i5 = 2;
                    }
                }
                zzfrzVar.zzf(zzacrVar);
            }
            zzfaVar.zzF(zzc);
            zzfaVar.zzE(zzd);
        }
        return new zzacq(i4, zzfrzVar.zzi());
    }

    @Override // com.google.android.gms.internal.ads.zzaci
    public final int zza() {
        return this.zzb;
    }

    @Nullable
    public final zzaci zzb(Class cls) {
        zzfsc zzfscVar = this.zza;
        int size = zzfscVar.size();
        int i4 = 0;
        while (i4 < size) {
            zzaci zzaciVar = (zzaci) zzfscVar.get(i4);
            i4++;
            if (zzaciVar.getClass() == cls) {
                return zzaciVar;
            }
        }
        return null;
    }
}
