package com.google.firebase.storage.internal;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.firebase.appcheck.interop.InteropAppCheckTokenProvider;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.storage.network.NetworkRequest;
import java.util.Random;

/* loaded from: classes5.dex */
public class ExponentialBackoffSender {
    public static final int RND_MAX = 250;

    /* renamed from: f  reason: collision with root package name */
    private static final Random f32359f = new Random();

    /* renamed from: g  reason: collision with root package name */
    static Sleeper f32360g = new SleeperImpl();

    /* renamed from: h  reason: collision with root package name */
    static Clock f32361h = DefaultClock.getInstance();

    /* renamed from: a  reason: collision with root package name */
    private final Context f32362a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final InternalAuthProvider f32363b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final InteropAppCheckTokenProvider f32364c;

    /* renamed from: d  reason: collision with root package name */
    private long f32365d;

    /* renamed from: e  reason: collision with root package name */
    private volatile boolean f32366e;

    public ExponentialBackoffSender(Context context, @Nullable InternalAuthProvider internalAuthProvider, @Nullable InteropAppCheckTokenProvider interopAppCheckTokenProvider, long j4) {
        this.f32362a = context;
        this.f32363b = internalAuthProvider;
        this.f32364c = interopAppCheckTokenProvider;
        this.f32365d = j4;
    }

    public void cancel() {
        this.f32366e = true;
    }

    public boolean isRetryableError(int i4) {
        if ((i4 < 500 || i4 >= 600) && i4 != -2 && i4 != 429 && i4 != 408) {
            return false;
        }
        return true;
    }

    public void reset() {
        this.f32366e = false;
    }

    public void sendWithExponentialBackoff(@NonNull NetworkRequest networkRequest) {
        sendWithExponentialBackoff(networkRequest, true);
    }

    public void sendWithExponentialBackoff(@NonNull NetworkRequest networkRequest, boolean z3) {
        Preconditions.checkNotNull(networkRequest);
        long elapsedRealtime = f32361h.elapsedRealtime() + this.f32365d;
        if (z3) {
            networkRequest.performRequest(Util.getCurrentAuthToken(this.f32363b), Util.getCurrentAppCheckToken(this.f32364c), this.f32362a);
        } else {
            networkRequest.performRequestStart(Util.getCurrentAuthToken(this.f32363b), Util.getCurrentAppCheckToken(this.f32364c));
        }
        int i4 = 1000;
        while (f32361h.elapsedRealtime() + i4 <= elapsedRealtime && !networkRequest.isResultSuccess() && isRetryableError(networkRequest.getResultCode())) {
            try {
                f32360g.sleep(f32359f.nextInt(250) + i4);
                if (i4 < 30000) {
                    if (networkRequest.getResultCode() != -2) {
                        i4 *= 2;
                        Log.w("ExponenentialBackoff", "network error occurred, backing off/sleeping.");
                    } else {
                        Log.w("ExponenentialBackoff", "network unavailable, sleeping.");
                        i4 = 1000;
                    }
                }
                if (this.f32366e) {
                    return;
                }
                networkRequest.reset();
                if (z3) {
                    networkRequest.performRequest(Util.getCurrentAuthToken(this.f32363b), Util.getCurrentAppCheckToken(this.f32364c), this.f32362a);
                } else {
                    networkRequest.performRequestStart(Util.getCurrentAuthToken(this.f32363b), Util.getCurrentAppCheckToken(this.f32364c));
                }
            } catch (InterruptedException unused) {
                Log.w("ExponenentialBackoff", "thread interrupted during exponential backoff.");
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}
