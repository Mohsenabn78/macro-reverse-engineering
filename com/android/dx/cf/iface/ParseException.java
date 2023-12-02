package com.android.dx.cf.iface;

import com.android.dex.util.ExceptionWithContext;

/* loaded from: classes2.dex */
public class ParseException extends ExceptionWithContext {
    public ParseException(String str) {
        super(str);
    }

    public ParseException(Throwable th) {
        super(th);
    }

    public ParseException(String str, Throwable th) {
        super(str, th);
    }
}
