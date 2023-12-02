package com.h6ah4i.android.widget.advrecyclerview.swipeable;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter;
import com.h6ah4i.android.widget.advrecyclerview.swipeable.action.SwipeResultAction;
import com.h6ah4i.android.widget.advrecyclerview.utils.WrapperAdapterUtils;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SwipeableItemWrapperAdapter.java */
/* loaded from: classes6.dex */
public class e<VH extends RecyclerView.ViewHolder> extends SimpleWrapperAdapter<VH> {

    /* renamed from: d  reason: collision with root package name */
    private SwipeableItemAdapter f33972d;

    /* renamed from: e  reason: collision with root package name */
    private RecyclerViewSwipeManager f33973e;

    /* renamed from: f  reason: collision with root package name */
    private long f33974f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f33975g;

    public e(RecyclerViewSwipeManager recyclerViewSwipeManager, RecyclerView.Adapter<VH> adapter) {
        super(adapter);
        this.f33974f = -1L;
        SwipeableItemAdapter swipeableItemAdapter = (SwipeableItemAdapter) WrapperAdapterUtils.findWrappedAdapter(adapter, SwipeableItemAdapter.class);
        this.f33972d = swipeableItemAdapter;
        if (swipeableItemAdapter != null) {
            if (recyclerViewSwipeManager != null) {
                this.f33973e = recyclerViewSwipeManager;
                return;
            }
            throw new IllegalArgumentException("manager cannot be null");
        }
        throw new IllegalArgumentException("adapter does not implement SwipeableItemAdapter");
    }

    private void h() {
        RecyclerViewSwipeManager recyclerViewSwipeManager = this.f33973e;
        if (recyclerViewSwipeManager != null) {
            recyclerViewSwipeManager.cancelSwipe();
        }
    }

    private static boolean i(int i4, int i5, int i6) {
        if (i4 >= i5 && i4 < i5 + i6) {
            return true;
        }
        return false;
    }

    private static float j(int i4, int i5) {
        if (i5 != 1 && i5 != 2) {
            return 0.0f;
        }
        if (i4 != 2) {
            if (i4 != 3) {
                if (i4 != 4) {
                    if (i4 != 5) {
                        return 0.0f;
                    }
                    return 65537.0f;
                }
                return 65536.0f;
            }
            return -65537.0f;
        }
        return -65536.0f;
    }

    private static float k(SwipeableItemViewHolder swipeableItemViewHolder, boolean z3) {
        if (z3) {
            return swipeableItemViewHolder.getSwipeItemHorizontalSlideAmount();
        }
        return swipeableItemViewHolder.getSwipeItemVerticalSlideAmount();
    }

    private static void s(RecyclerView.ViewHolder viewHolder, int i4) {
        if (!(viewHolder instanceof SwipeableItemViewHolder)) {
            return;
        }
        SwipeableItemViewHolder swipeableItemViewHolder = (SwipeableItemViewHolder) viewHolder;
        int swipeStateFlags = swipeableItemViewHolder.getSwipeStateFlags();
        if (swipeStateFlags == -1 || ((swipeStateFlags ^ i4) & Integer.MAX_VALUE) != 0) {
            i4 |= Integer.MIN_VALUE;
        }
        swipeableItemViewHolder.setSwipeStateFlags(i4);
    }

    private static void t(SwipeableItemViewHolder swipeableItemViewHolder, float f4, boolean z3) {
        if (z3) {
            swipeableItemViewHolder.setSwipeItemHorizontalSlideAmount(f4);
        } else {
            swipeableItemViewHolder.setSwipeItemVerticalSlideAmount(f4);
        }
    }

    private boolean u() {
        return this.f33973e.B();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter
    public void a() {
        if (m() && !this.f33975g) {
            h();
        }
        super.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter
    public void b(int i4, int i5) {
        super.b(i4, i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter
    public void c(int i4, int i5, Object obj) {
        super.c(i4, i5, obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter
    public void d(int i4, int i5) {
        int k4;
        if (m() && (k4 = this.f33973e.k()) >= i4) {
            this.f33973e.D(k4 + i5);
        }
        super.d(i4, i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter
    public void e(int i4, int i5) {
        if (m()) {
            int k4 = this.f33973e.k();
            if (i(k4, i4, i5)) {
                h();
            } else if (i4 < k4) {
                this.f33973e.D(k4 - i5);
            }
        }
        super.e(i4, i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter
    public void f(int i4, int i5, int i6) {
        if (m()) {
            this.f33973e.C();
        }
        super.f(i4, i5, i6);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter
    public void g() {
        super.g();
        this.f33972d = null;
        this.f33973e = null;
        this.f33974f = -1L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int l(RecyclerView.ViewHolder viewHolder, int i4, int i5, int i6) {
        return this.f33972d.onGetSwipeReactionType(viewHolder, i4, i5, i6);
    }

    protected boolean m() {
        if (this.f33974f != -1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SwipeResultAction n(RecyclerView.ViewHolder viewHolder, int i4, int i5) {
        this.f33974f = -1L;
        return this.f33972d.onSwipeItem(viewHolder, i4, i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(RecyclerView.ViewHolder viewHolder, int i4, int i5, int i6, SwipeResultAction swipeResultAction) {
        SwipeableItemViewHolder swipeableItemViewHolder = (SwipeableItemViewHolder) viewHolder;
        swipeableItemViewHolder.setSwipeResult(i5);
        swipeableItemViewHolder.setAfterSwipeReaction(i6);
        if (i6 != 3) {
            t(swipeableItemViewHolder, j(i5, i6), u());
        }
        swipeResultAction.performAction();
        notifyDataSetChanged();
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull VH vh, int i4, @NonNull List<Object> list) {
        SwipeableItemViewHolder swipeableItemViewHolder;
        float f4;
        int i5;
        if (vh instanceof SwipeableItemViewHolder) {
            swipeableItemViewHolder = (SwipeableItemViewHolder) vh;
        } else {
            swipeableItemViewHolder = null;
        }
        if (swipeableItemViewHolder != null) {
            f4 = k((SwipeableItemViewHolder) vh, u());
        } else {
            f4 = 0.0f;
        }
        if (m()) {
            if (vh.getItemId() == this.f33974f) {
                i5 = 3;
            } else {
                i5 = 1;
            }
            s(vh, i5);
            super.onBindViewHolder(vh, i4, list);
        } else {
            s(vh, 0);
            super.onBindViewHolder(vh, i4, list);
        }
        if (swipeableItemViewHolder != null) {
            float k4 = k(swipeableItemViewHolder, u());
            boolean isProportionalSwipeAmountModeEnabled = swipeableItemViewHolder.isProportionalSwipeAmountModeEnabled();
            boolean isSwiping = this.f33973e.isSwiping();
            boolean t3 = this.f33973e.t(vh);
            if (f4 != k4 || (!isSwiping && !t3)) {
                this.f33973e.b(vh, i4, f4, k4, isProportionalSwipeAmountModeEnabled, u(), true, isSwiping);
            }
        }
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i4) {
        VH vh = (VH) super.onCreateViewHolder(viewGroup, i4);
        if (vh instanceof SwipeableItemViewHolder) {
            ((SwipeableItemViewHolder) vh).setSwipeStateFlags(-1);
        }
        return vh;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter, com.h6ah4i.android.widget.advrecyclerview.adapter.WrappedAdapter
    public void onViewRecycled(@NonNull VH vh, int i4) {
        super.onViewRecycled(vh, i4);
        long j4 = this.f33974f;
        if (j4 != -1 && j4 == vh.getItemId()) {
            this.f33973e.cancelSwipe();
        }
        if (vh instanceof SwipeableItemViewHolder) {
            RecyclerViewSwipeManager recyclerViewSwipeManager = this.f33973e;
            if (recyclerViewSwipeManager != null) {
                recyclerViewSwipeManager.c(vh);
            }
            SwipeableItemViewHolder swipeableItemViewHolder = (SwipeableItemViewHolder) vh;
            swipeableItemViewHolder.setSwipeResult(0);
            swipeableItemViewHolder.setAfterSwipeReaction(0);
            swipeableItemViewHolder.setSwipeItemHorizontalSlideAmount(0.0f);
            swipeableItemViewHolder.setSwipeItemVerticalSlideAmount(0.0f);
            swipeableItemViewHolder.setProportionalSwipeAmountModeEnabled(true);
            View b4 = f.b(swipeableItemViewHolder);
            if (b4 != null) {
                ViewCompat.animate(b4).cancel();
                b4.setTranslationX(0.0f);
                b4.setTranslationY(0.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(RecyclerViewSwipeManager recyclerViewSwipeManager, RecyclerView.ViewHolder viewHolder, int i4, long j4) {
        this.f33974f = j4;
        this.f33975g = true;
        this.f33972d.onSwipeItemStarted(viewHolder, i4);
        this.f33975g = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(RecyclerView.ViewHolder viewHolder, int i4, float f4, boolean z3, boolean z4, boolean z5) {
        float f5;
        SwipeableItemViewHolder swipeableItemViewHolder = (SwipeableItemViewHolder) viewHolder;
        float a4 = RecyclerViewSwipeManager.a(swipeableItemViewHolder, z4, f4, z3, swipeableItemViewHolder.isProportionalSwipeAmountModeEnabled());
        if (z4) {
            f5 = a4;
        } else {
            f5 = 0.0f;
        }
        if (z4) {
            a4 = 0.0f;
        }
        swipeableItemViewHolder.onSlideAmountUpdated(f5, a4, z5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(RecyclerView.ViewHolder viewHolder, int i4, float f4, boolean z3, boolean z4, boolean z5, int i5) {
        this.f33972d.onSetSwipeBackground(viewHolder, i4, i5);
        q(viewHolder, i4, f4, z3, z4, z5);
    }
}
