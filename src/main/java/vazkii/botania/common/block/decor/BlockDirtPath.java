/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Botania Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Botania
 * 
 * Botania is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * 
 * File Created @ [Jan 18, 2015, 1:47:03 AM (GMT)]
 */
package vazkii.botania.common.block.decor;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;
import vazkii.botania.common.block.BlockMod;
import vazkii.botania.common.lib.LibBlockNames;

public class BlockDirtPath extends BlockMod {

	public BlockDirtPath() {
		super(Material.ground);
		setBlockBounds(0F, 0F, 0F, 1F, 15F / 16F, 1F);
		setLightOpacity(255);
		setHardness(0.6F);
		setStepSound(soundTypeGravel);
		setBlockName(LibBlockNames.DIRT_PATH);
		useNeighborBrightness = true;
	}

	@Override
	public void onEntityWalking(World world, int x, int y, int z, Entity entity) {
		float speed = 2F;
		float max = 0.4F;

		double motionX = Math.abs(entity.motionX);
        double motionZ = Math.abs(entity.motionZ);
        if(motionX < max)
            entity.motionX *= speed;
        if(motionZ < max)
            entity.motionZ *= speed;
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
		return AxisAlignedBB.getBoundingBox(x, y, z, x + 1, y + 1, z + 1);
	}
	
	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	
	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}
	
	@Override
	public boolean canSustainPlant(IBlockAccess world, int x, int y, int z, ForgeDirection direction, IPlantable plantable) {
		return plantable.getPlantType(world, x, y - 1, z) == EnumPlantType.Plains;
	}
	
}