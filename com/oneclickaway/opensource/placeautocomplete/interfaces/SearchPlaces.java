package com.oneclickaway.opensource.placeautocomplete.interfaces;

import com.oneclickaway.opensource.placeautocomplete.data.api.bean.places_response.PredictionsItem;
import com.oneclickaway.opensource.placeautocomplete.utils.GroupStrategy;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SearchPlaces.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/oneclickaway/opensource/placeautocomplete/interfaces/SearchPlaces;", "", "PlaceItemSelectedListener", "RecentItemSelectedListener", "place_autocomplete_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes6.dex */
public interface SearchPlaces {

    /* compiled from: SearchPlaces.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/oneclickaway/opensource/placeautocomplete/interfaces/SearchPlaces$PlaceItemSelectedListener;", "", "onPlaceItemSelected", "", "candidateItem", "Lcom/oneclickaway/opensource/placeautocomplete/data/api/bean/places_response/PredictionsItem;", "place_autocomplete_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: classes6.dex */
    public interface PlaceItemSelectedListener {
        void onPlaceItemSelected(@Nullable PredictionsItem predictionsItem);
    }

    /* compiled from: SearchPlaces.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/oneclickaway/opensource/placeautocomplete/interfaces/SearchPlaces$RecentItemSelectedListener;", "", "onRecantsItemSelected", "", "savedItem", "Lcom/oneclickaway/opensource/placeautocomplete/utils/GroupStrategy$ListItem;", "place_autocomplete_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: classes6.dex */
    public interface RecentItemSelectedListener {
        void onRecantsItemSelected(@NotNull GroupStrategy.ListItem listItem);
    }
}
