package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.common.net.HttpHeaders;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.miguelbcr.ui.rx_paparazzo2.interactors.ImageUtils;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzagu {
    @VisibleForTesting
    static final String[] zza = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", HttpHeaders.TRAILER, "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Afro-Punk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop", "Abstract", "Art Rock", "Baroque", "Bhangra", "Big beat", "Breakbeat", "Chillout", "Downtempo", "Dub", "EBM", "Eclectic", "Electro", "Electroclash", "Emo", "Experimental", "Garage", "Global", "IDM", "Illbient", "Industro-Goth", "Jam Band", "Krautrock", "Leftfield", "Lounge", "Math Rock", "New Romantic", "Nu-Breakz", "Post-Punk", "Post-Rock", "Psytrance", "Shoegaze", "Space Rock", "Trop Rock", "World Music", "Neoclassical", "Audiobook", "Audio theatre", "Neue Deutsche Welle", "Podcast", "Indie-Rock", "G-Funk", "Dubstep", "Garage Rock", "Psybient"};
    public static final /* synthetic */ int zzb = 0;

    @Nullable
    public static zzby zza(zzfa zzfaVar) {
        String str;
        String str2;
        int zzc = zzfaVar.zzc() + zzfaVar.zze();
        int zze = zzfaVar.zze();
        int i4 = (zze >> 24) & 255;
        zzby zzbyVar = null;
        try {
            if (i4 != 169 && i4 != 253) {
                if (zze == 1735291493) {
                    int zzb2 = zzb(zzfaVar);
                    if (zzb2 > 0 && zzb2 <= 192) {
                        str2 = zza[zzb2 - 1];
                    } else {
                        str2 = null;
                    }
                    if (str2 != null) {
                        zzbyVar = new zzaev("TCON", null, zzfsc.zzm(str2));
                    } else {
                        zzer.zzf("MetadataUtil", "Failed to parse standard genre code");
                    }
                    return zzbyVar;
                } else if (zze == 1684632427) {
                    return zzd(1684632427, "TPOS", zzfaVar);
                } else {
                    if (zze == 1953655662) {
                        return zzd(1953655662, "TRCK", zzfaVar);
                    }
                    if (zze == 1953329263) {
                        return zzc(1953329263, "TBPM", zzfaVar, true, false);
                    }
                    if (zze == 1668311404) {
                        return zzc(1668311404, "TCMP", zzfaVar, true, true);
                    }
                    if (zze == 1668249202) {
                        int zze2 = zzfaVar.zze();
                        if (zzfaVar.zze() == 1684108385) {
                            int zze3 = zzfaVar.zze() & 16777215;
                            if (zze3 == 13) {
                                str = ImageUtils.MIME_TYPE_JPEG;
                            } else if (zze3 == 14) {
                                str = "image/png";
                                zze3 = 14;
                            } else {
                                str = null;
                            }
                            if (str == null) {
                                zzer.zzf("MetadataUtil", "Unrecognized cover art flags: " + zze3);
                            } else {
                                zzfaVar.zzG(4);
                                int i5 = zze2 - 16;
                                byte[] bArr = new byte[i5];
                                zzfaVar.zzB(bArr, 0, i5);
                                zzbyVar = new zzady(str, null, 3, bArr);
                            }
                        } else {
                            zzer.zzf("MetadataUtil", "Failed to parse cover art attribute");
                        }
                        return zzbyVar;
                    } else if (zze == 1631670868) {
                        return zze(1631670868, "TPE2", zzfaVar);
                    } else {
                        if (zze == 1936682605) {
                            return zze(1936682605, "TSOT", zzfaVar);
                        }
                        if (zze == 1936679276) {
                            return zze(1936679276, "TSO2", zzfaVar);
                        }
                        if (zze == 1936679282) {
                            return zze(1936679282, "TSOA", zzfaVar);
                        }
                        if (zze == 1936679265) {
                            return zze(1936679265, "TSOP", zzfaVar);
                        }
                        if (zze == 1936679791) {
                            return zze(1936679791, "TSOC", zzfaVar);
                        }
                        if (zze == 1920233063) {
                            return zzc(1920233063, "ITUNESADVISORY", zzfaVar, false, false);
                        }
                        if (zze == 1885823344) {
                            return zzc(1885823344, "ITUNESGAPLESS", zzfaVar, false, true);
                        }
                        if (zze == 1936683886) {
                            return zze(1936683886, "TVSHOWSORT", zzfaVar);
                        }
                        if (zze == 1953919848) {
                            return zze(1953919848, "TVSHOW", zzfaVar);
                        }
                        if (zze == 757935405) {
                            String str3 = null;
                            String str4 = null;
                            int i6 = -1;
                            int i7 = -1;
                            while (zzfaVar.zzc() < zzc) {
                                int zzc2 = zzfaVar.zzc();
                                int zze4 = zzfaVar.zze();
                                int zze5 = zzfaVar.zze();
                                zzfaVar.zzG(4);
                                if (zze5 == 1835360622) {
                                    str3 = zzfaVar.zzw(zze4 - 12);
                                } else if (zze5 == 1851878757) {
                                    str4 = zzfaVar.zzw(zze4 - 12);
                                } else {
                                    if (zze5 == 1684108385) {
                                        i7 = zze4;
                                    }
                                    if (zze5 == 1684108385) {
                                        i6 = zzc2;
                                    }
                                    zzfaVar.zzG(zze4 - 12);
                                }
                            }
                            if (str3 != null && str4 != null && i6 != -1) {
                                zzfaVar.zzF(i6);
                                zzfaVar.zzG(16);
                                zzbyVar = new zzaep(str3, str4, zzfaVar.zzw(i7 - 16));
                            }
                            return zzbyVar;
                        }
                    }
                }
            } else {
                int i8 = zze & 16777215;
                if (i8 == 6516084) {
                    int zze6 = zzfaVar.zze();
                    if (zzfaVar.zze() == 1684108385) {
                        zzfaVar.zzG(8);
                        String zzw = zzfaVar.zzw(zze6 - 16);
                        zzbyVar = new zzaeg("und", zzw, zzw);
                    } else {
                        zzer.zzf("MetadataUtil", "Failed to parse comment attribute: ".concat(zzage.zzf(zze)));
                    }
                    return zzbyVar;
                } else if (i8 != 7233901 && i8 != 7631467) {
                    if (i8 != 6516589 && i8 != 7828084) {
                        if (i8 == 6578553) {
                            return zze(zze, "TDRC", zzfaVar);
                        }
                        if (i8 == 4280916) {
                            return zze(zze, "TPE1", zzfaVar);
                        }
                        if (i8 == 7630703) {
                            return zze(zze, "TSSE", zzfaVar);
                        }
                        if (i8 == 6384738) {
                            return zze(zze, "TALB", zzfaVar);
                        }
                        if (i8 == 7108978) {
                            return zze(zze, "USLT", zzfaVar);
                        }
                        if (i8 == 6776174) {
                            return zze(zze, "TCON", zzfaVar);
                        }
                        if (i8 == 6779504) {
                            return zze(zze, "TIT1", zzfaVar);
                        }
                    } else {
                        return zze(zze, "TCOM", zzfaVar);
                    }
                } else {
                    return zze(zze, "TIT2", zzfaVar);
                }
            }
            zzer.zzb("MetadataUtil", "Skipped unknown metadata entry: " + zzage.zzf(zze));
            return null;
        } finally {
            zzfaVar.zzF(zzc);
        }
    }

    private static int zzb(zzfa zzfaVar) {
        zzfaVar.zzG(4);
        if (zzfaVar.zze() == 1684108385) {
            zzfaVar.zzG(8);
            return zzfaVar.zzk();
        }
        zzer.zzf("MetadataUtil", "Failed to parse uint8 attribute value");
        return -1;
    }

    @Nullable
    private static zzaen zzc(int i4, String str, zzfa zzfaVar, boolean z3, boolean z4) {
        int zzb2 = zzb(zzfaVar);
        if (z4) {
            zzb2 = Math.min(1, zzb2);
        }
        if (zzb2 >= 0) {
            if (z3) {
                return new zzaev(str, null, zzfsc.zzm(Integer.toString(zzb2)));
            }
            return new zzaeg("und", str, Integer.toString(zzb2));
        }
        zzer.zzf("MetadataUtil", "Failed to parse uint8 attribute: ".concat(zzage.zzf(i4)));
        return null;
    }

    @Nullable
    private static zzaev zzd(int i4, String str, zzfa zzfaVar) {
        int zze = zzfaVar.zze();
        if (zzfaVar.zze() == 1684108385 && zze >= 22) {
            zzfaVar.zzG(10);
            int zzo = zzfaVar.zzo();
            if (zzo > 0) {
                StringBuilder sb = new StringBuilder();
                sb.append(zzo);
                String sb2 = sb.toString();
                int zzo2 = zzfaVar.zzo();
                if (zzo2 > 0) {
                    sb2 = sb2 + RemoteSettings.FORWARD_SLASH_STRING + zzo2;
                }
                return new zzaev(str, null, zzfsc.zzm(sb2));
            }
        }
        zzer.zzf("MetadataUtil", "Failed to parse index/count attribute: ".concat(zzage.zzf(i4)));
        return null;
    }

    @Nullable
    private static zzaev zze(int i4, String str, zzfa zzfaVar) {
        int zze = zzfaVar.zze();
        if (zzfaVar.zze() == 1684108385) {
            zzfaVar.zzG(8);
            return new zzaev(str, null, zzfsc.zzm(zzfaVar.zzw(zze - 16)));
        }
        zzer.zzf("MetadataUtil", "Failed to parse text attribute: ".concat(zzage.zzf(i4)));
        return null;
    }
}
