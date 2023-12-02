package com.miguelbcr.ui.rx_paparazzo2.interactors;

import android.util.DisplayMetrics;
import com.miguelbcr.ui.rx_paparazzo2.entities.Config;
import com.miguelbcr.ui.rx_paparazzo2.entities.FileData;
import com.miguelbcr.ui.rx_paparazzo2.entities.TargetUi;
import com.miguelbcr.ui.rx_paparazzo2.entities.size.CustomMaxSize;
import com.miguelbcr.ui.rx_paparazzo2.entities.size.OriginalSize;
import com.miguelbcr.ui.rx_paparazzo2.entities.size.ScreenSize;
import io.reactivex.Observable;
import java.io.File;

/* loaded from: classes6.dex */
public final class ScaledImageDimensions extends a<Dimensions> {

    /* renamed from: a  reason: collision with root package name */
    private final TargetUi f36237a;

    /* renamed from: b  reason: collision with root package name */
    private final Config f36238b;

    /* renamed from: c  reason: collision with root package name */
    private FileData f36239c;

    public ScaledImageDimensions(TargetUi targetUi, Config config) {
        this.f36237a = targetUi;
        this.f36238b = config;
    }

    private Dimensions a(CustomMaxSize customMaxSize, File file) {
        int maxImageSize = customMaxSize.getMaxImageSize();
        Dimensions imageDimensions = ImageUtils.getImageDimensions(file);
        int max = Math.max(imageDimensions.getWidth(), imageDimensions.getHeight());
        if (max < maxImageSize) {
            return imageDimensions;
        }
        float f4 = maxImageSize / max;
        return new Dimensions((int) (imageDimensions.getWidth() * f4), (int) (imageDimensions.getHeight() * f4));
    }

    private Dimensions b() {
        File file = this.f36239c.getFile();
        if (this.f36238b.getSize() instanceof OriginalSize) {
            return ImageUtils.getImageDimensions(file);
        }
        if (this.f36238b.getSize() instanceof CustomMaxSize) {
            return a((CustomMaxSize) this.f36238b.getSize(), file);
        }
        if (this.f36238b.getSize() instanceof ScreenSize) {
            return c();
        }
        Dimensions c4 = c();
        return new Dimensions(c4.getWidth() / 8, c4.getHeight() / 8);
    }

    private Dimensions c() {
        DisplayMetrics displayMetrics = this.f36237a.getContext().getResources().getDisplayMetrics();
        return new Dimensions(displayMetrics.widthPixels, displayMetrics.heightPixels);
    }

    public Observable<Dimensions> react() {
        return Observable.just(b());
    }

    public ScaledImageDimensions with(FileData fileData) {
        this.f36239c = fileData;
        return this;
    }
}
