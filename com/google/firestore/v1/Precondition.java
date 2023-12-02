package com.google.firestore.v1;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes5.dex */
public final class Precondition extends GeneratedMessageLite<Precondition, Builder> implements PreconditionOrBuilder {
    private static final Precondition DEFAULT_INSTANCE;
    public static final int EXISTS_FIELD_NUMBER = 1;
    private static volatile Parser<Precondition> PARSER = null;
    public static final int UPDATE_TIME_FIELD_NUMBER = 2;
    private int conditionTypeCase_ = 0;
    private Object conditionType_;

    /* renamed from: com.google.firestore.v1.Precondition$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f32492a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f32492a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32492a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32492a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32492a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f32492a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f32492a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f32492a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<Precondition, Builder> implements PreconditionOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearConditionType() {
            f();
            ((Precondition) this.f33398b).m0();
            return this;
        }

        public Builder clearExists() {
            f();
            ((Precondition) this.f33398b).n0();
            return this;
        }

        public Builder clearUpdateTime() {
            f();
            ((Precondition) this.f33398b).o0();
            return this;
        }

        @Override // com.google.firestore.v1.PreconditionOrBuilder
        public ConditionTypeCase getConditionTypeCase() {
            return ((Precondition) this.f33398b).getConditionTypeCase();
        }

        @Override // com.google.firestore.v1.PreconditionOrBuilder
        public boolean getExists() {
            return ((Precondition) this.f33398b).getExists();
        }

        @Override // com.google.firestore.v1.PreconditionOrBuilder
        public Timestamp getUpdateTime() {
            return ((Precondition) this.f33398b).getUpdateTime();
        }

        @Override // com.google.firestore.v1.PreconditionOrBuilder
        public boolean hasExists() {
            return ((Precondition) this.f33398b).hasExists();
        }

        @Override // com.google.firestore.v1.PreconditionOrBuilder
        public boolean hasUpdateTime() {
            return ((Precondition) this.f33398b).hasUpdateTime();
        }

        public Builder mergeUpdateTime(Timestamp timestamp) {
            f();
            ((Precondition) this.f33398b).p0(timestamp);
            return this;
        }

        public Builder setExists(boolean z3) {
            f();
            ((Precondition) this.f33398b).q0(z3);
            return this;
        }

        public Builder setUpdateTime(Timestamp timestamp) {
            f();
            ((Precondition) this.f33398b).r0(timestamp);
            return this;
        }

        private Builder() {
            super(Precondition.DEFAULT_INSTANCE);
        }

        public Builder setUpdateTime(Timestamp.Builder builder) {
            f();
            ((Precondition) this.f33398b).r0(builder.build());
            return this;
        }
    }

    /* loaded from: classes5.dex */
    public enum ConditionTypeCase {
        EXISTS(1),
        UPDATE_TIME(2),
        CONDITIONTYPE_NOT_SET(0);
        
        private final int value;

        ConditionTypeCase(int i4) {
            this.value = i4;
        }

        public static ConditionTypeCase forNumber(int i4) {
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 != 2) {
                        return null;
                    }
                    return UPDATE_TIME;
                }
                return EXISTS;
            }
            return CONDITIONTYPE_NOT_SET;
        }

        public int getNumber() {
            return this.value;
        }

        @Deprecated
        public static ConditionTypeCase valueOf(int i4) {
            return forNumber(i4);
        }
    }

    static {
        Precondition precondition = new Precondition();
        DEFAULT_INSTANCE = precondition;
        GeneratedMessageLite.d0(Precondition.class, precondition);
    }

    private Precondition() {
    }

    public static Precondition getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m0() {
        this.conditionTypeCase_ = 0;
        this.conditionType_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n0() {
        if (this.conditionTypeCase_ == 1) {
            this.conditionTypeCase_ = 0;
            this.conditionType_ = null;
        }
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o0() {
        if (this.conditionTypeCase_ == 2) {
            this.conditionTypeCase_ = 0;
            this.conditionType_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p0(Timestamp timestamp) {
        timestamp.getClass();
        if (this.conditionTypeCase_ == 2 && this.conditionType_ != Timestamp.getDefaultInstance()) {
            this.conditionType_ = Timestamp.newBuilder((Timestamp) this.conditionType_).mergeFrom((Timestamp.Builder) timestamp).buildPartial();
        } else {
            this.conditionType_ = timestamp;
        }
        this.conditionTypeCase_ = 2;
    }

    public static Precondition parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Precondition) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
    }

    public static Precondition parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (Precondition) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Precondition> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q0(boolean z3) {
        this.conditionTypeCase_ = 1;
        this.conditionType_ = Boolean.valueOf(z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0(Timestamp timestamp) {
        timestamp.getClass();
        this.conditionType_ = timestamp;
        this.conditionTypeCase_ = 2;
    }

    @Override // com.google.firestore.v1.PreconditionOrBuilder
    public ConditionTypeCase getConditionTypeCase() {
        return ConditionTypeCase.forNumber(this.conditionTypeCase_);
    }

    @Override // com.google.firestore.v1.PreconditionOrBuilder
    public boolean getExists() {
        if (this.conditionTypeCase_ == 1) {
            return ((Boolean) this.conditionType_).booleanValue();
        }
        return false;
    }

    @Override // com.google.firestore.v1.PreconditionOrBuilder
    public Timestamp getUpdateTime() {
        if (this.conditionTypeCase_ == 2) {
            return (Timestamp) this.conditionType_;
        }
        return Timestamp.getDefaultInstance();
    }

    @Override // com.google.firestore.v1.PreconditionOrBuilder
    public boolean hasExists() {
        if (this.conditionTypeCase_ == 1) {
            return true;
        }
        return false;
    }

    @Override // com.google.firestore.v1.PreconditionOrBuilder
    public boolean hasUpdateTime() {
        if (this.conditionTypeCase_ == 2) {
            return true;
        }
        return false;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.f32492a[methodToInvoke.ordinal()]) {
            case 1:
                return new Precondition();
            case 2:
                return new Builder(null);
            case 3:
                return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0002\u0001\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001:\u0000\u0002<\u0000", new Object[]{"conditionType_", "conditionTypeCase_", Timestamp.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Precondition> parser = PARSER;
                if (parser == null) {
                    synchronized (Precondition.class) {
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

    public static Builder newBuilder(Precondition precondition) {
        return DEFAULT_INSTANCE.r(precondition);
    }

    public static Precondition parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Precondition) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Precondition parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Precondition) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Precondition parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (Precondition) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
    }

    public static Precondition parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Precondition) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Precondition parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (Precondition) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
    }

    public static Precondition parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Precondition) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Precondition parseFrom(InputStream inputStream) throws IOException {
        return (Precondition) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
    }

    public static Precondition parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Precondition) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Precondition parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Precondition) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Precondition parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Precondition) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
