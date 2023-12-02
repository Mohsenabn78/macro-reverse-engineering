package com.afollestad.materialdialogs.color;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.ArrayRes;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.Theme;
import com.afollestad.materialdialogs.commons.R;
import com.afollestad.materialdialogs.internal.MDTintHelper;
import com.afollestad.materialdialogs.util.DialogUtils;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Locale;

/* loaded from: classes2.dex */
public class ColorChooserDialog extends DialogFragment implements View.OnClickListener, View.OnLongClickListener {
    public static final String TAG_ACCENT = "[MD_COLOR_CHOOSER]";
    public static final String TAG_CUSTOM = "[MD_COLOR_CHOOSER]";
    public static final String TAG_PRIMARY = "[MD_COLOR_CHOOSER]";

    /* renamed from: b  reason: collision with root package name */
    private int[] f1077b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private int[][] f1078c;

    /* renamed from: d  reason: collision with root package name */
    private int f1079d;

    /* renamed from: e  reason: collision with root package name */
    private ColorCallback f1080e;

    /* renamed from: f  reason: collision with root package name */
    private GridView f1081f;

    /* renamed from: g  reason: collision with root package name */
    private View f1082g;

    /* renamed from: h  reason: collision with root package name */
    private EditText f1083h;

    /* renamed from: i  reason: collision with root package name */
    private View f1084i;

    /* renamed from: j  reason: collision with root package name */
    private TextWatcher f1085j;

    /* renamed from: k  reason: collision with root package name */
    private SeekBar f1086k;

    /* renamed from: l  reason: collision with root package name */
    private TextView f1087l;

    /* renamed from: m  reason: collision with root package name */
    private SeekBar f1088m;

    /* renamed from: n  reason: collision with root package name */
    private TextView f1089n;

    /* renamed from: o  reason: collision with root package name */
    private SeekBar f1090o;

    /* renamed from: p  reason: collision with root package name */
    private TextView f1091p;

    /* renamed from: q  reason: collision with root package name */
    private SeekBar f1092q;

    /* renamed from: r  reason: collision with root package name */
    private TextView f1093r;

    /* renamed from: s  reason: collision with root package name */
    private SeekBar.OnSeekBarChangeListener f1094s;

    /* renamed from: t  reason: collision with root package name */
    private int f1095t;

    /* loaded from: classes2.dex */
    public interface ColorCallback {
        void onColorChooserDismissed(@NonNull ColorChooserDialog colorChooserDialog);

        void onColorSelection(@NonNull ColorChooserDialog colorChooserDialog, @ColorInt int i4);
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface ColorChooserTag {
    }

    /* loaded from: classes2.dex */
    class a implements DialogInterface.OnShowListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            ColorChooserDialog.this.I();
        }
    }

    /* loaded from: classes2.dex */
    class b implements MaterialDialog.SingleButtonCallback {
        b() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.SingleButtonCallback
        public void onClick(@NonNull MaterialDialog materialDialog, @NonNull DialogAction dialogAction) {
            ColorChooserDialog.this.N(materialDialog);
        }
    }

    /* loaded from: classes2.dex */
    class c implements MaterialDialog.SingleButtonCallback {
        c() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.SingleButtonCallback
        public void onClick(@NonNull MaterialDialog materialDialog, @NonNull DialogAction dialogAction) {
            if (ColorChooserDialog.this.K()) {
                materialDialog.setActionButton(DialogAction.NEGATIVE, ColorChooserDialog.this.F().cancelBtn);
                ColorChooserDialog.this.J(false);
                ColorChooserDialog.this.M(-1);
                ColorChooserDialog.this.H();
                return;
            }
            materialDialog.cancel();
        }
    }

    /* loaded from: classes2.dex */
    class d implements MaterialDialog.SingleButtonCallback {
        d() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.SingleButtonCallback
        public void onClick(@NonNull MaterialDialog materialDialog, @NonNull DialogAction dialogAction) {
            ColorCallback colorCallback = ColorChooserDialog.this.f1080e;
            ColorChooserDialog colorChooserDialog = ColorChooserDialog.this;
            colorCallback.onColorSelection(colorChooserDialog, colorChooserDialog.G());
            ColorChooserDialog.this.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class g extends BaseAdapter {
        g() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (ColorChooserDialog.this.K()) {
                return ColorChooserDialog.this.f1078c[ColorChooserDialog.this.O()].length;
            }
            return ColorChooserDialog.this.f1077b.length;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i4) {
            if (ColorChooserDialog.this.K()) {
                return Integer.valueOf(ColorChooserDialog.this.f1078c[ColorChooserDialog.this.O()][i4]);
            }
            return Integer.valueOf(ColorChooserDialog.this.f1077b[i4]);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i4) {
            return i4;
        }

        @Override // android.widget.Adapter
        @SuppressLint({"DefaultLocale"})
        public View getView(int i4, View view, ViewGroup viewGroup) {
            int i5;
            boolean z3;
            boolean z4;
            if (view == null) {
                view = new CircleView(ColorChooserDialog.this.getContext());
                view.setLayoutParams(new AbsListView.LayoutParams(ColorChooserDialog.this.f1079d, ColorChooserDialog.this.f1079d));
            }
            CircleView circleView = (CircleView) view;
            if (ColorChooserDialog.this.K()) {
                i5 = ColorChooserDialog.this.f1078c[ColorChooserDialog.this.O()][i4];
            } else {
                i5 = ColorChooserDialog.this.f1077b[i4];
            }
            circleView.setBackgroundColor(i5);
            if (ColorChooserDialog.this.K()) {
                if (ColorChooserDialog.this.L() == i4) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                circleView.setSelected(z4);
            } else {
                if (ColorChooserDialog.this.O() == i4) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                circleView.setSelected(z3);
            }
            circleView.setTag(String.format("%d:%d", Integer.valueOf(i4), Integer.valueOf(i5)));
            circleView.setOnClickListener(ColorChooserDialog.this);
            circleView.setOnLongClickListener(ColorChooserDialog.this);
            return view;
        }
    }

    private void C(FragmentManager fragmentManager, String str) {
        Fragment findFragmentByTag = fragmentManager.findFragmentByTag(str);
        if (findFragmentByTag != null) {
            ((DialogFragment) findFragmentByTag).dismiss();
            fragmentManager.beginTransaction().remove(findFragmentByTag).commit();
        }
    }

    private void D(int i4, int i5) {
        int[][] iArr = this.f1078c;
        if (iArr != null && iArr.length - 1 >= i4) {
            int[] iArr2 = iArr[i4];
            for (int i6 = 0; i6 < iArr2.length; i6++) {
                if (iArr2[i6] == i5) {
                    M(i6);
                    return;
                }
            }
        }
    }

    private void E() {
        Builder F = F();
        int[] iArr = F.colorsTop;
        if (iArr != null) {
            this.f1077b = iArr;
            this.f1078c = F.colorsSub;
        } else if (F.accentMode) {
            this.f1077b = com.afollestad.materialdialogs.color.a.f1106c;
            this.f1078c = com.afollestad.materialdialogs.color.a.f1107d;
        } else {
            this.f1077b = com.afollestad.materialdialogs.color.a.f1104a;
            this.f1078c = com.afollestad.materialdialogs.color.a.f1105b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Builder F() {
        if (getArguments() != null && getArguments().containsKey("builder")) {
            return (Builder) getArguments().getSerializable("builder");
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ColorInt
    public int G() {
        int i4;
        View view = this.f1082g;
        if (view != null && view.getVisibility() == 0) {
            return this.f1095t;
        }
        if (L() > -1) {
            i4 = this.f1078c[O()][L()];
        } else if (O() > -1) {
            i4 = this.f1077b[O()];
        } else {
            i4 = 0;
        }
        if (i4 == 0) {
            return DialogUtils.resolveColor(getActivity(), R.attr.colorAccent, DialogUtils.resolveColor(getActivity(), 16843829));
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        if (this.f1081f.getAdapter() == null) {
            this.f1081f.setAdapter((ListAdapter) new g());
            this.f1081f.setSelector(ResourcesCompat.getDrawable(getResources(), R.drawable.md_transparent, null));
        } else {
            ((BaseAdapter) this.f1081f.getAdapter()).notifyDataSetChanged();
        }
        if (getDialog() != null) {
            getDialog().setTitle(getTitle());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        MaterialDialog materialDialog = (MaterialDialog) getDialog();
        if (materialDialog != null && F().dynamicButtonColor) {
            int G = G();
            if (Color.alpha(G) < 64 || (Color.red(G) > 247 && Color.green(G) > 247 && Color.blue(G) > 247)) {
                G = Color.parseColor("#DEDEDE");
            }
            if (F().dynamicButtonColor) {
                materialDialog.getActionButton(DialogAction.POSITIVE).setTextColor(G);
                materialDialog.getActionButton(DialogAction.NEGATIVE).setTextColor(G);
                materialDialog.getActionButton(DialogAction.NEUTRAL).setTextColor(G);
            }
            if (this.f1088m != null) {
                if (this.f1086k.getVisibility() == 0) {
                    MDTintHelper.setTint(this.f1086k, G);
                }
                MDTintHelper.setTint(this.f1088m, G);
                MDTintHelper.setTint(this.f1090o, G);
                MDTintHelper.setTint(this.f1092q, G);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(boolean z3) {
        getArguments().putBoolean("in_sub", z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean K() {
        return getArguments().getBoolean("in_sub", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int L() {
        if (this.f1078c == null) {
            return -1;
        }
        return getArguments().getInt("sub_index", -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(int i4) {
        if (this.f1078c == null) {
            return;
        }
        getArguments().putInt("sub_index", i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(MaterialDialog materialDialog) {
        if (materialDialog == null) {
            materialDialog = (MaterialDialog) getDialog();
        }
        if (this.f1081f.getVisibility() == 0) {
            materialDialog.setTitle(F().customBtn);
            materialDialog.setActionButton(DialogAction.NEUTRAL, F().presetsBtn);
            materialDialog.setActionButton(DialogAction.NEGATIVE, F().cancelBtn);
            this.f1081f.setVisibility(4);
            this.f1082g.setVisibility(0);
            e eVar = new e();
            this.f1085j = eVar;
            this.f1083h.addTextChangedListener(eVar);
            f fVar = new f();
            this.f1094s = fVar;
            this.f1088m.setOnSeekBarChangeListener(fVar);
            this.f1090o.setOnSeekBarChangeListener(this.f1094s);
            this.f1092q.setOnSeekBarChangeListener(this.f1094s);
            if (this.f1086k.getVisibility() == 0) {
                this.f1086k.setOnSeekBarChangeListener(this.f1094s);
                this.f1083h.setText(String.format("%08X", Integer.valueOf(this.f1095t)));
                return;
            }
            this.f1083h.setText(String.format("%06X", Integer.valueOf(16777215 & this.f1095t)));
            return;
        }
        materialDialog.setTitle(F().title);
        materialDialog.setActionButton(DialogAction.NEUTRAL, F().customBtn);
        if (K()) {
            materialDialog.setActionButton(DialogAction.NEGATIVE, F().backBtn);
        } else {
            materialDialog.setActionButton(DialogAction.NEGATIVE, F().cancelBtn);
        }
        this.f1081f.setVisibility(0);
        this.f1082g.setVisibility(8);
        this.f1083h.removeTextChangedListener(this.f1085j);
        this.f1085j = null;
        this.f1088m.setOnSeekBarChangeListener(null);
        this.f1090o.setOnSeekBarChangeListener(null);
        this.f1092q.setOnSeekBarChangeListener(null);
        this.f1094s = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int O() {
        return getArguments().getInt("top_index", -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(int i4) {
        if (i4 > -1) {
            D(i4, this.f1077b[i4]);
        }
        getArguments().putInt("top_index", i4);
    }

    @Nullable
    public static ColorChooserDialog findVisible(@NonNull FragmentManager fragmentManager, String str) {
        Fragment findFragmentByTag = fragmentManager.findFragmentByTag(str);
        if (findFragmentByTag != null && (findFragmentByTag instanceof ColorChooserDialog)) {
            return (ColorChooserDialog) findFragmentByTag;
        }
        return null;
    }

    @StringRes
    public int getTitle() {
        int i4;
        Builder F = F();
        if (K()) {
            i4 = F.titleSub;
        } else {
            i4 = F.title;
        }
        if (i4 == 0) {
            return F.title;
        }
        return i4;
    }

    public boolean isAccentMode() {
        return F().accentMode;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (getActivity() instanceof ColorCallback) {
            this.f1080e = (ColorCallback) getActivity();
        } else if (getParentFragment() instanceof ColorCallback) {
            this.f1080e = (ColorCallback) getParentFragment();
        } else {
            throw new IllegalStateException("ColorChooserDialog needs to be shown from an Activity/Fragment implementing ColorCallback.");
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() != null) {
            int parseInt = Integer.parseInt(((String) view.getTag()).split(":")[0]);
            MaterialDialog materialDialog = (MaterialDialog) getDialog();
            Builder F = F();
            if (K()) {
                M(parseInt);
            } else {
                P(parseInt);
                int[][] iArr = this.f1078c;
                if (iArr != null && parseInt < iArr.length) {
                    materialDialog.setActionButton(DialogAction.NEGATIVE, F.backBtn);
                    J(true);
                }
            }
            if (F.allowUserCustom) {
                this.f1095t = G();
            }
            I();
            H();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x007e, code lost:
        r8 = r3;
     */
    @Override // androidx.fragment.app.DialogFragment
    @androidx.annotation.NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.app.Dialog onCreateDialog(android.os.Bundle r8) {
        /*
            Method dump skipped, instructions count: 465
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.afollestad.materialdialogs.color.ColorChooserDialog.onCreateDialog(android.os.Bundle):android.app.Dialog");
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        ColorCallback colorCallback = this.f1080e;
        if (colorCallback != null) {
            colorCallback.onColorChooserDismissed(this);
        }
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (view.getTag() != null) {
            ((CircleView) view).showHint(Integer.parseInt(((String) view.getTag()).split(":")[1]));
            return true;
        }
        return false;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        boolean z3;
        super.onSaveInstanceState(bundle);
        bundle.putInt("top_index", O());
        bundle.putBoolean("in_sub", K());
        bundle.putInt("sub_index", L());
        View view = this.f1082g;
        if (view != null && view.getVisibility() == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        bundle.putBoolean("in_custom", z3);
    }

    @NonNull
    public ColorChooserDialog show(FragmentManager fragmentManager) {
        int[] iArr = F().colorsTop;
        C(fragmentManager, "[MD_COLOR_CHOOSER]");
        show(fragmentManager, "[MD_COLOR_CHOOSER]");
        return this;
    }

    public String tag() {
        String str = F().tag;
        if (str != null) {
            return str;
        }
        return super.getTag();
    }

    /* loaded from: classes2.dex */
    public static class Builder implements Serializable {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        final transient Context f1096a;
        @Nullable
        int[][] colorsSub;
        @Nullable
        int[] colorsTop;
        @Nullable
        String mediumFont;
        @ColorInt
        int preselectColor;
        @Nullable
        String regularFont;
        @Nullable
        String tag;
        @Nullable
        Theme theme;
        @StringRes
        final int title;
        @StringRes
        int titleSub;
        @StringRes
        int doneBtn = R.string.md_done_label;
        @StringRes
        int backBtn = R.string.md_back_label;
        @StringRes
        int cancelBtn = R.string.md_cancel_label;
        @StringRes
        int customBtn = R.string.md_custom_label;
        @StringRes
        int presetsBtn = R.string.md_presets_label;
        boolean accentMode = false;
        boolean dynamicButtonColor = true;
        boolean allowUserCustom = true;
        boolean allowUserCustomAlpha = true;
        boolean setPreselectionColor = false;

        public Builder(@NonNull Context context, @StringRes int i4) {
            this.f1096a = context;
            this.title = i4;
        }

        @NonNull
        public Builder accentMode(boolean z3) {
            this.accentMode = z3;
            return this;
        }

        @NonNull
        public Builder allowUserColorInput(boolean z3) {
            this.allowUserCustom = z3;
            return this;
        }

        @NonNull
        public Builder allowUserColorInputAlpha(boolean z3) {
            this.allowUserCustomAlpha = z3;
            return this;
        }

        @NonNull
        public Builder backButton(@StringRes int i4) {
            this.backBtn = i4;
            return this;
        }

        @NonNull
        public ColorChooserDialog build() {
            ColorChooserDialog colorChooserDialog = new ColorChooserDialog();
            Bundle bundle = new Bundle();
            bundle.putSerializable("builder", this);
            colorChooserDialog.setArguments(bundle);
            return colorChooserDialog;
        }

        @NonNull
        public Builder cancelButton(@StringRes int i4) {
            this.cancelBtn = i4;
            return this;
        }

        @NonNull
        public Builder customButton(@StringRes int i4) {
            this.customBtn = i4;
            return this;
        }

        @NonNull
        public Builder customColors(@NonNull int[] iArr, @Nullable int[][] iArr2) {
            this.colorsTop = iArr;
            this.colorsSub = iArr2;
            return this;
        }

        @NonNull
        public Builder doneButton(@StringRes int i4) {
            this.doneBtn = i4;
            return this;
        }

        @NonNull
        public Builder dynamicButtonColor(boolean z3) {
            this.dynamicButtonColor = z3;
            return this;
        }

        @NonNull
        public Builder preselect(@ColorInt int i4) {
            this.preselectColor = i4;
            this.setPreselectionColor = true;
            return this;
        }

        @NonNull
        public Builder presetsButton(@StringRes int i4) {
            this.presetsBtn = i4;
            return this;
        }

        @NonNull
        public ColorChooserDialog show(FragmentManager fragmentManager) {
            ColorChooserDialog build = build();
            build.show(fragmentManager);
            return build;
        }

        @NonNull
        public Builder tag(@Nullable String str) {
            this.tag = str;
            return this;
        }

        @NonNull
        public Builder theme(@NonNull Theme theme) {
            this.theme = theme;
            return this;
        }

        @NonNull
        public Builder titleSub(@StringRes int i4) {
            this.titleSub = i4;
            return this;
        }

        @NonNull
        public Builder typeface(@Nullable String str, @Nullable String str2) {
            this.mediumFont = str;
            this.regularFont = str2;
            return this;
        }

        @NonNull
        public Builder customColors(@ArrayRes int i4, @Nullable int[][] iArr) {
            this.colorsTop = DialogUtils.getColorArray(this.f1096a, i4);
            this.colorsSub = iArr;
            return this;
        }

        @NonNull
        public ColorChooserDialog show(FragmentActivity fragmentActivity) {
            return show(fragmentActivity.getSupportFragmentManager());
        }
    }

    @NonNull
    public ColorChooserDialog show(FragmentActivity fragmentActivity) {
        return show(fragmentActivity.getSupportFragmentManager());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class e implements TextWatcher {
        e() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
            try {
                ColorChooserDialog colorChooserDialog = ColorChooserDialog.this;
                colorChooserDialog.f1095t = Color.parseColor("#" + charSequence.toString());
            } catch (IllegalArgumentException unused) {
                ColorChooserDialog.this.f1095t = -16777216;
            }
            ColorChooserDialog.this.f1084i.setBackgroundColor(ColorChooserDialog.this.f1095t);
            if (ColorChooserDialog.this.f1086k.getVisibility() == 0) {
                int alpha = Color.alpha(ColorChooserDialog.this.f1095t);
                ColorChooserDialog.this.f1086k.setProgress(alpha);
                ColorChooserDialog.this.f1087l.setText(String.format(Locale.US, "%d", Integer.valueOf(alpha)));
            }
            ColorChooserDialog.this.f1088m.setProgress(Color.red(ColorChooserDialog.this.f1095t));
            ColorChooserDialog.this.f1090o.setProgress(Color.green(ColorChooserDialog.this.f1095t));
            ColorChooserDialog.this.f1092q.setProgress(Color.blue(ColorChooserDialog.this.f1095t));
            ColorChooserDialog.this.J(false);
            ColorChooserDialog.this.P(-1);
            ColorChooserDialog.this.M(-1);
            ColorChooserDialog.this.I();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class f implements SeekBar.OnSeekBarChangeListener {
        f() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        @SuppressLint({"DefaultLocale"})
        public void onProgressChanged(SeekBar seekBar, int i4, boolean z3) {
            if (z3) {
                if (ColorChooserDialog.this.F().allowUserCustomAlpha) {
                    ColorChooserDialog.this.f1083h.setText(String.format("%08X", Integer.valueOf(Color.argb(ColorChooserDialog.this.f1086k.getProgress(), ColorChooserDialog.this.f1088m.getProgress(), ColorChooserDialog.this.f1090o.getProgress(), ColorChooserDialog.this.f1092q.getProgress()))));
                } else {
                    ColorChooserDialog.this.f1083h.setText(String.format("%06X", Integer.valueOf(Color.rgb(ColorChooserDialog.this.f1088m.getProgress(), ColorChooserDialog.this.f1090o.getProgress(), ColorChooserDialog.this.f1092q.getProgress()) & 16777215)));
                }
            }
            ColorChooserDialog.this.f1087l.setText(String.format("%d", Integer.valueOf(ColorChooserDialog.this.f1086k.getProgress())));
            ColorChooserDialog.this.f1089n.setText(String.format("%d", Integer.valueOf(ColorChooserDialog.this.f1088m.getProgress())));
            ColorChooserDialog.this.f1091p.setText(String.format("%d", Integer.valueOf(ColorChooserDialog.this.f1090o.getProgress())));
            ColorChooserDialog.this.f1093r.setText(String.format("%d", Integer.valueOf(ColorChooserDialog.this.f1092q.getProgress())));
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }
}
