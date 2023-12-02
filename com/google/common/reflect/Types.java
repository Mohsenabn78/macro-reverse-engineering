package com.google.common.reflect;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.reflect.Types;
import java.io.Serializable;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.security.AccessControlException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.CheckForNull;
import kotlin.text.Typography;
import net.bytebuddy.description.type.TypeDescription;
import okhttp3.HttpUrl;

/* JADX INFO: Access modifiers changed from: package-private */
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public final class Types {

    /* renamed from: a  reason: collision with root package name */
    private static final Joiner f28256a = Joiner.on(", ").useForNull("null");

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public enum ClassOwnership {
        OWNED_BY_ENCLOSING_CLASS { // from class: com.google.common.reflect.Types.ClassOwnership.1
            @Override // com.google.common.reflect.Types.ClassOwnership
            @CheckForNull
            Class<?> c(Class<?> cls) {
                return cls.getEnclosingClass();
            }
        },
        LOCAL_CLASS_HAS_NO_OWNER { // from class: com.google.common.reflect.Types.ClassOwnership.2
            @Override // com.google.common.reflect.Types.ClassOwnership
            @CheckForNull
            Class<?> c(Class<?> cls) {
                if (cls.isLocalClass()) {
                    return null;
                }
                return cls.getEnclosingClass();
            }
        };
        

        /* renamed from: c  reason: collision with root package name */
        static final ClassOwnership f28260c = b();

        private static ClassOwnership b() {
            ClassOwnership[] values;
            new C1LocalClass<String>() { // from class: com.google.common.reflect.Types.ClassOwnership.3
            };
            ParameterizedType parameterizedType = (ParameterizedType) AnonymousClass3.class.getGenericSuperclass();
            Objects.requireNonNull(parameterizedType);
            ParameterizedType parameterizedType2 = parameterizedType;
            for (ClassOwnership classOwnership : values()) {
                if (classOwnership.c(C1LocalClass.class) == parameterizedType2.getOwnerType()) {
                    return classOwnership;
                }
            }
            throw new AssertionError();
        }

        @CheckForNull
        abstract Class<?> c(Class<?> cls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class GenericArrayTypeImpl implements GenericArrayType, Serializable {
        private static final long serialVersionUID = 0;
        private final Type componentType;

        GenericArrayTypeImpl(Type type) {
            this.componentType = JavaVersion.f28266e.g(type);
        }

        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof GenericArrayType) {
                return com.google.common.base.Objects.equal(getGenericComponentType(), ((GenericArrayType) obj).getGenericComponentType());
            }
            return false;
        }

        @Override // java.lang.reflect.GenericArrayType
        public Type getGenericComponentType() {
            return this.componentType;
        }

        public int hashCode() {
            return this.componentType.hashCode();
        }

        public String toString() {
            return Types.s(this.componentType) + HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public enum JavaVersion {
        JAVA6 { // from class: com.google.common.reflect.Types.JavaVersion.1
            @Override // com.google.common.reflect.Types.JavaVersion
            Type g(Type type) {
                Preconditions.checkNotNull(type);
                if (type instanceof Class) {
                    Class cls = (Class) type;
                    if (cls.isArray()) {
                        return new GenericArrayTypeImpl(cls.getComponentType());
                    }
                    return type;
                }
                return type;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.reflect.Types.JavaVersion
            /* renamed from: h */
            public GenericArrayType c(Type type) {
                return new GenericArrayTypeImpl(type);
            }
        },
        JAVA7 { // from class: com.google.common.reflect.Types.JavaVersion.2
            @Override // com.google.common.reflect.Types.JavaVersion
            Type c(Type type) {
                if (type instanceof Class) {
                    return Types.h((Class) type);
                }
                return new GenericArrayTypeImpl(type);
            }

            @Override // com.google.common.reflect.Types.JavaVersion
            Type g(Type type) {
                return (Type) Preconditions.checkNotNull(type);
            }
        },
        JAVA8 { // from class: com.google.common.reflect.Types.JavaVersion.3
            @Override // com.google.common.reflect.Types.JavaVersion
            Type c(Type type) {
                return JavaVersion.JAVA7.c(type);
            }

            @Override // com.google.common.reflect.Types.JavaVersion
            String e(Type type) {
                try {
                    return (String) Type.class.getMethod("getTypeName", new Class[0]).invoke(type, new Object[0]);
                } catch (IllegalAccessException e4) {
                    throw new RuntimeException(e4);
                } catch (NoSuchMethodException unused) {
                    throw new AssertionError("Type.getTypeName should be available in Java 8");
                } catch (InvocationTargetException e5) {
                    throw new RuntimeException(e5);
                }
            }

            @Override // com.google.common.reflect.Types.JavaVersion
            Type g(Type type) {
                return JavaVersion.JAVA7.g(type);
            }
        },
        JAVA9 { // from class: com.google.common.reflect.Types.JavaVersion.4
            @Override // com.google.common.reflect.Types.JavaVersion
            boolean b() {
                return false;
            }

            @Override // com.google.common.reflect.Types.JavaVersion
            Type c(Type type) {
                return JavaVersion.JAVA8.c(type);
            }

            @Override // com.google.common.reflect.Types.JavaVersion
            String e(Type type) {
                return JavaVersion.JAVA8.e(type);
            }

            @Override // com.google.common.reflect.Types.JavaVersion
            Type g(Type type) {
                return JavaVersion.JAVA8.g(type);
            }
        };
        

        /* renamed from: e  reason: collision with root package name */
        static final JavaVersion f28266e;

        static {
            JavaVersion javaVersion;
            JavaVersion javaVersion2;
            JavaVersion javaVersion3;
            JavaVersion javaVersion4;
            if (AnnotatedElement.class.isAssignableFrom(TypeVariable.class)) {
                if (new TypeCapture<Map.Entry<String, int[][]>>() { // from class: com.google.common.reflect.Types.JavaVersion.5
                }.a().toString().contains("java.util.Map.java.util.Map")) {
                    f28266e = javaVersion3;
                } else {
                    f28266e = javaVersion4;
                }
            } else if (new TypeCapture<int[]>() { // from class: com.google.common.reflect.Types.JavaVersion.6
            }.a() instanceof Class) {
                f28266e = javaVersion2;
            } else {
                f28266e = javaVersion;
            }
        }

        boolean b() {
            return true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract Type c(Type type);

        /* JADX INFO: Access modifiers changed from: package-private */
        public String e(Type type) {
            return Types.s(type);
        }

        final ImmutableList<Type> f(Type[] typeArr) {
            ImmutableList.Builder builder = ImmutableList.builder();
            for (Type type : typeArr) {
                builder.add((ImmutableList.Builder) g(type));
            }
            return builder.build();
        }

        abstract Type g(Type type);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class NativeTypeVariableEquals<X> {

        /* renamed from: a  reason: collision with root package name */
        static final boolean f28268a = !NativeTypeVariableEquals.class.getTypeParameters()[0].equals(Types.k(NativeTypeVariableEquals.class, "X", new Type[0]));

        NativeTypeVariableEquals() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class ParameterizedTypeImpl implements ParameterizedType, Serializable {
        private static final long serialVersionUID = 0;
        private final ImmutableList<Type> argumentsList;
        @CheckForNull
        private final Type ownerType;
        private final Class<?> rawType;

        ParameterizedTypeImpl(@CheckForNull Type type, Class<?> cls, Type[] typeArr) {
            boolean z3;
            Preconditions.checkNotNull(cls);
            if (typeArr.length == cls.getTypeParameters().length) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3);
            Types.f(typeArr, "type parameter");
            this.ownerType = type;
            this.rawType = cls;
            this.argumentsList = JavaVersion.f28266e.f(typeArr);
        }

        public boolean equals(@CheckForNull Object obj) {
            if (!(obj instanceof ParameterizedType)) {
                return false;
            }
            ParameterizedType parameterizedType = (ParameterizedType) obj;
            if (!getRawType().equals(parameterizedType.getRawType()) || !com.google.common.base.Objects.equal(getOwnerType(), parameterizedType.getOwnerType()) || !Arrays.equals(getActualTypeArguments(), parameterizedType.getActualTypeArguments())) {
                return false;
            }
            return true;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return Types.r(this.argumentsList);
        }

        @Override // java.lang.reflect.ParameterizedType
        @CheckForNull
        public Type getOwnerType() {
            return this.ownerType;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return this.rawType;
        }

        public int hashCode() {
            int hashCode;
            Type type = this.ownerType;
            if (type == null) {
                hashCode = 0;
            } else {
                hashCode = type.hashCode();
            }
            return (hashCode ^ this.argumentsList.hashCode()) ^ this.rawType.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (this.ownerType != null) {
                JavaVersion javaVersion = JavaVersion.f28266e;
                if (javaVersion.b()) {
                    sb.append(javaVersion.e(this.ownerType));
                    sb.append('.');
                }
            }
            sb.append(this.rawType.getName());
            sb.append(Typography.less);
            Joiner joiner = Types.f28256a;
            ImmutableList<Type> immutableList = this.argumentsList;
            final JavaVersion javaVersion2 = JavaVersion.f28266e;
            Objects.requireNonNull(javaVersion2);
            sb.append(joiner.join(Iterables.transform(immutableList, new Function() { // from class: com.google.common.reflect.d
                @Override // com.google.common.base.Function
                public final Object apply(Object obj) {
                    return Types.JavaVersion.this.e((Type) obj);
                }
            })));
            sb.append(Typography.greater);
            return sb.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class TypeVariableImpl<D extends GenericDeclaration> {

        /* renamed from: a  reason: collision with root package name */
        private final D f28269a;

        /* renamed from: b  reason: collision with root package name */
        private final String f28270b;

        /* renamed from: c  reason: collision with root package name */
        private final ImmutableList<Type> f28271c;

        TypeVariableImpl(D d4, String str, Type[] typeArr) {
            Types.f(typeArr, "bound for type variable");
            this.f28269a = (D) Preconditions.checkNotNull(d4);
            this.f28270b = (String) Preconditions.checkNotNull(str);
            this.f28271c = ImmutableList.copyOf(typeArr);
        }

        public D a() {
            return this.f28269a;
        }

        public String b() {
            return this.f28270b;
        }

        public boolean equals(@CheckForNull Object obj) {
            if (NativeTypeVariableEquals.f28268a) {
                if (obj != null && Proxy.isProxyClass(obj.getClass()) && (Proxy.getInvocationHandler(obj) instanceof TypeVariableInvocationHandler)) {
                    TypeVariableImpl typeVariableImpl = ((TypeVariableInvocationHandler) Proxy.getInvocationHandler(obj)).f28273a;
                    if (this.f28270b.equals(typeVariableImpl.b()) && this.f28269a.equals(typeVariableImpl.a()) && this.f28271c.equals(typeVariableImpl.f28271c)) {
                        return true;
                    }
                    return false;
                }
                return false;
            } else if (!(obj instanceof TypeVariable)) {
                return false;
            } else {
                TypeVariable typeVariable = (TypeVariable) obj;
                if (this.f28270b.equals(typeVariable.getName()) && this.f28269a.equals(typeVariable.getGenericDeclaration())) {
                    return true;
                }
                return false;
            }
        }

        public int hashCode() {
            return this.f28269a.hashCode() ^ this.f28270b.hashCode();
        }

        public String toString() {
            return this.f28270b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class TypeVariableInvocationHandler implements InvocationHandler {

        /* renamed from: b  reason: collision with root package name */
        private static final ImmutableMap<String, Method> f28272b;

        /* renamed from: a  reason: collision with root package name */
        private final TypeVariableImpl<?> f28273a;

        static {
            Method[] methods;
            ImmutableMap.Builder builder = ImmutableMap.builder();
            for (Method method : TypeVariableImpl.class.getMethods()) {
                if (method.getDeclaringClass().equals(TypeVariableImpl.class)) {
                    try {
                        method.setAccessible(true);
                    } catch (AccessControlException unused) {
                    }
                    builder.put(method.getName(), method);
                }
            }
            f28272b = builder.buildKeepingLast();
        }

        TypeVariableInvocationHandler(TypeVariableImpl<?> typeVariableImpl) {
            this.f28273a = typeVariableImpl;
        }

        @Override // java.lang.reflect.InvocationHandler
        @CheckForNull
        public Object invoke(Object obj, Method method, @CheckForNull Object[] objArr) throws Throwable {
            String name = method.getName();
            Method method2 = f28272b.get(name);
            if (method2 != null) {
                try {
                    return method2.invoke(this.f28273a, objArr);
                } catch (InvocationTargetException e4) {
                    throw e4.getCause();
                }
            }
            throw new UnsupportedOperationException(name);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class WildcardTypeImpl implements WildcardType, Serializable {
        private static final long serialVersionUID = 0;
        private final ImmutableList<Type> lowerBounds;
        private final ImmutableList<Type> upperBounds;

        /* JADX INFO: Access modifiers changed from: package-private */
        public WildcardTypeImpl(Type[] typeArr, Type[] typeArr2) {
            Types.f(typeArr, "lower bound for wildcard");
            Types.f(typeArr2, "upper bound for wildcard");
            JavaVersion javaVersion = JavaVersion.f28266e;
            this.lowerBounds = javaVersion.f(typeArr);
            this.upperBounds = javaVersion.f(typeArr2);
        }

        public boolean equals(@CheckForNull Object obj) {
            if (!(obj instanceof WildcardType)) {
                return false;
            }
            WildcardType wildcardType = (WildcardType) obj;
            if (!this.lowerBounds.equals(Arrays.asList(wildcardType.getLowerBounds())) || !this.upperBounds.equals(Arrays.asList(wildcardType.getUpperBounds()))) {
                return false;
            }
            return true;
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getLowerBounds() {
            return Types.r(this.lowerBounds);
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getUpperBounds() {
            return Types.r(this.upperBounds);
        }

        public int hashCode() {
            return this.lowerBounds.hashCode() ^ this.upperBounds.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(TypeDescription.Generic.OfWildcardType.SYMBOL);
            UnmodifiableIterator<Type> it = this.lowerBounds.iterator();
            while (it.hasNext()) {
                sb.append(" super ");
                sb.append(JavaVersion.f28266e.e(it.next()));
            }
            for (Type type : Types.g(this.upperBounds)) {
                sb.append(" extends ");
                sb.append(JavaVersion.f28266e.e(type));
            }
            return sb.toString();
        }
    }

    private Types() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f(Type[] typeArr, String str) {
        Class cls;
        for (Type type : typeArr) {
            if (type instanceof Class) {
                Preconditions.checkArgument(!cls.isPrimitive(), "Primitive type '%s' used as %s", (Class) type, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Iterable<Type> g(Iterable<Type> iterable) {
        return Iterables.filter(iterable, Predicates.not(Predicates.equalTo(Object.class)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Class<?> h(Class<?> cls) {
        return Array.newInstance(cls, 0).getClass();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @CheckForNull
    public static Type i(Type type) {
        Preconditions.checkNotNull(type);
        final AtomicReference atomicReference = new AtomicReference();
        new TypeVisitor() { // from class: com.google.common.reflect.Types.1
            @Override // com.google.common.reflect.TypeVisitor
            void b(Class<?> cls) {
                atomicReference.set(cls.getComponentType());
            }

            @Override // com.google.common.reflect.TypeVisitor
            void c(GenericArrayType genericArrayType) {
                atomicReference.set(genericArrayType.getGenericComponentType());
            }

            @Override // com.google.common.reflect.TypeVisitor
            void e(TypeVariable<?> typeVariable) {
                atomicReference.set(Types.p(typeVariable.getBounds()));
            }

            @Override // com.google.common.reflect.TypeVisitor
            void f(WildcardType wildcardType) {
                atomicReference.set(Types.p(wildcardType.getUpperBounds()));
            }
        }.a(type);
        return (Type) atomicReference.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Type j(Type type) {
        boolean z3;
        if (type instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType) type;
            Type[] lowerBounds = wildcardType.getLowerBounds();
            boolean z4 = true;
            if (lowerBounds.length <= 1) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "Wildcard cannot have more than one lower bounds.");
            if (lowerBounds.length == 1) {
                return q(j(lowerBounds[0]));
            }
            Type[] upperBounds = wildcardType.getUpperBounds();
            if (upperBounds.length != 1) {
                z4 = false;
            }
            Preconditions.checkArgument(z4, "Wildcard should have only one upper bound.");
            return o(j(upperBounds[0]));
        }
        return JavaVersion.f28266e.c(type);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <D extends GenericDeclaration> TypeVariable<D> k(D d4, String str, Type... typeArr) {
        if (typeArr.length == 0) {
            typeArr = new Type[]{Object.class};
        }
        return n(d4, str, typeArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ParameterizedType l(Class<?> cls, Type... typeArr) {
        return new ParameterizedTypeImpl(ClassOwnership.f28260c.c(cls), cls, typeArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ParameterizedType m(@CheckForNull Type type, Class<?> cls, Type... typeArr) {
        boolean z3;
        if (type == null) {
            return l(cls, typeArr);
        }
        Preconditions.checkNotNull(typeArr);
        if (cls.getEnclosingClass() != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "Owner type for unenclosed %s", cls);
        return new ParameterizedTypeImpl(type, cls, typeArr);
    }

    private static <D extends GenericDeclaration> TypeVariable<D> n(D d4, String str, Type[] typeArr) {
        return (TypeVariable) Reflection.newProxy(TypeVariable.class, new TypeVariableInvocationHandler(new TypeVariableImpl(d4, str, typeArr)));
    }

    @VisibleForTesting
    static WildcardType o(Type type) {
        return new WildcardTypeImpl(new Type[0], new Type[]{type});
    }

    /* JADX INFO: Access modifiers changed from: private */
    @CheckForNull
    public static Type p(Type[] typeArr) {
        for (Type type : typeArr) {
            Type i4 = i(type);
            if (i4 != null) {
                if (i4 instanceof Class) {
                    Class cls = (Class) i4;
                    if (cls.isPrimitive()) {
                        return cls;
                    }
                }
                return o(i4);
            }
        }
        return null;
    }

    @VisibleForTesting
    static WildcardType q(Type type) {
        return new WildcardTypeImpl(new Type[]{type}, new Type[]{Object.class});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Type[] r(Collection<Type> collection) {
        return (Type[]) collection.toArray(new Type[0]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String s(Type type) {
        if (type instanceof Class) {
            return ((Class) type).getName();
        }
        return type.toString();
    }
}
