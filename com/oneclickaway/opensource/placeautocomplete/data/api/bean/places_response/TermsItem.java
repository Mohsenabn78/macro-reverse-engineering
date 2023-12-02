package com.oneclickaway.opensource.placeautocomplete.data.api.bean.places_response;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TermsItem.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/oneclickaway/opensource/placeautocomplete/data/api/bean/places_response/TermsItem;", "", TypedValues.CycleType.S_WAVE_OFFSET, "", "value", "", "(Ljava/lang/Integer;Ljava/lang/String;)V", "getOffset", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getValue", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/String;)Lcom/oneclickaway/opensource/placeautocomplete/data/api/bean/places_response/TermsItem;", "equals", "", "other", "hashCode", "toString", "place_autocomplete_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes6.dex */
public final class TermsItem {
    @SerializedName(TypedValues.CycleType.S_WAVE_OFFSET)
    @Nullable
    private final Integer offset;
    @SerializedName("value")
    @Nullable
    private final String value;

    public TermsItem() {
        this(null, null, 3, null);
    }

    @NotNull
    public static /* synthetic */ TermsItem copy$default(TermsItem termsItem, Integer num, String str, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            num = termsItem.offset;
        }
        if ((i4 & 2) != 0) {
            str = termsItem.value;
        }
        return termsItem.copy(num, str);
    }

    @Nullable
    public final Integer component1() {
        return this.offset;
    }

    @Nullable
    public final String component2() {
        return this.value;
    }

    @NotNull
    public final TermsItem copy(@Nullable Integer num, @Nullable String str) {
        return new TermsItem(num, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof TermsItem) {
                TermsItem termsItem = (TermsItem) obj;
                if (!Intrinsics.areEqual(this.offset, termsItem.offset) || !Intrinsics.areEqual(this.value, termsItem.value)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @Nullable
    public final Integer getOffset() {
        return this.offset;
    }

    @Nullable
    public final String getValue() {
        return this.value;
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
        String str = this.value;
        if (str != null) {
            i5 = str.hashCode();
        }
        return i6 + i5;
    }

    @NotNull
    public String toString() {
        return "TermsItem(offset=" + this.offset + ", value=" + this.value + ")";
    }

    public TermsItem(@Nullable Integer num, @Nullable String str) {
        this.offset = num;
        this.value = str;
    }

    public /* synthetic */ TermsItem(Integer num, String str, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? null : num, (i4 & 2) != 0 ? null : str);
    }
}
