package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.style.CharacterStyle;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.places.AutocompletePrediction;
import java.util.Collections;
import java.util.List;

@SafeParcelable.Class(creator = "AutocompletePredictionEntityCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public final class zzc extends AbstractSafeParcelable implements AutocompletePrediction {
    public static final Parcelable.Creator<zzc> CREATOR = new zze();

    /* renamed from: j  reason: collision with root package name */
    private static final List<zzb> f21125j = Collections.emptyList();
    @SafeParcelable.Field(id = 1)

    /* renamed from: a  reason: collision with root package name */
    private final String f21126a;
    @SafeParcelable.Field(id = 2)

    /* renamed from: b  reason: collision with root package name */
    private final String f21127b;
    @SafeParcelable.Field(id = 3)

    /* renamed from: c  reason: collision with root package name */
    private final List<Integer> f21128c;
    @SafeParcelable.Field(id = 4)

    /* renamed from: d  reason: collision with root package name */
    private final List<zzb> f21129d;
    @SafeParcelable.Field(id = 5)

    /* renamed from: e  reason: collision with root package name */
    private final int f21130e;
    @SafeParcelable.Field(id = 6)

    /* renamed from: f  reason: collision with root package name */
    private final String f21131f;
    @SafeParcelable.Field(id = 7)

    /* renamed from: g  reason: collision with root package name */
    private final List<zzb> f21132g;
    @SafeParcelable.Field(id = 8)

    /* renamed from: h  reason: collision with root package name */
    private final String f21133h;
    @SafeParcelable.Field(id = 9)

    /* renamed from: i  reason: collision with root package name */
    private final List<zzb> f21134i;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzc(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) List<Integer> list, @SafeParcelable.Param(id = 5) int i4, @SafeParcelable.Param(id = 1) String str2, @SafeParcelable.Param(id = 4) List<zzb> list2, @SafeParcelable.Param(id = 6) String str3, @SafeParcelable.Param(id = 7) List<zzb> list3, @SafeParcelable.Param(id = 8) String str4, @SafeParcelable.Param(id = 9) List<zzb> list4) {
        this.f21127b = str;
        this.f21128c = list;
        this.f21130e = i4;
        this.f21126a = str2;
        this.f21129d = list2;
        this.f21131f = str3;
        this.f21132g = list3;
        this.f21133h = str4;
        this.f21134i = list4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzc)) {
            return false;
        }
        zzc zzcVar = (zzc) obj;
        if (Objects.equal(this.f21127b, zzcVar.f21127b) && Objects.equal(this.f21128c, zzcVar.f21128c) && Objects.equal(Integer.valueOf(this.f21130e), Integer.valueOf(zzcVar.f21130e)) && Objects.equal(this.f21126a, zzcVar.f21126a) && Objects.equal(this.f21129d, zzcVar.f21129d) && Objects.equal(this.f21131f, zzcVar.f21131f) && Objects.equal(this.f21132g, zzcVar.f21132g) && Objects.equal(this.f21133h, zzcVar.f21133h) && Objects.equal(this.f21134i, zzcVar.f21134i)) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.location.places.AutocompletePrediction
    public final CharSequence getFullText(@Nullable CharacterStyle characterStyle) {
        return zzi.zzb(this.f21126a, this.f21129d, characterStyle);
    }

    @Override // com.google.android.gms.location.places.AutocompletePrediction
    @Nullable
    public final String getPlaceId() {
        return this.f21127b;
    }

    @Override // com.google.android.gms.location.places.AutocompletePrediction
    public final List<Integer> getPlaceTypes() {
        return this.f21128c;
    }

    @Override // com.google.android.gms.location.places.AutocompletePrediction
    public final CharSequence getPrimaryText(@Nullable CharacterStyle characterStyle) {
        return zzi.zzb(this.f21131f, this.f21132g, characterStyle);
    }

    @Override // com.google.android.gms.location.places.AutocompletePrediction
    public final CharSequence getSecondaryText(@Nullable CharacterStyle characterStyle) {
        return zzi.zzb(this.f21133h, this.f21134i, characterStyle);
    }

    public final int hashCode() {
        return Objects.hashCode(this.f21127b, this.f21128c, Integer.valueOf(this.f21130e), this.f21126a, this.f21129d, this.f21131f, this.f21132g, this.f21133h, this.f21134i);
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return true;
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("placeId", this.f21127b).add("placeTypes", this.f21128c).add("fullText", this.f21126a).add("fullTextMatchedSubstrings", this.f21129d).add("primaryText", this.f21131f).add("primaryTextMatchedSubstrings", this.f21132g).add("secondaryText", this.f21133h).add("secondaryTextMatchedSubstrings", this.f21134i).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.f21126a, false);
        SafeParcelWriter.writeString(parcel, 2, this.f21127b, false);
        SafeParcelWriter.writeIntegerList(parcel, 3, this.f21128c, false);
        SafeParcelWriter.writeTypedList(parcel, 4, this.f21129d, false);
        SafeParcelWriter.writeInt(parcel, 5, this.f21130e);
        SafeParcelWriter.writeString(parcel, 6, this.f21131f, false);
        SafeParcelWriter.writeTypedList(parcel, 7, this.f21132g, false);
        SafeParcelWriter.writeString(parcel, 8, this.f21133h, false);
        SafeParcelWriter.writeTypedList(parcel, 9, this.f21134i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final /* bridge */ /* synthetic */ AutocompletePrediction freeze() {
        return this;
    }
}
