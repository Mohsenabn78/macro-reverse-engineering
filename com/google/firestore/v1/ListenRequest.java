package com.google.firestore.v1;

import com.google.firestore.v1.Target;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.Parser;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes5.dex */
public final class ListenRequest extends GeneratedMessageLite<ListenRequest, Builder> implements ListenRequestOrBuilder {
    public static final int ADD_TARGET_FIELD_NUMBER = 2;
    public static final int DATABASE_FIELD_NUMBER = 1;
    private static final ListenRequest DEFAULT_INSTANCE;
    public static final int LABELS_FIELD_NUMBER = 4;
    private static volatile Parser<ListenRequest> PARSER = null;
    public static final int REMOVE_TARGET_FIELD_NUMBER = 3;
    private Object targetChange_;
    private int targetChangeCase_ = 0;
    private MapFieldLite<String, String> labels_ = MapFieldLite.emptyMapField();
    private String database_ = "";

    /* renamed from: com.google.firestore.v1.ListenRequest$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f32485a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f32485a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32485a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32485a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32485a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f32485a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f32485a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f32485a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<ListenRequest, Builder> implements ListenRequestOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearAddTarget() {
            f();
            ((ListenRequest) this.f33398b).q0();
            return this;
        }

        public Builder clearDatabase() {
            f();
            ((ListenRequest) this.f33398b).r0();
            return this;
        }

        public Builder clearLabels() {
            f();
            ((ListenRequest) this.f33398b).u0().clear();
            return this;
        }

        public Builder clearRemoveTarget() {
            f();
            ((ListenRequest) this.f33398b).s0();
            return this;
        }

        public Builder clearTargetChange() {
            f();
            ((ListenRequest) this.f33398b).t0();
            return this;
        }

        @Override // com.google.firestore.v1.ListenRequestOrBuilder
        public boolean containsLabels(String str) {
            str.getClass();
            return ((ListenRequest) this.f33398b).getLabelsMap().containsKey(str);
        }

        @Override // com.google.firestore.v1.ListenRequestOrBuilder
        public Target getAddTarget() {
            return ((ListenRequest) this.f33398b).getAddTarget();
        }

        @Override // com.google.firestore.v1.ListenRequestOrBuilder
        public String getDatabase() {
            return ((ListenRequest) this.f33398b).getDatabase();
        }

        @Override // com.google.firestore.v1.ListenRequestOrBuilder
        public ByteString getDatabaseBytes() {
            return ((ListenRequest) this.f33398b).getDatabaseBytes();
        }

        @Override // com.google.firestore.v1.ListenRequestOrBuilder
        @Deprecated
        public Map<String, String> getLabels() {
            return getLabelsMap();
        }

        @Override // com.google.firestore.v1.ListenRequestOrBuilder
        public int getLabelsCount() {
            return ((ListenRequest) this.f33398b).getLabelsMap().size();
        }

        @Override // com.google.firestore.v1.ListenRequestOrBuilder
        public Map<String, String> getLabelsMap() {
            return Collections.unmodifiableMap(((ListenRequest) this.f33398b).getLabelsMap());
        }

        @Override // com.google.firestore.v1.ListenRequestOrBuilder
        public String getLabelsOrDefault(String str, String str2) {
            str.getClass();
            Map<String, String> labelsMap = ((ListenRequest) this.f33398b).getLabelsMap();
            if (labelsMap.containsKey(str)) {
                return labelsMap.get(str);
            }
            return str2;
        }

        @Override // com.google.firestore.v1.ListenRequestOrBuilder
        public String getLabelsOrThrow(String str) {
            str.getClass();
            Map<String, String> labelsMap = ((ListenRequest) this.f33398b).getLabelsMap();
            if (labelsMap.containsKey(str)) {
                return labelsMap.get(str);
            }
            throw new IllegalArgumentException();
        }

        @Override // com.google.firestore.v1.ListenRequestOrBuilder
        public int getRemoveTarget() {
            return ((ListenRequest) this.f33398b).getRemoveTarget();
        }

        @Override // com.google.firestore.v1.ListenRequestOrBuilder
        public TargetChangeCase getTargetChangeCase() {
            return ((ListenRequest) this.f33398b).getTargetChangeCase();
        }

        @Override // com.google.firestore.v1.ListenRequestOrBuilder
        public boolean hasAddTarget() {
            return ((ListenRequest) this.f33398b).hasAddTarget();
        }

        @Override // com.google.firestore.v1.ListenRequestOrBuilder
        public boolean hasRemoveTarget() {
            return ((ListenRequest) this.f33398b).hasRemoveTarget();
        }

        public Builder mergeAddTarget(Target target) {
            f();
            ((ListenRequest) this.f33398b).x0(target);
            return this;
        }

        public Builder putAllLabels(Map<String, String> map) {
            f();
            ((ListenRequest) this.f33398b).u0().putAll(map);
            return this;
        }

        public Builder putLabels(String str, String str2) {
            str.getClass();
            str2.getClass();
            f();
            ((ListenRequest) this.f33398b).u0().put(str, str2);
            return this;
        }

        public Builder removeLabels(String str) {
            str.getClass();
            f();
            ((ListenRequest) this.f33398b).u0().remove(str);
            return this;
        }

        public Builder setAddTarget(Target target) {
            f();
            ((ListenRequest) this.f33398b).y0(target);
            return this;
        }

        public Builder setDatabase(String str) {
            f();
            ((ListenRequest) this.f33398b).z0(str);
            return this;
        }

        public Builder setDatabaseBytes(ByteString byteString) {
            f();
            ((ListenRequest) this.f33398b).A0(byteString);
            return this;
        }

        public Builder setRemoveTarget(int i4) {
            f();
            ((ListenRequest) this.f33398b).B0(i4);
            return this;
        }

        private Builder() {
            super(ListenRequest.DEFAULT_INSTANCE);
        }

        public Builder setAddTarget(Target.Builder builder) {
            f();
            ((ListenRequest) this.f33398b).y0(builder.build());
            return this;
        }
    }

    /* loaded from: classes5.dex */
    private static final class LabelsDefaultEntryHolder {

        /* renamed from: a  reason: collision with root package name */
        static final MapEntryLite<String, String> f32486a;

        static {
            WireFormat.FieldType fieldType = WireFormat.FieldType.STRING;
            f32486a = MapEntryLite.newDefaultInstance(fieldType, "", fieldType, "");
        }

        private LabelsDefaultEntryHolder() {
        }
    }

    /* loaded from: classes5.dex */
    public enum TargetChangeCase {
        ADD_TARGET(2),
        REMOVE_TARGET(3),
        TARGETCHANGE_NOT_SET(0);
        
        private final int value;

        TargetChangeCase(int i4) {
            this.value = i4;
        }

        public static TargetChangeCase forNumber(int i4) {
            if (i4 != 0) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        return null;
                    }
                    return REMOVE_TARGET;
                }
                return ADD_TARGET;
            }
            return TARGETCHANGE_NOT_SET;
        }

        public int getNumber() {
            return this.value;
        }

        @Deprecated
        public static TargetChangeCase valueOf(int i4) {
            return forNumber(i4);
        }
    }

    static {
        ListenRequest listenRequest = new ListenRequest();
        DEFAULT_INSTANCE = listenRequest;
        GeneratedMessageLite.d0(ListenRequest.class, listenRequest);
    }

    private ListenRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        this.database_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B0(int i4) {
        this.targetChangeCase_ = 3;
        this.targetChange_ = Integer.valueOf(i4);
    }

    public static ListenRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.q();
    }

    public static ListenRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (ListenRequest) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
    }

    public static ListenRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (ListenRequest) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<ListenRequest> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q0() {
        if (this.targetChangeCase_ == 2) {
            this.targetChangeCase_ = 0;
            this.targetChange_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0() {
        this.database_ = getDefaultInstance().getDatabase();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0() {
        if (this.targetChangeCase_ == 3) {
            this.targetChangeCase_ = 0;
            this.targetChange_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t0() {
        this.targetChangeCase_ = 0;
        this.targetChange_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> u0() {
        return w0();
    }

    private MapFieldLite<String, String> v0() {
        return this.labels_;
    }

    private MapFieldLite<String, String> w0() {
        if (!this.labels_.isMutable()) {
            this.labels_ = this.labels_.mutableCopy();
        }
        return this.labels_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0(Target target) {
        target.getClass();
        if (this.targetChangeCase_ == 2 && this.targetChange_ != Target.getDefaultInstance()) {
            this.targetChange_ = Target.newBuilder((Target) this.targetChange_).mergeFrom((Target.Builder) target).buildPartial();
        } else {
            this.targetChange_ = target;
        }
        this.targetChangeCase_ = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0(Target target) {
        target.getClass();
        this.targetChange_ = target;
        this.targetChangeCase_ = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0(String str) {
        str.getClass();
        this.database_ = str;
    }

    @Override // com.google.firestore.v1.ListenRequestOrBuilder
    public boolean containsLabels(String str) {
        str.getClass();
        return v0().containsKey(str);
    }

    @Override // com.google.firestore.v1.ListenRequestOrBuilder
    public Target getAddTarget() {
        if (this.targetChangeCase_ == 2) {
            return (Target) this.targetChange_;
        }
        return Target.getDefaultInstance();
    }

    @Override // com.google.firestore.v1.ListenRequestOrBuilder
    public String getDatabase() {
        return this.database_;
    }

    @Override // com.google.firestore.v1.ListenRequestOrBuilder
    public ByteString getDatabaseBytes() {
        return ByteString.copyFromUtf8(this.database_);
    }

    @Override // com.google.firestore.v1.ListenRequestOrBuilder
    @Deprecated
    public Map<String, String> getLabels() {
        return getLabelsMap();
    }

    @Override // com.google.firestore.v1.ListenRequestOrBuilder
    public int getLabelsCount() {
        return v0().size();
    }

    @Override // com.google.firestore.v1.ListenRequestOrBuilder
    public Map<String, String> getLabelsMap() {
        return Collections.unmodifiableMap(v0());
    }

    @Override // com.google.firestore.v1.ListenRequestOrBuilder
    public String getLabelsOrDefault(String str, String str2) {
        str.getClass();
        MapFieldLite<String, String> v02 = v0();
        if (v02.containsKey(str)) {
            return v02.get(str);
        }
        return str2;
    }

    @Override // com.google.firestore.v1.ListenRequestOrBuilder
    public String getLabelsOrThrow(String str) {
        str.getClass();
        MapFieldLite<String, String> v02 = v0();
        if (v02.containsKey(str)) {
            return v02.get(str);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.firestore.v1.ListenRequestOrBuilder
    public int getRemoveTarget() {
        if (this.targetChangeCase_ == 3) {
            return ((Integer) this.targetChange_).intValue();
        }
        return 0;
    }

    @Override // com.google.firestore.v1.ListenRequestOrBuilder
    public TargetChangeCase getTargetChangeCase() {
        return TargetChangeCase.forNumber(this.targetChangeCase_);
    }

    @Override // com.google.firestore.v1.ListenRequestOrBuilder
    public boolean hasAddTarget() {
        if (this.targetChangeCase_ == 2) {
            return true;
        }
        return false;
    }

    @Override // com.google.firestore.v1.ListenRequestOrBuilder
    public boolean hasRemoveTarget() {
        if (this.targetChangeCase_ == 3) {
            return true;
        }
        return false;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.f32485a[methodToInvoke.ordinal()]) {
            case 1:
                return new ListenRequest();
            case 2:
                return new Builder(null);
            case 3:
                return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0004\u0001\u0000\u0001\u0004\u0004\u0001\u0000\u0000\u0001Ȉ\u0002<\u0000\u00037\u0000\u00042", new Object[]{"targetChange_", "targetChangeCase_", "database_", Target.class, "labels_", LabelsDefaultEntryHolder.f32486a});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<ListenRequest> parser = PARSER;
                if (parser == null) {
                    synchronized (ListenRequest.class) {
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

    public static Builder newBuilder(ListenRequest listenRequest) {
        return DEFAULT_INSTANCE.r(listenRequest);
    }

    public static ListenRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ListenRequest) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ListenRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ListenRequest) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static ListenRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (ListenRequest) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
    }

    public static ListenRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ListenRequest) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static ListenRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (ListenRequest) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
    }

    public static ListenRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ListenRequest) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static ListenRequest parseFrom(InputStream inputStream) throws IOException {
        return (ListenRequest) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
    }

    public static ListenRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ListenRequest) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ListenRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (ListenRequest) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
    }

    public static ListenRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ListenRequest) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
