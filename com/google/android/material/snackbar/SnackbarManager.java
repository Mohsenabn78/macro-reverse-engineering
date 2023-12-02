package com.google.android.material.snackbar;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class SnackbarManager {

    /* renamed from: e  reason: collision with root package name */
    private static SnackbarManager f24452e;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final Object f24453a = new Object();
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final Handler f24454b = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.google.android.material.snackbar.SnackbarManager.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(@NonNull Message message) {
            if (message.what != 0) {
                return false;
            }
            SnackbarManager.this.d((SnackbarRecord) message.obj);
            return true;
        }
    });
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private SnackbarRecord f24455c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private SnackbarRecord f24456d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public interface Callback {
        void a(int i4);

        void show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class SnackbarRecord {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        final WeakReference<Callback> f24458a;

        /* renamed from: b  reason: collision with root package name */
        int f24459b;

        /* renamed from: c  reason: collision with root package name */
        boolean f24460c;

        SnackbarRecord(int i4, Callback callback) {
            this.f24458a = new WeakReference<>(callback);
            this.f24459b = i4;
        }

        boolean a(@Nullable Callback callback) {
            if (callback != null && this.f24458a.get() == callback) {
                return true;
            }
            return false;
        }
    }

    private SnackbarManager() {
    }

    private boolean a(@NonNull SnackbarRecord snackbarRecord, int i4) {
        Callback callback = snackbarRecord.f24458a.get();
        if (callback != null) {
            this.f24454b.removeCallbacksAndMessages(snackbarRecord);
            callback.a(i4);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SnackbarManager c() {
        if (f24452e == null) {
            f24452e = new SnackbarManager();
        }
        return f24452e;
    }

    private boolean g(Callback callback) {
        SnackbarRecord snackbarRecord = this.f24455c;
        if (snackbarRecord != null && snackbarRecord.a(callback)) {
            return true;
        }
        return false;
    }

    private boolean h(Callback callback) {
        SnackbarRecord snackbarRecord = this.f24456d;
        if (snackbarRecord != null && snackbarRecord.a(callback)) {
            return true;
        }
        return false;
    }

    private void m(@NonNull SnackbarRecord snackbarRecord) {
        int i4 = snackbarRecord.f24459b;
        if (i4 == -2) {
            return;
        }
        if (i4 <= 0) {
            if (i4 == -1) {
                i4 = ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED;
            } else {
                i4 = 2750;
            }
        }
        this.f24454b.removeCallbacksAndMessages(snackbarRecord);
        Handler handler = this.f24454b;
        handler.sendMessageDelayed(Message.obtain(handler, 0, snackbarRecord), i4);
    }

    private void o() {
        SnackbarRecord snackbarRecord = this.f24456d;
        if (snackbarRecord != null) {
            this.f24455c = snackbarRecord;
            this.f24456d = null;
            Callback callback = snackbarRecord.f24458a.get();
            if (callback != null) {
                callback.show();
            } else {
                this.f24455c = null;
            }
        }
    }

    public void b(Callback callback, int i4) {
        synchronized (this.f24453a) {
            if (g(callback)) {
                a(this.f24455c, i4);
            } else if (h(callback)) {
                a(this.f24456d, i4);
            }
        }
    }

    void d(@NonNull SnackbarRecord snackbarRecord) {
        synchronized (this.f24453a) {
            if (this.f24455c == snackbarRecord || this.f24456d == snackbarRecord) {
                a(snackbarRecord, 2);
            }
        }
    }

    public boolean e(Callback callback) {
        boolean g4;
        synchronized (this.f24453a) {
            g4 = g(callback);
        }
        return g4;
    }

    public boolean f(Callback callback) {
        boolean z3;
        synchronized (this.f24453a) {
            if (!g(callback) && !h(callback)) {
                z3 = false;
            }
            z3 = true;
        }
        return z3;
    }

    public void i(Callback callback) {
        synchronized (this.f24453a) {
            if (g(callback)) {
                this.f24455c = null;
                if (this.f24456d != null) {
                    o();
                }
            }
        }
    }

    public void j(Callback callback) {
        synchronized (this.f24453a) {
            if (g(callback)) {
                m(this.f24455c);
            }
        }
    }

    public void k(Callback callback) {
        synchronized (this.f24453a) {
            if (g(callback)) {
                SnackbarRecord snackbarRecord = this.f24455c;
                if (!snackbarRecord.f24460c) {
                    snackbarRecord.f24460c = true;
                    this.f24454b.removeCallbacksAndMessages(snackbarRecord);
                }
            }
        }
    }

    public void l(Callback callback) {
        synchronized (this.f24453a) {
            if (g(callback)) {
                SnackbarRecord snackbarRecord = this.f24455c;
                if (snackbarRecord.f24460c) {
                    snackbarRecord.f24460c = false;
                    m(snackbarRecord);
                }
            }
        }
    }

    public void n(int i4, Callback callback) {
        synchronized (this.f24453a) {
            if (g(callback)) {
                SnackbarRecord snackbarRecord = this.f24455c;
                snackbarRecord.f24459b = i4;
                this.f24454b.removeCallbacksAndMessages(snackbarRecord);
                m(this.f24455c);
                return;
            }
            if (h(callback)) {
                this.f24456d.f24459b = i4;
            } else {
                this.f24456d = new SnackbarRecord(i4, callback);
            }
            SnackbarRecord snackbarRecord2 = this.f24455c;
            if (snackbarRecord2 != null && a(snackbarRecord2, 4)) {
                return;
            }
            this.f24455c = null;
            o();
        }
    }
}
