package com.oneclickaway.opensource.placeautocomplete.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Commons.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lcom/oneclickaway/opensource/placeautocomplete/utils/Commons;", "", "()V", "getPrettyTime", "", "milliSeconds", "", "isNetworkConnected", "", "mContext", "Landroid/content/Context;", "place_autocomplete_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes6.dex */
public final class Commons {
    public static final Commons INSTANCE = new Commons();

    private Commons() {
    }

    @NotNull
    public final String getPrettyTime(long j4) {
        float currentTimeMillis = (((float) (System.currentTimeMillis() - j4)) / 1000.0f) / 60.0f;
        Calendar currentDateInstance = Calendar.getInstance();
        currentDateInstance.set(currentDateInstance.get(1), currentDateInstance.get(5), currentDateInstance.get(5));
        Calendar currentTimeCalender = Calendar.getInstance();
        currentTimeCalender.set(currentTimeCalender.get(1), currentTimeCalender.get(5), currentTimeCalender.get(5), 0, 0, 0);
        Intrinsics.checkExpressionValueIsNotNull(currentDateInstance, "currentDateInstance");
        long timeInMillis = currentDateInstance.getTimeInMillis();
        Intrinsics.checkExpressionValueIsNotNull(currentTimeCalender, "currentTimeCalender");
        float timeInMillis2 = (((float) (timeInMillis - currentTimeCalender.getTimeInMillis())) / 1000.0f) / 60.0f;
        if (currentTimeMillis < timeInMillis2) {
            return "Today";
        }
        float f4 = currentTimeMillis - timeInMillis2;
        if (f4 < 1440) {
            return "Yesterday";
        }
        if (f4 < 10080) {
            return "Earlier this week";
        }
        return "Previous Searches";
    }

    public final boolean isNetworkConnected(@NotNull Context mContext) {
        Intrinsics.checkParameterIsNotNull(mContext, "mContext");
        ConnectivityManager connectivityManager = (ConnectivityManager) mContext.getSystemService("connectivity");
        if (connectivityManager == null) {
            Intrinsics.throwNpe();
        }
        if (connectivityManager.getActiveNetworkInfo() != null) {
            return true;
        }
        return false;
    }
}
