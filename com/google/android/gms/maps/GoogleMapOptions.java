package com.google.android.gms.maps;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.common.Util;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

@SafeParcelable.Class(creator = "GoogleMapOptionsCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes4.dex */
public final class GoogleMapOptions extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<GoogleMapOptions> CREATOR = new zzaa();
    @SafeParcelable.Field(defaultValue = Util.ANY_CONTACT_ID, getter = "getZOrderOnTopForParcel", id = 2, type = "byte")

    /* renamed from: a  reason: collision with root package name */
    private Boolean f21202a;
    @SafeParcelable.Field(defaultValue = Util.ANY_CONTACT_ID, getter = "getUseViewLifecycleInFragmentForParcel", id = 3, type = "byte")

    /* renamed from: b  reason: collision with root package name */
    private Boolean f21203b;
    @SafeParcelable.Field(getter = "getMapType", id = 4)

    /* renamed from: c  reason: collision with root package name */
    private int f21204c;
    @SafeParcelable.Field(getter = "getCamera", id = 5)

    /* renamed from: d  reason: collision with root package name */
    private CameraPosition f21205d;
    @SafeParcelable.Field(defaultValue = Util.ANY_CONTACT_ID, getter = "getZoomControlsEnabledForParcel", id = 6, type = "byte")

    /* renamed from: e  reason: collision with root package name */
    private Boolean f21206e;
    @SafeParcelable.Field(defaultValue = Util.ANY_CONTACT_ID, getter = "getCompassEnabledForParcel", id = 7, type = "byte")

    /* renamed from: f  reason: collision with root package name */
    private Boolean f21207f;
    @SafeParcelable.Field(defaultValue = Util.ANY_CONTACT_ID, getter = "getScrollGesturesEnabledForParcel", id = 8, type = "byte")

    /* renamed from: g  reason: collision with root package name */
    private Boolean f21208g;
    @SafeParcelable.Field(defaultValue = Util.ANY_CONTACT_ID, getter = "getZoomGesturesEnabledForParcel", id = 9, type = "byte")

    /* renamed from: h  reason: collision with root package name */
    private Boolean f21209h;
    @SafeParcelable.Field(defaultValue = Util.ANY_CONTACT_ID, getter = "getTiltGesturesEnabledForParcel", id = 10, type = "byte")

    /* renamed from: i  reason: collision with root package name */
    private Boolean f21210i;
    @SafeParcelable.Field(defaultValue = Util.ANY_CONTACT_ID, getter = "getRotateGesturesEnabledForParcel", id = 11, type = "byte")

    /* renamed from: j  reason: collision with root package name */
    private Boolean f21211j;
    @SafeParcelable.Field(defaultValue = Util.ANY_CONTACT_ID, getter = "getLiteModeForParcel", id = 12, type = "byte")

    /* renamed from: k  reason: collision with root package name */
    private Boolean f21212k;
    @SafeParcelable.Field(defaultValue = Util.ANY_CONTACT_ID, getter = "getMapToolbarEnabledForParcel", id = 14, type = "byte")

    /* renamed from: l  reason: collision with root package name */
    private Boolean f21213l;
    @SafeParcelable.Field(defaultValue = Util.ANY_CONTACT_ID, getter = "getAmbientEnabledForParcel", id = 15, type = "byte")

    /* renamed from: m  reason: collision with root package name */
    private Boolean f21214m;
    @SafeParcelable.Field(getter = "getMinZoomPreference", id = 16)

    /* renamed from: n  reason: collision with root package name */
    private Float f21215n;
    @SafeParcelable.Field(getter = "getMaxZoomPreference", id = 17)

    /* renamed from: o  reason: collision with root package name */
    private Float f21216o;
    @SafeParcelable.Field(getter = "getLatLngBoundsForCameraTarget", id = 18)

    /* renamed from: p  reason: collision with root package name */
    private LatLngBounds f21217p;
    @SafeParcelable.Field(defaultValue = Util.ANY_CONTACT_ID, getter = "getScrollGesturesEnabledDuringRotateOrZoomForParcel", id = 19, type = "byte")

    /* renamed from: q  reason: collision with root package name */
    private Boolean f21218q;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public GoogleMapOptions(@SafeParcelable.Param(id = 2) byte b4, @SafeParcelable.Param(id = 3) byte b5, @SafeParcelable.Param(id = 4) int i4, @SafeParcelable.Param(id = 5) CameraPosition cameraPosition, @SafeParcelable.Param(id = 6) byte b6, @SafeParcelable.Param(id = 7) byte b7, @SafeParcelable.Param(id = 8) byte b8, @SafeParcelable.Param(id = 9) byte b9, @SafeParcelable.Param(id = 10) byte b10, @SafeParcelable.Param(id = 11) byte b11, @SafeParcelable.Param(id = 12) byte b12, @SafeParcelable.Param(id = 14) byte b13, @SafeParcelable.Param(id = 15) byte b14, @SafeParcelable.Param(id = 16) Float f4, @SafeParcelable.Param(id = 17) Float f5, @SafeParcelable.Param(id = 18) LatLngBounds latLngBounds, @SafeParcelable.Param(id = 19) byte b15) {
        this.f21204c = -1;
        this.f21215n = null;
        this.f21216o = null;
        this.f21217p = null;
        this.f21202a = com.google.android.gms.maps.internal.zza.zza(b4);
        this.f21203b = com.google.android.gms.maps.internal.zza.zza(b5);
        this.f21204c = i4;
        this.f21205d = cameraPosition;
        this.f21206e = com.google.android.gms.maps.internal.zza.zza(b6);
        this.f21207f = com.google.android.gms.maps.internal.zza.zza(b7);
        this.f21208g = com.google.android.gms.maps.internal.zza.zza(b8);
        this.f21209h = com.google.android.gms.maps.internal.zza.zza(b9);
        this.f21210i = com.google.android.gms.maps.internal.zza.zza(b10);
        this.f21211j = com.google.android.gms.maps.internal.zza.zza(b11);
        this.f21212k = com.google.android.gms.maps.internal.zza.zza(b12);
        this.f21213l = com.google.android.gms.maps.internal.zza.zza(b13);
        this.f21214m = com.google.android.gms.maps.internal.zza.zza(b14);
        this.f21215n = f4;
        this.f21216o = f5;
        this.f21217p = latLngBounds;
        this.f21218q = com.google.android.gms.maps.internal.zza.zza(b15);
    }

    public static GoogleMapOptions createFromAttributes(Context context, AttributeSet attributeSet) {
        if (context != null && attributeSet != null) {
            TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R.styleable.MapAttrs);
            GoogleMapOptions googleMapOptions = new GoogleMapOptions();
            int i4 = R.styleable.MapAttrs_mapType;
            if (obtainAttributes.hasValue(i4)) {
                googleMapOptions.mapType(obtainAttributes.getInt(i4, -1));
            }
            int i5 = R.styleable.MapAttrs_zOrderOnTop;
            if (obtainAttributes.hasValue(i5)) {
                googleMapOptions.zOrderOnTop(obtainAttributes.getBoolean(i5, false));
            }
            int i6 = R.styleable.MapAttrs_useViewLifecycle;
            if (obtainAttributes.hasValue(i6)) {
                googleMapOptions.useViewLifecycleInFragment(obtainAttributes.getBoolean(i6, false));
            }
            int i7 = R.styleable.MapAttrs_uiCompass;
            if (obtainAttributes.hasValue(i7)) {
                googleMapOptions.compassEnabled(obtainAttributes.getBoolean(i7, true));
            }
            int i8 = R.styleable.MapAttrs_uiRotateGestures;
            if (obtainAttributes.hasValue(i8)) {
                googleMapOptions.rotateGesturesEnabled(obtainAttributes.getBoolean(i8, true));
            }
            int i9 = R.styleable.MapAttrs_uiScrollGesturesDuringRotateOrZoom;
            if (obtainAttributes.hasValue(i9)) {
                googleMapOptions.scrollGesturesEnabledDuringRotateOrZoom(obtainAttributes.getBoolean(i9, true));
            }
            int i10 = R.styleable.MapAttrs_uiScrollGestures;
            if (obtainAttributes.hasValue(i10)) {
                googleMapOptions.scrollGesturesEnabled(obtainAttributes.getBoolean(i10, true));
            }
            int i11 = R.styleable.MapAttrs_uiTiltGestures;
            if (obtainAttributes.hasValue(i11)) {
                googleMapOptions.tiltGesturesEnabled(obtainAttributes.getBoolean(i11, true));
            }
            int i12 = R.styleable.MapAttrs_uiZoomGestures;
            if (obtainAttributes.hasValue(i12)) {
                googleMapOptions.zoomGesturesEnabled(obtainAttributes.getBoolean(i12, true));
            }
            int i13 = R.styleable.MapAttrs_uiZoomControls;
            if (obtainAttributes.hasValue(i13)) {
                googleMapOptions.zoomControlsEnabled(obtainAttributes.getBoolean(i13, true));
            }
            int i14 = R.styleable.MapAttrs_liteMode;
            if (obtainAttributes.hasValue(i14)) {
                googleMapOptions.liteMode(obtainAttributes.getBoolean(i14, false));
            }
            int i15 = R.styleable.MapAttrs_uiMapToolbar;
            if (obtainAttributes.hasValue(i15)) {
                googleMapOptions.mapToolbarEnabled(obtainAttributes.getBoolean(i15, true));
            }
            int i16 = R.styleable.MapAttrs_ambientEnabled;
            if (obtainAttributes.hasValue(i16)) {
                googleMapOptions.ambientEnabled(obtainAttributes.getBoolean(i16, false));
            }
            int i17 = R.styleable.MapAttrs_cameraMinZoomPreference;
            if (obtainAttributes.hasValue(i17)) {
                googleMapOptions.minZoomPreference(obtainAttributes.getFloat(i17, Float.NEGATIVE_INFINITY));
            }
            if (obtainAttributes.hasValue(i17)) {
                googleMapOptions.maxZoomPreference(obtainAttributes.getFloat(R.styleable.MapAttrs_cameraMaxZoomPreference, Float.POSITIVE_INFINITY));
            }
            googleMapOptions.latLngBoundsForCameraTarget(zza(context, attributeSet));
            googleMapOptions.camera(zzb(context, attributeSet));
            obtainAttributes.recycle();
            return googleMapOptions;
        }
        return null;
    }

    public static LatLngBounds zza(Context context, AttributeSet attributeSet) {
        Float f4;
        Float f5;
        Float f6;
        Float f7;
        if (context == null || attributeSet == null) {
            return null;
        }
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R.styleable.MapAttrs);
        int i4 = R.styleable.MapAttrs_latLngBoundsSouthWestLatitude;
        if (obtainAttributes.hasValue(i4)) {
            f4 = Float.valueOf(obtainAttributes.getFloat(i4, 0.0f));
        } else {
            f4 = null;
        }
        int i5 = R.styleable.MapAttrs_latLngBoundsSouthWestLongitude;
        if (obtainAttributes.hasValue(i5)) {
            f5 = Float.valueOf(obtainAttributes.getFloat(i5, 0.0f));
        } else {
            f5 = null;
        }
        int i6 = R.styleable.MapAttrs_latLngBoundsNorthEastLatitude;
        if (obtainAttributes.hasValue(i6)) {
            f6 = Float.valueOf(obtainAttributes.getFloat(i6, 0.0f));
        } else {
            f6 = null;
        }
        int i7 = R.styleable.MapAttrs_latLngBoundsNorthEastLongitude;
        if (obtainAttributes.hasValue(i7)) {
            f7 = Float.valueOf(obtainAttributes.getFloat(i7, 0.0f));
        } else {
            f7 = null;
        }
        obtainAttributes.recycle();
        if (f4 == null || f5 == null || f6 == null || f7 == null) {
            return null;
        }
        return new LatLngBounds(new LatLng(f4.floatValue(), f5.floatValue()), new LatLng(f6.floatValue(), f7.floatValue()));
    }

    public static CameraPosition zzb(Context context, AttributeSet attributeSet) {
        float f4;
        float f5;
        if (context != null && attributeSet != null) {
            TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R.styleable.MapAttrs);
            int i4 = R.styleable.MapAttrs_cameraTargetLat;
            if (obtainAttributes.hasValue(i4)) {
                f4 = obtainAttributes.getFloat(i4, 0.0f);
            } else {
                f4 = 0.0f;
            }
            int i5 = R.styleable.MapAttrs_cameraTargetLng;
            if (obtainAttributes.hasValue(i5)) {
                f5 = obtainAttributes.getFloat(i5, 0.0f);
            } else {
                f5 = 0.0f;
            }
            LatLng latLng = new LatLng(f4, f5);
            CameraPosition.Builder builder = CameraPosition.builder();
            builder.target(latLng);
            int i6 = R.styleable.MapAttrs_cameraZoom;
            if (obtainAttributes.hasValue(i6)) {
                builder.zoom(obtainAttributes.getFloat(i6, 0.0f));
            }
            int i7 = R.styleable.MapAttrs_cameraBearing;
            if (obtainAttributes.hasValue(i7)) {
                builder.bearing(obtainAttributes.getFloat(i7, 0.0f));
            }
            int i8 = R.styleable.MapAttrs_cameraTilt;
            if (obtainAttributes.hasValue(i8)) {
                builder.tilt(obtainAttributes.getFloat(i8, 0.0f));
            }
            obtainAttributes.recycle();
            return builder.build();
        }
        return null;
    }

    public final GoogleMapOptions ambientEnabled(boolean z3) {
        this.f21214m = Boolean.valueOf(z3);
        return this;
    }

    public final GoogleMapOptions camera(CameraPosition cameraPosition) {
        this.f21205d = cameraPosition;
        return this;
    }

    public final GoogleMapOptions compassEnabled(boolean z3) {
        this.f21207f = Boolean.valueOf(z3);
        return this;
    }

    public final Boolean getAmbientEnabled() {
        return this.f21214m;
    }

    public final CameraPosition getCamera() {
        return this.f21205d;
    }

    public final Boolean getCompassEnabled() {
        return this.f21207f;
    }

    public final LatLngBounds getLatLngBoundsForCameraTarget() {
        return this.f21217p;
    }

    public final Boolean getLiteMode() {
        return this.f21212k;
    }

    public final Boolean getMapToolbarEnabled() {
        return this.f21213l;
    }

    public final int getMapType() {
        return this.f21204c;
    }

    public final Float getMaxZoomPreference() {
        return this.f21216o;
    }

    public final Float getMinZoomPreference() {
        return this.f21215n;
    }

    public final Boolean getRotateGesturesEnabled() {
        return this.f21211j;
    }

    public final Boolean getScrollGesturesEnabled() {
        return this.f21208g;
    }

    public final Boolean getScrollGesturesEnabledDuringRotateOrZoom() {
        return this.f21218q;
    }

    public final Boolean getTiltGesturesEnabled() {
        return this.f21210i;
    }

    public final Boolean getUseViewLifecycleInFragment() {
        return this.f21203b;
    }

    public final Boolean getZOrderOnTop() {
        return this.f21202a;
    }

    public final Boolean getZoomControlsEnabled() {
        return this.f21206e;
    }

    public final Boolean getZoomGesturesEnabled() {
        return this.f21209h;
    }

    public final GoogleMapOptions latLngBoundsForCameraTarget(LatLngBounds latLngBounds) {
        this.f21217p = latLngBounds;
        return this;
    }

    public final GoogleMapOptions liteMode(boolean z3) {
        this.f21212k = Boolean.valueOf(z3);
        return this;
    }

    public final GoogleMapOptions mapToolbarEnabled(boolean z3) {
        this.f21213l = Boolean.valueOf(z3);
        return this;
    }

    public final GoogleMapOptions mapType(int i4) {
        this.f21204c = i4;
        return this;
    }

    public final GoogleMapOptions maxZoomPreference(float f4) {
        this.f21216o = Float.valueOf(f4);
        return this;
    }

    public final GoogleMapOptions minZoomPreference(float f4) {
        this.f21215n = Float.valueOf(f4);
        return this;
    }

    public final GoogleMapOptions rotateGesturesEnabled(boolean z3) {
        this.f21211j = Boolean.valueOf(z3);
        return this;
    }

    public final GoogleMapOptions scrollGesturesEnabled(boolean z3) {
        this.f21208g = Boolean.valueOf(z3);
        return this;
    }

    public final GoogleMapOptions scrollGesturesEnabledDuringRotateOrZoom(boolean z3) {
        this.f21218q = Boolean.valueOf(z3);
        return this;
    }

    public final GoogleMapOptions tiltGesturesEnabled(boolean z3) {
        this.f21210i = Boolean.valueOf(z3);
        return this;
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("MapType", Integer.valueOf(this.f21204c)).add("LiteMode", this.f21212k).add(Constants.CAMERA_APP_NAME, this.f21205d).add("CompassEnabled", this.f21207f).add("ZoomControlsEnabled", this.f21206e).add("ScrollGesturesEnabled", this.f21208g).add("ZoomGesturesEnabled", this.f21209h).add("TiltGesturesEnabled", this.f21210i).add("RotateGesturesEnabled", this.f21211j).add("ScrollGesturesEnabledDuringRotateOrZoom", this.f21218q).add("MapToolbarEnabled", this.f21213l).add("AmbientEnabled", this.f21214m).add("MinZoomPreference", this.f21215n).add("MaxZoomPreference", this.f21216o).add("LatLngBoundsForCameraTarget", this.f21217p).add("ZOrderOnTop", this.f21202a).add("UseViewLifecycleInFragment", this.f21203b).toString();
    }

    public final GoogleMapOptions useViewLifecycleInFragment(boolean z3) {
        this.f21203b = Boolean.valueOf(z3);
        return this;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeByte(parcel, 2, com.google.android.gms.maps.internal.zza.zza(this.f21202a));
        SafeParcelWriter.writeByte(parcel, 3, com.google.android.gms.maps.internal.zza.zza(this.f21203b));
        SafeParcelWriter.writeInt(parcel, 4, getMapType());
        SafeParcelWriter.writeParcelable(parcel, 5, getCamera(), i4, false);
        SafeParcelWriter.writeByte(parcel, 6, com.google.android.gms.maps.internal.zza.zza(this.f21206e));
        SafeParcelWriter.writeByte(parcel, 7, com.google.android.gms.maps.internal.zza.zza(this.f21207f));
        SafeParcelWriter.writeByte(parcel, 8, com.google.android.gms.maps.internal.zza.zza(this.f21208g));
        SafeParcelWriter.writeByte(parcel, 9, com.google.android.gms.maps.internal.zza.zza(this.f21209h));
        SafeParcelWriter.writeByte(parcel, 10, com.google.android.gms.maps.internal.zza.zza(this.f21210i));
        SafeParcelWriter.writeByte(parcel, 11, com.google.android.gms.maps.internal.zza.zza(this.f21211j));
        SafeParcelWriter.writeByte(parcel, 12, com.google.android.gms.maps.internal.zza.zza(this.f21212k));
        SafeParcelWriter.writeByte(parcel, 14, com.google.android.gms.maps.internal.zza.zza(this.f21213l));
        SafeParcelWriter.writeByte(parcel, 15, com.google.android.gms.maps.internal.zza.zza(this.f21214m));
        SafeParcelWriter.writeFloatObject(parcel, 16, getMinZoomPreference(), false);
        SafeParcelWriter.writeFloatObject(parcel, 17, getMaxZoomPreference(), false);
        SafeParcelWriter.writeParcelable(parcel, 18, getLatLngBoundsForCameraTarget(), i4, false);
        SafeParcelWriter.writeByte(parcel, 19, com.google.android.gms.maps.internal.zza.zza(this.f21218q));
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final GoogleMapOptions zOrderOnTop(boolean z3) {
        this.f21202a = Boolean.valueOf(z3);
        return this;
    }

    public final GoogleMapOptions zoomControlsEnabled(boolean z3) {
        this.f21206e = Boolean.valueOf(z3);
        return this;
    }

    public final GoogleMapOptions zoomGesturesEnabled(boolean z3) {
        this.f21209h = Boolean.valueOf(z3);
        return this;
    }

    public GoogleMapOptions() {
        this.f21204c = -1;
        this.f21215n = null;
        this.f21216o = null;
        this.f21217p = null;
    }
}
