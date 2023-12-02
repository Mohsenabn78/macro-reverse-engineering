package com.google.common.eventbus;

import androidx.core.app.NotificationCompat;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;

@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public class DeadEvent {

    /* renamed from: a  reason: collision with root package name */
    private final Object f27634a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f27635b;

    public DeadEvent(Object obj, Object obj2) {
        this.f27634a = Preconditions.checkNotNull(obj);
        this.f27635b = Preconditions.checkNotNull(obj2);
    }

    public Object getEvent() {
        return this.f27635b;
    }

    public Object getSource() {
        return this.f27634a;
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("source", this.f27634a).add(NotificationCompat.CATEGORY_EVENT, this.f27635b).toString();
    }
}
