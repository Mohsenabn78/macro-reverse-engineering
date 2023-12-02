package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
@Deprecated
/* loaded from: classes4.dex */
public class zzadu implements zzby {
    public static final Parcelable.Creator<zzadu> CREATOR = new zzadt();
    public final String zza;
    public final String zzb;

    public zzadu(String str, String str2) {
        this.zza = str;
        this.zzb = str2;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzadu zzaduVar = (zzadu) obj;
            if (this.zza.equals(zzaduVar.zza) && this.zzb.equals(zzaduVar.zzb)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.zza.hashCode() + 527) * 31) + this.zzb.hashCode();
    }

    public final String toString() {
        String str = this.zza;
        String str2 = this.zzb;
        return "VC: " + str + "=" + str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.zza);
        parcel.writeString(this.zzb);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.gms.internal.ads.zzby
    public final void zza(zzbt zzbtVar) {
        char c4;
        String str = this.zza;
        switch (str.hashCode()) {
            case 62359119:
                if (str.equals("ALBUM")) {
                    c4 = 2;
                    break;
                }
                c4 = 65535;
                break;
            case 79833656:
                if (str.equals("TITLE")) {
                    c4 = 0;
                    break;
                }
                c4 = 65535;
                break;
            case 428414940:
                if (str.equals("DESCRIPTION")) {
                    c4 = 4;
                    break;
                }
                c4 = 65535;
                break;
            case 1746739798:
                if (str.equals("ALBUMARTIST")) {
                    c4 = 3;
                    break;
                }
                c4 = 65535;
                break;
            case 1939198791:
                if (str.equals("ARTIST")) {
                    c4 = 1;
                    break;
                }
                c4 = 65535;
                break;
            default:
                c4 = 65535;
                break;
        }
        if (c4 != 0) {
            if (c4 != 1) {
                if (c4 != 2) {
                    if (c4 != 3) {
                        if (c4 != 4) {
                            return;
                        }
                        zzbtVar.zzh(this.zzb);
                        return;
                    }
                    zzbtVar.zzc(this.zzb);
                    return;
                }
                zzbtVar.zzd(this.zzb);
                return;
            }
            zzbtVar.zze(this.zzb);
            return;
        }
        zzbtVar.zzq(this.zzb);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public zzadu(Parcel parcel) {
        String readString = parcel.readString();
        int i4 = zzfj.zza;
        this.zza = readString;
        this.zzb = parcel.readString();
    }
}
