package com.oneclickaway.opensource.placeautocomplete.data.api.bean.places_response;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PredictionsItem.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B}\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0005\u0012\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0005\u0012\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u001c\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0005HÆ\u0003J\u0013\u0010\u001d\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0005HÆ\u0003J\u0013\u0010\u001e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0081\u0001\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00052\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00052\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R \u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R \u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R \u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014¨\u0006*"}, d2 = {"Lcom/oneclickaway/opensource/placeautocomplete/data/api/bean/places_response/PredictionsItem;", "", "reference", "", "types", "", "matchedSubstrings", "Lcom/oneclickaway/opensource/placeautocomplete/data/api/bean/places_response/MatchedSubstringsItem;", "terms", "Lcom/oneclickaway/opensource/placeautocomplete/data/api/bean/places_response/TermsItem;", "structuredFormatting", "Lcom/oneclickaway/opensource/placeautocomplete/data/api/bean/places_response/StructuredFormatting;", "description", "id", "placeId", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lcom/oneclickaway/opensource/placeautocomplete/data/api/bean/places_response/StructuredFormatting;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "getId", "getMatchedSubstrings", "()Ljava/util/List;", "getPlaceId", "getReference", "getStructuredFormatting", "()Lcom/oneclickaway/opensource/placeautocomplete/data/api/bean/places_response/StructuredFormatting;", "getTerms", "getTypes", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "place_autocomplete_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes6.dex */
public final class PredictionsItem {
    @SerializedName("description")
    @Nullable
    private final String description;
    @SerializedName("id")
    @Nullable
    private final String id;
    @SerializedName("matched_substrings")
    @Nullable
    private final List<MatchedSubstringsItem> matchedSubstrings;
    @SerializedName("place_id")
    @Nullable
    private final String placeId;
    @SerializedName("reference")
    @Nullable
    private final String reference;
    @SerializedName("structured_formatting")
    @Nullable
    private final StructuredFormatting structuredFormatting;
    @SerializedName("terms")
    @Nullable
    private final List<TermsItem> terms;
    @SerializedName("types")
    @Nullable
    private final List<String> types;

    public PredictionsItem() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static /* synthetic */ PredictionsItem copy$default(PredictionsItem predictionsItem, String str, List list, List list2, List list3, StructuredFormatting structuredFormatting, String str2, String str3, String str4, int i4, Object obj) {
        String str5;
        List<String> list4;
        List<MatchedSubstringsItem> list5;
        List<TermsItem> list6;
        StructuredFormatting structuredFormatting2;
        String str6;
        String str7;
        String str8;
        if ((i4 & 1) != 0) {
            str5 = predictionsItem.reference;
        } else {
            str5 = str;
        }
        if ((i4 & 2) != 0) {
            list4 = predictionsItem.types;
        } else {
            list4 = list;
        }
        if ((i4 & 4) != 0) {
            list5 = predictionsItem.matchedSubstrings;
        } else {
            list5 = list2;
        }
        if ((i4 & 8) != 0) {
            list6 = predictionsItem.terms;
        } else {
            list6 = list3;
        }
        if ((i4 & 16) != 0) {
            structuredFormatting2 = predictionsItem.structuredFormatting;
        } else {
            structuredFormatting2 = structuredFormatting;
        }
        if ((i4 & 32) != 0) {
            str6 = predictionsItem.description;
        } else {
            str6 = str2;
        }
        if ((i4 & 64) != 0) {
            str7 = predictionsItem.id;
        } else {
            str7 = str3;
        }
        if ((i4 & 128) != 0) {
            str8 = predictionsItem.placeId;
        } else {
            str8 = str4;
        }
        return predictionsItem.copy(str5, list4, list5, list6, structuredFormatting2, str6, str7, str8);
    }

    @Nullable
    public final String component1() {
        return this.reference;
    }

    @Nullable
    public final List<String> component2() {
        return this.types;
    }

    @Nullable
    public final List<MatchedSubstringsItem> component3() {
        return this.matchedSubstrings;
    }

    @Nullable
    public final List<TermsItem> component4() {
        return this.terms;
    }

    @Nullable
    public final StructuredFormatting component5() {
        return this.structuredFormatting;
    }

    @Nullable
    public final String component6() {
        return this.description;
    }

    @Nullable
    public final String component7() {
        return this.id;
    }

    @Nullable
    public final String component8() {
        return this.placeId;
    }

    @NotNull
    public final PredictionsItem copy(@Nullable String str, @Nullable List<String> list, @Nullable List<MatchedSubstringsItem> list2, @Nullable List<TermsItem> list3, @Nullable StructuredFormatting structuredFormatting, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        return new PredictionsItem(str, list, list2, list3, structuredFormatting, str2, str3, str4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof PredictionsItem) {
                PredictionsItem predictionsItem = (PredictionsItem) obj;
                if (!Intrinsics.areEqual(this.reference, predictionsItem.reference) || !Intrinsics.areEqual(this.types, predictionsItem.types) || !Intrinsics.areEqual(this.matchedSubstrings, predictionsItem.matchedSubstrings) || !Intrinsics.areEqual(this.terms, predictionsItem.terms) || !Intrinsics.areEqual(this.structuredFormatting, predictionsItem.structuredFormatting) || !Intrinsics.areEqual(this.description, predictionsItem.description) || !Intrinsics.areEqual(this.id, predictionsItem.id) || !Intrinsics.areEqual(this.placeId, predictionsItem.placeId)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final List<MatchedSubstringsItem> getMatchedSubstrings() {
        return this.matchedSubstrings;
    }

    @Nullable
    public final String getPlaceId() {
        return this.placeId;
    }

    @Nullable
    public final String getReference() {
        return this.reference;
    }

    @Nullable
    public final StructuredFormatting getStructuredFormatting() {
        return this.structuredFormatting;
    }

    @Nullable
    public final List<TermsItem> getTerms() {
        return this.terms;
    }

    @Nullable
    public final List<String> getTypes() {
        return this.types;
    }

    public int hashCode() {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        String str = this.reference;
        int i11 = 0;
        if (str != null) {
            i4 = str.hashCode();
        } else {
            i4 = 0;
        }
        int i12 = i4 * 31;
        List<String> list = this.types;
        if (list != null) {
            i5 = list.hashCode();
        } else {
            i5 = 0;
        }
        int i13 = (i12 + i5) * 31;
        List<MatchedSubstringsItem> list2 = this.matchedSubstrings;
        if (list2 != null) {
            i6 = list2.hashCode();
        } else {
            i6 = 0;
        }
        int i14 = (i13 + i6) * 31;
        List<TermsItem> list3 = this.terms;
        if (list3 != null) {
            i7 = list3.hashCode();
        } else {
            i7 = 0;
        }
        int i15 = (i14 + i7) * 31;
        StructuredFormatting structuredFormatting = this.structuredFormatting;
        if (structuredFormatting != null) {
            i8 = structuredFormatting.hashCode();
        } else {
            i8 = 0;
        }
        int i16 = (i15 + i8) * 31;
        String str2 = this.description;
        if (str2 != null) {
            i9 = str2.hashCode();
        } else {
            i9 = 0;
        }
        int i17 = (i16 + i9) * 31;
        String str3 = this.id;
        if (str3 != null) {
            i10 = str3.hashCode();
        } else {
            i10 = 0;
        }
        int i18 = (i17 + i10) * 31;
        String str4 = this.placeId;
        if (str4 != null) {
            i11 = str4.hashCode();
        }
        return i18 + i11;
    }

    @NotNull
    public String toString() {
        return "PredictionsItem(reference=" + this.reference + ", types=" + this.types + ", matchedSubstrings=" + this.matchedSubstrings + ", terms=" + this.terms + ", structuredFormatting=" + this.structuredFormatting + ", description=" + this.description + ", id=" + this.id + ", placeId=" + this.placeId + ")";
    }

    public PredictionsItem(@Nullable String str, @Nullable List<String> list, @Nullable List<MatchedSubstringsItem> list2, @Nullable List<TermsItem> list3, @Nullable StructuredFormatting structuredFormatting, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        this.reference = str;
        this.types = list;
        this.matchedSubstrings = list2;
        this.terms = list3;
        this.structuredFormatting = structuredFormatting;
        this.description = str2;
        this.id = str3;
        this.placeId = str4;
    }

    public /* synthetic */ PredictionsItem(String str, List list, List list2, List list3, StructuredFormatting structuredFormatting, String str2, String str3, String str4, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? null : str, (i4 & 2) != 0 ? null : list, (i4 & 4) != 0 ? null : list2, (i4 & 8) != 0 ? null : list3, (i4 & 16) != 0 ? null : structuredFormatting, (i4 & 32) != 0 ? null : str2, (i4 & 64) != 0 ? null : str3, (i4 & 128) == 0 ? str4 : null);
    }
}
