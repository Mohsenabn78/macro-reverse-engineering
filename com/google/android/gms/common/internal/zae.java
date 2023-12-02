package com.google.android.gms.common.internal;

import android.content.Intent;
import androidx.fragment.app.Fragment;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
final class zae extends zag {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Intent f20510a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Fragment f20511b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ int f20512c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zae(Intent intent, Fragment fragment, int i4) {
        this.f20510a = intent;
        this.f20511b = fragment;
        this.f20512c = i4;
    }

    @Override // com.google.android.gms.common.internal.zag
    public final void a() {
        Intent intent = this.f20510a;
        if (intent != null) {
            this.f20511b.startActivityForResult(intent, this.f20512c);
        }
    }
}
