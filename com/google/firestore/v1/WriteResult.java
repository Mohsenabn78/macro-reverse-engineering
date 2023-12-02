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
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: classes5.dex */
public final class WriteResult extends GeneratedMessageLite<WriteResult, Builder> implements WriteResultOrBuilder {
    private static final WriteResult DEFAULT_INSTANCE;
    private static volatile Parser<WriteResult> PARSER = null;
    public static final int TRANSFORM_RESULTS_FIELD_NUMBER = 2;
    public static final int UPDATE_TIME_FIELD_NUMBER = 1;
    private Internal.ProtobufList<Value> transformResults_ = GeneratedMessageLite.y();
    private Timestamp updateTime_;

    /* renamed from: com.google.firestore.v1.WriteResult$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f32540a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f32540a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32540a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32540a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32540a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f32540a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f32540a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f32540a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<WriteResult, Builder> implements WriteResultOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllTransformResults(Iterable<? extends Value> iterable) {
            f();
            ((WriteResult) this.f33398b).p0(iterable);
            return this;
        }

        public Builder addTransformResults(Value value) {
            f();
            ((WriteResult) this.f33398b).r0(value);
            return this;
        }

        public Builder clearTransformResults() {
            f();
            ((WriteResult) this.f33398b).s0();
            return this;
        }

        public Builder clearUpdateTime() {
            f();
            ((WriteResult) this.f33398b).t0();
            return this;
        }

        @Override // com.google.firestore.v1.WriteResultOrBuilder
        public Value getTransformResults(int i4) {
            return ((WriteResult) this.f33398b).getTransformResults(i4);
        }

        @Override // com.google.firestore.v1.WriteResultOrBuilder
        public int getTransformResultsCount() {
            return ((WriteResult) this.f33398b).getTransformResultsCount();
        }

        @Override // com.google.firestore.v1.WriteResultOrBuilder
        public List<Value> getTransformResultsList() {
            return Collections.unmodifiableList(((WriteResult) this.f33398b).getTransformResultsList());
        }

        @Override // com.google.firestore.v1.WriteResultOrBuilder
        public Timestamp getUpdateTime() {
            return ((WriteResult) this.f33398b).getUpdateTime();
        }

        @Override // com.google.firestore.v1.WriteResultOrBuilder
        public boolean hasUpdateTime() {
            return ((WriteResult) this.f33398b).hasUpdateTime();
        }

        public Builder mergeUpdateTime(Timestamp timestamp) {
            f();
            ((WriteResult) this.f33398b).v0(timestamp);
            return this;
        }

        public Builder removeTransformResults(int i4) {
            f();
            ((WriteResult) this.f33398b).w0(i4);
            return this;
        }

        public Builder setTransformResults(int i4, Value value) {
            f();
            ((WriteResult) this.f33398b).x0(i4, value);
            return this;
        }

        public Builder setUpdateTime(Timestamp timestamp) {
            f();
            ((WriteResult) this.f33398b).y0(timestamp);
            return this;
        }

        private Builder() {
            super(WriteResult.DEFAULT_INSTANCE);
        }

        public Builder addTransformResults(int i4, Value value) {
            f();
            ((WriteResult) this.f33398b).q0(i4, value);
            return this;
        }

        public Builder setTransformResults(int i4, Value.Builder builder) {
            f();
            ((WriteResult) this.f33398b).x0(i4, builder.build());
            return this;
        }

        public Builder setUpdateTime(Timestamp.Builder builder) {
            f();
            ((WriteResult) this.f33398b).y0(builder.build());
            return this;
        }

        public Builder addTransformResults(Value.Builder builder) {
            f();
            ((WriteResult) this.f33398b).r0(builder.build());
            return this;
        }

        public Builder addTransformResults(int i4, Value.Builder builder) {
            f();
            ((WriteResult) this.f33398b).q0(i4, builder.build());
            return this;
        }
    }

    static {
        WriteResult writeResult = new WriteResult();
        DEFAULT_INSTANCE = writeResult;
        GeneratedMessageLite.d0(WriteResult.class, writeResult);
    }

    private WriteResult() {
    }

    public static WriteResult getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p0(Iterable<? extends Value> iterable) {
        u0();
        AbstractMessageLite.a(iterable, this.transformResults_);
    }

    public static WriteResult parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (WriteResult) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
    }

    public static WriteResult parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (WriteResult) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<WriteResult> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q0(int i4, Value value) {
        value.getClass();
        u0();
        this.transformResults_.add(i4, value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0(Value value) {
        value.getClass();
        u0();
        this.transformResults_.add(value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0() {
        this.transformResults_ = GeneratedMessageLite.y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t0() {
        this.updateTime_ = null;
    }

    private void u0() {
        Internal.ProtobufList<Value> protobufList = this.transformResults_;
        if (!protobufList.isModifiable()) {
            this.transformResults_ = GeneratedMessageLite.K(protobufList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v0(Timestamp timestamp) {
        timestamp.getClass();
        Timestamp timestamp2 = this.updateTime_;
        if (timestamp2 != null && timestamp2 != Timestamp.getDefaultInstance()) {
            this.updateTime_ = Timestamp.newBuilder(this.updateTime_).mergeFrom((Timestamp.Builder) timestamp).buildPartial();
        } else {
            this.updateTime_ = timestamp;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w0(int i4) {
        u0();
        this.transformResults_.remove(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0(int i4, Value value) {
        value.getClass();
        u0();
        this.transformResults_.set(i4, value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0(Timestamp timestamp) {
        timestamp.getClass();
        this.updateTime_ = timestamp;
    }

    @Override // com.google.firestore.v1.WriteResultOrBuilder
    public Value getTransformResults(int i4) {
        return this.transformResults_.get(i4);
    }

    @Override // com.google.firestore.v1.WriteResultOrBuilder
    public int getTransformResultsCount() {
        return this.transformResults_.size();
    }

    @Override // com.google.firestore.v1.WriteResultOrBuilder
    public List<Value> getTransformResultsList() {
        return this.transformResults_;
    }

    public ValueOrBuilder getTransformResultsOrBuilder(int i4) {
        return this.transformResults_.get(i4);
    }

    public List<? extends ValueOrBuilder> getTransformResultsOrBuilderList() {
        return this.transformResults_;
    }

    @Override // com.google.firestore.v1.WriteResultOrBuilder
    public Timestamp getUpdateTime() {
        Timestamp timestamp = this.updateTime_;
        if (timestamp == null) {
            return Timestamp.getDefaultInstance();
        }
        return timestamp;
    }

    @Override // com.google.firestore.v1.WriteResultOrBuilder
    public boolean hasUpdateTime() {
        if (this.updateTime_ != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.f32540a[methodToInvoke.ordinal()]) {
            case 1:
                return new WriteResult();
            case 2:
                return new Builder(null);
            case 3:
                return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\t\u0002\u001b", new Object[]{"updateTime_", "transformResults_", Value.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<WriteResult> parser = PARSER;
                if (parser == null) {
                    synchronized (WriteResult.class) {
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

    public static Builder newBuilder(WriteResult writeResult) {
        return DEFAULT_INSTANCE.r(writeResult);
    }

    public static WriteResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (WriteResult) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static WriteResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (WriteResult) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static WriteResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (WriteResult) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
    }

    public static WriteResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (WriteResult) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static WriteResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (WriteResult) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
    }

    public static WriteResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (WriteResult) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static WriteResult parseFrom(InputStream inputStream) throws IOException {
        return (WriteResult) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
    }

    public static WriteResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (WriteResult) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static WriteResult parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (WriteResult) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
    }

    public static WriteResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (WriteResult) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
