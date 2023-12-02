package com.google.android.gms.internal.ads;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzcgf {
    private static final Pattern zza = Pattern.compile("^\\uFEFF?\\s*(\\s*<!--([^-]|(?!-->))*-->)*\\s*<!DOCTYPE(\\s)+html(|(\\s)+[^>]*)>", 2);
    private static final Pattern zzb = Pattern.compile("^\\uFEFF?\\s*(\\s*<!--([^-]|(?!-->))*-->)*?\\s*<!DOCTYPE[^>]*>", 2);

    public static String zza(@NonNull String str, @Nullable String... strArr) {
        StringBuilder sb = new StringBuilder();
        Matcher matcher = zza.matcher(str);
        int i4 = 0;
        if (matcher.find()) {
            int end = matcher.end();
            sb.append(str.substring(0, end));
            while (i4 <= 0) {
                String str2 = strArr[i4];
                if (str2 != null) {
                    sb.append(str2);
                }
                i4++;
            }
            sb.append(str.substring(end));
        } else {
            if (!zzb.matcher(str).find()) {
                while (i4 <= 0) {
                    String str3 = strArr[i4];
                    if (str3 != null) {
                        sb.append(str3);
                    }
                    i4++;
                }
            }
            sb.append(str);
        }
        return sb.toString();
    }
}
