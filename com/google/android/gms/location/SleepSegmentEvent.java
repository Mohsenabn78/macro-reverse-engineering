package com.google.android.gms.location;

import android.content.Intent;
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
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-location@@21.0.1 */
@SafeParcelable.Class(creator = "SleepSegmentEventCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public class SleepSegmentEvent extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<SleepSegmentEvent> CREATOR = new zzag();
    public static final int STATUS_MISSING_DATA = 1;
    public static final int STATUS_NOT_DETECTED = 2;
    public static final int STATUS_SUCCESSFUL = 0;
    @SafeParcelable.Field(getter = "getStartTimeMillis", id = 1)

    /* renamed from: a  reason: collision with root package name */
    private final long f20996a;
    @SafeParcelable.Field(getter = "getEndTimeMillis", id = 2)

    /* renamed from: b  reason: collision with root package name */
    private final long f20997b;
    @SafeParcelable.Field(getter = "getStatus", id = 3)

    /* renamed from: c  reason: collision with root package name */
    private final int f20998c;
    @SafeParcelable.Field(getter = "getMissingDataDurationMinutes", id = 4)

    /* renamed from: d  reason: collision with root package name */
    private final int f20999d;
    @SafeParcelable.Field(getter = "getNinetiethPctConfidence", id = 5)

    /* renamed from: e  reason: collision with root package name */
    private final int f21000e;

    @ShowFirstParty
    @SafeParcelable.Constructor
    public SleepSegmentEvent(@SafeParcelable.Param(id = 1) long j4, @SafeParcelable.Param(id = 2) long j5, @SafeParcelable.Param(id = 3) int i4, @SafeParcelable.Param(id = 4) int i5, @SafeParcelable.Param(id = 5) int i6) {
        boolean z3;
        if (j4 <= j5) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "endTimeMillis must be greater than or equal to startTimeMillis");
        this.f20996a = j4;
        this.f20997b = j5;
        this.f20998c = i4;
        this.f20999d = i5;
        this.f21000e = i6;
    }

    @NonNull
    public static List<SleepSegmentEvent> extractEvents(@NonNull Intent intent) {
        Preconditions.checkNotNull(intent);
        if (!hasEvents(intent)) {
            return Collections.emptyList();
        }
        ArrayList arrayList = (ArrayList) intent.getSerializableExtra("com.google.android.location.internal.EXTRA_SLEEP_SEGMENT_RESULT");
        if (arrayList == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            byte[] bArr = (byte[]) arrayList.get(i4);
            Preconditions.checkNotNull(bArr);
            arrayList2.add((SleepSegmentEvent) SafeParcelableSerializer.deserializeFromBytes(bArr, CREATOR));
        }
        return Collections.unmodifiableList(arrayList2);
    }

    public static boolean hasEvents(@Nullable Intent intent) {
        if (intent == null) {
            return false;
        }
        return intent.hasExtra("com.google.android.location.internal.EXTRA_SLEEP_SEGMENT_RESULT");
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof SleepSegmentEvent) {
            SleepSegmentEvent sleepSegmentEvent = (SleepSegmentEvent) obj;
            if (this.f20996a == sleepSegmentEvent.getStartTimeMillis() && this.f20997b == sleepSegmentEvent.getEndTimeMillis() && this.f20998c == sleepSegmentEvent.getStatus() && this.f20999d == sleepSegmentEvent.f20999d && this.f21000e == sleepSegmentEvent.f21000e) {
                return true;
            }
        }
        return false;
    }

    public long getEndTimeMillis() {
        return this.f20997b;
    }

    public long getSegmentDurationMillis() {
        return this.f20997b - this.f20996a;
    }

    public long getStartTimeMillis() {
        return this.f20996a;
    }

    public int getStatus() {
        return this.f20998c;
    }

    public int hashCode() {
        return Objects.hashCode(Long.valueOf(this.f20996a), Long.valueOf(this.f20997b), Integer.valueOf(this.f20998c));
    }

    @NonNull
    public String toString() {
        long j4 = this.f20996a;
        long j5 = this.f20997b;
        int i4 = this.f20998c;
        return "startMillis=" + j4 + ", endMillis=" + j5 + ", status=" + i4;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i4) {
        Preconditions.checkNotNull(parcel);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, getStartTimeMillis());
        SafeParcelWriter.writeLong(parcel, 2, getEndTimeMillis());
        SafeParcelWriter.writeInt(parcel, 3, getStatus());
        SafeParcelWriter.writeInt(parcel, 4, this.f20999d);
        SafeParcelWriter.writeInt(parcel, 5, this.f21000e);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
