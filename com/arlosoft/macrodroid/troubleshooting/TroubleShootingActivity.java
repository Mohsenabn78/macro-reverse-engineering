package com.arlosoft.macrodroid.troubleshooting;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity;
import com.arlosoft.macrodroid.bugreporting.ReportBugActivity;
import com.arlosoft.macrodroid.databinding.ActivityTroubleshootingBinding;
import com.arlosoft.macrodroid.extensions.ViewExtensionsKt;
import com.arlosoft.macrodroid.logging.systemlog.SystemLogActivity;
import com.arlosoft.macrodroid.troubleshooting.help.TroubleShootingHelpFragment;
import com.arlosoft.macrodroid.troubleshooting.problem.ProblemListFragment;
import com.arlosoft.macrodroid.utils.gradients.Gradients;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.appupdate.AppUpdateManagerFactory;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TroubleShootingActivity.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class TroubleShootingActivity extends MacroDroidDaggerBaseActivity {
    public static final int $stable = 8;

    /* renamed from: f  reason: collision with root package name */
    private ActivityTroubleshootingBinding f15806f;

    /* compiled from: TroubleShootingActivity.kt */
    /* loaded from: classes3.dex */
    private final class a extends FragmentStateAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TroubleShootingActivity f15807a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull TroubleShootingActivity troubleShootingActivity, FragmentActivity fa) {
            super(fa);
            Intrinsics.checkNotNullParameter(fa, "fa");
            this.f15807a = troubleShootingActivity;
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter
        @NotNull
        public Fragment createFragment(int i4) {
            if (i4 == 0) {
                return new ProblemListFragment();
            }
            return new TroubleShootingHelpFragment();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TroubleShootingActivity.kt */
    /* loaded from: classes3.dex */
    public static final class b extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
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
                TroubleShootingActivity.this.u();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TroubleShootingActivity.kt */
    /* loaded from: classes3.dex */
    public static final class c extends Lambda implements Function1<AppUpdateInfo, Unit> {
        final /* synthetic */ AppUpdateManager $appUpdateManager;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(AppUpdateManager appUpdateManager) {
            super(1);
            this.$appUpdateManager = appUpdateManager;
        }

        public final void a(AppUpdateInfo appUpdateInfo) {
            if (appUpdateInfo.updateAvailability() != 2) {
                TroubleShootingActivity.this.B();
                return;
            }
            TroubleShootingActivity troubleShootingActivity = TroubleShootingActivity.this;
            AppUpdateManager appUpdateManager = this.$appUpdateManager;
            Intrinsics.checkNotNullExpressionValue(appUpdateInfo, "appUpdateInfo");
            troubleShootingActivity.z(appUpdateManager, appUpdateInfo);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(AppUpdateInfo appUpdateInfo) {
            a(appUpdateInfo);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(AppUpdateManager appUpdateManager, AppUpdateInfo appUpdateInfo, TroubleShootingActivity this$0, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(appUpdateManager, "$appUpdateManager");
        Intrinsics.checkNotNullParameter(appUpdateInfo, "$appUpdateInfo");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        appUpdateManager.startUpdateFlowForResult(appUpdateInfo, 1, this$0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.report_a_bug);
        builder.setMessage(R.string.report_bug_dialog_info);
        builder.setPositiveButton(R.string.report_a_bug, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.troubleshooting.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                TroubleShootingActivity.C(TroubleShootingActivity.this, dialogInterface, i4);
            }
        });
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.setNeutralButton(R.string.system_log, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.troubleshooting.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                TroubleShootingActivity.D(TroubleShootingActivity.this, dialogInterface, i4);
            }
        });
        try {
            builder.show();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(TroubleShootingActivity this$0, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.startActivity(new Intent(this$0, ReportBugActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(TroubleShootingActivity this$0, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent(this$0, SystemLogActivity.class);
        intent.addFlags(268435456);
        this$0.startActivity(intent);
    }

    private final void s() {
        ActivityTroubleshootingBinding activityTroubleshootingBinding = this.f15806f;
        if (activityTroubleshootingBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTroubleshootingBinding = null;
        }
        Button button = activityTroubleshootingBinding.reportBugButton;
        Intrinsics.checkNotNullExpressionValue(button, "binding.reportBugButton");
        ViewExtensionsKt.onClick$default(button, null, new b(null), 1, null);
    }

    private final void t() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.report_bug_battery_optimisation_title);
        builder.setMessage(R.string.report_bug_battery_optimisation_warning);
        builder.setPositiveButton(17039370, (DialogInterface.OnClickListener) null);
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u() {
        if (x()) {
            t();
            return;
        }
        try {
            AppUpdateManager create = AppUpdateManagerFactory.create(this);
            Intrinsics.checkNotNullExpressionValue(create, "create(this)");
            Task<AppUpdateInfo> appUpdateInfo = create.getAppUpdateInfo();
            Intrinsics.checkNotNullExpressionValue(appUpdateInfo, "appUpdateManager.appUpdateInfo");
            final c cVar = new c(create);
            appUpdateInfo.addOnSuccessListener(new OnSuccessListener() { // from class: com.arlosoft.macrodroid.troubleshooting.e
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    TroubleShootingActivity.v(Function1.this, obj);
                }
            });
            appUpdateInfo.addOnFailureListener(new OnFailureListener() { // from class: com.arlosoft.macrodroid.troubleshooting.f
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    TroubleShootingActivity.w(TroubleShootingActivity.this, exc);
                }
            });
        } catch (Exception e4) {
            FirebaseAnalyticsEventLogger.logHandledException(e4);
            B();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(TroubleShootingActivity this$0, Exception it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        FirebaseAnalyticsEventLogger.logHandledException(it);
        this$0.B();
    }

    private final boolean x() {
        boolean isIgnoringBatteryOptimizations;
        if (Build.VERSION.SDK_INT >= 23) {
            Gradients gradients = Gradients.INSTANCE;
            Object systemService = gradients.getContext().getSystemService("power");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.PowerManager");
            isIgnoringBatteryOptimizations = ((PowerManager) systemService).isIgnoringBatteryOptimizations(gradients.getContext().getPackageName());
            return !isIgnoringBatteryOptimizations;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(TroubleShootingActivity this$0, TabLayout.Tab tab, int i4) {
        int i5;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(tab, "tab");
        if (i4 == 0) {
            i5 = R.string.troubleshoot_heading_issues_identified;
        } else {
            i5 = R.string.troubleshoot_common_problems;
        }
        tab.setText(this$0.getString(i5));
        ActivityTroubleshootingBinding activityTroubleshootingBinding = this$0.f15806f;
        if (activityTroubleshootingBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTroubleshootingBinding = null;
        }
        activityTroubleshootingBinding.viewPager.setCurrentItem(tab.getPosition(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z(final AppUpdateManager appUpdateManager, final AppUpdateInfo appUpdateInfo) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.report_a_bug);
        builder.setMessage(R.string.report_bug_update_required);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.troubleshooting.a
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                TroubleShootingActivity.A(AppUpdateManager.this, appUpdateInfo, this, dialogInterface, i4);
            }
        });
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity, com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        ActivityTroubleshootingBinding inflate = ActivityTroubleshootingBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater)");
        this.f15806f = inflate;
        ActivityTroubleshootingBinding activityTroubleshootingBinding = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        setContentView(inflate.getRoot());
        ActivityTroubleshootingBinding activityTroubleshootingBinding2 = this.f15806f;
        if (activityTroubleshootingBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTroubleshootingBinding2 = null;
        }
        setSupportActionBar(activityTroubleshootingBinding2.toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
        ActionBar supportActionBar2 = getSupportActionBar();
        if (supportActionBar2 != null) {
            supportActionBar2.setTitle(R.string.drawer_menu_troubleshooting);
        }
        a aVar = new a(this, this);
        ActivityTroubleshootingBinding activityTroubleshootingBinding3 = this.f15806f;
        if (activityTroubleshootingBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTroubleshootingBinding3 = null;
        }
        activityTroubleshootingBinding3.viewPager.setAdapter(aVar);
        ActivityTroubleshootingBinding activityTroubleshootingBinding4 = this.f15806f;
        if (activityTroubleshootingBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTroubleshootingBinding4 = null;
        }
        activityTroubleshootingBinding4.tabLayout.setTabTextColors(ContextCompat.getColor(this, R.color.white_slight_transparent), ContextCompat.getColor(this, R.color.white));
        ActivityTroubleshootingBinding activityTroubleshootingBinding5 = this.f15806f;
        if (activityTroubleshootingBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTroubleshootingBinding5 = null;
        }
        activityTroubleshootingBinding5.tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.white));
        ActivityTroubleshootingBinding activityTroubleshootingBinding6 = this.f15806f;
        if (activityTroubleshootingBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTroubleshootingBinding6 = null;
        }
        TabLayout tabLayout = activityTroubleshootingBinding6.tabLayout;
        ActivityTroubleshootingBinding activityTroubleshootingBinding7 = this.f15806f;
        if (activityTroubleshootingBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityTroubleshootingBinding = activityTroubleshootingBinding7;
        }
        new TabLayoutMediator(tabLayout, activityTroubleshootingBinding.viewPager, new TabLayoutMediator.TabConfigurationStrategy() { // from class: com.arlosoft.macrodroid.troubleshooting.d
            @Override // com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
            public final void onConfigureTab(TabLayout.Tab tab, int i4) {
                TroubleShootingActivity.y(TroubleShootingActivity.this, tab, i4);
            }
        }).attach();
        s();
    }
}
