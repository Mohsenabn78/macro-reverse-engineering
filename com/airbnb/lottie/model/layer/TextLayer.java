package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.content.ContentGroup;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.TextKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.DocumentData;
import com.airbnb.lottie.model.Font;
import com.airbnb.lottie.model.FontCharacter;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableTextProperties;
import com.airbnb.lottie.model.content.ShapeGroup;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class TextLayer extends BaseLayer {
    private final RectF A;
    private final Matrix B;
    private final Paint C;
    private final Paint D;
    private final Map<FontCharacter, List<ContentGroup>> E;
    private final LongSparseArray<String> F;
    private final TextKeyframeAnimation G;
    private final LottieDrawable H;
    private final LottieComposition I;
    @Nullable
    private BaseKeyframeAnimation<Integer, Integer> J;
    @Nullable
    private BaseKeyframeAnimation<Integer, Integer> K;
    @Nullable
    private BaseKeyframeAnimation<Integer, Integer> L;
    @Nullable
    private BaseKeyframeAnimation<Integer, Integer> M;
    @Nullable
    private BaseKeyframeAnimation<Float, Float> N;
    @Nullable
    private BaseKeyframeAnimation<Float, Float> O;
    @Nullable
    private BaseKeyframeAnimation<Float, Float> P;
    @Nullable
    private BaseKeyframeAnimation<Float, Float> Q;
    @Nullable
    private BaseKeyframeAnimation<Float, Float> R;
    @Nullable
    private BaseKeyframeAnimation<Float, Float> S;

    /* renamed from: z  reason: collision with root package name */
    private final StringBuilder f1777z;

    /* loaded from: classes2.dex */
    class a extends Paint {
        a(int i4) {
            super(i4);
            setStyle(Paint.Style.FILL);
        }
    }

    /* loaded from: classes2.dex */
    class b extends Paint {
        b(int i4) {
            super(i4);
            setStyle(Paint.Style.STROKE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f1780a;

        static {
            int[] iArr = new int[DocumentData.Justification.values().length];
            f1780a = iArr;
            try {
                iArr[DocumentData.Justification.LEFT_ALIGN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1780a[DocumentData.Justification.RIGHT_ALIGN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1780a[DocumentData.Justification.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TextLayer(LottieDrawable lottieDrawable, Layer layer) {
        super(lottieDrawable, layer);
        AnimatableFloatValue animatableFloatValue;
        AnimatableFloatValue animatableFloatValue2;
        AnimatableColorValue animatableColorValue;
        AnimatableColorValue animatableColorValue2;
        this.f1777z = new StringBuilder(2);
        this.A = new RectF();
        this.B = new Matrix();
        this.C = new a(1);
        this.D = new b(1);
        this.E = new HashMap();
        this.F = new LongSparseArray<>();
        this.H = lottieDrawable;
        this.I = layer.a();
        TextKeyframeAnimation createAnimation = layer.o().createAnimation();
        this.G = createAnimation;
        createAnimation.addUpdateListener(this);
        addAnimation(createAnimation);
        AnimatableTextProperties p4 = layer.p();
        if (p4 != null && (animatableColorValue2 = p4.color) != null) {
            BaseKeyframeAnimation<Integer, Integer> createAnimation2 = animatableColorValue2.createAnimation();
            this.J = createAnimation2;
            createAnimation2.addUpdateListener(this);
            addAnimation(this.J);
        }
        if (p4 != null && (animatableColorValue = p4.stroke) != null) {
            BaseKeyframeAnimation<Integer, Integer> createAnimation3 = animatableColorValue.createAnimation();
            this.L = createAnimation3;
            createAnimation3.addUpdateListener(this);
            addAnimation(this.L);
        }
        if (p4 != null && (animatableFloatValue2 = p4.strokeWidth) != null) {
            BaseKeyframeAnimation<Float, Float> createAnimation4 = animatableFloatValue2.createAnimation();
            this.N = createAnimation4;
            createAnimation4.addUpdateListener(this);
            addAnimation(this.N);
        }
        if (p4 != null && (animatableFloatValue = p4.tracking) != null) {
            BaseKeyframeAnimation<Float, Float> createAnimation5 = animatableFloatValue.createAnimation();
            this.P = createAnimation5;
            createAnimation5.addUpdateListener(this);
            addAnimation(this.P);
        }
    }

    private String A(String str, int i4) {
        int codePointAt = str.codePointAt(i4);
        int charCount = Character.charCount(codePointAt) + i4;
        while (charCount < str.length()) {
            int codePointAt2 = str.codePointAt(charCount);
            if (!M(codePointAt2)) {
                break;
            }
            charCount += Character.charCount(codePointAt2);
            codePointAt = (codePointAt * 31) + codePointAt2;
        }
        long j4 = codePointAt;
        if (this.F.containsKey(j4)) {
            return this.F.get(j4);
        }
        this.f1777z.setLength(0);
        while (i4 < charCount) {
            int codePointAt3 = str.codePointAt(i4);
            this.f1777z.appendCodePoint(codePointAt3);
            i4 += Character.charCount(codePointAt3);
        }
        String sb = this.f1777z.toString();
        this.F.put(j4, sb);
        return sb;
    }

    private void B(String str, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawText(str, 0, str.length(), 0.0f, 0.0f, paint);
    }

    private void C(FontCharacter fontCharacter, Matrix matrix, float f4, DocumentData documentData, Canvas canvas) {
        List<ContentGroup> J = J(fontCharacter);
        for (int i4 = 0; i4 < J.size(); i4++) {
            Path path = J.get(i4).getPath();
            path.computeBounds(this.A, false);
            this.B.set(matrix);
            this.B.preTranslate(0.0f, (-documentData.baselineShift) * Utils.dpScale());
            this.B.preScale(f4, f4);
            path.transform(this.B);
            if (documentData.strokeOverFill) {
                F(path, this.C, canvas);
                F(path, this.D, canvas);
            } else {
                F(path, this.D, canvas);
                F(path, this.C, canvas);
            }
        }
    }

    private void D(String str, DocumentData documentData, Canvas canvas) {
        if (documentData.strokeOverFill) {
            B(str, this.C, canvas);
            B(str, this.D, canvas);
            return;
        }
        B(str, this.D, canvas);
        B(str, this.C, canvas);
    }

    private void E(String str, DocumentData documentData, Canvas canvas, float f4) {
        int i4 = 0;
        while (i4 < str.length()) {
            String A = A(str, i4);
            i4 += A.length();
            D(A, documentData, canvas);
            canvas.translate(this.C.measureText(A) + f4, 0.0f);
        }
    }

    private void F(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawPath(path, paint);
    }

    private void G(String str, DocumentData documentData, Matrix matrix, Font font, Canvas canvas, float f4, float f5) {
        float floatValue;
        for (int i4 = 0; i4 < str.length(); i4++) {
            FontCharacter fontCharacter = this.I.getCharacters().get(FontCharacter.hashFor(str.charAt(i4), font.getFamily(), font.getStyle()));
            if (fontCharacter != null) {
                C(fontCharacter, matrix, f5, documentData, canvas);
                float width = ((float) fontCharacter.getWidth()) * f5 * Utils.dpScale() * f4;
                float f6 = documentData.tracking / 10.0f;
                BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation = this.Q;
                if (baseKeyframeAnimation != null) {
                    floatValue = baseKeyframeAnimation.getValue().floatValue();
                } else {
                    BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2 = this.P;
                    if (baseKeyframeAnimation2 != null) {
                        floatValue = baseKeyframeAnimation2.getValue().floatValue();
                    }
                    canvas.translate(width + (f6 * f4), 0.0f);
                }
                f6 += floatValue;
                canvas.translate(width + (f6 * f4), 0.0f);
            }
        }
    }

    private void H(DocumentData documentData, Matrix matrix, Font font, Canvas canvas) {
        float f4;
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation = this.S;
        if (baseKeyframeAnimation != null) {
            f4 = baseKeyframeAnimation.getValue().floatValue();
        } else {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2 = this.R;
            if (baseKeyframeAnimation2 != null) {
                f4 = baseKeyframeAnimation2.getValue().floatValue();
            } else {
                f4 = documentData.size;
            }
        }
        float f5 = f4 / 100.0f;
        float scale = Utils.getScale(matrix);
        String str = documentData.text;
        float dpScale = documentData.lineHeight * Utils.dpScale();
        List<String> L = L(str);
        int size = L.size();
        for (int i4 = 0; i4 < size; i4++) {
            String str2 = L.get(i4);
            float K = K(str2, font, f5, scale);
            canvas.save();
            z(documentData.justification, canvas, K);
            canvas.translate(0.0f, (i4 * dpScale) - (((size - 1) * dpScale) / 2.0f));
            G(str2, documentData, matrix, font, canvas, scale, f5);
            canvas.restore();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00ab A[LOOP:0: B:23:0x00a9->B:24:0x00ab, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void I(com.airbnb.lottie.model.DocumentData r7, com.airbnb.lottie.model.Font r8, android.graphics.Matrix r9, android.graphics.Canvas r10) {
        /*
            r6 = this;
            com.airbnb.lottie.utils.Utils.getScale(r9)
            com.airbnb.lottie.LottieDrawable r9 = r6.H
            java.lang.String r0 = r8.getFamily()
            java.lang.String r8 = r8.getStyle()
            android.graphics.Typeface r8 = r9.getTypeface(r0, r8)
            if (r8 != 0) goto L14
            return
        L14:
            java.lang.String r9 = r7.text
            com.airbnb.lottie.LottieDrawable r0 = r6.H
            com.airbnb.lottie.TextDelegate r0 = r0.getTextDelegate()
            if (r0 == 0) goto L22
            java.lang.String r9 = r0.getTextInternal(r9)
        L22:
            android.graphics.Paint r0 = r6.C
            r0.setTypeface(r8)
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Float, java.lang.Float> r8 = r6.S
            if (r8 == 0) goto L36
            java.lang.Object r8 = r8.getValue()
            java.lang.Float r8 = (java.lang.Float) r8
            float r8 = r8.floatValue()
            goto L47
        L36:
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Float, java.lang.Float> r8 = r6.R
            if (r8 == 0) goto L45
            java.lang.Object r8 = r8.getValue()
            java.lang.Float r8 = (java.lang.Float) r8
            float r8 = r8.floatValue()
            goto L47
        L45:
            float r8 = r7.size
        L47:
            android.graphics.Paint r0 = r6.C
            float r1 = com.airbnb.lottie.utils.Utils.dpScale()
            float r1 = r1 * r8
            r0.setTextSize(r1)
            android.graphics.Paint r0 = r6.D
            android.graphics.Paint r1 = r6.C
            android.graphics.Typeface r1 = r1.getTypeface()
            r0.setTypeface(r1)
            android.graphics.Paint r0 = r6.D
            android.graphics.Paint r1 = r6.C
            float r1 = r1.getTextSize()
            r0.setTextSize(r1)
            float r0 = r7.lineHeight
            float r1 = com.airbnb.lottie.utils.Utils.dpScale()
            float r0 = r0 * r1
            int r1 = r7.tracking
            float r1 = (float) r1
            r2 = 1092616192(0x41200000, float:10.0)
            float r1 = r1 / r2
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Float, java.lang.Float> r2 = r6.Q
            if (r2 == 0) goto L86
            java.lang.Object r2 = r2.getValue()
            java.lang.Float r2 = (java.lang.Float) r2
            float r2 = r2.floatValue()
        L84:
            float r1 = r1 + r2
            goto L95
        L86:
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation<java.lang.Float, java.lang.Float> r2 = r6.P
            if (r2 == 0) goto L95
            java.lang.Object r2 = r2.getValue()
            java.lang.Float r2 = (java.lang.Float) r2
            float r2 = r2.floatValue()
            goto L84
        L95:
            float r2 = com.airbnb.lottie.utils.Utils.dpScale()
            float r1 = r1 * r2
            float r1 = r1 * r8
            r8 = 1120403456(0x42c80000, float:100.0)
            float r1 = r1 / r8
            java.util.List r8 = r6.L(r9)
            int r9 = r8.size()
            r2 = 0
        La9:
            if (r2 >= r9) goto Le2
            java.lang.Object r3 = r8.get(r2)
            java.lang.String r3 = (java.lang.String) r3
            android.graphics.Paint r4 = r6.D
            float r4 = r4.measureText(r3)
            int r5 = r3.length()
            int r5 = r5 + (-1)
            float r5 = (float) r5
            float r5 = r5 * r1
            float r4 = r4 + r5
            r10.save()
            com.airbnb.lottie.model.DocumentData$Justification r5 = r7.justification
            r6.z(r5, r10, r4)
            int r4 = r9 + (-1)
            float r4 = (float) r4
            float r4 = r4 * r0
            r5 = 1073741824(0x40000000, float:2.0)
            float r4 = r4 / r5
            float r5 = (float) r2
            float r5 = r5 * r0
            float r5 = r5 - r4
            r4 = 0
            r10.translate(r4, r5)
            r6.E(r3, r7, r10, r1)
            r10.restore()
            int r2 = r2 + 1
            goto La9
        Le2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.model.layer.TextLayer.I(com.airbnb.lottie.model.DocumentData, com.airbnb.lottie.model.Font, android.graphics.Matrix, android.graphics.Canvas):void");
    }

    private List<ContentGroup> J(FontCharacter fontCharacter) {
        if (this.E.containsKey(fontCharacter)) {
            return this.E.get(fontCharacter);
        }
        List<ShapeGroup> shapes = fontCharacter.getShapes();
        int size = shapes.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i4 = 0; i4 < size; i4++) {
            arrayList.add(new ContentGroup(this.H, this, shapes.get(i4)));
        }
        this.E.put(fontCharacter, arrayList);
        return arrayList;
    }

    private float K(String str, Font font, float f4, float f5) {
        float f6 = 0.0f;
        for (int i4 = 0; i4 < str.length(); i4++) {
            FontCharacter fontCharacter = this.I.getCharacters().get(FontCharacter.hashFor(str.charAt(i4), font.getFamily(), font.getStyle()));
            if (fontCharacter != null) {
                f6 = (float) (f6 + (fontCharacter.getWidth() * f4 * Utils.dpScale() * f5));
            }
        }
        return f6;
    }

    private List<String> L(String str) {
        return Arrays.asList(str.replaceAll("\r\n", "\r").replaceAll("\n", "\r").split("\r"));
    }

    private boolean M(int i4) {
        if (Character.getType(i4) != 16 && Character.getType(i4) != 27 && Character.getType(i4) != 6 && Character.getType(i4) != 28 && Character.getType(i4) != 19) {
            return false;
        }
        return true;
    }

    private void z(DocumentData.Justification justification, Canvas canvas, float f4) {
        int i4 = c.f1780a[justification.ordinal()];
        if (i4 != 2) {
            if (i4 == 3) {
                canvas.translate((-f4) / 2.0f, 0.0f);
                return;
            }
            return;
        }
        canvas.translate(-f4, 0.0f);
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t3, @Nullable LottieValueCallback<T> lottieValueCallback) {
        super.addValueCallback(t3, lottieValueCallback);
        if (t3 == LottieProperty.COLOR) {
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation = this.K;
            if (baseKeyframeAnimation != null) {
                removeAnimation(baseKeyframeAnimation);
            }
            if (lottieValueCallback == null) {
                this.K = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.K = valueCallbackKeyframeAnimation;
            valueCallbackKeyframeAnimation.addUpdateListener(this);
            addAnimation(this.K);
        } else if (t3 == LottieProperty.STROKE_COLOR) {
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2 = this.M;
            if (baseKeyframeAnimation2 != null) {
                removeAnimation(baseKeyframeAnimation2);
            }
            if (lottieValueCallback == null) {
                this.M = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation2 = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.M = valueCallbackKeyframeAnimation2;
            valueCallbackKeyframeAnimation2.addUpdateListener(this);
            addAnimation(this.M);
        } else if (t3 == LottieProperty.STROKE_WIDTH) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation3 = this.O;
            if (baseKeyframeAnimation3 != null) {
                removeAnimation(baseKeyframeAnimation3);
            }
            if (lottieValueCallback == null) {
                this.O = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation3 = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.O = valueCallbackKeyframeAnimation3;
            valueCallbackKeyframeAnimation3.addUpdateListener(this);
            addAnimation(this.O);
        } else if (t3 == LottieProperty.TEXT_TRACKING) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation4 = this.Q;
            if (baseKeyframeAnimation4 != null) {
                removeAnimation(baseKeyframeAnimation4);
            }
            if (lottieValueCallback == null) {
                this.Q = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation4 = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.Q = valueCallbackKeyframeAnimation4;
            valueCallbackKeyframeAnimation4.addUpdateListener(this);
            addAnimation(this.Q);
        } else if (t3 == LottieProperty.TEXT_SIZE) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation5 = this.S;
            if (baseKeyframeAnimation5 != null) {
                removeAnimation(baseKeyframeAnimation5);
            }
            if (lottieValueCallback == null) {
                this.S = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation5 = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.S = valueCallbackKeyframeAnimation5;
            valueCallbackKeyframeAnimation5.addUpdateListener(this);
            addAnimation(this.S);
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    void drawLayer(Canvas canvas, Matrix matrix, int i4) {
        int intValue;
        canvas.save();
        if (!this.H.useTextGlyphs()) {
            canvas.concat(matrix);
        }
        DocumentData value = this.G.getValue();
        Font font = this.I.getFonts().get(value.fontName);
        if (font == null) {
            canvas.restore();
            return;
        }
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation = this.K;
        if (baseKeyframeAnimation != null) {
            this.C.setColor(baseKeyframeAnimation.getValue().intValue());
        } else {
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2 = this.J;
            if (baseKeyframeAnimation2 != null) {
                this.C.setColor(baseKeyframeAnimation2.getValue().intValue());
            } else {
                this.C.setColor(value.color);
            }
        }
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation3 = this.M;
        if (baseKeyframeAnimation3 != null) {
            this.D.setColor(baseKeyframeAnimation3.getValue().intValue());
        } else {
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation4 = this.L;
            if (baseKeyframeAnimation4 != null) {
                this.D.setColor(baseKeyframeAnimation4.getValue().intValue());
            } else {
                this.D.setColor(value.strokeColor);
            }
        }
        if (this.f1741v.getOpacity() == null) {
            intValue = 100;
        } else {
            intValue = this.f1741v.getOpacity().getValue().intValue();
        }
        int i5 = (intValue * 255) / 100;
        this.C.setAlpha(i5);
        this.D.setAlpha(i5);
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation5 = this.O;
        if (baseKeyframeAnimation5 != null) {
            this.D.setStrokeWidth(baseKeyframeAnimation5.getValue().floatValue());
        } else {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation6 = this.N;
            if (baseKeyframeAnimation6 != null) {
                this.D.setStrokeWidth(baseKeyframeAnimation6.getValue().floatValue());
            } else {
                this.D.setStrokeWidth(value.strokeWidth * Utils.dpScale() * Utils.getScale(matrix));
            }
        }
        if (this.H.useTextGlyphs()) {
            H(value, matrix, font, canvas);
        } else {
            I(value, font, matrix, canvas);
        }
        canvas.restore();
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.animation.content.DrawingContent
    public void getBounds(RectF rectF, Matrix matrix, boolean z3) {
        super.getBounds(rectF, matrix, z3);
        rectF.set(0.0f, 0.0f, this.I.getBounds().width(), this.I.getBounds().height());
    }
}
