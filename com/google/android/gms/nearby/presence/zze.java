package com.google.android.gms.nearby.presence;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@ShowFirstParty
@RequiresApi(26)
@SafeParcelable.Class(creator = "DeviceTypeCreator")
/* loaded from: classes4.dex */
public final class zze extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zze> CREATOR = new zzf();
    @SafeParcelable.Field(defaultValue = "0", getter = "getValue", id = 1)

    /* renamed from: a  reason: collision with root package name */
    private final int f22489a;

    @SafeParcelable.Constructor
    public zze(@SafeParcelable.Param(id = 1) int i4) {
        this.f22489a = i4;
    }

    public final boolean equals(@Nullable Object obj) {
        if (!(obj instanceof zze) || this.f22489a != ((zze) obj).f22489a) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{22, Integer.valueOf(this.f22489a)});
    }

    public final String toString() {
        return String.format(Locale.US, "DataElement<type: %s, value: %d>", "DeviceType", Integer.valueOf(this.f22489a));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f22489a);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
