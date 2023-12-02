package com.oneclickaway.opensource.placeautocomplete.data.api.bean.places_response;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: StructuredFormatting.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u0013\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003J5\u0010\u0011\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/oneclickaway/opensource/placeautocomplete/data/api/bean/places_response/StructuredFormatting;", "", "mainTextMatchedSubstrings", "", "Lcom/oneclickaway/opensource/placeautocomplete/data/api/bean/places_response/MainTextMatchedSubstringsItem;", "secondaryText", "", "mainText", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getMainText", "()Ljava/lang/String;", "getMainTextMatchedSubstrings", "()Ljava/util/List;", "getSecondaryText", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "place_autocomplete_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes6.dex */
public final class StructuredFormatting {
    @SerializedName("main_text")
    @Nullable
    private final String mainText;
    @SerializedName("main_text_matched_substrings")
    @Nullable
    private final List<MainTextMatchedSubstringsItem> mainTextMatchedSubstrings;
    @SerializedName("secondary_text")
    @Nullable
    private final String secondaryText;

    public StructuredFormatting() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static /* synthetic */ StructuredFormatting copy$default(StructuredFormatting structuredFormatting, List list, String str, String str2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            list = structuredFormatting.mainTextMatchedSubstrings;
        }
        if ((i4 & 2) != 0) {
            str = structuredFormatting.secondaryText;
        }
        if ((i4 & 4) != 0) {
            str2 = structuredFormatting.mainText;
        }
        return structuredFormatting.copy(list, str, str2);
    }

    @Nullable
    public final List<MainTextMatchedSubstringsItem> component1() {
        return this.mainTextMatchedSubstrings;
    }

    @Nullable
    public final String component2() {
        return this.secondaryText;
    }

    @Nullable
    public final String component3() {
        return this.mainText;
    }

    @NotNull
    public final StructuredFormatting copy(@Nullable List<MainTextMatchedSubstringsItem> list, @Nullable String str, @Nullable String str2) {
        return new StructuredFormatting(list, str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof StructuredFormatting) {
                StructuredFormatting structuredFormatting = (StructuredFormatting) obj;
                if (!Intrinsics.areEqual(this.mainTextMatchedSubstrings, structuredFormatting.mainTextMatchedSubstrings) || !Intrinsics.areEqual(this.secondaryText, structuredFormatting.secondaryText) || !Intrinsics.areEqual(this.mainText, structuredFormatting.mainText)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @Nullable
    public final String getMainText() {
        return this.mainText;
    }

    @Nullable
    public final List<MainTextMatchedSubstringsItem> getMainTextMatchedSubstrings() {
        return this.mainTextMatchedSubstrings;
    }

    @Nullable
    public final String getSecondaryText() {
        return this.secondaryText;
    }

    public int hashCode() {
        int i4;
        int i5;
        List<MainTextMatchedSubstringsItem> list = this.mainTextMatchedSubstrings;
        int i6 = 0;
        if (list != null) {
            i4 = list.hashCode();
        } else {
            i4 = 0;
        }
        int i7 = i4 * 31;
        String str = this.secondaryText;
        if (str != null) {
            i5 = str.hashCode();
        } else {
            i5 = 0;
        }
        int i8 = (i7 + i5) * 31;
        String str2 = this.mainText;
        if (str2 != null) {
            i6 = str2.hashCode();
        }
        return i8 + i6;
    }

    @NotNull
    public String toString() {
        return "StructuredFormatting(mainTextMatchedSubstrings=" + this.mainTextMatchedSubstrings + ", secondaryText=" + this.secondaryText + ", mainText=" + this.mainText + ")";
    }

    public StructuredFormatting(@Nullable List<MainTextMatchedSubstringsItem> list, @Nullable String str, @Nullable String str2) {
        this.mainTextMatchedSubstrings = list;
        this.secondaryText = str;
        this.mainText = str2;
    }

    public /* synthetic */ StructuredFormatting(List list, String str, String str2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? null : list, (i4 & 2) != 0 ? null : str, (i4 & 4) != 0 ? null : str2);
    }
}
