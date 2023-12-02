package com.h6ah4i.android.widget.advrecyclerview.expandable;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.h6ah4i.android.widget.advrecyclerview.adapter.ItemIdComposer;
import com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter;
import com.h6ah4i.android.widget.advrecyclerview.draggable.DraggableItemAdapter;
import com.h6ah4i.android.widget.advrecyclerview.draggable.DraggableItemViewHolder;
import com.h6ah4i.android.widget.advrecyclerview.draggable.ItemDraggableRange;
import com.h6ah4i.android.widget.advrecyclerview.expandable.RecyclerViewExpandableItemManager;
import com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemAdapter;
import com.h6ah4i.android.widget.advrecyclerview.swipeable.action.SwipeResultAction;
import com.h6ah4i.android.widget.advrecyclerview.utils.WrapperAdapterUtils;
import java.util.List;

/* compiled from: ExpandableRecyclerViewWrapperAdapter.java */
/* loaded from: classes6.dex */
class c extends SimpleWrapperAdapter<RecyclerView.ViewHolder> implements DraggableItemAdapter<RecyclerView.ViewHolder>, SwipeableItemAdapter<RecyclerView.ViewHolder> {

    /* renamed from: d  reason: collision with root package name */
    private ExpandableItemAdapter f33879d;

    /* renamed from: e  reason: collision with root package name */
    private RecyclerViewExpandableItemManager f33880e;

    /* renamed from: f  reason: collision with root package name */
    private b f33881f;

    /* renamed from: g  reason: collision with root package name */
    private int f33882g;

    /* renamed from: h  reason: collision with root package name */
    private int f33883h;

    /* renamed from: i  reason: collision with root package name */
    private int f33884i;

    /* renamed from: j  reason: collision with root package name */
    private int f33885j;

    /* renamed from: k  reason: collision with root package name */
    private int f33886k;

    /* renamed from: l  reason: collision with root package name */
    private int f33887l;

    /* renamed from: m  reason: collision with root package name */
    private int f33888m;

    /* renamed from: n  reason: collision with root package name */
    private int f33889n;

    /* renamed from: o  reason: collision with root package name */
    private RecyclerViewExpandableItemManager.OnGroupExpandListener f33890o;

    /* renamed from: p  reason: collision with root package name */
    private RecyclerViewExpandableItemManager.OnGroupCollapseListener f33891p;

    public c(RecyclerViewExpandableItemManager recyclerViewExpandableItemManager, RecyclerView.Adapter<RecyclerView.ViewHolder> adapter, long[] jArr) {
        super(adapter);
        this.f33882g = -1;
        this.f33883h = -1;
        this.f33884i = -1;
        this.f33885j = -1;
        this.f33886k = -1;
        this.f33887l = -1;
        this.f33888m = -1;
        this.f33889n = -1;
        ExpandableItemAdapter n4 = n(adapter);
        this.f33879d = n4;
        if (n4 != null) {
            if (recyclerViewExpandableItemManager != null) {
                this.f33880e = recyclerViewExpandableItemManager;
                b bVar = new b();
                this.f33881f = bVar;
                bVar.b(this.f33879d, 0, this.f33880e.getDefaultGroupsExpandedState());
                if (jArr != null) {
                    this.f33881f.B(jArr, null, null, null);
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("manager cannot be null");
        }
        throw new IllegalArgumentException("adapter does not implement ExpandableItemAdapter");
    }

    private void N(int i4, int i5, boolean z3, Object obj) {
        if (this.f33890o != null) {
            for (int i6 = 0; i6 < i5; i6++) {
                this.f33890o.onGroupExpand(i4 + i6, z3, obj);
            }
        }
    }

    private void O() {
        b bVar = this.f33881f;
        if (bVar != null) {
            long[] l4 = bVar.l();
            this.f33881f.b(this.f33879d, 0, this.f33880e.getDefaultGroupsExpandedState());
            this.f33881f.B(l4, null, null, null);
        }
    }

    private static void Q(RecyclerView.ViewHolder viewHolder, int i4) {
        if (!(viewHolder instanceof ExpandableItemViewHolder)) {
            return;
        }
        ExpandableItemViewHolder expandableItemViewHolder = (ExpandableItemViewHolder) viewHolder;
        int expandStateFlags = expandableItemViewHolder.getExpandStateFlags();
        if (expandStateFlags != -1 && ((expandStateFlags ^ i4) & 4) != 0) {
            i4 |= 8;
        }
        if (expandStateFlags == -1 || ((expandStateFlags ^ i4) & Integer.MAX_VALUE) != 0) {
            i4 |= Integer.MIN_VALUE;
        }
        expandableItemViewHolder.setExpandStateFlags(i4);
    }

    private void j(RecyclerView.ViewHolder viewHolder, int i4, int i5) {
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        if (!(viewHolder instanceof DraggableItemViewHolder)) {
            return;
        }
        DraggableItemViewHolder draggableItemViewHolder = (DraggableItemViewHolder) viewHolder;
        int i6 = this.f33882g;
        boolean z7 = false;
        if (i6 != -1 && this.f33883h != -1) {
            z3 = true;
        } else {
            z3 = false;
        }
        int i7 = this.f33884i;
        if (i7 != -1 && this.f33885j != -1) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (i4 >= i6 && i4 <= this.f33883h) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (i4 != -1 && i5 >= i7 && i5 <= this.f33885j) {
            z6 = true;
        } else {
            z6 = false;
        }
        int dragStateFlags = draggableItemViewHolder.getDragStateFlags();
        if ((dragStateFlags & 1) != 0 && (dragStateFlags & 4) == 0 && ((!z3 || z5) && (!z4 || (z4 && z6)))) {
            z7 = true;
        }
        if (z7) {
            draggableItemViewHolder.setDragStateFlags(dragStateFlags | 4 | Integer.MIN_VALUE);
        }
    }

    private static ExpandableItemAdapter n(RecyclerView.Adapter adapter) {
        return (ExpandableItemAdapter) WrapperAdapterUtils.findWrappedAdapter(adapter, ExpandableItemAdapter.class);
    }

    private static boolean u(ItemDraggableRange itemDraggableRange) {
        return itemDraggableRange.getClass().equals(ChildPositionItemDraggableRange.class);
    }

    private static boolean v(ItemDraggableRange itemDraggableRange) {
        if (itemDraggableRange.getClass().equals(GroupPositionItemDraggableRange.class) || itemDraggableRange.getClass().equals(ItemDraggableRange.class)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void A(int i4, int i5, int i6, Object obj) {
        int m4 = this.f33881f.m(i4);
        if (m4 > 0 && i5 < m4) {
            int j4 = this.f33881f.j(a.b(i4, 0));
            if (j4 != -1) {
                notifyItemRangeChanged(j4 + i5, Math.min(i6, m4 - i5), obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B(int i4, int i5, int i6) {
        this.f33881f.o(i4, i5, i6);
        int j4 = this.f33881f.j(a.b(i4, i5));
        if (j4 != -1) {
            notifyItemRangeInserted(j4, i6);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void C(int i4, int i5, int i6) {
        int j4 = this.f33881f.j(a.b(i4, i5));
        this.f33881f.y(i4, i5, i6);
        if (j4 != -1) {
            notifyItemRangeRemoved(j4, i6);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void D(int i4, int i5) {
        int j4 = this.f33881f.j(a.b(i4, i5));
        this.f33881f.x(i4, i5);
        if (j4 != -1) {
            notifyItemRemoved(j4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void E(int i4, Object obj) {
        int m4 = this.f33881f.m(i4);
        if (m4 > 0) {
            int j4 = this.f33881f.j(a.b(i4, 0));
            if (j4 != -1) {
                notifyItemRangeChanged(j4, m4, obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void F(int i4, Object obj) {
        int j4 = this.f33881f.j(a.c(i4));
        int m4 = this.f33881f.m(i4);
        if (j4 != -1) {
            notifyItemRangeChanged(j4, m4 + 1, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void G(int i4, Object obj) {
        int j4 = this.f33881f.j(a.c(i4));
        if (j4 != -1) {
            notifyItemChanged(j4, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void H(int i4, boolean z3) {
        if (this.f33881f.p(i4, z3) > 0) {
            notifyItemInserted(this.f33881f.j(a.c(i4)));
            N(i4, 1, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I(int i4, int i5) {
        long packedPositionForGroup = RecyclerViewExpandableItemManager.getPackedPositionForGroup(i4);
        long packedPositionForGroup2 = RecyclerViewExpandableItemManager.getPackedPositionForGroup(i5);
        int r4 = r(packedPositionForGroup);
        int r5 = r(packedPositionForGroup2);
        boolean isGroupExpanded = isGroupExpanded(i4);
        boolean isGroupExpanded2 = isGroupExpanded(i5);
        this.f33881f.w(i4, i5);
        if (!isGroupExpanded && !isGroupExpanded2) {
            notifyItemMoved(r4, r5);
        } else {
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void J(int i4, int i5, boolean z3) {
        int q4 = this.f33881f.q(i4, i5, z3);
        if (q4 > 0) {
            notifyItemRangeInserted(this.f33881f.j(a.c(i4)), q4);
            N(i4, i5, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void K(int i4, int i5) {
        int j4 = this.f33881f.j(a.c(i4));
        int A = this.f33881f.A(i4, i5);
        if (A > 0) {
            notifyItemRangeRemoved(j4, A);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void L(int i4) {
        int j4 = this.f33881f.j(a.c(i4));
        int z3 = this.f33881f.z(i4);
        if (z3 > 0) {
            notifyItemRangeRemoved(j4, z3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean M(@NonNull RecyclerView.ViewHolder viewHolder, int i4, int i5, int i6) {
        if (this.f33879d == null) {
            return false;
        }
        long h4 = this.f33881f.h(i4);
        int d4 = a.d(h4);
        if (a.a(h4) != -1) {
            return false;
        }
        boolean z3 = !this.f33881f.u(d4);
        if (!this.f33879d.onCheckCanExpandOrCollapseGroup(viewHolder, d4, i5, i6, z3)) {
            return false;
        }
        if (z3) {
            l(d4, true, null);
        } else {
            i(d4, true, null);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void P(long[] jArr, boolean z3, boolean z4) {
        ExpandableItemAdapter expandableItemAdapter;
        RecyclerViewExpandableItemManager.OnGroupExpandListener onGroupExpandListener;
        b bVar = this.f33881f;
        RecyclerViewExpandableItemManager.OnGroupCollapseListener onGroupCollapseListener = null;
        if (z3) {
            expandableItemAdapter = this.f33879d;
        } else {
            expandableItemAdapter = null;
        }
        if (z4) {
            onGroupExpandListener = this.f33890o;
        } else {
            onGroupExpandListener = null;
        }
        if (z4) {
            onGroupCollapseListener = this.f33891p;
        }
        bVar.B(jArr, expandableItemAdapter, onGroupExpandListener, onGroupCollapseListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void R(RecyclerViewExpandableItemManager.OnGroupCollapseListener onGroupCollapseListener) {
        this.f33891p = onGroupCollapseListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void S(RecyclerViewExpandableItemManager.OnGroupExpandListener onGroupExpandListener) {
        this.f33890o = onGroupExpandListener;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter
    protected void a() {
        O();
        super.a();
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter
    protected void b(int i4, int i5) {
        super.b(i4, i5);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter
    protected void d(int i4, int i5) {
        O();
        super.d(i4, i5);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter
    protected void e(int i4, int i5) {
        if (i5 == 1) {
            long h4 = this.f33881f.h(i4);
            int d4 = a.d(h4);
            int a4 = a.a(h4);
            if (a4 == -1) {
                this.f33881f.z(d4);
            } else {
                this.f33881f.x(d4, a4);
            }
        } else {
            O();
        }
        super.e(i4, i5);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter
    protected void f(int i4, int i5, int i6) {
        O();
        super.f(i4, i5, i6);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter
    protected void g() {
        super.g();
        this.f33879d = null;
        this.f33880e = null;
        this.f33890o = null;
        this.f33891p = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getChildCount(int i4) {
        return this.f33879d.getChildCount(i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getGroupCount() {
        return this.f33879d.getGroupCount();
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f33881f.k();
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i4) {
        if (this.f33879d == null) {
            return -1L;
        }
        long h4 = this.f33881f.h(i4);
        int d4 = a.d(h4);
        int a4 = a.a(h4);
        if (a4 == -1) {
            return ItemIdComposer.composeExpandableGroupId(this.f33879d.getGroupId(d4));
        }
        return ItemIdComposer.composeExpandableChildId(this.f33879d.getGroupId(d4), this.f33879d.getChildId(d4, a4));
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i4) {
        int childItemViewType;
        if (this.f33879d == null) {
            return 0;
        }
        long h4 = this.f33881f.h(i4);
        int d4 = a.d(h4);
        int a4 = a.a(h4);
        if (a4 == -1) {
            childItemViewType = this.f33879d.getGroupItemViewType(d4);
        } else {
            childItemViewType = this.f33879d.getChildItemViewType(d4, a4);
        }
        if ((childItemViewType & Integer.MIN_VALUE) == 0) {
            if (a4 == -1) {
                return childItemViewType | Integer.MIN_VALUE;
            }
            return childItemViewType;
        }
        throw new IllegalStateException("Illegal view type (type = " + Integer.toHexString(childItemViewType) + ")");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h() {
        if (!this.f33881f.t() && !this.f33881f.r()) {
            this.f33881f.b(this.f33879d, 2, this.f33880e.getDefaultGroupsExpandedState());
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean i(int i4, boolean z3, Object obj) {
        if (!this.f33881f.u(i4) || !this.f33879d.onHookGroupCollapse(i4, z3, obj)) {
            return false;
        }
        if (this.f33881f.c(i4)) {
            notifyItemRangeRemoved(this.f33881f.j(a.c(i4)) + 1, this.f33881f.f(i4));
        }
        notifyItemChanged(this.f33881f.j(a.c(i4)), obj);
        RecyclerViewExpandableItemManager.OnGroupCollapseListener onGroupCollapseListener = this.f33891p;
        if (onGroupCollapseListener != null) {
            onGroupCollapseListener.onGroupCollapse(i4, z3, obj);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isGroupExpanded(int i4) {
        return this.f33881f.u(i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k() {
        if (!this.f33881f.t() && !this.f33881f.s()) {
            this.f33881f.b(this.f33879d, 1, this.f33880e.getDefaultGroupsExpandedState());
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean l(int i4, boolean z3, Object obj) {
        if (this.f33881f.u(i4) || !this.f33879d.onHookGroupExpand(i4, z3, obj)) {
            return false;
        }
        if (this.f33881f.e(i4)) {
            notifyItemRangeInserted(this.f33881f.j(a.c(i4)) + 1, this.f33881f.f(i4));
        }
        notifyItemChanged(this.f33881f.j(a.c(i4)), obj);
        RecyclerViewExpandableItemManager.OnGroupExpandListener onGroupExpandListener = this.f33890o;
        if (onGroupExpandListener != null) {
            onGroupExpandListener.onGroupExpand(i4, z3, obj);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int m() {
        return this.f33881f.g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long o(int i4) {
        return this.f33881f.h(i4);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i4, @NonNull List<Object> list) {
        int i5;
        if (this.f33879d == null) {
            return;
        }
        long h4 = this.f33881f.h(i4);
        int d4 = a.d(h4);
        int a4 = a.a(h4);
        int itemViewType = viewHolder.getItemViewType() & Integer.MAX_VALUE;
        if (a4 == -1) {
            i5 = 1;
        } else {
            i5 = 2;
        }
        if (this.f33881f.u(d4)) {
            i5 |= 4;
        }
        Q(viewHolder, i5);
        j(viewHolder, d4, a4);
        if (a4 == -1) {
            this.f33879d.onBindGroupViewHolder(viewHolder, d4, itemViewType, list);
        } else {
            this.f33879d.onBindChildViewHolder(viewHolder, d4, a4, itemViewType, list);
        }
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.draggable.DraggableItemAdapter
    public boolean onCheckCanDrop(int i4, int i5) {
        boolean z3;
        boolean z4;
        ExpandableItemAdapter expandableItemAdapter = this.f33879d;
        boolean z5 = true;
        if (!(expandableItemAdapter instanceof ExpandableDraggableItemAdapter)) {
            return true;
        }
        if (expandableItemAdapter.getGroupCount() < 1) {
            return false;
        }
        ExpandableDraggableItemAdapter expandableDraggableItemAdapter = (ExpandableDraggableItemAdapter) this.f33879d;
        long h4 = this.f33881f.h(i4);
        int d4 = a.d(h4);
        int a4 = a.a(h4);
        long h5 = this.f33881f.h(i5);
        int d5 = a.d(h5);
        int a5 = a.a(h5);
        if (a4 == -1) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (a5 == -1) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3) {
            if (d4 != d5 && i4 < i5) {
                boolean u3 = this.f33881f.u(d5);
                int m4 = this.f33881f.m(d5);
                if (z4) {
                    z4 = !u3;
                } else {
                    if (a5 != m4 - 1) {
                        z5 = false;
                    }
                    z4 = z5;
                }
            }
            if (!z4) {
                return false;
            }
            return expandableDraggableItemAdapter.onCheckGroupCanDrop(d4, d5);
        }
        boolean u4 = this.f33881f.u(d5);
        if (i4 < i5) {
            if (z4) {
                a5 = u4 ? 0 : this.f33881f.f(d5);
            }
        } else if (z4) {
            if (d5 > 0) {
                d5--;
                a5 = this.f33881f.f(d5);
            } else {
                z5 = false;
            }
        }
        if (!z5) {
            return false;
        }
        return expandableDraggableItemAdapter.onCheckChildCanDrop(d4, a4, d5, a5);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.draggable.DraggableItemAdapter
    public boolean onCheckCanStartDrag(@NonNull RecyclerView.ViewHolder viewHolder, int i4, int i5, int i6) {
        boolean onCheckChildCanStartDrag;
        ExpandableItemAdapter expandableItemAdapter = this.f33879d;
        if (!(expandableItemAdapter instanceof ExpandableDraggableItemAdapter)) {
            return false;
        }
        ExpandableDraggableItemAdapter expandableDraggableItemAdapter = (ExpandableDraggableItemAdapter) expandableItemAdapter;
        long h4 = this.f33881f.h(i4);
        int d4 = a.d(h4);
        int a4 = a.a(h4);
        if (a4 == -1) {
            onCheckChildCanStartDrag = expandableDraggableItemAdapter.onCheckGroupCanStartDrag(viewHolder, d4, i5, i6);
        } else {
            onCheckChildCanStartDrag = expandableDraggableItemAdapter.onCheckChildCanStartDrag(viewHolder, d4, a4, i5, i6);
        }
        this.f33882g = -1;
        this.f33883h = -1;
        this.f33884i = -1;
        this.f33885j = -1;
        return onCheckChildCanStartDrag;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i4) {
        RecyclerView.ViewHolder onCreateChildViewHolder;
        ExpandableItemAdapter expandableItemAdapter = this.f33879d;
        if (expandableItemAdapter != null) {
            int i5 = Integer.MAX_VALUE & i4;
            if ((i4 & Integer.MIN_VALUE) != 0) {
                onCreateChildViewHolder = expandableItemAdapter.onCreateGroupViewHolder(viewGroup, i5);
            } else {
                onCreateChildViewHolder = expandableItemAdapter.onCreateChildViewHolder(viewGroup, i5);
            }
            if (onCreateChildViewHolder instanceof ExpandableItemViewHolder) {
                ((ExpandableItemViewHolder) onCreateChildViewHolder).setExpandStateFlags(-1);
            }
            return onCreateChildViewHolder;
        }
        throw new IllegalStateException();
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.draggable.DraggableItemAdapter
    public ItemDraggableRange onGetItemDraggableRange(@NonNull RecyclerView.ViewHolder viewHolder, int i4) {
        ExpandableItemAdapter expandableItemAdapter = this.f33879d;
        if (!(expandableItemAdapter instanceof ExpandableDraggableItemAdapter) || expandableItemAdapter.getGroupCount() < 1) {
            return null;
        }
        ExpandableDraggableItemAdapter expandableDraggableItemAdapter = (ExpandableDraggableItemAdapter) this.f33879d;
        long h4 = this.f33881f.h(i4);
        int d4 = a.d(h4);
        int a4 = a.a(h4);
        if (a4 == -1) {
            ItemDraggableRange onGetGroupItemDraggableRange = expandableDraggableItemAdapter.onGetGroupItemDraggableRange(viewHolder, d4);
            if (onGetGroupItemDraggableRange == null) {
                return new ItemDraggableRange(0, Math.max(0, (this.f33881f.k() - this.f33881f.m(Math.max(0, this.f33879d.getGroupCount() - 1))) - 1));
            } else if (v(onGetGroupItemDraggableRange)) {
                long c4 = a.c(onGetGroupItemDraggableRange.getStart());
                long c5 = a.c(onGetGroupItemDraggableRange.getEnd());
                int j4 = this.f33881f.j(c4);
                int j5 = this.f33881f.j(c5);
                if (onGetGroupItemDraggableRange.getEnd() > d4) {
                    j5 += this.f33881f.m(onGetGroupItemDraggableRange.getEnd());
                }
                this.f33882g = onGetGroupItemDraggableRange.getStart();
                this.f33883h = onGetGroupItemDraggableRange.getEnd();
                return new ItemDraggableRange(j4, j5);
            } else {
                throw new IllegalStateException("Invalid range specified: " + onGetGroupItemDraggableRange);
            }
        }
        ItemDraggableRange onGetChildItemDraggableRange = expandableDraggableItemAdapter.onGetChildItemDraggableRange(viewHolder, d4, a4);
        if (onGetChildItemDraggableRange == null) {
            return new ItemDraggableRange(1, Math.max(1, this.f33881f.k() - 1));
        }
        if (v(onGetChildItemDraggableRange)) {
            long c6 = a.c(onGetChildItemDraggableRange.getStart());
            int j6 = this.f33881f.j(a.c(onGetChildItemDraggableRange.getEnd())) + this.f33881f.m(onGetChildItemDraggableRange.getEnd());
            int min = Math.min(this.f33881f.j(c6) + 1, j6);
            this.f33882g = onGetChildItemDraggableRange.getStart();
            this.f33883h = onGetChildItemDraggableRange.getEnd();
            return new ItemDraggableRange(min, j6);
        } else if (u(onGetChildItemDraggableRange)) {
            int max = Math.max(this.f33881f.m(d4) - 1, 0);
            int min2 = Math.min(onGetChildItemDraggableRange.getStart(), max);
            int min3 = Math.min(onGetChildItemDraggableRange.getEnd(), max);
            long b4 = a.b(d4, min2);
            long b5 = a.b(d4, min3);
            int j7 = this.f33881f.j(b4);
            int j8 = this.f33881f.j(b5);
            this.f33884i = min2;
            this.f33885j = min3;
            return new ItemDraggableRange(j7, j8);
        } else {
            throw new IllegalStateException("Invalid range specified: " + onGetChildItemDraggableRange);
        }
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemAdapter
    public int onGetSwipeReactionType(@NonNull RecyclerView.ViewHolder viewHolder, int i4, int i5, int i6) {
        ExpandableItemAdapter expandableItemAdapter = this.f33879d;
        if (!(expandableItemAdapter instanceof BaseExpandableSwipeableItemAdapter)) {
            return 0;
        }
        BaseExpandableSwipeableItemAdapter baseExpandableSwipeableItemAdapter = (BaseExpandableSwipeableItemAdapter) expandableItemAdapter;
        long h4 = this.f33881f.h(i4);
        int d4 = a.d(h4);
        int a4 = a.a(h4);
        if (a4 == -1) {
            return baseExpandableSwipeableItemAdapter.onGetGroupItemSwipeReactionType(viewHolder, d4, i5, i6);
        }
        return baseExpandableSwipeableItemAdapter.onGetChildItemSwipeReactionType(viewHolder, d4, a4, i5, i6);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.draggable.DraggableItemAdapter
    public void onItemDragFinished(int i4, int i5, boolean z3) {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10 = this.f33886k;
        int i11 = this.f33887l;
        int i12 = this.f33888m;
        int i13 = this.f33889n;
        this.f33882g = -1;
        this.f33883h = -1;
        this.f33884i = -1;
        this.f33885j = -1;
        this.f33886k = -1;
        this.f33887l = -1;
        this.f33888m = -1;
        this.f33889n = -1;
        if (!(this.f33879d instanceof ExpandableDraggableItemAdapter)) {
            return;
        }
        if (i10 == -1 && i11 == -1) {
            long h4 = this.f33881f.h(i4);
            int d4 = a.d(h4);
            i7 = a.a(h4);
            i9 = i7;
            i6 = d4;
            i8 = i6;
        } else {
            i6 = i10;
            i7 = i11;
            i8 = i12;
            i9 = i13;
        }
        ExpandableDraggableItemAdapter expandableDraggableItemAdapter = (ExpandableDraggableItemAdapter) this.f33879d;
        if (i7 == -1) {
            expandableDraggableItemAdapter.onGroupDragFinished(i6, i8, z3);
        } else {
            expandableDraggableItemAdapter.onChildDragFinished(i6, i7, i8, i9, z3);
        }
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.draggable.DraggableItemAdapter
    public void onItemDragStarted(int i4) {
        ExpandableItemAdapter expandableItemAdapter = this.f33879d;
        if (!(expandableItemAdapter instanceof ExpandableDraggableItemAdapter)) {
            return;
        }
        ExpandableDraggableItemAdapter expandableDraggableItemAdapter = (ExpandableDraggableItemAdapter) expandableItemAdapter;
        long h4 = this.f33881f.h(i4);
        int d4 = a.d(h4);
        int a4 = a.a(h4);
        if (a4 == -1) {
            expandableDraggableItemAdapter.onGroupDragStarted(d4);
        } else {
            expandableDraggableItemAdapter.onChildDragStarted(d4, a4);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0095 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00a5  */
    @Override // com.h6ah4i.android.widget.advrecyclerview.draggable.DraggableItemAdapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onMoveItem(int r11, int r12) {
        /*
            Method dump skipped, instructions count: 217
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.h6ah4i.android.widget.advrecyclerview.expandable.c.onMoveItem(int, int):void");
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemAdapter
    public void onSetSwipeBackground(@NonNull RecyclerView.ViewHolder viewHolder, int i4, int i5) {
        ExpandableItemAdapter expandableItemAdapter = this.f33879d;
        if (!(expandableItemAdapter instanceof BaseExpandableSwipeableItemAdapter)) {
            return;
        }
        BaseExpandableSwipeableItemAdapter baseExpandableSwipeableItemAdapter = (BaseExpandableSwipeableItemAdapter) expandableItemAdapter;
        long h4 = this.f33881f.h(i4);
        int d4 = a.d(h4);
        int a4 = a.a(h4);
        if (a4 == -1) {
            baseExpandableSwipeableItemAdapter.onSetGroupItemSwipeBackground(viewHolder, d4, i5);
        } else {
            baseExpandableSwipeableItemAdapter.onSetChildItemSwipeBackground(viewHolder, d4, a4, i5);
        }
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemAdapter
    public SwipeResultAction onSwipeItem(@NonNull RecyclerView.ViewHolder viewHolder, int i4, int i5) {
        ExpandableItemAdapter expandableItemAdapter = this.f33879d;
        if (!(expandableItemAdapter instanceof BaseExpandableSwipeableItemAdapter) || i4 == -1) {
            return null;
        }
        long h4 = this.f33881f.h(i4);
        return d.a((BaseExpandableSwipeableItemAdapter) expandableItemAdapter, viewHolder, a.d(h4), a.a(h4), i5);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemAdapter
    public void onSwipeItemStarted(@NonNull RecyclerView.ViewHolder viewHolder, int i4) {
        ExpandableItemAdapter expandableItemAdapter = this.f33879d;
        if (!(expandableItemAdapter instanceof BaseExpandableSwipeableItemAdapter)) {
            return;
        }
        BaseExpandableSwipeableItemAdapter baseExpandableSwipeableItemAdapter = (BaseExpandableSwipeableItemAdapter) expandableItemAdapter;
        long h4 = this.f33881f.h(i4);
        int d4 = a.d(h4);
        int a4 = a.a(h4);
        if (a4 == -1) {
            baseExpandableSwipeableItemAdapter.onSwipeGroupItemStarted(viewHolder, d4);
        } else {
            baseExpandableSwipeableItemAdapter.onSwipeChildItemStarted(viewHolder, d4, a4);
        }
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.SimpleWrapperAdapter, com.h6ah4i.android.widget.advrecyclerview.adapter.WrappedAdapter
    public void onViewRecycled(@NonNull RecyclerView.ViewHolder viewHolder, int i4) {
        if (viewHolder instanceof ExpandableItemViewHolder) {
            ((ExpandableItemViewHolder) viewHolder).setExpandStateFlags(-1);
        }
        super.onViewRecycled(viewHolder, i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int p() {
        return this.f33881f.i();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long[] q() {
        b bVar = this.f33881f;
        if (bVar != null) {
            return bVar.l();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int r(long j4) {
        return this.f33881f.j(j4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean s() {
        return this.f33881f.r();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean t() {
        return this.f33881f.s();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(int i4, int i5, Object obj) {
        A(i4, i5, 1, obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x(int i4, int i5) {
        this.f33881f.n(i4, i5);
        int j4 = this.f33881f.j(a.b(i4, i5));
        if (j4 != -1) {
            notifyItemInserted(j4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y(int i4, int i5, int i6) {
        z(i4, i5, i4, i6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z(int i4, int i5, int i6, int i7) {
        long packedPositionForChild = RecyclerViewExpandableItemManager.getPackedPositionForChild(i4, i5);
        long packedPositionForChild2 = RecyclerViewExpandableItemManager.getPackedPositionForChild(i6, i7);
        int r4 = r(packedPositionForChild);
        int r5 = r(packedPositionForChild2);
        this.f33881f.v(i4, i5, i6, i7);
        if (r4 != -1 && r5 != -1) {
            notifyItemMoved(r4, r5);
        } else if (r4 != -1) {
            notifyItemRemoved(r4);
        } else if (r5 != -1) {
            notifyItemInserted(r5);
        }
    }
}
