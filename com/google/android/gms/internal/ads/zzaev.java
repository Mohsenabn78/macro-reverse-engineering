package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzaev extends zzaen {
    public static final Parcelable.Creator<zzaev> CREATOR = new zzaeu();
    @Nullable
    public final String zza;
    @Deprecated
    public final String zzb;
    public final zzfsc zzc;

    public zzaev(String str, @Nullable String str2, List list) {
        super(str);
        zzdy.zzd(!list.isEmpty());
        this.zza = str2;
        zzfsc zzj = zzfsc.zzj(list);
        this.zzc = zzj;
        this.zzb = (String) zzj.get(0);
    }

    private static List zzb(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            if (str.length() >= 10) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(5, 7))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(8, 10))));
            } else if (str.length() >= 7) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(5, 7))));
            } else if (str.length() >= 4) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
            }
            return arrayList;
        } catch (NumberFormatException unused) {
            return new ArrayList();
        }
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzaev.class == obj.getClass()) {
            zzaev zzaevVar = (zzaev) obj;
            if (zzfj.zzC(this.zzf, zzaevVar.zzf) && zzfj.zzC(this.zza, zzaevVar.zza) && this.zzc.equals(zzaevVar.zzc)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i4;
        int hashCode = this.zzf.hashCode() + 527;
        String str = this.zza;
        if (str != null) {
            i4 = str.hashCode();
        } else {
            i4 = 0;
        }
        return (((hashCode * 31) + i4) * 31) + this.zzc.hashCode();
    }

    @Override // com.google.android.gms.internal.ads.zzaen
    public final String toString() {
        String str = this.zzf;
        String str2 = this.zza;
        String valueOf = String.valueOf(this.zzc);
        return str + ": description=" + str2 + ": values=" + valueOf;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.zzf);
        parcel.writeString(this.zza);
        parcel.writeStringArray((String[]) this.zzc.toArray(new String[0]));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.gms.internal.ads.zzaen, com.google.android.gms.internal.ads.zzby
    public final void zza(zzbt zzbtVar) {
        char c4;
        Integer num;
        String str = this.zzf;
        switch (str.hashCode()) {
            case 82815:
                if (str.equals("TAL")) {
                    c4 = 6;
                    break;
                }
                c4 = 65535;
                break;
            case 82878:
                if (str.equals("TCM")) {
                    c4 = 16;
                    break;
                }
                c4 = 65535;
                break;
            case 82897:
                if (str.equals("TDA")) {
                    c4 = '\f';
                    break;
                }
                c4 = 65535;
                break;
            case 83253:
                if (str.equals("TP1")) {
                    c4 = 2;
                    break;
                }
                c4 = 65535;
                break;
            case 83254:
                if (str.equals("TP2")) {
                    c4 = 4;
                    break;
                }
                c4 = 65535;
                break;
            case 83255:
                if (str.equals("TP3")) {
                    c4 = 18;
                    break;
                }
                c4 = 65535;
                break;
            case 83341:
                if (str.equals("TRK")) {
                    c4 = '\b';
                    break;
                }
                c4 = 65535;
                break;
            case 83378:
                if (str.equals("TT2")) {
                    c4 = 0;
                    break;
                }
                c4 = 65535;
                break;
            case 83536:
                if (str.equals("TXT")) {
                    c4 = 20;
                    break;
                }
                c4 = 65535;
                break;
            case 83552:
                if (str.equals("TYE")) {
                    c4 = '\n';
                    break;
                }
                c4 = 65535;
                break;
            case 2567331:
                if (str.equals("TALB")) {
                    c4 = 7;
                    break;
                }
                c4 = 65535;
                break;
            case 2569357:
                if (str.equals("TCOM")) {
                    c4 = 17;
                    break;
                }
                c4 = 65535;
                break;
            case 2569891:
                if (str.equals("TDAT")) {
                    c4 = '\r';
                    break;
                }
                c4 = 65535;
                break;
            case 2570401:
                if (str.equals("TDRC")) {
                    c4 = 14;
                    break;
                }
                c4 = 65535;
                break;
            case 2570410:
                if (str.equals("TDRL")) {
                    c4 = 15;
                    break;
                }
                c4 = 65535;
                break;
            case 2571565:
                if (str.equals("TEXT")) {
                    c4 = 21;
                    break;
                }
                c4 = 65535;
                break;
            case 2575251:
                if (str.equals("TIT2")) {
                    c4 = 1;
                    break;
                }
                c4 = 65535;
                break;
            case 2581512:
                if (str.equals("TPE1")) {
                    c4 = 3;
                    break;
                }
                c4 = 65535;
                break;
            case 2581513:
                if (str.equals("TPE2")) {
                    c4 = 5;
                    break;
                }
                c4 = 65535;
                break;
            case 2581514:
                if (str.equals("TPE3")) {
                    c4 = 19;
                    break;
                }
                c4 = 65535;
                break;
            case 2583398:
                if (str.equals("TRCK")) {
                    c4 = '\t';
                    break;
                }
                c4 = 65535;
                break;
            case 2590194:
                if (str.equals("TYER")) {
                    c4 = 11;
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
                zzbtVar.zzq((CharSequence) this.zzc.get(0));
                return;
            case 2:
            case 3:
                zzbtVar.zze((CharSequence) this.zzc.get(0));
                return;
            case 4:
            case 5:
                zzbtVar.zzc((CharSequence) this.zzc.get(0));
                return;
            case 6:
            case 7:
                zzbtVar.zzd((CharSequence) this.zzc.get(0));
                return;
            case '\b':
            case '\t':
                int i4 = zzfj.zza;
                String[] split = ((String) this.zzc.get(0)).split(RemoteSettings.FORWARD_SLASH_STRING, -1);
                try {
                    int parseInt = Integer.parseInt(split[0]);
                    if (split.length > 1) {
                        num = Integer.valueOf(Integer.parseInt(split[1]));
                    } else {
                        num = null;
                    }
                    zzbtVar.zzs(Integer.valueOf(parseInt));
                    zzbtVar.zzr(num);
                    return;
                } catch (NumberFormatException unused) {
                    return;
                }
            case '\n':
            case 11:
                try {
                    zzbtVar.zzl(Integer.valueOf(Integer.parseInt((String) this.zzc.get(0))));
                    return;
                } catch (NumberFormatException unused2) {
                    return;
                }
            case '\f':
            case '\r':
                try {
                    String str2 = (String) this.zzc.get(0);
                    int parseInt2 = Integer.parseInt(str2.substring(2, 4));
                    int parseInt3 = Integer.parseInt(str2.substring(0, 2));
                    zzbtVar.zzk(Integer.valueOf(parseInt2));
                    zzbtVar.zzj(Integer.valueOf(parseInt3));
                    return;
                } catch (NumberFormatException | StringIndexOutOfBoundsException unused3) {
                    return;
                }
            case 14:
                List zzb = zzb((String) this.zzc.get(0));
                int size = zzb.size();
                if (size != 1) {
                    if (size != 2) {
                        if (size == 3) {
                            zzbtVar.zzj((Integer) zzb.get(2));
                        } else {
                            return;
                        }
                    }
                    zzbtVar.zzk((Integer) zzb.get(1));
                }
                zzbtVar.zzl((Integer) zzb.get(0));
                return;
            case 15:
                List zzb2 = zzb((String) this.zzc.get(0));
                int size2 = zzb2.size();
                if (size2 != 1) {
                    if (size2 != 2) {
                        if (size2 == 3) {
                            zzbtVar.zzm((Integer) zzb2.get(2));
                        } else {
                            return;
                        }
                    }
                    zzbtVar.zzn((Integer) zzb2.get(1));
                }
                zzbtVar.zzo((Integer) zzb2.get(0));
                return;
            case 16:
            case 17:
                zzbtVar.zzf((CharSequence) this.zzc.get(0));
                return;
            case 18:
            case 19:
                zzbtVar.zzg((CharSequence) this.zzc.get(0));
                return;
            case 20:
            case 21:
                zzbtVar.zzt((CharSequence) this.zzc.get(0));
                return;
            default:
                return;
        }
    }
}
