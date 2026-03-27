package data.scripts;

import com.fs.starfarer.api.EveryFrameScript;
import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.campaign.CampaignFleetAPI;
import com.fs.starfarer.api.fleet.FleetMemberAPI;
import com.fs.starfarer.api.impl.campaign.ids.Tags;


public class drts_RepairmentSuspend_SnycScripts implements EveryFrameScript {

    public static final String DRTS_HULLMOD_ID = "drts_RepairmentSuspend";
    public static final String DRTS_MOD_TAG = "drts_added_variant_unrestorable";

    @Override
    public void advance(float amount) {
        CampaignFleetAPI fleet = Global.getSector().getPlayerFleet();
        if (fleet == null) return;

        for (FleetMemberAPI member : fleet.getFleetData().getMembersListCopy()) {
            if (member.getVariant() == null) continue;

            boolean hasHullmod = member.getVariant().getHullMods().contains(DRTS_HULLMOD_ID);
            boolean hasTag = member.getVariant().hasTag(Tags.VARIANT_UNRESTORABLE);
            boolean addedByMod = member.getVariant().hasTag(DRTS_MOD_TAG);

            if (hasHullmod && !hasTag) {
                member.getVariant().addTag(Tags.VARIANT_UNRESTORABLE);
                member.getVariant().addTag(DRTS_MOD_TAG);
            } else if (!hasHullmod && addedByMod) {
                if (hasTag) {
                    member.getVariant().removeTag(Tags.VARIANT_UNRESTORABLE);
                }
                member.getVariant().removeTag(DRTS_MOD_TAG);
            }
        }
    }

    @Override
    public boolean isDone() {
        return false;
    }

    @Override
    public boolean runWhilePaused() {
        return true;
    }
}
