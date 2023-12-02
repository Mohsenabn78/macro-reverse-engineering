package com.google.android.gms.internal.nearby;

import android.database.ContentObserver;
import android.os.Handler;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public final class zzsa extends ContentObserver {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzsa(Handler handler) {
        super(null);
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z3) {
        AtomicBoolean atomicBoolean;
        atomicBoolean = zzsb.zzl;
        atomicBoolean.set(true);
    }
}
