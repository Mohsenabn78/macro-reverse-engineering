package com.thoughtbot.expandablerecyclerview;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.models.ExpandableListPosition;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;
import java.util.List;

/* loaded from: classes6.dex */
public abstract class MultiTypeExpandableRecyclerViewAdapter<GVH extends GroupViewHolder, CVH extends ChildViewHolder> extends ExpandableRecyclerViewAdapter<GVH, CVH> {
    public MultiTypeExpandableRecyclerViewAdapter(List<? extends ExpandableGroup> list) {
        super(list);
    }

    public int getChildViewType(int i4, ExpandableGroup expandableGroup, int i5) {
        return super.getItemViewType(i4);
    }

    public int getGroupViewType(int i4, ExpandableGroup expandableGroup) {
        return super.getItemViewType(i4);
    }

    @Override // com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i4) {
        ExpandableListPosition unflattenedPosition = this.f38082a.getUnflattenedPosition(i4);
        ExpandableGroup expandableGroup = this.f38082a.getExpandableGroup(unflattenedPosition);
        int i5 = unflattenedPosition.type;
        if (i5 != 1) {
            if (i5 != 2) {
                return i5;
            }
            return getGroupViewType(i4, expandableGroup);
        }
        return getChildViewType(i4, expandableGroup, unflattenedPosition.childPos);
    }

    public boolean isChild(int i4) {
        if (i4 == 1) {
            return true;
        }
        return false;
    }

    public boolean isGroup(int i4) {
        if (i4 == 2) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i4) {
        ExpandableListPosition unflattenedPosition = this.f38082a.getUnflattenedPosition(i4);
        ExpandableGroup expandableGroup = this.f38082a.getExpandableGroup(unflattenedPosition);
        if (isGroup(getItemViewType(i4))) {
            onBindGroupViewHolder((GroupViewHolder) viewHolder, i4, expandableGroup);
        } else if (isChild(getItemViewType(i4))) {
            onBindChildViewHolder((ChildViewHolder) viewHolder, i4, expandableGroup, unflattenedPosition.childPos);
        }
    }

    @Override // com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i4) {
        if (isGroup(i4)) {
            GVH onCreateGroupViewHolder = onCreateGroupViewHolder(viewGroup, i4);
            onCreateGroupViewHolder.setOnGroupClickListener(this);
            return onCreateGroupViewHolder;
        } else if (isChild(i4)) {
            return onCreateChildViewHolder(viewGroup, i4);
        } else {
            throw new IllegalArgumentException("viewType is not valid");
        }
    }
}
