package com.oneclickaway.opensource.placeautocomplete.data.api.bean.places_response;

import androidx.core.app.NotificationCompat;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SearchResponse.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0006HÆ\u0003J)\u0010\u000e\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/oneclickaway/opensource/placeautocomplete/data/api/bean/places_response/SearchResponse;", "", "predictions", "", "Lcom/oneclickaway/opensource/placeautocomplete/data/api/bean/places_response/PredictionsItem;", NotificationCompat.CATEGORY_STATUS, "", "(Ljava/util/List;Ljava/lang/String;)V", "getPredictions", "()Ljava/util/List;", "getStatus", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "place_autocomplete_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes6.dex */
public final class SearchResponse {
    @SerializedName("predictions")
    @Nullable
    private final List<PredictionsItem> predictions;
    @SerializedName(NotificationCompat.CATEGORY_STATUS)
    @Nullable
    private final String status;

    public SearchResponse() {
        this(null, null, 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static /* synthetic */ SearchResponse copy$default(SearchResponse searchResponse, List list, String str, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            list = searchResponse.predictions;
        }
        if ((i4 & 2) != 0) {
            str = searchResponse.status;
        }
        return searchResponse.copy(list, str);
    }

    @Nullable
    public final List<PredictionsItem> component1() {
        return this.predictions;
    }

    @Nullable
    public final String component2() {
        return this.status;
    }

    @NotNull
    public final SearchResponse copy(@Nullable List<PredictionsItem> list, @Nullable String str) {
        return new SearchResponse(list, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof SearchResponse) {
                SearchResponse searchResponse = (SearchResponse) obj;
                if (!Intrinsics.areEqual(this.predictions, searchResponse.predictions) || !Intrinsics.areEqual(this.status, searchResponse.status)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @Nullable
    public final List<PredictionsItem> getPredictions() {
        return this.predictions;
    }

    @Nullable
    public final String getStatus() {
        return this.status;
    }

    public int hashCode() {
        int i4;
        List<PredictionsItem> list = this.predictions;
        int i5 = 0;
        if (list != null) {
            i4 = list.hashCode();
        } else {
            i4 = 0;
        }
        int i6 = i4 * 31;
        String str = this.status;
        if (str != null) {
            i5 = str.hashCode();
        }
        return i6 + i5;
    }

    @NotNull
    public String toString() {
        return "SearchResponse(predictions=" + this.predictions + ", status=" + this.status + ")";
    }

    public SearchResponse(@Nullable List<PredictionsItem> list, @Nullable String str) {
        this.predictions = list;
        this.status = str;
    }

    public /* synthetic */ SearchResponse(List list, String str, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? null : list, (i4 & 2) != 0 ? null : str);
    }
}
