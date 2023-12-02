package com.google.firestore.v1;

import com.google.firestore.v1.DocumentChange;
import com.google.firestore.v1.DocumentDelete;
import com.google.firestore.v1.DocumentRemove;
import com.google.firestore.v1.ExistenceFilter;
import com.google.firestore.v1.TargetChange;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes5.dex */
public final class ListenResponse extends GeneratedMessageLite<ListenResponse, Builder> implements ListenResponseOrBuilder {
    private static final ListenResponse DEFAULT_INSTANCE;
    public static final int DOCUMENT_CHANGE_FIELD_NUMBER = 3;
    public static final int DOCUMENT_DELETE_FIELD_NUMBER = 4;
    public static final int DOCUMENT_REMOVE_FIELD_NUMBER = 6;
    public static final int FILTER_FIELD_NUMBER = 5;
    private static volatile Parser<ListenResponse> PARSER = null;
    public static final int TARGET_CHANGE_FIELD_NUMBER = 2;
    private int responseTypeCase_ = 0;
    private Object responseType_;

    /* renamed from: com.google.firestore.v1.ListenResponse$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f32488a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f32488a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32488a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32488a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32488a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f32488a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f32488a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f32488a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<ListenResponse, Builder> implements ListenResponseOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearDocumentChange() {
            f();
            ((ListenResponse) this.f33398b).w0();
            return this;
        }

        public Builder clearDocumentDelete() {
            f();
            ((ListenResponse) this.f33398b).x0();
            return this;
        }

        public Builder clearDocumentRemove() {
            f();
            ((ListenResponse) this.f33398b).y0();
            return this;
        }

        public Builder clearFilter() {
            f();
            ((ListenResponse) this.f33398b).z0();
            return this;
        }

        public Builder clearResponseType() {
            f();
            ((ListenResponse) this.f33398b).A0();
            return this;
        }

        public Builder clearTargetChange() {
            f();
            ((ListenResponse) this.f33398b).B0();
            return this;
        }

        @Override // com.google.firestore.v1.ListenResponseOrBuilder
        public DocumentChange getDocumentChange() {
            return ((ListenResponse) this.f33398b).getDocumentChange();
        }

        @Override // com.google.firestore.v1.ListenResponseOrBuilder
        public DocumentDelete getDocumentDelete() {
            return ((ListenResponse) this.f33398b).getDocumentDelete();
        }

        @Override // com.google.firestore.v1.ListenResponseOrBuilder
        public DocumentRemove getDocumentRemove() {
            return ((ListenResponse) this.f33398b).getDocumentRemove();
        }

        @Override // com.google.firestore.v1.ListenResponseOrBuilder
        public ExistenceFilter getFilter() {
            return ((ListenResponse) this.f33398b).getFilter();
        }

        @Override // com.google.firestore.v1.ListenResponseOrBuilder
        public ResponseTypeCase getResponseTypeCase() {
            return ((ListenResponse) this.f33398b).getResponseTypeCase();
        }

        @Override // com.google.firestore.v1.ListenResponseOrBuilder
        public TargetChange getTargetChange() {
            return ((ListenResponse) this.f33398b).getTargetChange();
        }

        @Override // com.google.firestore.v1.ListenResponseOrBuilder
        public boolean hasDocumentChange() {
            return ((ListenResponse) this.f33398b).hasDocumentChange();
        }

        @Override // com.google.firestore.v1.ListenResponseOrBuilder
        public boolean hasDocumentDelete() {
            return ((ListenResponse) this.f33398b).hasDocumentDelete();
        }

        @Override // com.google.firestore.v1.ListenResponseOrBuilder
        public boolean hasDocumentRemove() {
            return ((ListenResponse) this.f33398b).hasDocumentRemove();
        }

        @Override // com.google.firestore.v1.ListenResponseOrBuilder
        public boolean hasFilter() {
            return ((ListenResponse) this.f33398b).hasFilter();
        }

        @Override // com.google.firestore.v1.ListenResponseOrBuilder
        public boolean hasTargetChange() {
            return ((ListenResponse) this.f33398b).hasTargetChange();
        }

        public Builder mergeDocumentChange(DocumentChange documentChange) {
            f();
            ((ListenResponse) this.f33398b).C0(documentChange);
            return this;
        }

        public Builder mergeDocumentDelete(DocumentDelete documentDelete) {
            f();
            ((ListenResponse) this.f33398b).D0(documentDelete);
            return this;
        }

        public Builder mergeDocumentRemove(DocumentRemove documentRemove) {
            f();
            ((ListenResponse) this.f33398b).E0(documentRemove);
            return this;
        }

        public Builder mergeFilter(ExistenceFilter existenceFilter) {
            f();
            ((ListenResponse) this.f33398b).F0(existenceFilter);
            return this;
        }

        public Builder mergeTargetChange(TargetChange targetChange) {
            f();
            ((ListenResponse) this.f33398b).G0(targetChange);
            return this;
        }

        public Builder setDocumentChange(DocumentChange documentChange) {
            f();
            ((ListenResponse) this.f33398b).H0(documentChange);
            return this;
        }

        public Builder setDocumentDelete(DocumentDelete documentDelete) {
            f();
            ((ListenResponse) this.f33398b).I0(documentDelete);
            return this;
        }

        public Builder setDocumentRemove(DocumentRemove documentRemove) {
            f();
            ((ListenResponse) this.f33398b).J0(documentRemove);
            return this;
        }

        public Builder setFilter(ExistenceFilter existenceFilter) {
            f();
            ((ListenResponse) this.f33398b).K0(existenceFilter);
            return this;
        }

        public Builder setTargetChange(TargetChange targetChange) {
            f();
            ((ListenResponse) this.f33398b).L0(targetChange);
            return this;
        }

        private Builder() {
            super(ListenResponse.DEFAULT_INSTANCE);
        }

        public Builder setDocumentChange(DocumentChange.Builder builder) {
            f();
            ((ListenResponse) this.f33398b).H0(builder.build());
            return this;
        }

        public Builder setDocumentDelete(DocumentDelete.Builder builder) {
            f();
            ((ListenResponse) this.f33398b).I0(builder.build());
            return this;
        }

        public Builder setDocumentRemove(DocumentRemove.Builder builder) {
            f();
            ((ListenResponse) this.f33398b).J0(builder.build());
            return this;
        }

        public Builder setFilter(ExistenceFilter.Builder builder) {
            f();
            ((ListenResponse) this.f33398b).K0(builder.build());
            return this;
        }

        public Builder setTargetChange(TargetChange.Builder builder) {
            f();
            ((ListenResponse) this.f33398b).L0(builder.build());
            return this;
        }
    }

    /* loaded from: classes5.dex */
    public enum ResponseTypeCase {
        TARGET_CHANGE(2),
        DOCUMENT_CHANGE(3),
        DOCUMENT_DELETE(4),
        DOCUMENT_REMOVE(6),
        FILTER(5),
        RESPONSETYPE_NOT_SET(0);
        
        private final int value;

        ResponseTypeCase(int i4) {
            this.value = i4;
        }

        public static ResponseTypeCase forNumber(int i4) {
            if (i4 != 0) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        if (i4 != 4) {
                            if (i4 != 5) {
                                if (i4 != 6) {
                                    return null;
                                }
                                return DOCUMENT_REMOVE;
                            }
                            return FILTER;
                        }
                        return DOCUMENT_DELETE;
                    }
                    return DOCUMENT_CHANGE;
                }
                return TARGET_CHANGE;
            }
            return RESPONSETYPE_NOT_SET;
        }

        public int getNumber() {
            return this.value;
        }

        @Deprecated
        public static ResponseTypeCase valueOf(int i4) {
            return forNumber(i4);
        }
    }

    static {
        ListenResponse listenResponse = new ListenResponse();
        DEFAULT_INSTANCE = listenResponse;
        GeneratedMessageLite.d0(ListenResponse.class, listenResponse);
    }

    private ListenResponse() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0() {
        this.responseTypeCase_ = 0;
        this.responseType_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B0() {
        if (this.responseTypeCase_ == 2) {
            this.responseTypeCase_ = 0;
            this.responseType_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C0(DocumentChange documentChange) {
        documentChange.getClass();
        if (this.responseTypeCase_ == 3 && this.responseType_ != DocumentChange.getDefaultInstance()) {
            this.responseType_ = DocumentChange.newBuilder((DocumentChange) this.responseType_).mergeFrom((DocumentChange.Builder) documentChange).buildPartial();
        } else {
            this.responseType_ = documentChange;
        }
        this.responseTypeCase_ = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D0(DocumentDelete documentDelete) {
        documentDelete.getClass();
        if (this.responseTypeCase_ == 4 && this.responseType_ != DocumentDelete.getDefaultInstance()) {
            this.responseType_ = DocumentDelete.newBuilder((DocumentDelete) this.responseType_).mergeFrom((DocumentDelete.Builder) documentDelete).buildPartial();
        } else {
            this.responseType_ = documentDelete;
        }
        this.responseTypeCase_ = 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E0(DocumentRemove documentRemove) {
        documentRemove.getClass();
        if (this.responseTypeCase_ == 6 && this.responseType_ != DocumentRemove.getDefaultInstance()) {
            this.responseType_ = DocumentRemove.newBuilder((DocumentRemove) this.responseType_).mergeFrom((DocumentRemove.Builder) documentRemove).buildPartial();
        } else {
            this.responseType_ = documentRemove;
        }
        this.responseTypeCase_ = 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F0(ExistenceFilter existenceFilter) {
        existenceFilter.getClass();
        if (this.responseTypeCase_ == 5 && this.responseType_ != ExistenceFilter.getDefaultInstance()) {
            this.responseType_ = ExistenceFilter.newBuilder((ExistenceFilter) this.responseType_).mergeFrom((ExistenceFilter.Builder) existenceFilter).buildPartial();
        } else {
            this.responseType_ = existenceFilter;
        }
        this.responseTypeCase_ = 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G0(TargetChange targetChange) {
        targetChange.getClass();
        if (this.responseTypeCase_ == 2 && this.responseType_ != TargetChange.getDefaultInstance()) {
            this.responseType_ = TargetChange.newBuilder((TargetChange) this.responseType_).mergeFrom((TargetChange.Builder) targetChange).buildPartial();
        } else {
            this.responseType_ = targetChange;
        }
        this.responseTypeCase_ = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H0(DocumentChange documentChange) {
        documentChange.getClass();
        this.responseType_ = documentChange;
        this.responseTypeCase_ = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I0(DocumentDelete documentDelete) {
        documentDelete.getClass();
        this.responseType_ = documentDelete;
        this.responseTypeCase_ = 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J0(DocumentRemove documentRemove) {
        documentRemove.getClass();
        this.responseType_ = documentRemove;
        this.responseTypeCase_ = 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K0(ExistenceFilter existenceFilter) {
        existenceFilter.getClass();
        this.responseType_ = existenceFilter;
        this.responseTypeCase_ = 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L0(TargetChange targetChange) {
        targetChange.getClass();
        this.responseType_ = targetChange;
        this.responseTypeCase_ = 2;
    }

    public static ListenResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.q();
    }

    public static ListenResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (ListenResponse) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
    }

    public static ListenResponse parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (ListenResponse) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<ListenResponse> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w0() {
        if (this.responseTypeCase_ == 3) {
            this.responseTypeCase_ = 0;
            this.responseType_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0() {
        if (this.responseTypeCase_ == 4) {
            this.responseTypeCase_ = 0;
            this.responseType_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0() {
        if (this.responseTypeCase_ == 6) {
            this.responseTypeCase_ = 0;
            this.responseType_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0() {
        if (this.responseTypeCase_ == 5) {
            this.responseTypeCase_ = 0;
            this.responseType_ = null;
        }
    }

    @Override // com.google.firestore.v1.ListenResponseOrBuilder
    public DocumentChange getDocumentChange() {
        if (this.responseTypeCase_ == 3) {
            return (DocumentChange) this.responseType_;
        }
        return DocumentChange.getDefaultInstance();
    }

    @Override // com.google.firestore.v1.ListenResponseOrBuilder
    public DocumentDelete getDocumentDelete() {
        if (this.responseTypeCase_ == 4) {
            return (DocumentDelete) this.responseType_;
        }
        return DocumentDelete.getDefaultInstance();
    }

    @Override // com.google.firestore.v1.ListenResponseOrBuilder
    public DocumentRemove getDocumentRemove() {
        if (this.responseTypeCase_ == 6) {
            return (DocumentRemove) this.responseType_;
        }
        return DocumentRemove.getDefaultInstance();
    }

    @Override // com.google.firestore.v1.ListenResponseOrBuilder
    public ExistenceFilter getFilter() {
        if (this.responseTypeCase_ == 5) {
            return (ExistenceFilter) this.responseType_;
        }
        return ExistenceFilter.getDefaultInstance();
    }

    @Override // com.google.firestore.v1.ListenResponseOrBuilder
    public ResponseTypeCase getResponseTypeCase() {
        return ResponseTypeCase.forNumber(this.responseTypeCase_);
    }

    @Override // com.google.firestore.v1.ListenResponseOrBuilder
    public TargetChange getTargetChange() {
        if (this.responseTypeCase_ == 2) {
            return (TargetChange) this.responseType_;
        }
        return TargetChange.getDefaultInstance();
    }

    @Override // com.google.firestore.v1.ListenResponseOrBuilder
    public boolean hasDocumentChange() {
        if (this.responseTypeCase_ == 3) {
            return true;
        }
        return false;
    }

    @Override // com.google.firestore.v1.ListenResponseOrBuilder
    public boolean hasDocumentDelete() {
        if (this.responseTypeCase_ == 4) {
            return true;
        }
        return false;
    }

    @Override // com.google.firestore.v1.ListenResponseOrBuilder
    public boolean hasDocumentRemove() {
        if (this.responseTypeCase_ == 6) {
            return true;
        }
        return false;
    }

    @Override // com.google.firestore.v1.ListenResponseOrBuilder
    public boolean hasFilter() {
        if (this.responseTypeCase_ == 5) {
            return true;
        }
        return false;
    }

    @Override // com.google.firestore.v1.ListenResponseOrBuilder
    public boolean hasTargetChange() {
        if (this.responseTypeCase_ == 2) {
            return true;
        }
        return false;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.f32488a[methodToInvoke.ordinal()]) {
            case 1:
                return new ListenResponse();
            case 2:
                return new Builder(null);
            case 3:
                return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0005\u0001\u0000\u0002\u0006\u0005\u0000\u0000\u0000\u0002<\u0000\u0003<\u0000\u0004<\u0000\u0005<\u0000\u0006<\u0000", new Object[]{"responseType_", "responseTypeCase_", TargetChange.class, DocumentChange.class, DocumentDelete.class, ExistenceFilter.class, DocumentRemove.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<ListenResponse> parser = PARSER;
                if (parser == null) {
                    synchronized (ListenResponse.class) {
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

    public static Builder newBuilder(ListenResponse listenResponse) {
        return DEFAULT_INSTANCE.r(listenResponse);
    }

    public static ListenResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ListenResponse) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ListenResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ListenResponse) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static ListenResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (ListenResponse) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
    }

    public static ListenResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ListenResponse) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static ListenResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (ListenResponse) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
    }

    public static ListenResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ListenResponse) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static ListenResponse parseFrom(InputStream inputStream) throws IOException {
        return (ListenResponse) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
    }

    public static ListenResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ListenResponse) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ListenResponse parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (ListenResponse) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
    }

    public static ListenResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ListenResponse) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
