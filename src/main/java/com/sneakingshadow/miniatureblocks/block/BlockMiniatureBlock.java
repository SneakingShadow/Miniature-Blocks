package com.sneakingshadow.miniatureblocks.block;

import com.sneakingshadow.miniatureblocks.reference.Ref;
import com.sneakingshadow.miniatureblocks.tileentity.TileEntityMiniatureBlock;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.event.ForgeEventFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by SneakingShadow on 21.11.2016.
 */
public class BlockMiniatureBlock extends BlockContainer {

    public BlockMiniatureBlock() {
        super(Material.ground);
        this.setBlockName(Ref.MOD_ID + ":" + "miniature_block");
    }

    /**
     * Returns a new instance of a block's tile entity class. Called on placing the block.
     *
     * @param world
     * @param metadata
     */
    @Override
    public TileEntity createNewTileEntity(World world, int metadata) {
        return new TileEntityMiniatureBlock();
    }

    /**
     * How many world ticks before ticking
     */
    public int tickRate(World world)
    {
        return 1;
    }

    public void breakBlock(World world, int x, int y, int z, Block block, int metadata)
    {
        if (hasTileEntity(metadata) && !(this instanceof BlockContainer))
        {
            world.removeTileEntity(x, y, z);
        }
    }

    public Item getItemDropped(int metadata, Random random, int fortune)
    {
        return null;
    }

    /**
     * Drops the block items with a specified chance of dropping the specified items
     */
    public void dropBlockAsItemWithChance(World p_149690_1_, int p_149690_2_, int p_149690_3_, int p_149690_4_, int p_149690_5_, float p_149690_6_, int p_149690_7_) {

    }

    /**
     * Spawns EntityItem in the world for the given ItemStack if the world is not remote.
     */
    public void dropBlockAsItem(World p_149642_1_, int p_149642_2_, int p_149642_3_, int p_149642_4_, ItemStack p_149642_5_) {

    }

    /**
     * Gets the hardness of block at the given coordinates in the given world, relative to the ability of the given
     * EntityPlayer.
     */
    public float getPlayerRelativeBlockHardness(EntityPlayer entityPlayer, World world, int x, int y, int z)
    {
        return ForgeHooks.blockStrength(this, entityPlayer, world, x, y, z);
    }

    /**
     * called by spawner, ore, redstoneOre blocks
     */
    public void dropXpOnBlockBreak(World world, int x, int y, int z, int exp_to_drop)
    {

    }

    /**
     * Returns how much this block can resist explosions from the passed in entity.
     */
    public float getExplosionResistance(Entity entity)
    {
        return this.blockResistance / 5.0F;
    }

    /**
     * Called upon the block being destroyed by an explosion
     */
    public void onBlockDestroyedByExplosion(World world, int z, int y, int x, Explosion explosion) {}

    /**
     * Returns which pass should this block be rendered on. 0 for solids and 1 for alpha
     */
    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass()
    {
        return 1;
    }

    /**
     * Called upon block activation (right click on the block.)
     */
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityPlayer, int side, float hitX, float hitY, float hitZ)
    {
        TileEntityMiniatureBlock tileEntity = (TileEntityMiniatureBlock) world.getTileEntity(x,y,z);
        String s = "";
        for (int ix = 0; ix < 16; ix++) {
            for (int iz = 0; iz < 16; iz++) {
                if (tileEntity.getBlock(ix,0,iz) == Blocks.cobblestone) {
                    s += "c";
                } else {
                    s += " ";
                }
            }
            s += "\n";
        }

        System.out.println(hitX);
        System.out.println(hitY);
        System.out.println(hitZ);

        return false;
    }



    /*
     * Adds all intersecting collision boxes to a list. (Be sure to only add boxes to the list if they intersect the
     * mask.) Parameters: World, X, Y, Z, mask, list, colliding entity
     *//*
    @Override
    public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB mask, List list, Entity entity)
    {
        TileEntityMiniatureBlock tileEntityMiniatureBlock;
        {
            TileEntity tileEntity = world.getTileEntity(x, y, z);
            if (tileEntity == null || !(tileEntity instanceof TileEntityMiniatureBlock)) {
                return;
            }
            tileEntityMiniatureBlock = (TileEntityMiniatureBlock) tileEntity;
        }

        for (int ix = 0; ix < 16; ix++) {
            for (int iy = 0; iy < 16; iy++) {
                for (int iz = 0; iz < 16; iz++) {
                    Block block = tileEntityMiniatureBlock.getBlock(x,y,z);
                    AxisAlignedBB axisAlignedBB1 = this.getMiniBlockBoundingBox(x,y,z,ix,iy,iz);

                    if (block != Blocks.air && mask.intersectsWith(axisAlignedBB1))
                    {
                        list.add(axisAlignedBB1);
                    }
                }
            }
        }
    }*/

    /*
    public AxisAlignedBB getMiniBlockBoundingBox(int x, int y, int z, int blockX, int blockY, int blockZ)
    {
        double minX = (double)x + blockX * 0.0625d;
        double minY = (double)y + blockY * 0.0625d;
        double minZ = (double)z + blockZ * 0.0625d;
        return AxisAlignedBB.getBoundingBox(minX, minY, minZ, minX+0.0625d, minY+0.0625d, minZ+0.0625d);
    }
    */

    /*
     * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
     * cleared to be reused)
     *//*
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
    {
        return AxisAlignedBB.getBoundingBox((double)x + this.minX, (double)y + this.minY, (double)z + this.minZ, (double)x + this.maxX, (double)y + this.maxY, (double)z + this.maxZ);
    }*/

    /*
     * Returns the bounding box of the wired rectangular prism to render.
     *//*
    @SideOnly(Side.CLIENT)
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int x, int y, int z)
    {
        return AxisAlignedBB.getBoundingBox((double)x + this.minX, (double)y + this.minY, (double)z + this.minZ, (double)x + this.maxX, (double)y + this.maxY, (double)z + this.maxZ);
    }*/

    /*
     * Ray traces through the blocks collision from start vector to end vector returning a ray trace hit. Args: world,
     * x, y, z, startVec, endVec
     *//*
    public MovingObjectPosition collisionRayTrace(World p_149731_1_, int p_149731_2_, int p_149731_3_, int p_149731_4_, Vec3 p_149731_5_, Vec3 p_149731_6_)
    {
        this.setBlockBoundsBasedOnState(p_149731_1_, p_149731_2_, p_149731_3_, p_149731_4_);
        p_149731_5_ = p_149731_5_.addVector((double)(-p_149731_2_), (double)(-p_149731_3_), (double)(-p_149731_4_));
        p_149731_6_ = p_149731_6_.addVector((double)(-p_149731_2_), (double)(-p_149731_3_), (double)(-p_149731_4_));
        Vec3 vec32 = p_149731_5_.getIntermediateWithXValue(p_149731_6_, this.minX);
        Vec3 vec33 = p_149731_5_.getIntermediateWithXValue(p_149731_6_, this.maxX);
        Vec3 vec34 = p_149731_5_.getIntermediateWithYValue(p_149731_6_, this.minY);
        Vec3 vec35 = p_149731_5_.getIntermediateWithYValue(p_149731_6_, this.maxY);
        Vec3 vec36 = p_149731_5_.getIntermediateWithZValue(p_149731_6_, this.minZ);
        Vec3 vec37 = p_149731_5_.getIntermediateWithZValue(p_149731_6_, this.maxZ);

        if (!this.isVecInsideYZBounds(vec32))
        {
            vec32 = null;
        }

        if (!this.isVecInsideYZBounds(vec33))
        {
            vec33 = null;
        }

        if (!this.isVecInsideXZBounds(vec34))
        {
            vec34 = null;
        }

        if (!this.isVecInsideXZBounds(vec35))
        {
            vec35 = null;
        }

        if (!this.isVecInsideXYBounds(vec36))
        {
            vec36 = null;
        }

        if (!this.isVecInsideXYBounds(vec37))
        {
            vec37 = null;
        }

        Vec3 vec38 = null;

        if (vec32 != null && (vec38 == null || p_149731_5_.squareDistanceTo(vec32) < p_149731_5_.squareDistanceTo(vec38)))
        {
            vec38 = vec32;
        }

        if (vec33 != null && (vec38 == null || p_149731_5_.squareDistanceTo(vec33) < p_149731_5_.squareDistanceTo(vec38)))
        {
            vec38 = vec33;
        }

        if (vec34 != null && (vec38 == null || p_149731_5_.squareDistanceTo(vec34) < p_149731_5_.squareDistanceTo(vec38)))
        {
            vec38 = vec34;
        }

        if (vec35 != null && (vec38 == null || p_149731_5_.squareDistanceTo(vec35) < p_149731_5_.squareDistanceTo(vec38)))
        {
            vec38 = vec35;
        }

        if (vec36 != null && (vec38 == null || p_149731_5_.squareDistanceTo(vec36) < p_149731_5_.squareDistanceTo(vec38)))
        {
            vec38 = vec36;
        }

        if (vec37 != null && (vec38 == null || p_149731_5_.squareDistanceTo(vec37) < p_149731_5_.squareDistanceTo(vec38)))
        {
            vec38 = vec37;
        }

        if (vec38 == null)
        {
            return null;
        }
        else
        {
            byte b0 = -1;

            if (vec38 == vec32)
            {
                b0 = 4;
            }

            if (vec38 == vec33)
            {
                b0 = 5;
            }

            if (vec38 == vec34)
            {
                b0 = 0;
            }

            if (vec38 == vec35)
            {
                b0 = 1;
            }

            if (vec38 == vec36)
            {
                b0 = 2;
            }

            if (vec38 == vec37)
            {
                b0 = 3;
            }

            return new MovingObjectPosition(p_149731_2_, p_149731_3_, p_149731_4_, b0, vec38.addVector((double)p_149731_2_, (double)p_149731_3_, (double)p_149731_4_));
        }
    }*/

    /*
     * Checks if a vector is within the Y and Z bounds of the block.
     *//*
    private boolean isVecInsideYZBounds(Vec3 p_149654_1_)
    {
        return p_149654_1_ == null ? false : p_149654_1_.yCoord >= this.minY && p_149654_1_.yCoord <= this.maxY && p_149654_1_.zCoord >= this.minZ && p_149654_1_.zCoord <= this.maxZ;
    }*/

    /*
     * Checks if a vector is within the X and Z bounds of the block.
     *//*
    private boolean isVecInsideXZBounds(Vec3 p_149687_1_)
    {
        return p_149687_1_ == null ? false : p_149687_1_.xCoord >= this.minX && p_149687_1_.xCoord <= this.maxX && p_149687_1_.zCoord >= this.minZ && p_149687_1_.zCoord <= this.maxZ;
    }*/

    /*
     * Checks if a vector is within the X and Y bounds of the block.
     *//*
    private boolean isVecInsideXYBounds(Vec3 vector)
    {
        return vector == null ? false : vector.xCoord >= this.minX && vector.xCoord <= this.maxX && vector.yCoord >= this.minY && vector.yCoord <= this.maxY;
    }*/

    /*
     * Updates the blocks bounds based on its current state. Args: world, x, y, z
     *//*
    public void setBlockBoundsBasedOnState(IBlockAccess blockAccess, int x, int y, int z) {

    }*/

    /*
     * Return true if the block is a normal, solid cube.  This
     * determines indirect power state, entity ejection from blocks, and a few
     * others.
     *
     * @param world The current world
     * @param x X Position
     * @param y Y position
     * @param z Z position
     * @return True if the block is a full cube
     *//*
    public boolean isNormalCube(IBlockAccess world, int x, int y, int z)
    {
        return getMaterial().isOpaque() && renderAsNormalBlock() && !canProvidePower();
    }*/

    /*
     * Checks if the block is a solid face on the given side, used by placement logic.
     *
     * @param world The current world
     * @param x X Position
     * @param y Y position
     * @param z Z position
     * @param side The side to check
     * @return True if the block is solid on the specified side.
     */
    /*public boolean isSideSolid(IBlockAccess world, int x, int y, int z, ForgeDirection side)
    {
        int meta = world.getBlockMetadata(x, y, z);

        if (this instanceof BlockSlab)
        {
            return (((meta & 8) == 8 && (side == UP)) || func_149730_j());
        }
        else if (this instanceof BlockFarmland)
        {
            return (side != DOWN && side != UP);
        }
        else if (this instanceof BlockStairs)
        {
            boolean flipped = ((meta & 4) != 0);
            return ((meta & 3) + side.ordinal() == 5) || (side == UP && flipped);
        }
        else if (this instanceof BlockSnow)
        {
            return (meta & 7) == 7;
        }
        else if (this instanceof BlockHopper && side == UP)
        {
            return true;
        }
        else if (this instanceof BlockCompressedPowered)
        {
            return true;
        }
        return isNormalCube(world, x, y, z);
    }*/

    /*
     * Determines if a new block can be replace the space occupied by this one,
     * Used in the player's placement code to make the block act like water, and lava.
     *
     * @param world The current world
     * @param x X Position
     * @param y Y position
     * @param z Z position
     * @return True if the block is replaceable by another block
     *//*
    public boolean isReplaceable(IBlockAccess world, int x, int y, int z)
    {
        return blockMaterial.isReplaceable();
    }
    */

    /*
     * Determines this block should be treated as an air block
     * by the rest of the code. This method is primarily
     * useful for creating pure logic-blocks that will be invisible
     * to the player and otherwise interact as air would.
     *
     * @param world The current world
     * @param x X Position
     * @param y Y position
     * @param z Z position
     * @return True if the block considered air
     *//*
    public boolean isAir(IBlockAccess world, int x, int y, int z)
    {
        return getMaterial() == Material.air;
    }
    */

    /*
     * Determines if the player can harvest this block, obtaining it's drops when the block is destroyed.
     *
     * @param player The player damaging the block, may be null
     * @param meta The block's current metadata
     * @return True to spawn the drops
     *//*
    public boolean canHarvestBlock(EntityPlayer player, int meta)
    {
        return ForgeHooks.canHarvestBlock(this, player, meta);
    }
    */

    /*
     * Called when a player removes a block.  This is responsible for
     * actually destroying the block, and the block is intact at time of call.
     * This is called regardless of whether the player can harvest the block or
     * not.
     *
     * Return true if the block is actually destroyed.
     *
     * Note: When used in multiplayer, this is called on both client and
     * server sides!
     *
     * @param world The current world
     * @param player The player damaging the block, may be null
     * @param x X Position
     * @param y Y position
     * @param z Z position
     * @param willHarvest True if Block.harvestBlock will be called after this, if the return in true.
     *        Can be useful to delay the destruction of tile entities till after harvestBlock
     * @return True if the block is actually destroyed.
     *//*
    public boolean removedByPlayer(World world, EntityPlayer player, int x, int y, int z, boolean willHarvest)
    {
        return removedByPlayer(world, player, x, y, z);
    }
    */

    /*
     * Chance that fire will spread and consume this block.
     * 300 being a 100% chance, 0, being a 0% chance.
     *
     * @param world The current world
     * @param x The blocks X position
     * @param y The blocks Y position
     * @param z The blocks Z position
     * @param face The face that the fire is coming from
     * @return A number ranging from 0 to 300 relating used to determine if the block will be consumed by fire
     *//*
    public int getFlammability(IBlockAccess world, int x, int y, int z, ForgeDirection face)
    {
        return Blocks.fire.getFlammability(this);
    }
    */

    /*
     * Returns true if the given side of this block type should be rendered, if the adjacent block is at the given
     * coordinates.  Args: blockAccess, x, y, z, side
     *//*
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess p_149646_1_, int p_149646_2_, int p_149646_3_, int p_149646_4_, int p_149646_5_)
    {
        return p_149646_5_ == 0 && this.minY > 0.0D ? true : (p_149646_5_ == 1 && this.maxY < 1.0D ? true : (p_149646_5_ == 2 && this.minZ > 0.0D ? true : (p_149646_5_ == 3 && this.maxZ < 1.0D ? true : (p_149646_5_ == 4 && this.minX > 0.0D ? true : (p_149646_5_ == 5 && this.maxX < 1.0D ? true : !p_149646_1_.getBlock(p_149646_2_, p_149646_3_, p_149646_4_).isOpaqueCube())))));
    }
    */

}
