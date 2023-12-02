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
public final class Logging extends GeneratedMessageLite<Logging, Builder> implements LoggingOrBuilder {
    public static final int CONSUMER_DESTINATIONS_FIELD_NUMBER = 2;
    private static final Logging DEFAULT_INSTANCE;
    private static volatile Parser<Logging> PARSER = null;
    public static final int PRODUCER_DESTINATIONS_FIELD_NUMBER = 1;
    private Internal.ProtobufList<LoggingDestination> producerDestinations_ = GeneratedMessageLite.y();
    private Internal.ProtobufList<LoggingDestination> consumerDestinations_ = GeneratedMessageLite.y();

    /* renamed from: com.google.api.Logging$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f25424a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f25424a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f25424a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f25424a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f25424a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f25424a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f25424a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f25424a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<Logging, Builder> implements LoggingOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllConsumerDestinations(Iterable<? extends LoggingDestination> iterable) {
            f();
            ((Logging) this.f33398b).s0(iterable);
            return this;
        }

        public Builder addAllProducerDestinations(Iterable<? extends LoggingDestination> iterable) {
            f();
            ((Logging) this.f33398b).t0(iterable);
            return this;
        }

        public Builder addConsumerDestinations(LoggingDestination loggingDestination) {
            f();
            ((Logging) this.f33398b).v0(loggingDestination);
            return this;
        }

        public Builder addProducerDestinations(LoggingDestination loggingDestination) {
            f();
            ((Logging) this.f33398b).x0(loggingDestination);
            return this;
        }

        public Builder clearConsumerDestinations() {
            f();
            ((Logging) this.f33398b).y0();
            return this;
        }

        public Builder clearProducerDestinations() {
            f();
            ((Logging) this.f33398b).z0();
            return this;
        }

        @Override // com.google.api.LoggingOrBuilder
        public LoggingDestination getConsumerDestinations(int i4) {
            return ((Logging) this.f33398b).getConsumerDestinations(i4);
        }

        @Override // com.google.api.LoggingOrBuilder
        public int getConsumerDestinationsCount() {
            return ((Logging) this.f33398b).getConsumerDestinationsCount();
        }

        @Override // com.google.api.LoggingOrBuilder
        public List<LoggingDestination> getConsumerDestinationsList() {
            return Collections.unmodifiableList(((Logging) this.f33398b).getConsumerDestinationsList());
        }

        @Override // com.google.api.LoggingOrBuilder
        public LoggingDestination getProducerDestinations(int i4) {
            return ((Logging) this.f33398b).getProducerDestinations(i4);
        }

        @Override // com.google.api.LoggingOrBuilder
        public int getProducerDestinationsCount() {
            return ((Logging) this.f33398b).getProducerDestinationsCount();
        }

        @Override // com.google.api.LoggingOrBuilder
        public List<LoggingDestination> getProducerDestinationsList() {
            return Collections.unmodifiableList(((Logging) this.f33398b).getProducerDestinationsList());
        }

        public Builder removeConsumerDestinations(int i4) {
            f();
            ((Logging) this.f33398b).C0(i4);
            return this;
        }

        public Builder removeProducerDestinations(int i4) {
            f();
            ((Logging) this.f33398b).D0(i4);
            return this;
        }

        public Builder setConsumerDestinations(int i4, LoggingDestination loggingDestination) {
            f();
            ((Logging) this.f33398b).E0(i4, loggingDestination);
            return this;
        }

        public Builder setProducerDestinations(int i4, LoggingDestination loggingDestination) {
            f();
            ((Logging) this.f33398b).F0(i4, loggingDestination);
            return this;
        }

        private Builder() {
            super(Logging.DEFAULT_INSTANCE);
        }

        public Builder addConsumerDestinations(int i4, LoggingDestination loggingDestination) {
            f();
            ((Logging) this.f33398b).u0(i4, loggingDestination);
            return this;
        }

        public Builder addProducerDestinations(int i4, LoggingDestination loggingDestination) {
            f();
            ((Logging) this.f33398b).w0(i4, loggingDestination);
            return this;
        }

        public Builder setConsumerDestinations(int i4, LoggingDestination.Builder builder) {
            f();
            ((Logging) this.f33398b).E0(i4, builder.build());
            return this;
        }

        public Builder setProducerDestinations(int i4, LoggingDestination.Builder builder) {
            f();
            ((Logging) this.f33398b).F0(i4, builder.build());
            return this;
        }

        public Builder addConsumerDestinations(LoggingDestination.Builder builder) {
            f();
            ((Logging) this.f33398b).v0(builder.build());
            return this;
        }

        public Builder addProducerDestinations(LoggingDestination.Builder builder) {
            f();
            ((Logging) this.f33398b).x0(builder.build());
            return this;
        }

        public Builder addConsumerDestinations(int i4, LoggingDestination.Builder builder) {
            f();
            ((Logging) this.f33398b).u0(i4, builder.build());
            return this;
        }

        public Builder addProducerDestinations(int i4, LoggingDestination.Builder builder) {
            f();
            ((Logging) this.f33398b).w0(i4, builder.build());
            return this;
        }
    }

    /* loaded from: classes5.dex */
    public static final class LoggingDestination extends GeneratedMessageLite<LoggingDestination, Builder> implements LoggingDestinationOrBuilder {
        private static final LoggingDestination DEFAULT_INSTANCE;
        public static final int LOGS_FIELD_NUMBER = 1;
        public static final int MONITORED_RESOURCE_FIELD_NUMBER = 3;
        private static volatile Parser<LoggingDestination> PARSER;
        private String monitoredResource_ = "";
        private Internal.ProtobufList<String> logs_ = GeneratedMessageLite.y();

        /* loaded from: classes5.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<LoggingDestination, Builder> implements LoggingDestinationOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder addAllLogs(Iterable<String> iterable) {
                f();
                ((LoggingDestination) this.f33398b).o0(iterable);
                return this;
            }

            public Builder addLogs(String str) {
                f();
                ((LoggingDestination) this.f33398b).p0(str);
                return this;
            }

            public Builder addLogsBytes(ByteString byteString) {
                f();
                ((LoggingDestination) this.f33398b).q0(byteString);
                return this;
            }

            public Builder clearLogs() {
                f();
                ((LoggingDestination) this.f33398b).r0();
                return this;
            }

            public Builder clearMonitoredResource() {
                f();
                ((LoggingDestination) this.f33398b).s0();
                return this;
            }

            @Override // com.google.api.Logging.LoggingDestinationOrBuilder
            public String getLogs(int i4) {
                return ((LoggingDestination) this.f33398b).getLogs(i4);
            }

            @Override // com.google.api.Logging.LoggingDestinationOrBuilder
            public ByteString getLogsBytes(int i4) {
                return ((LoggingDestination) this.f33398b).getLogsBytes(i4);
            }

            @Override // com.google.api.Logging.LoggingDestinationOrBuilder
            public int getLogsCount() {
                return ((LoggingDestination) this.f33398b).getLogsCount();
            }

            @Override // com.google.api.Logging.LoggingDestinationOrBuilder
            public List<String> getLogsList() {
                return Collections.unmodifiableList(((LoggingDestination) this.f33398b).getLogsList());
            }

            @Override // com.google.api.Logging.LoggingDestinationOrBuilder
            public String getMonitoredResource() {
                return ((LoggingDestination) this.f33398b).getMonitoredResource();
            }

            @Override // com.google.api.Logging.LoggingDestinationOrBuilder
            public ByteString getMonitoredResourceBytes() {
                return ((LoggingDestination) this.f33398b).getMonitoredResourceBytes();
            }

            public Builder setLogs(int i4, String str) {
                f();
                ((LoggingDestination) this.f33398b).u0(i4, str);
                return this;
            }

            public Builder setMonitoredResource(String str) {
                f();
                ((LoggingDestination) this.f33398b).v0(str);
                return this;
            }

            public Builder setMonitoredResourceBytes(ByteString byteString) {
                f();
                ((LoggingDestination) this.f33398b).w0(byteString);
                return this;
            }

            private Builder() {
                super(LoggingDestination.DEFAULT_INSTANCE);
            }
        }

        static {
            LoggingDestination loggingDestination = new LoggingDestination();
            DEFAULT_INSTANCE = loggingDestination;
            GeneratedMessageLite.d0(LoggingDestination.class, loggingDestination);
        }

        private LoggingDestination() {
        }

        public static LoggingDestination getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.q();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void o0(Iterable<String> iterable) {
            t0();
            AbstractMessageLite.a(iterable, this.logs_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void p0(String str) {
            str.getClass();
            t0();
            this.logs_.add(str);
        }

        public static LoggingDestination parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (LoggingDestination) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
        }

        public static LoggingDestination parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (LoggingDestination) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<LoggingDestination> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void q0(ByteString byteString) {
            AbstractMessageLite.b(byteString);
            t0();
            this.logs_.add(byteString.toStringUtf8());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void r0() {
            this.logs_ = GeneratedMessageLite.y();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s0() {
            this.monitoredResource_ = getDefaultInstance().getMonitoredResource();
        }

        private void t0() {
            Internal.ProtobufList<String> protobufList = this.logs_;
            if (!protobufList.isModifiable()) {
                this.logs_ = GeneratedMessageLite.K(protobufList);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void u0(int i4, String str) {
            str.getClass();
            t0();
            this.logs_.set(i4, str);
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

        @Override // com.google.api.Logging.LoggingDestinationOrBuilder
        public String getLogs(int i4) {
            return this.logs_.get(i4);
        }

        @Override // com.google.api.Logging.LoggingDestinationOrBuilder
        public ByteString getLogsBytes(int i4) {
            return ByteString.copyFromUtf8(this.logs_.get(i4));
        }

        @Override // com.google.api.Logging.LoggingDestinationOrBuilder
        public int getLogsCount() {
            return this.logs_.size();
        }

        @Override // com.google.api.Logging.LoggingDestinationOrBuilder
        public List<String> getLogsList() {
            return this.logs_;
        }

        @Override // com.google.api.Logging.LoggingDestinationOrBuilder
        public String getMonitoredResource() {
            return this.monitoredResource_;
        }

        @Override // com.google.api.Logging.LoggingDestinationOrBuilder
        public ByteString getMonitoredResourceBytes() {
            return ByteString.copyFromUtf8(this.monitoredResource_);
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (AnonymousClass1.f25424a[methodToInvoke.ordinal()]) {
                case 1:
                    return new LoggingDestination();
                case 2:
                    return new Builder(null);
                case 3:
                    return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0001\u0000\u0001Ț\u0003Ȉ", new Object[]{"logs_", "monitoredResource_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<LoggingDestination> parser = PARSER;
                    if (parser == null) {
                        synchronized (LoggingDestination.class) {
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

        public static Builder newBuilder(LoggingDestination loggingDestination) {
            return DEFAULT_INSTANCE.r(loggingDestination);
        }

        public static LoggingDestination parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (LoggingDestination) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static LoggingDestination parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (LoggingDestination) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static LoggingDestination parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (LoggingDestination) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
        }

        public static LoggingDestination parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (LoggingDestination) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static LoggingDestination parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (LoggingDestination) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
        }

        public static LoggingDestination parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (LoggingDestination) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static LoggingDestination parseFrom(InputStream inputStream) throws IOException {
            return (LoggingDestination) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
        }

        public static LoggingDestination parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (LoggingDestination) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static LoggingDestination parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (LoggingDestination) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
        }

        public static LoggingDestination parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (LoggingDestination) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: classes5.dex */
    public interface LoggingDestinationOrBuilder extends MessageLiteOrBuilder {
        String getLogs(int i4);

        ByteString getLogsBytes(int i4);

        int getLogsCount();

        List<String> getLogsList();

        String getMonitoredResource();

        ByteString getMonitoredResourceBytes();
    }

    static {
        Logging logging = new Logging();
        DEFAULT_INSTANCE = logging;
        GeneratedMessageLite.d0(Logging.class, logging);
    }

    private Logging() {
    }

    private void A0() {
        Internal.ProtobufList<LoggingDestination> protobufList = this.consumerDestinations_;
        if (!protobufList.isModifiable()) {
            this.consumerDestinations_ = GeneratedMessageLite.K(protobufList);
        }
    }

    private void B0() {
        Internal.ProtobufList<LoggingDestination> protobufList = this.producerDestinations_;
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
    public void E0(int i4, LoggingDestination loggingDestination) {
        loggingDestination.getClass();
        A0();
        this.consumerDestinations_.set(i4, loggingDestination);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F0(int i4, LoggingDestination loggingDestination) {
        loggingDestination.getClass();
        B0();
        this.producerDestinations_.set(i4, loggingDestination);
    }

    public static Logging getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.q();
    }

    public static Logging parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Logging) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
    }

    public static Logging parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (Logging) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Logging> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0(Iterable<? extends LoggingDestination> iterable) {
        A0();
        AbstractMessageLite.a(iterable, this.consumerDestinations_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t0(Iterable<? extends LoggingDestination> iterable) {
        B0();
        AbstractMessageLite.a(iterable, this.producerDestinations_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u0(int i4, LoggingDestination loggingDestination) {
        loggingDestination.getClass();
        A0();
        this.consumerDestinations_.add(i4, loggingDestination);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v0(LoggingDestination loggingDestination) {
        loggingDestination.getClass();
        A0();
        this.consumerDestinations_.add(loggingDestination);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w0(int i4, LoggingDestination loggingDestination) {
        loggingDestination.getClass();
        B0();
        this.producerDestinations_.add(i4, loggingDestination);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0(LoggingDestination loggingDestination) {
        loggingDestination.getClass();
        B0();
        this.producerDestinations_.add(loggingDestination);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0() {
        this.consumerDestinations_ = GeneratedMessageLite.y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0() {
        this.producerDestinations_ = GeneratedMessageLite.y();
    }

    @Override // com.google.api.LoggingOrBuilder
    public LoggingDestination getConsumerDestinations(int i4) {
        return this.consumerDestinations_.get(i4);
    }

    @Override // com.google.api.LoggingOrBuilder
    public int getConsumerDestinationsCount() {
        return this.consumerDestinations_.size();
    }

    @Override // com.google.api.LoggingOrBuilder
    public List<LoggingDestination> getConsumerDestinationsList() {
        return this.consumerDestinations_;
    }

    public LoggingDestinationOrBuilder getConsumerDestinationsOrBuilder(int i4) {
        return this.consumerDestinations_.get(i4);
    }

    public List<? extends LoggingDestinationOrBuilder> getConsumerDestinationsOrBuilderList() {
        return this.consumerDestinations_;
    }

    @Override // com.google.api.LoggingOrBuilder
    public LoggingDestination getProducerDestinations(int i4) {
        return this.producerDestinations_.get(i4);
    }

    @Override // com.google.api.LoggingOrBuilder
    public int getProducerDestinationsCount() {
        return this.producerDestinations_.size();
    }

    @Override // com.google.api.LoggingOrBuilder
    public List<LoggingDestination> getProducerDestinationsList() {
        return this.producerDestinations_;
    }

    public LoggingDestinationOrBuilder getProducerDestinationsOrBuilder(int i4) {
        return this.producerDestinations_.get(i4);
    }

    public List<? extends LoggingDestinationOrBuilder> getProducerDestinationsOrBuilderList() {
        return this.producerDestinations_;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.f25424a[methodToInvoke.ordinal()]) {
            case 1:
                return new Logging();
            case 2:
                return new Builder(null);
            case 3:
                return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0002\u0000\u0001\u001b\u0002\u001b", new Object[]{"producerDestinations_", LoggingDestination.class, "consumerDestinations_", LoggingDestination.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Logging> parser = PARSER;
                if (parser == null) {
                    synchronized (Logging.class) {
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

    public static Builder newBuilder(Logging logging) {
        return DEFAULT_INSTANCE.r(logging);
    }

    public static Logging parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Logging) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Logging parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Logging) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Logging parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (Logging) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
    }

    public static Logging parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Logging) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Logging parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (Logging) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
    }

    public static Logging parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Logging) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Logging parseFrom(InputStream inputStream) throws IOException {
        return (Logging) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
    }

    public static Logging parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Logging) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Logging parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Logging) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Logging parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Logging) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
