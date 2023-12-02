package com.google.protobuf;

import net.bytebuddy.implementation.auxiliary.TypeProxy;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class ExtensionRegistryFactory {

    /* renamed from: a  reason: collision with root package name */
    static final Class<?> f33327a = e();

    ExtensionRegistryFactory() {
    }

    public static ExtensionRegistryLite a() {
        ExtensionRegistryLite c4 = c(TypeProxy.SilentConstruction.Appender.NEW_INSTANCE_METHOD_NAME);
        if (c4 == null) {
            return new ExtensionRegistryLite();
        }
        return c4;
    }

    public static ExtensionRegistryLite b() {
        ExtensionRegistryLite c4 = c("getEmptyRegistry");
        if (c4 == null) {
            return ExtensionRegistryLite.f33331e;
        }
        return c4;
    }

    private static final ExtensionRegistryLite c(String str) {
        Class<?> cls = f33327a;
        if (cls == null) {
            return null;
        }
        try {
            return (ExtensionRegistryLite) cls.getDeclaredMethod(str, new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean d(ExtensionRegistryLite extensionRegistryLite) {
        Class<?> cls = f33327a;
        if (cls != null && cls.isAssignableFrom(extensionRegistryLite.getClass())) {
            return true;
        }
        return false;
    }

    static Class<?> e() {
        try {
            return Class.forName("com.google.protobuf.ExtensionRegistry");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}
