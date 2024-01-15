package kn.jktech.anether.client.mixins;

import net.minecraft.src.game.block.BlockPortal;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(BlockPortal.PortalSize.class)
public interface PortalSizeAccessor {
    @Accessor("surface")
    int getSurface();
}
