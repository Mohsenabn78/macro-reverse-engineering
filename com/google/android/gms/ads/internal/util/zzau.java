package com.google.android.gms.ads.internal.util;

import android.content.DialogInterface;
import android.net.Uri;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzau implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzav f19274a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzau(zzav zzavVar) {
        this.f19274a = zzavVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i4) {
        com.google.android.gms.ads.internal.zzt.zzp();
        zzs.zzQ(this.f19274a.f19275a, Uri.parse("https://support.google.com/dfp_premium/answer/7160685#push"));
    }
}
