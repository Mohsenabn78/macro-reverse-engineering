package com.jaredrummler.android.colorpicker;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.graphics.ColorUtils;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.jaredrummler.android.colorpicker.ColorPickerView;
import com.jaredrummler.android.colorpicker.b;
import java.util.Arrays;
import java.util.Locale;

/* loaded from: classes6.dex */
public class ColorPickerDialog extends DialogFragment implements ColorPickerView.OnColorChangedListener, TextWatcher {
    public static final int[] MATERIAL_COLORS = {-769226, -1499549, -54125, -6543440, -10011977, -12627531, -14575885, -16537100, -16728876, -16738680, -11751600, -7617718, -3285959, -5317, -16121, -26624, -8825528, -10453621, -6381922};
    public static final int TYPE_CUSTOM = 0;
    public static final int TYPE_PRESETS = 1;

    /* renamed from: b  reason: collision with root package name */
    ColorPickerDialogListener f34464b;

    /* renamed from: c  reason: collision with root package name */
    FrameLayout f34465c;

    /* renamed from: d  reason: collision with root package name */
    int[] f34466d;
    @ColorInt

    /* renamed from: e  reason: collision with root package name */
    int f34467e;

    /* renamed from: f  reason: collision with root package name */
    int f34468f;

    /* renamed from: g  reason: collision with root package name */
    int f34469g;

    /* renamed from: h  reason: collision with root package name */
    boolean f34470h;

    /* renamed from: i  reason: collision with root package name */
    int f34471i;

    /* renamed from: j  reason: collision with root package name */
    com.jaredrummler.android.colorpicker.b f34472j;

    /* renamed from: k  reason: collision with root package name */
    LinearLayout f34473k;

    /* renamed from: l  reason: collision with root package name */
    SeekBar f34474l;

    /* renamed from: m  reason: collision with root package name */
    TextView f34475m;

    /* renamed from: n  reason: collision with root package name */
    ColorPickerView f34476n;

    /* renamed from: o  reason: collision with root package name */
    ColorPanelView f34477o;

    /* renamed from: p  reason: collision with root package name */
    EditText f34478p;

    /* renamed from: q  reason: collision with root package name */
    boolean f34479q;

    /* renamed from: r  reason: collision with root package name */
    private int f34480r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f34481s;

    /* renamed from: t  reason: collision with root package name */
    private int f34482t;

    /* renamed from: u  reason: collision with root package name */
    private final View.OnTouchListener f34483u = new b();

    /* loaded from: classes6.dex */
    public static final class Builder {
        @StringRes

        /* renamed from: a  reason: collision with root package name */
        int f34484a = R.string.cpv_default_title;
        @StringRes

        /* renamed from: b  reason: collision with root package name */
        int f34485b = R.string.cpv_presets;
        @StringRes

        /* renamed from: c  reason: collision with root package name */
        int f34486c = R.string.cpv_custom;
        @StringRes

        /* renamed from: d  reason: collision with root package name */
        int f34487d = R.string.cpv_select;
        @DialogType

        /* renamed from: e  reason: collision with root package name */
        int f34488e = 1;

        /* renamed from: f  reason: collision with root package name */
        int[] f34489f = ColorPickerDialog.MATERIAL_COLORS;
        @ColorInt

        /* renamed from: g  reason: collision with root package name */
        int f34490g = -16777216;

        /* renamed from: h  reason: collision with root package name */
        int f34491h = 0;

        /* renamed from: i  reason: collision with root package name */
        boolean f34492i = false;

        /* renamed from: j  reason: collision with root package name */
        boolean f34493j = true;

        /* renamed from: k  reason: collision with root package name */
        boolean f34494k = true;

        /* renamed from: l  reason: collision with root package name */
        boolean f34495l = true;
        @ColorShape

        /* renamed from: m  reason: collision with root package name */
        int f34496m = 1;

        Builder() {
        }

        public ColorPickerDialog create() {
            ColorPickerDialog colorPickerDialog = new ColorPickerDialog();
            Bundle bundle = new Bundle();
            bundle.putInt("id", this.f34491h);
            bundle.putInt("dialogType", this.f34488e);
            bundle.putInt(TypedValues.Custom.S_COLOR, this.f34490g);
            bundle.putIntArray("presets", this.f34489f);
            bundle.putBoolean("alpha", this.f34492i);
            bundle.putBoolean("allowCustom", this.f34494k);
            bundle.putBoolean("allowPresets", this.f34493j);
            bundle.putInt("dialogTitle", this.f34484a);
            bundle.putBoolean("showColorShades", this.f34495l);
            bundle.putInt("colorShape", this.f34496m);
            bundle.putInt("presetsButtonText", this.f34485b);
            bundle.putInt("customButtonText", this.f34486c);
            bundle.putInt("selectedButtonText", this.f34487d);
            colorPickerDialog.setArguments(bundle);
            return colorPickerDialog;
        }

        public Builder setAllowCustom(boolean z3) {
            this.f34494k = z3;
            return this;
        }

        public Builder setAllowPresets(boolean z3) {
            this.f34493j = z3;
            return this;
        }

        public Builder setColor(int i4) {
            this.f34490g = i4;
            return this;
        }

        public Builder setColorShape(int i4) {
            this.f34496m = i4;
            return this;
        }

        public Builder setCustomButtonText(@StringRes int i4) {
            this.f34486c = i4;
            return this;
        }

        public Builder setDialogId(int i4) {
            this.f34491h = i4;
            return this;
        }

        public Builder setDialogTitle(@StringRes int i4) {
            this.f34484a = i4;
            return this;
        }

        public Builder setDialogType(@DialogType int i4) {
            this.f34488e = i4;
            return this;
        }

        public Builder setPresets(@NonNull int[] iArr) {
            this.f34489f = iArr;
            return this;
        }

        public Builder setPresetsButtonText(@StringRes int i4) {
            this.f34485b = i4;
            return this;
        }

        public Builder setSelectedButtonText(@StringRes int i4) {
            this.f34487d = i4;
            return this;
        }

        public Builder setShowAlphaSlider(boolean z3) {
            this.f34492i = z3;
            return this;
        }

        public Builder setShowColorShades(boolean z3) {
            this.f34495l = z3;
            return this;
        }

        public void show(FragmentActivity fragmentActivity) {
            create().show(fragmentActivity.getSupportFragmentManager(), "color-picker-dialog");
        }
    }

    /* loaded from: classes6.dex */
    public @interface DialogType {
    }

    /* loaded from: classes6.dex */
    class b implements View.OnTouchListener {
        b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            EditText editText = ColorPickerDialog.this.f34478p;
            if (view == editText || !editText.hasFocus()) {
                return false;
            }
            ColorPickerDialog.this.f34478p.clearFocus();
            ((InputMethodManager) ColorPickerDialog.this.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(ColorPickerDialog.this.f34478p.getWindowToken(), 0);
            ColorPickerDialog.this.f34478p.clearFocus();
            return true;
        }
    }

    /* loaded from: classes6.dex */
    class c implements DialogInterface.OnClickListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i4) {
            ColorPickerDialog colorPickerDialog = ColorPickerDialog.this;
            colorPickerDialog.onColorSelected(colorPickerDialog.f34467e);
        }
    }

    /* loaded from: classes6.dex */
    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i4;
            int i5;
            ColorPickerDialog.this.f34465c.removeAllViews();
            ColorPickerDialog colorPickerDialog = ColorPickerDialog.this;
            int i6 = colorPickerDialog.f34468f;
            if (i6 != 0) {
                if (i6 == 1) {
                    colorPickerDialog.f34468f = 0;
                    Button button = (Button) view;
                    if (colorPickerDialog.f34480r != 0) {
                        i5 = ColorPickerDialog.this.f34480r;
                    } else {
                        i5 = R.string.cpv_presets;
                    }
                    button.setText(i5);
                    ColorPickerDialog colorPickerDialog2 = ColorPickerDialog.this;
                    colorPickerDialog2.f34465c.addView(colorPickerDialog2.f());
                    return;
                }
                return;
            }
            colorPickerDialog.f34468f = 1;
            Button button2 = (Button) view;
            if (colorPickerDialog.f34482t != 0) {
                i4 = ColorPickerDialog.this.f34482t;
            } else {
                i4 = R.string.cpv_custom;
            }
            button2.setText(i4);
            ColorPickerDialog colorPickerDialog3 = ColorPickerDialog.this;
            colorPickerDialog3.f34465c.addView(colorPickerDialog3.g());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int color = ColorPickerDialog.this.f34477o.getColor();
            ColorPickerDialog colorPickerDialog = ColorPickerDialog.this;
            int i4 = colorPickerDialog.f34467e;
            if (color == i4) {
                colorPickerDialog.onColorSelected(i4);
                ColorPickerDialog.this.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class f implements View.OnFocusChangeListener {
        f() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z3) {
            if (z3) {
                ((InputMethodManager) ColorPickerDialog.this.getActivity().getSystemService("input_method")).showSoftInput(ColorPickerDialog.this.f34478p, 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class g implements b.a {
        g() {
        }

        @Override // com.jaredrummler.android.colorpicker.b.a
        public void onColorSelected(int i4) {
            ColorPickerDialog colorPickerDialog = ColorPickerDialog.this;
            int i5 = colorPickerDialog.f34467e;
            if (i5 == i4) {
                colorPickerDialog.onColorSelected(i5);
                ColorPickerDialog.this.dismiss();
                return;
            }
            colorPickerDialog.f34467e = i4;
            if (colorPickerDialog.f34470h) {
                colorPickerDialog.e(i4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class h implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ColorPanelView f34504a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f34505b;

        h(ColorPanelView colorPanelView, int i4) {
            this.f34504a = colorPanelView;
            this.f34505b = i4;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f34504a.setColor(this.f34505b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class i implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ColorPanelView f34507a;

        i(ColorPanelView colorPanelView) {
            this.f34507a = colorPanelView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i4;
            boolean z3;
            if ((view.getTag() instanceof Boolean) && ((Boolean) view.getTag()).booleanValue()) {
                ColorPickerDialog colorPickerDialog = ColorPickerDialog.this;
                colorPickerDialog.onColorSelected(colorPickerDialog.f34467e);
                ColorPickerDialog.this.dismiss();
                return;
            }
            ColorPickerDialog.this.f34467e = this.f34507a.getColor();
            ColorPickerDialog.this.f34472j.a();
            for (int i5 = 0; i5 < ColorPickerDialog.this.f34473k.getChildCount(); i5++) {
                FrameLayout frameLayout = (FrameLayout) ColorPickerDialog.this.f34473k.getChildAt(i5);
                ColorPanelView colorPanelView = (ColorPanelView) frameLayout.findViewById(R.id.cpv_color_panel_view);
                ImageView imageView = (ImageView) frameLayout.findViewById(R.id.cpv_color_image_view);
                if (colorPanelView == view) {
                    i4 = R.drawable.cpv_preset_checked;
                } else {
                    i4 = 0;
                }
                imageView.setImageResource(i4);
                if ((colorPanelView == view && ColorUtils.calculateLuminance(colorPanelView.getColor()) >= 0.65d) || Color.alpha(colorPanelView.getColor()) <= 165) {
                    imageView.setColorFilter(-16777216, PorterDuff.Mode.SRC_IN);
                } else {
                    imageView.setColorFilter((ColorFilter) null);
                }
                if (colorPanelView == view) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                colorPanelView.setTag(Boolean.valueOf(z3));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class j implements View.OnLongClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ColorPanelView f34509a;

        j(ColorPanelView colorPanelView) {
            this.f34509a = colorPanelView;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            this.f34509a.showHint();
            return true;
        }
    }

    private int getSelectedItemPosition() {
        int i4 = 0;
        while (true) {
            int[] iArr = this.f34466d;
            if (i4 < iArr.length) {
                if (iArr[i4] == this.f34467e) {
                    return i4;
                }
                i4++;
            } else {
                return -1;
            }
        }
    }

    private int[] h(@ColorInt int i4) {
        return new int[]{o(i4, 0.9d), o(i4, 0.7d), o(i4, 0.5d), o(i4, 0.333d), o(i4, 0.166d), o(i4, -0.125d), o(i4, -0.25d), o(i4, -0.375d), o(i4, -0.5d), o(i4, -0.675d), o(i4, -0.7d), o(i4, -0.775d)};
    }

    private void i() {
        boolean z3;
        int alpha = Color.alpha(this.f34467e);
        int[] intArray = getArguments().getIntArray("presets");
        this.f34466d = intArray;
        if (intArray == null) {
            this.f34466d = MATERIAL_COLORS;
        }
        int[] iArr = this.f34466d;
        if (iArr == MATERIAL_COLORS) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.f34466d = Arrays.copyOf(iArr, iArr.length);
        if (alpha != 255) {
            int i4 = 0;
            while (true) {
                int[] iArr2 = this.f34466d;
                if (i4 >= iArr2.length) {
                    break;
                }
                int i5 = iArr2[i4];
                this.f34466d[i4] = Color.argb(alpha, Color.red(i5), Color.green(i5), Color.blue(i5));
                i4++;
            }
        }
        this.f34466d = p(this.f34466d, this.f34467e);
        int i6 = getArguments().getInt(TypedValues.Custom.S_COLOR);
        if (i6 != this.f34467e) {
            this.f34466d = p(this.f34466d, i6);
        }
        if (z3) {
            int[] iArr3 = this.f34466d;
            if (iArr3.length == 19) {
                this.f34466d = l(iArr3, Color.argb(alpha, 0, 0, 0));
            }
        }
    }

    private void j() {
        if (this.f34464b != null) {
            Log.w("ColorPickerDialog", "Using deprecated listener which may be remove in future releases");
            this.f34464b.onDialogDismissed(this.f34469g);
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity instanceof ColorPickerDialogListener) {
            ((ColorPickerDialogListener) activity).onDialogDismissed(this.f34469g);
        }
    }

    private int k(String str) throws NumberFormatException {
        int i4;
        int i5;
        if (str.startsWith("#")) {
            str = str.substring(1);
        }
        int i6 = 255;
        int i7 = 0;
        if (str.length() == 0) {
            i4 = 0;
        } else if (str.length() <= 2) {
            i4 = Integer.parseInt(str, 16);
        } else {
            if (str.length() == 3) {
                i7 = Integer.parseInt(str.substring(0, 1), 16);
                i5 = Integer.parseInt(str.substring(1, 2), 16);
                i4 = Integer.parseInt(str.substring(2, 3), 16);
            } else if (str.length() == 4) {
                i5 = Integer.parseInt(str.substring(0, 2), 16);
                i4 = Integer.parseInt(str.substring(2, 4), 16);
            } else if (str.length() == 5) {
                i7 = Integer.parseInt(str.substring(0, 1), 16);
                i5 = Integer.parseInt(str.substring(1, 3), 16);
                i4 = Integer.parseInt(str.substring(3, 5), 16);
            } else if (str.length() == 6) {
                i7 = Integer.parseInt(str.substring(0, 2), 16);
                i5 = Integer.parseInt(str.substring(2, 4), 16);
                i4 = Integer.parseInt(str.substring(4, 6), 16);
            } else if (str.length() == 7) {
                int parseInt = Integer.parseInt(str.substring(0, 1), 16);
                i7 = Integer.parseInt(str.substring(1, 3), 16);
                int parseInt2 = Integer.parseInt(str.substring(3, 5), 16);
                i4 = Integer.parseInt(str.substring(5, 7), 16);
                i6 = parseInt;
                i5 = parseInt2;
            } else if (str.length() == 8) {
                i6 = Integer.parseInt(str.substring(0, 2), 16);
                i7 = Integer.parseInt(str.substring(2, 4), 16);
                i5 = Integer.parseInt(str.substring(4, 6), 16);
                i4 = Integer.parseInt(str.substring(6, 8), 16);
            } else {
                i6 = -1;
                i4 = -1;
                i5 = -1;
                i7 = -1;
            }
            return Color.argb(i6, i7, i5, i4);
        }
        i5 = 0;
        return Color.argb(i6, i7, i5, i4);
    }

    private int[] l(int[] iArr, int i4) {
        boolean z3;
        int length = iArr.length;
        int i5 = 0;
        while (true) {
            if (i5 < length) {
                if (iArr[i5] == i4) {
                    z3 = true;
                    break;
                }
                i5++;
            } else {
                z3 = false;
                break;
            }
        }
        if (!z3) {
            int length2 = iArr.length + 1;
            int[] iArr2 = new int[length2];
            int i6 = length2 - 1;
            iArr2[i6] = i4;
            System.arraycopy(iArr, 0, iArr2, 0, i6);
            return iArr2;
        }
        return iArr;
    }

    private void m(int i4) {
        if (this.f34479q) {
            this.f34478p.setText(String.format("%08X", Integer.valueOf(i4)));
        } else {
            this.f34478p.setText(String.format("%06X", Integer.valueOf(i4 & 16777215)));
        }
    }

    private void n() {
        int alpha = 255 - Color.alpha(this.f34467e);
        this.f34474l.setMax(255);
        this.f34474l.setProgress(alpha);
        this.f34475m.setText(String.format(Locale.ENGLISH, "%d%%", Integer.valueOf((int) ((alpha * 100.0d) / 255.0d))));
        this.f34474l.setOnSeekBarChangeListener(new a());
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    private int o(@ColorInt int i4, double d4) {
        long parseLong = Long.parseLong(String.format("#%06X", Integer.valueOf(16777215 & i4)).substring(1), 16);
        double d5 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        int i5 = (d4 > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (d4 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1));
        if (i5 >= 0) {
            d5 = 255.0d;
        }
        if (i5 < 0) {
            d4 *= -1.0d;
        }
        long j4 = parseLong >> 16;
        long j5 = (parseLong >> 8) & 255;
        long j6 = parseLong & 255;
        return Color.argb(Color.alpha(i4), (int) (Math.round((d5 - j4) * d4) + j4), (int) (Math.round((d5 - j5) * d4) + j5), (int) (Math.round((d5 - j6) * d4) + j6));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onColorSelected(int i4) {
        if (this.f34464b != null) {
            Log.w("ColorPickerDialog", "Using deprecated listener which may be remove in future releases");
            this.f34464b.onColorSelected(this.f34469g, i4);
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity instanceof ColorPickerDialogListener) {
            ((ColorPickerDialogListener) activity).onColorSelected(this.f34469g, i4);
            return;
        }
        throw new IllegalStateException("The activity must implement ColorPickerDialogListener");
    }

    private int[] p(int[] iArr, int i4) {
        boolean z3;
        int length = iArr.length;
        int i5 = 0;
        while (true) {
            if (i5 < length) {
                if (iArr[i5] == i4) {
                    z3 = true;
                    break;
                }
                i5++;
            } else {
                z3 = false;
                break;
            }
        }
        if (!z3) {
            int length2 = iArr.length + 1;
            int[] iArr2 = new int[length2];
            iArr2[0] = i4;
            System.arraycopy(iArr, 0, iArr2, 1, length2 - 1);
            return iArr2;
        }
        return iArr;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        int k4;
        if (this.f34478p.isFocused() && (k4 = k(editable.toString())) != this.f34476n.getColor()) {
            this.f34481s = true;
            this.f34476n.setColor(k4, true);
        }
    }

    void e(@ColorInt int i4) {
        int i5;
        int[] h4 = h(i4);
        int i6 = 0;
        if (this.f34473k.getChildCount() != 0) {
            while (i6 < this.f34473k.getChildCount()) {
                FrameLayout frameLayout = (FrameLayout) this.f34473k.getChildAt(i6);
                ColorPanelView colorPanelView = (ColorPanelView) frameLayout.findViewById(R.id.cpv_color_panel_view);
                colorPanelView.setColor(h4[i6]);
                colorPanelView.setTag(Boolean.FALSE);
                ((ImageView) frameLayout.findViewById(R.id.cpv_color_image_view)).setImageDrawable(null);
                i6++;
            }
            return;
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.cpv_item_horizontal_padding);
        int length = h4.length;
        while (i6 < length) {
            int i7 = h4[i6];
            if (this.f34471i == 0) {
                i5 = R.layout.cpv_color_item_square;
            } else {
                i5 = R.layout.cpv_color_item_circle;
            }
            View inflate = View.inflate(getActivity(), i5, null);
            ColorPanelView colorPanelView2 = (ColorPanelView) inflate.findViewById(R.id.cpv_color_panel_view);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) colorPanelView2.getLayoutParams();
            marginLayoutParams.rightMargin = dimensionPixelSize;
            marginLayoutParams.leftMargin = dimensionPixelSize;
            colorPanelView2.setLayoutParams(marginLayoutParams);
            colorPanelView2.setColor(i7);
            this.f34473k.addView(inflate);
            colorPanelView2.post(new h(colorPanelView2, i7));
            colorPanelView2.setOnClickListener(new i(colorPanelView2));
            colorPanelView2.setOnLongClickListener(new j(colorPanelView2));
            i6++;
        }
    }

    View f() {
        View inflate = View.inflate(getActivity(), R.layout.cpv_dialog_color_picker, null);
        this.f34476n = (ColorPickerView) inflate.findViewById(R.id.cpv_color_picker_view);
        ColorPanelView colorPanelView = (ColorPanelView) inflate.findViewById(R.id.cpv_color_panel_old);
        this.f34477o = (ColorPanelView) inflate.findViewById(R.id.cpv_color_panel_new);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.cpv_arrow_right);
        this.f34478p = (EditText) inflate.findViewById(R.id.cpv_hex);
        try {
            TypedArray obtainStyledAttributes = getActivity().obtainStyledAttributes(new TypedValue().data, new int[]{16842806});
            int color = obtainStyledAttributes.getColor(0, -16777216);
            obtainStyledAttributes.recycle();
            imageView.setColorFilter(color);
        } catch (Exception unused) {
        }
        this.f34476n.setAlphaSliderVisible(this.f34479q);
        colorPanelView.setColor(getArguments().getInt(TypedValues.Custom.S_COLOR));
        this.f34476n.setColor(this.f34467e, true);
        this.f34477o.setColor(this.f34467e);
        m(this.f34467e);
        if (!this.f34479q) {
            this.f34478p.setFilters(new InputFilter[]{new InputFilter.LengthFilter(6)});
        }
        this.f34477o.setOnClickListener(new e());
        inflate.setOnTouchListener(this.f34483u);
        this.f34476n.setOnColorChangedListener(this);
        this.f34478p.addTextChangedListener(this);
        this.f34478p.setOnFocusChangeListener(new f());
        return inflate;
    }

    View g() {
        View inflate = View.inflate(getActivity(), R.layout.cpv_dialog_presets, null);
        this.f34473k = (LinearLayout) inflate.findViewById(R.id.shades_layout);
        this.f34474l = (SeekBar) inflate.findViewById(R.id.transparency_seekbar);
        this.f34475m = (TextView) inflate.findViewById(R.id.transparency_text);
        GridView gridView = (GridView) inflate.findViewById(R.id.gridView);
        i();
        if (this.f34470h) {
            e(this.f34467e);
        } else {
            this.f34473k.setVisibility(8);
            inflate.findViewById(R.id.shades_divider).setVisibility(8);
        }
        com.jaredrummler.android.colorpicker.b bVar = new com.jaredrummler.android.colorpicker.b(new g(), this.f34466d, getSelectedItemPosition(), this.f34471i);
        this.f34472j = bVar;
        gridView.setAdapter((ListAdapter) bVar);
        if (this.f34479q) {
            n();
        } else {
            inflate.findViewById(R.id.transparency_layout).setVisibility(8);
            inflate.findViewById(R.id.transparency_title).setVisibility(8);
        }
        return inflate;
    }

    @Override // com.jaredrummler.android.colorpicker.ColorPickerView.OnColorChangedListener
    public void onColorChanged(int i4) {
        this.f34467e = i4;
        ColorPanelView colorPanelView = this.f34477o;
        if (colorPanelView != null) {
            colorPanelView.setColor(i4);
        }
        if (!this.f34481s && this.f34478p != null) {
            m(i4);
            if (this.f34478p.hasFocus()) {
                ((InputMethodManager) getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.f34478p.getWindowToken(), 0);
                this.f34478p.clearFocus();
            }
        }
        this.f34481s = false;
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        int i4;
        this.f34469g = getArguments().getInt("id");
        this.f34479q = getArguments().getBoolean("alpha");
        this.f34470h = getArguments().getBoolean("showColorShades");
        this.f34471i = getArguments().getInt("colorShape");
        if (bundle == null) {
            this.f34467e = getArguments().getInt(TypedValues.Custom.S_COLOR);
            this.f34468f = getArguments().getInt("dialogType");
        } else {
            this.f34467e = bundle.getInt(TypedValues.Custom.S_COLOR);
            this.f34468f = bundle.getInt("dialogType");
        }
        FrameLayout frameLayout = new FrameLayout(requireActivity());
        this.f34465c = frameLayout;
        int i5 = this.f34468f;
        if (i5 == 0) {
            frameLayout.addView(f());
        } else if (i5 == 1) {
            frameLayout.addView(g());
        }
        int i6 = getArguments().getInt("selectedButtonText");
        if (i6 == 0) {
            i6 = R.string.cpv_select;
        }
        AlertDialog.Builder positiveButton = new AlertDialog.Builder(requireActivity()).setView(this.f34465c).setPositiveButton(i6, new c());
        int i7 = getArguments().getInt("dialogTitle");
        if (i7 != 0) {
            positiveButton.setTitle(i7);
        }
        this.f34480r = getArguments().getInt("presetsButtonText");
        this.f34482t = getArguments().getInt("customButtonText");
        if (this.f34468f == 0 && getArguments().getBoolean("allowPresets")) {
            i4 = this.f34480r;
            if (i4 == 0) {
                i4 = R.string.cpv_presets;
            }
        } else if (this.f34468f == 1 && getArguments().getBoolean("allowCustom")) {
            i4 = this.f34482t;
            if (i4 == 0) {
                i4 = R.string.cpv_custom;
            }
        } else {
            i4 = 0;
        }
        if (i4 != 0) {
            positiveButton.setNeutralButton(i4, (DialogInterface.OnClickListener) null);
        }
        return positiveButton.create();
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        j();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt(TypedValues.Custom.S_COLOR, this.f34467e);
        bundle.putInt("dialogType", this.f34468f);
        super.onSaveInstanceState(bundle);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        AlertDialog alertDialog = (AlertDialog) getDialog();
        alertDialog.getWindow().clearFlags(131080);
        alertDialog.getWindow().setSoftInputMode(4);
        Button button = alertDialog.getButton(-3);
        if (button != null) {
            button.setOnClickListener(new d());
        }
    }

    public void setColorPickerDialogListener(ColorPickerDialogListener colorPickerDialogListener) {
        this.f34464b = colorPickerDialogListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a implements SeekBar.OnSeekBarChangeListener {
        a() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i4, boolean z3) {
            com.jaredrummler.android.colorpicker.b bVar;
            ColorPickerDialog.this.f34475m.setText(String.format(Locale.ENGLISH, "%d%%", Integer.valueOf((int) ((i4 * 100.0d) / 255.0d))));
            int i5 = 255 - i4;
            int i6 = 0;
            while (true) {
                bVar = ColorPickerDialog.this.f34472j;
                int[] iArr = bVar.f34573b;
                if (i6 >= iArr.length) {
                    break;
                }
                int i7 = iArr[i6];
                ColorPickerDialog.this.f34472j.f34573b[i6] = Color.argb(i5, Color.red(i7), Color.green(i7), Color.blue(i7));
                i6++;
            }
            bVar.notifyDataSetChanged();
            for (int i8 = 0; i8 < ColorPickerDialog.this.f34473k.getChildCount(); i8++) {
                FrameLayout frameLayout = (FrameLayout) ColorPickerDialog.this.f34473k.getChildAt(i8);
                ColorPanelView colorPanelView = (ColorPanelView) frameLayout.findViewById(R.id.cpv_color_panel_view);
                ImageView imageView = (ImageView) frameLayout.findViewById(R.id.cpv_color_image_view);
                if (frameLayout.getTag() == null) {
                    frameLayout.setTag(Integer.valueOf(colorPanelView.getBorderColor()));
                }
                int color = colorPanelView.getColor();
                int argb = Color.argb(i5, Color.red(color), Color.green(color), Color.blue(color));
                if (i5 <= 165) {
                    colorPanelView.setBorderColor(argb | (-16777216));
                } else {
                    colorPanelView.setBorderColor(((Integer) frameLayout.getTag()).intValue());
                }
                if (colorPanelView.getTag() != null && ((Boolean) colorPanelView.getTag()).booleanValue()) {
                    if (i5 <= 165) {
                        imageView.setColorFilter(-16777216, PorterDuff.Mode.SRC_IN);
                    } else if (ColorUtils.calculateLuminance(argb) >= 0.65d) {
                        imageView.setColorFilter(-16777216, PorterDuff.Mode.SRC_IN);
                    } else {
                        imageView.setColorFilter(-1, PorterDuff.Mode.SRC_IN);
                    }
                }
                colorPanelView.setColor(argb);
            }
            ColorPickerDialog.this.f34467e = Color.argb(i5, Color.red(ColorPickerDialog.this.f34467e), Color.green(ColorPickerDialog.this.f34467e), Color.blue(ColorPickerDialog.this.f34467e));
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
    }
}
