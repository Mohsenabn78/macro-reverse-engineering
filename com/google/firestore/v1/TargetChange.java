package com.google.firestore.v1;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.google.protobuf.Timestamp;
import com.google.rpc.Status;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: classes5.dex */
public final class TargetChange extends GeneratedMessageLite<TargetChange, Builder> implements TargetChangeOrBuilder {
    public static final int CAUSE_FIELD_NUMBER = 3;
    private static final TargetChange DEFAULT_INSTANCE;
    private static volatile Parser<TargetChange> PARSER = null;
    public static final int READ_TIME_FIELD_NUMBER = 6;
    public static final int RESUME_TOKEN_FIELD_NUMBER = 4;
    public static final int TARGET_CHANGE_TYPE_FIELD_NUMBER = 1;
    public static final int TARGET_IDS_FIELD_NUMBER = 2;
    private Status cause_;
    private Timestamp readTime_;
    private int targetChangeType_;
    private int targetIdsMemoizedSerializedSize = -1;
    private Internal.IntList targetIds_ = GeneratedMessageLite.w();
    private ByteString resumeToken_ = ByteString.EMPTY;

    /* renamed from: com.google.firestore.v1.TargetChange$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f32525a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f32525a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32525a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32525a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32525a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f32525a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f32525a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f32525a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<TargetChange, Builder> implements TargetChangeOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllTargetIds(Iterable<? extends Integer> iterable) {
            f();
            ((TargetChange) this.f33398b).v0(iterable);
            return this;
        }

        public Builder addTargetIds(int i4) {
            f();
            ((TargetChange) this.f33398b).w0(i4);
            return this;
        }

        public Builder clearCause() {
            f();
            ((TargetChange) this.f33398b).x0();
            return this;
        }

        public Builder clearReadTime() {
            f();
            ((TargetChange) this.f33398b).y0();
            return this;
        }

        public Builder clearResumeToken() {
            f();
            ((TargetChange) this.f33398b).z0();
            return this;
        }

        public Builder clearTargetChangeType() {
            f();
            ((TargetChange) this.f33398b).A0();
            return this;
        }

        public Builder clearTargetIds() {
            f();
            ((TargetChange) this.f33398b).B0();
            return this;
        }

        @Override // com.google.firestore.v1.TargetChangeOrBuilder
        public Status getCause() {
            return ((TargetChange) this.f33398b).getCause();
        }

        @Override // com.google.firestore.v1.TargetChangeOrBuilder
        public Timestamp getReadTime() {
            return ((TargetChange) this.f33398b).getReadTime();
        }

        @Override // com.google.firestore.v1.TargetChangeOrBuilder
        public ByteString getResumeToken() {
            return ((TargetChange) this.f33398b).getResumeToken();
        }

        @Override // com.google.firestore.v1.TargetChangeOrBuilder
        public TargetChangeType getTargetChangeType() {
            return ((TargetChange) this.f33398b).getTargetChangeType();
        }

        @Override // com.google.firestore.v1.TargetChangeOrBuilder
        public int getTargetChangeTypeValue() {
            return ((TargetChange) this.f33398b).getTargetChangeTypeValue();
        }

        @Override // com.google.firestore.v1.TargetChangeOrBuilder
        public int getTargetIds(int i4) {
            return ((TargetChange) this.f33398b).getTargetIds(i4);
        }

        @Override // com.google.firestore.v1.TargetChangeOrBuilder
        public int getTargetIdsCount() {
            return ((TargetChange) this.f33398b).getTargetIdsCount();
        }

        @Override // com.google.firestore.v1.TargetChangeOrBuilder
        public List<Integer> getTargetIdsList() {
            return Collections.unmodifiableList(((TargetChange) this.f33398b).getTargetIdsList());
        }

        @Override // com.google.firestore.v1.TargetChangeOrBuilder
        public boolean hasCause() {
            return ((TargetChange) this.f33398b).hasCause();
        }

        @Override // com.google.firestore.v1.TargetChangeOrBuilder
        public boolean hasReadTime() {
            return ((TargetChange) this.f33398b).hasReadTime();
        }

        public Builder mergeCause(Status status) {
            f();
            ((TargetChange) this.f33398b).D0(status);
            return this;
        }

        public Builder mergeReadTime(Timestamp timestamp) {
            f();
            ((TargetChange) this.f33398b).E0(timestamp);
            return this;
        }

        public Builder setCause(Status status) {
            f();
            ((TargetChange) this.f33398b).F0(status);
            return this;
        }

        public Builder setReadTime(Timestamp timestamp) {
            f();
            ((TargetChange) this.f33398b).G0(timestamp);
            return this;
        }

        public Builder setResumeToken(ByteString byteString) {
            f();
            ((TargetChange) this.f33398b).H0(byteString);
            return this;
        }

        public Builder setTargetChangeType(TargetChangeType targetChangeType) {
            f();
            ((TargetChange) this.f33398b).I0(targetChangeType);
            return this;
        }

        public Builder setTargetChangeTypeValue(int i4) {
            f();
            ((TargetChange) this.f33398b).J0(i4);
            return this;
        }

        public Builder setTargetIds(int i4, int i5) {
            f();
            ((TargetChange) this.f33398b).K0(i4, i5);
            return this;
        }

        private Builder() {
            super(TargetChange.DEFAULT_INSTANCE);
        }

        public Builder setCause(Status.Builder builder) {
            f();
            ((TargetChange) this.f33398b).F0(builder.build());
            return this;
        }

        public Builder setReadTime(Timestamp.Builder builder) {
            f();
            ((TargetChange) this.f33398b).G0(builder.build());
            return this;
        }
    }

    /* loaded from: classes5.dex */
    public enum TargetChangeType implements Internal.EnumLite {
        NO_CHANGE(0),
        ADD(1),
        REMOVE(2),
        CURRENT(3),
        RESET(4),
        UNRECOGNIZED(-1);
        
        public static final int ADD_VALUE = 1;
        public static final int CURRENT_VALUE = 3;
        public static final int NO_CHANGE_VALUE = 0;
        public static final int REMOVE_VALUE = 2;
        public static final int RESET_VALUE = 4;

        /* renamed from: a  reason: collision with root package name */
        private static final Internal.EnumLiteMap<TargetChangeType> f32526a = new Internal.EnumLiteMap<TargetChangeType>() { // from class: com.google.firestore.v1.TargetChange.TargetChangeType.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            /* renamed from: a */
            public TargetChangeType findValueByNumber(int i4) {
                return TargetChangeType.forNumber(i4);
            }
        };
        private final int value;

        /* loaded from: classes5.dex */
        private static final class TargetChangeTypeVerifier implements Internal.EnumVerifier {

            /* renamed from: a  reason: collision with root package name */
            static final Internal.EnumVerifier f32528a = new TargetChangeTypeVerifier();

            private TargetChangeTypeVerifier() {
            }

            @Override // com.google.protobuf.Internal.EnumVerifier
            public boolean isInRange(int i4) {
                if (TargetChangeType.forNumber(i4) != null) {
                    return true;
                }
                return false;
            }
        }

        TargetChangeType(int i4) {
            this.value = i4;
        }

        public static TargetChangeType forNumber(int i4) {
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 != 2) {
                        if (i4 != 3) {
                            if (i4 != 4) {
                                return null;
                            }
                            return RESET;
                        }
                        return CURRENT;
                    }
                    return REMOVE;
                }
                return ADD;
            }
            return NO_CHANGE;
        }

        public static Internal.EnumLiteMap<TargetChangeType> internalGetValueMap() {
            return f32526a;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return TargetChangeTypeVerifier.f32528a;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static TargetChangeType valueOf(int i4) {
            return forNumber(i4);
        }
    }

    static {
        TargetChange targetChange = new TargetChange();
        DEFAULT_INSTANCE = targetChange;
        GeneratedMessageLite.d0(TargetChange.class, targetChange);
    }

    private TargetChange() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0() {
        this.targetChangeType_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B0() {
        this.targetIds_ = GeneratedMessageLite.w();
    }

    private void C0() {
        Internal.IntList intList = this.targetIds_;
        if (!intList.isModifiable()) {
            this.targetIds_ = GeneratedMessageLite.I(intList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D0(Status status) {
        status.getClass();
        Status status2 = this.cause_;
        if (status2 != null && status2 != Status.getDefaultInstance()) {
            this.cause_ = Status.newBuilder(this.cause_).mergeFrom((Status.Builder) status).buildPartial();
        } else {
            this.cause_ = status;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E0(Timestamp timestamp) {
        timestamp.getClass();
        Timestamp timestamp2 = this.readTime_;
        if (timestamp2 != null && timestamp2 != Timestamp.getDefaultInstance()) {
            this.readTime_ = Timestamp.newBuilder(this.readTime_).mergeFrom((Timestamp.Builder) timestamp).buildPartial();
        } else {
            this.readTime_ = timestamp;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F0(Status status) {
        status.getClass();
        this.cause_ = status;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G0(Timestamp timestamp) {
        timestamp.getClass();
        this.readTime_ = timestamp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H0(ByteString byteString) {
        byteString.getClass();
        this.resumeToken_ = byteString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I0(TargetChangeType targetChangeType) {
        this.targetChangeType_ = targetChangeType.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J0(int i4) {
        this.targetChangeType_ = i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K0(int i4, int i5) {
        C0();
        this.targetIds_.setInt(i4, i5);
    }

    public static TargetChange getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.q();
    }

    public static TargetChange parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (TargetChange) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
    }

    public static TargetChange parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (TargetChange) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<TargetChange> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v0(Iterable<? extends Integer> iterable) {
        C0();
        AbstractMessageLite.a(iterable, this.targetIds_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w0(int i4) {
        C0();
        this.targetIds_.addInt(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0() {
        this.cause_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0() {
        this.readTime_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0() {
        this.resumeToken_ = getDefaultInstance().getResumeToken();
    }

    @Override // com.google.firestore.v1.TargetChangeOrBuilder
    public Status getCause() {
        Status status = this.cause_;
        if (status == null) {
            return Status.getDefaultInstance();
        }
        return status;
    }

    @Override // com.google.firestore.v1.TargetChangeOrBuilder
    public Timestamp getReadTime() {
        Timestamp timestamp = this.readTime_;
        if (timestamp == null) {
            return Timestamp.getDefaultInstance();
        }
        return timestamp;
    }

    @Override // com.google.firestore.v1.TargetChangeOrBuilder
    public ByteString getResumeToken() {
        return this.resumeToken_;
    }

    @Override // com.google.firestore.v1.TargetChangeOrBuilder
    public TargetChangeType getTargetChangeType() {
        TargetChangeType forNumber = TargetChangeType.forNumber(this.targetChangeType_);
        if (forNumber == null) {
            return TargetChangeType.UNRECOGNIZED;
        }
        return forNumber;
    }

    @Override // com.google.firestore.v1.TargetChangeOrBuilder
    public int getTargetChangeTypeValue() {
        return this.targetChangeType_;
    }

    @Override // com.google.firestore.v1.TargetChangeOrBuilder
    public int getTargetIds(int i4) {
        return this.targetIds_.getInt(i4);
    }

    @Override // com.google.firestore.v1.TargetChangeOrBuilder
    public int getTargetIdsCount() {
        return this.targetIds_.size();
    }

    @Override // com.google.firestore.v1.TargetChangeOrBuilder
    public List<Integer> getTargetIdsList() {
        return this.targetIds_;
    }

    @Override // com.google.firestore.v1.TargetChangeOrBuilder
    public boolean hasCause() {
        if (this.cause_ != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.firestore.v1.TargetChangeOrBuilder
    public boolean hasReadTime() {
        if (this.readTime_ != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.f32525a[methodToInvoke.ordinal()]) {
            case 1:
                return new TargetChange();
            case 2:
                return new Builder(null);
            case 3:
                return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0006\u0005\u0000\u0001\u0000\u0001\f\u0002'\u0003\t\u0004\n\u0006\t", new Object[]{"targetChangeType_", "targetIds_", "cause_", "resumeToken_", "readTime_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<TargetChange> parser = PARSER;
                if (parser == null) {
                    synchronized (TargetChange.class) {
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

    public static Builder newBuilder(TargetChange targetChange) {
        return DEFAULT_INSTANCE.r(targetChange);
    }

    public static TargetChange parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (TargetChange) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static TargetChange parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (TargetChange) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static TargetChange parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (TargetChange) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
    }

    public static TargetChange parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (TargetChange) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static TargetChange parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (TargetChange) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
    }

    public static TargetChange parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (TargetChange) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static TargetChange parseFrom(InputStream inputStream) throws IOException {
        return (TargetChange) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
    }

    public static TargetChange parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (TargetChange) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static TargetChange parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (TargetChange) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
    }

    public static TargetChange parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (TargetChange) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
