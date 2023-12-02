package com.android.dx.ssa;

import com.android.dx.rop.code.RopMethod;
import com.android.dx.rop.code.TranslationAdvice;
import com.android.dx.ssa.back.LivenessAnalyzer;
import com.android.dx.ssa.back.SsaToRop;
import java.util.EnumSet;

/* loaded from: classes2.dex */
public class Optimizer {
    private static TranslationAdvice advice = null;
    private static boolean preserveLocals = true;

    /* loaded from: classes2.dex */
    public enum OptionalStep {
        MOVE_PARAM_COMBINER,
        SCCP,
        LITERAL_UPGRADE,
        CONST_COLLECTOR,
        ESCAPE_ANALYSIS
    }

    public static SsaMethod debugDeadCodeRemover(RopMethod ropMethod, int i4, boolean z3, boolean z4, TranslationAdvice translationAdvice) {
        preserveLocals = z4;
        advice = translationAdvice;
        SsaMethod convertToSsaMethod = SsaConverter.convertToSsaMethod(ropMethod, i4, z3);
        DeadCodeRemover.process(convertToSsaMethod);
        return convertToSsaMethod;
    }

    public static SsaMethod debugEdgeSplit(RopMethod ropMethod, int i4, boolean z3, boolean z4, TranslationAdvice translationAdvice) {
        preserveLocals = z4;
        advice = translationAdvice;
        return SsaConverter.testEdgeSplit(ropMethod, i4, z3);
    }

    public static SsaMethod debugNoRegisterAllocation(RopMethod ropMethod, int i4, boolean z3, boolean z4, TranslationAdvice translationAdvice, EnumSet<OptionalStep> enumSet) {
        preserveLocals = z4;
        advice = translationAdvice;
        SsaMethod convertToSsaMethod = SsaConverter.convertToSsaMethod(ropMethod, i4, z3);
        runSsaFormSteps(convertToSsaMethod, enumSet);
        LivenessAnalyzer.constructInterferenceGraph(convertToSsaMethod);
        return convertToSsaMethod;
    }

    public static SsaMethod debugPhiPlacement(RopMethod ropMethod, int i4, boolean z3, boolean z4, TranslationAdvice translationAdvice) {
        preserveLocals = z4;
        advice = translationAdvice;
        return SsaConverter.testPhiPlacement(ropMethod, i4, z3);
    }

    public static SsaMethod debugRenaming(RopMethod ropMethod, int i4, boolean z3, boolean z4, TranslationAdvice translationAdvice) {
        preserveLocals = z4;
        advice = translationAdvice;
        return SsaConverter.convertToSsaMethod(ropMethod, i4, z3);
    }

    public static TranslationAdvice getAdvice() {
        return advice;
    }

    public static boolean getPreserveLocals() {
        return preserveLocals;
    }

    public static RopMethod optimize(RopMethod ropMethod, int i4, boolean z3, boolean z4, TranslationAdvice translationAdvice) {
        return optimize(ropMethod, i4, z3, z4, translationAdvice, EnumSet.allOf(OptionalStep.class));
    }

    private static RopMethod optimizeMinimizeRegisters(RopMethod ropMethod, int i4, boolean z3, EnumSet<OptionalStep> enumSet) {
        SsaMethod convertToSsaMethod = SsaConverter.convertToSsaMethod(ropMethod, i4, z3);
        EnumSet<OptionalStep> clone = enumSet.clone();
        clone.remove(OptionalStep.CONST_COLLECTOR);
        runSsaFormSteps(convertToSsaMethod, clone);
        return SsaToRop.convertToRopMethod(convertToSsaMethod, true);
    }

    private static void runSsaFormSteps(SsaMethod ssaMethod, EnumSet<OptionalStep> enumSet) {
        boolean z3;
        if (enumSet.contains(OptionalStep.MOVE_PARAM_COMBINER)) {
            MoveParamCombiner.process(ssaMethod);
        }
        boolean z4 = false;
        if (enumSet.contains(OptionalStep.SCCP)) {
            SCCP.process(ssaMethod);
            DeadCodeRemover.process(ssaMethod);
            z3 = false;
        } else {
            z3 = true;
        }
        if (enumSet.contains(OptionalStep.LITERAL_UPGRADE)) {
            LiteralOpUpgrader.process(ssaMethod);
            DeadCodeRemover.process(ssaMethod);
            z3 = false;
        }
        OptionalStep optionalStep = OptionalStep.ESCAPE_ANALYSIS;
        enumSet.remove(optionalStep);
        if (enumSet.contains(optionalStep)) {
            EscapeAnalysis.process(ssaMethod);
            DeadCodeRemover.process(ssaMethod);
            z3 = false;
        }
        if (enumSet.contains(OptionalStep.CONST_COLLECTOR)) {
            ConstCollector.process(ssaMethod);
            DeadCodeRemover.process(ssaMethod);
        } else {
            z4 = z3;
        }
        if (z4) {
            DeadCodeRemover.process(ssaMethod);
        }
        PhiTypeResolver.process(ssaMethod);
    }

    public static RopMethod optimize(RopMethod ropMethod, int i4, boolean z3, boolean z4, TranslationAdvice translationAdvice, EnumSet<OptionalStep> enumSet) {
        preserveLocals = z4;
        advice = translationAdvice;
        SsaMethod convertToSsaMethod = SsaConverter.convertToSsaMethod(ropMethod, i4, z3);
        runSsaFormSteps(convertToSsaMethod, enumSet);
        RopMethod convertToRopMethod = SsaToRop.convertToRopMethod(convertToSsaMethod, false);
        return convertToRopMethod.getBlocks().getRegCount() > advice.getMaxOptimalRegisterCount() ? optimizeMinimizeRegisters(ropMethod, i4, z3, enumSet) : convertToRopMethod;
    }
}
