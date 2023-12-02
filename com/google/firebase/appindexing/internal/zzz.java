package com.google.firebase.appindexing.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
@SafeParcelable.Class(creator = "MutateRequestCreator")
@SafeParcelable.Reserved({4})
/* loaded from: classes5.dex */
public final class zzz extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzz> CREATOR = new zzaa();
    @SafeParcelable.Field(id = 1)
    public final int zza;
    @Nullable
    @SafeParcelable.Field(id = 2)
    public final Thing[] zzb;
    @Nullable
    @SafeParcelable.Field(id = 3)
    public final String[] zzc;
    @Nullable
    @SafeParcelable.Field(id = 5)
    public final String[] zzd;
    @Nullable
    @SafeParcelable.Field(id = 6)
    public final zzc zze;
    @Nullable
    @SafeParcelable.Field(id = 7)
    public final String zzf;
    @Nullable
    @SafeParcelable.Field(id = 8)
    public final String zzg;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzz(@SafeParcelable.Param(id = 1) int i4, @Nullable @SafeParcelable.Param(id = 2) Thing[] thingArr, @Nullable @SafeParcelable.Param(id = 3) String[] strArr, @Nullable @SafeParcelable.Param(id = 5) String[] strArr2, @Nullable @SafeParcelable.Param(id = 6) zzc zzcVar, @Nullable @SafeParcelable.Param(id = 7) String str, @Nullable @SafeParcelable.Param(id = 8) String str2) {
        if (i4 != 0 && i4 != 1 && i4 != 2 && i4 != 3 && i4 != 4 && i4 != 6 && i4 != 7) {
            i4 = 0;
        }
        this.zza = i4;
        this.zzb = thingArr;
        this.zzc = strArr;
        this.zzd = strArr2;
        this.zze = zzcVar;
        this.zzf = str;
        this.zzg = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeTypedArray(parcel, 2, this.zzb, i4, false);
        SafeParcelWriter.writeStringArray(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeStringArray(parcel, 5, this.zzd, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zze, i4, false);
        SafeParcelWriter.writeString(parcel, 7, this.zzf, false);
        SafeParcelWriter.writeString(parcel, 8, this.zzg, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
