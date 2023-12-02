package com.google.protobuf;

@CheckReturnValue
/* loaded from: classes6.dex */
final class NewInstanceSchemas {

    /* renamed from: a  reason: collision with root package name */
    private static final NewInstanceSchema f33503a = c();

    /* renamed from: b  reason: collision with root package name */
    private static final NewInstanceSchema f33504b = new NewInstanceSchemaLite();

    NewInstanceSchemas() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static NewInstanceSchema a() {
        return f33503a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static NewInstanceSchema b() {
        return f33504b;
    }

    private static NewInstanceSchema c() {
        try {
            return (NewInstanceSchema) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
