package com.google.android.gms.wearable.internal;

import android.util.Log;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.wearable.MessageClient;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
final class zzir implements ListenerHolder.Notifier {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzfx f22833a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzev f22834b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzir(zzfx zzfxVar, zzev zzevVar, byte[] bArr) {
        this.f22833a = zzfxVar;
        this.f22834b = zzevVar;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* bridge */ /* synthetic */ void notifyListener(Object obj) {
        Task<byte[]> onRequest = ((MessageClient.RpcService) obj).onRequest(this.f22833a.getSourceNodeId(), this.f22833a.getPath(), this.f22833a.getData());
        if (onRequest == null) {
            zzit.d(this.f22834b, false, null);
            return;
        }
        final zzev zzevVar = this.f22834b;
        onRequest.addOnCompleteListener(new OnCompleteListener(null) { // from class: com.google.android.gms.wearable.internal.zziq
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                zzev zzevVar2 = zzev.this;
                if (task.isSuccessful()) {
                    zzit.d(zzevVar2, true, (byte[]) task.getResult());
                    return;
                }
                Log.e("WearableListenerStub", "Failed to resolve future, sending null response", task.getException());
                zzit.d(zzevVar2, false, null);
            }
        });
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final void onNotifyListenerFailed() {
        Log.e("WearableListenerStub", "Failed to notify listener, sending null response");
        zzit.d(this.f22834b, false, null);
    }
}
