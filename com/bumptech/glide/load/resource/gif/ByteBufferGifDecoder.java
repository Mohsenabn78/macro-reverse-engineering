package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.Glide;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.gifdecoder.GifHeader;
import com.bumptech.glide.gifdecoder.GifHeaderParser;
import com.bumptech.glide.gifdecoder.StandardGifDecoder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.UnitTransformation;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Util;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Queue;

/* loaded from: classes3.dex */
public class ByteBufferGifDecoder implements ResourceDecoder<ByteBuffer, GifDrawable> {

    /* renamed from: f  reason: collision with root package name */
    private static final a f17288f = new a();

    /* renamed from: g  reason: collision with root package name */
    private static final b f17289g = new b();

    /* renamed from: a  reason: collision with root package name */
    private final Context f17290a;

    /* renamed from: b  reason: collision with root package name */
    private final List<ImageHeaderParser> f17291b;

    /* renamed from: c  reason: collision with root package name */
    private final b f17292c;

    /* renamed from: d  reason: collision with root package name */
    private final a f17293d;

    /* renamed from: e  reason: collision with root package name */
    private final GifBitmapProvider f17294e;

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* loaded from: classes3.dex */
    public static class a {
        a() {
        }

        GifDecoder a(GifDecoder.BitmapProvider bitmapProvider, GifHeader gifHeader, ByteBuffer byteBuffer, int i4) {
            return new StandardGifDecoder(bitmapProvider, gifHeader, byteBuffer, i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private final Queue<GifHeaderParser> f17295a = Util.createQueue(0);

        b() {
        }

        synchronized GifHeaderParser a(ByteBuffer byteBuffer) {
            GifHeaderParser poll;
            poll = this.f17295a.poll();
            if (poll == null) {
                poll = new GifHeaderParser();
            }
            return poll.setData(byteBuffer);
        }

        synchronized void b(GifHeaderParser gifHeaderParser) {
            gifHeaderParser.clear();
            this.f17295a.offer(gifHeaderParser);
        }
    }

    public ByteBufferGifDecoder(Context context) {
        this(context, Glide.get(context).getRegistry().getImageHeaderParsers(), Glide.get(context).getBitmapPool(), Glide.get(context).getArrayPool());
    }

    @Nullable
    private GifDrawableResource a(ByteBuffer byteBuffer, int i4, int i5, GifHeaderParser gifHeaderParser, Options options) {
        Bitmap.Config config;
        long logTime = LogTime.getLogTime();
        try {
            GifHeader parseHeader = gifHeaderParser.parseHeader();
            if (parseHeader.getNumFrames() > 0 && parseHeader.getStatus() == 0) {
                if (options.get(GifOptions.DECODE_FORMAT) == DecodeFormat.PREFER_RGB_565) {
                    config = Bitmap.Config.RGB_565;
                } else {
                    config = Bitmap.Config.ARGB_8888;
                }
                GifDecoder a4 = this.f17293d.a(this.f17294e, parseHeader, byteBuffer, b(parseHeader, i4, i5));
                a4.setDefaultBitmapConfig(config);
                a4.advance();
                Bitmap nextFrame = a4.getNextFrame();
                if (nextFrame == null) {
                    return null;
                }
                GifDrawableResource gifDrawableResource = new GifDrawableResource(new GifDrawable(this.f17290a, a4, UnitTransformation.get(), i4, i5, nextFrame));
                if (Log.isLoggable("BufferGifDecoder", 2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Decoded GIF from stream in ");
                    sb.append(LogTime.getElapsedMillis(logTime));
                }
                return gifDrawableResource;
            }
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Decoded GIF from stream in ");
                sb2.append(LogTime.getElapsedMillis(logTime));
            }
            return null;
        } finally {
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Decoded GIF from stream in ");
                sb3.append(LogTime.getElapsedMillis(logTime));
            }
        }
    }

    private static int b(GifHeader gifHeader, int i4, int i5) {
        int highestOneBit;
        int min = Math.min(gifHeader.getHeight() / i5, gifHeader.getWidth() / i4);
        if (min == 0) {
            highestOneBit = 0;
        } else {
            highestOneBit = Integer.highestOneBit(min);
        }
        int max = Math.max(1, highestOneBit);
        if (Log.isLoggable("BufferGifDecoder", 2) && max > 1) {
            StringBuilder sb = new StringBuilder();
            sb.append("Downsampling GIF, sampleSize: ");
            sb.append(max);
            sb.append(", target dimens: [");
            sb.append(i4);
            sb.append("x");
            sb.append(i5);
            sb.append("], actual dimens: [");
            sb.append(gifHeader.getWidth());
            sb.append("x");
            sb.append(gifHeader.getHeight());
            sb.append("]");
        }
        return max;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public GifDrawableResource decode(@NonNull ByteBuffer byteBuffer, int i4, int i5, @NonNull Options options) {
        GifHeaderParser a4 = this.f17292c.a(byteBuffer);
        try {
            return a(byteBuffer, i4, i5, a4, options);
        } finally {
            this.f17292c.b(a4);
        }
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public boolean handles(@NonNull ByteBuffer byteBuffer, @NonNull Options options) throws IOException {
        return !((Boolean) options.get(GifOptions.DISABLE_ANIMATION)).booleanValue() && ImageHeaderParserUtils.getType(this.f17291b, byteBuffer) == ImageHeaderParser.ImageType.GIF;
    }

    public ByteBufferGifDecoder(Context context, List<ImageHeaderParser> list, BitmapPool bitmapPool, ArrayPool arrayPool) {
        this(context, list, bitmapPool, arrayPool, f17289g, f17288f);
    }

    @VisibleForTesting
    ByteBufferGifDecoder(Context context, List<ImageHeaderParser> list, BitmapPool bitmapPool, ArrayPool arrayPool, b bVar, a aVar) {
        this.f17290a = context.getApplicationContext();
        this.f17291b = list;
        this.f17293d = aVar;
        this.f17294e = new GifBitmapProvider(bitmapPool, arrayPool);
        this.f17292c = bVar;
    }
}
