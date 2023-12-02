package com.google.api;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
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

/* loaded from: classes5.dex */
public final class BackendRule extends GeneratedMessageLite<BackendRule, Builder> implements BackendRuleOrBuilder {
    public static final int ADDRESS_FIELD_NUMBER = 2;
    public static final int DEADLINE_FIELD_NUMBER = 3;
    private static final BackendRule DEFAULT_INSTANCE;
    public static final int DISABLE_AUTH_FIELD_NUMBER = 8;
    public static final int JWT_AUDIENCE_FIELD_NUMBER = 7;
    public static final int MIN_DEADLINE_FIELD_NUMBER = 4;
    public static final int OPERATION_DEADLINE_FIELD_NUMBER = 5;
    private static volatile Parser<BackendRule> PARSER = null;
    public static final int PATH_TRANSLATION_FIELD_NUMBER = 6;
    public static final int PROTOCOL_FIELD_NUMBER = 9;
    public static final int SELECTOR_FIELD_NUMBER = 1;
    private Object authentication_;
    private double deadline_;
    private double minDeadline_;
    private double operationDeadline_;
    private int pathTranslation_;
    private int authenticationCase_ = 0;
    private String selector_ = "";
    private String address_ = "";
    private String protocol_ = "";

    /* renamed from: com.google.api.BackendRule$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f25388a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f25388a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f25388a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f25388a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f25388a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f25388a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f25388a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f25388a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public enum AuthenticationCase {
        JWT_AUDIENCE(7),
        DISABLE_AUTH(8),
        AUTHENTICATION_NOT_SET(0);
        
        private final int value;

        AuthenticationCase(int i4) {
            this.value = i4;
        }

        public static AuthenticationCase forNumber(int i4) {
            if (i4 != 0) {
                if (i4 != 7) {
                    if (i4 != 8) {
                        return null;
                    }
                    return DISABLE_AUTH;
                }
                return JWT_AUDIENCE;
            }
            return AUTHENTICATION_NOT_SET;
        }

        public int getNumber() {
            return this.value;
        }

        @Deprecated
        public static AuthenticationCase valueOf(int i4) {
            return forNumber(i4);
        }
    }

    /* loaded from: classes5.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<BackendRule, Builder> implements BackendRuleOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearAddress() {
            f();
            ((BackendRule) this.f33398b).E0();
            return this;
        }

        public Builder clearAuthentication() {
            f();
            ((BackendRule) this.f33398b).F0();
            return this;
        }

        public Builder clearDeadline() {
            f();
            ((BackendRule) this.f33398b).G0();
            return this;
        }

        public Builder clearDisableAuth() {
            f();
            ((BackendRule) this.f33398b).H0();
            return this;
        }

        public Builder clearJwtAudience() {
            f();
            ((BackendRule) this.f33398b).I0();
            return this;
        }

        public Builder clearMinDeadline() {
            f();
            ((BackendRule) this.f33398b).J0();
            return this;
        }

        public Builder clearOperationDeadline() {
            f();
            ((BackendRule) this.f33398b).K0();
            return this;
        }

        public Builder clearPathTranslation() {
            f();
            ((BackendRule) this.f33398b).L0();
            return this;
        }

        public Builder clearProtocol() {
            f();
            ((BackendRule) this.f33398b).M0();
            return this;
        }

        public Builder clearSelector() {
            f();
            ((BackendRule) this.f33398b).N0();
            return this;
        }

        @Override // com.google.api.BackendRuleOrBuilder
        public String getAddress() {
            return ((BackendRule) this.f33398b).getAddress();
        }

        @Override // com.google.api.BackendRuleOrBuilder
        public ByteString getAddressBytes() {
            return ((BackendRule) this.f33398b).getAddressBytes();
        }

        @Override // com.google.api.BackendRuleOrBuilder
        public AuthenticationCase getAuthenticationCase() {
            return ((BackendRule) this.f33398b).getAuthenticationCase();
        }

        @Override // com.google.api.BackendRuleOrBuilder
        public double getDeadline() {
            return ((BackendRule) this.f33398b).getDeadline();
        }

        @Override // com.google.api.BackendRuleOrBuilder
        public boolean getDisableAuth() {
            return ((BackendRule) this.f33398b).getDisableAuth();
        }

        @Override // com.google.api.BackendRuleOrBuilder
        public String getJwtAudience() {
            return ((BackendRule) this.f33398b).getJwtAudience();
        }

        @Override // com.google.api.BackendRuleOrBuilder
        public ByteString getJwtAudienceBytes() {
            return ((BackendRule) this.f33398b).getJwtAudienceBytes();
        }

        @Override // com.google.api.BackendRuleOrBuilder
        public double getMinDeadline() {
            return ((BackendRule) this.f33398b).getMinDeadline();
        }

        @Override // com.google.api.BackendRuleOrBuilder
        public double getOperationDeadline() {
            return ((BackendRule) this.f33398b).getOperationDeadline();
        }

        @Override // com.google.api.BackendRuleOrBuilder
        public PathTranslation getPathTranslation() {
            return ((BackendRule) this.f33398b).getPathTranslation();
        }

        @Override // com.google.api.BackendRuleOrBuilder
        public int getPathTranslationValue() {
            return ((BackendRule) this.f33398b).getPathTranslationValue();
        }

        @Override // com.google.api.BackendRuleOrBuilder
        public String getProtocol() {
            return ((BackendRule) this.f33398b).getProtocol();
        }

        @Override // com.google.api.BackendRuleOrBuilder
        public ByteString getProtocolBytes() {
            return ((BackendRule) this.f33398b).getProtocolBytes();
        }

        @Override // com.google.api.BackendRuleOrBuilder
        public String getSelector() {
            return ((BackendRule) this.f33398b).getSelector();
        }

        @Override // com.google.api.BackendRuleOrBuilder
        public ByteString getSelectorBytes() {
            return ((BackendRule) this.f33398b).getSelectorBytes();
        }

        public Builder setAddress(String str) {
            f();
            ((BackendRule) this.f33398b).O0(str);
            return this;
        }

        public Builder setAddressBytes(ByteString byteString) {
            f();
            ((BackendRule) this.f33398b).P0(byteString);
            return this;
        }

        public Builder setDeadline(double d4) {
            f();
            ((BackendRule) this.f33398b).Q0(d4);
            return this;
        }

        public Builder setDisableAuth(boolean z3) {
            f();
            ((BackendRule) this.f33398b).R0(z3);
            return this;
        }

        public Builder setJwtAudience(String str) {
            f();
            ((BackendRule) this.f33398b).S0(str);
            return this;
        }

        public Builder setJwtAudienceBytes(ByteString byteString) {
            f();
            ((BackendRule) this.f33398b).T0(byteString);
            return this;
        }

        public Builder setMinDeadline(double d4) {
            f();
            ((BackendRule) this.f33398b).U0(d4);
            return this;
        }

        public Builder setOperationDeadline(double d4) {
            f();
            ((BackendRule) this.f33398b).V0(d4);
            return this;
        }

        public Builder setPathTranslation(PathTranslation pathTranslation) {
            f();
            ((BackendRule) this.f33398b).W0(pathTranslation);
            return this;
        }

        public Builder setPathTranslationValue(int i4) {
            f();
            ((BackendRule) this.f33398b).X0(i4);
            return this;
        }

        public Builder setProtocol(String str) {
            f();
            ((BackendRule) this.f33398b).Y0(str);
            return this;
        }

        public Builder setProtocolBytes(ByteString byteString) {
            f();
            ((BackendRule) this.f33398b).Z0(byteString);
            return this;
        }

        public Builder setSelector(String str) {
            f();
            ((BackendRule) this.f33398b).a1(str);
            return this;
        }

        public Builder setSelectorBytes(ByteString byteString) {
            f();
            ((BackendRule) this.f33398b).b1(byteString);
            return this;
        }

        private Builder() {
            super(BackendRule.DEFAULT_INSTANCE);
        }
    }

    /* loaded from: classes5.dex */
    public enum PathTranslation implements Internal.EnumLite {
        PATH_TRANSLATION_UNSPECIFIED(0),
        CONSTANT_ADDRESS(1),
        APPEND_PATH_TO_ADDRESS(2),
        UNRECOGNIZED(-1);
        
        public static final int APPEND_PATH_TO_ADDRESS_VALUE = 2;
        public static final int CONSTANT_ADDRESS_VALUE = 1;
        public static final int PATH_TRANSLATION_UNSPECIFIED_VALUE = 0;

        /* renamed from: a  reason: collision with root package name */
        private static final Internal.EnumLiteMap<PathTranslation> f25390a = new Internal.EnumLiteMap<PathTranslation>() { // from class: com.google.api.BackendRule.PathTranslation.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            /* renamed from: a */
            public PathTranslation findValueByNumber(int i4) {
                return PathTranslation.forNumber(i4);
            }
        };
        private final int value;

        /* loaded from: classes5.dex */
        private static final class PathTranslationVerifier implements Internal.EnumVerifier {

            /* renamed from: a  reason: collision with root package name */
            static final Internal.EnumVerifier f25392a = new PathTranslationVerifier();

            private PathTranslationVerifier() {
            }

            @Override // com.google.protobuf.Internal.EnumVerifier
            public boolean isInRange(int i4) {
                if (PathTranslation.forNumber(i4) != null) {
                    return true;
                }
                return false;
            }
        }

        PathTranslation(int i4) {
            this.value = i4;
        }

        public static PathTranslation forNumber(int i4) {
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 != 2) {
                        return null;
                    }
                    return APPEND_PATH_TO_ADDRESS;
                }
                return CONSTANT_ADDRESS;
            }
            return PATH_TRANSLATION_UNSPECIFIED;
        }

        public static Internal.EnumLiteMap<PathTranslation> internalGetValueMap() {
            return f25390a;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return PathTranslationVerifier.f25392a;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static PathTranslation valueOf(int i4) {
            return forNumber(i4);
        }
    }

    static {
        BackendRule backendRule = new BackendRule();
        DEFAULT_INSTANCE = backendRule;
        GeneratedMessageLite.d0(BackendRule.class, backendRule);
    }

    private BackendRule() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E0() {
        this.address_ = getDefaultInstance().getAddress();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F0() {
        this.authenticationCase_ = 0;
        this.authentication_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G0() {
        this.deadline_ = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H0() {
        if (this.authenticationCase_ == 8) {
            this.authenticationCase_ = 0;
            this.authentication_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I0() {
        if (this.authenticationCase_ == 7) {
            this.authenticationCase_ = 0;
            this.authentication_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J0() {
        this.minDeadline_ = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K0() {
        this.operationDeadline_ = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L0() {
        this.pathTranslation_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M0() {
        this.protocol_ = getDefaultInstance().getProtocol();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N0() {
        this.selector_ = getDefaultInstance().getSelector();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O0(String str) {
        str.getClass();
        this.address_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P0(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        this.address_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q0(double d4) {
        this.deadline_ = d4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R0(boolean z3) {
        this.authenticationCase_ = 8;
        this.authentication_ = Boolean.valueOf(z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S0(String str) {
        str.getClass();
        this.authenticationCase_ = 7;
        this.authentication_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T0(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        this.authentication_ = byteString.toStringUtf8();
        this.authenticationCase_ = 7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U0(double d4) {
        this.minDeadline_ = d4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V0(double d4) {
        this.operationDeadline_ = d4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W0(PathTranslation pathTranslation) {
        this.pathTranslation_ = pathTranslation.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X0(int i4) {
        this.pathTranslation_ = i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y0(String str) {
        str.getClass();
        this.protocol_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z0(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        this.protocol_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a1(String str) {
        str.getClass();
        this.selector_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b1(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        this.selector_ = byteString.toStringUtf8();
    }

    public static BackendRule getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.q();
    }

    public static BackendRule parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (BackendRule) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
    }

    public static BackendRule parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (BackendRule) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<BackendRule> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    @Override // com.google.api.BackendRuleOrBuilder
    public String getAddress() {
        return this.address_;
    }

    @Override // com.google.api.BackendRuleOrBuilder
    public ByteString getAddressBytes() {
        return ByteString.copyFromUtf8(this.address_);
    }

    @Override // com.google.api.BackendRuleOrBuilder
    public AuthenticationCase getAuthenticationCase() {
        return AuthenticationCase.forNumber(this.authenticationCase_);
    }

    @Override // com.google.api.BackendRuleOrBuilder
    public double getDeadline() {
        return this.deadline_;
    }

    @Override // com.google.api.BackendRuleOrBuilder
    public boolean getDisableAuth() {
        if (this.authenticationCase_ == 8) {
            return ((Boolean) this.authentication_).booleanValue();
        }
        return false;
    }

    @Override // com.google.api.BackendRuleOrBuilder
    public String getJwtAudience() {
        if (this.authenticationCase_ == 7) {
            return (String) this.authentication_;
        }
        return "";
    }

    @Override // com.google.api.BackendRuleOrBuilder
    public ByteString getJwtAudienceBytes() {
        String str;
        if (this.authenticationCase_ == 7) {
            str = (String) this.authentication_;
        } else {
            str = "";
        }
        return ByteString.copyFromUtf8(str);
    }

    @Override // com.google.api.BackendRuleOrBuilder
    public double getMinDeadline() {
        return this.minDeadline_;
    }

    @Override // com.google.api.BackendRuleOrBuilder
    public double getOperationDeadline() {
        return this.operationDeadline_;
    }

    @Override // com.google.api.BackendRuleOrBuilder
    public PathTranslation getPathTranslation() {
        PathTranslation forNumber = PathTranslation.forNumber(this.pathTranslation_);
        if (forNumber == null) {
            return PathTranslation.UNRECOGNIZED;
        }
        return forNumber;
    }

    @Override // com.google.api.BackendRuleOrBuilder
    public int getPathTranslationValue() {
        return this.pathTranslation_;
    }

    @Override // com.google.api.BackendRuleOrBuilder
    public String getProtocol() {
        return this.protocol_;
    }

    @Override // com.google.api.BackendRuleOrBuilder
    public ByteString getProtocolBytes() {
        return ByteString.copyFromUtf8(this.protocol_);
    }

    @Override // com.google.api.BackendRuleOrBuilder
    public String getSelector() {
        return this.selector_;
    }

    @Override // com.google.api.BackendRuleOrBuilder
    public ByteString getSelectorBytes() {
        return ByteString.copyFromUtf8(this.selector_);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.f25388a[methodToInvoke.ordinal()]) {
            case 1:
                return new BackendRule();
            case 2:
                return new Builder(null);
            case 3:
                return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\t\u0001\u0000\u0001\t\t\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u0000\u0004\u0000\u0005\u0000\u0006\f\u0007Ȼ\u0000\b:\u0000\tȈ", new Object[]{"authentication_", "authenticationCase_", "selector_", "address_", "deadline_", "minDeadline_", "operationDeadline_", "pathTranslation_", "protocol_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<BackendRule> parser = PARSER;
                if (parser == null) {
                    synchronized (BackendRule.class) {
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

    public static Builder newBuilder(BackendRule backendRule) {
        return DEFAULT_INSTANCE.r(backendRule);
    }

    public static BackendRule parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (BackendRule) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static BackendRule parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (BackendRule) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static BackendRule parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (BackendRule) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
    }

    public static BackendRule parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (BackendRule) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static BackendRule parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (BackendRule) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
    }

    public static BackendRule parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (BackendRule) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static BackendRule parseFrom(InputStream inputStream) throws IOException {
        return (BackendRule) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
    }

    public static BackendRule parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (BackendRule) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static BackendRule parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (BackendRule) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
    }

    public static BackendRule parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (BackendRule) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
