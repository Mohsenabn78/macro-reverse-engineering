package com.google.firestore.v1;

import com.google.firestore.v1.ArrayValue;
import com.google.firestore.v1.Value;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
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
public final class DocumentTransform extends GeneratedMessageLite<DocumentTransform, Builder> implements DocumentTransformOrBuilder {
    private static final DocumentTransform DEFAULT_INSTANCE;
    public static final int DOCUMENT_FIELD_NUMBER = 1;
    public static final int FIELD_TRANSFORMS_FIELD_NUMBER = 2;
    private static volatile Parser<DocumentTransform> PARSER;
    private String document_ = "";
    private Internal.ProtobufList<FieldTransform> fieldTransforms_ = GeneratedMessageLite.y();

    /* renamed from: com.google.firestore.v1.DocumentTransform$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f32455a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f32455a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32455a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32455a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32455a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f32455a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f32455a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f32455a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<DocumentTransform, Builder> implements DocumentTransformOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllFieldTransforms(Iterable<? extends FieldTransform> iterable) {
            f();
            ((DocumentTransform) this.f33398b).p0(iterable);
            return this;
        }

        public Builder addFieldTransforms(FieldTransform fieldTransform) {
            f();
            ((DocumentTransform) this.f33398b).r0(fieldTransform);
            return this;
        }

        public Builder clearDocument() {
            f();
            ((DocumentTransform) this.f33398b).s0();
            return this;
        }

        public Builder clearFieldTransforms() {
            f();
            ((DocumentTransform) this.f33398b).t0();
            return this;
        }

        @Override // com.google.firestore.v1.DocumentTransformOrBuilder
        public String getDocument() {
            return ((DocumentTransform) this.f33398b).getDocument();
        }

        @Override // com.google.firestore.v1.DocumentTransformOrBuilder
        public ByteString getDocumentBytes() {
            return ((DocumentTransform) this.f33398b).getDocumentBytes();
        }

        @Override // com.google.firestore.v1.DocumentTransformOrBuilder
        public FieldTransform getFieldTransforms(int i4) {
            return ((DocumentTransform) this.f33398b).getFieldTransforms(i4);
        }

        @Override // com.google.firestore.v1.DocumentTransformOrBuilder
        public int getFieldTransformsCount() {
            return ((DocumentTransform) this.f33398b).getFieldTransformsCount();
        }

        @Override // com.google.firestore.v1.DocumentTransformOrBuilder
        public List<FieldTransform> getFieldTransformsList() {
            return Collections.unmodifiableList(((DocumentTransform) this.f33398b).getFieldTransformsList());
        }

        public Builder removeFieldTransforms(int i4) {
            f();
            ((DocumentTransform) this.f33398b).v0(i4);
            return this;
        }

        public Builder setDocument(String str) {
            f();
            ((DocumentTransform) this.f33398b).w0(str);
            return this;
        }

        public Builder setDocumentBytes(ByteString byteString) {
            f();
            ((DocumentTransform) this.f33398b).x0(byteString);
            return this;
        }

        public Builder setFieldTransforms(int i4, FieldTransform fieldTransform) {
            f();
            ((DocumentTransform) this.f33398b).y0(i4, fieldTransform);
            return this;
        }

        private Builder() {
            super(DocumentTransform.DEFAULT_INSTANCE);
        }

        public Builder addFieldTransforms(int i4, FieldTransform fieldTransform) {
            f();
            ((DocumentTransform) this.f33398b).q0(i4, fieldTransform);
            return this;
        }

        public Builder setFieldTransforms(int i4, FieldTransform.Builder builder) {
            f();
            ((DocumentTransform) this.f33398b).y0(i4, builder.build());
            return this;
        }

        public Builder addFieldTransforms(FieldTransform.Builder builder) {
            f();
            ((DocumentTransform) this.f33398b).r0(builder.build());
            return this;
        }

        public Builder addFieldTransforms(int i4, FieldTransform.Builder builder) {
            f();
            ((DocumentTransform) this.f33398b).q0(i4, builder.build());
            return this;
        }
    }

    /* loaded from: classes5.dex */
    public static final class FieldTransform extends GeneratedMessageLite<FieldTransform, Builder> implements FieldTransformOrBuilder {
        public static final int APPEND_MISSING_ELEMENTS_FIELD_NUMBER = 6;
        private static final FieldTransform DEFAULT_INSTANCE;
        public static final int FIELD_PATH_FIELD_NUMBER = 1;
        public static final int INCREMENT_FIELD_NUMBER = 3;
        public static final int MAXIMUM_FIELD_NUMBER = 4;
        public static final int MINIMUM_FIELD_NUMBER = 5;
        private static volatile Parser<FieldTransform> PARSER = null;
        public static final int REMOVE_ALL_FROM_ARRAY_FIELD_NUMBER = 7;
        public static final int SET_TO_SERVER_VALUE_FIELD_NUMBER = 2;
        private Object transformType_;
        private int transformTypeCase_ = 0;
        private String fieldPath_ = "";

        /* loaded from: classes5.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<FieldTransform, Builder> implements FieldTransformOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearAppendMissingElements() {
                f();
                ((FieldTransform) this.f33398b).C0();
                return this;
            }

            public Builder clearFieldPath() {
                f();
                ((FieldTransform) this.f33398b).D0();
                return this;
            }

            public Builder clearIncrement() {
                f();
                ((FieldTransform) this.f33398b).E0();
                return this;
            }

            public Builder clearMaximum() {
                f();
                ((FieldTransform) this.f33398b).F0();
                return this;
            }

            public Builder clearMinimum() {
                f();
                ((FieldTransform) this.f33398b).G0();
                return this;
            }

            public Builder clearRemoveAllFromArray() {
                f();
                ((FieldTransform) this.f33398b).H0();
                return this;
            }

            public Builder clearSetToServerValue() {
                f();
                ((FieldTransform) this.f33398b).I0();
                return this;
            }

            public Builder clearTransformType() {
                f();
                ((FieldTransform) this.f33398b).J0();
                return this;
            }

            @Override // com.google.firestore.v1.DocumentTransform.FieldTransformOrBuilder
            public ArrayValue getAppendMissingElements() {
                return ((FieldTransform) this.f33398b).getAppendMissingElements();
            }

            @Override // com.google.firestore.v1.DocumentTransform.FieldTransformOrBuilder
            public String getFieldPath() {
                return ((FieldTransform) this.f33398b).getFieldPath();
            }

            @Override // com.google.firestore.v1.DocumentTransform.FieldTransformOrBuilder
            public ByteString getFieldPathBytes() {
                return ((FieldTransform) this.f33398b).getFieldPathBytes();
            }

            @Override // com.google.firestore.v1.DocumentTransform.FieldTransformOrBuilder
            public Value getIncrement() {
                return ((FieldTransform) this.f33398b).getIncrement();
            }

            @Override // com.google.firestore.v1.DocumentTransform.FieldTransformOrBuilder
            public Value getMaximum() {
                return ((FieldTransform) this.f33398b).getMaximum();
            }

            @Override // com.google.firestore.v1.DocumentTransform.FieldTransformOrBuilder
            public Value getMinimum() {
                return ((FieldTransform) this.f33398b).getMinimum();
            }

            @Override // com.google.firestore.v1.DocumentTransform.FieldTransformOrBuilder
            public ArrayValue getRemoveAllFromArray() {
                return ((FieldTransform) this.f33398b).getRemoveAllFromArray();
            }

            @Override // com.google.firestore.v1.DocumentTransform.FieldTransformOrBuilder
            public ServerValue getSetToServerValue() {
                return ((FieldTransform) this.f33398b).getSetToServerValue();
            }

            @Override // com.google.firestore.v1.DocumentTransform.FieldTransformOrBuilder
            public int getSetToServerValueValue() {
                return ((FieldTransform) this.f33398b).getSetToServerValueValue();
            }

            @Override // com.google.firestore.v1.DocumentTransform.FieldTransformOrBuilder
            public TransformTypeCase getTransformTypeCase() {
                return ((FieldTransform) this.f33398b).getTransformTypeCase();
            }

            @Override // com.google.firestore.v1.DocumentTransform.FieldTransformOrBuilder
            public boolean hasAppendMissingElements() {
                return ((FieldTransform) this.f33398b).hasAppendMissingElements();
            }

            @Override // com.google.firestore.v1.DocumentTransform.FieldTransformOrBuilder
            public boolean hasIncrement() {
                return ((FieldTransform) this.f33398b).hasIncrement();
            }

            @Override // com.google.firestore.v1.DocumentTransform.FieldTransformOrBuilder
            public boolean hasMaximum() {
                return ((FieldTransform) this.f33398b).hasMaximum();
            }

            @Override // com.google.firestore.v1.DocumentTransform.FieldTransformOrBuilder
            public boolean hasMinimum() {
                return ((FieldTransform) this.f33398b).hasMinimum();
            }

            @Override // com.google.firestore.v1.DocumentTransform.FieldTransformOrBuilder
            public boolean hasRemoveAllFromArray() {
                return ((FieldTransform) this.f33398b).hasRemoveAllFromArray();
            }

            @Override // com.google.firestore.v1.DocumentTransform.FieldTransformOrBuilder
            public boolean hasSetToServerValue() {
                return ((FieldTransform) this.f33398b).hasSetToServerValue();
            }

            public Builder mergeAppendMissingElements(ArrayValue arrayValue) {
                f();
                ((FieldTransform) this.f33398b).K0(arrayValue);
                return this;
            }

            public Builder mergeIncrement(Value value) {
                f();
                ((FieldTransform) this.f33398b).L0(value);
                return this;
            }

            public Builder mergeMaximum(Value value) {
                f();
                ((FieldTransform) this.f33398b).M0(value);
                return this;
            }

            public Builder mergeMinimum(Value value) {
                f();
                ((FieldTransform) this.f33398b).N0(value);
                return this;
            }

            public Builder mergeRemoveAllFromArray(ArrayValue arrayValue) {
                f();
                ((FieldTransform) this.f33398b).O0(arrayValue);
                return this;
            }

            public Builder setAppendMissingElements(ArrayValue arrayValue) {
                f();
                ((FieldTransform) this.f33398b).P0(arrayValue);
                return this;
            }

            public Builder setFieldPath(String str) {
                f();
                ((FieldTransform) this.f33398b).Q0(str);
                return this;
            }

            public Builder setFieldPathBytes(ByteString byteString) {
                f();
                ((FieldTransform) this.f33398b).R0(byteString);
                return this;
            }

            public Builder setIncrement(Value value) {
                f();
                ((FieldTransform) this.f33398b).S0(value);
                return this;
            }

            public Builder setMaximum(Value value) {
                f();
                ((FieldTransform) this.f33398b).T0(value);
                return this;
            }

            public Builder setMinimum(Value value) {
                f();
                ((FieldTransform) this.f33398b).U0(value);
                return this;
            }

            public Builder setRemoveAllFromArray(ArrayValue arrayValue) {
                f();
                ((FieldTransform) this.f33398b).V0(arrayValue);
                return this;
            }

            public Builder setSetToServerValue(ServerValue serverValue) {
                f();
                ((FieldTransform) this.f33398b).W0(serverValue);
                return this;
            }

            public Builder setSetToServerValueValue(int i4) {
                f();
                ((FieldTransform) this.f33398b).X0(i4);
                return this;
            }

            private Builder() {
                super(FieldTransform.DEFAULT_INSTANCE);
            }

            public Builder setAppendMissingElements(ArrayValue.Builder builder) {
                f();
                ((FieldTransform) this.f33398b).P0(builder.build());
                return this;
            }

            public Builder setIncrement(Value.Builder builder) {
                f();
                ((FieldTransform) this.f33398b).S0(builder.build());
                return this;
            }

            public Builder setMaximum(Value.Builder builder) {
                f();
                ((FieldTransform) this.f33398b).T0(builder.build());
                return this;
            }

            public Builder setMinimum(Value.Builder builder) {
                f();
                ((FieldTransform) this.f33398b).U0(builder.build());
                return this;
            }

            public Builder setRemoveAllFromArray(ArrayValue.Builder builder) {
                f();
                ((FieldTransform) this.f33398b).V0(builder.build());
                return this;
            }
        }

        /* loaded from: classes5.dex */
        public enum ServerValue implements Internal.EnumLite {
            SERVER_VALUE_UNSPECIFIED(0),
            REQUEST_TIME(1),
            UNRECOGNIZED(-1);
            
            public static final int REQUEST_TIME_VALUE = 1;
            public static final int SERVER_VALUE_UNSPECIFIED_VALUE = 0;

            /* renamed from: a  reason: collision with root package name */
            private static final Internal.EnumLiteMap<ServerValue> f32456a = new Internal.EnumLiteMap<ServerValue>() { // from class: com.google.firestore.v1.DocumentTransform.FieldTransform.ServerValue.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                /* renamed from: a */
                public ServerValue findValueByNumber(int i4) {
                    return ServerValue.forNumber(i4);
                }
            };
            private final int value;

            /* loaded from: classes5.dex */
            private static final class ServerValueVerifier implements Internal.EnumVerifier {

                /* renamed from: a  reason: collision with root package name */
                static final Internal.EnumVerifier f32458a = new ServerValueVerifier();

                private ServerValueVerifier() {
                }

                @Override // com.google.protobuf.Internal.EnumVerifier
                public boolean isInRange(int i4) {
                    if (ServerValue.forNumber(i4) != null) {
                        return true;
                    }
                    return false;
                }
            }

            ServerValue(int i4) {
                this.value = i4;
            }

            public static ServerValue forNumber(int i4) {
                if (i4 != 0) {
                    if (i4 != 1) {
                        return null;
                    }
                    return REQUEST_TIME;
                }
                return SERVER_VALUE_UNSPECIFIED;
            }

            public static Internal.EnumLiteMap<ServerValue> internalGetValueMap() {
                return f32456a;
            }

            public static Internal.EnumVerifier internalGetVerifier() {
                return ServerValueVerifier.f32458a;
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                if (this != UNRECOGNIZED) {
                    return this.value;
                }
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }

            @Deprecated
            public static ServerValue valueOf(int i4) {
                return forNumber(i4);
            }
        }

        /* loaded from: classes5.dex */
        public enum TransformTypeCase {
            SET_TO_SERVER_VALUE(2),
            INCREMENT(3),
            MAXIMUM(4),
            MINIMUM(5),
            APPEND_MISSING_ELEMENTS(6),
            REMOVE_ALL_FROM_ARRAY(7),
            TRANSFORMTYPE_NOT_SET(0);
            
            private final int value;

            TransformTypeCase(int i4) {
                this.value = i4;
            }

            public static TransformTypeCase forNumber(int i4) {
                if (i4 != 0) {
                    switch (i4) {
                        case 2:
                            return SET_TO_SERVER_VALUE;
                        case 3:
                            return INCREMENT;
                        case 4:
                            return MAXIMUM;
                        case 5:
                            return MINIMUM;
                        case 6:
                            return APPEND_MISSING_ELEMENTS;
                        case 7:
                            return REMOVE_ALL_FROM_ARRAY;
                        default:
                            return null;
                    }
                }
                return TRANSFORMTYPE_NOT_SET;
            }

            public int getNumber() {
                return this.value;
            }

            @Deprecated
            public static TransformTypeCase valueOf(int i4) {
                return forNumber(i4);
            }
        }

        static {
            FieldTransform fieldTransform = new FieldTransform();
            DEFAULT_INSTANCE = fieldTransform;
            GeneratedMessageLite.d0(FieldTransform.class, fieldTransform);
        }

        private FieldTransform() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void C0() {
            if (this.transformTypeCase_ == 6) {
                this.transformTypeCase_ = 0;
                this.transformType_ = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void D0() {
            this.fieldPath_ = getDefaultInstance().getFieldPath();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void E0() {
            if (this.transformTypeCase_ == 3) {
                this.transformTypeCase_ = 0;
                this.transformType_ = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void F0() {
            if (this.transformTypeCase_ == 4) {
                this.transformTypeCase_ = 0;
                this.transformType_ = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void G0() {
            if (this.transformTypeCase_ == 5) {
                this.transformTypeCase_ = 0;
                this.transformType_ = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void H0() {
            if (this.transformTypeCase_ == 7) {
                this.transformTypeCase_ = 0;
                this.transformType_ = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void I0() {
            if (this.transformTypeCase_ == 2) {
                this.transformTypeCase_ = 0;
                this.transformType_ = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void J0() {
            this.transformTypeCase_ = 0;
            this.transformType_ = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void K0(ArrayValue arrayValue) {
            arrayValue.getClass();
            if (this.transformTypeCase_ == 6 && this.transformType_ != ArrayValue.getDefaultInstance()) {
                this.transformType_ = ArrayValue.newBuilder((ArrayValue) this.transformType_).mergeFrom((ArrayValue.Builder) arrayValue).buildPartial();
            } else {
                this.transformType_ = arrayValue;
            }
            this.transformTypeCase_ = 6;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void L0(Value value) {
            value.getClass();
            if (this.transformTypeCase_ == 3 && this.transformType_ != Value.getDefaultInstance()) {
                this.transformType_ = Value.newBuilder((Value) this.transformType_).mergeFrom((Value.Builder) value).buildPartial();
            } else {
                this.transformType_ = value;
            }
            this.transformTypeCase_ = 3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void M0(Value value) {
            value.getClass();
            if (this.transformTypeCase_ == 4 && this.transformType_ != Value.getDefaultInstance()) {
                this.transformType_ = Value.newBuilder((Value) this.transformType_).mergeFrom((Value.Builder) value).buildPartial();
            } else {
                this.transformType_ = value;
            }
            this.transformTypeCase_ = 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void N0(Value value) {
            value.getClass();
            if (this.transformTypeCase_ == 5 && this.transformType_ != Value.getDefaultInstance()) {
                this.transformType_ = Value.newBuilder((Value) this.transformType_).mergeFrom((Value.Builder) value).buildPartial();
            } else {
                this.transformType_ = value;
            }
            this.transformTypeCase_ = 5;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void O0(ArrayValue arrayValue) {
            arrayValue.getClass();
            if (this.transformTypeCase_ == 7 && this.transformType_ != ArrayValue.getDefaultInstance()) {
                this.transformType_ = ArrayValue.newBuilder((ArrayValue) this.transformType_).mergeFrom((ArrayValue.Builder) arrayValue).buildPartial();
            } else {
                this.transformType_ = arrayValue;
            }
            this.transformTypeCase_ = 7;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void P0(ArrayValue arrayValue) {
            arrayValue.getClass();
            this.transformType_ = arrayValue;
            this.transformTypeCase_ = 6;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Q0(String str) {
            str.getClass();
            this.fieldPath_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void R0(ByteString byteString) {
            AbstractMessageLite.b(byteString);
            this.fieldPath_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void S0(Value value) {
            value.getClass();
            this.transformType_ = value;
            this.transformTypeCase_ = 3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void T0(Value value) {
            value.getClass();
            this.transformType_ = value;
            this.transformTypeCase_ = 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void U0(Value value) {
            value.getClass();
            this.transformType_ = value;
            this.transformTypeCase_ = 5;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void V0(ArrayValue arrayValue) {
            arrayValue.getClass();
            this.transformType_ = arrayValue;
            this.transformTypeCase_ = 7;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void W0(ServerValue serverValue) {
            this.transformType_ = Integer.valueOf(serverValue.getNumber());
            this.transformTypeCase_ = 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void X0(int i4) {
            this.transformTypeCase_ = 2;
            this.transformType_ = Integer.valueOf(i4);
        }

        public static FieldTransform getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.q();
        }

        public static FieldTransform parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (FieldTransform) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
        }

        public static FieldTransform parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (FieldTransform) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<FieldTransform> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        @Override // com.google.firestore.v1.DocumentTransform.FieldTransformOrBuilder
        public ArrayValue getAppendMissingElements() {
            if (this.transformTypeCase_ == 6) {
                return (ArrayValue) this.transformType_;
            }
            return ArrayValue.getDefaultInstance();
        }

        @Override // com.google.firestore.v1.DocumentTransform.FieldTransformOrBuilder
        public String getFieldPath() {
            return this.fieldPath_;
        }

        @Override // com.google.firestore.v1.DocumentTransform.FieldTransformOrBuilder
        public ByteString getFieldPathBytes() {
            return ByteString.copyFromUtf8(this.fieldPath_);
        }

        @Override // com.google.firestore.v1.DocumentTransform.FieldTransformOrBuilder
        public Value getIncrement() {
            if (this.transformTypeCase_ == 3) {
                return (Value) this.transformType_;
            }
            return Value.getDefaultInstance();
        }

        @Override // com.google.firestore.v1.DocumentTransform.FieldTransformOrBuilder
        public Value getMaximum() {
            if (this.transformTypeCase_ == 4) {
                return (Value) this.transformType_;
            }
            return Value.getDefaultInstance();
        }

        @Override // com.google.firestore.v1.DocumentTransform.FieldTransformOrBuilder
        public Value getMinimum() {
            if (this.transformTypeCase_ == 5) {
                return (Value) this.transformType_;
            }
            return Value.getDefaultInstance();
        }

        @Override // com.google.firestore.v1.DocumentTransform.FieldTransformOrBuilder
        public ArrayValue getRemoveAllFromArray() {
            if (this.transformTypeCase_ == 7) {
                return (ArrayValue) this.transformType_;
            }
            return ArrayValue.getDefaultInstance();
        }

        @Override // com.google.firestore.v1.DocumentTransform.FieldTransformOrBuilder
        public ServerValue getSetToServerValue() {
            if (this.transformTypeCase_ == 2) {
                ServerValue forNumber = ServerValue.forNumber(((Integer) this.transformType_).intValue());
                if (forNumber == null) {
                    return ServerValue.UNRECOGNIZED;
                }
                return forNumber;
            }
            return ServerValue.SERVER_VALUE_UNSPECIFIED;
        }

        @Override // com.google.firestore.v1.DocumentTransform.FieldTransformOrBuilder
        public int getSetToServerValueValue() {
            if (this.transformTypeCase_ == 2) {
                return ((Integer) this.transformType_).intValue();
            }
            return 0;
        }

        @Override // com.google.firestore.v1.DocumentTransform.FieldTransformOrBuilder
        public TransformTypeCase getTransformTypeCase() {
            return TransformTypeCase.forNumber(this.transformTypeCase_);
        }

        @Override // com.google.firestore.v1.DocumentTransform.FieldTransformOrBuilder
        public boolean hasAppendMissingElements() {
            if (this.transformTypeCase_ == 6) {
                return true;
            }
            return false;
        }

        @Override // com.google.firestore.v1.DocumentTransform.FieldTransformOrBuilder
        public boolean hasIncrement() {
            if (this.transformTypeCase_ == 3) {
                return true;
            }
            return false;
        }

        @Override // com.google.firestore.v1.DocumentTransform.FieldTransformOrBuilder
        public boolean hasMaximum() {
            if (this.transformTypeCase_ == 4) {
                return true;
            }
            return false;
        }

        @Override // com.google.firestore.v1.DocumentTransform.FieldTransformOrBuilder
        public boolean hasMinimum() {
            if (this.transformTypeCase_ == 5) {
                return true;
            }
            return false;
        }

        @Override // com.google.firestore.v1.DocumentTransform.FieldTransformOrBuilder
        public boolean hasRemoveAllFromArray() {
            if (this.transformTypeCase_ == 7) {
                return true;
            }
            return false;
        }

        @Override // com.google.firestore.v1.DocumentTransform.FieldTransformOrBuilder
        public boolean hasSetToServerValue() {
            if (this.transformTypeCase_ == 2) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (AnonymousClass1.f32455a[methodToInvoke.ordinal()]) {
                case 1:
                    return new FieldTransform();
                case 2:
                    return new Builder(null);
                case 3:
                    return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0007\u0001\u0000\u0001\u0007\u0007\u0000\u0000\u0000\u0001Ȉ\u0002?\u0000\u0003<\u0000\u0004<\u0000\u0005<\u0000\u0006<\u0000\u0007<\u0000", new Object[]{"transformType_", "transformTypeCase_", "fieldPath_", Value.class, Value.class, Value.class, ArrayValue.class, ArrayValue.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<FieldTransform> parser = PARSER;
                    if (parser == null) {
                        synchronized (FieldTransform.class) {
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

        public static Builder newBuilder(FieldTransform fieldTransform) {
            return DEFAULT_INSTANCE.r(fieldTransform);
        }

        public static FieldTransform parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (FieldTransform) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static FieldTransform parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (FieldTransform) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static FieldTransform parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (FieldTransform) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
        }

        public static FieldTransform parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (FieldTransform) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static FieldTransform parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (FieldTransform) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
        }

        public static FieldTransform parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (FieldTransform) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static FieldTransform parseFrom(InputStream inputStream) throws IOException {
            return (FieldTransform) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
        }

        public static FieldTransform parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (FieldTransform) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static FieldTransform parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (FieldTransform) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
        }

        public static FieldTransform parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (FieldTransform) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: classes5.dex */
    public interface FieldTransformOrBuilder extends MessageLiteOrBuilder {
        ArrayValue getAppendMissingElements();

        String getFieldPath();

        ByteString getFieldPathBytes();

        Value getIncrement();

        Value getMaximum();

        Value getMinimum();

        ArrayValue getRemoveAllFromArray();

        FieldTransform.ServerValue getSetToServerValue();

        int getSetToServerValueValue();

        FieldTransform.TransformTypeCase getTransformTypeCase();

        boolean hasAppendMissingElements();

        boolean hasIncrement();

        boolean hasMaximum();

        boolean hasMinimum();

        boolean hasRemoveAllFromArray();

        boolean hasSetToServerValue();
    }

    static {
        DocumentTransform documentTransform = new DocumentTransform();
        DEFAULT_INSTANCE = documentTransform;
        GeneratedMessageLite.d0(DocumentTransform.class, documentTransform);
    }

    private DocumentTransform() {
    }

    public static DocumentTransform getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p0(Iterable<? extends FieldTransform> iterable) {
        u0();
        AbstractMessageLite.a(iterable, this.fieldTransforms_);
    }

    public static DocumentTransform parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (DocumentTransform) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
    }

    public static DocumentTransform parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (DocumentTransform) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<DocumentTransform> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q0(int i4, FieldTransform fieldTransform) {
        fieldTransform.getClass();
        u0();
        this.fieldTransforms_.add(i4, fieldTransform);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0(FieldTransform fieldTransform) {
        fieldTransform.getClass();
        u0();
        this.fieldTransforms_.add(fieldTransform);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0() {
        this.document_ = getDefaultInstance().getDocument();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t0() {
        this.fieldTransforms_ = GeneratedMessageLite.y();
    }

    private void u0() {
        Internal.ProtobufList<FieldTransform> protobufList = this.fieldTransforms_;
        if (!protobufList.isModifiable()) {
            this.fieldTransforms_ = GeneratedMessageLite.K(protobufList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v0(int i4) {
        u0();
        this.fieldTransforms_.remove(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w0(String str) {
        str.getClass();
        this.document_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        this.document_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0(int i4, FieldTransform fieldTransform) {
        fieldTransform.getClass();
        u0();
        this.fieldTransforms_.set(i4, fieldTransform);
    }

    @Override // com.google.firestore.v1.DocumentTransformOrBuilder
    public String getDocument() {
        return this.document_;
    }

    @Override // com.google.firestore.v1.DocumentTransformOrBuilder
    public ByteString getDocumentBytes() {
        return ByteString.copyFromUtf8(this.document_);
    }

    @Override // com.google.firestore.v1.DocumentTransformOrBuilder
    public FieldTransform getFieldTransforms(int i4) {
        return this.fieldTransforms_.get(i4);
    }

    @Override // com.google.firestore.v1.DocumentTransformOrBuilder
    public int getFieldTransformsCount() {
        return this.fieldTransforms_.size();
    }

    @Override // com.google.firestore.v1.DocumentTransformOrBuilder
    public List<FieldTransform> getFieldTransformsList() {
        return this.fieldTransforms_;
    }

    public FieldTransformOrBuilder getFieldTransformsOrBuilder(int i4) {
        return this.fieldTransforms_.get(i4);
    }

    public List<? extends FieldTransformOrBuilder> getFieldTransformsOrBuilderList() {
        return this.fieldTransforms_;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.f32455a[methodToInvoke.ordinal()]) {
            case 1:
                return new DocumentTransform();
            case 2:
                return new Builder(null);
            case 3:
                return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002\u001b", new Object[]{"document_", "fieldTransforms_", FieldTransform.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<DocumentTransform> parser = PARSER;
                if (parser == null) {
                    synchronized (DocumentTransform.class) {
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

    public static Builder newBuilder(DocumentTransform documentTransform) {
        return DEFAULT_INSTANCE.r(documentTransform);
    }

    public static DocumentTransform parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (DocumentTransform) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static DocumentTransform parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (DocumentTransform) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static DocumentTransform parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (DocumentTransform) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
    }

    public static DocumentTransform parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (DocumentTransform) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static DocumentTransform parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (DocumentTransform) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
    }

    public static DocumentTransform parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (DocumentTransform) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static DocumentTransform parseFrom(InputStream inputStream) throws IOException {
        return (DocumentTransform) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
    }

    public static DocumentTransform parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (DocumentTransform) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static DocumentTransform parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (DocumentTransform) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
    }

    public static DocumentTransform parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (DocumentTransform) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
