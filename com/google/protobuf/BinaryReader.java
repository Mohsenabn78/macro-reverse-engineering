package com.google.protobuf;

import com.google.android.gms.nearby.uwb.RangingPosition;
import com.google.common.base.Ascii;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@CheckReturnValue
/* loaded from: classes6.dex */
abstract class BinaryReader implements Reader {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.protobuf.BinaryReader$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f33160a;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            f33160a = iArr;
            try {
                iArr[WireFormat.FieldType.BOOL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f33160a[WireFormat.FieldType.BYTES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f33160a[WireFormat.FieldType.DOUBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f33160a[WireFormat.FieldType.ENUM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f33160a[WireFormat.FieldType.FIXED32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f33160a[WireFormat.FieldType.FIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f33160a[WireFormat.FieldType.FLOAT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f33160a[WireFormat.FieldType.INT32.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f33160a[WireFormat.FieldType.INT64.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f33160a[WireFormat.FieldType.MESSAGE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f33160a[WireFormat.FieldType.SFIXED32.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f33160a[WireFormat.FieldType.SFIXED64.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f33160a[WireFormat.FieldType.SINT32.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f33160a[WireFormat.FieldType.SINT64.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f33160a[WireFormat.FieldType.STRING.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f33160a[WireFormat.FieldType.UINT32.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f33160a[WireFormat.FieldType.UINT64.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    /* loaded from: classes6.dex */
    private static final class SafeHeapReader extends BinaryReader {

        /* renamed from: a  reason: collision with root package name */
        private final boolean f33161a;

        /* renamed from: b  reason: collision with root package name */
        private final byte[] f33162b;

        /* renamed from: c  reason: collision with root package name */
        private int f33163c;

        /* renamed from: d  reason: collision with root package name */
        private int f33164d;

        /* renamed from: e  reason: collision with root package name */
        private int f33165e;

        /* renamed from: f  reason: collision with root package name */
        private int f33166f;

        private void A() throws IOException {
            int i4 = this.f33164d;
            int i5 = this.f33163c;
            if (i4 - i5 >= 10) {
                byte[] bArr = this.f33162b;
                int i6 = 0;
                while (i6 < 10) {
                    int i7 = i5 + 1;
                    if (bArr[i5] >= 0) {
                        this.f33163c = i7;
                        return;
                    } else {
                        i6++;
                        i5 = i7;
                    }
                }
            }
            B();
        }

        private void B() throws IOException {
            for (int i4 = 0; i4 < 10; i4++) {
                if (i() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.g();
        }

        private void C(int i4) throws IOException {
            v(i4);
            if ((i4 & 3) == 0) {
                return;
            }
            throw InvalidProtocolBufferException.i();
        }

        private void D(int i4) throws IOException {
            v(i4);
            if ((i4 & 7) == 0) {
                return;
            }
            throw InvalidProtocolBufferException.i();
        }

        private boolean h() {
            if (this.f33163c == this.f33164d) {
                return true;
            }
            return false;
        }

        private byte i() throws IOException {
            int i4 = this.f33163c;
            if (i4 != this.f33164d) {
                byte[] bArr = this.f33162b;
                this.f33163c = i4 + 1;
                return bArr[i4];
            }
            throw InvalidProtocolBufferException.n();
        }

        private Object j(WireFormat.FieldType fieldType, Class<?> cls, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            switch (AnonymousClass1.f33160a[fieldType.ordinal()]) {
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
                    throw new RuntimeException("unsupported field type.");
            }
        }

        private <T> T k(Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            T newInstance = schema.newInstance();
            b(newInstance, schema, extensionRegistryLite);
            schema.makeImmutable(newInstance);
            return newInstance;
        }

        private int l() throws IOException {
            v(4);
            return m();
        }

        private int m() {
            int i4 = this.f33163c;
            byte[] bArr = this.f33162b;
            this.f33163c = i4 + 4;
            return ((bArr[i4 + 3] & 255) << 24) | (bArr[i4] & 255) | ((bArr[i4 + 1] & 255) << 8) | ((bArr[i4 + 2] & 255) << 16);
        }

        private long n() throws IOException {
            v(8);
            return o();
        }

        private long o() {
            int i4 = this.f33163c;
            byte[] bArr = this.f33162b;
            this.f33163c = i4 + 8;
            return ((bArr[i4 + 7] & 255) << 56) | (bArr[i4] & 255) | ((bArr[i4 + 1] & 255) << 8) | ((bArr[i4 + 2] & 255) << 16) | ((bArr[i4 + 3] & 255) << 24) | ((bArr[i4 + 4] & 255) << 32) | ((bArr[i4 + 5] & 255) << 40) | ((bArr[i4 + 6] & 255) << 48);
        }

        private <T> T p(Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            T newInstance = schema.newInstance();
            c(newInstance, schema, extensionRegistryLite);
            schema.makeImmutable(newInstance);
            return newInstance;
        }

        private int s() throws IOException {
            int i4;
            int i5 = this.f33163c;
            int i6 = this.f33164d;
            if (i6 != i5) {
                byte[] bArr = this.f33162b;
                int i7 = i5 + 1;
                byte b4 = bArr[i5];
                if (b4 >= 0) {
                    this.f33163c = i7;
                    return b4;
                } else if (i6 - i7 < 9) {
                    return (int) u();
                } else {
                    int i8 = i7 + 1;
                    int i9 = b4 ^ (bArr[i7] << 7);
                    if (i9 < 0) {
                        i4 = i9 ^ RangingPosition.RSSI_UNKNOWN;
                    } else {
                        int i10 = i8 + 1;
                        int i11 = i9 ^ (bArr[i8] << Ascii.SO);
                        if (i11 >= 0) {
                            i4 = i11 ^ 16256;
                        } else {
                            i8 = i10 + 1;
                            int i12 = i11 ^ (bArr[i10] << Ascii.NAK);
                            if (i12 < 0) {
                                i4 = i12 ^ (-2080896);
                            } else {
                                i10 = i8 + 1;
                                byte b5 = bArr[i8];
                                i4 = (i12 ^ (b5 << Ascii.FS)) ^ 266354560;
                                if (b5 < 0) {
                                    i8 = i10 + 1;
                                    if (bArr[i10] < 0) {
                                        i10 = i8 + 1;
                                        if (bArr[i8] < 0) {
                                            i8 = i10 + 1;
                                            if (bArr[i10] < 0) {
                                                i10 = i8 + 1;
                                                if (bArr[i8] < 0) {
                                                    i8 = i10 + 1;
                                                    if (bArr[i10] < 0) {
                                                        throw InvalidProtocolBufferException.g();
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        i8 = i10;
                    }
                    this.f33163c = i8;
                    return i4;
                }
            }
            throw InvalidProtocolBufferException.n();
        }

        private long u() throws IOException {
            long j4 = 0;
            for (int i4 = 0; i4 < 64; i4 += 7) {
                byte i5 = i();
                j4 |= (i5 & Byte.MAX_VALUE) << i4;
                if ((i5 & 128) == 0) {
                    return j4;
                }
            }
            throw InvalidProtocolBufferException.g();
        }

        private void v(int i4) throws IOException {
            if (i4 >= 0 && i4 <= this.f33164d - this.f33163c) {
                return;
            }
            throw InvalidProtocolBufferException.n();
        }

        private void w(int i4) throws IOException {
            if (this.f33163c == i4) {
                return;
            }
            throw InvalidProtocolBufferException.n();
        }

        private void x(int i4) throws IOException {
            if (WireFormat.getTagWireType(this.f33165e) == i4) {
                return;
            }
            throw InvalidProtocolBufferException.f();
        }

        private void y(int i4) throws IOException {
            v(i4);
            this.f33163c += i4;
        }

        private void z() throws IOException {
            int i4 = this.f33166f;
            this.f33166f = WireFormat.a(WireFormat.getTagFieldNumber(this.f33165e), 4);
            while (getFieldNumber() != Integer.MAX_VALUE && skipField()) {
            }
            if (this.f33165e == this.f33166f) {
                this.f33166f = i4;
                return;
            }
            throw InvalidProtocolBufferException.i();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.Reader
        public <K, V> void a(Map<K, V> map, MapEntryLite.Metadata<K, V> metadata, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            x(2);
            int s3 = s();
            v(s3);
            int i4 = this.f33164d;
            this.f33164d = this.f33163c + s3;
            try {
                Object obj = metadata.f33470b;
                Object obj2 = metadata.f33472d;
                while (true) {
                    int fieldNumber = getFieldNumber();
                    if (fieldNumber == Integer.MAX_VALUE) {
                        map.put(obj, obj2);
                        return;
                    } else if (fieldNumber != 1) {
                        if (fieldNumber != 2) {
                            try {
                                if (!skipField()) {
                                    throw new InvalidProtocolBufferException("Unable to parse map entry.");
                                    break;
                                }
                            } catch (InvalidProtocolBufferException.InvalidWireTypeException unused) {
                                if (!skipField()) {
                                    throw new InvalidProtocolBufferException("Unable to parse map entry.");
                                }
                            }
                        } else {
                            obj2 = j(metadata.f33471c, metadata.f33472d.getClass(), extensionRegistryLite);
                        }
                    } else {
                        obj = j(metadata.f33469a, null, null);
                    }
                }
            } finally {
                this.f33164d = i4;
            }
        }

        @Override // com.google.protobuf.Reader
        public <T> void b(T t3, Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int i4 = this.f33166f;
            this.f33166f = WireFormat.a(WireFormat.getTagFieldNumber(this.f33165e), 4);
            try {
                schema.c(t3, this, extensionRegistryLite);
                if (this.f33165e == this.f33166f) {
                    return;
                }
                throw InvalidProtocolBufferException.i();
            } finally {
                this.f33166f = i4;
            }
        }

        @Override // com.google.protobuf.Reader
        public <T> void c(T t3, Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int s3 = s();
            v(s3);
            int i4 = this.f33164d;
            int i5 = this.f33163c + s3;
            this.f33164d = i5;
            try {
                schema.c(t3, this, extensionRegistryLite);
                if (this.f33163c == i5) {
                    return;
                }
                throw InvalidProtocolBufferException.i();
            } finally {
                this.f33164d = i4;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.Reader
        @Deprecated
        public <T> void d(List<T> list, Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int i4;
            if (WireFormat.getTagWireType(this.f33165e) == 3) {
                int i5 = this.f33165e;
                do {
                    list.add(k(schema, extensionRegistryLite));
                    if (h()) {
                        return;
                    }
                    i4 = this.f33163c;
                } while (s() == i5);
                this.f33163c = i4;
                return;
            }
            throw InvalidProtocolBufferException.f();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.Reader
        public <T> void e(List<T> list, Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int i4;
            if (WireFormat.getTagWireType(this.f33165e) == 2) {
                int i5 = this.f33165e;
                do {
                    list.add(p(schema, extensionRegistryLite));
                    if (h()) {
                        return;
                    }
                    i4 = this.f33163c;
                } while (s() == i5);
                this.f33163c = i4;
                return;
            }
            throw InvalidProtocolBufferException.f();
        }

        @Override // com.google.protobuf.Reader
        @Deprecated
        public <T> T f(Class<T> cls, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            x(3);
            return (T) k(Protobuf.a().c(cls), extensionRegistryLite);
        }

        @Override // com.google.protobuf.Reader
        public <T> T g(Class<T> cls, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            x(2);
            return (T) p(Protobuf.a().c(cls), extensionRegistryLite);
        }

        @Override // com.google.protobuf.Reader
        public int getFieldNumber() throws IOException {
            if (h()) {
                return Integer.MAX_VALUE;
            }
            int s3 = s();
            this.f33165e = s3;
            if (s3 == this.f33166f) {
                return Integer.MAX_VALUE;
            }
            return WireFormat.getTagFieldNumber(s3);
        }

        @Override // com.google.protobuf.Reader
        public int getTag() {
            return this.f33165e;
        }

        public String q(boolean z3) throws IOException {
            x(2);
            int s3 = s();
            if (s3 == 0) {
                return "";
            }
            v(s3);
            if (z3) {
                byte[] bArr = this.f33162b;
                int i4 = this.f33163c;
                if (!Utf8.u(bArr, i4, i4 + s3)) {
                    throw InvalidProtocolBufferException.e();
                }
            }
            String str = new String(this.f33162b, this.f33163c, s3, Internal.f33419b);
            this.f33163c += s3;
            return str;
        }

        public void r(List<String> list, boolean z3) throws IOException {
            int i4;
            int i5;
            if (WireFormat.getTagWireType(this.f33165e) == 2) {
                if ((list instanceof LazyStringList) && !z3) {
                    LazyStringList lazyStringList = (LazyStringList) list;
                    do {
                        lazyStringList.add(readBytes());
                        if (h()) {
                            return;
                        }
                        i5 = this.f33163c;
                    } while (s() == this.f33165e);
                    this.f33163c = i5;
                    return;
                }
                do {
                    list.add(q(z3));
                    if (h()) {
                        return;
                    }
                    i4 = this.f33163c;
                } while (s() == this.f33165e);
                this.f33163c = i4;
                return;
            }
            throw InvalidProtocolBufferException.f();
        }

        @Override // com.google.protobuf.Reader
        public boolean readBool() throws IOException {
            x(0);
            if (s() == 0) {
                return false;
            }
            return true;
        }

        @Override // com.google.protobuf.Reader
        public void readBoolList(List<Boolean> list) throws IOException {
            int i4;
            boolean z3;
            int i5;
            boolean z4;
            if (list instanceof BooleanArrayList) {
                BooleanArrayList booleanArrayList = (BooleanArrayList) list;
                int tagWireType = WireFormat.getTagWireType(this.f33165e);
                if (tagWireType != 0) {
                    if (tagWireType == 2) {
                        int s3 = this.f33163c + s();
                        while (this.f33163c < s3) {
                            if (s() != 0) {
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                            booleanArrayList.addBoolean(z4);
                        }
                        w(s3);
                        return;
                    }
                    throw InvalidProtocolBufferException.f();
                }
                do {
                    booleanArrayList.addBoolean(readBool());
                    if (h()) {
                        return;
                    }
                    i5 = this.f33163c;
                } while (s() == this.f33165e);
                this.f33163c = i5;
                return;
            }
            int tagWireType2 = WireFormat.getTagWireType(this.f33165e);
            if (tagWireType2 != 0) {
                if (tagWireType2 == 2) {
                    int s4 = this.f33163c + s();
                    while (this.f33163c < s4) {
                        if (s() != 0) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        list.add(Boolean.valueOf(z3));
                    }
                    w(s4);
                    return;
                }
                throw InvalidProtocolBufferException.f();
            }
            do {
                list.add(Boolean.valueOf(readBool()));
                if (h()) {
                    return;
                }
                i4 = this.f33163c;
            } while (s() == this.f33165e);
            this.f33163c = i4;
        }

        @Override // com.google.protobuf.Reader
        public ByteString readBytes() throws IOException {
            ByteString copyFrom;
            x(2);
            int s3 = s();
            if (s3 == 0) {
                return ByteString.EMPTY;
            }
            v(s3);
            if (this.f33161a) {
                copyFrom = ByteString.w(this.f33162b, this.f33163c, s3);
            } else {
                copyFrom = ByteString.copyFrom(this.f33162b, this.f33163c, s3);
            }
            this.f33163c += s3;
            return copyFrom;
        }

        @Override // com.google.protobuf.Reader
        public void readBytesList(List<ByteString> list) throws IOException {
            int i4;
            if (WireFormat.getTagWireType(this.f33165e) == 2) {
                do {
                    list.add(readBytes());
                    if (h()) {
                        return;
                    }
                    i4 = this.f33163c;
                } while (s() == this.f33165e);
                this.f33163c = i4;
                return;
            }
            throw InvalidProtocolBufferException.f();
        }

        @Override // com.google.protobuf.Reader
        public double readDouble() throws IOException {
            x(1);
            return Double.longBitsToDouble(n());
        }

        @Override // com.google.protobuf.Reader
        public void readDoubleList(List<Double> list) throws IOException {
            int i4;
            int i5;
            if (list instanceof DoubleArrayList) {
                DoubleArrayList doubleArrayList = (DoubleArrayList) list;
                int tagWireType = WireFormat.getTagWireType(this.f33165e);
                if (tagWireType != 1) {
                    if (tagWireType == 2) {
                        int s3 = s();
                        D(s3);
                        int i6 = this.f33163c + s3;
                        while (this.f33163c < i6) {
                            doubleArrayList.addDouble(Double.longBitsToDouble(o()));
                        }
                        return;
                    }
                    throw InvalidProtocolBufferException.f();
                }
                do {
                    doubleArrayList.addDouble(readDouble());
                    if (h()) {
                        return;
                    }
                    i5 = this.f33163c;
                } while (s() == this.f33165e);
                this.f33163c = i5;
                return;
            }
            int tagWireType2 = WireFormat.getTagWireType(this.f33165e);
            if (tagWireType2 != 1) {
                if (tagWireType2 == 2) {
                    int s4 = s();
                    D(s4);
                    int i7 = this.f33163c + s4;
                    while (this.f33163c < i7) {
                        list.add(Double.valueOf(Double.longBitsToDouble(o())));
                    }
                    return;
                }
                throw InvalidProtocolBufferException.f();
            }
            do {
                list.add(Double.valueOf(readDouble()));
                if (h()) {
                    return;
                }
                i4 = this.f33163c;
            } while (s() == this.f33165e);
            this.f33163c = i4;
        }

        @Override // com.google.protobuf.Reader
        public int readEnum() throws IOException {
            x(0);
            return s();
        }

        @Override // com.google.protobuf.Reader
        public void readEnumList(List<Integer> list) throws IOException {
            int i4;
            int i5;
            if (list instanceof IntArrayList) {
                IntArrayList intArrayList = (IntArrayList) list;
                int tagWireType = WireFormat.getTagWireType(this.f33165e);
                if (tagWireType != 0) {
                    if (tagWireType == 2) {
                        int s3 = this.f33163c + s();
                        while (this.f33163c < s3) {
                            intArrayList.addInt(s());
                        }
                        return;
                    }
                    throw InvalidProtocolBufferException.f();
                }
                do {
                    intArrayList.addInt(readEnum());
                    if (h()) {
                        return;
                    }
                    i5 = this.f33163c;
                } while (s() == this.f33165e);
                this.f33163c = i5;
                return;
            }
            int tagWireType2 = WireFormat.getTagWireType(this.f33165e);
            if (tagWireType2 != 0) {
                if (tagWireType2 == 2) {
                    int s4 = this.f33163c + s();
                    while (this.f33163c < s4) {
                        list.add(Integer.valueOf(s()));
                    }
                    return;
                }
                throw InvalidProtocolBufferException.f();
            }
            do {
                list.add(Integer.valueOf(readEnum()));
                if (h()) {
                    return;
                }
                i4 = this.f33163c;
            } while (s() == this.f33165e);
            this.f33163c = i4;
        }

        @Override // com.google.protobuf.Reader
        public int readFixed32() throws IOException {
            x(5);
            return l();
        }

        @Override // com.google.protobuf.Reader
        public void readFixed32List(List<Integer> list) throws IOException {
            int i4;
            int i5;
            if (list instanceof IntArrayList) {
                IntArrayList intArrayList = (IntArrayList) list;
                int tagWireType = WireFormat.getTagWireType(this.f33165e);
                if (tagWireType != 2) {
                    if (tagWireType == 5) {
                        do {
                            intArrayList.addInt(readFixed32());
                            if (h()) {
                                return;
                            }
                            i5 = this.f33163c;
                        } while (s() == this.f33165e);
                        this.f33163c = i5;
                        return;
                    }
                    throw InvalidProtocolBufferException.f();
                }
                int s3 = s();
                C(s3);
                int i6 = this.f33163c + s3;
                while (this.f33163c < i6) {
                    intArrayList.addInt(m());
                }
                return;
            }
            int tagWireType2 = WireFormat.getTagWireType(this.f33165e);
            if (tagWireType2 != 2) {
                if (tagWireType2 == 5) {
                    do {
                        list.add(Integer.valueOf(readFixed32()));
                        if (h()) {
                            return;
                        }
                        i4 = this.f33163c;
                    } while (s() == this.f33165e);
                    this.f33163c = i4;
                    return;
                }
                throw InvalidProtocolBufferException.f();
            }
            int s4 = s();
            C(s4);
            int i7 = this.f33163c + s4;
            while (this.f33163c < i7) {
                list.add(Integer.valueOf(m()));
            }
        }

        @Override // com.google.protobuf.Reader
        public long readFixed64() throws IOException {
            x(1);
            return n();
        }

        @Override // com.google.protobuf.Reader
        public void readFixed64List(List<Long> list) throws IOException {
            int i4;
            int i5;
            if (list instanceof LongArrayList) {
                LongArrayList longArrayList = (LongArrayList) list;
                int tagWireType = WireFormat.getTagWireType(this.f33165e);
                if (tagWireType != 1) {
                    if (tagWireType == 2) {
                        int s3 = s();
                        D(s3);
                        int i6 = this.f33163c + s3;
                        while (this.f33163c < i6) {
                            longArrayList.addLong(o());
                        }
                        return;
                    }
                    throw InvalidProtocolBufferException.f();
                }
                do {
                    longArrayList.addLong(readFixed64());
                    if (h()) {
                        return;
                    }
                    i5 = this.f33163c;
                } while (s() == this.f33165e);
                this.f33163c = i5;
                return;
            }
            int tagWireType2 = WireFormat.getTagWireType(this.f33165e);
            if (tagWireType2 != 1) {
                if (tagWireType2 == 2) {
                    int s4 = s();
                    D(s4);
                    int i7 = this.f33163c + s4;
                    while (this.f33163c < i7) {
                        list.add(Long.valueOf(o()));
                    }
                    return;
                }
                throw InvalidProtocolBufferException.f();
            }
            do {
                list.add(Long.valueOf(readFixed64()));
                if (h()) {
                    return;
                }
                i4 = this.f33163c;
            } while (s() == this.f33165e);
            this.f33163c = i4;
        }

        @Override // com.google.protobuf.Reader
        public float readFloat() throws IOException {
            x(5);
            return Float.intBitsToFloat(l());
        }

        @Override // com.google.protobuf.Reader
        public void readFloatList(List<Float> list) throws IOException {
            int i4;
            int i5;
            if (list instanceof FloatArrayList) {
                FloatArrayList floatArrayList = (FloatArrayList) list;
                int tagWireType = WireFormat.getTagWireType(this.f33165e);
                if (tagWireType != 2) {
                    if (tagWireType == 5) {
                        do {
                            floatArrayList.addFloat(readFloat());
                            if (h()) {
                                return;
                            }
                            i5 = this.f33163c;
                        } while (s() == this.f33165e);
                        this.f33163c = i5;
                        return;
                    }
                    throw InvalidProtocolBufferException.f();
                }
                int s3 = s();
                C(s3);
                int i6 = this.f33163c + s3;
                while (this.f33163c < i6) {
                    floatArrayList.addFloat(Float.intBitsToFloat(m()));
                }
                return;
            }
            int tagWireType2 = WireFormat.getTagWireType(this.f33165e);
            if (tagWireType2 != 2) {
                if (tagWireType2 == 5) {
                    do {
                        list.add(Float.valueOf(readFloat()));
                        if (h()) {
                            return;
                        }
                        i4 = this.f33163c;
                    } while (s() == this.f33165e);
                    this.f33163c = i4;
                    return;
                }
                throw InvalidProtocolBufferException.f();
            }
            int s4 = s();
            C(s4);
            int i7 = this.f33163c + s4;
            while (this.f33163c < i7) {
                list.add(Float.valueOf(Float.intBitsToFloat(m())));
            }
        }

        @Override // com.google.protobuf.Reader
        public int readInt32() throws IOException {
            x(0);
            return s();
        }

        @Override // com.google.protobuf.Reader
        public void readInt32List(List<Integer> list) throws IOException {
            int i4;
            int i5;
            if (list instanceof IntArrayList) {
                IntArrayList intArrayList = (IntArrayList) list;
                int tagWireType = WireFormat.getTagWireType(this.f33165e);
                if (tagWireType != 0) {
                    if (tagWireType == 2) {
                        int s3 = this.f33163c + s();
                        while (this.f33163c < s3) {
                            intArrayList.addInt(s());
                        }
                        w(s3);
                        return;
                    }
                    throw InvalidProtocolBufferException.f();
                }
                do {
                    intArrayList.addInt(readInt32());
                    if (h()) {
                        return;
                    }
                    i5 = this.f33163c;
                } while (s() == this.f33165e);
                this.f33163c = i5;
                return;
            }
            int tagWireType2 = WireFormat.getTagWireType(this.f33165e);
            if (tagWireType2 != 0) {
                if (tagWireType2 == 2) {
                    int s4 = this.f33163c + s();
                    while (this.f33163c < s4) {
                        list.add(Integer.valueOf(s()));
                    }
                    w(s4);
                    return;
                }
                throw InvalidProtocolBufferException.f();
            }
            do {
                list.add(Integer.valueOf(readInt32()));
                if (h()) {
                    return;
                }
                i4 = this.f33163c;
            } while (s() == this.f33165e);
            this.f33163c = i4;
        }

        @Override // com.google.protobuf.Reader
        public long readInt64() throws IOException {
            x(0);
            return t();
        }

        @Override // com.google.protobuf.Reader
        public void readInt64List(List<Long> list) throws IOException {
            int i4;
            int i5;
            if (list instanceof LongArrayList) {
                LongArrayList longArrayList = (LongArrayList) list;
                int tagWireType = WireFormat.getTagWireType(this.f33165e);
                if (tagWireType != 0) {
                    if (tagWireType == 2) {
                        int s3 = this.f33163c + s();
                        while (this.f33163c < s3) {
                            longArrayList.addLong(t());
                        }
                        w(s3);
                        return;
                    }
                    throw InvalidProtocolBufferException.f();
                }
                do {
                    longArrayList.addLong(readInt64());
                    if (h()) {
                        return;
                    }
                    i5 = this.f33163c;
                } while (s() == this.f33165e);
                this.f33163c = i5;
                return;
            }
            int tagWireType2 = WireFormat.getTagWireType(this.f33165e);
            if (tagWireType2 != 0) {
                if (tagWireType2 == 2) {
                    int s4 = this.f33163c + s();
                    while (this.f33163c < s4) {
                        list.add(Long.valueOf(t()));
                    }
                    w(s4);
                    return;
                }
                throw InvalidProtocolBufferException.f();
            }
            do {
                list.add(Long.valueOf(readInt64()));
                if (h()) {
                    return;
                }
                i4 = this.f33163c;
            } while (s() == this.f33165e);
            this.f33163c = i4;
        }

        @Override // com.google.protobuf.Reader
        public int readSFixed32() throws IOException {
            x(5);
            return l();
        }

        @Override // com.google.protobuf.Reader
        public void readSFixed32List(List<Integer> list) throws IOException {
            int i4;
            int i5;
            if (list instanceof IntArrayList) {
                IntArrayList intArrayList = (IntArrayList) list;
                int tagWireType = WireFormat.getTagWireType(this.f33165e);
                if (tagWireType != 2) {
                    if (tagWireType == 5) {
                        do {
                            intArrayList.addInt(readSFixed32());
                            if (h()) {
                                return;
                            }
                            i5 = this.f33163c;
                        } while (s() == this.f33165e);
                        this.f33163c = i5;
                        return;
                    }
                    throw InvalidProtocolBufferException.f();
                }
                int s3 = s();
                C(s3);
                int i6 = this.f33163c + s3;
                while (this.f33163c < i6) {
                    intArrayList.addInt(m());
                }
                return;
            }
            int tagWireType2 = WireFormat.getTagWireType(this.f33165e);
            if (tagWireType2 != 2) {
                if (tagWireType2 == 5) {
                    do {
                        list.add(Integer.valueOf(readSFixed32()));
                        if (h()) {
                            return;
                        }
                        i4 = this.f33163c;
                    } while (s() == this.f33165e);
                    this.f33163c = i4;
                    return;
                }
                throw InvalidProtocolBufferException.f();
            }
            int s4 = s();
            C(s4);
            int i7 = this.f33163c + s4;
            while (this.f33163c < i7) {
                list.add(Integer.valueOf(m()));
            }
        }

        @Override // com.google.protobuf.Reader
        public long readSFixed64() throws IOException {
            x(1);
            return n();
        }

        @Override // com.google.protobuf.Reader
        public void readSFixed64List(List<Long> list) throws IOException {
            int i4;
            int i5;
            if (list instanceof LongArrayList) {
                LongArrayList longArrayList = (LongArrayList) list;
                int tagWireType = WireFormat.getTagWireType(this.f33165e);
                if (tagWireType != 1) {
                    if (tagWireType == 2) {
                        int s3 = s();
                        D(s3);
                        int i6 = this.f33163c + s3;
                        while (this.f33163c < i6) {
                            longArrayList.addLong(o());
                        }
                        return;
                    }
                    throw InvalidProtocolBufferException.f();
                }
                do {
                    longArrayList.addLong(readSFixed64());
                    if (h()) {
                        return;
                    }
                    i5 = this.f33163c;
                } while (s() == this.f33165e);
                this.f33163c = i5;
                return;
            }
            int tagWireType2 = WireFormat.getTagWireType(this.f33165e);
            if (tagWireType2 != 1) {
                if (tagWireType2 == 2) {
                    int s4 = s();
                    D(s4);
                    int i7 = this.f33163c + s4;
                    while (this.f33163c < i7) {
                        list.add(Long.valueOf(o()));
                    }
                    return;
                }
                throw InvalidProtocolBufferException.f();
            }
            do {
                list.add(Long.valueOf(readSFixed64()));
                if (h()) {
                    return;
                }
                i4 = this.f33163c;
            } while (s() == this.f33165e);
            this.f33163c = i4;
        }

        @Override // com.google.protobuf.Reader
        public int readSInt32() throws IOException {
            x(0);
            return CodedInputStream.decodeZigZag32(s());
        }

        @Override // com.google.protobuf.Reader
        public void readSInt32List(List<Integer> list) throws IOException {
            int i4;
            int i5;
            if (list instanceof IntArrayList) {
                IntArrayList intArrayList = (IntArrayList) list;
                int tagWireType = WireFormat.getTagWireType(this.f33165e);
                if (tagWireType != 0) {
                    if (tagWireType == 2) {
                        int s3 = this.f33163c + s();
                        while (this.f33163c < s3) {
                            intArrayList.addInt(CodedInputStream.decodeZigZag32(s()));
                        }
                        return;
                    }
                    throw InvalidProtocolBufferException.f();
                }
                do {
                    intArrayList.addInt(readSInt32());
                    if (h()) {
                        return;
                    }
                    i5 = this.f33163c;
                } while (s() == this.f33165e);
                this.f33163c = i5;
                return;
            }
            int tagWireType2 = WireFormat.getTagWireType(this.f33165e);
            if (tagWireType2 != 0) {
                if (tagWireType2 == 2) {
                    int s4 = this.f33163c + s();
                    while (this.f33163c < s4) {
                        list.add(Integer.valueOf(CodedInputStream.decodeZigZag32(s())));
                    }
                    return;
                }
                throw InvalidProtocolBufferException.f();
            }
            do {
                list.add(Integer.valueOf(readSInt32()));
                if (h()) {
                    return;
                }
                i4 = this.f33163c;
            } while (s() == this.f33165e);
            this.f33163c = i4;
        }

        @Override // com.google.protobuf.Reader
        public long readSInt64() throws IOException {
            x(0);
            return CodedInputStream.decodeZigZag64(t());
        }

        @Override // com.google.protobuf.Reader
        public void readSInt64List(List<Long> list) throws IOException {
            int i4;
            int i5;
            if (list instanceof LongArrayList) {
                LongArrayList longArrayList = (LongArrayList) list;
                int tagWireType = WireFormat.getTagWireType(this.f33165e);
                if (tagWireType != 0) {
                    if (tagWireType == 2) {
                        int s3 = this.f33163c + s();
                        while (this.f33163c < s3) {
                            longArrayList.addLong(CodedInputStream.decodeZigZag64(t()));
                        }
                        return;
                    }
                    throw InvalidProtocolBufferException.f();
                }
                do {
                    longArrayList.addLong(readSInt64());
                    if (h()) {
                        return;
                    }
                    i5 = this.f33163c;
                } while (s() == this.f33165e);
                this.f33163c = i5;
                return;
            }
            int tagWireType2 = WireFormat.getTagWireType(this.f33165e);
            if (tagWireType2 != 0) {
                if (tagWireType2 == 2) {
                    int s4 = this.f33163c + s();
                    while (this.f33163c < s4) {
                        list.add(Long.valueOf(CodedInputStream.decodeZigZag64(t())));
                    }
                    return;
                }
                throw InvalidProtocolBufferException.f();
            }
            do {
                list.add(Long.valueOf(readSInt64()));
                if (h()) {
                    return;
                }
                i4 = this.f33163c;
            } while (s() == this.f33165e);
            this.f33163c = i4;
        }

        @Override // com.google.protobuf.Reader
        public String readString() throws IOException {
            return q(false);
        }

        @Override // com.google.protobuf.Reader
        public void readStringList(List<String> list) throws IOException {
            r(list, false);
        }

        @Override // com.google.protobuf.Reader
        public void readStringListRequireUtf8(List<String> list) throws IOException {
            r(list, true);
        }

        @Override // com.google.protobuf.Reader
        public String readStringRequireUtf8() throws IOException {
            return q(true);
        }

        @Override // com.google.protobuf.Reader
        public int readUInt32() throws IOException {
            x(0);
            return s();
        }

        @Override // com.google.protobuf.Reader
        public void readUInt32List(List<Integer> list) throws IOException {
            int i4;
            int i5;
            if (list instanceof IntArrayList) {
                IntArrayList intArrayList = (IntArrayList) list;
                int tagWireType = WireFormat.getTagWireType(this.f33165e);
                if (tagWireType != 0) {
                    if (tagWireType == 2) {
                        int s3 = this.f33163c + s();
                        while (this.f33163c < s3) {
                            intArrayList.addInt(s());
                        }
                        return;
                    }
                    throw InvalidProtocolBufferException.f();
                }
                do {
                    intArrayList.addInt(readUInt32());
                    if (h()) {
                        return;
                    }
                    i5 = this.f33163c;
                } while (s() == this.f33165e);
                this.f33163c = i5;
                return;
            }
            int tagWireType2 = WireFormat.getTagWireType(this.f33165e);
            if (tagWireType2 != 0) {
                if (tagWireType2 == 2) {
                    int s4 = this.f33163c + s();
                    while (this.f33163c < s4) {
                        list.add(Integer.valueOf(s()));
                    }
                    return;
                }
                throw InvalidProtocolBufferException.f();
            }
            do {
                list.add(Integer.valueOf(readUInt32()));
                if (h()) {
                    return;
                }
                i4 = this.f33163c;
            } while (s() == this.f33165e);
            this.f33163c = i4;
        }

        @Override // com.google.protobuf.Reader
        public long readUInt64() throws IOException {
            x(0);
            return t();
        }

        @Override // com.google.protobuf.Reader
        public void readUInt64List(List<Long> list) throws IOException {
            int i4;
            int i5;
            if (list instanceof LongArrayList) {
                LongArrayList longArrayList = (LongArrayList) list;
                int tagWireType = WireFormat.getTagWireType(this.f33165e);
                if (tagWireType != 0) {
                    if (tagWireType == 2) {
                        int s3 = this.f33163c + s();
                        while (this.f33163c < s3) {
                            longArrayList.addLong(t());
                        }
                        w(s3);
                        return;
                    }
                    throw InvalidProtocolBufferException.f();
                }
                do {
                    longArrayList.addLong(readUInt64());
                    if (h()) {
                        return;
                    }
                    i5 = this.f33163c;
                } while (s() == this.f33165e);
                this.f33163c = i5;
                return;
            }
            int tagWireType2 = WireFormat.getTagWireType(this.f33165e);
            if (tagWireType2 != 0) {
                if (tagWireType2 == 2) {
                    int s4 = this.f33163c + s();
                    while (this.f33163c < s4) {
                        list.add(Long.valueOf(t()));
                    }
                    w(s4);
                    return;
                }
                throw InvalidProtocolBufferException.f();
            }
            do {
                list.add(Long.valueOf(readUInt64()));
                if (h()) {
                    return;
                }
                i4 = this.f33163c;
            } while (s() == this.f33165e);
            this.f33163c = i4;
        }

        @Override // com.google.protobuf.Reader
        public boolean skipField() throws IOException {
            int i4;
            if (!h() && (i4 = this.f33165e) != this.f33166f) {
                int tagWireType = WireFormat.getTagWireType(i4);
                if (tagWireType != 0) {
                    if (tagWireType != 1) {
                        if (tagWireType != 2) {
                            if (tagWireType != 3) {
                                if (tagWireType == 5) {
                                    y(4);
                                    return true;
                                }
                                throw InvalidProtocolBufferException.f();
                            }
                            z();
                            return true;
                        }
                        y(s());
                        return true;
                    }
                    y(8);
                    return true;
                }
                A();
                return true;
            }
            return false;
        }

        public long t() throws IOException {
            long j4;
            long j5;
            long j6;
            int i4;
            int i5 = this.f33163c;
            int i6 = this.f33164d;
            if (i6 != i5) {
                byte[] bArr = this.f33162b;
                int i7 = i5 + 1;
                byte b4 = bArr[i5];
                if (b4 >= 0) {
                    this.f33163c = i7;
                    return b4;
                } else if (i6 - i7 < 9) {
                    return u();
                } else {
                    int i8 = i7 + 1;
                    int i9 = b4 ^ (bArr[i7] << 7);
                    if (i9 < 0) {
                        i4 = i9 ^ RangingPosition.RSSI_UNKNOWN;
                    } else {
                        int i10 = i8 + 1;
                        int i11 = i9 ^ (bArr[i8] << Ascii.SO);
                        if (i11 >= 0) {
                            i8 = i10;
                            j4 = i11 ^ 16256;
                        } else {
                            i8 = i10 + 1;
                            int i12 = i11 ^ (bArr[i10] << Ascii.NAK);
                            if (i12 < 0) {
                                i4 = i12 ^ (-2080896);
                            } else {
                                long j7 = i12;
                                int i13 = i8 + 1;
                                long j8 = j7 ^ (bArr[i8] << 28);
                                if (j8 >= 0) {
                                    j6 = 266354560;
                                } else {
                                    i8 = i13 + 1;
                                    long j9 = j8 ^ (bArr[i13] << 35);
                                    if (j9 < 0) {
                                        j5 = -34093383808L;
                                    } else {
                                        i13 = i8 + 1;
                                        j8 = j9 ^ (bArr[i8] << 42);
                                        if (j8 >= 0) {
                                            j6 = 4363953127296L;
                                        } else {
                                            i8 = i13 + 1;
                                            j9 = j8 ^ (bArr[i13] << 49);
                                            if (j9 < 0) {
                                                j5 = -558586000294016L;
                                            } else {
                                                int i14 = i8 + 1;
                                                long j10 = (j9 ^ (bArr[i8] << 56)) ^ 71499008037633920L;
                                                if (j10 < 0) {
                                                    i8 = i14 + 1;
                                                    if (bArr[i14] < 0) {
                                                        throw InvalidProtocolBufferException.g();
                                                    }
                                                } else {
                                                    i8 = i14;
                                                }
                                                j4 = j10;
                                            }
                                        }
                                    }
                                    j4 = j9 ^ j5;
                                }
                                j4 = j8 ^ j6;
                                i8 = i13;
                            }
                        }
                        this.f33163c = i8;
                        return j4;
                    }
                    j4 = i4;
                    this.f33163c = i8;
                    return j4;
                }
            }
            throw InvalidProtocolBufferException.n();
        }
    }

    private BinaryReader() {
    }
}
