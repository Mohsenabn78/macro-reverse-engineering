package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.List;

@SafeParcelable.Class(creator = "CircleOptionsCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes4.dex */
public final class CircleOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<CircleOptions> CREATOR = new zzc();
    @SafeParcelable.Field(getter = "getCenter", id = 2)

    /* renamed from: a  reason: collision with root package name */
    private LatLng f21293a;
    @SafeParcelable.Field(getter = "getRadius", id = 3)

    /* renamed from: b  reason: collision with root package name */
    private double f21294b;
    @SafeParcelable.Field(getter = "getStrokeWidth", id = 4)

    /* renamed from: c  reason: collision with root package name */
    private float f21295c;
    @SafeParcelable.Field(getter = "getStrokeColor", id = 5)

    /* renamed from: d  reason: collision with root package name */
    private int f21296d;
    @SafeParcelable.Field(getter = "getFillColor", id = 6)

    /* renamed from: e  reason: collision with root package name */
    private int f21297e;
    @SafeParcelable.Field(getter = "getZIndex", id = 7)

    /* renamed from: f  reason: collision with root package name */
    private float f21298f;
    @SafeParcelable.Field(getter = "isVisible", id = 8)

    /* renamed from: g  reason: collision with root package name */
    private boolean f21299g;
    @SafeParcelable.Field(getter = "isClickable", id = 9)

    /* renamed from: h  reason: collision with root package name */
    private boolean f21300h;
    @Nullable
    @SafeParcelable.Field(getter = "getStrokePattern", id = 10)

    /* renamed from: i  reason: collision with root package name */
    private List<PatternItem> f21301i;

    public CircleOptions() {
        this.f21293a = null;
        this.f21294b = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        this.f21295c = 10.0f;
        this.f21296d = -16777216;
        this.f21297e = 0;
        this.f21298f = 0.0f;
        this.f21299g = true;
        this.f21300h = false;
        this.f21301i = null;
    }

    public final CircleOptions center(LatLng latLng) {
        this.f21293a = latLng;
        return this;
    }

    public final CircleOptions clickable(boolean z3) {
        this.f21300h = z3;
        return this;
    }

    public final CircleOptions fillColor(int i4) {
        this.f21297e = i4;
        return this;
    }

    public final LatLng getCenter() {
        return this.f21293a;
    }

    public final int getFillColor() {
        return this.f21297e;
    }

    public final double getRadius() {
        return this.f21294b;
    }

    public final int getStrokeColor() {
        return this.f21296d;
    }

    @Nullable
    public final List<PatternItem> getStrokePattern() {
        return this.f21301i;
    }

    public final float getStrokeWidth() {
        return this.f21295c;
    }

    public final float getZIndex() {
        return this.f21298f;
    }

    public final boolean isClickable() {
        return this.f21300h;
    }

    public final boolean isVisible() {
        return this.f21299g;
    }

    public final CircleOptions radius(double d4) {
        this.f21294b = d4;
        return this;
    }

    public final CircleOptions strokeColor(int i4) {
        this.f21296d = i4;
        return this;
    }

    public final CircleOptions strokePattern(@Nullable List<PatternItem> list) {
        this.f21301i = list;
        return this;
    }

    public final CircleOptions strokeWidth(float f4) {
        this.f21295c = f4;
        return this;
    }

    public final CircleOptions visible(boolean z3) {
        this.f21299g = z3;
        return this;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, getCenter(), i4, false);
        SafeParcelWriter.writeDouble(parcel, 3, getRadius());
        SafeParcelWriter.writeFloat(parcel, 4, getStrokeWidth());
        SafeParcelWriter.writeInt(parcel, 5, getStrokeColor());
        SafeParcelWriter.writeInt(parcel, 6, getFillColor());
        SafeParcelWriter.writeFloat(parcel, 7, getZIndex());
        SafeParcelWriter.writeBoolean(parcel, 8, isVisible());
        SafeParcelWriter.writeBoolean(parcel, 9, isClickable());
        SafeParcelWriter.writeTypedList(parcel, 10, getStrokePattern(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final CircleOptions zIndex(float f4) {
        this.f21298f = f4;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public CircleOptions(@SafeParcelable.Param(id = 2) LatLng latLng, @SafeParcelable.Param(id = 3) double d4, @SafeParcelable.Param(id = 4) float f4, @SafeParcelable.Param(id = 5) int i4, @SafeParcelable.Param(id = 6) int i5, @SafeParcelable.Param(id = 7) float f5, @SafeParcelable.Param(id = 8) boolean z3, @SafeParcelable.Param(id = 9) boolean z4, @Nullable @SafeParcelable.Param(id = 10) List<PatternItem> list) {
        this.f21293a = latLng;
        this.f21294b = d4;
        this.f21295c = f4;
        this.f21296d = i4;
        this.f21297e = i5;
        this.f21298f = f5;
        this.f21299g = z3;
        this.f21300h = z4;
        this.f21301i = list;
    }
}
