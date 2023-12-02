package com.google.api.client.repackaged.com.google.common.base;

import com.google.api.client.repackaged.com.google.common.annotations.Beta;
import com.google.api.client.repackaged.com.google.common.annotations.GwtCompatible;
import com.google.api.client.repackaged.com.google.common.annotations.GwtIncompatible;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import javax.annotation.Nullable;

@Beta
@GwtCompatible(emulated = true)
/* loaded from: classes5.dex */
public final class Enums {
    @GwtIncompatible("java.lang.ref.WeakReference")

    /* renamed from: a  reason: collision with root package name */
    private static final Map<Class<? extends Enum<?>>, Map<String, WeakReference<? extends Enum<?>>>> f25947a = new WeakHashMap();

    /* loaded from: classes5.dex */
    private static final class StringConverter<T extends Enum<T>> extends Converter<String, T> implements Serializable {
        private static final long serialVersionUID = 0;
        private final Class<T> enumClass;

        StringConverter(Class<T> cls) {
            this.enumClass = (Class) Preconditions.checkNotNull(cls);
        }

        @Override // com.google.api.client.repackaged.com.google.common.base.Converter, com.google.api.client.repackaged.com.google.common.base.Function
        public boolean equals(@Nullable Object obj) {
            if (obj instanceof StringConverter) {
                return this.enumClass.equals(((StringConverter) obj).enumClass);
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.api.client.repackaged.com.google.common.base.Converter
        /* renamed from: f */
        public String c(T t3) {
            return t3.name();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.api.client.repackaged.com.google.common.base.Converter
        /* renamed from: g */
        public T e(String str) {
            return (T) Enum.valueOf(this.enumClass, str);
        }

        public int hashCode() {
            return this.enumClass.hashCode();
        }

        public String toString() {
            return "Enums.stringConverter(" + this.enumClass.getName() + ".class)";
        }
    }

    /* loaded from: classes5.dex */
    private static final class ValueOfFunction<T extends Enum<T>> implements Function<String, T>, Serializable {
        private static final long serialVersionUID = 0;
        private final Class<T> enumClass;

        @Override // com.google.api.client.repackaged.com.google.common.base.Function
        /* renamed from: a */
        public T apply(String str) {
            try {
                return (T) Enum.valueOf(this.enumClass, str);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        @Override // com.google.api.client.repackaged.com.google.common.base.Function
        public boolean equals(@Nullable Object obj) {
            if ((obj instanceof ValueOfFunction) && this.enumClass.equals(((ValueOfFunction) obj).enumClass)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.enumClass.hashCode();
        }

        public String toString() {
            return "Enums.valueOf(" + this.enumClass + ")";
        }

        private ValueOfFunction(Class<T> cls) {
            this.enumClass = (Class) Preconditions.checkNotNull(cls);
        }
    }

    private Enums() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @GwtIncompatible("java.lang.ref.WeakReference")
    public static <T extends Enum<T>> Map<String, WeakReference<? extends Enum<?>>> a(Class<T> cls) {
        Map<String, WeakReference<? extends Enum<?>>> map;
        Map<Class<? extends Enum<?>>, Map<String, WeakReference<? extends Enum<?>>>> map2 = f25947a;
        synchronized (map2) {
            map = map2.get(cls);
            if (map == null) {
                map = b(cls);
            }
        }
        return map;
    }

    @GwtIncompatible("java.lang.ref.WeakReference")
    private static <T extends Enum<T>> Map<String, WeakReference<? extends Enum<?>>> b(Class<T> cls) {
        HashMap hashMap = new HashMap();
        Iterator it = EnumSet.allOf(cls).iterator();
        while (it.hasNext()) {
            Enum r22 = (Enum) it.next();
            hashMap.put(r22.name(), new WeakReference(r22));
        }
        f25947a.put(cls, hashMap);
        return hashMap;
    }

    @GwtIncompatible("reflection")
    public static Field getField(Enum<?> r12) {
        try {
            return r12.getDeclaringClass().getDeclaredField(r12.name());
        } catch (NoSuchFieldException e4) {
            throw new AssertionError(e4);
        }
    }

    public static <T extends Enum<T>> Optional<T> getIfPresent(Class<T> cls, String str) {
        Preconditions.checkNotNull(cls);
        Preconditions.checkNotNull(str);
        return Platform.a(cls, str);
    }

    public static <T extends Enum<T>> Converter<String, T> stringConverter(Class<T> cls) {
        return new StringConverter(cls);
    }

    @Deprecated
    public static <T extends Enum<T>> Function<String, T> valueOfFunction(Class<T> cls) {
        return new ValueOfFunction(cls);
    }
}
