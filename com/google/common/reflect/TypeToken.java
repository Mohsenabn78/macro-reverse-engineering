package com.google.common.reflect;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ForwardingSet;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.primitives.Primitives;
import com.google.common.reflect.Invokable;
import com.google.common.reflect.TypeResolver;
import com.google.common.reflect.Types;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public abstract class TypeToken<T> extends TypeCapture<T> implements Serializable {
    private static final long serialVersionUID = 3637540370352322684L;
    @CheckForNull

    /* renamed from: a  reason: collision with root package name */
    private transient TypeResolver f28235a;
    @CheckForNull

    /* renamed from: b  reason: collision with root package name */
    private transient TypeResolver f28236b;
    private final Type runtimeType;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class Bounds {

        /* renamed from: a  reason: collision with root package name */
        private final Type[] f28241a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f28242b;

        Bounds(Type[] typeArr, boolean z3) {
            this.f28241a = typeArr;
            this.f28242b = z3;
        }

        boolean a(Type type) {
            for (Type type2 : this.f28241a) {
                boolean isSubtypeOf = TypeToken.of(type2).isSubtypeOf(type);
                boolean z3 = this.f28242b;
                if (isSubtypeOf == z3) {
                    return z3;
                }
            }
            return !this.f28242b;
        }

        boolean b(Type type) {
            TypeToken<?> of = TypeToken.of(type);
            for (Type type2 : this.f28241a) {
                boolean isSubtypeOf = of.isSubtypeOf(type2);
                boolean z3 = this.f28242b;
                if (isSubtypeOf == z3) {
                    return z3;
                }
            }
            return !this.f28242b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class SimpleTypeToken<T> extends TypeToken<T> {
        private static final long serialVersionUID = 0;

        SimpleTypeToken(Type type) {
            super(type);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static abstract class TypeCollector<K> {

        /* renamed from: a  reason: collision with root package name */
        static final TypeCollector<TypeToken<?>> f28246a = new TypeCollector<TypeToken<?>>() { // from class: com.google.common.reflect.TypeToken.TypeCollector.1
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.reflect.TypeToken.TypeCollector
            /* renamed from: i */
            public Iterable<? extends TypeToken<?>> e(TypeToken<?> typeToken) {
                return typeToken.s();
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.reflect.TypeToken.TypeCollector
            /* renamed from: j */
            public Class<?> f(TypeToken<?> typeToken) {
                return typeToken.getRawType();
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.reflect.TypeToken.TypeCollector
            @CheckForNull
            /* renamed from: k */
            public TypeToken<?> g(TypeToken<?> typeToken) {
                return typeToken.t();
            }
        };

        /* renamed from: b  reason: collision with root package name */
        static final TypeCollector<Class<?>> f28247b = new TypeCollector<Class<?>>() { // from class: com.google.common.reflect.TypeToken.TypeCollector.2
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.reflect.TypeToken.TypeCollector
            /* renamed from: i */
            public Iterable<? extends Class<?>> e(Class<?> cls) {
                return Arrays.asList(cls.getInterfaces());
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.reflect.TypeToken.TypeCollector
            @CheckForNull
            /* renamed from: k */
            public Class<?> g(Class<?> cls) {
                return cls.getSuperclass();
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.reflect.TypeToken.TypeCollector
            /* renamed from: j */
            public Class<?> f(Class<?> cls) {
                return cls;
            }
        };

        /* loaded from: classes5.dex */
        private static class ForwardingTypeCollector<K> extends TypeCollector<K> {

            /* renamed from: c  reason: collision with root package name */
            private final TypeCollector<K> f28250c;

            ForwardingTypeCollector(TypeCollector<K> typeCollector) {
                super();
                this.f28250c = typeCollector;
            }

            @Override // com.google.common.reflect.TypeToken.TypeCollector
            Iterable<? extends K> e(K k4) {
                return this.f28250c.e(k4);
            }

            @Override // com.google.common.reflect.TypeToken.TypeCollector
            Class<?> f(K k4) {
                return this.f28250c.f(k4);
            }

            @Override // com.google.common.reflect.TypeToken.TypeCollector
            @CheckForNull
            K g(K k4) {
                return this.f28250c.g(k4);
            }
        }

        private TypeCollector() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @CanIgnoreReturnValue
        private int b(K k4, Map<? super K, Integer> map) {
            Integer num = map.get(k4);
            if (num != null) {
                return num.intValue();
            }
            boolean isInterface = f(k4).isInterface();
            int i4 = isInterface;
            for (K k5 : e(k4)) {
                i4 = Math.max(i4, b(k5, map));
            }
            K g4 = g(k4);
            int i5 = i4;
            if (g4 != null) {
                i5 = Math.max(i4, b(g4, map));
            }
            int i6 = i5 + 1;
            map.put(k4, Integer.valueOf(i6));
            return i6;
        }

        private static <K, V> ImmutableList<K> h(final Map<K, V> map, final Comparator<? super V> comparator) {
            return (ImmutableList<K>) new Ordering<K>() { // from class: com.google.common.reflect.TypeToken.TypeCollector.4
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.google.common.collect.Ordering, java.util.Comparator
                public int compare(K k4, K k5) {
                    Comparator comparator2 = comparator;
                    Object obj = map.get(k4);
                    Objects.requireNonNull(obj);
                    Object obj2 = map.get(k5);
                    Objects.requireNonNull(obj2);
                    return comparator2.compare(obj, obj2);
                }
            }.immutableSortedCopy(map.keySet());
        }

        final TypeCollector<K> a() {
            return new ForwardingTypeCollector<K>(this, this) { // from class: com.google.common.reflect.TypeToken.TypeCollector.3
                @Override // com.google.common.reflect.TypeToken.TypeCollector
                ImmutableList<K> c(Iterable<? extends K> iterable) {
                    ImmutableList.Builder builder = ImmutableList.builder();
                    for (K k4 : iterable) {
                        if (!f(k4).isInterface()) {
                            builder.add((ImmutableList.Builder) k4);
                        }
                    }
                    return super.c(builder.build());
                }

                @Override // com.google.common.reflect.TypeToken.TypeCollector.ForwardingTypeCollector, com.google.common.reflect.TypeToken.TypeCollector
                Iterable<? extends K> e(K k4) {
                    return ImmutableSet.of();
                }
            };
        }

        ImmutableList<K> c(Iterable<? extends K> iterable) {
            HashMap newHashMap = Maps.newHashMap();
            for (K k4 : iterable) {
                b(k4, newHashMap);
            }
            return h(newHashMap, Ordering.natural().reverse());
        }

        final ImmutableList<K> d(K k4) {
            return c(ImmutableList.of(k4));
        }

        abstract Iterable<? extends K> e(K k4);

        abstract Class<?> f(K k4);

        @CheckForNull
        abstract K g(K k4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public enum TypeFilter implements Predicate<TypeToken<?>> {
        IGNORE_TYPE_VARIABLE_OR_WILDCARD { // from class: com.google.common.reflect.TypeToken.TypeFilter.1
            @Override // com.google.common.base.Predicate
            /* renamed from: b */
            public boolean apply(TypeToken<?> typeToken) {
                if (!(((TypeToken) typeToken).runtimeType instanceof TypeVariable) && !(((TypeToken) typeToken).runtimeType instanceof WildcardType)) {
                    return true;
                }
                return false;
            }
        },
        INTERFACE_ONLY { // from class: com.google.common.reflect.TypeToken.TypeFilter.2
            @Override // com.google.common.base.Predicate
            /* renamed from: b */
            public boolean apply(TypeToken<?> typeToken) {
                return typeToken.getRawType().isInterface();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class TypeSet extends ForwardingSet<TypeToken<? super T>> implements Serializable {
        private static final long serialVersionUID = 0;
        @CheckForNull

        /* renamed from: a  reason: collision with root package name */
        private transient ImmutableSet<TypeToken<? super T>> f28254a;

        TypeSet() {
        }

        public TypeToken<T>.TypeSet classes() {
            return new ClassSet();
        }

        public TypeToken<T>.TypeSet interfaces() {
            return new InterfaceSet(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection
        /* renamed from: n */
        public Set<TypeToken<? super T>> f() {
            ImmutableSet<TypeToken<? super T>> immutableSet = this.f28254a;
            if (immutableSet == null) {
                ImmutableSet<TypeToken<? super T>> set = FluentIterable.from(TypeCollector.f28246a.d(TypeToken.this)).filter(TypeFilter.IGNORE_TYPE_VARIABLE_OR_WILDCARD).toSet();
                this.f28254a = set;
                return set;
            }
            return immutableSet;
        }

        public Set<Class<? super T>> rawTypes() {
            return ImmutableSet.copyOf((Collection) TypeCollector.f28247b.c(TypeToken.this.w()));
        }
    }

    private boolean A(Type type) {
        Iterator<TypeToken<? super T>> it = getTypes().iterator();
        while (it.hasNext()) {
            Type v3 = it.next().v();
            if (v3 != null && of(v3).isSubtypeOf(type)) {
                return true;
            }
        }
        return false;
    }

    private boolean B(GenericArrayType genericArrayType) {
        Type type = this.runtimeType;
        if (type instanceof Class) {
            Class cls = (Class) type;
            if (!cls.isArray()) {
                return false;
            }
            return of((Class) cls.getComponentType()).isSubtypeOf(genericArrayType.getGenericComponentType());
        } else if (!(type instanceof GenericArrayType)) {
            return false;
        } else {
            return of(((GenericArrayType) type).getGenericComponentType()).isSubtypeOf(genericArrayType.getGenericComponentType());
        }
    }

    private boolean C(ParameterizedType parameterizedType) {
        Class<? super Object> rawType = of(parameterizedType).getRawType();
        if (!J(rawType)) {
            return false;
        }
        TypeVariable<Class<? super Object>>[] typeParameters = rawType.getTypeParameters();
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        for (int i4 = 0; i4 < typeParameters.length; i4++) {
            if (!of(r().resolveType(typeParameters[i4])).z(actualTypeArguments[i4], typeParameters[i4])) {
                return false;
            }
        }
        if (!Modifier.isStatic(((Class) parameterizedType.getRawType()).getModifiers()) && parameterizedType.getOwnerType() != null && !A(parameterizedType.getOwnerType())) {
            return false;
        }
        return true;
    }

    private boolean D(GenericArrayType genericArrayType) {
        Type type = this.runtimeType;
        if (type instanceof Class) {
            Class cls = (Class) type;
            if (!cls.isArray()) {
                return cls.isAssignableFrom(Object[].class);
            }
            return of(genericArrayType.getGenericComponentType()).isSubtypeOf(cls.getComponentType());
        } else if (type instanceof GenericArrayType) {
            return of(genericArrayType.getGenericComponentType()).isSubtypeOf(((GenericArrayType) this.runtimeType).getGenericComponentType());
        } else {
            return false;
        }
    }

    private boolean E() {
        return Primitives.allWrapperTypes().contains(this.runtimeType);
    }

    private static Type F(Type type) {
        return Types.JavaVersion.JAVA7.c(type);
    }

    private TypeToken<?> H(Type type) {
        TypeToken<?> of = of(r().resolveType(type));
        of.f28236b = this.f28236b;
        of.f28235a = this.f28235a;
        return of;
    }

    private Type I(Class<?> cls) {
        if ((this.runtimeType instanceof Class) && (cls.getTypeParameters().length == 0 || getRawType().getTypeParameters().length != 0)) {
            return cls;
        }
        TypeToken K = K(cls);
        return new TypeResolver().where(K.getSupertype(getRawType()).runtimeType, this.runtimeType).resolveType(K.runtimeType);
    }

    private boolean J(Class<?> cls) {
        UnmodifiableIterator<Class<? super T>> it = w().iterator();
        while (it.hasNext()) {
            if (cls.isAssignableFrom(it.next())) {
                return true;
            }
        }
        return false;
    }

    @VisibleForTesting
    static <T> TypeToken<? extends T> K(Class<T> cls) {
        Type type;
        if (cls.isArray()) {
            return (TypeToken<? extends T>) of(Types.j(K(cls.getComponentType()).runtimeType));
        }
        TypeVariable<Class<T>>[] typeParameters = cls.getTypeParameters();
        if (cls.isMemberClass() && !Modifier.isStatic(cls.getModifiers())) {
            type = K(cls.getEnclosingClass()).runtimeType;
        } else {
            type = null;
        }
        if (typeParameters.length <= 0 && (type == null || type == cls.getEnclosingClass())) {
            return of((Class) cls);
        }
        return (TypeToken<? extends T>) of(Types.m(type, cls, typeParameters));
    }

    private static Bounds g(Type[] typeArr) {
        return new Bounds(typeArr, true);
    }

    @CheckForNull
    private TypeToken<? super T> h(Type type) {
        TypeToken<? super T> typeToken = (TypeToken<? super T>) of(type);
        if (typeToken.getRawType().isInterface()) {
            return null;
        }
        return typeToken;
    }

    private ImmutableList<TypeToken<? super T>> i(Type[] typeArr) {
        ImmutableList.Builder builder = ImmutableList.builder();
        for (Type type : typeArr) {
            TypeToken<?> of = of(type);
            if (of.getRawType().isInterface()) {
                builder.add((ImmutableList.Builder) of);
            }
        }
        return builder.build();
    }

    private static Type j(TypeVariable<?> typeVariable, Type type) {
        if (type instanceof WildcardType) {
            return l(typeVariable, (WildcardType) type);
        }
        return n(type);
    }

    private static WildcardType l(TypeVariable<?> typeVariable, WildcardType wildcardType) {
        Type[] upperBounds;
        Type[] bounds = typeVariable.getBounds();
        ArrayList arrayList = new ArrayList();
        for (Type type : wildcardType.getUpperBounds()) {
            if (!g(bounds).a(type)) {
                arrayList.add(n(type));
            }
        }
        return new Types.WildcardTypeImpl(wildcardType.getLowerBounds(), (Type[]) arrayList.toArray(new Type[0]));
    }

    private static ParameterizedType m(ParameterizedType parameterizedType) {
        Class cls = (Class) parameterizedType.getRawType();
        TypeVariable<Class<T>>[] typeParameters = cls.getTypeParameters();
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        for (int i4 = 0; i4 < actualTypeArguments.length; i4++) {
            actualTypeArguments[i4] = j(typeParameters[i4], actualTypeArguments[i4]);
        }
        return Types.m(parameterizedType.getOwnerType(), cls, actualTypeArguments);
    }

    private static Type n(Type type) {
        if (type instanceof ParameterizedType) {
            return m((ParameterizedType) type);
        }
        if (type instanceof GenericArrayType) {
            return Types.j(n(((GenericArrayType) type).getGenericComponentType()));
        }
        return type;
    }

    private static Bounds o(Type[] typeArr) {
        return new Bounds(typeArr, false);
    }

    public static <T> TypeToken<T> of(Class<T> cls) {
        return new SimpleTypeToken(cls);
    }

    private TypeToken<? extends T> p(Class<?> cls) {
        Class<?> componentType = cls.getComponentType();
        if (componentType != null) {
            TypeToken<?> componentType2 = getComponentType();
            Objects.requireNonNull(componentType2);
            return (TypeToken<? extends T>) of(F(componentType2.getSubtype(componentType).runtimeType));
        }
        throw new IllegalArgumentException(cls + " does not appear to be a subtype of " + this);
    }

    private TypeToken<? super T> q(Class<? super T> cls) {
        TypeToken<?> componentType = getComponentType();
        if (componentType != null) {
            Class componentType2 = cls.getComponentType();
            Objects.requireNonNull(componentType2);
            return (TypeToken<? super T>) of(F(componentType.getSupertype(componentType2).runtimeType));
        }
        throw new IllegalArgumentException(cls + " isn't a super type of " + this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TypeResolver r() {
        TypeResolver typeResolver = this.f28236b;
        if (typeResolver == null) {
            TypeResolver d4 = TypeResolver.d(this.runtimeType);
            this.f28236b = d4;
            return d4;
        }
        return typeResolver;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TypeResolver u() {
        TypeResolver typeResolver = this.f28235a;
        if (typeResolver == null) {
            TypeResolver f4 = TypeResolver.f(this.runtimeType);
            this.f28235a = f4;
            return f4;
        }
        return typeResolver;
    }

    @CheckForNull
    private Type v() {
        Type type = this.runtimeType;
        if (type instanceof ParameterizedType) {
            return ((ParameterizedType) type).getOwnerType();
        }
        if (type instanceof Class) {
            return ((Class) type).getEnclosingClass();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImmutableSet<Class<? super T>> w() {
        final ImmutableSet.Builder builder = ImmutableSet.builder();
        new TypeVisitor(this) { // from class: com.google.common.reflect.TypeToken.4
            @Override // com.google.common.reflect.TypeVisitor
            void b(Class<?> cls) {
                builder.add((ImmutableSet.Builder) cls);
            }

            @Override // com.google.common.reflect.TypeVisitor
            void c(GenericArrayType genericArrayType) {
                builder.add((ImmutableSet.Builder) Types.h(TypeToken.of(genericArrayType.getGenericComponentType()).getRawType()));
            }

            @Override // com.google.common.reflect.TypeVisitor
            void d(ParameterizedType parameterizedType) {
                builder.add((ImmutableSet.Builder) ((Class) parameterizedType.getRawType()));
            }

            @Override // com.google.common.reflect.TypeVisitor
            void e(TypeVariable<?> typeVariable) {
                a(typeVariable.getBounds());
            }

            @Override // com.google.common.reflect.TypeVisitor
            void f(WildcardType wildcardType) {
                a(wildcardType.getUpperBounds());
            }
        }.a(this.runtimeType);
        return builder.build();
    }

    private TypeToken<? extends T> x(Class<?> cls, Type[] typeArr) {
        if (typeArr.length > 0) {
            return (TypeToken<? extends T>) of(typeArr[0]).getSubtype(cls);
        }
        throw new IllegalArgumentException(cls + " isn't a subclass of " + this);
    }

    private TypeToken<? super T> y(Class<? super T> cls, Type[] typeArr) {
        for (Type type : typeArr) {
            TypeToken<?> of = of(type);
            if (of.isSubtypeOf(cls)) {
                return (TypeToken<? super T>) of.getSupertype(cls);
            }
        }
        throw new IllegalArgumentException(cls + " isn't a super type of " + this);
    }

    private boolean z(Type type, TypeVariable<?> typeVariable) {
        if (this.runtimeType.equals(type)) {
            return true;
        }
        if (type instanceof WildcardType) {
            WildcardType l4 = l(typeVariable, (WildcardType) type);
            if (o(l4.getUpperBounds()).b(this.runtimeType) && o(l4.getLowerBounds()).a(this.runtimeType)) {
                return true;
            }
            return false;
        }
        return n(this.runtimeType).equals(n(type));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    public final TypeToken<T> G() {
        new TypeVisitor() { // from class: com.google.common.reflect.TypeToken.3
            @Override // com.google.common.reflect.TypeVisitor
            void c(GenericArrayType genericArrayType) {
                a(genericArrayType.getGenericComponentType());
            }

            @Override // com.google.common.reflect.TypeVisitor
            void d(ParameterizedType parameterizedType) {
                a(parameterizedType.getActualTypeArguments());
                a(parameterizedType.getOwnerType());
            }

            @Override // com.google.common.reflect.TypeVisitor
            void e(TypeVariable<?> typeVariable) {
                throw new IllegalArgumentException(TypeToken.this.runtimeType + "contains a type variable and is not safe for the operation");
            }

            @Override // com.google.common.reflect.TypeVisitor
            void f(WildcardType wildcardType) {
                a(wildcardType.getLowerBounds());
                a(wildcardType.getUpperBounds());
            }
        }.a(this.runtimeType);
        return this;
    }

    public final Invokable<T, T> constructor(Constructor<?> constructor) {
        boolean z3;
        if (constructor.getDeclaringClass() == getRawType()) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "%s not declared by %s", constructor, getRawType());
        return new Invokable.ConstructorInvokable<T>(constructor) { // from class: com.google.common.reflect.TypeToken.2
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.reflect.Invokable.ConstructorInvokable, com.google.common.reflect.Invokable
            public Type[] b() {
                return TypeToken.this.r().k(super.b());
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.reflect.Invokable.ConstructorInvokable, com.google.common.reflect.Invokable
            public Type[] c() {
                return TypeToken.this.u().k(super.c());
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.reflect.Invokable.ConstructorInvokable, com.google.common.reflect.Invokable
            public Type d() {
                return TypeToken.this.r().resolveType(super.d());
            }

            @Override // com.google.common.reflect.Invokable
            public TypeToken<T> getOwnerType() {
                return TypeToken.this;
            }

            @Override // com.google.common.reflect.Invokable
            public String toString() {
                return getOwnerType() + "(" + Joiner.on(", ").join(c()) + ")";
            }
        };
    }

    public boolean equals(@CheckForNull Object obj) {
        if (obj instanceof TypeToken) {
            return this.runtimeType.equals(((TypeToken) obj).runtimeType);
        }
        return false;
    }

    @CheckForNull
    public final TypeToken<?> getComponentType() {
        Type i4 = Types.i(this.runtimeType);
        if (i4 == null) {
            return null;
        }
        return of(i4);
    }

    public final Class<? super T> getRawType() {
        return w().iterator().next();
    }

    public final TypeToken<? extends T> getSubtype(Class<?> cls) {
        Preconditions.checkArgument(!(this.runtimeType instanceof TypeVariable), "Cannot get subtype of type variable <%s>", this);
        Type type = this.runtimeType;
        if (type instanceof WildcardType) {
            return x(cls, ((WildcardType) type).getLowerBounds());
        }
        if (isArray()) {
            return p(cls);
        }
        Preconditions.checkArgument(getRawType().isAssignableFrom(cls), "%s isn't a subclass of %s", cls, this);
        TypeToken<? extends T> typeToken = (TypeToken<? extends T>) of(I(cls));
        Preconditions.checkArgument(typeToken.isSubtypeOf((TypeToken<?>) this), "%s does not appear to be a subtype of %s", typeToken, this);
        return typeToken;
    }

    public final TypeToken<? super T> getSupertype(Class<? super T> cls) {
        Preconditions.checkArgument(J(cls), "%s is not a super class of %s", cls, this);
        Type type = this.runtimeType;
        if (type instanceof TypeVariable) {
            return y(cls, ((TypeVariable) type).getBounds());
        }
        if (type instanceof WildcardType) {
            return y(cls, ((WildcardType) type).getUpperBounds());
        }
        if (cls.isArray()) {
            return q(cls);
        }
        return (TypeToken<? super T>) H(K(cls).runtimeType);
    }

    public final Type getType() {
        return this.runtimeType;
    }

    public final TypeToken<T>.TypeSet getTypes() {
        return new TypeSet();
    }

    public int hashCode() {
        return this.runtimeType.hashCode();
    }

    public final boolean isArray() {
        if (getComponentType() != null) {
            return true;
        }
        return false;
    }

    public final boolean isPrimitive() {
        Type type = this.runtimeType;
        if ((type instanceof Class) && ((Class) type).isPrimitive()) {
            return true;
        }
        return false;
    }

    public final boolean isSubtypeOf(TypeToken<?> typeToken) {
        return isSubtypeOf(typeToken.getType());
    }

    public final boolean isSupertypeOf(TypeToken<?> typeToken) {
        return typeToken.isSubtypeOf(getType());
    }

    public final Invokable<T, Object> method(Method method) {
        Preconditions.checkArgument(J(method.getDeclaringClass()), "%s not declared by %s", method, this);
        return new Invokable.MethodInvokable<T>(method) { // from class: com.google.common.reflect.TypeToken.1
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.reflect.Invokable.MethodInvokable, com.google.common.reflect.Invokable
            public Type[] b() {
                return TypeToken.this.r().k(super.b());
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.reflect.Invokable.MethodInvokable, com.google.common.reflect.Invokable
            public Type[] c() {
                return TypeToken.this.u().k(super.c());
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.reflect.Invokable.MethodInvokable, com.google.common.reflect.Invokable
            public Type d() {
                return TypeToken.this.r().resolveType(super.d());
            }

            @Override // com.google.common.reflect.Invokable
            public TypeToken<T> getOwnerType() {
                return TypeToken.this;
            }

            @Override // com.google.common.reflect.Invokable
            public String toString() {
                return getOwnerType() + "." + super.toString();
            }
        };
    }

    public final TypeToken<?> resolveType(Type type) {
        Preconditions.checkNotNull(type);
        return of(u().resolveType(type));
    }

    final ImmutableList<TypeToken<? super T>> s() {
        Type type = this.runtimeType;
        if (type instanceof TypeVariable) {
            return i(((TypeVariable) type).getBounds());
        }
        if (type instanceof WildcardType) {
            return i(((WildcardType) type).getUpperBounds());
        }
        ImmutableList.Builder builder = ImmutableList.builder();
        for (Type type2 : getRawType().getGenericInterfaces()) {
            builder.add((ImmutableList.Builder) H(type2));
        }
        return builder.build();
    }

    @CheckForNull
    final TypeToken<? super T> t() {
        Type type = this.runtimeType;
        if (type instanceof TypeVariable) {
            return h(((TypeVariable) type).getBounds()[0]);
        }
        if (type instanceof WildcardType) {
            return h(((WildcardType) type).getUpperBounds()[0]);
        }
        Type genericSuperclass = getRawType().getGenericSuperclass();
        if (genericSuperclass == null) {
            return null;
        }
        return (TypeToken<? super T>) H(genericSuperclass);
    }

    public String toString() {
        return Types.s(this.runtimeType);
    }

    public final TypeToken<T> unwrap() {
        if (E()) {
            return of(Primitives.unwrap((Class) this.runtimeType));
        }
        return this;
    }

    public final <X> TypeToken<T> where(TypeParameter<X> typeParameter, TypeToken<X> typeToken) {
        return new SimpleTypeToken(new TypeResolver().m(ImmutableMap.of(new TypeResolver.TypeVariableKey(typeParameter.f28223a), typeToken.runtimeType)).resolveType(this.runtimeType));
    }

    public final TypeToken<T> wrap() {
        if (isPrimitive()) {
            return of(Primitives.wrap((Class) this.runtimeType));
        }
        return this;
    }

    protected Object writeReplace() {
        return of(new TypeResolver().resolveType(this.runtimeType));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TypeToken() {
        Type a4 = a();
        this.runtimeType = a4;
        Preconditions.checkState(!(a4 instanceof TypeVariable), "Cannot construct a TypeToken for a type variable.\nYou probably meant to call new TypeToken<%s>(getClass()) that can resolve the type variable for you.\nIf you do need to create a TypeToken of a type variable, please use TypeToken.of() instead.", a4);
    }

    public static TypeToken<?> of(Type type) {
        return new SimpleTypeToken(type);
    }

    public final boolean isSubtypeOf(Type type) {
        Preconditions.checkNotNull(type);
        if (type instanceof WildcardType) {
            return g(((WildcardType) type).getLowerBounds()).b(this.runtimeType);
        }
        Type type2 = this.runtimeType;
        if (type2 instanceof WildcardType) {
            return g(((WildcardType) type2).getUpperBounds()).a(type);
        }
        if (type2 instanceof TypeVariable) {
            return type2.equals(type) || g(((TypeVariable) this.runtimeType).getBounds()).a(type);
        } else if (type2 instanceof GenericArrayType) {
            return of(type).D((GenericArrayType) this.runtimeType);
        } else {
            if (type instanceof Class) {
                return J((Class) type);
            }
            if (type instanceof ParameterizedType) {
                return C((ParameterizedType) type);
            }
            if (type instanceof GenericArrayType) {
                return B((GenericArrayType) type);
            }
            return false;
        }
    }

    public final boolean isSupertypeOf(Type type) {
        return of(type).isSubtypeOf(getType());
    }

    private TypeToken(Type type) {
        this.runtimeType = (Type) Preconditions.checkNotNull(type);
    }

    public final <X> TypeToken<T> where(TypeParameter<X> typeParameter, Class<X> cls) {
        return where(typeParameter, of((Class) cls));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public final class ClassSet extends TypeToken<T>.TypeSet {
        private static final long serialVersionUID = 0;
        @CheckForNull

        /* renamed from: b  reason: collision with root package name */
        private transient ImmutableSet<TypeToken<? super T>> f28243b;

        private ClassSet() {
            super();
        }

        private Object readResolve() {
            return TypeToken.this.getTypes().classes();
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeToken<T>.TypeSet interfaces() {
            throw new UnsupportedOperationException("classes().interfaces() not supported.");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.reflect.TypeToken.TypeSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection
        /* renamed from: n */
        public Set<TypeToken<? super T>> f() {
            ImmutableSet<TypeToken<? super T>> immutableSet = this.f28243b;
            if (immutableSet == null) {
                ImmutableSet<TypeToken<? super T>> set = FluentIterable.from(TypeCollector.f28246a.a().d(TypeToken.this)).filter(TypeFilter.IGNORE_TYPE_VARIABLE_OR_WILDCARD).toSet();
                this.f28243b = set;
                return set;
            }
            return immutableSet;
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public Set<Class<? super T>> rawTypes() {
            return ImmutableSet.copyOf((Collection) TypeCollector.f28247b.a().c(TypeToken.this.w()));
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeToken<T>.TypeSet classes() {
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public final class InterfaceSet extends TypeToken<T>.TypeSet {
        private static final long serialVersionUID = 0;

        /* renamed from: b  reason: collision with root package name */
        private final transient TypeToken<T>.TypeSet f28244b;
        @CheckForNull

        /* renamed from: c  reason: collision with root package name */
        private transient ImmutableSet<TypeToken<? super T>> f28245c;

        InterfaceSet(TypeToken<T>.TypeSet typeSet) {
            super();
            this.f28244b = typeSet;
        }

        private Object readResolve() {
            return TypeToken.this.getTypes().interfaces();
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeToken<T>.TypeSet classes() {
            throw new UnsupportedOperationException("interfaces().classes() not supported.");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.reflect.TypeToken.TypeSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection
        /* renamed from: n */
        public Set<TypeToken<? super T>> f() {
            ImmutableSet<TypeToken<? super T>> immutableSet = this.f28245c;
            if (immutableSet == null) {
                ImmutableSet<TypeToken<? super T>> set = FluentIterable.from(this.f28244b).filter(TypeFilter.INTERFACE_ONLY).toSet();
                this.f28245c = set;
                return set;
            }
            return immutableSet;
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public Set<Class<? super T>> rawTypes() {
            return FluentIterable.from(TypeCollector.f28247b.c(TypeToken.this.w())).filter(new Predicate() { // from class: com.google.common.reflect.c
                @Override // com.google.common.base.Predicate
                public final boolean apply(Object obj) {
                    return ((Class) obj).isInterface();
                }
            }).toSet();
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeToken<T>.TypeSet interfaces() {
            return this;
        }
    }
}
