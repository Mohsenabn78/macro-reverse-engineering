package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
public final class zadc {
    public static final Status zaa = new Status(8, "The connection to Google Play services was lost");
    @VisibleForTesting

    /* renamed from: a  reason: collision with root package name */
    final Set f20306a = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));

    /* renamed from: b  reason: collision with root package name */
    private final zadb f20307b = new zadb(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(BasePendingResult basePendingResult) {
        this.f20306a.add(basePendingResult);
        basePendingResult.zan(this.f20307b);
    }

    public final void zab() {
        BasePendingResult[] basePendingResultArr;
        for (BasePendingResult basePendingResult : (BasePendingResult[]) this.f20306a.toArray(new BasePendingResult[0])) {
            basePendingResult.zan(null);
            if (basePendingResult.zam()) {
                this.f20306a.remove(basePendingResult);
            }
        }
    }
}
