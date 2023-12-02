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

/* compiled from: Open.kt */
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\bJ&\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0013J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0005HÖ\u0001R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006 "}, d2 = {"Lcom/oneclickaway/opensource/placeautocomplete/data/api/bean/place_details/Open;", "Landroid/os/Parcelable;", "time", "", "day", "", "(Ljava/lang/String;Ljava/lang/Integer;)V", "getDay", "()Ljava/lang/Integer;", "setDay", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getTime", "()Ljava/lang/String;", "setTime", "(Ljava/lang/String;)V", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Integer;)Lcom/oneclickaway/opensource/placeautocomplete/data/api/bean/place_details/Open;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "place_autocomplete_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes6.dex */
public final class Open implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    @SerializedName("day")
    @Nullable
    private Integer day;
    @SerializedName("time")
    @Nullable
    private String time;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
    /* loaded from: classes6.dex */
    public static class Creator implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Object createFromParcel(@NotNull Parcel in) {
            Integer num;
            Intrinsics.checkParameterIsNotNull(in, "in");
            String readString = in.readString();
            if (in.readInt() != 0) {
                num = Integer.valueOf(in.readInt());
            } else {
                num = null;
            }
            return new Open(readString, num);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Object[] newArray(int i4) {
            return new Open[i4];
        }
    }

    public Open() {
        this(null, null, 3, null);
    }

    @NotNull
    public static /* synthetic */ Open copy$default(Open open, String str, Integer num, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = open.time;
        }
        if ((i4 & 2) != 0) {
            num = open.day;
        }
        return open.copy(str, num);
    }

    @Nullable
    public final String component1() {
        return this.time;
    }

    @Nullable
    public final Integer component2() {
        return this.day;
    }

    @NotNull
    public final Open copy(@Nullable String str, @Nullable Integer num) {
        return new Open(str, num);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof Open) {
                Open open = (Open) obj;
                if (!Intrinsics.areEqual(this.time, open.time) || !Intrinsics.areEqual(this.day, open.day)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @Nullable
    public final Integer getDay() {
        return this.day;
    }

    @Nullable
    public final String getTime() {
        return this.time;
    }

    public int hashCode() {
        int i4;
        String str = this.time;
        int i5 = 0;
        if (str != null) {
            i4 = str.hashCode();
        } else {
            i4 = 0;
        }
        int i6 = i4 * 31;
        Integer num = this.day;
        if (num != null) {
            i5 = num.hashCode();
        }
        return i6 + i5;
    }

    public final void setDay(@Nullable Integer num) {
        this.day = num;
    }

    public final void setTime(@Nullable String str) {
        this.time = str;
    }

    @NotNull
    public String toString() {
        return "Open(time=" + this.time + ", day=" + this.day + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i4) {
        int i5;
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeString(this.time);
        Integer num = this.day;
        if (num != null) {
            parcel.writeInt(1);
            i5 = num.intValue();
        } else {
            i5 = 0;
        }
        parcel.writeInt(i5);
    }

    public Open(@Nullable String str, @Nullable Integer num) {
        this.time = str;
        this.day = num;
    }

    public /* synthetic */ Open(String str, Integer num, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? null : str, (i4 & 2) != 0 ? null : num);
    }
}
