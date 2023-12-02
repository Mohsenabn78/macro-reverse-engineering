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
@SafeParcelable.Class(creator = "SleepClassifyEventCreator")
/* loaded from: classes4.dex */
public class SleepClassifyEvent extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<SleepClassifyEvent> CREATOR = new zzaf();
    @SafeParcelable.Field(getter = "getTimestampSec", id = 1)

    /* renamed from: a  reason: collision with root package name */
    private final int f20987a;
    @SafeParcelable.Field(getter = "getConfidence", id = 2)

    /* renamed from: b  reason: collision with root package name */
    private final int f20988b;
    @SafeParcelable.Field(getter = "getMotion", id = 3)

    /* renamed from: c  reason: collision with root package name */
    private final int f20989c;
    @SafeParcelable.Field(getter = "getLight", id = 4)

    /* renamed from: d  reason: collision with root package name */
    private final int f20990d;
    @SafeParcelable.Field(getter = "getNoise", id = 5)

    /* renamed from: e  reason: collision with root package name */
    private final int f20991e;
    @SafeParcelable.Field(getter = "getLightDiff", id = 6)

    /* renamed from: f  reason: collision with root package name */
    private final int f20992f;
    @SafeParcelable.Field(getter = "getNightOrDay", id = 7)

    /* renamed from: g  reason: collision with root package name */
    private final int f20993g;
    @SafeParcelable.Field(getter = "getConfidenceOverwrittenByAlarmClockTrigger", id = 8)

    /* renamed from: h  reason: collision with root package name */
    private final boolean f20994h;
    @SafeParcelable.Field(getter = "getPresenceConfidence", id = 9)

    /* renamed from: i  reason: collision with root package name */
    private final int f20995i;

    @ShowFirstParty
    @SafeParcelable.Constructor
    public SleepClassifyEvent(@SafeParcelable.Param(id = 1) int i4, @SafeParcelable.Param(id = 2) int i5, @SafeParcelable.Param(id = 3) int i6, @SafeParcelable.Param(id = 4) int i7, @SafeParcelable.Param(id = 5) int i8, @SafeParcelable.Param(id = 6) int i9, @SafeParcelable.Param(id = 7) int i10, @SafeParcelable.Param(id = 8) boolean z3, @SafeParcelable.Param(id = 9) int i11) {
        this.f20987a = i4;
        this.f20988b = i5;
        this.f20989c = i6;
        this.f20990d = i7;
        this.f20991e = i8;
        this.f20992f = i9;
        this.f20993g = i10;
        this.f20994h = z3;
        this.f20995i = i11;
    }

    @NonNull
    public static List<SleepClassifyEvent> extractEvents(@NonNull Intent intent) {
        Preconditions.checkNotNull(intent);
        if (!hasEvents(intent)) {
            return Collections.emptyList();
        }
        ArrayList arrayList = (ArrayList) intent.getSerializableExtra("com.google.android.location.internal.EXTRA_SLEEP_CLASSIFY_RESULT");
        if (arrayList == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            byte[] bArr = (byte[]) arrayList.get(i4);
            Preconditions.checkNotNull(bArr);
            arrayList2.add((SleepClassifyEvent) SafeParcelableSerializer.deserializeFromBytes(bArr, CREATOR));
        }
        return Collections.unmodifiableList(arrayList2);
    }

    public static boolean hasEvents(@Nullable Intent intent) {
        if (intent == null) {
            return false;
        }
        return intent.hasExtra("com.google.android.location.internal.EXTRA_SLEEP_CLASSIFY_RESULT");
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SleepClassifyEvent)) {
            return false;
        }
        SleepClassifyEvent sleepClassifyEvent = (SleepClassifyEvent) obj;
        if (this.f20987a == sleepClassifyEvent.f20987a && this.f20988b == sleepClassifyEvent.f20988b) {
            return true;
        }
        return false;
    }

    public int getConfidence() {
        return this.f20988b;
    }

    public int getLight() {
        return this.f20990d;
    }

    public int getMotion() {
        return this.f20989c;
    }

    public long getTimestampMillis() {
        return this.f20987a * 1000;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.f20987a), Integer.valueOf(this.f20988b));
    }

    @NonNull
    public String toString() {
        int i4 = this.f20987a;
        int i5 = this.f20988b;
        int i6 = this.f20989c;
        int i7 = this.f20990d;
        return i4 + " Conf:" + i5 + " Motion:" + i6 + " Light:" + i7;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i4) {
        Preconditions.checkNotNull(parcel);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f20987a);
        SafeParcelWriter.writeInt(parcel, 2, getConfidence());
        SafeParcelWriter.writeInt(parcel, 3, getMotion());
        SafeParcelWriter.writeInt(parcel, 4, getLight());
        SafeParcelWriter.writeInt(parcel, 5, this.f20991e);
        SafeParcelWriter.writeInt(parcel, 6, this.f20992f);
        SafeParcelWriter.writeInt(parcel, 7, this.f20993g);
        SafeParcelWriter.writeBoolean(parcel, 8, this.f20994h);
        SafeParcelWriter.writeInt(parcel, 9, this.f20995i);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
