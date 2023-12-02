package com.arlosoft.macrodroid.videos;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.app.di.annotations.ApplicationContext;
import com.arlosoft.macrodroid.videos.api.VideosApi;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.inject.Inject;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VideoDataRepository.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class VideoDataRepository {
    @NotNull
    public static final String KEY_VIDEO_DATA = "video_data";
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Context f16417a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final VideosApi f16418b;

    /* renamed from: c  reason: collision with root package name */
    private final SharedPreferences f16419c;

    /* renamed from: d  reason: collision with root package name */
    private final Gson f16420d;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: VideoDataRepository.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VideoDataRepository.kt */
    /* loaded from: classes3.dex */
    public static final class a extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return VideoDataRepository.this.getVideoData(this);
        }
    }

    @Inject
    public VideoDataRepository(@ApplicationContext @NotNull Context context, @NotNull VideosApi api) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(api, "api");
        this.f16417a = context;
        this.f16418b = api;
        this.f16419c = context.getSharedPreferences("VideoData", 0);
        this.f16420d = new GsonBuilder().create();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0037  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getVideoData(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.arlosoft.macrodroid.videos.data.VideosData> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.arlosoft.macrodroid.videos.VideoDataRepository.a
            if (r0 == 0) goto L13
            r0 = r6
            com.arlosoft.macrodroid.videos.VideoDataRepository$a r0 = (com.arlosoft.macrodroid.videos.VideoDataRepository.a) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.arlosoft.macrodroid.videos.VideoDataRepository$a r0 = new com.arlosoft.macrodroid.videos.VideoDataRepository$a
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            java.lang.String r3 = "video_data"
            r4 = 1
            if (r2 == 0) goto L37
            if (r2 != r4) goto L2f
            java.lang.Object r0 = r0.L$0
            com.arlosoft.macrodroid.videos.VideoDataRepository r0 = (com.arlosoft.macrodroid.videos.VideoDataRepository) r0
            kotlin.ResultKt.throwOnFailure(r6)     // Catch: java.lang.Exception -> L5f
            goto L48
        L2f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L37:
            kotlin.ResultKt.throwOnFailure(r6)
            com.arlosoft.macrodroid.videos.api.VideosApi r6 = r5.f16418b     // Catch: java.lang.Exception -> L5e
            r0.L$0 = r5     // Catch: java.lang.Exception -> L5e
            r0.label = r4     // Catch: java.lang.Exception -> L5e
            java.lang.Object r6 = r6.getVideos(r0)     // Catch: java.lang.Exception -> L5e
            if (r6 != r1) goto L47
            return r1
        L47:
            r0 = r5
        L48:
            com.arlosoft.macrodroid.videos.data.VideosData r6 = (com.arlosoft.macrodroid.videos.data.VideosData) r6     // Catch: java.lang.Exception -> L5f
            com.google.gson.Gson r1 = r0.f16420d     // Catch: java.lang.Exception -> L5f
            java.lang.String r1 = r1.toJson(r6)     // Catch: java.lang.Exception -> L5f
            android.content.SharedPreferences r2 = r0.f16419c     // Catch: java.lang.Exception -> L5f
            android.content.SharedPreferences$Editor r2 = r2.edit()     // Catch: java.lang.Exception -> L5f
            android.content.SharedPreferences$Editor r1 = r2.putString(r3, r1)     // Catch: java.lang.Exception -> L5f
            r1.apply()     // Catch: java.lang.Exception -> L5f
            goto L71
        L5e:
            r0 = r5
        L5f:
            android.content.SharedPreferences r6 = r0.f16419c
            java.lang.String r1 = ""
            java.lang.String r6 = r6.getString(r3, r1)
            com.google.gson.Gson r0 = r0.f16420d
            java.lang.Class<com.arlosoft.macrodroid.videos.data.VideosData> r1 = com.arlosoft.macrodroid.videos.data.VideosData.class
            java.lang.Object r6 = r0.fromJson(r6, r1)
            com.arlosoft.macrodroid.videos.data.VideosData r6 = (com.arlosoft.macrodroid.videos.data.VideosData) r6
        L71:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.videos.VideoDataRepository.getVideoData(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
