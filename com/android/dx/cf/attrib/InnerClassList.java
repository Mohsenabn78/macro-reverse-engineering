package com.android.dx.cf.attrib;

import com.android.dx.rop.cst.CstString;
import com.android.dx.rop.cst.CstType;
import com.android.dx.util.FixedSizeList;

/* loaded from: classes2.dex */
public final class InnerClassList extends FixedSizeList {

    /* loaded from: classes2.dex */
    public static class Item {
        private final int accessFlags;
        private final CstType innerClass;
        private final CstString innerName;
        private final CstType outerClass;

        public Item(CstType cstType, CstType cstType2, CstString cstString, int i4) {
            if (cstType != null) {
                this.innerClass = cstType;
                this.outerClass = cstType2;
                this.innerName = cstString;
                this.accessFlags = i4;
                return;
            }
            throw new NullPointerException("innerClass == null");
        }

        public int getAccessFlags() {
            return this.accessFlags;
        }

        public CstType getInnerClass() {
            return this.innerClass;
        }

        public CstString getInnerName() {
            return this.innerName;
        }

        public CstType getOuterClass() {
            return this.outerClass;
        }
    }

    public InnerClassList(int i4) {
        super(i4);
    }

    public Item get(int i4) {
        return (Item) get0(i4);
    }

    public void set(int i4, CstType cstType, CstType cstType2, CstString cstString, int i5) {
        set0(i4, new Item(cstType, cstType2, cstString, i5));
    }
}
