package com.google.firebase.firestore.remote;

import com.google.firebase.firestore.core.OnlineState;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.AsyncQueue;
import com.google.firebase.firestore.util.Logger;
import io.grpc.Status;
import java.util.Locale;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class OnlineStateTracker {

    /* renamed from: b  reason: collision with root package name */
    private int f31123b;

    /* renamed from: c  reason: collision with root package name */
    private AsyncQueue.DelayedTask f31124c;

    /* renamed from: e  reason: collision with root package name */
    private final AsyncQueue f31126e;

    /* renamed from: f  reason: collision with root package name */
    private final OnlineStateCallback f31127f;

    /* renamed from: a  reason: collision with root package name */
    private OnlineState f31122a = OnlineState.UNKNOWN;

    /* renamed from: d  reason: collision with root package name */
    private boolean f31125d = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public interface OnlineStateCallback {
        void handleOnlineStateChange(OnlineState onlineState);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OnlineStateTracker(AsyncQueue asyncQueue, OnlineStateCallback onlineStateCallback) {
        this.f31126e = asyncQueue;
        this.f31127f = onlineStateCallback;
    }

    private void b() {
        AsyncQueue.DelayedTask delayedTask = this.f31124c;
        if (delayedTask != null) {
            delayedTask.cancel();
            this.f31124c = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f() {
        boolean z3;
        this.f31124c = null;
        if (this.f31122a == OnlineState.UNKNOWN) {
            z3 = true;
        } else {
            z3 = false;
        }
        Assert.hardAssert(z3, "Timer should be canceled if we transitioned to a different state.", new Object[0]);
        g(String.format(Locale.ENGLISH, "Backend didn't respond within %d seconds\n", 10));
        h(OnlineState.OFFLINE);
    }

    private void g(String str) {
        String format = String.format("Could not reach Cloud Firestore backend. %s\nThis typically indicates that your device does not have a healthy Internet connection at the moment. The client will operate in offline mode until it is able to successfully connect to the backend.", str);
        if (this.f31125d) {
            Logger.warn("OnlineStateTracker", "%s", format);
            this.f31125d = false;
            return;
        }
        Logger.debug("OnlineStateTracker", "%s", format);
    }

    private void h(OnlineState onlineState) {
        if (onlineState != this.f31122a) {
            this.f31122a = onlineState;
            this.f31127f.handleOnlineStateChange(onlineState);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OnlineState c() {
        return this.f31122a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(Status status) {
        boolean z3;
        boolean z4 = true;
        if (this.f31122a == OnlineState.ONLINE) {
            h(OnlineState.UNKNOWN);
            if (this.f31123b == 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            Assert.hardAssert(z3, "watchStreamFailures must be 0", new Object[0]);
            if (this.f31124c != null) {
                z4 = false;
            }
            Assert.hardAssert(z4, "onlineStateTimer must be null", new Object[0]);
            return;
        }
        int i4 = this.f31123b + 1;
        this.f31123b = i4;
        if (i4 >= 1) {
            b();
            g(String.format(Locale.ENGLISH, "Connection failed %d times. Most recent error: %s", 1, status));
            h(OnlineState.OFFLINE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        boolean z3;
        if (this.f31123b == 0) {
            h(OnlineState.UNKNOWN);
            if (this.f31124c == null) {
                z3 = true;
            } else {
                z3 = false;
            }
            Assert.hardAssert(z3, "onlineStateTimer shouldn't be started yet", new Object[0]);
            this.f31124c = this.f31126e.enqueueAfterDelay(AsyncQueue.TimerId.ONLINE_STATE_TIMEOUT, 10000L, new Runnable() { // from class: com.google.firebase.firestore.remote.w
                @Override // java.lang.Runnable
                public final void run() {
                    OnlineStateTracker.this.f();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(OnlineState onlineState) {
        b();
        this.f31123b = 0;
        if (onlineState == OnlineState.ONLINE) {
            this.f31125d = false;
        }
        h(onlineState);
    }
}
