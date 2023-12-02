package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.IObjectWrapper;

@SafeParcelable.Class(creator = "MarkerOptionsCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes4.dex */
public final class MarkerOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<MarkerOptions> CREATOR = new zzh();
    @SafeParcelable.Field(getter = "getPosition", id = 2)

    /* renamed from: a  reason: collision with root package name */
    private LatLng f21325a;
    @SafeParcelable.Field(getter = "getTitle", id = 3)

    /* renamed from: b  reason: collision with root package name */
    private String f21326b;
    @SafeParcelable.Field(getter = "getSnippet", id = 4)

    /* renamed from: c  reason: collision with root package name */
    private String f21327c;
    @SafeParcelable.Field(getter = "getWrappedIconDescriptorImplBinder", id = 5, type = "android.os.IBinder")

    /* renamed from: d  reason: collision with root package name */
    private BitmapDescriptor f21328d;
    @SafeParcelable.Field(getter = "getAnchorU", id = 6)

    /* renamed from: e  reason: collision with root package name */
    private float f21329e;
    @SafeParcelable.Field(getter = "getAnchorV", id = 7)

    /* renamed from: f  reason: collision with root package name */
    private float f21330f;
    @SafeParcelable.Field(getter = "isDraggable", id = 8)

    /* renamed from: g  reason: collision with root package name */
    private boolean f21331g;
    @SafeParcelable.Field(getter = "isVisible", id = 9)

    /* renamed from: h  reason: collision with root package name */
    private boolean f21332h;
    @SafeParcelable.Field(getter = "isFlat", id = 10)

    /* renamed from: i  reason: collision with root package name */
    private boolean f21333i;
    @SafeParcelable.Field(getter = "getRotation", id = 11)

    /* renamed from: j  reason: collision with root package name */
    private float f21334j;
    @SafeParcelable.Field(defaultValue = "0.5f", getter = "getInfoWindowAnchorU", id = 12)

    /* renamed from: k  reason: collision with root package name */
    private float f21335k;
    @SafeParcelable.Field(getter = "getInfoWindowAnchorV", id = 13)

    /* renamed from: l  reason: collision with root package name */
    private float f21336l;
    @SafeParcelable.Field(defaultValue = "1.0f", getter = "getAlpha", id = 14)

    /* renamed from: m  reason: collision with root package name */
    private float f21337m;
    @SafeParcelable.Field(getter = "getZIndex", id = 15)

    /* renamed from: n  reason: collision with root package name */
    private float f21338n;

    public MarkerOptions() {
        this.f21329e = 0.5f;
        this.f21330f = 1.0f;
        this.f21332h = true;
        this.f21333i = false;
        this.f21334j = 0.0f;
        this.f21335k = 0.5f;
        this.f21336l = 0.0f;
        this.f21337m = 1.0f;
    }

    public final MarkerOptions alpha(float f4) {
        this.f21337m = f4;
        return this;
    }

    public final MarkerOptions anchor(float f4, float f5) {
        this.f21329e = f4;
        this.f21330f = f5;
        return this;
    }

    public final MarkerOptions draggable(boolean z3) {
        this.f21331g = z3;
        return this;
    }

    public final MarkerOptions flat(boolean z3) {
        this.f21333i = z3;
        return this;
    }

    public final float getAlpha() {
        return this.f21337m;
    }

    public final float getAnchorU() {
        return this.f21329e;
    }

    public final float getAnchorV() {
        return this.f21330f;
    }

    public final BitmapDescriptor getIcon() {
        return this.f21328d;
    }

    public final float getInfoWindowAnchorU() {
        return this.f21335k;
    }

    public final float getInfoWindowAnchorV() {
        return this.f21336l;
    }

    public final LatLng getPosition() {
        return this.f21325a;
    }

    public final float getRotation() {
        return this.f21334j;
    }

    public final String getSnippet() {
        return this.f21327c;
    }

    public final String getTitle() {
        return this.f21326b;
    }

    public final float getZIndex() {
        return this.f21338n;
    }

    public final MarkerOptions icon(@Nullable BitmapDescriptor bitmapDescriptor) {
        this.f21328d = bitmapDescriptor;
        return this;
    }

    public final MarkerOptions infoWindowAnchor(float f4, float f5) {
        this.f21335k = f4;
        this.f21336l = f5;
        return this;
    }

    public final boolean isDraggable() {
        return this.f21331g;
    }

    public final boolean isFlat() {
        return this.f21333i;
    }

    public final boolean isVisible() {
        return this.f21332h;
    }

    public final MarkerOptions position(@NonNull LatLng latLng) {
        if (latLng != null) {
            this.f21325a = latLng;
            return this;
        }
        throw new IllegalArgumentException("latlng cannot be null - a position is required.");
    }

    public final MarkerOptions rotation(float f4) {
        this.f21334j = f4;
        return this;
    }

    public final MarkerOptions snippet(@Nullable String str) {
        this.f21327c = str;
        return this;
    }

    public final MarkerOptions title(@Nullable String str) {
        this.f21326b = str;
        return this;
    }

    public final MarkerOptions visible(boolean z3) {
        this.f21332h = z3;
        return this;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        IBinder asBinder;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, getPosition(), i4, false);
        SafeParcelWriter.writeString(parcel, 3, getTitle(), false);
        SafeParcelWriter.writeString(parcel, 4, getSnippet(), false);
        BitmapDescriptor bitmapDescriptor = this.f21328d;
        if (bitmapDescriptor == null) {
            asBinder = null;
        } else {
            asBinder = bitmapDescriptor.zzb().asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 5, asBinder, false);
        SafeParcelWriter.writeFloat(parcel, 6, getAnchorU());
        SafeParcelWriter.writeFloat(parcel, 7, getAnchorV());
        SafeParcelWriter.writeBoolean(parcel, 8, isDraggable());
        SafeParcelWriter.writeBoolean(parcel, 9, isVisible());
        SafeParcelWriter.writeBoolean(parcel, 10, isFlat());
        SafeParcelWriter.writeFloat(parcel, 11, getRotation());
        SafeParcelWriter.writeFloat(parcel, 12, getInfoWindowAnchorU());
        SafeParcelWriter.writeFloat(parcel, 13, getInfoWindowAnchorV());
        SafeParcelWriter.writeFloat(parcel, 14, getAlpha());
        SafeParcelWriter.writeFloat(parcel, 15, getZIndex());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final MarkerOptions zIndex(float f4) {
        this.f21338n = f4;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public MarkerOptions(@SafeParcelable.Param(id = 2) LatLng latLng, @SafeParcelable.Param(id = 3) String str, @SafeParcelable.Param(id = 4) String str2, @SafeParcelable.Param(id = 5) IBinder iBinder, @SafeParcelable.Param(id = 6) float f4, @SafeParcelable.Param(id = 7) float f5, @SafeParcelable.Param(id = 8) boolean z3, @SafeParcelable.Param(id = 9) boolean z4, @SafeParcelable.Param(id = 10) boolean z5, @SafeParcelable.Param(id = 11) float f6, @SafeParcelable.Param(id = 12) float f7, @SafeParcelable.Param(id = 13) float f8, @SafeParcelable.Param(id = 14) float f9, @SafeParcelable.Param(id = 15) float f10) {
        this.f21329e = 0.5f;
        this.f21330f = 1.0f;
        this.f21332h = true;
        this.f21333i = false;
        this.f21334j = 0.0f;
        this.f21335k = 0.5f;
        this.f21336l = 0.0f;
        this.f21337m = 1.0f;
        this.f21325a = latLng;
        this.f21326b = str;
        this.f21327c = str2;
        if (iBinder == null) {
            this.f21328d = null;
        } else {
            this.f21328d = new BitmapDescriptor(IObjectWrapper.Stub.asInterface(iBinder));
        }
        this.f21329e = f4;
        this.f21330f = f5;
        this.f21331g = z3;
        this.f21332h = z4;
        this.f21333i = z5;
        this.f21334j = f6;
        this.f21335k = f7;
        this.f21336l = f8;
        this.f21337m = f9;
        this.f21338n = f10;
    }
}
