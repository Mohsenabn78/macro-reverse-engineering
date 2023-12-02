package com.arlosoft.macrodroid.plugins.api;

import com.arlosoft.macrodroid.plugins.data.PluginDetail;
import com.arlosoft.macrodroid.templatestore.model.Comment;
import com.arlosoft.macrodroid.templatestore.model.PluginPostCommentBody;
import io.reactivex.Completable;
import io.reactivex.Single;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import okhttp3.MultipartBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Query;

/* compiled from: PluginListApi.kt */
/* loaded from: classes3.dex */
public interface PluginListApi {

    /* compiled from: PluginListApi.kt */
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ Single getComments$default(PluginListApi pluginListApi, int i4, long j4, int i5, int i6, Object obj) {
            if (obj == null) {
                if ((i6 & 2) != 0) {
                    j4 = Long.MAX_VALUE;
                }
                if ((i6 & 4) != 0) {
                    i5 = 10;
                }
                return pluginListApi.getComments(i4, j4, i5);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getComments");
        }

        public static /* synthetic */ Single getPlugins$default(PluginListApi pluginListApi, int i4, int i5, int i6, int i7, String str, String str2, int i8, Object obj) {
            int i9;
            int i10;
            if (obj == null) {
                if ((i8 & 2) != 0) {
                    i9 = 0;
                } else {
                    i9 = i5;
                }
                if ((i8 & 4) != 0) {
                    i10 = 10;
                } else {
                    i10 = i6;
                }
                if ((i8 & 16) != 0) {
                    str = "en";
                }
                String str3 = str;
                if ((i8 & 32) != 0) {
                    str2 = "";
                }
                return pluginListApi.getPlugins(i4, i9, i10, i7, str3, str2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPlugins");
        }
    }

    @GET("/v1/checkPlugin")
    @Nullable
    Object checkPackage(@NotNull @Query("packageName") String str, @NotNull Continuation<? super Unit> continuation);

    @DELETE("/v1/plugin_comments")
    @NotNull
    Completable deleteComment(@Header("authorization") @NotNull String str, @Query("commentId") int i4, @Query("pluginId") int i5);

    @GET("/v1/plugin_comments")
    @NotNull
    Single<List<Comment>> getComments(@Query("pluginId") int i4, @Query("timestampBefore") long j4, @Query("pageSize") int i5);

    @GET("/v1/plugins")
    @NotNull
    Single<List<PluginDetail>> getPlugins(@Query("queryingUserId") int i4, @Query("start") int i5, @Query("pageSize") int i6, @Query("orderBy") int i7, @NotNull @Query("deviceLanguage") String str, @Nullable @Query("searchTerm") String str2);

    @POST("/v1/plugin_comments")
    @NotNull
    Completable postComment(@Header("authorization") @NotNull String str, @Body @NotNull PluginPostCommentBody pluginPostCommentBody);

    @POST("/v1/reportPlugin")
    @NotNull
    Completable reportPlugin(@Query("pluginId") int i4, @NotNull @Query("pluginName") String str, @Query("reasonCode") int i5);

    @POST("/v1/pluginsStarMacro")
    @NotNull
    Completable starPlugin(@Header("authorization") @NotNull String str, @Query("pluginId") int i4, @Query("userId") int i5, @Query("addStar") boolean z3);

    @PUT("/v1/plugin_comments")
    @NotNull
    Completable updateComment(@Header("authorization") @NotNull String str, @Query("userId") int i4, @Query("commentId") int i5, @NotNull @Query("text") String str2);

    @POST("/v1/pluginsIcon")
    @Nullable
    @Multipart
    Object uploadNonPlayStoreAppIcon(@Nullable @Part MultipartBody.Part part, @NotNull Continuation<? super String> continuation);

    @POST("/v1/plugins")
    @Nullable
    Object uploadPlayStorePlugin(@Header("authorization") @NotNull String str, @Body @NotNull UploadPluginBody uploadPluginBody, @NotNull Continuation<? super Unit> continuation);
}
