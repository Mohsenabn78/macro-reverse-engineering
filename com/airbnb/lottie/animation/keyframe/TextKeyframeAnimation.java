package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.model.DocumentData;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

/* loaded from: classes2.dex */
public class TextKeyframeAnimation extends a<DocumentData> {
    public TextKeyframeAnimation(List<Keyframe<DocumentData>> list) {
        super(list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    /* renamed from: h */
    public DocumentData getValue(Keyframe<DocumentData> keyframe, float f4) {
        DocumentData documentData;
        if (f4 == 1.0f && (documentData = keyframe.endValue) != null) {
            return documentData;
        }
        return keyframe.startValue;
    }
}
