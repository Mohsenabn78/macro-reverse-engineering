package com.arlosoft.macrodroid.triggers;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialog;
import androidx.core.content.ContextCompat;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.events.EventBusUtils;
import com.arlosoft.macrodroid.events.FloatingButtonsUpdateEvent;
import com.arlosoft.macrodroid.interfaces.SupportsUserImages;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.activities.selecticon.IconSelectActivity;
import com.arlosoft.macrodroid.triggers.info.FloatingButtonTriggerInfo;
import com.arlosoft.macrodroid.triggers.services.FloatingButtonService;
import com.arlosoft.macrodroid.utils.FileUtils;
import com.melnykov.fab.FloatingActionButton;
import com.thebluealliance.spectrum.SpectrumDialog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class FloatingButtonTrigger extends Trigger implements SupportsUserImages {
    public static final Parcelable.Creator<FloatingButtonTrigger> CREATOR = new c();
    public static final int DEFAULT_PADDING_MINI = 16;
    public static final int DEFAULT_PADDING_NORMAL = 20;
    public static final int MAX_ICON_PADDING = 28;
    public static final int MAX_NEGATIVE_PADDING = 8;
    private static final int REQUEST_CODE_ICON_SELECT = 249232;
    public static final int SIZE_MINI = 1;
    public static final int SIZE_NORMAL = 0;
    private static int s_triggerCounter;
    private boolean disableTriggerOnRemove;
    private boolean forceLocation;
    private String identifier;
    private int m_alpha;
    private transient WeakReference<FloatingActionButton> m_fabRef;
    private int m_iconBgColor;
    private String m_imagePackageName;
    protected int m_imageResourceId;
    protected String m_imageResourceName;
    private String m_imageUri;
    private int m_padding;
    private transient WeakReference<SeekBar> m_paddingSeekBarRef;
    private boolean m_showOnLockScreen;
    private int m_size;
    private boolean m_transparentBackground;
    private transient boolean normalSizeSelected;
    private int overridenAlpha;
    private int overridenBgColor;
    private int overridenSize;
    private boolean overridenTransparentBackground;
    private boolean preventRemoveByDrag;
    private boolean usePercentForLocation;
    private int xLocation;
    private int yLocation;

    /* loaded from: classes3.dex */
    class c implements Parcelable.Creator<FloatingButtonTrigger> {
        c() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public FloatingButtonTrigger createFromParcel(Parcel parcel) {
            return new FloatingButtonTrigger(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public FloatingButtonTrigger[] newArray(int i4) {
            return new FloatingButtonTrigger[i4];
        }
    }

    /* synthetic */ FloatingButtonTrigger(Parcel parcel, a aVar) {
        this(parcel);
    }

    private void W() {
        int i4;
        boolean z3;
        int i5;
        final Activity activity = getActivity();
        final AppCompatDialog appCompatDialog = new AppCompatDialog(activity, getDialogTheme());
        appCompatDialog.setContentView(R.layout.dialog_floating_button);
        appCompatDialog.setTitle(getName());
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
        layoutParams.width = -1;
        appCompatDialog.getWindow().setAttributes(layoutParams);
        Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        Button button3 = (Button) appCompatDialog.findViewById(R.id.floating_button_change_background);
        Button button4 = (Button) appCompatDialog.findViewById(R.id.floating_button_change_icon);
        final SeekBar seekBar = (SeekBar) appCompatDialog.findViewById(R.id.floating_button_alpha_seekbar);
        final SeekBar seekBar2 = (SeekBar) appCompatDialog.findViewById(R.id.padding_seekbar);
        TextView textView = (TextView) appCompatDialog.findViewById(R.id.alpha_percent_text);
        final RadioButton radioButton = (RadioButton) appCompatDialog.findViewById(R.id.normal_size);
        RadioButton radioButton2 = (RadioButton) appCompatDialog.findViewById(R.id.mini_size);
        final CheckBox checkBox = (CheckBox) appCompatDialog.findViewById(R.id.show_on_lock_screen);
        ImageView imageView = (ImageView) appCompatDialog.findViewById(R.id.floating_button_image);
        final FloatingActionButton floatingActionButton = (FloatingActionButton) appCompatDialog.findViewById(R.id.fab);
        final CheckBox checkBox2 = (CheckBox) appCompatDialog.findViewById(R.id.transparent_background_checkbox);
        final CheckBox checkBox3 = (CheckBox) appCompatDialog.findViewById(R.id.force_location_on_enable);
        final EditText editText = (EditText) appCompatDialog.findViewById(R.id.x_location);
        final EditText editText2 = (EditText) appCompatDialog.findViewById(R.id.y_location);
        final Spinner spinner = (Spinner) appCompatDialog.findViewById(R.id.disable_options_spinner);
        final EditText editText3 = (EditText) appCompatDialog.findViewById(R.id.identifier_text);
        final RadioButton radioButton3 = (RadioButton) appCompatDialog.findViewById(R.id.radioButtonPixels);
        final RadioButton radioButton4 = (RadioButton) appCompatDialog.findViewById(R.id.radioButtonPercent);
        final CheckBox checkBox4 = (CheckBox) appCompatDialog.findViewById(R.id.prevent_removal_by_bin);
        editText3.setText(this.identifier);
        radioButton3.setChecked(!this.usePercentForLocation);
        radioButton4.setChecked(this.usePercentForLocation);
        checkBox4.setChecked(this.preventRemoveByDrag);
        checkBox4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.triggers.v2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
                FloatingButtonTrigger.Y(spinner, compoundButton, z4);
            }
        });
        if (this.preventRemoveByDrag) {
            i4 = 8;
        } else {
            i4 = 0;
        }
        spinner.setVisibility(i4);
        checkBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.triggers.w2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
                FloatingButtonTrigger.Z(editText, editText2, radioButton3, radioButton4, compoundButton, z4);
            }
        });
        editText.setEnabled(this.forceLocation);
        editText2.setEnabled(this.forceLocation);
        radioButton3.setEnabled(this.forceLocation);
        radioButton4.setEnabled(this.forceLocation);
        editText.setText(String.valueOf(this.xLocation));
        editText2.setText(String.valueOf(this.yLocation));
        checkBox3.setChecked(this.forceLocation);
        this.m_fabRef = new WeakReference<>(floatingActionButton);
        this.m_paddingSeekBarRef = new WeakReference<>(seekBar2);
        int i6 = this.m_size;
        if (i6 == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.normalSizeSelected = z3;
        if (i6 == 0) {
            radioButton.setChecked(true);
            floatingActionButton.setType(0);
        } else {
            radioButton2.setChecked(true);
            floatingActionButton.setType(1);
        }
        checkBox2.setChecked(this.m_transparentBackground);
        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.triggers.x2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
                FloatingButtonTrigger.this.a0(floatingActionButton, compoundButton, z4);
            }
        });
        spinner.setSelection(this.disableTriggerOnRemove ? 1 : 0);
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.y2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FloatingButtonTrigger.this.c0(floatingActionButton, activity, view);
            }
        });
        seekBar2.setMax(28);
        seekBar2.setProgress(this.m_padding);
        seekBar2.setOnSeekBarChangeListener(new a(floatingActionButton, seekBar2));
        seekBar.setProgress(this.m_alpha);
        textView.setText(this.m_alpha + "%");
        imageView.setAlpha(((float) this.m_alpha) / 100.0f);
        checkBox.setChecked(this.m_showOnLockScreen);
        if (Build.VERSION.SDK_INT >= 26) {
            checkBox.setVisibility(8);
        }
        seekBar.setOnSeekBarChangeListener(new b(textView, floatingActionButton));
        radioButton2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.triggers.z2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
                FloatingButtonTrigger.this.d0(floatingActionButton, seekBar2, compoundButton, z4);
            }
        });
        i0(floatingActionButton, this.m_padding);
        if (this.m_transparentBackground) {
            i5 = 0;
        } else {
            i5 = this.m_iconBgColor;
        }
        floatingActionButton.setColorNormal(i5);
        button4.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.a3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FloatingButtonTrigger.e0(activity, view);
            }
        });
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.b3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FloatingButtonTrigger.this.f0(appCompatDialog, seekBar, seekBar2, radioButton, checkBox, checkBox2, checkBox3, spinner, editText3, radioButton4, checkBox4, editText, editText2, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.c3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.dismiss();
            }
        });
        appCompatDialog.show();
    }

    private int X() {
        if (this.normalSizeSelected) {
            return 20;
        }
        return 16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Y(Spinner spinner, CompoundButton compoundButton, boolean z3) {
        int i4;
        if (z3) {
            i4 = 8;
        } else {
            i4 = 0;
        }
        spinner.setVisibility(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Z(EditText editText, EditText editText2, RadioButton radioButton, RadioButton radioButton2, CompoundButton compoundButton, boolean z3) {
        editText.setEnabled(z3);
        editText2.setEnabled(z3);
        radioButton.setEnabled(z3);
        radioButton2.setEnabled(z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a0(FloatingActionButton floatingActionButton, CompoundButton compoundButton, boolean z3) {
        int i4;
        if (z3) {
            i4 = 0;
        } else {
            i4 = this.m_iconBgColor;
        }
        floatingActionButton.setColorNormal(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0(FloatingActionButton floatingActionButton, boolean z3, int i4) {
        if (z3) {
            this.m_iconBgColor = i4;
            floatingActionButton.setColorNormal(i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c0(final FloatingActionButton floatingActionButton, Activity activity, View view) {
        new SpectrumDialog.Builder(getContext()).setTitle(R.string.select_color).setColors(R.array.notification_colors).setSelectedColor(this.m_iconBgColor).setDismissOnColorSelected(true).setOutlineWidth(1).setOnColorSelectedListener(new SpectrumDialog.OnColorSelectedListener() { // from class: com.arlosoft.macrodroid.triggers.d3
            @Override // com.thebluealliance.spectrum.SpectrumDialog.OnColorSelectedListener
            public final void onColorSelected(boolean z3, int i4) {
                FloatingButtonTrigger.this.b0(floatingActionButton, z3, i4);
            }
        }).build().show(((AppCompatActivity) activity).getSupportFragmentManager(), "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d0(FloatingActionButton floatingActionButton, SeekBar seekBar, CompoundButton compoundButton, boolean z3) {
        floatingActionButton.setPadding(0, 0, 0, 0);
        floatingActionButton.setType(z3 ? 1 : 0);
        int h02 = (int) h0(seekBar.getProgress());
        floatingActionButton.setPadding(h02, h02, h02, h02);
        this.normalSizeSelected = !z3 ? 1 : 0;
        i0(floatingActionButton, seekBar.getProgress());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e0(Activity activity, View view) {
        Intent intent = new Intent(activity, IconSelectActivity.class);
        intent.putExtra(IconSelectActivity.EXTRA_DISPLAY_APP_ICONS, true);
        activity.startActivityForResult(intent, REQUEST_CODE_ICON_SELECT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f0(AppCompatDialog appCompatDialog, SeekBar seekBar, SeekBar seekBar2, RadioButton radioButton, CheckBox checkBox, CheckBox checkBox2, CheckBox checkBox3, Spinner spinner, EditText editText, RadioButton radioButton2, CheckBox checkBox4, EditText editText2, EditText editText3, View view) {
        int intValue;
        int intValue2;
        appCompatDialog.dismiss();
        this.m_alpha = seekBar.getProgress();
        this.m_padding = seekBar2.getProgress();
        boolean z3 = true;
        this.m_size = !radioButton.isChecked();
        this.m_showOnLockScreen = checkBox.isChecked();
        this.m_transparentBackground = checkBox2.isChecked();
        this.forceLocation = checkBox3.isChecked();
        if (spinner.getSelectedItemPosition() == 0) {
            z3 = false;
        }
        this.disableTriggerOnRemove = z3;
        this.identifier = editText.getText().toString();
        this.usePercentForLocation = radioButton2.isChecked();
        this.preventRemoveByDrag = checkBox4.isChecked();
        try {
            if (TextUtils.isEmpty(editText2.getText().toString())) {
                intValue2 = 0;
            } else {
                intValue2 = Integer.valueOf(editText2.getText().toString()).intValue();
            }
            this.xLocation = intValue2;
        } catch (Exception unused) {
            this.xLocation = 0;
        }
        try {
            if (TextUtils.isEmpty(editText3.getText().toString())) {
                intValue = 0;
            } else {
                intValue = Integer.valueOf(editText3.getText().toString()).intValue();
            }
            this.yLocation = intValue;
        } catch (Exception unused2) {
            this.yLocation = 0;
        }
        itemComplete();
        EventBusUtils.getEventBus().post(new FloatingButtonsUpdateEvent());
    }

    private float h0(float f4) {
        return f4 * getContext().getResources().getDisplayMetrics().density;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i0(FloatingActionButton floatingActionButton, int i4) {
        int i5;
        int h02 = (int) h0(i4 - 8);
        floatingActionButton.setPadding(h02, h02, h02, h02);
        String str = this.m_imageUri;
        if (str != null) {
            floatingActionButton.setImageURI(Uri.parse(str));
            return;
        }
        String str2 = this.m_imagePackageName;
        if (str2 == null) {
            if (this.m_imageResourceName != null) {
                i5 = Util.getResId(getContext(), this.m_imageResourceName);
            } else {
                i5 = -1;
            }
            if (i5 != -1) {
                floatingActionButton.setImageResource(i5);
                return;
            }
            int i6 = this.m_imageResourceId;
            if (i6 == 0) {
                floatingActionButton.setImageResource(R.drawable.not_icon_setup);
            } else {
                floatingActionButton.setImageResource(i6);
            }
        } else if (str2.equals(Constants.USER_ICON_OPTION_PACKAGE)) {
            Bitmap decodeBitmapFromUserIconFile = FileUtils.decodeBitmapFromUserIconFile(this.m_imageResourceName);
            if (decodeBitmapFromUserIconFile != null) {
                floatingActionButton.setImageBitmap(decodeBitmapFromUserIconFile);
            } else {
                floatingActionButton.setImageResource(R.drawable.launcher_no_border);
            }
        } else {
            Drawable drawableFromPackageWithName = Util.getDrawableFromPackageWithName(getContext(), this.m_imagePackageName, this.m_imageResourceName);
            if (drawableFromPackageWithName == null) {
                drawableFromPackageWithName = Util.getDrawableFromPackage(getContext(), this.m_imagePackageName, this.m_imageResourceId);
            }
            if (drawableFromPackageWithName != null) {
                floatingActionButton.setImageDrawable(drawableFromPackageWithName);
            } else {
                floatingActionButton.setImageResource(R.drawable.not_icon_setup);
            }
        }
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    protected void disableTrigger() {
        int i4 = s_triggerCounter - 1;
        s_triggerCounter = i4;
        if (i4 < 0) {
            s_triggerCounter = 0;
        }
        if (s_triggerCounter == 0) {
            getContext().stopService(new Intent(getContext(), FloatingButtonService.class));
        } else {
            EventBusUtils.getEventBus().post(new FloatingButtonsUpdateEvent());
        }
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    protected void enableTrigger() {
        int i4 = s_triggerCounter + 1;
        s_triggerCounter = i4;
        if (i4 == 1) {
            getContext().startService(new Intent(getContext(), FloatingButtonService.class));
        } else {
            EventBusUtils.getEventBus().post(new FloatingButtonsUpdateEvent());
        }
    }

    public int getAlpha() {
        return this.m_alpha;
    }

    public int getBackgroundColor() {
        if (this.m_transparentBackground) {
            return 0;
        }
        return this.m_iconBgColor;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        return this.identifier;
    }

    public boolean getForceStartLocationIsPercent() {
        return this.usePercentForLocation;
    }

    @Nullable
    public Point getForcedStartLocation() {
        if (this.forceLocation) {
            return new Point(this.xLocation, this.yLocation);
        }
        return null;
    }

    @Nullable
    public String getIdentifier() {
        return this.identifier;
    }

    public String getImagePackageName() {
        return this.m_imagePackageName;
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsUserImages
    @Nullable
    public List<String> getImagePaths() {
        String str = this.m_imagePackageName;
        if (str != null && str.equals(Constants.USER_ICON_OPTION_PACKAGE)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.m_imageResourceName);
            return arrayList;
        }
        return null;
    }

    public int getImageResourceId() {
        return this.m_imageResourceId;
    }

    public String getImageResourceName() {
        return this.m_imageResourceName;
    }

    public String getImageUri() {
        return this.m_imageUri;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return FloatingButtonTriggerInfo.getInstance();
    }

    public boolean getIsDisableTriggerOnRemove() {
        return this.disableTriggerOnRemove;
    }

    public int getPadding() {
        return this.m_padding;
    }

    public boolean getPreventRemoveByDrag() {
        return this.preventRemoveByDrag;
    }

    public boolean getShowOnLockScreen() {
        return this.m_showOnLockScreen;
    }

    public int getSize() {
        return this.m_size;
    }

    public boolean getTransparentBackground() {
        return this.m_transparentBackground;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleActivityResult(Activity activity, int i4, int i5, Intent intent) {
        WeakReference<FloatingActionButton> weakReference;
        setActivity(activity);
        if (i4 == REQUEST_CODE_ICON_SELECT && i5 != 0 && (weakReference = this.m_fabRef) != null) {
            FloatingActionButton floatingActionButton = weakReference.get();
            SeekBar seekBar = this.m_paddingSeekBarRef.get();
            if (floatingActionButton != null && seekBar != null) {
                this.m_imageResourceId = intent.getIntExtra(Util.DRAWABLE_ID_EXTRA, 0);
                this.m_imageResourceName = intent.getStringExtra(Util.DRAWABLE_NAME_EXTRA);
                this.m_imagePackageName = intent.getStringExtra(Util.DRAWABLE_PACKAGE_NAME_EXTRA);
                Uri data = intent.getData();
                if (data != null) {
                    this.m_imageUri = data.toString();
                }
                this.m_padding = X();
                seekBar.setProgress(X());
                i0(floatingActionButton, this.m_padding);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        W();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean requiresCanDrawOverlays() {
        return true;
    }

    public void setAlpha(int i4) {
        this.m_alpha = i4;
    }

    public void setBackgroundColor(int i4) {
        this.m_iconBgColor = i4;
    }

    public void setImageData(String str, String str2, int i4, String str3) {
        this.m_imagePackageName = str;
        this.m_imageResourceName = str2;
        this.m_imageResourceId = i4;
        this.m_imageUri = str3;
    }

    public void setImageOnFloatingView(FloatingActionButton floatingActionButton) {
        i0(floatingActionButton, this.m_padding);
    }

    public void setPadding(int i4) {
        this.m_padding = i4;
    }

    public void setSize(int i4) {
        this.m_size = i4;
    }

    public void setTransparentBackground(boolean z3) {
        this.m_transparentBackground = z3;
    }

    public void setUsePercentForLocation(boolean z3) {
        this.usePercentForLocation = z3;
    }

    public void setXYLocation(int i4, int i5) {
        this.xLocation = i4;
        this.yLocation = i5;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_iconBgColor);
        parcel.writeInt(this.overridenBgColor);
        parcel.writeString(this.m_imageResourceName);
        parcel.writeString(this.m_imagePackageName);
        parcel.writeString(this.m_imageUri);
        parcel.writeInt(this.m_alpha);
        parcel.writeInt(this.overridenAlpha);
        parcel.writeInt(this.m_size);
        parcel.writeInt(this.overridenSize);
        parcel.writeInt(this.m_showOnLockScreen ? 1 : 0);
        parcel.writeInt(this.m_padding);
        parcel.writeInt(this.m_transparentBackground ? 1 : 0);
        parcel.writeInt(this.overridenTransparentBackground ? 1 : 0);
        parcel.writeInt(this.forceLocation ? 1 : 0);
        parcel.writeInt(this.xLocation);
        parcel.writeInt(this.yLocation);
        parcel.writeInt(this.disableTriggerOnRemove ? 1 : 0);
        parcel.writeString(this.identifier);
        parcel.writeInt(this.usePercentForLocation ? 1 : 0);
        parcel.writeInt(this.preventRemoveByDrag ? 1 : 0);
    }

    public FloatingButtonTrigger(Activity activity, Macro macro) {
        this();
        this.m_macro = macro;
        setActivity(activity);
    }

    public FloatingButtonTrigger() {
        this.identifier = "";
        this.m_padding = 20;
        this.normalSizeSelected = true;
        this.preventRemoveByDrag = false;
        this.m_alpha = 100;
        this.m_iconBgColor = ContextCompat.getColor(getContext(), R.color.md_grey_600);
    }

    private FloatingButtonTrigger(Parcel parcel) {
        super(parcel);
        this.identifier = "";
        this.m_padding = 20;
        this.normalSizeSelected = true;
        this.preventRemoveByDrag = false;
        this.m_iconBgColor = parcel.readInt();
        this.overridenBgColor = parcel.readInt();
        this.m_imageResourceName = parcel.readString();
        this.m_imagePackageName = parcel.readString();
        this.m_imageUri = parcel.readString();
        this.m_alpha = parcel.readInt();
        this.overridenAlpha = parcel.readInt();
        this.m_size = parcel.readInt();
        this.overridenSize = parcel.readInt();
        this.m_showOnLockScreen = parcel.readInt() != 0;
        this.m_padding = parcel.readInt();
        this.m_transparentBackground = parcel.readInt() != 0;
        this.overridenTransparentBackground = parcel.readInt() != 0;
        this.forceLocation = parcel.readInt() != 0;
        this.xLocation = parcel.readInt();
        this.yLocation = parcel.readInt();
        this.disableTriggerOnRemove = parcel.readInt() != 0;
        this.identifier = parcel.readString();
        this.usePercentForLocation = parcel.readInt() != 0;
        this.preventRemoveByDrag = parcel.readInt() != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements SeekBar.OnSeekBarChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FloatingActionButton f14360a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ SeekBar f14361b;

        a(FloatingActionButton floatingActionButton, SeekBar seekBar) {
            this.f14360a = floatingActionButton;
            this.f14361b = seekBar;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i4, boolean z3) {
            FloatingButtonTrigger.this.i0(this.f14360a, this.f14361b.getProgress());
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements SeekBar.OnSeekBarChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TextView f14363a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ FloatingActionButton f14364b;

        b(TextView textView, FloatingActionButton floatingActionButton) {
            this.f14363a = textView;
            this.f14364b = floatingActionButton;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i4, boolean z3) {
            if (z3) {
                TextView textView = this.f14363a;
                textView.setText(i4 + "%");
                this.f14364b.setAlpha(((float) i4) / 100.0f);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }
}
