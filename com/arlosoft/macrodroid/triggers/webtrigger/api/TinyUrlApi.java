package com.arlosoft.macrodroid.triggers.webtrigger.api;

import io.reactivex.Single;
import org.jetbrains.annotations.NotNull;
import retrofit2.http.POST;
import retrofit2.http.Query;

/* compiled from: TinyUrlApi.kt */
/* loaded from: classes3.dex */
public interface TinyUrlApi {
    @POST("/api-create.php")
    @NotNull
    Single<String> urlTriggerToken(@NotNull @Query("url") String str);
}
