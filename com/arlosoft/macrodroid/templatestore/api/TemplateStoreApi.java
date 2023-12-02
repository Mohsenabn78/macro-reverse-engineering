package com.arlosoft.macrodroid.templatestore.api;

import com.arlosoft.macrodroid.templatestore.model.Comment;
import com.arlosoft.macrodroid.templatestore.model.MacroTemplate;
import com.arlosoft.macrodroid.templatestore.model.PostCommentBody;
import com.arlosoft.macrodroid.templatestore.model.Report;
import com.arlosoft.macrodroid.templatestore.model.UploadMacroBody;
import com.arlosoft.macrodroid.templatestore.model.User;
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

/* compiled from: TemplateStoreApi.kt */
/* loaded from: classes3.dex */
public interface TemplateStoreApi {

    /* compiled from: TemplateStoreApi.kt */
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ Single getComments$default(TemplateStoreApi templateStoreApi, int i4, long j4, int i5, int i6, Object obj) {
            if (obj == null) {
                if ((i6 & 2) != 0) {
                    j4 = Long.MAX_VALUE;
                }
                if ((i6 & 4) != 0) {
                    i5 = 10;
                }
                return templateStoreApi.getComments(i4, j4, i5);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getComments");
        }

        public static /* synthetic */ Single getCommentsAfter$default(TemplateStoreApi templateStoreApi, int i4, long j4, int i5, int i6, Object obj) {
            if (obj == null) {
                if ((i6 & 2) != 0) {
                    j4 = Long.MAX_VALUE;
                }
                if ((i6 & 4) != 0) {
                    i5 = 10;
                }
                return templateStoreApi.getCommentsAfter(i4, j4, i5);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCommentsAfter");
        }

        public static /* synthetic */ Single getMacros$default(TemplateStoreApi templateStoreApi, String str, int i4, int i5, int i6, int i7, int i8, int i9, String str2, String str3, int i10, Object obj) {
            int i11;
            int i12;
            String str4;
            String str5;
            if (obj == null) {
                if ((i10 & 16) != 0) {
                    i11 = 0;
                } else {
                    i11 = i7;
                }
                if ((i10 & 32) != 0) {
                    i12 = 10;
                } else {
                    i12 = i8;
                }
                if ((i10 & 128) != 0) {
                    str4 = "";
                } else {
                    str4 = str2;
                }
                if ((i10 & 256) != 0) {
                    str5 = "en";
                } else {
                    str5 = str3;
                }
                return templateStoreApi.getMacros(str, i4, i5, i6, i11, i12, i9, str4, str5);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getMacros");
        }

        public static /* synthetic */ Object getMacrosCoroutine$default(TemplateStoreApi templateStoreApi, String str, int i4, int i5, int i6, int i7, int i8, int i9, String str2, String str3, Continuation continuation, int i10, Object obj) {
            int i11;
            int i12;
            String str4;
            String str5;
            if (obj == null) {
                if ((i10 & 16) != 0) {
                    i11 = 0;
                } else {
                    i11 = i7;
                }
                if ((i10 & 32) != 0) {
                    i12 = 10;
                } else {
                    i12 = i8;
                }
                if ((i10 & 128) != 0) {
                    str4 = "";
                } else {
                    str4 = str2;
                }
                if ((i10 & 256) != 0) {
                    str5 = "en";
                } else {
                    str5 = str3;
                }
                return templateStoreApi.getMacrosCoroutine(str, i4, i5, i6, i11, i12, i9, str4, str5, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getMacrosCoroutine");
        }

        public static /* synthetic */ Single getUsersByRank$default(TemplateStoreApi templateStoreApi, String str, int i4, int i5, int i6, Object obj) {
            if (obj == null) {
                if ((i6 & 2) != 0) {
                    i4 = 0;
                }
                if ((i6 & 4) != 0) {
                    i5 = 10;
                }
                return templateStoreApi.getUsersByRank(str, i4, i5);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getUsersByRank");
        }
    }

    @POST("/v1/users")
    @NotNull
    Single<User> addUser(@Header("authorization") @NotNull String str, @NotNull @Query("username") String str2, @NotNull @Query("personalIdentifier") String str3, @NotNull @Query("description") String str4);

    @POST("/v1/users")
    @NotNull
    @Multipart
    Single<User> addUserWithImage(@Header("authorization") @NotNull String str, @NotNull @Query("username") String str2, @NotNull @Query("personalIdentifier") String str3, @NotNull @Query("description") String str4, @Nullable @Part MultipartBody.Part part);

    @DELETE("/v1/comments")
    @NotNull
    Completable deleteComment(@Header("authorization") @NotNull String str, @Query("commentId") int i4, @Query("macroId") int i5);

    @DELETE("/v1/macros")
    @NotNull
    Completable deleteMacro(@Header("authorization") @NotNull String str, @Query("macroId") int i4, @Query("userId") int i5);

    @DELETE("/v1/macros")
    @Nullable
    Object deleteMacroCoroutine(@Header("authorization") @NotNull String str, @Query("macroId") int i4, @Query("userId") int i5, @NotNull Continuation<? super Unit> continuation);

    @DELETE("/v1/reports")
    @Nullable
    Object deleteReports(@Header("authorization") @NotNull String str, @Query("macroId") int i4, @Query("userId") int i5, @NotNull Continuation<? super Unit> continuation);

    @DELETE("/v1/users")
    @NotNull
    Completable deleteUser(@Header("authorization") @NotNull String str, @Query("userId") int i4);

    @GET("/v1/comments")
    @NotNull
    Single<List<Comment>> getComments(@Query("macroId") int i4, @Query("timestampBefore") long j4, @Query("pageSize") int i5);

    @GET("/v1/comments")
    @NotNull
    Single<List<Comment>> getCommentsAfter(@Query("macroId") int i4, @Query("timestampAfter") long j4, @Query("pageSize") int i5);

    @GET("/v1/macros")
    @NotNull
    Single<List<MacroTemplate>> getMacros(@Header("authorization") @NotNull String str, @Query("userId") int i4, @Query("queryingUserId") int i5, @Query("categoryId") int i6, @Query("start") int i7, @Query("pageSize") int i8, @Query("orderBy") int i9, @NotNull @Query("searchTerm") String str2, @NotNull @Query("deviceLanguage") String str3);

    @GET("/v1/macros")
    @Nullable
    Object getMacrosCoroutine(@Header("authorization") @NotNull String str, @Query("userId") int i4, @Query("queryingUserId") int i5, @Query("categoryId") int i6, @Query("start") int i7, @Query("pageSize") int i8, @Query("orderBy") int i9, @NotNull @Query("searchTerm") String str2, @NotNull @Query("deviceLanguage") String str3, @NotNull Continuation<? super List<MacroTemplate>> continuation);

    @GET("/v1/reports")
    @Nullable
    Object getReports(@Query("macroId") int i4, @NotNull Continuation<? super List<Report>> continuation);

    @GET("/v1/users")
    @NotNull
    Single<User> getUserById(@Query("userId") int i4);

    @GET("/v1/users")
    @NotNull
    Single<User> getUserByPersonalIdentifier(@NotNull @Query("personalIdentifier") String str);

    @GET("/v1/userRank")
    @NotNull
    Single<List<User>> getUsersByRank(@Header("authorization") @NotNull String str, @Query("start") int i4, @Query("pageSize") int i5);

    @POST("/v1/comments")
    @NotNull
    Completable postComment(@Header("authorization") @NotNull String str, @Body @NotNull PostCommentBody postCommentBody);

    @POST("/v1/reports")
    @NotNull
    Completable reportMacro(@Query("macroId") int i4, @Query("userId") int i5, @Query("reasonCode") int i6, @NotNull @Query("reasonText") String str);

    @POST("/v1/userReports")
    @NotNull
    Completable reportUser(@Query("aboutUserId") int i4, @Query("fromUserId") int i5, @Query("reasonCode") int i6, @NotNull @Query("reasonText") String str);

    @POST("/v1/starMacro")
    @NotNull
    Completable starMacro(@Header("authorization") @NotNull String str, @Query("macroId") int i4, @Query("userId") int i5, @Query("addStar") boolean z3);

    @PUT("/v1/comments")
    @NotNull
    Completable updateComment(@Header("authorization") @NotNull String str, @Query("userId") int i4, @Query("commentId") int i5, @NotNull @Query("text") String str2);

    @PUT("/v1/macros")
    @NotNull
    Completable updateMacro(@Header("authorization") @NotNull String str, @Query("macroId") int i4, @Body @NotNull UploadMacroBody uploadMacroBody);

    @PUT("/v1/macros")
    @NotNull
    Completable updateMacroDescription(@Header("authorization") @NotNull String str, @Query("macroId") int i4, @NotNull @Query("description") String str2);

    @PUT("/v1/macros")
    @NotNull
    Completable updateMacroName(@Header("authorization") @NotNull String str, @Query("macroId") int i4, @NotNull @Query("name") String str2);

    @POST("/v1/userUpdate")
    @NotNull
    Single<User> updateUser(@Header("authorization") @NotNull String str, @Query("userId") int i4, @NotNull @Query("description") String str2);

    @POST("/v1/userUpdate")
    @NotNull
    @Multipart
    Single<User> updateUserWithImage(@Header("authorization") @NotNull String str, @Query("userId") int i4, @NotNull @Query("description") String str2, @NotNull @Part MultipartBody.Part part);

    @POST("/v1/macros")
    @NotNull
    Completable uploadMacro(@Header("authorization") @NotNull String str, @Body @NotNull UploadMacroBody uploadMacroBody);
}
