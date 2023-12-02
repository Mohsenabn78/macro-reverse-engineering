package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "PlacePhotoMetadataResultCreator")
@SafeParcelable.Reserved({1000})
@Deprecated
/* loaded from: classes4.dex */
public class PlacePhotoMetadataResult extends AbstractSafeParcelable implements Result {
    public static final Parcelable.Creator<PlacePhotoMetadataResult> CREATOR = new zzk();
    @SafeParcelable.Field(getter = "getStatus", id = 1)

    /* renamed from: a  reason: collision with root package name */
    private final Status f21036a;
    @SafeParcelable.Field(id = 2)

    /* renamed from: b  reason: collision with root package name */
    private final DataHolder f21037b;

    /* renamed from: c  reason: collision with root package name */
    private final PlacePhotoMetadataBuffer f21038c;

    @SafeParcelable.Constructor
    public PlacePhotoMetadataResult(@SafeParcelable.Param(id = 1) Status status, @SafeParcelable.Param(id = 2) DataHolder dataHolder) {
        this.f21036a = status;
        this.f21037b = dataHolder;
        if (dataHolder == null) {
            this.f21038c = null;
        } else {
            this.f21038c = new PlacePhotoMetadataBuffer(dataHolder);
        }
    }

    public PlacePhotoMetadataBuffer getPhotoMetadata() {
        return this.f21038c;
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.f21036a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getStatus(), i4, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.f21037b, i4, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
