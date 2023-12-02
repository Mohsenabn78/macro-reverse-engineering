package com.arlosoft.macrodroid.templatestore.reportmacro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.lifecycle.Observer;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity;
import com.arlosoft.macrodroid.databinding.ActivityReportsSummaryBinding;
import com.arlosoft.macrodroid.extensions.ViewExtensionsKt;
import com.arlosoft.macrodroid.templatestore.model.MacroTemplate;
import com.arlosoft.macrodroid.templatestore.reportmacro.UiEvent;
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

/* compiled from: ReportMacroActivity.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class ReportMacroActivity extends MacroDroidDaggerBaseActivity {
    public static final int REQUEST_CODE = 222;

    /* renamed from: f  reason: collision with root package name */
    private ActivityReportsSummaryBinding f13663f;
    @Inject
    public ReportMacroRepository reportMacroRepository;
    @Inject
    public ReportMacroViewModel viewModel;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: ReportMacroActivity.kt */
    @SourceDebugExtension({"SMAP\nReportMacroActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReportMacroActivity.kt\ncom/arlosoft/macrodroid/templatestore/reportmacro/ReportMacroActivity$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,201:1\n1#2:202\n*E\n"})
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void showReportMacroScreen(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            activity.startActivityForResult(new Intent(activity, ReportMacroActivity.class), 222);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReportMacroActivity.kt */
    /* loaded from: classes3.dex */
    public static final class a extends Lambda implements Function1<MacroReportData, Unit> {
        a() {
            super(1);
        }

        public final void a(MacroReportData macroReportData) {
            MacroReportEntryAdapter macroReportEntryAdapter = new MacroReportEntryAdapter(macroReportData.getEntries());
            ActivityReportsSummaryBinding activityReportsSummaryBinding = ReportMacroActivity.this.f13663f;
            if (activityReportsSummaryBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityReportsSummaryBinding = null;
            }
            activityReportsSummaryBinding.commentsRecyclerView.setAdapter(macroReportEntryAdapter);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MacroReportData macroReportData) {
            a(macroReportData);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReportMacroActivity.kt */
    /* loaded from: classes3.dex */
    public static final class b extends Lambda implements Function1<UiEvent, Unit> {
        b() {
            super(1);
        }

        public final void a(@Nullable UiEvent uiEvent) {
            if (uiEvent instanceof UiEvent.CloseScreen) {
                ReportMacroActivity.this.setResult(-1);
                ReportMacroActivity.this.finish();
            }
            if (uiEvent instanceof UiEvent.FailedOperationError) {
                ToastCompat.makeText(ReportMacroActivity.this, (int) R.string.macrodroid_error, 1).show();
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(UiEvent uiEvent) {
            a(uiEvent);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: ReportMacroActivity.kt */
    /* loaded from: classes3.dex */
    static final class c extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ MacroTemplate $macroTemplate;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(MacroTemplate macroTemplate, Continuation<? super c> continuation) {
            super(3, continuation);
            this.$macroTemplate = macroTemplate;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new c(this.$macroTemplate, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ReportMacroActivity.this.o(this.$macroTemplate);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: ReportMacroActivity.kt */
    /* loaded from: classes3.dex */
    static final class d extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ MacroTemplate $macroTemplate;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(MacroTemplate macroTemplate, Continuation<? super d> continuation) {
            super(3, continuation);
            this.$macroTemplate = macroTemplate;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new d(this.$macroTemplate, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ReportMacroActivity.this.n(this.$macroTemplate);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReportMacroActivity.kt */
    /* loaded from: classes3.dex */
    public static final class e implements Observer, FunctionAdapter {

        /* renamed from: a  reason: collision with root package name */
        private final /* synthetic */ Function1 f13664a;

        e(Function1 function) {
            Intrinsics.checkNotNullParameter(function, "function");
            this.f13664a = function;
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
            return this.f13664a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f13664a.invoke(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReportMacroActivity.kt */
    /* loaded from: classes3.dex */
    public static final class f extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ AppCompatDialog $dialog;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(AppCompatDialog appCompatDialog, Continuation<? super f> continuation) {
            super(3, continuation);
            this.$dialog = appCompatDialog;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new f(this.$dialog, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ReportMacroActivity.this.getViewModel().clearReports();
                this.$dialog.dismiss();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReportMacroActivity.kt */
    /* loaded from: classes3.dex */
    public static final class g extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ AppCompatDialog $dialog;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(AppCompatDialog appCompatDialog, Continuation<? super g> continuation) {
            super(3, continuation);
            this.$dialog = appCompatDialog;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new g(this.$dialog, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.$dialog.dismiss();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReportMacroActivity.kt */
    /* loaded from: classes3.dex */
    public static final class h extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ AppCompatDialog $dialog;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(AppCompatDialog appCompatDialog, Continuation<? super h> continuation) {
            super(3, continuation);
            this.$dialog = appCompatDialog;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new h(this.$dialog, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ReportMacroActivity.this.getViewModel().deleteMacro();
                this.$dialog.dismiss();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReportMacroActivity.kt */
    /* loaded from: classes3.dex */
    public static final class i extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ AppCompatDialog $dialog;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(AppCompatDialog appCompatDialog, Continuation<? super i> continuation) {
            super(3, continuation);
            this.$dialog = appCompatDialog;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new i(this.$dialog, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.$dialog.dismiss();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private final void m() {
        getViewModel().getMacroReportData().observe(this, new e(new a()));
        getViewModel().getUiEvent().observe(this, new e(new b()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(MacroTemplate macroTemplate) {
        AppCompatDialog appCompatDialog = new AppCompatDialog(this, R.style.Theme_App_Dialog_Template);
        appCompatDialog.setContentView(R.layout.dialog_moderator_clear_reports);
        appCompatDialog.setTitle(macroTemplate.getName());
        Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        if (button != null) {
            ViewExtensionsKt.onClick$default(button, null, new f(appCompatDialog, null), 1, null);
        }
        if (button2 != null) {
            ViewExtensionsKt.onClick$default(button2, null, new g(appCompatDialog, null), 1, null);
        }
        appCompatDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(MacroTemplate macroTemplate) {
        AppCompatDialog appCompatDialog = new AppCompatDialog(this, R.style.Theme_App_Dialog_Template);
        appCompatDialog.setContentView(R.layout.dialog_moderator_remove);
        appCompatDialog.setTitle(macroTemplate.getName());
        Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        if (button != null) {
            ViewExtensionsKt.onClick$default(button, null, new h(appCompatDialog, null), 1, null);
        }
        if (button2 != null) {
            ViewExtensionsKt.onClick$default(button2, null, new i(appCompatDialog, null), 1, null);
        }
        appCompatDialog.show();
    }

    @NotNull
    public final ReportMacroRepository getReportMacroRepository() {
        ReportMacroRepository reportMacroRepository = this.reportMacroRepository;
        if (reportMacroRepository != null) {
            return reportMacroRepository;
        }
        Intrinsics.throwUninitializedPropertyAccessException("reportMacroRepository");
        return null;
    }

    @NotNull
    public final ReportMacroViewModel getViewModel() {
        ReportMacroViewModel reportMacroViewModel = this.viewModel;
        if (reportMacroViewModel != null) {
            return reportMacroViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }

    @Override // com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity, com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        ActivityReportsSummaryBinding inflate = ActivityReportsSummaryBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater)");
        this.f13663f = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        setContentView(inflate.getRoot());
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
        MacroTemplate macroTemplate = getReportMacroRepository().getMacroTemplate();
        Intrinsics.checkNotNull(macroTemplate);
        ActionBar supportActionBar2 = getSupportActionBar();
        if (supportActionBar2 != null) {
            supportActionBar2.setTitle(macroTemplate.getName());
        }
        getViewModel().setMacroTemplate(macroTemplate);
        m();
        ActivityReportsSummaryBinding activityReportsSummaryBinding = this.f13663f;
        if (activityReportsSummaryBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityReportsSummaryBinding = null;
        }
        Button button = activityReportsSummaryBinding.deleteMacroButton;
        Intrinsics.checkNotNullExpressionValue(button, "binding.deleteMacroButton");
        ViewExtensionsKt.onClick$default(button, null, new c(macroTemplate, null), 1, null);
        ActivityReportsSummaryBinding activityReportsSummaryBinding2 = this.f13663f;
        if (activityReportsSummaryBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityReportsSummaryBinding2 = null;
        }
        Button button2 = activityReportsSummaryBinding2.clearReportsButton;
        Intrinsics.checkNotNullExpressionValue(button2, "binding.clearReportsButton");
        ViewExtensionsKt.onClick$default(button2, null, new d(macroTemplate, null), 1, null);
    }

    @Override // com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        getReportMacroRepository().setMacroTemplate(null);
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

    public final void setReportMacroRepository(@NotNull ReportMacroRepository reportMacroRepository) {
        Intrinsics.checkNotNullParameter(reportMacroRepository, "<set-?>");
        this.reportMacroRepository = reportMacroRepository;
    }

    public final void setViewModel(@NotNull ReportMacroViewModel reportMacroViewModel) {
        Intrinsics.checkNotNullParameter(reportMacroViewModel, "<set-?>");
        this.viewModel = reportMacroViewModel;
    }
}
