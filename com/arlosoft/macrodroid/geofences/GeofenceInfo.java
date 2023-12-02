package com.arlosoft.macrodroid.geofences;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.common.DontObfuscate;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: GeofenceInfo.kt */
@StabilityInferred(parameters = 0)
@DontObfuscate
@Parcelize
/* loaded from: classes3.dex */
public final class GeofenceInfo implements Parcelable, Comparable<GeofenceInfo> {
    public static final int $stable = 0;
    @NotNull
    public static final String GEOFENCE_CACHE = "GeofenceInfo";
    @NotNull
    public static final String GEOFENCE_GENERIC_ID = "generic";
    @NotNull
    public static final String GEOFENCE_KEY = "GeofenceInfo";
    public static final int STATUS_INSIDE = 1;
    public static final int STATUS_OUTSIDE = 2;
    public static final int STATUS_UNKNOWN = 0;
    @NotNull
    private final String id;
    private final int insideStatus;
    private final double latitude;
    private final double longitude;
    @NotNull
    private final String name;
    private final int radius;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final Parcelable.Creator<GeofenceInfo> CREATOR = new Creator();

    /* compiled from: GeofenceInfo.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: GeofenceInfo.kt */
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<GeofenceInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final GeofenceInfo createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new GeofenceInfo(parcel.readString(), parcel.readString(), parcel.readDouble(), parcel.readDouble(), parcel.readInt(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final GeofenceInfo[] newArray(int i4) {
            return new GeofenceInfo[i4];
        }
    }

    public GeofenceInfo(@NotNull String id, @NotNull String name, double d4, double d5, int i4, int i5) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        this.id = id;
        this.name = name;
        this.latitude = d4;
        this.longitude = d5;
        this.radius = i4;
        this.insideStatus = i5;
    }

    public static /* synthetic */ GeofenceInfo copy$default(GeofenceInfo geofenceInfo, String str, String str2, double d4, double d5, int i4, int i5, int i6, Object obj) {
        String str3;
        String str4;
        double d6;
        double d7;
        int i7;
        int i8;
        if ((i6 & 1) != 0) {
            str3 = geofenceInfo.id;
        } else {
            str3 = str;
        }
        if ((i6 & 2) != 0) {
            str4 = geofenceInfo.name;
        } else {
            str4 = str2;
        }
        if ((i6 & 4) != 0) {
            d6 = geofenceInfo.latitude;
        } else {
            d6 = d4;
        }
        if ((i6 & 8) != 0) {
            d7 = geofenceInfo.longitude;
        } else {
            d7 = d5;
        }
        if ((i6 & 16) != 0) {
            i7 = geofenceInfo.radius;
        } else {
            i7 = i4;
        }
        if ((i6 & 32) != 0) {
            i8 = geofenceInfo.insideStatus;
        } else {
            i8 = i5;
        }
        return geofenceInfo.copy(str3, str4, d6, d7, i7, i8);
    }

    @NotNull
    public final String component1() {
        return this.id;
    }

    @NotNull
    public final String component2() {
        return this.name;
    }

    public final double component3() {
        return this.latitude;
    }

    public final double component4() {
        return this.longitude;
    }

    public final int component5() {
        return this.radius;
    }

    public final int component6() {
        return this.insideStatus;
    }

    @NotNull
    public final GeofenceInfo copy(@NotNull String id, @NotNull String name, double d4, double d5, int i4, int i5) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        return new GeofenceInfo(id, name, d4, d5, i4, i5);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GeofenceInfo)) {
            return false;
        }
        GeofenceInfo geofenceInfo = (GeofenceInfo) obj;
        if (Intrinsics.areEqual(this.id, geofenceInfo.id) && Intrinsics.areEqual(this.name, geofenceInfo.name) && Double.compare(this.latitude, geofenceInfo.latitude) == 0 && Double.compare(this.longitude, geofenceInfo.longitude) == 0 && this.radius == geofenceInfo.radius && this.insideStatus == geofenceInfo.insideStatus) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    public final int getInsideStatus() {
        return this.insideStatus;
    }

    public final double getLatitude() {
        return this.latitude;
    }

    public final double getLongitude() {
        return this.longitude;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public final int getRadius() {
        return this.radius;
    }

    public int hashCode() {
        return (((((((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + androidx.compose.animation.core.b.a(this.latitude)) * 31) + androidx.compose.animation.core.b.a(this.longitude)) * 31) + this.radius) * 31) + this.insideStatus;
    }

    @NotNull
    public String toString() {
        String str = this.id;
        String str2 = this.name;
        double d4 = this.latitude;
        double d5 = this.longitude;
        int i4 = this.radius;
        int i5 = this.insideStatus;
        return "GeofenceInfo(id=" + str + ", name=" + str2 + ", latitude=" + d4 + ", longitude=" + d5 + ", radius=" + i4 + ", insideStatus=" + i5 + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeString(this.id);
        out.writeString(this.name);
        out.writeDouble(this.latitude);
        out.writeDouble(this.longitude);
        out.writeInt(this.radius);
        out.writeInt(this.insideStatus);
    }

    @Override // java.lang.Comparable
    public int compareTo(@NotNull GeofenceInfo otherGroup) {
        Intrinsics.checkNotNullParameter(otherGroup, "otherGroup");
        return this.name.compareTo(otherGroup.name);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ GeofenceInfo(java.lang.String r12, java.lang.String r13, double r14, double r16, int r18, int r19, int r20, kotlin.jvm.internal.DefaultConstructorMarker r21) {
        /*
            r11 = this;
            r0 = r20 & 1
            if (r0 == 0) goto L13
            java.util.UUID r0 = java.util.UUID.randomUUID()
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "randomUUID().toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r3 = r0
            goto L14
        L13:
            r3 = r12
        L14:
            r0 = r20 & 2
            if (r0 == 0) goto L1c
            java.lang.String r0 = ""
            r4 = r0
            goto L1d
        L1c:
            r4 = r13
        L1d:
            r0 = r20 & 4
            r1 = 0
            if (r0 == 0) goto L25
            r5 = r1
            goto L26
        L25:
            r5 = r14
        L26:
            r0 = r20 & 8
            if (r0 == 0) goto L2c
            r7 = r1
            goto L2e
        L2c:
            r7 = r16
        L2e:
            r0 = r20 & 16
            if (r0 == 0) goto L35
            r0 = 0
            r9 = 0
            goto L37
        L35:
            r9 = r18
        L37:
            r2 = r11
            r10 = r19
            r2.<init>(r3, r4, r5, r7, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.geofences.GeofenceInfo.<init>(java.lang.String, java.lang.String, double, double, int, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
