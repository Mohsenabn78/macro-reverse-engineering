package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import com.airbnb.lottie.utils.Utils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class CompoundTrimPathContent {

    /* renamed from: a  reason: collision with root package name */
    private List<TrimPathContent> f1406a = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(TrimPathContent trimPathContent) {
        this.f1406a.add(trimPathContent);
    }

    public void apply(Path path) {
        for (int size = this.f1406a.size() - 1; size >= 0; size--) {
            Utils.applyTrimPathIfNeeded(path, this.f1406a.get(size));
        }
    }
}
