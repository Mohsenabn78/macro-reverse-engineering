package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SafeParcelable.Class(creator = "PolylineOptionsCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes4.dex */
public final class PolylineOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<PolylineOptions> CREATOR = new zzl();
    @SafeParcelable.Field(getter = "getPoints", id = 2)

    /* renamed from: a  reason: collision with root package name */
    private final List<LatLng> f21355a;
    @SafeParcelable.Field(getter = "getWidth", id = 3)

    /* renamed from: b  reason: collision with root package name */
    private float f21356b;
    @SafeParcelable.Field(getter = "getColor", id = 4)

    /* renamed from: c  reason: collision with root package name */
    private int f21357c;
    @SafeParcelable.Field(getter = "getZIndex", id = 5)

    /* renamed from: d  reason: collision with root package name */
    private float f21358d;
    @SafeParcelable.Field(getter = "isVisible", id = 6)

    /* renamed from: e  reason: collision with root package name */
    private boolean f21359e;
    @SafeParcelable.Field(getter = "isGeodesic", id = 7)

    /* renamed from: f  reason: collision with root package name */
    private boolean f21360f;
    @SafeParcelable.Field(getter = "isClickable", id = 8)

    /* renamed from: g  reason: collision with root package name */
    private boolean f21361g;
    @NonNull
    @SafeParcelable.Field(getter = "getStartCap", id = 9)

    /* renamed from: h  reason: collision with root package name */
    private Cap f21362h;
    @NonNull
    @SafeParcelable.Field(getter = "getEndCap", id = 10)

    /* renamed from: i  reason: collision with root package name */
    private Cap f21363i;
    @SafeParcelable.Field(getter = "getJointType", id = 11)

    /* renamed from: j  reason: collision with root package name */
    private int f21364j;
    @Nullable
    @SafeParcelable.Field(getter = "getPattern", id = 12)

    /* renamed from: k  reason: collision with root package name */
    private List<PatternItem> f21365k;

    public PolylineOptions() {
        this.f21356b = 10.0f;
        this.f21357c = -16777216;
        this.f21358d = 0.0f;
        this.f21359e = true;
        this.f21360f = false;
        this.f21361g = false;
        this.f21362h = new ButtCap();
        this.f21363i = new ButtCap();
        this.f21364j = 0;
        this.f21365k = null;
        this.f21355a = new ArrayList();
    }

    public final PolylineOptions add(LatLng latLng) {
        this.f21355a.add(latLng);
        return this;
    }

    public final PolylineOptions addAll(Iterable<LatLng> iterable) {
        for (LatLng latLng : iterable) {
            this.f21355a.add(latLng);
        }
        return this;
    }

    public final PolylineOptions clickable(boolean z3) {
        this.f21361g = z3;
        return this;
    }

    public final PolylineOptions color(int i4) {
        this.f21357c = i4;
        return this;
    }

    public final PolylineOptions endCap(@NonNull Cap cap) {
        this.f21363i = (Cap) Preconditions.checkNotNull(cap, "endCap must not be null");
        return this;
    }

    public final PolylineOptions geodesic(boolean z3) {
        this.f21360f = z3;
        return this;
    }

    public final int getColor() {
        return this.f21357c;
    }

    @NonNull
    public final Cap getEndCap() {
        return this.f21363i;
    }

    public final int getJointType() {
        return this.f21364j;
    }

    @Nullable
    public final List<PatternItem> getPattern() {
        return this.f21365k;
    }

    public final List<LatLng> getPoints() {
        return this.f21355a;
    }

    @NonNull
    public final Cap getStartCap() {
        return this.f21362h;
    }

    public final float getWidth() {
        return this.f21356b;
    }

    public final float getZIndex() {
        return this.f21358d;
    }

    public final boolean isClickable() {
        return this.f21361g;
    }

    public final boolean isGeodesic() {
        return this.f21360f;
    }

    public final boolean isVisible() {
        return this.f21359e;
    }

    public final PolylineOptions jointType(int i4) {
        this.f21364j = i4;
        return this;
    }

    public final PolylineOptions pattern(@Nullable List<PatternItem> list) {
        this.f21365k = list;
        return this;
    }

    public final PolylineOptions startCap(@NonNull Cap cap) {
        this.f21362h = (Cap) Preconditions.checkNotNull(cap, "startCap must not be null");
        return this;
    }

    public final PolylineOptions visible(boolean z3) {
        this.f21359e = z3;
        return this;
    }

    public final PolylineOptions width(float f4) {
        this.f21356b = f4;
        return this;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 2, getPoints(), false);
        SafeParcelWriter.writeFloat(parcel, 3, getWidth());
        SafeParcelWriter.writeInt(parcel, 4, getColor());
        SafeParcelWriter.writeFloat(parcel, 5, getZIndex());
        SafeParcelWriter.writeBoolean(parcel, 6, isVisible());
        SafeParcelWriter.writeBoolean(parcel, 7, isGeodesic());
        SafeParcelWriter.writeBoolean(parcel, 8, isClickable());
        SafeParcelWriter.writeParcelable(parcel, 9, getStartCap(), i4, false);
        SafeParcelWriter.writeParcelable(parcel, 10, getEndCap(), i4, false);
        SafeParcelWriter.writeInt(parcel, 11, getJointType());
        SafeParcelWriter.writeTypedList(parcel, 12, getPattern(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final PolylineOptions zIndex(float f4) {
        this.f21358d = f4;
        return this;
    }

    public final PolylineOptions add(LatLng... latLngArr) {
        this.f21355a.addAll(Arrays.asList(latLngArr));
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public PolylineOptions(@SafeParcelable.Param(id = 2) List list, @SafeParcelable.Param(id = 3) float f4, @SafeParcelable.Param(id = 4) int i4, @SafeParcelable.Param(id = 5) float f5, @SafeParcelable.Param(id = 6) boolean z3, @SafeParcelable.Param(id = 7) boolean z4, @SafeParcelable.Param(id = 8) boolean z5, @Nullable @SafeParcelable.Param(id = 9) Cap cap, @Nullable @SafeParcelable.Param(id = 10) Cap cap2, @SafeParcelable.Param(id = 11) int i5, @Nullable @SafeParcelable.Param(id = 12) List<PatternItem> list2) {
        this.f21356b = 10.0f;
        this.f21357c = -16777216;
        this.f21358d = 0.0f;
        this.f21359e = true;
        this.f21360f = false;
        this.f21361g = false;
        this.f21362h = new ButtCap();
        this.f21363i = new ButtCap();
        this.f21364j = 0;
        this.f21365k = null;
        this.f21355a = list;
        this.f21356b = f4;
        this.f21357c = i4;
        this.f21358d = f5;
        this.f21359e = z3;
        this.f21360f = z4;
        this.f21361g = z5;
        if (cap != null) {
            this.f21362h = cap;
        }
        if (cap2 != null) {
            this.f21363i = cap2;
        }
        this.f21364j = i5;
        this.f21365k = list2;
    }
}
