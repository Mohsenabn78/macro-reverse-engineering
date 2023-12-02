package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public class ExtensionRegistryLite {

    /* renamed from: b  reason: collision with root package name */
    private static volatile boolean f33328b = false;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f33329c = true;

    /* renamed from: d  reason: collision with root package name */
    private static volatile ExtensionRegistryLite f33330d;

    /* renamed from: e  reason: collision with root package name */
    static final ExtensionRegistryLite f33331e = new ExtensionRegistryLite(true);

    /* renamed from: a  reason: collision with root package name */
    private final Map<ObjectIntPair, GeneratedMessageLite.GeneratedExtension<?, ?>> f33332a;

    /* loaded from: classes6.dex */
    private static class ExtensionClassHolder {

        /* renamed from: a  reason: collision with root package name */
        static final Class<?> f33333a = a();

        private ExtensionClassHolder() {
        }

        static Class<?> a() {
            try {
                return Class.forName("com.google.protobuf.Extension");
            } catch (ClassNotFoundException unused) {
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class ObjectIntPair {

        /* renamed from: a  reason: collision with root package name */
        private final Object f33334a;

        /* renamed from: b  reason: collision with root package name */
        private final int f33335b;

        ObjectIntPair(Object obj, int i4) {
            this.f33334a = obj;
            this.f33335b = i4;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ObjectIntPair)) {
                return false;
            }
            ObjectIntPair objectIntPair = (ObjectIntPair) obj;
            if (this.f33334a != objectIntPair.f33334a || this.f33335b != objectIntPair.f33335b) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (System.identityHashCode(this.f33334a) * 65535) + this.f33335b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ExtensionRegistryLite() {
        this.f33332a = new HashMap();
    }

    public static ExtensionRegistryLite getEmptyRegistry() {
        ExtensionRegistryLite extensionRegistryLite = f33330d;
        if (extensionRegistryLite == null) {
            synchronized (ExtensionRegistryLite.class) {
                extensionRegistryLite = f33330d;
                if (extensionRegistryLite == null) {
                    if (f33329c) {
                        extensionRegistryLite = ExtensionRegistryFactory.b();
                    } else {
                        extensionRegistryLite = f33331e;
                    }
                    f33330d = extensionRegistryLite;
                }
            }
        }
        return extensionRegistryLite;
    }

    public static boolean isEagerlyParseMessageSets() {
        return f33328b;
    }

    public static ExtensionRegistryLite newInstance() {
        if (f33329c) {
            return ExtensionRegistryFactory.a();
        }
        return new ExtensionRegistryLite();
    }

    public static void setEagerlyParseMessageSets(boolean z3) {
        f33328b = z3;
    }

    public final void add(GeneratedMessageLite.GeneratedExtension<?, ?> generatedExtension) {
        this.f33332a.put(new ObjectIntPair(generatedExtension.getContainingTypeDefaultInstance(), generatedExtension.getNumber()), generatedExtension);
    }

    public <ContainingType extends MessageLite> GeneratedMessageLite.GeneratedExtension<ContainingType, ?> findLiteExtensionByNumber(ContainingType containingtype, int i4) {
        return (GeneratedMessageLite.GeneratedExtension<ContainingType, ?>) this.f33332a.get(new ObjectIntPair(containingtype, i4));
    }

    public ExtensionRegistryLite getUnmodifiable() {
        return new ExtensionRegistryLite(this);
    }

    ExtensionRegistryLite(ExtensionRegistryLite extensionRegistryLite) {
        if (extensionRegistryLite == f33331e) {
            this.f33332a = Collections.emptyMap();
        } else {
            this.f33332a = Collections.unmodifiableMap(extensionRegistryLite.f33332a);
        }
    }

    public final void add(ExtensionLite<?, ?> extensionLite) {
        if (GeneratedMessageLite.GeneratedExtension.class.isAssignableFrom(extensionLite.getClass())) {
            add((GeneratedMessageLite.GeneratedExtension) extensionLite);
        }
        if (f33329c && ExtensionRegistryFactory.d(this)) {
            try {
                getClass().getMethod("add", ExtensionClassHolder.f33333a).invoke(this, extensionLite);
            } catch (Exception e4) {
                throw new IllegalArgumentException(String.format("Could not invoke ExtensionRegistry#add for %s", extensionLite), e4);
            }
        }
    }

    ExtensionRegistryLite(boolean z3) {
        this.f33332a = Collections.emptyMap();
    }
}
