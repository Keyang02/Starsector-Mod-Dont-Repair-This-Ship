package data.scripts;

import com.fs.starfarer.api.BaseModPlugin;
import com.fs.starfarer.api.Global;

public class ModPlugin extends BaseModPlugin {

    @Override
    public void onGameLoad(boolean newGame) {
        Global.getSector().addScript(new drts_RepairmentSuspend_SnycScripts());
    }
}