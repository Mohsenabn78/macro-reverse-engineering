package com.arlosoft.macrodroid.utils;

import androidx.compose.animation.core.AnimationKt;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.ads.RequestConfiguration;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* loaded from: classes3.dex */
public class ConciseNumberFormatter {

    /* renamed from: a  reason: collision with root package name */
    private static final NavigableMap<Long, String> f16015a;

    static {
        TreeMap treeMap = new TreeMap();
        f16015a = treeMap;
        treeMap.put(1000L, "k");
        treeMap.put(Long.valueOf((long) AnimationKt.MillisToNanos), "M");
        treeMap.put(1000000000L, RequestConfiguration.MAX_AD_CONTENT_RATING_G);
        treeMap.put(1000000000000L, "T");
        treeMap.put(1000000000000000L, "P");
        treeMap.put(1000000000000000000L, ExifInterface.LONGITUDE_EAST);
    }

    public static String format(long j4) {
        boolean z3;
        StringBuilder sb;
        if (j4 == Long.MIN_VALUE) {
            return format(-9223372036854775807L);
        }
        if (j4 < 0) {
            return "-" + format(-j4);
        } else if (j4 < 1000) {
            return Long.toString(j4);
        } else {
            Map.Entry<Long, String> floorEntry = f16015a.floorEntry(Long.valueOf(j4));
            String value = floorEntry.getValue();
            long longValue = j4 / (floorEntry.getKey().longValue() / 10);
            if (longValue < 100 && longValue / 10.0d != longValue / 10) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                sb = new StringBuilder();
                sb.append(longValue / 10.0d);
            } else {
                sb = new StringBuilder();
                sb.append(longValue / 10);
            }
            sb.append(value);
            return sb.toString();
        }
    }
}
