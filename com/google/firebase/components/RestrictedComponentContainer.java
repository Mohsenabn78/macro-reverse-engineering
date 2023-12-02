package com.google.firebase.components;

import com.google.firebase.events.Event;
import com.google.firebase.events.Publisher;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class RestrictedComponentContainer implements ComponentContainer {

    /* renamed from: a  reason: collision with root package name */
    private final Set<Qualified<?>> f29226a;

    /* renamed from: b  reason: collision with root package name */
    private final Set<Qualified<?>> f29227b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<Qualified<?>> f29228c;

    /* renamed from: d  reason: collision with root package name */
    private final Set<Qualified<?>> f29229d;

    /* renamed from: e  reason: collision with root package name */
    private final Set<Qualified<?>> f29230e;

    /* renamed from: f  reason: collision with root package name */
    private final Set<Class<?>> f29231f;

    /* renamed from: g  reason: collision with root package name */
    private final ComponentContainer f29232g;

    /* loaded from: classes5.dex */
    private static class RestrictedPublisher implements Publisher {

        /* renamed from: a  reason: collision with root package name */
        private final Set<Class<?>> f29233a;

        /* renamed from: b  reason: collision with root package name */
        private final Publisher f29234b;

        public RestrictedPublisher(Set<Class<?>> set, Publisher publisher) {
            this.f29233a = set;
            this.f29234b = publisher;
        }

        @Override // com.google.firebase.events.Publisher
        public void publish(Event<?> event) {
            if (this.f29233a.contains(event.getType())) {
                this.f29234b.publish(event);
                return;
            }
            throw new DependencyException(String.format("Attempting to publish an undeclared event %s.", event));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RestrictedComponentContainer(Component<?> component, ComponentContainer componentContainer) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        HashSet hashSet5 = new HashSet();
        for (Dependency dependency : component.getDependencies()) {
            if (dependency.isDirectInjection()) {
                if (dependency.isSet()) {
                    hashSet4.add(dependency.getInterface());
                } else {
                    hashSet.add(dependency.getInterface());
                }
            } else if (dependency.isDeferred()) {
                hashSet3.add(dependency.getInterface());
            } else if (dependency.isSet()) {
                hashSet5.add(dependency.getInterface());
            } else {
                hashSet2.add(dependency.getInterface());
            }
        }
        if (!component.getPublishedEvents().isEmpty()) {
            hashSet.add(Qualified.unqualified(Publisher.class));
        }
        this.f29226a = Collections.unmodifiableSet(hashSet);
        this.f29227b = Collections.unmodifiableSet(hashSet2);
        this.f29228c = Collections.unmodifiableSet(hashSet3);
        this.f29229d = Collections.unmodifiableSet(hashSet4);
        this.f29230e = Collections.unmodifiableSet(hashSet5);
        this.f29231f = component.getPublishedEvents();
        this.f29232g = componentContainer;
    }

    @Override // com.google.firebase.components.ComponentContainer
    public <T> T get(Class<T> cls) {
        if (this.f29226a.contains(Qualified.unqualified(cls))) {
            T t3 = (T) this.f29232g.get(cls);
            return !cls.equals(Publisher.class) ? t3 : (T) new RestrictedPublisher(this.f29231f, (Publisher) t3);
        }
        throw new DependencyException(String.format("Attempting to request an undeclared dependency %s.", cls));
    }

    @Override // com.google.firebase.components.ComponentContainer
    public <T> Deferred<T> getDeferred(Class<T> cls) {
        return getDeferred(Qualified.unqualified(cls));
    }

    @Override // com.google.firebase.components.ComponentContainer
    public <T> Provider<T> getProvider(Class<T> cls) {
        return getProvider(Qualified.unqualified(cls));
    }

    @Override // com.google.firebase.components.ComponentContainer
    public /* synthetic */ Set setOf(Class cls) {
        return f.f(this, cls);
    }

    @Override // com.google.firebase.components.ComponentContainer
    public <T> Provider<Set<T>> setOfProvider(Class<T> cls) {
        return setOfProvider(Qualified.unqualified(cls));
    }

    @Override // com.google.firebase.components.ComponentContainer
    public <T> Deferred<T> getDeferred(Qualified<T> qualified) {
        if (this.f29228c.contains(qualified)) {
            return this.f29232g.getDeferred(qualified);
        }
        throw new DependencyException(String.format("Attempting to request an undeclared dependency Deferred<%s>.", qualified));
    }

    @Override // com.google.firebase.components.ComponentContainer
    public <T> Provider<T> getProvider(Qualified<T> qualified) {
        if (this.f29227b.contains(qualified)) {
            return this.f29232g.getProvider(qualified);
        }
        throw new DependencyException(String.format("Attempting to request an undeclared dependency Provider<%s>.", qualified));
    }

    @Override // com.google.firebase.components.ComponentContainer
    public <T> Set<T> setOf(Qualified<T> qualified) {
        if (this.f29229d.contains(qualified)) {
            return this.f29232g.setOf(qualified);
        }
        throw new DependencyException(String.format("Attempting to request an undeclared dependency Set<%s>.", qualified));
    }

    @Override // com.google.firebase.components.ComponentContainer
    public <T> Provider<Set<T>> setOfProvider(Qualified<T> qualified) {
        if (this.f29230e.contains(qualified)) {
            return this.f29232g.setOfProvider(qualified);
        }
        throw new DependencyException(String.format("Attempting to request an undeclared dependency Provider<Set<%s>>.", qualified));
    }

    @Override // com.google.firebase.components.ComponentContainer
    public <T> T get(Qualified<T> qualified) {
        if (this.f29226a.contains(qualified)) {
            return (T) this.f29232g.get(qualified);
        }
        throw new DependencyException(String.format("Attempting to request an undeclared dependency %s.", qualified));
    }
}
