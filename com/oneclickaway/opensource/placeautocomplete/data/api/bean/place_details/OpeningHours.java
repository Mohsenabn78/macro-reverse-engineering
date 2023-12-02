package com.oneclickaway.opensource.placeautocomplete.data.api.bean.place_details;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: OpeningHours.kt */
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0005¢\u0006\u0002\u0010\tJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0013\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003J\u0013\u0010\u0017\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0005HÆ\u0003JB\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00052\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0019J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\u0013\u0010\u001c\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\u001bHÖ\u0001J\t\u0010 \u001a\u00020\bHÖ\u0001J\u0019\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001bHÖ\u0001R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR(\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R(\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012¨\u0006&"}, d2 = {"Lcom/oneclickaway/opensource/placeautocomplete/data/api/bean/place_details/OpeningHours;", "Landroid/os/Parcelable;", "openNow", "", "periods", "", "Lcom/oneclickaway/opensource/placeautocomplete/data/api/bean/place_details/PeriodsItem;", "weekdayText", "", "(Ljava/lang/Boolean;Ljava/util/List;Ljava/util/List;)V", "getOpenNow", "()Ljava/lang/Boolean;", "setOpenNow", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getPeriods", "()Ljava/util/List;", "setPeriods", "(Ljava/util/List;)V", "getWeekdayText", "setWeekdayText", "component1", "component2", "component3", "copy", "(Ljava/lang/Boolean;Ljava/util/List;Ljava/util/List;)Lcom/oneclickaway/opensource/placeautocomplete/data/api/bean/place_details/OpeningHours;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "place_autocomplete_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes6.dex */
public final class OpeningHours implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    @SerializedName("open_now")
    @Nullable
    private Boolean openNow;
    @SerializedName("periods")
    @Nullable
    private List<PeriodsItem> periods;
    @SerializedName("weekday_text")
    @Nullable
    private List<String> weekdayText;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
    /* loaded from: classes6.dex */
    public static class Creator implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Object createFromParcel(@NotNull Parcel in) {
            Boolean bool;
            PeriodsItem periodsItem;
            boolean z3;
            Intrinsics.checkParameterIsNotNull(in, "in");
            ArrayList arrayList = null;
            if (in.readInt() != 0) {
                if (in.readInt() != 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                bool = Boolean.valueOf(z3);
            } else {
                bool = null;
            }
            if (in.readInt() != 0) {
                int readInt = in.readInt();
                ArrayList arrayList2 = new ArrayList(readInt);
                while (readInt != 0) {
                    if (in.readInt() != 0) {
                        periodsItem = (PeriodsItem) PeriodsItem.CREATOR.createFromParcel(in);
                    } else {
                        periodsItem = null;
                    }
                    arrayList2.add(periodsItem);
                    readInt--;
                }
                arrayList = arrayList2;
            }
            return new OpeningHours(bool, arrayList, in.createStringArrayList());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Object[] newArray(int i4) {
            return new OpeningHours[i4];
        }
    }

    public OpeningHours() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static /* synthetic */ OpeningHours copy$default(OpeningHours openingHours, Boolean bool, List list, List list2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            bool = openingHours.openNow;
        }
        if ((i4 & 2) != 0) {
            list = openingHours.periods;
        }
        if ((i4 & 4) != 0) {
            list2 = openingHours.weekdayText;
        }
        return openingHours.copy(bool, list, list2);
    }

    @Nullable
    public final Boolean component1() {
        return this.openNow;
    }

    @Nullable
    public final List<PeriodsItem> component2() {
        return this.periods;
    }

    @Nullable
    public final List<String> component3() {
        return this.weekdayText;
    }

    @NotNull
    public final OpeningHours copy(@Nullable Boolean bool, @Nullable List<PeriodsItem> list, @Nullable List<String> list2) {
        return new OpeningHours(bool, list, list2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof OpeningHours) {
                OpeningHours openingHours = (OpeningHours) obj;
                if (!Intrinsics.areEqual(this.openNow, openingHours.openNow) || !Intrinsics.areEqual(this.periods, openingHours.periods) || !Intrinsics.areEqual(this.weekdayText, openingHours.weekdayText)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @Nullable
    public final Boolean getOpenNow() {
        return this.openNow;
    }

    @Nullable
    public final List<PeriodsItem> getPeriods() {
        return this.periods;
    }

    @Nullable
    public final List<String> getWeekdayText() {
        return this.weekdayText;
    }

    public int hashCode() {
        int i4;
        int i5;
        Boolean bool = this.openNow;
        int i6 = 0;
        if (bool != null) {
            i4 = bool.hashCode();
        } else {
            i4 = 0;
        }
        int i7 = i4 * 31;
        List<PeriodsItem> list = this.periods;
        if (list != null) {
            i5 = list.hashCode();
        } else {
            i5 = 0;
        }
        int i8 = (i7 + i5) * 31;
        List<String> list2 = this.weekdayText;
        if (list2 != null) {
            i6 = list2.hashCode();
        }
        return i8 + i6;
    }

    public final void setOpenNow(@Nullable Boolean bool) {
        this.openNow = bool;
    }

    public final void setPeriods(@Nullable List<PeriodsItem> list) {
        this.periods = list;
    }

    public final void setWeekdayText(@Nullable List<String> list) {
        this.weekdayText = list;
    }

    @NotNull
    public String toString() {
        return "OpeningHours(openNow=" + this.openNow + ", periods=" + this.periods + ", weekdayText=" + this.weekdayText + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i4) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        Boolean bool = this.openNow;
        if (bool != null) {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        } else {
            parcel.writeInt(0);
        }
        List<PeriodsItem> list = this.periods;
        if (list != null) {
            parcel.writeInt(1);
            parcel.writeInt(list.size());
            for (PeriodsItem periodsItem : list) {
                if (periodsItem != null) {
                    parcel.writeInt(1);
                    periodsItem.writeToParcel(parcel, 0);
                } else {
                    parcel.writeInt(0);
                }
            }
        } else {
            parcel.writeInt(0);
        }
        parcel.writeStringList(this.weekdayText);
    }

    public OpeningHours(@Nullable Boolean bool, @Nullable List<PeriodsItem> list, @Nullable List<String> list2) {
        this.openNow = bool;
        this.periods = list;
        this.weekdayText = list2;
    }

    public /* synthetic */ OpeningHours(Boolean bool, List list, List list2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? null : bool, (i4 & 2) != 0 ? null : list, (i4 & 4) != 0 ? null : list2);
    }
}
