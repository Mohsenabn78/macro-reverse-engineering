package com.google.firebase.installations;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes5.dex */
final class AwaitListener implements OnCompleteListener<Void> {

    /* renamed from: a  reason: collision with root package name */
    private final CountDownLatch f31512a = new CountDownLatch(1);

    AwaitListener() {
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public void onComplete(@NonNull Task<Void> task) {
        this.f31512a.countDown();
    }
}
