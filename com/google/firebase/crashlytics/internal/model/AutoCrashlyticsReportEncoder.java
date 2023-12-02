package com.google.firebase.crashlytics.internal.model;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.getpebble.android.kit.Constants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.sun.mail.imap.IMAPStore;
import java.io.IOException;

/* loaded from: classes5.dex */
public final class AutoCrashlyticsReportEncoder implements Configurator {
    public static final int CODEGEN_VERSION = 2;
    public static final Configurator CONFIG = new AutoCrashlyticsReportEncoder();

    /* loaded from: classes5.dex */
    private static final class CrashlyticsReportApplicationExitInfoBuildIdMappingForArchEncoder implements ObjectEncoder<CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch> {

        /* renamed from: a  reason: collision with root package name */
        static final CrashlyticsReportApplicationExitInfoBuildIdMappingForArchEncoder f29600a = new CrashlyticsReportApplicationExitInfoBuildIdMappingForArchEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f29601b = FieldDescriptor.of("arch");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f29602c = FieldDescriptor.of("libraryName");

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f29603d = FieldDescriptor.of("buildId");

        private CrashlyticsReportApplicationExitInfoBuildIdMappingForArchEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* renamed from: a */
        public void encode(CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch buildIdMappingForArch, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(f29601b, buildIdMappingForArch.getArch());
            objectEncoderContext.add(f29602c, buildIdMappingForArch.getLibraryName());
            objectEncoderContext.add(f29603d, buildIdMappingForArch.getBuildId());
        }
    }

    /* loaded from: classes5.dex */
    private static final class CrashlyticsReportApplicationExitInfoEncoder implements ObjectEncoder<CrashlyticsReport.ApplicationExitInfo> {

        /* renamed from: a  reason: collision with root package name */
        static final CrashlyticsReportApplicationExitInfoEncoder f29604a = new CrashlyticsReportApplicationExitInfoEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f29605b = FieldDescriptor.of("pid");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f29606c = FieldDescriptor.of("processName");

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f29607d = FieldDescriptor.of("reasonCode");

        /* renamed from: e  reason: collision with root package name */
        private static final FieldDescriptor f29608e = FieldDescriptor.of("importance");

        /* renamed from: f  reason: collision with root package name */
        private static final FieldDescriptor f29609f = FieldDescriptor.of("pss");

        /* renamed from: g  reason: collision with root package name */
        private static final FieldDescriptor f29610g = FieldDescriptor.of("rss");

        /* renamed from: h  reason: collision with root package name */
        private static final FieldDescriptor f29611h = FieldDescriptor.of("timestamp");

        /* renamed from: i  reason: collision with root package name */
        private static final FieldDescriptor f29612i = FieldDescriptor.of("traceFile");

        /* renamed from: j  reason: collision with root package name */
        private static final FieldDescriptor f29613j = FieldDescriptor.of("buildIdMappingForArch");

        private CrashlyticsReportApplicationExitInfoEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* renamed from: a */
        public void encode(CrashlyticsReport.ApplicationExitInfo applicationExitInfo, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(f29605b, applicationExitInfo.getPid());
            objectEncoderContext.add(f29606c, applicationExitInfo.getProcessName());
            objectEncoderContext.add(f29607d, applicationExitInfo.getReasonCode());
            objectEncoderContext.add(f29608e, applicationExitInfo.getImportance());
            objectEncoderContext.add(f29609f, applicationExitInfo.getPss());
            objectEncoderContext.add(f29610g, applicationExitInfo.getRss());
            objectEncoderContext.add(f29611h, applicationExitInfo.getTimestamp());
            objectEncoderContext.add(f29612i, applicationExitInfo.getTraceFile());
            objectEncoderContext.add(f29613j, applicationExitInfo.getBuildIdMappingForArch());
        }
    }

    /* loaded from: classes5.dex */
    private static final class CrashlyticsReportCustomAttributeEncoder implements ObjectEncoder<CrashlyticsReport.CustomAttribute> {

        /* renamed from: a  reason: collision with root package name */
        static final CrashlyticsReportCustomAttributeEncoder f29614a = new CrashlyticsReportCustomAttributeEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f29615b = FieldDescriptor.of("key");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f29616c = FieldDescriptor.of("value");

        private CrashlyticsReportCustomAttributeEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* renamed from: a */
        public void encode(CrashlyticsReport.CustomAttribute customAttribute, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(f29615b, customAttribute.getKey());
            objectEncoderContext.add(f29616c, customAttribute.getValue());
        }
    }

    /* loaded from: classes5.dex */
    private static final class CrashlyticsReportEncoder implements ObjectEncoder<CrashlyticsReport> {

        /* renamed from: a  reason: collision with root package name */
        static final CrashlyticsReportEncoder f29617a = new CrashlyticsReportEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f29618b = FieldDescriptor.of(RemoteConfigConstants.RequestFieldKey.SDK_VERSION);

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f29619c = FieldDescriptor.of("gmpAppId");

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f29620d = FieldDescriptor.of("platform");

        /* renamed from: e  reason: collision with root package name */
        private static final FieldDescriptor f29621e = FieldDescriptor.of("installationUuid");

        /* renamed from: f  reason: collision with root package name */
        private static final FieldDescriptor f29622f = FieldDescriptor.of("firebaseInstallationId");

        /* renamed from: g  reason: collision with root package name */
        private static final FieldDescriptor f29623g = FieldDescriptor.of("buildVersion");

        /* renamed from: h  reason: collision with root package name */
        private static final FieldDescriptor f29624h = FieldDescriptor.of("displayVersion");

        /* renamed from: i  reason: collision with root package name */
        private static final FieldDescriptor f29625i = FieldDescriptor.of("session");

        /* renamed from: j  reason: collision with root package name */
        private static final FieldDescriptor f29626j = FieldDescriptor.of("ndkPayload");

        /* renamed from: k  reason: collision with root package name */
        private static final FieldDescriptor f29627k = FieldDescriptor.of("appExitInfo");

        private CrashlyticsReportEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* renamed from: a */
        public void encode(CrashlyticsReport crashlyticsReport, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(f29618b, crashlyticsReport.getSdkVersion());
            objectEncoderContext.add(f29619c, crashlyticsReport.getGmpAppId());
            objectEncoderContext.add(f29620d, crashlyticsReport.getPlatform());
            objectEncoderContext.add(f29621e, crashlyticsReport.getInstallationUuid());
            objectEncoderContext.add(f29622f, crashlyticsReport.getFirebaseInstallationId());
            objectEncoderContext.add(f29623g, crashlyticsReport.getBuildVersion());
            objectEncoderContext.add(f29624h, crashlyticsReport.getDisplayVersion());
            objectEncoderContext.add(f29625i, crashlyticsReport.getSession());
            objectEncoderContext.add(f29626j, crashlyticsReport.getNdkPayload());
            objectEncoderContext.add(f29627k, crashlyticsReport.getAppExitInfo());
        }
    }

    /* loaded from: classes5.dex */
    private static final class CrashlyticsReportFilesPayloadEncoder implements ObjectEncoder<CrashlyticsReport.FilesPayload> {

        /* renamed from: a  reason: collision with root package name */
        static final CrashlyticsReportFilesPayloadEncoder f29628a = new CrashlyticsReportFilesPayloadEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f29629b = FieldDescriptor.of("files");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f29630c = FieldDescriptor.of("orgId");

        private CrashlyticsReportFilesPayloadEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* renamed from: a */
        public void encode(CrashlyticsReport.FilesPayload filesPayload, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(f29629b, filesPayload.getFiles());
            objectEncoderContext.add(f29630c, filesPayload.getOrgId());
        }
    }

    /* loaded from: classes5.dex */
    private static final class CrashlyticsReportFilesPayloadFileEncoder implements ObjectEncoder<CrashlyticsReport.FilesPayload.File> {

        /* renamed from: a  reason: collision with root package name */
        static final CrashlyticsReportFilesPayloadFileEncoder f29631a = new CrashlyticsReportFilesPayloadFileEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f29632b = FieldDescriptor.of("filename");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f29633c = FieldDescriptor.of("contents");

        private CrashlyticsReportFilesPayloadFileEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* renamed from: a */
        public void encode(CrashlyticsReport.FilesPayload.File file, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(f29632b, file.getFilename());
            objectEncoderContext.add(f29633c, file.getContents());
        }
    }

    /* loaded from: classes5.dex */
    private static final class CrashlyticsReportSessionApplicationEncoder implements ObjectEncoder<CrashlyticsReport.Session.Application> {

        /* renamed from: a  reason: collision with root package name */
        static final CrashlyticsReportSessionApplicationEncoder f29634a = new CrashlyticsReportSessionApplicationEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f29635b = FieldDescriptor.of("identifier");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f29636c = FieldDescriptor.of("version");

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f29637d = FieldDescriptor.of("displayVersion");

        /* renamed from: e  reason: collision with root package name */
        private static final FieldDescriptor f29638e = FieldDescriptor.of("organization");

        /* renamed from: f  reason: collision with root package name */
        private static final FieldDescriptor f29639f = FieldDescriptor.of("installationUuid");

        /* renamed from: g  reason: collision with root package name */
        private static final FieldDescriptor f29640g = FieldDescriptor.of("developmentPlatform");

        /* renamed from: h  reason: collision with root package name */
        private static final FieldDescriptor f29641h = FieldDescriptor.of("developmentPlatformVersion");

        private CrashlyticsReportSessionApplicationEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* renamed from: a */
        public void encode(CrashlyticsReport.Session.Application application, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(f29635b, application.getIdentifier());
            objectEncoderContext.add(f29636c, application.getVersion());
            objectEncoderContext.add(f29637d, application.getDisplayVersion());
            objectEncoderContext.add(f29638e, application.getOrganization());
            objectEncoderContext.add(f29639f, application.getInstallationUuid());
            objectEncoderContext.add(f29640g, application.getDevelopmentPlatform());
            objectEncoderContext.add(f29641h, application.getDevelopmentPlatformVersion());
        }
    }

    /* loaded from: classes5.dex */
    private static final class CrashlyticsReportSessionApplicationOrganizationEncoder implements ObjectEncoder<CrashlyticsReport.Session.Application.Organization> {

        /* renamed from: a  reason: collision with root package name */
        static final CrashlyticsReportSessionApplicationOrganizationEncoder f29642a = new CrashlyticsReportSessionApplicationOrganizationEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f29643b = FieldDescriptor.of("clsId");

        private CrashlyticsReportSessionApplicationOrganizationEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* renamed from: a */
        public void encode(CrashlyticsReport.Session.Application.Organization organization, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(f29643b, organization.getClsId());
        }
    }

    /* loaded from: classes5.dex */
    private static final class CrashlyticsReportSessionDeviceEncoder implements ObjectEncoder<CrashlyticsReport.Session.Device> {

        /* renamed from: a  reason: collision with root package name */
        static final CrashlyticsReportSessionDeviceEncoder f29644a = new CrashlyticsReportSessionDeviceEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f29645b = FieldDescriptor.of("arch");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f29646c = FieldDescriptor.of("model");

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f29647d = FieldDescriptor.of("cores");

        /* renamed from: e  reason: collision with root package name */
        private static final FieldDescriptor f29648e = FieldDescriptor.of("ram");

        /* renamed from: f  reason: collision with root package name */
        private static final FieldDescriptor f29649f = FieldDescriptor.of("diskSpace");

        /* renamed from: g  reason: collision with root package name */
        private static final FieldDescriptor f29650g = FieldDescriptor.of("simulator");

        /* renamed from: h  reason: collision with root package name */
        private static final FieldDescriptor f29651h = FieldDescriptor.of(RemoteConfigConstants.ResponseFieldKey.STATE);

        /* renamed from: i  reason: collision with root package name */
        private static final FieldDescriptor f29652i = FieldDescriptor.of("manufacturer");

        /* renamed from: j  reason: collision with root package name */
        private static final FieldDescriptor f29653j = FieldDescriptor.of("modelClass");

        private CrashlyticsReportSessionDeviceEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* renamed from: a */
        public void encode(CrashlyticsReport.Session.Device device, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(f29645b, device.getArch());
            objectEncoderContext.add(f29646c, device.getModel());
            objectEncoderContext.add(f29647d, device.getCores());
            objectEncoderContext.add(f29648e, device.getRam());
            objectEncoderContext.add(f29649f, device.getDiskSpace());
            objectEncoderContext.add(f29650g, device.isSimulator());
            objectEncoderContext.add(f29651h, device.getState());
            objectEncoderContext.add(f29652i, device.getManufacturer());
            objectEncoderContext.add(f29653j, device.getModelClass());
        }
    }

    /* loaded from: classes5.dex */
    private static final class CrashlyticsReportSessionEncoder implements ObjectEncoder<CrashlyticsReport.Session> {

        /* renamed from: a  reason: collision with root package name */
        static final CrashlyticsReportSessionEncoder f29654a = new CrashlyticsReportSessionEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f29655b = FieldDescriptor.of("generator");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f29656c = FieldDescriptor.of("identifier");

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f29657d = FieldDescriptor.of("appQualitySessionId");

        /* renamed from: e  reason: collision with root package name */
        private static final FieldDescriptor f29658e = FieldDescriptor.of("startedAt");

        /* renamed from: f  reason: collision with root package name */
        private static final FieldDescriptor f29659f = FieldDescriptor.of("endedAt");

        /* renamed from: g  reason: collision with root package name */
        private static final FieldDescriptor f29660g = FieldDescriptor.of("crashed");

        /* renamed from: h  reason: collision with root package name */
        private static final FieldDescriptor f29661h = FieldDescriptor.of("app");

        /* renamed from: i  reason: collision with root package name */
        private static final FieldDescriptor f29662i = FieldDescriptor.of("user");

        /* renamed from: j  reason: collision with root package name */
        private static final FieldDescriptor f29663j = FieldDescriptor.of(IMAPStore.ID_OS);

        /* renamed from: k  reason: collision with root package name */
        private static final FieldDescriptor f29664k = FieldDescriptor.of("device");

        /* renamed from: l  reason: collision with root package name */
        private static final FieldDescriptor f29665l = FieldDescriptor.of("events");

        /* renamed from: m  reason: collision with root package name */
        private static final FieldDescriptor f29666m = FieldDescriptor.of("generatorType");

        private CrashlyticsReportSessionEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* renamed from: a */
        public void encode(CrashlyticsReport.Session session, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(f29655b, session.getGenerator());
            objectEncoderContext.add(f29656c, session.getIdentifierUtf8Bytes());
            objectEncoderContext.add(f29657d, session.getAppQualitySessionId());
            objectEncoderContext.add(f29658e, session.getStartedAt());
            objectEncoderContext.add(f29659f, session.getEndedAt());
            objectEncoderContext.add(f29660g, session.isCrashed());
            objectEncoderContext.add(f29661h, session.getApp());
            objectEncoderContext.add(f29662i, session.getUser());
            objectEncoderContext.add(f29663j, session.getOs());
            objectEncoderContext.add(f29664k, session.getDevice());
            objectEncoderContext.add(f29665l, session.getEvents());
            objectEncoderContext.add(f29666m, session.getGeneratorType());
        }
    }

    /* loaded from: classes5.dex */
    private static final class CrashlyticsReportSessionEventApplicationEncoder implements ObjectEncoder<CrashlyticsReport.Session.Event.Application> {

        /* renamed from: a  reason: collision with root package name */
        static final CrashlyticsReportSessionEventApplicationEncoder f29667a = new CrashlyticsReportSessionEventApplicationEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f29668b = FieldDescriptor.of("execution");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f29669c = FieldDescriptor.of("customAttributes");

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f29670d = FieldDescriptor.of("internalKeys");

        /* renamed from: e  reason: collision with root package name */
        private static final FieldDescriptor f29671e = FieldDescriptor.of("background");

        /* renamed from: f  reason: collision with root package name */
        private static final FieldDescriptor f29672f = FieldDescriptor.of("uiOrientation");

        private CrashlyticsReportSessionEventApplicationEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* renamed from: a */
        public void encode(CrashlyticsReport.Session.Event.Application application, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(f29668b, application.getExecution());
            objectEncoderContext.add(f29669c, application.getCustomAttributes());
            objectEncoderContext.add(f29670d, application.getInternalKeys());
            objectEncoderContext.add(f29671e, application.getBackground());
            objectEncoderContext.add(f29672f, application.getUiOrientation());
        }
    }

    /* loaded from: classes5.dex */
    private static final class CrashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder implements ObjectEncoder<CrashlyticsReport.Session.Event.Application.Execution.BinaryImage> {

        /* renamed from: a  reason: collision with root package name */
        static final CrashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder f29673a = new CrashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f29674b = FieldDescriptor.of("baseAddress");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f29675c = FieldDescriptor.of("size");

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f29676d = FieldDescriptor.of("name");

        /* renamed from: e  reason: collision with root package name */
        private static final FieldDescriptor f29677e = FieldDescriptor.of(Constants.APP_UUID);

        private CrashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* renamed from: a */
        public void encode(CrashlyticsReport.Session.Event.Application.Execution.BinaryImage binaryImage, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(f29674b, binaryImage.getBaseAddress());
            objectEncoderContext.add(f29675c, binaryImage.getSize());
            objectEncoderContext.add(f29676d, binaryImage.getName());
            objectEncoderContext.add(f29677e, binaryImage.getUuidUtf8Bytes());
        }
    }

    /* loaded from: classes5.dex */
    private static final class CrashlyticsReportSessionEventApplicationExecutionEncoder implements ObjectEncoder<CrashlyticsReport.Session.Event.Application.Execution> {

        /* renamed from: a  reason: collision with root package name */
        static final CrashlyticsReportSessionEventApplicationExecutionEncoder f29678a = new CrashlyticsReportSessionEventApplicationExecutionEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f29679b = FieldDescriptor.of("threads");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f29680c = FieldDescriptor.of("exception");

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f29681d = FieldDescriptor.of("appExitInfo");

        /* renamed from: e  reason: collision with root package name */
        private static final FieldDescriptor f29682e = FieldDescriptor.of("signal");

        /* renamed from: f  reason: collision with root package name */
        private static final FieldDescriptor f29683f = FieldDescriptor.of("binaries");

        private CrashlyticsReportSessionEventApplicationExecutionEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* renamed from: a */
        public void encode(CrashlyticsReport.Session.Event.Application.Execution execution, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(f29679b, execution.getThreads());
            objectEncoderContext.add(f29680c, execution.getException());
            objectEncoderContext.add(f29681d, execution.getAppExitInfo());
            objectEncoderContext.add(f29682e, execution.getSignal());
            objectEncoderContext.add(f29683f, execution.getBinaries());
        }
    }

    /* loaded from: classes5.dex */
    private static final class CrashlyticsReportSessionEventApplicationExecutionExceptionEncoder implements ObjectEncoder<CrashlyticsReport.Session.Event.Application.Execution.Exception> {

        /* renamed from: a  reason: collision with root package name */
        static final CrashlyticsReportSessionEventApplicationExecutionExceptionEncoder f29684a = new CrashlyticsReportSessionEventApplicationExecutionExceptionEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f29685b = FieldDescriptor.of("type");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f29686c = FieldDescriptor.of("reason");

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f29687d = FieldDescriptor.of("frames");

        /* renamed from: e  reason: collision with root package name */
        private static final FieldDescriptor f29688e = FieldDescriptor.of("causedBy");

        /* renamed from: f  reason: collision with root package name */
        private static final FieldDescriptor f29689f = FieldDescriptor.of("overflowCount");

        private CrashlyticsReportSessionEventApplicationExecutionExceptionEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* renamed from: a */
        public void encode(CrashlyticsReport.Session.Event.Application.Execution.Exception exception, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(f29685b, exception.getType());
            objectEncoderContext.add(f29686c, exception.getReason());
            objectEncoderContext.add(f29687d, exception.getFrames());
            objectEncoderContext.add(f29688e, exception.getCausedBy());
            objectEncoderContext.add(f29689f, exception.getOverflowCount());
        }
    }

    /* loaded from: classes5.dex */
    private static final class CrashlyticsReportSessionEventApplicationExecutionSignalEncoder implements ObjectEncoder<CrashlyticsReport.Session.Event.Application.Execution.Signal> {

        /* renamed from: a  reason: collision with root package name */
        static final CrashlyticsReportSessionEventApplicationExecutionSignalEncoder f29690a = new CrashlyticsReportSessionEventApplicationExecutionSignalEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f29691b = FieldDescriptor.of("name");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f29692c = FieldDescriptor.of("code");

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f29693d = FieldDescriptor.of(IMAPStore.ID_ADDRESS);

        private CrashlyticsReportSessionEventApplicationExecutionSignalEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* renamed from: a */
        public void encode(CrashlyticsReport.Session.Event.Application.Execution.Signal signal, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(f29691b, signal.getName());
            objectEncoderContext.add(f29692c, signal.getCode());
            objectEncoderContext.add(f29693d, signal.getAddress());
        }
    }

    /* loaded from: classes5.dex */
    private static final class CrashlyticsReportSessionEventApplicationExecutionThreadEncoder implements ObjectEncoder<CrashlyticsReport.Session.Event.Application.Execution.Thread> {

        /* renamed from: a  reason: collision with root package name */
        static final CrashlyticsReportSessionEventApplicationExecutionThreadEncoder f29694a = new CrashlyticsReportSessionEventApplicationExecutionThreadEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f29695b = FieldDescriptor.of("name");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f29696c = FieldDescriptor.of("importance");

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f29697d = FieldDescriptor.of("frames");

        private CrashlyticsReportSessionEventApplicationExecutionThreadEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* renamed from: a */
        public void encode(CrashlyticsReport.Session.Event.Application.Execution.Thread thread, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(f29695b, thread.getName());
            objectEncoderContext.add(f29696c, thread.getImportance());
            objectEncoderContext.add(f29697d, thread.getFrames());
        }
    }

    /* loaded from: classes5.dex */
    private static final class CrashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder implements ObjectEncoder<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> {

        /* renamed from: a  reason: collision with root package name */
        static final CrashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder f29698a = new CrashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f29699b = FieldDescriptor.of("pc");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f29700c = FieldDescriptor.of("symbol");

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f29701d = FieldDescriptor.of("file");

        /* renamed from: e  reason: collision with root package name */
        private static final FieldDescriptor f29702e = FieldDescriptor.of(TypedValues.CycleType.S_WAVE_OFFSET);

        /* renamed from: f  reason: collision with root package name */
        private static final FieldDescriptor f29703f = FieldDescriptor.of("importance");

        private CrashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* renamed from: a */
        public void encode(CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame frame, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(f29699b, frame.getPc());
            objectEncoderContext.add(f29700c, frame.getSymbol());
            objectEncoderContext.add(f29701d, frame.getFile());
            objectEncoderContext.add(f29702e, frame.getOffset());
            objectEncoderContext.add(f29703f, frame.getImportance());
        }
    }

    /* loaded from: classes5.dex */
    private static final class CrashlyticsReportSessionEventDeviceEncoder implements ObjectEncoder<CrashlyticsReport.Session.Event.Device> {

        /* renamed from: a  reason: collision with root package name */
        static final CrashlyticsReportSessionEventDeviceEncoder f29704a = new CrashlyticsReportSessionEventDeviceEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f29705b = FieldDescriptor.of("batteryLevel");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f29706c = FieldDescriptor.of("batteryVelocity");

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f29707d = FieldDescriptor.of("proximityOn");

        /* renamed from: e  reason: collision with root package name */
        private static final FieldDescriptor f29708e = FieldDescriptor.of("orientation");

        /* renamed from: f  reason: collision with root package name */
        private static final FieldDescriptor f29709f = FieldDescriptor.of("ramUsed");

        /* renamed from: g  reason: collision with root package name */
        private static final FieldDescriptor f29710g = FieldDescriptor.of("diskUsed");

        private CrashlyticsReportSessionEventDeviceEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* renamed from: a */
        public void encode(CrashlyticsReport.Session.Event.Device device, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(f29705b, device.getBatteryLevel());
            objectEncoderContext.add(f29706c, device.getBatteryVelocity());
            objectEncoderContext.add(f29707d, device.isProximityOn());
            objectEncoderContext.add(f29708e, device.getOrientation());
            objectEncoderContext.add(f29709f, device.getRamUsed());
            objectEncoderContext.add(f29710g, device.getDiskUsed());
        }
    }

    /* loaded from: classes5.dex */
    private static final class CrashlyticsReportSessionEventEncoder implements ObjectEncoder<CrashlyticsReport.Session.Event> {

        /* renamed from: a  reason: collision with root package name */
        static final CrashlyticsReportSessionEventEncoder f29711a = new CrashlyticsReportSessionEventEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f29712b = FieldDescriptor.of("timestamp");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f29713c = FieldDescriptor.of("type");

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f29714d = FieldDescriptor.of("app");

        /* renamed from: e  reason: collision with root package name */
        private static final FieldDescriptor f29715e = FieldDescriptor.of("device");

        /* renamed from: f  reason: collision with root package name */
        private static final FieldDescriptor f29716f = FieldDescriptor.of("log");

        private CrashlyticsReportSessionEventEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* renamed from: a */
        public void encode(CrashlyticsReport.Session.Event event, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(f29712b, event.getTimestamp());
            objectEncoderContext.add(f29713c, event.getType());
            objectEncoderContext.add(f29714d, event.getApp());
            objectEncoderContext.add(f29715e, event.getDevice());
            objectEncoderContext.add(f29716f, event.getLog());
        }
    }

    /* loaded from: classes5.dex */
    private static final class CrashlyticsReportSessionEventLogEncoder implements ObjectEncoder<CrashlyticsReport.Session.Event.Log> {

        /* renamed from: a  reason: collision with root package name */
        static final CrashlyticsReportSessionEventLogEncoder f29717a = new CrashlyticsReportSessionEventLogEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f29718b = FieldDescriptor.of(FirebaseAnalytics.Param.CONTENT);

        private CrashlyticsReportSessionEventLogEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* renamed from: a */
        public void encode(CrashlyticsReport.Session.Event.Log log, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(f29718b, log.getContent());
        }
    }

    /* loaded from: classes5.dex */
    private static final class CrashlyticsReportSessionOperatingSystemEncoder implements ObjectEncoder<CrashlyticsReport.Session.OperatingSystem> {

        /* renamed from: a  reason: collision with root package name */
        static final CrashlyticsReportSessionOperatingSystemEncoder f29719a = new CrashlyticsReportSessionOperatingSystemEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f29720b = FieldDescriptor.of("platform");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f29721c = FieldDescriptor.of("version");

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f29722d = FieldDescriptor.of("buildVersion");

        /* renamed from: e  reason: collision with root package name */
        private static final FieldDescriptor f29723e = FieldDescriptor.of("jailbroken");

        private CrashlyticsReportSessionOperatingSystemEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* renamed from: a */
        public void encode(CrashlyticsReport.Session.OperatingSystem operatingSystem, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(f29720b, operatingSystem.getPlatform());
            objectEncoderContext.add(f29721c, operatingSystem.getVersion());
            objectEncoderContext.add(f29722d, operatingSystem.getBuildVersion());
            objectEncoderContext.add(f29723e, operatingSystem.isJailbroken());
        }
    }

    /* loaded from: classes5.dex */
    private static final class CrashlyticsReportSessionUserEncoder implements ObjectEncoder<CrashlyticsReport.Session.User> {

        /* renamed from: a  reason: collision with root package name */
        static final CrashlyticsReportSessionUserEncoder f29724a = new CrashlyticsReportSessionUserEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f29725b = FieldDescriptor.of("identifier");

        private CrashlyticsReportSessionUserEncoder() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder
        /* renamed from: a */
        public void encode(CrashlyticsReport.Session.User user, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(f29725b, user.getIdentifier());
        }
    }

    private AutoCrashlyticsReportEncoder() {
    }

    @Override // com.google.firebase.encoders.config.Configurator
    public void configure(EncoderConfig<?> encoderConfig) {
        CrashlyticsReportEncoder crashlyticsReportEncoder = CrashlyticsReportEncoder.f29617a;
        encoderConfig.registerEncoder(CrashlyticsReport.class, crashlyticsReportEncoder);
        encoderConfig.registerEncoder(AutoValue_CrashlyticsReport.class, crashlyticsReportEncoder);
        CrashlyticsReportSessionEncoder crashlyticsReportSessionEncoder = CrashlyticsReportSessionEncoder.f29654a;
        encoderConfig.registerEncoder(CrashlyticsReport.Session.class, crashlyticsReportSessionEncoder);
        encoderConfig.registerEncoder(AutoValue_CrashlyticsReport_Session.class, crashlyticsReportSessionEncoder);
        CrashlyticsReportSessionApplicationEncoder crashlyticsReportSessionApplicationEncoder = CrashlyticsReportSessionApplicationEncoder.f29634a;
        encoderConfig.registerEncoder(CrashlyticsReport.Session.Application.class, crashlyticsReportSessionApplicationEncoder);
        encoderConfig.registerEncoder(AutoValue_CrashlyticsReport_Session_Application.class, crashlyticsReportSessionApplicationEncoder);
        CrashlyticsReportSessionApplicationOrganizationEncoder crashlyticsReportSessionApplicationOrganizationEncoder = CrashlyticsReportSessionApplicationOrganizationEncoder.f29642a;
        encoderConfig.registerEncoder(CrashlyticsReport.Session.Application.Organization.class, crashlyticsReportSessionApplicationOrganizationEncoder);
        encoderConfig.registerEncoder(AutoValue_CrashlyticsReport_Session_Application_Organization.class, crashlyticsReportSessionApplicationOrganizationEncoder);
        CrashlyticsReportSessionUserEncoder crashlyticsReportSessionUserEncoder = CrashlyticsReportSessionUserEncoder.f29724a;
        encoderConfig.registerEncoder(CrashlyticsReport.Session.User.class, crashlyticsReportSessionUserEncoder);
        encoderConfig.registerEncoder(AutoValue_CrashlyticsReport_Session_User.class, crashlyticsReportSessionUserEncoder);
        CrashlyticsReportSessionOperatingSystemEncoder crashlyticsReportSessionOperatingSystemEncoder = CrashlyticsReportSessionOperatingSystemEncoder.f29719a;
        encoderConfig.registerEncoder(CrashlyticsReport.Session.OperatingSystem.class, crashlyticsReportSessionOperatingSystemEncoder);
        encoderConfig.registerEncoder(AutoValue_CrashlyticsReport_Session_OperatingSystem.class, crashlyticsReportSessionOperatingSystemEncoder);
        CrashlyticsReportSessionDeviceEncoder crashlyticsReportSessionDeviceEncoder = CrashlyticsReportSessionDeviceEncoder.f29644a;
        encoderConfig.registerEncoder(CrashlyticsReport.Session.Device.class, crashlyticsReportSessionDeviceEncoder);
        encoderConfig.registerEncoder(AutoValue_CrashlyticsReport_Session_Device.class, crashlyticsReportSessionDeviceEncoder);
        CrashlyticsReportSessionEventEncoder crashlyticsReportSessionEventEncoder = CrashlyticsReportSessionEventEncoder.f29711a;
        encoderConfig.registerEncoder(CrashlyticsReport.Session.Event.class, crashlyticsReportSessionEventEncoder);
        encoderConfig.registerEncoder(AutoValue_CrashlyticsReport_Session_Event.class, crashlyticsReportSessionEventEncoder);
        CrashlyticsReportSessionEventApplicationEncoder crashlyticsReportSessionEventApplicationEncoder = CrashlyticsReportSessionEventApplicationEncoder.f29667a;
        encoderConfig.registerEncoder(CrashlyticsReport.Session.Event.Application.class, crashlyticsReportSessionEventApplicationEncoder);
        encoderConfig.registerEncoder(AutoValue_CrashlyticsReport_Session_Event_Application.class, crashlyticsReportSessionEventApplicationEncoder);
        CrashlyticsReportSessionEventApplicationExecutionEncoder crashlyticsReportSessionEventApplicationExecutionEncoder = CrashlyticsReportSessionEventApplicationExecutionEncoder.f29678a;
        encoderConfig.registerEncoder(CrashlyticsReport.Session.Event.Application.Execution.class, crashlyticsReportSessionEventApplicationExecutionEncoder);
        encoderConfig.registerEncoder(AutoValue_CrashlyticsReport_Session_Event_Application_Execution.class, crashlyticsReportSessionEventApplicationExecutionEncoder);
        CrashlyticsReportSessionEventApplicationExecutionThreadEncoder crashlyticsReportSessionEventApplicationExecutionThreadEncoder = CrashlyticsReportSessionEventApplicationExecutionThreadEncoder.f29694a;
        encoderConfig.registerEncoder(CrashlyticsReport.Session.Event.Application.Execution.Thread.class, crashlyticsReportSessionEventApplicationExecutionThreadEncoder);
        encoderConfig.registerEncoder(AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread.class, crashlyticsReportSessionEventApplicationExecutionThreadEncoder);
        CrashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder crashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder = CrashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder.f29698a;
        encoderConfig.registerEncoder(CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.class, crashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder);
        encoderConfig.registerEncoder(AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame.class, crashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder);
        CrashlyticsReportSessionEventApplicationExecutionExceptionEncoder crashlyticsReportSessionEventApplicationExecutionExceptionEncoder = CrashlyticsReportSessionEventApplicationExecutionExceptionEncoder.f29684a;
        encoderConfig.registerEncoder(CrashlyticsReport.Session.Event.Application.Execution.Exception.class, crashlyticsReportSessionEventApplicationExecutionExceptionEncoder);
        encoderConfig.registerEncoder(AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception.class, crashlyticsReportSessionEventApplicationExecutionExceptionEncoder);
        CrashlyticsReportApplicationExitInfoEncoder crashlyticsReportApplicationExitInfoEncoder = CrashlyticsReportApplicationExitInfoEncoder.f29604a;
        encoderConfig.registerEncoder(CrashlyticsReport.ApplicationExitInfo.class, crashlyticsReportApplicationExitInfoEncoder);
        encoderConfig.registerEncoder(AutoValue_CrashlyticsReport_ApplicationExitInfo.class, crashlyticsReportApplicationExitInfoEncoder);
        CrashlyticsReportApplicationExitInfoBuildIdMappingForArchEncoder crashlyticsReportApplicationExitInfoBuildIdMappingForArchEncoder = CrashlyticsReportApplicationExitInfoBuildIdMappingForArchEncoder.f29600a;
        encoderConfig.registerEncoder(CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch.class, crashlyticsReportApplicationExitInfoBuildIdMappingForArchEncoder);
        encoderConfig.registerEncoder(AutoValue_CrashlyticsReport_ApplicationExitInfo_BuildIdMappingForArch.class, crashlyticsReportApplicationExitInfoBuildIdMappingForArchEncoder);
        CrashlyticsReportSessionEventApplicationExecutionSignalEncoder crashlyticsReportSessionEventApplicationExecutionSignalEncoder = CrashlyticsReportSessionEventApplicationExecutionSignalEncoder.f29690a;
        encoderConfig.registerEncoder(CrashlyticsReport.Session.Event.Application.Execution.Signal.class, crashlyticsReportSessionEventApplicationExecutionSignalEncoder);
        encoderConfig.registerEncoder(AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal.class, crashlyticsReportSessionEventApplicationExecutionSignalEncoder);
        CrashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder crashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder = CrashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder.f29673a;
        encoderConfig.registerEncoder(CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.class, crashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder);
        encoderConfig.registerEncoder(AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage.class, crashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder);
        CrashlyticsReportCustomAttributeEncoder crashlyticsReportCustomAttributeEncoder = CrashlyticsReportCustomAttributeEncoder.f29614a;
        encoderConfig.registerEncoder(CrashlyticsReport.CustomAttribute.class, crashlyticsReportCustomAttributeEncoder);
        encoderConfig.registerEncoder(AutoValue_CrashlyticsReport_CustomAttribute.class, crashlyticsReportCustomAttributeEncoder);
        CrashlyticsReportSessionEventDeviceEncoder crashlyticsReportSessionEventDeviceEncoder = CrashlyticsReportSessionEventDeviceEncoder.f29704a;
        encoderConfig.registerEncoder(CrashlyticsReport.Session.Event.Device.class, crashlyticsReportSessionEventDeviceEncoder);
        encoderConfig.registerEncoder(AutoValue_CrashlyticsReport_Session_Event_Device.class, crashlyticsReportSessionEventDeviceEncoder);
        CrashlyticsReportSessionEventLogEncoder crashlyticsReportSessionEventLogEncoder = CrashlyticsReportSessionEventLogEncoder.f29717a;
        encoderConfig.registerEncoder(CrashlyticsReport.Session.Event.Log.class, crashlyticsReportSessionEventLogEncoder);
        encoderConfig.registerEncoder(AutoValue_CrashlyticsReport_Session_Event_Log.class, crashlyticsReportSessionEventLogEncoder);
        CrashlyticsReportFilesPayloadEncoder crashlyticsReportFilesPayloadEncoder = CrashlyticsReportFilesPayloadEncoder.f29628a;
        encoderConfig.registerEncoder(CrashlyticsReport.FilesPayload.class, crashlyticsReportFilesPayloadEncoder);
        encoderConfig.registerEncoder(AutoValue_CrashlyticsReport_FilesPayload.class, crashlyticsReportFilesPayloadEncoder);
        CrashlyticsReportFilesPayloadFileEncoder crashlyticsReportFilesPayloadFileEncoder = CrashlyticsReportFilesPayloadFileEncoder.f29631a;
        encoderConfig.registerEncoder(CrashlyticsReport.FilesPayload.File.class, crashlyticsReportFilesPayloadFileEncoder);
        encoderConfig.registerEncoder(AutoValue_CrashlyticsReport_FilesPayload_File.class, crashlyticsReportFilesPayloadFileEncoder);
    }
}
