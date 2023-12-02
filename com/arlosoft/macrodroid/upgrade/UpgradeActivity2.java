package com.arlosoft.macrodroid.upgrade;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.ContextCompat;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.databinding.ActivityUpgrade2Binding;
import com.arlosoft.macrodroid.extensions.ViewExtensionsKt;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.upgrade.base.BasePurchaseActivity;
import java.util.Arrays;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: UpgradeActivity2.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nUpgradeActivity2.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UpgradeActivity2.kt\ncom/arlosoft/macrodroid/upgrade/UpgradeActivity2\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,139:1\n262#2,2:140\n262#2,2:142\n*S KotlinDebug\n*F\n+ 1 UpgradeActivity2.kt\ncom/arlosoft/macrodroid/upgrade/UpgradeActivity2\n*L\n69#1:140,2\n126#1:142,2\n*E\n"})
/* loaded from: classes3.dex */
public final class UpgradeActivity2 extends BasePurchaseActivity {

    /* renamed from: h  reason: collision with root package name */
    private ActivityUpgrade2Binding f15873h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private String f15874i;
    @NotNull

    /* renamed from: j  reason: collision with root package name */
    private final String f15875j = "upgrade_screen";

    /* renamed from: k  reason: collision with root package name */
    private final boolean f15876k = true;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private CountDownTimer f15877l;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: UpgradeActivity2.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void animateInUpgradeSceen(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            activity.startActivity(new Intent(activity, UpgradeActivity2.class));
            activity.overridePendingTransition(R.anim.up_from_bottom_slow, R.anim.no_change);
        }
    }

    /* compiled from: UpgradeActivity2.kt */
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
                UpgradeActivity2.this.s();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: UpgradeActivity2.kt */
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
                UpgradeActivity2.this.s();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: UpgradeActivity2.kt */
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
                UpgradeActivity2.this.x();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @JvmStatic
    public static final void animateInUpgradeSceen(@NotNull Activity activity) {
        Companion.animateInUpgradeSceen(activity);
    }

    private final void v() {
        int i4;
        boolean r4 = r();
        ActivityUpgrade2Binding activityUpgrade2Binding = this.f15873h;
        if (activityUpgrade2Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityUpgrade2Binding = null;
        }
        LinearLayout linearLayout = activityUpgrade2Binding.flashSaleContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.flashSaleContainer");
        if (r4) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        linearLayout.setVisibility(i4);
        if (r4) {
            final long flashSaleExpiry = getFlashSaleManager().getFlashSaleExpiry() - System.currentTimeMillis();
            CountDownTimer countDownTimer = this.f15877l;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            this.f15877l = new CountDownTimer(flashSaleExpiry) { // from class: com.arlosoft.macrodroid.upgrade.UpgradeActivity2$initFlashSaleState$1
                @Override // android.os.CountDownTimer
                public void onFinish() {
                    ActivityUpgrade2Binding activityUpgrade2Binding2;
                    String str;
                    ActivityUpgrade2Binding activityUpgrade2Binding3;
                    this.t(true);
                    activityUpgrade2Binding2 = this.f15873h;
                    ActivityUpgrade2Binding activityUpgrade2Binding4 = null;
                    if (activityUpgrade2Binding2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        activityUpgrade2Binding2 = null;
                    }
                    LinearLayout linearLayout2 = activityUpgrade2Binding2.flashSaleContainer;
                    Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.flashSaleContainer");
                    linearLayout2.setVisibility(8);
                    UpgradeActivity2 upgradeActivity2 = this;
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String string = upgradeActivity2.getString(R.string.only_this_price);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.only_this_price)");
                    Object[] objArr = new Object[1];
                    str = this.f15874i;
                    if (str == null) {
                        str = "";
                    }
                    objArr[0] = str;
                    String format = String.format(string, Arrays.copyOf(objArr, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                    upgradeActivity2.setPriceText(format);
                    activityUpgrade2Binding3 = this.f15873h;
                    if (activityUpgrade2Binding3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        activityUpgrade2Binding4 = activityUpgrade2Binding3;
                    }
                    TextView textView = activityUpgrade2Binding4.wasPrice;
                    Intrinsics.checkNotNullExpressionValue(textView, "binding.wasPrice");
                    textView.setVisibility(8);
                }

                @Override // android.os.CountDownTimer
                public void onTick(long j4) {
                    ActivityUpgrade2Binding activityUpgrade2Binding2;
                    String padStart;
                    String padStart2;
                    String padStart3;
                    long j5 = j4 / 1000;
                    activityUpgrade2Binding2 = this.f15873h;
                    if (activityUpgrade2Binding2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        activityUpgrade2Binding2 = null;
                    }
                    TextView textView = activityUpgrade2Binding2.flashSaleTimeRemaining;
                    padStart = StringsKt__StringsKt.padStart(String.valueOf(j5 / 3600), 2, '0');
                    long j6 = 60;
                    padStart2 = StringsKt__StringsKt.padStart(String.valueOf((j5 / j6) % j6), 2, '0');
                    padStart3 = StringsKt__StringsKt.padStart(String.valueOf(j5 % j6), 2, '0');
                    textView.setText(padStart + ":" + padStart2 + ":" + padStart3);
                }
            }.start();
        }
    }

    private final void w() {
        ActivityUpgrade2Binding activityUpgrade2Binding = this.f15873h;
        ActivityUpgrade2Binding activityUpgrade2Binding2 = null;
        if (activityUpgrade2Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityUpgrade2Binding = null;
        }
        activityUpgrade2Binding.recyclerView.setAdapter(new UpgradeItemsAdapter(UpgradeBlurbItemKt.getUpgradeBlurbItems()));
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.upgrade_item_divider);
        Intrinsics.checkNotNull(drawable);
        DividerItemDecorator dividerItemDecorator = new DividerItemDecorator(drawable);
        ActivityUpgrade2Binding activityUpgrade2Binding3 = this.f15873h;
        if (activityUpgrade2Binding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityUpgrade2Binding2 = activityUpgrade2Binding3;
        }
        activityUpgrade2Binding2.recyclerView.addItemDecoration(dividerItemDecorator);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x() {
        startActivityForResult(new Intent(this, UpgradeSupportActivity2.class), 0);
    }

    @Override // com.arlosoft.macrodroid.upgrade.base.BasePurchaseActivity
    @NotNull
    public String getAnalyticsPuchaseSource() {
        return this.f15875j;
    }

    @Override // com.arlosoft.macrodroid.upgrade.base.BasePurchaseActivity
    public boolean getSupportsFlashSale() {
        return this.f15876k;
    }

    @Override // com.arlosoft.macrodroid.upgrade.base.BasePurchaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i4, int i5, @Nullable Intent intent) {
        super.onActivityResult(i4, i5, intent);
        if (i4 == 0 && i5 == -1) {
            finish();
        }
        finish();
    }

    @Override // com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(0, R.anim.out_to_bottom);
    }

    @Override // com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity, com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        ActivityUpgrade2Binding inflate = ActivityUpgrade2Binding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater)");
        this.f15873h = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        setContentView(inflate.getRoot());
        Settings.setCanShowUpgradeOnLaunch(getApplicationContext(), false);
        ActivityUpgrade2Binding activityUpgrade2Binding = this.f15873h;
        if (activityUpgrade2Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityUpgrade2Binding = null;
        }
        setSupportActionBar(activityUpgrade2Binding.toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayShowTitleEnabled(false);
        }
        ActionBar supportActionBar2 = getSupportActionBar();
        if (supportActionBar2 != null) {
            supportActionBar2.setDisplayHomeAsUpEnabled(true);
        }
        w();
        q();
        ActivityUpgrade2Binding activityUpgrade2Binding2 = this.f15873h;
        if (activityUpgrade2Binding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityUpgrade2Binding2 = null;
        }
        Button button = activityUpgrade2Binding2.upgradeNowButton;
        Intrinsics.checkNotNullExpressionValue(button, "binding.upgradeNowButton");
        ViewExtensionsKt.onClick$default(button, null, new a(null), 1, null);
        ActivityUpgrade2Binding activityUpgrade2Binding3 = this.f15873h;
        if (activityUpgrade2Binding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityUpgrade2Binding3 = null;
        }
        FrameLayout frameLayout = activityUpgrade2Binding3.priceContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.priceContainer");
        ViewExtensionsKt.onClick$default(frameLayout, null, new b(null), 1, null);
        ActivityUpgrade2Binding activityUpgrade2Binding4 = this.f15873h;
        if (activityUpgrade2Binding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityUpgrade2Binding4 = null;
        }
        TextView textView = activityUpgrade2Binding4.helpButton;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.helpButton");
        ViewExtensionsKt.onClick$default(textView, null, new c(null), 1, null);
        getFlashSaleManager().startNewFlashSaleIfAppropriate();
        getFlashSaleManager().clearFlashSaleNotification(this);
        v();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(@NotNull MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (item.getItemId() == 16908332) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override // com.arlosoft.macrodroid.upgrade.base.BasePurchaseActivity
    public void setPriceText(@NotNull String price) {
        Intrinsics.checkNotNullParameter(price, "price");
        ActivityUpgrade2Binding activityUpgrade2Binding = this.f15873h;
        ActivityUpgrade2Binding activityUpgrade2Binding2 = null;
        if (activityUpgrade2Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityUpgrade2Binding = null;
        }
        activityUpgrade2Binding.priceText.setText(price);
        ActivityUpgrade2Binding activityUpgrade2Binding3 = this.f15873h;
        if (activityUpgrade2Binding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityUpgrade2Binding2 = activityUpgrade2Binding3;
        }
        activityUpgrade2Binding2.priceViewFlipper.setDisplayedChild(1);
    }

    @Override // com.arlosoft.macrodroid.upgrade.base.BasePurchaseActivity
    public void setWasPriceText(@NotNull String price) {
        Intrinsics.checkNotNullParameter(price, "price");
        this.f15874i = price;
        ActivityUpgrade2Binding activityUpgrade2Binding = this.f15873h;
        ActivityUpgrade2Binding activityUpgrade2Binding2 = null;
        if (activityUpgrade2Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityUpgrade2Binding = null;
        }
        TextView textView = activityUpgrade2Binding.wasPrice;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = getString(R.string.flash_sale_was_price);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.flash_sale_was_price)");
        String format = String.format(string, Arrays.copyOf(new Object[]{price}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        textView.setText(format);
        ActivityUpgrade2Binding activityUpgrade2Binding3 = this.f15873h;
        if (activityUpgrade2Binding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityUpgrade2Binding3 = null;
        }
        TextView textView2 = activityUpgrade2Binding3.wasPrice;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.wasPrice");
        textView2.setVisibility(0);
        ActivityUpgrade2Binding activityUpgrade2Binding4 = this.f15873h;
        if (activityUpgrade2Binding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityUpgrade2Binding4 = null;
        }
        TextView textView3 = activityUpgrade2Binding4.wasPrice;
        ActivityUpgrade2Binding activityUpgrade2Binding5 = this.f15873h;
        if (activityUpgrade2Binding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityUpgrade2Binding2 = activityUpgrade2Binding5;
        }
        textView3.setPaintFlags(activityUpgrade2Binding2.wasPrice.getPaintFlags() | 16);
    }
}
