package com.arlosoft.macrodroid.commercial.api;

import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.POST;
import retrofit2.http.Query;

/* compiled from: CommercialApi.kt */
/* loaded from: classes3.dex */
public interface CommercialApi {
    @POST("/v1/registerDevice")
    @Nullable
    Object registerDevice(@NotNull @Query("company") String str, @NotNull @Query("deviceId") String str2, @NotNull Continuation<? super Boolean> continuation);
}
