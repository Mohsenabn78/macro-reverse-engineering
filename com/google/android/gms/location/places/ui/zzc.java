package com.google.android.gms.location.places.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.util.TypedValue;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtilLight;

/* loaded from: classes4.dex */
public class zzc {

    /* renamed from: a  reason: collision with root package name */
    protected final Intent f21164a;

    public zzc(String str) {
        Intent intent = new Intent(str);
        this.f21164a = intent;
        intent.setPackage("com.google.android.gms");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Intent build(Activity activity) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        Resources.Theme theme = activity.getTheme();
        TypedValue typedValue = new TypedValue();
        TypedValue typedValue2 = new TypedValue();
        if (theme.resolveAttribute(16843827, typedValue, true) && !this.f21164a.hasExtra("primary_color")) {
            this.f21164a.putExtra("primary_color", typedValue.data);
        }
        if (theme.resolveAttribute(16843828, typedValue2, true) && !this.f21164a.hasExtra("primary_color_dark")) {
            this.f21164a.putExtra("primary_color_dark", typedValue2.data);
        }
        GoogleApiAvailability.getInstance().verifyGooglePlayServicesIsAvailable(activity, GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
        return this.f21164a;
    }
}
