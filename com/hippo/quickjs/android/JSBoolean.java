package com.hippo.quickjs.android;

/* loaded from: classes6.dex */
public class JSBoolean extends JSValue {

    /* renamed from: c  reason: collision with root package name */
    private final boolean f34051c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSBoolean(long j4, JSContext jSContext, boolean z3) {
        super(j4, jSContext);
        this.f34051c = z3;
    }

    public boolean getBoolean() {
        return this.f34051c;
    }
}
