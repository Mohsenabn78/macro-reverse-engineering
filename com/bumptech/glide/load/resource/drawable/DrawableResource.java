package com.bumptech.glide.load.resource.drawable;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.util.Preconditions;

/* loaded from: classes3.dex */
public abstract class DrawableResource<T extends Drawable> implements Resource<T>, Initializable {

    /* renamed from: a  reason: collision with root package name */
    protected final T f17286a;

    public DrawableResource(T t3) {
        this.f17286a = (T) Preconditions.checkNotNull(t3);
    }

    public void initialize() {
        T t3 = this.f17286a;
        if (t3 instanceof BitmapDrawable) {
            ((BitmapDrawable) t3).getBitmap().prepareToDraw();
        } else if (t3 instanceof GifDrawable) {
            ((GifDrawable) t3).getFirstFrame().prepareToDraw();
        }
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @NonNull
    public final T get() {
        Drawable.ConstantState constantState = this.f17286a.getConstantState();
        if (constantState == null) {
            return this.f17286a;
        }
        return (T) constantState.newDrawable();
    }
}
