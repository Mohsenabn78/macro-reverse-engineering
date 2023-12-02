package com.android.dx.cf.code;

import com.android.dx.cf.attrib.AttCode;
import com.android.dx.cf.attrib.AttLineNumberTable;
import com.android.dx.cf.attrib.AttLocalVariableTable;
import com.android.dx.cf.attrib.AttLocalVariableTypeTable;
import com.android.dx.cf.iface.AttributeList;
import com.android.dx.cf.iface.ClassFile;
import com.android.dx.cf.iface.Method;
import com.android.dx.rop.code.SourcePosition;
import com.android.dx.rop.cst.CstNat;
import com.android.dx.rop.cst.CstString;
import com.android.dx.rop.cst.CstType;
import com.android.dx.rop.type.Prototype;

/* loaded from: classes2.dex */
public final class ConcreteMethod implements Method {
    private final boolean accSuper;
    private final AttCode attCode;
    private final LineNumberList lineNumbers;
    private final LocalVariableList localVariables;
    private final Method method;
    private final CstString sourceFile;

    public ConcreteMethod(Method method, ClassFile classFile, boolean z3, boolean z4) {
        this(method, classFile.getAccessFlags(), classFile.getSourceFile(), z3, z4);
    }

    public boolean getAccSuper() {
        return this.accSuper;
    }

    @Override // com.android.dx.cf.iface.Member
    public int getAccessFlags() {
        return this.method.getAccessFlags();
    }

    @Override // com.android.dx.cf.iface.Member, com.android.dx.cf.iface.HasAttribute
    public AttributeList getAttributes() {
        return this.method.getAttributes();
    }

    public ByteCatchList getCatches() {
        return this.attCode.getCatches();
    }

    public BytecodeArray getCode() {
        return this.attCode.getCode();
    }

    @Override // com.android.dx.cf.iface.Member
    public CstType getDefiningClass() {
        return this.method.getDefiningClass();
    }

    @Override // com.android.dx.cf.iface.Member
    public CstString getDescriptor() {
        return this.method.getDescriptor();
    }

    @Override // com.android.dx.cf.iface.Method
    public Prototype getEffectiveDescriptor() {
        return this.method.getEffectiveDescriptor();
    }

    public LineNumberList getLineNumbers() {
        return this.lineNumbers;
    }

    public LocalVariableList getLocalVariables() {
        return this.localVariables;
    }

    public int getMaxLocals() {
        return this.attCode.getMaxLocals();
    }

    public int getMaxStack() {
        return this.attCode.getMaxStack();
    }

    @Override // com.android.dx.cf.iface.Member
    public CstString getName() {
        return this.method.getName();
    }

    @Override // com.android.dx.cf.iface.Member
    public CstNat getNat() {
        return this.method.getNat();
    }

    public SourcePosition makeSourcePosistion(int i4) {
        return new SourcePosition(this.sourceFile, i4, this.lineNumbers.pcToLine(i4));
    }

    public ConcreteMethod(Method method, int i4, CstString cstString, boolean z3, boolean z4) {
        this.method = method;
        this.accSuper = (i4 & 32) != 0;
        this.sourceFile = cstString;
        AttCode attCode = (AttCode) method.getAttributes().findFirst(AttCode.ATTRIBUTE_NAME);
        this.attCode = attCode;
        AttributeList attributes = attCode.getAttributes();
        LineNumberList lineNumberList = LineNumberList.EMPTY;
        if (z3) {
            for (AttLineNumberTable attLineNumberTable = (AttLineNumberTable) attributes.findFirst(AttLineNumberTable.ATTRIBUTE_NAME); attLineNumberTable != null; attLineNumberTable = (AttLineNumberTable) attributes.findNext(attLineNumberTable)) {
                lineNumberList = LineNumberList.concat(lineNumberList, attLineNumberTable.getLineNumbers());
            }
        }
        this.lineNumbers = lineNumberList;
        LocalVariableList localVariableList = LocalVariableList.EMPTY;
        if (z4) {
            for (AttLocalVariableTable attLocalVariableTable = (AttLocalVariableTable) attributes.findFirst(AttLocalVariableTable.ATTRIBUTE_NAME); attLocalVariableTable != null; attLocalVariableTable = (AttLocalVariableTable) attributes.findNext(attLocalVariableTable)) {
                localVariableList = LocalVariableList.concat(localVariableList, attLocalVariableTable.getLocalVariables());
            }
            LocalVariableList localVariableList2 = LocalVariableList.EMPTY;
            for (AttLocalVariableTypeTable attLocalVariableTypeTable = (AttLocalVariableTypeTable) attributes.findFirst(AttLocalVariableTypeTable.ATTRIBUTE_NAME); attLocalVariableTypeTable != null; attLocalVariableTypeTable = (AttLocalVariableTypeTable) attributes.findNext(attLocalVariableTypeTable)) {
                localVariableList2 = LocalVariableList.concat(localVariableList2, attLocalVariableTypeTable.getLocalVariables());
            }
            if (localVariableList2.size() != 0) {
                localVariableList = LocalVariableList.mergeDescriptorsAndSignatures(localVariableList, localVariableList2);
            }
        }
        this.localVariables = localVariableList;
    }
}
