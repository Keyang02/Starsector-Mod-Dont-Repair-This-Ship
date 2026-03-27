package data.hullmods;

import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.combat.BaseHullMod;
import com.fs.starfarer.api.combat.ShipAPI;
import com.fs.starfarer.api.combat.ShipAPI.HullSize;
import com.fs.starfarer.api.ui.TooltipMakerAPI;

import java.awt.Color;

public class drts_RepairmentSuspend_HullMod extends BaseHullMod {

    public static final String HULLMOD_ID = "drts_RepairmentSuspend";
    public static final String SKILL_NAME = "Hull Restoration";
    public static final String DMOD_NAME = "D-mods";

    @Override
    public String getDescriptionParam(int index, HullSize hullSize) {
        if (index == 0) return SKILL_NAME;
        return null;
    }

    @Override
    public void addPostDescriptionSection(TooltipMakerAPI tooltip, HullSize hullSize, ShipAPI ship, float width, boolean isForModSpec) {
        final Color yellow = Global.getSettings().getColor("hColor");
        final Color darkred = Global.getSettings().getColor("textEnemyColor");
        final Color[] colors = {yellow, darkred};
        tooltip.addPara("%1$s ignores this ship when repairing %2$s each month.", 10f, colors, SKILL_NAME, DMOD_NAME);
    }

    @Override
    public boolean isApplicableToShip(ShipAPI ship) {
        return ship != null && ship.getVariant() != null;
    }

    @Override
    public String getUnapplicableReason(ShipAPI ship) {
        return null;
    }
}
