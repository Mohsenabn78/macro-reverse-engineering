package com.arlosoft.macrodroid.templatestore.ui.subscription.mysubscriptions.users;

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
import com.arlosoft.macrodroid.database.room.UserSubscription;
import com.arlosoft.macrodroid.databinding.FragmentTemplateStoreMySubscriptionsBinding;
import com.arlosoft.macrodroid.templatestore.ui.TemplateStoreList;
import com.arlosoft.macrodroid.templatestore.ui.profile.ProfileImageProvider;
import com.arlosoft.macrodroid.templatestore.ui.subscription.SwipteToDeleteCallback;
import com.arlosoft.macrodroid.templatestore.ui.subscription.mysubscriptions.users.viewmodel.MyUserSubscriptionsViewModel;
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

/* compiled from: MyUserSubscriptionsFragment.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class MyUserSubscriptionsFragment extends MacroDroidDaggerBaseFragment implements TemplateStoreList {

    /* renamed from: b  reason: collision with root package name */
    private FragmentTemplateStoreMySubscriptionsBinding f13908b;

    /* renamed from: c  reason: collision with root package name */
    private MyUserSubscriptionsAdapter f13909c;
    @Inject
    public ProfileImageProvider profileImageProvider;
    @Inject
    public MyUserSubscriptionsViewModel viewModel;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: MyUserSubscriptionsFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final MyUserSubscriptionsFragment newInstance() {
            return new MyUserSubscriptionsFragment();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MyUserSubscriptionsFragment.kt */
    @SourceDebugExtension({"SMAP\nMyUserSubscriptionsFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MyUserSubscriptionsFragment.kt\ncom/arlosoft/macrodroid/templatestore/ui/subscription/mysubscriptions/users/MyUserSubscriptionsFragment$bindViewModel$1\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,96:1\n262#2,2:97\n262#2,2:99\n262#2,2:101\n262#2,2:103\n*S KotlinDebug\n*F\n+ 1 MyUserSubscriptionsFragment.kt\ncom/arlosoft/macrodroid/templatestore/ui/subscription/mysubscriptions/users/MyUserSubscriptionsFragment$bindViewModel$1\n*L\n71#1:97,2\n72#1:99,2\n74#1:101,2\n75#1:103,2\n*E\n"})
    /* loaded from: classes3.dex */
    public static final class a extends Lambda implements Function1<List<? extends UserSubscription>, Unit> {
        a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends UserSubscription> list) {
            invoke2((List<UserSubscription>) list);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(List<UserSubscription> it) {
            MyUserSubscriptionsAdapter myUserSubscriptionsAdapter = null;
            FragmentTemplateStoreMySubscriptionsBinding fragmentTemplateStoreMySubscriptionsBinding = null;
            if (it.isEmpty()) {
                FragmentTemplateStoreMySubscriptionsBinding fragmentTemplateStoreMySubscriptionsBinding2 = MyUserSubscriptionsFragment.this.f13908b;
                if (fragmentTemplateStoreMySubscriptionsBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    fragmentTemplateStoreMySubscriptionsBinding2 = null;
                }
                LinearLayout linearLayout = fragmentTemplateStoreMySubscriptionsBinding2.emptyView;
                Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.emptyView");
                linearLayout.setVisibility(0);
                FragmentTemplateStoreMySubscriptionsBinding fragmentTemplateStoreMySubscriptionsBinding3 = MyUserSubscriptionsFragment.this.f13908b;
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
            FragmentTemplateStoreMySubscriptionsBinding fragmentTemplateStoreMySubscriptionsBinding4 = MyUserSubscriptionsFragment.this.f13908b;
            if (fragmentTemplateStoreMySubscriptionsBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentTemplateStoreMySubscriptionsBinding4 = null;
            }
            RecyclerView recyclerView2 = fragmentTemplateStoreMySubscriptionsBinding4.updatesList;
            Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.updatesList");
            recyclerView2.setVisibility(0);
            FragmentTemplateStoreMySubscriptionsBinding fragmentTemplateStoreMySubscriptionsBinding5 = MyUserSubscriptionsFragment.this.f13908b;
            if (fragmentTemplateStoreMySubscriptionsBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentTemplateStoreMySubscriptionsBinding5 = null;
            }
            LinearLayout linearLayout2 = fragmentTemplateStoreMySubscriptionsBinding5.emptyView;
            Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.emptyView");
            linearLayout2.setVisibility(8);
            MyUserSubscriptionsAdapter myUserSubscriptionsAdapter2 = MyUserSubscriptionsFragment.this.f13909c;
            if (myUserSubscriptionsAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
            } else {
                myUserSubscriptionsAdapter = myUserSubscriptionsAdapter2;
            }
            Intrinsics.checkNotNullExpressionValue(it, "it");
            myUserSubscriptionsAdapter.updateItems(it);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MyUserSubscriptionsFragment.kt */
    @SourceDebugExtension({"SMAP\nMyUserSubscriptionsFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MyUserSubscriptionsFragment.kt\ncom/arlosoft/macrodroid/templatestore/ui/subscription/mysubscriptions/users/MyUserSubscriptionsFragment$bindViewModel$2\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,96:1\n262#2,2:97\n*S KotlinDebug\n*F\n+ 1 MyUserSubscriptionsFragment.kt\ncom/arlosoft/macrodroid/templatestore/ui/subscription/mysubscriptions/users/MyUserSubscriptionsFragment$bindViewModel$2\n*L\n80#1:97,2\n*E\n"})
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
            FragmentTemplateStoreMySubscriptionsBinding fragmentTemplateStoreMySubscriptionsBinding = MyUserSubscriptionsFragment.this.f13908b;
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

    /* compiled from: MyUserSubscriptionsFragment.kt */
    /* loaded from: classes3.dex */
    static final class c extends Lambda implements Function1<Integer, Unit> {
        c() {
            super(1);
        }

        public final void invoke(int i4) {
            MyUserSubscriptionsFragment.this.getViewModel().deleteItemAtPosition(i4);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke(num.intValue());
            return Unit.INSTANCE;
        }
    }

    /* compiled from: MyUserSubscriptionsFragment.kt */
    /* loaded from: classes3.dex */
    static final class d extends Lambda implements Function2<UserSubscription, Boolean, Unit> {
        d() {
            super(2);
        }

        public final void a(@NotNull UserSubscription updateItem, boolean z3) {
            Intrinsics.checkNotNullParameter(updateItem, "updateItem");
            if (z3) {
                MyUserSubscriptionsFragment.this.d(updateItem);
            } else {
                MyUserSubscriptionsFragment.this.getViewModel().onUpdateItemClicked(updateItem);
            }
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: invoke */
        public /* bridge */ /* synthetic */ Unit mo1invoke(UserSubscription userSubscription, Boolean bool) {
            a(userSubscription, bool.booleanValue());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MyUserSubscriptionsFragment.kt */
    /* loaded from: classes3.dex */
    public static final class e implements Observer, FunctionAdapter {

        /* renamed from: a  reason: collision with root package name */
        private final /* synthetic */ Function1 f13910a;

        e(Function1 function) {
            Intrinsics.checkNotNullParameter(function, "function");
            this.f13910a = function;
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
            return this.f13910a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f13910a.invoke(obj);
        }
    }

    private final void c() {
        getViewModel().getUpdateItems().observe(getViewLifecycleOwner(), new e(new a()));
        getViewModel().isLoading().observe(getViewLifecycleOwner(), new e(new b()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(final UserSubscription userSubscription) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity(), R.style.Theme_App_Dialog_Action);
        builder.setTitle(userSubscription.getUserName());
        builder.setMessage(R.string.template_store_user_unsubscribe_question);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.templatestore.ui.subscription.mysubscriptions.users.a
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                MyUserSubscriptionsFragment.e(MyUserSubscriptionsFragment.this, userSubscription, dialogInterface, i4);
            }
        });
        builder.setNeutralButton(17039360, (DialogInterface.OnClickListener) null);
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(MyUserSubscriptionsFragment this$0, UserSubscription userSubscription, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(userSubscription, "$userSubscription");
        this$0.getViewModel().unsubscribeItem(userSubscription);
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
    public final MyUserSubscriptionsViewModel getViewModel() {
        MyUserSubscriptionsViewModel myUserSubscriptionsViewModel = this.viewModel;
        if (myUserSubscriptionsViewModel != null) {
            return myUserSubscriptionsViewModel;
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
        this.f13908b = inflate;
        getLifecycle().addObserver(getViewModel());
        c();
        FragmentTemplateStoreMySubscriptionsBinding fragmentTemplateStoreMySubscriptionsBinding = this.f13908b;
        FragmentTemplateStoreMySubscriptionsBinding fragmentTemplateStoreMySubscriptionsBinding2 = null;
        if (fragmentTemplateStoreMySubscriptionsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTemplateStoreMySubscriptionsBinding = null;
        }
        fragmentTemplateStoreMySubscriptionsBinding.emptyMessageText.setText(getString(R.string.template_store_user_subscriptions_empty));
        Drawable drawable = ContextCompat.getDrawable(requireContext(), R.drawable.ic_baseline_delete_36);
        Intrinsics.checkNotNull(drawable);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new SwipteToDeleteCallback(drawable, 4, new c()));
        FragmentTemplateStoreMySubscriptionsBinding fragmentTemplateStoreMySubscriptionsBinding3 = this.f13908b;
        if (fragmentTemplateStoreMySubscriptionsBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTemplateStoreMySubscriptionsBinding3 = null;
        }
        itemTouchHelper.attachToRecyclerView(fragmentTemplateStoreMySubscriptionsBinding3.updatesList);
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.f13909c = new MyUserSubscriptionsAdapter(emptyList, getProfileImageProvider(), new d());
        FragmentTemplateStoreMySubscriptionsBinding fragmentTemplateStoreMySubscriptionsBinding4 = this.f13908b;
        if (fragmentTemplateStoreMySubscriptionsBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTemplateStoreMySubscriptionsBinding4 = null;
        }
        RecyclerView recyclerView = fragmentTemplateStoreMySubscriptionsBinding4.updatesList;
        MyUserSubscriptionsAdapter myUserSubscriptionsAdapter = this.f13909c;
        if (myUserSubscriptionsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            myUserSubscriptionsAdapter = null;
        }
        recyclerView.setAdapter(myUserSubscriptionsAdapter);
        FragmentTemplateStoreMySubscriptionsBinding fragmentTemplateStoreMySubscriptionsBinding5 = this.f13908b;
        if (fragmentTemplateStoreMySubscriptionsBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentTemplateStoreMySubscriptionsBinding2 = fragmentTemplateStoreMySubscriptionsBinding5;
        }
        FrameLayout root = fragmentTemplateStoreMySubscriptionsBinding2.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    public final void setProfileImageProvider(@NotNull ProfileImageProvider profileImageProvider) {
        Intrinsics.checkNotNullParameter(profileImageProvider, "<set-?>");
        this.profileImageProvider = profileImageProvider;
    }

    public final void setViewModel(@NotNull MyUserSubscriptionsViewModel myUserSubscriptionsViewModel) {
        Intrinsics.checkNotNullParameter(myUserSubscriptionsViewModel, "<set-?>");
        this.viewModel = myUserSubscriptionsViewModel;
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.TemplateStoreList
    public void scrollToTop() {
    }
}
