package com.arlosoft.macrodroid.drawer.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.MotionEventCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.arlosoft.macrodroid.BuildConfig;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.drawer.model.DrawerItem;
import com.arlosoft.macrodroid.events.CloseDrawerEvent;
import com.arlosoft.macrodroid.events.EventBusUtils;
import com.arlosoft.macrodroid.utils.FileUtils;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes3.dex */
public abstract class DrawerItemViewHolder extends RecyclerView.ViewHolder {
    @ColorInt

    /* renamed from: a  reason: collision with root package name */
    private int f11481a;

    /* renamed from: b  reason: collision with root package name */
    private Set<ImageView> f11482b;

    /* renamed from: c  reason: collision with root package name */
    private DrawItemListener f11483c;

    /* renamed from: d  reason: collision with root package name */
    private DrawerItem f11484d;

    public DrawerItemViewHolder(View view, DrawItemListener drawItemListener) {
        super(view);
        this.f11482b = new HashSet();
        this.f11483c = drawItemListener;
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean g(View view) {
        DrawItemListener drawItemListener = this.f11483c;
        if (drawItemListener != null) {
            drawItemListener.onLongPress(this);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean h(View view, MotionEvent motionEvent) {
        DrawItemListener drawItemListener;
        if (MotionEventCompat.getActionMasked(motionEvent) == 0 && (drawItemListener = this.f11483c) != null) {
            drawItemListener.onStartDrag(this);
            return false;
        }
        return false;
    }

    protected void c() {
        this.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.arlosoft.macrodroid.drawer.ui.b
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean g4;
                g4 = DrawerItemViewHolder.this.g(view);
                return g4;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d() {
        EventBusUtils.getEventBus().post(new CloseDrawerEvent());
    }

    @Nullable
    protected ImageView[] e() {
        return new ImageView[0];
    }

    @Nullable
    protected TextView[] f() {
        return new TextView[0];
    }

    public Context getContext() {
        return this.itemView.getContext();
    }

    public DrawerItem getDrawerItem() {
        return this.f11484d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(ImageView imageView) {
        j(imageView);
        imageView.setOnTouchListener(new View.OnTouchListener() { // from class: com.arlosoft.macrodroid.drawer.ui.a
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean h4;
                h4 = DrawerItemViewHolder.this.h(view, motionEvent);
                return h4;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(@NonNull ImageView imageView) {
        DrawableCompat.setTintList(DrawableCompat.wrap(imageView.getDrawable()).mutate(), new ColorStateList(new int[][]{new int[0]}, new int[]{this.f11481a}));
    }

    @CallSuper
    public void onBind(@NonNull DrawerItem drawerItem, boolean z3) {
        this.f11484d = drawerItem;
    }

    public void setColor(@ColorInt int i4) {
        ImageView[] e4;
        this.f11481a = i4;
        for (ImageView imageView : e()) {
            if (!this.f11482b.contains(imageView)) {
                j(imageView);
            }
        }
        for (TextView textView : f()) {
            textView.setTextColor(i4);
        }
    }

    public void setIcon(ImageView imageView, DrawerItem drawerItem, int i4) {
        if (drawerItem.getImagePackageName() != null && !drawerItem.getImagePackageName().equals(BuildConfig.APPLICATION_ID)) {
            this.f11482b.add(imageView);
        } else {
            this.f11482b.remove(imageView);
        }
        if (drawerItem.getImagePackageName() != null && drawerItem.getImagePackageName().equals(Constants.USER_ICON_OPTION_PACKAGE)) {
            Bitmap decodeBitmapFromUserIconFile = FileUtils.decodeBitmapFromUserIconFile(drawerItem.getImageResourceName());
            if (decodeBitmapFromUserIconFile != null) {
                imageView.setImageBitmap(decodeBitmapFromUserIconFile);
                return;
            }
            this.f11482b.remove(imageView);
            imageView.setImageResource(i4);
            return;
        }
        Drawable drawableFromPackageWithName = Util.getDrawableFromPackageWithName(this.itemView.getContext(), drawerItem.getImagePackageName(), drawerItem.getImageResourceName());
        if (drawableFromPackageWithName != null) {
            imageView.setImageDrawable(drawableFromPackageWithName);
        } else {
            imageView.setImageResource(i4);
        }
    }

    public void setNonTintImageViews(ImageView imageView) {
        this.f11482b.add(imageView);
    }

    public void refresh() {
    }

    public void unbind() {
    }
}
