package com.google.protobuf;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: Access modifiers changed from: package-private */
@CheckReturnValue
/* loaded from: classes6.dex */
public final class Protobuf {

    /* renamed from: c  reason: collision with root package name */
    private static final Protobuf f33514c = new Protobuf();

    /* renamed from: b  reason: collision with root package name */
    private final ConcurrentMap<Class<?>, Schema<?>> f33516b = new ConcurrentHashMap();

    /* renamed from: a  reason: collision with root package name */
    private final SchemaFactory f33515a = new ManifestSchemaFactory();

    private Protobuf() {
    }

    public static Protobuf a() {
        return f33514c;
    }

    public Schema<?> b(Class<?> cls, Schema<?> schema) {
        Internal.b(cls, "messageType");
        Internal.b(schema, "schema");
        return this.f33516b.putIfAbsent(cls, schema);
    }

    public <T> Schema<T> c(Class<T> cls) {
        Internal.b(cls, "messageType");
        Schema<T> schema = (Schema<T>) this.f33516b.get(cls);
        if (schema == null) {
            Schema<T> createSchema = this.f33515a.createSchema(cls);
            Schema<T> schema2 = (Schema<T>) b(cls, createSchema);
            if (schema2 != null) {
                return schema2;
            }
            return createSchema;
        }
        return schema;
    }

    public <T> Schema<T> d(T t3) {
        return c(t3.getClass());
    }

    public <T> void e(T t3, Writer writer) throws IOException {
        d(t3).a(t3, writer);
    }
}
