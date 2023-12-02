package com.google.protobuf;

import com.google.android.gms.nearby.uwb.RangingPosition;
import com.google.common.base.Ascii;
import com.google.protobuf.MessageLite;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes6.dex */
public abstract class CodedInputStream {

    /* renamed from: f  reason: collision with root package name */
    private static volatile int f33215f = 100;

    /* renamed from: a  reason: collision with root package name */
    int f33216a;

    /* renamed from: b  reason: collision with root package name */
    int f33217b;

    /* renamed from: c  reason: collision with root package name */
    int f33218c;

    /* renamed from: d  reason: collision with root package name */
    CodedInputStreamReader f33219d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f33220e;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class ArrayDecoder extends CodedInputStream {

        /* renamed from: g  reason: collision with root package name */
        private final byte[] f33221g;

        /* renamed from: h  reason: collision with root package name */
        private final boolean f33222h;

        /* renamed from: i  reason: collision with root package name */
        private int f33223i;

        /* renamed from: j  reason: collision with root package name */
        private int f33224j;

        /* renamed from: k  reason: collision with root package name */
        private int f33225k;

        /* renamed from: l  reason: collision with root package name */
        private int f33226l;

        /* renamed from: m  reason: collision with root package name */
        private int f33227m;

        /* renamed from: n  reason: collision with root package name */
        private boolean f33228n;

        /* renamed from: o  reason: collision with root package name */
        private int f33229o;

        private void e() {
            int i4 = this.f33223i + this.f33224j;
            this.f33223i = i4;
            int i5 = i4 - this.f33226l;
            int i6 = this.f33229o;
            if (i5 > i6) {
                int i7 = i5 - i6;
                this.f33224j = i7;
                this.f33223i = i4 - i7;
                return;
            }
            this.f33224j = 0;
        }

        private void f() throws IOException {
            if (this.f33223i - this.f33225k >= 10) {
                g();
            } else {
                h();
            }
        }

        private void g() throws IOException {
            for (int i4 = 0; i4 < 10; i4++) {
                byte[] bArr = this.f33221g;
                int i5 = this.f33225k;
                this.f33225k = i5 + 1;
                if (bArr[i5] >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.g();
        }

        private void h() throws IOException {
            for (int i4 = 0; i4 < 10; i4++) {
                if (readRawByte() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.g();
        }

        @Override // com.google.protobuf.CodedInputStream
        public void checkLastTagWas(int i4) throws InvalidProtocolBufferException {
            if (this.f33227m == i4) {
                return;
            }
            throw InvalidProtocolBufferException.b();
        }

        long d() throws IOException {
            long j4 = 0;
            for (int i4 = 0; i4 < 64; i4 += 7) {
                byte readRawByte = readRawByte();
                j4 |= (readRawByte & Byte.MAX_VALUE) << i4;
                if ((readRawByte & 128) == 0) {
                    return j4;
                }
            }
            throw InvalidProtocolBufferException.g();
        }

        @Override // com.google.protobuf.CodedInputStream
        public void enableAliasing(boolean z3) {
            this.f33228n = z3;
        }

        @Override // com.google.protobuf.CodedInputStream
        public int getBytesUntilLimit() {
            int i4 = this.f33229o;
            if (i4 == Integer.MAX_VALUE) {
                return -1;
            }
            return i4 - getTotalBytesRead();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int getLastTag() {
            return this.f33227m;
        }

        @Override // com.google.protobuf.CodedInputStream
        public int getTotalBytesRead() {
            return this.f33225k - this.f33226l;
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean isAtEnd() throws IOException {
            if (this.f33225k == this.f33223i) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.CodedInputStream
        public void popLimit(int i4) {
            this.f33229o = i4;
            e();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int pushLimit(int i4) throws InvalidProtocolBufferException {
            if (i4 >= 0) {
                int totalBytesRead = i4 + getTotalBytesRead();
                if (totalBytesRead >= 0) {
                    int i5 = this.f33229o;
                    if (totalBytesRead <= i5) {
                        this.f33229o = totalBytesRead;
                        e();
                        return i5;
                    }
                    throw InvalidProtocolBufferException.n();
                }
                throw InvalidProtocolBufferException.i();
            }
            throw InvalidProtocolBufferException.h();
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean readBool() throws IOException {
            if (readRawVarint64() != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte[] readByteArray() throws IOException {
            return readRawBytes(readRawVarint32());
        }

        @Override // com.google.protobuf.CodedInputStream
        public ByteBuffer readByteBuffer() throws IOException {
            ByteBuffer wrap;
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0) {
                int i4 = this.f33223i;
                int i5 = this.f33225k;
                if (readRawVarint32 <= i4 - i5) {
                    if (!this.f33222h && this.f33228n) {
                        wrap = ByteBuffer.wrap(this.f33221g, i5, readRawVarint32).slice();
                    } else {
                        wrap = ByteBuffer.wrap(Arrays.copyOfRange(this.f33221g, i5, i5 + readRawVarint32));
                    }
                    this.f33225k += readRawVarint32;
                    return wrap;
                }
            }
            if (readRawVarint32 == 0) {
                return Internal.EMPTY_BYTE_BUFFER;
            }
            if (readRawVarint32 < 0) {
                throw InvalidProtocolBufferException.h();
            }
            throw InvalidProtocolBufferException.n();
        }

        @Override // com.google.protobuf.CodedInputStream
        public ByteString readBytes() throws IOException {
            ByteString copyFrom;
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0) {
                int i4 = this.f33223i;
                int i5 = this.f33225k;
                if (readRawVarint32 <= i4 - i5) {
                    if (this.f33222h && this.f33228n) {
                        copyFrom = ByteString.w(this.f33221g, i5, readRawVarint32);
                    } else {
                        copyFrom = ByteString.copyFrom(this.f33221g, i5, readRawVarint32);
                    }
                    this.f33225k += readRawVarint32;
                    return copyFrom;
                }
            }
            if (readRawVarint32 == 0) {
                return ByteString.EMPTY;
            }
            return ByteString.v(readRawBytes(readRawVarint32));
        }

        @Override // com.google.protobuf.CodedInputStream
        public double readDouble() throws IOException {
            return Double.longBitsToDouble(readRawLittleEndian64());
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readEnum() throws IOException {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public float readFloat() throws IOException {
            return Float.intBitsToFloat(readRawLittleEndian32());
        }

        @Override // com.google.protobuf.CodedInputStream
        public void readGroup(int i4, MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            checkRecursionLimit();
            this.f33216a++;
            builder.mergeFrom(this, extensionRegistryLite);
            checkLastTagWas(WireFormat.a(i4, 4));
            this.f33216a--;
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readInt32() throws IOException {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readInt64() throws IOException {
            return readRawVarint64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public void readMessage(MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int readRawVarint32 = readRawVarint32();
            checkRecursionLimit();
            int pushLimit = pushLimit(readRawVarint32);
            this.f33216a++;
            builder.mergeFrom(this, extensionRegistryLite);
            checkLastTagWas(0);
            this.f33216a--;
            if (getBytesUntilLimit() == 0) {
                popLimit(pushLimit);
                return;
            }
            throw InvalidProtocolBufferException.n();
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte readRawByte() throws IOException {
            int i4 = this.f33225k;
            if (i4 != this.f33223i) {
                byte[] bArr = this.f33221g;
                this.f33225k = i4 + 1;
                return bArr[i4];
            }
            throw InvalidProtocolBufferException.n();
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte[] readRawBytes(int i4) throws IOException {
            if (i4 > 0) {
                int i5 = this.f33223i;
                int i6 = this.f33225k;
                if (i4 <= i5 - i6) {
                    int i7 = i4 + i6;
                    this.f33225k = i7;
                    return Arrays.copyOfRange(this.f33221g, i6, i7);
                }
            }
            if (i4 <= 0) {
                if (i4 == 0) {
                    return Internal.EMPTY_BYTE_ARRAY;
                }
                throw InvalidProtocolBufferException.h();
            }
            throw InvalidProtocolBufferException.n();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readRawLittleEndian32() throws IOException {
            int i4 = this.f33225k;
            if (this.f33223i - i4 >= 4) {
                byte[] bArr = this.f33221g;
                this.f33225k = i4 + 4;
                return ((bArr[i4 + 3] & 255) << 24) | (bArr[i4] & 255) | ((bArr[i4 + 1] & 255) << 8) | ((bArr[i4 + 2] & 255) << 16);
            }
            throw InvalidProtocolBufferException.n();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readRawLittleEndian64() throws IOException {
            int i4 = this.f33225k;
            if (this.f33223i - i4 >= 8) {
                byte[] bArr = this.f33221g;
                this.f33225k = i4 + 8;
                return ((bArr[i4 + 7] & 255) << 56) | (bArr[i4] & 255) | ((bArr[i4 + 1] & 255) << 8) | ((bArr[i4 + 2] & 255) << 16) | ((bArr[i4 + 3] & 255) << 24) | ((bArr[i4 + 4] & 255) << 32) | ((bArr[i4 + 5] & 255) << 40) | ((bArr[i4 + 6] & 255) << 48);
            }
            throw InvalidProtocolBufferException.n();
        }

        /* JADX WARN: Code restructure failed: missing block: B:33:0x0068, code lost:
            if (r2[r3] < 0) goto L34;
         */
        @Override // com.google.protobuf.CodedInputStream
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public int readRawVarint32() throws java.io.IOException {
            /*
                r5 = this;
                int r0 = r5.f33225k
                int r1 = r5.f33223i
                if (r1 != r0) goto L7
                goto L6a
            L7:
                byte[] r2 = r5.f33221g
                int r3 = r0 + 1
                r0 = r2[r0]
                if (r0 < 0) goto L12
                r5.f33225k = r3
                return r0
            L12:
                int r1 = r1 - r3
                r4 = 9
                if (r1 >= r4) goto L18
                goto L6a
            L18:
                int r1 = r3 + 1
                r3 = r2[r3]
                int r3 = r3 << 7
                r0 = r0 ^ r3
                if (r0 >= 0) goto L24
                r0 = r0 ^ (-128(0xffffffffffffff80, float:NaN))
                goto L70
            L24:
                int r3 = r1 + 1
                r1 = r2[r1]
                int r1 = r1 << 14
                r0 = r0 ^ r1
                if (r0 < 0) goto L31
                r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
            L2f:
                r1 = r3
                goto L70
            L31:
                int r1 = r3 + 1
                r3 = r2[r3]
                int r3 = r3 << 21
                r0 = r0 ^ r3
                if (r0 >= 0) goto L3f
                r2 = -2080896(0xffffffffffe03f80, float:NaN)
                r0 = r0 ^ r2
                goto L70
            L3f:
                int r3 = r1 + 1
                r1 = r2[r1]
                int r4 = r1 << 28
                r0 = r0 ^ r4
                r4 = 266354560(0xfe03f80, float:2.2112565E-29)
                r0 = r0 ^ r4
                if (r1 >= 0) goto L2f
                int r1 = r3 + 1
                r3 = r2[r3]
                if (r3 >= 0) goto L70
                int r3 = r1 + 1
                r1 = r2[r1]
                if (r1 >= 0) goto L2f
                int r1 = r3 + 1
                r3 = r2[r3]
                if (r3 >= 0) goto L70
                int r3 = r1 + 1
                r1 = r2[r1]
                if (r1 >= 0) goto L2f
                int r1 = r3 + 1
                r2 = r2[r3]
                if (r2 >= 0) goto L70
            L6a:
                long r0 = r5.d()
                int r1 = (int) r0
                return r1
            L70:
                r5.f33225k = r1
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.CodedInputStream.ArrayDecoder.readRawVarint32():int");
        }

        /* JADX WARN: Code restructure failed: missing block: B:39:0x00b4, code lost:
            if (r2[r0] < 0) goto L42;
         */
        @Override // com.google.protobuf.CodedInputStream
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public long readRawVarint64() throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 192
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.CodedInputStream.ArrayDecoder.readRawVarint64():long");
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readSFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readSFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readSInt32() throws IOException {
            return CodedInputStream.decodeZigZag32(readRawVarint32());
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readSInt64() throws IOException {
            return CodedInputStream.decodeZigZag64(readRawVarint64());
        }

        @Override // com.google.protobuf.CodedInputStream
        public String readString() throws IOException {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0) {
                int i4 = this.f33223i;
                int i5 = this.f33225k;
                if (readRawVarint32 <= i4 - i5) {
                    String str = new String(this.f33221g, i5, readRawVarint32, Internal.f33419b);
                    this.f33225k += readRawVarint32;
                    return str;
                }
            }
            if (readRawVarint32 == 0) {
                return "";
            }
            if (readRawVarint32 < 0) {
                throw InvalidProtocolBufferException.h();
            }
            throw InvalidProtocolBufferException.n();
        }

        @Override // com.google.protobuf.CodedInputStream
        public String readStringRequireUtf8() throws IOException {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0) {
                int i4 = this.f33223i;
                int i5 = this.f33225k;
                if (readRawVarint32 <= i4 - i5) {
                    String h4 = Utf8.h(this.f33221g, i5, readRawVarint32);
                    this.f33225k += readRawVarint32;
                    return h4;
                }
            }
            if (readRawVarint32 == 0) {
                return "";
            }
            if (readRawVarint32 <= 0) {
                throw InvalidProtocolBufferException.h();
            }
            throw InvalidProtocolBufferException.n();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readTag() throws IOException {
            if (isAtEnd()) {
                this.f33227m = 0;
                return 0;
            }
            int readRawVarint32 = readRawVarint32();
            this.f33227m = readRawVarint32;
            if (WireFormat.getTagFieldNumber(readRawVarint32) != 0) {
                return this.f33227m;
            }
            throw InvalidProtocolBufferException.c();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readUInt32() throws IOException {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readUInt64() throws IOException {
            return readRawVarint64();
        }

        @Override // com.google.protobuf.CodedInputStream
        @Deprecated
        public void readUnknownGroup(int i4, MessageLite.Builder builder) throws IOException {
            readGroup(i4, builder, ExtensionRegistryLite.getEmptyRegistry());
        }

        @Override // com.google.protobuf.CodedInputStream
        public void resetSizeCounter() {
            this.f33226l = this.f33225k;
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean skipField(int i4) throws IOException {
            int tagWireType = WireFormat.getTagWireType(i4);
            if (tagWireType == 0) {
                f();
                return true;
            } else if (tagWireType == 1) {
                skipRawBytes(8);
                return true;
            } else if (tagWireType == 2) {
                skipRawBytes(readRawVarint32());
                return true;
            } else if (tagWireType == 3) {
                skipMessage();
                checkLastTagWas(WireFormat.a(WireFormat.getTagFieldNumber(i4), 4));
                return true;
            } else if (tagWireType != 4) {
                if (tagWireType == 5) {
                    skipRawBytes(4);
                    return true;
                }
                throw InvalidProtocolBufferException.f();
            } else {
                return false;
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public void skipMessage() throws IOException {
            int readTag;
            do {
                readTag = readTag();
                if (readTag == 0) {
                    return;
                }
            } while (skipField(readTag));
        }

        @Override // com.google.protobuf.CodedInputStream
        public void skipRawBytes(int i4) throws IOException {
            if (i4 >= 0) {
                int i5 = this.f33223i;
                int i6 = this.f33225k;
                if (i4 <= i5 - i6) {
                    this.f33225k = i6 + i4;
                    return;
                }
            }
            if (i4 < 0) {
                throw InvalidProtocolBufferException.h();
            }
            throw InvalidProtocolBufferException.n();
        }

        private ArrayDecoder(byte[] bArr, int i4, int i5, boolean z3) {
            super();
            this.f33229o = Integer.MAX_VALUE;
            this.f33221g = bArr;
            this.f33223i = i5 + i4;
            this.f33225k = i4;
            this.f33226l = i4;
            this.f33222h = z3;
        }

        @Override // com.google.protobuf.CodedInputStream
        public void skipMessage(CodedOutputStream codedOutputStream) throws IOException {
            int readTag;
            do {
                readTag = readTag();
                if (readTag == 0) {
                    return;
                }
            } while (skipField(readTag, codedOutputStream));
        }

        @Override // com.google.protobuf.CodedInputStream
        public <T extends MessageLite> T readGroup(int i4, Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            checkRecursionLimit();
            this.f33216a++;
            T parsePartialFrom = parser.parsePartialFrom(this, extensionRegistryLite);
            checkLastTagWas(WireFormat.a(i4, 4));
            this.f33216a--;
            return parsePartialFrom;
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean skipField(int i4, CodedOutputStream codedOutputStream) throws IOException {
            int tagWireType = WireFormat.getTagWireType(i4);
            if (tagWireType == 0) {
                long readInt64 = readInt64();
                codedOutputStream.writeUInt32NoTag(i4);
                codedOutputStream.writeUInt64NoTag(readInt64);
                return true;
            } else if (tagWireType == 1) {
                long readRawLittleEndian64 = readRawLittleEndian64();
                codedOutputStream.writeUInt32NoTag(i4);
                codedOutputStream.writeFixed64NoTag(readRawLittleEndian64);
                return true;
            } else if (tagWireType == 2) {
                ByteString readBytes = readBytes();
                codedOutputStream.writeUInt32NoTag(i4);
                codedOutputStream.writeBytesNoTag(readBytes);
                return true;
            } else if (tagWireType == 3) {
                codedOutputStream.writeUInt32NoTag(i4);
                skipMessage(codedOutputStream);
                int a4 = WireFormat.a(WireFormat.getTagFieldNumber(i4), 4);
                checkLastTagWas(a4);
                codedOutputStream.writeUInt32NoTag(a4);
                return true;
            } else if (tagWireType != 4) {
                if (tagWireType == 5) {
                    int readRawLittleEndian32 = readRawLittleEndian32();
                    codedOutputStream.writeUInt32NoTag(i4);
                    codedOutputStream.writeFixed32NoTag(readRawLittleEndian32);
                    return true;
                }
                throw InvalidProtocolBufferException.f();
            } else {
                return false;
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public <T extends MessageLite> T readMessage(Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int readRawVarint32 = readRawVarint32();
            checkRecursionLimit();
            int pushLimit = pushLimit(readRawVarint32);
            this.f33216a++;
            T parsePartialFrom = parser.parsePartialFrom(this, extensionRegistryLite);
            checkLastTagWas(0);
            this.f33216a--;
            if (getBytesUntilLimit() == 0) {
                popLimit(pushLimit);
                return parsePartialFrom;
            }
            throw InvalidProtocolBufferException.n();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class IterableDirectByteBufferDecoder extends CodedInputStream {

        /* renamed from: g  reason: collision with root package name */
        private final Iterable<ByteBuffer> f33230g;

        /* renamed from: h  reason: collision with root package name */
        private final Iterator<ByteBuffer> f33231h;

        /* renamed from: i  reason: collision with root package name */
        private ByteBuffer f33232i;

        /* renamed from: j  reason: collision with root package name */
        private final boolean f33233j;

        /* renamed from: k  reason: collision with root package name */
        private boolean f33234k;

        /* renamed from: l  reason: collision with root package name */
        private int f33235l;

        /* renamed from: m  reason: collision with root package name */
        private int f33236m;

        /* renamed from: n  reason: collision with root package name */
        private int f33237n;

        /* renamed from: o  reason: collision with root package name */
        private int f33238o;

        /* renamed from: p  reason: collision with root package name */
        private int f33239p;

        /* renamed from: q  reason: collision with root package name */
        private int f33240q;

        /* renamed from: r  reason: collision with root package name */
        private long f33241r;

        /* renamed from: s  reason: collision with root package name */
        private long f33242s;

        /* renamed from: t  reason: collision with root package name */
        private long f33243t;

        /* renamed from: u  reason: collision with root package name */
        private long f33244u;

        private long d() {
            return this.f33244u - this.f33241r;
        }

        private void e() throws InvalidProtocolBufferException {
            if (this.f33231h.hasNext()) {
                l();
                return;
            }
            throw InvalidProtocolBufferException.n();
        }

        private void f(byte[] bArr, int i4, int i5) throws IOException {
            if (i5 >= 0 && i5 <= i()) {
                int i6 = i5;
                while (i6 > 0) {
                    if (d() == 0) {
                        e();
                    }
                    int min = Math.min(i6, (int) d());
                    long j4 = min;
                    UnsafeUtil.p(this.f33241r, bArr, (i5 - i6) + i4, j4);
                    i6 -= min;
                    this.f33241r += j4;
                }
            } else if (i5 <= 0) {
                if (i5 == 0) {
                    return;
                }
                throw InvalidProtocolBufferException.h();
            } else {
                throw InvalidProtocolBufferException.n();
            }
        }

        private void h() {
            int i4 = this.f33235l + this.f33236m;
            this.f33235l = i4;
            int i5 = i4 - this.f33240q;
            int i6 = this.f33237n;
            if (i5 > i6) {
                int i7 = i5 - i6;
                this.f33236m = i7;
                this.f33235l = i4 - i7;
                return;
            }
            this.f33236m = 0;
        }

        private int i() {
            return (int) (((this.f33235l - this.f33239p) - this.f33241r) + this.f33242s);
        }

        private void j() throws IOException {
            for (int i4 = 0; i4 < 10; i4++) {
                if (readRawByte() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.g();
        }

        private ByteBuffer k(int i4, int i5) throws IOException {
            int position = this.f33232i.position();
            int limit = this.f33232i.limit();
            ByteBuffer byteBuffer = this.f33232i;
            try {
                try {
                    byteBuffer.position(i4);
                    byteBuffer.limit(i5);
                    return this.f33232i.slice();
                } catch (IllegalArgumentException unused) {
                    throw InvalidProtocolBufferException.n();
                }
            } finally {
                byteBuffer.position(position);
                byteBuffer.limit(limit);
            }
        }

        private void l() {
            ByteBuffer next = this.f33231h.next();
            this.f33232i = next;
            this.f33239p += (int) (this.f33241r - this.f33242s);
            long position = next.position();
            this.f33241r = position;
            this.f33242s = position;
            this.f33244u = this.f33232i.limit();
            long k4 = UnsafeUtil.k(this.f33232i);
            this.f33243t = k4;
            this.f33241r += k4;
            this.f33242s += k4;
            this.f33244u += k4;
        }

        @Override // com.google.protobuf.CodedInputStream
        public void checkLastTagWas(int i4) throws InvalidProtocolBufferException {
            if (this.f33238o == i4) {
                return;
            }
            throw InvalidProtocolBufferException.b();
        }

        @Override // com.google.protobuf.CodedInputStream
        public void enableAliasing(boolean z3) {
            this.f33234k = z3;
        }

        long g() throws IOException {
            long j4 = 0;
            for (int i4 = 0; i4 < 64; i4 += 7) {
                byte readRawByte = readRawByte();
                j4 |= (readRawByte & Byte.MAX_VALUE) << i4;
                if ((readRawByte & 128) == 0) {
                    return j4;
                }
            }
            throw InvalidProtocolBufferException.g();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int getBytesUntilLimit() {
            int i4 = this.f33237n;
            if (i4 == Integer.MAX_VALUE) {
                return -1;
            }
            return i4 - getTotalBytesRead();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int getLastTag() {
            return this.f33238o;
        }

        @Override // com.google.protobuf.CodedInputStream
        public int getTotalBytesRead() {
            return (int) (((this.f33239p - this.f33240q) + this.f33241r) - this.f33242s);
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean isAtEnd() throws IOException {
            if ((this.f33239p + this.f33241r) - this.f33242s == this.f33235l) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.CodedInputStream
        public void popLimit(int i4) {
            this.f33237n = i4;
            h();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int pushLimit(int i4) throws InvalidProtocolBufferException {
            if (i4 >= 0) {
                int totalBytesRead = i4 + getTotalBytesRead();
                int i5 = this.f33237n;
                if (totalBytesRead <= i5) {
                    this.f33237n = totalBytesRead;
                    h();
                    return i5;
                }
                throw InvalidProtocolBufferException.n();
            }
            throw InvalidProtocolBufferException.h();
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean readBool() throws IOException {
            if (readRawVarint64() != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte[] readByteArray() throws IOException {
            return readRawBytes(readRawVarint32());
        }

        @Override // com.google.protobuf.CodedInputStream
        public ByteBuffer readByteBuffer() throws IOException {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0) {
                long j4 = readRawVarint32;
                if (j4 <= d()) {
                    if (!this.f33233j && this.f33234k) {
                        long j5 = this.f33241r + j4;
                        this.f33241r = j5;
                        long j6 = this.f33243t;
                        return k((int) ((j5 - j6) - j4), (int) (j5 - j6));
                    }
                    byte[] bArr = new byte[readRawVarint32];
                    UnsafeUtil.p(this.f33241r, bArr, 0L, j4);
                    this.f33241r += j4;
                    return ByteBuffer.wrap(bArr);
                }
            }
            if (readRawVarint32 > 0 && readRawVarint32 <= i()) {
                byte[] bArr2 = new byte[readRawVarint32];
                f(bArr2, 0, readRawVarint32);
                return ByteBuffer.wrap(bArr2);
            } else if (readRawVarint32 == 0) {
                return Internal.EMPTY_BYTE_BUFFER;
            } else {
                if (readRawVarint32 < 0) {
                    throw InvalidProtocolBufferException.h();
                }
                throw InvalidProtocolBufferException.n();
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public ByteString readBytes() throws IOException {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0) {
                long j4 = readRawVarint32;
                long j5 = this.f33244u;
                long j6 = this.f33241r;
                if (j4 <= j5 - j6) {
                    if (this.f33233j && this.f33234k) {
                        int i4 = (int) (j6 - this.f33243t);
                        ByteString u3 = ByteString.u(k(i4, readRawVarint32 + i4));
                        this.f33241r += j4;
                        return u3;
                    }
                    byte[] bArr = new byte[readRawVarint32];
                    UnsafeUtil.p(j6, bArr, 0L, j4);
                    this.f33241r += j4;
                    return ByteString.v(bArr);
                }
            }
            if (readRawVarint32 > 0 && readRawVarint32 <= i()) {
                if (this.f33233j && this.f33234k) {
                    ArrayList arrayList = new ArrayList();
                    while (readRawVarint32 > 0) {
                        if (d() == 0) {
                            e();
                        }
                        int min = Math.min(readRawVarint32, (int) d());
                        int i5 = (int) (this.f33241r - this.f33243t);
                        arrayList.add(ByteString.u(k(i5, i5 + min)));
                        readRawVarint32 -= min;
                        this.f33241r += min;
                    }
                    return ByteString.copyFrom(arrayList);
                }
                byte[] bArr2 = new byte[readRawVarint32];
                f(bArr2, 0, readRawVarint32);
                return ByteString.v(bArr2);
            } else if (readRawVarint32 == 0) {
                return ByteString.EMPTY;
            } else {
                if (readRawVarint32 < 0) {
                    throw InvalidProtocolBufferException.h();
                }
                throw InvalidProtocolBufferException.n();
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public double readDouble() throws IOException {
            return Double.longBitsToDouble(readRawLittleEndian64());
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readEnum() throws IOException {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public float readFloat() throws IOException {
            return Float.intBitsToFloat(readRawLittleEndian32());
        }

        @Override // com.google.protobuf.CodedInputStream
        public void readGroup(int i4, MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            checkRecursionLimit();
            this.f33216a++;
            builder.mergeFrom(this, extensionRegistryLite);
            checkLastTagWas(WireFormat.a(i4, 4));
            this.f33216a--;
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readInt32() throws IOException {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readInt64() throws IOException {
            return readRawVarint64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public void readMessage(MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int readRawVarint32 = readRawVarint32();
            checkRecursionLimit();
            int pushLimit = pushLimit(readRawVarint32);
            this.f33216a++;
            builder.mergeFrom(this, extensionRegistryLite);
            checkLastTagWas(0);
            this.f33216a--;
            if (getBytesUntilLimit() == 0) {
                popLimit(pushLimit);
                return;
            }
            throw InvalidProtocolBufferException.n();
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte readRawByte() throws IOException {
            if (d() == 0) {
                e();
            }
            long j4 = this.f33241r;
            this.f33241r = 1 + j4;
            return UnsafeUtil.x(j4);
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte[] readRawBytes(int i4) throws IOException {
            if (i4 >= 0) {
                long j4 = i4;
                if (j4 <= d()) {
                    byte[] bArr = new byte[i4];
                    UnsafeUtil.p(this.f33241r, bArr, 0L, j4);
                    this.f33241r += j4;
                    return bArr;
                }
            }
            if (i4 >= 0 && i4 <= i()) {
                byte[] bArr2 = new byte[i4];
                f(bArr2, 0, i4);
                return bArr2;
            } else if (i4 <= 0) {
                if (i4 == 0) {
                    return Internal.EMPTY_BYTE_ARRAY;
                }
                throw InvalidProtocolBufferException.h();
            } else {
                throw InvalidProtocolBufferException.n();
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readRawLittleEndian32() throws IOException {
            if (d() >= 4) {
                long j4 = this.f33241r;
                this.f33241r = 4 + j4;
                return ((UnsafeUtil.x(j4 + 3) & 255) << 24) | (UnsafeUtil.x(j4) & 255) | ((UnsafeUtil.x(1 + j4) & 255) << 8) | ((UnsafeUtil.x(2 + j4) & 255) << 16);
            }
            return (readRawByte() & 255) | ((readRawByte() & 255) << 8) | ((readRawByte() & 255) << 16) | ((readRawByte() & 255) << 24);
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readRawLittleEndian64() throws IOException {
            if (d() >= 8) {
                long j4 = this.f33241r;
                this.f33241r = 8 + j4;
                long x3 = (UnsafeUtil.x(j4) & 255) | ((UnsafeUtil.x(1 + j4) & 255) << 8);
                return ((UnsafeUtil.x(j4 + 7) & 255) << 56) | ((UnsafeUtil.x(2 + j4) & 255) << 16) | x3 | ((UnsafeUtil.x(3 + j4) & 255) << 24) | ((UnsafeUtil.x(4 + j4) & 255) << 32) | ((UnsafeUtil.x(5 + j4) & 255) << 40) | ((UnsafeUtil.x(6 + j4) & 255) << 48);
            }
            return (readRawByte() & 255) | ((readRawByte() & 255) << 8) | ((readRawByte() & 255) << 16) | ((readRawByte() & 255) << 24) | ((readRawByte() & 255) << 32) | ((readRawByte() & 255) << 40) | ((readRawByte() & 255) << 48) | ((readRawByte() & 255) << 56);
        }

        /* JADX WARN: Code restructure failed: missing block: B:33:0x0088, code lost:
            if (com.google.protobuf.UnsafeUtil.x(r4) < 0) goto L34;
         */
        @Override // com.google.protobuf.CodedInputStream
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public int readRawVarint32() throws java.io.IOException {
            /*
                r10 = this;
                long r0 = r10.f33241r
                long r2 = r10.f33244u
                int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
                if (r4 != 0) goto La
                goto L8a
            La:
                r2 = 1
                long r4 = r0 + r2
                byte r0 = com.google.protobuf.UnsafeUtil.x(r0)
                if (r0 < 0) goto L1a
                long r4 = r10.f33241r
                long r4 = r4 + r2
                r10.f33241r = r4
                return r0
            L1a:
                long r6 = r10.f33244u
                long r8 = r10.f33241r
                long r6 = r6 - r8
                r8 = 10
                int r1 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                if (r1 >= 0) goto L26
                goto L8a
            L26:
                long r6 = r4 + r2
                byte r1 = com.google.protobuf.UnsafeUtil.x(r4)
                int r1 = r1 << 7
                r0 = r0 ^ r1
                if (r0 >= 0) goto L34
                r0 = r0 ^ (-128(0xffffffffffffff80, float:NaN))
                goto L90
            L34:
                long r4 = r6 + r2
                byte r1 = com.google.protobuf.UnsafeUtil.x(r6)
                int r1 = r1 << 14
                r0 = r0 ^ r1
                if (r0 < 0) goto L43
                r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
            L41:
                r6 = r4
                goto L90
            L43:
                long r6 = r4 + r2
                byte r1 = com.google.protobuf.UnsafeUtil.x(r4)
                int r1 = r1 << 21
                r0 = r0 ^ r1
                if (r0 >= 0) goto L53
                r1 = -2080896(0xffffffffffe03f80, float:NaN)
                r0 = r0 ^ r1
                goto L90
            L53:
                long r4 = r6 + r2
                byte r1 = com.google.protobuf.UnsafeUtil.x(r6)
                int r6 = r1 << 28
                r0 = r0 ^ r6
                r6 = 266354560(0xfe03f80, float:2.2112565E-29)
                r0 = r0 ^ r6
                if (r1 >= 0) goto L41
                long r6 = r4 + r2
                byte r1 = com.google.protobuf.UnsafeUtil.x(r4)
                if (r1 >= 0) goto L90
                long r4 = r6 + r2
                byte r1 = com.google.protobuf.UnsafeUtil.x(r6)
                if (r1 >= 0) goto L41
                long r6 = r4 + r2
                byte r1 = com.google.protobuf.UnsafeUtil.x(r4)
                if (r1 >= 0) goto L90
                long r4 = r6 + r2
                byte r1 = com.google.protobuf.UnsafeUtil.x(r6)
                if (r1 >= 0) goto L41
                long r6 = r4 + r2
                byte r1 = com.google.protobuf.UnsafeUtil.x(r4)
                if (r1 >= 0) goto L90
            L8a:
                long r0 = r10.g()
                int r1 = (int) r0
                return r1
            L90:
                r10.f33241r = r6
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.CodedInputStream.IterableDirectByteBufferDecoder.readRawVarint32():int");
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readRawVarint64() throws IOException {
            long x3;
            long j4;
            long j5;
            int i4;
            long j6 = this.f33241r;
            if (this.f33244u != j6) {
                long j7 = j6 + 1;
                byte x4 = UnsafeUtil.x(j6);
                if (x4 >= 0) {
                    this.f33241r++;
                    return x4;
                } else if (this.f33244u - this.f33241r >= 10) {
                    long j8 = j7 + 1;
                    int x5 = x4 ^ (UnsafeUtil.x(j7) << 7);
                    if (x5 < 0) {
                        i4 = x5 ^ RangingPosition.RSSI_UNKNOWN;
                    } else {
                        long j9 = j8 + 1;
                        int x6 = x5 ^ (UnsafeUtil.x(j8) << Ascii.SO);
                        if (x6 >= 0) {
                            x3 = x6 ^ 16256;
                        } else {
                            j8 = j9 + 1;
                            int x7 = x6 ^ (UnsafeUtil.x(j9) << Ascii.NAK);
                            if (x7 < 0) {
                                i4 = x7 ^ (-2080896);
                            } else {
                                j9 = j8 + 1;
                                long x8 = x7 ^ (UnsafeUtil.x(j8) << 28);
                                if (x8 >= 0) {
                                    j5 = 266354560;
                                } else {
                                    long j10 = j9 + 1;
                                    long x9 = x8 ^ (UnsafeUtil.x(j9) << 35);
                                    if (x9 < 0) {
                                        j4 = -34093383808L;
                                    } else {
                                        j9 = j10 + 1;
                                        x8 = x9 ^ (UnsafeUtil.x(j10) << 42);
                                        if (x8 >= 0) {
                                            j5 = 4363953127296L;
                                        } else {
                                            j10 = j9 + 1;
                                            x9 = x8 ^ (UnsafeUtil.x(j9) << 49);
                                            if (x9 < 0) {
                                                j4 = -558586000294016L;
                                            } else {
                                                j9 = j10 + 1;
                                                x3 = (x9 ^ (UnsafeUtil.x(j10) << 56)) ^ 71499008037633920L;
                                                if (x3 < 0) {
                                                    long j11 = 1 + j9;
                                                    if (UnsafeUtil.x(j9) >= 0) {
                                                        j8 = j11;
                                                        this.f33241r = j8;
                                                        return x3;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    x3 = x9 ^ j4;
                                    j8 = j10;
                                    this.f33241r = j8;
                                    return x3;
                                }
                                x3 = x8 ^ j5;
                            }
                        }
                        j8 = j9;
                        this.f33241r = j8;
                        return x3;
                    }
                    x3 = i4;
                    this.f33241r = j8;
                    return x3;
                }
            }
            return g();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readSFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readSFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readSInt32() throws IOException {
            return CodedInputStream.decodeZigZag32(readRawVarint32());
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readSInt64() throws IOException {
            return CodedInputStream.decodeZigZag64(readRawVarint64());
        }

        @Override // com.google.protobuf.CodedInputStream
        public String readString() throws IOException {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0) {
                long j4 = readRawVarint32;
                long j5 = this.f33244u;
                long j6 = this.f33241r;
                if (j4 <= j5 - j6) {
                    byte[] bArr = new byte[readRawVarint32];
                    UnsafeUtil.p(j6, bArr, 0L, j4);
                    String str = new String(bArr, Internal.f33419b);
                    this.f33241r += j4;
                    return str;
                }
            }
            if (readRawVarint32 > 0 && readRawVarint32 <= i()) {
                byte[] bArr2 = new byte[readRawVarint32];
                f(bArr2, 0, readRawVarint32);
                return new String(bArr2, Internal.f33419b);
            } else if (readRawVarint32 == 0) {
                return "";
            } else {
                if (readRawVarint32 < 0) {
                    throw InvalidProtocolBufferException.h();
                }
                throw InvalidProtocolBufferException.n();
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public String readStringRequireUtf8() throws IOException {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0) {
                long j4 = readRawVarint32;
                long j5 = this.f33244u;
                long j6 = this.f33241r;
                if (j4 <= j5 - j6) {
                    String g4 = Utf8.g(this.f33232i, (int) (j6 - this.f33242s), readRawVarint32);
                    this.f33241r += j4;
                    return g4;
                }
            }
            if (readRawVarint32 >= 0 && readRawVarint32 <= i()) {
                byte[] bArr = new byte[readRawVarint32];
                f(bArr, 0, readRawVarint32);
                return Utf8.h(bArr, 0, readRawVarint32);
            } else if (readRawVarint32 == 0) {
                return "";
            } else {
                if (readRawVarint32 <= 0) {
                    throw InvalidProtocolBufferException.h();
                }
                throw InvalidProtocolBufferException.n();
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readTag() throws IOException {
            if (isAtEnd()) {
                this.f33238o = 0;
                return 0;
            }
            int readRawVarint32 = readRawVarint32();
            this.f33238o = readRawVarint32;
            if (WireFormat.getTagFieldNumber(readRawVarint32) != 0) {
                return this.f33238o;
            }
            throw InvalidProtocolBufferException.c();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readUInt32() throws IOException {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readUInt64() throws IOException {
            return readRawVarint64();
        }

        @Override // com.google.protobuf.CodedInputStream
        @Deprecated
        public void readUnknownGroup(int i4, MessageLite.Builder builder) throws IOException {
            readGroup(i4, builder, ExtensionRegistryLite.getEmptyRegistry());
        }

        @Override // com.google.protobuf.CodedInputStream
        public void resetSizeCounter() {
            this.f33240q = (int) ((this.f33239p + this.f33241r) - this.f33242s);
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean skipField(int i4) throws IOException {
            int tagWireType = WireFormat.getTagWireType(i4);
            if (tagWireType == 0) {
                j();
                return true;
            } else if (tagWireType == 1) {
                skipRawBytes(8);
                return true;
            } else if (tagWireType == 2) {
                skipRawBytes(readRawVarint32());
                return true;
            } else if (tagWireType == 3) {
                skipMessage();
                checkLastTagWas(WireFormat.a(WireFormat.getTagFieldNumber(i4), 4));
                return true;
            } else if (tagWireType != 4) {
                if (tagWireType == 5) {
                    skipRawBytes(4);
                    return true;
                }
                throw InvalidProtocolBufferException.f();
            } else {
                return false;
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public void skipMessage() throws IOException {
            int readTag;
            do {
                readTag = readTag();
                if (readTag == 0) {
                    return;
                }
            } while (skipField(readTag));
        }

        @Override // com.google.protobuf.CodedInputStream
        public void skipRawBytes(int i4) throws IOException {
            if (i4 >= 0 && i4 <= ((this.f33235l - this.f33239p) - this.f33241r) + this.f33242s) {
                while (i4 > 0) {
                    if (d() == 0) {
                        e();
                    }
                    int min = Math.min(i4, (int) d());
                    i4 -= min;
                    this.f33241r += min;
                }
            } else if (i4 < 0) {
                throw InvalidProtocolBufferException.h();
            } else {
                throw InvalidProtocolBufferException.n();
            }
        }

        private IterableDirectByteBufferDecoder(Iterable<ByteBuffer> iterable, int i4, boolean z3) {
            super();
            this.f33237n = Integer.MAX_VALUE;
            this.f33235l = i4;
            this.f33230g = iterable;
            this.f33231h = iterable.iterator();
            this.f33233j = z3;
            this.f33239p = 0;
            this.f33240q = 0;
            if (i4 == 0) {
                this.f33232i = Internal.EMPTY_BYTE_BUFFER;
                this.f33241r = 0L;
                this.f33242s = 0L;
                this.f33244u = 0L;
                this.f33243t = 0L;
                return;
            }
            l();
        }

        @Override // com.google.protobuf.CodedInputStream
        public void skipMessage(CodedOutputStream codedOutputStream) throws IOException {
            int readTag;
            do {
                readTag = readTag();
                if (readTag == 0) {
                    return;
                }
            } while (skipField(readTag, codedOutputStream));
        }

        @Override // com.google.protobuf.CodedInputStream
        public <T extends MessageLite> T readGroup(int i4, Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            checkRecursionLimit();
            this.f33216a++;
            T parsePartialFrom = parser.parsePartialFrom(this, extensionRegistryLite);
            checkLastTagWas(WireFormat.a(i4, 4));
            this.f33216a--;
            return parsePartialFrom;
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean skipField(int i4, CodedOutputStream codedOutputStream) throws IOException {
            int tagWireType = WireFormat.getTagWireType(i4);
            if (tagWireType == 0) {
                long readInt64 = readInt64();
                codedOutputStream.writeUInt32NoTag(i4);
                codedOutputStream.writeUInt64NoTag(readInt64);
                return true;
            } else if (tagWireType == 1) {
                long readRawLittleEndian64 = readRawLittleEndian64();
                codedOutputStream.writeUInt32NoTag(i4);
                codedOutputStream.writeFixed64NoTag(readRawLittleEndian64);
                return true;
            } else if (tagWireType == 2) {
                ByteString readBytes = readBytes();
                codedOutputStream.writeUInt32NoTag(i4);
                codedOutputStream.writeBytesNoTag(readBytes);
                return true;
            } else if (tagWireType == 3) {
                codedOutputStream.writeUInt32NoTag(i4);
                skipMessage(codedOutputStream);
                int a4 = WireFormat.a(WireFormat.getTagFieldNumber(i4), 4);
                checkLastTagWas(a4);
                codedOutputStream.writeUInt32NoTag(a4);
                return true;
            } else if (tagWireType != 4) {
                if (tagWireType == 5) {
                    int readRawLittleEndian32 = readRawLittleEndian32();
                    codedOutputStream.writeUInt32NoTag(i4);
                    codedOutputStream.writeFixed32NoTag(readRawLittleEndian32);
                    return true;
                }
                throw InvalidProtocolBufferException.f();
            } else {
                return false;
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public <T extends MessageLite> T readMessage(Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int readRawVarint32 = readRawVarint32();
            checkRecursionLimit();
            int pushLimit = pushLimit(readRawVarint32);
            this.f33216a++;
            T parsePartialFrom = parser.parsePartialFrom(this, extensionRegistryLite);
            checkLastTagWas(0);
            this.f33216a--;
            if (getBytesUntilLimit() == 0) {
                popLimit(pushLimit);
                return parsePartialFrom;
            }
            throw InvalidProtocolBufferException.n();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class StreamDecoder extends CodedInputStream {

        /* renamed from: g  reason: collision with root package name */
        private final InputStream f33245g;

        /* renamed from: h  reason: collision with root package name */
        private final byte[] f33246h;

        /* renamed from: i  reason: collision with root package name */
        private int f33247i;

        /* renamed from: j  reason: collision with root package name */
        private int f33248j;

        /* renamed from: k  reason: collision with root package name */
        private int f33249k;

        /* renamed from: l  reason: collision with root package name */
        private int f33250l;

        /* renamed from: m  reason: collision with root package name */
        private int f33251m;

        /* renamed from: n  reason: collision with root package name */
        private int f33252n;

        /* renamed from: o  reason: collision with root package name */
        private RefillCallback f33253o;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes6.dex */
        public interface RefillCallback {
            void onRefill();
        }

        /* loaded from: classes6.dex */
        private class SkippedDataSink implements RefillCallback {

            /* renamed from: a  reason: collision with root package name */
            private int f33254a;

            /* renamed from: b  reason: collision with root package name */
            private ByteArrayOutputStream f33255b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ StreamDecoder f33256c;

            @Override // com.google.protobuf.CodedInputStream.StreamDecoder.RefillCallback
            public void onRefill() {
                if (this.f33255b == null) {
                    this.f33255b = new ByteArrayOutputStream();
                }
                this.f33255b.write(this.f33256c.f33246h, this.f33254a, this.f33256c.f33249k - this.f33254a);
                this.f33254a = 0;
            }
        }

        private static int f(InputStream inputStream) throws IOException {
            try {
                return inputStream.available();
            } catch (InvalidProtocolBufferException e4) {
                e4.l();
                throw e4;
            }
        }

        private static int g(InputStream inputStream, byte[] bArr, int i4, int i5) throws IOException {
            try {
                return inputStream.read(bArr, i4, i5);
            } catch (InvalidProtocolBufferException e4) {
                e4.l();
                throw e4;
            }
        }

        private ByteString h(int i4) throws IOException {
            byte[] j4 = j(i4);
            if (j4 != null) {
                return ByteString.copyFrom(j4);
            }
            int i5 = this.f33249k;
            int i6 = this.f33247i;
            int i7 = i6 - i5;
            this.f33251m += i6;
            this.f33249k = 0;
            this.f33247i = 0;
            List<byte[]> k4 = k(i4 - i7);
            byte[] bArr = new byte[i4];
            System.arraycopy(this.f33246h, i5, bArr, 0, i7);
            for (byte[] bArr2 : k4) {
                System.arraycopy(bArr2, 0, bArr, i7, bArr2.length);
                i7 += bArr2.length;
            }
            return ByteString.v(bArr);
        }

        private byte[] i(int i4, boolean z3) throws IOException {
            byte[] j4 = j(i4);
            if (j4 != null) {
                if (z3) {
                    return (byte[]) j4.clone();
                }
                return j4;
            }
            int i5 = this.f33249k;
            int i6 = this.f33247i;
            int i7 = i6 - i5;
            this.f33251m += i6;
            this.f33249k = 0;
            this.f33247i = 0;
            List<byte[]> k4 = k(i4 - i7);
            byte[] bArr = new byte[i4];
            System.arraycopy(this.f33246h, i5, bArr, 0, i7);
            for (byte[] bArr2 : k4) {
                System.arraycopy(bArr2, 0, bArr, i7, bArr2.length);
                i7 += bArr2.length;
            }
            return bArr;
        }

        private byte[] j(int i4) throws IOException {
            if (i4 == 0) {
                return Internal.EMPTY_BYTE_ARRAY;
            }
            if (i4 >= 0) {
                int i5 = this.f33251m;
                int i6 = this.f33249k;
                int i7 = i5 + i6 + i4;
                if (i7 - this.f33218c <= 0) {
                    int i8 = this.f33252n;
                    if (i7 <= i8) {
                        int i9 = this.f33247i - i6;
                        int i10 = i4 - i9;
                        if (i10 >= 4096 && i10 > f(this.f33245g)) {
                            return null;
                        }
                        byte[] bArr = new byte[i4];
                        System.arraycopy(this.f33246h, this.f33249k, bArr, 0, i9);
                        this.f33251m += this.f33247i;
                        this.f33249k = 0;
                        this.f33247i = 0;
                        while (i9 < i4) {
                            int g4 = g(this.f33245g, bArr, i9, i4 - i9);
                            if (g4 != -1) {
                                this.f33251m += g4;
                                i9 += g4;
                            } else {
                                throw InvalidProtocolBufferException.n();
                            }
                        }
                        return bArr;
                    }
                    skipRawBytes((i8 - i5) - i6);
                    throw InvalidProtocolBufferException.n();
                }
                throw InvalidProtocolBufferException.m();
            }
            throw InvalidProtocolBufferException.h();
        }

        private List<byte[]> k(int i4) throws IOException {
            ArrayList arrayList = new ArrayList();
            while (i4 > 0) {
                int min = Math.min(i4, 4096);
                byte[] bArr = new byte[min];
                int i5 = 0;
                while (i5 < min) {
                    int read = this.f33245g.read(bArr, i5, min - i5);
                    if (read != -1) {
                        this.f33251m += read;
                        i5 += read;
                    } else {
                        throw InvalidProtocolBufferException.n();
                    }
                }
                i4 -= min;
                arrayList.add(bArr);
            }
            return arrayList;
        }

        private void m() {
            int i4 = this.f33247i + this.f33248j;
            this.f33247i = i4;
            int i5 = this.f33251m + i4;
            int i6 = this.f33252n;
            if (i5 > i6) {
                int i7 = i5 - i6;
                this.f33248j = i7;
                this.f33247i = i4 - i7;
                return;
            }
            this.f33248j = 0;
        }

        private void n(int i4) throws IOException {
            if (!t(i4)) {
                if (i4 > (this.f33218c - this.f33251m) - this.f33249k) {
                    throw InvalidProtocolBufferException.m();
                }
                throw InvalidProtocolBufferException.n();
            }
        }

        private static long o(InputStream inputStream, long j4) throws IOException {
            try {
                return inputStream.skip(j4);
            } catch (InvalidProtocolBufferException e4) {
                e4.l();
                throw e4;
            }
        }

        private void p(int i4) throws IOException {
            if (i4 >= 0) {
                int i5 = this.f33251m;
                int i6 = this.f33249k;
                int i7 = i5 + i6 + i4;
                int i8 = this.f33252n;
                if (i7 <= i8) {
                    int i9 = 0;
                    if (this.f33253o == null) {
                        this.f33251m = i5 + i6;
                        this.f33247i = 0;
                        this.f33249k = 0;
                        i9 = this.f33247i - i6;
                        while (i9 < i4) {
                            try {
                                long j4 = i4 - i9;
                                long o4 = o(this.f33245g, j4);
                                int i10 = (o4 > 0L ? 1 : (o4 == 0L ? 0 : -1));
                                if (i10 >= 0 && o4 <= j4) {
                                    if (i10 == 0) {
                                        break;
                                    }
                                    i9 += (int) o4;
                                } else {
                                    throw new IllegalStateException(this.f33245g.getClass() + "#skip returned invalid result: " + o4 + "\nThe InputStream implementation is buggy.");
                                }
                            } finally {
                                this.f33251m += i9;
                                m();
                            }
                        }
                    }
                    if (i9 < i4) {
                        int i11 = this.f33247i;
                        int i12 = i11 - this.f33249k;
                        this.f33249k = i11;
                        n(1);
                        while (true) {
                            int i13 = i4 - i12;
                            int i14 = this.f33247i;
                            if (i13 > i14) {
                                i12 += i14;
                                this.f33249k = i14;
                                n(1);
                            } else {
                                this.f33249k = i13;
                                return;
                            }
                        }
                    }
                } else {
                    skipRawBytes((i8 - i5) - i6);
                    throw InvalidProtocolBufferException.n();
                }
            } else {
                throw InvalidProtocolBufferException.h();
            }
        }

        private void q() throws IOException {
            if (this.f33247i - this.f33249k >= 10) {
                r();
            } else {
                s();
            }
        }

        private void r() throws IOException {
            for (int i4 = 0; i4 < 10; i4++) {
                byte[] bArr = this.f33246h;
                int i5 = this.f33249k;
                this.f33249k = i5 + 1;
                if (bArr[i5] >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.g();
        }

        private void s() throws IOException {
            for (int i4 = 0; i4 < 10; i4++) {
                if (readRawByte() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.g();
        }

        private boolean t(int i4) throws IOException {
            int i5 = this.f33249k;
            if (i5 + i4 > this.f33247i) {
                int i6 = this.f33218c;
                int i7 = this.f33251m;
                if (i4 > (i6 - i7) - i5 || i7 + i5 + i4 > this.f33252n) {
                    return false;
                }
                RefillCallback refillCallback = this.f33253o;
                if (refillCallback != null) {
                    refillCallback.onRefill();
                }
                int i8 = this.f33249k;
                if (i8 > 0) {
                    int i9 = this.f33247i;
                    if (i9 > i8) {
                        byte[] bArr = this.f33246h;
                        System.arraycopy(bArr, i8, bArr, 0, i9 - i8);
                    }
                    this.f33251m += i8;
                    this.f33247i -= i8;
                    this.f33249k = 0;
                }
                InputStream inputStream = this.f33245g;
                byte[] bArr2 = this.f33246h;
                int i10 = this.f33247i;
                int g4 = g(inputStream, bArr2, i10, Math.min(bArr2.length - i10, (this.f33218c - this.f33251m) - i10));
                if (g4 != 0 && g4 >= -1 && g4 <= this.f33246h.length) {
                    if (g4 <= 0) {
                        return false;
                    }
                    this.f33247i += g4;
                    m();
                    if (this.f33247i >= i4) {
                        return true;
                    }
                    return t(i4);
                }
                throw new IllegalStateException(this.f33245g.getClass() + "#read(byte[]) returned invalid result: " + g4 + "\nThe InputStream implementation is buggy.");
            }
            throw new IllegalStateException("refillBuffer() called when " + i4 + " bytes were already available in buffer");
        }

        @Override // com.google.protobuf.CodedInputStream
        public void checkLastTagWas(int i4) throws InvalidProtocolBufferException {
            if (this.f33250l == i4) {
                return;
            }
            throw InvalidProtocolBufferException.b();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int getBytesUntilLimit() {
            int i4 = this.f33252n;
            if (i4 == Integer.MAX_VALUE) {
                return -1;
            }
            return i4 - (this.f33251m + this.f33249k);
        }

        @Override // com.google.protobuf.CodedInputStream
        public int getLastTag() {
            return this.f33250l;
        }

        @Override // com.google.protobuf.CodedInputStream
        public int getTotalBytesRead() {
            return this.f33251m + this.f33249k;
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean isAtEnd() throws IOException {
            if (this.f33249k == this.f33247i && !t(1)) {
                return true;
            }
            return false;
        }

        long l() throws IOException {
            long j4 = 0;
            for (int i4 = 0; i4 < 64; i4 += 7) {
                byte readRawByte = readRawByte();
                j4 |= (readRawByte & Byte.MAX_VALUE) << i4;
                if ((readRawByte & 128) == 0) {
                    return j4;
                }
            }
            throw InvalidProtocolBufferException.g();
        }

        @Override // com.google.protobuf.CodedInputStream
        public void popLimit(int i4) {
            this.f33252n = i4;
            m();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int pushLimit(int i4) throws InvalidProtocolBufferException {
            if (i4 >= 0) {
                int i5 = i4 + this.f33251m + this.f33249k;
                int i6 = this.f33252n;
                if (i5 <= i6) {
                    this.f33252n = i5;
                    m();
                    return i6;
                }
                throw InvalidProtocolBufferException.n();
            }
            throw InvalidProtocolBufferException.h();
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean readBool() throws IOException {
            if (readRawVarint64() != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte[] readByteArray() throws IOException {
            int readRawVarint32 = readRawVarint32();
            int i4 = this.f33247i;
            int i5 = this.f33249k;
            if (readRawVarint32 <= i4 - i5 && readRawVarint32 > 0) {
                byte[] copyOfRange = Arrays.copyOfRange(this.f33246h, i5, i5 + readRawVarint32);
                this.f33249k += readRawVarint32;
                return copyOfRange;
            }
            return i(readRawVarint32, false);
        }

        @Override // com.google.protobuf.CodedInputStream
        public ByteBuffer readByteBuffer() throws IOException {
            int readRawVarint32 = readRawVarint32();
            int i4 = this.f33247i;
            int i5 = this.f33249k;
            if (readRawVarint32 <= i4 - i5 && readRawVarint32 > 0) {
                ByteBuffer wrap = ByteBuffer.wrap(Arrays.copyOfRange(this.f33246h, i5, i5 + readRawVarint32));
                this.f33249k += readRawVarint32;
                return wrap;
            } else if (readRawVarint32 == 0) {
                return Internal.EMPTY_BYTE_BUFFER;
            } else {
                return ByteBuffer.wrap(i(readRawVarint32, true));
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public ByteString readBytes() throws IOException {
            int readRawVarint32 = readRawVarint32();
            int i4 = this.f33247i;
            int i5 = this.f33249k;
            if (readRawVarint32 <= i4 - i5 && readRawVarint32 > 0) {
                ByteString copyFrom = ByteString.copyFrom(this.f33246h, i5, readRawVarint32);
                this.f33249k += readRawVarint32;
                return copyFrom;
            } else if (readRawVarint32 == 0) {
                return ByteString.EMPTY;
            } else {
                return h(readRawVarint32);
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public double readDouble() throws IOException {
            return Double.longBitsToDouble(readRawLittleEndian64());
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readEnum() throws IOException {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public float readFloat() throws IOException {
            return Float.intBitsToFloat(readRawLittleEndian32());
        }

        @Override // com.google.protobuf.CodedInputStream
        public void readGroup(int i4, MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            checkRecursionLimit();
            this.f33216a++;
            builder.mergeFrom(this, extensionRegistryLite);
            checkLastTagWas(WireFormat.a(i4, 4));
            this.f33216a--;
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readInt32() throws IOException {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readInt64() throws IOException {
            return readRawVarint64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public void readMessage(MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int readRawVarint32 = readRawVarint32();
            checkRecursionLimit();
            int pushLimit = pushLimit(readRawVarint32);
            this.f33216a++;
            builder.mergeFrom(this, extensionRegistryLite);
            checkLastTagWas(0);
            this.f33216a--;
            if (getBytesUntilLimit() == 0) {
                popLimit(pushLimit);
                return;
            }
            throw InvalidProtocolBufferException.n();
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte readRawByte() throws IOException {
            if (this.f33249k == this.f33247i) {
                n(1);
            }
            byte[] bArr = this.f33246h;
            int i4 = this.f33249k;
            this.f33249k = i4 + 1;
            return bArr[i4];
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte[] readRawBytes(int i4) throws IOException {
            int i5 = this.f33249k;
            if (i4 <= this.f33247i - i5 && i4 > 0) {
                int i6 = i4 + i5;
                this.f33249k = i6;
                return Arrays.copyOfRange(this.f33246h, i5, i6);
            }
            return i(i4, false);
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readRawLittleEndian32() throws IOException {
            int i4 = this.f33249k;
            if (this.f33247i - i4 < 4) {
                n(4);
                i4 = this.f33249k;
            }
            byte[] bArr = this.f33246h;
            this.f33249k = i4 + 4;
            return ((bArr[i4 + 3] & 255) << 24) | (bArr[i4] & 255) | ((bArr[i4 + 1] & 255) << 8) | ((bArr[i4 + 2] & 255) << 16);
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readRawLittleEndian64() throws IOException {
            int i4 = this.f33249k;
            if (this.f33247i - i4 < 8) {
                n(8);
                i4 = this.f33249k;
            }
            byte[] bArr = this.f33246h;
            this.f33249k = i4 + 8;
            return ((bArr[i4 + 7] & 255) << 56) | (bArr[i4] & 255) | ((bArr[i4 + 1] & 255) << 8) | ((bArr[i4 + 2] & 255) << 16) | ((bArr[i4 + 3] & 255) << 24) | ((bArr[i4 + 4] & 255) << 32) | ((bArr[i4 + 5] & 255) << 40) | ((bArr[i4 + 6] & 255) << 48);
        }

        /* JADX WARN: Code restructure failed: missing block: B:33:0x0068, code lost:
            if (r2[r3] < 0) goto L34;
         */
        @Override // com.google.protobuf.CodedInputStream
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public int readRawVarint32() throws java.io.IOException {
            /*
                r5 = this;
                int r0 = r5.f33249k
                int r1 = r5.f33247i
                if (r1 != r0) goto L7
                goto L6a
            L7:
                byte[] r2 = r5.f33246h
                int r3 = r0 + 1
                r0 = r2[r0]
                if (r0 < 0) goto L12
                r5.f33249k = r3
                return r0
            L12:
                int r1 = r1 - r3
                r4 = 9
                if (r1 >= r4) goto L18
                goto L6a
            L18:
                int r1 = r3 + 1
                r3 = r2[r3]
                int r3 = r3 << 7
                r0 = r0 ^ r3
                if (r0 >= 0) goto L24
                r0 = r0 ^ (-128(0xffffffffffffff80, float:NaN))
                goto L70
            L24:
                int r3 = r1 + 1
                r1 = r2[r1]
                int r1 = r1 << 14
                r0 = r0 ^ r1
                if (r0 < 0) goto L31
                r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
            L2f:
                r1 = r3
                goto L70
            L31:
                int r1 = r3 + 1
                r3 = r2[r3]
                int r3 = r3 << 21
                r0 = r0 ^ r3
                if (r0 >= 0) goto L3f
                r2 = -2080896(0xffffffffffe03f80, float:NaN)
                r0 = r0 ^ r2
                goto L70
            L3f:
                int r3 = r1 + 1
                r1 = r2[r1]
                int r4 = r1 << 28
                r0 = r0 ^ r4
                r4 = 266354560(0xfe03f80, float:2.2112565E-29)
                r0 = r0 ^ r4
                if (r1 >= 0) goto L2f
                int r1 = r3 + 1
                r3 = r2[r3]
                if (r3 >= 0) goto L70
                int r3 = r1 + 1
                r1 = r2[r1]
                if (r1 >= 0) goto L2f
                int r1 = r3 + 1
                r3 = r2[r3]
                if (r3 >= 0) goto L70
                int r3 = r1 + 1
                r1 = r2[r1]
                if (r1 >= 0) goto L2f
                int r1 = r3 + 1
                r2 = r2[r3]
                if (r2 >= 0) goto L70
            L6a:
                long r0 = r5.l()
                int r1 = (int) r0
                return r1
            L70:
                r5.f33249k = r1
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.CodedInputStream.StreamDecoder.readRawVarint32():int");
        }

        /* JADX WARN: Code restructure failed: missing block: B:39:0x00b4, code lost:
            if (r2[r0] < 0) goto L42;
         */
        @Override // com.google.protobuf.CodedInputStream
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public long readRawVarint64() throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 192
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.CodedInputStream.StreamDecoder.readRawVarint64():long");
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readSFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readSFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readSInt32() throws IOException {
            return CodedInputStream.decodeZigZag32(readRawVarint32());
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readSInt64() throws IOException {
            return CodedInputStream.decodeZigZag64(readRawVarint64());
        }

        @Override // com.google.protobuf.CodedInputStream
        public String readString() throws IOException {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0) {
                int i4 = this.f33247i;
                int i5 = this.f33249k;
                if (readRawVarint32 <= i4 - i5) {
                    String str = new String(this.f33246h, i5, readRawVarint32, Internal.f33419b);
                    this.f33249k += readRawVarint32;
                    return str;
                }
            }
            if (readRawVarint32 == 0) {
                return "";
            }
            if (readRawVarint32 <= this.f33247i) {
                n(readRawVarint32);
                String str2 = new String(this.f33246h, this.f33249k, readRawVarint32, Internal.f33419b);
                this.f33249k += readRawVarint32;
                return str2;
            }
            return new String(i(readRawVarint32, false), Internal.f33419b);
        }

        @Override // com.google.protobuf.CodedInputStream
        public String readStringRequireUtf8() throws IOException {
            byte[] i4;
            int readRawVarint32 = readRawVarint32();
            int i5 = this.f33249k;
            int i6 = this.f33247i;
            if (readRawVarint32 <= i6 - i5 && readRawVarint32 > 0) {
                i4 = this.f33246h;
                this.f33249k = i5 + readRawVarint32;
            } else if (readRawVarint32 == 0) {
                return "";
            } else {
                i5 = 0;
                if (readRawVarint32 <= i6) {
                    n(readRawVarint32);
                    i4 = this.f33246h;
                    this.f33249k = readRawVarint32 + 0;
                } else {
                    i4 = i(readRawVarint32, false);
                }
            }
            return Utf8.h(i4, i5, readRawVarint32);
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readTag() throws IOException {
            if (isAtEnd()) {
                this.f33250l = 0;
                return 0;
            }
            int readRawVarint32 = readRawVarint32();
            this.f33250l = readRawVarint32;
            if (WireFormat.getTagFieldNumber(readRawVarint32) != 0) {
                return this.f33250l;
            }
            throw InvalidProtocolBufferException.c();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readUInt32() throws IOException {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readUInt64() throws IOException {
            return readRawVarint64();
        }

        @Override // com.google.protobuf.CodedInputStream
        @Deprecated
        public void readUnknownGroup(int i4, MessageLite.Builder builder) throws IOException {
            readGroup(i4, builder, ExtensionRegistryLite.getEmptyRegistry());
        }

        @Override // com.google.protobuf.CodedInputStream
        public void resetSizeCounter() {
            this.f33251m = -this.f33249k;
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean skipField(int i4) throws IOException {
            int tagWireType = WireFormat.getTagWireType(i4);
            if (tagWireType == 0) {
                q();
                return true;
            } else if (tagWireType == 1) {
                skipRawBytes(8);
                return true;
            } else if (tagWireType == 2) {
                skipRawBytes(readRawVarint32());
                return true;
            } else if (tagWireType == 3) {
                skipMessage();
                checkLastTagWas(WireFormat.a(WireFormat.getTagFieldNumber(i4), 4));
                return true;
            } else if (tagWireType != 4) {
                if (tagWireType == 5) {
                    skipRawBytes(4);
                    return true;
                }
                throw InvalidProtocolBufferException.f();
            } else {
                return false;
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public void skipMessage() throws IOException {
            int readTag;
            do {
                readTag = readTag();
                if (readTag == 0) {
                    return;
                }
            } while (skipField(readTag));
        }

        @Override // com.google.protobuf.CodedInputStream
        public void skipRawBytes(int i4) throws IOException {
            int i5 = this.f33247i;
            int i6 = this.f33249k;
            if (i4 <= i5 - i6 && i4 >= 0) {
                this.f33249k = i6 + i4;
            } else {
                p(i4);
            }
        }

        private StreamDecoder(InputStream inputStream, int i4) {
            super();
            this.f33252n = Integer.MAX_VALUE;
            this.f33253o = null;
            Internal.b(inputStream, "input");
            this.f33245g = inputStream;
            this.f33246h = new byte[i4];
            this.f33247i = 0;
            this.f33249k = 0;
            this.f33251m = 0;
        }

        @Override // com.google.protobuf.CodedInputStream
        public void skipMessage(CodedOutputStream codedOutputStream) throws IOException {
            int readTag;
            do {
                readTag = readTag();
                if (readTag == 0) {
                    return;
                }
            } while (skipField(readTag, codedOutputStream));
        }

        @Override // com.google.protobuf.CodedInputStream
        public <T extends MessageLite> T readGroup(int i4, Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            checkRecursionLimit();
            this.f33216a++;
            T parsePartialFrom = parser.parsePartialFrom(this, extensionRegistryLite);
            checkLastTagWas(WireFormat.a(i4, 4));
            this.f33216a--;
            return parsePartialFrom;
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean skipField(int i4, CodedOutputStream codedOutputStream) throws IOException {
            int tagWireType = WireFormat.getTagWireType(i4);
            if (tagWireType == 0) {
                long readInt64 = readInt64();
                codedOutputStream.writeUInt32NoTag(i4);
                codedOutputStream.writeUInt64NoTag(readInt64);
                return true;
            } else if (tagWireType == 1) {
                long readRawLittleEndian64 = readRawLittleEndian64();
                codedOutputStream.writeUInt32NoTag(i4);
                codedOutputStream.writeFixed64NoTag(readRawLittleEndian64);
                return true;
            } else if (tagWireType == 2) {
                ByteString readBytes = readBytes();
                codedOutputStream.writeUInt32NoTag(i4);
                codedOutputStream.writeBytesNoTag(readBytes);
                return true;
            } else if (tagWireType == 3) {
                codedOutputStream.writeUInt32NoTag(i4);
                skipMessage(codedOutputStream);
                int a4 = WireFormat.a(WireFormat.getTagFieldNumber(i4), 4);
                checkLastTagWas(a4);
                codedOutputStream.writeUInt32NoTag(a4);
                return true;
            } else if (tagWireType != 4) {
                if (tagWireType == 5) {
                    int readRawLittleEndian32 = readRawLittleEndian32();
                    codedOutputStream.writeUInt32NoTag(i4);
                    codedOutputStream.writeFixed32NoTag(readRawLittleEndian32);
                    return true;
                }
                throw InvalidProtocolBufferException.f();
            } else {
                return false;
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public <T extends MessageLite> T readMessage(Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int readRawVarint32 = readRawVarint32();
            checkRecursionLimit();
            int pushLimit = pushLimit(readRawVarint32);
            this.f33216a++;
            T parsePartialFrom = parser.parsePartialFrom(this, extensionRegistryLite);
            checkLastTagWas(0);
            this.f33216a--;
            if (getBytesUntilLimit() == 0) {
                popLimit(pushLimit);
                return parsePartialFrom;
            }
            throw InvalidProtocolBufferException.n();
        }

        @Override // com.google.protobuf.CodedInputStream
        public void enableAliasing(boolean z3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class UnsafeDirectNioDecoder extends CodedInputStream {

        /* renamed from: g  reason: collision with root package name */
        private final ByteBuffer f33257g;

        /* renamed from: h  reason: collision with root package name */
        private final boolean f33258h;

        /* renamed from: i  reason: collision with root package name */
        private final long f33259i;

        /* renamed from: j  reason: collision with root package name */
        private long f33260j;

        /* renamed from: k  reason: collision with root package name */
        private long f33261k;

        /* renamed from: l  reason: collision with root package name */
        private long f33262l;

        /* renamed from: m  reason: collision with root package name */
        private int f33263m;

        /* renamed from: n  reason: collision with root package name */
        private int f33264n;

        /* renamed from: o  reason: collision with root package name */
        private boolean f33265o;

        /* renamed from: p  reason: collision with root package name */
        private int f33266p;

        private int d(long j4) {
            return (int) (j4 - this.f33259i);
        }

        static boolean e() {
            return UnsafeUtil.K();
        }

        private void g() {
            long j4 = this.f33260j + this.f33263m;
            this.f33260j = j4;
            int i4 = (int) (j4 - this.f33262l);
            int i5 = this.f33266p;
            if (i4 > i5) {
                int i6 = i4 - i5;
                this.f33263m = i6;
                this.f33260j = j4 - i6;
                return;
            }
            this.f33263m = 0;
        }

        private int h() {
            return (int) (this.f33260j - this.f33261k);
        }

        private void i() throws IOException {
            if (h() >= 10) {
                j();
            } else {
                k();
            }
        }

        private void j() throws IOException {
            for (int i4 = 0; i4 < 10; i4++) {
                long j4 = this.f33261k;
                this.f33261k = 1 + j4;
                if (UnsafeUtil.x(j4) >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.g();
        }

        private void k() throws IOException {
            for (int i4 = 0; i4 < 10; i4++) {
                if (readRawByte() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.g();
        }

        private ByteBuffer l(long j4, long j5) throws IOException {
            int position = this.f33257g.position();
            int limit = this.f33257g.limit();
            ByteBuffer byteBuffer = this.f33257g;
            try {
                try {
                    byteBuffer.position(d(j4));
                    byteBuffer.limit(d(j5));
                    return this.f33257g.slice();
                } catch (IllegalArgumentException e4) {
                    InvalidProtocolBufferException n4 = InvalidProtocolBufferException.n();
                    n4.initCause(e4);
                    throw n4;
                }
            } finally {
                byteBuffer.position(position);
                byteBuffer.limit(limit);
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public void checkLastTagWas(int i4) throws InvalidProtocolBufferException {
            if (this.f33264n == i4) {
                return;
            }
            throw InvalidProtocolBufferException.b();
        }

        @Override // com.google.protobuf.CodedInputStream
        public void enableAliasing(boolean z3) {
            this.f33265o = z3;
        }

        long f() throws IOException {
            long j4 = 0;
            for (int i4 = 0; i4 < 64; i4 += 7) {
                byte readRawByte = readRawByte();
                j4 |= (readRawByte & Byte.MAX_VALUE) << i4;
                if ((readRawByte & 128) == 0) {
                    return j4;
                }
            }
            throw InvalidProtocolBufferException.g();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int getBytesUntilLimit() {
            int i4 = this.f33266p;
            if (i4 == Integer.MAX_VALUE) {
                return -1;
            }
            return i4 - getTotalBytesRead();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int getLastTag() {
            return this.f33264n;
        }

        @Override // com.google.protobuf.CodedInputStream
        public int getTotalBytesRead() {
            return (int) (this.f33261k - this.f33262l);
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean isAtEnd() throws IOException {
            if (this.f33261k == this.f33260j) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.CodedInputStream
        public void popLimit(int i4) {
            this.f33266p = i4;
            g();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int pushLimit(int i4) throws InvalidProtocolBufferException {
            if (i4 >= 0) {
                int totalBytesRead = i4 + getTotalBytesRead();
                int i5 = this.f33266p;
                if (totalBytesRead <= i5) {
                    this.f33266p = totalBytesRead;
                    g();
                    return i5;
                }
                throw InvalidProtocolBufferException.n();
            }
            throw InvalidProtocolBufferException.h();
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean readBool() throws IOException {
            if (readRawVarint64() != 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte[] readByteArray() throws IOException {
            return readRawBytes(readRawVarint32());
        }

        @Override // com.google.protobuf.CodedInputStream
        public ByteBuffer readByteBuffer() throws IOException {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0 && readRawVarint32 <= h()) {
                if (!this.f33258h && this.f33265o) {
                    long j4 = this.f33261k;
                    long j5 = readRawVarint32;
                    ByteBuffer l4 = l(j4, j4 + j5);
                    this.f33261k += j5;
                    return l4;
                }
                byte[] bArr = new byte[readRawVarint32];
                long j6 = readRawVarint32;
                UnsafeUtil.p(this.f33261k, bArr, 0L, j6);
                this.f33261k += j6;
                return ByteBuffer.wrap(bArr);
            } else if (readRawVarint32 == 0) {
                return Internal.EMPTY_BYTE_BUFFER;
            } else {
                if (readRawVarint32 < 0) {
                    throw InvalidProtocolBufferException.h();
                }
                throw InvalidProtocolBufferException.n();
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public ByteString readBytes() throws IOException {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0 && readRawVarint32 <= h()) {
                if (this.f33258h && this.f33265o) {
                    long j4 = this.f33261k;
                    long j5 = readRawVarint32;
                    ByteBuffer l4 = l(j4, j4 + j5);
                    this.f33261k += j5;
                    return ByteString.u(l4);
                }
                byte[] bArr = new byte[readRawVarint32];
                long j6 = readRawVarint32;
                UnsafeUtil.p(this.f33261k, bArr, 0L, j6);
                this.f33261k += j6;
                return ByteString.v(bArr);
            } else if (readRawVarint32 == 0) {
                return ByteString.EMPTY;
            } else {
                if (readRawVarint32 < 0) {
                    throw InvalidProtocolBufferException.h();
                }
                throw InvalidProtocolBufferException.n();
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public double readDouble() throws IOException {
            return Double.longBitsToDouble(readRawLittleEndian64());
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readEnum() throws IOException {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public float readFloat() throws IOException {
            return Float.intBitsToFloat(readRawLittleEndian32());
        }

        @Override // com.google.protobuf.CodedInputStream
        public void readGroup(int i4, MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            checkRecursionLimit();
            this.f33216a++;
            builder.mergeFrom(this, extensionRegistryLite);
            checkLastTagWas(WireFormat.a(i4, 4));
            this.f33216a--;
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readInt32() throws IOException {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readInt64() throws IOException {
            return readRawVarint64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public void readMessage(MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int readRawVarint32 = readRawVarint32();
            checkRecursionLimit();
            int pushLimit = pushLimit(readRawVarint32);
            this.f33216a++;
            builder.mergeFrom(this, extensionRegistryLite);
            checkLastTagWas(0);
            this.f33216a--;
            if (getBytesUntilLimit() == 0) {
                popLimit(pushLimit);
                return;
            }
            throw InvalidProtocolBufferException.n();
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte readRawByte() throws IOException {
            long j4 = this.f33261k;
            if (j4 != this.f33260j) {
                this.f33261k = 1 + j4;
                return UnsafeUtil.x(j4);
            }
            throw InvalidProtocolBufferException.n();
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte[] readRawBytes(int i4) throws IOException {
            if (i4 >= 0 && i4 <= h()) {
                byte[] bArr = new byte[i4];
                long j4 = this.f33261k;
                long j5 = i4;
                l(j4, j4 + j5).get(bArr);
                this.f33261k += j5;
                return bArr;
            } else if (i4 <= 0) {
                if (i4 == 0) {
                    return Internal.EMPTY_BYTE_ARRAY;
                }
                throw InvalidProtocolBufferException.h();
            } else {
                throw InvalidProtocolBufferException.n();
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readRawLittleEndian32() throws IOException {
            long j4 = this.f33261k;
            if (this.f33260j - j4 >= 4) {
                this.f33261k = 4 + j4;
                return ((UnsafeUtil.x(j4 + 3) & 255) << 24) | (UnsafeUtil.x(j4) & 255) | ((UnsafeUtil.x(1 + j4) & 255) << 8) | ((UnsafeUtil.x(2 + j4) & 255) << 16);
            }
            throw InvalidProtocolBufferException.n();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readRawLittleEndian64() throws IOException {
            long j4 = this.f33261k;
            if (this.f33260j - j4 >= 8) {
                this.f33261k = 8 + j4;
                return ((UnsafeUtil.x(j4 + 7) & 255) << 56) | (UnsafeUtil.x(j4) & 255) | ((UnsafeUtil.x(1 + j4) & 255) << 8) | ((UnsafeUtil.x(2 + j4) & 255) << 16) | ((UnsafeUtil.x(3 + j4) & 255) << 24) | ((UnsafeUtil.x(4 + j4) & 255) << 32) | ((UnsafeUtil.x(5 + j4) & 255) << 40) | ((UnsafeUtil.x(6 + j4) & 255) << 48);
            }
            throw InvalidProtocolBufferException.n();
        }

        /* JADX WARN: Code restructure failed: missing block: B:33:0x0083, code lost:
            if (com.google.protobuf.UnsafeUtil.x(r4) < 0) goto L34;
         */
        @Override // com.google.protobuf.CodedInputStream
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public int readRawVarint32() throws java.io.IOException {
            /*
                r10 = this;
                long r0 = r10.f33261k
                long r2 = r10.f33260j
                int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
                if (r4 != 0) goto La
                goto L85
            La:
                r2 = 1
                long r4 = r0 + r2
                byte r0 = com.google.protobuf.UnsafeUtil.x(r0)
                if (r0 < 0) goto L17
                r10.f33261k = r4
                return r0
            L17:
                long r6 = r10.f33260j
                long r6 = r6 - r4
                r8 = 9
                int r1 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                if (r1 >= 0) goto L21
                goto L85
            L21:
                long r6 = r4 + r2
                byte r1 = com.google.protobuf.UnsafeUtil.x(r4)
                int r1 = r1 << 7
                r0 = r0 ^ r1
                if (r0 >= 0) goto L2f
                r0 = r0 ^ (-128(0xffffffffffffff80, float:NaN))
                goto L8b
            L2f:
                long r4 = r6 + r2
                byte r1 = com.google.protobuf.UnsafeUtil.x(r6)
                int r1 = r1 << 14
                r0 = r0 ^ r1
                if (r0 < 0) goto L3e
                r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
            L3c:
                r6 = r4
                goto L8b
            L3e:
                long r6 = r4 + r2
                byte r1 = com.google.protobuf.UnsafeUtil.x(r4)
                int r1 = r1 << 21
                r0 = r0 ^ r1
                if (r0 >= 0) goto L4e
                r1 = -2080896(0xffffffffffe03f80, float:NaN)
                r0 = r0 ^ r1
                goto L8b
            L4e:
                long r4 = r6 + r2
                byte r1 = com.google.protobuf.UnsafeUtil.x(r6)
                int r6 = r1 << 28
                r0 = r0 ^ r6
                r6 = 266354560(0xfe03f80, float:2.2112565E-29)
                r0 = r0 ^ r6
                if (r1 >= 0) goto L3c
                long r6 = r4 + r2
                byte r1 = com.google.protobuf.UnsafeUtil.x(r4)
                if (r1 >= 0) goto L8b
                long r4 = r6 + r2
                byte r1 = com.google.protobuf.UnsafeUtil.x(r6)
                if (r1 >= 0) goto L3c
                long r6 = r4 + r2
                byte r1 = com.google.protobuf.UnsafeUtil.x(r4)
                if (r1 >= 0) goto L8b
                long r4 = r6 + r2
                byte r1 = com.google.protobuf.UnsafeUtil.x(r6)
                if (r1 >= 0) goto L3c
                long r6 = r4 + r2
                byte r1 = com.google.protobuf.UnsafeUtil.x(r4)
                if (r1 >= 0) goto L8b
            L85:
                long r0 = r10.f()
                int r1 = (int) r0
                return r1
            L8b:
                r10.f33261k = r6
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.CodedInputStream.UnsafeDirectNioDecoder.readRawVarint32():int");
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readRawVarint64() throws IOException {
            long x3;
            long j4;
            long j5;
            int i4;
            long j6 = this.f33261k;
            if (this.f33260j != j6) {
                long j7 = j6 + 1;
                byte x4 = UnsafeUtil.x(j6);
                if (x4 >= 0) {
                    this.f33261k = j7;
                    return x4;
                } else if (this.f33260j - j7 >= 9) {
                    long j8 = j7 + 1;
                    int x5 = x4 ^ (UnsafeUtil.x(j7) << 7);
                    if (x5 < 0) {
                        i4 = x5 ^ RangingPosition.RSSI_UNKNOWN;
                    } else {
                        long j9 = j8 + 1;
                        int x6 = x5 ^ (UnsafeUtil.x(j8) << Ascii.SO);
                        if (x6 >= 0) {
                            x3 = x6 ^ 16256;
                        } else {
                            j8 = j9 + 1;
                            int x7 = x6 ^ (UnsafeUtil.x(j9) << Ascii.NAK);
                            if (x7 < 0) {
                                i4 = x7 ^ (-2080896);
                            } else {
                                j9 = j8 + 1;
                                long x8 = x7 ^ (UnsafeUtil.x(j8) << 28);
                                if (x8 >= 0) {
                                    j5 = 266354560;
                                } else {
                                    long j10 = j9 + 1;
                                    long x9 = x8 ^ (UnsafeUtil.x(j9) << 35);
                                    if (x9 < 0) {
                                        j4 = -34093383808L;
                                    } else {
                                        j9 = j10 + 1;
                                        x8 = x9 ^ (UnsafeUtil.x(j10) << 42);
                                        if (x8 >= 0) {
                                            j5 = 4363953127296L;
                                        } else {
                                            j10 = j9 + 1;
                                            x9 = x8 ^ (UnsafeUtil.x(j9) << 49);
                                            if (x9 < 0) {
                                                j4 = -558586000294016L;
                                            } else {
                                                j9 = j10 + 1;
                                                x3 = (x9 ^ (UnsafeUtil.x(j10) << 56)) ^ 71499008037633920L;
                                                if (x3 < 0) {
                                                    long j11 = 1 + j9;
                                                    if (UnsafeUtil.x(j9) >= 0) {
                                                        j8 = j11;
                                                        this.f33261k = j8;
                                                        return x3;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    x3 = x9 ^ j4;
                                    j8 = j10;
                                    this.f33261k = j8;
                                    return x3;
                                }
                                x3 = x8 ^ j5;
                            }
                        }
                        j8 = j9;
                        this.f33261k = j8;
                        return x3;
                    }
                    x3 = i4;
                    this.f33261k = j8;
                    return x3;
                }
            }
            return f();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readSFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readSFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readSInt32() throws IOException {
            return CodedInputStream.decodeZigZag32(readRawVarint32());
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readSInt64() throws IOException {
            return CodedInputStream.decodeZigZag64(readRawVarint64());
        }

        @Override // com.google.protobuf.CodedInputStream
        public String readString() throws IOException {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0 && readRawVarint32 <= h()) {
                byte[] bArr = new byte[readRawVarint32];
                long j4 = readRawVarint32;
                UnsafeUtil.p(this.f33261k, bArr, 0L, j4);
                String str = new String(bArr, Internal.f33419b);
                this.f33261k += j4;
                return str;
            } else if (readRawVarint32 == 0) {
                return "";
            } else {
                if (readRawVarint32 < 0) {
                    throw InvalidProtocolBufferException.h();
                }
                throw InvalidProtocolBufferException.n();
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public String readStringRequireUtf8() throws IOException {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0 && readRawVarint32 <= h()) {
                String g4 = Utf8.g(this.f33257g, d(this.f33261k), readRawVarint32);
                this.f33261k += readRawVarint32;
                return g4;
            } else if (readRawVarint32 == 0) {
                return "";
            } else {
                if (readRawVarint32 <= 0) {
                    throw InvalidProtocolBufferException.h();
                }
                throw InvalidProtocolBufferException.n();
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readTag() throws IOException {
            if (isAtEnd()) {
                this.f33264n = 0;
                return 0;
            }
            int readRawVarint32 = readRawVarint32();
            this.f33264n = readRawVarint32;
            if (WireFormat.getTagFieldNumber(readRawVarint32) != 0) {
                return this.f33264n;
            }
            throw InvalidProtocolBufferException.c();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readUInt32() throws IOException {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readUInt64() throws IOException {
            return readRawVarint64();
        }

        @Override // com.google.protobuf.CodedInputStream
        @Deprecated
        public void readUnknownGroup(int i4, MessageLite.Builder builder) throws IOException {
            readGroup(i4, builder, ExtensionRegistryLite.getEmptyRegistry());
        }

        @Override // com.google.protobuf.CodedInputStream
        public void resetSizeCounter() {
            this.f33262l = this.f33261k;
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean skipField(int i4) throws IOException {
            int tagWireType = WireFormat.getTagWireType(i4);
            if (tagWireType == 0) {
                i();
                return true;
            } else if (tagWireType == 1) {
                skipRawBytes(8);
                return true;
            } else if (tagWireType == 2) {
                skipRawBytes(readRawVarint32());
                return true;
            } else if (tagWireType == 3) {
                skipMessage();
                checkLastTagWas(WireFormat.a(WireFormat.getTagFieldNumber(i4), 4));
                return true;
            } else if (tagWireType != 4) {
                if (tagWireType == 5) {
                    skipRawBytes(4);
                    return true;
                }
                throw InvalidProtocolBufferException.f();
            } else {
                return false;
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public void skipMessage() throws IOException {
            int readTag;
            do {
                readTag = readTag();
                if (readTag == 0) {
                    return;
                }
            } while (skipField(readTag));
        }

        @Override // com.google.protobuf.CodedInputStream
        public void skipRawBytes(int i4) throws IOException {
            if (i4 >= 0 && i4 <= h()) {
                this.f33261k += i4;
            } else if (i4 < 0) {
                throw InvalidProtocolBufferException.h();
            } else {
                throw InvalidProtocolBufferException.n();
            }
        }

        private UnsafeDirectNioDecoder(ByteBuffer byteBuffer, boolean z3) {
            super();
            this.f33266p = Integer.MAX_VALUE;
            this.f33257g = byteBuffer;
            long k4 = UnsafeUtil.k(byteBuffer);
            this.f33259i = k4;
            this.f33260j = byteBuffer.limit() + k4;
            long position = k4 + byteBuffer.position();
            this.f33261k = position;
            this.f33262l = position;
            this.f33258h = z3;
        }

        @Override // com.google.protobuf.CodedInputStream
        public void skipMessage(CodedOutputStream codedOutputStream) throws IOException {
            int readTag;
            do {
                readTag = readTag();
                if (readTag == 0) {
                    return;
                }
            } while (skipField(readTag, codedOutputStream));
        }

        @Override // com.google.protobuf.CodedInputStream
        public <T extends MessageLite> T readGroup(int i4, Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            checkRecursionLimit();
            this.f33216a++;
            T parsePartialFrom = parser.parsePartialFrom(this, extensionRegistryLite);
            checkLastTagWas(WireFormat.a(i4, 4));
            this.f33216a--;
            return parsePartialFrom;
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean skipField(int i4, CodedOutputStream codedOutputStream) throws IOException {
            int tagWireType = WireFormat.getTagWireType(i4);
            if (tagWireType == 0) {
                long readInt64 = readInt64();
                codedOutputStream.writeUInt32NoTag(i4);
                codedOutputStream.writeUInt64NoTag(readInt64);
                return true;
            } else if (tagWireType == 1) {
                long readRawLittleEndian64 = readRawLittleEndian64();
                codedOutputStream.writeUInt32NoTag(i4);
                codedOutputStream.writeFixed64NoTag(readRawLittleEndian64);
                return true;
            } else if (tagWireType == 2) {
                ByteString readBytes = readBytes();
                codedOutputStream.writeUInt32NoTag(i4);
                codedOutputStream.writeBytesNoTag(readBytes);
                return true;
            } else if (tagWireType == 3) {
                codedOutputStream.writeUInt32NoTag(i4);
                skipMessage(codedOutputStream);
                int a4 = WireFormat.a(WireFormat.getTagFieldNumber(i4), 4);
                checkLastTagWas(a4);
                codedOutputStream.writeUInt32NoTag(a4);
                return true;
            } else if (tagWireType != 4) {
                if (tagWireType == 5) {
                    int readRawLittleEndian32 = readRawLittleEndian32();
                    codedOutputStream.writeUInt32NoTag(i4);
                    codedOutputStream.writeFixed32NoTag(readRawLittleEndian32);
                    return true;
                }
                throw InvalidProtocolBufferException.f();
            } else {
                return false;
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public <T extends MessageLite> T readMessage(Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int readRawVarint32 = readRawVarint32();
            checkRecursionLimit();
            int pushLimit = pushLimit(readRawVarint32);
            this.f33216a++;
            T parsePartialFrom = parser.parsePartialFrom(this, extensionRegistryLite);
            checkLastTagWas(0);
            this.f33216a--;
            if (getBytesUntilLimit() == 0) {
                popLimit(pushLimit);
                return parsePartialFrom;
            }
            throw InvalidProtocolBufferException.n();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static CodedInputStream a(Iterable<ByteBuffer> iterable, boolean z3) {
        boolean z4 = false;
        int i4 = 0;
        for (ByteBuffer byteBuffer : iterable) {
            i4 += byteBuffer.remaining();
            if (byteBuffer.hasArray()) {
                z4 |= true;
            } else if (byteBuffer.isDirect()) {
                z4 |= true;
            } else {
                z4 |= true;
            }
        }
        if (z4) {
            return new IterableDirectByteBufferDecoder(iterable, i4, z3);
        }
        return newInstance(new IterableByteBufferInputStream(iterable));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static CodedInputStream b(ByteBuffer byteBuffer, boolean z3) {
        if (byteBuffer.hasArray()) {
            return c(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining(), z3);
        }
        if (byteBuffer.isDirect() && UnsafeDirectNioDecoder.e()) {
            return new UnsafeDirectNioDecoder(byteBuffer, z3);
        }
        int remaining = byteBuffer.remaining();
        byte[] bArr = new byte[remaining];
        byteBuffer.duplicate().get(bArr);
        return c(bArr, 0, remaining, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static CodedInputStream c(byte[] bArr, int i4, int i5, boolean z3) {
        ArrayDecoder arrayDecoder = new ArrayDecoder(bArr, i4, i5, z3);
        try {
            arrayDecoder.pushLimit(i5);
            return arrayDecoder;
        } catch (InvalidProtocolBufferException e4) {
            throw new IllegalArgumentException(e4);
        }
    }

    public static int decodeZigZag32(int i4) {
        return (-(i4 & 1)) ^ (i4 >>> 1);
    }

    public static long decodeZigZag64(long j4) {
        return (-(j4 & 1)) ^ (j4 >>> 1);
    }

    public static CodedInputStream newInstance(InputStream inputStream) {
        return newInstance(inputStream, 4096);
    }

    public static int readRawVarint32(int i4, InputStream inputStream) throws IOException {
        if ((i4 & 128) == 0) {
            return i4;
        }
        int i5 = i4 & 127;
        int i6 = 7;
        while (i6 < 32) {
            int read = inputStream.read();
            if (read != -1) {
                i5 |= (read & 127) << i6;
                if ((read & 128) == 0) {
                    return i5;
                }
                i6 += 7;
            } else {
                throw InvalidProtocolBufferException.n();
            }
        }
        while (i6 < 64) {
            int read2 = inputStream.read();
            if (read2 != -1) {
                if ((read2 & 128) == 0) {
                    return i5;
                }
                i6 += 7;
            } else {
                throw InvalidProtocolBufferException.n();
            }
        }
        throw InvalidProtocolBufferException.g();
    }

    public abstract void checkLastTagWas(int i4) throws InvalidProtocolBufferException;

    public void checkRecursionLimit() throws InvalidProtocolBufferException {
        if (this.f33216a < this.f33217b) {
            return;
        }
        throw InvalidProtocolBufferException.j();
    }

    public abstract void enableAliasing(boolean z3);

    public abstract int getBytesUntilLimit();

    public abstract int getLastTag();

    public abstract int getTotalBytesRead();

    public abstract boolean isAtEnd() throws IOException;

    public abstract void popLimit(int i4);

    public abstract int pushLimit(int i4) throws InvalidProtocolBufferException;

    public abstract boolean readBool() throws IOException;

    public abstract byte[] readByteArray() throws IOException;

    public abstract ByteBuffer readByteBuffer() throws IOException;

    public abstract ByteString readBytes() throws IOException;

    public abstract double readDouble() throws IOException;

    public abstract int readEnum() throws IOException;

    public abstract int readFixed32() throws IOException;

    public abstract long readFixed64() throws IOException;

    public abstract float readFloat() throws IOException;

    public abstract <T extends MessageLite> T readGroup(int i4, Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws IOException;

    public abstract void readGroup(int i4, MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException;

    public abstract int readInt32() throws IOException;

    public abstract long readInt64() throws IOException;

    public abstract <T extends MessageLite> T readMessage(Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws IOException;

    public abstract void readMessage(MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException;

    public abstract byte readRawByte() throws IOException;

    public abstract byte[] readRawBytes(int i4) throws IOException;

    public abstract int readRawLittleEndian32() throws IOException;

    public abstract long readRawLittleEndian64() throws IOException;

    public abstract int readRawVarint32() throws IOException;

    public abstract long readRawVarint64() throws IOException;

    public abstract int readSFixed32() throws IOException;

    public abstract long readSFixed64() throws IOException;

    public abstract int readSInt32() throws IOException;

    public abstract long readSInt64() throws IOException;

    public abstract String readString() throws IOException;

    public abstract String readStringRequireUtf8() throws IOException;

    public abstract int readTag() throws IOException;

    public abstract int readUInt32() throws IOException;

    public abstract long readUInt64() throws IOException;

    @Deprecated
    public abstract void readUnknownGroup(int i4, MessageLite.Builder builder) throws IOException;

    public abstract void resetSizeCounter();

    public final int setRecursionLimit(int i4) {
        if (i4 >= 0) {
            int i5 = this.f33217b;
            this.f33217b = i4;
            return i5;
        }
        throw new IllegalArgumentException("Recursion limit cannot be negative: " + i4);
    }

    public final int setSizeLimit(int i4) {
        if (i4 >= 0) {
            int i5 = this.f33218c;
            this.f33218c = i4;
            return i5;
        }
        throw new IllegalArgumentException("Size limit cannot be negative: " + i4);
    }

    public abstract boolean skipField(int i4) throws IOException;

    @Deprecated
    public abstract boolean skipField(int i4, CodedOutputStream codedOutputStream) throws IOException;

    public abstract void skipMessage() throws IOException;

    public abstract void skipMessage(CodedOutputStream codedOutputStream) throws IOException;

    public abstract void skipRawBytes(int i4) throws IOException;

    private CodedInputStream() {
        this.f33217b = f33215f;
        this.f33218c = Integer.MAX_VALUE;
        this.f33220e = false;
    }

    public static CodedInputStream newInstance(InputStream inputStream, int i4) {
        if (i4 > 0) {
            if (inputStream == null) {
                return newInstance(Internal.EMPTY_BYTE_ARRAY);
            }
            return new StreamDecoder(inputStream, i4);
        }
        throw new IllegalArgumentException("bufferSize must be > 0");
    }

    public static CodedInputStream newInstance(Iterable<ByteBuffer> iterable) {
        if (!UnsafeDirectNioDecoder.e()) {
            return newInstance(new IterableByteBufferInputStream(iterable));
        }
        return a(iterable, false);
    }

    public static CodedInputStream newInstance(byte[] bArr) {
        return newInstance(bArr, 0, bArr.length);
    }

    public static CodedInputStream newInstance(byte[] bArr, int i4, int i5) {
        return c(bArr, i4, i5, false);
    }

    public static CodedInputStream newInstance(ByteBuffer byteBuffer) {
        return b(byteBuffer, false);
    }
}
