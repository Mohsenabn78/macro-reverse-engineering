package com.android.dx.cf.attrib;

import com.android.dx.cf.code.LocalVariableList;

/* loaded from: classes2.dex */
public final class AttLocalVariableTypeTable extends BaseLocalVariables {
    public static final String ATTRIBUTE_NAME = "LocalVariableTypeTable";

    public AttLocalVariableTypeTable(LocalVariableList localVariableList) {
        super(ATTRIBUTE_NAME, localVariableList);
    }
}
