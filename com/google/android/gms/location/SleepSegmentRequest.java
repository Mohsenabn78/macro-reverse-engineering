package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-location@@21.0.1 */
@SafeParcelable.Class(creator = "SleepSegmentRequestCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public class SleepSegmentRequest extends AbstractSafeParcelable {
    public static final int CLASSIFY_EVENTS_ONLY = 2;
    @NonNull
    public static final Parcelable.Creator<SleepSegmentRequest> CREATOR = new zzah();
    public static final int SEGMENT_AND_CLASSIFY_EVENTS = 0;
    public static final int SEGMENT_EVENTS_ONLY = 1;
    @Nullable
    @SafeParcelable.Field(getter = "getUserPreferredSleepWindow", id = 1)

    /* renamed from: a  reason: collision with root package name */
    private final List f21001a;
    @SafeParcelable.Field(defaultValue = "0", getter = "getRequestedDataType", id = 2)

    /* renamed from: b  reason: collision with root package name */
    private final int f21002b;

    public SleepSegmentRequest(int i4) {
        this(null, i4);
    }

    @NonNull
    public static SleepSegmentRequest getDefaultSleepSegmentRequest() {
        return new SleepSegmentRequest(null, 0);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SleepSegmentRequest)) {
            return false;
        }
        SleepSegmentRequest sleepSegmentRequest = (SleepSegmentRequest) obj;
        if (Objects.equal(this.f21001a, sleepSegmentRequest.f21001a) && this.f21002b == sleepSegmentRequest.f21002b) {
            return true;
        }
        return false;
    }

    public int getRequestedDataType() {
        return this.f21002b;
    }

    public int hashCode() {
        return Objects.hashCode(this.f21001a, Integer.valueOf(this.f21002b));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i4) {
        Preconditions.checkNotNull(parcel);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, this.f21001a, false);
        SafeParcelWriter.writeInt(parcel, 2, getRequestedDataType());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @ShowFirstParty
    @SafeParcelable.Constructor
    public SleepSegmentRequest(@Nullable @SafeParcelable.Param(id = 1) List list, @SafeParcelable.Param(id = 2) int i4) {
        this.f21001a = list;
        this.f21002b = i4;
    }
}
