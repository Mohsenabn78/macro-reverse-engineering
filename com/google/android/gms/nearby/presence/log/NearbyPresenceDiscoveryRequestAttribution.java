package com.google.android.gms.nearby.presence.log;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@SafeParcelable.Class(creator = "NearbyPresenceDiscoveryRequestAttributionCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public final class NearbyPresenceDiscoveryRequestAttribution extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<NearbyPresenceDiscoveryRequestAttribution> CREATOR = new zzd();
    @Nullable
    @SafeParcelable.Field(getter = "getDtdiAttribution", id = 1)

    /* renamed from: a  reason: collision with root package name */
    private DtdiAttribution f22477a;

    /* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
    @SafeParcelable.Reserved({1000})
    /* loaded from: classes4.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final NearbyPresenceDiscoveryRequestAttribution f22478a;

        public Builder() {
            this.f22478a = new NearbyPresenceDiscoveryRequestAttribution((zzc) null);
        }

        @NonNull
        public NearbyPresenceDiscoveryRequestAttribution build() {
            return this.f22478a;
        }

        @NonNull
        public Builder setDtdiAttribution(@Nullable DtdiAttribution dtdiAttribution) {
            this.f22478a.f22477a = dtdiAttribution;
            return this;
        }

        public Builder(@NonNull NearbyPresenceDiscoveryRequestAttribution nearbyPresenceDiscoveryRequestAttribution) {
            NearbyPresenceDiscoveryRequestAttribution nearbyPresenceDiscoveryRequestAttribution2 = new NearbyPresenceDiscoveryRequestAttribution((zzc) null);
            this.f22478a = nearbyPresenceDiscoveryRequestAttribution2;
            nearbyPresenceDiscoveryRequestAttribution2.f22477a = nearbyPresenceDiscoveryRequestAttribution.f22477a;
        }
    }

    private NearbyPresenceDiscoveryRequestAttribution() {
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof NearbyPresenceDiscoveryRequestAttribution) {
            return Objects.equal(this.f22477a, ((NearbyPresenceDiscoveryRequestAttribution) obj).f22477a);
        }
        return false;
    }

    @Nullable
    public DtdiAttribution getDtdiAttribution() {
        return this.f22477a;
    }

    public int hashCode() {
        return Objects.hashCode(this.f22477a);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getDtdiAttribution(), i4, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public NearbyPresenceDiscoveryRequestAttribution(@Nullable @SafeParcelable.Param(id = 1) DtdiAttribution dtdiAttribution) {
        this.f22477a = dtdiAttribution;
    }

    /* synthetic */ NearbyPresenceDiscoveryRequestAttribution(zzc zzcVar) {
    }
}
