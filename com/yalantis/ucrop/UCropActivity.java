package com.yalantis.ucrop;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import com.yalantis.ucrop.UCrop;
import com.yalantis.ucrop.callback.BitmapCropCallback;
import com.yalantis.ucrop.model.AspectRatio;
import com.yalantis.ucrop.util.SelectedStateListDrawable;
import com.yalantis.ucrop.view.GestureCropImageView;
import com.yalantis.ucrop.view.OverlayView;
import com.yalantis.ucrop.view.TransformImageView;
import com.yalantis.ucrop.view.UCropView;
import com.yalantis.ucrop.view.widget.AspectRatioTextView;
import com.yalantis.ucrop.view.widget.HorizontalProgressWheelView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes6.dex */
public class UCropActivity extends AppCompatActivity {
    public static final int ALL = 3;
    public static final Bitmap.CompressFormat DEFAULT_COMPRESS_FORMAT = Bitmap.CompressFormat.JPEG;
    public static final int DEFAULT_COMPRESS_QUALITY = 90;
    public static final int NONE = 0;
    public static final int ROTATE = 2;
    public static final int SCALE = 1;

    /* renamed from: c  reason: collision with root package name */
    private String f38367c;

    /* renamed from: d  reason: collision with root package name */
    private int f38368d;

    /* renamed from: e  reason: collision with root package name */
    private int f38369e;

    /* renamed from: f  reason: collision with root package name */
    private int f38370f;

    /* renamed from: g  reason: collision with root package name */
    private int f38371g;
    @ColorInt

    /* renamed from: h  reason: collision with root package name */
    private int f38372h;
    @DrawableRes

    /* renamed from: i  reason: collision with root package name */
    private int f38373i;
    @DrawableRes

    /* renamed from: j  reason: collision with root package name */
    private int f38374j;

    /* renamed from: k  reason: collision with root package name */
    private int f38375k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f38376l;

    /* renamed from: n  reason: collision with root package name */
    private UCropView f38378n;

    /* renamed from: o  reason: collision with root package name */
    private GestureCropImageView f38379o;

    /* renamed from: p  reason: collision with root package name */
    private OverlayView f38380p;

    /* renamed from: q  reason: collision with root package name */
    private ViewGroup f38381q;

    /* renamed from: r  reason: collision with root package name */
    private ViewGroup f38382r;

    /* renamed from: s  reason: collision with root package name */
    private ViewGroup f38383s;

    /* renamed from: t  reason: collision with root package name */
    private ViewGroup f38384t;

    /* renamed from: u  reason: collision with root package name */
    private ViewGroup f38385u;

    /* renamed from: v  reason: collision with root package name */
    private ViewGroup f38386v;

    /* renamed from: x  reason: collision with root package name */
    private TextView f38388x;

    /* renamed from: y  reason: collision with root package name */
    private TextView f38389y;

    /* renamed from: z  reason: collision with root package name */
    private View f38390z;

    /* renamed from: m  reason: collision with root package name */
    private boolean f38377m = true;

    /* renamed from: w  reason: collision with root package name */
    private List<ViewGroup> f38387w = new ArrayList();
    private Bitmap.CompressFormat A = DEFAULT_COMPRESS_FORMAT;
    private int B = 90;
    private int[] C = {1, 2, 3};
    private TransformImageView.TransformImageListener D = new a();
    private final View.OnClickListener E = new g();

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes6.dex */
    public @interface GestureTypes {
    }

    /* loaded from: classes6.dex */
    class a implements TransformImageView.TransformImageListener {
        a() {
        }

        @Override // com.yalantis.ucrop.view.TransformImageView.TransformImageListener
        public void onLoadComplete() {
            UCropActivity.this.f38378n.animate().alpha(1.0f).setDuration(300L).setInterpolator(new AccelerateInterpolator());
            UCropActivity.this.f38390z.setClickable(false);
            UCropActivity.this.f38377m = false;
            UCropActivity.this.supportInvalidateOptionsMenu();
        }

        @Override // com.yalantis.ucrop.view.TransformImageView.TransformImageListener
        public void onLoadFailure(@NonNull Exception exc) {
            UCropActivity.this.B(exc);
            UCropActivity.this.finish();
        }

        @Override // com.yalantis.ucrop.view.TransformImageView.TransformImageListener
        public void onRotate(float f4) {
            UCropActivity.this.y(f4);
        }

        @Override // com.yalantis.ucrop.view.TransformImageView.TransformImageListener
        public void onScale(float f4) {
            UCropActivity.this.D(f4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z3;
            UCropActivity.this.f38379o.setTargetAspectRatio(((AspectRatioTextView) ((ViewGroup) view).getChildAt(0)).getAspectRatio(view.isSelected()));
            UCropActivity.this.f38379o.setImageToWrapCropBounds();
            if (!view.isSelected()) {
                for (ViewGroup viewGroup : UCropActivity.this.f38387w) {
                    if (viewGroup == view) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    viewGroup.setSelected(z3);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class c implements HorizontalProgressWheelView.ScrollingListener {
        c() {
        }

        @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.ScrollingListener
        public void onScroll(float f4, float f5) {
            UCropActivity.this.f38379o.postRotate(f4 / 42.0f);
        }

        @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.ScrollingListener
        public void onScrollEnd() {
            UCropActivity.this.f38379o.setImageToWrapCropBounds();
        }

        @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.ScrollingListener
        public void onScrollStart() {
            UCropActivity.this.f38379o.cancelAllAnimations();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UCropActivity.this.v();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UCropActivity.this.w(90);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class f implements HorizontalProgressWheelView.ScrollingListener {
        f() {
        }

        @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.ScrollingListener
        public void onScroll(float f4, float f5) {
            if (f4 > 0.0f) {
                UCropActivity.this.f38379o.zoomInImage(UCropActivity.this.f38379o.getCurrentScale() + (f4 * ((UCropActivity.this.f38379o.getMaxScale() - UCropActivity.this.f38379o.getMinScale()) / 15000.0f)));
            } else {
                UCropActivity.this.f38379o.zoomOutImage(UCropActivity.this.f38379o.getCurrentScale() + (f4 * ((UCropActivity.this.f38379o.getMaxScale() - UCropActivity.this.f38379o.getMinScale()) / 15000.0f)));
            }
        }

        @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.ScrollingListener
        public void onScrollEnd() {
            UCropActivity.this.f38379o.setImageToWrapCropBounds();
        }

        @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.ScrollingListener
        public void onScrollStart() {
            UCropActivity.this.f38379o.cancelAllAnimations();
        }
    }

    /* loaded from: classes6.dex */
    class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!view.isSelected()) {
                UCropActivity.this.F(view.getId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class h implements BitmapCropCallback {
        h() {
        }

        @Override // com.yalantis.ucrop.callback.BitmapCropCallback
        public void onBitmapCropped(@NonNull Uri uri, int i4, int i5, int i6, int i7) {
            UCropActivity uCropActivity = UCropActivity.this;
            uCropActivity.C(uri, uCropActivity.f38379o.getTargetAspectRatio(), i4, i5, i6, i7);
            UCropActivity.this.finish();
        }

        @Override // com.yalantis.ucrop.callback.BitmapCropCallback
        public void onCropFailure(@NonNull Throwable th) {
            UCropActivity.this.B(th);
            UCropActivity.this.finish();
        }
    }

    private void A() {
        if (this.f38376l) {
            if (this.f38381q.getVisibility() == 0) {
                F(R.id.state_aspect_ratio);
                return;
            } else {
                F(R.id.state_scale);
                return;
            }
        }
        x(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(float f4) {
        TextView textView = this.f38389y;
        if (textView != null) {
            textView.setText(String.format(Locale.getDefault(), "%d%%", Integer.valueOf((int) (f4 * 100.0f))));
        }
    }

    @TargetApi(21)
    private void E(@ColorInt int i4) {
        Window window = getWindow();
        if (window != null) {
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(@IdRes int i4) {
        boolean z3;
        boolean z4;
        boolean z5;
        int i5;
        int i6;
        if (!this.f38376l) {
            return;
        }
        ViewGroup viewGroup = this.f38381q;
        int i7 = R.id.state_aspect_ratio;
        if (i4 == i7) {
            z3 = true;
        } else {
            z3 = false;
        }
        viewGroup.setSelected(z3);
        ViewGroup viewGroup2 = this.f38382r;
        int i8 = R.id.state_rotate;
        if (i4 == i8) {
            z4 = true;
        } else {
            z4 = false;
        }
        viewGroup2.setSelected(z4);
        ViewGroup viewGroup3 = this.f38383s;
        int i9 = R.id.state_scale;
        if (i4 == i9) {
            z5 = true;
        } else {
            z5 = false;
        }
        viewGroup3.setSelected(z5);
        ViewGroup viewGroup4 = this.f38384t;
        int i10 = 8;
        if (i4 == i7) {
            i5 = 0;
        } else {
            i5 = 8;
        }
        viewGroup4.setVisibility(i5);
        ViewGroup viewGroup5 = this.f38385u;
        if (i4 == i8) {
            i6 = 0;
        } else {
            i6 = 8;
        }
        viewGroup5.setVisibility(i6);
        ViewGroup viewGroup6 = this.f38386v;
        if (i4 == i9) {
            i10 = 0;
        }
        viewGroup6.setVisibility(i10);
        if (i4 == i9) {
            x(0);
        } else if (i4 == i8) {
            x(1);
        } else {
            x(2);
        }
    }

    private void G() {
        E(this.f38369e);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(this.f38368d);
        toolbar.setTitleTextColor(this.f38371g);
        TextView textView = (TextView) toolbar.findViewById(R.id.toolbar_title);
        textView.setTextColor(this.f38371g);
        textView.setText(this.f38367c);
        Drawable mutate = ContextCompat.getDrawable(this, this.f38373i).mutate();
        mutate.setColorFilter(this.f38371g, PorterDuff.Mode.SRC_ATOP);
        toolbar.setNavigationIcon(mutate);
        setSupportActionBar(toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayShowTitleEnabled(false);
        }
    }

    private void H(@NonNull Intent intent) {
        int intExtra = intent.getIntExtra(UCrop.Options.EXTRA_ASPECT_RATIO_SELECTED_BY_DEFAULT, 0);
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(UCrop.Options.EXTRA_ASPECT_RATIO_OPTIONS);
        if (parcelableArrayListExtra == null || parcelableArrayListExtra.isEmpty()) {
            parcelableArrayListExtra = new ArrayList();
            parcelableArrayListExtra.add(new AspectRatio(null, 1.0f, 1.0f));
            parcelableArrayListExtra.add(new AspectRatio(null, 3.0f, 4.0f));
            parcelableArrayListExtra.add(new AspectRatio(getString(R.string.ucrop_label_original).toUpperCase(), 0.0f, 0.0f));
            parcelableArrayListExtra.add(new AspectRatio(null, 3.0f, 2.0f));
            parcelableArrayListExtra.add(new AspectRatio(null, 16.0f, 9.0f));
            intExtra = 2;
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.layout_aspect_ratio);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        Iterator it = parcelableArrayListExtra.iterator();
        while (it.hasNext()) {
            FrameLayout frameLayout = (FrameLayout) getLayoutInflater().inflate(R.layout.ucrop_aspect_ratio, (ViewGroup) null);
            frameLayout.setLayoutParams(layoutParams);
            AspectRatioTextView aspectRatioTextView = (AspectRatioTextView) frameLayout.getChildAt(0);
            aspectRatioTextView.setActiveColor(this.f38370f);
            aspectRatioTextView.setAspectRatio((AspectRatio) it.next());
            linearLayout.addView(frameLayout);
            this.f38387w.add(frameLayout);
        }
        this.f38387w.get(intExtra).setSelected(true);
        for (ViewGroup viewGroup : this.f38387w) {
            viewGroup.setOnClickListener(new b());
        }
    }

    private void I() {
        this.f38388x = (TextView) findViewById(R.id.text_view_rotate);
        int i4 = R.id.rotate_scroll_wheel;
        ((HorizontalProgressWheelView) findViewById(i4)).setScrollingListener(new c());
        ((HorizontalProgressWheelView) findViewById(i4)).setMiddleLineColor(this.f38370f);
        findViewById(R.id.wrapper_reset_rotate).setOnClickListener(new d());
        findViewById(R.id.wrapper_rotate_by_angle).setOnClickListener(new e());
    }

    private void J() {
        this.f38389y = (TextView) findViewById(R.id.text_view_scale);
        int i4 = R.id.scale_scroll_wheel;
        ((HorizontalProgressWheelView) findViewById(i4)).setScrollingListener(new f());
        ((HorizontalProgressWheelView) findViewById(i4)).setMiddleLineColor(this.f38370f);
    }

    private void K() {
        ImageView imageView = (ImageView) findViewById(R.id.image_view_state_scale);
        ImageView imageView2 = (ImageView) findViewById(R.id.image_view_state_rotate);
        ImageView imageView3 = (ImageView) findViewById(R.id.image_view_state_aspect_ratio);
        imageView.setImageDrawable(new SelectedStateListDrawable(imageView.getDrawable(), this.f38370f));
        imageView2.setImageDrawable(new SelectedStateListDrawable(imageView2.getDrawable(), this.f38370f));
        imageView3.setImageDrawable(new SelectedStateListDrawable(imageView3.getDrawable(), this.f38370f));
    }

    private void L(@NonNull Intent intent) {
        this.f38369e = intent.getIntExtra(UCrop.Options.EXTRA_STATUS_BAR_COLOR, ContextCompat.getColor(this, R.color.ucrop_color_statusbar));
        this.f38368d = intent.getIntExtra(UCrop.Options.EXTRA_TOOL_BAR_COLOR, ContextCompat.getColor(this, R.color.ucrop_color_toolbar));
        this.f38370f = intent.getIntExtra(UCrop.Options.EXTRA_UCROP_COLOR_WIDGET_ACTIVE, ContextCompat.getColor(this, R.color.ucrop_color_widget_active));
        this.f38371g = intent.getIntExtra(UCrop.Options.EXTRA_UCROP_WIDGET_COLOR_TOOLBAR, ContextCompat.getColor(this, R.color.ucrop_color_toolbar_widget));
        this.f38373i = intent.getIntExtra(UCrop.Options.EXTRA_UCROP_WIDGET_CANCEL_DRAWABLE, R.drawable.ucrop_ic_cross);
        this.f38374j = intent.getIntExtra(UCrop.Options.EXTRA_UCROP_WIDGET_CROP_DRAWABLE, R.drawable.ucrop_ic_done);
        String stringExtra = intent.getStringExtra(UCrop.Options.EXTRA_UCROP_TITLE_TEXT_TOOLBAR);
        this.f38367c = stringExtra;
        if (stringExtra == null) {
            stringExtra = getResources().getString(R.string.ucrop_label_edit_photo);
        }
        this.f38367c = stringExtra;
        this.f38375k = intent.getIntExtra(UCrop.Options.EXTRA_UCROP_LOGO_COLOR, ContextCompat.getColor(this, R.color.ucrop_color_default_logo));
        this.f38376l = !intent.getBooleanExtra(UCrop.Options.EXTRA_HIDE_BOTTOM_CONTROLS, false);
        this.f38372h = intent.getIntExtra(UCrop.Options.EXTRA_UCROP_ROOT_VIEW_BACKGROUND_COLOR, ContextCompat.getColor(this, R.color.ucrop_color_crop_background));
        G();
        t();
        if (this.f38376l) {
            View.inflate(this, R.layout.ucrop_controls, (ViewGroup) findViewById(R.id.ucrop_photobox));
            ViewGroup viewGroup = (ViewGroup) findViewById(R.id.state_aspect_ratio);
            this.f38381q = viewGroup;
            viewGroup.setOnClickListener(this.E);
            ViewGroup viewGroup2 = (ViewGroup) findViewById(R.id.state_rotate);
            this.f38382r = viewGroup2;
            viewGroup2.setOnClickListener(this.E);
            ViewGroup viewGroup3 = (ViewGroup) findViewById(R.id.state_scale);
            this.f38383s = viewGroup3;
            viewGroup3.setOnClickListener(this.E);
            this.f38384t = (ViewGroup) findViewById(R.id.layout_aspect_ratio);
            this.f38385u = (ViewGroup) findViewById(R.id.layout_rotate_wheel);
            this.f38386v = (ViewGroup) findViewById(R.id.layout_scale_wheel);
            H(intent);
            I();
            J();
            K();
        }
    }

    private void r() {
        if (this.f38390z == null) {
            this.f38390z = new View(this);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(3, R.id.toolbar);
            this.f38390z.setLayoutParams(layoutParams);
            this.f38390z.setClickable(true);
        }
        ((RelativeLayout) findViewById(R.id.ucrop_photobox)).addView(this.f38390z);
    }

    private void t() {
        UCropView uCropView = (UCropView) findViewById(R.id.ucrop);
        this.f38378n = uCropView;
        this.f38379o = uCropView.getCropImageView();
        this.f38380p = this.f38378n.getOverlayView();
        this.f38379o.setTransformImageListener(this.D);
        ((ImageView) findViewById(R.id.image_view_logo)).setColorFilter(this.f38375k, PorterDuff.Mode.SRC_ATOP);
        findViewById(R.id.ucrop_frame).setBackgroundColor(this.f38372h);
    }

    private void u(@NonNull Intent intent) {
        Bitmap.CompressFormat compressFormat;
        String stringExtra = intent.getStringExtra(UCrop.Options.EXTRA_COMPRESSION_FORMAT_NAME);
        if (!TextUtils.isEmpty(stringExtra)) {
            compressFormat = Bitmap.CompressFormat.valueOf(stringExtra);
        } else {
            compressFormat = null;
        }
        if (compressFormat == null) {
            compressFormat = DEFAULT_COMPRESS_FORMAT;
        }
        this.A = compressFormat;
        this.B = intent.getIntExtra(UCrop.Options.EXTRA_COMPRESSION_QUALITY, 90);
        int[] intArrayExtra = intent.getIntArrayExtra(UCrop.Options.EXTRA_ALLOWED_GESTURES);
        if (intArrayExtra != null && intArrayExtra.length == 3) {
            this.C = intArrayExtra;
        }
        this.f38379o.setMaxBitmapSize(intent.getIntExtra(UCrop.Options.EXTRA_MAX_BITMAP_SIZE, 0));
        this.f38379o.setMaxScaleMultiplier(intent.getFloatExtra(UCrop.Options.EXTRA_MAX_SCALE_MULTIPLIER, 10.0f));
        this.f38379o.setImageToWrapCropBoundsAnimDuration(intent.getIntExtra(UCrop.Options.EXTRA_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION, 500));
        this.f38380p.setFreestyleCropEnabled(intent.getBooleanExtra(UCrop.Options.EXTRA_FREE_STYLE_CROP, false));
        this.f38380p.setDimmedColor(intent.getIntExtra(UCrop.Options.EXTRA_DIMMED_LAYER_COLOR, getResources().getColor(R.color.ucrop_color_default_dimmed)));
        this.f38380p.setCircleDimmedLayer(intent.getBooleanExtra(UCrop.Options.EXTRA_CIRCLE_DIMMED_LAYER, false));
        this.f38380p.setShowCropFrame(intent.getBooleanExtra(UCrop.Options.EXTRA_SHOW_CROP_FRAME, true));
        this.f38380p.setCropFrameColor(intent.getIntExtra(UCrop.Options.EXTRA_CROP_FRAME_COLOR, getResources().getColor(R.color.ucrop_color_default_crop_frame)));
        this.f38380p.setCropFrameStrokeWidth(intent.getIntExtra(UCrop.Options.EXTRA_CROP_FRAME_STROKE_WIDTH, getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_frame_stoke_width)));
        this.f38380p.setShowCropGrid(intent.getBooleanExtra(UCrop.Options.EXTRA_SHOW_CROP_GRID, true));
        this.f38380p.setCropGridRowCount(intent.getIntExtra(UCrop.Options.EXTRA_CROP_GRID_ROW_COUNT, 2));
        this.f38380p.setCropGridColumnCount(intent.getIntExtra(UCrop.Options.EXTRA_CROP_GRID_COLUMN_COUNT, 2));
        this.f38380p.setCropGridColor(intent.getIntExtra(UCrop.Options.EXTRA_CROP_GRID_COLOR, getResources().getColor(R.color.ucrop_color_default_crop_grid)));
        this.f38380p.setCropGridStrokeWidth(intent.getIntExtra(UCrop.Options.EXTRA_CROP_GRID_STROKE_WIDTH, getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_grid_stoke_width)));
        float floatExtra = intent.getFloatExtra(UCrop.EXTRA_ASPECT_RATIO_X, 0.0f);
        float floatExtra2 = intent.getFloatExtra(UCrop.EXTRA_ASPECT_RATIO_Y, 0.0f);
        int intExtra = intent.getIntExtra(UCrop.Options.EXTRA_ASPECT_RATIO_SELECTED_BY_DEFAULT, 0);
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(UCrop.Options.EXTRA_ASPECT_RATIO_OPTIONS);
        if (floatExtra > 0.0f && floatExtra2 > 0.0f) {
            ViewGroup viewGroup = this.f38381q;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
            }
            this.f38379o.setTargetAspectRatio(floatExtra / floatExtra2);
        } else if (parcelableArrayListExtra != null && intExtra < parcelableArrayListExtra.size()) {
            this.f38379o.setTargetAspectRatio(((AspectRatio) parcelableArrayListExtra.get(intExtra)).getAspectRatioX() / ((AspectRatio) parcelableArrayListExtra.get(intExtra)).getAspectRatioY());
        } else {
            this.f38379o.setTargetAspectRatio(0.0f);
        }
        int intExtra2 = intent.getIntExtra(UCrop.EXTRA_MAX_SIZE_X, 0);
        int intExtra3 = intent.getIntExtra(UCrop.EXTRA_MAX_SIZE_Y, 0);
        if (intExtra2 > 0 && intExtra3 > 0) {
            this.f38379o.setMaxResultImageSizeX(intExtra2);
            this.f38379o.setMaxResultImageSizeY(intExtra3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        GestureCropImageView gestureCropImageView = this.f38379o;
        gestureCropImageView.postRotate(-gestureCropImageView.getCurrentAngle());
        this.f38379o.setImageToWrapCropBounds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(int i4) {
        this.f38379o.postRotate(i4);
        this.f38379o.setImageToWrapCropBounds();
    }

    private void x(int i4) {
        boolean z3;
        GestureCropImageView gestureCropImageView = this.f38379o;
        int i5 = this.C[i4];
        boolean z4 = false;
        if (i5 != 3 && i5 != 1) {
            z3 = false;
        } else {
            z3 = true;
        }
        gestureCropImageView.setScaleEnabled(z3);
        GestureCropImageView gestureCropImageView2 = this.f38379o;
        int i6 = this.C[i4];
        gestureCropImageView2.setRotateEnabled((i6 == 3 || i6 == 2) ? true : true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(float f4) {
        TextView textView = this.f38388x;
        if (textView != null) {
            textView.setText(String.format(Locale.getDefault(), "%.1f°", Float.valueOf(f4)));
        }
    }

    private void z(@NonNull Intent intent) {
        Uri uri = (Uri) intent.getParcelableExtra(UCrop.EXTRA_INPUT_URI);
        Uri uri2 = (Uri) intent.getParcelableExtra(UCrop.EXTRA_OUTPUT_URI);
        u(intent);
        if (uri != null && uri2 != null) {
            try {
                this.f38379o.setImageUri(uri, uri2);
                return;
            } catch (Exception e4) {
                B(e4);
                finish();
                return;
            }
        }
        B(new NullPointerException(getString(R.string.ucrop_error_input_data_is_absent)));
        finish();
    }

    protected void B(Throwable th) {
        setResult(96, new Intent().putExtra(UCrop.EXTRA_ERROR, th));
    }

    protected void C(Uri uri, float f4, int i4, int i5, int i6, int i7) {
        setResult(-1, new Intent().putExtra(UCrop.EXTRA_OUTPUT_URI, uri).putExtra(UCrop.EXTRA_OUTPUT_CROP_ASPECT_RATIO, f4).putExtra(UCrop.EXTRA_OUTPUT_IMAGE_WIDTH, i6).putExtra(UCrop.EXTRA_OUTPUT_IMAGE_HEIGHT, i7).putExtra(UCrop.EXTRA_OUTPUT_OFFSET_X, i4).putExtra(UCrop.EXTRA_OUTPUT_OFFSET_Y, i5));
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.ucrop_activity_photobox);
        Intent intent = getIntent();
        L(intent);
        z(intent);
        A();
        r();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.ucrop_menu_activity, menu);
        MenuItem findItem = menu.findItem(R.id.menu_loader);
        Drawable icon = findItem.getIcon();
        if (icon != null) {
            try {
                icon.mutate();
                icon.setColorFilter(this.f38371g, PorterDuff.Mode.SRC_ATOP);
                findItem.setIcon(icon);
            } catch (IllegalStateException e4) {
                Log.i("UCropActivity", String.format("%s - %s", e4.getMessage(), getString(R.string.ucrop_mutate_exception_hint)));
            }
            ((Animatable) findItem.getIcon()).start();
        }
        MenuItem findItem2 = menu.findItem(R.id.menu_crop);
        Drawable drawable = ContextCompat.getDrawable(this, this.f38374j);
        if (drawable != null) {
            drawable.mutate();
            drawable.setColorFilter(this.f38371g, PorterDuff.Mode.SRC_ATOP);
            findItem2.setIcon(drawable);
        }
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.menu_crop) {
            s();
        } else if (menuItem.getItemId() == 16908332) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.menu_crop).setVisible(!this.f38377m);
        menu.findItem(R.id.menu_loader).setVisible(this.f38377m);
        return super.onPrepareOptionsMenu(menu);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        GestureCropImageView gestureCropImageView = this.f38379o;
        if (gestureCropImageView != null) {
            gestureCropImageView.cancelAllAnimations();
        }
    }

    protected void s() {
        this.f38390z.setClickable(true);
        this.f38377m = true;
        supportInvalidateOptionsMenu();
        this.f38379o.cropAndSaveImage(this.A, this.B, new h());
    }
}
