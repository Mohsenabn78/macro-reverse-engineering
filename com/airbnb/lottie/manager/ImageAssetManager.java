package com.airbnb.lottie.manager;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import androidx.annotation.Nullable;
import com.airbnb.lottie.ImageAssetDelegate;
import com.airbnb.lottie.LottieImageAsset;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class ImageAssetManager {

    /* renamed from: e  reason: collision with root package name */
    private static final Object f1582e = new Object();

    /* renamed from: a  reason: collision with root package name */
    private final Context f1583a;

    /* renamed from: b  reason: collision with root package name */
    private final String f1584b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private ImageAssetDelegate f1585c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, LottieImageAsset> f1586d;

    public ImageAssetManager(Drawable.Callback callback, String str, ImageAssetDelegate imageAssetDelegate, Map<String, LottieImageAsset> map) {
        if (!TextUtils.isEmpty(str) && str.charAt(str.length() - 1) != '/') {
            this.f1584b = str + '/';
        } else {
            this.f1584b = str;
        }
        if (!(callback instanceof View)) {
            Logger.warning("LottieDrawable must be inside of a view for images to work.");
            this.f1586d = new HashMap();
            this.f1583a = null;
            return;
        }
        this.f1583a = ((View) callback).getContext();
        this.f1586d = map;
        setDelegate(imageAssetDelegate);
    }

    private Bitmap a(String str, @Nullable Bitmap bitmap) {
        synchronized (f1582e) {
            this.f1586d.get(str).setBitmap(bitmap);
        }
        return bitmap;
    }

    @Nullable
    public Bitmap bitmapForId(String str) {
        LottieImageAsset lottieImageAsset = this.f1586d.get(str);
        if (lottieImageAsset == null) {
            return null;
        }
        Bitmap bitmap = lottieImageAsset.getBitmap();
        if (bitmap != null) {
            return bitmap;
        }
        ImageAssetDelegate imageAssetDelegate = this.f1585c;
        if (imageAssetDelegate != null) {
            Bitmap fetchBitmap = imageAssetDelegate.fetchBitmap(lottieImageAsset);
            if (fetchBitmap != null) {
                a(str, fetchBitmap);
            }
            return fetchBitmap;
        }
        String fileName = lottieImageAsset.getFileName();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = true;
        options.inDensity = 160;
        if (fileName.startsWith("data:") && fileName.indexOf("base64,") > 0) {
            try {
                byte[] decode = Base64.decode(fileName.substring(fileName.indexOf(44) + 1), 0);
                return a(str, BitmapFactory.decodeByteArray(decode, 0, decode.length, options));
            } catch (IllegalArgumentException e4) {
                Logger.warning("data URL did not have correct base64 format.", e4);
                return null;
            }
        }
        try {
            if (!TextUtils.isEmpty(this.f1584b)) {
                AssetManager assets = this.f1583a.getAssets();
                try {
                    return a(str, Utils.resizeBitmapIfNeeded(BitmapFactory.decodeStream(assets.open(this.f1584b + fileName), null, options), lottieImageAsset.getWidth(), lottieImageAsset.getHeight()));
                } catch (IllegalArgumentException e5) {
                    Logger.warning("Unable to decode image.", e5);
                    return null;
                }
            }
            throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
        } catch (IOException e6) {
            Logger.warning("Unable to open asset.", e6);
            return null;
        }
    }

    public boolean hasSameContext(Context context) {
        if ((context == null && this.f1583a == null) || this.f1583a.equals(context)) {
            return true;
        }
        return false;
    }

    public void setDelegate(@Nullable ImageAssetDelegate imageAssetDelegate) {
        this.f1585c = imageAssetDelegate;
    }

    @Nullable
    public Bitmap updateBitmap(String str, @Nullable Bitmap bitmap) {
        if (bitmap == null) {
            LottieImageAsset lottieImageAsset = this.f1586d.get(str);
            Bitmap bitmap2 = lottieImageAsset.getBitmap();
            lottieImageAsset.setBitmap(null);
            return bitmap2;
        }
        Bitmap bitmap3 = this.f1586d.get(str).getBitmap();
        a(str, bitmap);
        return bitmap3;
    }

    public ImageAssetManager(Context context, String str, ImageAssetDelegate imageAssetDelegate, Map<String, LottieImageAsset> map) {
        this.f1583a = context;
        if (!TextUtils.isEmpty(str) && str.charAt(str.length() - 1) != '/') {
            this.f1584b = str + '/';
        } else {
            this.f1584b = str;
        }
        this.f1586d = map;
        setDelegate(imageAssetDelegate);
    }
}
