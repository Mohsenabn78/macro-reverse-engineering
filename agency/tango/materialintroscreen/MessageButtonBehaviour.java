package agency.tango.materialintroscreen;

import android.view.View;

/* loaded from: classes.dex */
public class MessageButtonBehaviour {

    /* renamed from: a */
    private View.OnClickListener f84a;

    /* renamed from: b */
    private String f85b;

    public MessageButtonBehaviour(View.OnClickListener onClickListener, String str) {
        this.f84a = onClickListener;
        this.f85b = str;
    }

    public View.OnClickListener getClickListener() {
        return this.f84a;
    }

    public String getMessageButtonText() {
        return this.f85b;
    }

    public MessageButtonBehaviour(String str) {
        this.f85b = str;
    }
}
