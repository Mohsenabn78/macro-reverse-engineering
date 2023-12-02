package com.arlosoft.macrodroid.editscreen;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.util.Range;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SubMenu;
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
import android.widget.PopupMenu;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import androidx.appcompat.widget.TooltipCompat;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.OneShotPreDrawListener;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.araujo.jordan.excuseme.ExcuseMe;
import com.araujo.jordan.excuseme.model.PermissionStatus;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.Action;
import com.arlosoft.macrodroid.action.ActionBlockAction;
import com.arlosoft.macrodroid.action.CancelActiveMacroAction;
import com.arlosoft.macrodroid.action.ConditionAction;
import com.arlosoft.macrodroid.action.DisableMacroAction;
import com.arlosoft.macrodroid.action.ElseIfConditionAction;
import com.arlosoft.macrodroid.action.ElseIfConfirmedThenAction;
import com.arlosoft.macrodroid.action.ElseParentAction;
import com.arlosoft.macrodroid.action.EndParentAction;
import com.arlosoft.macrodroid.action.ForceMacroRunAction;
import com.arlosoft.macrodroid.action.IfConditionAction;
import com.arlosoft.macrodroid.action.LoopAction;
import com.arlosoft.macrodroid.action.ParentAction;
import com.arlosoft.macrodroid.action.WaitUntilTriggerAction;
import com.arlosoft.macrodroid.actionblock.ActionBlockHelper;
import com.arlosoft.macrodroid.actionblock.data.ActionBlock;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity;
import com.arlosoft.macrodroid.autobackup.worker.AutoBackupCloudWorker;
import com.arlosoft.macrodroid.categories.Category;
import com.arlosoft.macrodroid.categories.CategoryList;
import com.arlosoft.macrodroid.categories.HasMacroNames;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.common.MacroDroidVariable;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.common.VariableUpdatedListener;
import com.arlosoft.macrodroid.confirmation.PremiumStatusHandler;
import com.arlosoft.macrodroid.constraint.Constraint;
import com.arlosoft.macrodroid.constraint.LogicConstraint;
import com.arlosoft.macrodroid.databinding.ActivityEditMacroBinding;
import com.arlosoft.macrodroid.databinding.IncludeVariablesBinding;
import com.arlosoft.macrodroid.editscreen.EditMacroActivity;
import com.arlosoft.macrodroid.events.EventBusUtils;
import com.arlosoft.macrodroid.events.MacroDeletedEvent;
import com.arlosoft.macrodroid.events.MacroEnabledStateChangeEvent;
import com.arlosoft.macrodroid.events.RefreshEditMacroPageEvent;
import com.arlosoft.macrodroid.extensions.DialogExtensionsKt;
import com.arlosoft.macrodroid.extensions.ViewExtensionsKt;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.logging.systemlog.SystemLogActivity;
import com.arlosoft.macrodroid.macro.ActionBlockStore;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.macro.RemovedItem;
import com.arlosoft.macrodroid.nearby.NearbyDevice;
import com.arlosoft.macrodroid.nearby.NearbyHelper;
import com.arlosoft.macrodroid.permissions.PermissionsHelper;
import com.arlosoft.macrodroid.remoteconfig.RemoteConfig;
import com.arlosoft.macrodroid.selectableitemlist.AddActionActivity;
import com.arlosoft.macrodroid.selectableitemlist.AddConstraintActivity;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.EmptyTrigger;
import com.arlosoft.macrodroid.triggers.Trigger;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.triggers.WidgetPressedTrigger;
import com.arlosoft.macrodroid.utils.CopyHelper;
import com.arlosoft.macrodroid.utils.DeleteMacroHelperKt;
import com.arlosoft.macrodroid.utils.MacroListUtils;
import com.arlosoft.macrodroid.utils.MacroUtils;
import com.arlosoft.macrodroid.utils.ScreenShotHelper;
import com.arlosoft.macrodroid.utils.gradients.Gradients;
import com.arlosoft.macrodroid.variables.DictionaryEventListener;
import com.arlosoft.macrodroid.variables.MacroDroidVariablesActivity;
import com.arlosoft.macrodroid.variables.VariableHelper;
import com.arlosoft.macrodroid.variables.VariableValue;
import com.arlosoft.macrodroid.widget.ItemFinishedListener;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.SnackbarAnimate;
import com.h6ah4i.android.widget.advrecyclerview.draggable.RecyclerViewDragDropManager;
import com.tbruyelle.rxpermissions2.RxPermissions;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import javax.inject.Inject;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.IntRange;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import me.drakeet.support.toast.ToastCompat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import splitties.alertdialog.appcompat.AlertDialogKt;

/* compiled from: EditMacroActivity.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nEditMacroActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EditMacroActivity.kt\ncom/arlosoft/macrodroid/editscreen/EditMacroActivity\n+ 2 TextView.kt\nandroidx/core/widget/TextViewKt\n+ 3 View.kt\nandroidx/core/view/ViewKt\n+ 4 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 6 Lists.kt\nsplitties/collections/ListsKt\n+ 7 AlertDialog.kt\nsplitties/alertdialog/appcompat/AlertDialogKt\n*L\n1#1,2586:1\n65#2,16:2587\n93#2,3:2603\n262#3,2:2606\n84#3:2638\n262#3,2:2641\n262#3,2:2647\n262#3,2:2649\n262#3,2:2651\n262#3,2:2653\n262#3,2:2668\n262#3,2:2670\n262#3,2:2672\n262#3,2:2674\n262#3,2:2676\n37#4,2:2608\n37#4,2:2636\n37#4,2:2666\n1855#5,2:2610\n1855#5,2:2612\n766#5:2614\n857#5,2:2615\n1855#5:2617\n1856#5:2624\n766#5:2625\n857#5,2:2626\n1855#5:2628\n1856#5:2635\n1855#5,2:2639\n1549#5:2643\n1620#5,3:2644\n33#6,6:2618\n33#6,6:2629\n27#7,3:2655\n165#7,2:2658\n183#7,2:2660\n30#7:2662\n84#7,3:2663\n*S KotlinDebug\n*F\n+ 1 EditMacroActivity.kt\ncom/arlosoft/macrodroid/editscreen/EditMacroActivity\n*L\n553#1:2587,16\n553#1:2603,3\n660#1:2606,2\n1606#1:2638\n1700#1:2641,2\n1979#1:2647,2\n1989#1:2649,2\n1999#1:2651,2\n2000#1:2653,2\n2479#1:2668,2\n2497#1:2670,2\n2506#1:2672,2\n2028#1:2674,2\n2029#1:2676,2\n709#1:2608,2\n1287#1:2636,2\n2205#1:2666,2\n922#1:2610,2\n1062#1:2612,2\n1098#1:2614\n1098#1:2615,2\n1098#1:2617\n1098#1:2624\n1107#1:2625\n1107#1:2626,2\n1107#1:2628\n1107#1:2635\n1654#1:2639,2\n1734#1:2643\n1734#1:2644,3\n1100#1:2618,6\n1109#1:2629,6\n2165#1:2655,3\n2168#1:2658,2\n2169#1:2660,2\n2165#1:2662\n2170#1:2663,3\n*E\n"})
/* loaded from: classes3.dex */
public final class EditMacroActivity extends MacroDroidDaggerBaseActivity implements ItemFinishedListener {
    @NotNull
    public static final String ADDING_NEW_MACRO_EXTRA = "adding_new_macro";
    @NotNull
    public static final String IS_TEMPLATE_EXTRA = "is_template";
    @NotNull
    public static final String NEW_TEMPLATE_STORE = "new_template_store";
    public static final int UNDO_PROMPT_TIMEOUT = 4500;
    @Nullable
    private Action A;
    @Nullable
    private Macro B;
    private boolean C;
    private int E;
    private IncludeVariablesBinding G;
    private ActivityEditMacroBinding H;
    @Inject
    public ActionBlockStore actionBlockStore;

    /* renamed from: f  reason: collision with root package name */
    private Macro f11735f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private SelectableItem f11736g;

    /* renamed from: h  reason: collision with root package name */
    private int f11737h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private AllSelectableItemsListAdapter f11738i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f11739j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f11740k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f11741l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f11742m;

    /* renamed from: n  reason: collision with root package name */
    private int f11743n;
    @Inject
    public NearbyHelper nearbyHelper;

    /* renamed from: o  reason: collision with root package name */
    private boolean f11744o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f11745p;
    @Inject
    public PremiumStatusHandler premiumStatusHandler;

    /* renamed from: q  reason: collision with root package name */
    private boolean f11746q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f11747r;
    @Inject
    public RemoteConfig remoteConfig;

    /* renamed from: s  reason: collision with root package name */
    private BottomSheetBehavior<View> f11748s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f11749t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f11750u;

    /* renamed from: v  reason: collision with root package name */
    private LocalVarsAdapter f11751v;

    /* renamed from: x  reason: collision with root package name */
    private int f11753x;

    /* renamed from: y  reason: collision with root package name */
    private MenuItem f11754y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f11755z;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* renamed from: w  reason: collision with root package name */
    private int f11752w = 1;
    @NotNull
    private List<Integer> D = new ArrayList();
    private boolean F = true;
    @NotNull
    private final VariableUpdatedListener I = new VariableUpdatedListener() { // from class: com.arlosoft.macrodroid.editscreen.y
        @Override // com.arlosoft.macrodroid.common.VariableUpdatedListener
        public final void variableValueUpdated(MacroDroidVariable macroDroidVariable, VariableValue variableValue, VariableValue variableValue2, long j4) {
            EditMacroActivity.B0(EditMacroActivity.this, macroDroidVariable, variableValue, variableValue2, j4);
        }
    };
    @NotNull
    private final EditMacroActivity$nearbyDeviceStatusListener$1 J = new NearbyHelper.NearbySendListener() { // from class: com.arlosoft.macrodroid.editscreen.EditMacroActivity$nearbyDeviceStatusListener$1
        @Override // com.arlosoft.macrodroid.nearby.NearbyHelper.NearbySendListener
        public void fileSent(@NotNull NearbyDevice nearbyDevice) {
            Intrinsics.checkNotNullParameter(nearbyDevice, "nearbyDevice");
            ActivityEditMacroBinding activityEditMacroBinding = EditMacroActivity.this.H;
            if (activityEditMacroBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityEditMacroBinding = null;
            }
            activityEditMacroBinding.nearbySharePanel.collapse();
            EditMacroActivity.this.getNearbyHelper().stopDiscovery();
            EditMacroActivity.this.getNearbyHelper().disconnect();
        }
    };
    @NotNull
    private final EditMacroActivity$triggerHeaderCallback$1 K = new EditMacroActivity$triggerHeaderCallback$1(this);
    @NotNull
    private final EditMacroActivity$actionHeaderCallback$1 L = new HeaderCallback() { // from class: com.arlosoft.macrodroid.editscreen.EditMacroActivity$actionHeaderCallback$1
        @Override // com.arlosoft.macrodroid.editscreen.HeaderCallback
        public void onAdd() {
            Macro macro = null;
            EditMacroActivity.this.A = null;
            Intent intent = new Intent(EditMacroActivity.this, AddActionActivity.class);
            Macro macro2 = EditMacroActivity.this.f11735f;
            if (macro2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("macro");
            } else {
                macro = macro2;
            }
            intent.putExtra("MacroId", macro.getId());
            EditMacroActivity.this.startActivityForResult(intent, 909091);
        }

        @Override // com.arlosoft.macrodroid.editscreen.HeaderCallback
        public void onPaste() {
            EditMacroActivity.this.w0();
        }
    };
    @NotNull
    private final EditMacroActivity$constraintHeaderCallback$1 M = new HeaderCallbackConstraint() { // from class: com.arlosoft.macrodroid.editscreen.EditMacroActivity$constraintHeaderCallback$1
        @Override // com.arlosoft.macrodroid.editscreen.HeaderCallback
        public void onAdd() {
            Intent intent = new Intent(EditMacroActivity.this, AddConstraintActivity.class);
            Macro macro = EditMacroActivity.this.f11735f;
            if (macro == null) {
                Intrinsics.throwUninitializedPropertyAccessException("macro");
                macro = null;
            }
            intent.putExtra("MacroId", macro.getId());
            EditMacroActivity.this.startActivityForResult(intent, 909091);
        }

        @Override // com.arlosoft.macrodroid.editscreen.HeaderCallbackConstraint
        public void onLogicItemChanged(boolean z3) {
            EditMacroActivity.this.f11741l = true;
            EditMacroActivity.this.D1();
            Macro macro = EditMacroActivity.this.f11735f;
            if (macro == null) {
                Intrinsics.throwUninitializedPropertyAccessException("macro");
                macro = null;
            }
            macro.setConstraintIsOrCondition(!z3);
        }

        @Override // com.arlosoft.macrodroid.editscreen.HeaderCallback
        public void onPaste() {
            EditMacroActivity.this.x0();
        }
    };
    @NotNull
    private final EditMacroActivity$localVarsHeaderCallback$1 N = new HeaderCallback() { // from class: com.arlosoft.macrodroid.editscreen.EditMacroActivity$localVarsHeaderCallback$1
        @Override // com.arlosoft.macrodroid.editscreen.HeaderCallback
        public void onAdd() {
            EditMacroActivity.this.e0();
        }

        @Override // com.arlosoft.macrodroid.editscreen.HeaderCallback
        public void onPaste() {
        }
    };

    /* compiled from: EditMacroActivity.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EditMacroActivity.kt */
    /* loaded from: classes3.dex */
    public static final class a extends Lambda implements Function1<Boolean, Unit> {
        final /* synthetic */ boolean $isDisable;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(boolean z3) {
            super(1);
            this.$isDisable = z3;
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
                EditMacroActivity.this.Y(this.$isDisable);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EditMacroActivity.kt */
    /* loaded from: classes3.dex */
    public static final class a0 extends Lambda implements Function1<SelectableItem, Unit> {

        /* renamed from: d  reason: collision with root package name */
        public static final a0 f11764d = new a0();

        a0() {
            super(1);
        }

        public final void a(@NotNull SelectableItem it) {
            Intrinsics.checkNotNullParameter(it, "it");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SelectableItem selectableItem) {
            a(selectableItem);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EditMacroActivity.kt */
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
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                EditMacroActivity.this.e0();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EditMacroActivity.kt */
    /* loaded from: classes3.dex */
    public static final class b0 extends Lambda implements Function1<SelectableItem, Unit> {

        /* renamed from: d  reason: collision with root package name */
        public static final b0 f11766d = new b0();

        b0() {
            super(1);
        }

        public final void a(@NotNull SelectableItem it) {
            Intrinsics.checkNotNullParameter(it, "it");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SelectableItem selectableItem) {
            a(selectableItem);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EditMacroActivity.kt */
    /* loaded from: classes3.dex */
    public static final class c extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        int label;

        c(Continuation<? super c> continuation) {
            super(3, continuation);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean c(EditMacroActivity editMacroActivity, MenuItem menuItem) {
            int itemId = menuItem.getItemId();
            if (itemId == R.id.menu_bottom_bar) {
                editMacroActivity.f11752w = 2;
            } else if (itemId == R.id.menu_hide) {
                editMacroActivity.f11752w = 0;
            } else if (itemId == R.id.menu_inline) {
                editMacroActivity.f11752w = 1;
            }
            Settings.setLocalVarsDisplayMode(editMacroActivity, editMacroActivity.f11752w);
            editMacroActivity.n1();
            return true;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: b */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new c(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            boolean z3;
            boolean z4;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                EditMacroActivity editMacroActivity = EditMacroActivity.this;
                IncludeVariablesBinding includeVariablesBinding = editMacroActivity.G;
                if (includeVariablesBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("includeVarsBinding");
                    includeVariablesBinding = null;
                }
                PopupMenu popupMenu = new PopupMenu(editMacroActivity, includeVariablesBinding.varTitleLayout);
                popupMenu.inflate(R.menu.local_vars_display_mode_menu);
                final EditMacroActivity editMacroActivity2 = EditMacroActivity.this;
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.arlosoft.macrodroid.editscreen.p0
                    @Override // android.widget.PopupMenu.OnMenuItemClickListener
                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        boolean c4;
                        c4 = EditMacroActivity.c.c(EditMacroActivity.this, menuItem);
                        return c4;
                    }
                });
                popupMenu.show();
                MenuItem findItem = popupMenu.getMenu().findItem(R.id.menu_hide);
                boolean z5 = false;
                if (EditMacroActivity.this.f11752w == 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                findItem.setChecked(z3);
                MenuItem findItem2 = popupMenu.getMenu().findItem(R.id.menu_inline);
                if (EditMacroActivity.this.f11752w == 1) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                findItem2.setChecked(z4);
                MenuItem findItem3 = popupMenu.getMenu().findItem(R.id.menu_bottom_bar);
                if (EditMacroActivity.this.f11752w == 2) {
                    z5 = true;
                }
                findItem3.setChecked(z5);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EditMacroActivity.kt */
    /* loaded from: classes3.dex */
    public static final class c0 extends Lambda implements Function1<List<? extends SelectableItem>, Unit> {
        c0() {
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
            EditMacroActivity.this.setHasEdited();
        }
    }

    /* compiled from: EditMacroActivity.kt */
    /* loaded from: classes3.dex */
    static final class d extends Lambda implements Function1<String, Unit> {
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
            EditMacroActivity.this.f11741l = true;
            EditMacroActivity.this.D1();
        }
    }

    /* compiled from: EditMacroActivity.kt */
    /* loaded from: classes3.dex */
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
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                BottomSheetBehavior bottomSheetBehavior = EditMacroActivity.this.f11748s;
                BottomSheetBehavior bottomSheetBehavior2 = null;
                if (bottomSheetBehavior == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bottomSheetBehavior");
                    bottomSheetBehavior = null;
                }
                if (bottomSheetBehavior.getState() == 3) {
                    BottomSheetBehavior bottomSheetBehavior3 = EditMacroActivity.this.f11748s;
                    if (bottomSheetBehavior3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("bottomSheetBehavior");
                    } else {
                        bottomSheetBehavior2 = bottomSheetBehavior3;
                    }
                    bottomSheetBehavior2.setState(4);
                } else {
                    BottomSheetBehavior bottomSheetBehavior4 = EditMacroActivity.this.f11748s;
                    if (bottomSheetBehavior4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("bottomSheetBehavior");
                    } else {
                        bottomSheetBehavior2 = bottomSheetBehavior4;
                    }
                    bottomSheetBehavior2.setState(3);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: EditMacroActivity.kt */
    /* loaded from: classes3.dex */
    static final class f extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
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
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ActivityEditMacroBinding activityEditMacroBinding = null;
                if (EditMacroActivity.this.E > 0) {
                    EditMacroActivity editMacroActivity = EditMacroActivity.this;
                    editMacroActivity.E--;
                    ActivityEditMacroBinding activityEditMacroBinding2 = EditMacroActivity.this.H;
                    if (activityEditMacroBinding2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        activityEditMacroBinding2 = null;
                    }
                    RecyclerView.LayoutManager layoutManager = activityEditMacroBinding2.allItemsList.getLayoutManager();
                    Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                    ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(((Number) EditMacroActivity.this.D.get(EditMacroActivity.this.E)).intValue(), 0);
                }
                if (EditMacroActivity.this.E == 0) {
                    ActivityEditMacroBinding activityEditMacroBinding3 = EditMacroActivity.this.H;
                    if (activityEditMacroBinding3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        activityEditMacroBinding3 = null;
                    }
                    activityEditMacroBinding3.searchUpButton.setAlpha(0.3f);
                }
                if (EditMacroActivity.this.E < EditMacroActivity.this.D.size() - 1) {
                    ActivityEditMacroBinding activityEditMacroBinding4 = EditMacroActivity.this.H;
                    if (activityEditMacroBinding4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        activityEditMacroBinding = activityEditMacroBinding4;
                    }
                    activityEditMacroBinding.searchDownButton.setAlpha(1.0f);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: EditMacroActivity.kt */
    /* loaded from: classes3.dex */
    static final class g extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
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
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ActivityEditMacroBinding activityEditMacroBinding = null;
                if (EditMacroActivity.this.E < EditMacroActivity.this.D.size() - 1) {
                    EditMacroActivity.this.E++;
                    ActivityEditMacroBinding activityEditMacroBinding2 = EditMacroActivity.this.H;
                    if (activityEditMacroBinding2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        activityEditMacroBinding2 = null;
                    }
                    RecyclerView.LayoutManager layoutManager = activityEditMacroBinding2.allItemsList.getLayoutManager();
                    Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                    ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(((Number) EditMacroActivity.this.D.get(EditMacroActivity.this.E)).intValue(), 0);
                }
                if (EditMacroActivity.this.E == EditMacroActivity.this.D.size() - 1) {
                    ActivityEditMacroBinding activityEditMacroBinding3 = EditMacroActivity.this.H;
                    if (activityEditMacroBinding3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        activityEditMacroBinding3 = null;
                    }
                    activityEditMacroBinding3.searchDownButton.setAlpha(0.3f);
                }
                if (EditMacroActivity.this.E > 0) {
                    ActivityEditMacroBinding activityEditMacroBinding4 = EditMacroActivity.this.H;
                    if (activityEditMacroBinding4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        activityEditMacroBinding = activityEditMacroBinding4;
                    }
                    activityEditMacroBinding.searchUpButton.setAlpha(1.0f);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: EditMacroActivity.kt */
    /* loaded from: classes3.dex */
    static final class h extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        int label;

        h(Continuation<? super h> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new h(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                EditMacroActivity editMacroActivity = EditMacroActivity.this;
                boolean z3 = true;
                ActivityEditMacroBinding activityEditMacroBinding = null;
                if (editMacroActivity.F) {
                    EditMacroActivity.this.p0(true);
                    ActivityEditMacroBinding activityEditMacroBinding2 = EditMacroActivity.this.H;
                    if (activityEditMacroBinding2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        activityEditMacroBinding2 = null;
                    }
                    activityEditMacroBinding2.expandCollapseButton.setImageResource(R.drawable.unfold_less_horizontal);
                    ActivityEditMacroBinding activityEditMacroBinding3 = EditMacroActivity.this.H;
                    if (activityEditMacroBinding3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        activityEditMacroBinding = activityEditMacroBinding3;
                    }
                    TooltipCompat.setTooltipText(activityEditMacroBinding.expandCollapseButton, EditMacroActivity.this.getString(R.string.button_description_collapse));
                    z3 = false;
                } else {
                    EditMacroActivity.this.p0(false);
                    ActivityEditMacroBinding activityEditMacroBinding4 = EditMacroActivity.this.H;
                    if (activityEditMacroBinding4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        activityEditMacroBinding4 = null;
                    }
                    activityEditMacroBinding4.expandCollapseButton.setImageResource(R.drawable.unfold_more_horizontal);
                    ActivityEditMacroBinding activityEditMacroBinding5 = EditMacroActivity.this.H;
                    if (activityEditMacroBinding5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        activityEditMacroBinding = activityEditMacroBinding5;
                    }
                    TooltipCompat.setTooltipText(activityEditMacroBinding.expandCollapseButton, EditMacroActivity.this.getString(R.string.button_description_expand));
                }
                editMacroActivity.F = z3;
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: EditMacroActivity.kt */
    /* loaded from: classes3.dex */
    static final class i extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
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
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                EditMacroActivity.this.onBackPressed(true);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: EditMacroActivity.kt */
    /* loaded from: classes3.dex */
    static final class j extends Lambda implements Function1<String, Unit> {
        j() {
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
            EditMacroActivity.this.f11741l = true;
            EditMacroActivity.this.D1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EditMacroActivity.kt */
    /* loaded from: classes3.dex */
    public static final class k extends Lambda implements Function1<PermissionStatus, Unit> {
        final /* synthetic */ String[] $permissionsRequired;
        final /* synthetic */ EditMacroActivity this$0;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: EditMacroActivity.kt */
        /* loaded from: classes3.dex */
        public static final class a extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ EditMacroActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(EditMacroActivity editMacroActivity, Continuation<? super a> continuation) {
                super(3, continuation);
                this.this$0 = editMacroActivity;
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
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    ActivityEditMacroBinding activityEditMacroBinding = this.this$0.H;
                    if (activityEditMacroBinding == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        activityEditMacroBinding = null;
                    }
                    activityEditMacroBinding.nearbySharePanel.collapse();
                    this.this$0.getNearbyHelper().stopDiscovery();
                    this.this$0.getNearbyHelper().disconnect();
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        k(String[] strArr, EditMacroActivity editMacroActivity) {
            super(1);
            this.$permissionsRequired = strArr;
            this.this$0 = editMacroActivity;
        }

        public final void a(@NotNull PermissionStatus it) {
            Intrinsics.checkNotNullParameter(it, "it");
            if (it.getGranted().containsAll(ArraysKt.toList(this.$permissionsRequired))) {
                ActivityEditMacroBinding activityEditMacroBinding = this.this$0.H;
                if (activityEditMacroBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityEditMacroBinding = null;
                }
                activityEditMacroBinding.nearbySharePanel.expand();
                NearbyHelper nearbyHelper = this.this$0.getNearbyHelper();
                Macro macro = this.this$0.f11735f;
                if (macro == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("macro");
                    macro = null;
                }
                nearbyHelper.initialiseHelperForSending(macro, this.this$0.J);
                ActivityEditMacroBinding activityEditMacroBinding2 = this.this$0.H;
                if (activityEditMacroBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityEditMacroBinding2 = null;
                }
                ImageView imageView = activityEditMacroBinding2.dismissButton;
                Intrinsics.checkNotNullExpressionValue(imageView, "binding.dismissButton");
                ViewExtensionsKt.onClick$default(imageView, null, new a(this.this$0, null), 1, null);
                this.this$0.getNearbyHelper().startDiscovery(NearbyHelper.SERVICE_ID_MACRO_SHARE);
                this.this$0.C = true;
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PermissionStatus permissionStatus) {
            a(permissionStatus);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EditMacroActivity.kt */
    /* loaded from: classes3.dex */
    public static final class l extends Lambda implements Function1<String, Unit> {
        final /* synthetic */ EditText $category;
        final /* synthetic */ Button $okButton;
        final /* synthetic */ EditMacroActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        l(Button button, EditText editText, EditMacroActivity editMacroActivity) {
            super(1);
            this.$okButton = button;
            this.$category = editText;
            this.this$0 = editMacroActivity;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull String it) {
            Intrinsics.checkNotNullParameter(it, "it");
            Button button = this.$okButton;
            if (button != null) {
                Editable text = this.$category.getText();
                Intrinsics.checkNotNullExpressionValue(text, "category.text");
                button.setEnabled(text.length() > 0);
            }
            this.this$0.f11741l = true;
            this.this$0.D1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EditMacroActivity.kt */
    /* loaded from: classes3.dex */
    public static final class m extends Lambda implements Function1<SelectableItem, Unit> {
        m() {
            super(1);
        }

        public final void a(@NotNull SelectableItem item) {
            Intrinsics.checkNotNullParameter(item, "item");
            EditMacroActivity.this.x1(item);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SelectableItem selectableItem) {
            a(selectableItem);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EditMacroActivity.kt */
    /* loaded from: classes3.dex */
    public static final class n extends Lambda implements Function1<SelectableItem, Unit> {
        n() {
            super(1);
        }

        public final void a(@NotNull SelectableItem item) {
            Intrinsics.checkNotNullParameter(item, "item");
            EditMacroActivity.this.A1(item);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SelectableItem selectableItem) {
            a(selectableItem);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EditMacroActivity.kt */
    /* loaded from: classes3.dex */
    public static final class o extends Lambda implements Function1<SelectableItem, Unit> {
        o() {
            super(1);
        }

        public final void a(@NotNull SelectableItem item) {
            Intrinsics.checkNotNullParameter(item, "item");
            EditMacroActivity.this.q0(item);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SelectableItem selectableItem) {
            a(selectableItem);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EditMacroActivity.kt */
    /* loaded from: classes3.dex */
    public static final class p extends Lambda implements Function1<MacroDroidVariable, Unit> {
        p() {
            super(1);
        }

        public final void a(@NotNull MacroDroidVariable it) {
            Intrinsics.checkNotNullParameter(it, "it");
            EditMacroActivity.this.B1(it);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MacroDroidVariable macroDroidVariable) {
            a(macroDroidVariable);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EditMacroActivity.kt */
    /* loaded from: classes3.dex */
    public static final class q extends Lambda implements Function0<Unit> {
        q() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ActivityEditMacroBinding activityEditMacroBinding = EditMacroActivity.this.H;
            if (activityEditMacroBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityEditMacroBinding = null;
            }
            activityEditMacroBinding.allItemsList.setItemAnimator(new EditMacroItemAnimator());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EditMacroActivity.kt */
    /* loaded from: classes3.dex */
    public static final class r extends Lambda implements Function1<List<? extends ItemType>, Unit> {
        r() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends ItemType> list) {
            invoke2(list);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull List<? extends ItemType> it) {
            Intrinsics.checkNotNullParameter(it, "it");
            ActivityEditMacroBinding activityEditMacroBinding = EditMacroActivity.this.H;
            if (activityEditMacroBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityEditMacroBinding = null;
            }
            activityEditMacroBinding.allItemsList.setItemAnimator(null);
            EditMacroActivity.this.setHasEdited();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EditMacroActivity.kt */
    /* loaded from: classes3.dex */
    public static final class s extends Lambda implements Function1<MacroDroidVariable, Unit> {
        s() {
            super(1);
        }

        public final void a(@NotNull MacroDroidVariable it) {
            Intrinsics.checkNotNullParameter(it, "it");
            EditMacroActivity.this.B1(it);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MacroDroidVariable macroDroidVariable) {
            a(macroDroidVariable);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EditMacroActivity.kt */
    /* loaded from: classes3.dex */
    public static final class t extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ SelectableItemsListAdapter<Action> $extractActionsAdapter;
        final /* synthetic */ RecyclerView $extractActionsList;
        final /* synthetic */ LinearLayoutManager $layoutManager;
        int label;
        final /* synthetic */ EditMacroActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        t(SelectableItemsListAdapter<Action> selectableItemsListAdapter, LinearLayoutManager linearLayoutManager, RecyclerView recyclerView, EditMacroActivity editMacroActivity, Continuation<? super t> continuation) {
            super(3, continuation);
            this.$extractActionsAdapter = selectableItemsListAdapter;
            this.$layoutManager = linearLayoutManager;
            this.$extractActionsList = recyclerView;
            this.this$0 = editMacroActivity;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new t(this.$extractActionsAdapter, this.$layoutManager, this.$extractActionsList, this.this$0, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                int moveTopHighlight = this.$extractActionsAdapter.moveTopHighlight(true);
                if (moveTopHighlight < this.$layoutManager.findFirstCompletelyVisibleItemPosition()) {
                    this.$extractActionsList.scrollToPosition(moveTopHighlight);
                }
                this.this$0.F1(this.$extractActionsAdapter);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EditMacroActivity.kt */
    /* loaded from: classes3.dex */
    public static final class u extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ SelectableItemsListAdapter<Action> $extractActionsAdapter;
        final /* synthetic */ RecyclerView $extractActionsList;
        final /* synthetic */ LinearLayoutManager $layoutManager;
        int label;
        final /* synthetic */ EditMacroActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        u(SelectableItemsListAdapter<Action> selectableItemsListAdapter, LinearLayoutManager linearLayoutManager, RecyclerView recyclerView, EditMacroActivity editMacroActivity, Continuation<? super u> continuation) {
            super(3, continuation);
            this.$extractActionsAdapter = selectableItemsListAdapter;
            this.$layoutManager = linearLayoutManager;
            this.$extractActionsList = recyclerView;
            this.this$0 = editMacroActivity;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new u(this.$extractActionsAdapter, this.$layoutManager, this.$extractActionsList, this.this$0, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                int moveTopHighlight = this.$extractActionsAdapter.moveTopHighlight(false);
                if (moveTopHighlight > this.$layoutManager.findLastCompletelyVisibleItemPosition()) {
                    this.$extractActionsList.scrollToPosition(moveTopHighlight);
                }
                this.this$0.F1(this.$extractActionsAdapter);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EditMacroActivity.kt */
    /* loaded from: classes3.dex */
    public static final class v extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ SelectableItemsListAdapter<Action> $extractActionsAdapter;
        final /* synthetic */ RecyclerView $extractActionsList;
        final /* synthetic */ LinearLayoutManager $layoutManager;
        int label;
        final /* synthetic */ EditMacroActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        v(SelectableItemsListAdapter<Action> selectableItemsListAdapter, LinearLayoutManager linearLayoutManager, RecyclerView recyclerView, EditMacroActivity editMacroActivity, Continuation<? super v> continuation) {
            super(3, continuation);
            this.$extractActionsAdapter = selectableItemsListAdapter;
            this.$layoutManager = linearLayoutManager;
            this.$extractActionsList = recyclerView;
            this.this$0 = editMacroActivity;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new v(this.$extractActionsAdapter, this.$layoutManager, this.$extractActionsList, this.this$0, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                int moveBottomHighlght = this.$extractActionsAdapter.moveBottomHighlght(true);
                if (moveBottomHighlght < this.$layoutManager.findFirstCompletelyVisibleItemPosition()) {
                    this.$extractActionsList.scrollToPosition(moveBottomHighlght);
                }
                this.this$0.F1(this.$extractActionsAdapter);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EditMacroActivity.kt */
    /* loaded from: classes3.dex */
    public static final class w extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ SelectableItemsListAdapter<Action> $extractActionsAdapter;
        final /* synthetic */ RecyclerView $extractActionsList;
        final /* synthetic */ LinearLayoutManager $layoutManager;
        int label;
        final /* synthetic */ EditMacroActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        w(SelectableItemsListAdapter<Action> selectableItemsListAdapter, LinearLayoutManager linearLayoutManager, RecyclerView recyclerView, EditMacroActivity editMacroActivity, Continuation<? super w> continuation) {
            super(3, continuation);
            this.$extractActionsAdapter = selectableItemsListAdapter;
            this.$layoutManager = linearLayoutManager;
            this.$extractActionsList = recyclerView;
            this.this$0 = editMacroActivity;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new w(this.$extractActionsAdapter, this.$layoutManager, this.$extractActionsList, this.this$0, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                int moveBottomHighlght = this.$extractActionsAdapter.moveBottomHighlght(false);
                if (moveBottomHighlght > this.$layoutManager.findLastCompletelyVisibleItemPosition()) {
                    this.$extractActionsList.scrollToPosition(moveBottomHighlght);
                }
                this.this$0.F1(this.$extractActionsAdapter);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EditMacroActivity.kt */
    @SourceDebugExtension({"SMAP\nEditMacroActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EditMacroActivity.kt\ncom/arlosoft/macrodroid/editscreen/EditMacroActivity$showExtractToActionBlock$5\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,2586:1\n800#2,11:2587\n*S KotlinDebug\n*F\n+ 1 EditMacroActivity.kt\ncom/arlosoft/macrodroid/editscreen/EditMacroActivity$showExtractToActionBlock$5\n*L\n1585#1:2587,11\n*E\n"})
    /* loaded from: classes3.dex */
    public static final class x extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ TextView $actionBlockNameText;
        final /* synthetic */ AppCompatDialog $dialog;
        final /* synthetic */ SelectableItemsListAdapter<Action> $extractActionsAdapter;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        x(TextView textView, SelectableItemsListAdapter<Action> selectableItemsListAdapter, AppCompatDialog appCompatDialog, Continuation<? super x> continuation) {
            super(3, continuation);
            this.$actionBlockNameText = textView;
            this.$extractActionsAdapter = selectableItemsListAdapter;
            this.$dialog = appCompatDialog;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new x(this.$actionBlockNameText, this.$extractActionsAdapter, this.$dialog, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            boolean z3;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                EditMacroActivity.this.f11741l = true;
                CharSequence text = this.$actionBlockNameText.getText();
                Intrinsics.checkNotNullExpressionValue(text, "actionBlockNameText.text");
                if (text.length() == 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    EditMacroActivity editMacroActivity = EditMacroActivity.this;
                    Util.displayErrorDialog(editMacroActivity, editMacroActivity.getString(R.string.invalid_action_block), EditMacroActivity.this.getString(R.string.please_set_a_name));
                } else if (EditMacroActivity.this.n0(this.$actionBlockNameText.getText().toString())) {
                    EditMacroActivity editMacroActivity2 = EditMacroActivity.this;
                    Util.displayErrorDialog(editMacroActivity2, editMacroActivity2.getString(R.string.invalid_action_block), EditMacroActivity.this.getString(R.string.action_block_name_already_exists));
                } else if (this.$extractActionsAdapter.getInvalidExtraction()) {
                    EditMacroActivity editMacroActivity3 = EditMacroActivity.this;
                    Util.displayErrorDialog(editMacroActivity3, editMacroActivity3.getString(R.string.invalid_action_block), EditMacroActivity.this.getString(R.string.action_block_extract_invalid_control_flow));
                } else {
                    Range<Integer> highlightRange = this.$extractActionsAdapter.getHighlightRange();
                    if (highlightRange != null) {
                        EditMacroActivity editMacroActivity4 = EditMacroActivity.this;
                        TextView textView = this.$actionBlockNameText;
                        Macro macro = editMacroActivity4.f11735f;
                        if (macro == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("macro");
                            macro = null;
                        }
                        ArrayList<Action> actions = macro.getActions();
                        Integer lower = highlightRange.getLower();
                        Intrinsics.checkNotNullExpressionValue(lower, "range.lower");
                        List<Action> subList = actions.subList(lower.intValue(), highlightRange.getUpper().intValue() + 1);
                        Intrinsics.checkNotNullExpressionValue(subList, "macro.actions.subList(ra…e.lower, range.upper + 1)");
                        ArrayList arrayList = new ArrayList();
                        for (Object obj2 : subList) {
                            if (obj2 instanceof WaitUntilTriggerAction) {
                                arrayList.add(obj2);
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                            String string = editMacroActivity4.getString(R.string.action_block_extract_feature_x_not_available);
                            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.actio…_feature_x_not_available)");
                            String format = String.format(string, Arrays.copyOf(new Object[]{editMacroActivity4.getString(R.string.action_wait_until_trigger)}, 1));
                            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                            Util.displayErrorDialog(editMacroActivity4, editMacroActivity4.getString(R.string.invalid_action_block), format);
                            return Unit.INSTANCE;
                        }
                        Integer lower2 = highlightRange.getLower();
                        Intrinsics.checkNotNullExpressionValue(lower2, "range.lower");
                        int intValue = lower2.intValue();
                        Integer upper = highlightRange.getUpper();
                        Intrinsics.checkNotNullExpressionValue(upper, "range.upper");
                        Boxing.boxBoolean(editMacroActivity4.V0(intValue, upper.intValue(), textView.getText().toString()));
                    }
                    this.$dialog.dismiss();
                    EditMacroActivity.j1(EditMacroActivity.this, false, 1, null);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EditMacroActivity.kt */
    /* loaded from: classes3.dex */
    public static final class y extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ AppCompatDialog $dialog;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        y(AppCompatDialog appCompatDialog, Continuation<? super y> continuation) {
            super(3, continuation);
            this.$dialog = appCompatDialog;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new y(this.$dialog, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.$dialog.dismiss();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EditMacroActivity.kt */
    /* loaded from: classes3.dex */
    public static final class z extends Lambda implements Function1<SelectableItem, Unit> {

        /* renamed from: d  reason: collision with root package name */
        public static final z f11776d = new z();

        z() {
            super(1);
        }

        public final void a(@NotNull SelectableItem it) {
            Intrinsics.checkNotNullParameter(it, "it");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SelectableItem selectableItem) {
            a(selectableItem);
            return Unit.INSTANCE;
        }
    }

    private final void A0() {
        Macro macro = this.f11735f;
        ActivityEditMacroBinding activityEditMacroBinding = null;
        if (macro == null) {
            Intrinsics.throwUninitializedPropertyAccessException("macro");
            macro = null;
        }
        boolean isCompleted = macro.isCompleted();
        int i4 = R.color.primary;
        if (!isCompleted) {
            if (this.f11746q) {
                i4 = R.color.template_primary;
            }
            int color = ContextCompat.getColor(this, i4);
            ActivityEditMacroBinding activityEditMacroBinding2 = this.H;
            if (activityEditMacroBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityEditMacroBinding2 = null;
            }
            activityEditMacroBinding2.acceptButton.setImageResource(R.drawable.ic_playlist_plus_white_24dp);
            ActivityEditMacroBinding activityEditMacroBinding3 = this.H;
            if (activityEditMacroBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityEditMacroBinding = activityEditMacroBinding3;
            }
            Drawable mutate = DrawableCompat.wrap(activityEditMacroBinding.acceptButton.getDrawable()).mutate();
            Intrinsics.checkNotNullExpressionValue(mutate, "wrap(binding.acceptButton.drawable).mutate()");
            DrawableCompat.setTint(mutate, color);
            return;
        }
        Drawable mutate2 = DrawableCompat.wrap(getResources().getDrawable(R.drawable.ic_action_accept_white)).mutate();
        Intrinsics.checkNotNullExpressionValue(mutate2, "wrap(acceptDrawable).mutate()");
        DrawableCompat.setTint(mutate2, ContextCompat.getColor(this, R.color.primary));
        ActivityEditMacroBinding activityEditMacroBinding4 = this.H;
        if (activityEditMacroBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityEditMacroBinding = activityEditMacroBinding4;
        }
        activityEditMacroBinding.acceptButton.setImageResource(R.drawable.ic_action_accept_white);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A1(SelectableItem selectableItem) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, t0(selectableItem));
        builder.setTitle(selectableItem.getName());
        if (selectableItem.getInfo().supportsAdbHack()) {
            builder.setMessage(Util.appendAdbHackInfo(this, selectableItem.getHelpInfo()));
        } else {
            builder.setMessage(selectableItem.getHelpInfo());
        }
        builder.setNegativeButton(17039370, (DialogInterface.OnClickListener) null);
        Util.linkifyDialogText(builder.show());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B0(EditMacroActivity this$0, MacroDroidVariable variable, VariableValue newValue, VariableValue oldValue, long j4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(variable, "variable");
        Intrinsics.checkNotNullParameter(newValue, "newValue");
        Intrinsics.checkNotNullParameter(oldValue, "oldValue");
        this$0.l1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B1(final MacroDroidVariable macroDroidVariable) {
        VariableHelper variableHelper = VariableHelper.INSTANCE;
        Macro macro = this.f11735f;
        if (macro == null) {
            Intrinsics.throwUninitializedPropertyAccessException("macro");
            macro = null;
        }
        variableHelper.showLocalVarsDialog(this, macroDroidVariable, macro, R.style.Theme_App_Dialog_LocalVariables_NoTitle, R.style.Theme_App_Dialog_LocalVariables, new DictionaryEventListener() { // from class: com.arlosoft.macrodroid.editscreen.EditMacroActivity$showLocalVarsDialog$1
            @Override // com.arlosoft.macrodroid.variables.DictionaryEventListener
            public void dictionaryDeleted() {
                Macro macro2 = EditMacroActivity.this.f11735f;
                if (macro2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("macro");
                    macro2 = null;
                }
                macro2.getLocalVariables().remove(macroDroidVariable);
                EditMacroActivity.this.f11741l = true;
                EditMacroActivity.this.D1();
                EditMacroActivity.this.refresh(false);
            }

            @Override // com.arlosoft.macrodroid.variables.DictionaryEventListener
            public void entriesCleared() {
                EditMacroActivity.this.f11741l = true;
                EditMacroActivity.this.D1();
                EditMacroActivity.this.refresh(false);
            }

            @Override // com.arlosoft.macrodroid.variables.DictionaryEventListener
            public void entryRemoved(@NotNull VariableValue.DictionaryEntry removedEntry) {
                Intrinsics.checkNotNullParameter(removedEntry, "removedEntry");
                EditMacroActivity.this.f11741l = true;
                EditMacroActivity.this.D1();
                EditMacroActivity.this.refresh(false);
            }

            @Override // com.arlosoft.macrodroid.variables.DictionaryEventListener
            public void entryUpdated(@NotNull VariableValue.DictionaryEntry newEntry, @Nullable VariableValue.DictionaryEntry dictionaryEntry) {
                VariableValue variableValue;
                Intrinsics.checkNotNullParameter(newEntry, "newEntry");
                EditMacroActivity.this.f11741l = true;
                EditMacroActivity.this.D1();
                EditMacroActivity.this.refresh(false);
                Macro macro2 = EditMacroActivity.this.f11735f;
                if (macro2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("macro");
                    macro2 = null;
                }
                Set<VariableUpdatedListener> localVariableUpdatedListeners = macro2.getLocalVariableUpdatedListeners();
                Intrinsics.checkNotNullExpressionValue(localVariableUpdatedListeners, "macro.localVariableUpdatedListeners");
                EditMacroActivity editMacroActivity = EditMacroActivity.this;
                MacroDroidVariable macroDroidVariable2 = macroDroidVariable;
                synchronized (localVariableUpdatedListeners) {
                    Macro macro3 = editMacroActivity.f11735f;
                    if (macro3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("macro");
                        macro3 = null;
                    }
                    Set<VariableUpdatedListener> localVariableUpdatedListeners2 = macro3.getLocalVariableUpdatedListeners();
                    if (localVariableUpdatedListeners2 != null) {
                        Intrinsics.checkNotNullExpressionValue(localVariableUpdatedListeners2, "localVariableUpdatedListeners");
                        for (VariableUpdatedListener variableUpdatedListener : localVariableUpdatedListeners2) {
                            if (dictionaryEntry != null) {
                                variableValue = dictionaryEntry;
                            } else {
                                variableValue = VariableValue.Empty.INSTANCE;
                            }
                            Macro macro4 = editMacroActivity.f11735f;
                            if (macro4 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("macro");
                                macro4 = null;
                            }
                            variableUpdatedListener.variableValueUpdated(macroDroidVariable2, newEntry, variableValue, macro4.getGUID());
                        }
                        Unit unit = Unit.INSTANCE;
                    }
                }
            }

            @Override // com.arlosoft.macrodroid.variables.DictionaryEventListener
            public void refreshRequired() {
                EditMacroActivity.this.f11741l = true;
                EditMacroActivity.this.D1();
                EditMacroActivity.this.refresh(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C0(DialogInterface dialogInterface, int i4) {
        dialogInterface.dismiss();
    }

    private final String C1(String str) {
        return new Regex("[\\\\/:*?\"<>|]").replace(StringsKt.replace$default(str, ' ', '_', false, 4, (Object) null), "-");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D0(EditMacroActivity this$0, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        h0(this$0, false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D1() {
        boolean z3;
        ActivityEditMacroBinding activityEditMacroBinding = null;
        if (this.f11752w == 2) {
            BottomSheetBehavior<View> bottomSheetBehavior = this.f11748s;
            if (bottomSheetBehavior == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomSheetBehavior");
                bottomSheetBehavior = null;
            }
            if (bottomSheetBehavior.getState() == 3) {
                ActivityEditMacroBinding activityEditMacroBinding2 = this.H;
                if (activityEditMacroBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityEditMacroBinding2 = null;
                }
                if (activityEditMacroBinding2.acceptButton.isShown()) {
                    ActivityEditMacroBinding activityEditMacroBinding3 = this.H;
                    if (activityEditMacroBinding3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        activityEditMacroBinding3 = null;
                    }
                    activityEditMacroBinding3.acceptButton.hide();
                    ActivityEditMacroBinding activityEditMacroBinding4 = this.H;
                    if (activityEditMacroBinding4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        activityEditMacroBinding = activityEditMacroBinding4;
                    }
                    FloatingActionButton floatingActionButton = activityEditMacroBinding.acceptButton;
                    Intrinsics.checkNotNullExpressionValue(floatingActionButton, "binding.acceptButton");
                    floatingActionButton.setVisibility(8);
                    return;
                }
                return;
            }
        }
        Macro macro = this.f11735f;
        if (macro == null) {
            Intrinsics.throwUninitializedPropertyAccessException("macro");
            macro = null;
        }
        if (!macro.isCompleted()) {
            Macro macro2 = this.f11735f;
            if (macro2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("macro");
                macro2 = null;
            }
            if (macro2.isValid()) {
                ActivityEditMacroBinding activityEditMacroBinding5 = this.H;
                if (activityEditMacroBinding5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityEditMacroBinding5 = null;
                }
                Editable text = activityEditMacroBinding5.macroNameText.getText();
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
                    ActivityEditMacroBinding activityEditMacroBinding6 = this.H;
                    if (activityEditMacroBinding6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        activityEditMacroBinding = activityEditMacroBinding6;
                    }
                    activityEditMacroBinding.acceptButton.show();
                    return;
                }
            }
            if (!this.f11739j) {
                ActivityEditMacroBinding activityEditMacroBinding7 = this.H;
                if (activityEditMacroBinding7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    activityEditMacroBinding = activityEditMacroBinding7;
                }
                activityEditMacroBinding.acceptButton.show();
            }
        } else if (!this.f11741l) {
            ActivityEditMacroBinding activityEditMacroBinding8 = this.H;
            if (activityEditMacroBinding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityEditMacroBinding8 = null;
            }
            if (activityEditMacroBinding8.acceptButton.isShown()) {
                ActivityEditMacroBinding activityEditMacroBinding9 = this.H;
                if (activityEditMacroBinding9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityEditMacroBinding9 = null;
                }
                activityEditMacroBinding9.acceptButton.hide();
                ActivityEditMacroBinding activityEditMacroBinding10 = this.H;
                if (activityEditMacroBinding10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    activityEditMacroBinding = activityEditMacroBinding10;
                }
                FloatingActionButton floatingActionButton2 = activityEditMacroBinding.acceptButton;
                Intrinsics.checkNotNullExpressionValue(floatingActionButton2, "binding.acceptButton");
                floatingActionButton2.setVisibility(8);
            }
        } else {
            ActivityEditMacroBinding activityEditMacroBinding11 = this.H;
            if (activityEditMacroBinding11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityEditMacroBinding = activityEditMacroBinding11;
            }
            activityEditMacroBinding.acceptButton.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E0(DialogInterface dialogInterface, int i4) {
        dialogInterface.dismiss();
    }

    private final void E1() {
        AllSelectableItemsListAdapter allSelectableItemsListAdapter;
        AllSelectableItemsListAdapter allSelectableItemsListAdapter2;
        SelectableItem copyItem = CopyHelper.copyItem();
        if (copyItem != null) {
            if (copyItem instanceof Trigger) {
                AllSelectableItemsListAdapter allSelectableItemsListAdapter3 = this.f11738i;
                if (allSelectableItemsListAdapter3 != null) {
                    allSelectableItemsListAdapter3.setPasteButtonVisibility(PasteButtonVisibilty.TRIGGER);
                }
            } else if (copyItem instanceof Action) {
                AllSelectableItemsListAdapter allSelectableItemsListAdapter4 = this.f11738i;
                if (allSelectableItemsListAdapter4 != null) {
                    allSelectableItemsListAdapter4.setPasteButtonVisibility(PasteButtonVisibilty.ACTION);
                }
            } else if ((copyItem instanceof Constraint) && (allSelectableItemsListAdapter2 = this.f11738i) != null) {
                allSelectableItemsListAdapter2.setPasteButtonVisibility(PasteButtonVisibilty.CONSTRAINT);
            }
        } else if (CopyHelper.copyItemList() != null && (allSelectableItemsListAdapter = this.f11738i) != null) {
            allSelectableItemsListAdapter.setPasteButtonVisibility(PasteButtonVisibilty.ACTION);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F0(EditMacroActivity this$0, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        h0(this$0, false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F1(SelectableItemsListAdapter<Action> selectableItemsListAdapter) {
        Range<Integer> highlightRange = selectableItemsListAdapter.getHighlightRange();
        Intrinsics.checkNotNull(highlightRange);
        Macro macro = this.f11735f;
        if (macro == null) {
            Intrinsics.throwUninitializedPropertyAccessException("macro");
            macro = null;
        }
        ArrayList<Action> actions = macro.getActions();
        Integer lower = highlightRange.getLower();
        Intrinsics.checkNotNullExpressionValue(lower, "range.lower");
        boolean z3 = true;
        List<Action> subList = actions.subList(lower.intValue(), highlightRange.getUpper().intValue() + 1);
        Intrinsics.checkNotNullExpressionValue(subList, "macro.actions.subList(ra…e.lower, range.upper + 1)");
        if (Action.checkActionsFlowControl(subList) < 0) {
            z3 = false;
        }
        selectableItemsListAdapter.setInvalidExtraction(z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G0(EditMacroActivity this$0, int i4, int i5, boolean z3, DialogInterface dialogInterface, int i6) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.getPremiumStatusHandler().getPremiumStatus().isPro() && i4 > i5) {
            Util.showMacroLimitReached(this$0, this$0.getRemoteConfig());
            return;
        }
        Macro macro = this$0.f11735f;
        if (macro == null) {
            Intrinsics.throwUninitializedPropertyAccessException("macro");
            macro = null;
        }
        this$0.o1(!macro.isEnabled());
        this$0.s0();
        this$0.r0(z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H0(DialogInterface dialogInterface, int i4) {
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I0(EditMacroActivity this$0, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        h0(this$0, false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J0(EditMacroActivity this$0, int i4, int i5, DialogInterface dialogInterface, int i6) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.getPremiumStatusHandler().getPremiumStatus().isPro() && i4 > i5) {
            Util.showMacroLimitReached(this$0, this$0.getRemoteConfig());
        } else {
            this$0.v0(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K0(EditMacroActivity this$0, boolean z3, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.g0(z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L0(EditMacroActivity this$0, float f4, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i4 == 0) {
            this$0.s0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M0(EditMacroActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.v0(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean N0(EditMacroActivity this$0, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ActivityEditMacroBinding activityEditMacroBinding = this$0.H;
        if (activityEditMacroBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityEditMacroBinding = null;
        }
        activityEditMacroBinding.macroNameText.setFocusableInTouchMode(true);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O0(EditMacroActivity this$0, boolean z3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!z3) {
            ActivityEditMacroBinding activityEditMacroBinding = this$0.H;
            if (activityEditMacroBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityEditMacroBinding = null;
            }
            activityEditMacroBinding.macroNameText.clearFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean P0(EditMacroActivity this$0, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ActivityEditMacroBinding activityEditMacroBinding = this$0.H;
        if (activityEditMacroBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityEditMacroBinding = null;
        }
        activityEditMacroBinding.macroDescription.setCursorVisible(true);
        return false;
    }

    private final void Q0() {
        TriggerContextInfo triggerContextInfo;
        try {
            Macro macro = this.f11735f;
            if (macro == null) {
                Intrinsics.throwUninitializedPropertyAccessException("macro");
                macro = null;
            }
            String str = "TESTING MACRO:" + macro.getName();
            Macro macro2 = this.f11735f;
            if (macro2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("macro");
                macro2 = null;
            }
            SystemLog.logInfo(str, macro2.getGUID());
            Macro macro3 = this.f11735f;
            if (macro3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("macro");
                macro3 = null;
            }
            if (macro3.getTriggerList().size() == 0) {
                triggerContextInfo = new TriggerContextInfo(new EmptyTrigger());
            } else {
                Macro macro4 = this.f11735f;
                if (macro4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("macro");
                    macro4 = null;
                }
                triggerContextInfo = new TriggerContextInfo(macro4.getTriggerList().get(0));
            }
            Macro macro5 = this.f11735f;
            if (macro5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("macro");
                macro5 = null;
            }
            macro5.setTriggerThatInvoked(null);
            Macro macro6 = this.f11735f;
            if (macro6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("macro");
                macro6 = null;
            }
            macro6.invokeActions(triggerContextInfo, true);
        } catch (Exception unused) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(R.string.macro_test_failed);
            builder.setMessage(R.string.macro_cannot_be_run_without_trigger);
            builder.setPositiveButton(17039370, (DialogInterface.OnClickListener) null);
            builder.show();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v13 */
    private final void R0() {
        ScreenShotHelper screenShotHelper = ScreenShotHelper.INSTANCE;
        ActivityEditMacroBinding activityEditMacroBinding = this.H;
        FileOutputStream fileOutputStream = 0;
        if (activityEditMacroBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityEditMacroBinding = null;
        }
        RecyclerView recyclerView = activityEditMacroBinding.allItemsList;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.allItemsList");
        Bitmap screenshotFromRecyclerView = screenShotHelper.getScreenshotFromRecyclerView(recyclerView);
        if (screenshotFromRecyclerView == null) {
            return;
        }
        File file = new File(getExternalFilesDir(null), "Export");
        if (!file.exists()) {
            file.mkdirs();
        }
        Gradients gradients = Gradients.INSTANCE;
        File filesDir = gradients.getContext().getFilesDir();
        Macro macro = this.f11735f;
        if (macro == null) {
            Intrinsics.throwUninitializedPropertyAccessException("macro");
            macro = null;
        }
        String name = macro.getName();
        Intrinsics.checkNotNullExpressionValue(name, "macro.name");
        File file2 = new File(filesDir, C1(name) + ".png");
        try {
            try {
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                    try {
                        screenshotFromRecyclerView.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream2);
                        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
                        arrayList.add(FileProvider.getUriForFile(gradients.getContext(), gradients.getContext().getPackageName() + ".provider", file2));
                        Intent intent = new Intent("android.intent.action.SEND_MULTIPLE");
                        intent.addFlags(268435456);
                        intent.setType("image/png");
                        intent.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList);
                        String string = getString(R.string.menu_share_as_image);
                        startActivity(Intent.createChooser(intent, string));
                        screenshotFromRecyclerView.recycle();
                        fileOutputStream2.close();
                        fileOutputStream = string;
                    } catch (Exception e4) {
                        e = e4;
                        fileOutputStream = fileOutputStream2;
                        e.printStackTrace();
                        screenshotFromRecyclerView.recycle();
                        fileOutputStream = fileOutputStream;
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                            fileOutputStream = fileOutputStream;
                        }
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        try {
                            screenshotFromRecyclerView.recycle();
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                        throw th;
                    }
                } catch (Exception e6) {
                    e = e6;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e7) {
            e7.printStackTrace();
        }
    }

    private final void S0() {
        Macro macro = this.f11735f;
        if (macro == null) {
            Intrinsics.throwUninitializedPropertyAccessException("macro");
            macro = null;
        }
        MacroUtils.onShareMacro(this, macro, getActionBlockStore());
    }

    private final void T(Macro macro) {
        Iterator<Trigger> it = macro.getTriggerList().iterator();
        while (it.hasNext()) {
            Trigger next = it.next();
            next.applyImport(true);
            for (Constraint constraint : next.getConstraints()) {
                constraint.setMacro(macro);
                constraint.applyImport(true);
            }
        }
        Iterator<Action> it2 = macro.getActions().iterator();
        while (it2.hasNext()) {
            Action next2 = it2.next();
            next2.applyImport(true);
            for (Constraint constraint2 : next2.getConstraints()) {
                constraint2.setMacro(macro);
                constraint2.applyImport(true);
            }
        }
        for (Constraint constraint3 : macro.getConstraints()) {
            constraint3.setMacro(macro);
            constraint3.applyImport(true);
        }
    }

    private final void T0() {
        String[] strArr;
        int i4 = Build.VERSION.SDK_INT;
        if (i4 < 31) {
            strArr = new String[]{"android.permission.ACCESS_FINE_LOCATION"};
        } else if (i4 < 33) {
            strArr = new String[]{"android.permission.BLUETOOTH_CONNECT", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION", "android.permission.BLUETOOTH_ADVERTISE", "android.permission.BLUETOOTH_CONNECT"};
        } else {
            strArr = new String[]{"android.permission.BLUETOOTH_SCAN", "android.permission.NEARBY_WIFI_DEVICES", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION", "android.permission.BLUETOOTH_ADVERTISE", "android.permission.BLUETOOTH_CONNECT"};
        }
        ExcuseMe.Companion.couldYouGive((Activity) this).permissionFor((String[]) Arrays.copyOf(strArr, strArr.length), new k(strArr, this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U(boolean z3) {
        HashSet hashSet = new HashSet();
        if (!z3) {
            Macro macro = this.f11735f;
            Macro macro2 = null;
            if (macro == null) {
                Intrinsics.throwUninitializedPropertyAccessException("macro");
                macro = null;
            }
            Iterator<Trigger> it = macro.getTriggerList().iterator();
            while (it.hasNext()) {
                Trigger next = it.next();
                String[] requiredPermissions = next.getRequiredPermissions();
                hashSet.addAll(Arrays.asList(Arrays.copyOf(requiredPermissions, requiredPermissions.length)));
                if (!next.hasAllSpecialPermissions(this)) {
                    return;
                }
            }
            Macro macro3 = this.f11735f;
            if (macro3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("macro");
                macro3 = null;
            }
            Iterator<Action> it2 = macro3.getActions().iterator();
            while (it2.hasNext()) {
                Action next2 = it2.next();
                String[] requiredPermissions2 = next2.getRequiredPermissions();
                hashSet.addAll(Arrays.asList(Arrays.copyOf(requiredPermissions2, requiredPermissions2.length)));
                if (!next2.hasAllSpecialPermissions(this)) {
                    return;
                }
            }
            Macro macro4 = this.f11735f;
            if (macro4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("macro");
            } else {
                macro2 = macro4;
            }
            for (Constraint constraint : macro2.getConstraints()) {
                String[] requiredPermissions3 = constraint.getRequiredPermissions();
                hashSet.addAll(Arrays.asList(Arrays.copyOf(requiredPermissions3, requiredPermissions3.length)));
                if (!constraint.hasAllSpecialPermissions(this)) {
                    return;
                }
            }
        }
        if (Build.VERSION.SDK_INT >= 23 && hashSet.size() != 0) {
            String[] strArr = (String[]) hashSet.toArray(new String[0]);
            Observable<Boolean> observeOn = new RxPermissions(this).request((String[]) Arrays.copyOf(strArr, strArr.length)).observeOn(AndroidSchedulers.mainThread());
            final a aVar = new a(z3);
            observeOn.subscribe(new Consumer() { // from class: com.arlosoft.macrodroid.editscreen.q
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    EditMacroActivity.V(Function1.this, obj);
                }
            });
            return;
        }
        Y(z3);
    }

    private final void U0() {
        try {
            Macro macro = this.f11735f;
            if (macro == null) {
                Intrinsics.throwUninitializedPropertyAccessException("macro");
                macro = null;
            }
            TriggerContextInfo triggerContextInfo = new TriggerContextInfo(macro.getTriggerList().get(0));
            Macro macro2 = this.f11735f;
            if (macro2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("macro");
                macro2 = null;
            }
            if (macro2.canInvoke(triggerContextInfo, true)) {
                Macro macro3 = this.f11735f;
                if (macro3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("macro");
                    macro3 = null;
                }
                String str = "TESTING MACRO: " + macro3.getName();
                Macro macro4 = this.f11735f;
                if (macro4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("macro");
                    macro4 = null;
                }
                SystemLog.logInfo(str, macro4.getGUID());
                Macro macro5 = this.f11735f;
                if (macro5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("macro");
                    macro5 = null;
                }
                macro5.setTriggerThatInvoked(null);
                Macro macro6 = this.f11735f;
                if (macro6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("macro");
                    macro6 = null;
                }
                macro6.invokeActions(triggerContextInfo, true);
            }
        } catch (Exception unused) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(R.string.macro_test_failed);
            builder.setMessage(R.string.macro_cannot_be_run_without_trigger);
            builder.setPositiveButton(17039370, (DialogInterface.OnClickListener) null);
            builder.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean V0(int i4, int i5, String str) {
        ActionBlock actionBlock = new ActionBlock();
        actionBlock.setName(str);
        Macro macro = null;
        if (i4 <= i5) {
            int i6 = i4;
            while (true) {
                Macro macro2 = this.f11735f;
                if (macro2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("macro");
                    macro2 = null;
                }
                actionBlock.addAction(macro2.getActions().get(i6));
                if (i6 == i5) {
                    break;
                }
                i6++;
            }
        }
        if (Action.checkActionsFlowControl(actionBlock.getActions()) >= 0) {
            return false;
        }
        getActionBlockStore().addActionBlock(actionBlock);
        if (i4 <= i5) {
            while (true) {
                Macro macro3 = this.f11735f;
                if (macro3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("macro");
                    macro3 = null;
                }
                macro3.getActions().remove(i5);
                if (i5 == i4) {
                    break;
                }
                i5--;
            }
        }
        ActionBlockAction actionBlockAction = new ActionBlockAction();
        actionBlockAction.setActionBlockName(str);
        actionBlockAction.setActionBlockId(actionBlock.getGUID());
        Macro macro4 = this.f11735f;
        if (macro4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("macro");
            macro4 = null;
        }
        macro4.getActions().add(i4, actionBlockAction);
        MacroStore macroStore = MacroStore.getInstance();
        Macro macro5 = this.f11735f;
        if (macro5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("macro");
        } else {
            macro = macro5;
        }
        macroStore.updateMacro(macro);
        Context applicationContext = getApplicationContext();
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = getString(R.string.action_block_created_popup_with_name);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.actio…_created_popup_with_name)");
        String format = String.format(string, Arrays.copyOf(new Object[]{str}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        ToastCompat.makeText(applicationContext, (CharSequence) format, 1).show();
        return true;
    }

    private final void W() {
        Macro macro = this.f11735f;
        Macro macro2 = null;
        if (macro == null) {
            Intrinsics.throwUninitializedPropertyAccessException("macro");
            macro = null;
        }
        Iterator<Trigger> it = macro.getTriggerList().iterator();
        while (it.hasNext()) {
            it.next().clearHasEdited();
        }
        Macro macro3 = this.f11735f;
        if (macro3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("macro");
            macro3 = null;
        }
        Iterator<Action> it2 = macro3.getActions().iterator();
        while (it2.hasNext()) {
            it2.next().clearHasEdited();
        }
        Macro macro4 = this.f11735f;
        if (macro4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("macro");
        } else {
            macro2 = macro4;
        }
        for (Constraint constraint : macro2.getConstraints()) {
            constraint.clearHasEdited();
        }
    }

    private final void W0(Macro macro) {
        Iterator<Trigger> it = macro.getTriggerList().iterator();
        while (it.hasNext()) {
            Trigger next = it.next();
            next.postApplyImport();
            for (Constraint constraint : next.getConstraints()) {
                constraint.setMacro(macro);
                constraint.postApplyImport();
            }
        }
        Iterator<Action> it2 = macro.getActions().iterator();
        while (it2.hasNext()) {
            Action next2 = it2.next();
            next2.postApplyImport();
            for (Constraint constraint2 : next2.getConstraints()) {
                constraint2.setMacro(macro);
                constraint2.postApplyImport();
            }
        }
        for (Constraint constraint3 : macro.getConstraints()) {
            constraint3.setMacro(macro);
            constraint3.postApplyImport();
        }
    }

    private final void X(AppCompatDialog appCompatDialog, EditText editText) {
        Editable editable;
        SelectableItem selectableItem = this.f11736g;
        if (selectableItem != null) {
            selectableItem.setHasCommentEdited(true);
        }
        SelectableItem selectableItem2 = this.f11736g;
        if (selectableItem2 != null) {
            if (editText != null) {
                editable = editText.getText();
            } else {
                editable = null;
            }
            selectableItem2.setComment(String.valueOf(editable));
        }
        appCompatDialog.dismiss();
        this.f11741l = true;
        refresh$default(this, false, 1, null);
    }

    private final void X0(Macro macro) {
        Iterator<Trigger> it = macro.getTriggerList().iterator();
        while (it.hasNext()) {
            Trigger next = it.next();
            next.preApplyImport();
            for (Constraint constraint : next.getConstraints()) {
                constraint.setMacro(macro);
                constraint.preApplyImport();
            }
        }
        Iterator<Action> it2 = macro.getActions().iterator();
        while (it2.hasNext()) {
            Action next2 = it2.next();
            next2.preApplyImport();
            for (Constraint constraint2 : next2.getConstraints()) {
                constraint2.setMacro(macro);
                constraint2.preApplyImport();
            }
        }
        for (Constraint constraint3 : macro.getConstraints()) {
            constraint3.setMacro(macro);
            constraint3.preApplyImport();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void Y(boolean r6) {
        /*
            r5 = this;
            r5.s0()
            boolean r0 = r5.f11746q
            r1 = 0
            if (r0 == 0) goto L3f
            android.content.Context r0 = r5.getApplicationContext()
            r2 = 2131952463(0x7f13034f, float:1.954137E38)
            java.lang.String r2 = r5.getString(r2)
            com.arlosoft.macrodroid.macro.Macro r3 = r5.f11735f
            if (r3 != 0) goto L1d
            java.lang.String r3 = "macro"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r3 = r1
        L1d:
            java.lang.String r3 = r3.getName()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r2)
            java.lang.String r2 = ": "
            r4.append(r2)
            r4.append(r3)
            java.lang.String r2 = r4.toString()
            r3 = 0
            me.drakeet.support.toast.ToastCompat r0 = me.drakeet.support.toast.ToastCompat.makeText(r0, r2, r3)
            r0.show()
        L3d:
            r0 = r1
            goto L49
        L3f:
            boolean r0 = r5.f11740k
            if (r0 == 0) goto L3d
            com.arlosoft.macrodroid.homescreen.NewHomeScreenActivity$Companion r0 = com.arlosoft.macrodroid.homescreen.NewHomeScreenActivity.Companion
            android.content.Intent r0 = r0.createMacroListIntent(r5)
        L49:
            if (r0 == 0) goto L50
            r2 = 131072(0x20000, float:1.83671E-40)
            r0.addFlags(r2)
        L50:
            boolean r6 = r5.o1(r6)
            if (r6 == 0) goto L5b
            com.arlosoft.macrodroid.advert.AdvertActivity$Companion r6 = com.arlosoft.macrodroid.advert.AdvertActivity.Companion
            r6.setShowAdvertOnNextResume(r1)
        L5b:
            if (r0 == 0) goto L60
            r5.startActivity(r0)
        L60:
            r5.finish()
            com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger.logFirstMacroOneTime()
            com.arlosoft.macrodroid.macro.MacroStore r6 = com.arlosoft.macrodroid.macro.MacroStore.getInstance()
            java.util.List r6 = r6.getAllCompletedMacros()
            int r6 = r6.size()
            r0 = 5
            if (r6 < r0) goto L78
            com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger.logFiveMacrosOneTime()
        L78:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.editscreen.EditMacroActivity.Y(boolean):void");
    }

    private final boolean Y0(int i4, List<? extends Constraint> list) {
        if (i4 == 10) {
            return true;
        }
        for (Constraint constraint : list) {
            Macro macro = this.f11735f;
            if (macro == null) {
                Intrinsics.throwUninitializedPropertyAccessException("macro");
                macro = null;
            }
            constraint.setMacro(macro);
            if (constraint instanceof LogicConstraint) {
                List<Constraint> constraints = constraint.getConstraints();
                Intrinsics.checkNotNullExpressionValue(constraints, "childConstraint.getConstraints()");
                if (Y0(i4 + 1, constraints)) {
                    return true;
                }
            }
        }
        return false;
    }

    private final void Z() {
        IncludeVariablesBinding includeVariablesBinding = this.G;
        if (includeVariablesBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("includeVarsBinding");
            includeVariablesBinding = null;
        }
        ImageButton imageButton = includeVariablesBinding.addVariableButton;
        Intrinsics.checkNotNullExpressionValue(imageButton, "includeVarsBinding.addVariableButton");
        ViewExtensionsKt.onClick$default(imageButton, null, new b(null), 1, null);
        l1();
    }

    private final void Z0() {
        int size = MacroStore.getInstance().getAllCompletedMacros().size();
        int freeMacros = Settings.getFreeMacros(this);
        if (!getPremiumStatusHandler().getPremiumStatus().isPro() && size >= freeMacros) {
            Util.showMacroLimitReached(this, getRemoteConfig());
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.clone_macro);
        builder.setMessage(R.string.do_you_wish_to_clone);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.editscreen.e0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                EditMacroActivity.a1(EditMacroActivity.this, dialogInterface, i4);
            }
        });
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.editscreen.i0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                EditMacroActivity.b1(dialogInterface, i4);
            }
        });
        builder.show();
    }

    private final void a0(final ParentAction parentAction) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.Theme_App_Dialog_Action);
        builder.setTitle(R.string.delete);
        builder.setMessage(getString(R.string.delete_condition_or_loop_including_children_confirm));
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.editscreen.f0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                EditMacroActivity.b0(EditMacroActivity.this, parentAction, dialogInterface, i4);
            }
        });
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.editscreen.g0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                EditMacroActivity.c0(dialogInterface, i4);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a1(EditMacroActivity this$0, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Macro macro = this$0.f11735f;
        if (macro == null) {
            Intrinsics.throwUninitializedPropertyAccessException("macro");
            macro = null;
        }
        Macro cloneMacro = macro.cloneMacro(true, true);
        this$0.s0();
        Intent intent = new Intent(this$0, EditMacroActivity.class);
        intent.putExtra("MacroId", cloneMacro.getId());
        intent.putExtra(Constants.EXTRA_IS_CLONE, true);
        this$0.startActivity(intent);
        this$0.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(EditMacroActivity this$0, ParentAction action, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(action, "$action");
        Macro macro = this$0.f11735f;
        if (macro == null) {
            Intrinsics.throwUninitializedPropertyAccessException("macro");
            macro = null;
        }
        List<RemovedItem> removedItems = macro.removeItemAndChildren(action);
        this$0.f11736g = null;
        this$0.f11741l = true;
        Intrinsics.checkNotNullExpressionValue(removedItems, "removedItems");
        this$0.showDeleteUndo(removedItems);
        refresh$default(this$0, false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b1(DialogInterface dialogInterface, int i4) {
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0(DialogInterface dialogInterface, int i4) {
        dialogInterface.dismiss();
    }

    private final void c1() {
        Macro macro = this.f11735f;
        if (macro == null) {
            Intrinsics.throwUninitializedPropertyAccessException("macro");
            macro = null;
        }
        String deleteMacroCheckOtherMacros = DeleteMacroHelperKt.deleteMacroCheckOtherMacros(this, macro);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.delete_macro);
        String string = getString(R.string.are_you_sure_delete_macro);
        builder.setMessage(deleteMacroCheckOtherMacros + string);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.editscreen.i
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                EditMacroActivity.d1(EditMacroActivity.this, dialogInterface, i4);
            }
        });
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.editscreen.t
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                EditMacroActivity.e1(dialogInterface, i4);
            }
        });
        builder.show();
    }

    private final void d0(ParentAction parentAction) {
        int i4;
        int collectionSizeOrDefault;
        Macro macro = this.f11735f;
        if (macro == null) {
            Intrinsics.throwUninitializedPropertyAccessException("macro");
            macro = null;
        }
        ArrayList<Action> actions = macro.getActions();
        int indexOf = actions.indexOf(parentAction);
        if (parentAction instanceof IfConditionAction) {
            i4 = MacroListUtils.getEndIfIndex(actions, indexOf);
        } else if (parentAction instanceof LoopAction) {
            i4 = MacroListUtils.getEndLoopIndex(actions, indexOf);
        } else {
            i4 = 0;
        }
        IntRange intRange = new IntRange(indexOf, i4);
        collectionSizeOrDefault = kotlin.collections.f.collectionSizeOrDefault(intRange, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<Integer> it = intRange.iterator();
        while (it.hasNext()) {
            arrayList.add(actions.get(((IntIterator) it).nextInt()));
        }
        CopyHelper.setCopiedItemList(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d1(EditMacroActivity this$0, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Macro macro = this$0.f11735f;
        Macro macro2 = null;
        if (macro == null) {
            Intrinsics.throwUninitializedPropertyAccessException("macro");
            macro = null;
        }
        String str = "Macro Deleted - " + macro.getName();
        Macro macro3 = this$0.f11735f;
        if (macro3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("macro");
            macro3 = null;
        }
        SystemLog.logInfo(str, macro3.getGUID());
        MacroStore macroStore = MacroStore.getInstance();
        Macro macro4 = this$0.f11735f;
        if (macro4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("macro");
        } else {
            macro2 = macro4;
        }
        macroStore.removeMacro(macro2, true);
        this$0.s0();
        AutoBackupCloudWorker.Companion.scheduleNewBackup$default(AutoBackupCloudWorker.Companion, this$0, 0L, 2, null);
        this$0.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e0() {
        VariableHelper.createNewVariable(this, getPremiumStatusHandler().getPremiumStatus().isPro(), true, R.style.Theme_App_Dialog_LocalVariables, false, false, R.layout.simple_spinner_dropdown_item_2_lines_white_text, "#DDDDDD", false, null, null, new VariableHelper.NewVariableCreationListener() { // from class: com.arlosoft.macrodroid.editscreen.EditMacroActivity$createNewVariable$1
            @Override // com.arlosoft.macrodroid.variables.VariableHelper.NewVariableCreationListener
            public void newVariableCreated(@NotNull MacroDroidVariable variable, boolean z3) {
                Intrinsics.checkNotNullParameter(variable, "variable");
                Macro macro = EditMacroActivity.this.f11735f;
                if (macro == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("macro");
                    macro = null;
                }
                macro.getLocalVariables().add(variable);
                EditMacroActivity.this.f11741l = true;
                EditMacroActivity.this.l1();
                EditMacroActivity.this.D1();
            }

            @Override // com.arlosoft.macrodroid.variables.VariableHelper.NewVariableCreationListener
            public boolean validateVariableName(@NotNull String variableName) {
                Intrinsics.checkNotNullParameter(variableName, "variableName");
                Macro macro = EditMacroActivity.this.f11735f;
                if (macro == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("macro");
                    macro = null;
                }
                if (macro.findLocalVariableByName(variableName) == null) {
                    return true;
                }
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e1(DialogInterface dialogInterface, int i4) {
        dialogInterface.dismiss();
    }

    private final void f0() {
        IncludeVariablesBinding inflate = IncludeVariablesBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater)");
        this.G = inflate;
        ActivityEditMacroBinding activityEditMacroBinding = this.H;
        if (activityEditMacroBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityEditMacroBinding = null;
        }
        BottomSheetBehavior<View> from = BottomSheetBehavior.from(activityEditMacroBinding.bottomBar.bottomSheetVariables);
        Intrinsics.checkNotNullExpressionValue(from, "from(binding.bottomBar.bottomSheetVariables)");
        this.f11748s = from;
        n1();
        IncludeVariablesBinding includeVariablesBinding = this.G;
        if (includeVariablesBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("includeVarsBinding");
            includeVariablesBinding = null;
        }
        FrameLayout frameLayout = includeVariablesBinding.varTitleLayout;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "includeVarsBinding.varTitleLayout");
        ViewExtensionsKt.onLongClick$default(frameLayout, null, false, new c(null), 3, null);
    }

    private final void f1() {
        WindowManager.LayoutParams layoutParams;
        final AppCompatDialog appCompatDialog = new AppCompatDialog(this, R.style.Theme_App_Dialog);
        appCompatDialog.setContentView(R.layout.enter_category);
        appCompatDialog.setTitle(R.string.new_category);
        WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams();
        Window window = appCompatDialog.getWindow();
        if (window != null) {
            layoutParams = window.getAttributes();
        } else {
            layoutParams = null;
        }
        layoutParams2.copyFrom(layoutParams);
        if (!getResources().getBoolean(R.bool.is_tablet)) {
            layoutParams2.width = -1;
        }
        Window window2 = appCompatDialog.getWindow();
        if (window2 != null) {
            window2.setAttributes(layoutParams2);
        }
        Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        final EditText editText = (EditText) appCompatDialog.findViewById(R.id.enter_category_text);
        if (editText != null) {
            ViewExtensionsKt.afterTextChanged(editText, new l(button, editText, this));
        }
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.editscreen.z
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EditMacroActivity.g1(EditMacroActivity.this, editText, appCompatDialog, view);
                }
            });
        }
        if (button2 != null) {
            button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.editscreen.a0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EditMacroActivity.h1(AppCompatDialog.this, view);
                }
            });
        }
        appCompatDialog.show();
        if (editText != null) {
            ViewExtensionsKt.focusAndShowKeyboard(editText);
        }
    }

    private final void g0(boolean z3) {
        setResult(0, new Intent());
        MacroStore macroStore = MacroStore.getInstance();
        Macro macro = this.f11735f;
        if (macro == null) {
            Intrinsics.throwUninitializedPropertyAccessException("macro");
            macro = null;
        }
        macroStore.removeMacro(macro, false);
        Macro macro2 = this.B;
        if (macro2 != null) {
            MacroStore.getInstance().addMacro(macro2, true, macro2.isEnabled());
        }
        s0();
        r0(z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g1(EditMacroActivity this$0, EditText editText, AppCompatDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        Macro macro = this$0.f11735f;
        Editable editable = null;
        if (macro == null) {
            Intrinsics.throwUninitializedPropertyAccessException("macro");
            macro = null;
        }
        if (editText != null) {
            editable = editText.getText();
        }
        macro.setCategory(String.valueOf(editable));
        dialog.dismiss();
    }

    static /* synthetic */ void h0(EditMacroActivity editMacroActivity, boolean z3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            z3 = false;
        }
        editMacroActivity.g0(z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h1(AppCompatDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.dismiss();
    }

    private final void i0(final boolean z3) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        AlertDialogKt.setTitleResource(builder, R.string.add_macro);
        AlertDialogKt.setMessageResource(builder, R.string.import_macro_needs_additional_configuration);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.editscreen.EditMacroActivity$displayAdditionalConfigRequiredDialog$lambda$43$$inlined$okButton$1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(@NotNull DialogInterface dialog, int i4) {
                Intrinsics.checkNotNullParameter(dialog, "dialog");
                EditMacroActivity.this.U(z3);
            }
        });
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.editscreen.EditMacroActivity$displayAdditionalConfigRequiredDialog$lambda$43$$inlined$cancelButton$1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(@NotNull DialogInterface dialog, int i4) {
                Intrinsics.checkNotNullParameter(dialog, "dialog");
            }
        });
        final AlertDialog create = builder.create();
        Intrinsics.checkNotNullExpressionValue(create, "Builder(this)\n        .apply(dialogConfig)\n        .create()");
        create.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.arlosoft.macrodroid.editscreen.EditMacroActivity$displayAdditionalConfigRequiredDialog$$inlined$onShow$1
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
            }
        });
        create.show();
    }

    private final void i1(boolean z3) {
        Macro macro;
        boolean z4;
        Macro macro2;
        AllSelectableItemsListAdapter allSelectableItemsListAdapter = this.f11738i;
        if (allSelectableItemsListAdapter != null && !z3) {
            if (allSelectableItemsListAdapter != null) {
                Macro macro3 = this.f11735f;
                if (macro3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("macro");
                    macro2 = null;
                } else {
                    macro2 = macro3;
                }
                allSelectableItemsListAdapter.setMacro(macro2);
            }
            return;
        }
        Macro macro4 = this.f11735f;
        if (macro4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("macro");
            macro = null;
        } else {
            macro = macro4;
        }
        if (Settings.getLocalVarsDisplayMode(Gradients.INSTANCE.getContext()) == 1) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.f11738i = new AllSelectableItemsListAdapter(this, macro, z4, new m(), new n(), new o(), this.f11745p, !this.f11739j, this.K, this.L, this.M, this.N, new p(), new q(), new r());
        RecyclerViewDragDropManager recyclerViewDragDropManager = new RecyclerViewDragDropManager();
        AllSelectableItemsListAdapter allSelectableItemsListAdapter2 = this.f11738i;
        Intrinsics.checkNotNull(allSelectableItemsListAdapter2);
        RecyclerView.Adapter createWrappedAdapter = recyclerViewDragDropManager.createWrappedAdapter(allSelectableItemsListAdapter2);
        Intrinsics.checkNotNullExpressionValue(createWrappedAdapter, "dragDropManager.createWr…dapter(allItemsAdapter!!)");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        ActivityEditMacroBinding activityEditMacroBinding = this.H;
        if (activityEditMacroBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityEditMacroBinding = null;
        }
        activityEditMacroBinding.allItemsList.setItemAnimator(null);
        ActivityEditMacroBinding activityEditMacroBinding2 = this.H;
        if (activityEditMacroBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityEditMacroBinding2 = null;
        }
        activityEditMacroBinding2.allItemsList.setLayoutManager(linearLayoutManager);
        ActivityEditMacroBinding activityEditMacroBinding3 = this.H;
        if (activityEditMacroBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityEditMacroBinding3 = null;
        }
        activityEditMacroBinding3.allItemsList.setAdapter(createWrappedAdapter);
        ActivityEditMacroBinding activityEditMacroBinding4 = this.H;
        if (activityEditMacroBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityEditMacroBinding4 = null;
        }
        recyclerViewDragDropManager.attachRecyclerView(activityEditMacroBinding4.allItemsList);
        recyclerViewDragDropManager.setInitiateOnTouch(true);
        recyclerViewDragDropManager.setCheckCanDropEnabled(false);
    }

    private final void j0(SelectableItem selectableItem, String str, boolean z3) {
        String str2;
        final AppCompatDialog appCompatDialog = new AppCompatDialog(this, t0(selectableItem));
        appCompatDialog.setContentView(R.layout.dialog_comment);
        appCompatDialog.setTitle(str);
        DialogExtensionsKt.setWidthToParent(appCompatDialog, getResources().getDimensionPixelOffset(R.dimen.margin_medium));
        Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        ImageButton imageButton = (ImageButton) appCompatDialog.findViewById(R.id.clear_button);
        final EditText editText = (EditText) appCompatDialog.findViewById(R.id.enter_comment_text);
        if (editText != null) {
            SelectableItem selectableItem2 = this.f11736g;
            if (selectableItem2 != null) {
                str2 = selectableItem2.getComment();
            } else {
                str2 = null;
            }
            editText.setText(str2);
        }
        if (editText != null) {
            ViewExtensionsKt.setCursorAtEnd(editText);
        }
        if (z3 && imageButton != null) {
            imageButton.setVisibility(8);
        }
        if (imageButton != null) {
            imageButton.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.editscreen.b0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EditMacroActivity.k0(editText, view);
                }
            });
        }
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.editscreen.c0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EditMacroActivity.l0(EditMacroActivity.this, appCompatDialog, editText, view);
                }
            });
        }
        if (button2 != null) {
            button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.editscreen.d0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EditMacroActivity.m0(AppCompatDialog.this, view);
                }
            });
        }
        appCompatDialog.show();
        Window window = appCompatDialog.getWindow();
        if (window != null) {
            window.setSoftInputMode(5);
        }
    }

    static /* synthetic */ void j1(EditMacroActivity editMacroActivity, boolean z3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            z3 = false;
        }
        editMacroActivity.i1(z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(EditText editText, View view) {
        if (editText != null) {
            editText.setText("");
        }
    }

    private final void k1() {
        MenuItem menuItem;
        MenuItem menuItem2;
        boolean z3;
        boolean z4;
        int localVarsDisplayMode = Settings.getLocalVarsDisplayMode(this);
        MenuItem menuItem3 = this.f11754y;
        MenuItem menuItem4 = null;
        if (menuItem3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("localVarsMenuItem");
            menuItem3 = null;
        }
        SubMenu subMenu = menuItem3.getSubMenu();
        if (subMenu != null) {
            menuItem = subMenu.findItem(R.id.menu_hide);
        } else {
            menuItem = null;
        }
        boolean z5 = false;
        if (menuItem != null) {
            if (localVarsDisplayMode == 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            menuItem.setChecked(z4);
        }
        MenuItem menuItem5 = this.f11754y;
        if (menuItem5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("localVarsMenuItem");
            menuItem5 = null;
        }
        SubMenu subMenu2 = menuItem5.getSubMenu();
        if (subMenu2 != null) {
            menuItem2 = subMenu2.findItem(R.id.menu_inline);
        } else {
            menuItem2 = null;
        }
        if (menuItem2 != null) {
            if (localVarsDisplayMode == 1) {
                z3 = true;
            } else {
                z3 = false;
            }
            menuItem2.setChecked(z3);
        }
        MenuItem menuItem6 = this.f11754y;
        if (menuItem6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("localVarsMenuItem");
            menuItem6 = null;
        }
        SubMenu subMenu3 = menuItem6.getSubMenu();
        if (subMenu3 != null) {
            menuItem4 = subMenu3.findItem(R.id.menu_bottom_bar);
        }
        if (menuItem4 != null) {
            if (localVarsDisplayMode == 2) {
                z5 = true;
            }
            menuItem4.setChecked(z5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(EditMacroActivity this$0, AppCompatDialog dialog, EditText editText, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        this$0.X(dialog, editText);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l1() {
        runOnUiThread(new Runnable() { // from class: com.arlosoft.macrodroid.editscreen.r
            @Override // java.lang.Runnable
            public final void run() {
                EditMacroActivity.m1(EditMacroActivity.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(AppCompatDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m1(EditMacroActivity this$0) {
        Macro macro;
        int i4;
        List<MacroDroidVariable> localVariables;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Macro macro2 = this$0.f11735f;
        Macro macro3 = null;
        if (macro2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("macro");
            macro = null;
        } else {
            macro = macro2;
        }
        boolean z3 = this$0.f11745p;
        Resources resources = this$0.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        this$0.f11751v = new LocalVarsAdapter(macro, z3, resources, false, new s(), null);
        IncludeVariablesBinding includeVariablesBinding = this$0.G;
        if (includeVariablesBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("includeVarsBinding");
            includeVariablesBinding = null;
        }
        LocalVarRecyclerView localVarRecyclerView = includeVariablesBinding.localVarsList;
        LocalVarsAdapter localVarsAdapter = this$0.f11751v;
        if (localVarsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("localVarsAdapter");
            localVarsAdapter = null;
        }
        localVarRecyclerView.setAdapter(localVarsAdapter);
        IncludeVariablesBinding includeVariablesBinding2 = this$0.G;
        if (includeVariablesBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("includeVarsBinding");
            includeVariablesBinding2 = null;
        }
        TextView textView = includeVariablesBinding2.noVarsText;
        Intrinsics.checkNotNullExpressionValue(textView, "includeVarsBinding.noVarsText");
        Macro macro4 = this$0.f11735f;
        if (macro4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("macro");
            macro4 = null;
        }
        int i5 = 0;
        if (macro4.getLocalVariables().isEmpty()) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        textView.setVisibility(i4);
        IncludeVariablesBinding includeVariablesBinding3 = this$0.G;
        if (includeVariablesBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("includeVarsBinding");
            includeVariablesBinding3 = null;
        }
        LocalVarRecyclerView localVarRecyclerView2 = includeVariablesBinding3.localVarsList;
        Intrinsics.checkNotNullExpressionValue(localVarRecyclerView2, "includeVarsBinding.localVarsList");
        Macro macro5 = this$0.f11735f;
        if (macro5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("macro");
            macro5 = null;
        }
        Intrinsics.checkNotNullExpressionValue(macro5.getLocalVariables(), "macro.localVariables");
        if (!(!localVariables.isEmpty())) {
            i5 = 8;
        }
        localVarRecyclerView2.setVisibility(i5);
        AllSelectableItemsListAdapter allSelectableItemsListAdapter = this$0.f11738i;
        if (allSelectableItemsListAdapter != null) {
            Macro macro6 = this$0.f11735f;
            if (macro6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("macro");
            } else {
                macro3 = macro6;
            }
            allSelectableItemsListAdapter.updateLocalVariables(macro3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean n0(String str) {
        for (ActionBlock actionBlock : getActionBlockStore().getAllActionBlocks()) {
            if (Intrinsics.areEqual(actionBlock.getName(), str)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n1() {
        this.f11752w = Settings.getLocalVarsDisplayMode(this);
        ActivityEditMacroBinding activityEditMacroBinding = this.H;
        ActivityEditMacroBinding activityEditMacroBinding2 = null;
        if (activityEditMacroBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityEditMacroBinding = null;
        }
        FrameLayout frameLayout = activityEditMacroBinding.bottomBar.bottomSheetVariables;
        Intrinsics.checkNotNull(frameLayout, "null cannot be cast to non-null type android.widget.FrameLayout");
        frameLayout.removeAllViews();
        ActivityEditMacroBinding activityEditMacroBinding3 = this.H;
        if (activityEditMacroBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityEditMacroBinding3 = null;
        }
        FrameLayout frameLayout2 = activityEditMacroBinding3.bottomBar.bottomSheetVariables;
        Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.bottomBar.bottomSheetVariables");
        frameLayout2.setVisibility(8);
        int i4 = this.f11752w;
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 == 2) {
                    ActivityEditMacroBinding activityEditMacroBinding4 = this.H;
                    if (activityEditMacroBinding4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        activityEditMacroBinding4 = null;
                    }
                    FrameLayout frameLayout3 = activityEditMacroBinding4.bottomBar.bottomSheetVariables;
                    Intrinsics.checkNotNull(frameLayout3, "null cannot be cast to non-null type android.widget.FrameLayout");
                    IncludeVariablesBinding includeVariablesBinding = this.G;
                    if (includeVariablesBinding == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("includeVarsBinding");
                        includeVariablesBinding = null;
                    }
                    frameLayout3.addView(includeVariablesBinding.getRoot(), -1, -2);
                    ActivityEditMacroBinding activityEditMacroBinding5 = this.H;
                    if (activityEditMacroBinding5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        activityEditMacroBinding5 = null;
                    }
                    FrameLayout frameLayout4 = activityEditMacroBinding5.bottomBar.bottomSheetVariables;
                    Intrinsics.checkNotNullExpressionValue(frameLayout4, "binding.bottomBar.bottomSheetVariables");
                    frameLayout4.setVisibility(0);
                    IncludeVariablesBinding includeVariablesBinding2 = this.G;
                    if (includeVariablesBinding2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("includeVarsBinding");
                        includeVariablesBinding2 = null;
                    }
                    ImageButton imageButton = includeVariablesBinding2.addVariableButton;
                    Intrinsics.checkNotNullExpressionValue(imageButton, "includeVarsBinding.addVariableButton");
                    imageButton.setVisibility(8);
                    IncludeVariablesBinding includeVariablesBinding3 = this.G;
                    if (includeVariablesBinding3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("includeVarsBinding");
                        includeVariablesBinding3 = null;
                    }
                    includeVariablesBinding3.localVarsList.setInline(false);
                    IncludeVariablesBinding includeVariablesBinding4 = this.G;
                    if (includeVariablesBinding4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("includeVarsBinding");
                        includeVariablesBinding4 = null;
                    }
                    includeVariablesBinding4.localVarsLabel.setGravity(17);
                    BottomSheetBehavior<View> bottomSheetBehavior = this.f11748s;
                    if (bottomSheetBehavior == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("bottomSheetBehavior");
                        bottomSheetBehavior = null;
                    }
                    bottomSheetBehavior.setState(4);
                    t1(true);
                    ActivityEditMacroBinding activityEditMacroBinding6 = this.H;
                    if (activityEditMacroBinding6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        activityEditMacroBinding6 = null;
                    }
                    FrameLayout frameLayout5 = activityEditMacroBinding6.allItemsContainer;
                    ActivityEditMacroBinding activityEditMacroBinding7 = this.H;
                    if (activityEditMacroBinding7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        activityEditMacroBinding7 = null;
                    }
                    int paddingLeft = activityEditMacroBinding7.allItemsContainer.getPaddingLeft();
                    ActivityEditMacroBinding activityEditMacroBinding8 = this.H;
                    if (activityEditMacroBinding8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        activityEditMacroBinding8 = null;
                    }
                    int paddingTop = activityEditMacroBinding8.allItemsContainer.getPaddingTop();
                    ActivityEditMacroBinding activityEditMacroBinding9 = this.H;
                    if (activityEditMacroBinding9 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        activityEditMacroBinding2 = activityEditMacroBinding9;
                    }
                    frameLayout5.setPadding(paddingLeft, paddingTop, activityEditMacroBinding2.allItemsContainer.getPaddingRight(), this.f11753x);
                    AllSelectableItemsListAdapter allSelectableItemsListAdapter = this.f11738i;
                    if (allSelectableItemsListAdapter != null) {
                        allSelectableItemsListAdapter.setShowVariables(false);
                        return;
                    }
                    return;
                }
                return;
            }
            IncludeVariablesBinding includeVariablesBinding5 = this.G;
            if (includeVariablesBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("includeVarsBinding");
                includeVariablesBinding5 = null;
            }
            includeVariablesBinding5.localVarsList.setInline(true);
            IncludeVariablesBinding includeVariablesBinding6 = this.G;
            if (includeVariablesBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("includeVarsBinding");
                includeVariablesBinding6 = null;
            }
            ImageButton imageButton2 = includeVariablesBinding6.addVariableButton;
            Intrinsics.checkNotNullExpressionValue(imageButton2, "includeVarsBinding.addVariableButton");
            imageButton2.setVisibility(0);
            IncludeVariablesBinding includeVariablesBinding7 = this.G;
            if (includeVariablesBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("includeVarsBinding");
                includeVariablesBinding7 = null;
            }
            includeVariablesBinding7.addVariableButton.setAlpha(1.0f);
            IncludeVariablesBinding includeVariablesBinding8 = this.G;
            if (includeVariablesBinding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("includeVarsBinding");
                includeVariablesBinding8 = null;
            }
            includeVariablesBinding8.localVarsLabel.setGravity(16);
            t1(false);
            ActivityEditMacroBinding activityEditMacroBinding10 = this.H;
            if (activityEditMacroBinding10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityEditMacroBinding10 = null;
            }
            FrameLayout frameLayout6 = activityEditMacroBinding10.allItemsContainer;
            ActivityEditMacroBinding activityEditMacroBinding11 = this.H;
            if (activityEditMacroBinding11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityEditMacroBinding11 = null;
            }
            int paddingLeft2 = activityEditMacroBinding11.allItemsContainer.getPaddingLeft();
            ActivityEditMacroBinding activityEditMacroBinding12 = this.H;
            if (activityEditMacroBinding12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityEditMacroBinding12 = null;
            }
            int paddingTop2 = activityEditMacroBinding12.allItemsContainer.getPaddingTop();
            ActivityEditMacroBinding activityEditMacroBinding13 = this.H;
            if (activityEditMacroBinding13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityEditMacroBinding2 = activityEditMacroBinding13;
            }
            frameLayout6.setPadding(paddingLeft2, paddingTop2, activityEditMacroBinding2.allItemsContainer.getPaddingRight(), 0);
            AllSelectableItemsListAdapter allSelectableItemsListAdapter2 = this.f11738i;
            if (allSelectableItemsListAdapter2 != null) {
                allSelectableItemsListAdapter2.setShowVariables(true);
                return;
            }
            return;
        }
        t1(false);
        ActivityEditMacroBinding activityEditMacroBinding14 = this.H;
        if (activityEditMacroBinding14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityEditMacroBinding14 = null;
        }
        FrameLayout frameLayout7 = activityEditMacroBinding14.allItemsContainer;
        ActivityEditMacroBinding activityEditMacroBinding15 = this.H;
        if (activityEditMacroBinding15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityEditMacroBinding15 = null;
        }
        int paddingLeft3 = activityEditMacroBinding15.allItemsContainer.getPaddingLeft();
        ActivityEditMacroBinding activityEditMacroBinding16 = this.H;
        if (activityEditMacroBinding16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityEditMacroBinding16 = null;
        }
        int paddingTop3 = activityEditMacroBinding16.allItemsContainer.getPaddingTop();
        ActivityEditMacroBinding activityEditMacroBinding17 = this.H;
        if (activityEditMacroBinding17 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityEditMacroBinding2 = activityEditMacroBinding17;
        }
        frameLayout7.setPadding(paddingLeft3, paddingTop3, activityEditMacroBinding2.allItemsContainer.getPaddingRight(), 0);
        AllSelectableItemsListAdapter allSelectableItemsListAdapter3 = this.f11738i;
        if (allSelectableItemsListAdapter3 != null) {
            allSelectableItemsListAdapter3.setShowVariables(false);
        }
    }

    private final boolean o0(String str) {
        List<Macro> allMacros = MacroStore.getInstance().getAllCompletedMacros();
        Intrinsics.checkNotNullExpressionValue(allMacros, "allMacros");
        for (Macro macro : allMacros) {
            Macro macro2 = this.f11735f;
            if (macro2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("macro");
                macro2 = null;
            }
            if (!Intrinsics.areEqual(macro, macro2) && Intrinsics.areEqual(macro.getName(), str)) {
                return true;
            }
        }
        return false;
    }

    private final boolean o1(boolean z3) {
        int i4;
        Macro macro;
        List<String> mutableList;
        int lastIndex;
        Iterator it;
        List<String> mutableList2;
        int lastIndex2;
        Macro macro2 = this.f11735f;
        if (macro2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("macro");
            macro2 = null;
        }
        boolean isCompleted = macro2.isCompleted();
        Macro macro3 = this.f11735f;
        if (macro3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("macro");
            macro3 = null;
        }
        String name = macro3.getName();
        Macro macro4 = this.f11735f;
        if (macro4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("macro");
            macro4 = null;
        }
        macro4.setLastEditedTimestamp(System.currentTimeMillis());
        Macro macro5 = this.f11735f;
        if (macro5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("macro");
            macro5 = null;
        }
        ActivityEditMacroBinding activityEditMacroBinding = this.H;
        if (activityEditMacroBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityEditMacroBinding = null;
        }
        macro5.setDescription(String.valueOf(activityEditMacroBinding.macroDescription.getText()));
        Macro macro6 = this.f11735f;
        if (macro6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("macro");
            macro6 = null;
        }
        ActivityEditMacroBinding activityEditMacroBinding2 = this.H;
        if (activityEditMacroBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityEditMacroBinding2 = null;
        }
        macro6.setName(activityEditMacroBinding2.macroNameText.getText().toString());
        if (this.f11746q) {
            Macro macro7 = this.f11735f;
            if (macro7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("macro");
                macro7 = null;
            }
            if (!macro7.isCompleted()) {
                Macro macro8 = this.f11735f;
                if (macro8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("macro");
                    macro8 = null;
                }
                macro8.setEnabledFlag(true);
            }
        }
        Macro macro9 = this.f11735f;
        if (macro9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("macro");
            macro9 = null;
        }
        macro9.setCompleted(true);
        if (this.f11746q || this.f11740k) {
            Macro macro10 = this.f11735f;
            if (macro10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("macro");
                macro10 = null;
            }
            W0(macro10);
        }
        Iterator<T> it2 = getActionBlockStore().getActionBlocksBeingImported().iterator();
        while (true) {
            i4 = 0;
            if (!it2.hasNext()) {
                break;
            }
            ActionBlock actionBlock = (ActionBlock) it2.next();
            actionBlock.setIsBeingImported(false);
            getActionBlockStore().updateActionBlock(actionBlock);
            ActionBlockHelper.applyImport(actionBlock);
        }
        if (z3) {
            Macro macro11 = this.f11735f;
            if (macro11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("macro");
                macro11 = null;
            }
            macro11.setEnabled(false);
        }
        MacroStore macroStore = MacroStore.getInstance();
        Macro macro12 = this.f11735f;
        if (macro12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("macro");
            macro12 = null;
        }
        macroStore.updateMacro(macro12, true, isCompleted);
        boolean z4 = false;
        for (Macro macro13 : MacroStore.getInstance().getAllCompletedMacrosWithActionBlocks(false)) {
            Iterator<Action> it3 = macro13.getActions().iterator();
            boolean z5 = false;
            while (it3.hasNext()) {
                Action next = it3.next();
                if (next instanceof ForceMacroRunAction) {
                    ForceMacroRunAction forceMacroRunAction = (ForceMacroRunAction) next;
                    long guid = forceMacroRunAction.getGUID();
                    Macro macro14 = this.f11735f;
                    if (macro14 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("macro");
                        macro14 = null;
                    }
                    if (macro14.getGUID() != guid) {
                        Macro macro15 = this.f11735f;
                        if (macro15 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("macro");
                            macro15 = null;
                        }
                        if (Intrinsics.areEqual(macro15.getName(), forceMacroRunAction.getMacroName())) {
                        }
                    }
                    Macro macro16 = this.f11735f;
                    if (macro16 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("macro");
                        macro16 = null;
                    }
                    forceMacroRunAction.setName(macro16.getName());
                    z5 = true;
                } else if (next instanceof DisableMacroAction) {
                    DisableMacroAction disableMacroAction = (DisableMacroAction) next;
                    long guid2 = disableMacroAction.getGUID();
                    Macro macro17 = this.f11735f;
                    if (macro17 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("macro");
                        macro17 = null;
                    }
                    if (macro17.getGUID() == guid2) {
                        Macro macro18 = this.f11735f;
                        if (macro18 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("macro");
                            macro18 = null;
                        }
                        disableMacroAction.setName(macro18.getName());
                        z5 = true;
                    }
                } else if (next instanceof CancelActiveMacroAction) {
                    CancelActiveMacroAction cancelActiveMacroAction = (CancelActiveMacroAction) next;
                    long gUIDToCancel = cancelActiveMacroAction.getGUIDToCancel();
                    Macro macro19 = this.f11735f;
                    if (macro19 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("macro");
                        macro19 = null;
                    }
                    if (macro19.getGUID() != gUIDToCancel) {
                        Macro macro20 = this.f11735f;
                        if (macro20 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("macro");
                            macro20 = null;
                        }
                        if (Intrinsics.areEqual(macro20.getName(), cancelActiveMacroAction.getMacroName())) {
                        }
                    }
                    cancelActiveMacroAction.setMacroName(macro13.getName());
                    z5 = true;
                }
            }
            if (!Intrinsics.areEqual(name, macro13.getName())) {
                List<Constraint> allConstraints = macro13.getAllConstraints();
                Intrinsics.checkNotNullExpressionValue(allConstraints, "macro.allConstraints");
                ArrayList<Constraint> arrayList = new ArrayList();
                for (Object obj : allConstraints) {
                    if (((Constraint) obj) instanceof HasMacroNames) {
                        arrayList.add(obj);
                    }
                }
                for (Constraint constraint : arrayList) {
                    Intrinsics.checkNotNull(constraint, "null cannot be cast to non-null type com.arlosoft.macrodroid.categories.HasMacroNames");
                    HasMacroNames hasMacroNames = (HasMacroNames) constraint;
                    mutableList2 = CollectionsKt___CollectionsKt.toMutableList((Collection) hasMacroNames.getMacroNames());
                    int size = mutableList2.size();
                    lastIndex2 = CollectionsKt__CollectionsKt.getLastIndex(mutableList2);
                    if (lastIndex2 >= 0) {
                        while (true) {
                            int i5 = i4 + 1;
                            if (mutableList2.size() == size) {
                                if (Intrinsics.areEqual(mutableList2.get(i4), name)) {
                                    Macro macro21 = this.f11735f;
                                    if (macro21 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("macro");
                                        macro21 = null;
                                    }
                                    String name2 = macro21.getName();
                                    Intrinsics.checkNotNullExpressionValue(name2, "this.macro.name");
                                    mutableList2.set(i4, name2);
                                }
                                if (i4 == lastIndex2) {
                                    break;
                                }
                                i4 = i5;
                            } else {
                                throw new ConcurrentModificationException();
                            }
                        }
                    }
                    hasMacroNames.setMacroNames(mutableList2);
                    i4 = 0;
                }
                ArrayList<Action> actions = macro13.getActions();
                Intrinsics.checkNotNullExpressionValue(actions, "macro.actions");
                ArrayList arrayList2 = new ArrayList();
                for (Object obj2 : actions) {
                    if (((Action) obj2) instanceof HasMacroNames) {
                        arrayList2.add(obj2);
                    }
                }
                Iterator it4 = arrayList2.iterator();
                while (it4.hasNext()) {
                    Action action = (Action) it4.next();
                    Intrinsics.checkNotNull(action, "null cannot be cast to non-null type com.arlosoft.macrodroid.categories.HasMacroNames");
                    HasMacroNames hasMacroNames2 = (HasMacroNames) action;
                    mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) hasMacroNames2.getMacroNames());
                    int size2 = mutableList.size();
                    lastIndex = CollectionsKt__CollectionsKt.getLastIndex(mutableList);
                    if (lastIndex >= 0) {
                        int i6 = 0;
                        while (true) {
                            int i7 = i6 + 1;
                            it = it4;
                            if (mutableList.size() == size2) {
                                if (Intrinsics.areEqual(mutableList.get(i6), name)) {
                                    Macro macro22 = this.f11735f;
                                    if (macro22 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("macro");
                                        macro22 = null;
                                    }
                                    String name3 = macro22.getName();
                                    Intrinsics.checkNotNullExpressionValue(name3, "this.macro.name");
                                    mutableList.set(i6, name3);
                                }
                                if (i6 == lastIndex) {
                                    break;
                                }
                                it4 = it;
                                i6 = i7;
                            } else {
                                throw new ConcurrentModificationException();
                            }
                        }
                    } else {
                        it = it4;
                    }
                    hasMacroNames2.setMacroNames(mutableList);
                    it4 = it;
                }
            }
            if (z5) {
                MacroStore.getInstance().updateMacro(macro13);
            }
            if (this.f11746q || this.f11739j || this.f11741l || !isCompleted) {
                z4 = true;
            }
            i4 = 0;
        }
        setResult(-1, new Intent());
        Macro macro23 = this.f11735f;
        if (macro23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("macro");
            macro = null;
        } else {
            macro = macro23;
        }
        Settings.setLastEditedMacroGuid(this, macro.getGUID());
        this.f11742m = true;
        return z4;
    }

    public static /* synthetic */ void onBackPressed$default(EditMacroActivity editMacroActivity, boolean z3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            z3 = false;
        }
        editMacroActivity.onBackPressed(z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p0(boolean z3) {
        Macro macro = this.f11735f;
        if (macro == null) {
            Intrinsics.throwUninitializedPropertyAccessException("macro");
            macro = null;
        }
        Iterator<Action> it = macro.getActions().iterator();
        while (it.hasNext()) {
            Action next = it.next();
            if (next instanceof ParentAction) {
                ((ParentAction) next).setChildrenCollapsed(!z3);
            }
        }
        AllSelectableItemsListAdapter allSelectableItemsListAdapter = this.f11738i;
        if (allSelectableItemsListAdapter != null) {
            allSelectableItemsListAdapter.refreshShownItems();
        }
        AllSelectableItemsListAdapter allSelectableItemsListAdapter2 = this.f11738i;
        if (allSelectableItemsListAdapter2 != null) {
            allSelectableItemsListAdapter2.notifyDataSetChanged();
        }
    }

    private final void p1() {
        this.f11743n = 0;
        List<String> categories = Util.getCategories(getApplicationContext());
        Macro macro = this.f11735f;
        if (macro == null) {
            Intrinsics.throwUninitializedPropertyAccessException("macro");
            macro = null;
        }
        if (macro.getCategory() != null) {
            Macro macro2 = this.f11735f;
            if (macro2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("macro");
                macro2 = null;
            }
            if (!categories.contains(macro2.getCategory())) {
                Macro macro3 = this.f11735f;
                if (macro3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("macro");
                    macro3 = null;
                }
                categories.add(macro3.getCategory());
                Gradients gradients = Gradients.INSTANCE;
                final Locale locale = Settings.getLocale(gradients.getContext());
                Intrinsics.checkNotNullExpressionValue(locale, "getLocale(context)");
                Intrinsics.checkNotNullExpressionValue(categories, "categories");
                kotlin.collections.h.sortWith(categories, new Comparator() { // from class: com.arlosoft.macrodroid.editscreen.n
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        int q12;
                        q12 = EditMacroActivity.q1(locale, (String) obj, (String) obj2);
                        return q12;
                    }
                });
                categories.remove(gradients.getContext().getString(R.string.uncategorized));
                categories.add(0, gradients.getContext().getString(R.string.uncategorized));
            }
        }
        categories.add(0, "[" + getString(R.string.new_category) + "]");
        int size = categories.size();
        for (int i4 = 0; i4 < size; i4++) {
            String str = categories.get(i4);
            Macro macro4 = this.f11735f;
            if (macro4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("macro");
                macro4 = null;
            }
            if (Intrinsics.areEqual(str, macro4.getCategory())) {
                this.f11743n = i4;
            }
        }
        Intrinsics.checkNotNullExpressionValue(categories, "categories");
        final String[] strArr = (String[]) categories.toArray(new String[0]);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.select_category);
        builder.setSingleChoiceItems(strArr, this.f11743n, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.editscreen.o
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                EditMacroActivity.r1(EditMacroActivity.this, dialogInterface, i5);
            }
        });
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.editscreen.p
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                EditMacroActivity.s1(EditMacroActivity.this, strArr, dialogInterface, i5);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q0(SelectableItem selectableItem) {
        ParentAction parentAction;
        Macro macro = this.f11735f;
        Macro macro2 = null;
        if (macro == null) {
            Intrinsics.throwUninitializedPropertyAccessException("macro");
            macro = null;
        }
        int checkActionsFlowControl = Action.checkActionsFlowControl(macro.getActions());
        if (checkActionsFlowControl == -1) {
            Intrinsics.checkNotNull(selectableItem, "null cannot be cast to non-null type com.arlosoft.macrodroid.action.ParentAction");
            ((ParentAction) selectableItem).setChildrenCollapsed(!parentAction.getChildrenCollapsed());
            AllSelectableItemsListAdapter allSelectableItemsListAdapter = this.f11738i;
            if (allSelectableItemsListAdapter != null) {
                allSelectableItemsListAdapter.refreshShownItems();
            }
            AllSelectableItemsListAdapter allSelectableItemsListAdapter2 = this.f11738i;
            if (allSelectableItemsListAdapter2 != null) {
                allSelectableItemsListAdapter2.notifyDataSetChanged();
                return;
            }
            return;
        }
        String string = getString(R.string.invalid_control_flow);
        Macro macro3 = this.f11735f;
        if (macro3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("macro");
        } else {
            macro2 = macro3;
        }
        ToastCompat.makeText((Context) this, (CharSequence) (string + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + macro2.getActions().get(checkActionsFlowControl).getConfiguredName()), 1).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int q1(Locale locale, String str, String str2) {
        Intrinsics.checkNotNullParameter(locale, "$locale");
        Collator collator = Collator.getInstance(locale);
        collator.setStrength(0);
        return collator.compare(str, str2);
    }

    private final void r0(boolean z3) {
        getActionBlockStore().clearActionBlocksBeingImported();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r1(EditMacroActivity this$0, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.f11743n = i4;
    }

    public static /* synthetic */ void refresh$default(EditMacroActivity editMacroActivity, boolean z3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            z3 = false;
        }
        editMacroActivity.refresh(z3);
    }

    private final void s0() {
        Object systemService = getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        ActivityEditMacroBinding activityEditMacroBinding = this.H;
        if (activityEditMacroBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityEditMacroBinding = null;
        }
        inputMethodManager.hideSoftInputFromWindow(activityEditMacroBinding.macroDescription.getWindowToken(), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s1(EditMacroActivity this$0, String[] macroArray, DialogInterface dialogInterface, int i4) {
        Category category;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(macroArray, "$macroArray");
        if (this$0.f11743n == 0) {
            this$0.f1();
            return;
        }
        Macro macro = this$0.f11735f;
        Macro macro2 = null;
        if (macro == null) {
            Intrinsics.throwUninitializedPropertyAccessException("macro");
            macro = null;
        }
        macro.setCategory(macroArray[this$0.f11743n]);
        CategoryList categoryList = (CategoryList) MacroDroidApplication.Companion.getInstance().getCache(Category.CATEGORY_CACHE).get(Category.CATEGORIES_KEY, CategoryList.class);
        Macro macro3 = this$0.f11735f;
        if (macro3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("macro");
            macro3 = null;
        }
        macro3.setHeadingColor(0);
        if (categoryList != null) {
            Macro macro4 = this$0.f11735f;
            if (macro4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("macro");
                macro4 = null;
            }
            String category2 = macro4.getCategory();
            Intrinsics.checkNotNullExpressionValue(category2, "macro.category");
            category = categoryList.getCategoryByName(category2);
        } else {
            category = null;
        }
        if (category != null) {
            Macro macro5 = this$0.f11735f;
            if (macro5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("macro");
            } else {
                macro2 = macro5;
            }
            macro2.setHeadingColor(category.getColor());
        }
        this$0.f11741l = true;
        this$0.D1();
    }

    private final void showDeleteUndo(final List<? extends RemovedItem> list) {
        View findViewById = findViewById(R.id.editMacroContainer);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = getString(R.string.deleted_with_name);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.deleted_with_name)");
        String format = String.format(string, Arrays.copyOf(new Object[]{list.get(0).getItem().getConfiguredName()}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        SnackbarAnimate make = SnackbarAnimate.make(findViewById, format, (int) UNDO_PROMPT_TIMEOUT);
        Intrinsics.checkNotNullExpressionValue(make, "make(findViewById(R.id.e…me), UNDO_PROMPT_TIMEOUT)");
        make.setAction(R.string.undo, new View.OnClickListener() { // from class: com.arlosoft.macrodroid.editscreen.h0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EditMacroActivity.w1(EditMacroActivity.this, list, view);
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

    private final int t0(SelectableItem selectableItem) {
        if (selectableItem instanceof Trigger) {
            return R.style.Theme_App_Dialog_Invert_Trigger;
        }
        if (selectableItem instanceof Action) {
            return R.style.Theme_App_Dialog_Invert_Action;
        }
        return R.style.Theme_App_Dialog_Invert_Constraint;
    }

    private final void t1(boolean z3) {
        CoordinatorLayout.LayoutParams layoutParams = new CoordinatorLayout.LayoutParams(-2, -2);
        int dimension = (int) getResources().getDimension(R.dimen.margin_medium);
        layoutParams.setMargins(dimension, dimension, dimension, dimension);
        if (z3) {
            layoutParams.setAnchorId(R.id.bottomBar);
            layoutParams.anchorGravity = BadgeDrawable.TOP_END;
        } else {
            layoutParams.gravity = BadgeDrawable.BOTTOM_END;
        }
        ActivityEditMacroBinding activityEditMacroBinding = this.H;
        if (activityEditMacroBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityEditMacroBinding = null;
        }
        activityEditMacroBinding.acceptButton.setLayoutParams(layoutParams);
    }

    private final void u0() {
        ActivityEditMacroBinding activityEditMacroBinding = this.H;
        if (activityEditMacroBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityEditMacroBinding = null;
        }
        activityEditMacroBinding.descriptionExpandable.toggle();
    }

    private final void u1() {
        int i4;
        if (!this.f11746q) {
            ActivityEditMacroBinding activityEditMacroBinding = this.H;
            Macro macro = null;
            if (activityEditMacroBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityEditMacroBinding = null;
            }
            LinearLayout linearLayout = activityEditMacroBinding.disabledLabel;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.disabledLabel");
            Macro macro2 = this.f11735f;
            if (macro2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("macro");
            } else {
                macro = macro2;
            }
            if (!macro.isEnabled()) {
                i4 = 0;
            } else {
                i4 = 8;
            }
            linearLayout.setVisibility(i4);
        }
    }

    private final void v0(boolean z3) {
        int size = MacroStore.getInstance().getAllCompletedMacros().size();
        int freeMacros = Settings.getFreeMacros(this);
        Macro macro = this.f11735f;
        Macro macro2 = null;
        if (macro == null) {
            Intrinsics.throwUninitializedPropertyAccessException("macro");
            macro = null;
        }
        if (!macro.isCompleted()) {
            freeMacros--;
        }
        Macro macro3 = this.f11735f;
        if (macro3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("macro");
            macro3 = null;
        }
        int checkActionsFlowControl = Action.checkActionsFlowControl(macro3.getActions());
        if (checkActionsFlowControl >= 0) {
            String string = getString(R.string.invalid_control_flow);
            Macro macro4 = this.f11735f;
            if (macro4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("macro");
            } else {
                macro2 = macro4;
            }
            Util.displayErrorDialog(this, getString(R.string.invalid_macro), string + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + macro2.getActions().get(checkActionsFlowControl).getConfiguredName());
            return;
        }
        ActivityEditMacroBinding activityEditMacroBinding = this.H;
        if (activityEditMacroBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityEditMacroBinding = null;
        }
        if (TextUtils.isEmpty(activityEditMacroBinding.macroNameText.getText().toString())) {
            Util.displayErrorDialog(this, getString(R.string.invalid_macro), getString(R.string.please_set_a_macro_name));
            return;
        }
        Macro macro5 = this.f11735f;
        if (macro5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("macro");
            macro5 = null;
        }
        if (macro5.getTriggerList().size() == 0) {
            Util.displayErrorDialog(this, getString(R.string.invalid_macro), getString(R.string.please_add_a_trigger));
            return;
        }
        Macro macro6 = this.f11735f;
        if (macro6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("macro");
            macro6 = null;
        }
        if (macro6.getActions().size() == 0) {
            Util.displayErrorDialog(this, getString(R.string.invalid_macro), getString(R.string.please_add_an_action));
            return;
        }
        Macro macro7 = this.f11735f;
        if (macro7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("macro");
            macro7 = null;
        }
        if (!macro7.isValid() && !this.f11746q) {
            Util.displayErrorDialog(this, getString(R.string.invalid_macro), getString(R.string.ensure_valid_macro));
            return;
        }
        ActivityEditMacroBinding activityEditMacroBinding2 = this.H;
        if (activityEditMacroBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityEditMacroBinding2 = null;
        }
        if (o0(activityEditMacroBinding2.macroNameText.getText().toString())) {
            Util.displayErrorDialog(this, getString(R.string.invalid_macro), getString(R.string.macro_name_already_exists));
        } else if (!getPremiumStatusHandler().getPremiumStatus().isPro() && size > freeMacros) {
            Util.showMacroLimitReached(this, getRemoteConfig());
        } else {
            Macro macro8 = this.f11735f;
            if (macro8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("macro");
            } else {
                macro2 = macro8;
            }
            if (!macro2.isValid()) {
                i0(z3);
            } else {
                U(z3);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void v1() {
        /*
            r5 = this;
            com.arlosoft.macrodroid.databinding.ActivityEditMacroBinding r0 = r5.H
            r1 = 0
            if (r0 != 0) goto Lb
            java.lang.String r0 = "binding"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            r0 = r1
        Lb:
            com.google.android.material.floatingactionbutton.FloatingActionButton r0 = r0.acceptButton
            java.lang.String r2 = "binding.acceptButton"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            com.google.android.material.bottomsheet.BottomSheetBehavior<android.view.View> r2 = r5.f11748s
            if (r2 != 0) goto L1c
            java.lang.String r2 = "bottomSheetBehavior"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r2 = r1
        L1c:
            int r2 = r2.getState()
            r3 = 4
            r4 = 0
            if (r2 != r3) goto L3f
            com.arlosoft.macrodroid.macro.Macro r2 = r5.f11735f
            if (r2 != 0) goto L2e
            java.lang.String r2 = "macro"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            goto L2f
        L2e:
            r1 = r2
        L2f:
            boolean r1 = r1.isCompleted()
            if (r1 == 0) goto L3d
            boolean r1 = r5.f11739j
            if (r1 != 0) goto L3d
            boolean r1 = r5.f11741l
            if (r1 == 0) goto L3f
        L3d:
            r1 = 1
            goto L40
        L3f:
            r1 = 0
        L40:
            if (r1 == 0) goto L43
            goto L45
        L43:
            r4 = 8
        L45:
            r0.setVisibility(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.editscreen.EditMacroActivity.v1():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w0() {
        if (CopyHelper.copyItem() != null) {
            SelectableItem copyItem = CopyHelper.copyItem();
            Intrinsics.checkNotNull(copyItem, "null cannot be cast to non-null type com.arlosoft.macrodroid.action.Action");
            Action action = (Action) copyItem;
            Macro macro = this.f11735f;
            if (macro == null) {
                Intrinsics.throwUninitializedPropertyAccessException("macro");
                macro = null;
            }
            macro.getActions().add(action);
            Macro macro2 = this.f11735f;
            if (macro2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("macro");
                macro2 = null;
            }
            action.setMacro(macro2);
            action.setHasEdited(true);
        } else if (CopyHelper.copyItemList() != null) {
            for (SelectableItem selectableItem : CopyHelper.copyItemList()) {
                Intrinsics.checkNotNull(selectableItem, "null cannot be cast to non-null type com.arlosoft.macrodroid.action.Action");
                Action action2 = (Action) selectableItem;
                Macro macro3 = this.f11735f;
                if (macro3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("macro");
                    macro3 = null;
                }
                macro3.getActions().add(action2);
                Macro macro4 = this.f11735f;
                if (macro4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("macro");
                    macro4 = null;
                }
                action2.setMacro(macro4);
                action2.setHasEdited(true);
            }
        }
        ToastCompat.makeText(getApplicationContext(), (int) R.string.item_pasted, 0).show();
        CopyHelper.refreshCopiedItem();
        this.f11741l = true;
        refresh$default(this, false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w1(EditMacroActivity this$0, List removedItems, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(removedItems, "$removedItems");
        Macro macro = this$0.f11735f;
        if (macro == null) {
            Intrinsics.throwUninitializedPropertyAccessException("macro");
            macro = null;
        }
        macro.restoreItems(removedItems);
        refresh$default(this$0, false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x0() {
        SelectableItem copyItem = CopyHelper.copyItem();
        Intrinsics.checkNotNull(copyItem, "null cannot be cast to non-null type com.arlosoft.macrodroid.constraint.Constraint");
        Constraint constraint = (Constraint) copyItem;
        Macro macro = this.f11735f;
        if (macro == null) {
            Intrinsics.throwUninitializedPropertyAccessException("macro");
            macro = null;
        }
        macro.getConstraints().add(constraint);
        Macro macro2 = this.f11735f;
        if (macro2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("macro");
            macro2 = null;
        }
        constraint.setMacro(macro2);
        CopyHelper.refreshCopiedItem();
        constraint.setHasEdited(true);
        ToastCompat.makeText(getApplicationContext(), (int) R.string.item_pasted, 0).show();
        this.f11741l = true;
        refresh$default(this, false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x1(final SelectableItem selectableItem) {
        int i4;
        int i5;
        boolean z3;
        List<Constraint> constraints;
        List<Constraint> constraints2;
        int i6;
        int i7;
        this.f11736g = selectableItem;
        ArrayList arrayList = new ArrayList();
        if (selectableItem instanceof EndParentAction) {
            arrayList.add(getString(R.string.add_action_above));
            if ((CopyHelper.copyItem() != null && (CopyHelper.copyItem() instanceof Action)) || CopyHelper.copyItemList() != null) {
                arrayList.add(getString(R.string.paste_action_above));
            }
        } else if (selectableItem instanceof ElseParentAction) {
            if ((selectableItem instanceof ElseIfConditionAction) || (selectableItem instanceof ElseIfConfirmedThenAction)) {
                arrayList.add(getString(R.string.configure));
            }
            arrayList.add(getString(R.string.add_action_above));
            if ((CopyHelper.copyItem() != null && (CopyHelper.copyItem() instanceof Action)) || CopyHelper.copyItemList() != null) {
                arrayList.add(getString(R.string.paste_action_above));
            }
            arrayList.add(getString(R.string.add_child_action));
            ElseParentAction elseParentAction = (ElseParentAction) selectableItem;
            if (TextUtils.isEmpty(elseParentAction.getComment())) {
                arrayList.add(getString(R.string.add_comment));
            } else {
                arrayList.add(getString(R.string.edit_comment));
            }
            arrayList.add(getString(R.string.delete));
            Macro macro = this.f11735f;
            if (macro == null) {
                Intrinsics.throwUninitializedPropertyAccessException("macro");
                macro = null;
            }
            Intrinsics.checkNotNull(selectableItem, "null cannot be cast to non-null type com.arlosoft.macrodroid.action.Action");
            ParentAction parentAction = macro.getParentAction((Action) selectableItem);
            if (parentAction != null && parentAction.isEnabled()) {
                if (elseParentAction.isEnabled()) {
                    i6 = R.string.disable;
                } else {
                    i6 = R.string.enable;
                }
                arrayList.add(getString(i6));
                if (selectableItem.isEnabled()) {
                    i7 = R.string.disable_condition_or_loop_action_including_children;
                } else {
                    i7 = R.string.enable_condition_or_loop_action_including_children;
                }
                arrayList.add(getString(i7));
            }
        } else {
            if (selectableItem.hasOptions()) {
                arrayList.add(getString(R.string.configure));
            }
            if (selectableItem instanceof Trigger) {
                arrayList.add(getString(R.string.test_trigger));
                Intrinsics.checkNotNullExpressionValue(((Trigger) selectableItem).getConstraints(), "item.constraints");
                if (!constraints2.isEmpty()) {
                    arrayList.add(getString(R.string.test_trigger) + " (" + getString(R.string.testing_trigger_or_action_with_constraints) + ")");
                }
            }
            boolean z4 = selectableItem instanceof Action;
            if (z4) {
                if (!(selectableItem instanceof ParentAction)) {
                    arrayList.add(getString(R.string.test_action));
                    Intrinsics.checkNotNullExpressionValue(((Action) selectableItem).getConstraints(), "item.constraints");
                    if (!constraints.isEmpty()) {
                        arrayList.add(getString(R.string.test_action) + " (" + getString(R.string.testing_trigger_or_action_with_constraints) + ")");
                    }
                }
                arrayList.add(getString(R.string.add_action_above));
            }
            boolean z5 = selectableItem instanceof ParentAction;
            if (z5) {
                arrayList.add(getString(R.string.add_child_action));
            } else if (!(selectableItem instanceof Constraint) || (selectableItem instanceof LogicConstraint)) {
                arrayList.add(getString(R.string.add_constraint));
                if (CopyHelper.copyItem() != null && (CopyHelper.copyItem() instanceof Constraint)) {
                    arrayList.add(getString(R.string.paste_constraint));
                }
            }
            if (selectableItem instanceof IfConditionAction) {
                Macro macro2 = this.f11735f;
                if (macro2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("macro");
                    macro2 = null;
                }
                int indexOf = macro2.getActions().indexOf(selectableItem);
                Macro macro3 = this.f11735f;
                if (macro3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("macro");
                    macro3 = null;
                }
                int endIfIndex = MacroListUtils.getEndIfIndex(macro3.getActions(), indexOf);
                Macro macro4 = this.f11735f;
                if (macro4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("macro");
                    macro4 = null;
                }
                int elseIndex = MacroListUtils.getElseIndex(macro4.getActions(), indexOf);
                arrayList.add(getString(R.string.add_else_if_clause));
                arrayList.add(getString(R.string.add_else_if_confirmed_clause));
                if (1 <= elseIndex && elseIndex < endIfIndex) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (!z3) {
                    arrayList.add(getString(R.string.add_else_clause));
                }
            }
            if (TextUtils.isEmpty(selectableItem.getComment())) {
                arrayList.add(getString(R.string.add_comment));
            } else {
                arrayList.add(getString(R.string.edit_comment));
            }
            boolean z6 = selectableItem instanceof WidgetPressedTrigger;
            if (!z6) {
                arrayList.add(getString(R.string.ui_interaction_cut));
            }
            if (!z6) {
                arrayList.add(getString(R.string.action_file_operation_copy));
            }
            if ((CopyHelper.copyItem() != null && (CopyHelper.copyItem() instanceof Action)) || CopyHelper.copyItemList() != null) {
                arrayList.add(getString(R.string.paste_action_above));
            }
            if (z4) {
                arrayList.add(getString(R.string.extract_to_action_block));
            }
            arrayList.add(getString(R.string.delete));
            if (z5) {
                arrayList.add(getString(R.string.delete_condition_or_loop_including_children));
            }
            if (selectableItem.isEnabled()) {
                i4 = R.string.disable;
            } else {
                i4 = R.string.enable;
            }
            arrayList.add(getString(i4));
            if (z5) {
                if (((ParentAction) selectableItem).isEnabled()) {
                    i5 = R.string.disable_condition_or_loop_action_including_children;
                } else {
                    i5 = R.string.enable_condition_or_loop_action_including_children;
                }
                arrayList.add(getString(i5));
            }
            arrayList.add(getString(R.string.help));
            if (selectableItem instanceof Constraint) {
                Macro macro5 = this.f11735f;
                if (macro5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("macro");
                    macro5 = null;
                }
                SelectableItem findChildByGUID = macro5.findChildByGUID(((Constraint) selectableItem).getParentGUID());
                if (findChildByGUID != null && findChildByGUID.getConstraints().size() > 1) {
                    if (findChildByGUID.getConstraints().indexOf(selectableItem) > 0) {
                        arrayList.add(getString(R.string.move_up));
                    }
                    if (findChildByGUID.getConstraints().indexOf(selectableItem) < findChildByGUID.getConstraints().size() - 1) {
                        arrayList.add(getString(R.string.move_down));
                    }
                }
            }
        }
        if (arrayList.size() == 0) {
            return;
        }
        final String[] strArr = (String[]) arrayList.toArray(new String[0]);
        AlertDialog.Builder builder = new AlertDialog.Builder(this, t0(selectableItem));
        builder.setTitle(selectableItem.getEditMacroConfiguredName()).setItems(strArr, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.editscreen.m
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i8) {
                EditMacroActivity.y1(EditMacroActivity.this, strArr, selectableItem, dialogInterface, i8);
            }
        });
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y0() {
        SelectableItem copyItem = CopyHelper.copyItem();
        Intrinsics.checkNotNull(copyItem, "null cannot be cast to non-null type com.arlosoft.macrodroid.triggers.Trigger");
        Trigger trigger = (Trigger) copyItem;
        Macro macro = this.f11735f;
        if (macro == null) {
            Intrinsics.throwUninitializedPropertyAccessException("macro");
            macro = null;
        }
        macro.getTriggerList().add(trigger);
        Macro macro2 = this.f11735f;
        if (macro2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("macro");
            macro2 = null;
        }
        trigger.setMacro(macro2);
        ToastCompat.makeText(getApplicationContext(), (int) R.string.item_pasted, 0).show();
        CopyHelper.refreshCopiedItem();
        trigger.setHasEdited(true);
        this.f11741l = true;
        refresh$default(this, false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:143:0x03a3  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x041b  */
    /* JADX WARN: Removed duplicated region for block: B:295:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:297:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void y1(com.arlosoft.macrodroid.editscreen.EditMacroActivity r9, java.lang.String[] r10, com.arlosoft.macrodroid.common.SelectableItem r11, android.content.DialogInterface r12, int r13) {
        /*
            Method dump skipped, instructions count: 1686
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.editscreen.EditMacroActivity.y1(com.arlosoft.macrodroid.editscreen.EditMacroActivity, java.lang.String[], com.arlosoft.macrodroid.common.SelectableItem, android.content.DialogInterface, int):void");
    }

    private final void z0() {
        List<Integer> emptyList;
        ActivityEditMacroBinding activityEditMacroBinding = this.H;
        ActivityEditMacroBinding activityEditMacroBinding2 = null;
        if (activityEditMacroBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityEditMacroBinding = null;
        }
        if (activityEditMacroBinding.searchExpandable.isExpanded()) {
            AllSelectableItemsListAdapter allSelectableItemsListAdapter = this.f11738i;
            if (allSelectableItemsListAdapter != null) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                allSelectableItemsListAdapter.highlightSearchItems(emptyList);
            }
        } else {
            AllSelectableItemsListAdapter allSelectableItemsListAdapter2 = this.f11738i;
            if (allSelectableItemsListAdapter2 != null) {
                allSelectableItemsListAdapter2.highlightSearchItems(this.D);
            }
        }
        ActivityEditMacroBinding activityEditMacroBinding3 = this.H;
        if (activityEditMacroBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityEditMacroBinding2 = activityEditMacroBinding3;
        }
        activityEditMacroBinding2.searchExpandable.toggle();
    }

    private final void z1(final int i4) {
        Macro macro;
        AppCompatDialog appCompatDialog = new AppCompatDialog(this, R.style.Theme_App_Dialog_Invert_Action);
        appCompatDialog.setContentView(R.layout.dialog_extract_to_action_block);
        appCompatDialog.setTitle(R.string.extract_to_action_block);
        DialogExtensionsKt.setWidthToParent$default(appCompatDialog, 0, 1, null);
        View findViewById = appCompatDialog.findViewById(R.id.extractActionsList);
        Intrinsics.checkNotNull(findViewById);
        final RecyclerView recyclerView = (RecyclerView) findViewById;
        View findViewById2 = appCompatDialog.findViewById(R.id.actionBlockNameText);
        Intrinsics.checkNotNull(findViewById2);
        TextView textView = (TextView) findViewById2;
        View findViewById3 = appCompatDialog.findViewById(R.id.okButton);
        Intrinsics.checkNotNull(findViewById3);
        Button button = (Button) findViewById3;
        View findViewById4 = appCompatDialog.findViewById(R.id.cancelButton);
        Intrinsics.checkNotNull(findViewById4);
        Button button2 = (Button) findViewById4;
        View findViewById5 = appCompatDialog.findViewById(R.id.topUpButton);
        Intrinsics.checkNotNull(findViewById5);
        ImageButton imageButton = (ImageButton) findViewById5;
        View findViewById6 = appCompatDialog.findViewById(R.id.topDownButton);
        Intrinsics.checkNotNull(findViewById6);
        ImageButton imageButton2 = (ImageButton) findViewById6;
        View findViewById7 = appCompatDialog.findViewById(R.id.bottomUpButton);
        Intrinsics.checkNotNull(findViewById7);
        ImageButton imageButton3 = (ImageButton) findViewById7;
        View findViewById8 = appCompatDialog.findViewById(R.id.bottomDownButton);
        Intrinsics.checkNotNull(findViewById8);
        ImageButton imageButton4 = (ImageButton) findViewById8;
        Macro macro2 = this.f11735f;
        if (macro2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("macro");
            macro = null;
        } else {
            macro = macro2;
        }
        Macro macro3 = this.f11735f;
        if (macro3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("macro");
            macro3 = null;
        }
        ArrayList<Action> actions = macro3.getActions();
        Intrinsics.checkNotNullExpressionValue(actions, "macro.actions");
        SelectableItemsListAdapter<Action> selectableItemsListAdapter = new SelectableItemsListAdapter<>(this, macro, actions, z.f11776d, a0.f11764d, b0.f11766d, true, !this.f11739j, new c0());
        selectableItemsListAdapter.setHighlightRange(i4, i4);
        F1(selectableItemsListAdapter);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        ViewExtensionsKt.onClick$default(imageButton, null, new t(selectableItemsListAdapter, linearLayoutManager, recyclerView, this, null), 1, null);
        ViewExtensionsKt.onClick$default(imageButton2, null, new u(selectableItemsListAdapter, linearLayoutManager, recyclerView, this, null), 1, null);
        ViewExtensionsKt.onClick$default(imageButton3, null, new v(selectableItemsListAdapter, linearLayoutManager, recyclerView, this, null), 1, null);
        ViewExtensionsKt.onClick$default(imageButton4, null, new w(selectableItemsListAdapter, linearLayoutManager, recyclerView, this, null), 1, null);
        ViewExtensionsKt.onClick$default(button, null, new x(textView, selectableItemsListAdapter, appCompatDialog, null), 1, null);
        ViewExtensionsKt.onClick$default(button2, null, new y(appCompatDialog, null), 1, null);
        recyclerView.setItemAnimator(null);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(selectableItemsListAdapter);
        Intrinsics.checkNotNullExpressionValue(OneShotPreDrawListener.add(recyclerView, new Runnable() { // from class: com.arlosoft.macrodroid.editscreen.EditMacroActivity$showExtractToActionBlock$$inlined$doOnPreDraw$1
            @Override // java.lang.Runnable
            public final void run() {
                if (i4 > linearLayoutManager.findLastCompletelyVisibleItemPosition()) {
                    recyclerView.scrollToPosition(i4);
                }
            }
        }), "View.doOnPreDraw(\n    cr…dd(this) { action(this) }");
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
    public final RemoteConfig getRemoteConfig() {
        RemoteConfig remoteConfig = this.remoteConfig;
        if (remoteConfig != null) {
            return remoteConfig;
        }
        Intrinsics.throwUninitializedPropertyAccessException("remoteConfig");
        return null;
    }

    public final void handleOptionsDialogCancel() {
        if (this.A != null) {
            Macro macro = this.f11735f;
            if (macro == null) {
                Intrinsics.throwUninitializedPropertyAccessException("macro");
                macro = null;
            }
            macro.removeItem(this.A);
            this.A = null;
            refresh(true);
        }
    }

    public final boolean isEditingCondition() {
        return this.f11736g instanceof ConditionAction;
    }

    @Override // com.arlosoft.macrodroid.widget.ItemFinishedListener
    public void itemCancelled() {
        SelectableItem selectableItem = this.f11736g;
        if (selectableItem != null) {
            selectableItem.handleItemCancel();
        }
    }

    @Override // com.arlosoft.macrodroid.widget.ItemFinishedListener
    public void itemComplete(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        SelectableItem selectableItem = this.f11736g;
        if (selectableItem != null) {
            selectableItem.handleItemComplete(obj);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i4, int i5, @Nullable Intent intent) {
        super.onActivityResult(i4, i5, intent);
        switch (i4) {
            case 909091:
            case 909092:
            case 909093:
                if (i5 == -1) {
                    this.f11741l = true;
                    return;
                }
                return;
            default:
                Macro macro = this.f11735f;
                Macro macro2 = null;
                if (macro == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("macro");
                    macro = null;
                }
                if (macro.getActionBeingConfigured() != null) {
                    Macro macro3 = this.f11735f;
                    if (macro3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("macro");
                    } else {
                        macro2 = macro3;
                    }
                    macro2.getActionBeingConfigured().handleActivityResult(this, i4, i5, intent);
                    return;
                }
                SelectableItem selectableItem = this.f11736g;
                if (selectableItem != null) {
                    selectableItem.handleActivityResult(this, i4, i5, intent);
                    return;
                }
                return;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:82:0x014d, code lost:
        if (r2.macroNameText.length() == 0) goto L94;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onBackPressed(final boolean r13) {
        /*
            Method dump skipped, instructions count: 464
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.editscreen.EditMacroActivity.onBackPressed(boolean):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:126:0x03c2  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x03c9  */
    @Override // com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity, com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onCreate(@org.jetbrains.annotations.Nullable android.os.Bundle r22) {
        /*
            Method dump skipped, instructions count: 1723
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.editscreen.EditMacroActivity.onCreate(android.os.Bundle):void");
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(@NotNull Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        getMenuInflater().inflate(R.menu.edit_macros_menu, menu);
        D1();
        if (this.f11746q) {
            menu.findItem(R.id.menu_enable_disable_macro).setVisible(false);
            menu.findItem(R.id.menu_variables).setVisible(false);
            menu.findItem(R.id.add_disabled).setVisible(true);
        }
        MenuItem findItem = menu.findItem(R.id.menu_allow_logging);
        Macro macro = this.f11735f;
        Macro macro2 = null;
        if (macro == null) {
            Intrinsics.throwUninitializedPropertyAccessException("macro");
            macro = null;
        }
        findItem.setChecked(!macro.isExcludedFromLog());
        MenuItem findItem2 = menu.findItem(R.id.menu_local_variables_display_mode);
        Intrinsics.checkNotNullExpressionValue(findItem2, "menu.findItem(R.id.menu_…l_variables_display_mode)");
        this.f11754y = findItem2;
        MenuInflater menuInflater = getMenuInflater();
        MenuItem menuItem = this.f11754y;
        if (menuItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("localVarsMenuItem");
            menuItem = null;
        }
        menuInflater.inflate(R.menu.local_vars_display_mode_menu, menuItem.getSubMenu());
        k1();
        if (!this.f11741l) {
            menu.findItem(R.id.menu_save_changes).setVisible(false);
        }
        Macro macro3 = this.f11735f;
        if (macro3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("macro");
            macro3 = null;
        }
        if (!macro3.isCompleted()) {
            menu.findItem(R.id.menu_delete).setVisible(false);
            menu.findItem(R.id.menu_copy).setVisible(false);
            menu.findItem(R.id.menu_share).setVisible(false);
            menu.findItem(R.id.menu_share_as_image).setVisible(false);
        }
        Macro macro4 = this.f11735f;
        if (macro4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("macro");
        } else {
            macro2 = macro4;
        }
        if (!macro2.isEnabled()) {
            menu.findItem(R.id.menu_enable_disable_macro).setTitle(R.string.action_disable_macro_enable);
        }
        return true;
    }

    @Override // com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.f11736g = null;
    }

    public final void onEventMainThread(@NotNull MacroDeletedEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        long j4 = event.GUID;
        Macro macro = this.f11735f;
        if (macro == null) {
            Intrinsics.throwUninitializedPropertyAccessException("macro");
            macro = null;
        }
        if (j4 == macro.getGUID()) {
            finish();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    protected void onNewIntent(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        setIntent(intent);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(@NotNull MenuItem item) {
        boolean z3;
        Intrinsics.checkNotNullParameter(item, "item");
        Macro macro = null;
        switch (item.getItemId()) {
            case 16908332:
                onBackPressed(true);
                break;
            case R.id.add_disabled /* 2131361925 */:
                v0(true);
                break;
            case R.id.menu_allow_logging /* 2131363376 */:
                Macro macro2 = this.f11735f;
                if (macro2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("macro");
                    macro2 = null;
                }
                Macro macro3 = this.f11735f;
                if (macro3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("macro");
                    macro3 = null;
                }
                macro2.setExcludeFromLog(!macro3.isExcludedFromLog());
                Macro macro4 = this.f11735f;
                if (macro4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("macro");
                } else {
                    macro = macro4;
                }
                item.setChecked(!macro.isExcludedFromLog());
                break;
            case R.id.menu_bottom_bar /* 2131363379 */:
                Settings.setLocalVarsDisplayMode(this, 2);
                n1();
                k1();
                break;
            case R.id.menu_copy /* 2131363383 */:
                Z0();
                break;
            case R.id.menu_delete /* 2131363387 */:
                c1();
                break;
            case R.id.menu_enable_disable_macro /* 2131363393 */:
                Macro macro5 = this.f11735f;
                if (macro5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("macro");
                    macro5 = null;
                }
                Macro macro6 = this.f11735f;
                if (macro6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("macro");
                } else {
                    macro = macro6;
                }
                macro5.setEnabled(!macro.isEnabled());
                this.f11749t = true;
                invalidateOptionsMenu();
                u1();
                break;
            case R.id.menu_hide /* 2131363397 */:
                Settings.setLocalVarsDisplayMode(this, 0);
                n1();
                k1();
                break;
            case R.id.menu_inline /* 2131363401 */:
                Settings.setLocalVarsDisplayMode(this, 1);
                n1();
                k1();
                break;
            case R.id.menu_run /* 2131363418 */:
                Q0();
                break;
            case R.id.menu_save_changes /* 2131363421 */:
                ActivityEditMacroBinding activityEditMacroBinding = this.H;
                if (activityEditMacroBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityEditMacroBinding = null;
                }
                Editable text = activityEditMacroBinding.macroNameText.getText();
                Intrinsics.checkNotNullExpressionValue(text, "binding.macroNameText.text");
                if (text.length() == 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    Util.displayErrorDialog(this, getString(R.string.invalid_macro), getString(R.string.please_set_a_macro_name));
                    break;
                } else {
                    W();
                    this.f11741l = false;
                    Macro macro7 = this.f11735f;
                    if (macro7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("macro");
                        macro7 = null;
                    }
                    o1(!macro7.isEnabled());
                    Macro macro8 = this.f11735f;
                    if (macro8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("macro");
                    } else {
                        macro = macro8;
                    }
                    this.B = macro.createExactClone();
                    A0();
                    Z();
                    D1();
                    AllSelectableItemsListAdapter allSelectableItemsListAdapter = this.f11738i;
                    if (allSelectableItemsListAdapter != null) {
                        allSelectableItemsListAdapter.notifyDataSetChanged();
                        break;
                    }
                }
                break;
            case R.id.menu_search /* 2131363423 */:
                z0();
                break;
            case R.id.menu_select_category /* 2131363424 */:
                p1();
                break;
            case R.id.menu_share /* 2131363426 */:
                S0();
                break;
            case R.id.menu_share_as_image /* 2131363428 */:
                R0();
                break;
            case R.id.menu_share_nearby /* 2131363431 */:
                T0();
                break;
            case R.id.menu_test_macro /* 2131363439 */:
                U0();
                break;
            case R.id.menu_text_size /* 2131363440 */:
                boolean z4 = !this.f11745p;
                this.f11745p = z4;
                Settings.setEditMacroSmallMode(this, z4);
                refresh(true);
                break;
            case R.id.menu_toggle_description /* 2131363441 */:
                u0();
                break;
            case R.id.menu_variables /* 2131363446 */:
                Macro macro9 = this.f11735f;
                if (macro9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("macro");
                } else {
                    macro = macro9;
                }
                startActivity(MacroDroidVariablesActivity.createIntent(this, macro.getGUID()));
                break;
            case R.id.show_log /* 2131364028 */:
                SystemLogActivity.Companion companion = SystemLogActivity.Companion;
                Macro macro10 = this.f11735f;
                if (macro10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("macro");
                } else {
                    macro = macro10;
                }
                companion.launchForIndividualMacro(this, macro.getGUID());
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

    @Override // com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        EventBusUtils.getEventBus().unregister(this);
        if (this.C) {
            getNearbyHelper().stopDiscovery();
            getNearbyHelper().disconnect();
            getNearbyHelper().cleanUpHelper();
        }
        Macro macro = this.f11735f;
        if (macro != null) {
            if (macro == null) {
                Intrinsics.throwUninitializedPropertyAccessException("macro");
                macro = null;
            }
            macro.removeLocalVariableUpdatedListener(this.I);
        }
        super.onPause();
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(@NotNull Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        menu.findItem(R.id.menu_save_changes).setVisible(this.f11741l);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i4, @NotNull String[] permissions, @NotNull int[] grantResults) {
        boolean z3;
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        if (i4 != 34) {
            if (i4 != 3000) {
                super.onRequestPermissionsResult(i4, permissions, grantResults);
                return;
            }
            if (grantResults.length == 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            if ((!z3) && grantResults[0] == 0) {
                S0();
            }
            super.onRequestPermissionsResult(i4, permissions, grantResults);
            return;
        }
        SelectableItem selectableItem = this.f11736g;
        if (selectableItem != null) {
            PermissionsHelper.handleRequestPermissionResult(selectableItem, permissions, grantResults);
        }
    }

    @Override // com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (!EventBusUtils.getEventBus().isRegistered(this)) {
            EventBusUtils.getEventBus().register(this);
        }
        this.C = false;
        Macro macroById = MacroStore.getInstance().getMacroById(this.f11737h);
        if (macroById == null) {
            finish();
            return;
        }
        this.f11735f = macroById;
        ActivityEditMacroBinding activityEditMacroBinding = null;
        refresh$default(this, false, 1, null);
        E1();
        Macro macro = this.f11735f;
        if (macro == null) {
            Intrinsics.throwUninitializedPropertyAccessException("macro");
            macro = null;
        }
        macro.addLocalVariableUpdatedListener(this.I);
        ActivityEditMacroBinding activityEditMacroBinding2 = this.H;
        if (activityEditMacroBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityEditMacroBinding = activityEditMacroBinding2;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(activityEditMacroBinding.acceptButton, "translationX", 0.0f);
        ofFloat.setDuration(0L);
        ofFloat.start();
        v1();
    }

    @Override // com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(@NotNull Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        outState.putInt("MacroId", this.f11737h);
        outState.putBoolean("HasEdited", this.f11741l);
        outState.putBoolean(Constants.EXTRA_IS_CLONE, this.f11744o);
        outState.putParcelable("selectable_item", this.f11736g);
        super.onSaveInstanceState(outState);
    }

    public final void refresh(boolean z3) {
        i1(z3);
        SelectableItem selectableItem = this.f11736g;
        if (selectableItem != null) {
            selectableItem.refresh();
        }
        SelectableItem selectableItem2 = this.f11736g;
        if (selectableItem2 instanceof ConditionAction) {
            Intrinsics.checkNotNull(selectableItem2, "null cannot be cast to non-null type com.arlosoft.macrodroid.action.ConditionAction");
            ((ConditionAction) selectableItem2).configureConditionsList();
        }
        Z();
        D1();
    }

    public final void setActionBlockStore(@NotNull ActionBlockStore actionBlockStore) {
        Intrinsics.checkNotNullParameter(actionBlockStore, "<set-?>");
        this.actionBlockStore = actionBlockStore;
    }

    public final void setHasEdited() {
        this.f11741l = true;
        D1();
    }

    public final void setNearbyHelper(@NotNull NearbyHelper nearbyHelper) {
        Intrinsics.checkNotNullParameter(nearbyHelper, "<set-?>");
        this.nearbyHelper = nearbyHelper;
    }

    public final void setPremiumStatusHandler(@NotNull PremiumStatusHandler premiumStatusHandler) {
        Intrinsics.checkNotNullParameter(premiumStatusHandler, "<set-?>");
        this.premiumStatusHandler = premiumStatusHandler;
    }

    public final void setRemoteConfig(@NotNull RemoteConfig remoteConfig) {
        Intrinsics.checkNotNullParameter(remoteConfig, "<set-?>");
        this.remoteConfig = remoteConfig;
    }

    public final void onEventMainThread(@NotNull RefreshEditMacroPageEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        refresh$default(this, false, 1, null);
    }

    public final void onEventMainThread(@NotNull MacroEnabledStateChangeEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        long guid = event.macro.getGUID();
        Macro macro = this.f11735f;
        if (macro == null) {
            Intrinsics.throwUninitializedPropertyAccessException("macro");
            macro = null;
        }
        if (guid == macro.getGUID()) {
            refresh$default(this, false, 1, null);
            u1();
        }
    }
}
