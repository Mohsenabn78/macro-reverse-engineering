package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.maps.zzaf;
import com.google.android.gms.internal.maps.zzag;

@SafeParcelable.Class(creator = "TileOverlayOptionsCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes4.dex */
public final class TileOverlayOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<TileOverlayOptions> CREATOR = new zzu();
    @SafeParcelable.Field(getter = "getTileProviderDelegate", id = 2, type = "android.os.IBinder")

    /* renamed from: a  reason: collision with root package name */
    private zzaf f21369a;

    /* renamed from: b  reason: collision with root package name */
    private TileProvider f21370b;
    @SafeParcelable.Field(getter = "isVisible", id = 3)

    /* renamed from: c  reason: collision with root package name */
    private boolean f21371c;
    @SafeParcelable.Field(getter = "getZIndex", id = 4)

    /* renamed from: d  reason: collision with root package name */
    private float f21372d;
    @SafeParcelable.Field(defaultValue = "true", getter = "getFadeIn", id = 5)

    /* renamed from: e  reason: collision with root package name */
    private boolean f21373e;
    @SafeParcelable.Field(getter = "getTransparency", id = 6)

    /* renamed from: f  reason: collision with root package name */
    private float f21374f;

    public TileOverlayOptions() {
        this.f21371c = true;
        this.f21373e = true;
        this.f21374f = 0.0f;
    }

    public final TileOverlayOptions fadeIn(boolean z3) {
        this.f21373e = z3;
        return this;
    }

    public final boolean getFadeIn() {
        return this.f21373e;
    }

    public final TileProvider getTileProvider() {
        return this.f21370b;
    }

    public final float getTransparency() {
        return this.f21374f;
    }

    public final float getZIndex() {
        return this.f21372d;
    }

    public final boolean isVisible() {
        return this.f21371c;
    }

    public final TileOverlayOptions tileProvider(TileProvider tileProvider) {
        zzt zztVar;
        this.f21370b = tileProvider;
        if (tileProvider == null) {
            zztVar = null;
        } else {
            zztVar = new zzt(this, tileProvider);
        }
        this.f21369a = zztVar;
        return this;
    }

    public final TileOverlayOptions transparency(float f4) {
        boolean z3;
        if (f4 >= 0.0f && f4 <= 1.0f) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "Transparency must be in the range [0..1]");
        this.f21374f = f4;
        return this;
    }

    public final TileOverlayOptions visible(boolean z3) {
        this.f21371c = z3;
        return this;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeIBinder(parcel, 2, this.f21369a.asBinder(), false);
        SafeParcelWriter.writeBoolean(parcel, 3, isVisible());
        SafeParcelWriter.writeFloat(parcel, 4, getZIndex());
        SafeParcelWriter.writeBoolean(parcel, 5, getFadeIn());
        SafeParcelWriter.writeFloat(parcel, 6, getTransparency());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final TileOverlayOptions zIndex(float f4) {
        this.f21372d = f4;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public TileOverlayOptions(@SafeParcelable.Param(id = 2) IBinder iBinder, @SafeParcelable.Param(id = 3) boolean z3, @SafeParcelable.Param(id = 4) float f4, @SafeParcelable.Param(id = 5) boolean z4, @SafeParcelable.Param(id = 6) float f5) {
        this.f21371c = true;
        this.f21373e = true;
        this.f21374f = 0.0f;
        zzaf zzk = zzag.zzk(iBinder);
        this.f21369a = zzk;
        this.f21370b = zzk == null ? null : new zzs(this);
        this.f21371c = z3;
        this.f21372d = f4;
        this.f21373e = z4;
        this.f21374f = f5;
    }
}
