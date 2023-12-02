package com.google.firestore.v1;

import com.google.firestore.v1.Write;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: classes5.dex */
public final class CommitRequest extends GeneratedMessageLite<CommitRequest, Builder> implements CommitRequestOrBuilder {
    public static final int DATABASE_FIELD_NUMBER = 1;
    private static final CommitRequest DEFAULT_INSTANCE;
    private static volatile Parser<CommitRequest> PARSER = null;
    public static final int TRANSACTION_FIELD_NUMBER = 3;
    public static final int WRITES_FIELD_NUMBER = 2;
    private String database_ = "";
    private Internal.ProtobufList<Write> writes_ = GeneratedMessageLite.y();
    private ByteString transaction_ = ByteString.EMPTY;

    /* renamed from: com.google.firestore.v1.CommitRequest$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f32444a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f32444a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32444a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32444a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32444a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f32444a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f32444a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f32444a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<CommitRequest, Builder> implements CommitRequestOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllWrites(Iterable<? extends Write> iterable) {
            f();
            ((CommitRequest) this.f33398b).r0(iterable);
            return this;
        }

        public Builder addWrites(Write write) {
            f();
            ((CommitRequest) this.f33398b).t0(write);
            return this;
        }

        public Builder clearDatabase() {
            f();
            ((CommitRequest) this.f33398b).u0();
            return this;
        }

        public Builder clearTransaction() {
            f();
            ((CommitRequest) this.f33398b).v0();
            return this;
        }

        public Builder clearWrites() {
            f();
            ((CommitRequest) this.f33398b).w0();
            return this;
        }

        @Override // com.google.firestore.v1.CommitRequestOrBuilder
        public String getDatabase() {
            return ((CommitRequest) this.f33398b).getDatabase();
        }

        @Override // com.google.firestore.v1.CommitRequestOrBuilder
        public ByteString getDatabaseBytes() {
            return ((CommitRequest) this.f33398b).getDatabaseBytes();
        }

        @Override // com.google.firestore.v1.CommitRequestOrBuilder
        public ByteString getTransaction() {
            return ((CommitRequest) this.f33398b).getTransaction();
        }

        @Override // com.google.firestore.v1.CommitRequestOrBuilder
        public Write getWrites(int i4) {
            return ((CommitRequest) this.f33398b).getWrites(i4);
        }

        @Override // com.google.firestore.v1.CommitRequestOrBuilder
        public int getWritesCount() {
            return ((CommitRequest) this.f33398b).getWritesCount();
        }

        @Override // com.google.firestore.v1.CommitRequestOrBuilder
        public List<Write> getWritesList() {
            return Collections.unmodifiableList(((CommitRequest) this.f33398b).getWritesList());
        }

        public Builder removeWrites(int i4) {
            f();
            ((CommitRequest) this.f33398b).y0(i4);
            return this;
        }

        public Builder setDatabase(String str) {
            f();
            ((CommitRequest) this.f33398b).z0(str);
            return this;
        }

        public Builder setDatabaseBytes(ByteString byteString) {
            f();
            ((CommitRequest) this.f33398b).A0(byteString);
            return this;
        }

        public Builder setTransaction(ByteString byteString) {
            f();
            ((CommitRequest) this.f33398b).B0(byteString);
            return this;
        }

        public Builder setWrites(int i4, Write write) {
            f();
            ((CommitRequest) this.f33398b).C0(i4, write);
            return this;
        }

        private Builder() {
            super(CommitRequest.DEFAULT_INSTANCE);
        }

        public Builder addWrites(int i4, Write write) {
            f();
            ((CommitRequest) this.f33398b).s0(i4, write);
            return this;
        }

        public Builder setWrites(int i4, Write.Builder builder) {
            f();
            ((CommitRequest) this.f33398b).C0(i4, builder.build());
            return this;
        }

        public Builder addWrites(Write.Builder builder) {
            f();
            ((CommitRequest) this.f33398b).t0(builder.build());
            return this;
        }

        public Builder addWrites(int i4, Write.Builder builder) {
            f();
            ((CommitRequest) this.f33398b).s0(i4, builder.build());
            return this;
        }
    }

    static {
        CommitRequest commitRequest = new CommitRequest();
        DEFAULT_INSTANCE = commitRequest;
        GeneratedMessageLite.d0(CommitRequest.class, commitRequest);
    }

    private CommitRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        this.database_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B0(ByteString byteString) {
        byteString.getClass();
        this.transaction_ = byteString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C0(int i4, Write write) {
        write.getClass();
        x0();
        this.writes_.set(i4, write);
    }

    public static CommitRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.q();
    }

    public static CommitRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (CommitRequest) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
    }

    public static CommitRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (CommitRequest) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<CommitRequest> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0(Iterable<? extends Write> iterable) {
        x0();
        AbstractMessageLite.a(iterable, this.writes_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0(int i4, Write write) {
        write.getClass();
        x0();
        this.writes_.add(i4, write);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t0(Write write) {
        write.getClass();
        x0();
        this.writes_.add(write);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u0() {
        this.database_ = getDefaultInstance().getDatabase();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v0() {
        this.transaction_ = getDefaultInstance().getTransaction();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w0() {
        this.writes_ = GeneratedMessageLite.y();
    }

    private void x0() {
        Internal.ProtobufList<Write> protobufList = this.writes_;
        if (!protobufList.isModifiable()) {
            this.writes_ = GeneratedMessageLite.K(protobufList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0(int i4) {
        x0();
        this.writes_.remove(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0(String str) {
        str.getClass();
        this.database_ = str;
    }

    @Override // com.google.firestore.v1.CommitRequestOrBuilder
    public String getDatabase() {
        return this.database_;
    }

    @Override // com.google.firestore.v1.CommitRequestOrBuilder
    public ByteString getDatabaseBytes() {
        return ByteString.copyFromUtf8(this.database_);
    }

    @Override // com.google.firestore.v1.CommitRequestOrBuilder
    public ByteString getTransaction() {
        return this.transaction_;
    }

    @Override // com.google.firestore.v1.CommitRequestOrBuilder
    public Write getWrites(int i4) {
        return this.writes_.get(i4);
    }

    @Override // com.google.firestore.v1.CommitRequestOrBuilder
    public int getWritesCount() {
        return this.writes_.size();
    }

    @Override // com.google.firestore.v1.CommitRequestOrBuilder
    public List<Write> getWritesList() {
        return this.writes_;
    }

    public WriteOrBuilder getWritesOrBuilder(int i4) {
        return this.writes_.get(i4);
    }

    public List<? extends WriteOrBuilder> getWritesOrBuilderList() {
        return this.writes_;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.f32444a[methodToInvoke.ordinal()]) {
            case 1:
                return new CommitRequest();
            case 2:
                return new Builder(null);
            case 3:
                return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0001\u0000\u0001Ȉ\u0002\u001b\u0003\n", new Object[]{"database_", "writes_", Write.class, "transaction_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<CommitRequest> parser = PARSER;
                if (parser == null) {
                    synchronized (CommitRequest.class) {
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

    public static Builder newBuilder(CommitRequest commitRequest) {
        return DEFAULT_INSTANCE.r(commitRequest);
    }

    public static CommitRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CommitRequest) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static CommitRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (CommitRequest) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static CommitRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (CommitRequest) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
    }

    public static CommitRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (CommitRequest) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static CommitRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (CommitRequest) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
    }

    public static CommitRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (CommitRequest) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static CommitRequest parseFrom(InputStream inputStream) throws IOException {
        return (CommitRequest) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
    }

    public static CommitRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CommitRequest) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static CommitRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (CommitRequest) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
    }

    public static CommitRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CommitRequest) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
