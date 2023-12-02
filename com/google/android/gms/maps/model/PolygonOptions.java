package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SafeParcelable.Class(creator = "PolygonOptionsCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes4.dex */
public final class PolygonOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<PolygonOptions> CREATOR = new zzk();
    @SafeParcelable.Field(getter = "getPoints", id = 2)

    /* renamed from: a  reason: collision with root package name */
    private final List<LatLng> f21343a;
    @SafeParcelable.Field(getter = "getHolesForParcel", id = 3, type = "java.util.List")

    /* renamed from: b  reason: collision with root package name */
    private final List<List<LatLng>> f21344b;
    @SafeParcelable.Field(getter = "getStrokeWidth", id = 4)

    /* renamed from: c  reason: collision with root package name */
    private float f21345c;
    @SafeParcelable.Field(getter = "getStrokeColor", id = 5)

    /* renamed from: d  reason: collision with root package name */
    private int f21346d;
    @SafeParcelable.Field(getter = "getFillColor", id = 6)

    /* renamed from: e  reason: collision with root package name */
    private int f21347e;
    @SafeParcelable.Field(getter = "getZIndex", id = 7)

    /* renamed from: f  reason: collision with root package name */
    private float f21348f;
    @SafeParcelable.Field(getter = "isVisible", id = 8)

    /* renamed from: g  reason: collision with root package name */
    private boolean f21349g;
    @SafeParcelable.Field(getter = "isGeodesic", id = 9)

    /* renamed from: h  reason: collision with root package name */
    private boolean f21350h;
    @SafeParcelable.Field(getter = "isClickable", id = 10)

    /* renamed from: i  reason: collision with root package name */
    private boolean f21351i;
    @SafeParcelable.Field(getter = "getStrokeJointType", id = 11)

    /* renamed from: j  reason: collision with root package name */
    private int f21352j;
    @Nullable
    @SafeParcelable.Field(getter = "getStrokePattern", id = 12)

    /* renamed from: k  reason: collision with root package name */
    private List<PatternItem> f21353k;

    public PolygonOptions() {
        this.f21345c = 10.0f;
        this.f21346d = -16777216;
        this.f21347e = 0;
        this.f21348f = 0.0f;
        this.f21349g = true;
        this.f21350h = false;
        this.f21351i = false;
        this.f21352j = 0;
        this.f21353k = null;
        this.f21343a = new ArrayList();
        this.f21344b = new ArrayList();
    }

    public final PolygonOptions add(LatLng latLng) {
        this.f21343a.add(latLng);
        return this;
    }

    public final PolygonOptions addAll(Iterable<LatLng> iterable) {
        for (LatLng latLng : iterable) {
            this.f21343a.add(latLng);
        }
        return this;
    }

    public final PolygonOptions addHole(Iterable<LatLng> iterable) {
        ArrayList arrayList = new ArrayList();
        for (LatLng latLng : iterable) {
            arrayList.add(latLng);
        }
        this.f21344b.add(arrayList);
        return this;
    }

    public final PolygonOptions clickable(boolean z3) {
        this.f21351i = z3;
        return this;
    }

    public final PolygonOptions fillColor(int i4) {
        this.f21347e = i4;
        return this;
    }

    public final PolygonOptions geodesic(boolean z3) {
        this.f21350h = z3;
        return this;
    }

    public final int getFillColor() {
        return this.f21347e;
    }

    public final List<List<LatLng>> getHoles() {
        return this.f21344b;
    }

    public final List<LatLng> getPoints() {
        return this.f21343a;
    }

    public final int getStrokeColor() {
        return this.f21346d;
    }

    public final int getStrokeJointType() {
        return this.f21352j;
    }

    @Nullable
    public final List<PatternItem> getStrokePattern() {
        return this.f21353k;
    }

    public final float getStrokeWidth() {
        return this.f21345c;
    }

    public final float getZIndex() {
        return this.f21348f;
    }

    public final boolean isClickable() {
        return this.f21351i;
    }

    public final boolean isGeodesic() {
        return this.f21350h;
    }

    public final boolean isVisible() {
        return this.f21349g;
    }

    public final PolygonOptions strokeColor(int i4) {
        this.f21346d = i4;
        return this;
    }

    public final PolygonOptions strokeJointType(int i4) {
        this.f21352j = i4;
        return this;
    }

    public final PolygonOptions strokePattern(@Nullable List<PatternItem> list) {
        this.f21353k = list;
        return this;
    }

    public final PolygonOptions strokeWidth(float f4) {
        this.f21345c = f4;
        return this;
    }

    public final PolygonOptions visible(boolean z3) {
        this.f21349g = z3;
        return this;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 2, getPoints(), false);
        SafeParcelWriter.writeList(parcel, 3, this.f21344b, false);
        SafeParcelWriter.writeFloat(parcel, 4, getStrokeWidth());
        SafeParcelWriter.writeInt(parcel, 5, getStrokeColor());
        SafeParcelWriter.writeInt(parcel, 6, getFillColor());
        SafeParcelWriter.writeFloat(parcel, 7, getZIndex());
        SafeParcelWriter.writeBoolean(parcel, 8, isVisible());
        SafeParcelWriter.writeBoolean(parcel, 9, isGeodesic());
        SafeParcelWriter.writeBoolean(parcel, 10, isClickable());
        SafeParcelWriter.writeInt(parcel, 11, getStrokeJointType());
        SafeParcelWriter.writeTypedList(parcel, 12, getStrokePattern(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final PolygonOptions zIndex(float f4) {
        this.f21348f = f4;
        return this;
    }

    public final PolygonOptions add(LatLng... latLngArr) {
        this.f21343a.addAll(Arrays.asList(latLngArr));
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public PolygonOptions(@SafeParcelable.Param(id = 2) List<LatLng> list, @SafeParcelable.Param(id = 3) List list2, @SafeParcelable.Param(id = 4) float f4, @SafeParcelable.Param(id = 5) int i4, @SafeParcelable.Param(id = 6) int i5, @SafeParcelable.Param(id = 7) float f5, @SafeParcelable.Param(id = 8) boolean z3, @SafeParcelable.Param(id = 9) boolean z4, @SafeParcelable.Param(id = 10) boolean z5, @SafeParcelable.Param(id = 11) int i6, @Nullable @SafeParcelable.Param(id = 12) List<PatternItem> list3) {
        this.f21343a = list;
        this.f21344b = list2;
        this.f21345c = f4;
        this.f21346d = i4;
        this.f21347e = i5;
        this.f21348f = f5;
        this.f21349g = z3;
        this.f21350h = z4;
        this.f21351i = z5;
        this.f21352j = i6;
        this.f21353k = list3;
    }
}
