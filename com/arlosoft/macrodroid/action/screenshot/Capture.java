package com.arlosoft.macrodroid.action.screenshot;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.hardware.display.VirtualDisplay;
import android.media.Image;
import android.media.ImageReader;
import android.media.projection.MediaProjection;
import android.util.DisplayMetrics;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Capture.kt */
@StabilityInferred(parameters = 0)
@SuppressLint({"NewApi"})
/* loaded from: classes2.dex */
public final class Capture implements ImageReader.OnImageAvailableListener {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Context f4854a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private VirtualDisplay f4855b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private Function1<? super Bitmap, Unit> f4856c;

    public Capture(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f4854a = context;
    }

    private final Bitmap a(ImageReader imageReader) {
        Image acquireLatestImage = imageReader.acquireLatestImage();
        DisplayMetrics displayMetrics = this.f4854a.getResources().getDisplayMetrics();
        Image.Plane plane = acquireLatestImage.getPlanes()[0];
        Bitmap createBitmap = Bitmap.createBitmap(plane.getRowStride() / plane.getPixelStride(), displayMetrics.heightPixels, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(\n          … Bitmap.Config.ARGB_8888)");
        createBitmap.copyPixelsFromBuffer(plane.getBuffer());
        acquireLatestImage.close();
        return createBitmap;
    }

    private final VirtualDisplay b(MediaProjection mediaProjection) {
        DisplayMetrics displayMetrics = this.f4854a.getResources().getDisplayMetrics();
        ImageReader newInstance = ImageReader.newInstance(displayMetrics.widthPixels, displayMetrics.heightPixels, 1, 2);
        Intrinsics.checkNotNullExpressionValue(newInstance, "newInstance(\n           …mat.RGBA_8888, maxImages)");
        newInstance.setOnImageAvailableListener(this, null);
        VirtualDisplay createVirtualDisplay = mediaProjection.createVirtualDisplay("Capture Display", displayMetrics.widthPixels, displayMetrics.heightPixels, displayMetrics.densityDpi, 16, newInstance.getSurface(), null, null);
        Intrinsics.checkNotNullExpressionValue(createVirtualDisplay, "mediaProjection.createVi…ader.surface, null, null)");
        return createVirtualDisplay;
    }

    @NotNull
    public final Context getContext() {
        return this.f4854a;
    }

    @Override // android.media.ImageReader.OnImageAvailableListener
    public void onImageAvailable(@NotNull ImageReader reader) {
        Function1<? super Bitmap, Unit> function1;
        Intrinsics.checkNotNullParameter(reader, "reader");
        if (this.f4855b != null && (function1 = this.f4856c) != null) {
            function1.invoke(a(reader));
        }
    }

    public final void run(@NotNull MediaProjection mediaProjection, @NotNull Function1<? super Bitmap, Unit> onCaptureListener) {
        Intrinsics.checkNotNullParameter(mediaProjection, "mediaProjection");
        Intrinsics.checkNotNullParameter(onCaptureListener, "onCaptureListener");
        this.f4856c = onCaptureListener;
        if (this.f4855b == null) {
            this.f4855b = b(mediaProjection);
        }
    }

    public final void stop() {
        VirtualDisplay virtualDisplay = this.f4855b;
        if (virtualDisplay != null) {
            virtualDisplay.release();
        }
        this.f4855b = null;
        this.f4856c = null;
    }
}
