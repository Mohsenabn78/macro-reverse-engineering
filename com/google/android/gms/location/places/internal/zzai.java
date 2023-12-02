package com.google.android.gms.location.places.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.places.Place;
import java.util.Collections;
import java.util.List;

@SafeParcelable.Class(creator = "PlaceExtendedDetailsEntityCreator")
/* loaded from: classes4.dex */
public final class zzai extends AbstractSafeParcelable implements Place.ExtendedDetails {
    public static final Parcelable.Creator<zzai> CREATOR = new zzah();
    @SafeParcelable.Field(getter = "getPlaceTypes", id = 1)

    /* renamed from: a  reason: collision with root package name */
    private final List<Integer> f21090a;
    @SafeParcelable.Field(getter = "getPhoneNumber", id = 2)

    /* renamed from: b  reason: collision with root package name */
    private final String f21091b;
    @SafeParcelable.Field(getter = "getWebsiteUri", id = 3)

    /* renamed from: c  reason: collision with root package name */
    private final Uri f21092c;
    @SafeParcelable.Field(getter = "getRating", id = 4)

    /* renamed from: d  reason: collision with root package name */
    private final float f21093d;
    @SafeParcelable.Field(getter = "getPriceLevel", id = 5)

    /* renamed from: e  reason: collision with root package name */
    private final int f21094e;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzai(@SafeParcelable.Param(id = 1) List<Integer> list, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) Uri uri, @SafeParcelable.Param(id = 4) float f4, @SafeParcelable.Param(id = 5) int i4) {
        this.f21090a = Collections.unmodifiableList(list);
        this.f21091b = str;
        this.f21092c = uri;
        this.f21093d = f4;
        this.f21094e = i4;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeIntegerList(parcel, 1, this.f21090a, false);
        SafeParcelWriter.writeString(parcel, 2, this.f21091b, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.f21092c, i4, false);
        SafeParcelWriter.writeFloat(parcel, 4, this.f21093d);
        SafeParcelWriter.writeInt(parcel, 5, this.f21094e);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
