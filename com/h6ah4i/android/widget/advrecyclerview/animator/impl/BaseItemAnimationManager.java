package com.h6ah4i.android.widget.advrecyclerview.animator.impl;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.recyclerview.widget.RecyclerView;
import com.h6ah4i.android.widget.advrecyclerview.animator.BaseItemAnimator;
import com.h6ah4i.android.widget.advrecyclerview.animator.impl.ItemAnimationInfo;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public abstract class BaseItemAnimationManager<T extends ItemAnimationInfo> {

    /* renamed from: e  reason: collision with root package name */
    private static TimeInterpolator f33692e;

    /* renamed from: a  reason: collision with root package name */
    protected final BaseItemAnimator f33693a;

    /* renamed from: b  reason: collision with root package name */
    protected final List<T> f33694b = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    protected final List<RecyclerView.ViewHolder> f33696d = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    protected final List<List<T>> f33695c = new ArrayList();

    /* loaded from: classes6.dex */
    protected static class BaseAnimatorListener implements ViewPropertyAnimatorListener {

        /* renamed from: a  reason: collision with root package name */
        private BaseItemAnimationManager f33697a;

        /* renamed from: b  reason: collision with root package name */
        private ItemAnimationInfo f33698b;

        /* renamed from: c  reason: collision with root package name */
        private RecyclerView.ViewHolder f33699c;

        /* renamed from: d  reason: collision with root package name */
        private ViewPropertyAnimatorCompat f33700d;

        public BaseAnimatorListener(BaseItemAnimationManager baseItemAnimationManager, ItemAnimationInfo itemAnimationInfo, RecyclerView.ViewHolder viewHolder, ViewPropertyAnimatorCompat viewPropertyAnimatorCompat) {
            this.f33697a = baseItemAnimationManager;
            this.f33698b = itemAnimationInfo;
            this.f33699c = viewHolder;
            this.f33700d = viewPropertyAnimatorCompat;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationCancel(@NonNull View view) {
            this.f33697a.h(this.f33698b, this.f33699c);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(@NonNull View view) {
            BaseItemAnimationManager baseItemAnimationManager = this.f33697a;
            ItemAnimationInfo itemAnimationInfo = this.f33698b;
            RecyclerView.ViewHolder viewHolder = this.f33699c;
            this.f33700d.setListener(null);
            this.f33697a = null;
            this.f33698b = null;
            this.f33699c = null;
            this.f33700d = null;
            baseItemAnimationManager.j(itemAnimationInfo, viewHolder);
            baseItemAnimationManager.dispatchFinished(itemAnimationInfo, viewHolder);
            itemAnimationInfo.clear(viewHolder);
            baseItemAnimationManager.f33696d.remove(viewHolder);
            baseItemAnimationManager.d();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationStart(@NonNull View view) {
            this.f33697a.dispatchStarting(this.f33698b, this.f33699c);
        }
    }

    /* loaded from: classes6.dex */
    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ List f33701a;

        a(List list) {
            this.f33701a = list;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            for (ItemAnimationInfo itemAnimationInfo : this.f33701a) {
                BaseItemAnimationManager.this.b(itemAnimationInfo);
            }
            this.f33701a.clear();
            BaseItemAnimationManager.this.f33695c.remove(this.f33701a);
        }
    }

    public BaseItemAnimationManager(@NonNull BaseItemAnimator baseItemAnimator) {
        this.f33693a = baseItemAnimator;
    }

    private void a(RecyclerView.ViewHolder viewHolder) {
        if (viewHolder != null) {
            this.f33696d.add(viewHolder);
            return;
        }
        throw new IllegalStateException("item is null");
    }

    void b(@NonNull T t3) {
        k(t3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean c() {
        return this.f33693a.debugLogEnabled();
    }

    public void cancelAllStartedAnimations() {
        List<RecyclerView.ViewHolder> list = this.f33696d;
        for (int size = list.size() - 1; size >= 0; size--) {
            ViewCompat.animate(list.get(size).itemView).cancel();
        }
    }

    protected void d() {
        this.f33693a.dispatchFinishedWhenDone();
    }

    public abstract void dispatchFinished(@NonNull T t3, @NonNull RecyclerView.ViewHolder viewHolder);

    public abstract void dispatchStarting(@NonNull T t3, @NonNull RecyclerView.ViewHolder viewHolder);

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(@NonNull RecyclerView.ViewHolder viewHolder) {
        this.f33693a.endAnimation(viewHolder);
    }

    public void endAllDeferredReadyAnimations() {
        endDeferredReadyAnimations(null);
    }

    public void endAllPendingAnimations() {
        endPendingAnimations(null);
    }

    public void endDeferredReadyAnimations(@Nullable RecyclerView.ViewHolder viewHolder) {
        for (int size = this.f33695c.size() - 1; size >= 0; size--) {
            List<T> list = this.f33695c.get(size);
            for (int size2 = list.size() - 1; size2 >= 0; size2--) {
                if (f(list.get(size2), viewHolder) && viewHolder != null) {
                    list.remove(size2);
                }
            }
            if (viewHolder == null) {
                list.clear();
            }
            if (list.isEmpty()) {
                this.f33695c.remove(list);
            }
        }
    }

    public void endPendingAnimations(@Nullable RecyclerView.ViewHolder viewHolder) {
        List<T> list = this.f33694b;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (f(list.get(size), viewHolder) && viewHolder != null) {
                list.remove(size);
            }
        }
        if (viewHolder == null) {
            list.clear();
        }
    }

    protected abstract boolean f(@NonNull T t3, @NonNull RecyclerView.ViewHolder viewHolder);

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(@NonNull T t3) {
        this.f33694b.add(t3);
    }

    public abstract long getDuration();

    protected abstract void h(@NonNull T t3, @NonNull RecyclerView.ViewHolder viewHolder);

    public boolean hasPending() {
        return !this.f33694b.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void i(@NonNull T t3, @NonNull RecyclerView.ViewHolder viewHolder);

    public boolean isRunning() {
        if (this.f33694b.isEmpty() && this.f33696d.isEmpty() && this.f33695c.isEmpty()) {
            return false;
        }
        return true;
    }

    protected abstract void j(@NonNull T t3, @NonNull RecyclerView.ViewHolder viewHolder);

    protected abstract void k(@NonNull T t3);

    /* JADX INFO: Access modifiers changed from: protected */
    public void l(@NonNull RecyclerView.ViewHolder viewHolder) {
        if (f33692e == null) {
            f33692e = new ValueAnimator().getInterpolator();
        }
        viewHolder.itemView.animate().setInterpolator(f33692e);
        e(viewHolder);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m(@NonNull T t3, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull ViewPropertyAnimatorCompat viewPropertyAnimatorCompat) {
        viewPropertyAnimatorCompat.setListener(new BaseAnimatorListener(this, t3, viewHolder, viewPropertyAnimatorCompat));
        a(viewHolder);
        viewPropertyAnimatorCompat.start();
    }

    public boolean removeFromActive(@NonNull RecyclerView.ViewHolder viewHolder) {
        return this.f33696d.remove(viewHolder);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void runPendingAnimations(boolean z3, long j4) {
        ArrayList<ItemAnimationInfo> arrayList = new ArrayList(this.f33694b);
        this.f33694b.clear();
        if (z3) {
            this.f33695c.add(arrayList);
            ViewCompat.postOnAnimationDelayed(((ItemAnimationInfo) arrayList.get(0)).getAvailableViewHolder().itemView, new a(arrayList), j4);
            return;
        }
        for (ItemAnimationInfo itemAnimationInfo : arrayList) {
            b(itemAnimationInfo);
        }
        arrayList.clear();
    }

    public abstract void setDuration(long j4);
}
