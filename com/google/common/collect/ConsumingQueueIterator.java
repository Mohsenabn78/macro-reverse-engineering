package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Queue;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
final class ConsumingQueueIterator<T> extends AbstractIterator<T> {

    /* renamed from: c  reason: collision with root package name */
    private final Queue<T> f26780c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConsumingQueueIterator(Queue<T> queue) {
        this.f26780c = (Queue) Preconditions.checkNotNull(queue);
    }

    @Override // com.google.common.collect.AbstractIterator
    @CheckForNull
    protected T a() {
        if (this.f26780c.isEmpty()) {
            return b();
        }
        return this.f26780c.remove();
    }
}
