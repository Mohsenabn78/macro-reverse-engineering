package com.arlosoft.macrodroid.triggers;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.interfaces.SupportsMagicText;
import com.arlosoft.macrodroid.interfaces.SupportsUserImages;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.activities.WidgetConfigureActivity;
import com.arlosoft.macrodroid.triggers.info.WidgetPressedTriggerInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes3.dex */
public class WidgetPressedTrigger extends Trigger implements SupportsMagicText, SupportsUserImages {
    public static final Parcelable.Creator<WidgetPressedTrigger> CREATOR = new a();
    private static int REQUEST_CODE_WIDGET_CONFIGURE = 9823123;
    private String iconText;
    private String m_currentLabel;
    private int m_imageId;
    private String m_imagePackageName;
    private String m_imageResourceName;
    private String m_imageUri;
    private String m_widgetLabel;
    private int m_widgetType;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<WidgetPressedTrigger> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public WidgetPressedTrigger createFromParcel(Parcel parcel) {
            return new WidgetPressedTrigger(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public WidgetPressedTrigger[] newArray(int i4) {
            return new WidgetPressedTrigger[i4];
        }
    }

    /* synthetic */ WidgetPressedTrigger(Parcel parcel, a aVar) {
        this(parcel);
    }

    private int M(int i4) {
        int i5 = i4 - 1;
        if (i5 < 0) {
            return getWidgetTypes().length - 1;
        }
        return i5;
    }

    public static String[] getWidgetTypes() {
        return new String[]{SelectableItem.r(R.string.trigger_widget_pressed_custom), SelectableItem.r(R.string.trigger_widget_pressed_green), SelectableItem.r(R.string.trigger_widget_pressed_blue), SelectableItem.r(R.string.trigger_widget_pressed_red), SelectableItem.r(R.string.trigger_widget_pressed_yellow)};
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    protected void C(int i4) {
        this.m_widgetType = M(i4);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    protected int getCheckedItemIndex() {
        return (this.m_widgetType + 1) % getWidgetTypes().length;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        return SelectableItem.r(R.string.trigger_widget_pressed) + " (" + getWidgetTypes()[(this.m_widgetType + 1) % getWidgetTypes().length] + ")";
    }

    public String getCurrentWidgetLabel() {
        String str = this.m_currentLabel;
        if (str == null) {
            return getWidgetLabel();
        }
        return str;
    }

    public String getIconText() {
        return MagicText.replaceMagicText(getContext(), this.iconText, null, getMacro());
    }

    public String getImageName() {
        return this.m_imageResourceName;
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

    public int getImageResource() {
        return this.m_imageId;
    }

    public Uri getImageUri() {
        String str = this.m_imageUri;
        if (str != null) {
            return Uri.parse(str);
        }
        return null;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return WidgetPressedTriggerInfo.getInstance();
    }

    public String getPackageName() {
        return this.m_imagePackageName;
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public String[] getPossibleMagicText() {
        return new String[]{this.m_widgetLabel, this.iconText};
    }

    public String getWidgetLabel() {
        return MagicText.replaceMagicText(getContext(), this.m_widgetLabel, null, getMacro());
    }

    public int getWidgetType() {
        return this.m_widgetType;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleActivityResult(Activity activity, int i4, int i5, Intent intent) {
        setActivity(activity);
        if (i4 == REQUEST_CODE_WIDGET_CONFIGURE && i5 != 0) {
            this.m_imageId = intent.getIntExtra(Util.DRAWABLE_ID_EXTRA, 0);
            this.m_imageResourceName = intent.getStringExtra(Util.DRAWABLE_NAME_EXTRA);
            this.m_imagePackageName = intent.getStringExtra(Util.DRAWABLE_PACKAGE_NAME_EXTRA);
            this.m_widgetLabel = intent.getStringExtra(Util.WIDGET_TEXT_EXTRA);
            this.iconText = intent.getStringExtra(Util.ICON_TEXT_EXTRA);
            Uri data = intent.getData();
            if (data != null) {
                this.m_imageUri = data.toString();
            }
            itemComplete();
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    protected String[] o() {
        return (String[]) new ArrayList(Arrays.asList(getWidgetTypes())).toArray(new String[0]);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    protected String p() {
        return SelectableItem.r(R.string.trigger_widget_pressed_select);
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger, com.arlosoft.macrodroid.common.SelectableItem
    protected void secondaryItemConfirmed() {
        if (this.m_widgetType == 4) {
            Intent intent = new Intent(getContext(), WidgetConfigureActivity.class);
            String str = this.m_widgetLabel;
            if (str != null && str.length() > 0) {
                intent.putExtra(Util.WIDGET_TEXT_EXTRA, this.m_widgetLabel);
            }
            intent.putExtra(Util.DRAWABLE_ID_EXTRA, this.m_imageId);
            intent.putExtra(Util.DRAWABLE_PACKAGE_NAME_EXTRA, this.m_imagePackageName);
            intent.putExtra(Util.DRAWABLE_NAME_EXTRA, this.m_imageResourceName);
            intent.putExtra(Util.DRAWABLE_URI_EXTRA, this.m_imageUri);
            intent.putExtra(Util.ICON_TEXT_EXTRA, this.iconText);
            intent.putExtra("MacroId", getMacro().getId());
            getActivity().startActivityForResult(intent, REQUEST_CODE_WIDGET_CONFIGURE);
            return;
        }
        super.secondaryItemConfirmed();
    }

    public void setCurrentWidgetLabel(String str) {
        this.m_currentLabel = str;
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public void setPossibleMagicText(String[] strArr) {
        if (strArr.length == 2) {
            this.m_widgetLabel = strArr[0];
            this.iconText = strArr[1];
            return;
        }
        FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("SetPossibleMagicText incorrect array length (" + this.m_classType + ")"));
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_widgetType);
        parcel.writeString(this.m_widgetLabel);
        parcel.writeInt(this.m_imageId);
        parcel.writeString(this.m_imageResourceName);
        parcel.writeString(this.m_imagePackageName);
        parcel.writeString(this.m_imageUri);
        parcel.writeString(this.iconText);
    }

    public WidgetPressedTrigger(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private WidgetPressedTrigger() {
        this.m_widgetType = 4;
    }

    private WidgetPressedTrigger(Parcel parcel) {
        super(parcel);
        this.m_widgetType = parcel.readInt();
        this.m_widgetLabel = parcel.readString();
        this.m_imageId = parcel.readInt();
        this.m_imageResourceName = parcel.readString();
        this.m_imagePackageName = parcel.readString();
        this.m_imageUri = parcel.readString();
        this.iconText = parcel.readString();
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void disableTrigger() {
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void enableTrigger() {
    }
}
