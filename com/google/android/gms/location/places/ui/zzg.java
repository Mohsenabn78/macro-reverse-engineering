package com.google.android.gms.location.places.ui;

import android.view.View;

/* loaded from: classes4.dex */
final class zzg implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ SupportPlaceAutocompleteFragment f21168a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzg(SupportPlaceAutocompleteFragment supportPlaceAutocompleteFragment) {
        this.f21168a = supportPlaceAutocompleteFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean z3;
        z3 = this.f21168a.f21160e;
        if (!z3) {
            this.f21168a.e();
        }
    }
}
