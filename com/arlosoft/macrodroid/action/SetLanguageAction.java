package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.appcompat.app.AlertDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.SetLanguageActionInfo;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.root.RootToolsHelper;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import me.drakeet.support.toast.ToastCompat;

/* loaded from: classes2.dex */
public class SetLanguageAction extends Action {
    public static final Parcelable.Creator<SetLanguageAction> CREATOR = new a();
    private Locale m_locale;

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<SetLanguageAction> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public SetLanguageAction createFromParcel(Parcel parcel) {
            return new SetLanguageAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public SetLanguageAction[] newArray(int i4) {
            return new SetLanguageAction[i4];
        }
    }

    /* synthetic */ SetLanguageAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    private void U(Locale locale, Locale[] localeArr) {
        final ArrayList<Locale> arrayList = new ArrayList();
        for (Locale locale2 : localeArr) {
            if (!TextUtils.isEmpty(locale2.getDisplayCountry()) && locale.getDisplayLanguage().equals(locale2.getDisplayLanguage())) {
                arrayList.add(locale2);
            }
        }
        Collections.sort(arrayList, new Comparator() { // from class: com.arlosoft.macrodroid.action.uj
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int V;
                V = SetLanguageAction.V((Locale) obj, (Locale) obj2);
                return V;
            }
        });
        ArrayList arrayList2 = new ArrayList();
        int i4 = 0;
        int i5 = 0;
        for (Locale locale3 : arrayList) {
            arrayList2.add(locale3.getDisplayCountry());
            if (this.m_locale.equals(locale3)) {
                i4 = i5;
            }
            i5++;
        }
        if (arrayList2.size() == 1) {
            this.m_locale = (Locale) arrayList.get(0);
            itemComplete();
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(R.string.action_set_language);
        builder.setSingleChoiceItems((String[]) arrayList2.toArray(new String[0]), i4, (DialogInterface.OnClickListener) null);
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.vj
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i6) {
                SetLanguageAction.this.W(dialogInterface, i6);
            }
        });
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.wj
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i6) {
                SetLanguageAction.this.X(arrayList, dialogInterface, i6);
            }
        });
        AlertDialog create = builder.create();
        create.show();
        create.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.arlosoft.macrodroid.action.xj
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                SetLanguageAction.this.Y(dialogInterface);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int V(Locale locale, Locale locale2) {
        return locale.getDisplayCountry().compareTo(locale2.getDisplayCountry());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W(DialogInterface dialogInterface, int i4) {
        handleOptionsDialogCancelled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X(List list, DialogInterface dialogInterface, int i4) {
        this.m_locale = (Locale) list.get(((AlertDialog) dialogInterface).getListView().getCheckedItemPosition());
        itemComplete();
        if (RootToolsHelper.isAccessGiven()) {
            Util.runAsRoot(new String[]{"pm grant com.arlosoft.macrodroid android.permission.CHANGE_CONFIGURATION"});
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y(DialogInterface dialogInterface) {
        handleOptionsDialogCancelled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int Z(Locale locale, Locale locale2) {
        return locale.getDisplayLanguage().compareTo(locale2.getDisplayLanguage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a0(DialogInterface dialogInterface, int i4) {
        handleOptionsDialogCancelled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0(ArrayList arrayList, Locale[] localeArr, DialogInterface dialogInterface, int i4) {
        U((Locale) arrayList.get(((AlertDialog) dialogInterface).getListView().getCheckedItemPosition()), localeArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c0(DialogInterface dialogInterface) {
        handleOptionsDialogCancelled();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        return this.m_locale.getDisplayLanguage() + " (" + this.m_locale.getDisplayCountry() + ")";
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return SetLanguageActionInfo.getInstance();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        final Locale[] availableLocales = Locale.getAvailableLocales();
        ArrayList arrayList = new ArrayList();
        Arrays.sort(availableLocales, new Comparator() { // from class: com.arlosoft.macrodroid.action.qj
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int Z;
                Z = SetLanguageAction.Z((Locale) obj, (Locale) obj2);
                return Z;
            }
        });
        final ArrayList arrayList2 = new ArrayList();
        int i4 = 0;
        int i5 = 0;
        for (Locale locale : availableLocales) {
            String displayLanguage = locale.getDisplayLanguage();
            if (!arrayList.contains(displayLanguage)) {
                arrayList.add(displayLanguage);
                arrayList2.add(locale);
                if (this.m_locale.getDisplayLanguage().equals(locale.getDisplayLanguage())) {
                    i4 = i5;
                }
                i5++;
            }
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(R.string.action_set_language);
        builder.setSingleChoiceItems((String[]) arrayList.toArray(new String[0]), i4, (DialogInterface.OnClickListener) null);
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.rj
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i6) {
                SetLanguageAction.this.a0(dialogInterface, i6);
            }
        });
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.sj
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i6) {
                SetLanguageAction.this.b0(arrayList2, availableLocales, dialogInterface, i6);
            }
        });
        AlertDialog create = builder.create();
        create.show();
        create.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.arlosoft.macrodroid.action.tj
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                SetLanguageAction.this.c0(dialogInterface);
            }
        });
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
        if (RootToolsHelper.isAccessGiven()) {
            Util.runAsRoot(new String[]{"pm grant com.arlosoft.macrodroid android.permission.CHANGE_CONFIGURATION"});
        }
        try {
            Locale locale = this.m_locale;
            Class<?> cls = Class.forName("android.app.ActivityManagerNative");
            Method method = cls.getMethod("getDefault", new Class[0]);
            method.setAccessible(true);
            Object invoke = method.invoke(cls, new Object[0]);
            Method method2 = cls.getMethod("getConfiguration", new Class[0]);
            method2.setAccessible(true);
            Configuration configuration = (Configuration) method2.invoke(invoke, new Object[0]);
            configuration.getClass().getField("userSetLocale").setBoolean(configuration, true);
            configuration.locale = locale;
            Method method3 = cls.getMethod("updateConfiguration", Configuration.class);
            method3.setAccessible(true);
            method3.invoke(invoke, configuration);
        } catch (Exception unused) {
            ToastCompat.makeText(getContext().getApplicationContext(), (int) R.string.error, 0).show();
            SystemLog.logError("Could not set system language, you need to grant permission via adb with the command: pm grant com.arlosoft.macrodroid android.permission.CHANGE_CONFIGURATION", getMacroGuid().longValue());
        }
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeSerializable(this.m_locale);
    }

    public SetLanguageAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public SetLanguageAction() {
        this.m_locale = Locale.getDefault();
    }

    private SetLanguageAction(Parcel parcel) {
        super(parcel);
        this.m_locale = (Locale) parcel.readSerializable();
    }
}
