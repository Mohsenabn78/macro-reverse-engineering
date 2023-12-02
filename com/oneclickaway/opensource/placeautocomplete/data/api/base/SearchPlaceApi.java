package com.oneclickaway.opensource.placeautocomplete.data.api.base;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.oneclickaway.opensource.placeautocomplete.data.api.bean.place_details.PlacesDetailsResponse;
import com.oneclickaway.opensource.placeautocomplete.data.api.bean.places_response.SearchResponse;
import io.reactivex.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.http.GET;
import retrofit2.http.Query;

/* compiled from: SearchPlaceApi.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0006H'J6\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0001\u0010\n\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\u000b\u001a\u00020\u00062\b\b\u0001\u0010\f\u001a\u00020\u0006H'¨\u0006\r"}, d2 = {"Lcom/oneclickaway/opensource/placeautocomplete/data/api/base/SearchPlaceApi;", "", "getPlaceDetailsFromPlaceId", "Lio/reactivex/Observable;", "Lcom/oneclickaway/opensource/placeautocomplete/data/api/bean/place_details/PlacesDetailsResponse;", "placeId", "", "apiKey", "getPlaceResults", "Lcom/oneclickaway/opensource/placeautocomplete/data/api/bean/places_response/SearchResponse;", "placeHint", FirebaseAnalytics.Param.LOCATION, "radius", "place_autocomplete_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes6.dex */
public interface SearchPlaceApi {
    @GET("details/json")
    @NotNull
    Observable<PlacesDetailsResponse> getPlaceDetailsFromPlaceId(@NotNull @Query("placeid") String str, @NotNull @Query("key") String str2);

    @GET("autocomplete/json")
    @NotNull
    Observable<SearchResponse> getPlaceResults(@NotNull @Query("input") String str, @NotNull @Query("key") String str2, @NotNull @Query("location") String str3, @NotNull @Query("radius") String str4);
}
