package com.arlosoft.macrodroid.editscreen;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
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
import com.google.android.material.card.MaterialCardView;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.h6ah4i.android.widget.advrecyclerview.utils.AbstractDraggableItemViewHolder;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
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

/* compiled from: AllSelectableItemsViewHolder.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nAllSelectableItemsViewHolder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AllSelectableItemsViewHolder.kt\ncom/arlosoft/macrodroid/editscreen/AllSelectableItemsViewHolder\n+ 2 View.kt\nandroidx/core/view/ViewKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,668:1\n262#2,2:669\n260#2:671\n262#2,2:672\n262#2,2:696\n262#2,2:698\n262#2,2:700\n262#2,2:702\n262#2,2:704\n262#2,2:706\n262#2,2:708\n262#2,2:710\n262#2,2:712\n262#2,2:714\n262#2,2:716\n262#2,2:718\n262#2,2:720\n262#2,2:722\n262#2,2:724\n262#2,2:726\n262#2,2:728\n262#2,2:730\n262#2,2:732\n262#2,2:734\n262#2,2:736\n262#2,2:738\n262#2,2:740\n262#2,2:742\n262#2,2:744\n262#2,2:746\n262#2,2:748\n262#2,2:750\n262#2,2:752\n350#3,7:674\n378#3,7:681\n1549#3:688\n1620#3,3:689\n1549#3:692\n1620#3,3:693\n1#4:754\n*S KotlinDebug\n*F\n+ 1 AllSelectableItemsViewHolder.kt\ncom/arlosoft/macrodroid/editscreen/AllSelectableItemsViewHolder\n*L\n128#1:669,2\n130#1:671\n139#1:672,2\n171#1:696,2\n219#1:698,2\n254#1:700,2\n256#1:702,2\n257#1:704,2\n282#1:706,2\n312#1:708,2\n313#1:710,2\n316#1:712,2\n320#1:714,2\n341#1:716,2\n391#1:718,2\n396#1:720,2\n413#1:722,2\n417#1:724,2\n418#1:726,2\n435#1:728,2\n480#1:730,2\n487#1:732,2\n491#1:734,2\n493#1:736,2\n504#1:738,2\n541#1:740,2\n542#1:742,2\n582#1:744,2\n583#1:746,2\n629#1:748,2\n656#1:750,2\n658#1:752,2\n145#1:674,7\n146#1:681,7\n147#1:688\n147#1:689,3\n147#1:692\n147#1:693,3\n*E\n"})
/* loaded from: classes3.dex */
public final class AllSelectableItemsViewHolder extends AbstractDraggableItemViewHolder {
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final SelectableItemType f11718b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final Activity f11719c;
    @BindView(R.id.cardView)
    public MaterialCardView cardView;
    @BindView(R.id.collapse_expand_button)
    public ImageView collapseExpandButton;
    @BindView(R.id.constraintContainer)
    public ViewGroup constraintContainer;
    @BindView(R.id.constraintLinkUnderAction)
    public View constraintLinkUnderAction;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final Macro f11720d;
    @BindView(R.id.dragHandle)
    public View dragHandle;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private final Function1<SelectableItem, Unit> f11721e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private final Function1<SelectableItem, Unit> f11722f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private final Function1<SelectableItem, Unit> f11723g;
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    private final Observable<Boolean> f11724h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private final Function1<SelectableItem, Unit> f11725i;

    /* renamed from: j  reason: collision with root package name */
    private final int f11726j;

    /* renamed from: k  reason: collision with root package name */
    private final int f11727k;

    /* renamed from: l  reason: collision with root package name */
    private final int f11728l;

    /* renamed from: m  reason: collision with root package name */
    private final int f11729m;
    @Nullable

    /* renamed from: n  reason: collision with root package name */
    private Boolean f11730n;
    @BindView(R.id.topLevelContainer)
    public ViewGroup topLevelContainer;
    @BindView(R.id.topLevelExtrasContainer)
    public ViewGroup topLevelExtrasContainer;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* renamed from: o  reason: collision with root package name */
    private static final int f11713o = IntExtensionsKt.getPx(32);

    /* renamed from: p  reason: collision with root package name */
    private static final int f11714p = IntExtensionsKt.getPx(6);

    /* renamed from: q  reason: collision with root package name */
    private static final int f11715q = IntExtensionsKt.getPx(26);

    /* renamed from: r  reason: collision with root package name */
    private static final int f11716r = IntExtensionsKt.getPx(5);

    /* renamed from: s  reason: collision with root package name */
    private static final int f11717s = IntExtensionsKt.getPx(4);

    /* compiled from: AllSelectableItemsViewHolder.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AllSelectableItemsViewHolder.kt */
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
                Function1 function1 = AllSelectableItemsViewHolder.this.f11723g;
                if (function1 != null) {
                    function1.invoke(this.$item);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AllSelectableItemsViewHolder.kt */
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
            Function1 function1 = AllSelectableItemsViewHolder.this.f11725i;
            if (function1 != null) {
                function1.invoke(this.$item);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AllSelectableItemsViewHolder.kt */
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
            AllSelectableItemsViewHolder.this.f11730n = bool;
            AllSelectableItemsViewHolder allSelectableItemsViewHolder = AllSelectableItemsViewHolder.this;
            Boolean bool2 = allSelectableItemsViewHolder.f11730n;
            Intrinsics.checkNotNull(bool2);
            boolean booleanValue = bool2.booleanValue();
            SelectableItem selectableItem = this.$item;
            TextView warningText = this.$warningText;
            Intrinsics.checkNotNullExpressionValue(warningText, "warningText");
            ImageView warningIcon = this.$warningIcon;
            Intrinsics.checkNotNullExpressionValue(warningIcon, "warningIcon");
            ViewGroup container = this.$container;
            Intrinsics.checkNotNullExpressionValue(container, "container");
            allSelectableItemsViewHolder.h(booleanValue, selectableItem, warningText, warningIcon, container);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AllSelectableItemsViewHolder.kt */
    @SourceDebugExtension({"SMAP\nAllSelectableItemsViewHolder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AllSelectableItemsViewHolder.kt\ncom/arlosoft/macrodroid/editscreen/AllSelectableItemsViewHolder$displayItem$3\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,668:1\n1#2:669\n*E\n"})
    /* loaded from: classes3.dex */
    public static final class d extends Lambda implements Function0<Unit> {
        final /* synthetic */ SelectableItem $item;
        final /* synthetic */ Ref.LongRef $lastClick;
        final /* synthetic */ AllSelectableItemsViewHolder this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(Ref.LongRef longRef, AllSelectableItemsViewHolder allSelectableItemsViewHolder, SelectableItem selectableItem) {
            super(0);
            this.$lastClick = longRef;
            this.this$0 = allSelectableItemsViewHolder;
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
            Function1 function1 = this.this$0.f11721e;
            if (function1 != null) {
                function1.invoke(this.$item);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AllSelectableItemsViewHolder.kt */
    @SourceDebugExtension({"SMAP\nAllSelectableItemsViewHolder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AllSelectableItemsViewHolder.kt\ncom/arlosoft/macrodroid/editscreen/AllSelectableItemsViewHolder$displayItem$5\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,668:1\n1#2:669\n*E\n"})
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
                Function1 unused = AllSelectableItemsViewHolder.this.f11721e;
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AllSelectableItemsViewHolder.kt */
    @SourceDebugExtension({"SMAP\nAllSelectableItemsViewHolder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AllSelectableItemsViewHolder.kt\ncom/arlosoft/macrodroid/editscreen/AllSelectableItemsViewHolder$displayItem$6\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,668:1\n1#2:669\n*E\n"})
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
                Function1 unused = AllSelectableItemsViewHolder.this.f11722f;
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AllSelectableItemsViewHolder(@NotNull SelectableItemType type, @NotNull Activity context, @NotNull Macro macro, @NotNull View itemView, @Nullable Function1<? super SelectableItem, Unit> function1, @Nullable Function1<? super SelectableItem, Unit> function12, @Nullable Function1<? super SelectableItem, Unit> function13, @NotNull Observable<Boolean> isRootedSubject, @Nullable Function1<? super SelectableItem, Unit> function14) {
        super(itemView);
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(macro, "macro");
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(isRootedSubject, "isRootedSubject");
        this.f11718b = type;
        this.f11719c = context;
        this.f11720d = macro;
        this.f11721e = function1;
        this.f11722f = function12;
        this.f11723g = function13;
        this.f11724h = isRootedSubject;
        this.f11725i = function14;
        this.f11726j = context.getResources().getDimensionPixelSize(R.dimen.action_child_indent);
        this.f11727k = context.getResources().getDimensionPixelSize(R.dimen.constraint_level_offset_small);
        this.f11728l = context.getResources().getDimensionPixelSize(R.dimen.constraint_level_offset);
        this.f11729m = context.getResources().getDimensionPixelSize(R.dimen.edit_entry_horizontal_padding);
        ButterKnife.bind(this, itemView);
    }

    public static /* synthetic */ void bind$default(AllSelectableItemsViewHolder allSelectableItemsViewHolder, ItemType itemType, List list, int i4, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, int i5, Object obj) {
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        if ((i5 & 128) != 0) {
            z13 = false;
        } else {
            z13 = z7;
        }
        if ((i5 & 256) != 0) {
            z14 = false;
        } else {
            z14 = z8;
        }
        if ((i5 & 512) != 0) {
            z15 = false;
        } else {
            z15 = z9;
        }
        if ((i5 & 4096) != 0) {
            z16 = false;
        } else {
            z16 = z12;
        }
        allSelectableItemsViewHolder.bind(itemType, list, i4, z3, z4, z5, z6, z13, z14, z15, z10, z11, z16);
    }

    private final void e(Action action, ImageView imageView, ViewGroup viewGroup, ImageView imageView2, boolean z3, boolean z4, View view) {
        int i4;
        boolean z5 = action instanceof EndLoopAction;
        if (z5) {
            ArrayList<Action> actions = this.f11720d.getActions();
            int startLoopIndex = MacroListUtils.getStartLoopIndex(this.f11720d.getActions(), this.f11720d.getActions().indexOf(action));
            if (startLoopIndex >= 0 && !actions.get(startLoopIndex).isEnabled()) {
                viewGroup.setAlpha(0.5f);
            }
        }
        boolean z6 = action instanceof EndIfAction;
        if (z6 || (action instanceof ElseParentAction)) {
            ArrayList<Action> actions2 = this.f11720d.getActions();
            int startIfIndex = MacroListUtils.getStartIfIndex(this.f11720d.getActions(), this.f11720d.getActions().indexOf(action));
            if (startIfIndex >= 0 && !actions2.get(startIfIndex).isEnabled()) {
                viewGroup.setAlpha(0.5f);
            }
        }
        if (!(action instanceof IfConditionAction) && !(action instanceof LoopAction) && !z6 && !z5 && !(action instanceof ElseParentAction)) {
            imageView.setBackgroundResource(R.drawable.circular_icon_background_action_dark);
        } else {
            imageView.setBackgroundResource(R.drawable.circular_icon_background_condition);
        }
        getCardView$app_standardRelease().setCardBackgroundColor(ContextCompat.getColor(this.f11719c, R.color.actions_primary));
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
            getCardView$app_standardRelease().setCardBackgroundColor(ContextCompat.getColor(this.f11719c, R.color.constraints_primary));
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
                    Activity activity = this.f11719c;
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
                    String str = this.f11719c.getString(R.string.rooted_or_adb_hack_required) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + sb2;
                    SpannableString spannableString = new SpannableString(str);
                    UnderlineSpan underlineSpan = new UnderlineSpan();
                    indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, sb2, 0, false, 6, (Object) null);
                    spannableString.setSpan(underlineSpan, indexOf$default, str.length(), 0);
                    textView.setText(spannableString);
                    textView.setVisibility(0);
                    textView.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.editscreen.e
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            AllSelectableItemsViewHolder.i(AllSelectableItemsViewHolder.this, selectableItem, view);
                        }
                    });
                    viewGroup.setBackgroundResource(R.drawable.item_error_border);
                    imageView.setVisibility(0);
                    return;
                }
                return;
            }
            textView.setText(this.f11719c.getString(R.string.rooted_device_required));
            textView.setVisibility(0);
            viewGroup.setBackgroundResource(R.drawable.item_error_border);
            imageView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(AllSelectableItemsViewHolder this$0, SelectableItem item, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        AdbHelperUtil.showAdbHackDetails(this$0.f11719c, item.getAdbHackPermissionRequired(), new b(item));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v3, types: [android.graphics.Typeface, kotlin.coroutines.Continuation, java.lang.Object, kotlin.coroutines.CoroutineContext] */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r2v18, types: [android.view.View] */
    @SuppressLint({"CheckResult"})
    private final void j(View view, final SelectableItem selectableItem, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, Observable<Boolean> observable, boolean z8) {
        MaterialCardView materialCardView;
        String str;
        TextView textView;
        ImageView imageView;
        View view2;
        LinearLayout linearLayout;
        boolean z9;
        int i4;
        float f4;
        boolean z10;
        ViewGroup viewGroup;
        ?? r13;
        int i5;
        boolean z11;
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
        MaterialCardView materialCardView2 = (MaterialCardView) view.findViewById(R.id.cardView);
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
            warningText.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.editscreen.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    AllSelectableItemsViewHolder.k(SelectableItem.this, this, view3);
                }
            });
            materialCardView = materialCardView2;
            str = "container";
            textView = textView4;
            imageView = warningIcon;
            view2 = findViewById;
            linearLayout = linearLayout2;
            z9 = true;
        } else {
            if (selectableItem.isRootOnly()) {
                Boolean bool = this.f11730n;
                if (bool != null) {
                    Intrinsics.checkNotNull(bool);
                    boolean booleanValue = bool.booleanValue();
                    Intrinsics.checkNotNullExpressionValue(container, "container");
                    materialCardView = materialCardView2;
                    str = "container";
                    linearLayout = linearLayout2;
                    textView = textView4;
                    imageView = warningIcon;
                    h(booleanValue, selectableItem, warningText, warningIcon, container);
                    view2 = findViewById;
                } else {
                    materialCardView = materialCardView2;
                    str = "container";
                    textView = textView4;
                    imageView = warningIcon;
                    linearLayout = linearLayout2;
                    Observable<Boolean> observeOn = observable.take(1L).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
                    view2 = findViewById;
                    final c cVar = new c(selectableItem, warningText, imageView, container);
                    observeOn.subscribe(new Consumer() { // from class: com.arlosoft.macrodroid.editscreen.g
                        @Override // io.reactivex.functions.Consumer
                        public final void accept(Object obj) {
                            AllSelectableItemsViewHolder.l(Function1.this, obj);
                        }
                    });
                }
            } else {
                materialCardView = materialCardView2;
                str = "container";
                textView = textView4;
                imageView = warningIcon;
                view2 = findViewById;
                linearLayout = linearLayout2;
            }
            z9 = false;
        }
        icon.setImageDrawable(ContextCompat.getDrawable(this.f11719c, selectableItem.getIcon()));
        Intrinsics.checkNotNullExpressionValue(icon, "icon");
        icon.setVisibility(0);
        boolean z12 = selectableItem instanceof ParentAction;
        if (z12) {
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
        container.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.arlosoft.macrodroid.editscreen.h
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view3) {
                boolean m4;
                m4 = AllSelectableItemsViewHolder.m(Ref.LongRef.this, this, selectableItem, view3);
                return m4;
            }
        });
        if (selectableItem instanceof Action) {
            Intrinsics.checkNotNullExpressionValue(grabHandle, "grabHandle");
            Intrinsics.checkNotNullExpressionValue(spacing, "spacing");
            r13 = 0;
            z10 = z12;
            viewGroup = container;
            e((Action) selectableItem, icon, container, grabHandle, z4, z3, spacing);
        } else {
            z10 = z12;
            viewGroup = container;
            if (!(selectableItem instanceof Constraint)) {
                r13 = null;
                if (selectableItem instanceof Trigger) {
                    icon.setBackgroundResource(R.drawable.circular_icon_background_trigger_dark);
                    materialCardView.setCardBackgroundColor(ContextCompat.getColor(this.f11719c, R.color.trigger_primary));
                    r13 = null;
                }
            } else {
                Intrinsics.checkNotNullExpressionValue(spacing, "spacing");
                g((Constraint) selectableItem, icon, z5, z6, z3, spacing, z7);
                r13 = null;
            }
        }
        if (selectableItem.isValid() && !z9) {
            i5 = 0;
        } else {
            viewGroup.setBackgroundResource(R.drawable.item_error_border);
            i5 = 0;
            imageView.setVisibility(0);
        }
        String extendedDetail = selectableItem.getExtendedDetail();
        if (extendedDetail != null && extendedDetail.length() != 0) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (!z11) {
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
        if (z10) {
            ParentAction parentAction2 = (ParentAction) selectableItem;
            if (parentAction2.getChildrenCollapsed()) {
                itemDetail.setVisibility(i6);
                LinearLayout collapsedParentIcons = linearLayout;
                Intrinsics.checkNotNullExpressionValue(collapsedParentIcons, "collapsedParentIcons");
                collapsedParentIcons.setVisibility(i5);
                List<Integer> childIcons = parentAction2.getChildIcons();
                collapsedParentIcons.removeAllViews();
                if (z6) {
                    i7 = f11715q;
                } else {
                    i7 = f11713o;
                }
                if (z6) {
                    i8 = f11716r;
                } else {
                    i8 = f11714p;
                }
                for (Integer i10 : childIcons) {
                    ImageView imageView2 = new ImageView(this.f11719c);
                    imageView2.setLayoutParams(new LinearLayoutCompat.LayoutParams(i7, i7));
                    Intrinsics.checkNotNullExpressionValue(i10, "i");
                    imageView2.setImageResource(i10.intValue());
                    ViewExtensionsKt.setMargins(imageView2, 0, 0, Integer.valueOf(f11717s), 0);
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
    public static final void k(SelectableItem item, AllSelectableItemsViewHolder this$0, View view) {
        Intrinsics.checkNotNullParameter(item, "$item");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        item.setActivity(this$0.f11719c);
        item.handleWarningClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean m(Ref.LongRef lastClick, AllSelectableItemsViewHolder this$0, SelectableItem item, View view) {
        Function1<SelectableItem, Unit> function1;
        Intrinsics.checkNotNullParameter(lastClick, "$lastClick");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        if (System.currentTimeMillis() - lastClick.element > 750 && (function1 = this$0.f11722f) != null) {
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
            return this.f11727k;
        }
        return this.f11728l;
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
        ViewGroup topLevelExtrasContainer = (ViewGroup) view.findViewById(R.id.topLevelExtrasContainer);
        ViewGroup extrasContainer = (ViewGroup) view.findViewById(R.id.constraintContainer);
        View constraintLinkUnderAction = view.findViewById(R.id.constraintLinkUnderAction);
        View link = view.findViewById(R.id.macro_edit_entry_extras_joiner);
        ViewGroup.LayoutParams layoutParams = constraintLinkUnderAction.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        layoutParams2.setMarginStart(layoutParams2.getMarginStart() + i4);
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
        int i7 = 0;
        for (SelectableItem childConstraint : selectableItem.getConstraints()) {
            int i8 = i7 + 1;
            View constraintView = LayoutInflater.from(this.f11719c).inflate(p(z5), extrasContainer, z10);
            TextView textView = (TextView) constraintView.findViewById(R.id.macro_edit_entry_detail);
            ViewGroup.LayoutParams layoutParams3 = constraintView.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) layoutParams3;
            layoutParams4.setMarginStart(i4);
            constraintView.setLayoutParams(layoutParams4);
            Intrinsics.checkNotNullExpressionValue(constraintView, "constraintView");
            Intrinsics.checkNotNullExpressionValue(childConstraint, "childConstraint");
            if (i8 == selectableItem.getConstraints().size()) {
                z8 = true;
            } else {
                z8 = false;
            }
            j(constraintView, childConstraint, z8, false, z3, z5, false, this.f11724h, z6);
            extrasContainer.addView(constraintView);
            textView.setMaxLines(1);
            if (childConstraint.getConstraints() != null && childConstraint.getConstraints().size() > 0) {
                int o4 = o(z5);
                i6 = i8;
                if (i6 < selectableItem.getConstraints().size()) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                q(childConstraint, constraintView, z3, o4, z9, z5, z6, z7);
            } else {
                i6 = i8;
            }
            i7 = i6;
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

    public final void bind(@NotNull ItemType itemType, @NotNull List<? extends ItemType> items, int i4, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12) {
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        int i5;
        boolean z13;
        Intrinsics.checkNotNullParameter(itemType, "itemType");
        Intrinsics.checkNotNullParameter(items, "items");
        SelectableItem selectableItem = ((HasSelectableItem) itemType).getSelectableItem();
        boolean z14 = false;
        getCardView$app_standardRelease().setVisibility(!z10 || !(selectableItem instanceof Action) || !((Action) selectableItem).isCollapsed() ? 0 : 8);
        if (getTopLevelContainer$app_standardRelease().getVisibility() == 0) {
            int i6 = -1;
            if (z10 && (selectableItem instanceof Action) && ((Action) selectableItem).isCollapsed()) {
                getTopLevelContainer$app_standardRelease().setLayoutParams(new FrameLayout.LayoutParams(0, 0));
            } else {
                getTopLevelContainer$app_standardRelease().getLayoutParams().width = -1;
                getTopLevelContainer$app_standardRelease().getLayoutParams().height = -2;
            }
            getCollapseExpandButton$app_standardRelease().setVisibility(8);
            if (selectableItem instanceof Action) {
                Iterator<? extends ItemType> it = items.iterator();
                int i7 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        i7 = -1;
                        break;
                    }
                    ItemType next = it.next();
                    if ((next instanceof HasSelectableItem) && (((HasSelectableItem) next).getSelectableItem() instanceof Action)) {
                        break;
                    }
                    i7++;
                }
                ListIterator<? extends ItemType> listIterator = items.listIterator(items.size());
                while (true) {
                    if (!listIterator.hasPrevious()) {
                        break;
                    }
                    ItemType previous = listIterator.previous();
                    if ((previous instanceof HasSelectableItem) && (((HasSelectableItem) previous).getSelectableItem() instanceof Action)) {
                        z13 = true;
                        continue;
                    } else {
                        z13 = false;
                        continue;
                    }
                    if (z13) {
                        i6 = listIterator.nextIndex();
                        break;
                    }
                }
                List<? extends ItemType> subList = items.subList(i7, i6 + 1);
                collectionSizeOrDefault = kotlin.collections.f.collectionSizeOrDefault(subList, 10);
                ArrayList<HasSelectableItem> arrayList = new ArrayList(collectionSizeOrDefault);
                for (ItemType itemType2 : subList) {
                    Intrinsics.checkNotNull(itemType2, "null cannot be cast to non-null type com.arlosoft.macrodroid.editscreen.HasSelectableItem");
                    arrayList.add((HasSelectableItem) itemType2);
                }
                collectionSizeOrDefault2 = kotlin.collections.f.collectionSizeOrDefault(arrayList, 10);
                ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
                for (HasSelectableItem hasSelectableItem : arrayList) {
                    SelectableItem selectableItem2 = hasSelectableItem.getSelectableItem();
                    Intrinsics.checkNotNull(selectableItem2, "null cannot be cast to non-null type com.arlosoft.macrodroid.action.Action");
                    arrayList2.add((Action) selectableItem2);
                }
                if (i7 <= i4) {
                    int i8 = i7;
                    i5 = 0;
                    while (true) {
                        try {
                            ItemType itemType3 = items.get(i8);
                            Intrinsics.checkNotNull(itemType3, "null cannot be cast to non-null type com.arlosoft.macrodroid.editscreen.HasSelectableItem");
                            SelectableItem selectableItem3 = ((HasSelectableItem) itemType3).getSelectableItem();
                            if ((selectableItem3 instanceof ParentAction) && !((ParentAction) selectableItem3).getChildrenCollapsed() && selectableItem3.isEnabled() && i8 != i4) {
                                i5++;
                            } else if (selectableItem3 instanceof EndParentAction) {
                                int startParentIndex = MacroListUtils.getStartParentIndex(arrayList2, i8 - i7);
                                if (startParentIndex >= 0) {
                                    if (((Action) arrayList2.get(startParentIndex)).isEnabled()) {
                                        i5--;
                                    }
                                } else {
                                    SystemLog.logError("Invalid start index for End action");
                                    FirebaseCrashlytics.getInstance().recordException(new Exception("Invalid start index for End action: startIndex = " + startParentIndex));
                                }
                            }
                        } catch (IndexOutOfBoundsException unused) {
                        }
                        if ((selectableItem instanceof ParentAction) && z10) {
                            getCollapseExpandButton$app_standardRelease().setVisibility(0);
                            getCollapseExpandButton$app_standardRelease().setImageResource(((ParentAction) selectableItem).getChildrenCollapsed() ? R.drawable.ic_arrow_down : R.drawable.material_ic_keyboard_arrow_up_24px_svg);
                            ViewExtensionsKt.onClick$default(getCollapseExpandButton$app_standardRelease(), null, new a(selectableItem, null), 1, null);
                        }
                        if (i8 == i4) {
                            break;
                        }
                        i8++;
                    }
                } else {
                    i5 = 0;
                }
                if (selectableItem instanceof ElseParentAction) {
                    int startIfIndex = MacroListUtils.getStartIfIndex(arrayList2, i4 - i7);
                    if (startIfIndex >= 0) {
                        if (((Action) arrayList2.get(startIfIndex)).isEnabled()) {
                            i5--;
                        }
                    } else {
                        SystemLog.logError("Invalid start index for Else action");
                        FirebaseCrashlytics.getInstance().recordException(new Exception("Invalid start index for Else action"));
                    }
                }
                ViewGroup topLevelContainer$app_standardRelease = getTopLevelContainer$app_standardRelease();
                int i9 = this.f11729m;
                topLevelContainer$app_standardRelease.setPadding((i5 * this.f11726j) + i9, 0, i9, 0);
            } else {
                ViewGroup topLevelContainer$app_standardRelease2 = getTopLevelContainer$app_standardRelease();
                int i10 = this.f11729m;
                topLevelContainer$app_standardRelease2.setPadding(i10, 0, i10, 0);
            }
            j(getCardView$app_standardRelease(), selectableItem, false, z4, true, z3, true, this.f11724h, z5);
            if (!(selectableItem instanceof ConditionAction) && selectableItem.getConstraints() != null && selectableItem.getConstraints().size() > 0) {
                getConstraintLinkUnderAction$app_standardRelease().setVisibility(0);
                getConstraintContainer$app_standardRelease().removeAllViews();
                Iterator<Constraint> it2 = selectableItem.getConstraints().iterator();
                int i11 = 0;
                while (it2.hasNext()) {
                    Constraint constraint = it2.next();
                    int i12 = i11 + 1;
                    View constraintView = LayoutInflater.from(this.f11719c).inflate(p(z3), getConstraintContainer$app_standardRelease(), z14);
                    Intrinsics.checkNotNullExpressionValue(constraintView, "constraintView");
                    n(constraintView);
                    Intrinsics.checkNotNullExpressionValue(constraint, "constraint");
                    boolean z15 = selectableItem instanceof Constraint;
                    Iterator<Constraint> it3 = it2;
                    j(constraintView, constraint, i12 == selectableItem.getConstraints().size(), false, z15, z3, false, this.f11724h, z5);
                    getConstraintContainer$app_standardRelease().addView(constraintView);
                    if (constraint.getConstraints() != null && constraint.getConstraints().size() > 0) {
                        q(constraint, constraintView, z15, o(z3), i12 < selectableItem.getConstraints().size(), z3, z5, z6);
                    }
                    i11 = i12;
                    z14 = false;
                    it2 = it3;
                }
                getTopLevelExtrasContainer$app_standardRelease().setVisibility(0);
            } else {
                getTopLevelExtrasContainer$app_standardRelease().setVisibility(8);
                getConstraintLinkUnderAction$app_standardRelease().setVisibility(8);
            }
            r(getDragHandle(), z4);
            if (z12) {
                getTopLevelContainer$app_standardRelease().setBackgroundResource(R.drawable.search_match_highlight);
            }
            if (z11) {
                if (z7 && z8) {
                    getTopLevelContainer$app_standardRelease().setBackgroundResource(z9 ? R.drawable.action_highlight_top_bottom_error : R.drawable.action_highlight_top_bottom);
                } else if (z7) {
                    getTopLevelContainer$app_standardRelease().setBackgroundResource(z9 ? R.drawable.action_highlight_top_error : R.drawable.action_highlight_top);
                } else if (z8) {
                    getTopLevelContainer$app_standardRelease().setBackgroundResource(z9 ? R.drawable.action_highlight_bottom_error : R.drawable.action_highlight_bottom);
                } else if (z6) {
                    getTopLevelContainer$app_standardRelease().setBackgroundResource(z9 ? R.drawable.action_highlight_error : R.drawable.action_highlight);
                } else {
                    getTopLevelContainer$app_standardRelease().setBackgroundResource(0);
                }
            }
        }
    }

    @NotNull
    public final MaterialCardView getCardView$app_standardRelease() {
        MaterialCardView materialCardView = this.cardView;
        if (materialCardView != null) {
            return materialCardView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("cardView");
        return null;
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
    public final View getDragHandle() {
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

    @NotNull
    public final SelectableItemType getType() {
        return this.f11718b;
    }

    public final void setCardView$app_standardRelease(@NotNull MaterialCardView materialCardView) {
        Intrinsics.checkNotNullParameter(materialCardView, "<set-?>");
        this.cardView = materialCardView;
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

    public final void setDragHandle(@NotNull View view) {
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
