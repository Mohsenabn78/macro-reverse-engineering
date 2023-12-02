package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Size;
import androidx.appcompat.app.AlertDialog;
import androidx.core.util.Pair;
import com.afollestad.materialdialogs.MaterialDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.LocalePluginActionInfo;
import com.arlosoft.macrodroid.action.receivers.LocaleTaskerSettingCompleteReceiver;
import com.arlosoft.macrodroid.common.MacroDroidVariable;
import com.arlosoft.macrodroid.common.MacroDroidVariableStore;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.data.ResumeMacroInfo;
import com.arlosoft.macrodroid.interfaces.BlockingAction;
import com.arlosoft.macrodroid.interfaces.HasVariables;
import com.arlosoft.macrodroid.interfaces.VariableNameUpdater;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.taskerplugin.ArrayHandlingOption;
import com.arlosoft.macrodroid.taskerplugin.PluginSelectedHandler;
import com.arlosoft.macrodroid.taskerplugin.TaskerPluginHelper;
import com.arlosoft.macrodroid.taskerplugin.TaskerVariableData;
import com.arlosoft.macrodroid.taskerplugin.TaskerVariableHandler;
import com.arlosoft.macrodroid.taskerplugin.TaskerVariableHelper;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.widget.ItemFinishedListener;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.twofortyfouram.locale.sdk.host.api.PluginRegistry;
import com.twofortyfouram.locale.sdk.host.api.Setting;
import com.twofortyfouram.locale.sdk.host.internal.BundleSerializer;
import com.twofortyfouram.locale.sdk.host.model.Plugin;
import com.twofortyfouram.locale.sdk.host.model.PluginErrorEdit;
import com.twofortyfouram.locale.sdk.host.model.PluginInstanceData;
import com.twofortyfouram.locale.sdk.host.model.PluginType;
import com.twofortyfouram.locale.sdk.host.ui.fragment.AbstractPluginEditFragment;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import me.drakeet.support.toast.ToastCompat;
import rx.Observable;
import rx.Subscriber;
import rx.android.app.AppObservable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/* loaded from: classes2.dex */
public class LocalePluginAction extends Action implements BlockingAction, TaskerVariableHandler, PluginSelectedHandler, HasVariables, VariableNameUpdater {
    public static final Parcelable.Creator<LocalePluginAction> CREATOR = new b();
    private static LocalePluginAction s_currentAction;
    private int arrayHandlingOption;
    private boolean blockActions;
    private transient TriggerContextInfo contextInfo;
    private transient boolean forceEvenIfNotEnabled;
    private transient boolean isTest;
    private Plugin m_plugin;
    private PluginInstanceData m_pluginInstanceData;
    private transient List<Plugin> m_pluginList;
    private transient Map<String, Plugin> m_pluginMap;
    private transient int m_selectedIndex;
    private transient boolean m_shownToastError;
    private Map<String, String> m_variableMap;
    private transient int nextAction;
    private transient ResumeMacroInfo resumeMacroInfo;
    private transient Stack<Integer> skipEndifIndexStack;

    /* loaded from: classes2.dex */
    public static class PluginEditFragment extends AbstractPluginEditFragment {
        @Override // com.twofortyfouram.locale.sdk.host.ui.fragment.IPluginEditFragment
        public void handleCancel(@NonNull Plugin plugin) {
            if (getActivity() instanceof ItemFinishedListener) {
                ((ItemFinishedListener) getActivity()).itemCancelled();
            }
        }

        @Override // com.twofortyfouram.locale.sdk.host.ui.fragment.IPluginEditFragment
        public void handleErrors(@NonNull Plugin plugin, @NonNull @Size(min = 1) EnumSet<PluginErrorEdit> enumSet) {
            long j4;
            StringBuilder sb = new StringBuilder();
            Iterator<E> it = enumSet.iterator();
            while (it.hasNext()) {
                sb.append(((PluginErrorEdit) it.next()).getDeveloperExplanation());
                sb.append("\n");
            }
            String sb2 = sb.toString();
            if (LocalePluginAction.s_currentAction != null) {
                j4 = LocalePluginAction.s_currentAction.getMacroGuid().longValue();
            } else {
                j4 = 0;
            }
            SystemLog.logError(sb2, j4);
            Util.displayErrorDialog(getActivity(), getString(R.string.error), sb.toString());
        }

        @Override // com.twofortyfouram.locale.sdk.host.ui.fragment.IPluginEditFragment
        public void handleSave(@NonNull Plugin plugin, @NonNull PluginInstanceData pluginInstanceData, @Nullable String[] strArr) {
            if (getActivity() instanceof ItemFinishedListener) {
                if (strArr != null && strArr.length > 0) {
                    if (LocalePluginAction.s_currentAction != null) {
                        new TaskerVariableHelper().showVariableList(getActivity(), LocalePluginAction.s_currentAction, strArr, LocalePluginAction.s_currentAction, new Pair<>(plugin, pluginInstanceData), LocalePluginAction.s_currentAction.getArrayHandlingOption(), false, LocalePluginAction.s_currentAction.blockActions);
                    } else {
                        SystemLog.logError("Could not save tasker plugin configuration (the current action is null).");
                    }
                } else if (LocalePluginAction.s_currentAction != null) {
                    ((ItemFinishedListener) getActivity()).itemComplete(new TaskerVariableData(new Pair(plugin, pluginInstanceData), LocalePluginAction.s_currentAction.getArrayHandlingOption(), false));
                } else {
                    SystemLog.logError("Could not save tasker plugin configuration (the current action is null).");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TriggerContextInfo f2290a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f2291b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f2292c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Stack f2293d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ ResumeMacroInfo f2294e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ boolean f2295f;

        a(TriggerContextInfo triggerContextInfo, int i4, boolean z3, Stack stack, ResumeMacroInfo resumeMacroInfo, boolean z4) {
            this.f2290a = triggerContextInfo;
            this.f2291b = i4;
            this.f2292c = z3;
            this.f2293d = stack;
            this.f2294e = resumeMacroInfo;
            this.f2295f = z4;
        }

        @Override // java.lang.Runnable
        public void run() {
            LocalePluginAction.this.i0(this.f2290a, this.f2291b, this.f2292c, this.f2293d, this.f2294e, this.f2295f);
        }
    }

    /* loaded from: classes2.dex */
    class b implements Parcelable.Creator<LocalePluginAction> {
        b() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public LocalePluginAction createFromParcel(Parcel parcel) {
            return new LocalePluginAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public LocalePluginAction[] newArray(int i4) {
            return new LocalePluginAction[i4];
        }
    }

    /* synthetic */ LocalePluginAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y(DialogInterface dialogInterface, int i4) {
        C(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z(DialogInterface dialogInterface, int i4) {
        handleOptionsDialogCancelled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a0(DialogInterface dialogInterface, int i4) {
        secondaryItemConfirmed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0(DialogInterface dialogInterface) {
        handleOptionsDialogCancelled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int c0(Plugin plugin, Plugin plugin2) {
        return plugin.getActivityLabel(getContext()).toLowerCase().compareTo(plugin2.getActivityLabel(getContext()).toLowerCase());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d0(Subscriber subscriber) {
        subscriber.onNext(PluginRegistry.getInstance(getContext()).getPluginMap(PluginType.SETTING));
        subscriber.onCompleted();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e0(MaterialDialog materialDialog, Activity activity, Map map) {
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
    public /* synthetic */ void f0(MaterialDialog materialDialog, Throwable th) {
        materialDialog.dismiss();
        PluginRegistry.getInstance(getContext()).destroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g0(int i4, TriggerContextInfo triggerContextInfo, boolean z3, Stack stack, ResumeMacroInfo resumeMacroInfo) {
        getMacro().invokeActions(getMacro().getActions(), i4, triggerContextInfo, z3, stack, resumeMacroInfo);
    }

    private String h0(String str, Macro macro) {
        if (macro != null) {
            for (MacroDroidVariable macroDroidVariable : macro.getLocalVariables()) {
                str = str.replace("%" + macroDroidVariable.getName(), macroDroidVariable.toString());
            }
        }
        for (MacroDroidVariable macroDroidVariable2 : MacroDroidVariableStore.getInstance().getAllVariables(true)) {
            str = str.replace("%" + macroDroidVariable2.getName(), macroDroidVariable2.toString());
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i0(@Nullable final TriggerContextInfo triggerContextInfo, final int i4, final boolean z3, @NonNull final Stack<Integer> stack, @Nullable final ResumeMacroInfo resumeMacroInfo, boolean z4) {
        byte[] bArr;
        byte[] bArr2;
        byte[] bArr3;
        this.contextInfo = triggerContextInfo;
        this.nextAction = i4;
        this.forceEvenIfNotEnabled = z3;
        this.skipEndifIndexStack = stack;
        this.resumeMacroInfo = resumeMacroInfo;
        this.isTest = z4;
        Setting setting = new Setting(getContext(), this.m_plugin);
        try {
            try {
                byte[] serializedBundle = this.m_pluginInstanceData.getSerializedBundle();
                try {
                    Bundle deserializeFromByteArray = BundleSerializer.deserializeFromByteArray(serializedBundle);
                    for (String str : deserializeFromByteArray.keySet()) {
                        Object obj = deserializeFromByteArray.get(str);
                        if (obj instanceof String) {
                            deserializeFromByteArray.putString(str, MagicText.replaceMagicText(getContext(), h0((String) obj, getMacro()), triggerContextInfo, getMacro()));
                        } else if (obj instanceof String[]) {
                            String[] strArr = (String[]) obj;
                            int i5 = 0;
                            while (i5 < strArr.length) {
                                bArr = serializedBundle;
                                try {
                                    strArr[i5] = MagicText.replaceMagicText(getContext(), strArr[i5], triggerContextInfo, getMacro());
                                    i5++;
                                    serializedBundle = bArr;
                                } catch (Exception e4) {
                                    e = e4;
                                    SystemLog.logError("Magic text replacement failed: " + e.toString(), getMacroGuid().longValue());
                                    bArr2 = bArr;
                                    PluginInstanceData pluginInstanceData = new PluginInstanceData(this.m_pluginInstanceData.getType(), this.m_pluginInstanceData.getRegistryName(), bArr2, this.m_pluginInstanceData.getBlurb());
                                    Intent intent = new Intent("com.arlosoft.macrodroid.SETTING_COMPLETE", Uri.parse("http://www.macrodroid.com"), getContext(), LocaleTaskerSettingCompleteReceiver.class);
                                    intent.putExtra(LocaleTaskerSettingCompleteReceiver.EXTRA_ACTION_ID, getSIGUID());
                                    if (!this.blockActions) {
                                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.arlosoft.macrodroid.action.o9
                                            @Override // java.lang.Runnable
                                            public final void run() {
                                                LocalePluginAction.this.g0(i4, triggerContextInfo, z3, stack, resumeMacroInfo);
                                            }
                                        });
                                    }
                                    setting.fire(pluginInstanceData, intent);
                                }
                            }
                            bArr3 = serializedBundle;
                            deserializeFromByteArray.putStringArray(str, strArr);
                            serializedBundle = bArr3;
                        }
                        bArr3 = serializedBundle;
                        serializedBundle = bArr3;
                    }
                    bArr = serializedBundle;
                    bArr2 = BundleSerializer.serializeToByteArray(deserializeFromByteArray);
                } catch (Exception e5) {
                    e = e5;
                    bArr = serializedBundle;
                }
                PluginInstanceData pluginInstanceData2 = new PluginInstanceData(this.m_pluginInstanceData.getType(), this.m_pluginInstanceData.getRegistryName(), bArr2, this.m_pluginInstanceData.getBlurb());
                Intent intent2 = new Intent("com.arlosoft.macrodroid.SETTING_COMPLETE", Uri.parse("http://www.macrodroid.com"), getContext(), LocaleTaskerSettingCompleteReceiver.class);
                intent2.putExtra(LocaleTaskerSettingCompleteReceiver.EXTRA_ACTION_ID, getSIGUID());
                if (!this.blockActions && !z4) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.arlosoft.macrodroid.action.o9
                        @Override // java.lang.Runnable
                        public final void run() {
                            LocalePluginAction.this.g0(i4, triggerContextInfo, z3, stack, resumeMacroInfo);
                        }
                    });
                }
                setting.fire(pluginInstanceData2, intent2);
            } catch (Exception unused) {
                Context applicationContext = getContext().getApplicationContext();
                ToastCompat.makeText(applicationContext, (CharSequence) (SelectableItem.r(R.string.problem_with) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + getMacro().getName() + ":" + SelectableItem.r(R.string.action_locale_plugin) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + SelectableItem.r(R.string.please_delete_and_recreate)), 1).show();
            }
        } finally {
            setting.destroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.m_selectedIndex = i4;
    }

    public ArrayHandlingOption getArrayHandlingOption() {
        return ArrayHandlingOption.fromId(this.arrayHandlingOption);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        try {
            if (this.m_plugin != null) {
                int i4 = 0;
                for (Plugin plugin : this.m_pluginList) {
                    if (plugin.getPackageName().equals(this.m_plugin.getPackageName()) && plugin.getActivityClassName().equals(this.m_plugin.getActivityClassName())) {
                        this.m_selectedIndex = i4;
                        return i4;
                    }
                    i4++;
                }
            }
        } catch (Exception unused) {
        }
        return 0;
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
        return LocalePluginActionInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getListModeName() {
        if (this.m_plugin != null) {
            try {
                return getConfiguredName() + " (" + getExtendedDetail() + ")";
            } catch (Exception unused) {
                return getName();
            }
        }
        return getName();
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
        this.blockActions = taskerVariableData.getBlockActions();
        itemComplete();
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
        AppObservable.bindActivity(activity, Observable.create(new Observable.OnSubscribe() { // from class: com.arlosoft.macrodroid.action.p9
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                LocalePluginAction.this.d0((Subscriber) obj);
            }
        })).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1() { // from class: com.arlosoft.macrodroid.action.q9
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                LocalePluginAction.this.e0(show, activity, (Map) obj);
            }
        }, new Action1() { // from class: com.arlosoft.macrodroid.action.r9
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                LocalePluginAction.this.f0(show, (Throwable) obj);
            }
        });
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleWarningClick() {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + this.m_plugin.getPackageName()));
            intent.addFlags(268435456);
            getContext().startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            Intent intent2 = new Intent("android.intent.action.VIEW");
            intent2.setData(Uri.parse("https://play.google.com/store/apps/details?id=" + this.m_plugin.getPackageName()));
            intent2.addFlags(268435456);
            getContext().startActivity(intent2);
        }
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean isValid() {
        Plugin plugin = this.m_plugin;
        if (plugin != null && plugin.getPackageName() != null) {
            return true;
        }
        return false;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    protected AlertDialog l() {
        Activity activity = getActivity();
        String[] o4 = o();
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, m());
        builder.setTitle(p());
        builder.setSingleChoiceItems(o4, getCheckedItemIndex(), new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.j9
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                LocalePluginAction.this.Y(dialogInterface, i4);
            }
        });
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.k9
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                LocalePluginAction.this.Z(dialogInterface, i4);
            }
        });
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.l9
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                LocalePluginAction.this.a0(dialogInterface, i4);
            }
        });
        AlertDialog create = builder.create();
        create.show();
        create.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.arlosoft.macrodroid.action.m9
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                LocalePluginAction.this.b0(dialogInterface);
            }
        });
        if (o4.length > 50) {
            ListView listView = create.getListView();
            listView.setFastScrollEnabled(true);
            listView.setPadding(0, 0, getContext().getResources().getDimensionPixelSize(R.dimen.fast_scroll_padding), 0);
            listView.setScrollBarStyle(33554432);
        }
        return create;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        String[] strArr = new String[this.m_pluginMap.size()];
        this.m_pluginList = new ArrayList();
        for (String str : this.m_pluginMap.keySet()) {
            this.m_pluginList.add(this.m_pluginMap.get(str));
        }
        Collections.sort(this.m_pluginList, new Comparator() { // from class: com.arlosoft.macrodroid.action.n9
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int c02;
                c02 = LocalePluginAction.this.c0((Plugin) obj, (Plugin) obj2);
                return c02;
            }
        });
        int i4 = 0;
        for (Plugin plugin : this.m_pluginList) {
            strArr[i4] = plugin.getActivityLabel(getContext());
            i4++;
        }
        return strArr;
    }

    @Override // com.arlosoft.macrodroid.taskerplugin.PluginSelectedHandler
    public void onPluginSelected(Plugin plugin) {
        Activity activity = getActivity();
        ((ViewGroup) activity.findViewById(R.id.content_overlay)).setVisibility(0);
        s_currentAction = this;
        PluginEditFragment pluginEditFragment = new PluginEditFragment();
        try {
            pluginEditFragment.setArguments(AbstractPluginEditFragment.newArgs(plugin, this.m_pluginInstanceData));
            activity.getFragmentManager().beginTransaction().add(R.id.content_overlay, pluginEditFragment).commit();
        } catch (Exception unused) {
            Context applicationContext = getContext().getApplicationContext();
            ToastCompat.makeText(applicationContext, (CharSequence) (SelectableItem.r(R.string.problem_with) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + SelectableItem.r(R.string.action_locale_plugin) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + SelectableItem.r(R.string.please_delete_and_recreate)), 1).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String p() {
        return SelectableItem.r(R.string.select_plugin);
    }

    public void resumeMacro() {
        if (this.blockActions && !this.isTest) {
            getMacro().invokeActions(getMacro().getActions(), this.nextAction, this.contextInfo, this.forceEvenIfNotEnabled, this.skipEndifIndexStack, this.resumeMacroInfo);
        }
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

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        int i5;
        super.writeToParcel(parcel, i4);
        try {
            parcel.writeParcelable(this.m_plugin, i4);
            parcel.writeParcelable(this.m_pluginInstanceData, i4);
            parcel.writeMap(this.m_variableMap);
            parcel.writeInt(this.arrayHandlingOption);
            if (this.blockActions) {
                i5 = 1;
            } else {
                i5 = 0;
            }
            parcel.writeInt(i5);
        } catch (Exception unused) {
            Context applicationContext = getContext().getApplicationContext();
            ToastCompat.makeText(applicationContext, (CharSequence) (SelectableItem.r(R.string.problem_with) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + getMacro().getName() + ":" + SelectableItem.r(R.string.action_locale_plugin) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + SelectableItem.r(R.string.please_delete_and_recreate)), 1).show();
        }
    }

    public LocalePluginAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    @Override // com.arlosoft.macrodroid.interfaces.BlockingAction
    public void invokeAction(@Nullable TriggerContextInfo triggerContextInfo, int i4, boolean z3, @NonNull Stack<Integer> stack, @Nullable ResumeMacroInfo resumeMacroInfo, boolean z4) {
        new Thread(new a(triggerContextInfo, i4, z3, stack, resumeMacroInfo, z4)).start();
    }

    private LocalePluginAction() {
        this.arrayHandlingOption = ArrayHandlingOption.FIRST_ELEMENT.getId();
        this.m_selectedIndex = 0;
        this.m_shownToastError = false;
        this.m_variableMap = new HashMap();
        this.skipEndifIndexStack = new Stack<>();
    }

    private LocalePluginAction(Parcel parcel) {
        super(parcel);
        this.arrayHandlingOption = ArrayHandlingOption.FIRST_ELEMENT.getId();
        this.m_selectedIndex = 0;
        this.m_shownToastError = false;
        this.m_variableMap = new HashMap();
        this.skipEndifIndexStack = new Stack<>();
        this.m_plugin = (Plugin) parcel.readParcelable(Plugin.class.getClassLoader());
        this.m_pluginInstanceData = (PluginInstanceData) parcel.readParcelable(PluginInstanceData.class.getClassLoader());
        HashMap hashMap = new HashMap();
        this.m_variableMap = hashMap;
        parcel.readMap(hashMap, String.class.getClassLoader());
        this.arrayHandlingOption = parcel.readInt();
        this.blockActions = parcel.readInt() != 0;
    }
}
