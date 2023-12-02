package com.airbnb.lottie.network;

import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieResult;
import com.airbnb.lottie.utils.Logger;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipInputStream;

/* loaded from: classes2.dex */
public class NetworkFetcher {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final NetworkCache f1784a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final LottieNetworkFetcher f1785b;

    public NetworkFetcher(@NonNull NetworkCache networkCache, @NonNull LottieNetworkFetcher lottieNetworkFetcher) {
        this.f1784a = networkCache;
        this.f1785b = lottieNetworkFetcher;
    }

    @Nullable
    @WorkerThread
    private LottieComposition a(@NonNull String str, @Nullable String str2) {
        Pair<FileExtension, InputStream> a4;
        LottieResult<LottieComposition> fromJsonInputStreamSync;
        if (str2 == null || (a4 = this.f1784a.a(str)) == null) {
            return null;
        }
        FileExtension fileExtension = (FileExtension) a4.first;
        InputStream inputStream = (InputStream) a4.second;
        if (fileExtension == FileExtension.ZIP) {
            fromJsonInputStreamSync = LottieCompositionFactory.fromZipStreamSync(new ZipInputStream(inputStream), str);
        } else {
            fromJsonInputStreamSync = LottieCompositionFactory.fromJsonInputStreamSync(inputStream, str);
        }
        if (fromJsonInputStreamSync.getValue() == null) {
            return null;
        }
        return fromJsonInputStreamSync.getValue();
    }

    @NonNull
    @WorkerThread
    private LottieResult<LottieComposition> b(@NonNull String str, @Nullable String str2) {
        boolean z3;
        Logger.debug("Fetching " + str);
        Closeable closeable = null;
        try {
            try {
                LottieFetchResult fetchSync = this.f1785b.fetchSync(str);
                if (fetchSync.isSuccessful()) {
                    LottieResult<LottieComposition> c4 = c(str, fetchSync.bodyByteStream(), fetchSync.contentType(), str2);
                    StringBuilder sb = new StringBuilder();
                    sb.append("Completed fetch from network. Success: ");
                    if (c4.getValue() != null) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    sb.append(z3);
                    Logger.debug(sb.toString());
                    try {
                        fetchSync.close();
                    } catch (IOException e4) {
                        Logger.warning("LottieFetchResult close failed ", e4);
                    }
                    return c4;
                }
                LottieResult<LottieComposition> lottieResult = new LottieResult<>(new IllegalArgumentException(fetchSync.error()));
                try {
                    fetchSync.close();
                } catch (IOException e5) {
                    Logger.warning("LottieFetchResult close failed ", e5);
                }
                return lottieResult;
            } catch (Exception e6) {
                LottieResult<LottieComposition> lottieResult2 = new LottieResult<>(e6);
                if (0 != 0) {
                    try {
                        closeable.close();
                    } catch (IOException e7) {
                        Logger.warning("LottieFetchResult close failed ", e7);
                    }
                }
                return lottieResult2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    closeable.close();
                } catch (IOException e8) {
                    Logger.warning("LottieFetchResult close failed ", e8);
                }
            }
            throw th;
        }
    }

    @NonNull
    private LottieResult<LottieComposition> c(@NonNull String str, @NonNull InputStream inputStream, @Nullable String str2, @Nullable String str3) throws IOException {
        FileExtension fileExtension;
        LottieResult<LottieComposition> e4;
        if (str2 == null) {
            str2 = "application/json";
        }
        if (!str2.contains("application/zip") && !str.split("\\?")[0].endsWith(".lottie")) {
            Logger.debug("Received json response.");
            fileExtension = FileExtension.JSON;
            e4 = d(str, inputStream, str3);
        } else {
            Logger.debug("Handling zip response.");
            fileExtension = FileExtension.ZIP;
            e4 = e(str, inputStream, str3);
        }
        if (str3 != null && e4.getValue() != null) {
            this.f1784a.e(str, fileExtension);
        }
        return e4;
    }

    @NonNull
    private LottieResult<LottieComposition> d(@NonNull String str, @NonNull InputStream inputStream, @Nullable String str2) throws IOException {
        if (str2 == null) {
            return LottieCompositionFactory.fromJsonInputStreamSync(inputStream, null);
        }
        return LottieCompositionFactory.fromJsonInputStreamSync(new FileInputStream(new File(this.f1784a.f(str, inputStream, FileExtension.JSON).getAbsolutePath())), str);
    }

    @NonNull
    private LottieResult<LottieComposition> e(@NonNull String str, @NonNull InputStream inputStream, @Nullable String str2) throws IOException {
        if (str2 == null) {
            return LottieCompositionFactory.fromZipStreamSync(new ZipInputStream(inputStream), null);
        }
        return LottieCompositionFactory.fromZipStreamSync(new ZipInputStream(new FileInputStream(this.f1784a.f(str, inputStream, FileExtension.ZIP))), str);
    }

    @NonNull
    @WorkerThread
    public LottieResult<LottieComposition> fetchSync(@NonNull String str, @Nullable String str2) {
        LottieComposition a4 = a(str, str2);
        if (a4 != null) {
            return new LottieResult<>(a4);
        }
        Logger.debug("Animation for " + str + " not found in cache. Fetching from network.");
        return b(str, str2);
    }
}
