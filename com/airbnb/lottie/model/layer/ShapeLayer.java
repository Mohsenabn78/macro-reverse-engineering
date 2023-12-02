package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.ContentGroup;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.ShapeGroup;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public class ShapeLayer extends BaseLayer {

    /* renamed from: z  reason: collision with root package name */
    private final ContentGroup f1775z;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShapeLayer(LottieDrawable lottieDrawable, Layer layer) {
        super(lottieDrawable, layer);
        ContentGroup contentGroup = new ContentGroup(lottieDrawable, this, new ShapeGroup("__container", layer.j(), false));
        this.f1775z = contentGroup;
        contentGroup.setContents(Collections.emptyList(), Collections.emptyList());
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    void drawLayer(@NonNull Canvas canvas, Matrix matrix, int i4) {
        this.f1775z.draw(canvas, matrix, i4);
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.animation.content.DrawingContent
    public void getBounds(RectF rectF, Matrix matrix, boolean z3) {
        super.getBounds(rectF, matrix, z3);
        this.f1775z.getBounds(rectF, this.f1732m, z3);
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    protected void u(KeyPath keyPath, int i4, List<KeyPath> list, KeyPath keyPath2) {
        this.f1775z.resolveKeyPath(keyPath, i4, list, keyPath2);
    }
}
