package com.google.firestore.v1;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes5.dex */
public final class TransactionOptions extends GeneratedMessageLite<TransactionOptions, Builder> implements TransactionOptionsOrBuilder {
    private static final TransactionOptions DEFAULT_INSTANCE;
    private static volatile Parser<TransactionOptions> PARSER = null;
    public static final int READ_ONLY_FIELD_NUMBER = 2;
    public static final int READ_WRITE_FIELD_NUMBER = 3;
    private int modeCase_ = 0;
    private Object mode_;

    /* renamed from: com.google.firestore.v1.TransactionOptions$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f32529a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f32529a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32529a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32529a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32529a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f32529a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f32529a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f32529a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<TransactionOptions, Builder> implements TransactionOptionsOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearMode() {
            f();
            ((TransactionOptions) this.f33398b).n0();
            return this;
        }

        public Builder clearReadOnly() {
            f();
            ((TransactionOptions) this.f33398b).o0();
            return this;
        }

        public Builder clearReadWrite() {
            f();
            ((TransactionOptions) this.f33398b).p0();
            return this;
        }

        @Override // com.google.firestore.v1.TransactionOptionsOrBuilder
        public ModeCase getModeCase() {
            return ((TransactionOptions) this.f33398b).getModeCase();
        }

        @Override // com.google.firestore.v1.TransactionOptionsOrBuilder
        public ReadOnly getReadOnly() {
            return ((TransactionOptions) this.f33398b).getReadOnly();
        }

        @Override // com.google.firestore.v1.TransactionOptionsOrBuilder
        public ReadWrite getReadWrite() {
            return ((TransactionOptions) this.f33398b).getReadWrite();
        }

        @Override // com.google.firestore.v1.TransactionOptionsOrBuilder
        public boolean hasReadOnly() {
            return ((TransactionOptions) this.f33398b).hasReadOnly();
        }

        @Override // com.google.firestore.v1.TransactionOptionsOrBuilder
        public boolean hasReadWrite() {
            return ((TransactionOptions) this.f33398b).hasReadWrite();
        }

        public Builder mergeReadOnly(ReadOnly readOnly) {
            f();
            ((TransactionOptions) this.f33398b).q0(readOnly);
            return this;
        }

        public Builder mergeReadWrite(ReadWrite readWrite) {
            f();
            ((TransactionOptions) this.f33398b).r0(readWrite);
            return this;
        }

        public Builder setReadOnly(ReadOnly readOnly) {
            f();
            ((TransactionOptions) this.f33398b).s0(readOnly);
            return this;
        }

        public Builder setReadWrite(ReadWrite readWrite) {
            f();
            ((TransactionOptions) this.f33398b).t0(readWrite);
            return this;
        }

        private Builder() {
            super(TransactionOptions.DEFAULT_INSTANCE);
        }

        public Builder setReadOnly(ReadOnly.Builder builder) {
            f();
            ((TransactionOptions) this.f33398b).s0(builder.build());
            return this;
        }

        public Builder setReadWrite(ReadWrite.Builder builder) {
            f();
            ((TransactionOptions) this.f33398b).t0(builder.build());
            return this;
        }
    }

    /* loaded from: classes5.dex */
    public enum ModeCase {
        READ_ONLY(2),
        READ_WRITE(3),
        MODE_NOT_SET(0);
        
        private final int value;

        ModeCase(int i4) {
            this.value = i4;
        }

        public static ModeCase forNumber(int i4) {
            if (i4 != 0) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        return null;
                    }
                    return READ_WRITE;
                }
                return READ_ONLY;
            }
            return MODE_NOT_SET;
        }

        public int getNumber() {
            return this.value;
        }

        @Deprecated
        public static ModeCase valueOf(int i4) {
            return forNumber(i4);
        }
    }

    /* loaded from: classes5.dex */
    public static final class ReadOnly extends GeneratedMessageLite<ReadOnly, Builder> implements ReadOnlyOrBuilder {
        private static final ReadOnly DEFAULT_INSTANCE;
        private static volatile Parser<ReadOnly> PARSER = null;
        public static final int READ_TIME_FIELD_NUMBER = 2;
        private int consistencySelectorCase_ = 0;
        private Object consistencySelector_;

        /* loaded from: classes5.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<ReadOnly, Builder> implements ReadOnlyOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearConsistencySelector() {
                f();
                ((ReadOnly) this.f33398b).k0();
                return this;
            }

            public Builder clearReadTime() {
                f();
                ((ReadOnly) this.f33398b).l0();
                return this;
            }

            @Override // com.google.firestore.v1.TransactionOptions.ReadOnlyOrBuilder
            public ConsistencySelectorCase getConsistencySelectorCase() {
                return ((ReadOnly) this.f33398b).getConsistencySelectorCase();
            }

            @Override // com.google.firestore.v1.TransactionOptions.ReadOnlyOrBuilder
            public Timestamp getReadTime() {
                return ((ReadOnly) this.f33398b).getReadTime();
            }

            @Override // com.google.firestore.v1.TransactionOptions.ReadOnlyOrBuilder
            public boolean hasReadTime() {
                return ((ReadOnly) this.f33398b).hasReadTime();
            }

            public Builder mergeReadTime(Timestamp timestamp) {
                f();
                ((ReadOnly) this.f33398b).m0(timestamp);
                return this;
            }

            public Builder setReadTime(Timestamp timestamp) {
                f();
                ((ReadOnly) this.f33398b).n0(timestamp);
                return this;
            }

            private Builder() {
                super(ReadOnly.DEFAULT_INSTANCE);
            }

            public Builder setReadTime(Timestamp.Builder builder) {
                f();
                ((ReadOnly) this.f33398b).n0(builder.build());
                return this;
            }
        }

        /* loaded from: classes5.dex */
        public enum ConsistencySelectorCase {
            READ_TIME(2),
            CONSISTENCYSELECTOR_NOT_SET(0);
            
            private final int value;

            ConsistencySelectorCase(int i4) {
                this.value = i4;
            }

            public static ConsistencySelectorCase forNumber(int i4) {
                if (i4 != 0) {
                    if (i4 != 2) {
                        return null;
                    }
                    return READ_TIME;
                }
                return CONSISTENCYSELECTOR_NOT_SET;
            }

            public int getNumber() {
                return this.value;
            }

            @Deprecated
            public static ConsistencySelectorCase valueOf(int i4) {
                return forNumber(i4);
            }
        }

        static {
            ReadOnly readOnly = new ReadOnly();
            DEFAULT_INSTANCE = readOnly;
            GeneratedMessageLite.d0(ReadOnly.class, readOnly);
        }

        private ReadOnly() {
        }

        public static ReadOnly getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void k0() {
            this.consistencySelectorCase_ = 0;
            this.consistencySelector_ = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void l0() {
            if (this.consistencySelectorCase_ == 2) {
                this.consistencySelectorCase_ = 0;
                this.consistencySelector_ = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void m0(Timestamp timestamp) {
            timestamp.getClass();
            if (this.consistencySelectorCase_ == 2 && this.consistencySelector_ != Timestamp.getDefaultInstance()) {
                this.consistencySelector_ = Timestamp.newBuilder((Timestamp) this.consistencySelector_).mergeFrom((Timestamp.Builder) timestamp).buildPartial();
            } else {
                this.consistencySelector_ = timestamp;
            }
            this.consistencySelectorCase_ = 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n0(Timestamp timestamp) {
            timestamp.getClass();
            this.consistencySelector_ = timestamp;
            this.consistencySelectorCase_ = 2;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.q();
        }

        public static ReadOnly parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ReadOnly) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
        }

        public static ReadOnly parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (ReadOnly) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<ReadOnly> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        @Override // com.google.firestore.v1.TransactionOptions.ReadOnlyOrBuilder
        public ConsistencySelectorCase getConsistencySelectorCase() {
            return ConsistencySelectorCase.forNumber(this.consistencySelectorCase_);
        }

        @Override // com.google.firestore.v1.TransactionOptions.ReadOnlyOrBuilder
        public Timestamp getReadTime() {
            if (this.consistencySelectorCase_ == 2) {
                return (Timestamp) this.consistencySelector_;
            }
            return Timestamp.getDefaultInstance();
        }

        @Override // com.google.firestore.v1.TransactionOptions.ReadOnlyOrBuilder
        public boolean hasReadTime() {
            if (this.consistencySelectorCase_ == 2) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (AnonymousClass1.f32529a[methodToInvoke.ordinal()]) {
                case 1:
                    return new ReadOnly();
                case 2:
                    return new Builder(null);
                case 3:
                    return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0001\u0001\u0000\u0002\u0002\u0001\u0000\u0000\u0000\u0002<\u0000", new Object[]{"consistencySelector_", "consistencySelectorCase_", Timestamp.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ReadOnly> parser = PARSER;
                    if (parser == null) {
                        synchronized (ReadOnly.class) {
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

        public static Builder newBuilder(ReadOnly readOnly) {
            return DEFAULT_INSTANCE.r(readOnly);
        }

        public static ReadOnly parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ReadOnly) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ReadOnly parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ReadOnly) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ReadOnly parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (ReadOnly) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
        }

        public static ReadOnly parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ReadOnly) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ReadOnly parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ReadOnly) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
        }

        public static ReadOnly parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ReadOnly) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ReadOnly parseFrom(InputStream inputStream) throws IOException {
            return (ReadOnly) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
        }

        public static ReadOnly parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ReadOnly) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ReadOnly parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ReadOnly) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ReadOnly parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ReadOnly) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: classes5.dex */
    public interface ReadOnlyOrBuilder extends MessageLiteOrBuilder {
        ReadOnly.ConsistencySelectorCase getConsistencySelectorCase();

        Timestamp getReadTime();

        boolean hasReadTime();
    }

    /* loaded from: classes5.dex */
    public static final class ReadWrite extends GeneratedMessageLite<ReadWrite, Builder> implements ReadWriteOrBuilder {
        private static final ReadWrite DEFAULT_INSTANCE;
        private static volatile Parser<ReadWrite> PARSER = null;
        public static final int RETRY_TRANSACTION_FIELD_NUMBER = 1;
        private ByteString retryTransaction_ = ByteString.EMPTY;

        /* loaded from: classes5.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<ReadWrite, Builder> implements ReadWriteOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearRetryTransaction() {
                f();
                ((ReadWrite) this.f33398b).i0();
                return this;
            }

            @Override // com.google.firestore.v1.TransactionOptions.ReadWriteOrBuilder
            public ByteString getRetryTransaction() {
                return ((ReadWrite) this.f33398b).getRetryTransaction();
            }

            public Builder setRetryTransaction(ByteString byteString) {
                f();
                ((ReadWrite) this.f33398b).j0(byteString);
                return this;
            }

            private Builder() {
                super(ReadWrite.DEFAULT_INSTANCE);
            }
        }

        static {
            ReadWrite readWrite = new ReadWrite();
            DEFAULT_INSTANCE = readWrite;
            GeneratedMessageLite.d0(ReadWrite.class, readWrite);
        }

        private ReadWrite() {
        }

        public static ReadWrite getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void i0() {
            this.retryTransaction_ = getDefaultInstance().getRetryTransaction();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j0(ByteString byteString) {
            byteString.getClass();
            this.retryTransaction_ = byteString;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.q();
        }

        public static ReadWrite parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ReadWrite) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
        }

        public static ReadWrite parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (ReadWrite) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<ReadWrite> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        @Override // com.google.firestore.v1.TransactionOptions.ReadWriteOrBuilder
        public ByteString getRetryTransaction() {
            return this.retryTransaction_;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (AnonymousClass1.f32529a[methodToInvoke.ordinal()]) {
                case 1:
                    return new ReadWrite();
                case 2:
                    return new Builder(null);
                case 3:
                    return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\n", new Object[]{"retryTransaction_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ReadWrite> parser = PARSER;
                    if (parser == null) {
                        synchronized (ReadWrite.class) {
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

        public static Builder newBuilder(ReadWrite readWrite) {
            return DEFAULT_INSTANCE.r(readWrite);
        }

        public static ReadWrite parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ReadWrite) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ReadWrite parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ReadWrite) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ReadWrite parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (ReadWrite) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
        }

        public static ReadWrite parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ReadWrite) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ReadWrite parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ReadWrite) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
        }

        public static ReadWrite parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ReadWrite) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ReadWrite parseFrom(InputStream inputStream) throws IOException {
            return (ReadWrite) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
        }

        public static ReadWrite parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ReadWrite) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ReadWrite parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ReadWrite) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ReadWrite parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ReadWrite) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: classes5.dex */
    public interface ReadWriteOrBuilder extends MessageLiteOrBuilder {
        ByteString getRetryTransaction();
    }

    static {
        TransactionOptions transactionOptions = new TransactionOptions();
        DEFAULT_INSTANCE = transactionOptions;
        GeneratedMessageLite.d0(TransactionOptions.class, transactionOptions);
    }

    private TransactionOptions() {
    }

    public static TransactionOptions getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n0() {
        this.modeCase_ = 0;
        this.mode_ = null;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o0() {
        if (this.modeCase_ == 2) {
            this.modeCase_ = 0;
            this.mode_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p0() {
        if (this.modeCase_ == 3) {
            this.modeCase_ = 0;
            this.mode_ = null;
        }
    }

    public static TransactionOptions parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (TransactionOptions) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
    }

    public static TransactionOptions parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (TransactionOptions) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<TransactionOptions> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q0(ReadOnly readOnly) {
        readOnly.getClass();
        if (this.modeCase_ == 2 && this.mode_ != ReadOnly.getDefaultInstance()) {
            this.mode_ = ReadOnly.newBuilder((ReadOnly) this.mode_).mergeFrom((ReadOnly.Builder) readOnly).buildPartial();
        } else {
            this.mode_ = readOnly;
        }
        this.modeCase_ = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0(ReadWrite readWrite) {
        readWrite.getClass();
        if (this.modeCase_ == 3 && this.mode_ != ReadWrite.getDefaultInstance()) {
            this.mode_ = ReadWrite.newBuilder((ReadWrite) this.mode_).mergeFrom((ReadWrite.Builder) readWrite).buildPartial();
        } else {
            this.mode_ = readWrite;
        }
        this.modeCase_ = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0(ReadOnly readOnly) {
        readOnly.getClass();
        this.mode_ = readOnly;
        this.modeCase_ = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t0(ReadWrite readWrite) {
        readWrite.getClass();
        this.mode_ = readWrite;
        this.modeCase_ = 3;
    }

    @Override // com.google.firestore.v1.TransactionOptionsOrBuilder
    public ModeCase getModeCase() {
        return ModeCase.forNumber(this.modeCase_);
    }

    @Override // com.google.firestore.v1.TransactionOptionsOrBuilder
    public ReadOnly getReadOnly() {
        if (this.modeCase_ == 2) {
            return (ReadOnly) this.mode_;
        }
        return ReadOnly.getDefaultInstance();
    }

    @Override // com.google.firestore.v1.TransactionOptionsOrBuilder
    public ReadWrite getReadWrite() {
        if (this.modeCase_ == 3) {
            return (ReadWrite) this.mode_;
        }
        return ReadWrite.getDefaultInstance();
    }

    @Override // com.google.firestore.v1.TransactionOptionsOrBuilder
    public boolean hasReadOnly() {
        if (this.modeCase_ == 2) {
            return true;
        }
        return false;
    }

    @Override // com.google.firestore.v1.TransactionOptionsOrBuilder
    public boolean hasReadWrite() {
        if (this.modeCase_ == 3) {
            return true;
        }
        return false;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.f32529a[methodToInvoke.ordinal()]) {
            case 1:
                return new TransactionOptions();
            case 2:
                return new Builder(null);
            case 3:
                return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0002\u0001\u0000\u0002\u0003\u0002\u0000\u0000\u0000\u0002<\u0000\u0003<\u0000", new Object[]{"mode_", "modeCase_", ReadOnly.class, ReadWrite.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<TransactionOptions> parser = PARSER;
                if (parser == null) {
                    synchronized (TransactionOptions.class) {
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

    public static Builder newBuilder(TransactionOptions transactionOptions) {
        return DEFAULT_INSTANCE.r(transactionOptions);
    }

    public static TransactionOptions parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (TransactionOptions) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static TransactionOptions parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (TransactionOptions) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static TransactionOptions parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (TransactionOptions) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
    }

    public static TransactionOptions parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (TransactionOptions) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static TransactionOptions parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (TransactionOptions) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
    }

    public static TransactionOptions parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (TransactionOptions) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static TransactionOptions parseFrom(InputStream inputStream) throws IOException {
        return (TransactionOptions) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
    }

    public static TransactionOptions parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (TransactionOptions) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static TransactionOptions parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (TransactionOptions) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
    }

    public static TransactionOptions parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (TransactionOptions) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
