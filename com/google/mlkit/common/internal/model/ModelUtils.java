package com.google.mlkit.common.internal.model;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.internal.mlkit_common.zzad;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: com.google.mlkit:common@@18.5.0 */
@KeepForSdk
@WorkerThread
/* loaded from: classes5.dex */
public class ModelUtils {

    /* renamed from: a  reason: collision with root package name */
    private static final GmsLogger f32923a = new GmsLogger("ModelUtils", "");

    /* compiled from: com.google.mlkit:common@@18.5.0 */
    @KeepForSdk
    /* loaded from: classes5.dex */
    public static abstract class AutoMLManifest {
        @NonNull
        @KeepForSdk
        public abstract String getLabelsFile();

        @NonNull
        @KeepForSdk
        public abstract String getModelFile();

        @NonNull
        @KeepForSdk
        public abstract String getModelType();
    }

    /* compiled from: com.google.mlkit:common@@18.5.0 */
    @KeepForSdk
    /* loaded from: classes5.dex */
    public static abstract class ModelLoggingInfo {
        static ModelLoggingInfo a(long j4, @Nullable String str, boolean z3) {
            return new AutoValue_ModelUtils_ModelLoggingInfo(j4, zzad.zzb(str), z3);
        }

        @NonNull
        @KeepForSdk
        public abstract String getHash();

        @KeepForSdk
        public abstract long getSize();

        @KeepForSdk
        public abstract boolean isManifestModel();
    }

    private ModelUtils() {
    }

    @Nullable
    private static String a(Context context, String str, boolean z3) {
        AutoMLManifest parseManifestFile = parseManifestFile(str, z3, context);
        if (parseManifestFile == null) {
            f32923a.e("ModelUtils", "Failed to parse manifest file.");
            return null;
        }
        return new File(new File(str).getParent(), parseManifestFile.getModelFile()).toString();
    }

    @Nullable
    private static String b(InputStream inputStream) {
        int i4;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_SHA256);
            byte[] bArr = new byte[1048576];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                messageDigest.update(bArr, 0, read);
            }
            byte[] digest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b4 : digest) {
                String hexString = Integer.toHexString(b4 & 255);
                if (hexString.length() == 1) {
                    sb.append('0');
                }
                sb.append(hexString);
            }
            return sb.toString();
        } catch (IOException unused) {
            f32923a.e("ModelUtils", "Failed to read model file");
            return null;
        } catch (NoSuchAlgorithmException unused2) {
            f32923a.e("ModelUtils", "Do not have SHA-256 algorithm");
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0102 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @androidx.annotation.Nullable
    @com.google.android.gms.common.annotation.KeepForSdk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.mlkit.common.internal.model.ModelUtils.ModelLoggingInfo getModelLoggingInfo(@androidx.annotation.NonNull android.content.Context r11, @androidx.annotation.NonNull com.google.mlkit.common.model.LocalModel r12) {
        /*
            Method dump skipped, instructions count: 296
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.mlkit.common.internal.model.ModelUtils.getModelLoggingInfo(android.content.Context, com.google.mlkit.common.model.LocalModel):com.google.mlkit.common.internal.model.ModelUtils$ModelLoggingInfo");
    }

    @Nullable
    @KeepForSdk
    public static String getSHA256(@NonNull File file) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            String b4 = b(fileInputStream);
            fileInputStream.close();
            return b4;
        } catch (IOException e4) {
            f32923a.e("ModelUtils", "Failed to create FileInputStream for model: ".concat(e4.toString()));
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x002b, code lost:
        if (new java.io.File(r5).exists() == false) goto L5;
     */
    @androidx.annotation.Nullable
    @com.google.android.gms.common.annotation.KeepForSdk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.mlkit.common.internal.model.ModelUtils.AutoMLManifest parseManifestFile(@androidx.annotation.NonNull java.lang.String r5, boolean r6, @androidx.annotation.NonNull android.content.Context r7) {
        /*
            com.google.android.gms.common.internal.GmsLogger r0 = com.google.mlkit.common.internal.model.ModelUtils.f32923a
            java.lang.String r1 = java.lang.String.valueOf(r5)
            java.lang.String r2 = "Manifest file path: "
            java.lang.String r1 = r2.concat(r1)
            java.lang.String r2 = "ModelUtils"
            r0.d(r2, r1)
            r1 = 0
            if (r6 == 0) goto L22
            android.content.res.AssetManager r3 = r7.getAssets()     // Catch: java.io.IOException -> L2d
            java.io.InputStream r3 = r3.open(r5)     // Catch: java.io.IOException -> L2d
            if (r3 == 0) goto L35
            r3.close()     // Catch: java.io.IOException -> L2d
            goto L35
        L22:
            java.io.File r3 = new java.io.File
            r3.<init>(r5)
            boolean r3 = r3.exists()
            if (r3 != 0) goto L35
        L2d:
            com.google.android.gms.common.internal.GmsLogger r5 = com.google.mlkit.common.internal.model.ModelUtils.f32923a
            java.lang.String r6 = "Manifest file does not exist."
            r5.e(r2, r6)
            return r1
        L35:
            boolean r3 = r5.isEmpty()     // Catch: java.io.IOException -> La6 org.json.JSONException -> La8
            r4 = 0
            if (r3 == 0) goto L3f
            byte[] r5 = new byte[r4]     // Catch: java.io.IOException -> La6 org.json.JSONException -> La8
            goto L62
        L3f:
            if (r6 == 0) goto L4a
            android.content.res.AssetManager r6 = r7.getAssets()     // Catch: java.io.IOException -> La6 org.json.JSONException -> La8
            java.io.InputStream r5 = r6.open(r5)     // Catch: java.io.IOException -> La6 org.json.JSONException -> La8
            goto L55
        L4a:
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch: java.io.IOException -> La6 org.json.JSONException -> La8
            java.io.File r7 = new java.io.File     // Catch: java.io.IOException -> La6 org.json.JSONException -> La8
            r7.<init>(r5)     // Catch: java.io.IOException -> La6 org.json.JSONException -> La8
            r6.<init>(r7)     // Catch: java.io.IOException -> La6 org.json.JSONException -> La8
            r5 = r6
        L55:
            int r6 = r5.available()     // Catch: java.lang.Throwable -> L9a
            byte[] r7 = new byte[r6]     // Catch: java.lang.Throwable -> L9a
            r5.read(r7, r4, r6)     // Catch: java.lang.Throwable -> L9a
            r5.close()     // Catch: java.io.IOException -> La6 org.json.JSONException -> La8
            r5 = r7
        L62:
            java.lang.String r6 = new java.lang.String     // Catch: java.io.IOException -> La6 org.json.JSONException -> La8
            java.lang.String r7 = "UTF-8"
            r6.<init>(r5, r7)     // Catch: java.io.IOException -> La6 org.json.JSONException -> La8
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.io.IOException -> La6 org.json.JSONException -> La8
            r5.<init>()     // Catch: java.io.IOException -> La6 org.json.JSONException -> La8
            java.lang.String r7 = "Json string from the manifest file: "
            r5.append(r7)     // Catch: java.io.IOException -> La6 org.json.JSONException -> La8
            r5.append(r6)     // Catch: java.io.IOException -> La6 org.json.JSONException -> La8
            java.lang.String r5 = r5.toString()     // Catch: java.io.IOException -> La6 org.json.JSONException -> La8
            r0.d(r2, r5)     // Catch: java.io.IOException -> La6 org.json.JSONException -> La8
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch: java.io.IOException -> La6 org.json.JSONException -> La8
            r5.<init>(r6)     // Catch: java.io.IOException -> La6 org.json.JSONException -> La8
            java.lang.String r6 = "modelType"
            java.lang.String r6 = r5.getString(r6)     // Catch: java.io.IOException -> La6 org.json.JSONException -> La8
            java.lang.String r7 = "modelFile"
            java.lang.String r7 = r5.getString(r7)     // Catch: java.io.IOException -> La6 org.json.JSONException -> La8
            java.lang.String r0 = "labelsFile"
            java.lang.String r5 = r5.getString(r0)     // Catch: java.io.IOException -> La6 org.json.JSONException -> La8
            com.google.mlkit.common.internal.model.AutoValue_ModelUtils_AutoMLManifest r0 = new com.google.mlkit.common.internal.model.AutoValue_ModelUtils_AutoMLManifest     // Catch: java.io.IOException -> La6 org.json.JSONException -> La8
            r0.<init>(r6, r7, r5)     // Catch: java.io.IOException -> La6 org.json.JSONException -> La8
            return r0
        L9a:
            r6 = move-exception
            if (r5 == 0) goto La5
            r5.close()     // Catch: java.lang.Throwable -> La1
            goto La5
        La1:
            r5 = move-exception
            com.google.mlkit.common.internal.model.zzh.zza(r6, r5)     // Catch: java.io.IOException -> La6 org.json.JSONException -> La8
        La5:
            throw r6     // Catch: java.io.IOException -> La6 org.json.JSONException -> La8
        La6:
            r5 = move-exception
            goto La9
        La8:
            r5 = move-exception
        La9:
            com.google.android.gms.common.internal.GmsLogger r6 = com.google.mlkit.common.internal.model.ModelUtils.f32923a
            java.lang.String r7 = "Error parsing the manifest file."
            r6.e(r2, r7, r5)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.mlkit.common.internal.model.ModelUtils.parseManifestFile(java.lang.String, boolean, android.content.Context):com.google.mlkit.common.internal.model.ModelUtils$AutoMLManifest");
    }

    public static boolean zza(@NonNull File file, @NonNull String str) {
        String sha256 = getSHA256(file);
        f32923a.d("ModelUtils", "Calculated hash value is: ".concat(String.valueOf(sha256)));
        return str.equals(sha256);
    }
}
