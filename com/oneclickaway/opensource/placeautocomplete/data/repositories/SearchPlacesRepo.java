package com.oneclickaway.opensource.placeautocomplete.data.repositories;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.mlkit.nl.translate.TranslateLanguage;
import com.oneclickaway.opensource.placeautocomplete.data.api.base.RESTAPIManager;
import com.oneclickaway.opensource.placeautocomplete.data.api.bean.place_details.PlaceDetails;
import com.oneclickaway.opensource.placeautocomplete.data.api.bean.place_details.PlacesDetailsResponse;
import com.oneclickaway.opensource.placeautocomplete.data.api.bean.places_response.PredictionsItem;
import com.oneclickaway.opensource.placeautocomplete.data.api.bean.places_response.SearchResponse;
import com.oneclickaway.opensource.placeautocomplete.data.model.room.SearchSelectedItem;
import com.oneclickaway.opensource.placeautocomplete.data.room.RecentSearchesDAO;
import com.oneclickaway.opensource.placeautocomplete.data.room.RecentSearchesDB;
import com.oneclickaway.opensource.placeautocomplete.utils.Commons;
import com.oneclickaway.opensource.placeautocomplete.utils.LoadingManager;
import com.oneclickaway.opensource.placeautocomplete.utils.SearchPlacesStatusCodes;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.m;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SearchPlacesRepo.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0010J\u0014\u0010\u0017\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n0\u0018J\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\r0\u0018J\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\r0\u0018J\u000e\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0018J\u0012\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\n0\u0018J\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u0018J\n\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002J\u000e\u0010 \u001a\u00020\u00152\u0006\u0010!\u001a\u00020\"J&\u0010#\u001a\u00020\u00152\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020%2\u0006\u0010(\u001a\u00020%J\u0016\u0010)\u001a\u00020\u00152\u0006\u0010*\u001a\u00020%2\u0006\u0010&\u001a\u00020%R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004R\u001c\u0010\b\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/oneclickaway/opensource/placeautocomplete/data/repositories/SearchPlacesRepo;", "", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "getApplication", "()Landroid/app/Application;", "setApplication", "listOfSearchResults", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/oneclickaway/opensource/placeautocomplete/data/api/bean/places_response/PredictionsItem;", "loadingPlaceManager", "Lcom/oneclickaway/opensource/placeautocomplete/utils/LoadingManager;", "loadingPredictionManager", "placeDetails", "Lcom/oneclickaway/opensource/placeautocomplete/data/api/bean/place_details/PlaceDetails;", "recentSearches", "Lcom/oneclickaway/opensource/placeautocomplete/data/model/room/SearchSelectedItem;", "recentSearchesManager", "addSearchedItemToRecent", "", TranslateLanguage.ITALIAN, "getLiveListOfSearchResultsStream", "Landroidx/lifecycle/LiveData;", "getLoadingPlaceManager", "getLoadingPredictionManager", "getPlaceDetailsLiveDataStream", "getRecentSearches", "getRecentSearchesManager", "initDb", "Lcom/oneclickaway/opensource/placeautocomplete/data/room/RecentSearchesDB;", "requestListOfRecentSearches", "mContext", "Landroid/content/Context;", "requestListOfSearchResults", "placeHint", "", "apiKey", FirebaseAnalytics.Param.LOCATION, "radius", "requestPlaceDetails", "placeId", "place_autocomplete_release"}, k = 1, mv = {1, 1, 15})
@SuppressLint({"CheckResult"})
/* loaded from: classes6.dex */
public final class SearchPlacesRepo {
    @NotNull
    private Application application;
    private final MutableLiveData<List<PredictionsItem>> listOfSearchResults;
    private final MutableLiveData<LoadingManager> loadingPlaceManager;
    private final MutableLiveData<LoadingManager> loadingPredictionManager;
    private final MutableLiveData<PlaceDetails> placeDetails;
    private final MutableLiveData<List<SearchSelectedItem>> recentSearches;
    private final MutableLiveData<LoadingManager> recentSearchesManager;

    public SearchPlacesRepo(@NotNull Application application) {
        Intrinsics.checkParameterIsNotNull(application, "application");
        this.application = application;
        this.listOfSearchResults = new MutableLiveData<>();
        this.placeDetails = new MutableLiveData<>();
        this.recentSearches = new MutableLiveData<>();
        this.loadingPredictionManager = new MutableLiveData<>();
        this.loadingPlaceManager = new MutableLiveData<>();
        this.recentSearchesManager = new MutableLiveData<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RecentSearchesDB initDb() {
        return RecentSearchesDB.Companion.getInstance(this.application);
    }

    public final void addSearchedItemToRecent(@NotNull final PlaceDetails it) {
        Intrinsics.checkParameterIsNotNull(it, "it");
        Observable.fromCallable(new Callable() { // from class: com.oneclickaway.opensource.placeautocomplete.data.repositories.SearchPlacesRepo$addSearchedItemToRecent$1
            @Override // java.util.concurrent.Callable
            @Nullable
            public final Unit call() {
                RecentSearchesDB initDb;
                RecentSearchesDAO repDao;
                initDb = SearchPlacesRepo.this.initDb();
                if (initDb == null || (repDao = initDb.repDao()) == null) {
                    return null;
                }
                repDao.addSearchItem(new SearchSelectedItem(String.valueOf(it.getPlaceId()), String.valueOf(it.getName()), String.valueOf(it.getFormattedAddress()), System.currentTimeMillis()));
                return Unit.INSTANCE;
            }
        }).subscribeOn(Schedulers.computation()).observeOn(Schedulers.io()).subscribe(new DisposableObserver<Unit>() { // from class: com.oneclickaway.opensource.placeautocomplete.data.repositories.SearchPlacesRepo$addSearchedItemToRecent$2
            @Override // io.reactivex.Observer
            public void onComplete() {
                Log.e(SearchPlacesRepo$addSearchedItemToRecent$2.class.getSimpleName(), "addSearchedItemToRecent: Completed");
            }

            @Override // io.reactivex.Observer
            public void onError(@NotNull Throwable e4) {
                Intrinsics.checkParameterIsNotNull(e4, "e");
                Log.e(SearchPlacesRepo$addSearchedItemToRecent$2.class.getSimpleName(), "addSearchedItemToRecent: Error");
            }

            @Override // io.reactivex.Observer
            public void onNext(@NotNull Unit t3) {
                Intrinsics.checkParameterIsNotNull(t3, "t");
                Log.e(SearchPlacesRepo$addSearchedItemToRecent$2.class.getSimpleName(), "addSearchedItemToRecent: onNext");
            }
        });
    }

    @NotNull
    public final Application getApplication() {
        return this.application;
    }

    @NotNull
    public final LiveData<List<PredictionsItem>> getLiveListOfSearchResultsStream() {
        return this.listOfSearchResults;
    }

    @NotNull
    public final LiveData<LoadingManager> getLoadingPlaceManager() {
        return this.loadingPlaceManager;
    }

    @NotNull
    public final LiveData<LoadingManager> getLoadingPredictionManager() {
        return this.loadingPredictionManager;
    }

    @NotNull
    public final LiveData<PlaceDetails> getPlaceDetailsLiveDataStream() {
        return this.placeDetails;
    }

    @NotNull
    public final LiveData<List<SearchSelectedItem>> getRecentSearches() {
        return this.recentSearches;
    }

    @NotNull
    public final LiveData<LoadingManager> getRecentSearchesManager() {
        return this.recentSearchesManager;
    }

    public final void requestListOfRecentSearches(@NotNull final Context mContext) {
        Intrinsics.checkParameterIsNotNull(mContext, "mContext");
        this.recentSearchesManager.postValue(LoadingManager.STATE_REFRESHING);
        if (!Commons.INSTANCE.isNetworkConnected(this.application)) {
            this.recentSearchesManager.postValue(LoadingManager.STATE_NO_INTERNET);
        } else {
            Observable.fromCallable(new Callable() { // from class: com.oneclickaway.opensource.placeautocomplete.data.repositories.SearchPlacesRepo$requestListOfRecentSearches$1
                @Override // java.util.concurrent.Callable
                @Nullable
                public final List<SearchSelectedItem> call() {
                    RecentSearchesDAO repDao;
                    RecentSearchesDB companion = RecentSearchesDB.Companion.getInstance(mContext);
                    if (companion == null || (repDao = companion.repDao()) == null) {
                        return null;
                    }
                    return repDao.getRecentSearches();
                }
            }).subscribeOn(Schedulers.io()).observeOn(Schedulers.io()).subscribe(new Consumer<List<? extends SearchSelectedItem>>() { // from class: com.oneclickaway.opensource.placeautocomplete.data.repositories.SearchPlacesRepo$requestListOfRecentSearches$2
                @Override // io.reactivex.functions.Consumer
                public /* bridge */ /* synthetic */ void accept(List<? extends SearchSelectedItem> list) {
                    accept2((List<SearchSelectedItem>) list);
                }

                /* renamed from: accept  reason: avoid collision after fix types in other method */
                public final void accept2(@Nullable List<SearchSelectedItem> list) {
                    MutableLiveData mutableLiveData;
                    MutableLiveData mutableLiveData2;
                    MutableLiveData mutableLiveData3;
                    if (list == null || !list.isEmpty()) {
                        mutableLiveData = SearchPlacesRepo.this.recentSearchesManager;
                        mutableLiveData.postValue(LoadingManager.STATE_COMPLETED);
                        StringBuilder sb = new StringBuilder();
                        sb.append("");
                        sb.append(String.valueOf(list));
                        mutableLiveData2 = SearchPlacesRepo.this.recentSearches;
                        mutableLiveData2.postValue(list);
                        return;
                    }
                    mutableLiveData3 = SearchPlacesRepo.this.recentSearchesManager;
                    mutableLiveData3.postValue(LoadingManager.STATE_NO_RESULT);
                }
            });
        }
    }

    public final void requestListOfSearchResults(@NotNull String placeHint, @NotNull String apiKey, @NotNull String location, @NotNull String radius) {
        boolean isBlank;
        Intrinsics.checkParameterIsNotNull(placeHint, "placeHint");
        Intrinsics.checkParameterIsNotNull(apiKey, "apiKey");
        Intrinsics.checkParameterIsNotNull(location, "location");
        Intrinsics.checkParameterIsNotNull(radius, "radius");
        this.loadingPredictionManager.postValue(LoadingManager.STATE_REFRESHING);
        isBlank = m.isBlank(placeHint);
        if (isBlank) {
            this.loadingPredictionManager.postValue(LoadingManager.STATE_IDLE);
        } else if (!Commons.INSTANCE.isNetworkConnected(this.application)) {
            this.loadingPredictionManager.postValue(LoadingManager.STATE_NO_INTERNET);
        } else {
            RESTAPIManager.INSTANCE.getInstance().getPlaceResults(placeHint, apiKey, location, radius).filter(new Predicate<SearchResponse>() { // from class: com.oneclickaway.opensource.placeautocomplete.data.repositories.SearchPlacesRepo$requestListOfSearchResults$1
                @Override // io.reactivex.functions.Predicate
                public final boolean test(@NotNull SearchResponse it) {
                    MutableLiveData mutableLiveData;
                    Intrinsics.checkParameterIsNotNull(it, "it");
                    if (it.getPredictions() == null || !it.getPredictions().isEmpty()) {
                        return true;
                    }
                    mutableLiveData = SearchPlacesRepo.this.loadingPredictionManager;
                    mutableLiveData.postValue(LoadingManager.STATE_NO_RESULT);
                    return false;
                }
            }).subscribeOn(Schedulers.io()).observeOn(Schedulers.io()).map(new Function<T, R>() { // from class: com.oneclickaway.opensource.placeautocomplete.data.repositories.SearchPlacesRepo$requestListOfSearchResults$2
                @Override // io.reactivex.functions.Function
                @Nullable
                public final List<PredictionsItem> apply(@NotNull SearchResponse it) {
                    Intrinsics.checkParameterIsNotNull(it, "it");
                    return it.getPredictions();
                }
            }).subscribe(new DisposableObserver<List<? extends PredictionsItem>>() { // from class: com.oneclickaway.opensource.placeautocomplete.data.repositories.SearchPlacesRepo$requestListOfSearchResults$3
                @Override // io.reactivex.Observer
                public void onComplete() {
                    MutableLiveData mutableLiveData;
                    mutableLiveData = SearchPlacesRepo.this.loadingPredictionManager;
                    mutableLiveData.postValue(LoadingManager.STATE_COMPLETED);
                }

                @Override // io.reactivex.Observer
                public void onError(@NotNull Throwable e4) {
                    MutableLiveData mutableLiveData;
                    Intrinsics.checkParameterIsNotNull(e4, "e");
                    mutableLiveData = SearchPlacesRepo.this.loadingPredictionManager;
                    mutableLiveData.postValue(LoadingManager.STATE_ERROR);
                }

                @Override // io.reactivex.Observer
                public void onNext(@NotNull List<PredictionsItem> t3) {
                    MutableLiveData mutableLiveData;
                    Intrinsics.checkParameterIsNotNull(t3, "t");
                    mutableLiveData = SearchPlacesRepo.this.listOfSearchResults;
                    mutableLiveData.postValue(t3);
                }
            });
        }
    }

    public final void requestPlaceDetails(@NotNull String placeId, @NotNull String apiKey) {
        Intrinsics.checkParameterIsNotNull(placeId, "placeId");
        Intrinsics.checkParameterIsNotNull(apiKey, "apiKey");
        this.loadingPlaceManager.postValue(LoadingManager.STATE_REFRESHING);
        if (!Commons.INSTANCE.isNetworkConnected(this.application)) {
            this.loadingPlaceManager.postValue(LoadingManager.STATE_NO_INTERNET);
        } else {
            RESTAPIManager.INSTANCE.getInstance().getPlaceDetailsFromPlaceId(placeId, apiKey).observeOn(Schedulers.io()).subscribeOn(Schedulers.io()).filter(new Predicate<PlacesDetailsResponse>() { // from class: com.oneclickaway.opensource.placeautocomplete.data.repositories.SearchPlacesRepo$requestPlaceDetails$1
                @Override // io.reactivex.functions.Predicate
                public final boolean test(@NotNull PlacesDetailsResponse it) {
                    boolean equals$default;
                    Intrinsics.checkParameterIsNotNull(it, "it");
                    equals$default = m.equals$default(it.getStatus(), SearchPlacesStatusCodes.INSTANCE.getGOOGLE_SEARCH_RESULT_OK(), false, 2, null);
                    return equals$default;
                }
            }).map(new Function<T, R>() { // from class: com.oneclickaway.opensource.placeautocomplete.data.repositories.SearchPlacesRepo$requestPlaceDetails$2
                @Override // io.reactivex.functions.Function
                @Nullable
                public final PlaceDetails apply(@NotNull PlacesDetailsResponse it) {
                    Intrinsics.checkParameterIsNotNull(it, "it");
                    return it.getResult();
                }
            }).subscribe(new DisposableObserver<PlaceDetails>() { // from class: com.oneclickaway.opensource.placeautocomplete.data.repositories.SearchPlacesRepo$requestPlaceDetails$3
                @Override // io.reactivex.Observer
                public void onComplete() {
                    MutableLiveData mutableLiveData;
                    mutableLiveData = SearchPlacesRepo.this.loadingPlaceManager;
                    mutableLiveData.postValue(LoadingManager.STATE_COMPLETED);
                }

                @Override // io.reactivex.Observer
                public void onError(@NotNull Throwable e4) {
                    MutableLiveData mutableLiveData;
                    Intrinsics.checkParameterIsNotNull(e4, "e");
                    mutableLiveData = SearchPlacesRepo.this.loadingPlaceManager;
                    mutableLiveData.postValue(LoadingManager.STATE_ERROR);
                }

                @Override // io.reactivex.Observer
                public void onNext(@NotNull PlaceDetails it) {
                    MutableLiveData mutableLiveData;
                    Intrinsics.checkParameterIsNotNull(it, "it");
                    mutableLiveData = SearchPlacesRepo.this.placeDetails;
                    mutableLiveData.postValue(it);
                    SearchPlacesRepo.this.addSearchedItemToRecent(it);
                }
            });
        }
    }

    public final void setApplication(@NotNull Application application) {
        Intrinsics.checkParameterIsNotNull(application, "<set-?>");
        this.application = application;
    }
}
