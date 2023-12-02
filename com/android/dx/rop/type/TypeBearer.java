package com.android.dx.rop.type;

import com.android.dx.util.ToHuman;

/* loaded from: classes2.dex */
public interface TypeBearer extends ToHuman {
    int getBasicFrameType();

    int getBasicType();

    TypeBearer getFrameType();

    Type getType();

    boolean isConstant();
}
