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
public final class WriteResponse extends GeneratedMessageLite<WriteResponse, Builder> implements WriteResponseOrBuilder {
    public static final int COMMIT_TIME_FIELD_NUMBER = 4;
    private static final WriteResponse DEFAULT_INSTANCE;
    private static volatile Parser<WriteResponse> PARSER = null;
    public static final int STREAM_ID_FIELD_NUMBER = 1;
    public static final int STREAM_TOKEN_FIELD_NUMBER = 2;
    public static final int WRITE_RESULTS_FIELD_NUMBER = 3;
    private Timestamp commitTime_;
    private String streamId_ = "";
    private ByteString streamToken_ = ByteString.EMPTY;
    private Internal.ProtobufList<WriteResult> writeResults_ = GeneratedMessageLite.y();

    /* renamed from: com.google.firestore.v1.WriteResponse$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f32539a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f32539a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32539a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32539a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32539a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f32539a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f32539a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f32539a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<WriteResponse, Builder> implements WriteResponseOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllWriteResults(Iterable<? extends WriteResult> iterable) {
            f();
            ((WriteResponse) this.f33398b).u0(iterable);
            return this;
        }

        public Builder addWriteResults(WriteResult writeResult) {
            f();
            ((WriteResponse) this.f33398b).w0(writeResult);
            return this;
        }

        public Builder clearCommitTime() {
            f();
            ((WriteResponse) this.f33398b).x0();
            return this;
        }

        public Builder clearStreamId() {
            f();
            ((WriteResponse) this.f33398b).y0();
            return this;
        }

        public Builder clearStreamToken() {
            f();
            ((WriteResponse) this.f33398b).z0();
            return this;
        }

        public Builder clearWriteResults() {
            f();
            ((WriteResponse) this.f33398b).A0();
            return this;
        }

        @Override // com.google.firestore.v1.WriteResponseOrBuilder
        public Timestamp getCommitTime() {
            return ((WriteResponse) this.f33398b).getCommitTime();
        }

        @Override // com.google.firestore.v1.WriteResponseOrBuilder
        public String getStreamId() {
            return ((WriteResponse) this.f33398b).getStreamId();
        }

        @Override // com.google.firestore.v1.WriteResponseOrBuilder
        public ByteString getStreamIdBytes() {
            return ((WriteResponse) this.f33398b).getStreamIdBytes();
        }

        @Override // com.google.firestore.v1.WriteResponseOrBuilder
        public ByteString getStreamToken() {
            return ((WriteResponse) this.f33398b).getStreamToken();
        }

        @Override // com.google.firestore.v1.WriteResponseOrBuilder
        public WriteResult getWriteResults(int i4) {
            return ((WriteResponse) this.f33398b).getWriteResults(i4);
        }

        @Override // com.google.firestore.v1.WriteResponseOrBuilder
        public int getWriteResultsCount() {
            return ((WriteResponse) this.f33398b).getWriteResultsCount();
        }

        @Override // com.google.firestore.v1.WriteResponseOrBuilder
        public List<WriteResult> getWriteResultsList() {
            return Collections.unmodifiableList(((WriteResponse) this.f33398b).getWriteResultsList());
        }

        @Override // com.google.firestore.v1.WriteResponseOrBuilder
        public boolean hasCommitTime() {
            return ((WriteResponse) this.f33398b).hasCommitTime();
        }

        public Builder mergeCommitTime(Timestamp timestamp) {
            f();
            ((WriteResponse) this.f33398b).C0(timestamp);
            return this;
        }

        public Builder removeWriteResults(int i4) {
            f();
            ((WriteResponse) this.f33398b).D0(i4);
            return this;
        }

        public Builder setCommitTime(Timestamp timestamp) {
            f();
            ((WriteResponse) this.f33398b).E0(timestamp);
            return this;
        }

        public Builder setStreamId(String str) {
            f();
            ((WriteResponse) this.f33398b).F0(str);
            return this;
        }

        public Builder setStreamIdBytes(ByteString byteString) {
            f();
            ((WriteResponse) this.f33398b).G0(byteString);
            return this;
        }

        public Builder setStreamToken(ByteString byteString) {
            f();
            ((WriteResponse) this.f33398b).H0(byteString);
            return this;
        }

        public Builder setWriteResults(int i4, WriteResult writeResult) {
            f();
            ((WriteResponse) this.f33398b).I0(i4, writeResult);
            return this;
        }

        private Builder() {
            super(WriteResponse.DEFAULT_INSTANCE);
        }

        public Builder addWriteResults(int i4, WriteResult writeResult) {
            f();
            ((WriteResponse) this.f33398b).v0(i4, writeResult);
            return this;
        }

        public Builder setCommitTime(Timestamp.Builder builder) {
            f();
            ((WriteResponse) this.f33398b).E0(builder.build());
            return this;
        }

        public Builder setWriteResults(int i4, WriteResult.Builder builder) {
            f();
            ((WriteResponse) this.f33398b).I0(i4, builder.build());
            return this;
        }

        public Builder addWriteResults(WriteResult.Builder builder) {
            f();
            ((WriteResponse) this.f33398b).w0(builder.build());
            return this;
        }

        public Builder addWriteResults(int i4, WriteResult.Builder builder) {
            f();
            ((WriteResponse) this.f33398b).v0(i4, builder.build());
            return this;
        }
    }

    static {
        WriteResponse writeResponse = new WriteResponse();
        DEFAULT_INSTANCE = writeResponse;
        GeneratedMessageLite.d0(WriteResponse.class, writeResponse);
    }

    private WriteResponse() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0() {
        this.writeResults_ = GeneratedMessageLite.y();
    }

    private void B0() {
        Internal.ProtobufList<WriteResult> protobufList = this.writeResults_;
        if (!protobufList.isModifiable()) {
            this.writeResults_ = GeneratedMessageLite.K(protobufList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C0(Timestamp timestamp) {
        timestamp.getClass();
        Timestamp timestamp2 = this.commitTime_;
        if (timestamp2 != null && timestamp2 != Timestamp.getDefaultInstance()) {
            this.commitTime_ = Timestamp.newBuilder(this.commitTime_).mergeFrom((Timestamp.Builder) timestamp).buildPartial();
        } else {
            this.commitTime_ = timestamp;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D0(int i4) {
        B0();
        this.writeResults_.remove(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E0(Timestamp timestamp) {
        timestamp.getClass();
        this.commitTime_ = timestamp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F0(String str) {
        str.getClass();
        this.streamId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G0(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        this.streamId_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H0(ByteString byteString) {
        byteString.getClass();
        this.streamToken_ = byteString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I0(int i4, WriteResult writeResult) {
        writeResult.getClass();
        B0();
        this.writeResults_.set(i4, writeResult);
    }

    public static WriteResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.q();
    }

    public static WriteResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (WriteResponse) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
    }

    public static WriteResponse parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (WriteResponse) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<WriteResponse> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u0(Iterable<? extends WriteResult> iterable) {
        B0();
        AbstractMessageLite.a(iterable, this.writeResults_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v0(int i4, WriteResult writeResult) {
        writeResult.getClass();
        B0();
        this.writeResults_.add(i4, writeResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w0(WriteResult writeResult) {
        writeResult.getClass();
        B0();
        this.writeResults_.add(writeResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0() {
        this.commitTime_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0() {
        this.streamId_ = getDefaultInstance().getStreamId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0() {
        this.streamToken_ = getDefaultInstance().getStreamToken();
    }

    @Override // com.google.firestore.v1.WriteResponseOrBuilder
    public Timestamp getCommitTime() {
        Timestamp timestamp = this.commitTime_;
        if (timestamp == null) {
            return Timestamp.getDefaultInstance();
        }
        return timestamp;
    }

    @Override // com.google.firestore.v1.WriteResponseOrBuilder
    public String getStreamId() {
        return this.streamId_;
    }

    @Override // com.google.firestore.v1.WriteResponseOrBuilder
    public ByteString getStreamIdBytes() {
        return ByteString.copyFromUtf8(this.streamId_);
    }

    @Override // com.google.firestore.v1.WriteResponseOrBuilder
    public ByteString getStreamToken() {
        return this.streamToken_;
    }

    @Override // com.google.firestore.v1.WriteResponseOrBuilder
    public WriteResult getWriteResults(int i4) {
        return this.writeResults_.get(i4);
    }

    @Override // com.google.firestore.v1.WriteResponseOrBuilder
    public int getWriteResultsCount() {
        return this.writeResults_.size();
    }

    @Override // com.google.firestore.v1.WriteResponseOrBuilder
    public List<WriteResult> getWriteResultsList() {
        return this.writeResults_;
    }

    public WriteResultOrBuilder getWriteResultsOrBuilder(int i4) {
        return this.writeResults_.get(i4);
    }

    public List<? extends WriteResultOrBuilder> getWriteResultsOrBuilderList() {
        return this.writeResults_;
    }

    @Override // com.google.firestore.v1.WriteResponseOrBuilder
    public boolean hasCommitTime() {
        if (this.commitTime_ != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.f32539a[methodToInvoke.ordinal()]) {
            case 1:
                return new WriteResponse();
            case 2:
                return new Builder(null);
            case 3:
                return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0001\u0000\u0001Ȉ\u0002\n\u0003\u001b\u0004\t", new Object[]{"streamId_", "streamToken_", "writeResults_", WriteResult.class, "commitTime_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<WriteResponse> parser = PARSER;
                if (parser == null) {
                    synchronized (WriteResponse.class) {
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

    public static Builder newBuilder(WriteResponse writeResponse) {
        return DEFAULT_INSTANCE.r(writeResponse);
    }

    public static WriteResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (WriteResponse) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static WriteResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (WriteResponse) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static WriteResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (WriteResponse) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
    }

    public static WriteResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (WriteResponse) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static WriteResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (WriteResponse) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
    }

    public static WriteResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (WriteResponse) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static WriteResponse parseFrom(InputStream inputStream) throws IOException {
        return (WriteResponse) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
    }

    public static WriteResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (WriteResponse) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static WriteResponse parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (WriteResponse) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
    }

    public static WriteResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (WriteResponse) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
