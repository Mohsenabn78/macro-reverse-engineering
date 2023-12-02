package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.arlosoft.macrodroid.geofences.GeofenceInfo;
import com.google.android.gms.common.api.internal.LifecycleFragment;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
public abstract class zag implements DialogInterface.OnClickListener {
    public static zag zab(Activity activity, @Nullable Intent intent, int i4) {
        return new zad(intent, activity, i4);
    }

    public static zag zac(@NonNull Fragment fragment, @Nullable Intent intent, int i4) {
        return new zae(intent, fragment, i4);
    }

    public static zag zad(@NonNull LifecycleFragment lifecycleFragment, @Nullable Intent intent, int i4) {
        return new zaf(intent, lifecycleFragment, 2);
    }

    protected abstract void a();

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i4) {
        try {
            a();
        } catch (ActivityNotFoundException e4) {
            String str = "Failed to start resolution intent.";
            if (true == Build.FINGERPRINT.contains(GeofenceInfo.GEOFENCE_GENERIC_ID)) {
                str = "Failed to start resolution intent. This may occur when resolving Google Play services connection issues on emulators with Google APIs but not Google Play Store.";
            }
            Log.e("DialogRedirect", str, e4);
        } finally {
            dialogInterface.dismiss();
        }
    }
}
