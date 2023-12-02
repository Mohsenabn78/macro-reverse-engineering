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
import com.arlosoft.macrodroid.databinding.ActivityMacrodroidProAdvert2Binding;
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

/* compiled from: MacroDroidProAdvertActivity2.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes.dex */
public final class MacroDroidProAdvertActivity2 extends BasePurchaseActivity {

    /* renamed from: h  reason: collision with root package name */
    private ActivityMacrodroidProAdvert2Binding f5649h;
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    private final String f5650i = "pro_advert_2";
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private Intent f5651j;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: MacroDroidProAdvertActivity2.kt */
    @SourceDebugExtension({"SMAP\nMacroDroidProAdvertActivity2.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MacroDroidProAdvertActivity2.kt\ncom/arlosoft/macrodroid/advert/MacroDroidProAdvertActivity2$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,117:1\n1#2:118\n*E\n"})
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
            Intent intent2 = new Intent(activity, MacroDroidProAdvertActivity2.class);
            intent2.putExtra("has_replaced_real_advert", z3);
            if (intent != null) {
                intent2.putExtra("next_intent", intent);
            }
            activity.startActivity(intent2);
        }

        @JvmStatic
        public final void showRewardAdvert(@NotNull Activity activity, int i4) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            activity.startActivityForResult(new Intent(activity, MacroDroidProAdvertActivity2.class), i4);
        }
    }

    /* compiled from: MacroDroidProAdvertActivity2.kt */
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
                MacroDroidProAdvertActivity2.this.s();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: MacroDroidProAdvertActivity2.kt */
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
                MacroDroidProAdvertActivity2.this.finish();
                Intent intent = MacroDroidProAdvertActivity2.this.f5651j;
                if (intent != null) {
                    MacroDroidProAdvertActivity2.this.startActivity(intent);
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

    @JvmStatic
    public static final void showRewardAdvert(@NotNull Activity activity, int i4) {
        Companion.showRewardAdvert(activity, i4);
    }

    private final void v() {
        int i4;
        String proAdvertImageType = getRemoteConfig().getProAdvertImageType();
        ActivityMacrodroidProAdvert2Binding activityMacrodroidProAdvert2Binding = this.f5649h;
        if (activityMacrodroidProAdvert2Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMacrodroidProAdvert2Binding = null;
        }
        ImageView imageView = activityMacrodroidProAdvert2Binding.logoImage;
        if (Intrinsics.areEqual(proAdvertImageType, "santa")) {
            i4 = R.drawable.macrodroid_santa;
        } else {
            i4 = R.drawable.macrodroid_crown;
        }
        imageView.setImageResource(i4);
    }

    @Override // com.arlosoft.macrodroid.upgrade.base.BasePurchaseActivity
    @NotNull
    public String getAnalyticsPuchaseSource() {
        return this.f5650i;
    }

    @Override // com.arlosoft.macrodroid.upgrade.base.BasePurchaseActivity
    public void logSpecificPurchaseAnalytics() {
        FirebaseAnalyticsEventLogger.logProAdvertPurchase();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity, com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        ActivityMacrodroidProAdvert2Binding inflate = ActivityMacrodroidProAdvert2Binding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater)");
        this.f5649h = inflate;
        ActivityMacrodroidProAdvert2Binding activityMacrodroidProAdvert2Binding = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        setContentView(inflate.getRoot());
        ActivityExtensionsKt.makeStatusBarTransparent(this);
        q();
        this.f5651j = (Intent) getIntent().getParcelableExtra("next_intent");
        FirebaseAnalyticsEventLogger.INSTANCE.logMacroDroidProAdvertShown(getIntent().getBooleanExtra("has_replaced_real_advert", false));
        ActivityMacrodroidProAdvert2Binding activityMacrodroidProAdvert2Binding2 = this.f5649h;
        if (activityMacrodroidProAdvert2Binding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMacrodroidProAdvert2Binding2 = null;
        }
        Button button = activityMacrodroidProAdvert2Binding2.upgradeNowButton;
        Intrinsics.checkNotNullExpressionValue(button, "binding.upgradeNowButton");
        ViewExtensionsKt.onClick$default(button, null, new a(null), 1, null);
        ActivityMacrodroidProAdvert2Binding activityMacrodroidProAdvert2Binding3 = this.f5649h;
        if (activityMacrodroidProAdvert2Binding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMacrodroidProAdvert2Binding3 = null;
        }
        ImageView imageView = activityMacrodroidProAdvert2Binding3.closeButton;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.closeButton");
        ViewExtensionsKt.onClick$default(imageView, null, new b(null), 1, null);
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback() { // from class: com.arlosoft.macrodroid.advert.MacroDroidProAdvertActivity2$onCreate$3
            @Override // androidx.activity.OnBackPressedCallback
            public void handleOnBackPressed() {
            }
        });
        ActivityMacrodroidProAdvert2Binding activityMacrodroidProAdvert2Binding4 = this.f5649h;
        if (activityMacrodroidProAdvert2Binding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityMacrodroidProAdvert2Binding = activityMacrodroidProAdvert2Binding4;
        }
        activityMacrodroidProAdvert2Binding.macrodroidLabel.setText(StringExtensionsKt.setMacroDroidSizePaths("MACRODROID"));
        v();
        final long proAdvertCountDownSeconds = getRemoteConfig().getProAdvertCountDownSeconds() * 1000;
        new CountDownTimer(proAdvertCountDownSeconds) { // from class: com.arlosoft.macrodroid.advert.MacroDroidProAdvertActivity2$onCreate$4
            @Override // android.os.CountDownTimer
            public void onFinish() {
                ActivityMacrodroidProAdvert2Binding activityMacrodroidProAdvert2Binding5;
                ActivityMacrodroidProAdvert2Binding activityMacrodroidProAdvert2Binding6;
                ActivityMacrodroidProAdvert2Binding activityMacrodroidProAdvert2Binding7;
                try {
                    activityMacrodroidProAdvert2Binding5 = this.f5649h;
                    ActivityMacrodroidProAdvert2Binding activityMacrodroidProAdvert2Binding8 = null;
                    if (activityMacrodroidProAdvert2Binding5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        activityMacrodroidProAdvert2Binding5 = null;
                    }
                    TextView textView = activityMacrodroidProAdvert2Binding5.countdownText;
                    Intrinsics.checkNotNullExpressionValue(textView, "binding.countdownText");
                    textView.setVisibility(8);
                    activityMacrodroidProAdvert2Binding6 = this.f5649h;
                    if (activityMacrodroidProAdvert2Binding6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        activityMacrodroidProAdvert2Binding6 = null;
                    }
                    ImageView imageView2 = activityMacrodroidProAdvert2Binding6.countDownBlockClose;
                    Intrinsics.checkNotNullExpressionValue(imageView2, "binding.countDownBlockClose");
                    imageView2.setVisibility(8);
                    activityMacrodroidProAdvert2Binding7 = this.f5649h;
                    if (activityMacrodroidProAdvert2Binding7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        activityMacrodroidProAdvert2Binding8 = activityMacrodroidProAdvert2Binding7;
                    }
                    ImageView imageView3 = activityMacrodroidProAdvert2Binding8.closeButton;
                    Intrinsics.checkNotNullExpressionValue(imageView3, "binding.closeButton");
                    imageView3.setVisibility(0);
                    this.setResult(-1);
                } catch (Exception unused) {
                }
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j4) {
                ActivityMacrodroidProAdvert2Binding activityMacrodroidProAdvert2Binding5;
                try {
                    activityMacrodroidProAdvert2Binding5 = this.f5649h;
                    if (activityMacrodroidProAdvert2Binding5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        activityMacrodroidProAdvert2Binding5 = null;
                    }
                    activityMacrodroidProAdvert2Binding5.countdownText.setText(String.valueOf((j4 / 1000) + 1));
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
        ActivityMacrodroidProAdvert2Binding activityMacrodroidProAdvert2Binding = this.f5649h;
        if (activityMacrodroidProAdvert2Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMacrodroidProAdvert2Binding = null;
        }
        Button button = activityMacrodroidProAdvert2Binding.upgradeNowButton;
        String string = getString(R.string.upgrade_now);
        button.setText(string + " - " + price);
    }
}
