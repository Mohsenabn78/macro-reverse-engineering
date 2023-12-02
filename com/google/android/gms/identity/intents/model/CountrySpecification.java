package com.google.android.gms.identity.intents.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-identity@@17.0.1 */
@SafeParcelable.Class(creator = "CountrySpecificationCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes4.dex */
public class CountrySpecification extends AbstractSafeParcelable implements ReflectedParcelable {
    @NonNull
    public static final Parcelable.Creator<CountrySpecification> CREATOR = new zza();
    @SafeParcelable.Field(id = 2)

    /* renamed from: a  reason: collision with root package name */
    String f20849a;

    @SafeParcelable.Constructor
    public CountrySpecification(@NonNull @SafeParcelable.Param(id = 2) String str) {
        this.f20849a = str;
    }

    @NonNull
    public String getCountryCode() {
        return this.f20849a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.f20849a, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
