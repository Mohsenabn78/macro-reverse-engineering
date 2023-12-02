package com.koushikdutta.ion.loader;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import com.koushikdutta.async.future.Future;
import com.koushikdutta.async.future.SimpleFuture;
import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.ResponseServedFrom;
import com.koushikdutta.ion.bitmap.BitmapInfo;
import java.net.URI;

/* loaded from: classes6.dex */
public class PackageIconLoader extends SimpleLoader {

    /* loaded from: classes6.dex */
    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f36046a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Ion f36047b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f36048c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ SimpleFuture f36049d;

        a(String str, Ion ion, String str2, SimpleFuture simpleFuture) {
            this.f36046a = str;
            this.f36047b = ion;
            this.f36048c = str2;
            this.f36049d = simpleFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                String host = URI.create(this.f36046a).getHost();
                PackageManager packageManager = this.f36047b.getContext().getPackageManager();
                Bitmap bitmap = ((BitmapDrawable) packageManager.getPackageInfo(host, 0).applicationInfo.loadIcon(packageManager)).getBitmap();
                if (bitmap != null) {
                    BitmapInfo bitmapInfo = new BitmapInfo(this.f36048c, null, bitmap, new Point(bitmap.getWidth(), bitmap.getHeight()));
                    bitmapInfo.servedFrom = ResponseServedFrom.LOADED_FROM_CACHE;
                    this.f36049d.setComplete((SimpleFuture) bitmapInfo);
                    return;
                }
                throw new Exception("package icon failed to load");
            } catch (Exception e4) {
                this.f36049d.setComplete(e4);
            }
        }
    }

    @Override // com.koushikdutta.ion.loader.SimpleLoader, com.koushikdutta.ion.Loader
    public Future<BitmapInfo> loadBitmap(Context context, Ion ion, String str, String str2, int i4, int i5, boolean z3) {
        if (str2 != null && str2.startsWith("package:")) {
            SimpleFuture simpleFuture = new SimpleFuture();
            Ion.getBitmapLoadExecutorService().execute(new a(str2, ion, str, simpleFuture));
            return simpleFuture;
        }
        return null;
    }
}
