package com.google.firebase.events;

import com.google.firebase.components.Preconditions;

/* loaded from: classes5.dex */
public class Event<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Class<T> f30121a;

    /* renamed from: b  reason: collision with root package name */
    private final T f30122b;

    public Event(Class<T> cls, T t3) {
        this.f30121a = (Class) Preconditions.checkNotNull(cls);
        this.f30122b = (T) Preconditions.checkNotNull(t3);
    }

    public T getPayload() {
        return this.f30122b;
    }

    public Class<T> getType() {
        return this.f30121a;
    }

    public String toString() {
        return String.format("Event{type: %s, payload: %s}", this.f30121a, this.f30122b);
    }
}
