package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.firebase.transport.ClientMetrics;
import com.google.android.datatransport.runtime.firebase.transport.GlobalMetrics;
import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;
import com.google.android.datatransport.runtime.firebase.transport.LogSourceMetrics;
import com.google.android.datatransport.runtime.firebase.transport.StorageMetrics;
import com.google.android.datatransport.runtime.firebase.transport.TimeWindow;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;
import com.google.firebase.encoders.proto.AtProtobuf;
import java.io.IOException;

/* loaded from: classes.dex */
public final class AutoProtoEncoderDoNotUseEncoder implements Configurator {
    public static final int CODEGEN_VERSION = 2;
    public static final Configurator CONFIG = new AutoProtoEncoderDoNotUseEncoder();

    /* loaded from: classes.dex */
    private static final class ClientMetricsEncoder implements ObjectEncoder<ClientMetrics> {

        /* renamed from: a  reason: collision with root package name */
        static final ClientMetricsEncoder f18609a = new ClientMetricsEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f18610b = FieldDescriptor.builder("window").withProperty(AtProtobuf.builder().tag(1).build()).build();

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f18611c = FieldDescriptor.builder("logSourceMetrics").withProperty(AtProtobuf.builder().tag(2).build()).build();

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f18612d = FieldDescriptor.builder("globalMetrics").withProperty(AtProtobuf.builder().tag(3).build()).build();

        /* renamed from: e  reason: collision with root package name */
        private static final FieldDescriptor f18613e = FieldDescriptor.builder("appNamespace").withProperty(AtProtobuf.builder().tag(4).build()).build();

        private ClientMetricsEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* renamed from: a */
        public void encode(ClientMetrics clientMetrics, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(f18610b, clientMetrics.getWindowInternal());
            objectEncoderContext.add(f18611c, clientMetrics.getLogSourceMetricsList());
            objectEncoderContext.add(f18612d, clientMetrics.getGlobalMetricsInternal());
            objectEncoderContext.add(f18613e, clientMetrics.getAppNamespace());
        }
    }

    /* loaded from: classes.dex */
    private static final class GlobalMetricsEncoder implements ObjectEncoder<GlobalMetrics> {

        /* renamed from: a  reason: collision with root package name */
        static final GlobalMetricsEncoder f18614a = new GlobalMetricsEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f18615b = FieldDescriptor.builder("storageMetrics").withProperty(AtProtobuf.builder().tag(1).build()).build();

        private GlobalMetricsEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* renamed from: a */
        public void encode(GlobalMetrics globalMetrics, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(f18615b, globalMetrics.getStorageMetricsInternal());
        }
    }

    /* loaded from: classes.dex */
    private static final class LogEventDroppedEncoder implements ObjectEncoder<LogEventDropped> {

        /* renamed from: a  reason: collision with root package name */
        static final LogEventDroppedEncoder f18616a = new LogEventDroppedEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f18617b = FieldDescriptor.builder("eventsDroppedCount").withProperty(AtProtobuf.builder().tag(1).build()).build();

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f18618c = FieldDescriptor.builder("reason").withProperty(AtProtobuf.builder().tag(3).build()).build();

        private LogEventDroppedEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* renamed from: a */
        public void encode(LogEventDropped logEventDropped, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(f18617b, logEventDropped.getEventsDroppedCount());
            objectEncoderContext.add(f18618c, logEventDropped.getReason());
        }
    }

    /* loaded from: classes.dex */
    private static final class LogSourceMetricsEncoder implements ObjectEncoder<LogSourceMetrics> {

        /* renamed from: a  reason: collision with root package name */
        static final LogSourceMetricsEncoder f18619a = new LogSourceMetricsEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f18620b = FieldDescriptor.builder("logSource").withProperty(AtProtobuf.builder().tag(1).build()).build();

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f18621c = FieldDescriptor.builder("logEventDropped").withProperty(AtProtobuf.builder().tag(2).build()).build();

        private LogSourceMetricsEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* renamed from: a */
        public void encode(LogSourceMetrics logSourceMetrics, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(f18620b, logSourceMetrics.getLogSource());
            objectEncoderContext.add(f18621c, logSourceMetrics.getLogEventDroppedList());
        }
    }

    /* loaded from: classes.dex */
    private static final class ProtoEncoderDoNotUseEncoder implements ObjectEncoder<ProtoEncoderDoNotUse> {

        /* renamed from: a  reason: collision with root package name */
        static final ProtoEncoderDoNotUseEncoder f18622a = new ProtoEncoderDoNotUseEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f18623b = FieldDescriptor.of("clientMetrics");

        private ProtoEncoderDoNotUseEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* renamed from: a */
        public void encode(ProtoEncoderDoNotUse protoEncoderDoNotUse, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(f18623b, protoEncoderDoNotUse.getClientMetrics());
        }
    }

    /* loaded from: classes.dex */
    private static final class StorageMetricsEncoder implements ObjectEncoder<StorageMetrics> {

        /* renamed from: a  reason: collision with root package name */
        static final StorageMetricsEncoder f18624a = new StorageMetricsEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f18625b = FieldDescriptor.builder("currentCacheSizeBytes").withProperty(AtProtobuf.builder().tag(1).build()).build();

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f18626c = FieldDescriptor.builder("maxCacheSizeBytes").withProperty(AtProtobuf.builder().tag(2).build()).build();

        private StorageMetricsEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* renamed from: a */
        public void encode(StorageMetrics storageMetrics, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(f18625b, storageMetrics.getCurrentCacheSizeBytes());
            objectEncoderContext.add(f18626c, storageMetrics.getMaxCacheSizeBytes());
        }
    }

    /* loaded from: classes.dex */
    private static final class TimeWindowEncoder implements ObjectEncoder<TimeWindow> {

        /* renamed from: a  reason: collision with root package name */
        static final TimeWindowEncoder f18627a = new TimeWindowEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f18628b = FieldDescriptor.builder("startMs").withProperty(AtProtobuf.builder().tag(1).build()).build();

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f18629c = FieldDescriptor.builder("endMs").withProperty(AtProtobuf.builder().tag(2).build()).build();

        private TimeWindowEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* renamed from: a */
        public void encode(TimeWindow timeWindow, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(f18628b, timeWindow.getStartMs());
            objectEncoderContext.add(f18629c, timeWindow.getEndMs());
        }
    }

    private AutoProtoEncoderDoNotUseEncoder() {
    }

    @Override // com.google.firebase.encoders.config.Configurator
    public void configure(EncoderConfig<?> encoderConfig) {
        encoderConfig.registerEncoder(ProtoEncoderDoNotUse.class, ProtoEncoderDoNotUseEncoder.f18622a);
        encoderConfig.registerEncoder(ClientMetrics.class, ClientMetricsEncoder.f18609a);
        encoderConfig.registerEncoder(TimeWindow.class, TimeWindowEncoder.f18627a);
        encoderConfig.registerEncoder(LogSourceMetrics.class, LogSourceMetricsEncoder.f18619a);
        encoderConfig.registerEncoder(LogEventDropped.class, LogEventDroppedEncoder.f18616a);
        encoderConfig.registerEncoder(GlobalMetrics.class, GlobalMetricsEncoder.f18614a);
        encoderConfig.registerEncoder(StorageMetrics.class, StorageMetricsEncoder.f18624a);
    }
}
