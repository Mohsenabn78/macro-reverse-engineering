package com.arlosoft.macrodroid.triggers.webtrigger.api;

import io.reactivex.Completable;
import org.jetbrains.annotations.NotNull;
import retrofit2.http.POST;
import retrofit2.http.Query;

/* compiled from: WebTriggerApi.kt */
/* loaded from: classes3.dex */
public interface WebTriggerApi {
    @POST("/v1/urlTriggerDeviceIdPort")
    @NotNull
    Completable urlTriggerDeviceIdPort(@NotNull @Query("deviceId") String str, @NotNull @Query("passwordHash") String str2, @NotNull @Query("pushToken") String str3);

    @POST("/v1/urlTriggerExport")
    @NotNull
    Completable urlTriggerExport(@NotNull @Query("deviceId") String str, @NotNull @Query("passwordHash") String str2);

    @POST("/v1/urlTriggerToken")
    @NotNull
    Completable urlTriggerToken(@NotNull @Query("deviceId") String str, @NotNull @Query("alias") String str2, @NotNull @Query("pushToken") String str3, @NotNull @Query("company") String str4);
}
