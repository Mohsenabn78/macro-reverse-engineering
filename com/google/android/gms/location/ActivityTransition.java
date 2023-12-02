package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: com.google.android.gms:play-services-location@@21.0.1 */
@SafeParcelable.Class(creator = "ActivityTransitionCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public class ActivityTransition extends AbstractSafeParcelable {
    public static final int ACTIVITY_TRANSITION_ENTER = 0;
    public static final int ACTIVITY_TRANSITION_EXIT = 1;
    @NonNull
    public static final Parcelable.Creator<ActivityTransition> CREATOR = new zze();
    @SafeParcelable.Field(getter = "getActivityType", id = 1)

    /* renamed from: a  reason: collision with root package name */
    private final int f20873a;
    @SafeParcelable.Field(getter = "getTransitionType", id = 2)

    /* renamed from: b  reason: collision with root package name */
    private final int f20874b;

    /* compiled from: com.google.android.gms:play-services-location@@21.0.1 */
    /* loaded from: classes4.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private int f20875a = -1;

        /* renamed from: b  reason: collision with root package name */
        private int f20876b = -1;

        @NonNull
        public ActivityTransition build() {
            boolean z3;
            boolean z4 = true;
            if (this.f20875a != -1) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkState(z3, "Activity type not set.");
            if (this.f20876b == -1) {
                z4 = false;
            }
            Preconditions.checkState(z4, "Activity transition type not set.");
            return new ActivityTransition(this.f20875a, this.f20876b);
        }

        @NonNull
        public Builder setActivityTransition(int i4) {
            ActivityTransition.zza(i4);
            this.f20876b = i4;
            return this;
        }

        @NonNull
        public Builder setActivityType(int i4) {
            this.f20875a = i4;
            return this;
        }
    }

    /* compiled from: com.google.android.gms:play-services-location@@21.0.1 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes4.dex */
    public @interface SupportedActivityTransition {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public ActivityTransition(@SafeParcelable.Param(id = 1) int i4, @SafeParcelable.Param(id = 2) int i5) {
        this.f20873a = i4;
        this.f20874b = i5;
    }

    public static void zza(int i4) {
        boolean z3 = false;
        if (i4 >= 0 && i4 <= 1) {
            z3 = true;
        }
        Preconditions.checkArgument(z3, "Transition type " + i4 + " is not valid.");
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActivityTransition)) {
            return false;
        }
        ActivityTransition activityTransition = (ActivityTransition) obj;
        if (this.f20873a == activityTransition.f20873a && this.f20874b == activityTransition.f20874b) {
            return true;
        }
        return false;
    }

    public int getActivityType() {
        return this.f20873a;
    }

    public int getTransitionType() {
        return this.f20874b;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.f20873a), Integer.valueOf(this.f20874b));
    }

    @NonNull
    public String toString() {
        int i4 = this.f20873a;
        int i5 = this.f20874b;
        return "ActivityTransition [mActivityType=" + i4 + ", mTransitionType=" + i5 + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i4) {
        Preconditions.checkNotNull(parcel);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, getActivityType());
        SafeParcelWriter.writeInt(parcel, 2, getTransitionType());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
