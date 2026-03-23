package data.scripts;

import com.fs.starfarer.api.EveryFrameScript;
import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.campaign.CampaignFleetAPI;
import com.fs.starfarer.api.fleet.FleetMemberAPI;
import com.fs.starfarer.api.impl.campaign.ids.Tags;


public class drts_RepairmentSuspend_SnycScripts implements EveryFrameScript {

    public static final String HULLMOD_ID = "drts_RepairmentSuspend";

    @Override
    public void advance(float amount) {
        CampaignFleetAPI fleet = Global.getSector().getPlayerFleet();
        if (fleet == null) return;

        for (FleetMemberAPI member : fleet.getFleetData().getMembersListCopy()) {
            if (member.getVariant() == null) continue;

            boolean hasHullmod = member.getVariant().getHullMods().contains(HULLMOD_ID);
            boolean hasTag = member.getVariant().hasTag(Tags.VARIANT_UNRESTORABLE);

            if (hasHullmod && !hasTag) {
                member.getVariant().addTag(Tags.VARIANT_UNRESTORABLE);
            } else if (!hasHullmod && hasTag) {
                member.getVariant().removeTag(Tags.VARIANT_UNRESTORABLE);
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
