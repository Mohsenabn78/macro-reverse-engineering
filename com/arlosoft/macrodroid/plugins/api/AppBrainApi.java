package com.arlosoft.macrodroid.plugins.api;

import com.arlosoft.macrodroid.plugins.data.AppBrainPackageInfo;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/* compiled from: AppBrainApi.kt */
/* loaded from: classes3.dex */
public interface AppBrainApi {
    @Headers({"Accept: application/json"})
    @GET("/v2/info/getapp")
    @Nullable
    Object getApp(@NotNull @Query("apikey") String str, @NotNull @Query("package") String str2, @NotNull Continuation<? super AppBrainPackageInfo> continuation);

    @Headers({"Accept: application/json"})
    @GET("/v2/info/search")
    @Nullable
    Object search(@NotNull @Query("apikey") String str, @NotNull @Query("query") String str2, @NotNull Continuation<? super AppBrainPackageInfo> continuation);
}
