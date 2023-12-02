package com.oneclickaway.opensource.placeautocomplete.data.api.bean.places_response;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MatchedSubstringsItem.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J&\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\t\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/oneclickaway/opensource/placeautocomplete/data/api/bean/places_response/MatchedSubstringsItem;", "", TypedValues.CycleType.S_WAVE_OFFSET, "", "length", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "getLength", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getOffset", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/oneclickaway/opensource/placeautocomplete/data/api/bean/places_response/MatchedSubstringsItem;", "equals", "", "other", "hashCode", "toString", "", "place_autocomplete_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes6.dex */
public final class MatchedSubstringsItem {
    @SerializedName("length")
    @Nullable
    private final Integer length;
    @SerializedName(TypedValues.CycleType.S_WAVE_OFFSET)
    @Nullable
    private final Integer offset;

    public MatchedSubstringsItem() {
        this(null, null, 3, null);
    }

    @NotNull
    public static /* synthetic */ MatchedSubstringsItem copy$default(MatchedSubstringsItem matchedSubstringsItem, Integer num, Integer num2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            num = matchedSubstringsItem.offset;
        }
        if ((i4 & 2) != 0) {
            num2 = matchedSubstringsItem.length;
        }
        return matchedSubstringsItem.copy(num, num2);
    }

    @Nullable
    public final Integer component1() {
        return this.offset;
    }

    @Nullable
    public final Integer component2() {
        return this.length;
    }

    @NotNull
    public final MatchedSubstringsItem copy(@Nullable Integer num, @Nullable Integer num2) {
        return new MatchedSubstringsItem(num, num2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof MatchedSubstringsItem) {
                MatchedSubstringsItem matchedSubstringsItem = (MatchedSubstringsItem) obj;
                if (!Intrinsics.areEqual(this.offset, matchedSubstringsItem.offset) || !Intrinsics.areEqual(this.length, matchedSubstringsItem.length)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @Nullable
    public final Integer getLength() {
        return this.length;
    }

    @Nullable
    public final Integer getOffset() {
        return this.offset;
    }

    public int hashCode() {
        int i4;
        Integer num = this.offset;
        int i5 = 0;
        if (num != null) {
            i4 = num.hashCode();
        } else {
            i4 = 0;
        }
        int i6 = i4 * 31;
        Integer num2 = this.length;
        if (num2 != null) {
            i5 = num2.hashCode();
        }
        return i6 + i5;
    }

    @NotNull
    public String toString() {
        return "MatchedSubstringsItem(offset=" + this.offset + ", length=" + this.length + ")";
    }

    public MatchedSubstringsItem(@Nullable Integer num, @Nullable Integer num2) {
        this.offset = num;
        this.length = num2;
    }

    public /* synthetic */ MatchedSubstringsItem(Integer num, Integer num2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? null : num, (i4 & 2) != 0 ? null : num2);
    }
}
