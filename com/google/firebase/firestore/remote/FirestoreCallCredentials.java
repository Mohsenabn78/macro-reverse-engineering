package com.google.firebase.firestore.remote;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApiNotAvailableException;
import com.google.firebase.firestore.auth.CredentialsProvider;
import com.google.firebase.firestore.auth.User;
import com.google.firebase.firestore.util.Executors;
import com.google.firebase.firestore.util.Logger;
import com.google.firebase.internal.api.FirebaseNoSignedInUserException;
import io.grpc.CallCredentials;
import io.grpc.Metadata;
import io.grpc.Status;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class FirestoreCallCredentials extends CallCredentials {

    /* renamed from: c  reason: collision with root package name */
    private static final Metadata.Key<String> f31089c;

    /* renamed from: d  reason: collision with root package name */
    private static final Metadata.Key<String> f31090d;

    /* renamed from: a  reason: collision with root package name */
    private final CredentialsProvider<User> f31091a;

    /* renamed from: b  reason: collision with root package name */
    private final CredentialsProvider<String> f31092b;

    static {
        Metadata.AsciiMarshaller<String> asciiMarshaller = Metadata.ASCII_STRING_MARSHALLER;
        f31089c = Metadata.Key.of("Authorization", asciiMarshaller);
        f31090d = Metadata.Key.of("x-firebase-appcheck", asciiMarshaller);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FirestoreCallCredentials(CredentialsProvider<User> credentialsProvider, CredentialsProvider<String> credentialsProvider2) {
        this.f31091a = credentialsProvider;
        this.f31092b = credentialsProvider2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(Task task, CallCredentials.MetadataApplier metadataApplier, Task task2, Task task3) {
        Metadata metadata = new Metadata();
        if (task.isSuccessful()) {
            String str = (String) task.getResult();
            Logger.debug("FirestoreCallCredentials", "Successfully fetched auth token.", new Object[0]);
            if (str != null) {
                Metadata.Key<String> key = f31089c;
                metadata.put(key, "Bearer " + str);
            }
        } else {
            Exception exception = task.getException();
            if (exception instanceof FirebaseApiNotAvailableException) {
                Logger.debug("FirestoreCallCredentials", "Firebase Auth API not available, not using authentication.", new Object[0]);
            } else if (exception instanceof FirebaseNoSignedInUserException) {
                Logger.debug("FirestoreCallCredentials", "No user signed in, not using authentication.", new Object[0]);
            } else {
                Logger.warn("FirestoreCallCredentials", "Failed to get auth token: %s.", exception);
                metadataApplier.fail(Status.UNAUTHENTICATED.withCause(exception));
                return;
            }
        }
        if (task2.isSuccessful()) {
            String str2 = (String) task2.getResult();
            if (str2 != null && !str2.isEmpty()) {
                Logger.debug("FirestoreCallCredentials", "Successfully fetched AppCheck token.", new Object[0]);
                metadata.put(f31090d, str2);
            }
        } else {
            Exception exception2 = task2.getException();
            if (exception2 instanceof FirebaseApiNotAvailableException) {
                Logger.debug("FirestoreCallCredentials", "Firebase AppCheck API not available.", new Object[0]);
            } else {
                Logger.warn("FirestoreCallCredentials", "Failed to get AppCheck token: %s.", exception2);
                metadataApplier.fail(Status.UNAUTHENTICATED.withCause(exception2));
                return;
            }
        }
        metadataApplier.apply(metadata);
    }

    @Override // io.grpc.CallCredentials
    public void applyRequestMetadata(CallCredentials.RequestInfo requestInfo, Executor executor, final CallCredentials.MetadataApplier metadataApplier) {
        final Task<String> token = this.f31091a.getToken();
        final Task<String> token2 = this.f31092b.getToken();
        Tasks.whenAll(token, token2).addOnCompleteListener(Executors.DIRECT_EXECUTOR, new OnCompleteListener() { // from class: com.google.firebase.firestore.remote.k
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                FirestoreCallCredentials.b(Task.this, metadataApplier, token2, task);
            }
        });
    }

    @Override // io.grpc.CallCredentials
    public void thisUsesUnstableApi() {
    }
}
