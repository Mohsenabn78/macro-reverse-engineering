package com.google.api;

import com.google.api.DocumentationRule;
import com.google.api.Page;
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
public final class Documentation extends GeneratedMessageLite<Documentation, Builder> implements DocumentationOrBuilder {
    private static final Documentation DEFAULT_INSTANCE;
    public static final int DOCUMENTATION_ROOT_URL_FIELD_NUMBER = 4;
    public static final int OVERVIEW_FIELD_NUMBER = 2;
    public static final int PAGES_FIELD_NUMBER = 5;
    private static volatile Parser<Documentation> PARSER = null;
    public static final int RULES_FIELD_NUMBER = 3;
    public static final int SUMMARY_FIELD_NUMBER = 1;
    private String summary_ = "";
    private Internal.ProtobufList<Page> pages_ = GeneratedMessageLite.y();
    private Internal.ProtobufList<DocumentationRule> rules_ = GeneratedMessageLite.y();
    private String documentationRootUrl_ = "";
    private String overview_ = "";

    /* renamed from: com.google.api.Documentation$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f25404a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f25404a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f25404a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f25404a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f25404a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f25404a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f25404a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f25404a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<Documentation, Builder> implements DocumentationOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllPages(Iterable<? extends Page> iterable) {
            f();
            ((Documentation) this.f33398b).B0(iterable);
            return this;
        }

        public Builder addAllRules(Iterable<? extends DocumentationRule> iterable) {
            f();
            ((Documentation) this.f33398b).C0(iterable);
            return this;
        }

        public Builder addPages(Page page) {
            f();
            ((Documentation) this.f33398b).E0(page);
            return this;
        }

        public Builder addRules(DocumentationRule documentationRule) {
            f();
            ((Documentation) this.f33398b).G0(documentationRule);
            return this;
        }

        public Builder clearDocumentationRootUrl() {
            f();
            ((Documentation) this.f33398b).H0();
            return this;
        }

        public Builder clearOverview() {
            f();
            ((Documentation) this.f33398b).I0();
            return this;
        }

        public Builder clearPages() {
            f();
            ((Documentation) this.f33398b).J0();
            return this;
        }

        public Builder clearRules() {
            f();
            ((Documentation) this.f33398b).K0();
            return this;
        }

        public Builder clearSummary() {
            f();
            ((Documentation) this.f33398b).L0();
            return this;
        }

        @Override // com.google.api.DocumentationOrBuilder
        public String getDocumentationRootUrl() {
            return ((Documentation) this.f33398b).getDocumentationRootUrl();
        }

        @Override // com.google.api.DocumentationOrBuilder
        public ByteString getDocumentationRootUrlBytes() {
            return ((Documentation) this.f33398b).getDocumentationRootUrlBytes();
        }

        @Override // com.google.api.DocumentationOrBuilder
        public String getOverview() {
            return ((Documentation) this.f33398b).getOverview();
        }

        @Override // com.google.api.DocumentationOrBuilder
        public ByteString getOverviewBytes() {
            return ((Documentation) this.f33398b).getOverviewBytes();
        }

        @Override // com.google.api.DocumentationOrBuilder
        public Page getPages(int i4) {
            return ((Documentation) this.f33398b).getPages(i4);
        }

        @Override // com.google.api.DocumentationOrBuilder
        public int getPagesCount() {
            return ((Documentation) this.f33398b).getPagesCount();
        }

        @Override // com.google.api.DocumentationOrBuilder
        public List<Page> getPagesList() {
            return Collections.unmodifiableList(((Documentation) this.f33398b).getPagesList());
        }

        @Override // com.google.api.DocumentationOrBuilder
        public DocumentationRule getRules(int i4) {
            return ((Documentation) this.f33398b).getRules(i4);
        }

        @Override // com.google.api.DocumentationOrBuilder
        public int getRulesCount() {
            return ((Documentation) this.f33398b).getRulesCount();
        }

        @Override // com.google.api.DocumentationOrBuilder
        public List<DocumentationRule> getRulesList() {
            return Collections.unmodifiableList(((Documentation) this.f33398b).getRulesList());
        }

        @Override // com.google.api.DocumentationOrBuilder
        public String getSummary() {
            return ((Documentation) this.f33398b).getSummary();
        }

        @Override // com.google.api.DocumentationOrBuilder
        public ByteString getSummaryBytes() {
            return ((Documentation) this.f33398b).getSummaryBytes();
        }

        public Builder removePages(int i4) {
            f();
            ((Documentation) this.f33398b).O0(i4);
            return this;
        }

        public Builder removeRules(int i4) {
            f();
            ((Documentation) this.f33398b).P0(i4);
            return this;
        }

        public Builder setDocumentationRootUrl(String str) {
            f();
            ((Documentation) this.f33398b).Q0(str);
            return this;
        }

        public Builder setDocumentationRootUrlBytes(ByteString byteString) {
            f();
            ((Documentation) this.f33398b).R0(byteString);
            return this;
        }

        public Builder setOverview(String str) {
            f();
            ((Documentation) this.f33398b).S0(str);
            return this;
        }

        public Builder setOverviewBytes(ByteString byteString) {
            f();
            ((Documentation) this.f33398b).T0(byteString);
            return this;
        }

        public Builder setPages(int i4, Page page) {
            f();
            ((Documentation) this.f33398b).U0(i4, page);
            return this;
        }

        public Builder setRules(int i4, DocumentationRule documentationRule) {
            f();
            ((Documentation) this.f33398b).V0(i4, documentationRule);
            return this;
        }

        public Builder setSummary(String str) {
            f();
            ((Documentation) this.f33398b).W0(str);
            return this;
        }

        public Builder setSummaryBytes(ByteString byteString) {
            f();
            ((Documentation) this.f33398b).X0(byteString);
            return this;
        }

        private Builder() {
            super(Documentation.DEFAULT_INSTANCE);
        }

        public Builder addPages(int i4, Page page) {
            f();
            ((Documentation) this.f33398b).D0(i4, page);
            return this;
        }

        public Builder addRules(int i4, DocumentationRule documentationRule) {
            f();
            ((Documentation) this.f33398b).F0(i4, documentationRule);
            return this;
        }

        public Builder setPages(int i4, Page.Builder builder) {
            f();
            ((Documentation) this.f33398b).U0(i4, builder.build());
            return this;
        }

        public Builder setRules(int i4, DocumentationRule.Builder builder) {
            f();
            ((Documentation) this.f33398b).V0(i4, builder.build());
            return this;
        }

        public Builder addPages(Page.Builder builder) {
            f();
            ((Documentation) this.f33398b).E0(builder.build());
            return this;
        }

        public Builder addRules(DocumentationRule.Builder builder) {
            f();
            ((Documentation) this.f33398b).G0(builder.build());
            return this;
        }

        public Builder addPages(int i4, Page.Builder builder) {
            f();
            ((Documentation) this.f33398b).D0(i4, builder.build());
            return this;
        }

        public Builder addRules(int i4, DocumentationRule.Builder builder) {
            f();
            ((Documentation) this.f33398b).F0(i4, builder.build());
            return this;
        }
    }

    static {
        Documentation documentation = new Documentation();
        DEFAULT_INSTANCE = documentation;
        GeneratedMessageLite.d0(Documentation.class, documentation);
    }

    private Documentation() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B0(Iterable<? extends Page> iterable) {
        M0();
        AbstractMessageLite.a(iterable, this.pages_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C0(Iterable<? extends DocumentationRule> iterable) {
        N0();
        AbstractMessageLite.a(iterable, this.rules_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D0(int i4, Page page) {
        page.getClass();
        M0();
        this.pages_.add(i4, page);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E0(Page page) {
        page.getClass();
        M0();
        this.pages_.add(page);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F0(int i4, DocumentationRule documentationRule) {
        documentationRule.getClass();
        N0();
        this.rules_.add(i4, documentationRule);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G0(DocumentationRule documentationRule) {
        documentationRule.getClass();
        N0();
        this.rules_.add(documentationRule);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H0() {
        this.documentationRootUrl_ = getDefaultInstance().getDocumentationRootUrl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I0() {
        this.overview_ = getDefaultInstance().getOverview();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J0() {
        this.pages_ = GeneratedMessageLite.y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K0() {
        this.rules_ = GeneratedMessageLite.y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L0() {
        this.summary_ = getDefaultInstance().getSummary();
    }

    private void M0() {
        Internal.ProtobufList<Page> protobufList = this.pages_;
        if (!protobufList.isModifiable()) {
            this.pages_ = GeneratedMessageLite.K(protobufList);
        }
    }

    private void N0() {
        Internal.ProtobufList<DocumentationRule> protobufList = this.rules_;
        if (!protobufList.isModifiable()) {
            this.rules_ = GeneratedMessageLite.K(protobufList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O0(int i4) {
        M0();
        this.pages_.remove(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P0(int i4) {
        N0();
        this.rules_.remove(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q0(String str) {
        str.getClass();
        this.documentationRootUrl_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R0(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        this.documentationRootUrl_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S0(String str) {
        str.getClass();
        this.overview_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T0(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        this.overview_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U0(int i4, Page page) {
        page.getClass();
        M0();
        this.pages_.set(i4, page);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V0(int i4, DocumentationRule documentationRule) {
        documentationRule.getClass();
        N0();
        this.rules_.set(i4, documentationRule);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W0(String str) {
        str.getClass();
        this.summary_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X0(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        this.summary_ = byteString.toStringUtf8();
    }

    public static Documentation getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.q();
    }

    public static Documentation parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Documentation) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
    }

    public static Documentation parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (Documentation) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Documentation> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    @Override // com.google.api.DocumentationOrBuilder
    public String getDocumentationRootUrl() {
        return this.documentationRootUrl_;
    }

    @Override // com.google.api.DocumentationOrBuilder
    public ByteString getDocumentationRootUrlBytes() {
        return ByteString.copyFromUtf8(this.documentationRootUrl_);
    }

    @Override // com.google.api.DocumentationOrBuilder
    public String getOverview() {
        return this.overview_;
    }

    @Override // com.google.api.DocumentationOrBuilder
    public ByteString getOverviewBytes() {
        return ByteString.copyFromUtf8(this.overview_);
    }

    @Override // com.google.api.DocumentationOrBuilder
    public Page getPages(int i4) {
        return this.pages_.get(i4);
    }

    @Override // com.google.api.DocumentationOrBuilder
    public int getPagesCount() {
        return this.pages_.size();
    }

    @Override // com.google.api.DocumentationOrBuilder
    public List<Page> getPagesList() {
        return this.pages_;
    }

    public PageOrBuilder getPagesOrBuilder(int i4) {
        return this.pages_.get(i4);
    }

    public List<? extends PageOrBuilder> getPagesOrBuilderList() {
        return this.pages_;
    }

    @Override // com.google.api.DocumentationOrBuilder
    public DocumentationRule getRules(int i4) {
        return this.rules_.get(i4);
    }

    @Override // com.google.api.DocumentationOrBuilder
    public int getRulesCount() {
        return this.rules_.size();
    }

    @Override // com.google.api.DocumentationOrBuilder
    public List<DocumentationRule> getRulesList() {
        return this.rules_;
    }

    public DocumentationRuleOrBuilder getRulesOrBuilder(int i4) {
        return this.rules_.get(i4);
    }

    public List<? extends DocumentationRuleOrBuilder> getRulesOrBuilderList() {
        return this.rules_;
    }

    @Override // com.google.api.DocumentationOrBuilder
    public String getSummary() {
        return this.summary_;
    }

    @Override // com.google.api.DocumentationOrBuilder
    public ByteString getSummaryBytes() {
        return ByteString.copyFromUtf8(this.summary_);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.f25404a[methodToInvoke.ordinal()]) {
            case 1:
                return new Documentation();
            case 2:
                return new Builder(null);
            case 3:
                return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0002\u0000\u0001Ȉ\u0002Ȉ\u0003\u001b\u0004Ȉ\u0005\u001b", new Object[]{"summary_", "overview_", "rules_", DocumentationRule.class, "documentationRootUrl_", "pages_", Page.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Documentation> parser = PARSER;
                if (parser == null) {
                    synchronized (Documentation.class) {
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

    public static Builder newBuilder(Documentation documentation) {
        return DEFAULT_INSTANCE.r(documentation);
    }

    public static Documentation parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Documentation) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Documentation parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Documentation) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Documentation parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (Documentation) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
    }

    public static Documentation parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Documentation) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Documentation parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (Documentation) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
    }

    public static Documentation parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Documentation) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Documentation parseFrom(InputStream inputStream) throws IOException {
        return (Documentation) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
    }

    public static Documentation parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Documentation) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Documentation parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Documentation) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Documentation parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Documentation) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
