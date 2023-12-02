package com.google.protobuf;

import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
@CheckReturnValue
/* loaded from: classes6.dex */
public final class CodedInputStreamReader implements Reader {

    /* renamed from: a  reason: collision with root package name */
    private final CodedInputStream f33267a;

    /* renamed from: b  reason: collision with root package name */
    private int f33268b;

    /* renamed from: c  reason: collision with root package name */
    private int f33269c;

    /* renamed from: d  reason: collision with root package name */
    private int f33270d = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.protobuf.CodedInputStreamReader$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f33271a;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            f33271a = iArr;
            try {
                iArr[WireFormat.FieldType.BOOL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f33271a[WireFormat.FieldType.BYTES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f33271a[WireFormat.FieldType.DOUBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f33271a[WireFormat.FieldType.ENUM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f33271a[WireFormat.FieldType.FIXED32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f33271a[WireFormat.FieldType.FIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f33271a[WireFormat.FieldType.FLOAT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f33271a[WireFormat.FieldType.INT32.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f33271a[WireFormat.FieldType.INT64.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f33271a[WireFormat.FieldType.MESSAGE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f33271a[WireFormat.FieldType.SFIXED32.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f33271a[WireFormat.FieldType.SFIXED64.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f33271a[WireFormat.FieldType.SINT32.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f33271a[WireFormat.FieldType.SINT64.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f33271a[WireFormat.FieldType.STRING.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f33271a[WireFormat.FieldType.UINT32.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f33271a[WireFormat.FieldType.UINT64.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    private CodedInputStreamReader(CodedInputStream codedInputStream) {
        CodedInputStream codedInputStream2 = (CodedInputStream) Internal.b(codedInputStream, "input");
        this.f33267a = codedInputStream2;
        codedInputStream2.f33219d = this;
    }

    public static CodedInputStreamReader h(CodedInputStream codedInputStream) {
        CodedInputStreamReader codedInputStreamReader = codedInputStream.f33219d;
        if (codedInputStreamReader != null) {
            return codedInputStreamReader;
        }
        return new CodedInputStreamReader(codedInputStream);
    }

    private <T> void i(T t3, Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        int i4 = this.f33269c;
        this.f33269c = WireFormat.a(WireFormat.getTagFieldNumber(this.f33268b), 4);
        try {
            schema.c(t3, this, extensionRegistryLite);
            if (this.f33268b == this.f33269c) {
                return;
            }
            throw InvalidProtocolBufferException.i();
        } finally {
            this.f33269c = i4;
        }
    }

    private <T> void j(T t3, Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        CodedInputStream codedInputStream;
        int readUInt32 = this.f33267a.readUInt32();
        CodedInputStream codedInputStream2 = this.f33267a;
        if (codedInputStream2.f33216a < codedInputStream2.f33217b) {
            int pushLimit = codedInputStream2.pushLimit(readUInt32);
            this.f33267a.f33216a++;
            schema.c(t3, this, extensionRegistryLite);
            this.f33267a.checkLastTagWas(0);
            codedInputStream.f33216a--;
            this.f33267a.popLimit(pushLimit);
            return;
        }
        throw InvalidProtocolBufferException.j();
    }

    private Object k(WireFormat.FieldType fieldType, Class<?> cls, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        switch (AnonymousClass1.f33271a[fieldType.ordinal()]) {
            case 1:
                return Boolean.valueOf(readBool());
            case 2:
                return readBytes();
            case 3:
                return Double.valueOf(readDouble());
            case 4:
                return Integer.valueOf(readEnum());
            case 5:
                return Integer.valueOf(readFixed32());
            case 6:
                return Long.valueOf(readFixed64());
            case 7:
                return Float.valueOf(readFloat());
            case 8:
                return Integer.valueOf(readInt32());
            case 9:
                return Long.valueOf(readInt64());
            case 10:
                return g(cls, extensionRegistryLite);
            case 11:
                return Integer.valueOf(readSFixed32());
            case 12:
                return Long.valueOf(readSFixed64());
            case 13:
                return Integer.valueOf(readSInt32());
            case 14:
                return Long.valueOf(readSInt64());
            case 15:
                return readStringRequireUtf8();
            case 16:
                return Integer.valueOf(readUInt32());
            case 17:
                return Long.valueOf(readUInt64());
            default:
                throw new IllegalArgumentException("unsupported field type.");
        }
    }

    private <T> T l(Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        T newInstance = schema.newInstance();
        i(newInstance, schema, extensionRegistryLite);
        schema.makeImmutable(newInstance);
        return newInstance;
    }

    private <T> T m(Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        T newInstance = schema.newInstance();
        j(newInstance, schema, extensionRegistryLite);
        schema.makeImmutable(newInstance);
        return newInstance;
    }

    private void o(int i4) throws IOException {
        if (this.f33267a.getTotalBytesRead() == i4) {
            return;
        }
        throw InvalidProtocolBufferException.n();
    }

    private void p(int i4) throws IOException {
        if (WireFormat.getTagWireType(this.f33268b) == i4) {
            return;
        }
        throw InvalidProtocolBufferException.f();
    }

    private void q(int i4) throws IOException {
        if ((i4 & 3) == 0) {
            return;
        }
        throw InvalidProtocolBufferException.i();
    }

    private void r(int i4) throws IOException {
        if ((i4 & 7) == 0) {
            return;
        }
        throw InvalidProtocolBufferException.i();
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x005c, code lost:
        r8.put(r2, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0064, code lost:
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.Reader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public <K, V> void a(java.util.Map<K, V> r8, com.google.protobuf.MapEntryLite.Metadata<K, V> r9, com.google.protobuf.ExtensionRegistryLite r10) throws java.io.IOException {
        /*
            r7 = this;
            r0 = 2
            r7.p(r0)
            com.google.protobuf.CodedInputStream r1 = r7.f33267a
            int r1 = r1.readUInt32()
            com.google.protobuf.CodedInputStream r2 = r7.f33267a
            int r1 = r2.pushLimit(r1)
            K r2 = r9.f33470b
            V r3 = r9.f33472d
        L14:
            int r4 = r7.getFieldNumber()     // Catch: java.lang.Throwable -> L65
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r4 == r5) goto L5c
            com.google.protobuf.CodedInputStream r5 = r7.f33267a     // Catch: java.lang.Throwable -> L65
            boolean r5 = r5.isAtEnd()     // Catch: java.lang.Throwable -> L65
            if (r5 == 0) goto L26
            goto L5c
        L26:
            r5 = 1
            java.lang.String r6 = "Unable to parse map entry."
            if (r4 == r5) goto L47
            if (r4 == r0) goto L3a
            boolean r4 = r7.skipField()     // Catch: com.google.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L4f java.lang.Throwable -> L65
            if (r4 == 0) goto L34
            goto L14
        L34:
            com.google.protobuf.InvalidProtocolBufferException r4 = new com.google.protobuf.InvalidProtocolBufferException     // Catch: com.google.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L4f java.lang.Throwable -> L65
            r4.<init>(r6)     // Catch: com.google.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L4f java.lang.Throwable -> L65
            throw r4     // Catch: com.google.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L4f java.lang.Throwable -> L65
        L3a:
            com.google.protobuf.WireFormat$FieldType r4 = r9.f33471c     // Catch: com.google.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L4f java.lang.Throwable -> L65
            V r5 = r9.f33472d     // Catch: com.google.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L4f java.lang.Throwable -> L65
            java.lang.Class r5 = r5.getClass()     // Catch: com.google.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L4f java.lang.Throwable -> L65
            java.lang.Object r3 = r7.k(r4, r5, r10)     // Catch: com.google.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L4f java.lang.Throwable -> L65
            goto L14
        L47:
            com.google.protobuf.WireFormat$FieldType r4 = r9.f33469a     // Catch: com.google.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L4f java.lang.Throwable -> L65
            r5 = 0
            java.lang.Object r2 = r7.k(r4, r5, r5)     // Catch: com.google.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L4f java.lang.Throwable -> L65
            goto L14
        L4f:
            boolean r4 = r7.skipField()     // Catch: java.lang.Throwable -> L65
            if (r4 == 0) goto L56
            goto L14
        L56:
            com.google.protobuf.InvalidProtocolBufferException r8 = new com.google.protobuf.InvalidProtocolBufferException     // Catch: java.lang.Throwable -> L65
            r8.<init>(r6)     // Catch: java.lang.Throwable -> L65
            throw r8     // Catch: java.lang.Throwable -> L65
        L5c:
            r8.put(r2, r3)     // Catch: java.lang.Throwable -> L65
            com.google.protobuf.CodedInputStream r8 = r7.f33267a
            r8.popLimit(r1)
            return
        L65:
            r8 = move-exception
            com.google.protobuf.CodedInputStream r9 = r7.f33267a
            r9.popLimit(r1)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.CodedInputStreamReader.a(java.util.Map, com.google.protobuf.MapEntryLite$Metadata, com.google.protobuf.ExtensionRegistryLite):void");
    }

    @Override // com.google.protobuf.Reader
    public <T> void b(T t3, Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        p(3);
        i(t3, schema, extensionRegistryLite);
    }

    @Override // com.google.protobuf.Reader
    public <T> void c(T t3, Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        p(2);
        j(t3, schema, extensionRegistryLite);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.Reader
    @Deprecated
    public <T> void d(List<T> list, Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        int readTag;
        if (WireFormat.getTagWireType(this.f33268b) == 3) {
            int i4 = this.f33268b;
            do {
                list.add(l(schema, extensionRegistryLite));
                if (!this.f33267a.isAtEnd() && this.f33270d == 0) {
                    readTag = this.f33267a.readTag();
                } else {
                    return;
                }
            } while (readTag == i4);
            this.f33270d = readTag;
            return;
        }
        throw InvalidProtocolBufferException.f();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.Reader
    public <T> void e(List<T> list, Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        int readTag;
        if (WireFormat.getTagWireType(this.f33268b) == 2) {
            int i4 = this.f33268b;
            do {
                list.add(m(schema, extensionRegistryLite));
                if (!this.f33267a.isAtEnd() && this.f33270d == 0) {
                    readTag = this.f33267a.readTag();
                } else {
                    return;
                }
            } while (readTag == i4);
            this.f33270d = readTag;
            return;
        }
        throw InvalidProtocolBufferException.f();
    }

    @Override // com.google.protobuf.Reader
    @Deprecated
    public <T> T f(Class<T> cls, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        p(3);
        return (T) l(Protobuf.a().c(cls), extensionRegistryLite);
    }

    @Override // com.google.protobuf.Reader
    public <T> T g(Class<T> cls, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        p(2);
        return (T) m(Protobuf.a().c(cls), extensionRegistryLite);
    }

    @Override // com.google.protobuf.Reader
    public int getFieldNumber() throws IOException {
        int i4 = this.f33270d;
        if (i4 != 0) {
            this.f33268b = i4;
            this.f33270d = 0;
        } else {
            this.f33268b = this.f33267a.readTag();
        }
        int i5 = this.f33268b;
        if (i5 != 0 && i5 != this.f33269c) {
            return WireFormat.getTagFieldNumber(i5);
        }
        return Integer.MAX_VALUE;
    }

    @Override // com.google.protobuf.Reader
    public int getTag() {
        return this.f33268b;
    }

    public void n(List<String> list, boolean z3) throws IOException {
        String readString;
        int readTag;
        int readTag2;
        if (WireFormat.getTagWireType(this.f33268b) == 2) {
            if ((list instanceof LazyStringList) && !z3) {
                LazyStringList lazyStringList = (LazyStringList) list;
                do {
                    lazyStringList.add(readBytes());
                    if (this.f33267a.isAtEnd()) {
                        return;
                    }
                    readTag2 = this.f33267a.readTag();
                } while (readTag2 == this.f33268b);
                this.f33270d = readTag2;
                return;
            }
            do {
                if (z3) {
                    readString = readStringRequireUtf8();
                } else {
                    readString = readString();
                }
                list.add(readString);
                if (this.f33267a.isAtEnd()) {
                    return;
                }
                readTag = this.f33267a.readTag();
            } while (readTag == this.f33268b);
            this.f33270d = readTag;
            return;
        }
        throw InvalidProtocolBufferException.f();
    }

    @Override // com.google.protobuf.Reader
    public boolean readBool() throws IOException {
        p(0);
        return this.f33267a.readBool();
    }

    @Override // com.google.protobuf.Reader
    public void readBoolList(List<Boolean> list) throws IOException {
        int readTag;
        int readTag2;
        if (list instanceof BooleanArrayList) {
            BooleanArrayList booleanArrayList = (BooleanArrayList) list;
            int tagWireType = WireFormat.getTagWireType(this.f33268b);
            if (tagWireType != 0) {
                if (tagWireType == 2) {
                    int totalBytesRead = this.f33267a.getTotalBytesRead() + this.f33267a.readUInt32();
                    do {
                        booleanArrayList.addBoolean(this.f33267a.readBool());
                    } while (this.f33267a.getTotalBytesRead() < totalBytesRead);
                    o(totalBytesRead);
                    return;
                }
                throw InvalidProtocolBufferException.f();
            }
            do {
                booleanArrayList.addBoolean(this.f33267a.readBool());
                if (this.f33267a.isAtEnd()) {
                    return;
                }
                readTag2 = this.f33267a.readTag();
            } while (readTag2 == this.f33268b);
            this.f33270d = readTag2;
            return;
        }
        int tagWireType2 = WireFormat.getTagWireType(this.f33268b);
        if (tagWireType2 != 0) {
            if (tagWireType2 == 2) {
                int totalBytesRead2 = this.f33267a.getTotalBytesRead() + this.f33267a.readUInt32();
                do {
                    list.add(Boolean.valueOf(this.f33267a.readBool()));
                } while (this.f33267a.getTotalBytesRead() < totalBytesRead2);
                o(totalBytesRead2);
                return;
            }
            throw InvalidProtocolBufferException.f();
        }
        do {
            list.add(Boolean.valueOf(this.f33267a.readBool()));
            if (this.f33267a.isAtEnd()) {
                return;
            }
            readTag = this.f33267a.readTag();
        } while (readTag == this.f33268b);
        this.f33270d = readTag;
    }

    @Override // com.google.protobuf.Reader
    public ByteString readBytes() throws IOException {
        p(2);
        return this.f33267a.readBytes();
    }

    @Override // com.google.protobuf.Reader
    public void readBytesList(List<ByteString> list) throws IOException {
        int readTag;
        if (WireFormat.getTagWireType(this.f33268b) == 2) {
            do {
                list.add(readBytes());
                if (this.f33267a.isAtEnd()) {
                    return;
                }
                readTag = this.f33267a.readTag();
            } while (readTag == this.f33268b);
            this.f33270d = readTag;
            return;
        }
        throw InvalidProtocolBufferException.f();
    }

    @Override // com.google.protobuf.Reader
    public double readDouble() throws IOException {
        p(1);
        return this.f33267a.readDouble();
    }

    @Override // com.google.protobuf.Reader
    public void readDoubleList(List<Double> list) throws IOException {
        int readTag;
        int readTag2;
        if (list instanceof DoubleArrayList) {
            DoubleArrayList doubleArrayList = (DoubleArrayList) list;
            int tagWireType = WireFormat.getTagWireType(this.f33268b);
            if (tagWireType != 1) {
                if (tagWireType == 2) {
                    int readUInt32 = this.f33267a.readUInt32();
                    r(readUInt32);
                    int totalBytesRead = this.f33267a.getTotalBytesRead() + readUInt32;
                    do {
                        doubleArrayList.addDouble(this.f33267a.readDouble());
                    } while (this.f33267a.getTotalBytesRead() < totalBytesRead);
                    return;
                }
                throw InvalidProtocolBufferException.f();
            }
            do {
                doubleArrayList.addDouble(this.f33267a.readDouble());
                if (this.f33267a.isAtEnd()) {
                    return;
                }
                readTag2 = this.f33267a.readTag();
            } while (readTag2 == this.f33268b);
            this.f33270d = readTag2;
            return;
        }
        int tagWireType2 = WireFormat.getTagWireType(this.f33268b);
        if (tagWireType2 != 1) {
            if (tagWireType2 == 2) {
                int readUInt322 = this.f33267a.readUInt32();
                r(readUInt322);
                int totalBytesRead2 = this.f33267a.getTotalBytesRead() + readUInt322;
                do {
                    list.add(Double.valueOf(this.f33267a.readDouble()));
                } while (this.f33267a.getTotalBytesRead() < totalBytesRead2);
                return;
            }
            throw InvalidProtocolBufferException.f();
        }
        do {
            list.add(Double.valueOf(this.f33267a.readDouble()));
            if (this.f33267a.isAtEnd()) {
                return;
            }
            readTag = this.f33267a.readTag();
        } while (readTag == this.f33268b);
        this.f33270d = readTag;
    }

    @Override // com.google.protobuf.Reader
    public int readEnum() throws IOException {
        p(0);
        return this.f33267a.readEnum();
    }

    @Override // com.google.protobuf.Reader
    public void readEnumList(List<Integer> list) throws IOException {
        int readTag;
        int readTag2;
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            int tagWireType = WireFormat.getTagWireType(this.f33268b);
            if (tagWireType != 0) {
                if (tagWireType == 2) {
                    int totalBytesRead = this.f33267a.getTotalBytesRead() + this.f33267a.readUInt32();
                    do {
                        intArrayList.addInt(this.f33267a.readEnum());
                    } while (this.f33267a.getTotalBytesRead() < totalBytesRead);
                    o(totalBytesRead);
                    return;
                }
                throw InvalidProtocolBufferException.f();
            }
            do {
                intArrayList.addInt(this.f33267a.readEnum());
                if (this.f33267a.isAtEnd()) {
                    return;
                }
                readTag2 = this.f33267a.readTag();
            } while (readTag2 == this.f33268b);
            this.f33270d = readTag2;
            return;
        }
        int tagWireType2 = WireFormat.getTagWireType(this.f33268b);
        if (tagWireType2 != 0) {
            if (tagWireType2 == 2) {
                int totalBytesRead2 = this.f33267a.getTotalBytesRead() + this.f33267a.readUInt32();
                do {
                    list.add(Integer.valueOf(this.f33267a.readEnum()));
                } while (this.f33267a.getTotalBytesRead() < totalBytesRead2);
                o(totalBytesRead2);
                return;
            }
            throw InvalidProtocolBufferException.f();
        }
        do {
            list.add(Integer.valueOf(this.f33267a.readEnum()));
            if (this.f33267a.isAtEnd()) {
                return;
            }
            readTag = this.f33267a.readTag();
        } while (readTag == this.f33268b);
        this.f33270d = readTag;
    }

    @Override // com.google.protobuf.Reader
    public int readFixed32() throws IOException {
        p(5);
        return this.f33267a.readFixed32();
    }

    @Override // com.google.protobuf.Reader
    public void readFixed32List(List<Integer> list) throws IOException {
        int readTag;
        int readTag2;
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            int tagWireType = WireFormat.getTagWireType(this.f33268b);
            if (tagWireType != 2) {
                if (tagWireType == 5) {
                    do {
                        intArrayList.addInt(this.f33267a.readFixed32());
                        if (this.f33267a.isAtEnd()) {
                            return;
                        }
                        readTag2 = this.f33267a.readTag();
                    } while (readTag2 == this.f33268b);
                    this.f33270d = readTag2;
                    return;
                }
                throw InvalidProtocolBufferException.f();
            }
            int readUInt32 = this.f33267a.readUInt32();
            q(readUInt32);
            int totalBytesRead = this.f33267a.getTotalBytesRead() + readUInt32;
            do {
                intArrayList.addInt(this.f33267a.readFixed32());
            } while (this.f33267a.getTotalBytesRead() < totalBytesRead);
            return;
        }
        int tagWireType2 = WireFormat.getTagWireType(this.f33268b);
        if (tagWireType2 != 2) {
            if (tagWireType2 == 5) {
                do {
                    list.add(Integer.valueOf(this.f33267a.readFixed32()));
                    if (this.f33267a.isAtEnd()) {
                        return;
                    }
                    readTag = this.f33267a.readTag();
                } while (readTag == this.f33268b);
                this.f33270d = readTag;
                return;
            }
            throw InvalidProtocolBufferException.f();
        }
        int readUInt322 = this.f33267a.readUInt32();
        q(readUInt322);
        int totalBytesRead2 = this.f33267a.getTotalBytesRead() + readUInt322;
        do {
            list.add(Integer.valueOf(this.f33267a.readFixed32()));
        } while (this.f33267a.getTotalBytesRead() < totalBytesRead2);
    }

    @Override // com.google.protobuf.Reader
    public long readFixed64() throws IOException {
        p(1);
        return this.f33267a.readFixed64();
    }

    @Override // com.google.protobuf.Reader
    public void readFixed64List(List<Long> list) throws IOException {
        int readTag;
        int readTag2;
        if (list instanceof LongArrayList) {
            LongArrayList longArrayList = (LongArrayList) list;
            int tagWireType = WireFormat.getTagWireType(this.f33268b);
            if (tagWireType != 1) {
                if (tagWireType == 2) {
                    int readUInt32 = this.f33267a.readUInt32();
                    r(readUInt32);
                    int totalBytesRead = this.f33267a.getTotalBytesRead() + readUInt32;
                    do {
                        longArrayList.addLong(this.f33267a.readFixed64());
                    } while (this.f33267a.getTotalBytesRead() < totalBytesRead);
                    return;
                }
                throw InvalidProtocolBufferException.f();
            }
            do {
                longArrayList.addLong(this.f33267a.readFixed64());
                if (this.f33267a.isAtEnd()) {
                    return;
                }
                readTag2 = this.f33267a.readTag();
            } while (readTag2 == this.f33268b);
            this.f33270d = readTag2;
            return;
        }
        int tagWireType2 = WireFormat.getTagWireType(this.f33268b);
        if (tagWireType2 != 1) {
            if (tagWireType2 == 2) {
                int readUInt322 = this.f33267a.readUInt32();
                r(readUInt322);
                int totalBytesRead2 = this.f33267a.getTotalBytesRead() + readUInt322;
                do {
                    list.add(Long.valueOf(this.f33267a.readFixed64()));
                } while (this.f33267a.getTotalBytesRead() < totalBytesRead2);
                return;
            }
            throw InvalidProtocolBufferException.f();
        }
        do {
            list.add(Long.valueOf(this.f33267a.readFixed64()));
            if (this.f33267a.isAtEnd()) {
                return;
            }
            readTag = this.f33267a.readTag();
        } while (readTag == this.f33268b);
        this.f33270d = readTag;
    }

    @Override // com.google.protobuf.Reader
    public float readFloat() throws IOException {
        p(5);
        return this.f33267a.readFloat();
    }

    @Override // com.google.protobuf.Reader
    public void readFloatList(List<Float> list) throws IOException {
        int readTag;
        int readTag2;
        if (list instanceof FloatArrayList) {
            FloatArrayList floatArrayList = (FloatArrayList) list;
            int tagWireType = WireFormat.getTagWireType(this.f33268b);
            if (tagWireType != 2) {
                if (tagWireType == 5) {
                    do {
                        floatArrayList.addFloat(this.f33267a.readFloat());
                        if (this.f33267a.isAtEnd()) {
                            return;
                        }
                        readTag2 = this.f33267a.readTag();
                    } while (readTag2 == this.f33268b);
                    this.f33270d = readTag2;
                    return;
                }
                throw InvalidProtocolBufferException.f();
            }
            int readUInt32 = this.f33267a.readUInt32();
            q(readUInt32);
            int totalBytesRead = this.f33267a.getTotalBytesRead() + readUInt32;
            do {
                floatArrayList.addFloat(this.f33267a.readFloat());
            } while (this.f33267a.getTotalBytesRead() < totalBytesRead);
            return;
        }
        int tagWireType2 = WireFormat.getTagWireType(this.f33268b);
        if (tagWireType2 != 2) {
            if (tagWireType2 == 5) {
                do {
                    list.add(Float.valueOf(this.f33267a.readFloat()));
                    if (this.f33267a.isAtEnd()) {
                        return;
                    }
                    readTag = this.f33267a.readTag();
                } while (readTag == this.f33268b);
                this.f33270d = readTag;
                return;
            }
            throw InvalidProtocolBufferException.f();
        }
        int readUInt322 = this.f33267a.readUInt32();
        q(readUInt322);
        int totalBytesRead2 = this.f33267a.getTotalBytesRead() + readUInt322;
        do {
            list.add(Float.valueOf(this.f33267a.readFloat()));
        } while (this.f33267a.getTotalBytesRead() < totalBytesRead2);
    }

    @Override // com.google.protobuf.Reader
    public int readInt32() throws IOException {
        p(0);
        return this.f33267a.readInt32();
    }

    @Override // com.google.protobuf.Reader
    public void readInt32List(List<Integer> list) throws IOException {
        int readTag;
        int readTag2;
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            int tagWireType = WireFormat.getTagWireType(this.f33268b);
            if (tagWireType != 0) {
                if (tagWireType == 2) {
                    int totalBytesRead = this.f33267a.getTotalBytesRead() + this.f33267a.readUInt32();
                    do {
                        intArrayList.addInt(this.f33267a.readInt32());
                    } while (this.f33267a.getTotalBytesRead() < totalBytesRead);
                    o(totalBytesRead);
                    return;
                }
                throw InvalidProtocolBufferException.f();
            }
            do {
                intArrayList.addInt(this.f33267a.readInt32());
                if (this.f33267a.isAtEnd()) {
                    return;
                }
                readTag2 = this.f33267a.readTag();
            } while (readTag2 == this.f33268b);
            this.f33270d = readTag2;
            return;
        }
        int tagWireType2 = WireFormat.getTagWireType(this.f33268b);
        if (tagWireType2 != 0) {
            if (tagWireType2 == 2) {
                int totalBytesRead2 = this.f33267a.getTotalBytesRead() + this.f33267a.readUInt32();
                do {
                    list.add(Integer.valueOf(this.f33267a.readInt32()));
                } while (this.f33267a.getTotalBytesRead() < totalBytesRead2);
                o(totalBytesRead2);
                return;
            }
            throw InvalidProtocolBufferException.f();
        }
        do {
            list.add(Integer.valueOf(this.f33267a.readInt32()));
            if (this.f33267a.isAtEnd()) {
                return;
            }
            readTag = this.f33267a.readTag();
        } while (readTag == this.f33268b);
        this.f33270d = readTag;
    }

    @Override // com.google.protobuf.Reader
    public long readInt64() throws IOException {
        p(0);
        return this.f33267a.readInt64();
    }

    @Override // com.google.protobuf.Reader
    public void readInt64List(List<Long> list) throws IOException {
        int readTag;
        int readTag2;
        if (list instanceof LongArrayList) {
            LongArrayList longArrayList = (LongArrayList) list;
            int tagWireType = WireFormat.getTagWireType(this.f33268b);
            if (tagWireType != 0) {
                if (tagWireType == 2) {
                    int totalBytesRead = this.f33267a.getTotalBytesRead() + this.f33267a.readUInt32();
                    do {
                        longArrayList.addLong(this.f33267a.readInt64());
                    } while (this.f33267a.getTotalBytesRead() < totalBytesRead);
                    o(totalBytesRead);
                    return;
                }
                throw InvalidProtocolBufferException.f();
            }
            do {
                longArrayList.addLong(this.f33267a.readInt64());
                if (this.f33267a.isAtEnd()) {
                    return;
                }
                readTag2 = this.f33267a.readTag();
            } while (readTag2 == this.f33268b);
            this.f33270d = readTag2;
            return;
        }
        int tagWireType2 = WireFormat.getTagWireType(this.f33268b);
        if (tagWireType2 != 0) {
            if (tagWireType2 == 2) {
                int totalBytesRead2 = this.f33267a.getTotalBytesRead() + this.f33267a.readUInt32();
                do {
                    list.add(Long.valueOf(this.f33267a.readInt64()));
                } while (this.f33267a.getTotalBytesRead() < totalBytesRead2);
                o(totalBytesRead2);
                return;
            }
            throw InvalidProtocolBufferException.f();
        }
        do {
            list.add(Long.valueOf(this.f33267a.readInt64()));
            if (this.f33267a.isAtEnd()) {
                return;
            }
            readTag = this.f33267a.readTag();
        } while (readTag == this.f33268b);
        this.f33270d = readTag;
    }

    @Override // com.google.protobuf.Reader
    public int readSFixed32() throws IOException {
        p(5);
        return this.f33267a.readSFixed32();
    }

    @Override // com.google.protobuf.Reader
    public void readSFixed32List(List<Integer> list) throws IOException {
        int readTag;
        int readTag2;
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            int tagWireType = WireFormat.getTagWireType(this.f33268b);
            if (tagWireType != 2) {
                if (tagWireType == 5) {
                    do {
                        intArrayList.addInt(this.f33267a.readSFixed32());
                        if (this.f33267a.isAtEnd()) {
                            return;
                        }
                        readTag2 = this.f33267a.readTag();
                    } while (readTag2 == this.f33268b);
                    this.f33270d = readTag2;
                    return;
                }
                throw InvalidProtocolBufferException.f();
            }
            int readUInt32 = this.f33267a.readUInt32();
            q(readUInt32);
            int totalBytesRead = this.f33267a.getTotalBytesRead() + readUInt32;
            do {
                intArrayList.addInt(this.f33267a.readSFixed32());
            } while (this.f33267a.getTotalBytesRead() < totalBytesRead);
            return;
        }
        int tagWireType2 = WireFormat.getTagWireType(this.f33268b);
        if (tagWireType2 != 2) {
            if (tagWireType2 == 5) {
                do {
                    list.add(Integer.valueOf(this.f33267a.readSFixed32()));
                    if (this.f33267a.isAtEnd()) {
                        return;
                    }
                    readTag = this.f33267a.readTag();
                } while (readTag == this.f33268b);
                this.f33270d = readTag;
                return;
            }
            throw InvalidProtocolBufferException.f();
        }
        int readUInt322 = this.f33267a.readUInt32();
        q(readUInt322);
        int totalBytesRead2 = this.f33267a.getTotalBytesRead() + readUInt322;
        do {
            list.add(Integer.valueOf(this.f33267a.readSFixed32()));
        } while (this.f33267a.getTotalBytesRead() < totalBytesRead2);
    }

    @Override // com.google.protobuf.Reader
    public long readSFixed64() throws IOException {
        p(1);
        return this.f33267a.readSFixed64();
    }

    @Override // com.google.protobuf.Reader
    public void readSFixed64List(List<Long> list) throws IOException {
        int readTag;
        int readTag2;
        if (list instanceof LongArrayList) {
            LongArrayList longArrayList = (LongArrayList) list;
            int tagWireType = WireFormat.getTagWireType(this.f33268b);
            if (tagWireType != 1) {
                if (tagWireType == 2) {
                    int readUInt32 = this.f33267a.readUInt32();
                    r(readUInt32);
                    int totalBytesRead = this.f33267a.getTotalBytesRead() + readUInt32;
                    do {
                        longArrayList.addLong(this.f33267a.readSFixed64());
                    } while (this.f33267a.getTotalBytesRead() < totalBytesRead);
                    return;
                }
                throw InvalidProtocolBufferException.f();
            }
            do {
                longArrayList.addLong(this.f33267a.readSFixed64());
                if (this.f33267a.isAtEnd()) {
                    return;
                }
                readTag2 = this.f33267a.readTag();
            } while (readTag2 == this.f33268b);
            this.f33270d = readTag2;
            return;
        }
        int tagWireType2 = WireFormat.getTagWireType(this.f33268b);
        if (tagWireType2 != 1) {
            if (tagWireType2 == 2) {
                int readUInt322 = this.f33267a.readUInt32();
                r(readUInt322);
                int totalBytesRead2 = this.f33267a.getTotalBytesRead() + readUInt322;
                do {
                    list.add(Long.valueOf(this.f33267a.readSFixed64()));
                } while (this.f33267a.getTotalBytesRead() < totalBytesRead2);
                return;
            }
            throw InvalidProtocolBufferException.f();
        }
        do {
            list.add(Long.valueOf(this.f33267a.readSFixed64()));
            if (this.f33267a.isAtEnd()) {
                return;
            }
            readTag = this.f33267a.readTag();
        } while (readTag == this.f33268b);
        this.f33270d = readTag;
    }

    @Override // com.google.protobuf.Reader
    public int readSInt32() throws IOException {
        p(0);
        return this.f33267a.readSInt32();
    }

    @Override // com.google.protobuf.Reader
    public void readSInt32List(List<Integer> list) throws IOException {
        int readTag;
        int readTag2;
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            int tagWireType = WireFormat.getTagWireType(this.f33268b);
            if (tagWireType != 0) {
                if (tagWireType == 2) {
                    int totalBytesRead = this.f33267a.getTotalBytesRead() + this.f33267a.readUInt32();
                    do {
                        intArrayList.addInt(this.f33267a.readSInt32());
                    } while (this.f33267a.getTotalBytesRead() < totalBytesRead);
                    o(totalBytesRead);
                    return;
                }
                throw InvalidProtocolBufferException.f();
            }
            do {
                intArrayList.addInt(this.f33267a.readSInt32());
                if (this.f33267a.isAtEnd()) {
                    return;
                }
                readTag2 = this.f33267a.readTag();
            } while (readTag2 == this.f33268b);
            this.f33270d = readTag2;
            return;
        }
        int tagWireType2 = WireFormat.getTagWireType(this.f33268b);
        if (tagWireType2 != 0) {
            if (tagWireType2 == 2) {
                int totalBytesRead2 = this.f33267a.getTotalBytesRead() + this.f33267a.readUInt32();
                do {
                    list.add(Integer.valueOf(this.f33267a.readSInt32()));
                } while (this.f33267a.getTotalBytesRead() < totalBytesRead2);
                o(totalBytesRead2);
                return;
            }
            throw InvalidProtocolBufferException.f();
        }
        do {
            list.add(Integer.valueOf(this.f33267a.readSInt32()));
            if (this.f33267a.isAtEnd()) {
                return;
            }
            readTag = this.f33267a.readTag();
        } while (readTag == this.f33268b);
        this.f33270d = readTag;
    }

    @Override // com.google.protobuf.Reader
    public long readSInt64() throws IOException {
        p(0);
        return this.f33267a.readSInt64();
    }

    @Override // com.google.protobuf.Reader
    public void readSInt64List(List<Long> list) throws IOException {
        int readTag;
        int readTag2;
        if (list instanceof LongArrayList) {
            LongArrayList longArrayList = (LongArrayList) list;
            int tagWireType = WireFormat.getTagWireType(this.f33268b);
            if (tagWireType != 0) {
                if (tagWireType == 2) {
                    int totalBytesRead = this.f33267a.getTotalBytesRead() + this.f33267a.readUInt32();
                    do {
                        longArrayList.addLong(this.f33267a.readSInt64());
                    } while (this.f33267a.getTotalBytesRead() < totalBytesRead);
                    o(totalBytesRead);
                    return;
                }
                throw InvalidProtocolBufferException.f();
            }
            do {
                longArrayList.addLong(this.f33267a.readSInt64());
                if (this.f33267a.isAtEnd()) {
                    return;
                }
                readTag2 = this.f33267a.readTag();
            } while (readTag2 == this.f33268b);
            this.f33270d = readTag2;
            return;
        }
        int tagWireType2 = WireFormat.getTagWireType(this.f33268b);
        if (tagWireType2 != 0) {
            if (tagWireType2 == 2) {
                int totalBytesRead2 = this.f33267a.getTotalBytesRead() + this.f33267a.readUInt32();
                do {
                    list.add(Long.valueOf(this.f33267a.readSInt64()));
                } while (this.f33267a.getTotalBytesRead() < totalBytesRead2);
                o(totalBytesRead2);
                return;
            }
            throw InvalidProtocolBufferException.f();
        }
        do {
            list.add(Long.valueOf(this.f33267a.readSInt64()));
            if (this.f33267a.isAtEnd()) {
                return;
            }
            readTag = this.f33267a.readTag();
        } while (readTag == this.f33268b);
        this.f33270d = readTag;
    }

    @Override // com.google.protobuf.Reader
    public String readString() throws IOException {
        p(2);
        return this.f33267a.readString();
    }

    @Override // com.google.protobuf.Reader
    public void readStringList(List<String> list) throws IOException {
        n(list, false);
    }

    @Override // com.google.protobuf.Reader
    public void readStringListRequireUtf8(List<String> list) throws IOException {
        n(list, true);
    }

    @Override // com.google.protobuf.Reader
    public String readStringRequireUtf8() throws IOException {
        p(2);
        return this.f33267a.readStringRequireUtf8();
    }

    @Override // com.google.protobuf.Reader
    public int readUInt32() throws IOException {
        p(0);
        return this.f33267a.readUInt32();
    }

    @Override // com.google.protobuf.Reader
    public void readUInt32List(List<Integer> list) throws IOException {
        int readTag;
        int readTag2;
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            int tagWireType = WireFormat.getTagWireType(this.f33268b);
            if (tagWireType != 0) {
                if (tagWireType == 2) {
                    int totalBytesRead = this.f33267a.getTotalBytesRead() + this.f33267a.readUInt32();
                    do {
                        intArrayList.addInt(this.f33267a.readUInt32());
                    } while (this.f33267a.getTotalBytesRead() < totalBytesRead);
                    o(totalBytesRead);
                    return;
                }
                throw InvalidProtocolBufferException.f();
            }
            do {
                intArrayList.addInt(this.f33267a.readUInt32());
                if (this.f33267a.isAtEnd()) {
                    return;
                }
                readTag2 = this.f33267a.readTag();
            } while (readTag2 == this.f33268b);
            this.f33270d = readTag2;
            return;
        }
        int tagWireType2 = WireFormat.getTagWireType(this.f33268b);
        if (tagWireType2 != 0) {
            if (tagWireType2 == 2) {
                int totalBytesRead2 = this.f33267a.getTotalBytesRead() + this.f33267a.readUInt32();
                do {
                    list.add(Integer.valueOf(this.f33267a.readUInt32()));
                } while (this.f33267a.getTotalBytesRead() < totalBytesRead2);
                o(totalBytesRead2);
                return;
            }
            throw InvalidProtocolBufferException.f();
        }
        do {
            list.add(Integer.valueOf(this.f33267a.readUInt32()));
            if (this.f33267a.isAtEnd()) {
                return;
            }
            readTag = this.f33267a.readTag();
        } while (readTag == this.f33268b);
        this.f33270d = readTag;
    }

    @Override // com.google.protobuf.Reader
    public long readUInt64() throws IOException {
        p(0);
        return this.f33267a.readUInt64();
    }

    @Override // com.google.protobuf.Reader
    public void readUInt64List(List<Long> list) throws IOException {
        int readTag;
        int readTag2;
        if (list instanceof LongArrayList) {
            LongArrayList longArrayList = (LongArrayList) list;
            int tagWireType = WireFormat.getTagWireType(this.f33268b);
            if (tagWireType != 0) {
                if (tagWireType == 2) {
                    int totalBytesRead = this.f33267a.getTotalBytesRead() + this.f33267a.readUInt32();
                    do {
                        longArrayList.addLong(this.f33267a.readUInt64());
                    } while (this.f33267a.getTotalBytesRead() < totalBytesRead);
                    o(totalBytesRead);
                    return;
                }
                throw InvalidProtocolBufferException.f();
            }
            do {
                longArrayList.addLong(this.f33267a.readUInt64());
                if (this.f33267a.isAtEnd()) {
                    return;
                }
                readTag2 = this.f33267a.readTag();
            } while (readTag2 == this.f33268b);
            this.f33270d = readTag2;
            return;
        }
        int tagWireType2 = WireFormat.getTagWireType(this.f33268b);
        if (tagWireType2 != 0) {
            if (tagWireType2 == 2) {
                int totalBytesRead2 = this.f33267a.getTotalBytesRead() + this.f33267a.readUInt32();
                do {
                    list.add(Long.valueOf(this.f33267a.readUInt64()));
                } while (this.f33267a.getTotalBytesRead() < totalBytesRead2);
                o(totalBytesRead2);
                return;
            }
            throw InvalidProtocolBufferException.f();
        }
        do {
            list.add(Long.valueOf(this.f33267a.readUInt64()));
            if (this.f33267a.isAtEnd()) {
                return;
            }
            readTag = this.f33267a.readTag();
        } while (readTag == this.f33268b);
        this.f33270d = readTag;
    }

    @Override // com.google.protobuf.Reader
    public boolean skipField() throws IOException {
        int i4;
        if (!this.f33267a.isAtEnd() && (i4 = this.f33268b) != this.f33269c) {
            return this.f33267a.skipField(i4);
        }
        return false;
    }
}
