package com.google.api;

import com.google.api.LabelDescriptor;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Duration;
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
public final class MetricDescriptor extends GeneratedMessageLite<MetricDescriptor, Builder> implements MetricDescriptorOrBuilder {
    private static final MetricDescriptor DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 6;
    public static final int DISPLAY_NAME_FIELD_NUMBER = 7;
    public static final int LABELS_FIELD_NUMBER = 2;
    public static final int LAUNCH_STAGE_FIELD_NUMBER = 12;
    public static final int METADATA_FIELD_NUMBER = 10;
    public static final int METRIC_KIND_FIELD_NUMBER = 3;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile Parser<MetricDescriptor> PARSER = null;
    public static final int TYPE_FIELD_NUMBER = 8;
    public static final int UNIT_FIELD_NUMBER = 5;
    public static final int VALUE_TYPE_FIELD_NUMBER = 4;
    private int launchStage_;
    private MetricDescriptorMetadata metadata_;
    private int metricKind_;
    private int valueType_;
    private String name_ = "";
    private String type_ = "";
    private Internal.ProtobufList<LabelDescriptor> labels_ = GeneratedMessageLite.y();
    private String unit_ = "";
    private String description_ = "";
    private String displayName_ = "";

    /* renamed from: com.google.api.MetricDescriptor$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f25427a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f25427a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f25427a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f25427a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f25427a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f25427a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f25427a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f25427a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<MetricDescriptor, Builder> implements MetricDescriptorOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllLabels(Iterable<? extends LabelDescriptor> iterable) {
            f();
            ((MetricDescriptor) this.f33398b).N0(iterable);
            return this;
        }

        public Builder addLabels(LabelDescriptor labelDescriptor) {
            f();
            ((MetricDescriptor) this.f33398b).P0(labelDescriptor);
            return this;
        }

        public Builder clearDescription() {
            f();
            ((MetricDescriptor) this.f33398b).Q0();
            return this;
        }

        public Builder clearDisplayName() {
            f();
            ((MetricDescriptor) this.f33398b).R0();
            return this;
        }

        public Builder clearLabels() {
            f();
            ((MetricDescriptor) this.f33398b).S0();
            return this;
        }

        public Builder clearLaunchStage() {
            f();
            ((MetricDescriptor) this.f33398b).T0();
            return this;
        }

        public Builder clearMetadata() {
            f();
            ((MetricDescriptor) this.f33398b).U0();
            return this;
        }

        public Builder clearMetricKind() {
            f();
            ((MetricDescriptor) this.f33398b).V0();
            return this;
        }

        public Builder clearName() {
            f();
            ((MetricDescriptor) this.f33398b).W0();
            return this;
        }

        public Builder clearType() {
            f();
            ((MetricDescriptor) this.f33398b).X0();
            return this;
        }

        public Builder clearUnit() {
            f();
            ((MetricDescriptor) this.f33398b).Y0();
            return this;
        }

        public Builder clearValueType() {
            f();
            ((MetricDescriptor) this.f33398b).Z0();
            return this;
        }

        @Override // com.google.api.MetricDescriptorOrBuilder
        public String getDescription() {
            return ((MetricDescriptor) this.f33398b).getDescription();
        }

        @Override // com.google.api.MetricDescriptorOrBuilder
        public ByteString getDescriptionBytes() {
            return ((MetricDescriptor) this.f33398b).getDescriptionBytes();
        }

        @Override // com.google.api.MetricDescriptorOrBuilder
        public String getDisplayName() {
            return ((MetricDescriptor) this.f33398b).getDisplayName();
        }

        @Override // com.google.api.MetricDescriptorOrBuilder
        public ByteString getDisplayNameBytes() {
            return ((MetricDescriptor) this.f33398b).getDisplayNameBytes();
        }

        @Override // com.google.api.MetricDescriptorOrBuilder
        public LabelDescriptor getLabels(int i4) {
            return ((MetricDescriptor) this.f33398b).getLabels(i4);
        }

        @Override // com.google.api.MetricDescriptorOrBuilder
        public int getLabelsCount() {
            return ((MetricDescriptor) this.f33398b).getLabelsCount();
        }

        @Override // com.google.api.MetricDescriptorOrBuilder
        public List<LabelDescriptor> getLabelsList() {
            return Collections.unmodifiableList(((MetricDescriptor) this.f33398b).getLabelsList());
        }

        @Override // com.google.api.MetricDescriptorOrBuilder
        public LaunchStage getLaunchStage() {
            return ((MetricDescriptor) this.f33398b).getLaunchStage();
        }

        @Override // com.google.api.MetricDescriptorOrBuilder
        public int getLaunchStageValue() {
            return ((MetricDescriptor) this.f33398b).getLaunchStageValue();
        }

        @Override // com.google.api.MetricDescriptorOrBuilder
        public MetricDescriptorMetadata getMetadata() {
            return ((MetricDescriptor) this.f33398b).getMetadata();
        }

        @Override // com.google.api.MetricDescriptorOrBuilder
        public MetricKind getMetricKind() {
            return ((MetricDescriptor) this.f33398b).getMetricKind();
        }

        @Override // com.google.api.MetricDescriptorOrBuilder
        public int getMetricKindValue() {
            return ((MetricDescriptor) this.f33398b).getMetricKindValue();
        }

        @Override // com.google.api.MetricDescriptorOrBuilder
        public String getName() {
            return ((MetricDescriptor) this.f33398b).getName();
        }

        @Override // com.google.api.MetricDescriptorOrBuilder
        public ByteString getNameBytes() {
            return ((MetricDescriptor) this.f33398b).getNameBytes();
        }

        @Override // com.google.api.MetricDescriptorOrBuilder
        public String getType() {
            return ((MetricDescriptor) this.f33398b).getType();
        }

        @Override // com.google.api.MetricDescriptorOrBuilder
        public ByteString getTypeBytes() {
            return ((MetricDescriptor) this.f33398b).getTypeBytes();
        }

        @Override // com.google.api.MetricDescriptorOrBuilder
        public String getUnit() {
            return ((MetricDescriptor) this.f33398b).getUnit();
        }

        @Override // com.google.api.MetricDescriptorOrBuilder
        public ByteString getUnitBytes() {
            return ((MetricDescriptor) this.f33398b).getUnitBytes();
        }

        @Override // com.google.api.MetricDescriptorOrBuilder
        public ValueType getValueType() {
            return ((MetricDescriptor) this.f33398b).getValueType();
        }

        @Override // com.google.api.MetricDescriptorOrBuilder
        public int getValueTypeValue() {
            return ((MetricDescriptor) this.f33398b).getValueTypeValue();
        }

        @Override // com.google.api.MetricDescriptorOrBuilder
        public boolean hasMetadata() {
            return ((MetricDescriptor) this.f33398b).hasMetadata();
        }

        public Builder mergeMetadata(MetricDescriptorMetadata metricDescriptorMetadata) {
            f();
            ((MetricDescriptor) this.f33398b).b1(metricDescriptorMetadata);
            return this;
        }

        public Builder removeLabels(int i4) {
            f();
            ((MetricDescriptor) this.f33398b).c1(i4);
            return this;
        }

        public Builder setDescription(String str) {
            f();
            ((MetricDescriptor) this.f33398b).d1(str);
            return this;
        }

        public Builder setDescriptionBytes(ByteString byteString) {
            f();
            ((MetricDescriptor) this.f33398b).e1(byteString);
            return this;
        }

        public Builder setDisplayName(String str) {
            f();
            ((MetricDescriptor) this.f33398b).f1(str);
            return this;
        }

        public Builder setDisplayNameBytes(ByteString byteString) {
            f();
            ((MetricDescriptor) this.f33398b).g1(byteString);
            return this;
        }

        public Builder setLabels(int i4, LabelDescriptor labelDescriptor) {
            f();
            ((MetricDescriptor) this.f33398b).h1(i4, labelDescriptor);
            return this;
        }

        public Builder setLaunchStage(LaunchStage launchStage) {
            f();
            ((MetricDescriptor) this.f33398b).i1(launchStage);
            return this;
        }

        public Builder setLaunchStageValue(int i4) {
            f();
            ((MetricDescriptor) this.f33398b).j1(i4);
            return this;
        }

        public Builder setMetadata(MetricDescriptorMetadata metricDescriptorMetadata) {
            f();
            ((MetricDescriptor) this.f33398b).k1(metricDescriptorMetadata);
            return this;
        }

        public Builder setMetricKind(MetricKind metricKind) {
            f();
            ((MetricDescriptor) this.f33398b).l1(metricKind);
            return this;
        }

        public Builder setMetricKindValue(int i4) {
            f();
            ((MetricDescriptor) this.f33398b).m1(i4);
            return this;
        }

        public Builder setName(String str) {
            f();
            ((MetricDescriptor) this.f33398b).n1(str);
            return this;
        }

        public Builder setNameBytes(ByteString byteString) {
            f();
            ((MetricDescriptor) this.f33398b).o1(byteString);
            return this;
        }

        public Builder setType(String str) {
            f();
            ((MetricDescriptor) this.f33398b).p1(str);
            return this;
        }

        public Builder setTypeBytes(ByteString byteString) {
            f();
            ((MetricDescriptor) this.f33398b).q1(byteString);
            return this;
        }

        public Builder setUnit(String str) {
            f();
            ((MetricDescriptor) this.f33398b).r1(str);
            return this;
        }

        public Builder setUnitBytes(ByteString byteString) {
            f();
            ((MetricDescriptor) this.f33398b).s1(byteString);
            return this;
        }

        public Builder setValueType(ValueType valueType) {
            f();
            ((MetricDescriptor) this.f33398b).t1(valueType);
            return this;
        }

        public Builder setValueTypeValue(int i4) {
            f();
            ((MetricDescriptor) this.f33398b).u1(i4);
            return this;
        }

        private Builder() {
            super(MetricDescriptor.DEFAULT_INSTANCE);
        }

        public Builder addLabels(int i4, LabelDescriptor labelDescriptor) {
            f();
            ((MetricDescriptor) this.f33398b).O0(i4, labelDescriptor);
            return this;
        }

        public Builder setLabels(int i4, LabelDescriptor.Builder builder) {
            f();
            ((MetricDescriptor) this.f33398b).h1(i4, builder.build());
            return this;
        }

        public Builder setMetadata(MetricDescriptorMetadata.Builder builder) {
            f();
            ((MetricDescriptor) this.f33398b).k1(builder.build());
            return this;
        }

        public Builder addLabels(LabelDescriptor.Builder builder) {
            f();
            ((MetricDescriptor) this.f33398b).P0(builder.build());
            return this;
        }

        public Builder addLabels(int i4, LabelDescriptor.Builder builder) {
            f();
            ((MetricDescriptor) this.f33398b).O0(i4, builder.build());
            return this;
        }
    }

    /* loaded from: classes5.dex */
    public static final class MetricDescriptorMetadata extends GeneratedMessageLite<MetricDescriptorMetadata, Builder> implements MetricDescriptorMetadataOrBuilder {
        private static final MetricDescriptorMetadata DEFAULT_INSTANCE;
        public static final int INGEST_DELAY_FIELD_NUMBER = 3;
        public static final int LAUNCH_STAGE_FIELD_NUMBER = 1;
        private static volatile Parser<MetricDescriptorMetadata> PARSER = null;
        public static final int SAMPLE_PERIOD_FIELD_NUMBER = 2;
        private Duration ingestDelay_;
        private int launchStage_;
        private Duration samplePeriod_;

        /* loaded from: classes5.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<MetricDescriptorMetadata, Builder> implements MetricDescriptorMetadataOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearIngestDelay() {
                f();
                ((MetricDescriptorMetadata) this.f33398b).p0();
                return this;
            }

            @Deprecated
            public Builder clearLaunchStage() {
                f();
                ((MetricDescriptorMetadata) this.f33398b).q0();
                return this;
            }

            public Builder clearSamplePeriod() {
                f();
                ((MetricDescriptorMetadata) this.f33398b).r0();
                return this;
            }

            @Override // com.google.api.MetricDescriptor.MetricDescriptorMetadataOrBuilder
            public Duration getIngestDelay() {
                return ((MetricDescriptorMetadata) this.f33398b).getIngestDelay();
            }

            @Override // com.google.api.MetricDescriptor.MetricDescriptorMetadataOrBuilder
            @Deprecated
            public LaunchStage getLaunchStage() {
                return ((MetricDescriptorMetadata) this.f33398b).getLaunchStage();
            }

            @Override // com.google.api.MetricDescriptor.MetricDescriptorMetadataOrBuilder
            @Deprecated
            public int getLaunchStageValue() {
                return ((MetricDescriptorMetadata) this.f33398b).getLaunchStageValue();
            }

            @Override // com.google.api.MetricDescriptor.MetricDescriptorMetadataOrBuilder
            public Duration getSamplePeriod() {
                return ((MetricDescriptorMetadata) this.f33398b).getSamplePeriod();
            }

            @Override // com.google.api.MetricDescriptor.MetricDescriptorMetadataOrBuilder
            public boolean hasIngestDelay() {
                return ((MetricDescriptorMetadata) this.f33398b).hasIngestDelay();
            }

            @Override // com.google.api.MetricDescriptor.MetricDescriptorMetadataOrBuilder
            public boolean hasSamplePeriod() {
                return ((MetricDescriptorMetadata) this.f33398b).hasSamplePeriod();
            }

            public Builder mergeIngestDelay(Duration duration) {
                f();
                ((MetricDescriptorMetadata) this.f33398b).s0(duration);
                return this;
            }

            public Builder mergeSamplePeriod(Duration duration) {
                f();
                ((MetricDescriptorMetadata) this.f33398b).t0(duration);
                return this;
            }

            public Builder setIngestDelay(Duration duration) {
                f();
                ((MetricDescriptorMetadata) this.f33398b).u0(duration);
                return this;
            }

            @Deprecated
            public Builder setLaunchStage(LaunchStage launchStage) {
                f();
                ((MetricDescriptorMetadata) this.f33398b).v0(launchStage);
                return this;
            }

            @Deprecated
            public Builder setLaunchStageValue(int i4) {
                f();
                ((MetricDescriptorMetadata) this.f33398b).w0(i4);
                return this;
            }

            public Builder setSamplePeriod(Duration duration) {
                f();
                ((MetricDescriptorMetadata) this.f33398b).x0(duration);
                return this;
            }

            private Builder() {
                super(MetricDescriptorMetadata.DEFAULT_INSTANCE);
            }

            public Builder setIngestDelay(Duration.Builder builder) {
                f();
                ((MetricDescriptorMetadata) this.f33398b).u0(builder.build());
                return this;
            }

            public Builder setSamplePeriod(Duration.Builder builder) {
                f();
                ((MetricDescriptorMetadata) this.f33398b).x0(builder.build());
                return this;
            }
        }

        static {
            MetricDescriptorMetadata metricDescriptorMetadata = new MetricDescriptorMetadata();
            DEFAULT_INSTANCE = metricDescriptorMetadata;
            GeneratedMessageLite.d0(MetricDescriptorMetadata.class, metricDescriptorMetadata);
        }

        private MetricDescriptorMetadata() {
        }

        public static MetricDescriptorMetadata getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.q();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void p0() {
            this.ingestDelay_ = null;
        }

        public static MetricDescriptorMetadata parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (MetricDescriptorMetadata) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
        }

        public static MetricDescriptorMetadata parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (MetricDescriptorMetadata) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<MetricDescriptorMetadata> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void q0() {
            this.launchStage_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void r0() {
            this.samplePeriod_ = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s0(Duration duration) {
            duration.getClass();
            Duration duration2 = this.ingestDelay_;
            if (duration2 != null && duration2 != Duration.getDefaultInstance()) {
                this.ingestDelay_ = Duration.newBuilder(this.ingestDelay_).mergeFrom((Duration.Builder) duration).buildPartial();
            } else {
                this.ingestDelay_ = duration;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void t0(Duration duration) {
            duration.getClass();
            Duration duration2 = this.samplePeriod_;
            if (duration2 != null && duration2 != Duration.getDefaultInstance()) {
                this.samplePeriod_ = Duration.newBuilder(this.samplePeriod_).mergeFrom((Duration.Builder) duration).buildPartial();
            } else {
                this.samplePeriod_ = duration;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void u0(Duration duration) {
            duration.getClass();
            this.ingestDelay_ = duration;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void v0(LaunchStage launchStage) {
            this.launchStage_ = launchStage.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void w0(int i4) {
            this.launchStage_ = i4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void x0(Duration duration) {
            duration.getClass();
            this.samplePeriod_ = duration;
        }

        @Override // com.google.api.MetricDescriptor.MetricDescriptorMetadataOrBuilder
        public Duration getIngestDelay() {
            Duration duration = this.ingestDelay_;
            if (duration == null) {
                return Duration.getDefaultInstance();
            }
            return duration;
        }

        @Override // com.google.api.MetricDescriptor.MetricDescriptorMetadataOrBuilder
        @Deprecated
        public LaunchStage getLaunchStage() {
            LaunchStage forNumber = LaunchStage.forNumber(this.launchStage_);
            if (forNumber == null) {
                return LaunchStage.UNRECOGNIZED;
            }
            return forNumber;
        }

        @Override // com.google.api.MetricDescriptor.MetricDescriptorMetadataOrBuilder
        @Deprecated
        public int getLaunchStageValue() {
            return this.launchStage_;
        }

        @Override // com.google.api.MetricDescriptor.MetricDescriptorMetadataOrBuilder
        public Duration getSamplePeriod() {
            Duration duration = this.samplePeriod_;
            if (duration == null) {
                return Duration.getDefaultInstance();
            }
            return duration;
        }

        @Override // com.google.api.MetricDescriptor.MetricDescriptorMetadataOrBuilder
        public boolean hasIngestDelay() {
            if (this.ingestDelay_ != null) {
                return true;
            }
            return false;
        }

        @Override // com.google.api.MetricDescriptor.MetricDescriptorMetadataOrBuilder
        public boolean hasSamplePeriod() {
            if (this.samplePeriod_ != null) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (AnonymousClass1.f25427a[methodToInvoke.ordinal()]) {
                case 1:
                    return new MetricDescriptorMetadata();
                case 2:
                    return new Builder(null);
                case 3:
                    return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0002\t\u0003\t", new Object[]{"launchStage_", "samplePeriod_", "ingestDelay_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<MetricDescriptorMetadata> parser = PARSER;
                    if (parser == null) {
                        synchronized (MetricDescriptorMetadata.class) {
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

        public static Builder newBuilder(MetricDescriptorMetadata metricDescriptorMetadata) {
            return DEFAULT_INSTANCE.r(metricDescriptorMetadata);
        }

        public static MetricDescriptorMetadata parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MetricDescriptorMetadata) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static MetricDescriptorMetadata parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (MetricDescriptorMetadata) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static MetricDescriptorMetadata parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (MetricDescriptorMetadata) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
        }

        public static MetricDescriptorMetadata parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (MetricDescriptorMetadata) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static MetricDescriptorMetadata parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (MetricDescriptorMetadata) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
        }

        public static MetricDescriptorMetadata parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (MetricDescriptorMetadata) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static MetricDescriptorMetadata parseFrom(InputStream inputStream) throws IOException {
            return (MetricDescriptorMetadata) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
        }

        public static MetricDescriptorMetadata parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MetricDescriptorMetadata) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static MetricDescriptorMetadata parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (MetricDescriptorMetadata) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
        }

        public static MetricDescriptorMetadata parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MetricDescriptorMetadata) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: classes5.dex */
    public interface MetricDescriptorMetadataOrBuilder extends MessageLiteOrBuilder {
        Duration getIngestDelay();

        @Deprecated
        LaunchStage getLaunchStage();

        @Deprecated
        int getLaunchStageValue();

        Duration getSamplePeriod();

        boolean hasIngestDelay();

        boolean hasSamplePeriod();
    }

    /* loaded from: classes5.dex */
    public enum MetricKind implements Internal.EnumLite {
        METRIC_KIND_UNSPECIFIED(0),
        GAUGE(1),
        DELTA(2),
        CUMULATIVE(3),
        UNRECOGNIZED(-1);
        
        public static final int CUMULATIVE_VALUE = 3;
        public static final int DELTA_VALUE = 2;
        public static final int GAUGE_VALUE = 1;
        public static final int METRIC_KIND_UNSPECIFIED_VALUE = 0;

        /* renamed from: a  reason: collision with root package name */
        private static final Internal.EnumLiteMap<MetricKind> f25428a = new Internal.EnumLiteMap<MetricKind>() { // from class: com.google.api.MetricDescriptor.MetricKind.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            /* renamed from: a */
            public MetricKind findValueByNumber(int i4) {
                return MetricKind.forNumber(i4);
            }
        };
        private final int value;

        /* loaded from: classes5.dex */
        private static final class MetricKindVerifier implements Internal.EnumVerifier {

            /* renamed from: a  reason: collision with root package name */
            static final Internal.EnumVerifier f25430a = new MetricKindVerifier();

            private MetricKindVerifier() {
            }

            @Override // com.google.protobuf.Internal.EnumVerifier
            public boolean isInRange(int i4) {
                if (MetricKind.forNumber(i4) != null) {
                    return true;
                }
                return false;
            }
        }

        MetricKind(int i4) {
            this.value = i4;
        }

        public static MetricKind forNumber(int i4) {
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 != 2) {
                        if (i4 != 3) {
                            return null;
                        }
                        return CUMULATIVE;
                    }
                    return DELTA;
                }
                return GAUGE;
            }
            return METRIC_KIND_UNSPECIFIED;
        }

        public static Internal.EnumLiteMap<MetricKind> internalGetValueMap() {
            return f25428a;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return MetricKindVerifier.f25430a;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static MetricKind valueOf(int i4) {
            return forNumber(i4);
        }
    }

    /* loaded from: classes5.dex */
    public enum ValueType implements Internal.EnumLite {
        VALUE_TYPE_UNSPECIFIED(0),
        BOOL(1),
        INT64(2),
        DOUBLE(3),
        STRING(4),
        DISTRIBUTION(5),
        MONEY(6),
        UNRECOGNIZED(-1);
        
        public static final int BOOL_VALUE = 1;
        public static final int DISTRIBUTION_VALUE = 5;
        public static final int DOUBLE_VALUE = 3;
        public static final int INT64_VALUE = 2;
        public static final int MONEY_VALUE = 6;
        public static final int STRING_VALUE = 4;
        public static final int VALUE_TYPE_UNSPECIFIED_VALUE = 0;

        /* renamed from: a  reason: collision with root package name */
        private static final Internal.EnumLiteMap<ValueType> f25431a = new Internal.EnumLiteMap<ValueType>() { // from class: com.google.api.MetricDescriptor.ValueType.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            /* renamed from: a */
            public ValueType findValueByNumber(int i4) {
                return ValueType.forNumber(i4);
            }
        };
        private final int value;

        /* loaded from: classes5.dex */
        private static final class ValueTypeVerifier implements Internal.EnumVerifier {

            /* renamed from: a  reason: collision with root package name */
            static final Internal.EnumVerifier f25433a = new ValueTypeVerifier();

            private ValueTypeVerifier() {
            }

            @Override // com.google.protobuf.Internal.EnumVerifier
            public boolean isInRange(int i4) {
                if (ValueType.forNumber(i4) != null) {
                    return true;
                }
                return false;
            }
        }

        ValueType(int i4) {
            this.value = i4;
        }

        public static ValueType forNumber(int i4) {
            switch (i4) {
                case 0:
                    return VALUE_TYPE_UNSPECIFIED;
                case 1:
                    return BOOL;
                case 2:
                    return INT64;
                case 3:
                    return DOUBLE;
                case 4:
                    return STRING;
                case 5:
                    return DISTRIBUTION;
                case 6:
                    return MONEY;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<ValueType> internalGetValueMap() {
            return f25431a;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return ValueTypeVerifier.f25433a;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static ValueType valueOf(int i4) {
            return forNumber(i4);
        }
    }

    static {
        MetricDescriptor metricDescriptor = new MetricDescriptor();
        DEFAULT_INSTANCE = metricDescriptor;
        GeneratedMessageLite.d0(MetricDescriptor.class, metricDescriptor);
    }

    private MetricDescriptor() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N0(Iterable<? extends LabelDescriptor> iterable) {
        a1();
        AbstractMessageLite.a(iterable, this.labels_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O0(int i4, LabelDescriptor labelDescriptor) {
        labelDescriptor.getClass();
        a1();
        this.labels_.add(i4, labelDescriptor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P0(LabelDescriptor labelDescriptor) {
        labelDescriptor.getClass();
        a1();
        this.labels_.add(labelDescriptor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q0() {
        this.description_ = getDefaultInstance().getDescription();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R0() {
        this.displayName_ = getDefaultInstance().getDisplayName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S0() {
        this.labels_ = GeneratedMessageLite.y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T0() {
        this.launchStage_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U0() {
        this.metadata_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V0() {
        this.metricKind_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W0() {
        this.name_ = getDefaultInstance().getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X0() {
        this.type_ = getDefaultInstance().getType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y0() {
        this.unit_ = getDefaultInstance().getUnit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z0() {
        this.valueType_ = 0;
    }

    private void a1() {
        Internal.ProtobufList<LabelDescriptor> protobufList = this.labels_;
        if (!protobufList.isModifiable()) {
            this.labels_ = GeneratedMessageLite.K(protobufList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b1(MetricDescriptorMetadata metricDescriptorMetadata) {
        metricDescriptorMetadata.getClass();
        MetricDescriptorMetadata metricDescriptorMetadata2 = this.metadata_;
        if (metricDescriptorMetadata2 != null && metricDescriptorMetadata2 != MetricDescriptorMetadata.getDefaultInstance()) {
            this.metadata_ = MetricDescriptorMetadata.newBuilder(this.metadata_).mergeFrom((MetricDescriptorMetadata.Builder) metricDescriptorMetadata).buildPartial();
        } else {
            this.metadata_ = metricDescriptorMetadata;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c1(int i4) {
        a1();
        this.labels_.remove(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d1(String str) {
        str.getClass();
        this.description_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e1(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        this.description_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f1(String str) {
        str.getClass();
        this.displayName_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g1(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        this.displayName_ = byteString.toStringUtf8();
    }

    public static MetricDescriptor getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h1(int i4, LabelDescriptor labelDescriptor) {
        labelDescriptor.getClass();
        a1();
        this.labels_.set(i4, labelDescriptor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i1(LaunchStage launchStage) {
        this.launchStage_ = launchStage.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j1(int i4) {
        this.launchStage_ = i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k1(MetricDescriptorMetadata metricDescriptorMetadata) {
        metricDescriptorMetadata.getClass();
        this.metadata_ = metricDescriptorMetadata;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l1(MetricKind metricKind) {
        this.metricKind_ = metricKind.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m1(int i4) {
        this.metricKind_ = i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n1(String str) {
        str.getClass();
        this.name_ = str;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o1(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        this.name_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p1(String str) {
        str.getClass();
        this.type_ = str;
    }

    public static MetricDescriptor parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (MetricDescriptor) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
    }

    public static MetricDescriptor parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (MetricDescriptor) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<MetricDescriptor> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q1(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        this.type_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r1(String str) {
        str.getClass();
        this.unit_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s1(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        this.unit_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t1(ValueType valueType) {
        this.valueType_ = valueType.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u1(int i4) {
        this.valueType_ = i4;
    }

    @Override // com.google.api.MetricDescriptorOrBuilder
    public String getDescription() {
        return this.description_;
    }

    @Override // com.google.api.MetricDescriptorOrBuilder
    public ByteString getDescriptionBytes() {
        return ByteString.copyFromUtf8(this.description_);
    }

    @Override // com.google.api.MetricDescriptorOrBuilder
    public String getDisplayName() {
        return this.displayName_;
    }

    @Override // com.google.api.MetricDescriptorOrBuilder
    public ByteString getDisplayNameBytes() {
        return ByteString.copyFromUtf8(this.displayName_);
    }

    @Override // com.google.api.MetricDescriptorOrBuilder
    public LabelDescriptor getLabels(int i4) {
        return this.labels_.get(i4);
    }

    @Override // com.google.api.MetricDescriptorOrBuilder
    public int getLabelsCount() {
        return this.labels_.size();
    }

    @Override // com.google.api.MetricDescriptorOrBuilder
    public List<LabelDescriptor> getLabelsList() {
        return this.labels_;
    }

    public LabelDescriptorOrBuilder getLabelsOrBuilder(int i4) {
        return this.labels_.get(i4);
    }

    public List<? extends LabelDescriptorOrBuilder> getLabelsOrBuilderList() {
        return this.labels_;
    }

    @Override // com.google.api.MetricDescriptorOrBuilder
    public LaunchStage getLaunchStage() {
        LaunchStage forNumber = LaunchStage.forNumber(this.launchStage_);
        if (forNumber == null) {
            return LaunchStage.UNRECOGNIZED;
        }
        return forNumber;
    }

    @Override // com.google.api.MetricDescriptorOrBuilder
    public int getLaunchStageValue() {
        return this.launchStage_;
    }

    @Override // com.google.api.MetricDescriptorOrBuilder
    public MetricDescriptorMetadata getMetadata() {
        MetricDescriptorMetadata metricDescriptorMetadata = this.metadata_;
        if (metricDescriptorMetadata == null) {
            return MetricDescriptorMetadata.getDefaultInstance();
        }
        return metricDescriptorMetadata;
    }

    @Override // com.google.api.MetricDescriptorOrBuilder
    public MetricKind getMetricKind() {
        MetricKind forNumber = MetricKind.forNumber(this.metricKind_);
        if (forNumber == null) {
            return MetricKind.UNRECOGNIZED;
        }
        return forNumber;
    }

    @Override // com.google.api.MetricDescriptorOrBuilder
    public int getMetricKindValue() {
        return this.metricKind_;
    }

    @Override // com.google.api.MetricDescriptorOrBuilder
    public String getName() {
        return this.name_;
    }

    @Override // com.google.api.MetricDescriptorOrBuilder
    public ByteString getNameBytes() {
        return ByteString.copyFromUtf8(this.name_);
    }

    @Override // com.google.api.MetricDescriptorOrBuilder
    public String getType() {
        return this.type_;
    }

    @Override // com.google.api.MetricDescriptorOrBuilder
    public ByteString getTypeBytes() {
        return ByteString.copyFromUtf8(this.type_);
    }

    @Override // com.google.api.MetricDescriptorOrBuilder
    public String getUnit() {
        return this.unit_;
    }

    @Override // com.google.api.MetricDescriptorOrBuilder
    public ByteString getUnitBytes() {
        return ByteString.copyFromUtf8(this.unit_);
    }

    @Override // com.google.api.MetricDescriptorOrBuilder
    public ValueType getValueType() {
        ValueType forNumber = ValueType.forNumber(this.valueType_);
        if (forNumber == null) {
            return ValueType.UNRECOGNIZED;
        }
        return forNumber;
    }

    @Override // com.google.api.MetricDescriptorOrBuilder
    public int getValueTypeValue() {
        return this.valueType_;
    }

    @Override // com.google.api.MetricDescriptorOrBuilder
    public boolean hasMetadata() {
        if (this.metadata_ != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.f25427a[methodToInvoke.ordinal()]) {
            case 1:
                return new MetricDescriptor();
            case 2:
                return new Builder(null);
            case 3:
                return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\n\u0000\u0000\u0001\f\n\u0000\u0001\u0000\u0001Ȉ\u0002\u001b\u0003\f\u0004\f\u0005Ȉ\u0006Ȉ\u0007Ȉ\bȈ\n\t\f\f", new Object[]{"name_", "labels_", LabelDescriptor.class, "metricKind_", "valueType_", "unit_", "description_", "displayName_", "type_", "metadata_", "launchStage_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<MetricDescriptor> parser = PARSER;
                if (parser == null) {
                    synchronized (MetricDescriptor.class) {
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

    public static Builder newBuilder(MetricDescriptor metricDescriptor) {
        return DEFAULT_INSTANCE.r(metricDescriptor);
    }

    public static MetricDescriptor parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (MetricDescriptor) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MetricDescriptor parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (MetricDescriptor) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static MetricDescriptor parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (MetricDescriptor) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
    }

    public static MetricDescriptor parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (MetricDescriptor) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static MetricDescriptor parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (MetricDescriptor) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
    }

    public static MetricDescriptor parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (MetricDescriptor) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static MetricDescriptor parseFrom(InputStream inputStream) throws IOException {
        return (MetricDescriptor) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
    }

    public static MetricDescriptor parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (MetricDescriptor) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MetricDescriptor parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (MetricDescriptor) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
    }

    public static MetricDescriptor parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (MetricDescriptor) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
