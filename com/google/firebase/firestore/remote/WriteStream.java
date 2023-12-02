package com.google.firebase.firestore.remote;

import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.model.mutation.Mutation;
import com.google.firebase.firestore.model.mutation.MutationResult;
import com.google.firebase.firestore.remote.Stream;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.AsyncQueue;
import com.google.firebase.firestore.util.Preconditions;
import com.google.firestore.v1.FirestoreGrpc;
import com.google.firestore.v1.WriteRequest;
import com.google.firestore.v1.WriteResponse;
import com.google.protobuf.ByteString;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes5.dex */
public class WriteStream extends AbstractStream<WriteRequest, WriteResponse, Callback> {
    public static final ByteString EMPTY_STREAM_TOKEN = ByteString.EMPTY;

    /* renamed from: s  reason: collision with root package name */
    private final RemoteSerializer f31197s;

    /* renamed from: t  reason: collision with root package name */
    protected boolean f31198t;

    /* renamed from: u  reason: collision with root package name */
    private ByteString f31199u;

    /* loaded from: classes5.dex */
    public interface Callback extends Stream.StreamCallback {
        void onHandshakeComplete();

        void onWriteResponse(SnapshotVersion snapshotVersion, List<MutationResult> list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WriteStream(FirestoreChannel firestoreChannel, AsyncQueue asyncQueue, RemoteSerializer remoteSerializer, Callback callback) {
        super(firestoreChannel, FirestoreGrpc.getWriteMethod(), asyncQueue, AsyncQueue.TimerId.WRITE_STREAM_CONNECTION_BACKOFF, AsyncQueue.TimerId.WRITE_STREAM_IDLE, AsyncQueue.TimerId.HEALTH_CHECK_TIMEOUT, callback);
        this.f31198t = false;
        this.f31199u = EMPTY_STREAM_TOKEN;
        this.f31197s = remoteSerializer;
    }

    @Override // com.google.firebase.firestore.remote.AbstractStream, com.google.firebase.firestore.remote.Stream
    public /* bridge */ /* synthetic */ void inhibitBackoff() {
        super.inhibitBackoff();
    }

    @Override // com.google.firebase.firestore.remote.AbstractStream, com.google.firebase.firestore.remote.Stream
    public /* bridge */ /* synthetic */ boolean isOpen() {
        return super.isOpen();
    }

    @Override // com.google.firebase.firestore.remote.AbstractStream, com.google.firebase.firestore.remote.Stream
    public /* bridge */ /* synthetic */ boolean isStarted() {
        return super.isStarted();
    }

    @Override // com.google.firebase.firestore.remote.AbstractStream
    protected void q() {
        if (this.f31198t) {
            w(Collections.emptyList());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ByteString s() {
        return this.f31199u;
    }

    @Override // com.google.firebase.firestore.remote.AbstractStream, com.google.firebase.firestore.remote.Stream
    public void start() {
        this.f31198t = false;
        super.start();
    }

    @Override // com.google.firebase.firestore.remote.AbstractStream, com.google.firebase.firestore.remote.Stream
    public /* bridge */ /* synthetic */ void stop() {
        super.stop();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean t() {
        return this.f31198t;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(ByteString byteString) {
        this.f31199u = (ByteString) Preconditions.checkNotNull(byteString);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v() {
        Assert.hardAssert(isOpen(), "Writing handshake requires an opened stream", new Object[0]);
        Assert.hardAssert(!this.f31198t, "Handshake already completed", new Object[0]);
        r(WriteRequest.newBuilder().setDatabase(this.f31197s.databaseName()).build());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(List<Mutation> list) {
        Assert.hardAssert(isOpen(), "Writing mutations requires an opened stream", new Object[0]);
        Assert.hardAssert(this.f31198t, "Handshake must be complete before writing mutations", new Object[0]);
        WriteRequest.Builder newBuilder = WriteRequest.newBuilder();
        for (Mutation mutation : list) {
            newBuilder.addWrites(this.f31197s.encodeMutation(mutation));
        }
        newBuilder.setStreamToken(this.f31199u);
        r(newBuilder.build());
    }

    @Override // com.google.firebase.firestore.remote.AbstractStream
    public void onNext(WriteResponse writeResponse) {
        this.f31199u = writeResponse.getStreamToken();
        if (!this.f31198t) {
            this.f31198t = true;
            ((Callback) this.f31039m).onHandshakeComplete();
            return;
        }
        this.f31038l.reset();
        SnapshotVersion decodeVersion = this.f31197s.decodeVersion(writeResponse.getCommitTime());
        int writeResultsCount = writeResponse.getWriteResultsCount();
        ArrayList arrayList = new ArrayList(writeResultsCount);
        for (int i4 = 0; i4 < writeResultsCount; i4++) {
            arrayList.add(this.f31197s.decodeMutationResult(writeResponse.getWriteResults(i4), decodeVersion));
        }
        ((Callback) this.f31039m).onWriteResponse(decodeVersion, arrayList);
    }
}
