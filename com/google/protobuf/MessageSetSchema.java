package com.google.protobuf;

import com.google.protobuf.FieldSet;
import com.google.protobuf.LazyField;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

@CheckReturnValue
/* loaded from: classes6.dex */
final class MessageSetSchema<T> implements Schema<T> {

    /* renamed from: a  reason: collision with root package name */
    private final MessageLite f33497a;

    /* renamed from: b  reason: collision with root package name */
    private final UnknownFieldSchema<?, ?> f33498b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f33499c;

    /* renamed from: d  reason: collision with root package name */
    private final ExtensionSchema<?> f33500d;

    private MessageSetSchema(UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MessageLite messageLite) {
        this.f33498b = unknownFieldSchema;
        this.f33499c = extensionSchema.e(messageLite);
        this.f33500d = extensionSchema;
        this.f33497a = messageLite;
    }

    private <UT, UB> int d(UnknownFieldSchema<UT, UB> unknownFieldSchema, T t3) {
        return unknownFieldSchema.i(unknownFieldSchema.g(t3));
    }

    private <UT, UB, ET extends FieldSet.FieldDescriptorLite<ET>> void e(UnknownFieldSchema<UT, UB> unknownFieldSchema, ExtensionSchema<ET> extensionSchema, T t3, Reader reader, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        UB f4 = unknownFieldSchema.f(t3);
        FieldSet<ET> d4 = extensionSchema.d(t3);
        do {
            try {
                if (reader.getFieldNumber() == Integer.MAX_VALUE) {
                    return;
                }
            } finally {
                unknownFieldSchema.o(t3, f4);
            }
        } while (g(reader, extensionRegistryLite, extensionSchema, d4, unknownFieldSchema, f4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> MessageSetSchema<T> f(UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MessageLite messageLite) {
        return new MessageSetSchema<>(unknownFieldSchema, extensionSchema, messageLite);
    }

    private <UT, UB, ET extends FieldSet.FieldDescriptorLite<ET>> boolean g(Reader reader, ExtensionRegistryLite extensionRegistryLite, ExtensionSchema<ET> extensionSchema, FieldSet<ET> fieldSet, UnknownFieldSchema<UT, UB> unknownFieldSchema, UB ub) throws IOException {
        int tag = reader.getTag();
        if (tag != WireFormat.f33626a) {
            if (WireFormat.getTagWireType(tag) == 2) {
                Object b4 = extensionSchema.b(extensionRegistryLite, this.f33497a, WireFormat.getTagFieldNumber(tag));
                if (b4 != null) {
                    extensionSchema.h(reader, b4, extensionRegistryLite, fieldSet);
                    return true;
                }
                return unknownFieldSchema.m(ub, reader);
            }
            return reader.skipField();
        }
        Object obj = null;
        ByteString byteString = null;
        int i4 = 0;
        while (reader.getFieldNumber() != Integer.MAX_VALUE) {
            int tag2 = reader.getTag();
            if (tag2 == WireFormat.f33628c) {
                i4 = reader.readUInt32();
                obj = extensionSchema.b(extensionRegistryLite, this.f33497a, i4);
            } else if (tag2 == WireFormat.f33629d) {
                if (obj != null) {
                    extensionSchema.h(reader, obj, extensionRegistryLite, fieldSet);
                } else {
                    byteString = reader.readBytes();
                }
            } else if (!reader.skipField()) {
                break;
            }
        }
        if (reader.getTag() == WireFormat.f33627b) {
            if (byteString != null) {
                if (obj != null) {
                    extensionSchema.i(byteString, obj, extensionRegistryLite, fieldSet);
                } else {
                    unknownFieldSchema.d(ub, i4, byteString);
                }
            }
            return true;
        }
        throw InvalidProtocolBufferException.b();
    }

    private <UT, UB> void h(UnknownFieldSchema<UT, UB> unknownFieldSchema, T t3, Writer writer) throws IOException {
        unknownFieldSchema.s(unknownFieldSchema.g(t3), writer);
    }

    @Override // com.google.protobuf.Schema
    public void a(T t3, Writer writer) throws IOException {
        Iterator<Map.Entry<?, Object>> x3 = this.f33500d.c(t3).x();
        while (x3.hasNext()) {
            Map.Entry<?, Object> next = x3.next();
            FieldSet.FieldDescriptorLite fieldDescriptorLite = (FieldSet.FieldDescriptorLite) next.getKey();
            if (fieldDescriptorLite.getLiteJavaType() == WireFormat.JavaType.MESSAGE && !fieldDescriptorLite.isRepeated() && !fieldDescriptorLite.isPacked()) {
                if (next instanceof LazyField.LazyEntry) {
                    writer.writeMessageSetItem(fieldDescriptorLite.getNumber(), ((LazyField.LazyEntry) next).a().toByteString());
                } else {
                    writer.writeMessageSetItem(fieldDescriptorLite.getNumber(), next.getValue());
                }
            } else {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
        }
        h(this.f33498b, t3, writer);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00cb A[EDGE_INSN: B:57:0x00cb->B:34:0x00cb ?: BREAK  , SYNTHETIC] */
    @Override // com.google.protobuf.Schema
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b(T r11, byte[] r12, int r13, int r14, com.google.protobuf.ArrayDecoders.Registers r15) throws java.io.IOException {
        /*
            r10 = this;
            r0 = r11
            com.google.protobuf.GeneratedMessageLite r0 = (com.google.protobuf.GeneratedMessageLite) r0
            com.google.protobuf.UnknownFieldSetLite r1 = r0.unknownFields
            com.google.protobuf.UnknownFieldSetLite r2 = com.google.protobuf.UnknownFieldSetLite.getDefaultInstance()
            if (r1 != r2) goto L11
            com.google.protobuf.UnknownFieldSetLite r1 = com.google.protobuf.UnknownFieldSetLite.g()
            r0.unknownFields = r1
        L11:
            com.google.protobuf.GeneratedMessageLite$ExtendableMessage r11 = (com.google.protobuf.GeneratedMessageLite.ExtendableMessage) r11
            com.google.protobuf.FieldSet r11 = r11.f0()
            r0 = 0
            r2 = r0
        L19:
            if (r13 >= r14) goto Ld7
            int r4 = com.google.protobuf.ArrayDecoders.I(r12, r13, r15)
            int r13 = r15.f33156a
            int r3 = com.google.protobuf.WireFormat.f33626a
            r5 = 2
            if (r13 == r3) goto L6b
            int r3 = com.google.protobuf.WireFormat.getTagWireType(r13)
            if (r3 != r5) goto L66
            com.google.protobuf.ExtensionSchema<?> r2 = r10.f33500d
            com.google.protobuf.ExtensionRegistryLite r3 = r15.f33159d
            com.google.protobuf.MessageLite r5 = r10.f33497a
            int r6 = com.google.protobuf.WireFormat.getTagFieldNumber(r13)
            java.lang.Object r2 = r2.b(r3, r5, r6)
            r8 = r2
            com.google.protobuf.GeneratedMessageLite$GeneratedExtension r8 = (com.google.protobuf.GeneratedMessageLite.GeneratedExtension) r8
            if (r8 == 0) goto L5b
            com.google.protobuf.Protobuf r13 = com.google.protobuf.Protobuf.a()
            com.google.protobuf.MessageLite r2 = r8.getMessageDefaultInstance()
            java.lang.Class r2 = r2.getClass()
            com.google.protobuf.Schema r13 = r13.c(r2)
            int r13 = com.google.protobuf.ArrayDecoders.p(r13, r12, r4, r14, r15)
            com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor r2 = r8.f33411d
            java.lang.Object r3 = r15.f33158c
            r11.D(r2, r3)
            goto L64
        L5b:
            r2 = r13
            r3 = r12
            r5 = r14
            r6 = r1
            r7 = r15
            int r13 = com.google.protobuf.ArrayDecoders.G(r2, r3, r4, r5, r6, r7)
        L64:
            r2 = r8
            goto L19
        L66:
            int r13 = com.google.protobuf.ArrayDecoders.P(r13, r12, r4, r14, r15)
            goto L19
        L6b:
            r13 = 0
            r3 = r0
        L6d:
            if (r4 >= r14) goto Lcb
            int r4 = com.google.protobuf.ArrayDecoders.I(r12, r4, r15)
            int r6 = r15.f33156a
            int r7 = com.google.protobuf.WireFormat.getTagFieldNumber(r6)
            int r8 = com.google.protobuf.WireFormat.getTagWireType(r6)
            if (r7 == r5) goto Lac
            r9 = 3
            if (r7 == r9) goto L83
            goto Lc1
        L83:
            if (r2 == 0) goto La1
            com.google.protobuf.Protobuf r6 = com.google.protobuf.Protobuf.a()
            com.google.protobuf.MessageLite r7 = r2.getMessageDefaultInstance()
            java.lang.Class r7 = r7.getClass()
            com.google.protobuf.Schema r6 = r6.c(r7)
            int r4 = com.google.protobuf.ArrayDecoders.p(r6, r12, r4, r14, r15)
            com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor r6 = r2.f33411d
            java.lang.Object r7 = r15.f33158c
            r11.D(r6, r7)
            goto L6d
        La1:
            if (r8 != r5) goto Lc1
            int r4 = com.google.protobuf.ArrayDecoders.b(r12, r4, r15)
            java.lang.Object r3 = r15.f33158c
            com.google.protobuf.ByteString r3 = (com.google.protobuf.ByteString) r3
            goto L6d
        Lac:
            if (r8 != 0) goto Lc1
            int r4 = com.google.protobuf.ArrayDecoders.I(r12, r4, r15)
            int r13 = r15.f33156a
            com.google.protobuf.ExtensionSchema<?> r2 = r10.f33500d
            com.google.protobuf.ExtensionRegistryLite r6 = r15.f33159d
            com.google.protobuf.MessageLite r7 = r10.f33497a
            java.lang.Object r2 = r2.b(r6, r7, r13)
            com.google.protobuf.GeneratedMessageLite$GeneratedExtension r2 = (com.google.protobuf.GeneratedMessageLite.GeneratedExtension) r2
            goto L6d
        Lc1:
            int r7 = com.google.protobuf.WireFormat.f33627b
            if (r6 != r7) goto Lc6
            goto Lcb
        Lc6:
            int r4 = com.google.protobuf.ArrayDecoders.P(r6, r12, r4, r14, r15)
            goto L6d
        Lcb:
            if (r3 == 0) goto Ld4
            int r13 = com.google.protobuf.WireFormat.a(r13, r5)
            r1.j(r13, r3)
        Ld4:
            r13 = r4
            goto L19
        Ld7:
            if (r13 != r14) goto Lda
            return
        Lda:
            com.google.protobuf.InvalidProtocolBufferException r11 = com.google.protobuf.InvalidProtocolBufferException.i()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageSetSchema.b(java.lang.Object, byte[], int, int, com.google.protobuf.ArrayDecoders$Registers):void");
    }

    @Override // com.google.protobuf.Schema
    public void c(T t3, Reader reader, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        e(this.f33498b, this.f33500d, t3, reader, extensionRegistryLite);
    }

    @Override // com.google.protobuf.Schema
    public boolean equals(T t3, T t4) {
        if (!this.f33498b.g(t3).equals(this.f33498b.g(t4))) {
            return false;
        }
        if (this.f33499c) {
            return this.f33500d.c(t3).equals(this.f33500d.c(t4));
        }
        return true;
    }

    @Override // com.google.protobuf.Schema
    public int getSerializedSize(T t3) {
        int d4 = d(this.f33498b, t3) + 0;
        if (this.f33499c) {
            return d4 + this.f33500d.c(t3).k();
        }
        return d4;
    }

    @Override // com.google.protobuf.Schema
    public int hashCode(T t3) {
        int hashCode = this.f33498b.g(t3).hashCode();
        if (this.f33499c) {
            return (hashCode * 53) + this.f33500d.c(t3).hashCode();
        }
        return hashCode;
    }

    @Override // com.google.protobuf.Schema
    public final boolean isInitialized(T t3) {
        return this.f33500d.c(t3).t();
    }

    @Override // com.google.protobuf.Schema
    public void makeImmutable(T t3) {
        this.f33498b.j(t3);
        this.f33500d.f(t3);
    }

    @Override // com.google.protobuf.Schema
    public void mergeFrom(T t3, T t4) {
        SchemaUtil.G(this.f33498b, t3, t4);
        if (this.f33499c) {
            SchemaUtil.E(this.f33500d, t3, t4);
        }
    }

    @Override // com.google.protobuf.Schema
    public T newInstance() {
        MessageLite messageLite = this.f33497a;
        if (messageLite instanceof GeneratedMessageLite) {
            return (T) ((GeneratedMessageLite) messageLite).M();
        }
        return (T) messageLite.newBuilderForType().buildPartial();
    }
}
