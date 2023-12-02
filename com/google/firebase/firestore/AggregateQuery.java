package com.google.firebase.firestore;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.firestore.util.Executors;
import com.google.firebase.firestore.util.Preconditions;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes5.dex */
public class AggregateQuery {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final Query f30126a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final List<AggregateField> f30127b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AggregateQuery(@NonNull Query query, @NonNull List<AggregateField> list) {
        this.f30126a = query;
        this.f30127b = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object b(TaskCompletionSource taskCompletionSource, Task task) throws Exception {
        if (task.isSuccessful()) {
            taskCompletionSource.setResult(new AggregateQuerySnapshot(this, (Map) task.getResult()));
            return null;
        }
        taskCompletionSource.setException(task.getException());
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AggregateQuery)) {
            return false;
        }
        AggregateQuery aggregateQuery = (AggregateQuery) obj;
        if (this.f30126a.equals(aggregateQuery.f30126a) && this.f30127b.equals(aggregateQuery.f30127b)) {
            return true;
        }
        return false;
    }

    @NonNull
    public Task<AggregateQuerySnapshot> get(@NonNull AggregateSource aggregateSource) {
        Preconditions.checkNotNull(aggregateSource, "AggregateSource must not be null");
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f30126a.f30218b.i().runAggregateQuery(this.f30126a.f30217a, this.f30127b).continueWith(Executors.DIRECT_EXECUTOR, new Continuation() { // from class: com.google.firebase.firestore.a
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                Object b4;
                b4 = AggregateQuery.this.b(taskCompletionSource, task);
                return b4;
            }
        });
        return taskCompletionSource.getTask();
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public List<AggregateField> getAggregateFields() {
        return this.f30127b;
    }

    @NonNull
    public Query getQuery() {
        return this.f30126a;
    }

    public int hashCode() {
        return Objects.hash(this.f30126a, this.f30127b);
    }
}
