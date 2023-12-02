package com.arlosoft.macrodroid.editscreen;

import android.app.Activity;
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
import com.arlosoft.macrodroid.action.ParentAction;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.macro.Macro;
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
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SelectableItemsListAdapter.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nSelectableItemsListAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SelectableItemsListAdapter.kt\ncom/arlosoft/macrodroid/editscreen/SelectableItemsListAdapter\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,266:1\n288#2,2:267\n288#2,2:269\n288#2,2:271\n1549#2:273\n1620#2,3:274\n*S KotlinDebug\n*F\n+ 1 SelectableItemsListAdapter.kt\ncom/arlosoft/macrodroid/editscreen/SelectableItemsListAdapter\n*L\n194#1:267,2\n198#1:269,2\n208#1:271,2\n221#1:273\n221#1:274,3\n*E\n"})
/* loaded from: classes3.dex */
public final class SelectableItemsListAdapter<T extends SelectableItem> extends RecyclerView.Adapter<SelectableItemsViewHolder> implements DraggableItemAdapter<SelectableItemsViewHolder> {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Activity f11827a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final Macro f11828b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private List<T> f11829c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final Function1<SelectableItem, Unit> f11830d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final Function1<SelectableItem, Unit> f11831e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private final Function1<SelectableItem, Unit> f11832f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f11833g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f11834h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private final Function1<List<? extends SelectableItem>, Unit> f11835i;
    @NotNull

    /* renamed from: j  reason: collision with root package name */
    private final BehaviorSubject<Boolean> f11836j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f11837k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f11838l;
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    private Range<Integer> f11839m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f11840n;

    /* renamed from: o  reason: collision with root package name */
    private int f11841o;

    /* compiled from: SelectableItemsListAdapter.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class OrderBlock<T extends SelectableItem> {
        public static final int $stable = 8;

        /* renamed from: a  reason: collision with root package name */
        private final int f11842a;

        /* renamed from: b  reason: collision with root package name */
        private final int f11843b;
        @NotNull

        /* renamed from: c  reason: collision with root package name */
        private final List<T> f11844c;

        /* JADX WARN: Multi-variable type inference failed */
        public OrderBlock(int i4, int i5, @NotNull List<? extends T> items) {
            Intrinsics.checkNotNullParameter(items, "items");
            this.f11842a = i4;
            this.f11843b = i5;
            this.f11844c = items;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ OrderBlock copy$default(OrderBlock orderBlock, int i4, int i5, List list, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                i4 = orderBlock.f11842a;
            }
            if ((i6 & 2) != 0) {
                i5 = orderBlock.f11843b;
            }
            if ((i6 & 4) != 0) {
                list = orderBlock.f11844c;
            }
            return orderBlock.copy(i4, i5, list);
        }

        public final int component1() {
            return this.f11842a;
        }

        public final int component2() {
            return this.f11843b;
        }

        @NotNull
        public final List<T> component3() {
            return this.f11844c;
        }

        @NotNull
        public final OrderBlock<T> copy(int i4, int i5, @NotNull List<? extends T> items) {
            Intrinsics.checkNotNullParameter(items, "items");
            return new OrderBlock<>(i4, i5, items);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OrderBlock)) {
                return false;
            }
            OrderBlock orderBlock = (OrderBlock) obj;
            if (this.f11842a == orderBlock.f11842a && this.f11843b == orderBlock.f11843b && Intrinsics.areEqual(this.f11844c, orderBlock.f11844c)) {
                return true;
            }
            return false;
        }

        public final int getEndPosition() {
            return this.f11843b;
        }

        @NotNull
        public final List<T> getItems() {
            return this.f11844c;
        }

        public final int getStartPosition() {
            return this.f11842a;
        }

        public int hashCode() {
            return (((this.f11842a * 31) + this.f11843b) * 31) + this.f11844c.hashCode();
        }

        public final boolean isAtPosition(int i4) {
            if (i4 >= this.f11842a && i4 <= this.f11843b) {
                return true;
            }
            return false;
        }

        public final int size() {
            return (this.f11843b - this.f11842a) + 1;
        }

        @NotNull
        public String toString() {
            int i4 = this.f11842a;
            int i5 = this.f11843b;
            List<T> list = this.f11844c;
            return "OrderBlock(startPosition=" + i4 + ", endPosition=" + i5 + ", items=" + list + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SelectableItemsListAdapter.kt */
    /* loaded from: classes3.dex */
    public static final class a extends Lambda implements Function1<Boolean, Unit> {
        final /* synthetic */ SelectableItemsListAdapter<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(SelectableItemsListAdapter<T> selectableItemsListAdapter) {
            super(1);
            this.this$0 = selectableItemsListAdapter;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke2(bool);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(Boolean bool) {
            ((SelectableItemsListAdapter) this.this$0).f11836j.onNext(bool);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SelectableItemsListAdapter.kt */
    /* loaded from: classes3.dex */
    public static final class b extends Lambda implements Function1<Throwable, Unit> {
        final /* synthetic */ SelectableItemsListAdapter<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(SelectableItemsListAdapter<T> selectableItemsListAdapter) {
            super(1);
            this.this$0 = selectableItemsListAdapter;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke2(th);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th) {
            ((SelectableItemsListAdapter) this.this$0).f11836j.onNext(Boolean.FALSE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SelectableItemsListAdapter.kt */
    /* loaded from: classes3.dex */
    public static final class c extends Lambda implements Function1<SelectableItem, Unit> {
        final /* synthetic */ SelectableItemsListAdapter<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(SelectableItemsListAdapter<T> selectableItemsListAdapter) {
            super(1);
            this.this$0 = selectableItemsListAdapter;
        }

        public final void a(@NotNull SelectableItem it) {
            Intrinsics.checkNotNullParameter(it, "it");
            this.this$0.notifyDataSetChanged();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SelectableItem selectableItem) {
            a(selectableItem);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SelectableItemsListAdapter(@NotNull Activity context, @NotNull Macro macro, @NotNull List<T> items, @NotNull Function1<? super SelectableItem, Unit> itemListener, @NotNull Function1<? super SelectableItem, Unit> itemLongClickListener, @NotNull Function1<? super SelectableItem, Unit> itemCollapseExpandListener, boolean z3, boolean z4, @Nullable Function1<? super List<? extends SelectableItem>, Unit> function1) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(macro, "macro");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(itemListener, "itemListener");
        Intrinsics.checkNotNullParameter(itemLongClickListener, "itemLongClickListener");
        Intrinsics.checkNotNullParameter(itemCollapseExpandListener, "itemCollapseExpandListener");
        this.f11827a = context;
        this.f11828b = macro;
        this.f11829c = items;
        this.f11830d = itemListener;
        this.f11831e = itemLongClickListener;
        this.f11832f = itemCollapseExpandListener;
        this.f11833g = z3;
        this.f11834h = z4;
        this.f11835i = function1;
        BehaviorSubject<Boolean> create = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create, "create<Boolean>()");
        this.f11836j = create;
        e();
        setHasStableIds(true);
        l();
        this.f11841o = Integer.MAX_VALUE;
    }

    private final void e() {
        Single observeOn = Single.defer(new Callable() { // from class: com.arlosoft.macrodroid.editscreen.w0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                SingleSource f4;
                f4 = SelectableItemsListAdapter.f();
                return f4;
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final a aVar = new a(this);
        Consumer consumer = new Consumer() { // from class: com.arlosoft.macrodroid.editscreen.x0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SelectableItemsListAdapter.g(Function1.this, obj);
            }
        };
        final b bVar = new b(this);
        observeOn.subscribe(consumer, new Consumer() { // from class: com.arlosoft.macrodroid.editscreen.y0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SelectableItemsListAdapter.h(Function1.this, obj);
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

    private final int i() {
        if (this.f11833g) {
            return R.layout.macro_edit_entry_small_legacy;
        }
        return R.layout.macro_edit_entry_legacy;
    }

    private final List<OrderBlock<T>> j() {
        List listOf;
        ArrayList arrayList = new ArrayList();
        int i4 = 0;
        while (i4 < this.f11829c.size()) {
            T t3 = this.f11829c.get(i4);
            if (!(t3 instanceof ParentAction) || !((ParentAction) t3).getChildrenCollapsed()) {
                listOf = kotlin.collections.e.listOf(t3);
                arrayList.add(new OrderBlock(i4, i4, listOf));
            } else {
                List<T> list = this.f11829c;
                Intrinsics.checkNotNull(list, "null cannot be cast to non-null type kotlin.collections.MutableList<com.arlosoft.macrodroid.action.Action>");
                int parentEndIndex = MacroListUtils.getParentEndIndex(TypeIntrinsics.asMutableList(list), i4);
                arrayList.add(new OrderBlock(i4, parentEndIndex, this.f11829c.subList(i4, parentEndIndex + 1)));
                i4 = parentEndIndex;
            }
            i4++;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(SelectableItemsListAdapter this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.notifyDataSetChanged();
    }

    private final void l() {
        int i4 = 0;
        while (i4 < this.f11829c.size()) {
            T t3 = this.f11829c.get(i4);
            if (t3 instanceof ParentAction) {
                ParentAction parentAction = (ParentAction) t3;
                if (parentAction.getChildrenCollapsed()) {
                    List<T> list = this.f11829c;
                    Intrinsics.checkNotNull(list, "null cannot be cast to non-null type kotlin.collections.List<com.arlosoft.macrodroid.action.Action>");
                    int parentEndIndex = MacroListUtils.getParentEndIndex(list, i4);
                    int i5 = i4 + 1;
                    if (i5 <= parentEndIndex) {
                        while (true) {
                            this.f11829c.get(i5).setCollapsed(true);
                            if (i5 == parentEndIndex) {
                                break;
                            }
                            i5++;
                        }
                    }
                    i4 = parentEndIndex;
                }
                parentAction.setCollapsed(false);
            } else {
                t3.setCollapsed(false);
            }
            i4++;
        }
    }

    @Nullable
    public final Range<Integer> getHighlightRange() {
        return this.f11839m;
    }

    public final boolean getInvalidExtraction() {
        return this.f11840n;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f11829c.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i4) {
        return this.f11829c.get(i4).getSIGUID();
    }

    public final boolean isDragEnabled() {
        return this.f11837k;
    }

    public final int moveBottomHighlght(boolean z3) {
        int i4;
        int coerceAtMost;
        int coerceAtLeast;
        int coerceAtMost2;
        Range<Integer> range = this.f11839m;
        if (range == null) {
            return 0;
        }
        if (z3) {
            i4 = -1;
        } else {
            i4 = 1;
        }
        coerceAtMost = kotlin.ranges.h.coerceAtMost(range.getUpper().intValue() + i4, getItemCount() - 1);
        coerceAtLeast = kotlin.ranges.h.coerceAtLeast(coerceAtMost, 0);
        Integer lower = range.getLower();
        Intrinsics.checkNotNullExpressionValue(lower, "it.lower");
        coerceAtMost2 = kotlin.ranges.h.coerceAtMost(lower.intValue(), coerceAtLeast);
        this.f11839m = new Range<>(Integer.valueOf(coerceAtMost2), Integer.valueOf(coerceAtLeast));
        notifyDataSetChanged();
        return coerceAtLeast;
    }

    public final int moveTopHighlight(boolean z3) {
        int i4;
        int coerceAtLeast;
        int coerceAtMost;
        int coerceAtLeast2;
        Range<Integer> range = this.f11839m;
        if (range == null) {
            return 0;
        }
        if (z3) {
            i4 = -1;
        } else {
            i4 = 1;
        }
        coerceAtLeast = kotlin.ranges.h.coerceAtLeast(range.getLower().intValue() + i4, 0);
        coerceAtMost = kotlin.ranges.h.coerceAtMost(coerceAtLeast, getItemCount() - 1);
        Integer valueOf = Integer.valueOf(coerceAtMost);
        Integer upper = range.getUpper();
        Intrinsics.checkNotNullExpressionValue(upper, "it.upper");
        coerceAtLeast2 = kotlin.ranges.h.coerceAtLeast(upper.intValue(), coerceAtMost);
        this.f11839m = new Range<>(valueOf, Integer.valueOf(coerceAtLeast2));
        notifyDataSetChanged();
        return coerceAtMost;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.draggable.DraggableItemAdapter
    public boolean onCheckCanDrop(int i4, int i5) {
        return true;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.draggable.DraggableItemAdapter
    @Nullable
    public ItemDraggableRange onGetItemDraggableRange(@NotNull SelectableItemsViewHolder holder, int i4) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        return null;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.draggable.DraggableItemAdapter
    public void onItemDragFinished(int i4, int i5, boolean z3) {
        Function1<List<? extends SelectableItem>, Unit> function1;
        this.f11838l = false;
        if (i4 != i5 && (function1 = this.f11835i) != null) {
            function1.invoke(this.f11829c);
        }
        notifyDataSetChanged();
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.arlosoft.macrodroid.editscreen.v0
            @Override // java.lang.Runnable
            public final void run() {
                SelectableItemsListAdapter.k(SelectableItemsListAdapter.this);
            }
        }, 250L);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.draggable.DraggableItemAdapter
    public void onMoveItem(int i4, int i5) {
        List mutableList;
        OrderBlock orderBlock;
        Object obj;
        int indexOf;
        boolean z3;
        int collectionSizeOrDefault;
        List flatten;
        boolean z4;
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) j());
        List list = mutableList;
        Iterator it = list.iterator();
        while (true) {
            orderBlock = null;
            if (it.hasNext()) {
                obj = it.next();
                if (((OrderBlock) obj).isAtPosition(i4)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        OrderBlock orderBlock2 = (OrderBlock) obj;
        if (orderBlock2 == null) {
            return;
        }
        if (i5 > i4) {
            Iterator it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next = it2.next();
                if (((OrderBlock) next).getEndPosition() >= i5) {
                    z4 = true;
                    continue;
                } else {
                    z4 = false;
                    continue;
                }
                if (z4) {
                    orderBlock = next;
                    break;
                }
            }
            OrderBlock orderBlock3 = (OrderBlock) orderBlock;
            if (orderBlock3 == null || Intrinsics.areEqual(orderBlock2, orderBlock3)) {
                return;
            }
            mutableList.remove(orderBlock2);
            indexOf = mutableList.indexOf(orderBlock3) + 1;
        } else {
            Iterator it3 = list.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    break;
                }
                Object next2 = it3.next();
                if (((OrderBlock) next2).getStartPosition() >= i5) {
                    z3 = true;
                    continue;
                } else {
                    z3 = false;
                    continue;
                }
                if (z3) {
                    orderBlock = next2;
                    break;
                }
            }
            OrderBlock orderBlock4 = orderBlock;
            if (orderBlock4 == null || Intrinsics.areEqual(orderBlock2, orderBlock4)) {
                return;
            }
            mutableList.remove(orderBlock2);
            indexOf = mutableList.indexOf(orderBlock4);
        }
        mutableList.add(indexOf, orderBlock2);
        List<OrderBlock> list2 = mutableList;
        collectionSizeOrDefault = kotlin.collections.f.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (OrderBlock orderBlock5 : list2) {
            arrayList.add(orderBlock5.getItems());
        }
        flatten = kotlin.collections.f.flatten(arrayList);
        this.f11829c.clear();
        this.f11829c.addAll(flatten);
    }

    public final void setDragEnabled(boolean z3) {
        this.f11837k = z3;
        notifyDataSetChanged();
    }

    public final void setHighlightRange(int i4, int i5) {
        this.f11839m = new Range<>(Integer.valueOf(i4), Integer.valueOf(i5));
    }

    public final void setInvalidExtraction(boolean z3) {
        this.f11840n = z3;
        notifyDataSetChanged();
    }

    public final void setItems(@NotNull List<T> items) {
        Intrinsics.checkNotNullParameter(items, "items");
        this.f11829c = items;
        l();
        notifyDataSetChanged();
    }

    public final void setShowGrabHandle(boolean z3) {
        this.f11837k = z3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull SelectableItemsViewHolder holder, int i4) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (this.f11838l) {
            return;
        }
        Range<Integer> range = this.f11839m;
        boolean contains = range != null ? range.contains((Range<Integer>) Integer.valueOf(i4)) : false;
        Range<Integer> range2 = this.f11839m;
        Integer lower = range2 != null ? range2.getLower() : null;
        if (lower == null) {
            lower = Boolean.FALSE;
        }
        boolean areEqual = Intrinsics.areEqual(lower, Integer.valueOf(i4));
        Range<Integer> range3 = this.f11839m;
        Integer upper = range3 != null ? range3.getUpper() : null;
        if (upper == null) {
            upper = Boolean.FALSE;
        }
        boolean areEqual2 = Intrinsics.areEqual(upper, Integer.valueOf(i4));
        T t3 = this.f11829c.get(i4);
        List<T> list = this.f11829c;
        boolean z3 = this.f11833g;
        boolean z4 = this.f11837k;
        boolean z5 = this.f11834h;
        boolean z6 = this.f11840n;
        Range<Integer> range4 = this.f11839m;
        holder.bind(t3, list, i4, z3, z4, z5, contains, areEqual, areEqual2, z6, range4 == null, range4 != null);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.draggable.DraggableItemAdapter
    public boolean onCheckCanStartDrag(@NotNull SelectableItemsViewHolder holder, int i4, int i5, int i6) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (isDragEnabled()) {
            Rect rect = new Rect();
            holder.getDragHandle$app_standardRelease().getDrawingRect(rect);
            holder.getTopLevelContainer$app_standardRelease().offsetDescendantRectToMyCoords(holder.getDragHandle$app_standardRelease(), rect);
            boolean contains = rect.contains(i5, i6);
            this.f11838l = contains;
            return contains;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public SelectableItemsViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i4) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View v3 = LayoutInflater.from(parent.getContext()).inflate(i(), parent, false);
        Activity activity = this.f11827a;
        Macro macro = this.f11828b;
        Intrinsics.checkNotNullExpressionValue(v3, "v");
        return new SelectableItemsViewHolder(activity, macro, v3, this.f11830d, this.f11831e, this.f11832f, this.f11836j, new c(this));
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.draggable.DraggableItemAdapter
    public void onItemDragStarted(int i4) {
    }
}
