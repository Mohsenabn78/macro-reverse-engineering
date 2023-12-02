package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzgz extends ContentObserver {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgz(Handler handler) {
        super(null);
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z3) {
        AtomicBoolean atomicBoolean;
        atomicBoolean = zzha.zzl;
        atomicBoolean.set(true);
    }
}
