package com.google.common.io;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Ascii;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Objects;
import javax.annotation.CheckForNull;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

@ElementTypesAreNonnullByDefault
@GwtCompatible(emulated = true)
/* loaded from: classes5.dex */
public abstract class BaseEncoding {

    /* renamed from: a  reason: collision with root package name */
    private static final BaseEncoding f27917a;

    /* renamed from: b  reason: collision with root package name */
    private static final BaseEncoding f27918b;

    /* renamed from: c  reason: collision with root package name */
    private static final BaseEncoding f27919c;

    /* renamed from: d  reason: collision with root package name */
    private static final BaseEncoding f27920d;

    /* renamed from: e  reason: collision with root package name */
    private static final BaseEncoding f27921e;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class Alphabet {

        /* renamed from: a  reason: collision with root package name */
        private final String f27934a;

        /* renamed from: b  reason: collision with root package name */
        private final char[] f27935b;

        /* renamed from: c  reason: collision with root package name */
        final int f27936c;

        /* renamed from: d  reason: collision with root package name */
        final int f27937d;

        /* renamed from: e  reason: collision with root package name */
        final int f27938e;

        /* renamed from: f  reason: collision with root package name */
        final int f27939f;

        /* renamed from: g  reason: collision with root package name */
        private final byte[] f27940g;

        /* renamed from: h  reason: collision with root package name */
        private final boolean[] f27941h;

        /* renamed from: i  reason: collision with root package name */
        private final boolean f27942i;

        Alphabet(String str, char[] cArr) {
            this(str, cArr, c(cArr), false);
        }

        private static byte[] c(char[] cArr) {
            boolean z3;
            byte[] bArr = new byte[128];
            Arrays.fill(bArr, (byte) -1);
            for (int i4 = 0; i4 < cArr.length; i4++) {
                char c4 = cArr[i4];
                boolean z4 = true;
                if (c4 < 128) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                Preconditions.checkArgument(z3, "Non-ASCII character: %s", c4);
                if (bArr[c4] != -1) {
                    z4 = false;
                }
                Preconditions.checkArgument(z4, "Duplicate character: %s", c4);
                bArr[c4] = (byte) i4;
            }
            return bArr;
        }

        private boolean f() {
            for (char c4 : this.f27935b) {
                if (Ascii.isLowerCase(c4)) {
                    return true;
                }
            }
            return false;
        }

        private boolean g() {
            for (char c4 : this.f27935b) {
                if (Ascii.isUpperCase(c4)) {
                    return true;
                }
            }
            return false;
        }

        boolean b(char c4) {
            if (c4 <= 127 && this.f27940g[c4] != -1) {
                return true;
            }
            return false;
        }

        int d(char c4) throws DecodingException {
            if (c4 <= 127) {
                byte b4 = this.f27940g[c4];
                if (b4 == -1) {
                    if (c4 > ' ' && c4 != 127) {
                        throw new DecodingException("Unrecognized character: " + c4);
                    }
                    throw new DecodingException("Unrecognized character: 0x" + Integer.toHexString(c4));
                }
                return b4;
            }
            throw new DecodingException("Unrecognized character: 0x" + Integer.toHexString(c4));
        }

        char e(int i4) {
            return this.f27935b[i4];
        }

        public boolean equals(@CheckForNull Object obj) {
            if (!(obj instanceof Alphabet)) {
                return false;
            }
            Alphabet alphabet = (Alphabet) obj;
            if (this.f27942i != alphabet.f27942i || !Arrays.equals(this.f27935b, alphabet.f27935b)) {
                return false;
            }
            return true;
        }

        Alphabet h() {
            if (this.f27942i) {
                return this;
            }
            byte[] bArr = this.f27940g;
            byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
            int i4 = 65;
            while (true) {
                boolean z3 = true;
                if (i4 <= 90) {
                    int i5 = i4 | 32;
                    byte[] bArr2 = this.f27940g;
                    byte b4 = bArr2[i4];
                    byte b5 = bArr2[i5];
                    if (b4 == -1) {
                        copyOf[i4] = b5;
                    } else {
                        if (b5 != -1) {
                            z3 = false;
                        }
                        Preconditions.checkState(z3, "Can't ignoreCase() since '%s' and '%s' encode different values", (char) i4, (char) i5);
                        copyOf[i5] = b4;
                    }
                    i4++;
                } else {
                    return new Alphabet(this.f27934a + ".ignoreCase()", this.f27935b, copyOf, true);
                }
            }
        }

        public int hashCode() {
            int i4;
            int hashCode = Arrays.hashCode(this.f27935b);
            if (this.f27942i) {
                i4 = 1231;
            } else {
                i4 = 1237;
            }
            return hashCode + i4;
        }

        boolean i(int i4) {
            return this.f27941h[i4 % this.f27938e];
        }

        Alphabet j() {
            if (!g()) {
                return this;
            }
            Preconditions.checkState(!f(), "Cannot call lowerCase() on a mixed-case alphabet");
            char[] cArr = new char[this.f27935b.length];
            int i4 = 0;
            while (true) {
                char[] cArr2 = this.f27935b;
                if (i4 >= cArr2.length) {
                    break;
                }
                cArr[i4] = Ascii.toLowerCase(cArr2[i4]);
                i4++;
            }
            Alphabet alphabet = new Alphabet(this.f27934a + ".lowerCase()", cArr);
            if (this.f27942i) {
                return alphabet.h();
            }
            return alphabet;
        }

        public boolean k(char c4) {
            byte[] bArr = this.f27940g;
            if (c4 < bArr.length && bArr[c4] != -1) {
                return true;
            }
            return false;
        }

        Alphabet l() {
            if (!f()) {
                return this;
            }
            Preconditions.checkState(!g(), "Cannot call upperCase() on a mixed-case alphabet");
            char[] cArr = new char[this.f27935b.length];
            int i4 = 0;
            while (true) {
                char[] cArr2 = this.f27935b;
                if (i4 >= cArr2.length) {
                    break;
                }
                cArr[i4] = Ascii.toUpperCase(cArr2[i4]);
                i4++;
            }
            Alphabet alphabet = new Alphabet(this.f27934a + ".upperCase()", cArr);
            if (this.f27942i) {
                return alphabet.h();
            }
            return alphabet;
        }

        public String toString() {
            return this.f27934a;
        }

        private Alphabet(String str, char[] cArr, byte[] bArr, boolean z3) {
            this.f27934a = (String) Preconditions.checkNotNull(str);
            this.f27935b = (char[]) Preconditions.checkNotNull(cArr);
            try {
                int log2 = IntMath.log2(cArr.length, RoundingMode.UNNECESSARY);
                this.f27937d = log2;
                int numberOfTrailingZeros = Integer.numberOfTrailingZeros(log2);
                int i4 = 1 << (3 - numberOfTrailingZeros);
                this.f27938e = i4;
                this.f27939f = log2 >> numberOfTrailingZeros;
                this.f27936c = cArr.length - 1;
                this.f27940g = bArr;
                boolean[] zArr = new boolean[i4];
                for (int i5 = 0; i5 < this.f27939f; i5++) {
                    zArr[IntMath.divide(i5 * 8, this.f27937d, RoundingMode.CEILING)] = true;
                }
                this.f27941h = zArr;
                this.f27942i = z3;
            } catch (ArithmeticException e4) {
                throw new IllegalArgumentException("Illegal alphabet length " + cArr.length, e4);
            }
        }
    }

    /* loaded from: classes5.dex */
    static final class Base16Encoding extends StandardBaseEncoding {

        /* renamed from: k  reason: collision with root package name */
        final char[] f27943k;

        Base16Encoding(String str, String str2) {
            this(new Alphabet(str, str2.toCharArray()));
        }

        @Override // com.google.common.io.BaseEncoding.StandardBaseEncoding, com.google.common.io.BaseEncoding
        int b(byte[] bArr, CharSequence charSequence) throws DecodingException {
            Preconditions.checkNotNull(bArr);
            if (charSequence.length() % 2 != 1) {
                int i4 = 0;
                int i5 = 0;
                while (i4 < charSequence.length()) {
                    bArr[i5] = (byte) ((this.f27947f.d(charSequence.charAt(i4)) << 4) | this.f27947f.d(charSequence.charAt(i4 + 1)));
                    i4 += 2;
                    i5++;
                }
                return i5;
            }
            throw new DecodingException("Invalid input length " + charSequence.length());
        }

        @Override // com.google.common.io.BaseEncoding.StandardBaseEncoding, com.google.common.io.BaseEncoding
        void c(Appendable appendable, byte[] bArr, int i4, int i5) throws IOException {
            Preconditions.checkNotNull(appendable);
            Preconditions.checkPositionIndexes(i4, i4 + i5, bArr.length);
            for (int i6 = 0; i6 < i5; i6++) {
                int i7 = bArr[i4 + i6] & 255;
                appendable.append(this.f27943k[i7]);
                appendable.append(this.f27943k[i7 | 256]);
            }
        }

        @Override // com.google.common.io.BaseEncoding.StandardBaseEncoding
        BaseEncoding l(Alphabet alphabet, @CheckForNull Character ch) {
            return new Base16Encoding(alphabet);
        }

        private Base16Encoding(Alphabet alphabet) {
            super(alphabet, null);
            this.f27943k = new char[512];
            Preconditions.checkArgument(alphabet.f27935b.length == 16);
            for (int i4 = 0; i4 < 256; i4++) {
                this.f27943k[i4] = alphabet.e(i4 >>> 4);
                this.f27943k[i4 | 256] = alphabet.e(i4 & 15);
            }
        }
    }

    /* loaded from: classes5.dex */
    static final class Base64Encoding extends StandardBaseEncoding {
        Base64Encoding(String str, String str2, @CheckForNull Character ch) {
            this(new Alphabet(str, str2.toCharArray()), ch);
        }

        @Override // com.google.common.io.BaseEncoding.StandardBaseEncoding, com.google.common.io.BaseEncoding
        int b(byte[] bArr, CharSequence charSequence) throws DecodingException {
            Preconditions.checkNotNull(bArr);
            CharSequence j4 = j(charSequence);
            if (this.f27947f.i(j4.length())) {
                int i4 = 0;
                int i5 = 0;
                while (i4 < j4.length()) {
                    int i6 = i4 + 1;
                    int i7 = i6 + 1;
                    int d4 = (this.f27947f.d(j4.charAt(i4)) << 18) | (this.f27947f.d(j4.charAt(i6)) << 12);
                    int i8 = i5 + 1;
                    bArr[i5] = (byte) (d4 >>> 16);
                    if (i7 < j4.length()) {
                        int i9 = i7 + 1;
                        int d5 = d4 | (this.f27947f.d(j4.charAt(i7)) << 6);
                        i5 = i8 + 1;
                        bArr[i8] = (byte) ((d5 >>> 8) & 255);
                        if (i9 < j4.length()) {
                            i7 = i9 + 1;
                            i8 = i5 + 1;
                            bArr[i5] = (byte) ((d5 | this.f27947f.d(j4.charAt(i9))) & 255);
                        } else {
                            i4 = i9;
                        }
                    }
                    i5 = i8;
                    i4 = i7;
                }
                return i5;
            }
            throw new DecodingException("Invalid input length " + j4.length());
        }

        @Override // com.google.common.io.BaseEncoding.StandardBaseEncoding, com.google.common.io.BaseEncoding
        void c(Appendable appendable, byte[] bArr, int i4, int i5) throws IOException {
            Preconditions.checkNotNull(appendable);
            int i6 = i4 + i5;
            Preconditions.checkPositionIndexes(i4, i6, bArr.length);
            while (i5 >= 3) {
                int i7 = i4 + 1;
                int i8 = i7 + 1;
                int i9 = ((bArr[i4] & 255) << 16) | ((bArr[i7] & 255) << 8) | (bArr[i8] & 255);
                appendable.append(this.f27947f.e(i9 >>> 18));
                appendable.append(this.f27947f.e((i9 >>> 12) & 63));
                appendable.append(this.f27947f.e((i9 >>> 6) & 63));
                appendable.append(this.f27947f.e(i9 & 63));
                i5 -= 3;
                i4 = i8 + 1;
            }
            if (i4 < i6) {
                k(appendable, bArr, i4, i6 - i4);
            }
        }

        @Override // com.google.common.io.BaseEncoding.StandardBaseEncoding
        BaseEncoding l(Alphabet alphabet, @CheckForNull Character ch) {
            return new Base64Encoding(alphabet, ch);
        }

        private Base64Encoding(Alphabet alphabet, @CheckForNull Character ch) {
            super(alphabet, ch);
            Preconditions.checkArgument(alphabet.f27935b.length == 64);
        }
    }

    /* loaded from: classes5.dex */
    public static final class DecodingException extends IOException {
        DecodingException(String str) {
            super(str);
        }
    }

    /* loaded from: classes5.dex */
    static final class SeparatedBaseEncoding extends BaseEncoding {

        /* renamed from: f  reason: collision with root package name */
        private final BaseEncoding f27944f;

        /* renamed from: g  reason: collision with root package name */
        private final String f27945g;

        /* renamed from: h  reason: collision with root package name */
        private final int f27946h;

        SeparatedBaseEncoding(BaseEncoding baseEncoding, String str, int i4) {
            boolean z3;
            this.f27944f = (BaseEncoding) Preconditions.checkNotNull(baseEncoding);
            this.f27945g = (String) Preconditions.checkNotNull(str);
            this.f27946h = i4;
            if (i4 > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "Cannot add a separator after every %s chars", i4);
        }

        @Override // com.google.common.io.BaseEncoding
        int b(byte[] bArr, CharSequence charSequence) throws DecodingException {
            StringBuilder sb = new StringBuilder(charSequence.length());
            for (int i4 = 0; i4 < charSequence.length(); i4++) {
                char charAt = charSequence.charAt(i4);
                if (this.f27945g.indexOf(charAt) < 0) {
                    sb.append(charAt);
                }
            }
            return this.f27944f.b(bArr, sb);
        }

        @Override // com.google.common.io.BaseEncoding
        void c(Appendable appendable, byte[] bArr, int i4, int i5) throws IOException {
            this.f27944f.c(BaseEncoding.h(appendable, this.f27945g, this.f27946h), bArr, i4, i5);
        }

        @Override // com.google.common.io.BaseEncoding
        public boolean canDecode(CharSequence charSequence) {
            StringBuilder sb = new StringBuilder();
            for (int i4 = 0; i4 < charSequence.length(); i4++) {
                char charAt = charSequence.charAt(i4);
                if (this.f27945g.indexOf(charAt) < 0) {
                    sb.append(charAt);
                }
            }
            return this.f27944f.canDecode(sb);
        }

        @Override // com.google.common.io.BaseEncoding
        @J2ktIncompatible
        @GwtIncompatible
        public InputStream decodingStream(Reader reader) {
            return this.f27944f.decodingStream(BaseEncoding.e(reader, this.f27945g));
        }

        @Override // com.google.common.io.BaseEncoding
        @J2ktIncompatible
        @GwtIncompatible
        public OutputStream encodingStream(Writer writer) {
            return this.f27944f.encodingStream(BaseEncoding.i(writer, this.f27945g, this.f27946h));
        }

        @Override // com.google.common.io.BaseEncoding
        int f(int i4) {
            return this.f27944f.f(i4);
        }

        @Override // com.google.common.io.BaseEncoding
        int g(int i4) {
            int g4 = this.f27944f.g(i4);
            return g4 + (this.f27945g.length() * IntMath.divide(Math.max(0, g4 - 1), this.f27946h, RoundingMode.FLOOR));
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding ignoreCase() {
            return this.f27944f.ignoreCase().withSeparator(this.f27945g, this.f27946h);
        }

        @Override // com.google.common.io.BaseEncoding
        CharSequence j(CharSequence charSequence) {
            return this.f27944f.j(charSequence);
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding lowerCase() {
            return this.f27944f.lowerCase().withSeparator(this.f27945g, this.f27946h);
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding omitPadding() {
            return this.f27944f.omitPadding().withSeparator(this.f27945g, this.f27946h);
        }

        public String toString() {
            return this.f27944f + ".withSeparator(\"" + this.f27945g + "\", " + this.f27946h + ")";
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding upperCase() {
            return this.f27944f.upperCase().withSeparator(this.f27945g, this.f27946h);
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding withPadChar(char c4) {
            return this.f27944f.withPadChar(c4).withSeparator(this.f27945g, this.f27946h);
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding withSeparator(String str, int i4) {
            throw new UnsupportedOperationException("Already have a separator");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class StandardBaseEncoding extends BaseEncoding {

        /* renamed from: f  reason: collision with root package name */
        final Alphabet f27947f;
        @CheckForNull

        /* renamed from: g  reason: collision with root package name */
        final Character f27948g;
        @CheckForNull
        @LazyInit

        /* renamed from: h  reason: collision with root package name */
        private volatile BaseEncoding f27949h;
        @CheckForNull
        @LazyInit

        /* renamed from: i  reason: collision with root package name */
        private volatile BaseEncoding f27950i;
        @CheckForNull
        @LazyInit

        /* renamed from: j  reason: collision with root package name */
        private volatile BaseEncoding f27951j;

        StandardBaseEncoding(String str, String str2, @CheckForNull Character ch) {
            this(new Alphabet(str, str2.toCharArray()), ch);
        }

        @Override // com.google.common.io.BaseEncoding
        int b(byte[] bArr, CharSequence charSequence) throws DecodingException {
            Alphabet alphabet;
            Preconditions.checkNotNull(bArr);
            CharSequence j4 = j(charSequence);
            if (this.f27947f.i(j4.length())) {
                int i4 = 0;
                int i5 = 0;
                while (i4 < j4.length()) {
                    long j5 = 0;
                    int i6 = 0;
                    int i7 = 0;
                    while (true) {
                        alphabet = this.f27947f;
                        if (i6 >= alphabet.f27938e) {
                            break;
                        }
                        j5 <<= alphabet.f27937d;
                        if (i4 + i6 < j4.length()) {
                            j5 |= this.f27947f.d(j4.charAt(i7 + i4));
                            i7++;
                        }
                        i6++;
                    }
                    int i8 = alphabet.f27939f;
                    int i9 = (i8 * 8) - (i7 * alphabet.f27937d);
                    int i10 = (i8 - 1) * 8;
                    while (i10 >= i9) {
                        bArr[i5] = (byte) ((j5 >>> i10) & 255);
                        i10 -= 8;
                        i5++;
                    }
                    i4 += this.f27947f.f27938e;
                }
                return i5;
            }
            throw new DecodingException("Invalid input length " + j4.length());
        }

        @Override // com.google.common.io.BaseEncoding
        void c(Appendable appendable, byte[] bArr, int i4, int i5) throws IOException {
            Preconditions.checkNotNull(appendable);
            Preconditions.checkPositionIndexes(i4, i4 + i5, bArr.length);
            int i6 = 0;
            while (i6 < i5) {
                k(appendable, bArr, i4 + i6, Math.min(this.f27947f.f27939f, i5 - i6));
                i6 += this.f27947f.f27939f;
            }
        }

        @Override // com.google.common.io.BaseEncoding
        public boolean canDecode(CharSequence charSequence) {
            Preconditions.checkNotNull(charSequence);
            CharSequence j4 = j(charSequence);
            if (!this.f27947f.i(j4.length())) {
                return false;
            }
            for (int i4 = 0; i4 < j4.length(); i4++) {
                if (!this.f27947f.b(j4.charAt(i4))) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.common.io.BaseEncoding
        @J2ktIncompatible
        @GwtIncompatible
        public InputStream decodingStream(final Reader reader) {
            Preconditions.checkNotNull(reader);
            return new InputStream() { // from class: com.google.common.io.BaseEncoding.StandardBaseEncoding.2

                /* renamed from: a  reason: collision with root package name */
                int f27957a = 0;

                /* renamed from: b  reason: collision with root package name */
                int f27958b = 0;

                /* renamed from: c  reason: collision with root package name */
                int f27959c = 0;

                /* renamed from: d  reason: collision with root package name */
                boolean f27960d = false;

                @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    reader.close();
                }

                /* JADX WARN: Code restructure failed: missing block: B:24:0x0074, code lost:
                    throw new com.google.common.io.BaseEncoding.DecodingException("Padding cannot start at index " + r4.f27959c);
                 */
                @Override // java.io.InputStream
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public int read() throws java.io.IOException {
                    /*
                        r4 = this;
                    L0:
                        java.io.Reader r0 = r2
                        int r0 = r0.read()
                        r1 = -1
                        if (r0 != r1) goto L34
                        boolean r0 = r4.f27960d
                        if (r0 != 0) goto L33
                        com.google.common.io.BaseEncoding$StandardBaseEncoding r0 = com.google.common.io.BaseEncoding.StandardBaseEncoding.this
                        com.google.common.io.BaseEncoding$Alphabet r0 = r0.f27947f
                        int r2 = r4.f27959c
                        boolean r0 = r0.i(r2)
                        if (r0 == 0) goto L1a
                        goto L33
                    L1a:
                        com.google.common.io.BaseEncoding$DecodingException r0 = new com.google.common.io.BaseEncoding$DecodingException
                        java.lang.StringBuilder r1 = new java.lang.StringBuilder
                        r1.<init>()
                        java.lang.String r2 = "Invalid input length "
                        r1.append(r2)
                        int r2 = r4.f27959c
                        r1.append(r2)
                        java.lang.String r1 = r1.toString()
                        r0.<init>(r1)
                        throw r0
                    L33:
                        return r1
                    L34:
                        int r1 = r4.f27959c
                        r2 = 1
                        int r1 = r1 + r2
                        r4.f27959c = r1
                        char r0 = (char) r0
                        com.google.common.io.BaseEncoding$StandardBaseEncoding r1 = com.google.common.io.BaseEncoding.StandardBaseEncoding.this
                        java.lang.Character r1 = r1.f27948g
                        if (r1 == 0) goto L78
                        char r1 = r1.charValue()
                        if (r1 != r0) goto L78
                        boolean r0 = r4.f27960d
                        if (r0 != 0) goto L75
                        int r0 = r4.f27959c
                        if (r0 == r2) goto L5c
                        com.google.common.io.BaseEncoding$StandardBaseEncoding r1 = com.google.common.io.BaseEncoding.StandardBaseEncoding.this
                        com.google.common.io.BaseEncoding$Alphabet r1 = r1.f27947f
                        int r0 = r0 + (-1)
                        boolean r0 = r1.i(r0)
                        if (r0 == 0) goto L5c
                        goto L75
                    L5c:
                        com.google.common.io.BaseEncoding$DecodingException r0 = new com.google.common.io.BaseEncoding$DecodingException
                        java.lang.StringBuilder r1 = new java.lang.StringBuilder
                        r1.<init>()
                        java.lang.String r2 = "Padding cannot start at index "
                        r1.append(r2)
                        int r2 = r4.f27959c
                        r1.append(r2)
                        java.lang.String r1 = r1.toString()
                        r0.<init>(r1)
                        throw r0
                    L75:
                        r4.f27960d = r2
                        goto L0
                    L78:
                        boolean r1 = r4.f27960d
                        if (r1 != 0) goto La4
                        int r1 = r4.f27957a
                        com.google.common.io.BaseEncoding$StandardBaseEncoding r2 = com.google.common.io.BaseEncoding.StandardBaseEncoding.this
                        com.google.common.io.BaseEncoding$Alphabet r2 = r2.f27947f
                        int r3 = r2.f27937d
                        int r1 = r1 << r3
                        r4.f27957a = r1
                        int r0 = r2.d(r0)
                        r0 = r0 | r1
                        r4.f27957a = r0
                        int r1 = r4.f27958b
                        com.google.common.io.BaseEncoding$StandardBaseEncoding r2 = com.google.common.io.BaseEncoding.StandardBaseEncoding.this
                        com.google.common.io.BaseEncoding$Alphabet r2 = r2.f27947f
                        int r2 = r2.f27937d
                        int r1 = r1 + r2
                        r4.f27958b = r1
                        r2 = 8
                        if (r1 < r2) goto L0
                        int r1 = r1 - r2
                        r4.f27958b = r1
                        int r0 = r0 >> r1
                        r0 = r0 & 255(0xff, float:3.57E-43)
                        return r0
                    La4:
                        com.google.common.io.BaseEncoding$DecodingException r1 = new com.google.common.io.BaseEncoding$DecodingException
                        java.lang.StringBuilder r2 = new java.lang.StringBuilder
                        r2.<init>()
                        java.lang.String r3 = "Expected padding character but found '"
                        r2.append(r3)
                        r2.append(r0)
                        java.lang.String r0 = "' at index "
                        r2.append(r0)
                        int r0 = r4.f27959c
                        r2.append(r0)
                        java.lang.String r0 = r2.toString()
                        r1.<init>(r0)
                        throw r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.common.io.BaseEncoding.StandardBaseEncoding.AnonymousClass2.read():int");
                }

                @Override // java.io.InputStream
                public int read(byte[] bArr, int i4, int i5) throws IOException {
                    int i6 = i5 + i4;
                    Preconditions.checkPositionIndexes(i4, i6, bArr.length);
                    int i7 = i4;
                    while (i7 < i6) {
                        int read = read();
                        if (read == -1) {
                            int i8 = i7 - i4;
                            if (i8 == 0) {
                                return -1;
                            }
                            return i8;
                        }
                        bArr[i7] = (byte) read;
                        i7++;
                    }
                    return i7 - i4;
                }
            };
        }

        @Override // com.google.common.io.BaseEncoding
        @J2ktIncompatible
        @GwtIncompatible
        public OutputStream encodingStream(final Writer writer) {
            Preconditions.checkNotNull(writer);
            return new OutputStream() { // from class: com.google.common.io.BaseEncoding.StandardBaseEncoding.1

                /* renamed from: a  reason: collision with root package name */
                int f27952a = 0;

                /* renamed from: b  reason: collision with root package name */
                int f27953b = 0;

                /* renamed from: c  reason: collision with root package name */
                int f27954c = 0;

                @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    int i4 = this.f27953b;
                    if (i4 > 0) {
                        int i5 = this.f27952a;
                        Alphabet alphabet = StandardBaseEncoding.this.f27947f;
                        writer.write(alphabet.e((i5 << (alphabet.f27937d - i4)) & alphabet.f27936c));
                        this.f27954c++;
                        if (StandardBaseEncoding.this.f27948g != null) {
                            while (true) {
                                int i6 = this.f27954c;
                                StandardBaseEncoding standardBaseEncoding = StandardBaseEncoding.this;
                                if (i6 % standardBaseEncoding.f27947f.f27938e == 0) {
                                    break;
                                }
                                writer.write(standardBaseEncoding.f27948g.charValue());
                                this.f27954c++;
                            }
                        }
                    }
                    writer.close();
                }

                @Override // java.io.OutputStream, java.io.Flushable
                public void flush() throws IOException {
                    writer.flush();
                }

                @Override // java.io.OutputStream
                public void write(int i4) throws IOException {
                    this.f27952a = (i4 & 255) | (this.f27952a << 8);
                    this.f27953b += 8;
                    while (true) {
                        int i5 = this.f27953b;
                        Alphabet alphabet = StandardBaseEncoding.this.f27947f;
                        int i6 = alphabet.f27937d;
                        if (i5 >= i6) {
                            writer.write(alphabet.e((this.f27952a >> (i5 - i6)) & alphabet.f27936c));
                            this.f27954c++;
                            this.f27953b -= StandardBaseEncoding.this.f27947f.f27937d;
                        } else {
                            return;
                        }
                    }
                }
            };
        }

        public boolean equals(@CheckForNull Object obj) {
            if (!(obj instanceof StandardBaseEncoding)) {
                return false;
            }
            StandardBaseEncoding standardBaseEncoding = (StandardBaseEncoding) obj;
            if (!this.f27947f.equals(standardBaseEncoding.f27947f) || !Objects.equals(this.f27948g, standardBaseEncoding.f27948g)) {
                return false;
            }
            return true;
        }

        @Override // com.google.common.io.BaseEncoding
        int f(int i4) {
            return (int) (((this.f27947f.f27937d * i4) + 7) / 8);
        }

        @Override // com.google.common.io.BaseEncoding
        int g(int i4) {
            Alphabet alphabet = this.f27947f;
            return alphabet.f27938e * IntMath.divide(i4, alphabet.f27939f, RoundingMode.CEILING);
        }

        public int hashCode() {
            return this.f27947f.hashCode() ^ Objects.hashCode(this.f27948g);
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding ignoreCase() {
            BaseEncoding baseEncoding = this.f27951j;
            if (baseEncoding == null) {
                Alphabet h4 = this.f27947f.h();
                if (h4 == this.f27947f) {
                    baseEncoding = this;
                } else {
                    baseEncoding = l(h4, this.f27948g);
                }
                this.f27951j = baseEncoding;
            }
            return baseEncoding;
        }

        @Override // com.google.common.io.BaseEncoding
        CharSequence j(CharSequence charSequence) {
            Preconditions.checkNotNull(charSequence);
            Character ch = this.f27948g;
            if (ch == null) {
                return charSequence;
            }
            char charValue = ch.charValue();
            int length = charSequence.length() - 1;
            while (length >= 0 && charSequence.charAt(length) == charValue) {
                length--;
            }
            return charSequence.subSequence(0, length + 1);
        }

        void k(Appendable appendable, byte[] bArr, int i4, int i5) throws IOException {
            boolean z3;
            Preconditions.checkNotNull(appendable);
            Preconditions.checkPositionIndexes(i4, i4 + i5, bArr.length);
            int i6 = 0;
            if (i5 <= this.f27947f.f27939f) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3);
            long j4 = 0;
            for (int i7 = 0; i7 < i5; i7++) {
                j4 = (j4 | (bArr[i4 + i7] & 255)) << 8;
            }
            int i8 = ((i5 + 1) * 8) - this.f27947f.f27937d;
            while (i6 < i5 * 8) {
                Alphabet alphabet = this.f27947f;
                appendable.append(alphabet.e(((int) (j4 >>> (i8 - i6))) & alphabet.f27936c));
                i6 += this.f27947f.f27937d;
            }
            if (this.f27948g != null) {
                while (i6 < this.f27947f.f27939f * 8) {
                    appendable.append(this.f27948g.charValue());
                    i6 += this.f27947f.f27937d;
                }
            }
        }

        BaseEncoding l(Alphabet alphabet, @CheckForNull Character ch) {
            return new StandardBaseEncoding(alphabet, ch);
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding lowerCase() {
            BaseEncoding baseEncoding = this.f27950i;
            if (baseEncoding == null) {
                Alphabet j4 = this.f27947f.j();
                if (j4 == this.f27947f) {
                    baseEncoding = this;
                } else {
                    baseEncoding = l(j4, this.f27948g);
                }
                this.f27950i = baseEncoding;
            }
            return baseEncoding;
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding omitPadding() {
            if (this.f27948g == null) {
                return this;
            }
            return l(this.f27947f, null);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("BaseEncoding.");
            sb.append(this.f27947f);
            if (8 % this.f27947f.f27937d != 0) {
                if (this.f27948g == null) {
                    sb.append(".omitPadding()");
                } else {
                    sb.append(".withPadChar('");
                    sb.append(this.f27948g);
                    sb.append("')");
                }
            }
            return sb.toString();
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding upperCase() {
            BaseEncoding baseEncoding = this.f27949h;
            if (baseEncoding == null) {
                Alphabet l4 = this.f27947f.l();
                if (l4 == this.f27947f) {
                    baseEncoding = this;
                } else {
                    baseEncoding = l(l4, this.f27948g);
                }
                this.f27949h = baseEncoding;
            }
            return baseEncoding;
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding withPadChar(char c4) {
            Character ch;
            if (8 % this.f27947f.f27937d != 0 && ((ch = this.f27948g) == null || ch.charValue() != c4)) {
                return l(this.f27947f, Character.valueOf(c4));
            }
            return this;
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding withSeparator(String str, int i4) {
            boolean z3 = false;
            for (int i5 = 0; i5 < str.length(); i5++) {
                Preconditions.checkArgument(!this.f27947f.k(str.charAt(i5)), "Separator (%s) cannot contain alphabet characters", str);
            }
            Character ch = this.f27948g;
            if (ch != null) {
                if (str.indexOf(ch.charValue()) < 0) {
                    z3 = true;
                }
                Preconditions.checkArgument(z3, "Separator (%s) cannot contain padding character", str);
            }
            return new SeparatedBaseEncoding(this, str, i4);
        }

        StandardBaseEncoding(Alphabet alphabet, @CheckForNull Character ch) {
            this.f27947f = (Alphabet) Preconditions.checkNotNull(alphabet);
            Preconditions.checkArgument(ch == null || !alphabet.k(ch.charValue()), "Padding character %s was already in alphabet", ch);
            this.f27948g = ch;
        }
    }

    static {
        Character valueOf = Character.valueOf(SignatureVisitor.INSTANCEOF);
        f27917a = new Base64Encoding("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", valueOf);
        f27918b = new Base64Encoding("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_", valueOf);
        f27919c = new StandardBaseEncoding("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567", valueOf);
        f27920d = new StandardBaseEncoding("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV", valueOf);
        f27921e = new Base16Encoding("base16()", "0123456789ABCDEF");
    }

    BaseEncoding() {
    }

    public static BaseEncoding base16() {
        return f27921e;
    }

    public static BaseEncoding base32() {
        return f27919c;
    }

    public static BaseEncoding base32Hex() {
        return f27920d;
    }

    public static BaseEncoding base64() {
        return f27917a;
    }

    public static BaseEncoding base64Url() {
        return f27918b;
    }

    private static byte[] d(byte[] bArr, int i4) {
        if (i4 == bArr.length) {
            return bArr;
        }
        byte[] bArr2 = new byte[i4];
        System.arraycopy(bArr, 0, bArr2, 0, i4);
        return bArr2;
    }

    @J2ktIncompatible
    @GwtIncompatible
    static Reader e(final Reader reader, final String str) {
        Preconditions.checkNotNull(reader);
        Preconditions.checkNotNull(str);
        return new Reader() { // from class: com.google.common.io.BaseEncoding.3
            @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                reader.close();
            }

            @Override // java.io.Reader
            public int read() throws IOException {
                int read;
                do {
                    read = reader.read();
                    if (read == -1) {
                        break;
                    }
                } while (str.indexOf((char) read) >= 0);
                return read;
            }

            @Override // java.io.Reader
            public int read(char[] cArr, int i4, int i5) throws IOException {
                throw new UnsupportedOperationException();
            }
        };
    }

    static Appendable h(Appendable appendable, String str, int i4) {
        boolean z3;
        Preconditions.checkNotNull(appendable);
        Preconditions.checkNotNull(str);
        if (i4 > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3);
        return new Appendable(i4, appendable, str) { // from class: com.google.common.io.BaseEncoding.4

            /* renamed from: a  reason: collision with root package name */
            int f27928a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ int f27929b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ Appendable f27930c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ String f27931d;

            {
                this.f27929b = i4;
                this.f27930c = appendable;
                this.f27931d = str;
                this.f27928a = i4;
            }

            @Override // java.lang.Appendable
            public Appendable append(char c4) throws IOException {
                if (this.f27928a == 0) {
                    this.f27930c.append(this.f27931d);
                    this.f27928a = this.f27929b;
                }
                this.f27930c.append(c4);
                this.f27928a--;
                return this;
            }

            @Override // java.lang.Appendable
            public Appendable append(@CheckForNull CharSequence charSequence, int i5, int i6) {
                throw new UnsupportedOperationException();
            }

            @Override // java.lang.Appendable
            public Appendable append(@CheckForNull CharSequence charSequence) {
                throw new UnsupportedOperationException();
            }
        };
    }

    @J2ktIncompatible
    @GwtIncompatible
    static Writer i(final Writer writer, String str, int i4) {
        final Appendable h4 = h(writer, str, i4);
        return new Writer() { // from class: com.google.common.io.BaseEncoding.5
            @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                writer.close();
            }

            @Override // java.io.Writer, java.io.Flushable
            public void flush() throws IOException {
                writer.flush();
            }

            @Override // java.io.Writer
            public void write(int i5) throws IOException {
                h4.append((char) i5);
            }

            @Override // java.io.Writer
            public void write(char[] cArr, int i5, int i6) throws IOException {
                throw new UnsupportedOperationException();
            }
        };
    }

    final byte[] a(CharSequence charSequence) throws DecodingException {
        CharSequence j4 = j(charSequence);
        byte[] bArr = new byte[f(j4.length())];
        return d(bArr, b(bArr, j4));
    }

    abstract int b(byte[] bArr, CharSequence charSequence) throws DecodingException;

    abstract void c(Appendable appendable, byte[] bArr, int i4, int i5) throws IOException;

    public abstract boolean canDecode(CharSequence charSequence);

    public final byte[] decode(CharSequence charSequence) {
        try {
            return a(charSequence);
        } catch (DecodingException e4) {
            throw new IllegalArgumentException(e4);
        }
    }

    @J2ktIncompatible
    @GwtIncompatible
    public final ByteSource decodingSource(final CharSource charSource) {
        Preconditions.checkNotNull(charSource);
        return new ByteSource() { // from class: com.google.common.io.BaseEncoding.2
            @Override // com.google.common.io.ByteSource
            public InputStream openStream() throws IOException {
                return BaseEncoding.this.decodingStream(charSource.openStream());
            }
        };
    }

    @J2ktIncompatible
    @GwtIncompatible
    public abstract InputStream decodingStream(Reader reader);

    public String encode(byte[] bArr) {
        return encode(bArr, 0, bArr.length);
    }

    @J2ktIncompatible
    @GwtIncompatible
    public final ByteSink encodingSink(final CharSink charSink) {
        Preconditions.checkNotNull(charSink);
        return new ByteSink() { // from class: com.google.common.io.BaseEncoding.1
            @Override // com.google.common.io.ByteSink
            public OutputStream openStream() throws IOException {
                return BaseEncoding.this.encodingStream(charSink.openStream());
            }
        };
    }

    @J2ktIncompatible
    @GwtIncompatible
    public abstract OutputStream encodingStream(Writer writer);

    abstract int f(int i4);

    abstract int g(int i4);

    public abstract BaseEncoding ignoreCase();

    CharSequence j(CharSequence charSequence) {
        return (CharSequence) Preconditions.checkNotNull(charSequence);
    }

    public abstract BaseEncoding lowerCase();

    public abstract BaseEncoding omitPadding();

    public abstract BaseEncoding upperCase();

    public abstract BaseEncoding withPadChar(char c4);

    public abstract BaseEncoding withSeparator(String str, int i4);

    public final String encode(byte[] bArr, int i4, int i5) {
        Preconditions.checkPositionIndexes(i4, i4 + i5, bArr.length);
        StringBuilder sb = new StringBuilder(g(i5));
        try {
            c(sb, bArr, i4, i5);
            return sb.toString();
        } catch (IOException e4) {
            throw new AssertionError(e4);
        }
    }
}
