package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
@SafeParcelable.Class(creator = "AppParcelableCreator")
/* loaded from: classes4.dex */
public final class zzo extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzo> CREATOR = new zzp();
    @SafeParcelable.Field(id = 1)
    public final String zza;
    @SafeParcelable.Field(id = 2)
    public final String zzb;
    @SafeParcelable.Field(id = 3)
    public final zziv zzc;
    @SafeParcelable.Field(id = 4)
    public final String zzd;
    @Nullable
    @SafeParcelable.Field(id = 5)
    public final String zze;
    @Nullable
    @SafeParcelable.Field(id = 6)
    public final Float zzf;
    @Nullable
    @SafeParcelable.Field(id = 7)
    public final zzs zzg;

    @SafeParcelable.Constructor
    public zzo(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) String str2, @SafeParcelable.Param(id = 3) zziv zzivVar, @SafeParcelable.Param(id = 4) String str3, @Nullable @SafeParcelable.Param(id = 5) String str4, @Nullable @SafeParcelable.Param(id = 6) Float f4, @Nullable @SafeParcelable.Param(id = 7) zzs zzsVar) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzivVar;
        this.zzd = str3;
        this.zze = str4;
        this.zzf = f4;
        this.zzg = zzsVar;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzo.class == obj.getClass()) {
            zzo zzoVar = (zzo) obj;
            if (zzn.zza(this.zza, zzoVar.zza) && zzn.zza(this.zzb, zzoVar.zzb) && zzn.zza(this.zzc, zzoVar.zzc) && zzn.zza(this.zzd, zzoVar.zzd) && zzn.zza(this.zze, zzoVar.zze) && zzn.zza(this.zzf, zzoVar.zzf) && zzn.zza(this.zzg, zzoVar.zzg)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg});
    }

    public final String toString() {
        String str = this.zzb;
        String str2 = this.zzd;
        String str3 = this.zze;
        Float f4 = this.zzf;
        String valueOf = String.valueOf(this.zzg);
        String str4 = this.zza;
        String valueOf2 = String.valueOf(this.zzc);
        return "AppParcelable{title='" + str + "', developerName='" + str2 + "', formattedPrice='" + str3 + "', starRating=" + f4 + ", wearDetails=" + valueOf + ", deepLinkUri='" + str4 + "', icon=" + valueOf2 + "}";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzc, i4, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzd, false);
        SafeParcelWriter.writeString(parcel, 5, this.zze, false);
        SafeParcelWriter.writeFloatObject(parcel, 6, this.zzf, false);
        SafeParcelWriter.writeParcelable(parcel, 7, this.zzg, i4, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
