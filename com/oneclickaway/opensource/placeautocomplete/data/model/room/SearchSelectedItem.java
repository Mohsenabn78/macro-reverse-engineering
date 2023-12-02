package com.oneclickaway.opensource.placeautocomplete.data.model.room;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SearchSelectedItem.kt */
@Entity(tableName = "SearchSelectedItem")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J1\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\f¨\u0006 "}, d2 = {"Lcom/oneclickaway/opensource/placeautocomplete/data/model/room/SearchSelectedItem;", "", "placeId", "", "mainText", "secondaryText", "searchCurrentMilliseconds", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getMainText", "()Ljava/lang/String;", "setMainText", "(Ljava/lang/String;)V", "getPlaceId", "setPlaceId", "getSearchCurrentMilliseconds", "()J", "setSearchCurrentMilliseconds", "(J)V", "getSecondaryText", "setSecondaryText", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "place_autocomplete_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes6.dex */
public final class SearchSelectedItem {
    @NotNull
    private String mainText;
    @PrimaryKey
    @NotNull
    private String placeId;
    private long searchCurrentMilliseconds;
    @NotNull
    private String secondaryText;

    public SearchSelectedItem(@NotNull String placeId, @NotNull String mainText, @NotNull String secondaryText, long j4) {
        Intrinsics.checkParameterIsNotNull(placeId, "placeId");
        Intrinsics.checkParameterIsNotNull(mainText, "mainText");
        Intrinsics.checkParameterIsNotNull(secondaryText, "secondaryText");
        this.placeId = placeId;
        this.mainText = mainText;
        this.secondaryText = secondaryText;
        this.searchCurrentMilliseconds = j4;
    }

    @NotNull
    public static /* synthetic */ SearchSelectedItem copy$default(SearchSelectedItem searchSelectedItem, String str, String str2, String str3, long j4, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = searchSelectedItem.placeId;
        }
        if ((i4 & 2) != 0) {
            str2 = searchSelectedItem.mainText;
        }
        String str4 = str2;
        if ((i4 & 4) != 0) {
            str3 = searchSelectedItem.secondaryText;
        }
        String str5 = str3;
        if ((i4 & 8) != 0) {
            j4 = searchSelectedItem.searchCurrentMilliseconds;
        }
        return searchSelectedItem.copy(str, str4, str5, j4);
    }

    @NotNull
    public final String component1() {
        return this.placeId;
    }

    @NotNull
    public final String component2() {
        return this.mainText;
    }

    @NotNull
    public final String component3() {
        return this.secondaryText;
    }

    public final long component4() {
        return this.searchCurrentMilliseconds;
    }

    @NotNull
    public final SearchSelectedItem copy(@NotNull String placeId, @NotNull String mainText, @NotNull String secondaryText, long j4) {
        Intrinsics.checkParameterIsNotNull(placeId, "placeId");
        Intrinsics.checkParameterIsNotNull(mainText, "mainText");
        Intrinsics.checkParameterIsNotNull(secondaryText, "secondaryText");
        return new SearchSelectedItem(placeId, mainText, secondaryText, j4);
    }

    public boolean equals(@Nullable Object obj) {
        boolean z3;
        if (this != obj) {
            if (obj instanceof SearchSelectedItem) {
                SearchSelectedItem searchSelectedItem = (SearchSelectedItem) obj;
                if (Intrinsics.areEqual(this.placeId, searchSelectedItem.placeId) && Intrinsics.areEqual(this.mainText, searchSelectedItem.mainText) && Intrinsics.areEqual(this.secondaryText, searchSelectedItem.secondaryText)) {
                    if (this.searchCurrentMilliseconds == searchSelectedItem.searchCurrentMilliseconds) {
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

    @NotNull
    public final String getMainText() {
        return this.mainText;
    }

    @NotNull
    public final String getPlaceId() {
        return this.placeId;
    }

    public final long getSearchCurrentMilliseconds() {
        return this.searchCurrentMilliseconds;
    }

    @NotNull
    public final String getSecondaryText() {
        return this.secondaryText;
    }

    public int hashCode() {
        int i4;
        int i5;
        String str = this.placeId;
        int i6 = 0;
        if (str != null) {
            i4 = str.hashCode();
        } else {
            i4 = 0;
        }
        int i7 = i4 * 31;
        String str2 = this.mainText;
        if (str2 != null) {
            i5 = str2.hashCode();
        } else {
            i5 = 0;
        }
        int i8 = (i7 + i5) * 31;
        String str3 = this.secondaryText;
        if (str3 != null) {
            i6 = str3.hashCode();
        }
        long j4 = this.searchCurrentMilliseconds;
        return ((i8 + i6) * 31) + ((int) (j4 ^ (j4 >>> 32)));
    }

    public final void setMainText(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.mainText = str;
    }

    public final void setPlaceId(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.placeId = str;
    }

    public final void setSearchCurrentMilliseconds(long j4) {
        this.searchCurrentMilliseconds = j4;
    }

    public final void setSecondaryText(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.secondaryText = str;
    }

    @NotNull
    public String toString() {
        return "SearchSelectedItem(placeId=" + this.placeId + ", mainText=" + this.mainText + ", secondaryText=" + this.secondaryText + ", searchCurrentMilliseconds=" + this.searchCurrentMilliseconds + ")";
    }
}
