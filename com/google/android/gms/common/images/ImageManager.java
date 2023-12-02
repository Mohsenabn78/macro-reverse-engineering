package com.google.android.gms.common.images;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Constants;
import com.google.android.gms.internal.base.zam;
import com.google.android.gms.internal.base.zat;
import com.google.android.gms.internal.base.zau;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
public final class ImageManager {

    /* renamed from: h  reason: collision with root package name */
    private static final Object f20388h = new Object();

    /* renamed from: i  reason: collision with root package name */
    private static final HashSet f20389i = new HashSet();

    /* renamed from: j  reason: collision with root package name */
    private static ImageManager f20390j;

    /* renamed from: a  reason: collision with root package name */
    private final Context f20391a;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f20392b = new zau(Looper.getMainLooper());

    /* renamed from: c  reason: collision with root package name */
    private final ExecutorService f20393c = zat.zaa().zab(4, 2);

    /* renamed from: d  reason: collision with root package name */
    private final zam f20394d = new zam();

    /* renamed from: e  reason: collision with root package name */
    private final Map f20395e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    private final Map f20396f = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    private final Map f20397g = new HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
    @KeepName
    /* loaded from: classes4.dex */
    public final class ImageReceiver extends ResultReceiver {

        /* renamed from: a  reason: collision with root package name */
        private final Uri f20398a;

        /* renamed from: b  reason: collision with root package name */
        private final ArrayList f20399b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public ImageReceiver(Uri uri) {
            super(new zau(Looper.getMainLooper()));
            this.f20398a = uri;
            this.f20399b = new ArrayList();
        }

        public final void b(zag zagVar) {
            Asserts.checkMainThread("ImageReceiver.addImageRequest() must be called in the main thread");
            this.f20399b.add(zagVar);
        }

        public final void c(zag zagVar) {
            Asserts.checkMainThread("ImageReceiver.removeImageRequest() must be called in the main thread");
            this.f20399b.remove(zagVar);
        }

        public final void d() {
            Intent intent = new Intent(Constants.ACTION_LOAD_IMAGE);
            intent.setPackage("com.google.android.gms");
            intent.putExtra(Constants.EXTRA_URI, this.f20398a);
            intent.putExtra(Constants.EXTRA_RESULT_RECEIVER, this);
            intent.putExtra(Constants.EXTRA_PRIORITY, 3);
            ImageManager.this.f20391a.sendBroadcast(intent);
        }

        @Override // android.os.ResultReceiver
        public final void onReceiveResult(int i4, Bundle bundle) {
            ImageManager imageManager = ImageManager.this;
            imageManager.f20393c.execute(new zaa(imageManager, this.f20398a, (ParcelFileDescriptor) bundle.getParcelable("com.google.android.gms.extra.fileDescriptor")));
        }
    }

    /* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
    /* loaded from: classes4.dex */
    public interface OnImageLoadedListener {
        void onImageLoaded(@NonNull Uri uri, @Nullable Drawable drawable, boolean z3);
    }

    private ImageManager(Context context, boolean z3) {
        this.f20391a = context.getApplicationContext();
    }

    @NonNull
    public static ImageManager create(@NonNull Context context) {
        if (f20390j == null) {
            f20390j = new ImageManager(context, false);
        }
        return f20390j;
    }

    public void loadImage(@NonNull ImageView imageView, int i4) {
        zaj(new zae(imageView, i4));
    }

    public final void zaj(zag zagVar) {
        Asserts.checkMainThread("ImageManager.loadImage() must be called in the main thread");
        new zab(this, zagVar).run();
    }

    public void loadImage(@NonNull ImageView imageView, @NonNull Uri uri) {
        zaj(new zae(imageView, uri));
    }

    public void loadImage(@NonNull ImageView imageView, @NonNull Uri uri, int i4) {
        zae zaeVar = new zae(imageView, uri);
        zaeVar.f20420b = i4;
        zaj(zaeVar);
    }

    public void loadImage(@NonNull OnImageLoadedListener onImageLoadedListener, @NonNull Uri uri) {
        zaj(new zaf(onImageLoadedListener, uri));
    }

    public void loadImage(@NonNull OnImageLoadedListener onImageLoadedListener, @NonNull Uri uri, int i4) {
        zaf zafVar = new zaf(onImageLoadedListener, uri);
        zafVar.f20420b = i4;
        zaj(zafVar);
    }
}
