package com.yalantis.ucrop;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.yalantis.ucrop.model.AspectRatio;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

/* loaded from: classes6.dex */
public class UCrop {
    public static final String EXTRA_ASPECT_RATIO_X = "com.yalantis.ucrop.AspectRatioX";
    public static final String EXTRA_ASPECT_RATIO_Y = "com.yalantis.ucrop.AspectRatioY";
    public static final String EXTRA_ERROR = "com.yalantis.ucrop.Error";
    public static final String EXTRA_INPUT_URI = "com.yalantis.ucrop.InputUri";
    public static final String EXTRA_MAX_SIZE_X = "com.yalantis.ucrop.MaxSizeX";
    public static final String EXTRA_MAX_SIZE_Y = "com.yalantis.ucrop.MaxSizeY";
    public static final String EXTRA_OUTPUT_CROP_ASPECT_RATIO = "com.yalantis.ucrop.CropAspectRatio";
    public static final String EXTRA_OUTPUT_IMAGE_HEIGHT = "com.yalantis.ucrop.ImageHeight";
    public static final String EXTRA_OUTPUT_IMAGE_WIDTH = "com.yalantis.ucrop.ImageWidth";
    public static final String EXTRA_OUTPUT_OFFSET_X = "com.yalantis.ucrop.OffsetX";
    public static final String EXTRA_OUTPUT_OFFSET_Y = "com.yalantis.ucrop.OffsetY";
    public static final String EXTRA_OUTPUT_URI = "com.yalantis.ucrop.OutputUri";
    public static final int MIN_SIZE = 10;
    public static final int REQUEST_CROP = 69;
    public static final int RESULT_ERROR = 96;

    /* renamed from: a  reason: collision with root package name */
    private Intent f38364a = new Intent();

    /* renamed from: b  reason: collision with root package name */
    private Bundle f38365b;

    /* loaded from: classes6.dex */
    public static class Options {
        public static final String EXTRA_ALLOWED_GESTURES = "com.yalantis.ucrop.AllowedGestures";
        public static final String EXTRA_ASPECT_RATIO_OPTIONS = "com.yalantis.ucrop.AspectRatioOptions";
        public static final String EXTRA_ASPECT_RATIO_SELECTED_BY_DEFAULT = "com.yalantis.ucrop.AspectRatioSelectedByDefault";
        public static final String EXTRA_CIRCLE_DIMMED_LAYER = "com.yalantis.ucrop.CircleDimmedLayer";
        public static final String EXTRA_COMPRESSION_FORMAT_NAME = "com.yalantis.ucrop.CompressionFormatName";
        public static final String EXTRA_COMPRESSION_QUALITY = "com.yalantis.ucrop.CompressionQuality";
        public static final String EXTRA_CROP_FRAME_COLOR = "com.yalantis.ucrop.CropFrameColor";
        public static final String EXTRA_CROP_FRAME_STROKE_WIDTH = "com.yalantis.ucrop.CropFrameStrokeWidth";
        public static final String EXTRA_CROP_GRID_COLOR = "com.yalantis.ucrop.CropGridColor";
        public static final String EXTRA_CROP_GRID_COLUMN_COUNT = "com.yalantis.ucrop.CropGridColumnCount";
        public static final String EXTRA_CROP_GRID_ROW_COUNT = "com.yalantis.ucrop.CropGridRowCount";
        public static final String EXTRA_CROP_GRID_STROKE_WIDTH = "com.yalantis.ucrop.CropGridStrokeWidth";
        public static final String EXTRA_DIMMED_LAYER_COLOR = "com.yalantis.ucrop.DimmedLayerColor";
        public static final String EXTRA_FREE_STYLE_CROP = "com.yalantis.ucrop.FreeStyleCrop";
        public static final String EXTRA_HIDE_BOTTOM_CONTROLS = "com.yalantis.ucrop.HideBottomControls";
        public static final String EXTRA_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION = "com.yalantis.ucrop.ImageToCropBoundsAnimDuration";
        public static final String EXTRA_MAX_BITMAP_SIZE = "com.yalantis.ucrop.MaxBitmapSize";
        public static final String EXTRA_MAX_SCALE_MULTIPLIER = "com.yalantis.ucrop.MaxScaleMultiplier";
        public static final String EXTRA_SHOW_CROP_FRAME = "com.yalantis.ucrop.ShowCropFrame";
        public static final String EXTRA_SHOW_CROP_GRID = "com.yalantis.ucrop.ShowCropGrid";
        public static final String EXTRA_STATUS_BAR_COLOR = "com.yalantis.ucrop.StatusBarColor";
        public static final String EXTRA_TOOL_BAR_COLOR = "com.yalantis.ucrop.ToolbarColor";
        public static final String EXTRA_UCROP_COLOR_WIDGET_ACTIVE = "com.yalantis.ucrop.UcropColorWidgetActive";
        public static final String EXTRA_UCROP_LOGO_COLOR = "com.yalantis.ucrop.UcropLogoColor";
        public static final String EXTRA_UCROP_ROOT_VIEW_BACKGROUND_COLOR = "com.yalantis.ucrop.UcropRootViewBackgroundColor";
        public static final String EXTRA_UCROP_TITLE_TEXT_TOOLBAR = "com.yalantis.ucrop.UcropToolbarTitleText";
        public static final String EXTRA_UCROP_WIDGET_CANCEL_DRAWABLE = "com.yalantis.ucrop.UcropToolbarCancelDrawable";
        public static final String EXTRA_UCROP_WIDGET_COLOR_TOOLBAR = "com.yalantis.ucrop.UcropToolbarWidgetColor";
        public static final String EXTRA_UCROP_WIDGET_CROP_DRAWABLE = "com.yalantis.ucrop.UcropToolbarCropDrawable";

        /* renamed from: a  reason: collision with root package name */
        private final Bundle f38366a = new Bundle();

        @NonNull
        public Bundle getOptionBundle() {
            return this.f38366a;
        }

        public void setActiveWidgetColor(@ColorInt int i4) {
            this.f38366a.putInt(EXTRA_UCROP_COLOR_WIDGET_ACTIVE, i4);
        }

        public void setAllowedGestures(int i4, int i5, int i6) {
            this.f38366a.putIntArray(EXTRA_ALLOWED_GESTURES, new int[]{i4, i5, i6});
        }

        public void setAspectRatioOptions(int i4, AspectRatio... aspectRatioArr) {
            if (i4 <= aspectRatioArr.length) {
                this.f38366a.putInt(EXTRA_ASPECT_RATIO_SELECTED_BY_DEFAULT, i4);
                this.f38366a.putParcelableArrayList(EXTRA_ASPECT_RATIO_OPTIONS, new ArrayList<>(Arrays.asList(aspectRatioArr)));
                return;
            }
            throw new IllegalArgumentException(String.format(Locale.US, "Index [selectedByDefault = %d] cannot be higher than aspect ratio options count [count = %d].", Integer.valueOf(i4), Integer.valueOf(aspectRatioArr.length)));
        }

        public void setCircleDimmedLayer(boolean z3) {
            this.f38366a.putBoolean(EXTRA_CIRCLE_DIMMED_LAYER, z3);
        }

        public void setCompressionFormat(@NonNull Bitmap.CompressFormat compressFormat) {
            this.f38366a.putString(EXTRA_COMPRESSION_FORMAT_NAME, compressFormat.name());
        }

        public void setCompressionQuality(@IntRange(from = 0) int i4) {
            this.f38366a.putInt(EXTRA_COMPRESSION_QUALITY, i4);
        }

        public void setCropFrameColor(@ColorInt int i4) {
            this.f38366a.putInt(EXTRA_CROP_FRAME_COLOR, i4);
        }

        public void setCropFrameStrokeWidth(@IntRange(from = 0) int i4) {
            this.f38366a.putInt(EXTRA_CROP_FRAME_STROKE_WIDTH, i4);
        }

        public void setCropGridColor(@ColorInt int i4) {
            this.f38366a.putInt(EXTRA_CROP_GRID_COLOR, i4);
        }

        public void setCropGridColumnCount(@IntRange(from = 0) int i4) {
            this.f38366a.putInt(EXTRA_CROP_GRID_COLUMN_COUNT, i4);
        }

        public void setCropGridRowCount(@IntRange(from = 0) int i4) {
            this.f38366a.putInt(EXTRA_CROP_GRID_ROW_COUNT, i4);
        }

        public void setCropGridStrokeWidth(@IntRange(from = 0) int i4) {
            this.f38366a.putInt(EXTRA_CROP_GRID_STROKE_WIDTH, i4);
        }

        public void setDimmedLayerColor(@ColorInt int i4) {
            this.f38366a.putInt(EXTRA_DIMMED_LAYER_COLOR, i4);
        }

        public void setFreeStyleCropEnabled(boolean z3) {
            this.f38366a.putBoolean(EXTRA_FREE_STYLE_CROP, z3);
        }

        public void setHideBottomControls(boolean z3) {
            this.f38366a.putBoolean(EXTRA_HIDE_BOTTOM_CONTROLS, z3);
        }

        public void setImageToCropBoundsAnimDuration(@IntRange(from = 10) int i4) {
            this.f38366a.putInt(EXTRA_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION, i4);
        }

        public void setLogoColor(@ColorInt int i4) {
            this.f38366a.putInt(EXTRA_UCROP_LOGO_COLOR, i4);
        }

        public void setMaxBitmapSize(@IntRange(from = 10) int i4) {
            this.f38366a.putInt(EXTRA_MAX_BITMAP_SIZE, i4);
        }

        public void setMaxScaleMultiplier(@FloatRange(from = 1.0d, fromInclusive = false) float f4) {
            this.f38366a.putFloat(EXTRA_MAX_SCALE_MULTIPLIER, f4);
        }

        public void setRootViewBackgroundColor(@ColorInt int i4) {
            this.f38366a.putInt(EXTRA_UCROP_ROOT_VIEW_BACKGROUND_COLOR, i4);
        }

        public void setShowCropFrame(boolean z3) {
            this.f38366a.putBoolean(EXTRA_SHOW_CROP_FRAME, z3);
        }

        public void setShowCropGrid(boolean z3) {
            this.f38366a.putBoolean(EXTRA_SHOW_CROP_GRID, z3);
        }

        public void setStatusBarColor(@ColorInt int i4) {
            this.f38366a.putInt(EXTRA_STATUS_BAR_COLOR, i4);
        }

        public void setToolbarCancelDrawable(@DrawableRes int i4) {
            this.f38366a.putInt(EXTRA_UCROP_WIDGET_CANCEL_DRAWABLE, i4);
        }

        public void setToolbarColor(@ColorInt int i4) {
            this.f38366a.putInt(EXTRA_TOOL_BAR_COLOR, i4);
        }

        public void setToolbarCropDrawable(@DrawableRes int i4) {
            this.f38366a.putInt(EXTRA_UCROP_WIDGET_CROP_DRAWABLE, i4);
        }

        public void setToolbarTitle(@Nullable String str) {
            this.f38366a.putString(EXTRA_UCROP_TITLE_TEXT_TOOLBAR, str);
        }

        public void setToolbarWidgetColor(@ColorInt int i4) {
            this.f38366a.putInt(EXTRA_UCROP_WIDGET_COLOR_TOOLBAR, i4);
        }

        public void useSourceImageAspectRatio() {
            this.f38366a.putFloat(UCrop.EXTRA_ASPECT_RATIO_X, 0.0f);
            this.f38366a.putFloat(UCrop.EXTRA_ASPECT_RATIO_Y, 0.0f);
        }

        public void withAspectRatio(float f4, float f5) {
            this.f38366a.putFloat(UCrop.EXTRA_ASPECT_RATIO_X, f4);
            this.f38366a.putFloat(UCrop.EXTRA_ASPECT_RATIO_Y, f5);
        }

        public void withMaxResultSize(@IntRange(from = 10) int i4, @IntRange(from = 10) int i5) {
            this.f38366a.putInt(UCrop.EXTRA_MAX_SIZE_X, i4);
            this.f38366a.putInt(UCrop.EXTRA_MAX_SIZE_Y, i5);
        }
    }

    private UCrop(@NonNull Uri uri, @NonNull Uri uri2) {
        Bundle bundle = new Bundle();
        this.f38365b = bundle;
        bundle.putParcelable(EXTRA_INPUT_URI, uri);
        this.f38365b.putParcelable(EXTRA_OUTPUT_URI, uri2);
    }

    @Nullable
    public static Throwable getError(@NonNull Intent intent) {
        return (Throwable) intent.getSerializableExtra(EXTRA_ERROR);
    }

    @Nullable
    public static Uri getOutput(@NonNull Intent intent) {
        return (Uri) intent.getParcelableExtra(EXTRA_OUTPUT_URI);
    }

    public static float getOutputCropAspectRatio(@NonNull Intent intent) {
        return ((Float) intent.getParcelableExtra(EXTRA_OUTPUT_CROP_ASPECT_RATIO)).floatValue();
    }

    public static int getOutputImageHeight(@NonNull Intent intent) {
        return intent.getIntExtra(EXTRA_OUTPUT_IMAGE_HEIGHT, -1);
    }

    public static int getOutputImageWidth(@NonNull Intent intent) {
        return intent.getIntExtra(EXTRA_OUTPUT_IMAGE_WIDTH, -1);
    }

    public static UCrop of(@NonNull Uri uri, @NonNull Uri uri2) {
        return new UCrop(uri, uri2);
    }

    public UCropFragment getFragment() {
        return UCropFragment.newInstance(this.f38365b);
    }

    public Intent getIntent(@NonNull Context context) {
        this.f38364a.setClass(context, UCropActivity.class);
        this.f38364a.putExtras(this.f38365b);
        return this.f38364a;
    }

    public void start(@NonNull Activity activity) {
        start(activity, 69);
    }

    public UCrop useSourceImageAspectRatio() {
        this.f38365b.putFloat(EXTRA_ASPECT_RATIO_X, 0.0f);
        this.f38365b.putFloat(EXTRA_ASPECT_RATIO_Y, 0.0f);
        return this;
    }

    public UCrop withAspectRatio(float f4, float f5) {
        this.f38365b.putFloat(EXTRA_ASPECT_RATIO_X, f4);
        this.f38365b.putFloat(EXTRA_ASPECT_RATIO_Y, f5);
        return this;
    }

    public UCrop withMaxResultSize(@IntRange(from = 10) int i4, @IntRange(from = 10) int i5) {
        if (i4 < 10) {
            i4 = 10;
        }
        if (i5 < 10) {
            i5 = 10;
        }
        this.f38365b.putInt(EXTRA_MAX_SIZE_X, i4);
        this.f38365b.putInt(EXTRA_MAX_SIZE_Y, i5);
        return this;
    }

    public UCrop withOptions(@NonNull Options options) {
        this.f38365b.putAll(options.getOptionBundle());
        return this;
    }

    public UCropFragment getFragment(Bundle bundle) {
        this.f38365b = bundle;
        return getFragment();
    }

    public void start(@NonNull Activity activity, int i4) {
        activity.startActivityForResult(getIntent(activity), i4);
    }

    public void start(@NonNull Context context, @NonNull Fragment fragment) {
        start(context, fragment, 69);
    }

    public void start(@NonNull Context context, @NonNull androidx.fragment.app.Fragment fragment) {
        start(context, fragment, 69);
    }

    @TargetApi(11)
    public void start(@NonNull Context context, @NonNull Fragment fragment, int i4) {
        fragment.startActivityForResult(getIntent(context), i4);
    }

    public void start(@NonNull Context context, @NonNull androidx.fragment.app.Fragment fragment, int i4) {
        fragment.startActivityForResult(getIntent(context), i4);
    }
}
