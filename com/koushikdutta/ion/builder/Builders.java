package com.koushikdutta.ion.builder;

import android.graphics.Bitmap;
import com.koushikdutta.ion.bitmap.BitmapInfo;

/* loaded from: classes6.dex */
public interface Builders {

    /* loaded from: classes6.dex */
    public interface Any {

        /* loaded from: classes6.dex */
        public interface B extends RequestBuilder<F, B, M, U>, F {
        }

        /* loaded from: classes6.dex */
        public interface BF<A extends BF<?>> extends BitmapBuilder<A>, BitmapFutureBuilder, IF<A> {
        }

        /* loaded from: classes6.dex */
        public interface F extends FutureBuilder, ImageViewFutureBuilder {
        }

        /* loaded from: classes6.dex */
        public interface IF<A extends IF<?>> extends ImageViewBuilder<A>, ImageViewFutureBuilder {
        }

        /* loaded from: classes6.dex */
        public interface M extends MultipartBodyBuilder<M>, F {
        }

        /* loaded from: classes6.dex */
        public interface U extends UrlEncodedBuilder<U>, F {
        }
    }

    /* loaded from: classes6.dex */
    public interface IV {

        /* loaded from: classes6.dex */
        public interface F<A extends F<?>> extends ImageViewBuilder<A>, BitmapBuilder<A>, LoadImageViewFutureBuilder {
            Bitmap getBitmap();

            BitmapInfo getBitmapInfo();
        }
    }
}
