package com.google.firebase.firestore.remote;

import io.grpc.Metadata;
import io.grpc.Status;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public interface IncomingStreamObserver<RespT> {
    void a(Metadata metadata);

    void onClose(Status status);

    void onNext(RespT respt);

    void onOpen();
}
