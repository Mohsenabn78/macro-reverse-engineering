package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.List;

@SafeParcelable.Class(creator = "ExceptionalHoursCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public final class zzan extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzan> CREATOR = new zzf();
    @SafeParcelable.Field(id = 1)

    /* renamed from: a  reason: collision with root package name */
    private final int f21099a;
    @SafeParcelable.Field(id = 2)

    /* renamed from: b  reason: collision with root package name */
    private final int f21100b;
    @SafeParcelable.Field(id = 3)

    /* renamed from: c  reason: collision with root package name */
    private final int f21101c;
    @SafeParcelable.Field(id = 4)

    /* renamed from: d  reason: collision with root package name */
    private final int f21102d;
    @SafeParcelable.Field(id = 5)

    /* renamed from: e  reason: collision with root package name */
    private final int f21103e;
    @SafeParcelable.Field(id = 6)

    /* renamed from: f  reason: collision with root package name */
    private final int f21104f;
    @SafeParcelable.Field(id = 7)

    /* renamed from: g  reason: collision with root package name */
    private final List<zzao> f21105g;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzan(@SafeParcelable.Param(id = 1) int i4, @SafeParcelable.Param(id = 2) int i5, @SafeParcelable.Param(id = 3) int i6, @SafeParcelable.Param(id = 4) int i7, @SafeParcelable.Param(id = 5) int i8, @SafeParcelable.Param(id = 6) int i9, @SafeParcelable.Param(id = 7) List<zzao> list) {
        this.f21099a = i4;
        this.f21100b = i5;
        this.f21101c = i6;
        this.f21102d = i7;
        this.f21103e = i8;
        this.f21104f = i9;
        this.f21105g = Collections.unmodifiableList(list);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f21099a);
        SafeParcelWriter.writeInt(parcel, 2, this.f21100b);
        SafeParcelWriter.writeInt(parcel, 3, this.f21101c);
        SafeParcelWriter.writeInt(parcel, 4, this.f21102d);
        SafeParcelWriter.writeInt(parcel, 5, this.f21103e);
        SafeParcelWriter.writeInt(parcel, 6, this.f21104f);
        SafeParcelWriter.writeTypedList(parcel, 7, this.f21105g, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
