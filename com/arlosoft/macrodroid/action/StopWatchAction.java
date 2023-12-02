package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.StopWatchActionInfo;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.interfaces.HasStopwatch;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.stopwatch.StopWatch;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import java.util.List;

/* loaded from: classes2.dex */
public class StopWatchAction extends Action implements HasStopwatch {
    public static final Parcelable.Creator<StopWatchAction> CREATOR = new b();
    private static final int OPTION_PAUSE = 1;
    private static final int OPTION_RESET = 2;
    private static final int OPTION_RESET_AND_START = 3;
    private static final int OPTION_START = 0;
    private int m_option;
    private String m_stopwatchName;

    /* loaded from: classes2.dex */
    class b implements Parcelable.Creator<StopWatchAction> {
        b() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public StopWatchAction createFromParcel(Parcel parcel) {
            return new StopWatchAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public StopWatchAction[] newArray(int i4) {
            return new StopWatchAction[i4];
        }
    }

    /* synthetic */ StopWatchAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    private void R(@NonNull final List<String> list) {
        final AppCompatDialog appCompatDialog = new AppCompatDialog(getActivity(), getDialogTheme());
        appCompatDialog.setContentView(R.layout.dialog_new_stopwatch);
        appCompatDialog.setTitle(R.string.action_stop_watch_create_new);
        Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        final EditText editText = (EditText) appCompatDialog.findViewById(R.id.name);
        editText.addTextChangedListener(new a(button, editText));
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.to
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StopWatchAction.this.U(editText, list, appCompatDialog, view);
            }
        });
        ((Button) appCompatDialog.findViewById(R.id.cancelButton)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.uo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.cancel();
            }
        });
        appCompatDialog.show();
    }

    private void S() {
        final List<String> stopWatches = StopWatch.getStopWatches(getContext());
        String[] strArr = new String[stopWatches.size() + 1];
        int i4 = 0;
        strArr[0] = "<" + SelectableItem.r(R.string.action_stop_watch_create_new) + ">";
        for (int i5 = 1; i5 < stopWatches.size() + 1; i5++) {
            String str = stopWatches.get(i5 - 1);
            strArr[i5] = str;
            String str2 = this.m_stopwatchName;
            if (str2 != null && str2.equals(str)) {
                i4 = i5;
            }
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setSingleChoiceItems(strArr, i4, (DialogInterface.OnClickListener) null);
        builder.setTitle(p());
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.ro
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i6) {
                StopWatchAction.this.W(stopWatches, dialogInterface, i6);
            }
        });
        builder.create().show();
    }

    private void T(@NonNull final String str) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setSingleChoiceItems(getOptions(), this.m_option, (DialogInterface.OnClickListener) null);
        builder.setTitle(p());
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.so
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                StopWatchAction.this.X(str, dialogInterface, i4);
            }
        });
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U(EditText editText, List list, AppCompatDialog appCompatDialog, View view) {
        String obj = editText.getText().toString();
        if (list.contains(obj)) {
            Z();
            return;
        }
        list.add(obj);
        StopWatch.setStopWatches(getContext(), list);
        appCompatDialog.dismiss();
        T(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W(List list, DialogInterface dialogInterface, int i4) {
        ListView listView = ((AlertDialog) dialogInterface).getListView();
        int checkedItemPosition = listView.getCheckedItemPosition();
        if (checkedItemPosition == 0) {
            R(list);
        } else {
            T((String) listView.getAdapter().getItem(checkedItemPosition));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X(String str, DialogInterface dialogInterface, int i4) {
        this.m_option = ((AlertDialog) dialogInterface).getListView().getCheckedItemPosition();
        this.m_stopwatchName = str;
        itemComplete();
    }

    private void Z() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.Theme_App_Dialog_Variables);
        builder.setTitle(R.string.error);
        builder.setMessage(R.string.action_stop_watch_already_exists);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.vo
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }

    private String[] getOptions() {
        return new String[]{SelectableItem.r(R.string.start), SelectableItem.r(R.string.action_control_media_pause), SelectableItem.r(R.string.reset), SelectableItem.r(R.string.reset_and_restart)};
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void applyImport() {
        List<String> stopWatches = StopWatch.getStopWatches(getContext());
        if (!stopWatches.contains(this.m_stopwatchName)) {
            stopWatches.add(this.m_stopwatchName);
            StopWatch.setStopWatches(getContext(), stopWatches);
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        return SelectableItem.r(R.string.action_stop_watch) + " (" + getOptions()[this.m_option] + ")";
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        return this.m_stopwatchName;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return StopWatchActionInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getListModeName() {
        return SelectableItem.r(R.string.action_stop_watch) + " - " + getExtendedDetail() + " (" + getOptions()[this.m_option] + ")";
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasStopwatch
    public String getStopwatchName() {
        return this.m_stopwatchName;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        S();
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
        int i4 = this.m_option;
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 == 3) {
                        StopWatch.resetStopWatch(getContext(), this.m_stopwatchName);
                        StopWatch.startStopWatch(getContext(), this.m_stopwatchName);
                        return;
                    }
                    return;
                }
                StopWatch.resetStopWatch(getContext(), this.m_stopwatchName);
                return;
            }
            StopWatch.pauseStopWatch(getContext(), this.m_stopwatchName);
            return;
        }
        StopWatch.startStopWatch(getContext(), this.m_stopwatchName);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean isValid() {
        Macro macro = this.m_macro;
        if ((macro != null && !macro.isCompleted()) || StopWatch.getStopWatches(getContext()).contains(this.m_stopwatchName)) {
            return true;
        }
        return false;
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasStopwatch
    public void setStopwatchName(String str) {
        this.m_stopwatchName = str;
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_option);
        parcel.writeString(this.m_stopwatchName);
    }

    public StopWatchAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private StopWatchAction() {
    }

    private StopWatchAction(Parcel parcel) {
        super(parcel);
        this.m_option = parcel.readInt();
        this.m_stopwatchName = parcel.readString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Button f2623a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f2624b;

        a(Button button, EditText editText) {
            this.f2623a = button;
            this.f2624b = editText;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            boolean z3;
            Button button = this.f2623a;
            if (this.f2624b.getText().length() > 0) {
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
