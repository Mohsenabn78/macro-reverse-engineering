package com.h6ah4i.android.widget.advrecyclerview.event;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public abstract class BaseRecyclerViewEventDistributor<T> {

    /* renamed from: a  reason: collision with root package name */
    protected boolean f33852a;

    /* renamed from: b  reason: collision with root package name */
    protected RecyclerView f33853b;

    /* renamed from: c  reason: collision with root package name */
    protected List<T> f33854c;

    /* renamed from: d  reason: collision with root package name */
    protected boolean f33855d;

    protected void a(boolean z3) {
        if (!z3) {
            e("clear()");
        }
        d("clear()");
        List<T> list = this.f33854c;
        if (list == null) {
            return;
        }
        try {
            this.f33855d = true;
            for (int size = list.size() - 1; size >= 0; size--) {
                T remove = this.f33854c.remove(size);
                if (remove instanceof RecyclerViewEventDistributorListener) {
                    ((RecyclerViewEventDistributorListener) remove).onRemovedFromEventDistributor(this);
                }
            }
        } finally {
            this.f33855d = false;
        }
    }

    public boolean add(@NonNull T t3) {
        return add(t3, -1);
    }

    public void attachRecyclerView(@NonNull RecyclerView recyclerView) {
        e("attachRecyclerView()");
        d("attachRecyclerView()");
        b(recyclerView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(@NonNull RecyclerView recyclerView) {
        this.f33853b = recyclerView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c() {
        this.f33853b = null;
        this.f33854c = null;
        this.f33855d = false;
    }

    public void clear() {
        a(false);
    }

    public boolean contains(T t3) {
        List<T> list = this.f33854c;
        if (list != null) {
            return list.contains(t3);
        }
        return false;
    }

    protected void d(@NonNull String str) {
        if (!this.f33855d) {
            return;
        }
        throw new IllegalStateException(str + " can not be called while performing the clear() method");
    }

    protected void e(@NonNull String str) {
        if (!this.f33852a) {
            return;
        }
        throw new IllegalStateException(str + " can not be called after release() method called");
    }

    @Nullable
    public RecyclerView getRecyclerView() {
        return this.f33853b;
    }

    public boolean isReleased() {
        return this.f33852a;
    }

    public void release() {
        if (this.f33852a) {
            return;
        }
        this.f33852a = true;
        a(true);
        c();
    }

    public boolean remove(@NonNull T t3) {
        d("remove()");
        e("remove()");
        List<T> list = this.f33854c;
        if (list == null) {
            return false;
        }
        boolean remove = list.remove(t3);
        if (remove && (t3 instanceof RecyclerViewEventDistributorListener)) {
            ((RecyclerViewEventDistributorListener) t3).onRemovedFromEventDistributor(this);
        }
        return remove;
    }

    public int size() {
        List<T> list = this.f33854c;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public boolean add(@NonNull T t3, int i4) {
        e("add()");
        d("add()");
        if (this.f33854c == null) {
            this.f33854c = new ArrayList();
        }
        if (this.f33854c.contains(t3)) {
            return true;
        }
        if (i4 < 0) {
            this.f33854c.add(t3);
        } else {
            this.f33854c.add(i4, t3);
        }
        if (t3 instanceof RecyclerViewEventDistributorListener) {
            ((RecyclerViewEventDistributorListener) t3).onAddedToEventDistributor(this);
            return true;
        }
        return true;
    }
}
