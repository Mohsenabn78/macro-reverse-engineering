package com.google.api;

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
public final class Endpoint extends GeneratedMessageLite<Endpoint, Builder> implements EndpointOrBuilder {
    public static final int ALIASES_FIELD_NUMBER = 2;
    public static final int ALLOW_CORS_FIELD_NUMBER = 5;
    private static final Endpoint DEFAULT_INSTANCE;
    public static final int FEATURES_FIELD_NUMBER = 4;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile Parser<Endpoint> PARSER = null;
    public static final int TARGET_FIELD_NUMBER = 101;
    private boolean allowCors_;
    private String name_ = "";
    private Internal.ProtobufList<String> aliases_ = GeneratedMessageLite.y();
    private Internal.ProtobufList<String> features_ = GeneratedMessageLite.y();
    private String target_ = "";

    /* renamed from: com.google.api.Endpoint$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f25406a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f25406a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f25406a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f25406a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f25406a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f25406a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f25406a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f25406a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<Endpoint, Builder> implements EndpointOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Deprecated
        public Builder addAliases(String str) {
            f();
            ((Endpoint) this.f33398b).y0(str);
            return this;
        }

        @Deprecated
        public Builder addAliasesBytes(ByteString byteString) {
            f();
            ((Endpoint) this.f33398b).z0(byteString);
            return this;
        }

        @Deprecated
        public Builder addAllAliases(Iterable<String> iterable) {
            f();
            ((Endpoint) this.f33398b).A0(iterable);
            return this;
        }

        public Builder addAllFeatures(Iterable<String> iterable) {
            f();
            ((Endpoint) this.f33398b).B0(iterable);
            return this;
        }

        public Builder addFeatures(String str) {
            f();
            ((Endpoint) this.f33398b).C0(str);
            return this;
        }

        public Builder addFeaturesBytes(ByteString byteString) {
            f();
            ((Endpoint) this.f33398b).D0(byteString);
            return this;
        }

        @Deprecated
        public Builder clearAliases() {
            f();
            ((Endpoint) this.f33398b).E0();
            return this;
        }

        public Builder clearAllowCors() {
            f();
            ((Endpoint) this.f33398b).F0();
            return this;
        }

        public Builder clearFeatures() {
            f();
            ((Endpoint) this.f33398b).G0();
            return this;
        }

        public Builder clearName() {
            f();
            ((Endpoint) this.f33398b).H0();
            return this;
        }

        public Builder clearTarget() {
            f();
            ((Endpoint) this.f33398b).I0();
            return this;
        }

        @Override // com.google.api.EndpointOrBuilder
        @Deprecated
        public String getAliases(int i4) {
            return ((Endpoint) this.f33398b).getAliases(i4);
        }

        @Override // com.google.api.EndpointOrBuilder
        @Deprecated
        public ByteString getAliasesBytes(int i4) {
            return ((Endpoint) this.f33398b).getAliasesBytes(i4);
        }

        @Override // com.google.api.EndpointOrBuilder
        @Deprecated
        public int getAliasesCount() {
            return ((Endpoint) this.f33398b).getAliasesCount();
        }

        @Override // com.google.api.EndpointOrBuilder
        @Deprecated
        public List<String> getAliasesList() {
            return Collections.unmodifiableList(((Endpoint) this.f33398b).getAliasesList());
        }

        @Override // com.google.api.EndpointOrBuilder
        public boolean getAllowCors() {
            return ((Endpoint) this.f33398b).getAllowCors();
        }

        @Override // com.google.api.EndpointOrBuilder
        public String getFeatures(int i4) {
            return ((Endpoint) this.f33398b).getFeatures(i4);
        }

        @Override // com.google.api.EndpointOrBuilder
        public ByteString getFeaturesBytes(int i4) {
            return ((Endpoint) this.f33398b).getFeaturesBytes(i4);
        }

        @Override // com.google.api.EndpointOrBuilder
        public int getFeaturesCount() {
            return ((Endpoint) this.f33398b).getFeaturesCount();
        }

        @Override // com.google.api.EndpointOrBuilder
        public List<String> getFeaturesList() {
            return Collections.unmodifiableList(((Endpoint) this.f33398b).getFeaturesList());
        }

        @Override // com.google.api.EndpointOrBuilder
        public String getName() {
            return ((Endpoint) this.f33398b).getName();
        }

        @Override // com.google.api.EndpointOrBuilder
        public ByteString getNameBytes() {
            return ((Endpoint) this.f33398b).getNameBytes();
        }

        @Override // com.google.api.EndpointOrBuilder
        public String getTarget() {
            return ((Endpoint) this.f33398b).getTarget();
        }

        @Override // com.google.api.EndpointOrBuilder
        public ByteString getTargetBytes() {
            return ((Endpoint) this.f33398b).getTargetBytes();
        }

        @Deprecated
        public Builder setAliases(int i4, String str) {
            f();
            ((Endpoint) this.f33398b).L0(i4, str);
            return this;
        }

        public Builder setAllowCors(boolean z3) {
            f();
            ((Endpoint) this.f33398b).M0(z3);
            return this;
        }

        public Builder setFeatures(int i4, String str) {
            f();
            ((Endpoint) this.f33398b).N0(i4, str);
            return this;
        }

        public Builder setName(String str) {
            f();
            ((Endpoint) this.f33398b).O0(str);
            return this;
        }

        public Builder setNameBytes(ByteString byteString) {
            f();
            ((Endpoint) this.f33398b).P0(byteString);
            return this;
        }

        public Builder setTarget(String str) {
            f();
            ((Endpoint) this.f33398b).Q0(str);
            return this;
        }

        public Builder setTargetBytes(ByteString byteString) {
            f();
            ((Endpoint) this.f33398b).R0(byteString);
            return this;
        }

        private Builder() {
            super(Endpoint.DEFAULT_INSTANCE);
        }
    }

    static {
        Endpoint endpoint = new Endpoint();
        DEFAULT_INSTANCE = endpoint;
        GeneratedMessageLite.d0(Endpoint.class, endpoint);
    }

    private Endpoint() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0(Iterable<String> iterable) {
        J0();
        AbstractMessageLite.a(iterable, this.aliases_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B0(Iterable<String> iterable) {
        K0();
        AbstractMessageLite.a(iterable, this.features_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C0(String str) {
        str.getClass();
        K0();
        this.features_.add(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D0(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        K0();
        this.features_.add(byteString.toStringUtf8());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E0() {
        this.aliases_ = GeneratedMessageLite.y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F0() {
        this.allowCors_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G0() {
        this.features_ = GeneratedMessageLite.y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H0() {
        this.name_ = getDefaultInstance().getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I0() {
        this.target_ = getDefaultInstance().getTarget();
    }

    private void J0() {
        Internal.ProtobufList<String> protobufList = this.aliases_;
        if (!protobufList.isModifiable()) {
            this.aliases_ = GeneratedMessageLite.K(protobufList);
        }
    }

    private void K0() {
        Internal.ProtobufList<String> protobufList = this.features_;
        if (!protobufList.isModifiable()) {
            this.features_ = GeneratedMessageLite.K(protobufList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L0(int i4, String str) {
        str.getClass();
        J0();
        this.aliases_.set(i4, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M0(boolean z3) {
        this.allowCors_ = z3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N0(int i4, String str) {
        str.getClass();
        K0();
        this.features_.set(i4, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O0(String str) {
        str.getClass();
        this.name_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P0(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        this.name_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q0(String str) {
        str.getClass();
        this.target_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R0(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        this.target_ = byteString.toStringUtf8();
    }

    public static Endpoint getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.q();
    }

    public static Endpoint parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Endpoint) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
    }

    public static Endpoint parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (Endpoint) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Endpoint> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0(String str) {
        str.getClass();
        J0();
        this.aliases_.add(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        J0();
        this.aliases_.add(byteString.toStringUtf8());
    }

    @Override // com.google.api.EndpointOrBuilder
    @Deprecated
    public String getAliases(int i4) {
        return this.aliases_.get(i4);
    }

    @Override // com.google.api.EndpointOrBuilder
    @Deprecated
    public ByteString getAliasesBytes(int i4) {
        return ByteString.copyFromUtf8(this.aliases_.get(i4));
    }

    @Override // com.google.api.EndpointOrBuilder
    @Deprecated
    public int getAliasesCount() {
        return this.aliases_.size();
    }

    @Override // com.google.api.EndpointOrBuilder
    @Deprecated
    public List<String> getAliasesList() {
        return this.aliases_;
    }

    @Override // com.google.api.EndpointOrBuilder
    public boolean getAllowCors() {
        return this.allowCors_;
    }

    @Override // com.google.api.EndpointOrBuilder
    public String getFeatures(int i4) {
        return this.features_.get(i4);
    }

    @Override // com.google.api.EndpointOrBuilder
    public ByteString getFeaturesBytes(int i4) {
        return ByteString.copyFromUtf8(this.features_.get(i4));
    }

    @Override // com.google.api.EndpointOrBuilder
    public int getFeaturesCount() {
        return this.features_.size();
    }

    @Override // com.google.api.EndpointOrBuilder
    public List<String> getFeaturesList() {
        return this.features_;
    }

    @Override // com.google.api.EndpointOrBuilder
    public String getName() {
        return this.name_;
    }

    @Override // com.google.api.EndpointOrBuilder
    public ByteString getNameBytes() {
        return ByteString.copyFromUtf8(this.name_);
    }

    @Override // com.google.api.EndpointOrBuilder
    public String getTarget() {
        return this.target_;
    }

    @Override // com.google.api.EndpointOrBuilder
    public ByteString getTargetBytes() {
        return ByteString.copyFromUtf8(this.target_);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.f25406a[methodToInvoke.ordinal()]) {
            case 1:
                return new Endpoint();
            case 2:
                return new Builder(null);
            case 3:
                return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001e\u0005\u0000\u0002\u0000\u0001Ȉ\u0002Ț\u0004Ț\u0005\u0007eȈ", new Object[]{"name_", "aliases_", "features_", "allowCors_", "target_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Endpoint> parser = PARSER;
                if (parser == null) {
                    synchronized (Endpoint.class) {
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

    public static Builder newBuilder(Endpoint endpoint) {
        return DEFAULT_INSTANCE.r(endpoint);
    }

    public static Endpoint parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Endpoint) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Endpoint parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Endpoint) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Endpoint parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (Endpoint) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
    }

    public static Endpoint parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Endpoint) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Endpoint parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (Endpoint) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
    }

    public static Endpoint parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Endpoint) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Endpoint parseFrom(InputStream inputStream) throws IOException {
        return (Endpoint) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
    }

    public static Endpoint parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Endpoint) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Endpoint parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Endpoint) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Endpoint parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Endpoint) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
