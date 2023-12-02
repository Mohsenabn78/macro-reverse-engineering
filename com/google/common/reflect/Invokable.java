package com.google.common.reflect;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotCall;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public abstract class Invokable<T, R> implements AnnotatedElement, Member {

    /* renamed from: c  reason: collision with root package name */
    private static final boolean f28210c = f();

    /* renamed from: a  reason: collision with root package name */
    private final AccessibleObject f28211a;

    /* renamed from: b  reason: collision with root package name */
    private final Member f28212b;

    /* loaded from: classes5.dex */
    static class ConstructorInvokable<T> extends Invokable<T, T> {

        /* renamed from: d  reason: collision with root package name */
        final Constructor<?> f28213d;

        /* JADX INFO: Access modifiers changed from: package-private */
        public ConstructorInvokable(Constructor<?> constructor) {
            super(constructor);
            this.f28213d = constructor;
        }

        private boolean h() {
            Class<?> declaringClass = this.f28213d.getDeclaringClass();
            if (declaringClass.getEnclosingConstructor() != null) {
                return true;
            }
            Method enclosingMethod = declaringClass.getEnclosingMethod();
            if (enclosingMethod != null) {
                return !Modifier.isStatic(enclosingMethod.getModifiers());
            }
            if (declaringClass.getEnclosingClass() != null && !Modifier.isStatic(declaringClass.getModifiers())) {
                return true;
            }
            return false;
        }

        @Override // com.google.common.reflect.Invokable
        @IgnoreJRERequirement
        AnnotatedType[] a() {
            return this.f28213d.getAnnotatedParameterTypes();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.reflect.Invokable
        public Type[] b() {
            return this.f28213d.getGenericExceptionTypes();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.reflect.Invokable
        public Type[] c() {
            Type[] genericParameterTypes = this.f28213d.getGenericParameterTypes();
            if (genericParameterTypes.length > 0 && h()) {
                Class<?>[] parameterTypes = this.f28213d.getParameterTypes();
                if (genericParameterTypes.length == parameterTypes.length && parameterTypes[0] == getDeclaringClass().getEnclosingClass()) {
                    return (Type[]) Arrays.copyOfRange(genericParameterTypes, 1, genericParameterTypes.length);
                }
                return genericParameterTypes;
            }
            return genericParameterTypes;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.reflect.Invokable
        public Type d() {
            Class<? super T> declaringClass = getDeclaringClass();
            TypeVariable<Class<? super T>>[] typeParameters = declaringClass.getTypeParameters();
            if (typeParameters.length > 0) {
                return Types.l(declaringClass, typeParameters);
            }
            return declaringClass;
        }

        @Override // com.google.common.reflect.Invokable
        final Annotation[][] e() {
            return this.f28213d.getParameterAnnotations();
        }

        @Override // com.google.common.reflect.Invokable
        final Object g(@CheckForNull Object obj, Object[] objArr) throws InvocationTargetException, IllegalAccessException {
            try {
                return this.f28213d.newInstance(objArr);
            } catch (InstantiationException e4) {
                throw new RuntimeException(this.f28213d + " failed.", e4);
            }
        }

        @Override // com.google.common.reflect.Invokable
        @IgnoreJRERequirement
        @DoNotCall
        public AnnotatedType getAnnotatedReturnType() {
            return this.f28213d.getAnnotatedReturnType();
        }

        @Override // com.google.common.reflect.Invokable
        public final TypeVariable<?>[] getTypeParameters() {
            TypeVariable<Class<? super T>>[] typeParameters = getDeclaringClass().getTypeParameters();
            TypeVariable<Constructor<?>>[] typeParameters2 = this.f28213d.getTypeParameters();
            TypeVariable<?>[] typeVariableArr = new TypeVariable[typeParameters.length + typeParameters2.length];
            System.arraycopy(typeParameters, 0, typeVariableArr, 0, typeParameters.length);
            System.arraycopy(typeParameters2, 0, typeVariableArr, typeParameters.length, typeParameters2.length);
            return typeVariableArr;
        }

        @Override // com.google.common.reflect.Invokable
        public final boolean isOverridable() {
            return false;
        }

        @Override // com.google.common.reflect.Invokable
        public final boolean isVarArgs() {
            return this.f28213d.isVarArgs();
        }
    }

    /* loaded from: classes5.dex */
    static class MethodInvokable<T> extends Invokable<T, Object> {

        /* renamed from: d  reason: collision with root package name */
        final Method f28214d;

        /* JADX INFO: Access modifiers changed from: package-private */
        public MethodInvokable(Method method) {
            super(method);
            this.f28214d = method;
        }

        @Override // com.google.common.reflect.Invokable
        @IgnoreJRERequirement
        AnnotatedType[] a() {
            return this.f28214d.getAnnotatedParameterTypes();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.reflect.Invokable
        public Type[] b() {
            return this.f28214d.getGenericExceptionTypes();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.reflect.Invokable
        public Type[] c() {
            return this.f28214d.getGenericParameterTypes();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.reflect.Invokable
        public Type d() {
            return this.f28214d.getGenericReturnType();
        }

        @Override // com.google.common.reflect.Invokable
        final Annotation[][] e() {
            return this.f28214d.getParameterAnnotations();
        }

        @Override // com.google.common.reflect.Invokable
        @CheckForNull
        final Object g(@CheckForNull Object obj, Object[] objArr) throws InvocationTargetException, IllegalAccessException {
            return this.f28214d.invoke(obj, objArr);
        }

        @Override // com.google.common.reflect.Invokable
        @IgnoreJRERequirement
        @DoNotCall
        public AnnotatedType getAnnotatedReturnType() {
            return this.f28214d.getAnnotatedReturnType();
        }

        @Override // com.google.common.reflect.Invokable
        public final TypeVariable<?>[] getTypeParameters() {
            return this.f28214d.getTypeParameters();
        }

        @Override // com.google.common.reflect.Invokable
        public final boolean isOverridable() {
            if (!isFinal() && !isPrivate() && !isStatic() && !Modifier.isFinal(getDeclaringClass().getModifiers())) {
                return true;
            }
            return false;
        }

        @Override // com.google.common.reflect.Invokable
        public final boolean isVarArgs() {
            return this.f28214d.isVarArgs();
        }
    }

    <M extends AccessibleObject & Member> Invokable(M m4) {
        Preconditions.checkNotNull(m4);
        this.f28211a = m4;
        this.f28212b = m4;
    }

    private static boolean f() {
        try {
            Class.forName("java.lang.reflect.AnnotatedType");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static Invokable<?, Object> from(Method method) {
        return new MethodInvokable(method);
    }

    @IgnoreJRERequirement
    abstract AnnotatedType[] a();

    abstract Type[] b();

    abstract Type[] c();

    abstract Type d();

    abstract Annotation[][] e();

    public boolean equals(@CheckForNull Object obj) {
        if (!(obj instanceof Invokable)) {
            return false;
        }
        Invokable invokable = (Invokable) obj;
        if (!getOwnerType().equals(invokable.getOwnerType()) || !this.f28212b.equals(invokable.f28212b)) {
            return false;
        }
        return true;
    }

    @CheckForNull
    abstract Object g(@CheckForNull Object obj, Object[] objArr) throws InvocationTargetException, IllegalAccessException;

    @Beta
    @DoNotCall("fails under Android VMs; do not use from guava-android")
    @Deprecated
    @IgnoreJRERequirement
    public abstract AnnotatedType getAnnotatedReturnType();

    @Override // java.lang.reflect.AnnotatedElement
    @CheckForNull
    public final <A extends Annotation> A getAnnotation(Class<A> cls) {
        return (A) this.f28211a.getAnnotation(cls);
    }

    @Override // java.lang.reflect.AnnotatedElement
    public final Annotation[] getAnnotations() {
        return this.f28211a.getAnnotations();
    }

    @Override // java.lang.reflect.AnnotatedElement
    public final Annotation[] getDeclaredAnnotations() {
        return this.f28211a.getDeclaredAnnotations();
    }

    @Override // java.lang.reflect.Member
    public final Class<? super T> getDeclaringClass() {
        return (Class<? super T>) this.f28212b.getDeclaringClass();
    }

    public final ImmutableList<TypeToken<? extends Throwable>> getExceptionTypes() {
        ImmutableList.Builder builder = ImmutableList.builder();
        for (Type type : b()) {
            builder.add((ImmutableList.Builder) TypeToken.of(type));
        }
        return builder.build();
    }

    @Override // java.lang.reflect.Member
    public final int getModifiers() {
        return this.f28212b.getModifiers();
    }

    @Override // java.lang.reflect.Member
    public final String getName() {
        return this.f28212b.getName();
    }

    public TypeToken<T> getOwnerType() {
        return TypeToken.of((Class) getDeclaringClass());
    }

    @IgnoreJRERequirement
    public final ImmutableList<Parameter> getParameters() {
        Object[] objArr;
        Type[] c4 = c();
        Annotation[][] e4 = e();
        if (f28210c) {
            objArr = a();
        } else {
            objArr = new Object[c4.length];
        }
        ImmutableList.Builder builder = ImmutableList.builder();
        for (int i4 = 0; i4 < c4.length; i4++) {
            builder.add((ImmutableList.Builder) new Parameter(this, i4, TypeToken.of(c4[i4]), e4[i4], objArr[i4]));
        }
        return builder.build();
    }

    public final TypeToken<? extends R> getReturnType() {
        return (TypeToken<? extends R>) TypeToken.of(d());
    }

    public abstract TypeVariable<?>[] getTypeParameters();

    public int hashCode() {
        return this.f28212b.hashCode();
    }

    @CanIgnoreReturnValue
    @CheckForNull
    public final R invoke(@CheckForNull T t3, Object... objArr) throws InvocationTargetException, IllegalAccessException {
        return (R) g(t3, (Object[]) Preconditions.checkNotNull(objArr));
    }

    public final boolean isAbstract() {
        return Modifier.isAbstract(getModifiers());
    }

    public final boolean isAccessible() {
        return this.f28211a.isAccessible();
    }

    @Override // java.lang.reflect.AnnotatedElement
    public final boolean isAnnotationPresent(Class<? extends Annotation> cls) {
        return this.f28211a.isAnnotationPresent(cls);
    }

    public final boolean isFinal() {
        return Modifier.isFinal(getModifiers());
    }

    public final boolean isNative() {
        return Modifier.isNative(getModifiers());
    }

    public abstract boolean isOverridable();

    public final boolean isPackagePrivate() {
        if (!isPrivate() && !isPublic() && !isProtected()) {
            return true;
        }
        return false;
    }

    public final boolean isPrivate() {
        return Modifier.isPrivate(getModifiers());
    }

    public final boolean isProtected() {
        return Modifier.isProtected(getModifiers());
    }

    public final boolean isPublic() {
        return Modifier.isPublic(getModifiers());
    }

    public final boolean isStatic() {
        return Modifier.isStatic(getModifiers());
    }

    public final boolean isSynchronized() {
        return Modifier.isSynchronized(getModifiers());
    }

    @Override // java.lang.reflect.Member
    public final boolean isSynthetic() {
        return this.f28212b.isSynthetic();
    }

    public abstract boolean isVarArgs();

    public final <R1 extends R> Invokable<T, R1> returning(Class<R1> cls) {
        return returning(TypeToken.of((Class) cls));
    }

    public final void setAccessible(boolean z3) {
        this.f28211a.setAccessible(z3);
    }

    public String toString() {
        return this.f28212b.toString();
    }

    public final boolean trySetAccessible() {
        try {
            this.f28211a.setAccessible(true);
            return true;
        } catch (RuntimeException unused) {
            return false;
        }
    }

    public static <T> Invokable<T, T> from(Constructor<T> constructor) {
        return new ConstructorInvokable(constructor);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R1 extends R> Invokable<T, R1> returning(TypeToken<R1> typeToken) {
        if (typeToken.isSupertypeOf(getReturnType())) {
            return this;
        }
        throw new IllegalArgumentException("Invokable is known to return " + getReturnType() + ", not " + typeToken);
    }
}
