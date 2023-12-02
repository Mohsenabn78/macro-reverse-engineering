package com.arlosoft.macrodroid.translations.api;

import com.arlosoft.macrodroid.translations.data.TranslationData;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/* compiled from: OneSkyAppApi.kt */
/* loaded from: classes3.dex */
public interface OneSkyAppApi {
    @NotNull
    public static final String API_KEY = "1tlElroQgRxbbHOVXlvZ3WRJneeupimg";
    @NotNull
    public static final Companion Companion = Companion.f14303a;

    /* compiled from: OneSkyAppApi.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        @NotNull
        public static final String API_KEY = "1tlElroQgRxbbHOVXlvZ3WRJneeupimg";

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ Companion f14303a = new Companion();

        private Companion() {
        }
    }

    @Headers({"Accept: application/json", "content-type:  application/json"})
    @GET("/1/projects/28964/languages")
    @Nullable
    Object getLanguages(@NotNull @Query("api_key") String str, @Query("timestamp") long j4, @NotNull @Query("dev_hash") String str2, @NotNull Continuation<? super TranslationData> continuation);
}
