package com.h6ah4i.android.widget.advrecyclerview.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.ref.WeakReference;

/* loaded from: classes6.dex */
public class BridgeAdapterDataObserver extends RecyclerView.AdapterDataObserver {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<Subscriber> f33679a;

    /* renamed from: b  reason: collision with root package name */
    private final WeakReference<RecyclerView.Adapter> f33680b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f33681c;

    /* loaded from: classes6.dex */
    public interface Subscriber {
        void onBridgedAdapterChanged(@NonNull RecyclerView.Adapter adapter, @Nullable Object obj);

        void onBridgedAdapterItemRangeChanged(@NonNull RecyclerView.Adapter adapter, @Nullable Object obj, int i4, int i5);

        void onBridgedAdapterItemRangeChanged(@NonNull RecyclerView.Adapter adapter, @Nullable Object obj, int i4, int i5, @Nullable Object obj2);

        void onBridgedAdapterItemRangeInserted(@NonNull RecyclerView.Adapter adapter, @Nullable Object obj, int i4, int i5);

        void onBridgedAdapterItemRangeRemoved(@NonNull RecyclerView.Adapter adapter, @Nullable Object obj, int i4, int i5);

        void onBridgedAdapterRangeMoved(@NonNull RecyclerView.Adapter adapter, @Nullable Object obj, int i4, int i5, int i6);
    }

    public BridgeAdapterDataObserver(@NonNull Subscriber subscriber, @NonNull RecyclerView.Adapter adapter, @Nullable Object obj) {
        this.f33679a = new WeakReference<>(subscriber);
        this.f33680b = new WeakReference<>(adapter);
        this.f33681c = obj;
    }

    @Nullable
    public Object getTag() {
        return this.f33681c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public void onChanged() {
        Subscriber subscriber = this.f33679a.get();
        RecyclerView.Adapter adapter = this.f33680b.get();
        if (subscriber != null && adapter != null) {
            subscriber.onBridgedAdapterChanged(adapter, this.f33681c);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public void onItemRangeChanged(int i4, int i5) {
        Subscriber subscriber = this.f33679a.get();
        RecyclerView.Adapter adapter = this.f33680b.get();
        if (subscriber == null || adapter == null) {
            return;
        }
        subscriber.onBridgedAdapterItemRangeChanged(adapter, this.f33681c, i4, i5);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public void onItemRangeInserted(int i4, int i5) {
        Subscriber subscriber = this.f33679a.get();
        RecyclerView.Adapter adapter = this.f33680b.get();
        if (subscriber != null && adapter != null) {
            subscriber.onBridgedAdapterItemRangeInserted(adapter, this.f33681c, i4, i5);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public void onItemRangeMoved(int i4, int i5, int i6) {
        Subscriber subscriber = this.f33679a.get();
        RecyclerView.Adapter adapter = this.f33680b.get();
        if (subscriber != null && adapter != null) {
            subscriber.onBridgedAdapterRangeMoved(adapter, this.f33681c, i4, i5, i6);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public void onItemRangeRemoved(int i4, int i5) {
        Subscriber subscriber = this.f33679a.get();
        RecyclerView.Adapter adapter = this.f33680b.get();
        if (subscriber != null && adapter != null) {
            subscriber.onBridgedAdapterItemRangeRemoved(adapter, this.f33681c, i4, i5);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public void onItemRangeChanged(int i4, int i5, @Nullable Object obj) {
        Subscriber subscriber = this.f33679a.get();
        RecyclerView.Adapter adapter = this.f33680b.get();
        if (subscriber == null || adapter == null) {
            return;
        }
        subscriber.onBridgedAdapterItemRangeChanged(adapter, this.f33681c, i4, i5, obj);
    }
}
