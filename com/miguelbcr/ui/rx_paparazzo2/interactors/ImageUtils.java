package com.miguelbcr.ui.rx_paparazzo2.interactors;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.MimeTypeMap;
import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.miguelbcr.ui.rx_paparazzo2.entities.Config;
import com.miguelbcr.ui.rx_paparazzo2.entities.FileData;
import com.miguelbcr.ui.rx_paparazzo2.entities.TargetUi;
import com.miguelbcr.ui.rx_paparazzo2.entities.size.OriginalSize;
import io.reactivex.exceptions.Exceptions;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes6.dex */
public final class ImageUtils {
    public static final String JPG_FILE_EXTENSION = "jpg";
    public static final String MIME_TYPE_IMAGE_WILDCARD = "image/*";
    public static final String MIME_TYPE_JPEG = "image/jpeg";

    /* renamed from: c  reason: collision with root package name */
    private static final String f36218c = "ImageUtils";

    /* renamed from: a  reason: collision with root package name */
    private final TargetUi f36219a;

    /* renamed from: b  reason: collision with root package name */
    private final Config f36220b;

    public ImageUtils(TargetUi targetUi, Config config) {
        this.f36219a = targetUi;
        this.f36220b = config;
    }

    private void a(Bitmap bitmap, File file, Bitmap.CompressFormat compressFormat) {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    bitmap.compress(compressFormat, 90, fileOutputStream2);
                    try {
                        fileOutputStream2.flush();
                        fileOutputStream2.close();
                    } catch (IOException unused) {
                    }
                } catch (Exception e4) {
                    e = e4;
                    fileOutputStream = fileOutputStream2;
                    Log.e(f36218c, String.format("Could not save bitmap file to '%s'", file.getAbsolutePath()), e);
                    throw Exceptions.propagate(e);
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.flush();
                            fileOutputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e5) {
            e = e5;
        }
    }

    private int b(BitmapFactory.Options options, int i4, int i5) {
        Dimensions g4 = g(options.outWidth, options.outHeight);
        Dimensions g5 = g(i4, i5);
        float width = g4.getWidth();
        float height = g4.getHeight();
        float width2 = g5.getWidth();
        float height2 = g5.getHeight();
        if (height <= height2 && width <= width2) {
            return 1;
        }
        int round = Math.round(height / height2);
        int round2 = Math.round(width / width2);
        if (round >= round2) {
            round = round2;
        }
        float f4 = width * height;
        int i6 = round;
        while (f4 / (i6 * i6) > width2 * height2 * 2.0f) {
            i6++;
        }
        return i6;
    }

    private void c(File file, File file2, Dimensions dimensions) {
        String[] i4;
        try {
            String absolutePath = file2.getAbsolutePath();
            String absolutePath2 = file.getAbsolutePath();
            if (f(absolutePath) == Bitmap.CompressFormat.JPEG) {
                ExifInterface exifInterface = new ExifInterface(absolutePath2);
                ExifInterface exifInterface2 = new ExifInterface(absolutePath);
                for (String str : i()) {
                    String attribute = exifInterface.getAttribute(str);
                    if (!TextUtils.isEmpty(attribute)) {
                        exifInterface2.setAttribute(str, attribute);
                    }
                }
                exifInterface2.setAttribute(ExifInterface.TAG_IMAGE_WIDTH, String.valueOf(dimensions.getWidth()));
                exifInterface2.setAttribute(ExifInterface.TAG_IMAGE_LENGTH, String.valueOf(dimensions.getHeight()));
                exifInterface2.saveAttributes();
            }
        } catch (IOException unused) {
            String.format("Could not copy exif tags from '%s'", file.getAbsolutePath());
        }
    }

    private void d(File file, File file2, Dimensions dimensions) {
        copy(file, file2);
        c(file, file2, dimensions);
    }

    private File e(File file, String str, String str2) {
        File file2 = new File(file.getAbsolutePath(), createTimestampedFilename(str, str2));
        while (file2.exists()) {
            file2 = new File(file.getAbsolutePath(), createTimestampedFilename(str, str2));
        }
        return file2;
    }

    private Bitmap.CompressFormat f(String str) {
        Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.JPEG;
        if (getFileExtension(str).toLowerCase().contains("png")) {
            return Bitmap.CompressFormat.PNG;
        }
        return compressFormat;
    }

    private Dimensions g(int i4, int i5) {
        if (i4 < i5) {
            return new Dimensions(i4, i5);
        }
        return new Dimensions(i5, i4);
    }

    public static String getFileName(String str) {
        return new File(str).getName();
    }

    public static Dimensions getImageDimensions(File file) {
        String absolutePath = file.getAbsolutePath();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(absolutePath, options);
        return new Dimensions(options.outWidth, options.outHeight);
    }

    public static String getMimeType(Context context, Uri uri) {
        if (uri.getScheme().equals(FirebaseAnalytics.Param.CONTENT)) {
            return context.getContentResolver().getType(uri);
        }
        return getMimeType(uri.toString());
    }

    private File h(String str, String str2) {
        File file;
        if (!this.f36220b.isUseInternalStorage()) {
            file = l(str, str2);
        } else {
            file = null;
        }
        if (file == null) {
            return k(str2);
        }
        return file;
    }

    private String[] i() {
        return new String[]{ExifInterface.TAG_DATETIME, ExifInterface.TAG_EXPOSURE_TIME, ExifInterface.TAG_FLASH, ExifInterface.TAG_FOCAL_LENGTH, ExifInterface.TAG_GPS_ALTITUDE, ExifInterface.TAG_GPS_ALTITUDE_REF, ExifInterface.TAG_GPS_DATESTAMP, ExifInterface.TAG_GPS_LATITUDE, ExifInterface.TAG_GPS_LATITUDE_REF, ExifInterface.TAG_GPS_LONGITUDE, ExifInterface.TAG_GPS_LONGITUDE_REF, ExifInterface.TAG_GPS_PROCESSING_METHOD, ExifInterface.TAG_WHITE_BALANCE, ExifInterface.TAG_ORIENTATION, ExifInterface.TAG_MAKE, ExifInterface.TAG_GPS_TIMESTAMP, ExifInterface.TAG_MODEL, ExifInterface.TAG_ISO_SPEED_RATINGS, ExifInterface.TAG_SUBSEC_TIME, ExifInterface.TAG_DATETIME_DIGITIZED, ExifInterface.TAG_SUBSEC_TIME_DIGITIZED, ExifInterface.TAG_SUBSEC_TIME_ORIGINAL, ExifInterface.TAG_METERING_MODE, ExifInterface.TAG_F_NUMBER};
    }

    private File k(String str) {
        File filesDir = this.f36219a.getContext().getFilesDir();
        if (!TextUtils.isEmpty(str)) {
            filesDir = new File(filesDir, str);
        }
        if (!filesDir.exists() && !filesDir.mkdirs()) {
            return null;
        }
        return filesDir;
    }

    private File l(String str, String str2) {
        File externalStoragePublicDirectory;
        if (!Environment.getExternalStorageState().equals("mounted")) {
            return null;
        }
        if (str == null) {
            externalStoragePublicDirectory = Environment.getExternalStorageDirectory();
        } else {
            externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(str);
        }
        File file = new File(externalStoragePublicDirectory, str2);
        if (!file.exists() && !file.mkdirs()) {
            return null;
        }
        return file;
    }

    private Bitmap m(File file, int i4, int i5) {
        BitmapFactory.Options n4 = n(file, i4, i5);
        if (n4.inSampleSize == 1) {
            return null;
        }
        n4.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(file.getAbsolutePath(), n4);
    }

    private BitmapFactory.Options n(File file, int i4, int i5) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(file.getAbsolutePath(), options);
        if (i4 > 0 && i5 > 0) {
            options.inSampleSize = b(options, i4, i5);
        } else {
            options.inSampleSize = 1;
        }
        return options;
    }

    public static String stripPathFromFilename(String str) {
        int lastIndexOf = str.lastIndexOf(RemoteSettings.FORWARD_SLASH_STRING);
        if (lastIndexOf == -1) {
            return str;
        }
        return str.substring(lastIndexOf + 1);
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0041: MOVE  (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:21:0x0041 */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0049 A[Catch: IOException -> 0x004f, TRY_LEAVE, TryCatch #3 {IOException -> 0x004f, blocks: (B:23:0x0044, B:25:0x0049), top: B:30:0x0044 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0044 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void copy(java.io.InputStream r7, java.io.File r8) {
        /*
            r6 = this;
            r0 = 0
            r1 = 0
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L21 java.io.IOException -> L23
            r2.<init>(r8)     // Catch: java.lang.Throwable -> L21 java.io.IOException -> L23
            r1 = 1024(0x400, float:1.435E-42)
            byte[] r1 = new byte[r1]     // Catch: java.io.IOException -> L1f java.lang.Throwable -> L40
        Lb:
            int r3 = r7.read(r1)     // Catch: java.io.IOException -> L1f java.lang.Throwable -> L40
            if (r3 <= 0) goto L15
            r2.write(r1, r0, r3)     // Catch: java.io.IOException -> L1f java.lang.Throwable -> L40
            goto Lb
        L15:
            r7.close()     // Catch: java.io.IOException -> L1e
            r2.flush()     // Catch: java.io.IOException -> L1e
            r2.close()     // Catch: java.io.IOException -> L1e
        L1e:
            return
        L1f:
            r1 = move-exception
            goto L27
        L21:
            r8 = move-exception
            goto L42
        L23:
            r2 = move-exception
            r5 = r2
            r2 = r1
            r1 = r5
        L27:
            java.lang.String r3 = "Could not copy file to '%s'"
            r4 = 1
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> L40
            java.lang.String r8 = r8.getAbsolutePath()     // Catch: java.lang.Throwable -> L40
            r4[r0] = r8     // Catch: java.lang.Throwable -> L40
            java.lang.String r8 = java.lang.String.format(r3, r4)     // Catch: java.lang.Throwable -> L40
            java.lang.String r0 = com.miguelbcr.ui.rx_paparazzo2.interactors.ImageUtils.f36218c     // Catch: java.lang.Throwable -> L40
            android.util.Log.e(r0, r8, r1)     // Catch: java.lang.Throwable -> L40
            java.lang.RuntimeException r8 = io.reactivex.exceptions.Exceptions.propagate(r1)     // Catch: java.lang.Throwable -> L40
            throw r8     // Catch: java.lang.Throwable -> L40
        L40:
            r8 = move-exception
            r1 = r2
        L42:
            if (r7 == 0) goto L47
            r7.close()     // Catch: java.io.IOException -> L4f
        L47:
            if (r1 == 0) goto L4f
            r1.flush()     // Catch: java.io.IOException -> L4f
            r1.close()     // Catch: java.io.IOException -> L4f
        L4f:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.miguelbcr.ui.rx_paparazzo2.interactors.ImageUtils.copy(java.io.InputStream, java.io.File):void");
    }

    public String createTimestampedFilename(String str, String str2) {
        String format = new SimpleDateFormat("yyyyMMdd_HHmm_ssSSS", new Locale("en")).format(new Date());
        if (!TextUtils.isEmpty(str2) && !str2.startsWith(".")) {
            str2 = "." + str2;
        }
        return str + format + str2;
    }

    public String getFileExtension(String str) {
        return getFileExtension(str, "");
    }

    public File getOutputFile(String str, String str2) {
        return e(h(null, this.f36220b.getFileProviderDirectory()), str, str2);
    }

    public File getPrivateFile(String str, String str2) {
        File file = new File(this.f36219a.getContext().getFilesDir(), str);
        file.mkdirs();
        return new File(file, str2);
    }

    public boolean isImage(File file) {
        BitmapFactory.Options n4 = n(file, 0, 0);
        if (n4.outWidth <= 0 || n4.outHeight <= 0) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String j(Uri uri) {
        String mimeType = getMimeType(this.f36219a.getContext(), uri);
        if (TextUtils.isEmpty(mimeType)) {
            return getFileExtension(uri.getLastPathSegment());
        }
        return mimeType.split(RemoteSettings.FORWARD_SLASH_STRING)[1];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FileData o(FileData fileData, File file, Dimensions dimensions) {
        String str;
        String str2;
        File file2 = fileData.getFile();
        if (this.f36220b.getSize() instanceof OriginalSize) {
            d(file2, file, dimensions);
            str2 = fileData.getMimeType();
        } else {
            Bitmap m4 = m(file2, dimensions.getWidth(), dimensions.getHeight());
            if (m4 == null) {
                d(file2, file, dimensions);
                str2 = fileData.getMimeType();
            } else {
                Bitmap.CompressFormat f4 = f(file.getName());
                if (Bitmap.CompressFormat.JPEG == f4) {
                    str = MIME_TYPE_JPEG;
                } else if (Bitmap.CompressFormat.PNG == f4) {
                    str = "image/png";
                } else {
                    throw new IllegalStateException(String.format("Received unexpected compression format '%s'", f4));
                }
                a(m4, file, f4);
                c(file2, file, dimensions);
                str2 = str;
            }
        }
        return new FileData(fileData, file, true, str2);
    }

    public String getFileExtension(String str, String str2) {
        int lastIndexOf;
        String str3 = "";
        if (str != null && (lastIndexOf = str.lastIndexOf(46)) > 0) {
            str3 = str.substring(lastIndexOf + 1);
        }
        return (!TextUtils.isEmpty(str3) || TextUtils.isEmpty(str2)) ? str3 : str2;
    }

    public static String getMimeType(String str) {
        return MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(str).toLowerCase());
    }

    public void copy(File file, File file2) {
        try {
            copy(new FileInputStream(file), file2);
        } catch (IOException e4) {
            Log.e(f36218c, String.format("Could not copy file to '%s'", file2.getAbsolutePath()), e4);
            throw Exceptions.propagate(e4);
        }
    }
}
