package com.google.android.gms.internal.mlkit_translate;

import android.content.Context;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.util.AtomicFile;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.Dependency;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes4.dex */
public final class zzqy {
    public static final Component zza = Component.builder(zzqy.class).add(Dependency.required(Context.class)).factory(new ComponentFactory() { // from class: com.google.android.gms.internal.mlkit_translate.zzqx
        @Override // com.google.firebase.components.ComponentFactory
        public final Object create(ComponentContainer componentContainer) {
            return new zzqy((Context) componentContainer.get(Context.class));
        }
    }).build();
    private static final Object zzb = new Object();
    private final Context zzc;

    public zzqy(Context context) {
        this.zzc = context;
    }

    private final File zzc() {
        File noBackupFilesDir = ContextCompat.getNoBackupFilesDir(this.zzc);
        if (noBackupFilesDir == null || !noBackupFilesDir.isDirectory()) {
            Log.w("MLKitRemoteConfigSaver", "noBackupFilesDir doesn't exist, using regular files directory instead");
            noBackupFilesDir = this.zzc.getFilesDir();
            if (noBackupFilesDir != null && !noBackupFilesDir.isDirectory()) {
                try {
                    if (!noBackupFilesDir.mkdirs()) {
                        String obj = noBackupFilesDir.toString();
                        Log.w("MLKitRemoteConfigSaver", "mkdirs failed: " + obj);
                    }
                } catch (SecurityException e4) {
                    Log.w("MLKitRemoteConfigSaver", "mkdirs threw an exception: ".concat(noBackupFilesDir.toString()), e4);
                }
            }
        }
        return new File(noBackupFilesDir, "com.google.mlkit.RemoteConfig");
    }

    @Nullable
    public final zzqk zza(zzox zzoxVar) {
        zzqk zzqkVar;
        synchronized (zzb) {
            File zzc = zzc();
            zzqkVar = null;
            try {
                String str = new String(new AtomicFile(zzc).readFully(), Charset.forName("UTF-8"));
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    try {
                        zzqkVar = new zzqk(jSONObject.getJSONObject("configs_key"), new Date(jSONObject.getLong("fetch_time_key")), jSONObject.getJSONArray("abt_experiments_key"));
                    } catch (JSONException e4) {
                        zzoxVar.zzc(zznk.FILE_READ_RETURNED_INVALID_DATA);
                        Log.e("MLKitRemoteConfigSaver", "Error parsing remote config settings JSON object:\n".concat(jSONObject.toString()), e4);
                    }
                } catch (JSONException e5) {
                    zzoxVar.zzc(zznk.FILE_READ_RETURNED_MALFORMED_DATA);
                    Log.e("MLKitRemoteConfigSaver", "Error parsing remote config settings JSON string:\n".concat(str), e5);
                }
            } catch (IOException e6) {
                if (!zzc.exists()) {
                    String obj = zzc.toString();
                    Log.i("MLKitRemoteConfigSaver", "remote config settings file not yet present: " + obj);
                    return null;
                }
                zzoxVar.zzc(zznk.FILE_READ_FAILED);
                String obj2 = zzc.toString();
                Log.w("MLKitRemoteConfigSaver", "Error reading remote config settings file: " + obj2, e6);
                return null;
            }
        }
        return zzqkVar;
    }

    public final void zzb(zzqk zzqkVar, zzox zzoxVar) {
        File file;
        AtomicFile atomicFile;
        FileOutputStream startWrite;
        String zzqkVar2 = zzqkVar.toString();
        synchronized (zzb) {
            try {
                file = zzc();
                try {
                    String obj = file.toString();
                    Log.i("MLKitRemoteConfigSaver", "Creating remote config settings: " + obj);
                    atomicFile = new AtomicFile(file);
                    startWrite = atomicFile.startWrite();
                } catch (IOException e4) {
                    e = e4;
                    zzoxVar.zzc(zznk.FILE_WRITE_FAILED);
                    String valueOf = String.valueOf(file);
                    Log.e("MLKitRemoteConfigSaver", "Error writing to remote config settings file " + valueOf, e);
                }
            } catch (IOException e5) {
                e = e5;
                file = null;
            }
            try {
                PrintWriter printWriter = new PrintWriter(startWrite);
                printWriter.println(zzqkVar2);
                printWriter.flush();
                atomicFile.finishWrite(startWrite);
                String obj2 = file.toString();
                StringBuilder sb = new StringBuilder();
                sb.append("Succeeded writing remote config settings: ");
                sb.append(obj2);
                sb.append(":\n");
                sb.append(zzqkVar2);
            } catch (Throwable th) {
                atomicFile.failWrite(startWrite);
                throw th;
            }
        }
    }
}
