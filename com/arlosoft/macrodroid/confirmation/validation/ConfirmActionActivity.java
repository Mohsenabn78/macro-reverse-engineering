package com.arlosoft.macrodroid.confirmation.validation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.lifecycle.Observer;
import com.arlosoft.macrodroid.ExportImportActivity;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.databinding.ActivityValidatePurchaseBinding;
import com.arlosoft.macrodroid.extensions.ViewExtensionsKt;
import com.arlosoft.macrodroid.upgrade.base.BasePurchaseActivity;
import com.arlosoft.macrodroid.utils.UninstallHelper;
import javax.inject.Inject;
import kotlin.Function;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import me.drakeet.support.toast.ToastCompat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConfirmActionActivity.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class ConfirmActionActivity extends BasePurchaseActivity {
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    private final String f10121h = "validate_purchase";

    /* renamed from: i  reason: collision with root package name */
    private ActivityValidatePurchaseBinding f10122i;
    @Inject
    public ValidatePurchaseViewModel viewModel;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: ConfirmActionActivity.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void showActivity(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            activity.startActivity(new Intent(activity, ConfirmActionActivity.class));
        }
    }

    /* compiled from: ConfirmActionActivity.kt */
    /* loaded from: classes3.dex */
    static final class a extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        int label;

        a(Continuation<? super a> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new a(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ConfirmActionActivity.this.startActivity(new Intent(ConfirmActionActivity.this, ExportImportActivity.class));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: ConfirmActionActivity.kt */
    /* loaded from: classes3.dex */
    static final class b extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        int label;

        b(Continuation<? super b> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new b(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                UninstallHelper.uninstallMacroDroid(ConfirmActionActivity.this);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: ConfirmActionActivity.kt */
    /* loaded from: classes3.dex */
    static final class c extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        int label;

        c(Continuation<? super c> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new c(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ConfirmActionActivity confirmActionActivity = ConfirmActionActivity.this;
                ActivityValidatePurchaseBinding activityValidatePurchaseBinding = confirmActionActivity.f10122i;
                ActivityValidatePurchaseBinding activityValidatePurchaseBinding2 = null;
                if (activityValidatePurchaseBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityValidatePurchaseBinding = null;
                }
                String obj2 = activityValidatePurchaseBinding.emailAddress.getText().toString();
                ActivityValidatePurchaseBinding activityValidatePurchaseBinding3 = ConfirmActionActivity.this.f10122i;
                if (activityValidatePurchaseBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    activityValidatePurchaseBinding2 = activityValidatePurchaseBinding3;
                }
                confirmActionActivity.upgradeWithSerial(obj2, activityValidatePurchaseBinding2.serialCode.getText().toString());
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: ConfirmActionActivity.kt */
    /* loaded from: classes3.dex */
    static final class d extends Lambda implements Function1<Void, Unit> {
        d() {
            super(1);
        }

        public final void a(@Nullable Void r32) {
            ToastCompat.makeText(ConfirmActionActivity.this, (int) R.string.thanks_for_purchasing, 1).show();
            ConfirmActionActivity.this.finish();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r12) {
            a(r12);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: ConfirmActionActivity.kt */
    @SourceDebugExtension({"SMAP\nConfirmActionActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConfirmActionActivity.kt\ncom/arlosoft/macrodroid/confirmation/validation/ConfirmActionActivity$onCreate$5\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,89:1\n262#2,2:90\n*S KotlinDebug\n*F\n+ 1 ConfirmActionActivity.kt\ncom/arlosoft/macrodroid/confirmation/validation/ConfirmActionActivity$onCreate$5\n*L\n73#1:90,2\n*E\n"})
    /* loaded from: classes3.dex */
    static final class e extends Lambda implements Function1<Boolean, Unit> {
        e() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke2(bool);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(Boolean it) {
            ActivityValidatePurchaseBinding activityValidatePurchaseBinding = ConfirmActionActivity.this.f10122i;
            if (activityValidatePurchaseBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityValidatePurchaseBinding = null;
            }
            FrameLayout frameLayout = activityValidatePurchaseBinding.loadingBlocker;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.loadingBlocker");
            Intrinsics.checkNotNullExpressionValue(it, "it");
            frameLayout.setVisibility(it.booleanValue() ? 0 : 8);
        }
    }

    /* compiled from: ConfirmActionActivity.kt */
    /* loaded from: classes3.dex */
    static final class f implements Observer, FunctionAdapter {

        /* renamed from: a  reason: collision with root package name */
        private final /* synthetic */ Function1 f10123a;

        f(Function1 function) {
            Intrinsics.checkNotNullParameter(function, "function");
            this.f10123a = function;
        }

        public final boolean equals(@Nullable Object obj) {
            if (!(obj instanceof Observer) || !(obj instanceof FunctionAdapter)) {
                return false;
            }
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f10123a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f10123a.invoke(obj);
        }
    }

    @Override // com.arlosoft.macrodroid.upgrade.base.BasePurchaseActivity
    @NotNull
    public String getAnalyticsPuchaseSource() {
        return this.f10121h;
    }

    @NotNull
    public final ValidatePurchaseViewModel getViewModel() {
        ValidatePurchaseViewModel validatePurchaseViewModel = this.viewModel;
        if (validatePurchaseViewModel != null) {
            return validatePurchaseViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity, com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        ActivityValidatePurchaseBinding inflate = ActivityValidatePurchaseBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater)");
        this.f10122i = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        setContentView(inflate.getRoot());
        FirebaseAnalyticsEventLogger.logVerifyPurchaseScreenShown();
        ActivityValidatePurchaseBinding activityValidatePurchaseBinding = this.f10122i;
        if (activityValidatePurchaseBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityValidatePurchaseBinding = null;
        }
        Button button = activityValidatePurchaseBinding.exportMacrosButton;
        Intrinsics.checkNotNullExpressionValue(button, "binding.exportMacrosButton");
        ViewExtensionsKt.onClick$default(button, null, new a(null), 1, null);
        ActivityValidatePurchaseBinding activityValidatePurchaseBinding2 = this.f10122i;
        if (activityValidatePurchaseBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityValidatePurchaseBinding2 = null;
        }
        Button button2 = activityValidatePurchaseBinding2.uninstallButton;
        Intrinsics.checkNotNullExpressionValue(button2, "binding.uninstallButton");
        ViewExtensionsKt.onClick$default(button2, null, new b(null), 1, null);
        ActivityValidatePurchaseBinding activityValidatePurchaseBinding3 = this.f10122i;
        if (activityValidatePurchaseBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityValidatePurchaseBinding3 = null;
        }
        Button button3 = activityValidatePurchaseBinding3.upgradeWithSerialButton;
        Intrinsics.checkNotNullExpressionValue(button3, "binding.upgradeWithSerialButton");
        ViewExtensionsKt.onClick$default(button3, null, new c(null), 1, null);
        getViewModel().getPurchaseValidatedEvent().observe(this, new f(new d()));
        getViewModel().getLoadingBlockerActive().observe(this, new f(new e()));
    }

    @Override // com.arlosoft.macrodroid.upgrade.base.BasePurchaseActivity
    public void setPriceText(@NotNull String priceText) {
        Intrinsics.checkNotNullParameter(priceText, "priceText");
    }

    public final void setViewModel(@NotNull ValidatePurchaseViewModel validatePurchaseViewModel) {
        Intrinsics.checkNotNullParameter(validatePurchaseViewModel, "<set-?>");
        this.viewModel = validatePurchaseViewModel;
    }

    public final void upgradeWithSerial(@NotNull String email, @NotNull String serial) {
        boolean z3;
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(serial, "serial");
        boolean z4 = false;
        if (email.length() == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            ToastCompat.makeText(this, (int) R.string.action_share_location_enter_email, 1).show();
            return;
        }
        if (serial.length() == 0) {
            z4 = true;
        }
        if (z4) {
            ToastCompat.makeText(this, (int) R.string.invalid_serial, 1).show();
        } else {
            getViewModel().onUpgradeWithSerial(this, email, serial);
        }
    }
}
