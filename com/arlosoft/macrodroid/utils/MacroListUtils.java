package com.arlosoft.macrodroid.utils;

import com.arlosoft.macrodroid.action.Action;
import com.arlosoft.macrodroid.action.ElseAction;
import com.arlosoft.macrodroid.action.ElseIfConditionAction;
import com.arlosoft.macrodroid.action.ElseIfConfirmedThenAction;
import com.arlosoft.macrodroid.action.ElseParentAction;
import com.arlosoft.macrodroid.action.EndIfAction;
import com.arlosoft.macrodroid.action.EndLoopAction;
import com.arlosoft.macrodroid.action.IfConditionAction;
import com.arlosoft.macrodroid.action.IterateDictionaryAction;
import com.arlosoft.macrodroid.action.LoopAction;
import com.arlosoft.macrodroid.data.IteratorType;
import java.util.List;

/* loaded from: classes3.dex */
public class MacroListUtils {
    public static int getElseIndex(List<Action> list, int i4) {
        int i5 = 1;
        for (int i6 = i4 + 1; i6 < list.size() && i5 > 0; i6++) {
            Action action = list.get(i6);
            if (action instanceof IfConditionAction) {
                i5++;
            }
            if (action instanceof EndIfAction) {
                i5--;
            } else if (action.isEnabled() && (action instanceof ElseAction) && i5 == 1) {
                return i6;
            }
        }
        return -1;
    }

    public static int getEndIfIndex(List<Action> list, int i4) {
        int i5 = 1;
        for (int i6 = i4 + 1; i6 < list.size(); i6++) {
            Action action = list.get(i6);
            if (action instanceof IfConditionAction) {
                i5++;
            } else if ((action instanceof EndIfAction) && i5 - 1 == 0) {
                return i6;
            }
        }
        return -1;
    }

    public static int getEndLoopIndex(List<Action> list, int i4) {
        int i5 = 1;
        for (int i6 = i4 + 1; i6 < list.size(); i6++) {
            Action action = list.get(i6);
            if (action instanceof LoopAction) {
                i5++;
            } else if ((action instanceof EndLoopAction) && i5 - 1 == 0) {
                return i6;
            }
        }
        return -1;
    }

    public static int getNextElseIfIndex(List<Action> list, int i4) {
        int i5 = 1;
        for (int i6 = i4 + 1; i6 < list.size(); i6++) {
            Action action = list.get(i6);
            if (action instanceof IfConditionAction) {
                i5++;
            }
            if (action instanceof EndIfAction) {
                i5--;
                if (i5 == 0) {
                    return -1;
                }
            } else if (((action.isEnabled() && (action instanceof ElseIfConditionAction)) || (action instanceof ElseIfConfirmedThenAction)) && i5 == 1) {
                return i6;
            }
        }
        return -1;
    }

    public static int getNextElseOrElseIforEndParentIndex(List<Action> list, int i4) {
        int i5 = 1;
        for (int i6 = i4 + 1; i6 < list.size(); i6++) {
            Action action = list.get(i6);
            if (action instanceof IfConditionAction) {
                i5++;
            }
            if (action instanceof EndIfAction) {
                i5--;
                if (i5 == 0) {
                    return i6;
                }
            } else if (((action instanceof ElseAction) || (action instanceof ElseIfConditionAction) || (action instanceof ElseIfConfirmedThenAction)) && i5 == 1) {
                return i6;
            }
        }
        return -1;
    }

    public static int getParentEndIndex(List<Action> list, int i4) {
        if (list.get(i4) instanceof LoopAction) {
            return getEndLoopIndex(list, i4);
        }
        return getEndIfIndex(list, i4);
    }

    public static int getStartIfIndex(List<Action> list, int i4) {
        int i5 = 1;
        for (int i6 = i4 - 1; i6 >= 0; i6--) {
            Action action = list.get(i6);
            if (action instanceof EndIfAction) {
                i5++;
            } else if ((action instanceof IfConditionAction) && i5 - 1 == 0) {
                return i6;
            }
        }
        return -1;
    }

    public static int getStartLoopIndex(List<Action> list, int i4) {
        int i5 = 1;
        for (int i6 = i4 - 1; i6 >= 0; i6--) {
            Action action = list.get(i6);
            if (action instanceof EndLoopAction) {
                i5++;
            } else if ((action instanceof LoopAction) && i5 - 1 == 0) {
                return i6;
            }
        }
        return -1;
    }

    public static int getStartLoopIndexConsideringEnabledState(List<Action> list, int i4) {
        int i5 = 1;
        for (int i6 = i4 - 1; i6 >= 0; i6--) {
            Action action = list.get(i6);
            if ((action instanceof EndLoopAction) && action.isEnabled()) {
                int startLoopIndex = getStartLoopIndex(list, i6);
                if (startLoopIndex != -1 && list.get(startLoopIndex).isEnabled()) {
                    i5++;
                }
            } else if ((action instanceof LoopAction) && action.isEnabled() && i5 - 1 == 0) {
                return i6;
            }
        }
        return -1;
    }

    public static int getStartParentIndex(List<Action> list, int i4) {
        Action action = list.get(i4);
        if (!(action instanceof EndIfAction) && !(action instanceof ElseParentAction)) {
            return getStartLoopIndex(list, i4);
        }
        return getStartIfIndex(list, i4);
    }

    public static IteratorType isChildOfIterateDictionaryLoop(List<Action> list, int i4) {
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        for (int i8 = i4 - 1; i8 >= 0; i8--) {
            if (list.get(i8) instanceof IterateDictionaryAction) {
                i5++;
                if ((i5 + i6) - i7 > 0) {
                    if (((IterateDictionaryAction) list.get(i8)).getIsArray()) {
                        return IteratorType.ARRAY;
                    }
                    return IteratorType.DICTIONARY;
                }
            }
            if ((list.get(i8) instanceof LoopAction) && i7 > 0) {
                i6++;
            } else if (list.get(i8) instanceof EndLoopAction) {
                i7++;
            }
        }
        return IteratorType.NONE;
    }
}
