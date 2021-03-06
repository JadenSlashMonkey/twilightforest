package twilightforest.structures.minotaurmaze;

import net.minecraft.init.Blocks;
import net.minecraft.world.gen.structure.StructureComponent;
import twilightforest.block.BlockTFMazestone;
import twilightforest.block.TFBlocks;

import java.util.Random;

import static twilightforest.enums.MazestoneVariant.BRICK;
import static twilightforest.enums.MazestoneVariant.CRACKED;
import static twilightforest.enums.MazestoneVariant.MOSSY;

public class StructureTFMazeStones extends StructureComponent.BlockSelector {

	@Override
	public void selectBlocks(Random random, int x, int y, int z, boolean wall) {
		if (!wall) {
			this.blockstate = Blocks.AIR.getDefaultState();
		} else {
			this.blockstate = TFBlocks.maze_stone.getDefaultState();
			float rf = random.nextFloat();

			if (rf < 0.2F) {
				this.blockstate = blockstate.withProperty(BlockTFMazestone.VARIANT, MOSSY);
			} else if (rf < 0.5F) {
				this.blockstate = blockstate.withProperty(BlockTFMazestone.VARIANT, CRACKED);
			} else {
				this.blockstate = blockstate.withProperty(BlockTFMazestone.VARIANT, BRICK);
			}
		}
	}

}
