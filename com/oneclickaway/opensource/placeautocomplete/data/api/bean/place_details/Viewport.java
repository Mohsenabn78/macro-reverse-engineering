package com.oneclickaway.opensource.placeautocomplete.data.api.bean.place_details;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Viewport.kt */
@Parcelize
@Entity(tableName = "Viewport")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000fHÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001c"}, d2 = {"Lcom/oneclickaway/opensource/placeautocomplete/data/api/bean/place_details/Viewport;", "Landroid/os/Parcelable;", "southwest", "Lcom/oneclickaway/opensource/placeautocomplete/data/api/bean/place_details/Southwest;", "northeast", "Lcom/oneclickaway/opensource/placeautocomplete/data/api/bean/place_details/Northeast;", "(Lcom/oneclickaway/opensource/placeautocomplete/data/api/bean/place_details/Southwest;Lcom/oneclickaway/opensource/placeautocomplete/data/api/bean/place_details/Northeast;)V", "getNortheast", "()Lcom/oneclickaway/opensource/placeautocomplete/data/api/bean/place_details/Northeast;", "getSouthwest", "()Lcom/oneclickaway/opensource/placeautocomplete/data/api/bean/place_details/Southwest;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "place_autocomplete_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes6.dex */
public final class Viewport implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    @SerializedName("northeast")
    @Nullable
    private final Northeast northeast;
    @SerializedName("southwest")
    @PrimaryKey
    @Nullable
    private final Southwest southwest;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
    /* loaded from: classes6.dex */
    public static class Creator implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Object createFromParcel(@NotNull Parcel in) {
            Southwest southwest;
            Intrinsics.checkParameterIsNotNull(in, "in");
            Northeast northeast = null;
            if (in.readInt() != 0) {
                southwest = (Southwest) Southwest.CREATOR.createFromParcel(in);
            } else {
                southwest = null;
            }
            if (in.readInt() != 0) {
                northeast = (Northeast) Northeast.CREATOR.createFromParcel(in);
            }
            return new Viewport(southwest, northeast);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Object[] newArray(int i4) {
            return new Viewport[i4];
        }
    }

    public Viewport() {
        this(null, null, 3, null);
    }

    @NotNull
    public static /* synthetic */ Viewport copy$default(Viewport viewport, Southwest southwest, Northeast northeast, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            southwest = viewport.southwest;
        }
        if ((i4 & 2) != 0) {
            northeast = viewport.northeast;
        }
        return viewport.copy(southwest, northeast);
    }

    @Nullable
    public final Southwest component1() {
        return this.southwest;
    }

    @Nullable
    public final Northeast component2() {
        return this.northeast;
    }

    @NotNull
    public final Viewport copy(@Nullable Southwest southwest, @Nullable Northeast northeast) {
        return new Viewport(southwest, northeast);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof Viewport) {
                Viewport viewport = (Viewport) obj;
                if (!Intrinsics.areEqual(this.southwest, viewport.southwest) || !Intrinsics.areEqual(this.northeast, viewport.northeast)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @Nullable
    public final Northeast getNortheast() {
        return this.northeast;
    }

    @Nullable
    public final Southwest getSouthwest() {
        return this.southwest;
    }

    public int hashCode() {
        int i4;
        Southwest southwest = this.southwest;
        int i5 = 0;
        if (southwest != null) {
            i4 = southwest.hashCode();
        } else {
            i4 = 0;
        }
        int i6 = i4 * 31;
        Northeast northeast = this.northeast;
        if (northeast != null) {
            i5 = northeast.hashCode();
        }
        return i6 + i5;
    }

    @NotNull
    public String toString() {
        return "Viewport(southwest=" + this.southwest + ", northeast=" + this.northeast + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i4) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        Southwest southwest = this.southwest;
        if (southwest != null) {
            parcel.writeInt(1);
            southwest.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        Northeast northeast = this.northeast;
        if (northeast != null) {
            parcel.writeInt(1);
            northeast.writeToParcel(parcel, 0);
            return;
        }
        parcel.writeInt(0);
    }

    public Viewport(@Nullable Southwest southwest, @Nullable Northeast northeast) {
        this.southwest = southwest;
        this.northeast = northeast;
    }

    public /* synthetic */ Viewport(Southwest southwest, Northeast northeast, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? null : southwest, (i4 & 2) != 0 ? null : northeast);
    }
}
