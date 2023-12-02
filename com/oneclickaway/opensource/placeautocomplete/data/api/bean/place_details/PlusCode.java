package com.oneclickaway.opensource.placeautocomplete.data.api.bean.place_details;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.room.Entity;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PlusCode.kt */
@Parcelize
@Entity(tableName = "PlusCode")
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0010HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u001c"}, d2 = {"Lcom/oneclickaway/opensource/placeautocomplete/data/api/bean/place_details/PlusCode;", "Landroid/os/Parcelable;", "compoundCode", "", "globalCode", "(Ljava/lang/String;Ljava/lang/String;)V", "getCompoundCode", "()Ljava/lang/String;", "setCompoundCode", "(Ljava/lang/String;)V", "getGlobalCode", "setGlobalCode", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "place_autocomplete_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes6.dex */
public final class PlusCode implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    @SerializedName("compound_code")
    @Nullable
    private String compoundCode;
    @SerializedName("global_code")
    @Nullable
    private String globalCode;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
    /* loaded from: classes6.dex */
    public static class Creator implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Object createFromParcel(@NotNull Parcel in) {
            Intrinsics.checkParameterIsNotNull(in, "in");
            return new PlusCode(in.readString(), in.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Object[] newArray(int i4) {
            return new PlusCode[i4];
        }
    }

    public PlusCode() {
        this(null, null, 3, null);
    }

    @NotNull
    public static /* synthetic */ PlusCode copy$default(PlusCode plusCode, String str, String str2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = plusCode.compoundCode;
        }
        if ((i4 & 2) != 0) {
            str2 = plusCode.globalCode;
        }
        return plusCode.copy(str, str2);
    }

    @Nullable
    public final String component1() {
        return this.compoundCode;
    }

    @Nullable
    public final String component2() {
        return this.globalCode;
    }

    @NotNull
    public final PlusCode copy(@Nullable String str, @Nullable String str2) {
        return new PlusCode(str, str2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof PlusCode) {
                PlusCode plusCode = (PlusCode) obj;
                if (!Intrinsics.areEqual(this.compoundCode, plusCode.compoundCode) || !Intrinsics.areEqual(this.globalCode, plusCode.globalCode)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @Nullable
    public final String getCompoundCode() {
        return this.compoundCode;
    }

    @Nullable
    public final String getGlobalCode() {
        return this.globalCode;
    }

    public int hashCode() {
        int i4;
        String str = this.compoundCode;
        int i5 = 0;
        if (str != null) {
            i4 = str.hashCode();
        } else {
            i4 = 0;
        }
        int i6 = i4 * 31;
        String str2 = this.globalCode;
        if (str2 != null) {
            i5 = str2.hashCode();
        }
        return i6 + i5;
    }

    public final void setCompoundCode(@Nullable String str) {
        this.compoundCode = str;
    }

    public final void setGlobalCode(@Nullable String str) {
        this.globalCode = str;
    }

    @NotNull
    public String toString() {
        return "PlusCode(compoundCode=" + this.compoundCode + ", globalCode=" + this.globalCode + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i4) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeString(this.compoundCode);
        parcel.writeString(this.globalCode);
    }

    public PlusCode(@Nullable String str, @Nullable String str2) {
        this.compoundCode = str;
        this.globalCode = str2;
    }

    public /* synthetic */ PlusCode(String str, String str2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? null : str, (i4 & 2) != 0 ? null : str2);
    }
}
