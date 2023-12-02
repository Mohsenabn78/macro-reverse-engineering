package com.sens.app.extensions;

import android.location.Location;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

/* compiled from: LocationExtensions.kt */
/* loaded from: classes6.dex */
public final class LocationExtensionsKt {
    @NotNull
    public static final String prettyText(@NotNull Location location) {
        String str;
        Intrinsics.checkNotNullParameter(location, "<this>");
        StringBuilder sb = new StringBuilder();
        sb.append("Location [");
        sb.append(location.getProvider());
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(" %.6f,%.6f", Arrays.copyOf(new Object[]{Double.valueOf(location.getLatitude()), Double.valueOf(location.getLongitude())}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        sb.append(format);
        if (location.hasAccuracy()) {
            str = String.format(" hAcc=%.0f", Arrays.copyOf(new Object[]{Float.valueOf(location.getAccuracy())}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        } else {
            str = " hAcc=???";
        }
        sb.append(str);
        if (location.getTime() == 0) {
            sb.append(" t=?!?");
        }
        if (location.hasAltitude()) {
            sb.append(" alt=");
            sb.append((int) location.getAltitude());
        }
        if (location.hasSpeed()) {
            sb.append(" vel=");
            sb.append((int) location.getSpeed());
        }
        if (location.hasBearing()) {
            sb.append(" bear=");
            sb.append((int) location.getBearing());
        }
        if (location.isFromMockProvider()) {
            sb.append(" mock");
        }
        sb.append(']');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "s.toString()");
        return sb2;
    }
}
