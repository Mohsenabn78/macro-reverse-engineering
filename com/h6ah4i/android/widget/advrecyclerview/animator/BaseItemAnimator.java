package com.h6ah4i.android.widget.advrecyclerview.animator;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;

/* loaded from: classes6.dex */
public abstract class BaseItemAnimator extends SimpleItemAnimator {

    /* renamed from: a  reason: collision with root package name */
    private ItemAnimatorListener f33685a;

    /* loaded from: classes6.dex */
    public interface ItemAnimatorListener {
        void onAddFinished(@NonNull RecyclerView.ViewHolder viewHolder);

        void onChangeFinished(@NonNull RecyclerView.ViewHolder viewHolder);

        void onMoveFinished(@NonNull RecyclerView.ViewHolder viewHolder);

        void onRemoveFinished(@NonNull RecyclerView.ViewHolder viewHolder);
    }

    public boolean debugLogEnabled() {
        return false;
    }

    public boolean dispatchFinishedWhenDone() {
        if (!isRunning()) {
            dispatchAnimationsFinished();
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public final void onAddFinished(RecyclerView.ViewHolder viewHolder) {
        a(viewHolder);
        ItemAnimatorListener itemAnimatorListener = this.f33685a;
        if (itemAnimatorListener != null) {
            itemAnimatorListener.onAddFinished(viewHolder);
        }
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public final void onAddStarting(RecyclerView.ViewHolder viewHolder) {
        b(viewHolder);
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public final void onChangeFinished(RecyclerView.ViewHolder viewHolder, boolean z3) {
        c(viewHolder, z3);
        ItemAnimatorListener itemAnimatorListener = this.f33685a;
        if (itemAnimatorListener != null) {
            itemAnimatorListener.onChangeFinished(viewHolder);
        }
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public final void onChangeStarting(RecyclerView.ViewHolder viewHolder, boolean z3) {
        d(viewHolder, z3);
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public final void onMoveFinished(RecyclerView.ViewHolder viewHolder) {
        e(viewHolder);
        ItemAnimatorListener itemAnimatorListener = this.f33685a;
        if (itemAnimatorListener != null) {
            itemAnimatorListener.onMoveFinished(viewHolder);
        }
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public final void onMoveStarting(RecyclerView.ViewHolder viewHolder) {
        f(viewHolder);
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public final void onRemoveFinished(RecyclerView.ViewHolder viewHolder) {
        g(viewHolder);
        ItemAnimatorListener itemAnimatorListener = this.f33685a;
        if (itemAnimatorListener != null) {
            itemAnimatorListener.onRemoveFinished(viewHolder);
        }
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public final void onRemoveStarting(RecyclerView.ViewHolder viewHolder) {
        h(viewHolder);
    }

    public void setListener(@Nullable ItemAnimatorListener itemAnimatorListener) {
        this.f33685a = itemAnimatorListener;
    }

    protected void a(@NonNull RecyclerView.ViewHolder viewHolder) {
    }

    protected void b(@NonNull RecyclerView.ViewHolder viewHolder) {
    }

    protected void e(@NonNull RecyclerView.ViewHolder viewHolder) {
    }

    protected void f(@NonNull RecyclerView.ViewHolder viewHolder) {
    }

    protected void g(@NonNull RecyclerView.ViewHolder viewHolder) {
    }

    protected void h(@NonNull RecyclerView.ViewHolder viewHolder) {
    }

    protected void c(@NonNull RecyclerView.ViewHolder viewHolder, boolean z3) {
    }

    protected void d(@NonNull RecyclerView.ViewHolder viewHolder, boolean z3) {
    }
}
