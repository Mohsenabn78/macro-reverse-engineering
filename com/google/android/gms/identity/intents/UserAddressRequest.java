package com.google.android.gms.identity.intents;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.model.CountrySpecification;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-identity@@17.0.1 */
@SafeParcelable.Class(creator = "UserAddressRequestCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes4.dex */
public final class UserAddressRequest extends AbstractSafeParcelable implements ReflectedParcelable {
    @NonNull
    public static final Parcelable.Creator<UserAddressRequest> CREATOR = new zze();
    @SafeParcelable.Field(id = 2)

    /* renamed from: a  reason: collision with root package name */
    List<CountrySpecification> f20847a;

    /* compiled from: com.google.android.gms:play-services-identity@@17.0.1 */
    /* loaded from: classes4.dex */
    public final class Builder {
        /* synthetic */ Builder(zzd zzdVar) {
        }

        @NonNull
        public Builder addAllowedCountrySpecification(@NonNull CountrySpecification countrySpecification) {
            UserAddressRequest userAddressRequest = UserAddressRequest.this;
            if (userAddressRequest.f20847a == null) {
                userAddressRequest.f20847a = new ArrayList();
            }
            UserAddressRequest.this.f20847a.add(countrySpecification);
            return this;
        }

        @NonNull
        public Builder addAllowedCountrySpecifications(@NonNull Collection<CountrySpecification> collection) {
            UserAddressRequest userAddressRequest = UserAddressRequest.this;
            if (userAddressRequest.f20847a == null) {
                userAddressRequest.f20847a = new ArrayList();
            }
            UserAddressRequest.this.f20847a.addAll(collection);
            return this;
        }

        @NonNull
        public UserAddressRequest build() {
            UserAddressRequest userAddressRequest = UserAddressRequest.this;
            List<CountrySpecification> list = userAddressRequest.f20847a;
            if (list != null) {
                userAddressRequest.f20847a = Collections.unmodifiableList(list);
            }
            return UserAddressRequest.this;
        }
    }

    UserAddressRequest() {
    }

    @NonNull
    public static Builder newBuilder() {
        return new Builder(null);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 2, this.f20847a, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public UserAddressRequest(@SafeParcelable.Param(id = 2) List<CountrySpecification> list) {
        this.f20847a = list;
    }
}
