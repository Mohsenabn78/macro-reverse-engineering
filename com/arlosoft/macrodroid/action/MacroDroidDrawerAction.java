package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.MacroDroidDrawerActionInfo;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.drawer.DrawerOverlayHandleService;
import com.arlosoft.macrodroid.drawer.DrawerOverlayService;
import com.arlosoft.macrodroid.drawer.model.DrawerConfiguration;
import com.arlosoft.macrodroid.events.CloseDrawerEvent;
import com.arlosoft.macrodroid.events.DrawerHandleUpdateEvent;
import com.arlosoft.macrodroid.events.EventBusUtils;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.thebluealliance.spectrum.SpectrumDialog;

/* loaded from: classes2.dex */
public class MacroDroidDrawerAction extends Action {
    public static final Parcelable.Creator<MacroDroidDrawerAction> CREATOR = new b();
    private static final int OPTION_CLOSE = 1;
    private static final int OPTION_CONFIGURE_SWIPE_AREA = 4;
    private static final int OPTION_DISABLE = 3;
    private static final int OPTION_ENABLE = 2;
    private static final int OPTION_OPEN = 0;
    private static final int OPTION_TOGGLE = 5;
    private static final int SWIPE_AREA_OPTION_COLOR = 6;
    private static final int SWIPE_AREA_OPTION_HEIGHT = 4;
    private static final int SWIPE_AREA_OPTION_LEFT = 0;
    private static final int SWIPE_AREA_OPTION_OPACITY = 7;
    private static final int SWIPE_AREA_OPTION_RIGHT = 1;
    private static final int SWIPE_AREA_OPTION_VERTICAL_OFFSET = 5;
    private static final int SWIPE_AREA_OPTION_VISIBLE_WIDTH = 3;
    private static final int SWIPE_AREA_OPTION_WIDTH = 2;
    private int m_option;
    private int swipeAreaColour;
    private int swipeAreaHeight;
    private int swipeAreaOpacity;
    private int swipeAreaOption;
    private int swipeAreaVerticalOffset;
    private int swipeAreaVisibleWidth;
    private int swipeAreaWidth;

    /* loaded from: classes2.dex */
    class b implements Parcelable.Creator<MacroDroidDrawerAction> {
        b() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public MacroDroidDrawerAction createFromParcel(Parcel parcel) {
            return new MacroDroidDrawerAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public MacroDroidDrawerAction[] newArray(int i4) {
            return new MacroDroidDrawerAction[i4];
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface c {
        void a(int i4);
    }

    /* synthetic */ MacroDroidDrawerAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    private void U(int i4) {
        DrawerConfiguration drawerConfiguration = Settings.getDrawerConfiguration(getContext());
        switch (i4) {
            case 0:
                drawerConfiguration.leftSide = true;
                break;
            case 1:
                drawerConfiguration.leftSide = false;
                break;
            case 2:
                drawerConfiguration.swipeAreaWidth = this.swipeAreaWidth;
                break;
            case 3:
                drawerConfiguration.visibleSwipeAreaWidth = this.swipeAreaVisibleWidth;
                break;
            case 4:
                drawerConfiguration.swipeAreaHeight = this.swipeAreaHeight;
                break;
            case 5:
                drawerConfiguration.swipeAreaOffset = this.swipeAreaVerticalOffset;
                break;
            case 6:
                drawerConfiguration.swipeAreaColor = this.swipeAreaColour;
                break;
            case 7:
                drawerConfiguration.swipeAreaOpacity = (int) ((this.swipeAreaOpacity / 100.0d) * 255.0d);
                break;
        }
        Settings.setDrawerConfiguration(getContext(), drawerConfiguration);
        EventBusUtils.getEventBus().post(new DrawerHandleUpdateEvent(drawerConfiguration));
    }

    private AlertDialog.Builder V(String str, int i4, int i5, final c cVar) {
        View inflate = LayoutInflater.from(new ContextThemeWrapper(getActivity(), m())).inflate(R.layout.dialog_seek_bar, (ViewGroup) null);
        final SeekBar seekBar = (SeekBar) inflate.findViewById(R.id.seekBar);
        TextView textView = (TextView) inflate.findViewById(R.id.valueLabel);
        seekBar.setProgress(i4);
        seekBar.setMax(i5);
        textView.setText(((int) (i4 * (100.0d / i5))) + "%");
        seekBar.setOnSeekBarChangeListener(new a(textView, i5));
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(str);
        builder.setView(inflate);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.ga
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i6) {
                MacroDroidDrawerAction.this.X(cVar, seekBar, dialogInterface, i6);
            }
        });
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        return builder;
    }

    private String[] W() {
        return new String[]{SelectableItem.r(R.string.left), SelectableItem.r(R.string.right), SelectableItem.r(R.string.width), SelectableItem.r(R.string.visible_width), SelectableItem.r(R.string.height), SelectableItem.r(R.string.vertical_offset), SelectableItem.r(R.string.color), SelectableItem.r(R.string.opacity)};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X(c cVar, SeekBar seekBar, DialogInterface dialogInterface, int i4) {
        cVar.a(seekBar.getProgress());
        itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y(boolean z3, int i4) {
        if (z3) {
            this.swipeAreaColour = i4;
            itemComplete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z(int i4) {
        this.swipeAreaHeight = i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a0(int i4) {
        this.swipeAreaOpacity = i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0(DialogInterface dialogInterface, int i4) {
        int checkedItemPosition = ((AlertDialog) dialogInterface).getListView().getCheckedItemPosition();
        this.swipeAreaOption = checkedItemPosition;
        switch (checkedItemPosition) {
            case 2:
                l0();
                return;
            case 3:
                k0();
                return;
            case 4:
                g0();
                return;
            case 5:
                j0();
                return;
            case 6:
                f0();
                return;
            case 7:
                h0();
                return;
            default:
                itemComplete();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c0(int i4) {
        this.swipeAreaVerticalOffset = i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d0(int i4) {
        this.swipeAreaVisibleWidth = i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e0(int i4) {
        this.swipeAreaWidth = i4;
    }

    private void f0() {
        new SpectrumDialog.Builder(getContext()).setTitle(R.string.select_color).setColors(R.array.notification_colors).setDismissOnColorSelected(true).setOutlineWidth(1).setOnColorSelectedListener(new SpectrumDialog.OnColorSelectedListener() { // from class: com.arlosoft.macrodroid.action.ca
            @Override // com.thebluealliance.spectrum.SpectrumDialog.OnColorSelectedListener
            public final void onColorSelected(boolean z3, int i4) {
                MacroDroidDrawerAction.this.Y(z3, i4);
            }
        }).build().show(((AppCompatActivity) getActivity()).getSupportFragmentManager(), "");
    }

    private void g0() {
        V(SelectableItem.r(R.string.height), this.swipeAreaHeight, 90, new c() { // from class: com.arlosoft.macrodroid.action.aa
            @Override // com.arlosoft.macrodroid.action.MacroDroidDrawerAction.c
            public final void a(int i4) {
                MacroDroidDrawerAction.this.Z(i4);
            }
        }).show();
    }

    private String[] getOptions() {
        return new String[]{SelectableItem.r(R.string.open), SelectableItem.r(R.string.close), SelectableItem.r(R.string.enable), SelectableItem.r(R.string.disable), SelectableItem.r(R.string.action_macrodroid_drawer_configure_swipe_area), SelectableItem.r(R.string.toggle)};
    }

    private void h0() {
        V(SelectableItem.r(R.string.opacity), this.swipeAreaOpacity, 100, new c() { // from class: com.arlosoft.macrodroid.action.fa
            @Override // com.arlosoft.macrodroid.action.MacroDroidDrawerAction.c
            public final void a(int i4) {
                MacroDroidDrawerAction.this.a0(i4);
            }
        }).show();
    }

    private void i0() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(R.string.action_macrodroid_drawer_configure_swipe_area);
        builder.setSingleChoiceItems(W(), this.swipeAreaOption, (DialogInterface.OnClickListener) null);
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.z9
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                MacroDroidDrawerAction.this.b0(dialogInterface, i4);
            }
        });
        builder.create().show();
    }

    private void j0() {
        V(SelectableItem.r(R.string.vertical_offset), this.swipeAreaVerticalOffset, 90, new c() { // from class: com.arlosoft.macrodroid.action.ea
            @Override // com.arlosoft.macrodroid.action.MacroDroidDrawerAction.c
            public final void a(int i4) {
                MacroDroidDrawerAction.this.c0(i4);
            }
        }).show();
    }

    private void k0() {
        V(SelectableItem.r(R.string.visible_width), this.swipeAreaVisibleWidth, 20, new c() { // from class: com.arlosoft.macrodroid.action.da
            @Override // com.arlosoft.macrodroid.action.MacroDroidDrawerAction.c
            public final void a(int i4) {
                MacroDroidDrawerAction.this.d0(i4);
            }
        }).show();
    }

    private void l0() {
        V(SelectableItem.r(R.string.width), this.swipeAreaWidth, 20, new c() { // from class: com.arlosoft.macrodroid.action.ba
            @Override // com.arlosoft.macrodroid.action.MacroDroidDrawerAction.c
            public final void a(int i4) {
                MacroDroidDrawerAction.this.e0(i4);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.m_option = i4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return this.m_option;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        return getOptions()[this.m_option];
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return MacroDroidDrawerActionInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getListModeName() {
        return getName() + " (" + getExtendedDetail() + ")";
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
        int i4 = this.m_option;
        if (i4 != 0 && (i4 != 5 || DrawerOverlayService.drawerOpen)) {
            if (i4 != 1 && (i4 != 5 || !DrawerOverlayService.drawerOpen)) {
                if (i4 == 2) {
                    if (!Settings.isDrawerEnabled(getContext())) {
                        Settings.setDrawerEnabled(getContext(), true);
                        getContext().stopService(new Intent(getContext(), DrawerOverlayHandleService.class));
                        getContext().startService(new Intent(getContext(), DrawerOverlayHandleService.class));
                        return;
                    }
                    return;
                } else if (i4 == 3) {
                    if (Settings.isDrawerEnabled(getContext())) {
                        Settings.setDrawerEnabled(getContext(), false);
                        getContext().stopService(new Intent(getContext(), DrawerOverlayHandleService.class));
                        return;
                    }
                    return;
                } else if (i4 == 4) {
                    U(this.swipeAreaOption);
                    return;
                } else {
                    return;
                }
            }
            EventBusUtils.getEventBus().post(new CloseDrawerEvent());
            return;
        }
        getContext().startService(new Intent(getContext(), DrawerOverlayService.class));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return getOptions();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean requiresCanDrawOverlays() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        if (this.m_option == 4) {
            i0();
        } else {
            super.secondaryItemConfirmed();
        }
    }

    public void setState(int i4) {
        this.m_option = i4;
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_option);
        parcel.writeInt(this.swipeAreaOption);
        parcel.writeInt(this.swipeAreaColour);
        parcel.writeInt(this.swipeAreaHeight);
        parcel.writeInt(this.swipeAreaWidth);
        parcel.writeInt(this.swipeAreaVisibleWidth);
        parcel.writeInt(this.swipeAreaVerticalOffset);
    }

    public MacroDroidDrawerAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public MacroDroidDrawerAction() {
        this.swipeAreaOpacity = 50;
        this.swipeAreaHeight = 45;
        this.swipeAreaWidth = 10;
        this.swipeAreaVisibleWidth = 10;
        this.swipeAreaVerticalOffset = 50;
        this.m_option = 0;
    }

    private MacroDroidDrawerAction(Parcel parcel) {
        super(parcel);
        this.swipeAreaOpacity = 50;
        this.swipeAreaHeight = 45;
        this.swipeAreaWidth = 10;
        this.swipeAreaVisibleWidth = 10;
        this.swipeAreaVerticalOffset = 50;
        this.m_option = parcel.readInt();
        this.swipeAreaOption = parcel.readInt();
        this.swipeAreaColour = parcel.readInt();
        this.swipeAreaHeight = parcel.readInt();
        this.swipeAreaWidth = parcel.readInt();
        this.swipeAreaVisibleWidth = parcel.readInt();
        this.swipeAreaVerticalOffset = parcel.readInt();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements SeekBar.OnSeekBarChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TextView f2306a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f2307b;

        a(TextView textView, int i4) {
            this.f2306a = textView;
            this.f2307b = i4;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i4, boolean z3) {
            TextView textView = this.f2306a;
            textView.setText(((int) (i4 * (100.0d / this.f2307b))) + "%");
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }
}
