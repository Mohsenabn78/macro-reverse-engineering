package com.google.android.gms.internal.mlkit_translate;

import android.content.Context;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
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

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes4.dex */
public final class zzpa {
    public static final Component zza = Component.builder(zzpa.class).add(Dependency.required(Context.class)).factory(new ComponentFactory() { // from class: com.google.android.gms.internal.mlkit_translate.zzoz
        @Override // com.google.firebase.components.ComponentFactory
        public final Object create(ComponentContainer componentContainer) {
            return new zzpa((Context) componentContainer.get(Context.class));
        }
    }).build();
    private static final Object zzb = new Object();
    private final Context zzc;

    public zzpa(Context context) {
        this.zzc = context;
    }

    @Nullable
    public final zzpb zza(zzox zzoxVar) {
        zzpb zzpbVar;
        synchronized (zzb) {
            File zzb2 = zzb(zzoxVar);
            zzpbVar = null;
            try {
                String str = new String(new AtomicFile(zzb2).readFully(), Charset.forName("UTF-8"));
                try {
                    zzbo zzb3 = zzbt.zzb(str);
                    if (!(zzb3 instanceof zzbr)) {
                        Log.e("MLKitInstallationIdSaver", "Error parsing installation info JSON element:\n".concat(String.valueOf(zzb3)));
                        zzoxVar.zzc(zznk.FILE_READ_RETURNED_MALFORMED_DATA);
                    } else {
                        zzbr zzb4 = zzb3.zzb();
                        try {
                            zzop zzopVar = new zzop(zzb4.zzd("fid").zzd());
                            String zzd = zzb4.zzd("refreshToken").zzd();
                            String zzd2 = zzb4.zzd("temporaryToken").zzd();
                            long zza2 = zzb4.zzd("temporaryTokenExpiryTimestamp").zza();
                            String obj = zzopVar.toString();
                            StringBuilder sb = new StringBuilder();
                            sb.append("fid: ");
                            sb.append(obj);
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("refresh_token: ");
                            sb2.append(zzd);
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("temporary_token: ");
                            sb3.append(zzd2);
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append("temporary token expiry: ");
                            sb4.append(zza2);
                            zzpbVar = new zzpb(zzopVar, zzd, zzd2, zza2);
                        } catch (ClassCastException | IllegalStateException | NullPointerException e4) {
                            zzoxVar.zzc(zznk.FILE_READ_RETURNED_INVALID_DATA);
                            String obj2 = zzb4.toString();
                            Log.e("MLKitInstallationIdSaver", "Error traversing installation info JSON object:\nraw json:\n" + str + "\nparsed json:\n" + obj2, e4);
                        }
                    }
                } catch (zzbv e5) {
                    Log.e("MLKitInstallationIdSaver", "Error parsing installation info JSON object:\n".concat(str), e5);
                    zzoxVar.zzc(zznk.FILE_READ_RETURNED_MALFORMED_DATA);
                }
            } catch (IOException e6) {
                if (!zzb2.exists()) {
                    String obj3 = zzb2.toString();
                    Log.i("MLKitInstallationIdSaver", "Installation id file not yet present: " + obj3);
                    return null;
                }
                zzoxVar.zzc(zznk.FILE_READ_FAILED);
                String obj4 = zzb2.toString();
                Log.w("MLKitInstallationIdSaver", "Error reading installation id file: " + obj4, e6);
                return null;
            }
        }
        return zzpbVar;
    }

    @VisibleForTesting
    final File zzb(zzox zzoxVar) {
        File noBackupFilesDir = ContextCompat.getNoBackupFilesDir(this.zzc);
        if (noBackupFilesDir == null || !noBackupFilesDir.isDirectory()) {
            Log.w("MLKitInstallationIdSaver", "noBackupFilesDir doesn't exist, using regular files directory instead");
            noBackupFilesDir = this.zzc.getFilesDir();
            if (noBackupFilesDir != null && !noBackupFilesDir.isDirectory()) {
                try {
                    if (!noBackupFilesDir.mkdirs()) {
                        String obj = noBackupFilesDir.toString();
                        Log.w("MLKitInstallationIdSaver", "mkdirs failed: " + obj);
                        zzoxVar.zzd(zznk.DIRECTORY_CREATION_FAILED);
                    }
                } catch (SecurityException e4) {
                    Log.w("MLKitInstallationIdSaver", "mkdirs threw an exception: ".concat(noBackupFilesDir.toString()), e4);
                    zzoxVar.zzd(zznk.DIRECTORY_CREATION_FAILED);
                }
            }
        }
        return new File(noBackupFilesDir, "com.google.mlkit.InstallationId");
    }

    public final void zzc(zzpb zzpbVar, zzox zzoxVar) {
        File file;
        String format = String.format("{\n \"fid\": \"%s\",\n \"refreshToken\": \"%s\",\n \"temporaryToken\": \"%s\",\n \"temporaryTokenExpiryTimestamp\": \"%d\"\n}\n", zzpbVar.zzb().zza(), zzpbVar.zzc(), zzpbVar.zzd(), Long.valueOf(zzpbVar.zza()));
        synchronized (zzb) {
            try {
                file = zzb(zzoxVar);
                try {
                    String obj = file.toString();
                    Log.i("MLKitInstallationIdSaver", "Creating installation id: " + obj);
                    AtomicFile atomicFile = new AtomicFile(file);
                    FileOutputStream startWrite = atomicFile.startWrite();
                    try {
                        PrintWriter printWriter = new PrintWriter(startWrite);
                        printWriter.println(format);
                        printWriter.flush();
                        atomicFile.finishWrite(startWrite);
                        String obj2 = file.toString();
                        StringBuilder sb = new StringBuilder();
                        sb.append("Succeeded writing installation id: ");
                        sb.append(obj2);
                        sb.append(":\n");
                        sb.append(format);
                    } catch (Throwable th) {
                        atomicFile.failWrite(startWrite);
                        throw th;
                    }
                } catch (IOException e4) {
                    e = e4;
                    zzoxVar.zzc(zznk.FILE_WRITE_FAILED);
                    String valueOf = String.valueOf(file);
                    Log.e("MLKitInstallationIdSaver", "Error writing to installation id file " + valueOf, e);
                }
            } catch (IOException e5) {
                e = e5;
                file = null;
            }
        }
    }
}
