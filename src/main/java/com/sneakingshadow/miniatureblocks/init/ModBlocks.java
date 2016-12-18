package com.sneakingshadow.miniatureblocks.init;

import com.sneakingshadow.miniatureblocks.block.BlockMiniatureBlock;
import com.sneakingshadow.miniatureblocks.tileentity.TileEntityMiniatureBlock;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by SneakingShadow on 21.11.2016.
 */
public class ModBlocks {

    public static final Block MiniatureBlock = new BlockMiniatureBlock();

    public static void init() {
        registerBlock(MiniatureBlock);

        tileEntities();
    }

    private static void tileEntities() {
        registerTile(TileEntityMiniatureBlock.class, MiniatureBlock);
    }

    private static void registerBlock(Block block){
        GameRegistry.registerBlock(block, "block_" + block.getUnlocalizedName().substring( block.getUnlocalizedName().indexOf(':')+1 ));
    }

    private static void registerTile(Class<? extends TileEntity> clazz, Block block){
        GameRegistry.registerTileEntity(clazz, "tile_" + block.getUnlocalizedName().substring( block.getUnlocalizedName().indexOf(':')+1 ));
    }

}
