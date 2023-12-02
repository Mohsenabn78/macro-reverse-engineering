package com.arlosoft.macrodroid.intro;

import agency.tango.materialintroscreen.MaterialIntroActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.compose.runtime.internal.StabilityInferred;
import com.araujo.jordan.excuseme.ExcuseMe;
import com.araujo.jordan.excuseme.model.PermissionStatus;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.extensions.ActivityExtensionsKt;
import com.arlosoft.macrodroid.homescreen.NewHomeScreenActivity;
import com.arlosoft.macrodroid.settings.Settings;
import com.google.android.gms.ads.MobileAds;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.m;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: IntroActivity.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nIntroActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IntroActivity.kt\ncom/arlosoft/macrodroid/intro/IntroActivity\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,138:1\n262#2,2:139\n262#2,2:141\n*S KotlinDebug\n*F\n+ 1 IntroActivity.kt\ncom/arlosoft/macrodroid/intro/IntroActivity\n*L\n56#1:139,2\n123#1:141,2\n*E\n"})
/* loaded from: classes3.dex */
public final class IntroActivity extends MaterialIntroActivity {
    public static final int $stable = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IntroActivity.kt */
    /* loaded from: classes3.dex */
    public static final class a extends Lambda implements Function1<Boolean, Unit> {
        final /* synthetic */ long $startTime;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(long j4) {
            super(1);
            this.$startTime = j4;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke2(bool);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(Boolean bool) {
            IntroActivity.this.H(System.currentTimeMillis() - this.$startTime > 1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IntroActivity.kt */
    /* loaded from: classes3.dex */
    public static final class b extends Lambda implements Function1<Throwable, Unit> {
        b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke2(th);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th) {
            IntroActivity.this.H(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IntroActivity.kt */
    /* loaded from: classes3.dex */
    public static final class c extends Lambda implements Function1<PermissionStatus, Unit> {
        c() {
            super(1);
        }

        public final void a(@NotNull PermissionStatus it) {
            Intrinsics.checkNotNullParameter(it, "it");
            Settings.setHasShownIntro(IntroActivity.this, true);
            IntroActivity.this.startActivity(new Intent(IntroActivity.this, NewHomeScreenActivity.class));
            FirebaseAnalyticsEventLogger.logOnboardingComplete();
            IntroActivity.this.finish();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PermissionStatus permissionStatus) {
            a(permissionStatus);
            return Unit.INSTANCE;
        }
    }

    private final void D() {
        boolean equals;
        boolean equals2;
        String str;
        ImageButton imageButton = (ImageButton) findViewById(R.id.button_back);
        ((ImageButton) findViewById(R.id.button_next)).setContentDescription(getString(R.string.action_control_media_next));
        findViewById(R.id.coordinator_layout_slide).setBackgroundColor(-1);
        View findViewById = findViewById(R.id.coordinator_layout_slide);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<View>(R.id.coordinator_layout_slide)");
        findViewById.setVisibility(8);
        addSlide(new WelcomeOnboardFragment());
        addSlide(new TriggerOnboardFragment());
        addSlide(new ActionOnboardFragment());
        addSlide(new ConstraintOnboardFragment());
        String str2 = Build.MANUFACTURER;
        String str3 = "xiaomi";
        equals = m.equals(str2, "xiaomi", true);
        if (equals) {
            str = "Xiaomi";
        } else {
            str3 = "huawei";
            equals2 = m.equals(str2, "huawei", true);
            if (equals2) {
                str = "Huawei";
            } else {
                str3 = null;
                str = null;
            }
        }
        if (str != null && str3 != null) {
            addSlide(WarningOnboardFragment.Companion.createInstance(str, str3));
        }
        FirebaseAnalyticsEventLogger.logOnboardingStartOneTime();
        setSkipButtonVisible();
        this.f55g.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.intro.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                IntroActivity.E(IntroActivity.this, view);
            }
        });
        if (!MacroDroidApplication.Companion.getInstance().getPremiumStatusHandler().getPremiumStatus().isPro()) {
            try {
                MobileAds.initialize(getApplicationContext());
            } catch (Exception e4) {
                FirebaseAnalyticsEventLogger.logHandledException(e4);
            }
        }
        long currentTimeMillis = System.currentTimeMillis();
        Observable<Boolean> observeOn = MacroDroidApplication.Companion.getInstance().getApplicationStartedSubject().timeout(5L, TimeUnit.SECONDS).take(1L).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final a aVar = new a(currentTimeMillis);
        Consumer<? super Boolean> consumer = new Consumer() { // from class: com.arlosoft.macrodroid.intro.b
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                IntroActivity.F(Function1.this, obj);
            }
        };
        final b bVar = new b();
        observeOn.subscribe(consumer, new Consumer() { // from class: com.arlosoft.macrodroid.intro.c
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                IntroActivity.G(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(IntroActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FirebaseAnalyticsEventLogger.logOnboardingSkipped();
        this$0.onFinish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H(boolean z3) {
        if (Settings.getLastVersionRun(this) == 0 && !Settings.getHasShownIntro(this)) {
            View findViewById = findViewById(R.id.coordinator_layout_slide);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<View>(R.id.coordinator_layout_slide)");
            findViewById.setVisibility(0);
            return;
        }
        startActivity(new Intent(this, NewHomeScreenActivity.class));
        finish();
        if (z3) {
            overridePendingTransition(17432576, 17432577);
        } else {
            overridePendingTransition(0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // agency.tango.materialintroscreen.MaterialIntroActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        ActivityExtensionsKt.makeStatusBarTransparent(this);
        super.onCreate(bundle);
        if (!getResources().getBoolean(R.bool.is_tablet)) {
            try {
                setRequestedOrientation(1);
            } catch (IllegalStateException unused) {
            }
        }
        D();
    }

    @Override // agency.tango.materialintroscreen.MaterialIntroActivity
    public void onFinish() {
        ExcuseMe.Companion.couldYouGive((Activity) this).permissionFor(new String[]{"android.permission.POST_NOTIFICATIONS"}, new c());
    }
}
