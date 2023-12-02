package com.bumptech.glide.load.resource.bitmap;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.util.Preconditions;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

/* loaded from: classes3.dex */
public final class DefaultImageHeaderParser implements ImageHeaderParser {

    /* renamed from: a  reason: collision with root package name */
    static final byte[] f17230a = "Exif\u0000\u0000".getBytes(Charset.forName("UTF-8"));

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f17231b = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    /* loaded from: classes3.dex */
    private static final class a implements c {

        /* renamed from: a  reason: collision with root package name */
        private final ByteBuffer f17232a;

        a(ByteBuffer byteBuffer) {
            this.f17232a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.c
        public int a() {
            return ((d() << 8) & 65280) | (d() & 255);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.c
        public int b(byte[] bArr, int i4) {
            int min = Math.min(i4, this.f17232a.remaining());
            if (min == 0) {
                return -1;
            }
            this.f17232a.get(bArr, 0, min);
            return min;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.c
        public short c() {
            return (short) (d() & 255);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.c
        public int d() {
            if (this.f17232a.remaining() < 1) {
                return -1;
            }
            return this.f17232a.get();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.c
        public long skip(long j4) {
            int min = (int) Math.min(this.f17232a.remaining(), j4);
            ByteBuffer byteBuffer = this.f17232a;
            byteBuffer.position(byteBuffer.position() + min);
            return min;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final ByteBuffer f17233a;

        b(byte[] bArr, int i4) {
            this.f17233a = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i4);
        }

        private boolean c(int i4, int i5) {
            if (this.f17233a.remaining() - i4 >= i5) {
                return true;
            }
            return false;
        }

        short a(int i4) {
            if (c(i4, 2)) {
                return this.f17233a.getShort(i4);
            }
            return (short) -1;
        }

        int b(int i4) {
            if (c(i4, 4)) {
                return this.f17233a.getInt(i4);
            }
            return -1;
        }

        int d() {
            return this.f17233a.remaining();
        }

        void e(ByteOrder byteOrder) {
            this.f17233a.order(byteOrder);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public interface c {
        int a() throws IOException;

        int b(byte[] bArr, int i4) throws IOException;

        short c() throws IOException;

        int d() throws IOException;

        long skip(long j4) throws IOException;
    }

    /* loaded from: classes3.dex */
    private static final class d implements c {

        /* renamed from: a  reason: collision with root package name */
        private final InputStream f17234a;

        d(InputStream inputStream) {
            this.f17234a = inputStream;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.c
        public int a() throws IOException {
            return ((this.f17234a.read() << 8) & 65280) | (this.f17234a.read() & 255);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.c
        public int b(byte[] bArr, int i4) throws IOException {
            int i5 = i4;
            while (i5 > 0) {
                int read = this.f17234a.read(bArr, i4 - i5, i5);
                if (read == -1) {
                    break;
                }
                i5 -= read;
            }
            return i4 - i5;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.c
        public short c() throws IOException {
            return (short) (this.f17234a.read() & 255);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.c
        public int d() throws IOException {
            return this.f17234a.read();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.c
        public long skip(long j4) throws IOException {
            if (j4 < 0) {
                return 0L;
            }
            long j5 = j4;
            while (j5 > 0) {
                long skip = this.f17234a.skip(j5);
                if (skip <= 0) {
                    if (this.f17234a.read() == -1) {
                        break;
                    }
                    skip = 1;
                }
                j5 -= skip;
            }
            return j4 - j5;
        }
    }

    private static int a(int i4, int i5) {
        return i4 + 2 + (i5 * 12);
    }

    private int b(c cVar, ArrayPool arrayPool) throws IOException {
        int a4 = cVar.a();
        if (!d(a4)) {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Parser doesn't handle magic number: ");
                sb.append(a4);
            }
            return -1;
        }
        int f4 = f(cVar);
        if (f4 == -1) {
            Log.isLoggable("DfltImageHeaderParser", 3);
            return -1;
        }
        byte[] bArr = (byte[]) arrayPool.get(f4, byte[].class);
        try {
            return h(cVar, bArr, f4);
        } finally {
            arrayPool.put(bArr);
        }
    }

    @NonNull
    private ImageHeaderParser.ImageType c(c cVar) throws IOException {
        int a4 = cVar.a();
        if (a4 == 65496) {
            return ImageHeaderParser.ImageType.JPEG;
        }
        int a5 = ((a4 << 16) & SupportMenu.CATEGORY_MASK) | (cVar.a() & 65535);
        if (a5 == -1991225785) {
            cVar.skip(21L);
            if (cVar.d() >= 3) {
                return ImageHeaderParser.ImageType.PNG_A;
            }
            return ImageHeaderParser.ImageType.PNG;
        } else if ((a5 >> 8) == 4671814) {
            return ImageHeaderParser.ImageType.GIF;
        } else {
            if (a5 != 1380533830) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            cVar.skip(4L);
            if ((((cVar.a() << 16) & SupportMenu.CATEGORY_MASK) | (cVar.a() & 65535)) != 1464156752) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            int a6 = ((cVar.a() << 16) & SupportMenu.CATEGORY_MASK) | (cVar.a() & 65535);
            if ((a6 & InputDeviceCompat.SOURCE_ANY) != 1448097792) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            int i4 = a6 & 255;
            if (i4 == 88) {
                cVar.skip(4L);
                if ((cVar.d() & 16) != 0) {
                    return ImageHeaderParser.ImageType.WEBP_A;
                }
                return ImageHeaderParser.ImageType.WEBP;
            } else if (i4 == 76) {
                cVar.skip(4L);
                if ((cVar.d() & 8) != 0) {
                    return ImageHeaderParser.ImageType.WEBP_A;
                }
                return ImageHeaderParser.ImageType.WEBP;
            } else {
                return ImageHeaderParser.ImageType.WEBP;
            }
        }
    }

    private static boolean d(int i4) {
        if ((i4 & 65496) != 65496 && i4 != 19789 && i4 != 18761) {
            return false;
        }
        return true;
    }

    private boolean e(byte[] bArr, int i4) {
        boolean z3;
        if (bArr != null && i4 > f17230a.length) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            int i5 = 0;
            while (true) {
                byte[] bArr2 = f17230a;
                if (i5 >= bArr2.length) {
                    break;
                } else if (bArr[i5] != bArr2[i5]) {
                    return false;
                } else {
                    i5++;
                }
            }
        }
        return z3;
    }

    private int f(c cVar) throws IOException {
        short c4;
        int a4;
        long j4;
        long skip;
        do {
            short c5 = cVar.c();
            if (c5 != 255) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unknown segmentId=");
                    sb.append((int) c5);
                }
                return -1;
            }
            c4 = cVar.c();
            if (c4 == 218) {
                return -1;
            }
            if (c4 == 217) {
                Log.isLoggable("DfltImageHeaderParser", 3);
                return -1;
            }
            a4 = cVar.a() - 2;
            if (c4 != 225) {
                j4 = a4;
                skip = cVar.skip(j4);
            } else {
                return a4;
            }
        } while (skip == j4);
        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Unable to skip enough data, type: ");
            sb2.append((int) c4);
            sb2.append(", wanted to skip: ");
            sb2.append(a4);
            sb2.append(", but actually skipped: ");
            sb2.append(skip);
        }
        return -1;
    }

    private static int g(b bVar) {
        ByteOrder byteOrder;
        short a4 = bVar.a(6);
        if (a4 != 18761) {
            if (a4 != 19789) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unknown endianness = ");
                    sb.append((int) a4);
                }
                byteOrder = ByteOrder.BIG_ENDIAN;
            } else {
                byteOrder = ByteOrder.BIG_ENDIAN;
            }
        } else {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        }
        bVar.e(byteOrder);
        int b4 = bVar.b(10) + 6;
        short a5 = bVar.a(b4);
        for (int i4 = 0; i4 < a5; i4++) {
            int a6 = a(b4, i4);
            short a7 = bVar.a(a6);
            if (a7 == 274) {
                short a8 = bVar.a(a6 + 2);
                if (a8 >= 1 && a8 <= 12) {
                    int b5 = bVar.b(a6 + 4);
                    if (b5 < 0) {
                        Log.isLoggable("DfltImageHeaderParser", 3);
                    } else {
                        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Got tagIndex=");
                            sb2.append(i4);
                            sb2.append(" tagType=");
                            sb2.append((int) a7);
                            sb2.append(" formatCode=");
                            sb2.append((int) a8);
                            sb2.append(" componentCount=");
                            sb2.append(b5);
                        }
                        int i5 = b5 + f17231b[a8];
                        if (i5 > 4) {
                            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append("Got byte count > 4, not orientation, continuing, formatCode=");
                                sb3.append((int) a8);
                            }
                        } else {
                            int i6 = a6 + 8;
                            if (i6 >= 0 && i6 <= bVar.d()) {
                                if (i5 >= 0 && i5 + i6 <= bVar.d()) {
                                    return bVar.a(i6);
                                }
                                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                    StringBuilder sb4 = new StringBuilder();
                                    sb4.append("Illegal number of bytes for TI tag data tagType=");
                                    sb4.append((int) a7);
                                }
                            } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append("Illegal tagValueOffset=");
                                sb5.append(i6);
                                sb5.append(" tagType=");
                                sb5.append((int) a7);
                            }
                        }
                    }
                } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("Got invalid format code = ");
                    sb6.append((int) a8);
                }
            }
        }
        return -1;
    }

    private int h(c cVar, byte[] bArr, int i4) throws IOException {
        int b4 = cVar.b(bArr, i4);
        if (b4 != i4) {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Unable to read exif segment data, length: ");
                sb.append(i4);
                sb.append(", actually read: ");
                sb.append(b4);
            }
            return -1;
        } else if (e(bArr, i4)) {
            return g(new b(bArr, i4));
        } else {
            Log.isLoggable("DfltImageHeaderParser", 3);
            return -1;
        }
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public int getOrientation(@NonNull InputStream inputStream, @NonNull ArrayPool arrayPool) throws IOException {
        return b(new d((InputStream) Preconditions.checkNotNull(inputStream)), (ArrayPool) Preconditions.checkNotNull(arrayPool));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    @NonNull
    public ImageHeaderParser.ImageType getType(@NonNull InputStream inputStream) throws IOException {
        return c(new d((InputStream) Preconditions.checkNotNull(inputStream)));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    @NonNull
    public ImageHeaderParser.ImageType getType(@NonNull ByteBuffer byteBuffer) throws IOException {
        return c(new a((ByteBuffer) Preconditions.checkNotNull(byteBuffer)));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public int getOrientation(@NonNull ByteBuffer byteBuffer, @NonNull ArrayPool arrayPool) throws IOException {
        return b(new a((ByteBuffer) Preconditions.checkNotNull(byteBuffer)), (ArrayPool) Preconditions.checkNotNull(arrayPool));
    }
}
