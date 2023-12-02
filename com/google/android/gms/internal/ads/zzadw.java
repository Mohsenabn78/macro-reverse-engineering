package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzadw implements zzby {
    public static final Parcelable.Creator<zzadw> CREATOR = new zzadv();
    public final int zza;
    @Nullable
    public final String zzb;
    @Nullable
    public final String zzc;
    @Nullable
    public final String zzd;
    public final boolean zze;
    public final int zzf;

    public zzadw(int i4, @Nullable String str, @Nullable String str2, @Nullable String str3, boolean z3, int i5) {
        boolean z4 = true;
        if (i5 != -1 && i5 <= 0) {
            z4 = false;
        }
        zzdy.zzd(z4);
        this.zza = i4;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = str3;
        this.zze = z3;
        this.zzf = i5;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzadw.class == obj.getClass()) {
            zzadw zzadwVar = (zzadw) obj;
            if (this.zza == zzadwVar.zza && zzfj.zzC(this.zzb, zzadwVar.zzb) && zzfj.zzC(this.zzc, zzadwVar.zzc) && zzfj.zzC(this.zzd, zzadwVar.zzd) && this.zze == zzadwVar.zze && this.zzf == zzadwVar.zzf) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i4;
        int i5;
        int i6 = this.zza + 527;
        String str = this.zzb;
        int i7 = 0;
        if (str != null) {
            i4 = str.hashCode();
        } else {
            i4 = 0;
        }
        int i8 = i6 * 31;
        String str2 = this.zzc;
        if (str2 != null) {
            i5 = str2.hashCode();
        } else {
            i5 = 0;
        }
        int i9 = (((i8 + i4) * 31) + i5) * 31;
        String str3 = this.zzd;
        if (str3 != null) {
            i7 = str3.hashCode();
        }
        return ((((i9 + i7) * 31) + (this.zze ? 1 : 0)) * 31) + this.zzf;
    }

    public final String toString() {
        String str = this.zzc;
        String str2 = this.zzb;
        int i4 = this.zza;
        int i5 = this.zzf;
        return "IcyHeaders: name=\"" + str + "\", genre=\"" + str2 + "\", bitrate=" + i4 + ", metadataInterval=" + i5;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeInt(this.zza);
        parcel.writeString(this.zzb);
        parcel.writeString(this.zzc);
        parcel.writeString(this.zzd);
        boolean z3 = this.zze;
        int i5 = zzfj.zza;
        parcel.writeInt(z3 ? 1 : 0);
        parcel.writeInt(this.zzf);
    }

    @Override // com.google.android.gms.internal.ads.zzby
    public final void zza(zzbt zzbtVar) {
        String str = this.zzc;
        if (str != null) {
            zzbtVar.zzp(str);
        }
        String str2 = this.zzb;
        if (str2 != null) {
            zzbtVar.zzi(str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzadw(Parcel parcel) {
        this.zza = parcel.readInt();
        this.zzb = parcel.readString();
        this.zzc = parcel.readString();
        this.zzd = parcel.readString();
        int i4 = zzfj.zza;
        this.zze = parcel.readInt() != 0;
        this.zzf = parcel.readInt();
    }
}
