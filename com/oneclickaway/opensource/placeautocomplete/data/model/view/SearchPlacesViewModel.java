package com.oneclickaway.opensource.placeautocomplete.data.model.view;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.oneclickaway.opensource.placeautocomplete.data.api.bean.place_details.PlaceDetails;
import com.oneclickaway.opensource.placeautocomplete.data.api.bean.places_response.PredictionsItem;
import com.oneclickaway.opensource.placeautocomplete.data.model.room.SearchSelectedItem;
import com.oneclickaway.opensource.placeautocomplete.data.repositories.SearchPlacesRepo;
import com.oneclickaway.opensource.placeautocomplete.utils.LoadingManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: SearchPlacesViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0007\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t0\bJ\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\bJ\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\bJ\u000e\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\bJ\u0012\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\t0\bJ\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\bJ\u0006\u0010\u0013\u001a\u00020\u0014J&\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0017J\u0016\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/oneclickaway/opensource/placeautocomplete/data/model/view/SearchPlacesViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "applicationContext", "Landroid/app/Application;", "(Landroid/app/Application;)V", "searchPlacesRepo", "Lcom/oneclickaway/opensource/placeautocomplete/data/repositories/SearchPlacesRepo;", "getLiveListOfSearchResultsStream", "Landroidx/lifecycle/LiveData;", "", "Lcom/oneclickaway/opensource/placeautocomplete/data/api/bean/places_response/PredictionsItem;", "getLoadingPlaceManager", "Lcom/oneclickaway/opensource/placeautocomplete/utils/LoadingManager;", "getLoadingPredictionManager", "getPlaceDetailsLiveDataStream", "Lcom/oneclickaway/opensource/placeautocomplete/data/api/bean/place_details/PlaceDetails;", "getRecentSearchesData", "Lcom/oneclickaway/opensource/placeautocomplete/data/model/room/SearchSelectedItem;", "getRecentSearchesManager", "requestListOfRecentSearches", "", "requestListOfSearchResults", "placeHint", "", "apiKey", FirebaseAnalytics.Param.LOCATION, "radius", "requestPlaceDetails", "placeId", "place_autocomplete_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes6.dex */
public final class SearchPlacesViewModel extends AndroidViewModel {
    private final Application applicationContext;
    private final SearchPlacesRepo searchPlacesRepo;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchPlacesViewModel(@NotNull Application applicationContext) {
        super(applicationContext);
        Intrinsics.checkParameterIsNotNull(applicationContext, "applicationContext");
        this.applicationContext = applicationContext;
        this.searchPlacesRepo = new SearchPlacesRepo(applicationContext);
    }

    @NotNull
    public final LiveData<List<PredictionsItem>> getLiveListOfSearchResultsStream() {
        return this.searchPlacesRepo.getLiveListOfSearchResultsStream();
    }

    @NotNull
    public final LiveData<LoadingManager> getLoadingPlaceManager() {
        return this.searchPlacesRepo.getLoadingPlaceManager();
    }

    @NotNull
    public final LiveData<LoadingManager> getLoadingPredictionManager() {
        return this.searchPlacesRepo.getLoadingPredictionManager();
    }

    @NotNull
    public final LiveData<PlaceDetails> getPlaceDetailsLiveDataStream() {
        return this.searchPlacesRepo.getPlaceDetailsLiveDataStream();
    }

    @NotNull
    public final LiveData<List<SearchSelectedItem>> getRecentSearchesData() {
        return this.searchPlacesRepo.getRecentSearches();
    }

    @NotNull
    public final LiveData<LoadingManager> getRecentSearchesManager() {
        return this.searchPlacesRepo.getRecentSearchesManager();
    }

    public final void requestListOfRecentSearches() {
        this.searchPlacesRepo.requestListOfRecentSearches(this.applicationContext);
    }

    public final void requestListOfSearchResults(@NotNull String placeHint, @NotNull String apiKey, @NotNull String location, @NotNull String radius) {
        Intrinsics.checkParameterIsNotNull(placeHint, "placeHint");
        Intrinsics.checkParameterIsNotNull(apiKey, "apiKey");
        Intrinsics.checkParameterIsNotNull(location, "location");
        Intrinsics.checkParameterIsNotNull(radius, "radius");
        this.searchPlacesRepo.requestListOfSearchResults(placeHint, apiKey, location, radius);
    }

    public final void requestPlaceDetails(@NotNull String placeId, @NotNull String apiKey) {
        Intrinsics.checkParameterIsNotNull(placeId, "placeId");
        Intrinsics.checkParameterIsNotNull(apiKey, "apiKey");
        this.searchPlacesRepo.requestPlaceDetails(placeId, apiKey);
    }
}
