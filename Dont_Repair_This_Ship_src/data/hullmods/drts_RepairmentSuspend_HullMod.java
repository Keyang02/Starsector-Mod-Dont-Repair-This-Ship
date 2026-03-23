package data.hullmods;

import com.fs.starfarer.api.combat.BaseHullMod;
import com.fs.starfarer.api.combat.ShipAPI;
import com.fs.starfarer.api.combat.ShipAPI.HullSize;

public class drts_RepairmentSuspend_HullMod extends BaseHullMod {

    public static final String HULLMOD_ID = "drts_RepairmentSuspend";

    @Override
    public String getDescriptionParam(int index, HullSize hullSize) {
        if (index == 0) return "prevents Hull Restoration from removing D-mods";
        return null;
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