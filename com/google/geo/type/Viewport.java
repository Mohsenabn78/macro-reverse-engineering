package com.google.geo.type;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.google.type.LatLng;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes5.dex */
public final class Viewport extends GeneratedMessageLite<Viewport, Builder> implements ViewportOrBuilder {
    private static final Viewport DEFAULT_INSTANCE;
    public static final int HIGH_FIELD_NUMBER = 2;
    public static final int LOW_FIELD_NUMBER = 1;
    private static volatile Parser<Viewport> PARSER;
    private LatLng high_;
    private LatLng low_;

    /* renamed from: com.google.geo.type.Viewport$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f32541a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f32541a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32541a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32541a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32541a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f32541a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f32541a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f32541a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<Viewport, Builder> implements ViewportOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearHigh() {
            f();
            ((Viewport) this.f33398b).m0();
            return this;
        }

        public Builder clearLow() {
            f();
            ((Viewport) this.f33398b).n0();
            return this;
        }

        @Override // com.google.geo.type.ViewportOrBuilder
        public LatLng getHigh() {
            return ((Viewport) this.f33398b).getHigh();
        }

        @Override // com.google.geo.type.ViewportOrBuilder
        public LatLng getLow() {
            return ((Viewport) this.f33398b).getLow();
        }

        @Override // com.google.geo.type.ViewportOrBuilder
        public boolean hasHigh() {
            return ((Viewport) this.f33398b).hasHigh();
        }

        @Override // com.google.geo.type.ViewportOrBuilder
        public boolean hasLow() {
            return ((Viewport) this.f33398b).hasLow();
        }

        public Builder mergeHigh(LatLng latLng) {
            f();
            ((Viewport) this.f33398b).o0(latLng);
            return this;
        }

        public Builder mergeLow(LatLng latLng) {
            f();
            ((Viewport) this.f33398b).p0(latLng);
            return this;
        }

        public Builder setHigh(LatLng latLng) {
            f();
            ((Viewport) this.f33398b).q0(latLng);
            return this;
        }

        public Builder setLow(LatLng latLng) {
            f();
            ((Viewport) this.f33398b).r0(latLng);
            return this;
        }

        private Builder() {
            super(Viewport.DEFAULT_INSTANCE);
        }

        public Builder setHigh(LatLng.Builder builder) {
            f();
            ((Viewport) this.f33398b).q0(builder.build());
            return this;
        }

        public Builder setLow(LatLng.Builder builder) {
            f();
            ((Viewport) this.f33398b).r0(builder.build());
            return this;
        }
    }

    static {
        Viewport viewport = new Viewport();
        DEFAULT_INSTANCE = viewport;
        GeneratedMessageLite.d0(Viewport.class, viewport);
    }

    private Viewport() {
    }

    public static Viewport getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m0() {
        this.high_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n0() {
        this.low_ = null;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o0(LatLng latLng) {
        latLng.getClass();
        LatLng latLng2 = this.high_;
        if (latLng2 != null && latLng2 != LatLng.getDefaultInstance()) {
            this.high_ = LatLng.newBuilder(this.high_).mergeFrom((LatLng.Builder) latLng).buildPartial();
        } else {
            this.high_ = latLng;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p0(LatLng latLng) {
        latLng.getClass();
        LatLng latLng2 = this.low_;
        if (latLng2 != null && latLng2 != LatLng.getDefaultInstance()) {
            this.low_ = LatLng.newBuilder(this.low_).mergeFrom((LatLng.Builder) latLng).buildPartial();
        } else {
            this.low_ = latLng;
        }
    }

    public static Viewport parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Viewport) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
    }

    public static Viewport parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (Viewport) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Viewport> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q0(LatLng latLng) {
        latLng.getClass();
        this.high_ = latLng;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0(LatLng latLng) {
        latLng.getClass();
        this.low_ = latLng;
    }

    @Override // com.google.geo.type.ViewportOrBuilder
    public LatLng getHigh() {
        LatLng latLng = this.high_;
        if (latLng == null) {
            return LatLng.getDefaultInstance();
        }
        return latLng;
    }

    @Override // com.google.geo.type.ViewportOrBuilder
    public LatLng getLow() {
        LatLng latLng = this.low_;
        if (latLng == null) {
            return LatLng.getDefaultInstance();
        }
        return latLng;
    }

    @Override // com.google.geo.type.ViewportOrBuilder
    public boolean hasHigh() {
        if (this.high_ != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.geo.type.ViewportOrBuilder
    public boolean hasLow() {
        if (this.low_ != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.f32541a[methodToInvoke.ordinal()]) {
            case 1:
                return new Viewport();
            case 2:
                return new Builder(null);
            case 3:
                return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\t", new Object[]{"low_", "high_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Viewport> parser = PARSER;
                if (parser == null) {
                    synchronized (Viewport.class) {
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

    public static Builder newBuilder(Viewport viewport) {
        return DEFAULT_INSTANCE.r(viewport);
    }

    public static Viewport parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Viewport) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Viewport parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Viewport) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Viewport parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (Viewport) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
    }

    public static Viewport parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Viewport) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Viewport parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (Viewport) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
    }

    public static Viewport parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Viewport) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Viewport parseFrom(InputStream inputStream) throws IOException {
        return (Viewport) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
    }

    public static Viewport parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Viewport) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Viewport parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Viewport) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Viewport parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Viewport) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
