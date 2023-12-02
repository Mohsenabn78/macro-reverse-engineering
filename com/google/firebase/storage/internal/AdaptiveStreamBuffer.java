package com.google.firebase.storage.internal;

import android.util.Log;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes5.dex */
public class AdaptiveStreamBuffer {

    /* renamed from: f  reason: collision with root package name */
    private static final Runtime f32353f = Runtime.getRuntime();

    /* renamed from: a  reason: collision with root package name */
    private final InputStream f32354a;

    /* renamed from: b  reason: collision with root package name */
    private byte[] f32355b;

    /* renamed from: c  reason: collision with root package name */
    private int f32356c = 0;

    /* renamed from: e  reason: collision with root package name */
    private boolean f32358e = true;

    /* renamed from: d  reason: collision with root package name */
    private boolean f32357d = false;

    public AdaptiveStreamBuffer(InputStream inputStream, int i4) {
        this.f32354a = inputStream;
        this.f32355b = new byte[i4];
    }

    private int a(int i4) {
        int max = Math.max(this.f32355b.length * 2, i4);
        Runtime runtime = f32353f;
        long maxMemory = runtime.maxMemory() - (runtime.totalMemory() - runtime.freeMemory());
        if (this.f32358e && max < maxMemory) {
            try {
                byte[] bArr = new byte[max];
                System.arraycopy(this.f32355b, 0, bArr, 0, this.f32356c);
                this.f32355b = bArr;
            } catch (OutOfMemoryError unused) {
                Log.w("AdaptiveStreamBuffer", "Turning off adaptive buffer resizing due to low memory.");
                this.f32358e = false;
            }
        } else {
            Log.w("AdaptiveStreamBuffer", "Turning off adaptive buffer resizing to conserve memory.");
        }
        return this.f32355b.length;
    }

    public int advance(int i4) throws IOException {
        int i5 = this.f32356c;
        int i6 = 0;
        if (i4 <= i5) {
            int i7 = i5 - i4;
            this.f32356c = i7;
            byte[] bArr = this.f32355b;
            System.arraycopy(bArr, i4, bArr, 0, i7);
            return i4;
        }
        this.f32356c = 0;
        while (i6 < i4) {
            int skip = (int) this.f32354a.skip(i4 - i6);
            if (skip > 0) {
                i6 += skip;
            } else if (skip != 0) {
                continue;
            } else if (this.f32354a.read() == -1) {
                break;
            } else {
                i6++;
            }
        }
        return i6;
    }

    public int available() {
        return this.f32356c;
    }

    public void close() throws IOException {
        this.f32354a.close();
    }

    public int fill(int i4) throws IOException {
        if (i4 > this.f32355b.length) {
            i4 = Math.min(i4, a(i4));
        }
        while (true) {
            int i5 = this.f32356c;
            if (i5 >= i4) {
                break;
            }
            int read = this.f32354a.read(this.f32355b, i5, i4 - i5);
            if (read == -1) {
                this.f32357d = true;
                break;
            }
            this.f32356c += read;
        }
        return this.f32356c;
    }

    public byte[] get() {
        return this.f32355b;
    }

    public boolean isFinished() {
        return this.f32357d;
    }
}
