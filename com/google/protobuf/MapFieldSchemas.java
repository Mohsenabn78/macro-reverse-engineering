package com.google.protobuf;

@CheckReturnValue
/* loaded from: classes6.dex */
final class MapFieldSchemas {

    /* renamed from: a  reason: collision with root package name */
    private static final MapFieldSchema f33474a = c();

    /* renamed from: b  reason: collision with root package name */
    private static final MapFieldSchema f33475b = new MapFieldSchemaLite();

    MapFieldSchemas() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static MapFieldSchema a() {
        return f33474a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static MapFieldSchema b() {
        return f33475b;
    }

    private static MapFieldSchema c() {
        try {
            return (MapFieldSchema) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
