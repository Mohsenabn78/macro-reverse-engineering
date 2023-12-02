package com.google.android.gms.dynamic;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
final class zae implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f20826a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Intent f20827b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zae(Context context, Intent intent) {
        this.f20826a = context;
        this.f20827b = intent;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            this.f20826a.startActivity(this.f20827b);
        } catch (ActivityNotFoundException e4) {
            Log.e("DeferredLifecycleHelper", "Failed to start resolution intent", e4);
        }
    }
}
