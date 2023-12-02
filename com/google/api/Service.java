package com.google.api;

import com.google.api.Authentication;
import com.google.api.Backend;
import com.google.api.Billing;
import com.google.api.Context;
import com.google.api.Control;
import com.google.api.Documentation;
import com.google.api.Endpoint;
import com.google.api.Http;
import com.google.api.LogDescriptor;
import com.google.api.Logging;
import com.google.api.MetricDescriptor;
import com.google.api.MonitoredResourceDescriptor;
import com.google.api.Monitoring;
import com.google.api.Quota;
import com.google.api.SourceInfo;
import com.google.api.SystemParameters;
import com.google.api.Usage;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.Api;
import com.google.protobuf.ApiOrBuilder;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Enum;
import com.google.protobuf.EnumOrBuilder;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.google.protobuf.Type;
import com.google.protobuf.TypeOrBuilder;
import com.google.protobuf.UInt32Value;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: classes5.dex */
public final class Service extends GeneratedMessageLite<Service, Builder> implements ServiceOrBuilder {
    public static final int APIS_FIELD_NUMBER = 3;
    public static final int AUTHENTICATION_FIELD_NUMBER = 11;
    public static final int BACKEND_FIELD_NUMBER = 8;
    public static final int BILLING_FIELD_NUMBER = 26;
    public static final int CONFIG_VERSION_FIELD_NUMBER = 20;
    public static final int CONTEXT_FIELD_NUMBER = 12;
    public static final int CONTROL_FIELD_NUMBER = 21;
    private static final Service DEFAULT_INSTANCE;
    public static final int DOCUMENTATION_FIELD_NUMBER = 6;
    public static final int ENDPOINTS_FIELD_NUMBER = 18;
    public static final int ENUMS_FIELD_NUMBER = 5;
    public static final int HTTP_FIELD_NUMBER = 9;
    public static final int ID_FIELD_NUMBER = 33;
    public static final int LOGGING_FIELD_NUMBER = 27;
    public static final int LOGS_FIELD_NUMBER = 23;
    public static final int METRICS_FIELD_NUMBER = 24;
    public static final int MONITORED_RESOURCES_FIELD_NUMBER = 25;
    public static final int MONITORING_FIELD_NUMBER = 28;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile Parser<Service> PARSER = null;
    public static final int PRODUCER_PROJECT_ID_FIELD_NUMBER = 22;
    public static final int QUOTA_FIELD_NUMBER = 10;
    public static final int SOURCE_INFO_FIELD_NUMBER = 37;
    public static final int SYSTEM_PARAMETERS_FIELD_NUMBER = 29;
    public static final int TITLE_FIELD_NUMBER = 2;
    public static final int TYPES_FIELD_NUMBER = 4;
    public static final int USAGE_FIELD_NUMBER = 15;
    private Authentication authentication_;
    private Backend backend_;
    private Billing billing_;
    private UInt32Value configVersion_;
    private Context context_;
    private Control control_;
    private Documentation documentation_;
    private Http http_;
    private Logging logging_;
    private Monitoring monitoring_;
    private Quota quota_;
    private SourceInfo sourceInfo_;
    private SystemParameters systemParameters_;
    private Usage usage_;
    private String name_ = "";
    private String id_ = "";
    private String title_ = "";
    private String producerProjectId_ = "";
    private Internal.ProtobufList<Api> apis_ = GeneratedMessageLite.y();
    private Internal.ProtobufList<Type> types_ = GeneratedMessageLite.y();
    private Internal.ProtobufList<Enum> enums_ = GeneratedMessageLite.y();
    private Internal.ProtobufList<Endpoint> endpoints_ = GeneratedMessageLite.y();
    private Internal.ProtobufList<LogDescriptor> logs_ = GeneratedMessageLite.y();
    private Internal.ProtobufList<MetricDescriptor> metrics_ = GeneratedMessageLite.y();
    private Internal.ProtobufList<MonitoredResourceDescriptor> monitoredResources_ = GeneratedMessageLite.y();

    /* renamed from: com.google.api.Service$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f25457a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f25457a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f25457a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f25457a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f25457a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f25457a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f25457a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f25457a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<Service, Builder> implements ServiceOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllApis(Iterable<? extends Api> iterable) {
            f();
            ((Service) this.f33398b).Y1(iterable);
            return this;
        }

        public Builder addAllEndpoints(Iterable<? extends Endpoint> iterable) {
            f();
            ((Service) this.f33398b).Z1(iterable);
            return this;
        }

        public Builder addAllEnums(Iterable<? extends Enum> iterable) {
            f();
            ((Service) this.f33398b).a2(iterable);
            return this;
        }

        public Builder addAllLogs(Iterable<? extends LogDescriptor> iterable) {
            f();
            ((Service) this.f33398b).b2(iterable);
            return this;
        }

        public Builder addAllMetrics(Iterable<? extends MetricDescriptor> iterable) {
            f();
            ((Service) this.f33398b).c2(iterable);
            return this;
        }

        public Builder addAllMonitoredResources(Iterable<? extends MonitoredResourceDescriptor> iterable) {
            f();
            ((Service) this.f33398b).d2(iterable);
            return this;
        }

        public Builder addAllTypes(Iterable<? extends Type> iterable) {
            f();
            ((Service) this.f33398b).e2(iterable);
            return this;
        }

        public Builder addApis(Api api) {
            f();
            ((Service) this.f33398b).g2(api);
            return this;
        }

        public Builder addEndpoints(Endpoint endpoint) {
            f();
            ((Service) this.f33398b).i2(endpoint);
            return this;
        }

        public Builder addEnums(Enum r22) {
            f();
            ((Service) this.f33398b).k2(r22);
            return this;
        }

        public Builder addLogs(LogDescriptor logDescriptor) {
            f();
            ((Service) this.f33398b).m2(logDescriptor);
            return this;
        }

        public Builder addMetrics(MetricDescriptor metricDescriptor) {
            f();
            ((Service) this.f33398b).o2(metricDescriptor);
            return this;
        }

        public Builder addMonitoredResources(MonitoredResourceDescriptor monitoredResourceDescriptor) {
            f();
            ((Service) this.f33398b).q2(monitoredResourceDescriptor);
            return this;
        }

        public Builder addTypes(Type type) {
            f();
            ((Service) this.f33398b).s2(type);
            return this;
        }

        public Builder clearApis() {
            f();
            ((Service) this.f33398b).t2();
            return this;
        }

        public Builder clearAuthentication() {
            f();
            ((Service) this.f33398b).u2();
            return this;
        }

        public Builder clearBackend() {
            f();
            ((Service) this.f33398b).v2();
            return this;
        }

        public Builder clearBilling() {
            f();
            ((Service) this.f33398b).w2();
            return this;
        }

        public Builder clearConfigVersion() {
            f();
            ((Service) this.f33398b).x2();
            return this;
        }

        public Builder clearContext() {
            f();
            ((Service) this.f33398b).y2();
            return this;
        }

        public Builder clearControl() {
            f();
            ((Service) this.f33398b).z2();
            return this;
        }

        public Builder clearDocumentation() {
            f();
            ((Service) this.f33398b).A2();
            return this;
        }

        public Builder clearEndpoints() {
            f();
            ((Service) this.f33398b).B2();
            return this;
        }

        public Builder clearEnums() {
            f();
            ((Service) this.f33398b).C2();
            return this;
        }

        public Builder clearHttp() {
            f();
            ((Service) this.f33398b).D2();
            return this;
        }

        public Builder clearId() {
            f();
            ((Service) this.f33398b).E2();
            return this;
        }

        public Builder clearLogging() {
            f();
            ((Service) this.f33398b).F2();
            return this;
        }

        public Builder clearLogs() {
            f();
            ((Service) this.f33398b).G2();
            return this;
        }

        public Builder clearMetrics() {
            f();
            ((Service) this.f33398b).H2();
            return this;
        }

        public Builder clearMonitoredResources() {
            f();
            ((Service) this.f33398b).I2();
            return this;
        }

        public Builder clearMonitoring() {
            f();
            ((Service) this.f33398b).J2();
            return this;
        }

        public Builder clearName() {
            f();
            ((Service) this.f33398b).K2();
            return this;
        }

        public Builder clearProducerProjectId() {
            f();
            ((Service) this.f33398b).L2();
            return this;
        }

        public Builder clearQuota() {
            f();
            ((Service) this.f33398b).M2();
            return this;
        }

        public Builder clearSourceInfo() {
            f();
            ((Service) this.f33398b).N2();
            return this;
        }

        public Builder clearSystemParameters() {
            f();
            ((Service) this.f33398b).O2();
            return this;
        }

        public Builder clearTitle() {
            f();
            ((Service) this.f33398b).P2();
            return this;
        }

        public Builder clearTypes() {
            f();
            ((Service) this.f33398b).Q2();
            return this;
        }

        public Builder clearUsage() {
            f();
            ((Service) this.f33398b).R2();
            return this;
        }

        @Override // com.google.api.ServiceOrBuilder
        public Api getApis(int i4) {
            return ((Service) this.f33398b).getApis(i4);
        }

        @Override // com.google.api.ServiceOrBuilder
        public int getApisCount() {
            return ((Service) this.f33398b).getApisCount();
        }

        @Override // com.google.api.ServiceOrBuilder
        public List<Api> getApisList() {
            return Collections.unmodifiableList(((Service) this.f33398b).getApisList());
        }

        @Override // com.google.api.ServiceOrBuilder
        public Authentication getAuthentication() {
            return ((Service) this.f33398b).getAuthentication();
        }

        @Override // com.google.api.ServiceOrBuilder
        public Backend getBackend() {
            return ((Service) this.f33398b).getBackend();
        }

        @Override // com.google.api.ServiceOrBuilder
        public Billing getBilling() {
            return ((Service) this.f33398b).getBilling();
        }

        @Override // com.google.api.ServiceOrBuilder
        public UInt32Value getConfigVersion() {
            return ((Service) this.f33398b).getConfigVersion();
        }

        @Override // com.google.api.ServiceOrBuilder
        public Context getContext() {
            return ((Service) this.f33398b).getContext();
        }

        @Override // com.google.api.ServiceOrBuilder
        public Control getControl() {
            return ((Service) this.f33398b).getControl();
        }

        @Override // com.google.api.ServiceOrBuilder
        public Documentation getDocumentation() {
            return ((Service) this.f33398b).getDocumentation();
        }

        @Override // com.google.api.ServiceOrBuilder
        public Endpoint getEndpoints(int i4) {
            return ((Service) this.f33398b).getEndpoints(i4);
        }

        @Override // com.google.api.ServiceOrBuilder
        public int getEndpointsCount() {
            return ((Service) this.f33398b).getEndpointsCount();
        }

        @Override // com.google.api.ServiceOrBuilder
        public List<Endpoint> getEndpointsList() {
            return Collections.unmodifiableList(((Service) this.f33398b).getEndpointsList());
        }

        @Override // com.google.api.ServiceOrBuilder
        public Enum getEnums(int i4) {
            return ((Service) this.f33398b).getEnums(i4);
        }

        @Override // com.google.api.ServiceOrBuilder
        public int getEnumsCount() {
            return ((Service) this.f33398b).getEnumsCount();
        }

        @Override // com.google.api.ServiceOrBuilder
        public List<Enum> getEnumsList() {
            return Collections.unmodifiableList(((Service) this.f33398b).getEnumsList());
        }

        @Override // com.google.api.ServiceOrBuilder
        public Http getHttp() {
            return ((Service) this.f33398b).getHttp();
        }

        @Override // com.google.api.ServiceOrBuilder
        public String getId() {
            return ((Service) this.f33398b).getId();
        }

        @Override // com.google.api.ServiceOrBuilder
        public ByteString getIdBytes() {
            return ((Service) this.f33398b).getIdBytes();
        }

        @Override // com.google.api.ServiceOrBuilder
        public Logging getLogging() {
            return ((Service) this.f33398b).getLogging();
        }

        @Override // com.google.api.ServiceOrBuilder
        public LogDescriptor getLogs(int i4) {
            return ((Service) this.f33398b).getLogs(i4);
        }

        @Override // com.google.api.ServiceOrBuilder
        public int getLogsCount() {
            return ((Service) this.f33398b).getLogsCount();
        }

        @Override // com.google.api.ServiceOrBuilder
        public List<LogDescriptor> getLogsList() {
            return Collections.unmodifiableList(((Service) this.f33398b).getLogsList());
        }

        @Override // com.google.api.ServiceOrBuilder
        public MetricDescriptor getMetrics(int i4) {
            return ((Service) this.f33398b).getMetrics(i4);
        }

        @Override // com.google.api.ServiceOrBuilder
        public int getMetricsCount() {
            return ((Service) this.f33398b).getMetricsCount();
        }

        @Override // com.google.api.ServiceOrBuilder
        public List<MetricDescriptor> getMetricsList() {
            return Collections.unmodifiableList(((Service) this.f33398b).getMetricsList());
        }

        @Override // com.google.api.ServiceOrBuilder
        public MonitoredResourceDescriptor getMonitoredResources(int i4) {
            return ((Service) this.f33398b).getMonitoredResources(i4);
        }

        @Override // com.google.api.ServiceOrBuilder
        public int getMonitoredResourcesCount() {
            return ((Service) this.f33398b).getMonitoredResourcesCount();
        }

        @Override // com.google.api.ServiceOrBuilder
        public List<MonitoredResourceDescriptor> getMonitoredResourcesList() {
            return Collections.unmodifiableList(((Service) this.f33398b).getMonitoredResourcesList());
        }

        @Override // com.google.api.ServiceOrBuilder
        public Monitoring getMonitoring() {
            return ((Service) this.f33398b).getMonitoring();
        }

        @Override // com.google.api.ServiceOrBuilder
        public String getName() {
            return ((Service) this.f33398b).getName();
        }

        @Override // com.google.api.ServiceOrBuilder
        public ByteString getNameBytes() {
            return ((Service) this.f33398b).getNameBytes();
        }

        @Override // com.google.api.ServiceOrBuilder
        public String getProducerProjectId() {
            return ((Service) this.f33398b).getProducerProjectId();
        }

        @Override // com.google.api.ServiceOrBuilder
        public ByteString getProducerProjectIdBytes() {
            return ((Service) this.f33398b).getProducerProjectIdBytes();
        }

        @Override // com.google.api.ServiceOrBuilder
        public Quota getQuota() {
            return ((Service) this.f33398b).getQuota();
        }

        @Override // com.google.api.ServiceOrBuilder
        public SourceInfo getSourceInfo() {
            return ((Service) this.f33398b).getSourceInfo();
        }

        @Override // com.google.api.ServiceOrBuilder
        public SystemParameters getSystemParameters() {
            return ((Service) this.f33398b).getSystemParameters();
        }

        @Override // com.google.api.ServiceOrBuilder
        public String getTitle() {
            return ((Service) this.f33398b).getTitle();
        }

        @Override // com.google.api.ServiceOrBuilder
        public ByteString getTitleBytes() {
            return ((Service) this.f33398b).getTitleBytes();
        }

        @Override // com.google.api.ServiceOrBuilder
        public Type getTypes(int i4) {
            return ((Service) this.f33398b).getTypes(i4);
        }

        @Override // com.google.api.ServiceOrBuilder
        public int getTypesCount() {
            return ((Service) this.f33398b).getTypesCount();
        }

        @Override // com.google.api.ServiceOrBuilder
        public List<Type> getTypesList() {
            return Collections.unmodifiableList(((Service) this.f33398b).getTypesList());
        }

        @Override // com.google.api.ServiceOrBuilder
        public Usage getUsage() {
            return ((Service) this.f33398b).getUsage();
        }

        @Override // com.google.api.ServiceOrBuilder
        public boolean hasAuthentication() {
            return ((Service) this.f33398b).hasAuthentication();
        }

        @Override // com.google.api.ServiceOrBuilder
        public boolean hasBackend() {
            return ((Service) this.f33398b).hasBackend();
        }

        @Override // com.google.api.ServiceOrBuilder
        public boolean hasBilling() {
            return ((Service) this.f33398b).hasBilling();
        }

        @Override // com.google.api.ServiceOrBuilder
        public boolean hasConfigVersion() {
            return ((Service) this.f33398b).hasConfigVersion();
        }

        @Override // com.google.api.ServiceOrBuilder
        public boolean hasContext() {
            return ((Service) this.f33398b).hasContext();
        }

        @Override // com.google.api.ServiceOrBuilder
        public boolean hasControl() {
            return ((Service) this.f33398b).hasControl();
        }

        @Override // com.google.api.ServiceOrBuilder
        public boolean hasDocumentation() {
            return ((Service) this.f33398b).hasDocumentation();
        }

        @Override // com.google.api.ServiceOrBuilder
        public boolean hasHttp() {
            return ((Service) this.f33398b).hasHttp();
        }

        @Override // com.google.api.ServiceOrBuilder
        public boolean hasLogging() {
            return ((Service) this.f33398b).hasLogging();
        }

        @Override // com.google.api.ServiceOrBuilder
        public boolean hasMonitoring() {
            return ((Service) this.f33398b).hasMonitoring();
        }

        @Override // com.google.api.ServiceOrBuilder
        public boolean hasQuota() {
            return ((Service) this.f33398b).hasQuota();
        }

        @Override // com.google.api.ServiceOrBuilder
        public boolean hasSourceInfo() {
            return ((Service) this.f33398b).hasSourceInfo();
        }

        @Override // com.google.api.ServiceOrBuilder
        public boolean hasSystemParameters() {
            return ((Service) this.f33398b).hasSystemParameters();
        }

        @Override // com.google.api.ServiceOrBuilder
        public boolean hasUsage() {
            return ((Service) this.f33398b).hasUsage();
        }

        public Builder mergeAuthentication(Authentication authentication) {
            f();
            ((Service) this.f33398b).Z2(authentication);
            return this;
        }

        public Builder mergeBackend(Backend backend) {
            f();
            ((Service) this.f33398b).a3(backend);
            return this;
        }

        public Builder mergeBilling(Billing billing) {
            f();
            ((Service) this.f33398b).b3(billing);
            return this;
        }

        public Builder mergeConfigVersion(UInt32Value uInt32Value) {
            f();
            ((Service) this.f33398b).c3(uInt32Value);
            return this;
        }

        public Builder mergeContext(Context context) {
            f();
            ((Service) this.f33398b).d3(context);
            return this;
        }

        public Builder mergeControl(Control control) {
            f();
            ((Service) this.f33398b).e3(control);
            return this;
        }

        public Builder mergeDocumentation(Documentation documentation) {
            f();
            ((Service) this.f33398b).f3(documentation);
            return this;
        }

        public Builder mergeHttp(Http http) {
            f();
            ((Service) this.f33398b).g3(http);
            return this;
        }

        public Builder mergeLogging(Logging logging) {
            f();
            ((Service) this.f33398b).h3(logging);
            return this;
        }

        public Builder mergeMonitoring(Monitoring monitoring) {
            f();
            ((Service) this.f33398b).i3(monitoring);
            return this;
        }

        public Builder mergeQuota(Quota quota) {
            f();
            ((Service) this.f33398b).j3(quota);
            return this;
        }

        public Builder mergeSourceInfo(SourceInfo sourceInfo) {
            f();
            ((Service) this.f33398b).k3(sourceInfo);
            return this;
        }

        public Builder mergeSystemParameters(SystemParameters systemParameters) {
            f();
            ((Service) this.f33398b).l3(systemParameters);
            return this;
        }

        public Builder mergeUsage(Usage usage) {
            f();
            ((Service) this.f33398b).m3(usage);
            return this;
        }

        public Builder removeApis(int i4) {
            f();
            ((Service) this.f33398b).n3(i4);
            return this;
        }

        public Builder removeEndpoints(int i4) {
            f();
            ((Service) this.f33398b).o3(i4);
            return this;
        }

        public Builder removeEnums(int i4) {
            f();
            ((Service) this.f33398b).p3(i4);
            return this;
        }

        public Builder removeLogs(int i4) {
            f();
            ((Service) this.f33398b).q3(i4);
            return this;
        }

        public Builder removeMetrics(int i4) {
            f();
            ((Service) this.f33398b).r3(i4);
            return this;
        }

        public Builder removeMonitoredResources(int i4) {
            f();
            ((Service) this.f33398b).s3(i4);
            return this;
        }

        public Builder removeTypes(int i4) {
            f();
            ((Service) this.f33398b).t3(i4);
            return this;
        }

        public Builder setApis(int i4, Api api) {
            f();
            ((Service) this.f33398b).u3(i4, api);
            return this;
        }

        public Builder setAuthentication(Authentication authentication) {
            f();
            ((Service) this.f33398b).v3(authentication);
            return this;
        }

        public Builder setBackend(Backend backend) {
            f();
            ((Service) this.f33398b).w3(backend);
            return this;
        }

        public Builder setBilling(Billing billing) {
            f();
            ((Service) this.f33398b).x3(billing);
            return this;
        }

        public Builder setConfigVersion(UInt32Value uInt32Value) {
            f();
            ((Service) this.f33398b).y3(uInt32Value);
            return this;
        }

        public Builder setContext(Context context) {
            f();
            ((Service) this.f33398b).z3(context);
            return this;
        }

        public Builder setControl(Control control) {
            f();
            ((Service) this.f33398b).A3(control);
            return this;
        }

        public Builder setDocumentation(Documentation documentation) {
            f();
            ((Service) this.f33398b).B3(documentation);
            return this;
        }

        public Builder setEndpoints(int i4, Endpoint endpoint) {
            f();
            ((Service) this.f33398b).C3(i4, endpoint);
            return this;
        }

        public Builder setEnums(int i4, Enum r32) {
            f();
            ((Service) this.f33398b).D3(i4, r32);
            return this;
        }

        public Builder setHttp(Http http) {
            f();
            ((Service) this.f33398b).E3(http);
            return this;
        }

        public Builder setId(String str) {
            f();
            ((Service) this.f33398b).F3(str);
            return this;
        }

        public Builder setIdBytes(ByteString byteString) {
            f();
            ((Service) this.f33398b).G3(byteString);
            return this;
        }

        public Builder setLogging(Logging logging) {
            f();
            ((Service) this.f33398b).H3(logging);
            return this;
        }

        public Builder setLogs(int i4, LogDescriptor logDescriptor) {
            f();
            ((Service) this.f33398b).I3(i4, logDescriptor);
            return this;
        }

        public Builder setMetrics(int i4, MetricDescriptor metricDescriptor) {
            f();
            ((Service) this.f33398b).J3(i4, metricDescriptor);
            return this;
        }

        public Builder setMonitoredResources(int i4, MonitoredResourceDescriptor monitoredResourceDescriptor) {
            f();
            ((Service) this.f33398b).K3(i4, monitoredResourceDescriptor);
            return this;
        }

        public Builder setMonitoring(Monitoring monitoring) {
            f();
            ((Service) this.f33398b).L3(monitoring);
            return this;
        }

        public Builder setName(String str) {
            f();
            ((Service) this.f33398b).M3(str);
            return this;
        }

        public Builder setNameBytes(ByteString byteString) {
            f();
            ((Service) this.f33398b).N3(byteString);
            return this;
        }

        public Builder setProducerProjectId(String str) {
            f();
            ((Service) this.f33398b).O3(str);
            return this;
        }

        public Builder setProducerProjectIdBytes(ByteString byteString) {
            f();
            ((Service) this.f33398b).P3(byteString);
            return this;
        }

        public Builder setQuota(Quota quota) {
            f();
            ((Service) this.f33398b).Q3(quota);
            return this;
        }

        public Builder setSourceInfo(SourceInfo sourceInfo) {
            f();
            ((Service) this.f33398b).R3(sourceInfo);
            return this;
        }

        public Builder setSystemParameters(SystemParameters systemParameters) {
            f();
            ((Service) this.f33398b).S3(systemParameters);
            return this;
        }

        public Builder setTitle(String str) {
            f();
            ((Service) this.f33398b).T3(str);
            return this;
        }

        public Builder setTitleBytes(ByteString byteString) {
            f();
            ((Service) this.f33398b).U3(byteString);
            return this;
        }

        public Builder setTypes(int i4, Type type) {
            f();
            ((Service) this.f33398b).V3(i4, type);
            return this;
        }

        public Builder setUsage(Usage usage) {
            f();
            ((Service) this.f33398b).W3(usage);
            return this;
        }

        private Builder() {
            super(Service.DEFAULT_INSTANCE);
        }

        public Builder addApis(int i4, Api api) {
            f();
            ((Service) this.f33398b).f2(i4, api);
            return this;
        }

        public Builder addEndpoints(int i4, Endpoint endpoint) {
            f();
            ((Service) this.f33398b).h2(i4, endpoint);
            return this;
        }

        public Builder addEnums(int i4, Enum r32) {
            f();
            ((Service) this.f33398b).j2(i4, r32);
            return this;
        }

        public Builder addLogs(int i4, LogDescriptor logDescriptor) {
            f();
            ((Service) this.f33398b).l2(i4, logDescriptor);
            return this;
        }

        public Builder addMetrics(int i4, MetricDescriptor metricDescriptor) {
            f();
            ((Service) this.f33398b).n2(i4, metricDescriptor);
            return this;
        }

        public Builder addMonitoredResources(int i4, MonitoredResourceDescriptor monitoredResourceDescriptor) {
            f();
            ((Service) this.f33398b).p2(i4, monitoredResourceDescriptor);
            return this;
        }

        public Builder addTypes(int i4, Type type) {
            f();
            ((Service) this.f33398b).r2(i4, type);
            return this;
        }

        public Builder setApis(int i4, Api.Builder builder) {
            f();
            ((Service) this.f33398b).u3(i4, builder.build());
            return this;
        }

        public Builder setAuthentication(Authentication.Builder builder) {
            f();
            ((Service) this.f33398b).v3(builder.build());
            return this;
        }

        public Builder setBackend(Backend.Builder builder) {
            f();
            ((Service) this.f33398b).w3(builder.build());
            return this;
        }

        public Builder setBilling(Billing.Builder builder) {
            f();
            ((Service) this.f33398b).x3(builder.build());
            return this;
        }

        public Builder setConfigVersion(UInt32Value.Builder builder) {
            f();
            ((Service) this.f33398b).y3(builder.build());
            return this;
        }

        public Builder setContext(Context.Builder builder) {
            f();
            ((Service) this.f33398b).z3(builder.build());
            return this;
        }

        public Builder setControl(Control.Builder builder) {
            f();
            ((Service) this.f33398b).A3(builder.build());
            return this;
        }

        public Builder setDocumentation(Documentation.Builder builder) {
            f();
            ((Service) this.f33398b).B3(builder.build());
            return this;
        }

        public Builder setEndpoints(int i4, Endpoint.Builder builder) {
            f();
            ((Service) this.f33398b).C3(i4, builder.build());
            return this;
        }

        public Builder setEnums(int i4, Enum.Builder builder) {
            f();
            ((Service) this.f33398b).D3(i4, builder.build());
            return this;
        }

        public Builder setHttp(Http.Builder builder) {
            f();
            ((Service) this.f33398b).E3(builder.build());
            return this;
        }

        public Builder setLogging(Logging.Builder builder) {
            f();
            ((Service) this.f33398b).H3(builder.build());
            return this;
        }

        public Builder setLogs(int i4, LogDescriptor.Builder builder) {
            f();
            ((Service) this.f33398b).I3(i4, builder.build());
            return this;
        }

        public Builder setMetrics(int i4, MetricDescriptor.Builder builder) {
            f();
            ((Service) this.f33398b).J3(i4, builder.build());
            return this;
        }

        public Builder setMonitoredResources(int i4, MonitoredResourceDescriptor.Builder builder) {
            f();
            ((Service) this.f33398b).K3(i4, builder.build());
            return this;
        }

        public Builder setMonitoring(Monitoring.Builder builder) {
            f();
            ((Service) this.f33398b).L3(builder.build());
            return this;
        }

        public Builder setQuota(Quota.Builder builder) {
            f();
            ((Service) this.f33398b).Q3(builder.build());
            return this;
        }

        public Builder setSourceInfo(SourceInfo.Builder builder) {
            f();
            ((Service) this.f33398b).R3(builder.build());
            return this;
        }

        public Builder setSystemParameters(SystemParameters.Builder builder) {
            f();
            ((Service) this.f33398b).S3(builder.build());
            return this;
        }

        public Builder setTypes(int i4, Type.Builder builder) {
            f();
            ((Service) this.f33398b).V3(i4, builder.build());
            return this;
        }

        public Builder setUsage(Usage.Builder builder) {
            f();
            ((Service) this.f33398b).W3(builder.build());
            return this;
        }

        public Builder addApis(Api.Builder builder) {
            f();
            ((Service) this.f33398b).g2(builder.build());
            return this;
        }

        public Builder addEndpoints(Endpoint.Builder builder) {
            f();
            ((Service) this.f33398b).i2(builder.build());
            return this;
        }

        public Builder addEnums(Enum.Builder builder) {
            f();
            ((Service) this.f33398b).k2(builder.build());
            return this;
        }

        public Builder addLogs(LogDescriptor.Builder builder) {
            f();
            ((Service) this.f33398b).m2(builder.build());
            return this;
        }

        public Builder addMetrics(MetricDescriptor.Builder builder) {
            f();
            ((Service) this.f33398b).o2(builder.build());
            return this;
        }

        public Builder addMonitoredResources(MonitoredResourceDescriptor.Builder builder) {
            f();
            ((Service) this.f33398b).q2(builder.build());
            return this;
        }

        public Builder addTypes(Type.Builder builder) {
            f();
            ((Service) this.f33398b).s2(builder.build());
            return this;
        }

        public Builder addApis(int i4, Api.Builder builder) {
            f();
            ((Service) this.f33398b).f2(i4, builder.build());
            return this;
        }

        public Builder addEndpoints(int i4, Endpoint.Builder builder) {
            f();
            ((Service) this.f33398b).h2(i4, builder.build());
            return this;
        }

        public Builder addEnums(int i4, Enum.Builder builder) {
            f();
            ((Service) this.f33398b).j2(i4, builder.build());
            return this;
        }

        public Builder addLogs(int i4, LogDescriptor.Builder builder) {
            f();
            ((Service) this.f33398b).l2(i4, builder.build());
            return this;
        }

        public Builder addMetrics(int i4, MetricDescriptor.Builder builder) {
            f();
            ((Service) this.f33398b).n2(i4, builder.build());
            return this;
        }

        public Builder addMonitoredResources(int i4, MonitoredResourceDescriptor.Builder builder) {
            f();
            ((Service) this.f33398b).p2(i4, builder.build());
            return this;
        }

        public Builder addTypes(int i4, Type.Builder builder) {
            f();
            ((Service) this.f33398b).r2(i4, builder.build());
            return this;
        }
    }

    static {
        Service service = new Service();
        DEFAULT_INSTANCE = service;
        GeneratedMessageLite.d0(Service.class, service);
    }

    private Service() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A2() {
        this.documentation_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A3(Control control) {
        control.getClass();
        this.control_ = control;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B2() {
        this.endpoints_ = GeneratedMessageLite.y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B3(Documentation documentation) {
        documentation.getClass();
        this.documentation_ = documentation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C2() {
        this.enums_ = GeneratedMessageLite.y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C3(int i4, Endpoint endpoint) {
        endpoint.getClass();
        T2();
        this.endpoints_.set(i4, endpoint);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D2() {
        this.http_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D3(int i4, Enum r32) {
        r32.getClass();
        U2();
        this.enums_.set(i4, r32);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E2() {
        this.id_ = getDefaultInstance().getId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E3(Http http) {
        http.getClass();
        this.http_ = http;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F2() {
        this.logging_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F3(String str) {
        str.getClass();
        this.id_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G2() {
        this.logs_ = GeneratedMessageLite.y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G3(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        this.id_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H2() {
        this.metrics_ = GeneratedMessageLite.y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H3(Logging logging) {
        logging.getClass();
        this.logging_ = logging;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I2() {
        this.monitoredResources_ = GeneratedMessageLite.y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I3(int i4, LogDescriptor logDescriptor) {
        logDescriptor.getClass();
        V2();
        this.logs_.set(i4, logDescriptor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J2() {
        this.monitoring_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J3(int i4, MetricDescriptor metricDescriptor) {
        metricDescriptor.getClass();
        W2();
        this.metrics_.set(i4, metricDescriptor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K2() {
        this.name_ = getDefaultInstance().getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K3(int i4, MonitoredResourceDescriptor monitoredResourceDescriptor) {
        monitoredResourceDescriptor.getClass();
        X2();
        this.monitoredResources_.set(i4, monitoredResourceDescriptor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L2() {
        this.producerProjectId_ = getDefaultInstance().getProducerProjectId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L3(Monitoring monitoring) {
        monitoring.getClass();
        this.monitoring_ = monitoring;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M2() {
        this.quota_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M3(String str) {
        str.getClass();
        this.name_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N2() {
        this.sourceInfo_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N3(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        this.name_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O2() {
        this.systemParameters_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O3(String str) {
        str.getClass();
        this.producerProjectId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P2() {
        this.title_ = getDefaultInstance().getTitle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P3(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        this.producerProjectId_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q2() {
        this.types_ = GeneratedMessageLite.y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q3(Quota quota) {
        quota.getClass();
        this.quota_ = quota;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R2() {
        this.usage_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R3(SourceInfo sourceInfo) {
        sourceInfo.getClass();
        this.sourceInfo_ = sourceInfo;
    }

    private void S2() {
        Internal.ProtobufList<Api> protobufList = this.apis_;
        if (!protobufList.isModifiable()) {
            this.apis_ = GeneratedMessageLite.K(protobufList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S3(SystemParameters systemParameters) {
        systemParameters.getClass();
        this.systemParameters_ = systemParameters;
    }

    private void T2() {
        Internal.ProtobufList<Endpoint> protobufList = this.endpoints_;
        if (!protobufList.isModifiable()) {
            this.endpoints_ = GeneratedMessageLite.K(protobufList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T3(String str) {
        str.getClass();
        this.title_ = str;
    }

    private void U2() {
        Internal.ProtobufList<Enum> protobufList = this.enums_;
        if (!protobufList.isModifiable()) {
            this.enums_ = GeneratedMessageLite.K(protobufList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U3(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        this.title_ = byteString.toStringUtf8();
    }

    private void V2() {
        Internal.ProtobufList<LogDescriptor> protobufList = this.logs_;
        if (!protobufList.isModifiable()) {
            this.logs_ = GeneratedMessageLite.K(protobufList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V3(int i4, Type type) {
        type.getClass();
        Y2();
        this.types_.set(i4, type);
    }

    private void W2() {
        Internal.ProtobufList<MetricDescriptor> protobufList = this.metrics_;
        if (!protobufList.isModifiable()) {
            this.metrics_ = GeneratedMessageLite.K(protobufList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W3(Usage usage) {
        usage.getClass();
        this.usage_ = usage;
    }

    private void X2() {
        Internal.ProtobufList<MonitoredResourceDescriptor> protobufList = this.monitoredResources_;
        if (!protobufList.isModifiable()) {
            this.monitoredResources_ = GeneratedMessageLite.K(protobufList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y1(Iterable<? extends Api> iterable) {
        S2();
        AbstractMessageLite.a(iterable, this.apis_);
    }

    private void Y2() {
        Internal.ProtobufList<Type> protobufList = this.types_;
        if (!protobufList.isModifiable()) {
            this.types_ = GeneratedMessageLite.K(protobufList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z1(Iterable<? extends Endpoint> iterable) {
        T2();
        AbstractMessageLite.a(iterable, this.endpoints_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z2(Authentication authentication) {
        authentication.getClass();
        Authentication authentication2 = this.authentication_;
        if (authentication2 != null && authentication2 != Authentication.getDefaultInstance()) {
            this.authentication_ = Authentication.newBuilder(this.authentication_).mergeFrom((Authentication.Builder) authentication).buildPartial();
        } else {
            this.authentication_ = authentication;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a2(Iterable<? extends Enum> iterable) {
        U2();
        AbstractMessageLite.a(iterable, this.enums_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a3(Backend backend) {
        backend.getClass();
        Backend backend2 = this.backend_;
        if (backend2 != null && backend2 != Backend.getDefaultInstance()) {
            this.backend_ = Backend.newBuilder(this.backend_).mergeFrom((Backend.Builder) backend).buildPartial();
        } else {
            this.backend_ = backend;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b2(Iterable<? extends LogDescriptor> iterable) {
        V2();
        AbstractMessageLite.a(iterable, this.logs_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b3(Billing billing) {
        billing.getClass();
        Billing billing2 = this.billing_;
        if (billing2 != null && billing2 != Billing.getDefaultInstance()) {
            this.billing_ = Billing.newBuilder(this.billing_).mergeFrom((Billing.Builder) billing).buildPartial();
        } else {
            this.billing_ = billing;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c2(Iterable<? extends MetricDescriptor> iterable) {
        W2();
        AbstractMessageLite.a(iterable, this.metrics_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c3(UInt32Value uInt32Value) {
        uInt32Value.getClass();
        UInt32Value uInt32Value2 = this.configVersion_;
        if (uInt32Value2 != null && uInt32Value2 != UInt32Value.getDefaultInstance()) {
            this.configVersion_ = UInt32Value.newBuilder(this.configVersion_).mergeFrom((UInt32Value.Builder) uInt32Value).buildPartial();
        } else {
            this.configVersion_ = uInt32Value;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d2(Iterable<? extends MonitoredResourceDescriptor> iterable) {
        X2();
        AbstractMessageLite.a(iterable, this.monitoredResources_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d3(Context context) {
        context.getClass();
        Context context2 = this.context_;
        if (context2 != null && context2 != Context.getDefaultInstance()) {
            this.context_ = Context.newBuilder(this.context_).mergeFrom((Context.Builder) context).buildPartial();
        } else {
            this.context_ = context;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e2(Iterable<? extends Type> iterable) {
        Y2();
        AbstractMessageLite.a(iterable, this.types_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e3(Control control) {
        control.getClass();
        Control control2 = this.control_;
        if (control2 != null && control2 != Control.getDefaultInstance()) {
            this.control_ = Control.newBuilder(this.control_).mergeFrom((Control.Builder) control).buildPartial();
        } else {
            this.control_ = control;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f2(int i4, Api api) {
        api.getClass();
        S2();
        this.apis_.add(i4, api);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f3(Documentation documentation) {
        documentation.getClass();
        Documentation documentation2 = this.documentation_;
        if (documentation2 != null && documentation2 != Documentation.getDefaultInstance()) {
            this.documentation_ = Documentation.newBuilder(this.documentation_).mergeFrom((Documentation.Builder) documentation).buildPartial();
        } else {
            this.documentation_ = documentation;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g2(Api api) {
        api.getClass();
        S2();
        this.apis_.add(api);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g3(Http http) {
        http.getClass();
        Http http2 = this.http_;
        if (http2 != null && http2 != Http.getDefaultInstance()) {
            this.http_ = Http.newBuilder(this.http_).mergeFrom((Http.Builder) http).buildPartial();
        } else {
            this.http_ = http;
        }
    }

    public static Service getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h2(int i4, Endpoint endpoint) {
        endpoint.getClass();
        T2();
        this.endpoints_.add(i4, endpoint);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h3(Logging logging) {
        logging.getClass();
        Logging logging2 = this.logging_;
        if (logging2 != null && logging2 != Logging.getDefaultInstance()) {
            this.logging_ = Logging.newBuilder(this.logging_).mergeFrom((Logging.Builder) logging).buildPartial();
        } else {
            this.logging_ = logging;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i2(Endpoint endpoint) {
        endpoint.getClass();
        T2();
        this.endpoints_.add(endpoint);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i3(Monitoring monitoring) {
        monitoring.getClass();
        Monitoring monitoring2 = this.monitoring_;
        if (monitoring2 != null && monitoring2 != Monitoring.getDefaultInstance()) {
            this.monitoring_ = Monitoring.newBuilder(this.monitoring_).mergeFrom((Monitoring.Builder) monitoring).buildPartial();
        } else {
            this.monitoring_ = monitoring;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j2(int i4, Enum r32) {
        r32.getClass();
        U2();
        this.enums_.add(i4, r32);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j3(Quota quota) {
        quota.getClass();
        Quota quota2 = this.quota_;
        if (quota2 != null && quota2 != Quota.getDefaultInstance()) {
            this.quota_ = Quota.newBuilder(this.quota_).mergeFrom((Quota.Builder) quota).buildPartial();
        } else {
            this.quota_ = quota;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k2(Enum r22) {
        r22.getClass();
        U2();
        this.enums_.add(r22);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k3(SourceInfo sourceInfo) {
        sourceInfo.getClass();
        SourceInfo sourceInfo2 = this.sourceInfo_;
        if (sourceInfo2 != null && sourceInfo2 != SourceInfo.getDefaultInstance()) {
            this.sourceInfo_ = SourceInfo.newBuilder(this.sourceInfo_).mergeFrom((SourceInfo.Builder) sourceInfo).buildPartial();
        } else {
            this.sourceInfo_ = sourceInfo;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l2(int i4, LogDescriptor logDescriptor) {
        logDescriptor.getClass();
        V2();
        this.logs_.add(i4, logDescriptor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l3(SystemParameters systemParameters) {
        systemParameters.getClass();
        SystemParameters systemParameters2 = this.systemParameters_;
        if (systemParameters2 != null && systemParameters2 != SystemParameters.getDefaultInstance()) {
            this.systemParameters_ = SystemParameters.newBuilder(this.systemParameters_).mergeFrom((SystemParameters.Builder) systemParameters).buildPartial();
        } else {
            this.systemParameters_ = systemParameters;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m2(LogDescriptor logDescriptor) {
        logDescriptor.getClass();
        V2();
        this.logs_.add(logDescriptor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m3(Usage usage) {
        usage.getClass();
        Usage usage2 = this.usage_;
        if (usage2 != null && usage2 != Usage.getDefaultInstance()) {
            this.usage_ = Usage.newBuilder(this.usage_).mergeFrom((Usage.Builder) usage).buildPartial();
        } else {
            this.usage_ = usage;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n2(int i4, MetricDescriptor metricDescriptor) {
        metricDescriptor.getClass();
        W2();
        this.metrics_.add(i4, metricDescriptor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n3(int i4) {
        S2();
        this.apis_.remove(i4);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o2(MetricDescriptor metricDescriptor) {
        metricDescriptor.getClass();
        W2();
        this.metrics_.add(metricDescriptor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o3(int i4) {
        T2();
        this.endpoints_.remove(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p2(int i4, MonitoredResourceDescriptor monitoredResourceDescriptor) {
        monitoredResourceDescriptor.getClass();
        X2();
        this.monitoredResources_.add(i4, monitoredResourceDescriptor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p3(int i4) {
        U2();
        this.enums_.remove(i4);
    }

    public static Service parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Service) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
    }

    public static Service parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (Service) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Service> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q2(MonitoredResourceDescriptor monitoredResourceDescriptor) {
        monitoredResourceDescriptor.getClass();
        X2();
        this.monitoredResources_.add(monitoredResourceDescriptor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q3(int i4) {
        V2();
        this.logs_.remove(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r2(int i4, Type type) {
        type.getClass();
        Y2();
        this.types_.add(i4, type);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r3(int i4) {
        W2();
        this.metrics_.remove(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s2(Type type) {
        type.getClass();
        Y2();
        this.types_.add(type);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s3(int i4) {
        X2();
        this.monitoredResources_.remove(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t2() {
        this.apis_ = GeneratedMessageLite.y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t3(int i4) {
        Y2();
        this.types_.remove(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u2() {
        this.authentication_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u3(int i4, Api api) {
        api.getClass();
        S2();
        this.apis_.set(i4, api);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v2() {
        this.backend_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v3(Authentication authentication) {
        authentication.getClass();
        this.authentication_ = authentication;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w2() {
        this.billing_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w3(Backend backend) {
        backend.getClass();
        this.backend_ = backend;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x2() {
        this.configVersion_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x3(Billing billing) {
        billing.getClass();
        this.billing_ = billing;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y2() {
        this.context_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y3(UInt32Value uInt32Value) {
        uInt32Value.getClass();
        this.configVersion_ = uInt32Value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z2() {
        this.control_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z3(Context context) {
        context.getClass();
        this.context_ = context;
    }

    @Override // com.google.api.ServiceOrBuilder
    public Api getApis(int i4) {
        return this.apis_.get(i4);
    }

    @Override // com.google.api.ServiceOrBuilder
    public int getApisCount() {
        return this.apis_.size();
    }

    @Override // com.google.api.ServiceOrBuilder
    public List<Api> getApisList() {
        return this.apis_;
    }

    public ApiOrBuilder getApisOrBuilder(int i4) {
        return this.apis_.get(i4);
    }

    public List<? extends ApiOrBuilder> getApisOrBuilderList() {
        return this.apis_;
    }

    @Override // com.google.api.ServiceOrBuilder
    public Authentication getAuthentication() {
        Authentication authentication = this.authentication_;
        if (authentication == null) {
            return Authentication.getDefaultInstance();
        }
        return authentication;
    }

    @Override // com.google.api.ServiceOrBuilder
    public Backend getBackend() {
        Backend backend = this.backend_;
        if (backend == null) {
            return Backend.getDefaultInstance();
        }
        return backend;
    }

    @Override // com.google.api.ServiceOrBuilder
    public Billing getBilling() {
        Billing billing = this.billing_;
        if (billing == null) {
            return Billing.getDefaultInstance();
        }
        return billing;
    }

    @Override // com.google.api.ServiceOrBuilder
    public UInt32Value getConfigVersion() {
        UInt32Value uInt32Value = this.configVersion_;
        if (uInt32Value == null) {
            return UInt32Value.getDefaultInstance();
        }
        return uInt32Value;
    }

    @Override // com.google.api.ServiceOrBuilder
    public Context getContext() {
        Context context = this.context_;
        if (context == null) {
            return Context.getDefaultInstance();
        }
        return context;
    }

    @Override // com.google.api.ServiceOrBuilder
    public Control getControl() {
        Control control = this.control_;
        if (control == null) {
            return Control.getDefaultInstance();
        }
        return control;
    }

    @Override // com.google.api.ServiceOrBuilder
    public Documentation getDocumentation() {
        Documentation documentation = this.documentation_;
        if (documentation == null) {
            return Documentation.getDefaultInstance();
        }
        return documentation;
    }

    @Override // com.google.api.ServiceOrBuilder
    public Endpoint getEndpoints(int i4) {
        return this.endpoints_.get(i4);
    }

    @Override // com.google.api.ServiceOrBuilder
    public int getEndpointsCount() {
        return this.endpoints_.size();
    }

    @Override // com.google.api.ServiceOrBuilder
    public List<Endpoint> getEndpointsList() {
        return this.endpoints_;
    }

    public EndpointOrBuilder getEndpointsOrBuilder(int i4) {
        return this.endpoints_.get(i4);
    }

    public List<? extends EndpointOrBuilder> getEndpointsOrBuilderList() {
        return this.endpoints_;
    }

    @Override // com.google.api.ServiceOrBuilder
    public Enum getEnums(int i4) {
        return this.enums_.get(i4);
    }

    @Override // com.google.api.ServiceOrBuilder
    public int getEnumsCount() {
        return this.enums_.size();
    }

    @Override // com.google.api.ServiceOrBuilder
    public List<Enum> getEnumsList() {
        return this.enums_;
    }

    public EnumOrBuilder getEnumsOrBuilder(int i4) {
        return this.enums_.get(i4);
    }

    public List<? extends EnumOrBuilder> getEnumsOrBuilderList() {
        return this.enums_;
    }

    @Override // com.google.api.ServiceOrBuilder
    public Http getHttp() {
        Http http = this.http_;
        if (http == null) {
            return Http.getDefaultInstance();
        }
        return http;
    }

    @Override // com.google.api.ServiceOrBuilder
    public String getId() {
        return this.id_;
    }

    @Override // com.google.api.ServiceOrBuilder
    public ByteString getIdBytes() {
        return ByteString.copyFromUtf8(this.id_);
    }

    @Override // com.google.api.ServiceOrBuilder
    public Logging getLogging() {
        Logging logging = this.logging_;
        if (logging == null) {
            return Logging.getDefaultInstance();
        }
        return logging;
    }

    @Override // com.google.api.ServiceOrBuilder
    public LogDescriptor getLogs(int i4) {
        return this.logs_.get(i4);
    }

    @Override // com.google.api.ServiceOrBuilder
    public int getLogsCount() {
        return this.logs_.size();
    }

    @Override // com.google.api.ServiceOrBuilder
    public List<LogDescriptor> getLogsList() {
        return this.logs_;
    }

    public LogDescriptorOrBuilder getLogsOrBuilder(int i4) {
        return this.logs_.get(i4);
    }

    public List<? extends LogDescriptorOrBuilder> getLogsOrBuilderList() {
        return this.logs_;
    }

    @Override // com.google.api.ServiceOrBuilder
    public MetricDescriptor getMetrics(int i4) {
        return this.metrics_.get(i4);
    }

    @Override // com.google.api.ServiceOrBuilder
    public int getMetricsCount() {
        return this.metrics_.size();
    }

    @Override // com.google.api.ServiceOrBuilder
    public List<MetricDescriptor> getMetricsList() {
        return this.metrics_;
    }

    public MetricDescriptorOrBuilder getMetricsOrBuilder(int i4) {
        return this.metrics_.get(i4);
    }

    public List<? extends MetricDescriptorOrBuilder> getMetricsOrBuilderList() {
        return this.metrics_;
    }

    @Override // com.google.api.ServiceOrBuilder
    public MonitoredResourceDescriptor getMonitoredResources(int i4) {
        return this.monitoredResources_.get(i4);
    }

    @Override // com.google.api.ServiceOrBuilder
    public int getMonitoredResourcesCount() {
        return this.monitoredResources_.size();
    }

    @Override // com.google.api.ServiceOrBuilder
    public List<MonitoredResourceDescriptor> getMonitoredResourcesList() {
        return this.monitoredResources_;
    }

    public MonitoredResourceDescriptorOrBuilder getMonitoredResourcesOrBuilder(int i4) {
        return this.monitoredResources_.get(i4);
    }

    public List<? extends MonitoredResourceDescriptorOrBuilder> getMonitoredResourcesOrBuilderList() {
        return this.monitoredResources_;
    }

    @Override // com.google.api.ServiceOrBuilder
    public Monitoring getMonitoring() {
        Monitoring monitoring = this.monitoring_;
        if (monitoring == null) {
            return Monitoring.getDefaultInstance();
        }
        return monitoring;
    }

    @Override // com.google.api.ServiceOrBuilder
    public String getName() {
        return this.name_;
    }

    @Override // com.google.api.ServiceOrBuilder
    public ByteString getNameBytes() {
        return ByteString.copyFromUtf8(this.name_);
    }

    @Override // com.google.api.ServiceOrBuilder
    public String getProducerProjectId() {
        return this.producerProjectId_;
    }

    @Override // com.google.api.ServiceOrBuilder
    public ByteString getProducerProjectIdBytes() {
        return ByteString.copyFromUtf8(this.producerProjectId_);
    }

    @Override // com.google.api.ServiceOrBuilder
    public Quota getQuota() {
        Quota quota = this.quota_;
        if (quota == null) {
            return Quota.getDefaultInstance();
        }
        return quota;
    }

    @Override // com.google.api.ServiceOrBuilder
    public SourceInfo getSourceInfo() {
        SourceInfo sourceInfo = this.sourceInfo_;
        if (sourceInfo == null) {
            return SourceInfo.getDefaultInstance();
        }
        return sourceInfo;
    }

    @Override // com.google.api.ServiceOrBuilder
    public SystemParameters getSystemParameters() {
        SystemParameters systemParameters = this.systemParameters_;
        if (systemParameters == null) {
            return SystemParameters.getDefaultInstance();
        }
        return systemParameters;
    }

    @Override // com.google.api.ServiceOrBuilder
    public String getTitle() {
        return this.title_;
    }

    @Override // com.google.api.ServiceOrBuilder
    public ByteString getTitleBytes() {
        return ByteString.copyFromUtf8(this.title_);
    }

    @Override // com.google.api.ServiceOrBuilder
    public Type getTypes(int i4) {
        return this.types_.get(i4);
    }

    @Override // com.google.api.ServiceOrBuilder
    public int getTypesCount() {
        return this.types_.size();
    }

    @Override // com.google.api.ServiceOrBuilder
    public List<Type> getTypesList() {
        return this.types_;
    }

    public TypeOrBuilder getTypesOrBuilder(int i4) {
        return this.types_.get(i4);
    }

    public List<? extends TypeOrBuilder> getTypesOrBuilderList() {
        return this.types_;
    }

    @Override // com.google.api.ServiceOrBuilder
    public Usage getUsage() {
        Usage usage = this.usage_;
        if (usage == null) {
            return Usage.getDefaultInstance();
        }
        return usage;
    }

    @Override // com.google.api.ServiceOrBuilder
    public boolean hasAuthentication() {
        if (this.authentication_ != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.api.ServiceOrBuilder
    public boolean hasBackend() {
        if (this.backend_ != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.api.ServiceOrBuilder
    public boolean hasBilling() {
        if (this.billing_ != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.api.ServiceOrBuilder
    public boolean hasConfigVersion() {
        if (this.configVersion_ != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.api.ServiceOrBuilder
    public boolean hasContext() {
        if (this.context_ != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.api.ServiceOrBuilder
    public boolean hasControl() {
        if (this.control_ != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.api.ServiceOrBuilder
    public boolean hasDocumentation() {
        if (this.documentation_ != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.api.ServiceOrBuilder
    public boolean hasHttp() {
        if (this.http_ != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.api.ServiceOrBuilder
    public boolean hasLogging() {
        if (this.logging_ != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.api.ServiceOrBuilder
    public boolean hasMonitoring() {
        if (this.monitoring_ != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.api.ServiceOrBuilder
    public boolean hasQuota() {
        if (this.quota_ != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.api.ServiceOrBuilder
    public boolean hasSourceInfo() {
        if (this.sourceInfo_ != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.api.ServiceOrBuilder
    public boolean hasSystemParameters() {
        if (this.systemParameters_ != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.api.ServiceOrBuilder
    public boolean hasUsage() {
        if (this.usage_ != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.f25457a[methodToInvoke.ordinal()]) {
            case 1:
                return new Service();
            case 2:
                return new Builder(null);
            case 3:
                return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0019\u0000\u0000\u0001%\u0019\u0000\u0007\u0000\u0001Ȉ\u0002Ȉ\u0003\u001b\u0004\u001b\u0005\u001b\u0006\t\b\t\t\t\n\t\u000b\t\f\t\u000f\t\u0012\u001b\u0014\t\u0015\t\u0016Ȉ\u0017\u001b\u0018\u001b\u0019\u001b\u001a\t\u001b\t\u001c\t\u001d\t!Ȉ%\t", new Object[]{"name_", "title_", "apis_", Api.class, "types_", Type.class, "enums_", Enum.class, "documentation_", "backend_", "http_", "quota_", "authentication_", "context_", "usage_", "endpoints_", Endpoint.class, "configVersion_", "control_", "producerProjectId_", "logs_", LogDescriptor.class, "metrics_", MetricDescriptor.class, "monitoredResources_", MonitoredResourceDescriptor.class, "billing_", "logging_", "monitoring_", "systemParameters_", "id_", "sourceInfo_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Service> parser = PARSER;
                if (parser == null) {
                    synchronized (Service.class) {
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

    public static Builder newBuilder(Service service) {
        return DEFAULT_INSTANCE.r(service);
    }

    public static Service parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Service) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Service parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Service) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Service parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (Service) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
    }

    public static Service parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Service) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Service parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (Service) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
    }

    public static Service parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Service) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Service parseFrom(InputStream inputStream) throws IOException {
        return (Service) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
    }

    public static Service parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Service) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Service parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Service) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Service parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Service) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
