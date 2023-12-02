package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.IObjectWrapper;

@SafeParcelable.Class(creator = "GroundOverlayOptionsCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes4.dex */
public final class GroundOverlayOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GroundOverlayOptions> CREATOR = new zzd();
    public static final float NO_DIMENSION = -1.0f;
    @NonNull
    @SafeParcelable.Field(getter = "getWrappedImageDescriptorImplBinder", id = 2, type = "android.os.IBinder")

    /* renamed from: a  reason: collision with root package name */
    private BitmapDescriptor f21303a;
    @SafeParcelable.Field(getter = "getLocation", id = 3)

    /* renamed from: b  reason: collision with root package name */
    private LatLng f21304b;
    @SafeParcelable.Field(getter = "getWidth", id = 4)

    /* renamed from: c  reason: collision with root package name */
    private float f21305c;
    @SafeParcelable.Field(getter = "getHeight", id = 5)

    /* renamed from: d  reason: collision with root package name */
    private float f21306d;
    @SafeParcelable.Field(getter = "getBounds", id = 6)

    /* renamed from: e  reason: collision with root package name */
    private LatLngBounds f21307e;
    @SafeParcelable.Field(getter = "getBearing", id = 7)

    /* renamed from: f  reason: collision with root package name */
    private float f21308f;
    @SafeParcelable.Field(getter = "getZIndex", id = 8)

    /* renamed from: g  reason: collision with root package name */
    private float f21309g;
    @SafeParcelable.Field(getter = "isVisible", id = 9)

    /* renamed from: h  reason: collision with root package name */
    private boolean f21310h;
    @SafeParcelable.Field(getter = "getTransparency", id = 10)

    /* renamed from: i  reason: collision with root package name */
    private float f21311i;
    @SafeParcelable.Field(getter = "getAnchorU", id = 11)

    /* renamed from: j  reason: collision with root package name */
    private float f21312j;
    @SafeParcelable.Field(getter = "getAnchorV", id = 12)

    /* renamed from: k  reason: collision with root package name */
    private float f21313k;
    @SafeParcelable.Field(getter = "isClickable", id = 13)

    /* renamed from: l  reason: collision with root package name */
    private boolean f21314l;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public GroundOverlayOptions(@SafeParcelable.Param(id = 2) IBinder iBinder, @SafeParcelable.Param(id = 3) LatLng latLng, @SafeParcelable.Param(id = 4) float f4, @SafeParcelable.Param(id = 5) float f5, @SafeParcelable.Param(id = 6) LatLngBounds latLngBounds, @SafeParcelable.Param(id = 7) float f6, @SafeParcelable.Param(id = 8) float f7, @SafeParcelable.Param(id = 9) boolean z3, @SafeParcelable.Param(id = 10) float f8, @SafeParcelable.Param(id = 11) float f9, @SafeParcelable.Param(id = 12) float f10, @SafeParcelable.Param(id = 13) boolean z4) {
        this.f21310h = true;
        this.f21311i = 0.0f;
        this.f21312j = 0.5f;
        this.f21313k = 0.5f;
        this.f21314l = false;
        this.f21303a = new BitmapDescriptor(IObjectWrapper.Stub.asInterface(iBinder));
        this.f21304b = latLng;
        this.f21305c = f4;
        this.f21306d = f5;
        this.f21307e = latLngBounds;
        this.f21308f = f6;
        this.f21309g = f7;
        this.f21310h = z3;
        this.f21311i = f8;
        this.f21312j = f9;
        this.f21313k = f10;
        this.f21314l = z4;
    }

    private final GroundOverlayOptions b(LatLng latLng, float f4, float f5) {
        this.f21304b = latLng;
        this.f21305c = f4;
        this.f21306d = f5;
        return this;
    }

    public final GroundOverlayOptions anchor(float f4, float f5) {
        this.f21312j = f4;
        this.f21313k = f5;
        return this;
    }

    public final GroundOverlayOptions bearing(float f4) {
        this.f21308f = ((f4 % 360.0f) + 360.0f) % 360.0f;
        return this;
    }

    public final GroundOverlayOptions clickable(boolean z3) {
        this.f21314l = z3;
        return this;
    }

    public final float getAnchorU() {
        return this.f21312j;
    }

    public final float getAnchorV() {
        return this.f21313k;
    }

    public final float getBearing() {
        return this.f21308f;
    }

    public final LatLngBounds getBounds() {
        return this.f21307e;
    }

    public final float getHeight() {
        return this.f21306d;
    }

    public final BitmapDescriptor getImage() {
        return this.f21303a;
    }

    public final LatLng getLocation() {
        return this.f21304b;
    }

    public final float getTransparency() {
        return this.f21311i;
    }

    public final float getWidth() {
        return this.f21305c;
    }

    public final float getZIndex() {
        return this.f21309g;
    }

    public final GroundOverlayOptions image(@NonNull BitmapDescriptor bitmapDescriptor) {
        Preconditions.checkNotNull(bitmapDescriptor, "imageDescriptor must not be null");
        this.f21303a = bitmapDescriptor;
        return this;
    }

    public final boolean isClickable() {
        return this.f21314l;
    }

    public final boolean isVisible() {
        return this.f21310h;
    }

    public final GroundOverlayOptions position(LatLng latLng, float f4) {
        Preconditions.checkState(this.f21307e == null, "Position has already been set using positionFromBounds");
        Preconditions.checkArgument(latLng != null, "Location must be specified");
        Preconditions.checkArgument(f4 >= 0.0f, "Width must be non-negative");
        return b(latLng, f4, -1.0f);
    }

    public final GroundOverlayOptions positionFromBounds(LatLngBounds latLngBounds) {
        boolean z3;
        LatLng latLng = this.f21304b;
        if (latLng == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        String valueOf = String.valueOf(latLng);
        StringBuilder sb = new StringBuilder(valueOf.length() + 46);
        sb.append("Position has already been set using position: ");
        sb.append(valueOf);
        Preconditions.checkState(z3, sb.toString());
        this.f21307e = latLngBounds;
        return this;
    }

    public final GroundOverlayOptions transparency(float f4) {
        boolean z3;
        if (f4 >= 0.0f && f4 <= 1.0f) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "Transparency must be in the range [0..1]");
        this.f21311i = f4;
        return this;
    }

    public final GroundOverlayOptions visible(boolean z3) {
        this.f21310h = z3;
        return this;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeIBinder(parcel, 2, this.f21303a.zzb().asBinder(), false);
        SafeParcelWriter.writeParcelable(parcel, 3, getLocation(), i4, false);
        SafeParcelWriter.writeFloat(parcel, 4, getWidth());
        SafeParcelWriter.writeFloat(parcel, 5, getHeight());
        SafeParcelWriter.writeParcelable(parcel, 6, getBounds(), i4, false);
        SafeParcelWriter.writeFloat(parcel, 7, getBearing());
        SafeParcelWriter.writeFloat(parcel, 8, getZIndex());
        SafeParcelWriter.writeBoolean(parcel, 9, isVisible());
        SafeParcelWriter.writeFloat(parcel, 10, getTransparency());
        SafeParcelWriter.writeFloat(parcel, 11, getAnchorU());
        SafeParcelWriter.writeFloat(parcel, 12, getAnchorV());
        SafeParcelWriter.writeBoolean(parcel, 13, isClickable());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final GroundOverlayOptions zIndex(float f4) {
        this.f21309g = f4;
        return this;
    }

    public final GroundOverlayOptions position(LatLng latLng, float f4, float f5) {
        Preconditions.checkState(this.f21307e == null, "Position has already been set using positionFromBounds");
        Preconditions.checkArgument(latLng != null, "Location must be specified");
        Preconditions.checkArgument(f4 >= 0.0f, "Width must be non-negative");
        Preconditions.checkArgument(f5 >= 0.0f, "Height must be non-negative");
        return b(latLng, f4, f5);
    }

    public GroundOverlayOptions() {
        this.f21310h = true;
        this.f21311i = 0.0f;
        this.f21312j = 0.5f;
        this.f21313k = 0.5f;
        this.f21314l = false;
    }
}
