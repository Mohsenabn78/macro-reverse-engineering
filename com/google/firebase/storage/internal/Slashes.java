package com.google.firebase.storage.internal;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.sessions.settings.RemoteSettings;

/* loaded from: classes5.dex */
public class Slashes {
    @NonNull
    public static String normalizeSlashes(@NonNull String str) {
        String[] split;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (!str.startsWith(RemoteSettings.FORWARD_SLASH_STRING) && !str.endsWith(RemoteSettings.FORWARD_SLASH_STRING) && !str.contains("//")) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : str.split(RemoteSettings.FORWARD_SLASH_STRING, -1)) {
            if (!TextUtils.isEmpty(str2)) {
                if (sb.length() > 0) {
                    sb.append(RemoteSettings.FORWARD_SLASH_STRING);
                    sb.append(str2);
                } else {
                    sb.append(str2);
                }
            }
        }
        return sb.toString();
    }

    @NonNull
    public static String preserveSlashEncode(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return slashize(Uri.encode(str));
    }

    @NonNull
    public static String slashize(@NonNull String str) {
        Preconditions.checkNotNull(str);
        return str.replace("%2F", RemoteSettings.FORWARD_SLASH_STRING);
    }
}
