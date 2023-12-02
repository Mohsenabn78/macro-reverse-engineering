package com.android.dx.dex.file;

import com.android.dx.util.AnnotatedOutput;
import com.android.dx.util.Hex;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class MapItem extends OffsettedItem {
    private static final int ALIGNMENT = 4;
    private static final int WRITE_SIZE = 12;
    private final Item firstItem;
    private final int itemCount;
    private final Item lastItem;
    private final Section section;
    private final ItemType type;

    private MapItem(ItemType itemType, Section section, Item item, Item item2, int i4) {
        super(4, 12);
        if (itemType == null) {
            throw new NullPointerException("type == null");
        }
        if (section == null) {
            throw new NullPointerException("section == null");
        }
        if (item == null) {
            throw new NullPointerException("firstItem == null");
        }
        if (item2 == null) {
            throw new NullPointerException("lastItem == null");
        }
        if (i4 > 0) {
            this.type = itemType;
            this.section = section;
            this.firstItem = item;
            this.lastItem = item2;
            this.itemCount = i4;
            return;
        }
        throw new IllegalArgumentException("itemCount <= 0");
    }

    public static void addMap(Section[] sectionArr, MixedItemSection mixedItemSection) {
        if (sectionArr != null) {
            if (mixedItemSection.items().size() == 0) {
                ArrayList arrayList = new ArrayList(50);
                for (Section section : sectionArr) {
                    ItemType itemType = null;
                    Item item = null;
                    Item item2 = null;
                    int i4 = 0;
                    for (Item item3 : section.items()) {
                        ItemType itemType2 = item3.itemType();
                        if (itemType2 != itemType) {
                            if (i4 != 0) {
                                arrayList.add(new MapItem(itemType, section, item, item2, i4));
                            }
                            item = item3;
                            itemType = itemType2;
                            i4 = 0;
                        }
                        i4++;
                        item2 = item3;
                    }
                    if (i4 != 0) {
                        arrayList.add(new MapItem(itemType, section, item, item2, i4));
                    } else if (section == mixedItemSection) {
                        arrayList.add(new MapItem(mixedItemSection));
                    }
                }
                mixedItemSection.add(new UniformListItem(ItemType.TYPE_MAP_LIST, arrayList));
                return;
            }
            throw new IllegalArgumentException("mapSection.items().size() != 0");
        }
        throw new NullPointerException("sections == null");
    }

    @Override // com.android.dx.dex.file.Item
    public ItemType itemType() {
        return ItemType.TYPE_MAP_ITEM;
    }

    @Override // com.android.dx.dex.file.OffsettedItem
    public final String toHuman() {
        return toString();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append(MapItem.class.getName());
        stringBuffer.append('{');
        stringBuffer.append(this.section.toString());
        stringBuffer.append(' ');
        stringBuffer.append(this.type.toHuman());
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    @Override // com.android.dx.dex.file.OffsettedItem
    protected void writeTo0(DexFile dexFile, AnnotatedOutput annotatedOutput) {
        int absoluteItemOffset;
        int mapValue = this.type.getMapValue();
        Item item = this.firstItem;
        if (item == null) {
            absoluteItemOffset = this.section.getFileOffset();
        } else {
            absoluteItemOffset = this.section.getAbsoluteItemOffset(item);
        }
        if (annotatedOutput.annotates()) {
            annotatedOutput.annotate(0, offsetString() + ' ' + this.type.getTypeName() + " map");
            annotatedOutput.annotate(2, "  type:   " + Hex.u2(mapValue) + " // " + this.type.toString());
            annotatedOutput.annotate(2, "  unused: 0");
            StringBuilder sb = new StringBuilder();
            sb.append("  size:   ");
            sb.append(Hex.u4(this.itemCount));
            annotatedOutput.annotate(4, sb.toString());
            annotatedOutput.annotate(4, "  offset: " + Hex.u4(absoluteItemOffset));
        }
        annotatedOutput.writeShort(mapValue);
        annotatedOutput.writeShort(0);
        annotatedOutput.writeInt(this.itemCount);
        annotatedOutput.writeInt(absoluteItemOffset);
    }

    private MapItem(Section section) {
        super(4, 12);
        if (section != null) {
            this.type = ItemType.TYPE_MAP_LIST;
            this.section = section;
            this.firstItem = null;
            this.lastItem = null;
            this.itemCount = 1;
            return;
        }
        throw new NullPointerException("section == null");
    }

    @Override // com.android.dx.dex.file.Item
    public void addContents(DexFile dexFile) {
    }
}
