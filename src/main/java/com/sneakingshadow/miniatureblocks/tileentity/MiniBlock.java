package com.sneakingshadow.miniatureblocks.tileentity;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;

class MiniBlock {

    private Block block = Blocks.air;

    MiniBlock() {}

    void setBlock(Block block) {
        this.block = block;
    }

    Block getBlock() {
        return block;
    }

}
