package com.google.firestore.v1;

import com.google.firestore.v1.Document;
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
public final class ListDocumentsResponse extends GeneratedMessageLite<ListDocumentsResponse, Builder> implements ListDocumentsResponseOrBuilder {
    private static final ListDocumentsResponse DEFAULT_INSTANCE;
    public static final int DOCUMENTS_FIELD_NUMBER = 1;
    public static final int NEXT_PAGE_TOKEN_FIELD_NUMBER = 2;
    private static volatile Parser<ListDocumentsResponse> PARSER;
    private Internal.ProtobufList<Document> documents_ = GeneratedMessageLite.y();
    private String nextPageToken_ = "";

    /* renamed from: com.google.firestore.v1.ListDocumentsResponse$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f32484a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f32484a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32484a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32484a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32484a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f32484a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f32484a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f32484a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<ListDocumentsResponse, Builder> implements ListDocumentsResponseOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllDocuments(Iterable<? extends Document> iterable) {
            f();
            ((ListDocumentsResponse) this.f33398b).p0(iterable);
            return this;
        }

        public Builder addDocuments(Document document) {
            f();
            ((ListDocumentsResponse) this.f33398b).r0(document);
            return this;
        }

        public Builder clearDocuments() {
            f();
            ((ListDocumentsResponse) this.f33398b).s0();
            return this;
        }

        public Builder clearNextPageToken() {
            f();
            ((ListDocumentsResponse) this.f33398b).t0();
            return this;
        }

        @Override // com.google.firestore.v1.ListDocumentsResponseOrBuilder
        public Document getDocuments(int i4) {
            return ((ListDocumentsResponse) this.f33398b).getDocuments(i4);
        }

        @Override // com.google.firestore.v1.ListDocumentsResponseOrBuilder
        public int getDocumentsCount() {
            return ((ListDocumentsResponse) this.f33398b).getDocumentsCount();
        }

        @Override // com.google.firestore.v1.ListDocumentsResponseOrBuilder
        public List<Document> getDocumentsList() {
            return Collections.unmodifiableList(((ListDocumentsResponse) this.f33398b).getDocumentsList());
        }

        @Override // com.google.firestore.v1.ListDocumentsResponseOrBuilder
        public String getNextPageToken() {
            return ((ListDocumentsResponse) this.f33398b).getNextPageToken();
        }

        @Override // com.google.firestore.v1.ListDocumentsResponseOrBuilder
        public ByteString getNextPageTokenBytes() {
            return ((ListDocumentsResponse) this.f33398b).getNextPageTokenBytes();
        }

        public Builder removeDocuments(int i4) {
            f();
            ((ListDocumentsResponse) this.f33398b).v0(i4);
            return this;
        }

        public Builder setDocuments(int i4, Document document) {
            f();
            ((ListDocumentsResponse) this.f33398b).w0(i4, document);
            return this;
        }

        public Builder setNextPageToken(String str) {
            f();
            ((ListDocumentsResponse) this.f33398b).x0(str);
            return this;
        }

        public Builder setNextPageTokenBytes(ByteString byteString) {
            f();
            ((ListDocumentsResponse) this.f33398b).y0(byteString);
            return this;
        }

        private Builder() {
            super(ListDocumentsResponse.DEFAULT_INSTANCE);
        }

        public Builder addDocuments(int i4, Document document) {
            f();
            ((ListDocumentsResponse) this.f33398b).q0(i4, document);
            return this;
        }

        public Builder setDocuments(int i4, Document.Builder builder) {
            f();
            ((ListDocumentsResponse) this.f33398b).w0(i4, builder.build());
            return this;
        }

        public Builder addDocuments(Document.Builder builder) {
            f();
            ((ListDocumentsResponse) this.f33398b).r0(builder.build());
            return this;
        }

        public Builder addDocuments(int i4, Document.Builder builder) {
            f();
            ((ListDocumentsResponse) this.f33398b).q0(i4, builder.build());
            return this;
        }
    }

    static {
        ListDocumentsResponse listDocumentsResponse = new ListDocumentsResponse();
        DEFAULT_INSTANCE = listDocumentsResponse;
        GeneratedMessageLite.d0(ListDocumentsResponse.class, listDocumentsResponse);
    }

    private ListDocumentsResponse() {
    }

    public static ListDocumentsResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p0(Iterable<? extends Document> iterable) {
        u0();
        AbstractMessageLite.a(iterable, this.documents_);
    }

    public static ListDocumentsResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (ListDocumentsResponse) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
    }

    public static ListDocumentsResponse parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (ListDocumentsResponse) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<ListDocumentsResponse> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q0(int i4, Document document) {
        document.getClass();
        u0();
        this.documents_.add(i4, document);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0(Document document) {
        document.getClass();
        u0();
        this.documents_.add(document);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0() {
        this.documents_ = GeneratedMessageLite.y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t0() {
        this.nextPageToken_ = getDefaultInstance().getNextPageToken();
    }

    private void u0() {
        Internal.ProtobufList<Document> protobufList = this.documents_;
        if (!protobufList.isModifiable()) {
            this.documents_ = GeneratedMessageLite.K(protobufList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v0(int i4) {
        u0();
        this.documents_.remove(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w0(int i4, Document document) {
        document.getClass();
        u0();
        this.documents_.set(i4, document);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0(String str) {
        str.getClass();
        this.nextPageToken_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        this.nextPageToken_ = byteString.toStringUtf8();
    }

    @Override // com.google.firestore.v1.ListDocumentsResponseOrBuilder
    public Document getDocuments(int i4) {
        return this.documents_.get(i4);
    }

    @Override // com.google.firestore.v1.ListDocumentsResponseOrBuilder
    public int getDocumentsCount() {
        return this.documents_.size();
    }

    @Override // com.google.firestore.v1.ListDocumentsResponseOrBuilder
    public List<Document> getDocumentsList() {
        return this.documents_;
    }

    public DocumentOrBuilder getDocumentsOrBuilder(int i4) {
        return this.documents_.get(i4);
    }

    public List<? extends DocumentOrBuilder> getDocumentsOrBuilderList() {
        return this.documents_;
    }

    @Override // com.google.firestore.v1.ListDocumentsResponseOrBuilder
    public String getNextPageToken() {
        return this.nextPageToken_;
    }

    @Override // com.google.firestore.v1.ListDocumentsResponseOrBuilder
    public ByteString getNextPageTokenBytes() {
        return ByteString.copyFromUtf8(this.nextPageToken_);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.f32484a[methodToInvoke.ordinal()]) {
            case 1:
                return new ListDocumentsResponse();
            case 2:
                return new Builder(null);
            case 3:
                return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002Ȉ", new Object[]{"documents_", Document.class, "nextPageToken_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<ListDocumentsResponse> parser = PARSER;
                if (parser == null) {
                    synchronized (ListDocumentsResponse.class) {
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

    public static Builder newBuilder(ListDocumentsResponse listDocumentsResponse) {
        return DEFAULT_INSTANCE.r(listDocumentsResponse);
    }

    public static ListDocumentsResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ListDocumentsResponse) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ListDocumentsResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ListDocumentsResponse) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static ListDocumentsResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (ListDocumentsResponse) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
    }

    public static ListDocumentsResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ListDocumentsResponse) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static ListDocumentsResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (ListDocumentsResponse) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
    }

    public static ListDocumentsResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ListDocumentsResponse) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static ListDocumentsResponse parseFrom(InputStream inputStream) throws IOException {
        return (ListDocumentsResponse) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
    }

    public static ListDocumentsResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ListDocumentsResponse) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ListDocumentsResponse parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (ListDocumentsResponse) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
    }

    public static ListDocumentsResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ListDocumentsResponse) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
