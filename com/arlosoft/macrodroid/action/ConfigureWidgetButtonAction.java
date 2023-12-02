package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.ConfigureWidgetButtonActionInfo;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.interfaces.SupportsMagicText;
import com.arlosoft.macrodroid.interfaces.SupportsUserImages;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.triggers.Trigger;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.triggers.WidgetPressedTrigger;
import com.arlosoft.macrodroid.triggers.activities.WidgetConfigureActivity;
import com.arlosoft.macrodroid.triggers.receivers.widget.WidgetProviderCustom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import me.drakeet.support.toast.ToastCompat;

/* loaded from: classes2.dex */
public class ConfigureWidgetButtonAction extends Action implements SupportsMagicText, SupportsUserImages {
    public static final Parcelable.Creator<ConfigureWidgetButtonAction> CREATOR = new a();
    private static final int MACRO_ID_THIS_MACRO = -99;
    private static final int REQUEST_CODE_WIDGET_CONFIGURE = 12934543;
    private boolean m_faded;
    private String m_iconText;
    private String m_imagePackageName;
    private String m_imageResourceName;
    private String m_imageUri;
    private long m_macroId;
    private transient List<Long> m_macroIdList;
    private String m_optionName;
    private transient List<String> m_optionNames;
    private long m_triggerGUID;
    private transient List<Long> m_triggerGUIDList;
    private String m_widgetLabel;

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<ConfigureWidgetButtonAction> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ConfigureWidgetButtonAction createFromParcel(Parcel parcel) {
            return new ConfigureWidgetButtonAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public ConfigureWidgetButtonAction[] newArray(int i4) {
            return new ConfigureWidgetButtonAction[i4];
        }
    }

    /* synthetic */ ConfigureWidgetButtonAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    private WidgetPressedTrigger M() {
        Macro macroByGUID;
        if ((getMacro() != null && this.m_macroId == getMacro().getGUID()) || this.m_macroId == -99) {
            macroByGUID = getMacro();
        } else {
            macroByGUID = MacroStore.getInstance().getMacroByGUID(this.m_macroId);
        }
        if (macroByGUID == null) {
            macroByGUID = getMacro();
        }
        SelectableItem findChildByGUID = macroByGUID.findChildByGUID(this.m_triggerGUID);
        if (!(findChildByGUID instanceof WidgetPressedTrigger)) {
            return null;
        }
        return (WidgetPressedTrigger) findChildByGUID;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.m_triggerGUID = this.m_triggerGUIDList.get(i4).longValue();
        this.m_optionName = this.m_optionNames.get(i4);
        long longValue = this.m_macroIdList.get(i4).longValue();
        this.m_macroId = longValue;
        if (longValue == getMacroGuid().longValue()) {
            this.m_macroId = -99L;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        for (int i4 = 0; i4 < this.m_triggerGUIDList.size(); i4++) {
            if (this.m_triggerGUIDList.get(i4).longValue() == this.m_triggerGUID) {
                this.m_optionName = this.m_optionNames.get(i4);
                return i4;
            }
        }
        this.m_optionName = this.m_optionNames.get(0);
        long longValue = this.m_macroIdList.get(0).longValue();
        this.m_macroId = longValue;
        if (longValue == getMacroGuid().longValue()) {
            this.m_macroId = -99L;
        }
        this.m_triggerGUID = this.m_triggerGUIDList.get(0).longValue();
        return 0;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        return this.m_widgetLabel;
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
        return ConfigureWidgetButtonActionInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public String[] getPossibleMagicText() {
        return new String[]{this.m_widgetLabel, this.m_iconText};
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleActivityResult(Activity activity, int i4, int i5, Intent intent) {
        setActivity(activity);
        if (i4 == REQUEST_CODE_WIDGET_CONFIGURE && i5 != 0) {
            this.m_imageResourceName = intent.getStringExtra(Util.DRAWABLE_NAME_EXTRA);
            this.m_imagePackageName = intent.getStringExtra(Util.DRAWABLE_PACKAGE_NAME_EXTRA);
            this.m_widgetLabel = intent.getStringExtra(Util.WIDGET_TEXT_EXTRA);
            this.m_faded = intent.getBooleanExtra(Util.FADED_IMAGE_EXTRA, false);
            this.m_iconText = intent.getStringExtra(Util.ICON_TEXT_EXTRA);
            Uri data = intent.getData();
            if (data != null) {
                this.m_imageUri = data.toString();
            }
            itemComplete();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        String[] o4 = o();
        if (o4 != null && o4.length > 0) {
            k();
        }
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
        String replaceMagicText = MagicText.replaceMagicText(getContext(), this.m_widgetLabel, triggerContextInfo, getMacro());
        String replaceMagicText2 = MagicText.replaceMagicText(getContext(), this.m_iconText, triggerContextInfo, getMacro());
        WidgetPressedTrigger M = M();
        if (M != null) {
            M.setCurrentWidgetLabel(replaceMagicText);
            long j4 = this.m_macroId;
            if (j4 == -99) {
                j4 = getMacroGuid().longValue();
            }
            WidgetProviderCustom.updateMyWidgets(getContext(), null, j4, replaceMagicText, this.m_imageResourceName, this.m_imagePackageName, this.m_imageUri, this.m_faded, replaceMagicText2);
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean isValid() {
        if (M() != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        boolean z3;
        List<Macro> allCompletedMacrosSorted = MacroStore.getInstance().getAllCompletedMacrosSorted(false);
        this.m_triggerGUIDList = new ArrayList();
        this.m_macroIdList = new ArrayList();
        this.m_optionNames = new ArrayList();
        Iterator<Macro> it = allCompletedMacrosSorted.iterator();
        while (true) {
            if (it.hasNext()) {
                if (it.next().getGUID() == getMacro().getGUID()) {
                    z3 = true;
                    break;
                }
            } else {
                z3 = false;
                break;
            }
        }
        if (!z3) {
            allCompletedMacrosSorted.add(0, getMacro());
        }
        for (Macro macro : allCompletedMacrosSorted) {
            Iterator<Trigger> it2 = macro.getTriggerList().iterator();
            while (it2.hasNext()) {
                Trigger next = it2.next();
                if (next instanceof WidgetPressedTrigger) {
                    WidgetPressedTrigger widgetPressedTrigger = (WidgetPressedTrigger) next;
                    if (widgetPressedTrigger.getWidgetType() == 4) {
                        this.m_optionNames.add(macro.getName() + " (" + widgetPressedTrigger.getWidgetLabel() + ")");
                        this.m_macroIdList.add(Long.valueOf(next.getMacro().getGUID()));
                        this.m_triggerGUIDList.add(Long.valueOf(next.getSIGUID()));
                    }
                }
            }
        }
        if (this.m_optionNames.size() == 0) {
            ToastCompat.makeText(getContext().getApplicationContext(), (int) R.string.no_custom_widget_buttons_found, 0).show();
        }
        return (String[]) this.m_optionNames.toArray(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        WidgetPressedTrigger M;
        if (this.m_widgetLabel == null && (M = M()) != null) {
            this.m_widgetLabel = M.getWidgetLabel();
            this.m_imageResourceName = M.getImageName();
            this.m_imagePackageName = M.getPackageName();
            this.m_iconText = M.getIconText();
            Uri imageUri = M.getImageUri();
            if (imageUri != null) {
                this.m_imageUri = imageUri.toString();
            }
        }
        Intent intent = new Intent(getContext(), WidgetConfigureActivity.class);
        String str = this.m_widgetLabel;
        if (str != null && str.length() > 0) {
            intent.putExtra(Util.WIDGET_TEXT_EXTRA, this.m_widgetLabel);
        }
        intent.putExtra(WidgetConfigureActivity.ITEM_TYPE_EXTRA, 1);
        intent.putExtra(Util.DRAWABLE_PACKAGE_NAME_EXTRA, this.m_imagePackageName);
        intent.putExtra(Util.DRAWABLE_NAME_EXTRA, this.m_imageResourceName);
        intent.putExtra(Util.DRAWABLE_URI_EXTRA, this.m_imageUri);
        intent.putExtra(WidgetConfigureActivity.SHOW_FADED_IMAGE_EXTRA, true);
        intent.putExtra(Util.FADED_IMAGE_EXTRA, this.m_faded);
        intent.putExtra("MacroId", getMacro().getId());
        intent.putExtra(Util.ICON_TEXT_EXTRA, this.m_iconText);
        getActivity().startActivityForResult(intent, REQUEST_CODE_WIDGET_CONFIGURE);
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public void setPossibleMagicText(String[] strArr) {
        if (strArr.length == 2) {
            this.m_widgetLabel = strArr[0];
            this.m_iconText = strArr[1];
            return;
        }
        FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("SetPossibleMagicText incorrect array length (" + this.m_classType + ")"));
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void templateSelected() {
        if (M() == null) {
            for (Trigger trigger : getMacro().getTriggerList()) {
                if (trigger instanceof WidgetPressedTrigger) {
                    this.m_triggerGUID = trigger.getSIGUID();
                }
            }
        }
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeLong(this.m_triggerGUID);
        parcel.writeLong(this.m_macroId);
        parcel.writeString(this.m_widgetLabel);
        parcel.writeString(this.m_imageResourceName);
        parcel.writeString(this.m_imagePackageName);
        parcel.writeString(this.m_imageUri);
        parcel.writeInt(this.m_faded ? 1 : 0);
        parcel.writeString(this.m_iconText);
    }

    public ConfigureWidgetButtonAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public ConfigureWidgetButtonAction() {
    }

    private ConfigureWidgetButtonAction(Parcel parcel) {
        super(parcel);
        this.m_triggerGUID = parcel.readLong();
        this.m_macroId = parcel.readLong();
        this.m_widgetLabel = parcel.readString();
        this.m_imageResourceName = parcel.readString();
        this.m_imagePackageName = parcel.readString();
        this.m_imageUri = parcel.readString();
        this.m_faded = parcel.readInt() != 0;
        this.m_iconText = parcel.readString();
    }
}
