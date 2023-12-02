package com.google.firestore.bundle;

import com.google.protobuf.AbstractMessageLite;
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
public final class BundleMetadata extends GeneratedMessageLite<BundleMetadata, Builder> implements BundleMetadataOrBuilder {
    public static final int CREATE_TIME_FIELD_NUMBER = 2;
    private static final BundleMetadata DEFAULT_INSTANCE;
    public static final int ID_FIELD_NUMBER = 1;
    private static volatile Parser<BundleMetadata> PARSER = null;
    public static final int TOTAL_BYTES_FIELD_NUMBER = 5;
    public static final int TOTAL_DOCUMENTS_FIELD_NUMBER = 4;
    public static final int VERSION_FIELD_NUMBER = 3;
    private Timestamp createTime_;
    private String id_ = "";
    private long totalBytes_;
    private int totalDocuments_;
    private int version_;

    /* renamed from: com.google.firestore.bundle.BundleMetadata$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f32425a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f32425a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32425a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32425a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32425a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f32425a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f32425a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f32425a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<BundleMetadata, Builder> implements BundleMetadataOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearCreateTime() {
            f();
            ((BundleMetadata) this.f33398b).s0();
            return this;
        }

        public Builder clearId() {
            f();
            ((BundleMetadata) this.f33398b).t0();
            return this;
        }

        public Builder clearTotalBytes() {
            f();
            ((BundleMetadata) this.f33398b).u0();
            return this;
        }

        public Builder clearTotalDocuments() {
            f();
            ((BundleMetadata) this.f33398b).v0();
            return this;
        }

        public Builder clearVersion() {
            f();
            ((BundleMetadata) this.f33398b).w0();
            return this;
        }

        @Override // com.google.firestore.bundle.BundleMetadataOrBuilder
        public Timestamp getCreateTime() {
            return ((BundleMetadata) this.f33398b).getCreateTime();
        }

        @Override // com.google.firestore.bundle.BundleMetadataOrBuilder
        public String getId() {
            return ((BundleMetadata) this.f33398b).getId();
        }

        @Override // com.google.firestore.bundle.BundleMetadataOrBuilder
        public ByteString getIdBytes() {
            return ((BundleMetadata) this.f33398b).getIdBytes();
        }

        @Override // com.google.firestore.bundle.BundleMetadataOrBuilder
        public long getTotalBytes() {
            return ((BundleMetadata) this.f33398b).getTotalBytes();
        }

        @Override // com.google.firestore.bundle.BundleMetadataOrBuilder
        public int getTotalDocuments() {
            return ((BundleMetadata) this.f33398b).getTotalDocuments();
        }

        @Override // com.google.firestore.bundle.BundleMetadataOrBuilder
        public int getVersion() {
            return ((BundleMetadata) this.f33398b).getVersion();
        }

        @Override // com.google.firestore.bundle.BundleMetadataOrBuilder
        public boolean hasCreateTime() {
            return ((BundleMetadata) this.f33398b).hasCreateTime();
        }

        public Builder mergeCreateTime(Timestamp timestamp) {
            f();
            ((BundleMetadata) this.f33398b).x0(timestamp);
            return this;
        }

        public Builder setCreateTime(Timestamp timestamp) {
            f();
            ((BundleMetadata) this.f33398b).y0(timestamp);
            return this;
        }

        public Builder setId(String str) {
            f();
            ((BundleMetadata) this.f33398b).z0(str);
            return this;
        }

        public Builder setIdBytes(ByteString byteString) {
            f();
            ((BundleMetadata) this.f33398b).A0(byteString);
            return this;
        }

        public Builder setTotalBytes(long j4) {
            f();
            ((BundleMetadata) this.f33398b).B0(j4);
            return this;
        }

        public Builder setTotalDocuments(int i4) {
            f();
            ((BundleMetadata) this.f33398b).C0(i4);
            return this;
        }

        public Builder setVersion(int i4) {
            f();
            ((BundleMetadata) this.f33398b).D0(i4);
            return this;
        }

        private Builder() {
            super(BundleMetadata.DEFAULT_INSTANCE);
        }

        public Builder setCreateTime(Timestamp.Builder builder) {
            f();
            ((BundleMetadata) this.f33398b).y0(builder.build());
            return this;
        }
    }

    static {
        BundleMetadata bundleMetadata = new BundleMetadata();
        DEFAULT_INSTANCE = bundleMetadata;
        GeneratedMessageLite.d0(BundleMetadata.class, bundleMetadata);
    }

    private BundleMetadata() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        this.id_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B0(long j4) {
        this.totalBytes_ = j4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C0(int i4) {
        this.totalDocuments_ = i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D0(int i4) {
        this.version_ = i4;
    }

    public static BundleMetadata getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.q();
    }

    public static BundleMetadata parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (BundleMetadata) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
    }

    public static BundleMetadata parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (BundleMetadata) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<BundleMetadata> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0() {
        this.createTime_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t0() {
        this.id_ = getDefaultInstance().getId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u0() {
        this.totalBytes_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v0() {
        this.totalDocuments_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w0() {
        this.version_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0(Timestamp timestamp) {
        timestamp.getClass();
        Timestamp timestamp2 = this.createTime_;
        if (timestamp2 != null && timestamp2 != Timestamp.getDefaultInstance()) {
            this.createTime_ = Timestamp.newBuilder(this.createTime_).mergeFrom((Timestamp.Builder) timestamp).buildPartial();
        } else {
            this.createTime_ = timestamp;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0(Timestamp timestamp) {
        timestamp.getClass();
        this.createTime_ = timestamp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0(String str) {
        str.getClass();
        this.id_ = str;
    }

    @Override // com.google.firestore.bundle.BundleMetadataOrBuilder
    public Timestamp getCreateTime() {
        Timestamp timestamp = this.createTime_;
        if (timestamp == null) {
            return Timestamp.getDefaultInstance();
        }
        return timestamp;
    }

    @Override // com.google.firestore.bundle.BundleMetadataOrBuilder
    public String getId() {
        return this.id_;
    }

    @Override // com.google.firestore.bundle.BundleMetadataOrBuilder
    public ByteString getIdBytes() {
        return ByteString.copyFromUtf8(this.id_);
    }

    @Override // com.google.firestore.bundle.BundleMetadataOrBuilder
    public long getTotalBytes() {
        return this.totalBytes_;
    }

    @Override // com.google.firestore.bundle.BundleMetadataOrBuilder
    public int getTotalDocuments() {
        return this.totalDocuments_;
    }

    @Override // com.google.firestore.bundle.BundleMetadataOrBuilder
    public int getVersion() {
        return this.version_;
    }

    @Override // com.google.firestore.bundle.BundleMetadataOrBuilder
    public boolean hasCreateTime() {
        if (this.createTime_ != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.f32425a[methodToInvoke.ordinal()]) {
            case 1:
                return new BundleMetadata();
            case 2:
                return new Builder(null);
            case 3:
                return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002\t\u0003\u000b\u0004\u000b\u0005\u0003", new Object[]{"id_", "createTime_", "version_", "totalDocuments_", "totalBytes_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<BundleMetadata> parser = PARSER;
                if (parser == null) {
                    synchronized (BundleMetadata.class) {
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

    public static Builder newBuilder(BundleMetadata bundleMetadata) {
        return DEFAULT_INSTANCE.r(bundleMetadata);
    }

    public static BundleMetadata parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (BundleMetadata) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static BundleMetadata parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (BundleMetadata) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static BundleMetadata parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (BundleMetadata) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
    }

    public static BundleMetadata parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (BundleMetadata) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static BundleMetadata parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (BundleMetadata) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
    }

    public static BundleMetadata parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (BundleMetadata) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static BundleMetadata parseFrom(InputStream inputStream) throws IOException {
        return (BundleMetadata) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
    }

    public static BundleMetadata parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (BundleMetadata) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static BundleMetadata parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (BundleMetadata) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
    }

    public static BundleMetadata parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (BundleMetadata) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
