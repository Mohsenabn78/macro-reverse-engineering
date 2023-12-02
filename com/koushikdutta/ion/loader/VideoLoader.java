package com.koushikdutta.ion.loader;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.os.Build;
import com.koushikdutta.async.future.Future;
import com.koushikdutta.async.future.SimpleFuture;
import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.ResponseServedFrom;
import com.koushikdutta.ion.bitmap.BitmapInfo;
import com.koushikdutta.ion.loader.MediaFile;
import java.io.File;
import java.net.URI;

/* loaded from: classes6.dex */
public class VideoLoader extends SimpleLoader {

    /* loaded from: classes6.dex */
    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f36076a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ SimpleFuture f36077b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f36078c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f36079d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f36080e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ MediaFile.MediaFileType f36081f;

        a(String str, SimpleFuture simpleFuture, int i4, int i5, String str2, MediaFile.MediaFileType mediaFileType) {
            this.f36076a = str;
            this.f36077b = simpleFuture;
            this.f36078c = i4;
            this.f36079d = i5;
            this.f36080e = str2;
            this.f36081f = mediaFileType;
        }

        @Override // java.lang.Runnable
        public void run() {
            Bitmap createVideoThumbnail;
            File file = new File(URI.create(this.f36076a));
            if (this.f36077b.isCancelled()) {
                return;
            }
            try {
                if (!VideoLoader.a()) {
                    createVideoThumbnail = VideoLoader.createVideoThumbnail(file.getAbsolutePath());
                } else {
                    createVideoThumbnail = ThumbnailUtils.createVideoThumbnail(file.getAbsolutePath(), 1);
                }
                if (createVideoThumbnail != null) {
                    Point point = new Point(createVideoThumbnail.getWidth(), createVideoThumbnail.getHeight());
                    if (createVideoThumbnail.getWidth() > this.f36078c * 2 && createVideoThumbnail.getHeight() > this.f36079d * 2) {
                        float min = Math.min(this.f36078c / createVideoThumbnail.getWidth(), this.f36079d / createVideoThumbnail.getHeight());
                        if (min != 0.0f) {
                            createVideoThumbnail = Bitmap.createScaledBitmap(createVideoThumbnail, (int) (createVideoThumbnail.getWidth() * min), (int) (createVideoThumbnail.getHeight() * min), true);
                        }
                    }
                    BitmapInfo bitmapInfo = new BitmapInfo(this.f36080e, this.f36081f.mimeType, createVideoThumbnail, point);
                    bitmapInfo.servedFrom = ResponseServedFrom.LOADED_FROM_CACHE;
                    this.f36077b.setComplete((SimpleFuture) bitmapInfo);
                    return;
                }
                throw new Exception("video bitmap failed to load");
            } catch (Exception e4) {
                this.f36077b.setComplete(e4);
            } catch (OutOfMemoryError e5) {
                this.f36077b.setComplete(new Exception(e5));
            }
        }
    }

    static boolean a() {
        return Build.MANUFACTURER.toLowerCase().contains("samsung");
    }

    @TargetApi(10)
    public static Bitmap createVideoThumbnail(String str) throws Exception {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(str);
        try {
            return mediaMetadataRetriever.getFrameAtTime();
        } finally {
            try {
                mediaMetadataRetriever.release();
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.koushikdutta.ion.loader.SimpleLoader, com.koushikdutta.ion.Loader
    public Future<BitmapInfo> loadBitmap(Context context, Ion ion, String str, String str2, int i4, int i5, boolean z3) {
        MediaFile.MediaFileType fileType;
        if (!str2.startsWith("file") || (fileType = MediaFile.getFileType(str2)) == null || !MediaFile.isVideoFileType(fileType.fileType)) {
            return null;
        }
        SimpleFuture simpleFuture = new SimpleFuture();
        Ion.getBitmapLoadExecutorService().execute(new a(str2, simpleFuture, i4, i5, str, fileType));
        return simpleFuture;
    }
}
