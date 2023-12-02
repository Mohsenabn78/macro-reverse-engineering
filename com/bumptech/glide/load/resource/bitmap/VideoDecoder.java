package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* loaded from: classes3.dex */
public class VideoDecoder<T> implements ResourceDecoder<T, Bitmap> {
    public static final long DEFAULT_FRAME = -1;

    /* renamed from: a  reason: collision with root package name */
    private final e<T> f17273a;

    /* renamed from: b  reason: collision with root package name */
    private final BitmapPool f17274b;

    /* renamed from: c  reason: collision with root package name */
    private final d f17275c;
    public static final Option<Long> TARGET_FRAME = Option.disk("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new a());
    public static final Option<Integer> FRAME_OPTION = Option.disk("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, new b());

    /* renamed from: d  reason: collision with root package name */
    private static final d f17272d = new d();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements Option.CacheKeyUpdater<Long> {

        /* renamed from: a  reason: collision with root package name */
        private final ByteBuffer f17276a = ByteBuffer.allocate(8);

        a() {
        }

        @Override // com.bumptech.glide.load.Option.CacheKeyUpdater
        /* renamed from: a */
        public void update(@NonNull byte[] bArr, @NonNull Long l4, @NonNull MessageDigest messageDigest) {
            messageDigest.update(bArr);
            synchronized (this.f17276a) {
                this.f17276a.position(0);
                messageDigest.update(this.f17276a.putLong(l4.longValue()).array());
            }
        }
    }

    /* loaded from: classes3.dex */
    class b implements Option.CacheKeyUpdater<Integer> {

        /* renamed from: a  reason: collision with root package name */
        private final ByteBuffer f17277a = ByteBuffer.allocate(4);

        b() {
        }

        @Override // com.bumptech.glide.load.Option.CacheKeyUpdater
        /* renamed from: a */
        public void update(@NonNull byte[] bArr, @NonNull Integer num, @NonNull MessageDigest messageDigest) {
            if (num == null) {
                return;
            }
            messageDigest.update(bArr);
            synchronized (this.f17277a) {
                this.f17277a.position(0);
                messageDigest.update(this.f17277a.putInt(num.intValue()).array());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class c implements e<AssetFileDescriptor> {
        private c() {
        }

        /* synthetic */ c(a aVar) {
            this();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.VideoDecoder.e
        /* renamed from: b */
        public void a(MediaMetadataRetriever mediaMetadataRetriever, AssetFileDescriptor assetFileDescriptor) {
            mediaMetadataRetriever.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        }
    }

    @VisibleForTesting
    /* loaded from: classes3.dex */
    static class d {
        d() {
        }

        public MediaMetadataRetriever a() {
            return new MediaMetadataRetriever();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* loaded from: classes3.dex */
    public interface e<T> {
        void a(MediaMetadataRetriever mediaMetadataRetriever, T t3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class f implements e<ParcelFileDescriptor> {
        @Override // com.bumptech.glide.load.resource.bitmap.VideoDecoder.e
        /* renamed from: b */
        public void a(MediaMetadataRetriever mediaMetadataRetriever, ParcelFileDescriptor parcelFileDescriptor) {
            mediaMetadataRetriever.setDataSource(parcelFileDescriptor.getFileDescriptor());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public VideoDecoder(BitmapPool bitmapPool, e<T> eVar) {
        this(bitmapPool, eVar, f17272d);
    }

    @Nullable
    private static Bitmap a(MediaMetadataRetriever mediaMetadataRetriever, long j4, int i4, int i5, int i6, DownsampleStrategy downsampleStrategy) {
        Bitmap bitmap;
        if (Build.VERSION.SDK_INT >= 27 && i5 != Integer.MIN_VALUE && i6 != Integer.MIN_VALUE && downsampleStrategy != DownsampleStrategy.NONE) {
            bitmap = c(mediaMetadataRetriever, j4, i4, i5, i6, downsampleStrategy);
        } else {
            bitmap = null;
        }
        if (bitmap == null) {
            return b(mediaMetadataRetriever, j4, i4);
        }
        return bitmap;
    }

    public static ResourceDecoder<AssetFileDescriptor, Bitmap> asset(BitmapPool bitmapPool) {
        return new VideoDecoder(bitmapPool, new c(null));
    }

    private static Bitmap b(MediaMetadataRetriever mediaMetadataRetriever, long j4, int i4) {
        return mediaMetadataRetriever.getFrameAtTime(j4, i4);
    }

    @TargetApi(27)
    private static Bitmap c(MediaMetadataRetriever mediaMetadataRetriever, long j4, int i4, int i5, int i6, DownsampleStrategy downsampleStrategy) {
        Bitmap scaledFrameAtTime;
        try {
            int parseInt = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
            int parseInt2 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
            int parseInt3 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
            if (parseInt3 == 90 || parseInt3 == 270) {
                parseInt2 = parseInt;
                parseInt = parseInt2;
            }
            float scaleFactor = downsampleStrategy.getScaleFactor(parseInt, parseInt2, i5, i6);
            scaledFrameAtTime = mediaMetadataRetriever.getScaledFrameAtTime(j4, i4, Math.round(parseInt * scaleFactor), Math.round(scaleFactor * parseInt2));
            return scaledFrameAtTime;
        } catch (Throwable unused) {
            Log.isLoggable("VideoDecoder", 3);
            return null;
        }
    }

    public static ResourceDecoder<ParcelFileDescriptor, Bitmap> parcel(BitmapPool bitmapPool) {
        return new VideoDecoder(bitmapPool, new f());
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public Resource<Bitmap> decode(@NonNull T t3, int i4, int i5, @NonNull Options options) throws IOException {
        long longValue = ((Long) options.get(TARGET_FRAME)).longValue();
        if (longValue < 0 && longValue != -1) {
            throw new IllegalArgumentException("Requested frame must be non-negative, or DEFAULT_FRAME, given: " + longValue);
        }
        Integer num = (Integer) options.get(FRAME_OPTION);
        if (num == null) {
            num = 2;
        }
        DownsampleStrategy downsampleStrategy = (DownsampleStrategy) options.get(DownsampleStrategy.OPTION);
        if (downsampleStrategy == null) {
            downsampleStrategy = DownsampleStrategy.DEFAULT;
        }
        DownsampleStrategy downsampleStrategy2 = downsampleStrategy;
        MediaMetadataRetriever a4 = this.f17275c.a();
        try {
            try {
                this.f17273a.a(a4, t3);
                Bitmap a5 = a(a4, longValue, num.intValue(), i4, i5, downsampleStrategy2);
                a4.release();
                return BitmapResource.obtain(a5, this.f17274b);
            } catch (RuntimeException e4) {
                throw new IOException(e4);
            }
        } catch (Throwable th) {
            a4.release();
            throw th;
        }
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public boolean handles(@NonNull T t3, @NonNull Options options) {
        return true;
    }

    @VisibleForTesting
    VideoDecoder(BitmapPool bitmapPool, e<T> eVar, d dVar) {
        this.f17274b = bitmapPool;
        this.f17273a = eVar;
        this.f17275c = dVar;
    }
}
