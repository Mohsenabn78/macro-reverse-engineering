package com.google.firestore.v1;

import com.google.firestore.v1.StructuredQuery;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Int32Value;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: classes5.dex */
public final class Target extends GeneratedMessageLite<Target, Builder> implements TargetOrBuilder {
    private static final Target DEFAULT_INSTANCE;
    public static final int DOCUMENTS_FIELD_NUMBER = 3;
    public static final int EXPECTED_COUNT_FIELD_NUMBER = 12;
    public static final int ONCE_FIELD_NUMBER = 6;
    private static volatile Parser<Target> PARSER = null;
    public static final int QUERY_FIELD_NUMBER = 2;
    public static final int READ_TIME_FIELD_NUMBER = 11;
    public static final int RESUME_TOKEN_FIELD_NUMBER = 4;
    public static final int TARGET_ID_FIELD_NUMBER = 5;
    private Int32Value expectedCount_;
    private boolean once_;
    private Object resumeType_;
    private int targetId_;
    private Object targetType_;
    private int targetTypeCase_ = 0;
    private int resumeTypeCase_ = 0;

    /* renamed from: com.google.firestore.v1.Target$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f32521a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f32521a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32521a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32521a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32521a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f32521a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f32521a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f32521a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<Target, Builder> implements TargetOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearDocuments() {
            f();
            ((Target) this.f33398b).A0();
            return this;
        }

        public Builder clearExpectedCount() {
            f();
            ((Target) this.f33398b).B0();
            return this;
        }

        public Builder clearOnce() {
            f();
            ((Target) this.f33398b).C0();
            return this;
        }

        public Builder clearQuery() {
            f();
            ((Target) this.f33398b).D0();
            return this;
        }

        public Builder clearReadTime() {
            f();
            ((Target) this.f33398b).E0();
            return this;
        }

        public Builder clearResumeToken() {
            f();
            ((Target) this.f33398b).F0();
            return this;
        }

        public Builder clearResumeType() {
            f();
            ((Target) this.f33398b).G0();
            return this;
        }

        public Builder clearTargetId() {
            f();
            ((Target) this.f33398b).H0();
            return this;
        }

        public Builder clearTargetType() {
            f();
            ((Target) this.f33398b).I0();
            return this;
        }

        @Override // com.google.firestore.v1.TargetOrBuilder
        public DocumentsTarget getDocuments() {
            return ((Target) this.f33398b).getDocuments();
        }

        @Override // com.google.firestore.v1.TargetOrBuilder
        public Int32Value getExpectedCount() {
            return ((Target) this.f33398b).getExpectedCount();
        }

        @Override // com.google.firestore.v1.TargetOrBuilder
        public boolean getOnce() {
            return ((Target) this.f33398b).getOnce();
        }

        @Override // com.google.firestore.v1.TargetOrBuilder
        public QueryTarget getQuery() {
            return ((Target) this.f33398b).getQuery();
        }

        @Override // com.google.firestore.v1.TargetOrBuilder
        public Timestamp getReadTime() {
            return ((Target) this.f33398b).getReadTime();
        }

        @Override // com.google.firestore.v1.TargetOrBuilder
        public ByteString getResumeToken() {
            return ((Target) this.f33398b).getResumeToken();
        }

        @Override // com.google.firestore.v1.TargetOrBuilder
        public ResumeTypeCase getResumeTypeCase() {
            return ((Target) this.f33398b).getResumeTypeCase();
        }

        @Override // com.google.firestore.v1.TargetOrBuilder
        public int getTargetId() {
            return ((Target) this.f33398b).getTargetId();
        }

        @Override // com.google.firestore.v1.TargetOrBuilder
        public TargetTypeCase getTargetTypeCase() {
            return ((Target) this.f33398b).getTargetTypeCase();
        }

        @Override // com.google.firestore.v1.TargetOrBuilder
        public boolean hasDocuments() {
            return ((Target) this.f33398b).hasDocuments();
        }

        @Override // com.google.firestore.v1.TargetOrBuilder
        public boolean hasExpectedCount() {
            return ((Target) this.f33398b).hasExpectedCount();
        }

        @Override // com.google.firestore.v1.TargetOrBuilder
        public boolean hasQuery() {
            return ((Target) this.f33398b).hasQuery();
        }

        @Override // com.google.firestore.v1.TargetOrBuilder
        public boolean hasReadTime() {
            return ((Target) this.f33398b).hasReadTime();
        }

        @Override // com.google.firestore.v1.TargetOrBuilder
        public boolean hasResumeToken() {
            return ((Target) this.f33398b).hasResumeToken();
        }

        public Builder mergeDocuments(DocumentsTarget documentsTarget) {
            f();
            ((Target) this.f33398b).J0(documentsTarget);
            return this;
        }

        public Builder mergeExpectedCount(Int32Value int32Value) {
            f();
            ((Target) this.f33398b).K0(int32Value);
            return this;
        }

        public Builder mergeQuery(QueryTarget queryTarget) {
            f();
            ((Target) this.f33398b).L0(queryTarget);
            return this;
        }

        public Builder mergeReadTime(Timestamp timestamp) {
            f();
            ((Target) this.f33398b).M0(timestamp);
            return this;
        }

        public Builder setDocuments(DocumentsTarget documentsTarget) {
            f();
            ((Target) this.f33398b).N0(documentsTarget);
            return this;
        }

        public Builder setExpectedCount(Int32Value int32Value) {
            f();
            ((Target) this.f33398b).O0(int32Value);
            return this;
        }

        public Builder setOnce(boolean z3) {
            f();
            ((Target) this.f33398b).P0(z3);
            return this;
        }

        public Builder setQuery(QueryTarget queryTarget) {
            f();
            ((Target) this.f33398b).Q0(queryTarget);
            return this;
        }

        public Builder setReadTime(Timestamp timestamp) {
            f();
            ((Target) this.f33398b).R0(timestamp);
            return this;
        }

        public Builder setResumeToken(ByteString byteString) {
            f();
            ((Target) this.f33398b).S0(byteString);
            return this;
        }

        public Builder setTargetId(int i4) {
            f();
            ((Target) this.f33398b).T0(i4);
            return this;
        }

        private Builder() {
            super(Target.DEFAULT_INSTANCE);
        }

        public Builder setDocuments(DocumentsTarget.Builder builder) {
            f();
            ((Target) this.f33398b).N0(builder.build());
            return this;
        }

        public Builder setExpectedCount(Int32Value.Builder builder) {
            f();
            ((Target) this.f33398b).O0(builder.build());
            return this;
        }

        public Builder setQuery(QueryTarget.Builder builder) {
            f();
            ((Target) this.f33398b).Q0(builder.build());
            return this;
        }

        public Builder setReadTime(Timestamp.Builder builder) {
            f();
            ((Target) this.f33398b).R0(builder.build());
            return this;
        }
    }

    /* loaded from: classes5.dex */
    public static final class DocumentsTarget extends GeneratedMessageLite<DocumentsTarget, Builder> implements DocumentsTargetOrBuilder {
        private static final DocumentsTarget DEFAULT_INSTANCE;
        public static final int DOCUMENTS_FIELD_NUMBER = 2;
        private static volatile Parser<DocumentsTarget> PARSER;
        private Internal.ProtobufList<String> documents_ = GeneratedMessageLite.y();

        /* loaded from: classes5.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<DocumentsTarget, Builder> implements DocumentsTargetOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder addAllDocuments(Iterable<String> iterable) {
                f();
                ((DocumentsTarget) this.f33398b).l0(iterable);
                return this;
            }

            public Builder addDocuments(String str) {
                f();
                ((DocumentsTarget) this.f33398b).m0(str);
                return this;
            }

            public Builder addDocumentsBytes(ByteString byteString) {
                f();
                ((DocumentsTarget) this.f33398b).n0(byteString);
                return this;
            }

            public Builder clearDocuments() {
                f();
                ((DocumentsTarget) this.f33398b).o0();
                return this;
            }

            @Override // com.google.firestore.v1.Target.DocumentsTargetOrBuilder
            public String getDocuments(int i4) {
                return ((DocumentsTarget) this.f33398b).getDocuments(i4);
            }

            @Override // com.google.firestore.v1.Target.DocumentsTargetOrBuilder
            public ByteString getDocumentsBytes(int i4) {
                return ((DocumentsTarget) this.f33398b).getDocumentsBytes(i4);
            }

            @Override // com.google.firestore.v1.Target.DocumentsTargetOrBuilder
            public int getDocumentsCount() {
                return ((DocumentsTarget) this.f33398b).getDocumentsCount();
            }

            @Override // com.google.firestore.v1.Target.DocumentsTargetOrBuilder
            public List<String> getDocumentsList() {
                return Collections.unmodifiableList(((DocumentsTarget) this.f33398b).getDocumentsList());
            }

            public Builder setDocuments(int i4, String str) {
                f();
                ((DocumentsTarget) this.f33398b).q0(i4, str);
                return this;
            }

            private Builder() {
                super(DocumentsTarget.DEFAULT_INSTANCE);
            }
        }

        static {
            DocumentsTarget documentsTarget = new DocumentsTarget();
            DEFAULT_INSTANCE = documentsTarget;
            GeneratedMessageLite.d0(DocumentsTarget.class, documentsTarget);
        }

        private DocumentsTarget() {
        }

        public static DocumentsTarget getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void l0(Iterable<String> iterable) {
            p0();
            AbstractMessageLite.a(iterable, this.documents_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void m0(String str) {
            str.getClass();
            p0();
            this.documents_.add(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n0(ByteString byteString) {
            AbstractMessageLite.b(byteString);
            p0();
            this.documents_.add(byteString.toStringUtf8());
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.q();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void o0() {
            this.documents_ = GeneratedMessageLite.y();
        }

        private void p0() {
            Internal.ProtobufList<String> protobufList = this.documents_;
            if (!protobufList.isModifiable()) {
                this.documents_ = GeneratedMessageLite.K(protobufList);
            }
        }

        public static DocumentsTarget parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (DocumentsTarget) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
        }

        public static DocumentsTarget parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (DocumentsTarget) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<DocumentsTarget> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void q0(int i4, String str) {
            str.getClass();
            p0();
            this.documents_.set(i4, str);
        }

        @Override // com.google.firestore.v1.Target.DocumentsTargetOrBuilder
        public String getDocuments(int i4) {
            return this.documents_.get(i4);
        }

        @Override // com.google.firestore.v1.Target.DocumentsTargetOrBuilder
        public ByteString getDocumentsBytes(int i4) {
            return ByteString.copyFromUtf8(this.documents_.get(i4));
        }

        @Override // com.google.firestore.v1.Target.DocumentsTargetOrBuilder
        public int getDocumentsCount() {
            return this.documents_.size();
        }

        @Override // com.google.firestore.v1.Target.DocumentsTargetOrBuilder
        public List<String> getDocumentsList() {
            return this.documents_;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (AnonymousClass1.f32521a[methodToInvoke.ordinal()]) {
                case 1:
                    return new DocumentsTarget();
                case 2:
                    return new Builder(null);
                case 3:
                    return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0002\u0002\u0001\u0000\u0001\u0000\u0002Ț", new Object[]{"documents_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<DocumentsTarget> parser = PARSER;
                    if (parser == null) {
                        synchronized (DocumentsTarget.class) {
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

        public static Builder newBuilder(DocumentsTarget documentsTarget) {
            return DEFAULT_INSTANCE.r(documentsTarget);
        }

        public static DocumentsTarget parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (DocumentsTarget) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static DocumentsTarget parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (DocumentsTarget) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static DocumentsTarget parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (DocumentsTarget) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
        }

        public static DocumentsTarget parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (DocumentsTarget) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static DocumentsTarget parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (DocumentsTarget) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
        }

        public static DocumentsTarget parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (DocumentsTarget) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static DocumentsTarget parseFrom(InputStream inputStream) throws IOException {
            return (DocumentsTarget) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
        }

        public static DocumentsTarget parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (DocumentsTarget) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static DocumentsTarget parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (DocumentsTarget) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
        }

        public static DocumentsTarget parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (DocumentsTarget) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: classes5.dex */
    public interface DocumentsTargetOrBuilder extends MessageLiteOrBuilder {
        String getDocuments(int i4);

        ByteString getDocumentsBytes(int i4);

        int getDocumentsCount();

        List<String> getDocumentsList();
    }

    /* loaded from: classes5.dex */
    public static final class QueryTarget extends GeneratedMessageLite<QueryTarget, Builder> implements QueryTargetOrBuilder {
        private static final QueryTarget DEFAULT_INSTANCE;
        public static final int PARENT_FIELD_NUMBER = 1;
        private static volatile Parser<QueryTarget> PARSER = null;
        public static final int STRUCTURED_QUERY_FIELD_NUMBER = 2;
        private Object queryType_;
        private int queryTypeCase_ = 0;
        private String parent_ = "";

        /* loaded from: classes5.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<QueryTarget, Builder> implements QueryTargetOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearParent() {
                f();
                ((QueryTarget) this.f33398b).n0();
                return this;
            }

            public Builder clearQueryType() {
                f();
                ((QueryTarget) this.f33398b).o0();
                return this;
            }

            public Builder clearStructuredQuery() {
                f();
                ((QueryTarget) this.f33398b).p0();
                return this;
            }

            @Override // com.google.firestore.v1.Target.QueryTargetOrBuilder
            public String getParent() {
                return ((QueryTarget) this.f33398b).getParent();
            }

            @Override // com.google.firestore.v1.Target.QueryTargetOrBuilder
            public ByteString getParentBytes() {
                return ((QueryTarget) this.f33398b).getParentBytes();
            }

            @Override // com.google.firestore.v1.Target.QueryTargetOrBuilder
            public QueryTypeCase getQueryTypeCase() {
                return ((QueryTarget) this.f33398b).getQueryTypeCase();
            }

            @Override // com.google.firestore.v1.Target.QueryTargetOrBuilder
            public StructuredQuery getStructuredQuery() {
                return ((QueryTarget) this.f33398b).getStructuredQuery();
            }

            @Override // com.google.firestore.v1.Target.QueryTargetOrBuilder
            public boolean hasStructuredQuery() {
                return ((QueryTarget) this.f33398b).hasStructuredQuery();
            }

            public Builder mergeStructuredQuery(StructuredQuery structuredQuery) {
                f();
                ((QueryTarget) this.f33398b).q0(structuredQuery);
                return this;
            }

            public Builder setParent(String str) {
                f();
                ((QueryTarget) this.f33398b).r0(str);
                return this;
            }

            public Builder setParentBytes(ByteString byteString) {
                f();
                ((QueryTarget) this.f33398b).s0(byteString);
                return this;
            }

            public Builder setStructuredQuery(StructuredQuery structuredQuery) {
                f();
                ((QueryTarget) this.f33398b).t0(structuredQuery);
                return this;
            }

            private Builder() {
                super(QueryTarget.DEFAULT_INSTANCE);
            }

            public Builder setStructuredQuery(StructuredQuery.Builder builder) {
                f();
                ((QueryTarget) this.f33398b).t0(builder.build());
                return this;
            }
        }

        /* loaded from: classes5.dex */
        public enum QueryTypeCase {
            STRUCTURED_QUERY(2),
            QUERYTYPE_NOT_SET(0);
            
            private final int value;

            QueryTypeCase(int i4) {
                this.value = i4;
            }

            public static QueryTypeCase forNumber(int i4) {
                if (i4 != 0) {
                    if (i4 != 2) {
                        return null;
                    }
                    return STRUCTURED_QUERY;
                }
                return QUERYTYPE_NOT_SET;
            }

            public int getNumber() {
                return this.value;
            }

            @Deprecated
            public static QueryTypeCase valueOf(int i4) {
                return forNumber(i4);
            }
        }

        static {
            QueryTarget queryTarget = new QueryTarget();
            DEFAULT_INSTANCE = queryTarget;
            GeneratedMessageLite.d0(QueryTarget.class, queryTarget);
        }

        private QueryTarget() {
        }

        public static QueryTarget getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n0() {
            this.parent_ = getDefaultInstance().getParent();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.q();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void o0() {
            this.queryTypeCase_ = 0;
            this.queryType_ = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void p0() {
            if (this.queryTypeCase_ == 2) {
                this.queryTypeCase_ = 0;
                this.queryType_ = null;
            }
        }

        public static QueryTarget parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (QueryTarget) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
        }

        public static QueryTarget parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (QueryTarget) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<QueryTarget> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void q0(StructuredQuery structuredQuery) {
            structuredQuery.getClass();
            if (this.queryTypeCase_ == 2 && this.queryType_ != StructuredQuery.getDefaultInstance()) {
                this.queryType_ = StructuredQuery.newBuilder((StructuredQuery) this.queryType_).mergeFrom((StructuredQuery.Builder) structuredQuery).buildPartial();
            } else {
                this.queryType_ = structuredQuery;
            }
            this.queryTypeCase_ = 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void r0(String str) {
            str.getClass();
            this.parent_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s0(ByteString byteString) {
            AbstractMessageLite.b(byteString);
            this.parent_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void t0(StructuredQuery structuredQuery) {
            structuredQuery.getClass();
            this.queryType_ = structuredQuery;
            this.queryTypeCase_ = 2;
        }

        @Override // com.google.firestore.v1.Target.QueryTargetOrBuilder
        public String getParent() {
            return this.parent_;
        }

        @Override // com.google.firestore.v1.Target.QueryTargetOrBuilder
        public ByteString getParentBytes() {
            return ByteString.copyFromUtf8(this.parent_);
        }

        @Override // com.google.firestore.v1.Target.QueryTargetOrBuilder
        public QueryTypeCase getQueryTypeCase() {
            return QueryTypeCase.forNumber(this.queryTypeCase_);
        }

        @Override // com.google.firestore.v1.Target.QueryTargetOrBuilder
        public StructuredQuery getStructuredQuery() {
            if (this.queryTypeCase_ == 2) {
                return (StructuredQuery) this.queryType_;
            }
            return StructuredQuery.getDefaultInstance();
        }

        @Override // com.google.firestore.v1.Target.QueryTargetOrBuilder
        public boolean hasStructuredQuery() {
            if (this.queryTypeCase_ == 2) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (AnonymousClass1.f32521a[methodToInvoke.ordinal()]) {
                case 1:
                    return new QueryTarget();
                case 2:
                    return new Builder(null);
                case 3:
                    return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0002\u0001\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002<\u0000", new Object[]{"queryType_", "queryTypeCase_", "parent_", StructuredQuery.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<QueryTarget> parser = PARSER;
                    if (parser == null) {
                        synchronized (QueryTarget.class) {
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

        public static Builder newBuilder(QueryTarget queryTarget) {
            return DEFAULT_INSTANCE.r(queryTarget);
        }

        public static QueryTarget parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (QueryTarget) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static QueryTarget parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (QueryTarget) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static QueryTarget parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (QueryTarget) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
        }

        public static QueryTarget parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (QueryTarget) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static QueryTarget parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (QueryTarget) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
        }

        public static QueryTarget parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (QueryTarget) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static QueryTarget parseFrom(InputStream inputStream) throws IOException {
            return (QueryTarget) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
        }

        public static QueryTarget parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (QueryTarget) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static QueryTarget parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (QueryTarget) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
        }

        public static QueryTarget parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (QueryTarget) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: classes5.dex */
    public interface QueryTargetOrBuilder extends MessageLiteOrBuilder {
        String getParent();

        ByteString getParentBytes();

        QueryTarget.QueryTypeCase getQueryTypeCase();

        StructuredQuery getStructuredQuery();

        boolean hasStructuredQuery();
    }

    /* loaded from: classes5.dex */
    public enum ResumeTypeCase {
        RESUME_TOKEN(4),
        READ_TIME(11),
        RESUMETYPE_NOT_SET(0);
        
        private final int value;

        ResumeTypeCase(int i4) {
            this.value = i4;
        }

        public static ResumeTypeCase forNumber(int i4) {
            if (i4 != 0) {
                if (i4 != 4) {
                    if (i4 != 11) {
                        return null;
                    }
                    return READ_TIME;
                }
                return RESUME_TOKEN;
            }
            return RESUMETYPE_NOT_SET;
        }

        public int getNumber() {
            return this.value;
        }

        @Deprecated
        public static ResumeTypeCase valueOf(int i4) {
            return forNumber(i4);
        }
    }

    /* loaded from: classes5.dex */
    public enum TargetTypeCase {
        QUERY(2),
        DOCUMENTS(3),
        TARGETTYPE_NOT_SET(0);
        
        private final int value;

        TargetTypeCase(int i4) {
            this.value = i4;
        }

        public static TargetTypeCase forNumber(int i4) {
            if (i4 != 0) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        return null;
                    }
                    return DOCUMENTS;
                }
                return QUERY;
            }
            return TARGETTYPE_NOT_SET;
        }

        public int getNumber() {
            return this.value;
        }

        @Deprecated
        public static TargetTypeCase valueOf(int i4) {
            return forNumber(i4);
        }
    }

    static {
        Target target = new Target();
        DEFAULT_INSTANCE = target;
        GeneratedMessageLite.d0(Target.class, target);
    }

    private Target() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0() {
        if (this.targetTypeCase_ == 3) {
            this.targetTypeCase_ = 0;
            this.targetType_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B0() {
        this.expectedCount_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C0() {
        this.once_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D0() {
        if (this.targetTypeCase_ == 2) {
            this.targetTypeCase_ = 0;
            this.targetType_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E0() {
        if (this.resumeTypeCase_ == 11) {
            this.resumeTypeCase_ = 0;
            this.resumeType_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F0() {
        if (this.resumeTypeCase_ == 4) {
            this.resumeTypeCase_ = 0;
            this.resumeType_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G0() {
        this.resumeTypeCase_ = 0;
        this.resumeType_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H0() {
        this.targetId_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I0() {
        this.targetTypeCase_ = 0;
        this.targetType_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J0(DocumentsTarget documentsTarget) {
        documentsTarget.getClass();
        if (this.targetTypeCase_ == 3 && this.targetType_ != DocumentsTarget.getDefaultInstance()) {
            this.targetType_ = DocumentsTarget.newBuilder((DocumentsTarget) this.targetType_).mergeFrom((DocumentsTarget.Builder) documentsTarget).buildPartial();
        } else {
            this.targetType_ = documentsTarget;
        }
        this.targetTypeCase_ = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K0(Int32Value int32Value) {
        int32Value.getClass();
        Int32Value int32Value2 = this.expectedCount_;
        if (int32Value2 != null && int32Value2 != Int32Value.getDefaultInstance()) {
            this.expectedCount_ = Int32Value.newBuilder(this.expectedCount_).mergeFrom((Int32Value.Builder) int32Value).buildPartial();
        } else {
            this.expectedCount_ = int32Value;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L0(QueryTarget queryTarget) {
        queryTarget.getClass();
        if (this.targetTypeCase_ == 2 && this.targetType_ != QueryTarget.getDefaultInstance()) {
            this.targetType_ = QueryTarget.newBuilder((QueryTarget) this.targetType_).mergeFrom((QueryTarget.Builder) queryTarget).buildPartial();
        } else {
            this.targetType_ = queryTarget;
        }
        this.targetTypeCase_ = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M0(Timestamp timestamp) {
        timestamp.getClass();
        if (this.resumeTypeCase_ == 11 && this.resumeType_ != Timestamp.getDefaultInstance()) {
            this.resumeType_ = Timestamp.newBuilder((Timestamp) this.resumeType_).mergeFrom((Timestamp.Builder) timestamp).buildPartial();
        } else {
            this.resumeType_ = timestamp;
        }
        this.resumeTypeCase_ = 11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N0(DocumentsTarget documentsTarget) {
        documentsTarget.getClass();
        this.targetType_ = documentsTarget;
        this.targetTypeCase_ = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O0(Int32Value int32Value) {
        int32Value.getClass();
        this.expectedCount_ = int32Value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P0(boolean z3) {
        this.once_ = z3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q0(QueryTarget queryTarget) {
        queryTarget.getClass();
        this.targetType_ = queryTarget;
        this.targetTypeCase_ = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R0(Timestamp timestamp) {
        timestamp.getClass();
        this.resumeType_ = timestamp;
        this.resumeTypeCase_ = 11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S0(ByteString byteString) {
        byteString.getClass();
        this.resumeTypeCase_ = 4;
        this.resumeType_ = byteString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T0(int i4) {
        this.targetId_ = i4;
    }

    public static Target getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.q();
    }

    public static Target parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Target) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
    }

    public static Target parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (Target) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Target> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    @Override // com.google.firestore.v1.TargetOrBuilder
    public DocumentsTarget getDocuments() {
        if (this.targetTypeCase_ == 3) {
            return (DocumentsTarget) this.targetType_;
        }
        return DocumentsTarget.getDefaultInstance();
    }

    @Override // com.google.firestore.v1.TargetOrBuilder
    public Int32Value getExpectedCount() {
        Int32Value int32Value = this.expectedCount_;
        if (int32Value == null) {
            return Int32Value.getDefaultInstance();
        }
        return int32Value;
    }

    @Override // com.google.firestore.v1.TargetOrBuilder
    public boolean getOnce() {
        return this.once_;
    }

    @Override // com.google.firestore.v1.TargetOrBuilder
    public QueryTarget getQuery() {
        if (this.targetTypeCase_ == 2) {
            return (QueryTarget) this.targetType_;
        }
        return QueryTarget.getDefaultInstance();
    }

    @Override // com.google.firestore.v1.TargetOrBuilder
    public Timestamp getReadTime() {
        if (this.resumeTypeCase_ == 11) {
            return (Timestamp) this.resumeType_;
        }
        return Timestamp.getDefaultInstance();
    }

    @Override // com.google.firestore.v1.TargetOrBuilder
    public ByteString getResumeToken() {
        if (this.resumeTypeCase_ == 4) {
            return (ByteString) this.resumeType_;
        }
        return ByteString.EMPTY;
    }

    @Override // com.google.firestore.v1.TargetOrBuilder
    public ResumeTypeCase getResumeTypeCase() {
        return ResumeTypeCase.forNumber(this.resumeTypeCase_);
    }

    @Override // com.google.firestore.v1.TargetOrBuilder
    public int getTargetId() {
        return this.targetId_;
    }

    @Override // com.google.firestore.v1.TargetOrBuilder
    public TargetTypeCase getTargetTypeCase() {
        return TargetTypeCase.forNumber(this.targetTypeCase_);
    }

    @Override // com.google.firestore.v1.TargetOrBuilder
    public boolean hasDocuments() {
        if (this.targetTypeCase_ == 3) {
            return true;
        }
        return false;
    }

    @Override // com.google.firestore.v1.TargetOrBuilder
    public boolean hasExpectedCount() {
        if (this.expectedCount_ != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.firestore.v1.TargetOrBuilder
    public boolean hasQuery() {
        if (this.targetTypeCase_ == 2) {
            return true;
        }
        return false;
    }

    @Override // com.google.firestore.v1.TargetOrBuilder
    public boolean hasReadTime() {
        if (this.resumeTypeCase_ == 11) {
            return true;
        }
        return false;
    }

    @Override // com.google.firestore.v1.TargetOrBuilder
    public boolean hasResumeToken() {
        if (this.resumeTypeCase_ == 4) {
            return true;
        }
        return false;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.f32521a[methodToInvoke.ordinal()]) {
            case 1:
                return new Target();
            case 2:
                return new Builder(null);
            case 3:
                return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0007\u0002\u0000\u0002\f\u0007\u0000\u0000\u0000\u0002<\u0000\u0003<\u0000\u0004=\u0001\u0005\u0004\u0006\u0007\u000b<\u0001\f\t", new Object[]{"targetType_", "targetTypeCase_", "resumeType_", "resumeTypeCase_", QueryTarget.class, DocumentsTarget.class, "targetId_", "once_", Timestamp.class, "expectedCount_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Target> parser = PARSER;
                if (parser == null) {
                    synchronized (Target.class) {
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

    public static Builder newBuilder(Target target) {
        return DEFAULT_INSTANCE.r(target);
    }

    public static Target parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Target) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Target parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Target) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Target parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (Target) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
    }

    public static Target parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Target) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Target parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (Target) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
    }

    public static Target parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Target) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Target parseFrom(InputStream inputStream) throws IOException {
        return (Target) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
    }

    public static Target parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Target) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Target parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Target) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Target parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Target) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
