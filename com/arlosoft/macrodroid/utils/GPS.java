package com.arlosoft.macrodroid.utils;

import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes3.dex */
public class GPS {

    /* renamed from: a  reason: collision with root package name */
    private static StringBuilder f16034a = new StringBuilder(20);

    public static final synchronized String convert(double d4) {
        String sb;
        synchronized (GPS.class) {
            double abs = Math.abs(d4);
            int i4 = (int) abs;
            double d5 = (abs * 60.0d) - (i4 * 60.0d);
            int i5 = (int) d5;
            f16034a.setLength(0);
            f16034a.append(i4);
            f16034a.append("/1,");
            f16034a.append(i5);
            f16034a.append("/1,");
            f16034a.append((int) (((d5 * 60.0d) - (i5 * 60.0d)) * 1000.0d));
            f16034a.append("/1000");
            sb = f16034a.toString();
        }
        return sb;
    }

    public static String latitudeRef(double d4) {
        if (d4 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            return ExifInterface.LATITUDE_SOUTH;
        }
        return "N";
    }

    public static String longitudeRef(double d4) {
        if (d4 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            return ExifInterface.LONGITUDE_WEST;
        }
        return ExifInterface.LONGITUDE_EAST;
    }
}
