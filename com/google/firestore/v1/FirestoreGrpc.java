package com.google.firestore.v1;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.protobuf.Empty;
import io.grpc.BindableService;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.MethodDescriptor;
import io.grpc.ServerServiceDefinition;
import io.grpc.ServiceDescriptor;
import io.grpc.protobuf.lite.ProtoLiteUtils;
import io.grpc.stub.AbstractAsyncStub;
import io.grpc.stub.AbstractBlockingStub;
import io.grpc.stub.AbstractFutureStub;
import io.grpc.stub.AbstractStub;
import io.grpc.stub.ClientCalls;
import io.grpc.stub.ServerCalls;
import io.grpc.stub.StreamObserver;
import io.grpc.stub.annotations.GrpcGenerated;
import io.grpc.stub.annotations.RpcMethod;
import java.util.Iterator;

@GrpcGenerated
/* loaded from: classes5.dex */
public final class FirestoreGrpc {
    public static final String SERVICE_NAME = "google.firestore.v1.Firestore";

    /* renamed from: a  reason: collision with root package name */
    private static volatile MethodDescriptor<GetDocumentRequest, Document> f32461a;

    /* renamed from: b  reason: collision with root package name */
    private static volatile MethodDescriptor<ListDocumentsRequest, ListDocumentsResponse> f32462b;

    /* renamed from: c  reason: collision with root package name */
    private static volatile MethodDescriptor<CreateDocumentRequest, Document> f32463c;

    /* renamed from: d  reason: collision with root package name */
    private static volatile MethodDescriptor<UpdateDocumentRequest, Document> f32464d;

    /* renamed from: e  reason: collision with root package name */
    private static volatile MethodDescriptor<DeleteDocumentRequest, Empty> f32465e;

    /* renamed from: f  reason: collision with root package name */
    private static volatile MethodDescriptor<BatchGetDocumentsRequest, BatchGetDocumentsResponse> f32466f;

    /* renamed from: g  reason: collision with root package name */
    private static volatile MethodDescriptor<BeginTransactionRequest, BeginTransactionResponse> f32467g;

    /* renamed from: h  reason: collision with root package name */
    private static volatile MethodDescriptor<CommitRequest, CommitResponse> f32468h;

    /* renamed from: i  reason: collision with root package name */
    private static volatile MethodDescriptor<RollbackRequest, Empty> f32469i;

    /* renamed from: j  reason: collision with root package name */
    private static volatile MethodDescriptor<RunQueryRequest, RunQueryResponse> f32470j;

    /* renamed from: k  reason: collision with root package name */
    private static volatile MethodDescriptor<RunAggregationQueryRequest, RunAggregationQueryResponse> f32471k;

    /* renamed from: l  reason: collision with root package name */
    private static volatile MethodDescriptor<WriteRequest, WriteResponse> f32472l;

    /* renamed from: m  reason: collision with root package name */
    private static volatile MethodDescriptor<ListenRequest, ListenResponse> f32473m;

    /* renamed from: n  reason: collision with root package name */
    private static volatile MethodDescriptor<ListCollectionIdsRequest, ListCollectionIdsResponse> f32474n;

    /* renamed from: o  reason: collision with root package name */
    private static volatile ServiceDescriptor f32475o;

    /* loaded from: classes5.dex */
    public static final class FirestoreBlockingStub extends AbstractBlockingStub<FirestoreBlockingStub> {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.grpc.stub.AbstractStub
        /* renamed from: b */
        public FirestoreBlockingStub a(Channel channel, CallOptions callOptions) {
            return new FirestoreBlockingStub(channel, callOptions);
        }

        public Iterator<BatchGetDocumentsResponse> batchGetDocuments(BatchGetDocumentsRequest batchGetDocumentsRequest) {
            return ClientCalls.blockingServerStreamingCall(getChannel(), FirestoreGrpc.getBatchGetDocumentsMethod(), getCallOptions(), batchGetDocumentsRequest);
        }

        public BeginTransactionResponse beginTransaction(BeginTransactionRequest beginTransactionRequest) {
            return (BeginTransactionResponse) ClientCalls.blockingUnaryCall(getChannel(), FirestoreGrpc.getBeginTransactionMethod(), getCallOptions(), beginTransactionRequest);
        }

        public CommitResponse commit(CommitRequest commitRequest) {
            return (CommitResponse) ClientCalls.blockingUnaryCall(getChannel(), FirestoreGrpc.getCommitMethod(), getCallOptions(), commitRequest);
        }

        public Document createDocument(CreateDocumentRequest createDocumentRequest) {
            return (Document) ClientCalls.blockingUnaryCall(getChannel(), FirestoreGrpc.getCreateDocumentMethod(), getCallOptions(), createDocumentRequest);
        }

        public Empty deleteDocument(DeleteDocumentRequest deleteDocumentRequest) {
            return (Empty) ClientCalls.blockingUnaryCall(getChannel(), FirestoreGrpc.getDeleteDocumentMethod(), getCallOptions(), deleteDocumentRequest);
        }

        public Document getDocument(GetDocumentRequest getDocumentRequest) {
            return (Document) ClientCalls.blockingUnaryCall(getChannel(), FirestoreGrpc.getGetDocumentMethod(), getCallOptions(), getDocumentRequest);
        }

        public ListCollectionIdsResponse listCollectionIds(ListCollectionIdsRequest listCollectionIdsRequest) {
            return (ListCollectionIdsResponse) ClientCalls.blockingUnaryCall(getChannel(), FirestoreGrpc.getListCollectionIdsMethod(), getCallOptions(), listCollectionIdsRequest);
        }

        public ListDocumentsResponse listDocuments(ListDocumentsRequest listDocumentsRequest) {
            return (ListDocumentsResponse) ClientCalls.blockingUnaryCall(getChannel(), FirestoreGrpc.getListDocumentsMethod(), getCallOptions(), listDocumentsRequest);
        }

        public Empty rollback(RollbackRequest rollbackRequest) {
            return (Empty) ClientCalls.blockingUnaryCall(getChannel(), FirestoreGrpc.getRollbackMethod(), getCallOptions(), rollbackRequest);
        }

        public Iterator<RunAggregationQueryResponse> runAggregationQuery(RunAggregationQueryRequest runAggregationQueryRequest) {
            return ClientCalls.blockingServerStreamingCall(getChannel(), FirestoreGrpc.getRunAggregationQueryMethod(), getCallOptions(), runAggregationQueryRequest);
        }

        public Iterator<RunQueryResponse> runQuery(RunQueryRequest runQueryRequest) {
            return ClientCalls.blockingServerStreamingCall(getChannel(), FirestoreGrpc.getRunQueryMethod(), getCallOptions(), runQueryRequest);
        }

        public Document updateDocument(UpdateDocumentRequest updateDocumentRequest) {
            return (Document) ClientCalls.blockingUnaryCall(getChannel(), FirestoreGrpc.getUpdateDocumentMethod(), getCallOptions(), updateDocumentRequest);
        }

        private FirestoreBlockingStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }
    }

    /* loaded from: classes5.dex */
    public static final class FirestoreFutureStub extends AbstractFutureStub<FirestoreFutureStub> {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.grpc.stub.AbstractStub
        /* renamed from: b */
        public FirestoreFutureStub a(Channel channel, CallOptions callOptions) {
            return new FirestoreFutureStub(channel, callOptions);
        }

        public ListenableFuture<BeginTransactionResponse> beginTransaction(BeginTransactionRequest beginTransactionRequest) {
            return ClientCalls.futureUnaryCall(getChannel().newCall(FirestoreGrpc.getBeginTransactionMethod(), getCallOptions()), beginTransactionRequest);
        }

        public ListenableFuture<CommitResponse> commit(CommitRequest commitRequest) {
            return ClientCalls.futureUnaryCall(getChannel().newCall(FirestoreGrpc.getCommitMethod(), getCallOptions()), commitRequest);
        }

        public ListenableFuture<Document> createDocument(CreateDocumentRequest createDocumentRequest) {
            return ClientCalls.futureUnaryCall(getChannel().newCall(FirestoreGrpc.getCreateDocumentMethod(), getCallOptions()), createDocumentRequest);
        }

        public ListenableFuture<Empty> deleteDocument(DeleteDocumentRequest deleteDocumentRequest) {
            return ClientCalls.futureUnaryCall(getChannel().newCall(FirestoreGrpc.getDeleteDocumentMethod(), getCallOptions()), deleteDocumentRequest);
        }

        public ListenableFuture<Document> getDocument(GetDocumentRequest getDocumentRequest) {
            return ClientCalls.futureUnaryCall(getChannel().newCall(FirestoreGrpc.getGetDocumentMethod(), getCallOptions()), getDocumentRequest);
        }

        public ListenableFuture<ListCollectionIdsResponse> listCollectionIds(ListCollectionIdsRequest listCollectionIdsRequest) {
            return ClientCalls.futureUnaryCall(getChannel().newCall(FirestoreGrpc.getListCollectionIdsMethod(), getCallOptions()), listCollectionIdsRequest);
        }

        public ListenableFuture<ListDocumentsResponse> listDocuments(ListDocumentsRequest listDocumentsRequest) {
            return ClientCalls.futureUnaryCall(getChannel().newCall(FirestoreGrpc.getListDocumentsMethod(), getCallOptions()), listDocumentsRequest);
        }

        public ListenableFuture<Empty> rollback(RollbackRequest rollbackRequest) {
            return ClientCalls.futureUnaryCall(getChannel().newCall(FirestoreGrpc.getRollbackMethod(), getCallOptions()), rollbackRequest);
        }

        public ListenableFuture<Document> updateDocument(UpdateDocumentRequest updateDocumentRequest) {
            return ClientCalls.futureUnaryCall(getChannel().newCall(FirestoreGrpc.getUpdateDocumentMethod(), getCallOptions()), updateDocumentRequest);
        }

        private FirestoreFutureStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }
    }

    /* loaded from: classes5.dex */
    public static abstract class FirestoreImplBase implements BindableService {
        public void batchGetDocuments(BatchGetDocumentsRequest batchGetDocumentsRequest, StreamObserver<BatchGetDocumentsResponse> streamObserver) {
            ServerCalls.asyncUnimplementedUnaryCall(FirestoreGrpc.getBatchGetDocumentsMethod(), streamObserver);
        }

        public void beginTransaction(BeginTransactionRequest beginTransactionRequest, StreamObserver<BeginTransactionResponse> streamObserver) {
            ServerCalls.asyncUnimplementedUnaryCall(FirestoreGrpc.getBeginTransactionMethod(), streamObserver);
        }

        @Override // io.grpc.BindableService
        public final ServerServiceDefinition bindService() {
            return ServerServiceDefinition.builder(FirestoreGrpc.getServiceDescriptor()).addMethod(FirestoreGrpc.getGetDocumentMethod(), ServerCalls.asyncUnaryCall(new MethodHandlers(this, 0))).addMethod(FirestoreGrpc.getListDocumentsMethod(), ServerCalls.asyncUnaryCall(new MethodHandlers(this, 1))).addMethod(FirestoreGrpc.getCreateDocumentMethod(), ServerCalls.asyncUnaryCall(new MethodHandlers(this, 2))).addMethod(FirestoreGrpc.getUpdateDocumentMethod(), ServerCalls.asyncUnaryCall(new MethodHandlers(this, 3))).addMethod(FirestoreGrpc.getDeleteDocumentMethod(), ServerCalls.asyncUnaryCall(new MethodHandlers(this, 4))).addMethod(FirestoreGrpc.getBatchGetDocumentsMethod(), ServerCalls.asyncServerStreamingCall(new MethodHandlers(this, 5))).addMethod(FirestoreGrpc.getBeginTransactionMethod(), ServerCalls.asyncUnaryCall(new MethodHandlers(this, 6))).addMethod(FirestoreGrpc.getCommitMethod(), ServerCalls.asyncUnaryCall(new MethodHandlers(this, 7))).addMethod(FirestoreGrpc.getRollbackMethod(), ServerCalls.asyncUnaryCall(new MethodHandlers(this, 8))).addMethod(FirestoreGrpc.getRunQueryMethod(), ServerCalls.asyncServerStreamingCall(new MethodHandlers(this, 9))).addMethod(FirestoreGrpc.getRunAggregationQueryMethod(), ServerCalls.asyncServerStreamingCall(new MethodHandlers(this, 10))).addMethod(FirestoreGrpc.getWriteMethod(), ServerCalls.asyncBidiStreamingCall(new MethodHandlers(this, 12))).addMethod(FirestoreGrpc.getListenMethod(), ServerCalls.asyncBidiStreamingCall(new MethodHandlers(this, 13))).addMethod(FirestoreGrpc.getListCollectionIdsMethod(), ServerCalls.asyncUnaryCall(new MethodHandlers(this, 11))).build();
        }

        public void commit(CommitRequest commitRequest, StreamObserver<CommitResponse> streamObserver) {
            ServerCalls.asyncUnimplementedUnaryCall(FirestoreGrpc.getCommitMethod(), streamObserver);
        }

        public void createDocument(CreateDocumentRequest createDocumentRequest, StreamObserver<Document> streamObserver) {
            ServerCalls.asyncUnimplementedUnaryCall(FirestoreGrpc.getCreateDocumentMethod(), streamObserver);
        }

        public void deleteDocument(DeleteDocumentRequest deleteDocumentRequest, StreamObserver<Empty> streamObserver) {
            ServerCalls.asyncUnimplementedUnaryCall(FirestoreGrpc.getDeleteDocumentMethod(), streamObserver);
        }

        public void getDocument(GetDocumentRequest getDocumentRequest, StreamObserver<Document> streamObserver) {
            ServerCalls.asyncUnimplementedUnaryCall(FirestoreGrpc.getGetDocumentMethod(), streamObserver);
        }

        public void listCollectionIds(ListCollectionIdsRequest listCollectionIdsRequest, StreamObserver<ListCollectionIdsResponse> streamObserver) {
            ServerCalls.asyncUnimplementedUnaryCall(FirestoreGrpc.getListCollectionIdsMethod(), streamObserver);
        }

        public void listDocuments(ListDocumentsRequest listDocumentsRequest, StreamObserver<ListDocumentsResponse> streamObserver) {
            ServerCalls.asyncUnimplementedUnaryCall(FirestoreGrpc.getListDocumentsMethod(), streamObserver);
        }

        public StreamObserver<ListenRequest> listen(StreamObserver<ListenResponse> streamObserver) {
            return ServerCalls.asyncUnimplementedStreamingCall(FirestoreGrpc.getListenMethod(), streamObserver);
        }

        public void rollback(RollbackRequest rollbackRequest, StreamObserver<Empty> streamObserver) {
            ServerCalls.asyncUnimplementedUnaryCall(FirestoreGrpc.getRollbackMethod(), streamObserver);
        }

        public void runAggregationQuery(RunAggregationQueryRequest runAggregationQueryRequest, StreamObserver<RunAggregationQueryResponse> streamObserver) {
            ServerCalls.asyncUnimplementedUnaryCall(FirestoreGrpc.getRunAggregationQueryMethod(), streamObserver);
        }

        public void runQuery(RunQueryRequest runQueryRequest, StreamObserver<RunQueryResponse> streamObserver) {
            ServerCalls.asyncUnimplementedUnaryCall(FirestoreGrpc.getRunQueryMethod(), streamObserver);
        }

        public void updateDocument(UpdateDocumentRequest updateDocumentRequest, StreamObserver<Document> streamObserver) {
            ServerCalls.asyncUnimplementedUnaryCall(FirestoreGrpc.getUpdateDocumentMethod(), streamObserver);
        }

        public StreamObserver<WriteRequest> write(StreamObserver<WriteResponse> streamObserver) {
            return ServerCalls.asyncUnimplementedStreamingCall(FirestoreGrpc.getWriteMethod(), streamObserver);
        }
    }

    /* loaded from: classes5.dex */
    public static final class FirestoreStub extends AbstractAsyncStub<FirestoreStub> {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.grpc.stub.AbstractStub
        /* renamed from: b */
        public FirestoreStub a(Channel channel, CallOptions callOptions) {
            return new FirestoreStub(channel, callOptions);
        }

        public void batchGetDocuments(BatchGetDocumentsRequest batchGetDocumentsRequest, StreamObserver<BatchGetDocumentsResponse> streamObserver) {
            ClientCalls.asyncServerStreamingCall(getChannel().newCall(FirestoreGrpc.getBatchGetDocumentsMethod(), getCallOptions()), batchGetDocumentsRequest, streamObserver);
        }

        public void beginTransaction(BeginTransactionRequest beginTransactionRequest, StreamObserver<BeginTransactionResponse> streamObserver) {
            ClientCalls.asyncUnaryCall(getChannel().newCall(FirestoreGrpc.getBeginTransactionMethod(), getCallOptions()), beginTransactionRequest, streamObserver);
        }

        public void commit(CommitRequest commitRequest, StreamObserver<CommitResponse> streamObserver) {
            ClientCalls.asyncUnaryCall(getChannel().newCall(FirestoreGrpc.getCommitMethod(), getCallOptions()), commitRequest, streamObserver);
        }

        public void createDocument(CreateDocumentRequest createDocumentRequest, StreamObserver<Document> streamObserver) {
            ClientCalls.asyncUnaryCall(getChannel().newCall(FirestoreGrpc.getCreateDocumentMethod(), getCallOptions()), createDocumentRequest, streamObserver);
        }

        public void deleteDocument(DeleteDocumentRequest deleteDocumentRequest, StreamObserver<Empty> streamObserver) {
            ClientCalls.asyncUnaryCall(getChannel().newCall(FirestoreGrpc.getDeleteDocumentMethod(), getCallOptions()), deleteDocumentRequest, streamObserver);
        }

        public void getDocument(GetDocumentRequest getDocumentRequest, StreamObserver<Document> streamObserver) {
            ClientCalls.asyncUnaryCall(getChannel().newCall(FirestoreGrpc.getGetDocumentMethod(), getCallOptions()), getDocumentRequest, streamObserver);
        }

        public void listCollectionIds(ListCollectionIdsRequest listCollectionIdsRequest, StreamObserver<ListCollectionIdsResponse> streamObserver) {
            ClientCalls.asyncUnaryCall(getChannel().newCall(FirestoreGrpc.getListCollectionIdsMethod(), getCallOptions()), listCollectionIdsRequest, streamObserver);
        }

        public void listDocuments(ListDocumentsRequest listDocumentsRequest, StreamObserver<ListDocumentsResponse> streamObserver) {
            ClientCalls.asyncUnaryCall(getChannel().newCall(FirestoreGrpc.getListDocumentsMethod(), getCallOptions()), listDocumentsRequest, streamObserver);
        }

        public StreamObserver<ListenRequest> listen(StreamObserver<ListenResponse> streamObserver) {
            return ClientCalls.asyncBidiStreamingCall(getChannel().newCall(FirestoreGrpc.getListenMethod(), getCallOptions()), streamObserver);
        }

        public void rollback(RollbackRequest rollbackRequest, StreamObserver<Empty> streamObserver) {
            ClientCalls.asyncUnaryCall(getChannel().newCall(FirestoreGrpc.getRollbackMethod(), getCallOptions()), rollbackRequest, streamObserver);
        }

        public void runAggregationQuery(RunAggregationQueryRequest runAggregationQueryRequest, StreamObserver<RunAggregationQueryResponse> streamObserver) {
            ClientCalls.asyncServerStreamingCall(getChannel().newCall(FirestoreGrpc.getRunAggregationQueryMethod(), getCallOptions()), runAggregationQueryRequest, streamObserver);
        }

        public void runQuery(RunQueryRequest runQueryRequest, StreamObserver<RunQueryResponse> streamObserver) {
            ClientCalls.asyncServerStreamingCall(getChannel().newCall(FirestoreGrpc.getRunQueryMethod(), getCallOptions()), runQueryRequest, streamObserver);
        }

        public void updateDocument(UpdateDocumentRequest updateDocumentRequest, StreamObserver<Document> streamObserver) {
            ClientCalls.asyncUnaryCall(getChannel().newCall(FirestoreGrpc.getUpdateDocumentMethod(), getCallOptions()), updateDocumentRequest, streamObserver);
        }

        public StreamObserver<WriteRequest> write(StreamObserver<WriteResponse> streamObserver) {
            return ClientCalls.asyncBidiStreamingCall(getChannel().newCall(FirestoreGrpc.getWriteMethod(), getCallOptions()), streamObserver);
        }

        private FirestoreStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }
    }

    private FirestoreGrpc() {
    }

    @RpcMethod(fullMethodName = "google.firestore.v1.Firestore/BatchGetDocuments", methodType = MethodDescriptor.MethodType.SERVER_STREAMING, requestType = BatchGetDocumentsRequest.class, responseType = BatchGetDocumentsResponse.class)
    public static MethodDescriptor<BatchGetDocumentsRequest, BatchGetDocumentsResponse> getBatchGetDocumentsMethod() {
        MethodDescriptor<BatchGetDocumentsRequest, BatchGetDocumentsResponse> methodDescriptor = f32466f;
        if (methodDescriptor == null) {
            synchronized (FirestoreGrpc.class) {
                methodDescriptor = f32466f;
                if (methodDescriptor == null) {
                    methodDescriptor = MethodDescriptor.newBuilder().setType(MethodDescriptor.MethodType.SERVER_STREAMING).setFullMethodName(MethodDescriptor.generateFullMethodName(SERVICE_NAME, "BatchGetDocuments")).setSampledToLocalTracing(true).setRequestMarshaller(ProtoLiteUtils.marshaller(BatchGetDocumentsRequest.getDefaultInstance())).setResponseMarshaller(ProtoLiteUtils.marshaller(BatchGetDocumentsResponse.getDefaultInstance())).build();
                    f32466f = methodDescriptor;
                }
            }
        }
        return methodDescriptor;
    }

    @RpcMethod(fullMethodName = "google.firestore.v1.Firestore/BeginTransaction", methodType = MethodDescriptor.MethodType.UNARY, requestType = BeginTransactionRequest.class, responseType = BeginTransactionResponse.class)
    public static MethodDescriptor<BeginTransactionRequest, BeginTransactionResponse> getBeginTransactionMethod() {
        MethodDescriptor<BeginTransactionRequest, BeginTransactionResponse> methodDescriptor = f32467g;
        if (methodDescriptor == null) {
            synchronized (FirestoreGrpc.class) {
                methodDescriptor = f32467g;
                if (methodDescriptor == null) {
                    methodDescriptor = MethodDescriptor.newBuilder().setType(MethodDescriptor.MethodType.UNARY).setFullMethodName(MethodDescriptor.generateFullMethodName(SERVICE_NAME, "BeginTransaction")).setSampledToLocalTracing(true).setRequestMarshaller(ProtoLiteUtils.marshaller(BeginTransactionRequest.getDefaultInstance())).setResponseMarshaller(ProtoLiteUtils.marshaller(BeginTransactionResponse.getDefaultInstance())).build();
                    f32467g = methodDescriptor;
                }
            }
        }
        return methodDescriptor;
    }

    @RpcMethod(fullMethodName = "google.firestore.v1.Firestore/Commit", methodType = MethodDescriptor.MethodType.UNARY, requestType = CommitRequest.class, responseType = CommitResponse.class)
    public static MethodDescriptor<CommitRequest, CommitResponse> getCommitMethod() {
        MethodDescriptor<CommitRequest, CommitResponse> methodDescriptor = f32468h;
        if (methodDescriptor == null) {
            synchronized (FirestoreGrpc.class) {
                methodDescriptor = f32468h;
                if (methodDescriptor == null) {
                    methodDescriptor = MethodDescriptor.newBuilder().setType(MethodDescriptor.MethodType.UNARY).setFullMethodName(MethodDescriptor.generateFullMethodName(SERVICE_NAME, "Commit")).setSampledToLocalTracing(true).setRequestMarshaller(ProtoLiteUtils.marshaller(CommitRequest.getDefaultInstance())).setResponseMarshaller(ProtoLiteUtils.marshaller(CommitResponse.getDefaultInstance())).build();
                    f32468h = methodDescriptor;
                }
            }
        }
        return methodDescriptor;
    }

    @RpcMethod(fullMethodName = "google.firestore.v1.Firestore/CreateDocument", methodType = MethodDescriptor.MethodType.UNARY, requestType = CreateDocumentRequest.class, responseType = Document.class)
    public static MethodDescriptor<CreateDocumentRequest, Document> getCreateDocumentMethod() {
        MethodDescriptor<CreateDocumentRequest, Document> methodDescriptor = f32463c;
        if (methodDescriptor == null) {
            synchronized (FirestoreGrpc.class) {
                methodDescriptor = f32463c;
                if (methodDescriptor == null) {
                    methodDescriptor = MethodDescriptor.newBuilder().setType(MethodDescriptor.MethodType.UNARY).setFullMethodName(MethodDescriptor.generateFullMethodName(SERVICE_NAME, "CreateDocument")).setSampledToLocalTracing(true).setRequestMarshaller(ProtoLiteUtils.marshaller(CreateDocumentRequest.getDefaultInstance())).setResponseMarshaller(ProtoLiteUtils.marshaller(Document.getDefaultInstance())).build();
                    f32463c = methodDescriptor;
                }
            }
        }
        return methodDescriptor;
    }

    @RpcMethod(fullMethodName = "google.firestore.v1.Firestore/DeleteDocument", methodType = MethodDescriptor.MethodType.UNARY, requestType = DeleteDocumentRequest.class, responseType = Empty.class)
    public static MethodDescriptor<DeleteDocumentRequest, Empty> getDeleteDocumentMethod() {
        MethodDescriptor<DeleteDocumentRequest, Empty> methodDescriptor = f32465e;
        if (methodDescriptor == null) {
            synchronized (FirestoreGrpc.class) {
                methodDescriptor = f32465e;
                if (methodDescriptor == null) {
                    methodDescriptor = MethodDescriptor.newBuilder().setType(MethodDescriptor.MethodType.UNARY).setFullMethodName(MethodDescriptor.generateFullMethodName(SERVICE_NAME, "DeleteDocument")).setSampledToLocalTracing(true).setRequestMarshaller(ProtoLiteUtils.marshaller(DeleteDocumentRequest.getDefaultInstance())).setResponseMarshaller(ProtoLiteUtils.marshaller(Empty.getDefaultInstance())).build();
                    f32465e = methodDescriptor;
                }
            }
        }
        return methodDescriptor;
    }

    @RpcMethod(fullMethodName = "google.firestore.v1.Firestore/GetDocument", methodType = MethodDescriptor.MethodType.UNARY, requestType = GetDocumentRequest.class, responseType = Document.class)
    public static MethodDescriptor<GetDocumentRequest, Document> getGetDocumentMethod() {
        MethodDescriptor<GetDocumentRequest, Document> methodDescriptor = f32461a;
        if (methodDescriptor == null) {
            synchronized (FirestoreGrpc.class) {
                methodDescriptor = f32461a;
                if (methodDescriptor == null) {
                    methodDescriptor = MethodDescriptor.newBuilder().setType(MethodDescriptor.MethodType.UNARY).setFullMethodName(MethodDescriptor.generateFullMethodName(SERVICE_NAME, "GetDocument")).setSampledToLocalTracing(true).setRequestMarshaller(ProtoLiteUtils.marshaller(GetDocumentRequest.getDefaultInstance())).setResponseMarshaller(ProtoLiteUtils.marshaller(Document.getDefaultInstance())).build();
                    f32461a = methodDescriptor;
                }
            }
        }
        return methodDescriptor;
    }

    @RpcMethod(fullMethodName = "google.firestore.v1.Firestore/ListCollectionIds", methodType = MethodDescriptor.MethodType.UNARY, requestType = ListCollectionIdsRequest.class, responseType = ListCollectionIdsResponse.class)
    public static MethodDescriptor<ListCollectionIdsRequest, ListCollectionIdsResponse> getListCollectionIdsMethod() {
        MethodDescriptor<ListCollectionIdsRequest, ListCollectionIdsResponse> methodDescriptor = f32474n;
        if (methodDescriptor == null) {
            synchronized (FirestoreGrpc.class) {
                methodDescriptor = f32474n;
                if (methodDescriptor == null) {
                    methodDescriptor = MethodDescriptor.newBuilder().setType(MethodDescriptor.MethodType.UNARY).setFullMethodName(MethodDescriptor.generateFullMethodName(SERVICE_NAME, "ListCollectionIds")).setSampledToLocalTracing(true).setRequestMarshaller(ProtoLiteUtils.marshaller(ListCollectionIdsRequest.getDefaultInstance())).setResponseMarshaller(ProtoLiteUtils.marshaller(ListCollectionIdsResponse.getDefaultInstance())).build();
                    f32474n = methodDescriptor;
                }
            }
        }
        return methodDescriptor;
    }

    @RpcMethod(fullMethodName = "google.firestore.v1.Firestore/ListDocuments", methodType = MethodDescriptor.MethodType.UNARY, requestType = ListDocumentsRequest.class, responseType = ListDocumentsResponse.class)
    public static MethodDescriptor<ListDocumentsRequest, ListDocumentsResponse> getListDocumentsMethod() {
        MethodDescriptor<ListDocumentsRequest, ListDocumentsResponse> methodDescriptor = f32462b;
        if (methodDescriptor == null) {
            synchronized (FirestoreGrpc.class) {
                methodDescriptor = f32462b;
                if (methodDescriptor == null) {
                    methodDescriptor = MethodDescriptor.newBuilder().setType(MethodDescriptor.MethodType.UNARY).setFullMethodName(MethodDescriptor.generateFullMethodName(SERVICE_NAME, "ListDocuments")).setSampledToLocalTracing(true).setRequestMarshaller(ProtoLiteUtils.marshaller(ListDocumentsRequest.getDefaultInstance())).setResponseMarshaller(ProtoLiteUtils.marshaller(ListDocumentsResponse.getDefaultInstance())).build();
                    f32462b = methodDescriptor;
                }
            }
        }
        return methodDescriptor;
    }

    @RpcMethod(fullMethodName = "google.firestore.v1.Firestore/Listen", methodType = MethodDescriptor.MethodType.BIDI_STREAMING, requestType = ListenRequest.class, responseType = ListenResponse.class)
    public static MethodDescriptor<ListenRequest, ListenResponse> getListenMethod() {
        MethodDescriptor<ListenRequest, ListenResponse> methodDescriptor = f32473m;
        if (methodDescriptor == null) {
            synchronized (FirestoreGrpc.class) {
                methodDescriptor = f32473m;
                if (methodDescriptor == null) {
                    methodDescriptor = MethodDescriptor.newBuilder().setType(MethodDescriptor.MethodType.BIDI_STREAMING).setFullMethodName(MethodDescriptor.generateFullMethodName(SERVICE_NAME, "Listen")).setSampledToLocalTracing(true).setRequestMarshaller(ProtoLiteUtils.marshaller(ListenRequest.getDefaultInstance())).setResponseMarshaller(ProtoLiteUtils.marshaller(ListenResponse.getDefaultInstance())).build();
                    f32473m = methodDescriptor;
                }
            }
        }
        return methodDescriptor;
    }

    @RpcMethod(fullMethodName = "google.firestore.v1.Firestore/Rollback", methodType = MethodDescriptor.MethodType.UNARY, requestType = RollbackRequest.class, responseType = Empty.class)
    public static MethodDescriptor<RollbackRequest, Empty> getRollbackMethod() {
        MethodDescriptor<RollbackRequest, Empty> methodDescriptor = f32469i;
        if (methodDescriptor == null) {
            synchronized (FirestoreGrpc.class) {
                methodDescriptor = f32469i;
                if (methodDescriptor == null) {
                    methodDescriptor = MethodDescriptor.newBuilder().setType(MethodDescriptor.MethodType.UNARY).setFullMethodName(MethodDescriptor.generateFullMethodName(SERVICE_NAME, "Rollback")).setSampledToLocalTracing(true).setRequestMarshaller(ProtoLiteUtils.marshaller(RollbackRequest.getDefaultInstance())).setResponseMarshaller(ProtoLiteUtils.marshaller(Empty.getDefaultInstance())).build();
                    f32469i = methodDescriptor;
                }
            }
        }
        return methodDescriptor;
    }

    @RpcMethod(fullMethodName = "google.firestore.v1.Firestore/RunAggregationQuery", methodType = MethodDescriptor.MethodType.SERVER_STREAMING, requestType = RunAggregationQueryRequest.class, responseType = RunAggregationQueryResponse.class)
    public static MethodDescriptor<RunAggregationQueryRequest, RunAggregationQueryResponse> getRunAggregationQueryMethod() {
        MethodDescriptor<RunAggregationQueryRequest, RunAggregationQueryResponse> methodDescriptor = f32471k;
        if (methodDescriptor == null) {
            synchronized (FirestoreGrpc.class) {
                methodDescriptor = f32471k;
                if (methodDescriptor == null) {
                    methodDescriptor = MethodDescriptor.newBuilder().setType(MethodDescriptor.MethodType.SERVER_STREAMING).setFullMethodName(MethodDescriptor.generateFullMethodName(SERVICE_NAME, "RunAggregationQuery")).setSampledToLocalTracing(true).setRequestMarshaller(ProtoLiteUtils.marshaller(RunAggregationQueryRequest.getDefaultInstance())).setResponseMarshaller(ProtoLiteUtils.marshaller(RunAggregationQueryResponse.getDefaultInstance())).build();
                    f32471k = methodDescriptor;
                }
            }
        }
        return methodDescriptor;
    }

    @RpcMethod(fullMethodName = "google.firestore.v1.Firestore/RunQuery", methodType = MethodDescriptor.MethodType.SERVER_STREAMING, requestType = RunQueryRequest.class, responseType = RunQueryResponse.class)
    public static MethodDescriptor<RunQueryRequest, RunQueryResponse> getRunQueryMethod() {
        MethodDescriptor<RunQueryRequest, RunQueryResponse> methodDescriptor = f32470j;
        if (methodDescriptor == null) {
            synchronized (FirestoreGrpc.class) {
                methodDescriptor = f32470j;
                if (methodDescriptor == null) {
                    methodDescriptor = MethodDescriptor.newBuilder().setType(MethodDescriptor.MethodType.SERVER_STREAMING).setFullMethodName(MethodDescriptor.generateFullMethodName(SERVICE_NAME, "RunQuery")).setSampledToLocalTracing(true).setRequestMarshaller(ProtoLiteUtils.marshaller(RunQueryRequest.getDefaultInstance())).setResponseMarshaller(ProtoLiteUtils.marshaller(RunQueryResponse.getDefaultInstance())).build();
                    f32470j = methodDescriptor;
                }
            }
        }
        return methodDescriptor;
    }

    public static ServiceDescriptor getServiceDescriptor() {
        ServiceDescriptor serviceDescriptor = f32475o;
        if (serviceDescriptor == null) {
            synchronized (FirestoreGrpc.class) {
                serviceDescriptor = f32475o;
                if (serviceDescriptor == null) {
                    serviceDescriptor = ServiceDescriptor.newBuilder(SERVICE_NAME).addMethod(getGetDocumentMethod()).addMethod(getListDocumentsMethod()).addMethod(getCreateDocumentMethod()).addMethod(getUpdateDocumentMethod()).addMethod(getDeleteDocumentMethod()).addMethod(getBatchGetDocumentsMethod()).addMethod(getBeginTransactionMethod()).addMethod(getCommitMethod()).addMethod(getRollbackMethod()).addMethod(getRunQueryMethod()).addMethod(getRunAggregationQueryMethod()).addMethod(getWriteMethod()).addMethod(getListenMethod()).addMethod(getListCollectionIdsMethod()).build();
                    f32475o = serviceDescriptor;
                }
            }
        }
        return serviceDescriptor;
    }

    @RpcMethod(fullMethodName = "google.firestore.v1.Firestore/UpdateDocument", methodType = MethodDescriptor.MethodType.UNARY, requestType = UpdateDocumentRequest.class, responseType = Document.class)
    public static MethodDescriptor<UpdateDocumentRequest, Document> getUpdateDocumentMethod() {
        MethodDescriptor<UpdateDocumentRequest, Document> methodDescriptor = f32464d;
        if (methodDescriptor == null) {
            synchronized (FirestoreGrpc.class) {
                methodDescriptor = f32464d;
                if (methodDescriptor == null) {
                    methodDescriptor = MethodDescriptor.newBuilder().setType(MethodDescriptor.MethodType.UNARY).setFullMethodName(MethodDescriptor.generateFullMethodName(SERVICE_NAME, "UpdateDocument")).setSampledToLocalTracing(true).setRequestMarshaller(ProtoLiteUtils.marshaller(UpdateDocumentRequest.getDefaultInstance())).setResponseMarshaller(ProtoLiteUtils.marshaller(Document.getDefaultInstance())).build();
                    f32464d = methodDescriptor;
                }
            }
        }
        return methodDescriptor;
    }

    @RpcMethod(fullMethodName = "google.firestore.v1.Firestore/Write", methodType = MethodDescriptor.MethodType.BIDI_STREAMING, requestType = WriteRequest.class, responseType = WriteResponse.class)
    public static MethodDescriptor<WriteRequest, WriteResponse> getWriteMethod() {
        MethodDescriptor<WriteRequest, WriteResponse> methodDescriptor = f32472l;
        if (methodDescriptor == null) {
            synchronized (FirestoreGrpc.class) {
                methodDescriptor = f32472l;
                if (methodDescriptor == null) {
                    methodDescriptor = MethodDescriptor.newBuilder().setType(MethodDescriptor.MethodType.BIDI_STREAMING).setFullMethodName(MethodDescriptor.generateFullMethodName(SERVICE_NAME, "Write")).setSampledToLocalTracing(true).setRequestMarshaller(ProtoLiteUtils.marshaller(WriteRequest.getDefaultInstance())).setResponseMarshaller(ProtoLiteUtils.marshaller(WriteResponse.getDefaultInstance())).build();
                    f32472l = methodDescriptor;
                }
            }
        }
        return methodDescriptor;
    }

    public static FirestoreBlockingStub newBlockingStub(Channel channel) {
        return (FirestoreBlockingStub) AbstractBlockingStub.newStub(new AbstractStub.StubFactory<FirestoreBlockingStub>() { // from class: com.google.firestore.v1.FirestoreGrpc.2
            @Override // io.grpc.stub.AbstractStub.StubFactory
            /* renamed from: a */
            public FirestoreBlockingStub newStub(Channel channel2, CallOptions callOptions) {
                return new FirestoreBlockingStub(channel2, callOptions);
            }
        }, channel);
    }

    public static FirestoreFutureStub newFutureStub(Channel channel) {
        return (FirestoreFutureStub) AbstractFutureStub.newStub(new AbstractStub.StubFactory<FirestoreFutureStub>() { // from class: com.google.firestore.v1.FirestoreGrpc.3
            @Override // io.grpc.stub.AbstractStub.StubFactory
            /* renamed from: a */
            public FirestoreFutureStub newStub(Channel channel2, CallOptions callOptions) {
                return new FirestoreFutureStub(channel2, callOptions);
            }
        }, channel);
    }

    public static FirestoreStub newStub(Channel channel) {
        return (FirestoreStub) AbstractAsyncStub.newStub(new AbstractStub.StubFactory<FirestoreStub>() { // from class: com.google.firestore.v1.FirestoreGrpc.1
            @Override // io.grpc.stub.AbstractStub.StubFactory
            /* renamed from: a */
            public FirestoreStub newStub(Channel channel2, CallOptions callOptions) {
                return new FirestoreStub(channel2, callOptions);
            }
        }, channel);
    }

    /* loaded from: classes5.dex */
    private static final class MethodHandlers<Req, Resp> implements ServerCalls.UnaryMethod<Req, Resp>, ServerCalls.ServerStreamingMethod<Req, Resp>, ServerCalls.ClientStreamingMethod<Req, Resp>, ServerCalls.BidiStreamingMethod<Req, Resp> {

        /* renamed from: a  reason: collision with root package name */
        private final FirestoreImplBase f32476a;

        /* renamed from: b  reason: collision with root package name */
        private final int f32477b;

        MethodHandlers(FirestoreImplBase firestoreImplBase, int i4) {
            this.f32476a = firestoreImplBase;
            this.f32477b = i4;
        }

        @Override // io.grpc.stub.ServerCalls.UnaryMethod, io.grpc.stub.ServerCalls.e, io.grpc.stub.ServerCalls.ServerStreamingMethod
        public void invoke(Req req, StreamObserver<Resp> streamObserver) {
            switch (this.f32477b) {
                case 0:
                    this.f32476a.getDocument((GetDocumentRequest) req, streamObserver);
                    return;
                case 1:
                    this.f32476a.listDocuments((ListDocumentsRequest) req, streamObserver);
                    return;
                case 2:
                    this.f32476a.createDocument((CreateDocumentRequest) req, streamObserver);
                    return;
                case 3:
                    this.f32476a.updateDocument((UpdateDocumentRequest) req, streamObserver);
                    return;
                case 4:
                    this.f32476a.deleteDocument((DeleteDocumentRequest) req, streamObserver);
                    return;
                case 5:
                    this.f32476a.batchGetDocuments((BatchGetDocumentsRequest) req, streamObserver);
                    return;
                case 6:
                    this.f32476a.beginTransaction((BeginTransactionRequest) req, streamObserver);
                    return;
                case 7:
                    this.f32476a.commit((CommitRequest) req, streamObserver);
                    return;
                case 8:
                    this.f32476a.rollback((RollbackRequest) req, streamObserver);
                    return;
                case 9:
                    this.f32476a.runQuery((RunQueryRequest) req, streamObserver);
                    return;
                case 10:
                    this.f32476a.runAggregationQuery((RunAggregationQueryRequest) req, streamObserver);
                    return;
                case 11:
                    this.f32476a.listCollectionIds((ListCollectionIdsRequest) req, streamObserver);
                    return;
                default:
                    throw new AssertionError();
            }
        }

        @Override // io.grpc.stub.ServerCalls.ClientStreamingMethod, io.grpc.stub.ServerCalls.c, io.grpc.stub.ServerCalls.BidiStreamingMethod
        public StreamObserver<Req> invoke(StreamObserver<Resp> streamObserver) {
            int i4 = this.f32477b;
            if (i4 != 12) {
                if (i4 == 13) {
                    return (StreamObserver<Req>) this.f32476a.listen(streamObserver);
                }
                throw new AssertionError();
            }
            return (StreamObserver<Req>) this.f32476a.write(streamObserver);
        }
    }
}
