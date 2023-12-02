package com.bumptech.glide.request.target;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Preconditions;

/* loaded from: classes3.dex */
public class AppWidgetTarget extends SimpleTarget<Bitmap> {

    /* renamed from: d  reason: collision with root package name */
    private final int[] f17477d;

    /* renamed from: e  reason: collision with root package name */
    private final ComponentName f17478e;

    /* renamed from: f  reason: collision with root package name */
    private final RemoteViews f17479f;

    /* renamed from: g  reason: collision with root package name */
    private final Context f17480g;

    /* renamed from: h  reason: collision with root package name */
    private final int f17481h;

    public AppWidgetTarget(Context context, int i4, int i5, int i6, RemoteViews remoteViews, int... iArr) {
        super(i4, i5);
        if (iArr.length != 0) {
            this.f17480g = (Context) Preconditions.checkNotNull(context, "Context can not be null!");
            this.f17479f = (RemoteViews) Preconditions.checkNotNull(remoteViews, "RemoteViews object can not be null!");
            this.f17477d = (int[]) Preconditions.checkNotNull(iArr, "WidgetIds can not be null!");
            this.f17481h = i6;
            this.f17478e = null;
            return;
        }
        throw new IllegalArgumentException("WidgetIds must have length > 0");
    }

    private void a() {
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this.f17480g);
        ComponentName componentName = this.f17478e;
        if (componentName != null) {
            appWidgetManager.updateAppWidget(componentName, this.f17479f);
        } else {
            appWidgetManager.updateAppWidget(this.f17477d, this.f17479f);
        }
    }

    @Override // com.bumptech.glide.request.target.Target
    public /* bridge */ /* synthetic */ void onResourceReady(@NonNull Object obj, @Nullable Transition transition) {
        onResourceReady((Bitmap) obj, (Transition<? super Bitmap>) transition);
    }

    public void onResourceReady(@NonNull Bitmap bitmap, @Nullable Transition<? super Bitmap> transition) {
        this.f17479f.setImageViewBitmap(this.f17481h, bitmap);
        a();
    }

    public AppWidgetTarget(Context context, int i4, RemoteViews remoteViews, int... iArr) {
        this(context, Integer.MIN_VALUE, Integer.MIN_VALUE, i4, remoteViews, iArr);
    }

    public AppWidgetTarget(Context context, int i4, int i5, int i6, RemoteViews remoteViews, ComponentName componentName) {
        super(i4, i5);
        this.f17480g = (Context) Preconditions.checkNotNull(context, "Context can not be null!");
        this.f17479f = (RemoteViews) Preconditions.checkNotNull(remoteViews, "RemoteViews object can not be null!");
        this.f17478e = (ComponentName) Preconditions.checkNotNull(componentName, "ComponentName can not be null!");
        this.f17481h = i6;
        this.f17477d = null;
    }

    public AppWidgetTarget(Context context, int i4, RemoteViews remoteViews, ComponentName componentName) {
        this(context, Integer.MIN_VALUE, Integer.MIN_VALUE, i4, remoteViews, componentName);
    }
}
