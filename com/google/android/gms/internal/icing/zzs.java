package com.google.android.gms.internal.icing;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
@ShowFirstParty
@SafeParcelable.Class(creator = "RegisterSectionInfoCreator")
@SafeParcelable.Reserved({1000, 8, 9, 10})
/* loaded from: classes4.dex */
public final class zzs extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzs> CREATOR = new zzt();
    @SafeParcelable.Field(id = 1)
    public final String zza;
    @SafeParcelable.Field(id = 2)
    public final String zzb;
    @SafeParcelable.Field(id = 3)
    public final boolean zzc;
    @SafeParcelable.Field(defaultValue = "1", id = 4)
    public final int zzd;
    @SafeParcelable.Field(id = 5)
    public final boolean zze;
    @Nullable
    @SafeParcelable.Field(id = 6)
    public final String zzf;
    @Nullable
    @SafeParcelable.Field(id = 7)
    public final zzm[] zzg;
    @Nullable
    @SafeParcelable.Field(id = 11)
    public final String zzh;
    @SafeParcelable.Field(id = 12)
    public final zzu zzi;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzs(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) String str2, @SafeParcelable.Param(id = 3) boolean z3, @SafeParcelable.Param(id = 4) int i4, @SafeParcelable.Param(id = 5) boolean z4, @Nullable @SafeParcelable.Param(id = 6) String str3, @SafeParcelable.Param(id = 7) zzm[] zzmVarArr, @Nullable @SafeParcelable.Param(id = 11) String str4, @SafeParcelable.Param(id = 12) zzu zzuVar) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = z3;
        this.zzd = i4;
        this.zze = z4;
        this.zzf = str3;
        this.zzg = zzmVarArr;
        this.zzh = str4;
        this.zzi = zzuVar;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzs)) {
            return false;
        }
        zzs zzsVar = (zzs) obj;
        if (this.zzc == zzsVar.zzc && this.zzd == zzsVar.zzd && this.zze == zzsVar.zze && Objects.equal(this.zza, zzsVar.zza) && Objects.equal(this.zzb, zzsVar.zzb) && Objects.equal(this.zzf, zzsVar.zzf) && Objects.equal(this.zzh, zzsVar.zzh) && Objects.equal(this.zzi, zzsVar.zzi) && Arrays.equals(this.zzg, zzsVar.zzg)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, Boolean.valueOf(this.zzc), Integer.valueOf(this.zzd), Boolean.valueOf(this.zze), this.zzf, Integer.valueOf(Arrays.hashCode(this.zzg)), this.zzh, this.zzi);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzc);
        SafeParcelWriter.writeInt(parcel, 4, this.zzd);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zze);
        SafeParcelWriter.writeString(parcel, 6, this.zzf, false);
        SafeParcelWriter.writeTypedArray(parcel, 7, this.zzg, i4, false);
        SafeParcelWriter.writeString(parcel, 11, this.zzh, false);
        SafeParcelWriter.writeParcelable(parcel, 12, this.zzi, i4, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
