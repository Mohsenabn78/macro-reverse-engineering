package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Ascii;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.hash.Funnels;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hasher;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

@ElementTypesAreNonnullByDefault
@J2ktIncompatible
@GwtIncompatible
/* loaded from: classes5.dex */
public abstract class ByteSource {

    /* loaded from: classes5.dex */
    class AsCharSource extends CharSource {

        /* renamed from: a  reason: collision with root package name */
        final Charset f27965a;

        AsCharSource(Charset charset) {
            this.f27965a = (Charset) Preconditions.checkNotNull(charset);
        }

        @Override // com.google.common.io.CharSource
        public ByteSource asByteSource(Charset charset) {
            if (charset.equals(this.f27965a)) {
                return ByteSource.this;
            }
            return super.asByteSource(charset);
        }

        @Override // com.google.common.io.CharSource
        public Reader openStream() throws IOException {
            return new InputStreamReader(ByteSource.this.openStream(), this.f27965a);
        }

        @Override // com.google.common.io.CharSource
        public String read() throws IOException {
            return new String(ByteSource.this.read(), this.f27965a);
        }

        public String toString() {
            return ByteSource.this.toString() + ".asCharSource(" + this.f27965a + ")";
        }
    }

    /* loaded from: classes5.dex */
    private static class ByteArrayByteSource extends ByteSource {

        /* renamed from: a  reason: collision with root package name */
        final byte[] f27967a;

        /* renamed from: b  reason: collision with root package name */
        final int f27968b;

        /* renamed from: c  reason: collision with root package name */
        final int f27969c;

        ByteArrayByteSource(byte[] bArr) {
            this(bArr, 0, bArr.length);
        }

        @Override // com.google.common.io.ByteSource
        public long copyTo(OutputStream outputStream) throws IOException {
            outputStream.write(this.f27967a, this.f27968b, this.f27969c);
            return this.f27969c;
        }

        @Override // com.google.common.io.ByteSource
        public HashCode hash(HashFunction hashFunction) throws IOException {
            return hashFunction.hashBytes(this.f27967a, this.f27968b, this.f27969c);
        }

        @Override // com.google.common.io.ByteSource
        public boolean isEmpty() {
            if (this.f27969c == 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.common.io.ByteSource
        public InputStream openBufferedStream() {
            return openStream();
        }

        @Override // com.google.common.io.ByteSource
        public InputStream openStream() {
            return new ByteArrayInputStream(this.f27967a, this.f27968b, this.f27969c);
        }

        @Override // com.google.common.io.ByteSource
        public byte[] read() {
            byte[] bArr = this.f27967a;
            int i4 = this.f27968b;
            return Arrays.copyOfRange(bArr, i4, this.f27969c + i4);
        }

        @Override // com.google.common.io.ByteSource
        public long size() {
            return this.f27969c;
        }

        @Override // com.google.common.io.ByteSource
        public Optional<Long> sizeIfKnown() {
            return Optional.of(Long.valueOf(this.f27969c));
        }

        @Override // com.google.common.io.ByteSource
        public ByteSource slice(long j4, long j5) {
            boolean z3;
            boolean z4 = true;
            if (j4 >= 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "offset (%s) may not be negative", j4);
            if (j5 < 0) {
                z4 = false;
            }
            Preconditions.checkArgument(z4, "length (%s) may not be negative", j5);
            long min = Math.min(j4, this.f27969c);
            long min2 = Math.min(j5, this.f27969c - min);
            return new ByteArrayByteSource(this.f27967a, this.f27968b + ((int) min), (int) min2);
        }

        public String toString() {
            return "ByteSource.wrap(" + Ascii.truncate(BaseEncoding.base16().encode(this.f27967a, this.f27968b, this.f27969c), 30, "...") + ")";
        }

        ByteArrayByteSource(byte[] bArr, int i4, int i5) {
            this.f27967a = bArr;
            this.f27968b = i4;
            this.f27969c = i5;
        }

        @Override // com.google.common.io.ByteSource
        @ParametricNullness
        public <T> T read(ByteProcessor<T> byteProcessor) throws IOException {
            byteProcessor.processBytes(this.f27967a, this.f27968b, this.f27969c);
            return byteProcessor.getResult();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class ConcatenatedByteSource extends ByteSource {

        /* renamed from: a  reason: collision with root package name */
        final Iterable<? extends ByteSource> f27970a;

        ConcatenatedByteSource(Iterable<? extends ByteSource> iterable) {
            this.f27970a = (Iterable) Preconditions.checkNotNull(iterable);
        }

        @Override // com.google.common.io.ByteSource
        public boolean isEmpty() throws IOException {
            for (ByteSource byteSource : this.f27970a) {
                if (!byteSource.isEmpty()) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.common.io.ByteSource
        public InputStream openStream() throws IOException {
            return new MultiInputStream(this.f27970a.iterator());
        }

        @Override // com.google.common.io.ByteSource
        public long size() throws IOException {
            long j4 = 0;
            for (ByteSource byteSource : this.f27970a) {
                j4 += byteSource.size();
                if (j4 < 0) {
                    return Long.MAX_VALUE;
                }
            }
            return j4;
        }

        @Override // com.google.common.io.ByteSource
        public Optional<Long> sizeIfKnown() {
            Iterable<? extends ByteSource> iterable = this.f27970a;
            if (!(iterable instanceof Collection)) {
                return Optional.absent();
            }
            long j4 = 0;
            for (ByteSource byteSource : iterable) {
                Optional<Long> sizeIfKnown = byteSource.sizeIfKnown();
                if (!sizeIfKnown.isPresent()) {
                    return Optional.absent();
                }
                j4 += sizeIfKnown.get().longValue();
                if (j4 < 0) {
                    return Optional.of(Long.MAX_VALUE);
                }
            }
            return Optional.of(Long.valueOf(j4));
        }

        public String toString() {
            return "ByteSource.concat(" + this.f27970a + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class EmptyByteSource extends ByteArrayByteSource {

        /* renamed from: d  reason: collision with root package name */
        static final EmptyByteSource f27971d = new EmptyByteSource();

        EmptyByteSource() {
            super(new byte[0]);
        }

        @Override // com.google.common.io.ByteSource
        public CharSource asCharSource(Charset charset) {
            Preconditions.checkNotNull(charset);
            return CharSource.empty();
        }

        @Override // com.google.common.io.ByteSource.ByteArrayByteSource, com.google.common.io.ByteSource
        public byte[] read() {
            return this.f27967a;
        }

        @Override // com.google.common.io.ByteSource.ByteArrayByteSource
        public String toString() {
            return "ByteSource.empty()";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public final class SlicedByteSource extends ByteSource {

        /* renamed from: a  reason: collision with root package name */
        final long f27972a;

        /* renamed from: b  reason: collision with root package name */
        final long f27973b;

        SlicedByteSource(long j4, long j5) {
            boolean z3;
            if (j4 >= 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "offset (%s) may not be negative", j4);
            Preconditions.checkArgument(j5 >= 0, "length (%s) may not be negative", j5);
            this.f27972a = j4;
            this.f27973b = j5;
        }

        private InputStream b(InputStream inputStream) throws IOException {
            long j4 = this.f27972a;
            if (j4 > 0) {
                try {
                    if (ByteStreams.d(inputStream, j4) < this.f27972a) {
                        inputStream.close();
                        return new ByteArrayInputStream(new byte[0]);
                    }
                } finally {
                }
            }
            return ByteStreams.limit(inputStream, this.f27973b);
        }

        @Override // com.google.common.io.ByteSource
        public boolean isEmpty() throws IOException {
            if (this.f27973b != 0 && !super.isEmpty()) {
                return false;
            }
            return true;
        }

        @Override // com.google.common.io.ByteSource
        public InputStream openBufferedStream() throws IOException {
            return b(ByteSource.this.openBufferedStream());
        }

        @Override // com.google.common.io.ByteSource
        public InputStream openStream() throws IOException {
            return b(ByteSource.this.openStream());
        }

        @Override // com.google.common.io.ByteSource
        public Optional<Long> sizeIfKnown() {
            Optional<Long> sizeIfKnown = ByteSource.this.sizeIfKnown();
            if (sizeIfKnown.isPresent()) {
                long longValue = sizeIfKnown.get().longValue();
                return Optional.of(Long.valueOf(Math.min(this.f27973b, longValue - Math.min(this.f27972a, longValue))));
            }
            return Optional.absent();
        }

        @Override // com.google.common.io.ByteSource
        public ByteSource slice(long j4, long j5) {
            boolean z3;
            boolean z4 = true;
            if (j4 >= 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "offset (%s) may not be negative", j4);
            if (j5 < 0) {
                z4 = false;
            }
            Preconditions.checkArgument(z4, "length (%s) may not be negative", j5);
            long j6 = this.f27973b - j4;
            if (j6 <= 0) {
                return ByteSource.empty();
            }
            return ByteSource.this.slice(this.f27972a + j4, Math.min(j5, j6));
        }

        public String toString() {
            return ByteSource.this.toString() + ".slice(" + this.f27972a + ", " + this.f27973b + ")";
        }
    }

    private long a(InputStream inputStream) throws IOException {
        long j4 = 0;
        while (true) {
            long d4 = ByteStreams.d(inputStream, 2147483647L);
            if (d4 > 0) {
                j4 += d4;
            } else {
                return j4;
            }
        }
    }

    public static ByteSource concat(Iterable<? extends ByteSource> iterable) {
        return new ConcatenatedByteSource(iterable);
    }

    public static ByteSource empty() {
        return EmptyByteSource.f27971d;
    }

    public static ByteSource wrap(byte[] bArr) {
        return new ByteArrayByteSource(bArr);
    }

    public CharSource asCharSource(Charset charset) {
        return new AsCharSource(charset);
    }

    public boolean contentEquals(ByteSource byteSource) throws IOException {
        int read;
        Preconditions.checkNotNull(byteSource);
        byte[] b4 = ByteStreams.b();
        byte[] b5 = ByteStreams.b();
        Closer create = Closer.create();
        try {
            InputStream inputStream = (InputStream) create.register(openStream());
            InputStream inputStream2 = (InputStream) create.register(byteSource.openStream());
            do {
                read = ByteStreams.read(inputStream, b4, 0, b4.length);
                if (read == ByteStreams.read(inputStream2, b5, 0, b5.length) && Arrays.equals(b4, b5)) {
                }
                return false;
            } while (read == b4.length);
            create.close();
            return true;
        } finally {
        }
    }

    @CanIgnoreReturnValue
    public long copyTo(OutputStream outputStream) throws IOException {
        Preconditions.checkNotNull(outputStream);
        try {
            return ByteStreams.copy((InputStream) Closer.create().register(openStream()), outputStream);
        } finally {
        }
    }

    public HashCode hash(HashFunction hashFunction) throws IOException {
        Hasher newHasher = hashFunction.newHasher();
        copyTo(Funnels.asOutputStream(newHasher));
        return newHasher.hash();
    }

    public boolean isEmpty() throws IOException {
        Optional<Long> sizeIfKnown = sizeIfKnown();
        boolean z3 = true;
        if (sizeIfKnown.isPresent()) {
            if (sizeIfKnown.get().longValue() == 0) {
                return true;
            }
            return false;
        }
        Closer create = Closer.create();
        try {
            if (((InputStream) create.register(openStream())).read() != -1) {
                z3 = false;
            }
            return z3;
        } catch (Throwable th) {
            try {
                throw create.rethrow(th);
            } finally {
                create.close();
            }
        }
    }

    public InputStream openBufferedStream() throws IOException {
        InputStream openStream = openStream();
        if (openStream instanceof BufferedInputStream) {
            return (BufferedInputStream) openStream;
        }
        return new BufferedInputStream(openStream);
    }

    public abstract InputStream openStream() throws IOException;

    public byte[] read() throws IOException {
        byte[] byteArray;
        Closer create = Closer.create();
        try {
            InputStream inputStream = (InputStream) create.register(openStream());
            Optional<Long> sizeIfKnown = sizeIfKnown();
            if (sizeIfKnown.isPresent()) {
                byteArray = ByteStreams.e(inputStream, sizeIfKnown.get().longValue());
            } else {
                byteArray = ByteStreams.toByteArray(inputStream);
            }
            return byteArray;
        } catch (Throwable th) {
            try {
                throw create.rethrow(th);
            } finally {
                create.close();
            }
        }
    }

    public long size() throws IOException {
        Optional<Long> sizeIfKnown = sizeIfKnown();
        if (sizeIfKnown.isPresent()) {
            return sizeIfKnown.get().longValue();
        }
        Closer create = Closer.create();
        try {
            return a((InputStream) create.register(openStream()));
        } catch (IOException unused) {
            create.close();
            try {
                return ByteStreams.exhaust((InputStream) Closer.create().register(openStream()));
            } finally {
            }
        } finally {
        }
    }

    public Optional<Long> sizeIfKnown() {
        return Optional.absent();
    }

    public ByteSource slice(long j4, long j5) {
        return new SlicedByteSource(j4, j5);
    }

    public static ByteSource concat(Iterator<? extends ByteSource> it) {
        return concat(ImmutableList.copyOf(it));
    }

    public static ByteSource concat(ByteSource... byteSourceArr) {
        return concat(ImmutableList.copyOf(byteSourceArr));
    }

    @CanIgnoreReturnValue
    public long copyTo(ByteSink byteSink) throws IOException {
        Preconditions.checkNotNull(byteSink);
        Closer create = Closer.create();
        try {
            return ByteStreams.copy((InputStream) create.register(openStream()), (OutputStream) create.register(byteSink.openStream()));
        } finally {
        }
    }

    @CanIgnoreReturnValue
    @ParametricNullness
    public <T> T read(ByteProcessor<T> byteProcessor) throws IOException {
        Preconditions.checkNotNull(byteProcessor);
        try {
            return (T) ByteStreams.readBytes((InputStream) Closer.create().register(openStream()), byteProcessor);
        } finally {
        }
    }
}
