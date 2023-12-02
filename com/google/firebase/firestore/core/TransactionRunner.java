package com.google.firebase.firestore.core;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.TransactionOptions;
import com.google.firebase.firestore.remote.Datastore;
import com.google.firebase.firestore.remote.RemoteStore;
import com.google.firebase.firestore.util.AsyncQueue;
import com.google.firebase.firestore.util.ExponentialBackoff;
import com.google.firebase.firestore.util.Function;

/* loaded from: classes5.dex */
public class TransactionRunner<TResult> {

    /* renamed from: a  reason: collision with root package name */
    private AsyncQueue f30435a;

    /* renamed from: b  reason: collision with root package name */
    private RemoteStore f30436b;

    /* renamed from: c  reason: collision with root package name */
    private Function<Transaction, Task<TResult>> f30437c;

    /* renamed from: d  reason: collision with root package name */
    private int f30438d;

    /* renamed from: e  reason: collision with root package name */
    private ExponentialBackoff f30439e;

    /* renamed from: f  reason: collision with root package name */
    private TaskCompletionSource<TResult> f30440f = new TaskCompletionSource<>();

    public TransactionRunner(AsyncQueue asyncQueue, RemoteStore remoteStore, TransactionOptions transactionOptions, Function<Transaction, Task<TResult>> function) {
        this.f30435a = asyncQueue;
        this.f30436b = remoteStore;
        this.f30437c = function;
        this.f30438d = transactionOptions.getMaxAttempts();
        this.f30439e = new ExponentialBackoff(asyncQueue, AsyncQueue.TimerId.RETRY_TRANSACTION);
    }

    private void d(Task task) {
        if (this.f30438d > 0 && e(task.getException())) {
            i();
        } else {
            this.f30440f.setException(task.getException());
        }
    }

    private static boolean e(Exception exc) {
        if (!(exc instanceof FirebaseFirestoreException)) {
            return false;
        }
        FirebaseFirestoreException firebaseFirestoreException = (FirebaseFirestoreException) exc;
        FirebaseFirestoreException.Code code = firebaseFirestoreException.getCode();
        if (code != FirebaseFirestoreException.Code.ABORTED && code != FirebaseFirestoreException.Code.ALREADY_EXISTS && code != FirebaseFirestoreException.Code.FAILED_PRECONDITION && Datastore.isPermanentError(firebaseFirestoreException.getCode())) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void f(Task task, Task task2) {
        if (task2.isSuccessful()) {
            this.f30440f.setResult(task.getResult());
        } else {
            d(task2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(Transaction transaction, final Task task) {
        if (!task.isSuccessful()) {
            d(task);
        } else {
            transaction.commit().addOnCompleteListener(this.f30435a.getExecutor(), new OnCompleteListener() { // from class: com.google.firebase.firestore.core.i0
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task2) {
                    TransactionRunner.this.f(task, task2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h() {
        final Transaction createTransaction = this.f30436b.createTransaction();
        this.f30437c.apply(createTransaction).addOnCompleteListener(this.f30435a.getExecutor(), new OnCompleteListener() { // from class: com.google.firebase.firestore.core.h0
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                TransactionRunner.this.g(createTransaction, task);
            }
        });
    }

    private void i() {
        this.f30438d--;
        this.f30439e.backoffAndRun(new Runnable() { // from class: com.google.firebase.firestore.core.g0
            @Override // java.lang.Runnable
            public final void run() {
                TransactionRunner.this.h();
            }
        });
    }

    public Task<TResult> run() {
        i();
        return this.f30440f.getTask();
    }
}
