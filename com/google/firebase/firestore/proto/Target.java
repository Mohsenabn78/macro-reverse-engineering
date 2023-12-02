package com.google.firebase.firestore.proto;

import com.google.firestore.v1.Target;
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
public final class Target extends GeneratedMessageLite<Target, Builder> implements TargetOrBuilder {
    private static final Target DEFAULT_INSTANCE;
    public static final int DOCUMENTS_FIELD_NUMBER = 6;
    public static final int LAST_LIMBO_FREE_SNAPSHOT_VERSION_FIELD_NUMBER = 7;
    public static final int LAST_LISTEN_SEQUENCE_NUMBER_FIELD_NUMBER = 4;
    private static volatile Parser<Target> PARSER = null;
    public static final int QUERY_FIELD_NUMBER = 5;
    public static final int RESUME_TOKEN_FIELD_NUMBER = 3;
    public static final int SNAPSHOT_VERSION_FIELD_NUMBER = 2;
    public static final int TARGET_ID_FIELD_NUMBER = 1;
    private Timestamp lastLimboFreeSnapshotVersion_;
    private long lastListenSequenceNumber_;
    private Timestamp snapshotVersion_;
    private int targetId_;
    private Object targetType_;
    private int targetTypeCase_ = 0;
    private ByteString resumeToken_ = ByteString.EMPTY;

    /* renamed from: com.google.firebase.firestore.proto.Target$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f31014a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f31014a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f31014a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f31014a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f31014a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f31014a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f31014a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f31014a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<Target, Builder> implements TargetOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearDocuments() {
            f();
            ((Target) this.f33398b).z0();
            return this;
        }

        public Builder clearLastLimboFreeSnapshotVersion() {
            f();
            ((Target) this.f33398b).A0();
            return this;
        }

        public Builder clearLastListenSequenceNumber() {
            f();
            ((Target) this.f33398b).B0();
            return this;
        }

        public Builder clearQuery() {
            f();
            ((Target) this.f33398b).C0();
            return this;
        }

        public Builder clearResumeToken() {
            f();
            ((Target) this.f33398b).D0();
            return this;
        }

        public Builder clearSnapshotVersion() {
            f();
            ((Target) this.f33398b).E0();
            return this;
        }

        public Builder clearTargetId() {
            f();
            ((Target) this.f33398b).F0();
            return this;
        }

        public Builder clearTargetType() {
            f();
            ((Target) this.f33398b).G0();
            return this;
        }

        @Override // com.google.firebase.firestore.proto.TargetOrBuilder
        public Target.DocumentsTarget getDocuments() {
            return ((Target) this.f33398b).getDocuments();
        }

        @Override // com.google.firebase.firestore.proto.TargetOrBuilder
        public Timestamp getLastLimboFreeSnapshotVersion() {
            return ((Target) this.f33398b).getLastLimboFreeSnapshotVersion();
        }

        @Override // com.google.firebase.firestore.proto.TargetOrBuilder
        public long getLastListenSequenceNumber() {
            return ((Target) this.f33398b).getLastListenSequenceNumber();
        }

        @Override // com.google.firebase.firestore.proto.TargetOrBuilder
        public Target.QueryTarget getQuery() {
            return ((Target) this.f33398b).getQuery();
        }

        @Override // com.google.firebase.firestore.proto.TargetOrBuilder
        public ByteString getResumeToken() {
            return ((Target) this.f33398b).getResumeToken();
        }

        @Override // com.google.firebase.firestore.proto.TargetOrBuilder
        public Timestamp getSnapshotVersion() {
            return ((Target) this.f33398b).getSnapshotVersion();
        }

        @Override // com.google.firebase.firestore.proto.TargetOrBuilder
        public int getTargetId() {
            return ((Target) this.f33398b).getTargetId();
        }

        @Override // com.google.firebase.firestore.proto.TargetOrBuilder
        public TargetTypeCase getTargetTypeCase() {
            return ((Target) this.f33398b).getTargetTypeCase();
        }

        @Override // com.google.firebase.firestore.proto.TargetOrBuilder
        public boolean hasDocuments() {
            return ((Target) this.f33398b).hasDocuments();
        }

        @Override // com.google.firebase.firestore.proto.TargetOrBuilder
        public boolean hasLastLimboFreeSnapshotVersion() {
            return ((Target) this.f33398b).hasLastLimboFreeSnapshotVersion();
        }

        @Override // com.google.firebase.firestore.proto.TargetOrBuilder
        public boolean hasQuery() {
            return ((Target) this.f33398b).hasQuery();
        }

        @Override // com.google.firebase.firestore.proto.TargetOrBuilder
        public boolean hasSnapshotVersion() {
            return ((Target) this.f33398b).hasSnapshotVersion();
        }

        public Builder mergeDocuments(Target.DocumentsTarget documentsTarget) {
            f();
            ((Target) this.f33398b).H0(documentsTarget);
            return this;
        }

        public Builder mergeLastLimboFreeSnapshotVersion(Timestamp timestamp) {
            f();
            ((Target) this.f33398b).I0(timestamp);
            return this;
        }

        public Builder mergeQuery(Target.QueryTarget queryTarget) {
            f();
            ((Target) this.f33398b).J0(queryTarget);
            return this;
        }

        public Builder mergeSnapshotVersion(Timestamp timestamp) {
            f();
            ((Target) this.f33398b).K0(timestamp);
            return this;
        }

        public Builder setDocuments(Target.DocumentsTarget documentsTarget) {
            f();
            ((Target) this.f33398b).L0(documentsTarget);
            return this;
        }

        public Builder setLastLimboFreeSnapshotVersion(Timestamp timestamp) {
            f();
            ((Target) this.f33398b).M0(timestamp);
            return this;
        }

        public Builder setLastListenSequenceNumber(long j4) {
            f();
            ((Target) this.f33398b).N0(j4);
            return this;
        }

        public Builder setQuery(Target.QueryTarget queryTarget) {
            f();
            ((Target) this.f33398b).O0(queryTarget);
            return this;
        }

        public Builder setResumeToken(ByteString byteString) {
            f();
            ((Target) this.f33398b).P0(byteString);
            return this;
        }

        public Builder setSnapshotVersion(Timestamp timestamp) {
            f();
            ((Target) this.f33398b).Q0(timestamp);
            return this;
        }

        public Builder setTargetId(int i4) {
            f();
            ((Target) this.f33398b).R0(i4);
            return this;
        }

        private Builder() {
            super(Target.DEFAULT_INSTANCE);
        }

        public Builder setDocuments(Target.DocumentsTarget.Builder builder) {
            f();
            ((Target) this.f33398b).L0(builder.build());
            return this;
        }

        public Builder setLastLimboFreeSnapshotVersion(Timestamp.Builder builder) {
            f();
            ((Target) this.f33398b).M0(builder.build());
            return this;
        }

        public Builder setQuery(Target.QueryTarget.Builder builder) {
            f();
            ((Target) this.f33398b).O0(builder.build());
            return this;
        }

        public Builder setSnapshotVersion(Timestamp.Builder builder) {
            f();
            ((Target) this.f33398b).Q0(builder.build());
            return this;
        }
    }

    /* loaded from: classes5.dex */
    public enum TargetTypeCase {
        QUERY(5),
        DOCUMENTS(6),
        TARGETTYPE_NOT_SET(0);
        
        private final int value;

        TargetTypeCase(int i4) {
            this.value = i4;
        }

        public static TargetTypeCase forNumber(int i4) {
            if (i4 != 0) {
                if (i4 != 5) {
                    if (i4 != 6) {
                        return null;
                    }
                    return DOCUMENTS;
                }
                return QUERY;
            }
            return TARGETTYPE_NOT_SET;
        }

        public int getNumber() {
            return this.value;
        }

        @Deprecated
        public static TargetTypeCase valueOf(int i4) {
            return forNumber(i4);
        }
    }

    static {
        Target target = new Target();
        DEFAULT_INSTANCE = target;
        GeneratedMessageLite.d0(Target.class, target);
    }

    private Target() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0() {
        this.lastLimboFreeSnapshotVersion_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B0() {
        this.lastListenSequenceNumber_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C0() {
        if (this.targetTypeCase_ == 5) {
            this.targetTypeCase_ = 0;
            this.targetType_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D0() {
        this.resumeToken_ = getDefaultInstance().getResumeToken();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E0() {
        this.snapshotVersion_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F0() {
        this.targetId_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G0() {
        this.targetTypeCase_ = 0;
        this.targetType_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H0(Target.DocumentsTarget documentsTarget) {
        documentsTarget.getClass();
        if (this.targetTypeCase_ == 6 && this.targetType_ != Target.DocumentsTarget.getDefaultInstance()) {
            this.targetType_ = Target.DocumentsTarget.newBuilder((Target.DocumentsTarget) this.targetType_).mergeFrom((Target.DocumentsTarget.Builder) documentsTarget).buildPartial();
        } else {
            this.targetType_ = documentsTarget;
        }
        this.targetTypeCase_ = 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I0(Timestamp timestamp) {
        timestamp.getClass();
        Timestamp timestamp2 = this.lastLimboFreeSnapshotVersion_;
        if (timestamp2 != null && timestamp2 != Timestamp.getDefaultInstance()) {
            this.lastLimboFreeSnapshotVersion_ = Timestamp.newBuilder(this.lastLimboFreeSnapshotVersion_).mergeFrom((Timestamp.Builder) timestamp).buildPartial();
        } else {
            this.lastLimboFreeSnapshotVersion_ = timestamp;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J0(Target.QueryTarget queryTarget) {
        queryTarget.getClass();
        if (this.targetTypeCase_ == 5 && this.targetType_ != Target.QueryTarget.getDefaultInstance()) {
            this.targetType_ = Target.QueryTarget.newBuilder((Target.QueryTarget) this.targetType_).mergeFrom((Target.QueryTarget.Builder) queryTarget).buildPartial();
        } else {
            this.targetType_ = queryTarget;
        }
        this.targetTypeCase_ = 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K0(Timestamp timestamp) {
        timestamp.getClass();
        Timestamp timestamp2 = this.snapshotVersion_;
        if (timestamp2 != null && timestamp2 != Timestamp.getDefaultInstance()) {
            this.snapshotVersion_ = Timestamp.newBuilder(this.snapshotVersion_).mergeFrom((Timestamp.Builder) timestamp).buildPartial();
        } else {
            this.snapshotVersion_ = timestamp;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L0(Target.DocumentsTarget documentsTarget) {
        documentsTarget.getClass();
        this.targetType_ = documentsTarget;
        this.targetTypeCase_ = 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M0(Timestamp timestamp) {
        timestamp.getClass();
        this.lastLimboFreeSnapshotVersion_ = timestamp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N0(long j4) {
        this.lastListenSequenceNumber_ = j4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O0(Target.QueryTarget queryTarget) {
        queryTarget.getClass();
        this.targetType_ = queryTarget;
        this.targetTypeCase_ = 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P0(ByteString byteString) {
        byteString.getClass();
        this.resumeToken_ = byteString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q0(Timestamp timestamp) {
        timestamp.getClass();
        this.snapshotVersion_ = timestamp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R0(int i4) {
        this.targetId_ = i4;
    }

    public static Target getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.q();
    }

    public static Target parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Target) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
    }

    public static Target parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (Target) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Target> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0() {
        if (this.targetTypeCase_ == 6) {
            this.targetTypeCase_ = 0;
            this.targetType_ = null;
        }
    }

    @Override // com.google.firebase.firestore.proto.TargetOrBuilder
    public Target.DocumentsTarget getDocuments() {
        if (this.targetTypeCase_ == 6) {
            return (Target.DocumentsTarget) this.targetType_;
        }
        return Target.DocumentsTarget.getDefaultInstance();
    }

    @Override // com.google.firebase.firestore.proto.TargetOrBuilder
    public Timestamp getLastLimboFreeSnapshotVersion() {
        Timestamp timestamp = this.lastLimboFreeSnapshotVersion_;
        if (timestamp == null) {
            return Timestamp.getDefaultInstance();
        }
        return timestamp;
    }

    @Override // com.google.firebase.firestore.proto.TargetOrBuilder
    public long getLastListenSequenceNumber() {
        return this.lastListenSequenceNumber_;
    }

    @Override // com.google.firebase.firestore.proto.TargetOrBuilder
    public Target.QueryTarget getQuery() {
        if (this.targetTypeCase_ == 5) {
            return (Target.QueryTarget) this.targetType_;
        }
        return Target.QueryTarget.getDefaultInstance();
    }

    @Override // com.google.firebase.firestore.proto.TargetOrBuilder
    public ByteString getResumeToken() {
        return this.resumeToken_;
    }

    @Override // com.google.firebase.firestore.proto.TargetOrBuilder
    public Timestamp getSnapshotVersion() {
        Timestamp timestamp = this.snapshotVersion_;
        if (timestamp == null) {
            return Timestamp.getDefaultInstance();
        }
        return timestamp;
    }

    @Override // com.google.firebase.firestore.proto.TargetOrBuilder
    public int getTargetId() {
        return this.targetId_;
    }

    @Override // com.google.firebase.firestore.proto.TargetOrBuilder
    public TargetTypeCase getTargetTypeCase() {
        return TargetTypeCase.forNumber(this.targetTypeCase_);
    }

    @Override // com.google.firebase.firestore.proto.TargetOrBuilder
    public boolean hasDocuments() {
        if (this.targetTypeCase_ == 6) {
            return true;
        }
        return false;
    }

    @Override // com.google.firebase.firestore.proto.TargetOrBuilder
    public boolean hasLastLimboFreeSnapshotVersion() {
        if (this.lastLimboFreeSnapshotVersion_ != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.firebase.firestore.proto.TargetOrBuilder
    public boolean hasQuery() {
        if (this.targetTypeCase_ == 5) {
            return true;
        }
        return false;
    }

    @Override // com.google.firebase.firestore.proto.TargetOrBuilder
    public boolean hasSnapshotVersion() {
        if (this.snapshotVersion_ != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.f31014a[methodToInvoke.ordinal()]) {
            case 1:
                return new Target();
            case 2:
                return new Builder(null);
            case 3:
                return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0007\u0001\u0000\u0001\u0007\u0007\u0000\u0000\u0000\u0001\u0004\u0002\t\u0003\n\u0004\u0002\u0005<\u0000\u0006<\u0000\u0007\t", new Object[]{"targetType_", "targetTypeCase_", "targetId_", "snapshotVersion_", "resumeToken_", "lastListenSequenceNumber_", Target.QueryTarget.class, Target.DocumentsTarget.class, "lastLimboFreeSnapshotVersion_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Target> parser = PARSER;
                if (parser == null) {
                    synchronized (Target.class) {
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

    public static Builder newBuilder(Target target) {
        return DEFAULT_INSTANCE.r(target);
    }

    public static Target parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Target) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Target parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Target) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Target parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (Target) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
    }

    public static Target parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Target) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Target parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (Target) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
    }

    public static Target parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Target) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Target parseFrom(InputStream inputStream) throws IOException {
        return (Target) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
    }

    public static Target parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Target) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Target parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Target) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Target parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Target) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
