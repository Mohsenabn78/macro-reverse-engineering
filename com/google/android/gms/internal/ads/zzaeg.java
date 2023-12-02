package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzaeg extends zzaen {
    public static final Parcelable.Creator<zzaeg> CREATOR = new zzaef();
    public final String zza;
    public final String zzb;
    public final String zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaeg(Parcel parcel) {
        super("COMM");
        String readString = parcel.readString();
        int i4 = zzfj.zza;
        this.zza = readString;
        this.zzb = parcel.readString();
        this.zzc = parcel.readString();
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzaeg.class == obj.getClass()) {
            zzaeg zzaegVar = (zzaeg) obj;
            if (zzfj.zzC(this.zzb, zzaegVar.zzb) && zzfj.zzC(this.zza, zzaegVar.zza) && zzfj.zzC(this.zzc, zzaegVar.zzc)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i4;
        int i5;
        String str = this.zza;
        int i6 = 0;
        if (str != null) {
            i4 = str.hashCode();
        } else {
            i4 = 0;
        }
        String str2 = this.zzb;
        if (str2 != null) {
            i5 = str2.hashCode();
        } else {
            i5 = 0;
        }
        int i7 = i4 + 527;
        String str3 = this.zzc;
        if (str3 != null) {
            i6 = str3.hashCode();
        }
        return (((i7 * 31) + i5) * 31) + i6;
    }

    @Override // com.google.android.gms.internal.ads.zzaen
    public final String toString() {
        String str = this.zzf;
        String str2 = this.zza;
        String str3 = this.zzb;
        return str + ": language=" + str2 + ", description=" + str3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.zzf);
        parcel.writeString(this.zza);
        parcel.writeString(this.zzc);
    }

    public zzaeg(String str, String str2, String str3) {
        super("COMM");
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
    }
}
