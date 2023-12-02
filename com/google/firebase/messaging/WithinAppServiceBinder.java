package com.google.firebase.messaging;

import android.content.Intent;
import android.os.Binder;
import android.os.Process;
import android.util.Log;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.WithinAppServiceConnection;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class WithinAppServiceBinder extends Binder {

    /* renamed from: a  reason: collision with root package name */
    private final IntentHandler f31765a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public interface IntentHandler {
        Task<Void> a(Intent intent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WithinAppServiceBinder(IntentHandler intentHandler) {
        this.f31765a = intentHandler;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(final WithinAppServiceConnection.BindRequest bindRequest) {
        if (Binder.getCallingUid() == Process.myUid()) {
            Log.isLoggable(Constants.TAG, 3);
            this.f31765a.a(bindRequest.f31772a).addOnCompleteListener(new androidx.biometric.auth.a(), new OnCompleteListener() { // from class: com.google.firebase.messaging.f0
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    WithinAppServiceConnection.BindRequest.this.d();
                }
            });
            return;
        }
        throw new SecurityException("Binding only allowed within app");
    }
}
