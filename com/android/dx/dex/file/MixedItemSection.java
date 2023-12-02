package com.android.dx.dex.file;

import com.android.dex.util.ExceptionWithContext;
import com.android.dx.util.AnnotatedOutput;
import com.android.dx.util.Hex;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.TreeMap;

/* loaded from: classes2.dex */
public final class MixedItemSection extends Section {
    private static final Comparator<OffsettedItem> TYPE_SORTER = new Comparator<OffsettedItem>() { // from class: com.android.dx.dex.file.MixedItemSection.1
        @Override // java.util.Comparator
        public int compare(OffsettedItem offsettedItem, OffsettedItem offsettedItem2) {
            return offsettedItem.itemType().compareTo(offsettedItem2.itemType());
        }
    };
    private final HashMap<OffsettedItem, OffsettedItem> interns;
    private final ArrayList<OffsettedItem> items;
    private final SortType sort;
    private int writeSize;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.android.dx.dex.file.MixedItemSection$2  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$android$dx$dex$file$MixedItemSection$SortType;

        static {
            int[] iArr = new int[SortType.values().length];
            $SwitchMap$com$android$dx$dex$file$MixedItemSection$SortType = iArr;
            try {
                iArr[SortType.INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$android$dx$dex$file$MixedItemSection$SortType[SortType.TYPE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public enum SortType {
        NONE,
        TYPE,
        INSTANCE
    }

    public MixedItemSection(String str, DexFile dexFile, int i4, SortType sortType) {
        super(str, dexFile, i4);
        this.items = new ArrayList<>(100);
        this.interns = new HashMap<>(100);
        this.sort = sortType;
        this.writeSize = -1;
    }

    public void add(OffsettedItem offsettedItem) {
        throwIfPrepared();
        try {
            if (offsettedItem.getAlignment() <= getAlignment()) {
                this.items.add(offsettedItem);
                return;
            }
            throw new IllegalArgumentException("incompatible item alignment");
        } catch (NullPointerException unused) {
            throw new NullPointerException("item == null");
        }
    }

    public <T extends OffsettedItem> T get(T t3) {
        throwIfNotPrepared();
        T t4 = (T) this.interns.get(t3);
        if (t4 != null) {
            return t4;
        }
        throw new NoSuchElementException(t3.toString());
    }

    @Override // com.android.dx.dex.file.Section
    public int getAbsoluteItemOffset(Item item) {
        return ((OffsettedItem) item).getAbsoluteOffset();
    }

    public synchronized <T extends OffsettedItem> T intern(T t3) {
        throwIfPrepared();
        T t4 = (T) this.interns.get(t3);
        if (t4 != null) {
            return t4;
        }
        add(t3);
        this.interns.put(t3, t3);
        return t3;
    }

    @Override // com.android.dx.dex.file.Section
    public Collection<? extends Item> items() {
        return this.items;
    }

    public void placeItems() {
        throwIfNotPrepared();
        int i4 = AnonymousClass2.$SwitchMap$com$android$dx$dex$file$MixedItemSection$SortType[this.sort.ordinal()];
        if (i4 != 1) {
            if (i4 == 2) {
                Collections.sort(this.items, TYPE_SORTER);
            }
        } else {
            Collections.sort(this.items);
        }
        int size = this.items.size();
        int i5 = 0;
        for (int i6 = 0; i6 < size; i6++) {
            OffsettedItem offsettedItem = this.items.get(i6);
            try {
                int place = offsettedItem.place(this, i5);
                if (place >= i5) {
                    i5 = offsettedItem.writeSize() + place;
                } else {
                    throw new RuntimeException("bogus place() result for " + offsettedItem);
                }
            } catch (RuntimeException e4) {
                throw ExceptionWithContext.withContext(e4, "...while placing " + offsettedItem);
            }
        }
        this.writeSize = i5;
    }

    @Override // com.android.dx.dex.file.Section
    protected void prepare0() {
        DexFile file = getFile();
        int i4 = 0;
        while (true) {
            int size = this.items.size();
            if (i4 >= size) {
                return;
            }
            while (i4 < size) {
                this.items.get(i4).addContents(file);
                i4++;
            }
        }
    }

    public int size() {
        return this.items.size();
    }

    public void writeHeaderPart(AnnotatedOutput annotatedOutput) {
        int fileOffset;
        throwIfNotPrepared();
        int i4 = this.writeSize;
        if (i4 != -1) {
            if (i4 == 0) {
                fileOffset = 0;
            } else {
                fileOffset = getFileOffset();
            }
            String name = getName();
            if (name == null) {
                name = "<unnamed>";
            }
            char[] cArr = new char[15 - name.length()];
            Arrays.fill(cArr, ' ');
            String str = new String(cArr);
            if (annotatedOutput.annotates()) {
                annotatedOutput.annotate(4, name + "_size:" + str + Hex.u4(i4));
                annotatedOutput.annotate(4, name + "_off: " + str + Hex.u4(fileOffset));
            }
            annotatedOutput.writeInt(i4);
            annotatedOutput.writeInt(fileOffset);
            return;
        }
        throw new RuntimeException("write size not yet set");
    }

    public void writeIndexAnnotation(AnnotatedOutput annotatedOutput, ItemType itemType, String str) {
        throwIfNotPrepared();
        TreeMap treeMap = new TreeMap();
        Iterator<OffsettedItem> it = this.items.iterator();
        while (it.hasNext()) {
            OffsettedItem next = it.next();
            if (next.itemType() == itemType) {
                treeMap.put(next.toHuman(), next);
            }
        }
        if (treeMap.size() == 0) {
            return;
        }
        annotatedOutput.annotate(0, str);
        for (Map.Entry entry : treeMap.entrySet()) {
            annotatedOutput.annotate(0, ((OffsettedItem) entry.getValue()).offsetString() + ' ' + ((String) entry.getKey()) + '\n');
        }
    }

    @Override // com.android.dx.dex.file.Section
    public int writeSize() {
        throwIfNotPrepared();
        return this.writeSize;
    }

    @Override // com.android.dx.dex.file.Section
    protected void writeTo0(AnnotatedOutput annotatedOutput) {
        boolean annotates = annotatedOutput.annotates();
        DexFile file = getFile();
        Iterator<OffsettedItem> it = this.items.iterator();
        int i4 = 0;
        boolean z3 = true;
        while (it.hasNext()) {
            OffsettedItem next = it.next();
            if (annotates) {
                if (z3) {
                    z3 = false;
                } else {
                    annotatedOutput.annotate(0, "\n");
                }
            }
            int alignment = next.getAlignment() - 1;
            int i5 = (~alignment) & (i4 + alignment);
            if (i4 != i5) {
                annotatedOutput.writeZeroes(i5 - i4);
                i4 = i5;
            }
            next.writeTo(file, annotatedOutput);
            i4 += next.writeSize();
        }
        if (i4 == this.writeSize) {
            return;
        }
        throw new RuntimeException("output size mismatch");
    }
}
