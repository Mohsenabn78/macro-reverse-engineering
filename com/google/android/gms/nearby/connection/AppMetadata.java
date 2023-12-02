package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@SafeParcelable.Class(creator = "AppMetadataCreator")
@SafeParcelable.Reserved({1000})
@Deprecated
/* loaded from: classes4.dex */
public final class AppMetadata extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<AppMetadata> CREATOR = new zzd();
    @SafeParcelable.Field(getter = "getAppIdentifiers", id = 1)

    /* renamed from: a  reason: collision with root package name */
    private final List f22143a;

    @SafeParcelable.Constructor
    public AppMetadata(@NonNull @SafeParcelable.Param(id = 1) List<AppIdentifier> list) {
        this.f22143a = (List) Preconditions.checkNotNull(list, "Must specify application identifiers");
        Preconditions.checkNotZero(list.size(), (Object) "Application identifiers cannot be empty");
    }

    @NonNull
    public List<AppIdentifier> getAppIdentifiers() {
        return this.f22143a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, getAppIdentifiers(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
