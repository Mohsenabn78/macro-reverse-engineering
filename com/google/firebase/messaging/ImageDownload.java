package com.google.firebase.messaging;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/* loaded from: classes5.dex */
public class ImageDownload implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    private final URL f31671a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private volatile Future<?> f31672b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private Task<Bitmap> f31673c;

    private ImageDownload(URL url) {
        this.f31671a = url;
    }

    private byte[] c() throws IOException {
        URLConnection openConnection = this.f31671a.openConnection();
        if (openConnection.getContentLength() <= 1048576) {
            InputStream inputStream = openConnection.getInputStream();
            try {
                byte[] d4 = ByteStreams.d(ByteStreams.b(inputStream, 1048577L));
                if (inputStream != null) {
                    inputStream.close();
                }
                if (Log.isLoggable(Constants.TAG, 2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Downloaded ");
                    sb.append(d4.length);
                    sb.append(" bytes from ");
                    sb.append(this.f31671a);
                }
                if (d4.length <= 1048576) {
                    return d4;
                }
                throw new IOException("Image exceeds max size of 1048576");
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
        throw new IOException("Content-Length exceeds max size of 1048576");
    }

    @Nullable
    public static ImageDownload create(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new ImageDownload(new URL(str));
        } catch (MalformedURLException unused) {
            Log.w(Constants.TAG, "Not downloading image, bad URL: " + str);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(TaskCompletionSource taskCompletionSource) {
        try {
            taskCompletionSource.setResult(blockingDownload());
        } catch (Exception e4) {
            taskCompletionSource.setException(e4);
        }
    }

    public Bitmap blockingDownload() throws IOException {
        if (Log.isLoggable(Constants.TAG, 4)) {
            Log.i(Constants.TAG, "Starting download of: " + this.f31671a);
        }
        byte[] c4 = c();
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(c4, 0, c4.length);
        if (decodeByteArray != null) {
            if (Log.isLoggable(Constants.TAG, 3)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Successfully downloaded image: ");
                sb.append(this.f31671a);
            }
            return decodeByteArray;
        }
        throw new IOException("Failed to decode image: " + this.f31671a);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f31672b.cancel(true);
    }

    public Task<Bitmap> getTask() {
        return (Task) Preconditions.checkNotNull(this.f31673c);
    }

    public void start(ExecutorService executorService) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f31672b = executorService.submit(new Runnable() { // from class: com.google.firebase.messaging.w
            @Override // java.lang.Runnable
            public final void run() {
                ImageDownload.this.d(taskCompletionSource);
            }
        });
        this.f31673c = taskCompletionSource.getTask();
    }
}
