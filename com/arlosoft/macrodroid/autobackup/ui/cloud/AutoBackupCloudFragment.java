package com.arlosoft.macrodroid.autobackup.ui.cloud;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.SwitchCompat;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseFragment;
import com.arlosoft.macrodroid.autobackup.ui.cloud.AutoBackupUiState;
import com.arlosoft.macrodroid.databinding.FragmentCloudBackupBinding;
import com.arlosoft.macrodroid.extensions.ViewExtensionsKt;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.templatestore.model.User;
import com.arlosoft.macrodroid.upgrade.UpgradeActivity2;
import com.arlosoft.macrodroid.user.signin.SignInHelper;
import com.arlosoft.macrodroid.utils.SingleLiveEvent;
import com.firebase.ui.auth.FirebaseUiException;
import com.firebase.ui.auth.IdpResponse;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import es.dmoral.toasty.Toasty;
import io.reactivex.disposables.CompositeDisposable;
import java.io.File;
import java.util.List;
import java.util.concurrent.CancellationException;
import javax.inject.Inject;
import kotlin.Function;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.u;
import me.drakeet.support.toast.ToastCompat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import splitties.alertdialog.appcompat.AlertDialogKt;

/* compiled from: AutoBackupCloudFragment.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nAutoBackupCloudFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AutoBackupCloudFragment.kt\ncom/arlosoft/macrodroid/autobackup/ui/cloud/AutoBackupCloudFragment\n+ 2 TextView.kt\nandroidx/core/widget/TextViewKt\n+ 3 AlertDialog.kt\nsplitties/alertdialog/appcompat/AlertDialogKt\n+ 4 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,387:1\n65#2,16:388\n93#2,3:404\n27#3,3:407\n165#3,2:410\n183#3,2:412\n30#3:414\n84#3,3:415\n27#3,3:436\n165#3,2:439\n30#3:441\n27#3,3:442\n165#3,2:445\n183#3,2:447\n30#3:449\n262#4,2:418\n262#4,2:420\n262#4,2:422\n262#4,2:424\n262#4,2:426\n262#4,2:428\n262#4,2:430\n262#4,2:432\n262#4,2:434\n*S KotlinDebug\n*F\n+ 1 AutoBackupCloudFragment.kt\ncom/arlosoft/macrodroid/autobackup/ui/cloud/AutoBackupCloudFragment\n*L\n156#1:388,16\n156#1:404,3\n176#1:407,3\n179#1:410,2\n180#1:412,2\n176#1:414\n181#1:415,3\n363#1:436,3\n366#1:439,2\n363#1:441\n380#1:442,3\n383#1:445,2\n384#1:447,2\n380#1:449\n214#1:418,2\n276#1:420,2\n277#1:422,2\n279#1:424,2\n280#1:426,2\n283#1:428,2\n284#1:430,2\n286#1:432,2\n287#1:434,2\n*E\n"})
/* loaded from: classes3.dex */
public final class AutoBackupCloudFragment extends MacroDroidDaggerBaseFragment {

    /* renamed from: b  reason: collision with root package name */
    private FragmentCloudBackupBinding f9322b;

    /* renamed from: c  reason: collision with root package name */
    private CompositeDisposable f9323c;

    /* renamed from: d  reason: collision with root package name */
    private CloudBackupListAdapter f9324d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private SwitchCompat f9325e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f9326f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f9327g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private Dialog f9328h;
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    private final CompletableJob f9329i;
    @NotNull

    /* renamed from: j  reason: collision with root package name */
    private final CoroutineScope f9330j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f9331k;
    @Inject
    public SignInHelper signInHelper;
    @Inject
    public AutoBackupCloudViewModel viewModel;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: AutoBackupCloudFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final AutoBackupCloudFragment createFragment() {
            return new AutoBackupCloudFragment();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AutoBackupCloudFragment.kt */
    /* loaded from: classes3.dex */
    public static final class a implements Observer<AutoBackupUiState> {
        a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public final void onChanged(@NotNull AutoBackupUiState it) {
            Intrinsics.checkNotNullParameter(it, "it");
            AutoBackupCloudFragment.this.g(it);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AutoBackupCloudFragment.kt */
    /* loaded from: classes3.dex */
    public static final class b implements Observer<Boolean> {
        b() {
        }

        public final void a(boolean z3) {
            SwitchCompat switchCompat = AutoBackupCloudFragment.this.f9325e;
            if (switchCompat != null) {
                switchCompat.setChecked(z3);
            }
            AutoBackupCloudFragment.this.f9327g = z3;
        }

        @Override // androidx.lifecycle.Observer
        public /* bridge */ /* synthetic */ void onChanged(Boolean bool) {
            a(bool.booleanValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AutoBackupCloudFragment.kt */
    /* loaded from: classes3.dex */
    public static final class c implements Observer<BackupFailReason> {
        c() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public final void onChanged(@Nullable BackupFailReason backupFailReason) {
            Dialog dialog = AutoBackupCloudFragment.this.f9328h;
            if (dialog != null) {
                dialog.hide();
            }
            AutoBackupCloudFragment.this.f9328h = null;
            if (backupFailReason == BackupFailReason.NO_MACROS) {
                ToastCompat.makeText(AutoBackupCloudFragment.this.requireContext(), (CharSequence) AutoBackupCloudFragment.this.getString(R.string.no_macros_configured), 1).show();
            } else {
                ToastCompat.makeText(AutoBackupCloudFragment.this.requireContext(), (CharSequence) AutoBackupCloudFragment.this.getString(R.string.cloud_backup_failed_error_message), 1).show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AutoBackupCloudFragment.kt */
    /* loaded from: classes3.dex */
    public static final class d implements Observer<Void> {
        d() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public final void onChanged(@Nullable Void r32) {
            Dialog dialog = AutoBackupCloudFragment.this.f9328h;
            if (dialog != null) {
                dialog.hide();
            }
            AutoBackupCloudFragment.this.f9328h = null;
            ToastCompat.makeText(AutoBackupCloudFragment.this.requireContext(), (CharSequence) AutoBackupCloudFragment.this.getString(R.string.delete_failed), 1).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AutoBackupCloudFragment.kt */
    /* loaded from: classes3.dex */
    public static final class e implements Observer<BackupFailReason> {
        e() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public final void onChanged(@Nullable BackupFailReason backupFailReason) {
            Dialog dialog = AutoBackupCloudFragment.this.f9328h;
            if (dialog != null) {
                dialog.hide();
            }
            AutoBackupCloudFragment.this.f9328h = null;
            ToastCompat.makeText(AutoBackupCloudFragment.this.requireContext(), (CharSequence) AutoBackupCloudFragment.this.getString(R.string.backup_file_restore_failed), 1).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AutoBackupCloudFragment.kt */
    /* loaded from: classes3.dex */
    public static final class f implements Observer<Pair<? extends BackupInfo, ? extends String>> {
        f() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public final void onChanged(@Nullable Pair<BackupInfo, String> pair) {
            AutoBackupCloudFragment autoBackupCloudFragment = AutoBackupCloudFragment.this;
            Intrinsics.checkNotNull(pair);
            autoBackupCloudFragment.q(pair.getFirst(), pair.getSecond());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AutoBackupCloudFragment.kt */
    /* loaded from: classes3.dex */
    public static final class g implements Observer<Pair<? extends BackupInfo, ? extends String>> {
        g() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public final void onChanged(@Nullable Pair<BackupInfo, String> pair) {
            AutoBackupCloudFragment autoBackupCloudFragment = AutoBackupCloudFragment.this;
            Intrinsics.checkNotNull(pair);
            autoBackupCloudFragment.n(pair.getFirst(), pair.getSecond());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AutoBackupCloudFragment.kt */
    /* loaded from: classes3.dex */
    public static final class h implements Observer<Boolean> {
        h() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public final void onChanged(@Nullable Boolean bool) {
            AutoBackupCloudFragment autoBackupCloudFragment = AutoBackupCloudFragment.this;
            Intrinsics.checkNotNull(bool);
            autoBackupCloudFragment.j(bool.booleanValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AutoBackupCloudFragment.kt */
    /* loaded from: classes3.dex */
    public static final class i extends Lambda implements Function1<File, Unit> {
        i() {
            super(1);
        }

        public final void a(@Nullable File file) {
            AutoBackupCloudFragment autoBackupCloudFragment = AutoBackupCloudFragment.this;
            Intrinsics.checkNotNull(file);
            autoBackupCloudFragment.t(file);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(File file) {
            a(file);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AutoBackupCloudFragment.kt */
    /* loaded from: classes3.dex */
    public static final class j extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        int label;

        j(Continuation<? super j> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new j(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                AutoBackupCloudFragment.this.getViewModel().refresh();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AutoBackupCloudFragment.kt */
    /* loaded from: classes3.dex */
    public static final class k implements Observer, FunctionAdapter {

        /* renamed from: a  reason: collision with root package name */
        private final /* synthetic */ Function1 f9346a;

        k(Function1 function) {
            Intrinsics.checkNotNullParameter(function, "function");
            this.f9346a = function;
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
            return this.f9346a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f9346a.invoke(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AutoBackupCloudFragment.kt */
    /* loaded from: classes3.dex */
    public static final class l extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        l(Continuation<? super l> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new l(continuation);
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
                this.label = 1;
                if (DelayKt.delay(500L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            FragmentActivity activity = AutoBackupCloudFragment.this.getActivity();
            if (activity != null) {
                activity.invalidateOptionsMenu();
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((l) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AutoBackupCloudFragment.kt */
    /* loaded from: classes3.dex */
    public static final class m extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        m(Continuation<? super m> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new m(continuation);
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
                this.label = 1;
                if (DelayKt.delay(500L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            FragmentActivity activity = AutoBackupCloudFragment.this.getActivity();
            if (activity != null) {
                activity.invalidateOptionsMenu();
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((m) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AutoBackupCloudFragment.kt */
    /* loaded from: classes3.dex */
    public static final class n extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        int label;

        n(Continuation<? super n> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new n(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                AutoBackupCloudFragment.this.getSignInHelper().signIn(AutoBackupCloudFragment.this);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AutoBackupCloudFragment.kt */
    /* loaded from: classes3.dex */
    public static final class o extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        o(Continuation<? super o> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new o(continuation);
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
                this.label = 1;
                if (DelayKt.delay(500L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            FragmentActivity activity = AutoBackupCloudFragment.this.getActivity();
            if (activity != null) {
                activity.invalidateOptionsMenu();
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((o) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AutoBackupCloudFragment.kt */
    /* loaded from: classes3.dex */
    public static final class p extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        int label;

        p(Continuation<? super p> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new p(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                UpgradeActivity2.Companion companion = UpgradeActivity2.Companion;
                FragmentActivity requireActivity = AutoBackupCloudFragment.this.requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
                companion.animateInUpgradeSceen(requireActivity);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public AutoBackupCloudFragment() {
        CompletableJob c4;
        c4 = u.c(null, 1, null);
        this.f9329i = c4;
        this.f9330j = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(c4));
        this.f9331k = true;
    }

    private final void A() {
        this.f9326f = false;
        kotlinx.coroutines.e.e(this.f9330j, Dispatchers.getMain(), null, new o(null), 2, null);
        FragmentCloudBackupBinding fragmentCloudBackupBinding = this.f9322b;
        if (fragmentCloudBackupBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentCloudBackupBinding = null;
        }
        fragmentCloudBackupBinding.viewFlipper.setDisplayedChild(1);
        FragmentCloudBackupBinding fragmentCloudBackupBinding2 = this.f9322b;
        if (fragmentCloudBackupBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentCloudBackupBinding2 = null;
        }
        fragmentCloudBackupBinding2.upgradeSignInText.setText(getString(R.string.cloud_backup_pro_users_info));
        FragmentCloudBackupBinding fragmentCloudBackupBinding3 = this.f9322b;
        if (fragmentCloudBackupBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentCloudBackupBinding3 = null;
        }
        fragmentCloudBackupBinding3.upgradeSignInButton.setText(getString(R.string.upgrade_to_pro));
        FragmentCloudBackupBinding fragmentCloudBackupBinding4 = this.f9322b;
        if (fragmentCloudBackupBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentCloudBackupBinding4 = null;
        }
        Button button = fragmentCloudBackupBinding4.upgradeSignInButton;
        Intrinsics.checkNotNullExpressionValue(button, "binding.upgradeSignInButton");
        ViewExtensionsKt.onClick$default(button, null, new p(null), 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(AutoBackupUiState autoBackupUiState) {
        if (Intrinsics.areEqual(autoBackupUiState, AutoBackupUiState.ProOnlyScreen.INSTANCE)) {
            A();
        } else if (Intrinsics.areEqual(autoBackupUiState, AutoBackupUiState.SignInScreen.INSTANCE)) {
            z();
        } else if (Intrinsics.areEqual(autoBackupUiState, AutoBackupUiState.BackingUp.INSTANCE)) {
            m();
        } else if (Intrinsics.areEqual(autoBackupUiState, AutoBackupUiState.Deleting.INSTANCE)) {
            r();
        } else if (Intrinsics.areEqual(autoBackupUiState, AutoBackupUiState.Restoring.INSTANCE)) {
            y();
        } else if (autoBackupUiState instanceof AutoBackupUiState.BackupListScreen) {
            AutoBackupUiState.BackupListScreen backupListScreen = (AutoBackupUiState.BackupListScreen) autoBackupUiState;
            p(backupListScreen.isLoading(), backupListScreen.getFailedState(), backupListScreen.getBackupList(), backupListScreen.getDeviceId());
        }
    }

    private final void h() {
        getViewModel().getUiState().observe(getViewLifecycleOwner(), new a());
        getViewModel().getEnabledState().observe(getViewLifecycleOwner(), new b());
        SingleLiveEvent<BackupFailReason> backupFailedEvent = getViewModel().getBackupFailedEvent();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        backupFailedEvent.observe(viewLifecycleOwner, new c());
        SingleLiveEvent<Void> deleteFailedEvent = getViewModel().getDeleteFailedEvent();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "viewLifecycleOwner");
        deleteFailedEvent.observe(viewLifecycleOwner2, new d());
        SingleLiveEvent<BackupFailReason> backupFailedEvent2 = getViewModel().getBackupFailedEvent();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "viewLifecycleOwner");
        backupFailedEvent2.observe(viewLifecycleOwner3, new e());
        SingleLiveEvent<Pair<BackupInfo, String>> showLongPressOptionsEvent = getViewModel().getShowLongPressOptionsEvent();
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner4, "viewLifecycleOwner");
        showLongPressOptionsEvent.observe(viewLifecycleOwner4, new f());
        SingleLiveEvent<Pair<BackupInfo, String>> showBackupDialogEvent = getViewModel().getShowBackupDialogEvent();
        LifecycleOwner viewLifecycleOwner5 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner5, "viewLifecycleOwner");
        showBackupDialogEvent.observe(viewLifecycleOwner5, new g());
        SingleLiveEvent<Boolean> restoreBackupEvent = getViewModel().getRestoreBackupEvent();
        LifecycleOwner viewLifecycleOwner6 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner6, "viewLifecycleOwner");
        restoreBackupEvent.observe(viewLifecycleOwner6, new h());
        SingleLiveEvent<File> promptForPasswordEvent = getViewModel().getPromptForPasswordEvent();
        LifecycleOwner viewLifecycleOwner7 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner7, "viewLifecycleOwner");
        promptForPasswordEvent.observe(viewLifecycleOwner7, new k(new i()));
    }

    private final void i() {
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity);
        AlertDialogKt.setTitleResource(builder, R.string.delete_all_backups);
        AlertDialogKt.setMessageResource(builder, R.string.are_you_sure);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.autobackup.ui.cloud.AutoBackupCloudFragment$confirmDeleteAll$lambda$14$$inlined$okButton$1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(@NotNull DialogInterface dialog, int i4) {
                Intrinsics.checkNotNullParameter(dialog, "dialog");
                AutoBackupCloudFragment.this.getViewModel().deleteAllBackups();
            }
        });
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.autobackup.ui.cloud.AutoBackupCloudFragment$confirmDeleteAll$lambda$14$$inlined$cancelButton$1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(@NotNull DialogInterface dialog, int i4) {
                Intrinsics.checkNotNullParameter(dialog, "dialog");
            }
        });
        AlertDialog create = builder.create();
        Intrinsics.checkNotNullExpressionValue(create, "Builder(this)\n        .apply(dialogConfig)\n        .create()");
        create.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(boolean z3) {
        Dialog dialog = this.f9328h;
        if (dialog != null) {
            dialog.hide();
        }
        this.f9328h = null;
        if (z3) {
            Toasty.Config.getInstance().setTextColor(-1).tintIcon(false).apply();
            Toasty.custom(requireContext(), (CharSequence) getString(R.string.backup_file_restored), (Drawable) null, ContextCompat.getColor(requireContext(), R.color.md_green_600), 1, false, true).show();
            requireActivity().finish();
            return;
        }
        Toasty.Config.getInstance().setTextColor(-1).tintIcon(false).apply();
        Toasty.custom(requireContext(), (CharSequence) getString(R.string.backup_file_restore_failed), (Drawable) null, ContextCompat.getColor(requireContext(), R.color.md_red_600), 1, false, true).show();
    }

    private final void k() {
        List emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.f9324d = new CloudBackupListAdapter(emptyList, getViewModel());
        FragmentCloudBackupBinding fragmentCloudBackupBinding = this.f9322b;
        if (fragmentCloudBackupBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentCloudBackupBinding = null;
        }
        RecyclerView recyclerView = fragmentCloudBackupBinding.recyclerView;
        CloudBackupListAdapter cloudBackupListAdapter = this.f9324d;
        if (cloudBackupListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            cloudBackupListAdapter = null;
        }
        recyclerView.setAdapter(cloudBackupListAdapter);
        FragmentCloudBackupBinding fragmentCloudBackupBinding2 = this.f9322b;
        if (fragmentCloudBackupBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentCloudBackupBinding2 = null;
        }
        Button button = fragmentCloudBackupBinding2.retryButton;
        Intrinsics.checkNotNullExpressionValue(button, "binding.retryButton");
        ViewExtensionsKt.onClick$default(button, null, new j(null), 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(AutoBackupCloudFragment this$0, CompoundButton compoundButton, boolean z3) {
        int i4;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().onCloudBackEndabledStateChanged(z3);
        Context requireContext = this$0.requireContext();
        String string = this$0.getString(R.string.cloud_backup);
        if (z3) {
            i4 = R.string.enabled;
        } else {
            i4 = R.string.disabled;
        }
        String string2 = this$0.getString(i4);
        ToastCompat.makeText(requireContext, (CharSequence) (string + " - " + string2), 0).show();
    }

    private final void m() {
        String string = getString(R.string.cloud_backup_backing_up_to_cloud);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.cloud…ckup_backing_up_to_cloud)");
        x(string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(final BackupInfo backupInfo, String str) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        builder.setTitle(str);
        builder.setMessage(R.string.restore_backup_dialog_text);
        builder.setPositiveButton(R.string.restore_backup, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.autobackup.ui.cloud.a
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                AutoBackupCloudFragment.o(AutoBackupCloudFragment.this, backupInfo, dialogInterface, i4);
            }
        });
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(AutoBackupCloudFragment this$0, BackupInfo backupInfo, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(backupInfo, "$backupInfo");
        this$0.getViewModel().restoreBackup(backupInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(boolean z3, boolean z4, List<BackupInfo> list, String str) {
        int i4;
        Dialog dialog = this.f9328h;
        if (dialog != null) {
            dialog.hide();
        }
        FragmentCloudBackupBinding fragmentCloudBackupBinding = null;
        this.f9328h = null;
        FragmentCloudBackupBinding fragmentCloudBackupBinding2 = this.f9322b;
        if (fragmentCloudBackupBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentCloudBackupBinding2 = null;
        }
        fragmentCloudBackupBinding2.viewFlipper.setDisplayedChild(2);
        this.f9326f = true;
        kotlinx.coroutines.e.e(this.f9330j, Dispatchers.getMain(), null, new l(null), 2, null);
        CloudBackupListAdapter cloudBackupListAdapter = this.f9324d;
        if (cloudBackupListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            cloudBackupListAdapter = null;
        }
        cloudBackupListAdapter.setDeviceId(str);
        CloudBackupListAdapter cloudBackupListAdapter2 = this.f9324d;
        if (cloudBackupListAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            cloudBackupListAdapter2 = null;
        }
        cloudBackupListAdapter2.setItems(list);
        int i5 = 0;
        if (z3) {
            FragmentCloudBackupBinding fragmentCloudBackupBinding3 = this.f9322b;
            if (fragmentCloudBackupBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentCloudBackupBinding3 = null;
            }
            FrameLayout frameLayout = fragmentCloudBackupBinding3.loadingView;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.loadingView");
            frameLayout.setVisibility(0);
            FragmentCloudBackupBinding fragmentCloudBackupBinding4 = this.f9322b;
            if (fragmentCloudBackupBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentCloudBackupBinding = fragmentCloudBackupBinding4;
            }
            FrameLayout frameLayout2 = fragmentCloudBackupBinding.emptyView;
            Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.emptyView");
            frameLayout2.setVisibility(8);
            return;
        }
        FragmentCloudBackupBinding fragmentCloudBackupBinding5 = this.f9322b;
        if (fragmentCloudBackupBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentCloudBackupBinding5 = null;
        }
        FrameLayout frameLayout3 = fragmentCloudBackupBinding5.loadingView;
        Intrinsics.checkNotNullExpressionValue(frameLayout3, "binding.loadingView");
        frameLayout3.setVisibility(8);
        FragmentCloudBackupBinding fragmentCloudBackupBinding6 = this.f9322b;
        if (fragmentCloudBackupBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentCloudBackupBinding6 = null;
        }
        RecyclerView recyclerView = fragmentCloudBackupBinding6.recyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
        if (!list.isEmpty()) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        recyclerView.setVisibility(i4);
        if (z4) {
            FragmentCloudBackupBinding fragmentCloudBackupBinding7 = this.f9322b;
            if (fragmentCloudBackupBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentCloudBackupBinding7 = null;
            }
            FrameLayout frameLayout4 = fragmentCloudBackupBinding7.emptyView;
            Intrinsics.checkNotNullExpressionValue(frameLayout4, "binding.emptyView");
            frameLayout4.setVisibility(8);
            FragmentCloudBackupBinding fragmentCloudBackupBinding8 = this.f9322b;
            if (fragmentCloudBackupBinding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentCloudBackupBinding = fragmentCloudBackupBinding8;
            }
            FrameLayout frameLayout5 = fragmentCloudBackupBinding.failedDownloadView;
            Intrinsics.checkNotNullExpressionValue(frameLayout5, "binding.failedDownloadView");
            frameLayout5.setVisibility(0);
            return;
        }
        FragmentCloudBackupBinding fragmentCloudBackupBinding9 = this.f9322b;
        if (fragmentCloudBackupBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentCloudBackupBinding9 = null;
        }
        FrameLayout frameLayout6 = fragmentCloudBackupBinding9.failedDownloadView;
        Intrinsics.checkNotNullExpressionValue(frameLayout6, "binding.failedDownloadView");
        frameLayout6.setVisibility(8);
        FragmentCloudBackupBinding fragmentCloudBackupBinding10 = this.f9322b;
        if (fragmentCloudBackupBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentCloudBackupBinding = fragmentCloudBackupBinding10;
        }
        FrameLayout frameLayout7 = fragmentCloudBackupBinding.emptyView;
        Intrinsics.checkNotNullExpressionValue(frameLayout7, "binding.emptyView");
        if (!list.isEmpty()) {
            i5 = 8;
        }
        frameLayout7.setVisibility(i5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(final BackupInfo backupInfo, String str) {
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity);
        AlertDialogKt.setTitle(builder, str);
        AlertDialogKt.setMessageResource(builder, R.string.confirm_backup_delete);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.autobackup.ui.cloud.AutoBackupCloudFragment$showDeleteDialog$lambda$6$$inlined$okButton$1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(@NotNull DialogInterface dialog, int i4) {
                Intrinsics.checkNotNullParameter(dialog, "dialog");
                AutoBackupCloudFragment.this.getViewModel().deleteBackup(backupInfo);
            }
        });
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.autobackup.ui.cloud.AutoBackupCloudFragment$showDeleteDialog$lambda$6$$inlined$cancelButton$1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(@NotNull DialogInterface dialog, int i4) {
                Intrinsics.checkNotNullParameter(dialog, "dialog");
            }
        });
        final androidx.appcompat.app.AlertDialog create = builder.create();
        Intrinsics.checkNotNullExpressionValue(create, "Builder(this)\n        .apply(dialogConfig)\n        .create()");
        create.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.arlosoft.macrodroid.autobackup.ui.cloud.AutoBackupCloudFragment$showDeleteDialog$$inlined$onShow$1
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
            }
        });
        create.show();
    }

    private final void r() {
        String string = getString(R.string.cloud_backup_deleting_message);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.cloud_backup_deleting_message)");
        x(string);
    }

    private final void s() {
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity);
        AlertDialogKt.setTitleResource(builder, R.string.error);
        AlertDialogKt.setMessageResource(builder, R.string.cloud_backup_google_services_required);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.autobackup.ui.cloud.AutoBackupCloudFragment$showErrorWithSignInDialog$lambda$10$$inlined$okButton$1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(@NotNull DialogInterface dialog, int i4) {
                Intrinsics.checkNotNullParameter(dialog, "dialog");
            }
        });
        androidx.appcompat.app.AlertDialog create = builder.create();
        Intrinsics.checkNotNullExpressionValue(create, "Builder(this)\n        .apply(dialogConfig)\n        .create()");
        create.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t(final File file) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        View inflate = getLayoutInflater().inflate(R.layout.dialog_password_prompt, (ViewGroup) null);
        final EditText passwordEntry = (EditText) inflate.findViewById(R.id.passwordEntry);
        final Button button = (Button) inflate.findViewById(R.id.okButton);
        Button button2 = (Button) inflate.findViewById(R.id.cancelButton);
        builder.setTitle(R.string.enter_password);
        builder.setView(inflate);
        final androidx.appcompat.app.AlertDialog create = builder.create();
        Intrinsics.checkNotNullExpressionValue(create, "alert.create()");
        Window window = create.getWindow();
        if (window != null) {
            window.clearFlags(131080);
        }
        Window window2 = create.getWindow();
        if (window2 != null) {
            window2.setSoftInputMode(5);
        }
        create.show();
        passwordEntry.setText(Settings.getAutoBackupEncryptionPassword(requireContext()));
        Intrinsics.checkNotNullExpressionValue(passwordEntry, "passwordEntry");
        passwordEntry.addTextChangedListener(new TextWatcher() { // from class: com.arlosoft.macrodroid.autobackup.ui.cloud.AutoBackupCloudFragment$showPasswordDialog$$inlined$addTextChangedListener$default$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(@Nullable Editable editable) {
                boolean z3;
                Button button3 = button;
                if (passwordEntry.getText().length() >= 4) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                button3.setEnabled(z3);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(@Nullable CharSequence charSequence, int i4, int i5, int i6) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(@Nullable CharSequence charSequence, int i4, int i5, int i6) {
            }
        });
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.autobackup.ui.cloud.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AutoBackupCloudFragment.u(AutoBackupCloudFragment.this, file, passwordEntry, create, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.autobackup.ui.cloud.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AutoBackupCloudFragment.v(create, view);
            }
        });
        create.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.arlosoft.macrodroid.autobackup.ui.cloud.d
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                AutoBackupCloudFragment.w(AutoBackupCloudFragment.this, dialogInterface);
            }
        });
        passwordEntry.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(AutoBackupCloudFragment this$0, File file, EditText editText, Dialog dialog, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(file, "$file");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        this$0.getViewModel().decryptAndRestore(file, editText.getText().toString());
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(Dialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(AutoBackupCloudFragment this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Dialog dialog = this$0.f9328h;
        if (dialog != null) {
            dialog.hide();
        }
        this$0.f9328h = null;
    }

    private final void x(String str) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        View inflate = getLayoutInflater().inflate(R.layout.dialog_auto_backup_progress, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.text)).setText(str);
        builder.setView(inflate);
        this.f9328h = builder.show();
    }

    private final void y() {
        String string = getString(R.string.importing_macros);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.importing_macros)");
        x(string);
    }

    private final void z() {
        Dialog dialog = this.f9328h;
        if (dialog != null) {
            dialog.hide();
        }
        this.f9328h = null;
        FragmentCloudBackupBinding fragmentCloudBackupBinding = this.f9322b;
        if (fragmentCloudBackupBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentCloudBackupBinding = null;
        }
        FrameLayout frameLayout = fragmentCloudBackupBinding.loadingView;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.loadingView");
        frameLayout.setVisibility(8);
        this.f9326f = false;
        kotlinx.coroutines.e.e(this.f9330j, Dispatchers.getMain(), null, new m(null), 2, null);
        FragmentCloudBackupBinding fragmentCloudBackupBinding2 = this.f9322b;
        if (fragmentCloudBackupBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentCloudBackupBinding2 = null;
        }
        fragmentCloudBackupBinding2.viewFlipper.setDisplayedChild(1);
        FragmentCloudBackupBinding fragmentCloudBackupBinding3 = this.f9322b;
        if (fragmentCloudBackupBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentCloudBackupBinding3 = null;
        }
        fragmentCloudBackupBinding3.upgradeSignInText.setText(getString(R.string.cloud_backup_please_sign_in));
        FragmentCloudBackupBinding fragmentCloudBackupBinding4 = this.f9322b;
        if (fragmentCloudBackupBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentCloudBackupBinding4 = null;
        }
        fragmentCloudBackupBinding4.upgradeSignInButton.setText(getString(R.string.sign_in));
        FragmentCloudBackupBinding fragmentCloudBackupBinding5 = this.f9322b;
        if (fragmentCloudBackupBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentCloudBackupBinding5 = null;
        }
        Button button = fragmentCloudBackupBinding5.upgradeSignInButton;
        Intrinsics.checkNotNullExpressionValue(button, "binding.upgradeSignInButton");
        ViewExtensionsKt.onClick$default(button, null, new n(null), 1, null);
    }

    public final boolean getFirstTime() {
        return this.f9331k;
    }

    @NotNull
    public final CompletableJob getJob() {
        return this.f9329i;
    }

    @NotNull
    public final SignInHelper getSignInHelper() {
        SignInHelper signInHelper = this.signInHelper;
        if (signInHelper != null) {
            return signInHelper;
        }
        Intrinsics.throwUninitializedPropertyAccessException("signInHelper");
        return null;
    }

    @NotNull
    public final CoroutineScope getUiScope() {
        return this.f9330j;
    }

    @NotNull
    public final AutoBackupCloudViewModel getViewModel() {
        AutoBackupCloudViewModel autoBackupCloudViewModel = this.viewModel;
        if (autoBackupCloudViewModel != null) {
            return autoBackupCloudViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i4, int i5, @Nullable Intent intent) {
        Integer num;
        super.onActivityResult(i4, i5, intent);
        IdpResponse fromResultIntent = IdpResponse.fromResultIntent(intent);
        if (i4 == 9729) {
            Integer num2 = null;
            CompositeDisposable compositeDisposable = null;
            if (i5 == -1) {
                SignInHelper signInHelper = getSignInHelper();
                CompositeDisposable compositeDisposable2 = this.f9323c;
                if (compositeDisposable2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("compositeDisposable");
                } else {
                    compositeDisposable = compositeDisposable2;
                }
                signInHelper.handleSignInResult(fromResultIntent, compositeDisposable, new SignInHelper.SignInCallbackHandler() { // from class: com.arlosoft.macrodroid.autobackup.ui.cloud.AutoBackupCloudFragment$onActivityResult$1
                    @Override // com.arlosoft.macrodroid.user.signin.SignInHelper.SignInCallbackHandler
                    public void onSignInError() {
                        FragmentCloudBackupBinding fragmentCloudBackupBinding;
                        fragmentCloudBackupBinding = AutoBackupCloudFragment.this.f9322b;
                        if (fragmentCloudBackupBinding == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                            fragmentCloudBackupBinding = null;
                        }
                        FrameLayout frameLayout = fragmentCloudBackupBinding.loadingView;
                        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.loadingView");
                        frameLayout.setVisibility(8);
                        ToastCompat.makeText(AutoBackupCloudFragment.this.requireContext(), (int) R.string.could_not_sign_in, 1).show();
                    }

                    @Override // com.arlosoft.macrodroid.user.signin.SignInHelper.SignInCallbackHandler
                    public void onSignInStarted() {
                        List emptyList;
                        AutoBackupCloudFragment autoBackupCloudFragment = AutoBackupCloudFragment.this;
                        emptyList = CollectionsKt__CollectionsKt.emptyList();
                        autoBackupCloudFragment.p(true, false, emptyList, null);
                    }

                    @Override // com.arlosoft.macrodroid.user.signin.SignInHelper.SignInCallbackHandler
                    public void onSignedIn(@NotNull User user) {
                        Intrinsics.checkNotNullParameter(user, "user");
                        AutoBackupCloudFragment.this.getViewModel().refresh();
                    }

                    @Override // com.arlosoft.macrodroid.user.signin.SignInHelper.SignInCallbackHandler
                    public void onSignedInNoUser() {
                        AutoBackupCloudFragment.this.getViewModel().onSignedInNoUser();
                    }
                }, false);
            } else if (fromResultIntent != null) {
                FirebaseUiException error = fromResultIntent.getError();
                if (error != null) {
                    num = Integer.valueOf(error.getErrorCode());
                } else {
                    num = null;
                }
                SystemLog.logError("Sign in error: " + num);
                FirebaseCrashlytics firebaseCrashlytics = FirebaseCrashlytics.getInstance();
                FirebaseUiException error2 = fromResultIntent.getError();
                if (error2 != null) {
                    num2 = Integer.valueOf(error2.getErrorCode());
                }
                firebaseCrashlytics.recordException(new Exception("Template store Sign in error: " + num2));
                s();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.f9323c = new CompositeDisposable();
        setHasOptionsMenu(true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(@NotNull Menu menu, @NotNull MenuInflater inflater) {
        SwitchCompat switchCompat;
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        if (!this.f9331k && this.f9326f) {
            inflater.inflate(R.menu.autobackup_cloud_menu, menu);
            View actionView = menu.findItem(R.id.switch_enabled).getActionView();
            Intrinsics.checkNotNull(actionView, "null cannot be cast to non-null type androidx.appcompat.widget.SwitchCompat");
            this.f9325e = (SwitchCompat) actionView;
            menu.findItem(R.id.sign_out).setVisible(this.f9326f);
            menu.findItem(R.id.delete_all).setVisible(this.f9326f);
            menu.findItem(R.id.switch_enabled).setVisible(this.f9326f);
            SwitchCompat switchCompat2 = this.f9325e;
            if (switchCompat2 != null) {
                switchCompat2.setChecked(this.f9327g);
            }
            if (this.f9326f && (switchCompat = this.f9325e) != null) {
                switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.autobackup.ui.cloud.e
                    @Override // android.widget.CompoundButton.OnCheckedChangeListener
                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
                        AutoBackupCloudFragment.l(AutoBackupCloudFragment.this, compoundButton, z3);
                    }
                });
            }
        } else {
            this.f9331k = false;
        }
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentCloudBackupBinding inflate = FragmentCloudBackupBinding.inflate(inflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, container, false)");
        this.f9322b = inflate;
        getLifecycle().addObserver(getViewModel());
        h();
        FragmentCloudBackupBinding fragmentCloudBackupBinding = this.f9322b;
        if (fragmentCloudBackupBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentCloudBackupBinding = null;
        }
        return fragmentCloudBackupBinding.getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        CompositeDisposable compositeDisposable = null;
        Job.DefaultImpls.cancel$default((Job) this.f9329i, (CancellationException) null, 1, (Object) null);
        CompositeDisposable compositeDisposable2 = this.f9323c;
        if (compositeDisposable2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("compositeDisposable");
        } else {
            compositeDisposable = compositeDisposable2;
        }
        compositeDisposable.clear();
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(@NotNull MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        int itemId = item.getItemId();
        if (itemId != R.id.backup_now) {
            if (itemId != R.id.delete_all) {
                if (itemId == R.id.sign_out) {
                    getViewModel().signOut();
                }
            } else {
                i();
            }
        } else {
            getViewModel().backupNow();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        k();
    }

    public final void setFirstTime(boolean z3) {
        this.f9331k = z3;
    }

    public final void setSignInHelper(@NotNull SignInHelper signInHelper) {
        Intrinsics.checkNotNullParameter(signInHelper, "<set-?>");
        this.signInHelper = signInHelper;
    }

    public final void setViewModel(@NotNull AutoBackupCloudViewModel autoBackupCloudViewModel) {
        Intrinsics.checkNotNullParameter(autoBackupCloudViewModel, "<set-?>");
        this.viewModel = autoBackupCloudViewModel;
    }
}
