package com.google.firebase.crashlytics.internal.metadata;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class MetaDataStore {

    /* renamed from: b  reason: collision with root package name */
    private static final Charset f29560b = Charset.forName("UTF-8");

    /* renamed from: a  reason: collision with root package name */
    private final FileStore f29561a;

    public MetaDataStore(FileStore fileStore) {
        this.f29561a = fileStore;
    }

    private static Map<String, String> d(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            hashMap.put(next, k(jSONObject, next));
        }
        return hashMap;
    }

    @Nullable
    private String e(String str) throws JSONException {
        return k(new JSONObject(str), "userId");
    }

    private static String f(Map<String, String> map) {
        return new JSONObject(map).toString();
    }

    private static void i(File file) {
        if (file.exists() && file.delete()) {
            Logger logger = Logger.getLogger();
            logger.i("Deleted corrupt file: " + file.getAbsolutePath());
        }
    }

    private static String j(String str) throws JSONException {
        return new JSONObject(str) { // from class: com.google.firebase.crashlytics.internal.metadata.MetaDataStore.1

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ String f29562a;

            {
                this.f29562a = str;
                put("userId", str);
            }
        }.toString();
    }

    private static String k(JSONObject jSONObject, String str) {
        if (jSONObject.isNull(str)) {
            return null;
        }
        return jSONObject.optString(str, null);
    }

    @NonNull
    public File a(String str) {
        return this.f29561a.getSessionFile(str, UserMetadata.INTERNAL_KEYDATA_FILENAME);
    }

    @NonNull
    public File b(String str) {
        return this.f29561a.getSessionFile(str, UserMetadata.KEYDATA_FILENAME);
    }

    @NonNull
    public File c(String str) {
        return this.f29561a.getSessionFile(str, UserMetadata.USERDATA_FILENAME);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<String, String> g(String str, boolean z3) {
        File b4;
        FileInputStream fileInputStream;
        Exception e4;
        if (z3) {
            b4 = a(str);
        } else {
            b4 = b(str);
        }
        if (b4.exists() && b4.length() != 0) {
            FileInputStream fileInputStream2 = null;
            try {
                fileInputStream = new FileInputStream(b4);
            } catch (Exception e5) {
                fileInputStream = null;
                e4 = e5;
            } catch (Throwable th) {
                th = th;
                CommonUtils.closeOrLog(fileInputStream2, "Failed to close user metadata file.");
                throw th;
            }
            try {
                try {
                    Map<String, String> d4 = d(CommonUtils.streamToString(fileInputStream));
                    CommonUtils.closeOrLog(fileInputStream, "Failed to close user metadata file.");
                    return d4;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream2 = fileInputStream;
                    CommonUtils.closeOrLog(fileInputStream2, "Failed to close user metadata file.");
                    throw th;
                }
            } catch (Exception e6) {
                e4 = e6;
                Logger.getLogger().w("Error deserializing user metadata.", e4);
                i(b4);
                CommonUtils.closeOrLog(fileInputStream, "Failed to close user metadata file.");
                return Collections.emptyMap();
            }
        }
        i(b4);
        return Collections.emptyMap();
    }

    @Nullable
    public String h(String str) {
        FileInputStream fileInputStream;
        File c4 = c(str);
        FileInputStream fileInputStream2 = null;
        if (c4.exists() && c4.length() != 0) {
            try {
                fileInputStream = new FileInputStream(c4);
            } catch (Exception e4) {
                e = e4;
                fileInputStream = null;
            } catch (Throwable th) {
                th = th;
                CommonUtils.closeOrLog(fileInputStream2, "Failed to close user metadata file.");
                throw th;
            }
            try {
                try {
                    String e5 = e(CommonUtils.streamToString(fileInputStream));
                    Logger.getLogger().d("Loaded userId " + e5 + " for session " + str);
                    CommonUtils.closeOrLog(fileInputStream, "Failed to close user metadata file.");
                    return e5;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream2 = fileInputStream;
                    CommonUtils.closeOrLog(fileInputStream2, "Failed to close user metadata file.");
                    throw th;
                }
            } catch (Exception e6) {
                e = e6;
                Logger.getLogger().w("Error deserializing user metadata.", e);
                i(c4);
                CommonUtils.closeOrLog(fileInputStream, "Failed to close user metadata file.");
                return null;
            }
        }
        Logger.getLogger().d("No userId set for session " + str);
        i(c4);
        return null;
    }

    public void l(String str, Map<String, String> map, boolean z3) {
        File b4;
        if (z3) {
            b4 = a(str);
        } else {
            b4 = b(str);
        }
        BufferedWriter bufferedWriter = null;
        try {
            try {
                String f4 = f(map);
                BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(b4), f29560b));
                try {
                    bufferedWriter2.write(f4);
                    bufferedWriter2.flush();
                    CommonUtils.closeOrLog(bufferedWriter2, "Failed to close key/value metadata file.");
                } catch (Exception e4) {
                    e = e4;
                    bufferedWriter = bufferedWriter2;
                    Logger.getLogger().w("Error serializing key/value metadata.", e);
                    i(b4);
                    CommonUtils.closeOrLog(bufferedWriter, "Failed to close key/value metadata file.");
                } catch (Throwable th) {
                    th = th;
                    bufferedWriter = bufferedWriter2;
                    CommonUtils.closeOrLog(bufferedWriter, "Failed to close key/value metadata file.");
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public void m(String str, String str2) {
        File c4 = c(str);
        BufferedWriter bufferedWriter = null;
        try {
            try {
                String j4 = j(str2);
                BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(c4), f29560b));
                try {
                    bufferedWriter2.write(j4);
                    bufferedWriter2.flush();
                    CommonUtils.closeOrLog(bufferedWriter2, "Failed to close user metadata file.");
                } catch (Exception e4) {
                    e = e4;
                    bufferedWriter = bufferedWriter2;
                    Logger.getLogger().w("Error serializing user metadata.", e);
                    CommonUtils.closeOrLog(bufferedWriter, "Failed to close user metadata file.");
                } catch (Throwable th) {
                    th = th;
                    bufferedWriter = bufferedWriter2;
                    CommonUtils.closeOrLog(bufferedWriter, "Failed to close user metadata file.");
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e5) {
            e = e5;
        }
    }
}
