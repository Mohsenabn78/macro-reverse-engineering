package com.hippo.quickjs.android;

/* loaded from: classes6.dex */
public final class JSArray extends JSObject {
    /* JADX INFO: Access modifiers changed from: package-private */
    public JSArray(long j4, JSContext jSContext) {
        super(j4, jSContext, null);
    }

    public int getLength() {
        return ((JSNumber) getProperty("length").cast(JSNumber.class)).getInt();
    }
}
