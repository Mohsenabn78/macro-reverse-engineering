package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.Settings;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialog;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.emoji2.text.EmojiCompat;
import com.arlosoft.macrodroid.BuildConfig;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.activities.PopUpActionActivity;
import com.arlosoft.macrodroid.action.info.ToastActionInfo;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.interfaces.SupportsMagicText;
import com.arlosoft.macrodroid.interfaces.SupportsUserImages;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.permissions.PermissionsHelper;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.triggers.activities.selecticon.IconSelectActivity;
import com.arlosoft.macrodroid.utils.FileUtils;
import com.arlosoft.macrodroid.utils.IconUtils;
import com.arlosoft.macrodroid.utils.MDTextUtils;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.android.material.card.MaterialCardView;
import com.thebluealliance.spectrum.SpectrumDialog;
import es.dmoral.toasty.Toasty;
import java.io.FileNotFoundException;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import me.drakeet.support.toast.ToastCompat;

/* loaded from: classes2.dex */
public class ToastAction extends Action implements SupportsMagicText, SupportsUserImages {
    public static final Parcelable.Creator<ToastAction> CREATOR = new d();
    public static final int DURATION_LONG = 0;
    public static final int DURATION_LONG_BUG_FIX = 1;
    public static final int DURATION_SHORT = 2;
    public static final int POSITION_BOTTOM = 0;
    public static final int POSITION_CENTER = 1;
    public static final int POSITION_HORIZONTAL_CENTER = 0;
    public static final int POSITION_HORIZONTAL_LEFT = 1;
    public static final int POSITION_HORIZONTAL_RIGHT = 2;
    public static final int POSITION_TOP = 2;
    private static final int REQUEST_CODE_SELECT_ICON = 837834;
    public static SoftReference<Toast> lastToast;
    private boolean cancelPrevious;
    private transient WeakReference<ImageView> iconImageRef;
    private int m_backgroundColor;
    private transient int m_backgroundDuringConfig;
    private boolean m_displayIcon;
    private int m_duration;
    private int m_horizontalPosition;
    private String m_imageName;
    private String m_imagePackageName;
    private transient int m_imageResourceId;
    private String m_imageResourceName;
    private String m_imageUri;
    private String m_messageText;
    private int m_position;
    private int m_textColor;
    private transient int m_textDuringConfig;
    private boolean m_tintIcon;
    private boolean maintainSpaces;
    private boolean useTextOnly;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ViewGroup f2662a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ViewGroup f2663b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Activity f2664c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ TextView f2665d;

        a(ViewGroup viewGroup, ViewGroup viewGroup2, Activity activity, TextView textView) {
            this.f2662a = viewGroup;
            this.f2663b = viewGroup2;
            this.f2664c = activity;
            this.f2665d = textView;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
            int i4;
            int i5;
            boolean canDrawOverlays;
            ViewGroup viewGroup = this.f2662a;
            int i6 = 8;
            if (z3) {
                i4 = 8;
            } else {
                i4 = 0;
            }
            viewGroup.setVisibility(i4);
            ViewGroup viewGroup2 = this.f2663b;
            if (z3) {
                i5 = 8;
            } else {
                i5 = 0;
            }
            viewGroup2.setVisibility(i5);
            if (!z3 && Build.VERSION.SDK_INT >= 30) {
                canDrawOverlays = Settings.canDrawOverlays(this.f2664c);
                if (!canDrawOverlays) {
                    PermissionsHelper.showCanDrawOverlaysRequiredDialog(this.f2664c, false, false);
                }
            }
            TextView textView = this.f2665d;
            if (Build.VERSION.SDK_INT >= 31 && z3) {
                i6 = 0;
            }
            textView.setVisibility(i6);
        }
    }

    /* loaded from: classes2.dex */
    class b implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ImageView f2667a;

        b(ImageView imageView) {
            this.f2667a = imageView;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
            if (z3) {
                this.f2667a.setImageTintList(ColorStateList.valueOf(ToastAction.this.m_textDuringConfig));
            } else {
                this.f2667a.setImageTintList(null);
            }
        }
    }

    /* loaded from: classes2.dex */
    class d implements Parcelable.Creator<ToastAction> {
        d() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ToastAction createFromParcel(Parcel parcel) {
            return new ToastAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public ToastAction[] newArray(int i4) {
            return new ToastAction[i4];
        }
    }

    /* synthetic */ ToastAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    private void X(TriggerContextInfo triggerContextInfo, String str, boolean z3, boolean z4, String str2, String str3, String str4, String str5, int i4, int i5, int i6, int i7, int i8, boolean z5, boolean z6, boolean z7) {
        SoftReference<Toast> softReference;
        Toast toast;
        String replaceAll = g(str, triggerContextInfo).replaceAll("\n", "<br/>");
        if (z6) {
            replaceAll = replaceAll.replaceAll(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR, "&nbsp;");
        }
        String str6 = replaceAll;
        if (this.cancelPrevious && (softReference = lastToast) != null && (toast = softReference.get()) != null) {
            toast.cancel();
        }
        if (z5) {
            CharSequence fromHtml = Html.fromHtml(str6);
            try {
                fromHtml = EmojiCompat.get().process(fromHtml);
            } catch (Exception unused) {
            }
            ToastCompat makeText = ToastCompat.makeText(getContext(), fromHtml, i4 == 2 ? 0 : 1);
            makeText.show();
            lastToast = new SoftReference<>(makeText);
        } else if (!z7 && Build.VERSION.SDK_INT >= 30) {
            PopUpActionActivity.showPopupAction(getContext(), getMacroGuid().longValue(), str6, z3, z4, str2, str3, str4, str5, i4, i5, i6, i7, i8);
        } else {
            j0(triggerContextInfo, str6, z3, z4, str2, str3, str4, str5, i4, i5, i6, i7, i8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y(MaterialCardView materialCardView, MaterialCardView materialCardView2, ImageView imageView, boolean z3, int i4) {
        if (z3) {
            this.m_backgroundDuringConfig = i4;
            materialCardView.setCardBackgroundColor(i4);
            materialCardView2.setCardBackgroundColor(this.m_textDuringConfig);
            imageView.setBackgroundColor(this.m_backgroundDuringConfig);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z(final MaterialCardView materialCardView, final MaterialCardView materialCardView2, final ImageView imageView, Activity activity, View view) {
        new SpectrumDialog.Builder(getContext()).setTitle(R.string.select_color).setColors(R.array.toast_colors).setSelectedColor(this.m_backgroundDuringConfig).setDismissOnColorSelected(true).setOutlineWidth(1).setOnColorSelectedListener(new SpectrumDialog.OnColorSelectedListener() { // from class: com.arlosoft.macrodroid.action.vq
            @Override // com.thebluealliance.spectrum.SpectrumDialog.OnColorSelectedListener
            public final void onColorSelected(boolean z3, int i4) {
                ToastAction.this.Y(materialCardView, materialCardView2, imageView, z3, i4);
            }
        }).build().show(((AppCompatActivity) activity).getSupportFragmentManager(), "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a0(MaterialCardView materialCardView, MaterialCardView materialCardView2, boolean z3, int i4) {
        if (z3) {
            this.m_textDuringConfig = i4;
            materialCardView.setCardBackgroundColor(this.m_backgroundDuringConfig);
            materialCardView2.setCardBackgroundColor(this.m_textDuringConfig);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0(final MaterialCardView materialCardView, final MaterialCardView materialCardView2, Activity activity, View view) {
        new SpectrumDialog.Builder(getContext()).setTitle(R.string.select_color).setColors(R.array.toast_colors).setSelectedColor(this.m_backgroundDuringConfig).setDismissOnColorSelected(true).setOutlineWidth(1).setOnColorSelectedListener(new SpectrumDialog.OnColorSelectedListener() { // from class: com.arlosoft.macrodroid.action.uq
            @Override // com.thebluealliance.spectrum.SpectrumDialog.OnColorSelectedListener
            public final void onColorSelected(boolean z3, int i4) {
                ToastAction.this.a0(materialCardView, materialCardView2, z3, i4);
            }
        }).build().show(((AppCompatActivity) activity).getSupportFragmentManager(), "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c0(EditText editText, CheckBox checkBox, CheckBox checkBox2, Spinner spinner, Spinner spinner2, Spinner spinner3, RadioButton radioButton, CheckBox checkBox3, View view) {
        X(null, editText.getText().toString(), checkBox.isChecked(), checkBox2.isChecked(), this.m_imageUri, this.m_imagePackageName, this.m_imageName, this.m_imageResourceName, spinner.getSelectedItemPosition(), spinner2.getSelectedItemPosition(), spinner3.getSelectedItemPosition(), this.m_textDuringConfig, this.m_backgroundDuringConfig, radioButton.isChecked(), checkBox3.isChecked(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d0(Activity activity, View view) {
        activity.startActivityForResult(new Intent(activity, IconSelectActivity.class), REQUEST_CODE_SELECT_ICON);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e0(CheckBox checkBox, CheckBox checkBox2, EditText editText, Spinner spinner, Spinner spinner2, Spinner spinner3, RadioButton radioButton, CheckBox checkBox3, CheckBox checkBox4, AppCompatDialog appCompatDialog, View view) {
        this.m_displayIcon = checkBox.isChecked();
        this.m_tintIcon = checkBox2.isChecked();
        this.m_messageText = editText.getText().toString();
        this.m_backgroundColor = this.m_backgroundDuringConfig;
        this.m_textColor = this.m_textDuringConfig;
        this.m_duration = spinner.getSelectedItemPosition();
        this.m_position = spinner2.getSelectedItemPosition();
        this.m_horizontalPosition = spinner3.getSelectedItemPosition();
        this.useTextOnly = radioButton.isChecked();
        this.cancelPrevious = checkBox3.isChecked();
        this.maintainSpaces = checkBox4.isChecked();
        appCompatDialog.dismiss();
        itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void g0(EditText editText, MagicText.MagicTextPair magicTextPair) {
        int max = Math.max(editText.getSelectionStart(), 0);
        int max2 = Math.max(editText.getSelectionEnd(), 0);
        Editable text = editText.getText();
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = magicTextPair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    private int getBackgroundColor() {
        int i4 = this.m_backgroundColor;
        if (i4 == 0) {
            return ContextCompat.getColor(getContext(), R.color.md_grey_900);
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h0(Activity activity, MagicText.MagicTextListener magicTextListener, View view) {
        MagicText.displaySelectionDialog(activity, magicTextListener, getMacro(), true, true, true, R.style.Theme_App_Dialog_Action_SmallText, isChildOfIterateDictionary());
    }

    private void i0(Toast toast, int i4, int i5) {
        int i6;
        int dimensionPixelOffset = getContext().getResources().getDimensionPixelOffset(R.dimen.toast_margin);
        int i7 = 1;
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    i6 = 0;
                } else {
                    i6 = 48;
                }
            } else {
                i6 = 16;
            }
        } else {
            i6 = 80;
        }
        if (i5 != 0) {
            if (i5 != 1) {
                if (i5 != 2) {
                    i7 = 0;
                } else {
                    i7 = 5;
                }
            } else {
                i7 = 3;
            }
        }
        toast.setGravity(i6 | i7, 0, dimensionPixelOffset);
    }

    private void j0(TriggerContextInfo triggerContextInfo, String str, boolean z3, boolean z4, String str2, String str3, String str4, String str5, int i4, int i5, int i6, int i7, int i8) {
        Drawable createFromStream;
        Toast toast = null;
        if (str2 != null) {
            try {
                createFromStream = Drawable.createFromStream(getContext().getContentResolver().openInputStream(Uri.parse(str2)), str2);
            } catch (FileNotFoundException unused) {
            }
        } else if (str3 != null && str3.equals(Constants.USER_ICON_OPTION_PACKAGE)) {
            Bitmap decodeBitmapFromUserIconFile = FileUtils.decodeBitmapFromUserIconFile(str4);
            if (decodeBitmapFromUserIconFile != null) {
                createFromStream = new BitmapDrawable(getContext().getResources(), decodeBitmapFromUserIconFile);
            }
            createFromStream = null;
        } else {
            createFromStream = Util.getDrawableFromPackageWithName(getContext(), str3, str5);
        }
        if (createFromStream == null) {
            createFromStream = getContext().getResources().getDrawable(R.drawable.launcher_no_border);
        }
        if (!NotificationManagerCompat.from(getContext()).areNotificationsEnabled()) {
            SystemLog.logError("Pop up message failed because notifications are disabled for MacroDroid.", getMacroGuid().longValue());
            return;
        }
        Toasty.Config.getInstance().setTextColor(i7).tintIcon(z4).apply();
        CharSequence fromHtml = Html.fromHtml(str);
        try {
            fromHtml = EmojiCompat.get().process(fromHtml);
        } catch (Exception unused2) {
        }
        if (i4 == 0) {
            toast = Toasty.custom(getContext(), fromHtml, createFromStream, i8, 1, z3, true);
            i0(toast, i5, i6);
            toast.show();
        } else if (i4 == 1) {
            for (int i9 = 0; i9 < 2; i9++) {
                toast = Toasty.custom(getContext(), fromHtml, createFromStream, i8, 0, z3, true);
                i0(toast, i5, i6);
                toast.show();
            }
        } else if (i4 == 2) {
            toast = Toasty.custom(getContext(), fromHtml, createFromStream, i8, 0, z3, true);
            i0(toast, i5, i6);
            toast.show();
        }
        lastToast = new SoftReference<>(toast);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        return this.m_messageText;
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsUserImages
    @Nullable
    public List<String> getImagePaths() {
        if (!this.m_imagePackageName.equals(Constants.USER_ICON_OPTION_PACKAGE)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.m_imageResourceName);
        return arrayList;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return ToastActionInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getListModeName() {
        return getConfiguredName() + " '" + MDTextUtils.truncateListIfRequired(getExtendedDetail(), 15) + "'";
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public String[] getPossibleMagicText() {
        return new String[]{this.m_messageText};
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getSystemLogEntryName(TriggerContextInfo triggerContextInfo) {
        return getName() + " '" + g(this.m_messageText, triggerContextInfo) + "'";
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleActivityResult(Activity activity, int i4, int i5, Intent intent) {
        setActivity(activity);
        if (i4 == REQUEST_CODE_SELECT_ICON && i5 != 0) {
            this.m_imageResourceName = intent.getStringExtra(Util.DRAWABLE_NAME_EXTRA);
            this.m_imagePackageName = intent.getStringExtra(Util.DRAWABLE_PACKAGE_NAME_EXTRA);
            this.m_imageName = intent.getStringExtra(Util.DRAWABLE_NAME_EXTRA);
            this.m_imageResourceId = intent.getIntExtra(Util.DRAWABLE_ID_EXTRA, 0);
            Uri data = intent.getData();
            ImageView imageView = null;
            if (data != null) {
                this.m_imageUri = data.toString();
            } else {
                this.m_imageUri = null;
            }
            WeakReference<ImageView> weakReference = this.iconImageRef;
            if (weakReference != null) {
                imageView = weakReference.get();
            }
            ImageView imageView2 = imageView;
            if (imageView2 != null) {
                IconUtils.setImageOnImageView(getContext(), imageView2, this.m_imageName, this.m_imagePackageName, this.m_imageResourceId, this.m_imageUri);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        int i4;
        int i5;
        int i6;
        Button button;
        EditText editText;
        final Activity activity = getActivity();
        final AppCompatDialog appCompatDialog = new AppCompatDialog(new ContextThemeWrapper(activity, getDialogTheme()), getDialogTheme());
        appCompatDialog.setContentView(R.layout.toast_message_dialog);
        appCompatDialog.setTitle(R.string.action_toast);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
        layoutParams.width = -1;
        appCompatDialog.getWindow().setAttributes(layoutParams);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button3 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        final EditText editText2 = (EditText) appCompatDialog.findViewById(R.id.toast_message_dialog_text_content);
        Button button4 = (Button) appCompatDialog.findViewById(R.id.toast_message_dialog_magic_text_button);
        TextView textView = (TextView) appCompatDialog.findViewById(R.id.background_color_button);
        TextView textView2 = (TextView) appCompatDialog.findViewById(R.id.text_color_button);
        final MaterialCardView materialCardView = (MaterialCardView) appCompatDialog.findViewById(R.id.backgroundColorCircle);
        final MaterialCardView materialCardView2 = (MaterialCardView) appCompatDialog.findViewById(R.id.textColorCircle);
        final CheckBox checkBox = (CheckBox) appCompatDialog.findViewById(R.id.display_icon_checkbox);
        final CheckBox checkBox2 = (CheckBox) appCompatDialog.findViewById(R.id.tint_icon_checkbox);
        final ImageView imageView = (ImageView) appCompatDialog.findViewById(R.id.icon);
        final Spinner spinner = (Spinner) appCompatDialog.findViewById(R.id.duration_spinner);
        final Spinner spinner2 = (Spinner) appCompatDialog.findViewById(R.id.position_spinner);
        final Spinner spinner3 = (Spinner) appCompatDialog.findViewById(R.id.position_spinner_horizontal);
        Button button5 = (Button) appCompatDialog.findViewById(R.id.testButton);
        RadioButton radioButton = (RadioButton) appCompatDialog.findViewById(R.id.customizableRadioButton);
        final RadioButton radioButton2 = (RadioButton) appCompatDialog.findViewById(R.id.standardRadioButton);
        ViewGroup viewGroup = (ViewGroup) appCompatDialog.findViewById(R.id.customizationsContainer);
        ViewGroup viewGroup2 = (ViewGroup) appCompatDialog.findViewById(R.id.positionContainer);
        final CheckBox checkBox3 = (CheckBox) appCompatDialog.findViewById(R.id.cancelPreviousCheckbox);
        final CheckBox checkBox4 = (CheckBox) appCompatDialog.findViewById(R.id.maintain_spaces_checkbox);
        TextView textView3 = (TextView) appCompatDialog.findViewById(R.id.two_line_warning);
        this.iconImageRef = new WeakReference<>(imageView);
        if (Build.VERSION.SDK_INT >= 31 && this.useTextOnly) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        textView3.setVisibility(i4);
        checkBox4.setChecked(this.maintainSpaces);
        checkBox.setChecked(this.m_displayIcon);
        checkBox2.setChecked(this.m_tintIcon);
        if (this.useTextOnly) {
            i5 = 8;
        } else {
            i5 = 0;
        }
        viewGroup.setVisibility(i5);
        if (this.useTextOnly) {
            i6 = 8;
        } else {
            i6 = 0;
        }
        viewGroup2.setVisibility(i6);
        checkBox3.setChecked(this.cancelPrevious);
        radioButton.setChecked(!this.useTextOnly);
        radioButton2.setChecked(this.useTextOnly);
        int backgroundColor = getBackgroundColor();
        this.m_backgroundDuringConfig = backgroundColor;
        this.m_textDuringConfig = this.m_textColor;
        imageView.setBackgroundColor(backgroundColor);
        if (this.m_tintIcon) {
            imageView.setImageTintList(ColorStateList.valueOf(this.m_textDuringConfig));
        } else {
            imageView.setImageTintList(null);
        }
        radioButton2.setOnCheckedChangeListener(new a(viewGroup, viewGroup2, activity, textView3));
        materialCardView.setCardBackgroundColor(getBackgroundColor());
        materialCardView2.setCardBackgroundColor(this.m_textColor);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.mq
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ToastAction.this.Z(materialCardView, materialCardView2, imageView, activity, view);
            }
        };
        textView.setOnClickListener(onClickListener);
        materialCardView.setOnClickListener(onClickListener);
        View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.nq
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ToastAction.this.b0(materialCardView, materialCardView2, activity, view);
            }
        };
        textView2.setOnClickListener(onClickListener2);
        materialCardView2.setOnClickListener(onClickListener2);
        checkBox2.setOnCheckedChangeListener(new b(imageView));
        button5.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.oq
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ToastAction.this.c0(editText2, checkBox, checkBox2, spinner, spinner2, spinner3, radioButton2, checkBox4, view);
            }
        });
        spinner.setSelection(this.m_duration);
        spinner2.setSelection(this.m_position);
        spinner3.setSelection(this.m_horizontalPosition);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.pq
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ToastAction.d0(activity, view);
            }
        });
        IconUtils.setImageOnImageView(getContext(), imageView, this.m_imageName, this.m_imagePackageName, this.m_imageResourceId, this.m_imageUri);
        String str = this.m_messageText;
        if (str != null) {
            editText = editText2;
            editText.setText(str);
            editText.setSelection(editText.length());
            button = button2;
            button.setEnabled(true);
        } else {
            button = button2;
            editText = editText2;
            button.setEnabled(false);
        }
        editText.addTextChangedListener(new c(button, editText));
        final EditText editText3 = editText;
        final EditText editText4 = editText;
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.qq
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ToastAction.this.e0(checkBox, checkBox2, editText3, spinner, spinner2, spinner3, radioButton2, checkBox3, checkBox4, appCompatDialog, view);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.rq
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.dismiss();
            }
        });
        final MagicText.MagicTextListener magicTextListener = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.action.sq
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                ToastAction.g0(editText4, magicTextPair);
            }
        };
        button4.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.tq
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ToastAction.this.h0(activity, magicTextListener, view);
            }
        });
        appCompatDialog.show();
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
        X(triggerContextInfo, this.m_messageText, this.m_displayIcon, this.m_tintIcon, this.m_imageUri, this.m_imagePackageName, this.m_imageName, this.m_imageResourceName, this.m_duration, this.m_position, this.m_horizontalPosition, this.m_textColor, getBackgroundColor(), this.useTextOnly, this.maintainSpaces, false);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean requiresCanDrawOverlays() {
        if (this.useTextOnly || Build.VERSION.SDK_INT < 30) {
            return false;
        }
        return true;
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public void setPossibleMagicText(String[] strArr) {
        if (strArr.length == 1) {
            this.m_messageText = strArr[0];
            return;
        }
        FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("SetPossibleMagicText incorrect array length (" + this.m_classType + ")"));
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeString(this.m_messageText);
        parcel.writeInt(this.m_backgroundColor);
        parcel.writeString(this.m_imageResourceName);
        parcel.writeString(this.m_imagePackageName);
        parcel.writeString(this.m_imageUri);
        parcel.writeString(this.m_imageName);
        parcel.writeInt(this.m_displayIcon ? 1 : 0);
        parcel.writeInt(this.m_tintIcon ? 1 : 0);
        parcel.writeInt(this.m_duration);
        parcel.writeInt(this.m_position);
        parcel.writeInt(this.m_horizontalPosition);
        parcel.writeInt(this.m_textColor);
        parcel.writeInt(this.useTextOnly ? 1 : 0);
        parcel.writeInt(this.cancelPrevious ? 1 : 0);
        parcel.writeInt(this.maintainSpaces ? 1 : 0);
    }

    public ToastAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private ToastAction() {
        this.m_textColor = -1;
        this.m_imageResourceName = "launcher_no_border";
        this.m_imagePackageName = BuildConfig.APPLICATION_ID;
        this.m_imageName = "launcher_no_border";
        this.useTextOnly = true;
    }

    private ToastAction(Parcel parcel) {
        super(parcel);
        this.m_textColor = -1;
        this.m_imageResourceName = "launcher_no_border";
        this.m_imagePackageName = BuildConfig.APPLICATION_ID;
        this.m_imageName = "launcher_no_border";
        this.useTextOnly = true;
        this.m_messageText = parcel.readString();
        this.m_backgroundColor = parcel.readInt();
        this.m_imageResourceName = parcel.readString();
        this.m_imagePackageName = parcel.readString();
        this.m_imageUri = parcel.readString();
        this.m_imageName = parcel.readString();
        this.m_displayIcon = parcel.readInt() != 0;
        this.m_tintIcon = parcel.readInt() != 0;
        this.m_duration = parcel.readInt();
        this.m_position = parcel.readInt();
        this.m_horizontalPosition = parcel.readInt();
        this.m_textColor = parcel.readInt();
        this.useTextOnly = parcel.readInt() != 0;
        this.cancelPrevious = parcel.readInt() != 0;
        this.maintainSpaces = parcel.readInt() != 0;
    }

    /* loaded from: classes2.dex */
    class c implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Button f2669a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f2670b;

        c(Button button, EditText editText) {
            this.f2669a = button;
            this.f2670b = editText;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            boolean z3;
            Button button = this.f2669a;
            if (this.f2670b.getText().length() > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            button.setEnabled(z3);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        }
    }
}
