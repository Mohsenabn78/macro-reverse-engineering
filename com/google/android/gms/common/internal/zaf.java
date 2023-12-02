package com.google.android.gms.common.internal;

import android.content.Intent;
import com.google.android.gms.common.api.internal.LifecycleFragment;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
final class zaf extends zag {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Intent f20513a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ LifecycleFragment f20514b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zaf(Intent intent, LifecycleFragment lifecycleFragment, int i4) {
        this.f20513a = intent;
        this.f20514b = lifecycleFragment;
    }

    @Override // com.google.android.gms.common.internal.zag
    public final void a() {
        Intent intent = this.f20513a;
        if (intent != null) {
            this.f20514b.startActivityForResult(intent, 2);
        }
    }
}
