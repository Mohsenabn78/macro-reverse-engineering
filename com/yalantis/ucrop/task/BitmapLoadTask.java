package com.yalantis.ucrop.task;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.webkit.ProxyConfig;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.yalantis.ucrop.callback.BitmapLoadCallback;
import com.yalantis.ucrop.model.ExifInfo;
import com.yalantis.ucrop.util.BitmapLoadUtils;
import com.yalantis.ucrop.util.FileUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;

/* loaded from: classes6.dex */
public class BitmapLoadTask extends AsyncTask<Void, Void, BitmapWorkerResult> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f38466a;

    /* renamed from: b  reason: collision with root package name */
    private Uri f38467b;

    /* renamed from: c  reason: collision with root package name */
    private Uri f38468c;

    /* renamed from: d  reason: collision with root package name */
    private final int f38469d;

    /* renamed from: e  reason: collision with root package name */
    private final int f38470e;

    /* renamed from: f  reason: collision with root package name */
    private final BitmapLoadCallback f38471f;

    public BitmapLoadTask(@NonNull Context context, @NonNull Uri uri, @Nullable Uri uri2, int i4, int i5, BitmapLoadCallback bitmapLoadCallback) {
        this.f38466a = context;
        this.f38467b = uri;
        this.f38468c = uri2;
        this.f38469d = i4;
        this.f38470e = i5;
        this.f38471f = bitmapLoadCallback;
    }

    private void a(@NonNull Uri uri, @Nullable Uri uri2) throws NullPointerException, IOException {
        InputStream inputStream;
        if (uri2 != null) {
            FileOutputStream fileOutputStream = null;
            try {
                inputStream = this.f38466a.getContentResolver().openInputStream(uri);
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(new File(uri2.getPath()));
                    try {
                        if (inputStream != null) {
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int read = inputStream.read(bArr);
                                if (read > 0) {
                                    fileOutputStream2.write(bArr, 0, read);
                                } else {
                                    BitmapLoadUtils.close(fileOutputStream2);
                                    BitmapLoadUtils.close(inputStream);
                                    this.f38467b = this.f38468c;
                                    return;
                                }
                            }
                        } else {
                            throw new NullPointerException("InputStream for given input Uri is null");
                        }
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        BitmapLoadUtils.close(fileOutputStream);
                        BitmapLoadUtils.close(inputStream);
                        this.f38467b = this.f38468c;
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                inputStream = null;
            }
        } else {
            throw new NullPointerException("Output Uri is null - cannot copy image");
        }
    }

    private void c(@NonNull Uri uri, @Nullable Uri uri2) throws NullPointerException, IOException {
        Closeable closeable;
        Response response;
        if (uri2 != null) {
            OkHttpClient okHttpClient = new OkHttpClient();
            BufferedSource bufferedSource = null;
            try {
                Response execute = okHttpClient.newCall(new Request.Builder().url(uri.toString()).build()).execute();
                try {
                    BufferedSource source = execute.body().source();
                    try {
                        OutputStream openOutputStream = this.f38466a.getContentResolver().openOutputStream(uri2);
                        if (openOutputStream != null) {
                            Sink sink = Okio.sink(openOutputStream);
                            source.readAll(sink);
                            BitmapLoadUtils.close(source);
                            BitmapLoadUtils.close(sink);
                            BitmapLoadUtils.close(execute.body());
                            okHttpClient.dispatcher().cancelAll();
                            this.f38467b = this.f38468c;
                            return;
                        }
                        throw new NullPointerException("OutputStream for given output Uri is null");
                    } catch (Throwable th) {
                        th = th;
                        response = execute;
                        closeable = null;
                        bufferedSource = source;
                        BitmapLoadUtils.close(bufferedSource);
                        BitmapLoadUtils.close(closeable);
                        if (response != null) {
                            BitmapLoadUtils.close(response.body());
                        }
                        okHttpClient.dispatcher().cancelAll();
                        this.f38467b = this.f38468c;
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    response = execute;
                    closeable = null;
                }
            } catch (Throwable th3) {
                th = th3;
                closeable = null;
                response = null;
            }
        } else {
            throw new NullPointerException("Output Uri is null - cannot download image");
        }
    }

    private String d() {
        if (ContextCompat.checkSelfPermission(this.f38466a, "android.permission.READ_EXTERNAL_STORAGE") == 0) {
            return FileUtils.getPath(this.f38466a, this.f38467b);
        }
        return null;
    }

    private void f() throws NullPointerException, IOException {
        String scheme = this.f38467b.getScheme();
        StringBuilder sb = new StringBuilder();
        sb.append("Uri scheme: ");
        sb.append(scheme);
        if (!"http".equals(scheme) && !ProxyConfig.MATCH_HTTPS.equals(scheme)) {
            if (FirebaseAnalytics.Param.CONTENT.equals(scheme)) {
                String d4 = d();
                if (!TextUtils.isEmpty(d4) && new File(d4).exists()) {
                    this.f38467b = Uri.fromFile(new File(d4));
                    return;
                }
                try {
                    a(this.f38467b, this.f38468c);
                    return;
                } catch (IOException | NullPointerException e4) {
                    Log.e("BitmapWorkerTask", "Copying failed", e4);
                    throw e4;
                }
            } else if (!"file".equals(scheme)) {
                Log.e("BitmapWorkerTask", "Invalid Uri scheme " + scheme);
                throw new IllegalArgumentException("Invalid Uri scheme" + scheme);
            } else {
                return;
            }
        }
        try {
            c(this.f38467b, this.f38468c);
        } catch (IOException | NullPointerException e5) {
            Log.e("BitmapWorkerTask", "Downloading failed", e5);
            throw e5;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    @NonNull
    /* renamed from: b */
    public BitmapWorkerResult doInBackground(Void... voidArr) {
        if (this.f38467b == null) {
            return new BitmapWorkerResult(new NullPointerException("Input Uri cannot be null"));
        }
        try {
            f();
            try {
                ParcelFileDescriptor openFileDescriptor = this.f38466a.getContentResolver().openFileDescriptor(this.f38467b, "r");
                if (openFileDescriptor != null) {
                    FileDescriptor fileDescriptor = openFileDescriptor.getFileDescriptor();
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
                    if (options.outWidth != -1 && options.outHeight != -1) {
                        options.inSampleSize = BitmapLoadUtils.calculateInSampleSize(options, this.f38469d, this.f38470e);
                        boolean z3 = false;
                        options.inJustDecodeBounds = false;
                        Bitmap bitmap = null;
                        while (!z3) {
                            try {
                                bitmap = BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
                                z3 = true;
                            } catch (OutOfMemoryError e4) {
                                Log.e("BitmapWorkerTask", "doInBackground: BitmapFactory.decodeFileDescriptor: ", e4);
                                options.inSampleSize *= 2;
                            }
                        }
                        if (bitmap == null) {
                            return new BitmapWorkerResult(new IllegalArgumentException("Bitmap could not be decoded from the Uri: [" + this.f38467b + "]"));
                        }
                        BitmapLoadUtils.close(openFileDescriptor);
                        int exifOrientation = BitmapLoadUtils.getExifOrientation(this.f38466a, this.f38467b);
                        int exifToDegrees = BitmapLoadUtils.exifToDegrees(exifOrientation);
                        int exifToTranslation = BitmapLoadUtils.exifToTranslation(exifOrientation);
                        ExifInfo exifInfo = new ExifInfo(exifOrientation, exifToDegrees, exifToTranslation);
                        Matrix matrix = new Matrix();
                        if (exifToDegrees != 0) {
                            matrix.preRotate(exifToDegrees);
                        }
                        if (exifToTranslation != 1) {
                            matrix.postScale(exifToTranslation, 1.0f);
                        }
                        if (!matrix.isIdentity()) {
                            return new BitmapWorkerResult(BitmapLoadUtils.transformBitmap(bitmap, matrix), exifInfo);
                        }
                        return new BitmapWorkerResult(bitmap, exifInfo);
                    }
                    return new BitmapWorkerResult(new IllegalArgumentException("Bounds for bitmap could not be retrieved from the Uri: [" + this.f38467b + "]"));
                }
                return new BitmapWorkerResult(new NullPointerException("ParcelFileDescriptor was null for given Uri: [" + this.f38467b + "]"));
            } catch (FileNotFoundException e5) {
                return new BitmapWorkerResult(e5);
            }
        } catch (IOException | NullPointerException e6) {
            return new BitmapWorkerResult(e6);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: e */
    public void onPostExecute(@NonNull BitmapWorkerResult bitmapWorkerResult) {
        String path;
        Exception exc = bitmapWorkerResult.f38474c;
        if (exc == null) {
            BitmapLoadCallback bitmapLoadCallback = this.f38471f;
            Bitmap bitmap = bitmapWorkerResult.f38472a;
            ExifInfo exifInfo = bitmapWorkerResult.f38473b;
            String path2 = this.f38467b.getPath();
            Uri uri = this.f38468c;
            if (uri == null) {
                path = null;
            } else {
                path = uri.getPath();
            }
            bitmapLoadCallback.onBitmapLoaded(bitmap, exifInfo, path2, path);
            return;
        }
        this.f38471f.onFailure(exc);
    }

    /* loaded from: classes6.dex */
    public static class BitmapWorkerResult {

        /* renamed from: a  reason: collision with root package name */
        Bitmap f38472a;

        /* renamed from: b  reason: collision with root package name */
        ExifInfo f38473b;

        /* renamed from: c  reason: collision with root package name */
        Exception f38474c;

        public BitmapWorkerResult(@NonNull Bitmap bitmap, @NonNull ExifInfo exifInfo) {
            this.f38472a = bitmap;
            this.f38473b = exifInfo;
        }

        public BitmapWorkerResult(@NonNull Exception exc) {
            this.f38474c = exc;
        }
    }
}
