package com.google.android.gms.location.places.ui;

import android.view.View;

/* loaded from: classes4.dex */
final class zzf implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ SupportPlaceAutocompleteFragment f21167a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzf(SupportPlaceAutocompleteFragment supportPlaceAutocompleteFragment) {
        this.f21167a = supportPlaceAutocompleteFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f21167a.setText("");
    }
}
