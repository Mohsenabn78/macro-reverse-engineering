package com.oneclickaway.opensource.placeautocomplete.data.api.bean.place_details;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Geometry.kt */
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0013HÖ\u0001R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006 "}, d2 = {"Lcom/oneclickaway/opensource/placeautocomplete/data/api/bean/place_details/Geometry;", "Landroid/os/Parcelable;", "viewport", "Lcom/oneclickaway/opensource/placeautocomplete/data/api/bean/place_details/Viewport;", FirebaseAnalytics.Param.LOCATION, "Lcom/oneclickaway/opensource/placeautocomplete/data/api/bean/place_details/Location;", "(Lcom/oneclickaway/opensource/placeautocomplete/data/api/bean/place_details/Viewport;Lcom/oneclickaway/opensource/placeautocomplete/data/api/bean/place_details/Location;)V", "getLocation", "()Lcom/oneclickaway/opensource/placeautocomplete/data/api/bean/place_details/Location;", "setLocation", "(Lcom/oneclickaway/opensource/placeautocomplete/data/api/bean/place_details/Location;)V", "getViewport", "()Lcom/oneclickaway/opensource/placeautocomplete/data/api/bean/place_details/Viewport;", "setViewport", "(Lcom/oneclickaway/opensource/placeautocomplete/data/api/bean/place_details/Viewport;)V", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "place_autocomplete_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes6.dex */
public final class Geometry implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    @SerializedName(FirebaseAnalytics.Param.LOCATION)
    @Nullable
    private Location location;
    @SerializedName("viewport")
    @Nullable
    private Viewport viewport;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
    /* loaded from: classes6.dex */
    public static class Creator implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Object createFromParcel(@NotNull Parcel in) {
            Viewport viewport;
            Intrinsics.checkParameterIsNotNull(in, "in");
            Location location = null;
            if (in.readInt() != 0) {
                viewport = (Viewport) Viewport.CREATOR.createFromParcel(in);
            } else {
                viewport = null;
            }
            if (in.readInt() != 0) {
                location = (Location) Location.CREATOR.createFromParcel(in);
            }
            return new Geometry(viewport, location);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Object[] newArray(int i4) {
            return new Geometry[i4];
        }
    }

    public Geometry() {
        this(null, null, 3, null);
    }

    @NotNull
    public static /* synthetic */ Geometry copy$default(Geometry geometry, Viewport viewport, Location location, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            viewport = geometry.viewport;
        }
        if ((i4 & 2) != 0) {
            location = geometry.location;
        }
        return geometry.copy(viewport, location);
    }

    @Nullable
    public final Viewport component1() {
        return this.viewport;
    }

    @Nullable
    public final Location component2() {
        return this.location;
    }

    @NotNull
    public final Geometry copy(@Nullable Viewport viewport, @Nullable Location location) {
        return new Geometry(viewport, location);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof Geometry) {
                Geometry geometry = (Geometry) obj;
                if (!Intrinsics.areEqual(this.viewport, geometry.viewport) || !Intrinsics.areEqual(this.location, geometry.location)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @Nullable
    public final Location getLocation() {
        return this.location;
    }

    @Nullable
    public final Viewport getViewport() {
        return this.viewport;
    }

    public int hashCode() {
        int i4;
        Viewport viewport = this.viewport;
        int i5 = 0;
        if (viewport != null) {
            i4 = viewport.hashCode();
        } else {
            i4 = 0;
        }
        int i6 = i4 * 31;
        Location location = this.location;
        if (location != null) {
            i5 = location.hashCode();
        }
        return i6 + i5;
    }

    public final void setLocation(@Nullable Location location) {
        this.location = location;
    }

    public final void setViewport(@Nullable Viewport viewport) {
        this.viewport = viewport;
    }

    @NotNull
    public String toString() {
        return "Geometry(viewport=" + this.viewport + ", location=" + this.location + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i4) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        Viewport viewport = this.viewport;
        if (viewport != null) {
            parcel.writeInt(1);
            viewport.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        Location location = this.location;
        if (location != null) {
            parcel.writeInt(1);
            location.writeToParcel(parcel, 0);
            return;
        }
        parcel.writeInt(0);
    }

    public Geometry(@Nullable Viewport viewport, @Nullable Location location) {
        this.viewport = viewport;
        this.location = location;
    }

    public /* synthetic */ Geometry(Viewport viewport, Location location, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? null : viewport, (i4 & 2) != 0 ? null : location);
    }
}
