package com.google.protobuf;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: classes6.dex */
public final class DescriptorProtos {

    /* renamed from: com.google.protobuf.DescriptorProtos$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f33300a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f33300a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f33300a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f33300a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f33300a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f33300a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f33300a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f33300a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class DescriptorProto extends GeneratedMessageLite<DescriptorProto, Builder> implements DescriptorProtoOrBuilder {
        private static final DescriptorProto DEFAULT_INSTANCE;
        public static final int ENUM_TYPE_FIELD_NUMBER = 4;
        public static final int EXTENSION_FIELD_NUMBER = 6;
        public static final int EXTENSION_RANGE_FIELD_NUMBER = 5;
        public static final int FIELD_FIELD_NUMBER = 2;
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int NESTED_TYPE_FIELD_NUMBER = 3;
        public static final int ONEOF_DECL_FIELD_NUMBER = 8;
        public static final int OPTIONS_FIELD_NUMBER = 7;
        private static volatile Parser<DescriptorProto> PARSER = null;
        public static final int RESERVED_NAME_FIELD_NUMBER = 10;
        public static final int RESERVED_RANGE_FIELD_NUMBER = 9;
        private int bitField0_;
        private MessageOptions options_;
        private byte memoizedIsInitialized = 2;
        private String name_ = "";
        private Internal.ProtobufList<FieldDescriptorProto> field_ = GeneratedMessageLite.y();
        private Internal.ProtobufList<FieldDescriptorProto> extension_ = GeneratedMessageLite.y();
        private Internal.ProtobufList<DescriptorProto> nestedType_ = GeneratedMessageLite.y();
        private Internal.ProtobufList<EnumDescriptorProto> enumType_ = GeneratedMessageLite.y();
        private Internal.ProtobufList<ExtensionRange> extensionRange_ = GeneratedMessageLite.y();
        private Internal.ProtobufList<OneofDescriptorProto> oneofDecl_ = GeneratedMessageLite.y();
        private Internal.ProtobufList<ReservedRange> reservedRange_ = GeneratedMessageLite.y();
        private Internal.ProtobufList<String> reservedName_ = GeneratedMessageLite.y();

        /* loaded from: classes6.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<DescriptorProto, Builder> implements DescriptorProtoOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder addAllEnumType(Iterable<? extends EnumDescriptorProto> iterable) {
                f();
                ((DescriptorProto) this.f33398b).h1(iterable);
                return this;
            }

            public Builder addAllExtension(Iterable<? extends FieldDescriptorProto> iterable) {
                f();
                ((DescriptorProto) this.f33398b).i1(iterable);
                return this;
            }

            public Builder addAllExtensionRange(Iterable<? extends ExtensionRange> iterable) {
                f();
                ((DescriptorProto) this.f33398b).j1(iterable);
                return this;
            }

            public Builder addAllField(Iterable<? extends FieldDescriptorProto> iterable) {
                f();
                ((DescriptorProto) this.f33398b).k1(iterable);
                return this;
            }

            public Builder addAllNestedType(Iterable<? extends DescriptorProto> iterable) {
                f();
                ((DescriptorProto) this.f33398b).l1(iterable);
                return this;
            }

            public Builder addAllOneofDecl(Iterable<? extends OneofDescriptorProto> iterable) {
                f();
                ((DescriptorProto) this.f33398b).m1(iterable);
                return this;
            }

            public Builder addAllReservedName(Iterable<String> iterable) {
                f();
                ((DescriptorProto) this.f33398b).n1(iterable);
                return this;
            }

            public Builder addAllReservedRange(Iterable<? extends ReservedRange> iterable) {
                f();
                ((DescriptorProto) this.f33398b).o1(iterable);
                return this;
            }

            public Builder addEnumType(EnumDescriptorProto enumDescriptorProto) {
                f();
                ((DescriptorProto) this.f33398b).q1(enumDescriptorProto);
                return this;
            }

            public Builder addExtension(FieldDescriptorProto fieldDescriptorProto) {
                f();
                ((DescriptorProto) this.f33398b).s1(fieldDescriptorProto);
                return this;
            }

            public Builder addExtensionRange(ExtensionRange extensionRange) {
                f();
                ((DescriptorProto) this.f33398b).u1(extensionRange);
                return this;
            }

            public Builder addField(FieldDescriptorProto fieldDescriptorProto) {
                f();
                ((DescriptorProto) this.f33398b).w1(fieldDescriptorProto);
                return this;
            }

            public Builder addNestedType(DescriptorProto descriptorProto) {
                f();
                ((DescriptorProto) this.f33398b).y1(descriptorProto);
                return this;
            }

            public Builder addOneofDecl(OneofDescriptorProto oneofDescriptorProto) {
                f();
                ((DescriptorProto) this.f33398b).A1(oneofDescriptorProto);
                return this;
            }

            public Builder addReservedName(String str) {
                f();
                ((DescriptorProto) this.f33398b).B1(str);
                return this;
            }

            public Builder addReservedNameBytes(ByteString byteString) {
                f();
                ((DescriptorProto) this.f33398b).C1(byteString);
                return this;
            }

            public Builder addReservedRange(ReservedRange reservedRange) {
                f();
                ((DescriptorProto) this.f33398b).E1(reservedRange);
                return this;
            }

            public Builder clearEnumType() {
                f();
                ((DescriptorProto) this.f33398b).F1();
                return this;
            }

            public Builder clearExtension() {
                f();
                ((DescriptorProto) this.f33398b).G1();
                return this;
            }

            public Builder clearExtensionRange() {
                f();
                ((DescriptorProto) this.f33398b).H1();
                return this;
            }

            public Builder clearField() {
                f();
                ((DescriptorProto) this.f33398b).I1();
                return this;
            }

            public Builder clearName() {
                f();
                ((DescriptorProto) this.f33398b).J1();
                return this;
            }

            public Builder clearNestedType() {
                f();
                ((DescriptorProto) this.f33398b).K1();
                return this;
            }

            public Builder clearOneofDecl() {
                f();
                ((DescriptorProto) this.f33398b).L1();
                return this;
            }

            public Builder clearOptions() {
                f();
                ((DescriptorProto) this.f33398b).M1();
                return this;
            }

            public Builder clearReservedName() {
                f();
                ((DescriptorProto) this.f33398b).N1();
                return this;
            }

            public Builder clearReservedRange() {
                f();
                ((DescriptorProto) this.f33398b).O1();
                return this;
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public EnumDescriptorProto getEnumType(int i4) {
                return ((DescriptorProto) this.f33398b).getEnumType(i4);
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public int getEnumTypeCount() {
                return ((DescriptorProto) this.f33398b).getEnumTypeCount();
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public List<EnumDescriptorProto> getEnumTypeList() {
                return Collections.unmodifiableList(((DescriptorProto) this.f33398b).getEnumTypeList());
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public FieldDescriptorProto getExtension(int i4) {
                return ((DescriptorProto) this.f33398b).getExtension(i4);
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public int getExtensionCount() {
                return ((DescriptorProto) this.f33398b).getExtensionCount();
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public List<FieldDescriptorProto> getExtensionList() {
                return Collections.unmodifiableList(((DescriptorProto) this.f33398b).getExtensionList());
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public ExtensionRange getExtensionRange(int i4) {
                return ((DescriptorProto) this.f33398b).getExtensionRange(i4);
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public int getExtensionRangeCount() {
                return ((DescriptorProto) this.f33398b).getExtensionRangeCount();
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public List<ExtensionRange> getExtensionRangeList() {
                return Collections.unmodifiableList(((DescriptorProto) this.f33398b).getExtensionRangeList());
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public FieldDescriptorProto getField(int i4) {
                return ((DescriptorProto) this.f33398b).getField(i4);
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public int getFieldCount() {
                return ((DescriptorProto) this.f33398b).getFieldCount();
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public List<FieldDescriptorProto> getFieldList() {
                return Collections.unmodifiableList(((DescriptorProto) this.f33398b).getFieldList());
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public String getName() {
                return ((DescriptorProto) this.f33398b).getName();
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public ByteString getNameBytes() {
                return ((DescriptorProto) this.f33398b).getNameBytes();
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public DescriptorProto getNestedType(int i4) {
                return ((DescriptorProto) this.f33398b).getNestedType(i4);
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public int getNestedTypeCount() {
                return ((DescriptorProto) this.f33398b).getNestedTypeCount();
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public List<DescriptorProto> getNestedTypeList() {
                return Collections.unmodifiableList(((DescriptorProto) this.f33398b).getNestedTypeList());
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public OneofDescriptorProto getOneofDecl(int i4) {
                return ((DescriptorProto) this.f33398b).getOneofDecl(i4);
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public int getOneofDeclCount() {
                return ((DescriptorProto) this.f33398b).getOneofDeclCount();
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public List<OneofDescriptorProto> getOneofDeclList() {
                return Collections.unmodifiableList(((DescriptorProto) this.f33398b).getOneofDeclList());
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public MessageOptions getOptions() {
                return ((DescriptorProto) this.f33398b).getOptions();
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public String getReservedName(int i4) {
                return ((DescriptorProto) this.f33398b).getReservedName(i4);
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public ByteString getReservedNameBytes(int i4) {
                return ((DescriptorProto) this.f33398b).getReservedNameBytes(i4);
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public int getReservedNameCount() {
                return ((DescriptorProto) this.f33398b).getReservedNameCount();
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public List<String> getReservedNameList() {
                return Collections.unmodifiableList(((DescriptorProto) this.f33398b).getReservedNameList());
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public ReservedRange getReservedRange(int i4) {
                return ((DescriptorProto) this.f33398b).getReservedRange(i4);
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public int getReservedRangeCount() {
                return ((DescriptorProto) this.f33398b).getReservedRangeCount();
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public List<ReservedRange> getReservedRangeList() {
                return Collections.unmodifiableList(((DescriptorProto) this.f33398b).getReservedRangeList());
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public boolean hasName() {
                return ((DescriptorProto) this.f33398b).hasName();
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public boolean hasOptions() {
                return ((DescriptorProto) this.f33398b).hasOptions();
            }

            public Builder mergeOptions(MessageOptions messageOptions) {
                f();
                ((DescriptorProto) this.f33398b).X1(messageOptions);
                return this;
            }

            public Builder removeEnumType(int i4) {
                f();
                ((DescriptorProto) this.f33398b).Y1(i4);
                return this;
            }

            public Builder removeExtension(int i4) {
                f();
                ((DescriptorProto) this.f33398b).Z1(i4);
                return this;
            }

            public Builder removeExtensionRange(int i4) {
                f();
                ((DescriptorProto) this.f33398b).a2(i4);
                return this;
            }

            public Builder removeField(int i4) {
                f();
                ((DescriptorProto) this.f33398b).b2(i4);
                return this;
            }

            public Builder removeNestedType(int i4) {
                f();
                ((DescriptorProto) this.f33398b).c2(i4);
                return this;
            }

            public Builder removeOneofDecl(int i4) {
                f();
                ((DescriptorProto) this.f33398b).d2(i4);
                return this;
            }

            public Builder removeReservedRange(int i4) {
                f();
                ((DescriptorProto) this.f33398b).e2(i4);
                return this;
            }

            public Builder setEnumType(int i4, EnumDescriptorProto enumDescriptorProto) {
                f();
                ((DescriptorProto) this.f33398b).f2(i4, enumDescriptorProto);
                return this;
            }

            public Builder setExtension(int i4, FieldDescriptorProto fieldDescriptorProto) {
                f();
                ((DescriptorProto) this.f33398b).g2(i4, fieldDescriptorProto);
                return this;
            }

            public Builder setExtensionRange(int i4, ExtensionRange extensionRange) {
                f();
                ((DescriptorProto) this.f33398b).h2(i4, extensionRange);
                return this;
            }

            public Builder setField(int i4, FieldDescriptorProto fieldDescriptorProto) {
                f();
                ((DescriptorProto) this.f33398b).i2(i4, fieldDescriptorProto);
                return this;
            }

            public Builder setName(String str) {
                f();
                ((DescriptorProto) this.f33398b).j2(str);
                return this;
            }

            public Builder setNameBytes(ByteString byteString) {
                f();
                ((DescriptorProto) this.f33398b).k2(byteString);
                return this;
            }

            public Builder setNestedType(int i4, DescriptorProto descriptorProto) {
                f();
                ((DescriptorProto) this.f33398b).l2(i4, descriptorProto);
                return this;
            }

            public Builder setOneofDecl(int i4, OneofDescriptorProto oneofDescriptorProto) {
                f();
                ((DescriptorProto) this.f33398b).m2(i4, oneofDescriptorProto);
                return this;
            }

            public Builder setOptions(MessageOptions messageOptions) {
                f();
                ((DescriptorProto) this.f33398b).n2(messageOptions);
                return this;
            }

            public Builder setReservedName(int i4, String str) {
                f();
                ((DescriptorProto) this.f33398b).o2(i4, str);
                return this;
            }

            public Builder setReservedRange(int i4, ReservedRange reservedRange) {
                f();
                ((DescriptorProto) this.f33398b).p2(i4, reservedRange);
                return this;
            }

            private Builder() {
                super(DescriptorProto.DEFAULT_INSTANCE);
            }

            public Builder addEnumType(int i4, EnumDescriptorProto enumDescriptorProto) {
                f();
                ((DescriptorProto) this.f33398b).p1(i4, enumDescriptorProto);
                return this;
            }

            public Builder addExtension(int i4, FieldDescriptorProto fieldDescriptorProto) {
                f();
                ((DescriptorProto) this.f33398b).r1(i4, fieldDescriptorProto);
                return this;
            }

            public Builder addExtensionRange(int i4, ExtensionRange extensionRange) {
                f();
                ((DescriptorProto) this.f33398b).t1(i4, extensionRange);
                return this;
            }

            public Builder addField(int i4, FieldDescriptorProto fieldDescriptorProto) {
                f();
                ((DescriptorProto) this.f33398b).v1(i4, fieldDescriptorProto);
                return this;
            }

            public Builder addNestedType(int i4, DescriptorProto descriptorProto) {
                f();
                ((DescriptorProto) this.f33398b).x1(i4, descriptorProto);
                return this;
            }

            public Builder addOneofDecl(int i4, OneofDescriptorProto oneofDescriptorProto) {
                f();
                ((DescriptorProto) this.f33398b).z1(i4, oneofDescriptorProto);
                return this;
            }

            public Builder addReservedRange(int i4, ReservedRange reservedRange) {
                f();
                ((DescriptorProto) this.f33398b).D1(i4, reservedRange);
                return this;
            }

            public Builder setEnumType(int i4, EnumDescriptorProto.Builder builder) {
                f();
                ((DescriptorProto) this.f33398b).f2(i4, builder.build());
                return this;
            }

            public Builder setExtension(int i4, FieldDescriptorProto.Builder builder) {
                f();
                ((DescriptorProto) this.f33398b).g2(i4, builder.build());
                return this;
            }

            public Builder setExtensionRange(int i4, ExtensionRange.Builder builder) {
                f();
                ((DescriptorProto) this.f33398b).h2(i4, builder.build());
                return this;
            }

            public Builder setField(int i4, FieldDescriptorProto.Builder builder) {
                f();
                ((DescriptorProto) this.f33398b).i2(i4, builder.build());
                return this;
            }

            public Builder setNestedType(int i4, Builder builder) {
                f();
                ((DescriptorProto) this.f33398b).l2(i4, builder.build());
                return this;
            }

            public Builder setOneofDecl(int i4, OneofDescriptorProto.Builder builder) {
                f();
                ((DescriptorProto) this.f33398b).m2(i4, builder.build());
                return this;
            }

            public Builder setOptions(MessageOptions.Builder builder) {
                f();
                ((DescriptorProto) this.f33398b).n2((MessageOptions) builder.build());
                return this;
            }

            public Builder setReservedRange(int i4, ReservedRange.Builder builder) {
                f();
                ((DescriptorProto) this.f33398b).p2(i4, builder.build());
                return this;
            }

            public Builder addEnumType(EnumDescriptorProto.Builder builder) {
                f();
                ((DescriptorProto) this.f33398b).q1(builder.build());
                return this;
            }

            public Builder addExtension(FieldDescriptorProto.Builder builder) {
                f();
                ((DescriptorProto) this.f33398b).s1(builder.build());
                return this;
            }

            public Builder addExtensionRange(ExtensionRange.Builder builder) {
                f();
                ((DescriptorProto) this.f33398b).u1(builder.build());
                return this;
            }

            public Builder addField(FieldDescriptorProto.Builder builder) {
                f();
                ((DescriptorProto) this.f33398b).w1(builder.build());
                return this;
            }

            public Builder addNestedType(Builder builder) {
                f();
                ((DescriptorProto) this.f33398b).y1(builder.build());
                return this;
            }

            public Builder addOneofDecl(OneofDescriptorProto.Builder builder) {
                f();
                ((DescriptorProto) this.f33398b).A1(builder.build());
                return this;
            }

            public Builder addReservedRange(ReservedRange.Builder builder) {
                f();
                ((DescriptorProto) this.f33398b).E1(builder.build());
                return this;
            }

            public Builder addEnumType(int i4, EnumDescriptorProto.Builder builder) {
                f();
                ((DescriptorProto) this.f33398b).p1(i4, builder.build());
                return this;
            }

            public Builder addExtension(int i4, FieldDescriptorProto.Builder builder) {
                f();
                ((DescriptorProto) this.f33398b).r1(i4, builder.build());
                return this;
            }

            public Builder addExtensionRange(int i4, ExtensionRange.Builder builder) {
                f();
                ((DescriptorProto) this.f33398b).t1(i4, builder.build());
                return this;
            }

            public Builder addField(int i4, FieldDescriptorProto.Builder builder) {
                f();
                ((DescriptorProto) this.f33398b).v1(i4, builder.build());
                return this;
            }

            public Builder addNestedType(int i4, Builder builder) {
                f();
                ((DescriptorProto) this.f33398b).x1(i4, builder.build());
                return this;
            }

            public Builder addOneofDecl(int i4, OneofDescriptorProto.Builder builder) {
                f();
                ((DescriptorProto) this.f33398b).z1(i4, builder.build());
                return this;
            }

            public Builder addReservedRange(int i4, ReservedRange.Builder builder) {
                f();
                ((DescriptorProto) this.f33398b).D1(i4, builder.build());
                return this;
            }
        }

        /* loaded from: classes6.dex */
        public static final class ExtensionRange extends GeneratedMessageLite<ExtensionRange, Builder> implements ExtensionRangeOrBuilder {
            private static final ExtensionRange DEFAULT_INSTANCE;
            public static final int END_FIELD_NUMBER = 2;
            public static final int OPTIONS_FIELD_NUMBER = 3;
            private static volatile Parser<ExtensionRange> PARSER = null;
            public static final int START_FIELD_NUMBER = 1;
            private int bitField0_;
            private int end_;
            private byte memoizedIsInitialized = 2;
            private ExtensionRangeOptions options_;
            private int start_;

            /* loaded from: classes6.dex */
            public static final class Builder extends GeneratedMessageLite.Builder<ExtensionRange, Builder> implements ExtensionRangeOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                public Builder clearEnd() {
                    f();
                    ((ExtensionRange) this.f33398b).n0();
                    return this;
                }

                public Builder clearOptions() {
                    f();
                    ((ExtensionRange) this.f33398b).o0();
                    return this;
                }

                public Builder clearStart() {
                    f();
                    ((ExtensionRange) this.f33398b).p0();
                    return this;
                }

                @Override // com.google.protobuf.DescriptorProtos.DescriptorProto.ExtensionRangeOrBuilder
                public int getEnd() {
                    return ((ExtensionRange) this.f33398b).getEnd();
                }

                @Override // com.google.protobuf.DescriptorProtos.DescriptorProto.ExtensionRangeOrBuilder
                public ExtensionRangeOptions getOptions() {
                    return ((ExtensionRange) this.f33398b).getOptions();
                }

                @Override // com.google.protobuf.DescriptorProtos.DescriptorProto.ExtensionRangeOrBuilder
                public int getStart() {
                    return ((ExtensionRange) this.f33398b).getStart();
                }

                @Override // com.google.protobuf.DescriptorProtos.DescriptorProto.ExtensionRangeOrBuilder
                public boolean hasEnd() {
                    return ((ExtensionRange) this.f33398b).hasEnd();
                }

                @Override // com.google.protobuf.DescriptorProtos.DescriptorProto.ExtensionRangeOrBuilder
                public boolean hasOptions() {
                    return ((ExtensionRange) this.f33398b).hasOptions();
                }

                @Override // com.google.protobuf.DescriptorProtos.DescriptorProto.ExtensionRangeOrBuilder
                public boolean hasStart() {
                    return ((ExtensionRange) this.f33398b).hasStart();
                }

                public Builder mergeOptions(ExtensionRangeOptions extensionRangeOptions) {
                    f();
                    ((ExtensionRange) this.f33398b).q0(extensionRangeOptions);
                    return this;
                }

                public Builder setEnd(int i4) {
                    f();
                    ((ExtensionRange) this.f33398b).r0(i4);
                    return this;
                }

                public Builder setOptions(ExtensionRangeOptions extensionRangeOptions) {
                    f();
                    ((ExtensionRange) this.f33398b).s0(extensionRangeOptions);
                    return this;
                }

                public Builder setStart(int i4) {
                    f();
                    ((ExtensionRange) this.f33398b).t0(i4);
                    return this;
                }

                private Builder() {
                    super(ExtensionRange.DEFAULT_INSTANCE);
                }

                public Builder setOptions(ExtensionRangeOptions.Builder builder) {
                    f();
                    ((ExtensionRange) this.f33398b).s0((ExtensionRangeOptions) builder.build());
                    return this;
                }
            }

            static {
                ExtensionRange extensionRange = new ExtensionRange();
                DEFAULT_INSTANCE = extensionRange;
                GeneratedMessageLite.d0(ExtensionRange.class, extensionRange);
            }

            private ExtensionRange() {
            }

            public static ExtensionRange getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void n0() {
                this.bitField0_ &= -3;
                this.end_ = 0;
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.q();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void o0() {
                this.options_ = null;
                this.bitField0_ &= -5;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void p0() {
                this.bitField0_ &= -2;
                this.start_ = 0;
            }

            public static ExtensionRange parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (ExtensionRange) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
            }

            public static ExtensionRange parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return (ExtensionRange) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
            }

            public static Parser<ExtensionRange> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void q0(ExtensionRangeOptions extensionRangeOptions) {
                extensionRangeOptions.getClass();
                ExtensionRangeOptions extensionRangeOptions2 = this.options_;
                if (extensionRangeOptions2 != null && extensionRangeOptions2 != ExtensionRangeOptions.getDefaultInstance()) {
                    this.options_ = ((ExtensionRangeOptions.Builder) ExtensionRangeOptions.newBuilder(this.options_).mergeFrom((ExtensionRangeOptions.Builder) extensionRangeOptions)).buildPartial();
                } else {
                    this.options_ = extensionRangeOptions;
                }
                this.bitField0_ |= 4;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void r0(int i4) {
                this.bitField0_ |= 2;
                this.end_ = i4;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void s0(ExtensionRangeOptions extensionRangeOptions) {
                extensionRangeOptions.getClass();
                this.options_ = extensionRangeOptions;
                this.bitField0_ |= 4;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void t0(int i4) {
                this.bitField0_ |= 1;
                this.start_ = i4;
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProto.ExtensionRangeOrBuilder
            public int getEnd() {
                return this.end_;
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProto.ExtensionRangeOrBuilder
            public ExtensionRangeOptions getOptions() {
                ExtensionRangeOptions extensionRangeOptions = this.options_;
                if (extensionRangeOptions == null) {
                    return ExtensionRangeOptions.getDefaultInstance();
                }
                return extensionRangeOptions;
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProto.ExtensionRangeOrBuilder
            public int getStart() {
                return this.start_;
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProto.ExtensionRangeOrBuilder
            public boolean hasEnd() {
                if ((this.bitField0_ & 2) != 0) {
                    return true;
                }
                return false;
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProto.ExtensionRangeOrBuilder
            public boolean hasOptions() {
                if ((this.bitField0_ & 4) != 0) {
                    return true;
                }
                return false;
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProto.ExtensionRangeOrBuilder
            public boolean hasStart() {
                if ((this.bitField0_ & 1) != 0) {
                    return true;
                }
                return false;
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                int i4 = 1;
                switch (AnonymousClass1.f33300a[methodToInvoke.ordinal()]) {
                    case 1:
                        return new ExtensionRange();
                    case 2:
                        return new Builder(null);
                    case 3:
                        return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0001\u0001င\u0000\u0002င\u0001\u0003ᐉ\u0002", new Object[]{"bitField0_", "start_", "end_", "options_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<ExtensionRange> parser = PARSER;
                        if (parser == null) {
                            synchronized (ExtensionRange.class) {
                                parser = PARSER;
                                if (parser == null) {
                                    parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                    PARSER = parser;
                                }
                            }
                        }
                        return parser;
                    case 6:
                        return Byte.valueOf(this.memoizedIsInitialized);
                    case 7:
                        if (obj == null) {
                            i4 = 0;
                        }
                        this.memoizedIsInitialized = (byte) i4;
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            public static Builder newBuilder(ExtensionRange extensionRange) {
                return DEFAULT_INSTANCE.r(extensionRange);
            }

            public static ExtensionRange parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (ExtensionRange) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static ExtensionRange parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (ExtensionRange) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static ExtensionRange parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (ExtensionRange) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
            }

            public static ExtensionRange parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (ExtensionRange) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static ExtensionRange parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (ExtensionRange) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
            }

            public static ExtensionRange parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (ExtensionRange) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static ExtensionRange parseFrom(InputStream inputStream) throws IOException {
                return (ExtensionRange) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
            }

            public static ExtensionRange parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (ExtensionRange) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static ExtensionRange parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (ExtensionRange) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
            }

            public static ExtensionRange parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (ExtensionRange) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }
        }

        /* loaded from: classes6.dex */
        public interface ExtensionRangeOrBuilder extends MessageLiteOrBuilder {
            int getEnd();

            ExtensionRangeOptions getOptions();

            int getStart();

            boolean hasEnd();

            boolean hasOptions();

            boolean hasStart();
        }

        /* loaded from: classes6.dex */
        public static final class ReservedRange extends GeneratedMessageLite<ReservedRange, Builder> implements ReservedRangeOrBuilder {
            private static final ReservedRange DEFAULT_INSTANCE;
            public static final int END_FIELD_NUMBER = 2;
            private static volatile Parser<ReservedRange> PARSER = null;
            public static final int START_FIELD_NUMBER = 1;
            private int bitField0_;
            private int end_;
            private int start_;

            /* loaded from: classes6.dex */
            public static final class Builder extends GeneratedMessageLite.Builder<ReservedRange, Builder> implements ReservedRangeOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                public Builder clearEnd() {
                    f();
                    ((ReservedRange) this.f33398b).k0();
                    return this;
                }

                public Builder clearStart() {
                    f();
                    ((ReservedRange) this.f33398b).l0();
                    return this;
                }

                @Override // com.google.protobuf.DescriptorProtos.DescriptorProto.ReservedRangeOrBuilder
                public int getEnd() {
                    return ((ReservedRange) this.f33398b).getEnd();
                }

                @Override // com.google.protobuf.DescriptorProtos.DescriptorProto.ReservedRangeOrBuilder
                public int getStart() {
                    return ((ReservedRange) this.f33398b).getStart();
                }

                @Override // com.google.protobuf.DescriptorProtos.DescriptorProto.ReservedRangeOrBuilder
                public boolean hasEnd() {
                    return ((ReservedRange) this.f33398b).hasEnd();
                }

                @Override // com.google.protobuf.DescriptorProtos.DescriptorProto.ReservedRangeOrBuilder
                public boolean hasStart() {
                    return ((ReservedRange) this.f33398b).hasStart();
                }

                public Builder setEnd(int i4) {
                    f();
                    ((ReservedRange) this.f33398b).m0(i4);
                    return this;
                }

                public Builder setStart(int i4) {
                    f();
                    ((ReservedRange) this.f33398b).n0(i4);
                    return this;
                }

                private Builder() {
                    super(ReservedRange.DEFAULT_INSTANCE);
                }
            }

            static {
                ReservedRange reservedRange = new ReservedRange();
                DEFAULT_INSTANCE = reservedRange;
                GeneratedMessageLite.d0(ReservedRange.class, reservedRange);
            }

            private ReservedRange() {
            }

            public static ReservedRange getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void k0() {
                this.bitField0_ &= -3;
                this.end_ = 0;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void l0() {
                this.bitField0_ &= -2;
                this.start_ = 0;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void m0(int i4) {
                this.bitField0_ |= 2;
                this.end_ = i4;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void n0(int i4) {
                this.bitField0_ |= 1;
                this.start_ = i4;
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.q();
            }

            public static ReservedRange parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (ReservedRange) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
            }

            public static ReservedRange parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return (ReservedRange) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
            }

            public static Parser<ReservedRange> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProto.ReservedRangeOrBuilder
            public int getEnd() {
                return this.end_;
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProto.ReservedRangeOrBuilder
            public int getStart() {
                return this.start_;
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProto.ReservedRangeOrBuilder
            public boolean hasEnd() {
                if ((this.bitField0_ & 2) != 0) {
                    return true;
                }
                return false;
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProto.ReservedRangeOrBuilder
            public boolean hasStart() {
                if ((this.bitField0_ & 1) != 0) {
                    return true;
                }
                return false;
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                switch (AnonymousClass1.f33300a[methodToInvoke.ordinal()]) {
                    case 1:
                        return new ReservedRange();
                    case 2:
                        return new Builder(null);
                    case 3:
                        return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001", new Object[]{"bitField0_", "start_", "end_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<ReservedRange> parser = PARSER;
                        if (parser == null) {
                            synchronized (ReservedRange.class) {
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

            public static Builder newBuilder(ReservedRange reservedRange) {
                return DEFAULT_INSTANCE.r(reservedRange);
            }

            public static ReservedRange parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (ReservedRange) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static ReservedRange parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (ReservedRange) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static ReservedRange parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (ReservedRange) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
            }

            public static ReservedRange parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (ReservedRange) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static ReservedRange parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (ReservedRange) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
            }

            public static ReservedRange parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (ReservedRange) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static ReservedRange parseFrom(InputStream inputStream) throws IOException {
                return (ReservedRange) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
            }

            public static ReservedRange parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (ReservedRange) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static ReservedRange parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (ReservedRange) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
            }

            public static ReservedRange parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (ReservedRange) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }
        }

        /* loaded from: classes6.dex */
        public interface ReservedRangeOrBuilder extends MessageLiteOrBuilder {
            int getEnd();

            int getStart();

            boolean hasEnd();

            boolean hasStart();
        }

        static {
            DescriptorProto descriptorProto = new DescriptorProto();
            DEFAULT_INSTANCE = descriptorProto;
            GeneratedMessageLite.d0(DescriptorProto.class, descriptorProto);
        }

        private DescriptorProto() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void A1(OneofDescriptorProto oneofDescriptorProto) {
            oneofDescriptorProto.getClass();
            U1();
            this.oneofDecl_.add(oneofDescriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void B1(String str) {
            str.getClass();
            V1();
            this.reservedName_.add(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void C1(ByteString byteString) {
            V1();
            this.reservedName_.add(byteString.toStringUtf8());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void D1(int i4, ReservedRange reservedRange) {
            reservedRange.getClass();
            W1();
            this.reservedRange_.add(i4, reservedRange);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void E1(ReservedRange reservedRange) {
            reservedRange.getClass();
            W1();
            this.reservedRange_.add(reservedRange);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void F1() {
            this.enumType_ = GeneratedMessageLite.y();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void G1() {
            this.extension_ = GeneratedMessageLite.y();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void H1() {
            this.extensionRange_ = GeneratedMessageLite.y();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void I1() {
            this.field_ = GeneratedMessageLite.y();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void J1() {
            this.bitField0_ &= -2;
            this.name_ = getDefaultInstance().getName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void K1() {
            this.nestedType_ = GeneratedMessageLite.y();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void L1() {
            this.oneofDecl_ = GeneratedMessageLite.y();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void M1() {
            this.options_ = null;
            this.bitField0_ &= -3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void N1() {
            this.reservedName_ = GeneratedMessageLite.y();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void O1() {
            this.reservedRange_ = GeneratedMessageLite.y();
        }

        private void P1() {
            Internal.ProtobufList<EnumDescriptorProto> protobufList = this.enumType_;
            if (!protobufList.isModifiable()) {
                this.enumType_ = GeneratedMessageLite.K(protobufList);
            }
        }

        private void Q1() {
            Internal.ProtobufList<FieldDescriptorProto> protobufList = this.extension_;
            if (!protobufList.isModifiable()) {
                this.extension_ = GeneratedMessageLite.K(protobufList);
            }
        }

        private void R1() {
            Internal.ProtobufList<ExtensionRange> protobufList = this.extensionRange_;
            if (!protobufList.isModifiable()) {
                this.extensionRange_ = GeneratedMessageLite.K(protobufList);
            }
        }

        private void S1() {
            Internal.ProtobufList<FieldDescriptorProto> protobufList = this.field_;
            if (!protobufList.isModifiable()) {
                this.field_ = GeneratedMessageLite.K(protobufList);
            }
        }

        private void T1() {
            Internal.ProtobufList<DescriptorProto> protobufList = this.nestedType_;
            if (!protobufList.isModifiable()) {
                this.nestedType_ = GeneratedMessageLite.K(protobufList);
            }
        }

        private void U1() {
            Internal.ProtobufList<OneofDescriptorProto> protobufList = this.oneofDecl_;
            if (!protobufList.isModifiable()) {
                this.oneofDecl_ = GeneratedMessageLite.K(protobufList);
            }
        }

        private void V1() {
            Internal.ProtobufList<String> protobufList = this.reservedName_;
            if (!protobufList.isModifiable()) {
                this.reservedName_ = GeneratedMessageLite.K(protobufList);
            }
        }

        private void W1() {
            Internal.ProtobufList<ReservedRange> protobufList = this.reservedRange_;
            if (!protobufList.isModifiable()) {
                this.reservedRange_ = GeneratedMessageLite.K(protobufList);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void X1(MessageOptions messageOptions) {
            messageOptions.getClass();
            MessageOptions messageOptions2 = this.options_;
            if (messageOptions2 != null && messageOptions2 != MessageOptions.getDefaultInstance()) {
                this.options_ = ((MessageOptions.Builder) MessageOptions.newBuilder(this.options_).mergeFrom((MessageOptions.Builder) messageOptions)).buildPartial();
            } else {
                this.options_ = messageOptions;
            }
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Y1(int i4) {
            P1();
            this.enumType_.remove(i4);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Z1(int i4) {
            Q1();
            this.extension_.remove(i4);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a2(int i4) {
            R1();
            this.extensionRange_.remove(i4);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b2(int i4) {
            S1();
            this.field_.remove(i4);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c2(int i4) {
            T1();
            this.nestedType_.remove(i4);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d2(int i4) {
            U1();
            this.oneofDecl_.remove(i4);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e2(int i4) {
            W1();
            this.reservedRange_.remove(i4);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void f2(int i4, EnumDescriptorProto enumDescriptorProto) {
            enumDescriptorProto.getClass();
            P1();
            this.enumType_.set(i4, enumDescriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g2(int i4, FieldDescriptorProto fieldDescriptorProto) {
            fieldDescriptorProto.getClass();
            Q1();
            this.extension_.set(i4, fieldDescriptorProto);
        }

        public static DescriptorProto getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void h1(Iterable<? extends EnumDescriptorProto> iterable) {
            P1();
            AbstractMessageLite.a(iterable, this.enumType_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void h2(int i4, ExtensionRange extensionRange) {
            extensionRange.getClass();
            R1();
            this.extensionRange_.set(i4, extensionRange);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void i1(Iterable<? extends FieldDescriptorProto> iterable) {
            Q1();
            AbstractMessageLite.a(iterable, this.extension_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void i2(int i4, FieldDescriptorProto fieldDescriptorProto) {
            fieldDescriptorProto.getClass();
            S1();
            this.field_.set(i4, fieldDescriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j1(Iterable<? extends ExtensionRange> iterable) {
            R1();
            AbstractMessageLite.a(iterable, this.extensionRange_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j2(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.name_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void k1(Iterable<? extends FieldDescriptorProto> iterable) {
            S1();
            AbstractMessageLite.a(iterable, this.field_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void k2(ByteString byteString) {
            this.name_ = byteString.toStringUtf8();
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void l1(Iterable<? extends DescriptorProto> iterable) {
            T1();
            AbstractMessageLite.a(iterable, this.nestedType_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void l2(int i4, DescriptorProto descriptorProto) {
            descriptorProto.getClass();
            T1();
            this.nestedType_.set(i4, descriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void m1(Iterable<? extends OneofDescriptorProto> iterable) {
            U1();
            AbstractMessageLite.a(iterable, this.oneofDecl_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void m2(int i4, OneofDescriptorProto oneofDescriptorProto) {
            oneofDescriptorProto.getClass();
            U1();
            this.oneofDecl_.set(i4, oneofDescriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n1(Iterable<String> iterable) {
            V1();
            AbstractMessageLite.a(iterable, this.reservedName_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n2(MessageOptions messageOptions) {
            messageOptions.getClass();
            this.options_ = messageOptions;
            this.bitField0_ |= 2;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.q();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void o1(Iterable<? extends ReservedRange> iterable) {
            W1();
            AbstractMessageLite.a(iterable, this.reservedRange_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void o2(int i4, String str) {
            str.getClass();
            V1();
            this.reservedName_.set(i4, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void p1(int i4, EnumDescriptorProto enumDescriptorProto) {
            enumDescriptorProto.getClass();
            P1();
            this.enumType_.add(i4, enumDescriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void p2(int i4, ReservedRange reservedRange) {
            reservedRange.getClass();
            W1();
            this.reservedRange_.set(i4, reservedRange);
        }

        public static DescriptorProto parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (DescriptorProto) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
        }

        public static DescriptorProto parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (DescriptorProto) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<DescriptorProto> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void q1(EnumDescriptorProto enumDescriptorProto) {
            enumDescriptorProto.getClass();
            P1();
            this.enumType_.add(enumDescriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void r1(int i4, FieldDescriptorProto fieldDescriptorProto) {
            fieldDescriptorProto.getClass();
            Q1();
            this.extension_.add(i4, fieldDescriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s1(FieldDescriptorProto fieldDescriptorProto) {
            fieldDescriptorProto.getClass();
            Q1();
            this.extension_.add(fieldDescriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void t1(int i4, ExtensionRange extensionRange) {
            extensionRange.getClass();
            R1();
            this.extensionRange_.add(i4, extensionRange);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void u1(ExtensionRange extensionRange) {
            extensionRange.getClass();
            R1();
            this.extensionRange_.add(extensionRange);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void v1(int i4, FieldDescriptorProto fieldDescriptorProto) {
            fieldDescriptorProto.getClass();
            S1();
            this.field_.add(i4, fieldDescriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void w1(FieldDescriptorProto fieldDescriptorProto) {
            fieldDescriptorProto.getClass();
            S1();
            this.field_.add(fieldDescriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void x1(int i4, DescriptorProto descriptorProto) {
            descriptorProto.getClass();
            T1();
            this.nestedType_.add(i4, descriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void y1(DescriptorProto descriptorProto) {
            descriptorProto.getClass();
            T1();
            this.nestedType_.add(descriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void z1(int i4, OneofDescriptorProto oneofDescriptorProto) {
            oneofDescriptorProto.getClass();
            U1();
            this.oneofDecl_.add(i4, oneofDescriptorProto);
        }

        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public EnumDescriptorProto getEnumType(int i4) {
            return this.enumType_.get(i4);
        }

        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public int getEnumTypeCount() {
            return this.enumType_.size();
        }

        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public List<EnumDescriptorProto> getEnumTypeList() {
            return this.enumType_;
        }

        public EnumDescriptorProtoOrBuilder getEnumTypeOrBuilder(int i4) {
            return this.enumType_.get(i4);
        }

        public List<? extends EnumDescriptorProtoOrBuilder> getEnumTypeOrBuilderList() {
            return this.enumType_;
        }

        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public FieldDescriptorProto getExtension(int i4) {
            return this.extension_.get(i4);
        }

        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public int getExtensionCount() {
            return this.extension_.size();
        }

        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public List<FieldDescriptorProto> getExtensionList() {
            return this.extension_;
        }

        public FieldDescriptorProtoOrBuilder getExtensionOrBuilder(int i4) {
            return this.extension_.get(i4);
        }

        public List<? extends FieldDescriptorProtoOrBuilder> getExtensionOrBuilderList() {
            return this.extension_;
        }

        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public ExtensionRange getExtensionRange(int i4) {
            return this.extensionRange_.get(i4);
        }

        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public int getExtensionRangeCount() {
            return this.extensionRange_.size();
        }

        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public List<ExtensionRange> getExtensionRangeList() {
            return this.extensionRange_;
        }

        public ExtensionRangeOrBuilder getExtensionRangeOrBuilder(int i4) {
            return this.extensionRange_.get(i4);
        }

        public List<? extends ExtensionRangeOrBuilder> getExtensionRangeOrBuilderList() {
            return this.extensionRange_;
        }

        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public FieldDescriptorProto getField(int i4) {
            return this.field_.get(i4);
        }

        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public int getFieldCount() {
            return this.field_.size();
        }

        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public List<FieldDescriptorProto> getFieldList() {
            return this.field_;
        }

        public FieldDescriptorProtoOrBuilder getFieldOrBuilder(int i4) {
            return this.field_.get(i4);
        }

        public List<? extends FieldDescriptorProtoOrBuilder> getFieldOrBuilderList() {
            return this.field_;
        }

        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public String getName() {
            return this.name_;
        }

        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public ByteString getNameBytes() {
            return ByteString.copyFromUtf8(this.name_);
        }

        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public DescriptorProto getNestedType(int i4) {
            return this.nestedType_.get(i4);
        }

        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public int getNestedTypeCount() {
            return this.nestedType_.size();
        }

        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public List<DescriptorProto> getNestedTypeList() {
            return this.nestedType_;
        }

        public DescriptorProtoOrBuilder getNestedTypeOrBuilder(int i4) {
            return this.nestedType_.get(i4);
        }

        public List<? extends DescriptorProtoOrBuilder> getNestedTypeOrBuilderList() {
            return this.nestedType_;
        }

        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public OneofDescriptorProto getOneofDecl(int i4) {
            return this.oneofDecl_.get(i4);
        }

        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public int getOneofDeclCount() {
            return this.oneofDecl_.size();
        }

        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public List<OneofDescriptorProto> getOneofDeclList() {
            return this.oneofDecl_;
        }

        public OneofDescriptorProtoOrBuilder getOneofDeclOrBuilder(int i4) {
            return this.oneofDecl_.get(i4);
        }

        public List<? extends OneofDescriptorProtoOrBuilder> getOneofDeclOrBuilderList() {
            return this.oneofDecl_;
        }

        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public MessageOptions getOptions() {
            MessageOptions messageOptions = this.options_;
            if (messageOptions == null) {
                return MessageOptions.getDefaultInstance();
            }
            return messageOptions;
        }

        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public String getReservedName(int i4) {
            return this.reservedName_.get(i4);
        }

        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public ByteString getReservedNameBytes(int i4) {
            return ByteString.copyFromUtf8(this.reservedName_.get(i4));
        }

        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public int getReservedNameCount() {
            return this.reservedName_.size();
        }

        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public List<String> getReservedNameList() {
            return this.reservedName_;
        }

        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public ReservedRange getReservedRange(int i4) {
            return this.reservedRange_.get(i4);
        }

        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public int getReservedRangeCount() {
            return this.reservedRange_.size();
        }

        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public List<ReservedRange> getReservedRangeList() {
            return this.reservedRange_;
        }

        public ReservedRangeOrBuilder getReservedRangeOrBuilder(int i4) {
            return this.reservedRange_.get(i4);
        }

        public List<? extends ReservedRangeOrBuilder> getReservedRangeOrBuilderList() {
            return this.reservedRange_;
        }

        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public boolean hasName() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public boolean hasOptions() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            int i4 = 1;
            switch (AnonymousClass1.f33300a[methodToInvoke.ordinal()]) {
                case 1:
                    return new DescriptorProto();
                case 2:
                    return new Builder(null);
                case 3:
                    return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0001\n\u0000\u0001\u0001\n\n\u0000\b\u0007\u0001ဈ\u0000\u0002Л\u0003Л\u0004Л\u0005Л\u0006Л\u0007ᐉ\u0001\bЛ\t\u001b\n\u001a", new Object[]{"bitField0_", "name_", "field_", FieldDescriptorProto.class, "nestedType_", DescriptorProto.class, "enumType_", EnumDescriptorProto.class, "extensionRange_", ExtensionRange.class, "extension_", FieldDescriptorProto.class, "options_", "oneofDecl_", OneofDescriptorProto.class, "reservedRange_", ReservedRange.class, "reservedName_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<DescriptorProto> parser = PARSER;
                    if (parser == null) {
                        synchronized (DescriptorProto.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case 6:
                    return Byte.valueOf(this.memoizedIsInitialized);
                case 7:
                    if (obj == null) {
                        i4 = 0;
                    }
                    this.memoizedIsInitialized = (byte) i4;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static Builder newBuilder(DescriptorProto descriptorProto) {
            return DEFAULT_INSTANCE.r(descriptorProto);
        }

        public static DescriptorProto parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (DescriptorProto) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static DescriptorProto parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (DescriptorProto) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static DescriptorProto parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (DescriptorProto) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
        }

        public static DescriptorProto parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (DescriptorProto) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static DescriptorProto parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (DescriptorProto) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
        }

        public static DescriptorProto parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (DescriptorProto) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static DescriptorProto parseFrom(InputStream inputStream) throws IOException {
            return (DescriptorProto) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
        }

        public static DescriptorProto parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (DescriptorProto) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static DescriptorProto parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (DescriptorProto) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
        }

        public static DescriptorProto parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (DescriptorProto) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: classes6.dex */
    public interface DescriptorProtoOrBuilder extends MessageLiteOrBuilder {
        EnumDescriptorProto getEnumType(int i4);

        int getEnumTypeCount();

        List<EnumDescriptorProto> getEnumTypeList();

        FieldDescriptorProto getExtension(int i4);

        int getExtensionCount();

        List<FieldDescriptorProto> getExtensionList();

        DescriptorProto.ExtensionRange getExtensionRange(int i4);

        int getExtensionRangeCount();

        List<DescriptorProto.ExtensionRange> getExtensionRangeList();

        FieldDescriptorProto getField(int i4);

        int getFieldCount();

        List<FieldDescriptorProto> getFieldList();

        String getName();

        ByteString getNameBytes();

        DescriptorProto getNestedType(int i4);

        int getNestedTypeCount();

        List<DescriptorProto> getNestedTypeList();

        OneofDescriptorProto getOneofDecl(int i4);

        int getOneofDeclCount();

        List<OneofDescriptorProto> getOneofDeclList();

        MessageOptions getOptions();

        String getReservedName(int i4);

        ByteString getReservedNameBytes(int i4);

        int getReservedNameCount();

        List<String> getReservedNameList();

        DescriptorProto.ReservedRange getReservedRange(int i4);

        int getReservedRangeCount();

        List<DescriptorProto.ReservedRange> getReservedRangeList();

        boolean hasName();

        boolean hasOptions();
    }

    /* loaded from: classes6.dex */
    public static final class EnumDescriptorProto extends GeneratedMessageLite<EnumDescriptorProto, Builder> implements EnumDescriptorProtoOrBuilder {
        private static final EnumDescriptorProto DEFAULT_INSTANCE;
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int OPTIONS_FIELD_NUMBER = 3;
        private static volatile Parser<EnumDescriptorProto> PARSER = null;
        public static final int RESERVED_NAME_FIELD_NUMBER = 5;
        public static final int RESERVED_RANGE_FIELD_NUMBER = 4;
        public static final int VALUE_FIELD_NUMBER = 2;
        private int bitField0_;
        private EnumOptions options_;
        private byte memoizedIsInitialized = 2;
        private String name_ = "";
        private Internal.ProtobufList<EnumValueDescriptorProto> value_ = GeneratedMessageLite.y();
        private Internal.ProtobufList<EnumReservedRange> reservedRange_ = GeneratedMessageLite.y();
        private Internal.ProtobufList<String> reservedName_ = GeneratedMessageLite.y();

        /* loaded from: classes6.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<EnumDescriptorProto, Builder> implements EnumDescriptorProtoOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder addAllReservedName(Iterable<String> iterable) {
                f();
                ((EnumDescriptorProto) this.f33398b).D0(iterable);
                return this;
            }

            public Builder addAllReservedRange(Iterable<? extends EnumReservedRange> iterable) {
                f();
                ((EnumDescriptorProto) this.f33398b).E0(iterable);
                return this;
            }

            public Builder addAllValue(Iterable<? extends EnumValueDescriptorProto> iterable) {
                f();
                ((EnumDescriptorProto) this.f33398b).F0(iterable);
                return this;
            }

            public Builder addReservedName(String str) {
                f();
                ((EnumDescriptorProto) this.f33398b).G0(str);
                return this;
            }

            public Builder addReservedNameBytes(ByteString byteString) {
                f();
                ((EnumDescriptorProto) this.f33398b).H0(byteString);
                return this;
            }

            public Builder addReservedRange(EnumReservedRange enumReservedRange) {
                f();
                ((EnumDescriptorProto) this.f33398b).J0(enumReservedRange);
                return this;
            }

            public Builder addValue(EnumValueDescriptorProto enumValueDescriptorProto) {
                f();
                ((EnumDescriptorProto) this.f33398b).L0(enumValueDescriptorProto);
                return this;
            }

            public Builder clearName() {
                f();
                ((EnumDescriptorProto) this.f33398b).M0();
                return this;
            }

            public Builder clearOptions() {
                f();
                ((EnumDescriptorProto) this.f33398b).N0();
                return this;
            }

            public Builder clearReservedName() {
                f();
                ((EnumDescriptorProto) this.f33398b).O0();
                return this;
            }

            public Builder clearReservedRange() {
                f();
                ((EnumDescriptorProto) this.f33398b).P0();
                return this;
            }

            public Builder clearValue() {
                f();
                ((EnumDescriptorProto) this.f33398b).Q0();
                return this;
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
            public String getName() {
                return ((EnumDescriptorProto) this.f33398b).getName();
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
            public ByteString getNameBytes() {
                return ((EnumDescriptorProto) this.f33398b).getNameBytes();
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
            public EnumOptions getOptions() {
                return ((EnumDescriptorProto) this.f33398b).getOptions();
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
            public String getReservedName(int i4) {
                return ((EnumDescriptorProto) this.f33398b).getReservedName(i4);
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
            public ByteString getReservedNameBytes(int i4) {
                return ((EnumDescriptorProto) this.f33398b).getReservedNameBytes(i4);
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
            public int getReservedNameCount() {
                return ((EnumDescriptorProto) this.f33398b).getReservedNameCount();
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
            public List<String> getReservedNameList() {
                return Collections.unmodifiableList(((EnumDescriptorProto) this.f33398b).getReservedNameList());
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
            public EnumReservedRange getReservedRange(int i4) {
                return ((EnumDescriptorProto) this.f33398b).getReservedRange(i4);
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
            public int getReservedRangeCount() {
                return ((EnumDescriptorProto) this.f33398b).getReservedRangeCount();
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
            public List<EnumReservedRange> getReservedRangeList() {
                return Collections.unmodifiableList(((EnumDescriptorProto) this.f33398b).getReservedRangeList());
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
            public EnumValueDescriptorProto getValue(int i4) {
                return ((EnumDescriptorProto) this.f33398b).getValue(i4);
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
            public int getValueCount() {
                return ((EnumDescriptorProto) this.f33398b).getValueCount();
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
            public List<EnumValueDescriptorProto> getValueList() {
                return Collections.unmodifiableList(((EnumDescriptorProto) this.f33398b).getValueList());
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
            public boolean hasName() {
                return ((EnumDescriptorProto) this.f33398b).hasName();
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
            public boolean hasOptions() {
                return ((EnumDescriptorProto) this.f33398b).hasOptions();
            }

            public Builder mergeOptions(EnumOptions enumOptions) {
                f();
                ((EnumDescriptorProto) this.f33398b).U0(enumOptions);
                return this;
            }

            public Builder removeReservedRange(int i4) {
                f();
                ((EnumDescriptorProto) this.f33398b).V0(i4);
                return this;
            }

            public Builder removeValue(int i4) {
                f();
                ((EnumDescriptorProto) this.f33398b).W0(i4);
                return this;
            }

            public Builder setName(String str) {
                f();
                ((EnumDescriptorProto) this.f33398b).X0(str);
                return this;
            }

            public Builder setNameBytes(ByteString byteString) {
                f();
                ((EnumDescriptorProto) this.f33398b).Y0(byteString);
                return this;
            }

            public Builder setOptions(EnumOptions enumOptions) {
                f();
                ((EnumDescriptorProto) this.f33398b).Z0(enumOptions);
                return this;
            }

            public Builder setReservedName(int i4, String str) {
                f();
                ((EnumDescriptorProto) this.f33398b).a1(i4, str);
                return this;
            }

            public Builder setReservedRange(int i4, EnumReservedRange enumReservedRange) {
                f();
                ((EnumDescriptorProto) this.f33398b).b1(i4, enumReservedRange);
                return this;
            }

            public Builder setValue(int i4, EnumValueDescriptorProto enumValueDescriptorProto) {
                f();
                ((EnumDescriptorProto) this.f33398b).c1(i4, enumValueDescriptorProto);
                return this;
            }

            private Builder() {
                super(EnumDescriptorProto.DEFAULT_INSTANCE);
            }

            public Builder addReservedRange(int i4, EnumReservedRange enumReservedRange) {
                f();
                ((EnumDescriptorProto) this.f33398b).I0(i4, enumReservedRange);
                return this;
            }

            public Builder addValue(int i4, EnumValueDescriptorProto enumValueDescriptorProto) {
                f();
                ((EnumDescriptorProto) this.f33398b).K0(i4, enumValueDescriptorProto);
                return this;
            }

            public Builder setOptions(EnumOptions.Builder builder) {
                f();
                ((EnumDescriptorProto) this.f33398b).Z0((EnumOptions) builder.build());
                return this;
            }

            public Builder setReservedRange(int i4, EnumReservedRange.Builder builder) {
                f();
                ((EnumDescriptorProto) this.f33398b).b1(i4, builder.build());
                return this;
            }

            public Builder setValue(int i4, EnumValueDescriptorProto.Builder builder) {
                f();
                ((EnumDescriptorProto) this.f33398b).c1(i4, builder.build());
                return this;
            }

            public Builder addReservedRange(EnumReservedRange.Builder builder) {
                f();
                ((EnumDescriptorProto) this.f33398b).J0(builder.build());
                return this;
            }

            public Builder addValue(EnumValueDescriptorProto.Builder builder) {
                f();
                ((EnumDescriptorProto) this.f33398b).L0(builder.build());
                return this;
            }

            public Builder addReservedRange(int i4, EnumReservedRange.Builder builder) {
                f();
                ((EnumDescriptorProto) this.f33398b).I0(i4, builder.build());
                return this;
            }

            public Builder addValue(int i4, EnumValueDescriptorProto.Builder builder) {
                f();
                ((EnumDescriptorProto) this.f33398b).K0(i4, builder.build());
                return this;
            }
        }

        /* loaded from: classes6.dex */
        public static final class EnumReservedRange extends GeneratedMessageLite<EnumReservedRange, Builder> implements EnumReservedRangeOrBuilder {
            private static final EnumReservedRange DEFAULT_INSTANCE;
            public static final int END_FIELD_NUMBER = 2;
            private static volatile Parser<EnumReservedRange> PARSER = null;
            public static final int START_FIELD_NUMBER = 1;
            private int bitField0_;
            private int end_;
            private int start_;

            /* loaded from: classes6.dex */
            public static final class Builder extends GeneratedMessageLite.Builder<EnumReservedRange, Builder> implements EnumReservedRangeOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                public Builder clearEnd() {
                    f();
                    ((EnumReservedRange) this.f33398b).k0();
                    return this;
                }

                public Builder clearStart() {
                    f();
                    ((EnumReservedRange) this.f33398b).l0();
                    return this;
                }

                @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProto.EnumReservedRangeOrBuilder
                public int getEnd() {
                    return ((EnumReservedRange) this.f33398b).getEnd();
                }

                @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProto.EnumReservedRangeOrBuilder
                public int getStart() {
                    return ((EnumReservedRange) this.f33398b).getStart();
                }

                @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProto.EnumReservedRangeOrBuilder
                public boolean hasEnd() {
                    return ((EnumReservedRange) this.f33398b).hasEnd();
                }

                @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProto.EnumReservedRangeOrBuilder
                public boolean hasStart() {
                    return ((EnumReservedRange) this.f33398b).hasStart();
                }

                public Builder setEnd(int i4) {
                    f();
                    ((EnumReservedRange) this.f33398b).m0(i4);
                    return this;
                }

                public Builder setStart(int i4) {
                    f();
                    ((EnumReservedRange) this.f33398b).n0(i4);
                    return this;
                }

                private Builder() {
                    super(EnumReservedRange.DEFAULT_INSTANCE);
                }
            }

            static {
                EnumReservedRange enumReservedRange = new EnumReservedRange();
                DEFAULT_INSTANCE = enumReservedRange;
                GeneratedMessageLite.d0(EnumReservedRange.class, enumReservedRange);
            }

            private EnumReservedRange() {
            }

            public static EnumReservedRange getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void k0() {
                this.bitField0_ &= -3;
                this.end_ = 0;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void l0() {
                this.bitField0_ &= -2;
                this.start_ = 0;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void m0(int i4) {
                this.bitField0_ |= 2;
                this.end_ = i4;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void n0(int i4) {
                this.bitField0_ |= 1;
                this.start_ = i4;
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.q();
            }

            public static EnumReservedRange parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (EnumReservedRange) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
            }

            public static EnumReservedRange parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return (EnumReservedRange) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
            }

            public static Parser<EnumReservedRange> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProto.EnumReservedRangeOrBuilder
            public int getEnd() {
                return this.end_;
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProto.EnumReservedRangeOrBuilder
            public int getStart() {
                return this.start_;
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProto.EnumReservedRangeOrBuilder
            public boolean hasEnd() {
                if ((this.bitField0_ & 2) != 0) {
                    return true;
                }
                return false;
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProto.EnumReservedRangeOrBuilder
            public boolean hasStart() {
                if ((this.bitField0_ & 1) != 0) {
                    return true;
                }
                return false;
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                switch (AnonymousClass1.f33300a[methodToInvoke.ordinal()]) {
                    case 1:
                        return new EnumReservedRange();
                    case 2:
                        return new Builder(null);
                    case 3:
                        return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001", new Object[]{"bitField0_", "start_", "end_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<EnumReservedRange> parser = PARSER;
                        if (parser == null) {
                            synchronized (EnumReservedRange.class) {
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

            public static Builder newBuilder(EnumReservedRange enumReservedRange) {
                return DEFAULT_INSTANCE.r(enumReservedRange);
            }

            public static EnumReservedRange parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (EnumReservedRange) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static EnumReservedRange parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (EnumReservedRange) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static EnumReservedRange parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (EnumReservedRange) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
            }

            public static EnumReservedRange parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (EnumReservedRange) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static EnumReservedRange parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (EnumReservedRange) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
            }

            public static EnumReservedRange parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (EnumReservedRange) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static EnumReservedRange parseFrom(InputStream inputStream) throws IOException {
                return (EnumReservedRange) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
            }

            public static EnumReservedRange parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (EnumReservedRange) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static EnumReservedRange parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (EnumReservedRange) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
            }

            public static EnumReservedRange parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (EnumReservedRange) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }
        }

        /* loaded from: classes6.dex */
        public interface EnumReservedRangeOrBuilder extends MessageLiteOrBuilder {
            int getEnd();

            int getStart();

            boolean hasEnd();

            boolean hasStart();
        }

        static {
            EnumDescriptorProto enumDescriptorProto = new EnumDescriptorProto();
            DEFAULT_INSTANCE = enumDescriptorProto;
            GeneratedMessageLite.d0(EnumDescriptorProto.class, enumDescriptorProto);
        }

        private EnumDescriptorProto() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void D0(Iterable<String> iterable) {
            R0();
            AbstractMessageLite.a(iterable, this.reservedName_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void E0(Iterable<? extends EnumReservedRange> iterable) {
            S0();
            AbstractMessageLite.a(iterable, this.reservedRange_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void F0(Iterable<? extends EnumValueDescriptorProto> iterable) {
            T0();
            AbstractMessageLite.a(iterable, this.value_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void G0(String str) {
            str.getClass();
            R0();
            this.reservedName_.add(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void H0(ByteString byteString) {
            R0();
            this.reservedName_.add(byteString.toStringUtf8());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void I0(int i4, EnumReservedRange enumReservedRange) {
            enumReservedRange.getClass();
            S0();
            this.reservedRange_.add(i4, enumReservedRange);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void J0(EnumReservedRange enumReservedRange) {
            enumReservedRange.getClass();
            S0();
            this.reservedRange_.add(enumReservedRange);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void K0(int i4, EnumValueDescriptorProto enumValueDescriptorProto) {
            enumValueDescriptorProto.getClass();
            T0();
            this.value_.add(i4, enumValueDescriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void L0(EnumValueDescriptorProto enumValueDescriptorProto) {
            enumValueDescriptorProto.getClass();
            T0();
            this.value_.add(enumValueDescriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void M0() {
            this.bitField0_ &= -2;
            this.name_ = getDefaultInstance().getName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void N0() {
            this.options_ = null;
            this.bitField0_ &= -3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void O0() {
            this.reservedName_ = GeneratedMessageLite.y();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void P0() {
            this.reservedRange_ = GeneratedMessageLite.y();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Q0() {
            this.value_ = GeneratedMessageLite.y();
        }

        private void R0() {
            Internal.ProtobufList<String> protobufList = this.reservedName_;
            if (!protobufList.isModifiable()) {
                this.reservedName_ = GeneratedMessageLite.K(protobufList);
            }
        }

        private void S0() {
            Internal.ProtobufList<EnumReservedRange> protobufList = this.reservedRange_;
            if (!protobufList.isModifiable()) {
                this.reservedRange_ = GeneratedMessageLite.K(protobufList);
            }
        }

        private void T0() {
            Internal.ProtobufList<EnumValueDescriptorProto> protobufList = this.value_;
            if (!protobufList.isModifiable()) {
                this.value_ = GeneratedMessageLite.K(protobufList);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void U0(EnumOptions enumOptions) {
            enumOptions.getClass();
            EnumOptions enumOptions2 = this.options_;
            if (enumOptions2 != null && enumOptions2 != EnumOptions.getDefaultInstance()) {
                this.options_ = ((EnumOptions.Builder) EnumOptions.newBuilder(this.options_).mergeFrom((EnumOptions.Builder) enumOptions)).buildPartial();
            } else {
                this.options_ = enumOptions;
            }
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void V0(int i4) {
            S0();
            this.reservedRange_.remove(i4);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void W0(int i4) {
            T0();
            this.value_.remove(i4);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void X0(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.name_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Y0(ByteString byteString) {
            this.name_ = byteString.toStringUtf8();
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Z0(EnumOptions enumOptions) {
            enumOptions.getClass();
            this.options_ = enumOptions;
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a1(int i4, String str) {
            str.getClass();
            R0();
            this.reservedName_.set(i4, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b1(int i4, EnumReservedRange enumReservedRange) {
            enumReservedRange.getClass();
            S0();
            this.reservedRange_.set(i4, enumReservedRange);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c1(int i4, EnumValueDescriptorProto enumValueDescriptorProto) {
            enumValueDescriptorProto.getClass();
            T0();
            this.value_.set(i4, enumValueDescriptorProto);
        }

        public static EnumDescriptorProto getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.q();
        }

        public static EnumDescriptorProto parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (EnumDescriptorProto) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
        }

        public static EnumDescriptorProto parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (EnumDescriptorProto) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<EnumDescriptorProto> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
        public String getName() {
            return this.name_;
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
        public ByteString getNameBytes() {
            return ByteString.copyFromUtf8(this.name_);
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
        public EnumOptions getOptions() {
            EnumOptions enumOptions = this.options_;
            if (enumOptions == null) {
                return EnumOptions.getDefaultInstance();
            }
            return enumOptions;
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
        public String getReservedName(int i4) {
            return this.reservedName_.get(i4);
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
        public ByteString getReservedNameBytes(int i4) {
            return ByteString.copyFromUtf8(this.reservedName_.get(i4));
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
        public int getReservedNameCount() {
            return this.reservedName_.size();
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
        public List<String> getReservedNameList() {
            return this.reservedName_;
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
        public EnumReservedRange getReservedRange(int i4) {
            return this.reservedRange_.get(i4);
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
        public int getReservedRangeCount() {
            return this.reservedRange_.size();
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
        public List<EnumReservedRange> getReservedRangeList() {
            return this.reservedRange_;
        }

        public EnumReservedRangeOrBuilder getReservedRangeOrBuilder(int i4) {
            return this.reservedRange_.get(i4);
        }

        public List<? extends EnumReservedRangeOrBuilder> getReservedRangeOrBuilderList() {
            return this.reservedRange_;
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
        public EnumValueDescriptorProto getValue(int i4) {
            return this.value_.get(i4);
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
        public int getValueCount() {
            return this.value_.size();
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
        public List<EnumValueDescriptorProto> getValueList() {
            return this.value_;
        }

        public EnumValueDescriptorProtoOrBuilder getValueOrBuilder(int i4) {
            return this.value_.get(i4);
        }

        public List<? extends EnumValueDescriptorProtoOrBuilder> getValueOrBuilderList() {
            return this.value_;
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
        public boolean hasName() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
        public boolean hasOptions() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            int i4 = 1;
            switch (AnonymousClass1.f33300a[methodToInvoke.ordinal()]) {
                case 1:
                    return new EnumDescriptorProto();
                case 2:
                    return new Builder(null);
                case 3:
                    return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0003\u0002\u0001ဈ\u0000\u0002Л\u0003ᐉ\u0001\u0004\u001b\u0005\u001a", new Object[]{"bitField0_", "name_", "value_", EnumValueDescriptorProto.class, "options_", "reservedRange_", EnumReservedRange.class, "reservedName_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<EnumDescriptorProto> parser = PARSER;
                    if (parser == null) {
                        synchronized (EnumDescriptorProto.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case 6:
                    return Byte.valueOf(this.memoizedIsInitialized);
                case 7:
                    if (obj == null) {
                        i4 = 0;
                    }
                    this.memoizedIsInitialized = (byte) i4;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static Builder newBuilder(EnumDescriptorProto enumDescriptorProto) {
            return DEFAULT_INSTANCE.r(enumDescriptorProto);
        }

        public static EnumDescriptorProto parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (EnumDescriptorProto) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static EnumDescriptorProto parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (EnumDescriptorProto) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static EnumDescriptorProto parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (EnumDescriptorProto) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
        }

        public static EnumDescriptorProto parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (EnumDescriptorProto) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static EnumDescriptorProto parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (EnumDescriptorProto) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
        }

        public static EnumDescriptorProto parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (EnumDescriptorProto) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static EnumDescriptorProto parseFrom(InputStream inputStream) throws IOException {
            return (EnumDescriptorProto) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
        }

        public static EnumDescriptorProto parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (EnumDescriptorProto) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static EnumDescriptorProto parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (EnumDescriptorProto) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
        }

        public static EnumDescriptorProto parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (EnumDescriptorProto) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: classes6.dex */
    public interface EnumDescriptorProtoOrBuilder extends MessageLiteOrBuilder {
        String getName();

        ByteString getNameBytes();

        EnumOptions getOptions();

        String getReservedName(int i4);

        ByteString getReservedNameBytes(int i4);

        int getReservedNameCount();

        List<String> getReservedNameList();

        EnumDescriptorProto.EnumReservedRange getReservedRange(int i4);

        int getReservedRangeCount();

        List<EnumDescriptorProto.EnumReservedRange> getReservedRangeList();

        EnumValueDescriptorProto getValue(int i4);

        int getValueCount();

        List<EnumValueDescriptorProto> getValueList();

        boolean hasName();

        boolean hasOptions();
    }

    /* loaded from: classes6.dex */
    public static final class EnumOptions extends GeneratedMessageLite.ExtendableMessage<EnumOptions, Builder> implements EnumOptionsOrBuilder {
        public static final int ALLOW_ALIAS_FIELD_NUMBER = 2;
        private static final EnumOptions DEFAULT_INSTANCE;
        public static final int DEPRECATED_FIELD_NUMBER = 3;
        private static volatile Parser<EnumOptions> PARSER = null;
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        private boolean allowAlias_;
        private int bitField0_;
        private boolean deprecated_;
        private byte memoizedIsInitialized = 2;
        private Internal.ProtobufList<UninterpretedOption> uninterpretedOption_ = GeneratedMessageLite.y();

        /* loaded from: classes6.dex */
        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<EnumOptions, Builder> implements EnumOptionsOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder addAllUninterpretedOption(Iterable<? extends UninterpretedOption> iterable) {
                f();
                ((EnumOptions) this.f33398b).s0(iterable);
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption uninterpretedOption) {
                f();
                ((EnumOptions) this.f33398b).u0(uninterpretedOption);
                return this;
            }

            public Builder clearAllowAlias() {
                f();
                ((EnumOptions) this.f33398b).v0();
                return this;
            }

            public Builder clearDeprecated() {
                f();
                ((EnumOptions) this.f33398b).w0();
                return this;
            }

            public Builder clearUninterpretedOption() {
                f();
                ((EnumOptions) this.f33398b).x0();
                return this;
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumOptionsOrBuilder
            public boolean getAllowAlias() {
                return ((EnumOptions) this.f33398b).getAllowAlias();
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumOptionsOrBuilder
            public boolean getDeprecated() {
                return ((EnumOptions) this.f33398b).getDeprecated();
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumOptionsOrBuilder
            public UninterpretedOption getUninterpretedOption(int i4) {
                return ((EnumOptions) this.f33398b).getUninterpretedOption(i4);
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumOptionsOrBuilder
            public int getUninterpretedOptionCount() {
                return ((EnumOptions) this.f33398b).getUninterpretedOptionCount();
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumOptionsOrBuilder
            public List<UninterpretedOption> getUninterpretedOptionList() {
                return Collections.unmodifiableList(((EnumOptions) this.f33398b).getUninterpretedOptionList());
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumOptionsOrBuilder
            public boolean hasAllowAlias() {
                return ((EnumOptions) this.f33398b).hasAllowAlias();
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumOptionsOrBuilder
            public boolean hasDeprecated() {
                return ((EnumOptions) this.f33398b).hasDeprecated();
            }

            public Builder removeUninterpretedOption(int i4) {
                f();
                ((EnumOptions) this.f33398b).z0(i4);
                return this;
            }

            public Builder setAllowAlias(boolean z3) {
                f();
                ((EnumOptions) this.f33398b).A0(z3);
                return this;
            }

            public Builder setDeprecated(boolean z3) {
                f();
                ((EnumOptions) this.f33398b).B0(z3);
                return this;
            }

            public Builder setUninterpretedOption(int i4, UninterpretedOption uninterpretedOption) {
                f();
                ((EnumOptions) this.f33398b).C0(i4, uninterpretedOption);
                return this;
            }

            private Builder() {
                super(EnumOptions.DEFAULT_INSTANCE);
            }

            public Builder addUninterpretedOption(int i4, UninterpretedOption uninterpretedOption) {
                f();
                ((EnumOptions) this.f33398b).t0(i4, uninterpretedOption);
                return this;
            }

            public Builder setUninterpretedOption(int i4, UninterpretedOption.Builder builder) {
                f();
                ((EnumOptions) this.f33398b).C0(i4, builder.build());
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption.Builder builder) {
                f();
                ((EnumOptions) this.f33398b).u0(builder.build());
                return this;
            }

            public Builder addUninterpretedOption(int i4, UninterpretedOption.Builder builder) {
                f();
                ((EnumOptions) this.f33398b).t0(i4, builder.build());
                return this;
            }
        }

        static {
            EnumOptions enumOptions = new EnumOptions();
            DEFAULT_INSTANCE = enumOptions;
            GeneratedMessageLite.d0(EnumOptions.class, enumOptions);
        }

        private EnumOptions() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void A0(boolean z3) {
            this.bitField0_ |= 1;
            this.allowAlias_ = z3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void B0(boolean z3) {
            this.bitField0_ |= 2;
            this.deprecated_ = z3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void C0(int i4, UninterpretedOption uninterpretedOption) {
            uninterpretedOption.getClass();
            y0();
            this.uninterpretedOption_.set(i4, uninterpretedOption);
        }

        public static EnumOptions getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.q();
        }

        public static EnumOptions parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (EnumOptions) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
        }

        public static EnumOptions parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (EnumOptions) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<EnumOptions> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s0(Iterable<? extends UninterpretedOption> iterable) {
            y0();
            AbstractMessageLite.a(iterable, this.uninterpretedOption_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void t0(int i4, UninterpretedOption uninterpretedOption) {
            uninterpretedOption.getClass();
            y0();
            this.uninterpretedOption_.add(i4, uninterpretedOption);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void u0(UninterpretedOption uninterpretedOption) {
            uninterpretedOption.getClass();
            y0();
            this.uninterpretedOption_.add(uninterpretedOption);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void v0() {
            this.bitField0_ &= -2;
            this.allowAlias_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void w0() {
            this.bitField0_ &= -3;
            this.deprecated_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void x0() {
            this.uninterpretedOption_ = GeneratedMessageLite.y();
        }

        private void y0() {
            Internal.ProtobufList<UninterpretedOption> protobufList = this.uninterpretedOption_;
            if (!protobufList.isModifiable()) {
                this.uninterpretedOption_ = GeneratedMessageLite.K(protobufList);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void z0(int i4) {
            y0();
            this.uninterpretedOption_.remove(i4);
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumOptionsOrBuilder
        public boolean getAllowAlias() {
            return this.allowAlias_;
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumOptionsOrBuilder
        public boolean getDeprecated() {
            return this.deprecated_;
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumOptionsOrBuilder
        public UninterpretedOption getUninterpretedOption(int i4) {
            return this.uninterpretedOption_.get(i4);
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumOptionsOrBuilder
        public int getUninterpretedOptionCount() {
            return this.uninterpretedOption_.size();
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumOptionsOrBuilder
        public List<UninterpretedOption> getUninterpretedOptionList() {
            return this.uninterpretedOption_;
        }

        public UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int i4) {
            return this.uninterpretedOption_.get(i4);
        }

        public List<? extends UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList() {
            return this.uninterpretedOption_;
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumOptionsOrBuilder
        public boolean hasAllowAlias() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumOptionsOrBuilder
        public boolean hasDeprecated() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            int i4 = 1;
            switch (AnonymousClass1.f33300a[methodToInvoke.ordinal()]) {
                case 1:
                    return new EnumOptions();
                case 2:
                    return new Builder(null);
                case 3:
                    return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0002ϧ\u0003\u0000\u0001\u0001\u0002ဇ\u0000\u0003ဇ\u0001ϧЛ", new Object[]{"bitField0_", "allowAlias_", "deprecated_", "uninterpretedOption_", UninterpretedOption.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<EnumOptions> parser = PARSER;
                    if (parser == null) {
                        synchronized (EnumOptions.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case 6:
                    return Byte.valueOf(this.memoizedIsInitialized);
                case 7:
                    if (obj == null) {
                        i4 = 0;
                    }
                    this.memoizedIsInitialized = (byte) i4;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static Builder newBuilder(EnumOptions enumOptions) {
            return (Builder) DEFAULT_INSTANCE.r(enumOptions);
        }

        public static EnumOptions parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (EnumOptions) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static EnumOptions parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (EnumOptions) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static EnumOptions parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (EnumOptions) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
        }

        public static EnumOptions parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (EnumOptions) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static EnumOptions parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (EnumOptions) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
        }

        public static EnumOptions parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (EnumOptions) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static EnumOptions parseFrom(InputStream inputStream) throws IOException {
            return (EnumOptions) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
        }

        public static EnumOptions parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (EnumOptions) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static EnumOptions parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (EnumOptions) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
        }

        public static EnumOptions parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (EnumOptions) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: classes6.dex */
    public interface EnumOptionsOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<EnumOptions, EnumOptions.Builder> {
        boolean getAllowAlias();

        boolean getDeprecated();

        UninterpretedOption getUninterpretedOption(int i4);

        int getUninterpretedOptionCount();

        List<UninterpretedOption> getUninterpretedOptionList();

        boolean hasAllowAlias();

        boolean hasDeprecated();
    }

    /* loaded from: classes6.dex */
    public static final class EnumValueDescriptorProto extends GeneratedMessageLite<EnumValueDescriptorProto, Builder> implements EnumValueDescriptorProtoOrBuilder {
        private static final EnumValueDescriptorProto DEFAULT_INSTANCE;
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int NUMBER_FIELD_NUMBER = 2;
        public static final int OPTIONS_FIELD_NUMBER = 3;
        private static volatile Parser<EnumValueDescriptorProto> PARSER;
        private int bitField0_;
        private byte memoizedIsInitialized = 2;
        private String name_ = "";
        private int number_;
        private EnumValueOptions options_;

        /* loaded from: classes6.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<EnumValueDescriptorProto, Builder> implements EnumValueDescriptorProtoOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearName() {
                f();
                ((EnumValueDescriptorProto) this.f33398b).o0();
                return this;
            }

            public Builder clearNumber() {
                f();
                ((EnumValueDescriptorProto) this.f33398b).p0();
                return this;
            }

            public Builder clearOptions() {
                f();
                ((EnumValueDescriptorProto) this.f33398b).q0();
                return this;
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumValueDescriptorProtoOrBuilder
            public String getName() {
                return ((EnumValueDescriptorProto) this.f33398b).getName();
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumValueDescriptorProtoOrBuilder
            public ByteString getNameBytes() {
                return ((EnumValueDescriptorProto) this.f33398b).getNameBytes();
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumValueDescriptorProtoOrBuilder
            public int getNumber() {
                return ((EnumValueDescriptorProto) this.f33398b).getNumber();
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumValueDescriptorProtoOrBuilder
            public EnumValueOptions getOptions() {
                return ((EnumValueDescriptorProto) this.f33398b).getOptions();
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumValueDescriptorProtoOrBuilder
            public boolean hasName() {
                return ((EnumValueDescriptorProto) this.f33398b).hasName();
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumValueDescriptorProtoOrBuilder
            public boolean hasNumber() {
                return ((EnumValueDescriptorProto) this.f33398b).hasNumber();
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumValueDescriptorProtoOrBuilder
            public boolean hasOptions() {
                return ((EnumValueDescriptorProto) this.f33398b).hasOptions();
            }

            public Builder mergeOptions(EnumValueOptions enumValueOptions) {
                f();
                ((EnumValueDescriptorProto) this.f33398b).r0(enumValueOptions);
                return this;
            }

            public Builder setName(String str) {
                f();
                ((EnumValueDescriptorProto) this.f33398b).s0(str);
                return this;
            }

            public Builder setNameBytes(ByteString byteString) {
                f();
                ((EnumValueDescriptorProto) this.f33398b).t0(byteString);
                return this;
            }

            public Builder setNumber(int i4) {
                f();
                ((EnumValueDescriptorProto) this.f33398b).u0(i4);
                return this;
            }

            public Builder setOptions(EnumValueOptions enumValueOptions) {
                f();
                ((EnumValueDescriptorProto) this.f33398b).v0(enumValueOptions);
                return this;
            }

            private Builder() {
                super(EnumValueDescriptorProto.DEFAULT_INSTANCE);
            }

            public Builder setOptions(EnumValueOptions.Builder builder) {
                f();
                ((EnumValueDescriptorProto) this.f33398b).v0((EnumValueOptions) builder.build());
                return this;
            }
        }

        static {
            EnumValueDescriptorProto enumValueDescriptorProto = new EnumValueDescriptorProto();
            DEFAULT_INSTANCE = enumValueDescriptorProto;
            GeneratedMessageLite.d0(EnumValueDescriptorProto.class, enumValueDescriptorProto);
        }

        private EnumValueDescriptorProto() {
        }

        public static EnumValueDescriptorProto getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.q();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void o0() {
            this.bitField0_ &= -2;
            this.name_ = getDefaultInstance().getName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void p0() {
            this.bitField0_ &= -3;
            this.number_ = 0;
        }

        public static EnumValueDescriptorProto parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (EnumValueDescriptorProto) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
        }

        public static EnumValueDescriptorProto parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (EnumValueDescriptorProto) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<EnumValueDescriptorProto> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void q0() {
            this.options_ = null;
            this.bitField0_ &= -5;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void r0(EnumValueOptions enumValueOptions) {
            enumValueOptions.getClass();
            EnumValueOptions enumValueOptions2 = this.options_;
            if (enumValueOptions2 != null && enumValueOptions2 != EnumValueOptions.getDefaultInstance()) {
                this.options_ = ((EnumValueOptions.Builder) EnumValueOptions.newBuilder(this.options_).mergeFrom((EnumValueOptions.Builder) enumValueOptions)).buildPartial();
            } else {
                this.options_ = enumValueOptions;
            }
            this.bitField0_ |= 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s0(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.name_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void t0(ByteString byteString) {
            this.name_ = byteString.toStringUtf8();
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void u0(int i4) {
            this.bitField0_ |= 2;
            this.number_ = i4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void v0(EnumValueOptions enumValueOptions) {
            enumValueOptions.getClass();
            this.options_ = enumValueOptions;
            this.bitField0_ |= 4;
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumValueDescriptorProtoOrBuilder
        public String getName() {
            return this.name_;
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumValueDescriptorProtoOrBuilder
        public ByteString getNameBytes() {
            return ByteString.copyFromUtf8(this.name_);
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumValueDescriptorProtoOrBuilder
        public int getNumber() {
            return this.number_;
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumValueDescriptorProtoOrBuilder
        public EnumValueOptions getOptions() {
            EnumValueOptions enumValueOptions = this.options_;
            if (enumValueOptions == null) {
                return EnumValueOptions.getDefaultInstance();
            }
            return enumValueOptions;
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumValueDescriptorProtoOrBuilder
        public boolean hasName() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumValueDescriptorProtoOrBuilder
        public boolean hasNumber() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumValueDescriptorProtoOrBuilder
        public boolean hasOptions() {
            if ((this.bitField0_ & 4) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            int i4 = 1;
            switch (AnonymousClass1.f33300a[methodToInvoke.ordinal()]) {
                case 1:
                    return new EnumValueDescriptorProto();
                case 2:
                    return new Builder(null);
                case 3:
                    return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0001\u0001ဈ\u0000\u0002င\u0001\u0003ᐉ\u0002", new Object[]{"bitField0_", "name_", "number_", "options_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<EnumValueDescriptorProto> parser = PARSER;
                    if (parser == null) {
                        synchronized (EnumValueDescriptorProto.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case 6:
                    return Byte.valueOf(this.memoizedIsInitialized);
                case 7:
                    if (obj == null) {
                        i4 = 0;
                    }
                    this.memoizedIsInitialized = (byte) i4;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static Builder newBuilder(EnumValueDescriptorProto enumValueDescriptorProto) {
            return DEFAULT_INSTANCE.r(enumValueDescriptorProto);
        }

        public static EnumValueDescriptorProto parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (EnumValueDescriptorProto) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static EnumValueDescriptorProto parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (EnumValueDescriptorProto) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static EnumValueDescriptorProto parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (EnumValueDescriptorProto) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
        }

        public static EnumValueDescriptorProto parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (EnumValueDescriptorProto) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static EnumValueDescriptorProto parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (EnumValueDescriptorProto) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
        }

        public static EnumValueDescriptorProto parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (EnumValueDescriptorProto) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static EnumValueDescriptorProto parseFrom(InputStream inputStream) throws IOException {
            return (EnumValueDescriptorProto) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
        }

        public static EnumValueDescriptorProto parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (EnumValueDescriptorProto) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static EnumValueDescriptorProto parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (EnumValueDescriptorProto) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
        }

        public static EnumValueDescriptorProto parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (EnumValueDescriptorProto) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: classes6.dex */
    public interface EnumValueDescriptorProtoOrBuilder extends MessageLiteOrBuilder {
        String getName();

        ByteString getNameBytes();

        int getNumber();

        EnumValueOptions getOptions();

        boolean hasName();

        boolean hasNumber();

        boolean hasOptions();
    }

    /* loaded from: classes6.dex */
    public static final class EnumValueOptions extends GeneratedMessageLite.ExtendableMessage<EnumValueOptions, Builder> implements EnumValueOptionsOrBuilder {
        private static final EnumValueOptions DEFAULT_INSTANCE;
        public static final int DEPRECATED_FIELD_NUMBER = 1;
        private static volatile Parser<EnumValueOptions> PARSER = null;
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        private int bitField0_;
        private boolean deprecated_;
        private byte memoizedIsInitialized = 2;
        private Internal.ProtobufList<UninterpretedOption> uninterpretedOption_ = GeneratedMessageLite.y();

        /* loaded from: classes6.dex */
        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<EnumValueOptions, Builder> implements EnumValueOptionsOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder addAllUninterpretedOption(Iterable<? extends UninterpretedOption> iterable) {
                f();
                ((EnumValueOptions) this.f33398b).q0(iterable);
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption uninterpretedOption) {
                f();
                ((EnumValueOptions) this.f33398b).s0(uninterpretedOption);
                return this;
            }

            public Builder clearDeprecated() {
                f();
                ((EnumValueOptions) this.f33398b).t0();
                return this;
            }

            public Builder clearUninterpretedOption() {
                f();
                ((EnumValueOptions) this.f33398b).u0();
                return this;
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumValueOptionsOrBuilder
            public boolean getDeprecated() {
                return ((EnumValueOptions) this.f33398b).getDeprecated();
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumValueOptionsOrBuilder
            public UninterpretedOption getUninterpretedOption(int i4) {
                return ((EnumValueOptions) this.f33398b).getUninterpretedOption(i4);
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumValueOptionsOrBuilder
            public int getUninterpretedOptionCount() {
                return ((EnumValueOptions) this.f33398b).getUninterpretedOptionCount();
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumValueOptionsOrBuilder
            public List<UninterpretedOption> getUninterpretedOptionList() {
                return Collections.unmodifiableList(((EnumValueOptions) this.f33398b).getUninterpretedOptionList());
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumValueOptionsOrBuilder
            public boolean hasDeprecated() {
                return ((EnumValueOptions) this.f33398b).hasDeprecated();
            }

            public Builder removeUninterpretedOption(int i4) {
                f();
                ((EnumValueOptions) this.f33398b).w0(i4);
                return this;
            }

            public Builder setDeprecated(boolean z3) {
                f();
                ((EnumValueOptions) this.f33398b).x0(z3);
                return this;
            }

            public Builder setUninterpretedOption(int i4, UninterpretedOption uninterpretedOption) {
                f();
                ((EnumValueOptions) this.f33398b).y0(i4, uninterpretedOption);
                return this;
            }

            private Builder() {
                super(EnumValueOptions.DEFAULT_INSTANCE);
            }

            public Builder addUninterpretedOption(int i4, UninterpretedOption uninterpretedOption) {
                f();
                ((EnumValueOptions) this.f33398b).r0(i4, uninterpretedOption);
                return this;
            }

            public Builder setUninterpretedOption(int i4, UninterpretedOption.Builder builder) {
                f();
                ((EnumValueOptions) this.f33398b).y0(i4, builder.build());
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption.Builder builder) {
                f();
                ((EnumValueOptions) this.f33398b).s0(builder.build());
                return this;
            }

            public Builder addUninterpretedOption(int i4, UninterpretedOption.Builder builder) {
                f();
                ((EnumValueOptions) this.f33398b).r0(i4, builder.build());
                return this;
            }
        }

        static {
            EnumValueOptions enumValueOptions = new EnumValueOptions();
            DEFAULT_INSTANCE = enumValueOptions;
            GeneratedMessageLite.d0(EnumValueOptions.class, enumValueOptions);
        }

        private EnumValueOptions() {
        }

        public static EnumValueOptions getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.q();
        }

        public static EnumValueOptions parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (EnumValueOptions) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
        }

        public static EnumValueOptions parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (EnumValueOptions) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<EnumValueOptions> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void q0(Iterable<? extends UninterpretedOption> iterable) {
            v0();
            AbstractMessageLite.a(iterable, this.uninterpretedOption_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void r0(int i4, UninterpretedOption uninterpretedOption) {
            uninterpretedOption.getClass();
            v0();
            this.uninterpretedOption_.add(i4, uninterpretedOption);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s0(UninterpretedOption uninterpretedOption) {
            uninterpretedOption.getClass();
            v0();
            this.uninterpretedOption_.add(uninterpretedOption);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void t0() {
            this.bitField0_ &= -2;
            this.deprecated_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void u0() {
            this.uninterpretedOption_ = GeneratedMessageLite.y();
        }

        private void v0() {
            Internal.ProtobufList<UninterpretedOption> protobufList = this.uninterpretedOption_;
            if (!protobufList.isModifiable()) {
                this.uninterpretedOption_ = GeneratedMessageLite.K(protobufList);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void w0(int i4) {
            v0();
            this.uninterpretedOption_.remove(i4);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void x0(boolean z3) {
            this.bitField0_ |= 1;
            this.deprecated_ = z3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void y0(int i4, UninterpretedOption uninterpretedOption) {
            uninterpretedOption.getClass();
            v0();
            this.uninterpretedOption_.set(i4, uninterpretedOption);
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumValueOptionsOrBuilder
        public boolean getDeprecated() {
            return this.deprecated_;
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumValueOptionsOrBuilder
        public UninterpretedOption getUninterpretedOption(int i4) {
            return this.uninterpretedOption_.get(i4);
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumValueOptionsOrBuilder
        public int getUninterpretedOptionCount() {
            return this.uninterpretedOption_.size();
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumValueOptionsOrBuilder
        public List<UninterpretedOption> getUninterpretedOptionList() {
            return this.uninterpretedOption_;
        }

        public UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int i4) {
            return this.uninterpretedOption_.get(i4);
        }

        public List<? extends UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList() {
            return this.uninterpretedOption_;
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumValueOptionsOrBuilder
        public boolean hasDeprecated() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            int i4 = 1;
            switch (AnonymousClass1.f33300a[methodToInvoke.ordinal()]) {
                case 1:
                    return new EnumValueOptions();
                case 2:
                    return new Builder(null);
                case 3:
                    return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001ϧ\u0002\u0000\u0001\u0001\u0001ဇ\u0000ϧЛ", new Object[]{"bitField0_", "deprecated_", "uninterpretedOption_", UninterpretedOption.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<EnumValueOptions> parser = PARSER;
                    if (parser == null) {
                        synchronized (EnumValueOptions.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case 6:
                    return Byte.valueOf(this.memoizedIsInitialized);
                case 7:
                    if (obj == null) {
                        i4 = 0;
                    }
                    this.memoizedIsInitialized = (byte) i4;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static Builder newBuilder(EnumValueOptions enumValueOptions) {
            return (Builder) DEFAULT_INSTANCE.r(enumValueOptions);
        }

        public static EnumValueOptions parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (EnumValueOptions) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static EnumValueOptions parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (EnumValueOptions) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static EnumValueOptions parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (EnumValueOptions) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
        }

        public static EnumValueOptions parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (EnumValueOptions) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static EnumValueOptions parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (EnumValueOptions) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
        }

        public static EnumValueOptions parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (EnumValueOptions) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static EnumValueOptions parseFrom(InputStream inputStream) throws IOException {
            return (EnumValueOptions) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
        }

        public static EnumValueOptions parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (EnumValueOptions) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static EnumValueOptions parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (EnumValueOptions) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
        }

        public static EnumValueOptions parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (EnumValueOptions) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: classes6.dex */
    public interface EnumValueOptionsOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<EnumValueOptions, EnumValueOptions.Builder> {
        boolean getDeprecated();

        UninterpretedOption getUninterpretedOption(int i4);

        int getUninterpretedOptionCount();

        List<UninterpretedOption> getUninterpretedOptionList();

        boolean hasDeprecated();
    }

    /* loaded from: classes6.dex */
    public static final class ExtensionRangeOptions extends GeneratedMessageLite.ExtendableMessage<ExtensionRangeOptions, Builder> implements ExtensionRangeOptionsOrBuilder {
        private static final ExtensionRangeOptions DEFAULT_INSTANCE;
        private static volatile Parser<ExtensionRangeOptions> PARSER = null;
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        private byte memoizedIsInitialized = 2;
        private Internal.ProtobufList<UninterpretedOption> uninterpretedOption_ = GeneratedMessageLite.y();

        /* loaded from: classes6.dex */
        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<ExtensionRangeOptions, Builder> implements ExtensionRangeOptionsOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder addAllUninterpretedOption(Iterable<? extends UninterpretedOption> iterable) {
                f();
                ((ExtensionRangeOptions) this.f33398b).o0(iterable);
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption uninterpretedOption) {
                f();
                ((ExtensionRangeOptions) this.f33398b).q0(uninterpretedOption);
                return this;
            }

            public Builder clearUninterpretedOption() {
                f();
                ((ExtensionRangeOptions) this.f33398b).r0();
                return this;
            }

            @Override // com.google.protobuf.DescriptorProtos.ExtensionRangeOptionsOrBuilder
            public UninterpretedOption getUninterpretedOption(int i4) {
                return ((ExtensionRangeOptions) this.f33398b).getUninterpretedOption(i4);
            }

            @Override // com.google.protobuf.DescriptorProtos.ExtensionRangeOptionsOrBuilder
            public int getUninterpretedOptionCount() {
                return ((ExtensionRangeOptions) this.f33398b).getUninterpretedOptionCount();
            }

            @Override // com.google.protobuf.DescriptorProtos.ExtensionRangeOptionsOrBuilder
            public List<UninterpretedOption> getUninterpretedOptionList() {
                return Collections.unmodifiableList(((ExtensionRangeOptions) this.f33398b).getUninterpretedOptionList());
            }

            public Builder removeUninterpretedOption(int i4) {
                f();
                ((ExtensionRangeOptions) this.f33398b).t0(i4);
                return this;
            }

            public Builder setUninterpretedOption(int i4, UninterpretedOption uninterpretedOption) {
                f();
                ((ExtensionRangeOptions) this.f33398b).u0(i4, uninterpretedOption);
                return this;
            }

            private Builder() {
                super(ExtensionRangeOptions.DEFAULT_INSTANCE);
            }

            public Builder addUninterpretedOption(int i4, UninterpretedOption uninterpretedOption) {
                f();
                ((ExtensionRangeOptions) this.f33398b).p0(i4, uninterpretedOption);
                return this;
            }

            public Builder setUninterpretedOption(int i4, UninterpretedOption.Builder builder) {
                f();
                ((ExtensionRangeOptions) this.f33398b).u0(i4, builder.build());
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption.Builder builder) {
                f();
                ((ExtensionRangeOptions) this.f33398b).q0(builder.build());
                return this;
            }

            public Builder addUninterpretedOption(int i4, UninterpretedOption.Builder builder) {
                f();
                ((ExtensionRangeOptions) this.f33398b).p0(i4, builder.build());
                return this;
            }
        }

        static {
            ExtensionRangeOptions extensionRangeOptions = new ExtensionRangeOptions();
            DEFAULT_INSTANCE = extensionRangeOptions;
            GeneratedMessageLite.d0(ExtensionRangeOptions.class, extensionRangeOptions);
        }

        private ExtensionRangeOptions() {
        }

        public static ExtensionRangeOptions getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.q();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void o0(Iterable<? extends UninterpretedOption> iterable) {
            s0();
            AbstractMessageLite.a(iterable, this.uninterpretedOption_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void p0(int i4, UninterpretedOption uninterpretedOption) {
            uninterpretedOption.getClass();
            s0();
            this.uninterpretedOption_.add(i4, uninterpretedOption);
        }

        public static ExtensionRangeOptions parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ExtensionRangeOptions) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
        }

        public static ExtensionRangeOptions parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (ExtensionRangeOptions) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<ExtensionRangeOptions> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void q0(UninterpretedOption uninterpretedOption) {
            uninterpretedOption.getClass();
            s0();
            this.uninterpretedOption_.add(uninterpretedOption);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void r0() {
            this.uninterpretedOption_ = GeneratedMessageLite.y();
        }

        private void s0() {
            Internal.ProtobufList<UninterpretedOption> protobufList = this.uninterpretedOption_;
            if (!protobufList.isModifiable()) {
                this.uninterpretedOption_ = GeneratedMessageLite.K(protobufList);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void t0(int i4) {
            s0();
            this.uninterpretedOption_.remove(i4);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void u0(int i4, UninterpretedOption uninterpretedOption) {
            uninterpretedOption.getClass();
            s0();
            this.uninterpretedOption_.set(i4, uninterpretedOption);
        }

        @Override // com.google.protobuf.DescriptorProtos.ExtensionRangeOptionsOrBuilder
        public UninterpretedOption getUninterpretedOption(int i4) {
            return this.uninterpretedOption_.get(i4);
        }

        @Override // com.google.protobuf.DescriptorProtos.ExtensionRangeOptionsOrBuilder
        public int getUninterpretedOptionCount() {
            return this.uninterpretedOption_.size();
        }

        @Override // com.google.protobuf.DescriptorProtos.ExtensionRangeOptionsOrBuilder
        public List<UninterpretedOption> getUninterpretedOptionList() {
            return this.uninterpretedOption_;
        }

        public UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int i4) {
            return this.uninterpretedOption_.get(i4);
        }

        public List<? extends UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList() {
            return this.uninterpretedOption_;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            int i4 = 1;
            switch (AnonymousClass1.f33300a[methodToInvoke.ordinal()]) {
                case 1:
                    return new ExtensionRangeOptions();
                case 2:
                    return new Builder(null);
                case 3:
                    return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000ϧϧ\u0001\u0000\u0001\u0001ϧЛ", new Object[]{"uninterpretedOption_", UninterpretedOption.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ExtensionRangeOptions> parser = PARSER;
                    if (parser == null) {
                        synchronized (ExtensionRangeOptions.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case 6:
                    return Byte.valueOf(this.memoizedIsInitialized);
                case 7:
                    if (obj == null) {
                        i4 = 0;
                    }
                    this.memoizedIsInitialized = (byte) i4;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static Builder newBuilder(ExtensionRangeOptions extensionRangeOptions) {
            return (Builder) DEFAULT_INSTANCE.r(extensionRangeOptions);
        }

        public static ExtensionRangeOptions parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ExtensionRangeOptions) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ExtensionRangeOptions parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ExtensionRangeOptions) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ExtensionRangeOptions parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (ExtensionRangeOptions) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
        }

        public static ExtensionRangeOptions parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ExtensionRangeOptions) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ExtensionRangeOptions parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ExtensionRangeOptions) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
        }

        public static ExtensionRangeOptions parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ExtensionRangeOptions) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ExtensionRangeOptions parseFrom(InputStream inputStream) throws IOException {
            return (ExtensionRangeOptions) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
        }

        public static ExtensionRangeOptions parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ExtensionRangeOptions) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ExtensionRangeOptions parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ExtensionRangeOptions) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ExtensionRangeOptions parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ExtensionRangeOptions) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: classes6.dex */
    public interface ExtensionRangeOptionsOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<ExtensionRangeOptions, ExtensionRangeOptions.Builder> {
        UninterpretedOption getUninterpretedOption(int i4);

        int getUninterpretedOptionCount();

        List<UninterpretedOption> getUninterpretedOptionList();
    }

    /* loaded from: classes6.dex */
    public static final class FieldDescriptorProto extends GeneratedMessageLite<FieldDescriptorProto, Builder> implements FieldDescriptorProtoOrBuilder {
        private static final FieldDescriptorProto DEFAULT_INSTANCE;
        public static final int DEFAULT_VALUE_FIELD_NUMBER = 7;
        public static final int EXTENDEE_FIELD_NUMBER = 2;
        public static final int JSON_NAME_FIELD_NUMBER = 10;
        public static final int LABEL_FIELD_NUMBER = 4;
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int NUMBER_FIELD_NUMBER = 3;
        public static final int ONEOF_INDEX_FIELD_NUMBER = 9;
        public static final int OPTIONS_FIELD_NUMBER = 8;
        private static volatile Parser<FieldDescriptorProto> PARSER = null;
        public static final int PROTO3_OPTIONAL_FIELD_NUMBER = 17;
        public static final int TYPE_FIELD_NUMBER = 5;
        public static final int TYPE_NAME_FIELD_NUMBER = 6;
        private int bitField0_;
        private int number_;
        private int oneofIndex_;
        private FieldOptions options_;
        private boolean proto3Optional_;
        private byte memoizedIsInitialized = 2;
        private String name_ = "";
        private int label_ = 1;
        private int type_ = 1;
        private String typeName_ = "";
        private String extendee_ = "";
        private String defaultValue_ = "";
        private String jsonName_ = "";

        /* loaded from: classes6.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<FieldDescriptorProto, Builder> implements FieldDescriptorProtoOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearDefaultValue() {
                f();
                ((FieldDescriptorProto) this.f33398b).I0();
                return this;
            }

            public Builder clearExtendee() {
                f();
                ((FieldDescriptorProto) this.f33398b).J0();
                return this;
            }

            public Builder clearJsonName() {
                f();
                ((FieldDescriptorProto) this.f33398b).K0();
                return this;
            }

            public Builder clearLabel() {
                f();
                ((FieldDescriptorProto) this.f33398b).L0();
                return this;
            }

            public Builder clearName() {
                f();
                ((FieldDescriptorProto) this.f33398b).M0();
                return this;
            }

            public Builder clearNumber() {
                f();
                ((FieldDescriptorProto) this.f33398b).N0();
                return this;
            }

            public Builder clearOneofIndex() {
                f();
                ((FieldDescriptorProto) this.f33398b).O0();
                return this;
            }

            public Builder clearOptions() {
                f();
                ((FieldDescriptorProto) this.f33398b).P0();
                return this;
            }

            public Builder clearProto3Optional() {
                f();
                ((FieldDescriptorProto) this.f33398b).Q0();
                return this;
            }

            public Builder clearType() {
                f();
                ((FieldDescriptorProto) this.f33398b).R0();
                return this;
            }

            public Builder clearTypeName() {
                f();
                ((FieldDescriptorProto) this.f33398b).S0();
                return this;
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public String getDefaultValue() {
                return ((FieldDescriptorProto) this.f33398b).getDefaultValue();
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public ByteString getDefaultValueBytes() {
                return ((FieldDescriptorProto) this.f33398b).getDefaultValueBytes();
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public String getExtendee() {
                return ((FieldDescriptorProto) this.f33398b).getExtendee();
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public ByteString getExtendeeBytes() {
                return ((FieldDescriptorProto) this.f33398b).getExtendeeBytes();
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public String getJsonName() {
                return ((FieldDescriptorProto) this.f33398b).getJsonName();
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public ByteString getJsonNameBytes() {
                return ((FieldDescriptorProto) this.f33398b).getJsonNameBytes();
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public Label getLabel() {
                return ((FieldDescriptorProto) this.f33398b).getLabel();
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public String getName() {
                return ((FieldDescriptorProto) this.f33398b).getName();
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public ByteString getNameBytes() {
                return ((FieldDescriptorProto) this.f33398b).getNameBytes();
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public int getNumber() {
                return ((FieldDescriptorProto) this.f33398b).getNumber();
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public int getOneofIndex() {
                return ((FieldDescriptorProto) this.f33398b).getOneofIndex();
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public FieldOptions getOptions() {
                return ((FieldDescriptorProto) this.f33398b).getOptions();
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public boolean getProto3Optional() {
                return ((FieldDescriptorProto) this.f33398b).getProto3Optional();
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public Type getType() {
                return ((FieldDescriptorProto) this.f33398b).getType();
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public String getTypeName() {
                return ((FieldDescriptorProto) this.f33398b).getTypeName();
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public ByteString getTypeNameBytes() {
                return ((FieldDescriptorProto) this.f33398b).getTypeNameBytes();
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public boolean hasDefaultValue() {
                return ((FieldDescriptorProto) this.f33398b).hasDefaultValue();
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public boolean hasExtendee() {
                return ((FieldDescriptorProto) this.f33398b).hasExtendee();
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public boolean hasJsonName() {
                return ((FieldDescriptorProto) this.f33398b).hasJsonName();
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public boolean hasLabel() {
                return ((FieldDescriptorProto) this.f33398b).hasLabel();
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public boolean hasName() {
                return ((FieldDescriptorProto) this.f33398b).hasName();
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public boolean hasNumber() {
                return ((FieldDescriptorProto) this.f33398b).hasNumber();
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public boolean hasOneofIndex() {
                return ((FieldDescriptorProto) this.f33398b).hasOneofIndex();
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public boolean hasOptions() {
                return ((FieldDescriptorProto) this.f33398b).hasOptions();
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public boolean hasProto3Optional() {
                return ((FieldDescriptorProto) this.f33398b).hasProto3Optional();
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public boolean hasType() {
                return ((FieldDescriptorProto) this.f33398b).hasType();
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public boolean hasTypeName() {
                return ((FieldDescriptorProto) this.f33398b).hasTypeName();
            }

            public Builder mergeOptions(FieldOptions fieldOptions) {
                f();
                ((FieldDescriptorProto) this.f33398b).T0(fieldOptions);
                return this;
            }

            public Builder setDefaultValue(String str) {
                f();
                ((FieldDescriptorProto) this.f33398b).U0(str);
                return this;
            }

            public Builder setDefaultValueBytes(ByteString byteString) {
                f();
                ((FieldDescriptorProto) this.f33398b).V0(byteString);
                return this;
            }

            public Builder setExtendee(String str) {
                f();
                ((FieldDescriptorProto) this.f33398b).W0(str);
                return this;
            }

            public Builder setExtendeeBytes(ByteString byteString) {
                f();
                ((FieldDescriptorProto) this.f33398b).X0(byteString);
                return this;
            }

            public Builder setJsonName(String str) {
                f();
                ((FieldDescriptorProto) this.f33398b).Y0(str);
                return this;
            }

            public Builder setJsonNameBytes(ByteString byteString) {
                f();
                ((FieldDescriptorProto) this.f33398b).Z0(byteString);
                return this;
            }

            public Builder setLabel(Label label) {
                f();
                ((FieldDescriptorProto) this.f33398b).a1(label);
                return this;
            }

            public Builder setName(String str) {
                f();
                ((FieldDescriptorProto) this.f33398b).b1(str);
                return this;
            }

            public Builder setNameBytes(ByteString byteString) {
                f();
                ((FieldDescriptorProto) this.f33398b).c1(byteString);
                return this;
            }

            public Builder setNumber(int i4) {
                f();
                ((FieldDescriptorProto) this.f33398b).d1(i4);
                return this;
            }

            public Builder setOneofIndex(int i4) {
                f();
                ((FieldDescriptorProto) this.f33398b).e1(i4);
                return this;
            }

            public Builder setOptions(FieldOptions fieldOptions) {
                f();
                ((FieldDescriptorProto) this.f33398b).f1(fieldOptions);
                return this;
            }

            public Builder setProto3Optional(boolean z3) {
                f();
                ((FieldDescriptorProto) this.f33398b).g1(z3);
                return this;
            }

            public Builder setType(Type type) {
                f();
                ((FieldDescriptorProto) this.f33398b).h1(type);
                return this;
            }

            public Builder setTypeName(String str) {
                f();
                ((FieldDescriptorProto) this.f33398b).i1(str);
                return this;
            }

            public Builder setTypeNameBytes(ByteString byteString) {
                f();
                ((FieldDescriptorProto) this.f33398b).j1(byteString);
                return this;
            }

            private Builder() {
                super(FieldDescriptorProto.DEFAULT_INSTANCE);
            }

            public Builder setOptions(FieldOptions.Builder builder) {
                f();
                ((FieldDescriptorProto) this.f33398b).f1((FieldOptions) builder.build());
                return this;
            }
        }

        /* loaded from: classes6.dex */
        public enum Label implements Internal.EnumLite {
            LABEL_OPTIONAL(1),
            LABEL_REQUIRED(2),
            LABEL_REPEATED(3);
            
            public static final int LABEL_OPTIONAL_VALUE = 1;
            public static final int LABEL_REPEATED_VALUE = 3;
            public static final int LABEL_REQUIRED_VALUE = 2;

            /* renamed from: a  reason: collision with root package name */
            private static final Internal.EnumLiteMap<Label> f33301a = new Internal.EnumLiteMap<Label>() { // from class: com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Label.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                /* renamed from: a */
                public Label findValueByNumber(int i4) {
                    return Label.forNumber(i4);
                }
            };
            private final int value;

            /* JADX INFO: Access modifiers changed from: private */
            /* loaded from: classes6.dex */
            public static final class LabelVerifier implements Internal.EnumVerifier {

                /* renamed from: a  reason: collision with root package name */
                static final Internal.EnumVerifier f33303a = new LabelVerifier();

                private LabelVerifier() {
                }

                @Override // com.google.protobuf.Internal.EnumVerifier
                public boolean isInRange(int i4) {
                    if (Label.forNumber(i4) != null) {
                        return true;
                    }
                    return false;
                }
            }

            Label(int i4) {
                this.value = i4;
            }

            public static Label forNumber(int i4) {
                if (i4 != 1) {
                    if (i4 != 2) {
                        if (i4 != 3) {
                            return null;
                        }
                        return LABEL_REPEATED;
                    }
                    return LABEL_REQUIRED;
                }
                return LABEL_OPTIONAL;
            }

            public static Internal.EnumLiteMap<Label> internalGetValueMap() {
                return f33301a;
            }

            public static Internal.EnumVerifier internalGetVerifier() {
                return LabelVerifier.f33303a;
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static Label valueOf(int i4) {
                return forNumber(i4);
            }
        }

        /* loaded from: classes6.dex */
        public enum Type implements Internal.EnumLite {
            TYPE_DOUBLE(1),
            TYPE_FLOAT(2),
            TYPE_INT64(3),
            TYPE_UINT64(4),
            TYPE_INT32(5),
            TYPE_FIXED64(6),
            TYPE_FIXED32(7),
            TYPE_BOOL(8),
            TYPE_STRING(9),
            TYPE_GROUP(10),
            TYPE_MESSAGE(11),
            TYPE_BYTES(12),
            TYPE_UINT32(13),
            TYPE_ENUM(14),
            TYPE_SFIXED32(15),
            TYPE_SFIXED64(16),
            TYPE_SINT32(17),
            TYPE_SINT64(18);
            
            public static final int TYPE_BOOL_VALUE = 8;
            public static final int TYPE_BYTES_VALUE = 12;
            public static final int TYPE_DOUBLE_VALUE = 1;
            public static final int TYPE_ENUM_VALUE = 14;
            public static final int TYPE_FIXED32_VALUE = 7;
            public static final int TYPE_FIXED64_VALUE = 6;
            public static final int TYPE_FLOAT_VALUE = 2;
            public static final int TYPE_GROUP_VALUE = 10;
            public static final int TYPE_INT32_VALUE = 5;
            public static final int TYPE_INT64_VALUE = 3;
            public static final int TYPE_MESSAGE_VALUE = 11;
            public static final int TYPE_SFIXED32_VALUE = 15;
            public static final int TYPE_SFIXED64_VALUE = 16;
            public static final int TYPE_SINT32_VALUE = 17;
            public static final int TYPE_SINT64_VALUE = 18;
            public static final int TYPE_STRING_VALUE = 9;
            public static final int TYPE_UINT32_VALUE = 13;
            public static final int TYPE_UINT64_VALUE = 4;

            /* renamed from: a  reason: collision with root package name */
            private static final Internal.EnumLiteMap<Type> f33304a = new Internal.EnumLiteMap<Type>() { // from class: com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Type.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                /* renamed from: a */
                public Type findValueByNumber(int i4) {
                    return Type.forNumber(i4);
                }
            };
            private final int value;

            /* JADX INFO: Access modifiers changed from: private */
            /* loaded from: classes6.dex */
            public static final class TypeVerifier implements Internal.EnumVerifier {

                /* renamed from: a  reason: collision with root package name */
                static final Internal.EnumVerifier f33306a = new TypeVerifier();

                private TypeVerifier() {
                }

                @Override // com.google.protobuf.Internal.EnumVerifier
                public boolean isInRange(int i4) {
                    if (Type.forNumber(i4) != null) {
                        return true;
                    }
                    return false;
                }
            }

            Type(int i4) {
                this.value = i4;
            }

            public static Type forNumber(int i4) {
                switch (i4) {
                    case 1:
                        return TYPE_DOUBLE;
                    case 2:
                        return TYPE_FLOAT;
                    case 3:
                        return TYPE_INT64;
                    case 4:
                        return TYPE_UINT64;
                    case 5:
                        return TYPE_INT32;
                    case 6:
                        return TYPE_FIXED64;
                    case 7:
                        return TYPE_FIXED32;
                    case 8:
                        return TYPE_BOOL;
                    case 9:
                        return TYPE_STRING;
                    case 10:
                        return TYPE_GROUP;
                    case 11:
                        return TYPE_MESSAGE;
                    case 12:
                        return TYPE_BYTES;
                    case 13:
                        return TYPE_UINT32;
                    case 14:
                        return TYPE_ENUM;
                    case 15:
                        return TYPE_SFIXED32;
                    case 16:
                        return TYPE_SFIXED64;
                    case 17:
                        return TYPE_SINT32;
                    case 18:
                        return TYPE_SINT64;
                    default:
                        return null;
                }
            }

            public static Internal.EnumLiteMap<Type> internalGetValueMap() {
                return f33304a;
            }

            public static Internal.EnumVerifier internalGetVerifier() {
                return TypeVerifier.f33306a;
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static Type valueOf(int i4) {
                return forNumber(i4);
            }
        }

        static {
            FieldDescriptorProto fieldDescriptorProto = new FieldDescriptorProto();
            DEFAULT_INSTANCE = fieldDescriptorProto;
            GeneratedMessageLite.d0(FieldDescriptorProto.class, fieldDescriptorProto);
        }

        private FieldDescriptorProto() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void I0() {
            this.bitField0_ &= -65;
            this.defaultValue_ = getDefaultInstance().getDefaultValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void J0() {
            this.bitField0_ &= -33;
            this.extendee_ = getDefaultInstance().getExtendee();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void K0() {
            this.bitField0_ &= -257;
            this.jsonName_ = getDefaultInstance().getJsonName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void L0() {
            this.bitField0_ &= -5;
            this.label_ = 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void M0() {
            this.bitField0_ &= -2;
            this.name_ = getDefaultInstance().getName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void N0() {
            this.bitField0_ &= -3;
            this.number_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void O0() {
            this.bitField0_ &= -129;
            this.oneofIndex_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void P0() {
            this.options_ = null;
            this.bitField0_ &= -513;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Q0() {
            this.bitField0_ &= -1025;
            this.proto3Optional_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void R0() {
            this.bitField0_ &= -9;
            this.type_ = 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void S0() {
            this.bitField0_ &= -17;
            this.typeName_ = getDefaultInstance().getTypeName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void T0(FieldOptions fieldOptions) {
            fieldOptions.getClass();
            FieldOptions fieldOptions2 = this.options_;
            if (fieldOptions2 != null && fieldOptions2 != FieldOptions.getDefaultInstance()) {
                this.options_ = ((FieldOptions.Builder) FieldOptions.newBuilder(this.options_).mergeFrom((FieldOptions.Builder) fieldOptions)).buildPartial();
            } else {
                this.options_ = fieldOptions;
            }
            this.bitField0_ |= 512;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void U0(String str) {
            str.getClass();
            this.bitField0_ |= 64;
            this.defaultValue_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void V0(ByteString byteString) {
            this.defaultValue_ = byteString.toStringUtf8();
            this.bitField0_ |= 64;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void W0(String str) {
            str.getClass();
            this.bitField0_ |= 32;
            this.extendee_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void X0(ByteString byteString) {
            this.extendee_ = byteString.toStringUtf8();
            this.bitField0_ |= 32;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Y0(String str) {
            str.getClass();
            this.bitField0_ |= 256;
            this.jsonName_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Z0(ByteString byteString) {
            this.jsonName_ = byteString.toStringUtf8();
            this.bitField0_ |= 256;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a1(Label label) {
            this.label_ = label.getNumber();
            this.bitField0_ |= 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b1(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.name_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c1(ByteString byteString) {
            this.name_ = byteString.toStringUtf8();
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d1(int i4) {
            this.bitField0_ |= 2;
            this.number_ = i4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e1(int i4) {
            this.bitField0_ |= 128;
            this.oneofIndex_ = i4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void f1(FieldOptions fieldOptions) {
            fieldOptions.getClass();
            this.options_ = fieldOptions;
            this.bitField0_ |= 512;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g1(boolean z3) {
            this.bitField0_ |= 1024;
            this.proto3Optional_ = z3;
        }

        public static FieldDescriptorProto getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void h1(Type type) {
            this.type_ = type.getNumber();
            this.bitField0_ |= 8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void i1(String str) {
            str.getClass();
            this.bitField0_ |= 16;
            this.typeName_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j1(ByteString byteString) {
            this.typeName_ = byteString.toStringUtf8();
            this.bitField0_ |= 16;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.q();
        }

        public static FieldDescriptorProto parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (FieldDescriptorProto) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
        }

        public static FieldDescriptorProto parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (FieldDescriptorProto) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<FieldDescriptorProto> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public String getDefaultValue() {
            return this.defaultValue_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public ByteString getDefaultValueBytes() {
            return ByteString.copyFromUtf8(this.defaultValue_);
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public String getExtendee() {
            return this.extendee_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public ByteString getExtendeeBytes() {
            return ByteString.copyFromUtf8(this.extendee_);
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public String getJsonName() {
            return this.jsonName_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public ByteString getJsonNameBytes() {
            return ByteString.copyFromUtf8(this.jsonName_);
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public Label getLabel() {
            Label forNumber = Label.forNumber(this.label_);
            if (forNumber == null) {
                return Label.LABEL_OPTIONAL;
            }
            return forNumber;
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public String getName() {
            return this.name_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public ByteString getNameBytes() {
            return ByteString.copyFromUtf8(this.name_);
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public int getNumber() {
            return this.number_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public int getOneofIndex() {
            return this.oneofIndex_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public FieldOptions getOptions() {
            FieldOptions fieldOptions = this.options_;
            if (fieldOptions == null) {
                return FieldOptions.getDefaultInstance();
            }
            return fieldOptions;
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public boolean getProto3Optional() {
            return this.proto3Optional_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public Type getType() {
            Type forNumber = Type.forNumber(this.type_);
            if (forNumber == null) {
                return Type.TYPE_DOUBLE;
            }
            return forNumber;
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public String getTypeName() {
            return this.typeName_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public ByteString getTypeNameBytes() {
            return ByteString.copyFromUtf8(this.typeName_);
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public boolean hasDefaultValue() {
            if ((this.bitField0_ & 64) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public boolean hasExtendee() {
            if ((this.bitField0_ & 32) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public boolean hasJsonName() {
            if ((this.bitField0_ & 256) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public boolean hasLabel() {
            if ((this.bitField0_ & 4) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public boolean hasName() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public boolean hasNumber() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public boolean hasOneofIndex() {
            if ((this.bitField0_ & 128) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public boolean hasOptions() {
            if ((this.bitField0_ & 512) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public boolean hasProto3Optional() {
            if ((this.bitField0_ & 1024) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public boolean hasType() {
            if ((this.bitField0_ & 8) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public boolean hasTypeName() {
            if ((this.bitField0_ & 16) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            int i4 = 1;
            switch (AnonymousClass1.f33300a[methodToInvoke.ordinal()]) {
                case 1:
                    return new FieldDescriptorProto();
                case 2:
                    return new Builder(null);
                case 3:
                    return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0001\u000b\u0000\u0001\u0001\u0011\u000b\u0000\u0000\u0001\u0001ဈ\u0000\u0002ဈ\u0005\u0003င\u0001\u0004ဌ\u0002\u0005ဌ\u0003\u0006ဈ\u0004\u0007ဈ\u0006\bᐉ\t\tင\u0007\nဈ\b\u0011ဇ\n", new Object[]{"bitField0_", "name_", "extendee_", "number_", "label_", Label.internalGetVerifier(), "type_", Type.internalGetVerifier(), "typeName_", "defaultValue_", "options_", "oneofIndex_", "jsonName_", "proto3Optional_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<FieldDescriptorProto> parser = PARSER;
                    if (parser == null) {
                        synchronized (FieldDescriptorProto.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case 6:
                    return Byte.valueOf(this.memoizedIsInitialized);
                case 7:
                    if (obj == null) {
                        i4 = 0;
                    }
                    this.memoizedIsInitialized = (byte) i4;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static Builder newBuilder(FieldDescriptorProto fieldDescriptorProto) {
            return DEFAULT_INSTANCE.r(fieldDescriptorProto);
        }

        public static FieldDescriptorProto parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (FieldDescriptorProto) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static FieldDescriptorProto parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (FieldDescriptorProto) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static FieldDescriptorProto parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (FieldDescriptorProto) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
        }

        public static FieldDescriptorProto parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (FieldDescriptorProto) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static FieldDescriptorProto parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (FieldDescriptorProto) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
        }

        public static FieldDescriptorProto parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (FieldDescriptorProto) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static FieldDescriptorProto parseFrom(InputStream inputStream) throws IOException {
            return (FieldDescriptorProto) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
        }

        public static FieldDescriptorProto parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (FieldDescriptorProto) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static FieldDescriptorProto parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (FieldDescriptorProto) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
        }

        public static FieldDescriptorProto parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (FieldDescriptorProto) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: classes6.dex */
    public interface FieldDescriptorProtoOrBuilder extends MessageLiteOrBuilder {
        String getDefaultValue();

        ByteString getDefaultValueBytes();

        String getExtendee();

        ByteString getExtendeeBytes();

        String getJsonName();

        ByteString getJsonNameBytes();

        FieldDescriptorProto.Label getLabel();

        String getName();

        ByteString getNameBytes();

        int getNumber();

        int getOneofIndex();

        FieldOptions getOptions();

        boolean getProto3Optional();

        FieldDescriptorProto.Type getType();

        String getTypeName();

        ByteString getTypeNameBytes();

        boolean hasDefaultValue();

        boolean hasExtendee();

        boolean hasJsonName();

        boolean hasLabel();

        boolean hasName();

        boolean hasNumber();

        boolean hasOneofIndex();

        boolean hasOptions();

        boolean hasProto3Optional();

        boolean hasType();

        boolean hasTypeName();
    }

    /* loaded from: classes6.dex */
    public static final class FieldOptions extends GeneratedMessageLite.ExtendableMessage<FieldOptions, Builder> implements FieldOptionsOrBuilder {
        public static final int CTYPE_FIELD_NUMBER = 1;
        private static final FieldOptions DEFAULT_INSTANCE;
        public static final int DEPRECATED_FIELD_NUMBER = 3;
        public static final int JSTYPE_FIELD_NUMBER = 6;
        public static final int LAZY_FIELD_NUMBER = 5;
        public static final int PACKED_FIELD_NUMBER = 2;
        private static volatile Parser<FieldOptions> PARSER = null;
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        public static final int WEAK_FIELD_NUMBER = 10;
        private int bitField0_;
        private int ctype_;
        private boolean deprecated_;
        private int jstype_;
        private boolean lazy_;
        private boolean packed_;
        private boolean weak_;
        private byte memoizedIsInitialized = 2;
        private Internal.ProtobufList<UninterpretedOption> uninterpretedOption_ = GeneratedMessageLite.y();

        /* loaded from: classes6.dex */
        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<FieldOptions, Builder> implements FieldOptionsOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder addAllUninterpretedOption(Iterable<? extends UninterpretedOption> iterable) {
                f();
                ((FieldOptions) this.f33398b).A0(iterable);
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption uninterpretedOption) {
                f();
                ((FieldOptions) this.f33398b).C0(uninterpretedOption);
                return this;
            }

            public Builder clearCtype() {
                f();
                ((FieldOptions) this.f33398b).D0();
                return this;
            }

            public Builder clearDeprecated() {
                f();
                ((FieldOptions) this.f33398b).E0();
                return this;
            }

            public Builder clearJstype() {
                f();
                ((FieldOptions) this.f33398b).F0();
                return this;
            }

            public Builder clearLazy() {
                f();
                ((FieldOptions) this.f33398b).G0();
                return this;
            }

            public Builder clearPacked() {
                f();
                ((FieldOptions) this.f33398b).H0();
                return this;
            }

            public Builder clearUninterpretedOption() {
                f();
                ((FieldOptions) this.f33398b).I0();
                return this;
            }

            public Builder clearWeak() {
                f();
                ((FieldOptions) this.f33398b).J0();
                return this;
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
            public CType getCtype() {
                return ((FieldOptions) this.f33398b).getCtype();
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
            public boolean getDeprecated() {
                return ((FieldOptions) this.f33398b).getDeprecated();
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
            public JSType getJstype() {
                return ((FieldOptions) this.f33398b).getJstype();
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
            public boolean getLazy() {
                return ((FieldOptions) this.f33398b).getLazy();
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
            public boolean getPacked() {
                return ((FieldOptions) this.f33398b).getPacked();
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
            public UninterpretedOption getUninterpretedOption(int i4) {
                return ((FieldOptions) this.f33398b).getUninterpretedOption(i4);
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
            public int getUninterpretedOptionCount() {
                return ((FieldOptions) this.f33398b).getUninterpretedOptionCount();
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
            public List<UninterpretedOption> getUninterpretedOptionList() {
                return Collections.unmodifiableList(((FieldOptions) this.f33398b).getUninterpretedOptionList());
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
            public boolean getWeak() {
                return ((FieldOptions) this.f33398b).getWeak();
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
            public boolean hasCtype() {
                return ((FieldOptions) this.f33398b).hasCtype();
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
            public boolean hasDeprecated() {
                return ((FieldOptions) this.f33398b).hasDeprecated();
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
            public boolean hasJstype() {
                return ((FieldOptions) this.f33398b).hasJstype();
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
            public boolean hasLazy() {
                return ((FieldOptions) this.f33398b).hasLazy();
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
            public boolean hasPacked() {
                return ((FieldOptions) this.f33398b).hasPacked();
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
            public boolean hasWeak() {
                return ((FieldOptions) this.f33398b).hasWeak();
            }

            public Builder removeUninterpretedOption(int i4) {
                f();
                ((FieldOptions) this.f33398b).L0(i4);
                return this;
            }

            public Builder setCtype(CType cType) {
                f();
                ((FieldOptions) this.f33398b).M0(cType);
                return this;
            }

            public Builder setDeprecated(boolean z3) {
                f();
                ((FieldOptions) this.f33398b).N0(z3);
                return this;
            }

            public Builder setJstype(JSType jSType) {
                f();
                ((FieldOptions) this.f33398b).O0(jSType);
                return this;
            }

            public Builder setLazy(boolean z3) {
                f();
                ((FieldOptions) this.f33398b).P0(z3);
                return this;
            }

            public Builder setPacked(boolean z3) {
                f();
                ((FieldOptions) this.f33398b).Q0(z3);
                return this;
            }

            public Builder setUninterpretedOption(int i4, UninterpretedOption uninterpretedOption) {
                f();
                ((FieldOptions) this.f33398b).R0(i4, uninterpretedOption);
                return this;
            }

            public Builder setWeak(boolean z3) {
                f();
                ((FieldOptions) this.f33398b).S0(z3);
                return this;
            }

            private Builder() {
                super(FieldOptions.DEFAULT_INSTANCE);
            }

            public Builder addUninterpretedOption(int i4, UninterpretedOption uninterpretedOption) {
                f();
                ((FieldOptions) this.f33398b).B0(i4, uninterpretedOption);
                return this;
            }

            public Builder setUninterpretedOption(int i4, UninterpretedOption.Builder builder) {
                f();
                ((FieldOptions) this.f33398b).R0(i4, builder.build());
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption.Builder builder) {
                f();
                ((FieldOptions) this.f33398b).C0(builder.build());
                return this;
            }

            public Builder addUninterpretedOption(int i4, UninterpretedOption.Builder builder) {
                f();
                ((FieldOptions) this.f33398b).B0(i4, builder.build());
                return this;
            }
        }

        /* loaded from: classes6.dex */
        public enum CType implements Internal.EnumLite {
            STRING(0),
            CORD(1),
            STRING_PIECE(2);
            
            public static final int CORD_VALUE = 1;
            public static final int STRING_PIECE_VALUE = 2;
            public static final int STRING_VALUE = 0;

            /* renamed from: a  reason: collision with root package name */
            private static final Internal.EnumLiteMap<CType> f33307a = new Internal.EnumLiteMap<CType>() { // from class: com.google.protobuf.DescriptorProtos.FieldOptions.CType.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                /* renamed from: a */
                public CType findValueByNumber(int i4) {
                    return CType.forNumber(i4);
                }
            };
            private final int value;

            /* JADX INFO: Access modifiers changed from: private */
            /* loaded from: classes6.dex */
            public static final class CTypeVerifier implements Internal.EnumVerifier {

                /* renamed from: a  reason: collision with root package name */
                static final Internal.EnumVerifier f33309a = new CTypeVerifier();

                private CTypeVerifier() {
                }

                @Override // com.google.protobuf.Internal.EnumVerifier
                public boolean isInRange(int i4) {
                    if (CType.forNumber(i4) != null) {
                        return true;
                    }
                    return false;
                }
            }

            CType(int i4) {
                this.value = i4;
            }

            public static CType forNumber(int i4) {
                if (i4 != 0) {
                    if (i4 != 1) {
                        if (i4 != 2) {
                            return null;
                        }
                        return STRING_PIECE;
                    }
                    return CORD;
                }
                return STRING;
            }

            public static Internal.EnumLiteMap<CType> internalGetValueMap() {
                return f33307a;
            }

            public static Internal.EnumVerifier internalGetVerifier() {
                return CTypeVerifier.f33309a;
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static CType valueOf(int i4) {
                return forNumber(i4);
            }
        }

        /* loaded from: classes6.dex */
        public enum JSType implements Internal.EnumLite {
            JS_NORMAL(0),
            JS_STRING(1),
            JS_NUMBER(2);
            
            public static final int JS_NORMAL_VALUE = 0;
            public static final int JS_NUMBER_VALUE = 2;
            public static final int JS_STRING_VALUE = 1;

            /* renamed from: a  reason: collision with root package name */
            private static final Internal.EnumLiteMap<JSType> f33310a = new Internal.EnumLiteMap<JSType>() { // from class: com.google.protobuf.DescriptorProtos.FieldOptions.JSType.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                /* renamed from: a */
                public JSType findValueByNumber(int i4) {
                    return JSType.forNumber(i4);
                }
            };
            private final int value;

            /* JADX INFO: Access modifiers changed from: private */
            /* loaded from: classes6.dex */
            public static final class JSTypeVerifier implements Internal.EnumVerifier {

                /* renamed from: a  reason: collision with root package name */
                static final Internal.EnumVerifier f33312a = new JSTypeVerifier();

                private JSTypeVerifier() {
                }

                @Override // com.google.protobuf.Internal.EnumVerifier
                public boolean isInRange(int i4) {
                    if (JSType.forNumber(i4) != null) {
                        return true;
                    }
                    return false;
                }
            }

            JSType(int i4) {
                this.value = i4;
            }

            public static JSType forNumber(int i4) {
                if (i4 != 0) {
                    if (i4 != 1) {
                        if (i4 != 2) {
                            return null;
                        }
                        return JS_NUMBER;
                    }
                    return JS_STRING;
                }
                return JS_NORMAL;
            }

            public static Internal.EnumLiteMap<JSType> internalGetValueMap() {
                return f33310a;
            }

            public static Internal.EnumVerifier internalGetVerifier() {
                return JSTypeVerifier.f33312a;
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static JSType valueOf(int i4) {
                return forNumber(i4);
            }
        }

        static {
            FieldOptions fieldOptions = new FieldOptions();
            DEFAULT_INSTANCE = fieldOptions;
            GeneratedMessageLite.d0(FieldOptions.class, fieldOptions);
        }

        private FieldOptions() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void A0(Iterable<? extends UninterpretedOption> iterable) {
            K0();
            AbstractMessageLite.a(iterable, this.uninterpretedOption_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void B0(int i4, UninterpretedOption uninterpretedOption) {
            uninterpretedOption.getClass();
            K0();
            this.uninterpretedOption_.add(i4, uninterpretedOption);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void C0(UninterpretedOption uninterpretedOption) {
            uninterpretedOption.getClass();
            K0();
            this.uninterpretedOption_.add(uninterpretedOption);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void D0() {
            this.bitField0_ &= -2;
            this.ctype_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void E0() {
            this.bitField0_ &= -17;
            this.deprecated_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void F0() {
            this.bitField0_ &= -5;
            this.jstype_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void G0() {
            this.bitField0_ &= -9;
            this.lazy_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void H0() {
            this.bitField0_ &= -3;
            this.packed_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void I0() {
            this.uninterpretedOption_ = GeneratedMessageLite.y();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void J0() {
            this.bitField0_ &= -33;
            this.weak_ = false;
        }

        private void K0() {
            Internal.ProtobufList<UninterpretedOption> protobufList = this.uninterpretedOption_;
            if (!protobufList.isModifiable()) {
                this.uninterpretedOption_ = GeneratedMessageLite.K(protobufList);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void L0(int i4) {
            K0();
            this.uninterpretedOption_.remove(i4);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void M0(CType cType) {
            this.ctype_ = cType.getNumber();
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void N0(boolean z3) {
            this.bitField0_ |= 16;
            this.deprecated_ = z3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void O0(JSType jSType) {
            this.jstype_ = jSType.getNumber();
            this.bitField0_ |= 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void P0(boolean z3) {
            this.bitField0_ |= 8;
            this.lazy_ = z3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Q0(boolean z3) {
            this.bitField0_ |= 2;
            this.packed_ = z3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void R0(int i4, UninterpretedOption uninterpretedOption) {
            uninterpretedOption.getClass();
            K0();
            this.uninterpretedOption_.set(i4, uninterpretedOption);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void S0(boolean z3) {
            this.bitField0_ |= 32;
            this.weak_ = z3;
        }

        public static FieldOptions getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.q();
        }

        public static FieldOptions parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (FieldOptions) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
        }

        public static FieldOptions parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (FieldOptions) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<FieldOptions> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
        public CType getCtype() {
            CType forNumber = CType.forNumber(this.ctype_);
            if (forNumber == null) {
                return CType.STRING;
            }
            return forNumber;
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
        public boolean getDeprecated() {
            return this.deprecated_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
        public JSType getJstype() {
            JSType forNumber = JSType.forNumber(this.jstype_);
            if (forNumber == null) {
                return JSType.JS_NORMAL;
            }
            return forNumber;
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
        public boolean getLazy() {
            return this.lazy_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
        public boolean getPacked() {
            return this.packed_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
        public UninterpretedOption getUninterpretedOption(int i4) {
            return this.uninterpretedOption_.get(i4);
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
        public int getUninterpretedOptionCount() {
            return this.uninterpretedOption_.size();
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
        public List<UninterpretedOption> getUninterpretedOptionList() {
            return this.uninterpretedOption_;
        }

        public UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int i4) {
            return this.uninterpretedOption_.get(i4);
        }

        public List<? extends UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList() {
            return this.uninterpretedOption_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
        public boolean getWeak() {
            return this.weak_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
        public boolean hasCtype() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
        public boolean hasDeprecated() {
            if ((this.bitField0_ & 16) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
        public boolean hasJstype() {
            if ((this.bitField0_ & 4) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
        public boolean hasLazy() {
            if ((this.bitField0_ & 8) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
        public boolean hasPacked() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
        public boolean hasWeak() {
            if ((this.bitField0_ & 32) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            int i4 = 1;
            switch (AnonymousClass1.f33300a[methodToInvoke.ordinal()]) {
                case 1:
                    return new FieldOptions();
                case 2:
                    return new Builder(null);
                case 3:
                    return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0001\u0007\u0000\u0001\u0001ϧ\u0007\u0000\u0001\u0001\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဇ\u0004\u0005ဇ\u0003\u0006ဌ\u0002\nဇ\u0005ϧЛ", new Object[]{"bitField0_", "ctype_", CType.internalGetVerifier(), "packed_", "deprecated_", "lazy_", "jstype_", JSType.internalGetVerifier(), "weak_", "uninterpretedOption_", UninterpretedOption.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<FieldOptions> parser = PARSER;
                    if (parser == null) {
                        synchronized (FieldOptions.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case 6:
                    return Byte.valueOf(this.memoizedIsInitialized);
                case 7:
                    if (obj == null) {
                        i4 = 0;
                    }
                    this.memoizedIsInitialized = (byte) i4;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static Builder newBuilder(FieldOptions fieldOptions) {
            return (Builder) DEFAULT_INSTANCE.r(fieldOptions);
        }

        public static FieldOptions parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (FieldOptions) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static FieldOptions parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (FieldOptions) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static FieldOptions parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (FieldOptions) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
        }

        public static FieldOptions parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (FieldOptions) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static FieldOptions parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (FieldOptions) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
        }

        public static FieldOptions parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (FieldOptions) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static FieldOptions parseFrom(InputStream inputStream) throws IOException {
            return (FieldOptions) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
        }

        public static FieldOptions parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (FieldOptions) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static FieldOptions parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (FieldOptions) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
        }

        public static FieldOptions parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (FieldOptions) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: classes6.dex */
    public interface FieldOptionsOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<FieldOptions, FieldOptions.Builder> {
        FieldOptions.CType getCtype();

        boolean getDeprecated();

        FieldOptions.JSType getJstype();

        boolean getLazy();

        boolean getPacked();

        UninterpretedOption getUninterpretedOption(int i4);

        int getUninterpretedOptionCount();

        List<UninterpretedOption> getUninterpretedOptionList();

        boolean getWeak();

        boolean hasCtype();

        boolean hasDeprecated();

        boolean hasJstype();

        boolean hasLazy();

        boolean hasPacked();

        boolean hasWeak();
    }

    /* loaded from: classes6.dex */
    public static final class FileDescriptorProto extends GeneratedMessageLite<FileDescriptorProto, Builder> implements FileDescriptorProtoOrBuilder {
        private static final FileDescriptorProto DEFAULT_INSTANCE;
        public static final int DEPENDENCY_FIELD_NUMBER = 3;
        public static final int ENUM_TYPE_FIELD_NUMBER = 5;
        public static final int EXTENSION_FIELD_NUMBER = 7;
        public static final int MESSAGE_TYPE_FIELD_NUMBER = 4;
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int OPTIONS_FIELD_NUMBER = 8;
        public static final int PACKAGE_FIELD_NUMBER = 2;
        private static volatile Parser<FileDescriptorProto> PARSER = null;
        public static final int PUBLIC_DEPENDENCY_FIELD_NUMBER = 10;
        public static final int SERVICE_FIELD_NUMBER = 6;
        public static final int SOURCE_CODE_INFO_FIELD_NUMBER = 9;
        public static final int SYNTAX_FIELD_NUMBER = 12;
        public static final int WEAK_DEPENDENCY_FIELD_NUMBER = 11;
        private int bitField0_;
        private FileOptions options_;
        private SourceCodeInfo sourceCodeInfo_;
        private byte memoizedIsInitialized = 2;
        private String name_ = "";
        private String package_ = "";
        private Internal.ProtobufList<String> dependency_ = GeneratedMessageLite.y();
        private Internal.IntList publicDependency_ = GeneratedMessageLite.w();
        private Internal.IntList weakDependency_ = GeneratedMessageLite.w();
        private Internal.ProtobufList<DescriptorProto> messageType_ = GeneratedMessageLite.y();
        private Internal.ProtobufList<EnumDescriptorProto> enumType_ = GeneratedMessageLite.y();
        private Internal.ProtobufList<ServiceDescriptorProto> service_ = GeneratedMessageLite.y();
        private Internal.ProtobufList<FieldDescriptorProto> extension_ = GeneratedMessageLite.y();
        private String syntax_ = "";

        /* loaded from: classes6.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<FileDescriptorProto, Builder> implements FileDescriptorProtoOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder addAllDependency(Iterable<String> iterable) {
                f();
                ((FileDescriptorProto) this.f33398b).g1(iterable);
                return this;
            }

            public Builder addAllEnumType(Iterable<? extends EnumDescriptorProto> iterable) {
                f();
                ((FileDescriptorProto) this.f33398b).h1(iterable);
                return this;
            }

            public Builder addAllExtension(Iterable<? extends FieldDescriptorProto> iterable) {
                f();
                ((FileDescriptorProto) this.f33398b).i1(iterable);
                return this;
            }

            public Builder addAllMessageType(Iterable<? extends DescriptorProto> iterable) {
                f();
                ((FileDescriptorProto) this.f33398b).j1(iterable);
                return this;
            }

            public Builder addAllPublicDependency(Iterable<? extends Integer> iterable) {
                f();
                ((FileDescriptorProto) this.f33398b).k1(iterable);
                return this;
            }

            public Builder addAllService(Iterable<? extends ServiceDescriptorProto> iterable) {
                f();
                ((FileDescriptorProto) this.f33398b).l1(iterable);
                return this;
            }

            public Builder addAllWeakDependency(Iterable<? extends Integer> iterable) {
                f();
                ((FileDescriptorProto) this.f33398b).m1(iterable);
                return this;
            }

            public Builder addDependency(String str) {
                f();
                ((FileDescriptorProto) this.f33398b).n1(str);
                return this;
            }

            public Builder addDependencyBytes(ByteString byteString) {
                f();
                ((FileDescriptorProto) this.f33398b).o1(byteString);
                return this;
            }

            public Builder addEnumType(EnumDescriptorProto enumDescriptorProto) {
                f();
                ((FileDescriptorProto) this.f33398b).q1(enumDescriptorProto);
                return this;
            }

            public Builder addExtension(FieldDescriptorProto fieldDescriptorProto) {
                f();
                ((FileDescriptorProto) this.f33398b).s1(fieldDescriptorProto);
                return this;
            }

            public Builder addMessageType(DescriptorProto descriptorProto) {
                f();
                ((FileDescriptorProto) this.f33398b).u1(descriptorProto);
                return this;
            }

            public Builder addPublicDependency(int i4) {
                f();
                ((FileDescriptorProto) this.f33398b).v1(i4);
                return this;
            }

            public Builder addService(ServiceDescriptorProto serviceDescriptorProto) {
                f();
                ((FileDescriptorProto) this.f33398b).x1(serviceDescriptorProto);
                return this;
            }

            public Builder addWeakDependency(int i4) {
                f();
                ((FileDescriptorProto) this.f33398b).y1(i4);
                return this;
            }

            public Builder clearDependency() {
                f();
                ((FileDescriptorProto) this.f33398b).z1();
                return this;
            }

            public Builder clearEnumType() {
                f();
                ((FileDescriptorProto) this.f33398b).A1();
                return this;
            }

            public Builder clearExtension() {
                f();
                ((FileDescriptorProto) this.f33398b).B1();
                return this;
            }

            public Builder clearMessageType() {
                f();
                ((FileDescriptorProto) this.f33398b).C1();
                return this;
            }

            public Builder clearName() {
                f();
                ((FileDescriptorProto) this.f33398b).D1();
                return this;
            }

            public Builder clearOptions() {
                f();
                ((FileDescriptorProto) this.f33398b).E1();
                return this;
            }

            public Builder clearPackage() {
                f();
                ((FileDescriptorProto) this.f33398b).F1();
                return this;
            }

            public Builder clearPublicDependency() {
                f();
                ((FileDescriptorProto) this.f33398b).G1();
                return this;
            }

            public Builder clearService() {
                f();
                ((FileDescriptorProto) this.f33398b).H1();
                return this;
            }

            public Builder clearSourceCodeInfo() {
                f();
                ((FileDescriptorProto) this.f33398b).I1();
                return this;
            }

            public Builder clearSyntax() {
                f();
                ((FileDescriptorProto) this.f33398b).J1();
                return this;
            }

            public Builder clearWeakDependency() {
                f();
                ((FileDescriptorProto) this.f33398b).K1();
                return this;
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public String getDependency(int i4) {
                return ((FileDescriptorProto) this.f33398b).getDependency(i4);
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public ByteString getDependencyBytes(int i4) {
                return ((FileDescriptorProto) this.f33398b).getDependencyBytes(i4);
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public int getDependencyCount() {
                return ((FileDescriptorProto) this.f33398b).getDependencyCount();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public List<String> getDependencyList() {
                return Collections.unmodifiableList(((FileDescriptorProto) this.f33398b).getDependencyList());
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public EnumDescriptorProto getEnumType(int i4) {
                return ((FileDescriptorProto) this.f33398b).getEnumType(i4);
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public int getEnumTypeCount() {
                return ((FileDescriptorProto) this.f33398b).getEnumTypeCount();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public List<EnumDescriptorProto> getEnumTypeList() {
                return Collections.unmodifiableList(((FileDescriptorProto) this.f33398b).getEnumTypeList());
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public FieldDescriptorProto getExtension(int i4) {
                return ((FileDescriptorProto) this.f33398b).getExtension(i4);
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public int getExtensionCount() {
                return ((FileDescriptorProto) this.f33398b).getExtensionCount();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public List<FieldDescriptorProto> getExtensionList() {
                return Collections.unmodifiableList(((FileDescriptorProto) this.f33398b).getExtensionList());
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public DescriptorProto getMessageType(int i4) {
                return ((FileDescriptorProto) this.f33398b).getMessageType(i4);
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public int getMessageTypeCount() {
                return ((FileDescriptorProto) this.f33398b).getMessageTypeCount();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public List<DescriptorProto> getMessageTypeList() {
                return Collections.unmodifiableList(((FileDescriptorProto) this.f33398b).getMessageTypeList());
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public String getName() {
                return ((FileDescriptorProto) this.f33398b).getName();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public ByteString getNameBytes() {
                return ((FileDescriptorProto) this.f33398b).getNameBytes();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public FileOptions getOptions() {
                return ((FileDescriptorProto) this.f33398b).getOptions();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public String getPackage() {
                return ((FileDescriptorProto) this.f33398b).getPackage();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public ByteString getPackageBytes() {
                return ((FileDescriptorProto) this.f33398b).getPackageBytes();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public int getPublicDependency(int i4) {
                return ((FileDescriptorProto) this.f33398b).getPublicDependency(i4);
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public int getPublicDependencyCount() {
                return ((FileDescriptorProto) this.f33398b).getPublicDependencyCount();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public List<Integer> getPublicDependencyList() {
                return Collections.unmodifiableList(((FileDescriptorProto) this.f33398b).getPublicDependencyList());
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public ServiceDescriptorProto getService(int i4) {
                return ((FileDescriptorProto) this.f33398b).getService(i4);
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public int getServiceCount() {
                return ((FileDescriptorProto) this.f33398b).getServiceCount();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public List<ServiceDescriptorProto> getServiceList() {
                return Collections.unmodifiableList(((FileDescriptorProto) this.f33398b).getServiceList());
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public SourceCodeInfo getSourceCodeInfo() {
                return ((FileDescriptorProto) this.f33398b).getSourceCodeInfo();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public String getSyntax() {
                return ((FileDescriptorProto) this.f33398b).getSyntax();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public ByteString getSyntaxBytes() {
                return ((FileDescriptorProto) this.f33398b).getSyntaxBytes();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public int getWeakDependency(int i4) {
                return ((FileDescriptorProto) this.f33398b).getWeakDependency(i4);
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public int getWeakDependencyCount() {
                return ((FileDescriptorProto) this.f33398b).getWeakDependencyCount();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public List<Integer> getWeakDependencyList() {
                return Collections.unmodifiableList(((FileDescriptorProto) this.f33398b).getWeakDependencyList());
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public boolean hasName() {
                return ((FileDescriptorProto) this.f33398b).hasName();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public boolean hasOptions() {
                return ((FileDescriptorProto) this.f33398b).hasOptions();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public boolean hasPackage() {
                return ((FileDescriptorProto) this.f33398b).hasPackage();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public boolean hasSourceCodeInfo() {
                return ((FileDescriptorProto) this.f33398b).hasSourceCodeInfo();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public boolean hasSyntax() {
                return ((FileDescriptorProto) this.f33398b).hasSyntax();
            }

            public Builder mergeOptions(FileOptions fileOptions) {
                f();
                ((FileDescriptorProto) this.f33398b).S1(fileOptions);
                return this;
            }

            public Builder mergeSourceCodeInfo(SourceCodeInfo sourceCodeInfo) {
                f();
                ((FileDescriptorProto) this.f33398b).T1(sourceCodeInfo);
                return this;
            }

            public Builder removeEnumType(int i4) {
                f();
                ((FileDescriptorProto) this.f33398b).U1(i4);
                return this;
            }

            public Builder removeExtension(int i4) {
                f();
                ((FileDescriptorProto) this.f33398b).V1(i4);
                return this;
            }

            public Builder removeMessageType(int i4) {
                f();
                ((FileDescriptorProto) this.f33398b).W1(i4);
                return this;
            }

            public Builder removeService(int i4) {
                f();
                ((FileDescriptorProto) this.f33398b).X1(i4);
                return this;
            }

            public Builder setDependency(int i4, String str) {
                f();
                ((FileDescriptorProto) this.f33398b).Y1(i4, str);
                return this;
            }

            public Builder setEnumType(int i4, EnumDescriptorProto enumDescriptorProto) {
                f();
                ((FileDescriptorProto) this.f33398b).Z1(i4, enumDescriptorProto);
                return this;
            }

            public Builder setExtension(int i4, FieldDescriptorProto fieldDescriptorProto) {
                f();
                ((FileDescriptorProto) this.f33398b).a2(i4, fieldDescriptorProto);
                return this;
            }

            public Builder setMessageType(int i4, DescriptorProto descriptorProto) {
                f();
                ((FileDescriptorProto) this.f33398b).b2(i4, descriptorProto);
                return this;
            }

            public Builder setName(String str) {
                f();
                ((FileDescriptorProto) this.f33398b).c2(str);
                return this;
            }

            public Builder setNameBytes(ByteString byteString) {
                f();
                ((FileDescriptorProto) this.f33398b).d2(byteString);
                return this;
            }

            public Builder setOptions(FileOptions fileOptions) {
                f();
                ((FileDescriptorProto) this.f33398b).e2(fileOptions);
                return this;
            }

            public Builder setPackage(String str) {
                f();
                ((FileDescriptorProto) this.f33398b).f2(str);
                return this;
            }

            public Builder setPackageBytes(ByteString byteString) {
                f();
                ((FileDescriptorProto) this.f33398b).g2(byteString);
                return this;
            }

            public Builder setPublicDependency(int i4, int i5) {
                f();
                ((FileDescriptorProto) this.f33398b).h2(i4, i5);
                return this;
            }

            public Builder setService(int i4, ServiceDescriptorProto serviceDescriptorProto) {
                f();
                ((FileDescriptorProto) this.f33398b).i2(i4, serviceDescriptorProto);
                return this;
            }

            public Builder setSourceCodeInfo(SourceCodeInfo sourceCodeInfo) {
                f();
                ((FileDescriptorProto) this.f33398b).j2(sourceCodeInfo);
                return this;
            }

            public Builder setSyntax(String str) {
                f();
                ((FileDescriptorProto) this.f33398b).k2(str);
                return this;
            }

            public Builder setSyntaxBytes(ByteString byteString) {
                f();
                ((FileDescriptorProto) this.f33398b).l2(byteString);
                return this;
            }

            public Builder setWeakDependency(int i4, int i5) {
                f();
                ((FileDescriptorProto) this.f33398b).m2(i4, i5);
                return this;
            }

            private Builder() {
                super(FileDescriptorProto.DEFAULT_INSTANCE);
            }

            public Builder addEnumType(int i4, EnumDescriptorProto enumDescriptorProto) {
                f();
                ((FileDescriptorProto) this.f33398b).p1(i4, enumDescriptorProto);
                return this;
            }

            public Builder addExtension(int i4, FieldDescriptorProto fieldDescriptorProto) {
                f();
                ((FileDescriptorProto) this.f33398b).r1(i4, fieldDescriptorProto);
                return this;
            }

            public Builder addMessageType(int i4, DescriptorProto descriptorProto) {
                f();
                ((FileDescriptorProto) this.f33398b).t1(i4, descriptorProto);
                return this;
            }

            public Builder addService(int i4, ServiceDescriptorProto serviceDescriptorProto) {
                f();
                ((FileDescriptorProto) this.f33398b).w1(i4, serviceDescriptorProto);
                return this;
            }

            public Builder setEnumType(int i4, EnumDescriptorProto.Builder builder) {
                f();
                ((FileDescriptorProto) this.f33398b).Z1(i4, builder.build());
                return this;
            }

            public Builder setExtension(int i4, FieldDescriptorProto.Builder builder) {
                f();
                ((FileDescriptorProto) this.f33398b).a2(i4, builder.build());
                return this;
            }

            public Builder setMessageType(int i4, DescriptorProto.Builder builder) {
                f();
                ((FileDescriptorProto) this.f33398b).b2(i4, builder.build());
                return this;
            }

            public Builder setOptions(FileOptions.Builder builder) {
                f();
                ((FileDescriptorProto) this.f33398b).e2((FileOptions) builder.build());
                return this;
            }

            public Builder setService(int i4, ServiceDescriptorProto.Builder builder) {
                f();
                ((FileDescriptorProto) this.f33398b).i2(i4, builder.build());
                return this;
            }

            public Builder setSourceCodeInfo(SourceCodeInfo.Builder builder) {
                f();
                ((FileDescriptorProto) this.f33398b).j2(builder.build());
                return this;
            }

            public Builder addEnumType(EnumDescriptorProto.Builder builder) {
                f();
                ((FileDescriptorProto) this.f33398b).q1(builder.build());
                return this;
            }

            public Builder addExtension(FieldDescriptorProto.Builder builder) {
                f();
                ((FileDescriptorProto) this.f33398b).s1(builder.build());
                return this;
            }

            public Builder addMessageType(DescriptorProto.Builder builder) {
                f();
                ((FileDescriptorProto) this.f33398b).u1(builder.build());
                return this;
            }

            public Builder addService(ServiceDescriptorProto.Builder builder) {
                f();
                ((FileDescriptorProto) this.f33398b).x1(builder.build());
                return this;
            }

            public Builder addEnumType(int i4, EnumDescriptorProto.Builder builder) {
                f();
                ((FileDescriptorProto) this.f33398b).p1(i4, builder.build());
                return this;
            }

            public Builder addExtension(int i4, FieldDescriptorProto.Builder builder) {
                f();
                ((FileDescriptorProto) this.f33398b).r1(i4, builder.build());
                return this;
            }

            public Builder addMessageType(int i4, DescriptorProto.Builder builder) {
                f();
                ((FileDescriptorProto) this.f33398b).t1(i4, builder.build());
                return this;
            }

            public Builder addService(int i4, ServiceDescriptorProto.Builder builder) {
                f();
                ((FileDescriptorProto) this.f33398b).w1(i4, builder.build());
                return this;
            }
        }

        static {
            FileDescriptorProto fileDescriptorProto = new FileDescriptorProto();
            DEFAULT_INSTANCE = fileDescriptorProto;
            GeneratedMessageLite.d0(FileDescriptorProto.class, fileDescriptorProto);
        }

        private FileDescriptorProto() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void A1() {
            this.enumType_ = GeneratedMessageLite.y();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void B1() {
            this.extension_ = GeneratedMessageLite.y();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void C1() {
            this.messageType_ = GeneratedMessageLite.y();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void D1() {
            this.bitField0_ &= -2;
            this.name_ = getDefaultInstance().getName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void E1() {
            this.options_ = null;
            this.bitField0_ &= -5;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void F1() {
            this.bitField0_ &= -3;
            this.package_ = getDefaultInstance().getPackage();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void G1() {
            this.publicDependency_ = GeneratedMessageLite.w();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void H1() {
            this.service_ = GeneratedMessageLite.y();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void I1() {
            this.sourceCodeInfo_ = null;
            this.bitField0_ &= -9;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void J1() {
            this.bitField0_ &= -17;
            this.syntax_ = getDefaultInstance().getSyntax();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void K1() {
            this.weakDependency_ = GeneratedMessageLite.w();
        }

        private void L1() {
            Internal.ProtobufList<String> protobufList = this.dependency_;
            if (!protobufList.isModifiable()) {
                this.dependency_ = GeneratedMessageLite.K(protobufList);
            }
        }

        private void M1() {
            Internal.ProtobufList<EnumDescriptorProto> protobufList = this.enumType_;
            if (!protobufList.isModifiable()) {
                this.enumType_ = GeneratedMessageLite.K(protobufList);
            }
        }

        private void N1() {
            Internal.ProtobufList<FieldDescriptorProto> protobufList = this.extension_;
            if (!protobufList.isModifiable()) {
                this.extension_ = GeneratedMessageLite.K(protobufList);
            }
        }

        private void O1() {
            Internal.ProtobufList<DescriptorProto> protobufList = this.messageType_;
            if (!protobufList.isModifiable()) {
                this.messageType_ = GeneratedMessageLite.K(protobufList);
            }
        }

        private void P1() {
            Internal.IntList intList = this.publicDependency_;
            if (!intList.isModifiable()) {
                this.publicDependency_ = GeneratedMessageLite.I(intList);
            }
        }

        private void Q1() {
            Internal.ProtobufList<ServiceDescriptorProto> protobufList = this.service_;
            if (!protobufList.isModifiable()) {
                this.service_ = GeneratedMessageLite.K(protobufList);
            }
        }

        private void R1() {
            Internal.IntList intList = this.weakDependency_;
            if (!intList.isModifiable()) {
                this.weakDependency_ = GeneratedMessageLite.I(intList);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void S1(FileOptions fileOptions) {
            fileOptions.getClass();
            FileOptions fileOptions2 = this.options_;
            if (fileOptions2 != null && fileOptions2 != FileOptions.getDefaultInstance()) {
                this.options_ = ((FileOptions.Builder) FileOptions.newBuilder(this.options_).mergeFrom((FileOptions.Builder) fileOptions)).buildPartial();
            } else {
                this.options_ = fileOptions;
            }
            this.bitField0_ |= 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void T1(SourceCodeInfo sourceCodeInfo) {
            sourceCodeInfo.getClass();
            SourceCodeInfo sourceCodeInfo2 = this.sourceCodeInfo_;
            if (sourceCodeInfo2 != null && sourceCodeInfo2 != SourceCodeInfo.getDefaultInstance()) {
                this.sourceCodeInfo_ = SourceCodeInfo.newBuilder(this.sourceCodeInfo_).mergeFrom((SourceCodeInfo.Builder) sourceCodeInfo).buildPartial();
            } else {
                this.sourceCodeInfo_ = sourceCodeInfo;
            }
            this.bitField0_ |= 8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void U1(int i4) {
            M1();
            this.enumType_.remove(i4);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void V1(int i4) {
            N1();
            this.extension_.remove(i4);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void W1(int i4) {
            O1();
            this.messageType_.remove(i4);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void X1(int i4) {
            Q1();
            this.service_.remove(i4);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Y1(int i4, String str) {
            str.getClass();
            L1();
            this.dependency_.set(i4, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Z1(int i4, EnumDescriptorProto enumDescriptorProto) {
            enumDescriptorProto.getClass();
            M1();
            this.enumType_.set(i4, enumDescriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a2(int i4, FieldDescriptorProto fieldDescriptorProto) {
            fieldDescriptorProto.getClass();
            N1();
            this.extension_.set(i4, fieldDescriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b2(int i4, DescriptorProto descriptorProto) {
            descriptorProto.getClass();
            O1();
            this.messageType_.set(i4, descriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c2(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.name_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d2(ByteString byteString) {
            this.name_ = byteString.toStringUtf8();
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e2(FileOptions fileOptions) {
            fileOptions.getClass();
            this.options_ = fileOptions;
            this.bitField0_ |= 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void f2(String str) {
            str.getClass();
            this.bitField0_ |= 2;
            this.package_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g1(Iterable<String> iterable) {
            L1();
            AbstractMessageLite.a(iterable, this.dependency_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g2(ByteString byteString) {
            this.package_ = byteString.toStringUtf8();
            this.bitField0_ |= 2;
        }

        public static FileDescriptorProto getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void h1(Iterable<? extends EnumDescriptorProto> iterable) {
            M1();
            AbstractMessageLite.a(iterable, this.enumType_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void h2(int i4, int i5) {
            P1();
            this.publicDependency_.setInt(i4, i5);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void i1(Iterable<? extends FieldDescriptorProto> iterable) {
            N1();
            AbstractMessageLite.a(iterable, this.extension_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void i2(int i4, ServiceDescriptorProto serviceDescriptorProto) {
            serviceDescriptorProto.getClass();
            Q1();
            this.service_.set(i4, serviceDescriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j1(Iterable<? extends DescriptorProto> iterable) {
            O1();
            AbstractMessageLite.a(iterable, this.messageType_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j2(SourceCodeInfo sourceCodeInfo) {
            sourceCodeInfo.getClass();
            this.sourceCodeInfo_ = sourceCodeInfo;
            this.bitField0_ |= 8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void k1(Iterable<? extends Integer> iterable) {
            P1();
            AbstractMessageLite.a(iterable, this.publicDependency_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void k2(String str) {
            str.getClass();
            this.bitField0_ |= 16;
            this.syntax_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void l1(Iterable<? extends ServiceDescriptorProto> iterable) {
            Q1();
            AbstractMessageLite.a(iterable, this.service_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void l2(ByteString byteString) {
            this.syntax_ = byteString.toStringUtf8();
            this.bitField0_ |= 16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void m1(Iterable<? extends Integer> iterable) {
            R1();
            AbstractMessageLite.a(iterable, this.weakDependency_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void m2(int i4, int i5) {
            R1();
            this.weakDependency_.setInt(i4, i5);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n1(String str) {
            str.getClass();
            L1();
            this.dependency_.add(str);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.q();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void o1(ByteString byteString) {
            L1();
            this.dependency_.add(byteString.toStringUtf8());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void p1(int i4, EnumDescriptorProto enumDescriptorProto) {
            enumDescriptorProto.getClass();
            M1();
            this.enumType_.add(i4, enumDescriptorProto);
        }

        public static FileDescriptorProto parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (FileDescriptorProto) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
        }

        public static FileDescriptorProto parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (FileDescriptorProto) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<FileDescriptorProto> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void q1(EnumDescriptorProto enumDescriptorProto) {
            enumDescriptorProto.getClass();
            M1();
            this.enumType_.add(enumDescriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void r1(int i4, FieldDescriptorProto fieldDescriptorProto) {
            fieldDescriptorProto.getClass();
            N1();
            this.extension_.add(i4, fieldDescriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s1(FieldDescriptorProto fieldDescriptorProto) {
            fieldDescriptorProto.getClass();
            N1();
            this.extension_.add(fieldDescriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void t1(int i4, DescriptorProto descriptorProto) {
            descriptorProto.getClass();
            O1();
            this.messageType_.add(i4, descriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void u1(DescriptorProto descriptorProto) {
            descriptorProto.getClass();
            O1();
            this.messageType_.add(descriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void v1(int i4) {
            P1();
            this.publicDependency_.addInt(i4);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void w1(int i4, ServiceDescriptorProto serviceDescriptorProto) {
            serviceDescriptorProto.getClass();
            Q1();
            this.service_.add(i4, serviceDescriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void x1(ServiceDescriptorProto serviceDescriptorProto) {
            serviceDescriptorProto.getClass();
            Q1();
            this.service_.add(serviceDescriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void y1(int i4) {
            R1();
            this.weakDependency_.addInt(i4);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void z1() {
            this.dependency_ = GeneratedMessageLite.y();
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public String getDependency(int i4) {
            return this.dependency_.get(i4);
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public ByteString getDependencyBytes(int i4) {
            return ByteString.copyFromUtf8(this.dependency_.get(i4));
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public int getDependencyCount() {
            return this.dependency_.size();
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public List<String> getDependencyList() {
            return this.dependency_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public EnumDescriptorProto getEnumType(int i4) {
            return this.enumType_.get(i4);
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public int getEnumTypeCount() {
            return this.enumType_.size();
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public List<EnumDescriptorProto> getEnumTypeList() {
            return this.enumType_;
        }

        public EnumDescriptorProtoOrBuilder getEnumTypeOrBuilder(int i4) {
            return this.enumType_.get(i4);
        }

        public List<? extends EnumDescriptorProtoOrBuilder> getEnumTypeOrBuilderList() {
            return this.enumType_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public FieldDescriptorProto getExtension(int i4) {
            return this.extension_.get(i4);
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public int getExtensionCount() {
            return this.extension_.size();
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public List<FieldDescriptorProto> getExtensionList() {
            return this.extension_;
        }

        public FieldDescriptorProtoOrBuilder getExtensionOrBuilder(int i4) {
            return this.extension_.get(i4);
        }

        public List<? extends FieldDescriptorProtoOrBuilder> getExtensionOrBuilderList() {
            return this.extension_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public DescriptorProto getMessageType(int i4) {
            return this.messageType_.get(i4);
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public int getMessageTypeCount() {
            return this.messageType_.size();
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public List<DescriptorProto> getMessageTypeList() {
            return this.messageType_;
        }

        public DescriptorProtoOrBuilder getMessageTypeOrBuilder(int i4) {
            return this.messageType_.get(i4);
        }

        public List<? extends DescriptorProtoOrBuilder> getMessageTypeOrBuilderList() {
            return this.messageType_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public String getName() {
            return this.name_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public ByteString getNameBytes() {
            return ByteString.copyFromUtf8(this.name_);
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public FileOptions getOptions() {
            FileOptions fileOptions = this.options_;
            if (fileOptions == null) {
                return FileOptions.getDefaultInstance();
            }
            return fileOptions;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public String getPackage() {
            return this.package_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public ByteString getPackageBytes() {
            return ByteString.copyFromUtf8(this.package_);
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public int getPublicDependency(int i4) {
            return this.publicDependency_.getInt(i4);
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public int getPublicDependencyCount() {
            return this.publicDependency_.size();
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public List<Integer> getPublicDependencyList() {
            return this.publicDependency_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public ServiceDescriptorProto getService(int i4) {
            return this.service_.get(i4);
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public int getServiceCount() {
            return this.service_.size();
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public List<ServiceDescriptorProto> getServiceList() {
            return this.service_;
        }

        public ServiceDescriptorProtoOrBuilder getServiceOrBuilder(int i4) {
            return this.service_.get(i4);
        }

        public List<? extends ServiceDescriptorProtoOrBuilder> getServiceOrBuilderList() {
            return this.service_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public SourceCodeInfo getSourceCodeInfo() {
            SourceCodeInfo sourceCodeInfo = this.sourceCodeInfo_;
            if (sourceCodeInfo == null) {
                return SourceCodeInfo.getDefaultInstance();
            }
            return sourceCodeInfo;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public String getSyntax() {
            return this.syntax_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public ByteString getSyntaxBytes() {
            return ByteString.copyFromUtf8(this.syntax_);
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public int getWeakDependency(int i4) {
            return this.weakDependency_.getInt(i4);
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public int getWeakDependencyCount() {
            return this.weakDependency_.size();
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public List<Integer> getWeakDependencyList() {
            return this.weakDependency_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public boolean hasName() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public boolean hasOptions() {
            if ((this.bitField0_ & 4) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public boolean hasPackage() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public boolean hasSourceCodeInfo() {
            if ((this.bitField0_ & 8) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public boolean hasSyntax() {
            if ((this.bitField0_ & 16) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            int i4 = 1;
            switch (AnonymousClass1.f33300a[methodToInvoke.ordinal()]) {
                case 1:
                    return new FileDescriptorProto();
                case 2:
                    return new Builder(null);
                case 3:
                    return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0001\f\u0000\u0001\u0001\f\f\u0000\u0007\u0005\u0001ဈ\u0000\u0002ဈ\u0001\u0003\u001a\u0004Л\u0005Л\u0006Л\u0007Л\bᐉ\u0002\tဉ\u0003\n\u0016\u000b\u0016\fဈ\u0004", new Object[]{"bitField0_", "name_", "package_", "dependency_", "messageType_", DescriptorProto.class, "enumType_", EnumDescriptorProto.class, "service_", ServiceDescriptorProto.class, "extension_", FieldDescriptorProto.class, "options_", "sourceCodeInfo_", "publicDependency_", "weakDependency_", "syntax_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<FileDescriptorProto> parser = PARSER;
                    if (parser == null) {
                        synchronized (FileDescriptorProto.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case 6:
                    return Byte.valueOf(this.memoizedIsInitialized);
                case 7:
                    if (obj == null) {
                        i4 = 0;
                    }
                    this.memoizedIsInitialized = (byte) i4;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static Builder newBuilder(FileDescriptorProto fileDescriptorProto) {
            return DEFAULT_INSTANCE.r(fileDescriptorProto);
        }

        public static FileDescriptorProto parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (FileDescriptorProto) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static FileDescriptorProto parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (FileDescriptorProto) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static FileDescriptorProto parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (FileDescriptorProto) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
        }

        public static FileDescriptorProto parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (FileDescriptorProto) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static FileDescriptorProto parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (FileDescriptorProto) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
        }

        public static FileDescriptorProto parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (FileDescriptorProto) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static FileDescriptorProto parseFrom(InputStream inputStream) throws IOException {
            return (FileDescriptorProto) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
        }

        public static FileDescriptorProto parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (FileDescriptorProto) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static FileDescriptorProto parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (FileDescriptorProto) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
        }

        public static FileDescriptorProto parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (FileDescriptorProto) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: classes6.dex */
    public interface FileDescriptorProtoOrBuilder extends MessageLiteOrBuilder {
        String getDependency(int i4);

        ByteString getDependencyBytes(int i4);

        int getDependencyCount();

        List<String> getDependencyList();

        EnumDescriptorProto getEnumType(int i4);

        int getEnumTypeCount();

        List<EnumDescriptorProto> getEnumTypeList();

        FieldDescriptorProto getExtension(int i4);

        int getExtensionCount();

        List<FieldDescriptorProto> getExtensionList();

        DescriptorProto getMessageType(int i4);

        int getMessageTypeCount();

        List<DescriptorProto> getMessageTypeList();

        String getName();

        ByteString getNameBytes();

        FileOptions getOptions();

        String getPackage();

        ByteString getPackageBytes();

        int getPublicDependency(int i4);

        int getPublicDependencyCount();

        List<Integer> getPublicDependencyList();

        ServiceDescriptorProto getService(int i4);

        int getServiceCount();

        List<ServiceDescriptorProto> getServiceList();

        SourceCodeInfo getSourceCodeInfo();

        String getSyntax();

        ByteString getSyntaxBytes();

        int getWeakDependency(int i4);

        int getWeakDependencyCount();

        List<Integer> getWeakDependencyList();

        boolean hasName();

        boolean hasOptions();

        boolean hasPackage();

        boolean hasSourceCodeInfo();

        boolean hasSyntax();
    }

    /* loaded from: classes6.dex */
    public static final class FileDescriptorSet extends GeneratedMessageLite<FileDescriptorSet, Builder> implements FileDescriptorSetOrBuilder {
        private static final FileDescriptorSet DEFAULT_INSTANCE;
        public static final int FILE_FIELD_NUMBER = 1;
        private static volatile Parser<FileDescriptorSet> PARSER;
        private byte memoizedIsInitialized = 2;
        private Internal.ProtobufList<FileDescriptorProto> file_ = GeneratedMessageLite.y();

        /* loaded from: classes6.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<FileDescriptorSet, Builder> implements FileDescriptorSetOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder addAllFile(Iterable<? extends FileDescriptorProto> iterable) {
                f();
                ((FileDescriptorSet) this.f33398b).m0(iterable);
                return this;
            }

            public Builder addFile(FileDescriptorProto fileDescriptorProto) {
                f();
                ((FileDescriptorSet) this.f33398b).o0(fileDescriptorProto);
                return this;
            }

            public Builder clearFile() {
                f();
                ((FileDescriptorSet) this.f33398b).p0();
                return this;
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorSetOrBuilder
            public FileDescriptorProto getFile(int i4) {
                return ((FileDescriptorSet) this.f33398b).getFile(i4);
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorSetOrBuilder
            public int getFileCount() {
                return ((FileDescriptorSet) this.f33398b).getFileCount();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorSetOrBuilder
            public List<FileDescriptorProto> getFileList() {
                return Collections.unmodifiableList(((FileDescriptorSet) this.f33398b).getFileList());
            }

            public Builder removeFile(int i4) {
                f();
                ((FileDescriptorSet) this.f33398b).r0(i4);
                return this;
            }

            public Builder setFile(int i4, FileDescriptorProto fileDescriptorProto) {
                f();
                ((FileDescriptorSet) this.f33398b).s0(i4, fileDescriptorProto);
                return this;
            }

            private Builder() {
                super(FileDescriptorSet.DEFAULT_INSTANCE);
            }

            public Builder addFile(int i4, FileDescriptorProto fileDescriptorProto) {
                f();
                ((FileDescriptorSet) this.f33398b).n0(i4, fileDescriptorProto);
                return this;
            }

            public Builder setFile(int i4, FileDescriptorProto.Builder builder) {
                f();
                ((FileDescriptorSet) this.f33398b).s0(i4, builder.build());
                return this;
            }

            public Builder addFile(FileDescriptorProto.Builder builder) {
                f();
                ((FileDescriptorSet) this.f33398b).o0(builder.build());
                return this;
            }

            public Builder addFile(int i4, FileDescriptorProto.Builder builder) {
                f();
                ((FileDescriptorSet) this.f33398b).n0(i4, builder.build());
                return this;
            }
        }

        static {
            FileDescriptorSet fileDescriptorSet = new FileDescriptorSet();
            DEFAULT_INSTANCE = fileDescriptorSet;
            GeneratedMessageLite.d0(FileDescriptorSet.class, fileDescriptorSet);
        }

        private FileDescriptorSet() {
        }

        public static FileDescriptorSet getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void m0(Iterable<? extends FileDescriptorProto> iterable) {
            q0();
            AbstractMessageLite.a(iterable, this.file_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n0(int i4, FileDescriptorProto fileDescriptorProto) {
            fileDescriptorProto.getClass();
            q0();
            this.file_.add(i4, fileDescriptorProto);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.q();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void o0(FileDescriptorProto fileDescriptorProto) {
            fileDescriptorProto.getClass();
            q0();
            this.file_.add(fileDescriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void p0() {
            this.file_ = GeneratedMessageLite.y();
        }

        public static FileDescriptorSet parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (FileDescriptorSet) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
        }

        public static FileDescriptorSet parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (FileDescriptorSet) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<FileDescriptorSet> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        private void q0() {
            Internal.ProtobufList<FileDescriptorProto> protobufList = this.file_;
            if (!protobufList.isModifiable()) {
                this.file_ = GeneratedMessageLite.K(protobufList);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void r0(int i4) {
            q0();
            this.file_.remove(i4);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s0(int i4, FileDescriptorProto fileDescriptorProto) {
            fileDescriptorProto.getClass();
            q0();
            this.file_.set(i4, fileDescriptorProto);
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorSetOrBuilder
        public FileDescriptorProto getFile(int i4) {
            return this.file_.get(i4);
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorSetOrBuilder
        public int getFileCount() {
            return this.file_.size();
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorSetOrBuilder
        public List<FileDescriptorProto> getFileList() {
            return this.file_;
        }

        public FileDescriptorProtoOrBuilder getFileOrBuilder(int i4) {
            return this.file_.get(i4);
        }

        public List<? extends FileDescriptorProtoOrBuilder> getFileOrBuilderList() {
            return this.file_;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            int i4 = 1;
            switch (AnonymousClass1.f33300a[methodToInvoke.ordinal()]) {
                case 1:
                    return new FileDescriptorSet();
                case 2:
                    return new Builder(null);
                case 3:
                    return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0001Л", new Object[]{"file_", FileDescriptorProto.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<FileDescriptorSet> parser = PARSER;
                    if (parser == null) {
                        synchronized (FileDescriptorSet.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case 6:
                    return Byte.valueOf(this.memoizedIsInitialized);
                case 7:
                    if (obj == null) {
                        i4 = 0;
                    }
                    this.memoizedIsInitialized = (byte) i4;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static Builder newBuilder(FileDescriptorSet fileDescriptorSet) {
            return DEFAULT_INSTANCE.r(fileDescriptorSet);
        }

        public static FileDescriptorSet parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (FileDescriptorSet) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static FileDescriptorSet parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (FileDescriptorSet) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static FileDescriptorSet parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (FileDescriptorSet) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
        }

        public static FileDescriptorSet parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (FileDescriptorSet) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static FileDescriptorSet parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (FileDescriptorSet) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
        }

        public static FileDescriptorSet parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (FileDescriptorSet) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static FileDescriptorSet parseFrom(InputStream inputStream) throws IOException {
            return (FileDescriptorSet) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
        }

        public static FileDescriptorSet parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (FileDescriptorSet) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static FileDescriptorSet parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (FileDescriptorSet) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
        }

        public static FileDescriptorSet parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (FileDescriptorSet) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: classes6.dex */
    public interface FileDescriptorSetOrBuilder extends MessageLiteOrBuilder {
        FileDescriptorProto getFile(int i4);

        int getFileCount();

        List<FileDescriptorProto> getFileList();
    }

    /* loaded from: classes6.dex */
    public static final class FileOptions extends GeneratedMessageLite.ExtendableMessage<FileOptions, Builder> implements FileOptionsOrBuilder {
        public static final int CC_ENABLE_ARENAS_FIELD_NUMBER = 31;
        public static final int CC_GENERIC_SERVICES_FIELD_NUMBER = 16;
        public static final int CSHARP_NAMESPACE_FIELD_NUMBER = 37;
        private static final FileOptions DEFAULT_INSTANCE;
        public static final int DEPRECATED_FIELD_NUMBER = 23;
        public static final int GO_PACKAGE_FIELD_NUMBER = 11;
        public static final int JAVA_GENERATE_EQUALS_AND_HASH_FIELD_NUMBER = 20;
        public static final int JAVA_GENERIC_SERVICES_FIELD_NUMBER = 17;
        public static final int JAVA_MULTIPLE_FILES_FIELD_NUMBER = 10;
        public static final int JAVA_OUTER_CLASSNAME_FIELD_NUMBER = 8;
        public static final int JAVA_PACKAGE_FIELD_NUMBER = 1;
        public static final int JAVA_STRING_CHECK_UTF8_FIELD_NUMBER = 27;
        public static final int OBJC_CLASS_PREFIX_FIELD_NUMBER = 36;
        public static final int OPTIMIZE_FOR_FIELD_NUMBER = 9;
        private static volatile Parser<FileOptions> PARSER = null;
        public static final int PHP_CLASS_PREFIX_FIELD_NUMBER = 40;
        public static final int PHP_GENERIC_SERVICES_FIELD_NUMBER = 42;
        public static final int PHP_METADATA_NAMESPACE_FIELD_NUMBER = 44;
        public static final int PHP_NAMESPACE_FIELD_NUMBER = 41;
        public static final int PY_GENERIC_SERVICES_FIELD_NUMBER = 18;
        public static final int RUBY_PACKAGE_FIELD_NUMBER = 45;
        public static final int SWIFT_PREFIX_FIELD_NUMBER = 39;
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        private int bitField0_;
        private boolean ccGenericServices_;
        private boolean deprecated_;
        private boolean javaGenerateEqualsAndHash_;
        private boolean javaGenericServices_;
        private boolean javaMultipleFiles_;
        private boolean javaStringCheckUtf8_;
        private boolean phpGenericServices_;
        private boolean pyGenericServices_;
        private byte memoizedIsInitialized = 2;
        private String javaPackage_ = "";
        private String javaOuterClassname_ = "";
        private int optimizeFor_ = 1;
        private String goPackage_ = "";
        private boolean ccEnableArenas_ = true;
        private String objcClassPrefix_ = "";
        private String csharpNamespace_ = "";
        private String swiftPrefix_ = "";
        private String phpClassPrefix_ = "";
        private String phpNamespace_ = "";
        private String phpMetadataNamespace_ = "";
        private String rubyPackage_ = "";
        private Internal.ProtobufList<UninterpretedOption> uninterpretedOption_ = GeneratedMessageLite.y();

        /* loaded from: classes6.dex */
        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<FileOptions, Builder> implements FileOptionsOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder addAllUninterpretedOption(Iterable<? extends UninterpretedOption> iterable) {
                f();
                ((FileOptions) this.f33398b).m1(iterable);
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption uninterpretedOption) {
                f();
                ((FileOptions) this.f33398b).o1(uninterpretedOption);
                return this;
            }

            public Builder clearCcEnableArenas() {
                f();
                ((FileOptions) this.f33398b).p1();
                return this;
            }

            public Builder clearCcGenericServices() {
                f();
                ((FileOptions) this.f33398b).q1();
                return this;
            }

            public Builder clearCsharpNamespace() {
                f();
                ((FileOptions) this.f33398b).r1();
                return this;
            }

            public Builder clearDeprecated() {
                f();
                ((FileOptions) this.f33398b).s1();
                return this;
            }

            public Builder clearGoPackage() {
                f();
                ((FileOptions) this.f33398b).t1();
                return this;
            }

            @Deprecated
            public Builder clearJavaGenerateEqualsAndHash() {
                f();
                ((FileOptions) this.f33398b).u1();
                return this;
            }

            public Builder clearJavaGenericServices() {
                f();
                ((FileOptions) this.f33398b).v1();
                return this;
            }

            public Builder clearJavaMultipleFiles() {
                f();
                ((FileOptions) this.f33398b).w1();
                return this;
            }

            public Builder clearJavaOuterClassname() {
                f();
                ((FileOptions) this.f33398b).x1();
                return this;
            }

            public Builder clearJavaPackage() {
                f();
                ((FileOptions) this.f33398b).y1();
                return this;
            }

            public Builder clearJavaStringCheckUtf8() {
                f();
                ((FileOptions) this.f33398b).z1();
                return this;
            }

            public Builder clearObjcClassPrefix() {
                f();
                ((FileOptions) this.f33398b).A1();
                return this;
            }

            public Builder clearOptimizeFor() {
                f();
                ((FileOptions) this.f33398b).B1();
                return this;
            }

            public Builder clearPhpClassPrefix() {
                f();
                ((FileOptions) this.f33398b).C1();
                return this;
            }

            public Builder clearPhpGenericServices() {
                f();
                ((FileOptions) this.f33398b).D1();
                return this;
            }

            public Builder clearPhpMetadataNamespace() {
                f();
                ((FileOptions) this.f33398b).E1();
                return this;
            }

            public Builder clearPhpNamespace() {
                f();
                ((FileOptions) this.f33398b).F1();
                return this;
            }

            public Builder clearPyGenericServices() {
                f();
                ((FileOptions) this.f33398b).G1();
                return this;
            }

            public Builder clearRubyPackage() {
                f();
                ((FileOptions) this.f33398b).H1();
                return this;
            }

            public Builder clearSwiftPrefix() {
                f();
                ((FileOptions) this.f33398b).I1();
                return this;
            }

            public Builder clearUninterpretedOption() {
                f();
                ((FileOptions) this.f33398b).J1();
                return this;
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean getCcEnableArenas() {
                return ((FileOptions) this.f33398b).getCcEnableArenas();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean getCcGenericServices() {
                return ((FileOptions) this.f33398b).getCcGenericServices();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public String getCsharpNamespace() {
                return ((FileOptions) this.f33398b).getCsharpNamespace();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public ByteString getCsharpNamespaceBytes() {
                return ((FileOptions) this.f33398b).getCsharpNamespaceBytes();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean getDeprecated() {
                return ((FileOptions) this.f33398b).getDeprecated();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public String getGoPackage() {
                return ((FileOptions) this.f33398b).getGoPackage();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public ByteString getGoPackageBytes() {
                return ((FileOptions) this.f33398b).getGoPackageBytes();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            @Deprecated
            public boolean getJavaGenerateEqualsAndHash() {
                return ((FileOptions) this.f33398b).getJavaGenerateEqualsAndHash();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean getJavaGenericServices() {
                return ((FileOptions) this.f33398b).getJavaGenericServices();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean getJavaMultipleFiles() {
                return ((FileOptions) this.f33398b).getJavaMultipleFiles();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public String getJavaOuterClassname() {
                return ((FileOptions) this.f33398b).getJavaOuterClassname();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public ByteString getJavaOuterClassnameBytes() {
                return ((FileOptions) this.f33398b).getJavaOuterClassnameBytes();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public String getJavaPackage() {
                return ((FileOptions) this.f33398b).getJavaPackage();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public ByteString getJavaPackageBytes() {
                return ((FileOptions) this.f33398b).getJavaPackageBytes();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean getJavaStringCheckUtf8() {
                return ((FileOptions) this.f33398b).getJavaStringCheckUtf8();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public String getObjcClassPrefix() {
                return ((FileOptions) this.f33398b).getObjcClassPrefix();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public ByteString getObjcClassPrefixBytes() {
                return ((FileOptions) this.f33398b).getObjcClassPrefixBytes();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public OptimizeMode getOptimizeFor() {
                return ((FileOptions) this.f33398b).getOptimizeFor();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public String getPhpClassPrefix() {
                return ((FileOptions) this.f33398b).getPhpClassPrefix();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public ByteString getPhpClassPrefixBytes() {
                return ((FileOptions) this.f33398b).getPhpClassPrefixBytes();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean getPhpGenericServices() {
                return ((FileOptions) this.f33398b).getPhpGenericServices();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public String getPhpMetadataNamespace() {
                return ((FileOptions) this.f33398b).getPhpMetadataNamespace();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public ByteString getPhpMetadataNamespaceBytes() {
                return ((FileOptions) this.f33398b).getPhpMetadataNamespaceBytes();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public String getPhpNamespace() {
                return ((FileOptions) this.f33398b).getPhpNamespace();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public ByteString getPhpNamespaceBytes() {
                return ((FileOptions) this.f33398b).getPhpNamespaceBytes();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean getPyGenericServices() {
                return ((FileOptions) this.f33398b).getPyGenericServices();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public String getRubyPackage() {
                return ((FileOptions) this.f33398b).getRubyPackage();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public ByteString getRubyPackageBytes() {
                return ((FileOptions) this.f33398b).getRubyPackageBytes();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public String getSwiftPrefix() {
                return ((FileOptions) this.f33398b).getSwiftPrefix();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public ByteString getSwiftPrefixBytes() {
                return ((FileOptions) this.f33398b).getSwiftPrefixBytes();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public UninterpretedOption getUninterpretedOption(int i4) {
                return ((FileOptions) this.f33398b).getUninterpretedOption(i4);
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public int getUninterpretedOptionCount() {
                return ((FileOptions) this.f33398b).getUninterpretedOptionCount();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public List<UninterpretedOption> getUninterpretedOptionList() {
                return Collections.unmodifiableList(((FileOptions) this.f33398b).getUninterpretedOptionList());
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean hasCcEnableArenas() {
                return ((FileOptions) this.f33398b).hasCcEnableArenas();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean hasCcGenericServices() {
                return ((FileOptions) this.f33398b).hasCcGenericServices();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean hasCsharpNamespace() {
                return ((FileOptions) this.f33398b).hasCsharpNamespace();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean hasDeprecated() {
                return ((FileOptions) this.f33398b).hasDeprecated();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean hasGoPackage() {
                return ((FileOptions) this.f33398b).hasGoPackage();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            @Deprecated
            public boolean hasJavaGenerateEqualsAndHash() {
                return ((FileOptions) this.f33398b).hasJavaGenerateEqualsAndHash();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean hasJavaGenericServices() {
                return ((FileOptions) this.f33398b).hasJavaGenericServices();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean hasJavaMultipleFiles() {
                return ((FileOptions) this.f33398b).hasJavaMultipleFiles();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean hasJavaOuterClassname() {
                return ((FileOptions) this.f33398b).hasJavaOuterClassname();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean hasJavaPackage() {
                return ((FileOptions) this.f33398b).hasJavaPackage();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean hasJavaStringCheckUtf8() {
                return ((FileOptions) this.f33398b).hasJavaStringCheckUtf8();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean hasObjcClassPrefix() {
                return ((FileOptions) this.f33398b).hasObjcClassPrefix();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean hasOptimizeFor() {
                return ((FileOptions) this.f33398b).hasOptimizeFor();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean hasPhpClassPrefix() {
                return ((FileOptions) this.f33398b).hasPhpClassPrefix();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean hasPhpGenericServices() {
                return ((FileOptions) this.f33398b).hasPhpGenericServices();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean hasPhpMetadataNamespace() {
                return ((FileOptions) this.f33398b).hasPhpMetadataNamespace();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean hasPhpNamespace() {
                return ((FileOptions) this.f33398b).hasPhpNamespace();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean hasPyGenericServices() {
                return ((FileOptions) this.f33398b).hasPyGenericServices();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean hasRubyPackage() {
                return ((FileOptions) this.f33398b).hasRubyPackage();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean hasSwiftPrefix() {
                return ((FileOptions) this.f33398b).hasSwiftPrefix();
            }

            public Builder removeUninterpretedOption(int i4) {
                f();
                ((FileOptions) this.f33398b).L1(i4);
                return this;
            }

            public Builder setCcEnableArenas(boolean z3) {
                f();
                ((FileOptions) this.f33398b).M1(z3);
                return this;
            }

            public Builder setCcGenericServices(boolean z3) {
                f();
                ((FileOptions) this.f33398b).N1(z3);
                return this;
            }

            public Builder setCsharpNamespace(String str) {
                f();
                ((FileOptions) this.f33398b).O1(str);
                return this;
            }

            public Builder setCsharpNamespaceBytes(ByteString byteString) {
                f();
                ((FileOptions) this.f33398b).P1(byteString);
                return this;
            }

            public Builder setDeprecated(boolean z3) {
                f();
                ((FileOptions) this.f33398b).Q1(z3);
                return this;
            }

            public Builder setGoPackage(String str) {
                f();
                ((FileOptions) this.f33398b).R1(str);
                return this;
            }

            public Builder setGoPackageBytes(ByteString byteString) {
                f();
                ((FileOptions) this.f33398b).S1(byteString);
                return this;
            }

            @Deprecated
            public Builder setJavaGenerateEqualsAndHash(boolean z3) {
                f();
                ((FileOptions) this.f33398b).T1(z3);
                return this;
            }

            public Builder setJavaGenericServices(boolean z3) {
                f();
                ((FileOptions) this.f33398b).U1(z3);
                return this;
            }

            public Builder setJavaMultipleFiles(boolean z3) {
                f();
                ((FileOptions) this.f33398b).V1(z3);
                return this;
            }

            public Builder setJavaOuterClassname(String str) {
                f();
                ((FileOptions) this.f33398b).W1(str);
                return this;
            }

            public Builder setJavaOuterClassnameBytes(ByteString byteString) {
                f();
                ((FileOptions) this.f33398b).X1(byteString);
                return this;
            }

            public Builder setJavaPackage(String str) {
                f();
                ((FileOptions) this.f33398b).Y1(str);
                return this;
            }

            public Builder setJavaPackageBytes(ByteString byteString) {
                f();
                ((FileOptions) this.f33398b).Z1(byteString);
                return this;
            }

            public Builder setJavaStringCheckUtf8(boolean z3) {
                f();
                ((FileOptions) this.f33398b).a2(z3);
                return this;
            }

            public Builder setObjcClassPrefix(String str) {
                f();
                ((FileOptions) this.f33398b).b2(str);
                return this;
            }

            public Builder setObjcClassPrefixBytes(ByteString byteString) {
                f();
                ((FileOptions) this.f33398b).c2(byteString);
                return this;
            }

            public Builder setOptimizeFor(OptimizeMode optimizeMode) {
                f();
                ((FileOptions) this.f33398b).d2(optimizeMode);
                return this;
            }

            public Builder setPhpClassPrefix(String str) {
                f();
                ((FileOptions) this.f33398b).e2(str);
                return this;
            }

            public Builder setPhpClassPrefixBytes(ByteString byteString) {
                f();
                ((FileOptions) this.f33398b).f2(byteString);
                return this;
            }

            public Builder setPhpGenericServices(boolean z3) {
                f();
                ((FileOptions) this.f33398b).g2(z3);
                return this;
            }

            public Builder setPhpMetadataNamespace(String str) {
                f();
                ((FileOptions) this.f33398b).h2(str);
                return this;
            }

            public Builder setPhpMetadataNamespaceBytes(ByteString byteString) {
                f();
                ((FileOptions) this.f33398b).i2(byteString);
                return this;
            }

            public Builder setPhpNamespace(String str) {
                f();
                ((FileOptions) this.f33398b).j2(str);
                return this;
            }

            public Builder setPhpNamespaceBytes(ByteString byteString) {
                f();
                ((FileOptions) this.f33398b).k2(byteString);
                return this;
            }

            public Builder setPyGenericServices(boolean z3) {
                f();
                ((FileOptions) this.f33398b).l2(z3);
                return this;
            }

            public Builder setRubyPackage(String str) {
                f();
                ((FileOptions) this.f33398b).m2(str);
                return this;
            }

            public Builder setRubyPackageBytes(ByteString byteString) {
                f();
                ((FileOptions) this.f33398b).n2(byteString);
                return this;
            }

            public Builder setSwiftPrefix(String str) {
                f();
                ((FileOptions) this.f33398b).o2(str);
                return this;
            }

            public Builder setSwiftPrefixBytes(ByteString byteString) {
                f();
                ((FileOptions) this.f33398b).p2(byteString);
                return this;
            }

            public Builder setUninterpretedOption(int i4, UninterpretedOption uninterpretedOption) {
                f();
                ((FileOptions) this.f33398b).q2(i4, uninterpretedOption);
                return this;
            }

            private Builder() {
                super(FileOptions.DEFAULT_INSTANCE);
            }

            public Builder addUninterpretedOption(int i4, UninterpretedOption uninterpretedOption) {
                f();
                ((FileOptions) this.f33398b).n1(i4, uninterpretedOption);
                return this;
            }

            public Builder setUninterpretedOption(int i4, UninterpretedOption.Builder builder) {
                f();
                ((FileOptions) this.f33398b).q2(i4, builder.build());
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption.Builder builder) {
                f();
                ((FileOptions) this.f33398b).o1(builder.build());
                return this;
            }

            public Builder addUninterpretedOption(int i4, UninterpretedOption.Builder builder) {
                f();
                ((FileOptions) this.f33398b).n1(i4, builder.build());
                return this;
            }
        }

        /* loaded from: classes6.dex */
        public enum OptimizeMode implements Internal.EnumLite {
            SPEED(1),
            CODE_SIZE(2),
            LITE_RUNTIME(3);
            
            public static final int CODE_SIZE_VALUE = 2;
            public static final int LITE_RUNTIME_VALUE = 3;
            public static final int SPEED_VALUE = 1;

            /* renamed from: a  reason: collision with root package name */
            private static final Internal.EnumLiteMap<OptimizeMode> f33313a = new Internal.EnumLiteMap<OptimizeMode>() { // from class: com.google.protobuf.DescriptorProtos.FileOptions.OptimizeMode.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                /* renamed from: a */
                public OptimizeMode findValueByNumber(int i4) {
                    return OptimizeMode.forNumber(i4);
                }
            };
            private final int value;

            /* JADX INFO: Access modifiers changed from: private */
            /* loaded from: classes6.dex */
            public static final class OptimizeModeVerifier implements Internal.EnumVerifier {

                /* renamed from: a  reason: collision with root package name */
                static final Internal.EnumVerifier f33315a = new OptimizeModeVerifier();

                private OptimizeModeVerifier() {
                }

                @Override // com.google.protobuf.Internal.EnumVerifier
                public boolean isInRange(int i4) {
                    if (OptimizeMode.forNumber(i4) != null) {
                        return true;
                    }
                    return false;
                }
            }

            OptimizeMode(int i4) {
                this.value = i4;
            }

            public static OptimizeMode forNumber(int i4) {
                if (i4 != 1) {
                    if (i4 != 2) {
                        if (i4 != 3) {
                            return null;
                        }
                        return LITE_RUNTIME;
                    }
                    return CODE_SIZE;
                }
                return SPEED;
            }

            public static Internal.EnumLiteMap<OptimizeMode> internalGetValueMap() {
                return f33313a;
            }

            public static Internal.EnumVerifier internalGetVerifier() {
                return OptimizeModeVerifier.f33315a;
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static OptimizeMode valueOf(int i4) {
                return forNumber(i4);
            }
        }

        static {
            FileOptions fileOptions = new FileOptions();
            DEFAULT_INSTANCE = fileOptions;
            GeneratedMessageLite.d0(FileOptions.class, fileOptions);
        }

        private FileOptions() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void A1() {
            this.bitField0_ &= -8193;
            this.objcClassPrefix_ = getDefaultInstance().getObjcClassPrefix();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void B1() {
            this.bitField0_ &= -33;
            this.optimizeFor_ = 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void C1() {
            this.bitField0_ &= -65537;
            this.phpClassPrefix_ = getDefaultInstance().getPhpClassPrefix();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void D1() {
            this.bitField0_ &= -1025;
            this.phpGenericServices_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void E1() {
            this.bitField0_ &= -262145;
            this.phpMetadataNamespace_ = getDefaultInstance().getPhpMetadataNamespace();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void F1() {
            this.bitField0_ &= -131073;
            this.phpNamespace_ = getDefaultInstance().getPhpNamespace();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void G1() {
            this.bitField0_ &= -513;
            this.pyGenericServices_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void H1() {
            this.bitField0_ &= -524289;
            this.rubyPackage_ = getDefaultInstance().getRubyPackage();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void I1() {
            this.bitField0_ &= -32769;
            this.swiftPrefix_ = getDefaultInstance().getSwiftPrefix();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void J1() {
            this.uninterpretedOption_ = GeneratedMessageLite.y();
        }

        private void K1() {
            Internal.ProtobufList<UninterpretedOption> protobufList = this.uninterpretedOption_;
            if (!protobufList.isModifiable()) {
                this.uninterpretedOption_ = GeneratedMessageLite.K(protobufList);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void L1(int i4) {
            K1();
            this.uninterpretedOption_.remove(i4);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void M1(boolean z3) {
            this.bitField0_ |= 4096;
            this.ccEnableArenas_ = z3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void N1(boolean z3) {
            this.bitField0_ |= 128;
            this.ccGenericServices_ = z3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void O1(String str) {
            str.getClass();
            this.bitField0_ |= 16384;
            this.csharpNamespace_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void P1(ByteString byteString) {
            this.csharpNamespace_ = byteString.toStringUtf8();
            this.bitField0_ |= 16384;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Q1(boolean z3) {
            this.bitField0_ |= 2048;
            this.deprecated_ = z3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void R1(String str) {
            str.getClass();
            this.bitField0_ |= 64;
            this.goPackage_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void S1(ByteString byteString) {
            this.goPackage_ = byteString.toStringUtf8();
            this.bitField0_ |= 64;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void T1(boolean z3) {
            this.bitField0_ |= 8;
            this.javaGenerateEqualsAndHash_ = z3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void U1(boolean z3) {
            this.bitField0_ |= 256;
            this.javaGenericServices_ = z3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void V1(boolean z3) {
            this.bitField0_ |= 4;
            this.javaMultipleFiles_ = z3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void W1(String str) {
            str.getClass();
            this.bitField0_ |= 2;
            this.javaOuterClassname_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void X1(ByteString byteString) {
            this.javaOuterClassname_ = byteString.toStringUtf8();
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Y1(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.javaPackage_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Z1(ByteString byteString) {
            this.javaPackage_ = byteString.toStringUtf8();
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a2(boolean z3) {
            this.bitField0_ |= 16;
            this.javaStringCheckUtf8_ = z3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b2(String str) {
            str.getClass();
            this.bitField0_ |= 8192;
            this.objcClassPrefix_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c2(ByteString byteString) {
            this.objcClassPrefix_ = byteString.toStringUtf8();
            this.bitField0_ |= 8192;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d2(OptimizeMode optimizeMode) {
            this.optimizeFor_ = optimizeMode.getNumber();
            this.bitField0_ |= 32;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e2(String str) {
            str.getClass();
            this.bitField0_ |= 65536;
            this.phpClassPrefix_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void f2(ByteString byteString) {
            this.phpClassPrefix_ = byteString.toStringUtf8();
            this.bitField0_ |= 65536;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g2(boolean z3) {
            this.bitField0_ |= 1024;
            this.phpGenericServices_ = z3;
        }

        public static FileOptions getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void h2(String str) {
            str.getClass();
            this.bitField0_ |= 262144;
            this.phpMetadataNamespace_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void i2(ByteString byteString) {
            this.phpMetadataNamespace_ = byteString.toStringUtf8();
            this.bitField0_ |= 262144;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j2(String str) {
            str.getClass();
            this.bitField0_ |= 131072;
            this.phpNamespace_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void k2(ByteString byteString) {
            this.phpNamespace_ = byteString.toStringUtf8();
            this.bitField0_ |= 131072;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void l2(boolean z3) {
            this.bitField0_ |= 512;
            this.pyGenericServices_ = z3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void m1(Iterable<? extends UninterpretedOption> iterable) {
            K1();
            AbstractMessageLite.a(iterable, this.uninterpretedOption_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void m2(String str) {
            str.getClass();
            this.bitField0_ |= 524288;
            this.rubyPackage_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n1(int i4, UninterpretedOption uninterpretedOption) {
            uninterpretedOption.getClass();
            K1();
            this.uninterpretedOption_.add(i4, uninterpretedOption);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n2(ByteString byteString) {
            this.rubyPackage_ = byteString.toStringUtf8();
            this.bitField0_ |= 524288;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.q();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void o1(UninterpretedOption uninterpretedOption) {
            uninterpretedOption.getClass();
            K1();
            this.uninterpretedOption_.add(uninterpretedOption);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void o2(String str) {
            str.getClass();
            this.bitField0_ |= 32768;
            this.swiftPrefix_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void p1() {
            this.bitField0_ &= -4097;
            this.ccEnableArenas_ = true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void p2(ByteString byteString) {
            this.swiftPrefix_ = byteString.toStringUtf8();
            this.bitField0_ |= 32768;
        }

        public static FileOptions parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (FileOptions) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
        }

        public static FileOptions parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (FileOptions) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<FileOptions> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void q1() {
            this.bitField0_ &= -129;
            this.ccGenericServices_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void q2(int i4, UninterpretedOption uninterpretedOption) {
            uninterpretedOption.getClass();
            K1();
            this.uninterpretedOption_.set(i4, uninterpretedOption);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void r1() {
            this.bitField0_ &= -16385;
            this.csharpNamespace_ = getDefaultInstance().getCsharpNamespace();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s1() {
            this.bitField0_ &= -2049;
            this.deprecated_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void t1() {
            this.bitField0_ &= -65;
            this.goPackage_ = getDefaultInstance().getGoPackage();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void u1() {
            this.bitField0_ &= -9;
            this.javaGenerateEqualsAndHash_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void v1() {
            this.bitField0_ &= -257;
            this.javaGenericServices_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void w1() {
            this.bitField0_ &= -5;
            this.javaMultipleFiles_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void x1() {
            this.bitField0_ &= -3;
            this.javaOuterClassname_ = getDefaultInstance().getJavaOuterClassname();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void y1() {
            this.bitField0_ &= -2;
            this.javaPackage_ = getDefaultInstance().getJavaPackage();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void z1() {
            this.bitField0_ &= -17;
            this.javaStringCheckUtf8_ = false;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean getCcEnableArenas() {
            return this.ccEnableArenas_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean getCcGenericServices() {
            return this.ccGenericServices_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public String getCsharpNamespace() {
            return this.csharpNamespace_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public ByteString getCsharpNamespaceBytes() {
            return ByteString.copyFromUtf8(this.csharpNamespace_);
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean getDeprecated() {
            return this.deprecated_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public String getGoPackage() {
            return this.goPackage_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public ByteString getGoPackageBytes() {
            return ByteString.copyFromUtf8(this.goPackage_);
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        @Deprecated
        public boolean getJavaGenerateEqualsAndHash() {
            return this.javaGenerateEqualsAndHash_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean getJavaGenericServices() {
            return this.javaGenericServices_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean getJavaMultipleFiles() {
            return this.javaMultipleFiles_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public String getJavaOuterClassname() {
            return this.javaOuterClassname_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public ByteString getJavaOuterClassnameBytes() {
            return ByteString.copyFromUtf8(this.javaOuterClassname_);
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public String getJavaPackage() {
            return this.javaPackage_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public ByteString getJavaPackageBytes() {
            return ByteString.copyFromUtf8(this.javaPackage_);
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean getJavaStringCheckUtf8() {
            return this.javaStringCheckUtf8_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public String getObjcClassPrefix() {
            return this.objcClassPrefix_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public ByteString getObjcClassPrefixBytes() {
            return ByteString.copyFromUtf8(this.objcClassPrefix_);
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public OptimizeMode getOptimizeFor() {
            OptimizeMode forNumber = OptimizeMode.forNumber(this.optimizeFor_);
            if (forNumber == null) {
                return OptimizeMode.SPEED;
            }
            return forNumber;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public String getPhpClassPrefix() {
            return this.phpClassPrefix_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public ByteString getPhpClassPrefixBytes() {
            return ByteString.copyFromUtf8(this.phpClassPrefix_);
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean getPhpGenericServices() {
            return this.phpGenericServices_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public String getPhpMetadataNamespace() {
            return this.phpMetadataNamespace_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public ByteString getPhpMetadataNamespaceBytes() {
            return ByteString.copyFromUtf8(this.phpMetadataNamespace_);
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public String getPhpNamespace() {
            return this.phpNamespace_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public ByteString getPhpNamespaceBytes() {
            return ByteString.copyFromUtf8(this.phpNamespace_);
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean getPyGenericServices() {
            return this.pyGenericServices_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public String getRubyPackage() {
            return this.rubyPackage_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public ByteString getRubyPackageBytes() {
            return ByteString.copyFromUtf8(this.rubyPackage_);
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public String getSwiftPrefix() {
            return this.swiftPrefix_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public ByteString getSwiftPrefixBytes() {
            return ByteString.copyFromUtf8(this.swiftPrefix_);
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public UninterpretedOption getUninterpretedOption(int i4) {
            return this.uninterpretedOption_.get(i4);
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public int getUninterpretedOptionCount() {
            return this.uninterpretedOption_.size();
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public List<UninterpretedOption> getUninterpretedOptionList() {
            return this.uninterpretedOption_;
        }

        public UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int i4) {
            return this.uninterpretedOption_.get(i4);
        }

        public List<? extends UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList() {
            return this.uninterpretedOption_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean hasCcEnableArenas() {
            if ((this.bitField0_ & 4096) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean hasCcGenericServices() {
            if ((this.bitField0_ & 128) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean hasCsharpNamespace() {
            if ((this.bitField0_ & 16384) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean hasDeprecated() {
            if ((this.bitField0_ & 2048) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean hasGoPackage() {
            if ((this.bitField0_ & 64) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        @Deprecated
        public boolean hasJavaGenerateEqualsAndHash() {
            if ((this.bitField0_ & 8) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean hasJavaGenericServices() {
            if ((this.bitField0_ & 256) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean hasJavaMultipleFiles() {
            if ((this.bitField0_ & 4) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean hasJavaOuterClassname() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean hasJavaPackage() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean hasJavaStringCheckUtf8() {
            if ((this.bitField0_ & 16) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean hasObjcClassPrefix() {
            if ((this.bitField0_ & 8192) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean hasOptimizeFor() {
            if ((this.bitField0_ & 32) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean hasPhpClassPrefix() {
            if ((this.bitField0_ & 65536) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean hasPhpGenericServices() {
            if ((this.bitField0_ & 1024) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean hasPhpMetadataNamespace() {
            if ((this.bitField0_ & 262144) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean hasPhpNamespace() {
            if ((this.bitField0_ & 131072) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean hasPyGenericServices() {
            if ((this.bitField0_ & 512) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean hasRubyPackage() {
            if ((this.bitField0_ & 524288) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean hasSwiftPrefix() {
            if ((this.bitField0_ & 32768) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            int i4 = 1;
            switch (AnonymousClass1.f33300a[methodToInvoke.ordinal()]) {
                case 1:
                    return new FileOptions();
                case 2:
                    return new Builder(null);
                case 3:
                    return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0001\u0015\u0000\u0001\u0001ϧ\u0015\u0000\u0001\u0001\u0001ဈ\u0000\bဈ\u0001\tဌ\u0005\nဇ\u0002\u000bဈ\u0006\u0010ဇ\u0007\u0011ဇ\b\u0012ဇ\t\u0014ဇ\u0003\u0017ဇ\u000b\u001bဇ\u0004\u001fဇ\f$ဈ\r%ဈ\u000e'ဈ\u000f(ဈ\u0010)ဈ\u0011*ဇ\n,ဈ\u0012-ဈ\u0013ϧЛ", new Object[]{"bitField0_", "javaPackage_", "javaOuterClassname_", "optimizeFor_", OptimizeMode.internalGetVerifier(), "javaMultipleFiles_", "goPackage_", "ccGenericServices_", "javaGenericServices_", "pyGenericServices_", "javaGenerateEqualsAndHash_", "deprecated_", "javaStringCheckUtf8_", "ccEnableArenas_", "objcClassPrefix_", "csharpNamespace_", "swiftPrefix_", "phpClassPrefix_", "phpNamespace_", "phpGenericServices_", "phpMetadataNamespace_", "rubyPackage_", "uninterpretedOption_", UninterpretedOption.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<FileOptions> parser = PARSER;
                    if (parser == null) {
                        synchronized (FileOptions.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case 6:
                    return Byte.valueOf(this.memoizedIsInitialized);
                case 7:
                    if (obj == null) {
                        i4 = 0;
                    }
                    this.memoizedIsInitialized = (byte) i4;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static Builder newBuilder(FileOptions fileOptions) {
            return (Builder) DEFAULT_INSTANCE.r(fileOptions);
        }

        public static FileOptions parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (FileOptions) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static FileOptions parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (FileOptions) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static FileOptions parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (FileOptions) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
        }

        public static FileOptions parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (FileOptions) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static FileOptions parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (FileOptions) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
        }

        public static FileOptions parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (FileOptions) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static FileOptions parseFrom(InputStream inputStream) throws IOException {
            return (FileOptions) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
        }

        public static FileOptions parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (FileOptions) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static FileOptions parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (FileOptions) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
        }

        public static FileOptions parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (FileOptions) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: classes6.dex */
    public interface FileOptionsOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<FileOptions, FileOptions.Builder> {
        boolean getCcEnableArenas();

        boolean getCcGenericServices();

        String getCsharpNamespace();

        ByteString getCsharpNamespaceBytes();

        boolean getDeprecated();

        String getGoPackage();

        ByteString getGoPackageBytes();

        @Deprecated
        boolean getJavaGenerateEqualsAndHash();

        boolean getJavaGenericServices();

        boolean getJavaMultipleFiles();

        String getJavaOuterClassname();

        ByteString getJavaOuterClassnameBytes();

        String getJavaPackage();

        ByteString getJavaPackageBytes();

        boolean getJavaStringCheckUtf8();

        String getObjcClassPrefix();

        ByteString getObjcClassPrefixBytes();

        FileOptions.OptimizeMode getOptimizeFor();

        String getPhpClassPrefix();

        ByteString getPhpClassPrefixBytes();

        boolean getPhpGenericServices();

        String getPhpMetadataNamespace();

        ByteString getPhpMetadataNamespaceBytes();

        String getPhpNamespace();

        ByteString getPhpNamespaceBytes();

        boolean getPyGenericServices();

        String getRubyPackage();

        ByteString getRubyPackageBytes();

        String getSwiftPrefix();

        ByteString getSwiftPrefixBytes();

        UninterpretedOption getUninterpretedOption(int i4);

        int getUninterpretedOptionCount();

        List<UninterpretedOption> getUninterpretedOptionList();

        boolean hasCcEnableArenas();

        boolean hasCcGenericServices();

        boolean hasCsharpNamespace();

        boolean hasDeprecated();

        boolean hasGoPackage();

        @Deprecated
        boolean hasJavaGenerateEqualsAndHash();

        boolean hasJavaGenericServices();

        boolean hasJavaMultipleFiles();

        boolean hasJavaOuterClassname();

        boolean hasJavaPackage();

        boolean hasJavaStringCheckUtf8();

        boolean hasObjcClassPrefix();

        boolean hasOptimizeFor();

        boolean hasPhpClassPrefix();

        boolean hasPhpGenericServices();

        boolean hasPhpMetadataNamespace();

        boolean hasPhpNamespace();

        boolean hasPyGenericServices();

        boolean hasRubyPackage();

        boolean hasSwiftPrefix();
    }

    /* loaded from: classes6.dex */
    public static final class GeneratedCodeInfo extends GeneratedMessageLite<GeneratedCodeInfo, Builder> implements GeneratedCodeInfoOrBuilder {
        public static final int ANNOTATION_FIELD_NUMBER = 1;
        private static final GeneratedCodeInfo DEFAULT_INSTANCE;
        private static volatile Parser<GeneratedCodeInfo> PARSER;
        private Internal.ProtobufList<Annotation> annotation_ = GeneratedMessageLite.y();

        /* loaded from: classes6.dex */
        public static final class Annotation extends GeneratedMessageLite<Annotation, Builder> implements AnnotationOrBuilder {
            public static final int BEGIN_FIELD_NUMBER = 3;
            private static final Annotation DEFAULT_INSTANCE;
            public static final int END_FIELD_NUMBER = 4;
            private static volatile Parser<Annotation> PARSER = null;
            public static final int PATH_FIELD_NUMBER = 1;
            public static final int SOURCE_FILE_FIELD_NUMBER = 2;
            private int begin_;
            private int bitField0_;
            private int end_;
            private int pathMemoizedSerializedSize = -1;
            private Internal.IntList path_ = GeneratedMessageLite.w();
            private String sourceFile_ = "";

            /* loaded from: classes6.dex */
            public static final class Builder extends GeneratedMessageLite.Builder<Annotation, Builder> implements AnnotationOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                public Builder addAllPath(Iterable<? extends Integer> iterable) {
                    f();
                    ((Annotation) this.f33398b).r0(iterable);
                    return this;
                }

                public Builder addPath(int i4) {
                    f();
                    ((Annotation) this.f33398b).s0(i4);
                    return this;
                }

                public Builder clearBegin() {
                    f();
                    ((Annotation) this.f33398b).t0();
                    return this;
                }

                public Builder clearEnd() {
                    f();
                    ((Annotation) this.f33398b).u0();
                    return this;
                }

                public Builder clearPath() {
                    f();
                    ((Annotation) this.f33398b).v0();
                    return this;
                }

                public Builder clearSourceFile() {
                    f();
                    ((Annotation) this.f33398b).w0();
                    return this;
                }

                @Override // com.google.protobuf.DescriptorProtos.GeneratedCodeInfo.AnnotationOrBuilder
                public int getBegin() {
                    return ((Annotation) this.f33398b).getBegin();
                }

                @Override // com.google.protobuf.DescriptorProtos.GeneratedCodeInfo.AnnotationOrBuilder
                public int getEnd() {
                    return ((Annotation) this.f33398b).getEnd();
                }

                @Override // com.google.protobuf.DescriptorProtos.GeneratedCodeInfo.AnnotationOrBuilder
                public int getPath(int i4) {
                    return ((Annotation) this.f33398b).getPath(i4);
                }

                @Override // com.google.protobuf.DescriptorProtos.GeneratedCodeInfo.AnnotationOrBuilder
                public int getPathCount() {
                    return ((Annotation) this.f33398b).getPathCount();
                }

                @Override // com.google.protobuf.DescriptorProtos.GeneratedCodeInfo.AnnotationOrBuilder
                public List<Integer> getPathList() {
                    return Collections.unmodifiableList(((Annotation) this.f33398b).getPathList());
                }

                @Override // com.google.protobuf.DescriptorProtos.GeneratedCodeInfo.AnnotationOrBuilder
                public String getSourceFile() {
                    return ((Annotation) this.f33398b).getSourceFile();
                }

                @Override // com.google.protobuf.DescriptorProtos.GeneratedCodeInfo.AnnotationOrBuilder
                public ByteString getSourceFileBytes() {
                    return ((Annotation) this.f33398b).getSourceFileBytes();
                }

                @Override // com.google.protobuf.DescriptorProtos.GeneratedCodeInfo.AnnotationOrBuilder
                public boolean hasBegin() {
                    return ((Annotation) this.f33398b).hasBegin();
                }

                @Override // com.google.protobuf.DescriptorProtos.GeneratedCodeInfo.AnnotationOrBuilder
                public boolean hasEnd() {
                    return ((Annotation) this.f33398b).hasEnd();
                }

                @Override // com.google.protobuf.DescriptorProtos.GeneratedCodeInfo.AnnotationOrBuilder
                public boolean hasSourceFile() {
                    return ((Annotation) this.f33398b).hasSourceFile();
                }

                public Builder setBegin(int i4) {
                    f();
                    ((Annotation) this.f33398b).y0(i4);
                    return this;
                }

                public Builder setEnd(int i4) {
                    f();
                    ((Annotation) this.f33398b).z0(i4);
                    return this;
                }

                public Builder setPath(int i4, int i5) {
                    f();
                    ((Annotation) this.f33398b).A0(i4, i5);
                    return this;
                }

                public Builder setSourceFile(String str) {
                    f();
                    ((Annotation) this.f33398b).B0(str);
                    return this;
                }

                public Builder setSourceFileBytes(ByteString byteString) {
                    f();
                    ((Annotation) this.f33398b).C0(byteString);
                    return this;
                }

                private Builder() {
                    super(Annotation.DEFAULT_INSTANCE);
                }
            }

            static {
                Annotation annotation = new Annotation();
                DEFAULT_INSTANCE = annotation;
                GeneratedMessageLite.d0(Annotation.class, annotation);
            }

            private Annotation() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void A0(int i4, int i5) {
                x0();
                this.path_.setInt(i4, i5);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void B0(String str) {
                str.getClass();
                this.bitField0_ |= 1;
                this.sourceFile_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void C0(ByteString byteString) {
                this.sourceFile_ = byteString.toStringUtf8();
                this.bitField0_ |= 1;
            }

            public static Annotation getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.q();
            }

            public static Annotation parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (Annotation) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
            }

            public static Annotation parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return (Annotation) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
            }

            public static Parser<Annotation> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void r0(Iterable<? extends Integer> iterable) {
                x0();
                AbstractMessageLite.a(iterable, this.path_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void s0(int i4) {
                x0();
                this.path_.addInt(i4);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void t0() {
                this.bitField0_ &= -3;
                this.begin_ = 0;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void u0() {
                this.bitField0_ &= -5;
                this.end_ = 0;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void v0() {
                this.path_ = GeneratedMessageLite.w();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void w0() {
                this.bitField0_ &= -2;
                this.sourceFile_ = getDefaultInstance().getSourceFile();
            }

            private void x0() {
                Internal.IntList intList = this.path_;
                if (!intList.isModifiable()) {
                    this.path_ = GeneratedMessageLite.I(intList);
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void y0(int i4) {
                this.bitField0_ |= 2;
                this.begin_ = i4;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void z0(int i4) {
                this.bitField0_ |= 4;
                this.end_ = i4;
            }

            @Override // com.google.protobuf.DescriptorProtos.GeneratedCodeInfo.AnnotationOrBuilder
            public int getBegin() {
                return this.begin_;
            }

            @Override // com.google.protobuf.DescriptorProtos.GeneratedCodeInfo.AnnotationOrBuilder
            public int getEnd() {
                return this.end_;
            }

            @Override // com.google.protobuf.DescriptorProtos.GeneratedCodeInfo.AnnotationOrBuilder
            public int getPath(int i4) {
                return this.path_.getInt(i4);
            }

            @Override // com.google.protobuf.DescriptorProtos.GeneratedCodeInfo.AnnotationOrBuilder
            public int getPathCount() {
                return this.path_.size();
            }

            @Override // com.google.protobuf.DescriptorProtos.GeneratedCodeInfo.AnnotationOrBuilder
            public List<Integer> getPathList() {
                return this.path_;
            }

            @Override // com.google.protobuf.DescriptorProtos.GeneratedCodeInfo.AnnotationOrBuilder
            public String getSourceFile() {
                return this.sourceFile_;
            }

            @Override // com.google.protobuf.DescriptorProtos.GeneratedCodeInfo.AnnotationOrBuilder
            public ByteString getSourceFileBytes() {
                return ByteString.copyFromUtf8(this.sourceFile_);
            }

            @Override // com.google.protobuf.DescriptorProtos.GeneratedCodeInfo.AnnotationOrBuilder
            public boolean hasBegin() {
                if ((this.bitField0_ & 2) != 0) {
                    return true;
                }
                return false;
            }

            @Override // com.google.protobuf.DescriptorProtos.GeneratedCodeInfo.AnnotationOrBuilder
            public boolean hasEnd() {
                if ((this.bitField0_ & 4) != 0) {
                    return true;
                }
                return false;
            }

            @Override // com.google.protobuf.DescriptorProtos.GeneratedCodeInfo.AnnotationOrBuilder
            public boolean hasSourceFile() {
                if ((this.bitField0_ & 1) != 0) {
                    return true;
                }
                return false;
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                switch (AnonymousClass1.f33300a[methodToInvoke.ordinal()]) {
                    case 1:
                        return new Annotation();
                    case 2:
                        return new Builder(null);
                    case 3:
                        return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001'\u0002ဈ\u0000\u0003င\u0001\u0004င\u0002", new Object[]{"bitField0_", "path_", "sourceFile_", "begin_", "end_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<Annotation> parser = PARSER;
                        if (parser == null) {
                            synchronized (Annotation.class) {
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

            public static Builder newBuilder(Annotation annotation) {
                return DEFAULT_INSTANCE.r(annotation);
            }

            public static Annotation parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Annotation) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Annotation parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (Annotation) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static Annotation parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (Annotation) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
            }

            public static Annotation parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (Annotation) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static Annotation parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (Annotation) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
            }

            public static Annotation parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (Annotation) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static Annotation parseFrom(InputStream inputStream) throws IOException {
                return (Annotation) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
            }

            public static Annotation parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Annotation) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Annotation parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (Annotation) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
            }

            public static Annotation parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Annotation) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }
        }

        /* loaded from: classes6.dex */
        public interface AnnotationOrBuilder extends MessageLiteOrBuilder {
            int getBegin();

            int getEnd();

            int getPath(int i4);

            int getPathCount();

            List<Integer> getPathList();

            String getSourceFile();

            ByteString getSourceFileBytes();

            boolean hasBegin();

            boolean hasEnd();

            boolean hasSourceFile();
        }

        /* loaded from: classes6.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<GeneratedCodeInfo, Builder> implements GeneratedCodeInfoOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder addAllAnnotation(Iterable<? extends Annotation> iterable) {
                f();
                ((GeneratedCodeInfo) this.f33398b).m0(iterable);
                return this;
            }

            public Builder addAnnotation(Annotation annotation) {
                f();
                ((GeneratedCodeInfo) this.f33398b).o0(annotation);
                return this;
            }

            public Builder clearAnnotation() {
                f();
                ((GeneratedCodeInfo) this.f33398b).p0();
                return this;
            }

            @Override // com.google.protobuf.DescriptorProtos.GeneratedCodeInfoOrBuilder
            public Annotation getAnnotation(int i4) {
                return ((GeneratedCodeInfo) this.f33398b).getAnnotation(i4);
            }

            @Override // com.google.protobuf.DescriptorProtos.GeneratedCodeInfoOrBuilder
            public int getAnnotationCount() {
                return ((GeneratedCodeInfo) this.f33398b).getAnnotationCount();
            }

            @Override // com.google.protobuf.DescriptorProtos.GeneratedCodeInfoOrBuilder
            public List<Annotation> getAnnotationList() {
                return Collections.unmodifiableList(((GeneratedCodeInfo) this.f33398b).getAnnotationList());
            }

            public Builder removeAnnotation(int i4) {
                f();
                ((GeneratedCodeInfo) this.f33398b).r0(i4);
                return this;
            }

            public Builder setAnnotation(int i4, Annotation annotation) {
                f();
                ((GeneratedCodeInfo) this.f33398b).s0(i4, annotation);
                return this;
            }

            private Builder() {
                super(GeneratedCodeInfo.DEFAULT_INSTANCE);
            }

            public Builder addAnnotation(int i4, Annotation annotation) {
                f();
                ((GeneratedCodeInfo) this.f33398b).n0(i4, annotation);
                return this;
            }

            public Builder setAnnotation(int i4, Annotation.Builder builder) {
                f();
                ((GeneratedCodeInfo) this.f33398b).s0(i4, builder.build());
                return this;
            }

            public Builder addAnnotation(Annotation.Builder builder) {
                f();
                ((GeneratedCodeInfo) this.f33398b).o0(builder.build());
                return this;
            }

            public Builder addAnnotation(int i4, Annotation.Builder builder) {
                f();
                ((GeneratedCodeInfo) this.f33398b).n0(i4, builder.build());
                return this;
            }
        }

        static {
            GeneratedCodeInfo generatedCodeInfo = new GeneratedCodeInfo();
            DEFAULT_INSTANCE = generatedCodeInfo;
            GeneratedMessageLite.d0(GeneratedCodeInfo.class, generatedCodeInfo);
        }

        private GeneratedCodeInfo() {
        }

        public static GeneratedCodeInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void m0(Iterable<? extends Annotation> iterable) {
            q0();
            AbstractMessageLite.a(iterable, this.annotation_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n0(int i4, Annotation annotation) {
            annotation.getClass();
            q0();
            this.annotation_.add(i4, annotation);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.q();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void o0(Annotation annotation) {
            annotation.getClass();
            q0();
            this.annotation_.add(annotation);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void p0() {
            this.annotation_ = GeneratedMessageLite.y();
        }

        public static GeneratedCodeInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (GeneratedCodeInfo) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
        }

        public static GeneratedCodeInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (GeneratedCodeInfo) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<GeneratedCodeInfo> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        private void q0() {
            Internal.ProtobufList<Annotation> protobufList = this.annotation_;
            if (!protobufList.isModifiable()) {
                this.annotation_ = GeneratedMessageLite.K(protobufList);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void r0(int i4) {
            q0();
            this.annotation_.remove(i4);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s0(int i4, Annotation annotation) {
            annotation.getClass();
            q0();
            this.annotation_.set(i4, annotation);
        }

        @Override // com.google.protobuf.DescriptorProtos.GeneratedCodeInfoOrBuilder
        public Annotation getAnnotation(int i4) {
            return this.annotation_.get(i4);
        }

        @Override // com.google.protobuf.DescriptorProtos.GeneratedCodeInfoOrBuilder
        public int getAnnotationCount() {
            return this.annotation_.size();
        }

        @Override // com.google.protobuf.DescriptorProtos.GeneratedCodeInfoOrBuilder
        public List<Annotation> getAnnotationList() {
            return this.annotation_;
        }

        public AnnotationOrBuilder getAnnotationOrBuilder(int i4) {
            return this.annotation_.get(i4);
        }

        public List<? extends AnnotationOrBuilder> getAnnotationOrBuilderList() {
            return this.annotation_;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (AnonymousClass1.f33300a[methodToInvoke.ordinal()]) {
                case 1:
                    return new GeneratedCodeInfo();
                case 2:
                    return new Builder(null);
                case 3:
                    return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"annotation_", Annotation.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<GeneratedCodeInfo> parser = PARSER;
                    if (parser == null) {
                        synchronized (GeneratedCodeInfo.class) {
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

        public static Builder newBuilder(GeneratedCodeInfo generatedCodeInfo) {
            return DEFAULT_INSTANCE.r(generatedCodeInfo);
        }

        public static GeneratedCodeInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (GeneratedCodeInfo) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static GeneratedCodeInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (GeneratedCodeInfo) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static GeneratedCodeInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (GeneratedCodeInfo) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
        }

        public static GeneratedCodeInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (GeneratedCodeInfo) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static GeneratedCodeInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (GeneratedCodeInfo) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
        }

        public static GeneratedCodeInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (GeneratedCodeInfo) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static GeneratedCodeInfo parseFrom(InputStream inputStream) throws IOException {
            return (GeneratedCodeInfo) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
        }

        public static GeneratedCodeInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (GeneratedCodeInfo) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static GeneratedCodeInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (GeneratedCodeInfo) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
        }

        public static GeneratedCodeInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (GeneratedCodeInfo) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: classes6.dex */
    public interface GeneratedCodeInfoOrBuilder extends MessageLiteOrBuilder {
        GeneratedCodeInfo.Annotation getAnnotation(int i4);

        int getAnnotationCount();

        List<GeneratedCodeInfo.Annotation> getAnnotationList();
    }

    /* loaded from: classes6.dex */
    public static final class MessageOptions extends GeneratedMessageLite.ExtendableMessage<MessageOptions, Builder> implements MessageOptionsOrBuilder {
        private static final MessageOptions DEFAULT_INSTANCE;
        public static final int DEPRECATED_FIELD_NUMBER = 3;
        public static final int MAP_ENTRY_FIELD_NUMBER = 7;
        public static final int MESSAGE_SET_WIRE_FORMAT_FIELD_NUMBER = 1;
        public static final int NO_STANDARD_DESCRIPTOR_ACCESSOR_FIELD_NUMBER = 2;
        private static volatile Parser<MessageOptions> PARSER = null;
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        private int bitField0_;
        private boolean deprecated_;
        private boolean mapEntry_;
        private boolean messageSetWireFormat_;
        private boolean noStandardDescriptorAccessor_;
        private byte memoizedIsInitialized = 2;
        private Internal.ProtobufList<UninterpretedOption> uninterpretedOption_ = GeneratedMessageLite.y();

        /* loaded from: classes6.dex */
        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<MessageOptions, Builder> implements MessageOptionsOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder addAllUninterpretedOption(Iterable<? extends UninterpretedOption> iterable) {
                f();
                ((MessageOptions) this.f33398b).w0(iterable);
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption uninterpretedOption) {
                f();
                ((MessageOptions) this.f33398b).y0(uninterpretedOption);
                return this;
            }

            public Builder clearDeprecated() {
                f();
                ((MessageOptions) this.f33398b).z0();
                return this;
            }

            public Builder clearMapEntry() {
                f();
                ((MessageOptions) this.f33398b).A0();
                return this;
            }

            public Builder clearMessageSetWireFormat() {
                f();
                ((MessageOptions) this.f33398b).B0();
                return this;
            }

            public Builder clearNoStandardDescriptorAccessor() {
                f();
                ((MessageOptions) this.f33398b).C0();
                return this;
            }

            public Builder clearUninterpretedOption() {
                f();
                ((MessageOptions) this.f33398b).D0();
                return this;
            }

            @Override // com.google.protobuf.DescriptorProtos.MessageOptionsOrBuilder
            public boolean getDeprecated() {
                return ((MessageOptions) this.f33398b).getDeprecated();
            }

            @Override // com.google.protobuf.DescriptorProtos.MessageOptionsOrBuilder
            public boolean getMapEntry() {
                return ((MessageOptions) this.f33398b).getMapEntry();
            }

            @Override // com.google.protobuf.DescriptorProtos.MessageOptionsOrBuilder
            public boolean getMessageSetWireFormat() {
                return ((MessageOptions) this.f33398b).getMessageSetWireFormat();
            }

            @Override // com.google.protobuf.DescriptorProtos.MessageOptionsOrBuilder
            public boolean getNoStandardDescriptorAccessor() {
                return ((MessageOptions) this.f33398b).getNoStandardDescriptorAccessor();
            }

            @Override // com.google.protobuf.DescriptorProtos.MessageOptionsOrBuilder
            public UninterpretedOption getUninterpretedOption(int i4) {
                return ((MessageOptions) this.f33398b).getUninterpretedOption(i4);
            }

            @Override // com.google.protobuf.DescriptorProtos.MessageOptionsOrBuilder
            public int getUninterpretedOptionCount() {
                return ((MessageOptions) this.f33398b).getUninterpretedOptionCount();
            }

            @Override // com.google.protobuf.DescriptorProtos.MessageOptionsOrBuilder
            public List<UninterpretedOption> getUninterpretedOptionList() {
                return Collections.unmodifiableList(((MessageOptions) this.f33398b).getUninterpretedOptionList());
            }

            @Override // com.google.protobuf.DescriptorProtos.MessageOptionsOrBuilder
            public boolean hasDeprecated() {
                return ((MessageOptions) this.f33398b).hasDeprecated();
            }

            @Override // com.google.protobuf.DescriptorProtos.MessageOptionsOrBuilder
            public boolean hasMapEntry() {
                return ((MessageOptions) this.f33398b).hasMapEntry();
            }

            @Override // com.google.protobuf.DescriptorProtos.MessageOptionsOrBuilder
            public boolean hasMessageSetWireFormat() {
                return ((MessageOptions) this.f33398b).hasMessageSetWireFormat();
            }

            @Override // com.google.protobuf.DescriptorProtos.MessageOptionsOrBuilder
            public boolean hasNoStandardDescriptorAccessor() {
                return ((MessageOptions) this.f33398b).hasNoStandardDescriptorAccessor();
            }

            public Builder removeUninterpretedOption(int i4) {
                f();
                ((MessageOptions) this.f33398b).F0(i4);
                return this;
            }

            public Builder setDeprecated(boolean z3) {
                f();
                ((MessageOptions) this.f33398b).G0(z3);
                return this;
            }

            public Builder setMapEntry(boolean z3) {
                f();
                ((MessageOptions) this.f33398b).H0(z3);
                return this;
            }

            public Builder setMessageSetWireFormat(boolean z3) {
                f();
                ((MessageOptions) this.f33398b).I0(z3);
                return this;
            }

            public Builder setNoStandardDescriptorAccessor(boolean z3) {
                f();
                ((MessageOptions) this.f33398b).J0(z3);
                return this;
            }

            public Builder setUninterpretedOption(int i4, UninterpretedOption uninterpretedOption) {
                f();
                ((MessageOptions) this.f33398b).K0(i4, uninterpretedOption);
                return this;
            }

            private Builder() {
                super(MessageOptions.DEFAULT_INSTANCE);
            }

            public Builder addUninterpretedOption(int i4, UninterpretedOption uninterpretedOption) {
                f();
                ((MessageOptions) this.f33398b).x0(i4, uninterpretedOption);
                return this;
            }

            public Builder setUninterpretedOption(int i4, UninterpretedOption.Builder builder) {
                f();
                ((MessageOptions) this.f33398b).K0(i4, builder.build());
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption.Builder builder) {
                f();
                ((MessageOptions) this.f33398b).y0(builder.build());
                return this;
            }

            public Builder addUninterpretedOption(int i4, UninterpretedOption.Builder builder) {
                f();
                ((MessageOptions) this.f33398b).x0(i4, builder.build());
                return this;
            }
        }

        static {
            MessageOptions messageOptions = new MessageOptions();
            DEFAULT_INSTANCE = messageOptions;
            GeneratedMessageLite.d0(MessageOptions.class, messageOptions);
        }

        private MessageOptions() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void A0() {
            this.bitField0_ &= -9;
            this.mapEntry_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void B0() {
            this.bitField0_ &= -2;
            this.messageSetWireFormat_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void C0() {
            this.bitField0_ &= -3;
            this.noStandardDescriptorAccessor_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void D0() {
            this.uninterpretedOption_ = GeneratedMessageLite.y();
        }

        private void E0() {
            Internal.ProtobufList<UninterpretedOption> protobufList = this.uninterpretedOption_;
            if (!protobufList.isModifiable()) {
                this.uninterpretedOption_ = GeneratedMessageLite.K(protobufList);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void F0(int i4) {
            E0();
            this.uninterpretedOption_.remove(i4);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void G0(boolean z3) {
            this.bitField0_ |= 4;
            this.deprecated_ = z3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void H0(boolean z3) {
            this.bitField0_ |= 8;
            this.mapEntry_ = z3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void I0(boolean z3) {
            this.bitField0_ |= 1;
            this.messageSetWireFormat_ = z3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void J0(boolean z3) {
            this.bitField0_ |= 2;
            this.noStandardDescriptorAccessor_ = z3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void K0(int i4, UninterpretedOption uninterpretedOption) {
            uninterpretedOption.getClass();
            E0();
            this.uninterpretedOption_.set(i4, uninterpretedOption);
        }

        public static MessageOptions getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.q();
        }

        public static MessageOptions parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (MessageOptions) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
        }

        public static MessageOptions parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (MessageOptions) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<MessageOptions> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void w0(Iterable<? extends UninterpretedOption> iterable) {
            E0();
            AbstractMessageLite.a(iterable, this.uninterpretedOption_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void x0(int i4, UninterpretedOption uninterpretedOption) {
            uninterpretedOption.getClass();
            E0();
            this.uninterpretedOption_.add(i4, uninterpretedOption);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void y0(UninterpretedOption uninterpretedOption) {
            uninterpretedOption.getClass();
            E0();
            this.uninterpretedOption_.add(uninterpretedOption);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void z0() {
            this.bitField0_ &= -5;
            this.deprecated_ = false;
        }

        @Override // com.google.protobuf.DescriptorProtos.MessageOptionsOrBuilder
        public boolean getDeprecated() {
            return this.deprecated_;
        }

        @Override // com.google.protobuf.DescriptorProtos.MessageOptionsOrBuilder
        public boolean getMapEntry() {
            return this.mapEntry_;
        }

        @Override // com.google.protobuf.DescriptorProtos.MessageOptionsOrBuilder
        public boolean getMessageSetWireFormat() {
            return this.messageSetWireFormat_;
        }

        @Override // com.google.protobuf.DescriptorProtos.MessageOptionsOrBuilder
        public boolean getNoStandardDescriptorAccessor() {
            return this.noStandardDescriptorAccessor_;
        }

        @Override // com.google.protobuf.DescriptorProtos.MessageOptionsOrBuilder
        public UninterpretedOption getUninterpretedOption(int i4) {
            return this.uninterpretedOption_.get(i4);
        }

        @Override // com.google.protobuf.DescriptorProtos.MessageOptionsOrBuilder
        public int getUninterpretedOptionCount() {
            return this.uninterpretedOption_.size();
        }

        @Override // com.google.protobuf.DescriptorProtos.MessageOptionsOrBuilder
        public List<UninterpretedOption> getUninterpretedOptionList() {
            return this.uninterpretedOption_;
        }

        public UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int i4) {
            return this.uninterpretedOption_.get(i4);
        }

        public List<? extends UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList() {
            return this.uninterpretedOption_;
        }

        @Override // com.google.protobuf.DescriptorProtos.MessageOptionsOrBuilder
        public boolean hasDeprecated() {
            if ((this.bitField0_ & 4) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.DescriptorProtos.MessageOptionsOrBuilder
        public boolean hasMapEntry() {
            if ((this.bitField0_ & 8) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.DescriptorProtos.MessageOptionsOrBuilder
        public boolean hasMessageSetWireFormat() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.DescriptorProtos.MessageOptionsOrBuilder
        public boolean hasNoStandardDescriptorAccessor() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            int i4 = 1;
            switch (AnonymousClass1.f33300a[methodToInvoke.ordinal()]) {
                case 1:
                    return new MessageOptions();
                case 2:
                    return new Builder(null);
                case 3:
                    return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0001\u0005\u0000\u0001\u0001ϧ\u0005\u0000\u0001\u0001\u0001ဇ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0007ဇ\u0003ϧЛ", new Object[]{"bitField0_", "messageSetWireFormat_", "noStandardDescriptorAccessor_", "deprecated_", "mapEntry_", "uninterpretedOption_", UninterpretedOption.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<MessageOptions> parser = PARSER;
                    if (parser == null) {
                        synchronized (MessageOptions.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case 6:
                    return Byte.valueOf(this.memoizedIsInitialized);
                case 7:
                    if (obj == null) {
                        i4 = 0;
                    }
                    this.memoizedIsInitialized = (byte) i4;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static Builder newBuilder(MessageOptions messageOptions) {
            return (Builder) DEFAULT_INSTANCE.r(messageOptions);
        }

        public static MessageOptions parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MessageOptions) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static MessageOptions parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (MessageOptions) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static MessageOptions parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (MessageOptions) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
        }

        public static MessageOptions parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (MessageOptions) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static MessageOptions parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (MessageOptions) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
        }

        public static MessageOptions parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (MessageOptions) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static MessageOptions parseFrom(InputStream inputStream) throws IOException {
            return (MessageOptions) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
        }

        public static MessageOptions parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MessageOptions) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static MessageOptions parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (MessageOptions) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
        }

        public static MessageOptions parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MessageOptions) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: classes6.dex */
    public interface MessageOptionsOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<MessageOptions, MessageOptions.Builder> {
        boolean getDeprecated();

        boolean getMapEntry();

        boolean getMessageSetWireFormat();

        boolean getNoStandardDescriptorAccessor();

        UninterpretedOption getUninterpretedOption(int i4);

        int getUninterpretedOptionCount();

        List<UninterpretedOption> getUninterpretedOptionList();

        boolean hasDeprecated();

        boolean hasMapEntry();

        boolean hasMessageSetWireFormat();

        boolean hasNoStandardDescriptorAccessor();
    }

    /* loaded from: classes6.dex */
    public static final class MethodDescriptorProto extends GeneratedMessageLite<MethodDescriptorProto, Builder> implements MethodDescriptorProtoOrBuilder {
        public static final int CLIENT_STREAMING_FIELD_NUMBER = 5;
        private static final MethodDescriptorProto DEFAULT_INSTANCE;
        public static final int INPUT_TYPE_FIELD_NUMBER = 2;
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int OPTIONS_FIELD_NUMBER = 4;
        public static final int OUTPUT_TYPE_FIELD_NUMBER = 3;
        private static volatile Parser<MethodDescriptorProto> PARSER = null;
        public static final int SERVER_STREAMING_FIELD_NUMBER = 6;
        private int bitField0_;
        private boolean clientStreaming_;
        private MethodOptions options_;
        private boolean serverStreaming_;
        private byte memoizedIsInitialized = 2;
        private String name_ = "";
        private String inputType_ = "";
        private String outputType_ = "";

        /* loaded from: classes6.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<MethodDescriptorProto, Builder> implements MethodDescriptorProtoOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearClientStreaming() {
                f();
                ((MethodDescriptorProto) this.f33398b).w0();
                return this;
            }

            public Builder clearInputType() {
                f();
                ((MethodDescriptorProto) this.f33398b).x0();
                return this;
            }

            public Builder clearName() {
                f();
                ((MethodDescriptorProto) this.f33398b).y0();
                return this;
            }

            public Builder clearOptions() {
                f();
                ((MethodDescriptorProto) this.f33398b).z0();
                return this;
            }

            public Builder clearOutputType() {
                f();
                ((MethodDescriptorProto) this.f33398b).A0();
                return this;
            }

            public Builder clearServerStreaming() {
                f();
                ((MethodDescriptorProto) this.f33398b).B0();
                return this;
            }

            @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
            public boolean getClientStreaming() {
                return ((MethodDescriptorProto) this.f33398b).getClientStreaming();
            }

            @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
            public String getInputType() {
                return ((MethodDescriptorProto) this.f33398b).getInputType();
            }

            @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
            public ByteString getInputTypeBytes() {
                return ((MethodDescriptorProto) this.f33398b).getInputTypeBytes();
            }

            @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
            public String getName() {
                return ((MethodDescriptorProto) this.f33398b).getName();
            }

            @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
            public ByteString getNameBytes() {
                return ((MethodDescriptorProto) this.f33398b).getNameBytes();
            }

            @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
            public MethodOptions getOptions() {
                return ((MethodDescriptorProto) this.f33398b).getOptions();
            }

            @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
            public String getOutputType() {
                return ((MethodDescriptorProto) this.f33398b).getOutputType();
            }

            @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
            public ByteString getOutputTypeBytes() {
                return ((MethodDescriptorProto) this.f33398b).getOutputTypeBytes();
            }

            @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
            public boolean getServerStreaming() {
                return ((MethodDescriptorProto) this.f33398b).getServerStreaming();
            }

            @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
            public boolean hasClientStreaming() {
                return ((MethodDescriptorProto) this.f33398b).hasClientStreaming();
            }

            @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
            public boolean hasInputType() {
                return ((MethodDescriptorProto) this.f33398b).hasInputType();
            }

            @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
            public boolean hasName() {
                return ((MethodDescriptorProto) this.f33398b).hasName();
            }

            @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
            public boolean hasOptions() {
                return ((MethodDescriptorProto) this.f33398b).hasOptions();
            }

            @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
            public boolean hasOutputType() {
                return ((MethodDescriptorProto) this.f33398b).hasOutputType();
            }

            @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
            public boolean hasServerStreaming() {
                return ((MethodDescriptorProto) this.f33398b).hasServerStreaming();
            }

            public Builder mergeOptions(MethodOptions methodOptions) {
                f();
                ((MethodDescriptorProto) this.f33398b).C0(methodOptions);
                return this;
            }

            public Builder setClientStreaming(boolean z3) {
                f();
                ((MethodDescriptorProto) this.f33398b).D0(z3);
                return this;
            }

            public Builder setInputType(String str) {
                f();
                ((MethodDescriptorProto) this.f33398b).E0(str);
                return this;
            }

            public Builder setInputTypeBytes(ByteString byteString) {
                f();
                ((MethodDescriptorProto) this.f33398b).F0(byteString);
                return this;
            }

            public Builder setName(String str) {
                f();
                ((MethodDescriptorProto) this.f33398b).G0(str);
                return this;
            }

            public Builder setNameBytes(ByteString byteString) {
                f();
                ((MethodDescriptorProto) this.f33398b).H0(byteString);
                return this;
            }

            public Builder setOptions(MethodOptions methodOptions) {
                f();
                ((MethodDescriptorProto) this.f33398b).I0(methodOptions);
                return this;
            }

            public Builder setOutputType(String str) {
                f();
                ((MethodDescriptorProto) this.f33398b).J0(str);
                return this;
            }

            public Builder setOutputTypeBytes(ByteString byteString) {
                f();
                ((MethodDescriptorProto) this.f33398b).K0(byteString);
                return this;
            }

            public Builder setServerStreaming(boolean z3) {
                f();
                ((MethodDescriptorProto) this.f33398b).L0(z3);
                return this;
            }

            private Builder() {
                super(MethodDescriptorProto.DEFAULT_INSTANCE);
            }

            public Builder setOptions(MethodOptions.Builder builder) {
                f();
                ((MethodDescriptorProto) this.f33398b).I0((MethodOptions) builder.build());
                return this;
            }
        }

        static {
            MethodDescriptorProto methodDescriptorProto = new MethodDescriptorProto();
            DEFAULT_INSTANCE = methodDescriptorProto;
            GeneratedMessageLite.d0(MethodDescriptorProto.class, methodDescriptorProto);
        }

        private MethodDescriptorProto() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void A0() {
            this.bitField0_ &= -5;
            this.outputType_ = getDefaultInstance().getOutputType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void B0() {
            this.bitField0_ &= -33;
            this.serverStreaming_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void C0(MethodOptions methodOptions) {
            methodOptions.getClass();
            MethodOptions methodOptions2 = this.options_;
            if (methodOptions2 != null && methodOptions2 != MethodOptions.getDefaultInstance()) {
                this.options_ = ((MethodOptions.Builder) MethodOptions.newBuilder(this.options_).mergeFrom((MethodOptions.Builder) methodOptions)).buildPartial();
            } else {
                this.options_ = methodOptions;
            }
            this.bitField0_ |= 8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void D0(boolean z3) {
            this.bitField0_ |= 16;
            this.clientStreaming_ = z3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void E0(String str) {
            str.getClass();
            this.bitField0_ |= 2;
            this.inputType_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void F0(ByteString byteString) {
            this.inputType_ = byteString.toStringUtf8();
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void G0(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.name_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void H0(ByteString byteString) {
            this.name_ = byteString.toStringUtf8();
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void I0(MethodOptions methodOptions) {
            methodOptions.getClass();
            this.options_ = methodOptions;
            this.bitField0_ |= 8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void J0(String str) {
            str.getClass();
            this.bitField0_ |= 4;
            this.outputType_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void K0(ByteString byteString) {
            this.outputType_ = byteString.toStringUtf8();
            this.bitField0_ |= 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void L0(boolean z3) {
            this.bitField0_ |= 32;
            this.serverStreaming_ = z3;
        }

        public static MethodDescriptorProto getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.q();
        }

        public static MethodDescriptorProto parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (MethodDescriptorProto) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
        }

        public static MethodDescriptorProto parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (MethodDescriptorProto) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<MethodDescriptorProto> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void w0() {
            this.bitField0_ &= -17;
            this.clientStreaming_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void x0() {
            this.bitField0_ &= -3;
            this.inputType_ = getDefaultInstance().getInputType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void y0() {
            this.bitField0_ &= -2;
            this.name_ = getDefaultInstance().getName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void z0() {
            this.options_ = null;
            this.bitField0_ &= -9;
        }

        @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
        public boolean getClientStreaming() {
            return this.clientStreaming_;
        }

        @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
        public String getInputType() {
            return this.inputType_;
        }

        @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
        public ByteString getInputTypeBytes() {
            return ByteString.copyFromUtf8(this.inputType_);
        }

        @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
        public String getName() {
            return this.name_;
        }

        @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
        public ByteString getNameBytes() {
            return ByteString.copyFromUtf8(this.name_);
        }

        @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
        public MethodOptions getOptions() {
            MethodOptions methodOptions = this.options_;
            if (methodOptions == null) {
                return MethodOptions.getDefaultInstance();
            }
            return methodOptions;
        }

        @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
        public String getOutputType() {
            return this.outputType_;
        }

        @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
        public ByteString getOutputTypeBytes() {
            return ByteString.copyFromUtf8(this.outputType_);
        }

        @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
        public boolean getServerStreaming() {
            return this.serverStreaming_;
        }

        @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
        public boolean hasClientStreaming() {
            if ((this.bitField0_ & 16) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
        public boolean hasInputType() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
        public boolean hasName() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
        public boolean hasOptions() {
            if ((this.bitField0_ & 8) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
        public boolean hasOutputType() {
            if ((this.bitField0_ & 4) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
        public boolean hasServerStreaming() {
            if ((this.bitField0_ & 32) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            int i4 = 1;
            switch (AnonymousClass1.f33300a[methodToInvoke.ordinal()]) {
                case 1:
                    return new MethodDescriptorProto();
                case 2:
                    return new Builder(null);
                case 3:
                    return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0001\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ᐉ\u0003\u0005ဇ\u0004\u0006ဇ\u0005", new Object[]{"bitField0_", "name_", "inputType_", "outputType_", "options_", "clientStreaming_", "serverStreaming_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<MethodDescriptorProto> parser = PARSER;
                    if (parser == null) {
                        synchronized (MethodDescriptorProto.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case 6:
                    return Byte.valueOf(this.memoizedIsInitialized);
                case 7:
                    if (obj == null) {
                        i4 = 0;
                    }
                    this.memoizedIsInitialized = (byte) i4;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static Builder newBuilder(MethodDescriptorProto methodDescriptorProto) {
            return DEFAULT_INSTANCE.r(methodDescriptorProto);
        }

        public static MethodDescriptorProto parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MethodDescriptorProto) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static MethodDescriptorProto parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (MethodDescriptorProto) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static MethodDescriptorProto parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (MethodDescriptorProto) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
        }

        public static MethodDescriptorProto parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (MethodDescriptorProto) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static MethodDescriptorProto parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (MethodDescriptorProto) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
        }

        public static MethodDescriptorProto parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (MethodDescriptorProto) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static MethodDescriptorProto parseFrom(InputStream inputStream) throws IOException {
            return (MethodDescriptorProto) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
        }

        public static MethodDescriptorProto parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MethodDescriptorProto) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static MethodDescriptorProto parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (MethodDescriptorProto) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
        }

        public static MethodDescriptorProto parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MethodDescriptorProto) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: classes6.dex */
    public interface MethodDescriptorProtoOrBuilder extends MessageLiteOrBuilder {
        boolean getClientStreaming();

        String getInputType();

        ByteString getInputTypeBytes();

        String getName();

        ByteString getNameBytes();

        MethodOptions getOptions();

        String getOutputType();

        ByteString getOutputTypeBytes();

        boolean getServerStreaming();

        boolean hasClientStreaming();

        boolean hasInputType();

        boolean hasName();

        boolean hasOptions();

        boolean hasOutputType();

        boolean hasServerStreaming();
    }

    /* loaded from: classes6.dex */
    public static final class MethodOptions extends GeneratedMessageLite.ExtendableMessage<MethodOptions, Builder> implements MethodOptionsOrBuilder {
        private static final MethodOptions DEFAULT_INSTANCE;
        public static final int DEPRECATED_FIELD_NUMBER = 33;
        public static final int IDEMPOTENCY_LEVEL_FIELD_NUMBER = 34;
        private static volatile Parser<MethodOptions> PARSER = null;
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        private int bitField0_;
        private boolean deprecated_;
        private int idempotencyLevel_;
        private byte memoizedIsInitialized = 2;
        private Internal.ProtobufList<UninterpretedOption> uninterpretedOption_ = GeneratedMessageLite.y();

        /* loaded from: classes6.dex */
        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<MethodOptions, Builder> implements MethodOptionsOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder addAllUninterpretedOption(Iterable<? extends UninterpretedOption> iterable) {
                f();
                ((MethodOptions) this.f33398b).s0(iterable);
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption uninterpretedOption) {
                f();
                ((MethodOptions) this.f33398b).u0(uninterpretedOption);
                return this;
            }

            public Builder clearDeprecated() {
                f();
                ((MethodOptions) this.f33398b).v0();
                return this;
            }

            public Builder clearIdempotencyLevel() {
                f();
                ((MethodOptions) this.f33398b).w0();
                return this;
            }

            public Builder clearUninterpretedOption() {
                f();
                ((MethodOptions) this.f33398b).x0();
                return this;
            }

            @Override // com.google.protobuf.DescriptorProtos.MethodOptionsOrBuilder
            public boolean getDeprecated() {
                return ((MethodOptions) this.f33398b).getDeprecated();
            }

            @Override // com.google.protobuf.DescriptorProtos.MethodOptionsOrBuilder
            public IdempotencyLevel getIdempotencyLevel() {
                return ((MethodOptions) this.f33398b).getIdempotencyLevel();
            }

            @Override // com.google.protobuf.DescriptorProtos.MethodOptionsOrBuilder
            public UninterpretedOption getUninterpretedOption(int i4) {
                return ((MethodOptions) this.f33398b).getUninterpretedOption(i4);
            }

            @Override // com.google.protobuf.DescriptorProtos.MethodOptionsOrBuilder
            public int getUninterpretedOptionCount() {
                return ((MethodOptions) this.f33398b).getUninterpretedOptionCount();
            }

            @Override // com.google.protobuf.DescriptorProtos.MethodOptionsOrBuilder
            public List<UninterpretedOption> getUninterpretedOptionList() {
                return Collections.unmodifiableList(((MethodOptions) this.f33398b).getUninterpretedOptionList());
            }

            @Override // com.google.protobuf.DescriptorProtos.MethodOptionsOrBuilder
            public boolean hasDeprecated() {
                return ((MethodOptions) this.f33398b).hasDeprecated();
            }

            @Override // com.google.protobuf.DescriptorProtos.MethodOptionsOrBuilder
            public boolean hasIdempotencyLevel() {
                return ((MethodOptions) this.f33398b).hasIdempotencyLevel();
            }

            public Builder removeUninterpretedOption(int i4) {
                f();
                ((MethodOptions) this.f33398b).z0(i4);
                return this;
            }

            public Builder setDeprecated(boolean z3) {
                f();
                ((MethodOptions) this.f33398b).A0(z3);
                return this;
            }

            public Builder setIdempotencyLevel(IdempotencyLevel idempotencyLevel) {
                f();
                ((MethodOptions) this.f33398b).B0(idempotencyLevel);
                return this;
            }

            public Builder setUninterpretedOption(int i4, UninterpretedOption uninterpretedOption) {
                f();
                ((MethodOptions) this.f33398b).C0(i4, uninterpretedOption);
                return this;
            }

            private Builder() {
                super(MethodOptions.DEFAULT_INSTANCE);
            }

            public Builder addUninterpretedOption(int i4, UninterpretedOption uninterpretedOption) {
                f();
                ((MethodOptions) this.f33398b).t0(i4, uninterpretedOption);
                return this;
            }

            public Builder setUninterpretedOption(int i4, UninterpretedOption.Builder builder) {
                f();
                ((MethodOptions) this.f33398b).C0(i4, builder.build());
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption.Builder builder) {
                f();
                ((MethodOptions) this.f33398b).u0(builder.build());
                return this;
            }

            public Builder addUninterpretedOption(int i4, UninterpretedOption.Builder builder) {
                f();
                ((MethodOptions) this.f33398b).t0(i4, builder.build());
                return this;
            }
        }

        /* loaded from: classes6.dex */
        public enum IdempotencyLevel implements Internal.EnumLite {
            IDEMPOTENCY_UNKNOWN(0),
            NO_SIDE_EFFECTS(1),
            IDEMPOTENT(2);
            
            public static final int IDEMPOTENCY_UNKNOWN_VALUE = 0;
            public static final int IDEMPOTENT_VALUE = 2;
            public static final int NO_SIDE_EFFECTS_VALUE = 1;

            /* renamed from: a  reason: collision with root package name */
            private static final Internal.EnumLiteMap<IdempotencyLevel> f33316a = new Internal.EnumLiteMap<IdempotencyLevel>() { // from class: com.google.protobuf.DescriptorProtos.MethodOptions.IdempotencyLevel.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                /* renamed from: a */
                public IdempotencyLevel findValueByNumber(int i4) {
                    return IdempotencyLevel.forNumber(i4);
                }
            };
            private final int value;

            /* JADX INFO: Access modifiers changed from: private */
            /* loaded from: classes6.dex */
            public static final class IdempotencyLevelVerifier implements Internal.EnumVerifier {

                /* renamed from: a  reason: collision with root package name */
                static final Internal.EnumVerifier f33318a = new IdempotencyLevelVerifier();

                private IdempotencyLevelVerifier() {
                }

                @Override // com.google.protobuf.Internal.EnumVerifier
                public boolean isInRange(int i4) {
                    if (IdempotencyLevel.forNumber(i4) != null) {
                        return true;
                    }
                    return false;
                }
            }

            IdempotencyLevel(int i4) {
                this.value = i4;
            }

            public static IdempotencyLevel forNumber(int i4) {
                if (i4 != 0) {
                    if (i4 != 1) {
                        if (i4 != 2) {
                            return null;
                        }
                        return IDEMPOTENT;
                    }
                    return NO_SIDE_EFFECTS;
                }
                return IDEMPOTENCY_UNKNOWN;
            }

            public static Internal.EnumLiteMap<IdempotencyLevel> internalGetValueMap() {
                return f33316a;
            }

            public static Internal.EnumVerifier internalGetVerifier() {
                return IdempotencyLevelVerifier.f33318a;
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static IdempotencyLevel valueOf(int i4) {
                return forNumber(i4);
            }
        }

        static {
            MethodOptions methodOptions = new MethodOptions();
            DEFAULT_INSTANCE = methodOptions;
            GeneratedMessageLite.d0(MethodOptions.class, methodOptions);
        }

        private MethodOptions() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void A0(boolean z3) {
            this.bitField0_ |= 1;
            this.deprecated_ = z3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void B0(IdempotencyLevel idempotencyLevel) {
            this.idempotencyLevel_ = idempotencyLevel.getNumber();
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void C0(int i4, UninterpretedOption uninterpretedOption) {
            uninterpretedOption.getClass();
            y0();
            this.uninterpretedOption_.set(i4, uninterpretedOption);
        }

        public static MethodOptions getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.q();
        }

        public static MethodOptions parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (MethodOptions) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
        }

        public static MethodOptions parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (MethodOptions) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<MethodOptions> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s0(Iterable<? extends UninterpretedOption> iterable) {
            y0();
            AbstractMessageLite.a(iterable, this.uninterpretedOption_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void t0(int i4, UninterpretedOption uninterpretedOption) {
            uninterpretedOption.getClass();
            y0();
            this.uninterpretedOption_.add(i4, uninterpretedOption);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void u0(UninterpretedOption uninterpretedOption) {
            uninterpretedOption.getClass();
            y0();
            this.uninterpretedOption_.add(uninterpretedOption);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void v0() {
            this.bitField0_ &= -2;
            this.deprecated_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void w0() {
            this.bitField0_ &= -3;
            this.idempotencyLevel_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void x0() {
            this.uninterpretedOption_ = GeneratedMessageLite.y();
        }

        private void y0() {
            Internal.ProtobufList<UninterpretedOption> protobufList = this.uninterpretedOption_;
            if (!protobufList.isModifiable()) {
                this.uninterpretedOption_ = GeneratedMessageLite.K(protobufList);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void z0(int i4) {
            y0();
            this.uninterpretedOption_.remove(i4);
        }

        @Override // com.google.protobuf.DescriptorProtos.MethodOptionsOrBuilder
        public boolean getDeprecated() {
            return this.deprecated_;
        }

        @Override // com.google.protobuf.DescriptorProtos.MethodOptionsOrBuilder
        public IdempotencyLevel getIdempotencyLevel() {
            IdempotencyLevel forNumber = IdempotencyLevel.forNumber(this.idempotencyLevel_);
            if (forNumber == null) {
                return IdempotencyLevel.IDEMPOTENCY_UNKNOWN;
            }
            return forNumber;
        }

        @Override // com.google.protobuf.DescriptorProtos.MethodOptionsOrBuilder
        public UninterpretedOption getUninterpretedOption(int i4) {
            return this.uninterpretedOption_.get(i4);
        }

        @Override // com.google.protobuf.DescriptorProtos.MethodOptionsOrBuilder
        public int getUninterpretedOptionCount() {
            return this.uninterpretedOption_.size();
        }

        @Override // com.google.protobuf.DescriptorProtos.MethodOptionsOrBuilder
        public List<UninterpretedOption> getUninterpretedOptionList() {
            return this.uninterpretedOption_;
        }

        public UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int i4) {
            return this.uninterpretedOption_.get(i4);
        }

        public List<? extends UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList() {
            return this.uninterpretedOption_;
        }

        @Override // com.google.protobuf.DescriptorProtos.MethodOptionsOrBuilder
        public boolean hasDeprecated() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.DescriptorProtos.MethodOptionsOrBuilder
        public boolean hasIdempotencyLevel() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            int i4 = 1;
            switch (AnonymousClass1.f33300a[methodToInvoke.ordinal()]) {
                case 1:
                    return new MethodOptions();
                case 2:
                    return new Builder(null);
                case 3:
                    return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001!ϧ\u0003\u0000\u0001\u0001!ဇ\u0000\"ဌ\u0001ϧЛ", new Object[]{"bitField0_", "deprecated_", "idempotencyLevel_", IdempotencyLevel.internalGetVerifier(), "uninterpretedOption_", UninterpretedOption.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<MethodOptions> parser = PARSER;
                    if (parser == null) {
                        synchronized (MethodOptions.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case 6:
                    return Byte.valueOf(this.memoizedIsInitialized);
                case 7:
                    if (obj == null) {
                        i4 = 0;
                    }
                    this.memoizedIsInitialized = (byte) i4;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static Builder newBuilder(MethodOptions methodOptions) {
            return (Builder) DEFAULT_INSTANCE.r(methodOptions);
        }

        public static MethodOptions parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MethodOptions) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static MethodOptions parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (MethodOptions) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static MethodOptions parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (MethodOptions) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
        }

        public static MethodOptions parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (MethodOptions) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static MethodOptions parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (MethodOptions) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
        }

        public static MethodOptions parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (MethodOptions) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static MethodOptions parseFrom(InputStream inputStream) throws IOException {
            return (MethodOptions) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
        }

        public static MethodOptions parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MethodOptions) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static MethodOptions parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (MethodOptions) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
        }

        public static MethodOptions parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MethodOptions) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: classes6.dex */
    public interface MethodOptionsOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<MethodOptions, MethodOptions.Builder> {
        boolean getDeprecated();

        MethodOptions.IdempotencyLevel getIdempotencyLevel();

        UninterpretedOption getUninterpretedOption(int i4);

        int getUninterpretedOptionCount();

        List<UninterpretedOption> getUninterpretedOptionList();

        boolean hasDeprecated();

        boolean hasIdempotencyLevel();
    }

    /* loaded from: classes6.dex */
    public static final class OneofDescriptorProto extends GeneratedMessageLite<OneofDescriptorProto, Builder> implements OneofDescriptorProtoOrBuilder {
        private static final OneofDescriptorProto DEFAULT_INSTANCE;
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int OPTIONS_FIELD_NUMBER = 2;
        private static volatile Parser<OneofDescriptorProto> PARSER;
        private int bitField0_;
        private byte memoizedIsInitialized = 2;
        private String name_ = "";
        private OneofOptions options_;

        /* loaded from: classes6.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<OneofDescriptorProto, Builder> implements OneofDescriptorProtoOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearName() {
                f();
                ((OneofDescriptorProto) this.f33398b).m0();
                return this;
            }

            public Builder clearOptions() {
                f();
                ((OneofDescriptorProto) this.f33398b).n0();
                return this;
            }

            @Override // com.google.protobuf.DescriptorProtos.OneofDescriptorProtoOrBuilder
            public String getName() {
                return ((OneofDescriptorProto) this.f33398b).getName();
            }

            @Override // com.google.protobuf.DescriptorProtos.OneofDescriptorProtoOrBuilder
            public ByteString getNameBytes() {
                return ((OneofDescriptorProto) this.f33398b).getNameBytes();
            }

            @Override // com.google.protobuf.DescriptorProtos.OneofDescriptorProtoOrBuilder
            public OneofOptions getOptions() {
                return ((OneofDescriptorProto) this.f33398b).getOptions();
            }

            @Override // com.google.protobuf.DescriptorProtos.OneofDescriptorProtoOrBuilder
            public boolean hasName() {
                return ((OneofDescriptorProto) this.f33398b).hasName();
            }

            @Override // com.google.protobuf.DescriptorProtos.OneofDescriptorProtoOrBuilder
            public boolean hasOptions() {
                return ((OneofDescriptorProto) this.f33398b).hasOptions();
            }

            public Builder mergeOptions(OneofOptions oneofOptions) {
                f();
                ((OneofDescriptorProto) this.f33398b).o0(oneofOptions);
                return this;
            }

            public Builder setName(String str) {
                f();
                ((OneofDescriptorProto) this.f33398b).p0(str);
                return this;
            }

            public Builder setNameBytes(ByteString byteString) {
                f();
                ((OneofDescriptorProto) this.f33398b).q0(byteString);
                return this;
            }

            public Builder setOptions(OneofOptions oneofOptions) {
                f();
                ((OneofDescriptorProto) this.f33398b).r0(oneofOptions);
                return this;
            }

            private Builder() {
                super(OneofDescriptorProto.DEFAULT_INSTANCE);
            }

            public Builder setOptions(OneofOptions.Builder builder) {
                f();
                ((OneofDescriptorProto) this.f33398b).r0((OneofOptions) builder.build());
                return this;
            }
        }

        static {
            OneofDescriptorProto oneofDescriptorProto = new OneofDescriptorProto();
            DEFAULT_INSTANCE = oneofDescriptorProto;
            GeneratedMessageLite.d0(OneofDescriptorProto.class, oneofDescriptorProto);
        }

        private OneofDescriptorProto() {
        }

        public static OneofDescriptorProto getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void m0() {
            this.bitField0_ &= -2;
            this.name_ = getDefaultInstance().getName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n0() {
            this.options_ = null;
            this.bitField0_ &= -3;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.q();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void o0(OneofOptions oneofOptions) {
            oneofOptions.getClass();
            OneofOptions oneofOptions2 = this.options_;
            if (oneofOptions2 != null && oneofOptions2 != OneofOptions.getDefaultInstance()) {
                this.options_ = ((OneofOptions.Builder) OneofOptions.newBuilder(this.options_).mergeFrom((OneofOptions.Builder) oneofOptions)).buildPartial();
            } else {
                this.options_ = oneofOptions;
            }
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void p0(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.name_ = str;
        }

        public static OneofDescriptorProto parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (OneofDescriptorProto) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
        }

        public static OneofDescriptorProto parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (OneofDescriptorProto) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<OneofDescriptorProto> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void q0(ByteString byteString) {
            this.name_ = byteString.toStringUtf8();
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void r0(OneofOptions oneofOptions) {
            oneofOptions.getClass();
            this.options_ = oneofOptions;
            this.bitField0_ |= 2;
        }

        @Override // com.google.protobuf.DescriptorProtos.OneofDescriptorProtoOrBuilder
        public String getName() {
            return this.name_;
        }

        @Override // com.google.protobuf.DescriptorProtos.OneofDescriptorProtoOrBuilder
        public ByteString getNameBytes() {
            return ByteString.copyFromUtf8(this.name_);
        }

        @Override // com.google.protobuf.DescriptorProtos.OneofDescriptorProtoOrBuilder
        public OneofOptions getOptions() {
            OneofOptions oneofOptions = this.options_;
            if (oneofOptions == null) {
                return OneofOptions.getDefaultInstance();
            }
            return oneofOptions;
        }

        @Override // com.google.protobuf.DescriptorProtos.OneofDescriptorProtoOrBuilder
        public boolean hasName() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.DescriptorProtos.OneofDescriptorProtoOrBuilder
        public boolean hasOptions() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            int i4 = 1;
            switch (AnonymousClass1.f33300a[methodToInvoke.ordinal()]) {
                case 1:
                    return new OneofDescriptorProto();
                case 2:
                    return new Builder(null);
                case 3:
                    return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0001\u0001ဈ\u0000\u0002ᐉ\u0001", new Object[]{"bitField0_", "name_", "options_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<OneofDescriptorProto> parser = PARSER;
                    if (parser == null) {
                        synchronized (OneofDescriptorProto.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case 6:
                    return Byte.valueOf(this.memoizedIsInitialized);
                case 7:
                    if (obj == null) {
                        i4 = 0;
                    }
                    this.memoizedIsInitialized = (byte) i4;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static Builder newBuilder(OneofDescriptorProto oneofDescriptorProto) {
            return DEFAULT_INSTANCE.r(oneofDescriptorProto);
        }

        public static OneofDescriptorProto parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (OneofDescriptorProto) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static OneofDescriptorProto parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (OneofDescriptorProto) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static OneofDescriptorProto parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (OneofDescriptorProto) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
        }

        public static OneofDescriptorProto parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (OneofDescriptorProto) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static OneofDescriptorProto parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (OneofDescriptorProto) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
        }

        public static OneofDescriptorProto parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (OneofDescriptorProto) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static OneofDescriptorProto parseFrom(InputStream inputStream) throws IOException {
            return (OneofDescriptorProto) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
        }

        public static OneofDescriptorProto parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (OneofDescriptorProto) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static OneofDescriptorProto parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (OneofDescriptorProto) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
        }

        public static OneofDescriptorProto parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (OneofDescriptorProto) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: classes6.dex */
    public interface OneofDescriptorProtoOrBuilder extends MessageLiteOrBuilder {
        String getName();

        ByteString getNameBytes();

        OneofOptions getOptions();

        boolean hasName();

        boolean hasOptions();
    }

    /* loaded from: classes6.dex */
    public static final class OneofOptions extends GeneratedMessageLite.ExtendableMessage<OneofOptions, Builder> implements OneofOptionsOrBuilder {
        private static final OneofOptions DEFAULT_INSTANCE;
        private static volatile Parser<OneofOptions> PARSER = null;
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        private byte memoizedIsInitialized = 2;
        private Internal.ProtobufList<UninterpretedOption> uninterpretedOption_ = GeneratedMessageLite.y();

        /* loaded from: classes6.dex */
        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<OneofOptions, Builder> implements OneofOptionsOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder addAllUninterpretedOption(Iterable<? extends UninterpretedOption> iterable) {
                f();
                ((OneofOptions) this.f33398b).o0(iterable);
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption uninterpretedOption) {
                f();
                ((OneofOptions) this.f33398b).q0(uninterpretedOption);
                return this;
            }

            public Builder clearUninterpretedOption() {
                f();
                ((OneofOptions) this.f33398b).r0();
                return this;
            }

            @Override // com.google.protobuf.DescriptorProtos.OneofOptionsOrBuilder
            public UninterpretedOption getUninterpretedOption(int i4) {
                return ((OneofOptions) this.f33398b).getUninterpretedOption(i4);
            }

            @Override // com.google.protobuf.DescriptorProtos.OneofOptionsOrBuilder
            public int getUninterpretedOptionCount() {
                return ((OneofOptions) this.f33398b).getUninterpretedOptionCount();
            }

            @Override // com.google.protobuf.DescriptorProtos.OneofOptionsOrBuilder
            public List<UninterpretedOption> getUninterpretedOptionList() {
                return Collections.unmodifiableList(((OneofOptions) this.f33398b).getUninterpretedOptionList());
            }

            public Builder removeUninterpretedOption(int i4) {
                f();
                ((OneofOptions) this.f33398b).t0(i4);
                return this;
            }

            public Builder setUninterpretedOption(int i4, UninterpretedOption uninterpretedOption) {
                f();
                ((OneofOptions) this.f33398b).u0(i4, uninterpretedOption);
                return this;
            }

            private Builder() {
                super(OneofOptions.DEFAULT_INSTANCE);
            }

            public Builder addUninterpretedOption(int i4, UninterpretedOption uninterpretedOption) {
                f();
                ((OneofOptions) this.f33398b).p0(i4, uninterpretedOption);
                return this;
            }

            public Builder setUninterpretedOption(int i4, UninterpretedOption.Builder builder) {
                f();
                ((OneofOptions) this.f33398b).u0(i4, builder.build());
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption.Builder builder) {
                f();
                ((OneofOptions) this.f33398b).q0(builder.build());
                return this;
            }

            public Builder addUninterpretedOption(int i4, UninterpretedOption.Builder builder) {
                f();
                ((OneofOptions) this.f33398b).p0(i4, builder.build());
                return this;
            }
        }

        static {
            OneofOptions oneofOptions = new OneofOptions();
            DEFAULT_INSTANCE = oneofOptions;
            GeneratedMessageLite.d0(OneofOptions.class, oneofOptions);
        }

        private OneofOptions() {
        }

        public static OneofOptions getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.q();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void o0(Iterable<? extends UninterpretedOption> iterable) {
            s0();
            AbstractMessageLite.a(iterable, this.uninterpretedOption_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void p0(int i4, UninterpretedOption uninterpretedOption) {
            uninterpretedOption.getClass();
            s0();
            this.uninterpretedOption_.add(i4, uninterpretedOption);
        }

        public static OneofOptions parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (OneofOptions) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
        }

        public static OneofOptions parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (OneofOptions) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<OneofOptions> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void q0(UninterpretedOption uninterpretedOption) {
            uninterpretedOption.getClass();
            s0();
            this.uninterpretedOption_.add(uninterpretedOption);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void r0() {
            this.uninterpretedOption_ = GeneratedMessageLite.y();
        }

        private void s0() {
            Internal.ProtobufList<UninterpretedOption> protobufList = this.uninterpretedOption_;
            if (!protobufList.isModifiable()) {
                this.uninterpretedOption_ = GeneratedMessageLite.K(protobufList);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void t0(int i4) {
            s0();
            this.uninterpretedOption_.remove(i4);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void u0(int i4, UninterpretedOption uninterpretedOption) {
            uninterpretedOption.getClass();
            s0();
            this.uninterpretedOption_.set(i4, uninterpretedOption);
        }

        @Override // com.google.protobuf.DescriptorProtos.OneofOptionsOrBuilder
        public UninterpretedOption getUninterpretedOption(int i4) {
            return this.uninterpretedOption_.get(i4);
        }

        @Override // com.google.protobuf.DescriptorProtos.OneofOptionsOrBuilder
        public int getUninterpretedOptionCount() {
            return this.uninterpretedOption_.size();
        }

        @Override // com.google.protobuf.DescriptorProtos.OneofOptionsOrBuilder
        public List<UninterpretedOption> getUninterpretedOptionList() {
            return this.uninterpretedOption_;
        }

        public UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int i4) {
            return this.uninterpretedOption_.get(i4);
        }

        public List<? extends UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList() {
            return this.uninterpretedOption_;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            int i4 = 1;
            switch (AnonymousClass1.f33300a[methodToInvoke.ordinal()]) {
                case 1:
                    return new OneofOptions();
                case 2:
                    return new Builder(null);
                case 3:
                    return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000ϧϧ\u0001\u0000\u0001\u0001ϧЛ", new Object[]{"uninterpretedOption_", UninterpretedOption.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<OneofOptions> parser = PARSER;
                    if (parser == null) {
                        synchronized (OneofOptions.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case 6:
                    return Byte.valueOf(this.memoizedIsInitialized);
                case 7:
                    if (obj == null) {
                        i4 = 0;
                    }
                    this.memoizedIsInitialized = (byte) i4;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static Builder newBuilder(OneofOptions oneofOptions) {
            return (Builder) DEFAULT_INSTANCE.r(oneofOptions);
        }

        public static OneofOptions parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (OneofOptions) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static OneofOptions parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (OneofOptions) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static OneofOptions parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (OneofOptions) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
        }

        public static OneofOptions parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (OneofOptions) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static OneofOptions parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (OneofOptions) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
        }

        public static OneofOptions parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (OneofOptions) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static OneofOptions parseFrom(InputStream inputStream) throws IOException {
            return (OneofOptions) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
        }

        public static OneofOptions parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (OneofOptions) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static OneofOptions parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (OneofOptions) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
        }

        public static OneofOptions parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (OneofOptions) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: classes6.dex */
    public interface OneofOptionsOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<OneofOptions, OneofOptions.Builder> {
        UninterpretedOption getUninterpretedOption(int i4);

        int getUninterpretedOptionCount();

        List<UninterpretedOption> getUninterpretedOptionList();
    }

    /* loaded from: classes6.dex */
    public static final class ServiceDescriptorProto extends GeneratedMessageLite<ServiceDescriptorProto, Builder> implements ServiceDescriptorProtoOrBuilder {
        private static final ServiceDescriptorProto DEFAULT_INSTANCE;
        public static final int METHOD_FIELD_NUMBER = 2;
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int OPTIONS_FIELD_NUMBER = 3;
        private static volatile Parser<ServiceDescriptorProto> PARSER;
        private int bitField0_;
        private ServiceOptions options_;
        private byte memoizedIsInitialized = 2;
        private String name_ = "";
        private Internal.ProtobufList<MethodDescriptorProto> method_ = GeneratedMessageLite.y();

        /* loaded from: classes6.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<ServiceDescriptorProto, Builder> implements ServiceDescriptorProtoOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder addAllMethod(Iterable<? extends MethodDescriptorProto> iterable) {
                f();
                ((ServiceDescriptorProto) this.f33398b).s0(iterable);
                return this;
            }

            public Builder addMethod(MethodDescriptorProto methodDescriptorProto) {
                f();
                ((ServiceDescriptorProto) this.f33398b).u0(methodDescriptorProto);
                return this;
            }

            public Builder clearMethod() {
                f();
                ((ServiceDescriptorProto) this.f33398b).v0();
                return this;
            }

            public Builder clearName() {
                f();
                ((ServiceDescriptorProto) this.f33398b).w0();
                return this;
            }

            public Builder clearOptions() {
                f();
                ((ServiceDescriptorProto) this.f33398b).x0();
                return this;
            }

            @Override // com.google.protobuf.DescriptorProtos.ServiceDescriptorProtoOrBuilder
            public MethodDescriptorProto getMethod(int i4) {
                return ((ServiceDescriptorProto) this.f33398b).getMethod(i4);
            }

            @Override // com.google.protobuf.DescriptorProtos.ServiceDescriptorProtoOrBuilder
            public int getMethodCount() {
                return ((ServiceDescriptorProto) this.f33398b).getMethodCount();
            }

            @Override // com.google.protobuf.DescriptorProtos.ServiceDescriptorProtoOrBuilder
            public List<MethodDescriptorProto> getMethodList() {
                return Collections.unmodifiableList(((ServiceDescriptorProto) this.f33398b).getMethodList());
            }

            @Override // com.google.protobuf.DescriptorProtos.ServiceDescriptorProtoOrBuilder
            public String getName() {
                return ((ServiceDescriptorProto) this.f33398b).getName();
            }

            @Override // com.google.protobuf.DescriptorProtos.ServiceDescriptorProtoOrBuilder
            public ByteString getNameBytes() {
                return ((ServiceDescriptorProto) this.f33398b).getNameBytes();
            }

            @Override // com.google.protobuf.DescriptorProtos.ServiceDescriptorProtoOrBuilder
            public ServiceOptions getOptions() {
                return ((ServiceDescriptorProto) this.f33398b).getOptions();
            }

            @Override // com.google.protobuf.DescriptorProtos.ServiceDescriptorProtoOrBuilder
            public boolean hasName() {
                return ((ServiceDescriptorProto) this.f33398b).hasName();
            }

            @Override // com.google.protobuf.DescriptorProtos.ServiceDescriptorProtoOrBuilder
            public boolean hasOptions() {
                return ((ServiceDescriptorProto) this.f33398b).hasOptions();
            }

            public Builder mergeOptions(ServiceOptions serviceOptions) {
                f();
                ((ServiceDescriptorProto) this.f33398b).z0(serviceOptions);
                return this;
            }

            public Builder removeMethod(int i4) {
                f();
                ((ServiceDescriptorProto) this.f33398b).A0(i4);
                return this;
            }

            public Builder setMethod(int i4, MethodDescriptorProto methodDescriptorProto) {
                f();
                ((ServiceDescriptorProto) this.f33398b).B0(i4, methodDescriptorProto);
                return this;
            }

            public Builder setName(String str) {
                f();
                ((ServiceDescriptorProto) this.f33398b).C0(str);
                return this;
            }

            public Builder setNameBytes(ByteString byteString) {
                f();
                ((ServiceDescriptorProto) this.f33398b).D0(byteString);
                return this;
            }

            public Builder setOptions(ServiceOptions serviceOptions) {
                f();
                ((ServiceDescriptorProto) this.f33398b).E0(serviceOptions);
                return this;
            }

            private Builder() {
                super(ServiceDescriptorProto.DEFAULT_INSTANCE);
            }

            public Builder addMethod(int i4, MethodDescriptorProto methodDescriptorProto) {
                f();
                ((ServiceDescriptorProto) this.f33398b).t0(i4, methodDescriptorProto);
                return this;
            }

            public Builder setMethod(int i4, MethodDescriptorProto.Builder builder) {
                f();
                ((ServiceDescriptorProto) this.f33398b).B0(i4, builder.build());
                return this;
            }

            public Builder setOptions(ServiceOptions.Builder builder) {
                f();
                ((ServiceDescriptorProto) this.f33398b).E0((ServiceOptions) builder.build());
                return this;
            }

            public Builder addMethod(MethodDescriptorProto.Builder builder) {
                f();
                ((ServiceDescriptorProto) this.f33398b).u0(builder.build());
                return this;
            }

            public Builder addMethod(int i4, MethodDescriptorProto.Builder builder) {
                f();
                ((ServiceDescriptorProto) this.f33398b).t0(i4, builder.build());
                return this;
            }
        }

        static {
            ServiceDescriptorProto serviceDescriptorProto = new ServiceDescriptorProto();
            DEFAULT_INSTANCE = serviceDescriptorProto;
            GeneratedMessageLite.d0(ServiceDescriptorProto.class, serviceDescriptorProto);
        }

        private ServiceDescriptorProto() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void A0(int i4) {
            y0();
            this.method_.remove(i4);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void B0(int i4, MethodDescriptorProto methodDescriptorProto) {
            methodDescriptorProto.getClass();
            y0();
            this.method_.set(i4, methodDescriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void C0(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.name_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void D0(ByteString byteString) {
            this.name_ = byteString.toStringUtf8();
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void E0(ServiceOptions serviceOptions) {
            serviceOptions.getClass();
            this.options_ = serviceOptions;
            this.bitField0_ |= 2;
        }

        public static ServiceDescriptorProto getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.q();
        }

        public static ServiceDescriptorProto parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ServiceDescriptorProto) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
        }

        public static ServiceDescriptorProto parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (ServiceDescriptorProto) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<ServiceDescriptorProto> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s0(Iterable<? extends MethodDescriptorProto> iterable) {
            y0();
            AbstractMessageLite.a(iterable, this.method_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void t0(int i4, MethodDescriptorProto methodDescriptorProto) {
            methodDescriptorProto.getClass();
            y0();
            this.method_.add(i4, methodDescriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void u0(MethodDescriptorProto methodDescriptorProto) {
            methodDescriptorProto.getClass();
            y0();
            this.method_.add(methodDescriptorProto);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void v0() {
            this.method_ = GeneratedMessageLite.y();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void w0() {
            this.bitField0_ &= -2;
            this.name_ = getDefaultInstance().getName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void x0() {
            this.options_ = null;
            this.bitField0_ &= -3;
        }

        private void y0() {
            Internal.ProtobufList<MethodDescriptorProto> protobufList = this.method_;
            if (!protobufList.isModifiable()) {
                this.method_ = GeneratedMessageLite.K(protobufList);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void z0(ServiceOptions serviceOptions) {
            serviceOptions.getClass();
            ServiceOptions serviceOptions2 = this.options_;
            if (serviceOptions2 != null && serviceOptions2 != ServiceOptions.getDefaultInstance()) {
                this.options_ = ((ServiceOptions.Builder) ServiceOptions.newBuilder(this.options_).mergeFrom((ServiceOptions.Builder) serviceOptions)).buildPartial();
            } else {
                this.options_ = serviceOptions;
            }
            this.bitField0_ |= 2;
        }

        @Override // com.google.protobuf.DescriptorProtos.ServiceDescriptorProtoOrBuilder
        public MethodDescriptorProto getMethod(int i4) {
            return this.method_.get(i4);
        }

        @Override // com.google.protobuf.DescriptorProtos.ServiceDescriptorProtoOrBuilder
        public int getMethodCount() {
            return this.method_.size();
        }

        @Override // com.google.protobuf.DescriptorProtos.ServiceDescriptorProtoOrBuilder
        public List<MethodDescriptorProto> getMethodList() {
            return this.method_;
        }

        public MethodDescriptorProtoOrBuilder getMethodOrBuilder(int i4) {
            return this.method_.get(i4);
        }

        public List<? extends MethodDescriptorProtoOrBuilder> getMethodOrBuilderList() {
            return this.method_;
        }

        @Override // com.google.protobuf.DescriptorProtos.ServiceDescriptorProtoOrBuilder
        public String getName() {
            return this.name_;
        }

        @Override // com.google.protobuf.DescriptorProtos.ServiceDescriptorProtoOrBuilder
        public ByteString getNameBytes() {
            return ByteString.copyFromUtf8(this.name_);
        }

        @Override // com.google.protobuf.DescriptorProtos.ServiceDescriptorProtoOrBuilder
        public ServiceOptions getOptions() {
            ServiceOptions serviceOptions = this.options_;
            if (serviceOptions == null) {
                return ServiceOptions.getDefaultInstance();
            }
            return serviceOptions;
        }

        @Override // com.google.protobuf.DescriptorProtos.ServiceDescriptorProtoOrBuilder
        public boolean hasName() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.DescriptorProtos.ServiceDescriptorProtoOrBuilder
        public boolean hasOptions() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            int i4 = 1;
            switch (AnonymousClass1.f33300a[methodToInvoke.ordinal()]) {
                case 1:
                    return new ServiceDescriptorProto();
                case 2:
                    return new Builder(null);
                case 3:
                    return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0002\u0001ဈ\u0000\u0002Л\u0003ᐉ\u0001", new Object[]{"bitField0_", "name_", "method_", MethodDescriptorProto.class, "options_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ServiceDescriptorProto> parser = PARSER;
                    if (parser == null) {
                        synchronized (ServiceDescriptorProto.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case 6:
                    return Byte.valueOf(this.memoizedIsInitialized);
                case 7:
                    if (obj == null) {
                        i4 = 0;
                    }
                    this.memoizedIsInitialized = (byte) i4;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static Builder newBuilder(ServiceDescriptorProto serviceDescriptorProto) {
            return DEFAULT_INSTANCE.r(serviceDescriptorProto);
        }

        public static ServiceDescriptorProto parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ServiceDescriptorProto) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ServiceDescriptorProto parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ServiceDescriptorProto) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ServiceDescriptorProto parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (ServiceDescriptorProto) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
        }

        public static ServiceDescriptorProto parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ServiceDescriptorProto) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ServiceDescriptorProto parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ServiceDescriptorProto) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
        }

        public static ServiceDescriptorProto parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ServiceDescriptorProto) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ServiceDescriptorProto parseFrom(InputStream inputStream) throws IOException {
            return (ServiceDescriptorProto) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
        }

        public static ServiceDescriptorProto parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ServiceDescriptorProto) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ServiceDescriptorProto parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ServiceDescriptorProto) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ServiceDescriptorProto parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ServiceDescriptorProto) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: classes6.dex */
    public interface ServiceDescriptorProtoOrBuilder extends MessageLiteOrBuilder {
        MethodDescriptorProto getMethod(int i4);

        int getMethodCount();

        List<MethodDescriptorProto> getMethodList();

        String getName();

        ByteString getNameBytes();

        ServiceOptions getOptions();

        boolean hasName();

        boolean hasOptions();
    }

    /* loaded from: classes6.dex */
    public static final class ServiceOptions extends GeneratedMessageLite.ExtendableMessage<ServiceOptions, Builder> implements ServiceOptionsOrBuilder {
        private static final ServiceOptions DEFAULT_INSTANCE;
        public static final int DEPRECATED_FIELD_NUMBER = 33;
        private static volatile Parser<ServiceOptions> PARSER = null;
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        private int bitField0_;
        private boolean deprecated_;
        private byte memoizedIsInitialized = 2;
        private Internal.ProtobufList<UninterpretedOption> uninterpretedOption_ = GeneratedMessageLite.y();

        /* loaded from: classes6.dex */
        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<ServiceOptions, Builder> implements ServiceOptionsOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder addAllUninterpretedOption(Iterable<? extends UninterpretedOption> iterable) {
                f();
                ((ServiceOptions) this.f33398b).q0(iterable);
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption uninterpretedOption) {
                f();
                ((ServiceOptions) this.f33398b).s0(uninterpretedOption);
                return this;
            }

            public Builder clearDeprecated() {
                f();
                ((ServiceOptions) this.f33398b).t0();
                return this;
            }

            public Builder clearUninterpretedOption() {
                f();
                ((ServiceOptions) this.f33398b).u0();
                return this;
            }

            @Override // com.google.protobuf.DescriptorProtos.ServiceOptionsOrBuilder
            public boolean getDeprecated() {
                return ((ServiceOptions) this.f33398b).getDeprecated();
            }

            @Override // com.google.protobuf.DescriptorProtos.ServiceOptionsOrBuilder
            public UninterpretedOption getUninterpretedOption(int i4) {
                return ((ServiceOptions) this.f33398b).getUninterpretedOption(i4);
            }

            @Override // com.google.protobuf.DescriptorProtos.ServiceOptionsOrBuilder
            public int getUninterpretedOptionCount() {
                return ((ServiceOptions) this.f33398b).getUninterpretedOptionCount();
            }

            @Override // com.google.protobuf.DescriptorProtos.ServiceOptionsOrBuilder
            public List<UninterpretedOption> getUninterpretedOptionList() {
                return Collections.unmodifiableList(((ServiceOptions) this.f33398b).getUninterpretedOptionList());
            }

            @Override // com.google.protobuf.DescriptorProtos.ServiceOptionsOrBuilder
            public boolean hasDeprecated() {
                return ((ServiceOptions) this.f33398b).hasDeprecated();
            }

            public Builder removeUninterpretedOption(int i4) {
                f();
                ((ServiceOptions) this.f33398b).w0(i4);
                return this;
            }

            public Builder setDeprecated(boolean z3) {
                f();
                ((ServiceOptions) this.f33398b).x0(z3);
                return this;
            }

            public Builder setUninterpretedOption(int i4, UninterpretedOption uninterpretedOption) {
                f();
                ((ServiceOptions) this.f33398b).y0(i4, uninterpretedOption);
                return this;
            }

            private Builder() {
                super(ServiceOptions.DEFAULT_INSTANCE);
            }

            public Builder addUninterpretedOption(int i4, UninterpretedOption uninterpretedOption) {
                f();
                ((ServiceOptions) this.f33398b).r0(i4, uninterpretedOption);
                return this;
            }

            public Builder setUninterpretedOption(int i4, UninterpretedOption.Builder builder) {
                f();
                ((ServiceOptions) this.f33398b).y0(i4, builder.build());
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption.Builder builder) {
                f();
                ((ServiceOptions) this.f33398b).s0(builder.build());
                return this;
            }

            public Builder addUninterpretedOption(int i4, UninterpretedOption.Builder builder) {
                f();
                ((ServiceOptions) this.f33398b).r0(i4, builder.build());
                return this;
            }
        }

        static {
            ServiceOptions serviceOptions = new ServiceOptions();
            DEFAULT_INSTANCE = serviceOptions;
            GeneratedMessageLite.d0(ServiceOptions.class, serviceOptions);
        }

        private ServiceOptions() {
        }

        public static ServiceOptions getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.q();
        }

        public static ServiceOptions parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ServiceOptions) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
        }

        public static ServiceOptions parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (ServiceOptions) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<ServiceOptions> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void q0(Iterable<? extends UninterpretedOption> iterable) {
            v0();
            AbstractMessageLite.a(iterable, this.uninterpretedOption_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void r0(int i4, UninterpretedOption uninterpretedOption) {
            uninterpretedOption.getClass();
            v0();
            this.uninterpretedOption_.add(i4, uninterpretedOption);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s0(UninterpretedOption uninterpretedOption) {
            uninterpretedOption.getClass();
            v0();
            this.uninterpretedOption_.add(uninterpretedOption);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void t0() {
            this.bitField0_ &= -2;
            this.deprecated_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void u0() {
            this.uninterpretedOption_ = GeneratedMessageLite.y();
        }

        private void v0() {
            Internal.ProtobufList<UninterpretedOption> protobufList = this.uninterpretedOption_;
            if (!protobufList.isModifiable()) {
                this.uninterpretedOption_ = GeneratedMessageLite.K(protobufList);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void w0(int i4) {
            v0();
            this.uninterpretedOption_.remove(i4);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void x0(boolean z3) {
            this.bitField0_ |= 1;
            this.deprecated_ = z3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void y0(int i4, UninterpretedOption uninterpretedOption) {
            uninterpretedOption.getClass();
            v0();
            this.uninterpretedOption_.set(i4, uninterpretedOption);
        }

        @Override // com.google.protobuf.DescriptorProtos.ServiceOptionsOrBuilder
        public boolean getDeprecated() {
            return this.deprecated_;
        }

        @Override // com.google.protobuf.DescriptorProtos.ServiceOptionsOrBuilder
        public UninterpretedOption getUninterpretedOption(int i4) {
            return this.uninterpretedOption_.get(i4);
        }

        @Override // com.google.protobuf.DescriptorProtos.ServiceOptionsOrBuilder
        public int getUninterpretedOptionCount() {
            return this.uninterpretedOption_.size();
        }

        @Override // com.google.protobuf.DescriptorProtos.ServiceOptionsOrBuilder
        public List<UninterpretedOption> getUninterpretedOptionList() {
            return this.uninterpretedOption_;
        }

        public UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int i4) {
            return this.uninterpretedOption_.get(i4);
        }

        public List<? extends UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList() {
            return this.uninterpretedOption_;
        }

        @Override // com.google.protobuf.DescriptorProtos.ServiceOptionsOrBuilder
        public boolean hasDeprecated() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            int i4 = 1;
            switch (AnonymousClass1.f33300a[methodToInvoke.ordinal()]) {
                case 1:
                    return new ServiceOptions();
                case 2:
                    return new Builder(null);
                case 3:
                    return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001!ϧ\u0002\u0000\u0001\u0001!ဇ\u0000ϧЛ", new Object[]{"bitField0_", "deprecated_", "uninterpretedOption_", UninterpretedOption.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ServiceOptions> parser = PARSER;
                    if (parser == null) {
                        synchronized (ServiceOptions.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case 6:
                    return Byte.valueOf(this.memoizedIsInitialized);
                case 7:
                    if (obj == null) {
                        i4 = 0;
                    }
                    this.memoizedIsInitialized = (byte) i4;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static Builder newBuilder(ServiceOptions serviceOptions) {
            return (Builder) DEFAULT_INSTANCE.r(serviceOptions);
        }

        public static ServiceOptions parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ServiceOptions) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ServiceOptions parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ServiceOptions) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ServiceOptions parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (ServiceOptions) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
        }

        public static ServiceOptions parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ServiceOptions) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ServiceOptions parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ServiceOptions) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
        }

        public static ServiceOptions parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ServiceOptions) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ServiceOptions parseFrom(InputStream inputStream) throws IOException {
            return (ServiceOptions) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
        }

        public static ServiceOptions parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ServiceOptions) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ServiceOptions parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ServiceOptions) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ServiceOptions parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ServiceOptions) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: classes6.dex */
    public interface ServiceOptionsOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<ServiceOptions, ServiceOptions.Builder> {
        boolean getDeprecated();

        UninterpretedOption getUninterpretedOption(int i4);

        int getUninterpretedOptionCount();

        List<UninterpretedOption> getUninterpretedOptionList();

        boolean hasDeprecated();
    }

    /* loaded from: classes6.dex */
    public static final class SourceCodeInfo extends GeneratedMessageLite<SourceCodeInfo, Builder> implements SourceCodeInfoOrBuilder {
        private static final SourceCodeInfo DEFAULT_INSTANCE;
        public static final int LOCATION_FIELD_NUMBER = 1;
        private static volatile Parser<SourceCodeInfo> PARSER;
        private Internal.ProtobufList<Location> location_ = GeneratedMessageLite.y();

        /* loaded from: classes6.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<SourceCodeInfo, Builder> implements SourceCodeInfoOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder addAllLocation(Iterable<? extends Location> iterable) {
                f();
                ((SourceCodeInfo) this.f33398b).m0(iterable);
                return this;
            }

            public Builder addLocation(Location location) {
                f();
                ((SourceCodeInfo) this.f33398b).o0(location);
                return this;
            }

            public Builder clearLocation() {
                f();
                ((SourceCodeInfo) this.f33398b).p0();
                return this;
            }

            @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfoOrBuilder
            public Location getLocation(int i4) {
                return ((SourceCodeInfo) this.f33398b).getLocation(i4);
            }

            @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfoOrBuilder
            public int getLocationCount() {
                return ((SourceCodeInfo) this.f33398b).getLocationCount();
            }

            @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfoOrBuilder
            public List<Location> getLocationList() {
                return Collections.unmodifiableList(((SourceCodeInfo) this.f33398b).getLocationList());
            }

            public Builder removeLocation(int i4) {
                f();
                ((SourceCodeInfo) this.f33398b).r0(i4);
                return this;
            }

            public Builder setLocation(int i4, Location location) {
                f();
                ((SourceCodeInfo) this.f33398b).s0(i4, location);
                return this;
            }

            private Builder() {
                super(SourceCodeInfo.DEFAULT_INSTANCE);
            }

            public Builder addLocation(int i4, Location location) {
                f();
                ((SourceCodeInfo) this.f33398b).n0(i4, location);
                return this;
            }

            public Builder setLocation(int i4, Location.Builder builder) {
                f();
                ((SourceCodeInfo) this.f33398b).s0(i4, builder.build());
                return this;
            }

            public Builder addLocation(Location.Builder builder) {
                f();
                ((SourceCodeInfo) this.f33398b).o0(builder.build());
                return this;
            }

            public Builder addLocation(int i4, Location.Builder builder) {
                f();
                ((SourceCodeInfo) this.f33398b).n0(i4, builder.build());
                return this;
            }
        }

        /* loaded from: classes6.dex */
        public static final class Location extends GeneratedMessageLite<Location, Builder> implements LocationOrBuilder {
            private static final Location DEFAULT_INSTANCE;
            public static final int LEADING_COMMENTS_FIELD_NUMBER = 3;
            public static final int LEADING_DETACHED_COMMENTS_FIELD_NUMBER = 6;
            private static volatile Parser<Location> PARSER = null;
            public static final int PATH_FIELD_NUMBER = 1;
            public static final int SPAN_FIELD_NUMBER = 2;
            public static final int TRAILING_COMMENTS_FIELD_NUMBER = 4;
            private int bitField0_;
            private int pathMemoizedSerializedSize = -1;
            private int spanMemoizedSerializedSize = -1;
            private Internal.IntList path_ = GeneratedMessageLite.w();
            private Internal.IntList span_ = GeneratedMessageLite.w();
            private String leadingComments_ = "";
            private String trailingComments_ = "";
            private Internal.ProtobufList<String> leadingDetachedComments_ = GeneratedMessageLite.y();

            /* loaded from: classes6.dex */
            public static final class Builder extends GeneratedMessageLite.Builder<Location, Builder> implements LocationOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                public Builder addAllLeadingDetachedComments(Iterable<String> iterable) {
                    f();
                    ((Location) this.f33398b).z0(iterable);
                    return this;
                }

                public Builder addAllPath(Iterable<? extends Integer> iterable) {
                    f();
                    ((Location) this.f33398b).A0(iterable);
                    return this;
                }

                public Builder addAllSpan(Iterable<? extends Integer> iterable) {
                    f();
                    ((Location) this.f33398b).B0(iterable);
                    return this;
                }

                public Builder addLeadingDetachedComments(String str) {
                    f();
                    ((Location) this.f33398b).C0(str);
                    return this;
                }

                public Builder addLeadingDetachedCommentsBytes(ByteString byteString) {
                    f();
                    ((Location) this.f33398b).D0(byteString);
                    return this;
                }

                public Builder addPath(int i4) {
                    f();
                    ((Location) this.f33398b).E0(i4);
                    return this;
                }

                public Builder addSpan(int i4) {
                    f();
                    ((Location) this.f33398b).F0(i4);
                    return this;
                }

                public Builder clearLeadingComments() {
                    f();
                    ((Location) this.f33398b).G0();
                    return this;
                }

                public Builder clearLeadingDetachedComments() {
                    f();
                    ((Location) this.f33398b).H0();
                    return this;
                }

                public Builder clearPath() {
                    f();
                    ((Location) this.f33398b).I0();
                    return this;
                }

                public Builder clearSpan() {
                    f();
                    ((Location) this.f33398b).J0();
                    return this;
                }

                public Builder clearTrailingComments() {
                    f();
                    ((Location) this.f33398b).K0();
                    return this;
                }

                @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
                public String getLeadingComments() {
                    return ((Location) this.f33398b).getLeadingComments();
                }

                @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
                public ByteString getLeadingCommentsBytes() {
                    return ((Location) this.f33398b).getLeadingCommentsBytes();
                }

                @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
                public String getLeadingDetachedComments(int i4) {
                    return ((Location) this.f33398b).getLeadingDetachedComments(i4);
                }

                @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
                public ByteString getLeadingDetachedCommentsBytes(int i4) {
                    return ((Location) this.f33398b).getLeadingDetachedCommentsBytes(i4);
                }

                @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
                public int getLeadingDetachedCommentsCount() {
                    return ((Location) this.f33398b).getLeadingDetachedCommentsCount();
                }

                @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
                public List<String> getLeadingDetachedCommentsList() {
                    return Collections.unmodifiableList(((Location) this.f33398b).getLeadingDetachedCommentsList());
                }

                @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
                public int getPath(int i4) {
                    return ((Location) this.f33398b).getPath(i4);
                }

                @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
                public int getPathCount() {
                    return ((Location) this.f33398b).getPathCount();
                }

                @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
                public List<Integer> getPathList() {
                    return Collections.unmodifiableList(((Location) this.f33398b).getPathList());
                }

                @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
                public int getSpan(int i4) {
                    return ((Location) this.f33398b).getSpan(i4);
                }

                @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
                public int getSpanCount() {
                    return ((Location) this.f33398b).getSpanCount();
                }

                @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
                public List<Integer> getSpanList() {
                    return Collections.unmodifiableList(((Location) this.f33398b).getSpanList());
                }

                @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
                public String getTrailingComments() {
                    return ((Location) this.f33398b).getTrailingComments();
                }

                @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
                public ByteString getTrailingCommentsBytes() {
                    return ((Location) this.f33398b).getTrailingCommentsBytes();
                }

                @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
                public boolean hasLeadingComments() {
                    return ((Location) this.f33398b).hasLeadingComments();
                }

                @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
                public boolean hasTrailingComments() {
                    return ((Location) this.f33398b).hasTrailingComments();
                }

                public Builder setLeadingComments(String str) {
                    f();
                    ((Location) this.f33398b).O0(str);
                    return this;
                }

                public Builder setLeadingCommentsBytes(ByteString byteString) {
                    f();
                    ((Location) this.f33398b).P0(byteString);
                    return this;
                }

                public Builder setLeadingDetachedComments(int i4, String str) {
                    f();
                    ((Location) this.f33398b).Q0(i4, str);
                    return this;
                }

                public Builder setPath(int i4, int i5) {
                    f();
                    ((Location) this.f33398b).R0(i4, i5);
                    return this;
                }

                public Builder setSpan(int i4, int i5) {
                    f();
                    ((Location) this.f33398b).S0(i4, i5);
                    return this;
                }

                public Builder setTrailingComments(String str) {
                    f();
                    ((Location) this.f33398b).T0(str);
                    return this;
                }

                public Builder setTrailingCommentsBytes(ByteString byteString) {
                    f();
                    ((Location) this.f33398b).U0(byteString);
                    return this;
                }

                private Builder() {
                    super(Location.DEFAULT_INSTANCE);
                }
            }

            static {
                Location location = new Location();
                DEFAULT_INSTANCE = location;
                GeneratedMessageLite.d0(Location.class, location);
            }

            private Location() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void A0(Iterable<? extends Integer> iterable) {
                M0();
                AbstractMessageLite.a(iterable, this.path_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void B0(Iterable<? extends Integer> iterable) {
                N0();
                AbstractMessageLite.a(iterable, this.span_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void C0(String str) {
                str.getClass();
                L0();
                this.leadingDetachedComments_.add(str);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void D0(ByteString byteString) {
                L0();
                this.leadingDetachedComments_.add(byteString.toStringUtf8());
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void E0(int i4) {
                M0();
                this.path_.addInt(i4);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void F0(int i4) {
                N0();
                this.span_.addInt(i4);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void G0() {
                this.bitField0_ &= -2;
                this.leadingComments_ = getDefaultInstance().getLeadingComments();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void H0() {
                this.leadingDetachedComments_ = GeneratedMessageLite.y();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void I0() {
                this.path_ = GeneratedMessageLite.w();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void J0() {
                this.span_ = GeneratedMessageLite.w();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void K0() {
                this.bitField0_ &= -3;
                this.trailingComments_ = getDefaultInstance().getTrailingComments();
            }

            private void L0() {
                Internal.ProtobufList<String> protobufList = this.leadingDetachedComments_;
                if (!protobufList.isModifiable()) {
                    this.leadingDetachedComments_ = GeneratedMessageLite.K(protobufList);
                }
            }

            private void M0() {
                Internal.IntList intList = this.path_;
                if (!intList.isModifiable()) {
                    this.path_ = GeneratedMessageLite.I(intList);
                }
            }

            private void N0() {
                Internal.IntList intList = this.span_;
                if (!intList.isModifiable()) {
                    this.span_ = GeneratedMessageLite.I(intList);
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void O0(String str) {
                str.getClass();
                this.bitField0_ |= 1;
                this.leadingComments_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void P0(ByteString byteString) {
                this.leadingComments_ = byteString.toStringUtf8();
                this.bitField0_ |= 1;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void Q0(int i4, String str) {
                str.getClass();
                L0();
                this.leadingDetachedComments_.set(i4, str);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void R0(int i4, int i5) {
                M0();
                this.path_.setInt(i4, i5);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void S0(int i4, int i5) {
                N0();
                this.span_.setInt(i4, i5);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void T0(String str) {
                str.getClass();
                this.bitField0_ |= 2;
                this.trailingComments_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void U0(ByteString byteString) {
                this.trailingComments_ = byteString.toStringUtf8();
                this.bitField0_ |= 2;
            }

            public static Location getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.q();
            }

            public static Location parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (Location) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
            }

            public static Location parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return (Location) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
            }

            public static Parser<Location> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void z0(Iterable<String> iterable) {
                L0();
                AbstractMessageLite.a(iterable, this.leadingDetachedComments_);
            }

            @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
            public String getLeadingComments() {
                return this.leadingComments_;
            }

            @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
            public ByteString getLeadingCommentsBytes() {
                return ByteString.copyFromUtf8(this.leadingComments_);
            }

            @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
            public String getLeadingDetachedComments(int i4) {
                return this.leadingDetachedComments_.get(i4);
            }

            @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
            public ByteString getLeadingDetachedCommentsBytes(int i4) {
                return ByteString.copyFromUtf8(this.leadingDetachedComments_.get(i4));
            }

            @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
            public int getLeadingDetachedCommentsCount() {
                return this.leadingDetachedComments_.size();
            }

            @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
            public List<String> getLeadingDetachedCommentsList() {
                return this.leadingDetachedComments_;
            }

            @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
            public int getPath(int i4) {
                return this.path_.getInt(i4);
            }

            @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
            public int getPathCount() {
                return this.path_.size();
            }

            @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
            public List<Integer> getPathList() {
                return this.path_;
            }

            @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
            public int getSpan(int i4) {
                return this.span_.getInt(i4);
            }

            @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
            public int getSpanCount() {
                return this.span_.size();
            }

            @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
            public List<Integer> getSpanList() {
                return this.span_;
            }

            @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
            public String getTrailingComments() {
                return this.trailingComments_;
            }

            @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
            public ByteString getTrailingCommentsBytes() {
                return ByteString.copyFromUtf8(this.trailingComments_);
            }

            @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
            public boolean hasLeadingComments() {
                if ((this.bitField0_ & 1) != 0) {
                    return true;
                }
                return false;
            }

            @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
            public boolean hasTrailingComments() {
                if ((this.bitField0_ & 2) != 0) {
                    return true;
                }
                return false;
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                switch (AnonymousClass1.f33300a[methodToInvoke.ordinal()]) {
                    case 1:
                        return new Location();
                    case 2:
                        return new Builder(null);
                    case 3:
                        return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0001\u0005\u0000\u0001\u0001\u0006\u0005\u0000\u0003\u0000\u0001'\u0002'\u0003ဈ\u0000\u0004ဈ\u0001\u0006\u001a", new Object[]{"bitField0_", "path_", "span_", "leadingComments_", "trailingComments_", "leadingDetachedComments_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<Location> parser = PARSER;
                        if (parser == null) {
                            synchronized (Location.class) {
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

            public static Builder newBuilder(Location location) {
                return DEFAULT_INSTANCE.r(location);
            }

            public static Location parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Location) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Location parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (Location) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static Location parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (Location) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
            }

            public static Location parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (Location) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static Location parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (Location) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
            }

            public static Location parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (Location) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static Location parseFrom(InputStream inputStream) throws IOException {
                return (Location) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
            }

            public static Location parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Location) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Location parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (Location) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
            }

            public static Location parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Location) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }
        }

        /* loaded from: classes6.dex */
        public interface LocationOrBuilder extends MessageLiteOrBuilder {
            String getLeadingComments();

            ByteString getLeadingCommentsBytes();

            String getLeadingDetachedComments(int i4);

            ByteString getLeadingDetachedCommentsBytes(int i4);

            int getLeadingDetachedCommentsCount();

            List<String> getLeadingDetachedCommentsList();

            int getPath(int i4);

            int getPathCount();

            List<Integer> getPathList();

            int getSpan(int i4);

            int getSpanCount();

            List<Integer> getSpanList();

            String getTrailingComments();

            ByteString getTrailingCommentsBytes();

            boolean hasLeadingComments();

            boolean hasTrailingComments();
        }

        static {
            SourceCodeInfo sourceCodeInfo = new SourceCodeInfo();
            DEFAULT_INSTANCE = sourceCodeInfo;
            GeneratedMessageLite.d0(SourceCodeInfo.class, sourceCodeInfo);
        }

        private SourceCodeInfo() {
        }

        public static SourceCodeInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void m0(Iterable<? extends Location> iterable) {
            q0();
            AbstractMessageLite.a(iterable, this.location_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n0(int i4, Location location) {
            location.getClass();
            q0();
            this.location_.add(i4, location);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.q();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void o0(Location location) {
            location.getClass();
            q0();
            this.location_.add(location);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void p0() {
            this.location_ = GeneratedMessageLite.y();
        }

        public static SourceCodeInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (SourceCodeInfo) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
        }

        public static SourceCodeInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (SourceCodeInfo) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<SourceCodeInfo> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        private void q0() {
            Internal.ProtobufList<Location> protobufList = this.location_;
            if (!protobufList.isModifiable()) {
                this.location_ = GeneratedMessageLite.K(protobufList);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void r0(int i4) {
            q0();
            this.location_.remove(i4);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s0(int i4, Location location) {
            location.getClass();
            q0();
            this.location_.set(i4, location);
        }

        @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfoOrBuilder
        public Location getLocation(int i4) {
            return this.location_.get(i4);
        }

        @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfoOrBuilder
        public int getLocationCount() {
            return this.location_.size();
        }

        @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfoOrBuilder
        public List<Location> getLocationList() {
            return this.location_;
        }

        public LocationOrBuilder getLocationOrBuilder(int i4) {
            return this.location_.get(i4);
        }

        public List<? extends LocationOrBuilder> getLocationOrBuilderList() {
            return this.location_;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (AnonymousClass1.f33300a[methodToInvoke.ordinal()]) {
                case 1:
                    return new SourceCodeInfo();
                case 2:
                    return new Builder(null);
                case 3:
                    return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"location_", Location.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<SourceCodeInfo> parser = PARSER;
                    if (parser == null) {
                        synchronized (SourceCodeInfo.class) {
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

        public static Builder newBuilder(SourceCodeInfo sourceCodeInfo) {
            return DEFAULT_INSTANCE.r(sourceCodeInfo);
        }

        public static SourceCodeInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SourceCodeInfo) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static SourceCodeInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SourceCodeInfo) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static SourceCodeInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (SourceCodeInfo) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
        }

        public static SourceCodeInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SourceCodeInfo) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static SourceCodeInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (SourceCodeInfo) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
        }

        public static SourceCodeInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SourceCodeInfo) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static SourceCodeInfo parseFrom(InputStream inputStream) throws IOException {
            return (SourceCodeInfo) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
        }

        public static SourceCodeInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SourceCodeInfo) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static SourceCodeInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (SourceCodeInfo) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
        }

        public static SourceCodeInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SourceCodeInfo) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: classes6.dex */
    public interface SourceCodeInfoOrBuilder extends MessageLiteOrBuilder {
        SourceCodeInfo.Location getLocation(int i4);

        int getLocationCount();

        List<SourceCodeInfo.Location> getLocationList();
    }

    /* loaded from: classes6.dex */
    public static final class UninterpretedOption extends GeneratedMessageLite<UninterpretedOption, Builder> implements UninterpretedOptionOrBuilder {
        public static final int AGGREGATE_VALUE_FIELD_NUMBER = 8;
        private static final UninterpretedOption DEFAULT_INSTANCE;
        public static final int DOUBLE_VALUE_FIELD_NUMBER = 6;
        public static final int IDENTIFIER_VALUE_FIELD_NUMBER = 3;
        public static final int NAME_FIELD_NUMBER = 2;
        public static final int NEGATIVE_INT_VALUE_FIELD_NUMBER = 5;
        private static volatile Parser<UninterpretedOption> PARSER = null;
        public static final int POSITIVE_INT_VALUE_FIELD_NUMBER = 4;
        public static final int STRING_VALUE_FIELD_NUMBER = 7;
        private int bitField0_;
        private double doubleValue_;
        private long negativeIntValue_;
        private long positiveIntValue_;
        private byte memoizedIsInitialized = 2;
        private Internal.ProtobufList<NamePart> name_ = GeneratedMessageLite.y();
        private String identifierValue_ = "";
        private ByteString stringValue_ = ByteString.EMPTY;
        private String aggregateValue_ = "";

        /* loaded from: classes6.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<UninterpretedOption, Builder> implements UninterpretedOptionOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder addAllName(Iterable<? extends NamePart> iterable) {
                f();
                ((UninterpretedOption) this.f33398b).A0(iterable);
                return this;
            }

            public Builder addName(NamePart namePart) {
                f();
                ((UninterpretedOption) this.f33398b).C0(namePart);
                return this;
            }

            public Builder clearAggregateValue() {
                f();
                ((UninterpretedOption) this.f33398b).D0();
                return this;
            }

            public Builder clearDoubleValue() {
                f();
                ((UninterpretedOption) this.f33398b).E0();
                return this;
            }

            public Builder clearIdentifierValue() {
                f();
                ((UninterpretedOption) this.f33398b).F0();
                return this;
            }

            public Builder clearName() {
                f();
                ((UninterpretedOption) this.f33398b).G0();
                return this;
            }

            public Builder clearNegativeIntValue() {
                f();
                ((UninterpretedOption) this.f33398b).H0();
                return this;
            }

            public Builder clearPositiveIntValue() {
                f();
                ((UninterpretedOption) this.f33398b).I0();
                return this;
            }

            public Builder clearStringValue() {
                f();
                ((UninterpretedOption) this.f33398b).J0();
                return this;
            }

            @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
            public String getAggregateValue() {
                return ((UninterpretedOption) this.f33398b).getAggregateValue();
            }

            @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
            public ByteString getAggregateValueBytes() {
                return ((UninterpretedOption) this.f33398b).getAggregateValueBytes();
            }

            @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
            public double getDoubleValue() {
                return ((UninterpretedOption) this.f33398b).getDoubleValue();
            }

            @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
            public String getIdentifierValue() {
                return ((UninterpretedOption) this.f33398b).getIdentifierValue();
            }

            @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
            public ByteString getIdentifierValueBytes() {
                return ((UninterpretedOption) this.f33398b).getIdentifierValueBytes();
            }

            @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
            public NamePart getName(int i4) {
                return ((UninterpretedOption) this.f33398b).getName(i4);
            }

            @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
            public int getNameCount() {
                return ((UninterpretedOption) this.f33398b).getNameCount();
            }

            @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
            public List<NamePart> getNameList() {
                return Collections.unmodifiableList(((UninterpretedOption) this.f33398b).getNameList());
            }

            @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
            public long getNegativeIntValue() {
                return ((UninterpretedOption) this.f33398b).getNegativeIntValue();
            }

            @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
            public long getPositiveIntValue() {
                return ((UninterpretedOption) this.f33398b).getPositiveIntValue();
            }

            @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
            public ByteString getStringValue() {
                return ((UninterpretedOption) this.f33398b).getStringValue();
            }

            @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
            public boolean hasAggregateValue() {
                return ((UninterpretedOption) this.f33398b).hasAggregateValue();
            }

            @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
            public boolean hasDoubleValue() {
                return ((UninterpretedOption) this.f33398b).hasDoubleValue();
            }

            @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
            public boolean hasIdentifierValue() {
                return ((UninterpretedOption) this.f33398b).hasIdentifierValue();
            }

            @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
            public boolean hasNegativeIntValue() {
                return ((UninterpretedOption) this.f33398b).hasNegativeIntValue();
            }

            @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
            public boolean hasPositiveIntValue() {
                return ((UninterpretedOption) this.f33398b).hasPositiveIntValue();
            }

            @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
            public boolean hasStringValue() {
                return ((UninterpretedOption) this.f33398b).hasStringValue();
            }

            public Builder removeName(int i4) {
                f();
                ((UninterpretedOption) this.f33398b).L0(i4);
                return this;
            }

            public Builder setAggregateValue(String str) {
                f();
                ((UninterpretedOption) this.f33398b).M0(str);
                return this;
            }

            public Builder setAggregateValueBytes(ByteString byteString) {
                f();
                ((UninterpretedOption) this.f33398b).N0(byteString);
                return this;
            }

            public Builder setDoubleValue(double d4) {
                f();
                ((UninterpretedOption) this.f33398b).O0(d4);
                return this;
            }

            public Builder setIdentifierValue(String str) {
                f();
                ((UninterpretedOption) this.f33398b).P0(str);
                return this;
            }

            public Builder setIdentifierValueBytes(ByteString byteString) {
                f();
                ((UninterpretedOption) this.f33398b).Q0(byteString);
                return this;
            }

            public Builder setName(int i4, NamePart namePart) {
                f();
                ((UninterpretedOption) this.f33398b).R0(i4, namePart);
                return this;
            }

            public Builder setNegativeIntValue(long j4) {
                f();
                ((UninterpretedOption) this.f33398b).S0(j4);
                return this;
            }

            public Builder setPositiveIntValue(long j4) {
                f();
                ((UninterpretedOption) this.f33398b).T0(j4);
                return this;
            }

            public Builder setStringValue(ByteString byteString) {
                f();
                ((UninterpretedOption) this.f33398b).U0(byteString);
                return this;
            }

            private Builder() {
                super(UninterpretedOption.DEFAULT_INSTANCE);
            }

            public Builder addName(int i4, NamePart namePart) {
                f();
                ((UninterpretedOption) this.f33398b).B0(i4, namePart);
                return this;
            }

            public Builder setName(int i4, NamePart.Builder builder) {
                f();
                ((UninterpretedOption) this.f33398b).R0(i4, builder.build());
                return this;
            }

            public Builder addName(NamePart.Builder builder) {
                f();
                ((UninterpretedOption) this.f33398b).C0(builder.build());
                return this;
            }

            public Builder addName(int i4, NamePart.Builder builder) {
                f();
                ((UninterpretedOption) this.f33398b).B0(i4, builder.build());
                return this;
            }
        }

        /* loaded from: classes6.dex */
        public static final class NamePart extends GeneratedMessageLite<NamePart, Builder> implements NamePartOrBuilder {
            private static final NamePart DEFAULT_INSTANCE;
            public static final int IS_EXTENSION_FIELD_NUMBER = 2;
            public static final int NAME_PART_FIELD_NUMBER = 1;
            private static volatile Parser<NamePart> PARSER;
            private int bitField0_;
            private boolean isExtension_;
            private byte memoizedIsInitialized = 2;
            private String namePart_ = "";

            /* loaded from: classes6.dex */
            public static final class Builder extends GeneratedMessageLite.Builder<NamePart, Builder> implements NamePartOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                public Builder clearIsExtension() {
                    f();
                    ((NamePart) this.f33398b).l0();
                    return this;
                }

                public Builder clearNamePart() {
                    f();
                    ((NamePart) this.f33398b).m0();
                    return this;
                }

                @Override // com.google.protobuf.DescriptorProtos.UninterpretedOption.NamePartOrBuilder
                public boolean getIsExtension() {
                    return ((NamePart) this.f33398b).getIsExtension();
                }

                @Override // com.google.protobuf.DescriptorProtos.UninterpretedOption.NamePartOrBuilder
                public String getNamePart() {
                    return ((NamePart) this.f33398b).getNamePart();
                }

                @Override // com.google.protobuf.DescriptorProtos.UninterpretedOption.NamePartOrBuilder
                public ByteString getNamePartBytes() {
                    return ((NamePart) this.f33398b).getNamePartBytes();
                }

                @Override // com.google.protobuf.DescriptorProtos.UninterpretedOption.NamePartOrBuilder
                public boolean hasIsExtension() {
                    return ((NamePart) this.f33398b).hasIsExtension();
                }

                @Override // com.google.protobuf.DescriptorProtos.UninterpretedOption.NamePartOrBuilder
                public boolean hasNamePart() {
                    return ((NamePart) this.f33398b).hasNamePart();
                }

                public Builder setIsExtension(boolean z3) {
                    f();
                    ((NamePart) this.f33398b).n0(z3);
                    return this;
                }

                public Builder setNamePart(String str) {
                    f();
                    ((NamePart) this.f33398b).o0(str);
                    return this;
                }

                public Builder setNamePartBytes(ByteString byteString) {
                    f();
                    ((NamePart) this.f33398b).p0(byteString);
                    return this;
                }

                private Builder() {
                    super(NamePart.DEFAULT_INSTANCE);
                }
            }

            static {
                NamePart namePart = new NamePart();
                DEFAULT_INSTANCE = namePart;
                GeneratedMessageLite.d0(NamePart.class, namePart);
            }

            private NamePart() {
            }

            public static NamePart getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void l0() {
                this.bitField0_ &= -3;
                this.isExtension_ = false;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void m0() {
                this.bitField0_ &= -2;
                this.namePart_ = getDefaultInstance().getNamePart();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void n0(boolean z3) {
                this.bitField0_ |= 2;
                this.isExtension_ = z3;
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.q();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void o0(String str) {
                str.getClass();
                this.bitField0_ |= 1;
                this.namePart_ = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void p0(ByteString byteString) {
                this.namePart_ = byteString.toStringUtf8();
                this.bitField0_ |= 1;
            }

            public static NamePart parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (NamePart) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
            }

            public static NamePart parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return (NamePart) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
            }

            public static Parser<NamePart> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }

            @Override // com.google.protobuf.DescriptorProtos.UninterpretedOption.NamePartOrBuilder
            public boolean getIsExtension() {
                return this.isExtension_;
            }

            @Override // com.google.protobuf.DescriptorProtos.UninterpretedOption.NamePartOrBuilder
            public String getNamePart() {
                return this.namePart_;
            }

            @Override // com.google.protobuf.DescriptorProtos.UninterpretedOption.NamePartOrBuilder
            public ByteString getNamePartBytes() {
                return ByteString.copyFromUtf8(this.namePart_);
            }

            @Override // com.google.protobuf.DescriptorProtos.UninterpretedOption.NamePartOrBuilder
            public boolean hasIsExtension() {
                if ((this.bitField0_ & 2) != 0) {
                    return true;
                }
                return false;
            }

            @Override // com.google.protobuf.DescriptorProtos.UninterpretedOption.NamePartOrBuilder
            public boolean hasNamePart() {
                if ((this.bitField0_ & 1) != 0) {
                    return true;
                }
                return false;
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                int i4 = 1;
                switch (AnonymousClass1.f33300a[methodToInvoke.ordinal()]) {
                    case 1:
                        return new NamePart();
                    case 2:
                        return new Builder(null);
                    case 3:
                        return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0002\u0001ᔈ\u0000\u0002ᔇ\u0001", new Object[]{"bitField0_", "namePart_", "isExtension_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<NamePart> parser = PARSER;
                        if (parser == null) {
                            synchronized (NamePart.class) {
                                parser = PARSER;
                                if (parser == null) {
                                    parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                    PARSER = parser;
                                }
                            }
                        }
                        return parser;
                    case 6:
                        return Byte.valueOf(this.memoizedIsInitialized);
                    case 7:
                        if (obj == null) {
                            i4 = 0;
                        }
                        this.memoizedIsInitialized = (byte) i4;
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            public static Builder newBuilder(NamePart namePart) {
                return DEFAULT_INSTANCE.r(namePart);
            }

            public static NamePart parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (NamePart) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static NamePart parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (NamePart) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static NamePart parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (NamePart) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
            }

            public static NamePart parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (NamePart) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static NamePart parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (NamePart) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
            }

            public static NamePart parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (NamePart) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static NamePart parseFrom(InputStream inputStream) throws IOException {
                return (NamePart) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
            }

            public static NamePart parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (NamePart) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static NamePart parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (NamePart) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
            }

            public static NamePart parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (NamePart) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }
        }

        /* loaded from: classes6.dex */
        public interface NamePartOrBuilder extends MessageLiteOrBuilder {
            boolean getIsExtension();

            String getNamePart();

            ByteString getNamePartBytes();

            boolean hasIsExtension();

            boolean hasNamePart();
        }

        static {
            UninterpretedOption uninterpretedOption = new UninterpretedOption();
            DEFAULT_INSTANCE = uninterpretedOption;
            GeneratedMessageLite.d0(UninterpretedOption.class, uninterpretedOption);
        }

        private UninterpretedOption() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void A0(Iterable<? extends NamePart> iterable) {
            K0();
            AbstractMessageLite.a(iterable, this.name_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void B0(int i4, NamePart namePart) {
            namePart.getClass();
            K0();
            this.name_.add(i4, namePart);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void C0(NamePart namePart) {
            namePart.getClass();
            K0();
            this.name_.add(namePart);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void D0() {
            this.bitField0_ &= -33;
            this.aggregateValue_ = getDefaultInstance().getAggregateValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void E0() {
            this.bitField0_ &= -9;
            this.doubleValue_ = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void F0() {
            this.bitField0_ &= -2;
            this.identifierValue_ = getDefaultInstance().getIdentifierValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void G0() {
            this.name_ = GeneratedMessageLite.y();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void H0() {
            this.bitField0_ &= -5;
            this.negativeIntValue_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void I0() {
            this.bitField0_ &= -3;
            this.positiveIntValue_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void J0() {
            this.bitField0_ &= -17;
            this.stringValue_ = getDefaultInstance().getStringValue();
        }

        private void K0() {
            Internal.ProtobufList<NamePart> protobufList = this.name_;
            if (!protobufList.isModifiable()) {
                this.name_ = GeneratedMessageLite.K(protobufList);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void L0(int i4) {
            K0();
            this.name_.remove(i4);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void M0(String str) {
            str.getClass();
            this.bitField0_ |= 32;
            this.aggregateValue_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void N0(ByteString byteString) {
            this.aggregateValue_ = byteString.toStringUtf8();
            this.bitField0_ |= 32;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void O0(double d4) {
            this.bitField0_ |= 8;
            this.doubleValue_ = d4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void P0(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.identifierValue_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Q0(ByteString byteString) {
            this.identifierValue_ = byteString.toStringUtf8();
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void R0(int i4, NamePart namePart) {
            namePart.getClass();
            K0();
            this.name_.set(i4, namePart);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void S0(long j4) {
            this.bitField0_ |= 4;
            this.negativeIntValue_ = j4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void T0(long j4) {
            this.bitField0_ |= 2;
            this.positiveIntValue_ = j4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void U0(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 16;
            this.stringValue_ = byteString;
        }

        public static UninterpretedOption getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.q();
        }

        public static UninterpretedOption parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (UninterpretedOption) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
        }

        public static UninterpretedOption parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (UninterpretedOption) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<UninterpretedOption> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
        public String getAggregateValue() {
            return this.aggregateValue_;
        }

        @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
        public ByteString getAggregateValueBytes() {
            return ByteString.copyFromUtf8(this.aggregateValue_);
        }

        @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
        public double getDoubleValue() {
            return this.doubleValue_;
        }

        @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
        public String getIdentifierValue() {
            return this.identifierValue_;
        }

        @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
        public ByteString getIdentifierValueBytes() {
            return ByteString.copyFromUtf8(this.identifierValue_);
        }

        @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
        public NamePart getName(int i4) {
            return this.name_.get(i4);
        }

        @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
        public int getNameCount() {
            return this.name_.size();
        }

        @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
        public List<NamePart> getNameList() {
            return this.name_;
        }

        public NamePartOrBuilder getNameOrBuilder(int i4) {
            return this.name_.get(i4);
        }

        public List<? extends NamePartOrBuilder> getNameOrBuilderList() {
            return this.name_;
        }

        @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
        public long getNegativeIntValue() {
            return this.negativeIntValue_;
        }

        @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
        public long getPositiveIntValue() {
            return this.positiveIntValue_;
        }

        @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
        public ByteString getStringValue() {
            return this.stringValue_;
        }

        @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
        public boolean hasAggregateValue() {
            if ((this.bitField0_ & 32) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
        public boolean hasDoubleValue() {
            if ((this.bitField0_ & 8) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
        public boolean hasIdentifierValue() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
        public boolean hasNegativeIntValue() {
            if ((this.bitField0_ & 4) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
        public boolean hasPositiveIntValue() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
        public boolean hasStringValue() {
            if ((this.bitField0_ & 16) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            int i4 = 1;
            switch (AnonymousClass1.f33300a[methodToInvoke.ordinal()]) {
                case 1:
                    return new UninterpretedOption();
                case 2:
                    return new Builder(null);
                case 3:
                    return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0001\u0007\u0000\u0001\u0002\b\u0007\u0000\u0001\u0001\u0002Л\u0003ဈ\u0000\u0004ဃ\u0001\u0005ဂ\u0002\u0006က\u0003\u0007ည\u0004\bဈ\u0005", new Object[]{"bitField0_", "name_", NamePart.class, "identifierValue_", "positiveIntValue_", "negativeIntValue_", "doubleValue_", "stringValue_", "aggregateValue_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<UninterpretedOption> parser = PARSER;
                    if (parser == null) {
                        synchronized (UninterpretedOption.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case 6:
                    return Byte.valueOf(this.memoizedIsInitialized);
                case 7:
                    if (obj == null) {
                        i4 = 0;
                    }
                    this.memoizedIsInitialized = (byte) i4;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static Builder newBuilder(UninterpretedOption uninterpretedOption) {
            return DEFAULT_INSTANCE.r(uninterpretedOption);
        }

        public static UninterpretedOption parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (UninterpretedOption) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static UninterpretedOption parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (UninterpretedOption) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static UninterpretedOption parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (UninterpretedOption) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
        }

        public static UninterpretedOption parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (UninterpretedOption) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static UninterpretedOption parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (UninterpretedOption) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
        }

        public static UninterpretedOption parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (UninterpretedOption) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static UninterpretedOption parseFrom(InputStream inputStream) throws IOException {
            return (UninterpretedOption) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
        }

        public static UninterpretedOption parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (UninterpretedOption) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static UninterpretedOption parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (UninterpretedOption) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
        }

        public static UninterpretedOption parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (UninterpretedOption) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: classes6.dex */
    public interface UninterpretedOptionOrBuilder extends MessageLiteOrBuilder {
        String getAggregateValue();

        ByteString getAggregateValueBytes();

        double getDoubleValue();

        String getIdentifierValue();

        ByteString getIdentifierValueBytes();

        UninterpretedOption.NamePart getName(int i4);

        int getNameCount();

        List<UninterpretedOption.NamePart> getNameList();

        long getNegativeIntValue();

        long getPositiveIntValue();

        ByteString getStringValue();

        boolean hasAggregateValue();

        boolean hasDoubleValue();

        boolean hasIdentifierValue();

        boolean hasNegativeIntValue();

        boolean hasPositiveIntValue();

        boolean hasStringValue();
    }

    private DescriptorProtos() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}
