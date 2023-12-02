package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;
import com.bumptech.glide.load.DecodeFormat;
import java.io.File;

/* compiled from: HardwareConfigState.java */
/* loaded from: classes3.dex */
final class b {

    /* renamed from: c  reason: collision with root package name */
    private static final File f17279c = new File("/proc/self/fd");

    /* renamed from: d  reason: collision with root package name */
    private static volatile b f17280d;

    /* renamed from: a  reason: collision with root package name */
    private volatile int f17281a;

    /* renamed from: b  reason: collision with root package name */
    private volatile boolean f17282b = true;

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b a() {
        if (f17280d == null) {
            synchronized (b.class) {
                if (f17280d == null) {
                    f17280d = new b();
                }
            }
        }
        return f17280d;
    }

    private synchronized boolean b() {
        boolean z3 = true;
        int i4 = this.f17281a + 1;
        this.f17281a = i4;
        if (i4 >= 50) {
            this.f17281a = 0;
            int length = f17279c.list().length;
            if (length >= 700) {
                z3 = false;
            }
            this.f17282b = z3;
            if (!this.f17282b && Log.isLoggable("Downsampler", 5)) {
                Log.w("Downsampler", "Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors " + length + ", limit 700");
            }
        }
        return this.f17282b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(26)
    public boolean c(int i4, int i5, BitmapFactory.Options options, DecodeFormat decodeFormat, boolean z3, boolean z4) {
        boolean z5;
        Bitmap.Config config;
        if (!z3 || Build.VERSION.SDK_INT < 26 || z4) {
            return false;
        }
        if (i4 >= 128 && i5 >= 128 && b()) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (z5) {
            config = Bitmap.Config.HARDWARE;
            options.inPreferredConfig = config;
            options.inMutable = false;
        }
        return z5;
    }
}
