package com.google.android.play.core.integrity;

import android.os.Bundle;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.messaging.Constants;

/* compiled from: com.google.android.play:integrity@@1.1.0 */
/* loaded from: classes5.dex */
final class s extends com.google.android.play.integrity.internal.i {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ t f25306a;

    /* renamed from: b  reason: collision with root package name */
    private final com.google.android.play.integrity.internal.k f25307b = new com.google.android.play.integrity.internal.k("OnRequestIntegrityTokenCallback");

    /* renamed from: c  reason: collision with root package name */
    private final TaskCompletionSource f25308c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(t tVar, TaskCompletionSource taskCompletionSource) {
        this.f25306a = tVar;
        this.f25308c = taskCompletionSource;
    }

    @Override // com.google.android.play.integrity.internal.j
    public final void b(Bundle bundle) {
        this.f25306a.f25309a.r(this.f25308c);
        this.f25307b.d("onRequestIntegrityToken", new Object[0]);
        int i4 = bundle.getInt(Constants.IPC_BUNDLE_KEY_SEND_ERROR);
        if (i4 != 0) {
            this.f25308c.trySetException(new IntegrityServiceException(i4, null));
            return;
        }
        String string = bundle.getString("token");
        if (string == null) {
            this.f25308c.trySetException(new IntegrityServiceException(-100, null));
            return;
        }
        TaskCompletionSource taskCompletionSource = this.f25308c;
        d dVar = new d();
        dVar.a(string);
        taskCompletionSource.trySetResult(dVar.b());
    }
}
