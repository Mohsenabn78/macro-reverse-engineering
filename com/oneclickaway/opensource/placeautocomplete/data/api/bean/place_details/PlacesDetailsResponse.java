package com.oneclickaway.opensource.placeautocomplete.data.api.bean.place_details;

import androidx.core.app.NotificationCompat;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PlacesDetailsResponse.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003J5\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0007HÖ\u0001R(\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/oneclickaway/opensource/placeautocomplete/data/api/bean/place_details/PlacesDetailsResponse;", "", "result", "Lcom/oneclickaway/opensource/placeautocomplete/data/api/bean/place_details/PlaceDetails;", "htmlAttributions", "", NotificationCompat.CATEGORY_STATUS, "", "(Lcom/oneclickaway/opensource/placeautocomplete/data/api/bean/place_details/PlaceDetails;Ljava/util/List;Ljava/lang/String;)V", "getHtmlAttributions", "()Ljava/util/List;", "setHtmlAttributions", "(Ljava/util/List;)V", "getResult", "()Lcom/oneclickaway/opensource/placeautocomplete/data/api/bean/place_details/PlaceDetails;", "setResult", "(Lcom/oneclickaway/opensource/placeautocomplete/data/api/bean/place_details/PlaceDetails;)V", "getStatus", "()Ljava/lang/String;", "setStatus", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "place_autocomplete_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes6.dex */
public final class PlacesDetailsResponse {
    @SerializedName("html_attributions")
    @Nullable
    private List<? extends Object> htmlAttributions;
    @SerializedName("result")
    @Nullable
    private PlaceDetails result;
    @SerializedName(NotificationCompat.CATEGORY_STATUS)
    @Nullable
    private String status;

    public PlacesDetailsResponse() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static /* synthetic */ PlacesDetailsResponse copy$default(PlacesDetailsResponse placesDetailsResponse, PlaceDetails placeDetails, List list, String str, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            placeDetails = placesDetailsResponse.result;
        }
        if ((i4 & 2) != 0) {
            list = placesDetailsResponse.htmlAttributions;
        }
        if ((i4 & 4) != 0) {
            str = placesDetailsResponse.status;
        }
        return placesDetailsResponse.copy(placeDetails, list, str);
    }

    @Nullable
    public final PlaceDetails component1() {
        return this.result;
    }

    @Nullable
    public final List<Object> component2() {
        return this.htmlAttributions;
    }

    @Nullable
    public final String component3() {
        return this.status;
    }

    @NotNull
    public final PlacesDetailsResponse copy(@Nullable PlaceDetails placeDetails, @Nullable List<? extends Object> list, @Nullable String str) {
        return new PlacesDetailsResponse(placeDetails, list, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof PlacesDetailsResponse) {
                PlacesDetailsResponse placesDetailsResponse = (PlacesDetailsResponse) obj;
                if (!Intrinsics.areEqual(this.result, placesDetailsResponse.result) || !Intrinsics.areEqual(this.htmlAttributions, placesDetailsResponse.htmlAttributions) || !Intrinsics.areEqual(this.status, placesDetailsResponse.status)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @Nullable
    public final List<Object> getHtmlAttributions() {
        return this.htmlAttributions;
    }

    @Nullable
    public final PlaceDetails getResult() {
        return this.result;
    }

    @Nullable
    public final String getStatus() {
        return this.status;
    }

    public int hashCode() {
        int i4;
        int i5;
        PlaceDetails placeDetails = this.result;
        int i6 = 0;
        if (placeDetails != null) {
            i4 = placeDetails.hashCode();
        } else {
            i4 = 0;
        }
        int i7 = i4 * 31;
        List<? extends Object> list = this.htmlAttributions;
        if (list != null) {
            i5 = list.hashCode();
        } else {
            i5 = 0;
        }
        int i8 = (i7 + i5) * 31;
        String str = this.status;
        if (str != null) {
            i6 = str.hashCode();
        }
        return i8 + i6;
    }

    public final void setHtmlAttributions(@Nullable List<? extends Object> list) {
        this.htmlAttributions = list;
    }

    public final void setResult(@Nullable PlaceDetails placeDetails) {
        this.result = placeDetails;
    }

    public final void setStatus(@Nullable String str) {
        this.status = str;
    }

    @NotNull
    public String toString() {
        return "PlacesDetailsResponse(result=" + this.result + ", htmlAttributions=" + this.htmlAttributions + ", status=" + this.status + ")";
    }

    public PlacesDetailsResponse(@Nullable PlaceDetails placeDetails, @Nullable List<? extends Object> list, @Nullable String str) {
        this.result = placeDetails;
        this.htmlAttributions = list;
        this.status = str;
    }

    public /* synthetic */ PlacesDetailsResponse(PlaceDetails placeDetails, List list, String str, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? null : placeDetails, (i4 & 2) != 0 ? null : list, (i4 & 4) != 0 ? null : str);
    }
}
