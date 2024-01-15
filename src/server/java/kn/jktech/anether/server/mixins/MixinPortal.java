package kn.jktech.anether.server.mixins;

import net.minecraft.src.game.block.Block;
import net.minecraft.src.game.block.BlockPortal;
import net.minecraft.src.game.block.Material;
import net.minecraft.src.game.level.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockPortal.class)
public class MixinPortal extends Block {
    protected MixinPortal(int id, Material material) {
        super(id, material);
    }


    /***/
    @Inject(method = "tryToCreatePortal",at=@At(value = "HEAD",target = "Lnet/minecraft/src/game/block/BlockPortal;tryToCreatePortal()Z"), cancellable = true)
    public void tryToCreatePortalmixin(World world, int x, int y, int z, CallbackInfoReturnable<Boolean> cir) {
        System.out.println("!!! anether !!! creating portal...");
        BlockPortal.PortalSize ns = new BlockPortal.PortalSize(world, x, y, z, 1);
        BlockPortal.PortalSize ew = new BlockPortal.PortalSize(world, x, y, z, 2);
        if (ns.isPortalSizeValid() && ((PortalSizeAccessor)ns).getSurface() == 0) {
            ns.makePortal();
            cir.setReturnValue(true);
            return;
        } else if (ew.isPortalSizeValid() && ((PortalSizeAccessor)ew).getSurface() == 0) {
            ew.makePortal();
            cir.setReturnValue(true);
            return;
        } else {
            cir.setReturnValue(false);
            return;
        }
    }
}
