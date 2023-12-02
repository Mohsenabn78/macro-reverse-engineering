package com.koushikdutta.ion;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.koushikdutta.ion.bitmap.Transform;

/* compiled from: DefaultTransform.java */
/* loaded from: classes6.dex */
class f implements Transform {

    /* renamed from: d  reason: collision with root package name */
    static final Paint f35832d = new Paint(2);

    /* renamed from: a  reason: collision with root package name */
    final p f35833a;

    /* renamed from: b  reason: collision with root package name */
    final int f35834b;

    /* renamed from: c  reason: collision with root package name */
    final int f35835c;

    public f(int i4, int i5, p pVar) {
        this.f35834b = i4;
        this.f35835c = i5;
        if (pVar == null) {
            this.f35833a = p.FitXY;
        } else {
            this.f35833a = pVar;
        }
    }

    @Override // com.koushikdutta.ion.bitmap.Transform
    public String key() {
        return this.f35833a.name() + this.f35834b + "x" + this.f35835c;
    }

    @Override // com.koushikdutta.ion.bitmap.Transform
    public Bitmap transform(Bitmap bitmap) {
        float min;
        Bitmap.Config config = bitmap.getConfig();
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        int i4 = this.f35834b;
        int i5 = this.f35835c;
        if (i4 <= 0) {
            i4 = (int) ((bitmap.getWidth() / bitmap.getHeight()) * i5);
        } else if (i5 <= 0) {
            i5 = (int) ((bitmap.getHeight() / bitmap.getWidth()) * i4);
        }
        float f4 = i4;
        float f5 = i5;
        RectF rectF = new RectF(0.0f, 0.0f, f4, f5);
        p pVar = this.f35833a;
        p pVar2 = p.CenterInside;
        if (pVar == pVar2 && (i4 <= bitmap.getWidth() || i5 <= bitmap.getHeight())) {
            pVar = p.FitCenter;
        }
        if (pVar == pVar2) {
            float width = (i4 - bitmap.getWidth()) / 2.0f;
            float height = (i5 - bitmap.getHeight()) / 2.0f;
            rectF.set(width, height, bitmap.getWidth() + width, bitmap.getHeight() + height);
        } else if (pVar != p.FitXY) {
            float width2 = f4 / bitmap.getWidth();
            float height2 = f5 / bitmap.getHeight();
            if (pVar == p.CenterCrop) {
                min = Math.max(width2, height2);
            } else {
                min = Math.min(width2, height2);
            }
            if (min == 0.0f) {
                return bitmap;
            }
            float height3 = bitmap.getHeight() * min;
            float width3 = (f4 - (bitmap.getWidth() * min)) / 2.0f;
            float f6 = (f5 - height3) / 2.0f;
            rectF.set(width3, f6, f4 - width3, f5 - f6);
        }
        if (rectF.width() == bitmap.getWidth() && rectF.height() == bitmap.getHeight() && rectF.top == 0.0f && rectF.left == 0.0f) {
            return bitmap;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i4, i5, config);
        new Canvas(createBitmap).drawBitmap(bitmap, (Rect) null, rectF, f35832d);
        return createBitmap;
    }
}
