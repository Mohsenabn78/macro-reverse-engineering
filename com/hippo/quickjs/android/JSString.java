package com.hippo.quickjs.android;

/* loaded from: classes6.dex */
public final class JSString extends JSValue {

    /* renamed from: c  reason: collision with root package name */
    private final String f34063c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSString(long j4, JSContext jSContext, String str) {
        super(j4, jSContext);
        this.f34063c = str;
    }

    public String getString() {
        return this.f34063c;
    }
}
