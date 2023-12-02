package com.google.firebase.remoteconfig.internal;

import android.content.Context;
import androidx.annotation.AnyThread;
import androidx.annotation.GuardedBy;
import androidx.annotation.VisibleForTesting;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@AnyThread
/* loaded from: classes5.dex */
public class ConfigStorageClient {
    @GuardedBy("ConfigStorageClient.class")

    /* renamed from: c  reason: collision with root package name */
    private static final Map<String, ConfigStorageClient> f32012c = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    private final Context f32013a;

    /* renamed from: b  reason: collision with root package name */
    private final String f32014b;

    private ConfigStorageClient(Context context, String str) {
        this.f32013a = context;
        this.f32014b = str;
    }

    @VisibleForTesting
    public static synchronized void clearInstancesForTest() {
        synchronized (ConfigStorageClient.class) {
            f32012c.clear();
        }
    }

    public static synchronized ConfigStorageClient getInstance(Context context, String str) {
        ConfigStorageClient configStorageClient;
        synchronized (ConfigStorageClient.class) {
            Map<String, ConfigStorageClient> map = f32012c;
            if (!map.containsKey(str)) {
                map.put(str, new ConfigStorageClient(context, str));
            }
            configStorageClient = map.get(str);
        }
        return configStorageClient;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a() {
        return this.f32014b;
    }

    public synchronized Void clear() {
        this.f32013a.deleteFile(this.f32014b);
        return null;
    }

    @Nullable
    public synchronized ConfigContainer read() throws IOException {
        FileInputStream fileInputStream;
        Throwable th;
        try {
            fileInputStream = this.f32013a.openFileInput(this.f32014b);
        } catch (FileNotFoundException | JSONException unused) {
            fileInputStream = null;
        } catch (Throwable th2) {
            fileInputStream = null;
            th = th2;
        }
        try {
            int available = fileInputStream.available();
            byte[] bArr = new byte[available];
            fileInputStream.read(bArr, 0, available);
            ConfigContainer b4 = ConfigContainer.b(new JSONObject(new String(bArr, "UTF-8")));
            fileInputStream.close();
            return b4;
        } catch (FileNotFoundException | JSONException unused2) {
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
    }

    public synchronized Void write(ConfigContainer configContainer) throws IOException {
        FileOutputStream openFileOutput = this.f32013a.openFileOutput(this.f32014b, 0);
        openFileOutput.write(configContainer.toString().getBytes("UTF-8"));
        openFileOutput.close();
        return null;
    }
}
