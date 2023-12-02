package com.google.android.gms.common.api.internal;

import android.app.Dialog;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
final class zan extends zabw {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Dialog f20324a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zao f20325b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zan(zao zaoVar, Dialog dialog) {
        this.f20325b = zaoVar;
        this.f20324a = dialog;
    }

    @Override // com.google.android.gms.common.api.internal.zabw
    public final void zaa() {
        this.f20325b.f20327b.d();
        if (this.f20324a.isShowing()) {
            this.f20324a.dismiss();
        }
    }
}
