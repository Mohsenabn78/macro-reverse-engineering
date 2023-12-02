package com.h6ah4i.android.widget.advrecyclerview.expandable;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.h6ah4i.android.widget.advrecyclerview.adapter.AdapterPath;
import com.h6ah4i.android.widget.advrecyclerview.adapter.ItemIdComposer;
import com.h6ah4i.android.widget.advrecyclerview.adapter.ItemViewTypeComposer;
import com.h6ah4i.android.widget.advrecyclerview.utils.CustomRecyclerViewUtils;
import com.h6ah4i.android.widget.advrecyclerview.utils.WrapperAdapterUtils;

/* loaded from: classes6.dex */
public class RecyclerViewExpandableItemManager implements ExpandableItemConstants {
    public static final long NO_EXPANDABLE_POSITION = -1;

    /* renamed from: a  reason: collision with root package name */
    private SavedState f33859a;

    /* renamed from: b  reason: collision with root package name */
    private RecyclerView f33860b;

    /* renamed from: c  reason: collision with root package name */
    private c f33861c;

    /* renamed from: e  reason: collision with root package name */
    private OnGroupExpandListener f33863e;

    /* renamed from: f  reason: collision with root package name */
    private OnGroupCollapseListener f33864f;

    /* renamed from: h  reason: collision with root package name */
    private int f33866h;

    /* renamed from: i  reason: collision with root package name */
    private int f33867i;

    /* renamed from: j  reason: collision with root package name */
    private int f33868j;

    /* renamed from: g  reason: collision with root package name */
    private long f33865g = -1;

    /* renamed from: k  reason: collision with root package name */
    private boolean f33869k = false;

    /* renamed from: d  reason: collision with root package name */
    private RecyclerView.OnItemTouchListener f33862d = new a();

    /* loaded from: classes6.dex */
    public interface OnGroupCollapseListener {
        void onGroupCollapse(int i4, boolean z3, Object obj);
    }

    /* loaded from: classes6.dex */
    public interface OnGroupExpandListener {
        void onGroupExpand(int i4, boolean z3, Object obj);
    }

    public RecyclerViewExpandableItemManager(@Nullable Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.f33859a = (SavedState) parcelable;
        }
    }

    private void a(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
        RecyclerView.ViewHolder findChildViewHolderUnderWithTranslation = CustomRecyclerViewUtils.findChildViewHolderUnderWithTranslation(recyclerView, motionEvent.getX(), motionEvent.getY());
        this.f33867i = (int) (motionEvent.getX() + 0.5f);
        this.f33868j = (int) (motionEvent.getY() + 0.5f);
        if (findChildViewHolderUnderWithTranslation instanceof ExpandableItemViewHolder) {
            this.f33865g = findChildViewHolderUnderWithTranslation.getItemId();
        } else {
            this.f33865g = -1L;
        }
    }

    private boolean b(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
        RecyclerView.ViewHolder findChildViewHolderUnderWithTranslation;
        long j4 = this.f33865g;
        int i4 = this.f33867i;
        int i5 = this.f33868j;
        this.f33865g = -1L;
        this.f33867i = 0;
        this.f33868j = 0;
        if (j4 == -1 || motionEvent.getActionMasked() != 1 || this.f33860b.isComputingLayout()) {
            return false;
        }
        int x3 = (int) (motionEvent.getX() + 0.5f);
        int y3 = (int) (motionEvent.getY() + 0.5f);
        int i6 = y3 - i5;
        if (Math.abs(x3 - i4) < this.f33866h && Math.abs(i6) < this.f33866h && (findChildViewHolderUnderWithTranslation = CustomRecyclerViewUtils.findChildViewHolderUnderWithTranslation(recyclerView, motionEvent.getX(), motionEvent.getY())) != null && findChildViewHolderUnderWithTranslation.getItemId() == j4) {
            int unwrapPosition = WrapperAdapterUtils.unwrapPosition(this.f33860b.getAdapter(), this.f33861c, CustomRecyclerViewUtils.getSynchronizedPosition(findChildViewHolderUnderWithTranslation));
            if (unwrapPosition == -1) {
                return false;
            }
            View view = findChildViewHolderUnderWithTranslation.itemView;
            int left = view.getLeft();
            return this.f33861c.M(findChildViewHolderUnderWithTranslation, unwrapPosition, x3 - (left + ((int) (view.getTranslationX() + 0.5f))), y3 - (view.getTop() + ((int) (view.getTranslationY() + 0.5f))));
        }
        return false;
    }

    public static long getChildItemId(long j4) {
        return ItemIdComposer.extractExpandableChildIdPart(j4);
    }

    public static int getChildViewType(int i4) {
        return ItemViewTypeComposer.extractWrappedViewTypePart(i4);
    }

    public static long getCombinedChildId(long j4, long j5) {
        return ItemIdComposer.composeExpandableChildId(j4, j5);
    }

    public static long getCombinedGroupId(long j4) {
        return ItemIdComposer.composeExpandableGroupId(j4);
    }

    public static long getGroupItemId(long j4) {
        return ItemIdComposer.extractExpandableGroupIdPart(j4);
    }

    public static int getGroupViewType(int i4) {
        return ItemViewTypeComposer.extractWrappedViewTypePart(i4);
    }

    public static int getPackedPositionChild(long j4) {
        return com.h6ah4i.android.widget.advrecyclerview.expandable.a.a(j4);
    }

    public static long getPackedPositionForChild(int i4, int i5) {
        return com.h6ah4i.android.widget.advrecyclerview.expandable.a.b(i4, i5);
    }

    public static long getPackedPositionForGroup(int i4) {
        return com.h6ah4i.android.widget.advrecyclerview.expandable.a.c(i4);
    }

    public static int getPackedPositionGroup(long j4) {
        return com.h6ah4i.android.widget.advrecyclerview.expandable.a.d(j4);
    }

    public static boolean isGroupItemId(long j4) {
        return ItemIdComposer.isExpandableGroup(j4);
    }

    public static boolean isGroupViewType(int i4) {
        return ItemViewTypeComposer.isExpandableGroup(i4);
    }

    public void attachRecyclerView(@NonNull RecyclerView recyclerView) {
        if (!isReleased()) {
            if (this.f33860b == null) {
                this.f33860b = recyclerView;
                recyclerView.addOnItemTouchListener(this.f33862d);
                this.f33866h = ViewConfiguration.get(this.f33860b.getContext()).getScaledTouchSlop();
                return;
            }
            throw new IllegalStateException("RecyclerView instance has already been set");
        }
        throw new IllegalStateException("Accessing released object");
    }

    boolean c(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
        if (this.f33861c == null) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1 || actionMasked == 3) {
                b(recyclerView, motionEvent);
                return false;
            }
        } else {
            a(recyclerView, motionEvent);
        }
        return false;
    }

    public void collapseAll() {
        c cVar = this.f33861c;
        if (cVar != null) {
            cVar.h();
        }
    }

    public boolean collapseGroup(int i4) {
        return collapseGroup(i4, null);
    }

    @NonNull
    public RecyclerView.Adapter createWrappedAdapter(@NonNull RecyclerView.Adapter adapter) {
        long[] jArr;
        if (adapter.hasStableIds()) {
            if (this.f33861c == null) {
                SavedState savedState = this.f33859a;
                if (savedState != null) {
                    jArr = savedState.f33870a;
                } else {
                    jArr = null;
                }
                this.f33859a = null;
                c cVar = new c(this, adapter, jArr);
                this.f33861c = cVar;
                cVar.S(this.f33863e);
                this.f33863e = null;
                this.f33861c.R(this.f33864f);
                this.f33864f = null;
                return this.f33861c;
            }
            throw new IllegalStateException("already have a wrapped adapter");
        }
        throw new IllegalArgumentException("The passed adapter does not support stable IDs");
    }

    public void expandAll() {
        c cVar = this.f33861c;
        if (cVar != null) {
            cVar.k();
        }
    }

    public boolean expandGroup(int i4) {
        return expandGroup(i4, null);
    }

    public int getChildCount(int i4) {
        return this.f33861c.getChildCount(i4);
    }

    public int getCollapsedGroupsCount() {
        return this.f33861c.m();
    }

    public boolean getDefaultGroupsExpandedState() {
        return this.f33869k;
    }

    public long getExpandablePosition(int i4) {
        c cVar = this.f33861c;
        if (cVar == null) {
            return -1L;
        }
        return cVar.o(i4);
    }

    public int getExpandedGroupsCount() {
        return this.f33861c.p();
    }

    public int getFlatPosition(long j4) {
        c cVar = this.f33861c;
        if (cVar == null) {
            return -1;
        }
        return cVar.r(j4);
    }

    public int getGroupCount() {
        return this.f33861c.getGroupCount();
    }

    @NonNull
    public Parcelable getSavedState() {
        long[] jArr;
        c cVar = this.f33861c;
        if (cVar != null) {
            jArr = cVar.q();
        } else {
            jArr = null;
        }
        return new SavedState(jArr);
    }

    public boolean isAllGroupsCollapsed() {
        return this.f33861c.s();
    }

    public boolean isAllGroupsExpanded() {
        return this.f33861c.t();
    }

    public boolean isGroupExpanded(int i4) {
        c cVar = this.f33861c;
        if (cVar != null && cVar.isGroupExpanded(i4)) {
            return true;
        }
        return false;
    }

    public boolean isReleased() {
        if (this.f33862d == null) {
            return true;
        }
        return false;
    }

    public void notifyChildItemChanged(int i4, int i5) {
        this.f33861c.w(i4, i5, null);
    }

    public void notifyChildItemInserted(int i4, int i5) {
        this.f33861c.x(i4, i5);
    }

    public void notifyChildItemMoved(int i4, int i5, int i6) {
        this.f33861c.y(i4, i5, i6);
    }

    public void notifyChildItemRangeChanged(int i4, int i5, int i6) {
        this.f33861c.A(i4, i5, i6, null);
    }

    public void notifyChildItemRangeInserted(int i4, int i5, int i6) {
        this.f33861c.B(i4, i5, i6);
    }

    public void notifyChildItemRangeRemoved(int i4, int i5, int i6) {
        this.f33861c.C(i4, i5, i6);
    }

    public void notifyChildItemRemoved(int i4, int i5) {
        this.f33861c.D(i4, i5);
    }

    public void notifyChildrenOfGroupItemChanged(int i4) {
        this.f33861c.E(i4, null);
    }

    public void notifyGroupAndChildrenItemsChanged(int i4) {
        this.f33861c.F(i4, null);
    }

    public void notifyGroupItemChanged(int i4) {
        this.f33861c.G(i4, null);
    }

    public void notifyGroupItemInserted(int i4) {
        notifyGroupItemInserted(i4, this.f33869k);
    }

    public void notifyGroupItemMoved(int i4, int i5) {
        this.f33861c.I(i4, i5);
    }

    public void notifyGroupItemRangeInserted(int i4, int i5) {
        notifyGroupItemRangeInserted(i4, i5, this.f33869k);
    }

    public void notifyGroupItemRangeRemoved(int i4, int i5) {
        this.f33861c.K(i4, i5);
    }

    public void notifyGroupItemRemoved(int i4) {
        this.f33861c.L(i4);
    }

    public void release() {
        RecyclerView.OnItemTouchListener onItemTouchListener;
        RecyclerView recyclerView = this.f33860b;
        if (recyclerView != null && (onItemTouchListener = this.f33862d) != null) {
            recyclerView.removeOnItemTouchListener(onItemTouchListener);
        }
        this.f33862d = null;
        this.f33863e = null;
        this.f33864f = null;
        this.f33860b = null;
        this.f33859a = null;
    }

    public void restoreState(@Nullable Parcelable parcelable) {
        restoreState(parcelable, false, false);
    }

    public void scrollToGroup(int i4, int i5) {
        scrollToGroup(i4, i5, 0, 0, null);
    }

    public void scrollToGroupWithTotalChildrenHeight(int i4, int i5, int i6, int i7) {
        scrollToGroupWithTotalChildrenHeight(i4, i5, i6, i7, null);
    }

    public void setDefaultGroupsExpandedState(boolean z3) {
        this.f33869k = z3;
    }

    public void setOnGroupCollapseListener(@Nullable OnGroupCollapseListener onGroupCollapseListener) {
        c cVar = this.f33861c;
        if (cVar != null) {
            cVar.R(onGroupCollapseListener);
        } else {
            this.f33864f = onGroupCollapseListener;
        }
    }

    public void setOnGroupExpandListener(@Nullable OnGroupExpandListener onGroupExpandListener) {
        c cVar = this.f33861c;
        if (cVar != null) {
            cVar.S(onGroupExpandListener);
        } else {
            this.f33863e = onGroupExpandListener;
        }
    }

    /* loaded from: classes6.dex */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        final long[] f33870a;

        /* loaded from: classes6.dex */
        static class a implements Parcelable.Creator<SavedState> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public SavedState[] newArray(int i4) {
                return new SavedState[i4];
            }
        }

        public SavedState(long[] jArr) {
            this.f33870a = jArr;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i4) {
            parcel.writeLongArray(this.f33870a);
        }

        SavedState(Parcel parcel) {
            this.f33870a = parcel.createLongArray();
        }
    }

    public boolean collapseGroup(int i4, Object obj) {
        c cVar = this.f33861c;
        return cVar != null && cVar.i(i4, false, obj);
    }

    public boolean expandGroup(int i4, Object obj) {
        c cVar = this.f33861c;
        return cVar != null && cVar.l(i4, false, obj);
    }

    public void notifyChildItemChanged(int i4, int i5, Object obj) {
        this.f33861c.w(i4, i5, obj);
    }

    public void notifyChildItemMoved(int i4, int i5, int i6, int i7) {
        this.f33861c.z(i4, i5, i6, i7);
    }

    public void notifyChildItemRangeChanged(int i4, int i5, int i6, Object obj) {
        this.f33861c.A(i4, i5, i6, obj);
    }

    public void notifyChildrenOfGroupItemChanged(int i4, Object obj) {
        this.f33861c.E(i4, obj);
    }

    public void notifyGroupAndChildrenItemsChanged(int i4, Object obj) {
        this.f33861c.F(i4, obj);
    }

    public void notifyGroupItemChanged(int i4, Object obj) {
        this.f33861c.G(i4, obj);
    }

    public void notifyGroupItemInserted(int i4, boolean z3) {
        this.f33861c.H(i4, z3);
    }

    public void notifyGroupItemRangeInserted(int i4, int i5, boolean z3) {
        this.f33861c.J(i4, i5, z3);
    }

    public void restoreState(@Nullable Parcelable parcelable, boolean z3, boolean z4) {
        if (parcelable == null) {
            return;
        }
        if (parcelable instanceof SavedState) {
            c cVar = this.f33861c;
            if (cVar != null && this.f33860b != null) {
                cVar.P(((SavedState) parcelable).f33870a, z3, z4);
                return;
            }
            throw new IllegalStateException("RecyclerView has not been attached");
        }
        throw new IllegalArgumentException("Illegal saved state object passed");
    }

    public void scrollToGroup(int i4, int i5, int i6, int i7) {
        scrollToGroupWithTotalChildrenHeight(i4, getChildCount(i4) * i5, i6, i7, null);
    }

    public void scrollToGroupWithTotalChildrenHeight(int i4, int i5, int i6, int i7, @Nullable AdapterPath adapterPath) {
        int flatPosition = getFlatPosition(getPackedPositionForGroup(i4));
        if (adapterPath != null) {
            flatPosition = WrapperAdapterUtils.wrapPosition(adapterPath, this.f33861c, this.f33860b.getAdapter(), flatPosition);
        }
        RecyclerView.ViewHolder findViewHolderForLayoutPosition = this.f33860b.findViewHolderForLayoutPosition(flatPosition);
        if (findViewHolderForLayoutPosition == null) {
            return;
        }
        if (!isGroupExpanded(i4)) {
            i5 = 0;
        }
        int top = findViewHolderForLayoutPosition.itemView.getTop();
        int height = this.f33860b.getHeight() - findViewHolderForLayoutPosition.itemView.getBottom();
        if (top <= i6) {
            int paddingTop = i6 - this.f33860b.getPaddingTop();
            ((LinearLayoutManager) this.f33860b.getLayoutManager()).scrollToPositionWithOffset(flatPosition, paddingTop - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) findViewHolderForLayoutPosition.itemView.getLayoutParams())).topMargin);
            return;
        }
        int i8 = i5 + i7;
        if (height >= i8) {
            return;
        }
        this.f33860b.smoothScrollBy(0, Math.min(top - i6, Math.max(0, i8 - height)));
    }

    public void scrollToGroup(int i4, int i5, int i6, int i7, AdapterPath adapterPath) {
        scrollToGroupWithTotalChildrenHeight(i4, getChildCount(i4) * i5, i6, i7, adapterPath);
    }

    /* loaded from: classes6.dex */
    class a implements RecyclerView.OnItemTouchListener {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
            return RecyclerViewExpandableItemManager.this.c(recyclerView, motionEvent);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onRequestDisallowInterceptTouchEvent(boolean z3) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
        }
    }
}
