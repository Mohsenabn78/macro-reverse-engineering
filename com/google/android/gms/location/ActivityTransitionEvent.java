package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-location@@21.0.1 */
@SafeParcelable.Class(creator = "ActivityTransitionEventCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public class ActivityTransitionEvent extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<ActivityTransitionEvent> CREATOR = new zzf();
    @SafeParcelable.Field(getter = "getActivityType", id = 1)

    /* renamed from: a  reason: collision with root package name */
    private final int f20877a;
    @SafeParcelable.Field(getter = "getTransitionType", id = 2)

    /* renamed from: b  reason: collision with root package name */
    private final int f20878b;
    @SafeParcelable.Field(getter = "getElapsedRealTimeNanos", id = 3)

    /* renamed from: c  reason: collision with root package name */
    private final long f20879c;

    @SafeParcelable.Constructor
    public ActivityTransitionEvent(@SafeParcelable.Param(id = 1) int i4, @SafeParcelable.Param(id = 2) int i5, @SafeParcelable.Param(id = 3) long j4) {
        ActivityTransition.zza(i5);
        this.f20877a = i4;
        this.f20878b = i5;
        this.f20879c = j4;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActivityTransitionEvent)) {
            return false;
        }
        ActivityTransitionEvent activityTransitionEvent = (ActivityTransitionEvent) obj;
        if (this.f20877a == activityTransitionEvent.f20877a && this.f20878b == activityTransitionEvent.f20878b && this.f20879c == activityTransitionEvent.f20879c) {
            return true;
        }
        return false;
    }

    public int getActivityType() {
        return this.f20877a;
    }

    public long getElapsedRealTimeNanos() {
        return this.f20879c;
    }

    public int getTransitionType() {
        return this.f20878b;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.f20877a), Integer.valueOf(this.f20878b), Long.valueOf(this.f20879c));
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int i4 = this.f20877a;
        sb.append("ActivityType " + i4);
        sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
        int i5 = this.f20878b;
        sb.append("TransitionType " + i5);
        sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
        long j4 = this.f20879c;
        sb.append("ElapsedRealTimeNanos " + j4);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i4) {
        Preconditions.checkNotNull(parcel);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, getActivityType());
        SafeParcelWriter.writeInt(parcel, 2, getTransitionType());
        SafeParcelWriter.writeLong(parcel, 3, getElapsedRealTimeNanos());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
