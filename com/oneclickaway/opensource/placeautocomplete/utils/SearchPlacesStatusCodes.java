package com.oneclickaway.opensource.placeautocomplete.utils;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SearchPlacesStatusCodes.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0016\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006¨\u0006\u0015"}, d2 = {"Lcom/oneclickaway/opensource/placeautocomplete/utils/SearchPlacesStatusCodes;", "", "()V", "CONFIG", "", "getCONFIG", "()Ljava/lang/String;", "CURRENT_LOCATION", "getCURRENT_LOCATION", "ENCLOSE_RADIUS", "getENCLOSE_RADIUS", "GOOGLE_API_KEY", "getGOOGLE_API_KEY", "GOOGLE_SEARCH_RESULT_OK", "getGOOGLE_SEARCH_RESULT_OK", "PLACEHOLDER_TRANSITION", "getPLACEHOLDER_TRANSITION", "PLACE_DATA", "getPLACE_DATA", "SEARCH_TITLE", "getSEARCH_TITLE", "place_autocomplete_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes6.dex */
public final class SearchPlacesStatusCodes {
    public static final SearchPlacesStatusCodes INSTANCE = new SearchPlacesStatusCodes();
    @Nullable
    private static final String SEARCH_TITLE = SEARCH_TITLE;
    @Nullable
    private static final String SEARCH_TITLE = SEARCH_TITLE;
    @Nullable
    private static final String ENCLOSE_RADIUS = ENCLOSE_RADIUS;
    @Nullable
    private static final String ENCLOSE_RADIUS = ENCLOSE_RADIUS;
    @Nullable
    private static final String CURRENT_LOCATION = "location";
    @Nullable
    private static final String GOOGLE_API_KEY = GOOGLE_API_KEY;
    @Nullable
    private static final String GOOGLE_API_KEY = GOOGLE_API_KEY;
    @Nullable
    private static final String PLACE_DATA = PLACE_DATA;
    @Nullable
    private static final String PLACE_DATA = PLACE_DATA;
    @NotNull
    private static final String GOOGLE_SEARCH_RESULT_OK = GOOGLE_SEARCH_RESULT_OK;
    @NotNull
    private static final String GOOGLE_SEARCH_RESULT_OK = GOOGLE_SEARCH_RESULT_OK;
    @NotNull
    private static final String PLACEHOLDER_TRANSITION = PLACEHOLDER_TRANSITION;
    @NotNull
    private static final String PLACEHOLDER_TRANSITION = PLACEHOLDER_TRANSITION;
    @NotNull
    private static final String CONFIG = CONFIG;
    @NotNull
    private static final String CONFIG = CONFIG;

    private SearchPlacesStatusCodes() {
    }

    @NotNull
    public final String getCONFIG() {
        return CONFIG;
    }

    @Nullable
    public final String getCURRENT_LOCATION() {
        return CURRENT_LOCATION;
    }

    @Nullable
    public final String getENCLOSE_RADIUS() {
        return ENCLOSE_RADIUS;
    }

    @Nullable
    public final String getGOOGLE_API_KEY() {
        return GOOGLE_API_KEY;
    }

    @NotNull
    public final String getGOOGLE_SEARCH_RESULT_OK() {
        return GOOGLE_SEARCH_RESULT_OK;
    }

    @NotNull
    public final String getPLACEHOLDER_TRANSITION() {
        return PLACEHOLDER_TRANSITION;
    }

    @Nullable
    public final String getPLACE_DATA() {
        return PLACE_DATA;
    }

    @Nullable
    public final String getSEARCH_TITLE() {
        return SEARCH_TITLE;
    }
}
