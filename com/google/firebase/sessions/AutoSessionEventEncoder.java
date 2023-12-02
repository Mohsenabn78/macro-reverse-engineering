package com.google.firebase.sessions;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.io.IOException;

/* loaded from: classes5.dex */
public final class AutoSessionEventEncoder implements Configurator {
    public static final int CODEGEN_VERSION = 2;
    public static final Configurator CONFIG = new AutoSessionEventEncoder();

    /* loaded from: classes5.dex */
    private static final class AndroidApplicationInfoEncoder implements ObjectEncoder<AndroidApplicationInfo> {

        /* renamed from: a  reason: collision with root package name */
        static final AndroidApplicationInfoEncoder f32071a = new AndroidApplicationInfoEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f32072b = FieldDescriptor.of(RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME);

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f32073c = FieldDescriptor.of("versionName");

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f32074d = FieldDescriptor.of("appBuildVersion");

        /* renamed from: e  reason: collision with root package name */
        private static final FieldDescriptor f32075e = FieldDescriptor.of("deviceManufacturer");

        private AndroidApplicationInfoEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* renamed from: a */
        public void encode(AndroidApplicationInfo androidApplicationInfo, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(f32072b, androidApplicationInfo.getPackageName());
            objectEncoderContext.add(f32073c, androidApplicationInfo.getVersionName());
            objectEncoderContext.add(f32074d, androidApplicationInfo.getAppBuildVersion());
            objectEncoderContext.add(f32075e, androidApplicationInfo.getDeviceManufacturer());
        }
    }

    /* loaded from: classes5.dex */
    private static final class ApplicationInfoEncoder implements ObjectEncoder<ApplicationInfo> {

        /* renamed from: a  reason: collision with root package name */
        static final ApplicationInfoEncoder f32076a = new ApplicationInfoEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f32077b = FieldDescriptor.of(RemoteConfigConstants.RequestFieldKey.APP_ID);

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f32078c = FieldDescriptor.of("deviceModel");

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f32079d = FieldDescriptor.of("sessionSdkVersion");

        /* renamed from: e  reason: collision with root package name */
        private static final FieldDescriptor f32080e = FieldDescriptor.of("osVersion");

        /* renamed from: f  reason: collision with root package name */
        private static final FieldDescriptor f32081f = FieldDescriptor.of("logEnvironment");

        /* renamed from: g  reason: collision with root package name */
        private static final FieldDescriptor f32082g = FieldDescriptor.of("androidAppInfo");

        private ApplicationInfoEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* renamed from: a */
        public void encode(ApplicationInfo applicationInfo, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(f32077b, applicationInfo.getAppId());
            objectEncoderContext.add(f32078c, applicationInfo.getDeviceModel());
            objectEncoderContext.add(f32079d, applicationInfo.getSessionSdkVersion());
            objectEncoderContext.add(f32080e, applicationInfo.getOsVersion());
            objectEncoderContext.add(f32081f, applicationInfo.getLogEnvironment());
            objectEncoderContext.add(f32082g, applicationInfo.getAndroidAppInfo());
        }
    }

    /* loaded from: classes5.dex */
    private static final class DataCollectionStatusEncoder implements ObjectEncoder<DataCollectionStatus> {

        /* renamed from: a  reason: collision with root package name */
        static final DataCollectionStatusEncoder f32083a = new DataCollectionStatusEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f32084b = FieldDescriptor.of("performance");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f32085c = FieldDescriptor.of("crashlytics");

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f32086d = FieldDescriptor.of("sessionSamplingRate");

        private DataCollectionStatusEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* renamed from: a */
        public void encode(DataCollectionStatus dataCollectionStatus, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(f32084b, dataCollectionStatus.getPerformance());
            objectEncoderContext.add(f32085c, dataCollectionStatus.getCrashlytics());
            objectEncoderContext.add(f32086d, dataCollectionStatus.getSessionSamplingRate());
        }
    }

    /* loaded from: classes5.dex */
    private static final class SessionEventEncoder implements ObjectEncoder<SessionEvent> {

        /* renamed from: a  reason: collision with root package name */
        static final SessionEventEncoder f32087a = new SessionEventEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f32088b = FieldDescriptor.of("eventType");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f32089c = FieldDescriptor.of("sessionData");

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f32090d = FieldDescriptor.of("applicationInfo");

        private SessionEventEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* renamed from: a */
        public void encode(SessionEvent sessionEvent, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(f32088b, sessionEvent.getEventType());
            objectEncoderContext.add(f32089c, sessionEvent.getSessionData());
            objectEncoderContext.add(f32090d, sessionEvent.getApplicationInfo());
        }
    }

    /* loaded from: classes5.dex */
    private static final class SessionInfoEncoder implements ObjectEncoder<SessionInfo> {

        /* renamed from: a  reason: collision with root package name */
        static final SessionInfoEncoder f32091a = new SessionInfoEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f32092b = FieldDescriptor.of("sessionId");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f32093c = FieldDescriptor.of("firstSessionId");

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f32094d = FieldDescriptor.of("sessionIndex");

        /* renamed from: e  reason: collision with root package name */
        private static final FieldDescriptor f32095e = FieldDescriptor.of("eventTimestampUs");

        /* renamed from: f  reason: collision with root package name */
        private static final FieldDescriptor f32096f = FieldDescriptor.of("dataCollectionStatus");

        /* renamed from: g  reason: collision with root package name */
        private static final FieldDescriptor f32097g = FieldDescriptor.of("firebaseInstallationId");

        private SessionInfoEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* renamed from: a */
        public void encode(SessionInfo sessionInfo, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(f32092b, sessionInfo.getSessionId());
            objectEncoderContext.add(f32093c, sessionInfo.getFirstSessionId());
            objectEncoderContext.add(f32094d, sessionInfo.getSessionIndex());
            objectEncoderContext.add(f32095e, sessionInfo.getEventTimestampUs());
            objectEncoderContext.add(f32096f, sessionInfo.getDataCollectionStatus());
            objectEncoderContext.add(f32097g, sessionInfo.getFirebaseInstallationId());
        }
    }

    private AutoSessionEventEncoder() {
    }

    @Override // com.google.firebase.encoders.config.Configurator
    public void configure(EncoderConfig<?> encoderConfig) {
        encoderConfig.registerEncoder(SessionEvent.class, SessionEventEncoder.f32087a);
        encoderConfig.registerEncoder(SessionInfo.class, SessionInfoEncoder.f32091a);
        encoderConfig.registerEncoder(DataCollectionStatus.class, DataCollectionStatusEncoder.f32083a);
        encoderConfig.registerEncoder(ApplicationInfo.class, ApplicationInfoEncoder.f32076a);
        encoderConfig.registerEncoder(AndroidApplicationInfo.class, AndroidApplicationInfoEncoder.f32071a);
    }
}
