package com.arlosoft.macrodroid.triggers;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.view.WindowManager;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatDialog;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.AndroidWearIconAdapter;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.info.AndroidWearTriggerInfo;
import com.arlosoft.macrodroid.utils.FontAwesomeHelper;
import com.jaredrummler.android.colorpicker.ColorPickerDialog;
import com.jaredrummler.android.colorpicker.ColorPickerDialogListener;

/* loaded from: classes3.dex */
public class AndroidWearTrigger extends Trigger {
    public static final Parcelable.Creator<AndroidWearTrigger> CREATOR = new c();
    public static final int OPTION_ANDROID_WEAR_APP = 0;
    public static final int OPTION_ANDROID_WEAR_CONNECTED = 1;
    public static final int OPTION_ANDROID_WEAR_DISCONNECTED = 2;
    private static int s_triggerCounter = 0;
    public static boolean usingAndroidWear = false;
    private int iconBgColor;
    private int m_option;
    private String m_resourceName;

    /* loaded from: classes3.dex */
    class c implements Parcelable.Creator<AndroidWearTrigger> {
        c() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AndroidWearTrigger createFromParcel(Parcel parcel) {
            return new AndroidWearTrigger(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public AndroidWearTrigger[] newArray(int i4) {
            return new AndroidWearTrigger[i4];
        }
    }

    /* synthetic */ AndroidWearTrigger(Parcel parcel, a aVar) {
        this(parcel);
    }

    private void O() {
        AppCompatDialog appCompatDialog = new AppCompatDialog(getActivity(), getDialogTheme());
        appCompatDialog.setContentView(R.layout.select_icon_android_wear);
        appCompatDialog.setTitle(R.string.select_icon);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
        layoutParams.width = -1;
        appCompatDialog.getWindow().setAttributes(layoutParams);
        AndroidWearIconAdapter androidWearIconAdapter = new AndroidWearIconAdapter(getContext(), FontAwesomeHelper.RESOURCE_NAMES, getIconBgColor(), new a(appCompatDialog));
        View findViewById = appCompatDialog.findViewById(R.id.colorSelector);
        findViewById.setBackgroundColor(getIconBgColor());
        findViewById.setOnClickListener(new b(findViewById, androidWearIconAdapter));
        ((ListView) appCompatDialog.findViewById(R.id.select_icon_list)).setAdapter((ListAdapter) androidWearIconAdapter);
        appCompatDialog.show();
    }

    private String[] getOptions() {
        return new String[]{SelectableItem.r(R.string.trigger_android_wear_app), SelectableItem.r(R.string.trigger_android_wear_connect), SelectableItem.r(R.string.trigger_android_wear_disconnect)};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.m_option = i4;
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void disableTrigger() {
        s_triggerCounter--;
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void enableTrigger() {
        s_triggerCounter++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return this.m_option;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        return getOptions()[this.m_option];
    }

    public int getIconBgColor() {
        int i4 = this.iconBgColor;
        if (i4 == 0) {
            return ContextCompat.getColor(getContext(), R.color.default_wear_os_icon_bg_color);
        }
        return i4;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return AndroidWearTriggerInfo.getInstance();
    }

    public int getOption() {
        return this.m_option;
    }

    public String getResourceName() {
        return this.m_resourceName;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return getOptions();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.triggers.Trigger, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        if (this.m_option == 0) {
            O();
        } else {
            itemComplete();
        }
    }

    public void setAndroidWearAppOption() {
        this.m_option = 0;
        O();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_option);
        parcel.writeString(this.m_resourceName);
        parcel.writeInt(this.iconBgColor);
    }

    public AndroidWearTrigger(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public AndroidWearTrigger() {
        usingAndroidWear = true;
    }

    private AndroidWearTrigger(Parcel parcel) {
        super(parcel);
        this.m_option = parcel.readInt();
        this.m_resourceName = parcel.readString();
        this.iconBgColor = parcel.readInt();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f14314a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AndroidWearIconAdapter f14315b;

        b(View view, AndroidWearIconAdapter androidWearIconAdapter) {
            this.f14314a = view;
            this.f14315b = androidWearIconAdapter;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ColorPickerDialog create = ColorPickerDialog.newBuilder().setColor(AndroidWearTrigger.this.getIconBgColor()).setDialogType(1).setPresets(AndroidWearTrigger.this.getContext().getResources().getIntArray(R.array.toast_colors)).setAllowCustom(true).setAllowPresets(false).create();
            create.setColorPickerDialogListener(new a());
            create.show(((FragmentActivity) AndroidWearTrigger.this.getActivity()).getSupportFragmentManager(), (String) null);
        }

        /* loaded from: classes3.dex */
        class a implements ColorPickerDialogListener {
            a() {
            }

            @Override // com.jaredrummler.android.colorpicker.ColorPickerDialogListener
            public void onColorSelected(int i4, int i5) {
                b.this.f14314a.setBackgroundColor(i5);
                AndroidWearTrigger.this.iconBgColor = i5;
                b.this.f14315b.setIconBgColor(i5);
            }

            @Override // com.jaredrummler.android.colorpicker.ColorPickerDialogListener
            public void onDialogDismissed(int i4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements AndroidWearIconAdapter.IconSelectedListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AppCompatDialog f14312a;

        a(AppCompatDialog appCompatDialog) {
            this.f14312a = appCompatDialog;
        }

        @Override // com.arlosoft.macrodroid.common.AndroidWearIconAdapter.IconSelectedListener
        public void iconSelected(String str) {
            AndroidWearTrigger.this.m_resourceName = str;
            this.f14312a.dismiss();
            AndroidWearTrigger.this.itemComplete();
        }

        @Override // com.arlosoft.macrodroid.common.AndroidWearIconAdapter.IconSelectedListener
        public void iconStringSelected(String str) {
        }
    }
}
