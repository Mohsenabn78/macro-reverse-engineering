package com.android.dx.rop.type;

/* loaded from: classes2.dex */
public interface TypeList {
    Type getType(int i4);

    int getWordCount();

    boolean isMutable();

    int size();

    TypeList withAddedType(Type type);
}
