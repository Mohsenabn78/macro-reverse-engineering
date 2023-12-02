package com.google.firebase.firestore.proto;

import com.google.firestore.v1.Write;
import com.google.firestore.v1.WriteOrBuilder;
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
public final class WriteBatch extends GeneratedMessageLite<WriteBatch, Builder> implements WriteBatchOrBuilder {
    public static final int BASE_WRITES_FIELD_NUMBER = 4;
    public static final int BATCH_ID_FIELD_NUMBER = 1;
    private static final WriteBatch DEFAULT_INSTANCE;
    public static final int LOCAL_WRITE_TIME_FIELD_NUMBER = 3;
    private static volatile Parser<WriteBatch> PARSER = null;
    public static final int WRITES_FIELD_NUMBER = 2;
    private int batchId_;
    private Timestamp localWriteTime_;
    private Internal.ProtobufList<Write> writes_ = GeneratedMessageLite.y();
    private Internal.ProtobufList<Write> baseWrites_ = GeneratedMessageLite.y();

    /* renamed from: com.google.firebase.firestore.proto.WriteBatch$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f31018a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f31018a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f31018a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f31018a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f31018a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f31018a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f31018a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f31018a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<WriteBatch, Builder> implements WriteBatchOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllBaseWrites(Iterable<? extends Write> iterable) {
            f();
            ((WriteBatch) this.f33398b).x0(iterable);
            return this;
        }

        public Builder addAllWrites(Iterable<? extends Write> iterable) {
            f();
            ((WriteBatch) this.f33398b).y0(iterable);
            return this;
        }

        public Builder addBaseWrites(Write write) {
            f();
            ((WriteBatch) this.f33398b).A0(write);
            return this;
        }

        public Builder addWrites(Write write) {
            f();
            ((WriteBatch) this.f33398b).C0(write);
            return this;
        }

        public Builder clearBaseWrites() {
            f();
            ((WriteBatch) this.f33398b).D0();
            return this;
        }

        public Builder clearBatchId() {
            f();
            ((WriteBatch) this.f33398b).E0();
            return this;
        }

        public Builder clearLocalWriteTime() {
            f();
            ((WriteBatch) this.f33398b).F0();
            return this;
        }

        public Builder clearWrites() {
            f();
            ((WriteBatch) this.f33398b).G0();
            return this;
        }

        @Override // com.google.firebase.firestore.proto.WriteBatchOrBuilder
        public Write getBaseWrites(int i4) {
            return ((WriteBatch) this.f33398b).getBaseWrites(i4);
        }

        @Override // com.google.firebase.firestore.proto.WriteBatchOrBuilder
        public int getBaseWritesCount() {
            return ((WriteBatch) this.f33398b).getBaseWritesCount();
        }

        @Override // com.google.firebase.firestore.proto.WriteBatchOrBuilder
        public List<Write> getBaseWritesList() {
            return Collections.unmodifiableList(((WriteBatch) this.f33398b).getBaseWritesList());
        }

        @Override // com.google.firebase.firestore.proto.WriteBatchOrBuilder
        public int getBatchId() {
            return ((WriteBatch) this.f33398b).getBatchId();
        }

        @Override // com.google.firebase.firestore.proto.WriteBatchOrBuilder
        public Timestamp getLocalWriteTime() {
            return ((WriteBatch) this.f33398b).getLocalWriteTime();
        }

        @Override // com.google.firebase.firestore.proto.WriteBatchOrBuilder
        public Write getWrites(int i4) {
            return ((WriteBatch) this.f33398b).getWrites(i4);
        }

        @Override // com.google.firebase.firestore.proto.WriteBatchOrBuilder
        public int getWritesCount() {
            return ((WriteBatch) this.f33398b).getWritesCount();
        }

        @Override // com.google.firebase.firestore.proto.WriteBatchOrBuilder
        public List<Write> getWritesList() {
            return Collections.unmodifiableList(((WriteBatch) this.f33398b).getWritesList());
        }

        @Override // com.google.firebase.firestore.proto.WriteBatchOrBuilder
        public boolean hasLocalWriteTime() {
            return ((WriteBatch) this.f33398b).hasLocalWriteTime();
        }

        public Builder mergeLocalWriteTime(Timestamp timestamp) {
            f();
            ((WriteBatch) this.f33398b).J0(timestamp);
            return this;
        }

        public Builder removeBaseWrites(int i4) {
            f();
            ((WriteBatch) this.f33398b).K0(i4);
            return this;
        }

        public Builder removeWrites(int i4) {
            f();
            ((WriteBatch) this.f33398b).L0(i4);
            return this;
        }

        public Builder setBaseWrites(int i4, Write write) {
            f();
            ((WriteBatch) this.f33398b).M0(i4, write);
            return this;
        }

        public Builder setBatchId(int i4) {
            f();
            ((WriteBatch) this.f33398b).N0(i4);
            return this;
        }

        public Builder setLocalWriteTime(Timestamp timestamp) {
            f();
            ((WriteBatch) this.f33398b).O0(timestamp);
            return this;
        }

        public Builder setWrites(int i4, Write write) {
            f();
            ((WriteBatch) this.f33398b).P0(i4, write);
            return this;
        }

        private Builder() {
            super(WriteBatch.DEFAULT_INSTANCE);
        }

        public Builder addBaseWrites(int i4, Write write) {
            f();
            ((WriteBatch) this.f33398b).z0(i4, write);
            return this;
        }

        public Builder addWrites(int i4, Write write) {
            f();
            ((WriteBatch) this.f33398b).B0(i4, write);
            return this;
        }

        public Builder setBaseWrites(int i4, Write.Builder builder) {
            f();
            ((WriteBatch) this.f33398b).M0(i4, builder.build());
            return this;
        }

        public Builder setLocalWriteTime(Timestamp.Builder builder) {
            f();
            ((WriteBatch) this.f33398b).O0(builder.build());
            return this;
        }

        public Builder setWrites(int i4, Write.Builder builder) {
            f();
            ((WriteBatch) this.f33398b).P0(i4, builder.build());
            return this;
        }

        public Builder addBaseWrites(Write.Builder builder) {
            f();
            ((WriteBatch) this.f33398b).A0(builder.build());
            return this;
        }

        public Builder addWrites(Write.Builder builder) {
            f();
            ((WriteBatch) this.f33398b).C0(builder.build());
            return this;
        }

        public Builder addBaseWrites(int i4, Write.Builder builder) {
            f();
            ((WriteBatch) this.f33398b).z0(i4, builder.build());
            return this;
        }

        public Builder addWrites(int i4, Write.Builder builder) {
            f();
            ((WriteBatch) this.f33398b).B0(i4, builder.build());
            return this;
        }
    }

    static {
        WriteBatch writeBatch = new WriteBatch();
        DEFAULT_INSTANCE = writeBatch;
        GeneratedMessageLite.d0(WriteBatch.class, writeBatch);
    }

    private WriteBatch() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0(Write write) {
        write.getClass();
        H0();
        this.baseWrites_.add(write);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B0(int i4, Write write) {
        write.getClass();
        I0();
        this.writes_.add(i4, write);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C0(Write write) {
        write.getClass();
        I0();
        this.writes_.add(write);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D0() {
        this.baseWrites_ = GeneratedMessageLite.y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E0() {
        this.batchId_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F0() {
        this.localWriteTime_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G0() {
        this.writes_ = GeneratedMessageLite.y();
    }

    private void H0() {
        Internal.ProtobufList<Write> protobufList = this.baseWrites_;
        if (!protobufList.isModifiable()) {
            this.baseWrites_ = GeneratedMessageLite.K(protobufList);
        }
    }

    private void I0() {
        Internal.ProtobufList<Write> protobufList = this.writes_;
        if (!protobufList.isModifiable()) {
            this.writes_ = GeneratedMessageLite.K(protobufList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J0(Timestamp timestamp) {
        timestamp.getClass();
        Timestamp timestamp2 = this.localWriteTime_;
        if (timestamp2 != null && timestamp2 != Timestamp.getDefaultInstance()) {
            this.localWriteTime_ = Timestamp.newBuilder(this.localWriteTime_).mergeFrom((Timestamp.Builder) timestamp).buildPartial();
        } else {
            this.localWriteTime_ = timestamp;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K0(int i4) {
        H0();
        this.baseWrites_.remove(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L0(int i4) {
        I0();
        this.writes_.remove(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M0(int i4, Write write) {
        write.getClass();
        H0();
        this.baseWrites_.set(i4, write);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N0(int i4) {
        this.batchId_ = i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O0(Timestamp timestamp) {
        timestamp.getClass();
        this.localWriteTime_ = timestamp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P0(int i4, Write write) {
        write.getClass();
        I0();
        this.writes_.set(i4, write);
    }

    public static WriteBatch getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.q();
    }

    public static WriteBatch parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (WriteBatch) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
    }

    public static WriteBatch parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (WriteBatch) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<WriteBatch> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0(Iterable<? extends Write> iterable) {
        H0();
        AbstractMessageLite.a(iterable, this.baseWrites_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0(Iterable<? extends Write> iterable) {
        I0();
        AbstractMessageLite.a(iterable, this.writes_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0(int i4, Write write) {
        write.getClass();
        H0();
        this.baseWrites_.add(i4, write);
    }

    @Override // com.google.firebase.firestore.proto.WriteBatchOrBuilder
    public Write getBaseWrites(int i4) {
        return this.baseWrites_.get(i4);
    }

    @Override // com.google.firebase.firestore.proto.WriteBatchOrBuilder
    public int getBaseWritesCount() {
        return this.baseWrites_.size();
    }

    @Override // com.google.firebase.firestore.proto.WriteBatchOrBuilder
    public List<Write> getBaseWritesList() {
        return this.baseWrites_;
    }

    public WriteOrBuilder getBaseWritesOrBuilder(int i4) {
        return this.baseWrites_.get(i4);
    }

    public List<? extends WriteOrBuilder> getBaseWritesOrBuilderList() {
        return this.baseWrites_;
    }

    @Override // com.google.firebase.firestore.proto.WriteBatchOrBuilder
    public int getBatchId() {
        return this.batchId_;
    }

    @Override // com.google.firebase.firestore.proto.WriteBatchOrBuilder
    public Timestamp getLocalWriteTime() {
        Timestamp timestamp = this.localWriteTime_;
        if (timestamp == null) {
            return Timestamp.getDefaultInstance();
        }
        return timestamp;
    }

    @Override // com.google.firebase.firestore.proto.WriteBatchOrBuilder
    public Write getWrites(int i4) {
        return this.writes_.get(i4);
    }

    @Override // com.google.firebase.firestore.proto.WriteBatchOrBuilder
    public int getWritesCount() {
        return this.writes_.size();
    }

    @Override // com.google.firebase.firestore.proto.WriteBatchOrBuilder
    public List<Write> getWritesList() {
        return this.writes_;
    }

    public WriteOrBuilder getWritesOrBuilder(int i4) {
        return this.writes_.get(i4);
    }

    public List<? extends WriteOrBuilder> getWritesOrBuilderList() {
        return this.writes_;
    }

    @Override // com.google.firebase.firestore.proto.WriteBatchOrBuilder
    public boolean hasLocalWriteTime() {
        if (this.localWriteTime_ != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.f31018a[methodToInvoke.ordinal()]) {
            case 1:
                return new WriteBatch();
            case 2:
                return new Builder(null);
            case 3:
                return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0002\u0000\u0001\u0004\u0002\u001b\u0003\t\u0004\u001b", new Object[]{"batchId_", "writes_", Write.class, "localWriteTime_", "baseWrites_", Write.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<WriteBatch> parser = PARSER;
                if (parser == null) {
                    synchronized (WriteBatch.class) {
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

    public static Builder newBuilder(WriteBatch writeBatch) {
        return DEFAULT_INSTANCE.r(writeBatch);
    }

    public static WriteBatch parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (WriteBatch) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static WriteBatch parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (WriteBatch) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static WriteBatch parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (WriteBatch) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
    }

    public static WriteBatch parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (WriteBatch) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static WriteBatch parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (WriteBatch) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
    }

    public static WriteBatch parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (WriteBatch) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static WriteBatch parseFrom(InputStream inputStream) throws IOException {
        return (WriteBatch) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
    }

    public static WriteBatch parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (WriteBatch) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static WriteBatch parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (WriteBatch) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
    }

    public static WriteBatch parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (WriteBatch) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
