package com.h6ah4i.android.widget.advrecyclerview.composedadapter;

import android.view.ViewGroup;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.h6ah4i.android.widget.advrecyclerview.adapter.AdapterPathSegment;
import com.h6ah4i.android.widget.advrecyclerview.adapter.BridgeAdapterDataObserver;
import com.h6ah4i.android.widget.advrecyclerview.adapter.ItemIdComposer;
import com.h6ah4i.android.widget.advrecyclerview.adapter.ItemViewTypeComposer;
import com.h6ah4i.android.widget.advrecyclerview.adapter.UnwrapPositionResult;
import com.h6ah4i.android.widget.advrecyclerview.adapter.WrapperAdapter;
import com.h6ah4i.android.widget.advrecyclerview.utils.WrappedAdapterUtils;
import java.util.List;

/* loaded from: classes6.dex */
public class ComposedAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements WrapperAdapter<RecyclerView.ViewHolder>, BridgeAdapterDataObserver.Subscriber {
    public static long NO_SEGMENTED_POSITION = a.f33706f;

    /* renamed from: a  reason: collision with root package name */
    private a f33703a;

    /* renamed from: b  reason: collision with root package name */
    private c f33704b;

    /* renamed from: c  reason: collision with root package name */
    private d f33705c;

    public ComposedAdapter() {
        a aVar = new a(this);
        this.f33703a = aVar;
        this.f33704b = new c(aVar);
        this.f33705c = new d();
        setHasStableIds(true);
    }

    public static int extractSegmentOffsetPart(long j4) {
        return a.d(j4);
    }

    public static int extractSegmentPart(long j4) {
        return a.c(j4);
    }

    protected void a(@NonNull RecyclerView.Adapter adapter, @NonNull List<ComposedChildAdapterTag> list) {
        this.f33704b.g();
        notifyDataSetChanged();
    }

    @NonNull
    public ComposedChildAdapterTag addAdapter(@NonNull RecyclerView.Adapter adapter) {
        return addAdapter(adapter, getChildAdapterCount());
    }

    protected void b(@NonNull RecyclerView.Adapter adapter, @NonNull List<ComposedChildAdapterTag> list, int i4, int i5) {
        int size = list.size();
        for (int i6 = 0; i6 < size; i6++) {
            notifyItemRangeChanged(this.f33704b.b(this.f33703a.f(list.get(i6)), i4), i5);
        }
    }

    protected void c(@NonNull RecyclerView.Adapter adapter, @NonNull List<ComposedChildAdapterTag> list, int i4, int i5, Object obj) {
        int size = list.size();
        for (int i6 = 0; i6 < size; i6++) {
            notifyItemRangeChanged(this.f33704b.b(this.f33703a.f(list.get(i6)), i4), i5, obj);
        }
    }

    protected void d(@NonNull RecyclerView.Adapter adapter, @NonNull List<ComposedChildAdapterTag> list, int i4, int i5) {
        if (i5 <= 0) {
            return;
        }
        int size = list.size();
        if (size == 1) {
            int f4 = this.f33703a.f(list.get(0));
            this.f33704b.h(f4);
            notifyItemRangeInserted(this.f33704b.b(f4, i4), i5);
            return;
        }
        for (int i6 = 0; i6 < size; i6++) {
            this.f33704b.h(this.f33703a.f(list.get(i6)));
        }
        notifyDataSetChanged();
    }

    protected void e(@NonNull RecyclerView.Adapter adapter, @NonNull List<ComposedChildAdapterTag> list, int i4, int i5) {
        if (i5 <= 0) {
            return;
        }
        int size = list.size();
        if (size == 1) {
            int f4 = this.f33703a.f(list.get(0));
            this.f33704b.h(f4);
            notifyItemRangeRemoved(this.f33704b.b(f4, i4), i5);
            return;
        }
        for (int i6 = 0; i6 < size; i6++) {
            this.f33704b.h(this.f33703a.f(list.get(i6)));
        }
        notifyDataSetChanged();
    }

    protected void f(@NonNull RecyclerView.Adapter adapter, @NonNull List<ComposedChildAdapterTag> list, int i4, int i5, int i6) {
        if (i6 == 1) {
            if (list.size() == 1) {
                int f4 = this.f33703a.f(list.get(0));
                notifyItemMoved(this.f33704b.b(f4, i4), this.f33704b.b(f4, i5));
                return;
            }
            notifyDataSetChanged();
            return;
        }
        throw new IllegalStateException("itemCount should be always 1  (actual: " + i6 + ")");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @CallSuper
    public void g() {
        a aVar = this.f33703a;
        if (aVar != null) {
            aVar.j();
            this.f33703a = null;
        }
        c cVar = this.f33704b;
        if (cVar != null) {
            cVar.i();
            this.f33704b = null;
        }
        this.f33705c = null;
    }

    public int getChildAdapterCount() {
        return this.f33703a.g();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f33704b.f();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i4) {
        long segmentedPosition = getSegmentedPosition(i4);
        int c4 = a.c(segmentedPosition);
        int d4 = a.d(segmentedPosition);
        RecyclerView.Adapter e4 = this.f33703a.e(c4);
        int itemViewType = e4.getItemViewType(d4);
        return ItemIdComposer.composeSegment(ItemViewTypeComposer.extractSegmentPart(this.f33705c.d(c4, itemViewType)), e4.getItemId(d4));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i4) {
        long segmentedPosition = getSegmentedPosition(i4);
        int c4 = a.c(segmentedPosition);
        return this.f33705c.d(c4, this.f33703a.e(c4).getItemViewType(a.d(segmentedPosition)));
    }

    public int getSegment(@NonNull ComposedChildAdapterTag composedChildAdapterTag) {
        return this.f33703a.f(composedChildAdapterTag);
    }

    public long getSegmentedPosition(int i4) {
        return this.f33704b.e(i4);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.WrapperAdapter
    public void getWrappedAdapters(@NonNull List<RecyclerView.Adapter> list) {
        a aVar = this.f33703a;
        if (aVar != null) {
            list.addAll(aVar.i());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        List<RecyclerView.Adapter> i4 = this.f33703a.i();
        for (int i5 = 0; i5 < i4.size(); i5++) {
            i4.get(i5).onAttachedToRecyclerView(recyclerView);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i4) {
        long segmentedPosition = getSegmentedPosition(i4);
        int c4 = a.c(segmentedPosition);
        this.f33703a.e(c4).onBindViewHolder(viewHolder, a.d(segmentedPosition));
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.BridgeAdapterDataObserver.Subscriber
    public void onBridgedAdapterChanged(@NonNull RecyclerView.Adapter adapter, @Nullable Object obj) {
        a(adapter, (List) obj);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.BridgeAdapterDataObserver.Subscriber
    public void onBridgedAdapterItemRangeChanged(@NonNull RecyclerView.Adapter adapter, @Nullable Object obj, int i4, int i5) {
        b(adapter, (List) obj, i4, i5);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.BridgeAdapterDataObserver.Subscriber
    public void onBridgedAdapterItemRangeInserted(@NonNull RecyclerView.Adapter adapter, @Nullable Object obj, int i4, int i5) {
        d(adapter, (List) obj, i4, i5);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.BridgeAdapterDataObserver.Subscriber
    public void onBridgedAdapterItemRangeRemoved(@NonNull RecyclerView.Adapter adapter, @Nullable Object obj, int i4, int i5) {
        e(adapter, (List) obj, i4, i5);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.BridgeAdapterDataObserver.Subscriber
    public void onBridgedAdapterRangeMoved(@NonNull RecyclerView.Adapter adapter, @Nullable Object obj, int i4, int i5, int i6) {
        f(adapter, (List) obj, i4, i5, i6);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i4) {
        long c4 = this.f33705c.c(i4);
        int b4 = d.b(c4);
        return this.f33703a.e(b4).onCreateViewHolder(viewGroup, d.a(c4));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        List<RecyclerView.Adapter> i4 = this.f33703a.i();
        for (int i5 = 0; i5 < i4.size(); i5++) {
            i4.get(i5).onDetachedFromRecyclerView(recyclerView);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public boolean onFailedToRecycleView(@NonNull RecyclerView.ViewHolder viewHolder) {
        return onFailedToRecycleView(viewHolder, viewHolder.getItemViewType());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(@NonNull RecyclerView.ViewHolder viewHolder) {
        onViewAttachedToWindow(viewHolder, viewHolder.getItemViewType());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(@NonNull RecyclerView.ViewHolder viewHolder) {
        onViewDetachedFromWindow(viewHolder, viewHolder.getItemViewType());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(@NonNull RecyclerView.ViewHolder viewHolder) {
        onViewRecycled(viewHolder, viewHolder.getItemViewType());
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.WrapperAdapter
    public void release() {
        g();
    }

    public boolean removeAdapter(@NonNull ComposedChildAdapterTag composedChildAdapterTag) {
        int f4 = this.f33703a.f(composedChildAdapterTag);
        if (f4 < 0) {
            return false;
        }
        this.f33703a.k(composedChildAdapterTag);
        this.f33704b.h(f4);
        notifyDataSetChanged();
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void setHasStableIds(boolean z3) {
        if (z3 && !hasStableIds()) {
            int g4 = this.f33703a.g();
            for (int i4 = 0; i4 < g4; i4++) {
                if (!this.f33703a.e(i4).hasStableIds()) {
                    throw new IllegalStateException("All child adapters must support stable IDs");
                }
            }
        }
        super.setHasStableIds(z3);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.WrapperAdapter
    public void unwrapPosition(@NonNull UnwrapPositionResult unwrapPositionResult, int i4) {
        long e4 = this.f33704b.e(i4);
        if (e4 != a.f33706f) {
            int c4 = a.c(e4);
            int d4 = a.d(e4);
            unwrapPositionResult.adapter = this.f33703a.e(c4);
            unwrapPositionResult.position = d4;
            unwrapPositionResult.tag = this.f33703a.h(c4);
        }
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.WrapperAdapter
    public int wrapPosition(@NonNull AdapterPathSegment adapterPathSegment, int i4) {
        Object obj = adapterPathSegment.tag;
        if (obj != null) {
            return this.f33704b.b(this.f33703a.f((ComposedChildAdapterTag) obj), i4);
        }
        return -1;
    }

    @NonNull
    public ComposedChildAdapterTag addAdapter(@NonNull RecyclerView.Adapter adapter, int i4) {
        if (hasObservers() && hasStableIds() && !adapter.hasStableIds()) {
            throw new IllegalStateException("Wrapped child adapter must has stable IDs");
        }
        ComposedChildAdapterTag a4 = this.f33703a.a(adapter, i4);
        this.f33704b.h(this.f33703a.f(a4));
        notifyDataSetChanged();
        return a4;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.BridgeAdapterDataObserver.Subscriber
    public void onBridgedAdapterItemRangeChanged(@NonNull RecyclerView.Adapter adapter, @Nullable Object obj, int i4, int i5, Object obj2) {
        c(adapter, (List) obj, i4, i5, obj2);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.WrappedAdapter
    public boolean onFailedToRecycleView(@NonNull RecyclerView.ViewHolder viewHolder, int i4) {
        long c4 = this.f33705c.c(i4);
        int b4 = d.b(c4);
        return WrappedAdapterUtils.invokeOnFailedToRecycleView(this.f33703a.e(b4), viewHolder, d.a(c4));
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.WrappedAdapter
    public void onViewAttachedToWindow(@NonNull RecyclerView.ViewHolder viewHolder, int i4) {
        long c4 = this.f33705c.c(i4);
        int b4 = d.b(c4);
        WrappedAdapterUtils.invokeOnViewAttachedToWindow(this.f33703a.e(b4), viewHolder, d.a(c4));
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.WrappedAdapter
    public void onViewDetachedFromWindow(@NonNull RecyclerView.ViewHolder viewHolder, int i4) {
        long c4 = this.f33705c.c(i4);
        int b4 = d.b(c4);
        WrappedAdapterUtils.invokeOnViewDetachedFromWindow(this.f33703a.e(b4), viewHolder, d.a(c4));
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.WrappedAdapter
    public void onViewRecycled(@NonNull RecyclerView.ViewHolder viewHolder, int i4) {
        long c4 = this.f33705c.c(i4);
        int b4 = d.b(c4);
        WrappedAdapterUtils.invokeOnViewRecycled(this.f33703a.e(b4), viewHolder, d.a(c4));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i4, @NonNull List<Object> list) {
        long segmentedPosition = getSegmentedPosition(i4);
        int c4 = a.c(segmentedPosition);
        this.f33703a.e(c4).onBindViewHolder(viewHolder, a.d(segmentedPosition), list);
    }
}
