package com.google.api;

import com.google.protobuf.Api;
import com.google.protobuf.ByteString;
import com.google.protobuf.Enum;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Type;
import com.google.protobuf.UInt32Value;
import java.util.List;

/* loaded from: classes5.dex */
public interface ServiceOrBuilder extends MessageLiteOrBuilder {
    Api getApis(int i4);

    int getApisCount();

    List<Api> getApisList();

    Authentication getAuthentication();

    Backend getBackend();

    Billing getBilling();

    UInt32Value getConfigVersion();

    Context getContext();

    Control getControl();

    Documentation getDocumentation();

    Endpoint getEndpoints(int i4);

    int getEndpointsCount();

    List<Endpoint> getEndpointsList();

    Enum getEnums(int i4);

    int getEnumsCount();

    List<Enum> getEnumsList();

    Http getHttp();

    String getId();

    ByteString getIdBytes();

    Logging getLogging();

    LogDescriptor getLogs(int i4);

    int getLogsCount();

    List<LogDescriptor> getLogsList();

    MetricDescriptor getMetrics(int i4);

    int getMetricsCount();

    List<MetricDescriptor> getMetricsList();

    MonitoredResourceDescriptor getMonitoredResources(int i4);

    int getMonitoredResourcesCount();

    List<MonitoredResourceDescriptor> getMonitoredResourcesList();

    Monitoring getMonitoring();

    String getName();

    ByteString getNameBytes();

    String getProducerProjectId();

    ByteString getProducerProjectIdBytes();

    Quota getQuota();

    SourceInfo getSourceInfo();

    SystemParameters getSystemParameters();

    String getTitle();

    ByteString getTitleBytes();

    Type getTypes(int i4);

    int getTypesCount();

    List<Type> getTypesList();

    Usage getUsage();

    boolean hasAuthentication();

    boolean hasBackend();

    boolean hasBilling();

    boolean hasConfigVersion();

    boolean hasContext();

    boolean hasControl();

    boolean hasDocumentation();

    boolean hasHttp();

    boolean hasLogging();

    boolean hasMonitoring();

    boolean hasQuota();

    boolean hasSourceInfo();

    boolean hasSystemParameters();

    boolean hasUsage();
}
