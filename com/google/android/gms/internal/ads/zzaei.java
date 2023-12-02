package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzaei extends zzaen {
    public static final Parcelable.Creator<zzaei> CREATOR = new zzaeh();
    public final String zza;
    public final String zzb;
    public final String zzc;
    public final byte[] zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaei(Parcel parcel) {
        super("GEOB");
        String readString = parcel.readString();
        int i4 = zzfj.zza;
        this.zza = readString;
        this.zzb = parcel.readString();
        this.zzc = parcel.readString();
        this.zzd = parcel.createByteArray();
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzaei.class == obj.getClass()) {
            zzaei zzaeiVar = (zzaei) obj;
            if (zzfj.zzC(this.zza, zzaeiVar.zza) && zzfj.zzC(this.zzb, zzaeiVar.zzb) && zzfj.zzC(this.zzc, zzaeiVar.zzc) && Arrays.equals(this.zzd, zzaeiVar.zzd)) {
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
        return (((((i7 * 31) + i5) * 31) + i6) * 31) + Arrays.hashCode(this.zzd);
    }

    @Override // com.google.android.gms.internal.ads.zzaen
    public final String toString() {
        String str = this.zzf;
        String str2 = this.zza;
        String str3 = this.zzb;
        String str4 = this.zzc;
        return str + ": mimeType=" + str2 + ", filename=" + str3 + ", description=" + str4;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.zza);
        parcel.writeString(this.zzb);
        parcel.writeString(this.zzc);
        parcel.writeByteArray(this.zzd);
    }

    public zzaei(String str, String str2, String str3, byte[] bArr) {
        super("GEOB");
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = bArr;
    }
}
