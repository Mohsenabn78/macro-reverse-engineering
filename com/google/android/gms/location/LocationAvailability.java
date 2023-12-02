package com.google.android.gms.location;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* compiled from: com.google.android.gms:play-services-location@@21.0.1 */
@SafeParcelable.Class(creator = "LocationAvailabilityCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public final class LocationAvailability extends AbstractSafeParcelable implements ReflectedParcelable {
    @SafeParcelable.Field(defaultValueUnchecked = "LocationAvailability.STATUS_UNKNOWN", getter = "getCellStatus", id = 1)

    /* renamed from: a  reason: collision with root package name */
    private final int f20936a;
    @SafeParcelable.Field(defaultValueUnchecked = "LocationAvailability.STATUS_UNKNOWN", getter = "getWifiStatus", id = 2)

    /* renamed from: b  reason: collision with root package name */
    private final int f20937b;
    @SafeParcelable.Field(defaultValueUnchecked = "0", getter = "getElapsedRealtimeNs", id = 3)

    /* renamed from: c  reason: collision with root package name */
    private final long f20938c;
    @SafeParcelable.Field(defaultValueUnchecked = "LocationAvailability.STATUS_UNSUCCESSFUL", id = 4)

    /* renamed from: d  reason: collision with root package name */
    int f20939d;
    @SafeParcelable.Field(getter = "getBatchedStatus", id = 5)

    /* renamed from: e  reason: collision with root package name */
    private final zzac[] f20940e;
    @NonNull
    public static final LocationAvailability zza = new LocationAvailability(0, 1, 1, 0, null, true);
    @NonNull
    public static final LocationAvailability zzb = new LocationAvailability(1000, 1, 1, 0, null, false);
    @NonNull
    public static final Parcelable.Creator<LocationAvailability> CREATOR = new zzw();

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public LocationAvailability(@SafeParcelable.Param(id = 4) int i4, @SafeParcelable.Param(id = 1) int i5, @SafeParcelable.Param(id = 2) int i6, @SafeParcelable.Param(id = 3) long j4, @SafeParcelable.Param(id = 5) zzac[] zzacVarArr, @SafeParcelable.Param(id = 6) boolean z3) {
        this.f20939d = i4 < 1000 ? 0 : 1000;
        this.f20936a = i5;
        this.f20937b = i6;
        this.f20938c = j4;
        this.f20940e = zzacVarArr;
    }

    @Nullable
    public static LocationAvailability extractLocationAvailability(@NonNull Intent intent) {
        if (!hasLocationAvailability(intent)) {
            return null;
        }
        try {
            return (LocationAvailability) intent.getParcelableExtra("com.google.android.gms.location.EXTRA_LOCATION_AVAILABILITY");
        } catch (ClassCastException unused) {
            return null;
        }
    }

    @EnsuresNonNullIf(expression = {"#1"}, result = true)
    public static boolean hasLocationAvailability(@Nullable Intent intent) {
        if (intent != null && intent.hasExtra("com.google.android.gms.location.EXTRA_LOCATION_AVAILABILITY")) {
            return true;
        }
        return false;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof LocationAvailability) {
            LocationAvailability locationAvailability = (LocationAvailability) obj;
            if (this.f20936a == locationAvailability.f20936a && this.f20937b == locationAvailability.f20937b && this.f20938c == locationAvailability.f20938c && this.f20939d == locationAvailability.f20939d && Arrays.equals(this.f20940e, locationAvailability.f20940e)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.f20939d));
    }

    public boolean isLocationAvailable() {
        if (this.f20939d < 1000) {
            return true;
        }
        return false;
    }

    @NonNull
    public String toString() {
        boolean isLocationAvailable = isLocationAvailable();
        return "LocationAvailability[" + isLocationAvailable + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f20936a);
        SafeParcelWriter.writeInt(parcel, 2, this.f20937b);
        SafeParcelWriter.writeLong(parcel, 3, this.f20938c);
        SafeParcelWriter.writeInt(parcel, 4, this.f20939d);
        SafeParcelWriter.writeTypedArray(parcel, 5, this.f20940e, i4, false);
        SafeParcelWriter.writeBoolean(parcel, 6, isLocationAvailable());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
