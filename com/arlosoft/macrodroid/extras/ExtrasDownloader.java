package com.arlosoft.macrodroid.extras;

import android.content.Context;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.app.di.annotations.ApplicationContext;
import com.google.gson.Gson;
import javax.inject.Inject;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ExtrasDownloader.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class ExtrasDownloader {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Context f12006a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final Gson f12007b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ExtrasDownloader.kt */
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
            return ExtrasDownloader.this.activateExtraSubscription(null, null, null, this);
        }
    }

    @Inject
    public ExtrasDownloader(@ApplicationContext @NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f12006a = context;
        this.f12007b = new Gson();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00a6 A[Catch: Exception -> 0x00bf, TryCatch #0 {Exception -> 0x00bf, blocks: (B:12:0x002a, B:21:0x00a0, B:23:0x00a6, B:25:0x00ac, B:17:0x0042), top: B:30:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ab  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object activateExtraSubscription(@org.jetbrains.annotations.NotNull java.lang.String r9, @org.jetbrains.annotations.NotNull java.lang.String r10, @org.jetbrains.annotations.NotNull java.lang.String r11, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.arlosoft.macrodroid.extras.data.ExtraMacroSetData> r12) {
        /*
            r8 = this;
            boolean r0 = r12 instanceof com.arlosoft.macrodroid.extras.ExtrasDownloader.a
            if (r0 == 0) goto L13
            r0 = r12
            com.arlosoft.macrodroid.extras.ExtrasDownloader$a r0 = (com.arlosoft.macrodroid.extras.ExtrasDownloader.a) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.arlosoft.macrodroid.extras.ExtrasDownloader$a r0 = new com.arlosoft.macrodroid.extras.ExtrasDownloader$a
            r0.<init>(r12)
        L18:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L36
            if (r2 != r4) goto L2e
            java.lang.Object r9 = r0.L$0
            com.arlosoft.macrodroid.extras.ExtrasDownloader r9 = (com.arlosoft.macrodroid.extras.ExtrasDownloader) r9
            kotlin.ResultKt.throwOnFailure(r12)     // Catch: java.lang.Exception -> Lbf
            goto La0
        L2e:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L36:
            kotlin.ResultKt.throwOnFailure(r12)
            com.google.firebase.functions.FirebaseFunctions r12 = com.google.firebase.functions.FirebaseFunctions.getInstance()
            java.lang.String r2 = "getInstance()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r2)
            android.content.Context r2 = r8.f12006a     // Catch: java.lang.Exception -> Lbf
            r5 = 0
            java.lang.String r2 = com.arlosoft.macrodroid.settings.Settings.getUniqueId(r2, r5)     // Catch: java.lang.Exception -> Lbf
            r6 = 5
            kotlin.Pair[] r6 = new kotlin.Pair[r6]     // Catch: java.lang.Exception -> Lbf
            java.lang.String r7 = "sku_id"
            kotlin.Pair r9 = kotlin.TuplesKt.to(r7, r9)     // Catch: java.lang.Exception -> Lbf
            r6[r5] = r9     // Catch: java.lang.Exception -> Lbf
            java.lang.String r9 = "purchase_token"
            kotlin.Pair r9 = kotlin.TuplesKt.to(r9, r10)     // Catch: java.lang.Exception -> Lbf
            r6[r4] = r9     // Catch: java.lang.Exception -> Lbf
            java.lang.String r9 = "package_name"
            java.lang.String r10 = "com.arlosoft.macrodroid"
            kotlin.Pair r9 = kotlin.TuplesKt.to(r9, r10)     // Catch: java.lang.Exception -> Lbf
            r10 = 2
            r6[r10] = r9     // Catch: java.lang.Exception -> Lbf
            java.lang.String r9 = "key"
            kotlin.Pair r9 = kotlin.TuplesKt.to(r9, r2)     // Catch: java.lang.Exception -> Lbf
            r10 = 3
            r6[r10] = r9     // Catch: java.lang.Exception -> Lbf
            java.lang.String r9 = "macroSet"
            kotlin.Pair r9 = kotlin.TuplesKt.to(r9, r11)     // Catch: java.lang.Exception -> Lbf
            r10 = 4
            r6[r10] = r9     // Catch: java.lang.Exception -> Lbf
            java.util.Map r9 = kotlin.collections.MapsKt.mapOf(r6)     // Catch: java.lang.Exception -> Lbf
            java.lang.String r10 = "activateExtraSubscription"
            com.google.firebase.functions.HttpsCallableReference r10 = r12.getHttpsCallable(r10)     // Catch: java.lang.Exception -> Lbf
            java.util.concurrent.TimeUnit r11 = java.util.concurrent.TimeUnit.SECONDS     // Catch: java.lang.Exception -> Lbf
            r5 = 120(0x78, double:5.93E-322)
            com.google.firebase.functions.HttpsCallableReference r10 = r10.withTimeout(r5, r11)     // Catch: java.lang.Exception -> Lbf
            com.google.android.gms.tasks.Task r9 = r10.call(r9)     // Catch: java.lang.Exception -> Lbf
            java.lang.String r10 = "firebaseFunctions.getHtt…eUnit.SECONDS).call(data)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r10)     // Catch: java.lang.Exception -> Lbf
            r0.L$0 = r8     // Catch: java.lang.Exception -> Lbf
            r0.label = r4     // Catch: java.lang.Exception -> Lbf
            java.lang.Object r12 = kotlinx.coroutines.tasks.TasksKt.await(r9, r0)     // Catch: java.lang.Exception -> Lbf
            if (r12 != r1) goto L9f
            return r1
        L9f:
            r9 = r8
        La0:
            com.google.firebase.functions.HttpsCallableResult r12 = (com.google.firebase.functions.HttpsCallableResult) r12     // Catch: java.lang.Exception -> Lbf
            com.google.gson.Gson r9 = r9.f12007b     // Catch: java.lang.Exception -> Lbf
            if (r12 == 0) goto Lab
            java.lang.Object r10 = r12.getData()     // Catch: java.lang.Exception -> Lbf
            goto Lac
        Lab:
            r10 = r3
        Lac:
            java.lang.String r9 = r9.toJson(r10)     // Catch: java.lang.Exception -> Lbf
            com.google.gson.GsonBuilder r10 = com.arlosoft.macrodroid.gson.GsonUtils.getGsonBuilder()     // Catch: java.lang.Exception -> Lbf
            com.google.gson.Gson r10 = r10.create()     // Catch: java.lang.Exception -> Lbf
            java.lang.Class<com.arlosoft.macrodroid.extras.data.ExtraMacroSetData> r11 = com.arlosoft.macrodroid.extras.data.ExtraMacroSetData.class
            java.lang.Object r9 = r10.fromJson(r9, r11)     // Catch: java.lang.Exception -> Lbf
            return r9
        Lbf:
            r9 = move-exception
            r9.printStackTrace()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.extras.ExtrasDownloader.activateExtraSubscription(java.lang.String, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
