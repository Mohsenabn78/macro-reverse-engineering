package com.google.firebase.remoteconfig.internal;

import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.util.BiConsumer;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigValue;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;
import org.json.JSONException;

/* loaded from: classes5.dex */
public class ConfigGetParameterHandler {
    @VisibleForTesting(otherwise = 3)
    public static final Charset FRC_BYTE_ARRAY_ENCODING = Charset.forName("UTF-8");

    /* renamed from: e  reason: collision with root package name */
    static final Pattern f31964e = Pattern.compile("^(1|true|t|yes|y|on)$", 2);

    /* renamed from: f  reason: collision with root package name */
    static final Pattern f31965f = Pattern.compile("^(0|false|f|no|n|off|)$", 2);

    /* renamed from: a  reason: collision with root package name */
    private final Set<BiConsumer<String, ConfigContainer>> f31966a = new HashSet();

    /* renamed from: b  reason: collision with root package name */
    private final Executor f31967b;

    /* renamed from: c  reason: collision with root package name */
    private final ConfigCacheClient f31968c;

    /* renamed from: d  reason: collision with root package name */
    private final ConfigCacheClient f31969d;

    public ConfigGetParameterHandler(Executor executor, ConfigCacheClient configCacheClient, ConfigCacheClient configCacheClient2) {
        this.f31967b = executor;
        this.f31968c = configCacheClient;
        this.f31969d = configCacheClient2;
    }

    private void b(final String str, final ConfigContainer configContainer) {
        if (configContainer == null) {
            return;
        }
        synchronized (this.f31966a) {
            for (final BiConsumer<String, ConfigContainer> biConsumer : this.f31966a) {
                this.f31967b.execute(new Runnable() { // from class: com.google.firebase.remoteconfig.internal.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        BiConsumer.this.accept(str, configContainer);
                    }
                });
            }
        }
    }

    @Nullable
    private static ConfigContainer c(ConfigCacheClient configCacheClient) {
        return configCacheClient.getBlocking();
    }

    @Nullable
    private static Double d(ConfigCacheClient configCacheClient, String str) {
        ConfigContainer c4 = c(configCacheClient);
        if (c4 == null) {
            return null;
        }
        try {
            return Double.valueOf(c4.getConfigs().getDouble(str));
        } catch (JSONException unused) {
            return null;
        }
    }

    private static Set<String> e(ConfigCacheClient configCacheClient) {
        HashSet hashSet = new HashSet();
        ConfigContainer c4 = c(configCacheClient);
        if (c4 == null) {
            return hashSet;
        }
        Iterator<String> keys = c4.getConfigs().keys();
        while (keys.hasNext()) {
            hashSet.add(keys.next());
        }
        return hashSet;
    }

    private static TreeSet<String> f(String str, ConfigContainer configContainer) {
        TreeSet<String> treeSet = new TreeSet<>();
        Iterator<String> keys = configContainer.getConfigs().keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (next.startsWith(str)) {
                treeSet.add(next);
            }
        }
        return treeSet;
    }

    @Nullable
    private static Long g(ConfigCacheClient configCacheClient, String str) {
        ConfigContainer c4 = c(configCacheClient);
        if (c4 == null) {
            return null;
        }
        try {
            return Long.valueOf(c4.getConfigs().getLong(str));
        } catch (JSONException unused) {
            return null;
        }
    }

    @Nullable
    private static String h(ConfigCacheClient configCacheClient, String str) {
        ConfigContainer c4 = c(configCacheClient);
        if (c4 == null) {
            return null;
        }
        try {
            return c4.getConfigs().getString(str);
        } catch (JSONException unused) {
            return null;
        }
    }

    private static void j(String str, String str2) {
        Log.w(FirebaseRemoteConfig.TAG, String.format("No value of type '%s' exists for parameter key '%s'.", str2, str));
    }

    public void addListener(BiConsumer<String, ConfigContainer> biConsumer) {
        synchronized (this.f31966a) {
            this.f31966a.add(biConsumer);
        }
    }

    public Map<String, FirebaseRemoteConfigValue> getAll() {
        HashSet<String> hashSet = new HashSet();
        hashSet.addAll(e(this.f31968c));
        hashSet.addAll(e(this.f31969d));
        HashMap hashMap = new HashMap();
        for (String str : hashSet) {
            hashMap.put(str, getValue(str));
        }
        return hashMap;
    }

    public boolean getBoolean(String str) {
        String h4 = h(this.f31968c, str);
        if (h4 != null) {
            if (f31964e.matcher(h4).matches()) {
                b(str, c(this.f31968c));
                return true;
            } else if (f31965f.matcher(h4).matches()) {
                b(str, c(this.f31968c));
                return false;
            }
        }
        String h5 = h(this.f31969d, str);
        if (h5 != null) {
            if (f31964e.matcher(h5).matches()) {
                return true;
            }
            if (f31965f.matcher(h5).matches()) {
                return false;
            }
        }
        j(str, "Boolean");
        return false;
    }

    public byte[] getByteArray(String str) {
        String h4 = h(this.f31968c, str);
        if (h4 != null) {
            b(str, c(this.f31968c));
            return h4.getBytes(FRC_BYTE_ARRAY_ENCODING);
        }
        String h5 = h(this.f31969d, str);
        if (h5 != null) {
            return h5.getBytes(FRC_BYTE_ARRAY_ENCODING);
        }
        j(str, "ByteArray");
        return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_BYTE_ARRAY;
    }

    public double getDouble(String str) {
        Double d4 = d(this.f31968c, str);
        if (d4 != null) {
            b(str, c(this.f31968c));
            return d4.doubleValue();
        }
        Double d5 = d(this.f31969d, str);
        if (d5 != null) {
            return d5.doubleValue();
        }
        j(str, "Double");
        return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
    }

    public Set<String> getKeysByPrefix(String str) {
        if (str == null) {
            str = "";
        }
        TreeSet treeSet = new TreeSet();
        ConfigContainer c4 = c(this.f31968c);
        if (c4 != null) {
            treeSet.addAll(f(str, c4));
        }
        ConfigContainer c5 = c(this.f31969d);
        if (c5 != null) {
            treeSet.addAll(f(str, c5));
        }
        return treeSet;
    }

    public long getLong(String str) {
        Long g4 = g(this.f31968c, str);
        if (g4 != null) {
            b(str, c(this.f31968c));
            return g4.longValue();
        }
        Long g5 = g(this.f31969d, str);
        if (g5 != null) {
            return g5.longValue();
        }
        j(str, "Long");
        return 0L;
    }

    public String getString(String str) {
        String h4 = h(this.f31968c, str);
        if (h4 != null) {
            b(str, c(this.f31968c));
            return h4;
        }
        String h5 = h(this.f31969d, str);
        if (h5 != null) {
            return h5;
        }
        j(str, "String");
        return "";
    }

    public FirebaseRemoteConfigValue getValue(String str) {
        String h4 = h(this.f31968c, str);
        if (h4 != null) {
            b(str, c(this.f31968c));
            return new FirebaseRemoteConfigValueImpl(h4, 2);
        }
        String h5 = h(this.f31969d, str);
        if (h5 != null) {
            return new FirebaseRemoteConfigValueImpl(h5, 1);
        }
        j(str, "FirebaseRemoteConfigValue");
        return new FirebaseRemoteConfigValueImpl("", 0);
    }
}
