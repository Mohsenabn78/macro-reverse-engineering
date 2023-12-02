package com.google.android.gms.wearable;

import com.google.android.gms.common.data.DataHolder;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
final class zzq implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ DataHolder f22871a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzaa f22872b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzq(zzaa zzaaVar, DataHolder dataHolder) {
        this.f22872b = zzaaVar;
        this.f22871a = dataHolder;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DataEventBuffer dataEventBuffer = new DataEventBuffer(this.f22871a);
        try {
            this.f22872b.f22866b.onDataChanged(dataEventBuffer);
        } finally {
            dataEventBuffer.release();
        }
    }
}
