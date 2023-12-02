package com.google.android.gms.common.api.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
public final class zaac implements OnCompleteListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f20129a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zaad f20130b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zaac(zaad zaadVar, TaskCompletionSource taskCompletionSource) {
        this.f20130b = zaadVar;
        this.f20129a = taskCompletionSource;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(@NonNull Task task) {
        Map map;
        map = this.f20130b.f20132b;
        map.remove(this.f20129a);
    }
}
