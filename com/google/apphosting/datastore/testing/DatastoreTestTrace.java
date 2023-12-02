package com.google.apphosting.datastore.testing;

import com.google.firestore.v1.BatchGetDocumentsRequest;
import com.google.firestore.v1.BatchGetDocumentsResponse;
import com.google.firestore.v1.BatchGetDocumentsResponseOrBuilder;
import com.google.firestore.v1.BeginTransactionRequest;
import com.google.firestore.v1.BeginTransactionResponse;
import com.google.firestore.v1.CommitRequest;
import com.google.firestore.v1.CommitResponse;
import com.google.firestore.v1.CreateDocumentRequest;
import com.google.firestore.v1.DeleteDocumentRequest;
import com.google.firestore.v1.Document;
import com.google.firestore.v1.GetDocumentRequest;
import com.google.firestore.v1.ListCollectionIdsRequest;
import com.google.firestore.v1.ListCollectionIdsResponse;
import com.google.firestore.v1.ListDocumentsRequest;
import com.google.firestore.v1.ListDocumentsResponse;
import com.google.firestore.v1.ListenRequest;
import com.google.firestore.v1.ListenResponse;
import com.google.firestore.v1.RollbackRequest;
import com.google.firestore.v1.RunQueryRequest;
import com.google.firestore.v1.RunQueryResponse;
import com.google.firestore.v1.RunQueryResponseOrBuilder;
import com.google.firestore.v1.UpdateDocumentRequest;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Empty;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: classes5.dex */
public final class DatastoreTestTrace {

    /* renamed from: com.google.apphosting.datastore.testing.DatastoreTestTrace$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f26254a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f26254a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f26254a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f26254a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f26254a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f26254a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f26254a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f26254a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class DatastoreAction extends GeneratedMessageLite<DatastoreAction, Builder> implements DatastoreActionOrBuilder {
        public static final int ACTION_ID_FIELD_NUMBER = 200;
        private static final DatastoreAction DEFAULT_INSTANCE;
        public static final int FIRESTORE_V1_ACTION_FIELD_NUMBER = 3;
        private static volatile Parser<DatastoreAction> PARSER = null;
        public static final int VALIDATION_RULE_FIELD_NUMBER = 201;
        private int actionCase_ = 0;
        private int actionId_;
        private Object action_;
        private ValidationRule validationRule_;

        /* loaded from: classes5.dex */
        public enum ActionCase {
            FIRESTORE_V1_ACTION(3),
            ACTION_NOT_SET(0);
            
            private final int value;

            ActionCase(int i4) {
                this.value = i4;
            }

            public static ActionCase forNumber(int i4) {
                if (i4 != 0) {
                    if (i4 != 3) {
                        return null;
                    }
                    return FIRESTORE_V1_ACTION;
                }
                return ACTION_NOT_SET;
            }

            public int getNumber() {
                return this.value;
            }

            @Deprecated
            public static ActionCase valueOf(int i4) {
                return forNumber(i4);
            }
        }

        /* loaded from: classes5.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<DatastoreAction, Builder> implements DatastoreActionOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearAction() {
                f();
                ((DatastoreAction) this.f33398b).p0();
                return this;
            }

            public Builder clearActionId() {
                f();
                ((DatastoreAction) this.f33398b).q0();
                return this;
            }

            public Builder clearFirestoreV1Action() {
                f();
                ((DatastoreAction) this.f33398b).r0();
                return this;
            }

            public Builder clearValidationRule() {
                f();
                ((DatastoreAction) this.f33398b).s0();
                return this;
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.DatastoreActionOrBuilder
            public ActionCase getActionCase() {
                return ((DatastoreAction) this.f33398b).getActionCase();
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.DatastoreActionOrBuilder
            public int getActionId() {
                return ((DatastoreAction) this.f33398b).getActionId();
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.DatastoreActionOrBuilder
            public FirestoreV1Action getFirestoreV1Action() {
                return ((DatastoreAction) this.f33398b).getFirestoreV1Action();
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.DatastoreActionOrBuilder
            public ValidationRule getValidationRule() {
                return ((DatastoreAction) this.f33398b).getValidationRule();
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.DatastoreActionOrBuilder
            public boolean hasFirestoreV1Action() {
                return ((DatastoreAction) this.f33398b).hasFirestoreV1Action();
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.DatastoreActionOrBuilder
            public boolean hasValidationRule() {
                return ((DatastoreAction) this.f33398b).hasValidationRule();
            }

            public Builder mergeFirestoreV1Action(FirestoreV1Action firestoreV1Action) {
                f();
                ((DatastoreAction) this.f33398b).t0(firestoreV1Action);
                return this;
            }

            public Builder mergeValidationRule(ValidationRule validationRule) {
                f();
                ((DatastoreAction) this.f33398b).u0(validationRule);
                return this;
            }

            public Builder setActionId(int i4) {
                f();
                ((DatastoreAction) this.f33398b).v0(i4);
                return this;
            }

            public Builder setFirestoreV1Action(FirestoreV1Action firestoreV1Action) {
                f();
                ((DatastoreAction) this.f33398b).w0(firestoreV1Action);
                return this;
            }

            public Builder setValidationRule(ValidationRule validationRule) {
                f();
                ((DatastoreAction) this.f33398b).x0(validationRule);
                return this;
            }

            private Builder() {
                super(DatastoreAction.DEFAULT_INSTANCE);
            }

            public Builder setFirestoreV1Action(FirestoreV1Action.Builder builder) {
                f();
                ((DatastoreAction) this.f33398b).w0(builder.build());
                return this;
            }

            public Builder setValidationRule(ValidationRule.Builder builder) {
                f();
                ((DatastoreAction) this.f33398b).x0(builder.build());
                return this;
            }
        }

        static {
            DatastoreAction datastoreAction = new DatastoreAction();
            DEFAULT_INSTANCE = datastoreAction;
            GeneratedMessageLite.d0(DatastoreAction.class, datastoreAction);
        }

        private DatastoreAction() {
        }

        public static DatastoreAction getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.q();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void p0() {
            this.actionCase_ = 0;
            this.action_ = null;
        }

        public static DatastoreAction parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (DatastoreAction) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
        }

        public static DatastoreAction parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (DatastoreAction) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<DatastoreAction> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void q0() {
            this.actionId_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void r0() {
            if (this.actionCase_ == 3) {
                this.actionCase_ = 0;
                this.action_ = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s0() {
            this.validationRule_ = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void t0(FirestoreV1Action firestoreV1Action) {
            firestoreV1Action.getClass();
            if (this.actionCase_ == 3 && this.action_ != FirestoreV1Action.getDefaultInstance()) {
                this.action_ = FirestoreV1Action.newBuilder((FirestoreV1Action) this.action_).mergeFrom((FirestoreV1Action.Builder) firestoreV1Action).buildPartial();
            } else {
                this.action_ = firestoreV1Action;
            }
            this.actionCase_ = 3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void u0(ValidationRule validationRule) {
            validationRule.getClass();
            ValidationRule validationRule2 = this.validationRule_;
            if (validationRule2 != null && validationRule2 != ValidationRule.getDefaultInstance()) {
                this.validationRule_ = ValidationRule.newBuilder(this.validationRule_).mergeFrom((ValidationRule.Builder) validationRule).buildPartial();
            } else {
                this.validationRule_ = validationRule;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void v0(int i4) {
            this.actionId_ = i4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void w0(FirestoreV1Action firestoreV1Action) {
            firestoreV1Action.getClass();
            this.action_ = firestoreV1Action;
            this.actionCase_ = 3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void x0(ValidationRule validationRule) {
            validationRule.getClass();
            this.validationRule_ = validationRule;
        }

        @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.DatastoreActionOrBuilder
        public ActionCase getActionCase() {
            return ActionCase.forNumber(this.actionCase_);
        }

        @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.DatastoreActionOrBuilder
        public int getActionId() {
            return this.actionId_;
        }

        @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.DatastoreActionOrBuilder
        public FirestoreV1Action getFirestoreV1Action() {
            if (this.actionCase_ == 3) {
                return (FirestoreV1Action) this.action_;
            }
            return FirestoreV1Action.getDefaultInstance();
        }

        @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.DatastoreActionOrBuilder
        public ValidationRule getValidationRule() {
            ValidationRule validationRule = this.validationRule_;
            if (validationRule == null) {
                return ValidationRule.getDefaultInstance();
            }
            return validationRule;
        }

        @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.DatastoreActionOrBuilder
        public boolean hasFirestoreV1Action() {
            if (this.actionCase_ == 3) {
                return true;
            }
            return false;
        }

        @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.DatastoreActionOrBuilder
        public boolean hasValidationRule() {
            if (this.validationRule_ != null) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (AnonymousClass1.f26254a[methodToInvoke.ordinal()]) {
                case 1:
                    return new DatastoreAction();
                case 2:
                    return new Builder(null);
                case 3:
                    return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0003\u0001\u0000\u0003É\u0003\u0000\u0000\u0000\u0003<\u0000È\u0004É\t", new Object[]{"action_", "actionCase_", FirestoreV1Action.class, "actionId_", "validationRule_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<DatastoreAction> parser = PARSER;
                    if (parser == null) {
                        synchronized (DatastoreAction.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static Builder newBuilder(DatastoreAction datastoreAction) {
            return DEFAULT_INSTANCE.r(datastoreAction);
        }

        public static DatastoreAction parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (DatastoreAction) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static DatastoreAction parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (DatastoreAction) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static DatastoreAction parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (DatastoreAction) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
        }

        public static DatastoreAction parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (DatastoreAction) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static DatastoreAction parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (DatastoreAction) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
        }

        public static DatastoreAction parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (DatastoreAction) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static DatastoreAction parseFrom(InputStream inputStream) throws IOException {
            return (DatastoreAction) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
        }

        public static DatastoreAction parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (DatastoreAction) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static DatastoreAction parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (DatastoreAction) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
        }

        public static DatastoreAction parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (DatastoreAction) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: classes5.dex */
    public interface DatastoreActionOrBuilder extends MessageLiteOrBuilder {
        DatastoreAction.ActionCase getActionCase();

        int getActionId();

        FirestoreV1Action getFirestoreV1Action();

        ValidationRule getValidationRule();

        boolean hasFirestoreV1Action();

        boolean hasValidationRule();
    }

    /* loaded from: classes5.dex */
    public static final class FirestoreV1Action extends GeneratedMessageLite<FirestoreV1Action, Builder> implements FirestoreV1ActionOrBuilder {
        public static final int BATCH_GET_DOCUMENTS_FIELD_NUMBER = 10;
        public static final int BEGIN_TRANSACTION_FIELD_NUMBER = 6;
        public static final int COMMIT_FIELD_NUMBER = 7;
        public static final int CREATE_DOCUMENT_FIELD_NUMBER = 3;
        public static final int DATABASE_CONTENTS_BEFORE_ACTION_FIELD_NUMBER = 202;
        private static final FirestoreV1Action DEFAULT_INSTANCE;
        public static final int DELETE_DOCUMENT_FIELD_NUMBER = 5;
        public static final int GET_DOCUMENT_FIELD_NUMBER = 1;
        public static final int LISTEN_FIELD_NUMBER = 12;
        public static final int LIST_COLLECTION_IDS_FIELD_NUMBER = 9;
        public static final int LIST_DOCUMENTS_FIELD_NUMBER = 2;
        public static final int MATCHING_DOCUMENTS_FIELD_NUMBER = 203;
        private static volatile Parser<FirestoreV1Action> PARSER = null;
        public static final int REMOVE_LISTEN_FIELD_NUMBER = 13;
        public static final int ROLLBACK_FIELD_NUMBER = 8;
        public static final int RUN_QUERY_FIELD_NUMBER = 11;
        public static final int STATUS_FIELD_NUMBER = 201;
        public static final int UPDATE_DOCUMENT_FIELD_NUMBER = 4;
        private Object action_;
        private RunQuery databaseContentsBeforeAction_;
        private StatusProto status_;
        private int actionCase_ = 0;
        private Internal.ProtobufList<MatchingDocuments> matchingDocuments_ = GeneratedMessageLite.y();

        /* loaded from: classes5.dex */
        public enum ActionCase {
            GET_DOCUMENT(1),
            LIST_DOCUMENTS(2),
            CREATE_DOCUMENT(3),
            UPDATE_DOCUMENT(4),
            DELETE_DOCUMENT(5),
            BEGIN_TRANSACTION(6),
            COMMIT(7),
            ROLLBACK(8),
            LIST_COLLECTION_IDS(9),
            BATCH_GET_DOCUMENTS(10),
            RUN_QUERY(11),
            LISTEN(12),
            REMOVE_LISTEN(13),
            ACTION_NOT_SET(0);
            
            private final int value;

            ActionCase(int i4) {
                this.value = i4;
            }

            public static ActionCase forNumber(int i4) {
                switch (i4) {
                    case 0:
                        return ACTION_NOT_SET;
                    case 1:
                        return GET_DOCUMENT;
                    case 2:
                        return LIST_DOCUMENTS;
                    case 3:
                        return CREATE_DOCUMENT;
                    case 4:
                        return UPDATE_DOCUMENT;
                    case 5:
                        return DELETE_DOCUMENT;
                    case 6:
                        return BEGIN_TRANSACTION;
                    case 7:
                        return COMMIT;
                    case 8:
                        return ROLLBACK;
                    case 9:
                        return LIST_COLLECTION_IDS;
                    case 10:
                        return BATCH_GET_DOCUMENTS;
                    case 11:
                        return RUN_QUERY;
                    case 12:
                        return LISTEN;
                    case 13:
                        return REMOVE_LISTEN;
                    default:
                        return null;
                }
            }

            public int getNumber() {
                return this.value;
            }

            @Deprecated
            public static ActionCase valueOf(int i4) {
                return forNumber(i4);
            }
        }

        /* loaded from: classes5.dex */
        public static final class BatchGetDocuments extends GeneratedMessageLite<BatchGetDocuments, Builder> implements BatchGetDocumentsOrBuilder {
            private static final BatchGetDocuments DEFAULT_INSTANCE;
            private static volatile Parser<BatchGetDocuments> PARSER = null;
            public static final int REQUEST_FIELD_NUMBER = 1;
            public static final int RESPONSE_FIELD_NUMBER = 2;
            private BatchGetDocumentsRequest request_;
            private Internal.ProtobufList<BatchGetDocumentsResponse> response_ = GeneratedMessageLite.y();

            /* loaded from: classes5.dex */
            public static final class Builder extends GeneratedMessageLite.Builder<BatchGetDocuments, Builder> implements BatchGetDocumentsOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                public Builder addAllResponse(Iterable<? extends BatchGetDocumentsResponse> iterable) {
                    f();
                    ((BatchGetDocuments) this.f33398b).p0(iterable);
                    return this;
                }

                public Builder addResponse(BatchGetDocumentsResponse batchGetDocumentsResponse) {
                    f();
                    ((BatchGetDocuments) this.f33398b).r0(batchGetDocumentsResponse);
                    return this;
                }

                public Builder clearRequest() {
                    f();
                    ((BatchGetDocuments) this.f33398b).s0();
                    return this;
                }

                public Builder clearResponse() {
                    f();
                    ((BatchGetDocuments) this.f33398b).t0();
                    return this;
                }

                @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.BatchGetDocumentsOrBuilder
                public BatchGetDocumentsRequest getRequest() {
                    return ((BatchGetDocuments) this.f33398b).getRequest();
                }

                @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.BatchGetDocumentsOrBuilder
                public BatchGetDocumentsResponse getResponse(int i4) {
                    return ((BatchGetDocuments) this.f33398b).getResponse(i4);
                }

                @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.BatchGetDocumentsOrBuilder
                public int getResponseCount() {
                    return ((BatchGetDocuments) this.f33398b).getResponseCount();
                }

                @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.BatchGetDocumentsOrBuilder
                public List<BatchGetDocumentsResponse> getResponseList() {
                    return Collections.unmodifiableList(((BatchGetDocuments) this.f33398b).getResponseList());
                }

                @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.BatchGetDocumentsOrBuilder
                public boolean hasRequest() {
                    return ((BatchGetDocuments) this.f33398b).hasRequest();
                }

                public Builder mergeRequest(BatchGetDocumentsRequest batchGetDocumentsRequest) {
                    f();
                    ((BatchGetDocuments) this.f33398b).v0(batchGetDocumentsRequest);
                    return this;
                }

                public Builder removeResponse(int i4) {
                    f();
                    ((BatchGetDocuments) this.f33398b).w0(i4);
                    return this;
                }

                public Builder setRequest(BatchGetDocumentsRequest batchGetDocumentsRequest) {
                    f();
                    ((BatchGetDocuments) this.f33398b).x0(batchGetDocumentsRequest);
                    return this;
                }

                public Builder setResponse(int i4, BatchGetDocumentsResponse batchGetDocumentsResponse) {
                    f();
                    ((BatchGetDocuments) this.f33398b).y0(i4, batchGetDocumentsResponse);
                    return this;
                }

                private Builder() {
                    super(BatchGetDocuments.DEFAULT_INSTANCE);
                }

                public Builder addResponse(int i4, BatchGetDocumentsResponse batchGetDocumentsResponse) {
                    f();
                    ((BatchGetDocuments) this.f33398b).q0(i4, batchGetDocumentsResponse);
                    return this;
                }

                public Builder setRequest(BatchGetDocumentsRequest.Builder builder) {
                    f();
                    ((BatchGetDocuments) this.f33398b).x0(builder.build());
                    return this;
                }

                public Builder setResponse(int i4, BatchGetDocumentsResponse.Builder builder) {
                    f();
                    ((BatchGetDocuments) this.f33398b).y0(i4, builder.build());
                    return this;
                }

                public Builder addResponse(BatchGetDocumentsResponse.Builder builder) {
                    f();
                    ((BatchGetDocuments) this.f33398b).r0(builder.build());
                    return this;
                }

                public Builder addResponse(int i4, BatchGetDocumentsResponse.Builder builder) {
                    f();
                    ((BatchGetDocuments) this.f33398b).q0(i4, builder.build());
                    return this;
                }
            }

            static {
                BatchGetDocuments batchGetDocuments = new BatchGetDocuments();
                DEFAULT_INSTANCE = batchGetDocuments;
                GeneratedMessageLite.d0(BatchGetDocuments.class, batchGetDocuments);
            }

            private BatchGetDocuments() {
            }

            public static BatchGetDocuments getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.q();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void p0(Iterable<? extends BatchGetDocumentsResponse> iterable) {
                u0();
                AbstractMessageLite.a(iterable, this.response_);
            }

            public static BatchGetDocuments parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (BatchGetDocuments) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
            }

            public static BatchGetDocuments parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return (BatchGetDocuments) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
            }

            public static Parser<BatchGetDocuments> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void q0(int i4, BatchGetDocumentsResponse batchGetDocumentsResponse) {
                batchGetDocumentsResponse.getClass();
                u0();
                this.response_.add(i4, batchGetDocumentsResponse);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void r0(BatchGetDocumentsResponse batchGetDocumentsResponse) {
                batchGetDocumentsResponse.getClass();
                u0();
                this.response_.add(batchGetDocumentsResponse);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void s0() {
                this.request_ = null;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void t0() {
                this.response_ = GeneratedMessageLite.y();
            }

            private void u0() {
                Internal.ProtobufList<BatchGetDocumentsResponse> protobufList = this.response_;
                if (!protobufList.isModifiable()) {
                    this.response_ = GeneratedMessageLite.K(protobufList);
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void v0(BatchGetDocumentsRequest batchGetDocumentsRequest) {
                batchGetDocumentsRequest.getClass();
                BatchGetDocumentsRequest batchGetDocumentsRequest2 = this.request_;
                if (batchGetDocumentsRequest2 != null && batchGetDocumentsRequest2 != BatchGetDocumentsRequest.getDefaultInstance()) {
                    this.request_ = BatchGetDocumentsRequest.newBuilder(this.request_).mergeFrom((BatchGetDocumentsRequest.Builder) batchGetDocumentsRequest).buildPartial();
                } else {
                    this.request_ = batchGetDocumentsRequest;
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void w0(int i4) {
                u0();
                this.response_.remove(i4);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void x0(BatchGetDocumentsRequest batchGetDocumentsRequest) {
                batchGetDocumentsRequest.getClass();
                this.request_ = batchGetDocumentsRequest;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void y0(int i4, BatchGetDocumentsResponse batchGetDocumentsResponse) {
                batchGetDocumentsResponse.getClass();
                u0();
                this.response_.set(i4, batchGetDocumentsResponse);
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.BatchGetDocumentsOrBuilder
            public BatchGetDocumentsRequest getRequest() {
                BatchGetDocumentsRequest batchGetDocumentsRequest = this.request_;
                if (batchGetDocumentsRequest == null) {
                    return BatchGetDocumentsRequest.getDefaultInstance();
                }
                return batchGetDocumentsRequest;
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.BatchGetDocumentsOrBuilder
            public BatchGetDocumentsResponse getResponse(int i4) {
                return this.response_.get(i4);
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.BatchGetDocumentsOrBuilder
            public int getResponseCount() {
                return this.response_.size();
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.BatchGetDocumentsOrBuilder
            public List<BatchGetDocumentsResponse> getResponseList() {
                return this.response_;
            }

            public BatchGetDocumentsResponseOrBuilder getResponseOrBuilder(int i4) {
                return this.response_.get(i4);
            }

            public List<? extends BatchGetDocumentsResponseOrBuilder> getResponseOrBuilderList() {
                return this.response_;
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.BatchGetDocumentsOrBuilder
            public boolean hasRequest() {
                if (this.request_ != null) {
                    return true;
                }
                return false;
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                switch (AnonymousClass1.f26254a[methodToInvoke.ordinal()]) {
                    case 1:
                        return new BatchGetDocuments();
                    case 2:
                        return new Builder(null);
                    case 3:
                        return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\t\u0002\u001b", new Object[]{"request_", "response_", BatchGetDocumentsResponse.class});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<BatchGetDocuments> parser = PARSER;
                        if (parser == null) {
                            synchronized (BatchGetDocuments.class) {
                                parser = PARSER;
                                if (parser == null) {
                                    parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                    PARSER = parser;
                                }
                            }
                        }
                        return parser;
                    case 6:
                        return (byte) 1;
                    case 7:
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            public static Builder newBuilder(BatchGetDocuments batchGetDocuments) {
                return DEFAULT_INSTANCE.r(batchGetDocuments);
            }

            public static BatchGetDocuments parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (BatchGetDocuments) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static BatchGetDocuments parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (BatchGetDocuments) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static BatchGetDocuments parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (BatchGetDocuments) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
            }

            public static BatchGetDocuments parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (BatchGetDocuments) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static BatchGetDocuments parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (BatchGetDocuments) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
            }

            public static BatchGetDocuments parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (BatchGetDocuments) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static BatchGetDocuments parseFrom(InputStream inputStream) throws IOException {
                return (BatchGetDocuments) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
            }

            public static BatchGetDocuments parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (BatchGetDocuments) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static BatchGetDocuments parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (BatchGetDocuments) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
            }

            public static BatchGetDocuments parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (BatchGetDocuments) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }
        }

        /* loaded from: classes5.dex */
        public interface BatchGetDocumentsOrBuilder extends MessageLiteOrBuilder {
            BatchGetDocumentsRequest getRequest();

            BatchGetDocumentsResponse getResponse(int i4);

            int getResponseCount();

            List<BatchGetDocumentsResponse> getResponseList();

            boolean hasRequest();
        }

        /* loaded from: classes5.dex */
        public static final class BeginTransaction extends GeneratedMessageLite<BeginTransaction, Builder> implements BeginTransactionOrBuilder {
            private static final BeginTransaction DEFAULT_INSTANCE;
            private static volatile Parser<BeginTransaction> PARSER = null;
            public static final int REQUEST_FIELD_NUMBER = 1;
            public static final int RESPONSE_FIELD_NUMBER = 2;
            private BeginTransactionRequest request_;
            private BeginTransactionResponse response_;

            /* loaded from: classes5.dex */
            public static final class Builder extends GeneratedMessageLite.Builder<BeginTransaction, Builder> implements BeginTransactionOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                public Builder clearRequest() {
                    f();
                    ((BeginTransaction) this.f33398b).m0();
                    return this;
                }

                public Builder clearResponse() {
                    f();
                    ((BeginTransaction) this.f33398b).n0();
                    return this;
                }

                @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.BeginTransactionOrBuilder
                public BeginTransactionRequest getRequest() {
                    return ((BeginTransaction) this.f33398b).getRequest();
                }

                @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.BeginTransactionOrBuilder
                public BeginTransactionResponse getResponse() {
                    return ((BeginTransaction) this.f33398b).getResponse();
                }

                @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.BeginTransactionOrBuilder
                public boolean hasRequest() {
                    return ((BeginTransaction) this.f33398b).hasRequest();
                }

                @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.BeginTransactionOrBuilder
                public boolean hasResponse() {
                    return ((BeginTransaction) this.f33398b).hasResponse();
                }

                public Builder mergeRequest(BeginTransactionRequest beginTransactionRequest) {
                    f();
                    ((BeginTransaction) this.f33398b).o0(beginTransactionRequest);
                    return this;
                }

                public Builder mergeResponse(BeginTransactionResponse beginTransactionResponse) {
                    f();
                    ((BeginTransaction) this.f33398b).p0(beginTransactionResponse);
                    return this;
                }

                public Builder setRequest(BeginTransactionRequest beginTransactionRequest) {
                    f();
                    ((BeginTransaction) this.f33398b).q0(beginTransactionRequest);
                    return this;
                }

                public Builder setResponse(BeginTransactionResponse beginTransactionResponse) {
                    f();
                    ((BeginTransaction) this.f33398b).r0(beginTransactionResponse);
                    return this;
                }

                private Builder() {
                    super(BeginTransaction.DEFAULT_INSTANCE);
                }

                public Builder setRequest(BeginTransactionRequest.Builder builder) {
                    f();
                    ((BeginTransaction) this.f33398b).q0(builder.build());
                    return this;
                }

                public Builder setResponse(BeginTransactionResponse.Builder builder) {
                    f();
                    ((BeginTransaction) this.f33398b).r0(builder.build());
                    return this;
                }
            }

            static {
                BeginTransaction beginTransaction = new BeginTransaction();
                DEFAULT_INSTANCE = beginTransaction;
                GeneratedMessageLite.d0(BeginTransaction.class, beginTransaction);
            }

            private BeginTransaction() {
            }

            public static BeginTransaction getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void m0() {
                this.request_ = null;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void n0() {
                this.response_ = null;
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.q();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void o0(BeginTransactionRequest beginTransactionRequest) {
                beginTransactionRequest.getClass();
                BeginTransactionRequest beginTransactionRequest2 = this.request_;
                if (beginTransactionRequest2 != null && beginTransactionRequest2 != BeginTransactionRequest.getDefaultInstance()) {
                    this.request_ = BeginTransactionRequest.newBuilder(this.request_).mergeFrom((BeginTransactionRequest.Builder) beginTransactionRequest).buildPartial();
                } else {
                    this.request_ = beginTransactionRequest;
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void p0(BeginTransactionResponse beginTransactionResponse) {
                beginTransactionResponse.getClass();
                BeginTransactionResponse beginTransactionResponse2 = this.response_;
                if (beginTransactionResponse2 != null && beginTransactionResponse2 != BeginTransactionResponse.getDefaultInstance()) {
                    this.response_ = BeginTransactionResponse.newBuilder(this.response_).mergeFrom((BeginTransactionResponse.Builder) beginTransactionResponse).buildPartial();
                } else {
                    this.response_ = beginTransactionResponse;
                }
            }

            public static BeginTransaction parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (BeginTransaction) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
            }

            public static BeginTransaction parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return (BeginTransaction) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
            }

            public static Parser<BeginTransaction> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void q0(BeginTransactionRequest beginTransactionRequest) {
                beginTransactionRequest.getClass();
                this.request_ = beginTransactionRequest;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void r0(BeginTransactionResponse beginTransactionResponse) {
                beginTransactionResponse.getClass();
                this.response_ = beginTransactionResponse;
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.BeginTransactionOrBuilder
            public BeginTransactionRequest getRequest() {
                BeginTransactionRequest beginTransactionRequest = this.request_;
                if (beginTransactionRequest == null) {
                    return BeginTransactionRequest.getDefaultInstance();
                }
                return beginTransactionRequest;
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.BeginTransactionOrBuilder
            public BeginTransactionResponse getResponse() {
                BeginTransactionResponse beginTransactionResponse = this.response_;
                if (beginTransactionResponse == null) {
                    return BeginTransactionResponse.getDefaultInstance();
                }
                return beginTransactionResponse;
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.BeginTransactionOrBuilder
            public boolean hasRequest() {
                if (this.request_ != null) {
                    return true;
                }
                return false;
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.BeginTransactionOrBuilder
            public boolean hasResponse() {
                if (this.response_ != null) {
                    return true;
                }
                return false;
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                switch (AnonymousClass1.f26254a[methodToInvoke.ordinal()]) {
                    case 1:
                        return new BeginTransaction();
                    case 2:
                        return new Builder(null);
                    case 3:
                        return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\t", new Object[]{"request_", "response_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<BeginTransaction> parser = PARSER;
                        if (parser == null) {
                            synchronized (BeginTransaction.class) {
                                parser = PARSER;
                                if (parser == null) {
                                    parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                    PARSER = parser;
                                }
                            }
                        }
                        return parser;
                    case 6:
                        return (byte) 1;
                    case 7:
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            public static Builder newBuilder(BeginTransaction beginTransaction) {
                return DEFAULT_INSTANCE.r(beginTransaction);
            }

            public static BeginTransaction parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (BeginTransaction) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static BeginTransaction parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (BeginTransaction) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static BeginTransaction parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (BeginTransaction) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
            }

            public static BeginTransaction parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (BeginTransaction) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static BeginTransaction parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (BeginTransaction) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
            }

            public static BeginTransaction parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (BeginTransaction) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static BeginTransaction parseFrom(InputStream inputStream) throws IOException {
                return (BeginTransaction) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
            }

            public static BeginTransaction parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (BeginTransaction) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static BeginTransaction parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (BeginTransaction) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
            }

            public static BeginTransaction parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (BeginTransaction) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }
        }

        /* loaded from: classes5.dex */
        public interface BeginTransactionOrBuilder extends MessageLiteOrBuilder {
            BeginTransactionRequest getRequest();

            BeginTransactionResponse getResponse();

            boolean hasRequest();

            boolean hasResponse();
        }

        /* loaded from: classes5.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<FirestoreV1Action, Builder> implements FirestoreV1ActionOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder addAllMatchingDocuments(Iterable<? extends MatchingDocuments> iterable) {
                f();
                ((FirestoreV1Action) this.f33398b).g1(iterable);
                return this;
            }

            public Builder addMatchingDocuments(MatchingDocuments matchingDocuments) {
                f();
                ((FirestoreV1Action) this.f33398b).i1(matchingDocuments);
                return this;
            }

            public Builder clearAction() {
                f();
                ((FirestoreV1Action) this.f33398b).j1();
                return this;
            }

            public Builder clearBatchGetDocuments() {
                f();
                ((FirestoreV1Action) this.f33398b).k1();
                return this;
            }

            public Builder clearBeginTransaction() {
                f();
                ((FirestoreV1Action) this.f33398b).l1();
                return this;
            }

            public Builder clearCommit() {
                f();
                ((FirestoreV1Action) this.f33398b).m1();
                return this;
            }

            public Builder clearCreateDocument() {
                f();
                ((FirestoreV1Action) this.f33398b).n1();
                return this;
            }

            public Builder clearDatabaseContentsBeforeAction() {
                f();
                ((FirestoreV1Action) this.f33398b).o1();
                return this;
            }

            public Builder clearDeleteDocument() {
                f();
                ((FirestoreV1Action) this.f33398b).p1();
                return this;
            }

            public Builder clearGetDocument() {
                f();
                ((FirestoreV1Action) this.f33398b).q1();
                return this;
            }

            public Builder clearListCollectionIds() {
                f();
                ((FirestoreV1Action) this.f33398b).r1();
                return this;
            }

            public Builder clearListDocuments() {
                f();
                ((FirestoreV1Action) this.f33398b).s1();
                return this;
            }

            public Builder clearListen() {
                f();
                ((FirestoreV1Action) this.f33398b).t1();
                return this;
            }

            public Builder clearMatchingDocuments() {
                f();
                ((FirestoreV1Action) this.f33398b).u1();
                return this;
            }

            public Builder clearRemoveListen() {
                f();
                ((FirestoreV1Action) this.f33398b).v1();
                return this;
            }

            public Builder clearRollback() {
                f();
                ((FirestoreV1Action) this.f33398b).w1();
                return this;
            }

            public Builder clearRunQuery() {
                f();
                ((FirestoreV1Action) this.f33398b).x1();
                return this;
            }

            public Builder clearStatus() {
                f();
                ((FirestoreV1Action) this.f33398b).y1();
                return this;
            }

            public Builder clearUpdateDocument() {
                f();
                ((FirestoreV1Action) this.f33398b).z1();
                return this;
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1ActionOrBuilder
            public ActionCase getActionCase() {
                return ((FirestoreV1Action) this.f33398b).getActionCase();
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1ActionOrBuilder
            public BatchGetDocuments getBatchGetDocuments() {
                return ((FirestoreV1Action) this.f33398b).getBatchGetDocuments();
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1ActionOrBuilder
            public BeginTransaction getBeginTransaction() {
                return ((FirestoreV1Action) this.f33398b).getBeginTransaction();
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1ActionOrBuilder
            public Commit getCommit() {
                return ((FirestoreV1Action) this.f33398b).getCommit();
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1ActionOrBuilder
            public CreateDocument getCreateDocument() {
                return ((FirestoreV1Action) this.f33398b).getCreateDocument();
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1ActionOrBuilder
            public RunQuery getDatabaseContentsBeforeAction() {
                return ((FirestoreV1Action) this.f33398b).getDatabaseContentsBeforeAction();
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1ActionOrBuilder
            public DeleteDocument getDeleteDocument() {
                return ((FirestoreV1Action) this.f33398b).getDeleteDocument();
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1ActionOrBuilder
            public GetDocument getGetDocument() {
                return ((FirestoreV1Action) this.f33398b).getGetDocument();
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1ActionOrBuilder
            public ListCollectionIds getListCollectionIds() {
                return ((FirestoreV1Action) this.f33398b).getListCollectionIds();
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1ActionOrBuilder
            public ListDocuments getListDocuments() {
                return ((FirestoreV1Action) this.f33398b).getListDocuments();
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1ActionOrBuilder
            public Listen getListen() {
                return ((FirestoreV1Action) this.f33398b).getListen();
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1ActionOrBuilder
            public MatchingDocuments getMatchingDocuments(int i4) {
                return ((FirestoreV1Action) this.f33398b).getMatchingDocuments(i4);
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1ActionOrBuilder
            public int getMatchingDocumentsCount() {
                return ((FirestoreV1Action) this.f33398b).getMatchingDocumentsCount();
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1ActionOrBuilder
            public List<MatchingDocuments> getMatchingDocumentsList() {
                return Collections.unmodifiableList(((FirestoreV1Action) this.f33398b).getMatchingDocumentsList());
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1ActionOrBuilder
            public RemoveListen getRemoveListen() {
                return ((FirestoreV1Action) this.f33398b).getRemoveListen();
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1ActionOrBuilder
            public Rollback getRollback() {
                return ((FirestoreV1Action) this.f33398b).getRollback();
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1ActionOrBuilder
            public RunQuery getRunQuery() {
                return ((FirestoreV1Action) this.f33398b).getRunQuery();
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1ActionOrBuilder
            public StatusProto getStatus() {
                return ((FirestoreV1Action) this.f33398b).getStatus();
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1ActionOrBuilder
            public UpdateDocument getUpdateDocument() {
                return ((FirestoreV1Action) this.f33398b).getUpdateDocument();
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1ActionOrBuilder
            public boolean hasBatchGetDocuments() {
                return ((FirestoreV1Action) this.f33398b).hasBatchGetDocuments();
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1ActionOrBuilder
            public boolean hasBeginTransaction() {
                return ((FirestoreV1Action) this.f33398b).hasBeginTransaction();
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1ActionOrBuilder
            public boolean hasCommit() {
                return ((FirestoreV1Action) this.f33398b).hasCommit();
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1ActionOrBuilder
            public boolean hasCreateDocument() {
                return ((FirestoreV1Action) this.f33398b).hasCreateDocument();
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1ActionOrBuilder
            public boolean hasDatabaseContentsBeforeAction() {
                return ((FirestoreV1Action) this.f33398b).hasDatabaseContentsBeforeAction();
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1ActionOrBuilder
            public boolean hasDeleteDocument() {
                return ((FirestoreV1Action) this.f33398b).hasDeleteDocument();
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1ActionOrBuilder
            public boolean hasGetDocument() {
                return ((FirestoreV1Action) this.f33398b).hasGetDocument();
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1ActionOrBuilder
            public boolean hasListCollectionIds() {
                return ((FirestoreV1Action) this.f33398b).hasListCollectionIds();
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1ActionOrBuilder
            public boolean hasListDocuments() {
                return ((FirestoreV1Action) this.f33398b).hasListDocuments();
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1ActionOrBuilder
            public boolean hasListen() {
                return ((FirestoreV1Action) this.f33398b).hasListen();
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1ActionOrBuilder
            public boolean hasRemoveListen() {
                return ((FirestoreV1Action) this.f33398b).hasRemoveListen();
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1ActionOrBuilder
            public boolean hasRollback() {
                return ((FirestoreV1Action) this.f33398b).hasRollback();
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1ActionOrBuilder
            public boolean hasRunQuery() {
                return ((FirestoreV1Action) this.f33398b).hasRunQuery();
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1ActionOrBuilder
            public boolean hasStatus() {
                return ((FirestoreV1Action) this.f33398b).hasStatus();
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1ActionOrBuilder
            public boolean hasUpdateDocument() {
                return ((FirestoreV1Action) this.f33398b).hasUpdateDocument();
            }

            public Builder mergeBatchGetDocuments(BatchGetDocuments batchGetDocuments) {
                f();
                ((FirestoreV1Action) this.f33398b).B1(batchGetDocuments);
                return this;
            }

            public Builder mergeBeginTransaction(BeginTransaction beginTransaction) {
                f();
                ((FirestoreV1Action) this.f33398b).C1(beginTransaction);
                return this;
            }

            public Builder mergeCommit(Commit commit) {
                f();
                ((FirestoreV1Action) this.f33398b).D1(commit);
                return this;
            }

            public Builder mergeCreateDocument(CreateDocument createDocument) {
                f();
                ((FirestoreV1Action) this.f33398b).E1(createDocument);
                return this;
            }

            public Builder mergeDatabaseContentsBeforeAction(RunQuery runQuery) {
                f();
                ((FirestoreV1Action) this.f33398b).F1(runQuery);
                return this;
            }

            public Builder mergeDeleteDocument(DeleteDocument deleteDocument) {
                f();
                ((FirestoreV1Action) this.f33398b).G1(deleteDocument);
                return this;
            }

            public Builder mergeGetDocument(GetDocument getDocument) {
                f();
                ((FirestoreV1Action) this.f33398b).H1(getDocument);
                return this;
            }

            public Builder mergeListCollectionIds(ListCollectionIds listCollectionIds) {
                f();
                ((FirestoreV1Action) this.f33398b).I1(listCollectionIds);
                return this;
            }

            public Builder mergeListDocuments(ListDocuments listDocuments) {
                f();
                ((FirestoreV1Action) this.f33398b).J1(listDocuments);
                return this;
            }

            public Builder mergeListen(Listen listen) {
                f();
                ((FirestoreV1Action) this.f33398b).K1(listen);
                return this;
            }

            public Builder mergeRemoveListen(RemoveListen removeListen) {
                f();
                ((FirestoreV1Action) this.f33398b).L1(removeListen);
                return this;
            }

            public Builder mergeRollback(Rollback rollback) {
                f();
                ((FirestoreV1Action) this.f33398b).M1(rollback);
                return this;
            }

            public Builder mergeRunQuery(RunQuery runQuery) {
                f();
                ((FirestoreV1Action) this.f33398b).N1(runQuery);
                return this;
            }

            public Builder mergeStatus(StatusProto statusProto) {
                f();
                ((FirestoreV1Action) this.f33398b).O1(statusProto);
                return this;
            }

            public Builder mergeUpdateDocument(UpdateDocument updateDocument) {
                f();
                ((FirestoreV1Action) this.f33398b).P1(updateDocument);
                return this;
            }

            public Builder removeMatchingDocuments(int i4) {
                f();
                ((FirestoreV1Action) this.f33398b).Q1(i4);
                return this;
            }

            public Builder setBatchGetDocuments(BatchGetDocuments batchGetDocuments) {
                f();
                ((FirestoreV1Action) this.f33398b).R1(batchGetDocuments);
                return this;
            }

            public Builder setBeginTransaction(BeginTransaction beginTransaction) {
                f();
                ((FirestoreV1Action) this.f33398b).S1(beginTransaction);
                return this;
            }

            public Builder setCommit(Commit commit) {
                f();
                ((FirestoreV1Action) this.f33398b).T1(commit);
                return this;
            }

            public Builder setCreateDocument(CreateDocument createDocument) {
                f();
                ((FirestoreV1Action) this.f33398b).U1(createDocument);
                return this;
            }

            public Builder setDatabaseContentsBeforeAction(RunQuery runQuery) {
                f();
                ((FirestoreV1Action) this.f33398b).V1(runQuery);
                return this;
            }

            public Builder setDeleteDocument(DeleteDocument deleteDocument) {
                f();
                ((FirestoreV1Action) this.f33398b).W1(deleteDocument);
                return this;
            }

            public Builder setGetDocument(GetDocument getDocument) {
                f();
                ((FirestoreV1Action) this.f33398b).X1(getDocument);
                return this;
            }

            public Builder setListCollectionIds(ListCollectionIds listCollectionIds) {
                f();
                ((FirestoreV1Action) this.f33398b).Y1(listCollectionIds);
                return this;
            }

            public Builder setListDocuments(ListDocuments listDocuments) {
                f();
                ((FirestoreV1Action) this.f33398b).Z1(listDocuments);
                return this;
            }

            public Builder setListen(Listen listen) {
                f();
                ((FirestoreV1Action) this.f33398b).a2(listen);
                return this;
            }

            public Builder setMatchingDocuments(int i4, MatchingDocuments matchingDocuments) {
                f();
                ((FirestoreV1Action) this.f33398b).b2(i4, matchingDocuments);
                return this;
            }

            public Builder setRemoveListen(RemoveListen removeListen) {
                f();
                ((FirestoreV1Action) this.f33398b).c2(removeListen);
                return this;
            }

            public Builder setRollback(Rollback rollback) {
                f();
                ((FirestoreV1Action) this.f33398b).d2(rollback);
                return this;
            }

            public Builder setRunQuery(RunQuery runQuery) {
                f();
                ((FirestoreV1Action) this.f33398b).e2(runQuery);
                return this;
            }

            public Builder setStatus(StatusProto statusProto) {
                f();
                ((FirestoreV1Action) this.f33398b).f2(statusProto);
                return this;
            }

            public Builder setUpdateDocument(UpdateDocument updateDocument) {
                f();
                ((FirestoreV1Action) this.f33398b).g2(updateDocument);
                return this;
            }

            private Builder() {
                super(FirestoreV1Action.DEFAULT_INSTANCE);
            }

            public Builder addMatchingDocuments(int i4, MatchingDocuments matchingDocuments) {
                f();
                ((FirestoreV1Action) this.f33398b).h1(i4, matchingDocuments);
                return this;
            }

            public Builder setBatchGetDocuments(BatchGetDocuments.Builder builder) {
                f();
                ((FirestoreV1Action) this.f33398b).R1(builder.build());
                return this;
            }

            public Builder setBeginTransaction(BeginTransaction.Builder builder) {
                f();
                ((FirestoreV1Action) this.f33398b).S1(builder.build());
                return this;
            }

            public Builder setCommit(Commit.Builder builder) {
                f();
                ((FirestoreV1Action) this.f33398b).T1(builder.build());
                return this;
            }

            public Builder setCreateDocument(CreateDocument.Builder builder) {
                f();
                ((FirestoreV1Action) this.f33398b).U1(builder.build());
                return this;
            }

            public Builder setDatabaseContentsBeforeAction(RunQuery.Builder builder) {
                f();
                ((FirestoreV1Action) this.f33398b).V1(builder.build());
                return this;
            }

            public Builder setDeleteDocument(DeleteDocument.Builder builder) {
                f();
                ((FirestoreV1Action) this.f33398b).W1(builder.build());
                return this;
            }

            public Builder setGetDocument(GetDocument.Builder builder) {
                f();
                ((FirestoreV1Action) this.f33398b).X1(builder.build());
                return this;
            }

            public Builder setListCollectionIds(ListCollectionIds.Builder builder) {
                f();
                ((FirestoreV1Action) this.f33398b).Y1(builder.build());
                return this;
            }

            public Builder setListDocuments(ListDocuments.Builder builder) {
                f();
                ((FirestoreV1Action) this.f33398b).Z1(builder.build());
                return this;
            }

            public Builder setListen(Listen.Builder builder) {
                f();
                ((FirestoreV1Action) this.f33398b).a2(builder.build());
                return this;
            }

            public Builder setMatchingDocuments(int i4, MatchingDocuments.Builder builder) {
                f();
                ((FirestoreV1Action) this.f33398b).b2(i4, builder.build());
                return this;
            }

            public Builder setRemoveListen(RemoveListen.Builder builder) {
                f();
                ((FirestoreV1Action) this.f33398b).c2(builder.build());
                return this;
            }

            public Builder setRollback(Rollback.Builder builder) {
                f();
                ((FirestoreV1Action) this.f33398b).d2(builder.build());
                return this;
            }

            public Builder setRunQuery(RunQuery.Builder builder) {
                f();
                ((FirestoreV1Action) this.f33398b).e2(builder.build());
                return this;
            }

            public Builder setStatus(StatusProto.Builder builder) {
                f();
                ((FirestoreV1Action) this.f33398b).f2(builder.build());
                return this;
            }

            public Builder setUpdateDocument(UpdateDocument.Builder builder) {
                f();
                ((FirestoreV1Action) this.f33398b).g2(builder.build());
                return this;
            }

            public Builder addMatchingDocuments(MatchingDocuments.Builder builder) {
                f();
                ((FirestoreV1Action) this.f33398b).i1(builder.build());
                return this;
            }

            public Builder addMatchingDocuments(int i4, MatchingDocuments.Builder builder) {
                f();
                ((FirestoreV1Action) this.f33398b).h1(i4, builder.build());
                return this;
            }
        }

        /* loaded from: classes5.dex */
        public static final class Commit extends GeneratedMessageLite<Commit, Builder> implements CommitOrBuilder {
            private static final Commit DEFAULT_INSTANCE;
            private static volatile Parser<Commit> PARSER = null;
            public static final int REQUEST_FIELD_NUMBER = 1;
            public static final int RESPONSE_FIELD_NUMBER = 2;
            private CommitRequest request_;
            private CommitResponse response_;

            /* loaded from: classes5.dex */
            public static final class Builder extends GeneratedMessageLite.Builder<Commit, Builder> implements CommitOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                public Builder clearRequest() {
                    f();
                    ((Commit) this.f33398b).m0();
                    return this;
                }

                public Builder clearResponse() {
                    f();
                    ((Commit) this.f33398b).n0();
                    return this;
                }

                @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.CommitOrBuilder
                public CommitRequest getRequest() {
                    return ((Commit) this.f33398b).getRequest();
                }

                @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.CommitOrBuilder
                public CommitResponse getResponse() {
                    return ((Commit) this.f33398b).getResponse();
                }

                @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.CommitOrBuilder
                public boolean hasRequest() {
                    return ((Commit) this.f33398b).hasRequest();
                }

                @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.CommitOrBuilder
                public boolean hasResponse() {
                    return ((Commit) this.f33398b).hasResponse();
                }

                public Builder mergeRequest(CommitRequest commitRequest) {
                    f();
                    ((Commit) this.f33398b).o0(commitRequest);
                    return this;
                }

                public Builder mergeResponse(CommitResponse commitResponse) {
                    f();
                    ((Commit) this.f33398b).p0(commitResponse);
                    return this;
                }

                public Builder setRequest(CommitRequest commitRequest) {
                    f();
                    ((Commit) this.f33398b).q0(commitRequest);
                    return this;
                }

                public Builder setResponse(CommitResponse commitResponse) {
                    f();
                    ((Commit) this.f33398b).r0(commitResponse);
                    return this;
                }

                private Builder() {
                    super(Commit.DEFAULT_INSTANCE);
                }

                public Builder setRequest(CommitRequest.Builder builder) {
                    f();
                    ((Commit) this.f33398b).q0(builder.build());
                    return this;
                }

                public Builder setResponse(CommitResponse.Builder builder) {
                    f();
                    ((Commit) this.f33398b).r0(builder.build());
                    return this;
                }
            }

            static {
                Commit commit = new Commit();
                DEFAULT_INSTANCE = commit;
                GeneratedMessageLite.d0(Commit.class, commit);
            }

            private Commit() {
            }

            public static Commit getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void m0() {
                this.request_ = null;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void n0() {
                this.response_ = null;
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.q();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void o0(CommitRequest commitRequest) {
                commitRequest.getClass();
                CommitRequest commitRequest2 = this.request_;
                if (commitRequest2 != null && commitRequest2 != CommitRequest.getDefaultInstance()) {
                    this.request_ = CommitRequest.newBuilder(this.request_).mergeFrom((CommitRequest.Builder) commitRequest).buildPartial();
                } else {
                    this.request_ = commitRequest;
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void p0(CommitResponse commitResponse) {
                commitResponse.getClass();
                CommitResponse commitResponse2 = this.response_;
                if (commitResponse2 != null && commitResponse2 != CommitResponse.getDefaultInstance()) {
                    this.response_ = CommitResponse.newBuilder(this.response_).mergeFrom((CommitResponse.Builder) commitResponse).buildPartial();
                } else {
                    this.response_ = commitResponse;
                }
            }

            public static Commit parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (Commit) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
            }

            public static Commit parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return (Commit) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
            }

            public static Parser<Commit> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void q0(CommitRequest commitRequest) {
                commitRequest.getClass();
                this.request_ = commitRequest;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void r0(CommitResponse commitResponse) {
                commitResponse.getClass();
                this.response_ = commitResponse;
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.CommitOrBuilder
            public CommitRequest getRequest() {
                CommitRequest commitRequest = this.request_;
                if (commitRequest == null) {
                    return CommitRequest.getDefaultInstance();
                }
                return commitRequest;
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.CommitOrBuilder
            public CommitResponse getResponse() {
                CommitResponse commitResponse = this.response_;
                if (commitResponse == null) {
                    return CommitResponse.getDefaultInstance();
                }
                return commitResponse;
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.CommitOrBuilder
            public boolean hasRequest() {
                if (this.request_ != null) {
                    return true;
                }
                return false;
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.CommitOrBuilder
            public boolean hasResponse() {
                if (this.response_ != null) {
                    return true;
                }
                return false;
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                switch (AnonymousClass1.f26254a[methodToInvoke.ordinal()]) {
                    case 1:
                        return new Commit();
                    case 2:
                        return new Builder(null);
                    case 3:
                        return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\t", new Object[]{"request_", "response_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<Commit> parser = PARSER;
                        if (parser == null) {
                            synchronized (Commit.class) {
                                parser = PARSER;
                                if (parser == null) {
                                    parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                    PARSER = parser;
                                }
                            }
                        }
                        return parser;
                    case 6:
                        return (byte) 1;
                    case 7:
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            public static Builder newBuilder(Commit commit) {
                return DEFAULT_INSTANCE.r(commit);
            }

            public static Commit parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Commit) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Commit parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (Commit) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static Commit parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (Commit) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
            }

            public static Commit parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (Commit) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static Commit parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (Commit) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
            }

            public static Commit parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (Commit) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static Commit parseFrom(InputStream inputStream) throws IOException {
                return (Commit) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
            }

            public static Commit parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Commit) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Commit parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (Commit) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
            }

            public static Commit parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Commit) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }
        }

        /* loaded from: classes5.dex */
        public interface CommitOrBuilder extends MessageLiteOrBuilder {
            CommitRequest getRequest();

            CommitResponse getResponse();

            boolean hasRequest();

            boolean hasResponse();
        }

        /* loaded from: classes5.dex */
        public static final class CreateDocument extends GeneratedMessageLite<CreateDocument, Builder> implements CreateDocumentOrBuilder {
            private static final CreateDocument DEFAULT_INSTANCE;
            private static volatile Parser<CreateDocument> PARSER = null;
            public static final int REQUEST_FIELD_NUMBER = 1;
            public static final int RESPONSE_FIELD_NUMBER = 2;
            private CreateDocumentRequest request_;
            private Document response_;

            /* loaded from: classes5.dex */
            public static final class Builder extends GeneratedMessageLite.Builder<CreateDocument, Builder> implements CreateDocumentOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                public Builder clearRequest() {
                    f();
                    ((CreateDocument) this.f33398b).m0();
                    return this;
                }

                public Builder clearResponse() {
                    f();
                    ((CreateDocument) this.f33398b).n0();
                    return this;
                }

                @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.CreateDocumentOrBuilder
                public CreateDocumentRequest getRequest() {
                    return ((CreateDocument) this.f33398b).getRequest();
                }

                @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.CreateDocumentOrBuilder
                public Document getResponse() {
                    return ((CreateDocument) this.f33398b).getResponse();
                }

                @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.CreateDocumentOrBuilder
                public boolean hasRequest() {
                    return ((CreateDocument) this.f33398b).hasRequest();
                }

                @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.CreateDocumentOrBuilder
                public boolean hasResponse() {
                    return ((CreateDocument) this.f33398b).hasResponse();
                }

                public Builder mergeRequest(CreateDocumentRequest createDocumentRequest) {
                    f();
                    ((CreateDocument) this.f33398b).o0(createDocumentRequest);
                    return this;
                }

                public Builder mergeResponse(Document document) {
                    f();
                    ((CreateDocument) this.f33398b).p0(document);
                    return this;
                }

                public Builder setRequest(CreateDocumentRequest createDocumentRequest) {
                    f();
                    ((CreateDocument) this.f33398b).q0(createDocumentRequest);
                    return this;
                }

                public Builder setResponse(Document document) {
                    f();
                    ((CreateDocument) this.f33398b).r0(document);
                    return this;
                }

                private Builder() {
                    super(CreateDocument.DEFAULT_INSTANCE);
                }

                public Builder setRequest(CreateDocumentRequest.Builder builder) {
                    f();
                    ((CreateDocument) this.f33398b).q0(builder.build());
                    return this;
                }

                public Builder setResponse(Document.Builder builder) {
                    f();
                    ((CreateDocument) this.f33398b).r0(builder.build());
                    return this;
                }
            }

            static {
                CreateDocument createDocument = new CreateDocument();
                DEFAULT_INSTANCE = createDocument;
                GeneratedMessageLite.d0(CreateDocument.class, createDocument);
            }

            private CreateDocument() {
            }

            public static CreateDocument getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void m0() {
                this.request_ = null;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void n0() {
                this.response_ = null;
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.q();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void o0(CreateDocumentRequest createDocumentRequest) {
                createDocumentRequest.getClass();
                CreateDocumentRequest createDocumentRequest2 = this.request_;
                if (createDocumentRequest2 != null && createDocumentRequest2 != CreateDocumentRequest.getDefaultInstance()) {
                    this.request_ = CreateDocumentRequest.newBuilder(this.request_).mergeFrom((CreateDocumentRequest.Builder) createDocumentRequest).buildPartial();
                } else {
                    this.request_ = createDocumentRequest;
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void p0(Document document) {
                document.getClass();
                Document document2 = this.response_;
                if (document2 != null && document2 != Document.getDefaultInstance()) {
                    this.response_ = Document.newBuilder(this.response_).mergeFrom((Document.Builder) document).buildPartial();
                } else {
                    this.response_ = document;
                }
            }

            public static CreateDocument parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (CreateDocument) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
            }

            public static CreateDocument parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return (CreateDocument) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
            }

            public static Parser<CreateDocument> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void q0(CreateDocumentRequest createDocumentRequest) {
                createDocumentRequest.getClass();
                this.request_ = createDocumentRequest;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void r0(Document document) {
                document.getClass();
                this.response_ = document;
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.CreateDocumentOrBuilder
            public CreateDocumentRequest getRequest() {
                CreateDocumentRequest createDocumentRequest = this.request_;
                if (createDocumentRequest == null) {
                    return CreateDocumentRequest.getDefaultInstance();
                }
                return createDocumentRequest;
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.CreateDocumentOrBuilder
            public Document getResponse() {
                Document document = this.response_;
                if (document == null) {
                    return Document.getDefaultInstance();
                }
                return document;
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.CreateDocumentOrBuilder
            public boolean hasRequest() {
                if (this.request_ != null) {
                    return true;
                }
                return false;
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.CreateDocumentOrBuilder
            public boolean hasResponse() {
                if (this.response_ != null) {
                    return true;
                }
                return false;
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                switch (AnonymousClass1.f26254a[methodToInvoke.ordinal()]) {
                    case 1:
                        return new CreateDocument();
                    case 2:
                        return new Builder(null);
                    case 3:
                        return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\t", new Object[]{"request_", "response_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<CreateDocument> parser = PARSER;
                        if (parser == null) {
                            synchronized (CreateDocument.class) {
                                parser = PARSER;
                                if (parser == null) {
                                    parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                    PARSER = parser;
                                }
                            }
                        }
                        return parser;
                    case 6:
                        return (byte) 1;
                    case 7:
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            public static Builder newBuilder(CreateDocument createDocument) {
                return DEFAULT_INSTANCE.r(createDocument);
            }

            public static CreateDocument parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (CreateDocument) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static CreateDocument parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (CreateDocument) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static CreateDocument parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (CreateDocument) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
            }

            public static CreateDocument parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (CreateDocument) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static CreateDocument parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (CreateDocument) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
            }

            public static CreateDocument parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (CreateDocument) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static CreateDocument parseFrom(InputStream inputStream) throws IOException {
                return (CreateDocument) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
            }

            public static CreateDocument parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (CreateDocument) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static CreateDocument parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (CreateDocument) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
            }

            public static CreateDocument parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (CreateDocument) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }
        }

        /* loaded from: classes5.dex */
        public interface CreateDocumentOrBuilder extends MessageLiteOrBuilder {
            CreateDocumentRequest getRequest();

            Document getResponse();

            boolean hasRequest();

            boolean hasResponse();
        }

        /* loaded from: classes5.dex */
        public static final class DeleteDocument extends GeneratedMessageLite<DeleteDocument, Builder> implements DeleteDocumentOrBuilder {
            private static final DeleteDocument DEFAULT_INSTANCE;
            private static volatile Parser<DeleteDocument> PARSER = null;
            public static final int REQUEST_FIELD_NUMBER = 1;
            public static final int RESPONSE_FIELD_NUMBER = 2;
            private DeleteDocumentRequest request_;
            private Empty response_;

            /* loaded from: classes5.dex */
            public static final class Builder extends GeneratedMessageLite.Builder<DeleteDocument, Builder> implements DeleteDocumentOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                public Builder clearRequest() {
                    f();
                    ((DeleteDocument) this.f33398b).m0();
                    return this;
                }

                public Builder clearResponse() {
                    f();
                    ((DeleteDocument) this.f33398b).n0();
                    return this;
                }

                @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.DeleteDocumentOrBuilder
                public DeleteDocumentRequest getRequest() {
                    return ((DeleteDocument) this.f33398b).getRequest();
                }

                @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.DeleteDocumentOrBuilder
                public Empty getResponse() {
                    return ((DeleteDocument) this.f33398b).getResponse();
                }

                @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.DeleteDocumentOrBuilder
                public boolean hasRequest() {
                    return ((DeleteDocument) this.f33398b).hasRequest();
                }

                @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.DeleteDocumentOrBuilder
                public boolean hasResponse() {
                    return ((DeleteDocument) this.f33398b).hasResponse();
                }

                public Builder mergeRequest(DeleteDocumentRequest deleteDocumentRequest) {
                    f();
                    ((DeleteDocument) this.f33398b).o0(deleteDocumentRequest);
                    return this;
                }

                public Builder mergeResponse(Empty empty) {
                    f();
                    ((DeleteDocument) this.f33398b).p0(empty);
                    return this;
                }

                public Builder setRequest(DeleteDocumentRequest deleteDocumentRequest) {
                    f();
                    ((DeleteDocument) this.f33398b).q0(deleteDocumentRequest);
                    return this;
                }

                public Builder setResponse(Empty empty) {
                    f();
                    ((DeleteDocument) this.f33398b).r0(empty);
                    return this;
                }

                private Builder() {
                    super(DeleteDocument.DEFAULT_INSTANCE);
                }

                public Builder setRequest(DeleteDocumentRequest.Builder builder) {
                    f();
                    ((DeleteDocument) this.f33398b).q0(builder.build());
                    return this;
                }

                public Builder setResponse(Empty.Builder builder) {
                    f();
                    ((DeleteDocument) this.f33398b).r0(builder.build());
                    return this;
                }
            }

            static {
                DeleteDocument deleteDocument = new DeleteDocument();
                DEFAULT_INSTANCE = deleteDocument;
                GeneratedMessageLite.d0(DeleteDocument.class, deleteDocument);
            }

            private DeleteDocument() {
            }

            public static DeleteDocument getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void m0() {
                this.request_ = null;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void n0() {
                this.response_ = null;
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.q();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void o0(DeleteDocumentRequest deleteDocumentRequest) {
                deleteDocumentRequest.getClass();
                DeleteDocumentRequest deleteDocumentRequest2 = this.request_;
                if (deleteDocumentRequest2 != null && deleteDocumentRequest2 != DeleteDocumentRequest.getDefaultInstance()) {
                    this.request_ = DeleteDocumentRequest.newBuilder(this.request_).mergeFrom((DeleteDocumentRequest.Builder) deleteDocumentRequest).buildPartial();
                } else {
                    this.request_ = deleteDocumentRequest;
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void p0(Empty empty) {
                empty.getClass();
                Empty empty2 = this.response_;
                if (empty2 != null && empty2 != Empty.getDefaultInstance()) {
                    this.response_ = Empty.newBuilder(this.response_).mergeFrom((Empty.Builder) empty).buildPartial();
                } else {
                    this.response_ = empty;
                }
            }

            public static DeleteDocument parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (DeleteDocument) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
            }

            public static DeleteDocument parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return (DeleteDocument) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
            }

            public static Parser<DeleteDocument> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void q0(DeleteDocumentRequest deleteDocumentRequest) {
                deleteDocumentRequest.getClass();
                this.request_ = deleteDocumentRequest;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void r0(Empty empty) {
                empty.getClass();
                this.response_ = empty;
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.DeleteDocumentOrBuilder
            public DeleteDocumentRequest getRequest() {
                DeleteDocumentRequest deleteDocumentRequest = this.request_;
                if (deleteDocumentRequest == null) {
                    return DeleteDocumentRequest.getDefaultInstance();
                }
                return deleteDocumentRequest;
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.DeleteDocumentOrBuilder
            public Empty getResponse() {
                Empty empty = this.response_;
                if (empty == null) {
                    return Empty.getDefaultInstance();
                }
                return empty;
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.DeleteDocumentOrBuilder
            public boolean hasRequest() {
                if (this.request_ != null) {
                    return true;
                }
                return false;
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.DeleteDocumentOrBuilder
            public boolean hasResponse() {
                if (this.response_ != null) {
                    return true;
                }
                return false;
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                switch (AnonymousClass1.f26254a[methodToInvoke.ordinal()]) {
                    case 1:
                        return new DeleteDocument();
                    case 2:
                        return new Builder(null);
                    case 3:
                        return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\t", new Object[]{"request_", "response_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<DeleteDocument> parser = PARSER;
                        if (parser == null) {
                            synchronized (DeleteDocument.class) {
                                parser = PARSER;
                                if (parser == null) {
                                    parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                    PARSER = parser;
                                }
                            }
                        }
                        return parser;
                    case 6:
                        return (byte) 1;
                    case 7:
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            public static Builder newBuilder(DeleteDocument deleteDocument) {
                return DEFAULT_INSTANCE.r(deleteDocument);
            }

            public static DeleteDocument parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (DeleteDocument) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static DeleteDocument parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (DeleteDocument) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static DeleteDocument parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (DeleteDocument) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
            }

            public static DeleteDocument parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (DeleteDocument) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static DeleteDocument parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (DeleteDocument) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
            }

            public static DeleteDocument parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (DeleteDocument) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static DeleteDocument parseFrom(InputStream inputStream) throws IOException {
                return (DeleteDocument) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
            }

            public static DeleteDocument parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (DeleteDocument) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static DeleteDocument parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (DeleteDocument) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
            }

            public static DeleteDocument parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (DeleteDocument) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }
        }

        /* loaded from: classes5.dex */
        public interface DeleteDocumentOrBuilder extends MessageLiteOrBuilder {
            DeleteDocumentRequest getRequest();

            Empty getResponse();

            boolean hasRequest();

            boolean hasResponse();
        }

        /* loaded from: classes5.dex */
        public static final class GetDocument extends GeneratedMessageLite<GetDocument, Builder> implements GetDocumentOrBuilder {
            private static final GetDocument DEFAULT_INSTANCE;
            private static volatile Parser<GetDocument> PARSER = null;
            public static final int REQUEST_FIELD_NUMBER = 1;
            public static final int RESPONSE_FIELD_NUMBER = 2;
            private GetDocumentRequest request_;
            private Document response_;

            /* loaded from: classes5.dex */
            public static final class Builder extends GeneratedMessageLite.Builder<GetDocument, Builder> implements GetDocumentOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                public Builder clearRequest() {
                    f();
                    ((GetDocument) this.f33398b).m0();
                    return this;
                }

                public Builder clearResponse() {
                    f();
                    ((GetDocument) this.f33398b).n0();
                    return this;
                }

                @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.GetDocumentOrBuilder
                public GetDocumentRequest getRequest() {
                    return ((GetDocument) this.f33398b).getRequest();
                }

                @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.GetDocumentOrBuilder
                public Document getResponse() {
                    return ((GetDocument) this.f33398b).getResponse();
                }

                @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.GetDocumentOrBuilder
                public boolean hasRequest() {
                    return ((GetDocument) this.f33398b).hasRequest();
                }

                @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.GetDocumentOrBuilder
                public boolean hasResponse() {
                    return ((GetDocument) this.f33398b).hasResponse();
                }

                public Builder mergeRequest(GetDocumentRequest getDocumentRequest) {
                    f();
                    ((GetDocument) this.f33398b).o0(getDocumentRequest);
                    return this;
                }

                public Builder mergeResponse(Document document) {
                    f();
                    ((GetDocument) this.f33398b).p0(document);
                    return this;
                }

                public Builder setRequest(GetDocumentRequest getDocumentRequest) {
                    f();
                    ((GetDocument) this.f33398b).q0(getDocumentRequest);
                    return this;
                }

                public Builder setResponse(Document document) {
                    f();
                    ((GetDocument) this.f33398b).r0(document);
                    return this;
                }

                private Builder() {
                    super(GetDocument.DEFAULT_INSTANCE);
                }

                public Builder setRequest(GetDocumentRequest.Builder builder) {
                    f();
                    ((GetDocument) this.f33398b).q0(builder.build());
                    return this;
                }

                public Builder setResponse(Document.Builder builder) {
                    f();
                    ((GetDocument) this.f33398b).r0(builder.build());
                    return this;
                }
            }

            static {
                GetDocument getDocument = new GetDocument();
                DEFAULT_INSTANCE = getDocument;
                GeneratedMessageLite.d0(GetDocument.class, getDocument);
            }

            private GetDocument() {
            }

            public static GetDocument getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void m0() {
                this.request_ = null;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void n0() {
                this.response_ = null;
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.q();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void o0(GetDocumentRequest getDocumentRequest) {
                getDocumentRequest.getClass();
                GetDocumentRequest getDocumentRequest2 = this.request_;
                if (getDocumentRequest2 != null && getDocumentRequest2 != GetDocumentRequest.getDefaultInstance()) {
                    this.request_ = GetDocumentRequest.newBuilder(this.request_).mergeFrom((GetDocumentRequest.Builder) getDocumentRequest).buildPartial();
                } else {
                    this.request_ = getDocumentRequest;
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void p0(Document document) {
                document.getClass();
                Document document2 = this.response_;
                if (document2 != null && document2 != Document.getDefaultInstance()) {
                    this.response_ = Document.newBuilder(this.response_).mergeFrom((Document.Builder) document).buildPartial();
                } else {
                    this.response_ = document;
                }
            }

            public static GetDocument parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (GetDocument) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
            }

            public static GetDocument parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return (GetDocument) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
            }

            public static Parser<GetDocument> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void q0(GetDocumentRequest getDocumentRequest) {
                getDocumentRequest.getClass();
                this.request_ = getDocumentRequest;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void r0(Document document) {
                document.getClass();
                this.response_ = document;
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.GetDocumentOrBuilder
            public GetDocumentRequest getRequest() {
                GetDocumentRequest getDocumentRequest = this.request_;
                if (getDocumentRequest == null) {
                    return GetDocumentRequest.getDefaultInstance();
                }
                return getDocumentRequest;
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.GetDocumentOrBuilder
            public Document getResponse() {
                Document document = this.response_;
                if (document == null) {
                    return Document.getDefaultInstance();
                }
                return document;
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.GetDocumentOrBuilder
            public boolean hasRequest() {
                if (this.request_ != null) {
                    return true;
                }
                return false;
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.GetDocumentOrBuilder
            public boolean hasResponse() {
                if (this.response_ != null) {
                    return true;
                }
                return false;
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                switch (AnonymousClass1.f26254a[methodToInvoke.ordinal()]) {
                    case 1:
                        return new GetDocument();
                    case 2:
                        return new Builder(null);
                    case 3:
                        return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\t", new Object[]{"request_", "response_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<GetDocument> parser = PARSER;
                        if (parser == null) {
                            synchronized (GetDocument.class) {
                                parser = PARSER;
                                if (parser == null) {
                                    parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                    PARSER = parser;
                                }
                            }
                        }
                        return parser;
                    case 6:
                        return (byte) 1;
                    case 7:
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            public static Builder newBuilder(GetDocument getDocument) {
                return DEFAULT_INSTANCE.r(getDocument);
            }

            public static GetDocument parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (GetDocument) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static GetDocument parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (GetDocument) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static GetDocument parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (GetDocument) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
            }

            public static GetDocument parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (GetDocument) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static GetDocument parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (GetDocument) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
            }

            public static GetDocument parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (GetDocument) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static GetDocument parseFrom(InputStream inputStream) throws IOException {
                return (GetDocument) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
            }

            public static GetDocument parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (GetDocument) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static GetDocument parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (GetDocument) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
            }

            public static GetDocument parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (GetDocument) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }
        }

        /* loaded from: classes5.dex */
        public interface GetDocumentOrBuilder extends MessageLiteOrBuilder {
            GetDocumentRequest getRequest();

            Document getResponse();

            boolean hasRequest();

            boolean hasResponse();
        }

        /* loaded from: classes5.dex */
        public static final class ListCollectionIds extends GeneratedMessageLite<ListCollectionIds, Builder> implements ListCollectionIdsOrBuilder {
            private static final ListCollectionIds DEFAULT_INSTANCE;
            private static volatile Parser<ListCollectionIds> PARSER = null;
            public static final int REQUEST_FIELD_NUMBER = 1;
            public static final int RESPONSE_FIELD_NUMBER = 2;
            private ListCollectionIdsRequest request_;
            private ListCollectionIdsResponse response_;

            /* loaded from: classes5.dex */
            public static final class Builder extends GeneratedMessageLite.Builder<ListCollectionIds, Builder> implements ListCollectionIdsOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                public Builder clearRequest() {
                    f();
                    ((ListCollectionIds) this.f33398b).m0();
                    return this;
                }

                public Builder clearResponse() {
                    f();
                    ((ListCollectionIds) this.f33398b).n0();
                    return this;
                }

                @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.ListCollectionIdsOrBuilder
                public ListCollectionIdsRequest getRequest() {
                    return ((ListCollectionIds) this.f33398b).getRequest();
                }

                @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.ListCollectionIdsOrBuilder
                public ListCollectionIdsResponse getResponse() {
                    return ((ListCollectionIds) this.f33398b).getResponse();
                }

                @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.ListCollectionIdsOrBuilder
                public boolean hasRequest() {
                    return ((ListCollectionIds) this.f33398b).hasRequest();
                }

                @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.ListCollectionIdsOrBuilder
                public boolean hasResponse() {
                    return ((ListCollectionIds) this.f33398b).hasResponse();
                }

                public Builder mergeRequest(ListCollectionIdsRequest listCollectionIdsRequest) {
                    f();
                    ((ListCollectionIds) this.f33398b).o0(listCollectionIdsRequest);
                    return this;
                }

                public Builder mergeResponse(ListCollectionIdsResponse listCollectionIdsResponse) {
                    f();
                    ((ListCollectionIds) this.f33398b).p0(listCollectionIdsResponse);
                    return this;
                }

                public Builder setRequest(ListCollectionIdsRequest listCollectionIdsRequest) {
                    f();
                    ((ListCollectionIds) this.f33398b).q0(listCollectionIdsRequest);
                    return this;
                }

                public Builder setResponse(ListCollectionIdsResponse listCollectionIdsResponse) {
                    f();
                    ((ListCollectionIds) this.f33398b).r0(listCollectionIdsResponse);
                    return this;
                }

                private Builder() {
                    super(ListCollectionIds.DEFAULT_INSTANCE);
                }

                public Builder setRequest(ListCollectionIdsRequest.Builder builder) {
                    f();
                    ((ListCollectionIds) this.f33398b).q0(builder.build());
                    return this;
                }

                public Builder setResponse(ListCollectionIdsResponse.Builder builder) {
                    f();
                    ((ListCollectionIds) this.f33398b).r0(builder.build());
                    return this;
                }
            }

            static {
                ListCollectionIds listCollectionIds = new ListCollectionIds();
                DEFAULT_INSTANCE = listCollectionIds;
                GeneratedMessageLite.d0(ListCollectionIds.class, listCollectionIds);
            }

            private ListCollectionIds() {
            }

            public static ListCollectionIds getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void m0() {
                this.request_ = null;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void n0() {
                this.response_ = null;
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.q();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void o0(ListCollectionIdsRequest listCollectionIdsRequest) {
                listCollectionIdsRequest.getClass();
                ListCollectionIdsRequest listCollectionIdsRequest2 = this.request_;
                if (listCollectionIdsRequest2 != null && listCollectionIdsRequest2 != ListCollectionIdsRequest.getDefaultInstance()) {
                    this.request_ = ListCollectionIdsRequest.newBuilder(this.request_).mergeFrom((ListCollectionIdsRequest.Builder) listCollectionIdsRequest).buildPartial();
                } else {
                    this.request_ = listCollectionIdsRequest;
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void p0(ListCollectionIdsResponse listCollectionIdsResponse) {
                listCollectionIdsResponse.getClass();
                ListCollectionIdsResponse listCollectionIdsResponse2 = this.response_;
                if (listCollectionIdsResponse2 != null && listCollectionIdsResponse2 != ListCollectionIdsResponse.getDefaultInstance()) {
                    this.response_ = ListCollectionIdsResponse.newBuilder(this.response_).mergeFrom((ListCollectionIdsResponse.Builder) listCollectionIdsResponse).buildPartial();
                } else {
                    this.response_ = listCollectionIdsResponse;
                }
            }

            public static ListCollectionIds parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (ListCollectionIds) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
            }

            public static ListCollectionIds parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return (ListCollectionIds) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
            }

            public static Parser<ListCollectionIds> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void q0(ListCollectionIdsRequest listCollectionIdsRequest) {
                listCollectionIdsRequest.getClass();
                this.request_ = listCollectionIdsRequest;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void r0(ListCollectionIdsResponse listCollectionIdsResponse) {
                listCollectionIdsResponse.getClass();
                this.response_ = listCollectionIdsResponse;
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.ListCollectionIdsOrBuilder
            public ListCollectionIdsRequest getRequest() {
                ListCollectionIdsRequest listCollectionIdsRequest = this.request_;
                if (listCollectionIdsRequest == null) {
                    return ListCollectionIdsRequest.getDefaultInstance();
                }
                return listCollectionIdsRequest;
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.ListCollectionIdsOrBuilder
            public ListCollectionIdsResponse getResponse() {
                ListCollectionIdsResponse listCollectionIdsResponse = this.response_;
                if (listCollectionIdsResponse == null) {
                    return ListCollectionIdsResponse.getDefaultInstance();
                }
                return listCollectionIdsResponse;
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.ListCollectionIdsOrBuilder
            public boolean hasRequest() {
                if (this.request_ != null) {
                    return true;
                }
                return false;
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.ListCollectionIdsOrBuilder
            public boolean hasResponse() {
                if (this.response_ != null) {
                    return true;
                }
                return false;
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                switch (AnonymousClass1.f26254a[methodToInvoke.ordinal()]) {
                    case 1:
                        return new ListCollectionIds();
                    case 2:
                        return new Builder(null);
                    case 3:
                        return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\t", new Object[]{"request_", "response_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<ListCollectionIds> parser = PARSER;
                        if (parser == null) {
                            synchronized (ListCollectionIds.class) {
                                parser = PARSER;
                                if (parser == null) {
                                    parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                    PARSER = parser;
                                }
                            }
                        }
                        return parser;
                    case 6:
                        return (byte) 1;
                    case 7:
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            public static Builder newBuilder(ListCollectionIds listCollectionIds) {
                return DEFAULT_INSTANCE.r(listCollectionIds);
            }

            public static ListCollectionIds parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (ListCollectionIds) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static ListCollectionIds parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (ListCollectionIds) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static ListCollectionIds parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (ListCollectionIds) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
            }

            public static ListCollectionIds parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (ListCollectionIds) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static ListCollectionIds parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (ListCollectionIds) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
            }

            public static ListCollectionIds parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (ListCollectionIds) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static ListCollectionIds parseFrom(InputStream inputStream) throws IOException {
                return (ListCollectionIds) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
            }

            public static ListCollectionIds parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (ListCollectionIds) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static ListCollectionIds parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (ListCollectionIds) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
            }

            public static ListCollectionIds parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (ListCollectionIds) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }
        }

        /* loaded from: classes5.dex */
        public interface ListCollectionIdsOrBuilder extends MessageLiteOrBuilder {
            ListCollectionIdsRequest getRequest();

            ListCollectionIdsResponse getResponse();

            boolean hasRequest();

            boolean hasResponse();
        }

        /* loaded from: classes5.dex */
        public static final class ListDocuments extends GeneratedMessageLite<ListDocuments, Builder> implements ListDocumentsOrBuilder {
            private static final ListDocuments DEFAULT_INSTANCE;
            private static volatile Parser<ListDocuments> PARSER = null;
            public static final int REQUEST_FIELD_NUMBER = 1;
            public static final int RESPONSE_FIELD_NUMBER = 2;
            private ListDocumentsRequest request_;
            private ListDocumentsResponse response_;

            /* loaded from: classes5.dex */
            public static final class Builder extends GeneratedMessageLite.Builder<ListDocuments, Builder> implements ListDocumentsOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                public Builder clearRequest() {
                    f();
                    ((ListDocuments) this.f33398b).m0();
                    return this;
                }

                public Builder clearResponse() {
                    f();
                    ((ListDocuments) this.f33398b).n0();
                    return this;
                }

                @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.ListDocumentsOrBuilder
                public ListDocumentsRequest getRequest() {
                    return ((ListDocuments) this.f33398b).getRequest();
                }

                @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.ListDocumentsOrBuilder
                public ListDocumentsResponse getResponse() {
                    return ((ListDocuments) this.f33398b).getResponse();
                }

                @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.ListDocumentsOrBuilder
                public boolean hasRequest() {
                    return ((ListDocuments) this.f33398b).hasRequest();
                }

                @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.ListDocumentsOrBuilder
                public boolean hasResponse() {
                    return ((ListDocuments) this.f33398b).hasResponse();
                }

                public Builder mergeRequest(ListDocumentsRequest listDocumentsRequest) {
                    f();
                    ((ListDocuments) this.f33398b).o0(listDocumentsRequest);
                    return this;
                }

                public Builder mergeResponse(ListDocumentsResponse listDocumentsResponse) {
                    f();
                    ((ListDocuments) this.f33398b).p0(listDocumentsResponse);
                    return this;
                }

                public Builder setRequest(ListDocumentsRequest listDocumentsRequest) {
                    f();
                    ((ListDocuments) this.f33398b).q0(listDocumentsRequest);
                    return this;
                }

                public Builder setResponse(ListDocumentsResponse listDocumentsResponse) {
                    f();
                    ((ListDocuments) this.f33398b).r0(listDocumentsResponse);
                    return this;
                }

                private Builder() {
                    super(ListDocuments.DEFAULT_INSTANCE);
                }

                public Builder setRequest(ListDocumentsRequest.Builder builder) {
                    f();
                    ((ListDocuments) this.f33398b).q0(builder.build());
                    return this;
                }

                public Builder setResponse(ListDocumentsResponse.Builder builder) {
                    f();
                    ((ListDocuments) this.f33398b).r0(builder.build());
                    return this;
                }
            }

            static {
                ListDocuments listDocuments = new ListDocuments();
                DEFAULT_INSTANCE = listDocuments;
                GeneratedMessageLite.d0(ListDocuments.class, listDocuments);
            }

            private ListDocuments() {
            }

            public static ListDocuments getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void m0() {
                this.request_ = null;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void n0() {
                this.response_ = null;
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.q();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void o0(ListDocumentsRequest listDocumentsRequest) {
                listDocumentsRequest.getClass();
                ListDocumentsRequest listDocumentsRequest2 = this.request_;
                if (listDocumentsRequest2 != null && listDocumentsRequest2 != ListDocumentsRequest.getDefaultInstance()) {
                    this.request_ = ListDocumentsRequest.newBuilder(this.request_).mergeFrom((ListDocumentsRequest.Builder) listDocumentsRequest).buildPartial();
                } else {
                    this.request_ = listDocumentsRequest;
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void p0(ListDocumentsResponse listDocumentsResponse) {
                listDocumentsResponse.getClass();
                ListDocumentsResponse listDocumentsResponse2 = this.response_;
                if (listDocumentsResponse2 != null && listDocumentsResponse2 != ListDocumentsResponse.getDefaultInstance()) {
                    this.response_ = ListDocumentsResponse.newBuilder(this.response_).mergeFrom((ListDocumentsResponse.Builder) listDocumentsResponse).buildPartial();
                } else {
                    this.response_ = listDocumentsResponse;
                }
            }

            public static ListDocuments parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (ListDocuments) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
            }

            public static ListDocuments parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return (ListDocuments) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
            }

            public static Parser<ListDocuments> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void q0(ListDocumentsRequest listDocumentsRequest) {
                listDocumentsRequest.getClass();
                this.request_ = listDocumentsRequest;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void r0(ListDocumentsResponse listDocumentsResponse) {
                listDocumentsResponse.getClass();
                this.response_ = listDocumentsResponse;
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.ListDocumentsOrBuilder
            public ListDocumentsRequest getRequest() {
                ListDocumentsRequest listDocumentsRequest = this.request_;
                if (listDocumentsRequest == null) {
                    return ListDocumentsRequest.getDefaultInstance();
                }
                return listDocumentsRequest;
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.ListDocumentsOrBuilder
            public ListDocumentsResponse getResponse() {
                ListDocumentsResponse listDocumentsResponse = this.response_;
                if (listDocumentsResponse == null) {
                    return ListDocumentsResponse.getDefaultInstance();
                }
                return listDocumentsResponse;
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.ListDocumentsOrBuilder
            public boolean hasRequest() {
                if (this.request_ != null) {
                    return true;
                }
                return false;
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.ListDocumentsOrBuilder
            public boolean hasResponse() {
                if (this.response_ != null) {
                    return true;
                }
                return false;
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                switch (AnonymousClass1.f26254a[methodToInvoke.ordinal()]) {
                    case 1:
                        return new ListDocuments();
                    case 2:
                        return new Builder(null);
                    case 3:
                        return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\t", new Object[]{"request_", "response_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<ListDocuments> parser = PARSER;
                        if (parser == null) {
                            synchronized (ListDocuments.class) {
                                parser = PARSER;
                                if (parser == null) {
                                    parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                    PARSER = parser;
                                }
                            }
                        }
                        return parser;
                    case 6:
                        return (byte) 1;
                    case 7:
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            public static Builder newBuilder(ListDocuments listDocuments) {
                return DEFAULT_INSTANCE.r(listDocuments);
            }

            public static ListDocuments parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (ListDocuments) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static ListDocuments parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (ListDocuments) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static ListDocuments parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (ListDocuments) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
            }

            public static ListDocuments parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (ListDocuments) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static ListDocuments parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (ListDocuments) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
            }

            public static ListDocuments parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (ListDocuments) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static ListDocuments parseFrom(InputStream inputStream) throws IOException {
                return (ListDocuments) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
            }

            public static ListDocuments parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (ListDocuments) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static ListDocuments parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (ListDocuments) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
            }

            public static ListDocuments parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (ListDocuments) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }
        }

        /* loaded from: classes5.dex */
        public interface ListDocumentsOrBuilder extends MessageLiteOrBuilder {
            ListDocumentsRequest getRequest();

            ListDocumentsResponse getResponse();

            boolean hasRequest();

            boolean hasResponse();
        }

        /* loaded from: classes5.dex */
        public static final class Listen extends GeneratedMessageLite<Listen, Builder> implements ListenOrBuilder {
            private static final Listen DEFAULT_INSTANCE;
            private static volatile Parser<Listen> PARSER = null;
            public static final int REQUEST_FIELD_NUMBER = 1;
            public static final int RESPONSE_FIELD_NUMBER = 2;
            private ListenRequest request_;
            private ListenResponse response_;

            /* loaded from: classes5.dex */
            public static final class Builder extends GeneratedMessageLite.Builder<Listen, Builder> implements ListenOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                public Builder clearRequest() {
                    f();
                    ((Listen) this.f33398b).m0();
                    return this;
                }

                public Builder clearResponse() {
                    f();
                    ((Listen) this.f33398b).n0();
                    return this;
                }

                @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.ListenOrBuilder
                public ListenRequest getRequest() {
                    return ((Listen) this.f33398b).getRequest();
                }

                @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.ListenOrBuilder
                public ListenResponse getResponse() {
                    return ((Listen) this.f33398b).getResponse();
                }

                @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.ListenOrBuilder
                public boolean hasRequest() {
                    return ((Listen) this.f33398b).hasRequest();
                }

                @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.ListenOrBuilder
                public boolean hasResponse() {
                    return ((Listen) this.f33398b).hasResponse();
                }

                public Builder mergeRequest(ListenRequest listenRequest) {
                    f();
                    ((Listen) this.f33398b).o0(listenRequest);
                    return this;
                }

                public Builder mergeResponse(ListenResponse listenResponse) {
                    f();
                    ((Listen) this.f33398b).p0(listenResponse);
                    return this;
                }

                public Builder setRequest(ListenRequest listenRequest) {
                    f();
                    ((Listen) this.f33398b).q0(listenRequest);
                    return this;
                }

                public Builder setResponse(ListenResponse listenResponse) {
                    f();
                    ((Listen) this.f33398b).r0(listenResponse);
                    return this;
                }

                private Builder() {
                    super(Listen.DEFAULT_INSTANCE);
                }

                public Builder setRequest(ListenRequest.Builder builder) {
                    f();
                    ((Listen) this.f33398b).q0(builder.build());
                    return this;
                }

                public Builder setResponse(ListenResponse.Builder builder) {
                    f();
                    ((Listen) this.f33398b).r0(builder.build());
                    return this;
                }
            }

            static {
                Listen listen = new Listen();
                DEFAULT_INSTANCE = listen;
                GeneratedMessageLite.d0(Listen.class, listen);
            }

            private Listen() {
            }

            public static Listen getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void m0() {
                this.request_ = null;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void n0() {
                this.response_ = null;
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.q();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void o0(ListenRequest listenRequest) {
                listenRequest.getClass();
                ListenRequest listenRequest2 = this.request_;
                if (listenRequest2 != null && listenRequest2 != ListenRequest.getDefaultInstance()) {
                    this.request_ = ListenRequest.newBuilder(this.request_).mergeFrom((ListenRequest.Builder) listenRequest).buildPartial();
                } else {
                    this.request_ = listenRequest;
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void p0(ListenResponse listenResponse) {
                listenResponse.getClass();
                ListenResponse listenResponse2 = this.response_;
                if (listenResponse2 != null && listenResponse2 != ListenResponse.getDefaultInstance()) {
                    this.response_ = ListenResponse.newBuilder(this.response_).mergeFrom((ListenResponse.Builder) listenResponse).buildPartial();
                } else {
                    this.response_ = listenResponse;
                }
            }

            public static Listen parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (Listen) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
            }

            public static Listen parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return (Listen) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
            }

            public static Parser<Listen> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void q0(ListenRequest listenRequest) {
                listenRequest.getClass();
                this.request_ = listenRequest;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void r0(ListenResponse listenResponse) {
                listenResponse.getClass();
                this.response_ = listenResponse;
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.ListenOrBuilder
            public ListenRequest getRequest() {
                ListenRequest listenRequest = this.request_;
                if (listenRequest == null) {
                    return ListenRequest.getDefaultInstance();
                }
                return listenRequest;
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.ListenOrBuilder
            public ListenResponse getResponse() {
                ListenResponse listenResponse = this.response_;
                if (listenResponse == null) {
                    return ListenResponse.getDefaultInstance();
                }
                return listenResponse;
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.ListenOrBuilder
            public boolean hasRequest() {
                if (this.request_ != null) {
                    return true;
                }
                return false;
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.ListenOrBuilder
            public boolean hasResponse() {
                if (this.response_ != null) {
                    return true;
                }
                return false;
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                switch (AnonymousClass1.f26254a[methodToInvoke.ordinal()]) {
                    case 1:
                        return new Listen();
                    case 2:
                        return new Builder(null);
                    case 3:
                        return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\t", new Object[]{"request_", "response_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<Listen> parser = PARSER;
                        if (parser == null) {
                            synchronized (Listen.class) {
                                parser = PARSER;
                                if (parser == null) {
                                    parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                    PARSER = parser;
                                }
                            }
                        }
                        return parser;
                    case 6:
                        return (byte) 1;
                    case 7:
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            public static Builder newBuilder(Listen listen) {
                return DEFAULT_INSTANCE.r(listen);
            }

            public static Listen parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Listen) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Listen parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (Listen) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static Listen parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (Listen) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
            }

            public static Listen parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (Listen) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static Listen parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (Listen) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
            }

            public static Listen parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (Listen) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static Listen parseFrom(InputStream inputStream) throws IOException {
                return (Listen) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
            }

            public static Listen parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Listen) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Listen parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (Listen) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
            }

            public static Listen parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Listen) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }
        }

        /* loaded from: classes5.dex */
        public interface ListenOrBuilder extends MessageLiteOrBuilder {
            ListenRequest getRequest();

            ListenResponse getResponse();

            boolean hasRequest();

            boolean hasResponse();
        }

        /* loaded from: classes5.dex */
        public static final class MatchingDocuments extends GeneratedMessageLite<MatchingDocuments, Builder> implements MatchingDocumentsOrBuilder {
            private static final MatchingDocuments DEFAULT_INSTANCE;
            public static final int LISTEN_RESPONSE_FIELD_NUMBER = 1;
            public static final int MATCHING_DOCUMENTS_FIELD_NUMBER = 2;
            private static volatile Parser<MatchingDocuments> PARSER;
            private ListenResponse listenResponse_;
            private RunQueryResponse matchingDocuments_;

            /* loaded from: classes5.dex */
            public static final class Builder extends GeneratedMessageLite.Builder<MatchingDocuments, Builder> implements MatchingDocumentsOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                public Builder clearListenResponse() {
                    f();
                    ((MatchingDocuments) this.f33398b).m0();
                    return this;
                }

                public Builder clearMatchingDocuments() {
                    f();
                    ((MatchingDocuments) this.f33398b).n0();
                    return this;
                }

                @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.MatchingDocumentsOrBuilder
                public ListenResponse getListenResponse() {
                    return ((MatchingDocuments) this.f33398b).getListenResponse();
                }

                @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.MatchingDocumentsOrBuilder
                public RunQueryResponse getMatchingDocuments() {
                    return ((MatchingDocuments) this.f33398b).getMatchingDocuments();
                }

                @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.MatchingDocumentsOrBuilder
                public boolean hasListenResponse() {
                    return ((MatchingDocuments) this.f33398b).hasListenResponse();
                }

                @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.MatchingDocumentsOrBuilder
                public boolean hasMatchingDocuments() {
                    return ((MatchingDocuments) this.f33398b).hasMatchingDocuments();
                }

                public Builder mergeListenResponse(ListenResponse listenResponse) {
                    f();
                    ((MatchingDocuments) this.f33398b).o0(listenResponse);
                    return this;
                }

                public Builder mergeMatchingDocuments(RunQueryResponse runQueryResponse) {
                    f();
                    ((MatchingDocuments) this.f33398b).p0(runQueryResponse);
                    return this;
                }

                public Builder setListenResponse(ListenResponse listenResponse) {
                    f();
                    ((MatchingDocuments) this.f33398b).q0(listenResponse);
                    return this;
                }

                public Builder setMatchingDocuments(RunQueryResponse runQueryResponse) {
                    f();
                    ((MatchingDocuments) this.f33398b).r0(runQueryResponse);
                    return this;
                }

                private Builder() {
                    super(MatchingDocuments.DEFAULT_INSTANCE);
                }

                public Builder setListenResponse(ListenResponse.Builder builder) {
                    f();
                    ((MatchingDocuments) this.f33398b).q0(builder.build());
                    return this;
                }

                public Builder setMatchingDocuments(RunQueryResponse.Builder builder) {
                    f();
                    ((MatchingDocuments) this.f33398b).r0(builder.build());
                    return this;
                }
            }

            static {
                MatchingDocuments matchingDocuments = new MatchingDocuments();
                DEFAULT_INSTANCE = matchingDocuments;
                GeneratedMessageLite.d0(MatchingDocuments.class, matchingDocuments);
            }

            private MatchingDocuments() {
            }

            public static MatchingDocuments getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void m0() {
                this.listenResponse_ = null;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void n0() {
                this.matchingDocuments_ = null;
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.q();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void o0(ListenResponse listenResponse) {
                listenResponse.getClass();
                ListenResponse listenResponse2 = this.listenResponse_;
                if (listenResponse2 != null && listenResponse2 != ListenResponse.getDefaultInstance()) {
                    this.listenResponse_ = ListenResponse.newBuilder(this.listenResponse_).mergeFrom((ListenResponse.Builder) listenResponse).buildPartial();
                } else {
                    this.listenResponse_ = listenResponse;
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void p0(RunQueryResponse runQueryResponse) {
                runQueryResponse.getClass();
                RunQueryResponse runQueryResponse2 = this.matchingDocuments_;
                if (runQueryResponse2 != null && runQueryResponse2 != RunQueryResponse.getDefaultInstance()) {
                    this.matchingDocuments_ = RunQueryResponse.newBuilder(this.matchingDocuments_).mergeFrom((RunQueryResponse.Builder) runQueryResponse).buildPartial();
                } else {
                    this.matchingDocuments_ = runQueryResponse;
                }
            }

            public static MatchingDocuments parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (MatchingDocuments) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
            }

            public static MatchingDocuments parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return (MatchingDocuments) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
            }

            public static Parser<MatchingDocuments> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void q0(ListenResponse listenResponse) {
                listenResponse.getClass();
                this.listenResponse_ = listenResponse;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void r0(RunQueryResponse runQueryResponse) {
                runQueryResponse.getClass();
                this.matchingDocuments_ = runQueryResponse;
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.MatchingDocumentsOrBuilder
            public ListenResponse getListenResponse() {
                ListenResponse listenResponse = this.listenResponse_;
                if (listenResponse == null) {
                    return ListenResponse.getDefaultInstance();
                }
                return listenResponse;
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.MatchingDocumentsOrBuilder
            public RunQueryResponse getMatchingDocuments() {
                RunQueryResponse runQueryResponse = this.matchingDocuments_;
                if (runQueryResponse == null) {
                    return RunQueryResponse.getDefaultInstance();
                }
                return runQueryResponse;
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.MatchingDocumentsOrBuilder
            public boolean hasListenResponse() {
                if (this.listenResponse_ != null) {
                    return true;
                }
                return false;
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.MatchingDocumentsOrBuilder
            public boolean hasMatchingDocuments() {
                if (this.matchingDocuments_ != null) {
                    return true;
                }
                return false;
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                switch (AnonymousClass1.f26254a[methodToInvoke.ordinal()]) {
                    case 1:
                        return new MatchingDocuments();
                    case 2:
                        return new Builder(null);
                    case 3:
                        return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\t", new Object[]{"listenResponse_", "matchingDocuments_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<MatchingDocuments> parser = PARSER;
                        if (parser == null) {
                            synchronized (MatchingDocuments.class) {
                                parser = PARSER;
                                if (parser == null) {
                                    parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                    PARSER = parser;
                                }
                            }
                        }
                        return parser;
                    case 6:
                        return (byte) 1;
                    case 7:
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            public static Builder newBuilder(MatchingDocuments matchingDocuments) {
                return DEFAULT_INSTANCE.r(matchingDocuments);
            }

            public static MatchingDocuments parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (MatchingDocuments) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static MatchingDocuments parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (MatchingDocuments) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static MatchingDocuments parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (MatchingDocuments) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
            }

            public static MatchingDocuments parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (MatchingDocuments) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static MatchingDocuments parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (MatchingDocuments) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
            }

            public static MatchingDocuments parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (MatchingDocuments) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static MatchingDocuments parseFrom(InputStream inputStream) throws IOException {
                return (MatchingDocuments) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
            }

            public static MatchingDocuments parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (MatchingDocuments) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static MatchingDocuments parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (MatchingDocuments) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
            }

            public static MatchingDocuments parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (MatchingDocuments) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }
        }

        /* loaded from: classes5.dex */
        public interface MatchingDocumentsOrBuilder extends MessageLiteOrBuilder {
            ListenResponse getListenResponse();

            RunQueryResponse getMatchingDocuments();

            boolean hasListenResponse();

            boolean hasMatchingDocuments();
        }

        /* loaded from: classes5.dex */
        public static final class RemoveListen extends GeneratedMessageLite<RemoveListen, Builder> implements RemoveListenOrBuilder {
            private static final RemoveListen DEFAULT_INSTANCE;
            private static volatile Parser<RemoveListen> PARSER = null;
            public static final int TARGET_ID_FIELD_NUMBER = 1;
            private int targetId_;

            /* loaded from: classes5.dex */
            public static final class Builder extends GeneratedMessageLite.Builder<RemoveListen, Builder> implements RemoveListenOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                public Builder clearTargetId() {
                    f();
                    ((RemoveListen) this.f33398b).i0();
                    return this;
                }

                @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.RemoveListenOrBuilder
                public int getTargetId() {
                    return ((RemoveListen) this.f33398b).getTargetId();
                }

                public Builder setTargetId(int i4) {
                    f();
                    ((RemoveListen) this.f33398b).j0(i4);
                    return this;
                }

                private Builder() {
                    super(RemoveListen.DEFAULT_INSTANCE);
                }
            }

            static {
                RemoveListen removeListen = new RemoveListen();
                DEFAULT_INSTANCE = removeListen;
                GeneratedMessageLite.d0(RemoveListen.class, removeListen);
            }

            private RemoveListen() {
            }

            public static RemoveListen getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void i0() {
                this.targetId_ = 0;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void j0(int i4) {
                this.targetId_ = i4;
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.q();
            }

            public static RemoveListen parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (RemoveListen) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
            }

            public static RemoveListen parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return (RemoveListen) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
            }

            public static Parser<RemoveListen> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.RemoveListenOrBuilder
            public int getTargetId() {
                return this.targetId_;
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                switch (AnonymousClass1.f26254a[methodToInvoke.ordinal()]) {
                    case 1:
                        return new RemoveListen();
                    case 2:
                        return new Builder(null);
                    case 3:
                        return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0004", new Object[]{"targetId_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<RemoveListen> parser = PARSER;
                        if (parser == null) {
                            synchronized (RemoveListen.class) {
                                parser = PARSER;
                                if (parser == null) {
                                    parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                    PARSER = parser;
                                }
                            }
                        }
                        return parser;
                    case 6:
                        return (byte) 1;
                    case 7:
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            public static Builder newBuilder(RemoveListen removeListen) {
                return DEFAULT_INSTANCE.r(removeListen);
            }

            public static RemoveListen parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (RemoveListen) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static RemoveListen parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (RemoveListen) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static RemoveListen parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (RemoveListen) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
            }

            public static RemoveListen parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (RemoveListen) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static RemoveListen parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (RemoveListen) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
            }

            public static RemoveListen parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (RemoveListen) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static RemoveListen parseFrom(InputStream inputStream) throws IOException {
                return (RemoveListen) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
            }

            public static RemoveListen parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (RemoveListen) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static RemoveListen parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (RemoveListen) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
            }

            public static RemoveListen parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (RemoveListen) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }
        }

        /* loaded from: classes5.dex */
        public interface RemoveListenOrBuilder extends MessageLiteOrBuilder {
            int getTargetId();
        }

        /* loaded from: classes5.dex */
        public static final class Rollback extends GeneratedMessageLite<Rollback, Builder> implements RollbackOrBuilder {
            private static final Rollback DEFAULT_INSTANCE;
            private static volatile Parser<Rollback> PARSER = null;
            public static final int REQUEST_FIELD_NUMBER = 1;
            public static final int RESPONSE_FIELD_NUMBER = 2;
            private RollbackRequest request_;
            private Empty response_;

            /* loaded from: classes5.dex */
            public static final class Builder extends GeneratedMessageLite.Builder<Rollback, Builder> implements RollbackOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                public Builder clearRequest() {
                    f();
                    ((Rollback) this.f33398b).m0();
                    return this;
                }

                public Builder clearResponse() {
                    f();
                    ((Rollback) this.f33398b).n0();
                    return this;
                }

                @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.RollbackOrBuilder
                public RollbackRequest getRequest() {
                    return ((Rollback) this.f33398b).getRequest();
                }

                @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.RollbackOrBuilder
                public Empty getResponse() {
                    return ((Rollback) this.f33398b).getResponse();
                }

                @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.RollbackOrBuilder
                public boolean hasRequest() {
                    return ((Rollback) this.f33398b).hasRequest();
                }

                @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.RollbackOrBuilder
                public boolean hasResponse() {
                    return ((Rollback) this.f33398b).hasResponse();
                }

                public Builder mergeRequest(RollbackRequest rollbackRequest) {
                    f();
                    ((Rollback) this.f33398b).o0(rollbackRequest);
                    return this;
                }

                public Builder mergeResponse(Empty empty) {
                    f();
                    ((Rollback) this.f33398b).p0(empty);
                    return this;
                }

                public Builder setRequest(RollbackRequest rollbackRequest) {
                    f();
                    ((Rollback) this.f33398b).q0(rollbackRequest);
                    return this;
                }

                public Builder setResponse(Empty empty) {
                    f();
                    ((Rollback) this.f33398b).r0(empty);
                    return this;
                }

                private Builder() {
                    super(Rollback.DEFAULT_INSTANCE);
                }

                public Builder setRequest(RollbackRequest.Builder builder) {
                    f();
                    ((Rollback) this.f33398b).q0(builder.build());
                    return this;
                }

                public Builder setResponse(Empty.Builder builder) {
                    f();
                    ((Rollback) this.f33398b).r0(builder.build());
                    return this;
                }
            }

            static {
                Rollback rollback = new Rollback();
                DEFAULT_INSTANCE = rollback;
                GeneratedMessageLite.d0(Rollback.class, rollback);
            }

            private Rollback() {
            }

            public static Rollback getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void m0() {
                this.request_ = null;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void n0() {
                this.response_ = null;
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.q();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void o0(RollbackRequest rollbackRequest) {
                rollbackRequest.getClass();
                RollbackRequest rollbackRequest2 = this.request_;
                if (rollbackRequest2 != null && rollbackRequest2 != RollbackRequest.getDefaultInstance()) {
                    this.request_ = RollbackRequest.newBuilder(this.request_).mergeFrom((RollbackRequest.Builder) rollbackRequest).buildPartial();
                } else {
                    this.request_ = rollbackRequest;
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void p0(Empty empty) {
                empty.getClass();
                Empty empty2 = this.response_;
                if (empty2 != null && empty2 != Empty.getDefaultInstance()) {
                    this.response_ = Empty.newBuilder(this.response_).mergeFrom((Empty.Builder) empty).buildPartial();
                } else {
                    this.response_ = empty;
                }
            }

            public static Rollback parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (Rollback) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
            }

            public static Rollback parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return (Rollback) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
            }

            public static Parser<Rollback> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void q0(RollbackRequest rollbackRequest) {
                rollbackRequest.getClass();
                this.request_ = rollbackRequest;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void r0(Empty empty) {
                empty.getClass();
                this.response_ = empty;
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.RollbackOrBuilder
            public RollbackRequest getRequest() {
                RollbackRequest rollbackRequest = this.request_;
                if (rollbackRequest == null) {
                    return RollbackRequest.getDefaultInstance();
                }
                return rollbackRequest;
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.RollbackOrBuilder
            public Empty getResponse() {
                Empty empty = this.response_;
                if (empty == null) {
                    return Empty.getDefaultInstance();
                }
                return empty;
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.RollbackOrBuilder
            public boolean hasRequest() {
                if (this.request_ != null) {
                    return true;
                }
                return false;
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.RollbackOrBuilder
            public boolean hasResponse() {
                if (this.response_ != null) {
                    return true;
                }
                return false;
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                switch (AnonymousClass1.f26254a[methodToInvoke.ordinal()]) {
                    case 1:
                        return new Rollback();
                    case 2:
                        return new Builder(null);
                    case 3:
                        return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\t", new Object[]{"request_", "response_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<Rollback> parser = PARSER;
                        if (parser == null) {
                            synchronized (Rollback.class) {
                                parser = PARSER;
                                if (parser == null) {
                                    parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                    PARSER = parser;
                                }
                            }
                        }
                        return parser;
                    case 6:
                        return (byte) 1;
                    case 7:
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            public static Builder newBuilder(Rollback rollback) {
                return DEFAULT_INSTANCE.r(rollback);
            }

            public static Rollback parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Rollback) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Rollback parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (Rollback) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static Rollback parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (Rollback) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
            }

            public static Rollback parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (Rollback) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static Rollback parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (Rollback) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
            }

            public static Rollback parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (Rollback) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static Rollback parseFrom(InputStream inputStream) throws IOException {
                return (Rollback) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
            }

            public static Rollback parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Rollback) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Rollback parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (Rollback) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
            }

            public static Rollback parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Rollback) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }
        }

        /* loaded from: classes5.dex */
        public interface RollbackOrBuilder extends MessageLiteOrBuilder {
            RollbackRequest getRequest();

            Empty getResponse();

            boolean hasRequest();

            boolean hasResponse();
        }

        /* loaded from: classes5.dex */
        public static final class RunQuery extends GeneratedMessageLite<RunQuery, Builder> implements RunQueryOrBuilder {
            private static final RunQuery DEFAULT_INSTANCE;
            private static volatile Parser<RunQuery> PARSER = null;
            public static final int REQUEST_FIELD_NUMBER = 1;
            public static final int RESPONSE_FIELD_NUMBER = 2;
            private RunQueryRequest request_;
            private Internal.ProtobufList<RunQueryResponse> response_ = GeneratedMessageLite.y();

            /* loaded from: classes5.dex */
            public static final class Builder extends GeneratedMessageLite.Builder<RunQuery, Builder> implements RunQueryOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                public Builder addAllResponse(Iterable<? extends RunQueryResponse> iterable) {
                    f();
                    ((RunQuery) this.f33398b).p0(iterable);
                    return this;
                }

                public Builder addResponse(RunQueryResponse runQueryResponse) {
                    f();
                    ((RunQuery) this.f33398b).r0(runQueryResponse);
                    return this;
                }

                public Builder clearRequest() {
                    f();
                    ((RunQuery) this.f33398b).s0();
                    return this;
                }

                public Builder clearResponse() {
                    f();
                    ((RunQuery) this.f33398b).t0();
                    return this;
                }

                @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.RunQueryOrBuilder
                public RunQueryRequest getRequest() {
                    return ((RunQuery) this.f33398b).getRequest();
                }

                @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.RunQueryOrBuilder
                public RunQueryResponse getResponse(int i4) {
                    return ((RunQuery) this.f33398b).getResponse(i4);
                }

                @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.RunQueryOrBuilder
                public int getResponseCount() {
                    return ((RunQuery) this.f33398b).getResponseCount();
                }

                @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.RunQueryOrBuilder
                public List<RunQueryResponse> getResponseList() {
                    return Collections.unmodifiableList(((RunQuery) this.f33398b).getResponseList());
                }

                @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.RunQueryOrBuilder
                public boolean hasRequest() {
                    return ((RunQuery) this.f33398b).hasRequest();
                }

                public Builder mergeRequest(RunQueryRequest runQueryRequest) {
                    f();
                    ((RunQuery) this.f33398b).v0(runQueryRequest);
                    return this;
                }

                public Builder removeResponse(int i4) {
                    f();
                    ((RunQuery) this.f33398b).w0(i4);
                    return this;
                }

                public Builder setRequest(RunQueryRequest runQueryRequest) {
                    f();
                    ((RunQuery) this.f33398b).x0(runQueryRequest);
                    return this;
                }

                public Builder setResponse(int i4, RunQueryResponse runQueryResponse) {
                    f();
                    ((RunQuery) this.f33398b).y0(i4, runQueryResponse);
                    return this;
                }

                private Builder() {
                    super(RunQuery.DEFAULT_INSTANCE);
                }

                public Builder addResponse(int i4, RunQueryResponse runQueryResponse) {
                    f();
                    ((RunQuery) this.f33398b).q0(i4, runQueryResponse);
                    return this;
                }

                public Builder setRequest(RunQueryRequest.Builder builder) {
                    f();
                    ((RunQuery) this.f33398b).x0(builder.build());
                    return this;
                }

                public Builder setResponse(int i4, RunQueryResponse.Builder builder) {
                    f();
                    ((RunQuery) this.f33398b).y0(i4, builder.build());
                    return this;
                }

                public Builder addResponse(RunQueryResponse.Builder builder) {
                    f();
                    ((RunQuery) this.f33398b).r0(builder.build());
                    return this;
                }

                public Builder addResponse(int i4, RunQueryResponse.Builder builder) {
                    f();
                    ((RunQuery) this.f33398b).q0(i4, builder.build());
                    return this;
                }
            }

            static {
                RunQuery runQuery = new RunQuery();
                DEFAULT_INSTANCE = runQuery;
                GeneratedMessageLite.d0(RunQuery.class, runQuery);
            }

            private RunQuery() {
            }

            public static RunQuery getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.q();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void p0(Iterable<? extends RunQueryResponse> iterable) {
                u0();
                AbstractMessageLite.a(iterable, this.response_);
            }

            public static RunQuery parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (RunQuery) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
            }

            public static RunQuery parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return (RunQuery) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
            }

            public static Parser<RunQuery> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void q0(int i4, RunQueryResponse runQueryResponse) {
                runQueryResponse.getClass();
                u0();
                this.response_.add(i4, runQueryResponse);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void r0(RunQueryResponse runQueryResponse) {
                runQueryResponse.getClass();
                u0();
                this.response_.add(runQueryResponse);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void s0() {
                this.request_ = null;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void t0() {
                this.response_ = GeneratedMessageLite.y();
            }

            private void u0() {
                Internal.ProtobufList<RunQueryResponse> protobufList = this.response_;
                if (!protobufList.isModifiable()) {
                    this.response_ = GeneratedMessageLite.K(protobufList);
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void v0(RunQueryRequest runQueryRequest) {
                runQueryRequest.getClass();
                RunQueryRequest runQueryRequest2 = this.request_;
                if (runQueryRequest2 != null && runQueryRequest2 != RunQueryRequest.getDefaultInstance()) {
                    this.request_ = RunQueryRequest.newBuilder(this.request_).mergeFrom((RunQueryRequest.Builder) runQueryRequest).buildPartial();
                } else {
                    this.request_ = runQueryRequest;
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void w0(int i4) {
                u0();
                this.response_.remove(i4);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void x0(RunQueryRequest runQueryRequest) {
                runQueryRequest.getClass();
                this.request_ = runQueryRequest;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void y0(int i4, RunQueryResponse runQueryResponse) {
                runQueryResponse.getClass();
                u0();
                this.response_.set(i4, runQueryResponse);
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.RunQueryOrBuilder
            public RunQueryRequest getRequest() {
                RunQueryRequest runQueryRequest = this.request_;
                if (runQueryRequest == null) {
                    return RunQueryRequest.getDefaultInstance();
                }
                return runQueryRequest;
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.RunQueryOrBuilder
            public RunQueryResponse getResponse(int i4) {
                return this.response_.get(i4);
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.RunQueryOrBuilder
            public int getResponseCount() {
                return this.response_.size();
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.RunQueryOrBuilder
            public List<RunQueryResponse> getResponseList() {
                return this.response_;
            }

            public RunQueryResponseOrBuilder getResponseOrBuilder(int i4) {
                return this.response_.get(i4);
            }

            public List<? extends RunQueryResponseOrBuilder> getResponseOrBuilderList() {
                return this.response_;
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.RunQueryOrBuilder
            public boolean hasRequest() {
                if (this.request_ != null) {
                    return true;
                }
                return false;
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                switch (AnonymousClass1.f26254a[methodToInvoke.ordinal()]) {
                    case 1:
                        return new RunQuery();
                    case 2:
                        return new Builder(null);
                    case 3:
                        return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\t\u0002\u001b", new Object[]{"request_", "response_", RunQueryResponse.class});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<RunQuery> parser = PARSER;
                        if (parser == null) {
                            synchronized (RunQuery.class) {
                                parser = PARSER;
                                if (parser == null) {
                                    parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                    PARSER = parser;
                                }
                            }
                        }
                        return parser;
                    case 6:
                        return (byte) 1;
                    case 7:
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            public static Builder newBuilder(RunQuery runQuery) {
                return DEFAULT_INSTANCE.r(runQuery);
            }

            public static RunQuery parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (RunQuery) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static RunQuery parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (RunQuery) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static RunQuery parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (RunQuery) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
            }

            public static RunQuery parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (RunQuery) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static RunQuery parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (RunQuery) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
            }

            public static RunQuery parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (RunQuery) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static RunQuery parseFrom(InputStream inputStream) throws IOException {
                return (RunQuery) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
            }

            public static RunQuery parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (RunQuery) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static RunQuery parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (RunQuery) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
            }

            public static RunQuery parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (RunQuery) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }
        }

        /* loaded from: classes5.dex */
        public interface RunQueryOrBuilder extends MessageLiteOrBuilder {
            RunQueryRequest getRequest();

            RunQueryResponse getResponse(int i4);

            int getResponseCount();

            List<RunQueryResponse> getResponseList();

            boolean hasRequest();
        }

        /* loaded from: classes5.dex */
        public static final class UpdateDocument extends GeneratedMessageLite<UpdateDocument, Builder> implements UpdateDocumentOrBuilder {
            private static final UpdateDocument DEFAULT_INSTANCE;
            private static volatile Parser<UpdateDocument> PARSER = null;
            public static final int REQUEST_FIELD_NUMBER = 1;
            public static final int RESPONSE_FIELD_NUMBER = 2;
            private UpdateDocumentRequest request_;
            private Document response_;

            /* loaded from: classes5.dex */
            public static final class Builder extends GeneratedMessageLite.Builder<UpdateDocument, Builder> implements UpdateDocumentOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                public Builder clearRequest() {
                    f();
                    ((UpdateDocument) this.f33398b).m0();
                    return this;
                }

                public Builder clearResponse() {
                    f();
                    ((UpdateDocument) this.f33398b).n0();
                    return this;
                }

                @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.UpdateDocumentOrBuilder
                public UpdateDocumentRequest getRequest() {
                    return ((UpdateDocument) this.f33398b).getRequest();
                }

                @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.UpdateDocumentOrBuilder
                public Document getResponse() {
                    return ((UpdateDocument) this.f33398b).getResponse();
                }

                @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.UpdateDocumentOrBuilder
                public boolean hasRequest() {
                    return ((UpdateDocument) this.f33398b).hasRequest();
                }

                @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.UpdateDocumentOrBuilder
                public boolean hasResponse() {
                    return ((UpdateDocument) this.f33398b).hasResponse();
                }

                public Builder mergeRequest(UpdateDocumentRequest updateDocumentRequest) {
                    f();
                    ((UpdateDocument) this.f33398b).o0(updateDocumentRequest);
                    return this;
                }

                public Builder mergeResponse(Document document) {
                    f();
                    ((UpdateDocument) this.f33398b).p0(document);
                    return this;
                }

                public Builder setRequest(UpdateDocumentRequest updateDocumentRequest) {
                    f();
                    ((UpdateDocument) this.f33398b).q0(updateDocumentRequest);
                    return this;
                }

                public Builder setResponse(Document document) {
                    f();
                    ((UpdateDocument) this.f33398b).r0(document);
                    return this;
                }

                private Builder() {
                    super(UpdateDocument.DEFAULT_INSTANCE);
                }

                public Builder setRequest(UpdateDocumentRequest.Builder builder) {
                    f();
                    ((UpdateDocument) this.f33398b).q0(builder.build());
                    return this;
                }

                public Builder setResponse(Document.Builder builder) {
                    f();
                    ((UpdateDocument) this.f33398b).r0(builder.build());
                    return this;
                }
            }

            static {
                UpdateDocument updateDocument = new UpdateDocument();
                DEFAULT_INSTANCE = updateDocument;
                GeneratedMessageLite.d0(UpdateDocument.class, updateDocument);
            }

            private UpdateDocument() {
            }

            public static UpdateDocument getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void m0() {
                this.request_ = null;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void n0() {
                this.response_ = null;
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.q();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void o0(UpdateDocumentRequest updateDocumentRequest) {
                updateDocumentRequest.getClass();
                UpdateDocumentRequest updateDocumentRequest2 = this.request_;
                if (updateDocumentRequest2 != null && updateDocumentRequest2 != UpdateDocumentRequest.getDefaultInstance()) {
                    this.request_ = UpdateDocumentRequest.newBuilder(this.request_).mergeFrom((UpdateDocumentRequest.Builder) updateDocumentRequest).buildPartial();
                } else {
                    this.request_ = updateDocumentRequest;
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void p0(Document document) {
                document.getClass();
                Document document2 = this.response_;
                if (document2 != null && document2 != Document.getDefaultInstance()) {
                    this.response_ = Document.newBuilder(this.response_).mergeFrom((Document.Builder) document).buildPartial();
                } else {
                    this.response_ = document;
                }
            }

            public static UpdateDocument parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (UpdateDocument) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
            }

            public static UpdateDocument parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return (UpdateDocument) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
            }

            public static Parser<UpdateDocument> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void q0(UpdateDocumentRequest updateDocumentRequest) {
                updateDocumentRequest.getClass();
                this.request_ = updateDocumentRequest;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void r0(Document document) {
                document.getClass();
                this.response_ = document;
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.UpdateDocumentOrBuilder
            public UpdateDocumentRequest getRequest() {
                UpdateDocumentRequest updateDocumentRequest = this.request_;
                if (updateDocumentRequest == null) {
                    return UpdateDocumentRequest.getDefaultInstance();
                }
                return updateDocumentRequest;
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.UpdateDocumentOrBuilder
            public Document getResponse() {
                Document document = this.response_;
                if (document == null) {
                    return Document.getDefaultInstance();
                }
                return document;
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.UpdateDocumentOrBuilder
            public boolean hasRequest() {
                if (this.request_ != null) {
                    return true;
                }
                return false;
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1Action.UpdateDocumentOrBuilder
            public boolean hasResponse() {
                if (this.response_ != null) {
                    return true;
                }
                return false;
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                switch (AnonymousClass1.f26254a[methodToInvoke.ordinal()]) {
                    case 1:
                        return new UpdateDocument();
                    case 2:
                        return new Builder(null);
                    case 3:
                        return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\t", new Object[]{"request_", "response_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<UpdateDocument> parser = PARSER;
                        if (parser == null) {
                            synchronized (UpdateDocument.class) {
                                parser = PARSER;
                                if (parser == null) {
                                    parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                    PARSER = parser;
                                }
                            }
                        }
                        return parser;
                    case 6:
                        return (byte) 1;
                    case 7:
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            public static Builder newBuilder(UpdateDocument updateDocument) {
                return DEFAULT_INSTANCE.r(updateDocument);
            }

            public static UpdateDocument parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (UpdateDocument) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static UpdateDocument parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (UpdateDocument) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static UpdateDocument parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (UpdateDocument) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
            }

            public static UpdateDocument parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (UpdateDocument) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static UpdateDocument parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (UpdateDocument) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
            }

            public static UpdateDocument parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (UpdateDocument) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static UpdateDocument parseFrom(InputStream inputStream) throws IOException {
                return (UpdateDocument) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
            }

            public static UpdateDocument parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (UpdateDocument) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static UpdateDocument parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (UpdateDocument) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
            }

            public static UpdateDocument parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (UpdateDocument) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }
        }

        /* loaded from: classes5.dex */
        public interface UpdateDocumentOrBuilder extends MessageLiteOrBuilder {
            UpdateDocumentRequest getRequest();

            Document getResponse();

            boolean hasRequest();

            boolean hasResponse();
        }

        static {
            FirestoreV1Action firestoreV1Action = new FirestoreV1Action();
            DEFAULT_INSTANCE = firestoreV1Action;
            GeneratedMessageLite.d0(FirestoreV1Action.class, firestoreV1Action);
        }

        private FirestoreV1Action() {
        }

        private void A1() {
            Internal.ProtobufList<MatchingDocuments> protobufList = this.matchingDocuments_;
            if (!protobufList.isModifiable()) {
                this.matchingDocuments_ = GeneratedMessageLite.K(protobufList);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void B1(BatchGetDocuments batchGetDocuments) {
            batchGetDocuments.getClass();
            if (this.actionCase_ == 10 && this.action_ != BatchGetDocuments.getDefaultInstance()) {
                this.action_ = BatchGetDocuments.newBuilder((BatchGetDocuments) this.action_).mergeFrom((BatchGetDocuments.Builder) batchGetDocuments).buildPartial();
            } else {
                this.action_ = batchGetDocuments;
            }
            this.actionCase_ = 10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void C1(BeginTransaction beginTransaction) {
            beginTransaction.getClass();
            if (this.actionCase_ == 6 && this.action_ != BeginTransaction.getDefaultInstance()) {
                this.action_ = BeginTransaction.newBuilder((BeginTransaction) this.action_).mergeFrom((BeginTransaction.Builder) beginTransaction).buildPartial();
            } else {
                this.action_ = beginTransaction;
            }
            this.actionCase_ = 6;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void D1(Commit commit) {
            commit.getClass();
            if (this.actionCase_ == 7 && this.action_ != Commit.getDefaultInstance()) {
                this.action_ = Commit.newBuilder((Commit) this.action_).mergeFrom((Commit.Builder) commit).buildPartial();
            } else {
                this.action_ = commit;
            }
            this.actionCase_ = 7;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void E1(CreateDocument createDocument) {
            createDocument.getClass();
            if (this.actionCase_ == 3 && this.action_ != CreateDocument.getDefaultInstance()) {
                this.action_ = CreateDocument.newBuilder((CreateDocument) this.action_).mergeFrom((CreateDocument.Builder) createDocument).buildPartial();
            } else {
                this.action_ = createDocument;
            }
            this.actionCase_ = 3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void F1(RunQuery runQuery) {
            runQuery.getClass();
            RunQuery runQuery2 = this.databaseContentsBeforeAction_;
            if (runQuery2 != null && runQuery2 != RunQuery.getDefaultInstance()) {
                this.databaseContentsBeforeAction_ = RunQuery.newBuilder(this.databaseContentsBeforeAction_).mergeFrom((RunQuery.Builder) runQuery).buildPartial();
            } else {
                this.databaseContentsBeforeAction_ = runQuery;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void G1(DeleteDocument deleteDocument) {
            deleteDocument.getClass();
            if (this.actionCase_ == 5 && this.action_ != DeleteDocument.getDefaultInstance()) {
                this.action_ = DeleteDocument.newBuilder((DeleteDocument) this.action_).mergeFrom((DeleteDocument.Builder) deleteDocument).buildPartial();
            } else {
                this.action_ = deleteDocument;
            }
            this.actionCase_ = 5;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void H1(GetDocument getDocument) {
            getDocument.getClass();
            if (this.actionCase_ == 1 && this.action_ != GetDocument.getDefaultInstance()) {
                this.action_ = GetDocument.newBuilder((GetDocument) this.action_).mergeFrom((GetDocument.Builder) getDocument).buildPartial();
            } else {
                this.action_ = getDocument;
            }
            this.actionCase_ = 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void I1(ListCollectionIds listCollectionIds) {
            listCollectionIds.getClass();
            if (this.actionCase_ == 9 && this.action_ != ListCollectionIds.getDefaultInstance()) {
                this.action_ = ListCollectionIds.newBuilder((ListCollectionIds) this.action_).mergeFrom((ListCollectionIds.Builder) listCollectionIds).buildPartial();
            } else {
                this.action_ = listCollectionIds;
            }
            this.actionCase_ = 9;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void J1(ListDocuments listDocuments) {
            listDocuments.getClass();
            if (this.actionCase_ == 2 && this.action_ != ListDocuments.getDefaultInstance()) {
                this.action_ = ListDocuments.newBuilder((ListDocuments) this.action_).mergeFrom((ListDocuments.Builder) listDocuments).buildPartial();
            } else {
                this.action_ = listDocuments;
            }
            this.actionCase_ = 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void K1(Listen listen) {
            listen.getClass();
            if (this.actionCase_ == 12 && this.action_ != Listen.getDefaultInstance()) {
                this.action_ = Listen.newBuilder((Listen) this.action_).mergeFrom((Listen.Builder) listen).buildPartial();
            } else {
                this.action_ = listen;
            }
            this.actionCase_ = 12;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void L1(RemoveListen removeListen) {
            removeListen.getClass();
            if (this.actionCase_ == 13 && this.action_ != RemoveListen.getDefaultInstance()) {
                this.action_ = RemoveListen.newBuilder((RemoveListen) this.action_).mergeFrom((RemoveListen.Builder) removeListen).buildPartial();
            } else {
                this.action_ = removeListen;
            }
            this.actionCase_ = 13;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void M1(Rollback rollback) {
            rollback.getClass();
            if (this.actionCase_ == 8 && this.action_ != Rollback.getDefaultInstance()) {
                this.action_ = Rollback.newBuilder((Rollback) this.action_).mergeFrom((Rollback.Builder) rollback).buildPartial();
            } else {
                this.action_ = rollback;
            }
            this.actionCase_ = 8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void N1(RunQuery runQuery) {
            runQuery.getClass();
            if (this.actionCase_ == 11 && this.action_ != RunQuery.getDefaultInstance()) {
                this.action_ = RunQuery.newBuilder((RunQuery) this.action_).mergeFrom((RunQuery.Builder) runQuery).buildPartial();
            } else {
                this.action_ = runQuery;
            }
            this.actionCase_ = 11;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void O1(StatusProto statusProto) {
            statusProto.getClass();
            StatusProto statusProto2 = this.status_;
            if (statusProto2 != null && statusProto2 != StatusProto.getDefaultInstance()) {
                this.status_ = StatusProto.newBuilder(this.status_).mergeFrom((StatusProto.Builder) statusProto).buildPartial();
            } else {
                this.status_ = statusProto;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void P1(UpdateDocument updateDocument) {
            updateDocument.getClass();
            if (this.actionCase_ == 4 && this.action_ != UpdateDocument.getDefaultInstance()) {
                this.action_ = UpdateDocument.newBuilder((UpdateDocument) this.action_).mergeFrom((UpdateDocument.Builder) updateDocument).buildPartial();
            } else {
                this.action_ = updateDocument;
            }
            this.actionCase_ = 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Q1(int i4) {
            A1();
            this.matchingDocuments_.remove(i4);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void R1(BatchGetDocuments batchGetDocuments) {
            batchGetDocuments.getClass();
            this.action_ = batchGetDocuments;
            this.actionCase_ = 10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void S1(BeginTransaction beginTransaction) {
            beginTransaction.getClass();
            this.action_ = beginTransaction;
            this.actionCase_ = 6;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void T1(Commit commit) {
            commit.getClass();
            this.action_ = commit;
            this.actionCase_ = 7;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void U1(CreateDocument createDocument) {
            createDocument.getClass();
            this.action_ = createDocument;
            this.actionCase_ = 3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void V1(RunQuery runQuery) {
            runQuery.getClass();
            this.databaseContentsBeforeAction_ = runQuery;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void W1(DeleteDocument deleteDocument) {
            deleteDocument.getClass();
            this.action_ = deleteDocument;
            this.actionCase_ = 5;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void X1(GetDocument getDocument) {
            getDocument.getClass();
            this.action_ = getDocument;
            this.actionCase_ = 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Y1(ListCollectionIds listCollectionIds) {
            listCollectionIds.getClass();
            this.action_ = listCollectionIds;
            this.actionCase_ = 9;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Z1(ListDocuments listDocuments) {
            listDocuments.getClass();
            this.action_ = listDocuments;
            this.actionCase_ = 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a2(Listen listen) {
            listen.getClass();
            this.action_ = listen;
            this.actionCase_ = 12;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b2(int i4, MatchingDocuments matchingDocuments) {
            matchingDocuments.getClass();
            A1();
            this.matchingDocuments_.set(i4, matchingDocuments);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c2(RemoveListen removeListen) {
            removeListen.getClass();
            this.action_ = removeListen;
            this.actionCase_ = 13;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d2(Rollback rollback) {
            rollback.getClass();
            this.action_ = rollback;
            this.actionCase_ = 8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e2(RunQuery runQuery) {
            runQuery.getClass();
            this.action_ = runQuery;
            this.actionCase_ = 11;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void f2(StatusProto statusProto) {
            statusProto.getClass();
            this.status_ = statusProto;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g1(Iterable<? extends MatchingDocuments> iterable) {
            A1();
            AbstractMessageLite.a(iterable, this.matchingDocuments_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g2(UpdateDocument updateDocument) {
            updateDocument.getClass();
            this.action_ = updateDocument;
            this.actionCase_ = 4;
        }

        public static FirestoreV1Action getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void h1(int i4, MatchingDocuments matchingDocuments) {
            matchingDocuments.getClass();
            A1();
            this.matchingDocuments_.add(i4, matchingDocuments);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void i1(MatchingDocuments matchingDocuments) {
            matchingDocuments.getClass();
            A1();
            this.matchingDocuments_.add(matchingDocuments);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j1() {
            this.actionCase_ = 0;
            this.action_ = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void k1() {
            if (this.actionCase_ == 10) {
                this.actionCase_ = 0;
                this.action_ = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void l1() {
            if (this.actionCase_ == 6) {
                this.actionCase_ = 0;
                this.action_ = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void m1() {
            if (this.actionCase_ == 7) {
                this.actionCase_ = 0;
                this.action_ = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n1() {
            if (this.actionCase_ == 3) {
                this.actionCase_ = 0;
                this.action_ = null;
            }
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.q();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void o1() {
            this.databaseContentsBeforeAction_ = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void p1() {
            if (this.actionCase_ == 5) {
                this.actionCase_ = 0;
                this.action_ = null;
            }
        }

        public static FirestoreV1Action parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (FirestoreV1Action) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
        }

        public static FirestoreV1Action parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (FirestoreV1Action) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<FirestoreV1Action> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void q1() {
            if (this.actionCase_ == 1) {
                this.actionCase_ = 0;
                this.action_ = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void r1() {
            if (this.actionCase_ == 9) {
                this.actionCase_ = 0;
                this.action_ = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s1() {
            if (this.actionCase_ == 2) {
                this.actionCase_ = 0;
                this.action_ = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void t1() {
            if (this.actionCase_ == 12) {
                this.actionCase_ = 0;
                this.action_ = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void u1() {
            this.matchingDocuments_ = GeneratedMessageLite.y();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void v1() {
            if (this.actionCase_ == 13) {
                this.actionCase_ = 0;
                this.action_ = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void w1() {
            if (this.actionCase_ == 8) {
                this.actionCase_ = 0;
                this.action_ = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void x1() {
            if (this.actionCase_ == 11) {
                this.actionCase_ = 0;
                this.action_ = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void y1() {
            this.status_ = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void z1() {
            if (this.actionCase_ == 4) {
                this.actionCase_ = 0;
                this.action_ = null;
            }
        }

        @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1ActionOrBuilder
        public ActionCase getActionCase() {
            return ActionCase.forNumber(this.actionCase_);
        }

        @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1ActionOrBuilder
        public BatchGetDocuments getBatchGetDocuments() {
            if (this.actionCase_ == 10) {
                return (BatchGetDocuments) this.action_;
            }
            return BatchGetDocuments.getDefaultInstance();
        }

        @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1ActionOrBuilder
        public BeginTransaction getBeginTransaction() {
            if (this.actionCase_ == 6) {
                return (BeginTransaction) this.action_;
            }
            return BeginTransaction.getDefaultInstance();
        }

        @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1ActionOrBuilder
        public Commit getCommit() {
            if (this.actionCase_ == 7) {
                return (Commit) this.action_;
            }
            return Commit.getDefaultInstance();
        }

        @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1ActionOrBuilder
        public CreateDocument getCreateDocument() {
            if (this.actionCase_ == 3) {
                return (CreateDocument) this.action_;
            }
            return CreateDocument.getDefaultInstance();
        }

        @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1ActionOrBuilder
        public RunQuery getDatabaseContentsBeforeAction() {
            RunQuery runQuery = this.databaseContentsBeforeAction_;
            if (runQuery == null) {
                return RunQuery.getDefaultInstance();
            }
            return runQuery;
        }

        @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1ActionOrBuilder
        public DeleteDocument getDeleteDocument() {
            if (this.actionCase_ == 5) {
                return (DeleteDocument) this.action_;
            }
            return DeleteDocument.getDefaultInstance();
        }

        @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1ActionOrBuilder
        public GetDocument getGetDocument() {
            if (this.actionCase_ == 1) {
                return (GetDocument) this.action_;
            }
            return GetDocument.getDefaultInstance();
        }

        @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1ActionOrBuilder
        public ListCollectionIds getListCollectionIds() {
            if (this.actionCase_ == 9) {
                return (ListCollectionIds) this.action_;
            }
            return ListCollectionIds.getDefaultInstance();
        }

        @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1ActionOrBuilder
        public ListDocuments getListDocuments() {
            if (this.actionCase_ == 2) {
                return (ListDocuments) this.action_;
            }
            return ListDocuments.getDefaultInstance();
        }

        @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1ActionOrBuilder
        public Listen getListen() {
            if (this.actionCase_ == 12) {
                return (Listen) this.action_;
            }
            return Listen.getDefaultInstance();
        }

        @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1ActionOrBuilder
        public MatchingDocuments getMatchingDocuments(int i4) {
            return this.matchingDocuments_.get(i4);
        }

        @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1ActionOrBuilder
        public int getMatchingDocumentsCount() {
            return this.matchingDocuments_.size();
        }

        @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1ActionOrBuilder
        public List<MatchingDocuments> getMatchingDocumentsList() {
            return this.matchingDocuments_;
        }

        public MatchingDocumentsOrBuilder getMatchingDocumentsOrBuilder(int i4) {
            return this.matchingDocuments_.get(i4);
        }

        public List<? extends MatchingDocumentsOrBuilder> getMatchingDocumentsOrBuilderList() {
            return this.matchingDocuments_;
        }

        @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1ActionOrBuilder
        public RemoveListen getRemoveListen() {
            if (this.actionCase_ == 13) {
                return (RemoveListen) this.action_;
            }
            return RemoveListen.getDefaultInstance();
        }

        @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1ActionOrBuilder
        public Rollback getRollback() {
            if (this.actionCase_ == 8) {
                return (Rollback) this.action_;
            }
            return Rollback.getDefaultInstance();
        }

        @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1ActionOrBuilder
        public RunQuery getRunQuery() {
            if (this.actionCase_ == 11) {
                return (RunQuery) this.action_;
            }
            return RunQuery.getDefaultInstance();
        }

        @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1ActionOrBuilder
        public StatusProto getStatus() {
            StatusProto statusProto = this.status_;
            if (statusProto == null) {
                return StatusProto.getDefaultInstance();
            }
            return statusProto;
        }

        @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1ActionOrBuilder
        public UpdateDocument getUpdateDocument() {
            if (this.actionCase_ == 4) {
                return (UpdateDocument) this.action_;
            }
            return UpdateDocument.getDefaultInstance();
        }

        @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1ActionOrBuilder
        public boolean hasBatchGetDocuments() {
            if (this.actionCase_ == 10) {
                return true;
            }
            return false;
        }

        @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1ActionOrBuilder
        public boolean hasBeginTransaction() {
            if (this.actionCase_ == 6) {
                return true;
            }
            return false;
        }

        @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1ActionOrBuilder
        public boolean hasCommit() {
            if (this.actionCase_ == 7) {
                return true;
            }
            return false;
        }

        @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1ActionOrBuilder
        public boolean hasCreateDocument() {
            if (this.actionCase_ == 3) {
                return true;
            }
            return false;
        }

        @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1ActionOrBuilder
        public boolean hasDatabaseContentsBeforeAction() {
            if (this.databaseContentsBeforeAction_ != null) {
                return true;
            }
            return false;
        }

        @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1ActionOrBuilder
        public boolean hasDeleteDocument() {
            if (this.actionCase_ == 5) {
                return true;
            }
            return false;
        }

        @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1ActionOrBuilder
        public boolean hasGetDocument() {
            if (this.actionCase_ == 1) {
                return true;
            }
            return false;
        }

        @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1ActionOrBuilder
        public boolean hasListCollectionIds() {
            if (this.actionCase_ == 9) {
                return true;
            }
            return false;
        }

        @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1ActionOrBuilder
        public boolean hasListDocuments() {
            if (this.actionCase_ == 2) {
                return true;
            }
            return false;
        }

        @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1ActionOrBuilder
        public boolean hasListen() {
            if (this.actionCase_ == 12) {
                return true;
            }
            return false;
        }

        @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1ActionOrBuilder
        public boolean hasRemoveListen() {
            if (this.actionCase_ == 13) {
                return true;
            }
            return false;
        }

        @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1ActionOrBuilder
        public boolean hasRollback() {
            if (this.actionCase_ == 8) {
                return true;
            }
            return false;
        }

        @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1ActionOrBuilder
        public boolean hasRunQuery() {
            if (this.actionCase_ == 11) {
                return true;
            }
            return false;
        }

        @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1ActionOrBuilder
        public boolean hasStatus() {
            if (this.status_ != null) {
                return true;
            }
            return false;
        }

        @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.FirestoreV1ActionOrBuilder
        public boolean hasUpdateDocument() {
            if (this.actionCase_ == 4) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (AnonymousClass1.f26254a[methodToInvoke.ordinal()]) {
                case 1:
                    return new FirestoreV1Action();
                case 2:
                    return new Builder(null);
                case 3:
                    return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0010\u0001\u0000\u0001Ë\u0010\u0000\u0001\u0000\u0001<\u0000\u0002<\u0000\u0003<\u0000\u0004<\u0000\u0005<\u0000\u0006<\u0000\u0007<\u0000\b<\u0000\t<\u0000\n<\u0000\u000b<\u0000\f<\u0000\r<\u0000É\tÊ\tË\u001b", new Object[]{"action_", "actionCase_", GetDocument.class, ListDocuments.class, CreateDocument.class, UpdateDocument.class, DeleteDocument.class, BeginTransaction.class, Commit.class, Rollback.class, ListCollectionIds.class, BatchGetDocuments.class, RunQuery.class, Listen.class, RemoveListen.class, "status_", "databaseContentsBeforeAction_", "matchingDocuments_", MatchingDocuments.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<FirestoreV1Action> parser = PARSER;
                    if (parser == null) {
                        synchronized (FirestoreV1Action.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static Builder newBuilder(FirestoreV1Action firestoreV1Action) {
            return DEFAULT_INSTANCE.r(firestoreV1Action);
        }

        public static FirestoreV1Action parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (FirestoreV1Action) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static FirestoreV1Action parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (FirestoreV1Action) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static FirestoreV1Action parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (FirestoreV1Action) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
        }

        public static FirestoreV1Action parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (FirestoreV1Action) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static FirestoreV1Action parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (FirestoreV1Action) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
        }

        public static FirestoreV1Action parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (FirestoreV1Action) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static FirestoreV1Action parseFrom(InputStream inputStream) throws IOException {
            return (FirestoreV1Action) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
        }

        public static FirestoreV1Action parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (FirestoreV1Action) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static FirestoreV1Action parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (FirestoreV1Action) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
        }

        public static FirestoreV1Action parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (FirestoreV1Action) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: classes5.dex */
    public interface FirestoreV1ActionOrBuilder extends MessageLiteOrBuilder {
        FirestoreV1Action.ActionCase getActionCase();

        FirestoreV1Action.BatchGetDocuments getBatchGetDocuments();

        FirestoreV1Action.BeginTransaction getBeginTransaction();

        FirestoreV1Action.Commit getCommit();

        FirestoreV1Action.CreateDocument getCreateDocument();

        FirestoreV1Action.RunQuery getDatabaseContentsBeforeAction();

        FirestoreV1Action.DeleteDocument getDeleteDocument();

        FirestoreV1Action.GetDocument getGetDocument();

        FirestoreV1Action.ListCollectionIds getListCollectionIds();

        FirestoreV1Action.ListDocuments getListDocuments();

        FirestoreV1Action.Listen getListen();

        FirestoreV1Action.MatchingDocuments getMatchingDocuments(int i4);

        int getMatchingDocumentsCount();

        List<FirestoreV1Action.MatchingDocuments> getMatchingDocumentsList();

        FirestoreV1Action.RemoveListen getRemoveListen();

        FirestoreV1Action.Rollback getRollback();

        FirestoreV1Action.RunQuery getRunQuery();

        StatusProto getStatus();

        FirestoreV1Action.UpdateDocument getUpdateDocument();

        boolean hasBatchGetDocuments();

        boolean hasBeginTransaction();

        boolean hasCommit();

        boolean hasCreateDocument();

        boolean hasDatabaseContentsBeforeAction();

        boolean hasDeleteDocument();

        boolean hasGetDocument();

        boolean hasListCollectionIds();

        boolean hasListDocuments();

        boolean hasListen();

        boolean hasRemoveListen();

        boolean hasRollback();

        boolean hasRunQuery();

        boolean hasStatus();

        boolean hasUpdateDocument();
    }

    /* loaded from: classes5.dex */
    public static final class ParallelTestTrace extends GeneratedMessageLite<ParallelTestTrace, Builder> implements ParallelTestTraceOrBuilder {
        private static final ParallelTestTrace DEFAULT_INSTANCE;
        private static volatile Parser<ParallelTestTrace> PARSER = null;
        public static final int TEST_TRACE_FIELD_NUMBER = 1;
        private TestTrace testTrace_;

        /* loaded from: classes5.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<ParallelTestTrace, Builder> implements ParallelTestTraceOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearTestTrace() {
                f();
                ((ParallelTestTrace) this.f33398b).j0();
                return this;
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.ParallelTestTraceOrBuilder
            public TestTrace getTestTrace() {
                return ((ParallelTestTrace) this.f33398b).getTestTrace();
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.ParallelTestTraceOrBuilder
            public boolean hasTestTrace() {
                return ((ParallelTestTrace) this.f33398b).hasTestTrace();
            }

            public Builder mergeTestTrace(TestTrace testTrace) {
                f();
                ((ParallelTestTrace) this.f33398b).k0(testTrace);
                return this;
            }

            public Builder setTestTrace(TestTrace testTrace) {
                f();
                ((ParallelTestTrace) this.f33398b).l0(testTrace);
                return this;
            }

            private Builder() {
                super(ParallelTestTrace.DEFAULT_INSTANCE);
            }

            public Builder setTestTrace(TestTrace.Builder builder) {
                f();
                ((ParallelTestTrace) this.f33398b).l0(builder.build());
                return this;
            }
        }

        static {
            ParallelTestTrace parallelTestTrace = new ParallelTestTrace();
            DEFAULT_INSTANCE = parallelTestTrace;
            GeneratedMessageLite.d0(ParallelTestTrace.class, parallelTestTrace);
        }

        private ParallelTestTrace() {
        }

        public static ParallelTestTrace getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j0() {
            this.testTrace_ = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void k0(TestTrace testTrace) {
            testTrace.getClass();
            TestTrace testTrace2 = this.testTrace_;
            if (testTrace2 != null && testTrace2 != TestTrace.getDefaultInstance()) {
                this.testTrace_ = TestTrace.newBuilder(this.testTrace_).mergeFrom((TestTrace.Builder) testTrace).buildPartial();
            } else {
                this.testTrace_ = testTrace;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void l0(TestTrace testTrace) {
            testTrace.getClass();
            this.testTrace_ = testTrace;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.q();
        }

        public static ParallelTestTrace parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ParallelTestTrace) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
        }

        public static ParallelTestTrace parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (ParallelTestTrace) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<ParallelTestTrace> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.ParallelTestTraceOrBuilder
        public TestTrace getTestTrace() {
            TestTrace testTrace = this.testTrace_;
            if (testTrace == null) {
                return TestTrace.getDefaultInstance();
            }
            return testTrace;
        }

        @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.ParallelTestTraceOrBuilder
        public boolean hasTestTrace() {
            if (this.testTrace_ != null) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (AnonymousClass1.f26254a[methodToInvoke.ordinal()]) {
                case 1:
                    return new ParallelTestTrace();
                case 2:
                    return new Builder(null);
                case 3:
                    return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\t", new Object[]{"testTrace_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ParallelTestTrace> parser = PARSER;
                    if (parser == null) {
                        synchronized (ParallelTestTrace.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static Builder newBuilder(ParallelTestTrace parallelTestTrace) {
            return DEFAULT_INSTANCE.r(parallelTestTrace);
        }

        public static ParallelTestTrace parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ParallelTestTrace) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ParallelTestTrace parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ParallelTestTrace) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ParallelTestTrace parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (ParallelTestTrace) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
        }

        public static ParallelTestTrace parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ParallelTestTrace) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ParallelTestTrace parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ParallelTestTrace) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
        }

        public static ParallelTestTrace parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ParallelTestTrace) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ParallelTestTrace parseFrom(InputStream inputStream) throws IOException {
            return (ParallelTestTrace) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
        }

        public static ParallelTestTrace parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ParallelTestTrace) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ParallelTestTrace parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ParallelTestTrace) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ParallelTestTrace parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ParallelTestTrace) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: classes5.dex */
    public interface ParallelTestTraceOrBuilder extends MessageLiteOrBuilder {
        TestTrace getTestTrace();

        boolean hasTestTrace();
    }

    /* loaded from: classes5.dex */
    public static final class StatusProto extends GeneratedMessageLite<StatusProto, Builder> implements StatusProtoOrBuilder {
        public static final int CANONICAL_CODE_FIELD_NUMBER = 6;
        public static final int CODE_FIELD_NUMBER = 1;
        private static final StatusProto DEFAULT_INSTANCE;
        public static final int MESSAGE_FIELD_NUMBER = 3;
        private static volatile Parser<StatusProto> PARSER = null;
        public static final int SPACE_FIELD_NUMBER = 2;
        private int canonicalCode_;
        private int code_;
        private String space_ = "";
        private String message_ = "";

        /* loaded from: classes5.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<StatusProto, Builder> implements StatusProtoOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearCanonicalCode() {
                f();
                ((StatusProto) this.f33398b).q0();
                return this;
            }

            public Builder clearCode() {
                f();
                ((StatusProto) this.f33398b).r0();
                return this;
            }

            public Builder clearMessage() {
                f();
                ((StatusProto) this.f33398b).s0();
                return this;
            }

            public Builder clearSpace() {
                f();
                ((StatusProto) this.f33398b).t0();
                return this;
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.StatusProtoOrBuilder
            public int getCanonicalCode() {
                return ((StatusProto) this.f33398b).getCanonicalCode();
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.StatusProtoOrBuilder
            public int getCode() {
                return ((StatusProto) this.f33398b).getCode();
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.StatusProtoOrBuilder
            public String getMessage() {
                return ((StatusProto) this.f33398b).getMessage();
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.StatusProtoOrBuilder
            public ByteString getMessageBytes() {
                return ((StatusProto) this.f33398b).getMessageBytes();
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.StatusProtoOrBuilder
            public String getSpace() {
                return ((StatusProto) this.f33398b).getSpace();
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.StatusProtoOrBuilder
            public ByteString getSpaceBytes() {
                return ((StatusProto) this.f33398b).getSpaceBytes();
            }

            public Builder setCanonicalCode(int i4) {
                f();
                ((StatusProto) this.f33398b).u0(i4);
                return this;
            }

            public Builder setCode(int i4) {
                f();
                ((StatusProto) this.f33398b).v0(i4);
                return this;
            }

            public Builder setMessage(String str) {
                f();
                ((StatusProto) this.f33398b).w0(str);
                return this;
            }

            public Builder setMessageBytes(ByteString byteString) {
                f();
                ((StatusProto) this.f33398b).x0(byteString);
                return this;
            }

            public Builder setSpace(String str) {
                f();
                ((StatusProto) this.f33398b).y0(str);
                return this;
            }

            public Builder setSpaceBytes(ByteString byteString) {
                f();
                ((StatusProto) this.f33398b).z0(byteString);
                return this;
            }

            private Builder() {
                super(StatusProto.DEFAULT_INSTANCE);
            }
        }

        static {
            StatusProto statusProto = new StatusProto();
            DEFAULT_INSTANCE = statusProto;
            GeneratedMessageLite.d0(StatusProto.class, statusProto);
        }

        private StatusProto() {
        }

        public static StatusProto getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.q();
        }

        public static StatusProto parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (StatusProto) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
        }

        public static StatusProto parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (StatusProto) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<StatusProto> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void q0() {
            this.canonicalCode_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void r0() {
            this.code_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s0() {
            this.message_ = getDefaultInstance().getMessage();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void t0() {
            this.space_ = getDefaultInstance().getSpace();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void u0(int i4) {
            this.canonicalCode_ = i4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void v0(int i4) {
            this.code_ = i4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void w0(String str) {
            str.getClass();
            this.message_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void x0(ByteString byteString) {
            AbstractMessageLite.b(byteString);
            this.message_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void y0(String str) {
            str.getClass();
            this.space_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void z0(ByteString byteString) {
            AbstractMessageLite.b(byteString);
            this.space_ = byteString.toStringUtf8();
        }

        @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.StatusProtoOrBuilder
        public int getCanonicalCode() {
            return this.canonicalCode_;
        }

        @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.StatusProtoOrBuilder
        public int getCode() {
            return this.code_;
        }

        @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.StatusProtoOrBuilder
        public String getMessage() {
            return this.message_;
        }

        @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.StatusProtoOrBuilder
        public ByteString getMessageBytes() {
            return ByteString.copyFromUtf8(this.message_);
        }

        @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.StatusProtoOrBuilder
        public String getSpace() {
            return this.space_;
        }

        @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.StatusProtoOrBuilder
        public ByteString getSpaceBytes() {
            return ByteString.copyFromUtf8(this.space_);
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (AnonymousClass1.f26254a[methodToInvoke.ordinal()]) {
                case 1:
                    return new StatusProto();
                case 2:
                    return new Builder(null);
                case 3:
                    return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0006\u0004\u0000\u0000\u0000\u0001\u0004\u0002Ȉ\u0003Ȉ\u0006\u0004", new Object[]{"code_", "space_", "message_", "canonicalCode_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<StatusProto> parser = PARSER;
                    if (parser == null) {
                        synchronized (StatusProto.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static Builder newBuilder(StatusProto statusProto) {
            return DEFAULT_INSTANCE.r(statusProto);
        }

        public static StatusProto parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StatusProto) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static StatusProto parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (StatusProto) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static StatusProto parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (StatusProto) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
        }

        public static StatusProto parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (StatusProto) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static StatusProto parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (StatusProto) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
        }

        public static StatusProto parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (StatusProto) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static StatusProto parseFrom(InputStream inputStream) throws IOException {
            return (StatusProto) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
        }

        public static StatusProto parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StatusProto) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static StatusProto parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (StatusProto) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
        }

        public static StatusProto parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (StatusProto) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: classes5.dex */
    public interface StatusProtoOrBuilder extends MessageLiteOrBuilder {
        int getCanonicalCode();

        int getCode();

        String getMessage();

        ByteString getMessageBytes();

        String getSpace();

        ByteString getSpaceBytes();
    }

    /* loaded from: classes5.dex */
    public static final class TestTrace extends GeneratedMessageLite<TestTrace, Builder> implements TestTraceOrBuilder {
        public static final int ACTION_FIELD_NUMBER = 2;
        private static final TestTrace DEFAULT_INSTANCE;
        private static volatile Parser<TestTrace> PARSER = null;
        public static final int TRACE_DESCRIPTION_FIELD_NUMBER = 3;
        public static final int TRACE_ID_FIELD_NUMBER = 1;
        private String traceId_ = "";
        private Internal.ProtobufList<DatastoreAction> action_ = GeneratedMessageLite.y();
        private String traceDescription_ = "";

        /* loaded from: classes5.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<TestTrace, Builder> implements TestTraceOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder addAction(DatastoreAction datastoreAction) {
                f();
                ((TestTrace) this.f33398b).t0(datastoreAction);
                return this;
            }

            public Builder addAllAction(Iterable<? extends DatastoreAction> iterable) {
                f();
                ((TestTrace) this.f33398b).u0(iterable);
                return this;
            }

            public Builder clearAction() {
                f();
                ((TestTrace) this.f33398b).v0();
                return this;
            }

            public Builder clearTraceDescription() {
                f();
                ((TestTrace) this.f33398b).w0();
                return this;
            }

            public Builder clearTraceId() {
                f();
                ((TestTrace) this.f33398b).x0();
                return this;
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.TestTraceOrBuilder
            public DatastoreAction getAction(int i4) {
                return ((TestTrace) this.f33398b).getAction(i4);
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.TestTraceOrBuilder
            public int getActionCount() {
                return ((TestTrace) this.f33398b).getActionCount();
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.TestTraceOrBuilder
            public List<DatastoreAction> getActionList() {
                return Collections.unmodifiableList(((TestTrace) this.f33398b).getActionList());
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.TestTraceOrBuilder
            public String getTraceDescription() {
                return ((TestTrace) this.f33398b).getTraceDescription();
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.TestTraceOrBuilder
            public ByteString getTraceDescriptionBytes() {
                return ((TestTrace) this.f33398b).getTraceDescriptionBytes();
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.TestTraceOrBuilder
            public String getTraceId() {
                return ((TestTrace) this.f33398b).getTraceId();
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.TestTraceOrBuilder
            public ByteString getTraceIdBytes() {
                return ((TestTrace) this.f33398b).getTraceIdBytes();
            }

            public Builder removeAction(int i4) {
                f();
                ((TestTrace) this.f33398b).z0(i4);
                return this;
            }

            public Builder setAction(int i4, DatastoreAction datastoreAction) {
                f();
                ((TestTrace) this.f33398b).A0(i4, datastoreAction);
                return this;
            }

            public Builder setTraceDescription(String str) {
                f();
                ((TestTrace) this.f33398b).B0(str);
                return this;
            }

            public Builder setTraceDescriptionBytes(ByteString byteString) {
                f();
                ((TestTrace) this.f33398b).C0(byteString);
                return this;
            }

            public Builder setTraceId(String str) {
                f();
                ((TestTrace) this.f33398b).D0(str);
                return this;
            }

            public Builder setTraceIdBytes(ByteString byteString) {
                f();
                ((TestTrace) this.f33398b).E0(byteString);
                return this;
            }

            private Builder() {
                super(TestTrace.DEFAULT_INSTANCE);
            }

            public Builder addAction(int i4, DatastoreAction datastoreAction) {
                f();
                ((TestTrace) this.f33398b).s0(i4, datastoreAction);
                return this;
            }

            public Builder setAction(int i4, DatastoreAction.Builder builder) {
                f();
                ((TestTrace) this.f33398b).A0(i4, builder.build());
                return this;
            }

            public Builder addAction(DatastoreAction.Builder builder) {
                f();
                ((TestTrace) this.f33398b).t0(builder.build());
                return this;
            }

            public Builder addAction(int i4, DatastoreAction.Builder builder) {
                f();
                ((TestTrace) this.f33398b).s0(i4, builder.build());
                return this;
            }
        }

        static {
            TestTrace testTrace = new TestTrace();
            DEFAULT_INSTANCE = testTrace;
            GeneratedMessageLite.d0(TestTrace.class, testTrace);
        }

        private TestTrace() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void A0(int i4, DatastoreAction datastoreAction) {
            datastoreAction.getClass();
            y0();
            this.action_.set(i4, datastoreAction);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void B0(String str) {
            str.getClass();
            this.traceDescription_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void C0(ByteString byteString) {
            AbstractMessageLite.b(byteString);
            this.traceDescription_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void D0(String str) {
            str.getClass();
            this.traceId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void E0(ByteString byteString) {
            AbstractMessageLite.b(byteString);
            this.traceId_ = byteString.toStringUtf8();
        }

        public static TestTrace getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.q();
        }

        public static TestTrace parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (TestTrace) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
        }

        public static TestTrace parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (TestTrace) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<TestTrace> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s0(int i4, DatastoreAction datastoreAction) {
            datastoreAction.getClass();
            y0();
            this.action_.add(i4, datastoreAction);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void t0(DatastoreAction datastoreAction) {
            datastoreAction.getClass();
            y0();
            this.action_.add(datastoreAction);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void u0(Iterable<? extends DatastoreAction> iterable) {
            y0();
            AbstractMessageLite.a(iterable, this.action_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void v0() {
            this.action_ = GeneratedMessageLite.y();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void w0() {
            this.traceDescription_ = getDefaultInstance().getTraceDescription();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void x0() {
            this.traceId_ = getDefaultInstance().getTraceId();
        }

        private void y0() {
            Internal.ProtobufList<DatastoreAction> protobufList = this.action_;
            if (!protobufList.isModifiable()) {
                this.action_ = GeneratedMessageLite.K(protobufList);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void z0(int i4) {
            y0();
            this.action_.remove(i4);
        }

        @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.TestTraceOrBuilder
        public DatastoreAction getAction(int i4) {
            return this.action_.get(i4);
        }

        @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.TestTraceOrBuilder
        public int getActionCount() {
            return this.action_.size();
        }

        @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.TestTraceOrBuilder
        public List<DatastoreAction> getActionList() {
            return this.action_;
        }

        public DatastoreActionOrBuilder getActionOrBuilder(int i4) {
            return this.action_.get(i4);
        }

        public List<? extends DatastoreActionOrBuilder> getActionOrBuilderList() {
            return this.action_;
        }

        @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.TestTraceOrBuilder
        public String getTraceDescription() {
            return this.traceDescription_;
        }

        @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.TestTraceOrBuilder
        public ByteString getTraceDescriptionBytes() {
            return ByteString.copyFromUtf8(this.traceDescription_);
        }

        @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.TestTraceOrBuilder
        public String getTraceId() {
            return this.traceId_;
        }

        @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.TestTraceOrBuilder
        public ByteString getTraceIdBytes() {
            return ByteString.copyFromUtf8(this.traceId_);
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (AnonymousClass1.f26254a[methodToInvoke.ordinal()]) {
                case 1:
                    return new TestTrace();
                case 2:
                    return new Builder(null);
                case 3:
                    return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0001\u0000\u0001Ȉ\u0002\u001b\u0003Ȉ", new Object[]{"traceId_", "action_", DatastoreAction.class, "traceDescription_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<TestTrace> parser = PARSER;
                    if (parser == null) {
                        synchronized (TestTrace.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static Builder newBuilder(TestTrace testTrace) {
            return DEFAULT_INSTANCE.r(testTrace);
        }

        public static TestTrace parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (TestTrace) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static TestTrace parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (TestTrace) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static TestTrace parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (TestTrace) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
        }

        public static TestTrace parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (TestTrace) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static TestTrace parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (TestTrace) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
        }

        public static TestTrace parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (TestTrace) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static TestTrace parseFrom(InputStream inputStream) throws IOException {
            return (TestTrace) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
        }

        public static TestTrace parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (TestTrace) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static TestTrace parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (TestTrace) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
        }

        public static TestTrace parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (TestTrace) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: classes5.dex */
    public interface TestTraceOrBuilder extends MessageLiteOrBuilder {
        DatastoreAction getAction(int i4);

        int getActionCount();

        List<DatastoreAction> getActionList();

        String getTraceDescription();

        ByteString getTraceDescriptionBytes();

        String getTraceId();

        ByteString getTraceIdBytes();
    }

    /* loaded from: classes5.dex */
    public static final class TimelineTestTrace extends GeneratedMessageLite<TimelineTestTrace, Builder> implements TimelineTestTraceOrBuilder {
        private static final TimelineTestTrace DEFAULT_INSTANCE;
        private static volatile Parser<TimelineTestTrace> PARSER = null;
        public static final int TEST_TRACE_FIELD_NUMBER = 1;
        private TestTrace testTrace_;

        /* loaded from: classes5.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<TimelineTestTrace, Builder> implements TimelineTestTraceOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearTestTrace() {
                f();
                ((TimelineTestTrace) this.f33398b).j0();
                return this;
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.TimelineTestTraceOrBuilder
            public TestTrace getTestTrace() {
                return ((TimelineTestTrace) this.f33398b).getTestTrace();
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.TimelineTestTraceOrBuilder
            public boolean hasTestTrace() {
                return ((TimelineTestTrace) this.f33398b).hasTestTrace();
            }

            public Builder mergeTestTrace(TestTrace testTrace) {
                f();
                ((TimelineTestTrace) this.f33398b).k0(testTrace);
                return this;
            }

            public Builder setTestTrace(TestTrace testTrace) {
                f();
                ((TimelineTestTrace) this.f33398b).l0(testTrace);
                return this;
            }

            private Builder() {
                super(TimelineTestTrace.DEFAULT_INSTANCE);
            }

            public Builder setTestTrace(TestTrace.Builder builder) {
                f();
                ((TimelineTestTrace) this.f33398b).l0(builder.build());
                return this;
            }
        }

        static {
            TimelineTestTrace timelineTestTrace = new TimelineTestTrace();
            DEFAULT_INSTANCE = timelineTestTrace;
            GeneratedMessageLite.d0(TimelineTestTrace.class, timelineTestTrace);
        }

        private TimelineTestTrace() {
        }

        public static TimelineTestTrace getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j0() {
            this.testTrace_ = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void k0(TestTrace testTrace) {
            testTrace.getClass();
            TestTrace testTrace2 = this.testTrace_;
            if (testTrace2 != null && testTrace2 != TestTrace.getDefaultInstance()) {
                this.testTrace_ = TestTrace.newBuilder(this.testTrace_).mergeFrom((TestTrace.Builder) testTrace).buildPartial();
            } else {
                this.testTrace_ = testTrace;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void l0(TestTrace testTrace) {
            testTrace.getClass();
            this.testTrace_ = testTrace;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.q();
        }

        public static TimelineTestTrace parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (TimelineTestTrace) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
        }

        public static TimelineTestTrace parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (TimelineTestTrace) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<TimelineTestTrace> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.TimelineTestTraceOrBuilder
        public TestTrace getTestTrace() {
            TestTrace testTrace = this.testTrace_;
            if (testTrace == null) {
                return TestTrace.getDefaultInstance();
            }
            return testTrace;
        }

        @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.TimelineTestTraceOrBuilder
        public boolean hasTestTrace() {
            if (this.testTrace_ != null) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (AnonymousClass1.f26254a[methodToInvoke.ordinal()]) {
                case 1:
                    return new TimelineTestTrace();
                case 2:
                    return new Builder(null);
                case 3:
                    return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\t", new Object[]{"testTrace_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<TimelineTestTrace> parser = PARSER;
                    if (parser == null) {
                        synchronized (TimelineTestTrace.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static Builder newBuilder(TimelineTestTrace timelineTestTrace) {
            return DEFAULT_INSTANCE.r(timelineTestTrace);
        }

        public static TimelineTestTrace parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (TimelineTestTrace) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static TimelineTestTrace parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (TimelineTestTrace) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static TimelineTestTrace parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (TimelineTestTrace) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
        }

        public static TimelineTestTrace parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (TimelineTestTrace) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static TimelineTestTrace parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (TimelineTestTrace) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
        }

        public static TimelineTestTrace parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (TimelineTestTrace) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static TimelineTestTrace parseFrom(InputStream inputStream) throws IOException {
            return (TimelineTestTrace) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
        }

        public static TimelineTestTrace parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (TimelineTestTrace) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static TimelineTestTrace parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (TimelineTestTrace) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
        }

        public static TimelineTestTrace parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (TimelineTestTrace) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: classes5.dex */
    public interface TimelineTestTraceOrBuilder extends MessageLiteOrBuilder {
        TestTrace getTestTrace();

        boolean hasTestTrace();
    }

    /* loaded from: classes5.dex */
    public static final class ValidationRule extends GeneratedMessageLite<ValidationRule, Builder> implements ValidationRuleOrBuilder {
        private static final ValidationRule DEFAULT_INSTANCE;
        private static volatile Parser<ValidationRule> PARSER = null;
        public static final int VALIDATE_QUERY_INDEXES_FIELD_NUMBER = 2;
        public static final int VALIDATE_QUERY_RESULT_ORDER_FIELD_NUMBER = 1;
        private boolean validateQueryIndexes_;
        private boolean validateQueryResultOrder_;

        /* loaded from: classes5.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<ValidationRule, Builder> implements ValidationRuleOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearValidateQueryIndexes() {
                f();
                ((ValidationRule) this.f33398b).k0();
                return this;
            }

            public Builder clearValidateQueryResultOrder() {
                f();
                ((ValidationRule) this.f33398b).l0();
                return this;
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.ValidationRuleOrBuilder
            public boolean getValidateQueryIndexes() {
                return ((ValidationRule) this.f33398b).getValidateQueryIndexes();
            }

            @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.ValidationRuleOrBuilder
            public boolean getValidateQueryResultOrder() {
                return ((ValidationRule) this.f33398b).getValidateQueryResultOrder();
            }

            public Builder setValidateQueryIndexes(boolean z3) {
                f();
                ((ValidationRule) this.f33398b).m0(z3);
                return this;
            }

            public Builder setValidateQueryResultOrder(boolean z3) {
                f();
                ((ValidationRule) this.f33398b).n0(z3);
                return this;
            }

            private Builder() {
                super(ValidationRule.DEFAULT_INSTANCE);
            }
        }

        static {
            ValidationRule validationRule = new ValidationRule();
            DEFAULT_INSTANCE = validationRule;
            GeneratedMessageLite.d0(ValidationRule.class, validationRule);
        }

        private ValidationRule() {
        }

        public static ValidationRule getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void k0() {
            this.validateQueryIndexes_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void l0() {
            this.validateQueryResultOrder_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void m0(boolean z3) {
            this.validateQueryIndexes_ = z3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n0(boolean z3) {
            this.validateQueryResultOrder_ = z3;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.q();
        }

        public static ValidationRule parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ValidationRule) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
        }

        public static ValidationRule parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (ValidationRule) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<ValidationRule> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.ValidationRuleOrBuilder
        public boolean getValidateQueryIndexes() {
            return this.validateQueryIndexes_;
        }

        @Override // com.google.apphosting.datastore.testing.DatastoreTestTrace.ValidationRuleOrBuilder
        public boolean getValidateQueryResultOrder() {
            return this.validateQueryResultOrder_;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (AnonymousClass1.f26254a[methodToInvoke.ordinal()]) {
                case 1:
                    return new ValidationRule();
                case 2:
                    return new Builder(null);
                case 3:
                    return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0007\u0002\u0007", new Object[]{"validateQueryResultOrder_", "validateQueryIndexes_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ValidationRule> parser = PARSER;
                    if (parser == null) {
                        synchronized (ValidationRule.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static Builder newBuilder(ValidationRule validationRule) {
            return DEFAULT_INSTANCE.r(validationRule);
        }

        public static ValidationRule parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ValidationRule) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ValidationRule parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ValidationRule) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ValidationRule parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (ValidationRule) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
        }

        public static ValidationRule parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ValidationRule) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ValidationRule parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ValidationRule) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
        }

        public static ValidationRule parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ValidationRule) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ValidationRule parseFrom(InputStream inputStream) throws IOException {
            return (ValidationRule) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
        }

        public static ValidationRule parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ValidationRule) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ValidationRule parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ValidationRule) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ValidationRule parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ValidationRule) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: classes5.dex */
    public interface ValidationRuleOrBuilder extends MessageLiteOrBuilder {
        boolean getValidateQueryIndexes();

        boolean getValidateQueryResultOrder();
    }

    private DatastoreTestTrace() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}
