package com.oneclickaway.opensource.placeautocomplete.data.api.bean.place_details;

import android.os.Parcel;
import android.os.Parcelable;
import com.arlosoft.macrodroid.triggers.activities.LocationChooserActivity;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Northeast.kt */
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0010J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0012HÖ\u0001R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\u001f"}, d2 = {"Lcom/oneclickaway/opensource/placeautocomplete/data/api/bean/place_details/Northeast;", "Landroid/os/Parcelable;", "lng", "", LocationChooserActivity.EXTRA_LAT, "(Ljava/lang/Double;Ljava/lang/Double;)V", "getLat", "()Ljava/lang/Double;", "setLat", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "getLng", "setLng", "component1", "component2", "copy", "(Ljava/lang/Double;Ljava/lang/Double;)Lcom/oneclickaway/opensource/placeautocomplete/data/api/bean/place_details/Northeast;", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "place_autocomplete_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes6.dex */
public final class Northeast implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    @SerializedName(LocationChooserActivity.EXTRA_LAT)
    @Nullable
    private Double lat;
    @SerializedName("lng")
    @Nullable
    private Double lng;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
    /* loaded from: classes6.dex */
    public static class Creator implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Object createFromParcel(@NotNull Parcel in) {
            Double d4;
            Intrinsics.checkParameterIsNotNull(in, "in");
            Double d5 = null;
            if (in.readInt() != 0) {
                d4 = Double.valueOf(in.readDouble());
            } else {
                d4 = null;
            }
            if (in.readInt() != 0) {
                d5 = Double.valueOf(in.readDouble());
            }
            return new Northeast(d4, d5);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Object[] newArray(int i4) {
            return new Northeast[i4];
        }
    }

    public Northeast() {
        this(null, null, 3, null);
    }

    @NotNull
    public static /* synthetic */ Northeast copy$default(Northeast northeast, Double d4, Double d5, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            d4 = northeast.lng;
        }
        if ((i4 & 2) != 0) {
            d5 = northeast.lat;
        }
        return northeast.copy(d4, d5);
    }

    @Nullable
    public final Double component1() {
        return this.lng;
    }

    @Nullable
    public final Double component2() {
        return this.lat;
    }

    @NotNull
    public final Northeast copy(@Nullable Double d4, @Nullable Double d5) {
        return new Northeast(d4, d5);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof Northeast) {
                Northeast northeast = (Northeast) obj;
                if (!Intrinsics.areEqual((Object) this.lng, (Object) northeast.lng) || !Intrinsics.areEqual((Object) this.lat, (Object) northeast.lat)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @Nullable
    public final Double getLat() {
        return this.lat;
    }

    @Nullable
    public final Double getLng() {
        return this.lng;
    }

    public int hashCode() {
        int i4;
        Double d4 = this.lng;
        int i5 = 0;
        if (d4 != null) {
            i4 = d4.hashCode();
        } else {
            i4 = 0;
        }
        int i6 = i4 * 31;
        Double d5 = this.lat;
        if (d5 != null) {
            i5 = d5.hashCode();
        }
        return i6 + i5;
    }

    public final void setLat(@Nullable Double d4) {
        this.lat = d4;
    }

    public final void setLng(@Nullable Double d4) {
        this.lng = d4;
    }

    @NotNull
    public String toString() {
        return "Northeast(lng=" + this.lng + ", lat=" + this.lat + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i4) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        Double d4 = this.lng;
        if (d4 != null) {
            parcel.writeInt(1);
            parcel.writeDouble(d4.doubleValue());
        } else {
            parcel.writeInt(0);
        }
        Double d5 = this.lat;
        if (d5 != null) {
            parcel.writeInt(1);
            parcel.writeDouble(d5.doubleValue());
            return;
        }
        parcel.writeInt(0);
    }

    public Northeast(@Nullable Double d4, @Nullable Double d5) {
        this.lng = d4;
        this.lat = d5;
    }

    public /* synthetic */ Northeast(Double d4, Double d5, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? null : d4, (i4 & 2) != 0 ? null : d5);
    }
}
