package com.google.firestore.v1;

import com.google.firestore.v1.WriteResult;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: classes5.dex */
public final class CommitResponse extends GeneratedMessageLite<CommitResponse, Builder> implements CommitResponseOrBuilder {
    public static final int COMMIT_TIME_FIELD_NUMBER = 2;
    private static final CommitResponse DEFAULT_INSTANCE;
    private static volatile Parser<CommitResponse> PARSER = null;
    public static final int WRITE_RESULTS_FIELD_NUMBER = 1;
    private Timestamp commitTime_;
    private Internal.ProtobufList<WriteResult> writeResults_ = GeneratedMessageLite.y();

    /* renamed from: com.google.firestore.v1.CommitResponse$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f32445a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f32445a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32445a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32445a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32445a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f32445a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f32445a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f32445a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<CommitResponse, Builder> implements CommitResponseOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllWriteResults(Iterable<? extends WriteResult> iterable) {
            f();
            ((CommitResponse) this.f33398b).p0(iterable);
            return this;
        }

        public Builder addWriteResults(WriteResult writeResult) {
            f();
            ((CommitResponse) this.f33398b).r0(writeResult);
            return this;
        }

        public Builder clearCommitTime() {
            f();
            ((CommitResponse) this.f33398b).s0();
            return this;
        }

        public Builder clearWriteResults() {
            f();
            ((CommitResponse) this.f33398b).t0();
            return this;
        }

        @Override // com.google.firestore.v1.CommitResponseOrBuilder
        public Timestamp getCommitTime() {
            return ((CommitResponse) this.f33398b).getCommitTime();
        }

        @Override // com.google.firestore.v1.CommitResponseOrBuilder
        public WriteResult getWriteResults(int i4) {
            return ((CommitResponse) this.f33398b).getWriteResults(i4);
        }

        @Override // com.google.firestore.v1.CommitResponseOrBuilder
        public int getWriteResultsCount() {
            return ((CommitResponse) this.f33398b).getWriteResultsCount();
        }

        @Override // com.google.firestore.v1.CommitResponseOrBuilder
        public List<WriteResult> getWriteResultsList() {
            return Collections.unmodifiableList(((CommitResponse) this.f33398b).getWriteResultsList());
        }

        @Override // com.google.firestore.v1.CommitResponseOrBuilder
        public boolean hasCommitTime() {
            return ((CommitResponse) this.f33398b).hasCommitTime();
        }

        public Builder mergeCommitTime(Timestamp timestamp) {
            f();
            ((CommitResponse) this.f33398b).v0(timestamp);
            return this;
        }

        public Builder removeWriteResults(int i4) {
            f();
            ((CommitResponse) this.f33398b).w0(i4);
            return this;
        }

        public Builder setCommitTime(Timestamp timestamp) {
            f();
            ((CommitResponse) this.f33398b).x0(timestamp);
            return this;
        }

        public Builder setWriteResults(int i4, WriteResult writeResult) {
            f();
            ((CommitResponse) this.f33398b).y0(i4, writeResult);
            return this;
        }

        private Builder() {
            super(CommitResponse.DEFAULT_INSTANCE);
        }

        public Builder addWriteResults(int i4, WriteResult writeResult) {
            f();
            ((CommitResponse) this.f33398b).q0(i4, writeResult);
            return this;
        }

        public Builder setCommitTime(Timestamp.Builder builder) {
            f();
            ((CommitResponse) this.f33398b).x0(builder.build());
            return this;
        }

        public Builder setWriteResults(int i4, WriteResult.Builder builder) {
            f();
            ((CommitResponse) this.f33398b).y0(i4, builder.build());
            return this;
        }

        public Builder addWriteResults(WriteResult.Builder builder) {
            f();
            ((CommitResponse) this.f33398b).r0(builder.build());
            return this;
        }

        public Builder addWriteResults(int i4, WriteResult.Builder builder) {
            f();
            ((CommitResponse) this.f33398b).q0(i4, builder.build());
            return this;
        }
    }

    static {
        CommitResponse commitResponse = new CommitResponse();
        DEFAULT_INSTANCE = commitResponse;
        GeneratedMessageLite.d0(CommitResponse.class, commitResponse);
    }

    private CommitResponse() {
    }

    public static CommitResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p0(Iterable<? extends WriteResult> iterable) {
        u0();
        AbstractMessageLite.a(iterable, this.writeResults_);
    }

    public static CommitResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (CommitResponse) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
    }

    public static CommitResponse parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (CommitResponse) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<CommitResponse> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q0(int i4, WriteResult writeResult) {
        writeResult.getClass();
        u0();
        this.writeResults_.add(i4, writeResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0(WriteResult writeResult) {
        writeResult.getClass();
        u0();
        this.writeResults_.add(writeResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0() {
        this.commitTime_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t0() {
        this.writeResults_ = GeneratedMessageLite.y();
    }

    private void u0() {
        Internal.ProtobufList<WriteResult> protobufList = this.writeResults_;
        if (!protobufList.isModifiable()) {
            this.writeResults_ = GeneratedMessageLite.K(protobufList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v0(Timestamp timestamp) {
        timestamp.getClass();
        Timestamp timestamp2 = this.commitTime_;
        if (timestamp2 != null && timestamp2 != Timestamp.getDefaultInstance()) {
            this.commitTime_ = Timestamp.newBuilder(this.commitTime_).mergeFrom((Timestamp.Builder) timestamp).buildPartial();
        } else {
            this.commitTime_ = timestamp;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w0(int i4) {
        u0();
        this.writeResults_.remove(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0(Timestamp timestamp) {
        timestamp.getClass();
        this.commitTime_ = timestamp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0(int i4, WriteResult writeResult) {
        writeResult.getClass();
        u0();
        this.writeResults_.set(i4, writeResult);
    }

    @Override // com.google.firestore.v1.CommitResponseOrBuilder
    public Timestamp getCommitTime() {
        Timestamp timestamp = this.commitTime_;
        if (timestamp == null) {
            return Timestamp.getDefaultInstance();
        }
        return timestamp;
    }

    @Override // com.google.firestore.v1.CommitResponseOrBuilder
    public WriteResult getWriteResults(int i4) {
        return this.writeResults_.get(i4);
    }

    @Override // com.google.firestore.v1.CommitResponseOrBuilder
    public int getWriteResultsCount() {
        return this.writeResults_.size();
    }

    @Override // com.google.firestore.v1.CommitResponseOrBuilder
    public List<WriteResult> getWriteResultsList() {
        return this.writeResults_;
    }

    public WriteResultOrBuilder getWriteResultsOrBuilder(int i4) {
        return this.writeResults_.get(i4);
    }

    public List<? extends WriteResultOrBuilder> getWriteResultsOrBuilderList() {
        return this.writeResults_;
    }

    @Override // com.google.firestore.v1.CommitResponseOrBuilder
    public boolean hasCommitTime() {
        if (this.commitTime_ != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.f32445a[methodToInvoke.ordinal()]) {
            case 1:
                return new CommitResponse();
            case 2:
                return new Builder(null);
            case 3:
                return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002\t", new Object[]{"writeResults_", WriteResult.class, "commitTime_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<CommitResponse> parser = PARSER;
                if (parser == null) {
                    synchronized (CommitResponse.class) {
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

    public static Builder newBuilder(CommitResponse commitResponse) {
        return DEFAULT_INSTANCE.r(commitResponse);
    }

    public static CommitResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CommitResponse) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static CommitResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (CommitResponse) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static CommitResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (CommitResponse) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
    }

    public static CommitResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (CommitResponse) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static CommitResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (CommitResponse) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
    }

    public static CommitResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (CommitResponse) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static CommitResponse parseFrom(InputStream inputStream) throws IOException {
        return (CommitResponse) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
    }

    public static CommitResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CommitResponse) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static CommitResponse parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (CommitResponse) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
    }

    public static CommitResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CommitResponse) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
