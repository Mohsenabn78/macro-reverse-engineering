package com.google.api;

import com.google.api.AuthProvider;
import com.google.api.AuthenticationRule;
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
public final class Authentication extends GeneratedMessageLite<Authentication, Builder> implements AuthenticationOrBuilder {
    private static final Authentication DEFAULT_INSTANCE;
    private static volatile Parser<Authentication> PARSER = null;
    public static final int PROVIDERS_FIELD_NUMBER = 4;
    public static final int RULES_FIELD_NUMBER = 3;
    private Internal.ProtobufList<AuthenticationRule> rules_ = GeneratedMessageLite.y();
    private Internal.ProtobufList<AuthProvider> providers_ = GeneratedMessageLite.y();

    /* renamed from: com.google.api.Authentication$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f25385a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f25385a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f25385a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f25385a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f25385a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f25385a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f25385a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f25385a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<Authentication, Builder> implements AuthenticationOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllProviders(Iterable<? extends AuthProvider> iterable) {
            f();
            ((Authentication) this.f33398b).s0(iterable);
            return this;
        }

        public Builder addAllRules(Iterable<? extends AuthenticationRule> iterable) {
            f();
            ((Authentication) this.f33398b).t0(iterable);
            return this;
        }

        public Builder addProviders(AuthProvider authProvider) {
            f();
            ((Authentication) this.f33398b).v0(authProvider);
            return this;
        }

        public Builder addRules(AuthenticationRule authenticationRule) {
            f();
            ((Authentication) this.f33398b).x0(authenticationRule);
            return this;
        }

        public Builder clearProviders() {
            f();
            ((Authentication) this.f33398b).y0();
            return this;
        }

        public Builder clearRules() {
            f();
            ((Authentication) this.f33398b).z0();
            return this;
        }

        @Override // com.google.api.AuthenticationOrBuilder
        public AuthProvider getProviders(int i4) {
            return ((Authentication) this.f33398b).getProviders(i4);
        }

        @Override // com.google.api.AuthenticationOrBuilder
        public int getProvidersCount() {
            return ((Authentication) this.f33398b).getProvidersCount();
        }

        @Override // com.google.api.AuthenticationOrBuilder
        public List<AuthProvider> getProvidersList() {
            return Collections.unmodifiableList(((Authentication) this.f33398b).getProvidersList());
        }

        @Override // com.google.api.AuthenticationOrBuilder
        public AuthenticationRule getRules(int i4) {
            return ((Authentication) this.f33398b).getRules(i4);
        }

        @Override // com.google.api.AuthenticationOrBuilder
        public int getRulesCount() {
            return ((Authentication) this.f33398b).getRulesCount();
        }

        @Override // com.google.api.AuthenticationOrBuilder
        public List<AuthenticationRule> getRulesList() {
            return Collections.unmodifiableList(((Authentication) this.f33398b).getRulesList());
        }

        public Builder removeProviders(int i4) {
            f();
            ((Authentication) this.f33398b).C0(i4);
            return this;
        }

        public Builder removeRules(int i4) {
            f();
            ((Authentication) this.f33398b).D0(i4);
            return this;
        }

        public Builder setProviders(int i4, AuthProvider authProvider) {
            f();
            ((Authentication) this.f33398b).E0(i4, authProvider);
            return this;
        }

        public Builder setRules(int i4, AuthenticationRule authenticationRule) {
            f();
            ((Authentication) this.f33398b).F0(i4, authenticationRule);
            return this;
        }

        private Builder() {
            super(Authentication.DEFAULT_INSTANCE);
        }

        public Builder addProviders(int i4, AuthProvider authProvider) {
            f();
            ((Authentication) this.f33398b).u0(i4, authProvider);
            return this;
        }

        public Builder addRules(int i4, AuthenticationRule authenticationRule) {
            f();
            ((Authentication) this.f33398b).w0(i4, authenticationRule);
            return this;
        }

        public Builder setProviders(int i4, AuthProvider.Builder builder) {
            f();
            ((Authentication) this.f33398b).E0(i4, builder.build());
            return this;
        }

        public Builder setRules(int i4, AuthenticationRule.Builder builder) {
            f();
            ((Authentication) this.f33398b).F0(i4, builder.build());
            return this;
        }

        public Builder addProviders(AuthProvider.Builder builder) {
            f();
            ((Authentication) this.f33398b).v0(builder.build());
            return this;
        }

        public Builder addRules(AuthenticationRule.Builder builder) {
            f();
            ((Authentication) this.f33398b).x0(builder.build());
            return this;
        }

        public Builder addProviders(int i4, AuthProvider.Builder builder) {
            f();
            ((Authentication) this.f33398b).u0(i4, builder.build());
            return this;
        }

        public Builder addRules(int i4, AuthenticationRule.Builder builder) {
            f();
            ((Authentication) this.f33398b).w0(i4, builder.build());
            return this;
        }
    }

    static {
        Authentication authentication = new Authentication();
        DEFAULT_INSTANCE = authentication;
        GeneratedMessageLite.d0(Authentication.class, authentication);
    }

    private Authentication() {
    }

    private void A0() {
        Internal.ProtobufList<AuthProvider> protobufList = this.providers_;
        if (!protobufList.isModifiable()) {
            this.providers_ = GeneratedMessageLite.K(protobufList);
        }
    }

    private void B0() {
        Internal.ProtobufList<AuthenticationRule> protobufList = this.rules_;
        if (!protobufList.isModifiable()) {
            this.rules_ = GeneratedMessageLite.K(protobufList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C0(int i4) {
        A0();
        this.providers_.remove(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D0(int i4) {
        B0();
        this.rules_.remove(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E0(int i4, AuthProvider authProvider) {
        authProvider.getClass();
        A0();
        this.providers_.set(i4, authProvider);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F0(int i4, AuthenticationRule authenticationRule) {
        authenticationRule.getClass();
        B0();
        this.rules_.set(i4, authenticationRule);
    }

    public static Authentication getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.q();
    }

    public static Authentication parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Authentication) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
    }

    public static Authentication parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (Authentication) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Authentication> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0(Iterable<? extends AuthProvider> iterable) {
        A0();
        AbstractMessageLite.a(iterable, this.providers_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t0(Iterable<? extends AuthenticationRule> iterable) {
        B0();
        AbstractMessageLite.a(iterable, this.rules_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u0(int i4, AuthProvider authProvider) {
        authProvider.getClass();
        A0();
        this.providers_.add(i4, authProvider);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v0(AuthProvider authProvider) {
        authProvider.getClass();
        A0();
        this.providers_.add(authProvider);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w0(int i4, AuthenticationRule authenticationRule) {
        authenticationRule.getClass();
        B0();
        this.rules_.add(i4, authenticationRule);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0(AuthenticationRule authenticationRule) {
        authenticationRule.getClass();
        B0();
        this.rules_.add(authenticationRule);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0() {
        this.providers_ = GeneratedMessageLite.y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0() {
        this.rules_ = GeneratedMessageLite.y();
    }

    @Override // com.google.api.AuthenticationOrBuilder
    public AuthProvider getProviders(int i4) {
        return this.providers_.get(i4);
    }

    @Override // com.google.api.AuthenticationOrBuilder
    public int getProvidersCount() {
        return this.providers_.size();
    }

    @Override // com.google.api.AuthenticationOrBuilder
    public List<AuthProvider> getProvidersList() {
        return this.providers_;
    }

    public AuthProviderOrBuilder getProvidersOrBuilder(int i4) {
        return this.providers_.get(i4);
    }

    public List<? extends AuthProviderOrBuilder> getProvidersOrBuilderList() {
        return this.providers_;
    }

    @Override // com.google.api.AuthenticationOrBuilder
    public AuthenticationRule getRules(int i4) {
        return this.rules_.get(i4);
    }

    @Override // com.google.api.AuthenticationOrBuilder
    public int getRulesCount() {
        return this.rules_.size();
    }

    @Override // com.google.api.AuthenticationOrBuilder
    public List<AuthenticationRule> getRulesList() {
        return this.rules_;
    }

    public AuthenticationRuleOrBuilder getRulesOrBuilder(int i4) {
        return this.rules_.get(i4);
    }

    public List<? extends AuthenticationRuleOrBuilder> getRulesOrBuilderList() {
        return this.rules_;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.f25385a[methodToInvoke.ordinal()]) {
            case 1:
                return new Authentication();
            case 2:
                return new Builder(null);
            case 3:
                return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0003\u0004\u0002\u0000\u0002\u0000\u0003\u001b\u0004\u001b", new Object[]{"rules_", AuthenticationRule.class, "providers_", AuthProvider.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Authentication> parser = PARSER;
                if (parser == null) {
                    synchronized (Authentication.class) {
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

    public static Builder newBuilder(Authentication authentication) {
        return DEFAULT_INSTANCE.r(authentication);
    }

    public static Authentication parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Authentication) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Authentication parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Authentication) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Authentication parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (Authentication) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
    }

    public static Authentication parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Authentication) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Authentication parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (Authentication) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
    }

    public static Authentication parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Authentication) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Authentication parseFrom(InputStream inputStream) throws IOException {
        return (Authentication) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
    }

    public static Authentication parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Authentication) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Authentication parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Authentication) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Authentication parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Authentication) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
