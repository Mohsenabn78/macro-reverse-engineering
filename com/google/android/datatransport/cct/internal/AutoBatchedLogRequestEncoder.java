package com.google.android.datatransport.cct.internal;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.io.IOException;

/* loaded from: classes.dex */
public final class AutoBatchedLogRequestEncoder implements Configurator {
    public static final int CODEGEN_VERSION = 2;
    public static final Configurator CONFIG = new AutoBatchedLogRequestEncoder();

    /* loaded from: classes.dex */
    private static final class AndroidClientInfoEncoder implements ObjectEncoder<AndroidClientInfo> {

        /* renamed from: a  reason: collision with root package name */
        static final AndroidClientInfoEncoder f18503a = new AndroidClientInfoEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f18504b = FieldDescriptor.of(RemoteConfigConstants.RequestFieldKey.SDK_VERSION);

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f18505c = FieldDescriptor.of("model");

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f18506d = FieldDescriptor.of("hardware");

        /* renamed from: e  reason: collision with root package name */
        private static final FieldDescriptor f18507e = FieldDescriptor.of("device");

        /* renamed from: f  reason: collision with root package name */
        private static final FieldDescriptor f18508f = FieldDescriptor.of("product");

        /* renamed from: g  reason: collision with root package name */
        private static final FieldDescriptor f18509g = FieldDescriptor.of("osBuild");

        /* renamed from: h  reason: collision with root package name */
        private static final FieldDescriptor f18510h = FieldDescriptor.of("manufacturer");

        /* renamed from: i  reason: collision with root package name */
        private static final FieldDescriptor f18511i = FieldDescriptor.of("fingerprint");

        /* renamed from: j  reason: collision with root package name */
        private static final FieldDescriptor f18512j = FieldDescriptor.of("locale");

        /* renamed from: k  reason: collision with root package name */
        private static final FieldDescriptor f18513k = FieldDescriptor.of("country");

        /* renamed from: l  reason: collision with root package name */
        private static final FieldDescriptor f18514l = FieldDescriptor.of("mccMnc");

        /* renamed from: m  reason: collision with root package name */
        private static final FieldDescriptor f18515m = FieldDescriptor.of("applicationBuild");

        private AndroidClientInfoEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* renamed from: a */
        public void encode(AndroidClientInfo androidClientInfo, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(f18504b, androidClientInfo.getSdkVersion());
            objectEncoderContext.add(f18505c, androidClientInfo.getModel());
            objectEncoderContext.add(f18506d, androidClientInfo.getHardware());
            objectEncoderContext.add(f18507e, androidClientInfo.getDevice());
            objectEncoderContext.add(f18508f, androidClientInfo.getProduct());
            objectEncoderContext.add(f18509g, androidClientInfo.getOsBuild());
            objectEncoderContext.add(f18510h, androidClientInfo.getManufacturer());
            objectEncoderContext.add(f18511i, androidClientInfo.getFingerprint());
            objectEncoderContext.add(f18512j, androidClientInfo.getLocale());
            objectEncoderContext.add(f18513k, androidClientInfo.getCountry());
            objectEncoderContext.add(f18514l, androidClientInfo.getMccMnc());
            objectEncoderContext.add(f18515m, androidClientInfo.getApplicationBuild());
        }
    }

    /* loaded from: classes.dex */
    private static final class BatchedLogRequestEncoder implements ObjectEncoder<BatchedLogRequest> {

        /* renamed from: a  reason: collision with root package name */
        static final BatchedLogRequestEncoder f18516a = new BatchedLogRequestEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f18517b = FieldDescriptor.of("logRequest");

        private BatchedLogRequestEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* renamed from: a */
        public void encode(BatchedLogRequest batchedLogRequest, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(f18517b, batchedLogRequest.getLogRequests());
        }
    }

    /* loaded from: classes.dex */
    private static final class ClientInfoEncoder implements ObjectEncoder<ClientInfo> {

        /* renamed from: a  reason: collision with root package name */
        static final ClientInfoEncoder f18518a = new ClientInfoEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f18519b = FieldDescriptor.of("clientType");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f18520c = FieldDescriptor.of("androidClientInfo");

        private ClientInfoEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* renamed from: a */
        public void encode(ClientInfo clientInfo, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(f18519b, clientInfo.getClientType());
            objectEncoderContext.add(f18520c, clientInfo.getAndroidClientInfo());
        }
    }

    /* loaded from: classes.dex */
    private static final class LogEventEncoder implements ObjectEncoder<LogEvent> {

        /* renamed from: a  reason: collision with root package name */
        static final LogEventEncoder f18521a = new LogEventEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f18522b = FieldDescriptor.of("eventTimeMs");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f18523c = FieldDescriptor.of("eventCode");

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f18524d = FieldDescriptor.of("eventUptimeMs");

        /* renamed from: e  reason: collision with root package name */
        private static final FieldDescriptor f18525e = FieldDescriptor.of("sourceExtension");

        /* renamed from: f  reason: collision with root package name */
        private static final FieldDescriptor f18526f = FieldDescriptor.of("sourceExtensionJsonProto3");

        /* renamed from: g  reason: collision with root package name */
        private static final FieldDescriptor f18527g = FieldDescriptor.of("timezoneOffsetSeconds");

        /* renamed from: h  reason: collision with root package name */
        private static final FieldDescriptor f18528h = FieldDescriptor.of("networkConnectionInfo");

        private LogEventEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* renamed from: a */
        public void encode(LogEvent logEvent, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(f18522b, logEvent.getEventTimeMs());
            objectEncoderContext.add(f18523c, logEvent.getEventCode());
            objectEncoderContext.add(f18524d, logEvent.getEventUptimeMs());
            objectEncoderContext.add(f18525e, logEvent.getSourceExtension());
            objectEncoderContext.add(f18526f, logEvent.getSourceExtensionJsonProto3());
            objectEncoderContext.add(f18527g, logEvent.getTimezoneOffsetSeconds());
            objectEncoderContext.add(f18528h, logEvent.getNetworkConnectionInfo());
        }
    }

    /* loaded from: classes.dex */
    private static final class LogRequestEncoder implements ObjectEncoder<LogRequest> {

        /* renamed from: a  reason: collision with root package name */
        static final LogRequestEncoder f18529a = new LogRequestEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f18530b = FieldDescriptor.of("requestTimeMs");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f18531c = FieldDescriptor.of("requestUptimeMs");

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f18532d = FieldDescriptor.of("clientInfo");

        /* renamed from: e  reason: collision with root package name */
        private static final FieldDescriptor f18533e = FieldDescriptor.of("logSource");

        /* renamed from: f  reason: collision with root package name */
        private static final FieldDescriptor f18534f = FieldDescriptor.of("logSourceName");

        /* renamed from: g  reason: collision with root package name */
        private static final FieldDescriptor f18535g = FieldDescriptor.of("logEvent");

        /* renamed from: h  reason: collision with root package name */
        private static final FieldDescriptor f18536h = FieldDescriptor.of("qosTier");

        private LogRequestEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* renamed from: a */
        public void encode(LogRequest logRequest, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(f18530b, logRequest.getRequestTimeMs());
            objectEncoderContext.add(f18531c, logRequest.getRequestUptimeMs());
            objectEncoderContext.add(f18532d, logRequest.getClientInfo());
            objectEncoderContext.add(f18533e, logRequest.getLogSource());
            objectEncoderContext.add(f18534f, logRequest.getLogSourceName());
            objectEncoderContext.add(f18535g, logRequest.getLogEvents());
            objectEncoderContext.add(f18536h, logRequest.getQosTier());
        }
    }

    /* loaded from: classes.dex */
    private static final class NetworkConnectionInfoEncoder implements ObjectEncoder<NetworkConnectionInfo> {

        /* renamed from: a  reason: collision with root package name */
        static final NetworkConnectionInfoEncoder f18537a = new NetworkConnectionInfoEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f18538b = FieldDescriptor.of("networkType");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f18539c = FieldDescriptor.of("mobileSubtype");

        private NetworkConnectionInfoEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* renamed from: a */
        public void encode(NetworkConnectionInfo networkConnectionInfo, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(f18538b, networkConnectionInfo.getNetworkType());
            objectEncoderContext.add(f18539c, networkConnectionInfo.getMobileSubtype());
        }
    }

    private AutoBatchedLogRequestEncoder() {
    }

    @Override // com.google.firebase.encoders.config.Configurator
    public void configure(EncoderConfig<?> encoderConfig) {
        BatchedLogRequestEncoder batchedLogRequestEncoder = BatchedLogRequestEncoder.f18516a;
        encoderConfig.registerEncoder(BatchedLogRequest.class, batchedLogRequestEncoder);
        encoderConfig.registerEncoder(AutoValue_BatchedLogRequest.class, batchedLogRequestEncoder);
        LogRequestEncoder logRequestEncoder = LogRequestEncoder.f18529a;
        encoderConfig.registerEncoder(LogRequest.class, logRequestEncoder);
        encoderConfig.registerEncoder(AutoValue_LogRequest.class, logRequestEncoder);
        ClientInfoEncoder clientInfoEncoder = ClientInfoEncoder.f18518a;
        encoderConfig.registerEncoder(ClientInfo.class, clientInfoEncoder);
        encoderConfig.registerEncoder(AutoValue_ClientInfo.class, clientInfoEncoder);
        AndroidClientInfoEncoder androidClientInfoEncoder = AndroidClientInfoEncoder.f18503a;
        encoderConfig.registerEncoder(AndroidClientInfo.class, androidClientInfoEncoder);
        encoderConfig.registerEncoder(AutoValue_AndroidClientInfo.class, androidClientInfoEncoder);
        LogEventEncoder logEventEncoder = LogEventEncoder.f18521a;
        encoderConfig.registerEncoder(LogEvent.class, logEventEncoder);
        encoderConfig.registerEncoder(AutoValue_LogEvent.class, logEventEncoder);
        NetworkConnectionInfoEncoder networkConnectionInfoEncoder = NetworkConnectionInfoEncoder.f18537a;
        encoderConfig.registerEncoder(NetworkConnectionInfo.class, networkConnectionInfoEncoder);
        encoderConfig.registerEncoder(AutoValue_NetworkConnectionInfo.class, networkConnectionInfoEncoder);
    }
}
