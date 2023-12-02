package com.google.firestore.v1;

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
public final class ListCollectionIdsResponse extends GeneratedMessageLite<ListCollectionIdsResponse, Builder> implements ListCollectionIdsResponseOrBuilder {
    public static final int COLLECTION_IDS_FIELD_NUMBER = 1;
    private static final ListCollectionIdsResponse DEFAULT_INSTANCE;
    public static final int NEXT_PAGE_TOKEN_FIELD_NUMBER = 2;
    private static volatile Parser<ListCollectionIdsResponse> PARSER;
    private Internal.ProtobufList<String> collectionIds_ = GeneratedMessageLite.y();
    private String nextPageToken_ = "";

    /* renamed from: com.google.firestore.v1.ListCollectionIdsResponse$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f32481a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f32481a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32481a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32481a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32481a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f32481a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f32481a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f32481a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<ListCollectionIdsResponse, Builder> implements ListCollectionIdsResponseOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllCollectionIds(Iterable<String> iterable) {
            f();
            ((ListCollectionIdsResponse) this.f33398b).o0(iterable);
            return this;
        }

        public Builder addCollectionIds(String str) {
            f();
            ((ListCollectionIdsResponse) this.f33398b).p0(str);
            return this;
        }

        public Builder addCollectionIdsBytes(ByteString byteString) {
            f();
            ((ListCollectionIdsResponse) this.f33398b).q0(byteString);
            return this;
        }

        public Builder clearCollectionIds() {
            f();
            ((ListCollectionIdsResponse) this.f33398b).r0();
            return this;
        }

        public Builder clearNextPageToken() {
            f();
            ((ListCollectionIdsResponse) this.f33398b).s0();
            return this;
        }

        @Override // com.google.firestore.v1.ListCollectionIdsResponseOrBuilder
        public String getCollectionIds(int i4) {
            return ((ListCollectionIdsResponse) this.f33398b).getCollectionIds(i4);
        }

        @Override // com.google.firestore.v1.ListCollectionIdsResponseOrBuilder
        public ByteString getCollectionIdsBytes(int i4) {
            return ((ListCollectionIdsResponse) this.f33398b).getCollectionIdsBytes(i4);
        }

        @Override // com.google.firestore.v1.ListCollectionIdsResponseOrBuilder
        public int getCollectionIdsCount() {
            return ((ListCollectionIdsResponse) this.f33398b).getCollectionIdsCount();
        }

        @Override // com.google.firestore.v1.ListCollectionIdsResponseOrBuilder
        public List<String> getCollectionIdsList() {
            return Collections.unmodifiableList(((ListCollectionIdsResponse) this.f33398b).getCollectionIdsList());
        }

        @Override // com.google.firestore.v1.ListCollectionIdsResponseOrBuilder
        public String getNextPageToken() {
            return ((ListCollectionIdsResponse) this.f33398b).getNextPageToken();
        }

        @Override // com.google.firestore.v1.ListCollectionIdsResponseOrBuilder
        public ByteString getNextPageTokenBytes() {
            return ((ListCollectionIdsResponse) this.f33398b).getNextPageTokenBytes();
        }

        public Builder setCollectionIds(int i4, String str) {
            f();
            ((ListCollectionIdsResponse) this.f33398b).u0(i4, str);
            return this;
        }

        public Builder setNextPageToken(String str) {
            f();
            ((ListCollectionIdsResponse) this.f33398b).v0(str);
            return this;
        }

        public Builder setNextPageTokenBytes(ByteString byteString) {
            f();
            ((ListCollectionIdsResponse) this.f33398b).w0(byteString);
            return this;
        }

        private Builder() {
            super(ListCollectionIdsResponse.DEFAULT_INSTANCE);
        }
    }

    static {
        ListCollectionIdsResponse listCollectionIdsResponse = new ListCollectionIdsResponse();
        DEFAULT_INSTANCE = listCollectionIdsResponse;
        GeneratedMessageLite.d0(ListCollectionIdsResponse.class, listCollectionIdsResponse);
    }

    private ListCollectionIdsResponse() {
    }

    public static ListCollectionIdsResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o0(Iterable<String> iterable) {
        t0();
        AbstractMessageLite.a(iterable, this.collectionIds_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p0(String str) {
        str.getClass();
        t0();
        this.collectionIds_.add(str);
    }

    public static ListCollectionIdsResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (ListCollectionIdsResponse) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
    }

    public static ListCollectionIdsResponse parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (ListCollectionIdsResponse) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<ListCollectionIdsResponse> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q0(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        t0();
        this.collectionIds_.add(byteString.toStringUtf8());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0() {
        this.collectionIds_ = GeneratedMessageLite.y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0() {
        this.nextPageToken_ = getDefaultInstance().getNextPageToken();
    }

    private void t0() {
        Internal.ProtobufList<String> protobufList = this.collectionIds_;
        if (!protobufList.isModifiable()) {
            this.collectionIds_ = GeneratedMessageLite.K(protobufList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u0(int i4, String str) {
        str.getClass();
        t0();
        this.collectionIds_.set(i4, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v0(String str) {
        str.getClass();
        this.nextPageToken_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w0(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        this.nextPageToken_ = byteString.toStringUtf8();
    }

    @Override // com.google.firestore.v1.ListCollectionIdsResponseOrBuilder
    public String getCollectionIds(int i4) {
        return this.collectionIds_.get(i4);
    }

    @Override // com.google.firestore.v1.ListCollectionIdsResponseOrBuilder
    public ByteString getCollectionIdsBytes(int i4) {
        return ByteString.copyFromUtf8(this.collectionIds_.get(i4));
    }

    @Override // com.google.firestore.v1.ListCollectionIdsResponseOrBuilder
    public int getCollectionIdsCount() {
        return this.collectionIds_.size();
    }

    @Override // com.google.firestore.v1.ListCollectionIdsResponseOrBuilder
    public List<String> getCollectionIdsList() {
        return this.collectionIds_;
    }

    @Override // com.google.firestore.v1.ListCollectionIdsResponseOrBuilder
    public String getNextPageToken() {
        return this.nextPageToken_;
    }

    @Override // com.google.firestore.v1.ListCollectionIdsResponseOrBuilder
    public ByteString getNextPageTokenBytes() {
        return ByteString.copyFromUtf8(this.nextPageToken_);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.f32481a[methodToInvoke.ordinal()]) {
            case 1:
                return new ListCollectionIdsResponse();
            case 2:
                return new Builder(null);
            case 3:
                return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ț\u0002Ȉ", new Object[]{"collectionIds_", "nextPageToken_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<ListCollectionIdsResponse> parser = PARSER;
                if (parser == null) {
                    synchronized (ListCollectionIdsResponse.class) {
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

    public static Builder newBuilder(ListCollectionIdsResponse listCollectionIdsResponse) {
        return DEFAULT_INSTANCE.r(listCollectionIdsResponse);
    }

    public static ListCollectionIdsResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ListCollectionIdsResponse) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ListCollectionIdsResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ListCollectionIdsResponse) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static ListCollectionIdsResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (ListCollectionIdsResponse) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
    }

    public static ListCollectionIdsResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ListCollectionIdsResponse) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static ListCollectionIdsResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (ListCollectionIdsResponse) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
    }

    public static ListCollectionIdsResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ListCollectionIdsResponse) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static ListCollectionIdsResponse parseFrom(InputStream inputStream) throws IOException {
        return (ListCollectionIdsResponse) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
    }

    public static ListCollectionIdsResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ListCollectionIdsResponse) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ListCollectionIdsResponse parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (ListCollectionIdsResponse) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
    }

    public static ListCollectionIdsResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ListCollectionIdsResponse) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
