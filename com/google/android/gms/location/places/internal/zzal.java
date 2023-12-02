package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.List;

@SafeParcelable.Class(creator = "PlaceOpeningHoursEntityCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public final class zzal extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzal> CREATOR = new zzaq();
    @SafeParcelable.Field(id = 1)

    /* renamed from: a  reason: collision with root package name */
    private final List<zzao> f21097a;
    @SafeParcelable.Field(id = 2)

    /* renamed from: b  reason: collision with root package name */
    private final List<zzan> f21098b;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzal(@SafeParcelable.Param(id = 1) List<zzao> list, @SafeParcelable.Param(id = 2) List<zzan> list2) {
        this.f21097a = Collections.unmodifiableList(list);
        this.f21098b = Collections.unmodifiableList(list2);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, this.f21097a, false);
        SafeParcelWriter.writeTypedList(parcel, 2, this.f21098b, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
