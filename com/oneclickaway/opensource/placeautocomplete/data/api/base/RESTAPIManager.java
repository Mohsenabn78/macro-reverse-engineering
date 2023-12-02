package com.oneclickaway.opensource.placeautocomplete.data.api.base;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.jetbrains.annotations.NotNull;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/* compiled from: RESTAPIManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\b\u0010\u0007\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/oneclickaway/opensource/placeautocomplete/data/api/base/RESTAPIManager;", "", "()V", "BASE_URL", "", "getInstance", "Lcom/oneclickaway/opensource/placeautocomplete/data/api/base/SearchPlaceApi;", "getOkhttpClient", "Lokhttp3/OkHttpClient;", "place_autocomplete_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes6.dex */
public final class RESTAPIManager {
    public static final RESTAPIManager INSTANCE = new RESTAPIManager();
    private static String BASE_URL = "https://maps.googleapis.com/maps/api/place/";

    private RESTAPIManager() {
    }

    private final OkHttpClient getOkhttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));
        builder.callTimeout(100L, TimeUnit.SECONDS);
        builder.retryOnConnectionFailure(true);
        OkHttpClient build = builder.build();
        Intrinsics.checkExpressionValueIsNotNull(build, "okhttpBuilder.build()");
        return build;
    }

    @NotNull
    public final SearchPlaceApi getInstance() {
        Object create = new Retrofit.Builder().client(getOkhttpClient()).baseUrl(BASE_URL).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create()).build().create(SearchPlaceApi.class);
        Intrinsics.checkExpressionValueIsNotNull(create, "retroFit.create(SearchPlaceApi::class.java)");
        return (SearchPlaceApi) create;
    }
}
