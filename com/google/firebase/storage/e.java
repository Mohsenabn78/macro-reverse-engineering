package com.google.firebase.storage;

import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.OnCanceledListener;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes5.dex */
public final /* synthetic */ class e implements OnCanceledListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CancellationTokenSource f32338a;

    @Override // com.google.android.gms.tasks.OnCanceledListener
    public final void onCanceled() {
        this.f32338a.cancel();
    }
}
