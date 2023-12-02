package com.google.android.datatransport;

import androidx.annotation.Nullable;

/* loaded from: classes.dex */
final class AutoValue_Event<T> extends Event<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Integer f18478a;

    /* renamed from: b  reason: collision with root package name */
    private final T f18479b;

    /* renamed from: c  reason: collision with root package name */
    private final Priority f18480c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_Event(@Nullable Integer num, T t3, Priority priority) {
        this.f18478a = num;
        if (t3 != null) {
            this.f18479b = t3;
            if (priority != null) {
                this.f18480c = priority;
                return;
            }
            throw new NullPointerException("Null priority");
        }
        throw new NullPointerException("Null payload");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Event)) {
            return false;
        }
        Event event = (Event) obj;
        Integer num = this.f18478a;
        if (num != null ? num.equals(event.getCode()) : event.getCode() == null) {
            if (this.f18479b.equals(event.getPayload()) && this.f18480c.equals(event.getPriority())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.datatransport.Event
    @Nullable
    public Integer getCode() {
        return this.f18478a;
    }

    @Override // com.google.android.datatransport.Event
    public T getPayload() {
        return this.f18479b;
    }

    @Override // com.google.android.datatransport.Event
    public Priority getPriority() {
        return this.f18480c;
    }

    public int hashCode() {
        int hashCode;
        Integer num = this.f18478a;
        if (num == null) {
            hashCode = 0;
        } else {
            hashCode = num.hashCode();
        }
        return ((((hashCode ^ 1000003) * 1000003) ^ this.f18479b.hashCode()) * 1000003) ^ this.f18480c.hashCode();
    }

    public String toString() {
        return "Event{code=" + this.f18478a + ", payload=" + this.f18479b + ", priority=" + this.f18480c + "}";
    }
}
