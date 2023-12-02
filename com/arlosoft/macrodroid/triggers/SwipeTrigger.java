package com.arlosoft.macrodroid.triggers;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.appcompat.app.AlertDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.info.SwipeTriggerInfo;
import com.arlosoft.macrodroid.triggers.swipe.SwipeTriggerService;

/* loaded from: classes3.dex */
public class SwipeTrigger extends Trigger {
    public static final Parcelable.Creator<SwipeTrigger> CREATOR = new a();
    public static final int START_AREA_TOP_LEFT = 0;
    public static final int START_AREA_TOP_RIGHT = 1;
    public static final int SWIPE_ACROSS = 0;
    public static final int SWIPE_DIAGONAL = 1;
    public static final int SWIPE_DOWN = 2;
    private static int s_triggerCounter;
    private transient ImageView m_arrow_left;
    private transient ImageView m_arrow_left_diagonal;
    private transient ImageView m_arrow_left_down;
    private transient ImageView m_arrow_right;
    private transient ImageView m_arrow_right_diagonal;
    private transient ImageView m_arrow_right_down;
    private boolean m_cleared;
    private transient RelativeLayout m_overlay;
    private transient RelativeLayout m_overlayFrame;
    private int m_swipeMotion;
    private int m_swipeStartArea;
    private transient View m_top_left_area;
    private transient View m_top_right_area;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<SwipeTrigger> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public SwipeTrigger createFromParcel(Parcel parcel) {
            return new SwipeTrigger(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public SwipeTrigger[] newArray(int i4) {
            return new SwipeTrigger[i4];
        }
    }

    /* synthetic */ SwipeTrigger(Parcel parcel, a aVar) {
        this(parcel);
    }

    private void Q() {
        ImageView imageView = this.m_arrow_right;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        ImageView imageView2 = this.m_arrow_left;
        if (imageView2 != null) {
            imageView2.setVisibility(8);
        }
        ImageView imageView3 = this.m_arrow_right_diagonal;
        if (imageView3 != null) {
            imageView3.setVisibility(8);
        }
        ImageView imageView4 = this.m_arrow_left_diagonal;
        if (imageView4 != null) {
            imageView4.setVisibility(8);
        }
        ImageView imageView5 = this.m_arrow_right_down;
        if (imageView5 != null) {
            imageView5.setVisibility(8);
        }
        ImageView imageView6 = this.m_arrow_left_down;
        if (imageView6 != null) {
            imageView6.setVisibility(8);
        }
    }

    private void R() {
        this.m_cleared = true;
        this.m_overlayFrame = null;
        this.m_overlay = null;
        this.m_top_left_area = null;
        this.m_top_right_area = null;
        this.m_arrow_right = null;
        this.m_arrow_left = null;
        this.m_arrow_right_diagonal = null;
        this.m_arrow_left_diagonal = null;
        this.m_arrow_right_down = null;
        this.m_arrow_left_down = null;
    }

    private String[] S() {
        return new String[]{SelectableItem.r(R.string.trigger_swipe_across), SelectableItem.r(R.string.trigger_swipe_diagonal), SelectableItem.r(R.string.trigger_swipe_down)};
    }

    private String[] T() {
        return new String[]{SelectableItem.r(R.string.trigger_swipe_top_left), SelectableItem.r(R.string.trigger_swipe_top_right)};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U(DialogInterface dialogInterface, int i4) {
        this.m_swipeMotion = i4;
        Y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V(DialogInterface dialogInterface, int i4) {
        Q();
        this.m_overlayFrame.removeView(this.m_overlay);
        R();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W(DialogInterface dialogInterface, int i4) {
        Q();
        this.m_overlayFrame.removeView(this.m_overlay);
        R();
        itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X(DialogInterface dialogInterface) {
        if (!this.m_cleared) {
            Q();
            this.m_overlayFrame.removeView(this.m_overlay);
            this.m_top_left_area.setVisibility(8);
            this.m_top_right_area.setVisibility(8);
            R();
        }
    }

    private void Y() {
        Q();
        if (this.m_swipeStartArea == 0) {
            int i4 = this.m_swipeMotion;
            if (i4 == 0) {
                this.m_arrow_right.setVisibility(0);
                return;
            } else if (i4 == 1) {
                this.m_arrow_right_diagonal.setVisibility(0);
                return;
            } else if (i4 == 2) {
                this.m_arrow_right_down.setVisibility(0);
                return;
            } else {
                return;
            }
        }
        int i5 = this.m_swipeMotion;
        if (i5 == 0) {
            this.m_arrow_left.setVisibility(0);
        } else if (i5 == 1) {
            this.m_arrow_left_diagonal.setVisibility(0);
        } else if (i5 == 2) {
            this.m_arrow_left_down.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        int i5;
        this.m_swipeStartArea = i4;
        View view = this.m_top_left_area;
        int i6 = 0;
        if (i4 == 0) {
            i5 = 0;
        } else {
            i5 = 8;
        }
        view.setVisibility(i5);
        View view2 = this.m_top_right_area;
        if (this.m_swipeStartArea != 1) {
            i6 = 8;
        }
        view2.setVisibility(i6);
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void disableTrigger() {
        int i4 = s_triggerCounter - 1;
        s_triggerCounter = i4;
        if (i4 == 0) {
            getContext().stopService(new Intent(getContext(), SwipeTriggerService.class));
        }
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void enableTrigger() {
        getContext().startService(new Intent(getContext(), SwipeTriggerService.class));
        s_triggerCounter++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return this.m_swipeStartArea;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        return T()[this.m_swipeStartArea] + " - " + S()[this.m_swipeMotion];
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return SwipeTriggerInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getListModeName() {
        return getConfiguredName() + " (" + getExtendedDetail() + ")";
    }

    public int getSwipeMotion() {
        return this.m_swipeMotion;
    }

    public int getSwipeStartArea() {
        return this.m_swipeStartArea;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        if (!checkActivityAlive()) {
            return;
        }
        this.m_overlayFrame = (RelativeLayout) getActivity().findViewById(R.id.triggerOverlay);
        RelativeLayout relativeLayout = (RelativeLayout) View.inflate(getContext(), R.layout.swipe_description_overlay, null);
        this.m_overlay = relativeLayout;
        this.m_top_left_area = relativeLayout.findViewById(R.id.swipe_description_overlay_touch_area_top_left);
        this.m_top_right_area = this.m_overlay.findViewById(R.id.swipe_description_overlay_touch_area_top_right);
        ImageView imageView = (ImageView) this.m_overlay.findViewById(R.id.swipe_description_overlay_right_arrow);
        this.m_arrow_right = imageView;
        imageView.setVisibility(8);
        ImageView imageView2 = (ImageView) this.m_overlay.findViewById(R.id.swipe_description_overlay_left_arrow);
        this.m_arrow_left = imageView2;
        imageView2.setVisibility(8);
        ImageView imageView3 = (ImageView) this.m_overlay.findViewById(R.id.swipe_description_overlay_right_diagonal_arrow);
        this.m_arrow_right_diagonal = imageView3;
        imageView3.setVisibility(8);
        ImageView imageView4 = (ImageView) this.m_overlay.findViewById(R.id.swipe_description_overlay_left_diagonal_arrow);
        this.m_arrow_left_diagonal = imageView4;
        imageView4.setVisibility(8);
        ImageView imageView5 = (ImageView) this.m_overlay.findViewById(R.id.swipe_description_overlay_right_down_arrow);
        this.m_arrow_right_down = imageView5;
        imageView5.setVisibility(8);
        ImageView imageView6 = (ImageView) this.m_overlay.findViewById(R.id.swipe_description_overlay_left_down_arrow);
        this.m_arrow_left_down = imageView6;
        imageView6.setVisibility(8);
        super.handleItemSelected();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleOptionsDialogCancelled() {
        RelativeLayout relativeLayout;
        RelativeLayout relativeLayout2 = this.m_overlayFrame;
        if (relativeLayout2 != null && (relativeLayout = this.m_overlay) != null) {
            relativeLayout2.removeView(relativeLayout);
        }
        R();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return T();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String p() {
        int i4;
        this.m_overlayFrame.addView(this.m_overlay);
        View view = this.m_top_left_area;
        int i5 = 0;
        if (this.m_swipeStartArea == 0) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        view.setVisibility(i4);
        View view2 = this.m_top_right_area;
        if (this.m_swipeStartArea != 1) {
            i5 = 8;
        }
        view2.setVisibility(i5);
        return SelectableItem.r(R.string.trigger_swipe_start_area);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean requiresCanDrawOverlays() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.triggers.Trigger, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        Y();
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(R.string.trigger_swipe);
        builder.setSingleChoiceItems(S(), this.m_swipeMotion, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.f8
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                SwipeTrigger.this.U(dialogInterface, i4);
            }
        });
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.g8
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                SwipeTrigger.this.V(dialogInterface, i4);
            }
        });
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.h8
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                SwipeTrigger.this.W(dialogInterface, i4);
            }
        });
        AlertDialog create = builder.create();
        WindowManager.LayoutParams attributes = create.getWindow().getAttributes();
        attributes.alpha = 1.0f;
        create.getWindow().setAttributes(attributes);
        create.show();
        this.m_cleared = false;
        create.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.arlosoft.macrodroid.triggers.i8
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                SwipeTrigger.this.X(dialogInterface);
            }
        });
    }

    public void setSwipeMotion(int i4) {
        this.m_swipeMotion = i4;
    }

    public void setSwipeStartArea(int i4) {
        this.m_swipeStartArea = i4;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_swipeStartArea);
        parcel.writeInt(this.m_swipeMotion);
    }

    public SwipeTrigger(Activity activity, Macro macro) {
        this();
        this.m_macro = macro;
        setActivity(activity);
    }

    public SwipeTrigger() {
        this.m_swipeStartArea = 0;
        this.m_swipeMotion = 0;
        this.m_cleared = true;
    }

    private SwipeTrigger(Parcel parcel) {
        super(parcel);
        this.m_swipeStartArea = 0;
        this.m_swipeMotion = 0;
        this.m_cleared = true;
        this.m_swipeStartArea = parcel.readInt();
        this.m_swipeMotion = parcel.readInt();
    }
}
