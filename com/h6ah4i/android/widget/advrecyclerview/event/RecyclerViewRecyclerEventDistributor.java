package com.h6ah4i.android.widget.advrecyclerview.event;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.ref.WeakReference;
import java.util.List;

/* loaded from: classes6.dex */
public class RecyclerViewRecyclerEventDistributor extends BaseRecyclerViewEventDistributor<RecyclerView.RecyclerListener> {

    /* renamed from: e  reason: collision with root package name */
    private a f33856e = new a(this);

    /* loaded from: classes6.dex */
    private static class a implements RecyclerView.RecyclerListener {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<RecyclerViewRecyclerEventDistributor> f33857a;

        public a(@NonNull RecyclerViewRecyclerEventDistributor recyclerViewRecyclerEventDistributor) {
            this.f33857a = new WeakReference<>(recyclerViewRecyclerEventDistributor);
        }

        public void a() {
            this.f33857a.clear();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(@NonNull RecyclerView.ViewHolder viewHolder) {
            RecyclerViewRecyclerEventDistributor recyclerViewRecyclerEventDistributor = this.f33857a.get();
            if (recyclerViewRecyclerEventDistributor != null) {
                recyclerViewRecyclerEventDistributor.f(viewHolder);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.h6ah4i.android.widget.advrecyclerview.event.BaseRecyclerViewEventDistributor
    public void b(@NonNull RecyclerView recyclerView) {
        super.b(recyclerView);
        recyclerView.setRecyclerListener(this.f33856e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.h6ah4i.android.widget.advrecyclerview.event.BaseRecyclerViewEventDistributor
    public void c() {
        super.c();
        a aVar = this.f33856e;
        if (aVar != null) {
            aVar.a();
            this.f33856e = null;
        }
    }

    void f(@NonNull RecyclerView.ViewHolder viewHolder) {
        List<T> list = this.f33854c;
        if (list == 0) {
            return;
        }
        for (T t3 : list) {
            t3.onViewRecycled(viewHolder);
        }
    }
}
