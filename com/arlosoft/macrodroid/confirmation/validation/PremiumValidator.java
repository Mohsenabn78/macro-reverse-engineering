package com.arlosoft.macrodroid.confirmation.validation;

import android.content.Context;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.action.email.api.UpgradeApi;
import com.arlosoft.macrodroid.app.di.annotations.ApplicationContext;
import com.arlosoft.macrodroid.extensions.StringExtensionsKt;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.templatestore.api.TemplateStoreApiKt;
import javax.inject.Inject;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PremiumValidator.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class PremiumValidator {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Context f10131a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final UpgradeApi f10132b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PremiumValidator.kt */
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
            return PremiumValidator.this.checkProWithServer(this);
        }
    }

    @Inject
    public PremiumValidator(@ApplicationContext @NotNull Context context, @NotNull UpgradeApi upgradeApi) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(upgradeApi, "upgradeApi");
        this.f10131a = context;
        this.f10132b = upgradeApi;
    }

    @Nullable
    public final Object checkExtraSubscriptionWithServer(@NotNull Continuation<? super Boolean> continuation) {
        String purchaseSku = Settings.getPurchaseSku(this.f10131a);
        String str = "";
        if (purchaseSku == null) {
            purchaseSku = "";
        }
        String purchaseToken = Settings.getPurchaseToken(this.f10131a);
        if (purchaseToken == null) {
            purchaseToken = "";
        }
        String upgradeSerial = Settings.getUpgradeSerial(this.f10131a);
        if (upgradeSerial != null) {
            str = upgradeSerial;
        }
        StringExtensionsKt.sha256(TemplateStoreApiKt.TEMPLATE_API_SALT + str + purchaseSku + purchaseToken);
        return Boxing.boxBoolean(true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0093, code lost:
        if (r10 != false) goto L41;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003b  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object checkProWithServer(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.arlosoft.macrodroid.upgrade.model.ProUserStatusCode> r10) {
        /*
            Method dump skipped, instructions count: 234
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.confirmation.validation.PremiumValidator.checkProWithServer(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
