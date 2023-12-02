package com.h6ah4i.android.widget.advrecyclerview.adapter;

import android.view.ViewGroup;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.h6ah4i.android.widget.advrecyclerview.adapter.BridgeAdapterDataObserver;
import com.h6ah4i.android.widget.advrecyclerview.utils.WrappedAdapterUtils;
import java.util.Collections;
import java.util.List;

/* loaded from: classes6.dex */
public class SimpleWrapperAdapter<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> implements WrapperAdapter<VH>, BridgeAdapterDataObserver.Subscriber {

    /* renamed from: c  reason: collision with root package name */
    protected static final List<Object> f33682c = Collections.emptyList();

    /* renamed from: a  reason: collision with root package name */
    private RecyclerView.Adapter<VH> f33683a;

    /* renamed from: b  reason: collision with root package name */
    private BridgeAdapterDataObserver f33684b;

    public SimpleWrapperAdapter(@NonNull RecyclerView.Adapter<VH> adapter) {
        this.f33683a = adapter;
        BridgeAdapterDataObserver bridgeAdapterDataObserver = new BridgeAdapterDataObserver(this, adapter, null);
        this.f33684b = bridgeAdapterDataObserver;
        this.f33683a.registerAdapterDataObserver(bridgeAdapterDataObserver);
        super.setHasStableIds(this.f33683a.hasStableIds());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a() {
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(int i4, int i5) {
        notifyItemRangeChanged(i4, i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(int i4, int i5, Object obj) {
        notifyItemRangeChanged(i4, i5, obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(int i4, int i5) {
        notifyItemRangeInserted(i4, i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(int i4, int i5) {
        notifyItemRangeRemoved(i4, i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(int i4, int i5, int i6) {
        if (i6 == 1) {
            notifyItemMoved(i4, i5);
            return;
        }
        throw new IllegalStateException("itemCount should be always 1  (actual: " + i6 + ")");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (isWrappedAdapterAlive()) {
            return this.f33683a.getItemCount();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i4) {
        return this.f33683a.getItemId(i4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i4) {
        return this.f33683a.getItemViewType(i4);
    }

    @Nullable
    public RecyclerView.Adapter<VH> getWrappedAdapter() {
        return this.f33683a;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.WrapperAdapter
    public void getWrappedAdapters(@NonNull List<RecyclerView.Adapter> list) {
        RecyclerView.Adapter<VH> adapter = this.f33683a;
        if (adapter != null) {
            list.add(adapter);
        }
    }

    public boolean isWrappedAdapterAlive() {
        if (this.f33683a != null) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        if (isWrappedAdapterAlive()) {
            this.f33683a.onAttachedToRecyclerView(recyclerView);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull VH vh, int i4) {
        onBindViewHolder(vh, i4, f33682c);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.BridgeAdapterDataObserver.Subscriber
    public final void onBridgedAdapterChanged(@NonNull RecyclerView.Adapter adapter, @Nullable Object obj) {
        a();
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.BridgeAdapterDataObserver.Subscriber
    public final void onBridgedAdapterItemRangeChanged(@NonNull RecyclerView.Adapter adapter, @Nullable Object obj, int i4, int i5) {
        b(i4, i5);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.BridgeAdapterDataObserver.Subscriber
    public final void onBridgedAdapterItemRangeInserted(@NonNull RecyclerView.Adapter adapter, @Nullable Object obj, int i4, int i5) {
        d(i4, i5);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.BridgeAdapterDataObserver.Subscriber
    public final void onBridgedAdapterItemRangeRemoved(@NonNull RecyclerView.Adapter adapter, @Nullable Object obj, int i4, int i5) {
        e(i4, i5);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.BridgeAdapterDataObserver.Subscriber
    public final void onBridgedAdapterRangeMoved(@NonNull RecyclerView.Adapter adapter, @Nullable Object obj, int i4, int i5, int i6) {
        f(i4, i5, i6);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i4) {
        return this.f33683a.onCreateViewHolder(viewGroup, i4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        if (isWrappedAdapterAlive()) {
            this.f33683a.onDetachedFromRecyclerView(recyclerView);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public boolean onFailedToRecycleView(@NonNull VH vh) {
        return onFailedToRecycleView(vh, vh.getItemViewType());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(@NonNull VH vh) {
        onViewAttachedToWindow(vh, vh.getItemViewType());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(@NonNull VH vh) {
        onViewDetachedFromWindow(vh, vh.getItemViewType());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(@NonNull VH vh) {
        onViewRecycled(vh, vh.getItemViewType());
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.WrapperAdapter
    public void release() {
        BridgeAdapterDataObserver bridgeAdapterDataObserver;
        g();
        RecyclerView.Adapter<VH> adapter = this.f33683a;
        if (adapter != null && (bridgeAdapterDataObserver = this.f33684b) != null) {
            adapter.unregisterAdapterDataObserver(bridgeAdapterDataObserver);
        }
        this.f33683a = null;
        this.f33684b = null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void setHasStableIds(boolean z3) {
        super.setHasStableIds(z3);
        if (isWrappedAdapterAlive()) {
            this.f33683a.setHasStableIds(z3);
        }
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.WrapperAdapter
    public void unwrapPosition(@NonNull UnwrapPositionResult unwrapPositionResult, int i4) {
        unwrapPositionResult.adapter = getWrappedAdapter();
        unwrapPositionResult.position = i4;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.WrapperAdapter
    public int wrapPosition(@NonNull AdapterPathSegment adapterPathSegment, int i4) {
        if (adapterPathSegment.adapter == getWrappedAdapter()) {
            return i4;
        }
        return -1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull VH vh, int i4, @NonNull List<Object> list) {
        if (isWrappedAdapterAlive()) {
            this.f33683a.onBindViewHolder(vh, i4, list);
        }
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.BridgeAdapterDataObserver.Subscriber
    public final void onBridgedAdapterItemRangeChanged(@NonNull RecyclerView.Adapter adapter, @Nullable Object obj, int i4, int i5, Object obj2) {
        c(i4, i5, obj2);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.WrappedAdapter
    public boolean onFailedToRecycleView(@NonNull VH vh, int i4) {
        if (isWrappedAdapterAlive() ? WrappedAdapterUtils.invokeOnFailedToRecycleView(this.f33683a, vh, i4) : false) {
            return true;
        }
        return super.onFailedToRecycleView(vh);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.WrappedAdapter
    public void onViewAttachedToWindow(@NonNull VH vh, int i4) {
        if (isWrappedAdapterAlive()) {
            WrappedAdapterUtils.invokeOnViewAttachedToWindow(this.f33683a, vh, i4);
        }
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.WrappedAdapter
    public void onViewDetachedFromWindow(@NonNull VH vh, int i4) {
        if (isWrappedAdapterAlive()) {
            WrappedAdapterUtils.invokeOnViewDetachedFromWindow(this.f33683a, vh, i4);
        }
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.WrappedAdapter
    public void onViewRecycled(@NonNull VH vh, int i4) {
        if (isWrappedAdapterAlive()) {
            WrappedAdapterUtils.invokeOnViewRecycled(this.f33683a, vh, i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @CallSuper
    public void g() {
    }
}
