package com.google.protobuf;

import com.google.protobuf.Field;
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
public final class Type extends GeneratedMessageLite<Type, Builder> implements TypeOrBuilder {
    private static final Type DEFAULT_INSTANCE;
    public static final int FIELDS_FIELD_NUMBER = 2;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int ONEOFS_FIELD_NUMBER = 3;
    public static final int OPTIONS_FIELD_NUMBER = 4;
    private static volatile Parser<Type> PARSER = null;
    public static final int SOURCE_CONTEXT_FIELD_NUMBER = 5;
    public static final int SYNTAX_FIELD_NUMBER = 6;
    private SourceContext sourceContext_;
    private int syntax_;
    private String name_ = "";
    private Internal.ProtobufList<Field> fields_ = GeneratedMessageLite.y();
    private Internal.ProtobufList<String> oneofs_ = GeneratedMessageLite.y();
    private Internal.ProtobufList<Option> options_ = GeneratedMessageLite.y();

    /* renamed from: com.google.protobuf.Type$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f33584a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f33584a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f33584a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f33584a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f33584a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f33584a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f33584a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f33584a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<Type, Builder> implements TypeOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllFields(Iterable<? extends Field> iterable) {
            f();
            ((Type) this.f33398b).G0(iterable);
            return this;
        }

        public Builder addAllOneofs(Iterable<String> iterable) {
            f();
            ((Type) this.f33398b).H0(iterable);
            return this;
        }

        public Builder addAllOptions(Iterable<? extends Option> iterable) {
            f();
            ((Type) this.f33398b).I0(iterable);
            return this;
        }

        public Builder addFields(Field field) {
            f();
            ((Type) this.f33398b).K0(field);
            return this;
        }

        public Builder addOneofs(String str) {
            f();
            ((Type) this.f33398b).L0(str);
            return this;
        }

        public Builder addOneofsBytes(ByteString byteString) {
            f();
            ((Type) this.f33398b).M0(byteString);
            return this;
        }

        public Builder addOptions(Option option) {
            f();
            ((Type) this.f33398b).O0(option);
            return this;
        }

        public Builder clearFields() {
            f();
            ((Type) this.f33398b).P0();
            return this;
        }

        public Builder clearName() {
            f();
            ((Type) this.f33398b).Q0();
            return this;
        }

        public Builder clearOneofs() {
            f();
            ((Type) this.f33398b).R0();
            return this;
        }

        public Builder clearOptions() {
            f();
            ((Type) this.f33398b).S0();
            return this;
        }

        public Builder clearSourceContext() {
            f();
            ((Type) this.f33398b).T0();
            return this;
        }

        public Builder clearSyntax() {
            f();
            ((Type) this.f33398b).U0();
            return this;
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public Field getFields(int i4) {
            return ((Type) this.f33398b).getFields(i4);
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public int getFieldsCount() {
            return ((Type) this.f33398b).getFieldsCount();
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public List<Field> getFieldsList() {
            return Collections.unmodifiableList(((Type) this.f33398b).getFieldsList());
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public String getName() {
            return ((Type) this.f33398b).getName();
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public ByteString getNameBytes() {
            return ((Type) this.f33398b).getNameBytes();
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public String getOneofs(int i4) {
            return ((Type) this.f33398b).getOneofs(i4);
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public ByteString getOneofsBytes(int i4) {
            return ((Type) this.f33398b).getOneofsBytes(i4);
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public int getOneofsCount() {
            return ((Type) this.f33398b).getOneofsCount();
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public List<String> getOneofsList() {
            return Collections.unmodifiableList(((Type) this.f33398b).getOneofsList());
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public Option getOptions(int i4) {
            return ((Type) this.f33398b).getOptions(i4);
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public int getOptionsCount() {
            return ((Type) this.f33398b).getOptionsCount();
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public List<Option> getOptionsList() {
            return Collections.unmodifiableList(((Type) this.f33398b).getOptionsList());
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public SourceContext getSourceContext() {
            return ((Type) this.f33398b).getSourceContext();
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public Syntax getSyntax() {
            return ((Type) this.f33398b).getSyntax();
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public int getSyntaxValue() {
            return ((Type) this.f33398b).getSyntaxValue();
        }

        @Override // com.google.protobuf.TypeOrBuilder
        public boolean hasSourceContext() {
            return ((Type) this.f33398b).hasSourceContext();
        }

        public Builder mergeSourceContext(SourceContext sourceContext) {
            f();
            ((Type) this.f33398b).Y0(sourceContext);
            return this;
        }

        public Builder removeFields(int i4) {
            f();
            ((Type) this.f33398b).Z0(i4);
            return this;
        }

        public Builder removeOptions(int i4) {
            f();
            ((Type) this.f33398b).a1(i4);
            return this;
        }

        public Builder setFields(int i4, Field field) {
            f();
            ((Type) this.f33398b).b1(i4, field);
            return this;
        }

        public Builder setName(String str) {
            f();
            ((Type) this.f33398b).c1(str);
            return this;
        }

        public Builder setNameBytes(ByteString byteString) {
            f();
            ((Type) this.f33398b).d1(byteString);
            return this;
        }

        public Builder setOneofs(int i4, String str) {
            f();
            ((Type) this.f33398b).e1(i4, str);
            return this;
        }

        public Builder setOptions(int i4, Option option) {
            f();
            ((Type) this.f33398b).f1(i4, option);
            return this;
        }

        public Builder setSourceContext(SourceContext sourceContext) {
            f();
            ((Type) this.f33398b).g1(sourceContext);
            return this;
        }

        public Builder setSyntax(Syntax syntax) {
            f();
            ((Type) this.f33398b).h1(syntax);
            return this;
        }

        public Builder setSyntaxValue(int i4) {
            f();
            ((Type) this.f33398b).i1(i4);
            return this;
        }

        private Builder() {
            super(Type.DEFAULT_INSTANCE);
        }

        public Builder addFields(int i4, Field field) {
            f();
            ((Type) this.f33398b).J0(i4, field);
            return this;
        }

        public Builder addOptions(int i4, Option option) {
            f();
            ((Type) this.f33398b).N0(i4, option);
            return this;
        }

        public Builder setFields(int i4, Field.Builder builder) {
            f();
            ((Type) this.f33398b).b1(i4, builder.build());
            return this;
        }

        public Builder setOptions(int i4, Option.Builder builder) {
            f();
            ((Type) this.f33398b).f1(i4, builder.build());
            return this;
        }

        public Builder setSourceContext(SourceContext.Builder builder) {
            f();
            ((Type) this.f33398b).g1(builder.build());
            return this;
        }

        public Builder addFields(Field.Builder builder) {
            f();
            ((Type) this.f33398b).K0(builder.build());
            return this;
        }

        public Builder addOptions(Option.Builder builder) {
            f();
            ((Type) this.f33398b).O0(builder.build());
            return this;
        }

        public Builder addFields(int i4, Field.Builder builder) {
            f();
            ((Type) this.f33398b).J0(i4, builder.build());
            return this;
        }

        public Builder addOptions(int i4, Option.Builder builder) {
            f();
            ((Type) this.f33398b).N0(i4, builder.build());
            return this;
        }
    }

    static {
        Type type = new Type();
        DEFAULT_INSTANCE = type;
        GeneratedMessageLite.d0(Type.class, type);
    }

    private Type() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G0(Iterable<? extends Field> iterable) {
        V0();
        AbstractMessageLite.a(iterable, this.fields_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H0(Iterable<String> iterable) {
        W0();
        AbstractMessageLite.a(iterable, this.oneofs_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I0(Iterable<? extends Option> iterable) {
        X0();
        AbstractMessageLite.a(iterable, this.options_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J0(int i4, Field field) {
        field.getClass();
        V0();
        this.fields_.add(i4, field);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K0(Field field) {
        field.getClass();
        V0();
        this.fields_.add(field);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L0(String str) {
        str.getClass();
        W0();
        this.oneofs_.add(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M0(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        W0();
        this.oneofs_.add(byteString.toStringUtf8());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N0(int i4, Option option) {
        option.getClass();
        X0();
        this.options_.add(i4, option);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O0(Option option) {
        option.getClass();
        X0();
        this.options_.add(option);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P0() {
        this.fields_ = GeneratedMessageLite.y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q0() {
        this.name_ = getDefaultInstance().getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R0() {
        this.oneofs_ = GeneratedMessageLite.y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S0() {
        this.options_ = GeneratedMessageLite.y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T0() {
        this.sourceContext_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U0() {
        this.syntax_ = 0;
    }

    private void V0() {
        Internal.ProtobufList<Field> protobufList = this.fields_;
        if (!protobufList.isModifiable()) {
            this.fields_ = GeneratedMessageLite.K(protobufList);
        }
    }

    private void W0() {
        Internal.ProtobufList<String> protobufList = this.oneofs_;
        if (!protobufList.isModifiable()) {
            this.oneofs_ = GeneratedMessageLite.K(protobufList);
        }
    }

    private void X0() {
        Internal.ProtobufList<Option> protobufList = this.options_;
        if (!protobufList.isModifiable()) {
            this.options_ = GeneratedMessageLite.K(protobufList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y0(SourceContext sourceContext) {
        sourceContext.getClass();
        SourceContext sourceContext2 = this.sourceContext_;
        if (sourceContext2 != null && sourceContext2 != SourceContext.getDefaultInstance()) {
            this.sourceContext_ = SourceContext.newBuilder(this.sourceContext_).mergeFrom((SourceContext.Builder) sourceContext).buildPartial();
        } else {
            this.sourceContext_ = sourceContext;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z0(int i4) {
        V0();
        this.fields_.remove(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a1(int i4) {
        X0();
        this.options_.remove(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b1(int i4, Field field) {
        field.getClass();
        V0();
        this.fields_.set(i4, field);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c1(String str) {
        str.getClass();
        this.name_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d1(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        this.name_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e1(int i4, String str) {
        str.getClass();
        W0();
        this.oneofs_.set(i4, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f1(int i4, Option option) {
        option.getClass();
        X0();
        this.options_.set(i4, option);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g1(SourceContext sourceContext) {
        sourceContext.getClass();
        this.sourceContext_ = sourceContext;
    }

    public static Type getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h1(Syntax syntax) {
        this.syntax_ = syntax.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i1(int i4) {
        this.syntax_ = i4;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.q();
    }

    public static Type parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Type) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
    }

    public static Type parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (Type) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Type> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public Field getFields(int i4) {
        return this.fields_.get(i4);
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public int getFieldsCount() {
        return this.fields_.size();
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public List<Field> getFieldsList() {
        return this.fields_;
    }

    public FieldOrBuilder getFieldsOrBuilder(int i4) {
        return this.fields_.get(i4);
    }

    public List<? extends FieldOrBuilder> getFieldsOrBuilderList() {
        return this.fields_;
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public String getName() {
        return this.name_;
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public ByteString getNameBytes() {
        return ByteString.copyFromUtf8(this.name_);
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public String getOneofs(int i4) {
        return this.oneofs_.get(i4);
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public ByteString getOneofsBytes(int i4) {
        return ByteString.copyFromUtf8(this.oneofs_.get(i4));
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public int getOneofsCount() {
        return this.oneofs_.size();
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public List<String> getOneofsList() {
        return this.oneofs_;
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public Option getOptions(int i4) {
        return this.options_.get(i4);
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public int getOptionsCount() {
        return this.options_.size();
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public List<Option> getOptionsList() {
        return this.options_;
    }

    public OptionOrBuilder getOptionsOrBuilder(int i4) {
        return this.options_.get(i4);
    }

    public List<? extends OptionOrBuilder> getOptionsOrBuilderList() {
        return this.options_;
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public SourceContext getSourceContext() {
        SourceContext sourceContext = this.sourceContext_;
        if (sourceContext == null) {
            return SourceContext.getDefaultInstance();
        }
        return sourceContext;
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public Syntax getSyntax() {
        Syntax forNumber = Syntax.forNumber(this.syntax_);
        if (forNumber == null) {
            return Syntax.UNRECOGNIZED;
        }
        return forNumber;
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public int getSyntaxValue() {
        return this.syntax_;
    }

    @Override // com.google.protobuf.TypeOrBuilder
    public boolean hasSourceContext() {
        if (this.sourceContext_ != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.f33584a[methodToInvoke.ordinal()]) {
            case 1:
                return new Type();
            case 2:
                return new Builder(null);
            case 3:
                return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0000\u0001\u0006\u0006\u0000\u0003\u0000\u0001Ȉ\u0002\u001b\u0003Ț\u0004\u001b\u0005\t\u0006\f", new Object[]{"name_", "fields_", Field.class, "oneofs_", "options_", Option.class, "sourceContext_", "syntax_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Type> parser = PARSER;
                if (parser == null) {
                    synchronized (Type.class) {
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

    public static Builder newBuilder(Type type) {
        return DEFAULT_INSTANCE.r(type);
    }

    public static Type parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Type) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Type parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Type) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Type parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (Type) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
    }

    public static Type parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Type) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Type parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (Type) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
    }

    public static Type parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Type) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Type parseFrom(InputStream inputStream) throws IOException {
        return (Type) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
    }

    public static Type parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Type) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Type parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Type) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Type parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Type) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
