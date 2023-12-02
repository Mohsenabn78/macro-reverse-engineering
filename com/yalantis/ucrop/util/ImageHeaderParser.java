package com.yalantis.ucrop.util;

import android.media.ExifInterface;
import android.text.TextUtils;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

/* loaded from: classes6.dex */
public class ImageHeaderParser {
    public static final int UNKNOWN_ORIENTATION = -1;

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f38480b = "Exif\u0000\u0000".getBytes(Charset.forName("UTF-8"));

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f38481c = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    /* renamed from: a  reason: collision with root package name */
    private final b f38482a;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final ByteBuffer f38483a;

        public a(byte[] bArr, int i4) {
            this.f38483a = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i4);
        }

        public short a(int i4) {
            return this.f38483a.getShort(i4);
        }

        public int b(int i4) {
            return this.f38483a.getInt(i4);
        }

        public int c() {
            return this.f38483a.remaining();
        }

        public void d(ByteOrder byteOrder) {
            this.f38483a.order(byteOrder);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public interface b {
        int a() throws IOException;

        int b(byte[] bArr, int i4) throws IOException;

        short c() throws IOException;

        long skip(long j4) throws IOException;
    }

    /* loaded from: classes6.dex */
    private static class c implements b {

        /* renamed from: a  reason: collision with root package name */
        private final InputStream f38484a;

        public c(InputStream inputStream) {
            this.f38484a = inputStream;
        }

        @Override // com.yalantis.ucrop.util.ImageHeaderParser.b
        public int a() throws IOException {
            return ((this.f38484a.read() << 8) & 65280) | (this.f38484a.read() & 255);
        }

        @Override // com.yalantis.ucrop.util.ImageHeaderParser.b
        public int b(byte[] bArr, int i4) throws IOException {
            int i5 = i4;
            while (i5 > 0) {
                int read = this.f38484a.read(bArr, i4 - i5, i5);
                if (read == -1) {
                    break;
                }
                i5 -= read;
            }
            return i4 - i5;
        }

        @Override // com.yalantis.ucrop.util.ImageHeaderParser.b
        public short c() throws IOException {
            return (short) (this.f38484a.read() & 255);
        }

        @Override // com.yalantis.ucrop.util.ImageHeaderParser.b
        public long skip(long j4) throws IOException {
            if (j4 < 0) {
                return 0L;
            }
            long j5 = j4;
            while (j5 > 0) {
                long skip = this.f38484a.skip(j5);
                if (skip <= 0) {
                    if (this.f38484a.read() == -1) {
                        break;
                    }
                    skip = 1;
                }
                j5 -= skip;
            }
            return j4 - j5;
        }
    }

    public ImageHeaderParser(InputStream inputStream) {
        this.f38482a = new c(inputStream);
    }

    private static int a(int i4, int i5) {
        return i4 + 2 + (i5 * 12);
    }

    private static boolean b(int i4) {
        if ((i4 & 65496) != 65496 && i4 != 19789 && i4 != 18761) {
            return false;
        }
        return true;
    }

    private boolean c(byte[] bArr, int i4) {
        boolean z3;
        if (bArr != null && i4 > f38480b.length) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            int i5 = 0;
            while (true) {
                byte[] bArr2 = f38480b;
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

    public static void copyExif(ExifInterface exifInterface, int i4, int i5, String str) {
        String[] strArr = {androidx.exifinterface.media.ExifInterface.TAG_F_NUMBER, androidx.exifinterface.media.ExifInterface.TAG_DATETIME, androidx.exifinterface.media.ExifInterface.TAG_DATETIME_DIGITIZED, androidx.exifinterface.media.ExifInterface.TAG_EXPOSURE_TIME, androidx.exifinterface.media.ExifInterface.TAG_FLASH, androidx.exifinterface.media.ExifInterface.TAG_FOCAL_LENGTH, androidx.exifinterface.media.ExifInterface.TAG_GPS_ALTITUDE, androidx.exifinterface.media.ExifInterface.TAG_GPS_ALTITUDE_REF, androidx.exifinterface.media.ExifInterface.TAG_GPS_DATESTAMP, androidx.exifinterface.media.ExifInterface.TAG_GPS_LATITUDE, androidx.exifinterface.media.ExifInterface.TAG_GPS_LATITUDE_REF, androidx.exifinterface.media.ExifInterface.TAG_GPS_LONGITUDE, androidx.exifinterface.media.ExifInterface.TAG_GPS_LONGITUDE_REF, androidx.exifinterface.media.ExifInterface.TAG_GPS_PROCESSING_METHOD, androidx.exifinterface.media.ExifInterface.TAG_GPS_TIMESTAMP, androidx.exifinterface.media.ExifInterface.TAG_ISO_SPEED_RATINGS, androidx.exifinterface.media.ExifInterface.TAG_MAKE, androidx.exifinterface.media.ExifInterface.TAG_MODEL, androidx.exifinterface.media.ExifInterface.TAG_SUBSEC_TIME, androidx.exifinterface.media.ExifInterface.TAG_SUBSEC_TIME_DIGITIZED, androidx.exifinterface.media.ExifInterface.TAG_SUBSEC_TIME_ORIGINAL, androidx.exifinterface.media.ExifInterface.TAG_WHITE_BALANCE};
        try {
            ExifInterface exifInterface2 = new ExifInterface(str);
            for (int i6 = 0; i6 < 22; i6++) {
                String str2 = strArr[i6];
                String attribute = exifInterface.getAttribute(str2);
                if (!TextUtils.isEmpty(attribute)) {
                    exifInterface2.setAttribute(str2, attribute);
                }
            }
            exifInterface2.setAttribute(androidx.exifinterface.media.ExifInterface.TAG_IMAGE_WIDTH, String.valueOf(i4));
            exifInterface2.setAttribute(androidx.exifinterface.media.ExifInterface.TAG_IMAGE_LENGTH, String.valueOf(i5));
            exifInterface2.setAttribute(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, "0");
            exifInterface2.saveAttributes();
        } catch (IOException e4) {
            e4.getMessage();
        }
    }

    private int d() throws IOException {
        short c4;
        int a4;
        long j4;
        long skip;
        do {
            short c5 = this.f38482a.c();
            if (c5 != 255) {
                if (Log.isLoggable("ImageHeaderParser", 3)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unknown segmentId=");
                    sb.append((int) c5);
                }
                return -1;
            }
            c4 = this.f38482a.c();
            if (c4 == 218) {
                return -1;
            }
            if (c4 == 217) {
                Log.isLoggable("ImageHeaderParser", 3);
                return -1;
            }
            a4 = this.f38482a.a() - 2;
            if (c4 != 225) {
                j4 = a4;
                skip = this.f38482a.skip(j4);
            } else {
                return a4;
            }
        } while (skip == j4);
        if (Log.isLoggable("ImageHeaderParser", 3)) {
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

    private static int e(a aVar) {
        ByteOrder byteOrder;
        short a4 = aVar.a(6);
        if (a4 == 19789) {
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else if (a4 == 18761) {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        } else {
            if (Log.isLoggable("ImageHeaderParser", 3)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Unknown endianness = ");
                sb.append((int) a4);
            }
            byteOrder = ByteOrder.BIG_ENDIAN;
        }
        aVar.d(byteOrder);
        int b4 = aVar.b(10) + 6;
        short a5 = aVar.a(b4);
        for (int i4 = 0; i4 < a5; i4++) {
            int a6 = a(b4, i4);
            short a7 = aVar.a(a6);
            if (a7 == 274) {
                short a8 = aVar.a(a6 + 2);
                if (a8 >= 1 && a8 <= 12) {
                    int b5 = aVar.b(a6 + 4);
                    if (b5 < 0) {
                        Log.isLoggable("ImageHeaderParser", 3);
                    } else {
                        if (Log.isLoggable("ImageHeaderParser", 3)) {
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
                        int i5 = b5 + f38481c[a8];
                        if (i5 > 4) {
                            if (Log.isLoggable("ImageHeaderParser", 3)) {
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append("Got byte count > 4, not orientation, continuing, formatCode=");
                                sb3.append((int) a8);
                            }
                        } else {
                            int i6 = a6 + 8;
                            if (i6 >= 0 && i6 <= aVar.c()) {
                                if (i5 >= 0 && i5 + i6 <= aVar.c()) {
                                    return aVar.a(i6);
                                }
                                if (Log.isLoggable("ImageHeaderParser", 3)) {
                                    StringBuilder sb4 = new StringBuilder();
                                    sb4.append("Illegal number of bytes for TI tag data tagType=");
                                    sb4.append((int) a7);
                                }
                            } else if (Log.isLoggable("ImageHeaderParser", 3)) {
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append("Illegal tagValueOffset=");
                                sb5.append(i6);
                                sb5.append(" tagType=");
                                sb5.append((int) a7);
                            }
                        }
                    }
                } else if (Log.isLoggable("ImageHeaderParser", 3)) {
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("Got invalid format code = ");
                    sb6.append((int) a8);
                }
            }
        }
        return -1;
    }

    private int f(byte[] bArr, int i4) throws IOException {
        int b4 = this.f38482a.b(bArr, i4);
        if (b4 != i4) {
            if (Log.isLoggable("ImageHeaderParser", 3)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Unable to read exif segment data, length: ");
                sb.append(i4);
                sb.append(", actually read: ");
                sb.append(b4);
            }
            return -1;
        } else if (c(bArr, i4)) {
            return e(new a(bArr, i4));
        } else {
            Log.isLoggable("ImageHeaderParser", 3);
            return -1;
        }
    }

    public int getOrientation() throws IOException {
        int a4 = this.f38482a.a();
        if (!b(a4)) {
            if (Log.isLoggable("ImageHeaderParser", 3)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Parser doesn't handle magic number: ");
                sb.append(a4);
            }
            return -1;
        }
        int d4 = d();
        if (d4 == -1) {
            Log.isLoggable("ImageHeaderParser", 3);
            return -1;
        }
        return f(new byte[d4], d4);
    }
}
