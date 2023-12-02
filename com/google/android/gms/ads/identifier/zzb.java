package com.google.android.gms.ads.identifier;

import com.google.android.gms.common.util.VisibleForTesting;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads-identifier@@17.1.0 */
@VisibleForTesting
/* loaded from: classes4.dex */
public final class zzb extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<AdvertisingIdClient> f19037a;

    /* renamed from: b  reason: collision with root package name */
    private final long f19038b;

    /* renamed from: c  reason: collision with root package name */
    final CountDownLatch f19039c = new CountDownLatch(1);

    /* renamed from: d  reason: collision with root package name */
    boolean f19040d = false;

    public zzb(AdvertisingIdClient advertisingIdClient, long j4) {
        this.f19037a = new WeakReference<>(advertisingIdClient);
        this.f19038b = j4;
        start();
    }

    private final void a() {
        AdvertisingIdClient advertisingIdClient = this.f19037a.get();
        if (advertisingIdClient != null) {
            advertisingIdClient.zza();
            this.f19040d = true;
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        try {
            if (!this.f19039c.await(this.f19038b, TimeUnit.MILLISECONDS)) {
                a();
            }
        } catch (InterruptedException unused) {
            a();
        }
    }
}
