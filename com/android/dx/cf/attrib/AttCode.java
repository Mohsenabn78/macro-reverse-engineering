package com.android.dx.cf.attrib;

import com.android.dx.cf.code.ByteCatchList;
import com.android.dx.cf.code.BytecodeArray;
import com.android.dx.cf.iface.AttributeList;
import com.android.dx.util.MutabilityException;

/* loaded from: classes2.dex */
public final class AttCode extends BaseAttribute {
    public static final String ATTRIBUTE_NAME = "Code";
    private final AttributeList attributes;
    private final ByteCatchList catches;
    private final BytecodeArray code;
    private final int maxLocals;
    private final int maxStack;

    public AttCode(int i4, int i5, BytecodeArray bytecodeArray, ByteCatchList byteCatchList, AttributeList attributeList) {
        super(ATTRIBUTE_NAME);
        if (i4 >= 0) {
            if (i5 >= 0) {
                if (bytecodeArray != null) {
                    try {
                        if (!byteCatchList.isMutable()) {
                            try {
                                if (!attributeList.isMutable()) {
                                    this.maxStack = i4;
                                    this.maxLocals = i5;
                                    this.code = bytecodeArray;
                                    this.catches = byteCatchList;
                                    this.attributes = attributeList;
                                    return;
                                }
                                throw new MutabilityException("attributes.isMutable()");
                            } catch (NullPointerException unused) {
                                throw new NullPointerException("attributes == null");
                            }
                        }
                        throw new MutabilityException("catches.isMutable()");
                    } catch (NullPointerException unused2) {
                        throw new NullPointerException("catches == null");
                    }
                }
                throw new NullPointerException("code == null");
            }
            throw new IllegalArgumentException("maxLocals < 0");
        }
        throw new IllegalArgumentException("maxStack < 0");
    }

    @Override // com.android.dx.cf.iface.Attribute
    public int byteLength() {
        return this.code.byteLength() + 10 + this.catches.byteLength() + this.attributes.byteLength();
    }

    public AttributeList getAttributes() {
        return this.attributes;
    }

    public ByteCatchList getCatches() {
        return this.catches;
    }

    public BytecodeArray getCode() {
        return this.code;
    }

    public int getMaxLocals() {
        return this.maxLocals;
    }

    public int getMaxStack() {
        return this.maxStack;
    }
}
