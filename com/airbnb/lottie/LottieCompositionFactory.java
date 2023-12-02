package com.airbnb.lottie;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import androidx.annotation.WorkerThread;
import com.airbnb.lottie.model.LottieCompositionCache;
import com.airbnb.lottie.parser.LottieCompositionMoshiParser;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.google.mlkit.common.sdkinternal.Constants;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import okio.BufferedSource;
import okio.Okio;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class LottieCompositionFactory {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<String, LottieTask<LottieComposition>> f1270a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f1271b = {80, 75, 3, 4};

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements LottieListener<LottieComposition> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f1272a;

        a(String str) {
            this.f1272a = str;
        }

        @Override // com.airbnb.lottie.LottieListener
        /* renamed from: a */
        public void onResult(LottieComposition lottieComposition) {
            LottieCompositionFactory.f1270a.remove(this.f1272a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements LottieListener<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f1273a;

        b(String str) {
            this.f1273a = str;
        }

        @Override // com.airbnb.lottie.LottieListener
        /* renamed from: a */
        public void onResult(Throwable th) {
            LottieCompositionFactory.f1270a.remove(this.f1273a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements Callable<LottieResult<LottieComposition>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f1274a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f1275b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f1276c;

        c(Context context, String str, String str2) {
            this.f1274a = context;
            this.f1275b = str;
            this.f1276c = str2;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public LottieResult<LottieComposition> call() {
            LottieResult<LottieComposition> fetchSync = L.networkFetcher(this.f1274a).fetchSync(this.f1275b, this.f1276c);
            if (this.f1276c != null && fetchSync.getValue() != null) {
                LottieCompositionCache.getInstance().put(this.f1276c, fetchSync.getValue());
            }
            return fetchSync;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d implements Callable<LottieResult<LottieComposition>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f1277a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f1278b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f1279c;

        d(Context context, String str, String str2) {
            this.f1277a = context;
            this.f1278b = str;
            this.f1279c = str2;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public LottieResult<LottieComposition> call() {
            return LottieCompositionFactory.fromAssetSync(this.f1277a, this.f1278b, this.f1279c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class e implements Callable<LottieResult<LottieComposition>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ WeakReference f1280a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f1281b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f1282c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f1283d;

        e(WeakReference weakReference, Context context, int i4, String str) {
            this.f1280a = weakReference;
            this.f1281b = context;
            this.f1282c = i4;
            this.f1283d = str;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public LottieResult<LottieComposition> call() {
            Context context = (Context) this.f1280a.get();
            if (context == null) {
                context = this.f1281b;
            }
            return LottieCompositionFactory.fromRawResSync(context, this.f1282c, this.f1283d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class f implements Callable<LottieResult<LottieComposition>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ InputStream f1284a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f1285b;

        f(InputStream inputStream, String str) {
            this.f1284a = inputStream;
            this.f1285b = str;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public LottieResult<LottieComposition> call() {
            return LottieCompositionFactory.fromJsonInputStreamSync(this.f1284a, this.f1285b);
        }
    }

    /* loaded from: classes2.dex */
    class g implements Callable<LottieResult<LottieComposition>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ JSONObject f1286a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f1287b;

        g(JSONObject jSONObject, String str) {
            this.f1286a = jSONObject;
            this.f1287b = str;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public LottieResult<LottieComposition> call() {
            return LottieCompositionFactory.fromJsonSync(this.f1286a, this.f1287b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class h implements Callable<LottieResult<LottieComposition>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f1288a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f1289b;

        h(String str, String str2) {
            this.f1288a = str;
            this.f1289b = str2;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public LottieResult<LottieComposition> call() {
            return LottieCompositionFactory.fromJsonStringSync(this.f1288a, this.f1289b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class i implements Callable<LottieResult<LottieComposition>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ JsonReader f1290a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f1291b;

        i(JsonReader jsonReader, String str) {
            this.f1290a = jsonReader;
            this.f1291b = str;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public LottieResult<LottieComposition> call() {
            return LottieCompositionFactory.fromJsonReaderSync(this.f1290a, this.f1291b);
        }
    }

    /* loaded from: classes2.dex */
    class j implements Callable<LottieResult<LottieComposition>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ZipInputStream f1292a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f1293b;

        j(ZipInputStream zipInputStream, String str) {
            this.f1292a = zipInputStream;
            this.f1293b = str;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public LottieResult<LottieComposition> call() {
            return LottieCompositionFactory.fromZipStreamSync(this.f1292a, this.f1293b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class k implements Callable<LottieResult<LottieComposition>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ LottieComposition f1294a;

        k(LottieComposition lottieComposition) {
            this.f1294a = lottieComposition;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public LottieResult<LottieComposition> call() {
            return new LottieResult<>(this.f1294a);
        }
    }

    private LottieCompositionFactory() {
    }

    private static LottieTask<LottieComposition> b(@Nullable String str, Callable<LottieResult<LottieComposition>> callable) {
        LottieComposition lottieComposition;
        if (str == null) {
            lottieComposition = null;
        } else {
            lottieComposition = LottieCompositionCache.getInstance().get(str);
        }
        if (lottieComposition != null) {
            return new LottieTask<>(new k(lottieComposition));
        }
        if (str != null) {
            Map<String, LottieTask<LottieComposition>> map = f1270a;
            if (map.containsKey(str)) {
                return map.get(str);
            }
        }
        LottieTask<LottieComposition> lottieTask = new LottieTask<>(callable);
        if (str != null) {
            lottieTask.addListener(new a(str));
            lottieTask.addFailureListener(new b(str));
            f1270a.put(str, lottieTask);
        }
        return lottieTask;
    }

    @Nullable
    private static LottieImageAsset c(LottieComposition lottieComposition, String str) {
        for (LottieImageAsset lottieImageAsset : lottieComposition.getImages().values()) {
            if (lottieImageAsset.getFileName().equals(str)) {
                return lottieImageAsset;
            }
        }
        return null;
    }

    public static void clearCache(Context context) {
        f1270a.clear();
        LottieCompositionCache.getInstance().clear();
        L.networkCache(context).clear();
    }

    @WorkerThread
    private static LottieResult<LottieComposition> d(InputStream inputStream, @Nullable String str, boolean z3) {
        try {
            return fromJsonReaderSync(JsonReader.of(Okio.buffer(Okio.source(inputStream))), str);
        } finally {
            if (z3) {
                Utils.closeQuietly(inputStream);
            }
        }
    }

    private static LottieResult<LottieComposition> e(JsonReader jsonReader, @Nullable String str, boolean z3) {
        try {
            try {
                LottieComposition parse = LottieCompositionMoshiParser.parse(jsonReader);
                if (str != null) {
                    LottieCompositionCache.getInstance().put(str, parse);
                }
                LottieResult<LottieComposition> lottieResult = new LottieResult<>(parse);
                if (z3) {
                    Utils.closeQuietly(jsonReader);
                }
                return lottieResult;
            } catch (Exception e4) {
                LottieResult<LottieComposition> lottieResult2 = new LottieResult<>(e4);
                if (z3) {
                    Utils.closeQuietly(jsonReader);
                }
                return lottieResult2;
            }
        } catch (Throwable th) {
            if (z3) {
                Utils.closeQuietly(jsonReader);
            }
            throw th;
        }
    }

    @WorkerThread
    private static LottieResult<LottieComposition> f(ZipInputStream zipInputStream, @Nullable String str) {
        String[] split;
        HashMap hashMap = new HashMap();
        try {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            LottieComposition lottieComposition = null;
            while (nextEntry != null) {
                String name = nextEntry.getName();
                if (name.contains("__MACOSX")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().equalsIgnoreCase(Constants.AUTOML_IMAGE_LABELING_MANIFEST_JSON_FILE_NAME)) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().contains(".json")) {
                    lottieComposition = e(JsonReader.of(Okio.buffer(Okio.source(zipInputStream))), null, false).getValue();
                } else {
                    if (!name.contains(".png") && !name.contains(".webp") && !name.contains(".jpg") && !name.contains(".jpeg")) {
                        zipInputStream.closeEntry();
                    }
                    hashMap.put(name.split(RemoteSettings.FORWARD_SLASH_STRING)[split.length - 1], BitmapFactory.decodeStream(zipInputStream));
                }
                nextEntry = zipInputStream.getNextEntry();
            }
            if (lottieComposition == null) {
                return new LottieResult<>(new IllegalArgumentException("Unable to parse composition"));
            }
            for (Map.Entry entry : hashMap.entrySet()) {
                LottieImageAsset c4 = c(lottieComposition, (String) entry.getKey());
                if (c4 != null) {
                    c4.setBitmap(Utils.resizeBitmapIfNeeded((Bitmap) entry.getValue(), c4.getWidth(), c4.getHeight()));
                }
            }
            for (Map.Entry<String, LottieImageAsset> entry2 : lottieComposition.getImages().entrySet()) {
                if (entry2.getValue().getBitmap() == null) {
                    return new LottieResult<>(new IllegalStateException("There is no image for " + entry2.getValue().getFileName()));
                }
            }
            if (str != null) {
                LottieCompositionCache.getInstance().put(str, lottieComposition);
            }
            return new LottieResult<>(lottieComposition);
        } catch (IOException e4) {
            return new LottieResult<>(e4);
        }
    }

    public static LottieTask<LottieComposition> fromAsset(Context context, String str) {
        return fromAsset(context, str, "asset_" + str);
    }

    @WorkerThread
    public static LottieResult<LottieComposition> fromAssetSync(Context context, String str) {
        return fromAssetSync(context, str, "asset_" + str);
    }

    @Deprecated
    public static LottieTask<LottieComposition> fromJson(JSONObject jSONObject, @Nullable String str) {
        return b(str, new g(jSONObject, str));
    }

    public static LottieTask<LottieComposition> fromJsonInputStream(InputStream inputStream, @Nullable String str) {
        return b(str, new f(inputStream, str));
    }

    @WorkerThread
    public static LottieResult<LottieComposition> fromJsonInputStreamSync(InputStream inputStream, @Nullable String str) {
        return d(inputStream, str, true);
    }

    public static LottieTask<LottieComposition> fromJsonReader(JsonReader jsonReader, @Nullable String str) {
        return b(str, new i(jsonReader, str));
    }

    @WorkerThread
    public static LottieResult<LottieComposition> fromJsonReaderSync(JsonReader jsonReader, @Nullable String str) {
        return e(jsonReader, str, true);
    }

    public static LottieTask<LottieComposition> fromJsonString(String str, @Nullable String str2) {
        return b(str2, new h(str, str2));
    }

    @WorkerThread
    public static LottieResult<LottieComposition> fromJsonStringSync(String str, @Nullable String str2) {
        return fromJsonReaderSync(JsonReader.of(Okio.buffer(Okio.source(new ByteArrayInputStream(str.getBytes())))), str2);
    }

    @WorkerThread
    @Deprecated
    public static LottieResult<LottieComposition> fromJsonSync(JSONObject jSONObject, @Nullable String str) {
        return fromJsonStringSync(jSONObject.toString(), str);
    }

    public static LottieTask<LottieComposition> fromRawRes(Context context, @RawRes int i4) {
        return fromRawRes(context, i4, i(context, i4));
    }

    @WorkerThread
    public static LottieResult<LottieComposition> fromRawResSync(Context context, @RawRes int i4) {
        return fromRawResSync(context, i4, i(context, i4));
    }

    public static LottieTask<LottieComposition> fromUrl(Context context, String str) {
        return fromUrl(context, str, "url_" + str);
    }

    @WorkerThread
    public static LottieResult<LottieComposition> fromUrlSync(Context context, String str) {
        return fromUrlSync(context, str, str);
    }

    public static LottieTask<LottieComposition> fromZipStream(ZipInputStream zipInputStream, @Nullable String str) {
        return b(str, new j(zipInputStream, str));
    }

    @WorkerThread
    public static LottieResult<LottieComposition> fromZipStreamSync(ZipInputStream zipInputStream, @Nullable String str) {
        try {
            return f(zipInputStream, str);
        } finally {
            Utils.closeQuietly(zipInputStream);
        }
    }

    private static boolean g(Context context) {
        if ((context.getResources().getConfiguration().uiMode & 48) == 32) {
            return true;
        }
        return false;
    }

    private static Boolean h(BufferedSource bufferedSource) {
        try {
            BufferedSource peek = bufferedSource.peek();
            for (byte b4 : f1271b) {
                if (peek.readByte() != b4) {
                    return Boolean.FALSE;
                }
            }
            peek.close();
            return Boolean.TRUE;
        } catch (Exception e4) {
            Logger.error("Failed to check zip file header", e4);
            return Boolean.FALSE;
        }
    }

    private static String i(Context context, @RawRes int i4) {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("rawRes");
        if (g(context)) {
            str = "_night_";
        } else {
            str = "_day_";
        }
        sb.append(str);
        sb.append(i4);
        return sb.toString();
    }

    public static void setMaxCacheSize(int i4) {
        LottieCompositionCache.getInstance().resize(i4);
    }

    public static LottieTask<LottieComposition> fromRawRes(Context context, @RawRes int i4, @Nullable String str) {
        return b(str, new e(new WeakReference(context), context.getApplicationContext(), i4, str));
    }

    @WorkerThread
    public static LottieResult<LottieComposition> fromRawResSync(Context context, @RawRes int i4, @Nullable String str) {
        try {
            BufferedSource buffer = Okio.buffer(Okio.source(context.getResources().openRawResource(i4)));
            if (h(buffer).booleanValue()) {
                return fromZipStreamSync(new ZipInputStream(buffer.inputStream()), str);
            }
            return fromJsonInputStreamSync(buffer.inputStream(), str);
        } catch (Resources.NotFoundException e4) {
            return new LottieResult<>(e4);
        }
    }

    public static LottieTask<LottieComposition> fromUrl(Context context, String str, @Nullable String str2) {
        return b(str2, new c(context, str, str2));
    }

    @WorkerThread
    public static LottieResult<LottieComposition> fromUrlSync(Context context, String str, @Nullable String str2) {
        LottieResult<LottieComposition> fetchSync = L.networkFetcher(context).fetchSync(str, str2);
        if (str2 != null && fetchSync.getValue() != null) {
            LottieCompositionCache.getInstance().put(str2, fetchSync.getValue());
        }
        return fetchSync;
    }

    public static LottieTask<LottieComposition> fromAsset(Context context, String str, @Nullable String str2) {
        return b(str2, new d(context.getApplicationContext(), str, str2));
    }

    @WorkerThread
    public static LottieResult<LottieComposition> fromAssetSync(Context context, String str, @Nullable String str2) {
        try {
            if (!str.endsWith(".zip") && !str.endsWith(".lottie")) {
                return fromJsonInputStreamSync(context.getAssets().open(str), str2);
            }
            return fromZipStreamSync(new ZipInputStream(context.getAssets().open(str)), str2);
        } catch (IOException e4) {
            return new LottieResult<>(e4);
        }
    }
}
