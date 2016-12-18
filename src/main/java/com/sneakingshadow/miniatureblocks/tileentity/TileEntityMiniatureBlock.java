package com.sneakingshadow.miniatureblocks.tileentity;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by SneakingShadow on 21.11.2016.
 */
public class TileEntityMiniatureBlock extends TileEntity {

    private MiniBlock[][][] miniBlocks = new MiniBlock[16][16][16];

    public TileEntityMiniatureBlock() {
        for (int x = 0; x < 16; x++)
            for (int y = 0; y < 16; y++)
                for (int z = 0; z < 16; z++)
                    miniBlocks[x][y][z] = new MiniBlock();

    }

    /**
     * returns Blocks.air as default
     * */
    public Block getBlock(int x, int y, int z) {
        if (inBounds(x,y,z)) {
            return miniBlocks[x][y][z].getBlock();
        } else {
            return Blocks.air;
        }
    }

    public void setBlock(Block block, int x, int y, int z) {
        MiniBlock miniBlock = new MiniBlock();

        miniBlock.setBlock(block);

        if (inBounds(x,y,z)) {
            miniBlocks[x][y][z] = miniBlock;
            markDirty();
        } else {

        }
    }

    private boolean inBounds(int x, int y, int z) {
        return x < 16 && y < 16 && z < 16;
    }


    private void writeBlockToNBT(NBTTagCompound nbtTagCompound, int x, int y, int z)
    {
        MiniBlock miniBlock = miniBlocks[x][y][z];

        Block block = miniBlock.getBlock();
        int id = -1;

        if (block != Blocks.air) {
            id = Block.getIdFromBlock(block);
        }

        nbtTagCompound.setInteger("id", id);
    }

    private void readBlockFromNBT(NBTTagCompound nbtTagCompound, int x, int y, int z)
    {
        MiniBlock miniBlock = new MiniBlock();

        int id = nbtTagCompound.getInteger("id");
        if (id >= 0) {
            miniBlock.setBlock(Block.getBlockById(id));
        }

        miniBlocks[x][y][z] = miniBlock;
    }

    public void readFromNBT(NBTTagCompound nbtTagCompound)
    {
        super.readFromNBT(nbtTagCompound);
        NBTTagCompound blocksTagCompound = nbtTagCompound.getCompoundTag("blocks");

        for (int x = 0; x < 16; x++)
            for (int y = 0; y < 16; y++)
                for (int z = 0; z < 16; z++)
                    readBlockFromNBT(blocksTagCompound.getCompoundTag(getTag(x,y,z)), x, y, z);
    }

    public void writeToNBT(NBTTagCompound nbtTagCompound)
    {
        super.writeToNBT(nbtTagCompound);
        NBTTagCompound blocksTagCompound = new NBTTagCompound();

        for (int x = 0; x < 16; x++) {
            for (int y = 0; y < 16; y++) {
                for (int z = 0; z < 16; z++) {
                    NBTTagCompound blockTagCompound = new NBTTagCompound();
                    writeBlockToNBT(blockTagCompound, x, y, z);
                    blocksTagCompound.setTag(getTag(x,y,z), blockTagCompound);
                }
            }
        }

        nbtTagCompound.setTag("blocks", blocksTagCompound);
    }

    private static String getTag(int x, int y, int z) {
        return x + "." + y + "." + z;
    }

}
