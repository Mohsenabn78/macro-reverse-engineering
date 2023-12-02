package com.google.firestore.v1;

import com.google.firestore.v1.Value;
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
public final class Cursor extends GeneratedMessageLite<Cursor, Builder> implements CursorOrBuilder {
    public static final int BEFORE_FIELD_NUMBER = 2;
    private static final Cursor DEFAULT_INSTANCE;
    private static volatile Parser<Cursor> PARSER = null;
    public static final int VALUES_FIELD_NUMBER = 1;
    private boolean before_;
    private Internal.ProtobufList<Value> values_ = GeneratedMessageLite.y();

    /* renamed from: com.google.firestore.v1.Cursor$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f32447a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f32447a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32447a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32447a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32447a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f32447a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f32447a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f32447a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<Cursor, Builder> implements CursorOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllValues(Iterable<? extends Value> iterable) {
            f();
            ((Cursor) this.f33398b).o0(iterable);
            return this;
        }

        public Builder addValues(Value value) {
            f();
            ((Cursor) this.f33398b).q0(value);
            return this;
        }

        public Builder clearBefore() {
            f();
            ((Cursor) this.f33398b).r0();
            return this;
        }

        public Builder clearValues() {
            f();
            ((Cursor) this.f33398b).s0();
            return this;
        }

        @Override // com.google.firestore.v1.CursorOrBuilder
        public boolean getBefore() {
            return ((Cursor) this.f33398b).getBefore();
        }

        @Override // com.google.firestore.v1.CursorOrBuilder
        public Value getValues(int i4) {
            return ((Cursor) this.f33398b).getValues(i4);
        }

        @Override // com.google.firestore.v1.CursorOrBuilder
        public int getValuesCount() {
            return ((Cursor) this.f33398b).getValuesCount();
        }

        @Override // com.google.firestore.v1.CursorOrBuilder
        public List<Value> getValuesList() {
            return Collections.unmodifiableList(((Cursor) this.f33398b).getValuesList());
        }

        public Builder removeValues(int i4) {
            f();
            ((Cursor) this.f33398b).u0(i4);
            return this;
        }

        public Builder setBefore(boolean z3) {
            f();
            ((Cursor) this.f33398b).v0(z3);
            return this;
        }

        public Builder setValues(int i4, Value value) {
            f();
            ((Cursor) this.f33398b).w0(i4, value);
            return this;
        }

        private Builder() {
            super(Cursor.DEFAULT_INSTANCE);
        }

        public Builder addValues(int i4, Value value) {
            f();
            ((Cursor) this.f33398b).p0(i4, value);
            return this;
        }

        public Builder setValues(int i4, Value.Builder builder) {
            f();
            ((Cursor) this.f33398b).w0(i4, builder.build());
            return this;
        }

        public Builder addValues(Value.Builder builder) {
            f();
            ((Cursor) this.f33398b).q0(builder.build());
            return this;
        }

        public Builder addValues(int i4, Value.Builder builder) {
            f();
            ((Cursor) this.f33398b).p0(i4, builder.build());
            return this;
        }
    }

    static {
        Cursor cursor = new Cursor();
        DEFAULT_INSTANCE = cursor;
        GeneratedMessageLite.d0(Cursor.class, cursor);
    }

    private Cursor() {
    }

    public static Cursor getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o0(Iterable<? extends Value> iterable) {
        t0();
        AbstractMessageLite.a(iterable, this.values_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p0(int i4, Value value) {
        value.getClass();
        t0();
        this.values_.add(i4, value);
    }

    public static Cursor parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Cursor) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
    }

    public static Cursor parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (Cursor) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Cursor> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q0(Value value) {
        value.getClass();
        t0();
        this.values_.add(value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0() {
        this.before_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0() {
        this.values_ = GeneratedMessageLite.y();
    }

    private void t0() {
        Internal.ProtobufList<Value> protobufList = this.values_;
        if (!protobufList.isModifiable()) {
            this.values_ = GeneratedMessageLite.K(protobufList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u0(int i4) {
        t0();
        this.values_.remove(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v0(boolean z3) {
        this.before_ = z3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w0(int i4, Value value) {
        value.getClass();
        t0();
        this.values_.set(i4, value);
    }

    @Override // com.google.firestore.v1.CursorOrBuilder
    public boolean getBefore() {
        return this.before_;
    }

    @Override // com.google.firestore.v1.CursorOrBuilder
    public Value getValues(int i4) {
        return this.values_.get(i4);
    }

    @Override // com.google.firestore.v1.CursorOrBuilder
    public int getValuesCount() {
        return this.values_.size();
    }

    @Override // com.google.firestore.v1.CursorOrBuilder
    public List<Value> getValuesList() {
        return this.values_;
    }

    public ValueOrBuilder getValuesOrBuilder(int i4) {
        return this.values_.get(i4);
    }

    public List<? extends ValueOrBuilder> getValuesOrBuilderList() {
        return this.values_;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.f32447a[methodToInvoke.ordinal()]) {
            case 1:
                return new Cursor();
            case 2:
                return new Builder(null);
            case 3:
                return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002\u0007", new Object[]{"values_", Value.class, "before_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Cursor> parser = PARSER;
                if (parser == null) {
                    synchronized (Cursor.class) {
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

    public static Builder newBuilder(Cursor cursor) {
        return DEFAULT_INSTANCE.r(cursor);
    }

    public static Cursor parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Cursor) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Cursor parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Cursor) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Cursor parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (Cursor) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
    }

    public static Cursor parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Cursor) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Cursor parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (Cursor) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
    }

    public static Cursor parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Cursor) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Cursor parseFrom(InputStream inputStream) throws IOException {
        return (Cursor) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
    }

    public static Cursor parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Cursor) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Cursor parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Cursor) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Cursor parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Cursor) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
