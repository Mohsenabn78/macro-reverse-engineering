package com.arlosoft.macrodroid.advert;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.OnBackPressedCallback;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.databinding.ActivityMacrodroidProAdvertBinding;
import com.arlosoft.macrodroid.extensions.ActivityExtensionsKt;
import com.arlosoft.macrodroid.extensions.StringExtensionsKt;
import com.arlosoft.macrodroid.extensions.ViewExtensionsKt;
import com.arlosoft.macrodroid.upgrade.base.BasePurchaseActivity;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MacroDroidProAdvertActivity.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes.dex */
public final class MacroDroidProAdvertActivity extends BasePurchaseActivity {

    /* renamed from: h  reason: collision with root package name */
    private ActivityMacrodroidProAdvertBinding f5645h;
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    private final String f5646i = "pro_advert";
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private Intent f5647j;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: MacroDroidProAdvertActivity.kt */
    @SourceDebugExtension({"SMAP\nMacroDroidProAdvertActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MacroDroidProAdvertActivity.kt\ncom/arlosoft/macrodroid/advert/MacroDroidProAdvertActivity$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,97:1\n1#2:98\n*E\n"})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void showProAdvert(@NotNull Activity activity, boolean z3, @Nullable Intent intent) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intent intent2 = new Intent(activity, MacroDroidProAdvertActivity.class);
            intent2.putExtra("has_replaced_real_advert", z3);
            if (intent != null) {
                intent2.putExtra("next_intent", intent);
            }
            activity.startActivity(intent2);
        }
    }

    /* compiled from: MacroDroidProAdvertActivity.kt */
    /* loaded from: classes.dex */
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
                MacroDroidProAdvertActivity.this.s();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: MacroDroidProAdvertActivity.kt */
    /* loaded from: classes.dex */
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
                MacroDroidProAdvertActivity.this.finish();
                Intent intent = MacroDroidProAdvertActivity.this.f5647j;
                if (intent != null) {
                    MacroDroidProAdvertActivity.this.startActivity(intent);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @JvmStatic
    public static final void showProAdvert(@NotNull Activity activity, boolean z3, @Nullable Intent intent) {
        Companion.showProAdvert(activity, z3, intent);
    }

    @Override // com.arlosoft.macrodroid.upgrade.base.BasePurchaseActivity
    @NotNull
    public String getAnalyticsPuchaseSource() {
        return this.f5646i;
    }

    @Override // com.arlosoft.macrodroid.upgrade.base.BasePurchaseActivity
    public void logSpecificPurchaseAnalytics() {
        FirebaseAnalyticsEventLogger.logProAdvertPurchase();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity, com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        ActivityMacrodroidProAdvertBinding inflate = ActivityMacrodroidProAdvertBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater)");
        this.f5645h = inflate;
        ActivityMacrodroidProAdvertBinding activityMacrodroidProAdvertBinding = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        setContentView(inflate.getRoot());
        ActivityExtensionsKt.makeStatusBarTransparent(this);
        q();
        this.f5647j = (Intent) getIntent().getParcelableExtra("next_intent");
        FirebaseAnalyticsEventLogger.INSTANCE.logMacroDroidProAdvertShown(getIntent().getBooleanExtra("has_replaced_real_advert", false));
        ActivityMacrodroidProAdvertBinding activityMacrodroidProAdvertBinding2 = this.f5645h;
        if (activityMacrodroidProAdvertBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMacrodroidProAdvertBinding2 = null;
        }
        Button button = activityMacrodroidProAdvertBinding2.upgradeNowButton;
        Intrinsics.checkNotNullExpressionValue(button, "binding.upgradeNowButton");
        ViewExtensionsKt.onClick$default(button, null, new a(null), 1, null);
        ActivityMacrodroidProAdvertBinding activityMacrodroidProAdvertBinding3 = this.f5645h;
        if (activityMacrodroidProAdvertBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMacrodroidProAdvertBinding3 = null;
        }
        ImageView imageView = activityMacrodroidProAdvertBinding3.closeButton;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.closeButton");
        ViewExtensionsKt.onClick$default(imageView, null, new b(null), 1, null);
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback() { // from class: com.arlosoft.macrodroid.advert.MacroDroidProAdvertActivity$onCreate$3
            @Override // androidx.activity.OnBackPressedCallback
            public void handleOnBackPressed() {
            }
        });
        ActivityMacrodroidProAdvertBinding activityMacrodroidProAdvertBinding4 = this.f5645h;
        if (activityMacrodroidProAdvertBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityMacrodroidProAdvertBinding = activityMacrodroidProAdvertBinding4;
        }
        activityMacrodroidProAdvertBinding.macrodroidLabel.setText(StringExtensionsKt.setMacroDroidSizePaths("MACRODROID"));
        final long proAdvertCountDownSeconds = getRemoteConfig().getProAdvertCountDownSeconds() * 1000;
        new CountDownTimer(proAdvertCountDownSeconds) { // from class: com.arlosoft.macrodroid.advert.MacroDroidProAdvertActivity$onCreate$4
            @Override // android.os.CountDownTimer
            public void onFinish() {
                ActivityMacrodroidProAdvertBinding activityMacrodroidProAdvertBinding5;
                ActivityMacrodroidProAdvertBinding activityMacrodroidProAdvertBinding6;
                ActivityMacrodroidProAdvertBinding activityMacrodroidProAdvertBinding7;
                try {
                    activityMacrodroidProAdvertBinding5 = this.f5645h;
                    ActivityMacrodroidProAdvertBinding activityMacrodroidProAdvertBinding8 = null;
                    if (activityMacrodroidProAdvertBinding5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        activityMacrodroidProAdvertBinding5 = null;
                    }
                    TextView textView = activityMacrodroidProAdvertBinding5.countdownText;
                    Intrinsics.checkNotNullExpressionValue(textView, "binding.countdownText");
                    textView.setVisibility(8);
                    activityMacrodroidProAdvertBinding6 = this.f5645h;
                    if (activityMacrodroidProAdvertBinding6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        activityMacrodroidProAdvertBinding6 = null;
                    }
                    ImageView imageView2 = activityMacrodroidProAdvertBinding6.countDownBlockClose;
                    Intrinsics.checkNotNullExpressionValue(imageView2, "binding.countDownBlockClose");
                    imageView2.setVisibility(8);
                    activityMacrodroidProAdvertBinding7 = this.f5645h;
                    if (activityMacrodroidProAdvertBinding7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        activityMacrodroidProAdvertBinding8 = activityMacrodroidProAdvertBinding7;
                    }
                    ImageView imageView3 = activityMacrodroidProAdvertBinding8.closeButton;
                    Intrinsics.checkNotNullExpressionValue(imageView3, "binding.closeButton");
                    imageView3.setVisibility(0);
                } catch (Exception unused) {
                }
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j4) {
                ActivityMacrodroidProAdvertBinding activityMacrodroidProAdvertBinding5;
                try {
                    activityMacrodroidProAdvertBinding5 = this.f5645h;
                    if (activityMacrodroidProAdvertBinding5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        activityMacrodroidProAdvertBinding5 = null;
                    }
                    activityMacrodroidProAdvertBinding5.countdownText.setText(String.valueOf((j4 / 1000) + 1));
                } catch (Exception unused) {
                }
            }
        }.start();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        n();
    }

    @Override // com.arlosoft.macrodroid.upgrade.base.BasePurchaseActivity
    public void setPriceText(@NotNull String price) {
        Intrinsics.checkNotNullParameter(price, "price");
        ActivityMacrodroidProAdvertBinding activityMacrodroidProAdvertBinding = this.f5645h;
        if (activityMacrodroidProAdvertBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMacrodroidProAdvertBinding = null;
        }
        Button button = activityMacrodroidProAdvertBinding.upgradeNowButton;
        String string = getString(R.string.upgrade_now);
        button.setText(string + " - " + price);
    }
}
