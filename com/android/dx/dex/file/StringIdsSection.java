package com.android.dx.dex.file;

import com.android.dx.rop.cst.Constant;
import com.android.dx.rop.cst.CstNat;
import com.android.dx.rop.cst.CstString;
import com.android.dx.util.AnnotatedOutput;
import com.android.dx.util.Hex;
import java.util.Collection;
import java.util.TreeMap;

/* loaded from: classes2.dex */
public final class StringIdsSection extends UniformItemSection {
    private final TreeMap<CstString, StringIdItem> strings;

    public StringIdsSection(DexFile dexFile) {
        super("string_ids", dexFile, 4);
        this.strings = new TreeMap<>();
    }

    @Override // com.android.dx.dex.file.UniformItemSection
    public IndexedItem get(Constant constant) {
        if (constant != null) {
            throwIfNotPrepared();
            StringIdItem stringIdItem = this.strings.get((CstString) constant);
            if (stringIdItem != null) {
                return stringIdItem;
            }
            throw new IllegalArgumentException("not found");
        }
        throw new NullPointerException("cst == null");
    }

    public int indexOf(CstString cstString) {
        if (cstString != null) {
            throwIfNotPrepared();
            StringIdItem stringIdItem = this.strings.get(cstString);
            if (stringIdItem != null) {
                return stringIdItem.getIndex();
            }
            throw new IllegalArgumentException("not found");
        }
        throw new NullPointerException("string == null");
    }

    public StringIdItem intern(String str) {
        return intern(new StringIdItem(new CstString(str)));
    }

    @Override // com.android.dx.dex.file.Section
    public Collection<? extends Item> items() {
        return this.strings.values();
    }

    @Override // com.android.dx.dex.file.UniformItemSection
    protected void orderItems() {
        int i4 = 0;
        for (StringIdItem stringIdItem : this.strings.values()) {
            stringIdItem.setIndex(i4);
            i4++;
        }
    }

    public void writeHeaderPart(AnnotatedOutput annotatedOutput) {
        int fileOffset;
        throwIfNotPrepared();
        int size = this.strings.size();
        if (size == 0) {
            fileOffset = 0;
        } else {
            fileOffset = getFileOffset();
        }
        if (annotatedOutput.annotates()) {
            annotatedOutput.annotate(4, "string_ids_size: " + Hex.u4(size));
            annotatedOutput.annotate(4, "string_ids_off:  " + Hex.u4(fileOffset));
        }
        annotatedOutput.writeInt(size);
        annotatedOutput.writeInt(fileOffset);
    }

    public StringIdItem intern(CstString cstString) {
        return intern(new StringIdItem(cstString));
    }

    public synchronized StringIdItem intern(StringIdItem stringIdItem) {
        if (stringIdItem != null) {
            throwIfPrepared();
            CstString value = stringIdItem.getValue();
            StringIdItem stringIdItem2 = this.strings.get(value);
            if (stringIdItem2 != null) {
                return stringIdItem2;
            }
            this.strings.put(value, stringIdItem);
            return stringIdItem;
        }
        throw new NullPointerException("string == null");
    }

    public synchronized void intern(CstNat cstNat) {
        intern(cstNat.getName());
        intern(cstNat.getDescriptor());
    }
}
