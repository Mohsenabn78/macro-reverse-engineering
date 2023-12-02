package com.android.dx.util;

import com.android.dex.util.ExceptionWithContext;

/* loaded from: classes2.dex */
public class MutabilityException extends ExceptionWithContext {
    public MutabilityException(String str) {
        super(str);
    }

    public MutabilityException(Throwable th) {
        super(th);
    }

    public MutabilityException(String str, Throwable th) {
        super(str, th);
    }
}
