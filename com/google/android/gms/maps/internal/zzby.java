package com.google.android.gms.maps.internal;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.arlosoft.macrodroid.action.activities.PopUpActionActivity;

/* loaded from: classes4.dex */
public final class zzby {
    private zzby() {
    }

    private static <T extends Parcelable> T a(@Nullable Bundle bundle, String str) {
        if (bundle == null) {
            return null;
        }
        bundle.setClassLoader(zzby.class.getClassLoader());
        Bundle bundle2 = bundle.getBundle("map_state");
        if (bundle2 == null) {
            return null;
        }
        bundle2.setClassLoader(zzby.class.getClassLoader());
        return (T) bundle2.getParcelable(str);
    }

    public static void zza(@Nullable Bundle bundle, @Nullable Bundle bundle2) {
        if (bundle == null || bundle2 == null) {
            return;
        }
        Parcelable a4 = a(bundle, "MapOptions");
        if (a4 != null) {
            zza(bundle2, "MapOptions", a4);
        }
        Parcelable a5 = a(bundle, "StreetViewPanoramaOptions");
        if (a5 != null) {
            zza(bundle2, "StreetViewPanoramaOptions", a5);
        }
        Parcelable a6 = a(bundle, "camera");
        if (a6 != null) {
            zza(bundle2, "camera", a6);
        }
        if (bundle.containsKey(PopUpActionActivity.EXTRA_POSITION)) {
            bundle2.putString(PopUpActionActivity.EXTRA_POSITION, bundle.getString(PopUpActionActivity.EXTRA_POSITION));
        }
        if (bundle.containsKey("com.google.android.wearable.compat.extra.LOWBIT_AMBIENT")) {
            bundle2.putBoolean("com.google.android.wearable.compat.extra.LOWBIT_AMBIENT", bundle.getBoolean("com.google.android.wearable.compat.extra.LOWBIT_AMBIENT", false));
        }
    }

    public static void zza(Bundle bundle, String str, Parcelable parcelable) {
        bundle.setClassLoader(zzby.class.getClassLoader());
        Bundle bundle2 = bundle.getBundle("map_state");
        if (bundle2 == null) {
            bundle2 = new Bundle();
        }
        bundle2.setClassLoader(zzby.class.getClassLoader());
        bundle2.putParcelable(str, parcelable);
        bundle.putBundle("map_state", bundle2);
    }
}
