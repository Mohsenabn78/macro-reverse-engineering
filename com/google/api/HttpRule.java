package com.google.api;

import com.google.api.CustomHttpPattern;
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
public final class HttpRule extends GeneratedMessageLite<HttpRule, Builder> implements HttpRuleOrBuilder {
    public static final int ADDITIONAL_BINDINGS_FIELD_NUMBER = 11;
    public static final int BODY_FIELD_NUMBER = 7;
    public static final int CUSTOM_FIELD_NUMBER = 8;
    private static final HttpRule DEFAULT_INSTANCE;
    public static final int DELETE_FIELD_NUMBER = 5;
    public static final int GET_FIELD_NUMBER = 2;
    private static volatile Parser<HttpRule> PARSER = null;
    public static final int PATCH_FIELD_NUMBER = 6;
    public static final int POST_FIELD_NUMBER = 4;
    public static final int PUT_FIELD_NUMBER = 3;
    public static final int RESPONSE_BODY_FIELD_NUMBER = 12;
    public static final int SELECTOR_FIELD_NUMBER = 1;
    private Object pattern_;
    private int patternCase_ = 0;
    private String selector_ = "";
    private String body_ = "";
    private String responseBody_ = "";
    private Internal.ProtobufList<HttpRule> additionalBindings_ = GeneratedMessageLite.y();

    /* renamed from: com.google.api.HttpRule$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f25412a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f25412a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f25412a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f25412a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f25412a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f25412a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f25412a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f25412a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<HttpRule, Builder> implements HttpRuleOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAdditionalBindings(HttpRule httpRule) {
            f();
            ((HttpRule) this.f33398b).P0(httpRule);
            return this;
        }

        public Builder addAllAdditionalBindings(Iterable<? extends HttpRule> iterable) {
            f();
            ((HttpRule) this.f33398b).Q0(iterable);
            return this;
        }

        public Builder clearAdditionalBindings() {
            f();
            ((HttpRule) this.f33398b).R0();
            return this;
        }

        public Builder clearBody() {
            f();
            ((HttpRule) this.f33398b).S0();
            return this;
        }

        public Builder clearCustom() {
            f();
            ((HttpRule) this.f33398b).T0();
            return this;
        }

        public Builder clearDelete() {
            f();
            ((HttpRule) this.f33398b).U0();
            return this;
        }

        public Builder clearGet() {
            f();
            ((HttpRule) this.f33398b).V0();
            return this;
        }

        public Builder clearPatch() {
            f();
            ((HttpRule) this.f33398b).W0();
            return this;
        }

        public Builder clearPattern() {
            f();
            ((HttpRule) this.f33398b).X0();
            return this;
        }

        public Builder clearPost() {
            f();
            ((HttpRule) this.f33398b).Y0();
            return this;
        }

        public Builder clearPut() {
            f();
            ((HttpRule) this.f33398b).Z0();
            return this;
        }

        public Builder clearResponseBody() {
            f();
            ((HttpRule) this.f33398b).a1();
            return this;
        }

        public Builder clearSelector() {
            f();
            ((HttpRule) this.f33398b).b1();
            return this;
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public HttpRule getAdditionalBindings(int i4) {
            return ((HttpRule) this.f33398b).getAdditionalBindings(i4);
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public int getAdditionalBindingsCount() {
            return ((HttpRule) this.f33398b).getAdditionalBindingsCount();
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public List<HttpRule> getAdditionalBindingsList() {
            return Collections.unmodifiableList(((HttpRule) this.f33398b).getAdditionalBindingsList());
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public String getBody() {
            return ((HttpRule) this.f33398b).getBody();
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public ByteString getBodyBytes() {
            return ((HttpRule) this.f33398b).getBodyBytes();
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public CustomHttpPattern getCustom() {
            return ((HttpRule) this.f33398b).getCustom();
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public String getDelete() {
            return ((HttpRule) this.f33398b).getDelete();
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public ByteString getDeleteBytes() {
            return ((HttpRule) this.f33398b).getDeleteBytes();
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public String getGet() {
            return ((HttpRule) this.f33398b).getGet();
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public ByteString getGetBytes() {
            return ((HttpRule) this.f33398b).getGetBytes();
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public String getPatch() {
            return ((HttpRule) this.f33398b).getPatch();
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public ByteString getPatchBytes() {
            return ((HttpRule) this.f33398b).getPatchBytes();
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public PatternCase getPatternCase() {
            return ((HttpRule) this.f33398b).getPatternCase();
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public String getPost() {
            return ((HttpRule) this.f33398b).getPost();
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public ByteString getPostBytes() {
            return ((HttpRule) this.f33398b).getPostBytes();
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public String getPut() {
            return ((HttpRule) this.f33398b).getPut();
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public ByteString getPutBytes() {
            return ((HttpRule) this.f33398b).getPutBytes();
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public String getResponseBody() {
            return ((HttpRule) this.f33398b).getResponseBody();
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public ByteString getResponseBodyBytes() {
            return ((HttpRule) this.f33398b).getResponseBodyBytes();
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public String getSelector() {
            return ((HttpRule) this.f33398b).getSelector();
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public ByteString getSelectorBytes() {
            return ((HttpRule) this.f33398b).getSelectorBytes();
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public boolean hasCustom() {
            return ((HttpRule) this.f33398b).hasCustom();
        }

        public Builder mergeCustom(CustomHttpPattern customHttpPattern) {
            f();
            ((HttpRule) this.f33398b).d1(customHttpPattern);
            return this;
        }

        public Builder removeAdditionalBindings(int i4) {
            f();
            ((HttpRule) this.f33398b).e1(i4);
            return this;
        }

        public Builder setAdditionalBindings(int i4, HttpRule httpRule) {
            f();
            ((HttpRule) this.f33398b).f1(i4, httpRule);
            return this;
        }

        public Builder setBody(String str) {
            f();
            ((HttpRule) this.f33398b).g1(str);
            return this;
        }

        public Builder setBodyBytes(ByteString byteString) {
            f();
            ((HttpRule) this.f33398b).h1(byteString);
            return this;
        }

        public Builder setCustom(CustomHttpPattern customHttpPattern) {
            f();
            ((HttpRule) this.f33398b).i1(customHttpPattern);
            return this;
        }

        public Builder setDelete(String str) {
            f();
            ((HttpRule) this.f33398b).j1(str);
            return this;
        }

        public Builder setDeleteBytes(ByteString byteString) {
            f();
            ((HttpRule) this.f33398b).k1(byteString);
            return this;
        }

        public Builder setGet(String str) {
            f();
            ((HttpRule) this.f33398b).l1(str);
            return this;
        }

        public Builder setGetBytes(ByteString byteString) {
            f();
            ((HttpRule) this.f33398b).m1(byteString);
            return this;
        }

        public Builder setPatch(String str) {
            f();
            ((HttpRule) this.f33398b).n1(str);
            return this;
        }

        public Builder setPatchBytes(ByteString byteString) {
            f();
            ((HttpRule) this.f33398b).o1(byteString);
            return this;
        }

        public Builder setPost(String str) {
            f();
            ((HttpRule) this.f33398b).p1(str);
            return this;
        }

        public Builder setPostBytes(ByteString byteString) {
            f();
            ((HttpRule) this.f33398b).q1(byteString);
            return this;
        }

        public Builder setPut(String str) {
            f();
            ((HttpRule) this.f33398b).r1(str);
            return this;
        }

        public Builder setPutBytes(ByteString byteString) {
            f();
            ((HttpRule) this.f33398b).s1(byteString);
            return this;
        }

        public Builder setResponseBody(String str) {
            f();
            ((HttpRule) this.f33398b).t1(str);
            return this;
        }

        public Builder setResponseBodyBytes(ByteString byteString) {
            f();
            ((HttpRule) this.f33398b).u1(byteString);
            return this;
        }

        public Builder setSelector(String str) {
            f();
            ((HttpRule) this.f33398b).v1(str);
            return this;
        }

        public Builder setSelectorBytes(ByteString byteString) {
            f();
            ((HttpRule) this.f33398b).w1(byteString);
            return this;
        }

        private Builder() {
            super(HttpRule.DEFAULT_INSTANCE);
        }

        public Builder addAdditionalBindings(int i4, HttpRule httpRule) {
            f();
            ((HttpRule) this.f33398b).O0(i4, httpRule);
            return this;
        }

        public Builder setAdditionalBindings(int i4, Builder builder) {
            f();
            ((HttpRule) this.f33398b).f1(i4, builder.build());
            return this;
        }

        public Builder setCustom(CustomHttpPattern.Builder builder) {
            f();
            ((HttpRule) this.f33398b).i1(builder.build());
            return this;
        }

        public Builder addAdditionalBindings(Builder builder) {
            f();
            ((HttpRule) this.f33398b).P0(builder.build());
            return this;
        }

        public Builder addAdditionalBindings(int i4, Builder builder) {
            f();
            ((HttpRule) this.f33398b).O0(i4, builder.build());
            return this;
        }
    }

    /* loaded from: classes5.dex */
    public enum PatternCase {
        GET(2),
        PUT(3),
        POST(4),
        DELETE(5),
        PATCH(6),
        CUSTOM(8),
        PATTERN_NOT_SET(0);
        
        private final int value;

        PatternCase(int i4) {
            this.value = i4;
        }

        public static PatternCase forNumber(int i4) {
            if (i4 != 0) {
                if (i4 != 8) {
                    if (i4 != 2) {
                        if (i4 != 3) {
                            if (i4 != 4) {
                                if (i4 != 5) {
                                    if (i4 != 6) {
                                        return null;
                                    }
                                    return PATCH;
                                }
                                return DELETE;
                            }
                            return POST;
                        }
                        return PUT;
                    }
                    return GET;
                }
                return CUSTOM;
            }
            return PATTERN_NOT_SET;
        }

        public int getNumber() {
            return this.value;
        }

        @Deprecated
        public static PatternCase valueOf(int i4) {
            return forNumber(i4);
        }
    }

    static {
        HttpRule httpRule = new HttpRule();
        DEFAULT_INSTANCE = httpRule;
        GeneratedMessageLite.d0(HttpRule.class, httpRule);
    }

    private HttpRule() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O0(int i4, HttpRule httpRule) {
        httpRule.getClass();
        c1();
        this.additionalBindings_.add(i4, httpRule);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P0(HttpRule httpRule) {
        httpRule.getClass();
        c1();
        this.additionalBindings_.add(httpRule);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q0(Iterable<? extends HttpRule> iterable) {
        c1();
        AbstractMessageLite.a(iterable, this.additionalBindings_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R0() {
        this.additionalBindings_ = GeneratedMessageLite.y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S0() {
        this.body_ = getDefaultInstance().getBody();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T0() {
        if (this.patternCase_ == 8) {
            this.patternCase_ = 0;
            this.pattern_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U0() {
        if (this.patternCase_ == 5) {
            this.patternCase_ = 0;
            this.pattern_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V0() {
        if (this.patternCase_ == 2) {
            this.patternCase_ = 0;
            this.pattern_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W0() {
        if (this.patternCase_ == 6) {
            this.patternCase_ = 0;
            this.pattern_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X0() {
        this.patternCase_ = 0;
        this.pattern_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y0() {
        if (this.patternCase_ == 4) {
            this.patternCase_ = 0;
            this.pattern_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z0() {
        if (this.patternCase_ == 3) {
            this.patternCase_ = 0;
            this.pattern_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a1() {
        this.responseBody_ = getDefaultInstance().getResponseBody();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b1() {
        this.selector_ = getDefaultInstance().getSelector();
    }

    private void c1() {
        Internal.ProtobufList<HttpRule> protobufList = this.additionalBindings_;
        if (!protobufList.isModifiable()) {
            this.additionalBindings_ = GeneratedMessageLite.K(protobufList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d1(CustomHttpPattern customHttpPattern) {
        customHttpPattern.getClass();
        if (this.patternCase_ == 8 && this.pattern_ != CustomHttpPattern.getDefaultInstance()) {
            this.pattern_ = CustomHttpPattern.newBuilder((CustomHttpPattern) this.pattern_).mergeFrom((CustomHttpPattern.Builder) customHttpPattern).buildPartial();
        } else {
            this.pattern_ = customHttpPattern;
        }
        this.patternCase_ = 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e1(int i4) {
        c1();
        this.additionalBindings_.remove(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f1(int i4, HttpRule httpRule) {
        httpRule.getClass();
        c1();
        this.additionalBindings_.set(i4, httpRule);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g1(String str) {
        str.getClass();
        this.body_ = str;
    }

    public static HttpRule getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h1(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        this.body_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i1(CustomHttpPattern customHttpPattern) {
        customHttpPattern.getClass();
        this.pattern_ = customHttpPattern;
        this.patternCase_ = 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j1(String str) {
        str.getClass();
        this.patternCase_ = 5;
        this.pattern_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k1(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        this.pattern_ = byteString.toStringUtf8();
        this.patternCase_ = 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l1(String str) {
        str.getClass();
        this.patternCase_ = 2;
        this.pattern_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m1(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        this.pattern_ = byteString.toStringUtf8();
        this.patternCase_ = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n1(String str) {
        str.getClass();
        this.patternCase_ = 6;
        this.pattern_ = str;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o1(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        this.pattern_ = byteString.toStringUtf8();
        this.patternCase_ = 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p1(String str) {
        str.getClass();
        this.patternCase_ = 4;
        this.pattern_ = str;
    }

    public static HttpRule parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (HttpRule) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
    }

    public static HttpRule parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (HttpRule) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<HttpRule> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q1(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        this.pattern_ = byteString.toStringUtf8();
        this.patternCase_ = 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r1(String str) {
        str.getClass();
        this.patternCase_ = 3;
        this.pattern_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s1(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        this.pattern_ = byteString.toStringUtf8();
        this.patternCase_ = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t1(String str) {
        str.getClass();
        this.responseBody_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u1(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        this.responseBody_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v1(String str) {
        str.getClass();
        this.selector_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w1(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        this.selector_ = byteString.toStringUtf8();
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public HttpRule getAdditionalBindings(int i4) {
        return this.additionalBindings_.get(i4);
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public int getAdditionalBindingsCount() {
        return this.additionalBindings_.size();
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public List<HttpRule> getAdditionalBindingsList() {
        return this.additionalBindings_;
    }

    public HttpRuleOrBuilder getAdditionalBindingsOrBuilder(int i4) {
        return this.additionalBindings_.get(i4);
    }

    public List<? extends HttpRuleOrBuilder> getAdditionalBindingsOrBuilderList() {
        return this.additionalBindings_;
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public String getBody() {
        return this.body_;
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public ByteString getBodyBytes() {
        return ByteString.copyFromUtf8(this.body_);
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public CustomHttpPattern getCustom() {
        if (this.patternCase_ == 8) {
            return (CustomHttpPattern) this.pattern_;
        }
        return CustomHttpPattern.getDefaultInstance();
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public String getDelete() {
        if (this.patternCase_ == 5) {
            return (String) this.pattern_;
        }
        return "";
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public ByteString getDeleteBytes() {
        String str;
        if (this.patternCase_ == 5) {
            str = (String) this.pattern_;
        } else {
            str = "";
        }
        return ByteString.copyFromUtf8(str);
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public String getGet() {
        if (this.patternCase_ == 2) {
            return (String) this.pattern_;
        }
        return "";
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public ByteString getGetBytes() {
        String str;
        if (this.patternCase_ == 2) {
            str = (String) this.pattern_;
        } else {
            str = "";
        }
        return ByteString.copyFromUtf8(str);
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public String getPatch() {
        if (this.patternCase_ == 6) {
            return (String) this.pattern_;
        }
        return "";
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public ByteString getPatchBytes() {
        String str;
        if (this.patternCase_ == 6) {
            str = (String) this.pattern_;
        } else {
            str = "";
        }
        return ByteString.copyFromUtf8(str);
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public PatternCase getPatternCase() {
        return PatternCase.forNumber(this.patternCase_);
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public String getPost() {
        if (this.patternCase_ == 4) {
            return (String) this.pattern_;
        }
        return "";
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public ByteString getPostBytes() {
        String str;
        if (this.patternCase_ == 4) {
            str = (String) this.pattern_;
        } else {
            str = "";
        }
        return ByteString.copyFromUtf8(str);
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public String getPut() {
        if (this.patternCase_ == 3) {
            return (String) this.pattern_;
        }
        return "";
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public ByteString getPutBytes() {
        String str;
        if (this.patternCase_ == 3) {
            str = (String) this.pattern_;
        } else {
            str = "";
        }
        return ByteString.copyFromUtf8(str);
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public String getResponseBody() {
        return this.responseBody_;
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public ByteString getResponseBodyBytes() {
        return ByteString.copyFromUtf8(this.responseBody_);
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public String getSelector() {
        return this.selector_;
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public ByteString getSelectorBytes() {
        return ByteString.copyFromUtf8(this.selector_);
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public boolean hasCustom() {
        if (this.patternCase_ == 8) {
            return true;
        }
        return false;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.f25412a[methodToInvoke.ordinal()]) {
            case 1:
                return new HttpRule();
            case 2:
                return new Builder(null);
            case 3:
                return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\n\u0001\u0000\u0001\f\n\u0000\u0001\u0000\u0001Ȉ\u0002Ȼ\u0000\u0003Ȼ\u0000\u0004Ȼ\u0000\u0005Ȼ\u0000\u0006Ȼ\u0000\u0007Ȉ\b<\u0000\u000b\u001b\fȈ", new Object[]{"pattern_", "patternCase_", "selector_", "body_", CustomHttpPattern.class, "additionalBindings_", HttpRule.class, "responseBody_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<HttpRule> parser = PARSER;
                if (parser == null) {
                    synchronized (HttpRule.class) {
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

    public static Builder newBuilder(HttpRule httpRule) {
        return DEFAULT_INSTANCE.r(httpRule);
    }

    public static HttpRule parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (HttpRule) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static HttpRule parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (HttpRule) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static HttpRule parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (HttpRule) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
    }

    public static HttpRule parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (HttpRule) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static HttpRule parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (HttpRule) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
    }

    public static HttpRule parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (HttpRule) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static HttpRule parseFrom(InputStream inputStream) throws IOException {
        return (HttpRule) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
    }

    public static HttpRule parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (HttpRule) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static HttpRule parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (HttpRule) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
    }

    public static HttpRule parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (HttpRule) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
