package com.arlosoft.macrodroid.editscreen;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.Action;
import com.arlosoft.macrodroid.action.ActionBlockAction;
import com.arlosoft.macrodroid.action.ConditionAction;
import com.arlosoft.macrodroid.action.ElseParentAction;
import com.arlosoft.macrodroid.action.EndIfAction;
import com.arlosoft.macrodroid.action.EndLoopAction;
import com.arlosoft.macrodroid.action.EndParentAction;
import com.arlosoft.macrodroid.action.ForceMacroRunAction;
import com.arlosoft.macrodroid.action.IfConditionAction;
import com.arlosoft.macrodroid.action.LoopAction;
import com.arlosoft.macrodroid.action.ParentAction;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.constraint.Constraint;
import com.arlosoft.macrodroid.extensions.IntExtensionsKt;
import com.arlosoft.macrodroid.extensions.ViewExtensionsKt;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.Trigger;
import com.arlosoft.macrodroid.utils.AdbHelperUtil;
import com.arlosoft.macrodroid.utils.MDTextUtils;
import com.arlosoft.macrodroid.utils.MacroListUtils;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.h6ah4i.android.widget.advrecyclerview.utils.AbstractDraggableItemViewHolder;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SelectableItemsViewHolder.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nSelectableItemsViewHolder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SelectableItemsViewHolder.kt\ncom/arlosoft/macrodroid/editscreen/SelectableItemsViewHolder\n+ 2 View.kt\nandroidx/core/view/ViewKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,649:1\n262#2,2:650\n262#2,2:652\n262#2,2:654\n262#2,2:656\n262#2,2:658\n262#2,2:660\n262#2,2:662\n262#2,2:664\n262#2,2:666\n262#2,2:668\n262#2,2:670\n262#2,2:672\n262#2,2:674\n262#2,2:676\n262#2,2:678\n262#2,2:680\n262#2,2:682\n262#2,2:684\n262#2,2:686\n262#2,2:688\n262#2,2:690\n262#2,2:692\n262#2,2:694\n262#2,2:696\n262#2,2:698\n262#2,2:700\n262#2,2:702\n262#2,2:704\n262#2,2:706\n262#2,2:708\n262#2,2:710\n1#3:712\n*S KotlinDebug\n*F\n+ 1 SelectableItemsViewHolder.kt\ncom/arlosoft/macrodroid/editscreen/SelectableItemsViewHolder\n*L\n118#1:650,2\n126#1:652,2\n153#1:654,2\n205#1:656,2\n241#1:658,2\n243#1:660,2\n244#1:662,2\n265#1:664,2\n295#1:666,2\n296#1:668,2\n299#1:670,2\n303#1:672,2\n324#1:674,2\n373#1:676,2\n378#1:678,2\n395#1:680,2\n399#1:682,2\n400#1:684,2\n417#1:686,2\n462#1:688,2\n469#1:690,2\n473#1:692,2\n475#1:694,2\n486#1:696,2\n527#1:698,2\n528#1:700,2\n569#1:702,2\n570#1:704,2\n613#1:706,2\n637#1:708,2\n639#1:710,2\n*E\n"})
/* loaded from: classes3.dex */
public final class SelectableItemsViewHolder extends AbstractDraggableItemViewHolder {
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final Activity f11850b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final Macro f11851c;
    @BindView(R.id.collapse_expand_button)
    public ImageView collapseExpandButton;
    @BindView(R.id.constraintContainer)
    public ViewGroup constraintContainer;
    @BindView(R.id.constraintLinkUnderAction)
    public View constraintLinkUnderAction;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private final Function1<SelectableItem, Unit> f11852d;
    @BindView(R.id.dragHandle)
    public View dragHandle;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private final Function1<SelectableItem, Unit> f11853e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private final Function1<SelectableItem, Unit> f11854f;
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private final Observable<Boolean> f11855g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private final Function1<SelectableItem, Unit> f11856h;

    /* renamed from: i  reason: collision with root package name */
    private final int f11857i;

    /* renamed from: j  reason: collision with root package name */
    private final int f11858j;

    /* renamed from: k  reason: collision with root package name */
    private final int f11859k;

    /* renamed from: l  reason: collision with root package name */
    private final int f11860l;

    /* renamed from: m  reason: collision with root package name */
    private final int f11861m;

    /* renamed from: n  reason: collision with root package name */
    private final int f11862n;
    @Nullable

    /* renamed from: o  reason: collision with root package name */
    private Boolean f11863o;
    @BindView(R.id.topLevelContainer)
    public ViewGroup topLevelContainer;
    @BindView(R.id.topLevelExtrasContainer)
    public ViewGroup topLevelExtrasContainer;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* renamed from: p  reason: collision with root package name */
    private static final int f11845p = IntExtensionsKt.getPx(32);

    /* renamed from: q  reason: collision with root package name */
    private static final int f11846q = IntExtensionsKt.getPx(6);

    /* renamed from: r  reason: collision with root package name */
    private static final int f11847r = IntExtensionsKt.getPx(26);

    /* renamed from: s  reason: collision with root package name */
    private static final int f11848s = IntExtensionsKt.getPx(5);

    /* renamed from: t  reason: collision with root package name */
    private static final int f11849t = IntExtensionsKt.getPx(4);

    /* compiled from: SelectableItemsViewHolder.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SelectableItemsViewHolder.kt */
    /* loaded from: classes3.dex */
    public static final class a extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ SelectableItem $item;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(SelectableItem selectableItem, Continuation<? super a> continuation) {
            super(3, continuation);
            this.$item = selectableItem;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new a(this.$item, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                Function1 function1 = SelectableItemsViewHolder.this.f11854f;
                if (function1 != null) {
                    function1.invoke(this.$item);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SelectableItemsViewHolder.kt */
    /* loaded from: classes3.dex */
    public static final class b extends Lambda implements Function0<Unit> {
        final /* synthetic */ SelectableItem $item;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(SelectableItem selectableItem) {
            super(0);
            this.$item = selectableItem;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Function1 function1 = SelectableItemsViewHolder.this.f11856h;
            if (function1 != null) {
                function1.invoke(this.$item);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SelectableItemsViewHolder.kt */
    /* loaded from: classes3.dex */
    public static final class c extends Lambda implements Function1<Boolean, Unit> {
        final /* synthetic */ ViewGroup $container;
        final /* synthetic */ SelectableItem $item;
        final /* synthetic */ ImageView $warningIcon;
        final /* synthetic */ TextView $warningText;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(SelectableItem selectableItem, TextView textView, ImageView imageView, ViewGroup viewGroup) {
            super(1);
            this.$item = selectableItem;
            this.$warningText = textView;
            this.$warningIcon = imageView;
            this.$container = viewGroup;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke2(bool);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(Boolean bool) {
            SelectableItemsViewHolder.this.f11863o = bool;
            SelectableItemsViewHolder selectableItemsViewHolder = SelectableItemsViewHolder.this;
            Boolean bool2 = selectableItemsViewHolder.f11863o;
            Intrinsics.checkNotNull(bool2);
            boolean booleanValue = bool2.booleanValue();
            SelectableItem selectableItem = this.$item;
            TextView warningText = this.$warningText;
            Intrinsics.checkNotNullExpressionValue(warningText, "warningText");
            ImageView warningIcon = this.$warningIcon;
            Intrinsics.checkNotNullExpressionValue(warningIcon, "warningIcon");
            ViewGroup container = this.$container;
            Intrinsics.checkNotNullExpressionValue(container, "container");
            selectableItemsViewHolder.h(booleanValue, selectableItem, warningText, warningIcon, container);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SelectableItemsViewHolder.kt */
    @SourceDebugExtension({"SMAP\nSelectableItemsViewHolder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SelectableItemsViewHolder.kt\ncom/arlosoft/macrodroid/editscreen/SelectableItemsViewHolder$displayItem$3\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,649:1\n1#2:650\n*E\n"})
    /* loaded from: classes3.dex */
    public static final class d extends Lambda implements Function0<Unit> {
        final /* synthetic */ SelectableItem $item;
        final /* synthetic */ Ref.LongRef $lastClick;
        final /* synthetic */ SelectableItemsViewHolder this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(Ref.LongRef longRef, SelectableItemsViewHolder selectableItemsViewHolder, SelectableItem selectableItem) {
            super(0);
            this.$lastClick = longRef;
            this.this$0 = selectableItemsViewHolder;
            this.$item = selectableItem;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            this.$lastClick.element = System.currentTimeMillis();
            Function1 function1 = this.this$0.f11852d;
            if (function1 != null) {
                function1.invoke(this.$item);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SelectableItemsViewHolder.kt */
    @SourceDebugExtension({"SMAP\nSelectableItemsViewHolder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SelectableItemsViewHolder.kt\ncom/arlosoft/macrodroid/editscreen/SelectableItemsViewHolder$displayItem$5\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,649:1\n1#2:650\n*E\n"})
    /* loaded from: classes3.dex */
    public static final class e extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ SelectableItem $item;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(SelectableItem selectableItem, Continuation<? super e> continuation) {
            super(3, continuation);
            this.$item = selectableItem;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new e(this.$item, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                Function1 unused = SelectableItemsViewHolder.this.f11852d;
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SelectableItemsViewHolder.kt */
    @SourceDebugExtension({"SMAP\nSelectableItemsViewHolder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SelectableItemsViewHolder.kt\ncom/arlosoft/macrodroid/editscreen/SelectableItemsViewHolder$displayItem$6\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,649:1\n1#2:650\n*E\n"})
    /* loaded from: classes3.dex */
    public static final class f extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ SelectableItem $item;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(SelectableItem selectableItem, Continuation<? super f> continuation) {
            super(3, continuation);
            this.$item = selectableItem;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new f(this.$item, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                Function1 unused = SelectableItemsViewHolder.this.f11853e;
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SelectableItemsViewHolder(@NotNull Activity context, @NotNull Macro macro, @NotNull View itemView, @Nullable Function1<? super SelectableItem, Unit> function1, @Nullable Function1<? super SelectableItem, Unit> function12, @Nullable Function1<? super SelectableItem, Unit> function13, @NotNull Observable<Boolean> isRootedSubject, @Nullable Function1<? super SelectableItem, Unit> function14) {
        super(itemView);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(macro, "macro");
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(isRootedSubject, "isRootedSubject");
        this.f11850b = context;
        this.f11851c = macro;
        this.f11852d = function1;
        this.f11853e = function12;
        this.f11854f = function13;
        this.f11855g = isRootedSubject;
        this.f11856h = function14;
        this.f11857i = context.getResources().getDimensionPixelSize(R.dimen.action_child_indent);
        this.f11858j = context.getResources().getDimensionPixelSize(R.dimen.logic_edit_entry_height);
        this.f11859k = context.getResources().getDimensionPixelSize(R.dimen.logic_edit_small_entry_height);
        this.f11860l = context.getResources().getDimensionPixelSize(R.dimen.constraint_level_offset_small);
        this.f11861m = context.getResources().getDimensionPixelSize(R.dimen.constraint_level_offset);
        this.f11862n = context.getResources().getDimensionPixelSize(R.dimen.edit_entry_horizontal_padding);
        ButterKnife.bind(this, itemView);
    }

    public static /* synthetic */ void bind$default(SelectableItemsViewHolder selectableItemsViewHolder, SelectableItem selectableItem, List list, int i4, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, int i5, Object obj) {
        boolean z12;
        boolean z13;
        boolean z14;
        if ((i5 & 128) != 0) {
            z12 = false;
        } else {
            z12 = z7;
        }
        if ((i5 & 256) != 0) {
            z13 = false;
        } else {
            z13 = z8;
        }
        if ((i5 & 512) != 0) {
            z14 = false;
        } else {
            z14 = z9;
        }
        selectableItemsViewHolder.bind(selectableItem, list, i4, z3, z4, z5, z6, z12, z13, z14, z10, z11);
    }

    private final void e(Action action, ImageView imageView, ViewGroup viewGroup, ImageView imageView2, boolean z3, boolean z4, View view) {
        int i4;
        boolean z5 = action instanceof EndLoopAction;
        if (z5 && ((EndLoopAction) action).isEnabled()) {
            ArrayList<Action> actions = this.f11851c.getActions();
            int startLoopIndex = MacroListUtils.getStartLoopIndex(this.f11851c.getActions(), this.f11851c.getActions().indexOf(action));
            if (startLoopIndex >= 0 && !actions.get(startLoopIndex).isEnabled()) {
                viewGroup.setAlpha(0.5f);
            }
        }
        boolean z6 = action instanceof EndIfAction;
        if ((z6 || (action instanceof ElseParentAction)) && action.isEnabled()) {
            ArrayList<Action> actions2 = this.f11851c.getActions();
            int startIfIndex = MacroListUtils.getStartIfIndex(this.f11851c.getActions(), this.f11851c.getActions().indexOf(action));
            if (startIfIndex >= 0 && !actions2.get(startIfIndex).isEnabled()) {
                viewGroup.setAlpha(0.5f);
            }
        }
        if (!(action instanceof IfConditionAction) && !(action instanceof LoopAction) && !z6 && !z5 && !(action instanceof ElseParentAction)) {
            imageView.setBackgroundResource(R.drawable.circular_icon_background_action_dark);
        } else {
            imageView.setBackgroundResource(R.drawable.circular_icon_background_condition);
        }
        if (z3) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        imageView2.setVisibility(i4);
        if (z4) {
            view.setBackgroundResource(R.drawable.constraint_link_end);
        } else {
            view.setBackgroundResource(R.drawable.constraint_link_joiner);
        }
    }

    private final void f(SelectableItem selectableItem, TextView textView, boolean z3) {
        boolean z4;
        int i4;
        textView.setText(selectableItem.getComment());
        String comment = selectableItem.getComment();
        int i5 = 0;
        if (comment != null && comment.length() != 0) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (!z4) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        textView.setVisibility(i4);
        if (z3 && selectableItem.getHasCommentEdited()) {
            i5 = 2;
        }
        textView.setTypeface(null, i5);
    }

    private final void g(Constraint constraint, ImageView imageView, boolean z3, boolean z4, boolean z5, View view, boolean z6) {
        if (z3) {
            imageView.setBackgroundResource(R.drawable.circular_icon_background_constraint_dark);
        } else {
            imageView.setBackgroundResource(R.drawable.circular_icon_background_constraint);
        }
        if (z6) {
            view.setVisibility(8);
            return;
        }
        view.setVisibility(0);
        if (z5) {
            view.setBackgroundResource(R.drawable.constraint_link_end);
        } else {
            view.setBackgroundResource(R.drawable.constraint_link_joiner);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(boolean z3, final SelectableItem selectableItem, TextView textView, ImageView imageView, ViewGroup viewGroup) {
        boolean z4;
        int indexOf$default;
        if (!z3) {
            List<String> adbHackPermissionRequired = selectableItem.getAdbHackPermissionRequired();
            if (adbHackPermissionRequired != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<String> it = adbHackPermissionRequired.iterator();
                while (true) {
                    z4 = true;
                    if (!it.hasNext()) {
                        break;
                    }
                    String next = it.next();
                    Activity activity = this.f11850b;
                    Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.String");
                    if (ContextCompat.checkSelfPermission(activity, next) != 0) {
                        if (sb.length() <= 0) {
                            z4 = false;
                        }
                        if (z4) {
                            sb.append(" + ");
                        }
                        sb.append(next);
                    }
                }
                if (sb.length() <= 0) {
                    z4 = false;
                }
                if (z4) {
                    String sb2 = sb.toString();
                    Intrinsics.checkNotNullExpressionValue(sb2, "permissions.toString()");
                    String str = this.f11850b.getString(R.string.rooted_or_adb_hack_required) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + sb2;
                    SpannableString spannableString = new SpannableString(str);
                    UnderlineSpan underlineSpan = new UnderlineSpan();
                    indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, sb2, 0, false, 6, (Object) null);
                    spannableString.setSpan(underlineSpan, indexOf$default, str.length(), 0);
                    textView.setText(spannableString);
                    textView.setVisibility(0);
                    textView.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.editscreen.z0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            SelectableItemsViewHolder.i(SelectableItemsViewHolder.this, selectableItem, view);
                        }
                    });
                    viewGroup.setBackgroundResource(R.drawable.item_error_border);
                    imageView.setVisibility(0);
                    return;
                }
                return;
            }
            textView.setText(this.f11850b.getString(R.string.rooted_device_required));
            textView.setVisibility(0);
            viewGroup.setBackgroundResource(R.drawable.item_error_border);
            imageView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(SelectableItemsViewHolder this$0, SelectableItem item, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        AdbHelperUtil.showAdbHackDetails(this$0.f11850b, item.getAdbHackPermissionRequired(), new b(item));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v3, types: [android.graphics.Typeface, kotlin.coroutines.Continuation, java.lang.Object, kotlin.coroutines.CoroutineContext] */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r2v18, types: [android.view.View] */
    @SuppressLint({"CheckResult"})
    private final void j(View view, final SelectableItem selectableItem, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, Observable<Boolean> observable, boolean z8, boolean z9) {
        LinearLayout linearLayout;
        String str;
        TextView textView;
        ImageView imageView;
        View view2;
        boolean z10;
        int i4;
        float f4;
        boolean z11;
        ViewGroup viewGroup;
        ?? r13;
        int i5;
        boolean z12;
        TextView itemDetail;
        int i6;
        int i7;
        int i8;
        int i9;
        final Ref.LongRef longRef = new Ref.LongRef();
        ViewGroup container = (ViewGroup) view.findViewById(R.id.topLevelContainer);
        ImageView icon = (ImageView) view.findViewById(R.id.macro_edit_entry_icon);
        TextView textView2 = (TextView) view.findViewById(R.id.macro_edit_entry_name);
        TextView textView3 = (TextView) view.findViewById(R.id.macro_edit_entry_detail);
        ImageView grabHandle = (ImageView) view.findViewById(R.id.dragHandle);
        View findViewById = view.findViewById(R.id.start_spacing);
        ImageView warningIcon = (ImageView) view.findViewById(R.id.macro_edit_warning_icon);
        TextView warningText = (TextView) view.findViewById(R.id.macro_edit_entry_warning_text);
        TextView textView4 = (TextView) view.findViewById(R.id.macro_edit_entry_comment);
        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.collapsed_parent_icons);
        String editModeWarning = selectableItem.getEditModeWarning();
        Intrinsics.checkNotNullExpressionValue(warningIcon, "warningIcon");
        warningIcon.setVisibility(8);
        Intrinsics.checkNotNullExpressionValue(warningText, "warningText");
        warningText.setVisibility(8);
        container.setBackgroundResource(0);
        warningIcon.setVisibility(8);
        if (editModeWarning != null) {
            warningText.setText(editModeWarning);
            warningText.setVisibility(0);
            warningText.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.editscreen.a1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    SelectableItemsViewHolder.k(SelectableItem.this, this, view3);
                }
            });
            linearLayout = linearLayout2;
            str = "container";
            textView = textView4;
            imageView = warningIcon;
            view2 = findViewById;
            z10 = true;
        } else {
            if (selectableItem.isRootOnly()) {
                Boolean bool = this.f11863o;
                if (bool != null) {
                    Intrinsics.checkNotNull(bool);
                    boolean booleanValue = bool.booleanValue();
                    Intrinsics.checkNotNullExpressionValue(container, "container");
                    linearLayout = linearLayout2;
                    str = "container";
                    textView = textView4;
                    imageView = warningIcon;
                    h(booleanValue, selectableItem, warningText, warningIcon, container);
                } else {
                    linearLayout = linearLayout2;
                    str = "container";
                    textView = textView4;
                    imageView = warningIcon;
                    Observable<Boolean> observeOn = observable.take(1L).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
                    view2 = findViewById;
                    final c cVar = new c(selectableItem, warningText, imageView, container);
                    observeOn.subscribe(new Consumer() { // from class: com.arlosoft.macrodroid.editscreen.b1
                        @Override // io.reactivex.functions.Consumer
                        public final void accept(Object obj) {
                            SelectableItemsViewHolder.l(Function1.this, obj);
                        }
                    });
                    z10 = false;
                }
            } else {
                linearLayout = linearLayout2;
                str = "container";
                textView = textView4;
                imageView = warningIcon;
            }
            view2 = findViewById;
            z10 = false;
        }
        icon.setImageDrawable(ContextCompat.getDrawable(this.f11850b, selectableItem.getIcon()));
        Intrinsics.checkNotNullExpressionValue(icon, "icon");
        icon.setVisibility(0);
        boolean z13 = selectableItem instanceof ParentAction;
        if (z13) {
            ParentAction parentAction = (ParentAction) selectableItem;
            if (parentAction.getChildrenCollapsed()) {
                textView2.setText(parentAction.getCollapsedName());
            } else {
                textView2.setText(parentAction.getEditMacroConfiguredName());
            }
        } else {
            textView2.setText(selectableItem.getEditMacroConfiguredName());
        }
        if (z8 && selectableItem.hasEdited()) {
            i4 = 2;
        } else {
            i4 = 0;
        }
        textView2.setTypeface(null, i4);
        textView2.setGravity(8388627);
        TextView commentText = textView;
        Intrinsics.checkNotNullExpressionValue(commentText, "commentText");
        f(selectableItem, commentText, z8);
        if (selectableItem.isEnabled()) {
            f4 = 1.0f;
        } else {
            f4 = 0.5f;
        }
        container.setAlpha(f4);
        Intrinsics.checkNotNullExpressionValue(container, str);
        View spacing = view2;
        ViewExtensionsKt.onClickWithDebounce$default(container, 0L, new d(longRef, this, selectableItem), 1, null);
        container.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.arlosoft.macrodroid.editscreen.c1
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view3) {
                boolean m4;
                m4 = SelectableItemsViewHolder.m(Ref.LongRef.this, this, selectableItem, view3);
                return m4;
            }
        });
        if (selectableItem instanceof Action) {
            Intrinsics.checkNotNullExpressionValue(grabHandle, "grabHandle");
            Intrinsics.checkNotNullExpressionValue(spacing, "spacing");
            r13 = 0;
            z11 = z13;
            viewGroup = container;
            e((Action) selectableItem, icon, container, grabHandle, z4, z3, spacing);
        } else {
            z11 = z13;
            viewGroup = container;
            if (!(selectableItem instanceof Constraint)) {
                r13 = null;
                if (selectableItem instanceof Trigger) {
                    icon.setBackgroundResource(R.drawable.circular_icon_background_trigger_dark);
                    r13 = null;
                }
            } else {
                Intrinsics.checkNotNullExpressionValue(spacing, "spacing");
                g((Constraint) selectableItem, icon, z5, z6, z3, spacing, z7);
                r13 = null;
            }
        }
        if (selectableItem.isValid() && !z10) {
            i5 = 0;
        } else {
            viewGroup.setBackgroundResource(R.drawable.item_error_border);
            i5 = 0;
            imageView.setVisibility(0);
        }
        String extendedDetail = selectableItem.getExtendedDetail();
        if (extendedDetail != null && extendedDetail.length() != 0) {
            z12 = false;
        } else {
            z12 = true;
        }
        if (!z12) {
            itemDetail = textView3;
            Intrinsics.checkNotNullExpressionValue(itemDetail, "itemDetail");
            itemDetail.setVisibility(i5);
            if (z8 && selectableItem.hasEdited()) {
                i9 = 2;
            } else {
                i9 = 0;
            }
            itemDetail.setTypeface(r13, i9);
            if (selectableItem.isExtendedHtml()) {
                itemDetail.setText(MDTextUtils.fromHtml(extendedDetail));
            } else {
                itemDetail.setText(extendedDetail);
            }
            if ((selectableItem instanceof ForceMacroRunAction) || (selectableItem instanceof ActionBlockAction)) {
                itemDetail.setMovementMethod(LinkMovementMethod.getInstance());
                ViewExtensionsKt.onClick$default(itemDetail, r13, new e(selectableItem, r13), 1, r13);
                ViewExtensionsKt.onLongClick$default(itemDetail, null, false, new f(selectableItem, r13), 3, null);
            }
            i6 = 8;
        } else {
            itemDetail = textView3;
            Intrinsics.checkNotNullExpressionValue(itemDetail, "itemDetail");
            i6 = 8;
            itemDetail.setVisibility(8);
        }
        if (z11) {
            ParentAction parentAction2 = (ParentAction) selectableItem;
            if (parentAction2.getChildrenCollapsed()) {
                itemDetail.setVisibility(i6);
                LinearLayout collapsedParentIcons = linearLayout;
                Intrinsics.checkNotNullExpressionValue(collapsedParentIcons, "collapsedParentIcons");
                collapsedParentIcons.setVisibility(i5);
                List<Integer> childIcons = parentAction2.getChildIcons();
                collapsedParentIcons.removeAllViews();
                if (z6) {
                    i7 = f11847r;
                } else {
                    i7 = f11845p;
                }
                if (z6) {
                    i8 = f11848s;
                } else {
                    i8 = f11846q;
                }
                for (Integer i10 : childIcons) {
                    ImageView imageView2 = new ImageView(this.f11850b);
                    imageView2.setLayoutParams(new LinearLayoutCompat.LayoutParams(i7, i7));
                    Intrinsics.checkNotNullExpressionValue(i10, "i");
                    imageView2.setImageResource(i10.intValue());
                    ViewExtensionsKt.setMargins(imageView2, 0, 0, Integer.valueOf(f11849t), 0);
                    imageView2.setPadding(i8, i8, i8, i8);
                    imageView2.setBackgroundResource(R.drawable.roundrect_icon_background_action_dark);
                    collapsedParentIcons.addView(imageView2);
                }
                return;
            }
        }
        LinearLayout collapsedParentIcons2 = linearLayout;
        Intrinsics.checkNotNullExpressionValue(collapsedParentIcons2, "collapsedParentIcons");
        collapsedParentIcons2.setVisibility(i6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(SelectableItem item, SelectableItemsViewHolder this$0, View view) {
        Intrinsics.checkNotNullParameter(item, "$item");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        item.setActivity(this$0.f11850b);
        item.handleWarningClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean m(Ref.LongRef lastClick, SelectableItemsViewHolder this$0, SelectableItem item, View view) {
        Function1<SelectableItem, Unit> function1;
        Intrinsics.checkNotNullParameter(lastClick, "$lastClick");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        if (System.currentTimeMillis() - lastClick.element > 750 && (function1 = this$0.f11853e) != null) {
            function1.invoke(item);
            return true;
        }
        return true;
    }

    private final void n(View view) {
        TextView textView = (TextView) view.findViewById(R.id.macro_edit_entry_detail);
        if (textView != null) {
            textView.setMaxLines(1);
        }
    }

    private final int o(boolean z3) {
        if (z3) {
            return this.f11860l;
        }
        return this.f11861m;
    }

    private final int p(boolean z3) {
        if (z3) {
            return R.layout.include_macro_item_small;
        }
        return R.layout.include_macro_item;
    }

    private final void q(SelectableItem selectableItem, View view, boolean z3, int i4, boolean z4, boolean z5, boolean z6, boolean z7) {
        int i5;
        boolean z8;
        int i6;
        boolean z9;
        int i7 = i4;
        ViewGroup topLevelExtrasContainer = (ViewGroup) view.findViewById(R.id.topLevelExtrasContainer);
        ViewGroup extrasContainer = (ViewGroup) view.findViewById(R.id.constraintContainer);
        View constraintLinkUnderAction = view.findViewById(R.id.constraintLinkUnderAction);
        View link = view.findViewById(R.id.macro_edit_entry_extras_joiner);
        ViewGroup.LayoutParams layoutParams = constraintLinkUnderAction.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        layoutParams2.setMarginStart(layoutParams2.getMarginStart() + i7);
        constraintLinkUnderAction.setLayoutParams(layoutParams2);
        Intrinsics.checkNotNullExpressionValue(constraintLinkUnderAction, "constraintLinkUnderAction");
        boolean z10 = false;
        constraintLinkUnderAction.setVisibility(0);
        Intrinsics.checkNotNullExpressionValue(link, "link");
        if (z4) {
            i5 = 0;
        } else {
            i5 = 8;
        }
        link.setVisibility(i5);
        extrasContainer.removeAllViews();
        int i8 = 0;
        for (SelectableItem childConstraint : selectableItem.getConstraints()) {
            int i9 = i8 + 1;
            View constraintView = LayoutInflater.from(this.f11850b).inflate(p(z5), extrasContainer, z10);
            TextView textView = (TextView) constraintView.findViewById(R.id.macro_edit_entry_detail);
            ViewGroup.LayoutParams layoutParams3 = constraintView.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) layoutParams3;
            layoutParams4.setMarginStart(i7);
            constraintView.setLayoutParams(layoutParams4);
            Intrinsics.checkNotNullExpressionValue(constraintView, "constraintView");
            Intrinsics.checkNotNullExpressionValue(childConstraint, "childConstraint");
            if (i9 == selectableItem.getConstraints().size()) {
                z8 = true;
            } else {
                z8 = false;
            }
            j(constraintView, childConstraint, z8, false, z3, z5, false, this.f11855g, z6, z7);
            extrasContainer.addView(constraintView);
            textView.setMaxLines(1);
            if (childConstraint.getConstraints() != null && childConstraint.getConstraints().size() > 0) {
                int o4 = o(z5);
                i6 = i9;
                if (i6 < selectableItem.getConstraints().size()) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                q(childConstraint, constraintView, z3, o4, z9, z5, z6, z7);
            } else {
                i6 = i9;
            }
            i7 = i4;
            i8 = i6;
            z10 = false;
        }
        Intrinsics.checkNotNullExpressionValue(topLevelExtrasContainer, "topLevelExtrasContainer");
        topLevelExtrasContainer.setVisibility(0);
        Intrinsics.checkNotNullExpressionValue(extrasContainer, "extrasContainer");
        extrasContainer.setVisibility(0);
    }

    private final void r(View view, boolean z3) {
        int i4;
        if (z3) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        view.setVisibility(i4);
    }

    public final void bind(@NotNull SelectableItem item, @NotNull List<? extends SelectableItem> items, int i4, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11) {
        boolean z12;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        boolean z13;
        boolean z14;
        int i10;
        int i11;
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        ViewGroup topLevelContainer$app_standardRelease = getTopLevelContainer$app_standardRelease();
        boolean z15 = false;
        if (z10 && (item instanceof Action) && ((Action) item).isCollapsed()) {
            z12 = false;
        } else {
            z12 = true;
        }
        if (z12) {
            i5 = 0;
        } else {
            i5 = 8;
        }
        topLevelContainer$app_standardRelease.setVisibility(i5);
        if (z10 && (item instanceof Action) && ((Action) item).isCollapsed()) {
            getTopLevelContainer$app_standardRelease().setLayoutParams(new RecyclerView.LayoutParams(0, 0));
        } else {
            getTopLevelContainer$app_standardRelease().getLayoutParams().width = -1;
            getTopLevelContainer$app_standardRelease().getLayoutParams().height = -2;
        }
        getCollapseExpandButton$app_standardRelease().setVisibility(8);
        if (item instanceof Action) {
            if (i4 >= 0) {
                int i12 = 0;
                i10 = 0;
                while (true) {
                    try {
                        Action action = (Action) items.get(i12);
                        if ((action instanceof ParentAction) && action.isEnabled() && i12 != i4) {
                            i10++;
                        } else if (action instanceof EndParentAction) {
                            int startParentIndex = MacroListUtils.getStartParentIndex(items, i12);
                            if (startParentIndex >= 0) {
                                if (((Action) items.get(startParentIndex)).isEnabled()) {
                                    i10--;
                                }
                            } else {
                                SystemLog.logError("Invalid start index for End action");
                                FirebaseCrashlytics.getInstance().recordException(new Exception("Invalid start index for End action: startIndex = " + startParentIndex));
                            }
                        }
                    } catch (IndexOutOfBoundsException unused) {
                    }
                    if ((item instanceof ParentAction) && z10) {
                        getCollapseExpandButton$app_standardRelease().setVisibility(0);
                        ImageView collapseExpandButton$app_standardRelease = getCollapseExpandButton$app_standardRelease();
                        if (((ParentAction) item).getChildrenCollapsed()) {
                            i11 = R.drawable.ic_arrow_down;
                        } else {
                            i11 = R.drawable.material_ic_keyboard_arrow_up_24px_svg;
                        }
                        collapseExpandButton$app_standardRelease.setImageResource(i11);
                        ViewExtensionsKt.onClick$default(getCollapseExpandButton$app_standardRelease(), null, new a(item, null), 1, null);
                    }
                    if (i12 == i4) {
                        break;
                    }
                    i12++;
                }
            } else {
                i10 = 0;
            }
            if (item instanceof ElseParentAction) {
                int startIfIndex = MacroListUtils.getStartIfIndex(items, i4);
                if (startIfIndex >= 0) {
                    if (((Action) items.get(startIfIndex)).isEnabled()) {
                        i10--;
                    }
                } else {
                    SystemLog.logError("Invalid start index for Else action");
                    FirebaseCrashlytics.getInstance().recordException(new Exception("Invalid start index for Else action"));
                }
            }
            ViewGroup topLevelContainer$app_standardRelease2 = getTopLevelContainer$app_standardRelease();
            int i13 = this.f11862n;
            topLevelContainer$app_standardRelease2.setPadding((i10 * this.f11857i) + i13, 0, i13, 0);
        } else {
            ViewGroup topLevelContainer$app_standardRelease3 = getTopLevelContainer$app_standardRelease();
            int i14 = this.f11862n;
            topLevelContainer$app_standardRelease3.setPadding(i14, 0, i14, 0);
        }
        j(getTopLevelContainer$app_standardRelease(), item, false, z4, true, z3, true, this.f11855g, z5, z6);
        if (!(item instanceof ConditionAction) && item.getConstraints() != null && item.getConstraints().size() > 0) {
            getConstraintLinkUnderAction$app_standardRelease().setVisibility(0);
            getConstraintContainer$app_standardRelease().removeAllViews();
            int i15 = 0;
            for (Constraint constraint : item.getConstraints()) {
                int i16 = i15 + 1;
                View constraintView = LayoutInflater.from(this.f11850b).inflate(p(z3), getConstraintContainer$app_standardRelease(), z15);
                Intrinsics.checkNotNullExpressionValue(constraintView, "constraintView");
                n(constraintView);
                Intrinsics.checkNotNullExpressionValue(constraint, "constraint");
                if (i16 == item.getConstraints().size()) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                boolean z16 = item instanceof Constraint;
                j(constraintView, constraint, z13, false, z16, z3, false, this.f11855g, z5, z6);
                getConstraintContainer$app_standardRelease().addView(constraintView);
                if (constraint.getConstraints() != null && constraint.getConstraints().size() > 0) {
                    int o4 = o(z3);
                    if (i16 < item.getConstraints().size()) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    q(constraint, constraintView, z16, o4, z14, z3, z5, z6);
                }
                i15 = i16;
                z15 = false;
            }
            getTopLevelExtrasContainer$app_standardRelease().setVisibility(0);
        } else {
            getTopLevelExtrasContainer$app_standardRelease().setVisibility(8);
            getConstraintLinkUnderAction$app_standardRelease().setVisibility(8);
        }
        r(getDragHandle$app_standardRelease(), z4);
        if (z11) {
            if (z7 && z8) {
                ViewGroup topLevelContainer$app_standardRelease4 = getTopLevelContainer$app_standardRelease();
                if (z9) {
                    i9 = R.drawable.action_highlight_top_bottom_error;
                } else {
                    i9 = R.drawable.action_highlight_top_bottom;
                }
                topLevelContainer$app_standardRelease4.setBackgroundResource(i9);
            } else if (z7) {
                ViewGroup topLevelContainer$app_standardRelease5 = getTopLevelContainer$app_standardRelease();
                if (z9) {
                    i8 = R.drawable.action_highlight_top_error;
                } else {
                    i8 = R.drawable.action_highlight_top;
                }
                topLevelContainer$app_standardRelease5.setBackgroundResource(i8);
            } else if (z8) {
                ViewGroup topLevelContainer$app_standardRelease6 = getTopLevelContainer$app_standardRelease();
                if (z9) {
                    i7 = R.drawable.action_highlight_bottom_error;
                } else {
                    i7 = R.drawable.action_highlight_bottom;
                }
                topLevelContainer$app_standardRelease6.setBackgroundResource(i7);
            } else if (z6) {
                ViewGroup topLevelContainer$app_standardRelease7 = getTopLevelContainer$app_standardRelease();
                if (z9) {
                    i6 = R.drawable.action_highlight_error;
                } else {
                    i6 = R.drawable.action_highlight;
                }
                topLevelContainer$app_standardRelease7.setBackgroundResource(i6);
            } else {
                getTopLevelContainer$app_standardRelease().setBackgroundResource(0);
            }
        }
    }

    @NotNull
    public final ImageView getCollapseExpandButton$app_standardRelease() {
        ImageView imageView = this.collapseExpandButton;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("collapseExpandButton");
        return null;
    }

    @NotNull
    public final ViewGroup getConstraintContainer$app_standardRelease() {
        ViewGroup viewGroup = this.constraintContainer;
        if (viewGroup != null) {
            return viewGroup;
        }
        Intrinsics.throwUninitializedPropertyAccessException("constraintContainer");
        return null;
    }

    @NotNull
    public final View getConstraintLinkUnderAction$app_standardRelease() {
        View view = this.constraintLinkUnderAction;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("constraintLinkUnderAction");
        return null;
    }

    @NotNull
    public final View getDragHandle$app_standardRelease() {
        View view = this.dragHandle;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("dragHandle");
        return null;
    }

    @NotNull
    public final ViewGroup getTopLevelContainer$app_standardRelease() {
        ViewGroup viewGroup = this.topLevelContainer;
        if (viewGroup != null) {
            return viewGroup;
        }
        Intrinsics.throwUninitializedPropertyAccessException("topLevelContainer");
        return null;
    }

    @NotNull
    public final ViewGroup getTopLevelExtrasContainer$app_standardRelease() {
        ViewGroup viewGroup = this.topLevelExtrasContainer;
        if (viewGroup != null) {
            return viewGroup;
        }
        Intrinsics.throwUninitializedPropertyAccessException("topLevelExtrasContainer");
        return null;
    }

    public final void setCollapseExpandButton$app_standardRelease(@NotNull ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.collapseExpandButton = imageView;
    }

    public final void setConstraintContainer$app_standardRelease(@NotNull ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "<set-?>");
        this.constraintContainer = viewGroup;
    }

    public final void setConstraintLinkUnderAction$app_standardRelease(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.constraintLinkUnderAction = view;
    }

    public final void setDragHandle$app_standardRelease(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.dragHandle = view;
    }

    public final void setTopLevelContainer$app_standardRelease(@NotNull ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "<set-?>");
        this.topLevelContainer = viewGroup;
    }

    public final void setTopLevelExtrasContainer$app_standardRelease(@NotNull ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "<set-?>");
        this.topLevelExtrasContainer = viewGroup;
    }
}
