package com.android.dx.dex.file;

import com.android.dx.rop.cst.Constant;
import com.android.dx.rop.cst.CstType;
import com.android.dx.rop.type.Type;
import com.android.dx.rop.type.TypeList;
import com.android.dx.util.AnnotatedOutput;
import com.android.dx.util.Hex;
import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeMap;

/* loaded from: classes2.dex */
public final class ClassDefsSection extends UniformItemSection {
    private final TreeMap<Type, ClassDefItem> classDefs;
    private ArrayList<ClassDefItem> orderedDefs;

    public ClassDefsSection(DexFile dexFile) {
        super("class_defs", dexFile, 4);
        this.classDefs = new TreeMap<>();
        this.orderedDefs = null;
    }

    private int orderItems0(Type type, int i4, int i5) {
        ClassDefItem classDefItem = this.classDefs.get(type);
        if (classDefItem != null && !classDefItem.hasIndex()) {
            if (i5 >= 0) {
                int i6 = i5 - 1;
                CstType superclass = classDefItem.getSuperclass();
                if (superclass != null) {
                    i4 = orderItems0(superclass.getClassType(), i4, i6);
                }
                TypeList interfaces = classDefItem.getInterfaces();
                int size = interfaces.size();
                for (int i7 = 0; i7 < size; i7++) {
                    i4 = orderItems0(interfaces.getType(i7), i4, i6);
                }
                classDefItem.setIndex(i4);
                this.orderedDefs.add(classDefItem);
                return i4 + 1;
            }
            throw new RuntimeException("class circularity with " + type);
        }
        return i4;
    }

    public void add(ClassDefItem classDefItem) {
        try {
            Type classType = classDefItem.getThisClass().getClassType();
            throwIfPrepared();
            if (this.classDefs.get(classType) == null) {
                this.classDefs.put(classType, classDefItem);
                return;
            }
            throw new IllegalArgumentException("already added: " + classType);
        } catch (NullPointerException unused) {
            throw new NullPointerException("clazz == null");
        }
    }

    @Override // com.android.dx.dex.file.UniformItemSection
    public IndexedItem get(Constant constant) {
        if (constant != null) {
            throwIfNotPrepared();
            ClassDefItem classDefItem = this.classDefs.get(((CstType) constant).getClassType());
            if (classDefItem != null) {
                return classDefItem;
            }
            throw new IllegalArgumentException("not found");
        }
        throw new NullPointerException("cst == null");
    }

    @Override // com.android.dx.dex.file.Section
    public Collection<? extends Item> items() {
        ArrayList<ClassDefItem> arrayList = this.orderedDefs;
        if (arrayList != null) {
            return arrayList;
        }
        return this.classDefs.values();
    }

    @Override // com.android.dx.dex.file.UniformItemSection
    protected void orderItems() {
        int size = this.classDefs.size();
        this.orderedDefs = new ArrayList<>(size);
        int i4 = 0;
        for (Type type : this.classDefs.keySet()) {
            i4 = orderItems0(type, i4, size - i4);
        }
    }

    public void writeHeaderPart(AnnotatedOutput annotatedOutput) {
        int fileOffset;
        throwIfNotPrepared();
        int size = this.classDefs.size();
        if (size == 0) {
            fileOffset = 0;
        } else {
            fileOffset = getFileOffset();
        }
        if (annotatedOutput.annotates()) {
            annotatedOutput.annotate(4, "class_defs_size: " + Hex.u4(size));
            annotatedOutput.annotate(4, "class_defs_off:  " + Hex.u4(fileOffset));
        }
        annotatedOutput.writeInt(size);
        annotatedOutput.writeInt(fileOffset);
    }
}
