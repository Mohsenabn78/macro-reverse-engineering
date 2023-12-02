package com.arlosoft.macrodroid.logging.systemlog;

import android.animation.LayoutTransition;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.widget.SearchView;
import androidx.cardview.widget.CardView;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import androidx.paging.CombinedLoadStates;
import androidx.paging.LoadState;
import androidx.paging.PagingData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity;
import com.arlosoft.macrodroid.database.room.SystemLogEntry;
import com.arlosoft.macrodroid.databinding.ActivitySystemLogBinding;
import com.arlosoft.macrodroid.extensions.ViewExtensionsKt;
import com.arlosoft.macrodroid.logging.systemlog.macrofilter.MacroLogFilterActivity;
import com.arlosoft.macrodroid.logging.systemlog.variablefilter.VariableLogFilterActivity;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.templatestore.ui.comments.TemplateCommentsActivity;
import com.arlosoft.macrodroid.utils.FileUtils;
import com.arlosoft.macrodroid.widget.BetterCheckBox;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.File;
import java.util.Arrays;
import javax.inject.Inject;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import me.drakeet.support.toast.ToastCompat;
import org.jetbrains.anko.sdk27.coroutines.Sdk27CoroutinesListenersWithCoroutinesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SystemLogActivity.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nSystemLogActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SystemLogActivity.kt\ncom/arlosoft/macrodroid/logging/systemlog/SystemLogActivity\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,399:1\n262#2,2:400\n260#2,4:402\n*S KotlinDebug\n*F\n+ 1 SystemLogActivity.kt\ncom/arlosoft/macrodroid/logging/systemlog/SystemLogActivity\n*L\n106#1:400,2\n226#1:402,4\n*E\n"})
/* loaded from: classes3.dex */
public final class SystemLogActivity extends MacroDroidDaggerBaseActivity {

    /* renamed from: f  reason: collision with root package name */
    private ActivitySystemLogBinding f12684f;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private SearchView f12686h;

    /* renamed from: j  reason: collision with root package name */
    private boolean f12688j;
    public SystemLogAdapter pagingAdapter;
    @Inject
    public SystemLogViewModel viewModel;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @NotNull

    /* renamed from: l  reason: collision with root package name */
    private static final String f12683l = TemplateCommentsActivity.EXTRA_MACRO_ID;
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private final MacroMovementMethod f12685g = new MacroMovementMethod(this);
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    private String f12687i = "";
    @NotNull

    /* renamed from: k  reason: collision with root package name */
    private CoroutineScope f12689k = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain()));

    /* compiled from: SystemLogActivity.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void launchForIndividualMacro(@NotNull Activity activity, long j4) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intent intent = new Intent(activity, SystemLogActivity.class);
            intent.putExtra(SystemLogActivity.f12683l, j4);
            activity.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SystemLogActivity.kt */
    /* loaded from: classes3.dex */
    public static final class a extends SuspendLambda implements Function4<CoroutineScope, CompoundButton, Boolean, Continuation<? super Unit>, Object> {
        /* synthetic */ boolean Z$0;
        int label;

        a(Continuation<? super a> continuation) {
            super(4, continuation);
        }

        @Nullable
        public final Object a(@NotNull CoroutineScope coroutineScope, @Nullable CompoundButton compoundButton, boolean z3, @Nullable Continuation<? super Unit> continuation) {
            a aVar = new a(continuation);
            aVar.Z$0 = z3;
            return aVar.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, CompoundButton compoundButton, Boolean bool, Continuation<? super Unit> continuation) {
            return a(coroutineScope, compoundButton, bool.booleanValue(), continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                SystemLogActivity.this.getViewModel().setFilterTriggersEnabled(this.Z$0);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SystemLogActivity.kt */
    /* loaded from: classes3.dex */
    public static final class b extends SuspendLambda implements Function4<CoroutineScope, CompoundButton, Boolean, Continuation<? super Unit>, Object> {
        /* synthetic */ boolean Z$0;
        int label;

        b(Continuation<? super b> continuation) {
            super(4, continuation);
        }

        @Nullable
        public final Object a(@NotNull CoroutineScope coroutineScope, @Nullable CompoundButton compoundButton, boolean z3, @Nullable Continuation<? super Unit> continuation) {
            b bVar = new b(continuation);
            bVar.Z$0 = z3;
            return bVar.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, CompoundButton compoundButton, Boolean bool, Continuation<? super Unit> continuation) {
            return a(coroutineScope, compoundButton, bool.booleanValue(), continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                SystemLogActivity.this.getViewModel().setFilterActionsEnabled(this.Z$0);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SystemLogActivity.kt */
    /* loaded from: classes3.dex */
    public static final class c extends SuspendLambda implements Function4<CoroutineScope, CompoundButton, Boolean, Continuation<? super Unit>, Object> {
        /* synthetic */ boolean Z$0;
        int label;

        c(Continuation<? super c> continuation) {
            super(4, continuation);
        }

        @Nullable
        public final Object a(@NotNull CoroutineScope coroutineScope, @Nullable CompoundButton compoundButton, boolean z3, @Nullable Continuation<? super Unit> continuation) {
            c cVar = new c(continuation);
            cVar.Z$0 = z3;
            return cVar.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, CompoundButton compoundButton, Boolean bool, Continuation<? super Unit> continuation) {
            return a(coroutineScope, compoundButton, bool.booleanValue(), continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                SystemLogActivity.this.getViewModel().setFilterConstraintsEnabled(this.Z$0);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SystemLogActivity.kt */
    /* loaded from: classes3.dex */
    public static final class d extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        int label;

        d(Continuation<? super d> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new d(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                SystemLogActivity.this.startActivity(new Intent(SystemLogActivity.this, MacroLogFilterActivity.class));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SystemLogActivity.kt */
    /* loaded from: classes3.dex */
    public static final class e extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        int label;

        e(Continuation<? super e> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new e(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                SystemLogActivity.this.startActivity(new Intent(SystemLogActivity.this, VariableLogFilterActivity.class));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SystemLogActivity.kt */
    /* loaded from: classes3.dex */
    public static final class f extends Lambda implements Function1<CombinedLoadStates, Unit> {
        f() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(CombinedLoadStates combinedLoadStates) {
            invoke2(combinedLoadStates);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull CombinedLoadStates loadState) {
            Intrinsics.checkNotNullParameter(loadState, "loadState");
            if ((loadState.getSource().getRefresh() instanceof LoadState.NotLoading) && loadState.getAppend().getEndOfPaginationReached() && SystemLogActivity.this.getPagingAdapter().getItemCount() < 1) {
                ActivitySystemLogBinding activitySystemLogBinding = SystemLogActivity.this.f12684f;
                if (activitySystemLogBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activitySystemLogBinding = null;
                }
                activitySystemLogBinding.viewFlipper.setDisplayedChild(2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SystemLogActivity.kt */
    /* loaded from: classes3.dex */
    public static final class g implements Observer<PagingData<SystemLogEntry>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: SystemLogActivity.kt */
        /* loaded from: classes3.dex */
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ PagingData<SystemLogEntry> $it;
            int label;
            final /* synthetic */ SystemLogActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(SystemLogActivity systemLogActivity, PagingData<SystemLogEntry> pagingData, Continuation<? super a> continuation) {
                super(2, continuation);
                this.this$0 = systemLogActivity;
                this.$it = pagingData;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new a(this.this$0, this.$it, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object coroutine_suspended;
                coroutine_suspended = kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                int i4 = this.label;
                if (i4 != 0) {
                    if (i4 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    SystemLogAdapter pagingAdapter = this.this$0.getPagingAdapter();
                    PagingData<SystemLogEntry> it = this.$it;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    this.label = 1;
                    if (pagingAdapter.submitData(it, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        g() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public final void onChanged(PagingData<SystemLogEntry> pagingData) {
            kotlinx.coroutines.e.e(LifecycleOwnerKt.getLifecycleScope(SystemLogActivity.this), Dispatchers.getMain(), null, new a(SystemLogActivity.this, pagingData, null), 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SystemLogActivity.kt */
    /* loaded from: classes3.dex */
    public static final class h implements Observer<Unit> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: SystemLogActivity.kt */
        /* loaded from: classes3.dex */
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ SystemLogActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(SystemLogActivity systemLogActivity, Continuation<? super a> continuation) {
                super(2, continuation);
                this.this$0 = systemLogActivity;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new a(this.this$0, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.this$0.getPagingAdapter().refresh();
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        h() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public final void onChanged(@Nullable Unit unit) {
            kotlinx.coroutines.e.e(LifecycleOwnerKt.getLifecycleScope(SystemLogActivity.this), Dispatchers.getMain(), null, new a(SystemLogActivity.this, null), 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SystemLogActivity.kt */
    /* loaded from: classes3.dex */
    public static final class i implements Observer<String> {
        i() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public final void onChanged(@Nullable String str) {
            SystemLogActivity systemLogActivity = SystemLogActivity.this;
            Intrinsics.checkNotNull(str);
            systemLogActivity.H(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SystemLogActivity.kt */
    /* loaded from: classes3.dex */
    public static final class j implements Observer<LogFilter> {
        j() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public final void onChanged(LogFilter it) {
            SystemLogActivity systemLogActivity = SystemLogActivity.this;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            systemLogActivity.s(it);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SystemLogActivity.kt */
    /* loaded from: classes3.dex */
    public static final class k implements Observer<Pair<? extends Integer, ? extends Integer>> {
        k() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public final void onChanged(Pair<Integer, Integer> it) {
            SystemLogActivity systemLogActivity = SystemLogActivity.this;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            systemLogActivity.v(it);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SystemLogActivity.kt */
    /* loaded from: classes3.dex */
    public static final class l implements Observer<Pair<? extends Integer, ? extends Integer>> {
        l() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public final void onChanged(Pair<Integer, Integer> it) {
            SystemLogActivity systemLogActivity = SystemLogActivity.this;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            systemLogActivity.x(it);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(SystemLogActivity this$0, DialogInterface dialog, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        this$0.getViewModel().clearLog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(DialogInterface dialog, int i4) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
    }

    private final void C() {
        boolean z3 = !Settings.getReverseSystemLog(this);
        getPagingAdapter().setReversed(z3);
        Settings.setReverseSystemLog(this, z3);
        ActivitySystemLogBinding activitySystemLogBinding = this.f12684f;
        if (activitySystemLogBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activitySystemLogBinding = null;
        }
        RecyclerView.LayoutManager layoutManager = activitySystemLogBinding.recyclerView.getLayoutManager();
        Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        ((LinearLayoutManager) layoutManager).setReverseLayout(z3);
    }

    private final void D(Menu menu, boolean z3) {
        menu.findItem(R.id.menu_filter).setVisible(z3);
    }

    private final boolean E() {
        if ((getResources().getConfiguration().uiMode & 48) == 32) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean F(SystemLogActivity this$0, Menu menu) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(menu, "$menu");
        this$0.D(menu, true);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(SystemLogActivity this$0, Menu menu, View view, boolean z3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(menu, "$menu");
        if (z3) {
            this$0.D(menu, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H(String str) {
        try {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.SUBJECT", "MacroDroid Log");
            intent.putExtra("android.intent.extra.TEXT", "Here is the MacroDroid log file.");
            FileUtils.addFileStreamToIntent(this, intent, new File(str));
            startActivity(Intent.createChooser(intent, getString(R.string.share_log)));
        } catch (ActivityNotFoundException unused) {
            ToastCompat.makeText(getApplicationContext(), (CharSequence) getString(R.string.no_app_found_to_share), 0).show();
        } catch (Exception e4) {
            ToastCompat.makeText(getApplicationContext(), (int) R.string.export_failed, 0).show();
            SystemLog.logError("Failed to export file: " + e4);
        }
    }

    private final void I() {
        boolean z3;
        boolean z4;
        boolean z5;
        View findViewById = findViewById(R.id.menu_filter);
        View findViewById2 = findViewById(R.id.menu_share_log);
        if (this.f12688j) {
            findViewById = findViewById2;
        }
        PopupMenu popupMenu = new PopupMenu(this, findViewById);
        popupMenu.inflate(R.menu.text_size_menu);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.arlosoft.macrodroid.logging.systemlog.a
            @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                boolean J;
                J = SystemLogActivity.J(SystemLogActivity.this, menuItem);
                return J;
            }
        });
        try {
            popupMenu.show();
            int logTextSize = Settings.getLogTextSize(this);
            MenuItem findItem = popupMenu.getMenu().findItem(R.id.menu_small);
            boolean z6 = true;
            if (logTextSize == 10) {
                z3 = true;
            } else {
                z3 = false;
            }
            findItem.setChecked(z3);
            MenuItem findItem2 = popupMenu.getMenu().findItem(R.id.menu_medium);
            if (logTextSize == 12) {
                z4 = true;
            } else {
                z4 = false;
            }
            findItem2.setChecked(z4);
            MenuItem findItem3 = popupMenu.getMenu().findItem(R.id.menu_large);
            if (logTextSize == 14) {
                z5 = true;
            } else {
                z5 = false;
            }
            findItem3.setChecked(z5);
            MenuItem findItem4 = popupMenu.getMenu().findItem(R.id.menu_very_large);
            if (logTextSize != 16) {
                z6 = false;
            }
            findItem4.setChecked(z6);
        } catch (Exception e4) {
            SystemLog.logError("Failed to display popupmenu: " + e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean J(SystemLogActivity this$0, MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i4 = 12;
        switch (menuItem.getItemId()) {
            case R.id.menu_large /* 2131363403 */:
                i4 = 14;
                break;
            case R.id.menu_small /* 2131363436 */:
                i4 = 10;
                break;
            case R.id.menu_very_large /* 2131363447 */:
                i4 = 16;
                break;
        }
        this$0.getPagingAdapter().setTextSize(i4);
        Settings.setLogTextSize(this$0, i4);
        return true;
    }

    private final void K() {
        boolean z3;
        ActivitySystemLogBinding activitySystemLogBinding = this.f12684f;
        ActivitySystemLogBinding activitySystemLogBinding2 = null;
        if (activitySystemLogBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activitySystemLogBinding = null;
        }
        LinearLayout linearLayout = activitySystemLogBinding.filterPanel;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.filterPanel");
        ActivitySystemLogBinding activitySystemLogBinding3 = this.f12684f;
        if (activitySystemLogBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activitySystemLogBinding2 = activitySystemLogBinding3;
        }
        LinearLayout linearLayout2 = activitySystemLogBinding2.filterPanel;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.filterPanel");
        int i4 = 0;
        if (linearLayout2.getVisibility() == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (!(!z3)) {
            i4 = 8;
        }
        linearLayout.setVisibility(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s(LogFilter logFilter) {
        ActivitySystemLogBinding activitySystemLogBinding = this.f12684f;
        ActivitySystemLogBinding activitySystemLogBinding2 = null;
        if (activitySystemLogBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activitySystemLogBinding = null;
        }
        activitySystemLogBinding.showTriggers.setChecked(logFilter.getShowTriggers(), false);
        ActivitySystemLogBinding activitySystemLogBinding3 = this.f12684f;
        if (activitySystemLogBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activitySystemLogBinding3 = null;
        }
        activitySystemLogBinding3.showActions.setChecked(logFilter.getShowActions(), false);
        ActivitySystemLogBinding activitySystemLogBinding4 = this.f12684f;
        if (activitySystemLogBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activitySystemLogBinding4 = null;
        }
        activitySystemLogBinding4.showConstraints.setChecked(logFilter.getShowConstraints(), false);
        int ordinal = logFilter.getLogLevelEnum().ordinal() - 1;
        ActivitySystemLogBinding activitySystemLogBinding5 = this.f12684f;
        if (activitySystemLogBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activitySystemLogBinding2 = activitySystemLogBinding5;
        }
        activitySystemLogBinding2.logLevelSpinner.setSelection(ordinal);
    }

    private final void t() {
        ActivitySystemLogBinding activitySystemLogBinding = null;
        if (Settings.shouldHideInfoCardSystemLog(this)) {
            ActivitySystemLogBinding activitySystemLogBinding2 = this.f12684f;
            if (activitySystemLogBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activitySystemLogBinding = activitySystemLogBinding2;
            }
            activitySystemLogBinding.infoCard.infoCardView.setVisibility(8);
            return;
        }
        ActivitySystemLogBinding activitySystemLogBinding3 = this.f12684f;
        if (activitySystemLogBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activitySystemLogBinding3 = null;
        }
        activitySystemLogBinding3.infoCard.infoCardView.setCardBackgroundColor(ContextCompat.getColor(this, R.color.system_log_primary));
        ActivitySystemLogBinding activitySystemLogBinding4 = this.f12684f;
        if (activitySystemLogBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activitySystemLogBinding4 = null;
        }
        activitySystemLogBinding4.infoCard.infoCardTitle.setText(R.string.system_log);
        ActivitySystemLogBinding activitySystemLogBinding5 = this.f12684f;
        if (activitySystemLogBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activitySystemLogBinding5 = null;
        }
        activitySystemLogBinding5.infoCard.infoCardDetail.setText(R.string.system_log_info_card);
        ActivitySystemLogBinding activitySystemLogBinding6 = this.f12684f;
        if (activitySystemLogBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activitySystemLogBinding = activitySystemLogBinding6;
        }
        activitySystemLogBinding.infoCard.infoCardGotIt.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.logging.systemlog.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SystemLogActivity.u(SystemLogActivity.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(SystemLogActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Settings.hideInfoCardSystemLog(this$0.getApplicationContext());
        ActivitySystemLogBinding activitySystemLogBinding = this$0.f12684f;
        if (activitySystemLogBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activitySystemLogBinding = null;
        }
        activitySystemLogBinding.infoCard.infoCardView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(Pair<Integer, Integer> pair) {
        String str;
        ActivitySystemLogBinding activitySystemLogBinding = null;
        if (pair.getSecond().intValue() == 0) {
            ActivitySystemLogBinding activitySystemLogBinding2 = this.f12684f;
            if (activitySystemLogBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activitySystemLogBinding = activitySystemLogBinding2;
            }
            activitySystemLogBinding.macroFilterButton.setText(getString(R.string.no_macros_configured));
        } else if (pair.getFirst().intValue() != pair.getSecond().intValue()) {
            ActivitySystemLogBinding activitySystemLogBinding3 = this.f12684f;
            if (activitySystemLogBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activitySystemLogBinding = activitySystemLogBinding3;
            }
            Button button = activitySystemLogBinding.macroFilterButton;
            try {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String string = getString(R.string.system_log_filter_x_out_of_y_macros_enabled);
                Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.syste…_out_of_y_macros_enabled)");
                str = String.format(string, Arrays.copyOf(new Object[]{pair.getFirst(), pair.getSecond()}, 2));
                Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
            } catch (Exception unused) {
                str = pair.getFirst() + RemoteSettings.FORWARD_SLASH_STRING + pair.getSecond() + " macros enabled";
            }
            button.setText(str);
        } else {
            ActivitySystemLogBinding activitySystemLogBinding4 = this.f12684f;
            if (activitySystemLogBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activitySystemLogBinding = activitySystemLogBinding4;
            }
            activitySystemLogBinding.macroFilterButton.setText(getString(R.string.system_log_filter_all_macros_enabled));
        }
    }

    private final void w() {
        final int[] intArray = getResources().getIntArray(R.array.log_levels_int);
        Intrinsics.checkNotNullExpressionValue(intArray, "if (BuildConfig.DEBUG) r…y(R.array.log_levels_int)");
        ActivitySystemLogBinding activitySystemLogBinding = this.f12684f;
        if (activitySystemLogBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activitySystemLogBinding = null;
        }
        activitySystemLogBinding.logLevelSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.arlosoft.macrodroid.logging.systemlog.SystemLogActivity$configureUi$1
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(@NotNull AdapterView<?> parent, @Nullable View view, int i4, long j4) {
                Intrinsics.checkNotNullParameter(parent, "parent");
                this.getViewModel().setFilterLogLevel(intArray[i4]);
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(@NotNull AdapterView<?> parent) {
                Intrinsics.checkNotNullParameter(parent, "parent");
            }
        });
        ActivitySystemLogBinding activitySystemLogBinding2 = this.f12684f;
        if (activitySystemLogBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activitySystemLogBinding2 = null;
        }
        BetterCheckBox betterCheckBox = activitySystemLogBinding2.showTriggers;
        Intrinsics.checkNotNullExpressionValue(betterCheckBox, "binding.showTriggers");
        Sdk27CoroutinesListenersWithCoroutinesKt.onCheckedChange$default(betterCheckBox, (CoroutineContext) null, new a(null), 1, (Object) null);
        ActivitySystemLogBinding activitySystemLogBinding3 = this.f12684f;
        if (activitySystemLogBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activitySystemLogBinding3 = null;
        }
        BetterCheckBox betterCheckBox2 = activitySystemLogBinding3.showActions;
        Intrinsics.checkNotNullExpressionValue(betterCheckBox2, "binding.showActions");
        Sdk27CoroutinesListenersWithCoroutinesKt.onCheckedChange$default(betterCheckBox2, (CoroutineContext) null, new b(null), 1, (Object) null);
        ActivitySystemLogBinding activitySystemLogBinding4 = this.f12684f;
        if (activitySystemLogBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activitySystemLogBinding4 = null;
        }
        BetterCheckBox betterCheckBox3 = activitySystemLogBinding4.showConstraints;
        Intrinsics.checkNotNullExpressionValue(betterCheckBox3, "binding.showConstraints");
        Sdk27CoroutinesListenersWithCoroutinesKt.onCheckedChange$default(betterCheckBox3, (CoroutineContext) null, new c(null), 1, (Object) null);
        ActivitySystemLogBinding activitySystemLogBinding5 = this.f12684f;
        if (activitySystemLogBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activitySystemLogBinding5 = null;
        }
        Button button = activitySystemLogBinding5.macroFilterButton;
        Intrinsics.checkNotNullExpressionValue(button, "binding.macroFilterButton");
        ViewExtensionsKt.onClick$default(button, null, new d(null), 1, null);
        ActivitySystemLogBinding activitySystemLogBinding6 = this.f12684f;
        if (activitySystemLogBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activitySystemLogBinding6 = null;
        }
        Button button2 = activitySystemLogBinding6.variablesFilterButton;
        Intrinsics.checkNotNullExpressionValue(button2, "binding.variablesFilterButton");
        ViewExtensionsKt.onClick$default(button2, null, new e(null), 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x(Pair<Integer, Integer> pair) {
        String str;
        ActivitySystemLogBinding activitySystemLogBinding = null;
        if (pair.getSecond().intValue() == 0) {
            ActivitySystemLogBinding activitySystemLogBinding2 = this.f12684f;
            if (activitySystemLogBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activitySystemLogBinding = activitySystemLogBinding2;
            }
            activitySystemLogBinding.variablesFilterButton.setText(getString(R.string.no_variables_configured));
        } else if (pair.getFirst().intValue() != pair.getSecond().intValue()) {
            ActivitySystemLogBinding activitySystemLogBinding3 = this.f12684f;
            if (activitySystemLogBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activitySystemLogBinding = activitySystemLogBinding3;
            }
            Button button = activitySystemLogBinding.variablesFilterButton;
            try {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String string = getString(R.string.system_log_filter_x_out_of_y_variables_enabled);
                Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.syste…t_of_y_variables_enabled)");
                str = String.format(string, Arrays.copyOf(new Object[]{pair.getFirst(), pair.getSecond()}, 2));
                Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
            } catch (Exception unused) {
                str = pair.getFirst() + RemoteSettings.FORWARD_SLASH_STRING + pair.getSecond() + " variables enabled";
            }
            button.setText(str);
        } else {
            ActivitySystemLogBinding activitySystemLogBinding4 = this.f12684f;
            if (activitySystemLogBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activitySystemLogBinding = activitySystemLogBinding4;
            }
            activitySystemLogBinding.variablesFilterButton.setText(getString(R.string.system_log_filter_all_variables_enabled));
        }
    }

    private final void y() {
        getPagingAdapter().addLoadStateListener(new f());
        ActivitySystemLogBinding activitySystemLogBinding = this.f12684f;
        ActivitySystemLogBinding activitySystemLogBinding2 = null;
        if (activitySystemLogBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activitySystemLogBinding = null;
        }
        activitySystemLogBinding.recyclerView.setAdapter(getPagingAdapter());
        ActivitySystemLogBinding activitySystemLogBinding3 = this.f12684f;
        if (activitySystemLogBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activitySystemLogBinding2 = activitySystemLogBinding3;
        }
        CardView cardView = activitySystemLogBinding2.infoCard.infoCardView;
        getPagingAdapter().registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() { // from class: com.arlosoft.macrodroid.logging.systemlog.SystemLogActivity$configureViewModelObservers$2
            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeInserted(int i4, int i5) {
                ActivitySystemLogBinding activitySystemLogBinding4 = SystemLogActivity.this.f12684f;
                ActivitySystemLogBinding activitySystemLogBinding5 = null;
                if (activitySystemLogBinding4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activitySystemLogBinding4 = null;
                }
                activitySystemLogBinding4.viewFlipper.setDisplayedChild(1);
                if (i4 == 0) {
                    ActivitySystemLogBinding activitySystemLogBinding6 = SystemLogActivity.this.f12684f;
                    if (activitySystemLogBinding6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        activitySystemLogBinding6 = null;
                    }
                    RecyclerView.LayoutManager layoutManager = activitySystemLogBinding6.recyclerView.getLayoutManager();
                    Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                    if (((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition() == 0) {
                        ActivitySystemLogBinding activitySystemLogBinding7 = SystemLogActivity.this.f12684f;
                        if (activitySystemLogBinding7 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                        } else {
                            activitySystemLogBinding5 = activitySystemLogBinding7;
                        }
                        activitySystemLogBinding5.recyclerView.scrollToPosition(0);
                    }
                }
            }
        });
        getViewModel().getPageLiveData().observe(this, new g());
        getViewModel().getRefreshEvent().observe(this, new h());
        getViewModel().getShareLogEvent().observe(this, new i());
        getViewModel().getFilter().observe(this, new j());
        getViewModel().getMacroCount().observe(this, new k());
        getViewModel().getVariableCount().observe(this, new l());
    }

    private final void z() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.clear_log);
        builder.setMessage(R.string.are_you_sure_clear_log);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.logging.systemlog.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                SystemLogActivity.A(SystemLogActivity.this, dialogInterface, i4);
            }
        });
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.logging.systemlog.d
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                SystemLogActivity.B(dialogInterface, i4);
            }
        });
        builder.show();
    }

    @NotNull
    public final SystemLogAdapter getPagingAdapter() {
        SystemLogAdapter systemLogAdapter = this.pagingAdapter;
        if (systemLogAdapter != null) {
            return systemLogAdapter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("pagingAdapter");
        return null;
    }

    @NotNull
    public final String getSearchTerm() {
        return this.f12687i;
    }

    @NotNull
    public final SystemLogViewModel getViewModel() {
        SystemLogViewModel systemLogViewModel = this.viewModel;
        if (systemLogViewModel != null) {
            return systemLogViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity, com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        ActivitySystemLogBinding inflate = ActivitySystemLogBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater)");
        this.f12684f = inflate;
        ActivitySystemLogBinding activitySystemLogBinding = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        setContentView(inflate.getRoot());
        ActivitySystemLogBinding activitySystemLogBinding2 = this.f12684f;
        if (activitySystemLogBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activitySystemLogBinding2 = null;
        }
        setSupportActionBar(activitySystemLogBinding2.toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
        ActionBar supportActionBar2 = getSupportActionBar();
        if (supportActionBar2 != null) {
            supportActionBar2.setTitle("");
        }
        ActivitySystemLogBinding activitySystemLogBinding3 = this.f12684f;
        if (activitySystemLogBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activitySystemLogBinding3 = null;
        }
        activitySystemLogBinding3.title.setText(getString(R.string.system_log));
        ActivitySystemLogBinding activitySystemLogBinding4 = this.f12684f;
        if (activitySystemLogBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activitySystemLogBinding4 = null;
        }
        LayoutTransition layoutTransition = activitySystemLogBinding4.rootContent.getLayoutTransition();
        Intrinsics.checkNotNullExpressionValue(layoutTransition, "binding.rootContent.getLayoutTransition()");
        layoutTransition.enableTransitionType(4);
        ActivitySystemLogBinding activitySystemLogBinding5 = this.f12684f;
        if (activitySystemLogBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activitySystemLogBinding5 = null;
        }
        activitySystemLogBinding5.recyclerView.setItemAnimator(null);
        ActivitySystemLogBinding activitySystemLogBinding6 = this.f12684f;
        if (activitySystemLogBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activitySystemLogBinding6 = null;
        }
        RecyclerView.LayoutManager layoutManager = activitySystemLogBinding6.recyclerView.getLayoutManager();
        Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        ((LinearLayoutManager) layoutManager).setReverseLayout(Settings.getReverseSystemLog(this));
        setPagingAdapter(new SystemLogAdapter(this.f12685g, E(), Settings.getReverseSystemLog(this), Settings.getSystemLogShowMilliSeconds(this)));
        getPagingAdapter().setTextSize(Settings.getLogTextSize(this));
        getLifecycle().addObserver(getViewModel());
        long longExtra = getIntent().getLongExtra(f12683l, 0L);
        if (longExtra != 0) {
            getViewModel().filterForSingleMacro(longExtra);
            this.f12688j = true;
            ActivitySystemLogBinding activitySystemLogBinding7 = this.f12684f;
            if (activitySystemLogBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activitySystemLogBinding = activitySystemLogBinding7;
            }
            activitySystemLogBinding.macroName.setText(MacroStore.getInstance().getMacroByGUID(longExtra).getName());
        } else {
            ActivitySystemLogBinding activitySystemLogBinding8 = this.f12684f;
            if (activitySystemLogBinding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activitySystemLogBinding = activitySystemLogBinding8;
            }
            TextView textView = activitySystemLogBinding.macroName;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.macroName");
            textView.setVisibility(8);
        }
        w();
        y();
        t();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(@NotNull final Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        getMenuInflater().inflate(R.menu.system_log_menu, menu);
        boolean z3 = false;
        if (this.f12688j) {
            menu.findItem(R.id.menu_filter).setVisible(false);
            menu.findItem(R.id.menu_clear_log).setVisible(false);
        }
        menu.findItem(R.id.show_milliseconds).setChecked(Settings.getSystemLogShowMilliSeconds(this));
        View actionView = menu.findItem(R.id.menu_search).getActionView();
        Intrinsics.checkNotNull(actionView, "null cannot be cast to non-null type androidx.appcompat.widget.SearchView");
        SearchView searchView = (SearchView) actionView;
        this.f12686h = searchView;
        if (searchView != null) {
            searchView.setQuery(getSearchTerm(), false);
            if (this.f12687i.length() > 0) {
                z3 = true;
            }
            if (z3) {
                searchView.clearFocus();
            }
            searchView.setOnCloseListener(new SearchView.OnCloseListener() { // from class: com.arlosoft.macrodroid.logging.systemlog.e
                @Override // androidx.appcompat.widget.SearchView.OnCloseListener
                public final boolean onClose() {
                    boolean F;
                    F = SystemLogActivity.F(SystemLogActivity.this, menu);
                    return F;
                }
            });
            searchView.setOnQueryTextFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.arlosoft.macrodroid.logging.systemlog.f
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z4) {
                    SystemLogActivity.G(SystemLogActivity.this, menu, view, z4);
                }
            });
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() { // from class: com.arlosoft.macrodroid.logging.systemlog.SystemLogActivity$onCreateOptionsMenu$1$3
                @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
                public boolean onQueryTextChange(@NotNull String newText) {
                    Intrinsics.checkNotNullParameter(newText, "newText");
                    SystemLogActivity.this.getViewModel().updateSearchText(newText);
                    return true;
                }

                @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
                public boolean onQueryTextSubmit(@NotNull String query) {
                    Intrinsics.checkNotNullParameter(query, "query");
                    return false;
                }
            });
        }
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(@NotNull MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        switch (item.getItemId()) {
            case 16908332:
                finish();
                break;
            case R.id.invert_order /* 2131363135 */:
                C();
                break;
            case R.id.menu_clear_log /* 2131363380 */:
                z();
                break;
            case R.id.menu_filter /* 2131363395 */:
                K();
                break;
            case R.id.menu_share_log /* 2131363429 */:
                getViewModel().onShareClicked();
                break;
            case R.id.menu_share_log_html /* 2131363430 */:
                getViewModel().onShareHtmlClicked();
                break;
            case R.id.menu_text_size /* 2131363440 */:
                I();
                break;
            case R.id.show_milliseconds /* 2131364029 */:
                boolean z3 = !Settings.getSystemLogShowMilliSeconds(this);
                Settings.setSystemLogShowMilliSeconds(this, z3);
                getPagingAdapter().setShowMilliseconds(z3);
                item.setChecked(z3);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public final void setPagingAdapter(@NotNull SystemLogAdapter systemLogAdapter) {
        Intrinsics.checkNotNullParameter(systemLogAdapter, "<set-?>");
        this.pagingAdapter = systemLogAdapter;
    }

    public final void setViewModel(@NotNull SystemLogViewModel systemLogViewModel) {
        Intrinsics.checkNotNullParameter(systemLogViewModel, "<set-?>");
        this.viewModel = systemLogViewModel;
    }
}
