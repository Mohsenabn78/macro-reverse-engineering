package com.google.protobuf;

import com.google.protobuf.EnumValue;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.Option;
import com.google.protobuf.SourceContext;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: classes6.dex */
public final class Enum extends GeneratedMessageLite<Enum, Builder> implements EnumOrBuilder {
    private static final Enum DEFAULT_INSTANCE;
    public static final int ENUMVALUE_FIELD_NUMBER = 2;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int OPTIONS_FIELD_NUMBER = 3;
    private static volatile Parser<Enum> PARSER = null;
    public static final int SOURCE_CONTEXT_FIELD_NUMBER = 4;
    public static final int SYNTAX_FIELD_NUMBER = 5;
    private SourceContext sourceContext_;
    private int syntax_;
    private String name_ = "";
    private Internal.ProtobufList<EnumValue> enumvalue_ = GeneratedMessageLite.y();
    private Internal.ProtobufList<Option> options_ = GeneratedMessageLite.y();

    /* renamed from: com.google.protobuf.Enum$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f33325a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f33325a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f33325a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f33325a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f33325a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f33325a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f33325a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f33325a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<Enum, Builder> implements EnumOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllEnumvalue(Iterable<? extends EnumValue> iterable) {
            f();
            ((Enum) this.f33398b).B0(iterable);
            return this;
        }

        public Builder addAllOptions(Iterable<? extends Option> iterable) {
            f();
            ((Enum) this.f33398b).C0(iterable);
            return this;
        }

        public Builder addEnumvalue(EnumValue enumValue) {
            f();
            ((Enum) this.f33398b).E0(enumValue);
            return this;
        }

        public Builder addOptions(Option option) {
            f();
            ((Enum) this.f33398b).G0(option);
            return this;
        }

        public Builder clearEnumvalue() {
            f();
            ((Enum) this.f33398b).H0();
            return this;
        }

        public Builder clearName() {
            f();
            ((Enum) this.f33398b).I0();
            return this;
        }

        public Builder clearOptions() {
            f();
            ((Enum) this.f33398b).J0();
            return this;
        }

        public Builder clearSourceContext() {
            f();
            ((Enum) this.f33398b).K0();
            return this;
        }

        public Builder clearSyntax() {
            f();
            ((Enum) this.f33398b).L0();
            return this;
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public EnumValue getEnumvalue(int i4) {
            return ((Enum) this.f33398b).getEnumvalue(i4);
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public int getEnumvalueCount() {
            return ((Enum) this.f33398b).getEnumvalueCount();
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public List<EnumValue> getEnumvalueList() {
            return Collections.unmodifiableList(((Enum) this.f33398b).getEnumvalueList());
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public String getName() {
            return ((Enum) this.f33398b).getName();
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public ByteString getNameBytes() {
            return ((Enum) this.f33398b).getNameBytes();
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public Option getOptions(int i4) {
            return ((Enum) this.f33398b).getOptions(i4);
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public int getOptionsCount() {
            return ((Enum) this.f33398b).getOptionsCount();
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public List<Option> getOptionsList() {
            return Collections.unmodifiableList(((Enum) this.f33398b).getOptionsList());
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public SourceContext getSourceContext() {
            return ((Enum) this.f33398b).getSourceContext();
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public Syntax getSyntax() {
            return ((Enum) this.f33398b).getSyntax();
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public int getSyntaxValue() {
            return ((Enum) this.f33398b).getSyntaxValue();
        }

        @Override // com.google.protobuf.EnumOrBuilder
        public boolean hasSourceContext() {
            return ((Enum) this.f33398b).hasSourceContext();
        }

        public Builder mergeSourceContext(SourceContext sourceContext) {
            f();
            ((Enum) this.f33398b).O0(sourceContext);
            return this;
        }

        public Builder removeEnumvalue(int i4) {
            f();
            ((Enum) this.f33398b).P0(i4);
            return this;
        }

        public Builder removeOptions(int i4) {
            f();
            ((Enum) this.f33398b).Q0(i4);
            return this;
        }

        public Builder setEnumvalue(int i4, EnumValue enumValue) {
            f();
            ((Enum) this.f33398b).R0(i4, enumValue);
            return this;
        }

        public Builder setName(String str) {
            f();
            ((Enum) this.f33398b).S0(str);
            return this;
        }

        public Builder setNameBytes(ByteString byteString) {
            f();
            ((Enum) this.f33398b).T0(byteString);
            return this;
        }

        public Builder setOptions(int i4, Option option) {
            f();
            ((Enum) this.f33398b).U0(i4, option);
            return this;
        }

        public Builder setSourceContext(SourceContext sourceContext) {
            f();
            ((Enum) this.f33398b).V0(sourceContext);
            return this;
        }

        public Builder setSyntax(Syntax syntax) {
            f();
            ((Enum) this.f33398b).W0(syntax);
            return this;
        }

        public Builder setSyntaxValue(int i4) {
            f();
            ((Enum) this.f33398b).X0(i4);
            return this;
        }

        private Builder() {
            super(Enum.DEFAULT_INSTANCE);
        }

        public Builder addEnumvalue(int i4, EnumValue enumValue) {
            f();
            ((Enum) this.f33398b).D0(i4, enumValue);
            return this;
        }

        public Builder addOptions(int i4, Option option) {
            f();
            ((Enum) this.f33398b).F0(i4, option);
            return this;
        }

        public Builder setEnumvalue(int i4, EnumValue.Builder builder) {
            f();
            ((Enum) this.f33398b).R0(i4, builder.build());
            return this;
        }

        public Builder setOptions(int i4, Option.Builder builder) {
            f();
            ((Enum) this.f33398b).U0(i4, builder.build());
            return this;
        }

        public Builder setSourceContext(SourceContext.Builder builder) {
            f();
            ((Enum) this.f33398b).V0(builder.build());
            return this;
        }

        public Builder addEnumvalue(EnumValue.Builder builder) {
            f();
            ((Enum) this.f33398b).E0(builder.build());
            return this;
        }

        public Builder addOptions(Option.Builder builder) {
            f();
            ((Enum) this.f33398b).G0(builder.build());
            return this;
        }

        public Builder addEnumvalue(int i4, EnumValue.Builder builder) {
            f();
            ((Enum) this.f33398b).D0(i4, builder.build());
            return this;
        }

        public Builder addOptions(int i4, Option.Builder builder) {
            f();
            ((Enum) this.f33398b).F0(i4, builder.build());
            return this;
        }
    }

    static {
        Enum r02 = new Enum();
        DEFAULT_INSTANCE = r02;
        GeneratedMessageLite.d0(Enum.class, r02);
    }

    private Enum() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B0(Iterable<? extends EnumValue> iterable) {
        M0();
        AbstractMessageLite.a(iterable, this.enumvalue_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C0(Iterable<? extends Option> iterable) {
        N0();
        AbstractMessageLite.a(iterable, this.options_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D0(int i4, EnumValue enumValue) {
        enumValue.getClass();
        M0();
        this.enumvalue_.add(i4, enumValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E0(EnumValue enumValue) {
        enumValue.getClass();
        M0();
        this.enumvalue_.add(enumValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F0(int i4, Option option) {
        option.getClass();
        N0();
        this.options_.add(i4, option);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G0(Option option) {
        option.getClass();
        N0();
        this.options_.add(option);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H0() {
        this.enumvalue_ = GeneratedMessageLite.y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I0() {
        this.name_ = getDefaultInstance().getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J0() {
        this.options_ = GeneratedMessageLite.y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K0() {
        this.sourceContext_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L0() {
        this.syntax_ = 0;
    }

    private void M0() {
        Internal.ProtobufList<EnumValue> protobufList = this.enumvalue_;
        if (!protobufList.isModifiable()) {
            this.enumvalue_ = GeneratedMessageLite.K(protobufList);
        }
    }

    private void N0() {
        Internal.ProtobufList<Option> protobufList = this.options_;
        if (!protobufList.isModifiable()) {
            this.options_ = GeneratedMessageLite.K(protobufList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O0(SourceContext sourceContext) {
        sourceContext.getClass();
        SourceContext sourceContext2 = this.sourceContext_;
        if (sourceContext2 != null && sourceContext2 != SourceContext.getDefaultInstance()) {
            this.sourceContext_ = SourceContext.newBuilder(this.sourceContext_).mergeFrom((SourceContext.Builder) sourceContext).buildPartial();
        } else {
            this.sourceContext_ = sourceContext;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P0(int i4) {
        M0();
        this.enumvalue_.remove(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q0(int i4) {
        N0();
        this.options_.remove(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R0(int i4, EnumValue enumValue) {
        enumValue.getClass();
        M0();
        this.enumvalue_.set(i4, enumValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S0(String str) {
        str.getClass();
        this.name_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T0(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        this.name_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U0(int i4, Option option) {
        option.getClass();
        N0();
        this.options_.set(i4, option);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V0(SourceContext sourceContext) {
        sourceContext.getClass();
        this.sourceContext_ = sourceContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W0(Syntax syntax) {
        this.syntax_ = syntax.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X0(int i4) {
        this.syntax_ = i4;
    }

    public static Enum getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.q();
    }

    public static Enum parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Enum) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
    }

    public static Enum parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (Enum) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Enum> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public EnumValue getEnumvalue(int i4) {
        return this.enumvalue_.get(i4);
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public int getEnumvalueCount() {
        return this.enumvalue_.size();
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public List<EnumValue> getEnumvalueList() {
        return this.enumvalue_;
    }

    public EnumValueOrBuilder getEnumvalueOrBuilder(int i4) {
        return this.enumvalue_.get(i4);
    }

    public List<? extends EnumValueOrBuilder> getEnumvalueOrBuilderList() {
        return this.enumvalue_;
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public String getName() {
        return this.name_;
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public ByteString getNameBytes() {
        return ByteString.copyFromUtf8(this.name_);
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public Option getOptions(int i4) {
        return this.options_.get(i4);
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public int getOptionsCount() {
        return this.options_.size();
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public List<Option> getOptionsList() {
        return this.options_;
    }

    public OptionOrBuilder getOptionsOrBuilder(int i4) {
        return this.options_.get(i4);
    }

    public List<? extends OptionOrBuilder> getOptionsOrBuilderList() {
        return this.options_;
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public SourceContext getSourceContext() {
        SourceContext sourceContext = this.sourceContext_;
        if (sourceContext == null) {
            return SourceContext.getDefaultInstance();
        }
        return sourceContext;
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public Syntax getSyntax() {
        Syntax forNumber = Syntax.forNumber(this.syntax_);
        if (forNumber == null) {
            return Syntax.UNRECOGNIZED;
        }
        return forNumber;
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public int getSyntaxValue() {
        return this.syntax_;
    }

    @Override // com.google.protobuf.EnumOrBuilder
    public boolean hasSourceContext() {
        if (this.sourceContext_ != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.f33325a[methodToInvoke.ordinal()]) {
            case 1:
                return new Enum();
            case 2:
                return new Builder(null);
            case 3:
                return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0002\u0000\u0001Ȉ\u0002\u001b\u0003\u001b\u0004\t\u0005\f", new Object[]{"name_", "enumvalue_", EnumValue.class, "options_", Option.class, "sourceContext_", "syntax_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Enum> parser = PARSER;
                if (parser == null) {
                    synchronized (Enum.class) {
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

    public static Builder newBuilder(Enum r12) {
        return DEFAULT_INSTANCE.r(r12);
    }

    public static Enum parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Enum) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Enum parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Enum) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Enum parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (Enum) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
    }

    public static Enum parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Enum) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Enum parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (Enum) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
    }

    public static Enum parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Enum) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Enum parseFrom(InputStream inputStream) throws IOException {
        return (Enum) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
    }

    public static Enum parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Enum) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Enum parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Enum) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Enum parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Enum) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
