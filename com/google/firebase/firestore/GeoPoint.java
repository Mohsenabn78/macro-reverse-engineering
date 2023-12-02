package com.google.firebase.firestore;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.firestore.util.Util;

/* loaded from: classes5.dex */
public class GeoPoint implements Comparable<GeoPoint> {

    /* renamed from: a  reason: collision with root package name */
    private final double f30192a;

    /* renamed from: b  reason: collision with root package name */
    private final double f30193b;

    public GeoPoint(double d4, double d5) {
        if (!Double.isNaN(d4) && d4 >= -90.0d && d4 <= 90.0d) {
            if (!Double.isNaN(d5) && d5 >= -180.0d && d5 <= 180.0d) {
                this.f30192a = d4;
                this.f30193b = d5;
                return;
            }
            throw new IllegalArgumentException("Longitude must be in the range of [-180, 180]");
        }
        throw new IllegalArgumentException("Latitude must be in the range of [-90, 90]");
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof GeoPoint)) {
            return false;
        }
        GeoPoint geoPoint = (GeoPoint) obj;
        if (this.f30192a != geoPoint.f30192a || this.f30193b != geoPoint.f30193b) {
            return false;
        }
        return true;
    }

    public double getLatitude() {
        return this.f30192a;
    }

    public double getLongitude() {
        return this.f30193b;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.f30192a);
        long doubleToLongBits2 = Double.doubleToLongBits(this.f30193b);
        return (((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
    }

    @NonNull
    public String toString() {
        return "GeoPoint { latitude=" + this.f30192a + ", longitude=" + this.f30193b + " }";
    }

    @Override // java.lang.Comparable
    public int compareTo(@NonNull GeoPoint geoPoint) {
        int compareDoubles = Util.compareDoubles(this.f30192a, geoPoint.f30192a);
        return compareDoubles == 0 ? Util.compareDoubles(this.f30193b, geoPoint.f30193b) : compareDoubles;
    }
}
