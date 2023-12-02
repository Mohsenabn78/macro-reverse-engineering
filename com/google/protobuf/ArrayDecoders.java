package com.google.protobuf;

import com.google.common.base.Ascii;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.WireFormat;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
@CheckReturnValue
/* loaded from: classes6.dex */
public final class ArrayDecoders {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.protobuf.ArrayDecoders$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f33155a;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            f33155a = iArr;
            try {
                iArr[WireFormat.FieldType.DOUBLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f33155a[WireFormat.FieldType.FLOAT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f33155a[WireFormat.FieldType.INT64.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f33155a[WireFormat.FieldType.UINT64.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f33155a[WireFormat.FieldType.INT32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f33155a[WireFormat.FieldType.UINT32.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f33155a[WireFormat.FieldType.FIXED64.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f33155a[WireFormat.FieldType.SFIXED64.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f33155a[WireFormat.FieldType.FIXED32.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f33155a[WireFormat.FieldType.SFIXED32.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f33155a[WireFormat.FieldType.BOOL.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f33155a[WireFormat.FieldType.SINT32.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f33155a[WireFormat.FieldType.SINT64.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f33155a[WireFormat.FieldType.ENUM.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f33155a[WireFormat.FieldType.BYTES.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f33155a[WireFormat.FieldType.STRING.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f33155a[WireFormat.FieldType.GROUP.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f33155a[WireFormat.FieldType.MESSAGE.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
        }
    }

    private ArrayDecoders() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int A(int i4, byte[] bArr, int i5, int i6, Internal.ProtobufList<?> protobufList, Registers registers) {
        IntArrayList intArrayList = (IntArrayList) protobufList;
        int I = I(bArr, i5, registers);
        intArrayList.addInt(CodedInputStream.decodeZigZag32(registers.f33156a));
        while (I < i6) {
            int I2 = I(bArr, I, registers);
            if (i4 != registers.f33156a) {
                break;
            }
            I = I(bArr, I2, registers);
            intArrayList.addInt(CodedInputStream.decodeZigZag32(registers.f33156a));
        }
        return I;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int B(int i4, byte[] bArr, int i5, int i6, Internal.ProtobufList<?> protobufList, Registers registers) {
        LongArrayList longArrayList = (LongArrayList) protobufList;
        int L = L(bArr, i5, registers);
        longArrayList.addLong(CodedInputStream.decodeZigZag64(registers.f33157b));
        while (L < i6) {
            int I = I(bArr, L, registers);
            if (i4 != registers.f33156a) {
                break;
            }
            L = L(bArr, I, registers);
            longArrayList.addLong(CodedInputStream.decodeZigZag64(registers.f33157b));
        }
        return L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int C(byte[] bArr, int i4, Registers registers) throws InvalidProtocolBufferException {
        int I = I(bArr, i4, registers);
        int i5 = registers.f33156a;
        if (i5 >= 0) {
            if (i5 == 0) {
                registers.f33158c = "";
                return I;
            }
            registers.f33158c = new String(bArr, I, i5, Internal.f33419b);
            return I + i5;
        }
        throw InvalidProtocolBufferException.h();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x001d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:8:0x001a -> B:9:0x001b). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int D(int r4, byte[] r5, int r6, int r7, com.google.protobuf.Internal.ProtobufList<?> r8, com.google.protobuf.ArrayDecoders.Registers r9) throws com.google.protobuf.InvalidProtocolBufferException {
        /*
            int r6 = I(r5, r6, r9)
            int r0 = r9.f33156a
            if (r0 < 0) goto L45
            java.lang.String r1 = ""
            if (r0 != 0) goto L10
            r8.add(r1)
            goto L1b
        L10:
            java.lang.String r2 = new java.lang.String
            java.nio.charset.Charset r3 = com.google.protobuf.Internal.f33419b
            r2.<init>(r5, r6, r0, r3)
            r8.add(r2)
        L1a:
            int r6 = r6 + r0
        L1b:
            if (r6 >= r7) goto L44
            int r0 = I(r5, r6, r9)
            int r2 = r9.f33156a
            if (r4 == r2) goto L26
            goto L44
        L26:
            int r6 = I(r5, r0, r9)
            int r0 = r9.f33156a
            if (r0 < 0) goto L3f
            if (r0 != 0) goto L34
            r8.add(r1)
            goto L1b
        L34:
            java.lang.String r2 = new java.lang.String
            java.nio.charset.Charset r3 = com.google.protobuf.Internal.f33419b
            r2.<init>(r5, r6, r0, r3)
            r8.add(r2)
            goto L1a
        L3f:
            com.google.protobuf.InvalidProtocolBufferException r4 = com.google.protobuf.InvalidProtocolBufferException.h()
            throw r4
        L44:
            return r6
        L45:
            com.google.protobuf.InvalidProtocolBufferException r4 = com.google.protobuf.InvalidProtocolBufferException.h()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.ArrayDecoders.D(int, byte[], int, int, com.google.protobuf.Internal$ProtobufList, com.google.protobuf.ArrayDecoders$Registers):int");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0022 -> B:11:0x0023). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int E(int r5, byte[] r6, int r7, int r8, com.google.protobuf.Internal.ProtobufList<?> r9, com.google.protobuf.ArrayDecoders.Registers r10) throws com.google.protobuf.InvalidProtocolBufferException {
        /*
            int r7 = I(r6, r7, r10)
            int r0 = r10.f33156a
            if (r0 < 0) goto L5f
            java.lang.String r1 = ""
            if (r0 != 0) goto L10
            r9.add(r1)
            goto L23
        L10:
            int r2 = r7 + r0
            boolean r3 = com.google.protobuf.Utf8.u(r6, r7, r2)
            if (r3 == 0) goto L5a
            java.lang.String r3 = new java.lang.String
            java.nio.charset.Charset r4 = com.google.protobuf.Internal.f33419b
            r3.<init>(r6, r7, r0, r4)
            r9.add(r3)
        L22:
            r7 = r2
        L23:
            if (r7 >= r8) goto L59
            int r0 = I(r6, r7, r10)
            int r2 = r10.f33156a
            if (r5 == r2) goto L2e
            goto L59
        L2e:
            int r7 = I(r6, r0, r10)
            int r0 = r10.f33156a
            if (r0 < 0) goto L54
            if (r0 != 0) goto L3c
            r9.add(r1)
            goto L23
        L3c:
            int r2 = r7 + r0
            boolean r3 = com.google.protobuf.Utf8.u(r6, r7, r2)
            if (r3 == 0) goto L4f
            java.lang.String r3 = new java.lang.String
            java.nio.charset.Charset r4 = com.google.protobuf.Internal.f33419b
            r3.<init>(r6, r7, r0, r4)
            r9.add(r3)
            goto L22
        L4f:
            com.google.protobuf.InvalidProtocolBufferException r5 = com.google.protobuf.InvalidProtocolBufferException.e()
            throw r5
        L54:
            com.google.protobuf.InvalidProtocolBufferException r5 = com.google.protobuf.InvalidProtocolBufferException.h()
            throw r5
        L59:
            return r7
        L5a:
            com.google.protobuf.InvalidProtocolBufferException r5 = com.google.protobuf.InvalidProtocolBufferException.e()
            throw r5
        L5f:
            com.google.protobuf.InvalidProtocolBufferException r5 = com.google.protobuf.InvalidProtocolBufferException.h()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.ArrayDecoders.E(int, byte[], int, int, com.google.protobuf.Internal$ProtobufList, com.google.protobuf.ArrayDecoders$Registers):int");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int F(byte[] bArr, int i4, Registers registers) throws InvalidProtocolBufferException {
        int I = I(bArr, i4, registers);
        int i5 = registers.f33156a;
        if (i5 >= 0) {
            if (i5 == 0) {
                registers.f33158c = "";
                return I;
            }
            registers.f33158c = Utf8.h(bArr, I, i5);
            return I + i5;
        }
        throw InvalidProtocolBufferException.h();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int G(int i4, byte[] bArr, int i5, int i6, UnknownFieldSetLite unknownFieldSetLite, Registers registers) throws InvalidProtocolBufferException {
        if (WireFormat.getTagFieldNumber(i4) != 0) {
            int tagWireType = WireFormat.getTagWireType(i4);
            if (tagWireType != 0) {
                if (tagWireType != 1) {
                    if (tagWireType != 2) {
                        if (tagWireType != 3) {
                            if (tagWireType == 5) {
                                unknownFieldSetLite.j(i4, Integer.valueOf(h(bArr, i5)));
                                return i5 + 4;
                            }
                            throw InvalidProtocolBufferException.c();
                        }
                        UnknownFieldSetLite g4 = UnknownFieldSetLite.g();
                        int i7 = (i4 & (-8)) | 4;
                        int i8 = 0;
                        while (true) {
                            if (i5 >= i6) {
                                break;
                            }
                            int I = I(bArr, i5, registers);
                            int i9 = registers.f33156a;
                            if (i9 == i7) {
                                i8 = i9;
                                i5 = I;
                                break;
                            }
                            i8 = i9;
                            i5 = G(i9, bArr, I, i6, g4, registers);
                        }
                        if (i5 <= i6 && i8 == i7) {
                            unknownFieldSetLite.j(i4, g4);
                            return i5;
                        }
                        throw InvalidProtocolBufferException.i();
                    }
                    int I2 = I(bArr, i5, registers);
                    int i10 = registers.f33156a;
                    if (i10 >= 0) {
                        if (i10 <= bArr.length - I2) {
                            if (i10 == 0) {
                                unknownFieldSetLite.j(i4, ByteString.EMPTY);
                            } else {
                                unknownFieldSetLite.j(i4, ByteString.copyFrom(bArr, I2, i10));
                            }
                            return I2 + i10;
                        }
                        throw InvalidProtocolBufferException.n();
                    }
                    throw InvalidProtocolBufferException.h();
                }
                unknownFieldSetLite.j(i4, Long.valueOf(j(bArr, i5)));
                return i5 + 8;
            }
            int L = L(bArr, i5, registers);
            unknownFieldSetLite.j(i4, Long.valueOf(registers.f33157b));
            return L;
        }
        throw InvalidProtocolBufferException.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int H(int i4, byte[] bArr, int i5, Registers registers) {
        int i6 = i4 & 127;
        int i7 = i5 + 1;
        byte b4 = bArr[i5];
        if (b4 >= 0) {
            registers.f33156a = i6 | (b4 << 7);
            return i7;
        }
        int i8 = i6 | ((b4 & Byte.MAX_VALUE) << 7);
        int i9 = i7 + 1;
        byte b5 = bArr[i7];
        if (b5 >= 0) {
            registers.f33156a = i8 | (b5 << Ascii.SO);
            return i9;
        }
        int i10 = i8 | ((b5 & Byte.MAX_VALUE) << 14);
        int i11 = i9 + 1;
        byte b6 = bArr[i9];
        if (b6 >= 0) {
            registers.f33156a = i10 | (b6 << Ascii.NAK);
            return i11;
        }
        int i12 = i10 | ((b6 & Byte.MAX_VALUE) << 21);
        int i13 = i11 + 1;
        byte b7 = bArr[i11];
        if (b7 >= 0) {
            registers.f33156a = i12 | (b7 << Ascii.FS);
            return i13;
        }
        int i14 = i12 | ((b7 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i15 = i13 + 1;
            if (bArr[i13] < 0) {
                i13 = i15;
            } else {
                registers.f33156a = i14;
                return i15;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int I(byte[] bArr, int i4, Registers registers) {
        int i5 = i4 + 1;
        byte b4 = bArr[i4];
        if (b4 >= 0) {
            registers.f33156a = b4;
            return i5;
        }
        return H(b4, bArr, i5, registers);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int J(int i4, byte[] bArr, int i5, int i6, Internal.ProtobufList<?> protobufList, Registers registers) {
        IntArrayList intArrayList = (IntArrayList) protobufList;
        int I = I(bArr, i5, registers);
        intArrayList.addInt(registers.f33156a);
        while (I < i6) {
            int I2 = I(bArr, I, registers);
            if (i4 != registers.f33156a) {
                break;
            }
            I = I(bArr, I2, registers);
            intArrayList.addInt(registers.f33156a);
        }
        return I;
    }

    static int K(long j4, byte[] bArr, int i4, Registers registers) {
        int i5 = i4 + 1;
        byte b4 = bArr[i4];
        long j5 = (j4 & 127) | ((b4 & Byte.MAX_VALUE) << 7);
        int i6 = 7;
        while (b4 < 0) {
            int i7 = i5 + 1;
            byte b5 = bArr[i5];
            i6 += 7;
            j5 |= (b5 & Byte.MAX_VALUE) << i6;
            i5 = i7;
            b4 = b5;
        }
        registers.f33157b = j5;
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int L(byte[] bArr, int i4, Registers registers) {
        int i5 = i4 + 1;
        long j4 = bArr[i4];
        if (j4 >= 0) {
            registers.f33157b = j4;
            return i5;
        }
        return K(j4, bArr, i5, registers);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int M(int i4, byte[] bArr, int i5, int i6, Internal.ProtobufList<?> protobufList, Registers registers) {
        LongArrayList longArrayList = (LongArrayList) protobufList;
        int L = L(bArr, i5, registers);
        longArrayList.addLong(registers.f33157b);
        while (L < i6) {
            int I = I(bArr, L, registers);
            if (i4 != registers.f33156a) {
                break;
            }
            L = L(bArr, I, registers);
            longArrayList.addLong(registers.f33157b);
        }
        return L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int N(Object obj, Schema schema, byte[] bArr, int i4, int i5, int i6, Registers registers) throws IOException {
        int a02 = ((MessageSchema) schema).a0(obj, bArr, i4, i5, i6, registers);
        registers.f33158c = obj;
        return a02;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int O(Object obj, Schema schema, byte[] bArr, int i4, int i5, Registers registers) throws IOException {
        int i6 = i4 + 1;
        int i7 = bArr[i4];
        if (i7 < 0) {
            i6 = H(i7, bArr, i6, registers);
            i7 = registers.f33156a;
        }
        int i8 = i6;
        if (i7 >= 0 && i7 <= i5 - i8) {
            int i9 = i7 + i8;
            schema.b(obj, bArr, i8, i9, registers);
            registers.f33158c = obj;
            return i9;
        }
        throw InvalidProtocolBufferException.n();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int P(int i4, byte[] bArr, int i5, int i6, Registers registers) throws InvalidProtocolBufferException {
        if (WireFormat.getTagFieldNumber(i4) != 0) {
            int tagWireType = WireFormat.getTagWireType(i4);
            if (tagWireType != 0) {
                if (tagWireType != 1) {
                    if (tagWireType != 2) {
                        if (tagWireType != 3) {
                            if (tagWireType == 5) {
                                return i5 + 4;
                            }
                            throw InvalidProtocolBufferException.c();
                        }
                        int i7 = (i4 & (-8)) | 4;
                        int i8 = 0;
                        while (i5 < i6) {
                            i5 = I(bArr, i5, registers);
                            i8 = registers.f33156a;
                            if (i8 == i7) {
                                break;
                            }
                            i5 = P(i8, bArr, i5, i6, registers);
                        }
                        if (i5 <= i6 && i8 == i7) {
                            return i5;
                        }
                        throw InvalidProtocolBufferException.i();
                    }
                    return I(bArr, i5, registers) + registers.f33156a;
                }
                return i5 + 8;
            }
            return L(bArr, i5, registers);
        }
        throw InvalidProtocolBufferException.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i4, byte[] bArr, int i5, int i6, Internal.ProtobufList<?> protobufList, Registers registers) {
        boolean z3;
        boolean z4;
        BooleanArrayList booleanArrayList = (BooleanArrayList) protobufList;
        int L = L(bArr, i5, registers);
        if (registers.f33157b != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        booleanArrayList.addBoolean(z3);
        while (L < i6) {
            int I = I(bArr, L, registers);
            if (i4 != registers.f33156a) {
                break;
            }
            L = L(bArr, I, registers);
            if (registers.f33157b != 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            booleanArrayList.addBoolean(z4);
        }
        return L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(byte[] bArr, int i4, Registers registers) throws InvalidProtocolBufferException {
        int I = I(bArr, i4, registers);
        int i5 = registers.f33156a;
        if (i5 >= 0) {
            if (i5 <= bArr.length - I) {
                if (i5 == 0) {
                    registers.f33158c = ByteString.EMPTY;
                    return I;
                }
                registers.f33158c = ByteString.copyFrom(bArr, I, i5);
                return I + i5;
            }
            throw InvalidProtocolBufferException.n();
        }
        throw InvalidProtocolBufferException.h();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x001e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x001b -> B:10:0x001c). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int c(int r2, byte[] r3, int r4, int r5, com.google.protobuf.Internal.ProtobufList<?> r6, com.google.protobuf.ArrayDecoders.Registers r7) throws com.google.protobuf.InvalidProtocolBufferException {
        /*
            int r4 = I(r3, r4, r7)
            int r0 = r7.f33156a
            if (r0 < 0) goto L53
            int r1 = r3.length
            int r1 = r1 - r4
            if (r0 > r1) goto L4e
            if (r0 != 0) goto L14
            com.google.protobuf.ByteString r0 = com.google.protobuf.ByteString.EMPTY
            r6.add(r0)
            goto L1c
        L14:
            com.google.protobuf.ByteString r1 = com.google.protobuf.ByteString.copyFrom(r3, r4, r0)
            r6.add(r1)
        L1b:
            int r4 = r4 + r0
        L1c:
            if (r4 >= r5) goto L4d
            int r0 = I(r3, r4, r7)
            int r1 = r7.f33156a
            if (r2 == r1) goto L27
            goto L4d
        L27:
            int r4 = I(r3, r0, r7)
            int r0 = r7.f33156a
            if (r0 < 0) goto L48
            int r1 = r3.length
            int r1 = r1 - r4
            if (r0 > r1) goto L43
            if (r0 != 0) goto L3b
            com.google.protobuf.ByteString r0 = com.google.protobuf.ByteString.EMPTY
            r6.add(r0)
            goto L1c
        L3b:
            com.google.protobuf.ByteString r1 = com.google.protobuf.ByteString.copyFrom(r3, r4, r0)
            r6.add(r1)
            goto L1b
        L43:
            com.google.protobuf.InvalidProtocolBufferException r2 = com.google.protobuf.InvalidProtocolBufferException.n()
            throw r2
        L48:
            com.google.protobuf.InvalidProtocolBufferException r2 = com.google.protobuf.InvalidProtocolBufferException.h()
            throw r2
        L4d:
            return r4
        L4e:
            com.google.protobuf.InvalidProtocolBufferException r2 = com.google.protobuf.InvalidProtocolBufferException.n()
            throw r2
        L53:
            com.google.protobuf.InvalidProtocolBufferException r2 = com.google.protobuf.InvalidProtocolBufferException.h()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.ArrayDecoders.c(int, byte[], int, int, com.google.protobuf.Internal$ProtobufList, com.google.protobuf.ArrayDecoders$Registers):int");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static double d(byte[] bArr, int i4) {
        return Double.longBitsToDouble(j(bArr, i4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e(int i4, byte[] bArr, int i5, int i6, Internal.ProtobufList<?> protobufList, Registers registers) {
        DoubleArrayList doubleArrayList = (DoubleArrayList) protobufList;
        doubleArrayList.addDouble(d(bArr, i5));
        int i7 = i5 + 8;
        while (i7 < i6) {
            int I = I(bArr, i7, registers);
            if (i4 != registers.f33156a) {
                break;
            }
            doubleArrayList.addDouble(d(bArr, I));
            i7 = I + 8;
        }
        return i7;
    }

    static int f(int i4, byte[] bArr, int i5, int i6, GeneratedMessageLite.ExtendableMessage<?, ?> extendableMessage, GeneratedMessageLite.GeneratedExtension<?, ?> generatedExtension, UnknownFieldSchema<UnknownFieldSetLite, UnknownFieldSetLite> unknownFieldSchema, Registers registers) throws IOException {
        boolean z3;
        FieldSet<GeneratedMessageLite.ExtensionDescriptor> fieldSet = extendableMessage.extensions;
        int i7 = i4 >>> 3;
        if (generatedExtension.f33411d.isRepeated() && generatedExtension.f33411d.isPacked()) {
            switch (AnonymousClass1.f33155a[generatedExtension.getLiteType().ordinal()]) {
                case 1:
                    DoubleArrayList doubleArrayList = new DoubleArrayList();
                    int s3 = s(bArr, i5, doubleArrayList, registers);
                    fieldSet.D(generatedExtension.f33411d, doubleArrayList);
                    return s3;
                case 2:
                    FloatArrayList floatArrayList = new FloatArrayList();
                    int v3 = v(bArr, i5, floatArrayList, registers);
                    fieldSet.D(generatedExtension.f33411d, floatArrayList);
                    return v3;
                case 3:
                case 4:
                    LongArrayList longArrayList = new LongArrayList();
                    int z4 = z(bArr, i5, longArrayList, registers);
                    fieldSet.D(generatedExtension.f33411d, longArrayList);
                    return z4;
                case 5:
                case 6:
                    IntArrayList intArrayList = new IntArrayList();
                    int y3 = y(bArr, i5, intArrayList, registers);
                    fieldSet.D(generatedExtension.f33411d, intArrayList);
                    return y3;
                case 7:
                case 8:
                    LongArrayList longArrayList2 = new LongArrayList();
                    int u3 = u(bArr, i5, longArrayList2, registers);
                    fieldSet.D(generatedExtension.f33411d, longArrayList2);
                    return u3;
                case 9:
                case 10:
                    IntArrayList intArrayList2 = new IntArrayList();
                    int t3 = t(bArr, i5, intArrayList2, registers);
                    fieldSet.D(generatedExtension.f33411d, intArrayList2);
                    return t3;
                case 11:
                    BooleanArrayList booleanArrayList = new BooleanArrayList();
                    int r4 = r(bArr, i5, booleanArrayList, registers);
                    fieldSet.D(generatedExtension.f33411d, booleanArrayList);
                    return r4;
                case 12:
                    IntArrayList intArrayList3 = new IntArrayList();
                    int w3 = w(bArr, i5, intArrayList3, registers);
                    fieldSet.D(generatedExtension.f33411d, intArrayList3);
                    return w3;
                case 13:
                    LongArrayList longArrayList3 = new LongArrayList();
                    int x3 = x(bArr, i5, longArrayList3, registers);
                    fieldSet.D(generatedExtension.f33411d, longArrayList3);
                    return x3;
                case 14:
                    IntArrayList intArrayList4 = new IntArrayList();
                    int y4 = y(bArr, i5, intArrayList4, registers);
                    SchemaUtil.z(extendableMessage, i7, intArrayList4, generatedExtension.f33411d.getEnumType(), null, unknownFieldSchema);
                    fieldSet.D(generatedExtension.f33411d, intArrayList4);
                    return y4;
                default:
                    throw new IllegalStateException("Type cannot be packed: " + generatedExtension.f33411d.getLiteType());
            }
        }
        Object obj = null;
        if (generatedExtension.getLiteType() == WireFormat.FieldType.ENUM) {
            i5 = I(bArr, i5, registers);
            if (generatedExtension.f33411d.getEnumType().findValueByNumber(registers.f33156a) == null) {
                SchemaUtil.L(extendableMessage, i7, registers.f33156a, null, unknownFieldSchema);
                return i5;
            }
            obj = Integer.valueOf(registers.f33156a);
        } else {
            switch (AnonymousClass1.f33155a[generatedExtension.getLiteType().ordinal()]) {
                case 1:
                    obj = Double.valueOf(d(bArr, i5));
                    i5 += 8;
                    break;
                case 2:
                    obj = Float.valueOf(l(bArr, i5));
                    i5 += 4;
                    break;
                case 3:
                case 4:
                    i5 = L(bArr, i5, registers);
                    obj = Long.valueOf(registers.f33157b);
                    break;
                case 5:
                case 6:
                    i5 = I(bArr, i5, registers);
                    obj = Integer.valueOf(registers.f33156a);
                    break;
                case 7:
                case 8:
                    obj = Long.valueOf(j(bArr, i5));
                    i5 += 8;
                    break;
                case 9:
                case 10:
                    obj = Integer.valueOf(h(bArr, i5));
                    i5 += 4;
                    break;
                case 11:
                    i5 = L(bArr, i5, registers);
                    if (registers.f33157b != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    obj = Boolean.valueOf(z3);
                    break;
                case 12:
                    i5 = I(bArr, i5, registers);
                    obj = Integer.valueOf(CodedInputStream.decodeZigZag32(registers.f33156a));
                    break;
                case 13:
                    i5 = L(bArr, i5, registers);
                    obj = Long.valueOf(CodedInputStream.decodeZigZag64(registers.f33157b));
                    break;
                case 14:
                    throw new IllegalStateException("Shouldn't reach here.");
                case 15:
                    i5 = b(bArr, i5, registers);
                    obj = registers.f33158c;
                    break;
                case 16:
                    i5 = C(bArr, i5, registers);
                    obj = registers.f33158c;
                    break;
                case 17:
                    int i8 = (i7 << 3) | 4;
                    Schema c4 = Protobuf.a().c(generatedExtension.getMessageDefaultInstance().getClass());
                    if (generatedExtension.isRepeated()) {
                        int n4 = n(c4, bArr, i5, i6, i8, registers);
                        fieldSet.a(generatedExtension.f33411d, registers.f33158c);
                        return n4;
                    }
                    Object j4 = fieldSet.j(generatedExtension.f33411d);
                    if (j4 == null) {
                        j4 = c4.newInstance();
                        fieldSet.D(generatedExtension.f33411d, j4);
                    }
                    return N(j4, c4, bArr, i5, i6, i8, registers);
                case 18:
                    Schema c5 = Protobuf.a().c(generatedExtension.getMessageDefaultInstance().getClass());
                    if (generatedExtension.isRepeated()) {
                        int p4 = p(c5, bArr, i5, i6, registers);
                        fieldSet.a(generatedExtension.f33411d, registers.f33158c);
                        return p4;
                    }
                    Object j5 = fieldSet.j(generatedExtension.f33411d);
                    if (j5 == null) {
                        j5 = c5.newInstance();
                        fieldSet.D(generatedExtension.f33411d, j5);
                    }
                    return O(j5, c5, bArr, i5, i6, registers);
            }
        }
        if (generatedExtension.isRepeated()) {
            fieldSet.a(generatedExtension.f33411d, obj);
        } else {
            fieldSet.D(generatedExtension.f33411d, obj);
        }
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int g(int i4, byte[] bArr, int i5, int i6, Object obj, MessageLite messageLite, UnknownFieldSchema<UnknownFieldSetLite, UnknownFieldSetLite> unknownFieldSchema, Registers registers) throws IOException {
        GeneratedMessageLite.GeneratedExtension findLiteExtensionByNumber = registers.f33159d.findLiteExtensionByNumber(messageLite, i4 >>> 3);
        if (findLiteExtensionByNumber == null) {
            return G(i4, bArr, i5, i6, MessageSchema.q(obj), registers);
        }
        GeneratedMessageLite.ExtendableMessage extendableMessage = (GeneratedMessageLite.ExtendableMessage) obj;
        extendableMessage.f0();
        return f(i4, bArr, i5, i6, extendableMessage, findLiteExtensionByNumber, unknownFieldSchema, registers);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int h(byte[] bArr, int i4) {
        return ((bArr[i4 + 3] & 255) << 24) | (bArr[i4] & 255) | ((bArr[i4 + 1] & 255) << 8) | ((bArr[i4 + 2] & 255) << 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int i(int i4, byte[] bArr, int i5, int i6, Internal.ProtobufList<?> protobufList, Registers registers) {
        IntArrayList intArrayList = (IntArrayList) protobufList;
        intArrayList.addInt(h(bArr, i5));
        int i7 = i5 + 4;
        while (i7 < i6) {
            int I = I(bArr, i7, registers);
            if (i4 != registers.f33156a) {
                break;
            }
            intArrayList.addInt(h(bArr, I));
            i7 = I + 4;
        }
        return i7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long j(byte[] bArr, int i4) {
        return ((bArr[i4 + 7] & 255) << 56) | (bArr[i4] & 255) | ((bArr[i4 + 1] & 255) << 8) | ((bArr[i4 + 2] & 255) << 16) | ((bArr[i4 + 3] & 255) << 24) | ((bArr[i4 + 4] & 255) << 32) | ((bArr[i4 + 5] & 255) << 40) | ((bArr[i4 + 6] & 255) << 48);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int k(int i4, byte[] bArr, int i5, int i6, Internal.ProtobufList<?> protobufList, Registers registers) {
        LongArrayList longArrayList = (LongArrayList) protobufList;
        longArrayList.addLong(j(bArr, i5));
        int i7 = i5 + 8;
        while (i7 < i6) {
            int I = I(bArr, i7, registers);
            if (i4 != registers.f33156a) {
                break;
            }
            longArrayList.addLong(j(bArr, I));
            i7 = I + 8;
        }
        return i7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float l(byte[] bArr, int i4) {
        return Float.intBitsToFloat(h(bArr, i4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int m(int i4, byte[] bArr, int i5, int i6, Internal.ProtobufList<?> protobufList, Registers registers) {
        FloatArrayList floatArrayList = (FloatArrayList) protobufList;
        floatArrayList.addFloat(l(bArr, i5));
        int i7 = i5 + 4;
        while (i7 < i6) {
            int I = I(bArr, i7, registers);
            if (i4 != registers.f33156a) {
                break;
            }
            floatArrayList.addFloat(l(bArr, I));
            i7 = I + 4;
        }
        return i7;
    }

    static int n(Schema schema, byte[] bArr, int i4, int i5, int i6, Registers registers) throws IOException {
        Object newInstance = schema.newInstance();
        int N = N(newInstance, schema, bArr, i4, i5, i6, registers);
        schema.makeImmutable(newInstance);
        registers.f33158c = newInstance;
        return N;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int o(Schema schema, int i4, byte[] bArr, int i5, int i6, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        int i7 = (i4 & (-8)) | 4;
        int n4 = n(schema, bArr, i5, i6, i7, registers);
        protobufList.add(registers.f33158c);
        while (n4 < i6) {
            int I = I(bArr, n4, registers);
            if (i4 != registers.f33156a) {
                break;
            }
            n4 = n(schema, bArr, I, i6, i7, registers);
            protobufList.add(registers.f33158c);
        }
        return n4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int p(Schema schema, byte[] bArr, int i4, int i5, Registers registers) throws IOException {
        Object newInstance = schema.newInstance();
        int O = O(newInstance, schema, bArr, i4, i5, registers);
        schema.makeImmutable(newInstance);
        registers.f33158c = newInstance;
        return O;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int q(Schema<?> schema, int i4, byte[] bArr, int i5, int i6, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        int p4 = p(schema, bArr, i5, i6, registers);
        protobufList.add(registers.f33158c);
        while (p4 < i6) {
            int I = I(bArr, p4, registers);
            if (i4 != registers.f33156a) {
                break;
            }
            p4 = p(schema, bArr, I, i6, registers);
            protobufList.add(registers.f33158c);
        }
        return p4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int r(byte[] bArr, int i4, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        boolean z3;
        BooleanArrayList booleanArrayList = (BooleanArrayList) protobufList;
        int I = I(bArr, i4, registers);
        int i5 = registers.f33156a + I;
        while (I < i5) {
            I = L(bArr, I, registers);
            if (registers.f33157b != 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            booleanArrayList.addBoolean(z3);
        }
        if (I == i5) {
            return I;
        }
        throw InvalidProtocolBufferException.n();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int s(byte[] bArr, int i4, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        DoubleArrayList doubleArrayList = (DoubleArrayList) protobufList;
        int I = I(bArr, i4, registers);
        int i5 = registers.f33156a + I;
        while (I < i5) {
            doubleArrayList.addDouble(d(bArr, I));
            I += 8;
        }
        if (I == i5) {
            return I;
        }
        throw InvalidProtocolBufferException.n();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int t(byte[] bArr, int i4, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        IntArrayList intArrayList = (IntArrayList) protobufList;
        int I = I(bArr, i4, registers);
        int i5 = registers.f33156a + I;
        while (I < i5) {
            intArrayList.addInt(h(bArr, I));
            I += 4;
        }
        if (I == i5) {
            return I;
        }
        throw InvalidProtocolBufferException.n();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int u(byte[] bArr, int i4, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        LongArrayList longArrayList = (LongArrayList) protobufList;
        int I = I(bArr, i4, registers);
        int i5 = registers.f33156a + I;
        while (I < i5) {
            longArrayList.addLong(j(bArr, I));
            I += 8;
        }
        if (I == i5) {
            return I;
        }
        throw InvalidProtocolBufferException.n();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int v(byte[] bArr, int i4, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        FloatArrayList floatArrayList = (FloatArrayList) protobufList;
        int I = I(bArr, i4, registers);
        int i5 = registers.f33156a + I;
        while (I < i5) {
            floatArrayList.addFloat(l(bArr, I));
            I += 4;
        }
        if (I == i5) {
            return I;
        }
        throw InvalidProtocolBufferException.n();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int w(byte[] bArr, int i4, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        IntArrayList intArrayList = (IntArrayList) protobufList;
        int I = I(bArr, i4, registers);
        int i5 = registers.f33156a + I;
        while (I < i5) {
            I = I(bArr, I, registers);
            intArrayList.addInt(CodedInputStream.decodeZigZag32(registers.f33156a));
        }
        if (I == i5) {
            return I;
        }
        throw InvalidProtocolBufferException.n();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int x(byte[] bArr, int i4, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        LongArrayList longArrayList = (LongArrayList) protobufList;
        int I = I(bArr, i4, registers);
        int i5 = registers.f33156a + I;
        while (I < i5) {
            I = L(bArr, I, registers);
            longArrayList.addLong(CodedInputStream.decodeZigZag64(registers.f33157b));
        }
        if (I == i5) {
            return I;
        }
        throw InvalidProtocolBufferException.n();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int y(byte[] bArr, int i4, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        IntArrayList intArrayList = (IntArrayList) protobufList;
        int I = I(bArr, i4, registers);
        int i5 = registers.f33156a + I;
        while (I < i5) {
            I = I(bArr, I, registers);
            intArrayList.addInt(registers.f33156a);
        }
        if (I == i5) {
            return I;
        }
        throw InvalidProtocolBufferException.n();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int z(byte[] bArr, int i4, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        LongArrayList longArrayList = (LongArrayList) protobufList;
        int I = I(bArr, i4, registers);
        int i5 = registers.f33156a + I;
        while (I < i5) {
            I = L(bArr, I, registers);
            longArrayList.addLong(registers.f33157b);
        }
        if (I == i5) {
            return I;
        }
        throw InvalidProtocolBufferException.n();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class Registers {

        /* renamed from: a  reason: collision with root package name */
        public int f33156a;

        /* renamed from: b  reason: collision with root package name */
        public long f33157b;

        /* renamed from: c  reason: collision with root package name */
        public Object f33158c;

        /* renamed from: d  reason: collision with root package name */
        public final ExtensionRegistryLite f33159d;

        Registers() {
            this.f33159d = ExtensionRegistryLite.getEmptyRegistry();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Registers(ExtensionRegistryLite extensionRegistryLite) {
            extensionRegistryLite.getClass();
            this.f33159d = extensionRegistryLite;
        }
    }
}
