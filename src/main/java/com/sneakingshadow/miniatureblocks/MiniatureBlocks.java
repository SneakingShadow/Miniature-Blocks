package com.sneakingshadow.miniatureblocks;

import com.sneakingshadow.miniatureblocks.Reference.Ref;
import com.sneakingshadow.miniatureblocks.proxy.IProxy;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;

@Mod(modid = Ref.MOD_ID, name = Ref.MOD_NAME, version = Ref.VERSION)
public class MiniatureBlocks
{
    @Mod.Instance(Ref.MOD_ID)
    public static MiniatureBlocks instance;

    @SidedProxy(clientSide = Ref.CLIENT_PROXY_CLASS, serverSide = Ref.SERVER_PROXY_CLASS)
    public static IProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {

    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {

    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {

    }

}





/*

        ISaveHandler fakeSaveHandler = new ISaveHandler() {
            @Override
            public WorldInfo loadWorldInfo() {
                return null;
            }

            @Override
            public void checkSessionLock() throws MinecraftException {

            }

            @Override
            public IChunkLoader getChunkLoader(WorldProvider p_75763_1_) {
                return null;
            }

            @Override
            public void saveWorldInfoWithPlayer(WorldInfo p_75755_1_, NBTTagCompound p_75755_2_) {

            }

            @Override
            public void saveWorldInfo(WorldInfo p_75761_1_) {

            }

            @Override
            public IPlayerFileData getSaveHandler() {
                return null;
            }

            @Override
            public void flush() {

            }

            @Override
            public File getWorldDirectory() {
                return null;
            }

            @Override
            public File getMapFileFromName(String p_75758_1_) {
                return null;
            }

            @Override
            public String getWorldDirectoryName() {
                return null;
            }
        };

        WorldSettings fakeWorldSettings = new WorldSettings(world.getWorldInfo());

        World fakeWorld = new World(fakeSaveHandler, (String) "", fakeWorldSettings, (WorldProvider) null, (Profiler) null) {
            @Override
            protected IChunkProvider createChunkProvider() {
                return null;
            }

            @Override
            protected int func_152379_p() {
                return 0;
            }

            @Override
            public Entity getEntityByID(int p_73045_1_) {
                return null;
            }
        };

        fakeWorld.getBlock(x,y,z);
        fakeWorld.setBlock(x,y+1,z, Blocks.cobblestone);

*/
