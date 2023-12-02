package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.WindowManager;
import android.widget.LinearLayout;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.ForceScreenRotationActionInfo;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.utils.OrientationListener;
import com.arlosoft.macrodroid.utils.OverlayUtils;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import me.drakeet.support.toast.ToastCompat;

/* loaded from: classes2.dex */
public class ForceScreenRotationAction extends Action {
    public static final Parcelable.Creator<ForceScreenRotationAction> CREATOR = new b();
    private static LinearLayout s_orientationChanger;
    private static OrientationListener s_orientationListener;
    private int m_option;
    private transient boolean m_overlayOn;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ WindowManager.LayoutParams f2248a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f2249b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ WindowManager f2250c;

        a(WindowManager.LayoutParams layoutParams, boolean z3, WindowManager windowManager) {
            this.f2248a = layoutParams;
            this.f2249b = z3;
            this.f2250c = windowManager;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i4;
            WindowManager.LayoutParams layoutParams = this.f2248a;
            if (this.f2249b) {
                i4 = 1;
            } else {
                i4 = 9;
            }
            layoutParams.screenOrientation = i4;
            this.f2250c.updateViewLayout(ForceScreenRotationAction.s_orientationChanger, this.f2248a);
        }
    }

    /* loaded from: classes2.dex */
    class b implements Parcelable.Creator<ForceScreenRotationAction> {
        b() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ForceScreenRotationAction createFromParcel(Parcel parcel) {
            return new ForceScreenRotationAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public ForceScreenRotationAction[] newArray(int i4) {
            return new ForceScreenRotationAction[i4];
        }
    }

    /* synthetic */ ForceScreenRotationAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    private int O() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int rotation = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getRotation();
        if (((rotation == 0 || rotation == 2) && configuration.orientation == 2) || ((rotation == 1 || rotation == 3) && configuration.orientation == 1)) {
            return 2;
        }
        return 1;
    }

    private int P() {
        int O = O();
        int orientation = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getOrientation();
        if (orientation != 0) {
            if (orientation != 1) {
                if (orientation != 2) {
                    if (O != 1) {
                        return 1;
                    }
                    return 8;
                } else if (O == 1) {
                    return 9;
                } else {
                    return 8;
                }
            } else if (O == 1) {
                return 0;
            } else {
                return 9;
            }
        } else if (O != 1) {
            return 0;
        } else {
            return 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q(WindowManager.LayoutParams layoutParams, WindowManager windowManager, boolean z3) {
        new Handler(Looper.getMainLooper()).post(new a(layoutParams, z3, windowManager));
    }

    private String[] getOptions() {
        return new String[]{SelectableItem.r(R.string.action_force_screen_rotation_portrait), SelectableItem.r(R.string.action_force_screen_rotation_landscape), SelectableItem.r(R.string.action_force_screen_rotation_cancel), SelectableItem.r(R.string.action_force_screen_rotation_current), SelectableItem.r(R.string.action_force_screen_rotation_toggle_current), SelectableItem.r(R.string.action_force_screen_rotation_portrait_180), SelectableItem.r(R.string.action_force_screen_rotation_landscape_180), SelectableItem.r(R.string.action_force_screen_sensor_landscape), SelectableItem.r(R.string.action_force_screen_sensor_portrait), SelectableItem.r(R.string.action_force_screen_full_sensor_mode)};
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
        return ForceScreenRotationActionInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
        final WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
        LinearLayout linearLayout = s_orientationChanger;
        if (linearLayout != null) {
            try {
                windowManager.removeView(linearLayout);
            } catch (IllegalArgumentException unused) {
            }
        }
        s_orientationChanger = new LinearLayout(getContext());
        final WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(1, 1, OverlayUtils.getOverlayTypeLockScreen(), 24, -2);
        OrientationListener orientationListener = s_orientationListener;
        if (orientationListener != null) {
            orientationListener.disable();
            s_orientationListener = null;
        }
        int i4 = this.m_option;
        if (i4 == 0) {
            layoutParams.screenOrientation = 1;
            this.m_overlayOn = true;
        } else if (i4 == 1) {
            layoutParams.screenOrientation = 0;
            this.m_overlayOn = true;
        } else if (i4 == 2) {
            this.m_overlayOn = false;
        } else if (i4 == 3) {
            layoutParams.screenOrientation = P();
            this.m_overlayOn = true;
        } else if (i4 == 4) {
            if (!this.m_overlayOn) {
                this.m_overlayOn = true;
                layoutParams.screenOrientation = P();
            } else {
                this.m_overlayOn = false;
            }
        } else if (i4 == 5) {
            layoutParams.screenOrientation = 9;
            this.m_overlayOn = true;
        } else if (i4 == 6) {
            layoutParams.screenOrientation = 8;
            this.m_overlayOn = true;
        } else if (i4 == 7) {
            layoutParams.screenOrientation = 6;
            this.m_overlayOn = true;
        } else if (i4 == 8) {
            s_orientationListener = new OrientationListener(getContext(), 3, new OrientationListener.OrientationChangedListener() { // from class: com.arlosoft.macrodroid.action.u7
                @Override // com.arlosoft.macrodroid.utils.OrientationListener.OrientationChangedListener
                public final void orientationUpdated(boolean z3) {
                    ForceScreenRotationAction.this.Q(layoutParams, windowManager, z3);
                }
            });
            this.m_overlayOn = true;
        } else if (i4 == 9) {
            layoutParams.screenOrientation = 10;
            this.m_overlayOn = true;
        } else {
            this.m_overlayOn = false;
        }
        if (this.m_overlayOn) {
            try {
                windowManager.addView(s_orientationChanger, layoutParams);
                s_orientationChanger.setVisibility(0);
                OrientationListener orientationListener2 = s_orientationListener;
                if (orientationListener2 != null) {
                    orientationListener2.enable();
                    return;
                }
                return;
            } catch (SecurityException unused2) {
                SystemLog.logInfo("Screen Rotation failed: requires SYSTEM_ALERT_WINDOW permission", getMacroGuid().longValue());
                Context applicationContext = getContext().getApplicationContext();
                ToastCompat.makeText(applicationContext, (CharSequence) (SelectableItem.r(R.string.action_force_screen_rotation) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + SelectableItem.r(R.string.action_failed_requires_permission)), 0).show();
                s_orientationChanger = null;
                return;
            } catch (Exception e4) {
                SystemLog.logVerbose("Screen Rotation failed: " + e4.toString(), getMacroGuid().longValue());
                return;
            }
        }
        s_orientationChanger = null;
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

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_option);
    }

    public ForceScreenRotationAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
        this.m_overlayOn = false;
    }

    private ForceScreenRotationAction() {
    }

    private ForceScreenRotationAction(Parcel parcel) {
        super(parcel);
        this.m_option = parcel.readInt();
    }
}
