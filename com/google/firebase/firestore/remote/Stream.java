package com.google.firebase.firestore.remote;

import com.google.firebase.firestore.remote.Stream.StreamCallback;
import io.grpc.Status;

/* loaded from: classes5.dex */
public interface Stream<CallbackType extends StreamCallback> {

    /* loaded from: classes5.dex */
    public enum State {
        Initial,
        Starting,
        Open,
        Healthy,
        Error,
        Backoff
    }

    /* loaded from: classes5.dex */
    public interface StreamCallback {
        void onClose(Status status);

        void onOpen();
    }

    void inhibitBackoff();

    boolean isOpen();

    boolean isStarted();

    void start();

    void stop();
}
