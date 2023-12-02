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
public final class ContextRule extends GeneratedMessageLite<ContextRule, Builder> implements ContextRuleOrBuilder {
    public static final int ALLOWED_REQUEST_EXTENSIONS_FIELD_NUMBER = 4;
    public static final int ALLOWED_RESPONSE_EXTENSIONS_FIELD_NUMBER = 5;
    private static final ContextRule DEFAULT_INSTANCE;
    private static volatile Parser<ContextRule> PARSER = null;
    public static final int PROVIDED_FIELD_NUMBER = 3;
    public static final int REQUESTED_FIELD_NUMBER = 2;
    public static final int SELECTOR_FIELD_NUMBER = 1;
    private String selector_ = "";
    private Internal.ProtobufList<String> requested_ = GeneratedMessageLite.y();
    private Internal.ProtobufList<String> provided_ = GeneratedMessageLite.y();
    private Internal.ProtobufList<String> allowedRequestExtensions_ = GeneratedMessageLite.y();
    private Internal.ProtobufList<String> allowedResponseExtensions_ = GeneratedMessageLite.y();

    /* renamed from: com.google.api.ContextRule$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f25399a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f25399a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f25399a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f25399a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f25399a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f25399a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f25399a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f25399a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<ContextRule, Builder> implements ContextRuleOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllAllowedRequestExtensions(Iterable<String> iterable) {
            f();
            ((ContextRule) this.f33398b).D0(iterable);
            return this;
        }

        public Builder addAllAllowedResponseExtensions(Iterable<String> iterable) {
            f();
            ((ContextRule) this.f33398b).E0(iterable);
            return this;
        }

        public Builder addAllProvided(Iterable<String> iterable) {
            f();
            ((ContextRule) this.f33398b).F0(iterable);
            return this;
        }

        public Builder addAllRequested(Iterable<String> iterable) {
            f();
            ((ContextRule) this.f33398b).G0(iterable);
            return this;
        }

        public Builder addAllowedRequestExtensions(String str) {
            f();
            ((ContextRule) this.f33398b).H0(str);
            return this;
        }

        public Builder addAllowedRequestExtensionsBytes(ByteString byteString) {
            f();
            ((ContextRule) this.f33398b).I0(byteString);
            return this;
        }

        public Builder addAllowedResponseExtensions(String str) {
            f();
            ((ContextRule) this.f33398b).J0(str);
            return this;
        }

        public Builder addAllowedResponseExtensionsBytes(ByteString byteString) {
            f();
            ((ContextRule) this.f33398b).K0(byteString);
            return this;
        }

        public Builder addProvided(String str) {
            f();
            ((ContextRule) this.f33398b).L0(str);
            return this;
        }

        public Builder addProvidedBytes(ByteString byteString) {
            f();
            ((ContextRule) this.f33398b).M0(byteString);
            return this;
        }

        public Builder addRequested(String str) {
            f();
            ((ContextRule) this.f33398b).N0(str);
            return this;
        }

        public Builder addRequestedBytes(ByteString byteString) {
            f();
            ((ContextRule) this.f33398b).O0(byteString);
            return this;
        }

        public Builder clearAllowedRequestExtensions() {
            f();
            ((ContextRule) this.f33398b).P0();
            return this;
        }

        public Builder clearAllowedResponseExtensions() {
            f();
            ((ContextRule) this.f33398b).Q0();
            return this;
        }

        public Builder clearProvided() {
            f();
            ((ContextRule) this.f33398b).R0();
            return this;
        }

        public Builder clearRequested() {
            f();
            ((ContextRule) this.f33398b).S0();
            return this;
        }

        public Builder clearSelector() {
            f();
            ((ContextRule) this.f33398b).T0();
            return this;
        }

        @Override // com.google.api.ContextRuleOrBuilder
        public String getAllowedRequestExtensions(int i4) {
            return ((ContextRule) this.f33398b).getAllowedRequestExtensions(i4);
        }

        @Override // com.google.api.ContextRuleOrBuilder
        public ByteString getAllowedRequestExtensionsBytes(int i4) {
            return ((ContextRule) this.f33398b).getAllowedRequestExtensionsBytes(i4);
        }

        @Override // com.google.api.ContextRuleOrBuilder
        public int getAllowedRequestExtensionsCount() {
            return ((ContextRule) this.f33398b).getAllowedRequestExtensionsCount();
        }

        @Override // com.google.api.ContextRuleOrBuilder
        public List<String> getAllowedRequestExtensionsList() {
            return Collections.unmodifiableList(((ContextRule) this.f33398b).getAllowedRequestExtensionsList());
        }

        @Override // com.google.api.ContextRuleOrBuilder
        public String getAllowedResponseExtensions(int i4) {
            return ((ContextRule) this.f33398b).getAllowedResponseExtensions(i4);
        }

        @Override // com.google.api.ContextRuleOrBuilder
        public ByteString getAllowedResponseExtensionsBytes(int i4) {
            return ((ContextRule) this.f33398b).getAllowedResponseExtensionsBytes(i4);
        }

        @Override // com.google.api.ContextRuleOrBuilder
        public int getAllowedResponseExtensionsCount() {
            return ((ContextRule) this.f33398b).getAllowedResponseExtensionsCount();
        }

        @Override // com.google.api.ContextRuleOrBuilder
        public List<String> getAllowedResponseExtensionsList() {
            return Collections.unmodifiableList(((ContextRule) this.f33398b).getAllowedResponseExtensionsList());
        }

        @Override // com.google.api.ContextRuleOrBuilder
        public String getProvided(int i4) {
            return ((ContextRule) this.f33398b).getProvided(i4);
        }

        @Override // com.google.api.ContextRuleOrBuilder
        public ByteString getProvidedBytes(int i4) {
            return ((ContextRule) this.f33398b).getProvidedBytes(i4);
        }

        @Override // com.google.api.ContextRuleOrBuilder
        public int getProvidedCount() {
            return ((ContextRule) this.f33398b).getProvidedCount();
        }

        @Override // com.google.api.ContextRuleOrBuilder
        public List<String> getProvidedList() {
            return Collections.unmodifiableList(((ContextRule) this.f33398b).getProvidedList());
        }

        @Override // com.google.api.ContextRuleOrBuilder
        public String getRequested(int i4) {
            return ((ContextRule) this.f33398b).getRequested(i4);
        }

        @Override // com.google.api.ContextRuleOrBuilder
        public ByteString getRequestedBytes(int i4) {
            return ((ContextRule) this.f33398b).getRequestedBytes(i4);
        }

        @Override // com.google.api.ContextRuleOrBuilder
        public int getRequestedCount() {
            return ((ContextRule) this.f33398b).getRequestedCount();
        }

        @Override // com.google.api.ContextRuleOrBuilder
        public List<String> getRequestedList() {
            return Collections.unmodifiableList(((ContextRule) this.f33398b).getRequestedList());
        }

        @Override // com.google.api.ContextRuleOrBuilder
        public String getSelector() {
            return ((ContextRule) this.f33398b).getSelector();
        }

        @Override // com.google.api.ContextRuleOrBuilder
        public ByteString getSelectorBytes() {
            return ((ContextRule) this.f33398b).getSelectorBytes();
        }

        public Builder setAllowedRequestExtensions(int i4, String str) {
            f();
            ((ContextRule) this.f33398b).Y0(i4, str);
            return this;
        }

        public Builder setAllowedResponseExtensions(int i4, String str) {
            f();
            ((ContextRule) this.f33398b).Z0(i4, str);
            return this;
        }

        public Builder setProvided(int i4, String str) {
            f();
            ((ContextRule) this.f33398b).a1(i4, str);
            return this;
        }

        public Builder setRequested(int i4, String str) {
            f();
            ((ContextRule) this.f33398b).b1(i4, str);
            return this;
        }

        public Builder setSelector(String str) {
            f();
            ((ContextRule) this.f33398b).c1(str);
            return this;
        }

        public Builder setSelectorBytes(ByteString byteString) {
            f();
            ((ContextRule) this.f33398b).d1(byteString);
            return this;
        }

        private Builder() {
            super(ContextRule.DEFAULT_INSTANCE);
        }
    }

    static {
        ContextRule contextRule = new ContextRule();
        DEFAULT_INSTANCE = contextRule;
        GeneratedMessageLite.d0(ContextRule.class, contextRule);
    }

    private ContextRule() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D0(Iterable<String> iterable) {
        U0();
        AbstractMessageLite.a(iterable, this.allowedRequestExtensions_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E0(Iterable<String> iterable) {
        V0();
        AbstractMessageLite.a(iterable, this.allowedResponseExtensions_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F0(Iterable<String> iterable) {
        W0();
        AbstractMessageLite.a(iterable, this.provided_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G0(Iterable<String> iterable) {
        X0();
        AbstractMessageLite.a(iterable, this.requested_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H0(String str) {
        str.getClass();
        U0();
        this.allowedRequestExtensions_.add(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I0(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        U0();
        this.allowedRequestExtensions_.add(byteString.toStringUtf8());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J0(String str) {
        str.getClass();
        V0();
        this.allowedResponseExtensions_.add(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K0(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        V0();
        this.allowedResponseExtensions_.add(byteString.toStringUtf8());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L0(String str) {
        str.getClass();
        W0();
        this.provided_.add(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M0(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        W0();
        this.provided_.add(byteString.toStringUtf8());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N0(String str) {
        str.getClass();
        X0();
        this.requested_.add(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O0(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        X0();
        this.requested_.add(byteString.toStringUtf8());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P0() {
        this.allowedRequestExtensions_ = GeneratedMessageLite.y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q0() {
        this.allowedResponseExtensions_ = GeneratedMessageLite.y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R0() {
        this.provided_ = GeneratedMessageLite.y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S0() {
        this.requested_ = GeneratedMessageLite.y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T0() {
        this.selector_ = getDefaultInstance().getSelector();
    }

    private void U0() {
        Internal.ProtobufList<String> protobufList = this.allowedRequestExtensions_;
        if (!protobufList.isModifiable()) {
            this.allowedRequestExtensions_ = GeneratedMessageLite.K(protobufList);
        }
    }

    private void V0() {
        Internal.ProtobufList<String> protobufList = this.allowedResponseExtensions_;
        if (!protobufList.isModifiable()) {
            this.allowedResponseExtensions_ = GeneratedMessageLite.K(protobufList);
        }
    }

    private void W0() {
        Internal.ProtobufList<String> protobufList = this.provided_;
        if (!protobufList.isModifiable()) {
            this.provided_ = GeneratedMessageLite.K(protobufList);
        }
    }

    private void X0() {
        Internal.ProtobufList<String> protobufList = this.requested_;
        if (!protobufList.isModifiable()) {
            this.requested_ = GeneratedMessageLite.K(protobufList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y0(int i4, String str) {
        str.getClass();
        U0();
        this.allowedRequestExtensions_.set(i4, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z0(int i4, String str) {
        str.getClass();
        V0();
        this.allowedResponseExtensions_.set(i4, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a1(int i4, String str) {
        str.getClass();
        W0();
        this.provided_.set(i4, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b1(int i4, String str) {
        str.getClass();
        X0();
        this.requested_.set(i4, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c1(String str) {
        str.getClass();
        this.selector_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d1(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        this.selector_ = byteString.toStringUtf8();
    }

    public static ContextRule getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.q();
    }

    public static ContextRule parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (ContextRule) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
    }

    public static ContextRule parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (ContextRule) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<ContextRule> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    @Override // com.google.api.ContextRuleOrBuilder
    public String getAllowedRequestExtensions(int i4) {
        return this.allowedRequestExtensions_.get(i4);
    }

    @Override // com.google.api.ContextRuleOrBuilder
    public ByteString getAllowedRequestExtensionsBytes(int i4) {
        return ByteString.copyFromUtf8(this.allowedRequestExtensions_.get(i4));
    }

    @Override // com.google.api.ContextRuleOrBuilder
    public int getAllowedRequestExtensionsCount() {
        return this.allowedRequestExtensions_.size();
    }

    @Override // com.google.api.ContextRuleOrBuilder
    public List<String> getAllowedRequestExtensionsList() {
        return this.allowedRequestExtensions_;
    }

    @Override // com.google.api.ContextRuleOrBuilder
    public String getAllowedResponseExtensions(int i4) {
        return this.allowedResponseExtensions_.get(i4);
    }

    @Override // com.google.api.ContextRuleOrBuilder
    public ByteString getAllowedResponseExtensionsBytes(int i4) {
        return ByteString.copyFromUtf8(this.allowedResponseExtensions_.get(i4));
    }

    @Override // com.google.api.ContextRuleOrBuilder
    public int getAllowedResponseExtensionsCount() {
        return this.allowedResponseExtensions_.size();
    }

    @Override // com.google.api.ContextRuleOrBuilder
    public List<String> getAllowedResponseExtensionsList() {
        return this.allowedResponseExtensions_;
    }

    @Override // com.google.api.ContextRuleOrBuilder
    public String getProvided(int i4) {
        return this.provided_.get(i4);
    }

    @Override // com.google.api.ContextRuleOrBuilder
    public ByteString getProvidedBytes(int i4) {
        return ByteString.copyFromUtf8(this.provided_.get(i4));
    }

    @Override // com.google.api.ContextRuleOrBuilder
    public int getProvidedCount() {
        return this.provided_.size();
    }

    @Override // com.google.api.ContextRuleOrBuilder
    public List<String> getProvidedList() {
        return this.provided_;
    }

    @Override // com.google.api.ContextRuleOrBuilder
    public String getRequested(int i4) {
        return this.requested_.get(i4);
    }

    @Override // com.google.api.ContextRuleOrBuilder
    public ByteString getRequestedBytes(int i4) {
        return ByteString.copyFromUtf8(this.requested_.get(i4));
    }

    @Override // com.google.api.ContextRuleOrBuilder
    public int getRequestedCount() {
        return this.requested_.size();
    }

    @Override // com.google.api.ContextRuleOrBuilder
    public List<String> getRequestedList() {
        return this.requested_;
    }

    @Override // com.google.api.ContextRuleOrBuilder
    public String getSelector() {
        return this.selector_;
    }

    @Override // com.google.api.ContextRuleOrBuilder
    public ByteString getSelectorBytes() {
        return ByteString.copyFromUtf8(this.selector_);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.f25399a[methodToInvoke.ordinal()]) {
            case 1:
                return new ContextRule();
            case 2:
                return new Builder(null);
            case 3:
                return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0004\u0000\u0001Ȉ\u0002Ț\u0003Ț\u0004Ț\u0005Ț", new Object[]{"selector_", "requested_", "provided_", "allowedRequestExtensions_", "allowedResponseExtensions_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<ContextRule> parser = PARSER;
                if (parser == null) {
                    synchronized (ContextRule.class) {
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

    public static Builder newBuilder(ContextRule contextRule) {
        return DEFAULT_INSTANCE.r(contextRule);
    }

    public static ContextRule parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ContextRule) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ContextRule parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ContextRule) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static ContextRule parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (ContextRule) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
    }

    public static ContextRule parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ContextRule) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static ContextRule parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (ContextRule) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
    }

    public static ContextRule parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ContextRule) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static ContextRule parseFrom(InputStream inputStream) throws IOException {
        return (ContextRule) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
    }

    public static ContextRule parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ContextRule) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ContextRule parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (ContextRule) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
    }

    public static ContextRule parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ContextRule) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
