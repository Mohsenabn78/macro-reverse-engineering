package com.google.android.gms.common.api.internal;

import android.app.Dialog;
import android.app.PendingIntent;
import androidx.annotation.MainThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
public final class zao implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final zam f20326a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zap f20327b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zao(zap zapVar, zam zamVar) {
        this.f20327b = zapVar;
        this.f20326a = zamVar;
    }

    @Override // java.lang.Runnable
    @MainThread
    public final void run() {
        if (!this.f20327b.f20328a) {
            return;
        }
        ConnectionResult b4 = this.f20326a.b();
        if (b4.hasResolution()) {
            zap zapVar = this.f20327b;
            zapVar.mLifecycleFragment.startActivityForResult(GoogleApiActivity.zaa(zapVar.getActivity(), (PendingIntent) Preconditions.checkNotNull(b4.getResolution()), this.f20326a.a(), false), 1);
            return;
        }
        zap zapVar2 = this.f20327b;
        if (zapVar2.f20331d.getErrorResolutionIntent(zapVar2.getActivity(), b4.getErrorCode(), null) != null) {
            zap zapVar3 = this.f20327b;
            zapVar3.f20331d.zag(zapVar3.getActivity(), this.f20327b.mLifecycleFragment, b4.getErrorCode(), 2, this.f20327b);
        } else if (b4.getErrorCode() != 18) {
            this.f20327b.a(b4, this.f20326a.a());
        } else {
            zap zapVar4 = this.f20327b;
            Dialog zab = zapVar4.f20331d.zab(zapVar4.getActivity(), this.f20327b);
            zap zapVar5 = this.f20327b;
            zapVar5.f20331d.zac(zapVar5.getActivity().getApplicationContext(), new zan(this, zab));
        }
    }
}
