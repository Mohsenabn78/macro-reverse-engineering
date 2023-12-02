package com.google.android.gms.common.moduleinstall.internal;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.moduleinstall.ModuleInstallStatusUpdate;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
public final class zaab extends zag {

    /* renamed from: a  reason: collision with root package name */
    private final ListenerHolder f20624a;

    public zaab(ListenerHolder listenerHolder) {
        this.f20624a = listenerHolder;
    }

    @Override // com.google.android.gms.common.moduleinstall.internal.zah
    public final void zab(ModuleInstallStatusUpdate moduleInstallStatusUpdate) {
        this.f20624a.notifyListener(new zaaa(this, moduleInstallStatusUpdate));
    }
}
