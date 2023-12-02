package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@SafeParcelable.Class(creator = "AppIdentifierCreator")
@SafeParcelable.Reserved({1000})
@Deprecated
/* loaded from: classes4.dex */
public final class AppIdentifier extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<AppIdentifier> CREATOR = new zzc();
    @SafeParcelable.Field(getter = "getIdentifier", id = 1)

    /* renamed from: a  reason: collision with root package name */
    private final String f22142a;

    @SafeParcelable.Constructor
    public AppIdentifier(@NonNull @SafeParcelable.Param(id = 1) String str) {
        this.f22142a = Preconditions.checkNotEmpty(str, "Missing application identifier value");
    }

    @NonNull
    public String getIdentifier() {
        return this.f22142a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getIdentifier(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
