package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.model.StreetViewSource;

@SafeParcelable.Class(creator = "StreetViewPanoramaOptionsCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes4.dex */
public final class StreetViewPanoramaOptions extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<StreetViewPanoramaOptions> CREATOR = new zzai();
    @SafeParcelable.Field(getter = "getStreetViewPanoramaCamera", id = 2)

    /* renamed from: a  reason: collision with root package name */
    private StreetViewPanoramaCamera f21245a;
    @SafeParcelable.Field(getter = "getPanoramaId", id = 3)

    /* renamed from: b  reason: collision with root package name */
    private String f21246b;
    @SafeParcelable.Field(getter = "getPosition", id = 4)

    /* renamed from: c  reason: collision with root package name */
    private LatLng f21247c;
    @SafeParcelable.Field(getter = "getRadius", id = 5)

    /* renamed from: d  reason: collision with root package name */
    private Integer f21248d;
    @SafeParcelable.Field(getter = "getUserNavigationEnabledForParcel", id = 6, type = "byte")

    /* renamed from: e  reason: collision with root package name */
    private Boolean f21249e;
    @SafeParcelable.Field(getter = "getZoomGesturesEnabledForParcel", id = 7, type = "byte")

    /* renamed from: f  reason: collision with root package name */
    private Boolean f21250f;
    @SafeParcelable.Field(getter = "getPanningGesturesEnabledForParcel", id = 8, type = "byte")

    /* renamed from: g  reason: collision with root package name */
    private Boolean f21251g;
    @SafeParcelable.Field(getter = "getStreetNamesEnabledForParcel", id = 9, type = "byte")

    /* renamed from: h  reason: collision with root package name */
    private Boolean f21252h;
    @SafeParcelable.Field(getter = "getUseViewLifecycleInFragmentForParcel", id = 10, type = "byte")

    /* renamed from: i  reason: collision with root package name */
    private Boolean f21253i;
    @SafeParcelable.Field(getter = "getSource", id = 11)

    /* renamed from: j  reason: collision with root package name */
    private StreetViewSource f21254j;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public StreetViewPanoramaOptions(@SafeParcelable.Param(id = 2) StreetViewPanoramaCamera streetViewPanoramaCamera, @SafeParcelable.Param(id = 3) String str, @SafeParcelable.Param(id = 4) LatLng latLng, @SafeParcelable.Param(id = 5) Integer num, @SafeParcelable.Param(id = 6) byte b4, @SafeParcelable.Param(id = 7) byte b5, @SafeParcelable.Param(id = 8) byte b6, @SafeParcelable.Param(id = 9) byte b7, @SafeParcelable.Param(id = 10) byte b8, @SafeParcelable.Param(id = 11) StreetViewSource streetViewSource) {
        Boolean bool = Boolean.TRUE;
        this.f21249e = bool;
        this.f21250f = bool;
        this.f21251g = bool;
        this.f21252h = bool;
        this.f21254j = StreetViewSource.DEFAULT;
        this.f21245a = streetViewPanoramaCamera;
        this.f21247c = latLng;
        this.f21248d = num;
        this.f21246b = str;
        this.f21249e = com.google.android.gms.maps.internal.zza.zza(b4);
        this.f21250f = com.google.android.gms.maps.internal.zza.zza(b5);
        this.f21251g = com.google.android.gms.maps.internal.zza.zza(b6);
        this.f21252h = com.google.android.gms.maps.internal.zza.zza(b7);
        this.f21253i = com.google.android.gms.maps.internal.zza.zza(b8);
        this.f21254j = streetViewSource;
    }

    public final Boolean getPanningGesturesEnabled() {
        return this.f21251g;
    }

    public final String getPanoramaId() {
        return this.f21246b;
    }

    public final LatLng getPosition() {
        return this.f21247c;
    }

    public final Integer getRadius() {
        return this.f21248d;
    }

    public final StreetViewSource getSource() {
        return this.f21254j;
    }

    public final Boolean getStreetNamesEnabled() {
        return this.f21252h;
    }

    public final StreetViewPanoramaCamera getStreetViewPanoramaCamera() {
        return this.f21245a;
    }

    public final Boolean getUseViewLifecycleInFragment() {
        return this.f21253i;
    }

    public final Boolean getUserNavigationEnabled() {
        return this.f21249e;
    }

    public final Boolean getZoomGesturesEnabled() {
        return this.f21250f;
    }

    public final StreetViewPanoramaOptions panningGesturesEnabled(boolean z3) {
        this.f21251g = Boolean.valueOf(z3);
        return this;
    }

    public final StreetViewPanoramaOptions panoramaCamera(StreetViewPanoramaCamera streetViewPanoramaCamera) {
        this.f21245a = streetViewPanoramaCamera;
        return this;
    }

    public final StreetViewPanoramaOptions panoramaId(String str) {
        this.f21246b = str;
        return this;
    }

    public final StreetViewPanoramaOptions position(LatLng latLng) {
        this.f21247c = latLng;
        return this;
    }

    public final StreetViewPanoramaOptions streetNamesEnabled(boolean z3) {
        this.f21252h = Boolean.valueOf(z3);
        return this;
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("PanoramaId", this.f21246b).add("Position", this.f21247c).add("Radius", this.f21248d).add("Source", this.f21254j).add("StreetViewPanoramaCamera", this.f21245a).add("UserNavigationEnabled", this.f21249e).add("ZoomGesturesEnabled", this.f21250f).add("PanningGesturesEnabled", this.f21251g).add("StreetNamesEnabled", this.f21252h).add("UseViewLifecycleInFragment", this.f21253i).toString();
    }

    public final StreetViewPanoramaOptions useViewLifecycleInFragment(boolean z3) {
        this.f21253i = Boolean.valueOf(z3);
        return this;
    }

    public final StreetViewPanoramaOptions userNavigationEnabled(boolean z3) {
        this.f21249e = Boolean.valueOf(z3);
        return this;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, getStreetViewPanoramaCamera(), i4, false);
        SafeParcelWriter.writeString(parcel, 3, getPanoramaId(), false);
        SafeParcelWriter.writeParcelable(parcel, 4, getPosition(), i4, false);
        SafeParcelWriter.writeIntegerObject(parcel, 5, getRadius(), false);
        SafeParcelWriter.writeByte(parcel, 6, com.google.android.gms.maps.internal.zza.zza(this.f21249e));
        SafeParcelWriter.writeByte(parcel, 7, com.google.android.gms.maps.internal.zza.zza(this.f21250f));
        SafeParcelWriter.writeByte(parcel, 8, com.google.android.gms.maps.internal.zza.zza(this.f21251g));
        SafeParcelWriter.writeByte(parcel, 9, com.google.android.gms.maps.internal.zza.zza(this.f21252h));
        SafeParcelWriter.writeByte(parcel, 10, com.google.android.gms.maps.internal.zza.zza(this.f21253i));
        SafeParcelWriter.writeParcelable(parcel, 11, getSource(), i4, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final StreetViewPanoramaOptions zoomGesturesEnabled(boolean z3) {
        this.f21250f = Boolean.valueOf(z3);
        return this;
    }

    public final StreetViewPanoramaOptions position(LatLng latLng, Integer num) {
        this.f21247c = latLng;
        this.f21248d = num;
        return this;
    }

    public final StreetViewPanoramaOptions position(LatLng latLng, Integer num, StreetViewSource streetViewSource) {
        this.f21247c = latLng;
        this.f21248d = num;
        this.f21254j = streetViewSource;
        return this;
    }

    public final StreetViewPanoramaOptions position(LatLng latLng, StreetViewSource streetViewSource) {
        this.f21247c = latLng;
        this.f21254j = streetViewSource;
        return this;
    }

    public StreetViewPanoramaOptions() {
        Boolean bool = Boolean.TRUE;
        this.f21249e = bool;
        this.f21250f = bool;
        this.f21251g = bool;
        this.f21252h = bool;
        this.f21254j = StreetViewSource.DEFAULT;
    }
}
