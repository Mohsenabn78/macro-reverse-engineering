package com.arlosoft.macrodroid.utils;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.FirebaseCrashlytics;

/* loaded from: classes3.dex */
public class UriHelper {
    public static String getDisplayNameFromUri(@NonNull Context context, Uri uri) {
        String string;
        String str = "";
        if (uri == null) {
            return "";
        }
        try {
            Cursor query = context.getContentResolver().query(uri, null, null, null, null);
            if (query != null) {
                if (query.moveToFirst() && (string = query.getString(query.getColumnIndex("_display_name"))) != null) {
                    str = string;
                }
                query.close();
            }
        } catch (IllegalArgumentException e4) {
            FirebaseCrashlytics.getInstance().recordException(e4);
        }
        return str;
    }
}
