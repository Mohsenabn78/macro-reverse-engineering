package com.oneclickaway.opensource.placeautocomplete.data.api.bean.place_details;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PeriodsItem.kt */
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0013HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006 "}, d2 = {"Lcom/oneclickaway/opensource/placeautocomplete/data/api/bean/place_details/PeriodsItem;", "Landroid/os/Parcelable;", "close", "Lcom/oneclickaway/opensource/placeautocomplete/data/api/bean/place_details/Close;", "open", "Lcom/oneclickaway/opensource/placeautocomplete/data/api/bean/place_details/Open;", "(Lcom/oneclickaway/opensource/placeautocomplete/data/api/bean/place_details/Close;Lcom/oneclickaway/opensource/placeautocomplete/data/api/bean/place_details/Open;)V", "getClose", "()Lcom/oneclickaway/opensource/placeautocomplete/data/api/bean/place_details/Close;", "setClose", "(Lcom/oneclickaway/opensource/placeautocomplete/data/api/bean/place_details/Close;)V", "getOpen", "()Lcom/oneclickaway/opensource/placeautocomplete/data/api/bean/place_details/Open;", "setOpen", "(Lcom/oneclickaway/opensource/placeautocomplete/data/api/bean/place_details/Open;)V", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "place_autocomplete_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes6.dex */
public final class PeriodsItem implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    @SerializedName("close")
    @Nullable
    private Close close;
    @SerializedName("open")
    @Nullable
    private Open open;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
    /* loaded from: classes6.dex */
    public static class Creator implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Object createFromParcel(@NotNull Parcel in) {
            Close close;
            Intrinsics.checkParameterIsNotNull(in, "in");
            Open open = null;
            if (in.readInt() != 0) {
                close = (Close) Close.CREATOR.createFromParcel(in);
            } else {
                close = null;
            }
            if (in.readInt() != 0) {
                open = (Open) Open.CREATOR.createFromParcel(in);
            }
            return new PeriodsItem(close, open);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Object[] newArray(int i4) {
            return new PeriodsItem[i4];
        }
    }

    public PeriodsItem() {
        this(null, null, 3, null);
    }

    @NotNull
    public static /* synthetic */ PeriodsItem copy$default(PeriodsItem periodsItem, Close close, Open open, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            close = periodsItem.close;
        }
        if ((i4 & 2) != 0) {
            open = periodsItem.open;
        }
        return periodsItem.copy(close, open);
    }

    @Nullable
    public final Close component1() {
        return this.close;
    }

    @Nullable
    public final Open component2() {
        return this.open;
    }

    @NotNull
    public final PeriodsItem copy(@Nullable Close close, @Nullable Open open) {
        return new PeriodsItem(close, open);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof PeriodsItem) {
                PeriodsItem periodsItem = (PeriodsItem) obj;
                if (!Intrinsics.areEqual(this.close, periodsItem.close) || !Intrinsics.areEqual(this.open, periodsItem.open)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @Nullable
    public final Close getClose() {
        return this.close;
    }

    @Nullable
    public final Open getOpen() {
        return this.open;
    }

    public int hashCode() {
        int i4;
        Close close = this.close;
        int i5 = 0;
        if (close != null) {
            i4 = close.hashCode();
        } else {
            i4 = 0;
        }
        int i6 = i4 * 31;
        Open open = this.open;
        if (open != null) {
            i5 = open.hashCode();
        }
        return i6 + i5;
    }

    public final void setClose(@Nullable Close close) {
        this.close = close;
    }

    public final void setOpen(@Nullable Open open) {
        this.open = open;
    }

    @NotNull
    public String toString() {
        return "PeriodsItem(close=" + this.close + ", open=" + this.open + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i4) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        Close close = this.close;
        if (close != null) {
            parcel.writeInt(1);
            close.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        Open open = this.open;
        if (open != null) {
            parcel.writeInt(1);
            open.writeToParcel(parcel, 0);
            return;
        }
        parcel.writeInt(0);
    }

    public PeriodsItem(@Nullable Close close, @Nullable Open open) {
        this.close = close;
        this.open = open;
    }

    public /* synthetic */ PeriodsItem(Close close, Open open, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? null : close, (i4 & 2) != 0 ? null : open);
    }
}
