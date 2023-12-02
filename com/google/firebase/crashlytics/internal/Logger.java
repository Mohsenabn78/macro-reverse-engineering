package com.google.firebase.crashlytics.internal;

import android.util.Log;

/* loaded from: classes5.dex */
public class Logger {
    public static final String TAG = "FirebaseCrashlytics";

    /* renamed from: c  reason: collision with root package name */
    static final Logger f29367c = new Logger(TAG);

    /* renamed from: a  reason: collision with root package name */
    private final String f29368a;

    /* renamed from: b  reason: collision with root package name */
    private int f29369b = 4;

    public Logger(String str) {
        this.f29368a = str;
    }

    private boolean a(int i4) {
        if (this.f29369b > i4 && !Log.isLoggable(this.f29368a, i4)) {
            return false;
        }
        return true;
    }

    public static Logger getLogger() {
        return f29367c;
    }

    public void d(String str, Throwable th) {
        a(3);
    }

    public void e(String str, Throwable th) {
        if (a(6)) {
            Log.e(this.f29368a, str, th);
        }
    }

    public void i(String str, Throwable th) {
        if (a(4)) {
            Log.i(this.f29368a, str, th);
        }
    }

    public void log(int i4, String str) {
        log(i4, str, false);
    }

    public void v(String str, Throwable th) {
        a(2);
    }

    public void w(String str, Throwable th) {
        if (a(5)) {
            Log.w(this.f29368a, str, th);
        }
    }

    public void d(String str) {
        d(str, null);
    }

    public void log(int i4, String str, boolean z3) {
        if (z3 || a(i4)) {
            Log.println(i4, this.f29368a, str);
        }
    }

    public void v(String str) {
        v(str, null);
    }

    public void e(String str) {
        e(str, null);
    }

    public void i(String str) {
        i(str, null);
    }

    public void w(String str) {
        w(str, null);
    }
}
