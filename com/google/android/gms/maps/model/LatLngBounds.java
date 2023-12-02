package com.google.android.gms.maps.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.GoogleMapOptions;

@SafeParcelable.Class(creator = "LatLngBoundsCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes4.dex */
public final class LatLngBounds extends AbstractSafeParcelable implements ReflectedParcelable {
    @KeepForSdk
    public static final Parcelable.Creator<LatLngBounds> CREATOR = new zze();
    @SafeParcelable.Field(id = 3)
    public final LatLng northeast;
    @SafeParcelable.Field(id = 2)
    public final LatLng southwest;

    /* loaded from: classes4.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private double f21319a = Double.POSITIVE_INFINITY;

        /* renamed from: b  reason: collision with root package name */
        private double f21320b = Double.NEGATIVE_INFINITY;

        /* renamed from: c  reason: collision with root package name */
        private double f21321c = Double.NaN;

        /* renamed from: d  reason: collision with root package name */
        private double f21322d = Double.NaN;

        public final LatLngBounds build() {
            Preconditions.checkState(!Double.isNaN(this.f21321c), "no included points");
            return new LatLngBounds(new LatLng(this.f21319a, this.f21321c), new LatLng(this.f21320b, this.f21322d));
        }

        public final Builder include(LatLng latLng) {
            this.f21319a = Math.min(this.f21319a, latLng.latitude);
            this.f21320b = Math.max(this.f21320b, latLng.latitude);
            double d4 = latLng.longitude;
            if (Double.isNaN(this.f21321c)) {
                this.f21321c = d4;
            } else {
                double d5 = this.f21321c;
                double d6 = this.f21322d;
                boolean z3 = false;
                if (d5 > d6 ? d5 <= d4 || d4 <= d6 : d5 <= d4 && d4 <= d6) {
                    z3 = true;
                }
                if (!z3) {
                    if (LatLngBounds.b(d5, d4) < LatLngBounds.d(this.f21322d, d4)) {
                        this.f21321c = d4;
                    }
                }
                return this;
            }
            this.f21322d = d4;
            return this;
        }
    }

    @SafeParcelable.Constructor
    public LatLngBounds(@SafeParcelable.Param(id = 2) LatLng latLng, @SafeParcelable.Param(id = 3) LatLng latLng2) {
        boolean z3;
        Preconditions.checkNotNull(latLng, "null southwest");
        Preconditions.checkNotNull(latLng2, "null northeast");
        double d4 = latLng2.latitude;
        double d5 = latLng.latitude;
        if (d4 >= d5) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "southern latitude exceeds northern latitude (%s > %s)", Double.valueOf(d5), Double.valueOf(latLng2.latitude));
        this.southwest = latLng;
        this.northeast = latLng2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static double b(double d4, double d5) {
        return ((d4 - d5) + 360.0d) % 360.0d;
    }

    public static Builder builder() {
        return new Builder();
    }

    private final boolean c(double d4) {
        double d5 = this.southwest.longitude;
        double d6 = this.northeast.longitude;
        if (d5 <= d6) {
            if (d5 > d4 || d4 > d6) {
                return false;
            }
            return true;
        } else if (d5 > d4 && d4 > d6) {
            return false;
        } else {
            return true;
        }
    }

    public static LatLngBounds createFromAttributes(Context context, AttributeSet attributeSet) {
        return GoogleMapOptions.zza(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static double d(double d4, double d5) {
        return ((d5 - d4) + 360.0d) % 360.0d;
    }

    public final boolean contains(LatLng latLng) {
        boolean z3;
        double d4 = latLng.latitude;
        if (this.southwest.latitude <= d4 && d4 <= this.northeast.latitude) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3 && c(latLng.longitude)) {
            return true;
        }
        return false;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LatLngBounds)) {
            return false;
        }
        LatLngBounds latLngBounds = (LatLngBounds) obj;
        if (this.southwest.equals(latLngBounds.southwest) && this.northeast.equals(latLngBounds.northeast)) {
            return true;
        }
        return false;
    }

    public final LatLng getCenter() {
        LatLng latLng = this.southwest;
        double d4 = latLng.latitude;
        LatLng latLng2 = this.northeast;
        double d5 = (d4 + latLng2.latitude) / 2.0d;
        double d6 = latLng2.longitude;
        double d7 = latLng.longitude;
        if (d7 > d6) {
            d6 += 360.0d;
        }
        return new LatLng(d5, (d6 + d7) / 2.0d);
    }

    public final int hashCode() {
        return Objects.hashCode(this.southwest, this.northeast);
    }

    public final LatLngBounds including(LatLng latLng) {
        double min = Math.min(this.southwest.latitude, latLng.latitude);
        double max = Math.max(this.northeast.latitude, latLng.latitude);
        double d4 = this.northeast.longitude;
        double d5 = this.southwest.longitude;
        double d6 = latLng.longitude;
        if (!c(d6)) {
            if (b(d5, d6) < d(d4, d6)) {
                d5 = d6;
            } else {
                d4 = d6;
            }
        }
        return new LatLngBounds(new LatLng(min, d5), new LatLng(max, d4));
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("southwest", this.southwest).add("northeast", this.northeast).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.southwest, i4, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.northeast, i4, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
