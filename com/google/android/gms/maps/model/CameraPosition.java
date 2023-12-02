package com.google.android.gms.maps.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

@SafeParcelable.Class(creator = "CameraPositionCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes4.dex */
public final class CameraPosition extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<CameraPosition> CREATOR = new zza();
    @SafeParcelable.Field(id = 5)
    public final float bearing;
    @SafeParcelable.Field(id = 2)
    public final LatLng target;
    @SafeParcelable.Field(id = 4)
    public final float tilt;
    @SafeParcelable.Field(id = 3)
    public final float zoom;

    /* loaded from: classes4.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private LatLng f21284a;

        /* renamed from: b  reason: collision with root package name */
        private float f21285b;

        /* renamed from: c  reason: collision with root package name */
        private float f21286c;

        /* renamed from: d  reason: collision with root package name */
        private float f21287d;

        public Builder() {
        }

        public Builder(CameraPosition cameraPosition) {
            this.f21284a = cameraPosition.target;
            this.f21285b = cameraPosition.zoom;
            this.f21286c = cameraPosition.tilt;
            this.f21287d = cameraPosition.bearing;
        }

        public final Builder bearing(float f4) {
            this.f21287d = f4;
            return this;
        }

        public final CameraPosition build() {
            return new CameraPosition(this.f21284a, this.f21285b, this.f21286c, this.f21287d);
        }

        public final Builder target(LatLng latLng) {
            this.f21284a = latLng;
            return this;
        }

        public final Builder tilt(float f4) {
            this.f21286c = f4;
            return this;
        }

        public final Builder zoom(float f4) {
            this.f21285b = f4;
            return this;
        }
    }

    @SafeParcelable.Constructor
    public CameraPosition(@SafeParcelable.Param(id = 2) LatLng latLng, @SafeParcelable.Param(id = 3) float f4, @SafeParcelable.Param(id = 4) float f5, @SafeParcelable.Param(id = 5) float f6) {
        boolean z3;
        Preconditions.checkNotNull(latLng, "null camera target");
        if (0.0f <= f5 && f5 <= 90.0f) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "Tilt needs to be between 0 and 90 inclusive: %s", Float.valueOf(f5));
        this.target = latLng;
        this.zoom = f4;
        this.tilt = f5 + 0.0f;
        this.bearing = (((double) f6) <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? (f6 % 360.0f) + 360.0f : f6) % 360.0f;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static CameraPosition createFromAttributes(Context context, AttributeSet attributeSet) {
        return GoogleMapOptions.zzb(context, attributeSet);
    }

    public static final CameraPosition fromLatLngZoom(LatLng latLng, float f4) {
        return new CameraPosition(latLng, f4, 0.0f, 0.0f);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CameraPosition)) {
            return false;
        }
        CameraPosition cameraPosition = (CameraPosition) obj;
        if (this.target.equals(cameraPosition.target) && Float.floatToIntBits(this.zoom) == Float.floatToIntBits(cameraPosition.zoom) && Float.floatToIntBits(this.tilt) == Float.floatToIntBits(cameraPosition.tilt) && Float.floatToIntBits(this.bearing) == Float.floatToIntBits(cameraPosition.bearing)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.target, Float.valueOf(this.zoom), Float.valueOf(this.tilt), Float.valueOf(this.bearing));
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("target", this.target).add("zoom", Float.valueOf(this.zoom)).add("tilt", Float.valueOf(this.tilt)).add("bearing", Float.valueOf(this.bearing)).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.target, i4, false);
        SafeParcelWriter.writeFloat(parcel, 3, this.zoom);
        SafeParcelWriter.writeFloat(parcel, 4, this.tilt);
        SafeParcelWriter.writeFloat(parcel, 5, this.bearing);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public static Builder builder(CameraPosition cameraPosition) {
        return new Builder(cameraPosition);
    }
}
