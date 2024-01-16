package kn.jktech.anether.client.mixins;

import net.minecraft.src.game.MathHelper;
import net.minecraft.src.game.block.Block;
import net.minecraft.src.game.entity.Entity;
import net.minecraft.src.game.entity.player.EntityPlayer;
import net.minecraft.src.game.level.NetherPortalHandler;
import net.minecraft.src.game.level.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import static kn.jktech.anether.Anether.log;


@Mixin(NetherPortalHandler.class)
public class MixinPortalHandler {
    /**
     * @author kinnie
     * @reason patching portal workings
     */
    @Overwrite
    public void teleportEntity(World world, Entity entity) {
        boolean portalexists=false;
        if (!((NetherPortalHandler)(Object)this).useExistingPortal(world, entity)) {
            if(entity.posY>120){if (((EntityPlayer)entity).dimension==-1){
                entity.setPosition(entity.posX,121,entity.posZ);
            }
            else{
                log("back to the world");
                portalexists=findPortal(world,entity);
            }}
            if (!portalexists){((NetherPortalHandler)(Object)this).makeNewPortal(world, entity);}
            ((NetherPortalHandler)(Object)this).useExistingPortal(world, entity);
        }
    }
    public boolean findPortal(World world,Entity entity){
        int xpos = MathHelper.floor_double(entity.posX);
        int zpos = MathHelper.floor_double(entity.posZ);
        int id = Block.portal.blockID;

        for (int i=0;i<600;i++){
            for (int x=-16;x<=16;x++){for(int z=-16;z<=16;z++){
                if(world.getBlockId((xpos)+x,121+i,(zpos)+z)==id){
                    entity.setPosition((entity.posX)+x,121+i,(entity.posZ)+z);
                    return true;
                }
            }
            }

        }
        return false;
    }


}
