package com.hippo.quickjs.android;

import androidx.annotation.Nullable;

/* loaded from: classes6.dex */
public final class JSFunction extends JSObject {
    /* JADX INFO: Access modifiers changed from: package-private */
    public JSFunction(long j4, JSContext jSContext) {
        super(j4, jSContext, null);
    }

    public JSValue invoke(@Nullable JSValue jSValue, JSValue[] jSValueArr) {
        long j4;
        JSValue d4;
        if (jSValue != null) {
            a(jSValue);
        }
        for (JSValue jSValue2 : jSValueArr) {
            a(jSValue2);
        }
        long[] jArr = new long[jSValueArr.length];
        for (int i4 = 0; i4 < jSValueArr.length; i4++) {
            jArr[i4] = jSValueArr[i4].f34064a;
        }
        synchronized (this.f34065b.f34054c) {
            long b4 = this.f34065b.b();
            long j5 = this.f34064a;
            if (jSValue != null) {
                j4 = jSValue.f34064a;
            } else {
                j4 = 0;
            }
            d4 = this.f34065b.d(QuickJS.invokeValueFunction(b4, j5, j4, jArr));
        }
        return d4;
    }
}
