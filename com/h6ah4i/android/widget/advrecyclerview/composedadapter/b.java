package com.h6ah4i.android.widget.advrecyclerview.composedadapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.h6ah4i.android.widget.advrecyclerview.adapter.BridgeAdapterDataObserver;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ComposedChildAdapterDataObserver.java */
/* loaded from: classes6.dex */
class b extends BridgeAdapterDataObserver {
    public b(@NonNull BridgeAdapterDataObserver.Subscriber subscriber, @NonNull RecyclerView.Adapter adapter) {
        super(subscriber, adapter, new ArrayList());
    }

    @NonNull
    private List<ComposedChildAdapterTag> a() {
        return (List) getTag();
    }

    public boolean b() {
        return !a().isEmpty();
    }

    public void c(@NonNull ComposedChildAdapterTag composedChildAdapterTag) {
        a().add(composedChildAdapterTag);
    }

    public void d() {
        a().clear();
    }

    public void e(@NonNull ComposedChildAdapterTag composedChildAdapterTag) {
        a().remove(composedChildAdapterTag);
    }
}
