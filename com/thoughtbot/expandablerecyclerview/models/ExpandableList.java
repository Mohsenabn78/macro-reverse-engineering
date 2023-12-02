package com.thoughtbot.expandablerecyclerview.models;

import java.util.List;

/* loaded from: classes6.dex */
public class ExpandableList {
    public boolean[] expandedGroupIndexes;
    public List<? extends ExpandableGroup> groups;

    public ExpandableList(List<? extends ExpandableGroup> list) {
        this.groups = list;
        this.expandedGroupIndexes = new boolean[list.size()];
        for (int i4 = 0; i4 < list.size(); i4++) {
            this.expandedGroupIndexes[i4] = false;
        }
    }

    private int a(int i4) {
        if (!this.expandedGroupIndexes[i4]) {
            return 1;
        }
        return this.groups.get(i4).getItemCount() + 1;
    }

    public ExpandableGroup getExpandableGroup(ExpandableListPosition expandableListPosition) {
        return this.groups.get(expandableListPosition.groupPos);
    }

    public int getExpandableGroupItemCount(ExpandableListPosition expandableListPosition) {
        return this.groups.get(expandableListPosition.groupPos).getItemCount();
    }

    public int getFlattenedChildIndex(long j4) {
        return getFlattenedChildIndex(ExpandableListPosition.b(j4));
    }

    public int getFlattenedFirstChildIndex(int i4) {
        return getFlattenedGroupIndex(i4) + 1;
    }

    public int getFlattenedGroupIndex(ExpandableListPosition expandableListPosition) {
        int i4 = expandableListPosition.groupPos;
        int i5 = 0;
        for (int i6 = 0; i6 < i4; i6++) {
            i5 += a(i6);
        }
        return i5;
    }

    public ExpandableListPosition getUnflattenedPosition(int i4) {
        int i5 = i4;
        for (int i6 = 0; i6 < this.groups.size(); i6++) {
            int a4 = a(i6);
            if (i5 == 0) {
                return ExpandableListPosition.obtain(2, i6, -1, i4);
            }
            if (i5 < a4) {
                return ExpandableListPosition.obtain(1, i6, i5 - 1, i4);
            }
            i5 -= a4;
        }
        throw new RuntimeException("Unknown state");
    }

    public int getVisibleItemCount() {
        int i4 = 0;
        for (int i5 = 0; i5 < this.groups.size(); i5++) {
            i4 += a(i5);
        }
        return i4;
    }

    public int getFlattenedFirstChildIndex(ExpandableListPosition expandableListPosition) {
        return getFlattenedGroupIndex(expandableListPosition) + 1;
    }

    public int getFlattenedChildIndex(ExpandableListPosition expandableListPosition) {
        int i4 = expandableListPosition.groupPos;
        int i5 = expandableListPosition.childPos;
        int i6 = 0;
        for (int i7 = 0; i7 < i4; i7++) {
            i6 += a(i7);
        }
        return i6 + i5 + 1;
    }

    public int getFlattenedGroupIndex(int i4) {
        int i5 = 0;
        for (int i6 = 0; i6 < i4; i6++) {
            i5 += a(i6);
        }
        return i5;
    }

    public int getFlattenedGroupIndex(ExpandableGroup expandableGroup) {
        int indexOf = this.groups.indexOf(expandableGroup);
        int i4 = 0;
        for (int i5 = 0; i5 < indexOf; i5++) {
            i4 += a(i5);
        }
        return i4;
    }

    public int getFlattenedChildIndex(int i4, int i5) {
        int i6 = 0;
        for (int i7 = 0; i7 < i4; i7++) {
            i6 += a(i7);
        }
        return i6 + i5 + 1;
    }
}
