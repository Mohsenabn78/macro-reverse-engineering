package com.google.api;

import com.google.api.LabelDescriptor;
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
public final class MonitoredResourceDescriptor extends GeneratedMessageLite<MonitoredResourceDescriptor, Builder> implements MonitoredResourceDescriptorOrBuilder {
    private static final MonitoredResourceDescriptor DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 3;
    public static final int DISPLAY_NAME_FIELD_NUMBER = 2;
    public static final int LABELS_FIELD_NUMBER = 4;
    public static final int LAUNCH_STAGE_FIELD_NUMBER = 7;
    public static final int NAME_FIELD_NUMBER = 5;
    private static volatile Parser<MonitoredResourceDescriptor> PARSER = null;
    public static final int TYPE_FIELD_NUMBER = 1;
    private int launchStage_;
    private String name_ = "";
    private String type_ = "";
    private String displayName_ = "";
    private String description_ = "";
    private Internal.ProtobufList<LabelDescriptor> labels_ = GeneratedMessageLite.y();

    /* renamed from: com.google.api.MonitoredResourceDescriptor$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f25438a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f25438a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f25438a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f25438a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f25438a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f25438a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f25438a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f25438a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<MonitoredResourceDescriptor, Builder> implements MonitoredResourceDescriptorOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllLabels(Iterable<? extends LabelDescriptor> iterable) {
            f();
            ((MonitoredResourceDescriptor) this.f33398b).B0(iterable);
            return this;
        }

        public Builder addLabels(LabelDescriptor labelDescriptor) {
            f();
            ((MonitoredResourceDescriptor) this.f33398b).D0(labelDescriptor);
            return this;
        }

        public Builder clearDescription() {
            f();
            ((MonitoredResourceDescriptor) this.f33398b).E0();
            return this;
        }

        public Builder clearDisplayName() {
            f();
            ((MonitoredResourceDescriptor) this.f33398b).F0();
            return this;
        }

        public Builder clearLabels() {
            f();
            ((MonitoredResourceDescriptor) this.f33398b).G0();
            return this;
        }

        public Builder clearLaunchStage() {
            f();
            ((MonitoredResourceDescriptor) this.f33398b).H0();
            return this;
        }

        public Builder clearName() {
            f();
            ((MonitoredResourceDescriptor) this.f33398b).I0();
            return this;
        }

        public Builder clearType() {
            f();
            ((MonitoredResourceDescriptor) this.f33398b).J0();
            return this;
        }

        @Override // com.google.api.MonitoredResourceDescriptorOrBuilder
        public String getDescription() {
            return ((MonitoredResourceDescriptor) this.f33398b).getDescription();
        }

        @Override // com.google.api.MonitoredResourceDescriptorOrBuilder
        public ByteString getDescriptionBytes() {
            return ((MonitoredResourceDescriptor) this.f33398b).getDescriptionBytes();
        }

        @Override // com.google.api.MonitoredResourceDescriptorOrBuilder
        public String getDisplayName() {
            return ((MonitoredResourceDescriptor) this.f33398b).getDisplayName();
        }

        @Override // com.google.api.MonitoredResourceDescriptorOrBuilder
        public ByteString getDisplayNameBytes() {
            return ((MonitoredResourceDescriptor) this.f33398b).getDisplayNameBytes();
        }

        @Override // com.google.api.MonitoredResourceDescriptorOrBuilder
        public LabelDescriptor getLabels(int i4) {
            return ((MonitoredResourceDescriptor) this.f33398b).getLabels(i4);
        }

        @Override // com.google.api.MonitoredResourceDescriptorOrBuilder
        public int getLabelsCount() {
            return ((MonitoredResourceDescriptor) this.f33398b).getLabelsCount();
        }

        @Override // com.google.api.MonitoredResourceDescriptorOrBuilder
        public List<LabelDescriptor> getLabelsList() {
            return Collections.unmodifiableList(((MonitoredResourceDescriptor) this.f33398b).getLabelsList());
        }

        @Override // com.google.api.MonitoredResourceDescriptorOrBuilder
        public LaunchStage getLaunchStage() {
            return ((MonitoredResourceDescriptor) this.f33398b).getLaunchStage();
        }

        @Override // com.google.api.MonitoredResourceDescriptorOrBuilder
        public int getLaunchStageValue() {
            return ((MonitoredResourceDescriptor) this.f33398b).getLaunchStageValue();
        }

        @Override // com.google.api.MonitoredResourceDescriptorOrBuilder
        public String getName() {
            return ((MonitoredResourceDescriptor) this.f33398b).getName();
        }

        @Override // com.google.api.MonitoredResourceDescriptorOrBuilder
        public ByteString getNameBytes() {
            return ((MonitoredResourceDescriptor) this.f33398b).getNameBytes();
        }

        @Override // com.google.api.MonitoredResourceDescriptorOrBuilder
        public String getType() {
            return ((MonitoredResourceDescriptor) this.f33398b).getType();
        }

        @Override // com.google.api.MonitoredResourceDescriptorOrBuilder
        public ByteString getTypeBytes() {
            return ((MonitoredResourceDescriptor) this.f33398b).getTypeBytes();
        }

        public Builder removeLabels(int i4) {
            f();
            ((MonitoredResourceDescriptor) this.f33398b).L0(i4);
            return this;
        }

        public Builder setDescription(String str) {
            f();
            ((MonitoredResourceDescriptor) this.f33398b).M0(str);
            return this;
        }

        public Builder setDescriptionBytes(ByteString byteString) {
            f();
            ((MonitoredResourceDescriptor) this.f33398b).N0(byteString);
            return this;
        }

        public Builder setDisplayName(String str) {
            f();
            ((MonitoredResourceDescriptor) this.f33398b).O0(str);
            return this;
        }

        public Builder setDisplayNameBytes(ByteString byteString) {
            f();
            ((MonitoredResourceDescriptor) this.f33398b).P0(byteString);
            return this;
        }

        public Builder setLabels(int i4, LabelDescriptor labelDescriptor) {
            f();
            ((MonitoredResourceDescriptor) this.f33398b).Q0(i4, labelDescriptor);
            return this;
        }

        public Builder setLaunchStage(LaunchStage launchStage) {
            f();
            ((MonitoredResourceDescriptor) this.f33398b).R0(launchStage);
            return this;
        }

        public Builder setLaunchStageValue(int i4) {
            f();
            ((MonitoredResourceDescriptor) this.f33398b).S0(i4);
            return this;
        }

        public Builder setName(String str) {
            f();
            ((MonitoredResourceDescriptor) this.f33398b).T0(str);
            return this;
        }

        public Builder setNameBytes(ByteString byteString) {
            f();
            ((MonitoredResourceDescriptor) this.f33398b).U0(byteString);
            return this;
        }

        public Builder setType(String str) {
            f();
            ((MonitoredResourceDescriptor) this.f33398b).V0(str);
            return this;
        }

        public Builder setTypeBytes(ByteString byteString) {
            f();
            ((MonitoredResourceDescriptor) this.f33398b).W0(byteString);
            return this;
        }

        private Builder() {
            super(MonitoredResourceDescriptor.DEFAULT_INSTANCE);
        }

        public Builder addLabels(int i4, LabelDescriptor labelDescriptor) {
            f();
            ((MonitoredResourceDescriptor) this.f33398b).C0(i4, labelDescriptor);
            return this;
        }

        public Builder setLabels(int i4, LabelDescriptor.Builder builder) {
            f();
            ((MonitoredResourceDescriptor) this.f33398b).Q0(i4, builder.build());
            return this;
        }

        public Builder addLabels(LabelDescriptor.Builder builder) {
            f();
            ((MonitoredResourceDescriptor) this.f33398b).D0(builder.build());
            return this;
        }

        public Builder addLabels(int i4, LabelDescriptor.Builder builder) {
            f();
            ((MonitoredResourceDescriptor) this.f33398b).C0(i4, builder.build());
            return this;
        }
    }

    static {
        MonitoredResourceDescriptor monitoredResourceDescriptor = new MonitoredResourceDescriptor();
        DEFAULT_INSTANCE = monitoredResourceDescriptor;
        GeneratedMessageLite.d0(MonitoredResourceDescriptor.class, monitoredResourceDescriptor);
    }

    private MonitoredResourceDescriptor() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B0(Iterable<? extends LabelDescriptor> iterable) {
        K0();
        AbstractMessageLite.a(iterable, this.labels_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C0(int i4, LabelDescriptor labelDescriptor) {
        labelDescriptor.getClass();
        K0();
        this.labels_.add(i4, labelDescriptor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D0(LabelDescriptor labelDescriptor) {
        labelDescriptor.getClass();
        K0();
        this.labels_.add(labelDescriptor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E0() {
        this.description_ = getDefaultInstance().getDescription();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F0() {
        this.displayName_ = getDefaultInstance().getDisplayName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G0() {
        this.labels_ = GeneratedMessageLite.y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H0() {
        this.launchStage_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I0() {
        this.name_ = getDefaultInstance().getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J0() {
        this.type_ = getDefaultInstance().getType();
    }

    private void K0() {
        Internal.ProtobufList<LabelDescriptor> protobufList = this.labels_;
        if (!protobufList.isModifiable()) {
            this.labels_ = GeneratedMessageLite.K(protobufList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L0(int i4) {
        K0();
        this.labels_.remove(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M0(String str) {
        str.getClass();
        this.description_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N0(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        this.description_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O0(String str) {
        str.getClass();
        this.displayName_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P0(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        this.displayName_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q0(int i4, LabelDescriptor labelDescriptor) {
        labelDescriptor.getClass();
        K0();
        this.labels_.set(i4, labelDescriptor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R0(LaunchStage launchStage) {
        this.launchStage_ = launchStage.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S0(int i4) {
        this.launchStage_ = i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T0(String str) {
        str.getClass();
        this.name_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U0(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        this.name_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V0(String str) {
        str.getClass();
        this.type_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W0(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        this.type_ = byteString.toStringUtf8();
    }

    public static MonitoredResourceDescriptor getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.q();
    }

    public static MonitoredResourceDescriptor parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (MonitoredResourceDescriptor) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
    }

    public static MonitoredResourceDescriptor parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (MonitoredResourceDescriptor) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<MonitoredResourceDescriptor> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    @Override // com.google.api.MonitoredResourceDescriptorOrBuilder
    public String getDescription() {
        return this.description_;
    }

    @Override // com.google.api.MonitoredResourceDescriptorOrBuilder
    public ByteString getDescriptionBytes() {
        return ByteString.copyFromUtf8(this.description_);
    }

    @Override // com.google.api.MonitoredResourceDescriptorOrBuilder
    public String getDisplayName() {
        return this.displayName_;
    }

    @Override // com.google.api.MonitoredResourceDescriptorOrBuilder
    public ByteString getDisplayNameBytes() {
        return ByteString.copyFromUtf8(this.displayName_);
    }

    @Override // com.google.api.MonitoredResourceDescriptorOrBuilder
    public LabelDescriptor getLabels(int i4) {
        return this.labels_.get(i4);
    }

    @Override // com.google.api.MonitoredResourceDescriptorOrBuilder
    public int getLabelsCount() {
        return this.labels_.size();
    }

    @Override // com.google.api.MonitoredResourceDescriptorOrBuilder
    public List<LabelDescriptor> getLabelsList() {
        return this.labels_;
    }

    public LabelDescriptorOrBuilder getLabelsOrBuilder(int i4) {
        return this.labels_.get(i4);
    }

    public List<? extends LabelDescriptorOrBuilder> getLabelsOrBuilderList() {
        return this.labels_;
    }

    @Override // com.google.api.MonitoredResourceDescriptorOrBuilder
    public LaunchStage getLaunchStage() {
        LaunchStage forNumber = LaunchStage.forNumber(this.launchStage_);
        if (forNumber == null) {
            return LaunchStage.UNRECOGNIZED;
        }
        return forNumber;
    }

    @Override // com.google.api.MonitoredResourceDescriptorOrBuilder
    public int getLaunchStageValue() {
        return this.launchStage_;
    }

    @Override // com.google.api.MonitoredResourceDescriptorOrBuilder
    public String getName() {
        return this.name_;
    }

    @Override // com.google.api.MonitoredResourceDescriptorOrBuilder
    public ByteString getNameBytes() {
        return ByteString.copyFromUtf8(this.name_);
    }

    @Override // com.google.api.MonitoredResourceDescriptorOrBuilder
    public String getType() {
        return this.type_;
    }

    @Override // com.google.api.MonitoredResourceDescriptorOrBuilder
    public ByteString getTypeBytes() {
        return ByteString.copyFromUtf8(this.type_);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.f25438a[methodToInvoke.ordinal()]) {
            case 1:
                return new MonitoredResourceDescriptor();
            case 2:
                return new Builder(null);
            case 3:
                return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0000\u0001\u0007\u0006\u0000\u0001\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004\u001b\u0005Ȉ\u0007\f", new Object[]{"type_", "displayName_", "description_", "labels_", LabelDescriptor.class, "name_", "launchStage_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<MonitoredResourceDescriptor> parser = PARSER;
                if (parser == null) {
                    synchronized (MonitoredResourceDescriptor.class) {
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

    public static Builder newBuilder(MonitoredResourceDescriptor monitoredResourceDescriptor) {
        return DEFAULT_INSTANCE.r(monitoredResourceDescriptor);
    }

    public static MonitoredResourceDescriptor parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (MonitoredResourceDescriptor) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MonitoredResourceDescriptor parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (MonitoredResourceDescriptor) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static MonitoredResourceDescriptor parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (MonitoredResourceDescriptor) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
    }

    public static MonitoredResourceDescriptor parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (MonitoredResourceDescriptor) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static MonitoredResourceDescriptor parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (MonitoredResourceDescriptor) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
    }

    public static MonitoredResourceDescriptor parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (MonitoredResourceDescriptor) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static MonitoredResourceDescriptor parseFrom(InputStream inputStream) throws IOException {
        return (MonitoredResourceDescriptor) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
    }

    public static MonitoredResourceDescriptor parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (MonitoredResourceDescriptor) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MonitoredResourceDescriptor parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (MonitoredResourceDescriptor) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
    }

    public static MonitoredResourceDescriptor parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (MonitoredResourceDescriptor) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
