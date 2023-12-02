package com.google.android.gms.internal.places;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

@SafeParcelable.Class(creator = "PlaceUserDataCreator")
@SafeParcelable.Reserved({1000})
@Deprecated
@ShowFirstParty
/* loaded from: classes4.dex */
public final class zzi extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzi> CREATOR = new zzj();
    @SafeParcelable.Field(getter = "getPlaceId", id = 2)
    private final String placeId;
    @SafeParcelable.Field(getter = "getUserAccountName", id = 1)
    private final String zzav;
    @SafeParcelable.Field(getter = "getPlaceAliases", id = 6)
    private final List<zzg> zzdd;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzi(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) String str2, @SafeParcelable.Param(id = 6) List<zzg> list) {
        this.zzav = str;
        this.placeId = str2;
        this.zzdd = list;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzi)) {
            return false;
        }
        zzi zziVar = (zzi) obj;
        if (this.zzav.equals(zziVar.zzav) && this.placeId.equals(zziVar.placeId) && this.zzdd.equals(zziVar.zzdd)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzav, this.placeId, this.zzdd);
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("accountName", this.zzav).add("placeId", this.placeId).add("placeAliases", this.zzdd).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzav, false);
        SafeParcelWriter.writeString(parcel, 2, this.placeId, false);
        SafeParcelWriter.writeTypedList(parcel, 6, this.zzdd, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
