package com.google.protobuf;

import android.support.v4.media.session.PlaybackStateCompat;
import com.google.android.gms.nearby.uwb.RangingPosition;
import com.google.protobuf.Internal;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.Utf8;
import com.google.protobuf.WireFormat;
import com.google.protobuf.Writer;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Map;
import org.jetbrains.anko.DimensionsKt;

/* JADX INFO: Access modifiers changed from: package-private */
@CheckReturnValue
/* loaded from: classes6.dex */
public abstract class BinaryWriter extends ByteOutput implements Writer {

    /* renamed from: a  reason: collision with root package name */
    private final BufferAllocator f33167a;

    /* renamed from: b  reason: collision with root package name */
    private final int f33168b;

    /* renamed from: c  reason: collision with root package name */
    final ArrayDeque<AllocatedBuffer> f33169c;

    /* renamed from: d  reason: collision with root package name */
    int f33170d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.protobuf.BinaryWriter$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f33171a;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            f33171a = iArr;
            try {
                iArr[WireFormat.FieldType.BOOL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f33171a[WireFormat.FieldType.FIXED32.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f33171a[WireFormat.FieldType.FIXED64.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f33171a[WireFormat.FieldType.INT32.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f33171a[WireFormat.FieldType.INT64.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f33171a[WireFormat.FieldType.SFIXED32.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f33171a[WireFormat.FieldType.SFIXED64.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f33171a[WireFormat.FieldType.SINT32.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f33171a[WireFormat.FieldType.SINT64.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f33171a[WireFormat.FieldType.STRING.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f33171a[WireFormat.FieldType.UINT32.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f33171a[WireFormat.FieldType.UINT64.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f33171a[WireFormat.FieldType.FLOAT.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f33171a[WireFormat.FieldType.DOUBLE.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f33171a[WireFormat.FieldType.MESSAGE.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f33171a[WireFormat.FieldType.BYTES.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f33171a[WireFormat.FieldType.ENUM.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    /* loaded from: classes6.dex */
    private static final class SafeDirectWriter extends BinaryWriter {

        /* renamed from: e  reason: collision with root package name */
        private ByteBuffer f33172e;

        /* renamed from: f  reason: collision with root package name */
        private int f33173f;

        /* renamed from: g  reason: collision with root package name */
        private int f33174g;

        private int Q() {
            return this.f33173f - this.f33174g;
        }

        private void S() {
            U(h());
        }

        private void T(int i4) {
            U(i(i4));
        }

        private void U(AllocatedBuffer allocatedBuffer) {
            if (allocatedBuffer.d()) {
                ByteBuffer f4 = allocatedBuffer.f();
                if (f4.isDirect()) {
                    R();
                    this.f33169c.addFirst(allocatedBuffer);
                    this.f33172e = f4;
                    f4.limit(f4.capacity());
                    this.f33172e.position(0);
                    this.f33172e.order(ByteOrder.LITTLE_ENDIAN);
                    int limit = this.f33172e.limit() - 1;
                    this.f33173f = limit;
                    this.f33174g = limit;
                    return;
                }
                throw new RuntimeException("Allocator returned non-direct buffer");
            }
            throw new RuntimeException("Allocated buffer does not have NIO buffer");
        }

        private void W(int i4) {
            ByteBuffer byteBuffer = this.f33172e;
            int i5 = this.f33174g;
            this.f33174g = i5 - 1;
            byteBuffer.put(i5, (byte) (i4 >>> 28));
            int i6 = this.f33174g - 4;
            this.f33174g = i6;
            this.f33172e.putInt(i6 + 1, (i4 & 127) | 128 | ((((i4 >>> 21) & 127) | 128) << 24) | ((((i4 >>> 14) & 127) | 128) << 16) | ((((i4 >>> 7) & 127) | 128) << 8));
        }

        private void X(int i4) {
            int i5 = this.f33174g - 4;
            this.f33174g = i5;
            this.f33172e.putInt(i5 + 1, (i4 & 127) | 128 | ((266338304 & i4) << 3) | (((2080768 & i4) | 2097152) << 2) | (((i4 & 16256) | 16384) << 1));
        }

        private void Y(int i4) {
            ByteBuffer byteBuffer = this.f33172e;
            int i5 = this.f33174g;
            this.f33174g = i5 - 1;
            byteBuffer.put(i5, (byte) i4);
        }

        private void Z(int i4) {
            int i5 = this.f33174g - 3;
            this.f33174g = i5;
            this.f33172e.putInt(i5, (((i4 & 127) | 128) << 8) | ((2080768 & i4) << 10) | (((i4 & 16256) | 16384) << 9));
        }

        private void a0(int i4) {
            int i5 = this.f33174g - 2;
            this.f33174g = i5;
            this.f33172e.putShort(i5 + 1, (short) ((i4 & 127) | 128 | ((i4 & 16256) << 1)));
        }

        private void b0(long j4) {
            int i4 = this.f33174g - 8;
            this.f33174g = i4;
            this.f33172e.putLong(i4 + 1, (j4 & 127) | 128 | ((71494644084506624L & j4) << 7) | (((558551906910208L & j4) | 562949953421312L) << 6) | (((4363686772736L & j4) | 4398046511104L) << 5) | (((34091302912L & j4) | 34359738368L) << 4) | (((266338304 & j4) | 268435456) << 3) | (((2080768 & j4) | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE) << 2) | (((16256 & j4) | 16384) << 1));
        }

        private void c0(long j4) {
            int i4 = this.f33174g - 8;
            this.f33174g = i4;
            this.f33172e.putLong(i4 + 1, (j4 & 127) | 128 | (((71494644084506624L & j4) | 72057594037927936L) << 7) | (((558551906910208L & j4) | 562949953421312L) << 6) | (((4363686772736L & j4) | 4398046511104L) << 5) | (((34091302912L & j4) | 34359738368L) << 4) | (((266338304 & j4) | 268435456) << 3) | (((2080768 & j4) | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE) << 2) | (((16256 & j4) | 16384) << 1));
        }

        private void d0(long j4) {
            int i4 = this.f33174g - 5;
            this.f33174g = i4;
            this.f33172e.putLong(i4 - 2, (((j4 & 127) | 128) << 24) | ((34091302912L & j4) << 28) | (((266338304 & j4) | 268435456) << 27) | (((2080768 & j4) | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE) << 26) | (((16256 & j4) | 16384) << 25));
        }

        private void e0(long j4) {
            X((int) j4);
        }

        private void f0(long j4) {
            ByteBuffer byteBuffer = this.f33172e;
            int i4 = this.f33174g;
            this.f33174g = i4 - 1;
            byteBuffer.put(i4, (byte) (j4 >>> 56));
            c0(j4 & 72057594037927935L);
        }

        private void g0(long j4) {
            Y((int) j4);
        }

        private void h0(long j4) {
            int i4 = this.f33174g - 7;
            this.f33174g = i4;
            this.f33172e.putLong(i4, (((j4 & 127) | 128) << 8) | ((558551906910208L & j4) << 14) | (((4363686772736L & j4) | 4398046511104L) << 13) | (((34091302912L & j4) | 34359738368L) << 12) | (((266338304 & j4) | 268435456) << 11) | (((2080768 & j4) | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE) << 10) | (((16256 & j4) | 16384) << 9));
        }

        private void i0(long j4) {
            int i4 = this.f33174g - 6;
            this.f33174g = i4;
            this.f33172e.putLong(i4 - 1, (((j4 & 127) | 128) << 16) | ((4363686772736L & j4) << 21) | (((34091302912L & j4) | 34359738368L) << 20) | (((266338304 & j4) | 268435456) << 19) | (((2080768 & j4) | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE) << 18) | (((16256 & j4) | 16384) << 17));
        }

        private void j0(long j4) {
            ByteBuffer byteBuffer = this.f33172e;
            int i4 = this.f33174g;
            this.f33174g = i4 - 1;
            byteBuffer.put(i4, (byte) (j4 >>> 63));
            ByteBuffer byteBuffer2 = this.f33172e;
            int i5 = this.f33174g;
            this.f33174g = i5 - 1;
            byteBuffer2.put(i5, (byte) (((j4 >>> 56) & 127) | 128));
            c0(j4 & 72057594037927935L);
        }

        private void k0(long j4) {
            Z((int) j4);
        }

        private void l0(long j4) {
            a0((int) j4);
        }

        private int spaceLeft() {
            return this.f33174g + 1;
        }

        @Override // com.google.protobuf.BinaryWriter
        void E(int i4) {
            O(CodedOutputStream.encodeZigZag32(i4));
        }

        @Override // com.google.protobuf.BinaryWriter
        void H(long j4) {
            P(CodedOutputStream.encodeZigZag64(j4));
        }

        @Override // com.google.protobuf.BinaryWriter
        void O(int i4) {
            if ((i4 & RangingPosition.RSSI_UNKNOWN) == 0) {
                Y(i4);
            } else if ((i4 & (-16384)) == 0) {
                a0(i4);
            } else if (((-2097152) & i4) == 0) {
                Z(i4);
            } else if (((-268435456) & i4) == 0) {
                X(i4);
            } else {
                W(i4);
            }
        }

        @Override // com.google.protobuf.BinaryWriter
        void P(long j4) {
            switch (BinaryWriter.g(j4)) {
                case 1:
                    g0(j4);
                    return;
                case 2:
                    l0(j4);
                    return;
                case 3:
                    k0(j4);
                    return;
                case 4:
                    e0(j4);
                    return;
                case 5:
                    d0(j4);
                    return;
                case 6:
                    i0(j4);
                    return;
                case 7:
                    h0(j4);
                    return;
                case 8:
                    b0(j4);
                    return;
                case 9:
                    f0(j4);
                    return;
                case 10:
                    j0(j4);
                    return;
                default:
                    return;
            }
        }

        void R() {
            if (this.f33172e != null) {
                this.f33170d += Q();
                this.f33172e.position(this.f33174g + 1);
                this.f33172e = null;
                this.f33174g = 0;
                this.f33173f = 0;
            }
        }

        void V(String str) {
            int i4;
            int i5;
            int i6;
            char charAt;
            l(str.length());
            int length = str.length() - 1;
            this.f33174g -= length;
            while (length >= 0 && (charAt = str.charAt(length)) < 128) {
                this.f33172e.put(this.f33174g + length, (byte) charAt);
                length--;
            }
            if (length == -1) {
                this.f33174g--;
                return;
            }
            this.f33174g += length;
            while (length >= 0) {
                char charAt2 = str.charAt(length);
                if (charAt2 < 128 && (i6 = this.f33174g) >= 0) {
                    ByteBuffer byteBuffer = this.f33172e;
                    this.f33174g = i6 - 1;
                    byteBuffer.put(i6, (byte) charAt2);
                } else if (charAt2 < 2048 && (i5 = this.f33174g) > 0) {
                    ByteBuffer byteBuffer2 = this.f33172e;
                    this.f33174g = i5 - 1;
                    byteBuffer2.put(i5, (byte) ((charAt2 & '?') | 128));
                    ByteBuffer byteBuffer3 = this.f33172e;
                    int i7 = this.f33174g;
                    this.f33174g = i7 - 1;
                    byteBuffer3.put(i7, (byte) ((charAt2 >>> 6) | 960));
                } else if ((charAt2 < 55296 || 57343 < charAt2) && (i4 = this.f33174g) > 1) {
                    ByteBuffer byteBuffer4 = this.f33172e;
                    this.f33174g = i4 - 1;
                    byteBuffer4.put(i4, (byte) ((charAt2 & '?') | 128));
                    ByteBuffer byteBuffer5 = this.f33172e;
                    int i8 = this.f33174g;
                    this.f33174g = i8 - 1;
                    byteBuffer5.put(i8, (byte) (((charAt2 >>> 6) & 63) | 128));
                    ByteBuffer byteBuffer6 = this.f33172e;
                    int i9 = this.f33174g;
                    this.f33174g = i9 - 1;
                    byteBuffer6.put(i9, (byte) ((charAt2 >>> '\f') | DimensionsKt.XXHDPI));
                } else if (this.f33174g > 2) {
                    if (length != 0) {
                        char charAt3 = str.charAt(length - 1);
                        if (Character.isSurrogatePair(charAt3, charAt2)) {
                            length--;
                            int codePoint = Character.toCodePoint(charAt3, charAt2);
                            ByteBuffer byteBuffer7 = this.f33172e;
                            int i10 = this.f33174g;
                            this.f33174g = i10 - 1;
                            byteBuffer7.put(i10, (byte) ((codePoint & 63) | 128));
                            ByteBuffer byteBuffer8 = this.f33172e;
                            int i11 = this.f33174g;
                            this.f33174g = i11 - 1;
                            byteBuffer8.put(i11, (byte) (((codePoint >>> 6) & 63) | 128));
                            ByteBuffer byteBuffer9 = this.f33172e;
                            int i12 = this.f33174g;
                            this.f33174g = i12 - 1;
                            byteBuffer9.put(i12, (byte) (((codePoint >>> 12) & 63) | 128));
                            ByteBuffer byteBuffer10 = this.f33172e;
                            int i13 = this.f33174g;
                            this.f33174g = i13 - 1;
                            byteBuffer10.put(i13, (byte) ((codePoint >>> 18) | 240));
                        }
                    }
                    throw new Utf8.UnpairedSurrogateException(length - 1, length);
                } else {
                    l(length);
                    length++;
                }
                length--;
            }
        }

        @Override // com.google.protobuf.Writer
        public void c(int i4, Object obj, Schema schema) throws IOException {
            writeTag(i4, 4);
            schema.a(obj, this);
            writeTag(i4, 3);
        }

        @Override // com.google.protobuf.Writer
        public void e(int i4, Object obj, Schema schema) throws IOException {
            int totalBytesWritten = getTotalBytesWritten();
            schema.a(obj, this);
            l(10);
            O(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i4, 2);
        }

        @Override // com.google.protobuf.BinaryWriter
        public int getTotalBytesWritten() {
            return this.f33170d + Q();
        }

        @Override // com.google.protobuf.BinaryWriter
        void l(int i4) {
            if (spaceLeft() < i4) {
                T(i4);
            }
        }

        @Override // com.google.protobuf.BinaryWriter
        void m(boolean z3) {
            write(z3 ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.protobuf.BinaryWriter
        void r(int i4) {
            int i5 = this.f33174g - 4;
            this.f33174g = i5;
            this.f33172e.putInt(i5 + 1, i4);
        }

        @Override // com.google.protobuf.BinaryWriter
        void u(long j4) {
            int i4 = this.f33174g - 8;
            this.f33174g = i4;
            this.f33172e.putLong(i4 + 1, j4);
        }

        @Override // com.google.protobuf.ByteOutput
        public void write(byte b4) {
            ByteBuffer byteBuffer = this.f33172e;
            int i4 = this.f33174g;
            this.f33174g = i4 - 1;
            byteBuffer.put(i4, b4);
        }

        @Override // com.google.protobuf.Writer
        public void writeBool(int i4, boolean z3) {
            l(6);
            write(z3 ? (byte) 1 : (byte) 0);
            writeTag(i4, 0);
        }

        @Override // com.google.protobuf.Writer
        public void writeBytes(int i4, ByteString byteString) {
            try {
                byteString.y(this);
                l(10);
                O(byteString.size());
                writeTag(i4, 2);
            } catch (IOException e4) {
                throw new RuntimeException(e4);
            }
        }

        @Override // com.google.protobuf.Writer
        @Deprecated
        public void writeEndGroup(int i4) {
            writeTag(i4, 4);
        }

        @Override // com.google.protobuf.Writer
        public void writeFixed32(int i4, int i5) {
            l(9);
            r(i5);
            writeTag(i4, 5);
        }

        @Override // com.google.protobuf.Writer
        public void writeFixed64(int i4, long j4) {
            l(13);
            u(j4);
            writeTag(i4, 1);
        }

        @Override // com.google.protobuf.Writer
        public void writeInt32(int i4, int i5) {
            l(15);
            z(i5);
            writeTag(i4, 0);
        }

        @Override // com.google.protobuf.ByteOutput
        public void writeLazy(byte[] bArr, int i4, int i5) {
            if (spaceLeft() < i5) {
                this.f33170d += i5;
                this.f33169c.addFirst(AllocatedBuffer.k(bArr, i4, i5));
                S();
                return;
            }
            int i6 = this.f33174g - i5;
            this.f33174g = i6;
            this.f33172e.position(i6 + 1);
            this.f33172e.put(bArr, i4, i5);
        }

        @Override // com.google.protobuf.Writer
        public void writeMessage(int i4, Object obj) throws IOException {
            int totalBytesWritten = getTotalBytesWritten();
            Protobuf.a().e(obj, this);
            l(10);
            O(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i4, 2);
        }

        @Override // com.google.protobuf.Writer
        public void writeSInt32(int i4, int i5) {
            l(10);
            E(i5);
            writeTag(i4, 0);
        }

        @Override // com.google.protobuf.Writer
        public void writeSInt64(int i4, long j4) {
            l(15);
            H(j4);
            writeTag(i4, 0);
        }

        @Override // com.google.protobuf.Writer
        @Deprecated
        public void writeStartGroup(int i4) {
            writeTag(i4, 3);
        }

        @Override // com.google.protobuf.Writer
        public void writeString(int i4, String str) {
            int totalBytesWritten = getTotalBytesWritten();
            V(str);
            l(10);
            O(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i4, 2);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeTag(int i4, int i5) {
            O(WireFormat.a(i4, i5));
        }

        @Override // com.google.protobuf.Writer
        public void writeUInt32(int i4, int i5) {
            l(10);
            O(i5);
            writeTag(i4, 0);
        }

        @Override // com.google.protobuf.Writer
        public void writeUInt64(int i4, long j4) {
            l(15);
            P(j4);
            writeTag(i4, 0);
        }

        @Override // com.google.protobuf.BinaryWriter
        void z(int i4) {
            if (i4 >= 0) {
                O(i4);
            } else {
                P(i4);
            }
        }

        @Override // com.google.protobuf.ByteOutput
        public void write(byte[] bArr, int i4, int i5) {
            if (spaceLeft() < i5) {
                T(i5);
            }
            int i6 = this.f33174g - i5;
            this.f33174g = i6;
            this.f33172e.position(i6 + 1);
            this.f33172e.put(bArr, i4, i5);
        }

        @Override // com.google.protobuf.ByteOutput
        public void write(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            if (spaceLeft() < remaining) {
                T(remaining);
            }
            int i4 = this.f33174g - remaining;
            this.f33174g = i4;
            this.f33172e.position(i4 + 1);
            this.f33172e.put(byteBuffer);
        }

        @Override // com.google.protobuf.ByteOutput
        public void writeLazy(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            if (spaceLeft() < remaining) {
                this.f33170d += remaining;
                this.f33169c.addFirst(AllocatedBuffer.i(byteBuffer));
                S();
                return;
            }
            int i4 = this.f33174g - remaining;
            this.f33174g = i4;
            this.f33172e.position(i4 + 1);
            this.f33172e.put(byteBuffer);
        }
    }

    /* loaded from: classes6.dex */
    private static final class SafeHeapWriter extends BinaryWriter {

        /* renamed from: e  reason: collision with root package name */
        private AllocatedBuffer f33175e;

        /* renamed from: f  reason: collision with root package name */
        private byte[] f33176f;

        /* renamed from: g  reason: collision with root package name */
        private int f33177g;

        /* renamed from: h  reason: collision with root package name */
        private int f33178h;

        /* renamed from: i  reason: collision with root package name */
        private int f33179i;

        /* renamed from: j  reason: collision with root package name */
        private int f33180j;

        /* renamed from: k  reason: collision with root package name */
        private int f33181k;

        private void S() {
            U(j());
        }

        private void T(int i4) {
            U(k(i4));
        }

        private void U(AllocatedBuffer allocatedBuffer) {
            if (allocatedBuffer.c()) {
                R();
                this.f33169c.addFirst(allocatedBuffer);
                this.f33175e = allocatedBuffer;
                this.f33176f = allocatedBuffer.a();
                int b4 = allocatedBuffer.b();
                this.f33178h = allocatedBuffer.e() + b4;
                int g4 = b4 + allocatedBuffer.g();
                this.f33177g = g4;
                this.f33179i = g4 - 1;
                int i4 = this.f33178h - 1;
                this.f33180j = i4;
                this.f33181k = i4;
                return;
            }
            throw new RuntimeException("Allocator returned non-heap buffer");
        }

        private void W(int i4) {
            byte[] bArr = this.f33176f;
            int i5 = this.f33181k;
            int i6 = i5 - 1;
            bArr[i5] = (byte) (i4 >>> 28);
            int i7 = i6 - 1;
            bArr[i6] = (byte) (((i4 >>> 21) & 127) | 128);
            int i8 = i7 - 1;
            bArr[i7] = (byte) (((i4 >>> 14) & 127) | 128);
            int i9 = i8 - 1;
            bArr[i8] = (byte) (((i4 >>> 7) & 127) | 128);
            this.f33181k = i9 - 1;
            bArr[i9] = (byte) ((i4 & 127) | 128);
        }

        private void X(int i4) {
            byte[] bArr = this.f33176f;
            int i5 = this.f33181k;
            int i6 = i5 - 1;
            bArr[i5] = (byte) (i4 >>> 21);
            int i7 = i6 - 1;
            bArr[i6] = (byte) (((i4 >>> 14) & 127) | 128);
            int i8 = i7 - 1;
            bArr[i7] = (byte) (((i4 >>> 7) & 127) | 128);
            this.f33181k = i8 - 1;
            bArr[i8] = (byte) ((i4 & 127) | 128);
        }

        private void Y(int i4) {
            byte[] bArr = this.f33176f;
            int i5 = this.f33181k;
            this.f33181k = i5 - 1;
            bArr[i5] = (byte) i4;
        }

        private void Z(int i4) {
            byte[] bArr = this.f33176f;
            int i5 = this.f33181k;
            int i6 = i5 - 1;
            bArr[i5] = (byte) (i4 >>> 14);
            int i7 = i6 - 1;
            bArr[i6] = (byte) (((i4 >>> 7) & 127) | 128);
            this.f33181k = i7 - 1;
            bArr[i7] = (byte) ((i4 & 127) | 128);
        }

        private void a0(int i4) {
            byte[] bArr = this.f33176f;
            int i5 = this.f33181k;
            int i6 = i5 - 1;
            bArr[i5] = (byte) (i4 >>> 7);
            this.f33181k = i6 - 1;
            bArr[i6] = (byte) ((i4 & 127) | 128);
        }

        private void b0(long j4) {
            byte[] bArr = this.f33176f;
            int i4 = this.f33181k;
            int i5 = i4 - 1;
            bArr[i4] = (byte) (j4 >>> 49);
            int i6 = i5 - 1;
            bArr[i5] = (byte) (((j4 >>> 42) & 127) | 128);
            int i7 = i6 - 1;
            bArr[i6] = (byte) (((j4 >>> 35) & 127) | 128);
            int i8 = i7 - 1;
            bArr[i7] = (byte) (((j4 >>> 28) & 127) | 128);
            int i9 = i8 - 1;
            bArr[i8] = (byte) (((j4 >>> 21) & 127) | 128);
            int i10 = i9 - 1;
            bArr[i9] = (byte) (((j4 >>> 14) & 127) | 128);
            int i11 = i10 - 1;
            bArr[i10] = (byte) (((j4 >>> 7) & 127) | 128);
            this.f33181k = i11 - 1;
            bArr[i11] = (byte) ((j4 & 127) | 128);
        }

        private void c0(long j4) {
            byte[] bArr = this.f33176f;
            int i4 = this.f33181k;
            int i5 = i4 - 1;
            bArr[i4] = (byte) (j4 >>> 28);
            int i6 = i5 - 1;
            bArr[i5] = (byte) (((j4 >>> 21) & 127) | 128);
            int i7 = i6 - 1;
            bArr[i6] = (byte) (((j4 >>> 14) & 127) | 128);
            int i8 = i7 - 1;
            bArr[i7] = (byte) (((j4 >>> 7) & 127) | 128);
            this.f33181k = i8 - 1;
            bArr[i8] = (byte) ((j4 & 127) | 128);
        }

        private void d0(long j4) {
            byte[] bArr = this.f33176f;
            int i4 = this.f33181k;
            int i5 = i4 - 1;
            bArr[i4] = (byte) (j4 >>> 21);
            int i6 = i5 - 1;
            bArr[i5] = (byte) (((j4 >>> 14) & 127) | 128);
            int i7 = i6 - 1;
            bArr[i6] = (byte) (((j4 >>> 7) & 127) | 128);
            this.f33181k = i7 - 1;
            bArr[i7] = (byte) ((j4 & 127) | 128);
        }

        private void e0(long j4) {
            byte[] bArr = this.f33176f;
            int i4 = this.f33181k;
            int i5 = i4 - 1;
            bArr[i4] = (byte) (j4 >>> 56);
            int i6 = i5 - 1;
            bArr[i5] = (byte) (((j4 >>> 49) & 127) | 128);
            int i7 = i6 - 1;
            bArr[i6] = (byte) (((j4 >>> 42) & 127) | 128);
            int i8 = i7 - 1;
            bArr[i7] = (byte) (((j4 >>> 35) & 127) | 128);
            int i9 = i8 - 1;
            bArr[i8] = (byte) (((j4 >>> 28) & 127) | 128);
            int i10 = i9 - 1;
            bArr[i9] = (byte) (((j4 >>> 21) & 127) | 128);
            int i11 = i10 - 1;
            bArr[i10] = (byte) (((j4 >>> 14) & 127) | 128);
            int i12 = i11 - 1;
            bArr[i11] = (byte) (((j4 >>> 7) & 127) | 128);
            this.f33181k = i12 - 1;
            bArr[i12] = (byte) ((j4 & 127) | 128);
        }

        private void f0(long j4) {
            byte[] bArr = this.f33176f;
            int i4 = this.f33181k;
            this.f33181k = i4 - 1;
            bArr[i4] = (byte) j4;
        }

        private void g0(long j4) {
            byte[] bArr = this.f33176f;
            int i4 = this.f33181k;
            int i5 = i4 - 1;
            bArr[i4] = (byte) (j4 >>> 42);
            int i6 = i5 - 1;
            bArr[i5] = (byte) (((j4 >>> 35) & 127) | 128);
            int i7 = i6 - 1;
            bArr[i6] = (byte) (((j4 >>> 28) & 127) | 128);
            int i8 = i7 - 1;
            bArr[i7] = (byte) (((j4 >>> 21) & 127) | 128);
            int i9 = i8 - 1;
            bArr[i8] = (byte) (((j4 >>> 14) & 127) | 128);
            int i10 = i9 - 1;
            bArr[i9] = (byte) (((j4 >>> 7) & 127) | 128);
            this.f33181k = i10 - 1;
            bArr[i10] = (byte) ((j4 & 127) | 128);
        }

        private void h0(long j4) {
            byte[] bArr = this.f33176f;
            int i4 = this.f33181k;
            int i5 = i4 - 1;
            bArr[i4] = (byte) (j4 >>> 35);
            int i6 = i5 - 1;
            bArr[i5] = (byte) (((j4 >>> 28) & 127) | 128);
            int i7 = i6 - 1;
            bArr[i6] = (byte) (((j4 >>> 21) & 127) | 128);
            int i8 = i7 - 1;
            bArr[i7] = (byte) (((j4 >>> 14) & 127) | 128);
            int i9 = i8 - 1;
            bArr[i8] = (byte) (((j4 >>> 7) & 127) | 128);
            this.f33181k = i9 - 1;
            bArr[i9] = (byte) ((j4 & 127) | 128);
        }

        private void i0(long j4) {
            byte[] bArr = this.f33176f;
            int i4 = this.f33181k;
            int i5 = i4 - 1;
            bArr[i4] = (byte) (j4 >>> 63);
            int i6 = i5 - 1;
            bArr[i5] = (byte) (((j4 >>> 56) & 127) | 128);
            int i7 = i6 - 1;
            bArr[i6] = (byte) (((j4 >>> 49) & 127) | 128);
            int i8 = i7 - 1;
            bArr[i7] = (byte) (((j4 >>> 42) & 127) | 128);
            int i9 = i8 - 1;
            bArr[i8] = (byte) (((j4 >>> 35) & 127) | 128);
            int i10 = i9 - 1;
            bArr[i9] = (byte) (((j4 >>> 28) & 127) | 128);
            int i11 = i10 - 1;
            bArr[i10] = (byte) (((j4 >>> 21) & 127) | 128);
            int i12 = i11 - 1;
            bArr[i11] = (byte) (((j4 >>> 14) & 127) | 128);
            int i13 = i12 - 1;
            bArr[i12] = (byte) (((j4 >>> 7) & 127) | 128);
            this.f33181k = i13 - 1;
            bArr[i13] = (byte) ((j4 & 127) | 128);
        }

        private void j0(long j4) {
            byte[] bArr = this.f33176f;
            int i4 = this.f33181k;
            int i5 = i4 - 1;
            bArr[i4] = (byte) (((int) j4) >>> 14);
            int i6 = i5 - 1;
            bArr[i5] = (byte) (((j4 >>> 7) & 127) | 128);
            this.f33181k = i6 - 1;
            bArr[i6] = (byte) ((j4 & 127) | 128);
        }

        private void k0(long j4) {
            byte[] bArr = this.f33176f;
            int i4 = this.f33181k;
            int i5 = i4 - 1;
            bArr[i4] = (byte) (j4 >>> 7);
            this.f33181k = i5 - 1;
            bArr[i5] = (byte) ((((int) j4) & 127) | 128);
        }

        @Override // com.google.protobuf.BinaryWriter
        void E(int i4) {
            O(CodedOutputStream.encodeZigZag32(i4));
        }

        @Override // com.google.protobuf.BinaryWriter
        void H(long j4) {
            P(CodedOutputStream.encodeZigZag64(j4));
        }

        @Override // com.google.protobuf.BinaryWriter
        void O(int i4) {
            if ((i4 & RangingPosition.RSSI_UNKNOWN) == 0) {
                Y(i4);
            } else if ((i4 & (-16384)) == 0) {
                a0(i4);
            } else if (((-2097152) & i4) == 0) {
                Z(i4);
            } else if (((-268435456) & i4) == 0) {
                X(i4);
            } else {
                W(i4);
            }
        }

        @Override // com.google.protobuf.BinaryWriter
        void P(long j4) {
            switch (BinaryWriter.g(j4)) {
                case 1:
                    f0(j4);
                    return;
                case 2:
                    k0(j4);
                    return;
                case 3:
                    j0(j4);
                    return;
                case 4:
                    d0(j4);
                    return;
                case 5:
                    c0(j4);
                    return;
                case 6:
                    h0(j4);
                    return;
                case 7:
                    g0(j4);
                    return;
                case 8:
                    b0(j4);
                    return;
                case 9:
                    e0(j4);
                    return;
                case 10:
                    i0(j4);
                    return;
                default:
                    return;
            }
        }

        int Q() {
            return this.f33180j - this.f33181k;
        }

        void R() {
            if (this.f33175e != null) {
                this.f33170d += Q();
                AllocatedBuffer allocatedBuffer = this.f33175e;
                allocatedBuffer.h((this.f33181k - allocatedBuffer.b()) + 1);
                this.f33175e = null;
                this.f33181k = 0;
                this.f33180j = 0;
            }
        }

        void V(String str) {
            int i4;
            int i5;
            int i6;
            char charAt;
            l(str.length());
            int length = str.length() - 1;
            this.f33181k -= length;
            while (length >= 0 && (charAt = str.charAt(length)) < 128) {
                this.f33176f[this.f33181k + length] = (byte) charAt;
                length--;
            }
            if (length == -1) {
                this.f33181k--;
                return;
            }
            this.f33181k += length;
            while (length >= 0) {
                char charAt2 = str.charAt(length);
                if (charAt2 < 128 && (i6 = this.f33181k) > this.f33179i) {
                    byte[] bArr = this.f33176f;
                    this.f33181k = i6 - 1;
                    bArr[i6] = (byte) charAt2;
                } else if (charAt2 < 2048 && (i5 = this.f33181k) > this.f33177g) {
                    byte[] bArr2 = this.f33176f;
                    int i7 = i5 - 1;
                    bArr2[i5] = (byte) ((charAt2 & '?') | 128);
                    this.f33181k = i7 - 1;
                    bArr2[i7] = (byte) ((charAt2 >>> 6) | 960);
                } else if ((charAt2 < 55296 || 57343 < charAt2) && (i4 = this.f33181k) > this.f33177g + 1) {
                    byte[] bArr3 = this.f33176f;
                    int i8 = i4 - 1;
                    bArr3[i4] = (byte) ((charAt2 & '?') | 128);
                    int i9 = i8 - 1;
                    bArr3[i8] = (byte) (((charAt2 >>> 6) & 63) | 128);
                    this.f33181k = i9 - 1;
                    bArr3[i9] = (byte) ((charAt2 >>> '\f') | DimensionsKt.XXHDPI);
                } else if (this.f33181k > this.f33177g + 2) {
                    if (length != 0) {
                        char charAt3 = str.charAt(length - 1);
                        if (Character.isSurrogatePair(charAt3, charAt2)) {
                            length--;
                            int codePoint = Character.toCodePoint(charAt3, charAt2);
                            byte[] bArr4 = this.f33176f;
                            int i10 = this.f33181k;
                            int i11 = i10 - 1;
                            bArr4[i10] = (byte) ((codePoint & 63) | 128);
                            int i12 = i11 - 1;
                            bArr4[i11] = (byte) (((codePoint >>> 6) & 63) | 128);
                            int i13 = i12 - 1;
                            bArr4[i12] = (byte) (((codePoint >>> 12) & 63) | 128);
                            this.f33181k = i13 - 1;
                            bArr4[i13] = (byte) ((codePoint >>> 18) | 240);
                        }
                    }
                    throw new Utf8.UnpairedSurrogateException(length - 1, length);
                } else {
                    l(length);
                    length++;
                }
                length--;
            }
        }

        @Override // com.google.protobuf.Writer
        public void c(int i4, Object obj, Schema schema) throws IOException {
            writeTag(i4, 4);
            schema.a(obj, this);
            writeTag(i4, 3);
        }

        @Override // com.google.protobuf.Writer
        public void e(int i4, Object obj, Schema schema) throws IOException {
            int totalBytesWritten = getTotalBytesWritten();
            schema.a(obj, this);
            l(10);
            O(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i4, 2);
        }

        @Override // com.google.protobuf.BinaryWriter
        public int getTotalBytesWritten() {
            return this.f33170d + Q();
        }

        @Override // com.google.protobuf.BinaryWriter
        void l(int i4) {
            if (spaceLeft() < i4) {
                T(i4);
            }
        }

        @Override // com.google.protobuf.BinaryWriter
        void m(boolean z3) {
            write(z3 ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.protobuf.BinaryWriter
        void r(int i4) {
            byte[] bArr = this.f33176f;
            int i5 = this.f33181k;
            int i6 = i5 - 1;
            bArr[i5] = (byte) ((i4 >> 24) & 255);
            int i7 = i6 - 1;
            bArr[i6] = (byte) ((i4 >> 16) & 255);
            int i8 = i7 - 1;
            bArr[i7] = (byte) ((i4 >> 8) & 255);
            this.f33181k = i8 - 1;
            bArr[i8] = (byte) (i4 & 255);
        }

        int spaceLeft() {
            return this.f33181k - this.f33179i;
        }

        @Override // com.google.protobuf.BinaryWriter
        void u(long j4) {
            byte[] bArr = this.f33176f;
            int i4 = this.f33181k;
            int i5 = i4 - 1;
            bArr[i4] = (byte) (((int) (j4 >> 56)) & 255);
            int i6 = i5 - 1;
            bArr[i5] = (byte) (((int) (j4 >> 48)) & 255);
            int i7 = i6 - 1;
            bArr[i6] = (byte) (((int) (j4 >> 40)) & 255);
            int i8 = i7 - 1;
            bArr[i7] = (byte) (((int) (j4 >> 32)) & 255);
            int i9 = i8 - 1;
            bArr[i8] = (byte) (((int) (j4 >> 24)) & 255);
            int i10 = i9 - 1;
            bArr[i9] = (byte) (((int) (j4 >> 16)) & 255);
            int i11 = i10 - 1;
            bArr[i10] = (byte) (((int) (j4 >> 8)) & 255);
            this.f33181k = i11 - 1;
            bArr[i11] = (byte) (((int) j4) & 255);
        }

        @Override // com.google.protobuf.ByteOutput
        public void write(byte b4) {
            byte[] bArr = this.f33176f;
            int i4 = this.f33181k;
            this.f33181k = i4 - 1;
            bArr[i4] = b4;
        }

        @Override // com.google.protobuf.Writer
        public void writeBool(int i4, boolean z3) throws IOException {
            l(6);
            write(z3 ? (byte) 1 : (byte) 0);
            writeTag(i4, 0);
        }

        @Override // com.google.protobuf.Writer
        public void writeBytes(int i4, ByteString byteString) throws IOException {
            try {
                byteString.y(this);
                l(10);
                O(byteString.size());
                writeTag(i4, 2);
            } catch (IOException e4) {
                throw new RuntimeException(e4);
            }
        }

        @Override // com.google.protobuf.Writer
        public void writeEndGroup(int i4) {
            writeTag(i4, 4);
        }

        @Override // com.google.protobuf.Writer
        public void writeFixed32(int i4, int i5) throws IOException {
            l(9);
            r(i5);
            writeTag(i4, 5);
        }

        @Override // com.google.protobuf.Writer
        public void writeFixed64(int i4, long j4) throws IOException {
            l(13);
            u(j4);
            writeTag(i4, 1);
        }

        @Override // com.google.protobuf.Writer
        public void writeInt32(int i4, int i5) throws IOException {
            l(15);
            z(i5);
            writeTag(i4, 0);
        }

        @Override // com.google.protobuf.ByteOutput
        public void writeLazy(byte[] bArr, int i4, int i5) {
            if (spaceLeft() < i5) {
                this.f33170d += i5;
                this.f33169c.addFirst(AllocatedBuffer.k(bArr, i4, i5));
                S();
                return;
            }
            int i6 = this.f33181k - i5;
            this.f33181k = i6;
            System.arraycopy(bArr, i4, this.f33176f, i6 + 1, i5);
        }

        @Override // com.google.protobuf.Writer
        public void writeMessage(int i4, Object obj) throws IOException {
            int totalBytesWritten = getTotalBytesWritten();
            Protobuf.a().e(obj, this);
            l(10);
            O(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i4, 2);
        }

        @Override // com.google.protobuf.Writer
        public void writeSInt32(int i4, int i5) throws IOException {
            l(10);
            E(i5);
            writeTag(i4, 0);
        }

        @Override // com.google.protobuf.Writer
        public void writeSInt64(int i4, long j4) throws IOException {
            l(15);
            H(j4);
            writeTag(i4, 0);
        }

        @Override // com.google.protobuf.Writer
        public void writeStartGroup(int i4) {
            writeTag(i4, 3);
        }

        @Override // com.google.protobuf.Writer
        public void writeString(int i4, String str) throws IOException {
            int totalBytesWritten = getTotalBytesWritten();
            V(str);
            l(10);
            O(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i4, 2);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeTag(int i4, int i5) {
            O(WireFormat.a(i4, i5));
        }

        @Override // com.google.protobuf.Writer
        public void writeUInt32(int i4, int i5) throws IOException {
            l(10);
            O(i5);
            writeTag(i4, 0);
        }

        @Override // com.google.protobuf.Writer
        public void writeUInt64(int i4, long j4) throws IOException {
            l(15);
            P(j4);
            writeTag(i4, 0);
        }

        @Override // com.google.protobuf.BinaryWriter
        void z(int i4) {
            if (i4 >= 0) {
                O(i4);
            } else {
                P(i4);
            }
        }

        @Override // com.google.protobuf.ByteOutput
        public void write(byte[] bArr, int i4, int i5) {
            if (spaceLeft() < i5) {
                T(i5);
            }
            int i6 = this.f33181k - i5;
            this.f33181k = i6;
            System.arraycopy(bArr, i4, this.f33176f, i6 + 1, i5);
        }

        @Override // com.google.protobuf.ByteOutput
        public void write(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            if (spaceLeft() < remaining) {
                T(remaining);
            }
            int i4 = this.f33181k - remaining;
            this.f33181k = i4;
            byteBuffer.get(this.f33176f, i4 + 1, remaining);
        }

        @Override // com.google.protobuf.ByteOutput
        public void writeLazy(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            if (spaceLeft() < remaining) {
                this.f33170d += remaining;
                this.f33169c.addFirst(AllocatedBuffer.i(byteBuffer));
                S();
            }
            int i4 = this.f33181k - remaining;
            this.f33181k = i4;
            byteBuffer.get(this.f33176f, i4 + 1, remaining);
        }
    }

    /* loaded from: classes6.dex */
    private static final class UnsafeDirectWriter extends BinaryWriter {

        /* renamed from: e  reason: collision with root package name */
        private ByteBuffer f33182e;

        /* renamed from: f  reason: collision with root package name */
        private long f33183f;

        /* renamed from: g  reason: collision with root package name */
        private long f33184g;

        /* renamed from: h  reason: collision with root package name */
        private long f33185h;

        private int Q() {
            return (int) (this.f33185h - this.f33183f);
        }

        private int R() {
            return (int) (this.f33184g - this.f33185h);
        }

        private void T() {
            V(h());
        }

        private void U(int i4) {
            V(i(i4));
        }

        private void V(AllocatedBuffer allocatedBuffer) {
            if (allocatedBuffer.d()) {
                ByteBuffer f4 = allocatedBuffer.f();
                if (f4.isDirect()) {
                    S();
                    this.f33169c.addFirst(allocatedBuffer);
                    this.f33182e = f4;
                    f4.limit(f4.capacity());
                    this.f33182e.position(0);
                    long k4 = UnsafeUtil.k(this.f33182e);
                    this.f33183f = k4;
                    long limit = k4 + (this.f33182e.limit() - 1);
                    this.f33184g = limit;
                    this.f33185h = limit;
                    return;
                }
                throw new RuntimeException("Allocator returned non-direct buffer");
            }
            throw new RuntimeException("Allocated buffer does not have NIO buffer");
        }

        private void X(int i4) {
            long j4 = this.f33185h;
            this.f33185h = j4 - 1;
            UnsafeUtil.Q(j4, (byte) (i4 >>> 28));
            long j5 = this.f33185h;
            this.f33185h = j5 - 1;
            UnsafeUtil.Q(j5, (byte) (((i4 >>> 21) & 127) | 128));
            long j6 = this.f33185h;
            this.f33185h = j6 - 1;
            UnsafeUtil.Q(j6, (byte) (((i4 >>> 14) & 127) | 128));
            long j7 = this.f33185h;
            this.f33185h = j7 - 1;
            UnsafeUtil.Q(j7, (byte) (((i4 >>> 7) & 127) | 128));
            long j8 = this.f33185h;
            this.f33185h = j8 - 1;
            UnsafeUtil.Q(j8, (byte) ((i4 & 127) | 128));
        }

        private void Y(int i4) {
            long j4 = this.f33185h;
            this.f33185h = j4 - 1;
            UnsafeUtil.Q(j4, (byte) (i4 >>> 21));
            long j5 = this.f33185h;
            this.f33185h = j5 - 1;
            UnsafeUtil.Q(j5, (byte) (((i4 >>> 14) & 127) | 128));
            long j6 = this.f33185h;
            this.f33185h = j6 - 1;
            UnsafeUtil.Q(j6, (byte) (((i4 >>> 7) & 127) | 128));
            long j7 = this.f33185h;
            this.f33185h = j7 - 1;
            UnsafeUtil.Q(j7, (byte) ((i4 & 127) | 128));
        }

        private void Z(int i4) {
            long j4 = this.f33185h;
            this.f33185h = j4 - 1;
            UnsafeUtil.Q(j4, (byte) i4);
        }

        private void a0(int i4) {
            long j4 = this.f33185h;
            this.f33185h = j4 - 1;
            UnsafeUtil.Q(j4, (byte) (i4 >>> 14));
            long j5 = this.f33185h;
            this.f33185h = j5 - 1;
            UnsafeUtil.Q(j5, (byte) (((i4 >>> 7) & 127) | 128));
            long j6 = this.f33185h;
            this.f33185h = j6 - 1;
            UnsafeUtil.Q(j6, (byte) ((i4 & 127) | 128));
        }

        private void b0(int i4) {
            long j4 = this.f33185h;
            this.f33185h = j4 - 1;
            UnsafeUtil.Q(j4, (byte) (i4 >>> 7));
            long j5 = this.f33185h;
            this.f33185h = j5 - 1;
            UnsafeUtil.Q(j5, (byte) ((i4 & 127) | 128));
        }

        private void c0(long j4) {
            long j5 = this.f33185h;
            this.f33185h = j5 - 1;
            UnsafeUtil.Q(j5, (byte) (j4 >>> 49));
            long j6 = this.f33185h;
            this.f33185h = j6 - 1;
            UnsafeUtil.Q(j6, (byte) (((j4 >>> 42) & 127) | 128));
            long j7 = this.f33185h;
            this.f33185h = j7 - 1;
            UnsafeUtil.Q(j7, (byte) (((j4 >>> 35) & 127) | 128));
            long j8 = this.f33185h;
            this.f33185h = j8 - 1;
            UnsafeUtil.Q(j8, (byte) (((j4 >>> 28) & 127) | 128));
            long j9 = this.f33185h;
            this.f33185h = j9 - 1;
            UnsafeUtil.Q(j9, (byte) (((j4 >>> 21) & 127) | 128));
            long j10 = this.f33185h;
            this.f33185h = j10 - 1;
            UnsafeUtil.Q(j10, (byte) (((j4 >>> 14) & 127) | 128));
            long j11 = this.f33185h;
            this.f33185h = j11 - 1;
            UnsafeUtil.Q(j11, (byte) (((j4 >>> 7) & 127) | 128));
            long j12 = this.f33185h;
            this.f33185h = j12 - 1;
            UnsafeUtil.Q(j12, (byte) ((j4 & 127) | 128));
        }

        private void d0(long j4) {
            long j5 = this.f33185h;
            this.f33185h = j5 - 1;
            UnsafeUtil.Q(j5, (byte) (j4 >>> 28));
            long j6 = this.f33185h;
            this.f33185h = j6 - 1;
            UnsafeUtil.Q(j6, (byte) (((j4 >>> 21) & 127) | 128));
            long j7 = this.f33185h;
            this.f33185h = j7 - 1;
            UnsafeUtil.Q(j7, (byte) (((j4 >>> 14) & 127) | 128));
            long j8 = this.f33185h;
            this.f33185h = j8 - 1;
            UnsafeUtil.Q(j8, (byte) (((j4 >>> 7) & 127) | 128));
            long j9 = this.f33185h;
            this.f33185h = j9 - 1;
            UnsafeUtil.Q(j9, (byte) ((j4 & 127) | 128));
        }

        private void e0(long j4) {
            long j5 = this.f33185h;
            this.f33185h = j5 - 1;
            UnsafeUtil.Q(j5, (byte) (j4 >>> 21));
            long j6 = this.f33185h;
            this.f33185h = j6 - 1;
            UnsafeUtil.Q(j6, (byte) (((j4 >>> 14) & 127) | 128));
            long j7 = this.f33185h;
            this.f33185h = j7 - 1;
            UnsafeUtil.Q(j7, (byte) (((j4 >>> 7) & 127) | 128));
            long j8 = this.f33185h;
            this.f33185h = j8 - 1;
            UnsafeUtil.Q(j8, (byte) ((j4 & 127) | 128));
        }

        private void f0(long j4) {
            long j5 = this.f33185h;
            this.f33185h = j5 - 1;
            UnsafeUtil.Q(j5, (byte) (j4 >>> 56));
            long j6 = this.f33185h;
            this.f33185h = j6 - 1;
            UnsafeUtil.Q(j6, (byte) (((j4 >>> 49) & 127) | 128));
            long j7 = this.f33185h;
            this.f33185h = j7 - 1;
            UnsafeUtil.Q(j7, (byte) (((j4 >>> 42) & 127) | 128));
            long j8 = this.f33185h;
            this.f33185h = j8 - 1;
            UnsafeUtil.Q(j8, (byte) (((j4 >>> 35) & 127) | 128));
            long j9 = this.f33185h;
            this.f33185h = j9 - 1;
            UnsafeUtil.Q(j9, (byte) (((j4 >>> 28) & 127) | 128));
            long j10 = this.f33185h;
            this.f33185h = j10 - 1;
            UnsafeUtil.Q(j10, (byte) (((j4 >>> 21) & 127) | 128));
            long j11 = this.f33185h;
            this.f33185h = j11 - 1;
            UnsafeUtil.Q(j11, (byte) (((j4 >>> 14) & 127) | 128));
            long j12 = this.f33185h;
            this.f33185h = j12 - 1;
            UnsafeUtil.Q(j12, (byte) (((j4 >>> 7) & 127) | 128));
            long j13 = this.f33185h;
            this.f33185h = j13 - 1;
            UnsafeUtil.Q(j13, (byte) ((j4 & 127) | 128));
        }

        private void g0(long j4) {
            long j5 = this.f33185h;
            this.f33185h = j5 - 1;
            UnsafeUtil.Q(j5, (byte) j4);
        }

        private void h0(long j4) {
            long j5 = this.f33185h;
            this.f33185h = j5 - 1;
            UnsafeUtil.Q(j5, (byte) (j4 >>> 42));
            long j6 = this.f33185h;
            this.f33185h = j6 - 1;
            UnsafeUtil.Q(j6, (byte) (((j4 >>> 35) & 127) | 128));
            long j7 = this.f33185h;
            this.f33185h = j7 - 1;
            UnsafeUtil.Q(j7, (byte) (((j4 >>> 28) & 127) | 128));
            long j8 = this.f33185h;
            this.f33185h = j8 - 1;
            UnsafeUtil.Q(j8, (byte) (((j4 >>> 21) & 127) | 128));
            long j9 = this.f33185h;
            this.f33185h = j9 - 1;
            UnsafeUtil.Q(j9, (byte) (((j4 >>> 14) & 127) | 128));
            long j10 = this.f33185h;
            this.f33185h = j10 - 1;
            UnsafeUtil.Q(j10, (byte) (((j4 >>> 7) & 127) | 128));
            long j11 = this.f33185h;
            this.f33185h = j11 - 1;
            UnsafeUtil.Q(j11, (byte) ((j4 & 127) | 128));
        }

        private void i0(long j4) {
            long j5 = this.f33185h;
            this.f33185h = j5 - 1;
            UnsafeUtil.Q(j5, (byte) (j4 >>> 35));
            long j6 = this.f33185h;
            this.f33185h = j6 - 1;
            UnsafeUtil.Q(j6, (byte) (((j4 >>> 28) & 127) | 128));
            long j7 = this.f33185h;
            this.f33185h = j7 - 1;
            UnsafeUtil.Q(j7, (byte) (((j4 >>> 21) & 127) | 128));
            long j8 = this.f33185h;
            this.f33185h = j8 - 1;
            UnsafeUtil.Q(j8, (byte) (((j4 >>> 14) & 127) | 128));
            long j9 = this.f33185h;
            this.f33185h = j9 - 1;
            UnsafeUtil.Q(j9, (byte) (((j4 >>> 7) & 127) | 128));
            long j10 = this.f33185h;
            this.f33185h = j10 - 1;
            UnsafeUtil.Q(j10, (byte) ((j4 & 127) | 128));
        }

        private void j0(long j4) {
            long j5 = this.f33185h;
            this.f33185h = j5 - 1;
            UnsafeUtil.Q(j5, (byte) (j4 >>> 63));
            long j6 = this.f33185h;
            this.f33185h = j6 - 1;
            UnsafeUtil.Q(j6, (byte) (((j4 >>> 56) & 127) | 128));
            long j7 = this.f33185h;
            this.f33185h = j7 - 1;
            UnsafeUtil.Q(j7, (byte) (((j4 >>> 49) & 127) | 128));
            long j8 = this.f33185h;
            this.f33185h = j8 - 1;
            UnsafeUtil.Q(j8, (byte) (((j4 >>> 42) & 127) | 128));
            long j9 = this.f33185h;
            this.f33185h = j9 - 1;
            UnsafeUtil.Q(j9, (byte) (((j4 >>> 35) & 127) | 128));
            long j10 = this.f33185h;
            this.f33185h = j10 - 1;
            UnsafeUtil.Q(j10, (byte) (((j4 >>> 28) & 127) | 128));
            long j11 = this.f33185h;
            this.f33185h = j11 - 1;
            UnsafeUtil.Q(j11, (byte) (((j4 >>> 21) & 127) | 128));
            long j12 = this.f33185h;
            this.f33185h = j12 - 1;
            UnsafeUtil.Q(j12, (byte) (((j4 >>> 14) & 127) | 128));
            long j13 = this.f33185h;
            this.f33185h = j13 - 1;
            UnsafeUtil.Q(j13, (byte) (((j4 >>> 7) & 127) | 128));
            long j14 = this.f33185h;
            this.f33185h = j14 - 1;
            UnsafeUtil.Q(j14, (byte) ((j4 & 127) | 128));
        }

        private void k0(long j4) {
            long j5 = this.f33185h;
            this.f33185h = j5 - 1;
            UnsafeUtil.Q(j5, (byte) (((int) j4) >>> 14));
            long j6 = this.f33185h;
            this.f33185h = j6 - 1;
            UnsafeUtil.Q(j6, (byte) (((j4 >>> 7) & 127) | 128));
            long j7 = this.f33185h;
            this.f33185h = j7 - 1;
            UnsafeUtil.Q(j7, (byte) ((j4 & 127) | 128));
        }

        private void l0(long j4) {
            long j5 = this.f33185h;
            this.f33185h = j5 - 1;
            UnsafeUtil.Q(j5, (byte) (j4 >>> 7));
            long j6 = this.f33185h;
            this.f33185h = j6 - 1;
            UnsafeUtil.Q(j6, (byte) ((((int) j4) & 127) | 128));
        }

        private int spaceLeft() {
            return Q() + 1;
        }

        @Override // com.google.protobuf.BinaryWriter
        void E(int i4) {
            O(CodedOutputStream.encodeZigZag32(i4));
        }

        @Override // com.google.protobuf.BinaryWriter
        void H(long j4) {
            P(CodedOutputStream.encodeZigZag64(j4));
        }

        @Override // com.google.protobuf.BinaryWriter
        void O(int i4) {
            if ((i4 & RangingPosition.RSSI_UNKNOWN) == 0) {
                Z(i4);
            } else if ((i4 & (-16384)) == 0) {
                b0(i4);
            } else if (((-2097152) & i4) == 0) {
                a0(i4);
            } else if (((-268435456) & i4) == 0) {
                Y(i4);
            } else {
                X(i4);
            }
        }

        @Override // com.google.protobuf.BinaryWriter
        void P(long j4) {
            switch (BinaryWriter.g(j4)) {
                case 1:
                    g0(j4);
                    return;
                case 2:
                    l0(j4);
                    return;
                case 3:
                    k0(j4);
                    return;
                case 4:
                    e0(j4);
                    return;
                case 5:
                    d0(j4);
                    return;
                case 6:
                    i0(j4);
                    return;
                case 7:
                    h0(j4);
                    return;
                case 8:
                    c0(j4);
                    return;
                case 9:
                    f0(j4);
                    return;
                case 10:
                    j0(j4);
                    return;
                default:
                    return;
            }
        }

        void S() {
            if (this.f33182e != null) {
                this.f33170d += R();
                this.f33182e.position(Q() + 1);
                this.f33182e = null;
                this.f33185h = 0L;
                this.f33184g = 0L;
            }
        }

        void W(String str) {
            char charAt;
            l(str.length());
            int length = str.length();
            while (true) {
                length--;
                if (length < 0 || (charAt = str.charAt(length)) >= 128) {
                    break;
                }
                long j4 = this.f33185h;
                this.f33185h = j4 - 1;
                UnsafeUtil.Q(j4, (byte) charAt);
            }
            if (length == -1) {
                return;
            }
            while (length >= 0) {
                char charAt2 = str.charAt(length);
                if (charAt2 < 128) {
                    long j5 = this.f33185h;
                    if (j5 >= this.f33183f) {
                        this.f33185h = j5 - 1;
                        UnsafeUtil.Q(j5, (byte) charAt2);
                        length--;
                    }
                }
                if (charAt2 < 2048) {
                    long j6 = this.f33185h;
                    if (j6 > this.f33183f) {
                        this.f33185h = j6 - 1;
                        UnsafeUtil.Q(j6, (byte) ((charAt2 & '?') | 128));
                        long j7 = this.f33185h;
                        this.f33185h = j7 - 1;
                        UnsafeUtil.Q(j7, (byte) ((charAt2 >>> 6) | 960));
                        length--;
                    }
                }
                if (charAt2 < 55296 || 57343 < charAt2) {
                    long j8 = this.f33185h;
                    if (j8 > this.f33183f + 1) {
                        this.f33185h = j8 - 1;
                        UnsafeUtil.Q(j8, (byte) ((charAt2 & '?') | 128));
                        long j9 = this.f33185h;
                        this.f33185h = j9 - 1;
                        UnsafeUtil.Q(j9, (byte) (((charAt2 >>> 6) & 63) | 128));
                        long j10 = this.f33185h;
                        this.f33185h = j10 - 1;
                        UnsafeUtil.Q(j10, (byte) ((charAt2 >>> '\f') | DimensionsKt.XXHDPI));
                        length--;
                    }
                }
                if (this.f33185h > this.f33183f + 2) {
                    if (length != 0) {
                        char charAt3 = str.charAt(length - 1);
                        if (Character.isSurrogatePair(charAt3, charAt2)) {
                            length--;
                            int codePoint = Character.toCodePoint(charAt3, charAt2);
                            long j11 = this.f33185h;
                            this.f33185h = j11 - 1;
                            UnsafeUtil.Q(j11, (byte) ((codePoint & 63) | 128));
                            long j12 = this.f33185h;
                            this.f33185h = j12 - 1;
                            UnsafeUtil.Q(j12, (byte) (((codePoint >>> 6) & 63) | 128));
                            long j13 = this.f33185h;
                            this.f33185h = j13 - 1;
                            UnsafeUtil.Q(j13, (byte) (((codePoint >>> 12) & 63) | 128));
                            long j14 = this.f33185h;
                            this.f33185h = j14 - 1;
                            UnsafeUtil.Q(j14, (byte) ((codePoint >>> 18) | 240));
                        }
                    }
                    throw new Utf8.UnpairedSurrogateException(length - 1, length);
                }
                l(length);
                length++;
                length--;
            }
        }

        @Override // com.google.protobuf.Writer
        public void c(int i4, Object obj, Schema schema) throws IOException {
            writeTag(i4, 4);
            schema.a(obj, this);
            writeTag(i4, 3);
        }

        @Override // com.google.protobuf.Writer
        public void e(int i4, Object obj, Schema schema) throws IOException {
            int totalBytesWritten = getTotalBytesWritten();
            schema.a(obj, this);
            l(10);
            O(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i4, 2);
        }

        @Override // com.google.protobuf.BinaryWriter
        public int getTotalBytesWritten() {
            return this.f33170d + R();
        }

        @Override // com.google.protobuf.BinaryWriter
        void l(int i4) {
            if (spaceLeft() < i4) {
                U(i4);
            }
        }

        @Override // com.google.protobuf.BinaryWriter
        void m(boolean z3) {
            write(z3 ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.protobuf.BinaryWriter
        void r(int i4) {
            long j4 = this.f33185h;
            this.f33185h = j4 - 1;
            UnsafeUtil.Q(j4, (byte) ((i4 >> 24) & 255));
            long j5 = this.f33185h;
            this.f33185h = j5 - 1;
            UnsafeUtil.Q(j5, (byte) ((i4 >> 16) & 255));
            long j6 = this.f33185h;
            this.f33185h = j6 - 1;
            UnsafeUtil.Q(j6, (byte) ((i4 >> 8) & 255));
            long j7 = this.f33185h;
            this.f33185h = j7 - 1;
            UnsafeUtil.Q(j7, (byte) (i4 & 255));
        }

        @Override // com.google.protobuf.BinaryWriter
        void u(long j4) {
            long j5 = this.f33185h;
            this.f33185h = j5 - 1;
            UnsafeUtil.Q(j5, (byte) (((int) (j4 >> 56)) & 255));
            long j6 = this.f33185h;
            this.f33185h = j6 - 1;
            UnsafeUtil.Q(j6, (byte) (((int) (j4 >> 48)) & 255));
            long j7 = this.f33185h;
            this.f33185h = j7 - 1;
            UnsafeUtil.Q(j7, (byte) (((int) (j4 >> 40)) & 255));
            long j8 = this.f33185h;
            this.f33185h = j8 - 1;
            UnsafeUtil.Q(j8, (byte) (((int) (j4 >> 32)) & 255));
            long j9 = this.f33185h;
            this.f33185h = j9 - 1;
            UnsafeUtil.Q(j9, (byte) (((int) (j4 >> 24)) & 255));
            long j10 = this.f33185h;
            this.f33185h = j10 - 1;
            UnsafeUtil.Q(j10, (byte) (((int) (j4 >> 16)) & 255));
            long j11 = this.f33185h;
            this.f33185h = j11 - 1;
            UnsafeUtil.Q(j11, (byte) (((int) (j4 >> 8)) & 255));
            long j12 = this.f33185h;
            this.f33185h = j12 - 1;
            UnsafeUtil.Q(j12, (byte) (((int) j4) & 255));
        }

        @Override // com.google.protobuf.ByteOutput
        public void write(byte b4) {
            long j4 = this.f33185h;
            this.f33185h = j4 - 1;
            UnsafeUtil.Q(j4, b4);
        }

        @Override // com.google.protobuf.Writer
        public void writeBool(int i4, boolean z3) {
            l(6);
            write(z3 ? (byte) 1 : (byte) 0);
            writeTag(i4, 0);
        }

        @Override // com.google.protobuf.Writer
        public void writeBytes(int i4, ByteString byteString) {
            try {
                byteString.y(this);
                l(10);
                O(byteString.size());
                writeTag(i4, 2);
            } catch (IOException e4) {
                throw new RuntimeException(e4);
            }
        }

        @Override // com.google.protobuf.Writer
        @Deprecated
        public void writeEndGroup(int i4) {
            writeTag(i4, 4);
        }

        @Override // com.google.protobuf.Writer
        public void writeFixed32(int i4, int i5) {
            l(9);
            r(i5);
            writeTag(i4, 5);
        }

        @Override // com.google.protobuf.Writer
        public void writeFixed64(int i4, long j4) {
            l(13);
            u(j4);
            writeTag(i4, 1);
        }

        @Override // com.google.protobuf.Writer
        public void writeInt32(int i4, int i5) {
            l(15);
            z(i5);
            writeTag(i4, 0);
        }

        @Override // com.google.protobuf.ByteOutput
        public void writeLazy(byte[] bArr, int i4, int i5) {
            if (spaceLeft() < i5) {
                this.f33170d += i5;
                this.f33169c.addFirst(AllocatedBuffer.k(bArr, i4, i5));
                T();
                return;
            }
            this.f33185h -= i5;
            this.f33182e.position(Q() + 1);
            this.f33182e.put(bArr, i4, i5);
        }

        @Override // com.google.protobuf.Writer
        public void writeMessage(int i4, Object obj) throws IOException {
            int totalBytesWritten = getTotalBytesWritten();
            Protobuf.a().e(obj, this);
            l(10);
            O(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i4, 2);
        }

        @Override // com.google.protobuf.Writer
        public void writeSInt32(int i4, int i5) {
            l(10);
            E(i5);
            writeTag(i4, 0);
        }

        @Override // com.google.protobuf.Writer
        public void writeSInt64(int i4, long j4) {
            l(15);
            H(j4);
            writeTag(i4, 0);
        }

        @Override // com.google.protobuf.Writer
        @Deprecated
        public void writeStartGroup(int i4) {
            writeTag(i4, 3);
        }

        @Override // com.google.protobuf.Writer
        public void writeString(int i4, String str) {
            int totalBytesWritten = getTotalBytesWritten();
            W(str);
            l(10);
            O(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i4, 2);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeTag(int i4, int i5) {
            O(WireFormat.a(i4, i5));
        }

        @Override // com.google.protobuf.Writer
        public void writeUInt32(int i4, int i5) {
            l(10);
            O(i5);
            writeTag(i4, 0);
        }

        @Override // com.google.protobuf.Writer
        public void writeUInt64(int i4, long j4) {
            l(15);
            P(j4);
            writeTag(i4, 0);
        }

        @Override // com.google.protobuf.BinaryWriter
        void z(int i4) {
            if (i4 >= 0) {
                O(i4);
            } else {
                P(i4);
            }
        }

        @Override // com.google.protobuf.ByteOutput
        public void write(byte[] bArr, int i4, int i5) {
            if (spaceLeft() < i5) {
                U(i5);
            }
            this.f33185h -= i5;
            this.f33182e.position(Q() + 1);
            this.f33182e.put(bArr, i4, i5);
        }

        @Override // com.google.protobuf.ByteOutput
        public void write(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            if (spaceLeft() < remaining) {
                U(remaining);
            }
            this.f33185h -= remaining;
            this.f33182e.position(Q() + 1);
            this.f33182e.put(byteBuffer);
        }

        @Override // com.google.protobuf.ByteOutput
        public void writeLazy(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            if (spaceLeft() < remaining) {
                this.f33170d += remaining;
                this.f33169c.addFirst(AllocatedBuffer.i(byteBuffer));
                T();
                return;
            }
            this.f33185h -= remaining;
            this.f33182e.position(Q() + 1);
            this.f33182e.put(byteBuffer);
        }
    }

    /* loaded from: classes6.dex */
    private static final class UnsafeHeapWriter extends BinaryWriter {

        /* renamed from: e  reason: collision with root package name */
        private AllocatedBuffer f33186e;

        /* renamed from: f  reason: collision with root package name */
        private byte[] f33187f;

        /* renamed from: g  reason: collision with root package name */
        private long f33188g;

        /* renamed from: h  reason: collision with root package name */
        private long f33189h;

        /* renamed from: i  reason: collision with root package name */
        private long f33190i;

        /* renamed from: j  reason: collision with root package name */
        private long f33191j;

        /* renamed from: k  reason: collision with root package name */
        private long f33192k;

        private int Q() {
            return (int) this.f33192k;
        }

        private void T() {
            V(j());
        }

        private void U(int i4) {
            V(k(i4));
        }

        private void V(AllocatedBuffer allocatedBuffer) {
            if (allocatedBuffer.c()) {
                S();
                this.f33169c.addFirst(allocatedBuffer);
                this.f33186e = allocatedBuffer;
                this.f33187f = allocatedBuffer.a();
                long b4 = allocatedBuffer.b();
                this.f33189h = allocatedBuffer.e() + b4;
                long g4 = b4 + allocatedBuffer.g();
                this.f33188g = g4;
                this.f33190i = g4 - 1;
                long j4 = this.f33189h - 1;
                this.f33191j = j4;
                this.f33192k = j4;
                return;
            }
            throw new RuntimeException("Allocator returned non-heap buffer");
        }

        private void X(int i4) {
            byte[] bArr = this.f33187f;
            long j4 = this.f33192k;
            this.f33192k = j4 - 1;
            UnsafeUtil.R(bArr, j4, (byte) (i4 >>> 28));
            byte[] bArr2 = this.f33187f;
            long j5 = this.f33192k;
            this.f33192k = j5 - 1;
            UnsafeUtil.R(bArr2, j5, (byte) (((i4 >>> 21) & 127) | 128));
            byte[] bArr3 = this.f33187f;
            long j6 = this.f33192k;
            this.f33192k = j6 - 1;
            UnsafeUtil.R(bArr3, j6, (byte) (((i4 >>> 14) & 127) | 128));
            byte[] bArr4 = this.f33187f;
            long j7 = this.f33192k;
            this.f33192k = j7 - 1;
            UnsafeUtil.R(bArr4, j7, (byte) (((i4 >>> 7) & 127) | 128));
            byte[] bArr5 = this.f33187f;
            long j8 = this.f33192k;
            this.f33192k = j8 - 1;
            UnsafeUtil.R(bArr5, j8, (byte) ((i4 & 127) | 128));
        }

        private void Y(int i4) {
            byte[] bArr = this.f33187f;
            long j4 = this.f33192k;
            this.f33192k = j4 - 1;
            UnsafeUtil.R(bArr, j4, (byte) (i4 >>> 21));
            byte[] bArr2 = this.f33187f;
            long j5 = this.f33192k;
            this.f33192k = j5 - 1;
            UnsafeUtil.R(bArr2, j5, (byte) (((i4 >>> 14) & 127) | 128));
            byte[] bArr3 = this.f33187f;
            long j6 = this.f33192k;
            this.f33192k = j6 - 1;
            UnsafeUtil.R(bArr3, j6, (byte) (((i4 >>> 7) & 127) | 128));
            byte[] bArr4 = this.f33187f;
            long j7 = this.f33192k;
            this.f33192k = j7 - 1;
            UnsafeUtil.R(bArr4, j7, (byte) ((i4 & 127) | 128));
        }

        private void Z(int i4) {
            byte[] bArr = this.f33187f;
            long j4 = this.f33192k;
            this.f33192k = j4 - 1;
            UnsafeUtil.R(bArr, j4, (byte) i4);
        }

        private void a0(int i4) {
            byte[] bArr = this.f33187f;
            long j4 = this.f33192k;
            this.f33192k = j4 - 1;
            UnsafeUtil.R(bArr, j4, (byte) (i4 >>> 14));
            byte[] bArr2 = this.f33187f;
            long j5 = this.f33192k;
            this.f33192k = j5 - 1;
            UnsafeUtil.R(bArr2, j5, (byte) (((i4 >>> 7) & 127) | 128));
            byte[] bArr3 = this.f33187f;
            long j6 = this.f33192k;
            this.f33192k = j6 - 1;
            UnsafeUtil.R(bArr3, j6, (byte) ((i4 & 127) | 128));
        }

        private void b0(int i4) {
            byte[] bArr = this.f33187f;
            long j4 = this.f33192k;
            this.f33192k = j4 - 1;
            UnsafeUtil.R(bArr, j4, (byte) (i4 >>> 7));
            byte[] bArr2 = this.f33187f;
            long j5 = this.f33192k;
            this.f33192k = j5 - 1;
            UnsafeUtil.R(bArr2, j5, (byte) ((i4 & 127) | 128));
        }

        private void c0(long j4) {
            byte[] bArr = this.f33187f;
            long j5 = this.f33192k;
            this.f33192k = j5 - 1;
            UnsafeUtil.R(bArr, j5, (byte) (j4 >>> 49));
            byte[] bArr2 = this.f33187f;
            long j6 = this.f33192k;
            this.f33192k = j6 - 1;
            UnsafeUtil.R(bArr2, j6, (byte) (((j4 >>> 42) & 127) | 128));
            byte[] bArr3 = this.f33187f;
            long j7 = this.f33192k;
            this.f33192k = j7 - 1;
            UnsafeUtil.R(bArr3, j7, (byte) (((j4 >>> 35) & 127) | 128));
            byte[] bArr4 = this.f33187f;
            long j8 = this.f33192k;
            this.f33192k = j8 - 1;
            UnsafeUtil.R(bArr4, j8, (byte) (((j4 >>> 28) & 127) | 128));
            byte[] bArr5 = this.f33187f;
            long j9 = this.f33192k;
            this.f33192k = j9 - 1;
            UnsafeUtil.R(bArr5, j9, (byte) (((j4 >>> 21) & 127) | 128));
            byte[] bArr6 = this.f33187f;
            long j10 = this.f33192k;
            this.f33192k = j10 - 1;
            UnsafeUtil.R(bArr6, j10, (byte) (((j4 >>> 14) & 127) | 128));
            byte[] bArr7 = this.f33187f;
            long j11 = this.f33192k;
            this.f33192k = j11 - 1;
            UnsafeUtil.R(bArr7, j11, (byte) (((j4 >>> 7) & 127) | 128));
            byte[] bArr8 = this.f33187f;
            long j12 = this.f33192k;
            this.f33192k = j12 - 1;
            UnsafeUtil.R(bArr8, j12, (byte) ((j4 & 127) | 128));
        }

        private void d0(long j4) {
            byte[] bArr = this.f33187f;
            long j5 = this.f33192k;
            this.f33192k = j5 - 1;
            UnsafeUtil.R(bArr, j5, (byte) (j4 >>> 28));
            byte[] bArr2 = this.f33187f;
            long j6 = this.f33192k;
            this.f33192k = j6 - 1;
            UnsafeUtil.R(bArr2, j6, (byte) (((j4 >>> 21) & 127) | 128));
            byte[] bArr3 = this.f33187f;
            long j7 = this.f33192k;
            this.f33192k = j7 - 1;
            UnsafeUtil.R(bArr3, j7, (byte) (((j4 >>> 14) & 127) | 128));
            byte[] bArr4 = this.f33187f;
            long j8 = this.f33192k;
            this.f33192k = j8 - 1;
            UnsafeUtil.R(bArr4, j8, (byte) (((j4 >>> 7) & 127) | 128));
            byte[] bArr5 = this.f33187f;
            long j9 = this.f33192k;
            this.f33192k = j9 - 1;
            UnsafeUtil.R(bArr5, j9, (byte) ((j4 & 127) | 128));
        }

        private void e0(long j4) {
            byte[] bArr = this.f33187f;
            long j5 = this.f33192k;
            this.f33192k = j5 - 1;
            UnsafeUtil.R(bArr, j5, (byte) (j4 >>> 21));
            byte[] bArr2 = this.f33187f;
            long j6 = this.f33192k;
            this.f33192k = j6 - 1;
            UnsafeUtil.R(bArr2, j6, (byte) (((j4 >>> 14) & 127) | 128));
            byte[] bArr3 = this.f33187f;
            long j7 = this.f33192k;
            this.f33192k = j7 - 1;
            UnsafeUtil.R(bArr3, j7, (byte) (((j4 >>> 7) & 127) | 128));
            byte[] bArr4 = this.f33187f;
            long j8 = this.f33192k;
            this.f33192k = j8 - 1;
            UnsafeUtil.R(bArr4, j8, (byte) ((j4 & 127) | 128));
        }

        private void f0(long j4) {
            byte[] bArr = this.f33187f;
            long j5 = this.f33192k;
            this.f33192k = j5 - 1;
            UnsafeUtil.R(bArr, j5, (byte) (j4 >>> 56));
            byte[] bArr2 = this.f33187f;
            long j6 = this.f33192k;
            this.f33192k = j6 - 1;
            UnsafeUtil.R(bArr2, j6, (byte) (((j4 >>> 49) & 127) | 128));
            byte[] bArr3 = this.f33187f;
            long j7 = this.f33192k;
            this.f33192k = j7 - 1;
            UnsafeUtil.R(bArr3, j7, (byte) (((j4 >>> 42) & 127) | 128));
            byte[] bArr4 = this.f33187f;
            long j8 = this.f33192k;
            this.f33192k = j8 - 1;
            UnsafeUtil.R(bArr4, j8, (byte) (((j4 >>> 35) & 127) | 128));
            byte[] bArr5 = this.f33187f;
            long j9 = this.f33192k;
            this.f33192k = j9 - 1;
            UnsafeUtil.R(bArr5, j9, (byte) (((j4 >>> 28) & 127) | 128));
            byte[] bArr6 = this.f33187f;
            long j10 = this.f33192k;
            this.f33192k = j10 - 1;
            UnsafeUtil.R(bArr6, j10, (byte) (((j4 >>> 21) & 127) | 128));
            byte[] bArr7 = this.f33187f;
            long j11 = this.f33192k;
            this.f33192k = j11 - 1;
            UnsafeUtil.R(bArr7, j11, (byte) (((j4 >>> 14) & 127) | 128));
            byte[] bArr8 = this.f33187f;
            long j12 = this.f33192k;
            this.f33192k = j12 - 1;
            UnsafeUtil.R(bArr8, j12, (byte) (((j4 >>> 7) & 127) | 128));
            byte[] bArr9 = this.f33187f;
            long j13 = this.f33192k;
            this.f33192k = j13 - 1;
            UnsafeUtil.R(bArr9, j13, (byte) ((j4 & 127) | 128));
        }

        private void g0(long j4) {
            byte[] bArr = this.f33187f;
            long j5 = this.f33192k;
            this.f33192k = j5 - 1;
            UnsafeUtil.R(bArr, j5, (byte) j4);
        }

        private void h0(long j4) {
            byte[] bArr = this.f33187f;
            long j5 = this.f33192k;
            this.f33192k = j5 - 1;
            UnsafeUtil.R(bArr, j5, (byte) (j4 >>> 42));
            byte[] bArr2 = this.f33187f;
            long j6 = this.f33192k;
            this.f33192k = j6 - 1;
            UnsafeUtil.R(bArr2, j6, (byte) (((j4 >>> 35) & 127) | 128));
            byte[] bArr3 = this.f33187f;
            long j7 = this.f33192k;
            this.f33192k = j7 - 1;
            UnsafeUtil.R(bArr3, j7, (byte) (((j4 >>> 28) & 127) | 128));
            byte[] bArr4 = this.f33187f;
            long j8 = this.f33192k;
            this.f33192k = j8 - 1;
            UnsafeUtil.R(bArr4, j8, (byte) (((j4 >>> 21) & 127) | 128));
            byte[] bArr5 = this.f33187f;
            long j9 = this.f33192k;
            this.f33192k = j9 - 1;
            UnsafeUtil.R(bArr5, j9, (byte) (((j4 >>> 14) & 127) | 128));
            byte[] bArr6 = this.f33187f;
            long j10 = this.f33192k;
            this.f33192k = j10 - 1;
            UnsafeUtil.R(bArr6, j10, (byte) (((j4 >>> 7) & 127) | 128));
            byte[] bArr7 = this.f33187f;
            long j11 = this.f33192k;
            this.f33192k = j11 - 1;
            UnsafeUtil.R(bArr7, j11, (byte) ((j4 & 127) | 128));
        }

        private void i0(long j4) {
            byte[] bArr = this.f33187f;
            long j5 = this.f33192k;
            this.f33192k = j5 - 1;
            UnsafeUtil.R(bArr, j5, (byte) (j4 >>> 35));
            byte[] bArr2 = this.f33187f;
            long j6 = this.f33192k;
            this.f33192k = j6 - 1;
            UnsafeUtil.R(bArr2, j6, (byte) (((j4 >>> 28) & 127) | 128));
            byte[] bArr3 = this.f33187f;
            long j7 = this.f33192k;
            this.f33192k = j7 - 1;
            UnsafeUtil.R(bArr3, j7, (byte) (((j4 >>> 21) & 127) | 128));
            byte[] bArr4 = this.f33187f;
            long j8 = this.f33192k;
            this.f33192k = j8 - 1;
            UnsafeUtil.R(bArr4, j8, (byte) (((j4 >>> 14) & 127) | 128));
            byte[] bArr5 = this.f33187f;
            long j9 = this.f33192k;
            this.f33192k = j9 - 1;
            UnsafeUtil.R(bArr5, j9, (byte) (((j4 >>> 7) & 127) | 128));
            byte[] bArr6 = this.f33187f;
            long j10 = this.f33192k;
            this.f33192k = j10 - 1;
            UnsafeUtil.R(bArr6, j10, (byte) ((j4 & 127) | 128));
        }

        private void j0(long j4) {
            byte[] bArr = this.f33187f;
            long j5 = this.f33192k;
            this.f33192k = j5 - 1;
            UnsafeUtil.R(bArr, j5, (byte) (j4 >>> 63));
            byte[] bArr2 = this.f33187f;
            long j6 = this.f33192k;
            this.f33192k = j6 - 1;
            UnsafeUtil.R(bArr2, j6, (byte) (((j4 >>> 56) & 127) | 128));
            byte[] bArr3 = this.f33187f;
            long j7 = this.f33192k;
            this.f33192k = j7 - 1;
            UnsafeUtil.R(bArr3, j7, (byte) (((j4 >>> 49) & 127) | 128));
            byte[] bArr4 = this.f33187f;
            long j8 = this.f33192k;
            this.f33192k = j8 - 1;
            UnsafeUtil.R(bArr4, j8, (byte) (((j4 >>> 42) & 127) | 128));
            byte[] bArr5 = this.f33187f;
            long j9 = this.f33192k;
            this.f33192k = j9 - 1;
            UnsafeUtil.R(bArr5, j9, (byte) (((j4 >>> 35) & 127) | 128));
            byte[] bArr6 = this.f33187f;
            long j10 = this.f33192k;
            this.f33192k = j10 - 1;
            UnsafeUtil.R(bArr6, j10, (byte) (((j4 >>> 28) & 127) | 128));
            byte[] bArr7 = this.f33187f;
            long j11 = this.f33192k;
            this.f33192k = j11 - 1;
            UnsafeUtil.R(bArr7, j11, (byte) (((j4 >>> 21) & 127) | 128));
            byte[] bArr8 = this.f33187f;
            long j12 = this.f33192k;
            this.f33192k = j12 - 1;
            UnsafeUtil.R(bArr8, j12, (byte) (((j4 >>> 14) & 127) | 128));
            byte[] bArr9 = this.f33187f;
            long j13 = this.f33192k;
            this.f33192k = j13 - 1;
            UnsafeUtil.R(bArr9, j13, (byte) (((j4 >>> 7) & 127) | 128));
            byte[] bArr10 = this.f33187f;
            long j14 = this.f33192k;
            this.f33192k = j14 - 1;
            UnsafeUtil.R(bArr10, j14, (byte) ((j4 & 127) | 128));
        }

        private void k0(long j4) {
            byte[] bArr = this.f33187f;
            long j5 = this.f33192k;
            this.f33192k = j5 - 1;
            UnsafeUtil.R(bArr, j5, (byte) (((int) j4) >>> 14));
            byte[] bArr2 = this.f33187f;
            long j6 = this.f33192k;
            this.f33192k = j6 - 1;
            UnsafeUtil.R(bArr2, j6, (byte) (((j4 >>> 7) & 127) | 128));
            byte[] bArr3 = this.f33187f;
            long j7 = this.f33192k;
            this.f33192k = j7 - 1;
            UnsafeUtil.R(bArr3, j7, (byte) ((j4 & 127) | 128));
        }

        private void l0(long j4) {
            byte[] bArr = this.f33187f;
            long j5 = this.f33192k;
            this.f33192k = j5 - 1;
            UnsafeUtil.R(bArr, j5, (byte) (j4 >>> 7));
            byte[] bArr2 = this.f33187f;
            long j6 = this.f33192k;
            this.f33192k = j6 - 1;
            UnsafeUtil.R(bArr2, j6, (byte) ((((int) j4) & 127) | 128));
        }

        @Override // com.google.protobuf.BinaryWriter
        void E(int i4) {
            O(CodedOutputStream.encodeZigZag32(i4));
        }

        @Override // com.google.protobuf.BinaryWriter
        void H(long j4) {
            P(CodedOutputStream.encodeZigZag64(j4));
        }

        @Override // com.google.protobuf.BinaryWriter
        void O(int i4) {
            if ((i4 & RangingPosition.RSSI_UNKNOWN) == 0) {
                Z(i4);
            } else if ((i4 & (-16384)) == 0) {
                b0(i4);
            } else if (((-2097152) & i4) == 0) {
                a0(i4);
            } else if (((-268435456) & i4) == 0) {
                Y(i4);
            } else {
                X(i4);
            }
        }

        @Override // com.google.protobuf.BinaryWriter
        void P(long j4) {
            switch (BinaryWriter.g(j4)) {
                case 1:
                    g0(j4);
                    return;
                case 2:
                    l0(j4);
                    return;
                case 3:
                    k0(j4);
                    return;
                case 4:
                    e0(j4);
                    return;
                case 5:
                    d0(j4);
                    return;
                case 6:
                    i0(j4);
                    return;
                case 7:
                    h0(j4);
                    return;
                case 8:
                    c0(j4);
                    return;
                case 9:
                    f0(j4);
                    return;
                case 10:
                    j0(j4);
                    return;
                default:
                    return;
            }
        }

        int R() {
            return (int) (this.f33191j - this.f33192k);
        }

        void S() {
            if (this.f33186e != null) {
                this.f33170d += R();
                this.f33186e.h((Q() - this.f33186e.b()) + 1);
                this.f33186e = null;
                this.f33192k = 0L;
                this.f33191j = 0L;
            }
        }

        void W(String str) {
            char charAt;
            l(str.length());
            int length = str.length();
            while (true) {
                length--;
                if (length < 0 || (charAt = str.charAt(length)) >= 128) {
                    break;
                }
                byte[] bArr = this.f33187f;
                long j4 = this.f33192k;
                this.f33192k = j4 - 1;
                UnsafeUtil.R(bArr, j4, (byte) charAt);
            }
            if (length == -1) {
                return;
            }
            while (length >= 0) {
                char charAt2 = str.charAt(length);
                if (charAt2 < 128) {
                    long j5 = this.f33192k;
                    if (j5 > this.f33190i) {
                        byte[] bArr2 = this.f33187f;
                        this.f33192k = j5 - 1;
                        UnsafeUtil.R(bArr2, j5, (byte) charAt2);
                        length--;
                    }
                }
                if (charAt2 < 2048) {
                    long j6 = this.f33192k;
                    if (j6 > this.f33188g) {
                        byte[] bArr3 = this.f33187f;
                        this.f33192k = j6 - 1;
                        UnsafeUtil.R(bArr3, j6, (byte) ((charAt2 & '?') | 128));
                        byte[] bArr4 = this.f33187f;
                        long j7 = this.f33192k;
                        this.f33192k = j7 - 1;
                        UnsafeUtil.R(bArr4, j7, (byte) ((charAt2 >>> 6) | 960));
                        length--;
                    }
                }
                if (charAt2 < 55296 || 57343 < charAt2) {
                    long j8 = this.f33192k;
                    if (j8 > this.f33188g + 1) {
                        byte[] bArr5 = this.f33187f;
                        this.f33192k = j8 - 1;
                        UnsafeUtil.R(bArr5, j8, (byte) ((charAt2 & '?') | 128));
                        byte[] bArr6 = this.f33187f;
                        long j9 = this.f33192k;
                        this.f33192k = j9 - 1;
                        UnsafeUtil.R(bArr6, j9, (byte) (((charAt2 >>> 6) & 63) | 128));
                        byte[] bArr7 = this.f33187f;
                        long j10 = this.f33192k;
                        this.f33192k = j10 - 1;
                        UnsafeUtil.R(bArr7, j10, (byte) ((charAt2 >>> '\f') | DimensionsKt.XXHDPI));
                        length--;
                    }
                }
                if (this.f33192k > this.f33188g + 2) {
                    if (length != 0) {
                        char charAt3 = str.charAt(length - 1);
                        if (Character.isSurrogatePair(charAt3, charAt2)) {
                            length--;
                            int codePoint = Character.toCodePoint(charAt3, charAt2);
                            byte[] bArr8 = this.f33187f;
                            long j11 = this.f33192k;
                            this.f33192k = j11 - 1;
                            UnsafeUtil.R(bArr8, j11, (byte) ((codePoint & 63) | 128));
                            byte[] bArr9 = this.f33187f;
                            long j12 = this.f33192k;
                            this.f33192k = j12 - 1;
                            UnsafeUtil.R(bArr9, j12, (byte) (((codePoint >>> 6) & 63) | 128));
                            byte[] bArr10 = this.f33187f;
                            long j13 = this.f33192k;
                            this.f33192k = j13 - 1;
                            UnsafeUtil.R(bArr10, j13, (byte) (((codePoint >>> 12) & 63) | 128));
                            byte[] bArr11 = this.f33187f;
                            long j14 = this.f33192k;
                            this.f33192k = j14 - 1;
                            UnsafeUtil.R(bArr11, j14, (byte) ((codePoint >>> 18) | 240));
                        }
                    }
                    throw new Utf8.UnpairedSurrogateException(length - 1, length);
                }
                l(length);
                length++;
                length--;
            }
        }

        @Override // com.google.protobuf.Writer
        public void c(int i4, Object obj, Schema schema) throws IOException {
            writeTag(i4, 4);
            schema.a(obj, this);
            writeTag(i4, 3);
        }

        @Override // com.google.protobuf.Writer
        public void e(int i4, Object obj, Schema schema) throws IOException {
            int totalBytesWritten = getTotalBytesWritten();
            schema.a(obj, this);
            l(10);
            O(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i4, 2);
        }

        @Override // com.google.protobuf.BinaryWriter
        public int getTotalBytesWritten() {
            return this.f33170d + R();
        }

        @Override // com.google.protobuf.BinaryWriter
        void l(int i4) {
            if (spaceLeft() < i4) {
                U(i4);
            }
        }

        @Override // com.google.protobuf.BinaryWriter
        void m(boolean z3) {
            write(z3 ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.protobuf.BinaryWriter
        void r(int i4) {
            byte[] bArr = this.f33187f;
            long j4 = this.f33192k;
            this.f33192k = j4 - 1;
            UnsafeUtil.R(bArr, j4, (byte) ((i4 >> 24) & 255));
            byte[] bArr2 = this.f33187f;
            long j5 = this.f33192k;
            this.f33192k = j5 - 1;
            UnsafeUtil.R(bArr2, j5, (byte) ((i4 >> 16) & 255));
            byte[] bArr3 = this.f33187f;
            long j6 = this.f33192k;
            this.f33192k = j6 - 1;
            UnsafeUtil.R(bArr3, j6, (byte) ((i4 >> 8) & 255));
            byte[] bArr4 = this.f33187f;
            long j7 = this.f33192k;
            this.f33192k = j7 - 1;
            UnsafeUtil.R(bArr4, j7, (byte) (i4 & 255));
        }

        int spaceLeft() {
            return (int) (this.f33192k - this.f33190i);
        }

        @Override // com.google.protobuf.BinaryWriter
        void u(long j4) {
            byte[] bArr = this.f33187f;
            long j5 = this.f33192k;
            this.f33192k = j5 - 1;
            UnsafeUtil.R(bArr, j5, (byte) (((int) (j4 >> 56)) & 255));
            byte[] bArr2 = this.f33187f;
            long j6 = this.f33192k;
            this.f33192k = j6 - 1;
            UnsafeUtil.R(bArr2, j6, (byte) (((int) (j4 >> 48)) & 255));
            byte[] bArr3 = this.f33187f;
            long j7 = this.f33192k;
            this.f33192k = j7 - 1;
            UnsafeUtil.R(bArr3, j7, (byte) (((int) (j4 >> 40)) & 255));
            byte[] bArr4 = this.f33187f;
            long j8 = this.f33192k;
            this.f33192k = j8 - 1;
            UnsafeUtil.R(bArr4, j8, (byte) (((int) (j4 >> 32)) & 255));
            byte[] bArr5 = this.f33187f;
            long j9 = this.f33192k;
            this.f33192k = j9 - 1;
            UnsafeUtil.R(bArr5, j9, (byte) (((int) (j4 >> 24)) & 255));
            byte[] bArr6 = this.f33187f;
            long j10 = this.f33192k;
            this.f33192k = j10 - 1;
            UnsafeUtil.R(bArr6, j10, (byte) (((int) (j4 >> 16)) & 255));
            byte[] bArr7 = this.f33187f;
            long j11 = this.f33192k;
            this.f33192k = j11 - 1;
            UnsafeUtil.R(bArr7, j11, (byte) (((int) (j4 >> 8)) & 255));
            byte[] bArr8 = this.f33187f;
            long j12 = this.f33192k;
            this.f33192k = j12 - 1;
            UnsafeUtil.R(bArr8, j12, (byte) (((int) j4) & 255));
        }

        @Override // com.google.protobuf.ByteOutput
        public void write(byte b4) {
            byte[] bArr = this.f33187f;
            long j4 = this.f33192k;
            this.f33192k = j4 - 1;
            UnsafeUtil.R(bArr, j4, b4);
        }

        @Override // com.google.protobuf.Writer
        public void writeBool(int i4, boolean z3) {
            l(6);
            write(z3 ? (byte) 1 : (byte) 0);
            writeTag(i4, 0);
        }

        @Override // com.google.protobuf.Writer
        public void writeBytes(int i4, ByteString byteString) {
            try {
                byteString.y(this);
                l(10);
                O(byteString.size());
                writeTag(i4, 2);
            } catch (IOException e4) {
                throw new RuntimeException(e4);
            }
        }

        @Override // com.google.protobuf.Writer
        public void writeEndGroup(int i4) {
            writeTag(i4, 4);
        }

        @Override // com.google.protobuf.Writer
        public void writeFixed32(int i4, int i5) {
            l(9);
            r(i5);
            writeTag(i4, 5);
        }

        @Override // com.google.protobuf.Writer
        public void writeFixed64(int i4, long j4) {
            l(13);
            u(j4);
            writeTag(i4, 1);
        }

        @Override // com.google.protobuf.Writer
        public void writeInt32(int i4, int i5) {
            l(15);
            z(i5);
            writeTag(i4, 0);
        }

        @Override // com.google.protobuf.ByteOutput
        public void writeLazy(byte[] bArr, int i4, int i5) {
            if (i4 >= 0 && i4 + i5 <= bArr.length) {
                if (spaceLeft() < i5) {
                    this.f33170d += i5;
                    this.f33169c.addFirst(AllocatedBuffer.k(bArr, i4, i5));
                    T();
                    return;
                }
                this.f33192k -= i5;
                System.arraycopy(bArr, i4, this.f33187f, Q() + 1, i5);
                return;
            }
            throw new ArrayIndexOutOfBoundsException(String.format("value.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), Integer.valueOf(i4), Integer.valueOf(i5)));
        }

        @Override // com.google.protobuf.Writer
        public void writeMessage(int i4, Object obj) throws IOException {
            int totalBytesWritten = getTotalBytesWritten();
            Protobuf.a().e(obj, this);
            l(10);
            O(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i4, 2);
        }

        @Override // com.google.protobuf.Writer
        public void writeSInt32(int i4, int i5) {
            l(10);
            E(i5);
            writeTag(i4, 0);
        }

        @Override // com.google.protobuf.Writer
        public void writeSInt64(int i4, long j4) {
            l(15);
            H(j4);
            writeTag(i4, 0);
        }

        @Override // com.google.protobuf.Writer
        public void writeStartGroup(int i4) {
            writeTag(i4, 3);
        }

        @Override // com.google.protobuf.Writer
        public void writeString(int i4, String str) {
            int totalBytesWritten = getTotalBytesWritten();
            W(str);
            l(10);
            O(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i4, 2);
        }

        @Override // com.google.protobuf.BinaryWriter
        void writeTag(int i4, int i5) {
            O(WireFormat.a(i4, i5));
        }

        @Override // com.google.protobuf.Writer
        public void writeUInt32(int i4, int i5) {
            l(10);
            O(i5);
            writeTag(i4, 0);
        }

        @Override // com.google.protobuf.Writer
        public void writeUInt64(int i4, long j4) {
            l(15);
            P(j4);
            writeTag(i4, 0);
        }

        @Override // com.google.protobuf.BinaryWriter
        void z(int i4) {
            if (i4 >= 0) {
                O(i4);
            } else {
                P(i4);
            }
        }

        @Override // com.google.protobuf.ByteOutput
        public void write(byte[] bArr, int i4, int i5) {
            if (i4 >= 0 && i4 + i5 <= bArr.length) {
                l(i5);
                this.f33192k -= i5;
                System.arraycopy(bArr, i4, this.f33187f, Q() + 1, i5);
                return;
            }
            throw new ArrayIndexOutOfBoundsException(String.format("value.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), Integer.valueOf(i4), Integer.valueOf(i5)));
        }

        @Override // com.google.protobuf.ByteOutput
        public void write(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            l(remaining);
            this.f33192k -= remaining;
            byteBuffer.get(this.f33187f, Q() + 1, remaining);
        }

        @Override // com.google.protobuf.ByteOutput
        public void writeLazy(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            if (spaceLeft() < remaining) {
                this.f33170d += remaining;
                this.f33169c.addFirst(AllocatedBuffer.i(byteBuffer));
                T();
            }
            this.f33192k -= remaining;
            byteBuffer.get(this.f33187f, Q() + 1, remaining);
        }
    }

    private final void A(int i4, IntArrayList intArrayList, boolean z3) throws IOException {
        if (z3) {
            l((intArrayList.size() * 10) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = intArrayList.size() - 1; size >= 0; size--) {
                z(intArrayList.getInt(size));
            }
            O(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i4, 2);
            return;
        }
        for (int size2 = intArrayList.size() - 1; size2 >= 0; size2--) {
            writeInt32(i4, intArrayList.getInt(size2));
        }
    }

    private final void B(int i4, List<Integer> list, boolean z3) throws IOException {
        if (z3) {
            l((list.size() * 10) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = list.size() - 1; size >= 0; size--) {
                z(list.get(size).intValue());
            }
            O(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i4, 2);
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeInt32(i4, list.get(size2).intValue());
        }
    }

    private void C(int i4, Object obj) throws IOException {
        if (obj instanceof String) {
            writeString(i4, (String) obj);
        } else {
            writeBytes(i4, (ByteString) obj);
        }
    }

    static final void D(Writer writer, int i4, WireFormat.FieldType fieldType, Object obj) throws IOException {
        switch (AnonymousClass1.f33171a[fieldType.ordinal()]) {
            case 1:
                writer.writeBool(i4, ((Boolean) obj).booleanValue());
                return;
            case 2:
                writer.writeFixed32(i4, ((Integer) obj).intValue());
                return;
            case 3:
                writer.writeFixed64(i4, ((Long) obj).longValue());
                return;
            case 4:
                writer.writeInt32(i4, ((Integer) obj).intValue());
                return;
            case 5:
                writer.writeInt64(i4, ((Long) obj).longValue());
                return;
            case 6:
                writer.writeSFixed32(i4, ((Integer) obj).intValue());
                return;
            case 7:
                writer.writeSFixed64(i4, ((Long) obj).longValue());
                return;
            case 8:
                writer.writeSInt32(i4, ((Integer) obj).intValue());
                return;
            case 9:
                writer.writeSInt64(i4, ((Long) obj).longValue());
                return;
            case 10:
                writer.writeString(i4, (String) obj);
                return;
            case 11:
                writer.writeUInt32(i4, ((Integer) obj).intValue());
                return;
            case 12:
                writer.writeUInt64(i4, ((Long) obj).longValue());
                return;
            case 13:
                writer.writeFloat(i4, ((Float) obj).floatValue());
                return;
            case 14:
                writer.writeDouble(i4, ((Double) obj).doubleValue());
                return;
            case 15:
                writer.writeMessage(i4, obj);
                return;
            case 16:
                writer.writeBytes(i4, (ByteString) obj);
                return;
            case 17:
                if (obj instanceof Internal.EnumLite) {
                    writer.writeEnum(i4, ((Internal.EnumLite) obj).getNumber());
                    return;
                } else if (obj instanceof Integer) {
                    writer.writeEnum(i4, ((Integer) obj).intValue());
                    return;
                } else {
                    throw new IllegalArgumentException("Unexpected type for enum in map.");
                }
            default:
                throw new IllegalArgumentException("Unsupported map value type for: " + fieldType);
        }
    }

    private final void F(int i4, IntArrayList intArrayList, boolean z3) throws IOException {
        if (z3) {
            l((intArrayList.size() * 5) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = intArrayList.size() - 1; size >= 0; size--) {
                E(intArrayList.getInt(size));
            }
            O(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i4, 2);
            return;
        }
        for (int size2 = intArrayList.size() - 1; size2 >= 0; size2--) {
            writeSInt32(i4, intArrayList.getInt(size2));
        }
    }

    private final void G(int i4, List<Integer> list, boolean z3) throws IOException {
        if (z3) {
            l((list.size() * 5) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = list.size() - 1; size >= 0; size--) {
                E(list.get(size).intValue());
            }
            O(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i4, 2);
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeSInt32(i4, list.get(size2).intValue());
        }
    }

    private final void I(int i4, LongArrayList longArrayList, boolean z3) throws IOException {
        if (z3) {
            l((longArrayList.size() * 10) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = longArrayList.size() - 1; size >= 0; size--) {
                H(longArrayList.getLong(size));
            }
            O(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i4, 2);
            return;
        }
        for (int size2 = longArrayList.size() - 1; size2 >= 0; size2--) {
            writeSInt64(i4, longArrayList.getLong(size2));
        }
    }

    private final void J(int i4, List<Long> list, boolean z3) throws IOException {
        if (z3) {
            l((list.size() * 10) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = list.size() - 1; size >= 0; size--) {
                H(list.get(size).longValue());
            }
            O(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i4, 2);
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeSInt64(i4, list.get(size2).longValue());
        }
    }

    private final void K(int i4, IntArrayList intArrayList, boolean z3) throws IOException {
        if (z3) {
            l((intArrayList.size() * 5) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = intArrayList.size() - 1; size >= 0; size--) {
                O(intArrayList.getInt(size));
            }
            O(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i4, 2);
            return;
        }
        for (int size2 = intArrayList.size() - 1; size2 >= 0; size2--) {
            writeUInt32(i4, intArrayList.getInt(size2));
        }
    }

    private final void L(int i4, List<Integer> list, boolean z3) throws IOException {
        if (z3) {
            l((list.size() * 5) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = list.size() - 1; size >= 0; size--) {
                O(list.get(size).intValue());
            }
            O(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i4, 2);
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeUInt32(i4, list.get(size2).intValue());
        }
    }

    private final void M(int i4, LongArrayList longArrayList, boolean z3) throws IOException {
        if (z3) {
            l((longArrayList.size() * 10) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = longArrayList.size() - 1; size >= 0; size--) {
                P(longArrayList.getLong(size));
            }
            O(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i4, 2);
            return;
        }
        for (int size2 = longArrayList.size() - 1; size2 >= 0; size2--) {
            writeUInt64(i4, longArrayList.getLong(size2));
        }
    }

    private final void N(int i4, List<Long> list, boolean z3) throws IOException {
        if (z3) {
            l((list.size() * 10) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = list.size() - 1; size >= 0; size--) {
                P(list.get(size).longValue());
            }
            O(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i4, 2);
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeUInt64(i4, list.get(size2).longValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte g(long j4) {
        byte b4;
        if (((-128) & j4) == 0) {
            return (byte) 1;
        }
        if (j4 < 0) {
            return (byte) 10;
        }
        if (((-34359738368L) & j4) != 0) {
            b4 = (byte) 6;
            j4 >>>= 28;
        } else {
            b4 = 2;
        }
        if (((-2097152) & j4) != 0) {
            b4 = (byte) (b4 + 2);
            j4 >>>= 14;
        }
        if ((j4 & (-16384)) != 0) {
            return (byte) (b4 + 1);
        }
        return b4;
    }

    private final void n(int i4, BooleanArrayList booleanArrayList, boolean z3) throws IOException {
        if (z3) {
            l(booleanArrayList.size() + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = booleanArrayList.size() - 1; size >= 0; size--) {
                m(booleanArrayList.getBoolean(size));
            }
            O(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i4, 2);
            return;
        }
        for (int size2 = booleanArrayList.size() - 1; size2 >= 0; size2--) {
            writeBool(i4, booleanArrayList.getBoolean(size2));
        }
    }

    private final void o(int i4, List<Boolean> list, boolean z3) throws IOException {
        if (z3) {
            l(list.size() + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = list.size() - 1; size >= 0; size--) {
                m(list.get(size).booleanValue());
            }
            O(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i4, 2);
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeBool(i4, list.get(size2).booleanValue());
        }
    }

    private final void p(int i4, DoubleArrayList doubleArrayList, boolean z3) throws IOException {
        if (z3) {
            l((doubleArrayList.size() * 8) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = doubleArrayList.size() - 1; size >= 0; size--) {
                u(Double.doubleToRawLongBits(doubleArrayList.getDouble(size)));
            }
            O(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i4, 2);
            return;
        }
        for (int size2 = doubleArrayList.size() - 1; size2 >= 0; size2--) {
            writeDouble(i4, doubleArrayList.getDouble(size2));
        }
    }

    private final void q(int i4, List<Double> list, boolean z3) throws IOException {
        if (z3) {
            l((list.size() * 8) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = list.size() - 1; size >= 0; size--) {
                u(Double.doubleToRawLongBits(list.get(size).doubleValue()));
            }
            O(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i4, 2);
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeDouble(i4, list.get(size2).doubleValue());
        }
    }

    private final void s(int i4, IntArrayList intArrayList, boolean z3) throws IOException {
        if (z3) {
            l((intArrayList.size() * 4) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = intArrayList.size() - 1; size >= 0; size--) {
                r(intArrayList.getInt(size));
            }
            O(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i4, 2);
            return;
        }
        for (int size2 = intArrayList.size() - 1; size2 >= 0; size2--) {
            writeFixed32(i4, intArrayList.getInt(size2));
        }
    }

    private final void t(int i4, List<Integer> list, boolean z3) throws IOException {
        if (z3) {
            l((list.size() * 4) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = list.size() - 1; size >= 0; size--) {
                r(list.get(size).intValue());
            }
            O(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i4, 2);
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeFixed32(i4, list.get(size2).intValue());
        }
    }

    private final void v(int i4, LongArrayList longArrayList, boolean z3) throws IOException {
        if (z3) {
            l((longArrayList.size() * 8) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = longArrayList.size() - 1; size >= 0; size--) {
                u(longArrayList.getLong(size));
            }
            O(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i4, 2);
            return;
        }
        for (int size2 = longArrayList.size() - 1; size2 >= 0; size2--) {
            writeFixed64(i4, longArrayList.getLong(size2));
        }
    }

    private final void w(int i4, List<Long> list, boolean z3) throws IOException {
        if (z3) {
            l((list.size() * 8) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = list.size() - 1; size >= 0; size--) {
                u(list.get(size).longValue());
            }
            O(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i4, 2);
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeFixed64(i4, list.get(size2).longValue());
        }
    }

    private final void x(int i4, FloatArrayList floatArrayList, boolean z3) throws IOException {
        if (z3) {
            l((floatArrayList.size() * 4) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = floatArrayList.size() - 1; size >= 0; size--) {
                r(Float.floatToRawIntBits(floatArrayList.getFloat(size)));
            }
            O(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i4, 2);
            return;
        }
        for (int size2 = floatArrayList.size() - 1; size2 >= 0; size2--) {
            writeFloat(i4, floatArrayList.getFloat(size2));
        }
    }

    private final void y(int i4, List<Float> list, boolean z3) throws IOException {
        if (z3) {
            l((list.size() * 4) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = list.size() - 1; size >= 0; size--) {
                r(Float.floatToRawIntBits(list.get(size).floatValue()));
            }
            O(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i4, 2);
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeFloat(i4, list.get(size2).floatValue());
        }
    }

    abstract void E(int i4);

    abstract void H(long j4);

    abstract void O(int i4);

    abstract void P(long j4);

    @Override // com.google.protobuf.Writer
    public <K, V> void a(int i4, MapEntryLite.Metadata<K, V> metadata, Map<K, V> map) throws IOException {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            int totalBytesWritten = getTotalBytesWritten();
            D(this, 2, metadata.f33471c, entry.getValue());
            D(this, 1, metadata.f33469a, entry.getKey());
            O(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i4, 2);
        }
    }

    @Override // com.google.protobuf.Writer
    public final void b(int i4, List<?> list, Schema schema) throws IOException {
        for (int size = list.size() - 1; size >= 0; size--) {
            e(i4, list.get(size), schema);
        }
    }

    @Override // com.google.protobuf.Writer
    @Deprecated
    public final void d(int i4, List<?> list, Schema schema) throws IOException {
        for (int size = list.size() - 1; size >= 0; size--) {
            c(i4, list.get(size), schema);
        }
    }

    @Override // com.google.protobuf.Writer
    public final Writer.FieldOrder fieldOrder() {
        return Writer.FieldOrder.DESCENDING;
    }

    public abstract int getTotalBytesWritten();

    final AllocatedBuffer h() {
        return this.f33167a.a(this.f33168b);
    }

    final AllocatedBuffer i(int i4) {
        return this.f33167a.a(Math.max(i4, this.f33168b));
    }

    final AllocatedBuffer j() {
        return this.f33167a.b(this.f33168b);
    }

    final AllocatedBuffer k(int i4) {
        return this.f33167a.b(Math.max(i4, this.f33168b));
    }

    abstract void l(int i4);

    abstract void m(boolean z3);

    abstract void r(int i4);

    abstract void u(long j4);

    @Override // com.google.protobuf.Writer
    public final void writeBoolList(int i4, List<Boolean> list, boolean z3) throws IOException {
        if (list instanceof BooleanArrayList) {
            n(i4, (BooleanArrayList) list, z3);
        } else {
            o(i4, list, z3);
        }
    }

    @Override // com.google.protobuf.Writer
    public final void writeBytesList(int i4, List<ByteString> list) throws IOException {
        for (int size = list.size() - 1; size >= 0; size--) {
            writeBytes(i4, list.get(size));
        }
    }

    @Override // com.google.protobuf.Writer
    public final void writeDouble(int i4, double d4) throws IOException {
        writeFixed64(i4, Double.doubleToRawLongBits(d4));
    }

    @Override // com.google.protobuf.Writer
    public final void writeDoubleList(int i4, List<Double> list, boolean z3) throws IOException {
        if (list instanceof DoubleArrayList) {
            p(i4, (DoubleArrayList) list, z3);
        } else {
            q(i4, list, z3);
        }
    }

    @Override // com.google.protobuf.Writer
    public final void writeEnum(int i4, int i5) throws IOException {
        writeInt32(i4, i5);
    }

    @Override // com.google.protobuf.Writer
    public final void writeEnumList(int i4, List<Integer> list, boolean z3) throws IOException {
        writeInt32List(i4, list, z3);
    }

    @Override // com.google.protobuf.Writer
    public final void writeFixed32List(int i4, List<Integer> list, boolean z3) throws IOException {
        if (list instanceof IntArrayList) {
            s(i4, (IntArrayList) list, z3);
        } else {
            t(i4, list, z3);
        }
    }

    @Override // com.google.protobuf.Writer
    public final void writeFixed64List(int i4, List<Long> list, boolean z3) throws IOException {
        if (list instanceof LongArrayList) {
            v(i4, (LongArrayList) list, z3);
        } else {
            w(i4, list, z3);
        }
    }

    @Override // com.google.protobuf.Writer
    public final void writeFloat(int i4, float f4) throws IOException {
        writeFixed32(i4, Float.floatToRawIntBits(f4));
    }

    @Override // com.google.protobuf.Writer
    public final void writeFloatList(int i4, List<Float> list, boolean z3) throws IOException {
        if (list instanceof FloatArrayList) {
            x(i4, (FloatArrayList) list, z3);
        } else {
            y(i4, list, z3);
        }
    }

    @Override // com.google.protobuf.Writer
    public final void writeInt32List(int i4, List<Integer> list, boolean z3) throws IOException {
        if (list instanceof IntArrayList) {
            A(i4, (IntArrayList) list, z3);
        } else {
            B(i4, list, z3);
        }
    }

    @Override // com.google.protobuf.Writer
    public final void writeInt64(int i4, long j4) throws IOException {
        writeUInt64(i4, j4);
    }

    @Override // com.google.protobuf.Writer
    public final void writeInt64List(int i4, List<Long> list, boolean z3) throws IOException {
        writeUInt64List(i4, list, z3);
    }

    @Override // com.google.protobuf.Writer
    public final void writeMessageSetItem(int i4, Object obj) throws IOException {
        writeTag(1, 4);
        if (obj instanceof ByteString) {
            writeBytes(3, (ByteString) obj);
        } else {
            writeMessage(3, obj);
        }
        writeUInt32(2, i4);
        writeTag(1, 3);
    }

    @Override // com.google.protobuf.Writer
    public final void writeSFixed32(int i4, int i5) throws IOException {
        writeFixed32(i4, i5);
    }

    @Override // com.google.protobuf.Writer
    public final void writeSFixed32List(int i4, List<Integer> list, boolean z3) throws IOException {
        writeFixed32List(i4, list, z3);
    }

    @Override // com.google.protobuf.Writer
    public final void writeSFixed64(int i4, long j4) throws IOException {
        writeFixed64(i4, j4);
    }

    @Override // com.google.protobuf.Writer
    public final void writeSFixed64List(int i4, List<Long> list, boolean z3) throws IOException {
        writeFixed64List(i4, list, z3);
    }

    @Override // com.google.protobuf.Writer
    public final void writeSInt32List(int i4, List<Integer> list, boolean z3) throws IOException {
        if (list instanceof IntArrayList) {
            F(i4, (IntArrayList) list, z3);
        } else {
            G(i4, list, z3);
        }
    }

    @Override // com.google.protobuf.Writer
    public final void writeSInt64List(int i4, List<Long> list, boolean z3) throws IOException {
        if (list instanceof LongArrayList) {
            I(i4, (LongArrayList) list, z3);
        } else {
            J(i4, list, z3);
        }
    }

    @Override // com.google.protobuf.Writer
    public final void writeStringList(int i4, List<String> list) throws IOException {
        if (list instanceof LazyStringList) {
            LazyStringList lazyStringList = (LazyStringList) list;
            for (int size = list.size() - 1; size >= 0; size--) {
                C(i4, lazyStringList.getRaw(size));
            }
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeString(i4, list.get(size2));
        }
    }

    abstract void writeTag(int i4, int i5);

    @Override // com.google.protobuf.Writer
    public final void writeUInt32List(int i4, List<Integer> list, boolean z3) throws IOException {
        if (list instanceof IntArrayList) {
            K(i4, (IntArrayList) list, z3);
        } else {
            L(i4, list, z3);
        }
    }

    @Override // com.google.protobuf.Writer
    public final void writeUInt64List(int i4, List<Long> list, boolean z3) throws IOException {
        if (list instanceof LongArrayList) {
            M(i4, (LongArrayList) list, z3);
        } else {
            N(i4, list, z3);
        }
    }

    abstract void z(int i4);
}
