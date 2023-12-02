package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@SafeParcelable.Class(creator = "StopDiscoveryParamsCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public final class zznd extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zznd> CREATOR = new zzne();

    public final boolean equals(@Nullable Object obj) {
        if (this == obj || (obj instanceof zznd)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        SafeParcelWriter.finishObjectHeader(parcel, SafeParcelWriter.beginObjectHeader(parcel));
    }
}
