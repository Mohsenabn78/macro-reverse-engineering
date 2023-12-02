package com.h6ah4i.android.widget.advrecyclerview.draggable;

import android.util.Log;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter;
import com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemAdapter;
import com.h6ah4i.android.widget.advrecyclerview.swipeable.action.SwipeResultAction;
import com.h6ah4i.android.widget.advrecyclerview.swipeable.action.SwipeResultActionDefault;
import com.h6ah4i.android.widget.advrecyclerview.utils.CustomRecyclerViewUtils;
import com.h6ah4i.android.widget.advrecyclerview.utils.WrapperAdapterUtils;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DraggableItemWrapperAdapter.java */
/* loaded from: classes6.dex */
public class c<VH extends RecyclerView.ViewHolder> extends SimpleWrapperAdapter<VH> implements SwipeableItemAdapter<VH> {

    /* renamed from: d  reason: collision with root package name */
    private RecyclerViewDragDropManager f33802d;

    /* renamed from: e  reason: collision with root package name */
    private DraggableItemAdapter f33803e;

    /* renamed from: f  reason: collision with root package name */
    private RecyclerView.ViewHolder f33804f;

    /* renamed from: g  reason: collision with root package name */
    private DraggingItemInfo f33805g;

    /* renamed from: h  reason: collision with root package name */
    private ItemDraggableRange f33806h;

    /* renamed from: i  reason: collision with root package name */
    private int f33807i;

    /* renamed from: j  reason: collision with root package name */
    private int f33808j;

    /* renamed from: k  reason: collision with root package name */
    private int f33809k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f33810l;

    public c(RecyclerViewDragDropManager recyclerViewDragDropManager, RecyclerView.Adapter<VH> adapter) {
        super(adapter);
        this.f33807i = -1;
        this.f33808j = -1;
        if (recyclerViewDragDropManager != null) {
            this.f33802d = recyclerViewDragDropManager;
            return;
        }
        throw new IllegalArgumentException("manager cannot be null");
    }

    private void j() {
        RecyclerViewDragDropManager recyclerViewDragDropManager = this.f33802d;
        if (recyclerViewDragDropManager != null) {
            recyclerViewDragDropManager.cancelDrag();
        }
    }

    protected static int k(int i4, int i5, int i6, int i7) {
        if (i5 >= 0 && i6 >= 0) {
            if (i7 == 0) {
                if (i5 != i6) {
                    if (i4 >= i5 || i4 >= i6) {
                        if (i4 <= i5 || i4 <= i6) {
                            if (i6 < i5) {
                                if (i4 == i6) {
                                    return i5;
                                }
                                return i4 - 1;
                            } else if (i4 == i6) {
                                return i5;
                            } else {
                                return i4 + 1;
                            }
                        }
                        return i4;
                    }
                    return i4;
                }
                return i4;
            } else if (i7 == 1) {
                if (i4 == i6) {
                    return i5;
                }
                if (i4 == i5) {
                    return i6;
                }
                return i4;
            } else {
                throw new IllegalStateException("unexpected state");
            }
        }
        return i4;
    }

    private int o(int i4) {
        if (p()) {
            return k(i4, this.f33807i, this.f33808j, this.f33809k);
        }
        return i4;
    }

    private static void t(RecyclerView.ViewHolder viewHolder, int i4) {
        if (!(viewHolder instanceof DraggableItemViewHolder)) {
            return;
        }
        DraggableItemViewHolder draggableItemViewHolder = (DraggableItemViewHolder) viewHolder;
        int dragStateFlags = draggableItemViewHolder.getDragStateFlags();
        if (dragStateFlags == -1 || ((dragStateFlags ^ i4) & Integer.MAX_VALUE) != 0) {
            i4 |= Integer.MIN_VALUE;
        }
        draggableItemViewHolder.setDragStateFlags(i4);
    }

    private boolean u() {
        if (p() && !this.f33810l) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter
    public void a() {
        if (u()) {
            j();
        } else {
            super.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter
    public void b(int i4, int i5) {
        if (u()) {
            j();
        } else {
            super.b(i4, i5);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter
    public void d(int i4, int i5) {
        if (u()) {
            j();
        } else {
            super.d(i4, i5);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter
    public void e(int i4, int i5) {
        if (u()) {
            j();
        } else {
            super.e(i4, i5);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter
    public void f(int i4, int i5, int i6) {
        if (u()) {
            j();
        } else {
            super.f(i4, i5, i6);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter
    public void g() {
        super.g();
        this.f33804f = null;
        this.f33803e = null;
        this.f33802d = null;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i4) {
        if (p()) {
            return super.getItemId(k(i4, this.f33807i, this.f33808j, this.f33809k));
        }
        return super.getItemId(i4);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i4) {
        if (p()) {
            return super.getItemViewType(k(i4, this.f33807i, this.f33808j, this.f33809k));
        }
        return super.getItemViewType(i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean h(int i4, int i5) {
        return this.f33803e.onCheckCanDrop(i4, i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean i(RecyclerView.ViewHolder viewHolder, int i4, int i5, int i6) {
        DraggableItemAdapter draggableItemAdapter = (DraggableItemAdapter) WrapperAdapterUtils.findWrappedAdapter(this, DraggableItemAdapter.class, i4);
        if (draggableItemAdapter == null) {
            return false;
        }
        return draggableItemAdapter.onCheckCanStartDrag(viewHolder, i4, i5, i6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int l() {
        return this.f33808j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int m() {
        return this.f33807i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ItemDraggableRange n(RecyclerView.ViewHolder viewHolder, int i4) {
        DraggableItemAdapter draggableItemAdapter = (DraggableItemAdapter) WrapperAdapterUtils.findWrappedAdapter(this, DraggableItemAdapter.class, i4);
        if (draggableItemAdapter == null) {
            return null;
        }
        return draggableItemAdapter.onGetItemDraggableRange(viewHolder, i4);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull VH vh, int i4, @NonNull List<Object> list) {
        int i5;
        if (p()) {
            long j4 = this.f33805g.id;
            long itemId = vh.getItemId();
            int k4 = k(i4, this.f33807i, this.f33808j, this.f33809k);
            int i6 = (itemId > j4 ? 1 : (itemId == j4 ? 0 : -1));
            if (i6 == 0 && vh != this.f33804f) {
                Log.i("ARVDraggableWrapper", "a new view holder object for the currently dragging item is assigned");
                this.f33804f = vh;
                this.f33802d.I(vh);
            }
            if (i6 == 0) {
                i5 = 3;
            } else {
                i5 = 1;
            }
            if (this.f33806h.checkInRange(i4)) {
                i5 |= 4;
            }
            t(vh, i5);
            super.onBindViewHolder(vh, k4, list);
            return;
        }
        t(vh, 0);
        super.onBindViewHolder(vh, i4, list);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i4) {
        VH vh = (VH) super.onCreateViewHolder(viewGroup, i4);
        if (vh instanceof DraggableItemViewHolder) {
            ((DraggableItemViewHolder) vh).setDragStateFlags(-1);
        }
        return vh;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemAdapter
    public int onGetSwipeReactionType(@NonNull VH vh, int i4, int i5, int i6) {
        RecyclerView.Adapter<VH> wrappedAdapter = getWrappedAdapter();
        if (!(wrappedAdapter instanceof SwipeableItemAdapter)) {
            return 0;
        }
        return ((SwipeableItemAdapter) wrappedAdapter).onGetSwipeReactionType(vh, o(i4), i5, i6);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemAdapter
    public void onSetSwipeBackground(@NonNull VH vh, int i4, int i5) {
        RecyclerView.Adapter<VH> wrappedAdapter = getWrappedAdapter();
        if (!(wrappedAdapter instanceof SwipeableItemAdapter)) {
            return;
        }
        ((SwipeableItemAdapter) wrappedAdapter).onSetSwipeBackground(vh, o(i4), i5);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemAdapter
    public SwipeResultAction onSwipeItem(@NonNull VH vh, int i4, int i5) {
        RecyclerView.Adapter<VH> wrappedAdapter = getWrappedAdapter();
        if (!(wrappedAdapter instanceof SwipeableItemAdapter)) {
            return new SwipeResultActionDefault();
        }
        return ((SwipeableItemAdapter) wrappedAdapter).onSwipeItem(vh, o(i4), i5);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemAdapter
    public void onSwipeItemStarted(@NonNull VH vh, int i4) {
        RecyclerView.Adapter<VH> wrappedAdapter = getWrappedAdapter();
        if (!(wrappedAdapter instanceof SwipeableItemAdapter)) {
            return;
        }
        ((SwipeableItemAdapter) wrappedAdapter).onSwipeItemStarted(vh, o(i4));
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter, com.h6ah4i.android.widget.advrecyclerview.adapter.WrappedAdapter
    public void onViewRecycled(@NonNull VH vh, int i4) {
        if (p()) {
            this.f33802d.H(vh);
            this.f33804f = this.f33802d.o();
        }
        super.onViewRecycled(vh, i4);
    }

    protected boolean p() {
        if (this.f33805g != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(int i4, int i5, int i6) {
        int k4 = k(i4, this.f33807i, this.f33808j, this.f33809k);
        if (k4 == this.f33807i) {
            this.f33808j = i5;
            if (this.f33809k == 0 && CustomRecyclerViewUtils.isLinearLayout(i6)) {
                notifyItemMoved(i4, i5);
                return;
            } else {
                notifyDataSetChanged();
                return;
            }
        }
        throw new IllegalStateException("onMoveItem() - may be a bug or has duplicate IDs  --- mDraggingItemInitialPosition = " + this.f33807i + ", mDraggingItemCurrentPosition = " + this.f33808j + ", origFromPosition = " + k4 + ", fromPosition = " + i4 + ", toPosition = " + i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(int i4, int i5, boolean z3) {
        DraggableItemAdapter draggableItemAdapter = this.f33803e;
        this.f33807i = -1;
        this.f33808j = -1;
        this.f33806h = null;
        this.f33805g = null;
        this.f33804f = null;
        this.f33803e = null;
        if (z3 && i5 != i4) {
            draggableItemAdapter.onMoveItem(i4, i5);
        }
        draggableItemAdapter.onItemDragFinished(i4, i5, z3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s() {
        this.f33810l = true;
        this.f33803e.onItemDragStarted(m());
        this.f33810l = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v(DraggingItemInfo draggingItemInfo, RecyclerView.ViewHolder viewHolder, ItemDraggableRange itemDraggableRange, int i4, int i5) {
        if (viewHolder.getItemId() != -1) {
            DraggableItemAdapter draggableItemAdapter = (DraggableItemAdapter) WrapperAdapterUtils.findWrappedAdapter(this, DraggableItemAdapter.class, i4);
            this.f33803e = draggableItemAdapter;
            if (draggableItemAdapter != null) {
                this.f33808j = i4;
                this.f33807i = i4;
                this.f33805g = draggingItemInfo;
                this.f33804f = viewHolder;
                this.f33806h = itemDraggableRange;
                this.f33809k = i5;
                return;
            }
            throw new IllegalStateException("DraggableItemAdapter not found!");
        }
        throw new IllegalStateException("dragging target must provides valid ID");
    }
}
