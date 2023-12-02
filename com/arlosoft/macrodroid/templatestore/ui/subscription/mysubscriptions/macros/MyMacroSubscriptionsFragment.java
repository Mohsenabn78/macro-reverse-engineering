package com.arlosoft.macrodroid.templatestore.ui.subscription.mysubscriptions.macros;

import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.app.AlertDialog;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseFragment;
import com.arlosoft.macrodroid.database.room.MacroSubscription;
import com.arlosoft.macrodroid.databinding.FragmentTemplateStoreMySubscriptionsBinding;
import com.arlosoft.macrodroid.templatestore.ui.TemplateStoreList;
import com.arlosoft.macrodroid.templatestore.ui.profile.ProfileImageProvider;
import com.arlosoft.macrodroid.templatestore.ui.subscription.SwipteToDeleteCallback;
import com.arlosoft.macrodroid.templatestore.ui.subscription.mysubscriptions.macros.viewmodel.MyMacroSubscriptionsViewModel;
import java.util.List;
import javax.inject.Inject;
import kotlin.Function;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MyMacroSubscriptionsFragment.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class MyMacroSubscriptionsFragment extends MacroDroidDaggerBaseFragment implements TemplateStoreList {

    /* renamed from: b  reason: collision with root package name */
    private FragmentTemplateStoreMySubscriptionsBinding f13884b;

    /* renamed from: c  reason: collision with root package name */
    private MyMacroSubscriptionsAdapter f13885c;
    @Inject
    public ProfileImageProvider profileImageProvider;
    @Inject
    public MyMacroSubscriptionsViewModel viewModel;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: MyMacroSubscriptionsFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final MyMacroSubscriptionsFragment newInstance() {
            return new MyMacroSubscriptionsFragment();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MyMacroSubscriptionsFragment.kt */
    @SourceDebugExtension({"SMAP\nMyMacroSubscriptionsFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MyMacroSubscriptionsFragment.kt\ncom/arlosoft/macrodroid/templatestore/ui/subscription/mysubscriptions/macros/MyMacroSubscriptionsFragment$bindViewModel$1\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,94:1\n262#2,2:95\n262#2,2:97\n262#2,2:99\n262#2,2:101\n*S KotlinDebug\n*F\n+ 1 MyMacroSubscriptionsFragment.kt\ncom/arlosoft/macrodroid/templatestore/ui/subscription/mysubscriptions/macros/MyMacroSubscriptionsFragment$bindViewModel$1\n*L\n69#1:95,2\n70#1:97,2\n72#1:99,2\n73#1:101,2\n*E\n"})
    /* loaded from: classes3.dex */
    public static final class a extends Lambda implements Function1<List<? extends MacroSubscription>, Unit> {
        a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends MacroSubscription> list) {
            invoke2((List<MacroSubscription>) list);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(List<MacroSubscription> it) {
            MyMacroSubscriptionsAdapter myMacroSubscriptionsAdapter = null;
            FragmentTemplateStoreMySubscriptionsBinding fragmentTemplateStoreMySubscriptionsBinding = null;
            if (it.isEmpty()) {
                FragmentTemplateStoreMySubscriptionsBinding fragmentTemplateStoreMySubscriptionsBinding2 = MyMacroSubscriptionsFragment.this.f13884b;
                if (fragmentTemplateStoreMySubscriptionsBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    fragmentTemplateStoreMySubscriptionsBinding2 = null;
                }
                LinearLayout linearLayout = fragmentTemplateStoreMySubscriptionsBinding2.emptyView;
                Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.emptyView");
                linearLayout.setVisibility(0);
                FragmentTemplateStoreMySubscriptionsBinding fragmentTemplateStoreMySubscriptionsBinding3 = MyMacroSubscriptionsFragment.this.f13884b;
                if (fragmentTemplateStoreMySubscriptionsBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    fragmentTemplateStoreMySubscriptionsBinding = fragmentTemplateStoreMySubscriptionsBinding3;
                }
                RecyclerView recyclerView = fragmentTemplateStoreMySubscriptionsBinding.updatesList;
                Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.updatesList");
                recyclerView.setVisibility(8);
                return;
            }
            FragmentTemplateStoreMySubscriptionsBinding fragmentTemplateStoreMySubscriptionsBinding4 = MyMacroSubscriptionsFragment.this.f13884b;
            if (fragmentTemplateStoreMySubscriptionsBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentTemplateStoreMySubscriptionsBinding4 = null;
            }
            RecyclerView recyclerView2 = fragmentTemplateStoreMySubscriptionsBinding4.updatesList;
            Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.updatesList");
            recyclerView2.setVisibility(0);
            FragmentTemplateStoreMySubscriptionsBinding fragmentTemplateStoreMySubscriptionsBinding5 = MyMacroSubscriptionsFragment.this.f13884b;
            if (fragmentTemplateStoreMySubscriptionsBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentTemplateStoreMySubscriptionsBinding5 = null;
            }
            LinearLayout linearLayout2 = fragmentTemplateStoreMySubscriptionsBinding5.emptyView;
            Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.emptyView");
            linearLayout2.setVisibility(8);
            MyMacroSubscriptionsAdapter myMacroSubscriptionsAdapter2 = MyMacroSubscriptionsFragment.this.f13885c;
            if (myMacroSubscriptionsAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
            } else {
                myMacroSubscriptionsAdapter = myMacroSubscriptionsAdapter2;
            }
            Intrinsics.checkNotNullExpressionValue(it, "it");
            myMacroSubscriptionsAdapter.updateItems(it);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MyMacroSubscriptionsFragment.kt */
    @SourceDebugExtension({"SMAP\nMyMacroSubscriptionsFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MyMacroSubscriptionsFragment.kt\ncom/arlosoft/macrodroid/templatestore/ui/subscription/mysubscriptions/macros/MyMacroSubscriptionsFragment$bindViewModel$2\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,94:1\n262#2,2:95\n*S KotlinDebug\n*F\n+ 1 MyMacroSubscriptionsFragment.kt\ncom/arlosoft/macrodroid/templatestore/ui/subscription/mysubscriptions/macros/MyMacroSubscriptionsFragment$bindViewModel$2\n*L\n78#1:95,2\n*E\n"})
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
            FragmentTemplateStoreMySubscriptionsBinding fragmentTemplateStoreMySubscriptionsBinding = MyMacroSubscriptionsFragment.this.f13884b;
            if (fragmentTemplateStoreMySubscriptionsBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentTemplateStoreMySubscriptionsBinding = null;
            }
            LottieAnimationView lottieAnimationView = fragmentTemplateStoreMySubscriptionsBinding.loadingView;
            Intrinsics.checkNotNullExpressionValue(lottieAnimationView, "binding.loadingView");
            Intrinsics.checkNotNullExpressionValue(it, "it");
            lottieAnimationView.setVisibility(it.booleanValue() ? 0 : 8);
        }
    }

    /* compiled from: MyMacroSubscriptionsFragment.kt */
    /* loaded from: classes3.dex */
    static final class c extends Lambda implements Function1<Integer, Unit> {
        c() {
            super(1);
        }

        public final void invoke(int i4) {
            MyMacroSubscriptionsFragment.this.getViewModel().deleteItemAtPosition(i4);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke(num.intValue());
            return Unit.INSTANCE;
        }
    }

    /* compiled from: MyMacroSubscriptionsFragment.kt */
    /* loaded from: classes3.dex */
    static final class d extends Lambda implements Function2<MacroSubscription, Boolean, Unit> {
        d() {
            super(2);
        }

        public final void a(@NotNull MacroSubscription updateItem, boolean z3) {
            Intrinsics.checkNotNullParameter(updateItem, "updateItem");
            if (z3) {
                MyMacroSubscriptionsFragment.this.d(updateItem);
            } else {
                MyMacroSubscriptionsFragment.this.getViewModel().onUpdateItemClicked(updateItem);
            }
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: invoke */
        public /* bridge */ /* synthetic */ Unit mo1invoke(MacroSubscription macroSubscription, Boolean bool) {
            a(macroSubscription, bool.booleanValue());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MyMacroSubscriptionsFragment.kt */
    /* loaded from: classes3.dex */
    public static final class e implements Observer, FunctionAdapter {

        /* renamed from: a  reason: collision with root package name */
        private final /* synthetic */ Function1 f13886a;

        e(Function1 function) {
            Intrinsics.checkNotNullParameter(function, "function");
            this.f13886a = function;
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
            return this.f13886a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f13886a.invoke(obj);
        }
    }

    private final void c() {
        getViewModel().getUpdateItems().observe(getViewLifecycleOwner(), new e(new a()));
        getViewModel().isLoading().observe(getViewLifecycleOwner(), new e(new b()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(final MacroSubscription macroSubscription) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity(), R.style.Theme_App_Dialog_Action);
        builder.setTitle(macroSubscription.getMacroName());
        builder.setMessage(R.string.template_store_macro_unsubscribe_question);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.templatestore.ui.subscription.mysubscriptions.macros.a
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                MyMacroSubscriptionsFragment.e(MyMacroSubscriptionsFragment.this, macroSubscription, dialogInterface, i4);
            }
        });
        builder.setNeutralButton(17039360, (DialogInterface.OnClickListener) null);
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(MyMacroSubscriptionsFragment this$0, MacroSubscription macroSubscription, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(macroSubscription, "$macroSubscription");
        this$0.getViewModel().unsubscribeItem(macroSubscription);
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
    public final MyMacroSubscriptionsViewModel getViewModel() {
        MyMacroSubscriptionsViewModel myMacroSubscriptionsViewModel = this.viewModel;
        if (myMacroSubscriptionsViewModel != null) {
            return myMacroSubscriptionsViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @androidx.annotation.Nullable @Nullable ViewGroup viewGroup, @androidx.annotation.Nullable @Nullable Bundle bundle) {
        List emptyList;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentTemplateStoreMySubscriptionsBinding inflate = FragmentTemplateStoreMySubscriptionsBinding.inflate(inflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, container, false)");
        this.f13884b = inflate;
        getLifecycle().addObserver(getViewModel());
        c();
        Drawable drawable = ContextCompat.getDrawable(requireContext(), R.drawable.ic_baseline_delete_36);
        Intrinsics.checkNotNull(drawable);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new SwipteToDeleteCallback(drawable, 8, new c()));
        FragmentTemplateStoreMySubscriptionsBinding fragmentTemplateStoreMySubscriptionsBinding = this.f13884b;
        FragmentTemplateStoreMySubscriptionsBinding fragmentTemplateStoreMySubscriptionsBinding2 = null;
        if (fragmentTemplateStoreMySubscriptionsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTemplateStoreMySubscriptionsBinding = null;
        }
        itemTouchHelper.attachToRecyclerView(fragmentTemplateStoreMySubscriptionsBinding.updatesList);
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.f13885c = new MyMacroSubscriptionsAdapter(emptyList, new d());
        FragmentTemplateStoreMySubscriptionsBinding fragmentTemplateStoreMySubscriptionsBinding3 = this.f13884b;
        if (fragmentTemplateStoreMySubscriptionsBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTemplateStoreMySubscriptionsBinding3 = null;
        }
        RecyclerView recyclerView = fragmentTemplateStoreMySubscriptionsBinding3.updatesList;
        MyMacroSubscriptionsAdapter myMacroSubscriptionsAdapter = this.f13885c;
        if (myMacroSubscriptionsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            myMacroSubscriptionsAdapter = null;
        }
        recyclerView.setAdapter(myMacroSubscriptionsAdapter);
        FragmentTemplateStoreMySubscriptionsBinding fragmentTemplateStoreMySubscriptionsBinding4 = this.f13884b;
        if (fragmentTemplateStoreMySubscriptionsBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentTemplateStoreMySubscriptionsBinding2 = fragmentTemplateStoreMySubscriptionsBinding4;
        }
        FrameLayout root = fragmentTemplateStoreMySubscriptionsBinding2.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    public final void setProfileImageProvider(@NotNull ProfileImageProvider profileImageProvider) {
        Intrinsics.checkNotNullParameter(profileImageProvider, "<set-?>");
        this.profileImageProvider = profileImageProvider;
    }

    public final void setViewModel(@NotNull MyMacroSubscriptionsViewModel myMacroSubscriptionsViewModel) {
        Intrinsics.checkNotNullParameter(myMacroSubscriptionsViewModel, "<set-?>");
        this.viewModel = myMacroSubscriptionsViewModel;
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.TemplateStoreList
    public void scrollToTop() {
    }
}
