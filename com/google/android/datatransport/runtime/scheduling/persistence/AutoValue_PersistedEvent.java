package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class AutoValue_PersistedEvent extends PersistedEvent {

    /* renamed from: a  reason: collision with root package name */
    private final long f18875a;

    /* renamed from: b  reason: collision with root package name */
    private final TransportContext f18876b;

    /* renamed from: c  reason: collision with root package name */
    private final EventInternal f18877c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_PersistedEvent(long j4, TransportContext transportContext, EventInternal eventInternal) {
        this.f18875a = j4;
        if (transportContext != null) {
            this.f18876b = transportContext;
            if (eventInternal != null) {
                this.f18877c = eventInternal;
                return;
            }
            throw new NullPointerException("Null event");
        }
        throw new NullPointerException("Null transportContext");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PersistedEvent)) {
            return false;
        }
        PersistedEvent persistedEvent = (PersistedEvent) obj;
        if (this.f18875a == persistedEvent.getId() && this.f18876b.equals(persistedEvent.getTransportContext()) && this.f18877c.equals(persistedEvent.getEvent())) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.PersistedEvent
    public EventInternal getEvent() {
        return this.f18877c;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.PersistedEvent
    public long getId() {
        return this.f18875a;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.PersistedEvent
    public TransportContext getTransportContext() {
        return this.f18876b;
    }

    public int hashCode() {
        long j4 = this.f18875a;
        return this.f18877c.hashCode() ^ ((((((int) (j4 ^ (j4 >>> 32))) ^ 1000003) * 1000003) ^ this.f18876b.hashCode()) * 1000003);
    }

    public String toString() {
        return "PersistedEvent{id=" + this.f18875a + ", transportContext=" + this.f18876b + ", event=" + this.f18877c + "}";
    }
}
