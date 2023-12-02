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

/* compiled from: EmptyItemsViewHolder.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nEmptyItemsViewHolder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EmptyItemsViewHolder.kt\ncom/arlosoft/macrodroid/editscreen/EmptyItemsViewHolder\n+ 2 View.kt\nandroidx/core/view/ViewKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,668:1\n262#2,2:669\n262#2,2:671\n262#2,2:695\n262#2,2:697\n262#2,2:699\n262#2,2:701\n262#2,2:703\n262#2,2:705\n262#2,2:707\n262#2,2:709\n262#2,2:711\n262#2,2:713\n262#2,2:715\n262#2,2:717\n262#2,2:719\n262#2,2:721\n262#2,2:723\n262#2,2:725\n262#2,2:727\n262#2,2:729\n262#2,2:731\n262#2,2:733\n262#2,2:735\n262#2,2:737\n262#2,2:739\n262#2,2:741\n262#2,2:743\n262#2,2:745\n262#2,2:747\n262#2,2:749\n262#2,2:751\n350#3,7:673\n378#3,7:680\n1549#3:687\n1620#3,3:688\n1549#3:691\n1620#3,3:692\n1#4:753\n*S KotlinDebug\n*F\n+ 1 EmptyItemsViewHolder.kt\ncom/arlosoft/macrodroid/editscreen/EmptyItemsViewHolder\n*L\n124#1:669,2\n132#1:671,2\n166#1:695,2\n220#1:697,2\n258#1:699,2\n260#1:701,2\n261#1:703,2\n282#1:705,2\n313#1:707,2\n314#1:709,2\n317#1:711,2\n321#1:713,2\n342#1:715,2\n392#1:717,2\n397#1:719,2\n414#1:721,2\n418#1:723,2\n419#1:725,2\n436#1:727,2\n481#1:729,2\n488#1:731,2\n492#1:733,2\n494#1:735,2\n505#1:737,2\n542#1:739,2\n543#1:741,2\n584#1:743,2\n585#1:745,2\n631#1:747,2\n656#1:749,2\n658#1:751,2\n139#1:673,7\n140#1:680,7\n141#1:687\n141#1:688,3\n141#1:691\n141#1:692,3\n*E\n"})
/* loaded from: classes3.dex */
public final class EmptyItemsViewHolder extends AbstractDraggableItemViewHolder {
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final Activity f11787b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final Macro f11788c;
    @BindView(R.id.cardView)
    public MaterialCardView cardView;
    @BindView(R.id.collapse_expand_button)
    public ImageView collapseExpandButton;
    @BindView(R.id.constraintContainer)
    public ViewGroup constraintContainer;
    @BindView(R.id.constraintLinkUnderAction)
    public View constraintLinkUnderAction;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private final Function1<SelectableItem, Unit> f11789d;
    @BindView(R.id.dragHandle)
    public View dragHandle;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private final Function1<SelectableItem, Unit> f11790e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private final Function1<SelectableItem, Unit> f11791f;
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private final Observable<Boolean> f11792g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private final Function1<SelectableItem, Unit> f11793h;

    /* renamed from: i  reason: collision with root package name */
    private final int f11794i;

    /* renamed from: j  reason: collision with root package name */
    private final int f11795j;

    /* renamed from: k  reason: collision with root package name */
    private final int f11796k;

    /* renamed from: l  reason: collision with root package name */
    private final int f11797l;

    /* renamed from: m  reason: collision with root package name */
    private final int f11798m;

    /* renamed from: n  reason: collision with root package name */
    private final int f11799n;
    @Nullable

    /* renamed from: o  reason: collision with root package name */
    private Boolean f11800o;
    @BindView(R.id.topLevelContainer)
    public ViewGroup topLevelContainer;
    @BindView(R.id.topLevelExtrasContainer)
    public ViewGroup topLevelExtrasContainer;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* renamed from: p  reason: collision with root package name */
    private static final int f11782p = IntExtensionsKt.getPx(32);

    /* renamed from: q  reason: collision with root package name */
    private static final int f11783q = IntExtensionsKt.getPx(6);

    /* renamed from: r  reason: collision with root package name */
    private static final int f11784r = IntExtensionsKt.getPx(26);

    /* renamed from: s  reason: collision with root package name */
    private static final int f11785s = IntExtensionsKt.getPx(5);

    /* renamed from: t  reason: collision with root package name */
    private static final int f11786t = IntExtensionsKt.getPx(4);

    /* compiled from: EmptyItemsViewHolder.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EmptyItemsViewHolder.kt */
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
                Function1 function1 = EmptyItemsViewHolder.this.f11791f;
                if (function1 != null) {
                    function1.invoke(this.$item);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EmptyItemsViewHolder.kt */
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
            Function1 function1 = EmptyItemsViewHolder.this.f11793h;
            if (function1 != null) {
                function1.invoke(this.$item);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EmptyItemsViewHolder.kt */
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
            EmptyItemsViewHolder.this.f11800o = bool;
            EmptyItemsViewHolder emptyItemsViewHolder = EmptyItemsViewHolder.this;
            Boolean bool2 = emptyItemsViewHolder.f11800o;
            Intrinsics.checkNotNull(bool2);
            boolean booleanValue = bool2.booleanValue();
            SelectableItem selectableItem = this.$item;
            TextView warningText = this.$warningText;
            Intrinsics.checkNotNullExpressionValue(warningText, "warningText");
            ImageView warningIcon = this.$warningIcon;
            Intrinsics.checkNotNullExpressionValue(warningIcon, "warningIcon");
            ViewGroup container = this.$container;
            Intrinsics.checkNotNullExpressionValue(container, "container");
            emptyItemsViewHolder.h(booleanValue, selectableItem, warningText, warningIcon, container);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EmptyItemsViewHolder.kt */
    @SourceDebugExtension({"SMAP\nEmptyItemsViewHolder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EmptyItemsViewHolder.kt\ncom/arlosoft/macrodroid/editscreen/EmptyItemsViewHolder$displayItem$3\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,668:1\n1#2:669\n*E\n"})
    /* loaded from: classes3.dex */
    public static final class d extends Lambda implements Function0<Unit> {
        final /* synthetic */ SelectableItem $item;
        final /* synthetic */ Ref.LongRef $lastClick;
        final /* synthetic */ EmptyItemsViewHolder this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(Ref.LongRef longRef, EmptyItemsViewHolder emptyItemsViewHolder, SelectableItem selectableItem) {
            super(0);
            this.$lastClick = longRef;
            this.this$0 = emptyItemsViewHolder;
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
            Function1 function1 = this.this$0.f11789d;
            if (function1 != null) {
                function1.invoke(this.$item);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EmptyItemsViewHolder.kt */
    @SourceDebugExtension({"SMAP\nEmptyItemsViewHolder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EmptyItemsViewHolder.kt\ncom/arlosoft/macrodroid/editscreen/EmptyItemsViewHolder$displayItem$5\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,668:1\n1#2:669\n*E\n"})
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
                Function1 unused = EmptyItemsViewHolder.this.f11789d;
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EmptyItemsViewHolder.kt */
    @SourceDebugExtension({"SMAP\nEmptyItemsViewHolder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EmptyItemsViewHolder.kt\ncom/arlosoft/macrodroid/editscreen/EmptyItemsViewHolder$displayItem$6\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,668:1\n1#2:669\n*E\n"})
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
                Function1 unused = EmptyItemsViewHolder.this.f11790e;
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public EmptyItemsViewHolder(@NotNull Activity context, @NotNull Macro macro, @NotNull View itemView, @Nullable Function1<? super SelectableItem, Unit> function1, @Nullable Function1<? super SelectableItem, Unit> function12, @Nullable Function1<? super SelectableItem, Unit> function13, @NotNull Observable<Boolean> isRootedSubject, @Nullable Function1<? super SelectableItem, Unit> function14) {
        super(itemView);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(macro, "macro");
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(isRootedSubject, "isRootedSubject");
        this.f11787b = context;
        this.f11788c = macro;
        this.f11789d = function1;
        this.f11790e = function12;
        this.f11791f = function13;
        this.f11792g = isRootedSubject;
        this.f11793h = function14;
        this.f11794i = context.getResources().getDimensionPixelSize(R.dimen.action_child_indent);
        this.f11795j = context.getResources().getDimensionPixelSize(R.dimen.logic_edit_entry_height);
        this.f11796k = context.getResources().getDimensionPixelSize(R.dimen.logic_edit_small_entry_height);
        this.f11797l = context.getResources().getDimensionPixelSize(R.dimen.constraint_level_offset);
        this.f11798m = context.getResources().getDimensionPixelSize(R.dimen.constraint_level_offset);
        this.f11799n = context.getResources().getDimensionPixelSize(R.dimen.edit_entry_horizontal_padding);
        ButterKnife.bind(this, itemView);
    }

    public static /* synthetic */ void bind$default(EmptyItemsViewHolder emptyItemsViewHolder, ItemType itemType, List list, int i4, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, int i5, Object obj) {
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
        emptyItemsViewHolder.bind(itemType, list, i4, z3, z4, z5, z6, z12, z13, z14, z10, z11);
    }

    private final void e(Action action, ImageView imageView, ViewGroup viewGroup, ImageView imageView2, boolean z3, boolean z4, View view) {
        int i4;
        boolean z5 = action instanceof EndLoopAction;
        if (z5) {
            ArrayList<Action> actions = this.f11788c.getActions();
            int startLoopIndex = MacroListUtils.getStartLoopIndex(this.f11788c.getActions(), this.f11788c.getActions().indexOf(action));
            if (startLoopIndex >= 0 && !actions.get(startLoopIndex).isEnabled()) {
                viewGroup.setAlpha(0.5f);
            }
        }
        boolean z6 = action instanceof EndIfAction;
        if (z6 || (action instanceof ElseParentAction)) {
            ArrayList<Action> actions2 = this.f11788c.getActions();
            int startIfIndex = MacroListUtils.getStartIfIndex(this.f11788c.getActions(), this.f11788c.getActions().indexOf(action));
            if (startIfIndex >= 0 && !actions2.get(startIfIndex).isEnabled()) {
                viewGroup.setAlpha(0.5f);
            }
        }
        if (!(action instanceof IfConditionAction) && !(action instanceof LoopAction) && !z6 && !z5 && !(action instanceof ElseParentAction)) {
            imageView.setBackgroundResource(R.drawable.circular_icon_background_action_dark);
        } else {
            imageView.setBackgroundResource(R.drawable.circular_icon_background_condition);
        }
        getCardView$app_standardRelease().setCardBackgroundColor(ContextCompat.getColor(this.f11787b, R.color.actions_primary));
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
        getCardView$app_standardRelease().setCardBackgroundColor(ContextCompat.getColor(this.f11787b, R.color.constraints_primary));
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
                    Activity activity = this.f11787b;
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
                    String str = this.f11787b.getString(R.string.rooted_or_adb_hack_required) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + sb2;
                    SpannableString spannableString = new SpannableString(str);
                    UnderlineSpan underlineSpan = new UnderlineSpan();
                    indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, sb2, 0, false, 6, (Object) null);
                    spannableString.setSpan(underlineSpan, indexOf$default, str.length(), 0);
                    textView.setText(spannableString);
                    textView.setVisibility(0);
                    textView.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.editscreen.r0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            EmptyItemsViewHolder.i(EmptyItemsViewHolder.this, selectableItem, view);
                        }
                    });
                    viewGroup.setBackgroundResource(R.drawable.item_error_border);
                    imageView.setVisibility(0);
                    return;
                }
                return;
            }
            textView.setText(this.f11787b.getString(R.string.rooted_device_required));
            textView.setVisibility(0);
            viewGroup.setBackgroundResource(R.drawable.item_error_border);
            imageView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(EmptyItemsViewHolder this$0, SelectableItem item, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        AdbHelperUtil.showAdbHackDetails(this$0.f11787b, item.getAdbHackPermissionRequired(), new b(item));
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
        MaterialCardView materialCardView;
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
            warningText.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.editscreen.s0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    EmptyItemsViewHolder.k(SelectableItem.this, this, view3);
                }
            });
            materialCardView = materialCardView2;
            linearLayout = linearLayout2;
            str = "container";
            textView = textView4;
            imageView = warningIcon;
            view2 = findViewById;
            z10 = true;
        } else {
            if (selectableItem.isRootOnly()) {
                Boolean bool = this.f11800o;
                if (bool != null) {
                    Intrinsics.checkNotNull(bool);
                    boolean booleanValue = bool.booleanValue();
                    Intrinsics.checkNotNullExpressionValue(container, "container");
                    materialCardView = materialCardView2;
                    linearLayout = linearLayout2;
                    str = "container";
                    textView = textView4;
                    imageView = warningIcon;
                    h(booleanValue, selectableItem, warningText, warningIcon, container);
                } else {
                    materialCardView = materialCardView2;
                    linearLayout = linearLayout2;
                    str = "container";
                    textView = textView4;
                    imageView = warningIcon;
                    Observable<Boolean> observeOn = observable.take(1L).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
                    view2 = findViewById;
                    final c cVar = new c(selectableItem, warningText, imageView, container);
                    observeOn.subscribe(new Consumer() { // from class: com.arlosoft.macrodroid.editscreen.t0
                        @Override // io.reactivex.functions.Consumer
                        public final void accept(Object obj) {
                            EmptyItemsViewHolder.l(Function1.this, obj);
                        }
                    });
                    z10 = false;
                }
            } else {
                materialCardView = materialCardView2;
                linearLayout = linearLayout2;
                str = "container";
                textView = textView4;
                imageView = warningIcon;
            }
            view2 = findViewById;
            z10 = false;
        }
        icon.setImageDrawable(ContextCompat.getDrawable(this.f11787b, selectableItem.getIcon()));
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
        container.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.arlosoft.macrodroid.editscreen.u0
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view3) {
                boolean m4;
                m4 = EmptyItemsViewHolder.m(Ref.LongRef.this, this, selectableItem, view3);
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
                    materialCardView.setCardBackgroundColor(ContextCompat.getColor(this.f11787b, R.color.trigger_primary));
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
                    i7 = f11784r;
                } else {
                    i7 = f11782p;
                }
                if (z6) {
                    i8 = f11785s;
                } else {
                    i8 = f11783q;
                }
                for (Integer i10 : childIcons) {
                    ImageView imageView2 = new ImageView(this.f11787b);
                    imageView2.setLayoutParams(new LinearLayoutCompat.LayoutParams(i7, i7));
                    Intrinsics.checkNotNullExpressionValue(i10, "i");
                    imageView2.setImageResource(i10.intValue());
                    ViewExtensionsKt.setMargins(imageView2, 0, 0, Integer.valueOf(f11786t), 0);
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
    public static final void k(SelectableItem item, EmptyItemsViewHolder this$0, View view) {
        Intrinsics.checkNotNullParameter(item, "$item");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        item.setActivity(this$0.f11787b);
        item.handleWarningClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean m(Ref.LongRef lastClick, EmptyItemsViewHolder this$0, SelectableItem item, View view) {
        Function1<SelectableItem, Unit> function1;
        Intrinsics.checkNotNullParameter(lastClick, "$lastClick");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        if (System.currentTimeMillis() - lastClick.element > 750 && (function1 = this$0.f11790e) != null) {
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
            return this.f11797l;
        }
        return this.f11798m;
    }

    private final int p(boolean z3) {
        if (z3) {
            return R.layout.macro_edit_entry_small;
        }
        return R.layout.macro_edit_entry;
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
            View constraintView = LayoutInflater.from(this.f11787b).inflate(p(z5), extrasContainer, z10);
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
            j(constraintView, childConstraint, z8, false, z3, z5, false, this.f11792g, z6, z7);
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

    public final void bind(@NotNull ItemType itemType, @NotNull List<? extends ItemType> items, int i4, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11) {
        boolean z12;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        boolean z13;
        int i10;
        boolean z14;
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        int i11;
        int i12;
        boolean z15;
        boolean z16;
        Intrinsics.checkNotNullParameter(itemType, "itemType");
        Intrinsics.checkNotNullParameter(items, "items");
        SelectableItem selectableItem = ((HasSelectableItem) itemType).getSelectableItem();
        ViewGroup topLevelContainer$app_standardRelease = getTopLevelContainer$app_standardRelease();
        boolean z17 = false;
        if (z10 && (selectableItem instanceof Action) && ((Action) selectableItem).isCollapsed()) {
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
        int i13 = -1;
        if (z10 && (selectableItem instanceof Action) && ((Action) selectableItem).isCollapsed()) {
            getTopLevelContainer$app_standardRelease().setLayoutParams(new RecyclerView.LayoutParams(0, 0));
        } else {
            getTopLevelContainer$app_standardRelease().getLayoutParams().width = -1;
            getTopLevelContainer$app_standardRelease().getLayoutParams().height = -2;
        }
        getCollapseExpandButton$app_standardRelease().setVisibility(8);
        if (selectableItem instanceof Action) {
            Iterator<? extends ItemType> it = items.iterator();
            int i14 = 0;
            while (true) {
                if (it.hasNext()) {
                    ItemType next = it.next();
                    if ((next instanceof HasSelectableItem) && (((HasSelectableItem) next).getSelectableItem() instanceof Action)) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        break;
                    }
                    i14++;
                } else {
                    i14 = -1;
                    break;
                }
            }
            ListIterator<? extends ItemType> listIterator = items.listIterator(items.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    break;
                }
                ItemType previous = listIterator.previous();
                if ((previous instanceof HasSelectableItem) && (((HasSelectableItem) previous).getSelectableItem() instanceof Action)) {
                    z15 = true;
                    continue;
                } else {
                    z15 = false;
                    continue;
                }
                if (z15) {
                    i13 = listIterator.nextIndex();
                    break;
                }
            }
            List<? extends ItemType> subList = items.subList(i14, i13 + 1);
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
            if (i14 <= i4) {
                int i15 = i14;
                i11 = 0;
                while (true) {
                    try {
                        ItemType itemType3 = items.get(i15);
                        Intrinsics.checkNotNull(itemType3, "null cannot be cast to non-null type com.arlosoft.macrodroid.editscreen.HasSelectableItem");
                        SelectableItem selectableItem3 = ((HasSelectableItem) itemType3).getSelectableItem();
                        if ((selectableItem3 instanceof ParentAction) && selectableItem3.isEnabled() && i15 != i4) {
                            i11++;
                        } else if (selectableItem3 instanceof EndParentAction) {
                            int startParentIndex = MacroListUtils.getStartParentIndex(arrayList2, i15 - i14);
                            if (startParentIndex >= 0) {
                                if (((Action) arrayList2.get(startParentIndex)).isEnabled()) {
                                    i11--;
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
                        ImageView collapseExpandButton$app_standardRelease = getCollapseExpandButton$app_standardRelease();
                        if (((ParentAction) selectableItem).getChildrenCollapsed()) {
                            i12 = R.drawable.ic_arrow_down;
                        } else {
                            i12 = R.drawable.material_ic_keyboard_arrow_up_24px_svg;
                        }
                        collapseExpandButton$app_standardRelease.setImageResource(i12);
                        ViewExtensionsKt.onClick$default(getCollapseExpandButton$app_standardRelease(), null, new a(selectableItem, null), 1, null);
                    }
                    if (i15 == i4) {
                        break;
                    }
                    i15++;
                }
            } else {
                i11 = 0;
            }
            if (selectableItem instanceof ElseParentAction) {
                int startIfIndex = MacroListUtils.getStartIfIndex(arrayList2, i4 - i14);
                if (startIfIndex >= 0) {
                    if (((Action) arrayList2.get(startIfIndex)).isEnabled()) {
                        i11--;
                    }
                } else {
                    SystemLog.logError("Invalid start index for Else action");
                    FirebaseCrashlytics.getInstance().recordException(new Exception("Invalid start index for Else action"));
                }
            }
            ViewGroup topLevelContainer$app_standardRelease2 = getTopLevelContainer$app_standardRelease();
            int i16 = this.f11799n;
            topLevelContainer$app_standardRelease2.setPadding((i11 * this.f11794i) + i16, 0, i16, 0);
        } else {
            ViewGroup topLevelContainer$app_standardRelease3 = getTopLevelContainer$app_standardRelease();
            int i17 = this.f11799n;
            topLevelContainer$app_standardRelease3.setPadding(i17, 0, i17, 0);
        }
        j(getCardView$app_standardRelease(), selectableItem, false, z4, true, z3, true, this.f11792g, z5, z6);
        if (!(selectableItem instanceof ConditionAction) && selectableItem.getConstraints() != null && selectableItem.getConstraints().size() > 0) {
            getConstraintLinkUnderAction$app_standardRelease().setVisibility(0);
            getConstraintContainer$app_standardRelease().removeAllViews();
            int i18 = 0;
            for (Constraint constraint : selectableItem.getConstraints()) {
                int i19 = i18 + 1;
                View constraintView = LayoutInflater.from(this.f11787b).inflate(p(z3), getConstraintContainer$app_standardRelease(), z17);
                Intrinsics.checkNotNullExpressionValue(constraintView, "constraintView");
                n(constraintView);
                Intrinsics.checkNotNullExpressionValue(constraint, "constraint");
                if (i19 == selectableItem.getConstraints().size()) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                boolean z18 = selectableItem instanceof Constraint;
                j(constraintView, constraint, z13, false, z18, z3, false, this.f11792g, z5, z6);
                getConstraintContainer$app_standardRelease().addView(constraintView);
                if (constraint.getConstraints() != null && constraint.getConstraints().size() > 0) {
                    int o4 = o(z3);
                    i10 = i19;
                    if (i10 < selectableItem.getConstraints().size()) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    q(constraint, constraintView, z18, o4, z14, z3, z5, z6);
                } else {
                    i10 = i19;
                }
                i18 = i10;
                z17 = false;
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
