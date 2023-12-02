package com.thoughtbot.expandablerecyclerview;

import com.thoughtbot.expandablerecyclerview.listeners.ExpandCollapseListener;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.models.ExpandableList;
import com.thoughtbot.expandablerecyclerview.models.ExpandableListPosition;

/* loaded from: classes6.dex */
public class ExpandCollapseController {

    /* renamed from: a  reason: collision with root package name */
    private ExpandCollapseListener f38080a;

    /* renamed from: b  reason: collision with root package name */
    private ExpandableList f38081b;

    public ExpandCollapseController(ExpandableList expandableList, ExpandCollapseListener expandCollapseListener) {
        this.f38081b = expandableList;
        this.f38080a = expandCollapseListener;
    }

    private void a(ExpandableListPosition expandableListPosition) {
        ExpandableList expandableList = this.f38081b;
        expandableList.expandedGroupIndexes[expandableListPosition.groupPos] = false;
        ExpandCollapseListener expandCollapseListener = this.f38080a;
        if (expandCollapseListener != null) {
            expandCollapseListener.onGroupCollapsed(expandableList.getFlattenedGroupIndex(expandableListPosition) + 1, this.f38081b.groups.get(expandableListPosition.groupPos).getItemCount());
        }
    }

    private void b(ExpandableListPosition expandableListPosition) {
        ExpandableList expandableList = this.f38081b;
        expandableList.expandedGroupIndexes[expandableListPosition.groupPos] = true;
        ExpandCollapseListener expandCollapseListener = this.f38080a;
        if (expandCollapseListener != null) {
            expandCollapseListener.onGroupExpanded(expandableList.getFlattenedGroupIndex(expandableListPosition) + 1, this.f38081b.groups.get(expandableListPosition.groupPos).getItemCount());
        }
    }

    public boolean isGroupExpanded(ExpandableGroup expandableGroup) {
        return this.f38081b.expandedGroupIndexes[this.f38081b.groups.indexOf(expandableGroup)];
    }

    public boolean toggleGroup(int i4) {
        ExpandableListPosition unflattenedPosition = this.f38081b.getUnflattenedPosition(i4);
        boolean z3 = this.f38081b.expandedGroupIndexes[unflattenedPosition.groupPos];
        if (z3) {
            a(unflattenedPosition);
        } else {
            b(unflattenedPosition);
        }
        return z3;
    }

    public boolean isGroupExpanded(int i4) {
        return this.f38081b.expandedGroupIndexes[this.f38081b.getUnflattenedPosition(i4).groupPos];
    }

    public boolean toggleGroup(ExpandableGroup expandableGroup) {
        ExpandableList expandableList = this.f38081b;
        ExpandableListPosition unflattenedPosition = expandableList.getUnflattenedPosition(expandableList.getFlattenedGroupIndex(expandableGroup));
        boolean isGroupExpanded = isGroupExpanded(unflattenedPosition.groupPos);
        if (isGroupExpanded) {
            a(unflattenedPosition);
        } else {
            b(unflattenedPosition);
        }
        return isGroupExpanded;
    }
}
