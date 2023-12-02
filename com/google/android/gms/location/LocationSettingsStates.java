package com.google.android.gms.location;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;

/* compiled from: com.google.android.gms:play-services-location@@21.0.1 */
@SafeParcelable.Class(creator = "LocationSettingsStatesCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public final class LocationSettingsStates extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<LocationSettingsStates> CREATOR = new zzab();
    @SafeParcelable.Field(getter = "isGpsUsable", id = 1)

    /* renamed from: a  reason: collision with root package name */
    private final boolean f20981a;
    @SafeParcelable.Field(getter = "isNetworkLocationUsable", id = 2)

    /* renamed from: b  reason: collision with root package name */
    private final boolean f20982b;
    @SafeParcelable.Field(getter = "isBleUsable", id = 3)

    /* renamed from: c  reason: collision with root package name */
    private final boolean f20983c;
    @SafeParcelable.Field(getter = "isGpsPresent", id = 4)

    /* renamed from: d  reason: collision with root package name */
    private final boolean f20984d;
    @SafeParcelable.Field(getter = "isNetworkLocationPresent", id = 5)

    /* renamed from: e  reason: collision with root package name */
    private final boolean f20985e;
    @SafeParcelable.Field(getter = "isBlePresent", id = 6)

    /* renamed from: f  reason: collision with root package name */
    private final boolean f20986f;

    @SafeParcelable.Constructor
    public LocationSettingsStates(@SafeParcelable.Param(id = 1) boolean z3, @SafeParcelable.Param(id = 2) boolean z4, @SafeParcelable.Param(id = 3) boolean z5, @SafeParcelable.Param(id = 4) boolean z6, @SafeParcelable.Param(id = 5) boolean z7, @SafeParcelable.Param(id = 6) boolean z8) {
        this.f20981a = z3;
        this.f20982b = z4;
        this.f20983c = z5;
        this.f20984d = z6;
        this.f20985e = z7;
        this.f20986f = z8;
    }

    @Nullable
    public static LocationSettingsStates fromIntent(@NonNull Intent intent) {
        return (LocationSettingsStates) SafeParcelableSerializer.deserializeFromIntentExtra(intent, "com.google.android.gms.location.LOCATION_SETTINGS_STATES", CREATOR);
    }

    public boolean isBlePresent() {
        return this.f20986f;
    }

    public boolean isBleUsable() {
        return this.f20983c;
    }

    public boolean isGpsPresent() {
        return this.f20984d;
    }

    public boolean isGpsUsable() {
        return this.f20981a;
    }

    public boolean isLocationPresent() {
        if (!this.f20984d && !this.f20985e) {
            return false;
        }
        return true;
    }

    public boolean isLocationUsable() {
        if (!this.f20981a && !this.f20982b) {
            return false;
        }
        return true;
    }

    public boolean isNetworkLocationPresent() {
        return this.f20985e;
    }

    public boolean isNetworkLocationUsable() {
        return this.f20982b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, isGpsUsable());
        SafeParcelWriter.writeBoolean(parcel, 2, isNetworkLocationUsable());
        SafeParcelWriter.writeBoolean(parcel, 3, isBleUsable());
        SafeParcelWriter.writeBoolean(parcel, 4, isGpsPresent());
        SafeParcelWriter.writeBoolean(parcel, 5, isNetworkLocationPresent());
        SafeParcelWriter.writeBoolean(parcel, 6, isBlePresent());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
