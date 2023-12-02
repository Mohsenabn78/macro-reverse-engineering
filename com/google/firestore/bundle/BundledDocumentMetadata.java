package com.google.firestore.bundle;

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
public final class BundledDocumentMetadata extends GeneratedMessageLite<BundledDocumentMetadata, Builder> implements BundledDocumentMetadataOrBuilder {
    private static final BundledDocumentMetadata DEFAULT_INSTANCE;
    public static final int EXISTS_FIELD_NUMBER = 3;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile Parser<BundledDocumentMetadata> PARSER = null;
    public static final int QUERIES_FIELD_NUMBER = 4;
    public static final int READ_TIME_FIELD_NUMBER = 2;
    private boolean exists_;
    private String name_ = "";
    private Internal.ProtobufList<String> queries_ = GeneratedMessageLite.y();
    private Timestamp readTime_;

    /* renamed from: com.google.firestore.bundle.BundledDocumentMetadata$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f32426a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f32426a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32426a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32426a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32426a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f32426a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f32426a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f32426a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<BundledDocumentMetadata, Builder> implements BundledDocumentMetadataOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllQueries(Iterable<String> iterable) {
            f();
            ((BundledDocumentMetadata) this.f33398b).t0(iterable);
            return this;
        }

        public Builder addQueries(String str) {
            f();
            ((BundledDocumentMetadata) this.f33398b).u0(str);
            return this;
        }

        public Builder addQueriesBytes(ByteString byteString) {
            f();
            ((BundledDocumentMetadata) this.f33398b).v0(byteString);
            return this;
        }

        public Builder clearExists() {
            f();
            ((BundledDocumentMetadata) this.f33398b).w0();
            return this;
        }

        public Builder clearName() {
            f();
            ((BundledDocumentMetadata) this.f33398b).x0();
            return this;
        }

        public Builder clearQueries() {
            f();
            ((BundledDocumentMetadata) this.f33398b).y0();
            return this;
        }

        public Builder clearReadTime() {
            f();
            ((BundledDocumentMetadata) this.f33398b).z0();
            return this;
        }

        @Override // com.google.firestore.bundle.BundledDocumentMetadataOrBuilder
        public boolean getExists() {
            return ((BundledDocumentMetadata) this.f33398b).getExists();
        }

        @Override // com.google.firestore.bundle.BundledDocumentMetadataOrBuilder
        public String getName() {
            return ((BundledDocumentMetadata) this.f33398b).getName();
        }

        @Override // com.google.firestore.bundle.BundledDocumentMetadataOrBuilder
        public ByteString getNameBytes() {
            return ((BundledDocumentMetadata) this.f33398b).getNameBytes();
        }

        @Override // com.google.firestore.bundle.BundledDocumentMetadataOrBuilder
        public String getQueries(int i4) {
            return ((BundledDocumentMetadata) this.f33398b).getQueries(i4);
        }

        @Override // com.google.firestore.bundle.BundledDocumentMetadataOrBuilder
        public ByteString getQueriesBytes(int i4) {
            return ((BundledDocumentMetadata) this.f33398b).getQueriesBytes(i4);
        }

        @Override // com.google.firestore.bundle.BundledDocumentMetadataOrBuilder
        public int getQueriesCount() {
            return ((BundledDocumentMetadata) this.f33398b).getQueriesCount();
        }

        @Override // com.google.firestore.bundle.BundledDocumentMetadataOrBuilder
        public List<String> getQueriesList() {
            return Collections.unmodifiableList(((BundledDocumentMetadata) this.f33398b).getQueriesList());
        }

        @Override // com.google.firestore.bundle.BundledDocumentMetadataOrBuilder
        public Timestamp getReadTime() {
            return ((BundledDocumentMetadata) this.f33398b).getReadTime();
        }

        @Override // com.google.firestore.bundle.BundledDocumentMetadataOrBuilder
        public boolean hasReadTime() {
            return ((BundledDocumentMetadata) this.f33398b).hasReadTime();
        }

        public Builder mergeReadTime(Timestamp timestamp) {
            f();
            ((BundledDocumentMetadata) this.f33398b).B0(timestamp);
            return this;
        }

        public Builder setExists(boolean z3) {
            f();
            ((BundledDocumentMetadata) this.f33398b).C0(z3);
            return this;
        }

        public Builder setName(String str) {
            f();
            ((BundledDocumentMetadata) this.f33398b).D0(str);
            return this;
        }

        public Builder setNameBytes(ByteString byteString) {
            f();
            ((BundledDocumentMetadata) this.f33398b).E0(byteString);
            return this;
        }

        public Builder setQueries(int i4, String str) {
            f();
            ((BundledDocumentMetadata) this.f33398b).F0(i4, str);
            return this;
        }

        public Builder setReadTime(Timestamp timestamp) {
            f();
            ((BundledDocumentMetadata) this.f33398b).G0(timestamp);
            return this;
        }

        private Builder() {
            super(BundledDocumentMetadata.DEFAULT_INSTANCE);
        }

        public Builder setReadTime(Timestamp.Builder builder) {
            f();
            ((BundledDocumentMetadata) this.f33398b).G0(builder.build());
            return this;
        }
    }

    static {
        BundledDocumentMetadata bundledDocumentMetadata = new BundledDocumentMetadata();
        DEFAULT_INSTANCE = bundledDocumentMetadata;
        GeneratedMessageLite.d0(BundledDocumentMetadata.class, bundledDocumentMetadata);
    }

    private BundledDocumentMetadata() {
    }

    private void A0() {
        Internal.ProtobufList<String> protobufList = this.queries_;
        if (!protobufList.isModifiable()) {
            this.queries_ = GeneratedMessageLite.K(protobufList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B0(Timestamp timestamp) {
        timestamp.getClass();
        Timestamp timestamp2 = this.readTime_;
        if (timestamp2 != null && timestamp2 != Timestamp.getDefaultInstance()) {
            this.readTime_ = Timestamp.newBuilder(this.readTime_).mergeFrom((Timestamp.Builder) timestamp).buildPartial();
        } else {
            this.readTime_ = timestamp;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C0(boolean z3) {
        this.exists_ = z3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D0(String str) {
        str.getClass();
        this.name_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E0(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        this.name_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F0(int i4, String str) {
        str.getClass();
        A0();
        this.queries_.set(i4, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G0(Timestamp timestamp) {
        timestamp.getClass();
        this.readTime_ = timestamp;
    }

    public static BundledDocumentMetadata getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.q();
    }

    public static BundledDocumentMetadata parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (BundledDocumentMetadata) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
    }

    public static BundledDocumentMetadata parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (BundledDocumentMetadata) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<BundledDocumentMetadata> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t0(Iterable<String> iterable) {
        A0();
        AbstractMessageLite.a(iterable, this.queries_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u0(String str) {
        str.getClass();
        A0();
        this.queries_.add(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v0(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        A0();
        this.queries_.add(byteString.toStringUtf8());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w0() {
        this.exists_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0() {
        this.name_ = getDefaultInstance().getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0() {
        this.queries_ = GeneratedMessageLite.y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0() {
        this.readTime_ = null;
    }

    @Override // com.google.firestore.bundle.BundledDocumentMetadataOrBuilder
    public boolean getExists() {
        return this.exists_;
    }

    @Override // com.google.firestore.bundle.BundledDocumentMetadataOrBuilder
    public String getName() {
        return this.name_;
    }

    @Override // com.google.firestore.bundle.BundledDocumentMetadataOrBuilder
    public ByteString getNameBytes() {
        return ByteString.copyFromUtf8(this.name_);
    }

    @Override // com.google.firestore.bundle.BundledDocumentMetadataOrBuilder
    public String getQueries(int i4) {
        return this.queries_.get(i4);
    }

    @Override // com.google.firestore.bundle.BundledDocumentMetadataOrBuilder
    public ByteString getQueriesBytes(int i4) {
        return ByteString.copyFromUtf8(this.queries_.get(i4));
    }

    @Override // com.google.firestore.bundle.BundledDocumentMetadataOrBuilder
    public int getQueriesCount() {
        return this.queries_.size();
    }

    @Override // com.google.firestore.bundle.BundledDocumentMetadataOrBuilder
    public List<String> getQueriesList() {
        return this.queries_;
    }

    @Override // com.google.firestore.bundle.BundledDocumentMetadataOrBuilder
    public Timestamp getReadTime() {
        Timestamp timestamp = this.readTime_;
        if (timestamp == null) {
            return Timestamp.getDefaultInstance();
        }
        return timestamp;
    }

    @Override // com.google.firestore.bundle.BundledDocumentMetadataOrBuilder
    public boolean hasReadTime() {
        if (this.readTime_ != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.f32426a[methodToInvoke.ordinal()]) {
            case 1:
                return new BundledDocumentMetadata();
            case 2:
                return new Builder(null);
            case 3:
                return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0001\u0000\u0001Ȉ\u0002\t\u0003\u0007\u0004Ț", new Object[]{"name_", "readTime_", "exists_", "queries_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<BundledDocumentMetadata> parser = PARSER;
                if (parser == null) {
                    synchronized (BundledDocumentMetadata.class) {
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

    public static Builder newBuilder(BundledDocumentMetadata bundledDocumentMetadata) {
        return DEFAULT_INSTANCE.r(bundledDocumentMetadata);
    }

    public static BundledDocumentMetadata parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (BundledDocumentMetadata) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static BundledDocumentMetadata parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (BundledDocumentMetadata) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static BundledDocumentMetadata parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (BundledDocumentMetadata) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
    }

    public static BundledDocumentMetadata parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (BundledDocumentMetadata) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static BundledDocumentMetadata parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (BundledDocumentMetadata) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
    }

    public static BundledDocumentMetadata parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (BundledDocumentMetadata) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static BundledDocumentMetadata parseFrom(InputStream inputStream) throws IOException {
        return (BundledDocumentMetadata) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
    }

    public static BundledDocumentMetadata parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (BundledDocumentMetadata) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static BundledDocumentMetadata parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (BundledDocumentMetadata) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
    }

    public static BundledDocumentMetadata parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (BundledDocumentMetadata) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
