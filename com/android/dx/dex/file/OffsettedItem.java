package com.android.dx.dex.file;

import com.android.dex.util.ExceptionWithContext;
import com.android.dx.util.AnnotatedOutput;
import net.bytebuddy.pool.TypePool;

/* loaded from: classes2.dex */
public abstract class OffsettedItem extends Item implements Comparable<OffsettedItem> {
    private Section addedTo;
    private final int alignment;
    private int offset;
    private int writeSize;

    public OffsettedItem(int i4, int i5) {
        Section.validateAlignment(i4);
        if (i5 >= -1) {
            this.alignment = i4;
            this.writeSize = i5;
            this.addedTo = null;
            this.offset = -1;
            return;
        }
        throw new IllegalArgumentException("writeSize < -1");
    }

    public static int getAbsoluteOffsetOr0(OffsettedItem offsettedItem) {
        if (offsettedItem == null) {
            return 0;
        }
        return offsettedItem.getAbsoluteOffset();
    }

    protected int compareTo0(OffsettedItem offsettedItem) {
        throw new UnsupportedOperationException("unsupported");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        OffsettedItem offsettedItem = (OffsettedItem) obj;
        if (itemType() == offsettedItem.itemType() && compareTo0(offsettedItem) == 0) {
            return true;
        }
        return false;
    }

    public final int getAbsoluteOffset() {
        int i4 = this.offset;
        if (i4 >= 0) {
            return this.addedTo.getAbsoluteOffset(i4);
        }
        throw new RuntimeException("offset not yet known");
    }

    public final int getAlignment() {
        return this.alignment;
    }

    public final int getRelativeOffset() {
        int i4 = this.offset;
        if (i4 >= 0) {
            return i4;
        }
        throw new RuntimeException("offset not yet known");
    }

    public final String offsetString() {
        return TypePool.Default.LazyTypeDescription.GenericTypeToken.COMPONENT_TYPE_PATH + Integer.toHexString(getAbsoluteOffset()) + ']';
    }

    public final int place(Section section, int i4) {
        if (section != null) {
            if (i4 >= 0) {
                if (this.addedTo == null) {
                    int i5 = this.alignment - 1;
                    int i6 = (i4 + i5) & (~i5);
                    this.addedTo = section;
                    this.offset = i6;
                    place0(section, i6);
                    return i6;
                }
                throw new RuntimeException("already written");
            }
            throw new IllegalArgumentException("offset < 0");
        }
        throw new NullPointerException("addedTo == null");
    }

    public final void setWriteSize(int i4) {
        if (i4 >= 0) {
            if (this.writeSize < 0) {
                this.writeSize = i4;
                return;
            }
            throw new UnsupportedOperationException("writeSize already set");
        }
        throw new IllegalArgumentException("writeSize < 0");
    }

    public abstract String toHuman();

    @Override // com.android.dx.dex.file.Item
    public final int writeSize() {
        int i4 = this.writeSize;
        if (i4 >= 0) {
            return i4;
        }
        throw new UnsupportedOperationException("writeSize is unknown");
    }

    @Override // com.android.dx.dex.file.Item
    public final void writeTo(DexFile dexFile, AnnotatedOutput annotatedOutput) {
        annotatedOutput.alignTo(this.alignment);
        try {
            if (this.writeSize >= 0) {
                annotatedOutput.assertCursor(getAbsoluteOffset());
                writeTo0(dexFile, annotatedOutput);
                return;
            }
            throw new UnsupportedOperationException("writeSize is unknown");
        } catch (RuntimeException e4) {
            throw ExceptionWithContext.withContext(e4, "...while writing " + this);
        }
    }

    protected abstract void writeTo0(DexFile dexFile, AnnotatedOutput annotatedOutput);

    @Override // java.lang.Comparable
    public final int compareTo(OffsettedItem offsettedItem) {
        if (this == offsettedItem) {
            return 0;
        }
        ItemType itemType = itemType();
        ItemType itemType2 = offsettedItem.itemType();
        if (itemType != itemType2) {
            return itemType.compareTo(itemType2);
        }
        return compareTo0(offsettedItem);
    }

    protected void place0(Section section, int i4) {
    }
}
