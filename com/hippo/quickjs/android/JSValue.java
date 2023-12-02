package com.hippo.quickjs.android;

/* loaded from: classes6.dex */
public abstract class JSValue {

    /* renamed from: a  reason: collision with root package name */
    final long f34064a;

    /* renamed from: b  reason: collision with root package name */
    final JSContext f34065b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSValue(long j4, JSContext jSContext) {
        this.f34064a = j4;
        this.f34065b = jSContext;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(JSValue jSValue) {
        if (jSValue.f34065b == this.f34065b) {
            return;
        }
        throw new IllegalStateException("Two JSValues are not from the same JSContext");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends JSValue> T cast(Class<T> cls) {
        if (cls.isInstance(this)) {
            return this;
        }
        throw new JSDataException("expected: " + cls.getSimpleName() + ", actual: " + getClass().getSimpleName());
    }
}
