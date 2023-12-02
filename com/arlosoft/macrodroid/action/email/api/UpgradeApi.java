package com.arlosoft.macrodroid.action.email.api;

import com.arlosoft.macrodroid.upgrade.model.ProUserStatus;
import com.arlosoft.macrodroid.upgrade.model.UpgradeResponse;
import io.reactivex.Single;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/* compiled from: UpgradeApi.kt */
/* loaded from: classes2.dex */
public interface UpgradeApi {
    @GET("/v1/activatePro")
    @NotNull
    Single<UpgradeResponse> activatePro(@Header("authorization") @NotNull String str, @NotNull @Query("email") String str2, @NotNull @Query("serial") String str3);

    @GET("/v1/activatePro")
    @Nullable
    Object activateProCoroutine(@Header("authorization") @NotNull String str, @NotNull @Query("email") String str2, @NotNull @Query("serial") String str3, @NotNull Continuation<? super UpgradeResponse> continuation);

    @GET("/v1/checkExtra")
    @Nullable
    Object checkExtra(@Header("authorization") @NotNull String str, @Nullable @Query("serial") String str2, @Nullable @Query("subscriptionId") String str3, @NotNull @Query("token") String str4, @NotNull Continuation<? super ProUserStatus> continuation);

    @GET("/v1/checkPro")
    @Nullable
    Object checkProUser(@Header("authorization") @NotNull String str, @Nullable @Query("serial") String str2, @Nullable @Query("subscriptionId") String str3, @NotNull @Query("token") String str4, @NotNull Continuation<? super ProUserStatus> continuation);
}
