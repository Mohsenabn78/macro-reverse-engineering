package com.yalantis.ucrop;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
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
public class UCropFragment extends Fragment {
    public static final int ALL = 3;
    public static final Bitmap.CompressFormat DEFAULT_COMPRESS_FORMAT = Bitmap.CompressFormat.JPEG;
    public static final int DEFAULT_COMPRESS_QUALITY = 90;
    public static final int NONE = 0;
    public static final int ROTATE = 2;
    public static final int SCALE = 1;
    public static final String TAG = "UCropFragment";

    /* renamed from: b  reason: collision with root package name */
    private UCropFragmentCallback f38399b;

    /* renamed from: c  reason: collision with root package name */
    private int f38400c;
    @ColorInt

    /* renamed from: d  reason: collision with root package name */
    private int f38401d;

    /* renamed from: e  reason: collision with root package name */
    private int f38402e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f38403f;

    /* renamed from: g  reason: collision with root package name */
    private UCropView f38404g;

    /* renamed from: h  reason: collision with root package name */
    private GestureCropImageView f38405h;

    /* renamed from: i  reason: collision with root package name */
    private OverlayView f38406i;

    /* renamed from: j  reason: collision with root package name */
    private ViewGroup f38407j;

    /* renamed from: k  reason: collision with root package name */
    private ViewGroup f38408k;

    /* renamed from: l  reason: collision with root package name */
    private ViewGroup f38409l;

    /* renamed from: m  reason: collision with root package name */
    private ViewGroup f38410m;

    /* renamed from: n  reason: collision with root package name */
    private ViewGroup f38411n;

    /* renamed from: o  reason: collision with root package name */
    private ViewGroup f38412o;

    /* renamed from: q  reason: collision with root package name */
    private TextView f38414q;

    /* renamed from: r  reason: collision with root package name */
    private TextView f38415r;

    /* renamed from: s  reason: collision with root package name */
    private View f38416s;

    /* renamed from: p  reason: collision with root package name */
    private List<ViewGroup> f38413p = new ArrayList();

    /* renamed from: t  reason: collision with root package name */
    private Bitmap.CompressFormat f38417t = DEFAULT_COMPRESS_FORMAT;

    /* renamed from: u  reason: collision with root package name */
    private int f38418u = 90;

    /* renamed from: v  reason: collision with root package name */
    private int[] f38419v = {1, 2, 3};

    /* renamed from: w  reason: collision with root package name */
    private TransformImageView.TransformImageListener f38420w = new a();

    /* renamed from: x  reason: collision with root package name */
    private final View.OnClickListener f38421x = new g();

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes6.dex */
    public @interface GestureTypes {
    }

    /* loaded from: classes6.dex */
    public class UCropResult {
        public int mResultCode;
        public Intent mResultData;

        public UCropResult(int i4, Intent intent) {
            this.mResultCode = i4;
            this.mResultData = intent;
        }
    }

    /* loaded from: classes6.dex */
    class a implements TransformImageView.TransformImageListener {
        a() {
        }

        @Override // com.yalantis.ucrop.view.TransformImageView.TransformImageListener
        public void onLoadComplete() {
            UCropFragment.this.f38404g.animate().alpha(1.0f).setDuration(300L).setInterpolator(new AccelerateInterpolator());
            UCropFragment.this.f38416s.setClickable(false);
            UCropFragment.this.f38399b.loadingProgress(false);
        }

        @Override // com.yalantis.ucrop.view.TransformImageView.TransformImageListener
        public void onLoadFailure(@NonNull Exception exc) {
            UCropFragment.this.f38399b.onCropFinish(UCropFragment.this.m(exc));
        }

        @Override // com.yalantis.ucrop.view.TransformImageView.TransformImageListener
        public void onRotate(float f4) {
            UCropFragment.this.t(f4);
        }

        @Override // com.yalantis.ucrop.view.TransformImageView.TransformImageListener
        public void onScale(float f4) {
            UCropFragment.this.w(f4);
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
            UCropFragment.this.f38405h.setTargetAspectRatio(((AspectRatioTextView) ((ViewGroup) view).getChildAt(0)).getAspectRatio(view.isSelected()));
            UCropFragment.this.f38405h.setImageToWrapCropBounds();
            if (!view.isSelected()) {
                for (ViewGroup viewGroup : UCropFragment.this.f38413p) {
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
            UCropFragment.this.f38405h.postRotate(f4 / 42.0f);
        }

        @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.ScrollingListener
        public void onScrollEnd() {
            UCropFragment.this.f38405h.setImageToWrapCropBounds();
        }

        @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.ScrollingListener
        public void onScrollStart() {
            UCropFragment.this.f38405h.cancelAllAnimations();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UCropFragment.this.q();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UCropFragment.this.r(90);
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
                UCropFragment.this.f38405h.zoomInImage(UCropFragment.this.f38405h.getCurrentScale() + (f4 * ((UCropFragment.this.f38405h.getMaxScale() - UCropFragment.this.f38405h.getMinScale()) / 15000.0f)));
            } else {
                UCropFragment.this.f38405h.zoomOutImage(UCropFragment.this.f38405h.getCurrentScale() + (f4 * ((UCropFragment.this.f38405h.getMaxScale() - UCropFragment.this.f38405h.getMinScale()) / 15000.0f)));
            }
        }

        @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.ScrollingListener
        public void onScrollEnd() {
            UCropFragment.this.f38405h.setImageToWrapCropBounds();
        }

        @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.ScrollingListener
        public void onScrollStart() {
            UCropFragment.this.f38405h.cancelAllAnimations();
        }
    }

    /* loaded from: classes6.dex */
    class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!view.isSelected()) {
                UCropFragment.this.x(view.getId());
            }
        }
    }

    /* loaded from: classes6.dex */
    class h implements BitmapCropCallback {
        h() {
        }

        @Override // com.yalantis.ucrop.callback.BitmapCropCallback
        public void onBitmapCropped(@NonNull Uri uri, int i4, int i5, int i6, int i7) {
            UCropFragmentCallback uCropFragmentCallback = UCropFragment.this.f38399b;
            UCropFragment uCropFragment = UCropFragment.this;
            uCropFragmentCallback.onCropFinish(uCropFragment.n(uri, uCropFragment.f38405h.getTargetAspectRatio(), i4, i5, i6, i7));
            UCropFragment.this.f38399b.loadingProgress(false);
        }

        @Override // com.yalantis.ucrop.callback.BitmapCropCallback
        public void onCropFailure(@NonNull Throwable th) {
            UCropFragment.this.f38399b.onCropFinish(UCropFragment.this.m(th));
        }
    }

    private void A(View view) {
        this.f38415r = (TextView) view.findViewById(R.id.text_view_scale);
        int i4 = R.id.scale_scroll_wheel;
        ((HorizontalProgressWheelView) view.findViewById(i4)).setScrollingListener(new f());
        ((HorizontalProgressWheelView) view.findViewById(i4)).setMiddleLineColor(this.f38400c);
    }

    private void B(View view) {
        ImageView imageView = (ImageView) view.findViewById(R.id.image_view_state_scale);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.image_view_state_rotate);
        ImageView imageView3 = (ImageView) view.findViewById(R.id.image_view_state_aspect_ratio);
        imageView.setImageDrawable(new SelectedStateListDrawable(imageView.getDrawable(), this.f38400c));
        imageView2.setImageDrawable(new SelectedStateListDrawable(imageView2.getDrawable(), this.f38400c));
        imageView3.setImageDrawable(new SelectedStateListDrawable(imageView3.getDrawable(), this.f38400c));
    }

    private void l(View view) {
        if (this.f38416s == null) {
            this.f38416s = new View(getContext());
            this.f38416s.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            this.f38416s.setClickable(true);
        }
        ((RelativeLayout) view.findViewById(R.id.ucrop_photobox)).addView(this.f38416s);
    }

    public static UCropFragment newInstance(Bundle bundle) {
        UCropFragment uCropFragment = new UCropFragment();
        uCropFragment.setArguments(bundle);
        return uCropFragment;
    }

    private void o(View view) {
        UCropView uCropView = (UCropView) view.findViewById(R.id.ucrop);
        this.f38404g = uCropView;
        this.f38405h = uCropView.getCropImageView();
        this.f38406i = this.f38404g.getOverlayView();
        this.f38405h.setTransformImageListener(this.f38420w);
        ((ImageView) view.findViewById(R.id.image_view_logo)).setColorFilter(this.f38402e, PorterDuff.Mode.SRC_ATOP);
        view.findViewById(R.id.ucrop_frame).setBackgroundColor(this.f38401d);
    }

    private void p(@NonNull Bundle bundle) {
        Bitmap.CompressFormat compressFormat;
        String string = bundle.getString(UCrop.Options.EXTRA_COMPRESSION_FORMAT_NAME);
        if (!TextUtils.isEmpty(string)) {
            compressFormat = Bitmap.CompressFormat.valueOf(string);
        } else {
            compressFormat = null;
        }
        if (compressFormat == null) {
            compressFormat = DEFAULT_COMPRESS_FORMAT;
        }
        this.f38417t = compressFormat;
        this.f38418u = bundle.getInt(UCrop.Options.EXTRA_COMPRESSION_QUALITY, 90);
        int[] intArray = bundle.getIntArray(UCrop.Options.EXTRA_ALLOWED_GESTURES);
        if (intArray != null && intArray.length == 3) {
            this.f38419v = intArray;
        }
        this.f38405h.setMaxBitmapSize(bundle.getInt(UCrop.Options.EXTRA_MAX_BITMAP_SIZE, 0));
        this.f38405h.setMaxScaleMultiplier(bundle.getFloat(UCrop.Options.EXTRA_MAX_SCALE_MULTIPLIER, 10.0f));
        this.f38405h.setImageToWrapCropBoundsAnimDuration(bundle.getInt(UCrop.Options.EXTRA_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION, 500));
        this.f38406i.setFreestyleCropEnabled(bundle.getBoolean(UCrop.Options.EXTRA_FREE_STYLE_CROP, false));
        this.f38406i.setDimmedColor(bundle.getInt(UCrop.Options.EXTRA_DIMMED_LAYER_COLOR, getResources().getColor(R.color.ucrop_color_default_dimmed)));
        this.f38406i.setCircleDimmedLayer(bundle.getBoolean(UCrop.Options.EXTRA_CIRCLE_DIMMED_LAYER, false));
        this.f38406i.setShowCropFrame(bundle.getBoolean(UCrop.Options.EXTRA_SHOW_CROP_FRAME, true));
        this.f38406i.setCropFrameColor(bundle.getInt(UCrop.Options.EXTRA_CROP_FRAME_COLOR, getResources().getColor(R.color.ucrop_color_default_crop_frame)));
        this.f38406i.setCropFrameStrokeWidth(bundle.getInt(UCrop.Options.EXTRA_CROP_FRAME_STROKE_WIDTH, getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_frame_stoke_width)));
        this.f38406i.setShowCropGrid(bundle.getBoolean(UCrop.Options.EXTRA_SHOW_CROP_GRID, true));
        this.f38406i.setCropGridRowCount(bundle.getInt(UCrop.Options.EXTRA_CROP_GRID_ROW_COUNT, 2));
        this.f38406i.setCropGridColumnCount(bundle.getInt(UCrop.Options.EXTRA_CROP_GRID_COLUMN_COUNT, 2));
        this.f38406i.setCropGridColor(bundle.getInt(UCrop.Options.EXTRA_CROP_GRID_COLOR, getResources().getColor(R.color.ucrop_color_default_crop_grid)));
        this.f38406i.setCropGridStrokeWidth(bundle.getInt(UCrop.Options.EXTRA_CROP_GRID_STROKE_WIDTH, getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_grid_stoke_width)));
        float f4 = bundle.getFloat(UCrop.EXTRA_ASPECT_RATIO_X, 0.0f);
        float f5 = bundle.getFloat(UCrop.EXTRA_ASPECT_RATIO_Y, 0.0f);
        int i4 = bundle.getInt(UCrop.Options.EXTRA_ASPECT_RATIO_SELECTED_BY_DEFAULT, 0);
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(UCrop.Options.EXTRA_ASPECT_RATIO_OPTIONS);
        if (f4 > 0.0f && f5 > 0.0f) {
            ViewGroup viewGroup = this.f38407j;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
            }
            this.f38405h.setTargetAspectRatio(f4 / f5);
        } else if (parcelableArrayList != null && i4 < parcelableArrayList.size()) {
            this.f38405h.setTargetAspectRatio(((AspectRatio) parcelableArrayList.get(i4)).getAspectRatioX() / ((AspectRatio) parcelableArrayList.get(i4)).getAspectRatioY());
        } else {
            this.f38405h.setTargetAspectRatio(0.0f);
        }
        int i5 = bundle.getInt(UCrop.EXTRA_MAX_SIZE_X, 0);
        int i6 = bundle.getInt(UCrop.EXTRA_MAX_SIZE_Y, 0);
        if (i5 > 0 && i6 > 0) {
            this.f38405h.setMaxResultImageSizeX(i5);
            this.f38405h.setMaxResultImageSizeY(i6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        GestureCropImageView gestureCropImageView = this.f38405h;
        gestureCropImageView.postRotate(-gestureCropImageView.getCurrentAngle());
        this.f38405h.setImageToWrapCropBounds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(int i4) {
        this.f38405h.postRotate(i4);
        this.f38405h.setImageToWrapCropBounds();
    }

    private void s(int i4) {
        boolean z3;
        GestureCropImageView gestureCropImageView = this.f38405h;
        int i5 = this.f38419v[i4];
        boolean z4 = false;
        if (i5 != 3 && i5 != 1) {
            z3 = false;
        } else {
            z3 = true;
        }
        gestureCropImageView.setScaleEnabled(z3);
        GestureCropImageView gestureCropImageView2 = this.f38405h;
        int i6 = this.f38419v[i4];
        gestureCropImageView2.setRotateEnabled((i6 == 3 || i6 == 2) ? true : true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(float f4) {
        TextView textView = this.f38414q;
        if (textView != null) {
            textView.setText(String.format(Locale.getDefault(), "%.1f°", Float.valueOf(f4)));
        }
    }

    private void u(@NonNull Bundle bundle) {
        Uri uri = (Uri) bundle.getParcelable(UCrop.EXTRA_INPUT_URI);
        Uri uri2 = (Uri) bundle.getParcelable(UCrop.EXTRA_OUTPUT_URI);
        p(bundle);
        if (uri != null && uri2 != null) {
            try {
                this.f38405h.setImageUri(uri, uri2);
                return;
            } catch (Exception e4) {
                this.f38399b.onCropFinish(m(e4));
                return;
            }
        }
        this.f38399b.onCropFinish(m(new NullPointerException(getString(R.string.ucrop_error_input_data_is_absent))));
    }

    private void v() {
        if (this.f38403f) {
            if (this.f38407j.getVisibility() == 0) {
                x(R.id.state_aspect_ratio);
                return;
            } else {
                x(R.id.state_scale);
                return;
            }
        }
        s(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(float f4) {
        TextView textView = this.f38415r;
        if (textView != null) {
            textView.setText(String.format(Locale.getDefault(), "%d%%", Integer.valueOf((int) (f4 * 100.0f))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(@IdRes int i4) {
        boolean z3;
        boolean z4;
        boolean z5;
        int i5;
        int i6;
        if (!this.f38403f) {
            return;
        }
        ViewGroup viewGroup = this.f38407j;
        int i7 = R.id.state_aspect_ratio;
        if (i4 == i7) {
            z3 = true;
        } else {
            z3 = false;
        }
        viewGroup.setSelected(z3);
        ViewGroup viewGroup2 = this.f38408k;
        int i8 = R.id.state_rotate;
        if (i4 == i8) {
            z4 = true;
        } else {
            z4 = false;
        }
        viewGroup2.setSelected(z4);
        ViewGroup viewGroup3 = this.f38409l;
        int i9 = R.id.state_scale;
        if (i4 == i9) {
            z5 = true;
        } else {
            z5 = false;
        }
        viewGroup3.setSelected(z5);
        ViewGroup viewGroup4 = this.f38410m;
        int i10 = 8;
        if (i4 == i7) {
            i5 = 0;
        } else {
            i5 = 8;
        }
        viewGroup4.setVisibility(i5);
        ViewGroup viewGroup5 = this.f38411n;
        if (i4 == i8) {
            i6 = 0;
        } else {
            i6 = 8;
        }
        viewGroup5.setVisibility(i6);
        ViewGroup viewGroup6 = this.f38412o;
        if (i4 == i9) {
            i10 = 0;
        }
        viewGroup6.setVisibility(i10);
        if (i4 == i9) {
            s(0);
        } else if (i4 == i8) {
            s(1);
        } else {
            s(2);
        }
    }

    private void y(@NonNull Bundle bundle, View view) {
        int i4 = bundle.getInt(UCrop.Options.EXTRA_ASPECT_RATIO_SELECTED_BY_DEFAULT, 0);
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(UCrop.Options.EXTRA_ASPECT_RATIO_OPTIONS);
        if (parcelableArrayList == null || parcelableArrayList.isEmpty()) {
            parcelableArrayList = new ArrayList();
            parcelableArrayList.add(new AspectRatio(null, 1.0f, 1.0f));
            parcelableArrayList.add(new AspectRatio(null, 3.0f, 4.0f));
            parcelableArrayList.add(new AspectRatio(getString(R.string.ucrop_label_original).toUpperCase(), 0.0f, 0.0f));
            parcelableArrayList.add(new AspectRatio(null, 3.0f, 2.0f));
            parcelableArrayList.add(new AspectRatio(null, 16.0f, 9.0f));
            i4 = 2;
        }
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.layout_aspect_ratio);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        Iterator it = parcelableArrayList.iterator();
        while (it.hasNext()) {
            FrameLayout frameLayout = (FrameLayout) getLayoutInflater().inflate(R.layout.ucrop_aspect_ratio, (ViewGroup) null);
            frameLayout.setLayoutParams(layoutParams);
            AspectRatioTextView aspectRatioTextView = (AspectRatioTextView) frameLayout.getChildAt(0);
            aspectRatioTextView.setActiveColor(this.f38400c);
            aspectRatioTextView.setAspectRatio((AspectRatio) it.next());
            linearLayout.addView(frameLayout);
            this.f38413p.add(frameLayout);
        }
        this.f38413p.get(i4).setSelected(true);
        for (ViewGroup viewGroup : this.f38413p) {
            viewGroup.setOnClickListener(new b());
        }
    }

    private void z(View view) {
        this.f38414q = (TextView) view.findViewById(R.id.text_view_rotate);
        int i4 = R.id.rotate_scroll_wheel;
        ((HorizontalProgressWheelView) view.findViewById(i4)).setScrollingListener(new c());
        ((HorizontalProgressWheelView) view.findViewById(i4)).setMiddleLineColor(this.f38400c);
        view.findViewById(R.id.wrapper_reset_rotate).setOnClickListener(new d());
        view.findViewById(R.id.wrapper_rotate_by_angle).setOnClickListener(new e());
    }

    public void cropAndSaveImage() {
        this.f38416s.setClickable(true);
        this.f38399b.loadingProgress(true);
        this.f38405h.cropAndSaveImage(this.f38417t, this.f38418u, new h());
    }

    protected UCropResult m(Throwable th) {
        return new UCropResult(96, new Intent().putExtra(UCrop.EXTRA_ERROR, th));
    }

    protected UCropResult n(Uri uri, float f4, int i4, int i5, int i6, int i7) {
        return new UCropResult(-1, new Intent().putExtra(UCrop.EXTRA_OUTPUT_URI, uri).putExtra(UCrop.EXTRA_OUTPUT_CROP_ASPECT_RATIO, f4).putExtra(UCrop.EXTRA_OUTPUT_IMAGE_WIDTH, i6).putExtra(UCrop.EXTRA_OUTPUT_IMAGE_HEIGHT, i7).putExtra(UCrop.EXTRA_OUTPUT_OFFSET_X, i4).putExtra(UCrop.EXTRA_OUTPUT_OFFSET_Y, i5));
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            this.f38399b = (UCropFragmentCallback) context;
        } catch (ClassCastException unused) {
            throw new ClassCastException(context.toString() + " must implement UCropFragmentCallback");
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.ucrop_fragment_photobox, viewGroup, false);
        Bundle arguments = getArguments();
        setupViews(inflate, arguments);
        u(arguments);
        v();
        l(inflate);
        return inflate;
    }

    public void setCallback(UCropFragmentCallback uCropFragmentCallback) {
        this.f38399b = uCropFragmentCallback;
    }

    public void setupViews(View view, Bundle bundle) {
        this.f38400c = bundle.getInt(UCrop.Options.EXTRA_UCROP_COLOR_WIDGET_ACTIVE, ContextCompat.getColor(getContext(), R.color.ucrop_color_widget_active));
        this.f38402e = bundle.getInt(UCrop.Options.EXTRA_UCROP_LOGO_COLOR, ContextCompat.getColor(getContext(), R.color.ucrop_color_default_logo));
        this.f38403f = !bundle.getBoolean(UCrop.Options.EXTRA_HIDE_BOTTOM_CONTROLS, false);
        this.f38401d = bundle.getInt(UCrop.Options.EXTRA_UCROP_ROOT_VIEW_BACKGROUND_COLOR, ContextCompat.getColor(getContext(), R.color.ucrop_color_crop_background));
        o(view);
        this.f38399b.loadingProgress(true);
        if (this.f38403f) {
            View.inflate(getContext(), R.layout.ucrop_controls, (ViewGroup) view.findViewById(R.id.ucrop_photobox));
            ViewGroup viewGroup = (ViewGroup) view.findViewById(R.id.state_aspect_ratio);
            this.f38407j = viewGroup;
            viewGroup.setOnClickListener(this.f38421x);
            ViewGroup viewGroup2 = (ViewGroup) view.findViewById(R.id.state_rotate);
            this.f38408k = viewGroup2;
            viewGroup2.setOnClickListener(this.f38421x);
            ViewGroup viewGroup3 = (ViewGroup) view.findViewById(R.id.state_scale);
            this.f38409l = viewGroup3;
            viewGroup3.setOnClickListener(this.f38421x);
            this.f38410m = (ViewGroup) view.findViewById(R.id.layout_aspect_ratio);
            this.f38411n = (ViewGroup) view.findViewById(R.id.layout_rotate_wheel);
            this.f38412o = (ViewGroup) view.findViewById(R.id.layout_scale_wheel);
            y(bundle, view);
            z(view);
            A(view);
            B(view);
        }
    }
}
