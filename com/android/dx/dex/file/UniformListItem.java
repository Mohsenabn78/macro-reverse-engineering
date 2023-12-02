package com.android.dx.dex.file;

import com.android.dx.dex.file.OffsettedItem;
import com.android.dx.util.AnnotatedOutput;
import com.android.dx.util.Hex;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.util.List;

/* loaded from: classes2.dex */
public final class UniformListItem<T extends OffsettedItem> extends OffsettedItem {
    private static final int HEADER_SIZE = 4;
    private final ItemType itemType;
    private final List<T> items;

    public UniformListItem(ItemType itemType, List<T> list) {
        super(getAlignment(list), writeSize(list));
        if (itemType != null) {
            this.items = list;
            this.itemType = itemType;
            return;
        }
        throw new NullPointerException("itemType == null");
    }

    private static int getAlignment(List<? extends OffsettedItem> list) {
        try {
            return Math.max(4, list.get(0).getAlignment());
        } catch (IndexOutOfBoundsException unused) {
            throw new IllegalArgumentException("items.size() == 0");
        } catch (NullPointerException unused2) {
            throw new NullPointerException("items == null");
        }
    }

    private int headerSize() {
        return getAlignment();
    }

    private static int writeSize(List<? extends OffsettedItem> list) {
        return (list.size() * list.get(0).writeSize()) + getAlignment(list);
    }

    @Override // com.android.dx.dex.file.Item
    public void addContents(DexFile dexFile) {
        for (T t3 : this.items) {
            t3.addContents(dexFile);
        }
    }

    public final List<T> getItems() {
        return this.items;
    }

    @Override // com.android.dx.dex.file.Item
    public ItemType itemType() {
        return this.itemType;
    }

    @Override // com.android.dx.dex.file.OffsettedItem
    protected void place0(Section section, int i4) {
        int headerSize = i4 + headerSize();
        boolean z3 = true;
        int i5 = -1;
        int i6 = -1;
        for (T t3 : this.items) {
            int writeSize = t3.writeSize();
            if (z3) {
                i6 = t3.getAlignment();
                i5 = writeSize;
                z3 = false;
            } else if (writeSize == i5) {
                if (t3.getAlignment() != i6) {
                    throw new UnsupportedOperationException("item alignment mismatch");
                }
            } else {
                throw new UnsupportedOperationException("item size mismatch");
            }
            headerSize = t3.place(section, headerSize) + writeSize;
        }
    }

    @Override // com.android.dx.dex.file.OffsettedItem
    public final String toHuman() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("{");
        boolean z3 = true;
        for (T t3 : this.items) {
            if (z3) {
                z3 = false;
            } else {
                stringBuffer.append(", ");
            }
            stringBuffer.append(t3.toHuman());
        }
        stringBuffer.append("}");
        return stringBuffer.toString();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append(UniformListItem.class.getName());
        stringBuffer.append(this.items);
        return stringBuffer.toString();
    }

    @Override // com.android.dx.dex.file.OffsettedItem
    protected void writeTo0(DexFile dexFile, AnnotatedOutput annotatedOutput) {
        int size = this.items.size();
        if (annotatedOutput.annotates()) {
            annotatedOutput.annotate(0, offsetString() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + typeName());
            StringBuilder sb = new StringBuilder();
            sb.append("  size: ");
            sb.append(Hex.u4(size));
            annotatedOutput.annotate(4, sb.toString());
        }
        annotatedOutput.writeInt(size);
        for (T t3 : this.items) {
            t3.writeTo(dexFile, annotatedOutput);
        }
    }
}
