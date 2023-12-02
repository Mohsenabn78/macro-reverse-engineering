package com.thoughtbot.expandablerecyclerview.models;

import android.widget.ExpandableListView;
import java.util.ArrayList;
import javax.mail.UIDFolder;

/* loaded from: classes6.dex */
public class ExpandableListPosition {
    public static final int CHILD = 1;
    public static final int GROUP = 2;

    /* renamed from: b  reason: collision with root package name */
    private static ArrayList<ExpandableListPosition> f38088b = new ArrayList<>(5);

    /* renamed from: a  reason: collision with root package name */
    int f38089a;
    public int childPos;
    public int groupPos;
    public int type;

    private ExpandableListPosition() {
    }

    private static ExpandableListPosition a() {
        synchronized (f38088b) {
            if (f38088b.size() > 0) {
                ExpandableListPosition remove = f38088b.remove(0);
                remove.c();
                return remove;
            }
            return new ExpandableListPosition();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ExpandableListPosition b(long j4) {
        if (j4 == UIDFolder.MAXUID) {
            return null;
        }
        ExpandableListPosition a4 = a();
        a4.groupPos = ExpandableListView.getPackedPositionGroup(j4);
        if (ExpandableListView.getPackedPositionType(j4) == 1) {
            a4.type = 1;
            a4.childPos = ExpandableListView.getPackedPositionChild(j4);
        } else {
            a4.type = 2;
        }
        return a4;
    }

    private void c() {
        this.groupPos = 0;
        this.childPos = 0;
        this.f38089a = 0;
        this.type = 0;
    }

    public static ExpandableListPosition obtain(int i4, int i5, int i6, int i7) {
        ExpandableListPosition a4 = a();
        a4.type = i4;
        a4.groupPos = i5;
        a4.childPos = i6;
        a4.f38089a = i7;
        return a4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ExpandableListPosition expandableListPosition = (ExpandableListPosition) obj;
        if (this.groupPos == expandableListPosition.groupPos && this.childPos == expandableListPosition.childPos && this.f38089a == expandableListPosition.f38089a && this.type == expandableListPosition.type) {
            return true;
        }
        return false;
    }

    public long getPackedPosition() {
        if (this.type == 1) {
            return ExpandableListView.getPackedPositionForChild(this.groupPos, this.childPos);
        }
        return ExpandableListView.getPackedPositionForGroup(this.groupPos);
    }

    public int hashCode() {
        return (((((this.groupPos * 31) + this.childPos) * 31) + this.f38089a) * 31) + this.type;
    }

    public void recycle() {
        synchronized (f38088b) {
            if (f38088b.size() < 5) {
                f38088b.add(this);
            }
        }
    }

    public String toString() {
        return "ExpandableListPosition{groupPos=" + this.groupPos + ", childPos=" + this.childPos + ", flatListPos=" + this.f38089a + ", type=" + this.type + '}';
    }
}
