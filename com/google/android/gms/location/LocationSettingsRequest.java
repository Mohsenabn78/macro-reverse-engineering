package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-location@@21.0.1 */
@SafeParcelable.Class(creator = "LocationSettingsRequestCreator")
@SafeParcelable.Reserved({4, 5, 1000})
/* loaded from: classes4.dex */
public final class LocationSettingsRequest extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<LocationSettingsRequest> CREATOR = new zzz();
    @SafeParcelable.Field(getter = "getLocationRequests", id = 1)

    /* renamed from: a  reason: collision with root package name */
    private final List f20973a;
    @SafeParcelable.Field(defaultValue = "false", getter = "alwaysShow", id = 2)

    /* renamed from: b  reason: collision with root package name */
    private final boolean f20974b;
    @SafeParcelable.Field(getter = "needBle", id = 3)

    /* renamed from: c  reason: collision with root package name */
    private final boolean f20975c;

    /* compiled from: com.google.android.gms:play-services-location@@21.0.1 */
    /* loaded from: classes4.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final ArrayList f20976a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        private boolean f20977b = false;

        /* renamed from: c  reason: collision with root package name */
        private boolean f20978c = false;

        @NonNull
        public Builder addAllLocationRequests(@NonNull Collection<LocationRequest> collection) {
            for (LocationRequest locationRequest : collection) {
                if (locationRequest != null) {
                    this.f20976a.add(locationRequest);
                }
            }
            return this;
        }

        @NonNull
        public Builder addLocationRequest(@NonNull LocationRequest locationRequest) {
            if (locationRequest != null) {
                this.f20976a.add(locationRequest);
            }
            return this;
        }

        @NonNull
        public LocationSettingsRequest build() {
            return new LocationSettingsRequest(this.f20976a, this.f20977b, this.f20978c);
        }

        @NonNull
        public Builder setAlwaysShow(boolean z3) {
            this.f20977b = z3;
            return this;
        }

        @NonNull
        public Builder setNeedBle(boolean z3) {
            this.f20978c = z3;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public LocationSettingsRequest(@SafeParcelable.Param(id = 1) List list, @SafeParcelable.Param(id = 2) boolean z3, @SafeParcelable.Param(id = 3) boolean z4) {
        this.f20973a = list;
        this.f20974b = z3;
        this.f20975c = z4;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, Collections.unmodifiableList(this.f20973a), false);
        SafeParcelWriter.writeBoolean(parcel, 2, this.f20974b);
        SafeParcelWriter.writeBoolean(parcel, 3, this.f20975c);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
