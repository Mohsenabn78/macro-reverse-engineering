package com.arlosoft.macrodroid.templatestore.ui.subscription;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseFragment;
import com.arlosoft.macrodroid.database.room.SubscriptionUpdateItem;
import com.arlosoft.macrodroid.databinding.FragmentTemplateStoreListUpdatesBinding;
import com.arlosoft.macrodroid.templatestore.ui.TemplateStoreList;
import com.arlosoft.macrodroid.templatestore.ui.profile.ProfileImageProvider;
import com.arlosoft.macrodroid.templatestore.ui.subscription.viewmodel.ErrorType;
import com.arlosoft.macrodroid.templatestore.ui.subscription.viewmodel.TemplateUpdatesViewModel;
import com.arlosoft.macrodroid.utils.SingleLiveEvent;
import java.util.List;
import javax.inject.Inject;
import kotlin.Function;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import me.drakeet.support.toast.ToastCompat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TemplateUpdatesFragment.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class TemplateUpdatesFragment extends MacroDroidDaggerBaseFragment implements TemplateStoreList {

    /* renamed from: b  reason: collision with root package name */
    private FragmentTemplateStoreListUpdatesBinding f13871b;

    /* renamed from: c  reason: collision with root package name */
    private TemplateUpdatesAdapter f13872c;
    @Inject
    public ProfileImageProvider profileImageProvider;
    @Inject
    public TemplateUpdatesViewModel viewModel;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: TemplateUpdatesFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final TemplateUpdatesFragment newInstance() {
            return new TemplateUpdatesFragment();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TemplateUpdatesFragment.kt */
    @SourceDebugExtension({"SMAP\nTemplateUpdatesFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TemplateUpdatesFragment.kt\ncom/arlosoft/macrodroid/templatestore/ui/subscription/TemplateUpdatesFragment$bindViewModel$1\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,85:1\n262#2,2:86\n262#2,2:88\n262#2,2:90\n262#2,2:92\n*S KotlinDebug\n*F\n+ 1 TemplateUpdatesFragment.kt\ncom/arlosoft/macrodroid/templatestore/ui/subscription/TemplateUpdatesFragment$bindViewModel$1\n*L\n60#1:86,2\n61#1:88,2\n63#1:90,2\n64#1:92,2\n*E\n"})
    /* loaded from: classes3.dex */
    public static final class a extends Lambda implements Function1<List<? extends SubscriptionUpdateItem>, Unit> {
        a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends SubscriptionUpdateItem> list) {
            invoke2((List<SubscriptionUpdateItem>) list);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(List<SubscriptionUpdateItem> it) {
            TemplateUpdatesAdapter templateUpdatesAdapter = null;
            FragmentTemplateStoreListUpdatesBinding fragmentTemplateStoreListUpdatesBinding = null;
            if (it.isEmpty()) {
                FragmentTemplateStoreListUpdatesBinding fragmentTemplateStoreListUpdatesBinding2 = TemplateUpdatesFragment.this.f13871b;
                if (fragmentTemplateStoreListUpdatesBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    fragmentTemplateStoreListUpdatesBinding2 = null;
                }
                LinearLayout linearLayout = fragmentTemplateStoreListUpdatesBinding2.emptyView;
                Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.emptyView");
                linearLayout.setVisibility(0);
                FragmentTemplateStoreListUpdatesBinding fragmentTemplateStoreListUpdatesBinding3 = TemplateUpdatesFragment.this.f13871b;
                if (fragmentTemplateStoreListUpdatesBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    fragmentTemplateStoreListUpdatesBinding = fragmentTemplateStoreListUpdatesBinding3;
                }
                RecyclerView recyclerView = fragmentTemplateStoreListUpdatesBinding.updatesList;
                Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.updatesList");
                recyclerView.setVisibility(8);
                return;
            }
            FragmentTemplateStoreListUpdatesBinding fragmentTemplateStoreListUpdatesBinding4 = TemplateUpdatesFragment.this.f13871b;
            if (fragmentTemplateStoreListUpdatesBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentTemplateStoreListUpdatesBinding4 = null;
            }
            RecyclerView recyclerView2 = fragmentTemplateStoreListUpdatesBinding4.updatesList;
            Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.updatesList");
            recyclerView2.setVisibility(0);
            FragmentTemplateStoreListUpdatesBinding fragmentTemplateStoreListUpdatesBinding5 = TemplateUpdatesFragment.this.f13871b;
            if (fragmentTemplateStoreListUpdatesBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentTemplateStoreListUpdatesBinding5 = null;
            }
            LinearLayout linearLayout2 = fragmentTemplateStoreListUpdatesBinding5.emptyView;
            Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.emptyView");
            linearLayout2.setVisibility(8);
            TemplateUpdatesAdapter templateUpdatesAdapter2 = TemplateUpdatesFragment.this.f13872c;
            if (templateUpdatesAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
            } else {
                templateUpdatesAdapter = templateUpdatesAdapter2;
            }
            Intrinsics.checkNotNullExpressionValue(it, "it");
            templateUpdatesAdapter.updateItems(it);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TemplateUpdatesFragment.kt */
    @SourceDebugExtension({"SMAP\nTemplateUpdatesFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TemplateUpdatesFragment.kt\ncom/arlosoft/macrodroid/templatestore/ui/subscription/TemplateUpdatesFragment$bindViewModel$2\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,85:1\n262#2,2:86\n*S KotlinDebug\n*F\n+ 1 TemplateUpdatesFragment.kt\ncom/arlosoft/macrodroid/templatestore/ui/subscription/TemplateUpdatesFragment$bindViewModel$2\n*L\n69#1:86,2\n*E\n"})
    /* loaded from: classes3.dex */
    public static final class b extends Lambda implements Function1<Boolean, Unit> {
        b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke2(bool);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(Boolean it) {
            FragmentTemplateStoreListUpdatesBinding fragmentTemplateStoreListUpdatesBinding = TemplateUpdatesFragment.this.f13871b;
            if (fragmentTemplateStoreListUpdatesBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentTemplateStoreListUpdatesBinding = null;
            }
            LottieAnimationView lottieAnimationView = fragmentTemplateStoreListUpdatesBinding.loadingView;
            Intrinsics.checkNotNullExpressionValue(lottieAnimationView, "binding.loadingView");
            Intrinsics.checkNotNullExpressionValue(it, "it");
            lottieAnimationView.setVisibility(it.booleanValue() ? 0 : 8);
        }
    }

    /* compiled from: TemplateUpdatesFragment.kt */
    /* loaded from: classes3.dex */
    static final class c extends Lambda implements Function1<Integer, Unit> {
        c() {
            super(1);
        }

        public final void invoke(int i4) {
            TemplateUpdatesFragment.this.getViewModel().deleteItemAtPosition(i4);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke(num.intValue());
            return Unit.INSTANCE;
        }
    }

    /* compiled from: TemplateUpdatesFragment.kt */
    /* loaded from: classes3.dex */
    static final class d extends Lambda implements Function1<SubscriptionUpdateItem, Unit> {
        d() {
            super(1);
        }

        public final void a(@NotNull SubscriptionUpdateItem updateItem) {
            Intrinsics.checkNotNullParameter(updateItem, "updateItem");
            TemplateUpdatesFragment.this.getViewModel().onUpdateItemClicked(updateItem);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SubscriptionUpdateItem subscriptionUpdateItem) {
            a(subscriptionUpdateItem);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: TemplateUpdatesFragment.kt */
    /* loaded from: classes3.dex */
    static final class e extends Lambda implements Function1<SubscriptionUpdateItem, Unit> {
        e() {
            super(1);
        }

        public final void a(@NotNull SubscriptionUpdateItem updateItem) {
            Intrinsics.checkNotNullParameter(updateItem, "updateItem");
            TemplateUpdatesFragment.this.getViewModel().onUserClicked(updateItem);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SubscriptionUpdateItem subscriptionUpdateItem) {
            a(subscriptionUpdateItem);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TemplateUpdatesFragment.kt */
    /* loaded from: classes3.dex */
    public static final class f implements Observer, FunctionAdapter {

        /* renamed from: a  reason: collision with root package name */
        private final /* synthetic */ Function1 f13873a;

        f(Function1 function) {
            Intrinsics.checkNotNullParameter(function, "function");
            this.f13873a = function;
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
            return this.f13873a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f13873a.invoke(obj);
        }
    }

    private final void b() {
        getViewModel().getUpdateItems().observe(getViewLifecycleOwner(), new f(new a()));
        getViewModel().isLoading().observe(getViewLifecycleOwner(), new f(new b()));
        SingleLiveEvent<ErrorType> showError = getViewModel().getShowError();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        showError.observe(viewLifecycleOwner, new f(new Function1<ErrorType, Unit>() { // from class: com.arlosoft.macrodroid.templatestore.ui.subscription.TemplateUpdatesFragment$bindViewModel$3

            /* compiled from: TemplateUpdatesFragment.kt */
            /* loaded from: classes3.dex */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[ErrorType.values().length];
                    try {
                        iArr[ErrorType.MACRO_NOT_AVAILABLE.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[ErrorType.UNKOWN_ERROR.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void a(@Nullable ErrorType errorType) {
                int i4;
                int i5;
                if (errorType == null) {
                    i4 = -1;
                } else {
                    i4 = WhenMappings.$EnumSwitchMapping$0[errorType.ordinal()];
                }
                if (i4 != 1) {
                    if (i4 == 2) {
                        i5 = R.string.error;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    i5 = R.string.macro_not_found;
                }
                ToastCompat.makeText(TemplateUpdatesFragment.this.requireContext(), i5, 0).show();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ErrorType errorType) {
                a(errorType);
                return Unit.INSTANCE;
            }
        }));
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
    public final TemplateUpdatesViewModel getViewModel() {
        TemplateUpdatesViewModel templateUpdatesViewModel = this.viewModel;
        if (templateUpdatesViewModel != null) {
            return templateUpdatesViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @androidx.annotation.Nullable @Nullable ViewGroup viewGroup, @androidx.annotation.Nullable @Nullable Bundle bundle) {
        List emptyList;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentTemplateStoreListUpdatesBinding inflate = FragmentTemplateStoreListUpdatesBinding.inflate(inflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, container, false)");
        this.f13871b = inflate;
        getLifecycle().addObserver(getViewModel());
        b();
        Drawable drawable = ContextCompat.getDrawable(requireContext(), R.drawable.ic_baseline_delete_36);
        Intrinsics.checkNotNull(drawable);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new SwipteToDeleteCallback(drawable, 8, new c()));
        FragmentTemplateStoreListUpdatesBinding fragmentTemplateStoreListUpdatesBinding = this.f13871b;
        FragmentTemplateStoreListUpdatesBinding fragmentTemplateStoreListUpdatesBinding2 = null;
        if (fragmentTemplateStoreListUpdatesBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTemplateStoreListUpdatesBinding = null;
        }
        itemTouchHelper.attachToRecyclerView(fragmentTemplateStoreListUpdatesBinding.updatesList);
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.f13872c = new TemplateUpdatesAdapter(emptyList, getProfileImageProvider(), new d(), new e());
        FragmentTemplateStoreListUpdatesBinding fragmentTemplateStoreListUpdatesBinding3 = this.f13871b;
        if (fragmentTemplateStoreListUpdatesBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTemplateStoreListUpdatesBinding3 = null;
        }
        RecyclerView recyclerView = fragmentTemplateStoreListUpdatesBinding3.updatesList;
        TemplateUpdatesAdapter templateUpdatesAdapter = this.f13872c;
        if (templateUpdatesAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            templateUpdatesAdapter = null;
        }
        recyclerView.setAdapter(templateUpdatesAdapter);
        FragmentTemplateStoreListUpdatesBinding fragmentTemplateStoreListUpdatesBinding4 = this.f13871b;
        if (fragmentTemplateStoreListUpdatesBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentTemplateStoreListUpdatesBinding2 = fragmentTemplateStoreListUpdatesBinding4;
        }
        FrameLayout root = fragmentTemplateStoreListUpdatesBinding2.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    public final void setProfileImageProvider(@NotNull ProfileImageProvider profileImageProvider) {
        Intrinsics.checkNotNullParameter(profileImageProvider, "<set-?>");
        this.profileImageProvider = profileImageProvider;
    }

    public final void setViewModel(@NotNull TemplateUpdatesViewModel templateUpdatesViewModel) {
        Intrinsics.checkNotNullParameter(templateUpdatesViewModel, "<set-?>");
        this.viewModel = templateUpdatesViewModel;
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.TemplateStoreList
    public void scrollToTop() {
    }
}
