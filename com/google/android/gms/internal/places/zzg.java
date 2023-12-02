package com.google.android.gms.internal.places;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "PlaceAliasCreator")
@SafeParcelable.Reserved({1000})
@Deprecated
@ShowFirstParty
/* loaded from: classes4.dex */
public final class zzg extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzg> CREATOR = new zzf();
    private static final zzg zzda = new zzg("Home");
    private static final zzg zzdb = new zzg("Work");
    @SafeParcelable.Field(getter = "getAlias", id = 1)
    private final String zzdc;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzg(@SafeParcelable.Param(id = 1) String str) {
        this.zzdc = str;
    }

    @ShowFirstParty
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzg)) {
            return false;
        }
        return Objects.equal(this.zzdc, ((zzg) obj).zzdc);
    }

    @ShowFirstParty
    public final int hashCode() {
        return Objects.hashCode(this.zzdc);
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("alias", this.zzdc).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzdc, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
