package com.google.api;

import com.google.api.MetricRule;
import com.google.api.QuotaLimit;
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
public final class Quota extends GeneratedMessageLite<Quota, Builder> implements QuotaOrBuilder {
    private static final Quota DEFAULT_INSTANCE;
    public static final int LIMITS_FIELD_NUMBER = 3;
    public static final int METRIC_RULES_FIELD_NUMBER = 4;
    private static volatile Parser<Quota> PARSER;
    private Internal.ProtobufList<QuotaLimit> limits_ = GeneratedMessageLite.y();
    private Internal.ProtobufList<MetricRule> metricRules_ = GeneratedMessageLite.y();

    /* renamed from: com.google.api.Quota$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f25449a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f25449a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f25449a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f25449a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f25449a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f25449a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f25449a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f25449a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<Quota, Builder> implements QuotaOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllLimits(Iterable<? extends QuotaLimit> iterable) {
            f();
            ((Quota) this.f33398b).s0(iterable);
            return this;
        }

        public Builder addAllMetricRules(Iterable<? extends MetricRule> iterable) {
            f();
            ((Quota) this.f33398b).t0(iterable);
            return this;
        }

        public Builder addLimits(QuotaLimit quotaLimit) {
            f();
            ((Quota) this.f33398b).v0(quotaLimit);
            return this;
        }

        public Builder addMetricRules(MetricRule metricRule) {
            f();
            ((Quota) this.f33398b).x0(metricRule);
            return this;
        }

        public Builder clearLimits() {
            f();
            ((Quota) this.f33398b).y0();
            return this;
        }

        public Builder clearMetricRules() {
            f();
            ((Quota) this.f33398b).z0();
            return this;
        }

        @Override // com.google.api.QuotaOrBuilder
        public QuotaLimit getLimits(int i4) {
            return ((Quota) this.f33398b).getLimits(i4);
        }

        @Override // com.google.api.QuotaOrBuilder
        public int getLimitsCount() {
            return ((Quota) this.f33398b).getLimitsCount();
        }

        @Override // com.google.api.QuotaOrBuilder
        public List<QuotaLimit> getLimitsList() {
            return Collections.unmodifiableList(((Quota) this.f33398b).getLimitsList());
        }

        @Override // com.google.api.QuotaOrBuilder
        public MetricRule getMetricRules(int i4) {
            return ((Quota) this.f33398b).getMetricRules(i4);
        }

        @Override // com.google.api.QuotaOrBuilder
        public int getMetricRulesCount() {
            return ((Quota) this.f33398b).getMetricRulesCount();
        }

        @Override // com.google.api.QuotaOrBuilder
        public List<MetricRule> getMetricRulesList() {
            return Collections.unmodifiableList(((Quota) this.f33398b).getMetricRulesList());
        }

        public Builder removeLimits(int i4) {
            f();
            ((Quota) this.f33398b).C0(i4);
            return this;
        }

        public Builder removeMetricRules(int i4) {
            f();
            ((Quota) this.f33398b).D0(i4);
            return this;
        }

        public Builder setLimits(int i4, QuotaLimit quotaLimit) {
            f();
            ((Quota) this.f33398b).E0(i4, quotaLimit);
            return this;
        }

        public Builder setMetricRules(int i4, MetricRule metricRule) {
            f();
            ((Quota) this.f33398b).F0(i4, metricRule);
            return this;
        }

        private Builder() {
            super(Quota.DEFAULT_INSTANCE);
        }

        public Builder addLimits(int i4, QuotaLimit quotaLimit) {
            f();
            ((Quota) this.f33398b).u0(i4, quotaLimit);
            return this;
        }

        public Builder addMetricRules(int i4, MetricRule metricRule) {
            f();
            ((Quota) this.f33398b).w0(i4, metricRule);
            return this;
        }

        public Builder setLimits(int i4, QuotaLimit.Builder builder) {
            f();
            ((Quota) this.f33398b).E0(i4, builder.build());
            return this;
        }

        public Builder setMetricRules(int i4, MetricRule.Builder builder) {
            f();
            ((Quota) this.f33398b).F0(i4, builder.build());
            return this;
        }

        public Builder addLimits(QuotaLimit.Builder builder) {
            f();
            ((Quota) this.f33398b).v0(builder.build());
            return this;
        }

        public Builder addMetricRules(MetricRule.Builder builder) {
            f();
            ((Quota) this.f33398b).x0(builder.build());
            return this;
        }

        public Builder addLimits(int i4, QuotaLimit.Builder builder) {
            f();
            ((Quota) this.f33398b).u0(i4, builder.build());
            return this;
        }

        public Builder addMetricRules(int i4, MetricRule.Builder builder) {
            f();
            ((Quota) this.f33398b).w0(i4, builder.build());
            return this;
        }
    }

    static {
        Quota quota = new Quota();
        DEFAULT_INSTANCE = quota;
        GeneratedMessageLite.d0(Quota.class, quota);
    }

    private Quota() {
    }

    private void A0() {
        Internal.ProtobufList<QuotaLimit> protobufList = this.limits_;
        if (!protobufList.isModifiable()) {
            this.limits_ = GeneratedMessageLite.K(protobufList);
        }
    }

    private void B0() {
        Internal.ProtobufList<MetricRule> protobufList = this.metricRules_;
        if (!protobufList.isModifiable()) {
            this.metricRules_ = GeneratedMessageLite.K(protobufList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C0(int i4) {
        A0();
        this.limits_.remove(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D0(int i4) {
        B0();
        this.metricRules_.remove(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E0(int i4, QuotaLimit quotaLimit) {
        quotaLimit.getClass();
        A0();
        this.limits_.set(i4, quotaLimit);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F0(int i4, MetricRule metricRule) {
        metricRule.getClass();
        B0();
        this.metricRules_.set(i4, metricRule);
    }

    public static Quota getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.q();
    }

    public static Quota parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Quota) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
    }

    public static Quota parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (Quota) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Quota> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0(Iterable<? extends QuotaLimit> iterable) {
        A0();
        AbstractMessageLite.a(iterable, this.limits_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t0(Iterable<? extends MetricRule> iterable) {
        B0();
        AbstractMessageLite.a(iterable, this.metricRules_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u0(int i4, QuotaLimit quotaLimit) {
        quotaLimit.getClass();
        A0();
        this.limits_.add(i4, quotaLimit);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v0(QuotaLimit quotaLimit) {
        quotaLimit.getClass();
        A0();
        this.limits_.add(quotaLimit);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w0(int i4, MetricRule metricRule) {
        metricRule.getClass();
        B0();
        this.metricRules_.add(i4, metricRule);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0(MetricRule metricRule) {
        metricRule.getClass();
        B0();
        this.metricRules_.add(metricRule);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0() {
        this.limits_ = GeneratedMessageLite.y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0() {
        this.metricRules_ = GeneratedMessageLite.y();
    }

    @Override // com.google.api.QuotaOrBuilder
    public QuotaLimit getLimits(int i4) {
        return this.limits_.get(i4);
    }

    @Override // com.google.api.QuotaOrBuilder
    public int getLimitsCount() {
        return this.limits_.size();
    }

    @Override // com.google.api.QuotaOrBuilder
    public List<QuotaLimit> getLimitsList() {
        return this.limits_;
    }

    public QuotaLimitOrBuilder getLimitsOrBuilder(int i4) {
        return this.limits_.get(i4);
    }

    public List<? extends QuotaLimitOrBuilder> getLimitsOrBuilderList() {
        return this.limits_;
    }

    @Override // com.google.api.QuotaOrBuilder
    public MetricRule getMetricRules(int i4) {
        return this.metricRules_.get(i4);
    }

    @Override // com.google.api.QuotaOrBuilder
    public int getMetricRulesCount() {
        return this.metricRules_.size();
    }

    @Override // com.google.api.QuotaOrBuilder
    public List<MetricRule> getMetricRulesList() {
        return this.metricRules_;
    }

    public MetricRuleOrBuilder getMetricRulesOrBuilder(int i4) {
        return this.metricRules_.get(i4);
    }

    public List<? extends MetricRuleOrBuilder> getMetricRulesOrBuilderList() {
        return this.metricRules_;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.f25449a[methodToInvoke.ordinal()]) {
            case 1:
                return new Quota();
            case 2:
                return new Builder(null);
            case 3:
                return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0003\u0004\u0002\u0000\u0002\u0000\u0003\u001b\u0004\u001b", new Object[]{"limits_", QuotaLimit.class, "metricRules_", MetricRule.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Quota> parser = PARSER;
                if (parser == null) {
                    synchronized (Quota.class) {
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

    public static Builder newBuilder(Quota quota) {
        return DEFAULT_INSTANCE.r(quota);
    }

    public static Quota parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Quota) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Quota parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Quota) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Quota parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (Quota) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
    }

    public static Quota parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Quota) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Quota parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (Quota) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
    }

    public static Quota parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Quota) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Quota parseFrom(InputStream inputStream) throws IOException {
        return (Quota) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
    }

    public static Quota parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Quota) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Quota parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Quota) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Quota parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Quota) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
