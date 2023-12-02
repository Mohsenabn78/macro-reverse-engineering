package com.google.firestore.v1;

import com.google.firestore.v1.Document;
import com.google.firestore.v1.DocumentMask;
import com.google.firestore.v1.DocumentTransform;
import com.google.firestore.v1.Precondition;
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
public final class Write extends GeneratedMessageLite<Write, Builder> implements WriteOrBuilder {
    public static final int CURRENT_DOCUMENT_FIELD_NUMBER = 4;
    private static final Write DEFAULT_INSTANCE;
    public static final int DELETE_FIELD_NUMBER = 2;
    private static volatile Parser<Write> PARSER = null;
    public static final int TRANSFORM_FIELD_NUMBER = 6;
    public static final int UPDATE_FIELD_NUMBER = 1;
    public static final int UPDATE_MASK_FIELD_NUMBER = 3;
    public static final int UPDATE_TRANSFORMS_FIELD_NUMBER = 7;
    public static final int VERIFY_FIELD_NUMBER = 5;
    private Precondition currentDocument_;
    private Object operation_;
    private DocumentMask updateMask_;
    private int operationCase_ = 0;
    private Internal.ProtobufList<DocumentTransform.FieldTransform> updateTransforms_ = GeneratedMessageLite.y();

    /* renamed from: com.google.firestore.v1.Write$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f32535a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f32535a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32535a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32535a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32535a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f32535a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f32535a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f32535a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<Write, Builder> implements WriteOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllUpdateTransforms(Iterable<? extends DocumentTransform.FieldTransform> iterable) {
            f();
            ((Write) this.f33398b).F0(iterable);
            return this;
        }

        public Builder addUpdateTransforms(DocumentTransform.FieldTransform fieldTransform) {
            f();
            ((Write) this.f33398b).H0(fieldTransform);
            return this;
        }

        public Builder clearCurrentDocument() {
            f();
            ((Write) this.f33398b).I0();
            return this;
        }

        public Builder clearDelete() {
            f();
            ((Write) this.f33398b).J0();
            return this;
        }

        public Builder clearOperation() {
            f();
            ((Write) this.f33398b).K0();
            return this;
        }

        public Builder clearTransform() {
            f();
            ((Write) this.f33398b).L0();
            return this;
        }

        public Builder clearUpdate() {
            f();
            ((Write) this.f33398b).M0();
            return this;
        }

        public Builder clearUpdateMask() {
            f();
            ((Write) this.f33398b).N0();
            return this;
        }

        public Builder clearUpdateTransforms() {
            f();
            ((Write) this.f33398b).O0();
            return this;
        }

        public Builder clearVerify() {
            f();
            ((Write) this.f33398b).P0();
            return this;
        }

        @Override // com.google.firestore.v1.WriteOrBuilder
        public Precondition getCurrentDocument() {
            return ((Write) this.f33398b).getCurrentDocument();
        }

        @Override // com.google.firestore.v1.WriteOrBuilder
        public String getDelete() {
            return ((Write) this.f33398b).getDelete();
        }

        @Override // com.google.firestore.v1.WriteOrBuilder
        public ByteString getDeleteBytes() {
            return ((Write) this.f33398b).getDeleteBytes();
        }

        @Override // com.google.firestore.v1.WriteOrBuilder
        public OperationCase getOperationCase() {
            return ((Write) this.f33398b).getOperationCase();
        }

        @Override // com.google.firestore.v1.WriteOrBuilder
        public DocumentTransform getTransform() {
            return ((Write) this.f33398b).getTransform();
        }

        @Override // com.google.firestore.v1.WriteOrBuilder
        public Document getUpdate() {
            return ((Write) this.f33398b).getUpdate();
        }

        @Override // com.google.firestore.v1.WriteOrBuilder
        public DocumentMask getUpdateMask() {
            return ((Write) this.f33398b).getUpdateMask();
        }

        @Override // com.google.firestore.v1.WriteOrBuilder
        public DocumentTransform.FieldTransform getUpdateTransforms(int i4) {
            return ((Write) this.f33398b).getUpdateTransforms(i4);
        }

        @Override // com.google.firestore.v1.WriteOrBuilder
        public int getUpdateTransformsCount() {
            return ((Write) this.f33398b).getUpdateTransformsCount();
        }

        @Override // com.google.firestore.v1.WriteOrBuilder
        public List<DocumentTransform.FieldTransform> getUpdateTransformsList() {
            return Collections.unmodifiableList(((Write) this.f33398b).getUpdateTransformsList());
        }

        @Override // com.google.firestore.v1.WriteOrBuilder
        public String getVerify() {
            return ((Write) this.f33398b).getVerify();
        }

        @Override // com.google.firestore.v1.WriteOrBuilder
        public ByteString getVerifyBytes() {
            return ((Write) this.f33398b).getVerifyBytes();
        }

        @Override // com.google.firestore.v1.WriteOrBuilder
        public boolean hasCurrentDocument() {
            return ((Write) this.f33398b).hasCurrentDocument();
        }

        @Override // com.google.firestore.v1.WriteOrBuilder
        public boolean hasDelete() {
            return ((Write) this.f33398b).hasDelete();
        }

        @Override // com.google.firestore.v1.WriteOrBuilder
        public boolean hasTransform() {
            return ((Write) this.f33398b).hasTransform();
        }

        @Override // com.google.firestore.v1.WriteOrBuilder
        public boolean hasUpdate() {
            return ((Write) this.f33398b).hasUpdate();
        }

        @Override // com.google.firestore.v1.WriteOrBuilder
        public boolean hasUpdateMask() {
            return ((Write) this.f33398b).hasUpdateMask();
        }

        @Override // com.google.firestore.v1.WriteOrBuilder
        public boolean hasVerify() {
            return ((Write) this.f33398b).hasVerify();
        }

        public Builder mergeCurrentDocument(Precondition precondition) {
            f();
            ((Write) this.f33398b).R0(precondition);
            return this;
        }

        public Builder mergeTransform(DocumentTransform documentTransform) {
            f();
            ((Write) this.f33398b).S0(documentTransform);
            return this;
        }

        public Builder mergeUpdate(Document document) {
            f();
            ((Write) this.f33398b).T0(document);
            return this;
        }

        public Builder mergeUpdateMask(DocumentMask documentMask) {
            f();
            ((Write) this.f33398b).U0(documentMask);
            return this;
        }

        public Builder removeUpdateTransforms(int i4) {
            f();
            ((Write) this.f33398b).V0(i4);
            return this;
        }

        public Builder setCurrentDocument(Precondition precondition) {
            f();
            ((Write) this.f33398b).W0(precondition);
            return this;
        }

        public Builder setDelete(String str) {
            f();
            ((Write) this.f33398b).X0(str);
            return this;
        }

        public Builder setDeleteBytes(ByteString byteString) {
            f();
            ((Write) this.f33398b).Y0(byteString);
            return this;
        }

        public Builder setTransform(DocumentTransform documentTransform) {
            f();
            ((Write) this.f33398b).Z0(documentTransform);
            return this;
        }

        public Builder setUpdate(Document document) {
            f();
            ((Write) this.f33398b).a1(document);
            return this;
        }

        public Builder setUpdateMask(DocumentMask documentMask) {
            f();
            ((Write) this.f33398b).b1(documentMask);
            return this;
        }

        public Builder setUpdateTransforms(int i4, DocumentTransform.FieldTransform fieldTransform) {
            f();
            ((Write) this.f33398b).c1(i4, fieldTransform);
            return this;
        }

        public Builder setVerify(String str) {
            f();
            ((Write) this.f33398b).d1(str);
            return this;
        }

        public Builder setVerifyBytes(ByteString byteString) {
            f();
            ((Write) this.f33398b).e1(byteString);
            return this;
        }

        private Builder() {
            super(Write.DEFAULT_INSTANCE);
        }

        public Builder addUpdateTransforms(int i4, DocumentTransform.FieldTransform fieldTransform) {
            f();
            ((Write) this.f33398b).G0(i4, fieldTransform);
            return this;
        }

        public Builder setCurrentDocument(Precondition.Builder builder) {
            f();
            ((Write) this.f33398b).W0(builder.build());
            return this;
        }

        public Builder setTransform(DocumentTransform.Builder builder) {
            f();
            ((Write) this.f33398b).Z0(builder.build());
            return this;
        }

        public Builder setUpdate(Document.Builder builder) {
            f();
            ((Write) this.f33398b).a1(builder.build());
            return this;
        }

        public Builder setUpdateMask(DocumentMask.Builder builder) {
            f();
            ((Write) this.f33398b).b1(builder.build());
            return this;
        }

        public Builder setUpdateTransforms(int i4, DocumentTransform.FieldTransform.Builder builder) {
            f();
            ((Write) this.f33398b).c1(i4, builder.build());
            return this;
        }

        public Builder addUpdateTransforms(DocumentTransform.FieldTransform.Builder builder) {
            f();
            ((Write) this.f33398b).H0(builder.build());
            return this;
        }

        public Builder addUpdateTransforms(int i4, DocumentTransform.FieldTransform.Builder builder) {
            f();
            ((Write) this.f33398b).G0(i4, builder.build());
            return this;
        }
    }

    /* loaded from: classes5.dex */
    public enum OperationCase {
        UPDATE(1),
        DELETE(2),
        VERIFY(5),
        TRANSFORM(6),
        OPERATION_NOT_SET(0);
        
        private final int value;

        OperationCase(int i4) {
            this.value = i4;
        }

        public static OperationCase forNumber(int i4) {
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 != 2) {
                        if (i4 != 5) {
                            if (i4 != 6) {
                                return null;
                            }
                            return TRANSFORM;
                        }
                        return VERIFY;
                    }
                    return DELETE;
                }
                return UPDATE;
            }
            return OPERATION_NOT_SET;
        }

        public int getNumber() {
            return this.value;
        }

        @Deprecated
        public static OperationCase valueOf(int i4) {
            return forNumber(i4);
        }
    }

    static {
        Write write = new Write();
        DEFAULT_INSTANCE = write;
        GeneratedMessageLite.d0(Write.class, write);
    }

    private Write() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F0(Iterable<? extends DocumentTransform.FieldTransform> iterable) {
        Q0();
        AbstractMessageLite.a(iterable, this.updateTransforms_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G0(int i4, DocumentTransform.FieldTransform fieldTransform) {
        fieldTransform.getClass();
        Q0();
        this.updateTransforms_.add(i4, fieldTransform);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H0(DocumentTransform.FieldTransform fieldTransform) {
        fieldTransform.getClass();
        Q0();
        this.updateTransforms_.add(fieldTransform);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I0() {
        this.currentDocument_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J0() {
        if (this.operationCase_ == 2) {
            this.operationCase_ = 0;
            this.operation_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K0() {
        this.operationCase_ = 0;
        this.operation_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L0() {
        if (this.operationCase_ == 6) {
            this.operationCase_ = 0;
            this.operation_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M0() {
        if (this.operationCase_ == 1) {
            this.operationCase_ = 0;
            this.operation_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N0() {
        this.updateMask_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O0() {
        this.updateTransforms_ = GeneratedMessageLite.y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P0() {
        if (this.operationCase_ == 5) {
            this.operationCase_ = 0;
            this.operation_ = null;
        }
    }

    private void Q0() {
        Internal.ProtobufList<DocumentTransform.FieldTransform> protobufList = this.updateTransforms_;
        if (!protobufList.isModifiable()) {
            this.updateTransforms_ = GeneratedMessageLite.K(protobufList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R0(Precondition precondition) {
        precondition.getClass();
        Precondition precondition2 = this.currentDocument_;
        if (precondition2 != null && precondition2 != Precondition.getDefaultInstance()) {
            this.currentDocument_ = Precondition.newBuilder(this.currentDocument_).mergeFrom((Precondition.Builder) precondition).buildPartial();
        } else {
            this.currentDocument_ = precondition;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S0(DocumentTransform documentTransform) {
        documentTransform.getClass();
        if (this.operationCase_ == 6 && this.operation_ != DocumentTransform.getDefaultInstance()) {
            this.operation_ = DocumentTransform.newBuilder((DocumentTransform) this.operation_).mergeFrom((DocumentTransform.Builder) documentTransform).buildPartial();
        } else {
            this.operation_ = documentTransform;
        }
        this.operationCase_ = 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T0(Document document) {
        document.getClass();
        if (this.operationCase_ == 1 && this.operation_ != Document.getDefaultInstance()) {
            this.operation_ = Document.newBuilder((Document) this.operation_).mergeFrom((Document.Builder) document).buildPartial();
        } else {
            this.operation_ = document;
        }
        this.operationCase_ = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U0(DocumentMask documentMask) {
        documentMask.getClass();
        DocumentMask documentMask2 = this.updateMask_;
        if (documentMask2 != null && documentMask2 != DocumentMask.getDefaultInstance()) {
            this.updateMask_ = DocumentMask.newBuilder(this.updateMask_).mergeFrom((DocumentMask.Builder) documentMask).buildPartial();
        } else {
            this.updateMask_ = documentMask;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V0(int i4) {
        Q0();
        this.updateTransforms_.remove(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W0(Precondition precondition) {
        precondition.getClass();
        this.currentDocument_ = precondition;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X0(String str) {
        str.getClass();
        this.operationCase_ = 2;
        this.operation_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y0(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        this.operation_ = byteString.toStringUtf8();
        this.operationCase_ = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z0(DocumentTransform documentTransform) {
        documentTransform.getClass();
        this.operation_ = documentTransform;
        this.operationCase_ = 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a1(Document document) {
        document.getClass();
        this.operation_ = document;
        this.operationCase_ = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b1(DocumentMask documentMask) {
        documentMask.getClass();
        this.updateMask_ = documentMask;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c1(int i4, DocumentTransform.FieldTransform fieldTransform) {
        fieldTransform.getClass();
        Q0();
        this.updateTransforms_.set(i4, fieldTransform);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d1(String str) {
        str.getClass();
        this.operationCase_ = 5;
        this.operation_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e1(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        this.operation_ = byteString.toStringUtf8();
        this.operationCase_ = 5;
    }

    public static Write getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.q();
    }

    public static Write parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Write) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
    }

    public static Write parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (Write) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Write> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    @Override // com.google.firestore.v1.WriteOrBuilder
    public Precondition getCurrentDocument() {
        Precondition precondition = this.currentDocument_;
        if (precondition == null) {
            return Precondition.getDefaultInstance();
        }
        return precondition;
    }

    @Override // com.google.firestore.v1.WriteOrBuilder
    public String getDelete() {
        if (this.operationCase_ == 2) {
            return (String) this.operation_;
        }
        return "";
    }

    @Override // com.google.firestore.v1.WriteOrBuilder
    public ByteString getDeleteBytes() {
        String str;
        if (this.operationCase_ == 2) {
            str = (String) this.operation_;
        } else {
            str = "";
        }
        return ByteString.copyFromUtf8(str);
    }

    @Override // com.google.firestore.v1.WriteOrBuilder
    public OperationCase getOperationCase() {
        return OperationCase.forNumber(this.operationCase_);
    }

    @Override // com.google.firestore.v1.WriteOrBuilder
    public DocumentTransform getTransform() {
        if (this.operationCase_ == 6) {
            return (DocumentTransform) this.operation_;
        }
        return DocumentTransform.getDefaultInstance();
    }

    @Override // com.google.firestore.v1.WriteOrBuilder
    public Document getUpdate() {
        if (this.operationCase_ == 1) {
            return (Document) this.operation_;
        }
        return Document.getDefaultInstance();
    }

    @Override // com.google.firestore.v1.WriteOrBuilder
    public DocumentMask getUpdateMask() {
        DocumentMask documentMask = this.updateMask_;
        if (documentMask == null) {
            return DocumentMask.getDefaultInstance();
        }
        return documentMask;
    }

    @Override // com.google.firestore.v1.WriteOrBuilder
    public DocumentTransform.FieldTransform getUpdateTransforms(int i4) {
        return this.updateTransforms_.get(i4);
    }

    @Override // com.google.firestore.v1.WriteOrBuilder
    public int getUpdateTransformsCount() {
        return this.updateTransforms_.size();
    }

    @Override // com.google.firestore.v1.WriteOrBuilder
    public List<DocumentTransform.FieldTransform> getUpdateTransformsList() {
        return this.updateTransforms_;
    }

    public DocumentTransform.FieldTransformOrBuilder getUpdateTransformsOrBuilder(int i4) {
        return this.updateTransforms_.get(i4);
    }

    public List<? extends DocumentTransform.FieldTransformOrBuilder> getUpdateTransformsOrBuilderList() {
        return this.updateTransforms_;
    }

    @Override // com.google.firestore.v1.WriteOrBuilder
    public String getVerify() {
        if (this.operationCase_ == 5) {
            return (String) this.operation_;
        }
        return "";
    }

    @Override // com.google.firestore.v1.WriteOrBuilder
    public ByteString getVerifyBytes() {
        String str;
        if (this.operationCase_ == 5) {
            str = (String) this.operation_;
        } else {
            str = "";
        }
        return ByteString.copyFromUtf8(str);
    }

    @Override // com.google.firestore.v1.WriteOrBuilder
    public boolean hasCurrentDocument() {
        if (this.currentDocument_ != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.firestore.v1.WriteOrBuilder
    public boolean hasDelete() {
        if (this.operationCase_ == 2) {
            return true;
        }
        return false;
    }

    @Override // com.google.firestore.v1.WriteOrBuilder
    public boolean hasTransform() {
        if (this.operationCase_ == 6) {
            return true;
        }
        return false;
    }

    @Override // com.google.firestore.v1.WriteOrBuilder
    public boolean hasUpdate() {
        if (this.operationCase_ == 1) {
            return true;
        }
        return false;
    }

    @Override // com.google.firestore.v1.WriteOrBuilder
    public boolean hasUpdateMask() {
        if (this.updateMask_ != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.firestore.v1.WriteOrBuilder
    public boolean hasVerify() {
        if (this.operationCase_ == 5) {
            return true;
        }
        return false;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.f32535a[methodToInvoke.ordinal()]) {
            case 1:
                return new Write();
            case 2:
                return new Builder(null);
            case 3:
                return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0007\u0001\u0000\u0001\u0007\u0007\u0000\u0001\u0000\u0001<\u0000\u0002Ȼ\u0000\u0003\t\u0004\t\u0005Ȼ\u0000\u0006<\u0000\u0007\u001b", new Object[]{"operation_", "operationCase_", Document.class, "updateMask_", "currentDocument_", DocumentTransform.class, "updateTransforms_", DocumentTransform.FieldTransform.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Write> parser = PARSER;
                if (parser == null) {
                    synchronized (Write.class) {
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

    public static Builder newBuilder(Write write) {
        return DEFAULT_INSTANCE.r(write);
    }

    public static Write parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Write) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Write parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Write) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Write parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (Write) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
    }

    public static Write parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Write) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Write parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (Write) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
    }

    public static Write parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Write) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Write parseFrom(InputStream inputStream) throws IOException {
        return (Write) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
    }

    public static Write parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Write) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Write parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Write) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Write parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Write) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
