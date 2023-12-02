package com.google.firestore.v1;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.Parser;
import com.google.protobuf.Timestamp;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes5.dex */
public final class Document extends GeneratedMessageLite<Document, Builder> implements DocumentOrBuilder {
    public static final int CREATE_TIME_FIELD_NUMBER = 3;
    private static final Document DEFAULT_INSTANCE;
    public static final int FIELDS_FIELD_NUMBER = 2;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile Parser<Document> PARSER = null;
    public static final int UPDATE_TIME_FIELD_NUMBER = 4;
    private Timestamp createTime_;
    private MapFieldLite<String, Value> fields_ = MapFieldLite.emptyMapField();
    private String name_ = "";
    private Timestamp updateTime_;

    /* renamed from: com.google.firestore.v1.Document$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f32449a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f32449a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32449a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32449a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32449a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f32449a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f32449a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f32449a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<Document, Builder> implements DocumentOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearCreateTime() {
            f();
            ((Document) this.f33398b).q0();
            return this;
        }

        public Builder clearFields() {
            f();
            ((Document) this.f33398b).t0().clear();
            return this;
        }

        public Builder clearName() {
            f();
            ((Document) this.f33398b).r0();
            return this;
        }

        public Builder clearUpdateTime() {
            f();
            ((Document) this.f33398b).s0();
            return this;
        }

        @Override // com.google.firestore.v1.DocumentOrBuilder
        public boolean containsFields(String str) {
            str.getClass();
            return ((Document) this.f33398b).getFieldsMap().containsKey(str);
        }

        @Override // com.google.firestore.v1.DocumentOrBuilder
        public Timestamp getCreateTime() {
            return ((Document) this.f33398b).getCreateTime();
        }

        @Override // com.google.firestore.v1.DocumentOrBuilder
        @Deprecated
        public Map<String, Value> getFields() {
            return getFieldsMap();
        }

        @Override // com.google.firestore.v1.DocumentOrBuilder
        public int getFieldsCount() {
            return ((Document) this.f33398b).getFieldsMap().size();
        }

        @Override // com.google.firestore.v1.DocumentOrBuilder
        public Map<String, Value> getFieldsMap() {
            return Collections.unmodifiableMap(((Document) this.f33398b).getFieldsMap());
        }

        @Override // com.google.firestore.v1.DocumentOrBuilder
        public Value getFieldsOrDefault(String str, Value value) {
            str.getClass();
            Map<String, Value> fieldsMap = ((Document) this.f33398b).getFieldsMap();
            if (fieldsMap.containsKey(str)) {
                return fieldsMap.get(str);
            }
            return value;
        }

        @Override // com.google.firestore.v1.DocumentOrBuilder
        public Value getFieldsOrThrow(String str) {
            str.getClass();
            Map<String, Value> fieldsMap = ((Document) this.f33398b).getFieldsMap();
            if (fieldsMap.containsKey(str)) {
                return fieldsMap.get(str);
            }
            throw new IllegalArgumentException();
        }

        @Override // com.google.firestore.v1.DocumentOrBuilder
        public String getName() {
            return ((Document) this.f33398b).getName();
        }

        @Override // com.google.firestore.v1.DocumentOrBuilder
        public ByteString getNameBytes() {
            return ((Document) this.f33398b).getNameBytes();
        }

        @Override // com.google.firestore.v1.DocumentOrBuilder
        public Timestamp getUpdateTime() {
            return ((Document) this.f33398b).getUpdateTime();
        }

        @Override // com.google.firestore.v1.DocumentOrBuilder
        public boolean hasCreateTime() {
            return ((Document) this.f33398b).hasCreateTime();
        }

        @Override // com.google.firestore.v1.DocumentOrBuilder
        public boolean hasUpdateTime() {
            return ((Document) this.f33398b).hasUpdateTime();
        }

        public Builder mergeCreateTime(Timestamp timestamp) {
            f();
            ((Document) this.f33398b).w0(timestamp);
            return this;
        }

        public Builder mergeUpdateTime(Timestamp timestamp) {
            f();
            ((Document) this.f33398b).x0(timestamp);
            return this;
        }

        public Builder putAllFields(Map<String, Value> map) {
            f();
            ((Document) this.f33398b).t0().putAll(map);
            return this;
        }

        public Builder putFields(String str, Value value) {
            str.getClass();
            value.getClass();
            f();
            ((Document) this.f33398b).t0().put(str, value);
            return this;
        }

        public Builder removeFields(String str) {
            str.getClass();
            f();
            ((Document) this.f33398b).t0().remove(str);
            return this;
        }

        public Builder setCreateTime(Timestamp timestamp) {
            f();
            ((Document) this.f33398b).y0(timestamp);
            return this;
        }

        public Builder setName(String str) {
            f();
            ((Document) this.f33398b).z0(str);
            return this;
        }

        public Builder setNameBytes(ByteString byteString) {
            f();
            ((Document) this.f33398b).A0(byteString);
            return this;
        }

        public Builder setUpdateTime(Timestamp timestamp) {
            f();
            ((Document) this.f33398b).B0(timestamp);
            return this;
        }

        private Builder() {
            super(Document.DEFAULT_INSTANCE);
        }

        public Builder setCreateTime(Timestamp.Builder builder) {
            f();
            ((Document) this.f33398b).y0(builder.build());
            return this;
        }

        public Builder setUpdateTime(Timestamp.Builder builder) {
            f();
            ((Document) this.f33398b).B0(builder.build());
            return this;
        }
    }

    /* loaded from: classes5.dex */
    private static final class FieldsDefaultEntryHolder {

        /* renamed from: a  reason: collision with root package name */
        static final MapEntryLite<String, Value> f32450a = MapEntryLite.newDefaultInstance(WireFormat.FieldType.STRING, "", WireFormat.FieldType.MESSAGE, Value.getDefaultInstance());

        private FieldsDefaultEntryHolder() {
        }
    }

    static {
        Document document = new Document();
        DEFAULT_INSTANCE = document;
        GeneratedMessageLite.d0(Document.class, document);
    }

    private Document() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        this.name_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B0(Timestamp timestamp) {
        timestamp.getClass();
        this.updateTime_ = timestamp;
    }

    public static Document getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.q();
    }

    public static Document parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Document) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
    }

    public static Document parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (Document) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Document> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q0() {
        this.createTime_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0() {
        this.name_ = getDefaultInstance().getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0() {
        this.updateTime_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, Value> t0() {
        return v0();
    }

    private MapFieldLite<String, Value> u0() {
        return this.fields_;
    }

    private MapFieldLite<String, Value> v0() {
        if (!this.fields_.isMutable()) {
            this.fields_ = this.fields_.mutableCopy();
        }
        return this.fields_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w0(Timestamp timestamp) {
        timestamp.getClass();
        Timestamp timestamp2 = this.createTime_;
        if (timestamp2 != null && timestamp2 != Timestamp.getDefaultInstance()) {
            this.createTime_ = Timestamp.newBuilder(this.createTime_).mergeFrom((Timestamp.Builder) timestamp).buildPartial();
        } else {
            this.createTime_ = timestamp;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0(Timestamp timestamp) {
        timestamp.getClass();
        Timestamp timestamp2 = this.updateTime_;
        if (timestamp2 != null && timestamp2 != Timestamp.getDefaultInstance()) {
            this.updateTime_ = Timestamp.newBuilder(this.updateTime_).mergeFrom((Timestamp.Builder) timestamp).buildPartial();
        } else {
            this.updateTime_ = timestamp;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0(Timestamp timestamp) {
        timestamp.getClass();
        this.createTime_ = timestamp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0(String str) {
        str.getClass();
        this.name_ = str;
    }

    @Override // com.google.firestore.v1.DocumentOrBuilder
    public boolean containsFields(String str) {
        str.getClass();
        return u0().containsKey(str);
    }

    @Override // com.google.firestore.v1.DocumentOrBuilder
    public Timestamp getCreateTime() {
        Timestamp timestamp = this.createTime_;
        if (timestamp == null) {
            return Timestamp.getDefaultInstance();
        }
        return timestamp;
    }

    @Override // com.google.firestore.v1.DocumentOrBuilder
    @Deprecated
    public Map<String, Value> getFields() {
        return getFieldsMap();
    }

    @Override // com.google.firestore.v1.DocumentOrBuilder
    public int getFieldsCount() {
        return u0().size();
    }

    @Override // com.google.firestore.v1.DocumentOrBuilder
    public Map<String, Value> getFieldsMap() {
        return Collections.unmodifiableMap(u0());
    }

    @Override // com.google.firestore.v1.DocumentOrBuilder
    public Value getFieldsOrDefault(String str, Value value) {
        str.getClass();
        MapFieldLite<String, Value> u02 = u0();
        if (u02.containsKey(str)) {
            return u02.get(str);
        }
        return value;
    }

    @Override // com.google.firestore.v1.DocumentOrBuilder
    public Value getFieldsOrThrow(String str) {
        str.getClass();
        MapFieldLite<String, Value> u02 = u0();
        if (u02.containsKey(str)) {
            return u02.get(str);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.firestore.v1.DocumentOrBuilder
    public String getName() {
        return this.name_;
    }

    @Override // com.google.firestore.v1.DocumentOrBuilder
    public ByteString getNameBytes() {
        return ByteString.copyFromUtf8(this.name_);
    }

    @Override // com.google.firestore.v1.DocumentOrBuilder
    public Timestamp getUpdateTime() {
        Timestamp timestamp = this.updateTime_;
        if (timestamp == null) {
            return Timestamp.getDefaultInstance();
        }
        return timestamp;
    }

    @Override // com.google.firestore.v1.DocumentOrBuilder
    public boolean hasCreateTime() {
        if (this.createTime_ != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.firestore.v1.DocumentOrBuilder
    public boolean hasUpdateTime() {
        if (this.updateTime_ != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.f32449a[methodToInvoke.ordinal()]) {
            case 1:
                return new Document();
            case 2:
                return new Builder(null);
            case 3:
                return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0001\u0000\u0000\u0001Ȉ\u00022\u0003\t\u0004\t", new Object[]{"name_", "fields_", FieldsDefaultEntryHolder.f32450a, "createTime_", "updateTime_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Document> parser = PARSER;
                if (parser == null) {
                    synchronized (Document.class) {
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

    public static Builder newBuilder(Document document) {
        return DEFAULT_INSTANCE.r(document);
    }

    public static Document parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Document) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Document parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Document) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Document parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (Document) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
    }

    public static Document parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Document) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Document parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (Document) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
    }

    public static Document parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Document) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Document parseFrom(InputStream inputStream) throws IOException {
        return (Document) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
    }

    public static Document parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Document) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Document parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Document) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Document parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Document) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
