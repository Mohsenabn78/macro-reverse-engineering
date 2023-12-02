package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-location@@21.0.1 */
@ShowFirstParty
@SafeParcelable.Class(creator = "UserPreferredSleepWindowCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public final class zzaj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaj> CREATOR = new zzak();
    @SafeParcelable.Field(getter = "getStartHour", id = 1)

    /* renamed from: a  reason: collision with root package name */
    private final int f21184a;
    @SafeParcelable.Field(getter = "getStartMinute", id = 2)

    /* renamed from: b  reason: collision with root package name */
    private final int f21185b;
    @SafeParcelable.Field(getter = "getEndHour", id = 3)

    /* renamed from: c  reason: collision with root package name */
    private final int f21186c;
    @SafeParcelable.Field(getter = "getEndMinute", id = 4)

    /* renamed from: d  reason: collision with root package name */
    private final int f21187d;

    @SafeParcelable.Constructor
    public zzaj(@SafeParcelable.Param(id = 1) int i4, @SafeParcelable.Param(id = 2) int i5, @SafeParcelable.Param(id = 3) int i6, @SafeParcelable.Param(id = 4) int i7) {
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        if (i4 >= 0 && i4 <= 23) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkState(z3, "Start hour must be in range [0, 23].");
        if (i5 >= 0 && i5 <= 59) {
            z4 = true;
        } else {
            z4 = false;
        }
        Preconditions.checkState(z4, "Start minute must be in range [0, 59].");
        if (i6 >= 0 && i6 <= 23) {
            z5 = true;
        } else {
            z5 = false;
        }
        Preconditions.checkState(z5, "End hour must be in range [0, 23].");
        if (i7 >= 0 && i7 <= 59) {
            z6 = true;
        } else {
            z6 = false;
        }
        Preconditions.checkState(z6, "End minute must be in range [0, 59].");
        Preconditions.checkState(((i4 + i5) + i6) + i7 > 0, "Parameters can't be all 0.");
        this.f21184a = i4;
        this.f21185b = i5;
        this.f21186c = i6;
        this.f21187d = i7;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzaj)) {
            return false;
        }
        zzaj zzajVar = (zzaj) obj;
        if (this.f21184a == zzajVar.f21184a && this.f21185b == zzajVar.f21185b && this.f21186c == zzajVar.f21186c && this.f21187d == zzajVar.f21187d) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.f21184a), Integer.valueOf(this.f21185b), Integer.valueOf(this.f21186c), Integer.valueOf(this.f21187d));
    }

    public final String toString() {
        int i4 = this.f21184a;
        int i5 = this.f21185b;
        int i6 = this.f21186c;
        int i7 = this.f21187d;
        return "UserPreferredSleepWindow [startHour=" + i4 + ", startMinute=" + i5 + ", endHour=" + i6 + ", endMinute=" + i7 + "]";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        Preconditions.checkNotNull(parcel);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f21184a);
        SafeParcelWriter.writeInt(parcel, 2, this.f21185b);
        SafeParcelWriter.writeInt(parcel, 3, this.f21186c);
        SafeParcelWriter.writeInt(parcel, 4, this.f21187d);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
