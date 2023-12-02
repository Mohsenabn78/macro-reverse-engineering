package com.google.android.gms.ads.internal.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzav implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f19275a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f19276b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ boolean f19277c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ boolean f19278d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzav(zzaw zzawVar, Context context, String str, boolean z3, boolean z4) {
        this.f19275a = context;
        this.f19276b = str;
        this.f19277c = z3;
        this.f19278d = z4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.gms.ads.internal.zzt.zzp();
        AlertDialog.Builder zzG = zzs.zzG(this.f19275a);
        zzG.setMessage(this.f19276b);
        if (this.f19277c) {
            zzG.setTitle("Error");
        } else {
            zzG.setTitle("Info");
        }
        if (this.f19278d) {
            zzG.setNeutralButton("Dismiss", (DialogInterface.OnClickListener) null);
        } else {
            zzG.setPositiveButton("Learn More", new zzau(this));
            zzG.setNegativeButton("Dismiss", (DialogInterface.OnClickListener) null);
        }
        zzG.create().show();
    }
}
