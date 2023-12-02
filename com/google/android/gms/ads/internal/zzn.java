package com.google.android.gms.ads.internal;

import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.internal.ads.zzaqs;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzn implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzs f19396a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzn(zzs zzsVar) {
        this.f19396a = zzsVar;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        zzaqs zzaqsVar;
        zzaqs zzaqsVar2;
        zzs zzsVar = this.f19396a;
        zzaqsVar = zzsVar.f19412h;
        if (zzaqsVar != null) {
            zzaqsVar2 = zzsVar.f19412h;
            zzaqsVar2.zzd(motionEvent);
            return false;
        }
        return false;
    }
}
