package com.bumptech.glide.util;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes3.dex */
public final class ContentLengthInputStream extends FilterInputStream {

    /* renamed from: a  reason: collision with root package name */
    private final long f17567a;

    /* renamed from: b  reason: collision with root package name */
    private int f17568b;

    private ContentLengthInputStream(@NonNull InputStream inputStream, long j4) {
        super(inputStream);
        this.f17567a = j4;
    }

    private int b(int i4) throws IOException {
        if (i4 >= 0) {
            this.f17568b += i4;
        } else if (this.f17567a - this.f17568b > 0) {
            throw new IOException("Failed to read all expected data, expected: " + this.f17567a + ", but read: " + this.f17568b);
        }
        return i4;
    }

    private static int c(@Nullable String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException unused) {
                if (Log.isLoggable("ContentLengthStream", 3)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("failed to parse content length header: ");
                    sb.append(str);
                }
            }
        }
        return -1;
    }

    @NonNull
    public static InputStream obtain(@NonNull InputStream inputStream, @Nullable String str) {
        return obtain(inputStream, c(str));
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        return (int) Math.max(this.f17567a - this.f17568b, ((FilterInputStream) this).in.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        int read;
        read = super.read();
        b(read >= 0 ? 1 : -1);
        return read;
    }

    @NonNull
    public static InputStream obtain(@NonNull InputStream inputStream, long j4) {
        return new ContentLengthInputStream(inputStream, j4);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i4, int i5) throws IOException {
        return b(super.read(bArr, i4, i5));
    }
}
