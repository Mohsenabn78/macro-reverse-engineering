package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.PlaceLikelihood;

@SafeParcelable.Class(creator = "PlaceLikelihoodEntityCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public final class zzak extends AbstractSafeParcelable implements PlaceLikelihood {
    public static final Parcelable.Creator<zzak> CREATOR = new zzaj();
    @SafeParcelable.Field(id = 1)

    /* renamed from: a  reason: collision with root package name */
    private final PlaceEntity f21095a;
    @SafeParcelable.Field(id = 2)

    /* renamed from: b  reason: collision with root package name */
    private final float f21096b;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzak(@SafeParcelable.Param(id = 1) PlaceEntity placeEntity, @SafeParcelable.Param(id = 2) float f4) {
        this.f21095a = placeEntity;
        this.f21096b = f4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzak)) {
            return false;
        }
        zzak zzakVar = (zzak) obj;
        if (this.f21095a.equals(zzakVar.f21095a) && this.f21096b == zzakVar.f21096b) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.location.places.PlaceLikelihood
    public final float getLikelihood() {
        return this.f21096b;
    }

    @Override // com.google.android.gms.location.places.PlaceLikelihood
    public final Place getPlace() {
        return this.f21095a;
    }

    public final int hashCode() {
        return Objects.hashCode(this.f21095a, Float.valueOf(this.f21096b));
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return true;
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("place", this.f21095a).add("likelihood", Float.valueOf(this.f21096b)).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.f21095a, i4, false);
        SafeParcelWriter.writeFloat(parcel, 2, this.f21096b);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final /* bridge */ /* synthetic */ PlaceLikelihood freeze() {
        return this;
    }
}
