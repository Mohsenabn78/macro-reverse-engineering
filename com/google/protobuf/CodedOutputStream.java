package com.google.protobuf;

import com.google.android.gms.nearby.uwb.RangingPosition;
import com.google.protobuf.Utf8;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes6.dex */
public abstract class CodedOutputStream extends ByteOutput {
    public static final int DEFAULT_BUFFER_SIZE = 4096;
    @Deprecated
    public static final int LITTLE_ENDIAN_32_SIZE = 4;

    /* renamed from: c  reason: collision with root package name */
    private static final Logger f33272c = Logger.getLogger(CodedOutputStream.class.getName());

    /* renamed from: d  reason: collision with root package name */
    private static final boolean f33273d = UnsafeUtil.J();

    /* renamed from: a  reason: collision with root package name */
    CodedOutputStreamWriter f33274a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f33275b;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static abstract class AbstractBufferedEncoder extends CodedOutputStream {

        /* renamed from: e  reason: collision with root package name */
        final byte[] f33276e;

        /* renamed from: f  reason: collision with root package name */
        final int f33277f;

        /* renamed from: g  reason: collision with root package name */
        int f33278g;

        /* renamed from: h  reason: collision with root package name */
        int f33279h;

        AbstractBufferedEncoder(int i4) {
            super();
            if (i4 >= 0) {
                byte[] bArr = new byte[Math.max(i4, 20)];
                this.f33276e = bArr;
                this.f33277f = bArr.length;
                return;
            }
            throw new IllegalArgumentException("bufferSize must be >= 0");
        }

        final void A(long j4) {
            if (CodedOutputStream.f33273d) {
                long j5 = this.f33278g;
                while ((j4 & (-128)) != 0) {
                    byte[] bArr = this.f33276e;
                    int i4 = this.f33278g;
                    this.f33278g = i4 + 1;
                    UnsafeUtil.R(bArr, i4, (byte) ((((int) j4) & 127) | 128));
                    j4 >>>= 7;
                }
                byte[] bArr2 = this.f33276e;
                int i5 = this.f33278g;
                this.f33278g = i5 + 1;
                UnsafeUtil.R(bArr2, i5, (byte) j4);
                this.f33279h += (int) (this.f33278g - j5);
                return;
            }
            while ((j4 & (-128)) != 0) {
                byte[] bArr3 = this.f33276e;
                int i6 = this.f33278g;
                this.f33278g = i6 + 1;
                bArr3[i6] = (byte) ((((int) j4) & 127) | 128);
                this.f33279h++;
                j4 >>>= 7;
            }
            byte[] bArr4 = this.f33276e;
            int i7 = this.f33278g;
            this.f33278g = i7 + 1;
            bArr4[i7] = (byte) j4;
            this.f33279h++;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final int getTotalBytesWritten() {
            return this.f33279h;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final int spaceLeft() {
            throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
        }

        final void u(byte b4) {
            byte[] bArr = this.f33276e;
            int i4 = this.f33278g;
            this.f33278g = i4 + 1;
            bArr[i4] = b4;
            this.f33279h++;
        }

        final void v(int i4) {
            byte[] bArr = this.f33276e;
            int i5 = this.f33278g;
            int i6 = i5 + 1;
            bArr[i5] = (byte) (i4 & 255);
            int i7 = i6 + 1;
            bArr[i6] = (byte) ((i4 >> 8) & 255);
            int i8 = i7 + 1;
            bArr[i7] = (byte) ((i4 >> 16) & 255);
            this.f33278g = i8 + 1;
            bArr[i8] = (byte) ((i4 >> 24) & 255);
            this.f33279h += 4;
        }

        final void w(long j4) {
            byte[] bArr = this.f33276e;
            int i4 = this.f33278g;
            int i5 = i4 + 1;
            bArr[i4] = (byte) (j4 & 255);
            int i6 = i5 + 1;
            bArr[i5] = (byte) ((j4 >> 8) & 255);
            int i7 = i6 + 1;
            bArr[i6] = (byte) ((j4 >> 16) & 255);
            int i8 = i7 + 1;
            bArr[i7] = (byte) (255 & (j4 >> 24));
            int i9 = i8 + 1;
            bArr[i8] = (byte) (((int) (j4 >> 32)) & 255);
            int i10 = i9 + 1;
            bArr[i9] = (byte) (((int) (j4 >> 40)) & 255);
            int i11 = i10 + 1;
            bArr[i10] = (byte) (((int) (j4 >> 48)) & 255);
            this.f33278g = i11 + 1;
            bArr[i11] = (byte) (((int) (j4 >> 56)) & 255);
            this.f33279h += 8;
        }

        final void x(int i4) {
            if (i4 >= 0) {
                z(i4);
            } else {
                A(i4);
            }
        }

        final void y(int i4, int i5) {
            z(WireFormat.a(i4, i5));
        }

        final void z(int i4) {
            if (CodedOutputStream.f33273d) {
                long j4 = this.f33278g;
                while ((i4 & RangingPosition.RSSI_UNKNOWN) != 0) {
                    byte[] bArr = this.f33276e;
                    int i5 = this.f33278g;
                    this.f33278g = i5 + 1;
                    UnsafeUtil.R(bArr, i5, (byte) ((i4 & 127) | 128));
                    i4 >>>= 7;
                }
                byte[] bArr2 = this.f33276e;
                int i6 = this.f33278g;
                this.f33278g = i6 + 1;
                UnsafeUtil.R(bArr2, i6, (byte) i4);
                this.f33279h += (int) (this.f33278g - j4);
                return;
            }
            while ((i4 & RangingPosition.RSSI_UNKNOWN) != 0) {
                byte[] bArr3 = this.f33276e;
                int i7 = this.f33278g;
                this.f33278g = i7 + 1;
                bArr3[i7] = (byte) ((i4 & 127) | 128);
                this.f33279h++;
                i4 >>>= 7;
            }
            byte[] bArr4 = this.f33276e;
            int i8 = this.f33278g;
            this.f33278g = i8 + 1;
            bArr4[i8] = (byte) i4;
            this.f33279h++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class ArrayEncoder extends CodedOutputStream {

        /* renamed from: e  reason: collision with root package name */
        private final byte[] f33280e;

        /* renamed from: f  reason: collision with root package name */
        private final int f33281f;

        /* renamed from: g  reason: collision with root package name */
        private final int f33282g;

        /* renamed from: h  reason: collision with root package name */
        private int f33283h;

        ArrayEncoder(byte[] bArr, int i4, int i5) {
            super();
            if (bArr != null) {
                int i6 = i4 + i5;
                if ((i4 | i5 | (bArr.length - i6)) >= 0) {
                    this.f33280e = bArr;
                    this.f33281f = i4;
                    this.f33283h = i4;
                    this.f33282g = i6;
                    return;
                }
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), Integer.valueOf(i4), Integer.valueOf(i5)));
            }
            throw new NullPointerException("buffer");
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final int getTotalBytesWritten() {
            return this.f33283h - this.f33281f;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void q(byte[] bArr, int i4, int i5) throws IOException {
            writeUInt32NoTag(i5);
            write(bArr, i4, i5);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final int spaceLeft() {
            return this.f33282g - this.f33283h;
        }

        @Override // com.google.protobuf.CodedOutputStream
        final void t(int i4, MessageLite messageLite, Schema schema) throws IOException {
            writeTag(i4, 2);
            writeUInt32NoTag(((AbstractMessageLite) messageLite).d(schema));
            schema.a(messageLite, this.f33274a);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public final void write(byte b4) throws IOException {
            try {
                byte[] bArr = this.f33280e;
                int i4 = this.f33283h;
                this.f33283h = i4 + 1;
                bArr[i4] = b4;
            } catch (IndexOutOfBoundsException e4) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f33283h), Integer.valueOf(this.f33282g), 1), e4);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeBool(int i4, boolean z3) throws IOException {
            writeTag(i4, 0);
            write(z3 ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeByteArray(int i4, byte[] bArr) throws IOException {
            writeByteArray(i4, bArr, 0, bArr.length);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeByteBuffer(int i4, ByteBuffer byteBuffer) throws IOException {
            writeTag(i4, 2);
            writeUInt32NoTag(byteBuffer.capacity());
            writeRawBytes(byteBuffer);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeBytes(int i4, ByteString byteString) throws IOException {
            writeTag(i4, 2);
            writeBytesNoTag(byteString);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeBytesNoTag(ByteString byteString) throws IOException {
            writeUInt32NoTag(byteString.size());
            byteString.x(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeFixed32(int i4, int i5) throws IOException {
            writeTag(i4, 5);
            writeFixed32NoTag(i5);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeFixed32NoTag(int i4) throws IOException {
            try {
                byte[] bArr = this.f33280e;
                int i5 = this.f33283h;
                int i6 = i5 + 1;
                bArr[i5] = (byte) (i4 & 255);
                int i7 = i6 + 1;
                bArr[i6] = (byte) ((i4 >> 8) & 255);
                int i8 = i7 + 1;
                bArr[i7] = (byte) ((i4 >> 16) & 255);
                this.f33283h = i8 + 1;
                bArr[i8] = (byte) ((i4 >> 24) & 255);
            } catch (IndexOutOfBoundsException e4) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f33283h), Integer.valueOf(this.f33282g), 1), e4);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeFixed64(int i4, long j4) throws IOException {
            writeTag(i4, 1);
            writeFixed64NoTag(j4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeFixed64NoTag(long j4) throws IOException {
            try {
                byte[] bArr = this.f33280e;
                int i4 = this.f33283h;
                int i5 = i4 + 1;
                bArr[i4] = (byte) (((int) j4) & 255);
                int i6 = i5 + 1;
                bArr[i5] = (byte) (((int) (j4 >> 8)) & 255);
                int i7 = i6 + 1;
                bArr[i6] = (byte) (((int) (j4 >> 16)) & 255);
                int i8 = i7 + 1;
                bArr[i7] = (byte) (((int) (j4 >> 24)) & 255);
                int i9 = i8 + 1;
                bArr[i8] = (byte) (((int) (j4 >> 32)) & 255);
                int i10 = i9 + 1;
                bArr[i9] = (byte) (((int) (j4 >> 40)) & 255);
                int i11 = i10 + 1;
                bArr[i10] = (byte) (((int) (j4 >> 48)) & 255);
                this.f33283h = i11 + 1;
                bArr[i11] = (byte) (((int) (j4 >> 56)) & 255);
            } catch (IndexOutOfBoundsException e4) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f33283h), Integer.valueOf(this.f33282g), 1), e4);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeInt32(int i4, int i5) throws IOException {
            writeTag(i4, 0);
            writeInt32NoTag(i5);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeInt32NoTag(int i4) throws IOException {
            if (i4 >= 0) {
                writeUInt32NoTag(i4);
            } else {
                writeUInt64NoTag(i4);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public final void writeLazy(byte[] bArr, int i4, int i5) throws IOException {
            write(bArr, i4, i5);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeMessage(int i4, MessageLite messageLite) throws IOException {
            writeTag(i4, 2);
            writeMessageNoTag(messageLite);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeMessageNoTag(MessageLite messageLite) throws IOException {
            writeUInt32NoTag(messageLite.getSerializedSize());
            messageLite.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeMessageSetExtension(int i4, MessageLite messageLite) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i4);
            writeMessage(3, messageLite);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeRawBytes(ByteBuffer byteBuffer) throws IOException {
            if (byteBuffer.hasArray()) {
                write(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
                return;
            }
            ByteBuffer duplicate = byteBuffer.duplicate();
            duplicate.clear();
            write(duplicate);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeRawMessageSetExtension(int i4, ByteString byteString) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i4);
            writeBytes(3, byteString);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeString(int i4, String str) throws IOException {
            writeTag(i4, 2);
            writeStringNoTag(str);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeStringNoTag(String str) throws IOException {
            int i4 = this.f33283h;
            try {
                int computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(str.length() * 3);
                int computeUInt32SizeNoTag2 = CodedOutputStream.computeUInt32SizeNoTag(str.length());
                if (computeUInt32SizeNoTag2 == computeUInt32SizeNoTag) {
                    int i5 = i4 + computeUInt32SizeNoTag2;
                    this.f33283h = i5;
                    int i6 = Utf8.i(str, this.f33280e, i5, spaceLeft());
                    this.f33283h = i4;
                    writeUInt32NoTag((i6 - i4) - computeUInt32SizeNoTag2);
                    this.f33283h = i6;
                } else {
                    writeUInt32NoTag(Utf8.k(str));
                    this.f33283h = Utf8.i(str, this.f33280e, this.f33283h, spaceLeft());
                }
            } catch (Utf8.UnpairedSurrogateException e4) {
                this.f33283h = i4;
                m(str, e4);
            } catch (IndexOutOfBoundsException e5) {
                throw new OutOfSpaceException(e5);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeTag(int i4, int i5) throws IOException {
            writeUInt32NoTag(WireFormat.a(i4, i5));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeUInt32(int i4, int i5) throws IOException {
            writeTag(i4, 0);
            writeUInt32NoTag(i5);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeUInt32NoTag(int i4) throws IOException {
            while ((i4 & RangingPosition.RSSI_UNKNOWN) != 0) {
                try {
                    byte[] bArr = this.f33280e;
                    int i5 = this.f33283h;
                    this.f33283h = i5 + 1;
                    bArr[i5] = (byte) ((i4 & 127) | 128);
                    i4 >>>= 7;
                } catch (IndexOutOfBoundsException e4) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f33283h), Integer.valueOf(this.f33282g), 1), e4);
                }
            }
            byte[] bArr2 = this.f33280e;
            int i6 = this.f33283h;
            this.f33283h = i6 + 1;
            bArr2[i6] = (byte) i4;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeUInt64(int i4, long j4) throws IOException {
            writeTag(i4, 0);
            writeUInt64NoTag(j4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeUInt64NoTag(long j4) throws IOException {
            if (CodedOutputStream.f33273d && spaceLeft() >= 10) {
                while ((j4 & (-128)) != 0) {
                    byte[] bArr = this.f33280e;
                    int i4 = this.f33283h;
                    this.f33283h = i4 + 1;
                    UnsafeUtil.R(bArr, i4, (byte) ((((int) j4) & 127) | 128));
                    j4 >>>= 7;
                }
                byte[] bArr2 = this.f33280e;
                int i5 = this.f33283h;
                this.f33283h = i5 + 1;
                UnsafeUtil.R(bArr2, i5, (byte) j4);
                return;
            }
            while ((j4 & (-128)) != 0) {
                try {
                    byte[] bArr3 = this.f33280e;
                    int i6 = this.f33283h;
                    this.f33283h = i6 + 1;
                    bArr3[i6] = (byte) ((((int) j4) & 127) | 128);
                    j4 >>>= 7;
                } catch (IndexOutOfBoundsException e4) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f33283h), Integer.valueOf(this.f33282g), 1), e4);
                }
            }
            byte[] bArr4 = this.f33280e;
            int i7 = this.f33283h;
            this.f33283h = i7 + 1;
            bArr4[i7] = (byte) j4;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeByteArray(int i4, byte[] bArr, int i5, int i6) throws IOException {
            writeTag(i4, 2);
            q(bArr, i5, i6);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public final void writeLazy(ByteBuffer byteBuffer) throws IOException {
            write(byteBuffer);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public final void write(byte[] bArr, int i4, int i5) throws IOException {
            try {
                System.arraycopy(bArr, i4, this.f33280e, this.f33283h, i5);
                this.f33283h += i5;
            } catch (IndexOutOfBoundsException e4) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f33283h), Integer.valueOf(this.f33282g), Integer.valueOf(i5)), e4);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public final void write(ByteBuffer byteBuffer) throws IOException {
            int remaining = byteBuffer.remaining();
            try {
                byteBuffer.get(this.f33280e, this.f33283h, remaining);
                this.f33283h += remaining;
            } catch (IndexOutOfBoundsException e4) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f33283h), Integer.valueOf(this.f33282g), Integer.valueOf(remaining)), e4);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void flush() {
        }
    }

    /* loaded from: classes6.dex */
    private static final class ByteOutputEncoder extends AbstractBufferedEncoder {

        /* renamed from: i  reason: collision with root package name */
        private final ByteOutput f33284i;

        private void B() throws IOException {
            this.f33284i.write(this.f33276e, 0, this.f33278g);
            this.f33278g = 0;
        }

        private void C(int i4) throws IOException {
            if (this.f33277f - this.f33278g < i4) {
                B();
            }
        }

        void D(MessageLite messageLite, Schema schema) throws IOException {
            writeUInt32NoTag(((AbstractMessageLite) messageLite).d(schema));
            schema.a(messageLite, this.f33274a);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void flush() throws IOException {
            if (this.f33278g > 0) {
                B();
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void q(byte[] bArr, int i4, int i5) throws IOException {
            writeUInt32NoTag(i5);
            write(bArr, i4, i5);
        }

        @Override // com.google.protobuf.CodedOutputStream
        void t(int i4, MessageLite messageLite, Schema schema) throws IOException {
            writeTag(i4, 2);
            D(messageLite, schema);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(byte b4) throws IOException {
            if (this.f33278g == this.f33277f) {
                B();
            }
            u(b4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBool(int i4, boolean z3) throws IOException {
            C(11);
            y(i4, 0);
            u(z3 ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArray(int i4, byte[] bArr) throws IOException {
            writeByteArray(i4, bArr, 0, bArr.length);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteBuffer(int i4, ByteBuffer byteBuffer) throws IOException {
            writeTag(i4, 2);
            writeUInt32NoTag(byteBuffer.capacity());
            writeRawBytes(byteBuffer);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBytes(int i4, ByteString byteString) throws IOException {
            writeTag(i4, 2);
            writeBytesNoTag(byteString);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBytesNoTag(ByteString byteString) throws IOException {
            writeUInt32NoTag(byteString.size());
            byteString.x(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed32(int i4, int i5) throws IOException {
            C(14);
            y(i4, 5);
            v(i5);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed32NoTag(int i4) throws IOException {
            C(4);
            v(i4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed64(int i4, long j4) throws IOException {
            C(18);
            y(i4, 1);
            w(j4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed64NoTag(long j4) throws IOException {
            C(8);
            w(j4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeInt32(int i4, int i5) throws IOException {
            C(20);
            y(i4, 0);
            x(i5);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeInt32NoTag(int i4) throws IOException {
            if (i4 >= 0) {
                writeUInt32NoTag(i4);
            } else {
                writeUInt64NoTag(i4);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void writeLazy(byte[] bArr, int i4, int i5) throws IOException {
            flush();
            this.f33284i.writeLazy(bArr, i4, i5);
            this.f33279h += i5;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessage(int i4, MessageLite messageLite) throws IOException {
            writeTag(i4, 2);
            writeMessageNoTag(messageLite);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageNoTag(MessageLite messageLite) throws IOException {
            writeUInt32NoTag(messageLite.getSerializedSize());
            messageLite.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageSetExtension(int i4, MessageLite messageLite) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i4);
            writeMessage(3, messageLite);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeRawBytes(ByteBuffer byteBuffer) throws IOException {
            if (byteBuffer.hasArray()) {
                write(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
                return;
            }
            ByteBuffer duplicate = byteBuffer.duplicate();
            duplicate.clear();
            write(duplicate);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeRawMessageSetExtension(int i4, ByteString byteString) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i4);
            writeBytes(3, byteString);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeString(int i4, String str) throws IOException {
            writeTag(i4, 2);
            writeStringNoTag(str);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeStringNoTag(String str) throws IOException {
            int length = str.length() * 3;
            int computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(length);
            int i4 = computeUInt32SizeNoTag + length;
            int i5 = this.f33277f;
            if (i4 > i5) {
                byte[] bArr = new byte[length];
                int i6 = Utf8.i(str, bArr, 0, length);
                writeUInt32NoTag(i6);
                writeLazy(bArr, 0, i6);
                return;
            }
            if (i4 > i5 - this.f33278g) {
                B();
            }
            int i7 = this.f33278g;
            try {
                int computeUInt32SizeNoTag2 = CodedOutputStream.computeUInt32SizeNoTag(str.length());
                if (computeUInt32SizeNoTag2 == computeUInt32SizeNoTag) {
                    int i8 = i7 + computeUInt32SizeNoTag2;
                    this.f33278g = i8;
                    int i9 = Utf8.i(str, this.f33276e, i8, this.f33277f - i8);
                    this.f33278g = i7;
                    int i10 = (i9 - i7) - computeUInt32SizeNoTag2;
                    z(i10);
                    this.f33278g = i9;
                    this.f33279h += i10;
                } else {
                    int k4 = Utf8.k(str);
                    z(k4);
                    this.f33278g = Utf8.i(str, this.f33276e, this.f33278g, k4);
                    this.f33279h += k4;
                }
            } catch (Utf8.UnpairedSurrogateException e4) {
                this.f33279h -= this.f33278g - i7;
                this.f33278g = i7;
                m(str, e4);
            } catch (IndexOutOfBoundsException e5) {
                throw new OutOfSpaceException(e5);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeTag(int i4, int i5) throws IOException {
            writeUInt32NoTag(WireFormat.a(i4, i5));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt32(int i4, int i5) throws IOException {
            C(20);
            y(i4, 0);
            z(i5);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt32NoTag(int i4) throws IOException {
            C(5);
            z(i4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt64(int i4, long j4) throws IOException {
            C(20);
            y(i4, 0);
            A(j4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt64NoTag(long j4) throws IOException {
            C(10);
            A(j4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArray(int i4, byte[] bArr, int i5, int i6) throws IOException {
            writeTag(i4, 2);
            q(bArr, i5, i6);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(byte[] bArr, int i4, int i5) throws IOException {
            flush();
            this.f33284i.write(bArr, i4, i5);
            this.f33279h += i5;
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void writeLazy(ByteBuffer byteBuffer) throws IOException {
            flush();
            int remaining = byteBuffer.remaining();
            this.f33284i.writeLazy(byteBuffer);
            this.f33279h += remaining;
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(ByteBuffer byteBuffer) throws IOException {
            flush();
            int remaining = byteBuffer.remaining();
            this.f33284i.write(byteBuffer);
            this.f33279h += remaining;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class HeapNioEncoder extends ArrayEncoder {

        /* renamed from: i  reason: collision with root package name */
        private final ByteBuffer f33285i;

        /* renamed from: j  reason: collision with root package name */
        private int f33286j;

        HeapNioEncoder(ByteBuffer byteBuffer) {
            super(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
            this.f33285i = byteBuffer;
            this.f33286j = byteBuffer.position();
        }

        @Override // com.google.protobuf.CodedOutputStream.ArrayEncoder, com.google.protobuf.CodedOutputStream
        public void flush() {
            this.f33285i.position(this.f33286j + getTotalBytesWritten());
        }
    }

    /* loaded from: classes6.dex */
    public static class OutOfSpaceException extends IOException {
        private static final long serialVersionUID = -6947486886997889499L;

        OutOfSpaceException() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        OutOfSpaceException(String str) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + str);
        }

        OutOfSpaceException(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }

        OutOfSpaceException(String str, Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + str, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class OutputStreamEncoder extends AbstractBufferedEncoder {

        /* renamed from: i  reason: collision with root package name */
        private final OutputStream f33287i;

        OutputStreamEncoder(OutputStream outputStream, int i4) {
            super(i4);
            if (outputStream != null) {
                this.f33287i = outputStream;
                return;
            }
            throw new NullPointerException("out");
        }

        private void B() throws IOException {
            this.f33287i.write(this.f33276e, 0, this.f33278g);
            this.f33278g = 0;
        }

        private void C(int i4) throws IOException {
            if (this.f33277f - this.f33278g < i4) {
                B();
            }
        }

        void D(MessageLite messageLite, Schema schema) throws IOException {
            writeUInt32NoTag(((AbstractMessageLite) messageLite).d(schema));
            schema.a(messageLite, this.f33274a);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void flush() throws IOException {
            if (this.f33278g > 0) {
                B();
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void q(byte[] bArr, int i4, int i5) throws IOException {
            writeUInt32NoTag(i5);
            write(bArr, i4, i5);
        }

        @Override // com.google.protobuf.CodedOutputStream
        void t(int i4, MessageLite messageLite, Schema schema) throws IOException {
            writeTag(i4, 2);
            D(messageLite, schema);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(byte b4) throws IOException {
            if (this.f33278g == this.f33277f) {
                B();
            }
            u(b4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBool(int i4, boolean z3) throws IOException {
            C(11);
            y(i4, 0);
            u(z3 ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArray(int i4, byte[] bArr) throws IOException {
            writeByteArray(i4, bArr, 0, bArr.length);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteBuffer(int i4, ByteBuffer byteBuffer) throws IOException {
            writeTag(i4, 2);
            writeUInt32NoTag(byteBuffer.capacity());
            writeRawBytes(byteBuffer);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBytes(int i4, ByteString byteString) throws IOException {
            writeTag(i4, 2);
            writeBytesNoTag(byteString);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBytesNoTag(ByteString byteString) throws IOException {
            writeUInt32NoTag(byteString.size());
            byteString.x(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed32(int i4, int i5) throws IOException {
            C(14);
            y(i4, 5);
            v(i5);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed32NoTag(int i4) throws IOException {
            C(4);
            v(i4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed64(int i4, long j4) throws IOException {
            C(18);
            y(i4, 1);
            w(j4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed64NoTag(long j4) throws IOException {
            C(8);
            w(j4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeInt32(int i4, int i5) throws IOException {
            C(20);
            y(i4, 0);
            x(i5);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeInt32NoTag(int i4) throws IOException {
            if (i4 >= 0) {
                writeUInt32NoTag(i4);
            } else {
                writeUInt64NoTag(i4);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void writeLazy(byte[] bArr, int i4, int i5) throws IOException {
            write(bArr, i4, i5);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessage(int i4, MessageLite messageLite) throws IOException {
            writeTag(i4, 2);
            writeMessageNoTag(messageLite);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageNoTag(MessageLite messageLite) throws IOException {
            writeUInt32NoTag(messageLite.getSerializedSize());
            messageLite.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageSetExtension(int i4, MessageLite messageLite) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i4);
            writeMessage(3, messageLite);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeRawBytes(ByteBuffer byteBuffer) throws IOException {
            if (byteBuffer.hasArray()) {
                write(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
                return;
            }
            ByteBuffer duplicate = byteBuffer.duplicate();
            duplicate.clear();
            write(duplicate);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeRawMessageSetExtension(int i4, ByteString byteString) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i4);
            writeBytes(3, byteString);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeString(int i4, String str) throws IOException {
            writeTag(i4, 2);
            writeStringNoTag(str);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeStringNoTag(String str) throws IOException {
            int k4;
            try {
                int length = str.length() * 3;
                int computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(length);
                int i4 = computeUInt32SizeNoTag + length;
                int i5 = this.f33277f;
                if (i4 > i5) {
                    byte[] bArr = new byte[length];
                    int i6 = Utf8.i(str, bArr, 0, length);
                    writeUInt32NoTag(i6);
                    writeLazy(bArr, 0, i6);
                    return;
                }
                if (i4 > i5 - this.f33278g) {
                    B();
                }
                int computeUInt32SizeNoTag2 = CodedOutputStream.computeUInt32SizeNoTag(str.length());
                int i7 = this.f33278g;
                try {
                    if (computeUInt32SizeNoTag2 == computeUInt32SizeNoTag) {
                        int i8 = i7 + computeUInt32SizeNoTag2;
                        this.f33278g = i8;
                        int i9 = Utf8.i(str, this.f33276e, i8, this.f33277f - i8);
                        this.f33278g = i7;
                        k4 = (i9 - i7) - computeUInt32SizeNoTag2;
                        z(k4);
                        this.f33278g = i9;
                    } else {
                        k4 = Utf8.k(str);
                        z(k4);
                        this.f33278g = Utf8.i(str, this.f33276e, this.f33278g, k4);
                    }
                    this.f33279h += k4;
                } catch (Utf8.UnpairedSurrogateException e4) {
                    this.f33279h -= this.f33278g - i7;
                    this.f33278g = i7;
                    throw e4;
                } catch (ArrayIndexOutOfBoundsException e5) {
                    throw new OutOfSpaceException(e5);
                }
            } catch (Utf8.UnpairedSurrogateException e6) {
                m(str, e6);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeTag(int i4, int i5) throws IOException {
            writeUInt32NoTag(WireFormat.a(i4, i5));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt32(int i4, int i5) throws IOException {
            C(20);
            y(i4, 0);
            z(i5);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt32NoTag(int i4) throws IOException {
            C(5);
            z(i4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt64(int i4, long j4) throws IOException {
            C(20);
            y(i4, 0);
            A(j4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt64NoTag(long j4) throws IOException {
            C(10);
            A(j4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArray(int i4, byte[] bArr, int i5, int i6) throws IOException {
            writeTag(i4, 2);
            q(bArr, i5, i6);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void writeLazy(ByteBuffer byteBuffer) throws IOException {
            write(byteBuffer);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(byte[] bArr, int i4, int i5) throws IOException {
            int i6 = this.f33277f;
            int i7 = this.f33278g;
            if (i6 - i7 >= i5) {
                System.arraycopy(bArr, i4, this.f33276e, i7, i5);
                this.f33278g += i5;
                this.f33279h += i5;
                return;
            }
            int i8 = i6 - i7;
            System.arraycopy(bArr, i4, this.f33276e, i7, i8);
            int i9 = i4 + i8;
            int i10 = i5 - i8;
            this.f33278g = this.f33277f;
            this.f33279h += i8;
            B();
            if (i10 <= this.f33277f) {
                System.arraycopy(bArr, i9, this.f33276e, 0, i10);
                this.f33278g = i10;
            } else {
                this.f33287i.write(bArr, i9, i10);
            }
            this.f33279h += i10;
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(ByteBuffer byteBuffer) throws IOException {
            int remaining = byteBuffer.remaining();
            int i4 = this.f33277f;
            int i5 = this.f33278g;
            if (i4 - i5 >= remaining) {
                byteBuffer.get(this.f33276e, i5, remaining);
                this.f33278g += remaining;
                this.f33279h += remaining;
                return;
            }
            int i6 = i4 - i5;
            byteBuffer.get(this.f33276e, i5, i6);
            int i7 = remaining - i6;
            this.f33278g = this.f33277f;
            this.f33279h += i6;
            B();
            while (true) {
                int i8 = this.f33277f;
                if (i7 > i8) {
                    byteBuffer.get(this.f33276e, 0, i8);
                    this.f33287i.write(this.f33276e, 0, this.f33277f);
                    int i9 = this.f33277f;
                    i7 -= i9;
                    this.f33279h += i9;
                } else {
                    byteBuffer.get(this.f33276e, 0, i7);
                    this.f33278g = i7;
                    this.f33279h += i7;
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class SafeDirectNioEncoder extends CodedOutputStream {

        /* renamed from: e  reason: collision with root package name */
        private final ByteBuffer f33288e;

        /* renamed from: f  reason: collision with root package name */
        private final ByteBuffer f33289f;

        /* renamed from: g  reason: collision with root package name */
        private final int f33290g;

        SafeDirectNioEncoder(ByteBuffer byteBuffer) {
            super();
            this.f33288e = byteBuffer;
            this.f33289f = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            this.f33290g = byteBuffer.position();
        }

        private void u(String str) throws IOException {
            try {
                Utf8.j(str, this.f33289f);
            } catch (IndexOutOfBoundsException e4) {
                throw new OutOfSpaceException(e4);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void flush() {
            this.f33288e.position(this.f33289f.position());
        }

        @Override // com.google.protobuf.CodedOutputStream
        public int getTotalBytesWritten() {
            return this.f33289f.position() - this.f33290g;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void q(byte[] bArr, int i4, int i5) throws IOException {
            writeUInt32NoTag(i5);
            write(bArr, i4, i5);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public int spaceLeft() {
            return this.f33289f.remaining();
        }

        @Override // com.google.protobuf.CodedOutputStream
        void t(int i4, MessageLite messageLite, Schema schema) throws IOException {
            writeTag(i4, 2);
            v(messageLite, schema);
        }

        void v(MessageLite messageLite, Schema schema) throws IOException {
            writeUInt32NoTag(((AbstractMessageLite) messageLite).d(schema));
            schema.a(messageLite, this.f33274a);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(byte b4) throws IOException {
            try {
                this.f33289f.put(b4);
            } catch (BufferOverflowException e4) {
                throw new OutOfSpaceException(e4);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBool(int i4, boolean z3) throws IOException {
            writeTag(i4, 0);
            write(z3 ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArray(int i4, byte[] bArr) throws IOException {
            writeByteArray(i4, bArr, 0, bArr.length);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteBuffer(int i4, ByteBuffer byteBuffer) throws IOException {
            writeTag(i4, 2);
            writeUInt32NoTag(byteBuffer.capacity());
            writeRawBytes(byteBuffer);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBytes(int i4, ByteString byteString) throws IOException {
            writeTag(i4, 2);
            writeBytesNoTag(byteString);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBytesNoTag(ByteString byteString) throws IOException {
            writeUInt32NoTag(byteString.size());
            byteString.x(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed32(int i4, int i5) throws IOException {
            writeTag(i4, 5);
            writeFixed32NoTag(i5);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed32NoTag(int i4) throws IOException {
            try {
                this.f33289f.putInt(i4);
            } catch (BufferOverflowException e4) {
                throw new OutOfSpaceException(e4);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed64(int i4, long j4) throws IOException {
            writeTag(i4, 1);
            writeFixed64NoTag(j4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed64NoTag(long j4) throws IOException {
            try {
                this.f33289f.putLong(j4);
            } catch (BufferOverflowException e4) {
                throw new OutOfSpaceException(e4);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeInt32(int i4, int i5) throws IOException {
            writeTag(i4, 0);
            writeInt32NoTag(i5);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeInt32NoTag(int i4) throws IOException {
            if (i4 >= 0) {
                writeUInt32NoTag(i4);
            } else {
                writeUInt64NoTag(i4);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void writeLazy(byte[] bArr, int i4, int i5) throws IOException {
            write(bArr, i4, i5);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessage(int i4, MessageLite messageLite) throws IOException {
            writeTag(i4, 2);
            writeMessageNoTag(messageLite);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageNoTag(MessageLite messageLite) throws IOException {
            writeUInt32NoTag(messageLite.getSerializedSize());
            messageLite.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageSetExtension(int i4, MessageLite messageLite) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i4);
            writeMessage(3, messageLite);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeRawBytes(ByteBuffer byteBuffer) throws IOException {
            if (byteBuffer.hasArray()) {
                write(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
                return;
            }
            ByteBuffer duplicate = byteBuffer.duplicate();
            duplicate.clear();
            write(duplicate);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeRawMessageSetExtension(int i4, ByteString byteString) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i4);
            writeBytes(3, byteString);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeString(int i4, String str) throws IOException {
            writeTag(i4, 2);
            writeStringNoTag(str);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeStringNoTag(String str) throws IOException {
            int position = this.f33289f.position();
            try {
                int computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(str.length() * 3);
                int computeUInt32SizeNoTag2 = CodedOutputStream.computeUInt32SizeNoTag(str.length());
                if (computeUInt32SizeNoTag2 == computeUInt32SizeNoTag) {
                    int position2 = this.f33289f.position() + computeUInt32SizeNoTag2;
                    this.f33289f.position(position2);
                    u(str);
                    int position3 = this.f33289f.position();
                    this.f33289f.position(position);
                    writeUInt32NoTag(position3 - position2);
                    this.f33289f.position(position3);
                } else {
                    writeUInt32NoTag(Utf8.k(str));
                    u(str);
                }
            } catch (Utf8.UnpairedSurrogateException e4) {
                this.f33289f.position(position);
                m(str, e4);
            } catch (IllegalArgumentException e5) {
                throw new OutOfSpaceException(e5);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeTag(int i4, int i5) throws IOException {
            writeUInt32NoTag(WireFormat.a(i4, i5));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt32(int i4, int i5) throws IOException {
            writeTag(i4, 0);
            writeUInt32NoTag(i5);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt32NoTag(int i4) throws IOException {
            while ((i4 & RangingPosition.RSSI_UNKNOWN) != 0) {
                try {
                    this.f33289f.put((byte) ((i4 & 127) | 128));
                    i4 >>>= 7;
                } catch (BufferOverflowException e4) {
                    throw new OutOfSpaceException(e4);
                }
            }
            this.f33289f.put((byte) i4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt64(int i4, long j4) throws IOException {
            writeTag(i4, 0);
            writeUInt64NoTag(j4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt64NoTag(long j4) throws IOException {
            while (((-128) & j4) != 0) {
                try {
                    this.f33289f.put((byte) ((((int) j4) & 127) | 128));
                    j4 >>>= 7;
                } catch (BufferOverflowException e4) {
                    throw new OutOfSpaceException(e4);
                }
            }
            this.f33289f.put((byte) j4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArray(int i4, byte[] bArr, int i5, int i6) throws IOException {
            writeTag(i4, 2);
            q(bArr, i5, i6);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void writeLazy(ByteBuffer byteBuffer) throws IOException {
            write(byteBuffer);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(byte[] bArr, int i4, int i5) throws IOException {
            try {
                this.f33289f.put(bArr, i4, i5);
            } catch (IndexOutOfBoundsException e4) {
                throw new OutOfSpaceException(e4);
            } catch (BufferOverflowException e5) {
                throw new OutOfSpaceException(e5);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(ByteBuffer byteBuffer) throws IOException {
            try {
                this.f33289f.put(byteBuffer);
            } catch (BufferOverflowException e4) {
                throw new OutOfSpaceException(e4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class UnsafeDirectNioEncoder extends CodedOutputStream {

        /* renamed from: e  reason: collision with root package name */
        private final ByteBuffer f33291e;

        /* renamed from: f  reason: collision with root package name */
        private final ByteBuffer f33292f;

        /* renamed from: g  reason: collision with root package name */
        private final long f33293g;

        /* renamed from: h  reason: collision with root package name */
        private final long f33294h;

        /* renamed from: i  reason: collision with root package name */
        private final long f33295i;

        /* renamed from: j  reason: collision with root package name */
        private final long f33296j;

        /* renamed from: k  reason: collision with root package name */
        private long f33297k;

        UnsafeDirectNioEncoder(ByteBuffer byteBuffer) {
            super();
            this.f33291e = byteBuffer;
            this.f33292f = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            long k4 = UnsafeUtil.k(byteBuffer);
            this.f33293g = k4;
            long position = byteBuffer.position() + k4;
            this.f33294h = position;
            long limit = k4 + byteBuffer.limit();
            this.f33295i = limit;
            this.f33296j = limit - 10;
            this.f33297k = position;
        }

        private int u(long j4) {
            return (int) (j4 - this.f33293g);
        }

        static boolean v() {
            return UnsafeUtil.K();
        }

        private void w(long j4) {
            this.f33292f.position(u(j4));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void flush() {
            this.f33291e.position(u(this.f33297k));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public int getTotalBytesWritten() {
            return (int) (this.f33297k - this.f33294h);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void q(byte[] bArr, int i4, int i5) throws IOException {
            writeUInt32NoTag(i5);
            write(bArr, i4, i5);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public int spaceLeft() {
            return (int) (this.f33295i - this.f33297k);
        }

        @Override // com.google.protobuf.CodedOutputStream
        void t(int i4, MessageLite messageLite, Schema schema) throws IOException {
            writeTag(i4, 2);
            x(messageLite, schema);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(byte b4) throws IOException {
            long j4 = this.f33297k;
            if (j4 < this.f33295i) {
                this.f33297k = 1 + j4;
                UnsafeUtil.Q(j4, b4);
                return;
            }
            throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.f33297k), Long.valueOf(this.f33295i), 1));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBool(int i4, boolean z3) throws IOException {
            writeTag(i4, 0);
            write(z3 ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArray(int i4, byte[] bArr) throws IOException {
            writeByteArray(i4, bArr, 0, bArr.length);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteBuffer(int i4, ByteBuffer byteBuffer) throws IOException {
            writeTag(i4, 2);
            writeUInt32NoTag(byteBuffer.capacity());
            writeRawBytes(byteBuffer);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBytes(int i4, ByteString byteString) throws IOException {
            writeTag(i4, 2);
            writeBytesNoTag(byteString);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBytesNoTag(ByteString byteString) throws IOException {
            writeUInt32NoTag(byteString.size());
            byteString.x(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed32(int i4, int i5) throws IOException {
            writeTag(i4, 5);
            writeFixed32NoTag(i5);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed32NoTag(int i4) throws IOException {
            this.f33292f.putInt(u(this.f33297k), i4);
            this.f33297k += 4;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed64(int i4, long j4) throws IOException {
            writeTag(i4, 1);
            writeFixed64NoTag(j4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed64NoTag(long j4) throws IOException {
            this.f33292f.putLong(u(this.f33297k), j4);
            this.f33297k += 8;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeInt32(int i4, int i5) throws IOException {
            writeTag(i4, 0);
            writeInt32NoTag(i5);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeInt32NoTag(int i4) throws IOException {
            if (i4 >= 0) {
                writeUInt32NoTag(i4);
            } else {
                writeUInt64NoTag(i4);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void writeLazy(byte[] bArr, int i4, int i5) throws IOException {
            write(bArr, i4, i5);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessage(int i4, MessageLite messageLite) throws IOException {
            writeTag(i4, 2);
            writeMessageNoTag(messageLite);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageNoTag(MessageLite messageLite) throws IOException {
            writeUInt32NoTag(messageLite.getSerializedSize());
            messageLite.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageSetExtension(int i4, MessageLite messageLite) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i4);
            writeMessage(3, messageLite);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeRawBytes(ByteBuffer byteBuffer) throws IOException {
            if (byteBuffer.hasArray()) {
                write(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
                return;
            }
            ByteBuffer duplicate = byteBuffer.duplicate();
            duplicate.clear();
            write(duplicate);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeRawMessageSetExtension(int i4, ByteString byteString) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i4);
            writeBytes(3, byteString);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeString(int i4, String str) throws IOException {
            writeTag(i4, 2);
            writeStringNoTag(str);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeStringNoTag(String str) throws IOException {
            long j4 = this.f33297k;
            try {
                int computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(str.length() * 3);
                int computeUInt32SizeNoTag2 = CodedOutputStream.computeUInt32SizeNoTag(str.length());
                if (computeUInt32SizeNoTag2 == computeUInt32SizeNoTag) {
                    int u3 = u(this.f33297k) + computeUInt32SizeNoTag2;
                    this.f33292f.position(u3);
                    Utf8.j(str, this.f33292f);
                    int position = this.f33292f.position() - u3;
                    writeUInt32NoTag(position);
                    this.f33297k += position;
                } else {
                    int k4 = Utf8.k(str);
                    writeUInt32NoTag(k4);
                    w(this.f33297k);
                    Utf8.j(str, this.f33292f);
                    this.f33297k += k4;
                }
            } catch (Utf8.UnpairedSurrogateException e4) {
                this.f33297k = j4;
                w(j4);
                m(str, e4);
            } catch (IllegalArgumentException e5) {
                throw new OutOfSpaceException(e5);
            } catch (IndexOutOfBoundsException e6) {
                throw new OutOfSpaceException(e6);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeTag(int i4, int i5) throws IOException {
            writeUInt32NoTag(WireFormat.a(i4, i5));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt32(int i4, int i5) throws IOException {
            writeTag(i4, 0);
            writeUInt32NoTag(i5);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt32NoTag(int i4) throws IOException {
            if (this.f33297k <= this.f33296j) {
                while ((i4 & RangingPosition.RSSI_UNKNOWN) != 0) {
                    long j4 = this.f33297k;
                    this.f33297k = j4 + 1;
                    UnsafeUtil.Q(j4, (byte) ((i4 & 127) | 128));
                    i4 >>>= 7;
                }
                long j5 = this.f33297k;
                this.f33297k = 1 + j5;
                UnsafeUtil.Q(j5, (byte) i4);
                return;
            }
            while (true) {
                long j6 = this.f33297k;
                if (j6 < this.f33295i) {
                    if ((i4 & RangingPosition.RSSI_UNKNOWN) == 0) {
                        this.f33297k = 1 + j6;
                        UnsafeUtil.Q(j6, (byte) i4);
                        return;
                    }
                    this.f33297k = j6 + 1;
                    UnsafeUtil.Q(j6, (byte) ((i4 & 127) | 128));
                    i4 >>>= 7;
                } else {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.f33297k), Long.valueOf(this.f33295i), 1));
                }
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt64(int i4, long j4) throws IOException {
            writeTag(i4, 0);
            writeUInt64NoTag(j4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt64NoTag(long j4) throws IOException {
            if (this.f33297k <= this.f33296j) {
                while ((j4 & (-128)) != 0) {
                    long j5 = this.f33297k;
                    this.f33297k = j5 + 1;
                    UnsafeUtil.Q(j5, (byte) ((((int) j4) & 127) | 128));
                    j4 >>>= 7;
                }
                long j6 = this.f33297k;
                this.f33297k = 1 + j6;
                UnsafeUtil.Q(j6, (byte) j4);
                return;
            }
            while (true) {
                long j7 = this.f33297k;
                if (j7 < this.f33295i) {
                    if ((j4 & (-128)) == 0) {
                        this.f33297k = 1 + j7;
                        UnsafeUtil.Q(j7, (byte) j4);
                        return;
                    }
                    this.f33297k = j7 + 1;
                    UnsafeUtil.Q(j7, (byte) ((((int) j4) & 127) | 128));
                    j4 >>>= 7;
                } else {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.f33297k), Long.valueOf(this.f33295i), 1));
                }
            }
        }

        void x(MessageLite messageLite, Schema schema) throws IOException {
            writeUInt32NoTag(((AbstractMessageLite) messageLite).d(schema));
            schema.a(messageLite, this.f33274a);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArray(int i4, byte[] bArr, int i5, int i6) throws IOException {
            writeTag(i4, 2);
            q(bArr, i5, i6);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void writeLazy(ByteBuffer byteBuffer) throws IOException {
            write(byteBuffer);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(byte[] bArr, int i4, int i5) throws IOException {
            if (bArr != null && i4 >= 0 && i5 >= 0 && bArr.length - i5 >= i4) {
                long j4 = i5;
                long j5 = this.f33297k;
                if (this.f33295i - j4 >= j5) {
                    UnsafeUtil.q(bArr, i4, j5, j4);
                    this.f33297k += j4;
                    return;
                }
            }
            if (bArr == null) {
                throw new NullPointerException("value");
            }
            throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.f33297k), Long.valueOf(this.f33295i), Integer.valueOf(i5)));
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(ByteBuffer byteBuffer) throws IOException {
            try {
                int remaining = byteBuffer.remaining();
                w(this.f33297k);
                this.f33292f.put(byteBuffer);
                this.f33297k += remaining;
            } catch (BufferOverflowException e4) {
                throw new OutOfSpaceException(e4);
            }
        }
    }

    public static int computeBoolSize(int i4, boolean z3) {
        return computeTagSize(i4) + computeBoolSizeNoTag(z3);
    }

    public static int computeBoolSizeNoTag(boolean z3) {
        return 1;
    }

    public static int computeByteArraySize(int i4, byte[] bArr) {
        return computeTagSize(i4) + computeByteArraySizeNoTag(bArr);
    }

    public static int computeByteArraySizeNoTag(byte[] bArr) {
        return i(bArr.length);
    }

    public static int computeByteBufferSize(int i4, ByteBuffer byteBuffer) {
        return computeTagSize(i4) + computeByteBufferSizeNoTag(byteBuffer);
    }

    public static int computeByteBufferSizeNoTag(ByteBuffer byteBuffer) {
        return i(byteBuffer.capacity());
    }

    public static int computeBytesSize(int i4, ByteString byteString) {
        return computeTagSize(i4) + computeBytesSizeNoTag(byteString);
    }

    public static int computeBytesSizeNoTag(ByteString byteString) {
        return i(byteString.size());
    }

    public static int computeDoubleSize(int i4, double d4) {
        return computeTagSize(i4) + computeDoubleSizeNoTag(d4);
    }

    public static int computeDoubleSizeNoTag(double d4) {
        return 8;
    }

    public static int computeEnumSize(int i4, int i5) {
        return computeTagSize(i4) + computeEnumSizeNoTag(i5);
    }

    public static int computeEnumSizeNoTag(int i4) {
        return computeInt32SizeNoTag(i4);
    }

    public static int computeFixed32Size(int i4, int i5) {
        return computeTagSize(i4) + computeFixed32SizeNoTag(i5);
    }

    public static int computeFixed32SizeNoTag(int i4) {
        return 4;
    }

    public static int computeFixed64Size(int i4, long j4) {
        return computeTagSize(i4) + computeFixed64SizeNoTag(j4);
    }

    public static int computeFixed64SizeNoTag(long j4) {
        return 8;
    }

    public static int computeFloatSize(int i4, float f4) {
        return computeTagSize(i4) + computeFloatSizeNoTag(f4);
    }

    public static int computeFloatSizeNoTag(float f4) {
        return 4;
    }

    @Deprecated
    public static int computeGroupSize(int i4, MessageLite messageLite) {
        return (computeTagSize(i4) * 2) + messageLite.getSerializedSize();
    }

    @InlineMe
    @Deprecated
    public static int computeGroupSizeNoTag(MessageLite messageLite) {
        return messageLite.getSerializedSize();
    }

    public static int computeInt32Size(int i4, int i5) {
        return computeTagSize(i4) + computeInt32SizeNoTag(i5);
    }

    public static int computeInt32SizeNoTag(int i4) {
        if (i4 >= 0) {
            return computeUInt32SizeNoTag(i4);
        }
        return 10;
    }

    public static int computeInt64Size(int i4, long j4) {
        return computeTagSize(i4) + computeInt64SizeNoTag(j4);
    }

    public static int computeInt64SizeNoTag(long j4) {
        return computeUInt64SizeNoTag(j4);
    }

    public static int computeLazyFieldMessageSetExtensionSize(int i4, LazyFieldLite lazyFieldLite) {
        return (computeTagSize(1) * 2) + computeUInt32Size(2, i4) + computeLazyFieldSize(3, lazyFieldLite);
    }

    public static int computeLazyFieldSize(int i4, LazyFieldLite lazyFieldLite) {
        return computeTagSize(i4) + computeLazyFieldSizeNoTag(lazyFieldLite);
    }

    public static int computeLazyFieldSizeNoTag(LazyFieldLite lazyFieldLite) {
        return i(lazyFieldLite.getSerializedSize());
    }

    public static int computeMessageSetExtensionSize(int i4, MessageLite messageLite) {
        return (computeTagSize(1) * 2) + computeUInt32Size(2, i4) + computeMessageSize(3, messageLite);
    }

    public static int computeMessageSize(int i4, MessageLite messageLite) {
        return computeTagSize(i4) + computeMessageSizeNoTag(messageLite);
    }

    public static int computeMessageSizeNoTag(MessageLite messageLite) {
        return i(messageLite.getSerializedSize());
    }

    public static int computeRawMessageSetExtensionSize(int i4, ByteString byteString) {
        return (computeTagSize(1) * 2) + computeUInt32Size(2, i4) + computeBytesSize(3, byteString);
    }

    @InlineMe
    @Deprecated
    public static int computeRawVarint32Size(int i4) {
        return computeUInt32SizeNoTag(i4);
    }

    @InlineMe
    @Deprecated
    public static int computeRawVarint64Size(long j4) {
        return computeUInt64SizeNoTag(j4);
    }

    public static int computeSFixed32Size(int i4, int i5) {
        return computeTagSize(i4) + computeSFixed32SizeNoTag(i5);
    }

    public static int computeSFixed32SizeNoTag(int i4) {
        return 4;
    }

    public static int computeSFixed64Size(int i4, long j4) {
        return computeTagSize(i4) + computeSFixed64SizeNoTag(j4);
    }

    public static int computeSFixed64SizeNoTag(long j4) {
        return 8;
    }

    public static int computeSInt32Size(int i4, int i5) {
        return computeTagSize(i4) + computeSInt32SizeNoTag(i5);
    }

    public static int computeSInt32SizeNoTag(int i4) {
        return computeUInt32SizeNoTag(encodeZigZag32(i4));
    }

    public static int computeSInt64Size(int i4, long j4) {
        return computeTagSize(i4) + computeSInt64SizeNoTag(j4);
    }

    public static int computeSInt64SizeNoTag(long j4) {
        return computeUInt64SizeNoTag(encodeZigZag64(j4));
    }

    public static int computeStringSize(int i4, String str) {
        return computeTagSize(i4) + computeStringSizeNoTag(str);
    }

    public static int computeStringSizeNoTag(String str) {
        int length;
        try {
            length = Utf8.k(str);
        } catch (Utf8.UnpairedSurrogateException unused) {
            length = str.getBytes(Internal.f33419b).length;
        }
        return i(length);
    }

    public static int computeTagSize(int i4) {
        return computeUInt32SizeNoTag(WireFormat.a(i4, 0));
    }

    public static int computeUInt32Size(int i4, int i5) {
        return computeTagSize(i4) + computeUInt32SizeNoTag(i5);
    }

    public static int computeUInt32SizeNoTag(int i4) {
        if ((i4 & RangingPosition.RSSI_UNKNOWN) == 0) {
            return 1;
        }
        if ((i4 & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i4) == 0) {
            return 3;
        }
        if ((i4 & (-268435456)) == 0) {
            return 4;
        }
        return 5;
    }

    public static int computeUInt64Size(int i4, long j4) {
        return computeTagSize(i4) + computeUInt64SizeNoTag(j4);
    }

    public static int computeUInt64SizeNoTag(long j4) {
        int i4;
        if (((-128) & j4) == 0) {
            return 1;
        }
        if (j4 < 0) {
            return 10;
        }
        if (((-34359738368L) & j4) != 0) {
            j4 >>>= 28;
            i4 = 6;
        } else {
            i4 = 2;
        }
        if (((-2097152) & j4) != 0) {
            i4 += 2;
            j4 >>>= 14;
        }
        if ((j4 & (-16384)) != 0) {
            return i4 + 1;
        }
        return i4;
    }

    public static int encodeZigZag32(int i4) {
        return (i4 >> 31) ^ (i4 << 1);
    }

    public static long encodeZigZag64(long j4) {
        return (j4 >> 63) ^ (j4 << 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public static int g(int i4, MessageLite messageLite, Schema schema) {
        return (computeTagSize(i4) * 2) + h(messageLite, schema);
    }

    @Deprecated
    static int h(MessageLite messageLite, Schema schema) {
        return ((AbstractMessageLite) messageLite).d(schema);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int i(int i4) {
        return computeUInt32SizeNoTag(i4) + i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int j(int i4, MessageLite messageLite, Schema schema) {
        return computeTagSize(i4) + k(messageLite, schema);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int k(MessageLite messageLite, Schema schema) {
        return i(((AbstractMessageLite) messageLite).d(schema));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int l(int i4) {
        if (i4 > 4096) {
            return 4096;
        }
        return i4;
    }

    public static CodedOutputStream newInstance(OutputStream outputStream) {
        return newInstance(outputStream, 4096);
    }

    static CodedOutputStream o(ByteBuffer byteBuffer) {
        return new SafeDirectNioEncoder(byteBuffer);
    }

    static CodedOutputStream p(ByteBuffer byteBuffer) {
        return new UnsafeDirectNioEncoder(byteBuffer);
    }

    public final void checkNoSpaceLeft() {
        if (spaceLeft() == 0) {
            return;
        }
        throw new IllegalStateException("Did not write as much data as expected.");
    }

    public abstract void flush() throws IOException;

    public abstract int getTotalBytesWritten();

    final void m(String str, Utf8.UnpairedSurrogateException unpairedSurrogateException) throws IOException {
        f33272c.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) unpairedSurrogateException);
        byte[] bytes = str.getBytes(Internal.f33419b);
        try {
            writeUInt32NoTag(bytes.length);
            writeLazy(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e4) {
            throw new OutOfSpaceException(e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean n() {
        return this.f33275b;
    }

    abstract void q(byte[] bArr, int i4, int i5) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public final void r(int i4, MessageLite messageLite, Schema schema) throws IOException {
        writeTag(i4, 3);
        s(messageLite, schema);
        writeTag(i4, 4);
    }

    @Deprecated
    final void s(MessageLite messageLite, Schema schema) throws IOException {
        schema.a(messageLite, this.f33274a);
    }

    public abstract int spaceLeft();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void t(int i4, MessageLite messageLite, Schema schema) throws IOException;

    public void useDeterministicSerialization() {
        this.f33275b = true;
    }

    @Override // com.google.protobuf.ByteOutput
    public abstract void write(byte b4) throws IOException;

    @Override // com.google.protobuf.ByteOutput
    public abstract void write(ByteBuffer byteBuffer) throws IOException;

    @Override // com.google.protobuf.ByteOutput
    public abstract void write(byte[] bArr, int i4, int i5) throws IOException;

    public abstract void writeBool(int i4, boolean z3) throws IOException;

    public final void writeBoolNoTag(boolean z3) throws IOException {
        write(z3 ? (byte) 1 : (byte) 0);
    }

    public abstract void writeByteArray(int i4, byte[] bArr) throws IOException;

    public abstract void writeByteArray(int i4, byte[] bArr, int i5, int i6) throws IOException;

    public final void writeByteArrayNoTag(byte[] bArr) throws IOException {
        q(bArr, 0, bArr.length);
    }

    public abstract void writeByteBuffer(int i4, ByteBuffer byteBuffer) throws IOException;

    public abstract void writeBytes(int i4, ByteString byteString) throws IOException;

    public abstract void writeBytesNoTag(ByteString byteString) throws IOException;

    public final void writeDouble(int i4, double d4) throws IOException {
        writeFixed64(i4, Double.doubleToRawLongBits(d4));
    }

    public final void writeDoubleNoTag(double d4) throws IOException {
        writeFixed64NoTag(Double.doubleToRawLongBits(d4));
    }

    public final void writeEnum(int i4, int i5) throws IOException {
        writeInt32(i4, i5);
    }

    public final void writeEnumNoTag(int i4) throws IOException {
        writeInt32NoTag(i4);
    }

    public abstract void writeFixed32(int i4, int i5) throws IOException;

    public abstract void writeFixed32NoTag(int i4) throws IOException;

    public abstract void writeFixed64(int i4, long j4) throws IOException;

    public abstract void writeFixed64NoTag(long j4) throws IOException;

    public final void writeFloat(int i4, float f4) throws IOException {
        writeFixed32(i4, Float.floatToRawIntBits(f4));
    }

    public final void writeFloatNoTag(float f4) throws IOException {
        writeFixed32NoTag(Float.floatToRawIntBits(f4));
    }

    @Deprecated
    public final void writeGroup(int i4, MessageLite messageLite) throws IOException {
        writeTag(i4, 3);
        writeGroupNoTag(messageLite);
        writeTag(i4, 4);
    }

    @Deprecated
    public final void writeGroupNoTag(MessageLite messageLite) throws IOException {
        messageLite.writeTo(this);
    }

    public abstract void writeInt32(int i4, int i5) throws IOException;

    public abstract void writeInt32NoTag(int i4) throws IOException;

    public final void writeInt64(int i4, long j4) throws IOException {
        writeUInt64(i4, j4);
    }

    public final void writeInt64NoTag(long j4) throws IOException {
        writeUInt64NoTag(j4);
    }

    @Override // com.google.protobuf.ByteOutput
    public abstract void writeLazy(ByteBuffer byteBuffer) throws IOException;

    @Override // com.google.protobuf.ByteOutput
    public abstract void writeLazy(byte[] bArr, int i4, int i5) throws IOException;

    public abstract void writeMessage(int i4, MessageLite messageLite) throws IOException;

    public abstract void writeMessageNoTag(MessageLite messageLite) throws IOException;

    public abstract void writeMessageSetExtension(int i4, MessageLite messageLite) throws IOException;

    public final void writeRawByte(byte b4) throws IOException {
        write(b4);
    }

    public abstract void writeRawBytes(ByteBuffer byteBuffer) throws IOException;

    public final void writeRawBytes(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @InlineMe
    @Deprecated
    public final void writeRawLittleEndian32(int i4) throws IOException {
        writeFixed32NoTag(i4);
    }

    @InlineMe
    @Deprecated
    public final void writeRawLittleEndian64(long j4) throws IOException {
        writeFixed64NoTag(j4);
    }

    public abstract void writeRawMessageSetExtension(int i4, ByteString byteString) throws IOException;

    @InlineMe
    @Deprecated
    public final void writeRawVarint32(int i4) throws IOException {
        writeUInt32NoTag(i4);
    }

    @InlineMe
    @Deprecated
    public final void writeRawVarint64(long j4) throws IOException {
        writeUInt64NoTag(j4);
    }

    public final void writeSFixed32(int i4, int i5) throws IOException {
        writeFixed32(i4, i5);
    }

    public final void writeSFixed32NoTag(int i4) throws IOException {
        writeFixed32NoTag(i4);
    }

    public final void writeSFixed64(int i4, long j4) throws IOException {
        writeFixed64(i4, j4);
    }

    public final void writeSFixed64NoTag(long j4) throws IOException {
        writeFixed64NoTag(j4);
    }

    public final void writeSInt32(int i4, int i5) throws IOException {
        writeUInt32(i4, encodeZigZag32(i5));
    }

    public final void writeSInt32NoTag(int i4) throws IOException {
        writeUInt32NoTag(encodeZigZag32(i4));
    }

    public final void writeSInt64(int i4, long j4) throws IOException {
        writeUInt64(i4, encodeZigZag64(j4));
    }

    public final void writeSInt64NoTag(long j4) throws IOException {
        writeUInt64NoTag(encodeZigZag64(j4));
    }

    public abstract void writeString(int i4, String str) throws IOException;

    public abstract void writeStringNoTag(String str) throws IOException;

    public abstract void writeTag(int i4, int i5) throws IOException;

    public abstract void writeUInt32(int i4, int i5) throws IOException;

    public abstract void writeUInt32NoTag(int i4) throws IOException;

    public abstract void writeUInt64(int i4, long j4) throws IOException;

    public abstract void writeUInt64NoTag(long j4) throws IOException;

    private CodedOutputStream() {
    }

    public static CodedOutputStream newInstance(OutputStream outputStream, int i4) {
        return new OutputStreamEncoder(outputStream, i4);
    }

    public final void writeRawByte(int i4) throws IOException {
        write((byte) i4);
    }

    public final void writeRawBytes(byte[] bArr, int i4, int i5) throws IOException {
        write(bArr, i4, i5);
    }

    public static CodedOutputStream newInstance(byte[] bArr) {
        return newInstance(bArr, 0, bArr.length);
    }

    public final void writeRawBytes(ByteString byteString) throws IOException {
        byteString.x(this);
    }

    public static CodedOutputStream newInstance(byte[] bArr, int i4, int i5) {
        return new ArrayEncoder(bArr, i4, i5);
    }

    public static CodedOutputStream newInstance(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            return new HeapNioEncoder(byteBuffer);
        }
        if (byteBuffer.isDirect() && !byteBuffer.isReadOnly()) {
            if (UnsafeDirectNioEncoder.v()) {
                return p(byteBuffer);
            }
            return o(byteBuffer);
        }
        throw new IllegalArgumentException("ByteBuffer is read-only");
    }

    @Deprecated
    public static CodedOutputStream newInstance(ByteBuffer byteBuffer, int i4) {
        return newInstance(byteBuffer);
    }
}
