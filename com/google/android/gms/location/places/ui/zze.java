package com.google.android.gms.location.places.ui;

import android.view.View;

/* loaded from: classes4.dex */
final class zze implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ PlaceAutocompleteFragment f21166a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zze(PlaceAutocompleteFragment placeAutocompleteFragment) {
        this.f21166a = placeAutocompleteFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean z3;
        z3 = this.f21166a.f21153d;
        if (!z3) {
            this.f21166a.d();
        }
    }
}
