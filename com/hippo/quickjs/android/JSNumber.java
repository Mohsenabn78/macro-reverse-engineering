package com.hippo.quickjs.android;

/* loaded from: classes6.dex */
public abstract class JSNumber extends JSValue {
    /* JADX INFO: Access modifiers changed from: package-private */
    public JSNumber(long j4, JSContext jSContext) {
        super(j4, jSContext);
    }

    public abstract byte getByte();

    public abstract double getDouble();

    public abstract float getFloat();

    public abstract int getInt();

    public abstract long getLong();

    public abstract short getShort();
}
