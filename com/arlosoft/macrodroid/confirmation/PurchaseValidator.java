package com.arlosoft.macrodroid.confirmation;

import android.content.Context;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.action.email.api.UpgradeApi;
import com.arlosoft.macrodroid.app.di.annotations.ApplicationContext;
import com.arlosoft.macrodroid.extensions.StringExtensionsKt;
import com.arlosoft.macrodroid.settings.Settings;
import com.google.gson.Gson;
import javax.inject.Inject;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PurchaseValidator.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class PurchaseValidator {
    @NotNull
    public static final String SUBSCRIPTION_STATE_ACTIVE = "SUBSCRIPTION_STATE_ACTIVE";
    @NotNull
    public static final String SUBSCRIPTION_STATE_CANCELED = "SUBSCRIPTION_STATE_CANCELED";
    @NotNull
    public static final String SUBSCRIPTION_STATE_EXPIRED = "SUBSCRIPTION_STATE_EXPIRED";
    @NotNull
    public static final String SUBSCRIPTION_STATE_IN_GRACE_PERIOD = "SUBSCRIPTION_STATE_IN_GRACE_PERIOD";
    @NotNull
    public static final String SUBSCRIPTION_STATE_ON_HOLD = "SUBSCRIPTION_STATE_ON_HOLD";
    @NotNull
    public static final String SUBSCRIPTION_STATE_PAUSED = "SUBSCRIPTION_STATE_PAUSED";
    @NotNull
    public static final String SUBSCRIPTION_STATE_PENDING = "SUBSCRIPTION_STATE_PENDING";
    @NotNull
    public static final String SUBSCRIPTION_STATE_UNSPECIFIED = "SUBSCRIPTION_STATE_UNSPECIFIED";
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Context f10116a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final UpgradeApi f10117b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final Gson f10118c;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: PurchaseValidator.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PurchaseValidator.kt */
    /* loaded from: classes3.dex */
    public static final class a extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
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
            return PurchaseValidator.this.validateProUpgrade(null, null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PurchaseValidator.kt */
    /* loaded from: classes3.dex */
    public static final class b extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        b(Continuation<? super b> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PurchaseValidator.this.validateSubscription(null, null, this);
        }
    }

    @Inject
    public PurchaseValidator(@ApplicationContext @NotNull Context context, @NotNull UpgradeApi upgradeApi) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(upgradeApi, "upgradeApi");
        this.f10116a = context;
        this.f10117b = upgradeApi;
        this.f10118c = new Gson();
    }

    @NotNull
    public final Context getContext() {
        return this.f10116a;
    }

    @NotNull
    public final String getValidationCode(@NotNull String sku) {
        Intrinsics.checkNotNullParameter(sku, "sku");
        String extraValidationUniqueId = Settings.getExtraValidationUniqueId(this.f10116a);
        return StringExtensionsKt.sha256(sku + extraValidationUniqueId);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0092 A[Catch: Exception -> 0x00eb, TryCatch #0 {Exception -> 0x00eb, blocks: (B:12:0x0032, B:21:0x008c, B:23:0x0092, B:25:0x0098, B:27:0x00b4, B:29:0x00bf, B:17:0x006d), top: B:37:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b4 A[Catch: Exception -> 0x00eb, TryCatch #0 {Exception -> 0x00eb, blocks: (B:12:0x0032, B:21:0x008c, B:23:0x0092, B:25:0x0098, B:27:0x00b4, B:29:0x00bf, B:17:0x006d), top: B:37:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00bf A[Catch: Exception -> 0x00eb, TRY_LEAVE, TryCatch #0 {Exception -> 0x00eb, blocks: (B:12:0x0032, B:21:0x008c, B:23:0x0092, B:25:0x0098, B:27:0x00b4, B:29:0x00bf, B:17:0x006d), top: B:37:0x0021 }] */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object validateProUpgrade(@org.jetbrains.annotations.NotNull java.lang.String r7, @org.jetbrains.annotations.NotNull java.lang.String r8, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.arlosoft.macrodroid.upgrade.model.ProUserStatusCode> r9) {
        /*
            Method dump skipped, instructions count: 255
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.confirmation.PurchaseValidator.validateProUpgrade(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0093 A[Catch: Exception -> 0x013a, TryCatch #0 {Exception -> 0x013a, blocks: (B:12:0x002d, B:21:0x008d, B:23:0x0093, B:25:0x0099, B:27:0x00b5, B:30:0x00c3, B:33:0x00d0, B:34:0x00ff, B:35:0x0127, B:17:0x0068), top: B:40:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b5 A[Catch: Exception -> 0x013a, TRY_LEAVE, TryCatch #0 {Exception -> 0x013a, blocks: (B:12:0x002d, B:21:0x008d, B:23:0x0093, B:25:0x0099, B:27:0x00b5, B:30:0x00c3, B:33:0x00d0, B:34:0x00ff, B:35:0x0127, B:17:0x0068), top: B:40:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0127 A[Catch: Exception -> 0x013a, TRY_LEAVE, TryCatch #0 {Exception -> 0x013a, blocks: (B:12:0x002d, B:21:0x008d, B:23:0x0093, B:25:0x0099, B:27:0x00b5, B:30:0x00c3, B:33:0x00d0, B:34:0x00ff, B:35:0x0127, B:17:0x0068), top: B:40:0x0021 }] */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object validateSubscription(@org.jetbrains.annotations.NotNull java.lang.String r7, @org.jetbrains.annotations.NotNull java.lang.String r8, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.arlosoft.macrodroid.upgrade.model.SubscriptionCheckStatus> r9) {
        /*
            Method dump skipped, instructions count: 331
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.confirmation.PurchaseValidator.validateSubscription(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
