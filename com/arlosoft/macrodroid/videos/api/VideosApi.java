package com.arlosoft.macrodroid.videos.api;

import com.arlosoft.macrodroid.videos.data.VideosData;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/* compiled from: VideosApi.kt */
/* loaded from: classes3.dex */
public interface VideosApi {
    @Headers({"Accept: application/json"})
    @GET("/videos.json")
    @Nullable
    Object getVideos(@NotNull Continuation<? super VideosData> continuation);
}
