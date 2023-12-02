package com.arlosoft.macrodroid.plugins.pluginlist;

import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatButton;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseFragment;
import com.arlosoft.macrodroid.data.OrderByOption;
import com.arlosoft.macrodroid.databinding.FragmentPluginListBinding;
import com.arlosoft.macrodroid.extensions.ViewExtensionsKt;
import com.arlosoft.macrodroid.plugins.PluginsViewModel;
import com.arlosoft.macrodroid.plugins.comments.PluginCommentsActivity;
import com.arlosoft.macrodroid.plugins.data.LocalPluginListOverrideStore;
import com.arlosoft.macrodroid.plugins.data.PluginDetail;
import com.arlosoft.macrodroid.plugins.pluginlist.PluginListViewModel;
import com.arlosoft.macrodroid.templatestore.common.LoadState;
import com.arlosoft.macrodroid.templatestore.ui.comments.TemplateCommentsActivity;
import com.arlosoft.macrodroid.templatestore.ui.profile.ProfileImageProvider;
import com.arlosoft.macrodroid.user.signin.SignInHelper;
import com.arlosoft.macrodroid.utils.SingleLiveEvent;
import com.google.android.material.snackbar.SnackbarAnimate;
import java.util.Locale;
import java.util.Observable;
import java.util.Observer;
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
import kotlin.text.m;
import kotlinx.coroutines.CoroutineScope;
import me.drakeet.support.toast.ToastCompat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PluginListFragment.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nPluginListFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PluginListFragment.kt\ncom/arlosoft/macrodroid/plugins/pluginlist/PluginListFragment\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,241:1\n262#2,2:242\n262#2,2:244\n262#2,2:246\n262#2,2:248\n262#2,2:250\n262#2,2:252\n262#2,2:254\n262#2,2:256\n262#2,2:258\n262#2,2:260\n*S KotlinDebug\n*F\n+ 1 PluginListFragment.kt\ncom/arlosoft/macrodroid/plugins/pluginlist/PluginListFragment\n*L\n98#1:242,2\n162#1:244,2\n163#1:246,2\n164#1:248,2\n166#1:250,2\n167#1:252,2\n168#1:254,2\n170#1:256,2\n171#1:258,2\n172#1:260,2\n*E\n"})
/* loaded from: classes3.dex */
public final class PluginListFragment extends MacroDroidDaggerBaseFragment implements Observer {

    /* renamed from: b  reason: collision with root package name */
    private PluginListAdapter f13203b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private androidx.lifecycle.Observer<LoadState> f13204c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private LiveData<LoadState> f13205d;

    /* renamed from: e  reason: collision with root package name */
    private FragmentPluginListBinding f13206e;
    @Inject
    public LocalPluginListOverrideStore pluginListOverrideStore;
    @Inject
    public PluginsViewModel pluginsViewModel;
    @Inject
    public ProfileImageProvider profileImageProvider;
    @Inject
    public SignInHelper signInHelper;
    @Inject
    public PluginListViewModel viewModel;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: PluginListFragment.kt */
    @SourceDebugExtension({"SMAP\nPluginListFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PluginListFragment.kt\ncom/arlosoft/macrodroid/plugins/pluginlist/PluginListFragment$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,241:1\n1#2:242\n*E\n"})
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final PluginListFragment createInstance(@OrderByOption int i4) {
            PluginListFragment pluginListFragment = new PluginListFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("order_by_type", Integer.valueOf(i4));
            pluginListFragment.setArguments(bundle);
            return pluginListFragment;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PluginListFragment.kt */
    /* loaded from: classes3.dex */
    public static final class a implements androidx.lifecycle.Observer<LoadState> {
        a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public final void onChanged(@NotNull LoadState it) {
            Intrinsics.checkNotNullParameter(it, "it");
            PluginListFragment.this.n(it);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PluginListFragment.kt */
    /* loaded from: classes3.dex */
    public static final class b implements androidx.lifecycle.Observer<PagedList<PluginDetail>> {
        b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public final void onChanged(PagedList<PluginDetail> it) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            if (!it.isEmpty()) {
                PluginListAdapter pluginListAdapter = PluginListFragment.this.f13203b;
                if (pluginListAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    pluginListAdapter = null;
                }
                pluginListAdapter.submitList(it);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PluginListFragment.kt */
    @SourceDebugExtension({"SMAP\nPluginListFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PluginListFragment.kt\ncom/arlosoft/macrodroid/plugins/pluginlist/PluginListFragment$configureViewModelObservers$3\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,241:1\n1#2:242\n*E\n"})
    /* loaded from: classes3.dex */
    public static final class c implements androidx.lifecycle.Observer<PluginDetail> {
        c() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public final void onChanged(@Nullable PluginDetail pluginDetail) {
            if (pluginDetail != null) {
                PluginListFragment.this.m(pluginDetail);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PluginListFragment.kt */
    /* loaded from: classes3.dex */
    public static final class d implements androidx.lifecycle.Observer<PluginListViewModel.UiEvent> {
        d() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public final void onChanged(@Nullable PluginListViewModel.UiEvent uiEvent) {
            PluginListAdapter pluginListAdapter = null;
            if (uiEvent instanceof PluginListViewModel.UiEvent.StarRequiresSignIn) {
                PluginListFragment.this.showRequiresSignIn();
                PluginListAdapter pluginListAdapter2 = PluginListFragment.this.f13203b;
                if (pluginListAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                } else {
                    pluginListAdapter = pluginListAdapter2;
                }
                pluginListAdapter.notifyDataSetChanged();
            } else if (uiEvent instanceof PluginListViewModel.UiEvent.RefreshList) {
                PluginListAdapter pluginListAdapter3 = PluginListFragment.this.f13203b;
                if (pluginListAdapter3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                } else {
                    pluginListAdapter = pluginListAdapter3;
                }
                pluginListAdapter.notifyDataSetChanged();
            } else if (uiEvent instanceof PluginListViewModel.UiEvent.ShowOptionsDialog) {
                PluginListFragment.this.o(((PluginListViewModel.UiEvent.ShowOptionsDialog) uiEvent).getPluginDetail());
            } else if (uiEvent instanceof PluginListViewModel.UiEvent.ReportSubmitted) {
                ToastCompat.makeText(PluginListFragment.this.requireActivity().getApplicationContext(), (int) R.string.report_submitted, 1).show();
            } else if (uiEvent instanceof PluginListViewModel.UiEvent.ReportFailed) {
                ToastCompat.makeText(PluginListFragment.this.requireActivity().getApplicationContext(), (int) R.string.error, 1).show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PluginListFragment.kt */
    @SourceDebugExtension({"SMAP\nPluginListFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PluginListFragment.kt\ncom/arlosoft/macrodroid/plugins/pluginlist/PluginListFragment$configureViewModelObservers$5\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,241:1\n262#2,2:242\n*S KotlinDebug\n*F\n+ 1 PluginListFragment.kt\ncom/arlosoft/macrodroid/plugins/pluginlist/PluginListFragment$configureViewModelObservers$5\n*L\n150#1:242,2\n*E\n"})
    /* loaded from: classes3.dex */
    public static final class e implements androidx.lifecycle.Observer<String> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: PluginListFragment.kt */
        /* loaded from: classes3.dex */
        public static final class a extends Lambda implements Function1<LoadState, Unit> {
            final /* synthetic */ PluginListFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(PluginListFragment pluginListFragment) {
                super(1);
                this.this$0 = pluginListFragment;
            }

            public final void a(LoadState loadState) {
                androidx.lifecycle.Observer unused = this.this$0.f13204c;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(LoadState loadState) {
                a(loadState);
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: PluginListFragment.kt */
        /* loaded from: classes3.dex */
        public static final class b implements androidx.lifecycle.Observer<PagedList<PluginDetail>> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ PluginListFragment f13212a;

            b(PluginListFragment pluginListFragment) {
                this.f13212a = pluginListFragment;
            }

            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public final void onChanged(PagedList<PluginDetail> list) {
                Intrinsics.checkNotNullExpressionValue(list, "list");
                if (!list.isEmpty()) {
                    PluginListAdapter pluginListAdapter = this.f13212a.f13203b;
                    if (pluginListAdapter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adapter");
                        pluginListAdapter = null;
                    }
                    pluginListAdapter.submitList(list);
                }
            }
        }

        e() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public final void onChanged(String it) {
            PluginListViewModel viewModel = PluginListFragment.this.getViewModel();
            Intrinsics.checkNotNullExpressionValue(it, "it");
            LiveData<PagedList<PluginDetail>> searchText = viewModel.setSearchText(it);
            LiveData liveData = PluginListFragment.this.f13205d;
            if (liveData != null) {
                liveData.removeObserver(new g(new a(PluginListFragment.this)));
            }
            PluginListFragment pluginListFragment = PluginListFragment.this;
            pluginListFragment.f13205d = pluginListFragment.getViewModel().getLoadState();
            LiveData<LoadState> loadState = PluginListFragment.this.getViewModel().getLoadState();
            LifecycleOwner viewLifecycleOwner = PluginListFragment.this.getViewLifecycleOwner();
            androidx.lifecycle.Observer<? super LoadState> observer = PluginListFragment.this.f13204c;
            Intrinsics.checkNotNull(observer);
            loadState.observe(viewLifecycleOwner, observer);
            PluginListFragment.this.f13203b = new PluginListAdapter(PluginListFragment.this.getViewModel(), PluginListFragment.this.getProfileImageProvider(), PluginListFragment.this.getPluginListOverrideStore());
            FragmentPluginListBinding fragmentPluginListBinding = PluginListFragment.this.f13206e;
            FragmentPluginListBinding fragmentPluginListBinding2 = null;
            if (fragmentPluginListBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentPluginListBinding = null;
            }
            RecyclerView recyclerView = fragmentPluginListBinding.pluginList;
            PluginListAdapter pluginListAdapter = PluginListFragment.this.f13203b;
            if (pluginListAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                pluginListAdapter = null;
            }
            recyclerView.setAdapter(pluginListAdapter);
            FragmentPluginListBinding fragmentPluginListBinding3 = PluginListFragment.this.f13206e;
            if (fragmentPluginListBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentPluginListBinding2 = fragmentPluginListBinding3;
            }
            LottieAnimationView lottieAnimationView = fragmentPluginListBinding2.loadingView;
            Intrinsics.checkNotNullExpressionValue(lottieAnimationView, "binding.loadingView");
            lottieAnimationView.setVisibility(0);
            searchText.observe(PluginListFragment.this.getViewLifecycleOwner(), new b(PluginListFragment.this));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PluginListFragment.kt */
    @SourceDebugExtension({"SMAP\nPluginListFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PluginListFragment.kt\ncom/arlosoft/macrodroid/plugins/pluginlist/PluginListFragment$initialiseViews$1\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,241:1\n262#2,2:242\n262#2,2:244\n*S KotlinDebug\n*F\n+ 1 PluginListFragment.kt\ncom/arlosoft/macrodroid/plugins/pluginlist/PluginListFragment$initialiseViews$1\n*L\n104#1:242,2\n105#1:244,2\n*E\n"})
    /* loaded from: classes3.dex */
    public static final class f extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        int label;

        f(Continuation<? super f> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new f(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                FragmentPluginListBinding fragmentPluginListBinding = PluginListFragment.this.f13206e;
                FragmentPluginListBinding fragmentPluginListBinding2 = null;
                if (fragmentPluginListBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    fragmentPluginListBinding = null;
                }
                LottieAnimationView lottieAnimationView = fragmentPluginListBinding.loadingView;
                Intrinsics.checkNotNullExpressionValue(lottieAnimationView, "binding.loadingView");
                int i4 = 0;
                lottieAnimationView.setVisibility(0);
                FragmentPluginListBinding fragmentPluginListBinding3 = PluginListFragment.this.f13206e;
                if (fragmentPluginListBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    fragmentPluginListBinding2 = fragmentPluginListBinding3;
                }
                LinearLayout linearLayout = fragmentPluginListBinding2.errorView;
                Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.errorView");
                linearLayout.setVisibility(8);
                PluginListViewModel viewModel = PluginListFragment.this.getViewModel();
                Bundle arguments = PluginListFragment.this.getArguments();
                if (arguments != null) {
                    i4 = arguments.getInt("order_by_type");
                }
                viewModel.initialiseWithOrder(i4);
                PluginListFragment.this.f();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PluginListFragment.kt */
    /* loaded from: classes3.dex */
    public static final class g implements androidx.lifecycle.Observer, FunctionAdapter {

        /* renamed from: a  reason: collision with root package name */
        private final /* synthetic */ Function1 f13213a;

        g(Function1 function) {
            Intrinsics.checkNotNullParameter(function, "function");
            this.f13213a = function;
        }

        public final boolean equals(@Nullable Object obj) {
            if (!(obj instanceof androidx.lifecycle.Observer) || !(obj instanceof FunctionAdapter)) {
                return false;
            }
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f13213a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f13213a.invoke(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f() {
        this.f13204c = new a();
        LiveData<LoadState> loadState = getViewModel().getLoadState();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        androidx.lifecycle.Observer<LoadState> observer = this.f13204c;
        Intrinsics.checkNotNull(observer);
        loadState.observe(viewLifecycleOwner, observer);
        getViewModel().getPagedList().observe(getViewLifecycleOwner(), new b());
        SingleLiveEvent<PluginDetail> loadCommentsEvent = getViewModel().getLoadCommentsEvent();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "viewLifecycleOwner");
        loadCommentsEvent.observe(viewLifecycleOwner2, new c());
        SingleLiveEvent<PluginListViewModel.UiEvent> uiEvent = getViewModel().getUiEvent();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "viewLifecycleOwner");
        uiEvent.observe(viewLifecycleOwner3, new d());
        getPluginsViewModel().getSearchText().observe(getViewLifecycleOwner(), new e());
    }

    private final void g(final PluginDetail pluginDetail) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        builder.setTitle(pluginDetail.getName());
        builder.setMessage(R.string.plugin_report_broken_download_confirm);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.plugins.pluginlist.d
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                PluginListFragment.h(PluginListFragment.this, pluginDetail, dialogInterface, i4);
            }
        });
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(PluginListFragment this$0, PluginDetail pluginDetail, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(pluginDetail, "$pluginDetail");
        Intrinsics.checkNotNullParameter(dialogInterface, "<anonymous parameter 0>");
        this$0.getViewModel().reportBrokenDownload(pluginDetail);
    }

    private final void i(final PluginDetail pluginDetail) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        builder.setTitle(pluginDetail.getName());
        builder.setMessage(R.string.plugin_report_non_valid_plugin_confirm);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.plugins.pluginlist.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                PluginListFragment.j(PluginListFragment.this, pluginDetail, dialogInterface, i4);
            }
        });
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(PluginListFragment this$0, PluginDetail pluginDetail, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(pluginDetail, "$pluginDetail");
        Intrinsics.checkNotNullParameter(dialogInterface, "<anonymous parameter 0>");
        this$0.getViewModel().reportInvalidPlugin(pluginDetail);
    }

    private final void k(String str) {
        Object obj;
        FragmentActivity activity = getActivity();
        Context context = null;
        if (activity != null) {
            obj = activity.getSystemService("clipboard");
        } else {
            obj = null;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.content.ClipboardManager");
        ((ClipboardManager) obj).setText(str);
        FragmentActivity activity2 = getActivity();
        if (activity2 != null) {
            context = activity2.getApplicationContext();
        }
        ToastCompat.makeText(context, (int) R.string.link_copied_to_clipboard, 0).show();
    }

    private final void l() {
        this.f13203b = new PluginListAdapter(getViewModel(), getProfileImageProvider(), getPluginListOverrideStore());
        FragmentPluginListBinding fragmentPluginListBinding = this.f13206e;
        if (fragmentPluginListBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentPluginListBinding = null;
        }
        RecyclerView recyclerView = fragmentPluginListBinding.pluginList;
        PluginListAdapter pluginListAdapter = this.f13203b;
        if (pluginListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            pluginListAdapter = null;
        }
        recyclerView.setAdapter(pluginListAdapter);
        FragmentPluginListBinding fragmentPluginListBinding2 = this.f13206e;
        if (fragmentPluginListBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentPluginListBinding2 = null;
        }
        LottieAnimationView lottieAnimationView = fragmentPluginListBinding2.loadingView;
        Intrinsics.checkNotNullExpressionValue(lottieAnimationView, "binding.loadingView");
        lottieAnimationView.setVisibility(0);
        FragmentPluginListBinding fragmentPluginListBinding3 = this.f13206e;
        if (fragmentPluginListBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentPluginListBinding3 = null;
        }
        AppCompatButton appCompatButton = fragmentPluginListBinding3.retryButton;
        Intrinsics.checkNotNullExpressionValue(appCompatButton, "binding.retryButton");
        ViewExtensionsKt.onClick$default(appCompatButton, null, new f(null), 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(PluginDetail pluginDetail) {
        PluginCommentsActivity.Companion companion = PluginCommentsActivity.Companion;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        startActivityForResult(companion.createIntent(requireContext, pluginDetail), 101);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.overridePendingTransition(R.anim.up_from_bottom, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(LoadState loadState) {
        FragmentPluginListBinding fragmentPluginListBinding = null;
        if (loadState == LoadState.LOADING) {
            FragmentPluginListBinding fragmentPluginListBinding2 = this.f13206e;
            if (fragmentPluginListBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentPluginListBinding2 = null;
            }
            LottieAnimationView lottieAnimationView = fragmentPluginListBinding2.loadingView;
            Intrinsics.checkNotNullExpressionValue(lottieAnimationView, "binding.loadingView");
            lottieAnimationView.setVisibility(0);
            FragmentPluginListBinding fragmentPluginListBinding3 = this.f13206e;
            if (fragmentPluginListBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentPluginListBinding3 = null;
            }
            LinearLayout linearLayout = fragmentPluginListBinding3.errorView;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.errorView");
            linearLayout.setVisibility(8);
            FragmentPluginListBinding fragmentPluginListBinding4 = this.f13206e;
            if (fragmentPluginListBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentPluginListBinding = fragmentPluginListBinding4;
            }
            RecyclerView recyclerView = fragmentPluginListBinding.pluginList;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.pluginList");
            recyclerView.setVisibility(8);
        } else if (loadState == LoadState.ERROR) {
            FragmentPluginListBinding fragmentPluginListBinding5 = this.f13206e;
            if (fragmentPluginListBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentPluginListBinding5 = null;
            }
            LottieAnimationView lottieAnimationView2 = fragmentPluginListBinding5.loadingView;
            Intrinsics.checkNotNullExpressionValue(lottieAnimationView2, "binding.loadingView");
            lottieAnimationView2.setVisibility(8);
            FragmentPluginListBinding fragmentPluginListBinding6 = this.f13206e;
            if (fragmentPluginListBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentPluginListBinding6 = null;
            }
            LinearLayout linearLayout2 = fragmentPluginListBinding6.errorView;
            Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.errorView");
            linearLayout2.setVisibility(0);
            FragmentPluginListBinding fragmentPluginListBinding7 = this.f13206e;
            if (fragmentPluginListBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentPluginListBinding = fragmentPluginListBinding7;
            }
            RecyclerView recyclerView2 = fragmentPluginListBinding.pluginList;
            Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.pluginList");
            recyclerView2.setVisibility(8);
        } else {
            FragmentPluginListBinding fragmentPluginListBinding8 = this.f13206e;
            if (fragmentPluginListBinding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentPluginListBinding8 = null;
            }
            LottieAnimationView lottieAnimationView3 = fragmentPluginListBinding8.loadingView;
            Intrinsics.checkNotNullExpressionValue(lottieAnimationView3, "binding.loadingView");
            lottieAnimationView3.setVisibility(8);
            FragmentPluginListBinding fragmentPluginListBinding9 = this.f13206e;
            if (fragmentPluginListBinding9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentPluginListBinding9 = null;
            }
            LinearLayout linearLayout3 = fragmentPluginListBinding9.errorView;
            Intrinsics.checkNotNullExpressionValue(linearLayout3, "binding.errorView");
            linearLayout3.setVisibility(8);
            FragmentPluginListBinding fragmentPluginListBinding10 = this.f13206e;
            if (fragmentPluginListBinding10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentPluginListBinding = fragmentPluginListBinding10;
            }
            RecyclerView recyclerView3 = fragmentPluginListBinding.pluginList;
            Intrinsics.checkNotNullExpressionValue(recyclerView3, "binding.pluginList");
            recyclerView3.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(final PluginDetail pluginDetail) {
        String string = getString(R.string.edit_macro);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.edit_macro)");
        String lowerCase = string.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        m.capitalize(lowerCase);
        final String[] strArr = {getString(R.string.copy_web_link), getString(R.string.plugin_report_broken_download), getString(R.string.plugin_report_non_valid_plugin)};
        new AlertDialog.Builder(requireActivity(), R.style.Theme_App_Dialog_Template).setTitle(pluginDetail.getName()).setItems(strArr, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.plugins.pluginlist.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                PluginListFragment.p(strArr, this, pluginDetail, dialogInterface, i4);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(String[] options, PluginListFragment this$0, PluginDetail pluginDetail, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(options, "$options");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(pluginDetail, "$pluginDetail");
        String str = options[i4];
        Intrinsics.checkNotNullExpressionValue(str, "options[index]");
        if (Intrinsics.areEqual(str, this$0.getString(R.string.copy_web_link))) {
            this$0.k(pluginDetail.getDownloadLink());
        } else if (Intrinsics.areEqual(str, this$0.getString(R.string.plugin_report_broken_download))) {
            this$0.g(pluginDetail);
        } else if (Intrinsics.areEqual(str, this$0.getString(R.string.plugin_report_non_valid_plugin))) {
            this$0.i(pluginDetail);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(PluginListFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SignInHelper signInHelper = this$0.getSignInHelper();
        FragmentActivity requireActivity = this$0.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        signInHelper.signIn(requireActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showRequiresSignIn() {
        SnackbarAnimate make = SnackbarAnimate.make(requireView(), (int) R.string.please_sign_in_to_submit_and_rate_new_plugins, 5000);
        Intrinsics.checkNotNullExpressionValue(make, "make(requireView(), R.st…d_rate_new_plugins, 5000)");
        make.getView().setBackgroundResource(R.color.md_light_blue_600);
        View findViewById = make.getView().findViewById(R.id.snackbar_text);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) findViewById).setTextColor(-1);
        View findViewById2 = make.getView().findViewById(R.id.snackbar_action);
        Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) findViewById2).setTextColor(-1);
        make.setAction(R.string.sign_in, new View.OnClickListener() { // from class: com.arlosoft.macrodroid.plugins.pluginlist.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PluginListFragment.q(PluginListFragment.this, view);
            }
        });
        make.show();
    }

    @NotNull
    public final LocalPluginListOverrideStore getPluginListOverrideStore() {
        LocalPluginListOverrideStore localPluginListOverrideStore = this.pluginListOverrideStore;
        if (localPluginListOverrideStore != null) {
            return localPluginListOverrideStore;
        }
        Intrinsics.throwUninitializedPropertyAccessException("pluginListOverrideStore");
        return null;
    }

    @NotNull
    public final PluginsViewModel getPluginsViewModel() {
        PluginsViewModel pluginsViewModel = this.pluginsViewModel;
        if (pluginsViewModel != null) {
            return pluginsViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("pluginsViewModel");
        return null;
    }

    @NotNull
    public final ProfileImageProvider getProfileImageProvider() {
        ProfileImageProvider profileImageProvider = this.profileImageProvider;
        if (profileImageProvider != null) {
            return profileImageProvider;
        }
        Intrinsics.throwUninitializedPropertyAccessException("profileImageProvider");
        return null;
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
    public final PluginListViewModel getViewModel() {
        PluginListViewModel pluginListViewModel = this.viewModel;
        if (pluginListViewModel != null) {
            return pluginListViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i4, int i5, @Nullable Intent intent) {
        super.onActivityResult(i4, i5, intent);
        if (i4 == 101 && i5 == -1) {
            boolean z3 = false;
            if (intent != null && intent.getBooleanExtra(TemplateCommentsActivity.EXTRA_SIGN_IN, false)) {
                z3 = true;
            }
            if (z3) {
                SignInHelper signInHelper = getSignInHelper();
                FragmentActivity requireActivity = requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
                signInHelper.signIn(requireActivity);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        int i4 = 0;
        FragmentPluginListBinding inflate = FragmentPluginListBinding.inflate(inflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, container, false)");
        this.f13206e = inflate;
        PluginListViewModel viewModel = getViewModel();
        Bundle arguments = getArguments();
        if (arguments != null) {
            i4 = arguments.getInt("order_by_type");
        }
        viewModel.initialiseWithOrder(i4);
        l();
        f();
        FragmentPluginListBinding fragmentPluginListBinding = this.f13206e;
        if (fragmentPluginListBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentPluginListBinding = null;
        }
        return fragmentPluginListBinding.getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        PluginListAdapter pluginListAdapter = this.f13203b;
        if (pluginListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            pluginListAdapter = null;
        }
        pluginListAdapter.notifyDataSetChanged();
    }

    public final void setPluginListOverrideStore(@NotNull LocalPluginListOverrideStore localPluginListOverrideStore) {
        Intrinsics.checkNotNullParameter(localPluginListOverrideStore, "<set-?>");
        this.pluginListOverrideStore = localPluginListOverrideStore;
    }

    public final void setPluginsViewModel(@NotNull PluginsViewModel pluginsViewModel) {
        Intrinsics.checkNotNullParameter(pluginsViewModel, "<set-?>");
        this.pluginsViewModel = pluginsViewModel;
    }

    public final void setProfileImageProvider(@NotNull ProfileImageProvider profileImageProvider) {
        Intrinsics.checkNotNullParameter(profileImageProvider, "<set-?>");
        this.profileImageProvider = profileImageProvider;
    }

    public final void setSignInHelper(@NotNull SignInHelper signInHelper) {
        Intrinsics.checkNotNullParameter(signInHelper, "<set-?>");
        this.signInHelper = signInHelper;
    }

    public final void setViewModel(@NotNull PluginListViewModel pluginListViewModel) {
        Intrinsics.checkNotNullParameter(pluginListViewModel, "<set-?>");
        this.viewModel = pluginListViewModel;
    }

    @Override // java.util.Observer
    public void update(@Nullable Observable observable, @Nullable Object obj) {
        getViewModel().invalidatePagedList();
    }
}
