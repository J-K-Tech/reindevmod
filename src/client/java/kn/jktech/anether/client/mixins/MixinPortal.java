package kn.jktech.anether.client.mixins;

import net.minecraft.src.game.block.Block;
import net.minecraft.src.game.block.BlockPortal;
import net.minecraft.src.game.block.Material;
import net.minecraft.src.game.level.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(BlockPortal.class)
public class MixinPortal extends Block {
    protected MixinPortal(int id, Material material) {
        super(id, material);
    }


    /***/
    @Overwrite
    public boolean tryToCreatePortal(World world, int x, int y, int z) {
        System.out.println("!!! anether !!! creating portal...");
            BlockPortal.PortalSize ns = new BlockPortal.PortalSize(world, x, y, z, 1);
            BlockPortal.PortalSize ew = new BlockPortal.PortalSize(world, x, y, z, 2);
            if (ns.isPortalSizeValid() && ((PortalSizeAccessor)ns).getSurface() == 0) {
                ns.makePortal();
                return true;
            } else if (ew.isPortalSizeValid() && ((PortalSizeAccessor)ew).getSurface() == 0) {
                ew.makePortal();
                return true;
            } else {
                return false;
            }
        }
}
