package com.google.firebase.functions.ktx;

import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.FirebaseApp;
import com.google.firebase.functions.FirebaseFunctions;
import com.google.firebase.functions.HttpsCallableOptions;
import com.google.firebase.functions.HttpsCallableReference;
import com.google.firebase.ktx.Firebase;
import java.net.URL;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Functions.kt */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b\u001a\u001a\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0001\u001a\u0012\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\t\u001a\u00020\u0001\u001a+\u0010\n\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\f\u001a\u00020\u00012\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0002\b\u0011\u001a+\u0010\u0012\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00142\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0002\b\u0011\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0003*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0015"}, d2 = {"LIBRARY_NAME", "", "functions", "Lcom/google/firebase/functions/FirebaseFunctions;", "Lcom/google/firebase/ktx/Firebase;", "getFunctions", "(Lcom/google/firebase/ktx/Firebase;)Lcom/google/firebase/functions/FirebaseFunctions;", "app", "Lcom/google/firebase/FirebaseApp;", "regionOrCustomDomain", "getHttpsCallable", "Lcom/google/firebase/functions/HttpsCallableReference;", "name", "init", "Lkotlin/Function1;", "Lcom/google/firebase/functions/HttpsCallableOptions$Builder;", "", "Lkotlin/ExtensionFunctionType;", "getHttpsCallableFromUrl", ImagesContract.URL, "Ljava/net/URL;", "com.google.firebase-firebase-functions-ktx"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class FunctionsKt {
    @NotNull
    public static final String LIBRARY_NAME = "fire-fun-ktx";

    @NotNull
    public static final FirebaseFunctions functions(@NotNull Firebase firebase2, @NotNull String regionOrCustomDomain) {
        Intrinsics.checkNotNullParameter(firebase2, "<this>");
        Intrinsics.checkNotNullParameter(regionOrCustomDomain, "regionOrCustomDomain");
        FirebaseFunctions firebaseFunctions = FirebaseFunctions.getInstance(regionOrCustomDomain);
        Intrinsics.checkNotNullExpressionValue(firebaseFunctions, "getInstance(regionOrCustomDomain)");
        return firebaseFunctions;
    }

    @NotNull
    public static final FirebaseFunctions getFunctions(@NotNull Firebase firebase2) {
        Intrinsics.checkNotNullParameter(firebase2, "<this>");
        FirebaseFunctions firebaseFunctions = FirebaseFunctions.getInstance();
        Intrinsics.checkNotNullExpressionValue(firebaseFunctions, "getInstance()");
        return firebaseFunctions;
    }

    @NotNull
    public static final HttpsCallableReference getHttpsCallable(@NotNull FirebaseFunctions firebaseFunctions, @NotNull String name, @NotNull Function1<? super HttpsCallableOptions.Builder, Unit> init) {
        Intrinsics.checkNotNullParameter(firebaseFunctions, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(init, "init");
        HttpsCallableOptions.Builder builder = new HttpsCallableOptions.Builder();
        init.invoke(builder);
        HttpsCallableReference httpsCallable = firebaseFunctions.getHttpsCallable(name, builder.build());
        Intrinsics.checkNotNullExpressionValue(httpsCallable, "getHttpsCallable(name, builder.build())");
        return httpsCallable;
    }

    @NotNull
    public static final HttpsCallableReference getHttpsCallableFromUrl(@NotNull FirebaseFunctions firebaseFunctions, @NotNull URL url, @NotNull Function1<? super HttpsCallableOptions.Builder, Unit> init) {
        Intrinsics.checkNotNullParameter(firebaseFunctions, "<this>");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(init, "init");
        HttpsCallableOptions.Builder builder = new HttpsCallableOptions.Builder();
        init.invoke(builder);
        HttpsCallableReference httpsCallableFromUrl = firebaseFunctions.getHttpsCallableFromUrl(url, builder.build());
        Intrinsics.checkNotNullExpressionValue(httpsCallableFromUrl, "getHttpsCallableFromUrl(url, builder.build())");
        return httpsCallableFromUrl;
    }

    @NotNull
    public static final FirebaseFunctions functions(@NotNull Firebase firebase2, @NotNull FirebaseApp app) {
        Intrinsics.checkNotNullParameter(firebase2, "<this>");
        Intrinsics.checkNotNullParameter(app, "app");
        FirebaseFunctions firebaseFunctions = FirebaseFunctions.getInstance(app);
        Intrinsics.checkNotNullExpressionValue(firebaseFunctions, "getInstance(app)");
        return firebaseFunctions;
    }

    @NotNull
    public static final FirebaseFunctions functions(@NotNull Firebase firebase2, @NotNull FirebaseApp app, @NotNull String regionOrCustomDomain) {
        Intrinsics.checkNotNullParameter(firebase2, "<this>");
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(regionOrCustomDomain, "regionOrCustomDomain");
        FirebaseFunctions firebaseFunctions = FirebaseFunctions.getInstance(app, regionOrCustomDomain);
        Intrinsics.checkNotNullExpressionValue(firebaseFunctions, "getInstance(app, regionOrCustomDomain)");
        return firebaseFunctions;
    }
}
