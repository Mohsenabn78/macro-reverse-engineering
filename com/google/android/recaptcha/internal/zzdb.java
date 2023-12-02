package com.google.android.recaptcha.internal;

import android.net.Uri;
import android.text.TextUtils;
import androidx.webkit.ProxyConfig;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.f;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.m;
import org.jetbrains.annotations.NotNull;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
public final class zzdb {
    @NotNull
    public static final zzdb zza = new zzdb();
    @NotNull
    private static final List zzb;

    static {
        List listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"www.recaptcha.net", "www.gstatic.com/recaptcha"});
        zzb = zzc(listOf);
    }

    private zzdb() {
    }

    public static final boolean zza(@NotNull Uri uri) {
        if (!TextUtils.isEmpty(uri.toString()) && Intrinsics.areEqual(ProxyConfig.MATCH_HTTPS, uri.getScheme()) && !TextUtils.isEmpty(uri.getHost()) && zzb(uri.toString())) {
            return true;
        }
        return false;
    }

    private static final boolean zzb(String str) {
        boolean startsWith$default;
        List<String> list = zzb;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        for (String str2 : list) {
            startsWith$default = m.startsWith$default(str, str2, false, 2, null);
            if (startsWith$default) {
                return true;
            }
        }
        return false;
    }

    private static final List zzc(List list) {
        int collectionSizeOrDefault;
        collectionSizeOrDefault = f.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add("https://" + ((String) it.next()) + RemoteSettings.FORWARD_SLASH_STRING);
        }
        return arrayList;
    }
}
