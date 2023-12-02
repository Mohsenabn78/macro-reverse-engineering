package com.google.android.gms.common.api;

import com.google.android.gms.common.api.PendingResult;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
public final class zab implements PendingResult.StatusListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Batch f20352a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zab(Batch batch) {
        this.f20352a = batch;
    }

    @Override // com.google.android.gms.common.api.PendingResult.StatusListener
    public final void onComplete(Status status) {
        Object obj;
        int i4;
        int i5;
        boolean z3;
        boolean z4;
        Status status2;
        PendingResult[] pendingResultArr;
        obj = this.f20352a.f19997e;
        synchronized (obj) {
            if (this.f20352a.isCanceled()) {
                return;
            }
            if (status.isCanceled()) {
                this.f20352a.f19995c = true;
            } else if (!status.isSuccess()) {
                this.f20352a.f19994b = true;
            }
            Batch batch = this.f20352a;
            i4 = batch.f19993a;
            batch.f19993a = i4 - 1;
            Batch batch2 = this.f20352a;
            i5 = batch2.f19993a;
            if (i5 == 0) {
                z3 = batch2.f19995c;
                if (z3) {
                    super/*com.google.android.gms.common.api.internal.BasePendingResult*/.cancel();
                } else {
                    z4 = batch2.f19994b;
                    if (z4) {
                        status2 = new Status(13);
                    } else {
                        status2 = Status.RESULT_SUCCESS;
                    }
                    Batch batch3 = this.f20352a;
                    pendingResultArr = batch3.f19996d;
                    batch3.setResult(new BatchResult(status2, pendingResultArr));
                }
            }
        }
    }
}
