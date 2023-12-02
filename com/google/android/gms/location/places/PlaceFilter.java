package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@SafeParcelable.Class(creator = "PlaceFilterCreator")
@SafeParcelable.Reserved({1000, 2, 5})
@Deprecated
/* loaded from: classes4.dex */
public final class PlaceFilter extends com.google.android.gms.location.places.zzb {
    public static final Parcelable.Creator<PlaceFilter> CREATOR = new zzi();

    /* renamed from: h  reason: collision with root package name */
    private static final PlaceFilter f21019h = new PlaceFilter();
    @Nullable
    @SafeParcelable.Field(id = 1)

    /* renamed from: a  reason: collision with root package name */
    private final List<Integer> f21020a;
    @SafeParcelable.Field(id = 3)

    /* renamed from: b  reason: collision with root package name */
    private final boolean f21021b;
    @Nullable
    @SafeParcelable.Field(id = 4)

    /* renamed from: c  reason: collision with root package name */
    private final List<zzp> f21022c;
    @Nullable
    @SafeParcelable.Field(id = 6)

    /* renamed from: d  reason: collision with root package name */
    private final List<String> f21023d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private final Set<Integer> f21024e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private final Set<zzp> f21025f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private final Set<String> f21026g;

    @ShowFirstParty
    @Deprecated
    /* loaded from: classes4.dex */
    public static final class zzb {

        /* renamed from: a  reason: collision with root package name */
        private Collection<Integer> f21027a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f21028b;

        /* renamed from: c  reason: collision with root package name */
        private Collection<zzp> f21029c;

        /* renamed from: d  reason: collision with root package name */
        private String[] f21030d;

        private zzb() {
            this.f21027a = null;
            this.f21028b = false;
            this.f21029c = null;
            this.f21030d = null;
        }
    }

    public PlaceFilter() {
        this(false, null);
    }

    @ShowFirstParty
    @Deprecated
    public static PlaceFilter zzc() {
        new zzb();
        return new PlaceFilter((List<Integer>) null, false, (List<String>) null, (List<zzp>) null);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlaceFilter)) {
            return false;
        }
        PlaceFilter placeFilter = (PlaceFilter) obj;
        if (this.f21024e.equals(placeFilter.f21024e) && this.f21021b == placeFilter.f21021b && this.f21025f.equals(placeFilter.f21025f) && this.f21026g.equals(placeFilter.f21026g)) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.location.places.zzb
    public final Set<String> getPlaceIds() {
        return this.f21026g;
    }

    public final int hashCode() {
        return Objects.hashCode(this.f21024e, Boolean.valueOf(this.f21021b), this.f21025f, this.f21026g);
    }

    @Override // com.google.android.gms.location.places.zzb
    public final boolean isRestrictedToPlacesOpenNow() {
        return this.f21021b;
    }

    public final String toString() {
        Objects.ToStringHelper stringHelper = Objects.toStringHelper(this);
        if (!this.f21024e.isEmpty()) {
            stringHelper.add("types", this.f21024e);
        }
        stringHelper.add("requireOpenNow", Boolean.valueOf(this.f21021b));
        if (!this.f21026g.isEmpty()) {
            stringHelper.add("placeIds", this.f21026g);
        }
        if (!this.f21025f.isEmpty()) {
            stringHelper.add("requestedUserDataTypes", this.f21025f);
        }
        return stringHelper.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeIntegerList(parcel, 1, this.f21020a, false);
        SafeParcelWriter.writeBoolean(parcel, 3, this.f21021b);
        SafeParcelWriter.writeTypedList(parcel, 4, this.f21022c, false);
        SafeParcelWriter.writeStringList(parcel, 6, this.f21023d, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public PlaceFilter(boolean z3, @Nullable Collection<String> collection) {
        this((Collection<Integer>) null, z3, collection, (Collection<zzp>) null);
    }

    @ShowFirstParty
    private PlaceFilter(@Nullable Collection<Integer> collection, boolean z3, @Nullable Collection<String> collection2, @Nullable Collection<zzp> collection3) {
        this((List<Integer>) com.google.android.gms.location.places.zzb.b(null), z3, (List<String>) com.google.android.gms.location.places.zzb.b(collection2), (List<zzp>) com.google.android.gms.location.places.zzb.b(null));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public PlaceFilter(@Nullable @SafeParcelable.Param(id = 1) List<Integer> list, @SafeParcelable.Param(id = 3) boolean z3, @Nullable @SafeParcelable.Param(id = 6) List<String> list2, @Nullable @SafeParcelable.Param(id = 4) List<zzp> list3) {
        this.f21020a = list;
        this.f21021b = z3;
        this.f21022c = list3;
        this.f21023d = list2;
        this.f21024e = com.google.android.gms.location.places.zzb.c(list);
        this.f21025f = com.google.android.gms.location.places.zzb.c(list3);
        this.f21026g = com.google.android.gms.location.places.zzb.c(list2);
    }
}
