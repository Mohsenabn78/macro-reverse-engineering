package com.google.android.gms.measurement.internal;

import android.content.Context;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement@@21.3.0 */
@VisibleForTesting
/* loaded from: classes4.dex */
public final class zzli {

    /* renamed from: a  reason: collision with root package name */
    final Context f22067a;

    @VisibleForTesting
    public zzli(Context context) {
        Preconditions.checkNotNull(context);
        Context applicationContext = context.getApplicationContext();
        Preconditions.checkNotNull(applicationContext);
        this.f22067a = applicationContext;
    }
}
