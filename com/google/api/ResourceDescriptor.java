package com.google.api;

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
public final class ResourceDescriptor extends GeneratedMessageLite<ResourceDescriptor, Builder> implements ResourceDescriptorOrBuilder {
    private static final ResourceDescriptor DEFAULT_INSTANCE;
    public static final int HISTORY_FIELD_NUMBER = 4;
    public static final int NAME_FIELD_FIELD_NUMBER = 3;
    private static volatile Parser<ResourceDescriptor> PARSER = null;
    public static final int PATTERN_FIELD_NUMBER = 2;
    public static final int PLURAL_FIELD_NUMBER = 5;
    public static final int SINGULAR_FIELD_NUMBER = 6;
    public static final int TYPE_FIELD_NUMBER = 1;
    private int history_;
    private String type_ = "";
    private Internal.ProtobufList<String> pattern_ = GeneratedMessageLite.y();
    private String nameField_ = "";
    private String plural_ = "";
    private String singular_ = "";

    /* renamed from: com.google.api.ResourceDescriptor$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f25452a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f25452a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f25452a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f25452a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f25452a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f25452a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f25452a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f25452a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<ResourceDescriptor, Builder> implements ResourceDescriptorOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllPattern(Iterable<String> iterable) {
            f();
            ((ResourceDescriptor) this.f33398b).A0(iterable);
            return this;
        }

        public Builder addPattern(String str) {
            f();
            ((ResourceDescriptor) this.f33398b).B0(str);
            return this;
        }

        public Builder addPatternBytes(ByteString byteString) {
            f();
            ((ResourceDescriptor) this.f33398b).C0(byteString);
            return this;
        }

        public Builder clearHistory() {
            f();
            ((ResourceDescriptor) this.f33398b).D0();
            return this;
        }

        public Builder clearNameField() {
            f();
            ((ResourceDescriptor) this.f33398b).E0();
            return this;
        }

        public Builder clearPattern() {
            f();
            ((ResourceDescriptor) this.f33398b).F0();
            return this;
        }

        public Builder clearPlural() {
            f();
            ((ResourceDescriptor) this.f33398b).G0();
            return this;
        }

        public Builder clearSingular() {
            f();
            ((ResourceDescriptor) this.f33398b).H0();
            return this;
        }

        public Builder clearType() {
            f();
            ((ResourceDescriptor) this.f33398b).I0();
            return this;
        }

        @Override // com.google.api.ResourceDescriptorOrBuilder
        public History getHistory() {
            return ((ResourceDescriptor) this.f33398b).getHistory();
        }

        @Override // com.google.api.ResourceDescriptorOrBuilder
        public int getHistoryValue() {
            return ((ResourceDescriptor) this.f33398b).getHistoryValue();
        }

        @Override // com.google.api.ResourceDescriptorOrBuilder
        public String getNameField() {
            return ((ResourceDescriptor) this.f33398b).getNameField();
        }

        @Override // com.google.api.ResourceDescriptorOrBuilder
        public ByteString getNameFieldBytes() {
            return ((ResourceDescriptor) this.f33398b).getNameFieldBytes();
        }

        @Override // com.google.api.ResourceDescriptorOrBuilder
        public String getPattern(int i4) {
            return ((ResourceDescriptor) this.f33398b).getPattern(i4);
        }

        @Override // com.google.api.ResourceDescriptorOrBuilder
        public ByteString getPatternBytes(int i4) {
            return ((ResourceDescriptor) this.f33398b).getPatternBytes(i4);
        }

        @Override // com.google.api.ResourceDescriptorOrBuilder
        public int getPatternCount() {
            return ((ResourceDescriptor) this.f33398b).getPatternCount();
        }

        @Override // com.google.api.ResourceDescriptorOrBuilder
        public List<String> getPatternList() {
            return Collections.unmodifiableList(((ResourceDescriptor) this.f33398b).getPatternList());
        }

        @Override // com.google.api.ResourceDescriptorOrBuilder
        public String getPlural() {
            return ((ResourceDescriptor) this.f33398b).getPlural();
        }

        @Override // com.google.api.ResourceDescriptorOrBuilder
        public ByteString getPluralBytes() {
            return ((ResourceDescriptor) this.f33398b).getPluralBytes();
        }

        @Override // com.google.api.ResourceDescriptorOrBuilder
        public String getSingular() {
            return ((ResourceDescriptor) this.f33398b).getSingular();
        }

        @Override // com.google.api.ResourceDescriptorOrBuilder
        public ByteString getSingularBytes() {
            return ((ResourceDescriptor) this.f33398b).getSingularBytes();
        }

        @Override // com.google.api.ResourceDescriptorOrBuilder
        public String getType() {
            return ((ResourceDescriptor) this.f33398b).getType();
        }

        @Override // com.google.api.ResourceDescriptorOrBuilder
        public ByteString getTypeBytes() {
            return ((ResourceDescriptor) this.f33398b).getTypeBytes();
        }

        public Builder setHistory(History history) {
            f();
            ((ResourceDescriptor) this.f33398b).K0(history);
            return this;
        }

        public Builder setHistoryValue(int i4) {
            f();
            ((ResourceDescriptor) this.f33398b).L0(i4);
            return this;
        }

        public Builder setNameField(String str) {
            f();
            ((ResourceDescriptor) this.f33398b).M0(str);
            return this;
        }

        public Builder setNameFieldBytes(ByteString byteString) {
            f();
            ((ResourceDescriptor) this.f33398b).N0(byteString);
            return this;
        }

        public Builder setPattern(int i4, String str) {
            f();
            ((ResourceDescriptor) this.f33398b).O0(i4, str);
            return this;
        }

        public Builder setPlural(String str) {
            f();
            ((ResourceDescriptor) this.f33398b).P0(str);
            return this;
        }

        public Builder setPluralBytes(ByteString byteString) {
            f();
            ((ResourceDescriptor) this.f33398b).Q0(byteString);
            return this;
        }

        public Builder setSingular(String str) {
            f();
            ((ResourceDescriptor) this.f33398b).R0(str);
            return this;
        }

        public Builder setSingularBytes(ByteString byteString) {
            f();
            ((ResourceDescriptor) this.f33398b).S0(byteString);
            return this;
        }

        public Builder setType(String str) {
            f();
            ((ResourceDescriptor) this.f33398b).T0(str);
            return this;
        }

        public Builder setTypeBytes(ByteString byteString) {
            f();
            ((ResourceDescriptor) this.f33398b).U0(byteString);
            return this;
        }

        private Builder() {
            super(ResourceDescriptor.DEFAULT_INSTANCE);
        }
    }

    /* loaded from: classes5.dex */
    public enum History implements Internal.EnumLite {
        HISTORY_UNSPECIFIED(0),
        ORIGINALLY_SINGLE_PATTERN(1),
        FUTURE_MULTI_PATTERN(2),
        UNRECOGNIZED(-1);
        
        public static final int FUTURE_MULTI_PATTERN_VALUE = 2;
        public static final int HISTORY_UNSPECIFIED_VALUE = 0;
        public static final int ORIGINALLY_SINGLE_PATTERN_VALUE = 1;

        /* renamed from: a  reason: collision with root package name */
        private static final Internal.EnumLiteMap<History> f25453a = new Internal.EnumLiteMap<History>() { // from class: com.google.api.ResourceDescriptor.History.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            /* renamed from: a */
            public History findValueByNumber(int i4) {
                return History.forNumber(i4);
            }
        };
        private final int value;

        /* loaded from: classes5.dex */
        private static final class HistoryVerifier implements Internal.EnumVerifier {

            /* renamed from: a  reason: collision with root package name */
            static final Internal.EnumVerifier f25455a = new HistoryVerifier();

            private HistoryVerifier() {
            }

            @Override // com.google.protobuf.Internal.EnumVerifier
            public boolean isInRange(int i4) {
                if (History.forNumber(i4) != null) {
                    return true;
                }
                return false;
            }
        }

        History(int i4) {
            this.value = i4;
        }

        public static History forNumber(int i4) {
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 != 2) {
                        return null;
                    }
                    return FUTURE_MULTI_PATTERN;
                }
                return ORIGINALLY_SINGLE_PATTERN;
            }
            return HISTORY_UNSPECIFIED;
        }

        public static Internal.EnumLiteMap<History> internalGetValueMap() {
            return f25453a;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return HistoryVerifier.f25455a;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static History valueOf(int i4) {
            return forNumber(i4);
        }
    }

    static {
        ResourceDescriptor resourceDescriptor = new ResourceDescriptor();
        DEFAULT_INSTANCE = resourceDescriptor;
        GeneratedMessageLite.d0(ResourceDescriptor.class, resourceDescriptor);
    }

    private ResourceDescriptor() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0(Iterable<String> iterable) {
        J0();
        AbstractMessageLite.a(iterable, this.pattern_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B0(String str) {
        str.getClass();
        J0();
        this.pattern_.add(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C0(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        J0();
        this.pattern_.add(byteString.toStringUtf8());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D0() {
        this.history_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E0() {
        this.nameField_ = getDefaultInstance().getNameField();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F0() {
        this.pattern_ = GeneratedMessageLite.y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G0() {
        this.plural_ = getDefaultInstance().getPlural();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H0() {
        this.singular_ = getDefaultInstance().getSingular();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I0() {
        this.type_ = getDefaultInstance().getType();
    }

    private void J0() {
        Internal.ProtobufList<String> protobufList = this.pattern_;
        if (!protobufList.isModifiable()) {
            this.pattern_ = GeneratedMessageLite.K(protobufList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K0(History history) {
        this.history_ = history.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L0(int i4) {
        this.history_ = i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M0(String str) {
        str.getClass();
        this.nameField_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N0(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        this.nameField_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O0(int i4, String str) {
        str.getClass();
        J0();
        this.pattern_.set(i4, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P0(String str) {
        str.getClass();
        this.plural_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q0(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        this.plural_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R0(String str) {
        str.getClass();
        this.singular_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S0(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        this.singular_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T0(String str) {
        str.getClass();
        this.type_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U0(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        this.type_ = byteString.toStringUtf8();
    }

    public static ResourceDescriptor getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.q();
    }

    public static ResourceDescriptor parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (ResourceDescriptor) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
    }

    public static ResourceDescriptor parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (ResourceDescriptor) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<ResourceDescriptor> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    @Override // com.google.api.ResourceDescriptorOrBuilder
    public History getHistory() {
        History forNumber = History.forNumber(this.history_);
        if (forNumber == null) {
            return History.UNRECOGNIZED;
        }
        return forNumber;
    }

    @Override // com.google.api.ResourceDescriptorOrBuilder
    public int getHistoryValue() {
        return this.history_;
    }

    @Override // com.google.api.ResourceDescriptorOrBuilder
    public String getNameField() {
        return this.nameField_;
    }

    @Override // com.google.api.ResourceDescriptorOrBuilder
    public ByteString getNameFieldBytes() {
        return ByteString.copyFromUtf8(this.nameField_);
    }

    @Override // com.google.api.ResourceDescriptorOrBuilder
    public String getPattern(int i4) {
        return this.pattern_.get(i4);
    }

    @Override // com.google.api.ResourceDescriptorOrBuilder
    public ByteString getPatternBytes(int i4) {
        return ByteString.copyFromUtf8(this.pattern_.get(i4));
    }

    @Override // com.google.api.ResourceDescriptorOrBuilder
    public int getPatternCount() {
        return this.pattern_.size();
    }

    @Override // com.google.api.ResourceDescriptorOrBuilder
    public List<String> getPatternList() {
        return this.pattern_;
    }

    @Override // com.google.api.ResourceDescriptorOrBuilder
    public String getPlural() {
        return this.plural_;
    }

    @Override // com.google.api.ResourceDescriptorOrBuilder
    public ByteString getPluralBytes() {
        return ByteString.copyFromUtf8(this.plural_);
    }

    @Override // com.google.api.ResourceDescriptorOrBuilder
    public String getSingular() {
        return this.singular_;
    }

    @Override // com.google.api.ResourceDescriptorOrBuilder
    public ByteString getSingularBytes() {
        return ByteString.copyFromUtf8(this.singular_);
    }

    @Override // com.google.api.ResourceDescriptorOrBuilder
    public String getType() {
        return this.type_;
    }

    @Override // com.google.api.ResourceDescriptorOrBuilder
    public ByteString getTypeBytes() {
        return ByteString.copyFromUtf8(this.type_);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.f25452a[methodToInvoke.ordinal()]) {
            case 1:
                return new ResourceDescriptor();
            case 2:
                return new Builder(null);
            case 3:
                return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0000\u0001\u0006\u0006\u0000\u0001\u0000\u0001Ȉ\u0002Ț\u0003Ȉ\u0004\f\u0005Ȉ\u0006Ȉ", new Object[]{"type_", "pattern_", "nameField_", "history_", "plural_", "singular_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<ResourceDescriptor> parser = PARSER;
                if (parser == null) {
                    synchronized (ResourceDescriptor.class) {
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

    public static Builder newBuilder(ResourceDescriptor resourceDescriptor) {
        return DEFAULT_INSTANCE.r(resourceDescriptor);
    }

    public static ResourceDescriptor parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ResourceDescriptor) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ResourceDescriptor parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ResourceDescriptor) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static ResourceDescriptor parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (ResourceDescriptor) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
    }

    public static ResourceDescriptor parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ResourceDescriptor) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static ResourceDescriptor parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (ResourceDescriptor) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
    }

    public static ResourceDescriptor parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ResourceDescriptor) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static ResourceDescriptor parseFrom(InputStream inputStream) throws IOException {
        return (ResourceDescriptor) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
    }

    public static ResourceDescriptor parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ResourceDescriptor) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ResourceDescriptor parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (ResourceDescriptor) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
    }

    public static ResourceDescriptor parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ResourceDescriptor) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
