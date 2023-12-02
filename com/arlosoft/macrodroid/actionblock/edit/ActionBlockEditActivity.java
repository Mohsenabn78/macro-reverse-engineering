package com.arlosoft.macrodroid.actionblock.edit;

import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.araujo.jordan.excuseme.ExcuseMe;
import com.araujo.jordan.excuseme.model.PermissionStatus;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.Action;
import com.arlosoft.macrodroid.action.ConditionAction;
import com.arlosoft.macrodroid.action.ElseAction;
import com.arlosoft.macrodroid.action.ElseIfConditionAction;
import com.arlosoft.macrodroid.action.ElseIfConfirmedThenAction;
import com.arlosoft.macrodroid.action.ElseParentAction;
import com.arlosoft.macrodroid.action.EndIfAction;
import com.arlosoft.macrodroid.action.EndParentAction;
import com.arlosoft.macrodroid.action.IfConditionAction;
import com.arlosoft.macrodroid.action.ParentAction;
import com.arlosoft.macrodroid.action.WaitUntilTriggerAction;
import com.arlosoft.macrodroid.actionblock.ActionBlockHelper;
import com.arlosoft.macrodroid.actionblock.data.ActionBlock;
import com.arlosoft.macrodroid.actionblock.edit.ActionBlockEditActivity;
import com.arlosoft.macrodroid.actionblock.list.ActionBlockListActivity;
import com.arlosoft.macrodroid.advert.AdvertActivity;
import com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity;
import com.arlosoft.macrodroid.app.navigation.ScreenLoader;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.common.MacroDroidVariable;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SimpleDividerItemDecoration;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.common.VariableUpdatedListener;
import com.arlosoft.macrodroid.confirmation.PremiumStatusHandler;
import com.arlosoft.macrodroid.constraint.Constraint;
import com.arlosoft.macrodroid.constraint.LogicConstraint;
import com.arlosoft.macrodroid.data.MacroExportData;
import com.arlosoft.macrodroid.databinding.ActivityActionBlockEditBinding;
import com.arlosoft.macrodroid.editscreen.EditMacroActivity;
import com.arlosoft.macrodroid.editscreen.LocalVarsAdapter;
import com.arlosoft.macrodroid.editscreen.SelectableItemsListAdapter;
import com.arlosoft.macrodroid.editscreen.TopLevelEditHelper;
import com.arlosoft.macrodroid.events.EventBusUtils;
import com.arlosoft.macrodroid.events.ShowActionBlockTestSummaryEvent;
import com.arlosoft.macrodroid.extensions.ViewExtensionsKt;
import com.arlosoft.macrodroid.gson.GsonUtils;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.ActionBlockStore;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroDeserializer;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.macro.RemovedItem;
import com.arlosoft.macrodroid.macro.UserIconHelper;
import com.arlosoft.macrodroid.nearby.NearbyDevice;
import com.arlosoft.macrodroid.nearby.NearbyHelper;
import com.arlosoft.macrodroid.selectableitemlist.AddActionActivity;
import com.arlosoft.macrodroid.selectableitemlist.AddConstraintActivity;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.EmptyTrigger;
import com.arlosoft.macrodroid.triggers.Trigger;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.triggers.WidgetPressedTrigger;
import com.arlosoft.macrodroid.utils.CopyHelper;
import com.arlosoft.macrodroid.utils.MacroListUtils;
import com.arlosoft.macrodroid.utils.MacroUtils;
import com.arlosoft.macrodroid.utils.gradients.Gradients;
import com.arlosoft.macrodroid.variables.DictionaryEventListener;
import com.arlosoft.macrodroid.variables.MacroDroidVariablesActivity;
import com.arlosoft.macrodroid.variables.VariableHelper;
import com.arlosoft.macrodroid.variables.VariableValue;
import com.arlosoft.macrodroid.widget.ItemFinishedListener;
import com.arlosoft.macrodroid.widget.SelectableItemsRecyclerView;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.SnackbarAnimate;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.gson.Gson;
import com.h6ah4i.android.widget.advrecyclerview.draggable.RecyclerViewDragDropManager;
import com.tbruyelle.rxpermissions2.RxPermissions;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Function;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Regex;
import kotlinx.coroutines.CoroutineScope;
import me.drakeet.support.toast.ToastCompat;
import net.cachapa.expandablelayout.ExpandableLayout;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ActionBlockEditActivity.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nActionBlockEditActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActionBlockEditActivity.kt\ncom/arlosoft/macrodroid/actionblock/edit/ActionBlockEditActivity\n+ 2 TextView.kt\nandroidx/core/widget/TextViewKt\n+ 3 View.kt\nandroidx/core/view/ViewKt\n+ 4 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1503:1\n65#2,16:1504\n93#2,3:1520\n65#2,16:1523\n93#2,3:1539\n262#3,2:1542\n262#3,2:1544\n262#3,2:1546\n262#3,2:1548\n262#3,2:1550\n262#3,2:1552\n262#3,2:1554\n262#3,2:1558\n262#3,2:1560\n262#3,2:1565\n262#3,2:1567\n262#3,2:1569\n262#3,2:1577\n262#3,2:1579\n262#3,2:1581\n262#3,2:1583\n262#3,2:1585\n262#3,2:1587\n37#4,2:1556\n37#4,2:1573\n37#4,2:1575\n1747#5,3:1562\n1855#5,2:1571\n*S KotlinDebug\n*F\n+ 1 ActionBlockEditActivity.kt\ncom/arlosoft/macrodroid/actionblock/edit/ActionBlockEditActivity\n*L\n227#1:1504,16\n227#1:1520,3\n230#1:1523,16\n230#1:1539,3\n387#1:1542,2\n388#1:1544,2\n389#1:1546,2\n583#1:1548,2\n584#1:1550,2\n586#1:1552,2\n587#1:1554,2\n1038#1:1558,2\n1040#1:1560,2\n1042#1:1565,2\n1073#1:1567,2\n1109#1:1569,2\n1270#1:1577,2\n1271#1:1579,2\n1282#1:1581,2\n1283#1:1583,2\n1294#1:1585,2\n1295#1:1587,2\n822#1:1556,2\n1244#1:1573,2\n1447#1:1575,2\n1042#1:1562,3\n1219#1:1571,2\n*E\n"})
/* loaded from: classes.dex */
public final class ActionBlockEditActivity extends MacroDroidDaggerBaseActivity implements ItemFinishedListener {
    @Inject
    public ActionBlockStore actionBlockStore;

    /* renamed from: f  reason: collision with root package name */
    private ActivityActionBlockEditBinding f5509f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private SelectableItemsListAdapter<Action> f5510g;

    /* renamed from: h  reason: collision with root package name */
    private ActionBlock f5511h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f5512i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f5513j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f5514k;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private SelectableItem f5515l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f5516m;

    /* renamed from: n  reason: collision with root package name */
    private LocalVarsAdapter f5517n;
    @Inject
    public NearbyHelper nearbyHelper;

    /* renamed from: o  reason: collision with root package name */
    private LocalVarsAdapter f5518o;

    /* renamed from: p  reason: collision with root package name */
    private LocalVarsAdapter f5519p;
    @Inject
    public PremiumStatusHandler premiumStatusHandler;

    /* renamed from: q  reason: collision with root package name */
    private boolean f5520q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f5521r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f5522s;
    @Inject
    public ScreenLoader screenLoader;
    @Nullable

    /* renamed from: t  reason: collision with root package name */
    private Action f5523t;

    /* renamed from: u  reason: collision with root package name */
    private TopLevelEditHelper f5524u;
    @Nullable

    /* renamed from: v  reason: collision with root package name */
    private ActionBlock f5525v;
    @Inject
    public ActionBlockEditViewModel viewModel;
    @NotNull

    /* renamed from: w  reason: collision with root package name */
    private final VariableUpdatedListener f5526w = new VariableUpdatedListener() { // from class: com.arlosoft.macrodroid.actionblock.edit.r
        @Override // com.arlosoft.macrodroid.common.VariableUpdatedListener
        public final void variableValueUpdated(MacroDroidVariable macroDroidVariable, VariableValue variableValue, VariableValue variableValue2, long j4) {
            ActionBlockEditActivity.n0(ActionBlockEditActivity.this, macroDroidVariable, variableValue, variableValue2, j4);
        }
    };
    @NotNull

    /* renamed from: x  reason: collision with root package name */
    private final ActionBlockEditActivity$nearbyDeviceStatusListener$1 f5527x = new NearbyHelper.NearbySendListener() { // from class: com.arlosoft.macrodroid.actionblock.edit.ActionBlockEditActivity$nearbyDeviceStatusListener$1
        @Override // com.arlosoft.macrodroid.nearby.NearbyHelper.NearbySendListener
        public void fileSent(@NotNull NearbyDevice nearbyDevice) {
            Intrinsics.checkNotNullParameter(nearbyDevice, "nearbyDevice");
            ActionBlockEditActivity.this.y0(false);
            ActivityActionBlockEditBinding activityActionBlockEditBinding = ActionBlockEditActivity.this.f5509f;
            if (activityActionBlockEditBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityActionBlockEditBinding = null;
            }
            activityActionBlockEditBinding.nearbySharePanel.collapse();
            ActionBlockEditActivity.this.getNearbyHelper().stopDiscovery();
            ActionBlockEditActivity.this.getNearbyHelper().disconnect();
        }
    };
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: ActionBlockEditActivity.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ Intent getIntent$default(Companion companion, Activity activity, boolean z3, ActionBlock actionBlock, boolean z4, int i4, Object obj) {
            if ((i4 & 8) != 0) {
                z4 = false;
            }
            return companion.getIntent(activity, z3, actionBlock, z4);
        }

        @JvmStatic
        @NotNull
        public final Intent getIntent(@NotNull Activity activity, boolean z3, @NotNull ActionBlock actionBlock, boolean z4) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(actionBlock, "actionBlock");
            Intent intent = new Intent(activity, ActionBlockEditActivity.class);
            intent.putExtra("no_advert", z3);
            intent.putExtra(Constants.EXTRA_ACTION_BLOCK_GUID, actionBlock.getGUID());
            intent.putExtra("adding_new", z4);
            return intent;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ActionBlockEditActivity.kt */
    /* loaded from: classes.dex */
    public static final class a extends Lambda implements Function1<Boolean, Unit> {
        final /* synthetic */ boolean $closeScreen;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(boolean z3) {
            super(1);
            this.$closeScreen = z3;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke2(bool);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(Boolean granted) {
            Intrinsics.checkNotNullExpressionValue(granted, "granted");
            if (granted.booleanValue()) {
                ActionBlockEditActivity.this.N(this.$closeScreen);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ActionBlockEditActivity.kt */
    /* loaded from: classes.dex */
    public static final class a0 implements Observer, FunctionAdapter {

        /* renamed from: a  reason: collision with root package name */
        private final /* synthetic */ Function1 f5531a;

        a0(Function1 function) {
            Intrinsics.checkNotNullParameter(function, "function");
            this.f5531a = function;
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
            return this.f5531a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f5531a.invoke(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ActionBlockEditActivity.kt */
    @SourceDebugExtension({"SMAP\nActionBlockEditActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActionBlockEditActivity.kt\ncom/arlosoft/macrodroid/actionblock/edit/ActionBlockEditActivity$configureUi$10\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,1503:1\n260#2:1504\n262#2,2:1505\n262#2,2:1507\n*S KotlinDebug\n*F\n+ 1 ActionBlockEditActivity.kt\ncom/arlosoft/macrodroid/actionblock/edit/ActionBlockEditActivity$configureUi$10\n*L\n418#1:1504\n419#1:1505,2\n423#1:1507,2\n*E\n"})
    /* loaded from: classes.dex */
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
            boolean z3;
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ActivityActionBlockEditBinding activityActionBlockEditBinding = ActionBlockEditActivity.this.f5509f;
                ActionBlock actionBlock = null;
                if (activityActionBlockEditBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityActionBlockEditBinding = null;
                }
                FrameLayout frameLayout = activityActionBlockEditBinding.localVarsContent;
                Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.localVarsContent");
                if (frameLayout.getVisibility() == 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    ActivityActionBlockEditBinding activityActionBlockEditBinding2 = ActionBlockEditActivity.this.f5509f;
                    if (activityActionBlockEditBinding2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        activityActionBlockEditBinding2 = null;
                    }
                    FrameLayout frameLayout2 = activityActionBlockEditBinding2.localVarsContent;
                    Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.localVarsContent");
                    frameLayout2.setVisibility(8);
                    ActivityActionBlockEditBinding activityActionBlockEditBinding3 = ActionBlockEditActivity.this.f5509f;
                    if (activityActionBlockEditBinding3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        activityActionBlockEditBinding3 = null;
                    }
                    ObjectAnimator.ofFloat(activityActionBlockEditBinding3.localCollapseExpandButton, View.ROTATION, 180.0f, 0.0f).setDuration(500L).start();
                    ActionBlock actionBlock2 = ActionBlockEditActivity.this.f5511h;
                    if (actionBlock2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
                    } else {
                        actionBlock = actionBlock2;
                    }
                    actionBlock.setLocalExpanded(false);
                } else {
                    ActivityActionBlockEditBinding activityActionBlockEditBinding4 = ActionBlockEditActivity.this.f5509f;
                    if (activityActionBlockEditBinding4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        activityActionBlockEditBinding4 = null;
                    }
                    FrameLayout frameLayout3 = activityActionBlockEditBinding4.localVarsContent;
                    Intrinsics.checkNotNullExpressionValue(frameLayout3, "binding.localVarsContent");
                    frameLayout3.setVisibility(0);
                    ActivityActionBlockEditBinding activityActionBlockEditBinding5 = ActionBlockEditActivity.this.f5509f;
                    if (activityActionBlockEditBinding5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        activityActionBlockEditBinding5 = null;
                    }
                    ObjectAnimator.ofFloat(activityActionBlockEditBinding5.localCollapseExpandButton, View.ROTATION, 0.0f, 180.0f).setDuration(500L).start();
                    ActionBlock actionBlock3 = ActionBlockEditActivity.this.f5511h;
                    if (actionBlock3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
                    } else {
                        actionBlock = actionBlock3;
                    }
                    actionBlock.setLocalExpanded(true);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ActionBlockEditActivity.kt */
    /* loaded from: classes.dex */
    public static final class b0 extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ SelectableItemsListAdapter<T> $adapter;
        final /* synthetic */ ImageButton $button;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b0(SelectableItemsListAdapter<T> selectableItemsListAdapter, ImageButton imageButton, Continuation<? super b0> continuation) {
            super(3, continuation);
            this.$adapter = selectableItemsListAdapter;
            this.$button = imageButton;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new b0(this.$adapter, this.$button, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                if (this.$adapter.isDragEnabled()) {
                    this.$button.setSelected(false);
                    this.$adapter.setDragEnabled(false);
                    this.$adapter.setShowGrabHandle(false);
                    this.$adapter.notifyDataSetChanged();
                } else {
                    this.$button.setSelected(true);
                    this.$adapter.setDragEnabled(true);
                    this.$adapter.setShowGrabHandle(true);
                    this.$adapter.notifyDataSetChanged();
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ActionBlockEditActivity.kt */
    /* loaded from: classes.dex */
    public static final class c extends Lambda implements Function1<String, Unit> {
        c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull String it) {
            Intrinsics.checkNotNullParameter(it, "it");
            ActionBlockEditActivity.this.f5513j = true;
            ActionBlockEditActivity.this.G0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ActionBlockEditActivity.kt */
    /* loaded from: classes.dex */
    public static final class d extends Lambda implements Function1<String, Unit> {
        d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull String it) {
            Intrinsics.checkNotNullParameter(it, "it");
            ActionBlockEditActivity.this.f5513j = true;
            ActionBlockEditActivity.this.G0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ActionBlockEditActivity.kt */
    /* loaded from: classes.dex */
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
                ActionBlock actionBlock = null;
                ActionBlockEditActivity.this.f5523t = null;
                Intent intent = new Intent(ActionBlockEditActivity.this, AddActionActivity.class);
                ActionBlock actionBlock2 = ActionBlockEditActivity.this.f5511h;
                if (actionBlock2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
                } else {
                    actionBlock = actionBlock2;
                }
                intent.putExtra("MacroId", actionBlock.getId());
                ActionBlockEditActivity.this.startActivityForResult(intent, 501);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ActionBlockEditActivity.kt */
    /* loaded from: classes.dex */
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
                ActionBlockEditActivity.this.U(VariableType.INPUT);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ActionBlockEditActivity.kt */
    /* loaded from: classes.dex */
    public static final class g extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        int label;

        g(Continuation<? super g> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new g(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ActionBlockEditActivity.this.U(VariableType.OUTPUT);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ActionBlockEditActivity.kt */
    /* loaded from: classes.dex */
    public static final class h extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        int label;

        h(Continuation<? super h> continuation) {
            super(3, continuation);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(ActionBlockEditActivity actionBlockEditActivity, DialogInterface dialogInterface, int i4) {
            Settings.setShowWorkingVariableHelpInfo(actionBlockEditActivity, false);
            actionBlockEditActivity.U(VariableType.LOCAL_WORKING_VAR);
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: b */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new h(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                if (!Settings.getShowWorkingVariableHelpInfo(ActionBlockEditActivity.this)) {
                    ActionBlockEditActivity.this.U(VariableType.LOCAL_WORKING_VAR);
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(ActionBlockEditActivity.this);
                    builder.setMessage(R.string.action_block_working_variable_info);
                    final ActionBlockEditActivity actionBlockEditActivity = ActionBlockEditActivity.this;
                    builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.actionblock.edit.v
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i4) {
                            ActionBlockEditActivity.h.c(ActionBlockEditActivity.this, dialogInterface, i4);
                        }
                    });
                    builder.show();
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ActionBlockEditActivity.kt */
    /* loaded from: classes.dex */
    public static final class i extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        int label;

        i(Continuation<? super i> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new i(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ActionBlockEditActivity.this.l0();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ActionBlockEditActivity.kt */
    @SourceDebugExtension({"SMAP\nActionBlockEditActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActionBlockEditActivity.kt\ncom/arlosoft/macrodroid/actionblock/edit/ActionBlockEditActivity$configureUi$8\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,1503:1\n260#2:1504\n262#2,2:1505\n262#2,2:1507\n*S KotlinDebug\n*F\n+ 1 ActionBlockEditActivity.kt\ncom/arlosoft/macrodroid/actionblock/edit/ActionBlockEditActivity$configureUi$8\n*L\n396#1:1504\n397#1:1505,2\n401#1:1507,2\n*E\n"})
    /* loaded from: classes.dex */
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
            boolean z3;
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ActivityActionBlockEditBinding activityActionBlockEditBinding = ActionBlockEditActivity.this.f5509f;
                ActionBlock actionBlock = null;
                if (activityActionBlockEditBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityActionBlockEditBinding = null;
                }
                FrameLayout frameLayout = activityActionBlockEditBinding.inputVarsContent;
                Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.inputVarsContent");
                if (frameLayout.getVisibility() == 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    ActivityActionBlockEditBinding activityActionBlockEditBinding2 = ActionBlockEditActivity.this.f5509f;
                    if (activityActionBlockEditBinding2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        activityActionBlockEditBinding2 = null;
                    }
                    FrameLayout frameLayout2 = activityActionBlockEditBinding2.inputVarsContent;
                    Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.inputVarsContent");
                    frameLayout2.setVisibility(8);
                    ActivityActionBlockEditBinding activityActionBlockEditBinding3 = ActionBlockEditActivity.this.f5509f;
                    if (activityActionBlockEditBinding3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        activityActionBlockEditBinding3 = null;
                    }
                    ObjectAnimator.ofFloat(activityActionBlockEditBinding3.inputCollapseExpandButton, View.ROTATION, 180.0f, 0.0f).setDuration(500L).start();
                    ActionBlock actionBlock2 = ActionBlockEditActivity.this.f5511h;
                    if (actionBlock2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
                    } else {
                        actionBlock = actionBlock2;
                    }
                    actionBlock.setInputExpanded(false);
                } else {
                    ActivityActionBlockEditBinding activityActionBlockEditBinding4 = ActionBlockEditActivity.this.f5509f;
                    if (activityActionBlockEditBinding4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        activityActionBlockEditBinding4 = null;
                    }
                    FrameLayout frameLayout3 = activityActionBlockEditBinding4.inputVarsContent;
                    Intrinsics.checkNotNullExpressionValue(frameLayout3, "binding.inputVarsContent");
                    frameLayout3.setVisibility(0);
                    ActivityActionBlockEditBinding activityActionBlockEditBinding5 = ActionBlockEditActivity.this.f5509f;
                    if (activityActionBlockEditBinding5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        activityActionBlockEditBinding5 = null;
                    }
                    ObjectAnimator.ofFloat(activityActionBlockEditBinding5.inputCollapseExpandButton, View.ROTATION, 0.0f, 180.0f).setDuration(500L).start();
                    ActionBlock actionBlock3 = ActionBlockEditActivity.this.f5511h;
                    if (actionBlock3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
                    } else {
                        actionBlock = actionBlock3;
                    }
                    actionBlock.setInputExpanded(true);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ActionBlockEditActivity.kt */
    @SourceDebugExtension({"SMAP\nActionBlockEditActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActionBlockEditActivity.kt\ncom/arlosoft/macrodroid/actionblock/edit/ActionBlockEditActivity$configureUi$9\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,1503:1\n260#2:1504\n262#2,2:1505\n262#2,2:1507\n*S KotlinDebug\n*F\n+ 1 ActionBlockEditActivity.kt\ncom/arlosoft/macrodroid/actionblock/edit/ActionBlockEditActivity$configureUi$9\n*L\n407#1:1504\n408#1:1505,2\n412#1:1507,2\n*E\n"})
    /* loaded from: classes.dex */
    public static final class k extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        int label;

        k(Continuation<? super k> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new k(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            boolean z3;
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ActivityActionBlockEditBinding activityActionBlockEditBinding = ActionBlockEditActivity.this.f5509f;
                ActionBlock actionBlock = null;
                if (activityActionBlockEditBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityActionBlockEditBinding = null;
                }
                FrameLayout frameLayout = activityActionBlockEditBinding.outputVarsContent;
                Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.outputVarsContent");
                if (frameLayout.getVisibility() == 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    ActivityActionBlockEditBinding activityActionBlockEditBinding2 = ActionBlockEditActivity.this.f5509f;
                    if (activityActionBlockEditBinding2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        activityActionBlockEditBinding2 = null;
                    }
                    FrameLayout frameLayout2 = activityActionBlockEditBinding2.outputVarsContent;
                    Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.outputVarsContent");
                    frameLayout2.setVisibility(8);
                    ActivityActionBlockEditBinding activityActionBlockEditBinding3 = ActionBlockEditActivity.this.f5509f;
                    if (activityActionBlockEditBinding3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        activityActionBlockEditBinding3 = null;
                    }
                    ObjectAnimator.ofFloat(activityActionBlockEditBinding3.outputCollapseExpandButton, View.ROTATION, 180.0f, 0.0f).setDuration(500L).start();
                    ActionBlock actionBlock2 = ActionBlockEditActivity.this.f5511h;
                    if (actionBlock2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
                    } else {
                        actionBlock = actionBlock2;
                    }
                    actionBlock.setOutputExpanded(false);
                } else {
                    ActivityActionBlockEditBinding activityActionBlockEditBinding4 = ActionBlockEditActivity.this.f5509f;
                    if (activityActionBlockEditBinding4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        activityActionBlockEditBinding4 = null;
                    }
                    FrameLayout frameLayout3 = activityActionBlockEditBinding4.outputVarsContent;
                    Intrinsics.checkNotNullExpressionValue(frameLayout3, "binding.outputVarsContent");
                    frameLayout3.setVisibility(0);
                    ActivityActionBlockEditBinding activityActionBlockEditBinding5 = ActionBlockEditActivity.this.f5509f;
                    if (activityActionBlockEditBinding5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        activityActionBlockEditBinding5 = null;
                    }
                    ObjectAnimator.ofFloat(activityActionBlockEditBinding5.outputCollapseExpandButton, View.ROTATION, 0.0f, 180.0f).setDuration(500L).start();
                    ActionBlock actionBlock3 = ActionBlockEditActivity.this.f5511h;
                    if (actionBlock3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
                    } else {
                        actionBlock = actionBlock3;
                    }
                    actionBlock.setOutputExpanded(true);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ActionBlockEditActivity.kt */
    /* loaded from: classes.dex */
    public static final class l extends Lambda implements Function1<Boolean, Unit> {
        l() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke2(bool);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@Nullable Boolean bool) {
            ActionBlockEditActivity.this.M(bool != null ? bool.booleanValue() : false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ActionBlockEditActivity.kt */
    /* loaded from: classes.dex */
    public static final class m extends Lambda implements Function1<ActionBlock, Unit> {
        m() {
            super(1);
        }

        public final void a(@Nullable ActionBlock actionBlock) {
            ActionBlockEditActivity.this.M(false);
            if (actionBlock != null) {
                ActionBlockEditActivity actionBlockEditActivity = ActionBlockEditActivity.this;
                actionBlockEditActivity.startActivity(Companion.getIntent$default(ActionBlockEditActivity.Companion, actionBlockEditActivity, true, actionBlock, false, 8, null));
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ActionBlock actionBlock) {
            a(actionBlock);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: ActionBlockEditActivity.kt */
    /* loaded from: classes.dex */
    static final class n extends Lambda implements Function1<Boolean, Unit> {
        n() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.INSTANCE;
        }

        public final void invoke(boolean z3) {
            ActionBlockEditActivity.this.z0(z3);
        }
    }

    /* compiled from: ActionBlockEditActivity.kt */
    /* loaded from: classes.dex */
    static final class o extends Lambda implements Function0<Unit> {
        o() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ActionBlockEditActivity.refresh$default(ActionBlockEditActivity.this, false, 1, null);
        }
    }

    /* compiled from: ActionBlockEditActivity.kt */
    /* loaded from: classes.dex */
    static final class p extends Lambda implements Function0<Unit> {
        p() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ActionBlockEditActivity.refresh$default(ActionBlockEditActivity.this, false, 1, null);
        }
    }

    /* compiled from: ActionBlockEditActivity.kt */
    /* loaded from: classes.dex */
    static final class q extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        int label;

        q(Continuation<? super q> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new q(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ActionBlockEditActivity.this.onBackPressed();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: ActionBlockEditActivity.kt */
    /* loaded from: classes.dex */
    static final class r extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ AppCompatDialog $dialog;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        r(AppCompatDialog appCompatDialog, Continuation<? super r> continuation) {
            super(3, continuation);
            this.$dialog = appCompatDialog;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new r(this.$dialog, continuation).invokeSuspend(Unit.INSTANCE);
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
    /* compiled from: ActionBlockEditActivity.kt */
    /* loaded from: classes.dex */
    public static final class s extends Lambda implements Function1<PermissionStatus, Unit> {
        final /* synthetic */ List<String> $permissionsRequired;
        final /* synthetic */ ActionBlockEditActivity this$0;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ActionBlockEditActivity.kt */
        /* loaded from: classes.dex */
        public static final class a extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ ActionBlockEditActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(ActionBlockEditActivity actionBlockEditActivity, Continuation<? super a> continuation) {
                super(3, continuation);
                this.this$0 = actionBlockEditActivity;
            }

            @Override // kotlin.jvm.functions.Function3
            @Nullable
            /* renamed from: a */
            public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
                return new a(this.this$0, continuation).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.this$0.y0(false);
                    ActivityActionBlockEditBinding activityActionBlockEditBinding = this.this$0.f5509f;
                    if (activityActionBlockEditBinding == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        activityActionBlockEditBinding = null;
                    }
                    activityActionBlockEditBinding.nearbySharePanel.collapse();
                    this.this$0.getNearbyHelper().stopDiscovery();
                    this.this$0.getNearbyHelper().disconnect();
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ActionBlockEditActivity.kt */
        /* loaded from: classes.dex */
        public static final class b extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ ActionBlockEditActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(ActionBlockEditActivity actionBlockEditActivity, Continuation<? super b> continuation) {
                super(3, continuation);
                this.this$0 = actionBlockEditActivity;
            }

            @Override // kotlin.jvm.functions.Function3
            @Nullable
            /* renamed from: a */
            public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
                return new b(this.this$0, continuation).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.this$0.getNearbyHelper().sendFileNearby();
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        s(List<String> list, ActionBlockEditActivity actionBlockEditActivity) {
            super(1);
            this.$permissionsRequired = list;
            this.this$0 = actionBlockEditActivity;
        }

        public final void a(@NotNull PermissionStatus it) {
            Intrinsics.checkNotNullParameter(it, "it");
            for (String str : this.$permissionsRequired) {
                if (!it.getGranted().contains(str)) {
                    return;
                }
            }
            this.this$0.y0(false);
            ActivityActionBlockEditBinding activityActionBlockEditBinding = this.this$0.f5509f;
            if (activityActionBlockEditBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityActionBlockEditBinding = null;
            }
            activityActionBlockEditBinding.nearbySharePanel.expand();
            NearbyHelper nearbyHelper = this.this$0.getNearbyHelper();
            ActionBlock actionBlock = this.this$0.f5511h;
            if (actionBlock == null) {
                Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
                actionBlock = null;
            }
            nearbyHelper.initialiseHelperForSending(actionBlock, this.this$0.f5527x);
            ActivityActionBlockEditBinding activityActionBlockEditBinding2 = this.this$0.f5509f;
            if (activityActionBlockEditBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityActionBlockEditBinding2 = null;
            }
            ImageView imageView = activityActionBlockEditBinding2.dismissButton;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.dismissButton");
            ViewExtensionsKt.onClick$default(imageView, null, new a(this.this$0, null), 1, null);
            this.this$0.getNearbyHelper().startDiscovery(NearbyHelper.SERVICE_ID_ACTION_BLOCK_SHARE);
            ActivityActionBlockEditBinding activityActionBlockEditBinding3 = this.this$0.f5509f;
            if (activityActionBlockEditBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityActionBlockEditBinding3 = null;
            }
            Button button = activityActionBlockEditBinding3.deviceButton;
            Intrinsics.checkNotNullExpressionValue(button, "binding.deviceButton");
            ViewExtensionsKt.onClick$default(button, null, new b(this.this$0, null), 1, null);
            this.this$0.f5522s = true;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PermissionStatus permissionStatus) {
            a(permissionStatus);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ActionBlockEditActivity.kt */
    /* loaded from: classes.dex */
    public static final class t extends Lambda implements Function1<SelectableItem, Unit> {
        t() {
            super(1);
        }

        public final void a(@NotNull SelectableItem item) {
            Intrinsics.checkNotNullParameter(item, "item");
            ActionBlockEditActivity actionBlockEditActivity = ActionBlockEditActivity.this;
            ActionBlock actionBlock = actionBlockEditActivity.f5511h;
            if (actionBlock == null) {
                Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
                actionBlock = null;
            }
            actionBlockEditActivity.showEditButtonMenu(item, actionBlock);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SelectableItem selectableItem) {
            a(selectableItem);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ActionBlockEditActivity.kt */
    /* loaded from: classes.dex */
    public static final class u extends Lambda implements Function1<SelectableItem, Unit> {
        u() {
            super(1);
        }

        public final void a(@NotNull SelectableItem item) {
            Intrinsics.checkNotNullParameter(item, "item");
            if (!(item instanceof ElseParentAction) && !(item instanceof EndIfAction)) {
                TopLevelEditHelper topLevelEditHelper = ActionBlockEditActivity.this.f5524u;
                if (topLevelEditHelper == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("topLevelEditHelper");
                    topLevelEditHelper = null;
                }
                topLevelEditHelper.showHelpInfoDialog(item);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SelectableItem selectableItem) {
            a(selectableItem);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ActionBlockEditActivity.kt */
    /* loaded from: classes.dex */
    public static final class v extends Lambda implements Function1<SelectableItem, Unit> {
        v() {
            super(1);
        }

        public final void a(@NotNull SelectableItem item) {
            Intrinsics.checkNotNullParameter(item, "item");
            TopLevelEditHelper topLevelEditHelper = ActionBlockEditActivity.this.f5524u;
            if (topLevelEditHelper == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topLevelEditHelper");
                topLevelEditHelper = null;
            }
            topLevelEditHelper.expandOrCollapseParentAction(item);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SelectableItem selectableItem) {
            a(selectableItem);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ActionBlockEditActivity.kt */
    /* loaded from: classes.dex */
    public static final class w extends Lambda implements Function1<List<? extends SelectableItem>, Unit> {
        w() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends SelectableItem> list) {
            invoke2(list);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull List<? extends SelectableItem> itemsList) {
            Intrinsics.checkNotNullParameter(itemsList, "itemsList");
            ActionBlockEditActivity.this.setHasEdited();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ActionBlockEditActivity.kt */
    /* loaded from: classes.dex */
    public static final class x extends Lambda implements Function1<MacroDroidVariable, Unit> {
        x() {
            super(1);
        }

        public final void a(@NotNull MacroDroidVariable it) {
            Intrinsics.checkNotNullParameter(it, "it");
            ActionBlockEditActivity.this.D0(it);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MacroDroidVariable macroDroidVariable) {
            a(macroDroidVariable);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ActionBlockEditActivity.kt */
    /* loaded from: classes.dex */
    public static final class y extends Lambda implements Function1<MacroDroidVariable, Unit> {
        y() {
            super(1);
        }

        public final void a(@NotNull MacroDroidVariable it) {
            Intrinsics.checkNotNullParameter(it, "it");
            ActionBlockEditActivity.this.D0(it);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MacroDroidVariable macroDroidVariable) {
            a(macroDroidVariable);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ActionBlockEditActivity.kt */
    /* loaded from: classes.dex */
    public static final class z extends Lambda implements Function1<MacroDroidVariable, Unit> {
        z() {
            super(1);
        }

        public final void a(@NotNull MacroDroidVariable it) {
            Intrinsics.checkNotNullParameter(it, "it");
            ActionBlockEditActivity.this.D0(it);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MacroDroidVariable macroDroidVariable) {
            a(macroDroidVariable);
            return Unit.INSTANCE;
        }
    }

    private final <T extends SelectableItem> void A0(ImageButton imageButton, SelectableItemsListAdapter<T> selectableItemsListAdapter, List<? extends SelectableItem> list) {
        boolean z3;
        int i4 = 0;
        imageButton.setSelected(false);
        if (selectableItemsListAdapter.getItemCount() >= 2) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z3) {
            i4 = 8;
        }
        imageButton.setVisibility(i4);
        ViewExtensionsKt.onClick$default(imageButton, null, new b0(selectableItemsListAdapter, imageButton, null), 1, null);
        list.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B0(ActionBlockEditActivity this$0, List removedItems, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(removedItems, "$removedItems");
        ActionBlock actionBlock = this$0.f5511h;
        if (actionBlock == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
            actionBlock = null;
        }
        actionBlock.restoreItems(removedItems);
        refresh$default(this$0, false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C0(ActionBlockEditActivity this$0, String[] optionsToShow, SelectableItem item, Macro macro, DialogInterface dialogInterface, int i4) {
        int indexOf;
        int indexOf2;
        int indexOf3;
        List emptyList;
        List emptyList2;
        List<SelectableItem> copyItems;
        List<SelectableItem> reversed;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(optionsToShow, "$optionsToShow");
        Intrinsics.checkNotNullParameter(item, "$item");
        Intrinsics.checkNotNullParameter(macro, "$macro");
        TopLevelEditHelper topLevelEditHelper = null;
        ActionBlock actionBlock = null;
        ActionBlock actionBlock2 = null;
        ActionBlock actionBlock3 = null;
        TopLevelEditHelper topLevelEditHelper2 = null;
        TopLevelEditHelper topLevelEditHelper3 = null;
        this$0.f5523t = null;
        String str = optionsToShow[i4];
        if (Intrinsics.areEqual(str, this$0.getString(R.string.add_child_action))) {
            Intent intent = new Intent(this$0, AddActionActivity.class);
            ActionBlock actionBlock4 = this$0.f5511h;
            if (actionBlock4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
            } else {
                actionBlock = actionBlock4;
            }
            intent.putExtra("MacroId", actionBlock.getId());
            intent.putExtra(Constants.EXTRA_PARENT_GUID, item.getSIGUID());
            this$0.startActivityForResult(intent, 503);
        } else if (Intrinsics.areEqual(str, this$0.getString(R.string.paste_action_above))) {
            if (CopyHelper.copyItem() != null) {
                copyItems = kotlin.collections.e.listOf(CopyHelper.copyItem());
            } else {
                copyItems = CopyHelper.copyItemList();
            }
            ActionBlock actionBlock5 = this$0.f5511h;
            if (actionBlock5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
                actionBlock5 = null;
            }
            int size = actionBlock5.getActions().size();
            int i5 = 0;
            while (true) {
                if (i5 >= size) {
                    break;
                }
                ActionBlock actionBlock6 = this$0.f5511h;
                if (actionBlock6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
                    actionBlock6 = null;
                }
                if (actionBlock6.getActions().get(i5).getSIGUID() == item.getSIGUID()) {
                    Intrinsics.checkNotNullExpressionValue(copyItems, "copyItems");
                    reversed = CollectionsKt___CollectionsKt.reversed(copyItems);
                    for (SelectableItem selectableItem : reversed) {
                        Intrinsics.checkNotNull(selectableItem, "null cannot be cast to non-null type com.arlosoft.macrodroid.action.Action");
                        Action action = (Action) selectableItem;
                        ActionBlock actionBlock7 = this$0.f5511h;
                        if (actionBlock7 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
                            actionBlock7 = null;
                        }
                        actionBlock7.addActionAtIndex(action, i5);
                        ActionBlock actionBlock8 = this$0.f5511h;
                        if (actionBlock8 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
                            actionBlock8 = null;
                        }
                        action.setMacro(actionBlock8);
                    }
                } else {
                    i5++;
                }
            }
            CopyHelper.refreshCopiedItem();
            this$0.f5513j = true;
            refresh$default(this$0, false, 1, null);
        } else if (Intrinsics.areEqual(str, this$0.getString(R.string.add_action_above))) {
            Intent intent2 = new Intent(this$0, AddActionActivity.class);
            ActionBlock actionBlock9 = this$0.f5511h;
            if (actionBlock9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
            } else {
                actionBlock2 = actionBlock9;
            }
            intent2.putExtra("MacroId", actionBlock2.getId());
            intent2.putExtra(Constants.EXTRA_PARENT_GUID_FOR_INSERT, item.getSIGUID());
            this$0.startActivityForResult(intent2, 501);
        } else if (Intrinsics.areEqual(str, this$0.getString(R.string.add_constraint))) {
            Intent intent3 = new Intent(this$0, AddConstraintActivity.class);
            ActionBlock actionBlock10 = this$0.f5511h;
            if (actionBlock10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
            } else {
                actionBlock3 = actionBlock10;
            }
            intent3.putExtra("MacroId", actionBlock3.getId());
            intent3.putExtra(Constants.EXTRA_PARENT_GUID, item.getSIGUID());
            this$0.startActivityForResult(intent3, 502);
        } else if (Intrinsics.areEqual(str, this$0.getString(R.string.configure))) {
            item.setActivity(this$0);
            item.onItemSelected();
        } else if (Intrinsics.areEqual(str, this$0.getString(R.string.test_action))) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            SelectableItem copyItem = CopyHelper.copyItem(item, emptyList, emptyList2);
            Intrinsics.checkNotNull(copyItem, "null cannot be cast to non-null type com.arlosoft.macrodroid.action.Action");
            Action action2 = (Action) copyItem;
            action2.setMacro(item.getMacro());
            action2.testActionWithPermissionCheck(new TriggerContextInfo(""));
        } else {
            if (Intrinsics.areEqual(str, this$0.getString(R.string.test_action) + " (" + this$0.getString(R.string.testing_trigger_or_action_with_constraints) + ")")) {
                ((Action) item).testActionWithPermissionCheckAndConstraints(new TriggerContextInfo(""));
            } else if (Intrinsics.areEqual(str, this$0.getString(R.string.test_trigger))) {
                ((Trigger) item).testTrigger();
            } else if (Intrinsics.areEqual(str, this$0.getString(R.string.help))) {
                TopLevelEditHelper topLevelEditHelper4 = this$0.f5524u;
                if (topLevelEditHelper4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("topLevelEditHelper");
                } else {
                    topLevelEditHelper2 = topLevelEditHelper4;
                }
                topLevelEditHelper2.showHelpInfoDialog(item);
            } else if (Intrinsics.areEqual(str, this$0.getString(R.string.paste_constraint))) {
                SelectableItem copyItem2 = CopyHelper.copyItem();
                Intrinsics.checkNotNull(copyItem2, "null cannot be cast to non-null type com.arlosoft.macrodroid.constraint.Constraint");
                Constraint constraint = (Constraint) copyItem2;
                item.addConstraint(constraint);
                ActionBlock actionBlock11 = this$0.f5511h;
                if (actionBlock11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
                    actionBlock11 = null;
                }
                constraint.setMacro(actionBlock11);
                if (constraint instanceof LogicConstraint) {
                    List<Constraint> constraints = constraint.getConstraints();
                    Intrinsics.checkNotNullExpressionValue(constraints, "constraint.getConstraints()");
                    if (this$0.r0(0, constraints)) {
                        item.forceRemoveConstraint(constraint);
                        ToastCompat.makeText(this$0.getApplicationContext(), (int) R.string.cannot_add_constraint_infinite_recursion, 0).show();
                    }
                }
                CopyHelper.refreshCopiedItem();
                this$0.f5513j = true;
                refresh$default(this$0, false, 1, null);
            } else if (Intrinsics.areEqual(str, this$0.getString(R.string.ui_interaction_cut))) {
                boolean z3 = item instanceof ParentAction;
                if (z3) {
                    TopLevelEditHelper topLevelEditHelper5 = this$0.f5524u;
                    if (topLevelEditHelper5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("topLevelEditHelper");
                        topLevelEditHelper5 = null;
                    }
                    topLevelEditHelper5.copyParentAction((ParentAction) item, macro);
                } else {
                    CopyHelper.setCopiedItem(item);
                }
                ToastCompat.makeText(this$0.getApplicationContext(), (int) R.string.copied_to_clipboard, 0).show();
                this$0.H0();
                if (z3) {
                    int parentEndIndex = MacroListUtils.getParentEndIndex(macro.getActions(), macro.getActions().indexOf(item));
                    int indexOf4 = macro.getActions().indexOf(item);
                    if (indexOf4 <= parentEndIndex) {
                        while (true) {
                            macro.getActions().remove(parentEndIndex);
                            if (parentEndIndex == indexOf4) {
                                break;
                            }
                            parentEndIndex--;
                        }
                    }
                } else {
                    macro.removeItem(item);
                }
                this$0.f5515l = null;
                this$0.f5513j = true;
                refresh$default(this$0, false, 1, null);
            } else if (Intrinsics.areEqual(str, this$0.getString(R.string.action_file_operation_copy))) {
                if (item instanceof ParentAction) {
                    TopLevelEditHelper topLevelEditHelper6 = this$0.f5524u;
                    if (topLevelEditHelper6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("topLevelEditHelper");
                    } else {
                        topLevelEditHelper3 = topLevelEditHelper6;
                    }
                    topLevelEditHelper3.copyParentAction((ParentAction) item, macro);
                } else {
                    CopyHelper.setCopiedItem(item);
                }
                ToastCompat.makeText(this$0.getApplicationContext(), (int) R.string.copied_to_clipboard, 0).show();
                this$0.H0();
            } else if (Intrinsics.areEqual(str, this$0.getString(R.string.delete))) {
                ActionBlock actionBlock12 = this$0.f5511h;
                if (actionBlock12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
                    actionBlock12 = null;
                }
                List<RemovedItem> removedItems = actionBlock12.removeItem(item);
                Intrinsics.checkNotNullExpressionValue(removedItems, "removedItems");
                this$0.showDeleteUndo(removedItems);
                this$0.f5515l = null;
                this$0.f5513j = true;
                refresh$default(this$0, false, 1, null);
            } else if (Intrinsics.areEqual(str, this$0.getString(R.string.delete_condition_or_loop_including_children))) {
                this$0.R((ParentAction) item);
            } else if (Intrinsics.areEqual(str, this$0.getString(R.string.add_else_if_clause))) {
                ArrayList<Action> actions = macro.getActions();
                Intrinsics.checkNotNullExpressionValue(actions, "macro.actions");
                indexOf3 = CollectionsKt___CollectionsKt.indexOf((List<? extends SelectableItem>) ((List<? extends Object>) actions), item);
                int endIfIndex = MacroListUtils.getEndIfIndex(macro.getActions(), indexOf3);
                int elseIndex = MacroListUtils.getElseIndex(macro.getActions(), indexOf3);
                ElseIfConditionAction elseIfConditionAction = new ElseIfConditionAction();
                this$0.f5523t = elseIfConditionAction;
                this$0.f5515l = elseIfConditionAction;
                if (elseIndex != -1) {
                    endIfIndex = elseIndex;
                }
                macro.addActionAtIndex(elseIfConditionAction, endIfIndex);
                ActionBlock actionBlock13 = this$0.f5511h;
                if (actionBlock13 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
                    actionBlock13 = null;
                }
                elseIfConditionAction.setMacro(actionBlock13);
                elseIfConditionAction.setActivity(this$0);
                elseIfConditionAction.onItemSelected();
                this$0.f5513j = true;
                refresh$default(this$0, false, 1, null);
            } else if (Intrinsics.areEqual(str, this$0.getString(R.string.add_else_if_confirmed_clause))) {
                ArrayList<Action> actions2 = macro.getActions();
                Intrinsics.checkNotNullExpressionValue(actions2, "macro.actions");
                indexOf2 = CollectionsKt___CollectionsKt.indexOf((List<? extends SelectableItem>) ((List<? extends Object>) actions2), item);
                int endIfIndex2 = MacroListUtils.getEndIfIndex(macro.getActions(), indexOf2);
                int elseIndex2 = MacroListUtils.getElseIndex(macro.getActions(), indexOf2);
                ElseIfConfirmedThenAction elseIfConfirmedThenAction = new ElseIfConfirmedThenAction();
                this$0.f5523t = elseIfConfirmedThenAction;
                this$0.f5515l = elseIfConfirmedThenAction;
                if (elseIndex2 != -1) {
                    endIfIndex2 = elseIndex2;
                }
                macro.addActionAtIndex(elseIfConfirmedThenAction, endIfIndex2);
                ActionBlock actionBlock14 = this$0.f5511h;
                if (actionBlock14 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
                    actionBlock14 = null;
                }
                elseIfConfirmedThenAction.setMacro(actionBlock14);
                elseIfConfirmedThenAction.setActivity(this$0);
                elseIfConfirmedThenAction.onItemSelected();
                this$0.f5513j = true;
                refresh$default(this$0, false, 1, null);
            } else if (Intrinsics.areEqual(str, this$0.getString(R.string.add_else_clause))) {
                ArrayList<Action> actions3 = macro.getActions();
                Intrinsics.checkNotNullExpressionValue(actions3, "macro.actions");
                indexOf = CollectionsKt___CollectionsKt.indexOf((List<? extends SelectableItem>) ((List<? extends Object>) actions3), item);
                macro.addActionAtIndex(new ElseAction(), MacroListUtils.getEndIfIndex(macro.getActions(), indexOf));
                this$0.f5513j = true;
                refresh$default(this$0, false, 1, null);
            } else if (Intrinsics.areEqual(str, this$0.getString(R.string.enable))) {
                this$0.f5513j = true;
                item.setEnabled(true);
                macro.enableOrDisableItem(item, true);
                refresh$default(this$0, false, 1, null);
            } else if (Intrinsics.areEqual(str, this$0.getString(R.string.enable_condition_or_loop_action_including_children))) {
                this$0.f5513j = true;
                macro.enableOrDisableItemAndChildren((Action) item, true);
                refresh$default(this$0, false, 1, null);
            } else if (Intrinsics.areEqual(str, this$0.getString(R.string.disable))) {
                this$0.f5513j = true;
                macro.enableOrDisableItem(item, false);
                refresh$default(this$0, false, 1, null);
            } else if (Intrinsics.areEqual(str, this$0.getString(R.string.disable_condition_or_loop_action_including_children))) {
                this$0.f5513j = true;
                macro.enableOrDisableItemAndChildren((Action) item, false);
                refresh$default(this$0, false, 1, null);
            } else if (Intrinsics.areEqual(str, this$0.getString(R.string.add_comment)) || Intrinsics.areEqual(str, this$0.getString(R.string.edit_comment))) {
                TopLevelEditHelper topLevelEditHelper7 = this$0.f5524u;
                if (topLevelEditHelper7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("topLevelEditHelper");
                } else {
                    topLevelEditHelper = topLevelEditHelper7;
                }
                topLevelEditHelper.displayCommentDialog(item, str, Intrinsics.areEqual(str, this$0.getString(R.string.add_comment)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D0(final MacroDroidVariable macroDroidVariable) {
        VariableHelper variableHelper = VariableHelper.INSTANCE;
        ActionBlock actionBlock = this.f5511h;
        if (actionBlock == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
            actionBlock = null;
        }
        variableHelper.showLocalVarsDialog(this, macroDroidVariable, actionBlock, R.style.Theme_App_Dialog_LocalVariables_ActionBlock_NoTitle, R.style.Theme_App_Dialog_LocalVariables_ActionBlock, new DictionaryEventListener() { // from class: com.arlosoft.macrodroid.actionblock.edit.ActionBlockEditActivity$showLocalVarsDialog$1
            @Override // com.arlosoft.macrodroid.variables.DictionaryEventListener
            public void dictionaryDeleted() {
                ActionBlock actionBlock2 = ActionBlockEditActivity.this.f5511h;
                if (actionBlock2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
                    actionBlock2 = null;
                }
                actionBlock2.getLocalVariables().remove(macroDroidVariable);
                ActionBlockEditActivity.this.f5513j = true;
                ActionBlockEditActivity.this.G0();
                ActionBlockEditActivity.this.refresh(true);
            }

            @Override // com.arlosoft.macrodroid.variables.DictionaryEventListener
            public void entriesCleared() {
                ActionBlockEditActivity.this.f5513j = true;
                ActionBlockEditActivity.refresh$default(ActionBlockEditActivity.this, false, 1, null);
                ActionBlockEditActivity.this.G0();
            }

            @Override // com.arlosoft.macrodroid.variables.DictionaryEventListener
            public void entryRemoved(@NotNull VariableValue.DictionaryEntry removedEntry) {
                Intrinsics.checkNotNullParameter(removedEntry, "removedEntry");
                ActionBlockEditActivity.this.f5513j = true;
                ActionBlockEditActivity.refresh$default(ActionBlockEditActivity.this, false, 1, null);
                ActionBlockEditActivity.this.G0();
            }

            @Override // com.arlosoft.macrodroid.variables.DictionaryEventListener
            public void entryUpdated(@NotNull VariableValue.DictionaryEntry newEntry, @Nullable VariableValue.DictionaryEntry dictionaryEntry) {
                Intrinsics.checkNotNullParameter(newEntry, "newEntry");
                ActionBlockEditActivity.this.f5513j = true;
                ActionBlockEditActivity.refresh$default(ActionBlockEditActivity.this, false, 1, null);
                ActionBlockEditActivity.this.G0();
            }

            @Override // com.arlosoft.macrodroid.variables.DictionaryEventListener
            public void refreshRequired() {
                ActionBlockEditActivity.this.f5513j = true;
                ActionBlockEditActivity.refresh$default(ActionBlockEditActivity.this, false, 1, null);
                ActionBlockEditActivity.this.G0();
            }
        });
    }

    private final String E0(String str) {
        String replace$default;
        replace$default = kotlin.text.m.replace$default(str, ' ', '_', false, 4, (Object) null);
        return new Regex("[\\\\/:*?\"<>|]").replace(replace$default, "-");
    }

    private final void F0() {
        try {
            ActionBlock actionBlock = this.f5511h;
            if (actionBlock == null) {
                Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
                actionBlock = null;
            }
            String str = "Testing Action Block: " + actionBlock.getName();
            ActionBlock actionBlock2 = this.f5511h;
            if (actionBlock2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
                actionBlock2 = null;
            }
            SystemLog.logInfo(str, actionBlock2.getGUID());
            TriggerContextInfo triggerContextInfo = new TriggerContextInfo(new EmptyTrigger());
            ActionBlock actionBlock3 = this.f5511h;
            if (actionBlock3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
                actionBlock3 = null;
            }
            ActionBlock cloneActionBlock$default = ActionBlock.cloneActionBlock$default(actionBlock3, false, false, 2, null);
            cloneActionBlock$default.setIsClonedInstance(true);
            cloneActionBlock$default.setTestMode(true);
            cloneActionBlock$default.setTriggerThatInvoked(null);
            getActionBlockStore().addActionBlock(cloneActionBlock$default);
            cloneActionBlock$default.invokeActions(triggerContextInfo, true, null);
        } catch (Exception e4) {
            SystemLog.logError("Error when testing action block: " + e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G0() {
        boolean z3;
        ActionBlock actionBlock = this.f5511h;
        ActivityActionBlockEditBinding activityActionBlockEditBinding = null;
        if (actionBlock == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
            actionBlock = null;
        }
        if (!actionBlock.isCompleted()) {
            ActionBlock actionBlock2 = this.f5511h;
            if (actionBlock2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
                actionBlock2 = null;
            }
            if (actionBlock2.isValid()) {
                ActivityActionBlockEditBinding activityActionBlockEditBinding2 = this.f5509f;
                if (activityActionBlockEditBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityActionBlockEditBinding2 = null;
                }
                Editable text = activityActionBlockEditBinding2.actionBlockNameText.getText();
                boolean z4 = false;
                if (text != null) {
                    if (text.length() > 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (!z3) {
                        z4 = true;
                    }
                }
                if (!z4) {
                    ActivityActionBlockEditBinding activityActionBlockEditBinding3 = this.f5509f;
                    if (activityActionBlockEditBinding3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        activityActionBlockEditBinding = activityActionBlockEditBinding3;
                    }
                    activityActionBlockEditBinding.acceptButton.show();
                    return;
                }
            }
            if (!this.f5516m) {
                ActivityActionBlockEditBinding activityActionBlockEditBinding4 = this.f5509f;
                if (activityActionBlockEditBinding4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    activityActionBlockEditBinding = activityActionBlockEditBinding4;
                }
                activityActionBlockEditBinding.acceptButton.show();
            }
        } else if (!this.f5513j) {
            ActivityActionBlockEditBinding activityActionBlockEditBinding5 = this.f5509f;
            if (activityActionBlockEditBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityActionBlockEditBinding5 = null;
            }
            if (activityActionBlockEditBinding5.acceptButton.isShown()) {
                ActivityActionBlockEditBinding activityActionBlockEditBinding6 = this.f5509f;
                if (activityActionBlockEditBinding6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityActionBlockEditBinding6 = null;
                }
                activityActionBlockEditBinding6.acceptButton.hide();
                ActivityActionBlockEditBinding activityActionBlockEditBinding7 = this.f5509f;
                if (activityActionBlockEditBinding7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    activityActionBlockEditBinding = activityActionBlockEditBinding7;
                }
                FloatingActionButton floatingActionButton = activityActionBlockEditBinding.acceptButton;
                Intrinsics.checkNotNullExpressionValue(floatingActionButton, "binding.acceptButton");
                floatingActionButton.setVisibility(8);
            }
        } else {
            ActivityActionBlockEditBinding activityActionBlockEditBinding8 = this.f5509f;
            if (activityActionBlockEditBinding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityActionBlockEditBinding8 = null;
            }
            if (!activityActionBlockEditBinding8.acceptButton.isShown()) {
                ActivityActionBlockEditBinding activityActionBlockEditBinding9 = this.f5509f;
                if (activityActionBlockEditBinding9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    activityActionBlockEditBinding = activityActionBlockEditBinding9;
                }
                activityActionBlockEditBinding.acceptButton.show();
            }
        }
    }

    private final void H(ActionBlock actionBlock) {
        Iterator<Action> it = actionBlock.getActions().iterator();
        while (it.hasNext()) {
            Action next = it.next();
            next.applyImport();
            for (Constraint constraint : next.getConstraints()) {
                constraint.applyImport();
            }
        }
    }

    private final void H0() {
        boolean z3;
        SelectableItem copyItem = CopyHelper.copyItem();
        ActivityActionBlockEditBinding activityActionBlockEditBinding = this.f5509f;
        ActivityActionBlockEditBinding activityActionBlockEditBinding2 = null;
        if (activityActionBlockEditBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityActionBlockEditBinding = null;
        }
        ImageButton imageButton = activityActionBlockEditBinding.pasteActionButton;
        Intrinsics.checkNotNullExpressionValue(imageButton, "binding.pasteActionButton");
        int i4 = 8;
        imageButton.setVisibility(8);
        if (copyItem != null && (copyItem instanceof Action) && !(copyItem instanceof WaitUntilTriggerAction)) {
            ActivityActionBlockEditBinding activityActionBlockEditBinding3 = this.f5509f;
            if (activityActionBlockEditBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityActionBlockEditBinding2 = activityActionBlockEditBinding3;
            }
            ImageButton imageButton2 = activityActionBlockEditBinding2.pasteActionButton;
            Intrinsics.checkNotNullExpressionValue(imageButton2, "binding.pasteActionButton");
            imageButton2.setVisibility(0);
        } else if (CopyHelper.copyItemList() != null) {
            ActivityActionBlockEditBinding activityActionBlockEditBinding4 = this.f5509f;
            if (activityActionBlockEditBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityActionBlockEditBinding2 = activityActionBlockEditBinding4;
            }
            ImageButton imageButton3 = activityActionBlockEditBinding2.pasteActionButton;
            Intrinsics.checkNotNullExpressionValue(imageButton3, "binding.pasteActionButton");
            List<SelectableItem> copyItemList = CopyHelper.copyItemList();
            Intrinsics.checkNotNullExpressionValue(copyItemList, "copyItemList()");
            List<SelectableItem> list = copyItemList;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                for (SelectableItem selectableItem : list) {
                    if (selectableItem instanceof WaitUntilTriggerAction) {
                        z3 = true;
                        break;
                    }
                }
            }
            z3 = false;
            if (!z3) {
                i4 = 0;
            }
            imageButton3.setVisibility(i4);
        }
    }

    private final void I(boolean z3) {
        HashSet hashSet = new HashSet();
        ActionBlock actionBlock = this.f5511h;
        if (actionBlock == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
            actionBlock = null;
        }
        Iterator<Action> it = actionBlock.getActions().iterator();
        while (it.hasNext()) {
            Action next = it.next();
            String[] requiredPermissions = next.getRequiredPermissions();
            hashSet.addAll(Arrays.asList(Arrays.copyOf(requiredPermissions, requiredPermissions.length)));
            if (!next.hasAllSpecialPermissions(this)) {
                return;
            }
        }
        if (Build.VERSION.SDK_INT >= 23 && hashSet.size() != 0) {
            String[] strArr = (String[]) hashSet.toArray(new String[0]);
            Observable<Boolean> observeOn = new RxPermissions(this).request((String[]) Arrays.copyOf(strArr, strArr.length)).observeOn(AndroidSchedulers.mainThread());
            final a aVar = new a(z3);
            observeOn.subscribe(new Consumer() { // from class: com.arlosoft.macrodroid.actionblock.edit.o
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    ActionBlockEditActivity.K(Function1.this, obj);
                }
            });
            return;
        }
        N(z3);
    }

    private final boolean I0() {
        ActionBlock actionBlock = this.f5511h;
        ActivityActionBlockEditBinding activityActionBlockEditBinding = null;
        ActionBlock actionBlock2 = null;
        if (actionBlock == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
            actionBlock = null;
        }
        int checkActionsFlowControl = Action.checkActionsFlowControl(actionBlock.getActions());
        if (checkActionsFlowControl >= 0) {
            String string = getString(R.string.invalid_control_flow);
            ActionBlock actionBlock3 = this.f5511h;
            if (actionBlock3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
            } else {
                actionBlock2 = actionBlock3;
            }
            Util.displayErrorDialog(this, getString(R.string.invalid_action_block), string + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + actionBlock2.getActions().get(checkActionsFlowControl).getConfiguredName());
            return false;
        }
        ActivityActionBlockEditBinding activityActionBlockEditBinding2 = this.f5509f;
        if (activityActionBlockEditBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityActionBlockEditBinding2 = null;
        }
        if (TextUtils.isEmpty(activityActionBlockEditBinding2.actionBlockNameText.getText().toString())) {
            Util.displayErrorDialog(this, getString(R.string.invalid_action_block), getString(R.string.please_set_a_name), R.style.Theme_App_Dialog);
            return false;
        }
        ActionBlock actionBlock4 = this.f5511h;
        if (actionBlock4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
            actionBlock4 = null;
        }
        if (actionBlock4.getActions().size() == 0) {
            Util.displayErrorDialog(this, getString(R.string.invalid_action_block), getString(R.string.please_add_an_action), R.style.Theme_App_Dialog);
            return false;
        }
        ActionBlock actionBlock5 = this.f5511h;
        if (actionBlock5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
            actionBlock5 = null;
        }
        if (!actionBlock5.isValid()) {
            Util.displayErrorDialog(this, getString(R.string.invalid_action_block), getString(R.string.ensure_valid_action_block), R.style.Theme_App_Dialog);
            return false;
        }
        ActivityActionBlockEditBinding activityActionBlockEditBinding3 = this.f5509f;
        if (activityActionBlockEditBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityActionBlockEditBinding = activityActionBlockEditBinding3;
        }
        if (W(activityActionBlockEditBinding.actionBlockNameText.getText().toString())) {
            Util.displayErrorDialog(this, getString(R.string.invalid_action_block), getString(R.string.action_block_name_already_exists), R.style.Theme_App_Dialog);
            return false;
        }
        return true;
    }

    static /* synthetic */ void J(ActionBlockEditActivity actionBlockEditActivity, boolean z3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            z3 = true;
        }
        actionBlockEditActivity.I(z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L() {
        ActionBlock actionBlock = this.f5511h;
        ActionBlock actionBlock2 = null;
        if (actionBlock == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
            actionBlock = null;
        }
        Iterator<Trigger> it = actionBlock.getTriggerList().iterator();
        while (it.hasNext()) {
            it.next().clearHasEdited();
        }
        ActionBlock actionBlock3 = this.f5511h;
        if (actionBlock3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
            actionBlock3 = null;
        }
        Iterator<Action> it2 = actionBlock3.getActions().iterator();
        while (it2.hasNext()) {
            it2.next().clearHasEdited();
        }
        ActionBlock actionBlock4 = this.f5511h;
        if (actionBlock4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
        } else {
            actionBlock2 = actionBlock4;
        }
        for (Constraint constraint : actionBlock2.getConstraints()) {
            constraint.clearHasEdited();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M(boolean z3) {
        if (this.f5513j && z3 && !this.f5521r) {
            AdvertActivity.Companion.setShowAdvertOnNextResume(null);
        }
        if (this.f5521r && this.f5514k) {
            Intent intent = ActionBlockListActivity.Companion.getIntent(this, false);
            intent.addFlags(131072);
            startActivity(intent);
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N(boolean z3) {
        ActionBlockEditViewModel viewModel = getViewModel();
        ActionBlock actionBlock = this.f5511h;
        ActivityActionBlockEditBinding activityActionBlockEditBinding = null;
        if (actionBlock == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
            actionBlock = null;
        }
        ActivityActionBlockEditBinding activityActionBlockEditBinding2 = this.f5509f;
        if (activityActionBlockEditBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityActionBlockEditBinding2 = null;
        }
        String obj = activityActionBlockEditBinding2.actionBlockNameText.getText().toString();
        ActivityActionBlockEditBinding activityActionBlockEditBinding3 = this.f5509f;
        if (activityActionBlockEditBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityActionBlockEditBinding3 = null;
        }
        String valueOf = String.valueOf(activityActionBlockEditBinding3.description.getText());
        ActivityActionBlockEditBinding activityActionBlockEditBinding4 = this.f5509f;
        if (activityActionBlockEditBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityActionBlockEditBinding = activityActionBlockEditBinding4;
        }
        viewModel.saveActionBlock(actionBlock, obj, valueOf, activityActionBlockEditBinding.descriptionExpandable.isExpanded(), z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O() {
        ActivityActionBlockEditBinding activityActionBlockEditBinding = this.f5509f;
        if (activityActionBlockEditBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityActionBlockEditBinding = null;
        }
        String obj = activityActionBlockEditBinding.actionBlockNameText.getText().toString();
        ActionBlock actionBlock = this.f5511h;
        if (actionBlock == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
            actionBlock = null;
        }
        if (!Intrinsics.areEqual(obj, actionBlock.getName())) {
            ActivityActionBlockEditBinding activityActionBlockEditBinding2 = this.f5509f;
            if (activityActionBlockEditBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityActionBlockEditBinding2 = null;
            }
            EditText editText = activityActionBlockEditBinding2.actionBlockNameText;
            ActionBlock actionBlock2 = this.f5511h;
            if (actionBlock2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
                actionBlock2 = null;
            }
            editText.setText(actionBlock2.getName());
        }
        ActivityActionBlockEditBinding activityActionBlockEditBinding3 = this.f5509f;
        if (activityActionBlockEditBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityActionBlockEditBinding3 = null;
        }
        String valueOf = String.valueOf(activityActionBlockEditBinding3.description.getText());
        ActionBlock actionBlock3 = this.f5511h;
        if (actionBlock3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
            actionBlock3 = null;
        }
        if (!Intrinsics.areEqual(valueOf, actionBlock3.getDescription())) {
            ActivityActionBlockEditBinding activityActionBlockEditBinding4 = this.f5509f;
            if (activityActionBlockEditBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityActionBlockEditBinding4 = null;
            }
            AppCompatEditText appCompatEditText = activityActionBlockEditBinding4.description;
            ActionBlock actionBlock4 = this.f5511h;
            if (actionBlock4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
                actionBlock4 = null;
            }
            appCompatEditText.setText(actionBlock4.getDescription());
        }
        ActionBlock actionBlock5 = this.f5511h;
        if (actionBlock5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
            actionBlock5 = null;
        }
        if (actionBlock5.isDescriptionOpen()) {
            ActivityActionBlockEditBinding activityActionBlockEditBinding5 = this.f5509f;
            if (activityActionBlockEditBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityActionBlockEditBinding5 = null;
            }
            activityActionBlockEditBinding5.descriptionExpandable.expand(false);
        } else {
            ActivityActionBlockEditBinding activityActionBlockEditBinding6 = this.f5509f;
            if (activityActionBlockEditBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityActionBlockEditBinding6 = null;
            }
            activityActionBlockEditBinding6.descriptionExpandable.collapse(false);
        }
        ActivityActionBlockEditBinding activityActionBlockEditBinding7 = this.f5509f;
        if (activityActionBlockEditBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityActionBlockEditBinding7 = null;
        }
        activityActionBlockEditBinding7.actionsList.addItemDecoration(new SimpleDividerItemDecoration(getApplicationContext(), R.drawable.line_divider_edit_macro));
        ActivityActionBlockEditBinding activityActionBlockEditBinding8 = this.f5509f;
        if (activityActionBlockEditBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityActionBlockEditBinding8 = null;
        }
        EditText editText2 = activityActionBlockEditBinding8.actionBlockNameText;
        Intrinsics.checkNotNullExpressionValue(editText2, "binding.actionBlockNameText");
        ViewExtensionsKt.afterTextChanged(editText2, new c());
        ActivityActionBlockEditBinding activityActionBlockEditBinding9 = this.f5509f;
        if (activityActionBlockEditBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityActionBlockEditBinding9 = null;
        }
        AppCompatEditText appCompatEditText2 = activityActionBlockEditBinding9.description;
        Intrinsics.checkNotNullExpressionValue(appCompatEditText2, "binding.description");
        ViewExtensionsKt.afterTextChanged(appCompatEditText2, new d());
        ActivityActionBlockEditBinding activityActionBlockEditBinding10 = this.f5509f;
        if (activityActionBlockEditBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityActionBlockEditBinding10 = null;
        }
        ImageButton imageButton = activityActionBlockEditBinding10.addActionButton;
        Intrinsics.checkNotNullExpressionValue(imageButton, "binding.addActionButton");
        ViewExtensionsKt.onClick$default(imageButton, null, new e(null), 1, null);
        w0();
        ActivityActionBlockEditBinding activityActionBlockEditBinding11 = this.f5509f;
        if (activityActionBlockEditBinding11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityActionBlockEditBinding11 = null;
        }
        ImageButton imageButton2 = activityActionBlockEditBinding11.addInputVariableButton;
        Intrinsics.checkNotNullExpressionValue(imageButton2, "binding.addInputVariableButton");
        ViewExtensionsKt.onClick$default(imageButton2, null, new f(null), 1, null);
        ActivityActionBlockEditBinding activityActionBlockEditBinding12 = this.f5509f;
        if (activityActionBlockEditBinding12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityActionBlockEditBinding12 = null;
        }
        ImageButton imageButton3 = activityActionBlockEditBinding12.addOutputVariableButton;
        Intrinsics.checkNotNullExpressionValue(imageButton3, "binding.addOutputVariableButton");
        ViewExtensionsKt.onClick$default(imageButton3, null, new g(null), 1, null);
        ActivityActionBlockEditBinding activityActionBlockEditBinding13 = this.f5509f;
        if (activityActionBlockEditBinding13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityActionBlockEditBinding13 = null;
        }
        ImageButton imageButton4 = activityActionBlockEditBinding13.addLocalVariableButton;
        Intrinsics.checkNotNullExpressionValue(imageButton4, "binding.addLocalVariableButton");
        ViewExtensionsKt.onClick$default(imageButton4, null, new h(null), 1, null);
        ActivityActionBlockEditBinding activityActionBlockEditBinding14 = this.f5509f;
        if (activityActionBlockEditBinding14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityActionBlockEditBinding14 = null;
        }
        ImageButton imageButton5 = activityActionBlockEditBinding14.pasteActionButton;
        Intrinsics.checkNotNullExpressionValue(imageButton5, "binding.pasteActionButton");
        ViewExtensionsKt.onClick$default(imageButton5, null, new i(null), 1, null);
        ActivityActionBlockEditBinding activityActionBlockEditBinding15 = this.f5509f;
        if (activityActionBlockEditBinding15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityActionBlockEditBinding15 = null;
        }
        FrameLayout frameLayout = activityActionBlockEditBinding15.inputVarsContent;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.inputVarsContent");
        ActionBlock actionBlock6 = this.f5511h;
        if (actionBlock6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
            actionBlock6 = null;
        }
        frameLayout.setVisibility(actionBlock6.isInputExpanded() ? 0 : 8);
        ActivityActionBlockEditBinding activityActionBlockEditBinding16 = this.f5509f;
        if (activityActionBlockEditBinding16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityActionBlockEditBinding16 = null;
        }
        FrameLayout frameLayout2 = activityActionBlockEditBinding16.outputVarsContent;
        Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.outputVarsContent");
        ActionBlock actionBlock7 = this.f5511h;
        if (actionBlock7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
            actionBlock7 = null;
        }
        frameLayout2.setVisibility(actionBlock7.isOutputExpanded() ? 0 : 8);
        ActivityActionBlockEditBinding activityActionBlockEditBinding17 = this.f5509f;
        if (activityActionBlockEditBinding17 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityActionBlockEditBinding17 = null;
        }
        FrameLayout frameLayout3 = activityActionBlockEditBinding17.localVarsContent;
        Intrinsics.checkNotNullExpressionValue(frameLayout3, "binding.localVarsContent");
        ActionBlock actionBlock8 = this.f5511h;
        if (actionBlock8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
            actionBlock8 = null;
        }
        frameLayout3.setVisibility(actionBlock8.isLocalExpanded() ? 0 : 8);
        ActivityActionBlockEditBinding activityActionBlockEditBinding18 = this.f5509f;
        if (activityActionBlockEditBinding18 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityActionBlockEditBinding18 = null;
        }
        ImageButton imageButton6 = activityActionBlockEditBinding18.inputCollapseExpandButton;
        ActionBlock actionBlock9 = this.f5511h;
        if (actionBlock9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
            actionBlock9 = null;
        }
        imageButton6.setRotation(actionBlock9.isInputExpanded() ? 180.0f : 0.0f);
        ActivityActionBlockEditBinding activityActionBlockEditBinding19 = this.f5509f;
        if (activityActionBlockEditBinding19 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityActionBlockEditBinding19 = null;
        }
        ImageButton imageButton7 = activityActionBlockEditBinding19.outputCollapseExpandButton;
        ActionBlock actionBlock10 = this.f5511h;
        if (actionBlock10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
            actionBlock10 = null;
        }
        imageButton7.setRotation(actionBlock10.isOutputExpanded() ? 180.0f : 0.0f);
        ActivityActionBlockEditBinding activityActionBlockEditBinding20 = this.f5509f;
        if (activityActionBlockEditBinding20 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityActionBlockEditBinding20 = null;
        }
        ImageButton imageButton8 = activityActionBlockEditBinding20.localCollapseExpandButton;
        ActionBlock actionBlock11 = this.f5511h;
        if (actionBlock11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
            actionBlock11 = null;
        }
        imageButton8.setRotation(actionBlock11.isLocalExpanded() ? 180.0f : 0.0f);
        ActivityActionBlockEditBinding activityActionBlockEditBinding21 = this.f5509f;
        if (activityActionBlockEditBinding21 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityActionBlockEditBinding21 = null;
        }
        ImageButton imageButton9 = activityActionBlockEditBinding21.inputCollapseExpandButton;
        Intrinsics.checkNotNullExpressionValue(imageButton9, "binding.inputCollapseExpandButton");
        ViewExtensionsKt.onClick$default(imageButton9, null, new j(null), 1, null);
        ActivityActionBlockEditBinding activityActionBlockEditBinding22 = this.f5509f;
        if (activityActionBlockEditBinding22 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityActionBlockEditBinding22 = null;
        }
        ImageButton imageButton10 = activityActionBlockEditBinding22.outputCollapseExpandButton;
        Intrinsics.checkNotNullExpressionValue(imageButton10, "binding.outputCollapseExpandButton");
        ViewExtensionsKt.onClick$default(imageButton10, null, new k(null), 1, null);
        ActivityActionBlockEditBinding activityActionBlockEditBinding23 = this.f5509f;
        if (activityActionBlockEditBinding23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityActionBlockEditBinding23 = null;
        }
        ImageButton imageButton11 = activityActionBlockEditBinding23.localCollapseExpandButton;
        Intrinsics.checkNotNullExpressionValue(imageButton11, "binding.localCollapseExpandButton");
        ViewExtensionsKt.onClick$default(imageButton11, null, new b(null), 1, null);
        ActivityActionBlockEditBinding activityActionBlockEditBinding24 = this.f5509f;
        if (activityActionBlockEditBinding24 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityActionBlockEditBinding24 = null;
        }
        activityActionBlockEditBinding24.acceptButton.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.actionblock.edit.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ActionBlockEditActivity.P(ActionBlockEditActivity.this, view);
            }
        });
        SelectableItemsListAdapter<Action> selectableItemsListAdapter = this.f5510g;
        if (selectableItemsListAdapter != null) {
            selectableItemsListAdapter.setDragEnabled(false);
        }
        refresh$default(this, false, 1, null);
        H0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(ActionBlockEditActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.b0()) {
            J(this$0, false, 1, null);
        }
    }

    private final void Q() {
        getViewModel().getActionBlock().observe(this, new Observer<ActionBlock>() { // from class: com.arlosoft.macrodroid.actionblock.edit.ActionBlockEditActivity$configureViewModelObservers$1
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public final void onChanged(ActionBlock it) {
                boolean z3;
                VariableUpdatedListener variableUpdatedListener;
                boolean z4;
                ActionBlock actionBlock;
                ActionBlockEditActivity actionBlockEditActivity = ActionBlockEditActivity.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                actionBlockEditActivity.f5511h = it;
                z3 = ActionBlockEditActivity.this.f5516m;
                ActivityActionBlockEditBinding activityActionBlockEditBinding = null;
                if (!z3) {
                    actionBlock = ActionBlockEditActivity.this.f5525v;
                    if (actionBlock == null) {
                        ActionBlockEditActivity actionBlockEditActivity2 = ActionBlockEditActivity.this;
                        ActionBlock actionBlock2 = actionBlockEditActivity2.f5511h;
                        if (actionBlock2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
                            actionBlock2 = null;
                        }
                        actionBlockEditActivity2.f5525v = actionBlock2.exactClone();
                    }
                }
                ActionBlock actionBlock3 = ActionBlockEditActivity.this.f5511h;
                if (actionBlock3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
                    actionBlock3 = null;
                }
                variableUpdatedListener = ActionBlockEditActivity.this.f5526w;
                actionBlock3.addLocalVariableUpdatedListener(variableUpdatedListener);
                z4 = ActionBlockEditActivity.this.f5520q;
                if (!z4) {
                    ActionBlockEditActivity.this.L();
                    ActivityActionBlockEditBinding activityActionBlockEditBinding2 = ActionBlockEditActivity.this.f5509f;
                    if (activityActionBlockEditBinding2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        activityActionBlockEditBinding2 = null;
                    }
                    LinearLayout linearLayout = activityActionBlockEditBinding2.topLevelLayout;
                    Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.topLevelLayout");
                    linearLayout.setVisibility(0);
                    ActivityActionBlockEditBinding activityActionBlockEditBinding3 = ActionBlockEditActivity.this.f5509f;
                    if (activityActionBlockEditBinding3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        activityActionBlockEditBinding = activityActionBlockEditBinding3;
                    }
                    LinearLayout linearLayout2 = activityActionBlockEditBinding.topLevelLayout;
                    Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.topLevelLayout");
                    final ActionBlockEditActivity actionBlockEditActivity3 = ActionBlockEditActivity.this;
                    if (ViewCompat.isLaidOut(linearLayout2) && !linearLayout2.isLayoutRequested()) {
                        actionBlockEditActivity3.y0(true);
                    } else {
                        linearLayout2.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.arlosoft.macrodroid.actionblock.edit.ActionBlockEditActivity$configureViewModelObservers$1$onChanged$$inlined$doOnLayout$1
                            @Override // android.view.View.OnLayoutChangeListener
                            public void onLayoutChange(@NotNull View view, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
                                Intrinsics.checkNotNullParameter(view, "view");
                                view.removeOnLayoutChangeListener(this);
                                ActionBlockEditActivity.this.y0(true);
                            }
                        });
                    }
                    ActionBlockEditActivity.this.f5520q = true;
                }
                ActionBlockEditActivity.this.O();
            }
        });
        getViewModel().getCloseScreenEvent().observe(this, new a0(new l()));
        getViewModel().getCloseScreenAndShowActionBlockEvent().observe(this, new a0(new m()));
    }

    private final void R(final ParentAction parentAction) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.Theme_App_Dialog_Action);
        builder.setTitle(R.string.delete);
        builder.setMessage(getString(R.string.delete_condition_or_loop_including_children_confirm));
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.actionblock.edit.k
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                ActionBlockEditActivity.S(ActionBlockEditActivity.this, parentAction, dialogInterface, i4);
            }
        });
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.actionblock.edit.m
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                ActionBlockEditActivity.T(dialogInterface, i4);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(ActionBlockEditActivity this$0, ParentAction action, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(action, "$action");
        ActionBlock actionBlock = this$0.f5511h;
        if (actionBlock == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
            actionBlock = null;
        }
        List<RemovedItem> removedItems = actionBlock.removeItemAndChildren(action);
        this$0.f5515l = null;
        this$0.z0(true);
        Intrinsics.checkNotNullExpressionValue(removedItems, "removedItems");
        this$0.showDeleteUndo(removedItems);
        refresh$default(this$0, false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T(DialogInterface dialogInterface, int i4) {
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U(final VariableType variableType) {
        VariableHelper.createNewVariable(this, getPremiumStatusHandler().getPremiumStatus().isPro(), true, R.style.Theme_App_Dialog_LocalVariables_ActionBlock, false, false, R.layout.simple_spinner_dropdown_item_2_lines_white_text, "#DDDDDD", false, null, null, new VariableHelper.NewVariableCreationListener() { // from class: com.arlosoft.macrodroid.actionblock.edit.ActionBlockEditActivity$createNewVariable$1
            @Override // com.arlosoft.macrodroid.variables.VariableHelper.NewVariableCreationListener
            public void newVariableCreated(@NotNull MacroDroidVariable variable, boolean z3) {
                boolean z4;
                Intrinsics.checkNotNullParameter(variable, "variable");
                boolean z5 = false;
                if (VariableType.this == VariableType.INPUT) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                variable.setIsInput(z4);
                if (VariableType.this == VariableType.LOCAL_WORKING_VAR) {
                    z5 = true;
                }
                variable.setIsActionBlockWorkingVar(z5);
                ActionBlock actionBlock = this.f5511h;
                if (actionBlock == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
                    actionBlock = null;
                }
                actionBlock.getLocalVariables().add(variable);
                this.f5513j = true;
                this.w0();
                this.G0();
            }

            @Override // com.arlosoft.macrodroid.variables.VariableHelper.NewVariableCreationListener
            public boolean validateVariableName(@NotNull String variableName) {
                Intrinsics.checkNotNullParameter(variableName, "variableName");
                ActionBlock actionBlock = this.f5511h;
                if (actionBlock == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
                    actionBlock = null;
                }
                if (actionBlock.findLocalVariableByName(variableName) == null) {
                    return true;
                }
                return false;
            }
        });
    }

    private final void V() {
        setResult(0, new Intent());
        MacroStore macroStore = MacroStore.getInstance();
        ActionBlock actionBlock = this.f5511h;
        if (actionBlock == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
            actionBlock = null;
        }
        macroStore.removeMacro(actionBlock, false);
        ActionBlock actionBlock2 = this.f5525v;
        if (actionBlock2 != null) {
            MacroStore.getInstance().addMacro(actionBlock2, true, actionBlock2.isEnabled());
        }
        X();
        getActionBlockStore().clearActionBlocksBeingImported();
        finish();
    }

    private final boolean W(String str) {
        for (ActionBlock actionBlock : getActionBlockStore().getAllActionBlocks()) {
            ActionBlock actionBlock2 = this.f5511h;
            if (actionBlock2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
                actionBlock2 = null;
            }
            if (!Intrinsics.areEqual(actionBlock, actionBlock2) && Intrinsics.areEqual(actionBlock.getName(), str)) {
                return true;
            }
        }
        return false;
    }

    private final void X() {
        Object systemService = getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        ActivityActionBlockEditBinding activityActionBlockEditBinding = this.f5509f;
        if (activityActionBlockEditBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityActionBlockEditBinding = null;
        }
        inputMethodManager.hideSoftInputFromWindow(activityActionBlockEditBinding.description.getWindowToken(), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(ActionBlockEditActivity this$0, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        J(this$0, false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(ActionBlockEditActivity this$0, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.V();
    }

    private final void a0() {
        ActionBlock actionBlock = this.f5511h;
        ActivityActionBlockEditBinding activityActionBlockEditBinding = null;
        if (actionBlock == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
            actionBlock = null;
        }
        ActivityActionBlockEditBinding activityActionBlockEditBinding2 = this.f5509f;
        if (activityActionBlockEditBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityActionBlockEditBinding2 = null;
        }
        actionBlock.setDescriptionOpen(!activityActionBlockEditBinding2.descriptionExpandable.isExpanded());
        ActivityActionBlockEditBinding activityActionBlockEditBinding3 = this.f5509f;
        if (activityActionBlockEditBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityActionBlockEditBinding = activityActionBlockEditBinding3;
        }
        activityActionBlockEditBinding.descriptionExpandable.toggle();
    }

    private final boolean b0() {
        ActionBlock actionBlock = this.f5511h;
        ActivityActionBlockEditBinding activityActionBlockEditBinding = null;
        ActionBlock actionBlock2 = null;
        if (actionBlock == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
            actionBlock = null;
        }
        int checkActionsFlowControl = Action.checkActionsFlowControl(actionBlock.getActions());
        if (checkActionsFlowControl >= 0) {
            String string = getString(R.string.invalid_control_flow);
            ActionBlock actionBlock3 = this.f5511h;
            if (actionBlock3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
            } else {
                actionBlock2 = actionBlock3;
            }
            Util.displayErrorDialog(this, getString(R.string.invalid_action_block), string + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + actionBlock2.getActions().get(checkActionsFlowControl).getConfiguredName());
            return false;
        }
        ActivityActionBlockEditBinding activityActionBlockEditBinding2 = this.f5509f;
        if (activityActionBlockEditBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityActionBlockEditBinding2 = null;
        }
        if (TextUtils.isEmpty(activityActionBlockEditBinding2.actionBlockNameText.getText().toString())) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.Theme_App_Dialog);
            builder.setTitle(R.string.invalid_action_block);
            builder.setMessage(R.string.please_set_a_name);
            builder.setPositiveButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.actionblock.edit.u
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i4) {
                    ActionBlockEditActivity.c0(dialogInterface, i4);
                }
            });
            builder.setNeutralButton(R.string.discard, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.actionblock.edit.b
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i4) {
                    ActionBlockEditActivity.d0(ActionBlockEditActivity.this, dialogInterface, i4);
                }
            });
            builder.show();
            return false;
        }
        ActionBlock actionBlock4 = this.f5511h;
        if (actionBlock4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
            actionBlock4 = null;
        }
        if (actionBlock4.getActions().size() == 0) {
            AlertDialog.Builder builder2 = new AlertDialog.Builder(this, R.style.Theme_App_Dialog);
            builder2.setTitle(R.string.invalid_action_block);
            builder2.setMessage(R.string.please_add_an_action);
            builder2.setPositiveButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.actionblock.edit.c
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i4) {
                    ActionBlockEditActivity.e0(dialogInterface, i4);
                }
            });
            builder2.setNeutralButton(R.string.discard, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.actionblock.edit.d
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i4) {
                    ActionBlockEditActivity.f0(ActionBlockEditActivity.this, dialogInterface, i4);
                }
            });
            builder2.show();
            return false;
        }
        ActionBlock actionBlock5 = this.f5511h;
        if (actionBlock5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
            actionBlock5 = null;
        }
        if (!actionBlock5.isValid()) {
            AlertDialog.Builder builder3 = new AlertDialog.Builder(this, R.style.Theme_App_Dialog);
            builder3.setTitle(R.string.invalid_action_block);
            builder3.setMessage(R.string.ensure_valid_action_block).setCancelable(true).setPositiveButton(R.string.save, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.actionblock.edit.e
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i4) {
                    ActionBlockEditActivity.g0(ActionBlockEditActivity.this, dialogInterface, i4);
                }
            }).setNeutralButton(R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.actionblock.edit.f
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i4) {
                    ActionBlockEditActivity.h0(dialogInterface, i4);
                }
            }).setNegativeButton(R.string.discard, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.actionblock.edit.g
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i4) {
                    ActionBlockEditActivity.i0(ActionBlockEditActivity.this, dialogInterface, i4);
                }
            });
            builder3.show();
            return false;
        }
        ActivityActionBlockEditBinding activityActionBlockEditBinding3 = this.f5509f;
        if (activityActionBlockEditBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityActionBlockEditBinding = activityActionBlockEditBinding3;
        }
        if (!W(activityActionBlockEditBinding.actionBlockNameText.getText().toString())) {
            return true;
        }
        AlertDialog.Builder builder4 = new AlertDialog.Builder(this, R.style.Theme_App_Dialog);
        builder4.setTitle(R.string.invalid_action_block);
        builder4.setMessage(R.string.action_block_name_already_exists);
        builder4.setPositiveButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.actionblock.edit.h
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                ActionBlockEditActivity.j0(dialogInterface, i4);
            }
        });
        builder4.setNeutralButton(R.string.discard, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.actionblock.edit.i
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                ActionBlockEditActivity.k0(ActionBlockEditActivity.this, dialogInterface, i4);
            }
        });
        builder4.show();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0(DialogInterface dialogInterface, int i4) {
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d0(ActionBlockEditActivity this$0, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.V();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0(DialogInterface dialogInterface, int i4) {
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f0(ActionBlockEditActivity this$0, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.V();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g0(ActionBlockEditActivity this$0, DialogInterface dialog, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        J(this$0, false, 1, null);
    }

    @JvmStatic
    @NotNull
    public static final Intent getIntent(@NotNull Activity activity, boolean z3, @NotNull ActionBlock actionBlock, boolean z4) {
        return Companion.getIntent(activity, z3, actionBlock, z4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h0(DialogInterface dialog, int i4) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleBackPressed() {
        if (this.f5516m) {
            ActivityActionBlockEditBinding activityActionBlockEditBinding = this.f5509f;
            ActionBlock actionBlock = null;
            if (activityActionBlockEditBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityActionBlockEditBinding = null;
            }
            if (activityActionBlockEditBinding.actionBlockNameText.length() == 0) {
                ActionBlock actionBlock2 = this.f5511h;
                if (actionBlock2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
                    actionBlock2 = null;
                }
                if (actionBlock2.getActions().size() == 0) {
                    ActionBlock actionBlock3 = this.f5511h;
                    if (actionBlock3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
                        actionBlock3 = null;
                    }
                    if (actionBlock3.getLocalVariables().size() == 0) {
                        ActionBlockEditViewModel viewModel = getViewModel();
                        ActionBlock actionBlock4 = this.f5511h;
                        if (actionBlock4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
                        } else {
                            actionBlock = actionBlock4;
                        }
                        viewModel.deleteActionBlock(actionBlock);
                        finish();
                        return;
                    }
                }
            }
        }
        if (b0()) {
            if (this.f5513j) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle(R.string.save_changes);
                builder.setMessage(R.string.do_you_wish_to_save_changes);
                builder.setPositiveButton(R.string.save, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.actionblock.edit.a
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i4) {
                        ActionBlockEditActivity.Y(ActionBlockEditActivity.this, dialogInterface, i4);
                    }
                });
                builder.setNegativeButton(R.string.discard, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.actionblock.edit.l
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i4) {
                        ActionBlockEditActivity.Z(ActionBlockEditActivity.this, dialogInterface, i4);
                    }
                });
                builder.show();
                return;
            }
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i0(ActionBlockEditActivity this$0, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dialogInterface.dismiss();
        this$0.V();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(DialogInterface dialogInterface, int i4) {
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(ActionBlockEditActivity this$0, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.V();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l0() {
        if (CopyHelper.copyItem() != null) {
            SelectableItem copyItem = CopyHelper.copyItem();
            Intrinsics.checkNotNull(copyItem, "null cannot be cast to non-null type com.arlosoft.macrodroid.action.Action");
            Action action = (Action) copyItem;
            ActionBlock actionBlock = this.f5511h;
            if (actionBlock == null) {
                Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
                actionBlock = null;
            }
            actionBlock.getActions().add(action);
            ActionBlock actionBlock2 = this.f5511h;
            if (actionBlock2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
                actionBlock2 = null;
            }
            action.setMacro(actionBlock2);
            action.setHasEdited(true);
        } else if (CopyHelper.copyItemList() != null) {
            for (SelectableItem selectableItem : CopyHelper.copyItemList()) {
                Intrinsics.checkNotNull(selectableItem, "null cannot be cast to non-null type com.arlosoft.macrodroid.action.Action");
                Action action2 = (Action) selectableItem;
                ActionBlock actionBlock3 = this.f5511h;
                if (actionBlock3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
                    actionBlock3 = null;
                }
                actionBlock3.getActions().add(action2);
                ActionBlock actionBlock4 = this.f5511h;
                if (actionBlock4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
                    actionBlock4 = null;
                }
                action2.setMacro(actionBlock4);
                action2.setHasEdited(true);
            }
        }
        ToastCompat.makeText(getApplicationContext(), (int) R.string.item_pasted, 0).show();
        CopyHelper.refreshCopiedItem();
        this.f5513j = true;
        refresh$default(this, false, 1, null);
    }

    private final long m0(InputStream inputStream) {
        BufferedReader bufferedReader = null;
        ActionBlock actionBlock = null;
        bufferedReader = null;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(inputStream));
                String str = "";
                while (true) {
                    try {
                        try {
                            String readLine = bufferedReader2.readLine();
                            if (readLine == null) {
                                break;
                            }
                            str = str + readLine;
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader = bufferedReader2;
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            throw th;
                        }
                    } catch (Exception e4) {
                        e = e4;
                        bufferedReader = bufferedReader2;
                        ToastCompat.makeText(getApplicationContext(), (CharSequence) "The selected file could not be imported into MacroDroid", 1).show();
                        FirebaseCrashlytics.getInstance().recordException(new RuntimeException("Failed to import macro: " + e.getMessage()));
                        finish();
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (bufferedReader != null) {
                            bufferedReader.close();
                            return -1L;
                        }
                        return -1L;
                    }
                }
                Gson create = GsonUtils.getGsonBuilder().registerTypeAdapter(Macro.class, new MacroDeserializer(getApplicationContext(), true, true, true)).registerTypeAdapter(ActionBlock.class, new MacroDeserializer(getApplicationContext(), true, true, true)).create();
                try {
                    MacroExportData macroExportData = (MacroExportData) create.fromJson(str, (Class<Object>) MacroExportData.class);
                    Macro macro = macroExportData.getMacro();
                    Intrinsics.checkNotNull(macro, "null cannot be cast to non-null type com.arlosoft.macrodroid.actionblock.data.ActionBlock");
                    this.f5511h = (ActionBlock) macro;
                    if (macroExportData.getUserIcons() != null) {
                        UserIconHelper.importUserIcons(Gradients.INSTANCE.getContext(), macroExportData.getUserIcons());
                    }
                } catch (Exception unused) {
                    Object fromJson = create.fromJson(str, (Class<Object>) ActionBlock.class);
                    Intrinsics.checkNotNullExpressionValue(fromJson, "gson.fromJson(json, ActionBlock::class.java)");
                    this.f5511h = (ActionBlock) fromJson;
                }
                ActionBlockStore actionBlockStore = getActionBlockStore();
                ActionBlock actionBlock2 = this.f5511h;
                if (actionBlock2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
                    actionBlock2 = null;
                }
                ActionBlock actionBlock3 = this.f5511h;
                if (actionBlock3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
                    actionBlock3 = null;
                }
                List<ActionBlock> actionBlocksToImport = actionBlock3.getActionBlocksToImport();
                Intrinsics.checkNotNullExpressionValue(actionBlocksToImport, "actionBlock.actionBlocksToImport");
                ActionBlockHelper.addActionBlocks(actionBlockStore, actionBlock2, actionBlocksToImport, true);
                ActionBlock actionBlock4 = this.f5511h;
                if (actionBlock4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
                    actionBlock4 = null;
                }
                actionBlock4.setNewRandomGUID();
                ActionBlock actionBlock5 = this.f5511h;
                if (actionBlock5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
                    actionBlock5 = null;
                }
                actionBlock5.setCompleted(false);
                ActionBlock actionBlock6 = this.f5511h;
                if (actionBlock6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
                    actionBlock6 = null;
                }
                H(actionBlock6);
                this.f5516m = true;
                this.f5514k = true;
                ActionBlock actionBlock7 = this.f5511h;
                if (actionBlock7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
                    actionBlock7 = null;
                }
                actionBlock7.setIsBeingImported(true);
                ActionBlockStore actionBlockStore2 = getActionBlockStore();
                ActionBlock actionBlock8 = this.f5511h;
                if (actionBlock8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
                    actionBlock8 = null;
                }
                actionBlockStore2.addActionBlock(actionBlock8);
                ActionBlock actionBlock9 = this.f5511h;
                if (actionBlock9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
                } else {
                    actionBlock = actionBlock9;
                }
                long guid = actionBlock.getGUID();
                if (inputStream != null) {
                    inputStream.close();
                }
                bufferedReader2.close();
                return guid;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e5) {
            e = e5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(ActionBlockEditActivity this$0, MacroDroidVariable variable, VariableValue newVariable, VariableValue oldValue, long j4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(variable, "variable");
        Intrinsics.checkNotNullParameter(newVariable, "newVariable");
        Intrinsics.checkNotNullParameter(oldValue, "oldValue");
        this$0.w0();
    }

    private final void o0() {
        ActionBlock actionBlock = this.f5511h;
        if (actionBlock == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
            actionBlock = null;
        }
        MacroUtils.onShareActionBlock(this, actionBlock, getActionBlockStore());
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00f2 A[Catch: IOException -> 0x00f6, TRY_LEAVE, TryCatch #1 {IOException -> 0x00f6, blocks: (B:33:0x00ed, B:35:0x00f2), top: B:40:0x00ed }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void p0() {
        /*
            Method dump skipped, instructions count: 251
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.actionblock.edit.ActionBlockEditActivity.p0():void");
    }

    private final void q0() {
        List listOf;
        int i4 = Build.VERSION.SDK_INT;
        if (i4 < 31) {
            listOf = kotlin.collections.e.listOf("android.permission.ACCESS_FINE_LOCATION");
        } else {
            listOf = i4 < 33 ? CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"android.permission.BLUETOOTH_CONNECT", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION", "android.permission.BLUETOOTH_ADVERTISE", "android.permission.BLUETOOTH_CONNECT"}) : CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"android.permission.BLUETOOTH_SCAN", "android.permission.NEARBY_WIFI_DEVICES", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION", "android.permission.BLUETOOTH_ADVERTISE", "android.permission.BLUETOOTH_CONNECT"});
        }
        ExcuseMe.Companion couldYouGive = ExcuseMe.Companion.couldYouGive((Activity) this);
        String[] strArr = (String[]) listOf.toArray(new String[0]);
        couldYouGive.permissionFor((String[]) Arrays.copyOf(strArr, strArr.length), new s(listOf, this));
    }

    private final boolean r0(int i4, List<? extends Constraint> list) {
        if (i4 == 10) {
            return true;
        }
        for (Constraint constraint : list) {
            if (constraint instanceof LogicConstraint) {
                List<Constraint> constraints = constraint.getConstraints();
                Intrinsics.checkNotNullExpressionValue(constraints, "childConstraint.getConstraints()");
                if (r0(i4 + 1, constraints)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static /* synthetic */ void refresh$default(ActionBlockEditActivity actionBlockEditActivity, boolean z3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            z3 = false;
        }
        actionBlockEditActivity.refresh(z3);
    }

    private final void s0() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.menu_delete_action_block);
        builder.setMessage(getString(R.string.are_you_sure_delete_action_block));
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.actionblock.edit.s
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                ActionBlockEditActivity.t0(ActionBlockEditActivity.this, dialogInterface, i4);
            }
        });
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.actionblock.edit.t
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                ActionBlockEditActivity.u0(dialogInterface, i4);
            }
        });
        builder.show();
    }

    private final void showDeleteUndo(final List<? extends RemovedItem> list) {
        View findViewById = findViewById(R.id.coordinatorLayout);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = getString(R.string.deleted_with_name);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.deleted_with_name)");
        String format = String.format(string, Arrays.copyOf(new Object[]{list.get(0).getItem().getConfiguredName()}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        SnackbarAnimate make = SnackbarAnimate.make(findViewById, format, (int) EditMacroActivity.UNDO_PROMPT_TIMEOUT);
        Intrinsics.checkNotNullExpressionValue(make, "make(findViewById(R.id.c…_PROMPT_TIMEOUT\n        )");
        make.setAction(R.string.undo, new View.OnClickListener() { // from class: com.arlosoft.macrodroid.actionblock.edit.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ActionBlockEditActivity.B0(ActionBlockEditActivity.this, list, view);
            }
        });
        make.getView().setBackgroundResource(R.color.undo_bar_background);
        View findViewById2 = make.getView().findViewById(R.id.snackbar_text);
        Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) findViewById2).setTextColor(ContextCompat.getColor(this, R.color.undo_bar_foreground));
        View findViewById3 = make.getView().findViewById(R.id.snackbar_action);
        Intrinsics.checkNotNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) findViewById3).setTextColor(ContextCompat.getColor(this, R.color.undo_bar_foreground));
        make.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t0(ActionBlockEditActivity this$0, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ActionBlockEditViewModel viewModel = this$0.getViewModel();
        ActionBlock actionBlock = this$0.f5511h;
        if (actionBlock == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
            actionBlock = null;
        }
        viewModel.deleteActionBlock(actionBlock);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(DialogInterface dialogInterface, int i4) {
        dialogInterface.dismiss();
    }

    private final void v0(boolean z3) {
        boolean z4;
        ActionBlock actionBlock;
        String str;
        int i4;
        boolean z5;
        ActionBlock actionBlock2 = this.f5511h;
        ActionBlock actionBlock3 = null;
        ActivityActionBlockEditBinding activityActionBlockEditBinding = null;
        if (actionBlock2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
            actionBlock2 = null;
        }
        if (actionBlock2.getActions().size() == 0) {
            ActivityActionBlockEditBinding activityActionBlockEditBinding2 = this.f5509f;
            if (activityActionBlockEditBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityActionBlockEditBinding2 = null;
            }
            TextView textView = activityActionBlockEditBinding2.noActionsText;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.noActionsText");
            textView.setVisibility(0);
            ActivityActionBlockEditBinding activityActionBlockEditBinding3 = this.f5509f;
            if (activityActionBlockEditBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityActionBlockEditBinding = activityActionBlockEditBinding3;
            }
            SelectableItemsRecyclerView selectableItemsRecyclerView = activityActionBlockEditBinding.actionsList;
            Intrinsics.checkNotNullExpressionValue(selectableItemsRecyclerView, "binding.actionsList");
            selectableItemsRecyclerView.setVisibility(8);
        } else {
            ActivityActionBlockEditBinding activityActionBlockEditBinding4 = this.f5509f;
            if (activityActionBlockEditBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityActionBlockEditBinding4 = null;
            }
            TextView textView2 = activityActionBlockEditBinding4.noActionsText;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.noActionsText");
            textView2.setVisibility(8);
            ActivityActionBlockEditBinding activityActionBlockEditBinding5 = this.f5509f;
            if (activityActionBlockEditBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityActionBlockEditBinding5 = null;
            }
            SelectableItemsRecyclerView selectableItemsRecyclerView2 = activityActionBlockEditBinding5.actionsList;
            Intrinsics.checkNotNullExpressionValue(selectableItemsRecyclerView2, "binding.actionsList");
            selectableItemsRecyclerView2.setVisibility(0);
            SelectableItemsListAdapter<Action> selectableItemsListAdapter = this.f5510g;
            if (selectableItemsListAdapter != null) {
                z4 = selectableItemsListAdapter.isDragEnabled();
            } else {
                z4 = false;
            }
            SelectableItemsListAdapter<Action> selectableItemsListAdapter2 = this.f5510g;
            if (selectableItemsListAdapter2 != null && !z3) {
                if (selectableItemsListAdapter2 != null) {
                    ActionBlock actionBlock4 = this.f5511h;
                    if (actionBlock4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
                        actionBlock4 = null;
                    }
                    ArrayList<Action> actions = actionBlock4.getActions();
                    Intrinsics.checkNotNullExpressionValue(actions, "actionBlock.actions");
                    selectableItemsListAdapter2.setItems(actions);
                }
                str = "actionBlock.actions";
                i4 = 1;
            } else {
                ActionBlock actionBlock5 = this.f5511h;
                if (actionBlock5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
                    actionBlock = null;
                } else {
                    actionBlock = actionBlock5;
                }
                ActionBlock actionBlock6 = this.f5511h;
                if (actionBlock6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
                    actionBlock6 = null;
                }
                ArrayList<Action> actions2 = actionBlock6.getActions();
                Intrinsics.checkNotNullExpressionValue(actions2, "actionBlock.actions");
                str = "actionBlock.actions";
                this.f5510g = new SelectableItemsListAdapter<>(this, actionBlock, actions2, new t(), new u(), new v(), this.f5512i, true, new w());
                RecyclerViewDragDropManager recyclerViewDragDropManager = new RecyclerViewDragDropManager();
                SelectableItemsListAdapter<Action> selectableItemsListAdapter3 = this.f5510g;
                Intrinsics.checkNotNull(selectableItemsListAdapter3);
                RecyclerView.Adapter createWrappedAdapter = recyclerViewDragDropManager.createWrappedAdapter(selectableItemsListAdapter3);
                Intrinsics.checkNotNullExpressionValue(createWrappedAdapter, "dragDropManager.createWr…Adapter(actionsAdapter!!)");
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
                ActivityActionBlockEditBinding activityActionBlockEditBinding6 = this.f5509f;
                if (activityActionBlockEditBinding6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityActionBlockEditBinding6 = null;
                }
                activityActionBlockEditBinding6.actionsList.setItemAnimator(null);
                ActivityActionBlockEditBinding activityActionBlockEditBinding7 = this.f5509f;
                if (activityActionBlockEditBinding7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityActionBlockEditBinding7 = null;
                }
                activityActionBlockEditBinding7.actionsList.setNestedScrollingEnabled(false);
                ActivityActionBlockEditBinding activityActionBlockEditBinding8 = this.f5509f;
                if (activityActionBlockEditBinding8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityActionBlockEditBinding8 = null;
                }
                activityActionBlockEditBinding8.actionsList.setLayoutManager(linearLayoutManager);
                ActivityActionBlockEditBinding activityActionBlockEditBinding9 = this.f5509f;
                if (activityActionBlockEditBinding9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityActionBlockEditBinding9 = null;
                }
                activityActionBlockEditBinding9.actionsList.setAdapter(createWrappedAdapter);
                ActivityActionBlockEditBinding activityActionBlockEditBinding10 = this.f5509f;
                if (activityActionBlockEditBinding10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityActionBlockEditBinding10 = null;
                }
                recyclerViewDragDropManager.attachRecyclerView(activityActionBlockEditBinding10.actionsList);
                i4 = 1;
                recyclerViewDragDropManager.setInitiateOnTouch(true);
                recyclerViewDragDropManager.setCheckCanDropEnabled(false);
            }
            SelectableItemsListAdapter<Action> selectableItemsListAdapter4 = this.f5510g;
            if (selectableItemsListAdapter4 != null) {
                if (z4) {
                    ActionBlock actionBlock7 = this.f5511h;
                    if (actionBlock7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
                        actionBlock7 = null;
                    }
                    if (actionBlock7.getActions().size() > i4) {
                        z5 = true;
                        selectableItemsListAdapter4.setDragEnabled(z5);
                    }
                }
                z5 = false;
                selectableItemsListAdapter4.setDragEnabled(z5);
            }
            ActivityActionBlockEditBinding activityActionBlockEditBinding11 = this.f5509f;
            if (activityActionBlockEditBinding11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityActionBlockEditBinding11 = null;
            }
            ImageButton imageButton = activityActionBlockEditBinding11.reorderActionsButton;
            Intrinsics.checkNotNullExpressionValue(imageButton, "binding.reorderActionsButton");
            SelectableItemsListAdapter<Action> selectableItemsListAdapter5 = this.f5510g;
            Intrinsics.checkNotNull(selectableItemsListAdapter5);
            ActionBlock actionBlock8 = this.f5511h;
            if (actionBlock8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
            } else {
                actionBlock3 = actionBlock8;
            }
            ArrayList<Action> actions3 = actionBlock3.getActions();
            Intrinsics.checkNotNullExpressionValue(actions3, str);
            A0(imageButton, selectableItemsListAdapter5, actions3);
        }
        SelectableItem selectableItem = this.f5515l;
        if (selectableItem instanceof ConditionAction) {
            Intrinsics.checkNotNull(selectableItem, "null cannot be cast to non-null type com.arlosoft.macrodroid.action.ConditionAction");
            ((ConditionAction) selectableItem).configureConditionsList();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w0() {
        runOnUiThread(new Runnable() { // from class: com.arlosoft.macrodroid.actionblock.edit.q
            @Override // java.lang.Runnable
            public final void run() {
                ActionBlockEditActivity.x0(ActionBlockEditActivity.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x0(ActionBlockEditActivity this$0) {
        ActionBlock actionBlock;
        int i4;
        int i5;
        ActionBlock actionBlock2;
        int i6;
        int i7;
        ActionBlock actionBlock3;
        int i8;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ActionBlock actionBlock4 = this$0.f5511h;
        ActivityActionBlockEditBinding activityActionBlockEditBinding = null;
        if (actionBlock4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
            actionBlock = null;
        } else {
            actionBlock = actionBlock4;
        }
        boolean z3 = this$0.f5512i;
        Resources resources = this$0.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        this$0.f5517n = new LocalVarsAdapter(actionBlock, z3, resources, true, new x(), VariableType.INPUT);
        ActionBlock actionBlock5 = this$0.f5511h;
        if (actionBlock5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
            actionBlock5 = null;
        }
        int i9 = 0;
        List<MacroDroidVariable> inputVars = actionBlock5.getInputOnlyActionBlockVariables(false);
        ActivityActionBlockEditBinding activityActionBlockEditBinding2 = this$0.f5509f;
        if (activityActionBlockEditBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityActionBlockEditBinding2 = null;
        }
        TextView textView = activityActionBlockEditBinding2.inputVariablesHeading;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = this$0.getString(R.string.input_variables_with_count);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.input_variables_with_count)");
        String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(inputVars.size())}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        textView.setText(format);
        ActivityActionBlockEditBinding activityActionBlockEditBinding3 = this$0.f5509f;
        if (activityActionBlockEditBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityActionBlockEditBinding3 = null;
        }
        RecyclerView recyclerView = activityActionBlockEditBinding3.inputVarsList;
        LocalVarsAdapter localVarsAdapter = this$0.f5517n;
        if (localVarsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputVarsAdapter");
            localVarsAdapter = null;
        }
        recyclerView.setAdapter(localVarsAdapter);
        ActivityActionBlockEditBinding activityActionBlockEditBinding4 = this$0.f5509f;
        if (activityActionBlockEditBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityActionBlockEditBinding4 = null;
        }
        activityActionBlockEditBinding4.inputVarsList.setItemAnimator(null);
        ActivityActionBlockEditBinding activityActionBlockEditBinding5 = this$0.f5509f;
        if (activityActionBlockEditBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityActionBlockEditBinding5 = null;
        }
        activityActionBlockEditBinding5.inputVarsList.setNestedScrollingEnabled(false);
        ActivityActionBlockEditBinding activityActionBlockEditBinding6 = this$0.f5509f;
        if (activityActionBlockEditBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityActionBlockEditBinding6 = null;
        }
        TextView textView2 = activityActionBlockEditBinding6.noInputVarsText;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.noInputVarsText");
        if (inputVars.isEmpty()) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        textView2.setVisibility(i4);
        ActivityActionBlockEditBinding activityActionBlockEditBinding7 = this$0.f5509f;
        if (activityActionBlockEditBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityActionBlockEditBinding7 = null;
        }
        RecyclerView recyclerView2 = activityActionBlockEditBinding7.inputVarsList;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.inputVarsList");
        Intrinsics.checkNotNullExpressionValue(inputVars, "inputVars");
        if (!inputVars.isEmpty()) {
            i5 = 0;
        } else {
            i5 = 8;
        }
        recyclerView2.setVisibility(i5);
        ActionBlock actionBlock6 = this$0.f5511h;
        if (actionBlock6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
            actionBlock2 = null;
        } else {
            actionBlock2 = actionBlock6;
        }
        boolean z4 = this$0.f5512i;
        Resources resources2 = this$0.getResources();
        Intrinsics.checkNotNullExpressionValue(resources2, "resources");
        this$0.f5518o = new LocalVarsAdapter(actionBlock2, z4, resources2, true, new y(), VariableType.OUTPUT);
        ActionBlock actionBlock7 = this$0.f5511h;
        if (actionBlock7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
            actionBlock7 = null;
        }
        List<MacroDroidVariable> outputVars = actionBlock7.getOutputOnlyActionBlockVariables(false);
        ActivityActionBlockEditBinding activityActionBlockEditBinding8 = this$0.f5509f;
        if (activityActionBlockEditBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityActionBlockEditBinding8 = null;
        }
        TextView textView3 = activityActionBlockEditBinding8.outputVariablesHeading;
        String string2 = this$0.getString(R.string.output_variables_with_count);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.output_variables_with_count)");
        String format2 = String.format(string2, Arrays.copyOf(new Object[]{Integer.valueOf(outputVars.size())}, 1));
        Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
        textView3.setText(format2);
        ActivityActionBlockEditBinding activityActionBlockEditBinding9 = this$0.f5509f;
        if (activityActionBlockEditBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityActionBlockEditBinding9 = null;
        }
        RecyclerView recyclerView3 = activityActionBlockEditBinding9.outputVarsList;
        LocalVarsAdapter localVarsAdapter2 = this$0.f5518o;
        if (localVarsAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("outputVarsAdapter");
            localVarsAdapter2 = null;
        }
        recyclerView3.setAdapter(localVarsAdapter2);
        ActivityActionBlockEditBinding activityActionBlockEditBinding10 = this$0.f5509f;
        if (activityActionBlockEditBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityActionBlockEditBinding10 = null;
        }
        activityActionBlockEditBinding10.outputVarsList.setItemAnimator(null);
        ActivityActionBlockEditBinding activityActionBlockEditBinding11 = this$0.f5509f;
        if (activityActionBlockEditBinding11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityActionBlockEditBinding11 = null;
        }
        activityActionBlockEditBinding11.outputVarsList.setNestedScrollingEnabled(false);
        ActivityActionBlockEditBinding activityActionBlockEditBinding12 = this$0.f5509f;
        if (activityActionBlockEditBinding12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityActionBlockEditBinding12 = null;
        }
        TextView textView4 = activityActionBlockEditBinding12.noOutputVarsText;
        Intrinsics.checkNotNullExpressionValue(textView4, "binding.noOutputVarsText");
        if (outputVars.isEmpty()) {
            i6 = 0;
        } else {
            i6 = 8;
        }
        textView4.setVisibility(i6);
        ActivityActionBlockEditBinding activityActionBlockEditBinding13 = this$0.f5509f;
        if (activityActionBlockEditBinding13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityActionBlockEditBinding13 = null;
        }
        RecyclerView recyclerView4 = activityActionBlockEditBinding13.outputVarsList;
        Intrinsics.checkNotNullExpressionValue(recyclerView4, "binding.outputVarsList");
        Intrinsics.checkNotNullExpressionValue(outputVars, "outputVars");
        if (!outputVars.isEmpty()) {
            i7 = 0;
        } else {
            i7 = 8;
        }
        recyclerView4.setVisibility(i7);
        ActionBlock actionBlock8 = this$0.f5511h;
        if (actionBlock8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
            actionBlock3 = null;
        } else {
            actionBlock3 = actionBlock8;
        }
        boolean z5 = this$0.f5512i;
        Resources resources3 = this$0.getResources();
        Intrinsics.checkNotNullExpressionValue(resources3, "resources");
        this$0.f5519p = new LocalVarsAdapter(actionBlock3, z5, resources3, true, new z(), VariableType.LOCAL_WORKING_VAR);
        ActionBlock actionBlock9 = this$0.f5511h;
        if (actionBlock9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
            actionBlock9 = null;
        }
        List<MacroDroidVariable> localVars = actionBlock9.getActionBlockWorkingVariables(false);
        ActivityActionBlockEditBinding activityActionBlockEditBinding14 = this$0.f5509f;
        if (activityActionBlockEditBinding14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityActionBlockEditBinding14 = null;
        }
        TextView textView5 = activityActionBlockEditBinding14.localVariablesHeading;
        String string3 = this$0.getString(R.string.working_variables_with_count);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(R.string.working_variables_with_count)");
        String format3 = String.format(string3, Arrays.copyOf(new Object[]{Integer.valueOf(localVars.size())}, 1));
        Intrinsics.checkNotNullExpressionValue(format3, "format(format, *args)");
        textView5.setText(format3);
        ActivityActionBlockEditBinding activityActionBlockEditBinding15 = this$0.f5509f;
        if (activityActionBlockEditBinding15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityActionBlockEditBinding15 = null;
        }
        RecyclerView recyclerView5 = activityActionBlockEditBinding15.localVarsList;
        LocalVarsAdapter localVarsAdapter3 = this$0.f5519p;
        if (localVarsAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("localVarsAdapter");
            localVarsAdapter3 = null;
        }
        recyclerView5.setAdapter(localVarsAdapter3);
        ActivityActionBlockEditBinding activityActionBlockEditBinding16 = this$0.f5509f;
        if (activityActionBlockEditBinding16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityActionBlockEditBinding16 = null;
        }
        activityActionBlockEditBinding16.localVarsList.setItemAnimator(null);
        ActivityActionBlockEditBinding activityActionBlockEditBinding17 = this$0.f5509f;
        if (activityActionBlockEditBinding17 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityActionBlockEditBinding17 = null;
        }
        activityActionBlockEditBinding17.localVarsList.setNestedScrollingEnabled(false);
        ActivityActionBlockEditBinding activityActionBlockEditBinding18 = this$0.f5509f;
        if (activityActionBlockEditBinding18 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityActionBlockEditBinding18 = null;
        }
        TextView textView6 = activityActionBlockEditBinding18.noLocalVarsText;
        Intrinsics.checkNotNullExpressionValue(textView6, "binding.noLocalVarsText");
        if (localVars.isEmpty()) {
            i8 = 0;
        } else {
            i8 = 8;
        }
        textView6.setVisibility(i8);
        ActivityActionBlockEditBinding activityActionBlockEditBinding19 = this$0.f5509f;
        if (activityActionBlockEditBinding19 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityActionBlockEditBinding = activityActionBlockEditBinding19;
        }
        RecyclerView recyclerView6 = activityActionBlockEditBinding.localVarsList;
        Intrinsics.checkNotNullExpressionValue(recyclerView6, "binding.localVarsList");
        Intrinsics.checkNotNullExpressionValue(localVars, "localVars");
        if (!(!localVars.isEmpty())) {
            i9 = 8;
        }
        recyclerView6.setVisibility(i9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y0(boolean z3) {
        ActivityActionBlockEditBinding activityActionBlockEditBinding = this.f5509f;
        ActivityActionBlockEditBinding activityActionBlockEditBinding2 = null;
        if (activityActionBlockEditBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityActionBlockEditBinding = null;
        }
        activityActionBlockEditBinding.inputTopLevelLinearLayout.setLayoutTransition(new LayoutTransition());
        ActivityActionBlockEditBinding activityActionBlockEditBinding3 = this.f5509f;
        if (activityActionBlockEditBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityActionBlockEditBinding3 = null;
        }
        activityActionBlockEditBinding3.outputTopLevelLinearLayout.setLayoutTransition(new LayoutTransition());
        ActivityActionBlockEditBinding activityActionBlockEditBinding4 = this.f5509f;
        if (activityActionBlockEditBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityActionBlockEditBinding4 = null;
        }
        activityActionBlockEditBinding4.topLevelLayout.setLayoutTransition(new LayoutTransition());
        if (z3) {
            ActivityActionBlockEditBinding activityActionBlockEditBinding5 = this.f5509f;
            if (activityActionBlockEditBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityActionBlockEditBinding5 = null;
            }
            activityActionBlockEditBinding5.inputTopLevelLinearLayout.getLayoutTransition().enableTransitionType(4);
            ActivityActionBlockEditBinding activityActionBlockEditBinding6 = this.f5509f;
            if (activityActionBlockEditBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityActionBlockEditBinding6 = null;
            }
            activityActionBlockEditBinding6.outputTopLevelLinearLayout.getLayoutTransition().enableTransitionType(4);
            ActivityActionBlockEditBinding activityActionBlockEditBinding7 = this.f5509f;
            if (activityActionBlockEditBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityActionBlockEditBinding2 = activityActionBlockEditBinding7;
            }
            activityActionBlockEditBinding2.topLevelLayout.getLayoutTransition().enableTransitionType(4);
            return;
        }
        ActivityActionBlockEditBinding activityActionBlockEditBinding8 = this.f5509f;
        if (activityActionBlockEditBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityActionBlockEditBinding8 = null;
        }
        activityActionBlockEditBinding8.inputTopLevelLinearLayout.getLayoutTransition().disableTransitionType(4);
        ActivityActionBlockEditBinding activityActionBlockEditBinding9 = this.f5509f;
        if (activityActionBlockEditBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityActionBlockEditBinding9 = null;
        }
        activityActionBlockEditBinding9.outputTopLevelLinearLayout.getLayoutTransition().disableTransitionType(4);
        ActivityActionBlockEditBinding activityActionBlockEditBinding10 = this.f5509f;
        if (activityActionBlockEditBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityActionBlockEditBinding2 = activityActionBlockEditBinding10;
        }
        activityActionBlockEditBinding2.topLevelLayout.getLayoutTransition().disableTransitionType(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z0(boolean z3) {
        this.f5513j = z3;
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

    @NotNull
    public final PremiumStatusHandler getPremiumStatusHandler() {
        PremiumStatusHandler premiumStatusHandler = this.premiumStatusHandler;
        if (premiumStatusHandler != null) {
            return premiumStatusHandler;
        }
        Intrinsics.throwUninitializedPropertyAccessException("premiumStatusHandler");
        return null;
    }

    @NotNull
    public final ScreenLoader getScreenLoader() {
        ScreenLoader screenLoader = this.screenLoader;
        if (screenLoader != null) {
            return screenLoader;
        }
        Intrinsics.throwUninitializedPropertyAccessException("screenLoader");
        return null;
    }

    @NotNull
    public final ActionBlockEditViewModel getViewModel() {
        ActionBlockEditViewModel actionBlockEditViewModel = this.viewModel;
        if (actionBlockEditViewModel != null) {
            return actionBlockEditViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }

    public final boolean isEditingCondition() {
        return this.f5515l instanceof ConditionAction;
    }

    @Override // com.arlosoft.macrodroid.widget.ItemFinishedListener
    public void itemCancelled() {
        SelectableItem selectableItem = this.f5515l;
        if (selectableItem != null) {
            selectableItem.handleItemCancel();
        }
    }

    @Override // com.arlosoft.macrodroid.widget.ItemFinishedListener
    public void itemComplete(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        SelectableItem selectableItem = this.f5515l;
        if (selectableItem != null) {
            selectableItem.handleItemComplete(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:25:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onActivityResult(int r6, int r7, @org.jetbrains.annotations.Nullable android.content.Intent r8) {
        /*
            r5 = this;
            super.onActivityResult(r6, r7, r8)
            r0 = 1
            r1 = -1
            switch(r6) {
                case 501: goto L16;
                case 502: goto L16;
                case 503: goto L16;
                default: goto L8;
            }
        L8:
            com.arlosoft.macrodroid.actionblock.data.ActionBlock r2 = r5.f5511h
            if (r2 == 0) goto L34
            r3 = 0
            java.lang.String r4 = "actionBlock"
            if (r2 != 0) goto L1b
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r2 = r3
            goto L1b
        L16:
            if (r7 != r1) goto L1a
            r5.f5513j = r0
        L1a:
            return
        L1b:
            com.arlosoft.macrodroid.action.Action r2 = r2.getActionBeingConfigured()
            if (r2 == 0) goto L34
            com.arlosoft.macrodroid.actionblock.data.ActionBlock r2 = r5.f5511h
            if (r2 != 0) goto L29
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            goto L2a
        L29:
            r3 = r2
        L2a:
            com.arlosoft.macrodroid.action.Action r2 = r3.getActionBeingConfigured()
            if (r2 == 0) goto L3b
            r2.handleActivityResult(r5, r6, r7, r8)
            goto L3b
        L34:
            com.arlosoft.macrodroid.common.SelectableItem r2 = r5.f5515l
            if (r2 == 0) goto L3b
            r2.handleActivityResult(r5, r6, r7, r8)
        L3b:
            if (r7 != r1) goto L3f
            r5.f5513j = r0
        L3f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.actionblock.edit.ActionBlockEditActivity.onActivityResult(int, int, android.content.Intent):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity, com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        boolean z3;
        boolean z4;
        long longExtra;
        boolean z5;
        boolean endsWith$default;
        boolean startsWith$default;
        Object last;
        super.onCreate(bundle);
        ActivityActionBlockEditBinding inflate = ActivityActionBlockEditBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater)");
        this.f5509f = inflate;
        ActivityActionBlockEditBinding activityActionBlockEditBinding = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        setContentView(inflate.getRoot());
        this.f5512i = Settings.getEditMacroSmallMode(this);
        this.f5524u = new TopLevelEditHelper(this, new n(), new o(), new p());
        Intent intent = getIntent();
        if (intent != null) {
            z3 = intent.getBooleanExtra("no_advert", false);
        } else {
            z3 = false;
        }
        this.f5521r = z3;
        if (bundle != null) {
            this.f5515l = (SelectableItem) bundle.getParcelable("selectable_item");
        }
        Intent intent2 = getIntent();
        if (intent2 != null) {
            z4 = intent2.getBooleanExtra("adding_new", false);
        } else {
            z4 = false;
        }
        this.f5516m = z4;
        if (getIntent() != null && getIntent().getAction() != null && Intrinsics.areEqual(getIntent().getAction(), "android.intent.action.VIEW") && getIntent().getData() != null) {
            this.f5521r = true;
            Uri data = getIntent().getData();
            endsWith$default = kotlin.text.m.endsWith$default(String.valueOf(data), ".ablock", false, 2, null);
            try {
                if (!endsWith$default) {
                    startsWith$default = kotlin.text.m.startsWith$default(String.valueOf(data), "content://", false, 2, null);
                    if (!startsWith$default) {
                        Intrinsics.checkNotNull(data);
                        List<String> pathSegments = data.getPathSegments();
                        Intrinsics.checkNotNullExpressionValue(pathSegments, "uri!!.pathSegments");
                        last = CollectionsKt___CollectionsKt.last((List<? extends Object>) pathSegments);
                        Intrinsics.checkNotNullExpressionValue(last, "uri!!.pathSegments.last()");
                        longExtra = Long.parseLong((String) last);
                        z5 = true;
                    }
                }
                ContentResolver contentResolver = getContentResolver();
                Intrinsics.checkNotNull(data);
                InputStream openInputStream = contentResolver.openInputStream(data);
                Intrinsics.checkNotNull(openInputStream);
                longExtra = m0(openInputStream);
                z5 = true;
            } catch (Exception e4) {
                ToastCompat.makeText(getApplicationContext(), (CharSequence) "The selected file could not be imported into MacroDroid", 1).show();
                FirebaseCrashlytics.getInstance().recordException(new RuntimeException("Failed to import action block from input stream: " + e4.getMessage()));
                finish();
                return;
            }
        } else {
            longExtra = getIntent().getLongExtra(Constants.EXTRA_ACTION_BLOCK_GUID, -1L);
            z5 = false;
        }
        getViewModel().setActionBlockId(longExtra, z5);
        getLifecycle().addObserver(getViewModel());
        ActivityActionBlockEditBinding activityActionBlockEditBinding2 = this.f5509f;
        if (activityActionBlockEditBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityActionBlockEditBinding2 = null;
        }
        setSupportActionBar(activityActionBlockEditBinding2.toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayShowTitleEnabled(false);
        }
        ActivityActionBlockEditBinding activityActionBlockEditBinding3 = this.f5509f;
        if (activityActionBlockEditBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityActionBlockEditBinding3 = null;
        }
        ImageButton imageButton = activityActionBlockEditBinding3.actionBack;
        Intrinsics.checkNotNullExpressionValue(imageButton, "binding.actionBack");
        ViewExtensionsKt.onClick$default(imageButton, null, new q(null), 1, null);
        ActivityActionBlockEditBinding activityActionBlockEditBinding4 = this.f5509f;
        if (activityActionBlockEditBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityActionBlockEditBinding4 = null;
        }
        EditText editText = activityActionBlockEditBinding4.actionBlockNameText;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.actionBlockNameText");
        editText.addTextChangedListener(new TextWatcher() { // from class: com.arlosoft.macrodroid.actionblock.edit.ActionBlockEditActivity$onCreate$$inlined$addTextChangedListener$default$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(@Nullable Editable editable) {
                ActionBlockEditActivity.this.getViewModel().updateName(String.valueOf(editable));
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(@Nullable CharSequence charSequence, int i4, int i5, int i6) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(@Nullable CharSequence charSequence, int i4, int i5, int i6) {
            }
        });
        ActivityActionBlockEditBinding activityActionBlockEditBinding5 = this.f5509f;
        if (activityActionBlockEditBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityActionBlockEditBinding5 = null;
        }
        AppCompatEditText appCompatEditText = activityActionBlockEditBinding5.description;
        Intrinsics.checkNotNullExpressionValue(appCompatEditText, "binding.description");
        appCompatEditText.addTextChangedListener(new TextWatcher() { // from class: com.arlosoft.macrodroid.actionblock.edit.ActionBlockEditActivity$onCreate$$inlined$addTextChangedListener$default$2
            @Override // android.text.TextWatcher
            public void afterTextChanged(@Nullable Editable editable) {
                ActionBlockEditActivity.this.getViewModel().updateDescription(String.valueOf(editable));
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(@Nullable CharSequence charSequence, int i4, int i5, int i6) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(@Nullable CharSequence charSequence, int i4, int i5, int i6) {
            }
        });
        ActivityActionBlockEditBinding activityActionBlockEditBinding6 = this.f5509f;
        if (activityActionBlockEditBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityActionBlockEditBinding = activityActionBlockEditBinding6;
        }
        activityActionBlockEditBinding.nearbySharePanel.setOnExpansionUpdateListener(new ExpandableLayout.OnExpansionUpdateListener() { // from class: com.arlosoft.macrodroid.actionblock.edit.ActionBlockEditActivity$onCreate$7
            @Override // net.cachapa.expandablelayout.ExpandableLayout.OnExpansionUpdateListener
            public void onExpansionUpdate(float f4, int i4) {
                if (i4 == 0 || i4 == 3) {
                    ActionBlockEditActivity.this.y0(true);
                }
            }
        });
        Q();
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback() { // from class: com.arlosoft.macrodroid.actionblock.edit.ActionBlockEditActivity$onCreate$8
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(true);
            }

            @Override // androidx.activity.OnBackPressedCallback
            public void handleOnBackPressed() {
                ActionBlockEditActivity.this.handleBackPressed();
            }
        });
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(@NotNull Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        getMenuInflater().inflate(R.menu.edit_action_block_menu, menu);
        if (this.f5511h == null) {
            finish();
            return true;
        }
        MenuItem findItem = menu.findItem(R.id.menu_allow_logging);
        ActionBlock actionBlock = this.f5511h;
        if (actionBlock == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
            actionBlock = null;
        }
        findItem.setChecked(!actionBlock.isExcludedFromLog());
        return true;
    }

    @Override // com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ActionBlock actionBlock = this.f5511h;
        if (actionBlock != null) {
            if (actionBlock == null) {
                Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
                actionBlock = null;
            }
            actionBlock.removeLocalVariableUpdatedListener(this.f5526w);
        }
    }

    public final void onEventMainThread(@NotNull ShowActionBlockTestSummaryEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        try {
            if (!event.getOutputVars().isEmpty()) {
                AppCompatDialog appCompatDialog = new AppCompatDialog(this, R.style.Theme_App_Dialog_NoTitle);
                appCompatDialog.setContentView(R.layout.dialog_action_block_test_output);
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
                View findViewById = appCompatDialog.findViewById(R.id.outputVars);
                Intrinsics.checkNotNull(findViewById);
                View findViewById2 = appCompatDialog.findViewById(R.id.okButton);
                Intrinsics.checkNotNull(findViewById2);
                ((RecyclerView) findViewById).setAdapter(new ActionBlockOutputVarAdapter(event.getOutputVars()));
                ViewExtensionsKt.onClick$default((Button) findViewById2, null, new r(appCompatDialog, null), 1, null);
                appCompatDialog.show();
            }
        } catch (Exception e4) {
            SystemLog.logError("Failed to display variable summary: " + e4);
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(@NotNull MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        ActionBlock actionBlock = null;
        switch (item.getItemId()) {
            case R.id.menu_allow_logging /* 2131363376 */:
                ActionBlock actionBlock2 = this.f5511h;
                if (actionBlock2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
                    actionBlock2 = null;
                }
                ActionBlock actionBlock3 = this.f5511h;
                if (actionBlock3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
                    actionBlock3 = null;
                }
                actionBlock2.setExcludeFromLog(!actionBlock3.isExcludedFromLog());
                ActionBlock actionBlock4 = this.f5511h;
                if (actionBlock4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
                } else {
                    actionBlock = actionBlock4;
                }
                item.setChecked(!actionBlock.isExcludedFromLog());
                break;
            case R.id.menu_clone_action_block /* 2131363381 */:
                ActionBlockEditViewModel viewModel = getViewModel();
                ActionBlock actionBlock5 = this.f5511h;
                if (actionBlock5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
                } else {
                    actionBlock = actionBlock5;
                }
                viewModel.onCloneActionBlockClicked(actionBlock);
                break;
            case R.id.menu_delete /* 2131363387 */:
                s0();
                break;
            case R.id.menu_save_changes /* 2131363421 */:
                L();
                if (I0()) {
                    this.f5513j = false;
                    I(false);
                    ActionBlock actionBlock6 = this.f5511h;
                    if (actionBlock6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
                    } else {
                        actionBlock = actionBlock6;
                    }
                    this.f5525v = actionBlock.exactClone();
                    refresh(true);
                    break;
                }
                break;
            case R.id.menu_share_action_block /* 2131363427 */:
                o0();
                break;
            case R.id.menu_share_as_image /* 2131363428 */:
                p0();
                break;
            case R.id.menu_share_nearby /* 2131363431 */:
                q0();
                break;
            case R.id.menu_test_actions /* 2131363438 */:
                F0();
                break;
            case R.id.menu_text_size /* 2131363440 */:
                boolean z3 = !this.f5512i;
                this.f5512i = z3;
                Settings.setEditMacroSmallMode(this, z3);
                refresh(true);
                break;
            case R.id.menu_toggle_description /* 2131363441 */:
                a0();
                break;
            case R.id.menu_variables /* 2131363446 */:
                ActionBlock actionBlock7 = this.f5511h;
                if (actionBlock7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
                } else {
                    actionBlock = actionBlock7;
                }
                startActivity(MacroDroidVariablesActivity.createIntent(this, actionBlock.getGUID()));
                break;
        }
        return true;
    }

    @Override // com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        EventBusUtils.getEventBus().unregister(this);
        if (this.f5522s) {
            getNearbyHelper().stopDiscovery();
            getNearbyHelper().disconnect();
            getNearbyHelper().cleanUpHelper();
        }
        super.onPause();
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(@NotNull Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        menu.findItem(R.id.menu_save_changes).setVisible(this.f5513j);
        return super.onPrepareOptionsMenu(menu);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f5522s = false;
        EventBusUtils.getEventBus().register(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        ActionBlock actionBlock = this.f5511h;
        if (actionBlock != null) {
            if (actionBlock == null) {
                Intrinsics.throwUninitializedPropertyAccessException("actionBlock");
                actionBlock = null;
            }
            outState.putLong(Constants.EXTRA_MACRO_GUID, actionBlock.getGUID());
        }
        outState.putParcelable("selectable_item", this.f5515l);
        super.onSaveInstanceState(outState);
    }

    public final void refresh(boolean z3) {
        v0(z3);
        w0();
        G0();
    }

    public final void setActionBlockStore(@NotNull ActionBlockStore actionBlockStore) {
        Intrinsics.checkNotNullParameter(actionBlockStore, "<set-?>");
        this.actionBlockStore = actionBlockStore;
    }

    public final void setHasEdited() {
        this.f5513j = true;
        G0();
    }

    public final void setNearbyHelper(@NotNull NearbyHelper nearbyHelper) {
        Intrinsics.checkNotNullParameter(nearbyHelper, "<set-?>");
        this.nearbyHelper = nearbyHelper;
    }

    public final void setPremiumStatusHandler(@NotNull PremiumStatusHandler premiumStatusHandler) {
        Intrinsics.checkNotNullParameter(premiumStatusHandler, "<set-?>");
        this.premiumStatusHandler = premiumStatusHandler;
    }

    public final void setScreenLoader(@NotNull ScreenLoader screenLoader) {
        Intrinsics.checkNotNullParameter(screenLoader, "<set-?>");
        this.screenLoader = screenLoader;
    }

    public final void setViewModel(@NotNull ActionBlockEditViewModel actionBlockEditViewModel) {
        Intrinsics.checkNotNullParameter(actionBlockEditViewModel, "<set-?>");
        this.viewModel = actionBlockEditViewModel;
    }

    public final void showEditButtonMenu(@NotNull final SelectableItem item, @NotNull final Macro macro) {
        int i4;
        int i5;
        int i6;
        int i7;
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(macro, "macro");
        this.f5515l = item;
        ArrayList arrayList = new ArrayList();
        if (item instanceof EndParentAction) {
            if ((CopyHelper.copyItem() != null && (CopyHelper.copyItem() instanceof Action)) || CopyHelper.copyItemList() != null) {
                arrayList.add(getString(R.string.paste_action_above));
            }
            arrayList.add(getString(R.string.add_action_above));
        } else if (item instanceof ElseParentAction) {
            if ((item instanceof ElseIfConditionAction) || (item instanceof ElseIfConfirmedThenAction)) {
                arrayList.add(getString(R.string.configure));
            }
            if ((CopyHelper.copyItem() != null && (CopyHelper.copyItem() instanceof Action)) || CopyHelper.copyItemList() != null) {
                arrayList.add(getString(R.string.paste_action_above));
            }
            arrayList.add(getString(R.string.add_action_above));
            arrayList.add(getString(R.string.add_child_action));
            ElseParentAction elseParentAction = (ElseParentAction) item;
            if (TextUtils.isEmpty(elseParentAction.getComment())) {
                arrayList.add(getString(R.string.add_comment));
            } else {
                arrayList.add(getString(R.string.edit_comment));
            }
            arrayList.add(getString(R.string.delete));
            ParentAction parentAction = macro.getParentAction((Action) item);
            if (parentAction != null && parentAction.isEnabled()) {
                if (elseParentAction.isEnabled()) {
                    i6 = R.string.disable;
                } else {
                    i6 = R.string.enable;
                }
                arrayList.add(getString(i6));
                if (item.isEnabled()) {
                    i7 = R.string.disable_condition_or_loop_action_including_children;
                } else {
                    i7 = R.string.enable_condition_or_loop_action_including_children;
                }
                arrayList.add(getString(i7));
            }
        } else {
            if (item.hasOptions()) {
                arrayList.add(getString(R.string.configure));
            }
            if (item instanceof Trigger) {
                arrayList.add(getString(R.string.test_trigger));
            }
            boolean z3 = true;
            if (item instanceof Action) {
                if (!(item instanceof ParentAction)) {
                    arrayList.add(getString(R.string.test_action));
                    List<Constraint> constraints = ((Action) item).getConstraints();
                    Intrinsics.checkNotNullExpressionValue(constraints, "item.constraints");
                    if (!constraints.isEmpty()) {
                        String string = getString(R.string.test_action);
                        String string2 = getString(R.string.testing_trigger_or_action_with_constraints);
                        arrayList.add(string + " (" + string2 + ")");
                    }
                }
                arrayList.add(getString(R.string.add_action_above));
                if ((CopyHelper.copyItem() != null && (CopyHelper.copyItem() instanceof Action)) || CopyHelper.copyItemList() != null) {
                    arrayList.add(getString(R.string.paste_action_above));
                }
            }
            boolean z4 = item instanceof ParentAction;
            if (z4) {
                arrayList.add(getString(R.string.add_child_action));
            } else if (!(item instanceof Constraint) || (item instanceof LogicConstraint)) {
                arrayList.add(getString(R.string.add_constraint));
                if (CopyHelper.copyItem() != null && (CopyHelper.copyItem() instanceof Constraint)) {
                    arrayList.add(getString(R.string.paste_constraint));
                }
            }
            if (item instanceof IfConditionAction) {
                int indexOf = macro.getActions().indexOf(item);
                int endIfIndex = MacroListUtils.getEndIfIndex(macro.getActions(), indexOf);
                int elseIndex = MacroListUtils.getElseIndex(macro.getActions(), indexOf);
                arrayList.add(getString(R.string.add_else_if_clause));
                arrayList.add(getString(R.string.add_else_if_confirmed_clause));
                if (!((1 > elseIndex || elseIndex >= endIfIndex) ? false : false)) {
                    arrayList.add(getString(R.string.add_else_clause));
                }
            }
            if (TextUtils.isEmpty(item.getComment())) {
                arrayList.add(getString(R.string.add_comment));
            } else {
                arrayList.add(getString(R.string.edit_comment));
            }
            boolean z5 = item instanceof WidgetPressedTrigger;
            if (!z5) {
                arrayList.add(getString(R.string.ui_interaction_cut));
            }
            if (!z5) {
                arrayList.add(getString(R.string.action_file_operation_copy));
            }
            arrayList.add(getString(R.string.delete));
            if (z4) {
                arrayList.add(getString(R.string.delete_condition_or_loop_including_children));
            }
            if (item.isEnabled()) {
                i4 = R.string.disable;
            } else {
                i4 = R.string.enable;
            }
            arrayList.add(getString(i4));
            if (z4) {
                if (((ParentAction) item).isEnabled()) {
                    i5 = R.string.disable_condition_or_loop_action_including_children;
                } else {
                    i5 = R.string.enable_condition_or_loop_action_including_children;
                }
                arrayList.add(getString(i5));
            }
            arrayList.add(getString(R.string.help));
        }
        if (arrayList.size() == 0) {
            return;
        }
        final String[] strArr = (String[]) arrayList.toArray(new String[0]);
        TopLevelEditHelper topLevelEditHelper = this.f5524u;
        if (topLevelEditHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topLevelEditHelper");
            topLevelEditHelper = null;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this, topLevelEditHelper.getInvertDialogStyle(item));
        builder.setTitle(item.getEditMacroConfiguredName()).setItems(strArr, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.actionblock.edit.p
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i8) {
                ActionBlockEditActivity.C0(ActionBlockEditActivity.this, strArr, item, macro, dialogInterface, i8);
            }
        });
        builder.show();
    }
}
