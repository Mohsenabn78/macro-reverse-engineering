package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
@KeepForSdk
/* loaded from: classes4.dex */
public class BlockingServiceConnection implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    boolean f19951a = false;

    /* renamed from: b  reason: collision with root package name */
    private final BlockingQueue f19952b = new LinkedBlockingQueue();

    @NonNull
    @KeepForSdk
    public IBinder getService() throws InterruptedException {
        Preconditions.checkNotMainThread("BlockingServiceConnection.getService() called on main thread");
        if (!this.f19951a) {
            this.f19951a = true;
            return (IBinder) this.f19952b.take();
        }
        throw new IllegalStateException("Cannot call get on this connection more than once");
    }

    @NonNull
    @KeepForSdk
    public IBinder getServiceWithTimeout(long j4, @NonNull TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        Preconditions.checkNotMainThread("BlockingServiceConnection.getServiceWithTimeout() called on main thread");
        if (!this.f19951a) {
            this.f19951a = true;
            IBinder iBinder = (IBinder) this.f19952b.poll(j4, timeUnit);
            if (iBinder != null) {
                return iBinder;
            }
            throw new TimeoutException("Timed out waiting for the service connection");
        }
        throw new IllegalStateException("Cannot call get on this connection more than once");
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(@NonNull ComponentName componentName, @NonNull IBinder iBinder) {
        this.f19952b.add(iBinder);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(@NonNull ComponentName componentName) {
    }
}
