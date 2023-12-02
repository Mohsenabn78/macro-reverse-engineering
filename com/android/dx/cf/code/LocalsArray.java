package com.android.dx.cf.code;

import com.android.dex.util.ExceptionWithContext;
import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.type.Type;
import com.android.dx.rop.type.TypeBearer;
import com.android.dx.util.MutabilityControl;
import com.android.dx.util.ToHuman;

/* loaded from: classes2.dex */
public abstract class LocalsArray extends MutabilityControl implements ToHuman {
    /* JADX INFO: Access modifiers changed from: protected */
    public LocalsArray(boolean z3) {
        super(z3);
    }

    public abstract void annotate(ExceptionWithContext exceptionWithContext);

    public abstract LocalsArray copy();

    public abstract TypeBearer get(int i4);

    public abstract TypeBearer getCategory1(int i4);

    public abstract TypeBearer getCategory2(int i4);

    public abstract int getMaxLocals();

    public abstract TypeBearer getOrNull(int i4);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract OneLocalsArray getPrimary();

    public abstract void invalidate(int i4);

    public abstract void makeInitialized(Type type);

    public abstract LocalsArray merge(LocalsArray localsArray);

    public abstract LocalsArraySet mergeWithSubroutineCaller(LocalsArray localsArray, int i4);

    public abstract void set(int i4, TypeBearer typeBearer);

    public abstract void set(RegisterSpec registerSpec);
}
