package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.Intent;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
final class zad extends zag {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Intent f20507a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Activity f20508b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ int f20509c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zad(Intent intent, Activity activity, int i4) {
        this.f20507a = intent;
        this.f20508b = activity;
        this.f20509c = i4;
    }

    @Override // com.google.android.gms.common.internal.zag
    public final void a() {
        Intent intent = this.f20507a;
        if (intent != null) {
            this.f20508b.startActivityForResult(intent, this.f20509c);
        }
    }
}
