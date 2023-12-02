package com.google.android.gms.nearby.presence;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@ShowFirstParty
@RequiresApi(26)
@SafeParcelable.Class(creator = "CastIdentityCreator")
/* loaded from: classes4.dex */
public final class zza extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zza> CREATOR = new zzb();
    @SafeParcelable.Field(getter = "getId", id = 1)

    /* renamed from: a  reason: collision with root package name */
    private final String f22479a;

    @SafeParcelable.Constructor
    public zza(@SafeParcelable.Param(id = 1) String str) {
        boolean z3;
        if (str.length() <= 32) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "Cast id should be at most 32 characters.");
        this.f22479a = str;
    }

    public final boolean equals(@Nullable Object obj) {
        if (!(obj instanceof zza)) {
            return false;
        }
        String str = this.f22479a;
        String str2 = ((zza) obj).f22479a;
        if (str != str2 && (str == null || !str.equals(str2))) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{17, this.f22479a});
    }

    public final String toString() {
        return String.format(Locale.US, "DataElement<type: %s, Id: %s>", "CastId", this.f22479a);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.f22479a, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
