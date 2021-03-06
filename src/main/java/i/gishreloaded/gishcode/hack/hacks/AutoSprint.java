package i.gishreloaded.gishcode.hack.hacks;

import i.gishreloaded.gishcode.hack.Hack;
import i.gishreloaded.gishcode.hack.HackCategory;
import i.gishreloaded.gishcode.utils.Utils;
import i.gishreloaded.gishcode.utils.system.Wrapper;
import net.minecraft.init.MobEffects;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;

public class AutoSprint extends Hack{

	public AutoSprint() {
		super("AutoSprint", HackCategory.PLAYER);
	}
	
	@Override
	public void onClientTick(ClientTickEvent event) {
		if(this.canSprint()) {
			Wrapper.INSTANCE.player().setSprinting(Utils.isMoving(Wrapper.INSTANCE.player()));
		}
		super.onClientTick(event);
	}
	
	boolean canSprint() {
		if(!Wrapper.INSTANCE.player().onGround) {
			return false;
		}
		if(Wrapper.INSTANCE.player().isSprinting()) {
			return false;
		}
		if(Wrapper.INSTANCE.player().isOnLadder()) {
			return false;
		}
		if(Wrapper.INSTANCE.player().isInWater()) {
			return false;
		}
		if(Wrapper.INSTANCE.player().isInLava()) {
			return false;
		}
		if(Wrapper.INSTANCE.player().collidedHorizontally) {
			return false;
		}
		if(Wrapper.INSTANCE.player().moveForward < 0.1F) {
			return false;
		}
		if(Wrapper.INSTANCE.player().isSneaking()) {
			return false;
		}
		if(Wrapper.INSTANCE.player().getFoodStats().getFoodLevel() < 6) {
			return false;
		}
		if(Wrapper.INSTANCE.player().isRiding()) {
			return false;
		}
		if(Wrapper.INSTANCE.player().isPotionActive(MobEffects.BLINDNESS)) {
			return false;
		}
        return true;
    }
}
