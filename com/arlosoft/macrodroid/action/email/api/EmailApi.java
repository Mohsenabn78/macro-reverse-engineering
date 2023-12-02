package com.arlosoft.macrodroid.action.email.api;

import io.reactivex.Completable;
import model.EmailRequest;
import org.jetbrains.annotations.NotNull;
import retrofit2.http.Body;
import retrofit2.http.POST;

/* compiled from: EmailApi.kt */
/* loaded from: classes2.dex */
public interface EmailApi {
    @POST("/v1/sendEmail")
    @NotNull
    Completable sendEmail(@Body @NotNull EmailRequest emailRequest);
}
