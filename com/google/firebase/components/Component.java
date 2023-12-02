package com.google.firebase.components;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes5.dex */
public final class Component<T> {

    /* renamed from: a  reason: collision with root package name */
    private final String f29175a;

    /* renamed from: b  reason: collision with root package name */
    private final Set<Qualified<? super T>> f29176b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<Dependency> f29177c;

    /* renamed from: d  reason: collision with root package name */
    private final int f29178d;

    /* renamed from: e  reason: collision with root package name */
    private final int f29179e;

    /* renamed from: f  reason: collision with root package name */
    private final ComponentFactory<T> f29180f;

    /* renamed from: g  reason: collision with root package name */
    private final Set<Class<?>> f29181g;

    public static <T> Builder<T> builder(Class<T> cls) {
        return new Builder<>(cls, new Class[0]);
    }

    public static <T> Component<T> intoSet(final T t3, Class<T> cls) {
        return intoSetBuilder(cls).factory(new ComponentFactory() { // from class: com.google.firebase.components.b
            @Override // com.google.firebase.components.ComponentFactory
            public final Object create(ComponentContainer componentContainer) {
                Object f4;
                f4 = Component.f(t3, componentContainer);
                return f4;
            }
        }).build();
    }

    public static <T> Builder<T> intoSetBuilder(Class<T> cls) {
        return builder(cls).b();
    }

    @Deprecated
    public static <T> Component<T> of(Class<T> cls, final T t3) {
        return builder(cls).factory(new ComponentFactory() { // from class: com.google.firebase.components.e
            @Override // com.google.firebase.components.ComponentFactory
            public final Object create(ComponentContainer componentContainer) {
                Object h4;
                h4 = Component.h(t3, componentContainer);
                return h4;
            }
        }).build();
    }

    public Set<Dependency> getDependencies() {
        return this.f29177c;
    }

    public ComponentFactory<T> getFactory() {
        return this.f29180f;
    }

    @Nullable
    public String getName() {
        return this.f29175a;
    }

    public Set<Qualified<? super T>> getProvidedInterfaces() {
        return this.f29176b;
    }

    public Set<Class<?>> getPublishedEvents() {
        return this.f29181g;
    }

    public boolean isAlwaysEager() {
        if (this.f29178d == 1) {
            return true;
        }
        return false;
    }

    public boolean isEagerInDefaultApp() {
        if (this.f29178d == 2) {
            return true;
        }
        return false;
    }

    public boolean isLazy() {
        if (this.f29178d == 0) {
            return true;
        }
        return false;
    }

    public boolean isValue() {
        if (this.f29179e == 0) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "Component<" + Arrays.toString(this.f29176b.toArray()) + ">{" + this.f29178d + ", type=" + this.f29179e + ", deps=" + Arrays.toString(this.f29177c.toArray()) + "}";
    }

    public Component<T> withFactory(ComponentFactory<T> componentFactory) {
        return new Component<>(this.f29175a, this.f29176b, this.f29177c, this.f29178d, this.f29179e, componentFactory, this.f29181g);
    }

    /* loaded from: classes5.dex */
    public static class Builder<T> {

        /* renamed from: a  reason: collision with root package name */
        private String f29182a;

        /* renamed from: b  reason: collision with root package name */
        private final Set<Qualified<? super T>> f29183b;

        /* renamed from: c  reason: collision with root package name */
        private final Set<Dependency> f29184c;

        /* renamed from: d  reason: collision with root package name */
        private int f29185d;

        /* renamed from: e  reason: collision with root package name */
        private int f29186e;

        /* renamed from: f  reason: collision with root package name */
        private ComponentFactory<T> f29187f;

        /* renamed from: g  reason: collision with root package name */
        private final Set<Class<?>> f29188g;

        /* JADX INFO: Access modifiers changed from: private */
        @CanIgnoreReturnValue
        public Builder<T> b() {
            this.f29186e = 1;
            return this;
        }

        @CanIgnoreReturnValue
        private Builder<T> c(int i4) {
            boolean z3;
            if (this.f29185d == 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkState(z3, "Instantiation type has already been set.");
            this.f29185d = i4;
            return this;
        }

        private void d(Qualified<?> qualified) {
            Preconditions.checkArgument(!this.f29183b.contains(qualified), "Components are not allowed to depend on interfaces they themselves provide.");
        }

        @CanIgnoreReturnValue
        public Builder<T> add(Dependency dependency) {
            Preconditions.checkNotNull(dependency, "Null dependency");
            d(dependency.getInterface());
            this.f29184c.add(dependency);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<T> alwaysEager() {
            return c(1);
        }

        public Component<T> build() {
            boolean z3;
            if (this.f29187f != null) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkState(z3, "Missing required property: factory.");
            return new Component<>(this.f29182a, new HashSet(this.f29183b), new HashSet(this.f29184c), this.f29185d, this.f29186e, this.f29187f, this.f29188g);
        }

        @CanIgnoreReturnValue
        public Builder<T> eagerInDefaultApp() {
            return c(2);
        }

        @CanIgnoreReturnValue
        public Builder<T> factory(ComponentFactory<T> componentFactory) {
            this.f29187f = (ComponentFactory) Preconditions.checkNotNull(componentFactory, "Null factory");
            return this;
        }

        public Builder<T> name(@NonNull String str) {
            this.f29182a = str;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<T> publishes(Class<?> cls) {
            this.f29188g.add(cls);
            return this;
        }

        @SafeVarargs
        private Builder(Class<T> cls, Class<? super T>... clsArr) {
            this.f29182a = null;
            HashSet hashSet = new HashSet();
            this.f29183b = hashSet;
            this.f29184c = new HashSet();
            this.f29185d = 0;
            this.f29186e = 0;
            this.f29188g = new HashSet();
            Preconditions.checkNotNull(cls, "Null interface");
            hashSet.add(Qualified.unqualified(cls));
            for (Class<? super T> cls2 : clsArr) {
                Preconditions.checkNotNull(cls2, "Null interface");
                this.f29183b.add(Qualified.unqualified(cls2));
            }
        }

        @SafeVarargs
        private Builder(Qualified<T> qualified, Qualified<? super T>... qualifiedArr) {
            this.f29182a = null;
            HashSet hashSet = new HashSet();
            this.f29183b = hashSet;
            this.f29184c = new HashSet();
            this.f29185d = 0;
            this.f29186e = 0;
            this.f29188g = new HashSet();
            Preconditions.checkNotNull(qualified, "Null interface");
            hashSet.add(qualified);
            for (Qualified<? super T> qualified2 : qualifiedArr) {
                Preconditions.checkNotNull(qualified2, "Null interface");
            }
            Collections.addAll(this.f29183b, qualifiedArr);
        }
    }

    private Component(@Nullable String str, Set<Qualified<? super T>> set, Set<Dependency> set2, int i4, int i5, ComponentFactory<T> componentFactory, Set<Class<?>> set3) {
        this.f29175a = str;
        this.f29176b = Collections.unmodifiableSet(set);
        this.f29177c = Collections.unmodifiableSet(set2);
        this.f29178d = i4;
        this.f29179e = i5;
        this.f29180f = componentFactory;
        this.f29181g = Collections.unmodifiableSet(set3);
    }

    @SafeVarargs
    public static <T> Builder<T> builder(Class<T> cls, Class<? super T>... clsArr) {
        return new Builder<>(cls, clsArr);
    }

    public static <T> Component<T> intoSet(final T t3, Qualified<T> qualified) {
        return intoSetBuilder(qualified).factory(new ComponentFactory() { // from class: com.google.firebase.components.c
            @Override // com.google.firebase.components.ComponentFactory
            public final Object create(ComponentContainer componentContainer) {
                Object g4;
                g4 = Component.g(t3, componentContainer);
                return g4;
            }
        }).build();
    }

    public static <T> Builder<T> intoSetBuilder(Qualified<T> qualified) {
        return builder(qualified).b();
    }

    @SafeVarargs
    public static <T> Component<T> of(final T t3, Class<T> cls, Class<? super T>... clsArr) {
        return builder(cls, clsArr).factory(new ComponentFactory() { // from class: com.google.firebase.components.a
            @Override // com.google.firebase.components.ComponentFactory
            public final Object create(ComponentContainer componentContainer) {
                Object i4;
                i4 = Component.i(t3, componentContainer);
                return i4;
            }
        }).build();
    }

    public static <T> Builder<T> builder(Qualified<T> qualified) {
        return new Builder<>(qualified, new Qualified[0]);
    }

    @SafeVarargs
    public static <T> Component<T> of(final T t3, Qualified<T> qualified, Qualified<? super T>... qualifiedArr) {
        return builder(qualified, qualifiedArr).factory(new ComponentFactory() { // from class: com.google.firebase.components.d
            @Override // com.google.firebase.components.ComponentFactory
            public final Object create(ComponentContainer componentContainer) {
                Object j4;
                j4 = Component.j(t3, componentContainer);
                return j4;
            }
        }).build();
    }

    @SafeVarargs
    public static <T> Builder<T> builder(Qualified<T> qualified, Qualified<? super T>... qualifiedArr) {
        return new Builder<>(qualified, qualifiedArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object f(Object obj, ComponentContainer componentContainer) {
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object g(Object obj, ComponentContainer componentContainer) {
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object h(Object obj, ComponentContainer componentContainer) {
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object i(Object obj, ComponentContainer componentContainer) {
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object j(Object obj, ComponentContainer componentContainer) {
        return obj;
    }
}
