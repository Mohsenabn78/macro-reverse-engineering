package com.google.api;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: classes5.dex */
public final class Monitoring extends GeneratedMessageLite<Monitoring, Builder> implements MonitoringOrBuilder {
    public static final int CONSUMER_DESTINATIONS_FIELD_NUMBER = 2;
    private static final Monitoring DEFAULT_INSTANCE;
    private static volatile Parser<Monitoring> PARSER = null;
    public static final int PRODUCER_DESTINATIONS_FIELD_NUMBER = 1;
    private Internal.ProtobufList<MonitoringDestination> producerDestinations_ = GeneratedMessageLite.y();
    private Internal.ProtobufList<MonitoringDestination> consumerDestinations_ = GeneratedMessageLite.y();

    /* renamed from: com.google.api.Monitoring$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f25441a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f25441a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f25441a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f25441a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f25441a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f25441a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f25441a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f25441a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<Monitoring, Builder> implements MonitoringOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllConsumerDestinations(Iterable<? extends MonitoringDestination> iterable) {
            f();
            ((Monitoring) this.f33398b).s0(iterable);
            return this;
        }

        public Builder addAllProducerDestinations(Iterable<? extends MonitoringDestination> iterable) {
            f();
            ((Monitoring) this.f33398b).t0(iterable);
            return this;
        }

        public Builder addConsumerDestinations(MonitoringDestination monitoringDestination) {
            f();
            ((Monitoring) this.f33398b).v0(monitoringDestination);
            return this;
        }

        public Builder addProducerDestinations(MonitoringDestination monitoringDestination) {
            f();
            ((Monitoring) this.f33398b).x0(monitoringDestination);
            return this;
        }

        public Builder clearConsumerDestinations() {
            f();
            ((Monitoring) this.f33398b).y0();
            return this;
        }

        public Builder clearProducerDestinations() {
            f();
            ((Monitoring) this.f33398b).z0();
            return this;
        }

        @Override // com.google.api.MonitoringOrBuilder
        public MonitoringDestination getConsumerDestinations(int i4) {
            return ((Monitoring) this.f33398b).getConsumerDestinations(i4);
        }

        @Override // com.google.api.MonitoringOrBuilder
        public int getConsumerDestinationsCount() {
            return ((Monitoring) this.f33398b).getConsumerDestinationsCount();
        }

        @Override // com.google.api.MonitoringOrBuilder
        public List<MonitoringDestination> getConsumerDestinationsList() {
            return Collections.unmodifiableList(((Monitoring) this.f33398b).getConsumerDestinationsList());
        }

        @Override // com.google.api.MonitoringOrBuilder
        public MonitoringDestination getProducerDestinations(int i4) {
            return ((Monitoring) this.f33398b).getProducerDestinations(i4);
        }

        @Override // com.google.api.MonitoringOrBuilder
        public int getProducerDestinationsCount() {
            return ((Monitoring) this.f33398b).getProducerDestinationsCount();
        }

        @Override // com.google.api.MonitoringOrBuilder
        public List<MonitoringDestination> getProducerDestinationsList() {
            return Collections.unmodifiableList(((Monitoring) this.f33398b).getProducerDestinationsList());
        }

        public Builder removeConsumerDestinations(int i4) {
            f();
            ((Monitoring) this.f33398b).C0(i4);
            return this;
        }

        public Builder removeProducerDestinations(int i4) {
            f();
            ((Monitoring) this.f33398b).D0(i4);
            return this;
        }

        public Builder setConsumerDestinations(int i4, MonitoringDestination monitoringDestination) {
            f();
            ((Monitoring) this.f33398b).E0(i4, monitoringDestination);
            return this;
        }

        public Builder setProducerDestinations(int i4, MonitoringDestination monitoringDestination) {
            f();
            ((Monitoring) this.f33398b).F0(i4, monitoringDestination);
            return this;
        }

        private Builder() {
            super(Monitoring.DEFAULT_INSTANCE);
        }

        public Builder addConsumerDestinations(int i4, MonitoringDestination monitoringDestination) {
            f();
            ((Monitoring) this.f33398b).u0(i4, monitoringDestination);
            return this;
        }

        public Builder addProducerDestinations(int i4, MonitoringDestination monitoringDestination) {
            f();
            ((Monitoring) this.f33398b).w0(i4, monitoringDestination);
            return this;
        }

        public Builder setConsumerDestinations(int i4, MonitoringDestination.Builder builder) {
            f();
            ((Monitoring) this.f33398b).E0(i4, builder.build());
            return this;
        }

        public Builder setProducerDestinations(int i4, MonitoringDestination.Builder builder) {
            f();
            ((Monitoring) this.f33398b).F0(i4, builder.build());
            return this;
        }

        public Builder addConsumerDestinations(MonitoringDestination.Builder builder) {
            f();
            ((Monitoring) this.f33398b).v0(builder.build());
            return this;
        }

        public Builder addProducerDestinations(MonitoringDestination.Builder builder) {
            f();
            ((Monitoring) this.f33398b).x0(builder.build());
            return this;
        }

        public Builder addConsumerDestinations(int i4, MonitoringDestination.Builder builder) {
            f();
            ((Monitoring) this.f33398b).u0(i4, builder.build());
            return this;
        }

        public Builder addProducerDestinations(int i4, MonitoringDestination.Builder builder) {
            f();
            ((Monitoring) this.f33398b).w0(i4, builder.build());
            return this;
        }
    }

    /* loaded from: classes5.dex */
    public static final class MonitoringDestination extends GeneratedMessageLite<MonitoringDestination, Builder> implements MonitoringDestinationOrBuilder {
        private static final MonitoringDestination DEFAULT_INSTANCE;
        public static final int METRICS_FIELD_NUMBER = 2;
        public static final int MONITORED_RESOURCE_FIELD_NUMBER = 1;
        private static volatile Parser<MonitoringDestination> PARSER;
        private String monitoredResource_ = "";
        private Internal.ProtobufList<String> metrics_ = GeneratedMessageLite.y();

        /* loaded from: classes5.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<MonitoringDestination, Builder> implements MonitoringDestinationOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder addAllMetrics(Iterable<String> iterable) {
                f();
                ((MonitoringDestination) this.f33398b).o0(iterable);
                return this;
            }

            public Builder addMetrics(String str) {
                f();
                ((MonitoringDestination) this.f33398b).p0(str);
                return this;
            }

            public Builder addMetricsBytes(ByteString byteString) {
                f();
                ((MonitoringDestination) this.f33398b).q0(byteString);
                return this;
            }

            public Builder clearMetrics() {
                f();
                ((MonitoringDestination) this.f33398b).r0();
                return this;
            }

            public Builder clearMonitoredResource() {
                f();
                ((MonitoringDestination) this.f33398b).s0();
                return this;
            }

            @Override // com.google.api.Monitoring.MonitoringDestinationOrBuilder
            public String getMetrics(int i4) {
                return ((MonitoringDestination) this.f33398b).getMetrics(i4);
            }

            @Override // com.google.api.Monitoring.MonitoringDestinationOrBuilder
            public ByteString getMetricsBytes(int i4) {
                return ((MonitoringDestination) this.f33398b).getMetricsBytes(i4);
            }

            @Override // com.google.api.Monitoring.MonitoringDestinationOrBuilder
            public int getMetricsCount() {
                return ((MonitoringDestination) this.f33398b).getMetricsCount();
            }

            @Override // com.google.api.Monitoring.MonitoringDestinationOrBuilder
            public List<String> getMetricsList() {
                return Collections.unmodifiableList(((MonitoringDestination) this.f33398b).getMetricsList());
            }

            @Override // com.google.api.Monitoring.MonitoringDestinationOrBuilder
            public String getMonitoredResource() {
                return ((MonitoringDestination) this.f33398b).getMonitoredResource();
            }

            @Override // com.google.api.Monitoring.MonitoringDestinationOrBuilder
            public ByteString getMonitoredResourceBytes() {
                return ((MonitoringDestination) this.f33398b).getMonitoredResourceBytes();
            }

            public Builder setMetrics(int i4, String str) {
                f();
                ((MonitoringDestination) this.f33398b).u0(i4, str);
                return this;
            }

            public Builder setMonitoredResource(String str) {
                f();
                ((MonitoringDestination) this.f33398b).v0(str);
                return this;
            }

            public Builder setMonitoredResourceBytes(ByteString byteString) {
                f();
                ((MonitoringDestination) this.f33398b).w0(byteString);
                return this;
            }

            private Builder() {
                super(MonitoringDestination.DEFAULT_INSTANCE);
            }
        }

        static {
            MonitoringDestination monitoringDestination = new MonitoringDestination();
            DEFAULT_INSTANCE = monitoringDestination;
            GeneratedMessageLite.d0(MonitoringDestination.class, monitoringDestination);
        }

        private MonitoringDestination() {
        }

        public static MonitoringDestination getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.q();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void o0(Iterable<String> iterable) {
            t0();
            AbstractMessageLite.a(iterable, this.metrics_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void p0(String str) {
            str.getClass();
            t0();
            this.metrics_.add(str);
        }

        public static MonitoringDestination parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (MonitoringDestination) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
        }

        public static MonitoringDestination parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (MonitoringDestination) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<MonitoringDestination> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void q0(ByteString byteString) {
            AbstractMessageLite.b(byteString);
            t0();
            this.metrics_.add(byteString.toStringUtf8());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void r0() {
            this.metrics_ = GeneratedMessageLite.y();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s0() {
            this.monitoredResource_ = getDefaultInstance().getMonitoredResource();
        }

        private void t0() {
            Internal.ProtobufList<String> protobufList = this.metrics_;
            if (!protobufList.isModifiable()) {
                this.metrics_ = GeneratedMessageLite.K(protobufList);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void u0(int i4, String str) {
            str.getClass();
            t0();
            this.metrics_.set(i4, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void v0(String str) {
            str.getClass();
            this.monitoredResource_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void w0(ByteString byteString) {
            AbstractMessageLite.b(byteString);
            this.monitoredResource_ = byteString.toStringUtf8();
        }

        @Override // com.google.api.Monitoring.MonitoringDestinationOrBuilder
        public String getMetrics(int i4) {
            return this.metrics_.get(i4);
        }

        @Override // com.google.api.Monitoring.MonitoringDestinationOrBuilder
        public ByteString getMetricsBytes(int i4) {
            return ByteString.copyFromUtf8(this.metrics_.get(i4));
        }

        @Override // com.google.api.Monitoring.MonitoringDestinationOrBuilder
        public int getMetricsCount() {
            return this.metrics_.size();
        }

        @Override // com.google.api.Monitoring.MonitoringDestinationOrBuilder
        public List<String> getMetricsList() {
            return this.metrics_;
        }

        @Override // com.google.api.Monitoring.MonitoringDestinationOrBuilder
        public String getMonitoredResource() {
            return this.monitoredResource_;
        }

        @Override // com.google.api.Monitoring.MonitoringDestinationOrBuilder
        public ByteString getMonitoredResourceBytes() {
            return ByteString.copyFromUtf8(this.monitoredResource_);
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (AnonymousClass1.f25441a[methodToInvoke.ordinal()]) {
                case 1:
                    return new MonitoringDestination();
                case 2:
                    return new Builder(null);
                case 3:
                    return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002Ț", new Object[]{"monitoredResource_", "metrics_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<MonitoringDestination> parser = PARSER;
                    if (parser == null) {
                        synchronized (MonitoringDestination.class) {
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

        public static Builder newBuilder(MonitoringDestination monitoringDestination) {
            return DEFAULT_INSTANCE.r(monitoringDestination);
        }

        public static MonitoringDestination parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MonitoringDestination) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static MonitoringDestination parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (MonitoringDestination) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static MonitoringDestination parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (MonitoringDestination) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
        }

        public static MonitoringDestination parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (MonitoringDestination) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static MonitoringDestination parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (MonitoringDestination) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
        }

        public static MonitoringDestination parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (MonitoringDestination) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static MonitoringDestination parseFrom(InputStream inputStream) throws IOException {
            return (MonitoringDestination) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
        }

        public static MonitoringDestination parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MonitoringDestination) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static MonitoringDestination parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (MonitoringDestination) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
        }

        public static MonitoringDestination parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MonitoringDestination) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: classes5.dex */
    public interface MonitoringDestinationOrBuilder extends MessageLiteOrBuilder {
        String getMetrics(int i4);

        ByteString getMetricsBytes(int i4);

        int getMetricsCount();

        List<String> getMetricsList();

        String getMonitoredResource();

        ByteString getMonitoredResourceBytes();
    }

    static {
        Monitoring monitoring = new Monitoring();
        DEFAULT_INSTANCE = monitoring;
        GeneratedMessageLite.d0(Monitoring.class, monitoring);
    }

    private Monitoring() {
    }

    private void A0() {
        Internal.ProtobufList<MonitoringDestination> protobufList = this.consumerDestinations_;
        if (!protobufList.isModifiable()) {
            this.consumerDestinations_ = GeneratedMessageLite.K(protobufList);
        }
    }

    private void B0() {
        Internal.ProtobufList<MonitoringDestination> protobufList = this.producerDestinations_;
        if (!protobufList.isModifiable()) {
            this.producerDestinations_ = GeneratedMessageLite.K(protobufList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C0(int i4) {
        A0();
        this.consumerDestinations_.remove(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D0(int i4) {
        B0();
        this.producerDestinations_.remove(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E0(int i4, MonitoringDestination monitoringDestination) {
        monitoringDestination.getClass();
        A0();
        this.consumerDestinations_.set(i4, monitoringDestination);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F0(int i4, MonitoringDestination monitoringDestination) {
        monitoringDestination.getClass();
        B0();
        this.producerDestinations_.set(i4, monitoringDestination);
    }

    public static Monitoring getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.q();
    }

    public static Monitoring parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Monitoring) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
    }

    public static Monitoring parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (Monitoring) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Monitoring> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0(Iterable<? extends MonitoringDestination> iterable) {
        A0();
        AbstractMessageLite.a(iterable, this.consumerDestinations_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t0(Iterable<? extends MonitoringDestination> iterable) {
        B0();
        AbstractMessageLite.a(iterable, this.producerDestinations_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u0(int i4, MonitoringDestination monitoringDestination) {
        monitoringDestination.getClass();
        A0();
        this.consumerDestinations_.add(i4, monitoringDestination);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v0(MonitoringDestination monitoringDestination) {
        monitoringDestination.getClass();
        A0();
        this.consumerDestinations_.add(monitoringDestination);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w0(int i4, MonitoringDestination monitoringDestination) {
        monitoringDestination.getClass();
        B0();
        this.producerDestinations_.add(i4, monitoringDestination);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0(MonitoringDestination monitoringDestination) {
        monitoringDestination.getClass();
        B0();
        this.producerDestinations_.add(monitoringDestination);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0() {
        this.consumerDestinations_ = GeneratedMessageLite.y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0() {
        this.producerDestinations_ = GeneratedMessageLite.y();
    }

    @Override // com.google.api.MonitoringOrBuilder
    public MonitoringDestination getConsumerDestinations(int i4) {
        return this.consumerDestinations_.get(i4);
    }

    @Override // com.google.api.MonitoringOrBuilder
    public int getConsumerDestinationsCount() {
        return this.consumerDestinations_.size();
    }

    @Override // com.google.api.MonitoringOrBuilder
    public List<MonitoringDestination> getConsumerDestinationsList() {
        return this.consumerDestinations_;
    }

    public MonitoringDestinationOrBuilder getConsumerDestinationsOrBuilder(int i4) {
        return this.consumerDestinations_.get(i4);
    }

    public List<? extends MonitoringDestinationOrBuilder> getConsumerDestinationsOrBuilderList() {
        return this.consumerDestinations_;
    }

    @Override // com.google.api.MonitoringOrBuilder
    public MonitoringDestination getProducerDestinations(int i4) {
        return this.producerDestinations_.get(i4);
    }

    @Override // com.google.api.MonitoringOrBuilder
    public int getProducerDestinationsCount() {
        return this.producerDestinations_.size();
    }

    @Override // com.google.api.MonitoringOrBuilder
    public List<MonitoringDestination> getProducerDestinationsList() {
        return this.producerDestinations_;
    }

    public MonitoringDestinationOrBuilder getProducerDestinationsOrBuilder(int i4) {
        return this.producerDestinations_.get(i4);
    }

    public List<? extends MonitoringDestinationOrBuilder> getProducerDestinationsOrBuilderList() {
        return this.producerDestinations_;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.f25441a[methodToInvoke.ordinal()]) {
            case 1:
                return new Monitoring();
            case 2:
                return new Builder(null);
            case 3:
                return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0002\u0000\u0001\u001b\u0002\u001b", new Object[]{"producerDestinations_", MonitoringDestination.class, "consumerDestinations_", MonitoringDestination.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Monitoring> parser = PARSER;
                if (parser == null) {
                    synchronized (Monitoring.class) {
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

    public static Builder newBuilder(Monitoring monitoring) {
        return DEFAULT_INSTANCE.r(monitoring);
    }

    public static Monitoring parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Monitoring) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Monitoring parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Monitoring) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Monitoring parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (Monitoring) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
    }

    public static Monitoring parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Monitoring) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Monitoring parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (Monitoring) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
    }

    public static Monitoring parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Monitoring) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Monitoring parseFrom(InputStream inputStream) throws IOException {
        return (Monitoring) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
    }

    public static Monitoring parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Monitoring) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Monitoring parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Monitoring) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Monitoring parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Monitoring) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
