package com.android.dx.dex.file;

import com.android.dex.DexIndexOverflowException;
import com.android.dx.command.dexer.Main;
import com.android.dx.rop.cst.Constant;
import com.android.dx.rop.cst.CstType;
import com.android.dx.rop.type.Type;
import com.android.dx.util.AnnotatedOutput;
import com.android.dx.util.Hex;
import java.util.Collection;
import java.util.Iterator;
import java.util.TreeMap;

/* loaded from: classes2.dex */
public final class TypeIdsSection extends UniformItemSection {
    private final TreeMap<Type, TypeIdItem> typeIds;

    public TypeIdsSection(DexFile dexFile) {
        super("type_ids", dexFile, 4);
        this.typeIds = new TreeMap<>();
    }

    @Override // com.android.dx.dex.file.UniformItemSection
    public IndexedItem get(Constant constant) {
        if (constant != null) {
            throwIfNotPrepared();
            TypeIdItem typeIdItem = this.typeIds.get(((CstType) constant).getClassType());
            if (typeIdItem != null) {
                return typeIdItem;
            }
            throw new IllegalArgumentException("not found: " + constant);
        }
        throw new NullPointerException("cst == null");
    }

    public int indexOf(Type type) {
        if (type != null) {
            throwIfNotPrepared();
            TypeIdItem typeIdItem = this.typeIds.get(type);
            if (typeIdItem != null) {
                return typeIdItem.getIndex();
            }
            throw new IllegalArgumentException("not found: " + type);
        }
        throw new NullPointerException("type == null");
    }

    public synchronized TypeIdItem intern(Type type) {
        TypeIdItem typeIdItem;
        if (type != null) {
            throwIfPrepared();
            typeIdItem = this.typeIds.get(type);
            if (typeIdItem == null) {
                typeIdItem = new TypeIdItem(new CstType(type));
                this.typeIds.put(type, typeIdItem);
            }
        } else {
            throw new NullPointerException("type == null");
        }
        return typeIdItem;
    }

    @Override // com.android.dx.dex.file.Section
    public Collection<? extends Item> items() {
        return this.typeIds.values();
    }

    @Override // com.android.dx.dex.file.UniformItemSection
    protected void orderItems() {
        Iterator<? extends Item> it = items().iterator();
        int i4 = 0;
        while (it.hasNext()) {
            ((TypeIdItem) it.next()).setIndex(i4);
            i4++;
        }
    }

    public void writeHeaderPart(AnnotatedOutput annotatedOutput) {
        int fileOffset;
        throwIfNotPrepared();
        int size = this.typeIds.size();
        if (size == 0) {
            fileOffset = 0;
        } else {
            fileOffset = getFileOffset();
        }
        if (size <= 65536) {
            if (annotatedOutput.annotates()) {
                annotatedOutput.annotate(4, "type_ids_size:   " + Hex.u4(size));
                annotatedOutput.annotate(4, "type_ids_off:    " + Hex.u4(fileOffset));
            }
            annotatedOutput.writeInt(size);
            annotatedOutput.writeInt(fileOffset);
            return;
        }
        throw new DexIndexOverflowException("Too many type references: " + size + "; max is 65536.\n" + Main.getTooManyIdsErrorMessage());
    }

    public int indexOf(CstType cstType) {
        if (cstType != null) {
            return indexOf(cstType.getClassType());
        }
        throw new NullPointerException("type == null");
    }

    public synchronized TypeIdItem intern(CstType cstType) {
        TypeIdItem typeIdItem;
        if (cstType != null) {
            throwIfPrepared();
            Type classType = cstType.getClassType();
            typeIdItem = this.typeIds.get(classType);
            if (typeIdItem == null) {
                typeIdItem = new TypeIdItem(cstType);
                this.typeIds.put(classType, typeIdItem);
            }
        } else {
            throw new NullPointerException("type == null");
        }
        return typeIdItem;
    }
}
