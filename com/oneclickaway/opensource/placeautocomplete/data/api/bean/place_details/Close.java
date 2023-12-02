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

/* compiled from: Close.kt */
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001e"}, d2 = {"Lcom/oneclickaway/opensource/placeautocomplete/data/api/bean/place_details/Close;", "Landroid/os/Parcelable;", "time", "", "day", "", "(Ljava/lang/String;I)V", "getDay", "()I", "setDay", "(I)V", "getTime", "()Ljava/lang/String;", "setTime", "(Ljava/lang/String;)V", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "place_autocomplete_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes6.dex */
public final class Close implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    @SerializedName("day")
    private int day;
    @SerializedName("time")
    @Nullable
    private String time;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
    /* loaded from: classes6.dex */
    public static class Creator implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Object createFromParcel(@NotNull Parcel in) {
            Intrinsics.checkParameterIsNotNull(in, "in");
            return new Close(in.readString(), in.readInt());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Object[] newArray(int i4) {
            return new Close[i4];
        }
    }

    public Close(@Nullable String str, int i4) {
        this.time = str;
        this.day = i4;
    }

    @NotNull
    public static /* synthetic */ Close copy$default(Close close, String str, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = close.time;
        }
        if ((i5 & 2) != 0) {
            i4 = close.day;
        }
        return close.copy(str, i4);
    }

    @Nullable
    public final String component1() {
        return this.time;
    }

    public final int component2() {
        return this.day;
    }

    @NotNull
    public final Close copy(@Nullable String str, int i4) {
        return new Close(str, i4);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        boolean z3;
        if (this != obj) {
            if (obj instanceof Close) {
                Close close = (Close) obj;
                if (Intrinsics.areEqual(this.time, close.time)) {
                    if (this.day == close.day) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (z3) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int getDay() {
        return this.day;
    }

    @Nullable
    public final String getTime() {
        return this.time;
    }

    public int hashCode() {
        int i4;
        String str = this.time;
        if (str != null) {
            i4 = str.hashCode();
        } else {
            i4 = 0;
        }
        return (i4 * 31) + this.day;
    }

    public final void setDay(int i4) {
        this.day = i4;
    }

    public final void setTime(@Nullable String str) {
        this.time = str;
    }

    @NotNull
    public String toString() {
        return "Close(time=" + this.time + ", day=" + this.day + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i4) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeString(this.time);
        parcel.writeInt(this.day);
    }

    public /* synthetic */ Close(String str, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? null : str, i4);
    }
}
