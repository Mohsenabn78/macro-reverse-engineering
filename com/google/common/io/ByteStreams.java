package com.google.common.io;

import android.support.v4.media.session.PlaybackStateCompat;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
@J2ktIncompatible
@GwtIncompatible
/* loaded from: classes5.dex */
public final class ByteStreams {

    /* renamed from: a  reason: collision with root package name */
    private static final OutputStream f27975a = new OutputStream() { // from class: com.google.common.io.ByteStreams.1
        public String toString() {
            return "ByteStreams.nullOutputStream()";
        }

        @Override // java.io.OutputStream
        public void write(int i4) {
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) {
            Preconditions.checkNotNull(bArr);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i4, int i5) {
            Preconditions.checkNotNull(bArr);
            Preconditions.checkPositionIndexes(i4, i5 + i4, bArr.length);
        }
    };

    private ByteStreams() {
    }

    private static byte[] a(Queue<byte[]> queue, int i4) {
        if (queue.isEmpty()) {
            return new byte[0];
        }
        byte[] remove = queue.remove();
        if (remove.length == i4) {
            return remove;
        }
        int length = i4 - remove.length;
        byte[] copyOf = Arrays.copyOf(remove, i4);
        while (length > 0) {
            byte[] remove2 = queue.remove();
            int min = Math.min(length, remove2.length);
            System.arraycopy(remove2, 0, copyOf, i4 - length, min);
            length -= min;
        }
        return copyOf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] b() {
        return new byte[8192];
    }

    private static long c(InputStream inputStream, long j4) throws IOException {
        int available = inputStream.available();
        if (available == 0) {
            return 0L;
        }
        return inputStream.skip(Math.min(available, j4));
    }

    @CanIgnoreReturnValue
    public static long copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        Preconditions.checkNotNull(inputStream);
        Preconditions.checkNotNull(outputStream);
        byte[] b4 = b();
        long j4 = 0;
        while (true) {
            int read = inputStream.read(b4);
            if (read == -1) {
                return j4;
            }
            outputStream.write(b4, 0, read);
            j4 += read;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long d(InputStream inputStream, long j4) throws IOException {
        byte[] bArr = null;
        long j5 = 0;
        while (j5 < j4) {
            long j6 = j4 - j5;
            long c4 = c(inputStream, j6);
            if (c4 == 0) {
                int min = (int) Math.min(j6, (long) PlaybackStateCompat.ACTION_PLAY_FROM_URI);
                if (bArr == null) {
                    bArr = new byte[min];
                }
                c4 = inputStream.read(bArr, 0, min);
                if (c4 == -1) {
                    break;
                }
            }
            j5 += c4;
        }
        return j5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] e(InputStream inputStream, long j4) throws IOException {
        boolean z3;
        if (j4 >= 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "expectedSize (%s) must be non-negative", j4);
        if (j4 <= 2147483639) {
            int i4 = (int) j4;
            byte[] bArr = new byte[i4];
            int i5 = i4;
            while (i5 > 0) {
                int i6 = i4 - i5;
                int read = inputStream.read(bArr, i6, i5);
                if (read == -1) {
                    return Arrays.copyOf(bArr, i6);
                }
                i5 -= read;
            }
            int read2 = inputStream.read();
            if (read2 == -1) {
                return bArr;
            }
            ArrayDeque arrayDeque = new ArrayDeque(22);
            arrayDeque.add(bArr);
            arrayDeque.add(new byte[]{(byte) read2});
            return f(inputStream, arrayDeque, i4 + 1);
        }
        throw new OutOfMemoryError(j4 + " bytes is too large to fit in a byte array");
    }

    @CanIgnoreReturnValue
    public static long exhaust(InputStream inputStream) throws IOException {
        byte[] b4 = b();
        long j4 = 0;
        while (true) {
            long read = inputStream.read(b4);
            if (read != -1) {
                j4 += read;
            } else {
                return j4;
            }
        }
    }

    private static byte[] f(InputStream inputStream, Queue<byte[]> queue, int i4) throws IOException {
        int i5;
        int min = Math.min(8192, Math.max(128, Integer.highestOneBit(i4) * 2));
        while (i4 < 2147483639) {
            int min2 = Math.min(min, 2147483639 - i4);
            byte[] bArr = new byte[min2];
            queue.add(bArr);
            int i6 = 0;
            while (i6 < min2) {
                int read = inputStream.read(bArr, i6, min2 - i6);
                if (read == -1) {
                    return a(queue, i4);
                }
                i6 += read;
                i4 += read;
            }
            if (min < 4096) {
                i5 = 4;
            } else {
                i5 = 2;
            }
            min = IntMath.saturatedMultiply(min, i5);
        }
        if (inputStream.read() == -1) {
            return a(queue, 2147483639);
        }
        throw new OutOfMemoryError("input is too large to fit in a byte array");
    }

    public static InputStream limit(InputStream inputStream, long j4) {
        return new LimitedInputStream(inputStream, j4);
    }

    public static ByteArrayDataInput newDataInput(byte[] bArr) {
        return newDataInput(new ByteArrayInputStream(bArr));
    }

    public static ByteArrayDataOutput newDataOutput() {
        return newDataOutput(new ByteArrayOutputStream());
    }

    public static OutputStream nullOutputStream() {
        return f27975a;
    }

    @CanIgnoreReturnValue
    public static int read(InputStream inputStream, byte[] bArr, int i4, int i5) throws IOException {
        Preconditions.checkNotNull(inputStream);
        Preconditions.checkNotNull(bArr);
        int i6 = 0;
        if (i5 >= 0) {
            Preconditions.checkPositionIndexes(i4, i4 + i5, bArr.length);
            while (i6 < i5) {
                int read = inputStream.read(bArr, i4 + i6, i5 - i6);
                if (read == -1) {
                    break;
                }
                i6 += read;
            }
            return i6;
        }
        throw new IndexOutOfBoundsException(String.format("len (%s) cannot be negative", Integer.valueOf(i5)));
    }

    @CanIgnoreReturnValue
    @ParametricNullness
    public static <T> T readBytes(InputStream inputStream, ByteProcessor<T> byteProcessor) throws IOException {
        int read;
        Preconditions.checkNotNull(inputStream);
        Preconditions.checkNotNull(byteProcessor);
        byte[] b4 = b();
        do {
            read = inputStream.read(b4);
            if (read == -1) {
                break;
            }
        } while (byteProcessor.processBytes(b4, 0, read));
        return byteProcessor.getResult();
    }

    public static void readFully(InputStream inputStream, byte[] bArr) throws IOException {
        readFully(inputStream, bArr, 0, bArr.length);
    }

    public static void skipFully(InputStream inputStream, long j4) throws IOException {
        long d4 = d(inputStream, j4);
        if (d4 >= j4) {
            return;
        }
        throw new EOFException("reached end of stream after skipping " + d4 + " bytes; " + j4 + " bytes expected");
    }

    public static byte[] toByteArray(InputStream inputStream) throws IOException {
        Preconditions.checkNotNull(inputStream);
        return f(inputStream, new ArrayDeque(20), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class ByteArrayDataInputStream implements ByteArrayDataInput {

        /* renamed from: a  reason: collision with root package name */
        final DataInput f27976a;

        ByteArrayDataInputStream(ByteArrayInputStream byteArrayInputStream) {
            this.f27976a = new DataInputStream(byteArrayInputStream);
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public boolean readBoolean() {
            try {
                return this.f27976a.readBoolean();
            } catch (IOException e4) {
                throw new IllegalStateException(e4);
            }
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public byte readByte() {
            try {
                return this.f27976a.readByte();
            } catch (EOFException e4) {
                throw new IllegalStateException(e4);
            } catch (IOException e5) {
                throw new AssertionError(e5);
            }
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public char readChar() {
            try {
                return this.f27976a.readChar();
            } catch (IOException e4) {
                throw new IllegalStateException(e4);
            }
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public double readDouble() {
            try {
                return this.f27976a.readDouble();
            } catch (IOException e4) {
                throw new IllegalStateException(e4);
            }
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public float readFloat() {
            try {
                return this.f27976a.readFloat();
            } catch (IOException e4) {
                throw new IllegalStateException(e4);
            }
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public void readFully(byte[] bArr) {
            try {
                this.f27976a.readFully(bArr);
            } catch (IOException e4) {
                throw new IllegalStateException(e4);
            }
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public int readInt() {
            try {
                return this.f27976a.readInt();
            } catch (IOException e4) {
                throw new IllegalStateException(e4);
            }
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        @CheckForNull
        public String readLine() {
            try {
                return this.f27976a.readLine();
            } catch (IOException e4) {
                throw new IllegalStateException(e4);
            }
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public long readLong() {
            try {
                return this.f27976a.readLong();
            } catch (IOException e4) {
                throw new IllegalStateException(e4);
            }
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public short readShort() {
            try {
                return this.f27976a.readShort();
            } catch (IOException e4) {
                throw new IllegalStateException(e4);
            }
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public String readUTF() {
            try {
                return this.f27976a.readUTF();
            } catch (IOException e4) {
                throw new IllegalStateException(e4);
            }
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public int readUnsignedByte() {
            try {
                return this.f27976a.readUnsignedByte();
            } catch (IOException e4) {
                throw new IllegalStateException(e4);
            }
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public int readUnsignedShort() {
            try {
                return this.f27976a.readUnsignedShort();
            } catch (IOException e4) {
                throw new IllegalStateException(e4);
            }
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public int skipBytes(int i4) {
            try {
                return this.f27976a.skipBytes(i4);
            } catch (IOException e4) {
                throw new IllegalStateException(e4);
            }
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public void readFully(byte[] bArr, int i4, int i5) {
            try {
                this.f27976a.readFully(bArr, i4, i5);
            } catch (IOException e4) {
                throw new IllegalStateException(e4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class ByteArrayDataOutputStream implements ByteArrayDataOutput {

        /* renamed from: a  reason: collision with root package name */
        final DataOutput f27977a;

        /* renamed from: b  reason: collision with root package name */
        final ByteArrayOutputStream f27978b;

        ByteArrayDataOutputStream(ByteArrayOutputStream byteArrayOutputStream) {
            this.f27978b = byteArrayOutputStream;
            this.f27977a = new DataOutputStream(byteArrayOutputStream);
        }

        @Override // com.google.common.io.ByteArrayDataOutput
        public byte[] toByteArray() {
            return this.f27978b.toByteArray();
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void write(int i4) {
            try {
                this.f27977a.write(i4);
            } catch (IOException e4) {
                throw new AssertionError(e4);
            }
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeBoolean(boolean z3) {
            try {
                this.f27977a.writeBoolean(z3);
            } catch (IOException e4) {
                throw new AssertionError(e4);
            }
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeByte(int i4) {
            try {
                this.f27977a.writeByte(i4);
            } catch (IOException e4) {
                throw new AssertionError(e4);
            }
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeBytes(String str) {
            try {
                this.f27977a.writeBytes(str);
            } catch (IOException e4) {
                throw new AssertionError(e4);
            }
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeChar(int i4) {
            try {
                this.f27977a.writeChar(i4);
            } catch (IOException e4) {
                throw new AssertionError(e4);
            }
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeChars(String str) {
            try {
                this.f27977a.writeChars(str);
            } catch (IOException e4) {
                throw new AssertionError(e4);
            }
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeDouble(double d4) {
            try {
                this.f27977a.writeDouble(d4);
            } catch (IOException e4) {
                throw new AssertionError(e4);
            }
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeFloat(float f4) {
            try {
                this.f27977a.writeFloat(f4);
            } catch (IOException e4) {
                throw new AssertionError(e4);
            }
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeInt(int i4) {
            try {
                this.f27977a.writeInt(i4);
            } catch (IOException e4) {
                throw new AssertionError(e4);
            }
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeLong(long j4) {
            try {
                this.f27977a.writeLong(j4);
            } catch (IOException e4) {
                throw new AssertionError(e4);
            }
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeShort(int i4) {
            try {
                this.f27977a.writeShort(i4);
            } catch (IOException e4) {
                throw new AssertionError(e4);
            }
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeUTF(String str) {
            try {
                this.f27977a.writeUTF(str);
            } catch (IOException e4) {
                throw new AssertionError(e4);
            }
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void write(byte[] bArr) {
            try {
                this.f27977a.write(bArr);
            } catch (IOException e4) {
                throw new AssertionError(e4);
            }
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void write(byte[] bArr, int i4, int i5) {
            try {
                this.f27977a.write(bArr, i4, i5);
            } catch (IOException e4) {
                throw new AssertionError(e4);
            }
        }
    }

    public static ByteArrayDataInput newDataInput(byte[] bArr, int i4) {
        Preconditions.checkPositionIndex(i4, bArr.length);
        return newDataInput(new ByteArrayInputStream(bArr, i4, bArr.length - i4));
    }

    public static ByteArrayDataOutput newDataOutput(int i4) {
        if (i4 >= 0) {
            return newDataOutput(new ByteArrayOutputStream(i4));
        }
        throw new IllegalArgumentException(String.format("Invalid size: %s", Integer.valueOf(i4)));
    }

    public static void readFully(InputStream inputStream, byte[] bArr, int i4, int i5) throws IOException {
        int read = read(inputStream, bArr, i4, i5);
        if (read == i5) {
            return;
        }
        throw new EOFException("reached end of stream after reading " + read + " bytes; " + i5 + " bytes expected");
    }

    /* loaded from: classes5.dex */
    private static final class LimitedInputStream extends FilterInputStream {

        /* renamed from: a  reason: collision with root package name */
        private long f27979a;

        /* renamed from: b  reason: collision with root package name */
        private long f27980b;

        LimitedInputStream(InputStream inputStream, long j4) {
            super(inputStream);
            boolean z3;
            this.f27980b = -1L;
            Preconditions.checkNotNull(inputStream);
            if (j4 >= 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "limit must be non-negative");
            this.f27979a = j4;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int available() throws IOException {
            return (int) Math.min(((FilterInputStream) this).in.available(), this.f27979a);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public synchronized void mark(int i4) {
            ((FilterInputStream) this).in.mark(i4);
            this.f27980b = this.f27979a;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            if (this.f27979a == 0) {
                return -1;
            }
            int read = ((FilterInputStream) this).in.read();
            if (read != -1) {
                this.f27979a--;
            }
            return read;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public synchronized void reset() throws IOException {
            if (((FilterInputStream) this).in.markSupported()) {
                if (this.f27980b != -1) {
                    ((FilterInputStream) this).in.reset();
                    this.f27979a = this.f27980b;
                } else {
                    throw new IOException("Mark not set");
                }
            } else {
                throw new IOException("Mark not supported");
            }
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public long skip(long j4) throws IOException {
            long skip = ((FilterInputStream) this).in.skip(Math.min(j4, this.f27979a));
            this.f27979a -= skip;
            return skip;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i4, int i5) throws IOException {
            long j4 = this.f27979a;
            if (j4 == 0) {
                return -1;
            }
            int read = ((FilterInputStream) this).in.read(bArr, i4, (int) Math.min(i5, j4));
            if (read != -1) {
                this.f27979a -= read;
            }
            return read;
        }
    }

    public static ByteArrayDataInput newDataInput(ByteArrayInputStream byteArrayInputStream) {
        return new ByteArrayDataInputStream((ByteArrayInputStream) Preconditions.checkNotNull(byteArrayInputStream));
    }

    public static ByteArrayDataOutput newDataOutput(ByteArrayOutputStream byteArrayOutputStream) {
        return new ByteArrayDataOutputStream((ByteArrayOutputStream) Preconditions.checkNotNull(byteArrayOutputStream));
    }

    @CanIgnoreReturnValue
    public static long copy(ReadableByteChannel readableByteChannel, WritableByteChannel writableByteChannel) throws IOException {
        Preconditions.checkNotNull(readableByteChannel);
        Preconditions.checkNotNull(writableByteChannel);
        long j4 = 0;
        if (readableByteChannel instanceof FileChannel) {
            FileChannel fileChannel = (FileChannel) readableByteChannel;
            long position = fileChannel.position();
            long j5 = position;
            while (true) {
                long transferTo = fileChannel.transferTo(j5, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED, writableByteChannel);
                j5 += transferTo;
                fileChannel.position(j5);
                if (transferTo <= 0 && j5 >= fileChannel.size()) {
                    return j5 - position;
                }
            }
        } else {
            ByteBuffer wrap = ByteBuffer.wrap(b());
            while (readableByteChannel.read(wrap) != -1) {
                Java8Compatibility.b(wrap);
                while (wrap.hasRemaining()) {
                    j4 += writableByteChannel.write(wrap);
                }
                Java8Compatibility.a(wrap);
            }
            return j4;
        }
    }
}
