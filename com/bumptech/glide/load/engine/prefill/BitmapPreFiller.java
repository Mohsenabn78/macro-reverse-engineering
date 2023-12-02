package com.bumptech.glide.load.engine.prefill;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.prefill.PreFillType;
import com.bumptech.glide.util.Util;
import java.util.HashMap;

/* loaded from: classes3.dex */
public final class BitmapPreFiller {

    /* renamed from: a  reason: collision with root package name */
    private final MemoryCache f17079a;

    /* renamed from: b  reason: collision with root package name */
    private final BitmapPool f17080b;

    /* renamed from: c  reason: collision with root package name */
    private final DecodeFormat f17081c;

    /* renamed from: d  reason: collision with root package name */
    private final Handler f17082d = new Handler(Looper.getMainLooper());

    /* renamed from: e  reason: collision with root package name */
    private a f17083e;

    public BitmapPreFiller(MemoryCache memoryCache, BitmapPool bitmapPool, DecodeFormat decodeFormat) {
        this.f17079a = memoryCache;
        this.f17080b = bitmapPool;
        this.f17081c = decodeFormat;
    }

    private static int b(PreFillType preFillType) {
        return Util.getBitmapByteSize(preFillType.d(), preFillType.b(), preFillType.a());
    }

    @VisibleForTesting
    b a(PreFillType... preFillTypeArr) {
        long maxSize = (this.f17079a.getMaxSize() - this.f17079a.getCurrentSize()) + this.f17080b.getMaxSize();
        int i4 = 0;
        for (PreFillType preFillType : preFillTypeArr) {
            i4 += preFillType.c();
        }
        float f4 = ((float) maxSize) / i4;
        HashMap hashMap = new HashMap();
        for (PreFillType preFillType2 : preFillTypeArr) {
            hashMap.put(preFillType2, Integer.valueOf(Math.round(preFillType2.c() * f4) / b(preFillType2)));
        }
        return new b(hashMap);
    }

    public void preFill(PreFillType.Builder... builderArr) {
        Bitmap.Config config;
        a aVar = this.f17083e;
        if (aVar != null) {
            aVar.b();
        }
        PreFillType[] preFillTypeArr = new PreFillType[builderArr.length];
        for (int i4 = 0; i4 < builderArr.length; i4++) {
            PreFillType.Builder builder = builderArr[i4];
            if (builder.b() == null) {
                if (this.f17081c == DecodeFormat.PREFER_ARGB_8888) {
                    config = Bitmap.Config.ARGB_8888;
                } else {
                    config = Bitmap.Config.RGB_565;
                }
                builder.setConfig(config);
            }
            preFillTypeArr[i4] = builder.a();
        }
        a aVar2 = new a(this.f17080b, this.f17079a, a(preFillTypeArr));
        this.f17083e = aVar2;
        this.f17082d.post(aVar2);
    }
}
