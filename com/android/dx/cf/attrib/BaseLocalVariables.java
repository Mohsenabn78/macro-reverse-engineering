package com.android.dx.cf.attrib;

import com.android.dx.cf.code.LocalVariableList;
import com.android.dx.util.MutabilityException;

/* loaded from: classes2.dex */
public abstract class BaseLocalVariables extends BaseAttribute {
    private final LocalVariableList localVariables;

    public BaseLocalVariables(String str, LocalVariableList localVariableList) {
        super(str);
        try {
            if (!localVariableList.isMutable()) {
                this.localVariables = localVariableList;
                return;
            }
            throw new MutabilityException("localVariables.isMutable()");
        } catch (NullPointerException unused) {
            throw new NullPointerException("localVariables == null");
        }
    }

    @Override // com.android.dx.cf.iface.Attribute
    public final int byteLength() {
        return (this.localVariables.size() * 10) + 8;
    }

    public final LocalVariableList getLocalVariables() {
        return this.localVariables;
    }
}
