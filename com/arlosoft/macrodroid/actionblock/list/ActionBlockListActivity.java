package com.arlosoft.macrodroid.actionblock.list;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import androidx.appcompat.widget.SearchView;
import androidx.cardview.widget.CardView;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.ContextCompat;
import androidx.core.view.MenuItemCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.araujo.jordan.excuseme.ExcuseMe;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.actionblock.data.ActionBlock;
import com.arlosoft.macrodroid.actionblock.edit.ActionBlockEditActivity;
import com.arlosoft.macrodroid.actionblock.list.ActionBlockEvent;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity;
import com.arlosoft.macrodroid.cache.Cache;
import com.arlosoft.macrodroid.categories.Category;
import com.arlosoft.macrodroid.categories.CategoryList;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.databinding.ActivityActionBlockListBinding;
import com.arlosoft.macrodroid.editscreen.EditMacroActivity;
import com.arlosoft.macrodroid.extensions.ViewExtensionsKt;
import com.arlosoft.macrodroid.gson.GsonUtils;
import com.arlosoft.macrodroid.macro.ActionBlockStore;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.nearby.NearbyHelper;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.utils.CategoryPasswordHelper;
import com.arlosoft.macrodroid.utils.MacroUtils;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;
import kotlin.Function;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
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

/* compiled from: ActionBlockListActivity.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nActionBlockListActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActionBlockListActivity.kt\ncom/arlosoft/macrodroid/actionblock/list/ActionBlockListActivity\n+ 2 View.kt\nandroidx/core/view/ViewKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,383:1\n68#2,2:384\n260#2:386\n262#2,2:387\n71#2:389\n40#2:390\n56#2:391\n75#2:392\n262#2,2:393\n262#2,2:395\n262#2,2:397\n260#2:401\n37#3,2:399\n*S KotlinDebug\n*F\n+ 1 ActionBlockListActivity.kt\ncom/arlosoft/macrodroid/actionblock/list/ActionBlockListActivity\n*L\n261#1:384,2\n262#1:386\n265#1:387,2\n261#1:389\n261#1:390\n261#1:391\n261#1:392\n267#1:393,2\n269#1:395,2\n270#1:397,2\n120#1:401\n318#1:399,2\n*E\n"})
/* loaded from: classes.dex */
public final class ActionBlockListActivity extends MacroDroidDaggerBaseActivity {
    @NotNull
    public static final String EXTRA_IS_SELECT_MODE = "is_select_mode";
    @Inject
    public ActionBlockStore actionBlockStore;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private ActionBlockAdapter f5590f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private MenuItem f5591g;

    /* renamed from: h  reason: collision with root package name */
    private ActivityActionBlockListBinding f5592h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f5593i;
    @Inject
    public NearbyHelper nearbyHelper;
    @Inject
    public ActionBlockListViewModel viewModel;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: ActionBlockListActivity.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Intent getIntent(@NotNull Activity activity, boolean z3) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intent intent = new Intent(activity, ActionBlockListActivity.class);
            intent.putExtra(ActionBlockListActivity.EXTRA_IS_SELECT_MODE, z3);
            return intent;
        }

        public final void launch(@NotNull Activity activity, boolean z3, int i4) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            activity.startActivityForResult(getIntent(activity, z3), i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ActionBlockListActivity.kt */
    /* loaded from: classes.dex */
    public static final class a extends Lambda implements Function1<List<? extends ActionBlock>, Unit> {
        a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends ActionBlock> list) {
            invoke2((List<ActionBlock>) list);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(List<ActionBlock> actionBlocks) {
            ActionBlockListActivity actionBlockListActivity = ActionBlockListActivity.this;
            Intrinsics.checkNotNullExpressionValue(actionBlocks, "actionBlocks");
            actionBlockListActivity.u(actionBlocks);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ActionBlockListActivity.kt */
    @SourceDebugExtension({"SMAP\nActionBlockListActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActionBlockListActivity.kt\ncom/arlosoft/macrodroid/actionblock/list/ActionBlockListActivity$configureViewModelObservers$2\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,383:1\n1#2:384\n*E\n"})
    /* loaded from: classes.dex */
    public static final class b extends Lambda implements Function1<ActionBlockEvent, Unit> {
        b() {
            super(1);
        }

        public final void a(@Nullable ActionBlockEvent actionBlockEvent) {
            if (actionBlockEvent != null) {
                ActionBlockListActivity.this.y(actionBlockEvent);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ActionBlockEvent actionBlockEvent) {
            a(actionBlockEvent);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ActionBlockListActivity.kt */
    @SourceDebugExtension({"SMAP\nActionBlockListActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActionBlockListActivity.kt\ncom/arlosoft/macrodroid/actionblock/list/ActionBlockListActivity$configureViewModelObservers$3\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,383:1\n1#2:384\n*E\n"})
    /* loaded from: classes.dex */
    public static final class c extends Lambda implements Function1<ActionBlock, Unit> {
        c() {
            super(1);
        }

        public final void a(@Nullable ActionBlock actionBlock) {
            if (actionBlock != null) {
                ActionBlockListActivity.this.G(actionBlock);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ActionBlock actionBlock) {
            a(actionBlock);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ActionBlockListActivity.kt */
    @SourceDebugExtension({"SMAP\nActionBlockListActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActionBlockListActivity.kt\ncom/arlosoft/macrodroid/actionblock/list/ActionBlockListActivity$configureViewModelObservers$4\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,383:1\n1#2:384\n*E\n"})
    /* loaded from: classes.dex */
    public static final class d extends Lambda implements Function1<Macro, Unit> {
        d() {
            super(1);
        }

        public final void a(@Nullable Macro macro) {
            if (macro != null) {
                ActionBlockListActivity.this.F(macro);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Macro macro) {
            a(macro);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: ActionBlockListActivity.kt */
    /* loaded from: classes.dex */
    static final class e extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
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
                ActionBlockListActivity.this.getViewModel().onAddClicked();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ActionBlockListActivity.kt */
    /* loaded from: classes.dex */
    public static final class f implements Observer, FunctionAdapter {

        /* renamed from: a  reason: collision with root package name */
        private final /* synthetic */ Function1 f5595a;

        f(Function1 function) {
            Intrinsics.checkNotNullParameter(function, "function");
            this.f5595a = function;
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
            return this.f5595a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f5595a.invoke(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(EditText editText, ActionBlockListActivity this$0, ActionBlock actionBlock, EditText editText2, AppCompatDialog dialog, View view) {
        boolean z3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(actionBlock, "$actionBlock");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        if (editText.getText().toString().length() == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            ToastCompat.makeText(this$0, (int) R.string.trigger_cell_tower_enter_group_name_hint, 1).show();
        } else if (this$0.getActionBlockStore().getActionBlockByName(editText.getText().toString()) != null) {
            ToastCompat.makeText(this$0, (int) R.string.action_block_name_already_exists, 1).show();
        } else {
            ActionBlock cloneActionBlock = actionBlock.cloneActionBlock(false, false);
            cloneActionBlock.setIsClonedInstance(false);
            cloneActionBlock.setName(editText.getText().toString());
            cloneActionBlock.setDescription(editText2.getText().toString());
            this$0.getActionBlockStore().addActionBlock(cloneActionBlock);
            this$0.getViewModel().refreshActionBlocks();
            dialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(AppCompatDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.dismiss();
    }

    private final void C() {
        List listOf;
        int i4 = Build.VERSION.SDK_INT;
        if (i4 < 31) {
            listOf = kotlin.collections.e.listOf("android.permission.ACCESS_FINE_LOCATION");
        } else {
            listOf = i4 < 33 ? CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"android.permission.BLUETOOTH_CONNECT", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION", "android.permission.BLUETOOTH_ADVERTISE", "android.permission.BLUETOOTH_CONNECT"}) : CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"android.permission.BLUETOOTH_SCAN", "android.permission.NEARBY_WIFI_DEVICES", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION", "android.permission.BLUETOOTH_ADVERTISE", "android.permission.BLUETOOTH_CONNECT"});
        }
        ExcuseMe.Companion couldYouGive = ExcuseMe.Companion.couldYouGive((Activity) this);
        String[] strArr = (String[]) listOf.toArray(new String[0]);
        couldYouGive.permissionFor((String[]) Arrays.copyOf(strArr, strArr.length), new ActionBlockListActivity$importFromNearby$1(listOf, this));
    }

    private final void D(ActionBlock actionBlock, boolean z3) {
        startActivity(ActionBlockEditActivity.Companion.getIntent(this, this.f5593i, actionBlock, z3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(Macro macro) {
        if (macro.isActionBlock) {
            ActionBlockEditActivity.Companion companion = ActionBlockEditActivity.Companion;
            Intrinsics.checkNotNull(macro, "null cannot be cast to non-null type com.arlosoft.macrodroid.actionblock.data.ActionBlock");
            startActivity(companion.getIntent(this, true, (ActionBlock) macro, false));
            return;
        }
        Intent intent = new Intent(this, EditMacroActivity.class);
        intent.putExtra("MacroId", macro.getId());
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F(final Macro macro) {
        Cache cache = MacroDroidApplication.Companion.getInstance().getCache(Category.CATEGORY_CACHE);
        CategoryList categoryList = (CategoryList) cache.get(Category.CATEGORIES_KEY, CategoryList.class);
        if (categoryList == null) {
            categoryList = new CategoryList(new ArrayList());
        }
        String category = macro.getCategory();
        Intrinsics.checkNotNullExpressionValue(category, "macro.category");
        Category categoryByName = categoryList.getCategoryByName(category);
        if (categoryByName != null && categoryByName.isLocked()) {
            new CategoryPasswordHelper(cache, null).promptForCategoryPassword(this, getString(R.string.enter_category_lock_password), "", Settings.getLockedCategoryPassword(this), 0, new CategoryPasswordHelper.PasswordListener() { // from class: com.arlosoft.macrodroid.actionblock.list.ActionBlockListActivity$navigateToMacroWithLockCheck$1
                @Override // com.arlosoft.macrodroid.utils.CategoryPasswordHelper.PasswordListener
                public void passwordCorrect() {
                    ActionBlockListActivity.this.E(macro);
                }

                @Override // com.arlosoft.macrodroid.utils.CategoryPasswordHelper.PasswordListener
                public void passwordCancelled() {
                }
            });
        } else {
            E(macro);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G(ActionBlock actionBlock) {
        Intent intent = new Intent();
        intent.putExtra(Constants.EXTRA_ACTION_BLOCK_GUID, actionBlock.getGUID());
        intent.putExtra(Constants.EXTRA_ACTION_BLOCK_NAME, actionBlock.getName());
        setResult(-1, intent);
        finish();
    }

    private final void H(final ActionBlock actionBlock) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        String string = getString(R.string.delete);
        String name = actionBlock.getName();
        builder.setTitle(string + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + name);
        builder.setMessage(R.string.are_you_sure_delete_action_block);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.actionblock.list.g
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                ActionBlockListActivity.I(ActionBlockListActivity.this, actionBlock, dialogInterface, i4);
            }
        });
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.actionblock.list.h
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                ActionBlockListActivity.J(dialogInterface, i4);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(ActionBlockListActivity this$0, ActionBlock actionBlock, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(actionBlock, "$actionBlock");
        this$0.getViewModel().onDeleteClicked(actionBlock);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(DialogInterface dialog, int i4) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
    }

    private final void K() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.delete_all);
        builder.setMessage(R.string.are_you_sure_remove_all_action_blocks);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.actionblock.list.a
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                ActionBlockListActivity.L(ActionBlockListActivity.this, dialogInterface, i4);
            }
        });
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.actionblock.list.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                ActionBlockListActivity.M(dialogInterface, i4);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(ActionBlockListActivity this$0, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().deleteAllActionBlocks();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(DialogInterface dialog, int i4) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
    }

    private final void N(ActionBlock actionBlock) {
        MacroUtils.onShareActionBlock(this, actionBlock, getActionBlockStore());
    }

    private final void O(final ActionBlock actionBlock) {
        String[] strArr = {getString(R.string.edit), getString(R.string.menu_run), getString(R.string.delete), getString(R.string.share_action_block), getString(R.string.clone_action_block)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.Theme_App_Dialog);
        builder.setTitle(actionBlock.getName()).setItems(strArr, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.actionblock.list.d
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                ActionBlockListActivity.P(ActionBlockListActivity.this, actionBlock, dialogInterface, i4);
            }
        });
        builder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(ActionBlockListActivity this$0, ActionBlock actionBlock, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(actionBlock, "$actionBlock");
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        if (i4 == 4) {
                            this$0.getViewModel().onCloneActionBlockClicked(actionBlock);
                            return;
                        }
                        return;
                    }
                    this$0.N(actionBlock);
                    return;
                }
                this$0.H(actionBlock);
                return;
            }
            this$0.getViewModel().onTestActionsClicked(actionBlock);
            return;
        }
        this$0.getViewModel().onActionBlockClicked(actionBlock);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u(List<ActionBlock> list) {
        ActivityActionBlockListBinding activityActionBlockListBinding = this.f5592h;
        ActivityActionBlockListBinding activityActionBlockListBinding2 = null;
        if (activityActionBlockListBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityActionBlockListBinding = null;
        }
        activityActionBlockListBinding.actionBlocksList.setItemAnimator(null);
        boolean z3 = true;
        if (list.isEmpty()) {
            ActivityActionBlockListBinding activityActionBlockListBinding3 = this.f5592h;
            if (activityActionBlockListBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityActionBlockListBinding3 = null;
            }
            NestedScrollView nestedScrollView = activityActionBlockListBinding3.scrollView;
            Intrinsics.checkNotNullExpressionValue(nestedScrollView, "binding.scrollView");
            if (ViewCompat.isLaidOut(nestedScrollView) && !nestedScrollView.isLayoutRequested()) {
                ActivityActionBlockListBinding activityActionBlockListBinding4 = this.f5592h;
                if (activityActionBlockListBinding4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityActionBlockListBinding4 = null;
                }
                CardView cardView = activityActionBlockListBinding4.infoCard.infoCardView;
                Intrinsics.checkNotNullExpressionValue(cardView, "binding.infoCard.infoCardView");
                if (cardView.getVisibility() != 0) {
                    z3 = false;
                }
                if (!z3) {
                    ActivityActionBlockListBinding activityActionBlockListBinding5 = this.f5592h;
                    if (activityActionBlockListBinding5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        activityActionBlockListBinding5 = null;
                    }
                    ViewGroup.LayoutParams layoutParams = activityActionBlockListBinding5.emptyView.getLayoutParams();
                    ActivityActionBlockListBinding activityActionBlockListBinding6 = this.f5592h;
                    if (activityActionBlockListBinding6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        activityActionBlockListBinding6 = null;
                    }
                    layoutParams.height = activityActionBlockListBinding6.scrollView.getHeight();
                }
                ActivityActionBlockListBinding activityActionBlockListBinding7 = this.f5592h;
                if (activityActionBlockListBinding7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityActionBlockListBinding7 = null;
                }
                FrameLayout frameLayout = activityActionBlockListBinding7.emptyView;
                Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.emptyView");
                frameLayout.setVisibility(0);
            } else {
                nestedScrollView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.arlosoft.macrodroid.actionblock.list.ActionBlockListActivity$configureActionBlocksList$$inlined$doOnLayout$1
                    @Override // android.view.View.OnLayoutChangeListener
                    public void onLayoutChange(@NotNull View view, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
                        boolean z4;
                        Intrinsics.checkNotNullParameter(view, "view");
                        view.removeOnLayoutChangeListener(this);
                        ActivityActionBlockListBinding activityActionBlockListBinding8 = ActionBlockListActivity.this.f5592h;
                        ActivityActionBlockListBinding activityActionBlockListBinding9 = null;
                        if (activityActionBlockListBinding8 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                            activityActionBlockListBinding8 = null;
                        }
                        CardView cardView2 = activityActionBlockListBinding8.infoCard.infoCardView;
                        Intrinsics.checkNotNullExpressionValue(cardView2, "binding.infoCard.infoCardView");
                        if (cardView2.getVisibility() == 0) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        if (!z4) {
                            ActivityActionBlockListBinding activityActionBlockListBinding10 = ActionBlockListActivity.this.f5592h;
                            if (activityActionBlockListBinding10 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("binding");
                                activityActionBlockListBinding10 = null;
                            }
                            ViewGroup.LayoutParams layoutParams2 = activityActionBlockListBinding10.emptyView.getLayoutParams();
                            ActivityActionBlockListBinding activityActionBlockListBinding11 = ActionBlockListActivity.this.f5592h;
                            if (activityActionBlockListBinding11 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("binding");
                                activityActionBlockListBinding11 = null;
                            }
                            layoutParams2.height = activityActionBlockListBinding11.scrollView.getHeight();
                        }
                        ActivityActionBlockListBinding activityActionBlockListBinding12 = ActionBlockListActivity.this.f5592h;
                        if (activityActionBlockListBinding12 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                        } else {
                            activityActionBlockListBinding9 = activityActionBlockListBinding12;
                        }
                        FrameLayout frameLayout2 = activityActionBlockListBinding9.emptyView;
                        Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.emptyView");
                        frameLayout2.setVisibility(0);
                    }
                });
            }
            ActivityActionBlockListBinding activityActionBlockListBinding8 = this.f5592h;
            if (activityActionBlockListBinding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityActionBlockListBinding2 = activityActionBlockListBinding8;
            }
            RecyclerView recyclerView = activityActionBlockListBinding2.actionBlocksList;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.actionBlocksList");
            recyclerView.setVisibility(8);
            return;
        }
        ActivityActionBlockListBinding activityActionBlockListBinding9 = this.f5592h;
        if (activityActionBlockListBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityActionBlockListBinding9 = null;
        }
        RecyclerView recyclerView2 = activityActionBlockListBinding9.actionBlocksList;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.actionBlocksList");
        recyclerView2.setVisibility(0);
        ActivityActionBlockListBinding activityActionBlockListBinding10 = this.f5592h;
        if (activityActionBlockListBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityActionBlockListBinding10 = null;
        }
        FrameLayout frameLayout2 = activityActionBlockListBinding10.emptyView;
        Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.emptyView");
        frameLayout2.setVisibility(8);
        this.f5590f = new ActionBlockAdapter(list, true ^ this.f5593i, getViewModel());
        ActivityActionBlockListBinding activityActionBlockListBinding11 = this.f5592h;
        if (activityActionBlockListBinding11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityActionBlockListBinding2 = activityActionBlockListBinding11;
        }
        activityActionBlockListBinding2.actionBlocksList.setAdapter(this.f5590f);
        MenuItem menuItem = this.f5591g;
        if (menuItem != null) {
            View actionView = MenuItemCompat.getActionView(menuItem);
            Intrinsics.checkNotNull(actionView, "null cannot be cast to non-null type androidx.appcompat.widget.SearchView");
            SearchView searchView = (SearchView) actionView;
            if (!searchView.isIconified()) {
                ActionBlockAdapter actionBlockAdapter = this.f5590f;
                Intrinsics.checkNotNull(actionBlockAdapter);
                CharSequence query = searchView.getQuery();
                actionBlockAdapter.setFilter(((Object) query) + "_");
            }
        }
    }

    private final void v() {
        ActivityActionBlockListBinding activityActionBlockListBinding = null;
        if (Settings.shouldHideInfoCardActionBlocks(this)) {
            ActivityActionBlockListBinding activityActionBlockListBinding2 = this.f5592h;
            if (activityActionBlockListBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityActionBlockListBinding = activityActionBlockListBinding2;
            }
            activityActionBlockListBinding.infoCard.infoCardView.setVisibility(8);
            return;
        }
        ActivityActionBlockListBinding activityActionBlockListBinding3 = this.f5592h;
        if (activityActionBlockListBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityActionBlockListBinding3 = null;
        }
        activityActionBlockListBinding3.infoCard.infoCardView.setCardBackgroundColor(ContextCompat.getColor(this, R.color.actions_primary));
        ActivityActionBlockListBinding activityActionBlockListBinding4 = this.f5592h;
        if (activityActionBlockListBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityActionBlockListBinding4 = null;
        }
        activityActionBlockListBinding4.infoCard.infoCardTitle.setText(R.string.action_blocks);
        ActivityActionBlockListBinding activityActionBlockListBinding5 = this.f5592h;
        if (activityActionBlockListBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityActionBlockListBinding5 = null;
        }
        activityActionBlockListBinding5.infoCard.infoCardDetail.setText(R.string.action_block_help_info);
        ActivityActionBlockListBinding activityActionBlockListBinding6 = this.f5592h;
        if (activityActionBlockListBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityActionBlockListBinding = activityActionBlockListBinding6;
        }
        activityActionBlockListBinding.infoCard.infoCardGotIt.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.actionblock.list.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ActionBlockListActivity.w(ActionBlockListActivity.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(ActionBlockListActivity this$0, View view) {
        boolean z3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Settings.hideInfoCardActionBlocks(this$0.getApplicationContext());
        ActivityActionBlockListBinding activityActionBlockListBinding = this$0.f5592h;
        ActivityActionBlockListBinding activityActionBlockListBinding2 = null;
        if (activityActionBlockListBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityActionBlockListBinding = null;
        }
        activityActionBlockListBinding.infoCard.infoCardView.setVisibility(8);
        ActivityActionBlockListBinding activityActionBlockListBinding3 = this$0.f5592h;
        if (activityActionBlockListBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityActionBlockListBinding3 = null;
        }
        FrameLayout frameLayout = activityActionBlockListBinding3.emptyView;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.emptyView");
        if (frameLayout.getVisibility() == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            ActivityActionBlockListBinding activityActionBlockListBinding4 = this$0.f5592h;
            if (activityActionBlockListBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityActionBlockListBinding4 = null;
            }
            ViewGroup.LayoutParams layoutParams = activityActionBlockListBinding4.emptyView.getLayoutParams();
            ActivityActionBlockListBinding activityActionBlockListBinding5 = this$0.f5592h;
            if (activityActionBlockListBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityActionBlockListBinding2 = activityActionBlockListBinding5;
            }
            layoutParams.height = activityActionBlockListBinding2.scrollView.getHeight();
        }
    }

    private final void x() {
        getViewModel().getActionBlockList().observe(this, new f(new a()));
        getViewModel().getActionBlockEvent().observe(this, new f(new b()));
        getViewModel().getActionBlockSelectedEvent().observe(this, new f(new c()));
        getViewModel().getNavigateToMacroEvent().observe(this, new f(new d()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y(ActionBlockEvent actionBlockEvent) {
        if (actionBlockEvent instanceof ActionBlockEvent.AddNewBlock) {
            D(actionBlockEvent.getActionBlock(), true);
        } else if (actionBlockEvent instanceof ActionBlockEvent.OpenActionBlock) {
            D(actionBlockEvent.getActionBlock(), false);
        } else if (actionBlockEvent instanceof ActionBlockEvent.ShowActionBlockMenu) {
            O(actionBlockEvent.getActionBlock());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z(String str) {
        String description;
        Object fromJson = GsonUtils.getMacroGson().fromJson(str, (Class<Object>) Macro.class);
        Intrinsics.checkNotNull(fromJson, "null cannot be cast to non-null type com.arlosoft.macrodroid.actionblock.data.ActionBlock");
        final ActionBlock actionBlock = (ActionBlock) fromJson;
        final AppCompatDialog appCompatDialog = new AppCompatDialog(this, R.style.Theme_App_Dialog);
        appCompatDialog.setContentView(R.layout.dialog_add_action_block_from_nearby);
        appCompatDialog.setTitle(R.string.add_action_block);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        Window window = appCompatDialog.getWindow();
        Intrinsics.checkNotNull(window);
        layoutParams.copyFrom(window.getAttributes());
        if (!getResources().getBoolean(R.bool.is_tablet)) {
            layoutParams.width = -1;
        }
        Window window2 = appCompatDialog.getWindow();
        Intrinsics.checkNotNull(window2);
        window2.setAttributes(layoutParams);
        final EditText editText = (EditText) appCompatDialog.findViewById(R.id.descriptionText);
        final EditText editText2 = (EditText) appCompatDialog.findViewById(R.id.nameText);
        Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        Intrinsics.checkNotNull(editText2);
        editText2.setText(actionBlock.getName());
        Intrinsics.checkNotNull(editText);
        if (TextUtils.isEmpty(actionBlock.getDescription())) {
            description = "";
        } else {
            description = actionBlock.getDescription();
        }
        editText.setText(description);
        Intrinsics.checkNotNull(button);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.actionblock.list.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ActionBlockListActivity.A(editText2, this, actionBlock, editText, appCompatDialog, view);
            }
        });
        Intrinsics.checkNotNull(button2);
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.actionblock.list.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ActionBlockListActivity.B(AppCompatDialog.this, view);
            }
        });
        appCompatDialog.show();
    }

    @NotNull
    public final ActionBlockStore getActionBlockStore() {
        ActionBlockStore actionBlockStore = this.actionBlockStore;
        if (actionBlockStore != null) {
            return actionBlockStore;
        }
        Intrinsics.throwUninitializedPropertyAccessException("actionBlockStore");
        return null;
    }

    @NotNull
    public final NearbyHelper getNearbyHelper() {
        NearbyHelper nearbyHelper = this.nearbyHelper;
        if (nearbyHelper != null) {
            return nearbyHelper;
        }
        Intrinsics.throwUninitializedPropertyAccessException("nearbyHelper");
        return null;
    }

    @Nullable
    public final MenuItem getSearchMenuItem() {
        return this.f5591g;
    }

    @NotNull
    public final ActionBlockListViewModel getViewModel() {
        ActionBlockListViewModel actionBlockListViewModel = this.viewModel;
        if (actionBlockListViewModel != null) {
            return actionBlockListViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity, com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        ActivityActionBlockListBinding inflate = ActivityActionBlockListBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater)");
        this.f5592h = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        setContentView(inflate.getRoot());
        this.f5593i = getIntent().getBooleanExtra(EXTRA_IS_SELECT_MODE, false);
        getViewModel().setSelectMode(this.f5593i);
        getLifecycle().addObserver(getViewModel());
        ActivityActionBlockListBinding activityActionBlockListBinding = this.f5592h;
        if (activityActionBlockListBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityActionBlockListBinding = null;
        }
        setSupportActionBar(activityActionBlockListBinding.toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
        if (this.f5593i) {
            ActionBar supportActionBar2 = getSupportActionBar();
            if (supportActionBar2 != null) {
                supportActionBar2.setTitle(R.string.select_action_block);
            }
        } else {
            ActionBar supportActionBar3 = getSupportActionBar();
            if (supportActionBar3 != null) {
                supportActionBar3.setTitle(R.string.action_blocks);
            }
        }
        ActivityActionBlockListBinding activityActionBlockListBinding2 = this.f5592h;
        if (activityActionBlockListBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityActionBlockListBinding2 = null;
        }
        FloatingActionButton floatingActionButton = activityActionBlockListBinding2.fab;
        Intrinsics.checkNotNullExpressionValue(floatingActionButton, "binding.fab");
        ViewExtensionsKt.onClick$default(floatingActionButton, null, new e(null), 1, null);
        x();
        v();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(@NotNull Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        getMenuInflater().inflate(R.menu.action_blocks_menu, menu);
        MenuItem findItem = menu.findItem(R.id.menu_search);
        this.f5591g = findItem;
        View actionView = MenuItemCompat.getActionView(findItem);
        Intrinsics.checkNotNull(actionView, "null cannot be cast to non-null type androidx.appcompat.widget.SearchView");
        ((SearchView) actionView).setOnQueryTextListener(new SearchView.OnQueryTextListener() { // from class: com.arlosoft.macrodroid.actionblock.list.ActionBlockListActivity$onCreateOptionsMenu$1
            @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
            public boolean onQueryTextChange(@NotNull String newText) {
                ActionBlockAdapter actionBlockAdapter;
                Intrinsics.checkNotNullParameter(newText, "newText");
                actionBlockAdapter = ActionBlockListActivity.this.f5590f;
                if (actionBlockAdapter != null) {
                    actionBlockAdapter.setFilter(newText);
                    return true;
                }
                return true;
            }

            @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
            public boolean onQueryTextSubmit(@NotNull String query) {
                Intrinsics.checkNotNullParameter(query, "query");
                return false;
            }
        });
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(@NotNull MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        int itemId = item.getItemId();
        if (itemId != 16908332) {
            if (itemId != R.id.menu_delete_all) {
                if (itemId == R.id.menu_import_from_nearby) {
                    C();
                    return true;
                }
                return true;
            }
            K();
            return true;
        }
        finish();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        getNearbyHelper().stopAdvertising();
        getNearbyHelper().disconnect();
        getNearbyHelper().cleanUpHelper();
        super.onPause();
    }

    public final void setActionBlockStore(@NotNull ActionBlockStore actionBlockStore) {
        Intrinsics.checkNotNullParameter(actionBlockStore, "<set-?>");
        this.actionBlockStore = actionBlockStore;
    }

    public final void setNearbyHelper(@NotNull NearbyHelper nearbyHelper) {
        Intrinsics.checkNotNullParameter(nearbyHelper, "<set-?>");
        this.nearbyHelper = nearbyHelper;
    }

    public final void setSearchMenuItem(@Nullable MenuItem menuItem) {
        this.f5591g = menuItem;
    }

    public final void setViewModel(@NotNull ActionBlockListViewModel actionBlockListViewModel) {
        Intrinsics.checkNotNullParameter(actionBlockListViewModel, "<set-?>");
        this.viewModel = actionBlockListViewModel;
    }
}
