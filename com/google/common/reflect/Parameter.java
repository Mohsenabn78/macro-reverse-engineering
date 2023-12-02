package com.google.common.reflect;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableIterator;
import com.google.errorprone.annotations.DoNotCall;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.AnnotatedType;
import java.util.Objects;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public final class Parameter implements AnnotatedElement {

    /* renamed from: a  reason: collision with root package name */
    private final Invokable<?, ?> f28218a;

    /* renamed from: b  reason: collision with root package name */
    private final int f28219b;

    /* renamed from: c  reason: collision with root package name */
    private final TypeToken<?> f28220c;

    /* renamed from: d  reason: collision with root package name */
    private final ImmutableList<Annotation> f28221d;

    /* renamed from: e  reason: collision with root package name */
    private final Object f28222e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Parameter(Invokable<?, ?> invokable, int i4, TypeToken<?> typeToken, Annotation[] annotationArr, Object obj) {
        this.f28218a = invokable;
        this.f28219b = i4;
        this.f28220c = typeToken;
        this.f28221d = ImmutableList.copyOf(annotationArr);
        this.f28222e = obj;
    }

    public boolean equals(@CheckForNull Object obj) {
        if (!(obj instanceof Parameter)) {
            return false;
        }
        Parameter parameter = (Parameter) obj;
        if (this.f28219b != parameter.f28219b || !this.f28218a.equals(parameter.f28218a)) {
            return false;
        }
        return true;
    }

    @Beta
    @DoNotCall("fails under Android VMs; do not use from guava-android")
    @Deprecated
    @IgnoreJRERequirement
    public AnnotatedType getAnnotatedType() {
        AnnotatedType annotatedType = (AnnotatedType) this.f28222e;
        Objects.requireNonNull(annotatedType);
        return annotatedType;
    }

    @Override // java.lang.reflect.AnnotatedElement
    @CheckForNull
    public <A extends Annotation> A getAnnotation(Class<A> cls) {
        Preconditions.checkNotNull(cls);
        UnmodifiableIterator<Annotation> it = this.f28221d.iterator();
        while (it.hasNext()) {
            Annotation next = it.next();
            if (cls.isInstance(next)) {
                return cls.cast(next);
            }
        }
        return null;
    }

    @Override // java.lang.reflect.AnnotatedElement
    public Annotation[] getAnnotations() {
        return getDeclaredAnnotations();
    }

    @Override // java.lang.reflect.AnnotatedElement
    public <A extends Annotation> A[] getAnnotationsByType(Class<A> cls) {
        return (A[]) getDeclaredAnnotationsByType(cls);
    }

    @Override // java.lang.reflect.AnnotatedElement
    @CheckForNull
    public <A extends Annotation> A getDeclaredAnnotation(Class<A> cls) {
        Preconditions.checkNotNull(cls);
        return (A) FluentIterable.from(this.f28221d).filter(cls).first().orNull();
    }

    @Override // java.lang.reflect.AnnotatedElement
    public Annotation[] getDeclaredAnnotations() {
        return (Annotation[]) this.f28221d.toArray(new Annotation[0]);
    }

    @Override // java.lang.reflect.AnnotatedElement
    public <A extends Annotation> A[] getDeclaredAnnotationsByType(Class<A> cls) {
        return (A[]) ((Annotation[]) FluentIterable.from(this.f28221d).filter(cls).toArray(cls));
    }

    public Invokable<?, ?> getDeclaringInvokable() {
        return this.f28218a;
    }

    public TypeToken<?> getType() {
        return this.f28220c;
    }

    public int hashCode() {
        return this.f28219b;
    }

    @Override // java.lang.reflect.AnnotatedElement
    public boolean isAnnotationPresent(Class<? extends Annotation> cls) {
        if (getAnnotation(cls) != null) {
            return true;
        }
        return false;
    }

    public String toString() {
        return this.f28220c + " arg" + this.f28219b;
    }
}
