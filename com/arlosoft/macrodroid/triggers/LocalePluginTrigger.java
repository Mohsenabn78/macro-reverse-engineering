package com.arlosoft.macrodroid.triggers;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Size;
import androidx.appcompat.app.AlertDialog;
import androidx.core.util.Pair;
import com.afollestad.materialdialogs.MaterialDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.MacroDroidVariable;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.interfaces.HasVariables;
import com.arlosoft.macrodroid.interfaces.VariableNameUpdater;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.taskerplugin.ArrayHandlingOption;
import com.arlosoft.macrodroid.taskerplugin.PluginSelectedHandler;
import com.arlosoft.macrodroid.taskerplugin.TaskerPluginHelper;
import com.arlosoft.macrodroid.taskerplugin.TaskerVariableData;
import com.arlosoft.macrodroid.taskerplugin.TaskerVariableHandler;
import com.arlosoft.macrodroid.taskerplugin.TaskerVariableHelper;
import com.arlosoft.macrodroid.triggers.info.LocalePluginTriggerInfo;
import com.arlosoft.macrodroid.triggers.receivers.LocalePluginTriggerReceiver;
import com.arlosoft.macrodroid.widget.ItemFinishedListener;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.twofortyfouram.locale.api.Intent;
import com.twofortyfouram.locale.sdk.host.api.Condition;
import com.twofortyfouram.locale.sdk.host.api.Event;
import com.twofortyfouram.locale.sdk.host.api.PluginRegistry;
import com.twofortyfouram.locale.sdk.host.model.Plugin;
import com.twofortyfouram.locale.sdk.host.model.PluginErrorEdit;
import com.twofortyfouram.locale.sdk.host.model.PluginInstanceData;
import com.twofortyfouram.locale.sdk.host.model.PluginType;
import com.twofortyfouram.locale.sdk.host.ui.fragment.AbstractPluginEditFragment;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import me.drakeet.support.toast.ToastCompat;
import rx.Observable;
import rx.Subscriber;
import rx.android.app.AppObservable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/* loaded from: classes3.dex */
public class LocalePluginTrigger extends Trigger implements TaskerVariableHandler, PluginSelectedHandler, HasVariables, VariableNameUpdater {
    public static final Parcelable.Creator<LocalePluginTrigger> CREATOR = new b();
    private static LocalePluginTrigger s_currentTrigger;
    private static LocalePluginTriggerReceiver s_localePluginTriggerReceiver;
    private static int s_triggerCounter;
    private int arrayHandlingOption;
    private transient Condition condition;
    private transient Event event;
    private boolean m_invertCondition;
    private Plugin m_plugin;
    private PluginInstanceData m_pluginInstanceData;
    private transient Map<String, Plugin> m_pluginMap;
    private transient int m_previousState;
    private transient boolean m_shownToastError;
    private Map<String, String> m_variableMap;

    /* loaded from: classes3.dex */
    public static class PluginEditFragment extends AbstractPluginEditFragment {
        @Override // com.twofortyfouram.locale.sdk.host.ui.fragment.IPluginEditFragment
        public void handleCancel(@NonNull Plugin plugin) {
            if (getActivity() instanceof ItemFinishedListener) {
                ((ItemFinishedListener) getActivity()).itemCancelled();
            }
        }

        @Override // com.twofortyfouram.locale.sdk.host.ui.fragment.IPluginEditFragment
        public void handleErrors(@NonNull Plugin plugin, @NonNull @Size(min = 1) EnumSet<PluginErrorEdit> enumSet) {
            StringBuilder sb = new StringBuilder();
            Iterator<E> it = enumSet.iterator();
            while (it.hasNext()) {
                sb.append(((PluginErrorEdit) it.next()).getDeveloperExplanation());
                sb.append("\n");
            }
            ToastCompat.makeText(getActivity().getApplicationContext(), (CharSequence) sb.toString(), 1).show();
        }

        @Override // com.twofortyfouram.locale.sdk.host.ui.fragment.IPluginEditFragment
        public void handleSave(@NonNull Plugin plugin, @NonNull PluginInstanceData pluginInstanceData, @Nullable String[] strArr) {
            if (getActivity() instanceof ItemFinishedListener) {
                if (strArr != null && strArr.length > 0) {
                    new TaskerVariableHelper().showVariableList(getActivity(), LocalePluginTrigger.s_currentTrigger, strArr, LocalePluginTrigger.s_currentTrigger, new Pair<>(plugin, pluginInstanceData), LocalePluginTrigger.s_currentTrigger.getArrayHandlingOption(), true, false);
                    return;
                }
                ((ItemFinishedListener) getActivity()).itemComplete(new TaskerVariableData(new Pair(plugin, pluginInstanceData), LocalePluginTrigger.s_currentTrigger.getArrayHandlingOption(), false));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a extends Thread {
        a() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            if (LocalePluginTrigger.this.m_plugin.getType() == PluginType.CONDITION) {
                LocalePluginTrigger localePluginTrigger = LocalePluginTrigger.this;
                localePluginTrigger.condition = new Condition(localePluginTrigger.getContext(), LocalePluginTrigger.this.m_plugin);
                LocalePluginTrigger.this.condition.query(LocalePluginTrigger.this.m_pluginInstanceData, LocalePluginTrigger.this.m_previousState);
                return;
            }
            LocalePluginTrigger localePluginTrigger2 = LocalePluginTrigger.this;
            localePluginTrigger2.event = new Event(localePluginTrigger2.getContext(), LocalePluginTrigger.this.m_plugin);
            LocalePluginTrigger.this.event.query(LocalePluginTrigger.this.m_pluginInstanceData, LocalePluginTrigger.this.m_previousState, (Bundle) null);
        }
    }

    /* loaded from: classes3.dex */
    class b implements Parcelable.Creator<LocalePluginTrigger> {
        b() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public LocalePluginTrigger createFromParcel(Parcel parcel) {
            return new LocalePluginTrigger(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public LocalePluginTrigger[] newArray(int i4) {
            return new LocalePluginTrigger[i4];
        }
    }

    /* synthetic */ LocalePluginTrigger(Parcel parcel, a aVar) {
        this(parcel);
    }

    private void Y() {
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_invert_condition, (ViewGroup) null);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(this.m_plugin.getActivityLabel(getContext()));
        final CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.invert_condition_checkbox);
        checkBox.setChecked(this.m_invertCondition);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.w4
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                LocalePluginTrigger.this.Z(checkBox, dialogInterface, i4);
            }
        });
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.setView(inflate);
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z(CheckBox checkBox, DialogInterface dialogInterface, int i4) {
        this.m_invertCondition = checkBox.isChecked();
        itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a0(Subscriber subscriber) {
        Map<String, Plugin> pluginMap = PluginRegistry.getInstance(getContext()).getPluginMap(PluginType.CONDITION);
        Map<String, Plugin> pluginMap2 = PluginRegistry.getInstance(getContext()).getPluginMap(PluginType.EVENT);
        HashMap hashMap = new HashMap();
        hashMap.putAll(pluginMap);
        hashMap.putAll(pluginMap2);
        subscriber.onNext(hashMap);
        subscriber.onCompleted();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0(MaterialDialog materialDialog, Activity activity, Map map) {
        materialDialog.dismiss();
        this.m_pluginMap = map;
        if (map.size() > 0) {
            new TaskerPluginHelper().displayPluginList(this, this.m_pluginMap, this);
        } else {
            ToastCompat.makeText(activity.getApplicationContext(), (int) R.string.action_locale_no_plugins_found, 0).show();
        }
        PluginRegistry.getInstance(getContext()).destroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c0(MaterialDialog materialDialog, Throwable th) {
        materialDialog.dismiss();
        PluginRegistry.getInstance(getContext()).destroy();
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void disableTrigger() {
        s_triggerCounter--;
        Condition condition = this.condition;
        if (condition != null) {
            condition.destroy();
            this.condition = null;
        }
        Event event = this.event;
        if (event != null) {
            event.destroy();
            this.event = null;
        }
        if (s_triggerCounter == 0) {
            try {
                MacroDroidApplication.getInstance().unregisterReceiver(s_localePluginTriggerReceiver);
            } catch (Exception e4) {
                FirebaseAnalyticsEventLogger.logHandledException(e4);
            }
            s_localePluginTriggerReceiver = null;
        }
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void enableTrigger() {
        if (s_triggerCounter == 0) {
            s_localePluginTriggerReceiver = new LocalePluginTriggerReceiver();
            MacroDroidApplication.getInstance().registerReceiver(s_localePluginTriggerReceiver, new IntentFilter(Intent.ACTION_REQUEST_QUERY));
        }
        s_triggerCounter++;
        new a().start();
    }

    public ArrayHandlingOption getArrayHandlingOption() {
        return ArrayHandlingOption.fromId(this.arrayHandlingOption);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        Plugin plugin = this.m_plugin;
        if (plugin != null) {
            try {
                return plugin.getActivityLabel(getContext());
            } catch (Exception unused) {
            }
        }
        return super.getConfiguredName();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getEditModeWarning() {
        if (this.m_plugin == null) {
            return null;
        }
        try {
            getContext().getPackageManager().getPackageInfo(this.m_plugin.getPackageName(), 128);
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            if (this.m_plugin.getPackageName() == null) {
                return null;
            }
            return String.format(SelectableItem.r(R.string.requires_application), this.m_plugin.getPackageName());
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        PluginInstanceData pluginInstanceData;
        if (this.m_plugin != null && (pluginInstanceData = this.m_pluginInstanceData) != null) {
            try {
                return pluginInstanceData.getBlurb();
            } catch (Exception unused) {
                if (!this.m_shownToastError) {
                    Context applicationContext = getContext().getApplicationContext();
                    ToastCompat.makeText(applicationContext, (CharSequence) (SelectableItem.r(R.string.problem_with) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + SelectableItem.r(R.string.action_locale_plugin) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + SelectableItem.r(R.string.please_delete_and_recreate)), 1).show();
                    this.m_shownToastError = true;
                }
                return SelectableItem.r(R.string.please_delete_and_recreate);
            }
        }
        return "";
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return LocalePluginTriggerInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getListModeName() {
        return getConfiguredName() + " (" + getExtendedDetail() + ")";
    }

    public Plugin getPlugin() {
        return this.m_plugin;
    }

    public PluginInstanceData getPluginInstanceData() {
        return this.m_pluginInstanceData;
    }

    public int getPreviousState() {
        return this.m_previousState;
    }

    @Override // com.arlosoft.macrodroid.taskerplugin.TaskerVariableHandler
    @NonNull
    public Map<String, String> getVariableMap() {
        return this.m_variableMap;
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasVariables
    public List<MacroDroidVariable> getVariables() {
        ArrayList arrayList = new ArrayList();
        for (String str : this.m_variableMap.values()) {
            MacroDroidVariable variableByName = getVariableByName(str);
            if (variableByName != null) {
                arrayList.add(variableByName);
            }
        }
        return arrayList;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemComplete(Object obj) {
        TaskerVariableData taskerVariableData = (TaskerVariableData) obj;
        this.m_plugin = taskerVariableData.getPluginInstanceDataPair().first;
        this.m_pluginInstanceData = taskerVariableData.getPluginInstanceDataPair().second;
        this.arrayHandlingOption = taskerVariableData.getArrayHandlingOption().getId();
        if (this.m_plugin.getType() == PluginType.CONDITION) {
            Y();
        } else {
            itemComplete();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        Plugin plugin = this.m_plugin;
        if (plugin != null && this.m_pluginInstanceData != null) {
            onPluginSelected(plugin);
            return;
        }
        final Activity activity = getActivity();
        final MaterialDialog show = new MaterialDialog.Builder(activity).title(R.string.please_wait).content(R.string.getting_list_of_apps).progress(true, 0).cancelable(false).show();
        AppObservable.bindActivity(activity, Observable.create(new Observable.OnSubscribe() { // from class: com.arlosoft.macrodroid.triggers.t4
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                LocalePluginTrigger.this.a0((Subscriber) obj);
            }
        })).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1() { // from class: com.arlosoft.macrodroid.triggers.u4
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                LocalePluginTrigger.this.b0(show, activity, (Map) obj);
            }
        }, new Action1() { // from class: com.arlosoft.macrodroid.triggers.v4
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                LocalePluginTrigger.this.c0(show, (Throwable) obj);
            }
        });
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleWarningClick() {
        try {
            android.content.Intent intent = new android.content.Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + this.m_plugin.getPackageName()));
            intent.addFlags(268435456);
            getContext().startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            android.content.Intent intent2 = new android.content.Intent("android.intent.action.VIEW");
            intent2.setData(Uri.parse("https://play.google.com/store/apps/details?id=" + this.m_plugin.getPackageName()));
            intent2.addFlags(268435456);
            getContext().startActivity(intent2);
        }
    }

    public boolean isInvert() {
        return this.m_invertCondition;
    }

    @Override // com.arlosoft.macrodroid.taskerplugin.PluginSelectedHandler
    public void onPluginSelected(Plugin plugin) {
        Activity activity = getActivity();
        ((ViewGroup) activity.findViewById(R.id.content_overlay)).setVisibility(0);
        s_currentTrigger = this;
        PluginEditFragment pluginEditFragment = new PluginEditFragment();
        try {
            pluginEditFragment.setArguments(AbstractPluginEditFragment.newArgs(plugin, this.m_pluginInstanceData));
            activity.getFragmentManager().beginTransaction().add(R.id.content_overlay, pluginEditFragment).commit();
        } catch (Exception unused) {
            Context applicationContext = getContext().getApplicationContext();
            ToastCompat.makeText(applicationContext, (CharSequence) (SelectableItem.r(R.string.problem_with) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + SelectableItem.r(R.string.action_locale_plugin) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + SelectableItem.r(R.string.please_delete_and_recreate)), 1).show();
        }
        this.m_previousState = 18;
    }

    public void setPreviousState(int i4) {
        this.m_previousState = i4;
    }

    @Override // com.arlosoft.macrodroid.interfaces.VariableNameUpdater
    public void updateVariableName(@NonNull String str, @NonNull String str2) {
        String str3;
        Iterator<String> it = this.m_variableMap.keySet().iterator();
        while (true) {
            if (it.hasNext()) {
                str3 = it.next();
                if (this.m_variableMap.get(str3).equals(str)) {
                    break;
                }
            } else {
                str3 = null;
                break;
            }
        }
        if (str3 != null) {
            this.m_variableMap.put(str3, str2);
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        int i5;
        super.writeToParcel(parcel, i4);
        try {
            parcel.writeParcelable(this.m_plugin, i4);
            parcel.writeParcelable(this.m_pluginInstanceData, i4);
            if (this.m_invertCondition) {
                i5 = 1;
            } else {
                i5 = 0;
            }
            parcel.writeInt(i5);
            parcel.writeMap(this.m_variableMap);
            parcel.writeInt(this.arrayHandlingOption);
        } catch (Exception unused) {
            Context applicationContext = getContext().getApplicationContext();
            ToastCompat.makeText(applicationContext, (CharSequence) (SelectableItem.r(R.string.problem_with) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + getMacro().getName() + ":" + SelectableItem.r(R.string.action_locale_plugin) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + SelectableItem.r(R.string.please_delete_and_recreate)), 1).show();
        }
    }

    public LocalePluginTrigger(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private LocalePluginTrigger() {
        this.arrayHandlingOption = ArrayHandlingOption.FIRST_ELEMENT.getId();
        this.m_shownToastError = false;
        this.m_previousState = 18;
        this.m_variableMap = new HashMap();
    }

    private LocalePluginTrigger(Parcel parcel) {
        super(parcel);
        this.arrayHandlingOption = ArrayHandlingOption.FIRST_ELEMENT.getId();
        this.m_shownToastError = false;
        this.m_previousState = 18;
        this.m_variableMap = new HashMap();
        this.m_plugin = (Plugin) parcel.readParcelable(Plugin.class.getClassLoader());
        this.m_pluginInstanceData = (PluginInstanceData) parcel.readParcelable(PluginInstanceData.class.getClassLoader());
        this.m_invertCondition = parcel.readInt() != 0;
        HashMap hashMap = new HashMap();
        this.m_variableMap = hashMap;
        parcel.readMap(hashMap, String.class.getClassLoader());
        this.arrayHandlingOption = parcel.readInt();
    }
}
