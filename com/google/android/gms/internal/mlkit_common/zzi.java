package com.google.android.gms.internal.mlkit_common;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import androidx.core.content.ContextCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Callable;

/* compiled from: com.google.mlkit:common@@18.5.0 */
/* loaded from: classes4.dex */
public final class zzi {
    public static final /* synthetic */ int zza = 0;
    private static final String[] zzb = {"com.android.", "com.google.", "com.chrome.", "com.nest.", "com.waymo.", "com.waze"};
    private static final String[] zzc;
    private static final String[] zzd;

    static {
        boolean z3;
        String str;
        String str2;
        String[] strArr = new String[2];
        strArr[0] = "media";
        String str3 = Build.HARDWARE;
        if (!str3.equals("goldfish") && !str3.equals("ranchu")) {
            z3 = false;
        } else {
            z3 = true;
        }
        String str4 = "";
        if (true != z3) {
            str = "";
        } else {
            str = "androidx.test.services.storage.runfiles";
        }
        strArr[1] = str;
        zzc = strArr;
        String[] strArr2 = new String[3];
        int i4 = Build.VERSION.SDK_INT;
        if (i4 > 25) {
            str2 = "";
        } else {
            str2 = "com.google.android.inputmethod.latin.inputcontent";
        }
        strArr2[0] = str2;
        if (i4 <= 25) {
            str4 = "com.google.android.inputmethod.latin.dev.inputcontent";
        }
        strArr2[1] = str4;
        strArr2[2] = "com.google.android.apps.docs.storage.legacy";
        zzd = strArr2;
    }

    public static AssetFileDescriptor zza(Context context, Uri uri, String str) throws FileNotFoundException {
        zzh zzhVar = zzh.zza;
        ContentResolver contentResolver = context.getContentResolver();
        Uri zzc2 = zzc(uri);
        String scheme = zzc2.getScheme();
        if ("android.resource".equals(scheme)) {
            return contentResolver.openAssetFileDescriptor(zzc2, "r");
        }
        if (FirebaseAnalytics.Param.CONTENT.equals(scheme)) {
            if (zzi(context, zzc2, 1, zzhVar)) {
                AssetFileDescriptor openAssetFileDescriptor = contentResolver.openAssetFileDescriptor(zzc2, "r");
                zzd(openAssetFileDescriptor);
                return openAssetFileDescriptor;
            }
            throw new FileNotFoundException("Can't open content uri.");
        } else if ("file".equals(scheme)) {
            AssetFileDescriptor openAssetFileDescriptor2 = contentResolver.openAssetFileDescriptor(zzc2, "r");
            zzd(openAssetFileDescriptor2);
            try {
                zzh(context, openAssetFileDescriptor2.getParcelFileDescriptor(), zzc2, zzhVar);
                return openAssetFileDescriptor2;
            } catch (FileNotFoundException e4) {
                zzf(openAssetFileDescriptor2, e4);
                throw e4;
            } catch (IOException e5) {
                FileNotFoundException fileNotFoundException = new FileNotFoundException("Validation failed.");
                fileNotFoundException.initCause(e5);
                zzf(openAssetFileDescriptor2, fileNotFoundException);
                throw fileNotFoundException;
            }
        } else {
            throw new FileNotFoundException("Unsupported scheme");
        }
    }

    public static InputStream zzb(Context context, Uri uri) throws FileNotFoundException {
        zzh zzhVar = zzh.zza;
        ContentResolver contentResolver = context.getContentResolver();
        Uri zzc2 = zzc(uri);
        String scheme = zzc2.getScheme();
        if ("android.resource".equals(scheme)) {
            return contentResolver.openInputStream(zzc2);
        }
        if (FirebaseAnalytics.Param.CONTENT.equals(scheme)) {
            if (zzi(context, zzc2, 1, zzhVar)) {
                InputStream openInputStream = contentResolver.openInputStream(zzc2);
                zzd(openInputStream);
                return openInputStream;
            }
            throw new FileNotFoundException("Can't open content uri.");
        } else if ("file".equals(scheme)) {
            try {
                ParcelFileDescriptor openFileDescriptor = contentResolver.openFileDescriptor(Uri.fromFile(new File(zzc2.getPath()).getCanonicalFile()), "r");
                try {
                    zzh(context, openFileDescriptor, zzc2, zzhVar);
                    return new ParcelFileDescriptor.AutoCloseInputStream(openFileDescriptor);
                } catch (FileNotFoundException e4) {
                    zzg(openFileDescriptor, e4);
                    throw e4;
                } catch (IOException e5) {
                    FileNotFoundException fileNotFoundException = new FileNotFoundException("Validation failed.");
                    fileNotFoundException.initCause(e5);
                    zzg(openFileDescriptor, fileNotFoundException);
                    throw fileNotFoundException;
                }
            } catch (IOException e6) {
                FileNotFoundException fileNotFoundException2 = new FileNotFoundException("Canonicalization failed.");
                fileNotFoundException2.initCause(e6);
                throw fileNotFoundException2;
            }
        } else {
            throw new FileNotFoundException("Unsupported scheme");
        }
    }

    private static Uri zzc(Uri uri) {
        if (Build.VERSION.SDK_INT < 30) {
            return Uri.parse(uri.toString());
        }
        return uri;
    }

    private static Object zzd(Object obj) throws FileNotFoundException {
        if (obj != null) {
            return obj;
        }
        throw new FileNotFoundException("Content resolver returned null value.");
    }

    private static String zze(File file) throws IOException {
        String canonicalPath = file.getCanonicalPath();
        if (!canonicalPath.endsWith(RemoteSettings.FORWARD_SLASH_STRING)) {
            return canonicalPath.concat(RemoteSettings.FORWARD_SLASH_STRING);
        }
        return canonicalPath;
    }

    private static void zzf(AssetFileDescriptor assetFileDescriptor, FileNotFoundException fileNotFoundException) {
        try {
            assetFileDescriptor.close();
        } catch (IOException e4) {
            Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(fileNotFoundException, e4);
        }
    }

    private static void zzg(ParcelFileDescriptor parcelFileDescriptor, FileNotFoundException fileNotFoundException) {
        try {
            parcelFileDescriptor.close();
        } catch (IOException e4) {
            Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(fileNotFoundException, e4);
        }
    }

    private static void zzh(final Context context, ParcelFileDescriptor parcelFileDescriptor, Uri uri, zzh zzhVar) throws IOException {
        File dataDir;
        String canonicalPath = new File(uri.getPath()).getCanonicalPath();
        zzp zza2 = zzp.zza(parcelFileDescriptor.getFileDescriptor());
        zzp zzb2 = zzp.zzb(canonicalPath);
        if (!zzb2.zzc) {
            if (zza2.zza == zzb2.zza && zza2.zzb == zzb2.zzb) {
                if (!canonicalPath.startsWith("/proc/") && !canonicalPath.startsWith("/data/misc/")) {
                    zzh.zza(zzhVar);
                    File dataDir2 = ContextCompat.getDataDir(context);
                    boolean z3 = true;
                    if (dataDir2 == null ? !canonicalPath.startsWith(zze(Environment.getDataDirectory())) : !canonicalPath.startsWith(zze(dataDir2))) {
                        Context createDeviceProtectedStorageContext = ContextCompat.createDeviceProtectedStorageContext(context);
                        if (createDeviceProtectedStorageContext == null || (dataDir = ContextCompat.getDataDir(createDeviceProtectedStorageContext)) == null || !canonicalPath.startsWith(zze(dataDir))) {
                            File[] zzj = zzj(new Callable() { // from class: com.google.android.gms.internal.mlkit_common.zzc
                                @Override // java.util.concurrent.Callable
                                public final Object call() {
                                    Context context2 = context;
                                    int i4 = zzi.zza;
                                    return ContextCompat.getExternalFilesDirs(context2, null);
                                }
                            });
                            int length = zzj.length;
                            int i4 = 0;
                            while (true) {
                                if (i4 < length) {
                                    File file = zzj[i4];
                                    if (file != null && canonicalPath.startsWith(zze(file))) {
                                        break;
                                    }
                                    i4++;
                                } else {
                                    File[] zzj2 = zzj(new Callable() { // from class: com.google.android.gms.internal.mlkit_common.zzd
                                        @Override // java.util.concurrent.Callable
                                        public final Object call() {
                                            Context context2 = context;
                                            int i5 = zzi.zza;
                                            return ContextCompat.getExternalCacheDirs(context2);
                                        }
                                    });
                                    int length2 = zzj2.length;
                                    int i5 = 0;
                                    while (true) {
                                        if (i5 < length2) {
                                            File file2 = zzj2[i5];
                                            if (file2 != null && canonicalPath.startsWith(zze(file2))) {
                                                break;
                                            }
                                            i5++;
                                        } else {
                                            z3 = false;
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (z3 == zzh.zzb(zzhVar)) {
                        return;
                    }
                }
                throw new FileNotFoundException("Can't open file: ".concat(canonicalPath));
            }
            throw new FileNotFoundException("Can't open file: ".concat(String.valueOf(canonicalPath)));
        }
        throw new FileNotFoundException("Can't open file: ".concat(String.valueOf(canonicalPath)));
    }

    private static boolean zzi(Context context, Uri uri, int i4, zzh zzhVar) {
        String authority = uri.getAuthority();
        ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider(authority, 0);
        if (resolveContentProvider == null) {
            int lastIndexOf = authority.lastIndexOf(64);
            if (lastIndexOf >= 0) {
                authority = authority.substring(lastIndexOf + 1);
                resolveContentProvider = context.getPackageManager().resolveContentProvider(authority, 0);
            }
            if (resolveContentProvider == null) {
                if (zzh.zzb(zzhVar)) {
                    return false;
                }
                return true;
            }
        }
        int zzc2 = zzh.zzc(zzhVar, context, new zzq(uri, resolveContentProvider, authority)) - 1;
        if (zzc2 == 0) {
            return true;
        }
        if (zzc2 == 1) {
            return false;
        }
        if (context.getPackageName().equals(resolveContentProvider.packageName)) {
            return zzh.zzb(zzhVar);
        }
        if (zzh.zzb(zzhVar)) {
            return false;
        }
        if (context.checkUriPermission(uri, Process.myPid(), Process.myUid(), 1) != 0 && resolveContentProvider.exported) {
            String[] strArr = zzc;
            int length = strArr.length;
            for (int i5 = 0; i5 < 2; i5++) {
                if (strArr[i5].equals(authority)) {
                    return true;
                }
            }
            String[] strArr2 = zzd;
            int length2 = strArr2.length;
            for (int i6 = 0; i6 < 3; i6++) {
                if (strArr2[i6].equals(authority)) {
                    return true;
                }
            }
            String[] strArr3 = zzb;
            for (int i7 = 0; i7 < 6; i7++) {
                String str = strArr3[i7];
                if (str.charAt(str.length() - 1) == '.') {
                    if (resolveContentProvider.packageName.startsWith(str)) {
                        return false;
                    }
                } else if (resolveContentProvider.packageName.equals(str)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static File[] zzj(Callable callable) {
        try {
            return (File[]) callable.call();
        } catch (NullPointerException e4) {
            if (Build.VERSION.SDK_INT < 22) {
                return new File[0];
            }
            throw e4;
        } catch (Exception e5) {
            throw new RuntimeException(e5);
        }
    }
}
