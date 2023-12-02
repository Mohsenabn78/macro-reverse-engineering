package com.arlosoft.macrodroid.utils;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

/* loaded from: classes3.dex */
public class BitmapUtils {
    private static int a(int i4) {
        return Math.round(i4 * (Resources.getSystem().getDisplayMetrics().densityDpi / 160.0f));
    }

    private static void b(Paint paint, float f4, String str) {
        paint.setTextSize(48.0f);
        Rect rect = new Rect();
        paint.getTextBounds(str, 0, str.length(), rect);
        paint.setTextSize(((f4 * 48.0f) / rect.width()) - 1.0f);
    }

    public static Bitmap textAsBitmap(String str, int i4) {
        Paint paint = new Paint(1);
        paint.setColor(i4);
        paint.setTextAlign(Paint.Align.LEFT);
        int a4 = a(24);
        int a5 = a(24);
        if (str.length() > 4) {
            str = str.substring(0, 4);
        }
        b(paint, a4, str);
        float f4 = -paint.ascent();
        Bitmap createBitmap = Bitmap.createBitmap((int) (paint.measureText(str) + 0.5f), (int) (paint.descent() + f4 + 0.5f), Bitmap.Config.ARGB_8888);
        createBitmap.eraseColor(0);
        new Canvas(createBitmap).drawText(str, (a4 - a5) / 2, f4, paint);
        return createBitmap;
    }
}
