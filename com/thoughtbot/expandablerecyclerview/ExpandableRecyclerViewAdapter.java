package com.thoughtbot.expandablerecyclerview;

import android.os.Bundle;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.thoughtbot.expandablerecyclerview.listeners.ExpandCollapseListener;
import com.thoughtbot.expandablerecyclerview.listeners.GroupExpandCollapseListener;
import com.thoughtbot.expandablerecyclerview.listeners.OnGroupClickListener;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.models.ExpandableList;
import com.thoughtbot.expandablerecyclerview.models.ExpandableListPosition;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;
import java.util.List;

/* loaded from: classes6.dex */
public abstract class ExpandableRecyclerViewAdapter<GVH extends GroupViewHolder, CVH extends ChildViewHolder> extends RecyclerView.Adapter implements ExpandCollapseListener, OnGroupClickListener {

    /* renamed from: a  reason: collision with root package name */
    protected ExpandableList f38082a;

    /* renamed from: b  reason: collision with root package name */
    private ExpandCollapseController f38083b;

    /* renamed from: c  reason: collision with root package name */
    private OnGroupClickListener f38084c;

    /* renamed from: d  reason: collision with root package name */
    private GroupExpandCollapseListener f38085d;

    public ExpandableRecyclerViewAdapter(List<? extends ExpandableGroup> list) {
        ExpandableList expandableList = new ExpandableList(list);
        this.f38082a = expandableList;
        this.f38083b = new ExpandCollapseController(expandableList, this);
    }

    public List<? extends ExpandableGroup> getGroups() {
        return this.f38082a.groups;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f38082a.getVisibleItemCount();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i4) {
        return this.f38082a.getUnflattenedPosition(i4).type;
    }

    public boolean isGroupExpanded(int i4) {
        return this.f38083b.isGroupExpanded(i4);
    }

    public abstract void onBindChildViewHolder(CVH cvh, int i4, ExpandableGroup expandableGroup, int i5);

    public abstract void onBindGroupViewHolder(GVH gvh, int i4, ExpandableGroup expandableGroup);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i4) {
        ExpandableListPosition unflattenedPosition = this.f38082a.getUnflattenedPosition(i4);
        ExpandableGroup expandableGroup = this.f38082a.getExpandableGroup(unflattenedPosition);
        int i5 = unflattenedPosition.type;
        if (i5 != 1) {
            if (i5 == 2) {
                onBindGroupViewHolder((GroupViewHolder) viewHolder, i4, expandableGroup);
                return;
            }
            return;
        }
        onBindChildViewHolder((ChildViewHolder) viewHolder, i4, expandableGroup, unflattenedPosition.childPos);
    }

    public abstract CVH onCreateChildViewHolder(ViewGroup viewGroup, int i4);

    public abstract GVH onCreateGroupViewHolder(ViewGroup viewGroup, int i4);

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i4) {
        if (i4 != 1) {
            if (i4 == 2) {
                GVH onCreateGroupViewHolder = onCreateGroupViewHolder(viewGroup, i4);
                onCreateGroupViewHolder.setOnGroupClickListener(this);
                return onCreateGroupViewHolder;
            }
            throw new IllegalArgumentException("viewType is not valid");
        }
        return onCreateChildViewHolder(viewGroup, i4);
    }

    @Override // com.thoughtbot.expandablerecyclerview.listeners.OnGroupClickListener
    public boolean onGroupClick(int i4) {
        OnGroupClickListener onGroupClickListener = this.f38084c;
        if (onGroupClickListener != null) {
            onGroupClickListener.onGroupClick(i4);
        }
        return this.f38083b.toggleGroup(i4);
    }

    @Override // com.thoughtbot.expandablerecyclerview.listeners.ExpandCollapseListener
    public void onGroupCollapsed(int i4, int i5) {
        if (i5 > 0) {
            notifyItemRangeRemoved(i4, i5);
            if (this.f38085d != null) {
                this.f38085d.onGroupCollapsed(getGroups().get(this.f38082a.getUnflattenedPosition(i4 - 1).groupPos));
            }
        }
    }

    @Override // com.thoughtbot.expandablerecyclerview.listeners.ExpandCollapseListener
    public void onGroupExpanded(int i4, int i5) {
        if (i5 > 0) {
            notifyItemRangeInserted(i4, i5);
            if (this.f38085d != null) {
                this.f38085d.onGroupExpanded(getGroups().get(this.f38082a.getUnflattenedPosition(i4).groupPos));
            }
        }
    }

    public void onRestoreInstanceState(Bundle bundle) {
        if (bundle != null && bundle.containsKey("expandable_recyclerview_adapter_expand_state_map")) {
            this.f38082a.expandedGroupIndexes = bundle.getBooleanArray("expandable_recyclerview_adapter_expand_state_map");
            notifyDataSetChanged();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBooleanArray("expandable_recyclerview_adapter_expand_state_map", this.f38082a.expandedGroupIndexes);
    }

    public void setOnGroupClickListener(OnGroupClickListener onGroupClickListener) {
        this.f38084c = onGroupClickListener;
    }

    public void setOnGroupExpandCollapseListener(GroupExpandCollapseListener groupExpandCollapseListener) {
        this.f38085d = groupExpandCollapseListener;
    }

    public boolean toggleGroup(int i4) {
        return this.f38083b.toggleGroup(i4);
    }

    public boolean isGroupExpanded(ExpandableGroup expandableGroup) {
        return this.f38083b.isGroupExpanded(expandableGroup);
    }

    public boolean toggleGroup(ExpandableGroup expandableGroup) {
        return this.f38083b.toggleGroup(expandableGroup);
    }
}
