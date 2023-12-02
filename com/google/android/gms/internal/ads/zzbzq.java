package com.google.android.gms.internal.ads;

import android.util.JsonWriter;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.wearable.WearableStatusCodes;
import java.io.IOException;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzbzq {
    public static final /* synthetic */ int zza = 0;
    @GuardedBy("lock")
    private static boolean zzc = false;
    @GuardedBy("lock")
    private static boolean zzd = false;
    private final List zzg;
    private static final Object zzb = new Object();
    private static final Clock zze = DefaultClock.getInstance();
    private static final Set zzf = new HashSet(Arrays.asList(new String[0]));

    public zzbzq() {
        this(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zza(String str, String str2, Map map, byte[] bArr, JsonWriter jsonWriter) throws IOException {
        jsonWriter.name("params").beginObject();
        jsonWriter.name("firstline").beginObject();
        jsonWriter.name("uri").value(str);
        jsonWriter.name("verb").value(str2);
        jsonWriter.endObject();
        zzr(jsonWriter, map);
        if (bArr != null) {
            jsonWriter.name("body").value(Base64Utils.encode(bArr));
        }
        jsonWriter.endObject();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzb(int i4, Map map, JsonWriter jsonWriter) throws IOException {
        jsonWriter.name("params").beginObject();
        jsonWriter.name("firstline").beginObject();
        jsonWriter.name("code").value(i4);
        jsonWriter.endObject();
        zzr(jsonWriter, map);
        jsonWriter.endObject();
    }

    public static void zzi() {
        synchronized (zzb) {
            zzc = false;
            zzd = false;
            zzbzr.zzj("Ad debug logging enablement is out of date.");
        }
    }

    public static void zzj(boolean z3) {
        synchronized (zzb) {
            zzc = true;
            zzd = z3;
        }
    }

    public static boolean zzk() {
        boolean z3;
        synchronized (zzb) {
            z3 = false;
            if (zzc && zzd) {
                z3 = true;
            }
        }
        return z3;
    }

    public static boolean zzl() {
        boolean z3;
        synchronized (zzb) {
            z3 = zzc;
        }
        return z3;
    }

    private static synchronized void zzm(String str) {
        synchronized (zzbzq.class) {
            zzbzr.zzi("GMA Debug BEGIN");
            int i4 = 0;
            while (i4 < str.length()) {
                int i5 = i4 + WearableStatusCodes.TARGET_NODE_NOT_CONNECTED;
                zzbzr.zzi("GMA Debug CONTENT ".concat(String.valueOf(str.substring(i4, Math.min(i5, str.length())))));
                i4 = i5;
            }
            zzbzr.zzi("GMA Debug FINISH");
        }
    }

    private final void zzn(String str, zzbzp zzbzpVar) {
        StringWriter stringWriter = new StringWriter();
        JsonWriter jsonWriter = new JsonWriter(stringWriter);
        try {
            jsonWriter.beginObject();
            jsonWriter.name("timestamp").value(zze.currentTimeMillis());
            jsonWriter.name(NotificationCompat.CATEGORY_EVENT).value(str);
            jsonWriter.name("components").beginArray();
            for (String str2 : this.zzg) {
                jsonWriter.value(str2);
            }
            jsonWriter.endArray();
            zzbzpVar.zza(jsonWriter);
            jsonWriter.endObject();
            jsonWriter.flush();
            jsonWriter.close();
        } catch (IOException e4) {
            zzbzr.zzh("unable to log", e4);
        }
        zzm(stringWriter.toString());
    }

    private final void zzo(@Nullable final String str) {
        zzn("onNetworkRequestError", new zzbzp() { // from class: com.google.android.gms.internal.ads.zzbzm
            @Override // com.google.android.gms.internal.ads.zzbzp
            public final void zza(JsonWriter jsonWriter) {
                String str2 = str;
                int i4 = zzbzq.zza;
                jsonWriter.name("params").beginObject();
                if (str2 != null) {
                    jsonWriter.name("error_description").value(str2);
                }
                jsonWriter.endObject();
            }
        });
    }

    private final void zzp(final String str, final String str2, @Nullable final Map map, @Nullable final byte[] bArr) {
        zzn("onNetworkRequest", new zzbzp() { // from class: com.google.android.gms.internal.ads.zzbzn
            @Override // com.google.android.gms.internal.ads.zzbzp
            public final void zza(JsonWriter jsonWriter) {
                zzbzq.zza(str, str2, map, bArr, jsonWriter);
            }
        });
    }

    private final void zzq(@Nullable final Map map, final int i4) {
        zzn("onNetworkResponse", new zzbzp() { // from class: com.google.android.gms.internal.ads.zzbzl
            @Override // com.google.android.gms.internal.ads.zzbzp
            public final void zza(JsonWriter jsonWriter) {
                zzbzq.zzb(i4, map, jsonWriter);
            }
        });
    }

    private static void zzr(JsonWriter jsonWriter, @Nullable Map map) throws IOException {
        if (map == null) {
            return;
        }
        jsonWriter.name("headers").beginArray();
        Iterator it = map.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry entry = (Map.Entry) it.next();
            String str = (String) entry.getKey();
            if (!zzf.contains(str)) {
                if (entry.getValue() instanceof List) {
                    for (String str2 : (List) entry.getValue()) {
                        jsonWriter.beginObject();
                        jsonWriter.name("name").value(str);
                        jsonWriter.name("value").value(str2);
                        jsonWriter.endObject();
                    }
                } else if (entry.getValue() instanceof String) {
                    jsonWriter.beginObject();
                    jsonWriter.name("name").value(str);
                    jsonWriter.name("value").value((String) entry.getValue());
                    jsonWriter.endObject();
                } else {
                    zzbzr.zzg("Connection headers should be either Map<String, String> or Map<String, List<String>>");
                    break;
                }
            }
        }
        jsonWriter.endArray();
    }

    public final void zzc(HttpURLConnection httpURLConnection, @Nullable byte[] bArr) {
        HashMap hashMap;
        if (!zzk()) {
            return;
        }
        if (httpURLConnection.getRequestProperties() == null) {
            hashMap = null;
        } else {
            hashMap = new HashMap(httpURLConnection.getRequestProperties());
        }
        zzp(new String(httpURLConnection.getURL().toString()), new String(httpURLConnection.getRequestMethod()), hashMap, bArr);
    }

    public final void zzd(String str, String str2, @Nullable Map map, @Nullable byte[] bArr) {
        if (!zzk()) {
            return;
        }
        zzp(str, "GET", map, bArr);
    }

    public final void zze(HttpURLConnection httpURLConnection, int i4) {
        HashMap hashMap;
        if (!zzk()) {
            return;
        }
        String str = null;
        if (httpURLConnection.getHeaderFields() == null) {
            hashMap = null;
        } else {
            hashMap = new HashMap(httpURLConnection.getHeaderFields());
        }
        zzq(hashMap, i4);
        if (i4 >= 200 && i4 < 300) {
            return;
        }
        try {
            str = httpURLConnection.getResponseMessage();
        } catch (IOException e4) {
            zzbzr.zzj("Can not get error message from error HttpURLConnection\n".concat(String.valueOf(e4.getMessage())));
        }
        zzo(str);
    }

    public final void zzf(@Nullable Map map, int i4) {
        if (!zzk()) {
            return;
        }
        zzq(map, i4);
        if (i4 >= 200 && i4 < 300) {
            return;
        }
        zzo(null);
    }

    public final void zzg(@Nullable String str) {
        if (!zzk() || str == null) {
            return;
        }
        zzh(str.getBytes());
    }

    public final void zzh(final byte[] bArr) {
        zzn("onNetworkResponseBody", new zzbzp() { // from class: com.google.android.gms.internal.ads.zzbzo
            @Override // com.google.android.gms.internal.ads.zzbzp
            public final void zza(JsonWriter jsonWriter) {
                byte[] bArr2 = bArr;
                int i4 = zzbzq.zza;
                jsonWriter.name("params").beginObject();
                int length = bArr2.length;
                String encode = Base64Utils.encode(bArr2);
                if (length < 10000) {
                    jsonWriter.name("body").value(encode);
                } else {
                    String zze2 = zzbzk.zze(encode);
                    if (zze2 != null) {
                        jsonWriter.name("bodydigest").value(zze2);
                    }
                }
                jsonWriter.name("bodylength").value(length);
                jsonWriter.endObject();
            }
        });
    }

    public zzbzq(@Nullable String str) {
        List asList;
        if (!zzk()) {
            asList = new ArrayList();
        } else {
            asList = Arrays.asList("network_request_".concat(String.valueOf(UUID.randomUUID().toString())));
        }
        this.zzg = asList;
    }
}
