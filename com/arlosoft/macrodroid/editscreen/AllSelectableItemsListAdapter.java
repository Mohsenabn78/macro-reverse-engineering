package com.arlosoft.macrodroid.editscreen;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.util.Range;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.recyclerview.widget.RecyclerView;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.Action;
import com.arlosoft.macrodroid.action.ParentAction;
import com.arlosoft.macrodroid.common.MacroDroidVariable;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.constraint.Constraint;
import com.arlosoft.macrodroid.editscreen.ItemType;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.Trigger;
import com.arlosoft.macrodroid.utils.MacroListUtils;
import com.h6ah4i.android.widget.advrecyclerview.draggable.DraggableItemAdapter;
import com.h6ah4i.android.widget.advrecyclerview.draggable.ItemDraggableRange;
import com.stericson.RootShell.RootShell;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.Callable;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AllSelectableItemsListAdapter.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nAllSelectableItemsListAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AllSelectableItemsListAdapter.kt\ncom/arlosoft/macrodroid/editscreen/AllSelectableItemsListAdapter\n+ 2 Lists.kt\nsplitties/collections/ListsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,618:1\n33#2,6:619\n33#2,6:625\n33#2,6:631\n33#2,6:637\n800#3,11:643\n800#3,11:654\n800#3,11:665\n800#3,11:676\n1549#3:687\n1620#3,3:688\n766#3:691\n857#3,2:692\n1549#3:694\n1620#3,2:695\n800#3,11:697\n800#3,11:708\n800#3,11:719\n1622#3:730\n350#3,7:731\n378#3,7:738\n1549#3:745\n1620#3,3:746\n800#3,11:749\n1549#3:760\n1620#3,3:761\n800#3,11:764\n1549#3:775\n1620#3,3:776\n800#3,11:779\n1549#3:790\n1620#3,3:791\n1549#3:794\n1620#3,3:795\n*S KotlinDebug\n*F\n+ 1 AllSelectableItemsListAdapter.kt\ncom/arlosoft/macrodroid/editscreen/AllSelectableItemsListAdapter\n*L\n167#1:619,6\n178#1:625,6\n189#1:631,6\n199#1:637,6\n394#1:643,11\n398#1:654,11\n402#1:665,11\n406#1:676,11\n439#1:687\n439#1:688,3\n463#1:691\n463#1:692,2\n465#1:694\n465#1:695,2\n466#1:697,11\n470#1:708,11\n474#1:719,11\n465#1:730\n496#1:731,7\n497#1:738,7\n558#1:745\n558#1:746,3\n562#1:749,11\n562#1:760\n562#1:761,3\n564#1:764,11\n564#1:775\n564#1:776,3\n566#1:779,11\n566#1:790\n566#1:791,3\n577#1:794\n577#1:795,3\n*E\n"})
/* loaded from: classes3.dex */
public final class AllSelectableItemsListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements DraggableItemAdapter<RecyclerView.ViewHolder> {
    public static final int $stable = 8;
    @NotNull
    private final AllSelectableItemsListAdapter$triggerHeaderCallbackInternal$1 A;
    @NotNull
    private final AllSelectableItemsListAdapter$actionHeaderCallbackInternal$1 B;
    @NotNull
    private final AllSelectableItemsListAdapter$constraintHeaderCallbackInternal$1 C;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Activity f11681a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final Macro f11682b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f11683c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final Function1<SelectableItem, Unit> f11684d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final Function1<SelectableItem, Unit> f11685e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private final Function1<SelectableItem, Unit> f11686f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f11687g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f11688h;
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    private final HeaderCallback f11689i;
    @NotNull

    /* renamed from: j  reason: collision with root package name */
    private final HeaderCallback f11690j;
    @NotNull

    /* renamed from: k  reason: collision with root package name */
    private final HeaderCallbackConstraint f11691k;
    @NotNull

    /* renamed from: l  reason: collision with root package name */
    private final HeaderCallback f11692l;
    @NotNull

    /* renamed from: m  reason: collision with root package name */
    private final Function1<MacroDroidVariable, Unit> f11693m;
    @Nullable

    /* renamed from: n  reason: collision with root package name */
    private final Function0<Unit> f11694n;
    @Nullable

    /* renamed from: o  reason: collision with root package name */
    private final Function1<List<? extends ItemType>, Unit> f11695o;
    @NotNull

    /* renamed from: p  reason: collision with root package name */
    private final BehaviorSubject<Boolean> f11696p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f11697q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f11698r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f11699s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f11700t;
    @Nullable

    /* renamed from: u  reason: collision with root package name */
    private Range<Integer> f11701u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f11702v;
    @NotNull

    /* renamed from: w  reason: collision with root package name */
    private List<? extends ItemType> f11703w;
    @NotNull

    /* renamed from: x  reason: collision with root package name */
    private List<? extends ItemType> f11704x;
    @NotNull

    /* renamed from: y  reason: collision with root package name */
    private List<Integer> f11705y;
    @NotNull

    /* renamed from: z  reason: collision with root package name */
    private PasteButtonVisibilty f11706z;

    /* compiled from: AllSelectableItemsListAdapter.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class OrderBlock {
        public static final int $stable = 8;

        /* renamed from: a  reason: collision with root package name */
        private final int f11707a;

        /* renamed from: b  reason: collision with root package name */
        private final int f11708b;
        @NotNull

        /* renamed from: c  reason: collision with root package name */
        private final List<ItemType> f11709c;

        /* JADX WARN: Multi-variable type inference failed */
        public OrderBlock(int i4, int i5, @NotNull List<? extends ItemType> items) {
            Intrinsics.checkNotNullParameter(items, "items");
            this.f11707a = i4;
            this.f11708b = i5;
            this.f11709c = items;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ OrderBlock copy$default(OrderBlock orderBlock, int i4, int i5, List list, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                i4 = orderBlock.f11707a;
            }
            if ((i6 & 2) != 0) {
                i5 = orderBlock.f11708b;
            }
            if ((i6 & 4) != 0) {
                list = orderBlock.f11709c;
            }
            return orderBlock.copy(i4, i5, list);
        }

        public final int component1() {
            return this.f11707a;
        }

        public final int component2() {
            return this.f11708b;
        }

        @NotNull
        public final List<ItemType> component3() {
            return this.f11709c;
        }

        @NotNull
        public final OrderBlock copy(int i4, int i5, @NotNull List<? extends ItemType> items) {
            Intrinsics.checkNotNullParameter(items, "items");
            return new OrderBlock(i4, i5, items);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OrderBlock)) {
                return false;
            }
            OrderBlock orderBlock = (OrderBlock) obj;
            if (this.f11707a == orderBlock.f11707a && this.f11708b == orderBlock.f11708b && Intrinsics.areEqual(this.f11709c, orderBlock.f11709c)) {
                return true;
            }
            return false;
        }

        public final int getEndPosition() {
            return this.f11708b;
        }

        @NotNull
        public final List<ItemType> getItems() {
            return this.f11709c;
        }

        public final int getStartPosition() {
            return this.f11707a;
        }

        public int hashCode() {
            return (((this.f11707a * 31) + this.f11708b) * 31) + this.f11709c.hashCode();
        }

        public final boolean isAtPosition(int i4) {
            int i5 = this.f11707a;
            if (i4 > this.f11708b || i5 > i4) {
                return false;
            }
            return true;
        }

        public final int size() {
            return (this.f11708b - this.f11707a) + 1;
        }

        @NotNull
        public String toString() {
            int i4 = this.f11707a;
            int i5 = this.f11708b;
            List<ItemType> list = this.f11709c;
            return "OrderBlock(startPosition=" + i4 + ", endPosition=" + i5 + ", items=" + list + ")";
        }
    }

    /* compiled from: AllSelectableItemsListAdapter.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[ViewType.values().length];
            try {
                iArr[ViewType.TRIGGER_HEADER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ViewType.TRIGGER_EMPTY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ViewType.ACTION_HEADER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ViewType.ACTION_EMPTY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ViewType.CONSTRAINT_HEADER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ViewType.CONSTRAINT_EMPTY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[ViewType.SELECTABLE_ITEM_TRIGGER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[ViewType.SELECTABLE_ITEM_ACTION.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[ViewType.SELECTABLE_ITEM_CONSTRAINT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[ViewType.SELECTABLE_ITEM_TRIGGER_LAST.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[ViewType.SELECTABLE_ITEM_ACTION_LAST.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[ViewType.SELECTABLE_ITEM_CONSTRAINT_LAST.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[ViewType.LOCAL_VARIABLE_HEADER.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[ViewType.LOCAL_VARIABLE_EMPTY.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[ViewType.LOCAL_VARIABLE_ITEM.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[ViewType.LOCAL_VARIABLE_ITEM_LAST.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[SelectableItemType.values().length];
            try {
                iArr2[SelectableItemType.TRIGGER.ordinal()] = 1;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr2[SelectableItemType.ACTION.ordinal()] = 2;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr2[SelectableItemType.CONSTRAINT.ordinal()] = 3;
            } catch (NoSuchFieldError unused19) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AllSelectableItemsListAdapter.kt */
    /* loaded from: classes3.dex */
    public static final class a extends Lambda implements Function1<Boolean, Unit> {
        a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke2(bool);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(Boolean bool) {
            AllSelectableItemsListAdapter.this.f11696p.onNext(bool);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AllSelectableItemsListAdapter.kt */
    /* loaded from: classes3.dex */
    public static final class b extends Lambda implements Function1<Throwable, Unit> {
        b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke2(th);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th) {
            AllSelectableItemsListAdapter.this.f11696p.onNext(Boolean.FALSE);
        }
    }

    /* compiled from: AllSelectableItemsListAdapter.kt */
    /* loaded from: classes3.dex */
    static final class c extends Lambda implements Function1<SelectableItem, Unit> {
        c() {
            super(1);
        }

        public final void a(@NotNull SelectableItem it) {
            Intrinsics.checkNotNullParameter(it, "it");
            AllSelectableItemsListAdapter.this.notifyDataSetChanged();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SelectableItem selectableItem) {
            a(selectableItem);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: AllSelectableItemsListAdapter.kt */
    /* loaded from: classes3.dex */
    static final class d extends Lambda implements Function1<SelectableItem, Unit> {
        d() {
            super(1);
        }

        public final void a(@NotNull SelectableItem it) {
            Intrinsics.checkNotNullParameter(it, "it");
            AllSelectableItemsListAdapter.this.notifyDataSetChanged();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SelectableItem selectableItem) {
            a(selectableItem);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: AllSelectableItemsListAdapter.kt */
    /* loaded from: classes3.dex */
    static final class e extends Lambda implements Function1<SelectableItem, Unit> {
        e() {
            super(1);
        }

        public final void a(@NotNull SelectableItem it) {
            Intrinsics.checkNotNullParameter(it, "it");
            AllSelectableItemsListAdapter.this.notifyDataSetChanged();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SelectableItem selectableItem) {
            a(selectableItem);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: AllSelectableItemsListAdapter.kt */
    /* loaded from: classes3.dex */
    static final class f extends Lambda implements Function1<SelectableItem, Unit> {
        f() {
            super(1);
        }

        public final void a(@NotNull SelectableItem it) {
            Intrinsics.checkNotNullParameter(it, "it");
            AllSelectableItemsListAdapter.this.notifyDataSetChanged();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SelectableItem selectableItem) {
            a(selectableItem);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: AllSelectableItemsListAdapter.kt */
    /* loaded from: classes3.dex */
    static final class g extends Lambda implements Function1<SelectableItem, Unit> {
        g() {
            super(1);
        }

        public final void a(@NotNull SelectableItem it) {
            Intrinsics.checkNotNullParameter(it, "it");
            AllSelectableItemsListAdapter.this.notifyDataSetChanged();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SelectableItem selectableItem) {
            a(selectableItem);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: AllSelectableItemsListAdapter.kt */
    /* loaded from: classes3.dex */
    static final class h extends Lambda implements Function1<SelectableItem, Unit> {
        h() {
            super(1);
        }

        public final void a(@NotNull SelectableItem it) {
            Intrinsics.checkNotNullParameter(it, "it");
            AllSelectableItemsListAdapter.this.notifyDataSetChanged();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SelectableItem selectableItem) {
            a(selectableItem);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11, types: [com.arlosoft.macrodroid.editscreen.AllSelectableItemsListAdapter$triggerHeaderCallbackInternal$1] */
    /* JADX WARN: Type inference failed for: r1v12, types: [com.arlosoft.macrodroid.editscreen.AllSelectableItemsListAdapter$actionHeaderCallbackInternal$1] */
    /* JADX WARN: Type inference failed for: r1v13, types: [com.arlosoft.macrodroid.editscreen.AllSelectableItemsListAdapter$constraintHeaderCallbackInternal$1] */
    public AllSelectableItemsListAdapter(@NotNull Activity context, @NotNull Macro macro, boolean z3, @NotNull Function1<? super SelectableItem, Unit> itemListener, @NotNull Function1<? super SelectableItem, Unit> itemLongClickListener, @NotNull Function1<? super SelectableItem, Unit> itemCollapseExpandListener, boolean z4, boolean z5, @NotNull HeaderCallback triggerHeaderCallback, @NotNull HeaderCallback actionHeaderCallback, @NotNull HeaderCallbackConstraint constraintHeaderCallback, @NotNull HeaderCallback localVarsHeaderCallback, @NotNull Function1<? super MacroDroidVariable, Unit> localVarClickListener, @Nullable Function0<Unit> function0, @Nullable Function1<? super List<? extends ItemType>, Unit> function1) {
        List<? extends ItemType> emptyList;
        List<? extends ItemType> emptyList2;
        List<Integer> emptyList3;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(macro, "macro");
        Intrinsics.checkNotNullParameter(itemListener, "itemListener");
        Intrinsics.checkNotNullParameter(itemLongClickListener, "itemLongClickListener");
        Intrinsics.checkNotNullParameter(itemCollapseExpandListener, "itemCollapseExpandListener");
        Intrinsics.checkNotNullParameter(triggerHeaderCallback, "triggerHeaderCallback");
        Intrinsics.checkNotNullParameter(actionHeaderCallback, "actionHeaderCallback");
        Intrinsics.checkNotNullParameter(constraintHeaderCallback, "constraintHeaderCallback");
        Intrinsics.checkNotNullParameter(localVarsHeaderCallback, "localVarsHeaderCallback");
        Intrinsics.checkNotNullParameter(localVarClickListener, "localVarClickListener");
        this.f11681a = context;
        this.f11682b = macro;
        this.f11683c = z3;
        this.f11684d = itemListener;
        this.f11685e = itemLongClickListener;
        this.f11686f = itemCollapseExpandListener;
        this.f11687g = z4;
        this.f11688h = z5;
        this.f11689i = triggerHeaderCallback;
        this.f11690j = actionHeaderCallback;
        this.f11691k = constraintHeaderCallback;
        this.f11692l = localVarsHeaderCallback;
        this.f11693m = localVarClickListener;
        this.f11694n = function0;
        this.f11695o = function1;
        BehaviorSubject<Boolean> create = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create, "create<Boolean>()");
        this.f11696p = create;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.f11703w = emptyList;
        emptyList2 = CollectionsKt__CollectionsKt.emptyList();
        this.f11704x = emptyList2;
        emptyList3 = CollectionsKt__CollectionsKt.emptyList();
        this.f11705y = emptyList3;
        this.f11706z = PasteButtonVisibilty.NONE;
        this.A = new HeaderCallbackInternal() { // from class: com.arlosoft.macrodroid.editscreen.AllSelectableItemsListAdapter$triggerHeaderCallbackInternal$1
            @Override // com.arlosoft.macrodroid.editscreen.HeaderCallbackInternal
            public void onReorder() {
                AllSelectableItemsListAdapter allSelectableItemsListAdapter = AllSelectableItemsListAdapter.this;
                allSelectableItemsListAdapter.setTriggerDragEnabled(!allSelectableItemsListAdapter.isTriggerDragEnabled());
                AllSelectableItemsListAdapter.this.notifyDataSetChanged();
            }
        };
        this.B = new HeaderCallbackInternal() { // from class: com.arlosoft.macrodroid.editscreen.AllSelectableItemsListAdapter$actionHeaderCallbackInternal$1
            @Override // com.arlosoft.macrodroid.editscreen.HeaderCallbackInternal
            public void onReorder() {
                AllSelectableItemsListAdapter allSelectableItemsListAdapter = AllSelectableItemsListAdapter.this;
                allSelectableItemsListAdapter.setActionDragEnabled(!allSelectableItemsListAdapter.isActionDragEnabled());
                AllSelectableItemsListAdapter.this.notifyDataSetChanged();
            }
        };
        this.C = new HeaderCallbackInternal() { // from class: com.arlosoft.macrodroid.editscreen.AllSelectableItemsListAdapter$constraintHeaderCallbackInternal$1
            @Override // com.arlosoft.macrodroid.editscreen.HeaderCallbackInternal
            public void onReorder() {
                AllSelectableItemsListAdapter allSelectableItemsListAdapter = AllSelectableItemsListAdapter.this;
                allSelectableItemsListAdapter.setConstraintDragEnabled(!allSelectableItemsListAdapter.isConstraintDragEnabled());
                AllSelectableItemsListAdapter.this.notifyDataSetChanged();
            }
        };
        e();
        setHasStableIds(true);
        ArrayList<Trigger> triggerList = macro.getTriggerList();
        Intrinsics.checkNotNullExpressionValue(triggerList, "macro.triggerList");
        ArrayList<Action> actions = macro.getActions();
        Intrinsics.checkNotNullExpressionValue(actions, "macro.actions");
        List<Constraint> constraints = macro.getConstraints();
        Intrinsics.checkNotNullExpressionValue(constraints, "macro.constraints");
        List<MacroDroidVariable> localVariablesSorted = macro.getLocalVariablesSorted();
        Intrinsics.checkNotNullExpressionValue(localVariablesSorted, "macro.localVariablesSorted");
        o(triggerList, actions, constraints, localVariablesSorted);
        refreshShownItems();
    }

    private final void e() {
        Single observeOn = Single.defer(new Callable() { // from class: com.arlosoft.macrodroid.editscreen.b
            @Override // java.util.concurrent.Callable
            public final Object call() {
                SingleSource f4;
                f4 = AllSelectableItemsListAdapter.f();
                return f4;
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final a aVar = new a();
        Consumer consumer = new Consumer() { // from class: com.arlosoft.macrodroid.editscreen.c
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AllSelectableItemsListAdapter.g(Function1.this, obj);
            }
        };
        final b bVar = new b();
        observeOn.subscribe(consumer, new Consumer() { // from class: com.arlosoft.macrodroid.editscreen.d
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AllSelectableItemsListAdapter.h(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SingleSource f() {
        return Single.just(Boolean.valueOf(RootShell.isAccessGiven(1000, 2)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final List<ItemType.Action> i() {
        ArrayList arrayList = new ArrayList();
        for (Object obj : this.f11703w) {
            if (obj instanceof ItemType.Action) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    private final List<ItemType> j() {
        ArrayList arrayList = new ArrayList();
        for (Object obj : this.f11703w) {
            if (obj instanceof ItemType.Constraint) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    private final int k() {
        if (this.f11687g) {
            return R.layout.macro_edit_entry_bottom_small;
        }
        return R.layout.macro_edit_entry_bottom;
    }

    private final int l() {
        if (this.f11687g) {
            return R.layout.macro_edit_entry_small;
        }
        return R.layout.macro_edit_entry;
    }

    private final List<OrderBlock> m() {
        int collectionSizeOrDefault;
        List listOf;
        ArrayList arrayList = new ArrayList();
        List<ItemType.Action> i4 = i();
        collectionSizeOrDefault = kotlin.collections.f.collectionSizeOrDefault(i4, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        for (ItemType.Action action : i4) {
            arrayList2.add(action.getAction());
        }
        int i5 = 0;
        int i6 = 0;
        while (i5 < this.f11703w.size()) {
            ItemType itemType = this.f11703w.get(i5);
            boolean z3 = itemType instanceof ItemType.Action;
            if (z3) {
                ItemType.Action action2 = (ItemType.Action) itemType;
                if ((action2.getAction() instanceof ParentAction) && ((ParentAction) action2.getAction()).getChildrenCollapsed()) {
                    ((ParentAction) action2.getAction()).getChildActions();
                    int parentEndIndex = MacroListUtils.getParentEndIndex(arrayList2, i6);
                    int i7 = (parentEndIndex - i6) + 1 + i5;
                    arrayList.add(new OrderBlock(i5, i7 - 1, this.f11703w.subList(i5, i7)));
                    i6 = parentEndIndex + 1;
                    i5 = i7;
                }
            }
            listOf = kotlin.collections.e.listOf(itemType);
            arrayList.add(new OrderBlock(i5, i5, listOf));
            i5++;
            if (z3) {
                i6++;
            }
        }
        return arrayList;
    }

    private final List<ItemType> n() {
        ArrayList arrayList = new ArrayList();
        for (Object obj : this.f11703w) {
            if (obj instanceof ItemType.Trigger) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    private final void o(List<? extends Trigger> list, List<? extends Action> list2, List<? extends Constraint> list3, List<MacroDroidVariable> list4) {
        int lastIndex;
        boolean z3;
        int lastIndex2;
        boolean z4;
        int lastIndex3;
        boolean z5;
        int lastIndex4;
        boolean z6;
        List<? extends ItemType> list5;
        ArrayList arrayList = new ArrayList();
        arrayList.add(ItemType.TriggerHeader.INSTANCE);
        if (list.isEmpty()) {
            arrayList.add(ItemType.TriggersEmpty.INSTANCE);
        } else {
            int size = list.size();
            lastIndex = CollectionsKt__CollectionsKt.getLastIndex(list);
            if (lastIndex >= 0) {
                int i4 = 0;
                while (true) {
                    int i5 = i4 + 1;
                    if (list.size() == size) {
                        Trigger trigger = list.get(i4);
                        if (i4 == list.size() - 1) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        arrayList.add(new ItemType.Trigger(trigger, z3));
                        if (i4 == lastIndex) {
                            break;
                        }
                        i4 = i5;
                    } else {
                        throw new ConcurrentModificationException();
                    }
                }
            }
        }
        arrayList.add(ItemType.ActionHeader.INSTANCE);
        if (list2.isEmpty()) {
            arrayList.add(ItemType.ActionsEmpty.INSTANCE);
        } else {
            int size2 = list2.size();
            lastIndex2 = CollectionsKt__CollectionsKt.getLastIndex(list2);
            if (lastIndex2 >= 0) {
                int i6 = 0;
                while (true) {
                    int i7 = i6 + 1;
                    if (list2.size() == size2) {
                        Action action = list2.get(i6);
                        if (i6 == list2.size() - 1) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        arrayList.add(new ItemType.Action(action, z4));
                        if (i6 == lastIndex2) {
                            break;
                        }
                        i6 = i7;
                    } else {
                        throw new ConcurrentModificationException();
                    }
                }
            }
        }
        arrayList.add(ItemType.ConstraintHeader.INSTANCE);
        if (list3.isEmpty()) {
            arrayList.add(ItemType.ConstraintsEmpty.INSTANCE);
        } else {
            int size3 = list3.size();
            lastIndex3 = CollectionsKt__CollectionsKt.getLastIndex(list3);
            if (lastIndex3 >= 0) {
                int i8 = 0;
                while (true) {
                    int i9 = i8 + 1;
                    if (list3.size() == size3) {
                        Constraint constraint = list3.get(i8);
                        if (i8 == list3.size() - 1) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        arrayList.add(new ItemType.Constraint(constraint, z5));
                        if (i8 == lastIndex3) {
                            break;
                        }
                        i8 = i9;
                    } else {
                        throw new ConcurrentModificationException();
                    }
                }
            }
        }
        arrayList.add(ItemType.LocalVariableHeader.INSTANCE);
        if (list4.isEmpty()) {
            arrayList.add(ItemType.LocalVariablesEmpty.INSTANCE);
        } else {
            int size4 = list4.size();
            lastIndex4 = CollectionsKt__CollectionsKt.getLastIndex(list4);
            if (lastIndex4 >= 0) {
                int i10 = 0;
                while (true) {
                    int i11 = i10 + 1;
                    if (list4.size() == size4) {
                        MacroDroidVariable macroDroidVariable = list4.get(i10);
                        if (i10 == list4.size() - 1) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        arrayList.add(new ItemType.LocalVariable(macroDroidVariable, z6));
                        if (i10 == lastIndex4) {
                            break;
                        }
                        i10 = i11;
                    } else {
                        throw new ConcurrentModificationException();
                    }
                }
            }
        }
        list5 = CollectionsKt___CollectionsKt.toList(arrayList);
        this.f11703w = list5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(AllSelectableItemsListAdapter this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.notifyDataSetChanged();
    }

    private final boolean q(SelectableItemType selectableItemType) {
        int i4 = WhenMappings.$EnumSwitchMapping$1[selectableItemType.ordinal()];
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 == 3) {
                    return this.f11699s;
                }
                throw new NoWhenBranchMatchedException();
            }
            return this.f11698r;
        }
        return this.f11697q;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f11704x.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i4) {
        return this.f11704x.get(i4).getId();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i4) {
        return this.f11704x.get(i4).getViewType().getId();
    }

    public final void highlightSearchItems(@NotNull List<Integer> highlightedIndexes) {
        Intrinsics.checkNotNullParameter(highlightedIndexes, "highlightedIndexes");
        this.f11705y = highlightedIndexes;
        notifyDataSetChanged();
    }

    public final boolean isActionDragEnabled() {
        return this.f11698r;
    }

    public final boolean isConstraintDragEnabled() {
        return this.f11699s;
    }

    public final boolean isTriggerDragEnabled() {
        return this.f11697q;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, int i4) {
        boolean z3;
        Integer num;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        Intrinsics.checkNotNullParameter(holder, "holder");
        boolean z10 = false;
        if (holder instanceof TriggerHeadingViewHolder) {
            TriggerHeadingViewHolder triggerHeadingViewHolder = (TriggerHeadingViewHolder) holder;
            if (n().size() > 1) {
                z9 = true;
            } else {
                z9 = false;
            }
            if (this.f11706z == PasteButtonVisibilty.TRIGGER) {
                z10 = true;
            }
            triggerHeadingViewHolder.bind(z9, z10);
        } else if (holder instanceof ActionHeadingViewHolder) {
            ActionHeadingViewHolder actionHeadingViewHolder = (ActionHeadingViewHolder) holder;
            if (i().size() > 1) {
                z8 = true;
            } else {
                z8 = false;
            }
            if (this.f11706z == PasteButtonVisibilty.ACTION) {
                z10 = true;
            }
            actionHeadingViewHolder.bind(z8, z10);
        } else if (holder instanceof ConstraintHeadingViewHolder) {
            ConstraintHeadingViewHolder constraintHeadingViewHolder = (ConstraintHeadingViewHolder) holder;
            if (j().size() > 1) {
                z6 = true;
            } else {
                z6 = false;
            }
            if (j().size() > 1) {
                z7 = true;
            } else {
                z7 = false;
            }
            boolean z11 = !this.f11682b.isConstraintOrCondition();
            if (this.f11706z == PasteButtonVisibilty.CONSTRAINT) {
                z10 = true;
            }
            constraintHeadingViewHolder.bind(z6, z7, z11, z10);
        } else if (holder instanceof AllSelectableItemsViewHolder) {
            Range<Integer> range = this.f11701u;
            if (range != null) {
                z3 = range.contains((Range<Integer>) Integer.valueOf(i4));
            } else {
                z3 = false;
            }
            Range<Integer> range2 = this.f11701u;
            Integer num2 = null;
            if (range2 != null) {
                num = range2.getLower();
            } else {
                num = null;
            }
            if (num == null) {
                num = Boolean.FALSE;
            }
            boolean areEqual = Intrinsics.areEqual(num, Integer.valueOf(i4));
            Range<Integer> range3 = this.f11701u;
            if (range3 != null) {
                num2 = range3.getUpper();
            }
            if (num2 == null) {
                num2 = Boolean.FALSE;
            }
            boolean areEqual2 = Intrinsics.areEqual(num2, Integer.valueOf(i4));
            AllSelectableItemsViewHolder allSelectableItemsViewHolder = (AllSelectableItemsViewHolder) holder;
            ItemType itemType = this.f11704x.get(i4);
            List<? extends ItemType> list = this.f11704x;
            boolean z12 = this.f11687g;
            boolean q4 = q(allSelectableItemsViewHolder.getType());
            boolean z13 = this.f11688h;
            boolean z14 = this.f11702v;
            Range<Integer> range4 = this.f11701u;
            if (range4 == null) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (range4 != null) {
                z5 = true;
            } else {
                z5 = false;
            }
            allSelectableItemsViewHolder.bind(itemType, list, i4, z12, q4, z13, z3, areEqual, areEqual2, z14, z4, z5, this.f11705y.contains(Integer.valueOf(i4)));
        } else if (holder instanceof ItemsEmptyViewHolder) {
            ((ItemsEmptyViewHolder) holder).bind();
        } else if (holder instanceof LocalVarsHeadingViewHolder) {
            ((LocalVarsHeadingViewHolder) holder).bind();
        } else if (holder instanceof LocalVarsViewHolder) {
            ItemType itemType2 = this.f11704x.get(i4);
            Intrinsics.checkNotNull(itemType2, "null cannot be cast to non-null type com.arlosoft.macrodroid.editscreen.ItemType.LocalVariable");
            ((LocalVarsViewHolder) holder).bind(((ItemType.LocalVariable) itemType2).getLocalVariable());
        } else {
            throw new IllegalArgumentException("Unknown viewHolderType: " + holder);
        }
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.draggable.DraggableItemAdapter
    public boolean onCheckCanDrop(int i4, int i5) {
        return true;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.draggable.DraggableItemAdapter
    public boolean onCheckCanStartDrag(@NotNull RecyclerView.ViewHolder holder, int i4, int i5, int i6) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Rect rect = new Rect();
        AllSelectableItemsViewHolder allSelectableItemsViewHolder = (AllSelectableItemsViewHolder) holder;
        allSelectableItemsViewHolder.getDragHandle().getDrawingRect(rect);
        allSelectableItemsViewHolder.getTopLevelContainer$app_standardRelease().offsetDescendantRectToMyCoords(allSelectableItemsViewHolder.getDragHandle(), rect);
        boolean contains = rect.contains(i5, i6);
        this.f11700t = contains;
        return contains;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i4) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        switch (WhenMappings.$EnumSwitchMapping$0[ViewType.Companion.fromId(i4).ordinal()]) {
            case 1:
                View v3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.edit_macro_trigger_header_item, parent, false);
                Intrinsics.checkNotNullExpressionValue(v3, "v");
                return new TriggerHeadingViewHolder(v3, this.A, this.f11689i);
            case 2:
                View v4 = LayoutInflater.from(parent.getContext()).inflate(R.layout.edit_macro_trigger_empty, parent, false);
                Intrinsics.checkNotNullExpressionValue(v4, "v");
                return new ItemsEmptyViewHolder(v4);
            case 3:
                View v5 = LayoutInflater.from(parent.getContext()).inflate(R.layout.edit_macro_action_header_item, parent, false);
                Intrinsics.checkNotNullExpressionValue(v5, "v");
                return new ActionHeadingViewHolder(v5, this.B, this.f11690j);
            case 4:
                View v6 = LayoutInflater.from(parent.getContext()).inflate(R.layout.edit_macro_action_empty, parent, false);
                Intrinsics.checkNotNullExpressionValue(v6, "v");
                return new ItemsEmptyViewHolder(v6);
            case 5:
                View v7 = LayoutInflater.from(parent.getContext()).inflate(R.layout.edit_macro_constraint_header_item, parent, false);
                Intrinsics.checkNotNullExpressionValue(v7, "v");
                return new ConstraintHeadingViewHolder(v7, this.C, this.f11691k);
            case 6:
                View v8 = LayoutInflater.from(parent.getContext()).inflate(R.layout.edit_macro_constraint_empty, parent, false);
                Intrinsics.checkNotNullExpressionValue(v8, "v");
                return new ItemsEmptyViewHolder(v8);
            case 7:
                View v9 = LayoutInflater.from(parent.getContext()).inflate(l(), parent, false);
                SelectableItemType selectableItemType = SelectableItemType.TRIGGER;
                Activity activity = this.f11681a;
                Macro macro = this.f11682b;
                Intrinsics.checkNotNullExpressionValue(v9, "v");
                return new AllSelectableItemsViewHolder(selectableItemType, activity, macro, v9, this.f11684d, this.f11685e, this.f11686f, this.f11696p, new c());
            case 8:
                View v10 = LayoutInflater.from(parent.getContext()).inflate(l(), parent, false);
                SelectableItemType selectableItemType2 = SelectableItemType.ACTION;
                Activity activity2 = this.f11681a;
                Macro macro2 = this.f11682b;
                Intrinsics.checkNotNullExpressionValue(v10, "v");
                return new AllSelectableItemsViewHolder(selectableItemType2, activity2, macro2, v10, this.f11684d, this.f11685e, this.f11686f, this.f11696p, new d());
            case 9:
                View v11 = LayoutInflater.from(parent.getContext()).inflate(l(), parent, false);
                SelectableItemType selectableItemType3 = SelectableItemType.CONSTRAINT;
                Activity activity3 = this.f11681a;
                Macro macro3 = this.f11682b;
                Intrinsics.checkNotNullExpressionValue(v11, "v");
                return new AllSelectableItemsViewHolder(selectableItemType3, activity3, macro3, v11, this.f11684d, this.f11685e, this.f11686f, this.f11696p, new e());
            case 10:
                View v12 = LayoutInflater.from(parent.getContext()).inflate(k(), parent, false);
                SelectableItemType selectableItemType4 = SelectableItemType.TRIGGER;
                Activity activity4 = this.f11681a;
                Macro macro4 = this.f11682b;
                Intrinsics.checkNotNullExpressionValue(v12, "v");
                return new AllSelectableItemsViewHolder(selectableItemType4, activity4, macro4, v12, this.f11684d, this.f11685e, this.f11686f, this.f11696p, new f());
            case 11:
                View v13 = LayoutInflater.from(parent.getContext()).inflate(k(), parent, false);
                SelectableItemType selectableItemType5 = SelectableItemType.ACTION;
                Activity activity5 = this.f11681a;
                Macro macro5 = this.f11682b;
                Intrinsics.checkNotNullExpressionValue(v13, "v");
                return new AllSelectableItemsViewHolder(selectableItemType5, activity5, macro5, v13, this.f11684d, this.f11685e, this.f11686f, this.f11696p, new g());
            case 12:
                View v14 = LayoutInflater.from(parent.getContext()).inflate(k(), parent, false);
                SelectableItemType selectableItemType6 = SelectableItemType.CONSTRAINT;
                Activity activity6 = this.f11681a;
                Macro macro6 = this.f11682b;
                Intrinsics.checkNotNullExpressionValue(v14, "v");
                return new AllSelectableItemsViewHolder(selectableItemType6, activity6, macro6, v14, this.f11684d, this.f11685e, this.f11686f, this.f11696p, new h());
            case 13:
                View v15 = LayoutInflater.from(parent.getContext()).inflate(R.layout.edit_macro_local_variable_header_item, parent, false);
                Intrinsics.checkNotNullExpressionValue(v15, "v");
                return new LocalVarsHeadingViewHolder(v15, this.f11692l);
            case 14:
                View v16 = LayoutInflater.from(parent.getContext()).inflate(R.layout.edit_macro_local_variable_empty, parent, false);
                Intrinsics.checkNotNullExpressionValue(v16, "v");
                return new ItemsEmptyViewHolder(v16);
            case 15:
                View v17 = LayoutInflater.from(parent.getContext()).inflate(l(), parent, false);
                Intrinsics.checkNotNullExpressionValue(v17, "v");
                Resources resources = this.f11681a.getResources();
                Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
                return new LocalVarsViewHolder(v17, resources, false, this.f11693m);
            case 16:
                View v18 = LayoutInflater.from(parent.getContext()).inflate(k(), parent, false);
                Intrinsics.checkNotNullExpressionValue(v18, "v");
                Resources resources2 = this.f11681a.getResources();
                Intrinsics.checkNotNullExpressionValue(resources2, "context.resources");
                return new LocalVarsViewHolder(v18, resources2, false, this.f11693m);
            default:
                throw new IllegalArgumentException("Unknown viewType: " + i4);
        }
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.draggable.DraggableItemAdapter
    @NotNull
    public ItemDraggableRange onGetItemDraggableRange(@NotNull RecyclerView.ViewHolder holder, int i4) {
        int i5;
        Intrinsics.checkNotNullParameter(holder, "holder");
        String simpleName = this.f11704x.get(i4).getClass().getSimpleName();
        Iterator<? extends ItemType> it = this.f11704x.iterator();
        int i6 = 0;
        while (true) {
            i5 = -1;
            if (it.hasNext()) {
                if (Intrinsics.areEqual(it.next().getClass().getSimpleName(), simpleName)) {
                    break;
                }
                i6++;
            } else {
                i6 = -1;
                break;
            }
        }
        List<? extends ItemType> list = this.f11704x;
        ListIterator<? extends ItemType> listIterator = list.listIterator(list.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                break;
            } else if (Intrinsics.areEqual(listIterator.previous().getClass().getSimpleName(), simpleName)) {
                i5 = listIterator.nextIndex();
                break;
            }
        }
        return new ItemDraggableRange(i6, i5);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.draggable.DraggableItemAdapter
    public void onItemDragFinished(int i4, int i5, boolean z3) {
        Function1<List<? extends ItemType>, Unit> function1;
        this.f11700t = false;
        if (i4 != i5 && (function1 = this.f11695o) != null) {
            function1.invoke(this.f11703w);
        }
        notifyDataSetChanged();
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.arlosoft.macrodroid.editscreen.a
            @Override // java.lang.Runnable
            public final void run() {
                AllSelectableItemsListAdapter.p(AllSelectableItemsListAdapter.this);
            }
        }, 250L);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.draggable.DraggableItemAdapter
    public void onItemDragStarted(int i4) {
        Function0<Unit> function0 = this.f11694n;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.draggable.DraggableItemAdapter
    public void onMoveItem(int i4, int i5) {
        List mutableList;
        int indexOf;
        int collectionSizeOrDefault;
        List flatten;
        List mutableList2;
        List<? extends ItemType> list;
        Object firstOrNull;
        Object firstOrNull2;
        Object firstOrNull3;
        int collectionSizeOrDefault2;
        int collectionSizeOrDefault3;
        int collectionSizeOrDefault4;
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) m());
        OrderBlock orderBlock = (OrderBlock) mutableList.get(i4);
        if (i5 > i4) {
            OrderBlock orderBlock2 = (OrderBlock) mutableList.get(i5);
            if (Intrinsics.areEqual(orderBlock, orderBlock2)) {
                return;
            }
            mutableList.remove(orderBlock);
            indexOf = mutableList.indexOf(orderBlock2) + 1;
        } else {
            OrderBlock orderBlock3 = (OrderBlock) mutableList.get(i5);
            if (Intrinsics.areEqual(orderBlock, orderBlock3)) {
                return;
            }
            mutableList.remove(orderBlock);
            indexOf = mutableList.indexOf(orderBlock3);
        }
        mutableList.add(indexOf, orderBlock);
        List<OrderBlock> list2 = mutableList;
        collectionSizeOrDefault = kotlin.collections.f.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (OrderBlock orderBlock4 : list2) {
            arrayList.add(orderBlock4.getItems());
        }
        flatten = kotlin.collections.f.flatten(arrayList);
        mutableList2 = CollectionsKt___CollectionsKt.toMutableList((Collection) flatten);
        list = CollectionsKt___CollectionsKt.toList(mutableList2);
        this.f11703w = list;
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) orderBlock.getItems());
        if (!(firstOrNull instanceof ItemType.Trigger)) {
            firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) orderBlock.getItems());
            if (!(firstOrNull2 instanceof ItemType.Action)) {
                firstOrNull3 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) orderBlock.getItems());
                if (firstOrNull3 instanceof ItemType.Constraint) {
                    Macro macro = this.f11682b;
                    ArrayList<ItemType.Constraint> arrayList2 = new ArrayList();
                    for (Object obj : this.f11703w) {
                        if (obj instanceof ItemType.Constraint) {
                            arrayList2.add(obj);
                        }
                    }
                    collectionSizeOrDefault2 = kotlin.collections.f.collectionSizeOrDefault(arrayList2, 10);
                    ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault2);
                    for (ItemType.Constraint constraint : arrayList2) {
                        arrayList3.add(constraint.getConstraint());
                    }
                    macro.setConstraints(new ArrayList(arrayList3));
                }
            } else {
                Macro macro2 = this.f11682b;
                ArrayList<ItemType.Action> arrayList4 = new ArrayList();
                for (Object obj2 : this.f11703w) {
                    if (obj2 instanceof ItemType.Action) {
                        arrayList4.add(obj2);
                    }
                }
                collectionSizeOrDefault3 = kotlin.collections.f.collectionSizeOrDefault(arrayList4, 10);
                ArrayList arrayList5 = new ArrayList(collectionSizeOrDefault3);
                for (ItemType.Action action : arrayList4) {
                    arrayList5.add(action.getAction());
                }
                macro2.setActions(new ArrayList<>(arrayList5));
            }
        } else {
            Macro macro3 = this.f11682b;
            ArrayList<ItemType.Trigger> arrayList6 = new ArrayList();
            for (Object obj3 : this.f11703w) {
                if (obj3 instanceof ItemType.Trigger) {
                    arrayList6.add(obj3);
                }
            }
            collectionSizeOrDefault4 = kotlin.collections.f.collectionSizeOrDefault(arrayList6, 10);
            ArrayList arrayList7 = new ArrayList(collectionSizeOrDefault4);
            for (ItemType.Trigger trigger : arrayList6) {
                arrayList7.add(trigger.getTrigger());
            }
            macro3.setTriggerList(new ArrayList<>(arrayList7));
        }
        refreshShownItems();
        notifyItemRangeChanged(i4, i5);
    }

    public final void refreshShownItems() {
        int collectionSizeOrDefault;
        List mutableList;
        List<? extends ItemType> emptyList;
        int collectionSizeOrDefault2;
        Object lastOrNull;
        Object lastOrNull2;
        Object lastOrNull3;
        ItemType constraint;
        boolean z3;
        List<Action> emptyList2;
        List<ItemType.Action> i4 = i();
        collectionSizeOrDefault = kotlin.collections.f.collectionSizeOrDefault(i4, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (ItemType.Action action : i4) {
            Intrinsics.checkNotNull(action, "null cannot be cast to non-null type com.arlosoft.macrodroid.editscreen.ItemType.Action");
            arrayList.add(action.getAction());
        }
        int i5 = 0;
        while (i5 < arrayList.size()) {
            Action action2 = (Action) arrayList.get(i5);
            if (action2 instanceof ParentAction) {
                ParentAction parentAction = (ParentAction) action2;
                if (!parentAction.getChildrenCollapsed()) {
                    emptyList2 = CollectionsKt__CollectionsKt.emptyList();
                    parentAction.setChildActions(emptyList2);
                } else {
                    ArrayList arrayList2 = new ArrayList();
                    int parentEndIndex = MacroListUtils.getParentEndIndex(arrayList, i5);
                    int i6 = i5 + 1;
                    if (i6 <= parentEndIndex) {
                        while (true) {
                            arrayList2.add(arrayList.get(i6));
                            ((Action) arrayList.get(i6)).setCollapsed(true);
                            if (i6 == parentEndIndex) {
                                break;
                            }
                            i6++;
                        }
                    }
                    parentAction.setChildActions(arrayList2);
                    i5 = parentEndIndex;
                }
                parentAction.setCollapsed(false);
            } else {
                action2.setCollapsed(false);
            }
            i5++;
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : this.f11703w) {
            ItemType itemType = (ItemType) obj;
            if (((itemType instanceof ItemType.Action) && ((ItemType.Action) itemType).getAction().isCollapsed()) || (!this.f11683c && ((itemType instanceof ItemType.LocalVariableHeader) || (itemType instanceof ItemType.LocalVariablesEmpty) || (itemType instanceof ItemType.LocalVariable)))) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (z3) {
                arrayList3.add(obj);
            }
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList3);
        if (!(!mutableList.isEmpty())) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            this.f11704x = emptyList;
            return;
        }
        List<ItemType> list = mutableList;
        collectionSizeOrDefault2 = kotlin.collections.f.collectionSizeOrDefault(list, 10);
        ArrayList arrayList4 = new ArrayList(collectionSizeOrDefault2);
        for (ItemType itemType2 : list) {
            ArrayList arrayList5 = new ArrayList();
            for (Object obj2 : list) {
                if (obj2 instanceof ItemType.Action) {
                    arrayList5.add(obj2);
                }
            }
            lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) arrayList5);
            if (Intrinsics.areEqual(itemType2, lastOrNull)) {
                Intrinsics.checkNotNull(itemType2, "null cannot be cast to non-null type com.arlosoft.macrodroid.editscreen.ItemType.Action");
                constraint = new ItemType.Action(((ItemType.Action) itemType2).getAction(), true);
            } else if (itemType2 instanceof ItemType.Action) {
                constraint = new ItemType.Action(((ItemType.Action) itemType2).getAction(), false);
            } else {
                ArrayList arrayList6 = new ArrayList();
                for (Object obj3 : list) {
                    if (obj3 instanceof ItemType.Trigger) {
                        arrayList6.add(obj3);
                    }
                }
                lastOrNull2 = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) arrayList6);
                if (Intrinsics.areEqual(itemType2, lastOrNull2)) {
                    Intrinsics.checkNotNull(itemType2, "null cannot be cast to non-null type com.arlosoft.macrodroid.editscreen.ItemType.Trigger");
                    constraint = new ItemType.Trigger(((ItemType.Trigger) itemType2).getTrigger(), true);
                } else if (itemType2 instanceof ItemType.Trigger) {
                    constraint = new ItemType.Trigger(((ItemType.Trigger) itemType2).getTrigger(), false);
                } else {
                    ArrayList arrayList7 = new ArrayList();
                    for (Object obj4 : list) {
                        if (obj4 instanceof ItemType.Constraint) {
                            arrayList7.add(obj4);
                        }
                    }
                    lastOrNull3 = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) arrayList7);
                    if (Intrinsics.areEqual(itemType2, lastOrNull3)) {
                        Intrinsics.checkNotNull(itemType2, "null cannot be cast to non-null type com.arlosoft.macrodroid.editscreen.ItemType.Constraint");
                        constraint = new ItemType.Constraint(((ItemType.Constraint) itemType2).getConstraint(), true);
                    } else if (itemType2 instanceof ItemType.Constraint) {
                        constraint = new ItemType.Constraint(((ItemType.Constraint) itemType2).getConstraint(), false);
                    } else {
                        arrayList4.add(itemType2);
                    }
                }
            }
            itemType2 = constraint;
            arrayList4.add(itemType2);
        }
        this.f11704x = arrayList4;
    }

    @NotNull
    public final List<Integer> searchForText(@NotNull String searchText) {
        boolean z3;
        Iterable<IndexedValue> withIndex;
        Intrinsics.checkNotNullParameter(searchText, "searchText");
        ArrayList arrayList = new ArrayList();
        if (searchText.length() == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z3) {
            withIndex = CollectionsKt___CollectionsKt.withIndex(this.f11704x);
            for (IndexedValue indexedValue : withIndex) {
                ItemType itemType = (ItemType) indexedValue.getValue();
                if ((itemType instanceof HasSelectableItem) && ((HasSelectableItem) itemType).getSelectableItem().matchesSearchText(searchText)) {
                    arrayList.add(Integer.valueOf(indexedValue.getIndex()));
                }
            }
            return arrayList;
        }
        return arrayList;
    }

    public final void setActionDragEnabled(boolean z3) {
        this.f11698r = z3;
        notifyDataSetChanged();
    }

    public final void setConstraintDragEnabled(boolean z3) {
        this.f11699s = z3;
        notifyDataSetChanged();
    }

    public final void setMacro(@NotNull Macro macro) {
        Intrinsics.checkNotNullParameter(macro, "macro");
        ArrayList<Trigger> triggerList = macro.getTriggerList();
        Intrinsics.checkNotNullExpressionValue(triggerList, "macro.triggerList");
        ArrayList<Action> actions = macro.getActions();
        Intrinsics.checkNotNullExpressionValue(actions, "macro.actions");
        List<Constraint> constraints = macro.getConstraints();
        Intrinsics.checkNotNullExpressionValue(constraints, "macro.constraints");
        List<MacroDroidVariable> localVariablesSorted = macro.getLocalVariablesSorted();
        Intrinsics.checkNotNullExpressionValue(localVariablesSorted, "macro.localVariablesSorted");
        o(triggerList, actions, constraints, localVariablesSorted);
        refreshShownItems();
        notifyDataSetChanged();
    }

    public final void setPasteButtonVisibility(@NotNull PasteButtonVisibilty pasteButtonVisibilty) {
        Intrinsics.checkNotNullParameter(pasteButtonVisibilty, "pasteButtonVisibilty");
        this.f11706z = pasteButtonVisibilty;
        notifyDataSetChanged();
    }

    public final void setShowVariables(boolean z3) {
        if (this.f11683c != z3) {
            this.f11683c = z3;
            refreshShownItems();
            notifyDataSetChanged();
        }
    }

    public final void setTriggerDragEnabled(boolean z3) {
        this.f11697q = z3;
        notifyDataSetChanged();
    }

    public final void updateLocalVariables(@NotNull Macro macro) {
        Intrinsics.checkNotNullParameter(macro, "macro");
        ArrayList<Trigger> triggerList = macro.getTriggerList();
        Intrinsics.checkNotNullExpressionValue(triggerList, "macro.triggerList");
        ArrayList<Action> actions = macro.getActions();
        Intrinsics.checkNotNullExpressionValue(actions, "macro.actions");
        List<Constraint> constraints = macro.getConstraints();
        Intrinsics.checkNotNullExpressionValue(constraints, "macro.constraints");
        List<MacroDroidVariable> localVariablesSorted = macro.getLocalVariablesSorted();
        Intrinsics.checkNotNullExpressionValue(localVariablesSorted, "macro.localVariablesSorted");
        o(triggerList, actions, constraints, localVariablesSorted);
        refreshShownItems();
        notifyDataSetChanged();
    }
}
