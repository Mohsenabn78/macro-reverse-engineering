package com.google.firebase.components;

import android.util.Log;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.firebase.components.ComponentRuntime;
import com.google.firebase.dynamicloading.ComponentLoader;
import com.google.firebase.events.Publisher;
import com.google.firebase.events.Subscriber;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public class ComponentRuntime implements ComponentContainer, ComponentLoader {

    /* renamed from: h  reason: collision with root package name */
    private static final Provider<Set<Object>> f29192h = new Provider() { // from class: com.google.firebase.components.k
        @Override // com.google.firebase.inject.Provider
        public final Object get() {
            return Collections.emptySet();
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final Map<Component<?>, Provider<?>> f29193a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<Qualified<?>, Provider<?>> f29194b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<Qualified<?>, LazySet<?>> f29195c;

    /* renamed from: d  reason: collision with root package name */
    private final List<Provider<ComponentRegistrar>> f29196d;

    /* renamed from: e  reason: collision with root package name */
    private final EventBus f29197e;

    /* renamed from: f  reason: collision with root package name */
    private final AtomicReference<Boolean> f29198f;

    /* renamed from: g  reason: collision with root package name */
    private final ComponentRegistrarProcessor f29199g;

    public static Builder builder(Executor executor) {
        return new Builder(executor);
    }

    private void e(List<Component<?>> list) {
        ArrayList<Runnable> arrayList = new ArrayList();
        synchronized (this) {
            Iterator<Provider<ComponentRegistrar>> it = this.f29196d.iterator();
            while (it.hasNext()) {
                try {
                    ComponentRegistrar componentRegistrar = it.next().get();
                    if (componentRegistrar != null) {
                        list.addAll(this.f29199g.processRegistrar(componentRegistrar));
                        it.remove();
                    }
                } catch (InvalidRegistrarException e4) {
                    it.remove();
                    Log.w("ComponentDiscovery", "Invalid component registrar.", e4);
                }
            }
            if (this.f29193a.isEmpty()) {
                CycleDetector.a(list);
            } else {
                ArrayList arrayList2 = new ArrayList(this.f29193a.keySet());
                arrayList2.addAll(list);
                CycleDetector.a(arrayList2);
            }
            for (final Component<?> component : list) {
                this.f29193a.put(component, new Lazy(new Provider() { // from class: com.google.firebase.components.i
                    @Override // com.google.firebase.inject.Provider
                    public final Object get() {
                        Object h4;
                        h4 = ComponentRuntime.this.h(component);
                        return h4;
                    }
                }));
            }
            arrayList.addAll(n(list));
            arrayList.addAll(o());
            m();
        }
        for (Runnable runnable : arrayList) {
            runnable.run();
        }
        l();
    }

    private void f(Map<Component<?>, Provider<?>> map, boolean z3) {
        for (Map.Entry<Component<?>, Provider<?>> entry : map.entrySet()) {
            Component<?> key = entry.getKey();
            Provider<?> value = entry.getValue();
            if (key.isAlwaysEager() || (key.isEagerInDefaultApp() && z3)) {
                value.get();
            }
        }
        this.f29197e.b();
    }

    private static <T> List<T> g(Iterable<T> iterable) {
        ArrayList arrayList = new ArrayList();
        for (T t3 : iterable) {
            arrayList.add(t3);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object h(Component component) {
        return component.getFactory().create(new RestrictedComponentContainer(component, this));
    }

    private void l() {
        Boolean bool = this.f29198f.get();
        if (bool != null) {
            f(this.f29193a, bool.booleanValue());
        }
    }

    private void m() {
        for (Component<?> component : this.f29193a.keySet()) {
            for (Dependency dependency : component.getDependencies()) {
                if (dependency.isSet() && !this.f29195c.containsKey(dependency.getInterface())) {
                    this.f29195c.put(dependency.getInterface(), LazySet.b(Collections.emptySet()));
                } else if (this.f29194b.containsKey(dependency.getInterface())) {
                    continue;
                } else if (!dependency.isRequired()) {
                    if (!dependency.isSet()) {
                        this.f29194b.put(dependency.getInterface(), OptionalProvider.d());
                    }
                } else {
                    throw new MissingDependencyException(String.format("Unsatisfied dependency for component %s: %s", component, dependency.getInterface()));
                }
            }
        }
    }

    private List<Runnable> n(List<Component<?>> list) {
        ArrayList arrayList = new ArrayList();
        for (Component<?> component : list) {
            if (component.isValue()) {
                final Provider<?> provider = this.f29193a.get(component);
                for (Qualified<? super Object> qualified : component.getProvidedInterfaces()) {
                    if (!this.f29194b.containsKey(qualified)) {
                        this.f29194b.put(qualified, provider);
                    } else {
                        final OptionalProvider optionalProvider = (OptionalProvider) this.f29194b.get(qualified);
                        arrayList.add(new Runnable() { // from class: com.google.firebase.components.l
                            @Override // java.lang.Runnable
                            public final void run() {
                                OptionalProvider.this.i(provider);
                            }
                        });
                    }
                }
            }
        }
        return arrayList;
    }

    private List<Runnable> o() {
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        for (Map.Entry<Component<?>, Provider<?>> entry : this.f29193a.entrySet()) {
            Component<?> key = entry.getKey();
            if (!key.isValue()) {
                Provider<?> value = entry.getValue();
                for (Qualified<? super Object> qualified : key.getProvidedInterfaces()) {
                    if (!hashMap.containsKey(qualified)) {
                        hashMap.put(qualified, new HashSet());
                    }
                    ((Set) hashMap.get(qualified)).add(value);
                }
            }
        }
        for (Map.Entry entry2 : hashMap.entrySet()) {
            if (!this.f29195c.containsKey(entry2.getKey())) {
                this.f29195c.put((Qualified) entry2.getKey(), LazySet.b((Collection) entry2.getValue()));
            } else {
                final LazySet<?> lazySet = this.f29195c.get(entry2.getKey());
                for (final Provider provider : (Set) entry2.getValue()) {
                    arrayList.add(new Runnable() { // from class: com.google.firebase.components.m
                        @Override // java.lang.Runnable
                        public final void run() {
                            LazySet.this.a(provider);
                        }
                    });
                }
            }
        }
        return arrayList;
    }

    private static Iterable<Provider<ComponentRegistrar>> p(Iterable<ComponentRegistrar> iterable) {
        ArrayList arrayList = new ArrayList();
        for (final ComponentRegistrar componentRegistrar : iterable) {
            arrayList.add(new Provider() { // from class: com.google.firebase.components.j
                @Override // com.google.firebase.inject.Provider
                public final Object get() {
                    ComponentRegistrar k4;
                    k4 = ComponentRuntime.k(ComponentRegistrar.this);
                    return k4;
                }
            });
        }
        return arrayList;
    }

    @Override // com.google.firebase.dynamicloading.ComponentLoader
    public void discoverComponents() {
        synchronized (this) {
            if (this.f29196d.isEmpty()) {
                return;
            }
            e(new ArrayList());
        }
    }

    @Override // com.google.firebase.components.ComponentContainer
    public /* synthetic */ Object get(Qualified qualified) {
        return f.a(this, qualified);
    }

    @Override // com.google.firebase.components.ComponentContainer
    public /* synthetic */ Deferred getDeferred(Class cls) {
        return f.c(this, cls);
    }

    @Override // com.google.firebase.components.ComponentContainer
    public /* synthetic */ Provider getProvider(Class cls) {
        return f.d(this, cls);
    }

    @RestrictTo({RestrictTo.Scope.TESTS})
    @VisibleForTesting
    public void initializeAllComponentsForTests() {
        for (Provider<?> provider : this.f29193a.values()) {
            provider.get();
        }
    }

    public void initializeEagerComponents(boolean z3) {
        HashMap hashMap;
        if (!androidx.compose.animation.core.d.a(this.f29198f, null, Boolean.valueOf(z3))) {
            return;
        }
        synchronized (this) {
            hashMap = new HashMap(this.f29193a);
        }
        f(hashMap, z3);
    }

    @Override // com.google.firebase.components.ComponentContainer
    public /* synthetic */ Set setOf(Qualified qualified) {
        return f.e(this, qualified);
    }

    @Override // com.google.firebase.components.ComponentContainer
    public /* synthetic */ Provider setOfProvider(Class cls) {
        return f.g(this, cls);
    }

    @Deprecated
    public ComponentRuntime(Executor executor, Iterable<ComponentRegistrar> iterable, Component<?>... componentArr) {
        this(executor, p(iterable), Arrays.asList(componentArr), ComponentRegistrarProcessor.NOOP);
    }

    @Override // com.google.firebase.components.ComponentContainer
    public /* synthetic */ Object get(Class cls) {
        return f.b(this, cls);
    }

    @Override // com.google.firebase.components.ComponentContainer
    public <T> Deferred<T> getDeferred(Qualified<T> qualified) {
        Provider<T> provider = getProvider(qualified);
        if (provider == null) {
            return OptionalProvider.d();
        }
        if (provider instanceof OptionalProvider) {
            return (OptionalProvider) provider;
        }
        return OptionalProvider.h(provider);
    }

    @Override // com.google.firebase.components.ComponentContainer
    public synchronized <T> Provider<T> getProvider(Qualified<T> qualified) {
        Preconditions.checkNotNull(qualified, "Null interface requested.");
        return (Provider<T>) this.f29194b.get(qualified);
    }

    @Override // com.google.firebase.components.ComponentContainer
    public /* synthetic */ Set setOf(Class cls) {
        return f.f(this, cls);
    }

    @Override // com.google.firebase.components.ComponentContainer
    public synchronized <T> Provider<Set<T>> setOfProvider(Qualified<T> qualified) {
        LazySet<?> lazySet = this.f29195c.get(qualified);
        if (lazySet != null) {
            return lazySet;
        }
        return (Provider<Set<T>>) f29192h;
    }

    private ComponentRuntime(Executor executor, Iterable<Provider<ComponentRegistrar>> iterable, Collection<Component<?>> collection, ComponentRegistrarProcessor componentRegistrarProcessor) {
        this.f29193a = new HashMap();
        this.f29194b = new HashMap();
        this.f29195c = new HashMap();
        this.f29198f = new AtomicReference<>();
        EventBus eventBus = new EventBus(executor);
        this.f29197e = eventBus;
        this.f29199g = componentRegistrarProcessor;
        ArrayList arrayList = new ArrayList();
        arrayList.add(Component.of(eventBus, EventBus.class, Subscriber.class, Publisher.class));
        arrayList.add(Component.of(this, ComponentLoader.class, new Class[0]));
        for (Component<?> component : collection) {
            if (component != null) {
                arrayList.add(component);
            }
        }
        this.f29196d = g(iterable);
        e(arrayList);
    }

    /* loaded from: classes5.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final Executor f29200a;

        /* renamed from: b  reason: collision with root package name */
        private final List<Provider<ComponentRegistrar>> f29201b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        private final List<Component<?>> f29202c = new ArrayList();

        /* renamed from: d  reason: collision with root package name */
        private ComponentRegistrarProcessor f29203d = ComponentRegistrarProcessor.NOOP;

        Builder(Executor executor) {
            this.f29200a = executor;
        }

        @CanIgnoreReturnValue
        public Builder addComponent(Component<?> component) {
            this.f29202c.add(component);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder addComponentRegistrar(final ComponentRegistrar componentRegistrar) {
            this.f29201b.add(new Provider() { // from class: com.google.firebase.components.n
                @Override // com.google.firebase.inject.Provider
                public final Object get() {
                    ComponentRegistrar b4;
                    b4 = ComponentRuntime.Builder.b(ComponentRegistrar.this);
                    return b4;
                }
            });
            return this;
        }

        @CanIgnoreReturnValue
        public Builder addLazyComponentRegistrars(Collection<Provider<ComponentRegistrar>> collection) {
            this.f29201b.addAll(collection);
            return this;
        }

        public ComponentRuntime build() {
            return new ComponentRuntime(this.f29200a, this.f29201b, this.f29202c, this.f29203d);
        }

        @CanIgnoreReturnValue
        public Builder setProcessor(ComponentRegistrarProcessor componentRegistrarProcessor) {
            this.f29203d = componentRegistrarProcessor;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ ComponentRegistrar b(ComponentRegistrar componentRegistrar) {
            return componentRegistrar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ComponentRegistrar k(ComponentRegistrar componentRegistrar) {
        return componentRegistrar;
    }
}
