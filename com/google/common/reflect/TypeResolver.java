package com.google.common.reflect;

import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.reflect.Types;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.CheckForNull;
import kotlin.text.Typography;

@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public final class TypeResolver {

    /* renamed from: a  reason: collision with root package name */
    private final TypeTable f28224a;

    /* loaded from: classes5.dex */
    private static final class TypeMappingIntrospector extends TypeVisitor {

        /* renamed from: b  reason: collision with root package name */
        private final Map<TypeVariableKey, Type> f28227b = Maps.newHashMap();

        private TypeMappingIntrospector() {
        }

        static ImmutableMap<TypeVariableKey, Type> g(Type type) {
            Preconditions.checkNotNull(type);
            TypeMappingIntrospector typeMappingIntrospector = new TypeMappingIntrospector();
            typeMappingIntrospector.a(type);
            return ImmutableMap.copyOf((Map) typeMappingIntrospector.f28227b);
        }

        private void h(TypeVariableKey typeVariableKey, Type type) {
            if (this.f28227b.containsKey(typeVariableKey)) {
                return;
            }
            Type type2 = type;
            while (type2 != null) {
                if (typeVariableKey.a(type2)) {
                    while (type != null) {
                        type = this.f28227b.remove(TypeVariableKey.c(type));
                    }
                    return;
                }
                type2 = this.f28227b.get(TypeVariableKey.c(type2));
            }
            this.f28227b.put(typeVariableKey, type);
        }

        @Override // com.google.common.reflect.TypeVisitor
        void b(Class<?> cls) {
            a(cls.getGenericSuperclass());
            a(cls.getGenericInterfaces());
        }

        @Override // com.google.common.reflect.TypeVisitor
        void d(ParameterizedType parameterizedType) {
            boolean z3;
            Class cls = (Class) parameterizedType.getRawType();
            TypeVariable[] typeParameters = cls.getTypeParameters();
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            if (typeParameters.length == actualTypeArguments.length) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkState(z3);
            for (int i4 = 0; i4 < typeParameters.length; i4++) {
                h(new TypeVariableKey(typeParameters[i4]), actualTypeArguments[i4]);
            }
            a(cls);
            a(parameterizedType.getOwnerType());
        }

        @Override // com.google.common.reflect.TypeVisitor
        void e(TypeVariable<?> typeVariable) {
            a(typeVariable.getBounds());
        }

        @Override // com.google.common.reflect.TypeVisitor
        void f(WildcardType wildcardType) {
            a(wildcardType.getUpperBounds());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class TypeVariableKey {

        /* renamed from: a  reason: collision with root package name */
        private final TypeVariable<?> f28231a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public TypeVariableKey(TypeVariable<?> typeVariable) {
            this.f28231a = (TypeVariable) Preconditions.checkNotNull(typeVariable);
        }

        private boolean b(TypeVariable<?> typeVariable) {
            if (this.f28231a.getGenericDeclaration().equals(typeVariable.getGenericDeclaration()) && this.f28231a.getName().equals(typeVariable.getName())) {
                return true;
            }
            return false;
        }

        @CheckForNull
        static TypeVariableKey c(Type type) {
            if (type instanceof TypeVariable) {
                return new TypeVariableKey((TypeVariable) type);
            }
            return null;
        }

        boolean a(Type type) {
            if (type instanceof TypeVariable) {
                return b((TypeVariable) type);
            }
            return false;
        }

        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof TypeVariableKey) {
                return b(((TypeVariableKey) obj).f28231a);
            }
            return false;
        }

        public int hashCode() {
            return Objects.hashCode(this.f28231a.getGenericDeclaration(), this.f28231a.getName());
        }

        public String toString() {
            return this.f28231a.toString();
        }
    }

    /* loaded from: classes5.dex */
    private static class WildcardCapturer {

        /* renamed from: b  reason: collision with root package name */
        static final WildcardCapturer f28232b = new WildcardCapturer();

        /* renamed from: a  reason: collision with root package name */
        private final AtomicInteger f28233a;

        @CheckForNull
        private Type c(@CheckForNull Type type) {
            if (type == null) {
                return null;
            }
            return a(type);
        }

        private WildcardCapturer d(final TypeVariable<?> typeVariable) {
            return new WildcardCapturer(this, this.f28233a) { // from class: com.google.common.reflect.TypeResolver.WildcardCapturer.1
                @Override // com.google.common.reflect.TypeResolver.WildcardCapturer
                TypeVariable<?> b(Type[] typeArr) {
                    LinkedHashSet linkedHashSet = new LinkedHashSet(Arrays.asList(typeArr));
                    linkedHashSet.addAll(Arrays.asList(typeVariable.getBounds()));
                    if (linkedHashSet.size() > 1) {
                        linkedHashSet.remove(Object.class);
                    }
                    return super.b((Type[]) linkedHashSet.toArray(new Type[0]));
                }
            };
        }

        private WildcardCapturer e() {
            return new WildcardCapturer(this.f28233a);
        }

        final Type a(Type type) {
            Preconditions.checkNotNull(type);
            if (type instanceof Class) {
                return type;
            }
            if (type instanceof TypeVariable) {
                return type;
            }
            if (type instanceof GenericArrayType) {
                return Types.j(e().a(((GenericArrayType) type).getGenericComponentType()));
            }
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                Class cls = (Class) parameterizedType.getRawType();
                TypeVariable<?>[] typeParameters = cls.getTypeParameters();
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                for (int i4 = 0; i4 < actualTypeArguments.length; i4++) {
                    actualTypeArguments[i4] = d(typeParameters[i4]).a(actualTypeArguments[i4]);
                }
                return Types.m(e().c(parameterizedType.getOwnerType()), cls, actualTypeArguments);
            } else if (type instanceof WildcardType) {
                WildcardType wildcardType = (WildcardType) type;
                if (wildcardType.getLowerBounds().length == 0) {
                    return b(wildcardType.getUpperBounds());
                }
                return type;
            } else {
                throw new AssertionError("must have been one of the known types");
            }
        }

        TypeVariable<?> b(Type[] typeArr) {
            return Types.k(WildcardCapturer.class, "capture#" + this.f28233a.incrementAndGet() + "-of ? extends " + Joiner.on((char) Typography.amp).join(typeArr), typeArr);
        }

        private WildcardCapturer() {
            this(new AtomicInteger());
        }

        private WildcardCapturer(AtomicInteger atomicInteger) {
            this.f28233a = atomicInteger;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static TypeResolver d(Type type) {
        return new TypeResolver().m(TypeMappingIntrospector.g(type));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> T e(Class<T> cls, Object obj) {
        try {
            return cls.cast(obj);
        } catch (ClassCastException unused) {
            throw new IllegalArgumentException(obj + " is not a " + cls.getSimpleName());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static TypeResolver f(Type type) {
        return new TypeResolver().m(TypeMappingIntrospector.g(WildcardCapturer.f28232b.a(type)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(final Map<TypeVariableKey, Type> map, Type type, final Type type2) {
        if (type.equals(type2)) {
            return;
        }
        new TypeVisitor() { // from class: com.google.common.reflect.TypeResolver.1
            @Override // com.google.common.reflect.TypeVisitor
            void b(Class<?> cls) {
                if (type2 instanceof WildcardType) {
                    return;
                }
                throw new IllegalArgumentException("No type mapping from " + cls + " to " + type2);
            }

            @Override // com.google.common.reflect.TypeVisitor
            void c(GenericArrayType genericArrayType) {
                boolean z3;
                Type type3 = type2;
                if (type3 instanceof WildcardType) {
                    return;
                }
                Type i4 = Types.i(type3);
                if (i4 != null) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                Preconditions.checkArgument(z3, "%s is not an array type.", type2);
                TypeResolver.g(map, genericArrayType.getGenericComponentType(), i4);
            }

            @Override // com.google.common.reflect.TypeVisitor
            void d(ParameterizedType parameterizedType) {
                boolean z3;
                Type type3 = type2;
                if (type3 instanceof WildcardType) {
                    return;
                }
                ParameterizedType parameterizedType2 = (ParameterizedType) TypeResolver.e(ParameterizedType.class, type3);
                if (parameterizedType.getOwnerType() != null && parameterizedType2.getOwnerType() != null) {
                    TypeResolver.g(map, parameterizedType.getOwnerType(), parameterizedType2.getOwnerType());
                }
                Preconditions.checkArgument(parameterizedType.getRawType().equals(parameterizedType2.getRawType()), "Inconsistent raw type: %s vs. %s", parameterizedType, type2);
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                Type[] actualTypeArguments2 = parameterizedType2.getActualTypeArguments();
                if (actualTypeArguments.length == actualTypeArguments2.length) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                Preconditions.checkArgument(z3, "%s not compatible with %s", parameterizedType, parameterizedType2);
                for (int i4 = 0; i4 < actualTypeArguments.length; i4++) {
                    TypeResolver.g(map, actualTypeArguments[i4], actualTypeArguments2[i4]);
                }
            }

            @Override // com.google.common.reflect.TypeVisitor
            void e(TypeVariable<?> typeVariable) {
                map.put(new TypeVariableKey(typeVariable), type2);
            }

            @Override // com.google.common.reflect.TypeVisitor
            void f(WildcardType wildcardType) {
                boolean z3;
                Type type3 = type2;
                if (!(type3 instanceof WildcardType)) {
                    return;
                }
                WildcardType wildcardType2 = (WildcardType) type3;
                Type[] upperBounds = wildcardType.getUpperBounds();
                Type[] upperBounds2 = wildcardType2.getUpperBounds();
                Type[] lowerBounds = wildcardType.getLowerBounds();
                Type[] lowerBounds2 = wildcardType2.getLowerBounds();
                if (upperBounds.length == upperBounds2.length && lowerBounds.length == lowerBounds2.length) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                Preconditions.checkArgument(z3, "Incompatible type: %s vs. %s", wildcardType, type2);
                for (int i4 = 0; i4 < upperBounds.length; i4++) {
                    TypeResolver.g(map, upperBounds[i4], upperBounds2[i4]);
                }
                for (int i5 = 0; i5 < lowerBounds.length; i5++) {
                    TypeResolver.g(map, lowerBounds[i5], lowerBounds2[i5]);
                }
            }
        }.a(type);
    }

    private Type h(GenericArrayType genericArrayType) {
        return Types.j(resolveType(genericArrayType.getGenericComponentType()));
    }

    private ParameterizedType i(ParameterizedType parameterizedType) {
        Type resolveType;
        Type ownerType = parameterizedType.getOwnerType();
        if (ownerType == null) {
            resolveType = null;
        } else {
            resolveType = resolveType(ownerType);
        }
        return Types.m(resolveType, (Class) resolveType(parameterizedType.getRawType()), j(parameterizedType.getActualTypeArguments()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Type[] j(Type[] typeArr) {
        Type[] typeArr2 = new Type[typeArr.length];
        for (int i4 = 0; i4 < typeArr.length; i4++) {
            typeArr2[i4] = resolveType(typeArr[i4]);
        }
        return typeArr2;
    }

    private WildcardType l(WildcardType wildcardType) {
        return new Types.WildcardTypeImpl(j(wildcardType.getLowerBounds()), j(wildcardType.getUpperBounds()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Type[] k(Type[] typeArr) {
        for (int i4 = 0; i4 < typeArr.length; i4++) {
            typeArr[i4] = resolveType(typeArr[i4]);
        }
        return typeArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TypeResolver m(Map<TypeVariableKey, ? extends Type> map) {
        return new TypeResolver(this.f28224a.c(map));
    }

    public Type resolveType(Type type) {
        Preconditions.checkNotNull(type);
        if (type instanceof TypeVariable) {
            return this.f28224a.a((TypeVariable) type);
        }
        if (type instanceof ParameterizedType) {
            return i((ParameterizedType) type);
        }
        if (type instanceof GenericArrayType) {
            return h((GenericArrayType) type);
        }
        if (type instanceof WildcardType) {
            return l((WildcardType) type);
        }
        return type;
    }

    public TypeResolver where(Type type, Type type2) {
        HashMap newHashMap = Maps.newHashMap();
        g(newHashMap, (Type) Preconditions.checkNotNull(type), (Type) Preconditions.checkNotNull(type2));
        return m(newHashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class TypeTable {

        /* renamed from: a  reason: collision with root package name */
        private final ImmutableMap<TypeVariableKey, Type> f28228a;

        TypeTable() {
            this.f28228a = ImmutableMap.of();
        }

        final Type a(final TypeVariable<?> typeVariable) {
            return b(typeVariable, new TypeTable(this) { // from class: com.google.common.reflect.TypeResolver.TypeTable.1
                @Override // com.google.common.reflect.TypeResolver.TypeTable
                public Type b(TypeVariable<?> typeVariable2, TypeTable typeTable) {
                    if (typeVariable2.getGenericDeclaration().equals(typeVariable.getGenericDeclaration())) {
                        return typeVariable2;
                    }
                    return this.b(typeVariable2, typeTable);
                }
            });
        }

        /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.reflect.GenericDeclaration] */
        Type b(TypeVariable<?> typeVariable, TypeTable typeTable) {
            Type type = this.f28228a.get(new TypeVariableKey(typeVariable));
            if (type == null) {
                Type[] bounds = typeVariable.getBounds();
                if (bounds.length != 0) {
                    Type[] j4 = new TypeResolver(typeTable).j(bounds);
                    if (Types.NativeTypeVariableEquals.f28268a && Arrays.equals(bounds, j4)) {
                        return typeVariable;
                    }
                    return Types.k(typeVariable.getGenericDeclaration(), typeVariable.getName(), j4);
                }
                return typeVariable;
            }
            return new TypeResolver(typeTable).resolveType(type);
        }

        final TypeTable c(Map<TypeVariableKey, ? extends Type> map) {
            ImmutableMap.Builder builder = ImmutableMap.builder();
            builder.putAll(this.f28228a);
            for (Map.Entry<TypeVariableKey, ? extends Type> entry : map.entrySet()) {
                TypeVariableKey key = entry.getKey();
                Type value = entry.getValue();
                Preconditions.checkArgument(!key.a(value), "Type variable %s bound to itself", key);
                builder.put(key, value);
            }
            return new TypeTable(builder.buildOrThrow());
        }

        private TypeTable(ImmutableMap<TypeVariableKey, Type> immutableMap) {
            this.f28228a = immutableMap;
        }
    }

    public TypeResolver() {
        this.f28224a = new TypeTable();
    }

    private TypeResolver(TypeTable typeTable) {
        this.f28224a = typeTable;
    }
}
