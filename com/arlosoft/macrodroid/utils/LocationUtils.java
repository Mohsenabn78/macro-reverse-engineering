package com.arlosoft.macrodroid.utils;

import android.content.Context;
import android.provider.Settings;

/* loaded from: classes3.dex */
public class LocationUtils {
    public static boolean isLocationEnabled(Context context) {
        try {
            if (Settings.Secure.getInt(context.getContentResolver(), "location_mode") == 0) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
