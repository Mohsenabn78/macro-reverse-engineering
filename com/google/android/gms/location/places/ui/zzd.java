package com.google.android.gms.location.places.ui;

import android.view.View;

/* loaded from: classes4.dex */
final class zzd implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ PlaceAutocompleteFragment f21165a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzd(PlaceAutocompleteFragment placeAutocompleteFragment) {
        this.f21165a = placeAutocompleteFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f21165a.setText("");
    }
}
