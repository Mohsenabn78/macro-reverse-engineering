package com.google.android.gms.common.api.internal;

import androidx.annotation.BinderThread;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
final class zaar extends com.google.android.gms.signin.internal.zac {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference f20155a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zaar(zaaw zaawVar) {
        this.f20155a = new WeakReference(zaawVar);
    }

    @Override // com.google.android.gms.signin.internal.zac, com.google.android.gms.signin.internal.zae
    @BinderThread
    public final void zab(com.google.android.gms.signin.internal.zak zakVar) {
        zabi zabiVar;
        zaaw zaawVar = (zaaw) this.f20155a.get();
        if (zaawVar != null) {
            zabiVar = zaawVar.f20158a;
            zabiVar.f(new zaaq(this, zaawVar, zaawVar, zakVar));
        }
    }
}
