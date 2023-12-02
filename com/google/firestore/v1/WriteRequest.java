package com.google.firestore.v1;

import com.google.firestore.v1.Write;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.Parser;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public final class WriteRequest extends GeneratedMessageLite<WriteRequest, Builder> implements WriteRequestOrBuilder {
    public static final int DATABASE_FIELD_NUMBER = 1;
    private static final WriteRequest DEFAULT_INSTANCE;
    public static final int LABELS_FIELD_NUMBER = 5;
    private static volatile Parser<WriteRequest> PARSER = null;
    public static final int STREAM_ID_FIELD_NUMBER = 2;
    public static final int STREAM_TOKEN_FIELD_NUMBER = 4;
    public static final int WRITES_FIELD_NUMBER = 3;
    private MapFieldLite<String, String> labels_ = MapFieldLite.emptyMapField();
    private String database_ = "";
    private String streamId_ = "";
    private Internal.ProtobufList<Write> writes_ = GeneratedMessageLite.y();
    private ByteString streamToken_ = ByteString.EMPTY;

    /* renamed from: com.google.firestore.v1.WriteRequest$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f32537a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f32537a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32537a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32537a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32537a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f32537a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f32537a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f32537a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<WriteRequest, Builder> implements WriteRequestOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllWrites(Iterable<? extends Write> iterable) {
            f();
            ((WriteRequest) this.f33398b).v0(iterable);
            return this;
        }

        public Builder addWrites(Write write) {
            f();
            ((WriteRequest) this.f33398b).x0(write);
            return this;
        }

        public Builder clearDatabase() {
            f();
            ((WriteRequest) this.f33398b).y0();
            return this;
        }

        public Builder clearLabels() {
            f();
            ((WriteRequest) this.f33398b).D0().clear();
            return this;
        }

        public Builder clearStreamId() {
            f();
            ((WriteRequest) this.f33398b).z0();
            return this;
        }

        public Builder clearStreamToken() {
            f();
            ((WriteRequest) this.f33398b).A0();
            return this;
        }

        public Builder clearWrites() {
            f();
            ((WriteRequest) this.f33398b).B0();
            return this;
        }

        @Override // com.google.firestore.v1.WriteRequestOrBuilder
        public boolean containsLabels(String str) {
            str.getClass();
            return ((WriteRequest) this.f33398b).getLabelsMap().containsKey(str);
        }

        @Override // com.google.firestore.v1.WriteRequestOrBuilder
        public String getDatabase() {
            return ((WriteRequest) this.f33398b).getDatabase();
        }

        @Override // com.google.firestore.v1.WriteRequestOrBuilder
        public ByteString getDatabaseBytes() {
            return ((WriteRequest) this.f33398b).getDatabaseBytes();
        }

        @Override // com.google.firestore.v1.WriteRequestOrBuilder
        @Deprecated
        public Map<String, String> getLabels() {
            return getLabelsMap();
        }

        @Override // com.google.firestore.v1.WriteRequestOrBuilder
        public int getLabelsCount() {
            return ((WriteRequest) this.f33398b).getLabelsMap().size();
        }

        @Override // com.google.firestore.v1.WriteRequestOrBuilder
        public Map<String, String> getLabelsMap() {
            return Collections.unmodifiableMap(((WriteRequest) this.f33398b).getLabelsMap());
        }

        @Override // com.google.firestore.v1.WriteRequestOrBuilder
        public String getLabelsOrDefault(String str, String str2) {
            str.getClass();
            Map<String, String> labelsMap = ((WriteRequest) this.f33398b).getLabelsMap();
            if (labelsMap.containsKey(str)) {
                return labelsMap.get(str);
            }
            return str2;
        }

        @Override // com.google.firestore.v1.WriteRequestOrBuilder
        public String getLabelsOrThrow(String str) {
            str.getClass();
            Map<String, String> labelsMap = ((WriteRequest) this.f33398b).getLabelsMap();
            if (labelsMap.containsKey(str)) {
                return labelsMap.get(str);
            }
            throw new IllegalArgumentException();
        }

        @Override // com.google.firestore.v1.WriteRequestOrBuilder
        public String getStreamId() {
            return ((WriteRequest) this.f33398b).getStreamId();
        }

        @Override // com.google.firestore.v1.WriteRequestOrBuilder
        public ByteString getStreamIdBytes() {
            return ((WriteRequest) this.f33398b).getStreamIdBytes();
        }

        @Override // com.google.firestore.v1.WriteRequestOrBuilder
        public ByteString getStreamToken() {
            return ((WriteRequest) this.f33398b).getStreamToken();
        }

        @Override // com.google.firestore.v1.WriteRequestOrBuilder
        public Write getWrites(int i4) {
            return ((WriteRequest) this.f33398b).getWrites(i4);
        }

        @Override // com.google.firestore.v1.WriteRequestOrBuilder
        public int getWritesCount() {
            return ((WriteRequest) this.f33398b).getWritesCount();
        }

        @Override // com.google.firestore.v1.WriteRequestOrBuilder
        public List<Write> getWritesList() {
            return Collections.unmodifiableList(((WriteRequest) this.f33398b).getWritesList());
        }

        public Builder putAllLabels(Map<String, String> map) {
            f();
            ((WriteRequest) this.f33398b).D0().putAll(map);
            return this;
        }

        public Builder putLabels(String str, String str2) {
            str.getClass();
            str2.getClass();
            f();
            ((WriteRequest) this.f33398b).D0().put(str, str2);
            return this;
        }

        public Builder removeLabels(String str) {
            str.getClass();
            f();
            ((WriteRequest) this.f33398b).D0().remove(str);
            return this;
        }

        public Builder removeWrites(int i4) {
            f();
            ((WriteRequest) this.f33398b).G0(i4);
            return this;
        }

        public Builder setDatabase(String str) {
            f();
            ((WriteRequest) this.f33398b).H0(str);
            return this;
        }

        public Builder setDatabaseBytes(ByteString byteString) {
            f();
            ((WriteRequest) this.f33398b).I0(byteString);
            return this;
        }

        public Builder setStreamId(String str) {
            f();
            ((WriteRequest) this.f33398b).J0(str);
            return this;
        }

        public Builder setStreamIdBytes(ByteString byteString) {
            f();
            ((WriteRequest) this.f33398b).K0(byteString);
            return this;
        }

        public Builder setStreamToken(ByteString byteString) {
            f();
            ((WriteRequest) this.f33398b).L0(byteString);
            return this;
        }

        public Builder setWrites(int i4, Write write) {
            f();
            ((WriteRequest) this.f33398b).M0(i4, write);
            return this;
        }

        private Builder() {
            super(WriteRequest.DEFAULT_INSTANCE);
        }

        public Builder addWrites(int i4, Write write) {
            f();
            ((WriteRequest) this.f33398b).w0(i4, write);
            return this;
        }

        public Builder setWrites(int i4, Write.Builder builder) {
            f();
            ((WriteRequest) this.f33398b).M0(i4, builder.build());
            return this;
        }

        public Builder addWrites(Write.Builder builder) {
            f();
            ((WriteRequest) this.f33398b).x0(builder.build());
            return this;
        }

        public Builder addWrites(int i4, Write.Builder builder) {
            f();
            ((WriteRequest) this.f33398b).w0(i4, builder.build());
            return this;
        }
    }

    /* loaded from: classes5.dex */
    private static final class LabelsDefaultEntryHolder {

        /* renamed from: a  reason: collision with root package name */
        static final MapEntryLite<String, String> f32538a;

        static {
            WireFormat.FieldType fieldType = WireFormat.FieldType.STRING;
            f32538a = MapEntryLite.newDefaultInstance(fieldType, "", fieldType, "");
        }

        private LabelsDefaultEntryHolder() {
        }
    }

    static {
        WriteRequest writeRequest = new WriteRequest();
        DEFAULT_INSTANCE = writeRequest;
        GeneratedMessageLite.d0(WriteRequest.class, writeRequest);
    }

    private WriteRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0() {
        this.streamToken_ = getDefaultInstance().getStreamToken();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B0() {
        this.writes_ = GeneratedMessageLite.y();
    }

    private void C0() {
        Internal.ProtobufList<Write> protobufList = this.writes_;
        if (!protobufList.isModifiable()) {
            this.writes_ = GeneratedMessageLite.K(protobufList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> D0() {
        return F0();
    }

    private MapFieldLite<String, String> E0() {
        return this.labels_;
    }

    private MapFieldLite<String, String> F0() {
        if (!this.labels_.isMutable()) {
            this.labels_ = this.labels_.mutableCopy();
        }
        return this.labels_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G0(int i4) {
        C0();
        this.writes_.remove(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H0(String str) {
        str.getClass();
        this.database_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I0(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        this.database_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J0(String str) {
        str.getClass();
        this.streamId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K0(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        this.streamId_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L0(ByteString byteString) {
        byteString.getClass();
        this.streamToken_ = byteString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M0(int i4, Write write) {
        write.getClass();
        C0();
        this.writes_.set(i4, write);
    }

    public static WriteRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.q();
    }

    public static WriteRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (WriteRequest) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
    }

    public static WriteRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (WriteRequest) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<WriteRequest> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v0(Iterable<? extends Write> iterable) {
        C0();
        AbstractMessageLite.a(iterable, this.writes_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w0(int i4, Write write) {
        write.getClass();
        C0();
        this.writes_.add(i4, write);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0(Write write) {
        write.getClass();
        C0();
        this.writes_.add(write);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0() {
        this.database_ = getDefaultInstance().getDatabase();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0() {
        this.streamId_ = getDefaultInstance().getStreamId();
    }

    @Override // com.google.firestore.v1.WriteRequestOrBuilder
    public boolean containsLabels(String str) {
        str.getClass();
        return E0().containsKey(str);
    }

    @Override // com.google.firestore.v1.WriteRequestOrBuilder
    public String getDatabase() {
        return this.database_;
    }

    @Override // com.google.firestore.v1.WriteRequestOrBuilder
    public ByteString getDatabaseBytes() {
        return ByteString.copyFromUtf8(this.database_);
    }

    @Override // com.google.firestore.v1.WriteRequestOrBuilder
    @Deprecated
    public Map<String, String> getLabels() {
        return getLabelsMap();
    }

    @Override // com.google.firestore.v1.WriteRequestOrBuilder
    public int getLabelsCount() {
        return E0().size();
    }

    @Override // com.google.firestore.v1.WriteRequestOrBuilder
    public Map<String, String> getLabelsMap() {
        return Collections.unmodifiableMap(E0());
    }

    @Override // com.google.firestore.v1.WriteRequestOrBuilder
    public String getLabelsOrDefault(String str, String str2) {
        str.getClass();
        MapFieldLite<String, String> E0 = E0();
        if (E0.containsKey(str)) {
            return E0.get(str);
        }
        return str2;
    }

    @Override // com.google.firestore.v1.WriteRequestOrBuilder
    public String getLabelsOrThrow(String str) {
        str.getClass();
        MapFieldLite<String, String> E0 = E0();
        if (E0.containsKey(str)) {
            return E0.get(str);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.firestore.v1.WriteRequestOrBuilder
    public String getStreamId() {
        return this.streamId_;
    }

    @Override // com.google.firestore.v1.WriteRequestOrBuilder
    public ByteString getStreamIdBytes() {
        return ByteString.copyFromUtf8(this.streamId_);
    }

    @Override // com.google.firestore.v1.WriteRequestOrBuilder
    public ByteString getStreamToken() {
        return this.streamToken_;
    }

    @Override // com.google.firestore.v1.WriteRequestOrBuilder
    public Write getWrites(int i4) {
        return this.writes_.get(i4);
    }

    @Override // com.google.firestore.v1.WriteRequestOrBuilder
    public int getWritesCount() {
        return this.writes_.size();
    }

    @Override // com.google.firestore.v1.WriteRequestOrBuilder
    public List<Write> getWritesList() {
        return this.writes_;
    }

    public WriteOrBuilder getWritesOrBuilder(int i4) {
        return this.writes_.get(i4);
    }

    public List<? extends WriteOrBuilder> getWritesOrBuilderList() {
        return this.writes_;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.f32537a[methodToInvoke.ordinal()]) {
            case 1:
                return new WriteRequest();
            case 2:
                return new Builder(null);
            case 3:
                return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0001\u0001\u0000\u0001Ȉ\u0002Ȉ\u0003\u001b\u0004\n\u00052", new Object[]{"database_", "streamId_", "writes_", Write.class, "streamToken_", "labels_", LabelsDefaultEntryHolder.f32538a});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<WriteRequest> parser = PARSER;
                if (parser == null) {
                    synchronized (WriteRequest.class) {
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

    public static Builder newBuilder(WriteRequest writeRequest) {
        return DEFAULT_INSTANCE.r(writeRequest);
    }

    public static WriteRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (WriteRequest) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static WriteRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (WriteRequest) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static WriteRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (WriteRequest) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
    }

    public static WriteRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (WriteRequest) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static WriteRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (WriteRequest) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
    }

    public static WriteRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (WriteRequest) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static WriteRequest parseFrom(InputStream inputStream) throws IOException {
        return (WriteRequest) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
    }

    public static WriteRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (WriteRequest) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static WriteRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (WriteRequest) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
    }

    public static WriteRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (WriteRequest) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
