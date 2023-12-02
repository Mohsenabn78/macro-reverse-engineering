package com.hippo.quickjs.android;

/* loaded from: classes6.dex */
public class JSObject extends JSValue {
    public static int PROP_FLAG_CONFIGURABLE = 1;
    public static int PROP_FLAG_ENUMERABLE = 4;
    public static int PROP_FLAG_WRITABLE = 2;

    /* renamed from: c  reason: collision with root package name */
    private final Object f34060c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSObject(long j4, JSContext jSContext, Object obj) {
        super(j4, jSContext);
        this.f34060c = obj;
    }

    public void defineProperty(int i4, JSValue jSValue, int i5) {
        if ((i5 & (-8)) == 0) {
            synchronized (this.f34065b.f34054c) {
                this.f34065b.b();
                if (!QuickJS.defineValueProperty(this.f34065b.f34052a, this.f34064a, i4, jSValue.f34064a, i5)) {
                    throw new JSEvaluationException(QuickJS.getException(this.f34065b.f34052a));
                }
            }
            return;
        }
        throw new IllegalArgumentException("Invalid flags: " + i5);
    }

    public Object getJavaObject() {
        return this.f34060c;
    }

    public JSValue getProperty(int i4) {
        JSValue d4;
        synchronized (this.f34065b.f34054c) {
            d4 = this.f34065b.d(QuickJS.getValueProperty(this.f34065b.b(), this.f34064a, i4));
        }
        return d4;
    }

    public void setProperty(int i4, JSValue jSValue) {
        a(jSValue);
        synchronized (this.f34065b.f34054c) {
            this.f34065b.b();
            if (!QuickJS.setValueProperty(this.f34065b.f34052a, this.f34064a, i4, jSValue.f34064a)) {
                throw new JSEvaluationException(QuickJS.getException(this.f34065b.f34052a));
            }
        }
    }

    public JSValue getProperty(String str) {
        JSValue d4;
        synchronized (this.f34065b.f34054c) {
            d4 = this.f34065b.d(QuickJS.getValueProperty(this.f34065b.b(), this.f34064a, str));
        }
        return d4;
    }

    public void defineProperty(String str, JSValue jSValue, int i4) {
        if ((i4 & (-8)) == 0) {
            synchronized (this.f34065b.f34054c) {
                this.f34065b.b();
                if (!QuickJS.defineValueProperty(this.f34065b.f34052a, this.f34064a, str, jSValue.f34064a, i4)) {
                    throw new JSEvaluationException(QuickJS.getException(this.f34065b.f34052a));
                }
            }
            return;
        }
        throw new IllegalArgumentException("Invalid flags: " + i4);
    }

    public void setProperty(String str, JSValue jSValue) {
        a(jSValue);
        synchronized (this.f34065b.f34054c) {
            this.f34065b.b();
            if (!QuickJS.setValueProperty(this.f34065b.f34052a, this.f34064a, str, jSValue.f34064a)) {
                throw new JSEvaluationException(QuickJS.getException(this.f34065b.f34052a));
            }
        }
    }
}
